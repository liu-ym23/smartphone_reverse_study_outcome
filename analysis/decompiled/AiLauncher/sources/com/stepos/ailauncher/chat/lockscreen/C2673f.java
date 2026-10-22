package com.stepos.ailauncher.chat.lockscreen;

import android.app.Application;
import android.app.KeyguardManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.SystemClock;
import android.provider.Settings;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.chat.manager.AuthManager;
import com.stepos.ailauncher.chat.wake.Y;
import com.stepos.ailauncher.common.utils.C3197a;
import h8.C4148a;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.Result;
import p9.InterfaceC5063a;

@Metadata(d1 = {"\u0000A\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0004*\u0001\u001c\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\t\u0010\u0003J\u0017\u0010\n\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\n\u0010\bJ\u000f\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0011\u001a\u00020\u00108\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0013\u001a\u00020\u00108\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0013\u0010\u0012R\u0014\u0010\u0015\u001a\u00020\u00148\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0017\u001a\u00020\u00148\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0016R\u0014\u0010\u0018\u001a\u00020\u00108\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0018\u0010\u0012R\u0014\u0010\u001a\u001a\u00020\u00198\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0014\u0010\u001d\u001a\u00020\u001c8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001e¨\u0006\u001f"}, d2 = {"Lcom/stepos/ailauncher/chat/lockscreen/f;", "", "<init>", "()V", "Landroid/content/Context;", "context", "LY8/t;", Const.INTENT_KEY_BACKGROUND_COMMAND, "(Landroid/content/Context;)V", "f", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "", "e", "()Z", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "(Landroid/content/Context;)Z", "", "TAG", "Ljava/lang/String;", "USER_SETUP_COMPLETE", "Ljava/util/concurrent/atomic/AtomicBoolean;", "initialized", "Ljava/util/concurrent/atomic/AtomicBoolean;", "prompting", "ACTION_FIND_PHONE_UNLOCK", "Lcom/stepos/ailauncher/chat/lockscreen/l;", "findPhoneUnlockGate", "Lcom/stepos/ailauncher/chat/lockscreen/l;", "com/stepos/ailauncher/chat/lockscreen/f$a", "receiver", "Lcom/stepos/ailauncher/chat/lockscreen/f$a;", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.ailauncher.chat.lockscreen.f, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C2673f {
    private static final String ACTION_FIND_PHONE_UNLOCK = "com.stepos.action.FINDPHONE_UNLOCK";
    private static final String TAG = "AmooAuthMonitor";
    private static final String USER_SETUP_COMPLETE = "user_setup_complete";
    public static final C2673f INSTANCE = new C2673f();
    private static final AtomicBoolean initialized = new AtomicBoolean(false);
    private static final AtomicBoolean prompting = new AtomicBoolean(false);
    private static final C2679l findPhoneUnlockGate = new C2679l();
    private static final a receiver = new a();

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J#\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"com/stepos/ailauncher/chat/lockscreen/f$a", "Landroid/content/BroadcastReceiver;", "Landroid/content/Context;", "context", "Landroid/content/Intent;", "intent", "LY8/t;", "onReceive", "(Landroid/content/Context;Landroid/content/Intent;)V", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.ailauncher.chat.lockscreen.f$a */
    public static final class a extends BroadcastReceiver {
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            String action = intent != null ? intent.getAction() : null;
            if (action != null) {
                int iHashCode = action.hashCode();
                if (iHashCode == -2128145023) {
                    if (action.equals("android.intent.action.SCREEN_OFF")) {
                        C2673f.findPhoneUnlockGate.c();
                    }
                } else {
                    if (iHashCode != 137250837) {
                        if (iHashCode == 823795052 && action.equals("android.intent.action.USER_PRESENT")) {
                            C2673f.INSTANCE.f();
                            return;
                        }
                        return;
                    }
                    if (action.equals(C2673f.ACTION_FIND_PHONE_UNLOCK)) {
                        C2673f.findPhoneUnlockGate.b(SystemClock.elapsedRealtime());
                        C4148a.k(C2673f.TAG, "find phone unlocked, suppress this unlock auto prompt", false, 4, null);
                    }
                }
            }
        }
    }

    public static final Y8.t j(Context context, long j10) {
        prompting.set(false);
        C2673f c2673f = INSTANCE;
        if (!c2673f.h(context)) {
            C4148a.d(TAG, "OOBE incomplete after settle, skip unlock auto auth prompt", false, 4, null);
            return Y8.t.f7040a;
        }
        C2679l c2679l = findPhoneUnlockGate;
        if (c2679l.d(SystemClock.elapsedRealtime()) || j10 != c2679l.getGeneration()) {
            C4148a.k(TAG, "unlock auto prompt suppressed or superseded after settle, skip", false, 4, null);
            return Y8.t.f7040a;
        }
        if (c2673f.e()) {
            AuthManager authManager = AuthManager.INSTANCE;
            if (!authManager.w0()) {
                if (authManager.Y()) {
                    AuthManager.d0(authManager, context, null, 2, null);
                    return Y8.t.f7040a;
                }
                C4148a.d(TAG, "privacy not agreed after settle, skip unlock auto auth prompt", false, 4, null);
                return Y8.t.f7040a;
            }
        }
        C4148a.d(TAG, "agent auto prompt no longer allowed or auth showing after settle, skip", false, 4, null);
        return Y8.t.f7040a;
    }

    public static final Y8.t k() {
        prompting.set(false);
        C4148a.u(TAG, "unlock UI did not settle, skip auth prompt", false, 4, null);
        return Y8.t.f7040a;
    }

    public final boolean e() {
        AuthManager authManager = AuthManager.INSTANCE;
        return C2674g.b(authManager.U(), authManager.v0());
    }

    public final void f() {
        Application applicationA = C3197a.INSTANCE.a();
        if (!h(applicationA)) {
            C4148a.d(TAG, "OOBE incomplete, skip unlock auto auth prompt", false, 4, null);
            return;
        }
        if (findPhoneUnlockGate.d(SystemClock.elapsedRealtime())) {
            C4148a.k(TAG, "find phone unlock USER_PRESENT, skip auto auth prompt", false, 4, null);
            return;
        }
        if (!e()) {
            C4148a.d(TAG, "not logged in or agent choice already stored, skip unlock auto auth prompt", false, 4, null);
            return;
        }
        AuthManager authManager = AuthManager.INSTANCE;
        if (!authManager.Y()) {
            C4148a.d(TAG, "privacy not agreed, skip unlock auto auth prompt", false, 4, null);
            return;
        }
        if (com.stepos.ailauncher.chat.wake.F.INSTANCE.d() || authManager.w0()) {
            C4148a.d(TAG, "another auth prompt in flight, skip", false, 4, null);
            return;
        }
        Object systemService = applicationA.getSystemService("keyguard");
        KeyguardManager keyguardManager = systemService instanceof KeyguardManager ? (KeyguardManager) systemService : null;
        if (keyguardManager == null || !keyguardManager.isDeviceSecure()) {
            i(applicationA);
        } else {
            C4148a.d(TAG, "unlocked to desktop, skip lock-screen agent notice", false, 4, null);
        }
    }

    public final void g(Context context) {
        Object objB;
        kotlin.jvm.internal.p.i(context, "context");
        if (initialized.compareAndSet(false, true)) {
            Context applicationContext = context.getApplicationContext();
            Object systemService = applicationContext.getSystemService("keyguard");
            KeyguardManager keyguardManager = systemService instanceof KeyguardManager ? (KeyguardManager) systemService : null;
            C4148a.k(TAG, "init initialSecure=" + (keyguardManager != null ? Boolean.valueOf(keyguardManager.isDeviceSecure()) : null), false, 4, null);
            try {
                Result.Companion companion = Result.INSTANCE;
                a aVar = receiver;
                IntentFilter intentFilter = new IntentFilter("android.intent.action.USER_PRESENT");
                intentFilter.addAction(ACTION_FIND_PHONE_UNLOCK);
                intentFilter.addAction("android.intent.action.SCREEN_OFF");
                Y8.t tVar = Y8.t.f7040a;
                objB = Result.b(applicationContext.registerReceiver(aVar, intentFilter, "android.permission.WRITE_SECURE_SETTINGS", null, 2));
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                objB = Result.b(C4849c.a(th));
            }
            Throwable thE = Result.e(objB);
            if (thE != null) {
                initialized.set(false);
                C4148a.t(TAG, "register USER_PRESENT failed", thE, false, 8, null);
            }
        }
    }

    public final boolean h(Context context) {
        Object objB;
        try {
            Result.Companion companion = Result.INSTANCE;
            objB = Result.b(Boolean.valueOf(C2674g.a(Settings.Global.getInt(context.getContentResolver(), "device_provisioned", 0), Settings.Secure.getInt(context.getContentResolver(), USER_SETUP_COMPLETE, 0))));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        Throwable thE = Result.e(objB);
        if (thE != null) {
            C4148a.t(TAG, "read OOBE state failed, skip unlock auto auth prompt", thE, false, 8, null);
            objB = Boolean.FALSE;
        }
        return ((Boolean) objB).booleanValue();
    }

    public final void i(final Context context) {
        if (!prompting.compareAndSet(false, true)) {
            C4148a.d(TAG, "auth prompt already waiting, skip", false, 4, null);
        } else {
            final long generation = findPhoneUnlockGate.getGeneration();
            Y.INSTANCE.e(context, TAG, true, new InterfaceC5063a() { // from class: com.stepos.ailauncher.chat.lockscreen.d
                @Override // p9.InterfaceC5063a
                public final Object invoke() {
                    return C2673f.j(context, generation);
                }
            }, new InterfaceC5063a() { // from class: com.stepos.ailauncher.chat.lockscreen.e
                @Override // p9.InterfaceC5063a
                public final Object invoke() {
                    return C2673f.k();
                }
            });
        }
    }
}
