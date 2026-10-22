package y5;

import org.tukaani.xz.common.Util;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class j {

    /* renamed from: e, reason: collision with root package name */
    public static final j f6356e = new j(4611686018427387903L, true);

    /* renamed from: a, reason: collision with root package name */
    public final long f6357a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f6358b;

    /* renamed from: c, reason: collision with root package name */
    public final long f6359c;
    public final long d;

    static {
        new j(Util.VLI_MAX, false);
    }

    public j(long j4, boolean z) {
        this.f6357a = j4;
        this.f6358b = z;
        long j8 = 10;
        this.f6359c = j4 / j8;
        this.d = j4 % j8;
    }
}
