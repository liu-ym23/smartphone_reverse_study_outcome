package com.stepos.core.cta;

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
public final class CtaSwitchOwnershipGuard {
    public static final CtaSwitchOwnershipGuard INSTANCE = new CtaSwitchOwnershipGuard();
    private static final String TAG = "CtaSwitchOwnershipGuard";
    private static ContentObserver observer;

    private CtaSwitchOwnershipGuard() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onSetupComplete(Context context) {
        AiEngineSystemSettings.INSTANCE.takeOwnershipOfCtaSwitches(context);
        if (observer != null) {
            unregisterObserver(context);
            AIEngineLogger.i(LogModule.SERVICE, TAG, "setup complete → ownership taken, observer removed");
        }
    }

    private final void registerSetupObserver(final Context context) {
        Object objA;
        final Handler handler = new Handler(Looper.getMainLooper());
        ContentObserver contentObserver = new ContentObserver(handler) { // from class: com.stepos.core.cta.CtaSwitchOwnershipGuard$registerSetupObserver$obs$1
            @Override // android.database.ContentObserver
            public void onChange(boolean z) {
                if (UserSetupState.INSTANCE.isSetupComplete(context)) {
                    CtaSwitchOwnershipGuard.INSTANCE.onSetupComplete(context);
                } else {
                    AIEngineLogger.d(LogModule.SERVICE, "CtaSwitchOwnershipGuard", "setup marker changed but not complete → keep waiting");
                }
            }
        };
        try {
            context.getContentResolver().registerContentObserver(Settings.Secure.getUriFor(UserSetupState.KEY_USER_SETUP_COMPLETE), false, contentObserver);
            objA = n.f10413a;
        } catch (Throwable th) {
            objA = kotlin.c.a(th);
        }
        if (!(objA instanceof Result.Failure)) {
            observer = contentObserver;
            AIEngineLogger.i(LogModule.SERVICE, TAG, "setup in progress → observing user_setup_complete");
        }
        Throwable thB = Result.b(objA);
        if (thB != null) {
            AIEngineLogger.w(LogModule.SERVICE, TAG, "observe user_setup_complete failed → switches keep OOBE ownership: " + thB);
        }
    }

    private final void unregisterObserver(Context context) {
        ContentObserver contentObserver = observer;
        if (contentObserver != null) {
            try {
                context.getContentResolver().unregisterContentObserver(contentObserver);
                n nVar = n.f10413a;
            } catch (Throwable th) {
                kotlin.c.a(th);
            }
            observer = null;
        }
    }

    public final void install(Context context) {
        g.f(context, "context");
        Context applicationContext = context.getApplicationContext();
        g.c(applicationContext);
        unregisterObserver(applicationContext);
        AiEngineSystemSettings.INSTANCE.takeOwnershipOfCtaSwitches(applicationContext);
        UserSetupState userSetupState = UserSetupState.INSTANCE;
        if (userSetupState.isSetupComplete(applicationContext)) {
            AIEngineLogger.i(LogModule.SERVICE, TAG, "setup complete → ownership taken, observer not needed");
            return;
        }
        registerSetupObserver(applicationContext);
        if (userSetupState.isSetupComplete(applicationContext)) {
            onSetupComplete(applicationContext);
        }
    }
}
