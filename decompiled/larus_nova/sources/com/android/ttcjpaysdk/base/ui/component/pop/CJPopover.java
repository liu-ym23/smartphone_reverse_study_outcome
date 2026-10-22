package com.android.ttcjpaysdk.base.ui.component.pop;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.os.Build;
import android.os.IBinder;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.view.animation.OvershootInterpolator;
import android.widget.PopupWindow;
import androidx.core.content.ContextCompat;
import androidx.core.view.animation.PathInterpolatorCompat;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.android.ttcjpaysdk.base.ktextension.CJPayBasicExtensionKt;
import com.android.ttcjpaysdk.base.utils.CJBasicCommonUtils;
import com.bytedance.android.ec.model.response.ECPromotion;
import com.bytedance.android.live.core.anim.LiveDegradeFpsAnimator;
import com.bytedance.android.livesdkapi.LiveCommonConstants;
import com.bytedance.caijing.sdk.infra.base.logger.CJLogger;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.OverlaySource;
import com.obric.assistant.interaction.impl.window.helpers.PopupWindowLancet;
import com.obric.assistant.interaction.impl.window.landscape.childwindow.LandscapeChildPopupWindowBoundsAdapter;
import com.ss.android.ml.process.bl.MLConfigModel;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000²\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b.\n\u0002\u0018\u0002\n\u0002\b\f\b\u0007\u0018\u0000 ¡\u00012\u00020\u0001:\n \u0001¡\u0001¢\u0001£\u0001¤\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010T\u001a\u00020\r2\u0006\u0010U\u001a\u00020\rJ\u0010\u0010V\u001a\u00020W2\u0006\u0010X\u001a\u00020\u0013H\u0003J7\u0010Y\u001a\u00020Z2\u0006\u0010[\u001a\u00020\\2\u0006\u0010]\u001a\u00020\r2\u0006\u0010^\u001a\u00020\r2\u0006\u0010_\u001a\u00020\r2\b\b\u0002\u0010`\u001a\u00020\u0013H\u0000¢\u0006\u0002\baJ\b\u0010b\u001a\u00020WH\u0016J\u0006\u0010c\u001a\u00020\u0013J\u0006\u0010d\u001a\u00020WJ\u0006\u0010e\u001a\u00020\rJ&\u0010f\u001a\u00020W2\u0006\u0010g\u001a\u00020J2\u0006\u0010]\u001a\u00020\r2\u0006\u0010h\u001a\u00020\u00132\u0006\u0010i\u001a\u00020jJ\u0006\u0010k\u001a\u00020\rJ\u0006\u0010l\u001a\u00020\rJ\u0006\u0010m\u001a\u00020\rJ\u0006\u0010n\u001a\u00020\u001aJ\u0006\u0010o\u001a\u00020\rJ\u0006\u0010p\u001a\u00020\rJ\u0010\u0010q\u001a\u00020\r2\u0006\u0010]\u001a\u00020\rH\u0004J\b\u0010r\u001a\u0004\u0018\u00010\u0006J\u0006\u0010s\u001a\u00020JJ\b\u0010t\u001a\u0004\u0018\u00010JJ\b\u0010u\u001a\u00020WH\u0002J\u0006\u0010v\u001a\u00020WJ\b\u0010w\u001a\u00020WH\u0002J\b\u0010x\u001a\u00020WH\u0002J\u0006\u0010y\u001a\u00020WJ.\u0010z\u001a\u00020W2\u0006\u0010g\u001a\u00020J2\u0006\u0010]\u001a\u00020\r2\u0006\u0010{\u001a\u00020\r2\u0006\u0010|\u001a\u00020\r2\u0006\u0010}\u001a\u00020\u001cJ\u0010\u0010~\u001a\u00020W2\u0006\u0010\u007f\u001a\u00020\rH\u0007J\u000f\u0010\u0080\u0001\u001a\u00020W2\u0006\u0010[\u001a\u00020\u0013J\u0014\u0010\u0081\u0001\u001a\u00020W2\t\u0010\u0082\u0001\u001a\u0004\u0018\u00010JH\u0002J!\u0010\u0083\u0001\u001a\u00020W2\u0006\u0010g\u001a\u00020J2\u0006\u0010]\u001a\u00020\r2\u0006\u0010[\u001a\u00020\\H\u0002J\u0019\u0010\u0084\u0001\u001a\u00020W2\u0007\u0010\u0085\u0001\u001a\u00020\u00102\u0007\u0010\u0086\u0001\u001a\u00020\u0010J\u0019\u0010\u0087\u0001\u001a\u00020W2\u0007\u0010\u0088\u0001\u001a\u00020\r2\u0007\u0010\u0089\u0001\u001a\u00020\rJ\t\u0010\u008a\u0001\u001a\u00020WH\u0003J\u0010\u0010\u008b\u0001\u001a\u00020W2\u0007\u0010\u008c\u0001\u001a\u00020\u0013J\u0017\u0010\u008d\u0001\u001a\u00020W2\u0006\u0010]\u001a\u00020\rH\u0000¢\u0006\u0003\b\u008e\u0001J\u0012\u0010\u008f\u0001\u001a\u00020W2\t\b\u0002\u0010\u0090\u0001\u001a\u00020\u0013J\u0010\u0010\u0091\u0001\u001a\u00020W2\u0007\u0010\u0092\u0001\u001a\u00020AJ\u0010\u0010\u0093\u0001\u001a\u00020W2\u0007\u0010\u0094\u0001\u001a\u00020\rJ\u0010\u0010\u0095\u0001\u001a\u00020W2\u0007\u0010\u0096\u0001\u001a\u00020\rJ-\u0010\u0097\u0001\u001a\u00020W2\b\u0010g\u001a\u0004\u0018\u00010J2\u0006\u0010]\u001a\u00020\r2\u0006\u0010[\u001a\u00020\\2\n\b\u0002\u0010\u0098\u0001\u001a\u00030\u0099\u0001JH\u0010\u0097\u0001\u001a\u00020W2\b\u0010g\u001a\u0004\u0018\u00010J2\u0006\u0010]\u001a\u00020\r2\u0006\u0010[\u001a\u00020\\2\n\b\u0002\u0010\u0098\u0001\u001a\u00030\u0099\u00012\u0007\u0010\u009a\u0001\u001a\u00020\u001c2\u0007\u0010\u0094\u0001\u001a\u00020\r2\u0007\u0010\u0096\u0001\u001a\u00020\rJ<\u0010\u0097\u0001\u001a\u00020W2\b\u0010g\u001a\u0004\u0018\u00010J2\u0006\u0010]\u001a\u00020\r2\u0006\u0010h\u001a\u00020\u00132\u0007\u0010\u009a\u0001\u001a\u00020\u001c2\u0007\u0010\u0094\u0001\u001a\u00020\r2\u0007\u0010\u0096\u0001\u001a\u00020\rJ+\u0010\u0097\u0001\u001a\u00020W2\b\u0010g\u001a\u0004\u0018\u00010J2\u0006\u0010]\u001a\u00020\r2\u0007\u0010\u009a\u0001\u001a\u00020\u001c2\u0007\u0010\u009b\u0001\u001a\u00020\rJ-\u0010\u009c\u0001\u001a\u00020W2\b\u0010g\u001a\u0004\u0018\u00010J2\u0007\u0010\u009d\u0001\u001a\u00020\r2\u0007\u0010\u009e\u0001\u001a\u00020\r2\u0006\u0010]\u001a\u00020\rH\u0016J)\u0010\u009f\u0001\u001a\u00020W2\u0006\u0010g\u001a\u00020J2\u0006\u0010]\u001a\u00020\r2\u0006\u0010{\u001a\u00020\r2\u0006\u0010|\u001a\u00020\rH\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0016\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0017R\u000e\u0010\u0018\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\"\u001a\u0004\u0018\u00010#X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010%\u001a\u0004\u0018\u00010&X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020(X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020*X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010-\u001a\u00020\r8BX\u0082\u000e¢\u0006\b\n\u0000\u001a\u0004\b.\u0010/R\u000e\u00100\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00101\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00102\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00103\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00104\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00105\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00106\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00107\u001a\u00020\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00108\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00109\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010:\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010;\u001a\u00020\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010<\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010=\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010>\u001a\u0004\u0018\u00010?X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010@\u001a\u0004\u0018\u00010AX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010B\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010C\u001a\u00020\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010D\u001a\u0004\u0018\u00010EX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010F\u001a\u0004\u0018\u00010GX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010H\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010I\u001a\u0004\u0018\u00010JX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010K\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010L\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010M\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010N\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010O\u001a\u0004\u0018\u00010\u001cX\u0082\u000e¢\u0006\u0004\n\u0002\u0010PR\u0012\u0010Q\u001a\u0004\u0018\u00010\u001cX\u0082\u000e¢\u0006\u0004\n\u0002\u0010PR\u000e\u0010R\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010S\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006¥\u0001"}, d2 = {"Lcom/android/ttcjpaysdk/base/ui/component/pop/CJPopover;", "Landroid/widget/PopupWindow;", "builder", "Lcom/android/ttcjpaysdk/base/ui/component/pop/CJPopover$Builder;", "(Lcom/android/ttcjpaysdk/base/ui/component/pop/CJPopover$Builder;)V", "TAG", "", "activity", "Landroid/app/Activity;", "animSet", "Landroid/animation/AnimatorSet;", "bubbleText", "bubbleTextRes", "", "currentShowBubbleNumbers", "customInAnimator", "Landroid/animation/Animator;", "customOutAnimator", "enableAutoDismiss", "", "hasCome", "isAlreadyDismiss", "isHideVirtualKey", "Ljava/lang/Boolean;", "mAlignArrowPadding", "mAnimTime", "", "mArrowOffset", "", "mAutoDismissDelayMillis", "mBgColor", "mBorderColor", "mBorderWidth", "mBubbleOffset", "mClickListener", "Lcom/android/ttcjpaysdk/base/ui/component/pop/CJPopover$OnBubbleClickListener;", "mCornerRadius", "mDismissListener", "Lcom/android/ttcjpaysdk/base/ui/component/pop/CJPopover$OnBubbleDismissListener;", "mDismissRunnable", "Ljava/lang/Runnable;", "mDuxBubbleLayout", "Lcom/android/ttcjpaysdk/base/ui/component/pop/CJPopoverLayout;", "mFocusable", "mGetLocationInWindow", "mGravity", "getMGravity", "()I", "mHeight", "mLayoutClickable", "mNeedArrow", "mNeedOverShoot", "mNeedShadow", "mOnClickMaintain", "mOutsideTouchable", "mPadding", "mParentHeight", "mParentWidth", "mShadowColor", "mShadowRadius", "mShowAsDropDown", "mShowElevationShadow", "mShowListener", "Lcom/android/ttcjpaysdk/base/ui/component/pop/CJPopover$OnBubbleShowListener;", "mTargetLocation", "Landroid/graphics/Point;", "mTextColor", "mTextSize", "mTextView", "Lcom/android/ttcjpaysdk/base/ui/component/pop/CJPopoverTextView;", "mTypeFace", "Landroid/graphics/Typeface;", "mUseDefaultView", "mView", "Landroid/view/View;", "mWidth", "mXOffset", "mYOffset", GXTemplateKey.FLEXBOX_PADDING, "shadowDx", "Ljava/lang/Float;", "shadowDy", "shouldForceDismiss", "transparentBg", "adaptGravity", "originGravity", "animatorEasyInOut", "", "isIn", "calTargetPosition", "", "align", "Lcom/android/ttcjpaysdk/base/ui/component/pop/PopoverAlign;", GXTemplateKey.GAIAX_LAYER_GRAVITY, "anchorWidth", "anchorHeight", "ignoreAlign", "calTargetPosition$base_context_release", "dismiss", "dismissDirectly", "dismissForce", "getArrowHeight", "getBubblePosition", "anchor", "isMiddle", "position", "Landroid/graphics/Rect;", "getBubbledHeight", "getBubbledWidth", "getCurrentShowBubbleNumbers", "getInAnimTime", "getMeasuredHeight", "getMeasuredWidth", "getOrientation", "getPopText", "getPopoverView", "getView", "hideSystemUi", "hideView", "initContentView", "measure", LiveCommonConstants.REASON_ON_DEDTROY, "popupAtLocation", "x", "y", "arrowOffSet", "setAdjustHeight", "adjustHeight", "setAlignArrowPadding", "setBubbleLayout", "view", "setBubblePositionAndShow", "setCustomAnimator", "inAnimator", "outAnimator", "setCustomSize", "width", "height", "setDefaultView", "setEnableAutoDismiss", "value", "setGravity", "setGravity$base_context_release", "setShouldForceDismiss", "forceDismiss", "setTargetLocation", "targetLocation", "setXOffset", "xOffset", "setYOffset", "yOffset", "show", "arrowPosition", "Lcom/android/ttcjpaysdk/base/ui/component/pop/ArrowPosition;", "arrowOffset", "offset", "showAsDropDown", "xoff", "yoff", "showAtLocation", "Builder", "Companion", "OnBubbleClickListener", "OnBubbleDismissListener", "OnBubbleShowListener", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CJPopover extends PopupWindow {
    public static final Companion Companion = null;
    public static final long OPACITY_LONG = 120;
    public static final long OPACITY_SHORT = 90;
    public static final long SCALE_LONG = 420;
    public static final long SCALE_SHORT = 120;
    private final String TAG;
    private Activity activity;
    private AnimatorSet animSet;
    private String bubbleText;
    private int bubbleTextRes;
    private volatile int currentShowBubbleNumbers;
    private Animator customInAnimator;
    private Animator customOutAnimator;
    private boolean enableAutoDismiss;
    private boolean hasCome;
    private boolean isAlreadyDismiss;
    private Boolean isHideVirtualKey;
    private boolean mAlignArrowPadding;
    private long mAnimTime;
    private float mArrowOffset;
    private long mAutoDismissDelayMillis;
    private int mBgColor;
    private int mBorderColor;
    private int mBorderWidth;
    private float mBubbleOffset;
    private OnBubbleClickListener mClickListener;
    private float mCornerRadius;
    private OnBubbleDismissListener mDismissListener;
    private final Runnable mDismissRunnable;
    private CJPopoverLayout mDuxBubbleLayout;
    private boolean mFocusable;
    private boolean mGetLocationInWindow;
    private int mGravity;
    private int mHeight;
    private boolean mLayoutClickable;
    private boolean mNeedArrow;
    private boolean mNeedOverShoot;
    private boolean mNeedShadow;
    private boolean mOnClickMaintain;
    private boolean mOutsideTouchable;
    private float mPadding;
    private int mParentHeight;
    private int mParentWidth;
    private int mShadowColor;
    private float mShadowRadius;
    private boolean mShowAsDropDown;
    private boolean mShowElevationShadow;
    private OnBubbleShowListener mShowListener;
    private Point mTargetLocation;
    private int mTextColor;
    private float mTextSize;
    private CJPopoverTextView mTextView;
    private Typeface mTypeFace;
    private boolean mUseDefaultView;
    private View mView;
    private int mWidth;
    private int mXOffset;
    private int mYOffset;
    private int padding;
    private Float shadowDx;
    private Float shadowDy;
    private boolean shouldForceDismiss;
    private boolean transparentBg;

    @Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b8\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b!\n\u0002\u0018\u0002\n\u0002\bB\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010§\u0001\u001a\u00020!2\u0007\u0010¨\u0001\u001a\u00020!J\u0010\u0010©\u0001\u001a\u00020\u00002\u0007\u0010ª\u0001\u001a\u00020\u000fJ\b\u0010«\u0001\u001a\u00030¬\u0001J\u0010\u0010\u00ad\u0001\u001a\u00020\u00002\u0007\u0010®\u0001\u001a\u00020\u000fJ\u0010\u0010¯\u0001\u001a\u00020\u00002\u0007\u0010°\u0001\u001a\u00020\u0015J\u0010\u0010±\u0001\u001a\u00020\u00002\u0007\u0010²\u0001\u001a\u00020\tJ\u0010\u0010³\u0001\u001a\u00020\u00002\u0007\u0010°\u0001\u001a\u00020\u0015J\u0012\u0010´\u0001\u001a\u00020\u00002\t\b\u0001\u0010µ\u0001\u001a\u00020!J\u0010\u0010¶\u0001\u001a\u00020\u00002\u0007\u0010·\u0001\u001a\u00020!J\u0010\u0010¸\u0001\u001a\u00020\u00002\u0007\u0010¹\u0001\u001a\u00020!J\u0010\u0010º\u0001\u001a\u00020\u00002\u0007\u0010»\u0001\u001a\u00020-J\u0010\u0010¼\u0001\u001a\u00020\u00002\u0007\u0010½\u0001\u001a\u00020!J\u0010\u0010\f\u001a\u00020\u00002\b\b\u0001\u0010\b\u001a\u00020\tJ\u0010\u0010¾\u0001\u001a\u00020\u00002\u0007\u0010¿\u0001\u001a\u00020\u000fJ\u0010\u0010À\u0001\u001a\u00020\u00002\u0007\u0010Á\u0001\u001a\u00020\u000fJ\u0010\u0010Â\u0001\u001a\u00020\u00002\u0007\u0010Ã\u0001\u001a\u00020!J\u0010\u0010Ä\u0001\u001a\u00020\u00002\u0007\u0010Å\u0001\u001a\u00020!J\u0010\u0010Æ\u0001\u001a\u00020\u00002\u0007\u0010Ç\u0001\u001a\u00020\u000fJ\u0010\u0010È\u0001\u001a\u00020\u00002\u0007\u0010É\u0001\u001a\u00020\u000fJ\u0010\u0010Ê\u0001\u001a\u00020\u00002\u0007\u0010Ë\u0001\u001a\u00020\u000fJ\u0010\u0010Ì\u0001\u001a\u00020\u00002\u0007\u0010Ë\u0001\u001a\u00020\u000fJ\u0012\u0010Í\u0001\u001a\u00020\u00002\u0007\u0010Ë\u0001\u001a\u00020\u000fH\u0007J\u0010\u0010Î\u0001\u001a\u00020\u00002\u0007\u0010Ë\u0001\u001a\u00020\u000fJ\u0010\u0010Ï\u0001\u001a\u00020\u00002\u0007\u0010Ð\u0001\u001a\u000206J\u0010\u0010Ñ\u0001\u001a\u00020\u00002\u0007\u0010Ð\u0001\u001a\u00020<J\u0010\u0010Ò\u0001\u001a\u00020\u00002\u0007\u0010Ð\u0001\u001a\u00020uJ\u0010\u0010Ó\u0001\u001a\u00020\u00002\u0007\u0010Ô\u0001\u001a\u00020\u000fJ\u0010\u0010Õ\u0001\u001a\u00020\u00002\u0007\u0010Ö\u0001\u001a\u00020\tJ\u0010\u0010×\u0001\u001a\u00020\u00002\u0007\u0010µ\u0001\u001a\u00020!J\u0010\u0010Ø\u0001\u001a\u00020\u00002\u0007\u0010Ù\u0001\u001a\u00020\u000fJ\u0010\u0010Ú\u0001\u001a\u00020\u00002\u0007\u0010µ\u0001\u001a\u00020!J\u0010\u0010Û\u0001\u001a\u00020\u00002\u0007\u0010Ü\u0001\u001a\u00020\tJ\u0011\u0010Ý\u0001\u001a\u00020\u00002\b\u0010Þ\u0001\u001a\u00030\u0081\u0001J\u0010\u0010ß\u0001\u001a\u00020\u00002\u0007\u0010à\u0001\u001a\u00020\u000fJ\u0011\u0010á\u0001\u001a\u00020\u00002\b\u0010â\u0001\u001a\u00030\u008a\u0001J\u0010\u0010ã\u0001\u001a\u00020\u00002\u0007\u0010ä\u0001\u001a\u00020!J\u0010\u0010å\u0001\u001a\u00020\u00002\u0007\u0010²\u0001\u001a\u00020!J\u0010\u0010æ\u0001\u001a\u00020\u00002\u0007\u0010²\u0001\u001a\u00020!J\u0019\u0010ç\u0001\u001a\u00020\u00002\u0007\u0010è\u0001\u001a\u00020\t2\u0007\u0010é\u0001\u001a\u00020\tJ\u0010\u0010ê\u0001\u001a\u00020\u00002\u0007\u0010ë\u0001\u001a\u00020\tJ\u0010\u0010ì\u0001\u001a\u00020\u00002\u0007\u0010ì\u0001\u001a\u00020\u000fJ\u0010\u0010¡\u0001\u001a\u00020\u00002\u0007\u0010í\u0001\u001a\u00020\u000fR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\u0004R\u001a\u0010\b\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0014\u001a\u00020\u0015X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001a\u0010\u001a\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u000b\"\u0004\b\u001c\u0010\rR\u001a\u0010\u001d\u001a\u00020\u0015X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u0017\"\u0004\b\u001f\u0010\u0019R\u001a\u0010 \u001a\u00020!X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u001a\u0010&\u001a\u00020!X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010#\"\u0004\b(\u0010%R\u001a\u0010)\u001a\u00020!X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010#\"\u0004\b+\u0010%R\u001a\u0010,\u001a\u00020-X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R\u001a\u00102\u001a\u00020!X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u0010#\"\u0004\b4\u0010%R\u001c\u00105\u001a\u0004\u0018\u000106X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u00108\"\u0004\b9\u0010:R\u001c\u0010;\u001a\u0004\u0018\u00010<X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b=\u0010>\"\u0004\b?\u0010@R\u001a\u0010A\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bB\u0010\u0011\"\u0004\bC\u0010\u0013R\u001a\u0010D\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bE\u0010\u0011\"\u0004\bF\u0010\u0013R\u001a\u0010G\u001a\u00020!X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bH\u0010#\"\u0004\bI\u0010%R\u001a\u0010J\u001a\u00020!X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bK\u0010#\"\u0004\bL\u0010%R\u001a\u0010M\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bN\u0010\u0011\"\u0004\bO\u0010\u0013R\u001a\u0010P\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bQ\u0010\u0011\"\u0004\bR\u0010\u0013R\u001a\u0010S\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bT\u0010\u0011\"\u0004\bU\u0010\u0013R\u001a\u0010V\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bW\u0010\u0011\"\u0004\bX\u0010\u0013R\u001a\u0010Y\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bZ\u0010\u0011\"\u0004\b[\u0010\u0013R\u001a\u0010\\\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b]\u0010\u0011\"\u0004\b^\u0010\u0013R\u001a\u0010_\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b`\u0010\u0011\"\u0004\ba\u0010\u0013R\u001a\u0010b\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bc\u0010\u0011\"\u0004\bd\u0010\u0013R\u001a\u0010e\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bf\u0010\u000b\"\u0004\bg\u0010\rR\u001a\u0010h\u001a\u00020!X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bi\u0010#\"\u0004\bj\u0010%R\u001a\u0010k\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bl\u0010\u000b\"\u0004\bm\u0010\rR\u001a\u0010n\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bo\u0010\u0011\"\u0004\bp\u0010\u0013R\u001a\u0010q\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\br\u0010\u0011\"\u0004\bs\u0010\u0013R\u001c\u0010t\u001a\u0004\u0018\u00010uX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bv\u0010w\"\u0004\bx\u0010yR\u001a\u0010z\u001a\u00020!X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b{\u0010#\"\u0004\b|\u0010%R\u001a\u0010}\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b~\u0010\u000b\"\u0004\b\u007f\u0010\rR\"\u0010\u0080\u0001\u001a\u0005\u0018\u00010\u0081\u0001X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u0082\u0001\u0010\u0083\u0001\"\u0006\b\u0084\u0001\u0010\u0085\u0001R\u001d\u0010\u0086\u0001\u001a\u00020\u000fX\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0087\u0001\u0010\u0011\"\u0005\b\u0088\u0001\u0010\u0013R\"\u0010\u0089\u0001\u001a\u0005\u0018\u00010\u008a\u0001X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u008b\u0001\u0010\u008c\u0001\"\u0006\b\u008d\u0001\u0010\u008e\u0001R\u001d\u0010\u008f\u0001\u001a\u00020!X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0090\u0001\u0010#\"\u0005\b\u0091\u0001\u0010%R\u001d\u0010\u0092\u0001\u001a\u00020!X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0093\u0001\u0010#\"\u0005\b\u0094\u0001\u0010%R\u001d\u0010\u0095\u0001\u001a\u00020!X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0096\u0001\u0010#\"\u0005\b\u0097\u0001\u0010%R$\u0010\u0098\u0001\u001a\u0004\u0018\u00010\tX\u0086\u000e¢\u0006\u0015\n\u0003\u0010\u009d\u0001\u001a\u0006\b\u0099\u0001\u0010\u009a\u0001\"\u0006\b\u009b\u0001\u0010\u009c\u0001R$\u0010\u009e\u0001\u001a\u0004\u0018\u00010\tX\u0086\u000e¢\u0006\u0015\n\u0003\u0010\u009d\u0001\u001a\u0006\b\u009f\u0001\u0010\u009a\u0001\"\u0006\b \u0001\u0010\u009c\u0001R\u001d\u0010¡\u0001\u001a\u00020\u000fX\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b¢\u0001\u0010\u0011\"\u0005\b£\u0001\u0010\u0013R\u001d\u0010¤\u0001\u001a\u00020\u000fX\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b¥\u0001\u0010\u0011\"\u0005\b¦\u0001\u0010\u0013¨\u0006î\u0001"}, d2 = {"Lcom/android/ttcjpaysdk/base/ui/component/pop/CJPopover$Builder;", "", "activity", "Landroid/app/Activity;", "(Landroid/app/Activity;)V", "getActivity", "()Landroid/app/Activity;", "setActivity", "cornerRadius", "", "getCornerRadius", "()F", "setCornerRadius", "(F)V", "mAlignArrowPadding", "", "getMAlignArrowPadding", "()Z", "setMAlignArrowPadding", "(Z)V", "mAnimTime", "", "getMAnimTime", "()J", "setMAnimTime", "(J)V", "mArrowOffset", "getMArrowOffset", "setMArrowOffset", "mAutoDismissDelayMillis", "getMAutoDismissDelayMillis", "setMAutoDismissDelayMillis", "mBgColor", "", "getMBgColor", "()I", "setMBgColor", "(I)V", "mBorderColor", "getMBorderColor", "setMBorderColor", "mBorderWidth", "getMBorderWidth", "setMBorderWidth", "mBubbleText", "", "getMBubbleText", "()Ljava/lang/String;", "setMBubbleText", "(Ljava/lang/String;)V", "mBubbleTextRes", "getMBubbleTextRes", "setMBubbleTextRes", "mClickListener", "Lcom/android/ttcjpaysdk/base/ui/component/pop/CJPopover$OnBubbleClickListener;", "getMClickListener", "()Lcom/android/ttcjpaysdk/base/ui/component/pop/CJPopover$OnBubbleClickListener;", "setMClickListener", "(Lcom/android/ttcjpaysdk/base/ui/component/pop/CJPopover$OnBubbleClickListener;)V", "mDismissListener", "Lcom/android/ttcjpaysdk/base/ui/component/pop/CJPopover$OnBubbleDismissListener;", "getMDismissListener", "()Lcom/android/ttcjpaysdk/base/ui/component/pop/CJPopover$OnBubbleDismissListener;", "setMDismissListener", "(Lcom/android/ttcjpaysdk/base/ui/component/pop/CJPopover$OnBubbleDismissListener;)V", "mFocusable", "getMFocusable", "setMFocusable", "mGetLocationInWindow", "getMGetLocationInWindow", "setMGetLocationInWindow", "mGravity", "getMGravity", "setMGravity", "mHeight", "getMHeight", "setMHeight", "mHideVirtualKey", "getMHideVirtualKey", "setMHideVirtualKey", "mLayoutClickable", "getMLayoutClickable", "setMLayoutClickable", "mNeedAddColor", "getMNeedAddColor", "setMNeedAddColor", "mNeedArrow", "getMNeedArrow", "setMNeedArrow", "mNeedOverShoot", "getMNeedOverShoot", "setMNeedOverShoot", "mNeedShadow", "getMNeedShadow", "setMNeedShadow", "mOnClickMaintain", "getMOnClickMaintain", "setMOnClickMaintain", "mOutsideTouchable", "getMOutsideTouchable", "setMOutsideTouchable", "mPadding", "getMPadding", "setMPadding", "mShadowColor", "getMShadowColor", "setMShadowColor", "mShadowRadius", "getMShadowRadius", "setMShadowRadius", "mShowAsDropDown", "getMShowAsDropDown", "setMShowAsDropDown", "mShowElevationShadow", "getMShowElevationShadow", "setMShowElevationShadow", "mShowListener", "Lcom/android/ttcjpaysdk/base/ui/component/pop/CJPopover$OnBubbleShowListener;", "getMShowListener", "()Lcom/android/ttcjpaysdk/base/ui/component/pop/CJPopover$OnBubbleShowListener;", "setMShowListener", "(Lcom/android/ttcjpaysdk/base/ui/component/pop/CJPopover$OnBubbleShowListener;)V", "mTextColor", "getMTextColor", "setMTextColor", "mTextSize", "getMTextSize", "setMTextSize", "mTypeFace", "Landroid/graphics/Typeface;", "getMTypeFace", "()Landroid/graphics/Typeface;", "setMTypeFace", "(Landroid/graphics/Typeface;)V", "mUseDefaultView", "getMUseDefaultView", "setMUseDefaultView", "mView", "Landroid/view/View;", "getMView", "()Landroid/view/View;", "setMView", "(Landroid/view/View;)V", "mWidth", "getMWidth", "setMWidth", "mXOffset", "getMXOffset", "setMXOffset", "mYOffset", "getMYOffset", "setMYOffset", "shadowDx", "getShadowDx", "()Ljava/lang/Float;", "setShadowDx", "(Ljava/lang/Float;)V", "Ljava/lang/Float;", "shadowDy", "getShadowDy", "setShadowDy", "transparentBg", "getTransparentBg", "setTransparentBg", "useAlphaAnim", "getUseAlphaAnim", "setUseAlphaAnim", "adaptGravity", "originGravity", "alignArrowPadding", "align", "build", "Lcom/android/ttcjpaysdk/base/ui/component/pop/CJPopover;", "onClickMaintain", "maintain", "setAnimTime", "time", "setArrowOffset", "offset", "setAutoDismissDelayMillis", "setBgColor", "color", "setBorderColor", "borderColor", "setBorderWidth", "borderWidth", "setBubbleText", "str", "setBubbleTextRes", "resId", "setFocusable", "focusable", "setGetLocationInWindow", "getLocationInWindow", "setGravity", GXTemplateKey.GAIAX_LAYER_GRAVITY, "setHeight", "height", "setHideVirtualKey", "hide", "setLayoutClickable", "clickable", "setNeedArrow", "need", "setNeedOverShoot", "setNeedPath", "setNeedShadow", "setOnClickListener", "listener", "setOnDismissListener", "setOnShowListener", "setOutSideTouchable", "touchable", "setPadding", GXTemplateKey.FLEXBOX_PADDING, "setShadowColor", "setShowElevationShadow", "show", "setTextColor", "setTextSize", "textSize", "setTypeface", MLConfigModel.MODEL_TYPE_TF, "setUseDefaultView", "useDefault", "setView", "view", "setWidth", "width", "setXOffset", "setYOffset", "shadowOffset", "dx", "dy", "shadowRadius", "radius", "showAsDropDown", ECPromotion.TRANSPARENT_BOTTON_ICON, "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Builder {
        private Activity activity;
        private float cornerRadius;
        private boolean mAlignArrowPadding;
        private long mAnimTime;
        private float mArrowOffset;
        private long mAutoDismissDelayMillis;
        private int mBgColor;
        private int mBorderColor;
        private int mBorderWidth;
        private String mBubbleText;
        private int mBubbleTextRes;
        private OnBubbleClickListener mClickListener;
        private OnBubbleDismissListener mDismissListener;
        private boolean mFocusable;
        private boolean mGetLocationInWindow;
        private int mGravity;
        private int mHeight;
        private boolean mHideVirtualKey;
        private boolean mLayoutClickable;
        private boolean mNeedAddColor;
        private boolean mNeedArrow;
        private boolean mNeedOverShoot;
        private boolean mNeedShadow;
        private boolean mOnClickMaintain;
        private boolean mOutsideTouchable;
        private float mPadding;
        private int mShadowColor;
        private float mShadowRadius;
        private boolean mShowAsDropDown;
        private boolean mShowElevationShadow;
        private OnBubbleShowListener mShowListener;
        private int mTextColor;
        private float mTextSize;
        private Typeface mTypeFace;
        private boolean mUseDefaultView;
        private View mView;
        private int mWidth;
        private int mXOffset;
        private int mYOffset;
        private Float shadowDx;
        private Float shadowDy;
        private boolean transparentBg;
        private boolean useAlphaAnim;

        public final int adaptGravity(int r100) {
            if (r100 != 8388611) goto L5;
            return 3;
        L5:
            if (r100 != 8388613) goto L11;
            return 5;
        L11:
            return r100;
        }

        @Deprecated(message = "No op", replaceWith = @ReplaceWith(expression = "Not supported", imports = {}))
        public final Builder setNeedPath(boolean r100) {
            return this;
        }

        public final CJPopover build() {
            return new CJPopover(this);
        }

        public final Activity getActivity() {
            return this.activity;
        }

        public final float getCornerRadius() {
            return this.cornerRadius;
        }

        public final boolean getMAlignArrowPadding() {
            return this.mAlignArrowPadding;
        }

        public final long getMAnimTime() {
            return this.mAnimTime;
        }

        public final float getMArrowOffset() {
            return this.mArrowOffset;
        }

        public final long getMAutoDismissDelayMillis() {
            return this.mAutoDismissDelayMillis;
        }

        public final int getMBgColor() {
            return this.mBgColor;
        }

        public final int getMBorderColor() {
            return this.mBorderColor;
        }

        public final int getMBorderWidth() {
            return this.mBorderWidth;
        }

        public final String getMBubbleText() {
            return this.mBubbleText;
        }

        public final int getMBubbleTextRes() {
            return this.mBubbleTextRes;
        }

        public final OnBubbleClickListener getMClickListener() {
            return this.mClickListener;
        }

        public final OnBubbleDismissListener getMDismissListener() {
            return this.mDismissListener;
        }

        public final boolean getMFocusable() {
            return this.mFocusable;
        }

        public final boolean getMGetLocationInWindow() {
            return this.mGetLocationInWindow;
        }

        public final int getMGravity() {
            return this.mGravity;
        }

        public final int getMHeight() {
            return this.mHeight;
        }

        public final boolean getMHideVirtualKey() {
            return this.mHideVirtualKey;
        }

        public final boolean getMLayoutClickable() {
            return this.mLayoutClickable;
        }

        public final boolean getMNeedAddColor() {
            return this.mNeedAddColor;
        }

        public final boolean getMNeedArrow() {
            return this.mNeedArrow;
        }

        public final boolean getMNeedOverShoot() {
            return this.mNeedOverShoot;
        }

        public final boolean getMNeedShadow() {
            return this.mNeedShadow;
        }

        public final boolean getMOnClickMaintain() {
            return this.mOnClickMaintain;
        }

        public final boolean getMOutsideTouchable() {
            return this.mOutsideTouchable;
        }

        public final float getMPadding() {
            return this.mPadding;
        }

        public final int getMShadowColor() {
            return this.mShadowColor;
        }

        public final float getMShadowRadius() {
            return this.mShadowRadius;
        }

        public final boolean getMShowAsDropDown() {
            return this.mShowAsDropDown;
        }

        public final boolean getMShowElevationShadow() {
            return this.mShowElevationShadow;
        }

        public final OnBubbleShowListener getMShowListener() {
            return this.mShowListener;
        }

        public final int getMTextColor() {
            return this.mTextColor;
        }

        public final float getMTextSize() {
            return this.mTextSize;
        }

        public final Typeface getMTypeFace() {
            return this.mTypeFace;
        }

        public final boolean getMUseDefaultView() {
            return this.mUseDefaultView;
        }

        public final View getMView() {
            return this.mView;
        }

        public final int getMWidth() {
            return this.mWidth;
        }

        public final int getMXOffset() {
            return this.mXOffset;
        }

        public final int getMYOffset() {
            return this.mYOffset;
        }

        public final Float getShadowDx() {
            return this.shadowDx;
        }

        public final Float getShadowDy() {
            return this.shadowDy;
        }

        public final boolean getTransparentBg() {
            return this.transparentBg;
        }

        public final boolean getUseAlphaAnim() {
            return this.useAlphaAnim;
        }

        public Builder(Activity r100) {
            Intrinsics.checkNotNullParameter(r100, "activity");
            this.activity = r100;
            this.mAnimTime = 800;
            this.mAutoDismissDelayMillis = 5000;
            this.mUseDefaultView = true;
            this.mBubbleText = "";
            this.mTextSize = 13.0f;
            this.mNeedArrow = true;
            this.mPadding = 12.0f;
            this.mOutsideTouchable = true;
            this.mShadowColor = -16777216;
            this.mShadowRadius = 2.0f;
            this.mNeedAddColor = true;
            this.cornerRadius = CJPayBasicExtensionKt.dpF(8.0f);
            this.mLayoutClickable = true;
        }

        public final Builder alignArrowPadding(boolean r100) {
            this.mAlignArrowPadding = r100;
            return this;
        }

        public final Builder onClickMaintain(boolean r100) {
            this.mOnClickMaintain = r100;
            return this;
        }

        public final void setActivity(Activity r100) {
            Intrinsics.checkNotNullParameter(r100, "<set-?>");
            this.activity = r100;
        }

        public final Builder setAnimTime(long r100) {
            this.mAnimTime = r100;
            return this;
        }

        public final Builder setArrowOffset(float r100) {
            this.mArrowOffset = r100;
            return this;
        }

        public final Builder setAutoDismissDelayMillis(long r100) {
            this.mAutoDismissDelayMillis = r100;
            return this;
        }

        public final Builder setBgColor(int r100) {
            this.mBgColor = r100;
            return this;
        }

        public final Builder setBorderColor(int r100) {
            this.mBorderColor = r100;
            return this;
        }

        public final Builder setBorderWidth(int r100) {
            this.mBorderWidth = r100;
            return this;
        }

        public final Builder setBubbleText(String r100) {
            Intrinsics.checkNotNullParameter(r100, "str");
            this.mBubbleText = r100;
            return this;
        }

        public final Builder setBubbleTextRes(int r100) {
            this.mBubbleTextRes = r100;
            return this;
        }

        public final Builder setCornerRadius(float r100) {
            this.cornerRadius = r100;
            return this;
        }

        public final Builder setFocusable(boolean r100) {
            this.mFocusable = r100;
            return this;
        }

        public final Builder setGetLocationInWindow(boolean r100) {
            this.mGetLocationInWindow = r100;
            return this;
        }

        public final Builder setGravity(int r100) {
            this.mGravity = adaptGravity(r100);
            return this;
        }

        public final Builder setHeight(int r100) {
            this.mHeight = r100 + CJPayBasicExtensionKt.dp(14.0f);
            return this;
        }

        public final Builder setHideVirtualKey(boolean r100) {
            this.mHideVirtualKey = r100;
            return this;
        }

        public final Builder setLayoutClickable(boolean r100) {
            this.mLayoutClickable = r100;
            return this;
        }

        public final void setMAlignArrowPadding(boolean r100) {
            this.mAlignArrowPadding = r100;
        }

        public final void setMAnimTime(long r100) {
            this.mAnimTime = r100;
        }

        public final void setMArrowOffset(float r100) {
            this.mArrowOffset = r100;
        }

        public final void setMAutoDismissDelayMillis(long r100) {
            this.mAutoDismissDelayMillis = r100;
        }

        public final void setMBgColor(int r100) {
            this.mBgColor = r100;
        }

        public final void setMBorderColor(int r100) {
            this.mBorderColor = r100;
        }

        public final void setMBorderWidth(int r100) {
            this.mBorderWidth = r100;
        }

        public final void setMBubbleText(String r100) {
            Intrinsics.checkNotNullParameter(r100, "<set-?>");
            this.mBubbleText = r100;
        }

        public final void setMBubbleTextRes(int r100) {
            this.mBubbleTextRes = r100;
        }

        public final void setMClickListener(OnBubbleClickListener r100) {
            this.mClickListener = r100;
        }

        public final void setMDismissListener(OnBubbleDismissListener r100) {
            this.mDismissListener = r100;
        }

        public final void setMFocusable(boolean r100) {
            this.mFocusable = r100;
        }

        public final void setMGetLocationInWindow(boolean r100) {
            this.mGetLocationInWindow = r100;
        }

        public final void setMGravity(int r100) {
            this.mGravity = r100;
        }

        public final void setMHeight(int r100) {
            this.mHeight = r100;
        }

        public final void setMHideVirtualKey(boolean r100) {
            this.mHideVirtualKey = r100;
        }

        public final void setMLayoutClickable(boolean r100) {
            this.mLayoutClickable = r100;
        }

        public final void setMNeedAddColor(boolean r100) {
            this.mNeedAddColor = r100;
        }

        public final void setMNeedArrow(boolean r100) {
            this.mNeedArrow = r100;
        }

        public final void setMNeedOverShoot(boolean r100) {
            this.mNeedOverShoot = r100;
        }

        public final void setMNeedShadow(boolean r100) {
            this.mNeedShadow = r100;
        }

        public final void setMOnClickMaintain(boolean r100) {
            this.mOnClickMaintain = r100;
        }

        public final void setMOutsideTouchable(boolean r100) {
            this.mOutsideTouchable = r100;
        }

        public final void setMPadding(float r100) {
            this.mPadding = r100;
        }

        public final void setMShadowColor(int r100) {
            this.mShadowColor = r100;
        }

        public final void setMShadowRadius(float r100) {
            this.mShadowRadius = r100;
        }

        public final void setMShowAsDropDown(boolean r100) {
            this.mShowAsDropDown = r100;
        }

        public final void setMShowElevationShadow(boolean r100) {
            this.mShowElevationShadow = r100;
        }

        public final void setMShowListener(OnBubbleShowListener r100) {
            this.mShowListener = r100;
        }

        public final void setMTextColor(int r100) {
            this.mTextColor = r100;
        }

        public final void setMTextSize(float r100) {
            this.mTextSize = r100;
        }

        public final void setMTypeFace(Typeface r100) {
            this.mTypeFace = r100;
        }

        public final void setMUseDefaultView(boolean r100) {
            this.mUseDefaultView = r100;
        }

        public final void setMView(View r100) {
            this.mView = r100;
        }

        public final void setMWidth(int r100) {
            this.mWidth = r100;
        }

        public final void setMXOffset(int r100) {
            this.mXOffset = r100;
        }

        public final void setMYOffset(int r100) {
            this.mYOffset = r100;
        }

        public final Builder setNeedArrow(boolean r100) {
            this.mNeedArrow = r100;
            return this;
        }

        public final Builder setNeedOverShoot(boolean r100) {
            this.mNeedOverShoot = r100;
            return this;
        }

        public final Builder setNeedShadow(boolean r100) {
            this.mNeedShadow = r100;
            return this;
        }

        public final Builder setOnClickListener(OnBubbleClickListener r100) {
            Intrinsics.checkNotNullParameter(r100, "listener");
            this.mClickListener = r100;
            return this;
        }

        public final Builder setOnDismissListener(OnBubbleDismissListener r100) {
            Intrinsics.checkNotNullParameter(r100, "listener");
            this.mDismissListener = r100;
            return this;
        }

        public final Builder setOnShowListener(OnBubbleShowListener r100) {
            Intrinsics.checkNotNullParameter(r100, "listener");
            this.mShowListener = r100;
            return this;
        }

        public final Builder setOutSideTouchable(boolean r100) {
            this.mOutsideTouchable = r100;
            return this;
        }

        public final Builder setPadding(float r100) {
            this.mPadding = r100;
            return this;
        }

        public final Builder setShadowColor(int r100) {
            this.mShadowColor = r100;
            return this;
        }

        public final void setShadowDx(Float r100) {
            this.shadowDx = r100;
        }

        public final void setShadowDy(Float r100) {
            this.shadowDy = r100;
        }

        public final Builder setShowElevationShadow(boolean r100) {
            this.mShowElevationShadow = r100;
            return this;
        }

        public final Builder setTextColor(int r100) {
            this.mTextColor = r100;
            return this;
        }

        public final Builder setTextSize(float r100) {
            this.mTextSize = r100;
            return this;
        }

        public final void setTransparentBg(boolean r100) {
            this.transparentBg = r100;
        }

        public final Builder setTypeface(Typeface r100) {
            Intrinsics.checkNotNullParameter(r100, MLConfigModel.MODEL_TYPE_TF);
            this.mTypeFace = r100;
            return this;
        }

        public final void setUseAlphaAnim(boolean r100) {
            this.useAlphaAnim = r100;
        }

        public final Builder setUseDefaultView(boolean r100) {
            this.mUseDefaultView = r100;
            return this;
        }

        public final Builder setView(View r100) {
            Intrinsics.checkNotNullParameter(r100, "view");
            this.mView = r100;
            return this;
        }

        public final Builder setWidth(int r100) {
            this.mWidth = r100 + CJPayBasicExtensionKt.dp(14.0f);
            return this;
        }

        public final Builder setXOffset(int r100) {
            this.mXOffset = r100;
            return this;
        }

        public final Builder setYOffset(int r100) {
            this.mYOffset = r100;
            return this;
        }

        public final Builder shadowRadius(float r100) {
            this.mShadowRadius = r100;
            return this;
        }

        public final Builder showAsDropDown(boolean r100) {
            this.mShowAsDropDown = r100;
            return this;
        }

        public final Builder transparentBg(boolean r100) {
            this.transparentBg = r100;
            return this;
        }

        /* JADX INFO: renamed from: setCornerRadius, reason: collision with other method in class */
        public final void m8051setCornerRadius(float r100) {
            this.cornerRadius = r100;
        }

        public final Builder shadowOffset(float r100, float r101) {
            this.shadowDx = Float.valueOf(r100);
            this.shadowDy = Float.valueOf(r101);
            return this;
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/android/ttcjpaysdk/base/ui/component/pop/CJPopover$Companion;", "", "()V", "OPACITY_LONG", "", "OPACITY_SHORT", "SCALE_LONG", "SCALE_SHORT", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004"}, d2 = {"Lcom/android/ttcjpaysdk/base/ui/component/pop/CJPopover$OnBubbleClickListener;", "", "clickBubble", "", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface OnBubbleClickListener {
        void clickBubble();
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004"}, d2 = {"Lcom/android/ttcjpaysdk/base/ui/component/pop/CJPopover$OnBubbleDismissListener;", "", "bubbleDismiss", "", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface OnBubbleDismissListener {
        void bubbleDismiss();
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004"}, d2 = {"Lcom/android/ttcjpaysdk/base/ui/component/pop/CJPopover$OnBubbleShowListener;", "", "bubbleShow", "", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface OnBubbleShowListener {
        void bubbleShow();
    }

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1 = null;

        static {
            int[] r100 = new int[ArrowPosition.values().length];
            r100[ArrowPosition.END.ordinal()] = 1;     // Catch: NoSuchFieldError -> L15
        L24:
            r100[ArrowPosition.CENTER.ordinal()] = 2;     // Catch: NoSuchFieldError -> L16
        L30:
            r100[ArrowPosition.START.ordinal()] = 3;     // Catch: NoSuchFieldError -> L17
        L8:
            $EnumSwitchMapping$0 = r100;
            int[] r101 = new int[PopoverAlign.values().length];
            r101[PopoverAlign.MIDDLE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L18
        L26:
            r101[PopoverAlign.END.ordinal()] = 2;     // Catch: NoSuchFieldError -> L19
        L32:
            r101[PopoverAlign.START.ordinal()] = 3;     // Catch: NoSuchFieldError -> L20
        L22:
            r101[PopoverAlign.ABSOLUT.ordinal()] = 4;     // Catch: NoSuchFieldError -> L21
        L13:
            $EnumSwitchMapping$1 = r101;
        }
    }

    static {
        Companion = new Companion(null);
    }

    public static /* synthetic */ void access$000(PopupWindow r100) {
        super.dismiss();
    }

    public static /* synthetic */ void access$001(PopupWindow r100, View r101, int r102, int r103, int r104) {
        super.showAtLocation(r101, r102, r103, r104);
    }

    public static /* synthetic */ void access$002(PopupWindow r100, View r101, int r102, int r103, int r104) {
        super.showAsDropDown(r101, r102, r103, r104);
    }

    public final int adaptGravity(int r100) {
        if (r100 != 8388611) goto L5;
        return 3;
    L5:
        if (r100 != 8388613) goto L11;
        return 5;
    L11:
        return r100;
    }

    private final int getMGravity() {
        return adaptGravity(this.mGravity);
    }

    private final void hideSystemUi() {
        if (Intrinsics.areEqual(this.isHideVirtualKey, Boolean.FALSE) == false) goto L5;
        return;
    L5:
        getContentView().setSystemUiVisibility(4102);
    }

    private final void initContentView() {
        int r100 = this.mWidth;
        if (r100 == 0) goto L8;
        if (this.mHeight == 0) goto L8;
        setWidth(r100);
        setHeight(this.mHeight);
    L8:
        if (Intrinsics.areEqual(this.isHideVirtualKey, Boolean.TRUE) == false) goto L10;
        hideSystemUi();
    L10:
        CJPopoverLayout r101 = null;
        if (this.mBgColor == 0) goto L16;
        CJPopoverLayout r102 = this.mDuxBubbleLayout;
        if (r102 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("mDuxBubbleLayout");
        r102 = null;
    L15:
        r102.setMBgColor(this.mBgColor);
    L16:
        CJPopoverLayout r103 = this.mDuxBubbleLayout;
        if (r103 != null) goto L19;
        Intrinsics.throwUninitializedPropertyAccessException("mDuxBubbleLayout");
        r103 = null;
    L19:
        r103.setBubbleOrientation(getOrientation(getMGravity()));
        if (this.mPadding != 0.0f) goto L22;
        boolean r104 = true;
    L23:
        if (r104 == true) goto L28;
        CJPopoverLayout r105 = this.mDuxBubbleLayout;
        if (r105 != null) goto L27;
        Intrinsics.throwUninitializedPropertyAccessException("mDuxBubbleLayout");
        r105 = null;
    L27:
        r105.setMPadding(this.mPadding);
    L28:
        CJPopoverLayout r106 = this.mDuxBubbleLayout;
        if (r106 != null) goto L31;
        Intrinsics.throwUninitializedPropertyAccessException("mDuxBubbleLayout");
        r106 = null;
    L31:
        r106.getShadowConfig().setColor(this.mShadowColor);
        CJPopoverLayout r107 = this.mDuxBubbleLayout;
        if (r107 != null) goto L34;
        Intrinsics.throwUninitializedPropertyAccessException("mDuxBubbleLayout");
        r107 = null;
    L34:
        r107.getShadowConfig().setRadius(this.mShadowRadius);
        CJPopoverLayout r108 = this.mDuxBubbleLayout;
        if (r108 != null) goto L37;
        Intrinsics.throwUninitializedPropertyAccessException("mDuxBubbleLayout");
        r108 = null;
    L37:
        r108.setBorderColor(this.mBorderColor);
        CJPopoverLayout r109 = this.mDuxBubbleLayout;
        if (r109 != null) goto L40;
        Intrinsics.throwUninitializedPropertyAccessException("mDuxBubbleLayout");
        r109 = null;
    L40:
        r109.setBorderWidth(this.mBorderWidth);
        CJPopoverLayout r110 = this.mDuxBubbleLayout;
        if (r110 != null) goto L43;
        Intrinsics.throwUninitializedPropertyAccessException("mDuxBubbleLayout");
    L44:
        r101.setTransparentBg(this.transparentBg);
        return;
    L43:
        r101 = r110;
        goto L44
    L22:
        r104 = false;
        goto L23
    }

    private final void measure() {
        int r100 = this.mWidth;
        if (r100 != 0) goto L5;
    L7:
        getContentView().measure(Integer.MIN_VALUE, Integer.MIN_VALUE);
        return;
    L5:
        if (this.mHeight == 0) goto L7;
        int r101 = View.MeasureSpec.makeMeasureSpec(r100, 1073741824);
        int r102 = View.MeasureSpec.makeMeasureSpec(this.mHeight, 1073741824);
        getContentView().measure(r101, r102);
    }

    private final void setDefaultView() {
        CJPopoverTextView r100 = new CJPopoverTextView(this.activity, null, 2, null);
        this.mTextView = r100;
        int r101 = this.mTextColor;
        if (r101 == 0) goto L5;
        r100.setTextColor(r101);
    L6:
        Typeface r102 = this.mTypeFace;
        if (r102 == null) goto L12;
        CJPopoverTextView r103 = this.mTextView;
        if (r103 == null) goto L12;
        r103.setTypeface(r102);
    L12:
        CJPopoverTextView r104 = this.mTextView;
        if (r104 == null) goto L15;
        r104.setTextSize(1, 13.0f);
    L15:
        CJPopoverTextView r105 = this.mTextView;
        if (r105 == null) goto L19;
        r105.setTextAlignment(5);
    L19:
        CJPopoverTextView r106 = this.mTextView;
        if (r106 == null) goto L23;
        r106.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
    L23:
        CJPopoverTextView r107 = this.mTextView;
        if (r107 == null) goto L27;
        r107.setGravity(17);
    L27:
        CJPopoverTextView r108 = this.mTextView;
        if (r108 == null) goto L31;
        r108.setMaxWidth(CJPayBasicExtensionKt.dp(276.0f));
    L31:
        CJPopoverTextView r109 = this.mTextView;
        if (r109 == null) goto L35;
        r109.setMaxLines(1);
    L35:
        CJPopoverTextView r110 = this.mTextView;
        if (r110 == null) goto L39;
        r110.setEllipsize(TextUtils.TruncateAt.END);
    L39:
        setBubbleLayout(this.mTextView);
        if (this.isHideVirtualKey != null) goto L43;
        this.isHideVirtualKey = Boolean.TRUE;
    L43:
        if (TextUtils.isEmpty(this.bubbleText) == true) goto L48;
        CJPopoverTextView r111 = this.mTextView;
        if (r111 == null) goto L48;
        r111.setText(this.bubbleText);
    L48:
        int r112 = this.bubbleTextRes;
        if (r112 == 0) goto L53;
        CJPopoverTextView r113 = this.mTextView;
        if (r113 == null) goto L53;
        r113.setText(r112);
    L53:
        float r114 = this.mTextSize;
        if (r114 != 0.0f) goto L56;
        boolean r115 = true;
    L57:
        if (r115 == true) goto L61;
        CJPopoverTextView r116 = this.mTextView;
        if (r116 == null) goto L61;
        r116.setTextSize(1, r114);
    L61:
        getContentView().measure(Integer.MIN_VALUE, Integer.MIN_VALUE);
        return;
    L56:
        r115 = false;
        goto L57
    L5:
        r100.setTextColor(ContextCompat.getColor(this.activity, R.color.cj_pay_color_pop_view_const_text_inverse));
        goto L6
    }

    @Override // android.widget.PopupWindow
    public void dismiss() {
        if (this.isAlreadyDismiss == true) goto L6;
        animatorEasyInOut(false);
        getContentView().removeCallbacks(this.mDismissRunnable);
        this.mXOffset = 0;
        this.mYOffset = 0;
        return;
    }

    public final boolean dismissDirectly() {
        if (this.isAlreadyDismiss == true) goto L9;
        this.currentShowBubbleNumbers--;
        CJPopoverLayout r100 = this.mDuxBubbleLayout;
        if (r100 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("mDuxBubbleLayout");
        r100 = null;
    L7:
        r100.setVisibility(8);
        onDestroy();
        getContentView().removeCallbacks(this.mDismissRunnable);
        this.mXOffset = 0;
        this.mYOffset = 0;
        return true;
    L9:
        return false;
    }

    public final void dismissForce() {
        if (this.isAlreadyDismiss == true) goto L9;
        this.currentShowBubbleNumbers--;
        CJPopoverLayout r100 = this.mDuxBubbleLayout;
        if (r100 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("mDuxBubbleLayout");
        r100 = null;
    L7:
        r100.setVisibility(8);
        getContentView().removeCallbacks(this.mDismissRunnable);
        this.mXOffset = 0;
        this.mYOffset = 0;
        onDestroy();
        return;
    }

    public final int getArrowHeight() {
        CJPopoverLayout r100 = this.mDuxBubbleLayout;
        if (r100 == null) goto L7;
        if (r100 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("mDuxBubbleLayout");
        r100 = null;
    L9:
        return r100.getArrowHeight();
    L7:
        return 0;
    }

    public final View getPopoverView() {
        CJPopoverLayout r100 = this.mDuxBubbleLayout;
        if (r100 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("mDuxBubbleLayout");
        return null;
    L6:
        return r100;
    }

    public final void hideView() {
        CJPopoverLayout r100 = this.mDuxBubbleLayout;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mDuxBubbleLayout");
        r100 = null;
    L5:
        r100.setVisibility(8);
    }

    public final void onDestroy() {
        AnimatorSet r100 = this.animSet;
        if (r100 == null) goto L5;
        r100.removeAllListeners();
    L5:
        AnimatorSet r101 = this.animSet;
        if (r101 == null) goto L8;
        r101.cancel();
    L8:
        this.animSet = null;
        if (this.activity.isFinishing() == true) goto L13;
        if (isShowing() == false) goto L13;
    L20:
        INVOKESPECIAL_com_android_ttcjpaysdk_base_ui_component_pop_CJPopover_com_obric_assistant_interaction_impl_window_helpers_PopupWindowLancet_dismiss(this);     // Catch: Exception -> L17
        return;
    L17:
        e = move-exception;
        CJBasicCommonUtils.reportCatchException("ArrowPosition#onDestroy", e);
        CJBasicCommonUtils.logCatch("CJCatch", "ArrowPosition#onDestroy", e);
        return;
    L13:
        if (this.shouldForceDismiss == true) goto L20;
    }

    public final int getBubbledHeight() {
        measure();
        int r100 = getContentView().getMeasuredHeight();
        CJPopoverLayout r101 = this.mDuxBubbleLayout;
        if (r101 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("mDuxBubbleLayout");
        r101 = null;
    L6:
        return r100 - (r101.getPadding() * 4);
    }

    public final int getBubbledWidth() {
        measure();
        int r100 = getContentView().getMeasuredWidth();
        CJPopoverLayout r101 = this.mDuxBubbleLayout;
        if (r101 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("mDuxBubbleLayout");
        r101 = null;
    L6:
        return r100 - (r101.getPadding() * 4);
    }

    public final int getMeasuredHeight() {
        measure();
        return getContentView().getMeasuredHeight();
    }

    public final int getMeasuredWidth() {
        measure();
        return getContentView().getMeasuredWidth();
    }

    public final int getCurrentShowBubbleNumbers() {
        return this.currentShowBubbleNumbers;
    }

    public final long getInAnimTime() {
        return this.mAnimTime;
    }

    public final String getPopText() {
        return this.bubbleText;
    }

    public final View getView() {
        return this.mView;
    }

    public CJPopover(Builder r100) {
        Intrinsics.checkNotNullParameter(r100, "builder");
        this.mShadowColor = -16777216;
        this.mAnimTime = 200;
        this.mAutoDismissDelayMillis = 5000;
        this.mUseDefaultView = true;
        this.bubbleText = "";
        this.mTextSize = 13.0f;
        this.mNeedArrow = true;
        this.mPadding = 12.0f;
        this.mOutsideTouchable = true;
        this.enableAutoDismiss = true;
        this.mShadowRadius = 2.0f;
        this.mCornerRadius = CJPayBasicExtensionKt.dpF(8.0f);
        this.mLayoutClickable = true;
        this.TAG = "CJPopover";
        this.activity = r100.getActivity();
        this.mGravity = r100.getMGravity();
        this.mArrowOffset = r100.getMArrowOffset();
        this.mBgColor = r100.getMBgColor();
        this.mNeedOverShoot = r100.getMNeedOverShoot();
        this.isHideVirtualKey = Boolean.valueOf(r100.getMHideVirtualKey());
        this.mXOffset = r100.getMXOffset();
        this.mYOffset = r100.getMYOffset();
        this.mAnimTime = r100.getMAnimTime();
        this.mAutoDismissDelayMillis = r100.getMAutoDismissDelayMillis();
        this.mUseDefaultView = r100.getMUseDefaultView();
        this.mView = r100.getMView();
        this.mHeight = r100.getMHeight();
        this.mWidth = r100.getMWidth();
        this.bubbleText = r100.getMBubbleText();
        this.bubbleTextRes = r100.getMBubbleTextRes();
        this.mTextSize = r100.getMTextSize();
        this.mTextColor = r100.getMTextColor();
        this.mTypeFace = r100.getMTypeFace();
        this.mClickListener = r100.getMClickListener();
        this.mDismissListener = r100.getMDismissListener();
        this.mShowListener = r100.getMShowListener();
        this.mNeedArrow = r100.getMNeedArrow();
        this.mPadding = r100.getMPadding();
        this.mOutsideTouchable = r100.getMOutsideTouchable();
        this.mFocusable = r100.getMFocusable();
        this.mNeedShadow = r100.getMNeedShadow();
        this.mShadowColor = r100.getMShadowColor();
        this.mAlignArrowPadding = r100.getMAlignArrowPadding();
        this.mShadowRadius = r100.getMShadowRadius();
        this.mGetLocationInWindow = r100.getMGetLocationInWindow();
        this.mShowElevationShadow = r100.getMShowElevationShadow();
        this.mBorderWidth = r100.getMBorderWidth();
        this.mBorderColor = r100.getMBorderColor();
        this.transparentBg = r100.getTransparentBg();
        this.mCornerRadius = r100.getCornerRadius();
        this.shadowDx = r100.getShadowDx();
        this.shadowDy = r100.getShadowDy();
        this.mShowAsDropDown = r100.getMShowAsDropDown();
        this.mOnClickMaintain = r100.getMOnClickMaintain();
        this.mLayoutClickable = r100.getMLayoutClickable();
        setWidth(-2);
        setHeight(-2);
        setFocusable(this.mFocusable);
        setOutsideTouchable(this.mOutsideTouchable);
        setClippingEnabled(false);
        setInputMethodMode(1);
        setSoftInputMode(16);
        if (this.mUseDefaultView == true) goto L10;
        View r101 = this.mView;
        if (r101 == null) goto L10;
        setBubbleLayout(r101);
        CJPopoverLayout r102 = this.mDuxBubbleLayout;
        if (r102 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("mDuxBubbleLayout");
        r102 = null;
    L9:
        r102.setUseDefaultView(false);
    L11:
        initContentView();
        this.mDismissRunnable = new CJPopover$mDismissRunnable$1(this);
        return;
    L10:
        setDefaultView();
        goto L11
    }

    public static void INVOKESPECIAL_com_android_ttcjpaysdk_base_ui_component_pop_CJPopover_com_obric_assistant_interaction_impl_window_helpers_PopupWindowLancet_dismiss(PopupWindow r100) {
        PopupWindowLancet.handleDismissBeforeOrigin(r100);
        access$000(r100);
    }

    public static final /* synthetic */ boolean access$getEnableAutoDismiss$p(CJPopover r100) {
        return r100.enableAutoDismiss;
    }

    public static final /* synthetic */ OnBubbleClickListener access$getMClickListener$p(CJPopover r100) {
        return r100.mClickListener;
    }

    public static final /* synthetic */ OnBubbleDismissListener access$getMDismissListener$p(CJPopover r100) {
        return r100.mDismissListener;
    }

    public static final /* synthetic */ CJPopoverLayout access$getMDuxBubbleLayout$p(CJPopover r100) {
        return r100.mDuxBubbleLayout;
    }

    public static final /* synthetic */ boolean access$getMOnClickMaintain$p(CJPopover r100) {
        return r100.mOnClickMaintain;
    }

    public static final /* synthetic */ OnBubbleShowListener access$getMShowListener$p(CJPopover r100) {
        return r100.mShowListener;
    }

    private final void animatorEasyInOut(final boolean r110) {
        final CJPopoverLayout r100 = this.mDuxBubbleLayout;
        CJPopoverLayout r101 = null;
        if (r100 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("mDuxBubbleLayout");
        r100 = null;
    L6:
        if (r110 == true) goto L8;
        this.currentShowBubbleNumbers--;
        this.isAlreadyDismiss = true;
    L8:
        this.animSet = new AnimatorSet();
        int r102 = getMGravity();
        float r103 = 0.0f;
        if (r102 != 3) goto L11;
        float r104 = r100.getX() + r100.getMeasuredWidth();
        float r105 = r100.getY();
        CJPopoverLayout r106 = this.mDuxBubbleLayout;
        if (r106 != null) goto L35;
        Intrinsics.throwUninitializedPropertyAccessException("mDuxBubbleLayout");
    L36:
        float r107 = r101.getBubbleOffset();
    L37:
        float r108 = r107 + r105;
    L38:
        r100.setPivotY(r108);
        r100.setPivotX(r104);
        Interpolator r109 = PathInterpolatorCompat.create(0.0f, 0.0f, 1.0f, 1.0f);
        Interpolator r111 = PathInterpolatorCompat.create(0.3f, 0.0f, 0.9f, 0.6f);
        float[] r112 = new float[2];
        if (r110 == false) goto L41;
        float r113 = 0.0f;
    L42:
        r112[0] = r113;
        if (r110 == false) goto L45;
        r103 = 1.0f;
    L45:
        r112[1] = r103;
        ObjectAnimator r114 = ObjectAnimator.ofFloat(r100, "alpha", r112);
        if (r110 == true) goto L49;
        r109 = r111;
    L49:
        r114.setInterpolator(r109);
        if (r110 == false) goto L52;
        long r115 = 90;
    L53:
        r114.setDuration(r115);
        float[] r116 = new float[2];
        float r117 = 0.5f;
        if (r110 == false) goto L56;
        float r118 = 0.5f;
    L57:
        r116[0] = r118;
        float r119 = 0.8f;
        if (r110 == false) goto L60;
        float r120 = 1.0f;
    L61:
        r116[1] = r120;
        ObjectAnimator r121 = ObjectAnimator.ofFloat(r100, LiveDegradeFpsAnimator.SCALE_X, r116);
        if (r110 == false) goto L64;
        Interpolator r122 = new CJSpringInterpolator(0.61f);
    L65:
        r121.setInterpolator(r122);
        if (r110 == false) goto L68;
        long r123 = 420;
    L69:
        r121.setDuration(r123);
        float[] r124 = new float[2];
        if (r110 == true) goto L73;
        r117 = 1.0f;
    L73:
        r124[0] = r117;
        if (r110 == false) goto L76;
        r119 = 1.0f;
    L76:
        r124[1] = r119;
        ObjectAnimator r125 = ObjectAnimator.ofFloat(r100, LiveDegradeFpsAnimator.SCALE_Y, r124);
        if (r110 == false) goto L79;
        r111 = new CJSpringInterpolator(0.61f);
    L79:
        r125.setInterpolator(r111);
        if (r110 == false) goto L82;
        long r126 = 420;
    L83:
        r125.setDuration(r126);
        r100.setVisibility(0);
        if (r110 == false) goto L90;
        Animator r127 = this.customInAnimator;
        if (r127 == null) goto L90;
        AnimatorSet r128 = this.animSet;
        if (r128 == null) goto L103;
        r128.play(r127);
    L103:
        AnimatorSet r129 = this.animSet;
        if (r129 == null) goto L107;
        r129.addListener(new AnonymousClass1(r110, r100, this));
    L107:
        if (this.mNeedOverShoot == false) goto L113;
        if (r110 == false) goto L113;
        AnimatorSet r130 = this.animSet;
        if (r130 == null) goto L113;
        r130.setInterpolator(new OvershootInterpolator(1.0f));
    L113:
        AnimatorSet r131 = this.animSet;
        if (r131 == null) goto L117;
        r131.start();
        return;
    L117:
        return;
    L90:
        if (r110 == true) goto L96;
        Animator r132 = this.customOutAnimator;
        if (r132 == null) goto L96;
        AnimatorSet r133 = this.animSet;
        if (r133 == null) goto L103;
        r133.play(r132);
    L96:
        AnimatorSet r134 = this.animSet;
        if (r134 == null) goto L103;
        AnimatorSet.Builder r135 = r134.play(r121);
        if (r135 == null) goto L103;
        AnimatorSet.Builder r136 = r135.with(r125);
        if (r136 == null) goto L103;
        r136.with(r114);
        goto L103
    L82:
        r126 = 120;
        goto L83
    L68:
        r123 = 120;
        goto L69
    L64:
        r122 = r111;
        goto L65
    L60:
        r120 = 0.8f;
        goto L61
    L56:
        r118 = 1.0f;
        goto L57
    L52:
        r115 = 120;
        goto L53
    L41:
        r113 = 1.0f;
        goto L42
    L35:
        r101 = r106;
        goto L36
    L11:
        if (r102 != 5) goto L13;
        r104 = r100.getX();
        r105 = r100.getY();
        CJPopoverLayout r137 = this.mDuxBubbleLayout;
        if (r137 != null) goto L30;
        Intrinsics.throwUninitializedPropertyAccessException("mDuxBubbleLayout");
    L31:
        r107 = r101.getBubbleOffset();
        goto L37
    L30:
        r101 = r137;
        goto L31
    L13:
        if (r102 != 48) goto L15;
        float r138 = r100.getX();
        CJPopoverLayout r139 = this.mDuxBubbleLayout;
        if (r139 != null) goto L25;
        Intrinsics.throwUninitializedPropertyAccessException("mDuxBubbleLayout");
    L26:
        r104 = r138 + r101.getBubbleOffset();
        r108 = r100.getY() + r100.getMeasuredHeight();
        goto L38
    L25:
        r101 = r139;
        goto L26
    L15:
        if (r102 == 80) goto L17;
        r108 = 0.0f;
        r104 = 0.0f;
        goto L38
    L17:
        float r140 = r100.getX();
        CJPopoverLayout r141 = this.mDuxBubbleLayout;
        if (r141 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("mDuxBubbleLayout");
    L21:
        r104 = r140 + r101.getBubbleOffset();
        r108 = r100.getY();
        goto L38
    L20:
        r101 = r141;
        goto L21
    }

    private final void setBubbleLayout(View r100) {
        CJPopoverLayout r101 = new CJPopoverLayout(this.activity);
        this.mDuxBubbleLayout = r101;
        CJPopoverLayout r102 = null;
        if (this.mWidth != 0) goto L5;
    L10:
        CJPopoverLayout r103 = this.mDuxBubbleLayout;
        if (r103 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("mDuxBubbleLayout");
        r103 = null;
    L13:
        r103.setBackgroundColor(0);
        CJPopoverLayout r104 = this.mDuxBubbleLayout;
        if (r104 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("mDuxBubbleLayout");
        r104 = null;
    L16:
        r104.setCornerRadius(this.mCornerRadius);
        CJPopoverLayout r105 = this.mDuxBubbleLayout;
        if (r105 != null) goto L19;
        Intrinsics.throwUninitializedPropertyAccessException("mDuxBubbleLayout");
        r105 = null;
    L19:
        r105.addView(r100);
        CJPopoverLayout r106 = this.mDuxBubbleLayout;
        if (r106 != null) goto L22;
        Intrinsics.throwUninitializedPropertyAccessException("mDuxBubbleLayout");
        r106 = null;
    L22:
        r106.setGravity(17);
        ViewGroup.MarginLayoutParams r107 = new ViewGroup.MarginLayoutParams(-2, -2);
        CJPopoverLayout r108 = this.mDuxBubbleLayout;
        if (r108 != null) goto L25;
        Intrinsics.throwUninitializedPropertyAccessException("mDuxBubbleLayout");
        r108 = null;
    L25:
        r108.setLayoutParams(r107);
        CJPopoverLayout r109 = this.mDuxBubbleLayout;
        if (r109 != null) goto L28;
        Intrinsics.throwUninitializedPropertyAccessException("mDuxBubbleLayout");
        r109 = null;
    L28:
        r109.setVisibility(8);
        if (this.mBgColor == 0) goto L34;
        CJPopoverLayout r110 = this.mDuxBubbleLayout;
        if (r110 != null) goto L33;
        Intrinsics.throwUninitializedPropertyAccessException("mDuxBubbleLayout");
        r110 = null;
    L33:
        r110.setMBgColor(this.mBgColor);
    L34:
        CJPopoverLayout r111 = this.mDuxBubbleLayout;
        if (r111 != null) goto L37;
        Intrinsics.throwUninitializedPropertyAccessException("mDuxBubbleLayout");
        r111 = null;
    L37:
        r111.setMNeedArrow(this.mNeedArrow);
        CJPopoverLayout r112 = this.mDuxBubbleLayout;
        if (r112 != null) goto L40;
        Intrinsics.throwUninitializedPropertyAccessException("mDuxBubbleLayout");
        r112 = null;
    L40:
        r112.setMNeedShadow(this.mNeedShadow);
        CJPopoverLayout r113 = this.mDuxBubbleLayout;
        if (r113 != null) goto L43;
        Intrinsics.throwUninitializedPropertyAccessException("mDuxBubbleLayout");
        r113 = null;
    L43:
        r113.getShadowConfig().setColor(this.mShadowColor);
        if (this.shadowDx == null) goto L50;
        CJPopoverLayout r114 = this.mDuxBubbleLayout;
        if (r114 != null) goto L48;
        Intrinsics.throwUninitializedPropertyAccessException("mDuxBubbleLayout");
        r114 = null;
    L48:
        CJPopoverLayout.ShadowConfig r115 = r114.getShadowConfig();
        Float r116 = this.shadowDx;
        Intrinsics.checkNotNull(r116);
        r115.setDx(r116.floatValue());
    L50:
        if (this.shadowDy == null) goto L56;
        CJPopoverLayout r117 = this.mDuxBubbleLayout;
        if (r117 != null) goto L54;
        Intrinsics.throwUninitializedPropertyAccessException("mDuxBubbleLayout");
        r117 = null;
    L54:
        CJPopoverLayout.ShadowConfig r118 = r117.getShadowConfig();
        Float r119 = this.shadowDy;
        Intrinsics.checkNotNull(r119);
        r118.setDy(r119.floatValue());
    L56:
        if (this.mLayoutClickable == false) goto L64;
        CJPopoverLayout r120 = this.mDuxBubbleLayout;
        if (r120 != null) goto L60;
        Intrinsics.throwUninitializedPropertyAccessException("mDuxBubbleLayout");
        r120 = null;
    L60:
        r120.setClickable(true);
        CJPopoverLayout r121 = this.mDuxBubbleLayout;
        if (r121 != null) goto L63;
        Intrinsics.throwUninitializedPropertyAccessException("mDuxBubbleLayout");
        r121 = null;
    L63:
        r121.setOnClickListener(new ViewOnClickListenerC88961(this));
    L68:
        CJPopoverLayout r122 = this.mDuxBubbleLayout;
        if (r122 != null) goto L71;
        Intrinsics.throwUninitializedPropertyAccessException("mDuxBubbleLayout");
        r122 = null;
    L71:
        setContentView(r122);
        getContentView().measure(Integer.MIN_VALUE, Integer.MIN_VALUE);
        int r123 = Build.VERSION.SDK_INT;
        if (r123 >= 29) goto L74;
        return;
    L74:
        if (this.mShowElevationShadow == false) goto L91;
        CJPopoverLayout r124 = this.mDuxBubbleLayout;
        if (r124 != null) goto L78;
        Intrinsics.throwUninitializedPropertyAccessException("mDuxBubbleLayout");
        r124 = null;
    L78:
        CJPopoverLayout r125 = this.mDuxBubbleLayout;
        if (r125 != null) goto L81;
        Intrinsics.throwUninitializedPropertyAccessException("mDuxBubbleLayout");
        r125 = null;
    L81:
        float r126 = r125.getMWidth();
        CJPopoverLayout r127 = this.mDuxBubbleLayout;
        if (r127 != null) goto L84;
        Intrinsics.throwUninitializedPropertyAccessException("mDuxBubbleLayout");
    L85:
        r124.calculateBubbleArrowMatrix(r126, r102.getMHeight());
        setElevation(50.0f);
        this.mNeedShadow = false;
        this.mShadowRadius = 0.0f;
        getContentView().setOutlineProvider(new AnonymousClass2(this));
        if (r123 < 28) goto L88;
        getContentView().setOutlineSpotShadowColor(ColorProtector.parseColor("#8C000000"));
    L88:
        getContentView().setClipToOutline(true);
        return;
    L84:
        r102 = r127;
        goto L85
    L91:
        return;
    L64:
        CJPopoverLayout r128 = this.mDuxBubbleLayout;
        if (r128 != null) goto L67;
        Intrinsics.throwUninitializedPropertyAccessException("mDuxBubbleLayout");
        r128 = null;
    L67:
        r128.setClickable(false);
        goto L68
    L5:
        if (this.mHeight == 0) goto L10;
        r101.setDefaultWidth(getWidth());
        CJPopoverLayout r129 = this.mDuxBubbleLayout;
        if (r129 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("mDuxBubbleLayout");
        r129 = null;
    L9:
        r129.setDefaultHeight(getHeight());
        goto L10
    }

    public final int getOrientation(int r100) {
        int r101 = adaptGravity(r100);
        if (r101 != 3) goto L5;
        return 2;
    L5:
        if (r101 != 5) goto L7;
    L10:
        return 1;
    L7:
        if (r101 != 48) goto L9;
        return 3;
    L9:
        if (r101 != 80) goto L10;
        return 0;
    }

    @Deprecated(message = "这个函数只是为了dou+修一个UI问题，通常不要使用，如果使用请先联系zhangzhehua")
    public final void setAdjustHeight(int r100) {
        CJPopoverLayout r101 = this.mDuxBubbleLayout;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mDuxBubbleLayout");
        r101 = null;
    L5:
        r101.setMAdjustHeight(r100);
    }

    public final void setAlignArrowPadding(boolean r100) {
        this.mAlignArrowPadding = r100;
    }

    public final void setEnableAutoDismiss(boolean r100) {
        this.enableAutoDismiss = r100;
    }

    public final void setGravity$base_context_release(int r100) {
        CJPopoverLayout r101 = this.mDuxBubbleLayout;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mDuxBubbleLayout");
        r101 = null;
    L5:
        r101.setBubbleOrientation(getOrientation(adaptGravity(r100)));
    }

    public final void setShouldForceDismiss(boolean r100) {
        this.shouldForceDismiss = r100;
    }

    public final void setTargetLocation(Point r100) {
        Intrinsics.checkNotNullParameter(r100, "targetLocation");
        this.mTargetLocation = r100;
    }

    public final void setXOffset(int r100) {
        this.mXOffset = r100;
    }

    public final void setYOffset(int r100) {
        this.mYOffset = r100;
    }

    public static final /* synthetic */ void access$animatorEasyInOut(CJPopover r100, boolean r101) {
        r100.animatorEasyInOut(r101);
    }

    public final void setCustomAnimator(Animator r100, Animator r101) {
        Intrinsics.checkNotNullParameter(r100, "inAnimator");
        Intrinsics.checkNotNullParameter(r101, "outAnimator");
        this.customInAnimator = r100;
        this.customOutAnimator = r101;
    }

    public final void setCustomSize(int r100, int r101) {
        CJPopoverLayout r102 = this.mDuxBubbleLayout;
        if (r102 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mDuxBubbleLayout");
        r102 = null;
    L5:
        r102.setCustomSize(r100, r101);
    }

    private final void setBubblePositionAndShow(View r110, int r111, PopoverAlign r112) {
        int r100 = adaptGravity(r111);
        int[] r113 = new int[2];
        Point r101 = this.mTargetLocation;
        if (r101 == null) goto L6;
        Intrinsics.checkNotNull(r101);
        r113[0] = r101.x;
        r113[1] = r101.y;
    L9:
        int[] r114 = calTargetPosition$base_context_release$default(this, r112, r100, r110.getMeasuredWidth(), r110.getMeasuredHeight(), false, 16, null);
        if (this.mShowAsDropDown == false) goto L12;
        INVOKEVIRTUAL_com_android_ttcjpaysdk_base_ui_component_pop_CJPopover_com_obric_assistant_interaction_impl_window_helpers_PopupWindowLancet_showAsDropDown(this, r110, r114[0], r114[1] - r110.getMeasuredHeight(), 0);
        return;
    L12:
        INVOKEVIRTUAL_com_android_ttcjpaysdk_base_ui_component_pop_CJPopover_com_obric_assistant_interaction_impl_window_helpers_PopupWindowLancet_showAtLocation(this, r110, 0, r113[0] + r114[0], r113[1] + r114[1]);
        return;
    L6:
        if (this.mGetLocationInWindow == false) goto L8;
        r110.getLocationInWindow(r113);
        goto L9
    L8:
        r110.getLocationOnScreen(r113);
        goto L9
    }

    public static /* synthetic */ void setShouldForceDismiss$default(CJPopover r100, boolean r101, int r102, Object r103) {
        if ((r102 & 1) == 0) goto L5;
        r101 = true;
    L5:
        r100.setShouldForceDismiss(r101);
    }

    public final void getBubblePosition(View r100, int r101, boolean r110, Rect r111) {
        Intrinsics.checkNotNullParameter(r100, "anchor");
        Intrinsics.checkNotNullParameter(r111, "position");
        int r102 = adaptGravity(r101);
        int[] r103 = new int[2];
        Point r104 = this.mTargetLocation;
        if (r104 == null) goto L6;
        Intrinsics.checkNotNull(r104);
        r103[0] = r104.x;
        r103[1] = r104.y;
    L10:
        if (r102 != 3) goto L12;
        if (r110 == false) goto L32;
        int r105 = (r100.getMeasuredHeight() - getMeasuredHeight()) / 2;
    L33:
        r111.left = (r103[0] + this.mXOffset) - getMeasuredWidth();
        r111.right = r103[0] + this.mXOffset;
        r111.top = ((r103[1] + this.mYOffset) + r105) + CJPayBasicExtensionKt.dp(1.3f);
        r111.bottom = (((r103[1] + this.mYOffset) + r100.getHeight()) - r105) - CJPayBasicExtensionKt.dp(1.3f);
        return;
    L32:
        r105 = 0;
        goto L33
    L12:
        if (r102 != 5) goto L14;
        if (r110 == false) goto L28;
        int r106 = (r100.getMeasuredHeight() - getMeasuredHeight()) / 2;
    L29:
        r111.left = (r103[0] + this.mXOffset) + r100.getWidth();
        r111.right = ((r103[0] + this.mXOffset) + r100.getWidth()) + getMeasuredWidth();
        r111.top = ((r103[1] + this.mYOffset) + r106) + CJPayBasicExtensionKt.dp(1.3f);
        r111.bottom = (((r103[1] + this.mYOffset) + r100.getHeight()) - r106) - CJPayBasicExtensionKt.dp(1.3f);
        return;
    L28:
        r106 = 0;
        goto L29
    L14:
        if (r102 != 48) goto L16;
        if (r110 == false) goto L24;
        int r107 = (r100.getMeasuredWidth() - getMeasuredWidth()) / 2;
    L25:
        r111.left = ((r103[0] + this.mXOffset) + r107) + CJPayBasicExtensionKt.dp(1.4f);
        r111.right = (((r103[0] + this.mXOffset) + r100.getWidth()) - r107) - CJPayBasicExtensionKt.dp(1.4f);
        r111.top = ((r103[1] + this.mYOffset) - CJPayBasicExtensionKt.dp(1.3f)) - getMeasuredHeight();
        r111.bottom = (r103[1] + this.mYOffset) - CJPayBasicExtensionKt.dp(1.3f);
        return;
    L24:
        r107 = 0;
        goto L25
    L16:
        if (r102 != 80) goto L38;
        if (r110 == false) goto L20;
        int r108 = (r100.getMeasuredWidth() - getMeasuredWidth()) / 2;
    L21:
        r111.left = ((r103[0] + this.mXOffset) + r108) + CJPayBasicExtensionKt.dp(1.4f);
        r111.right = (((r103[0] + this.mXOffset) + r100.getWidth()) - r108) - CJPayBasicExtensionKt.dp(1.4f);
        r111.top = ((r103[1] + this.mYOffset) + r100.getHeight()) + CJPayBasicExtensionKt.dp(1.3f);
        r111.bottom = (((r103[1] + this.mYOffset) + r100.getHeight()) + getMeasuredHeight()) + CJPayBasicExtensionKt.dp(1.3f);
        return;
    L20:
        r108 = 0;
        goto L21
    L38:
        return;
    L6:
        if (CJWindowUtil.INSTANCE.isInHwMagicWindows(r100.getContext()) == false) goto L8;
        r100.getLocationInWindow(r103);
        goto L10
    L8:
        r100.getLocationOnScreen(r103);
        goto L10
    }

    public final void show(View r110, int r111, PopoverAlign r112, ArrowPosition r113) {
        Intrinsics.checkNotNullParameter(r112, "align");
        Intrinsics.checkNotNullParameter(r113, "arrowPosition");
        int r114 = adaptGravity(r111);
        boolean r100 = false;
        IBinder r101 = null;
        CJPopoverLayout r102 = null;
        if (this.activity.isFinishing() == true) goto L47;
        if (r110 == null) goto L47;
        if (r110.getWindowToken() == null) goto L47;
        this.mParentHeight = r110.getMeasuredHeight();
        this.mParentWidth = r110.getMeasuredWidth();
        getContentView().removeCallbacks(this.mDismissRunnable);
        this.mGravity = r114;
        CJPopoverLayout r103 = this.mDuxBubbleLayout;
        if (r103 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("mDuxBubbleLayout");
        r103 = null;
    L11:
        this.padding = r103.getPadding();
        if (isShowing() == true) goto L45;
        int r104 = getOrientation(r114);
        measure();
        if (r112 == PopoverAlign.ABSOLUT) goto L35;
        int r115 = WhenMappings.$EnumSwitchMapping$0[r113.ordinal()];
        if (r115 != 1) goto L18;
        if (r114 == 48) goto L32;
        if (r114 == 80) goto L32;
        float r116 = getMeasuredHeight();
        float r105 = CJPayBasicExtensionKt.dpF(20.0f);
    L33:
        this.mBubbleOffset = r116 - r105;
    L37:
        CJPopoverLayout r117 = this.mDuxBubbleLayout;
        if (r117 != null) goto L40;
        Intrinsics.throwUninitializedPropertyAccessException("mDuxBubbleLayout");
    L41:
        r102.setBubbleParams(r104, this.mBubbleOffset + this.mArrowOffset);
        setBubblePositionAndShow(r110, r114, r112);
        this.isAlreadyDismiss = false;
        if (this.mAutoDismissDelayMillis <= 0) goto L44;
        getContentView().postDelayed(this.mDismissRunnable, this.mAutoDismissDelayMillis);
    L44:
        this.currentShowBubbleNumbers++;
        return;
    L40:
        r102 = r117;
    L32:
        r116 = getMeasuredWidth();
        r105 = CJPayBasicExtensionKt.dpF(20.0f);
        goto L33
    L18:
        if (r115 == 2) goto L24;
        if (r115 != 3) goto L37;
        this.mBubbleOffset = CJPayBasicExtensionKt.dpF(20.0f);
        goto L37
    L24:
        if (r114 == 48) goto L27;
        if (r114 == 80) goto L27;
        int r106 = getMeasuredHeight();
    L28:
        this.mBubbleOffset = r106 / 2.0f;
    L27:
        r106 = getMeasuredWidth();
        goto L28
    L35:
        if (this.hasCome == true) goto L37;
        this.mArrowOffset += this.padding;
        this.hasCome = true;
        goto L37
    L45:
        INVOKESPECIAL_com_android_ttcjpaysdk_base_ui_component_pop_CJPopover_com_obric_assistant_interaction_impl_window_helpers_PopupWindowLancet_dismiss(this);
        return;
    L47:
        String r118 = this.TAG;
        StringBuilder r119 = new StringBuilder("illegal params: activity:");
        r119.append(this.activity.isFinishing());
        r119.append(" anchor:");
        if (r110 != null) goto L50;
        r100 = true;
    L50:
        r119.append(r100);
        r119.append(" windowToken:");
        if (r110 == null) goto L53;
        r101 = r110.getWindowToken();
    L53:
        r119.append(r101);
        CJLogger.b(r118, r119.toString());
    }

    @Override // android.widget.PopupWindow
    public void showAsDropDown(View r100, int r101, int r102, int r103) {
        INVOKESPECIAL_com_android_ttcjpaysdk_base_ui_component_pop_CJPopover_com_obric_assistant_interaction_impl_window_helpers_PopupWindowLancet_showAsDropDown(this, r100, r101, r102, adaptGravity(r103));     // Catch: Exception -> L5
        this.isAlreadyDismiss = false;     // Catch: Exception -> L5
        animatorEasyInOut(true);     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        CJBasicCommonUtils.reportCatchException("ArrowPosition#showAsDropDown", e);
        CJBasicCommonUtils.logCatch("CJCatch", "ArrowPosition#showAsDropDown", e);
    }

    @Override // android.widget.PopupWindow
    public void showAtLocation(View r100, int r101, int r102, int r103) {
        Intrinsics.checkNotNullParameter(r100, "anchor");
        INVOKESPECIAL_com_android_ttcjpaysdk_base_ui_component_pop_CJPopover_com_obric_assistant_interaction_impl_window_helpers_PopupWindowLancet_showAtLocation(this, r100, adaptGravity(r101), r102, r103);     // Catch: Exception -> L5
        this.isAlreadyDismiss = false;     // Catch: Exception -> L5
        animatorEasyInOut(true);     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        CJBasicCommonUtils.reportCatchException("ArrowPosition#showAtLocation", e);
        CJBasicCommonUtils.logCatch("CJCatch", "ArrowPosition#showAtLocation", e);
    }

    public final void show(View r100, int r101, float r110, int r111) {
        int r102 = adaptGravity(r101);
        if (r102 != 48) goto L5;
    L7:
        this.mXOffset = r111;
    L8:
        this.mArrowOffset = r110;
        show$default(this, r100, r102, PopoverAlign.ABSOLUT, null, 8, null);
        return;
    L5:
        if (r102 == 80) goto L7;
        goto L7
    }

    public static void INVOKESPECIAL_com_android_ttcjpaysdk_base_ui_component_pop_CJPopover_com_obric_assistant_interaction_impl_window_helpers_PopupWindowLancet_showAsDropDown(PopupWindow r100, View r101, int r102, int r103, int r104) {
        OverlaySource r105 = PopupWindowLancet.resolveSource(r101);
        if (PopupWindowLancet.rewriteShowAsDropDownIfNeeded(r100, r101, r105) == false) goto L5;
        return;
    L5:
        access$002(r100, r101, r102, r103, r104);
        PopupWindowLancet.trackAfterShow(r100, r105, r101);
    }

    public static void INVOKESPECIAL_com_android_ttcjpaysdk_base_ui_component_pop_CJPopover_com_obric_assistant_interaction_impl_window_helpers_PopupWindowLancet_showAtLocation(PopupWindow r100, View r101, int r102, int r110, int r111) {
        if (PopupWindowLancet.hasSubWindowToken(r101) == false) goto L6;
        return;
    L6:
        if ((r100 instanceof PopupWindow) == true) goto L8;
    L11:
        OverlaySource r103 = PopupWindowLancet.resolveSource(r101);
        if (PopupWindowLancet.rewriteDirectShowAtLocationIfNeeded(r100, r101, r103, r102, r110, r111) == false) goto L14;
        return;
    L14:
        access$001(r100, r101, r102, r110, r111);
        PopupWindowLancet.trackAfterShow(r100, r103, r101);
        return;
    L8:
        if (LandscapeChildPopupWindowBoundsAdapter.isShowAtLocationBypassTarget(r100) == false) goto L11;
        access$001(r100, r101, r102, r110, r111);
    }

    public static void INVOKEVIRTUAL_com_android_ttcjpaysdk_base_ui_component_pop_CJPopover_com_obric_assistant_interaction_impl_window_helpers_PopupWindowLancet_showAsDropDown(CJPopover r100, View r101, int r102, int r103, int r104) {
        OverlaySource r105 = PopupWindowLancet.resolveSource(r101);
        if (PopupWindowLancet.rewriteShowAsDropDownIfNeeded(r100, r101, r105) == false) goto L5;
        return;
    L5:
        r100.showAsDropDown(r101, r102, r103, r104);
        PopupWindowLancet.trackAfterShow(r100, r105, r101);
    }

    public static void INVOKEVIRTUAL_com_android_ttcjpaysdk_base_ui_component_pop_CJPopover_com_obric_assistant_interaction_impl_window_helpers_PopupWindowLancet_showAtLocation(CJPopover r100, View r101, int r102, int r110, int r111) {
        if (PopupWindowLancet.hasSubWindowToken(r101) == false) goto L6;
        return;
    L6:
        if ((r100 instanceof PopupWindow) == true) goto L8;
    L11:
        OverlaySource r103 = PopupWindowLancet.resolveSource(r101);
        if (PopupWindowLancet.rewriteDirectShowAtLocationIfNeeded(r100, r101, r103, r102, r110, r111) == false) goto L14;
        return;
    L14:
        r100.showAtLocation(r101, r102, r110, r111);
        PopupWindowLancet.trackAfterShow(r100, r103, r101);
        return;
    L8:
        if (LandscapeChildPopupWindowBoundsAdapter.isShowAtLocationBypassTarget(r100) == false) goto L11;
        r100.showAtLocation(r101, r102, r110, r111);
    }

    public final int[] calTargetPosition$base_context_release(PopoverAlign r100, int r110, int r111, int r112, boolean r113) {
        Intrinsics.checkNotNullParameter(r100, "align");
        int[] r101 = new int[2];
        if (this.mAlignArrowPadding == true) goto L5;
    L15:
        int r114 = adaptGravity(r110);
        if (r114 == 3) goto L57;
        if (r114 == 5) goto L45;
        if (r114 == 48) goto L33;
        if (r114 != 80) goto L69;
        int r102 = WhenMappings.$EnumSwitchMapping$1[r100.ordinal()];
        if (r102 == 1) goto L31;
        if (r102 == 2) goto L30;
        if (r102 == 3) goto L29;
        if (r102 == 4) goto L29;
        throw new NoWhenBranchMatchedException();
    L29:
        int r115 = 0;
    L32:
        r101[0] = this.mXOffset + r115;
        r101[1] = this.mYOffset + r112;
        goto L69
    L30:
        r115 = r111 - getMeasuredWidth();
        goto L32
    L31:
        r115 = (r111 - getMeasuredWidth()) / 2;
    L69:
        return r101;
    L33:
        int r103 = WhenMappings.$EnumSwitchMapping$1[r100.ordinal()];
        if (r103 == 1) goto L43;
        if (r103 == 2) goto L42;
        if (r103 == 3) goto L41;
        if (r103 == 4) goto L41;
        throw new NoWhenBranchMatchedException();
    L41:
        int r116 = 0;
    L44:
        r101[0] = this.mXOffset + r116;
        r101[1] = (-getMeasuredHeight()) + this.mYOffset;
        goto L69
    L42:
        r116 = r111 - getMeasuredWidth();
        goto L44
    L43:
        r116 = (r111 - getMeasuredWidth()) / 2;
        goto L44
    L45:
        int r104 = WhenMappings.$EnumSwitchMapping$1[r100.ordinal()];
        if (r104 == 1) goto L55;
        if (r104 == 2) goto L54;
        if (r104 == 3) goto L53;
        if (r104 == 4) goto L53;
        throw new NoWhenBranchMatchedException();
    L53:
        int r105 = 0;
    L56:
        r101[0] = this.mXOffset + r111;
        r101[1] = this.mYOffset + r105;
        goto L69
    L54:
        r105 = r111 - getMeasuredHeight();
        goto L56
    L55:
        r105 = (r111 - getMeasuredHeight()) / 2;
        goto L56
    L57:
        int r106 = WhenMappings.$EnumSwitchMapping$1[r100.ordinal()];
        if (r106 == 1) goto L67;
        if (r106 == 2) goto L66;
        if (r106 == 3) goto L65;
        if (r106 == 4) goto L65;
        throw new NoWhenBranchMatchedException();
    L65:
        int r117 = 0;
    L68:
        r101[0] = this.mXOffset - getMeasuredWidth();
        r101[1] = this.mYOffset + r117;
        goto L69
    L66:
        r117 = r111 - getMeasuredHeight();
        goto L68
    L67:
        r117 = (r111 - getMeasuredHeight()) / 2;
        goto L68
    L5:
        if (r100 != PopoverAlign.ABSOLUT) goto L15;
        if (r113 == true) goto L15;
        int r118 = getMGravity();
        if (r118 == 3) goto L14;
        if (r118 == 5) goto L14;
        if (r118 == 48) goto L13;
        if (r118 != 80) goto L15;
    L13:
        this.mXOffset -= getArrowHeight();
    L14:
        this.mYOffset -= getArrowHeight();
        goto L15
    }

    public final void popupAtLocation(View r100, int r101, int r102, int r103, float r104) {
        Intrinsics.checkNotNullParameter(r100, "anchor");
        int r105 = adaptGravity(r101);
        this.mGravity = r105;     // Catch: Exception -> L10
        this.mArrowOffset = r104;     // Catch: Exception -> L10
        CJPopoverLayout r106 = this.mDuxBubbleLayout;     // Catch: Exception -> L10
        if (r106 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("mDuxBubbleLayout");     // Catch: Exception -> L10
        r106 = null;
    L6:
        r106.setBubbleParams(getOrientation(r105), this.mBubbleOffset + this.mArrowOffset);     // Catch: Exception -> L10
        INVOKEVIRTUAL_com_android_ttcjpaysdk_base_ui_component_pop_CJPopover_com_obric_assistant_interaction_impl_window_helpers_PopupWindowLancet_showAtLocation(this, r100, 0, r102, r103);     // Catch: Exception -> L10
        if (this.mAutoDismissDelayMillis <= 0) goto L15;
        getContentView().postDelayed(this.mDismissRunnable, this.mAutoDismissDelayMillis);     // Catch: Exception -> L10
        return;
    L15:
        return;
    L10:
        e = move-exception;
        CJBasicCommonUtils.reportCatchException("ArrowPosition#popupAtLocation", e);
        CJBasicCommonUtils.logCatch("CJCatch", "ArrowPosition#popupAtLocation", e);
    }

    public final void show(View r100, int r101, boolean r110, float r111, int r112, int r113) {
        int r102 = adaptGravity(r101);
        this.mXOffset = r112;
        this.mYOffset = r113;
        this.mArrowOffset = r111;
        if (r110 == false) goto L5;
        PopoverAlign r103 = PopoverAlign.MIDDLE;
    L6:
        show$default(this, r100, r102, r103, null, 8, null);
        return;
    L5:
        r103 = PopoverAlign.ABSOLUT;
        goto L6
    }

    public static /* synthetic */ void show$default(CJPopover r100, View r101, int r102, PopoverAlign r103, ArrowPosition r104, int r105, Object r106) {
        if ((r105 & 8) == 0) goto L5;
        r104 = ArrowPosition.CENTER;
    L5:
        r100.show(r101, r102, r103, r104);
    }

    public final void show(View r100, int r101, PopoverAlign r102, ArrowPosition r103, float r104, int r105, int r106) {
        Intrinsics.checkNotNullParameter(r102, "align");
        Intrinsics.checkNotNullParameter(r103, "arrowPosition");
        int r107 = adaptGravity(r101);
        this.mXOffset = r105;
        this.mYOffset = r106;
        this.mArrowOffset = r104;
        show(r100, r107, r102, r103);
    }

    public static /* synthetic */ int[] calTargetPosition$base_context_release$default(CJPopover r100, PopoverAlign r101, int r102, int r103, int r110, boolean r111, int r112, Object r113) {
        if ((r112 & 16) == 0) goto L5;
        boolean r104 = false;
    L7:
        return r100.calTargetPosition$base_context_release(r101, r102, r103, r110, r104);
    L5:
        r104 = r111;
        goto L7
    }

    public static /* synthetic */ void show$default(CJPopover r100, View r110, int r111, PopoverAlign r112, ArrowPosition r113, float r114, int r115, int r116, int r117, Object r118) {
        if ((r117 & 8) == 0) goto L5;
        ArrowPosition r101 = ArrowPosition.CENTER;
    L6:
        r100.show(r110, r111, r112, r101, r114, r115, r116);
        return;
    L5:
        r101 = r113;
        goto L6
    }
}
