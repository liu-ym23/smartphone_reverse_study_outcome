package bc;

import kotlin.random.Random;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public abstract class a extends Random {
    @Override // kotlin.random.Random
    public final int a(int i10) {
        return (e().nextInt() >>> (32 - i10)) & ((-i10) >> 31);
    }

    @Override // kotlin.random.Random
    public final int b() {
        return e().nextInt();
    }

    @Override // kotlin.random.Random
    public final long c() {
        return e().nextLong();
    }

    public abstract java.util.Random e();
}
