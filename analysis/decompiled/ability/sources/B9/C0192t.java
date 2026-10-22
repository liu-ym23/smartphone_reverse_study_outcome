package B9;

/* renamed from: B9.t, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0192t {
    public static final long[] e = new long[0];

    /* renamed from: a, reason: collision with root package name */
    public final z9.g f257a;
    public final S7.n b;
    public long c;
    public final long[] d;

    public C0192t(z9.g descriptor, S7.n nVar) {
        kotlin.jvm.internal.k.f(descriptor, "descriptor");
        this.f257a = descriptor;
        this.b = nVar;
        int iD = descriptor.d();
        if (iD <= 64) {
            this.c = iD != 64 ? (-1) << iD : 0L;
            this.d = e;
            return;
        }
        this.c = 0L;
        int i = (iD - 1) >>> 6;
        long[] jArr = new long[i];
        if ((iD & 63) != 0) {
            jArr[i - 1] = (-1) << iD;
        }
        this.d = jArr;
    }
}
