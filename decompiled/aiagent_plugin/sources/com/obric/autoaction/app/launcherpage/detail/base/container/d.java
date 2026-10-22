package com.obric.autoaction.app.launcherpage.detail.base.container;

import android.content.Context;
import android.content.res.Resources;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.appcompat.app.AppCompatActivity;
import com.bytedance.common.wschannel.WsChannelMultiProcessSharedProvider;
import com.obric.aiagent.plugin.R;
import com.obric.autoaction.app.launcherpage.condition.config.ConditionConfigureDialogFragment;
import com.obric.autoaction.app.launcherpage.condition.config.ConditionConfigureResult;
import com.obric.autoaction.app.launcherpage.condition.config.condition.AutoCondition;
import com.obric.eventkit.task.model.ConditionGroup;
import com.obric.eventkit.task.model.ConditionTask;
import com.obric.eventkit.task.model.EventTask;
import com.obric.oui.lisitem.OCardListItem;
import com.obric.oui.sectiontitlebar.OSectionSupportiveText;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Collection;
import java.util.List;
import kotlinx.coroutines.am;
import kotlinx.coroutines.bd;

/* JADX INFO: compiled from: DetailConfigViewContainer.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class d extends z<c> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final boolean f23305a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private com.obric.autoaction.app.launcherpage.a.e f23306b;

    /* JADX INFO: compiled from: DetailConfigViewContainer.kt */
    @d.c.b.a.f(b = "DetailConfigViewContainer.kt", c = {77}, d = "invokeSuspend", e = "com.obric.autoaction.app.launcherpage.detail.base.container.DetailConfigViewContainer$bindBusiness$1$1")
    static final class a extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super d.x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f23307a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ AppCompatActivity f23308b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ d f23309c;

        a(AppCompatActivity r3, d r4, d.c.d<? super a> r5) {
            AppCompatActivity r6 = (AppCompatActivity) ZeusTransformUtils.wrapperContextForParams(r3, AppCompatActivity.class, "com.obric.aiagent.plugin");
            d.c.d r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            this.f23308b = r6;
            this.f23309c = r4;
            super(2, r7);
        }

        public final Object a(am r3, d.c.d<? super d.x> r4) {
            return ((a) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), a.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<d.x> create(Object r3, d.c.d<?> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new a(this.f23308b, this.f23309c, r5), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super d.x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r7) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f23307a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            d.o.a(r7);
        L11:
            ConditionConfigureResult r8 = (ConditionConfigureResult) ZeusTransformUtils.preCheckCast(r7, ConditionConfigureResult.class, "com.obric.aiagent.plugin");
            if (r8 == null) goto L17;
            d.a(this.f23309c, r8.getCondition());
            d.b(this.f23309c);
            com.obric.autoaction.app.launcherpage.detail.base.a r9 = this.f23309c.getContext();
            if (r9 == null) goto L17;
            r9.a((com.obric.autoaction.app.launcherpage.detail.base.h) ZeusTransformUtils.preCheckCast(new com.obric.autoaction.app.launcherpage.detail.base.j.d(d.a(this.f23309c)), com.obric.autoaction.app.launcherpage.detail.base.h.class, "com.obric.aiagent.plugin"));
        L17:
            return d.x.f38692a;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            d.o.a(r7);
            ConditionConfigureDialogFragment.a r10 = ConditionConfigureDialogFragment.Companion;
            AppCompatActivity r2 = this.f23308b;
            List<? extends AutoCondition> r4 = d.a(this.f23309c);
            d.c.d<? super ConditionConfigureResult> r5 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f23307a = 1;
            r7 = r10.a(r2, r4, r5);
            if (r7 != r0) goto L11;
            return r0;
        }
    }

    public d() {
        this(false, 1, null);
    }

    /* JADX INFO: renamed from: lambda$mNdKbvGpo5w38r2hbOHnFohH-jU, reason: not valid java name */
    public static /* synthetic */ void m473lambda$mNdKbvGpo5w38r2hbOHnFohHjU(d r0, View r1) {
        a(r0, r1);
    }

    public /* synthetic */ d(boolean r1, int r2, d.h.b.h r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = false;
    L5:
        this(r1);
    }

    public static final /* synthetic */ List a(d r0) {
        return r0.i();
    }

    public static final /* synthetic */ void a(d r2, List r3) {
        r2.a((List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin"));
    }

    public static final /* synthetic */ void b(d r0) {
        r0.l();
    }

    @Override // com.obric.autoaction.app.launcherpage.detail.base.container.z
    public /* synthetic */ com.obric.autoaction.app.launcherpage.detail.base.f b(com.obric.autoaction.app.launcherpage.detail.base.a r2) {
        return (com.obric.autoaction.app.launcherpage.detail.base.f) ZeusTransformUtils.preCheckCast(a(r2), com.obric.autoaction.app.launcherpage.detail.base.f.class, "com.obric.aiagent.plugin");
    }

    public d(boolean r1) {
        this.f23305a = r1;
    }

    private final List<AutoCondition> i() {
        return ((c) ZeusTransformUtils.preCheckCast(f(), c.class, "com.obric.aiagent.plugin")).a();
    }

    private final void a(List<? extends AutoCondition> r3) {
        List<? extends AutoCondition> r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
        ((c) ZeusTransformUtils.preCheckCast(f(), c.class, "com.obric.aiagent.plugin")).a(r4);
    }

    @Override // com.obric.autoaction.app.launcherpage.detail.base.container.z
    public View a(ViewGroup r4) {
        d.h.b.o.e(r4, "parent");
        com.obric.autoaction.app.launcherpage.a.e r5 = com.obric.autoaction.app.launcherpage.a.e.a(LayoutInflater.from((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r4.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")), r4, false);
        d.h.b.o.c(r5, "inflate(...)");
        this.f23306b = r5;
        if (r5 != null) goto L5;
        d.h.b.o.c("binding");
        r5 = null;
    L5:
        LinearLayout r3 = r5.b();
        d.h.b.o.c(r3, "getRoot(...)");
        return (View) ZeusTransformUtils.preCheckCast(r3, View.class, "com.obric.aiagent.plugin");
    }

    public c a(com.obric.autoaction.app.launcherpage.detail.base.a r5) {
        d.h.b.o.e(r5, "context");
        EventTask r6 = r5.c().a();
        List<AutoCondition> r2 = null;
        if (ZeusTransformUtils.instanceOf(r6, ConditionTask.class) == false) goto L5;
        ConditionTask r7 = (ConditionTask) ZeusTransformUtils.preCheckCast(r6, ConditionTask.class, "com.obric.aiagent.plugin");
    L6:
        if (r7 == null) goto L10;
        ConditionGroup r8 = r7.getConditions();
        if (r8 == null) goto L10;
        r2 = com.obric.autoaction.app.launcherpage.condition.a.a.a(r8);
    L10:
        if (r2 != null) goto L13;
        r2 = d.a.p.b();
    L13:
        return new c(r2, this.f23305a);
    L5:
        r7 = null;
        goto L6
    }

    @Override // com.obric.autoaction.app.launcherpage.detail.base.container.z
    public void a() {
        k();
    }

    @Override // com.obric.autoaction.app.launcherpage.detail.base.container.z
    public void b() {
        j();
    }

    private final void j() {
        l();
        com.obric.autoaction.app.launcherpage.a.e r1 = null;
        if (this.f23305a == false) goto L9;
        com.obric.autoaction.app.launcherpage.a.e r5 = this.f23306b;
        if (r5 != null) goto L7;
        d.h.b.o.c("binding");
    L8:
        OSectionSupportiveText r6 = r1.f22810a;
        d.h.b.o.c(r6, "bottomTip");
        com.obric.oui.common.util.k.a((View) ZeusTransformUtils.preCheckCast(r6, View.class, "com.obric.aiagent.plugin"));
        return;
    L7:
        r1 = r5;
        goto L8
    L9:
        com.obric.autoaction.app.launcherpage.a.e r7 = this.f23306b;
        if (r7 != null) goto L12;
        d.h.b.o.c("binding");
    L13:
        OSectionSupportiveText r8 = r1.f22810a;
        d.h.b.o.c(r8, "bottomTip");
        com.obric.oui.common.util.k.b((View) ZeusTransformUtils.preCheckCast(r8, View.class, "com.obric.aiagent.plugin"));
        return;
    L12:
        r1 = r7;
        goto L13
    }

    private final void k() {
        com.obric.autoaction.app.launcherpage.a.e r0 = this.f23306b;
        if (r0 != null) goto L5;
        d.h.b.o.c("binding");
        r0 = null;
    L5:
        r0.f22811b.setOnContentClickListener(new $$Lambda$d$mNdKbvGpo5w38r2hbOHnFohHjU(this));
    }

    private static final void a(d r9, View r10) {
        com.obric.autoaction.app.launcherpage.a.e r11 = r9.f23306b;
        if (r11 != null) goto L5;
        d.h.b.o.c("binding");
        r11 = null;
    L5:
        Context r12 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r11.b().getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r12, AppCompatActivity.class) == false) goto L8;
        AppCompatActivity r13 = (AppCompatActivity) ZeusTransformUtils.preCheckCast(r12, AppCompatActivity.class, "com.obric.aiagent.plugin");
    L9:
        if (r13 != null) goto L11;
        return;
    L11:
        kotlinx.coroutines.i.a((am) ZeusTransformUtils.preCheckCast(androidx.lifecycle.q.a((androidx.lifecycle.p) ZeusTransformUtils.preCheckCast(r13, androidx.lifecycle.p.class, "com.obric.aiagent.plugin")), am.class, "com.obric.aiagent.plugin"), (d.c.g) ZeusTransformUtils.preCheckCast(bd.b(), d.c.g.class, "com.obric.aiagent.plugin"), null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new a(r13, r9, null), d.h.a.m.class, "com.obric.aiagent.plugin"), 2, null);
        return;
    L8:
        r13 = null;
        goto L9
    }

    private final void l() {
        com.obric.autoaction.app.launcherpage.a.e r0 = this.f23306b;
        com.obric.autoaction.app.launcherpage.a.e r2 = null;
        if (r0 != null) goto L5;
        d.h.b.o.c("binding");
        r0 = null;
    L5:
        OCardListItem r1 = r0.f22811b;
        d.h.b.o.c(r1, "conditionEventTriggerCondition");
        if ((!((Collection) ZeusTransformUtils.preCheckCast(i(), Collection.class, "com.obric.aiagent.plugin")).isEmpty()) == false) goto L12;
        r1.setDefaultTailIcon(0);
        r1.showTailIcon(true);
        List<AutoCondition> r3 = i();
        com.obric.autoaction.app.launcherpage.a.e r14 = this.f23306b;
        if (r14 != null) goto L10;
        d.h.b.o.c("binding");
    L11:
        Context r15 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r2.b().getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        d.h.b.o.c(r15, "getContext(...)");
        r1.setSubTitle((CharSequence) ZeusTransformUtils.preCheckCast(com.obric.autoaction.app.launcherpage.condition.a.a.a(r3, r15), CharSequence.class, "com.obric.aiagent.plugin"));
        com.obric.autoaction.app.launcherpage.utils.p.a((View) ZeusTransformUtils.preCheckCast(r1.getSubTitleView(), View.class, "com.obric.aiagent.plugin"), 0, d.i.a.a(TypedValue.applyDimension(1, 4, Resources.getSystem().getDisplayMetrics())), 0, 0, 13, null);
        r1.showCustomEnd(false);
        r1.showSubTitle(true);
        return;
    L10:
        r2 = r14;
        goto L11
    L12:
        r1.setDefaultTailIcon(0);
        r1.showTailIcon(true);
        r1.showSubTitle(false);
        r1.showCustomEnd(true);
        r1.setDefaultCustomEndView(3);
        OCardListItem.setEndDetailText$default(r1, (CharSequence) ZeusTransformUtils.preCheckCast(com.obric.autoaction.app.launcherpage.utils.p.a(ZeusTransformUtils.mapRes(R.string.condition_event_go_add_condition, WsChannelMultiProcessSharedProvider.STRING_TYPE, "condition_event_go_add_condition"), null, 1, null), CharSequence.class, "com.obric.aiagent.plugin"), 0, 2, null);
    }
}
