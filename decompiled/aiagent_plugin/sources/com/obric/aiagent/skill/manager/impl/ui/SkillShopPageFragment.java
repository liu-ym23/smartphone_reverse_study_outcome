package com.obric.aiagent.skill.manager.impl.ui;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.bdturing.localstorage.DbHelper;
import com.obric.aiagent.plugin.R;
import com.obric.cae.libs.useraware.ApWakeEvent;
import com.obric.oui.orecyclerview.widget.LinearLayoutManager;
import com.obric.oui.orecyclerview.widget.RecyclerView;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: SkillShopPageFragment.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class SkillShopPageFragment extends Fragment {
    private static final String ARG_APP_FUNCTION_ENTRY_ENABLED = "app_function_entry_enabled";
    private static final String ARG_CATEGORY_ID = "category_id";
    private static final String ARG_RECOMMENDED = "recommended";
    private static final String ARG_TITLE = "title";
    public static final a Companion = null;
    private final d.f appFunctionEntryEnabled$delegate;
    private boolean canLoadMore;
    private final d.f channel$delegate;
    private bw discoveryAdapter;
    private ck loadMoreAdapter;
    private final d.f viewModel$delegate;

    /* JADX INFO: compiled from: SkillShopPageFragment.kt */
    public static final class a {
        public /* synthetic */ a(d.h.b.h r1) {
            this();
        }

        private a() {
        }

        public static final /* synthetic */ bu a(a r0, Bundle r1) {
            return r0.a(r1);
        }

        public final SkillShopPageFragment a(bu r4, boolean r5) {
            d.h.b.o.e(r4, "channel");
            SkillShopPageFragment r3 = new SkillShopPageFragment();
            Bundle r0 = new Bundle();
            r0.putBoolean(SkillShopPageFragment.ARG_RECOMMENDED, r4.f());
            r0.putString(SkillShopPageFragment.ARG_CATEGORY_ID, r4.c());
            r0.putString("title", r4.b());
            r0.putBoolean(SkillShopPageFragment.ARG_APP_FUNCTION_ENTRY_ENABLED, r5);
            r3.setArguments(r0);
            return r3;
        }

        private final bu a(Bundle r4) {
            if (r4 != null) goto L5;
            return null;
        L5:
            String r0 = r4.getString("title");
            if (r0 != null) goto L9;
            r0 = "";
        L9:
            if (r4.getBoolean(SkillShopPageFragment.ARG_RECOMMENDED, false) == true) goto L11;
            String r5 = r4.getString(SkillShopPageFragment.ARG_CATEGORY_ID);
            if (r5 != null) goto L15;
            return null;
        L15:
            if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r5, CharSequence.class, "com.obric.aiagent.plugin"))) == true) goto L18;
            r5 = null;
        L18:
            if (r5 != null) goto L20;
            return null;
        L20:
            return (bu) ZeusTransformUtils.preCheckCast(new bu.a(r5, r0), bu.class, "com.obric.aiagent.plugin");
        L11:
            return (bu) ZeusTransformUtils.preCheckCast(new bu.c(r0), bu.class, "com.obric.aiagent.plugin");
        }
    }

    /* JADX INFO: compiled from: SkillShopPageFragment.kt */
    private static final class b extends RecyclerView.g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final bw f20474a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f20475b;

        public b(bw r2, int r3) {
            d.h.b.o.e(r2, "adapter");
            this.f20474a = r2;
            this.f20475b = r3;
        }

        @Override // com.obric.oui.orecyclerview.widget.RecyclerView.g
        public void a(Rect r2, View r3, RecyclerView r4, RecyclerView.s r5) {
            d.h.b.o.e(r2, "outRect");
            d.h.b.o.e(r3, "view");
            d.h.b.o.e(r4, "parent");
            d.h.b.o.e(r5, "state");
            if (r4.getChildAdapterPosition(r3) == 1) goto L5;
            return;
        L5:
            if (this.f20474a.a() > 1) goto L7;
            return;
        L7:
            if (this.f20474a.a(0) != 0) goto L12;
            r2.top = this.f20475b;
            return;
        }
    }

    /* JADX INFO: compiled from: SkillShopPageFragment.kt */
    public static final class c extends RecyclerView.m {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ bw f20476a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ SkillShopPageFragment f20477b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ LinearLayoutManager f20478c;

        public static /* synthetic */ void lambda$s0quPW4V9ymhv57FkRkGjsx8uzo(SkillShopPageFragment r0, bu r1) {
            a(r0, r1);
        }

        c(bw r1, SkillShopPageFragment r2, LinearLayoutManager r3) {
            this.f20476a = r1;
            this.f20477b = r2;
            this.f20478c = r3;
        }

        @Override // com.obric.oui.orecyclerview.widget.RecyclerView.m
        public void a(RecyclerView r1, int r2, int r3) {
            d.h.b.o.e(r1, "recyclerView");
            if (r3 > 0) goto L5;
            return;
        L5:
            if (this.f20476a.a() != 0) goto L7;
            return;
        L7:
            if (SkillShopPageFragment.access$getCanLoadMore$p(this.f20477b) == true) goto L10;
            return;
        L10:
            if (this.f20478c.q() < (this.f20476a.a() - 1)) goto L18;
            final bu r4 = SkillShopPageFragment.access$getChannel(this.f20477b);
            if (r4 != null) goto L14;
            return;
        L14:
            final SkillShopPageFragment r0 = this.f20477b;
            r1.post(new $$Lambda$SkillShopPageFragment$c$s0quPW4V9ymhv57FkRkGjsx8uzo(r0, r4));
            return;
        }

        private static final void a(SkillShopPageFragment r0, bu r1) {
            SkillShopPageFragment.access$getViewModel(r0).b(r1);
        }
    }

    /* JADX INFO: compiled from: SkillShopPageFragment.kt */
    @d.c.b.a.f(b = "SkillShopPageFragment.kt", c = {ApWakeEvent.OTHER_END}, d = "invokeSuspend", e = "com.obric.aiagent.skill.manager.impl.ui.SkillShopPageFragment$onViewCreated$2")
    static final class d extends d.c.b.a.l implements d.h.a.m<kotlinx.coroutines.am, d.c.d<? super d.x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f20479a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ SkillShopPageFragment f20480b;

        d(SkillShopPageFragment r3, d.c.d<? super d> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f20480b = r3;
            super(2, r5);
        }

        public final Object a(kotlinx.coroutines.am r3, d.c.d<? super d.x> r4) {
            return ((d) ZeusTransformUtils.preCheckCast(create((kotlinx.coroutines.am) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), d.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<d.x> create(Object r2, d.c.d<?> r3) {
            d.c.d r4 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new d(this.f20480b, r4), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(kotlinx.coroutines.am r3, d.c.d<? super d.x> r4) {
            return a((kotlinx.coroutines.am) ZeusTransformUtils.preCheckCast(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r6) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f20479a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L6;
            d.o.a(r6);
        L12:
            throw new d.d();
        L6:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            d.o.a(r6);
            kotlinx.coroutines.b.ak<cf> r7 = SkillShopPageFragment.access$getViewModel(this.f20480b).b();
            final SkillShopPageFragment r3 = this.f20480b;
            kotlinx.coroutines.b.i<? super cf> r2 = (kotlinx.coroutines.b.i) ZeusTransformUtils.preCheckCast(new AnonymousClass1(r3), kotlinx.coroutines.b.i.class, "com.obric.aiagent.plugin");
            d.c.d<?> r4 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f20479a = 1;
            if (r7.collect(r2, r4) != r0) goto L12;
            return r0;
        }
    }

    static {
        Companion = new a(null);
    }

    public static /* synthetic */ cg lambda$9vGF9yUu9KWfJPq1NlGJVX1JyjI(SkillShopPageFragment r0) {
        return viewModel_delegate$lambda$0(r0);
    }

    public static /* synthetic */ bu lambda$hFE9j9sDjIHrx8eS0OQki2I75uk(SkillShopPageFragment r0) {
        return channel_delegate$lambda$1(r0);
    }

    public static /* synthetic */ boolean lambda$zeOpNkfzrrBN8DNaWXctEqmvzEk(SkillShopPageFragment r0) {
        return appFunctionEntryEnabled_delegate$lambda$2(r0);
    }

    public SkillShopPageFragment() {
        this.viewModel$delegate = d.g.a(d.j.f38507c, new $$Lambda$SkillShopPageFragment$9vGF9yUu9KWfJPq1NlGJVX1JyjI(this));
        this.channel$delegate = d.g.a(d.j.f38507c, new $$Lambda$SkillShopPageFragment$hFE9j9sDjIHrx8eS0OQki2I75uk(this));
        this.appFunctionEntryEnabled$delegate = d.g.a(d.j.f38507c, new $$Lambda$SkillShopPageFragment$zeOpNkfzrrBN8DNaWXctEqmvzEk(this));
    }

    public static final /* synthetic */ boolean access$getCanLoadMore$p(SkillShopPageFragment r0) {
        return r0.canLoadMore;
    }

    public static final /* synthetic */ bu access$getChannel(SkillShopPageFragment r0) {
        return r0.getChannel();
    }

    public static final /* synthetic */ cg access$getViewModel(SkillShopPageFragment r0) {
        return r0.getViewModel();
    }

    public static final /* synthetic */ void access$render(SkillShopPageFragment r0, cf r1) {
        r0.render(r1);
    }

    private final cg getViewModel() {
        return (cg) ZeusTransformUtils.preCheckCast(this.viewModel$delegate.b(), cg.class, "com.obric.aiagent.plugin");
    }

    private static final cg viewModel_delegate$lambda$0(SkillShopPageFragment r3) {
        FragmentActivity r4 = (FragmentActivity) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r3.requireActivity(), "com.obric.aiagent.plugin"), FragmentActivity.class, "com.obric.aiagent.plugin");
        d.h.b.o.c(r4, "requireActivity(...)");
        return (cg) ZeusTransformUtils.preCheckCast(new androidx.lifecycle.am((androidx.lifecycle.ap) ZeusTransformUtils.preCheckCast(r4, androidx.lifecycle.ap.class, "com.obric.aiagent.plugin")).a(cg.class), cg.class, "com.obric.aiagent.plugin");
    }

    private final bu getChannel() {
        return (bu) ZeusTransformUtils.preCheckCast(this.channel$delegate.b(), bu.class, "com.obric.aiagent.plugin");
    }

    private static final bu channel_delegate$lambda$1(SkillShopPageFragment r1) {
        return a.a(Companion, r1.getArguments());
    }

    private final boolean getAppFunctionEntryEnabled() {
        return ((Boolean) ZeusTransformUtils.preCheckCast(this.appFunctionEntryEnabled$delegate.b(), Boolean.class, "com.obric.aiagent.plugin")).booleanValue();
    }

    private static final boolean appFunctionEntryEnabled_delegate$lambda$2(SkillShopPageFragment r2) {
        Bundle r3 = r2.getArguments();
        if (r3 != null) goto L5;
        return false;
    L5:
        return r3.getBoolean(ARG_APP_FUNCTION_ENTRY_ENABLED, false);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        d.h.b.o.e(r2, "inflater");
        View r1 = ZeusTransformUtils.inflate(r2, ZeusTransformUtils.mapRes(R.layout.fragment_skill_shop_page, "layout", "fragment_skill_shop_page"), r3, false, "com.obric.aiagent.plugin");
        d.h.b.o.c(r1, "inflate(...)");
        return r1;
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View r10, Bundle r11) {
        d.h.b.o.e(r10, "view");
        super.onViewCreated(r10, r11);
        FragmentActivity r12 = (FragmentActivity) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getActivity(), "com.obric.aiagent.plugin"), FragmentActivity.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r12, SkillShopActivity.class) == false) goto L5;
        SkillShopActivity r13 = (SkillShopActivity) ZeusTransformUtils.preCheckCast(r12, SkillShopActivity.class, "com.obric.aiagent.plugin");
    L6:
        if (r13 != null) goto L8;
        return;
    L8:
        cb r14 = r13.pageActionHandler$impl_release();
        RecyclerView r15 = (RecyclerView) ZeusTransformUtils.preCheckCast(r10.findViewById(ZeusTransformUtils.mapRes(R.id.discovery_list, DbHelper.COL_ID, "discovery_list")), RecyclerView.class, "com.obric.aiagent.plugin");
        Resources r1 = ZeusTransformUtils.getResources(this, "com.obric.aiagent.plugin");
        if (getAppFunctionEntryEnabled() == false) goto L11;
        int r3 = ZeusTransformUtils.mapRes(R.dimen.skill_shop_discovery_top_padding_with_primary_tabs, "dimen", "skill_shop_discovery_top_padding_with_primary_tabs");
    L12:
        r15.setPadding(r15.getPaddingLeft(), r1.getDimensionPixelSize(r3), r15.getPaddingRight(), r15.getPaddingBottom());
        d.h.b.o.a(r15);
        bh.a(r15, ZeusTransformUtils.getResources(this, "com.obric.aiagent.plugin").getDimensionPixelSize(ZeusTransformUtils.mapRes(R.dimen.skill_navigation_list_extra_bottom, "dimen", "skill_navigation_list_extra_bottom")));
        LinearLayoutManager r2 = new LinearLayoutManager((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(requireContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"));
        bw r4 = new bw(r14);
        ck r16 = new ck();
        this.discoveryAdapter = r4;
        this.loadMoreAdapter = r16;
        r15.setLayoutManager((RecyclerView.h) ZeusTransformUtils.preCheckCast(r2, RecyclerView.h.class, "com.obric.aiagent.plugin"));
        r15.setItemAnimator(null);
        r15.setAdapter((RecyclerView.a) ZeusTransformUtils.preCheckCast(new com.obric.oui.orecyclerview.widget.g(new RecyclerView.a[]{r4, r16}), RecyclerView.a.class, "com.obric.aiagent.plugin"));
        r15.addItemDecoration((RecyclerView.g) ZeusTransformUtils.preCheckCast(new b(r4, dp(16.0f)), RecyclerView.g.class, "com.obric.aiagent.plugin"));
        r15.addOnScrollListener((RecyclerView.m) ZeusTransformUtils.preCheckCast(new c(r4, this, r2), RecyclerView.m.class, "com.obric.aiagent.plugin"));
        androidx.lifecycle.p r17 = getViewLifecycleOwner();
        d.h.b.o.c(r17, "getViewLifecycleOwner(...)");
        kotlinx.coroutines.i.a((kotlinx.coroutines.am) ZeusTransformUtils.preCheckCast(androidx.lifecycle.q.a(r17), kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), null, null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new d(this, null), d.h.a.m.class, "com.obric.aiagent.plugin"), 3, null);
        return;
    L11:
        r3 = ZeusTransformUtils.mapRes(R.dimen.skill_shop_discovery_top_padding_without_primary_tabs, "dimen", "skill_shop_discovery_top_padding_without_primary_tabs");
        goto L12
    L5:
        r13 = null;
        goto L6
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        bu r0 = getChannel();
        if (r0 == null) goto L6;
        getViewModel().a(r0);
        return;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        this.discoveryAdapter = null;
        this.loadMoreAdapter = null;
        this.canLoadMore = false;
        super.onDestroyView();
    }

    private final void render(cf r8) {
        bu r1 = getChannel();
        if (r1 != null) goto L5;
        return;
    L5:
        cd r0 = r8.a(r1);
        boolean r3 = true;
        if (r0.c() == true) goto L8;
    L12:
        boolean r2 = false;
    L13:
        this.canLoadMore = r2;
        ck r4 = this.loadMoreAdapter;
        if (r4 != null) goto L16;
    L22:
        bw r7 = this.discoveryAdapter;
        if (r7 == null) goto L26;
        r7.a(r1, r0.a(), r8.b(), r8.d(), r8.e(), r8.f());
        return;
    L26:
        return;
    L16:
        if (r0.b() == true) goto L18;
    L20:
        r3 = false;
    L21:
        r4.b_(r3);
        goto L22
    L18:
        if (r0.c() == false) goto L20;
    L8:
        if (r0.d() == false) goto L12;
        if (r0.b() == true) goto L12;
        r2 = true;
        goto L13
    }

    private final int dp(float r2) {
        return (int) ((r2 * ZeusTransformUtils.getResources(this, "com.obric.aiagent.plugin").getDisplayMetrics().density) + 0.5f);
    }
}
