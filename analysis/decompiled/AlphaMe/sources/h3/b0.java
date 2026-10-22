package h3;

import java.io.Closeable;
import java.io.IOException;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.internal.connection.Exchange;

/* loaded from: classes2.dex */
public final class b0 implements Closeable {

    /* renamed from: a, reason: collision with root package name */
    public final V f12864a;

    /* renamed from: b, reason: collision with root package name */
    public final T f12865b;

    /* renamed from: c, reason: collision with root package name */
    public final String f12866c;

    /* renamed from: d, reason: collision with root package name */
    public final int f12867d;

    /* renamed from: e, reason: collision with root package name */
    public final F f12868e;

    /* renamed from: f, reason: collision with root package name */
    public final H f12869f;

    /* renamed from: g, reason: collision with root package name */
    public final f0 f12870g;

    /* renamed from: h, reason: collision with root package name */
    public final b0 f12871h;

    /* renamed from: i, reason: collision with root package name */
    public final b0 f12872i;

    /* renamed from: j, reason: collision with root package name */
    public final b0 f12873j;

    /* renamed from: k, reason: collision with root package name */
    public final long f12874k;

    /* renamed from: l, reason: collision with root package name */
    public final long f12875l;

    /* renamed from: m, reason: collision with root package name */
    public final Exchange f12876m;

    /* renamed from: n, reason: collision with root package name */
    public C0600i f12877n;

    public b0(V request, T protocol, String message, int i4, F f4, H headers, f0 f0Var, b0 b0Var, b0 b0Var2, b0 b0Var3, long j4, long j5, Exchange exchange) {
        Intrinsics.checkNotNullParameter(request, "request");
        Intrinsics.checkNotNullParameter(protocol, "protocol");
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(headers, "headers");
        this.f12864a = request;
        this.f12865b = protocol;
        this.f12866c = message;
        this.f12867d = i4;
        this.f12868e = f4;
        this.f12869f = headers;
        this.f12870g = f0Var;
        this.f12871h = b0Var;
        this.f12872i = b0Var2;
        this.f12873j = b0Var3;
        this.f12874k = j4;
        this.f12875l = j5;
        this.f12876m = exchange;
    }

    public static String b(b0 b0Var, String name) {
        b0Var.getClass();
        Intrinsics.checkNotNullParameter(name, "name");
        String strA = b0Var.f12869f.a(name);
        if (strA == null) {
            return null;
        }
        return strA;
    }

    public final C0600i a() {
        C0600i c0600i = this.f12877n;
        if (c0600i != null) {
            return c0600i;
        }
        int i4 = C0600i.f12920n;
        C0600i c0600iD = y0.e.d(this.f12869f);
        this.f12877n = c0600iD;
        return c0600iD;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        f0 f0Var = this.f12870g;
        if (f0Var == null) {
            throw new IllegalStateException("response is not eligible for a body and must not be closed".toString());
        }
        f0Var.close();
    }

    public final boolean d() {
        int i4 = this.f12867d;
        return 200 <= i4 && i4 < 300;
    }

    public final a0 e() {
        Intrinsics.checkNotNullParameter(this, "response");
        a0 a0Var = new a0();
        a0Var.f12850a = this.f12864a;
        a0Var.f12851b = this.f12865b;
        a0Var.f12852c = this.f12867d;
        a0Var.f12853d = this.f12866c;
        a0Var.f12854e = this.f12868e;
        a0Var.f12855f = this.f12869f.d();
        a0Var.f12856g = this.f12870g;
        a0Var.f12857h = this.f12871h;
        a0Var.f12858i = this.f12872i;
        a0Var.f12859j = this.f12873j;
        a0Var.f12860k = this.f12874k;
        a0Var.f12861l = this.f12875l;
        a0Var.f12862m = this.f12876m;
        return a0Var;
    }

    public final String toString() {
        return "Response{protocol=" + this.f12865b + ", code=" + this.f12867d + ", message=" + this.f12866c + ", url=" + this.f12864a.f12826a + '}';
    }
}
