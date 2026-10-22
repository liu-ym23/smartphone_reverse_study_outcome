package com.obric.autoaction.app.launcherpage.donation;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.obric.autoaction.app.launcherpage.a.aq;
import com.obric.oui.lisitem.OCardListItem;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* JADX INFO: compiled from: QuestionSortAdapter.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class j extends RecyclerView.a<a> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List<com.obric.autoaction.app.launcherpage.donation.model.b> f23768a;

    /* JADX INFO: compiled from: QuestionSortAdapter.kt */
    public static final class a extends RecyclerView.u {
        private final aq r;
        private boolean s;

        public static /* synthetic */ void lambda$8hGMw88eXOtEhtqrWjLvoEBhI1w(a r0, View r1) {
            a(r0, r1);
        }

        public a(View r2) {
            o.e(r2, "itemView");
            super(r2);
            aq r3 = aq.a(r2);
            o.c(r3, "bind(...)");
            this.r = r3;
        }

        public final void a(com.obric.autoaction.app.launcherpage.donation.model.b r7) {
            o.e(r7, "questionSort");
            this.r.f22767a.setTitle((CharSequence) ZeusTransformUtils.preCheckCast(r7.a(), CharSequence.class, "com.obric.aiagent.plugin"));
            this.s = false;
            RecyclerView r0 = this.r.f22768b;
            i r1 = new i();
            r0.setLayoutManager((RecyclerView.h) ZeusTransformUtils.preCheckCast(new LinearLayoutManager((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.f2390a.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")), RecyclerView.h.class, "com.obric.aiagent.plugin"));
            r0.setAdapter((RecyclerView.a) ZeusTransformUtils.preCheckCast(r1, RecyclerView.a.class, "com.obric.aiagent.plugin"));
            r1.a(r7.b());
            this.r.f22767a.setOnContentClickListener(new $$Lambda$j$a$8hGMw88eXOtEhtqrWjLvoEBhI1w(this));
        }

        private static final void a(a r4, View r5) {
            if (r4.s == true) goto L5;
            r4.r.f22768b.setVisibility(0);
            OCardListItem.setCardPosition$default(r4.r.f22767a, 1, false, 2, null);
            r4.s = true;
            return;
        L5:
            r4.r.f22768b.setVisibility(8);
            OCardListItem.setCardPosition$default(r4.r.f22767a, 0, false, 2, null);
            r4.s = false;
        }
    }

    public j() {
        this.f23768a = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.aiagent.plugin");
    }

    @Override // androidx.recyclerview.widget.RecyclerView.a
    public /* synthetic */ RecyclerView.u a(ViewGroup r1, int r2) {
        return (RecyclerView.u) ZeusTransformUtils.preCheckCast(c(r1, r2), RecyclerView.u.class, "com.obric.aiagent.plugin");
    }

    @Override // androidx.recyclerview.widget.RecyclerView.a
    public /* synthetic */ void a(RecyclerView.u r3, int r4) {
        a((a) ZeusTransformUtils.preCheckCast(r3, a.class, "com.obric.aiagent.plugin"), r4);
    }

    public final void a(List<com.obric.autoaction.app.launcherpage.donation.model.b> r4) {
        List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.aiagent.plugin");
        o.e(r5, "data");
        this.f23768a.clear();
        this.f23768a.addAll((Collection) ZeusTransformUtils.preCheckCast(r5, Collection.class, "com.obric.aiagent.plugin"));
        d();
    }

    public a c(ViewGroup r2, int r3) {
        o.e(r2, "parent");
        aq r1 = aq.a(LayoutInflater.from((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r2.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")), r2, false);
        o.c(r1, "inflate(...)");
        ConstraintLayout r4 = r1.b();
        o.c(r4, "getRoot(...)");
        return new a((View) ZeusTransformUtils.preCheckCast(r4, View.class, "com.obric.aiagent.plugin"));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.a
    public int a() {
        return this.f23768a.size();
    }

    public void a(a r2, int r3) {
        o.e(r2, "holder");
        r2.a((com.obric.autoaction.app.launcherpage.donation.model.b) ZeusTransformUtils.preCheckCast(this.f23768a.get(r3), com.obric.autoaction.app.launcherpage.donation.model.b.class, "com.obric.aiagent.plugin"));
    }
}
