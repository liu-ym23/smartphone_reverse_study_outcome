package com.obric.autoaction.app.launcherpage.detail.condition.fragment;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.r;
import androidx.lifecycle.ao;
import androidx.lifecycle.ap;
import com.bytedance.common.wschannel.WsChannelMultiProcessSharedProvider;
import com.obric.aiagent.plugin.R;
import com.obric.autoaction.app.launcherpage.detail.base.container.n;
import com.obric.autoaction.app.launcherpage.detail.base.container.q;
import com.obric.autoaction.app.launcherpage.detail.base.container.u;
import com.obric.autoaction.app.launcherpage.detail.base.container.w;
import com.obric.autoaction.app.launcherpage.detail.base.container.z;
import com.obric.autoaction.app.launcherpage.detail.base.fragment.BaseReadDetailFragmentV2;
import com.obric.autoaction.app.launcherpage.detail.base.i;
import com.obric.autoaction.app.launcherpage.detail.base.k;
import com.obric.eventkit.task.model.ConditionTask;
import com.obric.eventkit.task.model.EventTask;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.c.b.a.l;
import d.c.g;
import d.f;
import d.h.a.m;
import d.h.b.aa;
import d.h.b.h;
import d.h.b.p;
import d.o;
import d.x;
import java.util.List;
import kotlinx.coroutines.am;
import kotlinx.coroutines.an;
import kotlinx.coroutines.bd;

/* JADX INFO: compiled from: ConditionEventDetailFragmentV2.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class ConditionEventDetailFragmentV2 extends BaseReadDetailFragmentV2 {
    private boolean updated;
    private final f viewModel$delegate;

    /* JADX INFO: compiled from: ConditionEventDetailFragmentV2.kt */
    @d.c.b.a.f(b = "ConditionEventDetailFragmentV2.kt", c = {67}, d = "invokeSuspend", e = "com.obric.autoaction.app.launcherpage.detail.condition.fragment.ConditionEventDetailFragmentV2$onNavigateToEditorPage$1")
    static final class a extends l implements d.h.a.b<d.c.d<? super EventTask>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f23471a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ ConditionEventDetailFragmentV2 f23472b;

        a(ConditionEventDetailFragmentV2 r3, d.c.d<? super a> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f23472b = r3;
            super(1, r5);
        }

        public final Object a(d.c.d<? super EventTask> r3) {
            return ((a) ZeusTransformUtils.preCheckCast(create((d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin")), a.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(d.c.d<?> r3) {
            d.c.d r4 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new a(this.f23472b, r4), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.b
        public /* synthetic */ Object invoke(d.c.d<? super EventTask> r3) {
            return a((d.c.d) ZeusTransformUtils.preCheckCast(r3, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r10) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f23471a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            o.a(r10);
        L11:
            return r10;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            o.a(r10);
            com.obric.autoaction.app.launcherpage.detail.condition.a r2 = com.obric.autoaction.app.launcherpage.detail.condition.a.f23400a;
            FragmentActivity r11 = (FragmentActivity) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.f23472b.requireActivity(), "com.obric.aiagent.plugin"), FragmentActivity.class, "com.obric.aiagent.plugin");
            d.h.b.o.c(r11, "requireActivity(...)");
            String r4 = this.f23472b.getTaskId();
            d.c.d r6 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f23471a = 1;
            r10 = com.obric.autoaction.app.launcherpage.detail.condition.a.a(r2, r11, r4, null, r6, 4, null);
            if (r10 != r0) goto L11;
            return r0;
        }
    }

    /* JADX INFO: compiled from: FragmentViewModelLazy.kt */
    public static final class b extends p implements d.h.a.a<Fragment> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Fragment f23473a;

        public b(Fragment r1) {
            this.f23473a = r1;
            super(0);
        }

        @Override // d.h.a.a
        public /* synthetic */ Fragment invoke() {
            return a();
        }

        public final Fragment a() {
            return this.f23473a;
        }
    }

    /* JADX INFO: compiled from: FragmentViewModelLazy.kt */
    public static final class c extends p implements d.h.a.a<ao> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ d.h.a.a f23474a;

        public c(d.h.a.a r3) {
            this.f23474a = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r3, d.h.a.a.class, "com.obric.aiagent.plugin");
            super(0);
        }

        @Override // d.h.a.a
        public /* synthetic */ ao invoke() {
            return a();
        }

        public final ao a() {
            ao r2 = ((ap) ZeusTransformUtils.preCheckCast(this.f23474a.invoke(), ap.class, "com.obric.aiagent.plugin")).getViewModelStore();
            d.h.b.o.b(r2, "ownerProducer().viewModelStore");
            return r2;
        }
    }

    /* JADX INFO: compiled from: ConditionEventDetailFragmentV2.kt */
    @d.c.b.a.f(b = "ConditionEventDetailFragmentV2.kt", c = {91}, d = "invokeSuspend", e = "com.obric.autoaction.app.launcherpage.detail.condition.fragment.ConditionEventDetailFragmentV2$updateCardIfNeed$1$1")
    static final class d extends l implements m<am, d.c.d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f23475a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ ConditionTask f23476b;

        d(ConditionTask r3, d.c.d<? super d> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f23476b = r3;
            super(2, r5);
        }

        public final Object a(am r3, d.c.d<? super x> r4) {
            return ((d) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), d.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r2, d.c.d<?> r3) {
            d.c.d r4 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new d(this.f23476b, r4), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r6) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f23475a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            o.a(r6);
        L12:
            return x.f38692a;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            o.a(r6);
            com.obric.autoaction.app.launcherpage.query.task.a r7 = com.obric.autoaction.app.launcherpage.query.task.a.f24297a;
            ConditionTask r2 = this.f23476b;
            d.c.d<? super x> r3 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f23475a = 1;
            if (r7.a(r2, r3) != r0) goto L12;
            return r0;
        }
    }

    @Override // com.obric.autoaction.app.launcherpage.base.TaskBaseFragment
    public String getPageEnterPageName() {
        return "condition_detail";
    }

    public ConditionEventDetailFragmentV2() {
        Fragment r0 = (Fragment) ZeusTransformUtils.preCheckCast(this, Fragment.class, "com.obric.aiagent.plugin");
        d.h.a.a r2 = (d.h.a.a) ZeusTransformUtils.preCheckCast(new b(r0), d.h.a.a.class, "com.obric.aiagent.plugin");
        this.viewModel$delegate = r.a(r0, aa.b(com.obric.autoaction.app.launcherpage.detail.condition.d.a.class), (d.h.a.a) ZeusTransformUtils.preCheckCast(new c(r2), d.h.a.a.class, "com.obric.aiagent.plugin"), null);
    }

    private final com.obric.autoaction.app.launcherpage.detail.condition.d.a getViewModel() {
        return (com.obric.autoaction.app.launcherpage.detail.condition.d.a) ZeusTransformUtils.preCheckCast(this.viewModel$delegate.b(), com.obric.autoaction.app.launcherpage.detail.condition.d.a.class, "com.obric.aiagent.plugin");
    }

    @Override // com.obric.autoaction.app.launcherpage.detail.base.fragment.BaseDetailFragmentV2
    public int getTitleRes() {
        return ZeusTransformUtils.mapRes(R.string.condition_event_detail_title, WsChannelMultiProcessSharedProvider.STRING_TYPE, "condition_event_detail_title");
    }

    @Override // com.obric.autoaction.app.launcherpage.detail.base.fragment.BaseDetailFragmentV2
    public com.obric.autoaction.app.launcherpage.detail.base.b.d getDetailViewModel() {
        return (com.obric.autoaction.app.launcherpage.detail.base.b.d) ZeusTransformUtils.preCheckCast(getViewModel(), com.obric.autoaction.app.launcherpage.detail.base.b.d.class, "com.obric.aiagent.plugin");
    }

    @Override // com.obric.autoaction.app.launcherpage.detail.base.fragment.BaseDetailFragmentV2
    public List<z<?>> registerDetailViewContainers() {
        boolean r1 = false;
        int r2 = 1;
        h r3 = null;
        return d.a.p.b(new z[]{com.obric.autoaction.app.launcherpage.detail.base.container.aa.a((z) ZeusTransformUtils.preCheckCast(new com.obric.autoaction.app.launcherpage.detail.base.container.h(r1, r2, r3), z.class, "com.obric.aiagent.plugin"), 16), new w(), com.obric.autoaction.app.launcherpage.detail.base.container.aa.a((z) ZeusTransformUtils.preCheckCast(new u(r1, r2, r3), z.class, "com.obric.aiagent.plugin"), 16), com.obric.autoaction.app.launcherpage.detail.base.container.aa.a((z) ZeusTransformUtils.preCheckCast(new com.obric.autoaction.app.launcherpage.detail.base.container.f(false), z.class, "com.obric.aiagent.plugin"), 16), com.obric.autoaction.app.launcherpage.detail.base.container.aa.a((z) ZeusTransformUtils.preCheckCast(new n(null, true, true), z.class, "com.obric.aiagent.plugin"), 16), com.obric.autoaction.app.launcherpage.detail.base.container.aa.a((z) ZeusTransformUtils.preCheckCast(new com.obric.autoaction.app.launcherpage.detail.base.container.l(), z.class, "com.obric.aiagent.plugin"), 16), com.obric.autoaction.app.launcherpage.detail.base.container.aa.a((z) ZeusTransformUtils.preCheckCast(new q(), z.class, "com.obric.aiagent.plugin"), 16)});
    }

    @Override // com.obric.autoaction.app.launcherpage.detail.base.fragment.BaseDetailFragmentV2
    public void bindState(i r3) {
        i r4 = (i) ZeusTransformUtils.wrapperContextForParams(r3, i.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r4, "state");
        super.bindState(r4);
        if (ZeusTransformUtils.instanceOf(r4, k.c.class) == false) goto L6;
        this.updated = true;
        return;
    }

    @Override // com.obric.autoaction.app.launcherpage.detail.base.fragment.BaseDetailFragmentV2
    public String loadingText() {
        return com.obric.autoaction.app.launcherpage.utils.p.a(ZeusTransformUtils.mapRes(R.string.condition_event_loading_text, WsChannelMultiProcessSharedProvider.STRING_TYPE, "condition_event_loading_text"), null, 1, null);
    }

    @Override // com.obric.autoaction.app.launcherpage.detail.base.fragment.BaseDetailFragmentV2
    public void onNavigateToEditorPage() {
        navigateToEditAndSync((d.h.a.b) ZeusTransformUtils.preCheckCast(new a(this, null), d.h.a.b.class, "com.obric.aiagent.plugin"));
    }

    @Override // com.obric.autoaction.app.launcherpage.detail.base.fragment.BaseReadDetailFragmentV2
    public void onEditorResultSynced(EventTask r2) {
        d.h.b.o.e(r2, "result");
        if (ZeusTransformUtils.instanceOf(r2, ConditionTask.class) == false) goto L6;
        this.updated = true;
        return;
    }

    @Override // com.obric.autoaction.app.launcherpage.detail.base.fragment.BaseReadDetailFragmentV2
    public void onDestroyExtra() {
        updateCardIfNeed();
    }

    private final void updateCardIfNeed() {
        if (this.updated == false) goto L11;
        EventTask r9 = getCurrentTask();
        if (ZeusTransformUtils.instanceOf(r9, ConditionTask.class) == false) goto L7;
        ConditionTask r10 = (ConditionTask) ZeusTransformUtils.preCheckCast(r9, ConditionTask.class, "com.obric.aiagent.plugin");
    L8:
        if (r10 == null) goto L12;
        kotlinx.coroutines.i.a(an.a((g) ZeusTransformUtils.preCheckCast(bd.c(), g.class, "com.obric.aiagent.plugin")), null, null, (m) ZeusTransformUtils.preCheckCast(new d(r10, null), m.class, "com.obric.aiagent.plugin"), 3, null);
        return;
    L12:
        return;
    L7:
        r10 = null;
        goto L8
    }
}
