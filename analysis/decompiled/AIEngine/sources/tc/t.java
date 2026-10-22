package tc;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class t {

    /* renamed from: e, reason: collision with root package name */
    public static final long[] f13050e = new long[0];

    /* renamed from: a, reason: collision with root package name */
    public final rc.e f13051a;

    /* renamed from: b, reason: collision with root package name */
    public final zb.p<rc.e, Integer, Boolean> f13052b;

    /* renamed from: c, reason: collision with root package name */
    public long f13053c;

    /* renamed from: d, reason: collision with root package name */
    public final long[] f13054d;

    /* JADX WARN: Multi-variable type inference failed */
    public t(rc.e descriptor, zb.p<? super rc.e, ? super Integer, Boolean> pVar) {
        kotlin.jvm.internal.g.f(descriptor, "descriptor");
        this.f13051a = descriptor;
        this.f13052b = pVar;
        int iE = descriptor.e();
        if (iE <= 64) {
            this.f13053c = iE != 64 ? (-1) << iE : 0L;
            this.f13054d = f13050e;
            return;
        }
        this.f13053c = 0L;
        int i10 = (iE - 1) >>> 6;
        long[] jArr = new long[i10];
        if ((iE & 63) != 0) {
            jArr[i10 - 1] = (-1) << iE;
        }
        this.f13054d = jArr;
    }
}
