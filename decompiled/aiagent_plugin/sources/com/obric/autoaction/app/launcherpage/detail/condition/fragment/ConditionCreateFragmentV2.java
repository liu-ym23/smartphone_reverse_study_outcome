package com.obric.autoaction.app.launcherpage.detail.condition.fragment;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.r;
import androidx.lifecycle.ao;
import androidx.lifecycle.ap;
import com.bytedance.common.wschannel.WsChannelMultiProcessSharedProvider;
import com.obric.aiagent.plugin.R;
import com.obric.autoaction.app.launcherpage.detail.base.b.d;
import com.obric.autoaction.app.launcherpage.detail.base.container.n;
import com.obric.autoaction.app.launcherpage.detail.base.container.s;
import com.obric.autoaction.app.launcherpage.detail.base.container.u;
import com.obric.autoaction.app.launcherpage.detail.base.container.w;
import com.obric.autoaction.app.launcherpage.detail.base.container.y;
import com.obric.autoaction.app.launcherpage.detail.base.container.z;
import com.obric.autoaction.app.launcherpage.detail.base.fragment.BaseCreateDetailFragmentV2;
import com.obric.autoaction.app.launcherpage.main.IMainTab;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.f;
import d.h.b.aa;
import d.h.b.o;
import d.h.b.p;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: ConditionCreateFragmentV2.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class ConditionCreateFragmentV2 extends BaseCreateDetailFragmentV2 {
    private final f viewModel$delegate;

    /* JADX INFO: compiled from: FragmentViewModelLazy.kt */
    public static final class a extends p implements d.h.a.a<Fragment> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Fragment f23469a;

        public a(Fragment r1) {
            this.f23469a = r1;
            super(0);
        }

        @Override // d.h.a.a
        public /* synthetic */ Fragment invoke() {
            return a();
        }

        public final Fragment a() {
            return this.f23469a;
        }
    }

    /* JADX INFO: compiled from: FragmentViewModelLazy.kt */
    public static final class b extends p implements d.h.a.a<ao> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ d.h.a.a f23470a;

        public b(d.h.a.a r3) {
            this.f23470a = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r3, d.h.a.a.class, "com.obric.aiagent.plugin");
            super(0);
        }

        @Override // d.h.a.a
        public /* synthetic */ ao invoke() {
            return a();
        }

        public final ao a() {
            ao r2 = ((ap) ZeusTransformUtils.preCheckCast(this.f23470a.invoke(), ap.class, "com.obric.aiagent.plugin")).getViewModelStore();
            o.b(r2, "ownerProducer().viewModelStore");
            return r2;
        }
    }

    @Override // com.obric.autoaction.app.launcherpage.base.TaskBaseFragment
    public String getPageEnterPageName() {
        return "condition_create";
    }

    public ConditionCreateFragmentV2() {
        Fragment r0 = (Fragment) ZeusTransformUtils.preCheckCast(this, Fragment.class, "com.obric.aiagent.plugin");
        d.h.a.a r2 = (d.h.a.a) ZeusTransformUtils.preCheckCast(new a(r0), d.h.a.a.class, "com.obric.aiagent.plugin");
        this.viewModel$delegate = r.a(r0, aa.b(com.obric.autoaction.app.launcherpage.detail.condition.d.a.class), (d.h.a.a) ZeusTransformUtils.preCheckCast(new b(r2), d.h.a.a.class, "com.obric.aiagent.plugin"), null);
    }

    private final com.obric.autoaction.app.launcherpage.detail.condition.d.a getViewModel() {
        return (com.obric.autoaction.app.launcherpage.detail.condition.d.a) ZeusTransformUtils.preCheckCast(this.viewModel$delegate.b(), com.obric.autoaction.app.launcherpage.detail.condition.d.a.class, "com.obric.aiagent.plugin");
    }

    @Override // com.obric.autoaction.app.launcherpage.detail.base.fragment.BaseDetailFragmentV2
    public int getTitleRes() {
        return ZeusTransformUtils.mapRes(R.string.condition_create_command_title, WsChannelMultiProcessSharedProvider.STRING_TYPE, "condition_create_command_title");
    }

    @Override // com.obric.autoaction.app.launcherpage.detail.base.fragment.BaseDetailFragmentV2
    public d getDetailViewModel() {
        return (d) ZeusTransformUtils.preCheckCast(getViewModel(), d.class, "com.obric.aiagent.plugin");
    }

    @Override // com.obric.autoaction.app.launcherpage.detail.base.fragment.BaseCreateDetailFragmentV2
    public String listTabName() {
        return IMainTab.Companion.b();
    }

    @Override // com.obric.autoaction.app.launcherpage.detail.base.fragment.BaseDetailFragmentV2
    public List<z<?>> registerDetailViewContainers() {
        List<z<?>> r0 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.aiagent.plugin");
        boolean r3 = false;
        int r5 = 1;
        if (getViewModel().t() == false) goto L5;
        r0.add(com.obric.autoaction.app.launcherpage.detail.base.container.aa.a((z) ZeusTransformUtils.preCheckCast(new y(com.obric.autoaction.app.launcherpage.utils.p.a(ZeusTransformUtils.mapRes(R.string.condition_event_limit_max_number_tip, WsChannelMultiProcessSharedProvider.STRING_TYPE, "condition_event_limit_max_number_tip"), new Object[]{String.valueOf(com.obric.autoaction.app.launcherpage.detail.condition.b.a())})), z.class, "com.obric.aiagent.plugin"), 16));
    L5:
        r0.add(com.obric.autoaction.app.launcherpage.detail.base.container.aa.a((z) ZeusTransformUtils.preCheckCast(new com.obric.autoaction.app.launcherpage.detail.base.container.d(r3, r5, null), z.class, "com.obric.aiagent.plugin"), 16));
        r0.add(new w());
        r0.add(com.obric.autoaction.app.launcherpage.detail.base.container.aa.a((z) ZeusTransformUtils.preCheckCast(new s(), z.class, "com.obric.aiagent.plugin"), 16));
        r0.add(com.obric.autoaction.app.launcherpage.detail.base.container.aa.a((z) ZeusTransformUtils.preCheckCast(new u(true), z.class, "com.obric.aiagent.plugin"), 16));
        r0.add(com.obric.autoaction.app.launcherpage.detail.base.container.aa.a((z) ZeusTransformUtils.preCheckCast(new com.obric.autoaction.app.launcherpage.detail.base.container.f(true), z.class, "com.obric.aiagent.plugin"), 16));
        r0.add(com.obric.autoaction.app.launcherpage.detail.base.container.aa.a((z) ZeusTransformUtils.preCheckCast(new n(com.obric.autoaction.app.launcherpage.utils.p.a(ZeusTransformUtils.mapRes(R.string.condition_event_more_extra, WsChannelMultiProcessSharedProvider.STRING_TYPE, "condition_event_more_extra"), null, 1, null), true, false), z.class, "com.obric.aiagent.plugin"), 16));
        return r0;
    }

    @Override // com.obric.autoaction.app.launcherpage.detail.base.fragment.BaseDetailFragmentV2
    public String loadingText() {
        return com.obric.autoaction.app.launcherpage.utils.p.a(ZeusTransformUtils.mapRes(R.string.condition_event_loading_text, WsChannelMultiProcessSharedProvider.STRING_TYPE, "condition_event_loading_text"), null, 1, null);
    }
}
