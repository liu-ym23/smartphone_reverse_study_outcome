package com.obric.autoaction.app.launcherpage.condition.location;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bytedance.bdturing.localstorage.DbHelper;
import com.obric.aiagent.plugin.R;
import com.obric.autoaction.app.launcherpage.ui.q;
import com.obric.autoaction.app.launcherpage.utils.p;
import com.obric.oui.blur.OBlurMaskView;
import com.obric.oui.forms.OEditText;
import com.obric.oui.orecyclerview.widget.RecyclerView;
import com.obric.oui.searchbar.v2.OSearchBar;
import com.obric.oui.titlebar.OFloatingTitleBar;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.x;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: ConditionEventLocationView.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class ConditionEventLocationView extends FrameLayout {
    private d.h.a.b<? super Editable, x> afterTextChanged;
    private View confirmButton;
    private final d.f locationAdapter$delegate;
    private final d.f locationRecyclerView$delegate;
    private final d.f locationRecyclerViewContainer$delegate;
    private final d.f locationSearchBar$delegate;
    private final d.f locationTitleBar$delegate;
    private final d.f maskView$delegate;
    private d.h.a.b<? super View, x> onBackListener;
    private d.h.a.b<? super View, x> onConfirmListener;
    private final String searchHint;
    private final boolean showConfirmAction;
    private final int startActionIcon;
    private final String title;

    public ConditionEventLocationView(Context r10) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r10, Context.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r1, "context");
        this(r1, null, null, null, 0, false, 62, null);
    }

    public ConditionEventLocationView(Context r12, AttributeSet r13) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r12, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r4 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r13, AttributeSet.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r3, "context");
        this(r3, r4, null, null, 0, false, 60, null);
    }

    public ConditionEventLocationView(Context r12, AttributeSet r13, String r14) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r12, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r4 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r13, AttributeSet.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r3, "context");
        this(r3, r4, r14, null, 0, false, 56, null);
    }

    public ConditionEventLocationView(Context r12, AttributeSet r13, String r14, String r15) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r12, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r4 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r13, AttributeSet.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r3, "context");
        this(r3, r4, r14, r15, 0, false, 48, null);
    }

    public ConditionEventLocationView(Context r12, AttributeSet r13, String r14, String r15, int r16) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r12, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r4 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r13, AttributeSet.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r3, "context");
        this(r3, r4, r14, r15, r16, false, 32, null);
    }

    /* JADX INFO: renamed from: lambda$6-G7YFnUazbxUVfguZ2WMeXUQYo, reason: not valid java name */
    public static /* synthetic */ OSearchBar m453lambda$6G7YFnUazbxUVfguZ2WMeXUQYo(ConditionEventLocationView r0) {
        return locationSearchBar_delegate$lambda$3(r0);
    }

    public static /* synthetic */ RecyclerView lambda$BkzCfBSpw6Bfj8unhSt3WivFzq4(ConditionEventLocationView r0) {
        return locationRecyclerView_delegate$lambda$0(r0);
    }

    public static /* synthetic */ void lambda$LC4LaLEJcxa_DE9fDOw1owpk3Ws(ConditionEventLocationView r0, View r1) {
        initView$lambda$10$lambda$9(r0, r1);
    }

    public static /* synthetic */ x lambda$OFZWeUA2qxwS4Ho8jH9ojV67hpw(ConditionEventLocationView r0, View r1) {
        return initView$lambda$10$lambda$7(r0, r1);
    }

    public static /* synthetic */ b lambda$TCpG4s6sOdb94jl2BvGgo1wl46I(Context r0) {
        return locationAdapter_delegate$lambda$2(r0);
    }

    public static /* synthetic */ OBlurMaskView lambda$hObg2LR7WSz0aO_t2l9idTsg8xQ(ConditionEventLocationView r0) {
        return maskView_delegate$lambda$5(r0);
    }

    /* JADX INFO: renamed from: lambda$j-nG_bI3JuqmzpsTH6KousKzG4E, reason: not valid java name */
    public static /* synthetic */ x m454lambda$jnG_bI3JuqmzpsTH6KousKzG4E(ConditionEventLocationView r0, View r1) {
        return initView$lambda$10$lambda$8(r0, r1);
    }

    /* JADX INFO: renamed from: lambda$pDuqKZvRe-4gmYhhnT4IiviTK4M, reason: not valid java name */
    public static /* synthetic */ OFloatingTitleBar m455lambda$pDuqKZvRe4gmYhhnT4IiviTK4M(ConditionEventLocationView r0) {
        return locationTitleBar_delegate$lambda$4(r0);
    }

    public static /* synthetic */ ViewGroup lambda$su67CrgTebrr5hl4_xYXFEqbBv0(ConditionEventLocationView r0) {
        return locationRecyclerViewContainer_delegate$lambda$1(r0);
    }

    public static final /* synthetic */ d.h.a.b access$getAfterTextChanged$p(ConditionEventLocationView r0) {
        return r0.afterTextChanged;
    }

    public /* synthetic */ ConditionEventLocationView(Context r5, AttributeSet r6, String r7, String r8, int r9, boolean r10, int r11, d.h.b.h r12) {
        Context r13 = (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r14 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r6, AttributeSet.class, "com.obric.aiagent.plugin");
        String r0 = null;
        if ((r11 & 2) == 0) goto L5;
        AttributeSet r15 = null;
    L7:
        if ((r11 & 4) == 0) goto L9;
        String r1 = null;
    L11:
        if ((r11 & 8) != 0) goto L15;
        r0 = r8;
    L15:
        if ((r11 & 16) == 0) goto L17;
        r9 = ZeusTransformUtils.mapRes(R.drawable.oui_ic_title_bar_back, "drawable", "oui_ic_title_bar_back");
    L17:
        int r2 = r9;
        if ((r11 & 32) == 0) goto L20;
        r10 = true;
    L20:
        this(r13, r15, r1, r0, r2, r10);
        return;
    L9:
        r1 = r7;
        goto L11
    L5:
        r15 = r14;
        goto L7
    }

    public ConditionEventLocationView(Context r3, AttributeSet r4, String r5, String r6, int r7, boolean r8) {
        final Context r9 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r10 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r9, "context");
        super(r9, r10);
        this.title = r5;
        this.searchHint = r6;
        this.startActionIcon = r7;
        this.showConfirmAction = r8;
        this.locationRecyclerView$delegate = d.g.a(new $$Lambda$ConditionEventLocationView$BkzCfBSpw6Bfj8unhSt3WivFzq4(this));
        this.locationRecyclerViewContainer$delegate = d.g.a(new $$Lambda$ConditionEventLocationView$su67CrgTebrr5hl4_xYXFEqbBv0(this));
        this.locationAdapter$delegate = d.g.a(new $$Lambda$ConditionEventLocationView$TCpG4s6sOdb94jl2BvGgo1wl46I(r9));
        this.locationSearchBar$delegate = d.g.a(new $$Lambda$ConditionEventLocationView$6G7YFnUazbxUVfguZ2WMeXUQYo(this));
        this.locationTitleBar$delegate = d.g.a(new $$Lambda$ConditionEventLocationView$pDuqKZvRe4gmYhhnT4IiviTK4M(this));
        this.maskView$delegate = d.g.a(new $$Lambda$ConditionEventLocationView$hObg2LR7WSz0aO_t2l9idTsg8xQ(this));
        ZeusTransformUtils.inflate(LayoutInflater.from(r9), ZeusTransformUtils.mapRes(R.layout.condition_event_location_layout, "layout", "condition_event_location_layout"), (ViewGroup) ZeusTransformUtils.preCheckCast(this, ViewGroup.class, "com.obric.aiagent.plugin"), "com.obric.aiagent.plugin");
        initView();
    }

    private final RecyclerView getLocationRecyclerView() {
        return (RecyclerView) ZeusTransformUtils.preCheckCast(this.locationRecyclerView$delegate.b(), RecyclerView.class, "com.obric.aiagent.plugin");
    }

    private static final RecyclerView locationRecyclerView_delegate$lambda$0(ConditionEventLocationView r3) {
        return (RecyclerView) ZeusTransformUtils.preCheckCast(r3.findViewById(ZeusTransformUtils.mapRes(R.id.condition_location_recycler_view, DbHelper.COL_ID, "condition_location_recycler_view")), RecyclerView.class, "com.obric.aiagent.plugin");
    }

    private final ViewGroup getLocationRecyclerViewContainer() {
        return (ViewGroup) ZeusTransformUtils.preCheckCast(this.locationRecyclerViewContainer$delegate.b(), ViewGroup.class, "com.obric.aiagent.plugin");
    }

    private static final ViewGroup locationRecyclerViewContainer_delegate$lambda$1(ConditionEventLocationView r3) {
        return (ViewGroup) ZeusTransformUtils.preCheckCast(r3.findViewById(ZeusTransformUtils.mapRes(R.id.condition_location_recycler_view_container, DbHelper.COL_ID, "condition_location_recycler_view_container")), ViewGroup.class, "com.obric.aiagent.plugin");
    }

    private final b getLocationAdapter() {
        return (b) ZeusTransformUtils.preCheckCast(this.locationAdapter$delegate.b(), b.class, "com.obric.aiagent.plugin");
    }

    private static final b locationAdapter_delegate$lambda$2(Context r2) {
        return new b((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin"));
    }

    private final OSearchBar getLocationSearchBar() {
        return (OSearchBar) ZeusTransformUtils.preCheckCast(this.locationSearchBar$delegate.b(), OSearchBar.class, "com.obric.aiagent.plugin");
    }

    private static final OSearchBar locationSearchBar_delegate$lambda$3(ConditionEventLocationView r3) {
        return (OSearchBar) ZeusTransformUtils.preCheckCast(r3.findViewById(ZeusTransformUtils.mapRes(R.id.condition_location_search, DbHelper.COL_ID, "condition_location_search")), OSearchBar.class, "com.obric.aiagent.plugin");
    }

    private final OFloatingTitleBar getLocationTitleBar() {
        return (OFloatingTitleBar) ZeusTransformUtils.preCheckCast(this.locationTitleBar$delegate.b(), OFloatingTitleBar.class, "com.obric.aiagent.plugin");
    }

    private static final OFloatingTitleBar locationTitleBar_delegate$lambda$4(ConditionEventLocationView r3) {
        return (OFloatingTitleBar) ZeusTransformUtils.preCheckCast(r3.findViewById(ZeusTransformUtils.mapRes(R.id.condition_location_sheet_title_bar, DbHelper.COL_ID, "condition_location_sheet_title_bar")), OFloatingTitleBar.class, "com.obric.aiagent.plugin");
    }

    private final OBlurMaskView getMaskView() {
        return (OBlurMaskView) ZeusTransformUtils.preCheckCast(this.maskView$delegate.b(), OBlurMaskView.class, "com.obric.aiagent.plugin");
    }

    private static final OBlurMaskView maskView_delegate$lambda$5(ConditionEventLocationView r3) {
        return (OBlurMaskView) ZeusTransformUtils.preCheckCast(r3.findViewById(ZeusTransformUtils.mapRes(R.id.blur_mask, DbHelper.COL_ID, "blur_mask")), OBlurMaskView.class, "com.obric.aiagent.plugin");
    }

    public final View getConfirmButton() {
        return this.confirmButton;
    }

    private final void configTitleMode() {
        if (com.obric.oui.material.l.b() < 3) goto L5;
        getLocationRecyclerViewContainer().setClipChildren(false);
        getMaskView().setMaskBlurRadius(8.0f);
        return;
    L5:
        getLocationRecyclerViewContainer().setClipChildren(true);
        getMaskView().setMaskBlurRadius(0.0f);
    }

    private final void initView() {
        OEditText r0 = getLocationSearchBar().getInputView();
        String r1 = this.searchHint;
        if (r1 != null) goto L6;
        r1 = this.title;
    L6:
        if (r1 == null) goto L8;
        r0.setHint((CharSequence) ZeusTransformUtils.preCheckCast(r1, CharSequence.class, "com.obric.aiagent.plugin"));
    L8:
        OFloatingTitleBar r2 = getLocationTitleBar();
        if (this.showConfirmAction == false) goto L11;
        Context r3 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r2.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        d.h.b.o.c(r3, "getContext(...)");
        d.h.b.o.a(r2);
        p.a(r3, r2, null, Integer.valueOf(this.startActionIcon), false, new $$Lambda$ConditionEventLocationView$OFZWeUA2qxwS4Ho8jH9ojV67hpw(this), new $$Lambda$ConditionEventLocationView$jnG_bI3JuqmzpsTH6KousKzG4E(this), 4, null);
        this.confirmButton = r2.findViewById(ZeusTransformUtils.mapRes(R.id.end_button_group, DbHelper.COL_ID, "end_button_group"));
    L12:
        r2.setCenterTitle(this.title);
        r0.requestFocus();
        r0.addTextChangedListener((TextWatcher) ZeusTransformUtils.preCheckCast(new AnonymousClass3(this), TextWatcher.class, "com.obric.aiagent.plugin"));
        RecyclerView r4 = getLocationRecyclerView();
        Context r5 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        d.h.b.o.c(r5, "getContext(...)");
        r4.setLayoutManager((RecyclerView.h) ZeusTransformUtils.preCheckCast(new q(r5), RecyclerView.h.class, "com.obric.aiagent.plugin"));
        getLocationRecyclerView().setAdapter((RecyclerView.a) ZeusTransformUtils.preCheckCast(getLocationAdapter(), RecyclerView.a.class, "com.obric.aiagent.plugin"));
        configTitleMode();
        return;
    L11:
        OFloatingTitleBar.addStartAction$default(r2, this.startActionIcon, 0, new $$Lambda$ConditionEventLocationView$LC4LaLEJcxa_DE9fDOw1owpk3Ws(this), 2, null);
        goto L12
    }

    private static final x initView$lambda$10$lambda$7(ConditionEventLocationView r1, View r2) {
        d.h.b.o.e(r2, "it");
        d.h.a.b<? super View, x> r3 = r1.onConfirmListener;
        if (r3 == null) goto L6;
        r3.invoke(r2);
    L6:
        return x.f38692a;
    }

    private static final x initView$lambda$10$lambda$8(ConditionEventLocationView r1, View r2) {
        d.h.b.o.e(r2, "it");
        d.h.a.b<? super View, x> r3 = r1.onBackListener;
        if (r3 == null) goto L6;
        r3.invoke(r2);
    L6:
        return x.f38692a;
    }

    private static final void initView$lambda$10$lambda$9(ConditionEventLocationView r0, View r1) {
        d.h.a.b<? super View, x> r2 = r0.onBackListener;
        if (r2 == null) goto L6;
        d.h.b.o.a(r1);
        r2.invoke(r1);
        return;
    }

    public final void setOnItemClickListener(d.h.a.m<? super ConditionLocationItemData, ? super Integer, x> r3) {
        d.h.a.m<? super ConditionLocationItemData, ? super Integer, x> r4 = (d.h.a.m) ZeusTransformUtils.wrapperContextForParams(r3, d.h.a.m.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r4, "listener");
        getLocationAdapter().a(r4);
    }

    public final void setOnUnsetItemClickListener(d.h.a.b<? super ConditionLocationItemData, x> r3) {
        d.h.a.b<? super ConditionLocationItemData, x> r4 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r3, d.h.a.b.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r4, "listener");
        getLocationAdapter().b(r4);
    }

    public final void setSelectLocationItemCallback(d.h.a.b<? super ConditionLocationItemData, x> r3) {
        d.h.a.b<? super ConditionLocationItemData, x> r4 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r3, d.h.a.b.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r4, "callback");
        getLocationAdapter().a(r4);
    }

    public final void configAdapter(String r3, com.obric.autoaction.app.launcherpage.condition.config.condition.g r4) {
        com.obric.autoaction.app.launcherpage.condition.config.condition.g r5 = (com.obric.autoaction.app.launcherpage.condition.config.condition.g) ZeusTransformUtils.wrapperContextForParams(r4, com.obric.autoaction.app.launcherpage.condition.config.condition.g.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r3, "locationType");
        d.h.b.o.e(r5, "locationCondition");
        getLocationAdapter().a(r3);
        getLocationAdapter().a(r5);
    }

    public final void setAfterTextChangedListener(d.h.a.b<? super Editable, x> r3) {
        d.h.a.b<? super Editable, x> r4 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r3, d.h.a.b.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r4, "afterTextChanged");
        this.afterTextChanged = r4;
    }

    public final CharSequence getSearchText() {
        return (CharSequence) ZeusTransformUtils.preCheckCast(getLocationSearchBar().getInputView().getText(), CharSequence.class, "com.obric.aiagent.plugin");
    }

    public final void updateLocationItems(List<ConditionLocationItemData> r4) {
        List<ConditionLocationItemData> r5 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r5, "locationItems");
        getLocationAdapter().a(r5);
        View r3 = findViewById(ZeusTransformUtils.mapRes(R.id.status, DbHelper.COL_ID, "status"));
        d.h.b.o.c(r3, "findViewById(...)");
        if (r5.isEmpty() == false) goto L5;
        int r6 = 0;
    L6:
        r3.setVisibility(r6);
        return;
    L5:
        r6 = 8;
        goto L6
    }

    public final void setLearningStatus(Map<Integer, Integer> r3) {
        Map<Integer, Integer> r4 = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r4, "learningStatus");
        getLocationAdapter().a(r4);
    }

    public final ConditionLocationItemData getSelectLocationItemData() {
        return getLocationAdapter().b();
    }

    public final void setOnBackClickListener(d.h.a.b<? super View, x> r3) {
        d.h.a.b<? super View, x> r4 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r3, d.h.a.b.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r4, "listener");
        this.onBackListener = r4;
    }

    public final void setOnConfirmButtonListener(d.h.a.b<? super View, x> r3) {
        d.h.a.b<? super View, x> r4 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r3, d.h.a.b.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r4, "listener");
        this.onConfirmListener = r4;
    }

    public final void applyBottomNavInsetPadding() {
        RecyclerView r3 = getLocationRecyclerView();
        d.h.b.o.c(r3, "<get-locationRecyclerView>(...)");
        p.a((View) ZeusTransformUtils.preCheckCast(r3, View.class, "com.obric.aiagent.plugin"), 0, true, 1, null);
    }
}
