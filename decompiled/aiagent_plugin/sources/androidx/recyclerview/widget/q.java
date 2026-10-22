package androidx.recyclerview.widget;

import androidx.recyclerview.widget.RecyclerView.u;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;

/* JADX INFO: compiled from: ListAdapter.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class q<T, VH extends RecyclerView.u> extends RecyclerView.a<VH> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final d<T> f2573a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final d.a<T> f2574b;

    public void a(List<T> r2, List<T> r3) {
        List r1 = (List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.aiagent.plugin");
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
    }

    public q(j.e<T> r5) {
        d.a<T> r0 = new AnonymousClass1(this);
        this.f2574b = r0;
        d<T> r1 = new d(new b(this), new c.a(r5).a());
        this.f2573a = r1;
        r1.a(r0);
    }

    public void a(List<T> r3) {
        List<T> r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
        this.f2573a.a(r4);
    }

    public void a(List<T> r3, Runnable r4) {
        List<T> r5 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
        Runnable r6 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r4, Runnable.class, "com.obric.aiagent.plugin");
        this.f2573a.a(r5, r6);
    }

    public T c(int r1) {
        return this.f2573a.a().get(r1);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.a
    public int a() {
        return this.f2573a.a().size();
    }
}
