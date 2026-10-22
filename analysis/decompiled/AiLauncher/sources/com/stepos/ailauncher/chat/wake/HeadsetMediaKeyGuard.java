package com.stepos.ailauncher.chat.wake;

import android.os.SystemClock;
import android.view.KeyEvent;
import com.autonavi.aps.amapapi.config.Const;
import h8.C4148a;
import h9.InterfaceC4149a;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\bÀ\u0002\u0018\u00002\u00020\u0001:\u0001\u001fB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0003J\u0015\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u0015\u0010\f\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0013\u001a\u00020\u00128\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0016\u001a\u00020\u00158\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0018\u001a\u00020\u00158\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0018\u0010\u0017R\u0014\u0010\u0019\u001a\u00020\u00018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001c\u001a\u00020\u001b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0016\u0010\u001e\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001e\u0010\u0017¨\u0006 "}, d2 = {"Lcom/stepos/ailauncher/chat/wake/HeadsetMediaKeyGuard;", "", "<init>", "()V", "LY8/t;", Const.INTENT_KEY_APIKEY, "", "active", Const.INTENT_KEY_UMID, "(Z)V", "Landroid/view/KeyEvent;", "event", Const.INTENT_KEY_PKGNAME, "(Landroid/view/KeyEvent;)Z", "", "keyCode", "c", "(I)Z", "", "TAG", "Ljava/lang/String;", "", "PRE_LISTEN_MS", "J", "TAIL_MS", "lock", "Ljava/lang/Object;", "Lcom/stepos/ailauncher/chat/wake/HeadsetMediaKeyGuard$Phase;", "phase", "Lcom/stepos/ailauncher/chat/wake/HeadsetMediaKeyGuard$Phase;", "armedUntil", "Phase", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class HeadsetMediaKeyGuard {
    private static final long PRE_LISTEN_MS = 3000;
    private static final String TAG = "HeadsetMediaKey";
    private static final long TAIL_MS = 800;
    private static long armedUntil;
    public static final HeadsetMediaKeyGuard INSTANCE = new HeadsetMediaKeyGuard();
    private static final Object lock = new Object();
    private static Phase phase = Phase.IDLE;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/stepos/ailauncher/chat/wake/HeadsetMediaKeyGuard$Phase;", "", "<init>", "(Ljava/lang/String;I)V", "IDLE", "PRE_LISTEN", "LISTENING", "TAIL", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Phase {
        private static final /* synthetic */ InterfaceC4149a $ENTRIES;
        private static final /* synthetic */ Phase[] $VALUES;
        public static final Phase IDLE = new Phase("IDLE", 0);
        public static final Phase PRE_LISTEN = new Phase("PRE_LISTEN", 1);
        public static final Phase LISTENING = new Phase("LISTENING", 2);
        public static final Phase TAIL = new Phase("TAIL", 3);

        private static final /* synthetic */ Phase[] $values() {
            return new Phase[]{IDLE, PRE_LISTEN, LISTENING, TAIL};
        }

        static {
            Phase[] phaseArr$values = $values();
            $VALUES = phaseArr$values;
            $ENTRIES = kotlin.enums.a.a(phaseArr$values);
        }

        private Phase(String str, int i10) {
        }

        public static InterfaceC4149a<Phase> getEntries() {
            return $ENTRIES;
        }

        public static Phase valueOf(String str) {
            return (Phase) Enum.valueOf(Phase.class, str);
        }

        public static Phase[] values() {
            return (Phase[]) $VALUES.clone();
        }
    }

    public final void a() {
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        synchronized (lock) {
            phase = Phase.PRE_LISTEN;
            armedUntil = jElapsedRealtime + 3000;
            Y8.t tVar = Y8.t.f7040a;
        }
        C4148a.k(TAG, "arm preListen=3000ms", false, 4, null);
    }

    public final boolean b(KeyEvent event) {
        boolean z10;
        kotlin.jvm.internal.p.i(event, "event");
        if (!c(event.getKeyCode())) {
            return false;
        }
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        synchronized (lock) {
            Phase phase2 = phase;
            Phase phase3 = Phase.IDLE;
            if (phase2 == phase3) {
                z10 = false;
            } else if (phase == Phase.LISTENING || jElapsedRealtime <= armedUntil) {
                z10 = true;
            } else {
                phase = phase3;
                z10 = false;
            }
        }
        if (!z10) {
            return false;
        }
        C4148a.d(TAG, "consume keyCode=" + event.getKeyCode() + " action=" + event.getAction() + " repeat=" + event.getRepeatCount(), false, 4, null);
        return true;
    }

    public final boolean c(int keyCode) {
        return keyCode == 85 || keyCode == 79 || keyCode == 126 || keyCode == 127;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0027  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void d(boolean r8) {
        /*
            r7 = this;
            long r0 = android.os.SystemClock.elapsedRealtime()
            java.lang.Object r7 = com.stepos.ailauncher.chat.wake.HeadsetMediaKeyGuard.lock
            monitor-enter(r7)
            r2 = 0
            r3 = 4
            r4 = 0
            if (r8 == 0) goto L27
            com.stepos.ailauncher.chat.wake.HeadsetMediaKeyGuard$Phase r5 = com.stepos.ailauncher.chat.wake.HeadsetMediaKeyGuard.phase     // Catch: java.lang.Throwable -> L25
            com.stepos.ailauncher.chat.wake.HeadsetMediaKeyGuard$Phase r6 = com.stepos.ailauncher.chat.wake.HeadsetMediaKeyGuard.Phase.IDLE     // Catch: java.lang.Throwable -> L25
            if (r5 == r6) goto L27
            com.stepos.ailauncher.chat.wake.HeadsetMediaKeyGuard$Phase r8 = com.stepos.ailauncher.chat.wake.HeadsetMediaKeyGuard.Phase.LISTENING     // Catch: java.lang.Throwable -> L25
            com.stepos.ailauncher.chat.wake.HeadsetMediaKeyGuard.phase = r8     // Catch: java.lang.Throwable -> L25
            r0 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            com.stepos.ailauncher.chat.wake.HeadsetMediaKeyGuard.armedUntil = r0     // Catch: java.lang.Throwable -> L25
            java.lang.String r8 = "HeadsetMediaKey"
            java.lang.String r0 = "listening, swallow headset media keys"
            h8.C4148a.k(r8, r0, r4, r3, r2)     // Catch: java.lang.Throwable -> L25
            goto L3f
        L25:
            r8 = move-exception
            goto L43
        L27:
            if (r8 != 0) goto L3f
            com.stepos.ailauncher.chat.wake.HeadsetMediaKeyGuard$Phase r8 = com.stepos.ailauncher.chat.wake.HeadsetMediaKeyGuard.phase     // Catch: java.lang.Throwable -> L25
            com.stepos.ailauncher.chat.wake.HeadsetMediaKeyGuard$Phase r5 = com.stepos.ailauncher.chat.wake.HeadsetMediaKeyGuard.Phase.LISTENING     // Catch: java.lang.Throwable -> L25
            if (r8 != r5) goto L3f
            com.stepos.ailauncher.chat.wake.HeadsetMediaKeyGuard$Phase r8 = com.stepos.ailauncher.chat.wake.HeadsetMediaKeyGuard.Phase.TAIL     // Catch: java.lang.Throwable -> L25
            com.stepos.ailauncher.chat.wake.HeadsetMediaKeyGuard.phase = r8     // Catch: java.lang.Throwable -> L25
            r5 = 800(0x320, double:3.953E-321)
            long r0 = r0 + r5
            com.stepos.ailauncher.chat.wake.HeadsetMediaKeyGuard.armedUntil = r0     // Catch: java.lang.Throwable -> L25
            java.lang.String r8 = "HeadsetMediaKey"
            java.lang.String r0 = "listen end, tail=800ms"
            h8.C4148a.k(r8, r0, r4, r3, r2)     // Catch: java.lang.Throwable -> L25
        L3f:
            Y8.t r8 = Y8.t.f7040a     // Catch: java.lang.Throwable -> L25
            monitor-exit(r7)
            return
        L43:
            monitor-exit(r7)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.chat.wake.HeadsetMediaKeyGuard.d(boolean):void");
    }
}
