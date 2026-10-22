package com.obric.aiagent.skill.manager.impl.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.obric.aiagent.plugin.R;
import com.obric.oui.orecyclerview.widget.RecyclerView;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: AppFunctionSkillUi.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class c extends RecyclerView.a<a> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f20702a;

    /* JADX INFO: compiled from: AppFunctionSkillUi.kt */
    public static final class a extends RecyclerView.v {
        public a(View r2) {
            d.h.b.o.e(r2, "itemView");
            super(r2);
        }
    }

    public void a(a r1, int r2) {
        d.h.b.o.e(r1, "holder");
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.a
    public /* synthetic */ void a(RecyclerView.v r3, int r4) {
        a((a) ZeusTransformUtils.preCheckCast(r3, a.class, "com.obric.aiagent.plugin"), r4);
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.a
    public /* synthetic */ RecyclerView.v b(ViewGroup r1, int r2) {
        return (RecyclerView.v) ZeusTransformUtils.preCheckCast(a(r1, r2), RecyclerView.v.class, "com.obric.aiagent.plugin");
    }

    public c() {
    }

    public final void a_(boolean r2) {
        if (this.f20702a != r2) goto L5;
        return;
    L5:
        this.f20702a = r2;
        if (r2 == false) goto L8;
        e(0);
        return;
    L8:
        f(0);
    }

    public a a(ViewGroup r5, int r6) {
        d.h.b.o.e(r5, "parent");
        View r7 = ZeusTransformUtils.inflate(LayoutInflater.from((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r5.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")), ZeusTransformUtils.mapRes(R.layout.item_app_function_skill_note, "layout", "item_app_function_skill_note"), r5, false, "com.obric.aiagent.plugin");
        d.h.b.o.c(r7, "inflate(...)");
        return new a(r7);
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.a
    public int a() {
        return this.f20702a ? 1 : 0;
    }
}
