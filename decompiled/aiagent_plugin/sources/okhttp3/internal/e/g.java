package okhttp3.internal.e;

import com.obric.capabilitykit.common.Ext;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import java.util.List;
import okhttp3.ab;
import okhttp3.ad;
import okhttp3.w;

/* JADX INFO: compiled from: RealInterceptorChain.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class g implements w.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final okhttp3.internal.d.e f39924a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final List<w> f39925b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f39926c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final okhttp3.internal.d.c f39927d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final ab f39928e;
    private final int f;
    private final int g;
    private final int h;
    private int i;

    public g(okhttp3.internal.d.e r3, List<? extends w> r4, int r5, okhttp3.internal.d.c r6, ab r7, int r8, int r9, int r10) {
        List<w> r11 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.aiagent.plugin");
        o.e(r3, "call");
        o.e(r11, "interceptors");
        o.e(r7, Ext.KEY_REQUEST);
        this.f39924a = r3;
        this.f39925b = r11;
        this.f39926c = r5;
        this.f39927d = r6;
        this.f39928e = r7;
        this.f = r8;
        this.g = r9;
        this.h = r10;
    }

    public final okhttp3.internal.d.e c() {
        return this.f39924a;
    }

    public final okhttp3.internal.d.c d() {
        return this.f39927d;
    }

    public final ab e() {
        return this.f39928e;
    }

    public final int f() {
        return this.f;
    }

    public final int g() {
        return this.g;
    }

    public final int h() {
        return this.h;
    }

    public static /* synthetic */ g a(g r4, int r5, okhttp3.internal.d.c r6, ab r7, int r8, int r9, int r10, int r11, Object r12) {
        if ((r11 & 1) == 0) goto L6;
        r5 = r4.f39926c;
    L6:
        if ((r11 & 2) == 0) goto L8;
        r6 = r4.f39927d;
    L8:
        okhttp3.internal.d.c r13 = r6;
        if ((r11 & 4) == 0) goto L11;
        r7 = r4.f39928e;
    L11:
        ab r0 = r7;
        if ((r11 & 8) == 0) goto L14;
        r8 = r4.f;
    L14:
        int r1 = r8;
        if ((r11 & 16) == 0) goto L17;
        r9 = r4.g;
    L17:
        int r2 = r9;
        if ((r11 & 32) == 0) goto L20;
        r10 = r4.h;
    L20:
        int r14 = r5;
        return r4.a(r14, r13, r0, r1, r2, r10);
    }

    public final g a(int r12, okhttp3.internal.d.c r13, ab r14, int r15, int r16, int r17) {
        o.e(r14, Ext.KEY_REQUEST);
        return new g(this.f39924a, this.f39925b, r12, r13, r14, r15, r16, r17);
    }

    @Override // okhttp3.w.a
    public okhttp3.j b() {
        okhttp3.internal.d.c r2 = this.f39927d;
        if (r2 == null) goto L5;
        okhttp3.internal.d.f r3 = r2.f();
    L7:
        return (okhttp3.j) ZeusTransformUtils.preCheckCast(r3, okhttp3.j.class, "com.obric.aiagent.plugin");
    L5:
        r3 = null;
        goto L7
    }

    public int i() {
        return this.g;
    }

    @Override // okhttp3.w.a
    public okhttp3.e call() {
        return (okhttp3.e) ZeusTransformUtils.preCheckCast(this.f39924a, okhttp3.e.class, "com.obric.aiagent.plugin");
    }

    @Override // okhttp3.w.a
    public ab a() {
        return this.f39928e;
    }

    @Override // okhttp3.w.a
    public ad a(ab r15) {
        o.e(r15, Ext.KEY_REQUEST);
        boolean r2 = false;
        if (this.f39926c >= this.f39925b.size()) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L46;
        this.i++;
        okhttp3.internal.d.c r1 = this.f39927d;
        if (r1 != null) goto L10;
    L21:
        g r16 = a(this, this.f39926c + 1, null, r15, 0, 0, 0, 58, null);
        w r3 = (w) ZeusTransformUtils.preCheckCast(this.f39925b.get(this.f39926c), w.class, "com.obric.aiagent.plugin");
        ad r5 = r3.intercept((w.a) ZeusTransformUtils.preCheckCast(r16, w.a.class, "com.obric.aiagent.plugin"));
        if (r5 == null) goto L44;
        if (this.f39927d == null) goto L37;
        if ((this.f39926c + 1) < this.f39925b.size()) goto L28;
    L31:
        boolean r14 = true;
    L32:
        if (r14 == true) goto L37;
        throw new IllegalStateException(("network interceptor " + r3 + " must call proceed() exactly once").toString());
    L28:
        if (r16.i == 1) goto L31;
        r14 = false;
    L37:
        if (r5.g() == null) goto L39;
        r2 = true;
    L39:
        if (r2 == false) goto L42;
        return r5;
    L42:
        throw new IllegalStateException(("interceptor " + r3 + " returned a response with no body").toString());
    L44:
        throw new NullPointerException("interceptor " + r3 + " returned null");
    L10:
        if (r1.c().a(r15.a()) == false) goto L20;
        if (this.i != 1) goto L14;
        boolean r4 = true;
    L15:
        if (r4 == true) goto L21;
        throw new IllegalStateException(("network interceptor " + this.f39925b.get(this.f39926c - 1) + " must call proceed() exactly once").toString());
    L14:
        r4 = false;
        goto L15
    L20:
        throw new IllegalStateException(("network interceptor " + this.f39925b.get(this.f39926c - 1) + " must retain the same host and port").toString());
    L46:
        throw new IllegalStateException("Check failed.".toString());
    L5:
        r0 = false;
        goto L6
    }
}
