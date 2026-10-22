package com.obric.oui.orecyclerview.widget;

import com.obric.oui.orecyclerview.widget.RecyclerView.v;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;

/* JADX INFO: compiled from: ListAdapter.java */
/* JADX INFO: loaded from: classes4.dex */
public abstract class p<T, VH extends RecyclerView.v> extends RecyclerView.a<VH> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final d.a<T> f35823a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final d<T> f35824b;

    public void a(List<T> r2, List<T> r3) {
        List r1 = (List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.aiagent.plugin");
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
    }

    public p(j.e<T> r5) {
        d.a<T> r0 = new AnonymousClass1(this);
        this.f35823a = r0;
        d<T> r1 = new d(new b(this), new c.a(r5).a());
        this.f35824b = r1;
        r1.a(r0);
    }

    public void b(List<T> r3) {
        List<T> r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
        this.f35824b.a(r4);
    }

    public T c(int r1) {
        return this.f35824b.a().get(r1);
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.a
    public int a() {
        return this.f35824b.a().size();
    }
}
