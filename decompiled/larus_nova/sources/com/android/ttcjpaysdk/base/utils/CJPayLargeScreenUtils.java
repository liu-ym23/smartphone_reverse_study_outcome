package com.android.ttcjpaysdk.base.utils;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.android.ttcjpaysdk.base.framework.AnimUtil;
import com.android.ttcjpaysdk.base.settings.CJPaySettingsManager;
import com.bytedance.caijing.sdk.infra.base.logger.CJLogger;
import com.bytedance.ee.bear.bitable.fieldedit.BitableFieldEditAnalytic;
import com.larus.home.impl.utils.c;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001:B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J,\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u000bH\u0007J\u0014\u0010\u0014\u001a\u0004\u0018\u00010\u00152\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0002J\u0019\u0010\u0016\u001a\u0004\u0018\u00010\u00062\b\u0010\u0017\u001a\u0004\u0018\u00010\u0011H\u0002¢\u0006\u0002\u0010\u0018J\b\u0010\u0019\u001a\u00020\u001aH\u0007J\u001c\u0010\u001b\u001a\u00020\u001a2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0011H\u0007J\u001a\u0010\u001b\u001a\u00020\u001a2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u001d\u001a\u00020\u0006H\u0007J\u001e\u0010\u001e\u001a\u00020\u00062\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u0011H\u0007J\u001e\u0010 \u001a\u00020\u00062\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u0011H\u0007J\u001a\u0010!\u001a\u00020\u00062\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u001d\u001a\u00020\u0006H\u0007J\"\u0010\"\u001a\u00020\u00062\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010#\u001a\u00020\u00062\u0006\u0010$\u001a\u00020\u0004H\u0007J\u001a\u0010%\u001a\u00020\u00062\b\u0010&\u001a\u0004\u0018\u00010\u00152\u0006\u0010'\u001a\u00020\u0006H\u0007J\u001e\u0010(\u001a\u00020\u00062\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u0011H\u0007J=\u0010)\u001a\u00020\r2\b\u0010*\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0012\u001a\u00020\u000b2!\u0010+\u001a\u001d\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b-\u0012\b\b.\u0012\u0004\b\b(/\u0012\u0004\u0012\u00020\r0,H\u0007J=\u00100\u001a\u00020\r2\b\u0010&\u001a\u0004\u0018\u00010\u00152\u0006\u00101\u001a\u00020\u00062!\u00102\u001a\u001d\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b-\u0012\b\b.\u0012\u0004\b\b(3\u0012\u0004\u0012\u00020\r0,H\u0007J\"\u00104\u001a\u00020\u001a2\u0006\u00105\u001a\u00020\u00062\u0006\u00106\u001a\u00020\u00062\b\b\u0002\u00107\u001a\u00020\u0004H\u0007J\u0018\u00108\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u00109\u001a\u00020\u0006H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082T¢\u0006\u0002\n\u0000¨\u0006;"}, d2 = {"Lcom/android/ttcjpaysdk/base/utils/CJPayLargeScreenUtils;", "", "()V", "LARGE_CONTENT_WIDTH_DP", "", "LARGE_SCREEN_MASK_COLOR", "", "LARGE_SCREEN_MAX_WIDTH_DP", "LARGE_SCREEN_MIN_WIDTH_DP", "MID_LARGE_CONTENT_WIDTH_DP", "TAG", "", "applyCashierContentLayout", "", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "contentView", "Landroid/view/View;", "tag", "reason", "findActivity", "Landroid/app/Activity;", "findWidthFromViewTree", "view", "(Landroid/view/View;)Ljava/lang/Integer;", "isCashierLargeScreenAdaptEnabled", "", "isLargeScreen", "anchorView", "availableWidthPx", "resolveAnimationWidthPx", "targetView", "resolveCashierContentWidthPx", "resolveCashierVisibleWidthPx", "resolveDialogWidthPx", "windowWidthPx", "widthRatio", "resolveRelayoutHostHeightWithInset", "activity", "rootHeight", "resolveWindowWidthPx", "scheduleRelayoutAfterNextLayout", "hostView", "onRelayout", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "hostHeight", "scheduleRelayoutWhenHostHeightSettled", "baselineHeight", "onHostHeightSettled", "settledHeight", "shouldRelayoutForWidthDelta", "previousWidthPx", "currentWidthPx", "thresholdRatio", "updateContentHostWidth", "targetWidth", "ConfigurationBaseline", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CJPayLargeScreenUtils {
    public static final CJPayLargeScreenUtils INSTANCE = null;
    private static final float LARGE_CONTENT_WIDTH_DP = 620.0f;
    public static final int LARGE_SCREEN_MASK_COLOR = 1461065763;
    private static final float LARGE_SCREEN_MAX_WIDTH_DP = 1024.0f;
    private static final float LARGE_SCREEN_MIN_WIDTH_DP = 540.0f;
    private static final float MID_LARGE_CONTENT_WIDTH_DP = 540.0f;
    private static final String TAG = "CJPayLargeScreenUtils";

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0004J\u001a\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012R\u001e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0004@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u001e\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0004@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0007¨\u0006\u0013"}, d2 = {"Lcom/android/ttcjpaysdk/base/utils/CJPayLargeScreenUtils$ConfigurationBaseline;", "", "()V", "<set-?>", "", "orientation", "getOrientation", "()I", "widthPx", "getWidthPx", "isOrientationChanged", "", "newOrientation", "record", "", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "anchorView", "Landroid/view/View;", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class ConfigurationBaseline {
        private int orientation;
        private int widthPx;

        public ConfigurationBaseline() {
        }

        public final int getOrientation() {
            return this.orientation;
        }

        public final int getWidthPx() {
            return this.widthPx;
        }

        public final boolean isOrientationChanged(int r100) {
            int r101 = this.orientation;
            if (r101 == 0) goto L6;
            if (r101 == r100) goto L6;
            return true;
        L6:
            return false;
        }

        public final void record(Context r100, View r101) {
            this.widthPx = CJPayLargeScreenUtils.resolveWindowWidthPx(r100, r101);
            if (r100 == null) goto L10;
            Resources r102 = r100.getResources();
            if (r102 == null) goto L11;
            Configuration r103 = r102.getConfiguration();
            if (r103 == null) goto L12;
            this.orientation = r103.orientation;
            return;
        L12:
            return;
        L11:
            return;
        }
    }

    static {
        INSTANCE = new CJPayLargeScreenUtils();
    }

    private CJPayLargeScreenUtils() {
    }

    @JvmStatic
    public static final boolean isCashierLargeScreenAdaptEnabled() {
        return CJPaySettingsManager.getInstance().isCashierLargeScreenAdaptEnabled();
    }

    public static View INVOKEVIRTUAL_com_android_ttcjpaysdk_base_utils_CJPayLargeScreenUtils_com_larus_home_impl_utils_DecorViewLancet_getDecorView(Window r100) {
        View r101 = r100.getDecorView();
        if (c.f346345e == false) goto L7;
        FLogger.f375446a.i("DecorViewLancet", "getDecorView");
        Thread r102 = ThreadMethodProxy.currentThread();
        if (r102 == c.f346341a) goto L7;
        c.a(r102, "getDecorView");
    L7:
        return r101;
    }

    public static DisplayMetrics INVOKEVIRTUAL_com_android_ttcjpaysdk_base_utils_CJPayLargeScreenUtils_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(Resources r100) {
        return WindowDisplayMetricsOverride.apply(r100, r100.getDisplayMetrics());
    }

    private final Activity findActivity(Context r100) {
    L3:
        if ((r100 instanceof ContextWrapper) == false) goto L9;
        if ((r100 instanceof Activity) == true) goto L7;
        r100 = ((ContextWrapper) r100).getBaseContext();
        goto L3
    L7:
        return (Activity) r100;
    L9:
        return null;
    }

    private final Integer findWidthFromViewTree(View r100) {
    L3:
        if (r100 == null) goto L23;
        ViewGroup.LayoutParams r101 = r100.getLayoutParams();
        int r102 = 0;
        if (r101 == null) goto L7;
        int r103 = r101.width;
    L9:
        if (r100.getWidth() <= 0) goto L12;
        r102 = r100.getWidth();
    L16:
        if (r102 > 0) goto L18;
        Object r104 = r100.getParent();
        if ((r104 instanceof View) == true) goto L21;
        r100 = null;
        goto L3
    L21:
        r100 = (View) r104;
        goto L3
    L18:
        return Integer.valueOf(r102);
    L12:
        if (r100.getMeasuredWidth() <= 0) goto L14;
        r102 = r100.getMeasuredWidth();
        goto L16
    L14:
        if (r103 <= 0) goto L16;
        r102 = r103;
        goto L16
    L7:
        r103 = 0;
        goto L9
    L23:
        return null;
    }

    @JvmStatic
    public static final boolean isLargeScreen(Context r100, int r101) {
        if (isCashierLargeScreenAdaptEnabled() == true) goto L5;
    L7:
        return false;
    L5:
        if (r101 <= CJPayBasicUtils.dipToPX(r100, 540.0f)) goto L7;
        return true;
    }

    @JvmStatic
    public static final int resolveAnimationWidthPx(Context r100, View r101) {
        if (isCashierLargeScreenAdaptEnabled() == false) goto L5;
        Integer r102 = INSTANCE.findWidthFromViewTree(r101);
        if (r102 == null) goto L19;
        if (r102.intValue() <= 0) goto L11;
        boolean r103 = true;
    L12:
        if (r103 == true) goto L15;
        r102 = null;
    L15:
        if (r102 == null) goto L19;
        return r102.intValue();
    L11:
        r103 = false;
    L19:
        return resolveCashierContentWidthPx(r100, r101);
    L5:
        return CJPayBasicUtils.getAbsolutePhysicalWidthOfScreen(r100);
    }

    @JvmStatic
    public static final int resolveCashierContentWidthPx(Context r100, View r101) {
        if (isCashierLargeScreenAdaptEnabled() == false) goto L5;
        Integer r102 = INSTANCE.findWidthFromViewTree(r101);
        if (r102 == null) goto L19;
        if (r102.intValue() <= 0) goto L11;
        boolean r103 = true;
    L12:
        if (r103 == true) goto L15;
        r102 = null;
    L15:
        if (r102 == null) goto L19;
        return r102.intValue();
    L11:
        r103 = false;
    L19:
        return resolveCashierVisibleWidthPx(r100, resolveWindowWidthPx(r100, r101));
    L5:
        return CJPayBasicUtils.getAbsolutePhysicalWidthOfScreen(r100);
    }

    @JvmStatic
    public static final int resolveCashierVisibleWidthPx(Context r100, int r101) {
        if (r101 > 0) goto L6;
        return 0;
    L6:
        if (isCashierLargeScreenAdaptEnabled() == true) goto L9;
        return r101;
    L9:
        if (r101 > CJPayBasicUtils.dipToPX(r100, 540.0f)) goto L12;
        return r101;
    L12:
        if (r101 > CJPayBasicUtils.dipToPX(r100, LARGE_SCREEN_MAX_WIDTH_DP)) goto L14;
        int r102 = CJPayBasicUtils.dipToPX(r100, 540.0f);
    L16:
        return Math.min(r101, r102);
    L14:
        r102 = CJPayBasicUtils.dipToPX(r100, LARGE_CONTENT_WIDTH_DP);
        goto L16
    }

    @JvmStatic
    public static final int resolveRelayoutHostHeightWithInset(Activity r100, int r101) {
        if (r100 != null) goto L4;
        return r101;
    L4:
        int r102 = AnimUtil.getScreenHeight$default(r100, true, false, BitableFieldEditAnalytic.ProgressFieldEditScene.MAX, 4, null);
        if (r102 > 0) goto L7;
        return r101;
    L7:
        return r102;
    }

    @JvmStatic
    public static final int resolveWindowWidthPx(Context r100, View r101) {
        CJPayLargeScreenUtils r102 = INSTANCE;
        Integer r103 = null;
        if (r101 == null) goto L5;
        View r104 = r101.getRootView();
    L6:
        Integer r105 = r102.findWidthFromViewTree(r104);
        if (r105 != null) goto L9;
    L17:
        Activity r106 = r102.findActivity(r100);
        if (r106 != null) goto L20;
    L29:
        if (r100 == null) goto L36;
        Resources r107 = r100.getResources();
        if (r107 == null) goto L37;
        DisplayMetrics r108 = INVOKEVIRTUAL_com_android_ttcjpaysdk_base_utils_CJPayLargeScreenUtils_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(r107);
        if (r108 != null) goto L35;
        return 0;
    L35:
        return r108.widthPixels;
    L37:
        return 0;
    L36:
        return 0;
    L20:
        if (Build.VERSION.SDK_INT < 30) goto L25;
        Rect r109 = r106.getWindowManager().getCurrentWindowMetrics().getBounds();
        if (r109.width() <= 0) goto L29;
        return r109.width();
    L25:
        Rect r110 = new Rect();
        INVOKEVIRTUAL_com_android_ttcjpaysdk_base_utils_CJPayLargeScreenUtils_com_larus_home_impl_utils_DecorViewLancet_getDecorView(r106.getWindow()).getWindowVisibleDisplayFrame(r110);
        if (r110.width() <= 0) goto L29;
        return r110.width();
    L9:
        if (r105.intValue() <= 0) goto L11;
        boolean r111 = true;
    L12:
        if (r111 == false) goto L14;
        r103 = r105;
    L14:
        if (r103 == null) goto L17;
        return r103.intValue();
    L11:
        r111 = false;
        goto L12
    L5:
        r104 = null;
        goto L6
    }

    private final void updateContentHostWidth(View r100, int r101) {
        ViewGroup.LayoutParams r102 = r100.getLayoutParams();
        if (r102 != null) goto L6;
        return;
    L6:
        if (r102.width != r101) goto L8;
        return;
    L8:
        r102.width = r101;
        if ((r102 instanceof FrameLayout.LayoutParams) == false) goto L12;
        ((FrameLayout.LayoutParams) r102).gravity = 81;
    L14:
        r100.setLayoutParams(r102);
        r100.requestLayout();
        return;
    L12:
        if ((r102 instanceof RelativeLayout.LayoutParams) == false) goto L14;
        RelativeLayout.LayoutParams r103 = (RelativeLayout.LayoutParams) r102;
        r103.addRule(14, -1);
        r103.addRule(12, -1);
        goto L14
    }

    @JvmStatic
    public static final boolean isLargeScreen(Context r100, View r101) {
        int r102 = resolveWindowWidthPx(r100, r101);
        if (r102 > 0) goto L5;
    L7:
        return false;
    L5:
        if (isLargeScreen(r100, r102) == false) goto L7;
        return true;
    }

    @JvmStatic
    public static final int resolveDialogWidthPx(Context r100, int r101, float r102) {
        int r103 = resolveCashierVisibleWidthPx(r100, r101);
        if (r103 > 0) goto L7;
        return 0;
    L7:
        return MathKt.roundToInt(r103 * r102);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v2, types: [android.view.View$OnLayoutChangeListener, com.android.ttcjpaysdk.base.utils.CJPayLargeScreenUtils$scheduleRelayoutAfterNextLayout$layoutChangeListener$1] */
    @JvmStatic
    public static final void scheduleRelayoutAfterNextLayout(final View r100, String r101, final Function1<? super Integer, Unit> r102) {
        Intrinsics.checkNotNullParameter(r101, "tag");
        Intrinsics.checkNotNullParameter(r102, "onRelayout");
        if (r100 != 0) goto L6;
        CJLogger.e(r101, "skip scheduleRelayoutAfterNextLayout: hostView is null");
        return;
    L6:
        final Ref.BooleanRef r103 = new Ref.BooleanRef();
        final Function0<Unit> r104 = new CJPayLargeScreenUtils$scheduleRelayoutAfterNextLayout$executeRelayout$1(r103, r102, r100);
        final ?? r105 = new CJPayLargeScreenUtils$scheduleRelayoutAfterNextLayout$layoutChangeListener$1(r100, r104);
        r100.addOnLayoutChangeListener(r105);
        r100.requestLayout();
        r100.post(new AnonymousClass1(r100, r105, r104));
    }

    @JvmStatic
    public static final void scheduleRelayoutWhenHostHeightSettled(final Activity r100, final int r101, final Function1<? super Integer, Unit> r102) {
        Intrinsics.checkNotNullParameter(r102, "onHostHeightSettled");
        if (r100 == null) goto L8;
        if (r101 <= 0) goto L9;
        new Handler(Looper.getMainLooper()).postDelayed(new RunnableC89251(r100, r101, r102), 500);
        return;
    L9:
        return;
    }

    @JvmStatic
    public static final boolean shouldRelayoutForWidthDelta(int r100, int r101, float r102) {
        if (isCashierLargeScreenAdaptEnabled() == true) goto L5;
        return false;
    L5:
        if (r100 <= 0) goto L12;
        if (r101 > 0) goto L9;
        return false;
    L9:
        if (Math.abs(r101 - r100) <= MathKt.roundToInt(r100 * r102)) goto L13;
        return true;
    L13:
        return false;
    L12:
        return false;
    }

    @JvmStatic
    public static final void applyCashierContentLayout(Context r100, View r101, String r102, String r103) {
        Intrinsics.checkNotNullParameter(r102, "tag");
        Intrinsics.checkNotNullParameter(r103, "reason");
        if (r101 != null) goto L6;
        CJLogger.e(r102, "skip large-screen layout: contentView is null, reason=" + r103);
        return;
    L6:
        int r104 = resolveWindowWidthPx(r100, r101);
        if (r104 > 0) goto L10;
        CJLogger.e(r102, "skip large-screen layout: invalid rootWidth=" + r104 + ", reason=" + r103);
        return;
    L10:
        boolean r105 = isLargeScreen(r100, r104);
        if (r105 == false) goto L13;
        int r106 = resolveCashierVisibleWidthPx(r100, r104);
    L14:
        INSTANCE.updateContentHostWidth(r101, r106);
        CJLogger.d(r102, "apply large-screen layout, reason=" + r103 + ", rootWidth=" + r104 + ", targetWidth=" + r106 + ", isLargeScreen=" + r105);
        return;
    L13:
        r106 = -1;
        goto L14
    }

    public static /* synthetic */ int resolveAnimationWidthPx$default(Context r100, View r101, int r102, Object r103) {
        if ((r102 & 2) == 0) goto L6;
        r101 = null;
    L6:
        return resolveAnimationWidthPx(r100, r101);
    }

    public static /* synthetic */ int resolveCashierContentWidthPx$default(Context r100, View r101, int r102, Object r103) {
        if ((r102 & 2) == 0) goto L6;
        r101 = null;
    L6:
        return resolveCashierContentWidthPx(r100, r101);
    }

    public static /* synthetic */ int resolveWindowWidthPx$default(Context r100, View r101, int r102, Object r103) {
        if ((r102 & 2) == 0) goto L6;
        r101 = null;
    L6:
        return resolveWindowWidthPx(r100, r101);
    }

    public static /* synthetic */ boolean shouldRelayoutForWidthDelta$default(int r100, int r101, float r102, int r103, Object r104) {
        if ((r103 & 4) == 0) goto L6;
        r102 = 0.25f;
    L6:
        return shouldRelayoutForWidthDelta(r100, r101, r102);
    }
}
