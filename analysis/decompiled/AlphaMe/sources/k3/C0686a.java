package k3;

import kotlin.jvm.internal.Intrinsics;

/* renamed from: k3.a, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C0686a {
    public static C0690e a() throws InterruptedException {
        C0690e c0690e = C0690e.head;
        Intrinsics.checkNotNull(c0690e);
        C0690e c0690e2 = c0690e.next;
        if (c0690e2 == null) {
            long jNanoTime = System.nanoTime();
            C0690e.class.wait(C0690e.IDLE_TIMEOUT_MILLIS);
            C0690e c0690e3 = C0690e.head;
            Intrinsics.checkNotNull(c0690e3);
            if (c0690e3.next != null || System.nanoTime() - jNanoTime < C0690e.IDLE_TIMEOUT_NANOS) {
                return null;
            }
            return C0690e.head;
        }
        long jAccess$remainingNanos = C0690e.access$remainingNanos(c0690e2, System.nanoTime());
        if (jAccess$remainingNanos > 0) {
            long j4 = jAccess$remainingNanos / 1000000;
            C0690e.class.wait(j4, (int) (jAccess$remainingNanos - (1000000 * j4)));
            return null;
        }
        C0690e c0690e4 = C0690e.head;
        Intrinsics.checkNotNull(c0690e4);
        c0690e4.next = c0690e2.next;
        c0690e2.next = null;
        return c0690e2;
    }
}
