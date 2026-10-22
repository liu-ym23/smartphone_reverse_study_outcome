package com.obric.oui.panel;

import android.animation.ObjectAnimator;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.widget.FrameLayout;
import androidx.appcompat.app.AppCompatDialogFragment;
import com.obric.aiagent.plugin.R;
import com.obric.oui.common.util.j;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import d.h.b.p;
import d.x;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: OBasicPanelFragment.kt */
/* JADX INFO: loaded from: classes4.dex */
public class OBasicPanelFragment extends AppCompatDialogFragment {
    private boolean adaptNavBarColor;
    private boolean adaptRLSlide;
    private com.obric.oui.panel.anim.a animConfig;
    private final com.obric.oui.panel.anim.b animController;
    private boolean autoSwitchDayNight;
    private boolean backgroundDimEnable;
    private List<? extends BottomSheetBehavior.a> bottomSheetCallbacks;
    private final a bottomSheetDismissCallback;
    private boolean clipTopCorner;
    private Integer collapsedHeight;
    private boolean disableAutoAdaptHeight;
    private d.h.a.b<? super MotionEvent, Boolean> dispatchTouchEvent;
    private Integer expandedHeight;
    private boolean fitsSystemWindows;
    private boolean fixedPanelHeight;
    private boolean floatHeader;
    private boolean isExpandable;
    private int maxPanelHeight;
    private Integer navBarColor;
    private DialogInterface.OnCancelListener onCancelListener;
    private d.h.a.a<Boolean> onDialogBackPressCallback;
    private DialogInterface.OnDismissListener onDismissListener;
    private View.OnClickListener outsideClickListener;
    private OBasicPanel.c padCompatConfig;
    private com.obric.oui.panel.header.c panelHeader;
    private boolean removeMinHeight;
    private int styleId;
    private boolean useToneBg;
    private boolean waitingForDismissAllowingStateLoss;

    /* JADX INFO: compiled from: OBasicPanelFragment.kt */
    public static final class a extends BottomSheetBehavior.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ OBasicPanelFragment f35891a;

        @Override // com.obric.oui.panel.BottomSheetBehavior.a
        public void a(View r1, float r2) {
            o.e(r1, "bottomSheet");
        }

        a(OBasicPanelFragment r1) {
            this.f35891a = r1;
        }

        @Override // com.obric.oui.panel.BottomSheetBehavior.a
        public void a(View r2, int r3) {
            o.e(r2, "bottomSheet");
            if (r3 != 5) goto L6;
            OBasicPanelFragment.access$dismissAfterAnimation(this.f35891a);
            return;
        }
    }

    /* JADX INFO: compiled from: OBasicPanelFragment.kt */
    static final class b extends p implements d.h.a.b<Float, x> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ OBasicPanelFragment f35892a;

        b(OBasicPanelFragment r1) {
            this.f35892a = r1;
            super(1);
        }

        @Override // d.h.a.b
        public /* synthetic */ x invoke(Float r3) {
            a(((Number) ZeusTransformUtils.preCheckCast(r3, Number.class, "com.obric.aiagent.plugin")).floatValue());
            return x.f38692a;
        }

        public final void a(float r2) {
            OBasicPanelFragment.access$dispatchAnimProgress(this.f35892a, r2, false);
        }
    }

    /* JADX INFO: compiled from: OBasicPanelFragment.kt */
    static final class c extends p implements d.h.a.b<Float, x> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ OBasicPanelFragment f35893a;

        c(OBasicPanelFragment r1) {
            this.f35893a = r1;
            super(1);
        }

        @Override // d.h.a.b
        public /* synthetic */ x invoke(Float r3) {
            a(((Number) ZeusTransformUtils.preCheckCast(r3, Number.class, "com.obric.aiagent.plugin")).floatValue());
            return x.f38692a;
        }

        public final void a(float r4) {
            OBasicPanelFragment.dispatchAnimProgress$default(this.f35893a, r4, false, 2, null);
        }
    }

    /* JADX INFO: renamed from: lambda$-8t2uODDuoJ8tgRcZnJfUC2aa0M, reason: not valid java name */
    public static /* synthetic */ void m1112lambda$8t2uODDuoJ8tgRcZnJfUC2aa0M(OBasicPanelFragment r0, DialogInterface r1) {
        m1113onViewCreated$lambda2(r0, r1);
    }

    public OBasicPanelFragment() {
        this.maxPanelHeight = -1;
        this.backgroundDimEnable = true;
        this.clipTopCorner = true;
        this.fitsSystemWindows = true;
        this.styleId = ZeusTransformUtils.mapRes(R.style.OBasicPanel, "style", "OBasicPanel");
        this.animController = new com.obric.oui.panel.anim.b();
        this.bottomSheetDismissCallback = new a(this);
    }

    public static final /* synthetic */ void access$dismissAfterAnimation(OBasicPanelFragment r0) {
        r0.dismissAfterAnimation();
    }

    public static final /* synthetic */ void access$dispatchAnimProgress(OBasicPanelFragment r0, float r1, boolean r2) {
        r0.dispatchAnimProgress(r1, r2);
    }

    public final int getMaxPanelHeight() {
        return this.maxPanelHeight;
    }

    public final void setMaxPanelHeight(int r1) {
        this.maxPanelHeight = r1;
    }

    public final boolean getUseToneBg() {
        return this.useToneBg;
    }

    public final void setUseToneBg(boolean r1) {
        this.useToneBg = r1;
    }

    public final boolean isExpandable() {
        return this.isExpandable;
    }

    public final void setExpandable(boolean r1) {
        this.isExpandable = r1;
    }

    public final boolean getFloatHeader() {
        return this.floatHeader;
    }

    public final void setFloatHeader(boolean r1) {
        this.floatHeader = r1;
    }

    public final boolean getBackgroundDimEnable() {
        return this.backgroundDimEnable;
    }

    public final void setBackgroundDimEnable(boolean r1) {
        this.backgroundDimEnable = r1;
    }

    public final boolean getAdaptNavBarColor() {
        return this.adaptNavBarColor;
    }

    public final void setAdaptNavBarColor(boolean r1) {
        this.adaptNavBarColor = r1;
    }

    public final com.obric.oui.panel.header.c getPanelHeader() {
        return this.panelHeader;
    }

    public final void setPanelHeader(com.obric.oui.panel.header.c r1) {
        this.panelHeader = r1;
    }

    public final Integer getNavBarColor() {
        return this.navBarColor;
    }

    public final void setNavBarColor(Integer r1) {
        this.navBarColor = r1;
    }

    public final d.h.a.a<Boolean> getOnDialogBackPressCallback() {
        return this.onDialogBackPressCallback;
    }

    public final void setOnDialogBackPressCallback(d.h.a.a<Boolean> r3) {
        this.onDialogBackPressCallback = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r3, d.h.a.a.class, "com.obric.aiagent.plugin");
    }

    public final DialogInterface.OnDismissListener getOnDismissListener() {
        return this.onDismissListener;
    }

    public final void setOnDismissListener(DialogInterface.OnDismissListener r3) {
        this.onDismissListener = (DialogInterface.OnDismissListener) ZeusTransformUtils.wrapperContextForParams(r3, DialogInterface.OnDismissListener.class, "com.obric.aiagent.plugin");
    }

    public final DialogInterface.OnCancelListener getOnCancelListener() {
        return this.onCancelListener;
    }

    public final void setOnCancelListener(DialogInterface.OnCancelListener r3) {
        this.onCancelListener = (DialogInterface.OnCancelListener) ZeusTransformUtils.wrapperContextForParams(r3, DialogInterface.OnCancelListener.class, "com.obric.aiagent.plugin");
    }

    public final boolean getClipTopCorner() {
        return this.clipTopCorner;
    }

    public final void setClipTopCorner(boolean r1) {
        this.clipTopCorner = r1;
    }

    public final boolean getAutoSwitchDayNight() {
        return this.autoSwitchDayNight;
    }

    public final void setAutoSwitchDayNight(boolean r1) {
        this.autoSwitchDayNight = r1;
    }

    public final d.h.a.b<MotionEvent, Boolean> getDispatchTouchEvent() {
        return this.dispatchTouchEvent;
    }

    public final void setDispatchTouchEvent(d.h.a.b<? super MotionEvent, Boolean> r3) {
        this.dispatchTouchEvent = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r3, d.h.a.b.class, "com.obric.aiagent.plugin");
    }

    public final boolean getRemoveMinHeight() {
        return this.removeMinHeight;
    }

    public final void setRemoveMinHeight(boolean r1) {
        this.removeMinHeight = r1;
    }

    public final Integer getCollapsedHeight() {
        return this.collapsedHeight;
    }

    public final void setCollapsedHeight(Integer r1) {
        this.collapsedHeight = r1;
    }

    public final Integer getExpandedHeight() {
        return this.expandedHeight;
    }

    public final void setExpandedHeight(Integer r1) {
        this.expandedHeight = r1;
    }

    public final boolean getFitsSystemWindows() {
        return this.fitsSystemWindows;
    }

    public final void setFitsSystemWindows(boolean r1) {
        this.fitsSystemWindows = r1;
    }

    public final List<BottomSheetBehavior.a> getBottomSheetCallbacks() {
        return this.bottomSheetCallbacks;
    }

    public final void setBottomSheetCallbacks(List<? extends BottomSheetBehavior.a> r3) {
        this.bottomSheetCallbacks = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
    }

    public final boolean getFixedPanelHeight() {
        return this.fixedPanelHeight;
    }

    public final void setFixedPanelHeight(boolean r1) {
        this.fixedPanelHeight = r1;
    }

    public final com.obric.oui.panel.anim.a getAnimConfig() {
        return this.animConfig;
    }

    public final void setAnimConfig(com.obric.oui.panel.anim.a r3) {
        this.animConfig = (com.obric.oui.panel.anim.a) ZeusTransformUtils.wrapperContextForParams(r3, com.obric.oui.panel.anim.a.class, "com.obric.aiagent.plugin");
    }

    public final int getStyleId() {
        return this.styleId;
    }

    public final void setStyleId(int r1) {
        this.styleId = r1;
    }

    public final boolean getAdaptRLSlide() {
        return this.adaptRLSlide;
    }

    public final void setAdaptRLSlide(boolean r1) {
        this.adaptRLSlide = r1;
    }

    public final boolean getDisableAutoAdaptHeight() {
        return this.disableAutoAdaptHeight;
    }

    public final void setDisableAutoAdaptHeight(boolean r1) {
        this.disableAutoAdaptHeight = r1;
    }

    public final com.obric.oui.panel.anim.b getAnimController$OUI_standardRelease() {
        return this.animController;
    }

    public final View.OnClickListener getOutsideClickListener() {
        return this.outsideClickListener;
    }

    public final void setOutsideClickListener(View.OnClickListener r3) {
        this.outsideClickListener = (View.OnClickListener) ZeusTransformUtils.wrapperContextForParams(r3, View.OnClickListener.class, "com.obric.aiagent.plugin");
    }

    public final OBasicPanel.c getPadCompatConfig() {
        return this.padCompatConfig;
    }

    public final void setPadCompatConfig(OBasicPanel.c r1) {
        this.padCompatConfig = r1;
    }

    @Override // androidx.appcompat.app.AppCompatDialogFragment, androidx.fragment.app.DialogFragment
    public Dialog onCreateDialog(Bundle r4) {
        Context r0 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(requireContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        o.c(r0, "requireContext()");
        OBasePanelDialog r5 = new OBasePanelDialog(r0, this.styleId);
        r5.setMaxPanelHeight(getMaxPanelHeight());
        r5.setUseToneBg(getUseToneBg());
        r5.setExpandable(isExpandable());
        r5.setFloatHeader(getFloatHeader());
        r5.setBackgroundDimEnable(getBackgroundDimEnable());
        r5.setAdaptNavBarColor(getAdaptNavBarColor());
        r5.setPanelHeader(getPanelHeader());
        r5.setNavBarColor(getNavBarColor());
        r5.setOnDialogBackPressCallback(getOnDialogBackPressCallback());
        r5.setClipTopCorner(getClipTopCorner());
        r5.setAutoSwitchDayNight(getAutoSwitchDayNight());
        r5.setDispatchTouchEvent(getDispatchTouchEvent());
        r5.setRemoveMinHeight(getRemoveMinHeight());
        r5.setPadCompatConfig(getPadCompatConfig());
        r5.setFixedHeight(getFixedPanelHeight());
        r5.setOutsideClickListener(getOutsideClickListener());
        r5.setCollapsedHeight(getCollapsedHeight());
        r5.setExpandedHeight(getExpandedHeight());
        r5.setFitsSystemWindows(getFitsSystemWindows());
        r5.setAdaptRLSlide(getAdaptRLSlide());
        r5.setDisableAutoAdaptHeight(getDisableAutoAdaptHeight());
        if (getBottomSheetCallbacks() == null) goto L12;
        List<BottomSheetBehavior.a> r3 = getBottomSheetCallbacks();
        if (r3 == null) goto L12;
        Iterator r6 = ((Iterable) ZeusTransformUtils.preCheckCast(r3, Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L9:
        if (r6.hasNext() == false) goto L12;
        r5.addBottomSheetCallback((BottomSheetBehavior.a) ZeusTransformUtils.preCheckCast(r6.next(), BottomSheetBehavior.a.class, "com.obric.aiagent.plugin"));
    L12:
        return (Dialog) ZeusTransformUtils.preCheckCast(r5, Dialog.class, "com.obric.aiagent.plugin");
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View r2, Bundle r3) {
        o.e(r2, "view");
        super.onViewCreated(r2, r3);
        Dialog r4 = getDialog();
        if (r4 == null) goto L7;
        r4.setOnShowListener(new $$Lambda$OBasicPanelFragment$8t2uODDuoJ8tgRcZnJfUC2aa0M(this));
        return;
    }

    /* JADX INFO: renamed from: onViewCreated$lambda-2, reason: not valid java name */
    private static final void m1113onViewCreated$lambda2(OBasicPanelFragment r2, DialogInterface r3) {
        DialogInterface r4 = (DialogInterface) ZeusTransformUtils.wrapperContextForParams(r3, DialogInterface.class, "com.obric.aiagent.plugin");
        o.e(r2, "this$0");
        r2.exeEnterAnim();
    }

    private final void exeEnterAnim() {
        Dialog r0 = getDialog();
        View r1 = null;
        if (r0 == null) goto L9;
        Window r2 = r0.getWindow();
        if (r2 == null) goto L9;
        r1 = r2.getDecorView();
    L9:
        if (r1 == null) goto L18;
        com.obric.oui.panel.anim.a r3 = this.animConfig;
        if (r3 == null) goto L19;
        ObjectAnimator r4 = r3.a(r1);
        if (r4 == null) goto L20;
        getAnimController$OUI_standardRelease().a(r4, (d.h.a.b) ZeusTransformUtils.preCheckCast(new b(this), d.h.a.b.class, "com.obric.aiagent.plugin"));
        return;
    L20:
        return;
    L19:
        return;
    }

    private final void exeExitAnim() {
        Dialog r0 = getDialog();
        View r1 = null;
        if (r0 == null) goto L9;
        Window r2 = r0.getWindow();
        if (r2 == null) goto L9;
        r1 = r2.getDecorView();
    L9:
        if (r1 == null) goto L18;
        com.obric.oui.panel.anim.a r3 = this.animConfig;
        if (r3 == null) goto L19;
        ObjectAnimator r4 = r3.b(r1);
        if (r4 == null) goto L20;
        getAnimController$OUI_standardRelease().b(r4, (d.h.a.b) ZeusTransformUtils.preCheckCast(new c(this), d.h.a.b.class, "com.obric.aiagent.plugin"));
        return;
    L20:
        return;
    L19:
        return;
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface r3) {
        DialogInterface r4 = (DialogInterface) ZeusTransformUtils.wrapperContextForParams(r3, DialogInterface.class, "com.obric.aiagent.plugin");
        o.e(r4, "dialog");
        exeExitAnim();
        super.onCancel(r4);
        DialogInterface.OnCancelListener r2 = this.onCancelListener;
        if (r2 == null) goto L7;
        r2.onCancel(r4);
        return;
    }

    @Override // androidx.fragment.app.DialogFragment
    public void dismiss() {
        exeExitAnim();     // Catch: Exception -> L7
        if (tryDismissWithAnimation(true) == true) goto L5;
        super.dismiss();     // Catch: Exception -> L7
    L5:
        x r2 = x.f38692a;     // Catch: Exception -> L7
        return;
    L7:
        e = move-exception;
        j.a(o.a("Try exception occur ", e.getMessage()));
        Throwable r3 = (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin");
        x r4 = x.f38692a;
    }

    @Override // androidx.fragment.app.DialogFragment
    public void dismissAllowingStateLoss() {
        exeExitAnim();
        super.dismissAllowingStateLoss();
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface r3) {
        DialogInterface r4 = (DialogInterface) ZeusTransformUtils.wrapperContextForParams(r3, DialogInterface.class, "com.obric.aiagent.plugin");
        o.e(r4, "dialog");
        super.onDismiss(r4);
        DialogInterface.OnDismissListener r2 = this.onDismissListener;
        if (r2 == null) goto L7;
        r2.onDismiss(r4);
        return;
    }

    public final int getBgColor() {
        Dialog r2 = getDialog();
        if (ZeusTransformUtils.instanceOf(r2, OBasePanelDialog.class) == false) goto L5;
        OBasePanelDialog r3 = (OBasePanelDialog) ZeusTransformUtils.preCheckCast(r2, OBasePanelDialog.class, "com.obric.aiagent.plugin");
    L6:
        if (r3 != null) goto L9;
        return 0;
    L9:
        return r3.getBgColor();
    L5:
        r3 = null;
        goto L6
    }

    private final boolean tryDismissWithAnimation(boolean r5) {
        Dialog r0 = getDialog();
        if (ZeusTransformUtils.instanceOf(r0, BottomSheetDialog.class) == false) goto L10;
        BottomSheetBehavior<FrameLayout> r1 = ((BottomSheetDialog) ZeusTransformUtils.preCheckCast(r0, BottomSheetDialog.class, "com.obric.aiagent.plugin")).getBehavior();
        o.c(r1, "dialog.behavior");
        if (r1.b() == true) goto L7;
        return false;
    L7:
        if (((BottomSheetDialog) ZeusTransformUtils.preCheckCast(r0, BottomSheetDialog.class, "com.obric.aiagent.plugin")).getDismissWithAnimation() == false) goto L13;
        dismissWithAnimation(r1, r5);
        return true;
    L13:
        return false;
    L10:
        return false;
    }

    private final void dismissWithAnimation(BottomSheetBehavior<?> r4, boolean r5) {
        this.waitingForDismissAllowingStateLoss = r5;
        if (r4.c() != 5) goto L6;
        dismissAfterAnimation();
        return;
    L6:
        if (ZeusTransformUtils.instanceOf(getDialog(), BottomSheetDialog.class) == false) goto L15;
        BottomSheetDialog r6 = (BottomSheetDialog) ZeusTransformUtils.preCheckCast(getDialog(), BottomSheetDialog.class, "com.obric.aiagent.plugin");
        if (r6 == null) goto L11;
        r6.removeDefaultCallback();
    L11:
        BottomSheetDialog r7 = (BottomSheetDialog) ZeusTransformUtils.preCheckCast(getDialog(), BottomSheetDialog.class, "com.obric.aiagent.plugin");
        if (r7 == null) goto L15;
        r7.clearBottomSheetCallback();
    L15:
        r4.b((BottomSheetBehavior.a) ZeusTransformUtils.preCheckCast(this.bottomSheetDismissCallback, BottomSheetBehavior.a.class, "com.obric.aiagent.plugin"));
        r4.b(5);
    }

    private final void dismissAfterAnimation() {
        if (this.waitingForDismissAllowingStateLoss == false) goto L5;
        super.dismissAllowingStateLoss();
        return;
    L5:
        super.dismiss();
    }

    static /* synthetic */ void dispatchAnimProgress$default(OBasicPanelFragment r0, float r1, boolean r2, int r3, Object r4) {
        if (r4 != null) goto L9;
        if ((r3 & 2) == 0) goto L6;
        r2 = true;
    L6:
        r0.dispatchAnimProgress(r1, r2);
        return;
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: dispatchAnimProgress");
    }

    private final void dispatchAnimProgress(float r4, boolean r5) {
        List<? extends BottomSheetBehavior.a> r3 = this.bottomSheetCallbacks;
        if (r3 == null) goto L12;
        Iterator r6 = ((Iterable) ZeusTransformUtils.preCheckCast(r3, Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L7:
        if (r6.hasNext() == false) goto L19;
        BottomSheetBehavior.a r0 = (BottomSheetBehavior.a) ZeusTransformUtils.preCheckCast(r6.next(), BottomSheetBehavior.a.class, "com.obric.aiagent.plugin");
        if (r5 == true) goto L10;
        r0.a(r4);
        goto L7
    L10:
        r0.b(r4);
        goto L7
    L19:
        return;
    }
}
