package com.obric.autoaction.app.launcherpage.detail.base.fragment;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.q;
import com.bytedance.bdturing.localstorage.DbHelper;
import com.bytedance.common.wschannel.WsChannelMultiProcessSharedProvider;
import com.obric.aiagent.plugin.R;
import com.obric.autoaction.app.launcherpage.a.ak;
import com.obric.autoaction.app.launcherpage.base.TaskBaseFragment;
import com.obric.autoaction.app.launcherpage.detail.base.container.ab;
import com.obric.autoaction.app.launcherpage.detail.base.container.z;
import com.obric.autoaction.app.launcherpage.detail.base.g;
import com.obric.autoaction.app.launcherpage.detail.base.j;
import com.obric.autoaction.app.launcherpage.detail.base.k;
import com.obric.autoaction.app.launcherpage.detail.shortcut.data.DetailParams;
import com.obric.autoaction.app.launcherpage.utils.p;
import com.obric.autoaction.app.launcherpage.widget.OAutoTipContainer;
import com.obric.autogui.common.api.app.AOHostAppTools;
import com.obric.autogui.common.api.configs.AutoActionConfigs;
import com.obric.autogui.common.api.presentation.AOUserInterfaceTools;
import com.obric.autogui.common.api.presentation.AssistRemoteCardUIParams;
import com.obric.eventkit.task.model.EventTask;
import com.obric.eventkit.task.model.EventTaskResult;
import com.obric.oui.button.OButtonGroup;
import com.obric.oui.material.l;
import com.obric.oui.titlebar.OFloatingTitleBar;
import com.obric.oui.toast.OToast;
import com.ss.android.socialbase.downloader.setting.DownloadSettingKeys;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.f;
import d.h.b.h;
import d.h.b.o;
import d.x;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import kotlinx.coroutines.am;
import kotlinx.coroutines.b.i;

/* JADX INFO: compiled from: BaseDetailFragmentV2.kt */
/* JADX INFO: loaded from: classes3.dex */
public abstract class BaseDetailFragmentV2 extends TaskBaseFragment implements com.obric.autoaction.app.launcherpage.detail.base.d, g {
    public static final a Companion = null;
    private static final int MAX_LENGTH = 60000;
    private static final String TAG = "BaseDetailFragmentV2";
    private ak _binding;
    private com.obric.autoaction.app.launcherpage.detail.base.a detailContext;
    private DetailParams detailParams;
    private boolean hasRegisteredViewContainers;
    private boolean isExitDialogShowing;
    private boolean isSaving;
    private OToast oToast;
    private d.h.a.b<? super EventTask, x> onResult;
    private final f titleBarRightButtonGroup$delegate;
    private ab viewContainerManager;
    private com.obric.autoaction.app.launcherpage.detail.base.b.d viewModel;

    /* JADX INFO: compiled from: BaseDetailFragmentV2.kt */
    public static final class a {
        public /* synthetic */ a(h r1) {
            this();
        }

        private a() {
        }
    }

    /* JADX INFO: compiled from: BaseDetailFragmentV2.kt */
    static final class b<T> implements i {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ BaseDetailFragmentV2 f23377a;

        b(BaseDetailFragmentV2 r1) {
            this.f23377a = r1;
        }

        @Override // kotlinx.coroutines.b.i
        public /* synthetic */ Object emit(Object r3, d.c.d r4) {
            d.c.d<? super x> r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            return a((com.obric.autoaction.app.launcherpage.detail.base.i) ZeusTransformUtils.preCheckCast(r3, com.obric.autoaction.app.launcherpage.detail.base.i.class, "com.obric.aiagent.plugin"), r5);
        }

        public final Object a(com.obric.autoaction.app.launcherpage.detail.base.i r3, d.c.d<? super x> r4) {
            com.obric.autoaction.app.launcherpage.detail.base.i r5 = (com.obric.autoaction.app.launcherpage.detail.base.i) ZeusTransformUtils.wrapperContextForParams(r3, com.obric.autoaction.app.launcherpage.detail.base.i.class, "com.obric.aiagent.plugin");
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f23377a.bindState(r5);
            return x.f38692a;
        }
    }

    /* JADX INFO: compiled from: BaseDetailFragmentV2.kt */
    static final class c<T> implements i {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ BaseDetailFragmentV2 f23378a;

        c(BaseDetailFragmentV2 r1) {
            this.f23378a = r1;
        }

        @Override // kotlinx.coroutines.b.i
        public /* synthetic */ Object emit(Object r3, d.c.d r4) {
            d.c.d<? super x> r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            return a((com.obric.autoaction.app.launcherpage.detail.base.c) ZeusTransformUtils.preCheckCast(r3, com.obric.autoaction.app.launcherpage.detail.base.c.class, "com.obric.aiagent.plugin"), r5);
        }

        public final Object a(com.obric.autoaction.app.launcherpage.detail.base.c r3, d.c.d<? super x> r4) {
            com.obric.autoaction.app.launcherpage.detail.base.c r5 = (com.obric.autoaction.app.launcherpage.detail.base.c) ZeusTransformUtils.wrapperContextForParams(r3, com.obric.autoaction.app.launcherpage.detail.base.c.class, "com.obric.aiagent.plugin");
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f23378a.handleEffect(r5);
            return x.f38692a;
        }
    }

    /* JADX INFO: compiled from: BaseDetailFragmentV2.kt */
    static final class d<T> implements i {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ BaseDetailFragmentV2 f23379a;

        d(BaseDetailFragmentV2 r1) {
            this.f23379a = r1;
        }

        @Override // kotlinx.coroutines.b.i
        public /* synthetic */ Object emit(Object r3, d.c.d r4) {
            d.c.d<? super x> r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            return a(((Boolean) ZeusTransformUtils.preCheckCast(r3, Boolean.class, "com.obric.aiagent.plugin")).booleanValue(), r5);
        }

        public final Object a(boolean r3, d.c.d<? super x> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            OButtonGroup r2 = BaseDetailFragmentV2.access$getTitleBarRightButtonGroup(this.f23379a);
            if (r2 == null) goto L6;
            r2.setEnabled(r3);
        L6:
            return x.f38692a;
        }
    }

    /* JADX INFO: compiled from: BaseDetailFragmentV2.kt */
    public static final class e extends androidx.activity.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ BaseDetailFragmentV2 f23380a;

        e(BaseDetailFragmentV2 r1) {
            this.f23380a = r1;
            super(true);
        }

        @Override // androidx.activity.c
        public void c() {
            if (this.f23380a.checkIsEdited() == false) goto L5;
            BaseDetailFragmentV2.access$showExitConfirmDialog(this.f23380a);
            return;
        L5:
            a(false);
            ((FragmentActivity) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.f23380a.requireActivity(), "com.obric.aiagent.plugin"), FragmentActivity.class, "com.obric.aiagent.plugin")).onBackPressed();
        }
    }

    static {
        Companion = new a(null);
    }

    public static /* synthetic */ void lambda$PdXkIyd1i1XVMYCaindYwCkVqUQ(BaseDetailFragmentV2 r0, OAutoTipContainer r1) {
        setupPermissionTipContainer$lambda$2$lambda$1(r0, r1);
    }

    public static /* synthetic */ boolean lambda$SGxLkHtnEOg3g4z_Rsvkdar2ztg(BaseDetailFragmentV2 r0, DialogInterface r1, int r2, KeyEvent r3) {
        return setupBackHandler$lambda$3(r0, r1, r2, r3);
    }

    public static /* synthetic */ void lambda$TutQ9tjYYcj0_jk5wMUhz42f_lM(BaseDetailFragmentV2 r0, DialogInterface r1, int r2) {
        showExitConfirmDialog$lambda$7(r0, r1, r2);
    }

    public static /* synthetic */ void lambda$XAlnhNEV1UJojtgNVhSDSdCpamc(BaseDetailFragmentV2 r0, DialogInterface r1) {
        showExitConfirmDialog$lambda$8(r0, r1);
    }

    public static /* synthetic */ OButtonGroup lambda$ZTBOeidKIO7OOUyuMuXa3FwuIQ8(BaseDetailFragmentV2 r0) {
        return titleBarRightButtonGroup_delegate$lambda$0(r0);
    }

    public static /* synthetic */ void lambda$gC0PDLnDphEObJ6EUXLGFvqmHSY(BaseDetailFragmentV2 r0, View r1) {
        showSaving$lambda$6$lambda$5(r0, r1);
    }

    public static /* synthetic */ x lambda$q6u7sqO0iAnJyB3cfD8N5JDoOpQ(OAutoTipContainer r0, BaseDetailFragmentV2 r1, boolean r2) {
        return setupPermissionTipContainer$lambda$2(r0, r1, r2);
    }

    public abstract void configTitleBar();

    public abstract com.obric.autoaction.app.launcherpage.detail.base.b.c getDetailMode();

    public abstract com.obric.autoaction.app.launcherpage.detail.base.b.d getDetailViewModel();

    public abstract int getTitleRes();

    public void onClosePage(EventTaskResult r1) {
    }

    public void onNavigateToEditorPage() {
    }

    public abstract List<z<?>> registerDetailViewContainers();

    public BaseDetailFragmentV2() {
        this.titleBarRightButtonGroup$delegate = d.g.a(new $$Lambda$BaseDetailFragmentV2$ZTBOeidKIO7OOUyuMuXa3FwuIQ8(this));
        this.detailParams = new DetailParams(null, null, null, null, false, false, 63, null);
    }

    public static final /* synthetic */ OButtonGroup access$getTitleBarRightButtonGroup(BaseDetailFragmentV2 r0) {
        return r0.getTitleBarRightButtonGroup();
    }

    public static final /* synthetic */ void access$showExitConfirmDialog(BaseDetailFragmentV2 r0) {
        r0.showExitConfirmDialog();
    }

    public final ak getBinding() {
        ak r0 = this._binding;
        o.a(r0);
        return r0;
    }

    public final OFloatingTitleBar getTitleBar() {
        if (isDialogModeValue() == false) goto L5;
        OFloatingTitleBar r1 = getBinding().f;
        o.a(r1);
        return r1;
    L5:
        OFloatingTitleBar r2 = getBinding().f22748e;
        o.a(r2);
        return r2;
    }

    public final OFloatingTitleBar getFloatingTransitionSourceTitleBar() {
        if (isDialogModeValue() == false) goto L5;
    L9:
        return null;
    L5:
        if (getView() == null) goto L9;
        if (getTitleBar().getVisibility() != 0) goto L9;
        return getTitleBar();
    }

    private final OButtonGroup getTitleBarRightButtonGroup() {
        return (OButtonGroup) ZeusTransformUtils.preCheckCast(this.titleBarRightButtonGroup$delegate.b(), OButtonGroup.class, "com.obric.aiagent.plugin");
    }

    private static final OButtonGroup titleBarRightButtonGroup_delegate$lambda$0(BaseDetailFragmentV2 r3) {
        return (OButtonGroup) ZeusTransformUtils.preCheckCast(r3.getTitleBar().findViewById(ZeusTransformUtils.mapRes(R.id.end_button_group, DbHelper.COL_ID, "end_button_group")), OButtonGroup.class, "com.obric.aiagent.plugin");
    }

    public final DetailParams getDetailParams() {
        return this.detailParams;
    }

    public final void setDetailParams(DetailParams r2) {
        o.e(r2, "<set-?>");
        this.detailParams = r2;
    }

    public d.h.a.b<EventTask, x> getOnResult() {
        return this.onResult;
    }

    @Override // com.obric.autoaction.app.launcherpage.detail.base.g
    public void setOnResult(d.h.a.b<? super EventTask, x> r3) {
        this.onResult = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r3, d.h.a.b.class, "com.obric.aiagent.plugin");
    }

    public final String getTaskId() {
        return this.detailParams.getTaskId();
    }

    public final EventTask getInitEventTask() {
        return this.detailParams.getInitEventTask();
    }

    public final AssistRemoteCardUIParams getDoubaoCardUIParams() {
        return this.detailParams.getDoubaoCardUIParams();
    }

    private final boolean isDialogModeValue() {
        return this.detailParams.isDialogMode();
    }

    public final EventTask getCurrentTask() {
        com.obric.autoaction.app.launcherpage.detail.base.b.d r0 = this.viewModel;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.l();
    }

    public final OToast getOToast() {
        return this.oToast;
    }

    public final void setOToast(OToast r1) {
        this.oToast = r1;
    }

    @Override // com.obric.autoaction.app.launcherpage.base.TaskBaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle r1) {
        super.onCreate(r1);
        initData();
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater r5, ViewGroup r6, Bundle r7) {
        o.e(r5, "inflater");
        this._binding = ak.a(r5, r6, false);
        if (isDialogModeValue() == true) goto L9;
        ak r8 = this._binding;
        if (r8 == null) goto L9;
        ConstraintLayout r9 = r8.b();
        if (r9 == null) goto L9;
        int r0 = ZeusTransformUtils.mapRes(R.color.oui_basic_bg_base_1, "color", "oui_basic_bg_base_1");
        Context r1 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(requireContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        o.c(r1, "requireContext(...)");
        r9.setBackgroundColor(p.b(r0, r1, null, 2, null));
    L9:
        ak r10 = this._binding;
        if (r10 == null) goto L14;
        OAutoTipContainer r11 = r10.g;
        if (r11 == null) goto L14;
        r11.setEnableAddIconGuide(false);
    L14:
        ConstraintLayout r4 = getBinding().b();
        o.c(r4, "getRoot(...)");
        return (View) ZeusTransformUtils.preCheckCast(r4, View.class, "com.obric.aiagent.plugin");
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View r2, Bundle r3) {
        o.e(r2, "view");
        super.onViewCreated(r2, r3);
        com.obric.autoaction.app.launcherpage.detail.base.b.d r4 = getDetailViewModel();
        this.viewModel = r4;
        r4.a(this.detailParams, getDetailMode());
        configTitleBar();
        setupCellContainer(r4);
        setupPermissionTipContainer();
        initObserver();
        setupBackHandler();
        if (isDialogModeValue() == true) goto L5;
        com.obric.autoaction.app.launcherpage.b.c.a(getTitleBar());
    L5:
        configTitleMode();
        if (isDialogModeValue() == true) goto L9;
        ScrollView r1 = getBinding().f22747d;
        o.c(r1, "detailScrollView");
        p.a((View) ZeusTransformUtils.preCheckCast(r1, View.class, "com.obric.aiagent.plugin"), 0, true, 1, null);
        return;
    }

    private final void setupCellContainer(com.obric.autoaction.app.launcherpage.detail.base.b.d r6) {
        com.obric.autoaction.app.launcherpage.detail.base.b.d r7 = (com.obric.autoaction.app.launcherpage.detail.base.b.d) ZeusTransformUtils.wrapperContextForParams(r6, com.obric.autoaction.app.launcherpage.detail.base.b.d.class, "com.obric.aiagent.plugin");
        com.obric.autoaction.app.launcherpage.detail.base.d r2 = (com.obric.autoaction.app.launcherpage.detail.base.d) ZeusTransformUtils.preCheckCast(this, com.obric.autoaction.app.launcherpage.detail.base.d.class, "com.obric.aiagent.plugin");
        androidx.lifecycle.p r3 = getViewLifecycleOwner();
        o.c(r3, "getViewLifecycleOwner(...)");
        com.obric.autoaction.app.launcherpage.detail.base.a r0 = new com.obric.autoaction.app.launcherpage.detail.base.a(r7, r2, r3, getTaskId());
        this.detailContext = r0;
        LinearLayout r4 = getBinding().f22744a;
        o.c(r4, "cellContainer");
        this.viewContainerManager = new ab((ViewGroup) ZeusTransformUtils.preCheckCast(r4, ViewGroup.class, "com.obric.aiagent.plugin"), r0);
    }

    private final void setupPermissionTipContainer() {
        final OAutoTipContainer r0 = getBinding().g;
        o.c(r0, "permissionTipContainer");
        p.a((View) ZeusTransformUtils.preCheckCast(r0, View.class, "com.obric.aiagent.plugin"), getTitleBar(), d.i.a.a(TypedValue.applyDimension(1, 8, Resources.getSystem().getDisplayMetrics())), isDialogModeValue());
        r0.setVisibilityListener(new $$Lambda$BaseDetailFragmentV2$q6u7sqO0iAnJyB3cfD8N5JDoOpQ(r0, this));
    }

    private static final x setupPermissionTipContainer$lambda$2(final OAutoTipContainer r1, final BaseDetailFragmentV2 r2, boolean r3) {
        if (r3 == true) goto L4;
    L6:
        if (r3 == true) goto L8;
    L10:
        r2.applyTipContentPadding(0);
    L12:
        return x.f38692a;
    L8:
        if (r1.getHeight() != 0) goto L10;
        r1.post(new $$Lambda$BaseDetailFragmentV2$PdXkIyd1i1XVMYCaindYwCkVqUQ(r2, r1));
        goto L12
    L4:
        if (r1.getHeight() == 0) goto L6;
        r2.applyTipContentPadding(r1.getHeight());
        goto L12
    }

    private static final void setupPermissionTipContainer$lambda$2$lambda$1(BaseDetailFragmentV2 r0, OAutoTipContainer r1) {
        r0.applyTipContentPadding(r1.getHeight());
    }

    private final void setupBackHandler() {
        if (isDialogModeValue() == false) goto L7;
        Dialog r0 = findOwnerDialog();
        if (r0 == null) goto L9;
        r0.setOnKeyListener(new $$Lambda$BaseDetailFragmentV2$SGxLkHtnEOg3g4z_Rsvkdar2ztg(this));
        return;
    L9:
        return;
    L7:
        ((FragmentActivity) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(requireActivity(), "com.obric.aiagent.plugin"), FragmentActivity.class, "com.obric.aiagent.plugin")).getOnBackPressedDispatcher().a(getViewLifecycleOwner(), (androidx.activity.c) ZeusTransformUtils.preCheckCast(new e(this), androidx.activity.c.class, "com.obric.aiagent.plugin"));
    }

    private static final boolean setupBackHandler$lambda$3(BaseDetailFragmentV2 r2, DialogInterface r3, int r4, KeyEvent r5) {
        DialogInterface r6 = (DialogInterface) ZeusTransformUtils.wrapperContextForParams(r3, DialogInterface.class, "com.obric.aiagent.plugin");
        if (r4 != 4) goto L10;
        if (r5.getAction() != 1) goto L10;
        if (r2.checkIsEdited() == false) goto L10;
        r2.showExitConfirmDialog();
        return true;
    L10:
        return false;
    }

    public void initData() {
        Bundle r0 = getArguments();
        if (r0 == null) goto L6;
        DetailParams r1 = (DetailParams) ZeusTransformUtils.preCheckCast(r0.getParcelable("key_ui_model"), DetailParams.class, "com.obric.aiagent.plugin");
        if (r1 == null) goto L6;
    L7:
        this.detailParams = r1;
        return;
    L6:
        r1 = new DetailParams(null, null, null, null, false, false, 63, null);
        goto L7
    }

    public void initObserver() {
        com.obric.autoaction.app.launcherpage.detail.base.b.d r0 = this.viewModel;
        if (r0 == null) goto L7;
        kotlinx.coroutines.b.h<com.obric.autoaction.app.launcherpage.detail.base.i> r1 = r0.e();
        if (r1 == null) goto L7;
        androidx.lifecycle.p r3 = getViewLifecycleOwner();
        o.c(r3, "getViewLifecycleOwner(...)");
        com.obric.autoaction.app.launcherpage.utils.c.a(r1, (am) ZeusTransformUtils.preCheckCast(q.a(r3), am.class, "com.obric.aiagent.plugin"), (i) ZeusTransformUtils.preCheckCast(new b(this), i.class, "com.obric.aiagent.plugin"));
    L7:
        com.obric.autoaction.app.launcherpage.detail.base.b.d r2 = this.viewModel;
        if (r2 == null) goto L12;
        kotlinx.coroutines.b.h<com.obric.autoaction.app.launcherpage.detail.base.c> r4 = r2.f();
        if (r4 == null) goto L12;
        androidx.lifecycle.p r5 = getViewLifecycleOwner();
        o.c(r5, "getViewLifecycleOwner(...)");
        com.obric.autoaction.app.launcherpage.utils.c.a(r4, (am) ZeusTransformUtils.preCheckCast(q.a(r5), am.class, "com.obric.aiagent.plugin"), (i) ZeusTransformUtils.preCheckCast(new c(this), i.class, "com.obric.aiagent.plugin"));
    L12:
        com.obric.autoaction.app.launcherpage.detail.base.b.d r6 = this.viewModel;
        if (r6 == null) goto L18;
        kotlinx.coroutines.b.ak<Boolean> r7 = r6.g();
        if (r7 == null) goto L19;
        kotlinx.coroutines.b.h r8 = (kotlinx.coroutines.b.h) ZeusTransformUtils.preCheckCast(r7, kotlinx.coroutines.b.h.class, "com.obric.aiagent.plugin");
        androidx.lifecycle.p r9 = getViewLifecycleOwner();
        o.c(r9, "getViewLifecycleOwner(...)");
        com.obric.autoaction.app.launcherpage.utils.c.a(r8, (am) ZeusTransformUtils.preCheckCast(q.a(r9), am.class, "com.obric.aiagent.plugin"), (i) ZeusTransformUtils.preCheckCast(new d(this), i.class, "com.obric.aiagent.plugin"));
        return;
    L19:
        return;
    }

    public boolean defaultEnableRightButton() {
        if (getTaskId() == null) goto L5;
    L8:
        return true;
    L5:
        if (getInitEventTask() != null) goto L8;
        return false;
    }

    @Override // com.obric.autoaction.app.launcherpage.base.TaskBaseFragment
    public String getPageEnterFrom() {
        String r2 = this.detailParams.getEnterFrom();
        if (r2 != null) goto L5;
    L9:
        return DownloadSettingKeys.BugFix.DEFAULT;
    L5:
        if (d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r2, CharSequence.class, "com.obric.aiagent.plugin")) == false) goto L8;
        r2 = null;
    L8:
        if (r2 == null) goto L9;
        return r2;
    }

    private final void configTitleMode() {
        if (isDialogModeValue() == false) goto L8;
        if (l.b() < 3) goto L8;
        getBinding().f.setMaskBlurRadius(8.0f);
        ConstraintLayout r0 = getBinding().f22745b;
        o.c(r0, "detailContentContainer");
        p.a((View) ZeusTransformUtils.preCheckCast(r0, View.class, "com.obric.aiagent.plugin"), getTitleBar(), true);
        return;
    L8:
        if (isDialogModeValue() == false) goto L10;
        getBinding().f22745b.setClipChildren(true);
        getBinding().f.showMask(false);
        ConstraintLayout r1 = getBinding().f22745b;
        o.c(r1, "detailContentContainer");
        p.a((View) ZeusTransformUtils.preCheckCast(r1, View.class, "com.obric.aiagent.plugin"), getTitleBar(), 0, true, 2, null);
        return;
    L10:
        ConstraintLayout r2 = getBinding().f22745b;
        o.c(r2, "detailContentContainer");
        p.a((View) ZeusTransformUtils.preCheckCast(r2, View.class, "com.obric.aiagent.plugin"), getTitleBar(), false, 2, null);
    }

    private final Dialog findOwnerDialog() {
        Fragment r2 = getParentFragment();
    L3:
        if (r2 == null) goto L9;
        if (ZeusTransformUtils.instanceOf(r2, DialogFragment.class) == true) goto L7;
        r2 = r2.getParentFragment();
        goto L3
    L7:
        return ((DialogFragment) ZeusTransformUtils.preCheckCast(r2, DialogFragment.class, "com.obric.aiagent.plugin")).getDialog();
    L9:
        return null;
    }

    public void bindState(com.obric.autoaction.app.launcherpage.detail.base.i r3) {
        com.obric.autoaction.app.launcherpage.detail.base.i r4 = (com.obric.autoaction.app.launcherpage.detail.base.i) ZeusTransformUtils.wrapperContextForParams(r3, com.obric.autoaction.app.launcherpage.detail.base.i.class, "com.obric.aiagent.plugin");
        o.e(r4, "state");
        if (ZeusTransformUtils.instanceOf(r4, k.a.class) == false) goto L6;
        registerDetailViewContainersIfNeeded();
        reportPageEnterSuccessIfNeeded();
        return;
    L6:
        if (ZeusTransformUtils.instanceOf(r4, k.b.class) == false) goto L11;
        ab r2 = this.viewContainerManager;
        if (r2 == null) goto L17;
        r2.b();
        return;
    L17:
        return;
    L11:
        if (ZeusTransformUtils.instanceOf(r4, k.c.class) == false) goto L19;
        ab r5 = this.viewContainerManager;
        if (r5 == null) goto L20;
        r5.b();
        return;
    L20:
        return;
    }

    public void handleEffect(com.obric.autoaction.app.launcherpage.detail.base.c r7) {
        com.obric.autoaction.app.launcherpage.detail.base.c r8 = (com.obric.autoaction.app.launcherpage.detail.base.c) ZeusTransformUtils.wrapperContextForParams(r7, com.obric.autoaction.app.launcherpage.detail.base.c.class, "com.obric.aiagent.plugin");
        o.e(r8, "effect");
        boolean r2 = false;
        if (ZeusTransformUtils.instanceOf(r8, com.obric.autoaction.app.launcherpage.detail.base.c.b.class) == false) goto L15;
        TaskBaseFragment.reportPageEnterFail$default((TaskBaseFragment) ZeusTransformUtils.preCheckCast(this, TaskBaseFragment.class, "com.obric.aiagent.plugin"), ((com.obric.autoaction.app.launcherpage.detail.base.c.b) ZeusTransformUtils.preCheckCast(r8, com.obric.autoaction.app.launcherpage.detail.base.c.b.class, "com.obric.aiagent.plugin")).a(), 0, 2, null);
        if (((com.obric.autoaction.app.launcherpage.detail.base.c.b) ZeusTransformUtils.preCheckCast(r8, com.obric.autoaction.app.launcherpage.detail.base.c.b.class, "com.obric.aiagent.plugin")).b() == false) goto L7;
    L8:
        showSaving(false);
    L10:
        if (((CharSequence) ZeusTransformUtils.preCheckCast(((com.obric.autoaction.app.launcherpage.detail.base.c.b) ZeusTransformUtils.preCheckCast(r8, com.obric.autoaction.app.launcherpage.detail.base.c.b.class, "com.obric.aiagent.plugin")).a(), CharSequence.class, "com.obric.aiagent.plugin")).length() <= 0) goto L12;
        r2 = true;
    L12:
        if (r2 == false) goto L20;
        AOUserInterfaceTools.INSTANCE.showAppToast((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AOHostAppTools.INSTANCE.getAppContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast(((com.obric.autoaction.app.launcherpage.detail.base.c.b) ZeusTransformUtils.preCheckCast(r8, com.obric.autoaction.app.launcherpage.detail.base.c.b.class, "com.obric.aiagent.plugin")).a(), CharSequence.class, "com.obric.aiagent.plugin"));
        return;
    L20:
        return;
    L7:
        if (this.isSaving == false) goto L10;
    L15:
        if (ZeusTransformUtils.instanceOf(r8, com.obric.autoaction.app.launcherpage.detail.base.c.a.class) == false) goto L19;
        showSaving(false);
        onClosePage(((com.obric.autoaction.app.launcherpage.detail.base.c.a) ZeusTransformUtils.preCheckCast(r8, com.obric.autoaction.app.launcherpage.detail.base.c.a.class, "com.obric.aiagent.plugin")).a());
        closeHost();
        return;
    L19:
        throw new d.k();
    }

    private final void registerDetailViewContainersIfNeeded() {
        if (this.hasRegisteredViewContainers == false) goto L5;
        return;
    L5:
        z[] r0 = (z[]) ZeusTransformUtils.preCheckCast(((Collection) ZeusTransformUtils.preCheckCast(registerDetailViewContainers(), Collection.class, "com.obric.aiagent.plugin")).toArray(new z[0]), z[].class, "com.obric.aiagent.plugin");
        ab r1 = this.viewContainerManager;
        if (r1 != null) goto L8;
        return;
    L8:
        r1.a((z[]) ZeusTransformUtils.preCheckCast(Arrays.copyOf(r0, r0.length), z[].class, "com.obric.aiagent.plugin"));
        this.hasRegisteredViewContainers = true;
        r1.a();
    }

    private final void showSaving(boolean r14) {
        boolean r1 = false;
        if (r14 == true) goto L5;
        OToast r15 = this.oToast;
        if (r15 == null) goto L20;
        r15.e();
    L20:
        View r16 = getBinding().f22746c;
        o.c(r16, "detailMaskView");
        com.obric.oui.common.util.k.b(r16);
        this.isSaving = false;
        return;
    L5:
        if (AutoActionConfigs.INSTANCE.getBooleanCfg("vlm.common.enable_check_query", true) == false) goto L16;
        com.obric.autoaction.app.launcherpage.detail.base.b.d r17 = this.viewModel;
        if (r17 != null) goto L9;
    L11:
        if (r1 == false) goto L16;
        OToast r18 = this.oToast;
        if (r18 == null) goto L15;
        r18.e();
    L15:
        FragmentActivity r2 = (FragmentActivity) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(requireActivity(), "com.obric.aiagent.plugin"), FragmentActivity.class, "com.obric.aiagent.plugin");
        o.c(r2, "requireActivity(...)");
        OToast r19 = new OToast((Context) ZeusTransformUtils.preCheckCast(r2, Context.class, "com.obric.aiagent.plugin"), loadingText(), 0, false, null, 0, 52, null);
        r19.a(MAX_LENGTH);
        r19.d();
        String r5 = getString(ZeusTransformUtils.mapRes(R.string.common_cancel, WsChannelMultiProcessSharedProvider.STRING_TYPE, "common_cancel"));
        o.c(r5, "getString(...)");
        OToast.a(r19, r5, new $$Lambda$BaseDetailFragmentV2$gC0PDLnDphEObJ6EUXLGFvqmHSY(this), 0, 4, null);
        this.oToast = r19;
        r19.f();
        this.isSaving = true;
        goto L16
    L9:
        if (r17.r() != true) goto L11;
        r1 = true;
    L16:
        View r13 = getBinding().f22746c;
        o.c(r13, "detailMaskView");
        com.obric.oui.common.util.k.a(r13);
    }

    private static final void showSaving$lambda$6$lambda$5(BaseDetailFragmentV2 r0, View r1) {
        r0.showSaving(false);
    }

    public void clickConfirmButton(View r4) {
        o.e(r4, "view");
        if (this.isExitDialogShowing == false) goto L5;
        return;
    L5:
        showSaving(true);
        reduce((com.obric.autoaction.app.launcherpage.detail.base.h) ZeusTransformUtils.preCheckCast(new j.b(false, 1, null), com.obric.autoaction.app.launcherpage.detail.base.h.class, "com.obric.aiagent.plugin"));
    }

    public String loadingText() {
        return p.a(ZeusTransformUtils.mapRes(R.string.shortcut_loading_text, WsChannelMultiProcessSharedProvider.STRING_TYPE, "shortcut_loading_text"), null, 1, null);
    }

    public final void clickCancelButton(View r2) {
        o.e(r2, "view");
        if (this.isSaving == false) goto L6;
        return;
    L6:
        if (checkIsEdited() == false) goto L8;
        showExitConfirmDialog();
        return;
    L8:
        closeHost();
    }

    public void closeHost() {
        if (isDialogModeValue() == false) goto L10;
        Fragment r2 = getParentFragment();
        if (ZeusTransformUtils.instanceOf(r2, DialogFragment.class) == false) goto L7;
        DialogFragment r3 = (DialogFragment) ZeusTransformUtils.preCheckCast(r2, DialogFragment.class, "com.obric.aiagent.plugin");
    L8:
        if (r3 == null) goto L15;
        r3.dismissAllowingStateLoss();
        return;
    L15:
        return;
    L7:
        r3 = null;
        goto L8
    L10:
        FragmentActivity r4 = (FragmentActivity) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(requireActivity(), "com.obric.aiagent.plugin"), FragmentActivity.class, "com.obric.aiagent.plugin");
        o.c(r4, "requireActivity(...)");
        if (r4.isTaskRoot() == false) goto L13;
        r4.finishAndRemoveTask();
        return;
    L13:
        r4.finish();
    }

    private final void showExitConfirmDialog() {
        this.isExitDialogShowing = true;
        Context r2 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(requireContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        o.c(r2, "requireContext(...)");
        String r0 = getString(ZeusTransformUtils.mapRes(R.string.condition_event_detail_back_confirm, WsChannelMultiProcessSharedProvider.STRING_TYPE, "condition_event_detail_back_confirm"));
        o.c(r0, "getString(...)");
        String r5 = getString(ZeusTransformUtils.mapRes(R.string.condition_event_detail_back_confirm_desc, WsChannelMultiProcessSharedProvider.STRING_TYPE, "condition_event_detail_back_confirm_desc"));
        o.c(r5, "getString(...)");
        p.a(r2, r0, (CharSequence) ZeusTransformUtils.preCheckCast(r5, CharSequence.class, "com.obric.aiagent.plugin"), getString(ZeusTransformUtils.mapRes(R.string.finish, WsChannelMultiProcessSharedProvider.STRING_TYPE, "finish")), null, true, false, new $$Lambda$BaseDetailFragmentV2$TutQ9tjYYcj0_jk5wMUhz42f_lM(this), 80, null).setOnDismissListener(new $$Lambda$BaseDetailFragmentV2$XAlnhNEV1UJojtgNVhSDSdCpamc(this));
    }

    private static final void showExitConfirmDialog$lambda$7(BaseDetailFragmentV2 r1, DialogInterface r2, int r3) {
        ((DialogInterface) ZeusTransformUtils.wrapperContextForParams(r2, DialogInterface.class, "com.obric.aiagent.plugin")).dismiss();
        r1.closeHost();
    }

    private static final void showExitConfirmDialog$lambda$8(BaseDetailFragmentV2 r2, DialogInterface r3) {
        DialogInterface r4 = (DialogInterface) ZeusTransformUtils.wrapperContextForParams(r3, DialogInterface.class, "com.obric.aiagent.plugin");
        r2.isExitDialogShowing = false;
    }

    public boolean checkIsEdited() {
        if (getDetailMode() != com.obric.autoaction.app.launcherpage.detail.base.b.c.f23287c) goto L13;
        com.obric.autoaction.app.launcherpage.detail.base.b.d r4 = this.viewModel;
        if (r4 != null) goto L7;
    L9:
        boolean r5 = false;
    L10:
        if (r5 == false) goto L13;
        return true;
    L7:
        if (r4.q() != true) goto L9;
        r5 = true;
    L13:
        return false;
    }

    public final void reduce(com.obric.autoaction.app.launcherpage.detail.base.h r3) {
        com.obric.autoaction.app.launcherpage.detail.base.h r4 = (com.obric.autoaction.app.launcherpage.detail.base.h) ZeusTransformUtils.wrapperContextForParams(r3, com.obric.autoaction.app.launcherpage.detail.base.h.class, "com.obric.aiagent.plugin");
        o.e(r4, "action");
        com.obric.autoaction.app.launcherpage.detail.base.b.d r2 = this.viewModel;
        if (r2 == null) goto L6;
        r2.a(r4);
        return;
    }

    private final void reportPageEnterSuccessIfNeeded() {
        reportPageEnterSuccessOnPreDraw((View) ZeusTransformUtils.preCheckCast(getBinding().f22747d, View.class, "com.obric.aiagent.plugin"));
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        if (isDialogModeValue() == false) goto L7;
        Dialog r0 = findOwnerDialog();
        if (r0 == null) goto L7;
        r0.setOnKeyListener(null);
    L7:
        ab r1 = this.viewContainerManager;
        if (r1 == null) goto L10;
        r1.c();
    L10:
        this.viewContainerManager = null;
        this.detailContext = null;
        this.hasRegisteredViewContainers = false;
        super.onDestroyView();
        this._binding = null;
    }

    @Override // com.obric.autoaction.app.launcherpage.detail.base.d
    public void navigateToEditPage() {
        onNavigateToEditorPage();
    }

    public boolean isDialogMode() {
        return isDialogModeValue();
    }

    @Override // com.obric.autoaction.app.launcherpage.detail.base.d
    public Dialog getDialog() {
        return findOwnerDialog();
    }

    private final void applyTipContentPadding(int r4) {
        if (r4 != 0) goto L4;
        int r5 = 0;
    L5:
        LinearLayout r3 = getBinding().f22744a;
        o.c(r3, "cellContainer");
        View r6 = (View) ZeusTransformUtils.preCheckCast(r3, View.class, "com.obric.aiagent.plugin");
        r6.setPadding(r6.getPaddingLeft(), r5, r6.getPaddingRight(), r6.getPaddingBottom());
        return;
    L4:
        r5 = r4 + d.i.a.a(TypedValue.applyDimension(1, 16, Resources.getSystem().getDisplayMetrics()));
        goto L5
    }
}
