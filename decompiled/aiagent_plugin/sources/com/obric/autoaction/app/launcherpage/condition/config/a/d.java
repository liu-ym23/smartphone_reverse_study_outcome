package com.obric.autoaction.app.launcherpage.condition.config.a;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.activity.ComponentActivity;
import com.obric.aiagent.plugin.R;
import com.obric.autoaction.app.launcherpage.condition.config.condition.AutoCondition;
import com.obric.autoaction.app.launcherpage.ui.f;
import com.obric.autoaction.app.launcherpage.ui.g;
import com.obric.autoaction.app.launcherpage.ui.h;
import com.obric.oui.lisitem.OCardListItem;
import com.obric.oui.text.OTextView;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.p;
import d.h.b.o;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: ConditionListCell.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class d extends f<e> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private com.obric.autoaction.app.launcherpage.a.a f22950a;

    /* JADX INFO: renamed from: lambda$OGRht69vnVIUI00-xje07fcKCYY, reason: not valid java name */
    public static /* synthetic */ void m450lambda$OGRht69vnVIUI00xje07fcKCYY(d r0, c r1, View r2) {
        a(r0, r1, r2);
    }

    public static /* synthetic */ void lambda$PcCXdpx3TbsX4xZ97nLN0ysjS7A(d r0, c r1, OCardListItem r2, View r3) {
        b(r0, r1, r2, r3);
    }

    public static /* synthetic */ void lambda$pBbPyfOXWDZ6uPsiRjbn9MjsbHU(OTextView r0, OCardListItem r1, c r2) {
        a(r0, r1, r2);
    }

    public static /* synthetic */ void lambda$ybVKaW3_DeLnWXFu64SmUwWnAVg(d r0, c r1, OCardListItem r2, View r3) {
        a(r0, r1, r2, r3);
    }

    public d() {
    }

    @Override // com.obric.autoaction.app.launcherpage.ui.f
    public /* synthetic */ void a(h r3, List r4) {
        h r5 = (h) ZeusTransformUtils.wrapperContextForParams(r3, h.class, "com.obric.aiagent.plugin");
        List<? extends Object> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.aiagent.plugin");
        a((e) ZeusTransformUtils.preCheckCast(r5, e.class, "com.obric.aiagent.plugin"), r6);
    }

    private final com.obric.autoaction.app.launcherpage.condition.config.a I() {
        com.obric.autoaction.app.launcherpage.ui.d r3 = ((f) ZeusTransformUtils.preCheckCast(this, f.class, "com.obric.aiagent.plugin")).b();
        if (r3 == null) goto L10;
        g r4 = r3.b();
        if (r4 == null) goto L10;
        com.obric.autoaction.app.launcherpage.ui.c r5 = r4.a().get(com.obric.autoaction.app.launcherpage.condition.config.b.class);
        if (ZeusTransformUtils.instanceOf(r5, com.obric.autoaction.app.launcherpage.condition.config.b.class) == true) goto L9;
        r5 = null;
    L9:
        com.obric.autoaction.app.launcherpage.ui.c r6 = (com.obric.autoaction.app.launcherpage.ui.c) ZeusTransformUtils.preCheckCast((com.obric.autoaction.app.launcherpage.condition.config.b) ZeusTransformUtils.preCheckCast(r5, com.obric.autoaction.app.launcherpage.condition.config.b.class, "com.obric.aiagent.plugin"), com.obric.autoaction.app.launcherpage.ui.c.class, "com.obric.aiagent.plugin");
    L11:
        com.obric.autoaction.app.launcherpage.condition.config.b r7 = (com.obric.autoaction.app.launcherpage.condition.config.b) ZeusTransformUtils.preCheckCast(r6, com.obric.autoaction.app.launcherpage.condition.config.b.class, "com.obric.aiagent.plugin");
        if (r7 != null) goto L14;
        return null;
    L14:
        return r7.a();
    L10:
        r6 = null;
        goto L11
    }

    @Override // com.obric.autoaction.app.launcherpage.ui.f
    public View a(ViewGroup r4) {
        o.e(r4, "parent");
        com.obric.autoaction.app.launcherpage.a.a r5 = com.obric.autoaction.app.launcherpage.a.a.a(LayoutInflater.from((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r4.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")), r4, false);
        o.c(r5, "inflate(...)");
        this.f22950a = r5;
        if (r5 != null) goto L5;
        o.c("binding");
        r5 = null;
    L5:
        LinearLayout r3 = r5.b();
        o.c(r3, "getRoot(...)");
        return (View) ZeusTransformUtils.preCheckCast(r3, View.class, "com.obric.aiagent.plugin");
    }

    public void a(e r8, List<? extends Object> r9) {
        List<? extends Object> r10 = (List) ZeusTransformUtils.wrapperContextForParams(r9, List.class, "com.obric.aiagent.plugin");
        o.e(r8, "item");
        o.e(r10, "payloads");
        super.a((h) ZeusTransformUtils.preCheckCast(r8, h.class, "com.obric.aiagent.plugin"), r10);
        if (r8.a().isEmpty() == false) goto L5;
        return;
    L5:
        Context r11 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.f35660b.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        List r0 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.aiagent.plugin");
        Iterator r12 = ((Iterable) ZeusTransformUtils.preCheckCast(r8.a(), Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L7:
        if (r12.hasNext() == false) goto L10;
        c r2 = (c) ZeusTransformUtils.preCheckCast(r12.next(), c.class, "com.obric.aiagent.plugin");
        o.a(r11);
        r0.add(a(r11, r2));
        goto L7
    L10:
        if (r0.size() != 1) goto L12;
        OCardListItem.setCardPosition$default((OCardListItem) ZeusTransformUtils.preCheckCast(p.k(r0), OCardListItem.class, "com.obric.aiagent.plugin"), 0, false, 2, null);
    L17:
        com.obric.autoaction.app.launcherpage.a.a r13 = this.f22950a;
        if (r13 != null) goto L20;
        o.c("binding");
        r13 = null;
    L20:
        r13.f22699a.removeAllViews();
        Iterator r14 = ((Iterable) ZeusTransformUtils.preCheckCast(r0, Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L22:
        if (r14.hasNext() == false) goto L27;
        OCardListItem r1 = (OCardListItem) ZeusTransformUtils.preCheckCast(r14.next(), OCardListItem.class, "com.obric.aiagent.plugin");
        com.obric.autoaction.app.launcherpage.a.a r3 = this.f22950a;
        if (r3 != null) goto L26;
        o.c("binding");
        r3 = null;
    L26:
        r3.f22699a.addView((View) ZeusTransformUtils.preCheckCast(r1, View.class, "com.obric.aiagent.plugin"));
        goto L22
    L27:
        return;
    L12:
        Iterator r15 = ((Iterable) ZeusTransformUtils.preCheckCast(r0, Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L14:
        if (r15.hasNext() == false) goto L16;
        OCardListItem.setCardPosition$default((OCardListItem) ZeusTransformUtils.preCheckCast(r15.next(), OCardListItem.class, "com.obric.aiagent.plugin"), 2, false, 2, null);
        goto L14
    L16:
        OCardListItem.setCardPosition$default((OCardListItem) ZeusTransformUtils.preCheckCast(p.k(r0), OCardListItem.class, "com.obric.aiagent.plugin"), 1, false, 2, null);
        OCardListItem.setCardPosition$default((OCardListItem) ZeusTransformUtils.preCheckCast(p.m(r0), OCardListItem.class, "com.obric.aiagent.plugin"), 3, false, 2, null);
        goto L17
    }

    private final OCardListItem a(Context r12, final c r13) {
        final OCardListItem r14 = new OCardListItem((Context) ZeusTransformUtils.wrapperContextForParams(r12, Context.class, "com.obric.aiagent.plugin"), null, 0, 6, null);
        r14.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        r14.showTailIcon(true);
        if (r13.b() == false) goto L5;
        r14.setTailIcon(ZeusTransformUtils.mapRes(R.drawable.ic_delete, "drawable", "ic_delete"));
        ImageView r2 = r14.getTailIconView();
        View r4 = (View) ZeusTransformUtils.preCheckCast(r2, View.class, "com.obric.aiagent.plugin");
        int r3 = com.obric.oui.common.util.g.a((View) ZeusTransformUtils.preCheckCast(r2, View.class, "com.obric.aiagent.plugin"), 7);
        r4.setPadding(r3, r3, r3, r3);
        r2.setClickable(true);
        r2.setOnClickListener(new $$Lambda$d$OGRht69vnVIUI00xje07fcKCYY(this, r13));
    L6:
        final OTextView r5 = r14.getTitleView();
        r5.setTextAppearance(ZeusTransformUtils.mapRes(R.style.Title_1_Regular, "style", "Title_1_Regular"));
        r5.setLineSpacing(TypedValue.applyDimension(1, 14, Resources.getSystem().getDisplayMetrics()), 1.0f);
        View r6 = (View) ZeusTransformUtils.preCheckCast(r5, View.class, "com.obric.aiagent.plugin");
        float r7 = 11;
        r6.setPadding(r6.getPaddingLeft(), d.i.a.a(TypedValue.applyDimension(1, r7, Resources.getSystem().getDisplayMetrics())), r6.getPaddingRight(), d.i.a.a(TypedValue.applyDimension(1, r7, Resources.getSystem().getDisplayMetrics())));
        ViewParent r8 = r5.getParent();
        View r9 = (View) ZeusTransformUtils.preCheckCast(r5, View.class, "com.obric.aiagent.plugin");
        int r10 = 0;
    L8:
        if (ZeusTransformUtils.instanceOf(r8, View.class) == false) goto L33;
        if (o.a(r9, r14) == true) goto L33;
        if (r9 == null) goto L33;
        ViewGroup.LayoutParams r11 = r9.getLayoutParams();
        if (ZeusTransformUtils.instanceOf(r11, ViewGroup.MarginLayoutParams.class) == false) goto L15;
        ViewGroup.MarginLayoutParams r15 = (ViewGroup.MarginLayoutParams) ZeusTransformUtils.preCheckCast(r11, ViewGroup.MarginLayoutParams.class, "com.obric.aiagent.plugin");
    L16:
        if (r15 == null) goto L18;
        int r16 = r15.leftMargin;
    L19:
        ViewGroup.LayoutParams r17 = r9.getLayoutParams();
        if (ZeusTransformUtils.instanceOf(r17, ViewGroup.MarginLayoutParams.class) == false) goto L22;
        ViewGroup.MarginLayoutParams r18 = (ViewGroup.MarginLayoutParams) ZeusTransformUtils.preCheckCast(r17, ViewGroup.MarginLayoutParams.class, "com.obric.aiagent.plugin");
    L23:
        if (r18 == null) goto L25;
        int r19 = r18.rightMargin;
    L26:
        r10 = r10 + (((r16 + r19) + r9.getPaddingLeft()) + r9.getPaddingRight());
        if (ZeusTransformUtils.instanceOf(r8, View.class) == false) goto L29;
        r9 = (View) ZeusTransformUtils.preCheckCast(r8, View.class, "com.obric.aiagent.plugin");
    L30:
        if (r9 != null) goto L31;
        r8 = null;
        goto L8
    L31:
        r8 = r9.getParent();
        goto L8
    L29:
        r9 = null;
        goto L30
    L25:
        r19 = 0;
        goto L26
    L22:
        r18 = null;
        goto L23
    L18:
        r16 = 0;
        goto L19
    L15:
        r15 = null;
    L33:
        r14.setTitle((CharSequence) ZeusTransformUtils.preCheckCast(r13.c().invoke(Integer.valueOf((ZeusTransformUtils.getResources(r14, "com.obric.aiagent.plugin").getDisplayMetrics().widthPixels - r10) - d.i.a.a(TypedValue.applyDimension(1, 30, Resources.getSystem().getDisplayMetrics())))), CharSequence.class, "com.obric.aiagent.plugin"));
        r5.post(new $$Lambda$d$pBbPyfOXWDZ6uPsiRjbn9MjsbHU(r5, r14, r13));
        r14.setOnContentClickListener(new $$Lambda$d$PcCXdpx3TbsX4xZ97nLN0ysjS7A(this, r13, r14));
        View r110 = (View) ZeusTransformUtils.preCheckCast(r14.getTitleContainer(), View.class, "com.obric.aiagent.plugin");
        r110.setPadding(r110.getPaddingLeft(), 0, r110.getPaddingRight(), 0);
        return r14;
    L5:
        r14.setTailIcon(ZeusTransformUtils.mapRes(R.drawable.oic_plus_small, "drawable", "oic_plus_small"));
        ImageView r20 = r14.getTailIconView();
        View r21 = (View) ZeusTransformUtils.preCheckCast(r20, View.class, "com.obric.aiagent.plugin");
        int r22 = com.obric.oui.common.util.g.a((View) ZeusTransformUtils.preCheckCast(r20, View.class, "com.obric.aiagent.plugin"), 7);
        r21.setPadding(r22, r22, r22, r22);
        r20.setClickable(true);
        r20.setOnClickListener(new $$Lambda$d$ybVKaW3_DeLnWXFu64SmUwWnAVg(this, r13, r14));
        goto L6
    }

    private static final void a(d r2, c r3, View r4) {
        com.obric.autoaction.app.launcherpage.condition.config.a r5 = r2.I();
        if (r5 == null) goto L9;
        Class<? extends AutoCondition> r6 = r3.a();
        Context r7 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r2.f35660b.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        o.c(r7, "getContext(...)");
        ComponentActivity r8 = (ComponentActivity) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(com.obric.autoaction.app.launcherpage.ui.e.a(r7), "com.obric.aiagent.plugin"), ComponentActivity.class, "com.obric.aiagent.plugin");
        if (r8 != null) goto L7;
        return;
    L7:
        r5.a(r6, (Activity) ZeusTransformUtils.preCheckCast(r8, Activity.class, "com.obric.aiagent.plugin"));
        return;
    }

    private static final void a(d r2, c r3, OCardListItem r4, View r5) {
        com.obric.autoaction.app.launcherpage.condition.config.a r6 = r2.I();
        if (r6 == null) goto L9;
        Class<? extends AutoCondition> r7 = r3.a();
        Context r8 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r2.f35660b.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        o.c(r8, "getContext(...)");
        ComponentActivity r9 = (ComponentActivity) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(com.obric.autoaction.app.launcherpage.ui.e.a(r8), "com.obric.aiagent.plugin"), ComponentActivity.class, "com.obric.aiagent.plugin");
        if (r9 != null) goto L7;
        return;
    L7:
        r6.a(r7, (Activity) ZeusTransformUtils.preCheckCast(r9, Activity.class, "com.obric.aiagent.plugin"), (View) ZeusTransformUtils.preCheckCast(r4, View.class, "com.obric.aiagent.plugin"));
        return;
    }

    private static final void a(OTextView r3, OCardListItem r4, c r5) {
        if (r3.getLineCount() <= 1) goto L6;
        r4.setTitle((CharSequence) ZeusTransformUtils.preCheckCast(r5.c().invoke(Integer.valueOf(r3.getWidth() - d.i.a.a(TypedValue.applyDimension(1, 30, Resources.getSystem().getDisplayMetrics())))), CharSequence.class, "com.obric.aiagent.plugin"));
        return;
    }

    private static final void b(d r2, c r3, OCardListItem r4, View r5) {
        com.obric.autoaction.app.launcherpage.condition.config.a r6 = r2.I();
        if (r6 == null) goto L9;
        Class<? extends AutoCondition> r7 = r3.a();
        Context r8 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r2.f35660b.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        o.c(r8, "getContext(...)");
        ComponentActivity r9 = (ComponentActivity) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(com.obric.autoaction.app.launcherpage.ui.e.a(r8), "com.obric.aiagent.plugin"), ComponentActivity.class, "com.obric.aiagent.plugin");
        if (r9 != null) goto L7;
        return;
    L7:
        r6.a(r7, (Activity) ZeusTransformUtils.preCheckCast(r9, Activity.class, "com.obric.aiagent.plugin"), (View) ZeusTransformUtils.preCheckCast(r4, View.class, "com.obric.aiagent.plugin"));
        return;
    }
}
