package com.obric.aiagent.skill.manager.impl.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentActivity;
import com.obric.aiagent.plugin.R;
import com.obric.aiagent.skill.manager.api.ISkillManagerService;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: SkillGatedActivity.kt */
/* JADX INFO: loaded from: classes3.dex */
final class bl {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final FragmentActivity f20651a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private ViewGroup f20652b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private View f20653c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private d.h.a.b<? super ISkillManagerService, d.x> f20654d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private List<? extends d.m<? extends View, Integer>> f20655e;
    private boolean f;
    private boolean g;
    private boolean h;

    /* JADX INFO: renamed from: lambda$7tI-_uPtmaarzkLhkVcUgJZrmgk, reason: not valid java name */
    public static /* synthetic */ d.m m338lambda$7tI_uPtmaarzkLhkVcUgJZrmgk(View r0) {
        return a(r0);
    }

    public bl(FragmentActivity r3) {
        FragmentActivity r4 = (FragmentActivity) ZeusTransformUtils.wrapperContextForParams(r3, FragmentActivity.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r4, "activity");
        this.f20651a = r4;
        this.f20655e = d.a.p.b();
    }

    public final boolean a() {
        return this.g;
    }

    public final boolean b() {
        return this.h;
    }

    public final void a(ViewGroup r5, d.h.a.b<? super ISkillManagerService, d.x> r6) {
        d.h.a.b<? super ISkillManagerService, d.x> r7 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r6, d.h.a.b.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r5, "root");
        d.h.b.o.e(r7, "initializeContent");
        if (this.f20652b == null) goto L5;
        return;
    L5:
        this.f20652b = r5;
        this.f20654d = r7;
        this.f20655e = d.n.m.g(d.n.m.d(androidx.core.view.ab.b(r5), $$Lambda$bl$7tI_uPtmaarzkLhkVcUgJZrmgk.INSTANCE));
        View r8 = ZeusTransformUtils.inflate(LayoutInflater.from((Context) ZeusTransformUtils.preCheckCast(this.f20651a, Context.class, "com.obric.aiagent.plugin")), ZeusTransformUtils.mapRes(R.layout.view_skill_feature_unavailable, "layout", "view_skill_feature_unavailable"), r5, false, "com.obric.aiagent.plugin");
        r8.setVisibility(8);
        r5.addView(r8);
        this.f20653c = r8;
        c();
    }

    private static final d.m a(View r1) {
        d.h.b.o.e(r1, "child");
        return d.s.a(r1, Integer.valueOf(r1.getVisibility()));
    }

    public final void c() {
        bn r0 = bm.f20656a.a((Context) ZeusTransformUtils.preCheckCast(this.f20651a, Context.class, "com.obric.aiagent.plugin"));
        if (r0.a() == true) goto L14;
        this.g = false;
        d();
        if (this.h == true) goto L7;
        return;
    L7:
        if (this.f == false) goto L9;
        return;
    L9:
        if (this.f20651a.isFinishing() == false) goto L11;
        return;
    L11:
        if (this.f20651a.isDestroyed() == true) goto L27;
        this.f = true;
        this.f20651a.recreate();
        return;
    L27:
        return;
    L14:
        ISkillManagerService r1 = r0.b();
        if (r1 != null) goto L18;
        bl r5 = (bl) ZeusTransformUtils.preCheckCast(this, bl.class, "com.obric.aiagent.plugin");
        r5.g = false;
        r5.d();
        return;
    L18:
        this.g = true;
        e();
        if (this.h == true) goto L28;
        this.h = true;
        d.h.a.b<? super ISkillManagerService, d.x> r6 = this.f20654d;
        if (r6 == null) goto L29;
        r6.invoke(r1);
        return;
    L29:
        return;
    }

    private final void d() {
        Iterator r0 = ((Iterable) ZeusTransformUtils.preCheckCast(this.f20655e, Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((View) ZeusTransformUtils.preCheckCast(((d.m) ZeusTransformUtils.preCheckCast(r0.next(), d.m.class, "com.obric.aiagent.plugin")).c(), View.class, "com.obric.aiagent.plugin")).setVisibility(8);
        goto L4
    L6:
        View r4 = this.f20653c;
        if (r4 == null) goto L11;
        r4.setVisibility(0);
        return;
    }

    private final void e() {
        Iterator r0 = ((Iterable) ZeusTransformUtils.preCheckCast(this.f20655e, Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        d.m r1 = (d.m) ZeusTransformUtils.preCheckCast(r0.next(), d.m.class, "com.obric.aiagent.plugin");
        ((View) ZeusTransformUtils.preCheckCast(r1.c(), View.class, "com.obric.aiagent.plugin")).setVisibility(((Number) ZeusTransformUtils.preCheckCast(r1.d(), Number.class, "com.obric.aiagent.plugin")).intValue());
        goto L4
    L6:
        View r5 = this.f20653c;
        if (r5 == null) goto L11;
        r5.setVisibility(8);
        return;
    }
}
