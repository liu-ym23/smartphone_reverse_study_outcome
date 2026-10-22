package com.obric.oui.dialog.base;

import android.animation.ValueAnimator;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.ColorStateList;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Looper;
import android.util.Size;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.WindowInsets;
import android.view.WindowManager;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageView;
import androidx.core.content.ContextCompat;
import com.obric.common.oea.foundation.animation.builder.ValueAnimatable;
import com.obric.common.oea.foundation.animation.manager.AnimationManager;
import com.obric.common.oea.foundation.animation.spec.AnimationSpecKt;
import com.obric.common.oea.foundation.animation.spec.spring.FloatSpringSpec;
import com.obric.common.oea.foundation.animation.token.Token;
import com.obric.common.oui.R;
import com.obric.oui.color.OPalette;
import com.obric.oui.color.StrokeConfig;
import com.obric.oui.common.util.OUnitExtensionKt;
import com.obric.oui.common.util.ViewExtensionsKt;
import com.obric.oui.dialog.alert.view.RadiusLayout;
import com.obric.oui.dialog.anim.DialogAnimStyle;
import com.obric.oui.material.MaterialConfig;
import com.obric.oui.material.MaterialToken;
import com.obric.oui.material.OMaterialExtBaseKt;
import com.obric.oui.material.OMaterialHelper;
import com.obric.oui.utils.KtExt;
import com.obric.oui.utils.ViewUtilKt;
import com.obric.oui.utils.log.L;
import com.obric.oui.window.OWindowConfigController;
import com.ttnet.org.chromium.base.BaseSwitches;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import obric.widget.calendar.MonthWeekEventsView;

/* JADX INFO: compiled from: AbstractDialog.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u008b\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0015\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b)*\u0001-\b&\u0018\u0000 \u009b\u00012\u00020\u0001:\u0006\u009a\u0001\u009b\u0001\u009c\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005¢\u0006\u0002\u0010\u0007J\u0006\u0010\u000b\u001a\u00020[J\u0010\u0010\\\u001a\u00020[2\u0006\u0010]\u001a\u00020\u0011H\u0004J-\u0010^\u001a\u00020[2\u0006\u0010_\u001a\u00020\u001b2\n\b\u0002\u0010`\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010a\u001a\u0004\u0018\u00010\u0011H\u0007¢\u0006\u0002\u0010bJ\b\u0010c\u001a\u00020[H\u0002J\b\u0010d\u001a\u00020[H\u0002J\b\u0010e\u001a\u00020[H\u0002J\u0010\u0010f\u001a\u00020[2\u0006\u0010g\u001a\u00020\u0005H\u0002J\b\u0010h\u001a\u00020[H\u0002J\b\u0010i\u001a\u00020[H\u0016J\u0018\u0010j\u001a\u00020[2\u0006\u0010k\u001a\u00020\u00182\u0006\u0010g\u001a\u00020\u0005H\u0002J\u0006\u0010l\u001a\u00020[J\n\u0010m\u001a\u0004\u0018\u00010\u0018H\u0014J\b\u0010n\u001a\u00020\u0011H&J\b\u0010o\u001a\u00020\u0011H\u0002J\u0010\u0010p\u001a\u00020q2\u0006\u0010\u0002\u001a\u00020\u0003H\u0004J\u0012\u0010r\u001a\u00020[2\b\u0010s\u001a\u0004\u0018\u00010tH\u0002J\u0006\u0010u\u001a\u00020\u0005J\u0006\u0010v\u001a\u00020\u0005J\b\u0010w\u001a\u00020[H\u0014J\u0010\u0010x\u001a\u00020[2\u0006\u0010y\u001a\u00020JH\u0002J\b\u0010z\u001a\u00020[H\u0002J\u0010\u0010{\u001a\u00020[2\u0006\u0010y\u001a\u00020JH\u0002J\u000e\u0010|\u001a\u00020[2\u0006\u0010}\u001a\u00020\u0005J\u001c\u0010~\u001a\u00020[2\u0006\u0010}\u001a\u00020\u00052\n\b\u0002\u0010\u007f\u001a\u0004\u0018\u00010GH\u0016J\u001a\u0010\u0080\u0001\u001a\u00020[2\u0006\u0010k\u001a\u00020\u00182\u0007\u0010\u0081\u0001\u001a\u00020\u0011H\u0002J\u0018\u0010\u0082\u0001\u001a\u00020\u00002\t\u0010\u0083\u0001\u001a\u0004\u0018\u00010\u0005¢\u0006\u0003\u0010\u0084\u0001J\t\u0010\u0085\u0001\u001a\u00020[H\u0002J\u000f\u0010\u0086\u0001\u001a\u00020[2\u0006\u0010}\u001a\u00020\u0005J\u0010\u0010\u0087\u0001\u001a\u00020\u00002\u0007\u0010\u0088\u0001\u001a\u00020\u0011J\u0010\u0010\u0089\u0001\u001a\u00020\u00002\u0007\u0010\u008a\u0001\u001a\u00020\u0011J\u001d\u0010\u008b\u0001\u001a\u00020\u00002\t\b\u0002\u0010\u008c\u0001\u001a\u00020\u00112\t\b\u0002\u0010\u008d\u0001\u001a\u00020\u0011J\u001d\u0010\u008e\u0001\u001a\u00020\u00002\t\b\u0002\u0010\u008f\u0001\u001a\u00020\u00112\t\b\u0002\u0010\u0090\u0001\u001a\u00020\u0011J\t\u0010\u0091\u0001\u001a\u00020[H\u0002J\t\u0010\u0092\u0001\u001a\u00020[H\u0017J#\u0010\u0093\u0001\u001a\u00020[2\u0006\u0010k\u001a\u00020\u00182\u0007\u0010\u0094\u0001\u001a\u00020\u00112\u0007\u0010\u0095\u0001\u001a\u00020\u0011H\u0002J\u001a\u0010\u0096\u0001\u001a\u00020[2\u0006\u0010k\u001a\u00020\u00182\u0007\u0010\u0097\u0001\u001a\u00020\u0005H\u0014J\u001a\u0010\u0098\u0001\u001a\u00020[2\u0006\u0010k\u001a\u00020\u00182\u0007\u0010\u0097\u0001\u001a\u00020\u0005H\u0002J\r\u0010\u0099\u0001\u001a\u00020\u0011*\u00020tH\u0014R\u0010\u0010\b\u001a\u00020\tX\u0082D¢\u0006\u0004\n\u0002\b\nR\u001a\u0010\u000b\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u001a\u0010\"\u001a\u00020\u0018X\u0084.¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u0010\u0010'\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010*\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0004\n\u0002\u0010+R\u0010\u0010,\u001a\u00020-X\u0082\u0004¢\u0006\u0004\n\u0002\u0010.R\u000e\u0010/\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00100\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00101\u001a\u0004\u0018\u000102X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00103\u001a\u000204X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u00105\u001a\u0004\u0018\u000106X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u00107\u001a\u00020\u0005X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b8\u0010\r\"\u0004\b9\u0010\u000fR\u0012\u0010:\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0004\n\u0002\u0010;R\u001a\u0010<\u001a\u00020\u0011X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b=\u0010>\"\u0004\b?\u0010@R\u0012\u0010A\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0004\n\u0002\u0010+R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\bB\u0010\rR\u001a\u0010C\u001a\u00020\u0011X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bD\u0010>\"\u0004\bE\u0010@R\u0010\u0010F\u001a\u0004\u0018\u00010GX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010H\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010I\u001a\u0004\u0018\u00010JX\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010K\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0004\n\u0002\u0010+R\u001a\u0010L\u001a\u00020\u0018X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\bM\u0010$\"\u0004\bN\u0010&R\u001a\u0010O\u001a\u00020\u0005X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bP\u0010\r\"\u0004\bQ\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\bR\u0010\rR\u000e\u0010S\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010T\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010U\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010V\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010W\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0004\n\u0002\u0010+R\u0012\u0010X\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0004\n\u0002\u0010+R\u0010\u0010Y\u001a\u0004\u0018\u00010ZX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u009d\u0001"}, d2 = {"Lcom/obric/oui/dialog/base/AbstractDialog;", "Landroid/app/Dialog;", "context", "Landroid/content/Context;", "widthMatch", "", "matchParentHeight", "(Landroid/content/Context;ZZ)V", "TAG", "", "TAG$1", "adaptWindowDim", "getAdaptWindowDim", "()Z", "setAdaptWindowDim", "(Z)V", "animExpectedHeight", "", "autoDismissOnButtonClick", "bgColor", "cancelRestoreToWrapOnCancel", "closeIcon", "Landroid/widget/ImageView;", "closeIconContainer", "Landroid/view/View;", "closeIconEnabled", "closeIconStyle", "Lcom/obric/oui/dialog/base/AbstractDialog$CloseIconStyle;", "completeShowListener", "Landroid/content/DialogInterface$OnShowListener;", "getCompleteShowListener", "()Landroid/content/DialogInterface$OnShowListener;", "setCompleteShowListener", "(Landroid/content/DialogInterface$OnShowListener;)V", "contentRootView", "getContentRootView", "()Landroid/view/View;", "setContentRootView", "(Landroid/view/View;)V", "currentAnimContainer", "enableLayoutHeightChangeAnim", "enableMaterial", "fixedWindowHeightPx", "Ljava/lang/Integer;", "handler", "com/obric/oui/dialog/base/AbstractDialog$handler$1", "Lcom/obric/oui/dialog/base/AbstractDialog$handler$1;", "heightAnimProgrammaticChange", "heightAnimRunning", "heightAnimator", "Lcom/obric/common/oea/foundation/animation/manager/AnimationManager;", "heightLayoutChangeListener", "Landroid/view/View$OnLayoutChangeListener;", "heightPreDrawListener", "Landroid/view/ViewTreeObserver$OnPreDrawListener;", "hideFirstFrame", "getHideFirstFrame", "setHideFirstFrame", "includeCutoutInLandscape", "Ljava/lang/Boolean;", "insetsBaseYOffsetPx", "getInsetsBaseYOffsetPx", "()I", "setInsetsBaseYOffsetPx", "(I)V", "lastAppliedWindowYPx", "getMatchParentHeight", "maxRootViewHeightGap", "getMaxRootViewHeightGap", "setMaxRootViewHeightGap", "onCloseClickListener", "Landroid/view/View$OnClickListener;", "pendingApplyWindowPosition", "pendingHeightChange", "Lcom/obric/oui/dialog/base/AbstractDialog$HeightChange;", "pendingTargetHeightWhileAnimating", "rootView", "getRootView", "setRootView", "showAnimRunning", "getShowAnimRunning", "setShowAnimRunning", "getWidthMatch", "windowGravity", "windowLockedMinHeightPx", "windowOffsetXPx", "windowOffsetYPx", "windowYAnimCurrentPx", "windowYAnimTargetPx", "windowYAnimator", "Landroid/animation/ValueAnimator;", "", "animateWindowYTo", "targetYPx", "applyCloseIconStyle", "style", "customIconColor", "customIconBgColor", "(Lcom/obric/oui/dialog/base/AbstractDialog$CloseIconStyle;Ljava/lang/Integer;Ljava/lang/Integer;)V", "applyWindowGravityAndXIfNeeded", "applyWindowHeightIfNeeded", "applyWindowPositionIfNeeded", "cancelHeightAnimatorIfNeeded", "restoreToWrapContent", "cleanupRootHeightAnim", "dismiss", "finishHeightAnim", "container", "forceHideFirstFrame", "getHeightChangeAnimContainer", "getLayout", "getLayoutMarginBottom", "getTargetWindowDimAmount", "", "hideAndTransparentNavigationBar", "window", "Landroid/view/Window;", "isAutoDismiss", "isDarkTheme", "onStop", "prepareAndStartHeightAnim", "change", "recheckInset", "scheduleHeightAnim", "setAutoDismiss", "enabled", "setCloseIconEnabled", "listener", "setContainerFixedHeight", MonthWeekEventsView.VIEW_PARAMS_HEIGHT, "setIncludeCutoutInLandscape", "include", "(Ljava/lang/Boolean;)Lcom/obric/oui/dialog/base/AbstractDialog;", "setOnApplyWindowInsetsListener", "setRootHeightChangeAnimEnabled", "setWindowFixedHeight", "heightPx", "setWindowGravity", "gravity", "setWindowOffset", "xPx", "yPx", "setWindowOffsetDp", "xDp", "yDp", "setupRootHeightChangeAnimIfNeeded", "show", "startHeightAnimator", "fromHeight", "toHeight", "suppressHeightAnimContainerChildren", "suppress", "suppressInternalLayout", "getLayoutMarginHorizontal", "CloseIconStyle", "Companion", "HeightChange", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public abstract class AbstractDialog extends Dialog {
    public static final Companion Companion = null;
    public static final int HORIZONTAL_MAX_HEIGHT = 300;
    public static final int HORIZONTAL_MAX_WIDTH = 440;
    public static final int HORIZONTAL_TOP_SYSBAR_HEIGHT = 156;
    public static final int MSG_RECHECK_INSET = 101;
    public static final String TAG = "AbstractDialog";
    private final String TAG$1;
    private boolean adaptWindowDim;
    private int animExpectedHeight;
    private boolean autoDismissOnButtonClick;
    private int bgColor;
    private boolean cancelRestoreToWrapOnCancel;
    private ImageView closeIcon;
    private View closeIconContainer;
    private boolean closeIconEnabled;
    private CloseIconStyle closeIconStyle;
    private DialogInterface.OnShowListener completeShowListener;
    protected View contentRootView;
    private View currentAnimContainer;
    private boolean enableLayoutHeightChangeAnim;
    private boolean enableMaterial;
    private Integer fixedWindowHeightPx;
    private final AbstractDialog$handler$1 handler;
    private boolean heightAnimProgrammaticChange;
    private boolean heightAnimRunning;
    private AnimationManager heightAnimator;
    private final View.OnLayoutChangeListener heightLayoutChangeListener;
    private ViewTreeObserver.OnPreDrawListener heightPreDrawListener;
    private boolean hideFirstFrame;
    private Boolean includeCutoutInLandscape;
    private int insetsBaseYOffsetPx;
    private Integer lastAppliedWindowYPx;
    private final boolean matchParentHeight;
    private int maxRootViewHeightGap;
    private View.OnClickListener onCloseClickListener;
    private boolean pendingApplyWindowPosition;
    private HeightChange pendingHeightChange;
    private Integer pendingTargetHeightWhileAnimating;
    public View rootView;
    private boolean showAnimRunning;
    private final boolean widthMatch;
    private int windowGravity;
    private int windowLockedMinHeightPx;
    private int windowOffsetXPx;
    private int windowOffsetYPx;
    private Integer windowYAnimCurrentPx;
    private Integer windowYAnimTargetPx;
    private ValueAnimator windowYAnimator;

    /* JADX INFO: compiled from: AbstractDialog.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/obric/oui/dialog/base/AbstractDialog$CloseIconStyle;", "", "(Ljava/lang/String;I)V", "LIGHT", "DARK", "CUSTOM", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final enum CloseIconStyle extends Enum<CloseIconStyle> {
        private static final /* synthetic */ CloseIconStyle[] $VALUES = null;
        public static final CloseIconStyle CUSTOM = null;
        public static final CloseIconStyle DARK = null;
        public static final CloseIconStyle LIGHT = null;

        private static final /* synthetic */ CloseIconStyle[] $values() {
            return new CloseIconStyle[]{LIGHT, DARK, CUSTOM};
        }

        public static CloseIconStyle valueOf(String r1) {
            return (CloseIconStyle) Enum.valueOf(CloseIconStyle.class, r1);
        }

        public static CloseIconStyle[] values() {
            return (CloseIconStyle[]) $VALUES.clone();
        }

        private CloseIconStyle(String r1, int r2) {
            super(r1, r2);
        }

        static {
            LIGHT = new CloseIconStyle("LIGHT", 0);
            DARK = new CloseIconStyle("DARK", 1);
            CUSTOM = new CloseIconStyle("CUSTOM", 2);
            $VALUES = $values();
        }
    }

    /* JADX INFO: compiled from: AbstractDialog.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/obric/oui/dialog/base/AbstractDialog$Companion;", "", "()V", "HORIZONTAL_MAX_HEIGHT", "", "HORIZONTAL_MAX_WIDTH", "HORIZONTAL_TOP_SYSBAR_HEIGHT", "MSG_RECHECK_INSET", "TAG", "", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: AbstractDialog.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0005¢\u0006\u0002\u0010\tJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÆ\u0003J;\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u0005HÖ\u0001J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\r¨\u0006\u001d"}, d2 = {"Lcom/obric/oui/dialog/base/AbstractDialog$HeightChange;", "", "container", "Landroid/view/View;", "fromHeight", "", "toHeight", "rootFromHeight", "rootToHeight", "(Landroid/view/View;IIII)V", "getContainer", "()Landroid/view/View;", "getFromHeight", "()I", "getRootFromHeight", "getRootToHeight", "getToHeight", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "toString", "", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    private static final class HeightChange {
        private final View container;
        private final int fromHeight;
        private final int rootFromHeight;
        private final int rootToHeight;
        private final int toHeight;

        public static /* synthetic */ HeightChange copy$default(HeightChange r3, View r4, int r5, int r6, int r7, int r8, int r9, Object r10) {
            if ((r9 & 1) == 0) goto L6;
            r4 = r3.container;
        L6:
            if ((r9 & 2) == 0) goto L8;
            r5 = r3.fromHeight;
        L8:
            int r11 = r5;
            if ((r9 & 4) == 0) goto L11;
            r6 = r3.toHeight;
        L11:
            int r0 = r6;
            if ((r9 & 8) == 0) goto L14;
            r7 = r3.rootFromHeight;
        L14:
            int r1 = r7;
            if ((r9 & 16) == 0) goto L17;
            r8 = r3.rootToHeight;
        L17:
            View r12 = r4;
            return r3.copy(r12, r11, r0, r1, r8);
        }

        public final View component1() {
            return this.container;
        }

        public final int component2() {
            return this.fromHeight;
        }

        public final int component3() {
            return this.toHeight;
        }

        public final int component4() {
            return this.rootFromHeight;
        }

        public final int component5() {
            return this.rootToHeight;
        }

        public final HeightChange copy(View r7, int r8, int r9, int r10, int r11) {
            Intrinsics.checkNotNullParameter(r7, "container");
            return new HeightChange(r7, r8, r9, r10, r11);
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof HeightChange) == true) goto L8;
            return false;
        L8:
            HeightChange r6 = (HeightChange) r5;
            if (Intrinsics.areEqual(this.container, r6.container) == true) goto L12;
            return false;
        L12:
            if (this.fromHeight == r6.fromHeight) goto L15;
            return false;
        L15:
            if (this.toHeight == r6.toHeight) goto L18;
            return false;
        L18:
            if (this.rootFromHeight == r6.rootFromHeight) goto L21;
            return false;
        L21:
            if (this.rootToHeight == r6.rootToHeight) goto L23;
            return false;
        L23:
            return true;
        }

        public int hashCode() {
            return (((((((this.container.hashCode() * 31) + Integer.hashCode(this.fromHeight)) * 31) + Integer.hashCode(this.toHeight)) * 31) + Integer.hashCode(this.rootFromHeight)) * 31) + Integer.hashCode(this.rootToHeight);
        }

        public String toString() {
            return "HeightChange(container=" + this.container + ", fromHeight=" + this.fromHeight + ", toHeight=" + this.toHeight + ", rootFromHeight=" + this.rootFromHeight + ", rootToHeight=" + this.rootToHeight + ')';
        }

        public HeightChange(View r2, int r3, int r4, int r5, int r6) {
            Intrinsics.checkNotNullParameter(r2, "container");
            this.container = r2;
            this.fromHeight = r3;
            this.toHeight = r4;
            this.rootFromHeight = r5;
            this.rootToHeight = r6;
        }

        public final View getContainer() {
            return this.container;
        }

        public final int getFromHeight() {
            return this.fromHeight;
        }

        public final int getToHeight() {
            return this.toHeight;
        }

        public final int getRootFromHeight() {
            return this.rootFromHeight;
        }

        public final int getRootToHeight() {
            return this.rootToHeight;
        }
    }

    /* JADX INFO: compiled from: AbstractDialog.kt */
    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

        static {
            int[] r0 = new int[CloseIconStyle.values().length];
            r0[CloseIconStyle.DARK.ordinal()] = 1;
            r0[CloseIconStyle.LIGHT.ordinal()] = 2;
            r0[CloseIconStyle.CUSTOM.ordinal()] = 3;
            $EnumSwitchMapping$0 = r0;
        }
    }

    public static /* synthetic */ void $r8$lambda$FC_wBu57uHUt7I3lwhFDKDQQHo4(AbstractDialog r0, HeightChange r1) {
        m464prepareAndStartHeightAnim$lambda8(r0, r1);
    }

    public static /* synthetic */ WindowInsets $r8$lambda$G8aYcH9rfOyaVhmLlQqfcB0fDqI(AbstractDialog r0, View r1, WindowInsets r2) {
        return m467setOnApplyWindowInsetsListener$lambda14(r0, r1, r2);
    }

    public static /* synthetic */ boolean $r8$lambda$N_zJa5oKUfNK93163iiB786_tds(AbstractDialog r0) {
        return m465scheduleHeightAnim$lambda6(r0);
    }

    public static /* synthetic */ void $r8$lambda$O9siTZRhbW62MSbv9FyShMEwoSU(AbstractDialog r0, View r1) {
        m466setCloseIconEnabled$lambda16$lambda15(r0, r1);
    }

    public static /* synthetic */ void $r8$lambda$P9PyEMoTBUNID1OcSz1uGCoZDR8(AbstractDialog r0, View r1, int r2, int r3, int r4, int r5, int r6, int r7, int r8, int r9) {
        m463heightLayoutChangeListener$lambda5(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9);
    }

    public static /* synthetic */ void $r8$lambda$Ue_AlP6IVMpY2y_hohCuQwqLjMU(Window r0, AbstractDialog r1, ValueAnimator r2, ValueAnimator r3) {
        m462animateWindowYTo$lambda4$lambda3(r0, r1, r2, r3);
    }

    static {
        Companion = new Companion(null);
    }

    public final void applyCloseIconStyle(CloseIconStyle r8) {
        Intrinsics.checkNotNullParameter(r8, "style");
        applyCloseIconStyle$default(this, r8, null, null, 6, null);
    }

    public final void applyCloseIconStyle(CloseIconStyle r8, Integer r9) {
        Intrinsics.checkNotNullParameter(r8, "style");
        applyCloseIconStyle$default(this, r8, r9, null, 4, null);
    }

    protected View getHeightChangeAnimContainer() {
        return null;
    }

    public abstract int getLayout();

    public /* synthetic */ AbstractDialog(Context r2, boolean r3, boolean r4, int r5, DefaultConstructorMarker r6) {
        if ((r5 & 2) == 0) goto L6;
        r3 = false;
    L6:
        if ((r5 & 4) == 0) goto L8;
        r4 = false;
    L8:
        this(r2, r3, r4);
    }

    public static final /* synthetic */ void access$finishHeightAnim(AbstractDialog r0, View r1, boolean r2) {
        r0.finishHeightAnim(r1, r2);
    }

    public static final /* synthetic */ int access$getAnimExpectedHeight$p(AbstractDialog r0) {
        return r0.animExpectedHeight;
    }

    public static final /* synthetic */ boolean access$getCancelRestoreToWrapOnCancel$p(AbstractDialog r0) {
        return r0.cancelRestoreToWrapOnCancel;
    }

    public static final /* synthetic */ Integer access$getPendingTargetHeightWhileAnimating$p(AbstractDialog r0) {
        return r0.pendingTargetHeightWhileAnimating;
    }

    public static final /* synthetic */ int access$getWindowGravity$p(AbstractDialog r0) {
        return r0.windowGravity;
    }

    public static final /* synthetic */ int access$getWindowOffsetXPx$p(AbstractDialog r0) {
        return r0.windowOffsetXPx;
    }

    public static final /* synthetic */ int access$getWindowOffsetYPx$p(AbstractDialog r0) {
        return r0.windowOffsetYPx;
    }

    public static final /* synthetic */ void access$recheckInset(AbstractDialog r0) {
        r0.recheckInset();
    }

    public static final /* synthetic */ void access$setAnimExpectedHeight$p(AbstractDialog r0, int r1) {
        r0.animExpectedHeight = r1;
    }

    public static final /* synthetic */ void access$setContainerFixedHeight(AbstractDialog r0, View r1, int r2) {
        r0.setContainerFixedHeight(r1, r2);
    }

    public static final /* synthetic */ void access$setLastAppliedWindowYPx$p(AbstractDialog r0, Integer r1) {
        r0.lastAppliedWindowYPx = r1;
    }

    public static final /* synthetic */ void access$setPendingTargetHeightWhileAnimating$p(AbstractDialog r0, Integer r1) {
        r0.pendingTargetHeightWhileAnimating = r1;
    }

    public static final /* synthetic */ void access$setWindowYAnimCurrentPx$p(AbstractDialog r0, Integer r1) {
        r0.windowYAnimCurrentPx = r1;
    }

    public static final /* synthetic */ void access$setWindowYAnimTargetPx$p(AbstractDialog r0, Integer r1) {
        r0.windowYAnimTargetPx = r1;
    }

    public static final /* synthetic */ void access$setWindowYAnimator$p(AbstractDialog r0, ValueAnimator r1) {
        r0.windowYAnimator = r1;
    }

    public static final /* synthetic */ void access$startHeightAnimator(AbstractDialog r0, View r1, int r2, int r3) {
        r0.startHeightAnimator(r1, r2, r3);
    }

    public final boolean getWidthMatch() {
        return this.widthMatch;
    }

    public final boolean getMatchParentHeight() {
        return this.matchParentHeight;
    }

    /* JADX WARN: Type inference failed for: r11v4, types: [com.obric.oui.dialog.base.AbstractDialog$handler$1] */
    public AbstractDialog(Context r10, boolean r11, boolean r12) {
        Intrinsics.checkNotNullParameter(r10, "context");
        super(r10);
        this.widthMatch = r11;
        this.matchParentHeight = r12;
        this.TAG$1 = TAG;
        this.closeIconStyle = CloseIconStyle.DARK;
        this.autoDismissOnButtonClick = true;
        this.maxRootViewHeightGap = -1;
        this.animExpectedHeight = -1;
        this.cancelRestoreToWrapOnCancel = true;
        this.windowGravity = 81;
        Window r1 = getWindow();
        if (r1 == null) goto L6;
        r1.requestFeature(1);
    L6:
        Window r2 = getWindow();
        if (r2 == null) goto L10;
        r2.addFlags(512);
    L10:
        if (r12 == false) goto L12;
        setContentView(R.layout.o_base_dialog_with_match_parent_height);
    L13:
        View r3 = findViewById(R.id.root_view);
        Intrinsics.checkNotNullExpressionValue(r3, "findViewById(R.id.root_view)");
        setRootView(r3);
        if ((getRootView().getBackground() instanceof ColorDrawable) == false) goto L21;
        Drawable r4 = getRootView().getBackground();
        if (r4 == null) goto L19;
        this.bgColor = ((ColorDrawable) r4).getColor();
    L32:
        getRootView().setAlpha(0.0f);
        this.closeIcon = (ImageView) findViewById(R.id.btn_close);
        this.closeIconContainer = findViewById(R.id.close_container);
        if (r12 == false) goto L35;
        View r13 = getRootView();
        ViewGroup.LayoutParams r5 = getRootView().getLayoutParams();
        r5.height = -1;
        r13.setLayoutParams(r5);
    L35:
        setCloseIconEnabled$default(this, this.closeIconEnabled, null, 2, null);
        ViewStub r14 = (ViewStub) findViewById(R.id.contentView);
        r14.setLayoutResource(getLayout());
        View r15 = r14.inflate();
        Intrinsics.checkNotNullExpressionValue(r15, "viewStub.inflate()");
        setContentRootView(r15);
        DialogAnimStyle.INSTANCE.adjustDialogTopSpace(getRootView());
        if (OMaterialExtBaseKt.isMaterialEffectEnabled(r10) == true) goto L38;
    L40:
        boolean r16 = false;
    L41:
        this.enableMaterial = r16;
        if (r16 == false) goto L53;
        getRootView().setBackgroundColor(0);
        MaterialConfig[] r17 = MaterialToken.OUI_Bg_Modal.invoke(Boolean.valueOf(!ViewUtilKt.isDarkMode(getRootView())));
        OMaterialExtBaseKt.materialsFromWindow$default(getRootView(), r17, false, null, 6, null);
        if (OMaterialHelper.getMaterialLevel(r10) != 1) goto L46;
    L47:
        StrokeConfig r18 = r17[0].getStroke();
        if (r18 == null) goto L53;
        if ((getRootView() instanceof DialogRootView) == false) goto L53;
        ((DialogRootView) getRootView()).setStroke(r18.getColor(), OUnitExtensionKt.cdp(r10, r18.getWidth()));
        goto L53
    L46:
        if (r17.length == 1) goto L47;
    L53:
        this.heightLayoutChangeListener = new AbstractDialog$$ExternalSyntheticLambda0(this);
        final Looper r19 = Looper.getMainLooper();
        this.handler = new AbstractDialog$handler$1(this, r19);
        return;
    L38:
        if (OMaterialHelper.isWidgetMaterialEffectEnabled() == false) goto L40;
        r16 = true;
        goto L41
    L19:
        throw new NullPointerException("null cannot be cast to non-null type android.graphics.drawable.ColorDrawable");
    L21:
        if ((getRootView().getBackground() instanceof GradientDrawable) == false) goto L31;
        Drawable r6 = getRootView().getBackground();
        if (r6 == null) goto L30;
        ColorStateList r7 = ((GradientDrawable) r6).getColor();
        if (r7 != null) goto L27;
        int r8 = 0;
    L28:
        this.bgColor = r8;
        goto L32
    L27:
        r8 = r7.getDefaultColor();
        goto L28
    L30:
        throw new NullPointerException("null cannot be cast to non-null type android.graphics.drawable.GradientDrawable");
    L31:
        this.bgColor = 0;
        goto L32
    L12:
        setContentView(R.layout.o_base_dialog);
        goto L13
    }

    public final View getRootView() {
        View r0 = this.rootView;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("rootView");
        return null;
    }

    public final void setRootView(View r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.rootView = r2;
    }

    protected final View getContentRootView() {
        View r0 = this.contentRootView;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("contentRootView");
        return null;
    }

    protected final void setContentRootView(View r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.contentRootView = r2;
    }

    protected final boolean getHideFirstFrame() {
        return this.hideFirstFrame;
    }

    protected final void setHideFirstFrame(boolean r1) {
        this.hideFirstFrame = r1;
    }

    public final boolean getAdaptWindowDim() {
        return this.adaptWindowDim;
    }

    public final void setAdaptWindowDim(boolean r1) {
        this.adaptWindowDim = r1;
    }

    protected final int getMaxRootViewHeightGap() {
        return this.maxRootViewHeightGap;
    }

    protected final void setMaxRootViewHeightGap(int r1) {
        this.maxRootViewHeightGap = r1;
    }

    protected final boolean getShowAnimRunning() {
        return this.showAnimRunning;
    }

    protected final void setShowAnimRunning(boolean r1) {
        this.showAnimRunning = r1;
    }

    public final DialogInterface.OnShowListener getCompleteShowListener() {
        return this.completeShowListener;
    }

    public final void setCompleteShowListener(DialogInterface.OnShowListener r1) {
        this.completeShowListener = r1;
    }

    protected final int getInsetsBaseYOffsetPx() {
        return this.insetsBaseYOffsetPx;
    }

    protected final void setInsetsBaseYOffsetPx(int r1) {
        this.insetsBaseYOffsetPx = r1;
    }

    public final boolean isDarkTheme() {
        int r0 = this.bgColor;
        if (r0 != 0) goto L7;
        return ViewUtilKt.isDarkMode(getRootView());
    L7:
        return OPalette.isDarkColor(r0);
    }

    public final void setRootHeightChangeAnimEnabled(boolean r1) {
        this.enableLayoutHeightChangeAnim = r1;
        if (r1 == true) goto L6;
        cleanupRootHeightAnim();
        return;
    }

    public final AbstractDialog setWindowFixedHeight(int r2) {
        Integer r3 = Integer.valueOf(r2);
        if (r3.intValue() <= 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == true) goto L9;
        r3 = null;
    L9:
        this.fixedWindowHeightPx = r3;
        applyWindowHeightIfNeeded();
        return this;
    L5:
        r0 = false;
        goto L6
    }

    public final AbstractDialog setWindowGravity(int r1) {
        this.windowGravity = r1;
        applyWindowPositionIfNeeded();
        return this;
    }

    public static /* synthetic */ AbstractDialog setWindowOffset$default(AbstractDialog r1, int r2, int r3, int r4, Object r5) {
        if (r5 != null) goto L12;
        if ((r4 & 1) == 0) goto L7;
        r2 = 0;
    L7:
        if ((r4 & 2) == 0) goto L10;
        r3 = 0;
    L10:
        return r1.setWindowOffset(r2, r3);
    L12:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setWindowOffset");
    }

    public final AbstractDialog setWindowOffset(int r1, int r2) {
        this.windowOffsetXPx = r1;
        this.windowOffsetYPx = r2;
        applyWindowPositionIfNeeded();
        return this;
    }

    public static /* synthetic */ AbstractDialog setWindowOffsetDp$default(AbstractDialog r1, int r2, int r3, int r4, Object r5) {
        if (r5 != null) goto L12;
        if ((r4 & 1) == 0) goto L7;
        r2 = 0;
    L7:
        if ((r4 & 2) == 0) goto L10;
        r3 = 0;
    L10:
        return r1.setWindowOffsetDp(r2, r3);
    L12:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setWindowOffsetDp");
    }

    public final AbstractDialog setWindowOffsetDp(int r3, int r4) {
        Context r0 = getContext();
        Intrinsics.checkNotNullExpressionValue(r0, "context");
        int r5 = OUnitExtensionKt.cdp(r0, r3);
        Context r1 = getContext();
        Intrinsics.checkNotNullExpressionValue(r1, "context");
        return setWindowOffset(r5, OUnitExtensionKt.cdp(r1, r4));
    }

    public final AbstractDialog setIncludeCutoutInLandscape(Boolean r1) {
        this.includeCutoutInLandscape = r1;
        return this;
    }

    private final void applyWindowPositionIfNeeded() {
        final Window r0 = getWindow();
        if (r0 != null) goto L5;
        return;
    L5:
        new AbstractDialog$applyWindowPositionIfNeeded$apply$1(r0, this).invoke();
    }

    private final void applyWindowGravityAndXIfNeeded() {
        Window r0 = getWindow();
        if (r0 != null) goto L5;
        return;
    L5:
        WindowManager.LayoutParams r1 = r0.getAttributes();
        if (r1.gravity == this.windowGravity) goto L8;
    L10:
        r1.gravity = this.windowGravity;
        r1.x = this.windowOffsetXPx;
        r0.setAttributes(r1);
        return;
    L8:
        if (r1.x != this.windowOffsetXPx) goto L10;
    }

    protected final void animateWindowYTo(final int r6) {
        final Window r0 = getWindow();
        if (r0 != null) goto L6;
        return;
    L6:
        if (isShowing() == true) goto L9;
        this.pendingApplyWindowPosition = true;
        return;
    L9:
        Integer r1 = this.windowYAnimCurrentPx;
        if (r1 != null) goto L14;
        r1 = this.lastAppliedWindowYPx;
        if (r1 != null) goto L14;
        int r2 = r0.getAttributes().y;
    L15:
        if (r2 != r6) goto L24;
        ValueAnimator r3 = this.windowYAnimator;
        if (r3 == null) goto L20;
        r3.cancel();
    L20:
        this.windowYAnimator = null;
        this.windowYAnimTargetPx = null;
        this.windowYAnimCurrentPx = Integer.valueOf(r6);
        this.lastAppliedWindowYPx = Integer.valueOf(r6);
        WindowManager.LayoutParams r5 = r0.getAttributes();
        if (r5.y == r6) goto L46;
        r5.y = r6;
        r0.setAttributes(r5);
        return;
    L46:
        return;
    L24:
        ValueAnimator r4 = this.windowYAnimator;
        if (r4 != null) goto L28;
    L26:
        boolean r7 = false;
    L30:
        if (r7 == false) goto L37;
        Integer r8 = this.windowYAnimTargetPx;
        if (r8 == null) goto L37;
        if (r8.intValue() != r6) goto L37;
        return;
    L37:
        ValueAnimator r9 = this.windowYAnimator;
        if (r9 == null) goto L41;
        r9.cancel();
    L41:
        this.windowYAnimTargetPx = Integer.valueOf(r6);
        final ValueAnimator r10 = ValueAnimator.ofInt(new int[]{r2, r6});
        r10.setDuration(200);
        r10.setInterpolator(new DecelerateInterpolator(1.5f));
        r10.addUpdateListener(new AbstractDialog$$ExternalSyntheticLambda4(r0, this, r10));
        r10.addListener(new AbstractDialog$animateWindowYTo$1$2(this, r6));
        this.windowYAnimator = r10;
        if (r10 == null) goto L47;
        r10.start();
        return;
    L47:
        return;
    L28:
        if (r4.isRunning() != true) goto L26;
        r7 = true;
    L14:
        r2 = r1.intValue();
        goto L15
    }

    /* JADX INFO: renamed from: animateWindowYTo$lambda-4$lambda-3, reason: not valid java name */
    private static final void m462animateWindowYTo$lambda4$lambda3(Window r1, AbstractDialog r2, ValueAnimator r3, ValueAnimator r4) {
        Intrinsics.checkNotNullParameter(r1, "$w");
        Intrinsics.checkNotNullParameter(r2, "this$0");
        Intrinsics.checkNotNullParameter(r4, "it");
        if (r1.getDecorView().isAttachedToWindow() == false) goto L9;
        Object r5 = r4.getAnimatedValue();
        if (r5 == null) goto L8;
        int r6 = ((Integer) r5).intValue();
        r2.windowYAnimCurrentPx = Integer.valueOf(r6);
        WindowManager.LayoutParams r7 = r1.getAttributes();
        r7.y = r6;
        r1.setAttributes(r7);
        return;
    L8:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
    L9:
        r3.cancel();
    }

    private final void applyWindowHeightIfNeeded() {
        if (isShowing() == true) goto L6;
        return;
    L6:
        if (this.matchParentHeight == false) goto L8;
        return;
    L8:
        Window r0 = getWindow();
        if (r0 != null) goto L11;
        return;
    L11:
        WindowManager.LayoutParams r1 = r0.getAttributes();
        Integer r2 = this.fixedWindowHeightPx;
        if (r2 == null) goto L20;
        if (r2.intValue() <= 0) goto L20;
        if (r1.height == r2.intValue()) goto L25;
        r1.height = r2.intValue();
        r0.setAttributes(r1);
        return;
    L25:
        return;
    L20:
        if (this.windowLockedMinHeightPx <= 0) goto L26;
        int r3 = r1.height;
        int r4 = this.windowLockedMinHeightPx;
        if (r3 == r4) goto L27;
        r1.height = r4;
        r0.setAttributes(r1);
        return;
    L27:
        return;
    }

    protected void suppressHeightAnimContainerChildren(View r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r2, "container");
        ViewGroup r0 = null;
        if ((r2 instanceof RadiusLayout) == false) goto L5;
        RadiusLayout r1 = (RadiusLayout) r2;
    L6:
        if (r1 != null) goto L8;
        Unit r4 = null;
    L9:
        if (r4 == null) goto L11;
        return;
    L11:
        if ((r2 instanceof ViewGroup) == false) goto L13;
        r0 = (ViewGroup) r2;
    L13:
        if (r0 == null) goto L18;
        r0.suppressLayout(r3);
        return;
    L18:
        return;
    L8:
        r1.setSuppressChildMeasureAndLayout(r3);
        r4 = Unit.INSTANCE;
        goto L9
    L5:
        r1 = null;
        goto L6
    }

    /* JADX INFO: renamed from: heightLayoutChangeListener$lambda-5, reason: not valid java name */
    private static final void m463heightLayoutChangeListener$lambda5(AbstractDialog r0, View r1, int r2, int r3, int r4, int r5, int r6, int r7, int r8, int r9) {
        Intrinsics.checkNotNullParameter(r0, "this$0");
        if (r0.enableLayoutHeightChangeAnim == true) goto L6;
        return;
    L6:
        if (r0.matchParentHeight == false) goto L9;
        return;
    L9:
        if (r0.heightAnimProgrammaticChange == false) goto L11;
        return;
    L11:
        int r10 = r5 - r3;
        int r11 = r9 - r7;
        if (r10 <= 0) goto L30;
        if (r11 <= 0) goto L31;
        if (r10 == r11) goto L32;
        int r12 = r10 - r11;
        int r13 = r0.getRootView().getHeight();
        if (r13 <= 0) goto L19;
        int r14 = Math.max(1, r13 - r12);
    L21:
        if (r0.heightAnimRunning == false) goto L28;
        int r15 = r0.animExpectedHeight;
        if (r15 <= 0) goto L26;
        if (r10 != r15) goto L26;
        return;
    L26:
        r0.pendingTargetHeightWhileAnimating = Integer.valueOf(r10);
        return;
    L28:
        Intrinsics.checkNotNullExpressionValue(r1, BaseSwitches.V);
        r0.scheduleHeightAnim(new HeightChange(r1, r11, r10, r14, r13));
        return;
    L19:
        r14 = r13;
        goto L21
    L32:
        return;
    L31:
        return;
    }

    private final void setupRootHeightChangeAnimIfNeeded() {
        if (this.matchParentHeight == false) goto L5;
        return;
    L5:
        View r0 = getHeightChangeAnimContainer();
        if (r0 != null) goto L8;
        return;
    L8:
        r0.removeOnLayoutChangeListener(this.heightLayoutChangeListener);
        r0.addOnLayoutChangeListener(this.heightLayoutChangeListener);
    }

    private final void scheduleHeightAnim(HeightChange r2) {
        this.pendingHeightChange = r2;
        if (this.heightPreDrawListener != null) goto L5;
        this.heightPreDrawListener = new AbstractDialog$$ExternalSyntheticLambda1(this);
    L5:
        ViewTreeObserver.OnPreDrawListener r1 = this.heightPreDrawListener;
        if (r1 == null) goto L13;
        ViewTreeObserver r3 = r2.getContainer().getViewTreeObserver();
        if (r3.isAlive() == false) goto L12;
        r3.removeOnPreDrawListener(r1);
        r3.addOnPreDrawListener(r1);
        return;
    L12:
        return;
    }

    /* JADX INFO: renamed from: scheduleHeightAnim$lambda-6, reason: not valid java name */
    private static final boolean m465scheduleHeightAnim$lambda6(AbstractDialog r5) {
        Intrinsics.checkNotNullParameter(r5, "this$0");
        HeightChange r0 = r5.pendingHeightChange;
        r5.pendingHeightChange = null;
        if (r0 != null) goto L5;
        View r2 = null;
    L6:
        if (r2 != null) goto L8;
        r2 = r5.getHeightChangeAnimContainer();
    L8:
        if (r2 != null) goto L10;
        ViewTreeObserver r3 = null;
    L11:
        ViewTreeObserver.OnPreDrawListener r4 = r5.heightPreDrawListener;
        if (r4 == null) goto L17;
        if (r3 == null) goto L17;
        if (r3.isAlive() == false) goto L17;
        r3.removeOnPreDrawListener(r4);
    L17:
        r5.heightPreDrawListener = null;
        if (r0 != null) goto L21;
        return true;
    L21:
        if (r5.isShowing() == true) goto L23;
        return true;
    L23:
        r5.prepareAndStartHeightAnim(r0);
        return false;
    L10:
        r3 = r2.getViewTreeObserver();
        goto L11
    L5:
        r2 = r0.getContainer();
        goto L6
    }

    private final void prepareAndStartHeightAnim(final HeightChange r3) {
        if (r3.getFromHeight() > 0) goto L5;
        return;
    L5:
        if (r3.getToHeight() > 0) goto L7;
        return;
    L7:
        if (r3.getFromHeight() == r3.getToHeight()) goto L13;
        cancelHeightAnimatorIfNeeded(false);
        this.heightAnimRunning = true;
        this.animExpectedHeight = r3.getFromHeight();
        this.currentAnimContainer = r3.getContainer();
        suppressInternalLayout(r3.getContainer(), true);
        setContainerFixedHeight(r3.getContainer(), r3.getFromHeight());
        r3.getContainer().requestLayout();
        r3.getContainer().post(new AbstractDialog$$ExternalSyntheticLambda2(this, r3));
        return;
    }

    /* JADX INFO: renamed from: prepareAndStartHeightAnim$lambda-8, reason: not valid java name */
    private static final void m464prepareAndStartHeightAnim$lambda8(AbstractDialog r2, HeightChange r3) {
        Intrinsics.checkNotNullParameter(r2, "this$0");
        Intrinsics.checkNotNullParameter(r3, "$change");
        r2.startHeightAnimator(r3.getContainer(), r3.getFromHeight(), r3.getToHeight());
    }

    private final void startHeightAnimator(final View r9, int r10, int r11) {
        if (this.enableLayoutHeightChangeAnim == true) goto L5;
        return;
    L5:
        if (this.matchParentHeight == false) goto L8;
        return;
    L8:
        if (isShowing() == true) goto L11;
        return;
    L11:
        if (r10 != r11) goto L14;
        finishHeightAnim(r9, true);
        return;
    L14:
        this.heightAnimRunning = true;
        this.pendingTargetHeightWhileAnimating = null;
        this.currentAnimContainer = r9;
        ValueAnimatable.Builder r1 = new ValueAnimatable.Builder();
        float r2 = r10;
        float r3 = r11;
        FloatSpringSpec r12 = AnimationSpecKt.spring$default(Token.Bounce.OUI_ANIMATION_BOUNCE_SMOOTH, Token.Duration.OUI_ANIMATION_DURATION_MEDIUM_2, 0, 4, null);
        r12.setAccuracy(0.3f);
        Unit r13 = Unit.INSTANCE;
        this.heightAnimator = ValueAnimatable.Builder.of$default(r1, r2, r3, r12, null, 8, null).onUpdate(new AnonymousClass2(this, r9)).onEnd(new AnonymousClass3(this, r9)).build().start();
    }

    private final void cancelHeightAnimatorIfNeeded(boolean r4) {
        AnimationManager r0 = this.heightAnimator;
        if (r0 == null) goto L7;
        this.cancelRestoreToWrapOnCancel = r4;
        AnimationManager.cancelAnimation$default(r0, false, 1, null);
        this.cancelRestoreToWrapOnCancel = true;
        this.heightAnimator = null;
        return;
    }

    private final void finishHeightAnim(View r3, boolean r4) {
        this.heightAnimRunning = false;
        this.animExpectedHeight = -1;
        this.currentAnimContainer = null;
        if (r4 == false) goto L5;
        this.heightAnimProgrammaticChange = true;
        ViewGroup.LayoutParams r5 = r3.getLayoutParams();
        r5.height = -2;
        r3.setLayoutParams(r5);
        this.heightAnimProgrammaticChange = false;
        r3.requestLayout();
    L5:
        suppressInternalLayout(r3, false);
    }

    private final void setContainerFixedHeight(View r2, int r3) {
        this.heightAnimProgrammaticChange = true;
        ViewGroup.LayoutParams r0 = r2.getLayoutParams();
        r0.height = r3;
        r2.setLayoutParams(r0);
        this.heightAnimProgrammaticChange = false;
    }

    private final void suppressInternalLayout(View r1, boolean r2) {
        suppressHeightAnimContainerChildren(r1, r2);
    }

    private final void cleanupRootHeightAnim() {
        View r0 = this.currentAnimContainer;
        if (r0 != null) goto L5;
        r0 = getHeightChangeAnimContainer();
    L5:
        cancelHeightAnimatorIfNeeded(true);
        if (r0 != null) goto L8;
    L10:
        if (r0 == null) goto L12;
        suppressInternalLayout(r0, false);
    L12:
        this.pendingHeightChange = null;
        this.pendingTargetHeightWhileAnimating = null;
        View r1 = getHeightChangeAnimContainer();
        if (r1 != null) goto L15;
        ViewTreeObserver r3 = null;
    L16:
        ViewTreeObserver.OnPreDrawListener r4 = this.heightPreDrawListener;
        if (r1 == null) goto L23;
        if (r4 == null) goto L23;
        if (r3 == null) goto L23;
        if (r3.isAlive() == false) goto L23;
        r3.removeOnPreDrawListener(r4);
    L23:
        this.heightPreDrawListener = null;
        if (r1 == null) goto L28;
        r1.removeOnLayoutChangeListener(this.heightLayoutChangeListener);
    L28:
        if (this.fixedWindowHeightPx != null) goto L31;
        this.windowLockedMinHeightPx = 0;
        return;
    L31:
        return;
    L15:
        r3 = r1.getViewTreeObserver();
        goto L16
    L8:
        if (this.heightAnimRunning == false) goto L10;
        finishHeightAnim(r0, true);
        goto L12
    }

    private final void setOnApplyWindowInsetsListener() {
        getRootView().setOnApplyWindowInsetsListener(new AbstractDialog$$ExternalSyntheticLambda3(this));
    }

    /* JADX INFO: renamed from: setOnApplyWindowInsetsListener$lambda-14, reason: not valid java name */
    private static final WindowInsets m467setOnApplyWindowInsetsListener$lambda14(AbstractDialog r11, View r12, WindowInsets r13) {
        Intrinsics.checkNotNullParameter(r11, "this$0");
        Intrinsics.checkNotNullParameter(r12, BaseSwitches.V);
        Intrinsics.checkNotNullParameter(r13, "insets");
        Context r0 = r12.getContext();
        Intrinsics.checkNotNullExpressionValue(r0, "v.context");
        boolean r1 = OWindowConfigController.isGestureNavigation(r0);
        OWindowConfigController r2 = OWindowConfigController.INSTANCE;
        Context r3 = r11.getContext();
        Intrinsics.checkNotNullExpressionValue(r3, "context");
        boolean r4 = r2.isLandscape(r3);
        OWindowConfigController r5 = OWindowConfigController.INSTANCE;
        Context r6 = r11.getContext();
        Intrinsics.checkNotNullExpressionValue(r6, "context");
        boolean r7 = r5.isInMultiWindowMode(r6);
        boolean r8 = true;
        if (r7 == true) goto L7;
        if (r4 == true) goto L7;
        boolean r9 = false;
    L8:
        if (r9 == false) goto L10;
        int r10 = 0;
    L11:
        int r14 = OWindowConfigController.INSTANCE.getImeHeight(r11.getRootView());
        L.v(r11.TAG$1, "onApplyWindowInsets, systemBarHeight: " + r10 + ", imeInsets: " + r14);
        if (r1 == false) goto L14;
        int r15 = r11.getLayoutMarginBottom();
    L15:
        View r16 = r11.getRootView();
        ViewGroup.LayoutParams r17 = r11.getRootView().getLayoutParams();
        Integer r18 = null;
        if ((r17 instanceof ViewGroup.MarginLayoutParams) == false) goto L18;
        ViewGroup.MarginLayoutParams r19 = (ViewGroup.MarginLayoutParams) r17;
    L19:
        if (r19 == null) goto L22;
        r19.bottomMargin = r15;
    L22:
        r16.setLayoutParams(r17);
        Context r20 = r11.getContext();
        Intrinsics.checkNotNullExpressionValue(r20, "context");
        if (r14 >= OUnitExtensionKt.getScreenHeight(r20)) goto L50;
        if (r14 > 0) goto L27;
        r11.insetsBaseYOffsetPx = 0;
        if (r11.widthMatch == false) goto L35;
        Context r110 = r11.getContext();
        Intrinsics.checkNotNullExpressionValue(r110, "context");
        int r21 = r10 - OUnitExtensionKt.cdp(r110, 16);
        r11.getRootView().setPadding(0, 0, 0, r21);
        L.v(r11.TAG$1, Intrinsics.stringPlus("onApplyWindowInsets, update rootView.padding, bottomPadding: ", Integer.valueOf(r21)));
    L37:
        r11.animateWindowYTo(r11.insetsBaseYOffsetPx + r11.windowOffsetYPx);
        if (r8 == false) goto L50;
        KtExt r111 = KtExt.INSTANCE;
        Object r112 = r11.getRootView().getParent();
        if (r112 != null) goto L43;
    L41:
        r112 = null;
    L44:
        View r113 = (View) r112;
        String r22 = r11.TAG$1;
        StringBuilder r23 = new StringBuilder("onApplyWindowInsets, post recheck, parentView.height: ");
        if (r113 == null) goto L48;
        r18 = Integer.valueOf(r113.getHeight());
    L48:
        L.v(r22, r23.append(r18).append(", rootView.height: ").append(r11.getRootView().getHeight()).toString());
        r11.handler.removeMessages(101);
        r11.handler.sendEmptyMessageDelayed(101, 200);
        goto L50
    L43:
        if ((r112 instanceof View) == false) goto L41;
    L35:
        L.v(r11.TAG$1, Intrinsics.stringPlus("onApplyWindowInsets, update rootView.layoutParams, bottomMargin: ", Integer.valueOf(r10)));
    L36:
        r8 = false;
        goto L37
    L27:
        if (r11.widthMatch == false) goto L29;
        r12.setPadding(0, 0, 0, r14);
        L.v(r11.TAG$1, Intrinsics.stringPlus("onApplyWindowInsets, update rootView.padding, bottomPadding: ", Integer.valueOf(r14)));
        r11.insetsBaseYOffsetPx = 0;
        goto L36
    L29:
        if (r1 == false) goto L31;
        r10 = 0;
    L31:
        r11.insetsBaseYOffsetPx = r14 - r10;
        String r114 = r11.TAG$1;
        Context r24 = r11.getContext();
        Intrinsics.checkNotNullExpressionValue(r24, "context");
        L.v(r114, Intrinsics.stringPlus("onApplyWindowInsets, update rootView.layoutParams, bottomMargin: ", Integer.valueOf(r14 + OUnitExtensionKt.cdp(r24, 16))));
    L50:
        return r13.consumeSystemWindowInsets();
    L18:
        r19 = null;
        goto L19
    L14:
        r15 = r11.getLayoutMarginBottom() + r10;
        goto L15
    L10:
        r10 = OWindowConfigController.INSTANCE.getNavigationBarHeight(r11.getContext());
    L7:
        r9 = true;
        goto L8
    }

    private final void recheckInset() {
    L18:
        e = move-exception;
        L.e(this.TAG$1, "recheckInset failed", e);
        return;
    L4:
        if (OWindowConfigController.INSTANCE.getImeHeight(getRootView()) <= 0) goto L6;
        return;
    L6:
        if (this.widthMatch == false) goto L24;
        KtExt r1 = KtExt.INSTANCE;     // Catch: Exception -> L18
        Object r2 = getRootView().getParent();     // Catch: Exception -> L18
        if (r2 != null) goto L11;
    L9:
        r2 = null;
    L12:
        View r3 = (View) r2;     // Catch: Exception -> L18
        if (r3 != null) goto L15;
        return;
    L15:
        if (r3.getHeight() <= getRootView().getHeight()) goto L26;
        getRootView().requestLayout();     // Catch: Exception -> L18
        L.v(this.TAG$1, "recheckInset, requestLayout, parentView.height: " + r3.getHeight() + ", rootView.height: " + getRootView().getHeight());     // Catch: Exception -> L18
        return;
    L26:
        return;
    L11:
        if ((r2 instanceof View) == false) goto L9;
    }

    @Override // android.app.Dialog
    protected void onStop() {
        super.onStop();
        removeCallbacksAndMessages(null);
        cleanupRootHeightAnim();
    }

    public static /* synthetic */ void setCloseIconEnabled$default(AbstractDialog r0, boolean r1, View.OnClickListener r2, int r3, Object r4) {
        if (r4 != null) goto L9;
        if ((r3 & 2) == 0) goto L6;
        r2 = null;
    L6:
        r0.setCloseIconEnabled(r1, r2);
        return;
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setCloseIconEnabled");
    }

    public void setCloseIconEnabled(boolean r7, View.OnClickListener r8) {
        this.closeIconEnabled = r7;
        this.onCloseClickListener = r8;
        ImageView r9 = this.closeIcon;
        if (r9 == null) goto L21;
        Context r0 = getContext();
        Intrinsics.checkNotNullExpressionValue(r0, "context");
        ViewExtensionsKt.expandTouchArea(r9, OUnitExtensionKt.cdp(r0, 44));
        if (r7 == false) goto L15;
        View r10 = this.closeIconContainer;
        if (r10 == null) goto L11;
        ViewExtensionsKt.makeVisible(r10);
    L11:
        applyCloseIconStyle$default(this, this.closeIconStyle, null, null, 6, null);
        View r11 = this.closeIconContainer;
        if (r11 == null) goto L22;
        r11.setOnClickListener(new AbstractDialog$$ExternalSyntheticLambda5(this));
        return;
    L22:
        return;
    L15:
        View r6 = this.closeIconContainer;
        if (r6 == null) goto L23;
        ViewExtensionsKt.makeGone(r6);
        return;
    L23:
        return;
    }

    /* JADX INFO: renamed from: setCloseIconEnabled$lambda-16$lambda-15, reason: not valid java name */
    private static final void m466setCloseIconEnabled$lambda16$lambda15(AbstractDialog r1, View r2) {
        Intrinsics.checkNotNullParameter(r1, "this$0");
        r1.dismiss();
        View.OnClickListener r3 = r1.onCloseClickListener;
        if (r3 == null) goto L7;
        r3.onClick(r2);
        return;
    }

    public static /* synthetic */ void applyCloseIconStyle$default(AbstractDialog r1, CloseIconStyle r2, Integer r3, Integer r4, int r5, Object r6) {
        if (r6 != null) goto L12;
        if ((r5 & 2) == 0) goto L7;
        r3 = null;
    L7:
        if ((r5 & 4) == 0) goto L9;
        r4 = null;
    L9:
        r1.applyCloseIconStyle(r2, r3, r4);
        return;
    L12:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: applyCloseIconStyle");
    }

    public final void applyCloseIconStyle(CloseIconStyle r2, Integer r3, Integer r4) {
        Intrinsics.checkNotNullParameter(r2, "style");
        if (this.closeIconEnabled == false) goto L38;
        int r5 = WhenMappings.$EnumSwitchMapping$0[r2.ordinal()];
        if (r5 != 1) goto L7;
        int r6 = R.color.ConstTextInverse;
        r4 = Integer.valueOf(R.color.ConstBGContainer7);
    L17:
        ImageView r7 = this.closeIcon;
        if (r7 == null) goto L21;
        r7.setImageTintList(ContextCompat.getColorStateList(getContext(), r6));
    L21:
        GradientDrawable r8 = null;
        if (r4 != null) goto L27;
        View r1 = this.closeIconContainer;
        if (r1 == null) goto L40;
        r1.setBackground(null);
        return;
    L40:
        return;
    L27:
        View r9 = this.closeIconContainer;
        if (r9 != null) goto L30;
        Drawable r10 = null;
    L32:
        if ((r10 instanceof GradientDrawable) == false) goto L34;
        r8 = (GradientDrawable) r10;
    L34:
        if (r8 == null) goto L41;
        r8.setColor(ContextCompat.getColorStateList(getContext(), r4.intValue()));
        return;
    L41:
        return;
    L30:
        r10 = r9.getBackground();
        goto L32
    L7:
        if (r5 != 2) goto L9;
        r6 = R.color.TextReverse;
        r4 = Integer.valueOf(R.color.ConstTextInverse5);
        goto L17
    L9:
        if (r5 != 3) goto L14;
        if (r3 != null) goto L12;
        r6 = R.color.ConstTextInverse;
        goto L17
    L12:
        r6 = r3.intValue();
        goto L17
    L14:
        throw new NoWhenBranchMatchedException();
    }

    @Override // android.app.Dialog
    public void show() {
        setOnApplyWindowInsetsListener();
        super.show();
        setupRootHeightChangeAnimIfNeeded();
        applyWindowHeightIfNeeded();
        Window r0 = getWindow();
        if (r0 == null) goto L61;
        if (getShowAnimRunning() == false) goto L8;
        return;
    L8:
        r0.setBackgroundDrawableResource(android.R.color.transparent);
        Window r2 = getWindow();
        if (r2 == null) goto L13;
        r2.setWindowAnimations(0);
    L13:
        if (getAdaptWindowDim() == false) goto L18;
        Window r3 = getWindow();
        if (r3 == null) goto L19;
        r3.clearFlags(2);
    L19:
        hideAndTransparentNavigationBar(r0);
        WindowManager.LayoutParams r4 = r0.getAttributes();
        r4.gravity = this.windowGravity;
        r4.x = this.windowOffsetXPx;
        r4.y = getInsetsBaseYOffsetPx() + this.windowOffsetYPx;
        r4.setFitInsetsSides(WindowInsets.Side.all() ^ 8);
        RadiusLayout r7 = null;
        if (getMatchParentHeight() == false) goto L22;
        r4.height = -1;
    L36:
        if (getWidthMatch() == false) goto L50;
        View r5 = getRootView();
        ViewGroup.LayoutParams r6 = getRootView().getLayoutParams();
        r6.width = -1;
        if ((r6 instanceof ViewGroup.MarginLayoutParams) == false) goto L40;
        ViewGroup.MarginLayoutParams r8 = (ViewGroup.MarginLayoutParams) r6;
    L41:
        if (r8 == null) goto L44;
        r8.bottomMargin = 0;
    L44:
        r5.setLayoutParams(r6);
        View r9 = getRootView();
        if ((r9 instanceof RadiusLayout) == false) goto L47;
        r7 = (RadiusLayout) r9;
    L47:
        if (r7 == null) goto L56;
        float r10 = r7.getContext().getResources().getDimension(R.dimen.oui_r_l3);
        r7.setRadius(r10, r10, 0.0f, 0.0f);
    L56:
        if (getAdaptWindowDim() == false) goto L58;
        Context r11 = r0.getContext();
        Intrinsics.checkNotNullExpressionValue(r11, "context");
        r4.dimAmount = getTargetWindowDimAmount(r11);
    L59:
        OWindowConfigController r12 = OWindowConfigController.INSTANCE;
        Context r13 = r0.getContext();
        Intrinsics.checkNotNullExpressionValue(r13, "context");
        Activity r14 = r12.getActivity(r13);
        Intrinsics.checkNotNullExpressionValue(r4, "params");
        OWindowConfigController.applyLandscapeCutoutMode(r14, r4, this.includeCutoutInLandscape);
        r0.setAttributes(r4);
        goto L61
    L58:
        r4.dimAmount = 0.0f;
        goto L59
    L40:
        r8 = null;
        goto L41
    L50:
        Size r15 = OWindowConfigController.getFullWindowSize(r0.getContext());
        int r16 = Math.min(r15.getWidth(), r15.getHeight()) - (getLayoutMarginHorizontal(r0) * 2);
        View r17 = getRootView();
        ViewGroup.LayoutParams r18 = getRootView().getLayoutParams();
        r18.width = r16;
        r17.setLayoutParams(r18);
        getRootView().measure(View.MeasureSpec.makeMeasureSpec(r16, Integer.MIN_VALUE), 0);
        if (r15.getWidth() >= r15.getHeight()) goto L56;
        int r19 = r15.getHeight();
        Context r20 = r0.getContext();
        Intrinsics.checkNotNullExpressionValue(r20, "context");
        int r21 = r19 - OUnitExtensionKt.cdp(r20, 232);
        if (getRootView().getMeasuredHeight() <= r21) goto L56;
        setMaxRootViewHeightGap(getRootView().getMeasuredHeight() - r21);
        goto L56
    L22:
        Integer r22 = this.fixedWindowHeightPx;
        if (r22 != null) goto L33;
        r22 = Integer.valueOf(this.windowLockedMinHeightPx);
        if (r22.intValue() <= 0) goto L27;
        boolean r23 = true;
    L28:
        if (r23 == true) goto L31;
        r22 = null;
    L31:
        if (r22 != null) goto L33;
        int r24 = -2;
    L34:
        r4.height = r24;
        goto L36
    L27:
        r23 = false;
    L33:
        r24 = r22.intValue();
        goto L34
    L18:
        r0.addFlags(2);
    L61:
        if (this.pendingApplyWindowPosition == false) goto L63;
        applyWindowPositionIfNeeded();
    L63:
        this.showAnimRunning = true;
    }

    private final void hideAndTransparentNavigationBar(Window r2) {
        if (r2 == null) goto L6;
        r2.setNavigationBarContrastEnforced(false);
    L6:
        if (r2 == null) goto L9;
        r2.clearFlags(134217728);
    L9:
        if (r2 == null) goto L12;
        r2.addFlags(Integer.MIN_VALUE);
    L12:
        if (r2 == null) goto L15;
        r2.setNavigationBarColor(0);
    L15:
        if (r2 == null) goto L18;
        r2.setDecorFitsSystemWindows(false);
    L18:
        if (r2 == null) goto L22;
        r2.setNavigationBarDividerColor(0);
        return;
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        getRootView().setOnApplyWindowInsetsListener(null);
        ValueAnimator r0 = this.windowYAnimator;
        if (r0 == null) goto L6;
        r0.cancel();
    L6:
        this.showAnimRunning = false;
        super.dismiss();     // Catch: Exception -> L9
        return;
    L9:
        e = move-exception;
        L.e(this.TAG$1, "origin Dismiss exception!", e);
    }

    protected final float getTargetWindowDimAmount(Context r1) {
        Intrinsics.checkNotNullParameter(r1, "context");
        if ((r1.getResources().getConfiguration().uiMode & 48) != 32) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L8;
        return 0.8f;
    L8:
        return 0.32f;
    L5:
        r0 = false;
        goto L6
    }

    protected int getLayoutMarginHorizontal(Window r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        return r1.getContext().getResources().getDimensionPixelSize(R.dimen.oui_dialog_layout_margin);
    }

    private final int getLayoutMarginBottom() {
        return getContext().getResources().getDimensionPixelSize(R.dimen.oui_dialog_layout_margin);
    }

    public final void forceHideFirstFrame() {
        this.hideFirstFrame = true;
    }

    public final void adaptWindowDim() {
        this.adaptWindowDim = true;
    }

    public final void setAutoDismiss(boolean r1) {
        this.autoDismissOnButtonClick = r1;
    }

    public final boolean isAutoDismiss() {
        return this.autoDismissOnButtonClick;
    }
}
