package com.obric.autoaction.app.launcherpage.detail.shortcut.fragment;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.r;
import androidx.lifecycle.ao;
import androidx.lifecycle.ap;
import com.bytedance.common.wschannel.WsChannelMultiProcessSharedProvider;
import com.obric.aiagent.plugin.R;
import com.obric.autoaction.app.launcherpage.detail.base.container.h;
import com.obric.autoaction.app.launcherpage.detail.base.container.n;
import com.obric.autoaction.app.launcherpage.detail.base.container.q;
import com.obric.autoaction.app.launcherpage.detail.base.container.z;
import com.obric.autoaction.app.launcherpage.detail.base.fragment.BaseReadDetailFragmentV2;
import com.obric.eventkit.task.model.EventTask;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.c.b.a.l;
import d.c.d;
import d.f;
import d.h.b.aa;
import d.h.b.p;
import d.o;
import d.x;
import java.util.List;

/* JADX INFO: compiled from: ShortcutDetailFragmentV2.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class ShortcutDetailFragmentV2 extends BaseReadDetailFragmentV2 {
    private final f viewModel$delegate;

    /* JADX INFO: compiled from: ShortcutDetailFragmentV2.kt */
    @d.c.b.a.f(b = "ShortcutDetailFragmentV2.kt", c = {38}, d = "invokeSuspend", e = "com.obric.autoaction.app.launcherpage.detail.shortcut.fragment.ShortcutDetailFragmentV2$onNavigateToEditorPage$1")
    static final class a extends l implements d.h.a.b<d<? super EventTask>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f23547a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ ShortcutDetailFragmentV2 f23548b;

        a(ShortcutDetailFragmentV2 r3, d<? super a> r4) {
            d r5 = (d) ZeusTransformUtils.wrapperContextForParams(r4, d.class, "com.obric.aiagent.plugin");
            this.f23548b = r3;
            super(1, r5);
        }

        public final Object a(d<? super EventTask> r3) {
            return ((a) ZeusTransformUtils.preCheckCast(create((d) ZeusTransformUtils.wrapperContextForParams(r3, d.class, "com.obric.aiagent.plugin")), a.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d<x> create(d<?> r3) {
            d r4 = (d) ZeusTransformUtils.wrapperContextForParams(r3, d.class, "com.obric.aiagent.plugin");
            return (d) ZeusTransformUtils.preCheckCast(new a(this.f23548b, r4), d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.b
        public /* synthetic */ Object invoke(d<? super EventTask> r3) {
            return a((d) ZeusTransformUtils.preCheckCast(r3, d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r10) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f23547a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            o.a(r10);
        L11:
            return r10;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            o.a(r10);
            com.obric.autoaction.app.launcherpage.detail.shortcut.a r2 = com.obric.autoaction.app.launcherpage.detail.shortcut.a.f23480a;
            FragmentActivity r11 = (FragmentActivity) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.f23548b.requireActivity(), "com.obric.aiagent.plugin"), FragmentActivity.class, "com.obric.aiagent.plugin");
            d.h.b.o.c(r11, "requireActivity(...)");
            String r4 = this.f23548b.getTaskId();
            d r6 = (d) ZeusTransformUtils.preCheckCast(this, d.class, "com.obric.aiagent.plugin");
            this.f23547a = 1;
            r10 = com.obric.autoaction.app.launcherpage.detail.shortcut.a.a(r2, r11, r4, null, r6, 4, null);
            if (r10 != r0) goto L11;
            return r0;
        }
    }

    /* JADX INFO: compiled from: FragmentViewModelLazy.kt */
    public static final class b extends p implements d.h.a.a<Fragment> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Fragment f23549a;

        public b(Fragment r1) {
            this.f23549a = r1;
            super(0);
        }

        @Override // d.h.a.a
        public /* synthetic */ Fragment invoke() {
            return a();
        }

        public final Fragment a() {
            return this.f23549a;
        }
    }

    /* JADX INFO: compiled from: FragmentViewModelLazy.kt */
    public static final class c extends p implements d.h.a.a<ao> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ d.h.a.a f23550a;

        public c(d.h.a.a r3) {
            this.f23550a = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r3, d.h.a.a.class, "com.obric.aiagent.plugin");
            super(0);
        }

        @Override // d.h.a.a
        public /* synthetic */ ao invoke() {
            return a();
        }

        public final ao a() {
            ao r2 = ((ap) ZeusTransformUtils.preCheckCast(this.f23550a.invoke(), ap.class, "com.obric.aiagent.plugin")).getViewModelStore();
            d.h.b.o.b(r2, "ownerProducer().viewModelStore");
            return r2;
        }
    }

    @Override // com.obric.autoaction.app.launcherpage.base.TaskBaseFragment
    public String getPageEnterPageName() {
        return "short_cut_detail";
    }

    public ShortcutDetailFragmentV2() {
        Fragment r0 = (Fragment) ZeusTransformUtils.preCheckCast(this, Fragment.class, "com.obric.aiagent.plugin");
        d.h.a.a r2 = (d.h.a.a) ZeusTransformUtils.preCheckCast(new b(r0), d.h.a.a.class, "com.obric.aiagent.plugin");
        this.viewModel$delegate = r.a(r0, aa.b(com.obric.autoaction.app.launcherpage.detail.shortcut.b.a.class), (d.h.a.a) ZeusTransformUtils.preCheckCast(new c(r2), d.h.a.a.class, "com.obric.aiagent.plugin"), null);
    }

    private final com.obric.autoaction.app.launcherpage.detail.shortcut.b.a getViewModel() {
        return (com.obric.autoaction.app.launcherpage.detail.shortcut.b.a) ZeusTransformUtils.preCheckCast(this.viewModel$delegate.b(), com.obric.autoaction.app.launcherpage.detail.shortcut.b.a.class, "com.obric.aiagent.plugin");
    }

    @Override // com.obric.autoaction.app.launcherpage.detail.base.fragment.BaseDetailFragmentV2
    public List<z<?>> registerDetailViewContainers() {
        return d.a.p.b(new z[]{com.obric.autoaction.app.launcherpage.detail.base.container.aa.a((z) ZeusTransformUtils.preCheckCast(new h(false, 1, null), z.class, "com.obric.aiagent.plugin"), 16), com.obric.autoaction.app.launcherpage.detail.base.container.aa.a((z) ZeusTransformUtils.preCheckCast(new com.obric.autoaction.app.launcherpage.detail.base.container.l(), z.class, "com.obric.aiagent.plugin"), 16), com.obric.autoaction.app.launcherpage.detail.base.container.aa.a((z) ZeusTransformUtils.preCheckCast(new n(null, false, true), z.class, "com.obric.aiagent.plugin"), 16), com.obric.autoaction.app.launcherpage.detail.base.container.aa.a((z) ZeusTransformUtils.preCheckCast(new com.obric.autoaction.app.launcherpage.detail.base.container.b(), z.class, "com.obric.aiagent.plugin"), 16), com.obric.autoaction.app.launcherpage.detail.base.container.aa.a((z) ZeusTransformUtils.preCheckCast(new q(), z.class, "com.obric.aiagent.plugin"), 16)});
    }

    @Override // com.obric.autoaction.app.launcherpage.detail.base.fragment.BaseDetailFragmentV2
    public void onNavigateToEditorPage() {
        navigateToEditAndSync((d.h.a.b) ZeusTransformUtils.preCheckCast(new a(this, null), d.h.a.b.class, "com.obric.aiagent.plugin"));
    }

    @Override // com.obric.autoaction.app.launcherpage.detail.base.fragment.BaseDetailFragmentV2
    public int getTitleRes() {
        return ZeusTransformUtils.mapRes(R.string.shortcut_detail_title, WsChannelMultiProcessSharedProvider.STRING_TYPE, "shortcut_detail_title");
    }

    @Override // com.obric.autoaction.app.launcherpage.detail.base.fragment.BaseDetailFragmentV2
    public com.obric.autoaction.app.launcherpage.detail.base.b.d getDetailViewModel() {
        return (com.obric.autoaction.app.launcherpage.detail.base.b.d) ZeusTransformUtils.preCheckCast(getViewModel(), com.obric.autoaction.app.launcherpage.detail.base.b.d.class, "com.obric.aiagent.plugin");
    }
}
