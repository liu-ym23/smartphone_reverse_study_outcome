package kotlin.random;

import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
public abstract class a extends Random {
    public a() {
    }

    public abstract java.util.Random getImpl();

    @Override // kotlin.random.Random
    public int nextBits(int r10) {
        return d.g(getImpl().nextInt(), r10);
    }

    @Override // kotlin.random.Random
    public boolean nextBoolean() {
        return getImpl().nextBoolean();
    }

    @Override // kotlin.random.Random
    @NotNull
    public byte[] nextBytes(@NotNull byte[] r10) {
        q.g(r10, "array");
        getImpl().nextBytes(r10);
        return r10;
    }

    @Override // kotlin.random.Random
    public double nextDouble() {
        return getImpl().nextDouble();
    }

    @Override // kotlin.random.Random
    public float nextFloat() {
        return getImpl().nextFloat();
    }

    @Override // kotlin.random.Random
    public int nextInt() {
        return getImpl().nextInt();
    }

    @Override // kotlin.random.Random
    public long nextLong() {
        return getImpl().nextLong();
    }

    @Override // kotlin.random.Random
    public int nextInt(int r10) {
        return getImpl().nextInt(r10);
    }
}
