package com.obric.autoaction.app.launcherpage.detail.shortcut.fragment;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.r;
import androidx.lifecycle.ao;
import androidx.lifecycle.ap;
import com.bytedance.common.wschannel.WsChannelMultiProcessSharedProvider;
import com.obric.aiagent.plugin.R;
import com.obric.autoaction.app.launcherpage.detail.base.b.d;
import com.obric.autoaction.app.launcherpage.detail.base.container.s;
import com.obric.autoaction.app.launcherpage.detail.base.container.v;
import com.obric.autoaction.app.launcherpage.detail.base.container.z;
import com.obric.autoaction.app.launcherpage.detail.base.fragment.BaseEditDetailFragmentV2;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.f;
import d.h.b.aa;
import d.h.b.o;
import d.h.b.p;
import java.util.List;

/* JADX INFO: compiled from: ShortcutEditDetailFragmentV2.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class ShortcutEditDetailFragmentV2 extends BaseEditDetailFragmentV2 {
    private final f viewModel$delegate;

    /* JADX INFO: compiled from: FragmentViewModelLazy.kt */
    public static final class a extends p implements d.h.a.a<Fragment> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Fragment f23551a;

        public a(Fragment r1) {
            this.f23551a = r1;
            super(0);
        }

        @Override // d.h.a.a
        public /* synthetic */ Fragment invoke() {
            return a();
        }

        public final Fragment a() {
            return this.f23551a;
        }
    }

    /* JADX INFO: compiled from: FragmentViewModelLazy.kt */
    public static final class b extends p implements d.h.a.a<ao> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ d.h.a.a f23552a;

        public b(d.h.a.a r3) {
            this.f23552a = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r3, d.h.a.a.class, "com.obric.aiagent.plugin");
            super(0);
        }

        @Override // d.h.a.a
        public /* synthetic */ ao invoke() {
            return a();
        }

        public final ao a() {
            ao r2 = ((ap) ZeusTransformUtils.preCheckCast(this.f23552a.invoke(), ap.class, "com.obric.aiagent.plugin")).getViewModelStore();
            o.b(r2, "ownerProducer().viewModelStore");
            return r2;
        }
    }

    @Override // com.obric.autoaction.app.launcherpage.base.TaskBaseFragment
    public String getPageEnterPageName() {
        return "shortcut_task_edit_detail";
    }

    public ShortcutEditDetailFragmentV2() {
        Fragment r0 = (Fragment) ZeusTransformUtils.preCheckCast(this, Fragment.class, "com.obric.aiagent.plugin");
        d.h.a.a r2 = (d.h.a.a) ZeusTransformUtils.preCheckCast(new a(r0), d.h.a.a.class, "com.obric.aiagent.plugin");
        this.viewModel$delegate = r.a(r0, aa.b(com.obric.autoaction.app.launcherpage.detail.shortcut.b.a.class), (d.h.a.a) ZeusTransformUtils.preCheckCast(new b(r2), d.h.a.a.class, "com.obric.aiagent.plugin"), null);
    }

    private final com.obric.autoaction.app.launcherpage.detail.shortcut.b.a getViewModel() {
        return (com.obric.autoaction.app.launcherpage.detail.shortcut.b.a) ZeusTransformUtils.preCheckCast(this.viewModel$delegate.b(), com.obric.autoaction.app.launcherpage.detail.shortcut.b.a.class, "com.obric.aiagent.plugin");
    }

    @Override // com.obric.autoaction.app.launcherpage.detail.base.fragment.BaseDetailFragmentV2
    public List<z<?>> registerDetailViewContainers() {
        return d.a.p.b(new z[]{com.obric.autoaction.app.launcherpage.detail.base.container.aa.a((z) ZeusTransformUtils.preCheckCast(new s(), z.class, "com.obric.aiagent.plugin"), 8), com.obric.autoaction.app.launcherpage.detail.base.container.aa.a((z) ZeusTransformUtils.preCheckCast(new v(), z.class, "com.obric.aiagent.plugin"), 16)});
    }

    @Override // com.obric.autoaction.app.launcherpage.detail.base.fragment.BaseDetailFragmentV2
    public int getTitleRes() {
        return ZeusTransformUtils.mapRes(R.string.shortcut_edit_command_title, WsChannelMultiProcessSharedProvider.STRING_TYPE, "shortcut_edit_command_title");
    }

    @Override // com.obric.autoaction.app.launcherpage.detail.base.fragment.BaseDetailFragmentV2
    public d getDetailViewModel() {
        return (d) ZeusTransformUtils.preCheckCast(getViewModel(), d.class, "com.obric.aiagent.plugin");
    }
}
