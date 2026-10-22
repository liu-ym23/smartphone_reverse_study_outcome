package com.obric.agent.trace.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.q;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;

/* JADX INFO: compiled from: IntentListAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class f extends q<j, g> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private i f15430b;

    public void a(g r1, int r2) {
        o.e(r1, "holder");
    }

    @Override // androidx.recyclerview.widget.RecyclerView.a
    public /* synthetic */ RecyclerView.u a(ViewGroup r1, int r2) {
        return (RecyclerView.u) ZeusTransformUtils.preCheckCast(c(r1, r2), RecyclerView.u.class, "com.obric.aiagent.plugin");
    }

    @Override // androidx.recyclerview.widget.RecyclerView.a
    public /* synthetic */ void a(RecyclerView.u r3, int r4) {
        a((g) ZeusTransformUtils.preCheckCast(r3, g.class, "com.obric.aiagent.plugin"), r4);
    }

    public f() {
        super((androidx.recyclerview.widget.j.e) ZeusTransformUtils.preCheckCast(new h(), androidx.recyclerview.widget.j.e.class, "com.obric.aiagent.plugin"));
    }

    public final void a(i r3) {
        this.f15430b = (i) ZeusTransformUtils.wrapperContextForParams(r3, i.class, "com.obric.aiagent.plugin");
    }

    public g c(ViewGroup r2, int r3) {
        o.e(r2, "parent");
        com.obric.agent.c.b r1 = com.obric.agent.c.b.a(LayoutInflater.from((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r2.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")), r2, false);
        o.c(r1, "inflate(...)");
        return new g(r1);
    }
}
