package o4;

import j4.k;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import n4.AbstractC0884a;

/* renamed from: o4.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0903a extends AbstractC0884a {
    @Override // n4.AbstractC0884a
    public Random c() {
        ThreadLocalRandom threadLocalRandomCurrent = ThreadLocalRandom.current();
        k.f(threadLocalRandomCurrent, "current(...)");
        return threadLocalRandomCurrent;
    }
}
