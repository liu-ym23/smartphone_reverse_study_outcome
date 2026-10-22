package hb;

/* JADX INFO: loaded from: classes3.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f20388a;

    public c(long r10) {
        this.f20388a = r10;
    }

    public final float a() {
        return Float.intBitsToFloat((int) (this.f20388a >> 32));
    }

    public final float b() {
        return Float.intBitsToFloat((int) (this.f20388a & 4294967295L));
    }
}
