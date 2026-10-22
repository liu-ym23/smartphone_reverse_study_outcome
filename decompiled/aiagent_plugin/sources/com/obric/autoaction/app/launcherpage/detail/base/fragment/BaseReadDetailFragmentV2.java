package com.obric.autoaction.app.launcherpage.detail.base.fragment;

import android.content.Context;
import android.view.View;
import androidx.lifecycle.q;
import com.obric.autoaction.app.launcherpage.detail.base.b.c;
import com.obric.autoaction.app.launcherpage.utils.p;
import com.obric.eventkit.task.model.EventTask;
import com.obric.oui.common.util.k;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.c.b.a.f;
import d.c.b.a.l;
import d.c.d;
import d.h.a.b;
import d.h.a.m;
import d.o;
import d.x;
import kotlinx.coroutines.am;
import kotlinx.coroutines.i;

/* JADX INFO: compiled from: BaseReadDetailFragmentV2.kt */
/* JADX INFO: loaded from: classes3.dex */
public abstract class BaseReadDetailFragmentV2 extends BaseDetailFragmentV2 {

    /* JADX INFO: compiled from: BaseReadDetailFragmentV2.kt */
    @f(b = "BaseReadDetailFragmentV2.kt", c = {61}, d = "invokeSuspend", e = "com.obric.autoaction.app.launcherpage.detail.base.fragment.BaseReadDetailFragmentV2$navigateToEditAndSync$1")
    static final class a extends l implements m<am, d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f23381a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ b<d<? super EventTask>, Object> f23382b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ BaseReadDetailFragmentV2 f23383c;

        a(b<? super d<? super EventTask>, ? extends Object> r3, BaseReadDetailFragmentV2 r4, d<? super a> r5) {
            b<d<? super EventTask>, Object> r6 = (b) ZeusTransformUtils.wrapperContextForParams(r3, b.class, "com.obric.aiagent.plugin");
            d r7 = (d) ZeusTransformUtils.wrapperContextForParams(r5, d.class, "com.obric.aiagent.plugin");
            this.f23382b = r6;
            this.f23383c = r4;
            super(2, r7);
        }

        public final Object a(am r3, d<? super x> r4) {
            return ((a) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d) ZeusTransformUtils.wrapperContextForParams(r4, d.class, "com.obric.aiagent.plugin")), a.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d<x> create(Object r3, d<?> r4) {
            d r5 = (d) ZeusTransformUtils.wrapperContextForParams(r4, d.class, "com.obric.aiagent.plugin");
            return (d) ZeusTransformUtils.preCheckCast(new a(this.f23382b, this.f23383c, r5), d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d<? super x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d) ZeusTransformUtils.preCheckCast(r4, d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r4) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f23381a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            o.a(r4);
        L11:
            EventTask r5 = (EventTask) ZeusTransformUtils.preCheckCast(r4, EventTask.class, "com.obric.aiagent.plugin");
            if (r5 == null) goto L15;
            BaseReadDetailFragmentV2 r3 = this.f23383c;
            r3.getDetailViewModel().a(r5, r3.getDetailParams().getEnterFrom());
            r3.onEditorResultSynced(r5);
        L15:
            return x.f38692a;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            o.a(r4);
            b<d<? super EventTask>, Object> r6 = this.f23382b;
            this.f23381a = 1;
            r4 = r6.invoke(this);
            if (r4 != r0) goto L11;
            return r0;
        }
    }

    public static /* synthetic */ x lambda$KHG5Y2_AW1sWZTc6HjGsdXxnMUY(BaseReadDetailFragmentV2 r0, View r1) {
        return configTitleBar$lambda$0(r0, r1);
    }

    /* JADX INFO: renamed from: lambda$o_h8URvVEu-b0SDvcmA1tGzrMDs, reason: not valid java name */
    public static /* synthetic */ x m488lambda$o_h8URvVEub0SDvcmA1tGzrMDs(BaseReadDetailFragmentV2 r0, View r1) {
        return configTitleBar$lambda$1(r0, r1);
    }

    public void onDestroyExtra() {
    }

    public void onEditorResultSynced(EventTask r1) {
        d.h.b.o.e(r1, "result");
    }

    public BaseReadDetailFragmentV2() {
    }

    @Override // com.obric.autoaction.app.launcherpage.detail.base.fragment.BaseDetailFragmentV2
    public c getDetailMode() {
        return c.f23286b;
    }

    @Override // com.obric.autoaction.app.launcherpage.detail.base.fragment.BaseDetailFragmentV2
    public void configTitleBar() {
        k.a((View) ZeusTransformUtils.preCheckCast(getTitleBar(), View.class, "com.obric.aiagent.plugin"));
        Context r0 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(requireContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        d.h.b.o.c(r0, "requireContext(...)");
        p.a(r0, getTitleBar(), Integer.valueOf(getTitleRes()), new $$Lambda$BaseReadDetailFragmentV2$KHG5Y2_AW1sWZTc6HjGsdXxnMUY(this), new $$Lambda$BaseReadDetailFragmentV2$o_h8URvVEub0SDvcmA1tGzrMDs(this));
    }

    private static final x configTitleBar$lambda$0(BaseReadDetailFragmentV2 r1, View r2) {
        d.h.b.o.e(r2, "it");
        r1.clickCancelButton(r2);
        return x.f38692a;
    }

    private static final x configTitleBar$lambda$1(BaseReadDetailFragmentV2 r1, View r2) {
        d.h.b.o.e(r2, "it");
        r1.onNavigateToEditorPage();
        return x.f38692a;
    }

    @Override // com.obric.autoaction.app.launcherpage.detail.base.fragment.BaseDetailFragmentV2
    public void handleEffect(com.obric.autoaction.app.launcherpage.detail.base.c r3) {
        com.obric.autoaction.app.launcherpage.detail.base.c r4 = (com.obric.autoaction.app.launcherpage.detail.base.c) ZeusTransformUtils.wrapperContextForParams(r3, com.obric.autoaction.app.launcherpage.detail.base.c.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r4, "effect");
        super.handleEffect(r4);
        if (ZeusTransformUtils.instanceOf(r4, com.obric.autoaction.app.launcherpage.detail.base.c.b.class) == true) goto L5;
        return;
    L5:
        if (getCurrentTask() != null) goto L9;
        closeHost();
        return;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        onDestroyExtra();
    }

    public final void navigateToEditAndSync(b<? super d<? super EventTask>, ? extends Object> r9) {
        b r10 = (b) ZeusTransformUtils.wrapperContextForParams(r9, b.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r10, "launch");
        androidx.lifecycle.p r0 = getViewLifecycleOwner();
        d.h.b.o.c(r0, "getViewLifecycleOwner(...)");
        i.a((am) ZeusTransformUtils.preCheckCast(q.a(r0), am.class, "com.obric.aiagent.plugin"), null, null, (m) ZeusTransformUtils.preCheckCast(new a(r10, this, null), m.class, "com.obric.aiagent.plugin"), 3, null);
    }
}
