package h3;

import kotlin.jvm.internal.Intrinsics;
import okhttp3.internal.connection.Exchange;

/* loaded from: classes2.dex */
public final class a0 {

    /* renamed from: a, reason: collision with root package name */
    public V f12850a;

    /* renamed from: b, reason: collision with root package name */
    public T f12851b;

    /* renamed from: d, reason: collision with root package name */
    public String f12853d;

    /* renamed from: e, reason: collision with root package name */
    public F f12854e;

    /* renamed from: g, reason: collision with root package name */
    public f0 f12856g;

    /* renamed from: h, reason: collision with root package name */
    public b0 f12857h;

    /* renamed from: i, reason: collision with root package name */
    public b0 f12858i;

    /* renamed from: j, reason: collision with root package name */
    public b0 f12859j;

    /* renamed from: k, reason: collision with root package name */
    public long f12860k;

    /* renamed from: l, reason: collision with root package name */
    public long f12861l;

    /* renamed from: m, reason: collision with root package name */
    public Exchange f12862m;

    /* renamed from: c, reason: collision with root package name */
    public int f12852c = -1;

    /* renamed from: f, reason: collision with root package name */
    public G f12855f = new G();

    public static void b(b0 b0Var, String str) {
        if (b0Var == null) {
            return;
        }
        if (b0Var.f12870g != null) {
            throw new IllegalArgumentException(Intrinsics.stringPlus(str, ".body != null").toString());
        }
        if (b0Var.f12871h != null) {
            throw new IllegalArgumentException(Intrinsics.stringPlus(str, ".networkResponse != null").toString());
        }
        if (b0Var.f12872i != null) {
            throw new IllegalArgumentException(Intrinsics.stringPlus(str, ".cacheResponse != null").toString());
        }
        if (b0Var.f12873j != null) {
            throw new IllegalArgumentException(Intrinsics.stringPlus(str, ".priorResponse != null").toString());
        }
    }

    public final b0 a() {
        int i4 = this.f12852c;
        if (i4 < 0) {
            throw new IllegalStateException(Intrinsics.stringPlus("code < 0: ", Integer.valueOf(i4)).toString());
        }
        V v4 = this.f12850a;
        if (v4 == null) {
            throw new IllegalStateException("request == null".toString());
        }
        T t4 = this.f12851b;
        if (t4 == null) {
            throw new IllegalStateException("protocol == null".toString());
        }
        String str = this.f12853d;
        if (str != null) {
            return new b0(v4, t4, str, i4, this.f12854e, this.f12855f.d(), this.f12856g, this.f12857h, this.f12858i, this.f12859j, this.f12860k, this.f12861l, this.f12862m);
        }
        throw new IllegalStateException("message == null".toString());
    }

    public final void c(H headers) {
        Intrinsics.checkNotNullParameter(headers, "headers");
        G gD = headers.d();
        Intrinsics.checkNotNullParameter(gD, "<set-?>");
        this.f12855f = gD;
    }
}
