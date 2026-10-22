package org.chromium;

import android.os.Process;
import com.bytedance.frameworks.baselib.network.http.cronet.TTNetInitMetrics;
import com.ttnet.org.chromium.net.impl.CronetLibraryLoader;
import com.ttnet.org.chromium.net.u;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
public class e extends u {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile e f23043b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f23044a;

    public e() {
        this.f23044a = false;
    }

    public static e r() {
        if (f23043b != null) goto L16;
        monitor-enter(e.class);
    L9:
        th = move-exception;
        throw th;
    L7:
        if (f23043b != null) goto L11;
        f23043b = new e();     // Catch: Throwable -> L9
    L11:
        monitor-exit(e.class);     // Catch: Throwable -> L9
    L16:
        return f23043b;
    }

    @Override // com.ttnet.org.chromium.net.u
    public Map a(String r10, Map r11) {
        return c.N().T(r10, r11);
    }

    @Override // com.ttnet.org.chromium.net.u
    public void b(String r10) {
        if (this.f23044a == false) goto L6;
        c.N().U(r10);
        return;
    }

    @Override // com.ttnet.org.chromium.net.u
    public void c() {
        if (this.f23044a == false) goto L6;
        c.N().V();
        return;
    }

    @Override // com.ttnet.org.chromium.net.u
    public void d(long r10, long r11, long r12, long r13, long r14, long r15, long r16, long r18, long r20, long r22, long r24, long r26, long r28, long r30, long r32, long r34, long r36, long r38) {
        TTNetInitMetrics r17 = TTNetInitMetrics.c();
        r17.f7211c = Process.getThreadPriority(0);
        r17.f7219k = CronetLibraryLoader.f18556g;
        r17.f7220l = CronetLibraryLoader.f18557h;
        r17.f7228t = CronetLibraryLoader.f18558i;
        r17.f7221m = r10;
        r17.f7222n = r11;
        r17.f7223o = r12;
        r17.f7224p = r13;
        r17.f7225q = r14;
        r17.f7226r = r15;
        r17.f7229u = r16;
        r17.f7230v = r18;
        r17.f7231w = r20;
        r17.f7232x = r22;
        r17.f7233y = r24;
        r17.f7234z = r26;
        r17.A = r28;
        r17.B = r30;
        r17.C = r32;
        r17.D = r34;
        r17.E = r36;
        r17.F = r38;
        c.N().k0(TTNetInitMetrics.c().f().toString(), "ttnet_init");
    }

    @Override // com.ttnet.org.chromium.net.u
    public void e() {
        if (this.f23044a == false) goto L6;
        c.N().W();
        return;
    }

    @Override // com.ttnet.org.chromium.net.u
    public void f(int r10) {
        c.N().X(r10);
    }

    @Override // com.ttnet.org.chromium.net.u
    public void g(int r10, int r11) {
        c.N().Z(r10, r11);
    }

    @Override // com.ttnet.org.chromium.net.u
    public void h(int r10) {
        c.N().a0(r10);
    }

    @Override // com.ttnet.org.chromium.net.u
    public void i(int r10, int r11, int r12) {
        c.N().b0(r10, r11, r12);
    }

    @Override // com.ttnet.org.chromium.net.u
    public void j(int r11, double r12, double r14, double r16, double r18) {
        c.N().c0(r11, r12, r14, r16, r18);
    }

    @Override // com.ttnet.org.chromium.net.u
    public void k(List r10, List r11) {
        if (this.f23044a == false) goto L6;
        c.N().d0(r10, r11);
        return;
    }

    @Override // com.ttnet.org.chromium.net.u
    public void l(int r10, int r11, int r12) {
        c.N().e0(r10, r11, r12);
    }

    @Override // com.ttnet.org.chromium.net.u
    public void m(String r10, String r11, String r12) {
        if (this.f23044a == false) goto L6;
        c.N().f0(r10, r11, r12);
        return;
    }

    @Override // com.ttnet.org.chromium.net.u
    public void n(String r10, String r11, String r12) {
        if (this.f23044a == false) goto L6;
        c.N().g0(r10, r11, r12);
        return;
    }

    @Override // com.ttnet.org.chromium.net.u
    public void o(String[] r10, String r11) {
        if (this.f23044a == false) goto L6;
        c.N().h0(r10, r11);
        return;
    }

    @Override // com.ttnet.org.chromium.net.u
    public void p(String r10, String r11, int r12, int r13, int r14, List r15, String r16) {
        c.N().i0(r10, r11, r12, r13, r14, r15, r16);
    }

    @Override // com.ttnet.org.chromium.net.u
    public void q(String r10) {
        if (this.f23044a == false) goto L6;
        c.N().j0(r10);
        return;
    }

    public void s(String r10, int r11) {
        if (this.f23044a == false) goto L6;
        c.N().Y(r10, r11);
        return;
    }

    public void t(boolean r10) {
        this.f23044a = r10;
    }
}
