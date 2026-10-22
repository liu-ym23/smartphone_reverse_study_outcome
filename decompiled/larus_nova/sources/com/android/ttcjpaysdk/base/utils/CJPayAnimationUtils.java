package com.android.ttcjpaysdk.base.utils;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.view.animation.AlphaAnimation;
import android.view.animation.AnimationSet;
import android.view.animation.Interpolator;
import android.view.animation.PathInterpolator;
import android.view.animation.TranslateAnimation;
import androidx.fragment.app.FragmentTransaction;
import com.android.ttcjpaysdk.base.ktextension.CJPayBasicExtensionKt;
import com.android.ttcjpaysdk.base.ktextension.CJPayKotlinExtensionsKt;
import com.android.ttcjpaysdk.bdpay.paymentmethod.ShareData;
import com.bytedance.android.live.core.anim.LiveDegradeFpsAnimator;
import com.bytedance.android.livesdk.end.LiveEndPageData;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.larus.home.impl.utils.c;
import com.larus.utils.logger.FLogger;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import r27.a;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000\u009c\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0011\bÆ\u0002\u0018\u00002\u00020\u0001:\u0002[\\B\u0007\b\u0002¢\u0006\u0002\u0010\u0002JF\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00172\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u001b\u001a\u00020\u001cH\u0007JF\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00172\b\u0010\u001f\u001a\u0004\u0018\u00010 2\u0006\u0010\u001b\u001a\u00020\u001cJ\u001a\u0010!\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0006\u0010\"\u001a\u00020\u0015H\u0007J\u0012\u0010#\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0007J(\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\u00172\u0006\u0010'\u001a\u00020\u00172\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010(\u001a\u00020)H\u0002J \u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020\u00172\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010(\u001a\u00020)H\u0002J&\u0010-\u001a\u00020\u00102\b\u0010.\u001a\u0004\u0018\u00010/2\b\u00100\u001a\u0004\u0018\u0001012\b\b\u0002\u00102\u001a\u00020\u0004H\u0007J\u001a\u00103\u001a\u00020\u00102\u0006\u00104\u001a\u00020\u00042\b\u00105\u001a\u0004\u0018\u000106H\u0007J6\u00107\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0006\u00108\u001a\u00020\u00152\b\u00109\u001a\u0004\u0018\u00010:2\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u001b\u001a\u00020\u001cH\u0007J,\u0010;\u001a\u0004\u0018\u00010\u001e2\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0006\u00108\u001a\u00020\u00152\b\u0010\u001f\u001a\u0004\u0018\u00010 2\u0006\u0010\u001b\u001a\u00020\u001cJ\n\u0010<\u001a\u0004\u0018\u00010)H\u0007J\u0014\u0010=\u001a\u0004\u0018\u00010>2\b\u00100\u001a\u0004\u0018\u000101H\u0003J&\u0010?\u001a\u00020@2\u0006\u0010A\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u001cJ6\u0010B\u001a\u00020\u00102\b\u00109\u001a\u0004\u0018\u00010:2\b\u0010C\u001a\u0004\u0018\u00010\u00122\u0006\u0010D\u001a\u00020\u00152\u0006\u0010\u0014\u001a\u00020\u00152\b\b\u0002\u0010E\u001a\u00020\u0015H\u0007J.\u0010F\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0006\u0010G\u001a\u00020\u00152\b\u00109\u001a\u0004\u0018\u00010:2\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0007J\u001c\u0010H\u001a\u00020\u00102\b\u0010.\u001a\u0004\u0018\u00010/2\b\b\u0001\u0010I\u001a\u00020\u0004H\u0007JL\u0010J\u001a\u00020\u00102\u0006\u0010C\u001a\u00020\u00122\b\b\u0002\u0010K\u001a\u00020L2\b\b\u0002\u0010,\u001a\u00020\u00172\b\b\u0002\u0010\u001b\u001a\u00020\u001c2\b\b\u0002\u0010&\u001a\u00020\u00172\b\b\u0002\u0010'\u001a\u00020\u00172\b\b\u0002\u0010M\u001a\u00020)H\u0007J.\u0010N\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0006\u0010O\u001a\u00020\u00152\b\u00109\u001a\u0004\u0018\u00010:2\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0007J6\u0010N\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0006\u0010O\u001a\u00020\u00152\b\u00109\u001a\u0004\u0018\u00010:2\b\b\u0002\u0010\u001b\u001a\u00020\u001c2\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aJ,\u0010N\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0006\u0010O\u001a\u00020\u00152\u0006\u0010P\u001a\u00020\u00042\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0007JF\u0010Q\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\b\b\u0001\u0010R\u001a\u00020\u00042\b\b\u0001\u0010S\u001a\u00020\u00042\b\b\u0001\u0010T\u001a\u00020\u00042\b\b\u0002\u0010\u001b\u001a\u00020\u001c2\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0007J<\u0010U\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\b\b\u0001\u0010R\u001a\u00020\u00042\b\b\u0001\u0010S\u001a\u00020\u00042\b\b\u0002\u0010\u001b\u001a\u00020\u001c2\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0007J6\u0010V\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0006\u0010W\u001a\u00020\u00042\u0006\u0010X\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u001c2\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0007J0\u0010Y\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0006\u0010\"\u001a\u00020\u00152\b\b\u0001\u0010T\u001a\u00020\u00042\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0007J6\u0010Z\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0006\u0010W\u001a\u00020\u00042\u0006\u0010X\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u001c2\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000bX\u0082T¢\u0006\u0002\n\u0000¨\u0006]"}, d2 = {"Lcom/android/ttcjpaysdk/base/utils/CJPayAnimationUtils;", "", "()V", "ANIM_FADE", "", "ANIM_HORIZONTAL", "ANIM_HORIZONTAL_IN_LEFT", "ANIM_HORIZONTAL_IN_RIGHT", "ANIM_NONE", "ANIM_VERTICAL", "CCJ_PAY_LINE_COLOR_22", "", "CJ_PAY_BG_LAYER_COLOR", "CJ_PAY_BG_TRANS_COLOR", "CJ_PAY_LINE_COLOR_E8", "baseAnimation", "", PickerReporterConstants.KEY.TARGET, "Landroid/view/View;", "propertyName", "isShow", "", "startValue", "", "endValue", "callback", "Lcom/android/ttcjpaysdk/base/utils/CJPayAnimationUtils$OnAnimationCallback;", "duration", "", "baseAnimationForUnify", "Landroid/animation/Animator;", "animatorListener", "Landroid/animation/AnimatorListenerAdapter;", "bgColorTransition", "isToDarken", "bottomLineDarkAnimation", "createAlphaAnimation", "Landroid/view/animation/AlphaAnimation;", "startAlpha", "endAlpha", "interpolator", "Landroid/view/animation/Interpolator;", "createTranslateAnimation", "Landroid/view/animation/TranslateAnimation;", "startY", "dialogCenterPosAdaptive", LiveEndPageData.TAG_WINDOW, "Landroid/view/Window;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "dialogHeight", "executeAnimation", "anim", "transaction", "Landroidx/fragment/app/FragmentTransaction;", "fadeInOrOutAnimation", "isFadeIn", "activity", "Landroid/app/Activity;", "getAlphaAnimation", "getBaseAnimationInterpolator", "getDefaultCornerRadii", "", "getPaddingRightAnimator", "Landroid/animation/ValueAnimator;", "targetView", "inOrOutWithAnimation", "view", "isWithAnimation", "isVertical", "rightInAndRightOutAnimation", "isRightIn", "setWindowAnimations", "resId", "startSlideUpAnimation", "animationType", "Lcom/android/ttcjpaysdk/base/utils/CJPayAnimationUtils$AnimationType;", "pathInterpolator", "upAndDownAnimation", "isUp", "transHeight", "viewBgColorAnimation", "startColor", "endColor", "res", "viewColorAnimation", "viewHeightAnimation", ShareData.START_HEIGHT, "endHeight", "viewPanelLayerAnimation", "viewXAnimation", "AnimationType", "OnAnimationCallback", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CJPayAnimationUtils {
    public static final int ANIM_FADE = 3;
    public static final int ANIM_HORIZONTAL = 1;
    public static final int ANIM_HORIZONTAL_IN_LEFT = 4;
    public static final int ANIM_HORIZONTAL_IN_RIGHT = 5;
    public static final int ANIM_NONE = 0;
    public static final int ANIM_VERTICAL = 2;
    private static final String CCJ_PAY_LINE_COLOR_22 = "#222222";
    public static final String CJ_PAY_BG_LAYER_COLOR = "#57000000";
    public static final String CJ_PAY_BG_TRANS_COLOR = "#00000000";
    private static final String CJ_PAY_LINE_COLOR_E8 = "#e8e8e8";
    public static final CJPayAnimationUtils INSTANCE = null;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/android/ttcjpaysdk/base/utils/CJPayAnimationUtils$AnimationType;", "", "(Ljava/lang/String;I)V", "SLIDE", "ALPHA", "SLIDE_AND_ALPHA", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final enum AnimationType extends Enum<AnimationType> {
        private static final /* synthetic */ AnimationType[] $VALUES = null;
        public static final AnimationType ALPHA = null;
        public static final AnimationType SLIDE = null;
        public static final AnimationType SLIDE_AND_ALPHA = null;

        private static final /* synthetic */ AnimationType[] $values() {
            return new AnimationType[]{SLIDE, ALPHA, SLIDE_AND_ALPHA};
        }

        public static AnimationType valueOf(String r100) {
            return (AnimationType) a.a(AnimationType.class, r100);
        }

        public static AnimationType[] values() {
            return (AnimationType[]) $VALUES.clone();
        }

        static {
            SLIDE = new AnimationType("SLIDE", 0);
            ALPHA = new AnimationType("ALPHA", 1);
            SLIDE_AND_ALPHA = new AnimationType("SLIDE_AND_ALPHA", 2);
            $VALUES = $values();
        }

        private AnimationType(String r100, int r101) {
            super(r100, r101);
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&¨\u0006\u0005"}, d2 = {"Lcom/android/ttcjpaysdk/base/utils/CJPayAnimationUtils$OnAnimationCallback;", "", "onEndCallback", "", "onStartCallback", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface OnAnimationCallback {
        void onEndCallback();

        void onStartCallback();
    }

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

        static {
            int[] r100 = new int[AnimationType.values().length];
            r100[AnimationType.SLIDE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r100[AnimationType.ALPHA.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r100[AnimationType.SLIDE_AND_ALPHA.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            $EnumSwitchMapping$0 = r100;
        }
    }

    static {
        INSTANCE = new CJPayAnimationUtils();
    }

    private CJPayAnimationUtils() {
    }

    @JvmStatic
    public static final Interpolator getBaseAnimationInterpolator() {
        return new PathInterpolator(0.25f, 0.1f, 0.25f, 1.0f);
    }

    public static View INVOKEVIRTUAL_com_android_ttcjpaysdk_base_utils_CJPayAnimationUtils_com_larus_home_impl_utils_DecorViewLancet_getDecorView(Window r100) {
        View r101 = r100.getDecorView();
        if (c.f346345e == false) goto L7;
        FLogger.f375446a.i("DecorViewLancet", "getDecorView");
        Thread r102 = ThreadMethodProxy.currentThread();
        if (r102 == c.f346341a) goto L7;
        c.a(r102, "getDecorView");
    L7:
        return r101;
    }

    public static final /* synthetic */ float[] access$getDefaultCornerRadii(Context r100) {
        return getDefaultCornerRadii(r100);
    }

    @JvmStatic
    public static final void bottomLineDarkAnimation(View r100) {
        viewColorAnimation$default(r100, ColorProtector.parseColor(CJ_PAY_LINE_COLOR_E8), ColorProtector.parseColor("#222222"), 250, null, 16, null);
    }

    @JvmStatic
    private static final float[] getDefaultCornerRadii(Context r100) {
        if (r100 != null) goto L5;
        return null;
    L5:
        return new float[]{CJPayBasicExtensionKt.dip2pxF(8.0f, r100), CJPayBasicExtensionKt.dip2pxF(8.0f, r100), CJPayBasicExtensionKt.dip2pxF(8.0f, r100), CJPayBasicExtensionKt.dip2pxF(8.0f, r100), 0.0f, 0.0f, 0.0f, 0.0f};
    }

    @JvmStatic
    public static final void bgColorTransition(View r110, boolean r111) {
        String r100 = CJ_PAY_BG_LAYER_COLOR;
        if (r111 == false) goto L5;
        String r101 = CJ_PAY_BG_LAYER_COLOR;
    L6:
        ColorDrawable r102 = null;
        if (r110 == null) goto L9;
        Drawable r103 = r110.getBackground();
    L11:
        if ((r103 instanceof ColorDrawable) == false) goto L13;
        r102 = (ColorDrawable) r103;
    L13:
        boolean r104 = false;
        if (r102 != null) goto L16;
    L18:
        if (r104 == false) goto L20;
        return;
    L20:
        if (r111 == false) goto L22;
        String r105 = "#00000000";
    L23:
        int r106 = ColorProtector.parseColor(r105);
        if (r111 == true) goto L27;
        r100 = "#00000000";
    L27:
        viewColorAnimation$default(r110, r106, ColorProtector.parseColor(r100), 0, null, 24, null);
        return;
    L22:
        r105 = CJ_PAY_BG_LAYER_COLOR;
        goto L23
    L16:
        if (r102.getColor() != ColorProtector.parseColor(r101)) goto L18;
        r104 = true;
        goto L18
    L9:
        r103 = null;
        goto L11
    L5:
        r101 = "#00000000";
        goto L6
    }

    @JvmStatic
    public static final void executeAnimation(int r100, FragmentTransaction r101) {
        if (r100 != 1) goto L5;
        CJPayActivityUtils.executeFragmentAddOrRemoveAnimation(r101);
        return;
    L5:
        if (r100 != 2) goto L7;
        CJPayActivityUtils.executeFragmentAddOrRemovePopupAnimation(r101);
        return;
    L7:
        if (r100 != 3) goto L9;
        CJPayActivityUtils.executeFragmentAddOrRemoveDialogAnimation(r101);
        return;
    L9:
        if (r100 != 4) goto L11;
        CJPayActivityUtils.executeFragmentAddOrRemoveLeftAnimation(r101);
        return;
    L11:
        if (r100 != 5) goto L23;
        CJPayActivityUtils.executeFragmentSlideInRightOutLeftAnimation(r101);
        return;
    }

    @JvmStatic
    public static final void setWindowAnimations(Window r100, int r101) {
        if (r100 == null) goto L5;
        r100.setWindowAnimations(r101);
        return;
    }

    private final TranslateAnimation createTranslateAnimation(float r100, long r101, Interpolator r102) {
        TranslateAnimation r103 = new TranslateAnimation(0.0f, 0.0f, r100, 0.0f);
        r103.setDuration(r101);
        r103.setInterpolator(r102);
        return r103;
    }

    @JvmStatic
    public static final void dialogCenterPosAdaptive(Window r100, Context r101, int r102) {
        if (r100 == null) goto L33;
        Unit r103 = null;
        if ((r101 instanceof Activity) == false) goto L6;
        Activity r104 = (Activity) r101;
    L8:
        if (r104 != null) goto L10;
    L30:
        if (r103 != null) goto L34;
        r100.setGravity(17);
        return;
    L34:
        return;
    L10:
        if (CJPayKotlinExtensionsKt.isAlive(r104) == true) goto L13;
        r104 = null;
    L13:
        if (r104 == null) goto L30;
        boolean r105 = false;
        INVOKEVIRTUAL_com_android_ttcjpaysdk_base_utils_CJPayAnimationUtils_com_larus_home_impl_utils_DecorViewLancet_getDecorView(r100).measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        if (r102 > 0) goto L18;
        r102 = INVOKEVIRTUAL_com_android_ttcjpaysdk_base_utils_CJPayAnimationUtils_com_larus_home_impl_utils_DecorViewLancet_getDecorView(r100).getMeasuredHeight();
    L18:
        int r106 = ((CJPayBasicUtils.getScreenHeight(r104) - r102) / 2) - CJPayBasicUtils.getStatusBarHeight(r104);
        Integer r107 = Integer.valueOf(r102);
        if (r107.intValue() <= 0) goto L22;
        if (r106 <= 0) goto L22;
        r105 = true;
    L22:
        if (r105 == true) goto L25;
        r107 = null;
    L25:
        if (r107 == null) goto L27;
        r107.intValue();
        r100.getAttributes().y = r106;
        r100.setGravity(48);
        r103 = Unit.INSTANCE;
    L27:
        if (r103 != null) goto L29;
        r100.setGravity(17);
    L29:
        r103 = Unit.INSTANCE;
        goto L30
    L6:
        r104 = null;
        goto L8
    }

    private final AlphaAnimation createAlphaAnimation(float r100, float r101, long r102, Interpolator r103) {
        AlphaAnimation r104 = new AlphaAnimation(r100, r101);
        r104.setDuration(r102);
        r104.setInterpolator(r103);
        return r104;
    }

    @JvmStatic
    public static final void rightInAndRightOutAnimation(View r100, boolean r101, Activity r110, OnAnimationCallback r111) {
        if (r110 == null) goto L15;
        CJPayKotlinExtensionsKt.isAlive(r110);
        Integer r102 = Integer.valueOf(CJPayLargeScreenUtils.resolveAnimationWidthPx(r110, r100));
        if (r102.intValue() <= 0) goto L6;
        boolean r103 = true;
    L7:
        if (r103 == true) goto L10;
        r102 = null;
    L10:
        if (r102 == null) goto L12;
        int r112 = r102.intValue();
    L13:
        baseAnimation(r100, LiveDegradeFpsAnimator.TRANSLATION_X, r101, r112, 0.0f, r111, 300);
        return;
    L12:
        r112 = CJPayBasicUtils.getAbsolutePhysicalWidthOfScreen(r110);
        goto L13
    L6:
        r103 = false;
        goto L7
    }

    @JvmStatic
    public static final void upAndDownAnimation(View r100, boolean r101, int r110, OnAnimationCallback r111) {
        baseAnimation(r100, LiveDegradeFpsAnimator.TRANSLATION_Y, r101, r110, 0.0f, r111, 300);
    }

    @JvmStatic
    public static final void viewPanelLayerAnimation(View r110, boolean r111, int r112, OnAnimationCallback r113) {
        String r100 = "#00000000";
        if (r111 == false) goto L5;
        String r101 = "#00000000";
    L6:
        int r102 = ColorProtector.parseColor(r101);
        if (r111 == false) goto L9;
        r100 = CJ_PAY_BG_LAYER_COLOR;
    L9:
        viewBgColorAnimation$default(r110, r102, ColorProtector.parseColor(r100), r112, 0, r113, 16, null);
        return;
    L5:
        r101 = CJ_PAY_BG_LAYER_COLOR;
        goto L6
    }

    public final Animator getAlphaAnimation(View r110, boolean r111, AnimatorListenerAdapter r112, long r113) {
        return baseAnimationForUnify(r110, "alpha", r111, 0.0f, 1.0f, r112, r113);
    }

    public final ValueAnimator getPaddingRightAnimator(final View r100, int r101, int r102, long r103) {
        Intrinsics.checkNotNullParameter(r100, "targetView");
        ValueAnimator r104 = ValueAnimator.ofInt(new int[]{r101, r102});
        r104.setDuration(r103);
        Interpolator r105 = getBaseAnimationInterpolator();
        if (r105 == null) goto L5;
        r104.setInterpolator(r105);
    L5:
        r104.addUpdateListener(new CJPayAnimationUtils$getPaddingRightAnimator$1$2(r100));
        return r104;
    }

    @JvmStatic
    public static final void upAndDownAnimation(View r100, boolean r101, Activity r102, OnAnimationCallback r103) {
        if (r102 == null) goto L5;
        CJPayKotlinExtensionsKt.isAlive(r102);
        upAndDownAnimation(r100, r101, CJPayBasicUtils.getScreenHeight(r102), r103);
        return;
    }

    public static /* synthetic */ void dialogCenterPosAdaptive$default(Window r100, Context r101, int r102, int r103, Object r104) {
        if ((r103 & 4) == 0) goto L5;
        r102 = 0;
    L5:
        dialogCenterPosAdaptive(r100, r101, r102);
    }

    @JvmStatic
    public static final void fadeInOrOutAnimation(View r100, boolean r101, Activity r110, OnAnimationCallback r111, long r112) {
        if (r110 == null) goto L5;
        CJPayKotlinExtensionsKt.isAlive(r110);
        baseAnimation(r100, "alpha", r101, 0.0f, 1.0f, r111, r112);
        return;
    }

    @JvmStatic
    public static final void inOrOutWithAnimation(final Activity r100, final View r101, boolean r102, final boolean r103, final boolean r104) {
        if (r100 == null) goto L13;
        if (r102 == false) goto L6;
        if (r101 == null) goto L14;
        r101.post(new CJPayAnimationUtils$inOrOutWithAnimation$1$1(r100, r104, r101, r103));
        return;
    L14:
        return;
    L6:
        if (r101 == null) goto L16;
        if (r103 == false) goto L10;
        int r105 = 0;
    L11:
        r101.setVisibility(r105);
        return;
    L10:
        r105 = 8;
        goto L11
    L16:
        return;
    }

    @JvmStatic
    public static final void viewColorAnimation(View r100, int r101, int r102, long r103, final OnAnimationCallback r104) {
        if (r100 != null) goto L12;
        return;
    L12:
        r100.setVisibility(0);     // Catch: Exception -> L9
        ObjectAnimator r105 = ObjectAnimator.ofInt(r100, "backgroundColor", new int[]{r101, r102});     // Catch: Exception -> L9
        r105.setDuration(r103);     // Catch: Exception -> L9
        Interpolator r106 = getBaseAnimationInterpolator();     // Catch: Exception -> L9
        if (r106 == null) goto L7;
        r105.setInterpolator(r106);     // Catch: Exception -> L9
    L7:
        r105.setEvaluator(new ArgbEvaluator());     // Catch: Exception -> L9
        r105.addListener(new CJPayAnimationUtils$viewColorAnimation$1$1$2(r104));     // Catch: Exception -> L9
        r105.start();     // Catch: Exception -> L9
        return;
    L9:
        e = move-exception;
        CJBasicCommonUtils.reportCatchException("CJPayAnimationUtils#onAnimationStart", e);
        CJBasicCommonUtils.logCatch("CJCatch", "CJPayAnimationUtils#onAnimationStart", e);
        Unit r107 = Unit.INSTANCE;
    }

    @JvmStatic
    public static final void viewHeightAnimation(final View r100, int r101, int r102, long r103, final OnAnimationCallback r104) {
        if (r100 != null) goto L12;
        return;
    L12:
        r100.setVisibility(0);     // Catch: Exception -> L9
        ValueAnimator r105 = ValueAnimator.ofInt(new int[]{r101, r102});     // Catch: Exception -> L9
        r105.setDuration(r103);     // Catch: Exception -> L9
        Interpolator r106 = getBaseAnimationInterpolator();     // Catch: Exception -> L9
        if (r106 == null) goto L7;
        r105.setInterpolator(r106);     // Catch: Exception -> L9
    L7:
        r105.addUpdateListener(new CJPayAnimationUtils$viewHeightAnimation$1$1$2(r100));     // Catch: Exception -> L9
        r105.addListener(new CJPayAnimationUtils$viewHeightAnimation$1$1$3(r104));     // Catch: Exception -> L9
        r105.start();     // Catch: Exception -> L9
        return;
    L9:
        e = move-exception;
        CJBasicCommonUtils.reportCatchException("CJPayAnimationUtils#onAnimationStart", e);
        CJBasicCommonUtils.logCatch("CJCatch", "CJPayAnimationUtils#onAnimationStart", e);
        Unit r107 = Unit.INSTANCE;
    }

    @JvmStatic
    public static final void viewXAnimation(final View r100, int r101, int r102, long r103, final OnAnimationCallback r104) {
        if (r100 != null) goto L12;
        return;
    L12:
        r100.setVisibility(0);     // Catch: Exception -> L9
        ValueAnimator r105 = ValueAnimator.ofInt(new int[]{r101, r102});     // Catch: Exception -> L9
        r105.setDuration(r103);     // Catch: Exception -> L9
        Interpolator r106 = getBaseAnimationInterpolator();     // Catch: Exception -> L9
        if (r106 == null) goto L7;
        r105.setInterpolator(r106);     // Catch: Exception -> L9
    L7:
        r105.addUpdateListener(new CJPayAnimationUtils$viewXAnimation$1$1$2(r100));     // Catch: Exception -> L9
        r105.addListener(new CJPayAnimationUtils$viewXAnimation$1$1$3(r104));     // Catch: Exception -> L9
        r105.start();     // Catch: Exception -> L9
        return;
    L9:
        e = move-exception;
        CJBasicCommonUtils.reportCatchException("CJPayAnimationUtils#onAnimationStart", e);
        CJBasicCommonUtils.logCatch("CJCatch", "CJPayAnimationUtils#onAnimationStart", e);
        Unit r107 = Unit.INSTANCE;
    }

    public final void upAndDownAnimation(View r100, boolean r110, Activity r111, long r112, OnAnimationCallback r113) {
        if (r111 == null) goto L5;
        CJPayKotlinExtensionsKt.isAlive(r111);
        baseAnimation(r100, LiveDegradeFpsAnimator.TRANSLATION_Y, r110, CJPayBasicUtils.getScreenHeight(r111), 0.0f, r113, r112);
        return;
    }

    @JvmStatic
    public static final void viewBgColorAnimation(final View r100, int r101, int r102, final int r103, long r104, final OnAnimationCallback r105) {
        if (r100 != null) goto L12;
        return;
    L12:
        r100.setVisibility(0);     // Catch: Exception -> L9
        ValueAnimator r106 = ValueAnimator.ofInt(new int[]{r101, r102});     // Catch: Exception -> L9
        r106.setDuration(r104);     // Catch: Exception -> L9
        Interpolator r107 = getBaseAnimationInterpolator();     // Catch: Exception -> L9
        if (r107 == null) goto L7;
        r106.setInterpolator(r107);     // Catch: Exception -> L9
    L7:
        r106.setEvaluator(new ArgbEvaluator());     // Catch: Exception -> L9
        r106.addUpdateListener(new CJPayAnimationUtils$viewBgColorAnimation$1$1$2(r100, r103));     // Catch: Exception -> L9
        r106.addListener(new CJPayAnimationUtils$viewBgColorAnimation$1$1$3(r105));     // Catch: Exception -> L9
        r106.start();     // Catch: Exception -> L9
        return;
    L9:
        e = move-exception;
        CJBasicCommonUtils.reportCatchException("CJPayAnimationUtils#onAnimationStart", e);
        CJBasicCommonUtils.logCatch("CJCatch", "CJPayAnimationUtils#onAnimationStart", e);
        Unit r108 = Unit.INSTANCE;
    }

    public static /* synthetic */ void viewPanelLayerAnimation$default(View r100, boolean r101, int r102, OnAnimationCallback r103, int r104, Object r105) {
        if ((r104 & 8) == 0) goto L5;
        r103 = null;
    L5:
        viewPanelLayerAnimation(r100, r101, r102, r103);
    }

    @JvmStatic
    public static final void baseAnimation(final View r100, String r101, final boolean r102, float r103, float r104, final OnAnimationCallback r110, long r111) {
        if (r100 != null) goto L4;
        return;
    L4:
        if ((!TextUtils.isEmpty(r101)) == false) goto L6;
        View r105 = r100;
    L7:
        if (r105 != null) goto L24;
        return;
    L24:
        r105.setVisibility(0);     // Catch: Exception -> L21
        float[] r106 = new float[2];     // Catch: Exception -> L21
        if (r102 == false) goto L12;
        float r107 = r103;
    L13:
        r106[0] = r107;     // Catch: Exception -> L21
        if (r102 == false) goto L16;
        r103 = r104;
    L16:
        r106[1] = r103;     // Catch: Exception -> L21
        ObjectAnimator r108 = ObjectAnimator.ofFloat(r105, r101, r106);     // Catch: Exception -> L21
        r108.setDuration(r111);     // Catch: Exception -> L21
        Interpolator r109 = getBaseAnimationInterpolator();     // Catch: Exception -> L21
        if (r109 == null) goto L19;
        r108.setInterpolator(r109);     // Catch: Exception -> L21
    L19:
        r108.addListener(new CJPayAnimationUtils$baseAnimation$2$1$2(r102, r100, r110));     // Catch: Exception -> L21
        r108.start();     // Catch: Exception -> L21
        return;
    L12:
        r107 = r104;
    L21:
        e = move-exception;
        CJBasicCommonUtils.reportCatchException("CJPayAnimationUtils#onAnimationStart", e);
        CJBasicCommonUtils.logCatch("CJCatch", "CJPayAnimationUtils#onAnimationStart", e);
        Unit r112 = Unit.INSTANCE;
        return;
    L6:
        r105 = null;
        goto L7
    }

    public static /* synthetic */ void inOrOutWithAnimation$default(Activity r100, View r101, boolean r102, boolean r103, boolean r104, int r105, Object r106) {
        if ((r105 & 16) == 0) goto L5;
        r104 = true;
    L5:
        inOrOutWithAnimation(r100, r101, r102, r103, r104);
    }

    @JvmStatic
    public static final void startSlideUpAnimation(View r100, AnimationType r101, float r110, long r111, float r112, float r113, Interpolator r114) {
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r101, "animationType");
        Intrinsics.checkNotNullParameter(r114, "pathInterpolator");
        AnimationSet r102 = new AnimationSet(true);
        r102.setDuration(r111);
        r102.setInterpolator(r114);
        r102.setFillAfter(true);
        int r103 = WhenMappings.$EnumSwitchMapping$0[r101.ordinal()];
        if (r103 != 1) goto L5;
        r102.addAnimation(INSTANCE.createTranslateAnimation(r110, r111, r114));
    L12:
        r100.startAnimation(r102);
        return;
    L5:
        if (r103 != 2) goto L7;
        r102.addAnimation(INSTANCE.createAlphaAnimation(r112, r113, r111, r114));
        goto L12
    L7:
        if (r103 != 3) goto L12;
        CJPayAnimationUtils r104 = INSTANCE;
        r102.addAnimation(r104.createTranslateAnimation(r110, r111, r114));
        r102.addAnimation(r104.createAlphaAnimation(r112, r113, r111, r114));
        goto L12
    }

    public static /* synthetic */ void viewColorAnimation$default(View r100, int r101, int r102, long r103, OnAnimationCallback r110, int r111, Object r112) {
        if ((r111 & 8) == 0) goto L5;
        r103 = 300;
    L5:
        long r104 = r103;
        if ((r111 & 16) == 0) goto L8;
        r110 = null;
    L8:
        viewColorAnimation(r100, r101, r102, r104, r110);
    }

    public static /* synthetic */ void viewHeightAnimation$default(View r100, int r101, int r102, long r103, OnAnimationCallback r110, int r111, Object r112) {
        if ((r111 & 16) == 0) goto L5;
        r110 = null;
    L5:
        viewHeightAnimation(r100, r101, r102, r103, r110);
    }

    public static /* synthetic */ void viewXAnimation$default(View r100, int r101, int r102, long r103, OnAnimationCallback r110, int r111, Object r112) {
        if ((r111 & 16) == 0) goto L5;
        r110 = null;
    L5:
        viewXAnimation(r100, r101, r102, r103, r110);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v4, types: [T, android.animation.ObjectAnimator] */
    public final Animator baseAnimationForUnify(View r100, String r101, boolean r102, float r103, float r110, AnimatorListenerAdapter r111, long r112) {
        Ref.ObjectRef r104 = new Ref.ObjectRef();
        if (r100 == null) goto L23;
        if ((!TextUtils.isEmpty(r101)) == true) goto L8;
        r100 = null;
    L8:
        if (r100 == null) goto L23;
        float[] r105 = new float[2];
        if (r102 == false) goto L12;
        float r106 = r103;
    L13:
        r105[0] = r106;
        if (r102 == false) goto L16;
        r103 = r110;
    L16:
        r105[1] = r103;
        ?? r107 = ObjectAnimator.ofFloat(r100, r101, r105);
        r107.setDuration(r112);
        Interpolator r108 = getBaseAnimationInterpolator();
        if (r108 == null) goto L19;
        r107.setInterpolator(r108);
    L19:
        if (r111 == null) goto L21;
        r107.addListener(r111);
    L21:
        r104.element = r107;
        goto L23
    L12:
        r106 = r110;
    L23:
        return (Animator) r104.element;
    }

    public static /* synthetic */ void upAndDownAnimation$default(CJPayAnimationUtils r100, View r101, boolean r102, Activity r110, long r111, OnAnimationCallback r112, int r113, Object r114) {
        if ((r113 & 8) == 0) goto L5;
        r111 = 300;
    L5:
        r100.upAndDownAnimation(r101, r102, r110, r111, r112);
    }

    public static /* synthetic */ void viewBgColorAnimation$default(View r100, int r101, int r102, int r110, long r111, OnAnimationCallback r112, int r113, Object r114) {
        if ((r113 & 16) == 0) goto L5;
        r111 = 300;
    L5:
        long r103 = r111;
        if ((r113 & 32) == 0) goto L8;
        r112 = null;
    L8:
        viewBgColorAnimation(r100, r101, r102, r110, r103, r112);
    }

    public static /* synthetic */ void startSlideUpAnimation$default(View r100, AnimationType r101, float r102, long r103, float r110, float r111, Interpolator r112, int r113, Object r114) {
        if ((r113 & 2) == 0) goto L6;
        r101 = AnimationType.SLIDE_AND_ALPHA;
    L6:
        if ((r113 & 4) == 0) goto L8;
        r102 = r100.getHeight();
    L8:
        float r115 = r102;
        if ((r113 & 8) == 0) goto L11;
        r103 = 300;
    L11:
        long r104 = r103;
        if ((r113 & 16) == 0) goto L14;
        float r105 = 0.0f;
    L16:
        if ((r113 & 32) == 0) goto L18;
        float r106 = 1.0f;
    L20:
        if ((r113 & 64) == 0) goto L22;
        r112 = new PathInterpolator(0.42f, 0.0f, 0.58f, 1.0f);
    L22:
        startSlideUpAnimation(r100, r101, r115, r104, r105, r106, r112);
        return;
    L18:
        r106 = r111;
        goto L20
    L14:
        r105 = r110;
        goto L16
    }
}
