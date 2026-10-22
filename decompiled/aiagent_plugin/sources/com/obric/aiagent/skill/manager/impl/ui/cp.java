package com.obric.aiagent.skill.manager.impl.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.bytedance.bdturing.localstorage.DbHelper;
import com.obric.aiagent.plugin.R;
import com.obric.oui.orecyclerview.widget.RecyclerView;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;

/* JADX INFO: compiled from: SkillUsageExampleAdapter.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class cp extends RecyclerView.a<a> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final d.h.a.b<e, d.x> f20766a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final List<String> f20767b;

    /* JADX INFO: compiled from: SkillUsageExampleAdapter.kt */
    public static final class a extends RecyclerView.v {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final d.h.a.b<e, d.x> f20768a;
        private final TextView s;

        public a(View r4, d.h.a.b<? super e, d.x> r5) {
            d.h.a.b<e, d.x> r6 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r5, d.h.a.b.class, "com.obric.aiagent.plugin");
            d.h.b.o.e(r4, "itemView");
            super(r4);
            this.f20768a = r6;
            View r7 = r4.findViewById(ZeusTransformUtils.mapRes(R.id.example_text, DbHelper.COL_ID, "example_text"));
            d.h.b.o.c(r7, "findViewById(...)");
            this.s = (TextView) ZeusTransformUtils.preCheckCast(r7, TextView.class, "com.obric.aiagent.plugin");
        }

        public final void a(String r3) {
            d.h.b.o.e(r3, "example");
            View r0 = this.f35660b;
            d.h.b.o.c(r0, "itemView");
            cn.a(r0, this.s, r3, this.f20768a);
        }
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.a
    public /* synthetic */ void a(RecyclerView.v r3, int r4) {
        a((a) ZeusTransformUtils.preCheckCast(r3, a.class, "com.obric.aiagent.plugin"), r4);
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.a
    public /* synthetic */ RecyclerView.v b(ViewGroup r1, int r2) {
        return (RecyclerView.v) ZeusTransformUtils.preCheckCast(a(r1, r2), RecyclerView.v.class, "com.obric.aiagent.plugin");
    }

    public a a(ViewGroup r5, int r6) {
        d.h.b.o.e(r5, "parent");
        View r7 = ZeusTransformUtils.inflate(LayoutInflater.from((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r5.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")), ZeusTransformUtils.mapRes(R.layout.item_skill_usage_example, "layout", "item_skill_usage_example"), r5, false, "com.obric.aiagent.plugin");
        d.h.b.o.a(r7);
        return new a(r7, this.f20766a);
    }

    public void a(a r2, int r3) {
        d.h.b.o.e(r2, "holder");
        r2.a((String) ZeusTransformUtils.preCheckCast(this.f20767b.get(r3), String.class, "com.obric.aiagent.plugin"));
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.a
    public int a() {
        return this.f20767b.size();
    }
}
