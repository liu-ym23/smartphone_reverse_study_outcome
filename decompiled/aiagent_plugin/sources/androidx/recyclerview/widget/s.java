package androidx.recyclerview.widget;

import android.view.ViewGroup;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: NestedAdapterWrapper.java */
/* JADX INFO: loaded from: classes.dex */
class s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final RecyclerView.a<RecyclerView.u> f2576a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final a f2577b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    int f2578c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final ad.c f2579d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final aa.d f2580e;
    private RecyclerView.b f;

    /* JADX INFO: compiled from: NestedAdapterWrapper.java */
    interface a {
        void a(s r1);

        void a(s r1, int r2, int r3);

        void a(s r1, int r2, int r3, Object r4);

        void b(s r1);

        void b(s r1, int r2, int r3);

        void c(s r1, int r2, int r3);
    }

    s(RecyclerView.a<RecyclerView.u> r3, a r4, ad r5, aa.d r6) {
        a r7 = (a) ZeusTransformUtils.wrapperContextForParams(r4, a.class, "com.obric.aiagent.plugin");
        ad r8 = (ad) ZeusTransformUtils.wrapperContextForParams(r5, ad.class, "com.obric.aiagent.plugin");
        aa.d r9 = (aa.d) ZeusTransformUtils.wrapperContextForParams(r6, aa.d.class, "com.obric.aiagent.plugin");
        this.f = new AnonymousClass1(this);
        this.f2576a = r3;
        this.f2577b = r7;
        this.f2579d = r8.a(this);
        this.f2580e = r9;
        this.f2578c = r3.a();
        r3.a(this.f);
    }

    int a() {
        return this.f2578c;
    }

    int a(int r2) {
        return this.f2579d.a(this.f2576a.a(r2));
    }

    RecyclerView.u a(ViewGroup r2, int r3) {
        int r4 = this.f2579d.b(r3);
        return this.f2576a.a(r2, r4);
    }

    void a(RecyclerView.u r1, int r2) {
        this.f2576a.b(r1, r2);
    }

    public long b(int r3) {
        long r0 = this.f2576a.b(r3);
        return this.f2580e.a(r0);
    }
}
