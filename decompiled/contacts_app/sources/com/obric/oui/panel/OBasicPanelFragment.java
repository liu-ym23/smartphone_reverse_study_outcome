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
import com.obric.common.oui.R;
import com.obric.oui.common.util.ToolsExtKt;
import com.obric.oui.panel.anim.AnimConfig;
import com.obric.oui.panel.anim.AnimController;
import com.obric.oui.panel.header.BasicPanelHeader;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: OBasicPanelFragment.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000¯\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u001b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001$\b\u0016\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010~\u001a\u00020\u007fH\u0016J\t\u0010\u0080\u0001\u001a\u00020\u007fH\u0002J\t\u0010\u0081\u0001\u001a\u00020\u007fH\u0016J\"\u0010\u0082\u0001\u001a\u00020\u007f2\u000e\b\u0001\u0010\u0083\u0001\u001a\u0007\u0012\u0002\b\u00030\u0084\u00012\u0007\u0010\u0085\u0001\u001a\u00020\u0004H\u0002J\u001e\u0010\u0086\u0001\u001a\u00020\u007f2\b\u0010\u0087\u0001\u001a\u00030\u0088\u00012\t\b\u0002\u0010\u0089\u0001\u001a\u00020\u0004H\u0002J\t\u0010\u008a\u0001\u001a\u00020\u007fH\u0002J\t\u0010\u008b\u0001\u001a\u00020\u007fH\u0002J\u0007\u0010\u008c\u0001\u001a\u00020*J\u0013\u0010\u008d\u0001\u001a\u00020\u007f2\b\u0010\u008e\u0001\u001a\u00030\u008f\u0001H\u0016J\u0016\u0010\u0090\u0001\u001a\u00030\u0091\u00012\n\u0010\u0092\u0001\u001a\u0005\u0018\u00010\u0093\u0001H\u0016J\u0013\u0010\u0094\u0001\u001a\u00020\u007f2\b\u0010\u008e\u0001\u001a\u00030\u008f\u0001H\u0016J\u001f\u0010\u0095\u0001\u001a\u00020\u007f2\b\u0010\u0096\u0001\u001a\u00030\u0097\u00012\n\u0010\u0092\u0001\u001a\u0005\u0018\u00010\u0093\u0001H\u0016J\u0012\u0010\u0098\u0001\u001a\u00020\u00042\u0007\u0010\u0085\u0001\u001a\u00020\u0004H\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001c\u0010\f\u001a\u0004\u0018\u00010\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0012\u001a\u00020\u0013X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0016\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0006\"\u0004\b\u0018\u0010\bR\u001a\u0010\u0019\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0006\"\u0004\b\u001b\u0010\bR\"\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u001e\u0018\u00010\u001dX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u0010\u0010#\u001a\u00020$X\u0082\u0004¢\u0006\u0004\n\u0002\u0010%R\u001a\u0010&\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010\u0006\"\u0004\b(\u0010\bR\u001e\u0010)\u001a\u0004\u0018\u00010*X\u0086\u000e¢\u0006\u0010\n\u0002\u0010/\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\u001a\u00100\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u0010\u0006\"\u0004\b2\u0010\bR(\u00103\u001a\u0010\u0012\u0004\u0012\u000205\u0012\u0004\u0012\u00020\u0004\u0018\u000104X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b6\u00107\"\u0004\b8\u00109R\u001e\u0010:\u001a\u0004\u0018\u00010*X\u0086\u000e¢\u0006\u0010\n\u0002\u0010/\u001a\u0004\b;\u0010,\"\u0004\b<\u0010.R\u001a\u0010=\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b>\u0010\u0006\"\u0004\b?\u0010\bR\u001a\u0010@\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bA\u0010\u0006\"\u0004\bB\u0010\bR\u001a\u0010C\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bD\u0010\u0006\"\u0004\bE\u0010\bR\u001a\u0010F\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bF\u0010\u0006\"\u0004\bG\u0010\bR\u001a\u0010H\u001a\u00020*X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bI\u0010J\"\u0004\bK\u0010LR\"\u0010M\u001a\u0004\u0018\u00010*8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010/\u001a\u0004\bN\u0010,\"\u0004\bO\u0010.R\u001c\u0010P\u001a\u0004\u0018\u00010QX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bR\u0010S\"\u0004\bT\u0010UR\"\u0010V\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010WX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bX\u0010Y\"\u0004\bZ\u0010[R\u001c\u0010\\\u001a\u0004\u0018\u00010]X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b^\u0010_\"\u0004\b`\u0010aR\u001c\u0010b\u001a\u0004\u0018\u00010cX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bd\u0010e\"\u0004\bf\u0010gR\u001c\u0010h\u001a\u0004\u0018\u00010iX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bj\u0010k\"\u0004\bl\u0010mR\u001c\u0010n\u001a\u0004\u0018\u00010oX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bp\u0010q\"\u0004\br\u0010sR\u001a\u0010t\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bu\u0010\u0006\"\u0004\bv\u0010\bR\u001a\u0010w\u001a\u00020*X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bx\u0010J\"\u0004\by\u0010LR\u001a\u0010z\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b{\u0010\u0006\"\u0004\b|\u0010\bR\u000e\u0010}\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0099\u0001"}, d2 = {"Lcom/obric/oui/panel/OBasicPanelFragment;", "Landroidx/appcompat/app/AppCompatDialogFragment;", "()V", "adaptNavBarColor", "", "getAdaptNavBarColor", "()Z", "setAdaptNavBarColor", "(Z)V", "adaptRLSlide", "getAdaptRLSlide", "setAdaptRLSlide", "animConfig", "Lcom/obric/oui/panel/anim/AnimConfig;", "getAnimConfig", "()Lcom/obric/oui/panel/anim/AnimConfig;", "setAnimConfig", "(Lcom/obric/oui/panel/anim/AnimConfig;)V", "animController", "Lcom/obric/oui/panel/anim/AnimController;", "getAnimController$OUI_standardRelease", "()Lcom/obric/oui/panel/anim/AnimController;", "autoSwitchDayNight", "getAutoSwitchDayNight", "setAutoSwitchDayNight", "backgroundDimEnable", "getBackgroundDimEnable", "setBackgroundDimEnable", "bottomSheetCallbacks", "", "Lcom/obric/oui/panel/BottomSheetBehavior$BottomSheetCallback;", "getBottomSheetCallbacks", "()Ljava/util/List;", "setBottomSheetCallbacks", "(Ljava/util/List;)V", "bottomSheetDismissCallback", "com/obric/oui/panel/OBasicPanelFragment$bottomSheetDismissCallback$1", "Lcom/obric/oui/panel/OBasicPanelFragment$bottomSheetDismissCallback$1;", "clipTopCorner", "getClipTopCorner", "setClipTopCorner", "collapsedHeight", "", "getCollapsedHeight", "()Ljava/lang/Integer;", "setCollapsedHeight", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "disableAutoAdaptHeight", "getDisableAutoAdaptHeight", "setDisableAutoAdaptHeight", "dispatchTouchEvent", "Lkotlin/Function1;", "Landroid/view/MotionEvent;", "getDispatchTouchEvent", "()Lkotlin/jvm/functions/Function1;", "setDispatchTouchEvent", "(Lkotlin/jvm/functions/Function1;)V", "expandedHeight", "getExpandedHeight", "setExpandedHeight", "fitsSystemWindows", "getFitsSystemWindows", "setFitsSystemWindows", "fixedPanelHeight", "getFixedPanelHeight", "setFixedPanelHeight", "floatHeader", "getFloatHeader", "setFloatHeader", "isExpandable", "setExpandable", "maxPanelHeight", "getMaxPanelHeight", "()I", "setMaxPanelHeight", "(I)V", "navBarColor", "getNavBarColor", "setNavBarColor", "onCancelListener", "Landroid/content/DialogInterface$OnCancelListener;", "getOnCancelListener", "()Landroid/content/DialogInterface$OnCancelListener;", "setOnCancelListener", "(Landroid/content/DialogInterface$OnCancelListener;)V", "onDialogBackPressCallback", "Lkotlin/Function0;", "getOnDialogBackPressCallback", "()Lkotlin/jvm/functions/Function0;", "setOnDialogBackPressCallback", "(Lkotlin/jvm/functions/Function0;)V", "onDismissListener", "Landroid/content/DialogInterface$OnDismissListener;", "getOnDismissListener", "()Landroid/content/DialogInterface$OnDismissListener;", "setOnDismissListener", "(Landroid/content/DialogInterface$OnDismissListener;)V", "outsideClickListener", "Landroid/view/View$OnClickListener;", "getOutsideClickListener", "()Landroid/view/View$OnClickListener;", "setOutsideClickListener", "(Landroid/view/View$OnClickListener;)V", "padCompatConfig", "Lcom/obric/oui/panel/OBasicPanel$PadCompatConfig;", "getPadCompatConfig", "()Lcom/obric/oui/panel/OBasicPanel$PadCompatConfig;", "setPadCompatConfig", "(Lcom/obric/oui/panel/OBasicPanel$PadCompatConfig;)V", "panelHeader", "Lcom/obric/oui/panel/header/BasicPanelHeader;", "getPanelHeader", "()Lcom/obric/oui/panel/header/BasicPanelHeader;", "setPanelHeader", "(Lcom/obric/oui/panel/header/BasicPanelHeader;)V", "removeMinHeight", "getRemoveMinHeight", "setRemoveMinHeight", "styleId", "getStyleId", "setStyleId", "useToneBg", "getUseToneBg", "setUseToneBg", "waitingForDismissAllowingStateLoss", "dismiss", "", "dismissAfterAnimation", "dismissAllowingStateLoss", "dismissWithAnimation", "behavior", "Lcom/obric/oui/panel/BottomSheetBehavior;", "allowingStateLoss", "dispatchAnimProgress", "value", "", "out", "exeEnterAnim", "exeExitAnim", "getBgColor", "onCancel", "dialog", "Landroid/content/DialogInterface;", "onCreateDialog", "Landroid/app/Dialog;", "savedInstanceState", "Landroid/os/Bundle;", "onDismiss", "onViewCreated", "view", "Landroid/view/View;", "tryDismissWithAnimation", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public class OBasicPanelFragment extends AppCompatDialogFragment {
    private boolean adaptNavBarColor;
    private boolean adaptRLSlide;
    private AnimConfig animConfig;
    private final AnimController animController;
    private boolean autoSwitchDayNight;
    private boolean backgroundDimEnable;
    private List<? extends BottomSheetBehavior.BottomSheetCallback> bottomSheetCallbacks;
    private final OBasicPanelFragment$bottomSheetDismissCallback$1 bottomSheetDismissCallback;
    private boolean clipTopCorner;
    private Integer collapsedHeight;
    private boolean disableAutoAdaptHeight;
    private Function1<? super MotionEvent, Boolean> dispatchTouchEvent;
    private Integer expandedHeight;
    private boolean fitsSystemWindows;
    private boolean fixedPanelHeight;
    private boolean floatHeader;
    private boolean isExpandable;
    private int maxPanelHeight;
    private Integer navBarColor;
    private DialogInterface.OnCancelListener onCancelListener;
    private Function0<Boolean> onDialogBackPressCallback;
    private DialogInterface.OnDismissListener onDismissListener;
    private View.OnClickListener outsideClickListener;
    private OBasicPanel.PadCompatConfig padCompatConfig;
    private BasicPanelHeader panelHeader;
    private boolean removeMinHeight;
    private int styleId;
    private boolean useToneBg;
    private boolean waitingForDismissAllowingStateLoss;

    /* JADX INFO: renamed from: $r8$lambda$-8t2uODDuoJ8tgRcZnJfUC2aa0M, reason: not valid java name */
    public static /* synthetic */ void m575$r8$lambda$8t2uODDuoJ8tgRcZnJfUC2aa0M(OBasicPanelFragment r0, DialogInterface r1) {
        m576onViewCreated$lambda2(r0, r1);
    }

    /* JADX WARN: Type inference failed for: r0v4, types: [com.obric.oui.panel.OBasicPanelFragment$bottomSheetDismissCallback$1] */
    public OBasicPanelFragment() {
        this.maxPanelHeight = -1;
        this.backgroundDimEnable = true;
        this.clipTopCorner = true;
        this.fitsSystemWindows = true;
        this.styleId = R.style.OBasicPanel;
        this.animController = new AnimController();
        this.bottomSheetDismissCallback = new OBasicPanelFragment$bottomSheetDismissCallback$1(this);
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

    public final BasicPanelHeader getPanelHeader() {
        return this.panelHeader;
    }

    public final void setPanelHeader(BasicPanelHeader r1) {
        this.panelHeader = r1;
    }

    public final Integer getNavBarColor() {
        return this.navBarColor;
    }

    public final void setNavBarColor(Integer r1) {
        this.navBarColor = r1;
    }

    public final Function0<Boolean> getOnDialogBackPressCallback() {
        return this.onDialogBackPressCallback;
    }

    public final void setOnDialogBackPressCallback(Function0<Boolean> r1) {
        this.onDialogBackPressCallback = r1;
    }

    public final DialogInterface.OnDismissListener getOnDismissListener() {
        return this.onDismissListener;
    }

    public final void setOnDismissListener(DialogInterface.OnDismissListener r1) {
        this.onDismissListener = r1;
    }

    public final DialogInterface.OnCancelListener getOnCancelListener() {
        return this.onCancelListener;
    }

    public final void setOnCancelListener(DialogInterface.OnCancelListener r1) {
        this.onCancelListener = r1;
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

    public final Function1<MotionEvent, Boolean> getDispatchTouchEvent() {
        return this.dispatchTouchEvent;
    }

    public final void setDispatchTouchEvent(Function1<? super MotionEvent, Boolean> r1) {
        this.dispatchTouchEvent = r1;
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

    public final List<BottomSheetBehavior.BottomSheetCallback> getBottomSheetCallbacks() {
        return this.bottomSheetCallbacks;
    }

    public final void setBottomSheetCallbacks(List<? extends BottomSheetBehavior.BottomSheetCallback> r1) {
        this.bottomSheetCallbacks = r1;
    }

    public final boolean getFixedPanelHeight() {
        return this.fixedPanelHeight;
    }

    public final void setFixedPanelHeight(boolean r1) {
        this.fixedPanelHeight = r1;
    }

    public final AnimConfig getAnimConfig() {
        return this.animConfig;
    }

    public final void setAnimConfig(AnimConfig r1) {
        this.animConfig = r1;
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

    public final AnimController getAnimController$OUI_standardRelease() {
        return this.animController;
    }

    public final View.OnClickListener getOutsideClickListener() {
        return this.outsideClickListener;
    }

    public final void setOutsideClickListener(View.OnClickListener r1) {
        this.outsideClickListener = r1;
    }

    public final OBasicPanel.PadCompatConfig getPadCompatConfig() {
        return this.padCompatConfig;
    }

    public final void setPadCompatConfig(OBasicPanel.PadCompatConfig r1) {
        this.padCompatConfig = r1;
    }

    @Override // androidx.appcompat.app.AppCompatDialogFragment, androidx.fragment.app.DialogFragment
    public Dialog onCreateDialog(Bundle r3) {
        Context r0 = requireContext();
        Intrinsics.checkNotNullExpressionValue(r0, "requireContext()");
        OBasePanelDialog r4 = new OBasePanelDialog(r0, this.styleId);
        r4.setMaxPanelHeight(getMaxPanelHeight());
        r4.setUseToneBg(getUseToneBg());
        r4.setExpandable(isExpandable());
        r4.setFloatHeader(getFloatHeader());
        r4.setBackgroundDimEnable(getBackgroundDimEnable());
        r4.setAdaptNavBarColor(getAdaptNavBarColor());
        r4.setPanelHeader(getPanelHeader());
        r4.setNavBarColor(getNavBarColor());
        r4.setOnDialogBackPressCallback(getOnDialogBackPressCallback());
        r4.setClipTopCorner(getClipTopCorner());
        r4.setAutoSwitchDayNight(getAutoSwitchDayNight());
        r4.setDispatchTouchEvent(getDispatchTouchEvent());
        r4.setRemoveMinHeight(getRemoveMinHeight());
        r4.setPadCompatConfig(getPadCompatConfig());
        r4.setFixedHeight(getFixedPanelHeight());
        r4.setOutsideClickListener(getOutsideClickListener());
        r4.setCollapsedHeight(getCollapsedHeight());
        r4.setExpandedHeight(getExpandedHeight());
        r4.setFitsSystemWindows(getFitsSystemWindows());
        r4.setAdaptRLSlide(getAdaptRLSlide());
        r4.setDisableAutoAdaptHeight(getDisableAutoAdaptHeight());
        if (getBottomSheetCallbacks() == null) goto L12;
        List<BottomSheetBehavior.BottomSheetCallback> r2 = getBottomSheetCallbacks();
        if (r2 == null) goto L12;
        Iterator<T> r5 = r2.iterator();
    L9:
        if (r5.hasNext() == false) goto L12;
        r4.addBottomSheetCallback((BottomSheetBehavior.BottomSheetCallback) r5.next());
    L12:
        return r4;
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View r2, Bundle r3) {
        Intrinsics.checkNotNullParameter(r2, "view");
        super.onViewCreated(r2, r3);
        Dialog r4 = getDialog();
        if (r4 == null) goto L7;
        r4.setOnShowListener(new OBasicPanelFragment$$ExternalSyntheticLambda0(this));
        return;
    }

    /* JADX INFO: renamed from: onViewCreated$lambda-2, reason: not valid java name */
    private static final void m576onViewCreated$lambda2(OBasicPanelFragment r0, DialogInterface r1) {
        Intrinsics.checkNotNullParameter(r0, "this$0");
        r0.exeEnterAnim();
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
        AnimConfig r3 = this.animConfig;
        if (r3 == null) goto L19;
        ObjectAnimator r4 = r3.getEnterAnim(r1);
        if (r4 == null) goto L20;
        getAnimController$OUI_standardRelease().doEnterAnim(r4, new OBasicPanelFragment$exeEnterAnim$1$1(this));
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
        AnimConfig r3 = this.animConfig;
        if (r3 == null) goto L19;
        ObjectAnimator r4 = r3.getExitAnim(r1);
        if (r4 == null) goto L20;
        getAnimController$OUI_standardRelease().doExitAnim(r4, new OBasicPanelFragment$exeExitAnim$1$1(this));
        return;
    L20:
        return;
    L19:
        return;
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface r2) {
        Intrinsics.checkNotNullParameter(r2, "dialog");
        exeExitAnim();
        super.onCancel(r2);
        DialogInterface.OnCancelListener r1 = this.onCancelListener;
        if (r1 == null) goto L7;
        r1.onCancel(r2);
        return;
    }

    @Override // androidx.fragment.app.DialogFragment
    public void dismiss() {
        exeExitAnim();     // Catch: Exception -> L7
        if (tryDismissWithAnimation(true) == true) goto L5;
        super.dismiss();     // Catch: Exception -> L7
    L5:
        Unit r2 = Unit.INSTANCE;     // Catch: Exception -> L7
        return;
    L7:
        e = move-exception;
        ToolsExtKt.printLog(Intrinsics.stringPlus("Try exception occur ", e.getMessage()));
        Unit r3 = Unit.INSTANCE;
    }

    @Override // androidx.fragment.app.DialogFragment
    public void dismissAllowingStateLoss() {
        exeExitAnim();
        super.dismissAllowingStateLoss();
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface r2) {
        Intrinsics.checkNotNullParameter(r2, "dialog");
        super.onDismiss(r2);
        DialogInterface.OnDismissListener r1 = this.onDismissListener;
        if (r1 == null) goto L7;
        r1.onDismiss(r2);
        return;
    }

    public final int getBgColor() {
        Dialog r1 = getDialog();
        if ((r1 instanceof OBasePanelDialog) == false) goto L5;
        OBasePanelDialog r2 = (OBasePanelDialog) r1;
    L6:
        if (r2 != null) goto L9;
        return 0;
    L9:
        return r2.getBgColor();
    L5:
        r2 = null;
        goto L6
    }

    private final boolean tryDismissWithAnimation(boolean r4) {
        Dialog r0 = getDialog();
        if ((r0 instanceof BottomSheetDialog) == false) goto L10;
        BottomSheetDialog r1 = (BottomSheetDialog) r0;
        BottomSheetBehavior<FrameLayout> r2 = r1.getBehavior();
        Intrinsics.checkNotNullExpressionValue(r2, "dialog.behavior");
        if (r2.isHideable() == true) goto L7;
        return false;
    L7:
        if (r1.getDismissWithAnimation() == false) goto L13;
        dismissWithAnimation(r2, r4);
        return true;
    L13:
        return false;
    L10:
        return false;
    }

    private final void dismissWithAnimation(BottomSheetBehavior<?> r2, boolean r3) {
        this.waitingForDismissAllowingStateLoss = r3;
        if (r2.getState() != 5) goto L6;
        dismissAfterAnimation();
        return;
    L6:
        if ((getDialog() instanceof BottomSheetDialog) == false) goto L15;
        BottomSheetDialog r4 = (BottomSheetDialog) getDialog();
        if (r4 == null) goto L11;
        r4.removeDefaultCallback();
    L11:
        BottomSheetDialog r5 = (BottomSheetDialog) getDialog();
        if (r5 == null) goto L15;
        r5.clearBottomSheetCallback();
    L15:
        r2.addBottomSheetCallback(this.bottomSheetDismissCallback);
        r2.setState(5);
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

    private final void dispatchAnimProgress(float r2, boolean r3) {
        List<? extends BottomSheetBehavior.BottomSheetCallback> r1 = this.bottomSheetCallbacks;
        if (r1 == null) goto L12;
        Iterator<T> r4 = r1.iterator();
    L7:
        if (r4.hasNext() == false) goto L19;
        BottomSheetBehavior.BottomSheetCallback r0 = (BottomSheetBehavior.BottomSheetCallback) r4.next();
        if (r3 == true) goto L10;
        r0.onEnterInProgressUpdate(r2);
        goto L7
    L10:
        r0.onExitOutProgressUpdate(r2);
        goto L7
    L19:
        return;
    }
}
