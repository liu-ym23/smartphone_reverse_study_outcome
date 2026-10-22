package com.obric.oui.orecyclerview.widget;

import android.view.ViewGroup;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: NestedAdapterWrapper.java */
/* JADX INFO: loaded from: classes4.dex */
class r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final RecyclerView.a<RecyclerView.v> f35826a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final a f35827b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    int f35828c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final ab.c f35829d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final y.d f35830e;
    private RecyclerView.b f;

    /* JADX INFO: compiled from: NestedAdapterWrapper.java */
    interface a {
        void a(r r1);

        void a(r r1, int r2, int r3);

        void a(r r1, int r2, int r3, Object r4);

        void b(r r1);

        void b(r r1, int r2, int r3);

        void c(r r1, int r2, int r3);
    }

    r(RecyclerView.a<RecyclerView.v> r3, a r4, ab r5, y.d r6) {
        a r7 = (a) ZeusTransformUtils.wrapperContextForParams(r4, a.class, "com.obric.aiagent.plugin");
        ab r8 = (ab) ZeusTransformUtils.wrapperContextForParams(r5, ab.class, "com.obric.aiagent.plugin");
        y.d r9 = (y.d) ZeusTransformUtils.wrapperContextForParams(r6, y.d.class, "com.obric.aiagent.plugin");
        this.f = new AnonymousClass1(this);
        this.f35826a = r3;
        this.f35827b = r7;
        this.f35829d = r8.a(this);
        this.f35830e = r9;
        this.f35828c = r3.a();
        r3.a(this.f);
    }

    int a() {
        return this.f35828c;
    }

    int a(int r2) {
        return this.f35829d.a(this.f35826a.a(r2));
    }

    RecyclerView.v a(ViewGroup r2, int r3) {
        int r4 = this.f35829d.b(r3);
        return this.f35826a.b(r2, r4);
    }

    void a(RecyclerView.v r1, int r2) {
        this.f35826a.b(r1, r2);
    }

    public long b(int r3) {
        long r0 = this.f35826a.a_(r3);
        return this.f35830e.a(r0);
    }
}
