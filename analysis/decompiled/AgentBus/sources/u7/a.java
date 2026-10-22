package u7;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import q7.k;

/* loaded from: classes.dex */
public final class a extends t7.a {
    @Override // t7.a
    public final Random a() {
        ThreadLocalRandom threadLocalRandomCurrent = ThreadLocalRandom.current();
        k.d(threadLocalRandomCurrent, "current(...)");
        return threadLocalRandomCurrent;
    }
}
