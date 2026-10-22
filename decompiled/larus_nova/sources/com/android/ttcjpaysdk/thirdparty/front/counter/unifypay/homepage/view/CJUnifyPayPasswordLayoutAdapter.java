package com.android.ttcjpaysdk.thirdparty.front.counter.unifypay.homepage.view;

import android.content.res.Resources;
import android.graphics.Rect;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import com.bytedance.caijing.sdk.infra.base.logger.CJLogger;
import com.larus.nova.R;
import com.lynx.serval.svg.SVGRenderEngine;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import r27.a;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b%\b\u0000\u0018\u0000 Y2\u00020\u0001:\u0005XYZ[\\BA\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n\u0012\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\n¢\u0006\u0002\u0010\rJ\b\u0010'\u001a\u00020(H\u0002J\b\u0010)\u001a\u00020(H\u0002J\u0010\u0010*\u001a\u00020\u000b2\u0006\u0010+\u001a\u00020\u000fH\u0002J\b\u0010,\u001a\u00020(H\u0002J\b\u0010-\u001a\u00020(H\u0002J\b\u0010.\u001a\u00020(H\u0002J\n\u0010/\u001a\u0004\u0018\u00010\u000fH\u0002J\u0006\u00100\u001a\u00020(J\b\u00101\u001a\u00020(H\u0002J\n\u00102\u001a\u0004\u0018\u00010\u0005H\u0002J\u0010\u00103\u001a\u00020\u00132\u0006\u00104\u001a\u00020\u0013H\u0002J\u0010\u00105\u001a\u00020\u000b2\u0006\u0010+\u001a\u00020\u000fH\u0002J\n\u00106\u001a\u0004\u0018\u00010\u0019H\u0002J \u00107\u001a\u0002082\u0006\u00109\u001a\u00020\u00052\u0006\u0010:\u001a\u00020\u00192\u0006\u0010;\u001a\u00020\u0013H\u0002J\b\u0010<\u001a\u00020\u0019H\u0002J\u0010\u0010=\u001a\u00020\u000b2\u0006\u0010+\u001a\u00020\u000fH\u0002J\b\u0010>\u001a\u00020\u000bH\u0002J\u000e\u0010?\u001a\u00020(2\u0006\u00109\u001a\u00020\u0005J\u0010\u0010@\u001a\u00020\u000b2\u0006\u0010:\u001a\u00020\u0019H\u0002J$\u0010A\u001a\u00020(2\u0006\u0010B\u001a\u00020\u00052\u0006\u0010C\u001a\u00020\u00032\n\b\u0002\u0010D\u001a\u0004\u0018\u00010\u0015H\u0002J\u0006\u0010E\u001a\u00020(J\u0010\u0010F\u001a\u00020\u00192\u0006\u00109\u001a\u00020\u0005H\u0002J\b\u0010G\u001a\u00020(H\u0002J\u0006\u0010H\u001a\u00020(J\u0014\u0010I\u001a\u00020(2\n\b\u0002\u0010J\u001a\u0004\u0018\u00010 H\u0002J\b\u0010K\u001a\u00020(H\u0002J\u0010\u0010L\u001a\u00020\u00132\u0006\u0010+\u001a\u00020\u000fH\u0002J\b\u0010M\u001a\u00020(H\u0002J\u0006\u0010N\u001a\u00020(J\b\u0010O\u001a\u00020(H\u0002J\b\u0010P\u001a\u00020(H\u0002J\b\u0010Q\u001a\u00020(H\u0002J\u0010\u0010R\u001a\u00020(2\u0006\u0010S\u001a\u00020\u0013H\u0002J\b\u0010T\u001a\u00020(H\u0002J\u000e\u0010U\u001a\u0004\u0018\u00010\u0005*\u00020\u0003H\u0002J\f\u0010V\u001a\u00020\u0019*\u00020\u0019H\u0002J\f\u0010W\u001a\u00020(*\u00020\u0005H\u0002R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001f\u001a\u0004\u0018\u00010 X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010!\u001a\u0004\u0018\u00010\"X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010#\u001a\u0004\u0018\u00010$X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010%\u001a\u0004\u0018\u00010&X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006]"}, d2 = {"Lcom/android/ttcjpaysdk/thirdparty/front/counter/unifypay/homepage/view/CJUnifyPayPasswordLayoutAdapter;", "", "paymentRoot", "Landroid/view/ViewGroup;", "cashierRoot", "Landroid/view/View;", "inlineHost", "overlayHost", "Landroid/widget/FrameLayout;", "isPasswordVerifyActive", "Lkotlin/Function0;", "", "isPageAnimationFinished", "(Landroid/view/ViewGroup;Landroid/view/View;Landroid/view/ViewGroup;Landroid/widget/FrameLayout;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)V", "candidateSnapshot", "Lcom/android/ttcjpaysdk/thirdparty/front/counter/unifypay/homepage/view/CJUnifyPayPasswordLayoutAdapter$LayoutSnapshot;", "cashierExpansion", "Lcom/android/ttcjpaysdk/thirdparty/front/counter/unifypay/homepage/view/CJUnifyPayPasswordLayoutAdapter$CashierExpansion;", "checkGeneration", "", "inlineContentLayoutParams", "Landroid/view/ViewGroup$LayoutParams;", "isOverlayExitAnimating", "isReleased", "layoutDecisionSafeRect", "Landroid/graphics/Rect;", "layoutMode", "Lcom/android/ttcjpaysdk/thirdparty/front/counter/unifypay/homepage/view/CJUnifyPayPasswordLayoutAdapter$LayoutMode;", "missingTargetRetryCount", "mountedVerifyContent", "observedVerifyContent", "pendingPreDrawListener", "Landroid/view/ViewTreeObserver$OnPreDrawListener;", "pendingPreDrawObserver", "Landroid/view/ViewTreeObserver;", "pendingScheduleRunnable", "Ljava/lang/Runnable;", "verifyContentLayoutListener", "Landroid/view/View$OnLayoutChangeListener;", "animateOverlayExit", "", "bindVerifyContentLayoutListener", "canExpandCashier", "snapshot", "cancelOverlayAnimation", "cancelOverlayExitIfNeeded", "cancelPendingCheck", "captureLayoutSnapshot", "checkAfterLayoutUpdate", "clearCandidateSnapshot", "currentVerifyContent", "dpToPx", "dp", "expandCashier", "getHostVisibleRect", "getVisibility", "Lcom/android/ttcjpaysdk/thirdparty/front/counter/unifypay/homepage/view/CJUnifyPayPasswordLayoutAdapter$ViewVisibility;", "view", "safeRect", "tolerance", "getWindowVisibleRect", "handleLayoutSnapshot", "isLayoutStableForSampling", "mountPreVerifyView", "moveContentToOverlay", "moveToHost", "content", "host", "layoutParams", "onGlobalLayout", "rawGlobalRect", "reapplyCashierExpansionIfNeeded", "release", "removePreDrawListener", "listener", "requestStableLayoutCheck", "requiredExtraHeight", "resetOverlayHost", SVGRenderEngine.RESTORE, "restoreCashierBounds", "restoreContentToInline", "restoreInlineLayout", "scheduleStablePreDrawCheck", "generation", "unbindVerifyContentLayoutListener", "findLastVisibleChild", "offsetToScreenCoordinates", "removeFromParent", "CashierExpansion", "Companion", "LayoutMode", "LayoutSnapshot", "ViewVisibility", "bdpay-front-counter_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CJUnifyPayPasswordLayoutAdapter {
    private static final Companion Companion = null;
    public static final int MAX_MISSING_TARGET_RETRY = 1;
    public static final long OVERLAY_FADE_DURATION_MS = 100;
    public static final String TAG = "CJUnifyPwdLayout";
    public static final int VISIBILITY_TOLERANCE_DP = 1;
    private LayoutSnapshot candidateSnapshot;
    private CashierExpansion cashierExpansion;
    private final View cashierRoot;
    private int checkGeneration;
    private ViewGroup.LayoutParams inlineContentLayoutParams;
    private final ViewGroup inlineHost;
    private boolean isOverlayExitAnimating;
    private final Function0<Boolean> isPageAnimationFinished;
    private final Function0<Boolean> isPasswordVerifyActive;
    private boolean isReleased;
    private Rect layoutDecisionSafeRect;
    private LayoutMode layoutMode;
    private int missingTargetRetryCount;
    private View mountedVerifyContent;
    private View observedVerifyContent;
    private final FrameLayout overlayHost;
    private final ViewGroup paymentRoot;
    private ViewTreeObserver.OnPreDrawListener pendingPreDrawListener;
    private ViewTreeObserver pendingPreDrawObserver;
    private Runnable pendingScheduleRunnable;
    private View.OnLayoutChangeListener verifyContentLayoutListener;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J1\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\u0018"}, d2 = {"Lcom/android/ttcjpaysdk/thirdparty/front/counter/unifypay/homepage/view/CJUnifyPayPasswordLayoutAdapter$CashierExpansion;", "", "originalHeight", "", "originalTopMargin", "expandedHeight", "expandedTopMargin", "(IIII)V", "getExpandedHeight", "()I", "getExpandedTopMargin", "getOriginalHeight", "getOriginalTopMargin", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "", "bdpay-front-counter_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class CashierExpansion {
        private final int expandedHeight;
        private final int expandedTopMargin;
        private final int originalHeight;
        private final int originalTopMargin;

        public static /* synthetic */ CashierExpansion copy$default(CashierExpansion r100, int r101, int r102, int r103, int r104, int r105, Object r106) {
            if ((r105 & 1) == 0) goto L6;
            r101 = r100.originalHeight;
        L6:
            if ((r105 & 2) == 0) goto L9;
            r102 = r100.originalTopMargin;
        L9:
            if ((r105 & 4) == 0) goto L12;
            r103 = r100.expandedHeight;
        L12:
            if ((r105 & 8) == 0) goto L15;
            r104 = r100.expandedTopMargin;
        L15:
            return r100.copy(r101, r102, r103, r104);
        }

        public final int component1() {
            return this.originalHeight;
        }

        public final int component2() {
            return this.originalTopMargin;
        }

        public final int component3() {
            return this.expandedHeight;
        }

        public final int component4() {
            return this.expandedTopMargin;
        }

        public final CashierExpansion copy(int r100, int r101, int r102, int r103) {
            return new CashierExpansion(r100, r101, r102, r103);
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof CashierExpansion) == true) goto L8;
            return false;
        L8:
            CashierExpansion r101 = (CashierExpansion) r100;
            if (this.originalHeight == r101.originalHeight) goto L12;
            return false;
        L12:
            if (this.originalTopMargin == r101.originalTopMargin) goto L15;
            return false;
        L15:
            if (this.expandedHeight == r101.expandedHeight) goto L18;
            return false;
        L18:
            if (this.expandedTopMargin == r101.expandedTopMargin) goto L20;
            return false;
        L20:
            return true;
        }

        public int hashCode() {
            return (((((this.originalHeight * 31) + this.originalTopMargin) * 31) + this.expandedHeight) * 31) + this.expandedTopMargin;
        }

        public String toString() {
            return "CashierExpansion(originalHeight=" + this.originalHeight + ", originalTopMargin=" + this.originalTopMargin + ", expandedHeight=" + this.expandedHeight + ", expandedTopMargin=" + this.expandedTopMargin + ')';
        }

        public final int getExpandedHeight() {
            return this.expandedHeight;
        }

        public final int getExpandedTopMargin() {
            return this.expandedTopMargin;
        }

        public final int getOriginalHeight() {
            return this.originalHeight;
        }

        public final int getOriginalTopMargin() {
            return this.originalTopMargin;
        }

        public CashierExpansion(int r100, int r101, int r102, int r103) {
            this.originalHeight = r100;
            this.originalTopMargin = r101;
            this.expandedHeight = r102;
            this.expandedTopMargin = r103;
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0082\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/android/ttcjpaysdk/thirdparty/front/counter/unifypay/homepage/view/CJUnifyPayPasswordLayoutAdapter$Companion;", "", "()V", "MAX_MISSING_TARGET_RETRY", "", "OVERLAY_FADE_DURATION_MS", "", "TAG", "", "VISIBILITY_TOLERANCE_DP", "bdpay-front-counter_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0082\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/android/ttcjpaysdk/thirdparty/front/counter/unifypay/homepage/view/CJUnifyPayPasswordLayoutAdapter$LayoutMode;", "", "(Ljava/lang/String;I)V", "INLINE", "CASHIER_EXPANDED", "VERIFY_OVERLAY", "bdpay-front-counter_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final enum LayoutMode extends Enum<LayoutMode> {
        private static final /* synthetic */ LayoutMode[] $VALUES = null;
        public static final LayoutMode CASHIER_EXPANDED = null;
        public static final LayoutMode INLINE = null;
        public static final LayoutMode VERIFY_OVERLAY = null;

        private static final /* synthetic */ LayoutMode[] $values() {
            return new LayoutMode[]{INLINE, CASHIER_EXPANDED, VERIFY_OVERLAY};
        }

        public static LayoutMode valueOf(String r100) {
            return (LayoutMode) a.a(LayoutMode.class, r100);
        }

        public static LayoutMode[] values() {
            return (LayoutMode[]) $VALUES.clone();
        }

        static {
            INLINE = new LayoutMode("INLINE", 0);
            CASHIER_EXPANDED = new LayoutMode("CASHIER_EXPANDED", 1);
            VERIFY_OVERLAY = new LayoutMode("VERIFY_OVERLAY", 2);
            $VALUES = $values();
        }

        private LayoutMode(String r100, int r101) {
            super(r100, r101);
        }
    }

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0016\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B=\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0002\u0010\u000bJ\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\t\u0010 \u001a\u00020\u0003HÆ\u0003J\t\u0010!\u001a\u00020\tHÆ\u0003J\t\u0010\"\u001a\u00020\tHÆ\u0003JO\u0010#\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\tHÆ\u0001J\u0013\u0010$\u001a\u00020\u00132\b\u0010%\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\u0016\u0010&\u001a\u00020\u00132\u0006\u0010%\u001a\u00020\u00002\u0006\u0010'\u001a\u00020\rJ\t\u0010(\u001a\u00020\rHÖ\u0001J\t\u0010)\u001a\u00020*HÖ\u0001R\u0011\u0010\f\u001a\u00020\r8F¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0012\u001a\u00020\u00138F¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0014R\u0011\u0010\n\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0016R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0011R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0011R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0011R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0011¨\u0006+"}, d2 = {"Lcom/android/ttcjpaysdk/thirdparty/front/counter/unifypay/homepage/view/CJUnifyPayPasswordLayoutAdapter$LayoutSnapshot;", "", "safeRect", "Landroid/graphics/Rect;", "paymentRect", "windowVisibleRect", "cashierRect", "verifyRect", "passwordInput", "Lcom/android/ttcjpaysdk/thirdparty/front/counter/unifypay/homepage/view/CJUnifyPayPasswordLayoutAdapter$ViewVisibility;", "keyboardBottomRow", "(Landroid/graphics/Rect;Landroid/graphics/Rect;Landroid/graphics/Rect;Landroid/graphics/Rect;Landroid/graphics/Rect;Lcom/android/ttcjpaysdk/thirdparty/front/counter/unifypay/homepage/view/CJUnifyPayPasswordLayoutAdapter$ViewVisibility;Lcom/android/ttcjpaysdk/thirdparty/front/counter/unifypay/homepage/view/CJUnifyPayPasswordLayoutAdapter$ViewVisibility;)V", "bottomDeficit", "", "getBottomDeficit", "()I", "getCashierRect", "()Landroid/graphics/Rect;", "isFullyVisible", "", "()Z", "getKeyboardBottomRow", "()Lcom/android/ttcjpaysdk/thirdparty/front/counter/unifypay/homepage/view/CJUnifyPayPasswordLayoutAdapter$ViewVisibility;", "getPasswordInput", "getPaymentRect", "getSafeRect", "getVerifyRect", "getWindowVisibleRect", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "other", "hasSameGeometry", "tolerance", "hashCode", "toString", "", "bdpay-front-counter_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class LayoutSnapshot {
        private final Rect cashierRect;
        private final ViewVisibility keyboardBottomRow;
        private final ViewVisibility passwordInput;
        private final Rect paymentRect;
        private final Rect safeRect;
        private final Rect verifyRect;
        private final Rect windowVisibleRect;

        public static /* synthetic */ LayoutSnapshot copy$default(LayoutSnapshot r100, Rect r101, Rect r102, Rect r103, Rect r104, Rect r110, ViewVisibility r111, ViewVisibility r112, int r113, Object r114) {
            if ((r113 & 1) == 0) goto L6;
            r101 = r100.safeRect;
        L6:
            if ((r113 & 2) == 0) goto L8;
            r102 = r100.paymentRect;
        L8:
            Rect r115 = r102;
            if ((r113 & 4) == 0) goto L11;
            r103 = r100.windowVisibleRect;
        L11:
            Rect r105 = r103;
            if ((r113 & 8) == 0) goto L14;
            r104 = r100.cashierRect;
        L14:
            Rect r106 = r104;
            if ((r113 & 16) == 0) goto L17;
            r110 = r100.verifyRect;
        L17:
            Rect r107 = r110;
            if ((r113 & 32) == 0) goto L20;
            r111 = r100.passwordInput;
        L20:
            ViewVisibility r108 = r111;
            if ((r113 & 64) == 0) goto L23;
            r112 = r100.keyboardBottomRow;
        L23:
            Rect r109 = r101;
            return r100.copy(r109, r115, r105, r106, r107, r108, r112);
        }

        public final Rect component1() {
            return this.safeRect;
        }

        public final Rect component2() {
            return this.paymentRect;
        }

        public final Rect component3() {
            return this.windowVisibleRect;
        }

        public final Rect component4() {
            return this.cashierRect;
        }

        public final Rect component5() {
            return this.verifyRect;
        }

        public final ViewVisibility component6() {
            return this.passwordInput;
        }

        public final ViewVisibility component7() {
            return this.keyboardBottomRow;
        }

        public final LayoutSnapshot copy(Rect r110, Rect r111, Rect r112, Rect r113, Rect r114, ViewVisibility r115, ViewVisibility r116) {
            Intrinsics.checkNotNullParameter(r110, "safeRect");
            Intrinsics.checkNotNullParameter(r111, "paymentRect");
            Intrinsics.checkNotNullParameter(r112, "windowVisibleRect");
            Intrinsics.checkNotNullParameter(r113, "cashierRect");
            Intrinsics.checkNotNullParameter(r114, "verifyRect");
            Intrinsics.checkNotNullParameter(r115, "passwordInput");
            Intrinsics.checkNotNullParameter(r116, "keyboardBottomRow");
            return new LayoutSnapshot(r110, r111, r112, r113, r114, r115, r116);
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof LayoutSnapshot) == true) goto L8;
            return false;
        L8:
            LayoutSnapshot r101 = (LayoutSnapshot) r100;
            if (Intrinsics.areEqual(this.safeRect, r101.safeRect) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.paymentRect, r101.paymentRect) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.windowVisibleRect, r101.windowVisibleRect) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.cashierRect, r101.cashierRect) == true) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.verifyRect, r101.verifyRect) == true) goto L24;
            return false;
        L24:
            if (Intrinsics.areEqual(this.passwordInput, r101.passwordInput) == true) goto L27;
            return false;
        L27:
            if (Intrinsics.areEqual(this.keyboardBottomRow, r101.keyboardBottomRow) == true) goto L29;
            return false;
        L29:
            return true;
        }

        public int hashCode() {
            return (((((((((((this.safeRect.hashCode() * 31) + this.paymentRect.hashCode()) * 31) + this.windowVisibleRect.hashCode()) * 31) + this.cashierRect.hashCode()) * 31) + this.verifyRect.hashCode()) * 31) + this.passwordInput.hashCode()) * 31) + this.keyboardBottomRow.hashCode();
        }

        public String toString() {
            return "LayoutSnapshot(safeRect=" + this.safeRect + ", paymentRect=" + this.paymentRect + ", windowVisibleRect=" + this.windowVisibleRect + ", cashierRect=" + this.cashierRect + ", verifyRect=" + this.verifyRect + ", passwordInput=" + this.passwordInput + ", keyboardBottomRow=" + this.keyboardBottomRow + ')';
        }

        public final int getBottomDeficit() {
            return RangesKt.coerceAtLeast(Math.max(this.passwordInput.getRawRect().bottom, this.keyboardBottomRow.getRawRect().bottom) - this.safeRect.bottom, 0);
        }

        public final boolean isFullyVisible() {
            if (this.passwordInput.isFullyVisible() == true) goto L5;
        L7:
            return false;
        L5:
            if (this.keyboardBottomRow.isFullyVisible() == false) goto L7;
            return true;
        }

        public final Rect getCashierRect() {
            return this.cashierRect;
        }

        public final ViewVisibility getKeyboardBottomRow() {
            return this.keyboardBottomRow;
        }

        public final ViewVisibility getPasswordInput() {
            return this.passwordInput;
        }

        public final Rect getPaymentRect() {
            return this.paymentRect;
        }

        public final Rect getSafeRect() {
            return this.safeRect;
        }

        public final Rect getVerifyRect() {
            return this.verifyRect;
        }

        public final Rect getWindowVisibleRect() {
            return this.windowVisibleRect;
        }

        public final boolean hasSameGeometry(LayoutSnapshot r100, int r101) {
            Intrinsics.checkNotNullParameter(r100, "other");
            if (CJUnifyPayPasswordLayoutAdapterKt.access$isNear(this.safeRect, r100.safeRect, r101) == true) goto L5;
        L15:
            return false;
        L5:
            if (CJUnifyPayPasswordLayoutAdapterKt.access$isNear(this.paymentRect, r100.paymentRect, r101) == false) goto L15;
            if (CJUnifyPayPasswordLayoutAdapterKt.access$isNear(this.cashierRect, r100.cashierRect, r101) == false) goto L15;
            if (CJUnifyPayPasswordLayoutAdapterKt.access$isNear(this.verifyRect, r100.verifyRect, r101) == false) goto L15;
            if (CJUnifyPayPasswordLayoutAdapterKt.access$isNear(this.passwordInput.getRawRect(), r100.passwordInput.getRawRect(), r101) == false) goto L15;
            if (CJUnifyPayPasswordLayoutAdapterKt.access$isNear(this.keyboardBottomRow.getRawRect(), r100.keyboardBottomRow.getRawRect(), r101) == false) goto L15;
            return true;
        }

        public LayoutSnapshot(Rect r100, Rect r101, Rect r102, Rect r103, Rect r104, ViewVisibility r105, ViewVisibility r106) {
            Intrinsics.checkNotNullParameter(r100, "safeRect");
            Intrinsics.checkNotNullParameter(r101, "paymentRect");
            Intrinsics.checkNotNullParameter(r102, "windowVisibleRect");
            Intrinsics.checkNotNullParameter(r103, "cashierRect");
            Intrinsics.checkNotNullParameter(r104, "verifyRect");
            Intrinsics.checkNotNullParameter(r105, "passwordInput");
            Intrinsics.checkNotNullParameter(r106, "keyboardBottomRow");
            this.safeRect = r100;
            this.paymentRect = r101;
            this.windowVisibleRect = r102;
            this.cashierRect = r103;
            this.verifyRect = r104;
            this.passwordInput = r105;
            this.keyboardBottomRow = r106;
        }
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\r\u001a\u00020\u00052\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u0013"}, d2 = {"Lcom/android/ttcjpaysdk/thirdparty/front/counter/unifypay/homepage/view/CJUnifyPayPasswordLayoutAdapter$ViewVisibility;", "", "rawRect", "Landroid/graphics/Rect;", "isFullyVisible", "", "(Landroid/graphics/Rect;Z)V", "()Z", "getRawRect", "()Landroid/graphics/Rect;", "component1", "component2", "copy", "equals", "other", "hashCode", "", "toString", "", "bdpay-front-counter_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class ViewVisibility {
        private final boolean isFullyVisible;
        private final Rect rawRect;

        public static /* synthetic */ ViewVisibility copy$default(ViewVisibility r100, Rect r101, boolean r102, int r103, Object r104) {
            if ((r103 & 1) == 0) goto L6;
            r101 = r100.rawRect;
        L6:
            if ((r103 & 2) == 0) goto L9;
            r102 = r100.isFullyVisible;
        L9:
            return r100.copy(r101, r102);
        }

        public final Rect component1() {
            return this.rawRect;
        }

        public final boolean component2() {
            return this.isFullyVisible;
        }

        public final ViewVisibility copy(Rect r100, boolean r101) {
            Intrinsics.checkNotNullParameter(r100, "rawRect");
            return new ViewVisibility(r100, r101);
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof ViewVisibility) == true) goto L8;
            return false;
        L8:
            ViewVisibility r101 = (ViewVisibility) r100;
            if (Intrinsics.areEqual(this.rawRect, r101.rawRect) == true) goto L12;
            return false;
        L12:
            if (this.isFullyVisible == r101.isFullyVisible) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            int r100 = this.rawRect.hashCode() * 31;
            if (this.isFullyVisible == false) goto L5;
            int r101 = 1231;
        L7:
            return r100 + r101;
        L5:
            r101 = 1237;
            goto L7
        }

        public String toString() {
            return "ViewVisibility(rawRect=" + this.rawRect + ", isFullyVisible=" + this.isFullyVisible + ')';
        }

        public final Rect getRawRect() {
            return this.rawRect;
        }

        public final boolean isFullyVisible() {
            return this.isFullyVisible;
        }

        public ViewVisibility(Rect r100, boolean r101) {
            Intrinsics.checkNotNullParameter(r100, "rawRect");
            this.rawRect = r100;
            this.isFullyVisible = r101;
        }
    }

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

        static {
            int[] r100 = new int[LayoutMode.values().length];
            r100[LayoutMode.INLINE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r100[LayoutMode.CASHIER_EXPANDED.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r100[LayoutMode.VERIFY_OVERLAY.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            $EnumSwitchMapping$0 = r100;
        }
    }

    static {
        Companion = new Companion(null);
    }

    private final void cancelOverlayAnimation() {
        this.isOverlayExitAnimating = false;
        this.overlayHost.animate().setListener(null).cancel();
    }

    private final void clearCandidateSnapshot() {
        this.candidateSnapshot = null;
    }

    private final void animateOverlayExit() {
        if (this.isOverlayExitAnimating == false) goto L5;
        return;
    L5:
        CJLogger.d(TAG, "start password overlay exit animation");
        cancelOverlayAnimation();
        this.isOverlayExitAnimating = true;
        this.overlayHost.animate().alpha(0.0f).setDuration(100).setListener(new AnonymousClass1(this)).start();
    }

    private final void cancelOverlayExitIfNeeded() {
        if (this.isOverlayExitAnimating == true) goto L5;
        return;
    L5:
        CJLogger.d(TAG, "password verify became active again, cancel overlay exit animation");
        cancelOverlayAnimation();
        this.overlayHost.setAlpha(1.0f);
    }

    private final void cancelPendingCheck() {
        this.checkGeneration++;
        clearCandidateSnapshot();
        Runnable r100 = this.pendingScheduleRunnable;
        if (r100 == null) goto L5;
        this.paymentRoot.removeCallbacks(r100);
    L5:
        this.pendingScheduleRunnable = null;
        removePreDrawListener$default(this, null, 1, null);
    }

    private final View currentVerifyContent() {
        View r100 = this.mountedVerifyContent;
        if (r100 == null) goto L14;
        if (r100.getParent() != this.inlineHost) goto L7;
    L10:
        boolean r101 = true;
    L11:
        if (r101 == false) goto L14;
        return r100;
    L7:
        if (r100.getParent() == this.overlayHost) goto L10;
        r101 = false;
    L14:
        return null;
    }

    private final Rect getHostVisibleRect() {
        Rect r100 = new Rect();
        if (this.paymentRoot.getGlobalVisibleRect(r100) == true) goto L5;
    L9:
        boolean r101 = false;
    L11:
        if (r101 == true) goto L14;
        r100 = null;
    L14:
        if (r100 != null) goto L16;
        return null;
    L16:
        return offsetToScreenCoordinates(r100);
    L5:
        if (r100.width() <= 0) goto L9;
        if (r100.height() <= 0) goto L9;
        r101 = true;
        goto L11
    }

    private final Rect getWindowVisibleRect() {
        Rect r100 = new Rect();
        this.paymentRoot.getWindowVisibleDisplayFrame(r100);
        return r100;
    }

    private final void reapplyCashierExpansionIfNeeded() {
        if (this.layoutMode == LayoutMode.CASHIER_EXPANDED) goto L5;
        return;
    L5:
        CashierExpansion r100 = this.cashierExpansion;
        if (r100 != null) goto L8;
        return;
    L8:
        ViewGroup.LayoutParams r101 = this.cashierRoot.getLayoutParams();
        if ((r101 instanceof ViewGroup.MarginLayoutParams) == false) goto L11;
        ViewGroup.MarginLayoutParams r102 = (ViewGroup.MarginLayoutParams) r101;
    L12:
        if (r102 != null) goto L15;
        return;
    L15:
        if (r102.height == r100.getExpandedHeight()) goto L17;
    L18:
        r102.height = r100.getExpandedHeight();
        r102.topMargin = r100.getExpandedTopMargin();
        this.cashierRoot.setLayoutParams(r102);
        return;
    L17:
        if (r102.topMargin != r100.getExpandedTopMargin()) goto L18;
        return;
    L11:
        r102 = null;
        goto L12
    }

    private final void requestStableLayoutCheck() {
        if (this.isReleased == false) goto L5;
        return;
    L5:
        if (this.isPasswordVerifyActive.invoke().booleanValue() == true) goto L7;
        return;
    L7:
        if (this.pendingScheduleRunnable == null) goto L9;
        return;
    L9:
        if (this.pendingPreDrawListener != null) goto L16;
        final int r100 = this.checkGeneration;
        Runnable r101 = new CJUnifyPayPasswordLayoutAdapter$requestStableLayoutCheck$runnable$1(this, r100);
        this.pendingScheduleRunnable = r101;
        this.paymentRoot.post(r101);
        return;
    }

    private final void resetOverlayHost() {
        ViewGroup.LayoutParams r100 = this.overlayHost.getLayoutParams();
        if ((r100 instanceof FrameLayout.LayoutParams) == false) goto L5;
        FrameLayout.LayoutParams r101 = (FrameLayout.LayoutParams) r100;
    L6:
        if (r101 == null) goto L8;
        r101.bottomMargin = 0;
        this.overlayHost.setLayoutParams(r101);
    L8:
        this.overlayHost.setAlpha(1.0f);
        this.overlayHost.setVisibility(8);
        this.overlayHost.requestLayout();
        return;
    L5:
        r101 = null;
        goto L6
    }

    private final void restoreCashierBounds() {
        CashierExpansion r100 = this.cashierExpansion;
        if (r100 != null) goto L5;
        return;
    L5:
        ViewGroup.LayoutParams r101 = this.cashierRoot.getLayoutParams();
        if ((r101 instanceof ViewGroup.MarginLayoutParams) == false) goto L8;
        ViewGroup.MarginLayoutParams r102 = (ViewGroup.MarginLayoutParams) r101;
    L9:
        if (r102 == null) goto L20;
        boolean r103 = true;
        if (r102.height != r100.getExpandedHeight()) goto L13;
        r102.height = r100.getOriginalHeight();
        boolean r104 = true;
    L15:
        if (r102.topMargin != r100.getExpandedTopMargin()) goto L17;
        r102.topMargin = r100.getOriginalTopMargin();
    L18:
        if (r103 == false) goto L20;
        CJLogger.d(TAG, "restore cashier bounds: height=" + r102.height + ", topMargin=" + r102.topMargin);
        this.cashierRoot.setLayoutParams(r102);
        goto L20
    L17:
        r103 = r104;
        goto L18
    L13:
        r104 = false;
    L20:
        this.cashierExpansion = null;
        return;
    L8:
        r102 = null;
        goto L9
    }

    private final void unbindVerifyContentLayoutListener() {
        View.OnLayoutChangeListener r100 = this.verifyContentLayoutListener;
        if (r100 == null) goto L7;
        View r101 = this.observedVerifyContent;
        if (r101 == null) goto L7;
        r101.removeOnLayoutChangeListener(r100);
    L7:
        this.observedVerifyContent = null;
        this.verifyContentLayoutListener = null;
    }

    public final void checkAfterLayoutUpdate() {
        if (this.isReleased == false) goto L7;
        CJLogger.e(TAG, "ignore layout check because adapter has been released");
        return;
    L7:
        if (this.isPasswordVerifyActive.invoke().booleanValue() == true) goto L10;
        CJLogger.d(TAG, "password verify is inactive after layout update, restore mode=" + this.layoutMode);
        restore();
        return;
    L10:
        CJLogger.d(TAG, "request password layout check after homepage update: mode=" + this.layoutMode);
        cancelOverlayExitIfNeeded();
        reapplyCashierExpansionIfNeeded();
        bindVerifyContentLayoutListener();
        requestStableLayoutCheck();
    }

    public final void onGlobalLayout() {
        if (this.isReleased == false) goto L5;
        return;
    L5:
        if (this.isPasswordVerifyActive.invoke().booleanValue() == false) goto L10;
        reapplyCashierExpansionIfNeeded();
        requestStableLayoutCheck();
        return;
    }

    public final void release() {
        CJLogger.d(TAG, "release password layout adapter: mode=" + this.layoutMode);
        cancelPendingCheck();
        unbindVerifyContentLayoutListener();
        restoreInlineLayout();
        this.isReleased = true;
        this.mountedVerifyContent = null;
        this.inlineContentLayoutParams = null;
    }

    public final void restore() {
        if (this.layoutMode == LayoutMode.INLINE) goto L5;
    L6:
        CJLogger.d(TAG, "restore password layout: mode=" + this.layoutMode + ", overlayExitAnimating=" + this.isOverlayExitAnimating);
    L7:
        cancelPendingCheck();
        unbindVerifyContentLayoutListener();
        this.missingTargetRetryCount = 0;
        if (this.layoutMode == LayoutMode.VERIFY_OVERLAY) goto L10;
    L12:
        restoreInlineLayout();
        return;
    L10:
        if (this.overlayHost.getVisibility() != 0) goto L12;
        animateOverlayExit();
        return;
    L5:
        if (this.isOverlayExitAnimating == false) goto L7;
        goto L6
    }

    private final void bindVerifyContentLayoutListener() {
        View r100 = currentVerifyContent();
        if (r100 != null) goto L6;
        return;
    L6:
        if (this.observedVerifyContent == r100) goto L8;
    L10:
        unbindVerifyContentLayoutListener();
        View.OnLayoutChangeListener r101 = new CJUnifyPayPasswordLayoutAdapter$bindVerifyContentLayoutListener$listener$1(this);
        this.observedVerifyContent = r100;
        this.verifyContentLayoutListener = r101;
        r100.addOnLayoutChangeListener(r101);
        return;
    L8:
        if (this.verifyContentLayoutListener == null) goto L10;
    }

    private final LayoutSnapshot captureLayoutSnapshot() {
        View r100 = currentVerifyContent();
        if (r100 != null) goto L5;
        return null;
    L5:
        View r101 = r100.findViewById(R.id.cj_pay_layout_pwd_input_container);
        if (r101 != null) goto L8;
        return null;
    L8:
        ViewGroup r102 = (ViewGroup) r100.findViewById(R.id.cj_pay_view_num_keyboard);
        if (r102 != null) goto L11;
        return null;
    L11:
        View r103 = r102.getChildAt(0);
        if ((r103 instanceof ViewGroup) == false) goto L14;
        ViewGroup r104 = (ViewGroup) r103;
    L15:
        if (r104 != null) goto L17;
        return null;
    L17:
        View r105 = findLastVisibleChild(r104);
        if (r105 != null) goto L21;
        return null;
    L21:
        if (this.paymentRoot.isLaidOut() == true) goto L23;
    L36:
        return null;
    L23:
        if (this.cashierRoot.isLaidOut() == false) goto L36;
        if (r100.isLaidOut() == false) goto L36;
        if (this.cashierRoot.getWidth() <= 0) goto L36;
        if (this.cashierRoot.getHeight() <= 0) goto L36;
        Rect r106 = getHostVisibleRect();
        if (r106 != null) goto L34;
        return null;
    L34:
        Rect r107 = getWindowVisibleRect();
        int r108 = dpToPx(1);
        return new LayoutSnapshot(r106, rawGlobalRect(this.paymentRoot), r107, rawGlobalRect(this.cashierRoot), rawGlobalRect(r100), getVisibility(r101, r106, r108), getVisibility(r105, r106, r108));
    L14:
        r104 = null;
        goto L15
    }

    private final boolean isLayoutStableForSampling() {
        View r100 = currentVerifyContent();
        float r101 = dpToPx(1);
        if (this.isPageAnimationFinished.invoke().booleanValue() == true) goto L5;
    L17:
        return false;
    L5:
        if (Math.abs(this.cashierRoot.getTranslationY()) > r101) goto L17;
        if (this.paymentRoot.isLayoutRequested() == true) goto L17;
        if (this.cashierRoot.isLayoutRequested() == true) goto L17;
        if (r100 != null) goto L12;
    L14:
        boolean r102 = false;
    L15:
        if (r102 == false) goto L17;
        return true;
    L12:
        if (r100.isLayoutRequested() == true) goto L14;
        r102 = true;
        goto L15
    }

    private final void restoreContentToInline() {
        cancelOverlayAnimation();
        View r100 = currentVerifyContent();
        if (r100 != null) goto L5;
    L7:
        this.overlayHost.removeAllViews();
        resetOverlayHost();
        CJLogger.d(TAG, "restore password verify content to embedded layout");
        return;
    L5:
        if (r100.getParent() == this.inlineHost) goto L7;
        CJLogger.d(TAG, "reparent password verify content from overlay to inline host");
        moveToHost(r100, this.inlineHost, this.inlineContentLayoutParams);
        goto L7
    }

    private final void restoreInlineLayout() {
        restoreContentToInline();
        restoreCashierBounds();
        this.layoutDecisionSafeRect = null;
        this.layoutMode = LayoutMode.INLINE;
    }

    public static DisplayMetrics INVOKEVIRTUAL_com_android_ttcjpaysdk_thirdparty_front_counter_unifypay_homepage_view_CJUnifyPayPasswordLayoutAdapter_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(Resources r100) {
        return WindowDisplayMetricsOverride.apply(r100, r100.getDisplayMetrics());
    }

    public static final /* synthetic */ LayoutSnapshot access$captureLayoutSnapshot(CJUnifyPayPasswordLayoutAdapter r100) {
        return r100.captureLayoutSnapshot();
    }

    public static final /* synthetic */ void access$clearCandidateSnapshot(CJUnifyPayPasswordLayoutAdapter r100) {
        r100.clearCandidateSnapshot();
    }

    public static final /* synthetic */ LayoutSnapshot access$getCandidateSnapshot$p(CJUnifyPayPasswordLayoutAdapter r100) {
        return r100.candidateSnapshot;
    }

    public static final /* synthetic */ View access$getCashierRoot$p(CJUnifyPayPasswordLayoutAdapter r100) {
        return r100.cashierRoot;
    }

    public static final /* synthetic */ int access$getCheckGeneration$p(CJUnifyPayPasswordLayoutAdapter r100) {
        return r100.checkGeneration;
    }

    public static final /* synthetic */ LayoutMode access$getLayoutMode$p(CJUnifyPayPasswordLayoutAdapter r100) {
        return r100.layoutMode;
    }

    public static final /* synthetic */ int access$getMissingTargetRetryCount$p(CJUnifyPayPasswordLayoutAdapter r100) {
        return r100.missingTargetRetryCount;
    }

    public static final /* synthetic */ ViewGroup access$getPaymentRoot$p(CJUnifyPayPasswordLayoutAdapter r100) {
        return r100.paymentRoot;
    }

    public static final /* synthetic */ boolean access$isLayoutStableForSampling(CJUnifyPayPasswordLayoutAdapter r100) {
        return r100.isLayoutStableForSampling();
    }

    public static final /* synthetic */ boolean access$isOverlayExitAnimating$p(CJUnifyPayPasswordLayoutAdapter r100) {
        return r100.isOverlayExitAnimating;
    }

    public static final /* synthetic */ Function0 access$isPasswordVerifyActive$p(CJUnifyPayPasswordLayoutAdapter r100) {
        return r100.isPasswordVerifyActive;
    }

    public static final /* synthetic */ boolean access$isReleased$p(CJUnifyPayPasswordLayoutAdapter r100) {
        return r100.isReleased;
    }

    public static final /* synthetic */ void access$requestStableLayoutCheck(CJUnifyPayPasswordLayoutAdapter r100) {
        r100.requestStableLayoutCheck();
    }

    public static final /* synthetic */ void access$restoreInlineLayout(CJUnifyPayPasswordLayoutAdapter r100) {
        r100.restoreInlineLayout();
    }

    private final boolean canExpandCashier(LayoutSnapshot r100) {
        int r101 = requiredExtraHeight(r100);
        int r102 = r100.getCashierRect().top - r100.getSafeRect().top;
        boolean r103 = false;
        int r104 = RangesKt.coerceAtLeast(r102, 0);
        if (r101 <= 0) goto L6;
        if (r101 > r104) goto L6;
        r103 = true;
    L6:
        CJLogger.d(TAG, "check cashier expansion: requiredExtraHeight=" + r101 + ", expandableHeight=" + r104 + ", canExpand=" + r103);
        return r103;
    }

    private final int dpToPx(int r100) {
        return (int) ((r100 * INVOKEVIRTUAL_com_android_ttcjpaysdk_thirdparty_front_counter_unifypay_homepage_view_CJUnifyPayPasswordLayoutAdapter_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(this.paymentRoot.getResources()).density) + 0.5f);
    }

    private final boolean expandCashier(LayoutSnapshot r100) {
        ViewGroup.LayoutParams r101 = this.cashierRoot.getLayoutParams();
        if ((r101 instanceof ViewGroup.MarginLayoutParams) == false) goto L5;
        ViewGroup.MarginLayoutParams r102 = (ViewGroup.MarginLayoutParams) r101;
    L7:
        if (r102 != null) goto L10;
        CJLogger.b(TAG, "cashier layout params do not support margins");
        return false;
    L10:
        CashierExpansion r103 = this.cashierExpansion;
        int r104 = requiredExtraHeight(r100);
        if (r103 == null) goto L13;
        int r105 = r103.getOriginalHeight();
    L14:
        if (r103 == null) goto L16;
        int r106 = r103.getOriginalTopMargin();
    L17:
        CashierExpansion r107 = new CashierExpansion(r105, r106, this.cashierRoot.getHeight() + r104, RangesKt.coerceAtLeast(r102.topMargin - r104, 0));
        this.cashierExpansion = r107;
        r102.height = r107.getExpandedHeight();
        r102.topMargin = r107.getExpandedTopMargin();
        this.cashierRoot.setLayoutParams(r102);
        CJLogger.d(TAG, "expand cashier for password content: targetHeight=" + r102.height + ", targetTopMargin=" + r102.topMargin);
        return true;
    L16:
        r106 = r102.topMargin;
        goto L17
    L13:
        r105 = r102.height;
        goto L14
    L5:
        r102 = null;
        goto L7
    }

    private final View findLastVisibleChild(ViewGroup r100) {
        int r101 = r100.getChildCount() - 1;
    L3:
        View r102 = null;
        if ((-1) >= r101) goto L14;
        View r103 = r100.getChildAt(r101);
        if (r103.getVisibility() != 0) goto L8;
        boolean r104 = true;
    L9:
        if (r104 == false) goto L11;
        r102 = r103;
    L11:
        if (r102 != null) goto L12;
        r101 = r101 - 1;
        goto L3
    L12:
        return r102;
    L8:
        r104 = false;
        goto L9
    L14:
        return null;
    }

    private final boolean handleLayoutSnapshot(LayoutSnapshot r100) {
        int r101 = dpToPx(1);
        if (this.layoutMode == LayoutMode.INLINE) goto L14;
        Rect r102 = this.layoutDecisionSafeRect;
        if (r102 != null) goto L7;
    L9:
        boolean r103 = false;
    L10:
        if (r103 == true) goto L14;
        CJLogger.d(TAG, "safe bounds changed, recalculate password layout from inline: old=" + this.layoutDecisionSafeRect + ", new=" + r100.getSafeRect());
        restoreInlineLayout();
        return true;
    L7:
        if (CJUnifyPayPasswordLayoutAdapterKt.access$isNear(r102, r100.getSafeRect(), r101) != true) goto L9;
        r103 = true;
    L14:
        if (r100.isFullyVisible() == false) goto L16;
        return false;
    L16:
        int r104 = WhenMappings.$EnumSwitchMapping$0[this.layoutMode.ordinal()];
        if (r104 == 1) goto L27;
        if (r104 != 2) goto L21;
        CJLogger.e(TAG, "password content remains clipped after cashier expansion, bottomDeficit=" + r100.getBottomDeficit());
        restoreCashierBounds();
        return moveContentToOverlay(r100.getSafeRect());
    L21:
        if (r104 != 3) goto L24;
        CJLogger.b(TAG, "password content remains clipped in overlay, safeBounds=" + r100.getSafeRect() + ", verifyBounds=" + r100.getVerifyRect());
        return false;
    L24:
        throw new NoWhenBranchMatchedException();
    L27:
        if (canExpandCashier(r100) == true) goto L29;
    L31:
        CJLogger.e(TAG, "cashier cannot cover password deficit, switch to overlay: bottomDeficit=" + r100.getBottomDeficit());
        return moveContentToOverlay(r100.getSafeRect());
    L29:
        if (expandCashier(r100) == false) goto L31;
        CJLogger.d(TAG, "switch password layout mode: INLINE -> CASHIER_EXPANDED");
        this.layoutDecisionSafeRect = new Rect(r100.getSafeRect());
        this.layoutMode = LayoutMode.CASHIER_EXPANDED;
        return true;
    }

    private final boolean moveContentToOverlay(Rect r110) {
        LayoutMode r100 = this.layoutMode;
        LayoutMode r101 = LayoutMode.VERIFY_OVERLAY;
        int r102 = 0;
        if (r100 != r101) goto L6;
        CJLogger.d(TAG, "skip moving password content because overlay mode is already active");
        return false;
    L6:
        View r103 = currentVerifyContent();
        if (r103 != null) goto L11;
        CJLogger.b(TAG, "password verify content is unavailable");
        return false;
    L11:
        if (r103.getParent() != this.inlineHost) goto L13;
        this.inlineContentLayoutParams = r103.getLayoutParams();
    L13:
        final View r104 = r103.findFocus();
        moveToHost(r103, this.overlayHost, new FrameLayout.LayoutParams(-1, -2, 80));
        Rect r105 = rawGlobalRect(this.paymentRoot);
        ViewGroup.LayoutParams r106 = this.overlayHost.getLayoutParams();
        FrameLayout.LayoutParams r107 = null;
        if ((r106 instanceof FrameLayout.LayoutParams) == false) goto L16;
        FrameLayout.LayoutParams r108 = (FrameLayout.LayoutParams) r106;
    L17:
        if (r108 == null) goto L19;
        r108.bottomMargin = RangesKt.coerceAtLeast(r105.bottom - r110.bottom, 0);
        this.overlayHost.setLayoutParams(r108);
    L19:
        restoreCashierBounds();
        this.overlayHost.setAlpha(0.0f);
        this.overlayHost.setVisibility(0);
        this.overlayHost.bringToFront();
        this.overlayHost.animate().alpha(1.0f).setDuration(100).setListener(null).start();
        this.layoutDecisionSafeRect = new Rect(r110);
        this.layoutMode = r101;
        if (r104 == null) goto L22;
        this.overlayHost.post(new CJUnifyPayPasswordLayoutAdapter$moveContentToOverlay$2$1(r104));
    L22:
        StringBuilder r109 = new StringBuilder("switch password layout mode to VERIFY_OVERLAY: verifyHeight=");
        r109.append(r103.getHeight());
        r109.append(", safeHeight=");
        r109.append(r110.height());
        r109.append(", bottomMargin=");
        ViewGroup.LayoutParams r111 = this.overlayHost.getLayoutParams();
        if ((r111 instanceof FrameLayout.LayoutParams) == false) goto L25;
        r107 = (FrameLayout.LayoutParams) r111;
    L25:
        if (r107 == null) goto L27;
        r102 = r107.bottomMargin;
    L27:
        r109.append(r102);
        CJLogger.d(TAG, r109.toString());
        return true;
    L16:
        r108 = null;
        goto L17
    }

    private final Rect offsetToScreenCoordinates(Rect r100) {
        int[] r101 = new int[2];
        this.paymentRoot.getRootView().getLocationOnScreen(r101);
        r100.offset(r101[0], r101[1]);
        return r100;
    }

    private final Rect rawGlobalRect(View r100) {
        int[] r101 = new int[2];
        r100.getLocationOnScreen(r101);
        int r102 = r101[0];
        return new Rect(r102, r101[1], r100.getWidth() + r102, r101[1] + r100.getHeight());
    }

    private final void removeFromParent(View r100) {
        ViewParent r101 = r100.getParent();
        if ((r101 instanceof ViewGroup) == false) goto L5;
        ViewGroup r102 = (ViewGroup) r101;
    L6:
        if (r102 == null) goto L9;
        r102.removeView(r100);
        return;
    L9:
        return;
    L5:
        r102 = null;
        goto L6
    }

    private final void removePreDrawListener(ViewTreeObserver.OnPreDrawListener r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        ViewTreeObserver r101 = this.pendingPreDrawObserver;
        boolean r102 = false;
        if (r101 != null) goto L7;
    L9:
        if (r102 == false) goto L12;
        r101.removeOnPreDrawListener(r100);
    L12:
        if (this.pendingPreDrawListener != r100) goto L15;
        this.pendingPreDrawListener = null;
        this.pendingPreDrawObserver = null;
        return;
    L15:
        return;
    L7:
        if (r101.isAlive() != true) goto L9;
        r102 = true;
        goto L9
    }

    private final int requiredExtraHeight(LayoutSnapshot r100) {
        return r100.getBottomDeficit() + dpToPx(1);
    }

    private final void scheduleStablePreDrawCheck(final int r100) {
        if (this.pendingPreDrawListener == null) goto L6;
        return;
    L6:
        if (this.paymentRoot.isAttachedToWindow() == true) goto L9;
        CJLogger.e(TAG, "skip stable layout check because payment root is detached");
        return;
    L9:
        ViewTreeObserver r101 = this.paymentRoot.getViewTreeObserver();
        if (r101.isAlive() == true) goto L13;
        CJLogger.e(TAG, "skip password layout check because viewTreeObserver is not alive");
        return;
    L13:
        ViewTreeObserver.OnPreDrawListener r102 = new CJUnifyPayPasswordLayoutAdapter$scheduleStablePreDrawCheck$listener$1(r100, this);
        this.pendingPreDrawListener = r102;
        this.pendingPreDrawObserver = r101;
        r101.addOnPreDrawListener(r102);
        this.paymentRoot.postInvalidateOnAnimation();
    }

    public final void mountPreVerifyView(View r100) {
        Intrinsics.checkNotNullParameter(r100, "view");
        if (this.isReleased == false) goto L6;
        CJLogger.e(TAG, "ignore mount because adapter has been released");
        return;
    L6:
        CJLogger.d(TAG, "mount pre-verify content: previousMode=" + this.layoutMode + ", content=" + r100.getClass().getSimpleName());
        cancelPendingCheck();
        unbindVerifyContentLayoutListener();
        cancelOverlayAnimation();
        restoreCashierBounds();
        View r101 = this.mountedVerifyContent;
        if (r101 == null) goto L9;
        removeFromParent(r101);
    L9:
        this.overlayHost.removeAllViews();
        resetOverlayHost();
        moveToHost$default(this, r100, this.inlineHost, null, 4, null);
        this.mountedVerifyContent = r100;
        this.inlineContentLayoutParams = r100.getLayoutParams();
        this.layoutDecisionSafeRect = null;
        this.layoutMode = LayoutMode.INLINE;
        this.missingTargetRetryCount = 0;
        bindVerifyContentLayoutListener();
        requestStableLayoutCheck();
    }

    public static final /* synthetic */ int access$dpToPx(CJUnifyPayPasswordLayoutAdapter r100, int r101) {
        return r100.dpToPx(r101);
    }

    public static final /* synthetic */ boolean access$handleLayoutSnapshot(CJUnifyPayPasswordLayoutAdapter r100, LayoutSnapshot r101) {
        return r100.handleLayoutSnapshot(r101);
    }

    public static final /* synthetic */ void access$removePreDrawListener(CJUnifyPayPasswordLayoutAdapter r100, ViewTreeObserver.OnPreDrawListener r101) {
        r100.removePreDrawListener(r101);
    }

    public static final /* synthetic */ void access$scheduleStablePreDrawCheck(CJUnifyPayPasswordLayoutAdapter r100, int r101) {
        r100.scheduleStablePreDrawCheck(r101);
    }

    public static final /* synthetic */ void access$setCandidateSnapshot$p(CJUnifyPayPasswordLayoutAdapter r100, LayoutSnapshot r101) {
        r100.candidateSnapshot = r101;
    }

    public static final /* synthetic */ void access$setMissingTargetRetryCount$p(CJUnifyPayPasswordLayoutAdapter r100, int r101) {
        r100.missingTargetRetryCount = r101;
    }

    public static final /* synthetic */ void access$setOverlayExitAnimating$p(CJUnifyPayPasswordLayoutAdapter r100, boolean r101) {
        r100.isOverlayExitAnimating = r101;
    }

    public static final /* synthetic */ void access$setPendingScheduleRunnable$p(CJUnifyPayPasswordLayoutAdapter r100, Runnable r101) {
        r100.pendingScheduleRunnable = r101;
    }

    private final ViewVisibility getVisibility(View r100, Rect r110, int r111) {
        Rect r101 = rawGlobalRect(r100);
        Rect r102 = new Rect();
        boolean r103 = r100.getGlobalVisibleRect(r102);
        boolean r104 = true;
        if ((r102.width() + r111) < r100.getWidth()) goto L5;
        boolean r105 = true;
    L7:
        if ((r102.height() + r111) < r100.getHeight()) goto L9;
        boolean r106 = true;
    L11:
        if (r101.left >= (r110.left - r111)) goto L13;
    L19:
        boolean r112 = false;
    L21:
        if (r103 == true) goto L23;
    L32:
        r104 = false;
    L34:
        return new ViewVisibility(r101, r104);
    L23:
        if (r100.isShown() == false) goto L32;
        if (r100.getWidth() <= 0) goto L32;
        if (r100.getHeight() <= 0) goto L32;
        if (r105 == false) goto L32;
        if (r106 == false) goto L32;
        if (r112 == false) goto L32;
    L13:
        if (r101.top < (r110.top - r111)) goto L19;
        if (r101.right > (r110.right + r111)) goto L19;
        if (r101.bottom > (r110.bottom + r111)) goto L19;
        r112 = true;
        goto L21
    L9:
        r106 = false;
        goto L11
    L5:
        r105 = false;
        goto L7
    }

    private final void moveToHost(View r100, ViewGroup r101, ViewGroup.LayoutParams r102) {
        removeFromParent(r100);
        r101.removeAllViews();
        if (r102 == null) goto L5;
        r101.addView(r100, r102);
        return;
    L5:
        r101.addView(r100);
    }

    public static /* synthetic */ void removePreDrawListener$default(CJUnifyPayPasswordLayoutAdapter r100, ViewTreeObserver.OnPreDrawListener r101, int r102, Object r103) {
        if ((r102 & 1) == 0) goto L5;
        r101 = r100.pendingPreDrawListener;
    L5:
        r100.removePreDrawListener(r101);
    }

    public CJUnifyPayPasswordLayoutAdapter(ViewGroup r100, View r101, ViewGroup r102, FrameLayout r103, Function0<Boolean> r104, Function0<Boolean> r105) {
        Intrinsics.checkNotNullParameter(r100, "paymentRoot");
        Intrinsics.checkNotNullParameter(r101, "cashierRoot");
        Intrinsics.checkNotNullParameter(r102, "inlineHost");
        Intrinsics.checkNotNullParameter(r103, "overlayHost");
        Intrinsics.checkNotNullParameter(r104, "isPasswordVerifyActive");
        Intrinsics.checkNotNullParameter(r105, "isPageAnimationFinished");
        this.paymentRoot = r100;
        this.cashierRoot = r101;
        this.inlineHost = r102;
        this.overlayHost = r103;
        this.isPasswordVerifyActive = r104;
        this.isPageAnimationFinished = r105;
        this.layoutMode = LayoutMode.INLINE;
    }

    public static /* synthetic */ void moveToHost$default(CJUnifyPayPasswordLayoutAdapter r100, View r101, ViewGroup r102, ViewGroup.LayoutParams r103, int r104, Object r105) {
        if ((r104 & 4) == 0) goto L5;
        r103 = null;
    L5:
        r100.moveToHost(r101, r102, r103);
    }
}
