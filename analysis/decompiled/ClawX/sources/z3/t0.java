package z3;

import org.tukaani.xz.common.Util;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public abstract class t0 {

    /* renamed from: a, reason: collision with root package name */
    public static final z7.b f6508a = z7.d.c("io.ktor.client.plugins.HttpTimeout");

    /* renamed from: b, reason: collision with root package name */
    public static final a4.d f6509b = b8.h.j("HttpTimeout", s0.f6503a, new p(4));

    public static final int a(long j4) {
        if (j4 == Util.VLI_MAX) {
            return 0;
        }
        if (j4 < -2147483648L) {
            return Integer.MIN_VALUE;
        }
        if (j4 > 2147483647L) {
            return Integer.MAX_VALUE;
        }
        return (int) j4;
    }
}
