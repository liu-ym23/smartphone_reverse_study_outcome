package com.obric.oui.popover.v2;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import androidx.annotation.ColorInt;
import androidx.appcompat.widget.p;
import com.obric.oui.material.o;
import com.obric.oui.popover.FakeAnchorView;
import com.tmall.wireless.tangram.structure.card.FixCard;
import java.lang.ref.WeakReference;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000¢\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u001b\n\u0002\u0010\t\n\u0002\b#\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0007\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0016\u0018\u0000 Ö\u00012\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0002×\u0001J\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\b\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\n\u0010\tJ\u001d\u0010\r\u001a\u00020\u00052\u000e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u000b¢\u0006\u0004\b\r\u0010\u000eJ\u001d\u0010\u000f\u001a\u00020\u00052\u000e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u000b¢\u0006\u0004\b\u000f\u0010\u000eJ\u0017\u0010\u0011\u001a\u00020\u00052\b\u0010\f\u001a\u0004\u0018\u00010\u0010¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0014\u001a\u00020\u00052\b\u0010\f\u001a\u0004\u0018\u00010\u0013¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0017\u001a\u00020\u00052\b\u0010\f\u001a\u0004\u0018\u00010\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u0015\u0010\u001b\u001a\u00020\u00052\u0006\u0010\u001a\u001a\u00020\u0019¢\u0006\u0004\b\u001b\u0010\u001cJ\u0015\u0010\u001e\u001a\u00020\u00052\u0006\u0010\u001d\u001a\u00020\u0019¢\u0006\u0004\b\u001e\u0010\u001cJ\u0015\u0010!\u001a\u00020\u00052\u0006\u0010 \u001a\u00020\u001f¢\u0006\u0004\b!\u0010\"J\u0015\u0010$\u001a\u00020\u00052\u0006\u0010#\u001a\u00020\u001f¢\u0006\u0004\b$\u0010\"J\r\u0010%\u001a\u00020\u0003¢\u0006\u0004\b%\u0010&J\u000f\u0010)\u001a\u00020\u001fH\u0000¢\u0006\u0004\b'\u0010(J\u0017\u0010,\u001a\u00020\u00052\u0006\u0010*\u001a\u00020\u001fH\u0000¢\u0006\u0004\b+\u0010\"J\u000f\u0010-\u001a\u00020\u001fH\u0016¢\u0006\u0004\b-\u0010(J\u000f\u0010.\u001a\u00020\u0005H\u0016¢\u0006\u0004\b.\u0010\tJ\u000f\u0010/\u001a\u00020\u0005H\u0016¢\u0006\u0004\b/\u0010\tJ\u000f\u00100\u001a\u00020\u0005H\u0016¢\u0006\u0004\b0\u0010\tJ\u000f\u00101\u001a\u00020\u0005H\u0014¢\u0006\u0004\b1\u0010\tJ\u000f\u00102\u001a\u00020\u0005H\u0014¢\u0006\u0004\b2\u0010\tJ\u0015\u00104\u001a\u00020\u00052\u0006\u00103\u001a\u00020\u001f¢\u0006\u0004\b4\u0010\"J\u000f\u00105\u001a\u00020\u0019H\u0016¢\u0006\u0004\b5\u00106R\u001a\u0010:\u001a\u00020\u00198\u0016X\u0096\u0004¢\u0006\f\n\u0004\b7\u00108\u001a\u0004\b9\u00106R\u001a\u0010?\u001a\u00020;8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\n\u0010<\u001a\u0004\b=\u0010>R\u001a\u0010B\u001a\u00020\u00198\u0016X\u0096D¢\u0006\f\n\u0004\b@\u00108\u001a\u0004\bA\u00106R\"\u0010F\u001a\u00020\u001f8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\b\u0010C\u001a\u0004\bD\u0010(\"\u0004\bE\u0010\"R\"\u0010J\u001a\u00020\u001f8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\bG\u0010C\u001a\u0004\bH\u0010(\"\u0004\bI\u0010\"R\"\u0010N\u001a\u00020\u001f8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\bK\u0010C\u001a\u0004\bL\u0010(\"\u0004\bM\u0010\"R\u0014\u0010P\u001a\u00020;8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bO\u0010<R\u0018\u0010S\u001a\u0004\u0018\u00010\u00138\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bQ\u0010RR\u0018\u0010V\u001a\u0004\u0018\u00010\u00168\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bT\u0010UR\u0018\u0010Y\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bW\u0010XR\u001e\u0010\\\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bZ\u0010[R\u001e\u0010^\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b]\u0010[R\"\u0010f\u001a\u00020_8\u0016@\u0016X\u0096.¢\u0006\u0012\n\u0004\b`\u0010a\u001a\u0004\bb\u0010c\"\u0004\bd\u0010eR\"\u0010n\u001a\u00020g8\u0016@\u0016X\u0096.¢\u0006\u0012\n\u0004\bh\u0010i\u001a\u0004\bj\u0010k\"\u0004\bl\u0010mR$\u0010v\u001a\u0004\u0018\u00010o8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\bp\u0010q\u001a\u0004\br\u0010s\"\u0004\bt\u0010uR\u0016\u0010x\u001a\u00020\u00198\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bw\u00108R#\u0010\u0080\u0001\u001a\u00020y8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\bz\u0010{\u001a\u0004\b|\u0010}\"\u0004\b~\u0010\u007fR&\u0010\u0084\u0001\u001a\u00020y8\u0016@\u0016X\u0096\u000e¢\u0006\u0015\n\u0005\b\u0081\u0001\u0010{\u001a\u0005\b\u0082\u0001\u0010}\"\u0005\b\u0083\u0001\u0010\u007fR&\u0010\u0088\u0001\u001a\u00020\u001f8\u0016@\u0016X\u0096\u000e¢\u0006\u0015\n\u0005\b\u0085\u0001\u0010C\u001a\u0005\b\u0086\u0001\u0010(\"\u0005\b\u0087\u0001\u0010\"R&\u0010\u008c\u0001\u001a\u00020\u001f8\u0016@\u0016X\u0096\u000e¢\u0006\u0015\n\u0005\b\u0089\u0001\u0010C\u001a\u0005\b\u008a\u0001\u0010(\"\u0005\b\u008b\u0001\u0010\"R\u001a\u0010\u008e\u0001\u001a\u0004\u0018\u00010g8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u008d\u0001\u0010iR\"\u0010\u0092\u0001\u001a\u000b\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u008f\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0090\u0001\u0010\u0091\u0001R&\u0010\u0096\u0001\u001a\u00020\u00198\u0016@\u0016X\u0096\u000e¢\u0006\u0015\n\u0005\b\u0093\u0001\u00108\u001a\u0005\b\u0094\u0001\u00106\"\u0005\b\u0095\u0001\u0010\u001cR&\u0010\u009a\u0001\u001a\u00020\u00198\u0016@\u0016X\u0096\u000e¢\u0006\u0015\n\u0005\b\u0097\u0001\u00108\u001a\u0005\b\u0098\u0001\u00106\"\u0005\b\u0099\u0001\u0010\u001cR\u0018\u0010\u009e\u0001\u001a\u00030\u009b\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u009c\u0001\u0010\u009d\u0001R\u001d\u0010¡\u0001\u001a\u00020\u001f8\u0016X\u0096\u0004¢\u0006\u000e\n\u0005\b\u009f\u0001\u0010C\u001a\u0005\b \u0001\u0010(R\u001d\u0010¤\u0001\u001a\u00020\u001f8\u0016X\u0096\u0004¢\u0006\u000e\n\u0005\b¢\u0001\u0010C\u001a\u0005\b£\u0001\u0010(R\u001d\u0010§\u0001\u001a\u00020\u001f8\u0016X\u0096\u0004¢\u0006\u000e\n\u0005\b¥\u0001\u0010C\u001a\u0005\b¦\u0001\u0010(R\u001d\u0010ª\u0001\u001a\u00020\u001f8\u0016X\u0096\u0004¢\u0006\u000e\n\u0005\b¨\u0001\u0010C\u001a\u0005\b©\u0001\u0010(R\u001d\u0010\u00ad\u0001\u001a\u00020\u00198\u0016X\u0096\u0004¢\u0006\u000e\n\u0005\b«\u0001\u00108\u001a\u0005\b¬\u0001\u00106R\u001d\u0010°\u0001\u001a\u00020\u001f8\u0016X\u0096\u0004¢\u0006\u000e\n\u0005\b®\u0001\u0010C\u001a\u0005\b¯\u0001\u0010(R\u001c\u0010²\u0001\u001a\u00020\u001f8\u0016X\u0096\u0004¢\u0006\r\n\u0004\b{\u0010C\u001a\u0005\b±\u0001\u0010(R\u001d\u0010µ\u0001\u001a\u00020\u00198\u0016X\u0096\u0004¢\u0006\u000e\n\u0005\b³\u0001\u00108\u001a\u0005\b´\u0001\u00106R4\u0010½\u0001\u001a\u0017\u0012\u0004\u0012\u00020\u0019\u0012\f\u0012\n\u0012\u0005\u0012\u00030¸\u00010·\u00010¶\u00018\u0016X\u0096\u0004¢\u0006\u0010\n\u0006\b¹\u0001\u0010º\u0001\u001a\u0006\b»\u0001\u0010¼\u0001R\u001c\u0010¿\u0001\u001a\u00020\u00198\u0016X\u0096\u0004¢\u0006\r\n\u0004\bC\u00108\u001a\u0005\b¾\u0001\u00106R\u001c\u0010Á\u0001\u001a\u00020\u001f8WX\u0096\u0004¢\u0006\r\n\u0004\b<\u0010C\u001a\u0005\bÀ\u0001\u0010(R\u001d\u0010Ä\u0001\u001a\u00020y8\u0016X\u0096\u0004¢\u0006\u000e\n\u0005\bÂ\u0001\u0010{\u001a\u0005\bÃ\u0001\u0010}R\u001d\u0010Ç\u0001\u001a\u00020y8\u0016X\u0096\u0004¢\u0006\u000e\n\u0005\bÅ\u0001\u0010{\u001a\u0005\bÆ\u0001\u0010}R'\u0010Ê\u0001\u001a\u00020\u00192\u0007\u0010È\u0001\u001a\u00020\u00198\u0006@BX\u0086\u000e¢\u0006\r\n\u0005\bÉ\u0001\u00108\u001a\u0004\b@\u00106R\u0018\u0010Î\u0001\u001a\u00030Ë\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\bÌ\u0001\u0010Í\u0001R\u0018\u0010Ð\u0001\u001a\u00030Ë\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\bÏ\u0001\u0010Í\u0001R\u0016\u0010Ñ\u0001\u001a\u00020\u00198VX\u0096\u0004¢\u0006\u0007\u001a\u0005\bÑ\u0001\u00106R\u0018\u0010Õ\u0001\u001a\u00030Ò\u00018VX\u0096\u0004¢\u0006\b\u001a\u0006\bÓ\u0001\u0010Ô\u0001¨\u0006Ø\u0001"}, d2 = {"Lcom/obric/oui/popover/v2/OPopoverModal;", "Landroid/widget/FrameLayout;", "Lcom/obric/oui/popover/v2/OPopoverBase;", "Landroid/view/View;", "view", "", "setBubbleLayout", "(Landroid/view/View;)V", "d", "()V", "b", "Lkotlin/Function0;", "listener", "setOnDismissListener", "(Lkotlin/jvm/functions/Function0;)V", "setOnShowListener", "Lcom/obric/oui/popover/v2/OPopover$OnBubbleShowListener;", "setOnBubbleShowListener", "(Lcom/obric/oui/popover/v2/OPopover$OnBubbleShowListener;)V", "Lcom/obric/oui/popover/v2/OPopover$OnBubbleStartDismissListener;", "setOnBubbleStartDismissListener", "(Lcom/obric/oui/popover/v2/OPopover$OnBubbleStartDismissListener;)V", "Lcom/obric/oui/popover/v2/OPopover$OnBubbleDismissListener;", "setOnBubbleDismissListener", "(Lcom/obric/oui/popover/v2/OPopover$OnBubbleDismissListener;)V", "", "remove", "setRemoveOnDismiss", "(Z)V", "enabled", "setEnableAutoDismiss", "", "xOffset", "setXOffset", "(I)V", "yOffset", "setYOffset", "getContentView", "()Landroid/view/View;", "getDisplayRotationDegrees$OUI_standardRelease", "()I", "getDisplayRotationDegrees", "gravity", "setGravity$OUI_standardRelease", "setGravity", "resolvePopoverAnimationGravityInternal", "onPopoverShownInternal", "onPopoverStartDismissInternal", "finishPopoverDismissInternal", "onDetachedFromWindow", "onAttachedToWindow", "maxHeight", "setMaxContentHeight", "isPopoverShowing", "()Z", "a", "Z", "getPopoverShowWithAnimation", "popoverShowWithAnimation", "", "J", "getPopoverAnimationDurationMillis", "()J", "popoverAnimationDurationMillis", "c", "getPopoverAnimationIsWindowMode", "popoverAnimationIsWindowMode", "I", "getPopoverGravity", "setPopoverGravity", "popoverGravity", "e", "getPopoverXOffset", "setPopoverXOffset", "popoverXOffset", "f", "getPopoverYOffset", "setPopoverYOffset", "popoverYOffset", "g", "mAutoDismissDelayMillis", "h", "Lcom/obric/oui/popover/v2/OPopover$OnBubbleStartDismissListener;", "bubbleStartDismissListener", "i", "Lcom/obric/oui/popover/v2/OPopover$OnBubbleDismissListener;", "bubbleDismissListener", "j", "Lcom/obric/oui/popover/v2/OPopover$OnBubbleShowListener;", "bubbleShowListener", "k", "Lkotlin/jvm/functions/Function0;", "dismissListener", "l", "showListener", "Lcom/obric/oui/popover/v2/OPopoverLayout;", "m", "Lcom/obric/oui/popover/v2/OPopoverLayout;", "getPopoverBubbleLayout", "()Lcom/obric/oui/popover/v2/OPopoverLayout;", "setPopoverBubbleLayout", "(Lcom/obric/oui/popover/v2/OPopoverLayout;)V", "popoverBubbleLayout", "Landroid/view/ViewGroup;", "n", "Landroid/view/ViewGroup;", "getPopoverWindowFrame", "()Landroid/view/ViewGroup;", "setPopoverWindowFrame", "(Landroid/view/ViewGroup;)V", "popoverWindowFrame", "Landroid/animation/AnimatorSet;", "o", "Landroid/animation/AnimatorSet;", "getPopoverAnimator", "()Landroid/animation/AnimatorSet;", "setPopoverAnimator", "(Landroid/animation/AnimatorSet;)V", "popoverAnimator", "p", "removeOnDismiss", "", "q", "F", "getPopoverAnchorCenterX", "()F", "setPopoverAnchorCenterX", "(F)V", "popoverAnchorCenterX", "r", "getPopoverAnchorCenterY", "setPopoverAnchorCenterY", "popoverAnchorCenterY", "s", "getPopoverPopupOriginX", "setPopoverPopupOriginX", "popoverPopupOriginX", "t", "getPopoverPopupOriginY", "setPopoverPopupOriginY", "popoverPopupOriginY", "u", "currentHostParent", "Ljava/lang/ref/WeakReference;", "v", "Ljava/lang/ref/WeakReference;", "currentAnchorRef", "w", "getPopoverPushedToStack", "setPopoverPushedToStack", "popoverPushedToStack", FixCard.FixStyle.KEY_X, "getPopoverRemovedFromStack", "setPopoverRemovedFromStack", "popoverRemovedFromStack", "Landroid/os/Handler;", FixCard.FixStyle.KEY_Y, "Landroid/os/Handler;", "mainHandler", "z", "getPopoverDisplayOrientation", "popoverDisplayOrientation", "A", "getPopoverBgColor", "popoverBgColor", "B", "getPopoverBorderWidth", "popoverBorderWidth", "C", "getPopoverBorderColor", "popoverBorderColor", "D", "getPopoverTransparentBg", "popoverTransparentBg", "E", "getPopoverWidth", "popoverWidth", "getPopoverHeight", "popoverHeight", "G", "getPopoverEnableBubbleMaterial", "popoverEnableBubbleMaterial", "Lkotlin/Function1;", "", "Lcom/obric/oui/material/b;", "H", "Lkotlin/jvm/functions/Function1;", "getPopoverMaterials", "()Lkotlin/jvm/functions/Function1;", "popoverMaterials", "getPopoverCoverPreviousWhenStacked", "popoverCoverPreviousWhenStacked", "getPopoverStackCoverColor", "popoverStackCoverColor", "K", "getPopoverStackAlphaPrevious", "popoverStackAlphaPrevious", "L", "getPopoverStackScalePrevious", "popoverStackScalePrevious", "<set-?>", "M", "isShowing", "Ljava/lang/Runnable;", "N", "Ljava/lang/Runnable;", "autoDismissRunnable", "O", "detachedCleanupRunnable", "isPopoverBubbleLayoutInitialized", "Landroid/content/Context;", "getPopoverContext", "()Landroid/content/Context;", "popoverContext", "P", "Companion", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public class OPopoverModal extends FrameLayout implements OPopoverBase<OPopoverModal> {
    public static final Companion P = null;
    public static final Map Q = null;
    public final int A;
    public final int B;
    public final int C;
    public final boolean D;
    public final int E;
    public final int F;
    public final boolean G;
    public final Function1 H;
    public final boolean I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public final int f16275J;
    public final float K;
    public final float L;
    public boolean M;
    public final Runnable N;
    public final Runnable O;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f16276a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f16277b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f16278c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f16279d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f16280e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f16281f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final long f16282g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public OPopover.OnBubbleStartDismissListener f16283h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public OPopover.OnBubbleDismissListener f16284i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public OPopover.OnBubbleShowListener f16285j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public Function0 f16286k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public Function0 f16287l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public OPopoverLayout f16288m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public ViewGroup f16289n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public AnimatorSet f16290o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f16291p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public float f16292q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public float f16293r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public int f16294s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public int f16295t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public ViewGroup f16296u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public WeakReference f16297v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public boolean f16298w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public boolean f16299x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final Handler f16300y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final int f16301z;

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r10) {
            this();
        }

        public static final /* synthetic */ void a(Companion r10, Activity r11, OPopoverModal r12) {
            r10.b(r11, r12);
        }

        public final synchronized void b(Activity r10, OPopoverModal r11) {
            monitor-enter(this);
            p.a(OPopoverModal.a().get(r10));     // Catch: Throwable -> L6
            monitor-exit(this);
            return;
        L6:
            th = move-exception;
            throw th;
        }

        public Companion() {
        }
    }

    static {
        P = new Companion(null);
        Q = new LinkedHashMap();
    }

    public static final /* synthetic */ Map a() {
        return Q;
    }

    private final void setBubbleLayout(View r10) {
        setPopoverBubbleLayout(createPopoverBubbleLayout(r10, 2));
        o.n(getPopoverBubbleLayout(), this);
    }

    @Override // com.obric.oui.popover.v2.OPopoverBase
    public void afterShowInStackIfNeeded() {
        OPopoverBase.DefaultImpls.a(this);
    }

    public final void b() {
        WeakReference r10 = this.f16297v;
        if (r10 != null) goto L5;
        View r11 = null;
    L7:
        if ((r11 instanceof FakeAnchorView) == false) goto L15;
        ViewParent r12 = ((FakeAnchorView) r11).getParent();
        if ((r12 instanceof ViewGroup) == false) goto L11;
        ViewGroup r13 = (ViewGroup) r12;
    L12:
        if (r13 == null) goto L15;
        r13.removeView(r11);
        goto L15
    L11:
        r13 = null;
    L15:
        this.f16297v = null;
        this.f16296u = null;
        return;
    L5:
        r11 = (View) r10.get();
        goto L7
    }

    @Override // com.obric.oui.popover.v2.OPopoverBase
    public void beforeShowInStackIfNeeded() {
        OPopoverBase.DefaultImpls.b(this);
    }

    public final boolean c() {
        return this.M;
    }

    @Override // com.obric.oui.popover.v2.OPopoverBase
    public void cancelPopoverAnimatorInternal() {
        OPopoverBase.DefaultImpls.c(this);
    }

    @Override // com.obric.oui.popover.v2.OPopoverBase
    public OPopoverLayout createPopoverBubbleLayout(View r10, int r11) {
        return OPopoverBase.DefaultImpls.d(this, r10, r11);
    }

    public final void d() {
        wd.a r10 = wd.a.f25402a;
        Context r11 = getContext();
        q.f(r11, "context");
        Activity r12 = r10.b(r11);
        if (r12 != null) goto L5;
        return;
    L5:
        Companion.a(P, r12, this);
    }

    @Override // com.obric.oui.popover.v2.OPopoverBase
    public void finishPopoverDismissInternal() {
        ViewGroup r10 = null;
        setPopoverAnimator(null);
        this.M = false;
        d();
        setVisibility(8);
        getPopoverWindowFrame().setVisibility(4);
        OPopoverBase.DefaultImpls.r(this, null, 1, null);
        b();
        onDestroyInStackIfNeeded();
        if (this.f16291p == false) goto L10;
        ViewParent r11 = getParent();
        if ((r11 instanceof ViewGroup) == false) goto L7;
        r10 = (ViewGroup) r11;
    L7:
        if (r10 == null) goto L10;
        r10.removeView(this);
    L10:
        OPopover.OnBubbleDismissListener r12 = this.f16284i;
        if (r12 == null) goto L14;
        r12.bubbleDismiss();
    L14:
        Function0 r13 = this.f16286k;
        if (r13 == null) goto L19;
        r13.invoke();
        return;
    }

    @NotNull
    public final View getContentView() {
        return getContentViewInternal();
    }

    @Override // com.obric.oui.popover.v2.OPopoverBase
    @NotNull
    public View getContentViewInternal() {
        return OPopoverBase.DefaultImpls.f(this);
    }

    public final int getDisplayRotationDegrees$OUI_standardRelease() {
        return getDisplayRotationDegreesInternal();
    }

    @Override // com.obric.oui.popover.v2.OPopoverBase
    public int getDisplayRotationDegreesInternal() {
        return OPopoverBase.DefaultImpls.g(this);
    }

    @Override // com.obric.oui.popover.v2.OPopoverBase
    public float getPopoverAnchorCenterX() {
        return this.f16292q;
    }

    @Override // com.obric.oui.popover.v2.OPopoverBase
    public float getPopoverAnchorCenterY() {
        return this.f16293r;
    }

    @Override // com.obric.oui.popover.v2.OPopoverBase
    public long getPopoverAnimationDurationMillis() {
        return this.f16277b;
    }

    @Override // com.obric.oui.popover.v2.OPopoverBase
    public boolean getPopoverAnimationIsWindowMode() {
        return this.f16278c;
    }

    @Override // com.obric.oui.popover.v2.OPopoverBase
    @Nullable
    public AnimatorSet getPopoverAnimator() {
        return this.f16290o;
    }

    @Override // com.obric.oui.popover.v2.OPopoverBase
    public int getPopoverBgColor() {
        return this.A;
    }

    @Override // com.obric.oui.popover.v2.OPopoverBase
    public int getPopoverBorderColor() {
        return this.C;
    }

    @Override // com.obric.oui.popover.v2.OPopoverBase
    public int getPopoverBorderWidth() {
        return this.B;
    }

    @Override // com.obric.oui.popover.v2.OPopoverBase
    @NotNull
    public OPopoverLayout getPopoverBubbleLayout() {
        OPopoverLayout r10 = this.f16288m;
        if (r10 == null) goto L5;
        return r10;
    L5:
        q.y("popoverBubbleLayout");
        return null;
    }

    @Override // com.obric.oui.popover.v2.OPopoverBase
    @NotNull
    public Context getPopoverContext() {
        Context r10 = getContext();
        q.f(r10, "context");
        return r10;
    }

    @Override // com.obric.oui.popover.v2.OPopoverBase
    public boolean getPopoverCoverPreviousWhenStacked() {
        return this.I;
    }

    @Override // com.obric.oui.popover.v2.OPopoverBase
    public int getPopoverDisplayOrientation() {
        return this.f16301z;
    }

    @Override // com.obric.oui.popover.v2.OPopoverBase
    public boolean getPopoverEnableBubbleMaterial() {
        return this.G;
    }

    @Override // com.obric.oui.popover.v2.OPopoverBase
    @Nullable
    public Animator getPopoverEnterAnimator() {
        return OPopoverBase.DefaultImpls.i(this);
    }

    @Override // com.obric.oui.popover.v2.OPopoverBase
    @Nullable
    public Animator getPopoverExitAnimator() {
        return OPopoverBase.DefaultImpls.j(this);
    }

    @Override // com.obric.oui.popover.v2.OPopoverBase
    public int getPopoverGravity() {
        return this.f16279d;
    }

    @Override // com.obric.oui.popover.v2.OPopoverBase
    public int getPopoverHeight() {
        return this.F;
    }

    @Override // com.obric.oui.popover.v2.OPopoverBase
    @NotNull
    public Function1<Boolean, com.obric.oui.material.b[]> getPopoverMaterials() {
        return this.H;
    }

    @Override // com.obric.oui.popover.v2.OPopoverBase
    public int getPopoverPopupOriginX() {
        return this.f16294s;
    }

    @Override // com.obric.oui.popover.v2.OPopoverBase
    public int getPopoverPopupOriginY() {
        return this.f16295t;
    }

    @Override // com.obric.oui.popover.v2.OPopoverBase
    public boolean getPopoverPushedToStack() {
        return this.f16298w;
    }

    @Override // com.obric.oui.popover.v2.OPopoverBase
    public boolean getPopoverRemovedFromStack() {
        return this.f16299x;
    }

    @Override // com.obric.oui.popover.v2.OPopoverBase
    public boolean getPopoverShowWithAnimation() {
        return this.f16276a;
    }

    @Override // com.obric.oui.popover.v2.OPopoverBase
    public float getPopoverStackAlphaPrevious() {
        return this.K;
    }

    @Override // com.obric.oui.popover.v2.OPopoverBase
    @ColorInt
    public int getPopoverStackCoverColor() {
        return this.f16275J;
    }

    @Override // com.obric.oui.popover.v2.OPopoverBase
    public float getPopoverStackScalePrevious() {
        return this.L;
    }

    @Override // com.obric.oui.popover.v2.OPopoverBase
    public boolean getPopoverTransparentBg() {
        return this.D;
    }

    @Override // com.obric.oui.popover.v2.OPopoverBase
    public int getPopoverWidth() {
        return this.E;
    }

    @Override // com.obric.oui.popover.v2.OPopoverBase
    @NotNull
    public ViewGroup getPopoverWindowFrame() {
        ViewGroup r10 = this.f16289n;
        if (r10 == null) goto L5;
        return r10;
    L5:
        q.y("popoverWindowFrame");
        return null;
    }

    @Override // com.obric.oui.popover.v2.OPopoverBase
    public int getPopoverXOffset() {
        return this.f16280e;
    }

    @Override // com.obric.oui.popover.v2.OPopoverBase
    public int getPopoverYOffset() {
        return this.f16281f;
    }

    @Override // com.obric.oui.popover.v2.OPopoverBase
    public boolean isPopoverBubbleLayoutInitialized() {
        if (this.f16288m == null) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.oui.popover.v2.OPopoverBase
    public boolean isPopoverShowing() {
        return this.M;
    }

    @Override // com.obric.oui.popover.v2.OPopoverBase
    public void measurePopoverContent(View r10, int r11, int r12) {
        OPopoverBase.DefaultImpls.k(this, r10, r11, r12);
    }

    @Override // com.obric.oui.popover.v2.OPopoverBase
    public void measurePopupInternal(int r10, int r11) {
        OPopoverBase.DefaultImpls.l(this, r10, r11);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        this.f16300y.removeCallbacks(this.O);
        super.onAttachedToWindow();
    }

    @Override // com.obric.oui.popover.v2.OPopoverBase
    public void onDestroyInStackIfNeeded() {
        OPopoverBase.DefaultImpls.m(this);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        d();
        super.onDetachedFromWindow();
        removeCallbacks(this.N);
        this.f16300y.removeCallbacks(this.O);
        this.f16300y.post(this.O);
    }

    @Override // com.obric.oui.popover.v2.OPopoverBase
    public void onPopoverShownInternal() {
        OPopover.OnBubbleShowListener r10 = this.f16285j;
        if (r10 == null) goto L6;
        r10.bubbleShow();
    L6:
        Function0 r11 = this.f16287l;
        if (r11 == null) goto L11;
        r11.invoke();
        return;
    }

    @Override // com.obric.oui.popover.v2.OPopoverBase
    public void onPopoverStartDismissInternal() {
        OPopover.OnBubbleStartDismissListener r10 = this.f16283h;
        if (r10 == null) goto L7;
        r10.bubbleStartDismiss();
        return;
    }

    @Override // com.obric.oui.popover.v2.OPopoverBase
    public void playPopoverEnterAnimationInternal() {
        OPopoverBase.DefaultImpls.n(this);
    }

    @Override // com.obric.oui.popover.v2.OPopoverBase
    public void playPopoverExitAnimationInternal() {
        OPopoverBase.DefaultImpls.o(this);
    }

    @Override // com.obric.oui.popover.v2.OPopoverBase
    public View requirePopoverContentView(View r10) {
        return OPopoverBase.DefaultImpls.p(this, r10);
    }

    @Override // com.obric.oui.popover.v2.OPopoverBase
    public void resetPopoverAnimatedViewState(View r10) {
        OPopoverBase.DefaultImpls.q(this, r10);
    }

    @Override // com.obric.oui.popover.v2.OPopoverBase
    public int resolvePopoverAnimationGravityInternal() {
        return getPopoverGravity() & 112;
    }

    @Override // com.obric.oui.popover.v2.OPopoverBase
    public float resolvePopoverPivot(float r10, int r11, float r12) {
        return OPopoverBase.DefaultImpls.s(this, r10, r11, r12);
    }

    @Override // com.obric.oui.popover.v2.OPopoverBase
    public OPopoverBase.b resolvePopoverShadowPadding(int r10) {
        return OPopoverBase.DefaultImpls.t(this, r10);
    }

    @Override // com.obric.oui.popover.v2.OPopoverBase
    public float resolvePopoverShadowSpace(int r10) {
        return OPopoverBase.DefaultImpls.u(this, r10);
    }

    public final void setEnableAutoDismiss(boolean r10) {
        removeCallbacks(this.N);
        if (r10 == false) goto L8;
        long r11 = this.f16282g;
        if (r11 <= 0) goto L9;
        postDelayed(this.N, r11);
        return;
    L9:
        return;
    }

    public final void setGravity$OUI_standardRelease(int r10) {
        setGravityInternal(r10);
    }

    @Override // com.obric.oui.popover.v2.OPopoverBase
    public void setGravityInternal(int r10) {
        OPopoverBase.DefaultImpls.v(this, r10);
    }

    public final void setMaxContentHeight(int r10) {
        OPopoverBase.DefaultImpls.x(this, r10, null, 2, null);
    }

    @Override // com.obric.oui.popover.v2.OPopoverBase
    public void setMaxContentHeightInternal(int r10, View r11) {
        OPopoverBase.DefaultImpls.w(this, r10, r11);
    }

    public final void setOnBubbleDismissListener(@Nullable OPopover.OnBubbleDismissListener r10) {
        this.f16284i = r10;
    }

    public final void setOnBubbleShowListener(@Nullable OPopover.OnBubbleShowListener r10) {
        this.f16285j = r10;
    }

    public final void setOnBubbleStartDismissListener(@Nullable OPopover.OnBubbleStartDismissListener r10) {
        this.f16283h = r10;
    }

    public final void setOnDismissListener(@Nullable Function0<Unit> r10) {
        this.f16286k = r10;
    }

    public final void setOnShowListener(@Nullable Function0<Unit> r10) {
        this.f16287l = r10;
    }

    @Override // com.obric.oui.popover.v2.OPopoverBase
    public void setPopoverAnchorCenterX(float r10) {
        this.f16292q = r10;
    }

    @Override // com.obric.oui.popover.v2.OPopoverBase
    public void setPopoverAnchorCenterY(float r10) {
        this.f16293r = r10;
    }

    @Override // com.obric.oui.popover.v2.OPopoverBase
    public void setPopoverAnimator(@Nullable AnimatorSet r10) {
        this.f16290o = r10;
    }

    @Override // com.obric.oui.popover.v2.OPopoverBase
    public void setPopoverBubbleLayout(@NotNull OPopoverLayout r10) {
        q.g(r10, "<set-?>");
        this.f16288m = r10;
    }

    @Override // com.obric.oui.popover.v2.OPopoverBase
    public void setPopoverGravity(int r10) {
        this.f16279d = r10;
    }

    @Override // com.obric.oui.popover.v2.OPopoverBase
    public void setPopoverMaxContentHeight(int r10, View r11, int r12, int r13) {
        OPopoverBase.DefaultImpls.y(this, r10, r11, r12, r13);
    }

    @Override // com.obric.oui.popover.v2.OPopoverBase
    public void setPopoverPopupOriginX(int r10) {
        this.f16294s = r10;
    }

    @Override // com.obric.oui.popover.v2.OPopoverBase
    public void setPopoverPopupOriginY(int r10) {
        this.f16295t = r10;
    }

    @Override // com.obric.oui.popover.v2.OPopoverBase
    public void setPopoverPushedToStack(boolean r10) {
        this.f16298w = r10;
    }

    @Override // com.obric.oui.popover.v2.OPopoverBase
    public void setPopoverRemovedFromStack(boolean r10) {
        this.f16299x = r10;
    }

    @Override // com.obric.oui.popover.v2.OPopoverBase
    public void setPopoverWindowFrame(@NotNull ViewGroup r10) {
        q.g(r10, "<set-?>");
        this.f16289n = r10;
    }

    @Override // com.obric.oui.popover.v2.OPopoverBase
    public void setPopoverXOffset(int r10) {
        this.f16280e = r10;
    }

    @Override // com.obric.oui.popover.v2.OPopoverBase
    public void setPopoverYOffset(int r10) {
        this.f16281f = r10;
    }

    public final void setRemoveOnDismiss(boolean r10) {
        this.f16291p = r10;
    }

    public final void setXOffset(int r10) {
        setXOffsetInternal(r10);
    }

    @Override // com.obric.oui.popover.v2.OPopoverBase
    public void setXOffsetInternal(int r10) {
        OPopoverBase.DefaultImpls.z(this, r10);
    }

    public final void setYOffset(int r10) {
        setYOffsetInternal(r10);
    }

    @Override // com.obric.oui.popover.v2.OPopoverBase
    public void setYOffsetInternal(int r10) {
        OPopoverBase.DefaultImpls.A(this, r10);
    }

    @Override // com.obric.oui.popover.v2.OPopoverBase
    public boolean shouldAnimatePopoverVisibilityInternal() {
        return OPopoverBase.DefaultImpls.B(this);
    }

    @Override // com.obric.oui.popover.v2.OPopoverBase
    public void showPopoverDirectlyInternal(ViewGroup r10, Function0 r11) {
        OPopoverBase.DefaultImpls.C(this, r10, r11);
    }

    @Override // com.obric.oui.popover.v2.OPopoverBase
    public void showPopoverWithoutAnimationInternal() {
        OPopoverBase.DefaultImpls.E(this);
    }

    @Override // com.obric.oui.popover.v2.OPopoverBase
    public AnimatorSet startPopoverVisibilityAnimationInternal(boolean r10, int r11, boolean r12, Animator r13, Function0 r14, Function0 r15) {
        return OPopoverBase.DefaultImpls.F(this, r10, r11, r12, r13, r14, r15);
    }

    @Override // com.obric.oui.popover.v2.OPopoverBase
    public void updatePopoverPivotInternal() {
        OPopoverBase.DefaultImpls.H(this);
    }
}
