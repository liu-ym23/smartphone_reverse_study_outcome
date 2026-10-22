package com.obric.oui.popover.v2;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.ColorInt;
import androidx.annotation.StyleRes;
import androidx.annotation.UiThread;
import androidx.core.view.ViewGroupKt;
import bg.h;
import com.bytedance.apm.constant.PerfConsts;
import com.google.common.primitives.Ints;
import com.obric.oui.common.style.OUILayoutHelper;
import com.obric.oui.common.style.Shadow;
import com.obric.oui.popover.menu.OPopoverMenuView;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.y;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0007\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b/\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b'\bf\u0018\u0000 °\u0001*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u0001:\u0006±\u0001²\u0001³\u0001J\u000f\u0010\u0004\u001a\u00020\u0003H&¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H&¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0006H&¢\u0006\u0004\b\t\u0010\bJ\u000f\u0010\n\u001a\u00020\u0006H&¢\u0006\u0004\b\n\u0010\bJ\u0019\u0010\r\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016¢\u0006\u0004\b\r\u0010\u000eJ!\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u000f\u001a\u00020\u000b2\b\b\u0002\u0010\u0011\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J'\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\u0016\u001a\u00020\u00102\u0006\u0010\u0017\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J/\u0010\u001c\u001a\u00020\u00062\u0006\u0010\u001a\u001a\u00020\u00102\u0006\u0010\u001b\u001a\u00020\u000b2\u0006\u0010\u0016\u001a\u00020\u00102\u0006\u0010\u0017\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u001c\u0010\u001dJ'\u0010\"\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u001e2\u0006\u0010 \u001a\u00020\u00102\u0006\u0010!\u001a\u00020\u001eH\u0016¢\u0006\u0004\b\"\u0010#J\u000f\u0010$\u001a\u00020\u0010H\u0016¢\u0006\u0004\b$\u0010%J\u0017\u0010'\u001a\u00020\u00062\u0006\u0010&\u001a\u00020\u0010H\u0016¢\u0006\u0004\b'\u0010(J\u0017\u0010*\u001a\u00020\u00062\u0006\u0010)\u001a\u00020\u0010H\u0016¢\u0006\u0004\b*\u0010(J\u0017\u0010,\u001a\u00020\u00062\u0006\u0010+\u001a\u00020\u0010H\u0016¢\u0006\u0004\b,\u0010(J\u000f\u0010-\u001a\u00020\u000bH\u0016¢\u0006\u0004\b-\u0010.J\u001f\u0010/\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u00102\u0006\u0010\u0017\u001a\u00020\u0010H\u0016¢\u0006\u0004\b/\u00100J\u000f\u00101\u001a\u00020\u0006H\u0016¢\u0006\u0004\b1\u0010\bJ+\u00105\u001a\u00020\u00062\b\b\u0002\u0010\f\u001a\u0002022\u0010\b\u0002\u00104\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u000103H\u0016¢\u0006\u0004\b5\u00106J[\u0010>\u001a\u00020=2\u0006\u00107\u001a\u00020\u00032\b\b\u0002\u0010&\u001a\u00020\u00102\b\b\u0002\u00108\u001a\u00020\u00032\n\b\u0002\u0010:\u001a\u0004\u0018\u0001092\u0010\b\u0002\u0010;\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u0001032\u0010\b\u0002\u0010<\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u000103H\u0016¢\u0006\u0004\b>\u0010?J\u0019\u0010@\u001a\u00020\u00062\b\b\u0002\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b@\u0010AJ\u0019\u0010D\u001a\u00020C2\b\b\u0001\u0010B\u001a\u00020\u0010H\u0016¢\u0006\u0004\bD\u0010EJ\u0019\u0010F\u001a\u00020\u001e2\b\b\u0001\u0010B\u001a\u00020\u0010H\u0016¢\u0006\u0004\bF\u0010GJ!\u0010H\u001a\u00020\u00062\u0006\u0010\u001a\u001a\u00020\u00102\b\b\u0002\u0010\u001b\u001a\u00020\u000bH\u0016¢\u0006\u0004\bH\u0010IJ\u000f\u0010J\u001a\u00020\u0003H\u0016¢\u0006\u0004\bJ\u0010\u0005J\u000f\u0010K\u001a\u00020\u0006H\u0016¢\u0006\u0004\bK\u0010\bJ\u000f\u0010L\u001a\u00020\u0010H\u0016¢\u0006\u0004\bL\u0010%J\u000f\u0010M\u001a\u00020\u0006H\u0016¢\u0006\u0004\bM\u0010\bJ\u000f\u0010N\u001a\u00020\u0006H\u0017¢\u0006\u0004\bN\u0010\bJ\u000f\u0010O\u001a\u00020\u0006H\u0017¢\u0006\u0004\bO\u0010\bJ\u000f\u0010P\u001a\u00020\u0006H\u0016¢\u0006\u0004\bP\u0010\bJ\u000f\u0010Q\u001a\u00020\u0006H\u0016¢\u0006\u0004\bQ\u0010\bJ\u000f\u0010R\u001a\u00020\u0006H\u0016¢\u0006\u0004\bR\u0010\bR\u0014\u0010V\u001a\u00020S8&X¦\u0004¢\u0006\u0006\u001a\u0004\bT\u0010UR\u0014\u0010X\u001a\u00020\u00108&X¦\u0004¢\u0006\u0006\u001a\u0004\bW\u0010%R\u0014\u0010Z\u001a\u00020\u00038&X¦\u0004¢\u0006\u0006\u001a\u0004\bY\u0010\u0005R\u0014\u0010^\u001a\u00020[8&X¦\u0004¢\u0006\u0006\u001a\u0004\b\\\u0010]R\u0014\u0010`\u001a\u00020\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b_\u0010\u0005R\u0016\u0010c\u001a\u0004\u0018\u0001098VX\u0096\u0004¢\u0006\u0006\u001a\u0004\ba\u0010bR\u0016\u0010e\u001a\u0004\u0018\u0001098VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bd\u0010bR\u001c\u0010h\u001a\u00020\u00108&@&X¦\u000e¢\u0006\f\u001a\u0004\bf\u0010%\"\u0004\bg\u0010(R\u001c\u0010k\u001a\u00020\u00108&@&X¦\u000e¢\u0006\f\u001a\u0004\bi\u0010%\"\u0004\bj\u0010(R\u001c\u0010n\u001a\u00020\u00108&@&X¦\u000e¢\u0006\f\u001a\u0004\bl\u0010%\"\u0004\bm\u0010(R\u001c\u0010s\u001a\u00020\u001e8&@&X¦\u000e¢\u0006\f\u001a\u0004\bo\u0010p\"\u0004\bq\u0010rR\u001c\u0010v\u001a\u00020\u001e8&@&X¦\u000e¢\u0006\f\u001a\u0004\bt\u0010p\"\u0004\bu\u0010rR\u001c\u0010y\u001a\u00020\u00108&@&X¦\u000e¢\u0006\f\u001a\u0004\bw\u0010%\"\u0004\bx\u0010(R\u001c\u0010|\u001a\u00020\u00108&@&X¦\u000e¢\u0006\f\u001a\u0004\bz\u0010%\"\u0004\b{\u0010(R\u0014\u0010~\u001a\u00020\u00108&X¦\u0004¢\u0006\u0006\u001a\u0004\b}\u0010%R\u0015\u0010\u0080\u0001\u001a\u00020\u00108&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u007f\u0010%R\u0016\u0010\u0082\u0001\u001a\u00020\u00108&X¦\u0004¢\u0006\u0007\u001a\u0005\b\u0081\u0001\u0010%R\u0016\u0010\u0084\u0001\u001a\u00020\u00038&X¦\u0004¢\u0006\u0007\u001a\u0005\b\u0083\u0001\u0010\u0005R\u0016\u0010\u0086\u0001\u001a\u00020\u00108&X¦\u0004¢\u0006\u0007\u001a\u0005\b\u0085\u0001\u0010%R\u0016\u0010\u0088\u0001\u001a\u00020\u00108&X¦\u0004¢\u0006\u0007\u001a\u0005\b\u0087\u0001\u0010%R\u0016\u0010\u008a\u0001\u001a\u00020\u00038&X¦\u0004¢\u0006\u0007\u001a\u0005\b\u0089\u0001\u0010\u0005R,\u0010\u0090\u0001\u001a\u0017\u0012\u0004\u0012\u00020\u0003\u0012\f\u0012\n\u0012\u0005\u0012\u00030\u008d\u00010\u008c\u00010\u008b\u00018&X¦\u0004¢\u0006\b\u001a\u0006\b\u008e\u0001\u0010\u008f\u0001R\u0016\u0010\u0092\u0001\u001a\u00020\u00038&X¦\u0004¢\u0006\u0007\u001a\u0005\b\u0091\u0001\u0010\u0005R\u0016\u0010\u0094\u0001\u001a\u00020\u00108gX¦\u0004¢\u0006\u0007\u001a\u0005\b\u0093\u0001\u0010%R\u0016\u0010\u0096\u0001\u001a\u00020\u001e8&X¦\u0004¢\u0006\u0007\u001a\u0005\b\u0095\u0001\u0010pR\u0016\u0010\u0098\u0001\u001a\u00020\u001e8&X¦\u0004¢\u0006\u0007\u001a\u0005\b\u0097\u0001\u0010pR!\u0010\u009d\u0001\u001a\u00020\u00128&@&X¦\u000e¢\u0006\u0010\u001a\u0006\b\u0099\u0001\u0010\u009a\u0001\"\u0006\b\u009b\u0001\u0010\u009c\u0001R!\u0010¢\u0001\u001a\u0002028&@&X¦\u000e¢\u0006\u0010\u001a\u0006\b\u009e\u0001\u0010\u009f\u0001\"\u0006\b \u0001\u0010¡\u0001R#\u0010§\u0001\u001a\u0004\u0018\u00010=8&@&X¦\u000e¢\u0006\u0010\u001a\u0006\b£\u0001\u0010¤\u0001\"\u0006\b¥\u0001\u0010¦\u0001R \u0010«\u0001\u001a\u00020\u00038&@&X¦\u000e¢\u0006\u000f\u001a\u0005\b¨\u0001\u0010\u0005\"\u0006\b©\u0001\u0010ª\u0001R \u0010®\u0001\u001a\u00020\u00038&@&X¦\u000e¢\u0006\u000f\u001a\u0005\b¬\u0001\u0010\u0005\"\u0006\b\u00ad\u0001\u0010ª\u0001R\u0016\u0010¯\u0001\u001a\u00020\u00038&X¦\u0004¢\u0006\u0007\u001a\u0005\b¯\u0001\u0010\u0005¨\u0006´\u0001"}, d2 = {"Lcom/obric/oui/popover/v2/OPopoverBase;", "", "T", "", "isPopoverShowing", "()Z", "", "onPopoverShownInternal", "()V", "onPopoverStartDismissInternal", "finishPopoverDismissInternal", "Landroid/view/View;", "view", "requirePopoverContentView", "(Landroid/view/View;)Landroid/view/View;", "contentView", "", "materialSourceType", "Lcom/obric/oui/popover/v2/OPopoverLayout;", "createPopoverBubbleLayout", "(Landroid/view/View;I)Lcom/obric/oui/popover/v2/OPopoverLayout;", "target", "widthMeasureSpec", "heightMeasureSpec", "measurePopoverContent", "(Landroid/view/View;II)V", "maxHeight", "measureTarget", "setPopoverMaxContentHeight", "(ILandroid/view/View;II)V", "", "anchorCenter", "popupOrigin", "fallback", "resolvePopoverPivot", "(FIF)F", "getDisplayRotationDegreesInternal", "()I", "gravity", "setGravityInternal", "(I)V", "xOffset", "setXOffsetInternal", "yOffset", "setYOffsetInternal", "getContentViewInternal", "()Landroid/view/View;", "measurePopupInternal", "(II)V", "updatePopoverPivotInternal", "Landroid/view/ViewGroup;", "Lkotlin/Function0;", "onShown", "showPopoverDirectlyInternal", "(Landroid/view/ViewGroup;Lkotlin/jvm/functions/Function0;)V", "isIn", "isWindowMode", "Landroid/animation/Animator;", "customAnimator", "onAnimationStart", "onAnimationEnd", "Landroid/animation/AnimatorSet;", "startPopoverVisibilityAnimationInternal", "(ZIZLandroid/animation/Animator;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)Landroid/animation/AnimatorSet;", "resetPopoverAnimatedViewState", "(Landroid/view/View;)V", "shadowStyleRes", "Lcom/obric/oui/popover/v2/OPopoverBase$b;", "resolvePopoverShadowPadding", "(I)Lcom/obric/oui/popover/v2/OPopoverBase$b;", "resolvePopoverShadowSpace", "(I)F", "setMaxContentHeightInternal", "(ILandroid/view/View;)V", "shouldAnimatePopoverVisibilityInternal", "cancelPopoverAnimatorInternal", "resolvePopoverAnimationGravityInternal", "showPopoverWithoutAnimationInternal", "playPopoverEnterAnimationInternal", "playPopoverExitAnimationInternal", "beforeShowInStackIfNeeded", "afterShowInStackIfNeeded", "onDestroyInStackIfNeeded", "Landroid/content/Context;", "getPopoverContext", "()Landroid/content/Context;", "popoverContext", "getPopoverDisplayOrientation", "popoverDisplayOrientation", "getPopoverShowWithAnimation", "popoverShowWithAnimation", "", "getPopoverAnimationDurationMillis", "()J", "popoverAnimationDurationMillis", "getPopoverAnimationIsWindowMode", "popoverAnimationIsWindowMode", "getPopoverEnterAnimator", "()Landroid/animation/Animator;", "popoverEnterAnimator", "getPopoverExitAnimator", "popoverExitAnimator", "getPopoverGravity", "setPopoverGravity", "popoverGravity", "getPopoverXOffset", "setPopoverXOffset", "popoverXOffset", "getPopoverYOffset", "setPopoverYOffset", "popoverYOffset", "getPopoverAnchorCenterX", "()F", "setPopoverAnchorCenterX", "(F)V", "popoverAnchorCenterX", "getPopoverAnchorCenterY", "setPopoverAnchorCenterY", "popoverAnchorCenterY", "getPopoverPopupOriginX", "setPopoverPopupOriginX", "popoverPopupOriginX", "getPopoverPopupOriginY", "setPopoverPopupOriginY", "popoverPopupOriginY", "getPopoverBgColor", "popoverBgColor", "getPopoverBorderWidth", "popoverBorderWidth", "getPopoverBorderColor", "popoverBorderColor", "getPopoverTransparentBg", "popoverTransparentBg", "getPopoverWidth", "popoverWidth", "getPopoverHeight", "popoverHeight", "getPopoverEnableBubbleMaterial", "popoverEnableBubbleMaterial", "Lkotlin/Function1;", "", "Lcom/obric/oui/material/b;", "getPopoverMaterials", "()Lkotlin/jvm/functions/Function1;", "popoverMaterials", "getPopoverCoverPreviousWhenStacked", "popoverCoverPreviousWhenStacked", "getPopoverStackCoverColor", "popoverStackCoverColor", "getPopoverStackAlphaPrevious", "popoverStackAlphaPrevious", "getPopoverStackScalePrevious", "popoverStackScalePrevious", "getPopoverBubbleLayout", "()Lcom/obric/oui/popover/v2/OPopoverLayout;", "setPopoverBubbleLayout", "(Lcom/obric/oui/popover/v2/OPopoverLayout;)V", "popoverBubbleLayout", "getPopoverWindowFrame", "()Landroid/view/ViewGroup;", "setPopoverWindowFrame", "(Landroid/view/ViewGroup;)V", "popoverWindowFrame", "getPopoverAnimator", "()Landroid/animation/AnimatorSet;", "setPopoverAnimator", "(Landroid/animation/AnimatorSet;)V", "popoverAnimator", "getPopoverPushedToStack", "setPopoverPushedToStack", "(Z)V", "popoverPushedToStack", "getPopoverRemovedFromStack", "setPopoverRemovedFromStack", "popoverRemovedFromStack", "isPopoverBubbleLayoutInitialized", "Companion", "a", "b", "StackController", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface OPopoverBase<T> {

    @NotNull
    public static final a Companion = null;

    public static final class DefaultImpls {
        public static void A(OPopoverBase r10, int r11) {
            q.g(r10, "this");
            r10.setPopoverYOffset(r11);
        }

        public static boolean B(OPopoverBase r10) {
            q.g(r10, "this");
            if (r10.getPopoverShowWithAnimation() == true) goto L5;
        L7:
            return false;
        L5:
            if (r10.getPopoverAnimationDurationMillis() <= 0) goto L7;
            return true;
        }

        public static void C(OPopoverBase r10, ViewGroup r11, Function0 r12) {
            q.g(r10, "this");
            q.g(r11, "view");
            r10.resetPopoverAnimatedViewState(r11);
            r11.setVisibility(0);
            if (r12 == null) goto L7;
            r12.invoke();
            return;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void D(OPopoverBase r10, ViewGroup r11, Function0 r12, int r13, Object r14) {
            if (r14 != null) goto L12;
            if ((r13 & 1) == 0) goto L7;
            r11 = r10.getPopoverWindowFrame();
        L7:
            if ((r13 & 2) == 0) goto L9;
            r12 = null;
        L9:
            r10.showPopoverDirectlyInternal(r11, r12);
            return;
        L12:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: showPopoverDirectlyInternal");
        }

        public static void E(final OPopoverBase r10) {
            q.g(r10, "this");
            D(r10, null, new C04481(r10), 1, null);
        }

        public static AnimatorSet F(OPopoverBase r11, boolean r12, int r13, boolean r14, Animator r15, Function0 r16, Function0 r17) {
            q.g(r11, "this");
            r11.updatePopoverPivotInternal();
            return e.f16319a.f(r11.getPopoverWindowFrame(), r14, r13, r11.getPopoverWindowFrame().getPivotX(), r11.getPopoverWindowFrame().getPivotY(), r12, r15, r16, r17);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ AnimatorSet G(OPopoverBase r10, boolean r11, int r12, boolean r13, Animator r14, Function0 r15, Function0 r16, int r17, Object r18) {
            if (r18 != null) goto L24;
            if ((r17 & 2) == 0) goto L6;
            r12 = r10.getPopoverGravity();
        L6:
            int r19 = r12;
            if ((r17 & 4) == 0) goto L9;
            r13 = true;
        L9:
            boolean r20 = r13;
            if ((r17 & 8) == 0) goto L12;
            Animator r21 = null;
        L14:
            if ((r17 & 16) == 0) goto L16;
            Function0 r22 = null;
        L18:
            if ((r17 & 32) == 0) goto L20;
            Function0 r23 = null;
        L22:
            return r10.startPopoverVisibilityAnimationInternal(r11, r19, r20, r21, r22, r23);
        L20:
            r23 = r16;
            goto L22
        L16:
            r22 = r15;
            goto L18
        L12:
            r21 = r14;
            goto L14
        L24:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: startPopoverVisibilityAnimationInternal");
        }

        public static void H(OPopoverBase r10) {
            q.g(r10, "this");
            r10.measurePopoverContent(r10.getContentViewInternal(), 0, 0);
            r10.getPopoverWindowFrame().setPivotX(r10.resolvePopoverPivot(r10.getPopoverAnchorCenterX(), r10.getPopoverPopupOriginX(), r10.getPopoverWindowFrame().getMeasuredWidth() / 2.0f));
            r10.getPopoverWindowFrame().setPivotY(r10.resolvePopoverPivot(r10.getPopoverAnchorCenterY(), r10.getPopoverPopupOriginY(), r10.getPopoverWindowFrame().getMeasuredHeight() / 2.0f));
        }

        public static void a(OPopoverBase r10) {
            q.g(r10, "this");
            if (r10.getPopoverPushedToStack() == false) goto L5;
            return;
        L5:
            r10.setPopoverPushedToStack(true);
            StackController.f16240a.e(r10);
        }

        public static void b(OPopoverBase r10) {
            q.g(r10, "this");
            StackController.f16240a.a(r10, r10.getPopoverCoverPreviousWhenStacked(), r10.getPopoverStackCoverColor(), r10.getPopoverStackAlphaPrevious(), r10.getPopoverStackScalePrevious());
        }

        public static void c(OPopoverBase r10) {
            q.g(r10, "this");
            AnimatorSet r11 = r10.getPopoverAnimator();
            if (r11 == null) goto L6;
            r11.cancel();
        L6:
            r10.setPopoverAnimator(null);
        }

        public static OPopoverLayout d(OPopoverBase r10, View r11, int r12) {
            q.g(r10, "this");
            q.g(r11, "contentView");
            OPopoverLayout r13 = new OPopoverLayout(r10.getPopoverContext(), r10.getPopoverEnableBubbleMaterial(), r10.getPopoverMaterials(), r12);
            r13.setBackgroundColor(0);
            r13.setGravity(17);
            r13.addView(a.b(OPopoverBase.Companion, r10.getPopoverContext(), r10.getPopoverDisplayOrientation(), r11));
            r13.setCornerRadius(tc.f.d(r10.getPopoverContext(), OPopoverLayout.f16249v.a()));
            if (r10.getPopoverBgColor() == 0) goto L6;
            r13.setBgColor(r10.getPopoverBgColor());
        L6:
            if (r13.g() == true) goto L8;
            r13.setBorderColor(r10.getPopoverBorderColor());
            r13.setBorderWidth(r10.getPopoverBorderWidth());
        L8:
            r13.setTransparentBg(r10.getPopoverTransparentBg());
            return r13;
        }

        public static /* synthetic */ OPopoverLayout e(OPopoverBase r10, View r11, int r12, int r13, Object r14) {
            if (r14 != null) goto L9;
            if ((r13 & 2) == 0) goto L7;
            r12 = 3;
        L7:
            return r10.createPopoverBubbleLayout(r11, r12);
        L9:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: createPopoverBubbleLayout");
        }

        public static View f(OPopoverBase r10) {
            q.g(r10, "this");
            return r10.getPopoverBubbleLayout();
        }

        public static int g(OPopoverBase r10) {
            q.g(r10, "this");
            int r11 = r10.getPopoverDisplayOrientation();
            if (r11 != 1) goto L5;
            return 90;
        L5:
            if (r11 == 3) goto L7;
            return 0;
        L7:
            return 270;
        }

        public static boolean h(OPopoverBase r10) {
            q.g(r10, "this");
            return true;
        }

        public static Animator i(OPopoverBase r10) {
            q.g(r10, "this");
            return null;
        }

        public static Animator j(OPopoverBase r10) {
            q.g(r10, "this");
            return null;
        }

        public static void k(OPopoverBase r10, View r11, int r12, int r13) {
            q.g(r10, "this");
            q.g(r11, "target");
            if (r10.getPopoverWidth() != 0) goto L5;
        L7:
            r11.measure(r12, r13);
            return;
        L5:
            if (r10.getPopoverHeight() == 0) goto L7;
            r11.measure(View.MeasureSpec.makeMeasureSpec(r10.getPopoverWidth(), Ints.MAX_POWER_OF_TWO), View.MeasureSpec.makeMeasureSpec(r10.getPopoverHeight(), Ints.MAX_POWER_OF_TWO));
        }

        public static void l(OPopoverBase r10, int r11, int r12) {
            q.g(r10, "this");
            r10.measurePopoverContent(r10.getContentViewInternal(), r11, r12);
        }

        public static void m(OPopoverBase r10) {
            q.g(r10, "this");
            if (r10.getPopoverRemovedFromStack() == false) goto L5;
            return;
        L5:
            r10.setPopoverRemovedFromStack(true);
            StackController.f16240a.d(r10);
        }

        public static void n(final OPopoverBase r10) {
            q.g(r10, "this");
            r10.cancelPopoverAnimatorInternal();
            boolean r11 = r10.getPopoverAnimationIsWindowMode();
            r10.setPopoverAnimator(r10.startPopoverVisibilityAnimationInternal(true, r10.resolvePopoverAnimationGravityInternal(), r11, r10.getPopoverEnterAnimator(), new AnonymousClass1(r10), new AnonymousClass2(r10)));
        }

        public static void o(final OPopoverBase r10) {
            q.g(r10, "this");
            r10.cancelPopoverAnimatorInternal();
            r10.onPopoverStartDismissInternal();
            boolean r11 = r10.getPopoverAnimationIsWindowMode();
            r10.setPopoverAnimator(G(r10, false, r10.resolvePopoverAnimationGravityInternal(), r11, r10.getPopoverExitAnimator(), null, new C04471(r10), 16, null));
        }

        public static View p(OPopoverBase r10, View r11) {
            q.g(r10, "this");
            if (r11 == null) goto L6;
            return r11;
        L6:
            throw new IllegalArgumentException("mView must be not null");
        }

        public static void q(OPopoverBase r10, View r11) {
            q.g(r10, "this");
            q.g(r11, "view");
            r11.setAlpha(1.0f);
            r11.setScaleX(1.0f);
            r11.setScaleY(1.0f);
            r11.setTranslationY(0.0f);
        }

        public static /* synthetic */ void r(OPopoverBase r10, View r11, int r12, Object r13) {
            if (r13 != null) goto L9;
            if ((r12 & 1) == 0) goto L6;
            r11 = r10.getPopoverWindowFrame();
        L6:
            r10.resetPopoverAnimatedViewState(r11);
            return;
        L9:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: resetPopoverAnimatedViewState");
        }

        public static float s(OPopoverBase r10, float r11, int r12, float r13) {
            q.g(r10, "this");
            if (Float.isNaN(r11) == false) goto L6;
            return r13;
        L6:
            return r11 - r12;
        }

        public static b t(OPopoverBase r10, int r11) {
            q.g(r10, "this");
            if (r11 != 0) goto L6;
            int r12 = 0;
            int r13 = 0;
            int r14 = 0;
            int r15 = 0;
            return new b(r12, r13, r14, r15, 15, null);
        L6:
            List r16 = OUILayoutHelper.x(r10.getPopoverContext(), r11);
            q.f(r16, "extractShadowInfo(popoverContext, shadowStyleRes)");
            int r17 = 0;
            int r18 = 0;
            int r19 = 0;
            int r20 = 0;
            b r21 = new b(r17, r18, r19, r20, 15, null);
            Iterator<T> r22 = r16.iterator();
        L8:
            if (r22.hasNext() == false) goto L10;
            Shadow r23 = (Shadow) r22.next();
            r21.f(Math.max(r21.b(), yf.b.b(r23.i() - r23.f())));
            r21.h(Math.max(r21.d(), yf.b.b(r23.i() - r23.g())));
            r21.g(Math.max(r21.c(), yf.b.b(r23.i() + r23.f())));
            r21.e(Math.max(r21.a(), yf.b.b(r23.i() + r23.g())));
            goto L8
        L10:
            return r21;
        }

        public static float u(OPopoverBase r10, int r11) {
            q.g(r10, "this");
            float r12 = 0.0f;
            if (r11 != 0) goto L5;
            return 0.0f;
        L5:
            List r13 = OUILayoutHelper.x(r10.getPopoverContext(), r11);
            q.f(r13, "extractShadowInfo(popoverContext, shadowStyleRes)");
            Iterator<T> r14 = r13.iterator();
        L7:
            if (r14.hasNext() == false) goto L9;
            r12 = r12 + ((Shadow) r14.next()).i();
            goto L7
        L9:
            return r12;
        }

        public static void v(OPopoverBase r10, int r11) {
            q.g(r10, "this");
            r10.setPopoverGravity(OPopover.Z.a(r11));
        }

        public static void w(OPopoverBase r10, int r11, View r12) {
            q.g(r10, "this");
            q.g(r12, "measureTarget");
            if (r10.isPopoverBubbleLayoutInitialized() == false) goto L8;
            if (r11 <= 0) goto L9;
            r10.setPopoverMaxContentHeight(r11, r12, Integer.MIN_VALUE, Integer.MIN_VALUE);
            return;
        L9:
            return;
        }

        public static /* synthetic */ void x(OPopoverBase r10, int r11, View r12, int r13, Object r14) {
            if (r14 != null) goto L9;
            if ((r13 & 2) == 0) goto L6;
            r12 = r10.getContentViewInternal();
        L6:
            r10.setMaxContentHeightInternal(r11, r12);
            return;
        L9:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setMaxContentHeightInternal");
        }

        public static void y(OPopoverBase r10, int r11, View r12, int r13, int r14) {
            q.g(r10, "this");
            q.g(r12, "measureTarget");
            if (r11 > 0) goto L5;
            return;
        L5:
            int r15 = h.d(r11 - (r10.getPopoverBubbleLayout().getArrowHeight() * 2), 0);
            a.a(OPopoverBase.Companion, r10.getPopoverBubbleLayout(), r15);
            r10.getPopoverBubbleLayout().requestLayout();
            r10.measurePopoverContent(r12, r13, r14);
        }

        public static void z(OPopoverBase r10, int r11) {
            q.g(r10, "this");
            r10.setPopoverXOffset(r11);
        }
    }

    public static final class StackController {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final StackController f16240a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final List f16241b = null;

        static {
            f16240a = new StackController();
            f16241b = new ArrayList();
        }

        public StackController() {
        }

        public static /* synthetic */ OPopoverBase g(StackController r10, OPopoverBase r11, int r12, Object r13) {
            if ((r12 & 1) == 0) goto L6;
            r11 = null;
        L6:
            return r10.f(r11);
        }

        public final synchronized void a(OPopoverBase r10, boolean r11, int r12, float r13, float r14) {
            monitor-enter(this);
            q.g(r10, PerfConsts.KEY_CURRENT_GALVANIC);     // Catch: Throwable -> L10
            OPopoverLayout.i(r10.getPopoverBubbleLayout(), false, 0, 2, null);     // Catch: Throwable -> L10
            if (r11 == true) goto L7;
            monitor-exit(this);
            return;
        L7:
            c(r10, r12, r13, r14);     // Catch: Throwable -> L10
            monitor-exit(this);
            return;
        L10:
            th = move-exception;
            throw th;
        }

        public final synchronized void b() {
            monitor-enter(this);
            y.B(f16241b, OPopoverBase$StackController$cleanupStackLocked$1.INSTANCE);     // Catch: Throwable -> L6
            monitor-exit(this);
            return;
        L6:
            th = move-exception;
            throw th;
        }

        public final synchronized void c(OPopoverBase r10, int r11, float r12, float r13) {
            monitor-enter(this);
            OPopoverBase r14 = f(r10);     // Catch: Throwable -> L10
            if (r14 != null) goto L7;
            monitor-exit(this);
            return;
        L7:
            e.f16319a.d(r14, false, r12, r13);     // Catch: Throwable -> L10
            monitor-exit(this);
            return;
        L10:
            th = move-exception;
            throw th;
        }

        public final synchronized void d(final OPopoverBase r10) {
            monitor-enter(this);
            q.g(r10, PerfConsts.KEY_CURRENT_GALVANIC);     // Catch: Throwable -> L9
            b();     // Catch: Throwable -> L9
            y.B(f16241b, new OPopoverBase$StackController$onDismiss$1(r10));     // Catch: Throwable -> L9
            OPopoverBase r11 = g(this, null, 1, null);     // Catch: Throwable -> L9
            if (r11 == null) goto L7;
            e.f16319a.d(r11, true, 1.0f, 1.0f);     // Catch: Throwable -> L9
        L7:
            monitor-exit(this);
            return;
        L9:
            th = move-exception;
            throw th;
        }

        public final synchronized void e(final OPopoverBase r10) {
            monitor-enter(this);
            q.g(r10, PerfConsts.KEY_CURRENT_GALVANIC);     // Catch: Throwable -> L6
            b();     // Catch: Throwable -> L6
            List r11 = f16241b;     // Catch: Throwable -> L6
            y.B(r11, new OPopoverBase$StackController$onShow$1(r10));     // Catch: Throwable -> L6
            r11.add(new WeakReference(r10));     // Catch: Throwable -> L6
            monitor-exit(this);
            return;
        L6:
            th = move-exception;
            throw th;
        }

        public final synchronized OPopoverBase f(OPopoverBase r10) {
            monitor-enter(this);
            b();     // Catch: Throwable -> L16
            int r11 = f16241b.size() - 1;     // Catch: Throwable -> L16
            if (r11 < 0) goto L18;
        L5:
            int r12 = r11 - 1;     // Catch: Throwable -> L16
            OPopoverBase r13 = (OPopoverBase) ((WeakReference) f16241b.get(r11)).get();     // Catch: Throwable -> L16
            if (r13 == null) goto L11;
            if (r10 == null) goto L14;
            if (r13 == r10) goto L11;
        L14:
            monitor-exit(this);
            return r13;
        L11:
            if (r12 < 0) goto L18;
            r11 = r12;
        L18:
            monitor-exit(this);
            return null;
        L16:
            th = move-exception;
            throw th;
        }
    }

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f16242a = null;

        static {
            f16242a = new a();
        }

        public a() {
        }

        public static final /* synthetic */ void a(a r10, View r11, int r12) {
            r10.c(r11, r12);
        }

        public static final /* synthetic */ View b(a r10, Context r11, int r12, View r13) {
            return r10.d(r11, r12, r13);
        }

        public final void c(View r10, int r11) {
            if ((r10 instanceof OPopoverMenuView) == false) goto L6;
            ((OPopoverMenuView) r10).setPopoverMaxHeight(r11);
        L6:
            if ((r10 instanceof ViewGroup) == false) goto L11;
            Iterator<T> r12 = ViewGroupKt.a((ViewGroup) r10).iterator();
        L9:
            if (r12.hasNext() == false) goto L13;
            View r13 = (View) r12.next();
            f16242a.c(r13, r11);
            goto L9
        L13:
            return;
        }

        public final View d(Context r10, int r11, View r12) {
            if (r11 != 1) goto L5;
            float r13 = 90.0f;
        L10:
            if (r13 != 0.0f) goto L12;
            return r12;
        L12:
            OPopoverLandscapeWrapper r14 = new OPopoverLandscapeWrapper(r10);
            r14.setOrientationAngle(r13);
            r14.addView(r12);
            return r14;
        L5:
            if (r11 == 3) goto L7;
            r13 = 0.0f;
            goto L10
        L7:
            r13 = 270.0f;
            goto L10
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f16243a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f16244b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f16245c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f16246d;

        public b(int r10, int r11, int r12, int r13) {
            this.f16243a = r10;
            this.f16244b = r11;
            this.f16245c = r12;
            this.f16246d = r13;
        }

        public final int a() {
            return this.f16246d;
        }

        public final int b() {
            return this.f16243a;
        }

        public final int c() {
            return this.f16245c;
        }

        public final int d() {
            return this.f16244b;
        }

        public final void e(int r10) {
            this.f16246d = r10;
        }

        public boolean equals(Object r10) {
            if (this != r10) goto L6;
            return true;
        L6:
            if ((r10 instanceof b) == true) goto L8;
            return false;
        L8:
            b r11 = (b) r10;
            if (this.f16243a == r11.f16243a) goto L12;
            return false;
        L12:
            if (this.f16244b == r11.f16244b) goto L15;
            return false;
        L15:
            if (this.f16245c == r11.f16245c) goto L18;
            return false;
        L18:
            if (this.f16246d == r11.f16246d) goto L20;
            return false;
        L20:
            return true;
        }

        public final void f(int r10) {
            this.f16243a = r10;
        }

        public final void g(int r10) {
            this.f16245c = r10;
        }

        public final void h(int r10) {
            this.f16244b = r10;
        }

        public int hashCode() {
            return (((((Integer.hashCode(this.f16243a) * 31) + Integer.hashCode(this.f16244b)) * 31) + Integer.hashCode(this.f16245c)) * 31) + Integer.hashCode(this.f16246d);
        }

        public String toString() {
            return "ShadowPadding(left=" + this.f16243a + ", top=" + this.f16244b + ", right=" + this.f16245c + ", bottom=" + this.f16246d + ')';
        }

        public /* synthetic */ b(int r10, int r11, int r12, int r13, int r14, DefaultConstructorMarker r15) {
            if ((r14 & 1) == 0) goto L6;
            r10 = 0;
        L6:
            if ((r14 & 2) == 0) goto L9;
            r11 = 0;
        L9:
            if ((r14 & 4) == 0) goto L12;
            r12 = 0;
        L12:
            if ((r14 & 8) == 0) goto L14;
            r13 = 0;
        L14:
            this(r10, r11, r12, r13);
        }
    }

    static {
        Companion = a.f16242a;
    }

    void afterShowInStackIfNeeded();

    void beforeShowInStackIfNeeded();

    void cancelPopoverAnimatorInternal();

    @NotNull
    OPopoverLayout createPopoverBubbleLayout(@NotNull View r10, int r11);

    void finishPopoverDismissInternal();

    @NotNull
    View getContentViewInternal();

    int getDisplayRotationDegreesInternal();

    float getPopoverAnchorCenterX();

    float getPopoverAnchorCenterY();

    long getPopoverAnimationDurationMillis();

    boolean getPopoverAnimationIsWindowMode();

    @Nullable
    AnimatorSet getPopoverAnimator();

    int getPopoverBgColor();

    int getPopoverBorderColor();

    int getPopoverBorderWidth();

    @NotNull
    OPopoverLayout getPopoverBubbleLayout();

    @NotNull
    Context getPopoverContext();

    boolean getPopoverCoverPreviousWhenStacked();

    int getPopoverDisplayOrientation();

    boolean getPopoverEnableBubbleMaterial();

    @Nullable
    Animator getPopoverEnterAnimator();

    @Nullable
    Animator getPopoverExitAnimator();

    int getPopoverGravity();

    int getPopoverHeight();

    @NotNull
    Function1<Boolean, com.obric.oui.material.b[]> getPopoverMaterials();

    int getPopoverPopupOriginX();

    int getPopoverPopupOriginY();

    boolean getPopoverPushedToStack();

    boolean getPopoverRemovedFromStack();

    boolean getPopoverShowWithAnimation();

    float getPopoverStackAlphaPrevious();

    @ColorInt
    int getPopoverStackCoverColor();

    float getPopoverStackScalePrevious();

    boolean getPopoverTransparentBg();

    int getPopoverWidth();

    @NotNull
    ViewGroup getPopoverWindowFrame();

    int getPopoverXOffset();

    int getPopoverYOffset();

    boolean isPopoverBubbleLayoutInitialized();

    boolean isPopoverShowing();

    void measurePopoverContent(@NotNull View r10, int r11, int r12);

    void measurePopupInternal(int r10, int r11);

    void onDestroyInStackIfNeeded();

    void onPopoverShownInternal();

    void onPopoverStartDismissInternal();

    @UiThread
    void playPopoverEnterAnimationInternal();

    @UiThread
    void playPopoverExitAnimationInternal();

    @NotNull
    View requirePopoverContentView(@Nullable View r10);

    void resetPopoverAnimatedViewState(@NotNull View r10);

    int resolvePopoverAnimationGravityInternal();

    float resolvePopoverPivot(float r10, int r11, float r12);

    @NotNull
    b resolvePopoverShadowPadding(@StyleRes int r10);

    float resolvePopoverShadowSpace(@StyleRes int r10);

    void setGravityInternal(int r10);

    void setMaxContentHeightInternal(int r10, @NotNull View r11);

    void setPopoverAnchorCenterX(float r10);

    void setPopoverAnchorCenterY(float r10);

    void setPopoverAnimator(@Nullable AnimatorSet r10);

    void setPopoverBubbleLayout(@NotNull OPopoverLayout r10);

    void setPopoverGravity(int r10);

    void setPopoverMaxContentHeight(int r10, @NotNull View r11, int r12, int r13);

    void setPopoverPopupOriginX(int r10);

    void setPopoverPopupOriginY(int r10);

    void setPopoverPushedToStack(boolean r10);

    void setPopoverRemovedFromStack(boolean r10);

    void setPopoverWindowFrame(@NotNull ViewGroup r10);

    void setPopoverXOffset(int r10);

    void setPopoverYOffset(int r10);

    void setXOffsetInternal(int r10);

    void setYOffsetInternal(int r10);

    boolean shouldAnimatePopoverVisibilityInternal();

    void showPopoverDirectlyInternal(@NotNull ViewGroup r10, @Nullable Function0<Unit> r11);

    void showPopoverWithoutAnimationInternal();

    @NotNull
    AnimatorSet startPopoverVisibilityAnimationInternal(boolean r10, int r11, boolean r12, @Nullable Animator r13, @Nullable Function0<Unit> r14, @Nullable Function0<Unit> r15);

    void updatePopoverPivotInternal();
}
