package com.bytedance.retrofit2.d;

import com.bytedance.retrofit2.ae;
import com.bytedance.retrofit2.ak;
import com.bytedance.retrofit2.e;
import com.bytedance.retrofit2.g;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: RealInterceptorChain.java */
/* JADX INFO: loaded from: classes.dex */
public class c implements b.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile boolean f9501a = false;
    private static boolean g = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final List<b> f9502b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f9503c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final com.bytedance.retrofit2.b.c f9504d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final e f9505e;
    private int f;

    static {
    }

    public c(List<b> r3, int r4, com.bytedance.retrofit2.b.c r5, e r6) {
        List<b> r7 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
        e r8 = (e) ZeusTransformUtils.wrapperContextForParams(r6, e.class, "com.obric.aiagent.plugin");
        this.f9502b = r7;
        this.f9503c = r4;
        this.f9504d = r5;
        this.f9505e = r8;
    }

    @Override // com.bytedance.retrofit2.d.b.a
    public com.bytedance.retrofit2.b.c a() {
        return this.f9504d;
    }

    @Override // com.bytedance.retrofit2.d.b.a
    public ak a(com.bytedance.retrofit2.b.c r8) {
        r8.a(this.f9504d.p());
        if (r8.p() == null) goto L6;
        r8.p().c();
    L6:
        if (this.f9503c >= this.f9502b.size()) goto L58;
        int r0 = this.f + 1;
        this.f = r0;
        if (r0 <= 1) goto L15;
        Iterator<b> r1 = this.f9502b.iterator();
    L11:
        if (r1.hasNext() == false) goto L15;
        b r3 = (b) ZeusTransformUtils.preCheckCast(r1.next(), b.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r3, g.class) == false) goto L11;
        ((g) ZeusTransformUtils.preCheckCast(r3, g.class, "com.obric.aiagent.plugin")).c();
    L15:
        c r2 = new c(this.f9502b, this.f9503c + 1, r8, this.f9505e);
        b r4 = (b) ZeusTransformUtils.preCheckCast(this.f9502b.get(this.f9503c), b.class, "com.obric.aiagent.plugin");
        if (g == true) goto L23;
        StringBuilder r5 = new StringBuilder().append("interceptor = ");
        if (r4 == null) goto L20;
        String r6 = r4.toString();
    L21:
        ae.a("RealInterceptorChain", r5.append(r6).append(" url = ").append(r8.b()).toString());
        goto L23
    L20:
        r6 = "";
    L23:
        if (r4 == null) goto L56;
        if (r8.p() == null) goto L60;
        r8.p().a(r4);
        r8.p().c(r4);
    L60:
        ak r7 = r4.a(r2);     // Catch: Throwable -> L43 Exception -> L45
        if (r7 == null) goto L42;
        if (r7.b() == null) goto L40;
        if (r8.p() == null) goto L38;
        r8.p().a(null);
        if (this.f9503c <= 0) goto L37;
        r8.p().b((b) ZeusTransformUtils.preCheckCast(this.f9502b.get(this.f9503c - 1), b.class, "com.obric.aiagent.plugin"));
    L37:
        a().p().a(null);
    L38:
        return r7;
    L40:
        throw new IllegalStateException("interceptor " + r4 + " returned a ssResponse with no body");     // Catch: Throwable -> L43 Exception -> L45
    L42:
        throw new NullPointerException("interceptor " + r4 + " returned null");     // Catch: Throwable -> L43 Exception -> L45
    L45:
        e = move-exception;
        throw e;     // Catch: Throwable -> L43
    L43:
        th = move-exception;
        if (r8.p() == null) goto L54;
        r8.p().a(null);
        if (this.f9503c <= 0) goto L53;
        r8.p().b((b) ZeusTransformUtils.preCheckCast(this.f9502b.get(this.f9503c - 1), b.class, "com.obric.aiagent.plugin"));
    L53:
        a().p().a(null);
    L54:
        throw th;
    L56:
        throw new NullPointerException("interceptor " + this.f9503c + " is null");
    L58:
        throw new AssertionError();
    }

    @Override // com.bytedance.retrofit2.d.b.a
    public ak b(com.bytedance.retrofit2.b.c r8) {
        r8.a(this.f9504d.p());
        if (r8.p() == null) goto L6;
        r8.p().c();
    L6:
        if (this.f9503c >= this.f9502b.size()) goto L58;
        int r0 = this.f + 1;
        this.f = r0;
        if (r0 <= 1) goto L15;
        Iterator<b> r1 = this.f9502b.iterator();
    L11:
        if (r1.hasNext() == false) goto L15;
        b r3 = (b) ZeusTransformUtils.preCheckCast(r1.next(), b.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r3, g.class) == false) goto L11;
        ((g) ZeusTransformUtils.preCheckCast(r3, g.class, "com.obric.aiagent.plugin")).c();
    L15:
        c r2 = new c(this.f9502b, this.f9503c + 1, r8, this.f9505e);
        b r4 = (b) ZeusTransformUtils.preCheckCast(this.f9502b.get(this.f9503c), b.class, "com.obric.aiagent.plugin");
        if (g == true) goto L23;
        StringBuilder r5 = new StringBuilder().append("interceptor = ");
        if (r4 == null) goto L20;
        String r6 = r4.toString();
    L21:
        ae.a("RealInterceptorChain", r5.append(r6).append(" url = ").append(r8.b()).toString());
        goto L23
    L20:
        r6 = "";
    L23:
        if (r4 == null) goto L56;
        if (r8.p() == null) goto L60;
        r8.p().a(r4);
        r8.p().c(r4);
    L60:
        ak r7 = r4.a(r2);     // Catch: Throwable -> L43 Exception -> L45
        if (r7 == null) goto L42;
        if (r7.b() == null) goto L40;
        if (r8.p() == null) goto L38;
        r8.p().a(null);
        if (this.f9503c <= 0) goto L37;
        r8.p().b((b) ZeusTransformUtils.preCheckCast(this.f9502b.get(this.f9503c - 1), b.class, "com.obric.aiagent.plugin"));
    L37:
        a().p().a(null);
    L38:
        return r7;
    L40:
        throw new IllegalStateException("interceptor " + r4 + " returned a ssResponse with no body");     // Catch: Throwable -> L43 Exception -> L45
    L42:
        throw new NullPointerException("interceptor " + r4 + " returned null");     // Catch: Throwable -> L43 Exception -> L45
    L45:
        e = move-exception;
        throw e;     // Catch: Throwable -> L43
    L43:
        th = move-exception;
        if (r8.p() == null) goto L54;
        r8.p().a(null);
        if (this.f9503c <= 0) goto L53;
        r8.p().b((b) ZeusTransformUtils.preCheckCast(this.f9502b.get(this.f9503c - 1), b.class, "com.obric.aiagent.plugin"));
    L53:
        a().p().a(null);
    L54:
        throw th;
    L56:
        throw new NullPointerException("interceptor " + this.f9503c + " is null");
    L58:
        throw new AssertionError();
    }

    @Override // com.bytedance.retrofit2.d.b.a
    public e call() {
        return this.f9505e;
    }

    public static void a(boolean r0) {
        f9501a = r0;
    }

    public static boolean b() {
        return f9501a;
    }
}
