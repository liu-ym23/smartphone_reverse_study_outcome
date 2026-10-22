package org.chromium;

import com.ttnet.org.chromium.net.aa;

/* JADX INFO: compiled from: CronetAppMonitorProvider.java */
/* JADX INFO: loaded from: classes5.dex */
public class b extends aa {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static b f40525a;

    @Override // com.ttnet.org.chromium.net.aa
    @Deprecated
    public boolean b(String r1, String r2) {
        return true;
    }

    public static b a() {
        if (f40525a != null) goto L15;
        monitor-enter(b.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f40525a != null) goto L9;
        f40525a = new b();     // Catch: Throwable -> L11
    L9:
        monitor-exit(b.class);     // Catch: Throwable -> L11
    L15:
        return f40525a;
    }

    private b() {
    }

    @Override // com.ttnet.org.chromium.net.aa
    public void a(String r1, String r2) {
        c.a().a(r1, r2);
    }

    @Override // com.ttnet.org.chromium.net.aa
    public void a(boolean r11, String r12, String r13, String r14, long r15, long r17, long r19, long r21, long r23, long r25, long r27, long r29, long r31, long r33, boolean r35, long r36, long r38, String r40, String r41, String r42, int r43, int r44, String r45) {
        com.bytedance.frameworks.baselib.network.http.b r7 = com.bytedance.frameworks.baselib.network.http.b.a();
        r7.P = r13;
        r7.w = r14;
        r7.f8139e = r15;
        r7.f = r15;
        r7.g = r17;
        r7.f8138d.aE.f.l = r17;
        r7.j = r23;
        r7.f8138d.aE.f.w = r23;
        r7.f8138d.f(r25);
        r7.f8138d.g(r27);
        r7.f8138d.h(r29);
        r7.f8138d.i(r31);
        r7.f8138d.k(r36);
        r7.f8138d.l(r33);
        r7.f8138d.m(r23 - r17);
        r7.f8138d.b(r40);
        r7.h = r19;
        r7.i = r21;
        r7.D = r35;
        r7.y = r38;
        r7.M = r41;
        r7.N = r42;
        r7.G = 0;
        if (r11 == false) goto L5;
        com.bytedance.frameworks.baselib.network.http.g.a(r12, r7);
        return;
    L5:
        com.bytedance.frameworks.baselib.network.http.g.a(r12, r7, h.a(h.a(r43, r44, r45)));
    }
}
