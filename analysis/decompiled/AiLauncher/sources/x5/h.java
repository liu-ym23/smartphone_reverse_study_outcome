package x5;

import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.chat.manager.AuthManager;
import com.stepos.ailauncher.foundation.account.AccountInfo;
import com.stepos.ailauncher.foundation.account.i;
import h8.C4148a;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000I\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0016\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0004*\u0001&\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0003J\u0015\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\r\u0010\n\u001a\u00020\u0004¢\u0006\u0004\b\n\u0010\u0003J\u0017\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u000b\u0010\tJ\u000f\u0010\f\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\f\u0010\u0003J\u000f\u0010\r\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\r\u0010\u0003J\u0017\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0011\u001a\u00020\u00108\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0014\u001a\u00020\u00138\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0016\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0016\u0010\u0018\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0018\u0010\u0017R\u001c\u0010\u001b\u001a\n \u001a*\u0004\u0018\u00010\u00190\u00198\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0018\u0010\u001d\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0016\u0010\u001f\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001f\u0010\u0017R\u0016\u0010!\u001a\u00020 8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b!\u0010\"R\u001c\u0010$\u001a\b\u0012\u0002\b\u0003\u0018\u00010#8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b$\u0010%R\u0014\u0010'\u001a\u00020&8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b'\u0010(¨\u0006)"}, d2 = {"Lx5/h;", "", "<init>", "()V", "LY8/t;", Const.INTENT_KEY_BACKGROUND_COMMAND, "", d.EXTRA_ENABLED, Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "(Z)V", "m", Const.INTENT_KEY_UMID, Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "l", "(Z)Z", "", "TAG", "Ljava/lang/String;", "", "RETRY_DELAYS_MS", "[J", "desired", "Z", "initialized", "Ljava/util/concurrent/ScheduledExecutorService;", "kotlin.jvm.PlatformType", "executor", "Ljava/util/concurrent/ScheduledExecutorService;", "lastSent", "Ljava/lang/Boolean;", "lastSentOk", "", "retryIndex", "I", "Ljava/util/concurrent/ScheduledFuture;", "pendingRetry", "Ljava/util/concurrent/ScheduledFuture;", "x5/h$a", "accountCallback", "Lx5/h$a;", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class h {
    private static final String TAG = "VoiceWakeupSwitch";
    private static volatile boolean desired;
    private static volatile boolean initialized;
    private static Boolean lastSent;
    private static boolean lastSentOk;
    private static ScheduledFuture<?> pendingRetry;
    private static int retryIndex;
    public static final h INSTANCE = new h();
    private static final long[] RETRY_DELAYS_MS = {1000, 4000, 16000};
    private static final ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor(new ThreadFactory() { // from class: x5.e
        @Override // java.util.concurrent.ThreadFactory
        public final Thread newThread(Runnable runnable) {
            return h.f(runnable);
        }
    });
    private static final a accountCallback = new a();

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"x5/h$a", "Lcom/stepos/ailauncher/foundation/account/i;", "Lcom/stepos/ailauncher/foundation/account/a;", "accountInfo", "LY8/t;", Const.INTENT_KEY_APIKEY, "(Lcom/stepos/ailauncher/foundation/account/a;)V", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class a implements i {
        @Override // com.stepos.ailauncher.foundation.account.i
        public void a(AccountInfo accountInfo) {
            h.INSTANCE.m();
        }
    }

    public static final void e() {
        ScheduledFuture<?> scheduledFuture = pendingRetry;
        if (scheduledFuture != null) {
            scheduledFuture.cancel(false);
        }
        pendingRetry = null;
        retryIndex = 0;
        INSTANCE.i();
    }

    public static final Thread f(Runnable runnable) {
        Thread thread = new Thread(runnable, "voice-wakeup-switch");
        thread.setDaemon(true);
        return thread;
    }

    public static final void k() {
        INSTANCE.i();
    }

    public final void d(boolean enabled) {
        desired = enabled;
        executor.execute(new Runnable() { // from class: x5.f
            @Override // java.lang.Runnable
            public final void run() {
                h.e();
            }
        });
    }

    public final void g() {
        if (initialized) {
            return;
        }
        initialized = true;
        com.stepos.ailauncher.foundation.account.f.INSTANCE.z(accountCallback);
        m();
    }

    public final void h(boolean enabled) {
        d(enabled);
    }

    public final void i() {
        boolean z10 = desired;
        if (p.d(lastSent, Boolean.valueOf(z10)) && lastSentOk) {
            return;
        }
        boolean zL = l(z10);
        lastSent = Boolean.valueOf(z10);
        lastSentOk = zL;
        if (zL) {
            retryIndex = 0;
        } else {
            j();
        }
    }

    public final void j() {
        int i10 = retryIndex;
        long[] jArr = RETRY_DELAYS_MS;
        if (i10 >= jArr.length) {
            C4148a.u(TAG, "retry exhausted, wait for next cold start sync", false, 4, null);
            return;
        }
        long j10 = jArr[i10];
        retryIndex = i10 + 1;
        pendingRetry = executor.schedule(new Runnable() { // from class: x5.g
            @Override // java.lang.Runnable
            public final void run() {
                h.k();
            }
        }, j10, TimeUnit.MILLISECONDS);
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0032  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean l(boolean r8) {
        /*
            r7 = this;
            r7 = 0
            com.stepos.ailauncher.common.utils.a r0 = com.stepos.ailauncher.common.utils.C3197a.INSTANCE     // Catch: java.lang.Throwable -> L34
            android.app.Application r0 = r0.a()     // Catch: java.lang.Throwable -> L34
            android.content.ContentResolver r0 = r0.getContentResolver()     // Catch: java.lang.Throwable -> L34
            x5.d r1 = x5.d.INSTANCE     // Catch: java.lang.Throwable -> L34
            android.net.Uri r1 = r1.a()     // Catch: java.lang.Throwable -> L34
            java.lang.String r2 = "set_amoo_enabled"
            android.os.Bundle r3 = new android.os.Bundle     // Catch: java.lang.Throwable -> L34
            r3.<init>()     // Catch: java.lang.Throwable -> L34
            java.lang.String r4 = "enabled"
            r3.putBoolean(r4, r8)     // Catch: java.lang.Throwable -> L34
            Y8.t r4 = Y8.t.f7040a     // Catch: java.lang.Throwable -> L34
            r4 = 0
            android.os.Bundle r0 = r0.call(r1, r2, r4, r3)     // Catch: java.lang.Throwable -> L34
            if (r0 == 0) goto L32
            java.lang.String r1 = "success"
            boolean r0 = r0.getBoolean(r1, r7)     // Catch: java.lang.Throwable -> L34
            r1 = 1
            if (r0 != r1) goto L32
            goto L37
        L32:
            r1 = r7
            goto L37
        L34:
            r0 = move-exception
            r3 = r0
            goto L57
        L37:
            java.lang.String r0 = "VoiceWakeupSwitch"
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L34
            r2.<init>()     // Catch: java.lang.Throwable -> L34
            java.lang.String r3 = "notify ability enabled="
            r2.append(r3)     // Catch: java.lang.Throwable -> L34
            r2.append(r8)     // Catch: java.lang.Throwable -> L34
            java.lang.String r3 = " success="
            r2.append(r3)     // Catch: java.lang.Throwable -> L34
            r2.append(r1)     // Catch: java.lang.Throwable -> L34
            java.lang.String r2 = r2.toString()     // Catch: java.lang.Throwable -> L34
            r3 = 4
            h8.C4148a.k(r0, r2, r7, r3, r4)     // Catch: java.lang.Throwable -> L34
            return r1
        L57:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "notify ability failed enabled="
            r0.append(r1)
            r0.append(r8)
            java.lang.String r2 = r0.toString()
            r5 = 8
            r6 = 0
            java.lang.String r1 = "VoiceWakeupSwitch"
            r4 = 0
            h8.C4148a.t(r1, r2, r3, r4, r5, r6)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: x5.h.l(boolean):boolean");
    }

    public final void m() {
        d(AuthManager.INSTANCE.K());
    }
}
