package com.obric.autoaction.app.launcherpage.shortcut;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.SystemClock;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.r;
import androidx.lifecycle.ao;
import com.bytedance.bdturing.localstorage.DbHelper;
import com.bytedance.common.wschannel.WsChannelMultiProcessSharedProvider;
import com.google.protobuf.DescriptorProtos;
import com.obric.aiagent.plugin.R;
import com.obric.autoaction.app.launcherpage.a.af;
import com.obric.autoaction.app.launcherpage.main.IMainTab;
import com.obric.autoaction.app.launcherpage.main.LauncherPageBaseTabFragment;
import com.obric.autoaction.app.launcherpage.ui.h;
import com.obric.autoaction.app.launcherpage.ui.n;
import com.obric.autoaction.app.launcherpage.ui.q;
import com.obric.autogui.common.api.AODeviceSpecificTools;
import com.obric.oui.orecyclerview.widget.RecyclerView;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.c.b.a.l;
import d.c.g;
import d.f;
import d.h.a.m;
import d.h.b.aa;
import d.h.b.p;
import d.o;
import d.x;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlinx.coroutines.am;
import kotlinx.coroutines.b.i;
import kotlinx.coroutines.bd;

/* JADX INFO: compiled from: ShortCutFragment.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class ShortCutFragment extends LauncherPageBaseTabFragment {
    private af binding;
    private long createStartTime;
    private String focusId;
    private boolean hasReportedRenderDuration;
    private final f viewModel$delegate;

    /* JADX INFO: compiled from: ShortCutFragment.kt */
    @d.c.b.a.f(b = "ShortCutFragment.kt", c = {93}, d = "invokeSuspend", e = "com.obric.autoaction.app.launcherpage.shortcut.ShortCutFragment$onViewCreated$3$1")
    static final class a extends l implements m<am, d.c.d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f24372a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ ShortCutFragment f24373b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ List<String> f24374c;

        a(ShortCutFragment r3, List<String> r4, d.c.d<? super a> r5) {
            List<String> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.aiagent.plugin");
            d.c.d r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            this.f24373b = r3;
            this.f24374c = r6;
            super(2, r7);
        }

        public final Object a(am r3, d.c.d<? super x> r4) {
            return ((a) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), a.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r3, d.c.d<?> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new a(this.f24373b, this.f24374c, r5), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r6) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f24372a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            o.a(r6);
        L12:
            if (((Boolean) ZeusTransformUtils.preCheckCast(r6, Boolean.class, "com.obric.aiagent.plugin")).booleanValue() == true) goto L15;
            ShortCutFragment.access$getViewModel(this.f24373b).e();
        L15:
            return x.f38692a;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            o.a(r6);
            com.obric.autoaction.app.launcherpage.shortcut.a r7 = ShortCutFragment.access$getViewModel(this.f24373b);
            List<String> r2 = this.f24374c;
            d.c.d<? super Boolean> r4 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f24372a = 1;
            r6 = r7.a(r2, r4);
            if (r6 != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: compiled from: ShortCutFragment.kt */
    public static final class b extends RecyclerView.g {
        b() {
        }

        @Override // com.obric.oui.orecyclerview.widget.RecyclerView.g
        public void a(Rect r5, View r6, RecyclerView r7, RecyclerView.s r8) {
            d.h.b.o.e(r5, "outRect");
            d.h.b.o.e(r6, "view");
            d.h.b.o.e(r7, "parent");
            d.h.b.o.e(r8, "state");
            RecyclerView.v r4 = r7.getChildViewHolder(r6);
            if (r4 != null) goto L5;
            return;
        L5:
            int r9 = r4.j();
            if (r9 != (-1)) goto L30;
            Object r10 = r6.getTag(ZeusTransformUtils.mapRes(R.id.tag_shortcut_item_offset_top, DbHelper.COL_ID, "tag_shortcut_item_offset_top"));
            Integer r3 = null;
            if (ZeusTransformUtils.instanceOf(r10, Integer.class) == false) goto L10;
            Integer r11 = (Integer) ZeusTransformUtils.preCheckCast(r10, Integer.class, "com.obric.aiagent.plugin");
        L11:
            int r12 = 0;
            if (r11 == null) goto L14;
            int r13 = r11.intValue();
        L15:
            r5.top = r13;
            Object r14 = r6.getTag(ZeusTransformUtils.mapRes(R.id.tag_shortcut_item_offset_left, DbHelper.COL_ID, "tag_shortcut_item_offset_left"));
            if (ZeusTransformUtils.instanceOf(r14, Integer.class) == false) goto L18;
            Integer r15 = (Integer) ZeusTransformUtils.preCheckCast(r14, Integer.class, "com.obric.aiagent.plugin");
        L19:
            if (r15 == null) goto L21;
            int r16 = r15.intValue();
        L22:
            r5.left = r16;
            Object r17 = r6.getTag(ZeusTransformUtils.mapRes(R.id.tag_shortcut_item_offset_right, DbHelper.COL_ID, "tag_shortcut_item_offset_right"));
            if (ZeusTransformUtils.instanceOf(r17, Integer.class) == false) goto L25;
            r3 = (Integer) ZeusTransformUtils.preCheckCast(r17, Integer.class, "com.obric.aiagent.plugin");
        L25:
            if (r3 == null) goto L27;
            r12 = r3.intValue();
        L27:
            r5.right = r12;
            return;
        L21:
            r16 = 0;
            goto L22
        L18:
            r15 = null;
            goto L19
        L14:
            r13 = 0;
            goto L15
        L10:
            r11 = null;
            goto L11
        L30:
            if (r9 != 0) goto L32;
            float r18 = 16;
            DisplayMetrics r19 = Resources.getSystem().getDisplayMetrics();
        L33:
            r5.top = d.i.a.a(TypedValue.applyDimension(1, r18, r19));
            r6.setTag(ZeusTransformUtils.mapRes(R.id.tag_shortcut_item_offset_top, DbHelper.COL_ID, "tag_shortcut_item_offset_top"), Integer.valueOf(r5.top));
            r6.setTag(ZeusTransformUtils.mapRes(R.id.tag_shortcut_item_offset_left, DbHelper.COL_ID, "tag_shortcut_item_offset_left"), Integer.valueOf(r5.left));
            r6.setTag(ZeusTransformUtils.mapRes(R.id.tag_shortcut_item_offset_right, DbHelper.COL_ID, "tag_shortcut_item_offset_right"), Integer.valueOf(r5.right));
            return;
        L32:
            r18 = 8;
            r19 = Resources.getSystem().getDisplayMetrics();
            goto L33
        }
    }

    /* JADX INFO: compiled from: ShortCutFragment.kt */
    public static final class c extends RecyclerView.m {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ ShortCutFragment f24375a;

        @Override // com.obric.oui.orecyclerview.widget.RecyclerView.m
        public void a(RecyclerView r1, int r2) {
            d.h.b.o.e(r1, "recyclerView");
        }

        c(ShortCutFragment r1) {
            this.f24375a = r1;
        }

        @Override // com.obric.oui.orecyclerview.widget.RecyclerView.m
        public void a(RecyclerView r2, int r3, int r4) {
            d.h.b.o.e(r2, "recyclerView");
            super.a(r2, r3, r4);
            ShortCutFragment.access$checkScrollBounds(this.f24375a, r2);
        }
    }

    /* JADX INFO: compiled from: ShortCutFragment.kt */
    @d.c.b.a.f(b = "ShortCutFragment.kt", c = {144}, d = "invokeSuspend", e = "com.obric.autoaction.app.launcherpage.shortcut.ShortCutFragment$onViewCreated$6")
    static final class d extends l implements m<am, d.c.d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f24376a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ ShortCutFragment f24377b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ com.obric.autoaction.app.launcherpage.ui.m<h> f24378c;

        d(ShortCutFragment r3, com.obric.autoaction.app.launcherpage.ui.m<h> r4, d.c.d<? super d> r5) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            this.f24377b = r3;
            this.f24378c = r4;
            super(2, r6);
        }

        public final Object a(am r3, d.c.d<? super x> r4) {
            return ((d) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), d.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r3, d.c.d<?> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new d(this.f24377b, this.f24378c, r5), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r6) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f24376a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L6;
            o.a(r6);
        L12:
            throw new d.d();
        L6:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            o.a(r6);
            kotlinx.coroutines.b.x<List<h>> r7 = ShortCutFragment.access$getViewModel(this.f24377b).b();
            final ShortCutFragment r3 = this.f24377b;
            final com.obric.autoaction.app.launcherpage.ui.m<h> r4 = this.f24378c;
            i<? super List<h>> r2 = (i) ZeusTransformUtils.preCheckCast(new AnonymousClass1(r3, r4), i.class, "com.obric.aiagent.plugin");
            d.c.d<?> r5 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f24376a = 1;
            if (r7.collect(r2, r5) != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: compiled from: FragmentViewModelLazy.kt */
    public static final class e extends p implements d.h.a.a<ao> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Fragment f24381a;

        public e(Fragment r1) {
            this.f24381a = r1;
            super(0);
        }

        @Override // d.h.a.a
        public /* synthetic */ ao invoke() {
            return a();
        }

        public final ao a() {
            FragmentActivity r2 = (FragmentActivity) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.f24381a.requireActivity(), "com.obric.aiagent.plugin"), FragmentActivity.class, "com.obric.aiagent.plugin");
            d.h.b.o.b(r2, "requireActivity()");
            ao r3 = r2.getViewModelStore();
            d.h.b.o.b(r3, "requireActivity().viewModelStore");
            return r3;
        }
    }

    /* JADX INFO: renamed from: lambda$Cg57gtr-USRvpYUeKtdy7Z9JXHg, reason: not valid java name */
    public static /* synthetic */ String m555lambda$Cg57gtrUSRvpYUeKtdy7Z9JXHg(h r0) {
        return onViewCreated$lambda$3(r0);
    }

    public static /* synthetic */ x lambda$GC1yvN2yG_BJBOzmO6oCs7iaT0k(ShortCutFragment r0, List r1, com.obric.autoaction.app.launcherpage.ui.l r2) {
        return onViewCreated$lambda$4(r0, r1, r2);
    }

    /* JADX INFO: renamed from: lambda$SxVhRj-_41D4JRBJowBJmeIUK5A, reason: not valid java name */
    public static /* synthetic */ boolean m556lambda$SxVhRj_41D4JRBJowBJmeIUK5A(h r0) {
        return onViewCreated$lambda$2(r0);
    }

    public static /* synthetic */ void lambda$YTHir7RMjwWxtwsGctlj86zvNQ0(ShortCutFragment r0, int r1) {
        focusCell$lambda$7(r0, r1);
    }

    public static /* synthetic */ void lambda$dXfAQsrdulEWD5Nc_PWhPFoMGoc(ShortCutFragment r0, String r1, Bundle r2) {
        onCreate$lambda$1(r0, r1, r2);
    }

    public static /* synthetic */ void lambda$eGtBbunD8OjXFh7BMVyhssxLD0Y(ShortCutFragment r0) {
        onCreate$lambda$1$lambda$0(r0);
    }

    public static /* synthetic */ x lambda$zU7U_5HPiJTe3ZTJduPZlYJLgUw(ShortCutFragment r0, List r1) {
        return submitShortcutList$lambda$5(r0, r1);
    }

    @Override // com.obric.autoaction.app.launcherpage.base.TaskBaseFragment
    public String getPageEnterPageName() {
        return "short_cut_list";
    }

    public ShortCutFragment() {
        Fragment r0 = (Fragment) ZeusTransformUtils.preCheckCast(this, Fragment.class, "com.obric.aiagent.plugin");
        this.viewModel$delegate = r.a(r0, aa.b(com.obric.autoaction.app.launcherpage.shortcut.a.class), (d.h.a.a) ZeusTransformUtils.preCheckCast(new e(r0), d.h.a.a.class, "com.obric.aiagent.plugin"), null);
    }

    public static final /* synthetic */ void access$checkScrollBounds(ShortCutFragment r0, RecyclerView r1) {
        r0.checkScrollBounds(r1);
    }

    public static final /* synthetic */ com.obric.autoaction.app.launcherpage.shortcut.a access$getViewModel(ShortCutFragment r0) {
        return r0.getViewModel();
    }

    public static final /* synthetic */ void access$submitShortcutList(ShortCutFragment r2, com.obric.autoaction.app.launcherpage.ui.m r3, List r4) {
        r2.submitShortcutList(r3, (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.aiagent.plugin"));
    }

    private final com.obric.autoaction.app.launcherpage.shortcut.a getViewModel() {
        return (com.obric.autoaction.app.launcherpage.shortcut.a) ZeusTransformUtils.preCheckCast(this.viewModel$delegate.b(), com.obric.autoaction.app.launcherpage.shortcut.a.class, "com.obric.aiagent.plugin");
    }

    @Override // com.obric.autoaction.app.launcherpage.base.TaskBaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle r4) {
        super.onCreate(r4);
        this.createStartTime = SystemClock.elapsedRealtime();
        getParentFragmentManager().a(IMainTab.Companion.a() + "_args", (androidx.lifecycle.p) ZeusTransformUtils.preCheckCast(this, androidx.lifecycle.p.class, "com.obric.aiagent.plugin"), new $$Lambda$ShortCutFragment$dXfAQsrdulEWD5Nc_PWhPFoMGoc(this));
    }

    private static final void onCreate$lambda$1(final ShortCutFragment r2, String r3, Bundle r4) {
        d.h.b.o.e(r3, "<unused var>");
        d.h.b.o.e(r4, "bundle");
        r2.focusId = r4.getString("key_task_id");
        af r5 = r2.binding;
        if (r5 != null) goto L5;
        d.h.b.o.c("binding");
        r5 = null;
    L5:
        r5.b().postDelayed(new $$Lambda$ShortCutFragment$eGtBbunD8OjXFh7BMVyhssxLD0Y(r2), 500);
    }

    private static final void onCreate$lambda$1$lambda$0(ShortCutFragment r0) {
        r0.focusCell();
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater r1, ViewGroup r2, Bundle r3) {
        d.h.b.o.e(r1, "inflater");
        af r4 = af.a(r1, r2, false);
        d.h.b.o.c(r4, "inflate(...)");
        this.binding = r4;
        if (r4 != null) goto L6;
        d.h.b.o.c("binding");
        r4 = null;
    L6:
        return (View) ZeusTransformUtils.preCheckCast(r4.b(), View.class, "com.obric.aiagent.plugin");
    }

    @Override // com.obric.autoaction.app.launcherpage.main.LauncherPageBaseTabFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View r10, Bundle r11) {
        d.h.b.o.e(r10, "view");
        super.onViewCreated(r10, r11);
        af r12 = this.binding;
        if (r12 != null) goto L5;
        d.h.b.o.c("binding");
        r12 = null;
    L5:
        RecyclerView r13 = r12.f22726a;
        d.h.b.o.c(r13, "list");
        com.obric.autoaction.app.launcherpage.ui.m r14 = new com.obric.autoaction.app.launcherpage.ui.m(r13, false, 2, null);
        r14.a(new Class[]{com.obric.autoaction.app.launcherpage.shortcut.cell.a.class});
        af r15 = this.binding;
        if (r15 != null) goto L8;
        d.h.b.o.c("binding");
        r15 = null;
    L8:
        r15.f22727b.setTitle((CharSequence) ZeusTransformUtils.preCheckCast(getString(ZeusTransformUtils.mapRes(R.string.shortcut_page_empty, WsChannelMultiProcessSharedProvider.STRING_TYPE, "shortcut_page_empty")), CharSequence.class, "com.obric.aiagent.plugin"));
        af r16 = this.binding;
        if (r16 != null) goto L11;
        d.h.b.o.c("binding");
        r16 = null;
    L11:
        r16.f22726a.setAdapter((RecyclerView.a) ZeusTransformUtils.preCheckCast(r14, RecyclerView.a.class, "com.obric.aiagent.plugin"));
        af r17 = this.binding;
        if (r17 != null) goto L14;
        d.h.b.o.c("binding");
        r17 = null;
    L14:
        RecyclerView r18 = r17.f22726a;
        Context r5 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(requireContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        d.h.b.o.c(r5, "requireContext(...)");
        r18.setLayoutManager((RecyclerView.h) ZeusTransformUtils.preCheckCast(new q(r5), RecyclerView.h.class, "com.obric.aiagent.plugin"));
        af r19 = this.binding;
        if (r19 != null) goto L17;
        d.h.b.o.c("binding");
        r19 = null;
    L17:
        RecyclerView r110 = r19.f22726a;
        d.h.b.o.c(r110, "list");
        com.obric.autoaction.app.launcherpage.utils.p.a((View) ZeusTransformUtils.preCheckCast(r110, View.class, "com.obric.aiagent.plugin"), 0, false, 2, null);
        af r2 = this.binding;
        if (r2 != null) goto L20;
        d.h.b.o.c("binding");
        r2 = null;
    L20:
        RecyclerView r3 = r2.f22726a;
        d.h.b.o.c(r3, "list");
        new n(r3, r14, $$Lambda$ShortCutFragment$SxVhRj_41D4JRBJowBJmeIUK5A.INSTANCE, $$Lambda$ShortCutFragment$Cg57gtrUSRvpYUeKtdy7Z9JXHg.INSTANCE, new $$Lambda$ShortCutFragment$GC1yvN2yG_BJBOzmO6oCs7iaT0k(this)).a();
        af r111 = this.binding;
        if (r111 != null) goto L23;
        d.h.b.o.c("binding");
        r111 = null;
    L23:
        r111.f22726a.addItemDecoration((RecyclerView.g) ZeusTransformUtils.preCheckCast(new b(), RecyclerView.g.class, "com.obric.aiagent.plugin"));
        af r112 = this.binding;
        if (r112 != null) goto L26;
        d.h.b.o.c("binding");
        r112 = null;
    L26:
        r112.f22726a.addOnScrollListener((RecyclerView.m) ZeusTransformUtils.preCheckCast(new c(this), RecyclerView.m.class, "com.obric.aiagent.plugin"));
        kotlinx.coroutines.i.a((am) ZeusTransformUtils.preCheckCast(androidx.lifecycle.q.a((androidx.lifecycle.p) ZeusTransformUtils.preCheckCast(this, androidx.lifecycle.p.class, "com.obric.aiagent.plugin")), am.class, "com.obric.aiagent.plugin"), null, null, (m) ZeusTransformUtils.preCheckCast(new d(this, r14, null), m.class, "com.obric.aiagent.plugin"), 3, null);
    }

    private static final boolean onViewCreated$lambda$2(h r2) {
        h r3 = (h) ZeusTransformUtils.wrapperContextForParams(r2, h.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r3, "it");
        return ZeusTransformUtils.instanceOf(r3, com.obric.autoaction.app.launcherpage.shortcut.cell.b.class);
    }

    private static final String onViewCreated$lambda$3(h r3) {
        h r4 = (h) ZeusTransformUtils.wrapperContextForParams(r3, h.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r4, "it");
        if (ZeusTransformUtils.instanceOf(r4, com.obric.autoaction.app.launcherpage.shortcut.cell.b.class) == false) goto L5;
        com.obric.autoaction.app.launcherpage.shortcut.cell.b r5 = (com.obric.autoaction.app.launcherpage.shortcut.cell.b) ZeusTransformUtils.preCheckCast(r4, com.obric.autoaction.app.launcherpage.shortcut.cell.b.class, "com.obric.aiagent.plugin");
    L6:
        if (r5 != null) goto L8;
        return null;
    L8:
        return r5.a();
    L5:
        r5 = null;
        goto L6
    }

    private static final x onViewCreated$lambda$4(ShortCutFragment r8, List r9, com.obric.autoaction.app.launcherpage.ui.l r10) {
        List r11 = (List) ZeusTransformUtils.wrapperContextForParams(r9, List.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r11, "orderedTaskIds");
        d.h.b.o.e(r10, "<unused var>");
        kotlinx.coroutines.i.a((am) ZeusTransformUtils.preCheckCast(androidx.lifecycle.q.a((androidx.lifecycle.p) ZeusTransformUtils.preCheckCast(r8, androidx.lifecycle.p.class, "com.obric.aiagent.plugin")), am.class, "com.obric.aiagent.plugin"), (g) ZeusTransformUtils.preCheckCast(bd.c(), g.class, "com.obric.aiagent.plugin"), null, (m) ZeusTransformUtils.preCheckCast(new a(r8, r11, null), m.class, "com.obric.aiagent.plugin"), 2, null);
        return x.f38692a;
    }

    private final void submitShortcutList(com.obric.autoaction.app.launcherpage.ui.m<h> r3, List<? extends h> r4) {
        final List<? extends T> r5 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.aiagent.plugin");
        r3.a(r5, new $$Lambda$ShortCutFragment$zU7U_5HPiJTe3ZTJduPZlYJLgUw(this, r5));
        boolean r6 = r5.isEmpty();
        af r7 = null;
        if (r6 == false) goto L9;
        af r2 = this.binding;
        if (r2 != null) goto L7;
        d.h.b.o.c("binding");
    L8:
        r7.f22727b.setVisibility(0);
        return;
    L7:
        r7 = r2;
        goto L8
    L9:
        af r8 = this.binding;
        if (r8 != null) goto L12;
        d.h.b.o.c("binding");
    L13:
        r7.f22727b.setVisibility(8);
        return;
    L12:
        r7 = r8;
        goto L13
    }

    private static final x submitShortcutList$lambda$5(ShortCutFragment r3, List r4) {
        List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.aiagent.plugin");
        r3.reportRenderDurationIfNeeded();
        af r0 = r3.binding;
        if (r0 != null) goto L5;
        d.h.b.o.c("binding");
        r0 = null;
    L5:
        r3.reportPageEnterSuccessOnPreDraw((View) ZeusTransformUtils.preCheckCast(r0.f22726a, View.class, "com.obric.aiagent.plugin"));
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r5, Collection.class, "com.obric.aiagent.plugin")).isEmpty()) == false) goto L9;
        r3.focusCell();
    L9:
        return x.f38692a;
    }

    private final void checkScrollBounds(RecyclerView r6) {
        d.m<Integer, Integer> r0 = AODeviceSpecificTools.INSTANCE.getScreenDimensions();
        boolean r1 = true;
        if (r0 == null) goto L5;
        int r2 = ((Number) ZeusTransformUtils.preCheckCast(r0.b(), Number.class, "com.obric.aiagent.plugin")).intValue();
    L6:
        float r3 = r2 * 1.5f;
        int r4 = r6.computeVerticalScrollOffset();
        int r5 = r6.computeVerticalScrollRange();
        int r7 = r6.computeVerticalScrollExtent();
        if (r5 <= r7) goto L9;
        int r8 = r5 - r7;
    L10:
        int r9 = r8 - r4;
        if (r9 < d.i.a.a(TypedValue.applyDimension(1, 24, Resources.getSystem().getDisplayMetrics()))) goto L15;
        r1 = false;
    L15:
        if (r9 < r3) goto L17;
        if (r1 == true) goto L17;
        return;
    L17:
        getViewModel().c();
        return;
    L9:
        r8 = 0;
        goto L10
    L5:
        r2 = d.i.a.a(TypedValue.applyDimension(1, DescriptorProtos.Edition.EDITION_LEGACY_VALUE, Resources.getSystem().getDisplayMetrics()));
        goto L6
    }

    private final void reportRenderDurationIfNeeded() {
        if (this.hasReportedRenderDuration == false) goto L5;
        return;
    L5:
        if (this.createStartTime <= 0) goto L10;
        this.hasReportedRenderDuration = true;
        com.obric.event.task.base.report.l.f32861a.a(SystemClock.elapsedRealtime() - this.createStartTime);
        return;
    }

    private final void focusCell() {
        if (this.focusId == null) goto L31;
        List r0 = (List) ZeusTransformUtils.preCheckCast(getViewModel().b().c(), List.class, "com.obric.aiagent.plugin");
        if (r0 != null) goto L7;
        r0 = d.a.p.b();
    L7:
        Iterator r1 = r0.iterator();
        final int r3 = 0;
    L9:
        if (r1.hasNext() == false) goto L19;
        h r4 = (h) ZeusTransformUtils.preCheckCast(r1.next(), h.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r4, com.obric.autoaction.app.launcherpage.shortcut.cell.b.class) == true) goto L13;
    L15:
        boolean r5 = false;
    L16:
        if (r5 == true) goto L20;
        r3 = r3 + 1;
    L20:
        af r2 = this.binding;
        af r6 = null;
        if (r2 != null) goto L23;
        d.h.b.o.c("binding");
        r2 = null;
    L23:
        r2.f22726a.scrollToPosition(r3);
        af r7 = this.binding;
        if (r7 != null) goto L26;
        d.h.b.o.c("binding");
    L27:
        r6.f22726a.post(new $$Lambda$ShortCutFragment$YTHir7RMjwWxtwsGctlj86zvNQ0(this, r3));
        return;
    L26:
        r6 = r7;
        goto L27
    L13:
        if (d.h.b.o.a(((com.obric.autoaction.app.launcherpage.shortcut.cell.b) ZeusTransformUtils.preCheckCast(r4, com.obric.autoaction.app.launcherpage.shortcut.cell.b.class, "com.obric.aiagent.plugin")).a(), this.focusId) == false) goto L15;
        r5 = true;
        goto L16
    L19:
        r3 = -1;
        goto L20
    }

    private static final void focusCell$lambda$7(ShortCutFragment r12, int r13) {
        af r0 = r12.binding;
        if (r0 != null) goto L5;
        d.h.b.o.c("binding");
        r0 = null;
    L5:
        RecyclerView.v r14 = r0.f22726a.findViewHolderForAdapterPosition(r13);
        if (ZeusTransformUtils.instanceOf(r14, com.obric.autoaction.app.launcherpage.shortcut.cell.a.class) == false) goto L20;
        com.obric.autoaction.app.launcherpage.shortcut.cell.b r1 = (com.obric.autoaction.app.launcherpage.shortcut.cell.b) ZeusTransformUtils.preCheckCast(((com.obric.autoaction.app.launcherpage.shortcut.cell.a) ZeusTransformUtils.preCheckCast(r14, com.obric.autoaction.app.launcherpage.shortcut.cell.a.class, "com.obric.aiagent.plugin")).a(), com.obric.autoaction.app.launcherpage.shortcut.cell.b.class, "com.obric.aiagent.plugin");
        if (r1 == null) goto L10;
        String r2 = r1.a();
    L12:
        if (d.h.b.o.a(r2, r12.focusId) == false) goto L21;
        com.obric.autoaction.app.launcherpage.module.view.a r3 = com.obric.autoaction.app.launcherpage.module.view.a.f24286a;
        com.obric.autoaction.app.launcherpage.shortcut.cell.b r4 = (com.obric.autoaction.app.launcherpage.shortcut.cell.b) ZeusTransformUtils.preCheckCast(((com.obric.autoaction.app.launcherpage.shortcut.cell.a) ZeusTransformUtils.preCheckCast(r14, com.obric.autoaction.app.launcherpage.shortcut.cell.a.class, "com.obric.aiagent.plugin")).a(), com.obric.autoaction.app.launcherpage.shortcut.cell.b.class, "com.obric.aiagent.plugin");
        if (r4 == null) goto L17;
        String r5 = r4.a();
        if (r5 == null) goto L17;
    L18:
        View r6 = ((com.obric.autoaction.app.launcherpage.shortcut.cell.a) ZeusTransformUtils.preCheckCast(r14, com.obric.autoaction.app.launcherpage.shortcut.cell.a.class, "com.obric.aiagent.plugin")).f35660b;
        d.h.b.o.c(r6, "itemView");
        com.obric.autoaction.app.launcherpage.module.view.a.a(r3, r5, r6, null, 0.0f, 0.0f, 0, 60, null);
        r12.focusId = null;
        return;
    L17:
        r5 = "";
        goto L18
    L21:
        return;
    L10:
        r2 = null;
        goto L12
    }
}
