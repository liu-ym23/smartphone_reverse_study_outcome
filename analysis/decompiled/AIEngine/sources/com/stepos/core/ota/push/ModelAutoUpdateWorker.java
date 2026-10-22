package com.stepos.core.ota.push;

import android.content.Context;
import androidx.work.CoroutineWorker;
import androidx.work.WorkerParameters;
import androidx.work.c;
import com.stepos.core.common.log.AIEngineLogger;
import com.stepos.core.common.log.LogModule;
import com.stepos.core.cta.CTAPermissionManager;
import com.stepos.core.ota.d;
import kotlin.Result;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.g;
import qb.b;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class ModelAutoUpdateWorker extends CoroutineWorker {
    public static final Companion Companion = new Companion(null);
    public static final String KEY_REASON = "reason";
    private static final String TAG = "ModelAutoUpdateWorker";

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class Companion {
        public /* synthetic */ Companion(e eVar) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ModelAutoUpdateWorker(Context context, WorkerParameters params) {
        super(context, params);
        g.f(context, "context");
        g.f(params, "params");
    }

    private final void diag(String str) {
        h0.e.k("[DIAG] ", str, LogModule.OTA, TAG);
    }

    @Override // androidx.work.CoroutineWorker
    public Object doWork(b<? super c.a> bVar) {
        Object objA;
        Object obj = getInputData().f2769a.get(KEY_REASON);
        String str = obj instanceof String ? (String) obj : null;
        if (str == null) {
            str = "periodic";
        }
        try {
            objA = Boolean.valueOf(PendingAutoUpdateStore.INSTANCE.hasNewDownloadPending());
        } catch (Throwable th) {
            objA = kotlin.c.a(th);
        }
        Object obj2 = Boolean.FALSE;
        if (objA instanceof Result.Failure) {
            objA = obj2;
        }
        boolean zBooleanValue = ((Boolean) objA).booleanValue();
        CTAPermissionManager cTAPermissionManager = CTAPermissionManager.INSTANCE;
        if (cTAPermissionManager.hasCTAPermission() && (cTAPermissionManager.isWlanAutoUpgradeEnabled() || zBooleanValue)) {
            AIEngineLogger.i(LogModule.OTA, TAG, "wake reason=".concat(str));
            boolean zHasCTAPermission = cTAPermissionManager.hasCTAPermission();
            boolean zIsWlanAutoUpgradeEnabled = cTAPermissionManager.isWlanAutoUpgradeEnabled();
            StringBuilder sbM = d.m("worker wake reason=", str, " cta=", " wifiAuto=", zHasCTAPermission);
            sbM.append(zIsWlanAutoUpgradeEnabled);
            sbM.append(" hasNewDownload=");
            sbM.append(zBooleanValue);
            diag(sbM.toString());
            ModelAutoUpdateManager.INSTANCE.onPeriodicWake(str);
            return new c.a.C0023c();
        }
        AIEngineLogger.i(LogModule.OTA, TAG, "skip: no CTA / switch off & no new download (reason=" + str + ")");
        boolean zHasCTAPermission2 = cTAPermissionManager.hasCTAPermission();
        boolean zIsWlanAutoUpgradeEnabled2 = cTAPermissionManager.isWlanAutoUpgradeEnabled();
        StringBuilder sbM2 = d.m("worker skip reason=", str, " cta=", " wifiAuto=", zHasCTAPermission2);
        sbM2.append(zIsWlanAutoUpgradeEnabled2);
        sbM2.append(" hasNewDownload=");
        sbM2.append(zBooleanValue);
        diag(sbM2.toString());
        return new c.a.C0023c();
    }
}
