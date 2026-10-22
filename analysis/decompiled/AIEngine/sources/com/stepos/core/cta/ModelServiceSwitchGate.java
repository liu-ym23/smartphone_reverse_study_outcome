package com.stepos.core.cta;

import android.content.ContentResolver;
import android.content.Context;
import android.database.ContentObserver;
import android.os.Handler;
import android.os.Looper;
import android.provider.Settings;
import com.stepos.core.common.log.AIEngineLogger;
import com.stepos.core.common.log.LogModule;
import com.stepos.core.common.settings.AiEngineSystemSettings;
import com.stepos.core.common.settings.UserSetupState;
import kotlin.Result;
import kotlin.jvm.internal.g;
import lb.n;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class ModelServiceSwitchGate {
    public static final ModelServiceSwitchGate INSTANCE = new ModelServiceSwitchGate();
    private static final String TAG = "ModelServiceSwitchGate";

    private ModelServiceSwitchGate() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void handleChange(Context context) {
        Object objA;
        Object objA2;
        Object objA3;
        ContentResolver contentResolver = context.getContentResolver();
        try {
            objA = Settings.System.getString(contentResolver, AiEngineSystemSettings.KEY_MODEL_SERVICE_STATUS);
        } catch (Throwable th) {
            objA = kotlin.c.a(th);
        }
        if (objA instanceof Result.Failure) {
            objA = null;
        }
        String str = (String) objA;
        try {
            objA2 = Settings.System.getString(contentResolver, AiEngineSystemSettings.KEY_CTA_AGREE_STATUS);
        } catch (Throwable th2) {
            objA2 = kotlin.c.a(th2);
        }
        String str2 = (String) (objA2 instanceof Result.Failure ? null : objA2);
        boolean zIsSetupComplete = UserSetupState.INSTANCE.isSetupComplete(context);
        if (!shouldRequestCta$common_release(str, str2, zIsSetupComplete)) {
            LogModule logModule = LogModule.SERVICE;
            StringBuilder sbS = ai.onnxruntime.a.s("onChange: no action (svc=", str, " cta=", str2, " setupComplete=");
            sbS.append(zIsSetupComplete);
            sbS.append(")");
            AIEngineLogger.d(logModule, TAG, sbS.toString());
            return;
        }
        LogModule logModule2 = LogModule.SERVICE;
        StringBuilder sbS2 = ai.onnxruntime.a.s("onChange: CTA required (svc=", str, " cta=", str2, " setupComplete=");
        sbS2.append(zIsSetupComplete);
        sbS2.append(") → rollback svc + show policy");
        AIEngineLogger.i(logModule2, TAG, sbS2.toString());
        boolean modelServiceEnabled = AiEngineSystemSettings.INSTANCE.setModelServiceEnabled(context, false);
        if (!modelServiceEnabled) {
            AIEngineLogger.w(logModule2, TAG, "rollback svc=0 failed → svc stays 1 while CTA not agreed");
        }
        try {
            context.startActivity(CtaGateGuard.INSTANCE.createPolicyIntent(context).addFlags(268435456));
            objA3 = n.f10413a;
        } catch (Throwable th3) {
            objA3 = kotlin.c.a(th3);
        }
        if (!(objA3 instanceof Result.Failure)) {
            AIEngineLogger.i(LogModule.SERVICE, TAG, "PolicyActivity started (rollbackOk=" + modelServiceEnabled + ")");
        }
        Throwable thB = Result.b(objA3);
        if (thB != null) {
            AIEngineLogger.w(LogModule.SERVICE, TAG, "PolicyActivity start failed → svc rolled back to 0 with no CTA prompt shown: " + thB);
        }
    }

    public final void install(Context context) {
        Object objA;
        g.f(context, "context");
        final Context applicationContext = context.getApplicationContext();
        ContentResolver contentResolver = applicationContext.getContentResolver();
        final Handler handler = new Handler(Looper.getMainLooper());
        try {
            contentResolver.registerContentObserver(Settings.System.getUriFor(AiEngineSystemSettings.KEY_MODEL_SERVICE_STATUS), false, new ContentObserver(handler) { // from class: com.stepos.core.cta.ModelServiceSwitchGate$install$observer$1
                @Override // android.database.ContentObserver
                public void onChange(boolean z) {
                    if (z) {
                        AIEngineLogger.d(LogModule.SERVICE, "ModelServiceSwitchGate", "onChange: selfChange=true → skip");
                        return;
                    }
                    ModelServiceSwitchGate modelServiceSwitchGate = ModelServiceSwitchGate.INSTANCE;
                    Context context2 = applicationContext;
                    g.c(context2);
                    modelServiceSwitchGate.handleChange(context2);
                }
            });
            objA = n.f10413a;
        } catch (Throwable th) {
            objA = kotlin.c.a(th);
        }
        if (!(objA instanceof Result.Failure)) {
            AIEngineLogger.i(LogModule.SERVICE, TAG, "installed: observing ai_engine_model_service_status");
        }
        Throwable thB = Result.b(objA);
        if (thB != null) {
            AIEngineLogger.w(LogModule.SERVICE, TAG, "install failed → switch-linked CTA gate inactive: " + thB);
        }
    }

    public final boolean shouldRequestCta$common_release(String str, String str2, boolean z) {
        if (g.b(str, "1")) {
            return z ? !g.b(str2, "1") : g.b(str2, "0");
        }
        return false;
    }
}
