package X7;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import kotlin.jvm.internal.k;

/* loaded from: classes3.dex */
public final class a extends W7.a {
    @Override // W7.c
    public final int c(int i, int i6) {
        return ThreadLocalRandom.current().nextInt(i, i6);
    }

    @Override // W7.c
    public final long e(long j5, long j6) {
        return ThreadLocalRandom.current().nextLong(j5, j6);
    }

    @Override // W7.a
    public final Random f() {
        ThreadLocalRandom threadLocalRandomCurrent = ThreadLocalRandom.current();
        k.e(threadLocalRandomCurrent, "current(...)");
        return threadLocalRandomCurrent;
    }
}
