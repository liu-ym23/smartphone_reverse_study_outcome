package com.stepos.stepclaw;

import a6.z;
import android.content.ContentResolver;
import android.content.Context;
import android.database.ContentObserver;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.provider.Settings;
import android.util.Log;
import b5.a0;
import b5.i;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import p5.l;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\t\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\t\u0010\bJ\u0017\u0010\n\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\n\u0010\bJ\u0015\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\u0004¢\u0006\u0004\b\r\u0010\u000eJ\u001d\u0010\u0011\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u0004H\u0000¢\u0006\u0004\b\u0013\u0010\bR\u0014\u0010\u0015\u001a\u00020\u000f8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0017\u001a\u00020\u000f8\u0000X\u0080T¢\u0006\u0006\n\u0004\b\u0017\u0010\u0016R.\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00060\u00188\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR*\u0010 \u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u001f8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u0018\u0010'\u001a\u0004\u0018\u00010&8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b'\u0010(¨\u0006)"}, d2 = {"Lcom/stepos/stepclaw/UserSetupCompletionGate;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "<init>", "()V", "Landroid/content/Context;", "appContext", "Lb5/a0;", "registerObserver", "(Landroid/content/Context;)V", "onUserSetupChanged", "unregisterObserver", "context", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "isUserSetupComplete", "(Landroid/content/Context;)Z", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "reason", "startGatewayWhenComplete", "(Landroid/content/Context;Ljava/lang/String;)Z", "resetForTest$app_release", "resetForTest", "TAG", "Ljava/lang/String;", "USER_SETUP_COMPLETE", "Lkotlin/Function1;", "gatewayStarter", "Lp5/l;", "getGatewayStarter$app_release", "()Lp5/l;", "setGatewayStarter$app_release", "(Lp5/l;)V", "Lkotlin/Function0;", "beforeObserverRegisteredForTest", "Lp5/a;", "getBeforeObserverRegisteredForTest$app_release", "()Lp5/a;", "setBeforeObserverRegisteredForTest$app_release", "(Lp5/a;)V", "Landroid/database/ContentObserver;", "observer", "Landroid/database/ContentObserver;", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes.dex */
public final class UserSetupCompletionGate {
    private static final String TAG = "UserSetupCompletionGate";
    public static final String USER_SETUP_COMPLETE = "user_setup_complete";
    private static p5.a beforeObserverRegisteredForTest;
    private static ContentObserver observer;
    public static final UserSetupCompletionGate INSTANCE = new UserSetupCompletionGate();
    private static l gatewayStarter = new z(9);

    private UserSetupCompletionGate() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final a0 gatewayStarter$lambda$0(Context it) {
        p.e(it, "it");
        GatewayForegroundService.INSTANCE.start(it);
        return a0.f883a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final synchronized void onUserSetupChanged(Context appContext) {
        if (isUserSetupComplete(appContext)) {
            unregisterObserver(appContext);
            Log.i(TAG, "USER_SETUP_COMPLETE changed to 1; starting GatewayForegroundService");
            gatewayStarter.invoke(appContext);
        }
    }

    private final void registerObserver(final Context appContext) {
        if (observer != null) {
            return;
        }
        Uri uriFor = Settings.Secure.getUriFor(USER_SETUP_COMPLETE);
        observer = new ContentObserver(new Handler(Looper.getMainLooper())) { // from class: com.stepos.stepclaw.UserSetupCompletionGate.registerObserver.1
            @Override // android.database.ContentObserver
            public void onChange(boolean selfChange) {
                UserSetupCompletionGate.INSTANCE.onUserSetupChanged(appContext);
            }

            @Override // android.database.ContentObserver
            public void onChange(boolean selfChange, Uri uri) {
                UserSetupCompletionGate.INSTANCE.onUserSetupChanged(appContext);
            }
        };
        ContentResolver contentResolver = appContext.getContentResolver();
        ContentObserver contentObserver = observer;
        p.b(contentObserver);
        contentResolver.registerContentObserver(uriFor, false, contentObserver);
        Log.i(TAG, "Registered USER_SETUP_COMPLETE observer");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final a0 resetForTest$lambda$0(Context it) {
        p.e(it, "it");
        GatewayForegroundService.INSTANCE.start(it);
        return a0.f883a;
    }

    private final void unregisterObserver(Context appContext) {
        Object objO;
        ContentObserver contentObserver = observer;
        if (contentObserver == null) {
            return;
        }
        try {
            appContext.getContentResolver().unregisterContentObserver(contentObserver);
            objO = a0.f883a;
        } catch (Throwable th) {
            objO = a.a.o(th);
        }
        Throwable thA = i.a(objO);
        if (thA != null) {
            Log.w(TAG, "Failed to unregister USER_SETUP_COMPLETE observer: " + thA.getMessage(), thA);
        }
        observer = null;
    }

    public final p5.a getBeforeObserverRegisteredForTest$app_release() {
        return beforeObserverRegisteredForTest;
    }

    public final l getGatewayStarter$app_release() {
        return gatewayStarter;
    }

    public final boolean isUserSetupComplete(Context context) {
        p.e(context, "context");
        return Settings.Secure.getInt(context.getContentResolver(), USER_SETUP_COMPLETE, 0) == 1;
    }

    public final synchronized void resetForTest$app_release(Context context) {
        p.e(context, "context");
        Context applicationContext = context.getApplicationContext();
        p.d(applicationContext, "getApplicationContext(...)");
        unregisterObserver(applicationContext);
        gatewayStarter = new z(8);
        beforeObserverRegisteredForTest = null;
    }

    public final void setBeforeObserverRegisteredForTest$app_release(p5.a aVar) {
        beforeObserverRegisteredForTest = aVar;
    }

    public final void setGatewayStarter$app_release(l lVar) {
        p.e(lVar, "<set-?>");
        gatewayStarter = lVar;
    }

    public final synchronized boolean startGatewayWhenComplete(Context context, String reason) {
        p.e(context, "context");
        p.e(reason, "reason");
        Context applicationContext = context.getApplicationContext();
        p.b(applicationContext);
        if (isUserSetupComplete(applicationContext)) {
            unregisterObserver(applicationContext);
            Log.i(TAG, "USER_SETUP_COMPLETE=1; starting GatewayForegroundService (reason=" + reason + ")");
            gatewayStarter.invoke(applicationContext);
            return true;
        }
        Log.i(TAG, "USER_SETUP_COMPLETE!=1; deferring GatewayForegroundService start (reason=" + reason + ")");
        p5.a aVar = beforeObserverRegisteredForTest;
        if (aVar != null) {
            aVar.invoke();
        }
        registerObserver(applicationContext);
        if (!isUserSetupComplete(applicationContext)) {
            return false;
        }
        unregisterObserver(applicationContext);
        Log.i(TAG, "USER_SETUP_COMPLETE=1 after observer registration; starting GatewayForegroundService (reason=" + reason + ")");
        gatewayStarter.invoke(applicationContext);
        return true;
    }
}
