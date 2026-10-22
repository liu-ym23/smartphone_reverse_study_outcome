package com.obric.autoaction.app.launcherpage.condition.config;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.r;
import androidx.lifecycle.ao;
import androidx.lifecycle.ap;
import androidx.lifecycle.w;
import com.bytedance.bdturing.localstorage.DbHelper;
import com.bytedance.common.wschannel.WsChannelMultiProcessSharedProvider;
import com.obric.aiagent.plugin.R;
import com.obric.autoaction.app.launcherpage.condition.config.condition.AutoCondition;
import com.obric.autoaction.app.launcherpage.detail.base.BaseOSheetDialogFragment;
import com.obric.autoaction.app.launcherpage.ui.g;
import com.obric.oui.material.l;
import com.obric.oui.orecyclerview.widget.LinearLayoutManager;
import com.obric.oui.orecyclerview.widget.RecyclerView;
import com.obric.oui.sheet.v2.OSheet;
import com.obric.oui.titlebar.OFloatingTitleBar;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.f;
import d.h.b.aa;
import d.h.b.h;
import d.h.b.i;
import d.h.b.o;
import d.h.b.p;
import d.x;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: ConditionConfigureDialogFragment.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class ConditionConfigureDialogFragment extends BaseOSheetDialogFragment<ConditionConfigureResult> {
    public static final a Companion = null;
    private static final String TAG = "ConditionConfigureOSheet";
    private com.obric.autoaction.app.launcherpage.a.b _binding;
    private List<? extends AutoCondition> conditions;
    private final f vm$delegate;

    /* JADX INFO: compiled from: ConditionConfigureDialogFragment.kt */
    public static final class a {
        public /* synthetic */ a(h r1) {
            this();
        }

        private a() {
        }

        public final ConditionConfigureDialogFragment a(List<? extends AutoCondition> r2) {
            List<? extends AutoCondition> r1 = (List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.aiagent.plugin");
            ConditionConfigureDialogFragment r3 = new ConditionConfigureDialogFragment();
            r3.setConditions(r1);
            return r3;
        }

        public final Object a(AppCompatActivity r3, List<? extends AutoCondition> r4, d.c.d<? super ConditionConfigureResult> r5) {
            AppCompatActivity r6 = (AppCompatActivity) ZeusTransformUtils.wrapperContextForParams(r3, AppCompatActivity.class, "com.obric.aiagent.plugin");
            List<? extends AutoCondition> r7 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.aiagent.plugin");
            d.c.d r8 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            return BaseOSheetDialogFragment.Companion.a((BaseOSheetDialogFragment) ZeusTransformUtils.preCheckCast(a(r7), BaseOSheetDialogFragment.class, "com.obric.aiagent.plugin"), (FragmentActivity) ZeusTransformUtils.preCheckCast(r6, FragmentActivity.class, "com.obric.aiagent.plugin"), ConditionConfigureDialogFragment.TAG, r8);
        }

        public final Dialog a(Activity r3) {
            Activity r2 = (Activity) ZeusTransformUtils.wrapperContextForParams(r3, Activity.class, "com.obric.aiagent.plugin");
            o.e(r2, "activity");
            if (ZeusTransformUtils.instanceOf(r2, FragmentActivity.class) == false) goto L5;
            FragmentActivity r4 = (FragmentActivity) ZeusTransformUtils.preCheckCast(r2, FragmentActivity.class, "com.obric.aiagent.plugin");
        L6:
            if (r4 != null) goto L8;
            return null;
        L8:
            Fragment r5 = r4.getSupportFragmentManager().b(ConditionConfigureDialogFragment.TAG);
            if (ZeusTransformUtils.instanceOf(r5, ConditionConfigureDialogFragment.class) == false) goto L11;
            ConditionConfigureDialogFragment r6 = (ConditionConfigureDialogFragment) ZeusTransformUtils.preCheckCast(r5, ConditionConfigureDialogFragment.class, "com.obric.aiagent.plugin");
        L12:
            if (r6 != null) goto L14;
            return null;
        L14:
            return r6.getDialog();
        L11:
            r6 = null;
            goto L12
        L5:
            r4 = null;
            goto L6
        }
    }

    /* JADX INFO: compiled from: ConditionConfigureDialogFragment.kt */
    static final class b implements w, i {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final /* synthetic */ d.h.a.b f22932a;

        b(d.h.a.b r3) {
            d.h.a.b r4 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r3, d.h.a.b.class, "com.obric.aiagent.plugin");
            o.e(r4, "function");
            this.f22932a = r4;
        }

        @Override // d.h.b.i
        public final d.c<?> a() {
            return (d.c) ZeusTransformUtils.preCheckCast(this.f22932a, d.c.class, "com.obric.aiagent.plugin");
        }

        public final boolean equals(Object r3) {
            if (ZeusTransformUtils.instanceOf(r3, w.class) == true) goto L5;
            return false;
        L5:
            if (ZeusTransformUtils.instanceOf(r3, i.class) == true) goto L7;
            return false;
        L7:
            return o.a(((i) ZeusTransformUtils.preCheckCast(this, i.class, "com.obric.aiagent.plugin")).a(), ((i) ZeusTransformUtils.preCheckCast(r3, i.class, "com.obric.aiagent.plugin")).a());
        }

        public final int hashCode() {
            return ((i) ZeusTransformUtils.preCheckCast(this, i.class, "com.obric.aiagent.plugin")).a().hashCode();
        }

        @Override // androidx.lifecycle.w
        public final /* synthetic */ void onChanged(Object r1) {
            this.f22932a.invoke(r1);
        }
    }

    /* JADX INFO: compiled from: ConditionConfigureDialogFragment.kt */
    public static final class c implements com.obric.autoaction.app.launcherpage.condition.config.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ ConditionConfigureDialogFragment f22933a;

        c(ConditionConfigureDialogFragment r1) {
            this.f22933a = r1;
        }

        @Override // com.obric.autoaction.app.launcherpage.condition.config.b
        public com.obric.autoaction.app.launcherpage.condition.config.a a() {
            return ConditionConfigureDialogFragment.access$getVm(this.f22933a);
        }
    }

    /* JADX INFO: compiled from: FragmentViewModelLazy.kt */
    public static final class d extends p implements d.h.a.a<Fragment> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Fragment f22934a;

        public d(Fragment r1) {
            this.f22934a = r1;
            super(0);
        }

        @Override // d.h.a.a
        public /* synthetic */ Fragment invoke() {
            return a();
        }

        public final Fragment a() {
            return this.f22934a;
        }
    }

    /* JADX INFO: compiled from: FragmentViewModelLazy.kt */
    public static final class e extends p implements d.h.a.a<ao> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ d.h.a.a f22935a;

        public e(d.h.a.a r3) {
            this.f22935a = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r3, d.h.a.a.class, "com.obric.aiagent.plugin");
            super(0);
        }

        @Override // d.h.a.a
        public /* synthetic */ ao invoke() {
            return a();
        }

        public final ao a() {
            ao r2 = ((ap) ZeusTransformUtils.preCheckCast(this.f22935a.invoke(), ap.class, "com.obric.aiagent.plugin")).getViewModelStore();
            o.b(r2, "ownerProducer().viewModelStore");
            return r2;
        }
    }

    static {
        Companion = new a(null);
    }

    public static /* synthetic */ x lambda$DKlcsmIhxZQ0UnqaGlZe5mBez5I(ConditionConfigureDialogFragment r0) {
        return setupViews$lambda$12$lambda$6(r0);
    }

    public static /* synthetic */ x lambda$HZKiH1EZGfNTa_WfzfTpqC5eTQk(ConditionConfigureDialogFragment r0, View r1) {
        return setupViews$lambda$4$lambda$2(r0, r1);
    }

    public static /* synthetic */ x lambda$JTH2phZiBw8MnMwct3q2fCxmKD0(ConditionConfigureDialogFragment r0, com.obric.autoaction.common.base.a r1) {
        return configExtension$lambda$0(r0, r1);
    }

    /* JADX INFO: renamed from: lambda$Jn9SRg-m3XKO6LrqOHQsI1AJtxY, reason: not valid java name */
    public static /* synthetic */ x m447lambda$Jn9SRgm3XKO6LrqOHQsI1AJtxY(com.obric.autoaction.app.launcherpage.ui.d r0, ConditionConfigureDialogFragment r1, View r2, List r3) {
        return setupViews$lambda$12(r0, r1, r2, r3);
    }

    public static /* synthetic */ x lambda$S3cVmaGx74zMh9o5Szwep2054LM(ConditionConfigureDialogFragment r0, View r1) {
        return setupViews$lambda$4$lambda$3(r0, r1);
    }

    @Override // com.obric.autoaction.app.launcherpage.detail.base.BaseOSheetDialogFragment
    public String getPageEnterPageName() {
        return "event_task_condition_config_page";
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater r1, ViewGroup r2, Bundle r3) {
        o.e(r1, "inflater");
        return null;
    }

    public ConditionConfigureDialogFragment() {
        Fragment r0 = (Fragment) ZeusTransformUtils.preCheckCast(this, Fragment.class, "com.obric.aiagent.plugin");
        d.h.a.a r2 = (d.h.a.a) ZeusTransformUtils.preCheckCast(new d(r0), d.h.a.a.class, "com.obric.aiagent.plugin");
        this.vm$delegate = r.a(r0, aa.b(com.obric.autoaction.app.launcherpage.condition.config.a.class), (d.h.a.a) ZeusTransformUtils.preCheckCast(new e(r2), d.h.a.a.class, "com.obric.aiagent.plugin"), null);
    }

    public static final /* synthetic */ com.obric.autoaction.app.launcherpage.condition.config.a access$getVm(ConditionConfigureDialogFragment r0) {
        return r0.getVm();
    }

    private final com.obric.autoaction.app.launcherpage.condition.config.a getVm() {
        return (com.obric.autoaction.app.launcherpage.condition.config.a) ZeusTransformUtils.preCheckCast(this.vm$delegate.b(), com.obric.autoaction.app.launcherpage.condition.config.a.class, "com.obric.aiagent.plugin");
    }

    private final com.obric.autoaction.app.launcherpage.a.b getBinding() {
        com.obric.autoaction.app.launcherpage.a.b r0 = this._binding;
        o.a(r0);
        return r0;
    }

    public final List<AutoCondition> getConditions() {
        return this.conditions;
    }

    public final void setConditions(List<? extends AutoCondition> r3) {
        this.conditions = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
    }

    @Override // com.obric.autoaction.app.launcherpage.detail.base.BaseOSheetDialogFragment
    public d.h.a.b<com.obric.autoaction.common.base.a, x> configExtension() {
        return new $$Lambda$ConditionConfigureDialogFragment$JTH2phZiBw8MnMwct3q2fCxmKD0(this);
    }

    private static final x configExtension$lambda$0(ConditionConfigureDialogFragment r4, com.obric.autoaction.common.base.a r5) {
        o.e(r5, "<this>");
        r5.a((com.obric.autoaction.common.base.b) ZeusTransformUtils.preCheckCast(new com.obric.autoaction.common.ext.b(r4.getPageEnterPageName(), false, 2, null), com.obric.autoaction.common.base.b.class, "com.obric.aiagent.plugin"));
        return x.f38692a;
    }

    @Override // com.obric.autoaction.app.launcherpage.detail.base.BaseOSheetDialogFragment
    public void configureSheet(OSheet r3, Bundle r4) {
        o.e(r3, "sheet");
        this._binding = com.obric.autoaction.app.launcherpage.a.b.a(getLayoutInflater());
        r3.setBodyView((View) ZeusTransformUtils.preCheckCast(getBinding().b(), View.class, "com.obric.aiagent.plugin"));
        setupViews();
        configTitleMode();
    }

    private final void setupViews() {
        RecyclerView r1 = getBinding().f22799a;
        o.c(r1, "conditionList");
        final com.obric.autoaction.app.launcherpage.ui.d r0 = new com.obric.autoaction.app.launcherpage.ui.d(r1, false, 2, null);
        getBinding().f22799a.setLayoutManager((RecyclerView.h) ZeusTransformUtils.preCheckCast(new LinearLayoutManager((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(requireContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")), RecyclerView.h.class, "com.obric.aiagent.plugin"));
        r0.a(new Class[]{com.obric.autoaction.app.launcherpage.condition.config.a.d.class});
        r0.a(new Class[]{com.obric.autoaction.app.launcherpage.condition.config.a.a.class});
        OFloatingTitleBar r2 = getBinding().f22801c;
        o.c(r2, "titlebar");
        r2.setVisibility(0);
        r2.setCenterTitle(ZeusTransformUtils.mapRes(R.string.condition_event_trigger_condition, WsChannelMultiProcessSharedProvider.STRING_TYPE, "condition_event_trigger_condition"));
        Context r6 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r2.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        o.c(r6, "getContext(...)");
        com.obric.autoaction.app.launcherpage.utils.p.a(r6, r2, Integer.valueOf(ZeusTransformUtils.mapRes(R.string.condition_event_trigger_condition, WsChannelMultiProcessSharedProvider.STRING_TYPE, "condition_event_trigger_condition")), Integer.valueOf(ZeusTransformUtils.mapRes(R.drawable.o_ic_titlebar_back, "drawable", "o_ic_titlebar_back")), false, new $$Lambda$ConditionConfigureDialogFragment$HZKiH1EZGfNTa_WfzfTpqC5eTQk(this), new $$Lambda$ConditionConfigureDialogFragment$S3cVmaGx74zMh9o5Szwep2054LM(this));
        final View r3 = r2.findViewById(ZeusTransformUtils.mapRes(R.id.end_button_group, DbHelper.COL_ID, "end_button_group"));
        List<? extends AutoCondition> r4 = this.conditions;
        if (r4 == null) goto L5;
        getVm().a(r4);
    L5:
        com.obric.autoaction.app.launcherpage.condition.config.a r5 = getVm();
        Context r7 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(requireContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        o.c(r7, "requireContext(...)");
        r5.a(r7);
        getVm().b().a((androidx.lifecycle.p) ZeusTransformUtils.preCheckCast(this, androidx.lifecycle.p.class, "com.obric.aiagent.plugin"), (w) ZeusTransformUtils.preCheckCast(new b(new $$Lambda$ConditionConfigureDialogFragment$Jn9SRgm3XKO6LrqOHQsI1AJtxY(r0, this, r3)), w.class, "com.obric.aiagent.plugin"));
        g r8 = r0.b();
        com.obric.autoaction.app.launcherpage.ui.c r13 = (com.obric.autoaction.app.launcherpage.ui.c) ZeusTransformUtils.preCheckCast(new c(this), com.obric.autoaction.app.launcherpage.ui.c.class, "com.obric.aiagent.plugin");
        if (r8.a().containsKey(com.obric.autoaction.app.launcherpage.condition.config.b.class) == true) goto L10;
        r8.a().put(com.obric.autoaction.app.launcherpage.condition.config.b.class, r13);
        return;
    L10:
        throw new RuntimeException("already contains control type :" + com.obric.autoaction.app.launcherpage.condition.config.b.class);
    }

    private static final x setupViews$lambda$4$lambda$2(ConditionConfigureDialogFragment r4, View r5) {
        o.e(r5, "it");
        Iterable r6 = (Iterable) ZeusTransformUtils.preCheckCast(r4.getVm().c(), Iterable.class, "com.obric.aiagent.plugin");
        Collection r0 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");
        Iterator r7 = r6.iterator();
    L4:
        if (r7.hasNext() == false) goto L8;
        Object r2 = r7.next();
        if (((AutoCondition) ZeusTransformUtils.preCheckCast(r2, AutoCondition.class, "com.obric.aiagent.plugin")).getActive() == false) goto L4;
        r0.add(r2);
        goto L4
    L8:
        List r8 = (List) ZeusTransformUtils.preCheckCast(r0, List.class, "com.obric.aiagent.plugin");
        Context r1 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r4.requireContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        o.c(r1, "requireContext(...)");
        r4.deliverResultAndDismiss(new ConditionConfigureResult(com.obric.autoaction.app.launcherpage.condition.a.a.a(r8, r1), r8));
        return x.f38692a;
    }

    private static final x setupViews$lambda$4$lambda$3(ConditionConfigureDialogFragment r1, View r2) {
        o.e(r2, "it");
        r1.deliverResultAndDismiss(null);
        return x.f38692a;
    }

    private static final x setupViews$lambda$12(com.obric.autoaction.app.launcherpage.ui.d r5, final ConditionConfigureDialogFragment r6, View r7, List r8) {
        r5.a((List) ZeusTransformUtils.wrapperContextForParams(r8, List.class, "com.obric.aiagent.plugin"), new $$Lambda$ConditionConfigureDialogFragment$DKlcsmIhxZQ0UnqaGlZe5mBez5I(r6));
        Iterable r9 = (Iterable) ZeusTransformUtils.preCheckCast(r6.getVm().c(), Iterable.class, "com.obric.aiagent.plugin");
        Map r10 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.aiagent.plugin");
        Iterator r11 = r9.iterator();
    L4:
        if (r11.hasNext() == false) goto L10;
        Object r12 = r11.next();
        String r0 = ((AutoCondition) ZeusTransformUtils.preCheckCast(r12, AutoCondition.class, "com.obric.aiagent.plugin")).getGroupInfo().getGroupName();
        Object r2 = r10.get(r0);
        if (r2 != null) goto L8;
        r2 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.aiagent.plugin");
        r10.put(r0, r2);
    L8:
        ((List) ZeusTransformUtils.preCheckCast(r2, List.class, "com.obric.aiagent.plugin")).add(r12);
        goto L4
    L10:
        if (r7 == null) goto L12;
        r7.setEnabled(false);
    L12:
        Iterator r13 = r10.entrySet().iterator();
    L14:
        if (r13.hasNext() == false) goto L57;
        List r14 = (List) ZeusTransformUtils.preCheckCast(((Map.Entry) ZeusTransformUtils.preCheckCast(r13.next(), Map.Entry.class, "com.obric.aiagent.plugin")).getValue(), List.class, "com.obric.aiagent.plugin");
        Iterable r1 = (Iterable) ZeusTransformUtils.preCheckCast(r14, Iterable.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r1, Collection.class) == true) goto L18;
    L20:
        Iterator r3 = r1.iterator();
    L22:
        if (r3.hasNext() == false) goto L19;
        AutoCondition r4 = (AutoCondition) ZeusTransformUtils.preCheckCast(r3.next(), AutoCondition.class, "com.obric.aiagent.plugin");
        if (r4.isPrimary() == true) goto L26;
    L28:
        boolean r15 = false;
    L29:
        if (r15 == false) goto L22;
        boolean r16 = true;
    L31:
        Iterable r17 = (Iterable) ZeusTransformUtils.preCheckCast(r14, Iterable.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r17, Collection.class) == true) goto L34;
    L36:
        Iterator r18 = r17.iterator();
    L38:
        if (r18.hasNext() == false) goto L35;
        AutoCondition r19 = (AutoCondition) ZeusTransformUtils.preCheckCast(r18.next(), AutoCondition.class, "com.obric.aiagent.plugin");
        if (r19.isPrimary() == false) goto L42;
    L44:
        boolean r20 = false;
    L45:
        if (r20 == false) goto L38;
        boolean r21 = true;
    L47:
        if (r21 == false) goto L53;
        if (r16 == true) goto L53;
        if (r7 == null) goto L52;
        r7.setEnabled(false);
    L52:
        return x.f38692a;
    L53:
        if (r16 == false) goto L14;
        if (r7 == null) goto L14;
        r7.setEnabled(true);
        goto L14
    L42:
        if (r19.getActive() == false) goto L44;
        r20 = true;
    L35:
        r21 = false;
        goto L47
    L34:
        if (((Collection) ZeusTransformUtils.preCheckCast(r17, Collection.class, "com.obric.aiagent.plugin")).isEmpty() == false) goto L36;
    L26:
        if (r4.getActive() == false) goto L28;
        r15 = true;
    L19:
        r16 = false;
        goto L31
    L18:
        if (((Collection) ZeusTransformUtils.preCheckCast(r1, Collection.class, "com.obric.aiagent.plugin")).isEmpty() == false) goto L20;
    L57:
        return x.f38692a;
    }

    private static final x setupViews$lambda$12$lambda$6(ConditionConfigureDialogFragment r3) {
        r3.reportPageEnterSuccessOnPreDraw((View) ZeusTransformUtils.preCheckCast(r3.getBinding().b(), View.class, "com.obric.aiagent.plugin"));
        return x.f38692a;
    }

    private final void configTitleMode() {
        if (l.b() < 3) goto L5;
        getBinding().f22800b.setClipChildren(false);
        getBinding().f22801c.setMaskBlurRadius(8.0f);
        FrameLayout r0 = getBinding().f22800b;
        o.c(r0, "conditionListContainer");
        View r1 = (View) ZeusTransformUtils.preCheckCast(r0, View.class, "com.obric.aiagent.plugin");
        OFloatingTitleBar r8 = getBinding().f22801c;
        o.c(r8, "titlebar");
        com.obric.autoaction.app.launcherpage.utils.p.a(r1, r8, true);
        return;
    L5:
        getBinding().f22800b.setClipChildren(true);
        FrameLayout r2 = getBinding().f22800b;
        o.c(r2, "conditionListContainer");
        View r3 = (View) ZeusTransformUtils.preCheckCast(r2, View.class, "com.obric.aiagent.plugin");
        OFloatingTitleBar r4 = getBinding().f22801c;
        o.c(r4, "titlebar");
        com.obric.autoaction.app.launcherpage.utils.p.a(r3, r4, 0, true, 2, null);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        this._binding = null;
    }
}
