package okhttp3.internal.d;

import com.bytedance.security.zenmobile.io.SensitiveType;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import d.x;
import java.io.IOException;
import java.net.Socket;
import java.util.List;
import okhttp3.af;
import okhttp3.internal.g.n;
import okhttp3.r;
import okhttp3.v;
import okhttp3.z;

/* JADX INFO: compiled from: ExchangeFinder.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final g f39875a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final okhttp3.a f39876b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final e f39877c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final r f39878d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private j.b f39879e;
    private j f;
    private int g;
    private int h;
    private int i;
    private af j;

    public d(g r2, okhttp3.a r3, e r4, r r5) {
        o.e(r2, "connectionPool");
        o.e(r3, SensitiveType.ADDRESS);
        o.e(r4, "call");
        o.e(r5, "eventListener");
        this.f39875a = r2;
        this.f39876b = r3;
        this.f39877c = r4;
        this.f39878d = r5;
    }

    public final okhttp3.a a() {
        return this.f39876b;
    }

    public final okhttp3.internal.e.d a(z r9, okhttp3.internal.e.g r10) {
        o.e(r9, "client");
        o.e(r10, "chain");
        int r2 = r10.f();     // Catch: IOException -> L9 i -> L12
        int r3 = r10.g();     // Catch: IOException -> L9 i -> L12
        int r4 = r10.h();     // Catch: IOException -> L9 i -> L12
        int r5 = r9.B();     // Catch: IOException -> L9 i -> L12
        boolean r6 = r9.f();     // Catch: IOException -> L9 i -> L12
        if (o.a(r10.e().b(), "GET") == true) goto L6;
        boolean r0 = true;
    L7:
        return a(r2, r3, r4, r5, r6, r0).a(r9, r10);
    L6:
        r0 = false;
    L9:
        e = move-exception;
        a(e);
        throw new i(e);
    L12:
        e = move-exception;
        a(e.b());
        throw e;
    }

    private final f a(int r3, int r4, int r5, int r6, boolean r7, boolean r8) {
    L2:
        f r0 = a(r3, r4, r5, r6, r7);
        if (r0.b(r8) == true) goto L4;
        r0.h();
        if (this.j != null) goto L2;
        j.b r1 = this.f39879e;
        boolean r2 = true;
        if (r1 == null) goto L10;
        boolean r9 = r1.b();
    L11:
        if (r9 == true) goto L2;
        j r10 = this.f;
        if (r10 == null) goto L15;
        r2 = r10.a();
    L15:
        if (r2 == true) goto L2;
        throw new IOException("exhausted all routes");
    L10:
        r9 = true;
        goto L11
    L4:
        return r0;
    }

    private final f a(int r15, int r16, int r17, int r18, boolean r19) {
        if (this.f39877c.d() == true) goto L74;
        f r2 = this.f39877c.i();
        boolean r0 = true;
        if (r2 == null) goto L31;
        monitor-enter(r2);
    L28:
        th = move-exception;
        throw th;
    L8:
        if (r2.c() == false) goto L10;
    L13:
        Socket r5 = this.f39877c.n();     // Catch: Throwable -> L28
    L14:
        x r6 = x.f38692a;     // Catch: Throwable -> L28
        monitor-exit(r2);
        if (this.f39877c.i() == null) goto L25;
        if (r5 == null) goto L21;
        r0 = false;
    L21:
        if (r0 == false) goto L24;
        return r2;
    L24:
        throw new IllegalStateException("Check failed.".toString());
    L25:
        if (r5 == null) goto L27;
        okhttp3.internal.c.a(r5);
    L27:
        this.f39878d.connectionReleased((okhttp3.e) ZeusTransformUtils.preCheckCast(this.f39877c, okhttp3.e.class, "com.obric.aiagent.plugin"), (okhttp3.j) ZeusTransformUtils.preCheckCast(r2, okhttp3.j.class, "com.obric.aiagent.plugin"));
        goto L31
    L10:
        if (a(r2.a().a().i()) == false) goto L13;
        r5 = null;
    L31:
        this.g = 0;
        this.h = 0;
        this.i = 0;
        if (this.f39875a.a(this.f39876b, this.f39877c, null, false) == false) goto L35;
        f r1 = this.f39877c.i();
        o.a(r1);
        this.f39878d.connectionAcquired((okhttp3.e) ZeusTransformUtils.preCheckCast(this.f39877c, okhttp3.e.class, "com.obric.aiagent.plugin"), (okhttp3.j) ZeusTransformUtils.preCheckCast(r1, okhttp3.j.class, "com.obric.aiagent.plugin"));
        return r1;
    L35:
        af r3 = this.j;
        if (r3 == null) goto L39;
        o.a(r3);
        this.j = null;
    L38:
        List<af> r7 = null;
    L54:
        f r4 = new f(this.f39875a, r3);
        this.f39877c.a(r4);
        r4.a(r15, r16, r17, r18, r19, (okhttp3.e) ZeusTransformUtils.preCheckCast(this.f39877c, okhttp3.e.class, "com.obric.aiagent.plugin"), this.f39878d);     // Catch: Throwable -> L68
        this.f39877c.a(null);
        this.f39877c.e().D().b(r4.a());
        if (this.f39875a.a(this.f39876b, this.f39877c, r7, true) == false) goto L60;
        f r8 = this.f39877c.i();
        o.a(r8);
        this.j = r3;
        okhttp3.internal.c.a(r4.b());
        this.f39878d.connectionAcquired((okhttp3.e) ZeusTransformUtils.preCheckCast(this.f39877c, okhttp3.e.class, "com.obric.aiagent.plugin"), (okhttp3.j) ZeusTransformUtils.preCheckCast(r8, okhttp3.j.class, "com.obric.aiagent.plugin"));
        return r8;
    L60:
        monitor-enter(r4);
        this.f39875a.a(r4);     // Catch: Throwable -> L65
        this.f39877c.b(r4);     // Catch: Throwable -> L65
        x r9 = x.f38692a;     // Catch: Throwable -> L65
        monitor-exit(r4);
        this.f39878d.connectionAcquired((okhttp3.e) ZeusTransformUtils.preCheckCast(this.f39877c, okhttp3.e.class, "com.obric.aiagent.plugin"), (okhttp3.j) ZeusTransformUtils.preCheckCast(r4, okhttp3.j.class, "com.obric.aiagent.plugin"));
        return r4;
    L65:
        th = move-exception;
        throw th;
    L68:
        th = move-exception;
        this.f39877c.a(null);
        throw th;
    L39:
        j.b r10 = this.f39879e;
        if (r10 == null) goto L44;
        o.a(r10);
        if (r10.b() == false) goto L44;
        j.b r11 = this.f39879e;
        o.a(r11);
        r3 = r11.c();
    L44:
        j r12 = this.f;
        if (r12 != null) goto L47;
        r12 = new j(this.f39876b, this.f39877c.e().D(), (okhttp3.e) ZeusTransformUtils.preCheckCast(this.f39877c, okhttp3.e.class, "com.obric.aiagent.plugin"), this.f39878d);
        this.f = r12;
    L47:
        j.b r13 = r12.b();
        this.f39879e = r13;
        r7 = r13.a();
        if (this.f39877c.d() == true) goto L72;
        if (this.f39875a.a(this.f39876b, this.f39877c, r7, false) == false) goto L53;
        f r14 = this.f39877c.i();
        o.a(r14);
        this.f39878d.connectionAcquired((okhttp3.e) ZeusTransformUtils.preCheckCast(this.f39877c, okhttp3.e.class, "com.obric.aiagent.plugin"), (okhttp3.j) ZeusTransformUtils.preCheckCast(r14, okhttp3.j.class, "com.obric.aiagent.plugin"));
        return r14;
    L53:
        r3 = r13.c();
        goto L54
    L72:
        throw new IOException("Canceled");
    L74:
        throw new IOException("Canceled");
    }

    public final void a(IOException r3) {
        o.e(r3, "e");
        this.j = null;
        if (ZeusTransformUtils.instanceOf(r3, n.class) == false) goto L8;
        if (((n) ZeusTransformUtils.preCheckCast(r3, n.class, "com.obric.aiagent.plugin")).f40087a != okhttp3.internal.g.b.i) goto L8;
        this.g++;
        return;
    L8:
        if (ZeusTransformUtils.instanceOf(r3, okhttp3.internal.g.a.class) == false) goto L10;
        this.h++;
        return;
    L10:
        this.i++;
    }

    public final boolean b() {
        boolean r1 = false;
        if (this.g != 0) goto L10;
        if (this.h != 0) goto L10;
        if (this.i != 0) goto L10;
        return false;
    L10:
        if (this.j == null) goto L12;
        return true;
    L12:
        af r0 = c();
        if (r0 == null) goto L16;
        this.j = r0;
        return true;
    L16:
        j.b r2 = this.f39879e;
        if (r2 != null) goto L19;
    L21:
        if (r1 == false) goto L23;
        return true;
    L23:
        j r3 = this.f;
        if (r3 != null) goto L27;
        return true;
    L27:
        return r3.a();
    L19:
        if (r2.b() != true) goto L21;
        r1 = true;
        goto L21
    }

    private final af c() {
        if (this.g <= 1) goto L5;
    L27:
        return null;
    L5:
        if (this.h > 1) goto L27;
        if (this.i > 0) goto L27;
        f r0 = this.f39877c.i();
        if (r0 != null) goto L12;
        return null;
    L12:
        monitor-enter(r0);
    L24:
        th = move-exception;
        throw th;
    L14:
        if (r0.d() == 0) goto L18;
        monitor-exit(r0);
        return null;
    L18:
        if (okhttp3.internal.c.a(r0.a().a().i(), this.f39876b.i()) == true) goto L21;
        monitor-exit(r0);
        return null;
    L21:
        af r3 = r0.a();     // Catch: Throwable -> L24
        monitor-exit(r0);
        return r3;
    }

    public final boolean a(v r3) {
        o.e(r3, "url");
        v r2 = this.f39876b.i();
        if (r3.c() == r2.c()) goto L5;
    L7:
        return false;
    L5:
        if (o.a(r3.b(), r2.b()) == false) goto L7;
        return true;
    }
}
