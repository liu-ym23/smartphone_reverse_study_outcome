package com.obric.oui.popover.v2;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.os.IBinder;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.animation.PathInterpolator;
import android.widget.FrameLayout;
import android.widget.PopupWindow;
import androidx.core.content.ContextCompat;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewGroupKt;
import com.GlobalProxyLancet;
import com.bytedance.apm.constant.PerfConsts;
import com.bytedance.framwork.core.sdklib.DBHelper;
import com.obric.common.oui.R;
import com.obric.oui.animation.easy.ViewPropertySpringAnimator;
import com.obric.oui.animation.easy.ViewPropertySpringAnimatorExtKt;
import com.obric.oui.animation.engine.DynamicAnimation;
import com.obric.oui.animation.engine.FloatPropertyCompat;
import com.obric.oui.common.style.OUILayoutHelper;
import com.obric.oui.common.style.Shadow;
import com.obric.oui.common.util.OUnitExtensionKt;
import com.obric.oui.material.MaterialConfig;
import com.obric.oui.material.MaterialConfigFormatNames;
import com.obric.oui.material.MaterialToken;
import com.obric.oui.popover.SingleChildFrameLayout;
import com.obric.oui.popover.menu.OPopoverMenuView;
import com.obric.oui.utils.AnimUtils;
import com.obric.oui.utils.KtExt;
import com.obric.oui.utils.ViewUtil;
import com.obric.oui.utils.log.L;
import com.obric.oui.window.OWindowConfigController;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: OPopover.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u009c\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b:\b\u0016\u0018\u0000 \u008a\u00012\u00020\u0001:\f\u0088\u0001\u0089\u0001\u008a\u0001\u008b\u0001\u008c\u0001\u008d\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J$\u0010N\u001a\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u00180O2\u0006\u0010P\u001a\u00020\u00182\u0006\u0010Q\u001a\u00020\u0018H\u0003J$\u0010R\u001a\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u00180O2\u0006\u0010P\u001a\u00020\u00182\u0006\u0010Q\u001a\u00020\u0018H\u0002J\b\u0010S\u001a\u00020TH\u0002J\u0010\u0010U\u001a\u00020T2\u0006\u0010V\u001a\u00020\u0013H\u0003J\b\u0010W\u001a\u00020TH\u0002J\b\u0010X\u001a\u00020TH\u0002J\b\u0010Y\u001a\u00020TH\u0016J\u0006\u0010Z\u001a\u00020TJ\r\u0010[\u001a\u00020\u0018H\u0000¢\u0006\u0002\b\\J\b\u0010]\u001a\u00020\bH\u0002J\u0006\u0010^\u001a\u00020\u001bJ\u0006\u0010_\u001a\u00020\u0018J\u0006\u0010`\u001a\u00020\u0018J\u0006\u0010a\u001a\u00020\fJ\b\u0010b\u001a\u00020TH\u0002J\b\u0010c\u001a\u00020TH\u0002J\u0010\u0010d\u001a\u00020\u00132\u0006\u0010e\u001a\u00020\fH\u0002J\b\u0010f\u001a\u00020TH\u0002J\u0006\u0010g\u001a\u00020TJ\b\u0010h\u001a\u00020TH\u0002J\u0012\u0010i\u001a\u00020\b2\b\b\u0001\u0010j\u001a\u00020\u0018H\u0002J\u0012\u0010k\u001a\u00020T2\b\u0010l\u001a\u0004\u0018\u00010\fH\u0002J\u0016\u0010m\u001a\u00020T2\u0006\u0010n\u001a\u00020\u00102\u0006\u0010o\u001a\u00020\u0010J\u000e\u0010p\u001a\u00020T2\u0006\u0010q\u001a\u00020\u0013J\u000e\u0010r\u001a\u00020T2\u0006\u0010s\u001a\u00020\u0013J\u000e\u0010t\u001a\u00020T2\u0006\u0010u\u001a\u00020\u0018J\u000e\u0010v\u001a\u00020T2\u0006\u0010w\u001a\u00020\u0013J\u000e\u0010x\u001a\u00020T2\u0006\u0010y\u001a\u00020\u0018J\u0018\u0010z\u001a\u00020T2\u0006\u0010l\u001a\u00020\f2\u0006\u0010y\u001a\u00020\u0018H\u0002J\u000e\u0010{\u001a\u00020T2\u0006\u0010|\u001a\u00020\"J\u000e\u0010}\u001a\u00020T2\u0006\u0010|\u001a\u00020:J\u000e\u0010~\u001a\u00020T2\u0006\u0010|\u001a\u00020AJ\u000f\u0010\u007f\u001a\u00020T2\u0007\u0010\u0080\u0001\u001a\u00020\u0018J\u0010\u0010\u0081\u0001\u001a\u00020T2\u0007\u0010\u0082\u0001\u001a\u00020\u0018J-\u0010\u0083\u0001\u001a\u00020T2\b\u0010e\u001a\u0004\u0018\u00010\f2\u0007\u0010\u0084\u0001\u001a\u00020\u00182\u0007\u0010\u0085\u0001\u001a\u00020\u00182\u0006\u0010u\u001a\u00020\u0018H\u0016J)\u0010\u0086\u0001\u001a\u00020T2\u0006\u0010e\u001a\u00020\f2\u0006\u0010u\u001a\u00020\u00182\u0006\u0010P\u001a\u00020\u00182\u0006\u0010Q\u001a\u00020\u0018H\u0016J\t\u0010\u0087\u0001\u001a\u00020TH\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0015\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0016R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010!\u001a\u0004\u0018\u00010\"X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020$X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010)\u001a\u00020\u00188BX\u0082\u000e¢\u0006\b\n\u0000\u001a\u0004\b*\u0010+R\u000e\u0010,\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R \u0010/\u001a\u0014\u0012\u0004\u0012\u00020\u0013\u0012\n\u0012\b\u0012\u0004\u0012\u0002020100X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00103\u001a\u000204X\u0082.¢\u0006\u0002\n\u0000R\u000e\u00105\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00106\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00107\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u00108\u001a\u00020\u00188\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u0010\u00109\u001a\u0004\u0018\u00010:X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010;\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010<\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010=\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010>\u001a\u00020\u00188\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u000e\u0010?\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010@\u001a\u0004\u0018\u00010AX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010B\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010C\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010D\u001a\u00020EX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010F\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010G\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010H\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010I\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010J\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010K\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010L\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010M\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u008e\u0001"}, d2 = {"Lcom/obric/oui/popover/v2/OPopover;", "Landroid/widget/PopupWindow;", "builder", "Lcom/obric/oui/popover/v2/OPopover$Builder;", "(Lcom/obric/oui/popover/v2/OPopover$Builder;)V", "activity", "Landroid/app/Activity;", "anchorCenterX", "", "anchorCenterY", "animFloatP", "Lcom/obric/oui/animation/engine/FloatPropertyCompat;", "Landroid/view/View;", "animSet", "Landroid/animation/AnimatorSet;", "customInAnimator", "Landroid/animation/Animator;", "customOutAnimator", "enableAutoDismiss", "", "isAlreadyDismiss", "isHideVirtualKey", "Ljava/lang/Boolean;", "mAnchorViewHeight", "", "mAnchorViewWidth", "mAnimTime", "", "mAutoDismissDelayMillis", "mBgColor", "mBorderColor", "mBorderWidth", "mCoverPreviousWhenStacked", "mDismissListener", "Lcom/obric/oui/popover/v2/OPopover$OnBubbleDismissListener;", "mDismissRunnable", "Ljava/lang/Runnable;", "mDisplayOrientation", "mEnableBubbleMaterial", "mFocusable", "mGetLocationInWindow", "mGravity", "getMGravity", "()I", "mHeight", "mIsFirstShow", "mIsShowInDialog", "mMaterials", "Lkotlin/Function1;", "", "Lcom/obric/oui/material/MaterialConfig;", "mOBubbleLayout", "Lcom/obric/oui/popover/v2/OPopoverLayout;", "mOutsideTouchable", "mShadowEnabled", "mShadowSpaceTop", "mShadowStyle", "mShowListener", "Lcom/obric/oui/popover/v2/OPopover$OnBubbleShowListener;", "mShowWithAnimation", "mSpacingForShadow", "mStackAlphaPrevious", "mStackCoverColor", "mStackScalePrevious", "mStartDismissListener", "Lcom/obric/oui/popover/v2/OPopover$OnBubbleStartDismissListener;", "mView", "mWidth", "mWindowFrame", "Landroid/view/ViewGroup;", "mXOffset", "mYOffset", "popupOriginX", "popupOriginY", "pushedToStack", "removedFromStack", "transparentBg", "useWindowCoords", "addShadowFrame", "Lkotlin/Pair;", MaterialConfigFormatNames.X, MaterialConfigFormatNames.Y, "addShadowFrameIfNeeded", "afterShowInStackIfNeeded", "", "animatorEasyInOut", "isIn", "beforeShowInStackIfNeeded", "clearFakeAnchorViewIfNecessary", "dismiss", "dismissDirectly", "getDisplayRotationDegrees", "getDisplayRotationDegrees$OUI_standardRelease", "getElevationPx", "getInAnimTime", "getMeasuredHeight", "getMeasuredWidth", "getPopoverView", "hideSystemUi", "initContentView", "isAnchorFromPopupWindow", "anchor", "measure", "onDestroy", "onDestroyInStackIfNeeded", "resolveShadowSpace", "shadowStyleRes", "setBubbleLayout", "view", "setCustomAnimator", "inAnimator", "outAnimator", "setEnableAutoDismiss", "value", "setGetLocationInWindow", "getLocationInWindow", "setGravity", "gravity", "setIsShowInDialog", "isShowInDialog", "setMaxContentHeight", "maxHeight", "setMaxContentHeightIfPossible", "setOnDismissListener", "listener", "setOnShowListener", "setOnStartDismissListener", "setXOffset", "xOffset", "setYOffset", "yOffset", "showAsDropDown", "xoff", "yoff", "showAtLocation", "showDirectly", "Builder", "CommonFloatProperty", "Companion", "OnBubbleDismissListener", "OnBubbleShowListener", "OnBubbleStartDismissListener", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public class OPopover extends PopupWindow {
    public static final Companion Companion = null;
    private static final String TAG = "OPopover";
    private static final List<WeakReference<OPopover>> popoverStack = null;
    private static boolean shouldForceDismiss;
    private Activity activity;
    private float anchorCenterX;
    private float anchorCenterY;
    private final FloatPropertyCompat<View> animFloatP;
    private AnimatorSet animSet;
    private Animator customInAnimator;
    private Animator customOutAnimator;
    private boolean enableAutoDismiss;
    private boolean isAlreadyDismiss;
    private Boolean isHideVirtualKey;
    private int mAnchorViewHeight;
    private int mAnchorViewWidth;
    private long mAnimTime;
    private long mAutoDismissDelayMillis;
    private int mBgColor;
    private int mBorderColor;
    private int mBorderWidth;
    private boolean mCoverPreviousWhenStacked;
    private OnBubbleDismissListener mDismissListener;
    private final Runnable mDismissRunnable;
    private int mDisplayOrientation;
    private boolean mEnableBubbleMaterial;
    private boolean mFocusable;
    private boolean mGetLocationInWindow;
    private int mGravity;
    private int mHeight;
    private boolean mIsFirstShow;
    private boolean mIsShowInDialog;
    private Function1<? super Boolean, MaterialConfig[]> mMaterials;
    private OPopoverLayout mOBubbleLayout;
    private boolean mOutsideTouchable;
    private boolean mShadowEnabled;
    private int mShadowSpaceTop;
    private int mShadowStyle;
    private OnBubbleShowListener mShowListener;
    private boolean mShowWithAnimation;
    private boolean mSpacingForShadow;
    private float mStackAlphaPrevious;
    private int mStackCoverColor;
    private float mStackScalePrevious;
    private OnBubbleStartDismissListener mStartDismissListener;
    private View mView;
    private int mWidth;
    private ViewGroup mWindowFrame;
    private int mXOffset;
    private int mYOffset;
    private int popupOriginX;
    private int popupOriginY;
    private boolean pushedToStack;
    private boolean removedFromStack;
    private boolean transparentBg;
    private boolean useWindowCoords;

    /* JADX INFO: compiled from: OPopover.kt */
    @Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0007\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b-\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0007\u0010\u007f\u001a\u00030\u0080\u0001J\u0010\u0010\u0081\u0001\u001a\u00020\u00002\u0007\u0010\u0082\u0001\u001a\u00020\tJ\u0010\u0010\u0083\u0001\u001a\u00020\u00002\u0007\u0010\u0082\u0001\u001a\u00020\tJ\u0012\u0010\u0084\u0001\u001a\u00020\u00002\t\b\u0001\u0010\u0085\u0001\u001a\u00020\u0012J\u0010\u0010\u0086\u0001\u001a\u00020\u00002\u0007\u0010\u0087\u0001\u001a\u00020\u0012J\u0010\u0010\u0088\u0001\u001a\u00020\u00002\u0007\u0010\u0089\u0001\u001a\u00020\u0012J\u0010\u0010\u008a\u0001\u001a\u00020\u00002\u0007\u0010\u008b\u0001\u001a\u00020\u001eJ\u0010\u0010\u008c\u0001\u001a\u00020\u00002\u0007\u0010\u008d\u0001\u001a\u00020\u0012J\u0010\u0010\u008e\u0001\u001a\u00020\u00002\u0007\u0010\u008f\u0001\u001a\u00020\u001eJ\u0010\u0010\u0090\u0001\u001a\u00020\u00002\u0007\u0010\u0091\u0001\u001a\u00020\u001eJ\u0010\u0010\u0092\u0001\u001a\u00020\u00002\u0007\u0010\u0093\u0001\u001a\u00020\u001eJ\u0010\u0010\u0094\u0001\u001a\u00020\u00002\u0007\u0010\u0095\u0001\u001a\u00020\u001eJ\"\u0010\u0096\u0001\u001a\u00020\u00002\u0019\u0010\u0097\u0001\u001a\u0014\u0012\u0004\u0012\u00020\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020A0@0?J\u0010\u0010\u0098\u0001\u001a\u00020\u00002\u0007\u0010\u0099\u0001\u001a\u00020$J\u0010\u0010\u009a\u0001\u001a\u00020\u00002\u0007\u0010\u0099\u0001\u001a\u00020MJ\u0010\u0010\u009b\u0001\u001a\u00020\u00002\u0007\u0010\u0099\u0001\u001a\u00020eJ\u0010\u0010\u009c\u0001\u001a\u00020\u00002\u0007\u0010\u009d\u0001\u001a\u00020\u001eJ\u0010\u0010\u009e\u0001\u001a\u00020\u00002\u0007\u0010\u008b\u0001\u001a\u00020\u001eJ\u0011\u0010{\u001a\u00020\u00002\t\b\u0001\u0010\u009f\u0001\u001a\u00020\u0012J\u0010\u0010 \u0001\u001a\u00020\u00002\u0007\u0010¡\u0001\u001a\u00020\u001eJ\u0010\u0010¢\u0001\u001a\u00020\u00002\u0007\u0010£\u0001\u001a\u00020\u001eJ\u0012\u0010¤\u0001\u001a\u00020\u00002\t\b\u0001\u0010\u0085\u0001\u001a\u00020\u0012J\u0010\u0010¥\u0001\u001a\u00020\u00002\u0007\u0010¦\u0001\u001a\u00020YJ\u0010\u0010§\u0001\u001a\u00020\u00002\u0007\u0010¨\u0001\u001a\u00020kJ\u0010\u0010©\u0001\u001a\u00020\u00002\u0007\u0010ª\u0001\u001a\u00020\u0012J\u0010\u0010«\u0001\u001a\u00020\u00002\u0007\u0010ª\u0001\u001a\u00020\u0012J\u000f\u0010|\u001a\u00020\u00002\u0007\u0010¬\u0001\u001a\u00020\u001eR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\u0004R\u001a\u0010\b\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u000b\"\u0004\b\u0010\u0010\rR\u001a\u0010\u0011\u001a\u00020\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0017\u001a\u00020\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0014\"\u0004\b\u0019\u0010\u0016R\u001a\u0010\u001a\u001a\u00020\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0014\"\u0004\b\u001c\u0010\u0016R\u001a\u0010\u001d\u001a\u00020\u001eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001c\u0010#\u001a\u0004\u0018\u00010$X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u001a\u0010)\u001a\u00020\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010\u0014\"\u0004\b+\u0010\u0016R\u001a\u0010,\u001a\u00020\u001eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010 \"\u0004\b.\u0010\"R\u001a\u0010/\u001a\u00020\u001eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u0010 \"\u0004\b1\u0010\"R\u001a\u00102\u001a\u00020\u001eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u0010 \"\u0004\b4\u0010\"R\u001a\u00105\u001a\u00020\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b6\u0010\u0014\"\u0004\b7\u0010\u0016R\u001a\u00108\u001a\u00020\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b9\u0010\u0014\"\u0004\b:\u0010\u0016R\u001a\u0010;\u001a\u00020\u001eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b<\u0010 \"\u0004\b=\u0010\"R,\u0010>\u001a\u0014\u0012\u0004\u0012\u00020\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020A0@0?X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bB\u0010C\"\u0004\bD\u0010ER\u001a\u0010F\u001a\u00020\u001eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bG\u0010 \"\u0004\bH\u0010\"R\u001a\u0010I\u001a\u00020\u001eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bJ\u0010 \"\u0004\bK\u0010\"R\u001c\u0010L\u001a\u0004\u0018\u00010MX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bN\u0010O\"\u0004\bP\u0010QR\u001a\u0010R\u001a\u00020\u001eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bS\u0010 \"\u0004\bT\u0010\"R\u001a\u0010U\u001a\u00020\u001eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bV\u0010 \"\u0004\bW\u0010\"R\u001a\u0010X\u001a\u00020YX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bZ\u0010[\"\u0004\b\\\u0010]R\u001e\u0010^\u001a\u00020\u00128\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b_\u0010\u0014\"\u0004\b`\u0010\u0016R\u001a\u0010a\u001a\u00020YX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bb\u0010[\"\u0004\bc\u0010]R\u001c\u0010d\u001a\u0004\u0018\u00010eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bf\u0010g\"\u0004\bh\u0010iR\u001c\u0010j\u001a\u0004\u0018\u00010kX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bl\u0010m\"\u0004\bn\u0010oR\u001a\u0010p\u001a\u00020\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bq\u0010\u0014\"\u0004\br\u0010\u0016R\u001a\u0010s\u001a\u00020\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bt\u0010\u0014\"\u0004\bu\u0010\u0016R\u001a\u0010v\u001a\u00020\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bw\u0010\u0014\"\u0004\bx\u0010\u0016R\u001e\u0010y\u001a\u00020\u00128\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bz\u0010\u0014\"\u0004\b{\u0010\u0016R\u001a\u0010|\u001a\u00020\u001eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b}\u0010 \"\u0004\b~\u0010\"¨\u0006\u00ad\u0001"}, d2 = {"Lcom/obric/oui/popover/v2/OPopover$Builder;", "", "activity", "Landroid/app/Activity;", "(Landroid/app/Activity;)V", "getActivity", "()Landroid/app/Activity;", "setActivity", "mAnimTime", "", "getMAnimTime", "()J", "setMAnimTime", "(J)V", "mAutoDismissDelayMillis", "getMAutoDismissDelayMillis", "setMAutoDismissDelayMillis", "mBgColor", "", "getMBgColor", "()I", "setMBgColor", "(I)V", "mBorderColor", "getMBorderColor", "setMBorderColor", "mBorderWidth", "getMBorderWidth", "setMBorderWidth", "mCoverPreviousWhenStacked", "", "getMCoverPreviousWhenStacked", "()Z", "setMCoverPreviousWhenStacked", "(Z)V", "mDismissListener", "Lcom/obric/oui/popover/v2/OPopover$OnBubbleDismissListener;", "getMDismissListener", "()Lcom/obric/oui/popover/v2/OPopover$OnBubbleDismissListener;", "setMDismissListener", "(Lcom/obric/oui/popover/v2/OPopover$OnBubbleDismissListener;)V", "mDisplayOrientation", "getMDisplayOrientation", "setMDisplayOrientation", "mEnableBubbleMaterial", "getMEnableBubbleMaterial", "setMEnableBubbleMaterial", "mFocusable", "getMFocusable", "setMFocusable", "mGetLocationInWindow", "getMGetLocationInWindow", "setMGetLocationInWindow", "mGravity", "getMGravity", "setMGravity", "mHeight", "getMHeight", "setMHeight", "mHideVirtualKey", "getMHideVirtualKey", "setMHideVirtualKey", "mMaterials", "Lkotlin/Function1;", "", "Lcom/obric/oui/material/MaterialConfig;", "getMMaterials", "()Lkotlin/jvm/functions/Function1;", "setMMaterials", "(Lkotlin/jvm/functions/Function1;)V", "mOutsideTouchable", "getMOutsideTouchable", "setMOutsideTouchable", "mShadowEnabled", "getMShadowEnabled", "setMShadowEnabled", "mShowListener", "Lcom/obric/oui/popover/v2/OPopover$OnBubbleShowListener;", "getMShowListener", "()Lcom/obric/oui/popover/v2/OPopover$OnBubbleShowListener;", "setMShowListener", "(Lcom/obric/oui/popover/v2/OPopover$OnBubbleShowListener;)V", "mShowWithAnimation", "getMShowWithAnimation", "setMShowWithAnimation", "mSpacingForShadow", "getMSpacingForShadow", "setMSpacingForShadow", "mStackAlphaPrevious", "", "getMStackAlphaPrevious", "()F", "setMStackAlphaPrevious", "(F)V", "mStackCoverColor", "getMStackCoverColor", "setMStackCoverColor", "mStackScalePrevious", "getMStackScalePrevious", "setMStackScalePrevious", "mStartDismissListener", "Lcom/obric/oui/popover/v2/OPopover$OnBubbleStartDismissListener;", "getMStartDismissListener", "()Lcom/obric/oui/popover/v2/OPopover$OnBubbleStartDismissListener;", "setMStartDismissListener", "(Lcom/obric/oui/popover/v2/OPopover$OnBubbleStartDismissListener;)V", "mView", "Landroid/view/View;", "getMView", "()Landroid/view/View;", "setMView", "(Landroid/view/View;)V", "mWidth", "getMWidth", "setMWidth", "mXOffset", "getMXOffset", "setMXOffset", "mYOffset", "getMYOffset", "setMYOffset", "shadowStyle", "getShadowStyle", "setShadowStyle", "transparentBg", "getTransparentBg", "setTransparentBg", "build", "Lcom/obric/oui/popover/v2/OPopover;", "setAnimTime", DBHelper.COL_TIME, "setAutoDismissDelayMillis", "setBgColor", "color", "setBorderColor", "borderColor", "setBorderWidth", "borderWidth", "setCoverPreviousWhenStacked", "enabled", "setDisplayOrientation", "orientation", "setEnableBubbleMaterial", "enable", "setFocusable", "focusable", "setGetLocationInWindow", "getLocationInWindow", "setHideVirtualKey", "hide", "setMaterials", "materials", "setOnDismissListener", "listener", "setOnShowListener", "setOnStartDismissListener", "setOutSideTouchable", "touchable", "setPopoverShadowEnabled", "shadowStyleRes", "setShowWithAnim", "withAnim", "setSpacingForShadow", "spacingForShadow", "setStackCoverColor", "setStackScalePrevious", "scale", "setView", "view", "setXOffset", "offset", "setYOffset", "transparent", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Builder {
        private Activity activity;
        private long mAnimTime;
        private long mAutoDismissDelayMillis;
        private int mBgColor;
        private int mBorderColor;
        private int mBorderWidth;
        private boolean mCoverPreviousWhenStacked;
        private OnBubbleDismissListener mDismissListener;
        private int mDisplayOrientation;
        private boolean mEnableBubbleMaterial;
        private boolean mFocusable;
        private boolean mGetLocationInWindow;
        private int mGravity;
        private int mHeight;
        private boolean mHideVirtualKey;
        private Function1<? super Boolean, MaterialConfig[]> mMaterials;
        private boolean mOutsideTouchable;
        private boolean mShadowEnabled;
        private OnBubbleShowListener mShowListener;
        private boolean mShowWithAnimation;
        private boolean mSpacingForShadow;
        private float mStackAlphaPrevious;
        private int mStackCoverColor;
        private float mStackScalePrevious;
        private OnBubbleStartDismissListener mStartDismissListener;
        private View mView;
        private int mWidth;
        private int mXOffset;
        private int mYOffset;
        private int shadowStyle;
        private boolean transparentBg;

        public Builder(Activity r3) {
            Intrinsics.checkNotNullParameter(r3, "activity");
            this.activity = r3;
            this.mBgColor = ContextCompat.getColor(r3, R.color.oui_toast_background);
            this.mAnimTime = 800;
            this.mAutoDismissDelayMillis = Long.MIN_VALUE;
            this.mOutsideTouchable = true;
            this.mShowWithAnimation = true;
            this.mShadowEnabled = true;
            this.shadowStyle = R.style.OUIShadow_3;
            this.mEnableBubbleMaterial = true;
            this.mMaterials = MaterialToken.OUI_Bg_Popup;
            this.mCoverPreviousWhenStacked = true;
            this.mStackCoverColor = Color.parseColor("#08000000");
            this.mStackAlphaPrevious = 0.3f;
            this.mStackScalePrevious = 0.98f;
        }

        public final Activity getActivity() {
            return this.activity;
        }

        public final void setActivity(Activity r2) {
            Intrinsics.checkNotNullParameter(r2, "<set-?>");
            this.activity = r2;
        }

        public final boolean getMFocusable() {
            return this.mFocusable;
        }

        public final void setMFocusable(boolean r1) {
            this.mFocusable = r1;
        }

        public final int getMGravity() {
            return this.mGravity;
        }

        public final void setMGravity(int r1) {
            this.mGravity = r1;
        }

        public final int getMDisplayOrientation() {
            return this.mDisplayOrientation;
        }

        public final void setMDisplayOrientation(int r1) {
            this.mDisplayOrientation = r1;
        }

        public final int getMBgColor() {
            return this.mBgColor;
        }

        public final void setMBgColor(int r1) {
            this.mBgColor = r1;
        }

        public final boolean getMHideVirtualKey() {
            return this.mHideVirtualKey;
        }

        public final void setMHideVirtualKey(boolean r1) {
            this.mHideVirtualKey = r1;
        }

        public final int getMXOffset() {
            return this.mXOffset;
        }

        public final void setMXOffset(int r1) {
            this.mXOffset = r1;
        }

        public final int getMYOffset() {
            return this.mYOffset;
        }

        public final void setMYOffset(int r1) {
            this.mYOffset = r1;
        }

        public final long getMAnimTime() {
            return this.mAnimTime;
        }

        public final void setMAnimTime(long r1) {
            this.mAnimTime = r1;
        }

        public final long getMAutoDismissDelayMillis() {
            return this.mAutoDismissDelayMillis;
        }

        public final void setMAutoDismissDelayMillis(long r1) {
            this.mAutoDismissDelayMillis = r1;
        }

        public final View getMView() {
            return this.mView;
        }

        public final void setMView(View r1) {
            this.mView = r1;
        }

        public final int getMWidth() {
            return this.mWidth;
        }

        public final void setMWidth(int r1) {
            this.mWidth = r1;
        }

        public final int getMHeight() {
            return this.mHeight;
        }

        public final void setMHeight(int r1) {
            this.mHeight = r1;
        }

        public final OnBubbleStartDismissListener getMStartDismissListener() {
            return this.mStartDismissListener;
        }

        public final void setMStartDismissListener(OnBubbleStartDismissListener r1) {
            this.mStartDismissListener = r1;
        }

        public final OnBubbleDismissListener getMDismissListener() {
            return this.mDismissListener;
        }

        public final void setMDismissListener(OnBubbleDismissListener r1) {
            this.mDismissListener = r1;
        }

        public final OnBubbleShowListener getMShowListener() {
            return this.mShowListener;
        }

        public final void setMShowListener(OnBubbleShowListener r1) {
            this.mShowListener = r1;
        }

        public final boolean getMOutsideTouchable() {
            return this.mOutsideTouchable;
        }

        public final void setMOutsideTouchable(boolean r1) {
            this.mOutsideTouchable = r1;
        }

        public final boolean getMGetLocationInWindow() {
            return this.mGetLocationInWindow;
        }

        public final void setMGetLocationInWindow(boolean r1) {
            this.mGetLocationInWindow = r1;
        }

        public final int getMBorderWidth() {
            return this.mBorderWidth;
        }

        public final void setMBorderWidth(int r1) {
            this.mBorderWidth = r1;
        }

        public final int getMBorderColor() {
            return this.mBorderColor;
        }

        public final void setMBorderColor(int r1) {
            this.mBorderColor = r1;
        }

        public final boolean getTransparentBg() {
            return this.transparentBg;
        }

        public final void setTransparentBg(boolean r1) {
            this.transparentBg = r1;
        }

        public final boolean getMShowWithAnimation() {
            return this.mShowWithAnimation;
        }

        public final void setMShowWithAnimation(boolean r1) {
            this.mShowWithAnimation = r1;
        }

        public final boolean getMShadowEnabled() {
            return this.mShadowEnabled;
        }

        public final void setMShadowEnabled(boolean r1) {
            this.mShadowEnabled = r1;
        }

        public final int getShadowStyle() {
            return this.shadowStyle;
        }

        /* JADX INFO: renamed from: setShadowStyle, reason: collision with other method in class */
        public final void m616setShadowStyle(int r1) {
            this.shadowStyle = r1;
        }

        public final boolean getMSpacingForShadow() {
            return this.mSpacingForShadow;
        }

        public final void setMSpacingForShadow(boolean r1) {
            this.mSpacingForShadow = r1;
        }

        public final boolean getMEnableBubbleMaterial() {
            return this.mEnableBubbleMaterial;
        }

        public final void setMEnableBubbleMaterial(boolean r1) {
            this.mEnableBubbleMaterial = r1;
        }

        public final Function1<Boolean, MaterialConfig[]> getMMaterials() {
            return this.mMaterials;
        }

        public final void setMMaterials(Function1<? super Boolean, MaterialConfig[]> r2) {
            Intrinsics.checkNotNullParameter(r2, "<set-?>");
            this.mMaterials = r2;
        }

        public final boolean getMCoverPreviousWhenStacked() {
            return this.mCoverPreviousWhenStacked;
        }

        public final void setMCoverPreviousWhenStacked(boolean r1) {
            this.mCoverPreviousWhenStacked = r1;
        }

        public final int getMStackCoverColor() {
            return this.mStackCoverColor;
        }

        public final void setMStackCoverColor(int r1) {
            this.mStackCoverColor = r1;
        }

        public final float getMStackAlphaPrevious() {
            return this.mStackAlphaPrevious;
        }

        public final void setMStackAlphaPrevious(float r1) {
            this.mStackAlphaPrevious = r1;
        }

        public final float getMStackScalePrevious() {
            return this.mStackScalePrevious;
        }

        public final void setMStackScalePrevious(float r1) {
            this.mStackScalePrevious = r1;
        }

        public final Builder setDisplayOrientation(int r1) {
            this.mDisplayOrientation = r1;
            return this;
        }

        public final Builder setFocusable(boolean r1) {
            this.mFocusable = r1;
            return this;
        }

        public final Builder setOutSideTouchable(boolean r1) {
            this.mOutsideTouchable = r1;
            return this;
        }

        public final Builder setBorderColor(int r1) {
            this.mBorderColor = r1;
            return this;
        }

        public final Builder setBorderWidth(int r1) {
            this.mBorderWidth = r1;
            return this;
        }

        public final Builder setOnShowListener(OnBubbleShowListener r2) {
            Intrinsics.checkNotNullParameter(r2, "listener");
            this.mShowListener = r2;
            return this;
        }

        public final Builder setOnStartDismissListener(OnBubbleStartDismissListener r2) {
            Intrinsics.checkNotNullParameter(r2, "listener");
            this.mStartDismissListener = r2;
            return this;
        }

        public final Builder setOnDismissListener(OnBubbleDismissListener r2) {
            Intrinsics.checkNotNullParameter(r2, "listener");
            this.mDismissListener = r2;
            return this;
        }

        public final Builder setShowWithAnim(boolean r1) {
            this.mShowWithAnimation = r1;
            return this;
        }

        public final Builder setPopoverShadowEnabled(boolean r1) {
            this.mShadowEnabled = r1;
            return this;
        }

        public final Builder setShadowStyle(int r1) {
            this.shadowStyle = r1;
            return this;
        }

        public final Builder setCoverPreviousWhenStacked(boolean r1) {
            this.mCoverPreviousWhenStacked = r1;
            return this;
        }

        public final Builder setStackCoverColor(int r1) {
            this.mStackCoverColor = r1;
            return this;
        }

        public final Builder setStackScalePrevious(float r1) {
            this.mStackScalePrevious = r1;
            return this;
        }

        public final Builder setBgColor(int r1) {
            this.mBgColor = r1;
            return this;
        }

        public final Builder setHideVirtualKey(boolean r1) {
            this.mHideVirtualKey = r1;
            return this;
        }

        public final Builder setXOffset(int r1) {
            this.mXOffset = r1;
            return this;
        }

        public final Builder setYOffset(int r1) {
            this.mYOffset = r1;
            return this;
        }

        public final Builder setAnimTime(long r1) {
            this.mAnimTime = r1;
            return this;
        }

        public final Builder setAutoDismissDelayMillis(long r1) {
            this.mAutoDismissDelayMillis = r1;
            return this;
        }

        public final Builder setView(View r2) {
            Intrinsics.checkNotNullParameter(r2, "view");
            this.mView = r2;
            return this;
        }

        public final Builder setGetLocationInWindow(boolean r1) {
            this.mGetLocationInWindow = r1;
            return this;
        }

        public final Builder setSpacingForShadow(boolean r1) {
            this.mSpacingForShadow = r1;
            return this;
        }

        public final Builder transparentBg(boolean r1) {
            this.transparentBg = r1;
            return this;
        }

        public final Builder setEnableBubbleMaterial(boolean r1) {
            this.mEnableBubbleMaterial = r1;
            return this;
        }

        public final Builder setMaterials(Function1<? super Boolean, MaterialConfig[]> r2) {
            Intrinsics.checkNotNullParameter(r2, "materials");
            this.mMaterials = r2;
            return this;
        }

        public final OPopover build() {
            return new OPopover(this);
        }
    }

    /* JADX INFO: compiled from: OPopover.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\u0004¨\u0006\b"}, d2 = {"Lcom/obric/oui/popover/v2/OPopover$CommonFloatProperty;", "", "value", "", "(F)V", "getValue", "()F", "setValue", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    private static final class CommonFloatProperty {
        private float value;

        public CommonFloatProperty(float r1) {
            this.value = r1;
        }

        public final float getValue() {
            return this.value;
        }

        public final void setValue(float r1) {
            this.value = r1;
        }
    }

    /* JADX INFO: compiled from: OPopover.kt */
    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\r\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0015\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\fH\u0000¢\u0006\u0002\b\u000eJ\b\u0010\u000f\u001a\u00020\u0010H\u0002J \u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0014H\u0002J\u0010\u0010\u0016\u001a\u00020\u00102\u0006\u0010\u0017\u001a\u00020\bH\u0002J\u0010\u0010\u0018\u001a\u00020\u00102\u0006\u0010\u0017\u001a\u00020\bH\u0002J\u0010\u0010\u0019\u001a\u00020\u00102\b\b\u0002\u0010\u001a\u001a\u00020\nJ(\u0010\u001b\u001a\u00020\u00102\u0006\u0010\u0017\u001a\u00020\b2\u0006\u0010\u001c\u001a\u00020\n2\u0006\u0010\u001d\u001a\u00020\u00142\u0006\u0010\u001e\u001a\u00020\u0014H\u0003J\u0016\u0010\u001f\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\bH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"Lcom/obric/oui/popover/v2/OPopover$Companion;", "", "()V", "TAG", "", "popoverStack", "", "Ljava/lang/ref/WeakReference;", "Lcom/obric/oui/popover/v2/OPopover;", "shouldForceDismiss", "", "adaptGravity", "", "originGravity", "adaptGravity$OUI_standardRelease", "cleanupStackLocked", "", "coverPreviousPopoverIfAny", PerfConsts.KEY_CURRENT_GALVANIC, "alpha", "", "scale", "popPopoverFromStack", "popover", "pushPopoverToStack", "setShouldForceDismiss", "forceDismiss", "startAnimationForStack", "toTop", "targetContentAlpha", "targetScale", "topLocked", "exclude", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        /* JADX INFO: renamed from: $r8$lambda$tQCvZUqh94IQK0O16SUeF37KQ-w, reason: not valid java name */
        public static /* synthetic */ void m617$r8$lambda$tQCvZUqh94IQK0O16SUeF37KQw(ViewGroup r0, float r1, float r2, Ref.FloatRef r3, float r4, View r5, Ref.FloatRef r6, float r7, DynamicAnimation r8, float r9, float r10) {
            m618startAnimationForStack$lambda2$lambda1(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9, r10);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        public final int adaptGravity$OUI_standardRelease(int r5) {
            boolean r1 = true;
            if ((r5 & GravityCompat.START) != 8388611) goto L5;
            boolean r4 = true;
        L7:
            if ((r5 & GravityCompat.END) == 8388613) goto L10;
            r1 = false;
        L10:
            if (r4 == false) goto L12;
            r5 = ((-8388612) & r5) | 3;
        L12:
            if (r1 == true) goto L14;
            return r5;
        L14:
            return ((-8388614) & r5) | 5;
        L5:
            r4 = false;
            goto L7
        }

        private Companion() {
        }

        public static final /* synthetic */ void access$coverPreviousPopoverIfAny(Companion r0, OPopover r1, float r2, float r3) {
            r0.coverPreviousPopoverIfAny(r1, r2, r3);
        }

        public static final /* synthetic */ void access$popPopoverFromStack(Companion r0, OPopover r1) {
            r0.popPopoverFromStack(r1);
        }

        public static final /* synthetic */ void access$pushPopoverToStack(Companion r0, OPopover r1) {
            r0.pushPopoverToStack(r1);
        }

        private final synchronized void cleanupStackLocked() {
            monitor-enter(this);
            CollectionsKt.removeAll(OPopover.access$getPopoverStack$cp(), OPopover$Companion$cleanupStackLocked$1.INSTANCE);     // Catch: Throwable -> L6
            monitor-exit(this);
            return;
        L6:
            th = move-exception;
            throw th;
        }

        static /* synthetic */ OPopover topLocked$default(Companion r0, OPopover r1, int r2, Object r3) {
            if ((r2 & 1) == 0) goto L6;
            r1 = null;
        L6:
            return r0.topLocked(r1);
        }

        private final synchronized OPopover topLocked(OPopover r4) {
            monitor-enter(this);
            cleanupStackLocked();     // Catch: Throwable -> L19
            int r0 = OPopover.access$getPopoverStack$cp().size() - 1;     // Catch: Throwable -> L19
            if (r0 < 0) goto L16;
        L5:
            int r1 = r0 - 1;     // Catch: Throwable -> L19
            OPopover r2 = (OPopover) ((WeakReference) OPopover.access$getPopoverStack$cp().get(r0)).get();     // Catch: Throwable -> L19
            if (r2 == null) goto L11;
            if (r4 == null) goto L14;
            if (r2 == r4) goto L11;
        L14:
            monitor-exit(this);
            return r2;
        L11:
            if (r1 < 0) goto L16;
            r0 = r1;
        L16:
            monitor-exit(this);
            return null;
        L19:
            th = move-exception;
            throw th;
        }

        private final synchronized void pushPopoverToStack(final OPopover r3) {
            monitor-enter(this);
            cleanupStackLocked();     // Catch: Throwable -> L6
            CollectionsKt.removeAll(OPopover.access$getPopoverStack$cp(), new OPopover$Companion$pushPopoverToStack$1(r3));     // Catch: Throwable -> L6
            OPopover.access$getPopoverStack$cp().add(new WeakReference(r3));     // Catch: Throwable -> L6
            monitor-exit(this);
            return;
        L6:
            th = move-exception;
            throw th;
        }

        private final synchronized void popPopoverFromStack(final OPopover r4) {
            monitor-enter(this);
            cleanupStackLocked();     // Catch: Throwable -> L9
            CollectionsKt.removeAll(OPopover.access$getPopoverStack$cp(), new OPopover$Companion$popPopoverFromStack$1(r4));     // Catch: Throwable -> L9
            OPopover r5 = topLocked(null);     // Catch: Throwable -> L9
            if (r5 == null) goto L7;
            OPopover.Companion.startAnimationForStack(r5, true, 1.0f, 1.0f);     // Catch: Throwable -> L9
        L7:
            monitor-exit(this);
            return;
        L9:
            th = move-exception;
            throw th;
        }

        private final synchronized void coverPreviousPopoverIfAny(OPopover r2, float r3, float r4) {
            monitor-enter(this);
            OPopover r5 = topLocked(r2);     // Catch: Throwable -> L11
            if (r5 != null) goto L8;
            monitor-exit(this);
            return;
        L8:
            startAnimationForStack(r5, false, r3, r4);     // Catch: Throwable -> L11
            monitor-exit(this);
            return;
        L11:
            th = move-exception;
            throw th;
        }

        private final void startAnimationForStack(OPopover r16, boolean r17, final float r18, final float r19) {
            ViewGroup r0 = OPopover.access$getMWindowFrame$p(r16);
            OPopoverLayout r1 = null;
            if (r0 != null) goto L5;
            Intrinsics.throwUninitializedPropertyAccessException("mWindowFrame");
            final ViewGroup r3 = null;
        L6:
            OPopoverLayout r2 = OPopover.access$getMOBubbleLayout$p(r16);
            if (r2 != null) goto L9;
            Intrinsics.throwUninitializedPropertyAccessException("mOBubbleLayout");
        L10:
            final View r8 = r1.getChildAt(0);
            if (r17 == false) goto L13;
            float r4 = 0.8f;
        L15:
            if (r17 == false) goto L17;
            final float r5 = 0.0f;
        L18:
            if (r17 == false) goto L20;
            final float r6 = 10000.0f;
        L21:
            final Ref.FloatRef r7 = new Ref.FloatRef();
            r7.element = r3.getScaleX();
            final Ref.FloatRef r9 = new Ref.FloatRef();
            r9.element = r8.getAlpha();
            ViewPropertySpringAnimator r10 = ViewPropertySpringAnimator.animateProperty$default(ViewPropertySpringAnimatorExtKt.spring(r3).defaultDampingRatio(r4).defaultStiffness(439.0f), OPopover.access$getAnimFloatP$p(r16), r6, null, 4, null);
            r10.setUpdateListener(new OPopover$Companion$$ExternalSyntheticLambda0(r3, r5, r6, r7, r19, r8, r9, r18));
            r10.start();
            return;
        L20:
            r6 = 0.0f;
            goto L21
        L17:
            r5 = 10000.0f;
            goto L18
        L13:
            r4 = 1.0f;
            goto L15
        L9:
            r1 = r2;
            goto L10
        L5:
            r3 = r0;
            goto L6
        }

        /* JADX INFO: renamed from: startAnimationForStack$lambda-2$lambda-1, reason: not valid java name */
        private static final void m618startAnimationForStack$lambda2$lambda1(ViewGroup r1, float r2, float r3, Ref.FloatRef r4, float r5, View r6, Ref.FloatRef r7, float r8, DynamicAnimation r9, float r10, float r11) {
            Intrinsics.checkNotNullParameter(r1, "$view");
            Intrinsics.checkNotNullParameter(r4, "$initScale");
            Intrinsics.checkNotNullParameter(r7, "$initAlpha");
            KtExt r12 = KtExt.INSTANCE;
            Object r13 = r1.getTag(R.id.o_popover_anim_p);
            if (r13 != null) goto L6;
        L4:
            r13 = null;
        L8:
            if (((CommonFloatProperty) r13) == null) goto L11;
            float r14 = AnimUtils.getAnimFraction(r10, r2, r3);
            float r15 = r4.element + ((r5 - r4.element) * r14);
            r1.setScaleX(r15);
            r1.setScaleY(r15);
            r6.setAlpha(r7.element + ((r8 - r7.element) * r14));
            return;
        L11:
            return;
        L6:
            if ((r13 instanceof CommonFloatProperty) == false) goto L4;
            goto L4
        }

        public static /* synthetic */ void setShouldForceDismiss$default(Companion r0, boolean r1, int r2, Object r3) {
            if ((r2 & 1) == 0) goto L5;
            r1 = true;
        L5:
            r0.setShouldForceDismiss(r1);
        }

        public final void setShouldForceDismiss(boolean r1) {
            OPopover.access$setShouldForceDismiss$cp(r1);
        }
    }

    /* JADX INFO: compiled from: OPopover.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004"}, d2 = {"Lcom/obric/oui/popover/v2/OPopover$OnBubbleDismissListener;", "", "bubbleDismiss", "", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface OnBubbleDismissListener {
        void bubbleDismiss();
    }

    /* JADX INFO: compiled from: OPopover.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004"}, d2 = {"Lcom/obric/oui/popover/v2/OPopover$OnBubbleShowListener;", "", "bubbleShow", "", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface OnBubbleShowListener {
        void bubbleShow();
    }

    /* JADX INFO: compiled from: OPopover.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004"}, d2 = {"Lcom/obric/oui/popover/v2/OPopover$OnBubbleStartDismissListener;", "", "bubbleStartDismiss", "", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface OnBubbleStartDismissListener {
        void bubbleStartDismiss();
    }

    public static /* synthetic */ void $r8$lambda$_dfEu8aR4HQo23qHZTcyifjvay8(OPopover r0) {
        m615mDismissRunnable$lambda5(r0);
    }

    public static /* synthetic */ void $r8$lambda$pm75b6XQXe_SSeD0jLcBqOnHJMc(ViewGroup r0, float r1, float r2, float r3, float r4, float r5, float r6, DynamicAnimation r7, float r8, float r9) {
        m614animatorEasyInOut$lambda8$lambda7(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9);
    }

    public static /* synthetic */ boolean $r8$lambda$xB8AT54htxRdyYjXUVdhZLOpSdk(OPopover r0, View r1, MotionEvent r2) {
        return m613addShadowFrame$lambda15(r0, r1, r2);
    }

    public OPopover(Builder r4) {
        Intrinsics.checkNotNullParameter(r4, "builder");
        this.mAnimTime = 200;
        this.mAutoDismissDelayMillis = 5000;
        this.mOutsideTouchable = true;
        this.enableAutoDismiss = true;
        this.mShowWithAnimation = true;
        this.mShadowEnabled = true;
        this.mShadowStyle = R.style.OUIShadow_3;
        this.mEnableBubbleMaterial = true;
        this.mMaterials = MaterialToken.OUI_Bg_Popup;
        this.mIsFirstShow = true;
        this.anchorCenterX = Float.NaN;
        this.anchorCenterY = Float.NaN;
        this.mCoverPreviousWhenStacked = true;
        this.mStackCoverColor = Color.parseColor("#08000000");
        this.mStackAlphaPrevious = 0.3f;
        this.mStackScalePrevious = 0.98f;
        this.activity = r4.getActivity();
        this.mGravity = r4.getMGravity();
        this.mDisplayOrientation = r4.getMDisplayOrientation();
        this.mBgColor = r4.getMBgColor();
        this.isHideVirtualKey = Boolean.valueOf(r4.getMHideVirtualKey());
        this.mXOffset = r4.getMXOffset();
        this.mYOffset = r4.getMYOffset();
        this.mAnimTime = r4.getMAnimTime();
        this.mAutoDismissDelayMillis = r4.getMAutoDismissDelayMillis();
        this.mView = r4.getMView();
        this.mHeight = r4.getMHeight();
        this.mWidth = r4.getMWidth();
        this.mStartDismissListener = r4.getMStartDismissListener();
        this.mDismissListener = r4.getMDismissListener();
        this.mShowListener = r4.getMShowListener();
        this.mOutsideTouchable = r4.getMOutsideTouchable();
        this.mFocusable = r4.getMFocusable();
        this.mGetLocationInWindow = r4.getMGetLocationInWindow();
        this.mBorderWidth = r4.getMBorderWidth();
        this.mBorderColor = r4.getMBorderColor();
        this.transparentBg = r4.getTransparentBg();
        this.mShowWithAnimation = r4.getMShowWithAnimation();
        this.mShadowEnabled = r4.getMShadowEnabled();
        this.mShadowStyle = r4.getShadowStyle();
        this.mSpacingForShadow = r4.getMSpacingForShadow();
        this.mEnableBubbleMaterial = r4.getMEnableBubbleMaterial();
        this.mMaterials = r4.getMMaterials();
        this.mCoverPreviousWhenStacked = r4.getMCoverPreviousWhenStacked();
        this.mStackCoverColor = r4.getMStackCoverColor();
        this.mStackAlphaPrevious = r4.getMStackAlphaPrevious();
        this.mStackScalePrevious = r4.getMStackScalePrevious();
        setWidth(-2);
        setHeight(-2);
        setFocusable(this.mFocusable);
        setOutsideTouchable(this.mOutsideTouchable);
        setClippingEnabled(false);
        setInputMethodMode(1);
        setSoftInputMode(16);
        View r5 = this.mView;
        if (r5 == null) goto L7;
        setBubbleLayout(r5);
        initContentView();
        setFocusable(true);
        this.mDismissRunnable = new OPopover$$ExternalSyntheticLambda1(this);
        this.animFloatP = new OPopover$animFloatP$1();
        return;
    L7:
        throw new IllegalArgumentException("mView must be not null");
    }

    public static final /* synthetic */ FloatPropertyCompat access$getAnimFloatP$p(OPopover r0) {
        return r0.animFloatP;
    }

    public static final /* synthetic */ OnBubbleDismissListener access$getMDismissListener$p(OPopover r0) {
        return r0.mDismissListener;
    }

    public static final /* synthetic */ OPopoverLayout access$getMOBubbleLayout$p(OPopover r0) {
        return r0.mOBubbleLayout;
    }

    public static final /* synthetic */ int access$getMShadowStyle$p(OPopover r0) {
        return r0.mShadowStyle;
    }

    public static final /* synthetic */ OnBubbleShowListener access$getMShowListener$p(OPopover r0) {
        return r0.mShowListener;
    }

    public static final /* synthetic */ ViewGroup access$getMWindowFrame$p(OPopover r0) {
        return r0.mWindowFrame;
    }

    public static final /* synthetic */ List access$getPopoverStack$cp() {
        return popoverStack;
    }

    public static final /* synthetic */ void access$setShouldForceDismiss$cp(boolean r0) {
        shouldForceDismiss = r0;
    }

    private final int getMGravity() {
        return Companion.adaptGravity$OUI_standardRelease(this.mGravity);
    }

    private final void initContentView() {
        if (Intrinsics.areEqual(this.isHideVirtualKey, true) == false) goto L5;
        hideSystemUi();
    L5:
        OPopoverLayout r1 = null;
        if (this.mBgColor == 0) goto L11;
        OPopoverLayout r0 = this.mOBubbleLayout;
        if (r0 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("mOBubbleLayout");
        r0 = null;
    L10:
        r0.setBgColor(this.mBgColor);
    L11:
        OPopoverLayout r2 = this.mOBubbleLayout;
        if (r2 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("mOBubbleLayout");
        r2 = null;
    L15:
        if (r2.isEnableMaterial() == true) goto L23;
        OPopoverLayout r3 = this.mOBubbleLayout;
        if (r3 != null) goto L19;
        Intrinsics.throwUninitializedPropertyAccessException("mOBubbleLayout");
        r3 = null;
    L19:
        r3.setBorderColor(this.mBorderColor);
        OPopoverLayout r4 = this.mOBubbleLayout;
        if (r4 != null) goto L22;
        Intrinsics.throwUninitializedPropertyAccessException("mOBubbleLayout");
        r4 = null;
    L22:
        r4.setBorderWidth(this.mBorderWidth);
    L23:
        OPopoverLayout r5 = this.mOBubbleLayout;
        if (r5 != null) goto L26;
        Intrinsics.throwUninitializedPropertyAccessException("mOBubbleLayout");
    L27:
        r1.setTransparentBg(this.transparentBg);
        return;
    L26:
        r1 = r5;
        goto L27
    }

    public final void setCustomAnimator(Animator r2, Animator r3) {
        Intrinsics.checkNotNullParameter(r2, "inAnimator");
        Intrinsics.checkNotNullParameter(r3, "outAnimator");
        this.customInAnimator = r2;
        this.customOutAnimator = r3;
    }

    public final long getInAnimTime() {
        return this.mAnimTime;
    }

    public final int getDisplayRotationDegrees$OUI_standardRelease() {
        int r1 = this.mDisplayOrientation;
        if (r1 != 1) goto L5;
        return 90;
    L5:
        if (r1 == 3) goto L7;
        return 0;
    L7:
        return 270;
    }

    public final void setXOffset(int r1) {
        this.mXOffset = r1;
    }

    public final void setYOffset(int r1) {
        this.mYOffset = r1;
    }

    public final void setGetLocationInWindow(boolean r1) {
        this.mGetLocationInWindow = r1;
    }

    public final void setOnShowListener(OnBubbleShowListener r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        this.mShowListener = r2;
    }

    public final void setOnStartDismissListener(OnBubbleStartDismissListener r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        this.mStartDismissListener = r2;
    }

    public final void setOnDismissListener(OnBubbleDismissListener r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        this.mDismissListener = r2;
    }

    private final void setBubbleLayout(View r6) {
        OPopoverLayout r0 = new OPopoverLayout(this.activity, this.mEnableBubbleMaterial, this.mMaterials);
        this.mOBubbleLayout = r0;
        r0.setBackgroundColor(0);
        OPopoverLayout r1 = this.mOBubbleLayout;
        OPopoverLayout r2 = null;
        if (r1 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mOBubbleLayout");
        r1 = null;
    L5:
        r1.setGravity(17);
        int r3 = this.mDisplayOrientation;
        if (r3 != 0) goto L8;
    L16:
        float r4 = 0.0f;
    L18:
        if (r4 <= 0.0f) goto L23;
        OPopoverLandscapeWrapper r5 = new OPopoverLandscapeWrapper(this.activity);
        r5.setOrientationAngle(r4);
        r5.addView(r6);
        OPopoverLayout r7 = this.mOBubbleLayout;
        if (r7 != null) goto L22;
        Intrinsics.throwUninitializedPropertyAccessException("mOBubbleLayout");
        r7 = null;
    L22:
        r7.addView(r5);
    L27:
        OPopoverLayout r8 = this.mOBubbleLayout;
        if (r8 != null) goto L30;
        Intrinsics.throwUninitializedPropertyAccessException("mOBubbleLayout");
        r8 = null;
    L30:
        r8.setCornerRadiusDp(OPopoverLayout.Companion.getCORNER_RADIUS_DP());
        ViewGroup.MarginLayoutParams r9 = new ViewGroup.MarginLayoutParams(-2, -2);
        OPopoverLayout r10 = this.mOBubbleLayout;
        if (r10 != null) goto L33;
        Intrinsics.throwUninitializedPropertyAccessException("mOBubbleLayout");
        r10 = null;
    L33:
        r10.setLayoutParams(r9);
        if (this.mBgColor == 0) goto L39;
        OPopoverLayout r11 = this.mOBubbleLayout;
        if (r11 != null) goto L38;
        Intrinsics.throwUninitializedPropertyAccessException("mOBubbleLayout");
        r11 = null;
    L38:
        r11.setBgColor(this.mBgColor);
    L39:
        OPopoverLayout r12 = this.mOBubbleLayout;
        if (r12 != null) goto L42;
        Intrinsics.throwUninitializedPropertyAccessException("mOBubbleLayout");
        r12 = null;
    L42:
        OPopoverLayout r13 = r12;
        this.mWindowFrame = r13;
        if (r13 != null) goto L45;
        Intrinsics.throwUninitializedPropertyAccessException("mWindowFrame");
    L46:
        setContentView(r2);
        getContentView().measure(Integer.MIN_VALUE, Integer.MIN_VALUE);
        return;
    L45:
        r2 = r13;
        goto L46
    L23:
        OPopoverLayout r14 = this.mOBubbleLayout;
        if (r14 != null) goto L26;
        Intrinsics.throwUninitializedPropertyAccessException("mOBubbleLayout");
        r14 = null;
    L26:
        r14.addView(r6);
        goto L27
    L8:
        if (r3 != 1) goto L10;
        r4 = 90.0f;
        goto L18
    L10:
        if (r3 == 2) goto L16;
        if (r3 != 3) goto L16;
        r4 = 270.0f;
        goto L18
    }

    @Override // android.widget.PopupWindow
    public void showAtLocation(View r12, int r13, int r14, int r15) {
        Intrinsics.checkNotNullParameter(r12, "anchor");
        if (this.mCoverPreviousWhenStacked == true) goto L5;
        this.mCoverPreviousWhenStacked = isAnchorFromPopupWindow(r12);
    L5:
        int r16 = Companion.adaptGravity$OUI_standardRelease(r13);
        beforeShowInStackIfNeeded();     // Catch: Exception -> L42
        Pair<Integer, Integer> r1 = addShadowFrameIfNeeded(r14, r15);     // Catch: Exception -> L42
        if (this.mGetLocationInWindow == false) goto L9;
    L12:
        boolean r2 = true;
    L13:
        this.useWindowCoords = r2;     // Catch: Exception -> L42
        int[] r5 = new int[2];     // Catch: Exception -> L42
        if (r2 == false) goto L16;
        r12.getLocationInWindow(r5);     // Catch: Exception -> L42
    L17:
        this.anchorCenterX = r5[0] + (r12.getWidth() / 2.0f);     // Catch: Exception -> L42
        this.anchorCenterY = r5[1] + (r12.getHeight() / 2.0f);     // Catch: Exception -> L42
        if (this.mIsShowInDialog == false) goto L27;
        View r3 = r12.getRootView();     // Catch: Exception -> L42
        Context r6 = r12.getContext();     // Catch: Exception -> L42
        Intrinsics.checkNotNullExpressionValue(r6, "anchor.context");     // Catch: Exception -> L42
        int r7 = OUnitExtensionKt.getScreenWidth(r6);     // Catch: Exception -> L42
        Context r8 = r12.getContext();     // Catch: Exception -> L42
        Intrinsics.checkNotNullExpressionValue(r8, "anchor.context");     // Catch: Exception -> L42
        int r0 = OUnitExtensionKt.getAppScreenHeight(r8);     // Catch: Exception -> L42
        int r9 = OWindowConfigController.getStatusBarHeight(r12.getContext());     // Catch: Exception -> L42
        int r10 = OWindowConfigController.INSTANCE.getNavigationBarHeight(r12.getContext());     // Catch: Exception -> L42
        if (r3.getWidth() >= r7) goto L22;
        float r11 = (r7 - r3.getWidth()) / 2.0f;     // Catch: Exception -> L42
    L23:
        int r17 = MathKt.roundToInt(r11);     // Catch: Exception -> L42
        if (r3.getHeight() >= r0) goto L26;
        int r4 = ((r0 - r3.getHeight()) + r9) + r10;     // Catch: Exception -> L42
    L28:
        int r18 = (r14 - r1.getFirst().intValue()) - r17;     // Catch: Exception -> L42
        int r19 = (r15 - r1.getSecond().intValue()) - r4;     // Catch: Exception -> L42
        this.popupOriginX = r18;     // Catch: Exception -> L42
        this.popupOriginY = r19;     // Catch: Exception -> L42
        setElevation(getElevationPx());     // Catch: Exception -> L42
        if (this.mIsShowInDialog == false) goto L31;
    L37:
        super.showAtLocation(r12, r16, r18, r19);     // Catch: Exception -> L42
        afterShowInStackIfNeeded();     // Catch: Exception -> L42
        setElevation(0.0f);     // Catch: Exception -> L42
        getContentView().setElevation(0.0f);     // Catch: Exception -> L42
        this.mIsFirstShow = false;     // Catch: Exception -> L42
        this.isAlreadyDismiss = false;     // Catch: Exception -> L42
        if (this.mShowWithAnimation == false) goto L40;
        animatorEasyInOut(true);     // Catch: Exception -> L42
        return;
    L40:
        showDirectly();     // Catch: Exception -> L42
        return;
    L31:
        if ((r12.getContext() instanceof Activity) == false) goto L37;
        Context r110 = r12.getContext();     // Catch: Exception -> L42
        if (r110 == null) goto L36;
        r12 = ((Activity) r110).getWindow().getDecorView();     // Catch: Exception -> L42
        Intrinsics.checkNotNullExpressionValue(r12, "anchor.context as Activity).window.decorView");     // Catch: Exception -> L42
        goto L37
    L36:
        throw new NullPointerException("null cannot be cast to non-null type android.app.Activity");     // Catch: Exception -> L42
    L26:
        r4 = 0;
        goto L28
    L22:
        r11 = 0.0f;
        goto L23
    L27:
        r4 = 0;
        r17 = 0;
        goto L28
    L16:
        r12.getLocationOnScreen(r5);     // Catch: Exception -> L42
        goto L17
    L9:
        if (this.mIsShowInDialog == true) goto L12;
        r2 = false;
    L42:
        e = move-exception;
        L.e(TAG, "showAtLocation, error", e);
    }

    private final boolean isAnchorFromPopupWindow(View r7) {
        View r6 = r7.getRootView();
        if (r6 != null) goto L5;
        return false;
    L5:
        String r0 = r6.getClass().getName();
        if (Intrinsics.areEqual(r0, "android.widget.PopupWindow$PopupDecorView") == false) goto L37;
        return true;
    L37:
        boolean r1 = Class.forName("android.widget.PopupWindow$PopupDecorView").isInstance(r6);     // Catch: Throwable -> L10
    L11:
        if (r1 == false) goto L39;
        return true;
    L39:
        IBinder r2 = r6.getWindowToken();     // Catch: Throwable -> L36
        IBinder r3 = r6.getApplicationWindowToken();     // Catch: Throwable -> L36
        if (r2 == null) goto L19;
        if (r3 == null) goto L19;
        if (Intrinsics.areEqual(r2, r3) == true) goto L19;
        boolean r4 = true;
    L20:
        ViewGroup.LayoutParams r8 = r6.getLayoutParams();
        if ((r8 instanceof WindowManager.LayoutParams) == false) goto L23;
        WindowManager.LayoutParams r9 = (WindowManager.LayoutParams) r8;
    L24:
        if (r9 != null) goto L27;
    L25:
        boolean r10 = false;
    L31:
        if (r4 == false) goto L34;
        if (r10 == false) goto L34;
        return true;
    L34:
        Intrinsics.checkNotNullExpressionValue(r0, "className");
        return StringsKt.contains$default(r0, "PopupDecorView", false, 2, null);
    L27:
        if (r9.type != 1002) goto L29;
    L30:
        r10 = true;
        goto L31
    L29:
        if (r9.type != 1000) goto L25;
    L23:
        r9 = null;
    L19:
        r4 = false;
    L10:
        r1 = false;
        goto L11
    }

    @Override // android.widget.PopupWindow
    public void showAsDropDown(View r9, int r10, int r11, int r12) {
        int r13 = Companion.adaptGravity$OUI_standardRelease(r12);
        beforeShowInStackIfNeeded();     // Catch: Exception -> L29
        Pair<Integer, Integer> r0 = addShadowFrameIfNeeded(r10, r11);     // Catch: Exception -> L29
        if (this.mGetLocationInWindow == false) goto L6;
    L9:
        boolean r1 = true;
    L10:
        this.useWindowCoords = r1;     // Catch: Exception -> L29
        if (r9 != null) goto L13;
        Unit r2 = null;
    L18:
        if (r2 != null) goto L20;
        OPopover r3 = this;     // Catch: Exception -> L29
        this.anchorCenterX = Float.NaN;     // Catch: Exception -> L29
        this.anchorCenterY = Float.NaN;     // Catch: Exception -> L29
    L20:
        super.showAsDropDown(r9, r10 - r0.getFirst().intValue(), r11 - r0.getSecond().intValue(), r13);     // Catch: Exception -> L29
        afterShowInStackIfNeeded();     // Catch: Exception -> L29
        this.mIsFirstShow = false;     // Catch: Exception -> L29
        int[] r14 = new int[2];     // Catch: Exception -> L29
        if (this.useWindowCoords == false) goto L23;
        getContentView().getLocationInWindow(r14);     // Catch: Exception -> L29
    L24:
        this.popupOriginX = r14[0];     // Catch: Exception -> L29
        this.popupOriginY = r14[1];     // Catch: Exception -> L29
        this.isAlreadyDismiss = false;     // Catch: Exception -> L29
        if (this.mShowWithAnimation == false) goto L27;
        animatorEasyInOut(true);     // Catch: Exception -> L29
        return;
    L27:
        showDirectly();     // Catch: Exception -> L29
        return;
    L23:
        getContentView().getLocationOnScreen(r14);     // Catch: Exception -> L29
        goto L24
    L13:
        int[] r5 = new int[2];     // Catch: Exception -> L29
        if (r1 == false) goto L16;
        r9.getLocationInWindow(r5);     // Catch: Exception -> L29
    L17:
        this.anchorCenterX = r5[0] + (r9.getWidth() / 2.0f);     // Catch: Exception -> L29
        this.anchorCenterY = r5[1] + (r9.getHeight() / 2.0f);     // Catch: Exception -> L29
        r2 = Unit.INSTANCE;     // Catch: Exception -> L29
        goto L18
    L16:
        r9.getLocationOnScreen(r5);     // Catch: Exception -> L29
        goto L17
    L6:
        if (this.mIsShowInDialog == true) goto L9;
        r1 = false;
    L29:
        e = move-exception;
        L.e(TAG, "showAsDropDown, error", e);
    }

    private final void hideSystemUi() {
        if (Intrinsics.areEqual(this.isHideVirtualKey, false) == false) goto L5;
        return;
    L5:
        getContentView().setSystemUiVisibility(4102);
    }

    private final void measure() {
        int r0 = this.mWidth;
        if (r0 != 0) goto L5;
    L7:
        getContentView().measure(Integer.MIN_VALUE, Integer.MIN_VALUE);
        return;
    L5:
        if (this.mHeight == 0) goto L7;
        int r1 = View.MeasureSpec.makeMeasureSpec(r0, 1073741824);
        int r2 = View.MeasureSpec.makeMeasureSpec(this.mHeight, 1073741824);
        getContentView().measure(r1, r2);
    }

    public final void onDestroy() {
        AnimatorSet r0 = this.animSet;
        if (r0 == null) goto L6;
        r0.removeAllListeners();
    L6:
        AnimatorSet r1 = this.animSet;
        if (r1 == null) goto L10;
        r1.cancel();
    L10:
        this.animSet = null;
        clearFakeAnchorViewIfNecessary();
        onDestroyInStackIfNeeded();
        if (this.activity.isFinishing() == true) goto L15;
        if (isShowing() == false) goto L15;
    L20:
        super.dismiss();     // Catch: Exception -> L19
        return;
    L22:
        return;
    L15:
        if (shouldForceDismiss == true) goto L20;
    }

    public final int getMeasuredHeight() {
        if (this.mIsFirstShow == false) goto L6;
        measure();
        return getContentView().getMeasuredHeight();
    L6:
        OPopoverLayout r1 = this.mOBubbleLayout;
        if (r1 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("mOBubbleLayout");
        r1 = null;
    L10:
        return r1.getMeasuredHeight();
    }

    public final int getMeasuredWidth() {
        if (this.mIsFirstShow == false) goto L6;
        measure();
        return getContentView().getMeasuredWidth();
    L6:
        OPopoverLayout r1 = this.mOBubbleLayout;
        if (r1 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("mOBubbleLayout");
        r1 = null;
    L10:
        return r1.getMeasuredWidth();
    }

    public final View getPopoverView() {
        OPopoverLayout r0 = this.mOBubbleLayout;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("mOBubbleLayout");
        r0 = null;
    L6:
        return r0;
    }

    public final void setMaxContentHeight(int r4) {
        OPopoverLayout r0 = this.mOBubbleLayout;
        if (r0 == null) goto L18;
        if (r4 <= 0) goto L19;
        OPopoverLayout r1 = null;
        if (r0 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("mOBubbleLayout");
        r0 = null;
    L9:
        int r5 = RangesKt.coerceAtLeast(r4 - (r0.getArrowHeight() * 2), 0);
        OPopoverLayout r2 = this.mOBubbleLayout;
        if (r2 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("mOBubbleLayout");
        r2 = null;
    L12:
        setMaxContentHeightIfPossible(r2, r5);
        OPopoverLayout r6 = this.mOBubbleLayout;
        if (r6 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("mOBubbleLayout");
    L16:
        r1.requestLayout();
        getContentView().measure(Integer.MIN_VALUE, Integer.MIN_VALUE);
        return;
    L15:
        r1 = r6;
        goto L16
    L19:
        return;
    }

    private final void setMaxContentHeightIfPossible(View r2, int r3) {
        if ((r2 instanceof OPopoverMenuView) == false) goto L6;
        ((OPopoverMenuView) r2).setPopoverMaxHeight(r3);
    L6:
        if ((r2 instanceof ViewGroup) == false) goto L11;
        Iterator<View> r4 = ViewGroupKt.getChildren((ViewGroup) r2).iterator();
    L9:
        if (r4.hasNext() == false) goto L13;
        setMaxContentHeightIfPossible(r4.next(), r3);
        goto L9
    L13:
        return;
    }

    private final void beforeShowInStackIfNeeded() {
        OPopoverLayout r0 = this.mOBubbleLayout;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mOBubbleLayout");
        r0 = null;
    L5:
        OPopoverLayout.setCovered$default(r0, false, 0, 2, null);
        if (this.mCoverPreviousWhenStacked == true) goto L8;
        return;
    L8:
        Companion.access$coverPreviousPopoverIfAny(Companion, this, this.mStackAlphaPrevious, this.mStackScalePrevious);
    }

    private final void afterShowInStackIfNeeded() {
        if (this.pushedToStack == false) goto L5;
        return;
    L5:
        this.pushedToStack = true;
        Companion.access$pushPopoverToStack(Companion, this);
    }

    private final void onDestroyInStackIfNeeded() {
        if (this.removedFromStack == false) goto L5;
        return;
    L5:
        this.removedFromStack = true;
        Companion.access$popPopoverFromStack(Companion, this);
    }

    /* JADX INFO: renamed from: mDismissRunnable$lambda-5, reason: not valid java name */
    private static final void m615mDismissRunnable$lambda5(OPopover r1) {
        Intrinsics.checkNotNullParameter(r1, "this$0");
        if (r1.enableAutoDismiss == false) goto L6;
        r1.animatorEasyInOut(false);
        return;
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

    public final void setEnableAutoDismiss(boolean r1) {
        this.enableAutoDismiss = r1;
    }

    public final void dismissDirectly() {
        if (this.isAlreadyDismiss == true) goto L9;
        ViewGroup r0 = this.mWindowFrame;
        if (r0 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("mWindowFrame");
        r0 = null;
    L7:
        r0.setVisibility(8);
        onDestroy();
        getContentView().removeCallbacks(this.mDismissRunnable);
        this.mXOffset = 0;
        this.mYOffset = 0;
        return;
    }

    private final void showDirectly() {
        setAnimationStyle(0);
        ViewGroup r1 = this.mWindowFrame;
        if (r1 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mWindowFrame");
        r1 = null;
    L5:
        r1.setVisibility(0);
        OnBubbleShowListener r2 = this.mShowListener;
        if (r2 == null) goto L10;
        r2.bubbleShow();
        return;
    }

    /* JADX WARN: Type inference failed for: r13v1, types: [T, com.obric.oui.animation.easy.ViewPropertySpringAnimator] */
    private final void animatorEasyInOut(final boolean r20) {
        setAnimationStyle(0);
        final ViewGroup r3 = this.mWindowFrame;
        if (r3 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mWindowFrame");
        r3 = null;
    L5:
        int r4 = 1;
        if (r20 == true) goto L8;
        this.isAlreadyDismiss = true;
    L8:
        this.animSet = new AnimatorSet();
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_i(TAG, "animatorEasyInOut, isIn = " + r20 + ", gravity = " + getMGravity());
        if (Float.isNaN(this.anchorCenterX) == false) goto L11;
        float r5 = r3.getMeasuredWidth() / 2.0f;
    L13:
        if (Float.isNaN(this.anchorCenterY) == false) goto L15;
        float r7 = r3.getMeasuredHeight() / 2.0f;
    L16:
        r3.setPivotX(r5);
        r3.setPivotY(r7);
        r3.setVisibility(0);
        final float r9 = 1.0f;
        PathInterpolator r6 = new PathInterpolator(0.4f, 0.8f, 0.74f, 1.0f);
        if (r20 == false) goto L19;
        float r8 = 0.0f;
    L20:
        if (r20 == false) goto L22;
        float r10 = 1.0f;
    L24:
        if (r3.getAlpha() != 0.0f) goto L26;
        boolean r11 = true;
    L27:
        if (r11 == false) goto L29;
    L34:
        ObjectAnimator r2 = ObjectAnimator.ofFloat(r3, "alpha", new float[]{r8, r10});
        r2.setInterpolator(r6);
        r2.setDuration(100);
        final Ref.ObjectRef r12 = new Ref.ObjectRef();
        if (r20 == false) goto L42;
        Animator r13 = this.customInAnimator;
        if (r13 == null) goto L42;
        AnimatorSet r14 = this.animSet;
        if (r14 == null) goto L83;
        r14.play(r13);
    L83:
        AnimatorSet r15 = this.animSet;
        if (r15 == null) goto L87;
        r15.addListener(new AnonymousClass2(r3, r20, this, r12));
    L87:
        if (r20 == true) goto L92;
        OnBubbleStartDismissListener r1 = this.mStartDismissListener;
        if (r1 == null) goto L92;
        r1.bubbleStartDismiss();
    L92:
        AnimatorSet r0 = this.animSet;
        if (r0 == null) goto L97;
        r0.start();
        return;
    L97:
        return;
    L42:
        if (r20 == true) goto L49;
        Animator r16 = this.customOutAnimator;
        if (r16 == null) goto L49;
        AnimatorSet r17 = this.animSet;
        if (r17 == null) goto L83;
        r17.play(r16);
    L49:
        AnimatorSet r18 = this.animSet;
        if (r18 == null) goto L54;
        r18.play(r2);
    L54:
        if (r20 == false) goto L56;
        final float r19 = 0.2f;
    L57:
        if (r20 == true) goto L61;
        r9 = 0.2f;
    L61:
        if (getMGravity() != 48) goto L65;
        r4 = -1;
    L65:
        if (r20 == false) goto L67;
        float r21 = -OUnitExtensionKt.vdpFloat(r3, 10);
    L68:
        float r22 = r4;
        final float r110 = r21 * r22;
        if (r20 == false) goto L71;
        float r23 = 0.0f;
    L72:
        final float r111 = r23 * r22;
        float r24 = 10000.0f;
        if (r20 == false) goto L75;
        float r25 = 0.0f;
    L76:
        if (r20 == true) goto L79;
        r24 = 0.0f;
    L79:
        ViewGroup r26 = r3;
        if (ViewPropertySpringAnimatorExtKt.spring(r26).isRunning() == true) goto L82;
        r3.setScaleX(r19);
        r3.setScaleY(r19);
        r3.setTranslationY(r110);
        r3.setTag(R.id.o_popover_anim_p, new CommonFloatProperty(r25));
    L82:
        ?? r112 = ViewPropertySpringAnimator.animateProperty$default(ViewPropertySpringAnimatorExtKt.spring(r26).defaultDampingRatio(0.85f).defaultStiffness(632.0f), this.animFloatP, r24, null, 4, null);
        final ViewGroup r27 = r3;
        final float r28 = r25;
        final float r29 = r24;
        r112.setUpdateListener(new OPopover$$ExternalSyntheticLambda2(r27, r28, r29, r19, r9, r110, r111));
        r12.element = r112;
        goto L83
    L75:
        r25 = 10000.0f;
        goto L76
    L71:
        r23 = -OUnitExtensionKt.vdpFloat(r3, 10);
        goto L72
    L67:
        r21 = 0.0f;
        goto L68
    L56:
        r19 = 1.0f;
        goto L57
    L29:
        if (r3.getAlpha() != 1.0f) goto L31;
        boolean r113 = true;
    L32:
        if (r113 == true) goto L34;
        r8 = r3.getAlpha();
        goto L34
    L31:
        r113 = false;
        goto L32
    L26:
        r11 = false;
        goto L27
    L22:
        r10 = 0.0f;
        goto L24
    L19:
        r8 = 1.0f;
        goto L20
    L15:
        r7 = this.anchorCenterY - this.popupOriginY;
        goto L16
    L11:
        r5 = this.anchorCenterX - this.popupOriginX;
        goto L13
    }

    /* JADX INFO: renamed from: animatorEasyInOut$lambda-8$lambda-7, reason: not valid java name */
    private static final void m614animatorEasyInOut$lambda8$lambda7(ViewGroup r1, float r2, float r3, float r4, float r5, float r6, float r7, DynamicAnimation r8, float r9, float r10) {
        Intrinsics.checkNotNullParameter(r1, "$view");
        KtExt r11 = KtExt.INSTANCE;
        Object r12 = r1.getTag(R.id.o_popover_anim_p);
        if (r12 != null) goto L6;
    L4:
        r12 = null;
    L8:
        if (((CommonFloatProperty) r12) == null) goto L11;
        float r13 = AnimUtils.getAnimFraction(r9, r2, r3);
        float r14 = r4 + ((r5 - r4) * r13);
        r1.setScaleX(r14);
        r1.setScaleY(r14);
        r1.setTranslationY(r6 + ((r7 - r6) * r13));
        return;
    L11:
        return;
    L6:
        if ((r12 instanceof CommonFloatProperty) == false) goto L4;
        goto L4
    }

    private final void clearFakeAnchorViewIfNecessary() {
        ViewGroup r3 = ViewUtil.INSTANCE.getActivityContentView(this.activity);
        if (r3 == null) goto L15;
        Sequence<View> r0 = ViewGroupKt.getChildren(r3);
        if (r0 == null) goto L17;
        Sequence r1 = SequencesKt.filter(r0, AnonymousClass1.INSTANCE);
        if (r1 == null) goto L18;
        Iterator r2 = r1.iterator();
    L13:
        if (r2.hasNext() == false) goto L19;
        r3.removeView((View) r2.next());
        L.d(TAG, "remove fake anchor view");
        goto L13
    L19:
        return;
    L18:
        return;
    L17:
        return;
    }

    private final Pair<Integer, Integer> addShadowFrameIfNeeded(int r2, int r3) {
        if (this.mShadowEnabled == false) goto L6;
        return addShadowFrame(r2, r3);
    L6:
        return new Pair(0, 0);
    }

    private final float getElevationPx() {
        int r0 = this.mShadowStyle;
        if (r0 == 0) goto L16;
        float r1 = resolveShadowSpace(r0);
        if (r1 > 0.0f) goto L12;
        L r2 = L.INSTANCE;
        if (r2.isBlocked(8) == true) goto L10;
        r2.getImpl().writeLog(TAG, 8, Intrinsics.stringPlus("surfaceInsets elevation resolved to 0, fallback to default. shadowStyleRes=", Integer.valueOf(access$getMShadowStyle$p(this))), null);
    L10:
        return 0.0f;
    L12:
        if (this.mSpacingForShadow == false) goto L15;
        return 0.0f;
    L15:
        return r1;
    L16:
        return 0.0f;
    }

    private final float resolveShadowSpace(int r2) {
        float r0 = 0.0f;
        if (r2 != 0) goto L5;
        return 0.0f;
    L5:
        List<Shadow> r1 = OUILayoutHelper.extractShadowInfo(this.activity, r2);
        Intrinsics.checkNotNullExpressionValue(r1, MaterialConfigFormatNames.SHADOWS);
        Iterator<T> r3 = r1.iterator();
    L7:
        if (r3.hasNext() == false) goto L9;
        r0 = r0 + ((Shadow) r3.next()).getRadius();
        goto L7
    L9:
        return r0;
    }

    private final Pair<Integer, Integer> addShadowFrame(int r18, int r19) {
        ViewGroup r6 = null;
        if (this.mIsFirstShow == true) goto L15;
        ViewGroup r1 = this.mWindowFrame;
        if (r1 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("mWindowFrame");
        r1 = null;
    L8:
        if ((r1 instanceof SingleChildFrameLayout) == false) goto L15;
        ViewGroup r2 = this.mWindowFrame;
        if (r2 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("mWindowFrame");
    L13:
        r6.setVisibility(4);
        getContentView().measure(Integer.MIN_VALUE, Integer.MIN_VALUE);
        Context r3 = getContentView().getContext();
        Intrinsics.checkNotNullExpressionValue(r3, "contentView.context");
        setWidth(OUnitExtensionKt.getScreenWidth(r3));
        return new Pair(Integer.valueOf(r18), Integer.valueOf(this.mShadowSpaceTop));
    L12:
        r6 = r2;
    L15:
        View r4 = LayoutInflater.from(this.activity).inflate(R.layout.o_layout_popover_shadow_frame, null);
        if (r4 == null) goto L59;
        SingleChildFrameLayout r5 = (SingleChildFrameLayout) r4;
        OPopoverLayout r7 = this.mOBubbleLayout;
        if (r7 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("mOBubbleLayout");
        r7 = null;
    L20:
        r5.addView(r7, new FrameLayout.LayoutParams(-2, -2));
        OPopoverLayout r8 = this.mOBubbleLayout;
        if (r8 != null) goto L23;
        Intrinsics.throwUninitializedPropertyAccessException("mOBubbleLayout");
        r8 = null;
    L23:
        r5.setShadowCornerRadius(MathKt.roundToInt(r8.getCornerRadius()));
        OPopoverLayout r9 = this.mOBubbleLayout;
        if (r9 != null) goto L26;
        Intrinsics.throwUninitializedPropertyAccessException("mOBubbleLayout");
        r9 = null;
    L26:
        int r10 = r9.getArrowHeight();
        OPopoverLayout r11 = this.mOBubbleLayout;
        if (r11 != null) goto L29;
        Intrinsics.throwUninitializedPropertyAccessException("mOBubbleLayout");
        r11 = null;
    L29:
        r5.setShadowInsets(r10, r11.getArrowHeight());
        int r12 = this.mShadowStyle;
        if (r12 != 0) goto L33;
        r12 = R.style.OUIShadow_3;
    L33:
        List<Shadow> r13 = OUILayoutHelper.extractShadowInfo(this.activity, r12);
        if (this.mSpacingForShadow == false) goto L51;
        Intrinsics.checkNotNullExpressionValue(r13, MaterialConfigFormatNames.SHADOWS);
        Iterator<T> r14 = r13.iterator();
        int r15 = 0;
        int r16 = 0;
        int r17 = 0;
        int r110 = 0;
    L37:
        if (r14.hasNext() == false) goto L52;
        Shadow r111 = (Shadow) r14.next();
        if ((r111.getRadius() - r111.getOffsetX()) <= r17) goto L42;
        r17 = MathKt.roundToInt(r111.getRadius() - r111.getOffsetX());
    L42:
        if ((r111.getRadius() + r111.getOffsetX()) <= r110) goto L45;
        r110 = MathKt.roundToInt(r111.getRadius() + r111.getOffsetX());
    L45:
        if ((r111.getRadius() - r111.getOffsetY()) <= r15) goto L48;
        r15 = MathKt.roundToInt(r111.getRadius() - r111.getOffsetY());
    L48:
        if ((r111.getRadius() + r111.getOffsetY()) <= r16) goto L37;
        r16 = MathKt.roundToInt(r111.getRadius() + r111.getOffsetY());
    L52:
        SingleChildFrameLayout r20 = new SingleChildFrameLayout(this.activity, null, 2, null);
        Context r112 = getContentView().getContext();
        Intrinsics.checkNotNullExpressionValue(r112, "contentView.context");
        r20.setLayoutParams(new ViewGroup.MarginLayoutParams(OUnitExtensionKt.getScreenWidth(r112), -2));
        r20.addView(r5, new FrameLayout.LayoutParams(-2, -2));
        r20.setClipChildren(false);
        r20.setClipToPadding(false);
        r20.setPadding(0, r15, 0, r16);
        r5.setX(r18);
        r20.setOnTouchListener(new OPopover$$ExternalSyntheticLambda0(this));
        this.mShadowSpaceTop = r15;
        SingleChildFrameLayout r21 = r20;
        this.mWindowFrame = r21;
        r21.setVisibility(4);
        ViewGroup r22 = this.mWindowFrame;
        if (r22 != null) goto L55;
        Intrinsics.throwUninitializedPropertyAccessException("mWindowFrame");
    L56:
        setContentView(r6);
        getContentView().measure(Integer.MIN_VALUE, Integer.MIN_VALUE);
        Context r23 = getContentView().getContext();
        Intrinsics.checkNotNullExpressionValue(r23, "contentView.context");
        setWidth(OUnitExtensionKt.getScreenWidth(r23));
        return new Pair(Integer.valueOf(r18), Integer.valueOf(r15));
    L55:
        r6 = r22;
        goto L56
    L51:
        r15 = 0;
        r16 = 0;
        goto L52
    L59:
        throw new NullPointerException("null cannot be cast to non-null type com.obric.oui.popover.SingleChildFrameLayout");
    }

    /* JADX INFO: renamed from: addShadowFrame$lambda-15, reason: not valid java name */
    private static final boolean m613addShadowFrame$lambda15(OPopover r2, View r3, MotionEvent r4) {
        Intrinsics.checkNotNullParameter(r2, "this$0");
        if (r4.getAction() != 0) goto L12;
        ViewUtil r5 = ViewUtil.INSTANCE;
        OPopoverLayout r0 = r2.mOBubbleLayout;
        if (r0 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("mOBubbleLayout");
        r0 = null;
    L7:
        Intrinsics.checkNotNullExpressionValue(r4, "event");
        if (r5.isEventOutsideView$OUI_standardRelease(r0, r4) == false) goto L13;
        r2.dismiss();
        return false;
    L13:
        return false;
    L12:
        return false;
    }

    public final void setIsShowInDialog(boolean r1) {
        this.mIsShowInDialog = r1;
    }

    public final void setGravity(int r2) {
        this.mGravity = Companion.adaptGravity$OUI_standardRelease(r2);
    }

    static {
        Companion = new Companion(null);
        popoverStack = new ArrayList();
    }
}
