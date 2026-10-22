package com.obric.oui.orecyclerview.widget;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: ViewInfoStore.java */
/* JADX INFO: loaded from: classes4.dex */
class aa {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final androidx.b.g<RecyclerView.v, a> f35690a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final androidx.b.d<RecyclerView.v> f35691b;

    /* JADX INFO: compiled from: ViewInfoStore.java */
    static class a {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        static androidx.core.util.f.a<a> f35692d;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f35693a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        RecyclerView.e.c f35694b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        RecyclerView.e.c f35695c;

        static {
            f35692d = new androidx.core.util.f.b(20);
        }

        private a() {
        }

        static a a() {
            a r0 = (a) ZeusTransformUtils.preCheckCast(f35692d.a(), a.class, "com.obric.aiagent.plugin");
            if (r0 == null) goto L5;
            return r0;
        L5:
            return new a();
        }

        static void a(a r1) {
            r1.f35693a = 0;
            r1.f35694b = null;
            r1.f35695c = null;
            f35692d.a(r1);
        }

        static void b() {
        L3:
            if (f35692d.a() != null) goto L3;
        }
    }

    /* JADX INFO: compiled from: ViewInfoStore.java */
    interface b {
        void a(RecyclerView.v r1);

        void a(RecyclerView.v r1, RecyclerView.e.c r2, RecyclerView.e.c r3);

        void b(RecyclerView.v r1, RecyclerView.e.c r2, RecyclerView.e.c r3);

        void c(RecyclerView.v r1, RecyclerView.e.c r2, RecyclerView.e.c r3);
    }

    aa() {
        this.f35690a = new androidx.b.g();
        this.f35691b = new androidx.b.d();
    }

    void a() {
        this.f35690a.clear();
        this.f35691b.d();
    }

    void a(RecyclerView.v r4, RecyclerView.e.c r5) {
        a r0 = (a) ZeusTransformUtils.preCheckCast(this.f35690a.get(r4), a.class, "com.obric.aiagent.plugin");
        if (r0 != null) goto L5;
        r0 = a.a();
        this.f35690a.put(r4, r0);
    L5:
        r0.f35694b = r5;
        r0.f35693a |= 4;
    }

    boolean a(RecyclerView.v r2) {
        a r1 = (a) ZeusTransformUtils.preCheckCast(this.f35690a.get(r2), a.class, "com.obric.aiagent.plugin");
        if (r1 != null) goto L5;
    L7:
        return false;
    L5:
        if ((r1.f35693a & 1) == 0) goto L7;
        return true;
    }

    RecyclerView.e.c b(RecyclerView.v r2) {
        return a(r2, 4);
    }

    RecyclerView.e.c c(RecyclerView.v r2) {
        return a(r2, 8);
    }

    private RecyclerView.e.c a(RecyclerView.v r5, int r6) {
        int r7 = this.f35690a.a(r5);
        if (r7 >= 0) goto L5;
        return null;
    L5:
        a r1 = (a) ZeusTransformUtils.preCheckCast(this.f35690a.c(r7), a.class, "com.obric.aiagent.plugin");
        if (r1 != null) goto L8;
    L21:
        return null;
    L8:
        if ((r1.f35693a & r6) == 0) goto L21;
        r1.f35693a &= ~r6;
        if (r6 != 4) goto L13;
        RecyclerView.e.c r8 = r1.f35694b;
    L16:
        if ((r1.f35693a & 12) != 0) goto L18;
        this.f35690a.d(r7);
        a.a(r1);
    L18:
        return r8;
    L13:
        if (r6 != 8) goto L20;
        r8 = r1.f35695c;
        goto L16
    L20:
        throw new IllegalArgumentException("Must provide flag PRE or POST");
    }

    void a(long r1, RecyclerView.v r3) {
        this.f35691b.b(r1, r3);
    }

    void b(RecyclerView.v r4, RecyclerView.e.c r5) {
        a r0 = (a) ZeusTransformUtils.preCheckCast(this.f35690a.get(r4), a.class, "com.obric.aiagent.plugin");
        if (r0 != null) goto L5;
        r0 = a.a();
        this.f35690a.put(r4, r0);
    L5:
        r0.f35693a |= 2;
        r0.f35694b = r5;
    }

    boolean d(RecyclerView.v r2) {
        a r1 = (a) ZeusTransformUtils.preCheckCast(this.f35690a.get(r2), a.class, "com.obric.aiagent.plugin");
        if (r1 != null) goto L5;
    L7:
        return false;
    L5:
        if ((r1.f35693a & 4) == 0) goto L7;
        return true;
    }

    RecyclerView.v a(long r1) {
        return (RecyclerView.v) ZeusTransformUtils.preCheckCast(this.f35691b.a(r1), RecyclerView.v.class, "com.obric.aiagent.plugin");
    }

    void c(RecyclerView.v r4, RecyclerView.e.c r5) {
        a r0 = (a) ZeusTransformUtils.preCheckCast(this.f35690a.get(r4), a.class, "com.obric.aiagent.plugin");
        if (r0 != null) goto L5;
        r0 = a.a();
        this.f35690a.put(r4, r0);
    L5:
        r0.f35695c = r5;
        r0.f35693a |= 8;
    }

    void e(RecyclerView.v r4) {
        a r0 = (a) ZeusTransformUtils.preCheckCast(this.f35690a.get(r4), a.class, "com.obric.aiagent.plugin");
        if (r0 != null) goto L5;
        r0 = a.a();
        this.f35690a.put(r4, r0);
    L5:
        r0.f35693a |= 1;
    }

    void f(RecyclerView.v r2) {
        a r1 = (a) ZeusTransformUtils.preCheckCast(this.f35690a.get(r2), a.class, "com.obric.aiagent.plugin");
        if (r1 != null) goto L5;
        return;
    L5:
        r1.f35693a &= -2;
    }

    void a(b r7) {
        b r8 = (b) ZeusTransformUtils.wrapperContextForParams(r7, b.class, "com.obric.aiagent.plugin");
        int r0 = this.f35690a.size() - 1;
    L3:
        if (r0 < 0) goto L27;
        RecyclerView.v r2 = (RecyclerView.v) ZeusTransformUtils.preCheckCast(this.f35690a.b(r0), RecyclerView.v.class, "com.obric.aiagent.plugin");
        a r3 = (a) ZeusTransformUtils.preCheckCast(this.f35690a.d(r0), a.class, "com.obric.aiagent.plugin");
        if ((r3.f35693a & 3) != 3) goto L8;
        r8.a(r2);
    L26:
        a.a(r3);
        r0 = r0 - 1;
        goto L3
    L8:
        if ((r3.f35693a & 1) == 0) goto L14;
        if (r3.f35694b != null) goto L12;
        r8.a(r2);
        goto L26
    L12:
        r8.a(r2, r3.f35694b, r3.f35695c);
        goto L26
    L14:
        if ((r3.f35693a & 14) != 14) goto L17;
        r8.b(r2, r3.f35694b, r3.f35695c);
        goto L26
    L17:
        if ((r3.f35693a & 12) != 12) goto L20;
        r8.c(r2, r3.f35694b, r3.f35695c);
        goto L26
    L20:
        if ((r3.f35693a & 4) == 0) goto L23;
        r8.a(r2, r3.f35694b, null);
        goto L26
    L23:
        if ((r3.f35693a & 8) == 0) goto L25;
        r8.b(r2, r3.f35694b, r3.f35695c);
        goto L26
    L25:
        int r4 = r3.f35693a;
        goto L26
    }

    void g(RecyclerView.v r3) {
        int r0 = this.f35691b.b() - 1;
    L3:
        if (r0 < 0) goto L8;
        if (r3 == this.f35691b.c(r0)) goto L6;
        r0 = r0 - 1;
        goto L3
    L6:
        this.f35691b.a(r0);
    L8:
        a r2 = (a) ZeusTransformUtils.preCheckCast(this.f35690a.remove(r3), a.class, "com.obric.aiagent.plugin");
        if (r2 == null) goto L14;
        a.a(r2);
        return;
    }

    void b() {
        a.b();
    }

    public void h(RecyclerView.v r1) {
        f(r1);
    }
}
