package com.obric.autoaction.app.launcherpage.module.view;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bytedance.bdturing.localstorage.DbHelper;
import com.google.protobuf.DescriptorProtos;
import com.obric.aiagent.plugin.R;
import com.obric.autoaction.app.launcherpage.module.a.a.g;
import com.obric.autoaction.app.launcherpage.module.a.a.k;
import com.obric.autoaction.app.launcherpage.module.a.i;
import com.obric.autoaction.app.launcherpage.ui.l;
import com.obric.autoaction.app.launcherpage.ui.m;
import com.obric.autoaction.app.launcherpage.ui.n;
import com.obric.autoaction.app.launcherpage.ui.q;
import com.obric.autoaction.app.launcherpage.utils.p;
import com.obric.autogui.common.api.AODeviceSpecificTools;
import com.obric.oui.orecyclerview.widget.LinearLayoutManager;
import com.obric.oui.orecyclerview.widget.RecyclerView;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;
import d.x;
import java.time.LocalDate;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: AutoActionTaskList.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class AutoActionTaskList extends FrameLayout {
    public static final a Companion = null;
    private static final String TAG = "AA-TaskList";
    private final int bottomSepShowingThreshold;
    private d.h.a.a<x> loadMoreAction;
    private View mEmptyView;
    private d mEmptyViewAdapter;
    private final RecyclerView mRv;
    private final m<com.obric.autoaction.app.launcherpage.module.a.a.f> mRvAdapter;
    private b mScrollStateChangedListener;
    private final View mView;
    private boolean needScrollToTodayOnFirstLoad;
    private final float preloadThreshold;
    private final int topSepShowingThreshold;

    /* JADX INFO: compiled from: AutoActionTaskList.kt */
    public static final class a {
        public /* synthetic */ a(h r1) {
            this();
        }

        private a() {
        }
    }

    /* JADX INFO: compiled from: AutoActionTaskList.kt */
    public interface b {
        void onScrollStateChanged(boolean r1, boolean r2);
    }

    /* JADX INFO: compiled from: AutoActionTaskList.kt */
    public static final class c extends RecyclerView.m {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ AutoActionTaskList f24279a;

        c(AutoActionTaskList r1) {
            this.f24279a = r1;
        }

        @Override // com.obric.oui.orecyclerview.widget.RecyclerView.m
        public void a(RecyclerView r2, int r3, int r4) {
            o.e(r2, "recyclerView");
            super.a(r2, r3, r4);
            AutoActionTaskList.access$checkScrollBounds(this.f24279a, r2);
        }

        @Override // com.obric.oui.orecyclerview.widget.RecyclerView.m
        public void a(RecyclerView r2, int r3) {
            o.e(r2, "recyclerView");
            super.a(r2, r3);
            if (r3 != 0) goto L6;
            AutoActionTaskList.access$checkScrollBounds(this.f24279a, r2);
            return;
        }
    }

    /* JADX INFO: compiled from: AutoActionTaskList.kt */
    public static final class d extends RecyclerView.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ AutoActionTaskList f24280a;

        d(AutoActionTaskList r1) {
            this.f24280a = r1;
        }

        @Override // com.obric.oui.orecyclerview.widget.RecyclerView.b
        public void a(int r1, int r2) {
            super.a(r1, r2);
            AutoActionTaskList.access$refreshEmptyView(this.f24280a);
        }

        @Override // com.obric.oui.orecyclerview.widget.RecyclerView.b
        public void b(int r1, int r2) {
            super.b(r1, r2);
            AutoActionTaskList.access$refreshEmptyView(this.f24280a);
        }
    }

    static {
        Companion = new a(null);
    }

    public AutoActionTaskList(Context r7) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.aiagent.plugin");
        o.e(r1, "context");
        this(r1, null, 0, 6, null);
    }

    public AutoActionTaskList(Context r9, AttributeSet r10) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r4 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r10, AttributeSet.class, "com.obric.aiagent.plugin");
        o.e(r3, "context");
        this(r3, r4, 0, 4, null);
    }

    public static /* synthetic */ x lambda$3hZrigPzYJLZXKzKeBaVeJNO6Ig(d.h.a.b r0, List r1, l r2) {
        return attachSortController$lambda$5(r0, r1, r2);
    }

    public static /* synthetic */ String lambda$LBVLIGZqsbUckuGWBxiANhzYrxo(com.obric.autoaction.app.launcherpage.module.a.a.f r0) {
        return attachSortController$lambda$4(r0);
    }

    /* JADX INFO: renamed from: lambda$XMB_EFBrXtvIyQuO6-utqnQASAk, reason: not valid java name */
    public static /* synthetic */ x m549lambda$XMB_EFBrXtvIyQuO6utqnQASAk(AutoActionTaskList r0, List r1, d.h.a.b r2) {
        return submitData$lambda$2(r0, r1, r2);
    }

    public static /* synthetic */ void lambda$YjwBebxUsLcHnEPC9U_ClbD0Wwc(AutoActionTaskList r0) {
        maybeScrollToTop$lambda$8(r0);
    }

    /* JADX INFO: renamed from: lambda$onMnWgxt0YUoFJiDtb3OswQ-R-8, reason: not valid java name */
    public static /* synthetic */ void m550lambda$onMnWgxt0YUoFJiDtb3OswQR8(int r0, AutoActionTaskList r1) {
        maybeScrollToToday$lambda$7(r0, r1);
    }

    public static /* synthetic */ boolean lambda$vwmcKQqwBDJgMzJPwh6R0fBAEWU(com.obric.autoaction.app.launcherpage.module.a.a.f r0) {
        return attachSortController$lambda$3(r0);
    }

    public /* synthetic */ AutoActionTaskList(Context r2, AttributeSet r3, int r4, int r5, h r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r8 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r3, AttributeSet.class, "com.obric.aiagent.plugin");
        if ((r5 & 2) == 0) goto L6;
        r8 = null;
    L6:
        if ((r5 & 4) == 0) goto L8;
        r4 = 0;
    L8:
        this(r7, r8, r4);
    }

    public static final /* synthetic */ void access$checkScrollBounds(AutoActionTaskList r0, RecyclerView r1) {
        r0.checkScrollBounds(r1);
    }

    public static final /* synthetic */ void access$refreshEmptyView(AutoActionTaskList r0) {
        r0.refreshEmptyView();
    }

    public AutoActionTaskList(Context r8, AttributeSet r9, int r10) {
        Context r11 = (Context) ZeusTransformUtils.wrapperContextForParams(r8, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r12 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r9, AttributeSet.class, "com.obric.aiagent.plugin");
        o.e(r11, "context");
        super(r11, r12, r10);
        View r13 = ZeusTransformUtils.inflate(LayoutInflater.from(r11), ZeusTransformUtils.mapRes(R.layout.autoaction_task_list, "layout", "autoaction_task_list"), (ViewGroup) ZeusTransformUtils.preCheckCast(this, ViewGroup.class, "com.obric.aiagent.plugin"), true, "com.obric.aiagent.plugin");
        o.c(r13, "inflate(...)");
        this.mView = r13;
        this.needScrollToTodayOnFirstLoad = true;
        d.m<Integer, Integer> r14 = AODeviceSpecificTools.INSTANCE.getScreenDimensions();
        if (r14 == null) goto L5;
        int r15 = ((Number) ZeusTransformUtils.preCheckCast(r14.b(), Number.class, "com.obric.aiagent.plugin")).intValue();
    L6:
        this.preloadThreshold = r15 * 1.5f;
        this.mEmptyViewAdapter = new d(this);
        this.topSepShowingThreshold = ZeusTransformUtils.getResources(r11, "com.obric.aiagent.plugin").getDimensionPixelSize(ZeusTransformUtils.mapRes(R.dimen.aa_tl_sep_top_scroll_threshold, "dimen", "aa_tl_sep_top_scroll_threshold"));
        this.bottomSepShowingThreshold = ZeusTransformUtils.getResources(r11, "com.obric.aiagent.plugin").getDimensionPixelSize(ZeusTransformUtils.mapRes(R.dimen.aa_tl_sep_bottom_scroll_threshold, "dimen", "aa_tl_sep_bottom_scroll_threshold"));
        View r16 = r13.findViewById(ZeusTransformUtils.mapRes(R.id.aa_task_list, DbHelper.COL_ID, "aa_task_list"));
        o.c(r16, "findViewById(...)");
        RecyclerView r17 = (RecyclerView) ZeusTransformUtils.preCheckCast(r16, RecyclerView.class, "com.obric.aiagent.plugin");
        this.mRv = r17;
        m<com.obric.autoaction.app.launcherpage.module.a.a.f> r18 = new m(r17, false, 2, null);
        this.mRvAdapter = r18;
        r17.setOverScrollMode(0);
        r17.addItemDecoration((RecyclerView.g) ZeusTransformUtils.preCheckCast(new com.obric.autoaction.app.launcherpage.module.view.c(d.i.a.a(TypedValue.applyDimension(1, 8, Resources.getSystem().getDisplayMetrics())), false, 2, null), RecyclerView.g.class, "com.obric.aiagent.plugin"));
        initTaskList();
        r18.a((RecyclerView.b) ZeusTransformUtils.preCheckCast(this.mEmptyViewAdapter, RecyclerView.b.class, "com.obric.aiagent.plugin"));
        return;
    L5:
        r15 = d.i.a.a(TypedValue.applyDimension(1, DescriptorProtos.Edition.EDITION_LEGACY_VALUE, Resources.getSystem().getDisplayMetrics()));
        goto L6
    }

    public final d.h.a.a<x> getLoadMoreAction() {
        return this.loadMoreAction;
    }

    public final void setLoadMoreAction(d.h.a.a<x> r3) {
        this.loadMoreAction = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r3, d.h.a.a.class, "com.obric.aiagent.plugin");
    }

    public final boolean getNeedScrollToTodayOnFirstLoad() {
        return this.needScrollToTodayOnFirstLoad;
    }

    public final void setNeedScrollToTodayOnFirstLoad(boolean r1) {
        this.needScrollToTodayOnFirstLoad = r1;
    }

    private final void refreshEmptyView() {
        View r0 = this.mEmptyView;
        if (r0 != null) goto L5;
        return;
    L5:
        if (this.mRvAdapter.a() != 0) goto L7;
        int r1 = 0;
    L8:
        r0.setVisibility(r1);
        return;
    L7:
        r1 = 8;
        goto L8
    }

    public final void bindEmptyView(View r1) {
        this.mEmptyView = r1;
        if (r1 == null) goto L6;
        refreshEmptyView();
        return;
    }

    public final void addListControl(i r3) {
        i r4 = (i) ZeusTransformUtils.wrapperContextForParams(r3, i.class, "com.obric.aiagent.plugin");
        o.e(r4, "control");
        this.mRvAdapter.a(r4);
    }

    private final void checkScrollBounds(RecyclerView r6) {
        int r0 = r6.computeVerticalScrollOffset();
        boolean r2 = true;
        if (r0 > this.topSepShowingThreshold) goto L5;
        boolean r1 = true;
    L6:
        int r4 = r6.computeVerticalScrollRange();
        int r7 = r6.computeVerticalScrollExtent();
        if (r4 <= r7) goto L9;
        int r5 = r4 - r7;
    L10:
        int r8 = r5 - r0;
        if (r8 < this.bottomSepShowingThreshold) goto L14;
        r2 = false;
    L14:
        b r9 = this.mScrollStateChangedListener;
        if (r9 == null) goto L18;
        r9.onScrollStateChanged(r1, r2);
    L18:
        if (r8 < this.preloadThreshold) goto L20;
        if (r2 == true) goto L20;
        return;
    L20:
        d.h.a.a<x> r10 = this.loadMoreAction;
        if (r10 == null) goto L25;
        r10.invoke();
        return;
    L25:
        return;
    L9:
        r5 = 0;
        goto L10
    L5:
        r1 = false;
        goto L6
    }

    private final void initTaskList() {
        this.mRvAdapter.a(new Class[]{com.obric.autoaction.app.launcherpage.module.a.c.class, com.obric.autoaction.app.launcherpage.module.a.b.class, com.obric.autoaction.app.launcherpage.module.a.f.class, com.obric.autoaction.app.launcherpage.module.a.e.class, com.obric.autoaction.app.launcherpage.module.a.a.class, com.obric.autoaction.app.launcherpage.module.a.d.class});
        RecyclerView r0 = this.mRv;
        Context r2 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        o.c(r2, "getContext(...)");
        r0.setLayoutManager((RecyclerView.h) ZeusTransformUtils.preCheckCast(new q(r2), RecyclerView.h.class, "com.obric.aiagent.plugin"));
        this.mRv.addOnScrollListener((RecyclerView.m) ZeusTransformUtils.preCheckCast(new c(this), RecyclerView.m.class, "com.obric.aiagent.plugin"));
    }

    public final void focusPosition(int r4) {
        RecyclerView.h r3 = this.mRv.getLayoutManager();
        o.a(r3, "null cannot be cast to non-null type com.obric.oui.orecyclerview.widget.LinearLayoutManager");
        ((LinearLayoutManager) ZeusTransformUtils.preCheckCast(r3, LinearLayoutManager.class, "com.obric.aiagent.plugin")).b(r4, d.i.a.a(TypedValue.applyDimension(1, 50, Resources.getSystem().getDisplayMetrics())));
    }

    public final void notifyItemChanged() {
        this.mRvAdapter.g();
    }

    public final void highLightPosition(int r10) {
        RecyclerView.v r9 = this.mRv.findViewHolderForAdapterPosition(r10);
        k r1 = null;
        if (ZeusTransformUtils.instanceOf(r9, com.obric.autoaction.app.launcherpage.ui.f.class) == false) goto L5;
        com.obric.autoaction.app.launcherpage.ui.f r11 = (com.obric.autoaction.app.launcherpage.ui.f) ZeusTransformUtils.preCheckCast(r9, com.obric.autoaction.app.launcherpage.ui.f.class, "com.obric.aiagent.plugin");
    L6:
        if (r11 == null) goto L8;
        com.obric.autoaction.app.launcherpage.ui.h r12 = r11.a();
    L10:
        if (ZeusTransformUtils.instanceOf(r12, k.class) == false) goto L12;
        r1 = (k) ZeusTransformUtils.preCheckCast(r12, k.class, "com.obric.aiagent.plugin");
    L12:
        if (r1 == null) goto L15;
        String r13 = r1.g();
        if (r13 == null) goto L15;
    L16:
        String r2 = r13;
        if (r9 == null) goto L20;
        com.obric.autoaction.app.launcherpage.module.view.a r0 = com.obric.autoaction.app.launcherpage.module.view.a.f24286a;
        View r3 = r9.f35660b;
        o.c(r3, "itemView");
        com.obric.autoaction.app.launcherpage.module.view.a.a(r0, r2, r3, null, 0.0f, 0.0f, 0, 60, null);
        return;
    L20:
        return;
    L15:
        r13 = "";
        goto L16
    L8:
        r12 = null;
        goto L10
    L5:
        r11 = null;
        goto L6
    }

    public static /* synthetic */ void submitData$default(AutoActionTaskList r1, List r2, d.h.a.b r3, int r4, Object r5) {
        List<? extends com.obric.autoaction.app.launcherpage.module.a.a.f> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.aiagent.plugin");
        d.h.a.b<? super List<? extends com.obric.autoaction.app.launcherpage.module.a.a.f>, x> r7 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r3, d.h.a.b.class, "com.obric.aiagent.plugin");
        if ((r4 & 2) == 0) goto L5;
        r7 = null;
    L5:
        r1.submitData(r6, r7);
    }

    public final void submitData(List<? extends com.obric.autoaction.app.launcherpage.module.a.a.f> r3, d.h.a.b<? super List<? extends com.obric.autoaction.app.launcherpage.module.a.a.f>, x> r4) {
        final List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
        final d.h.a.b r6 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r4, d.h.a.b.class, "com.obric.aiagent.plugin");
        o.e(r5, "data");
        this.mRvAdapter.a(r5, new $$Lambda$AutoActionTaskList$XMB_EFBrXtvIyQuO6utqnQASAk(this, r5, r6));
    }

    private static final x submitData$lambda$2(AutoActionTaskList r2, List r3, d.h.a.b r4) {
        List<? extends com.obric.autoaction.app.launcherpage.module.a.a.f> r5 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
        d.h.a.b r6 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r4, d.h.a.b.class, "com.obric.aiagent.plugin");
        r2.maybeScrollToToday(r5);
        if (r6 == null) goto L6;
        r6.invoke(r5);
    L6:
        return x.f38692a;
    }

    public final void attachSortController(d.h.a.b<? super List<String>, x> r8) {
        final d.h.a.b r9 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r8, d.h.a.b.class, "com.obric.aiagent.plugin");
        o.e(r9, "onOrderChanged");
        new n(this.mRv, this.mRvAdapter, $$Lambda$AutoActionTaskList$vwmcKQqwBDJgMzJPwh6R0fBAEWU.INSTANCE, $$Lambda$AutoActionTaskList$LBVLIGZqsbUckuGWBxiANhzYrxo.INSTANCE, new $$Lambda$AutoActionTaskList$3hZrigPzYJLZXKzKeBaVeJNO6Ig(r9)).a();
    }

    private static final boolean attachSortController$lambda$3(com.obric.autoaction.app.launcherpage.module.a.a.f r1) {
        o.e(r1, "it");
        return ZeusTransformUtils.instanceOf(r1, com.obric.autoaction.app.launcherpage.module.a.a.b.class);
    }

    private static final String attachSortController$lambda$4(com.obric.autoaction.app.launcherpage.module.a.a.f r3) {
        o.e(r3, "it");
        if (ZeusTransformUtils.instanceOf(r3, com.obric.autoaction.app.launcherpage.module.a.a.b.class) == false) goto L5;
        com.obric.autoaction.app.launcherpage.module.a.a.b r4 = (com.obric.autoaction.app.launcherpage.module.a.a.b) ZeusTransformUtils.preCheckCast(r3, com.obric.autoaction.app.launcherpage.module.a.a.b.class, "com.obric.aiagent.plugin");
    L6:
        if (r4 != null) goto L8;
        return null;
    L8:
        return r4.a();
    L5:
        r4 = null;
        goto L6
    }

    private static final x attachSortController$lambda$5(d.h.a.b r2, List r3, l r4) {
        d.h.a.b r5 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r2, d.h.a.b.class, "com.obric.aiagent.plugin");
        List r6 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
        o.e(r6, "orderedTaskIds");
        o.e(r4, "<unused var>");
        r5.invoke(r6);
        return x.f38692a;
    }

    private final void maybeScrollToToday(List<? extends com.obric.autoaction.app.launcherpage.module.a.a.f> r7) {
        List r8 = (List) ZeusTransformUtils.wrapperContextForParams(r7, List.class, "com.obric.aiagent.plugin");
        if (this.needScrollToTodayOnFirstLoad == true) goto L5;
        return;
    L5:
        LocalDate r0 = LocalDate.now();
        Iterator r9 = r8.iterator();
        final int r3 = 0;
    L7:
        if (r9.hasNext() == false) goto L17;
        com.obric.autoaction.app.launcherpage.module.a.a.f r4 = (com.obric.autoaction.app.launcherpage.module.a.a.f) ZeusTransformUtils.preCheckCast(r9.next(), com.obric.autoaction.app.launcherpage.module.a.a.f.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r4, g.class) == true) goto L11;
    L13:
        boolean r5 = false;
    L14:
        if (r5 == true) goto L18;
        r3 = r3 + 1;
    L18:
        this.mRv.post(new $$Lambda$AutoActionTaskList$onMnWgxt0YUoFJiDtb3OswQR8(r3, this));
        return;
    L11:
        if (o.a(((g) ZeusTransformUtils.preCheckCast(r4, g.class, "com.obric.aiagent.plugin")).a(), r0) == false) goto L13;
        r5 = true;
        goto L14
    L17:
        r3 = -1;
        goto L18
    }

    private static final void maybeScrollToToday$lambda$7(int r1, AutoActionTaskList r2) {
        if (r1 == (-1)) goto L6;
        r2.needScrollToTodayOnFirstLoad = false;
        r2.focusPosition(r1);
        return;
    }

    public final void maybeScrollToTop() {
        if (this.mRv.computeVerticalScrollOffset() > this.topSepShowingThreshold) goto L6;
        this.mRv.post(new $$Lambda$AutoActionTaskList$YjwBebxUsLcHnEPC9U_ClbD0Wwc(this));
        return;
    }

    private static final void maybeScrollToTop$lambda$8(AutoActionTaskList r1) {
        if (r1.mRvAdapter.a() <= 0) goto L6;
        r1.mRv.scrollToPosition(0);
        return;
    }

    public final void setScrollStateChangedListener(b r3) {
        b r4 = (b) ZeusTransformUtils.wrapperContextForParams(r3, b.class, "com.obric.aiagent.plugin");
        o.e(r4, "listener");
        this.mScrollStateChangedListener = r4;
    }

    public static /* synthetic */ void applyBottomNavInsetPadding$default(AutoActionTaskList r0, boolean r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = false;
    L5:
        r0.applyBottomNavInsetPadding(r1);
    }

    public final void applyBottomNavInsetPadding(boolean r4) {
        p.a((View) ZeusTransformUtils.preCheckCast(this.mRv, View.class, "com.obric.aiagent.plugin"), 0, r4, 1, null);
    }
}
