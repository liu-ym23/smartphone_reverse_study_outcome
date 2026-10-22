package com.stepos.widget.list;

import B6.a;
import D7.N;
import F6.b;
import F6.c;
import F6.d;
import F6.f;
import F6.g;
import android.R;
import android.animation.AnimatorInflater;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.text.Layout;
import android.text.method.TransformationMethod;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.Checkable;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import androidx.annotation.DrawableRes;
import androidx.annotation.MainThread;
import androidx.annotation.Px;
import androidx.annotation.RestrictTo;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.constraintlayout.widget.Barrier;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.exifinterface.media.ExifInterface;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBindings;
import com.stepos.ability.task.executor.e;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.internal.k;
import w6.AbstractC2104a;
import z6.C2179a;

@Metadata(d1 = {"\u0000\u008a\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\r\n\u0002\b=\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u00012\u00020\u0002:\u000325'J\u0017\u0010\b\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0015\u0010\u000b\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u000b\u0010\fJ\u0015\u0010\r\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\r\u0010\fJ\u0015\u0010\u000e\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u000e\u0010\fJ\u0015\u0010\u000f\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u000f\u0010\fJ\u0015\u0010\u0010\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u0010\u0010\fJ\u0017\u0010\u0013\u001a\u00020\u00052\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011¢\u0006\u0004\b\u0013\u0010\u0014J\u0015\u0010\u0013\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u0013\u0010\fJ\u0015\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u0003¢\u0006\u0004\b\u0016\u0010\u0007J\u0017\u0010\u0019\u001a\u00020\u00052\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017¢\u0006\u0004\b\u0019\u0010\u001aJ\u0017\u0010\u001c\u001a\u00020\u00052\b\b\u0001\u0010\u001b\u001a\u00020\t¢\u0006\u0004\b\u001c\u0010\fJ\u0017\u0010\u001e\u001a\u00020\u00052\b\b\u0001\u0010\u001b\u001a\u00020\u001d¢\u0006\u0004\b\u001e\u0010\u001fJ\u0019\u0010!\u001a\u00020\u00052\n\b\u0001\u0010 \u001a\u0004\u0018\u00010\t¢\u0006\u0004\b!\u0010\"J\u0017\u0010%\u001a\u00020\u00052\b\u0010$\u001a\u0004\u0018\u00010#¢\u0006\u0004\b%\u0010&J\u0017\u0010)\u001a\u00020\u00052\b\u0010(\u001a\u0004\u0018\u00010'¢\u0006\u0004\b)\u0010*J\u0017\u0010+\u001a\u00020\u00052\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011¢\u0006\u0004\b+\u0010\u0014J\u0017\u0010+\u001a\u00020\u00052\b\b\u0001\u0010\n\u001a\u00020\t¢\u0006\u0004\b+\u0010\fJ\u0015\u0010-\u001a\u00020\u00052\u0006\u0010,\u001a\u00020\u0003¢\u0006\u0004\b-\u0010\u0007J\u0017\u0010.\u001a\u00020\u00052\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017¢\u0006\u0004\b.\u0010\u001aJ\u0017\u0010/\u001a\u00020\u00052\b\b\u0001\u0010\u001b\u001a\u00020\t¢\u0006\u0004\b/\u0010\fJ\u0015\u00101\u001a\u00020\u00052\u0006\u00100\u001a\u00020\u0003¢\u0006\u0004\b1\u0010\u0007J\u0017\u00103\u001a\u00020\u00052\b\u0010(\u001a\u0004\u0018\u000102¢\u0006\u0004\b3\u00104J\u0017\u00106\u001a\u00020\u00052\b\u0010(\u001a\u0004\u0018\u000105¢\u0006\u0004\b6\u00107J\u0017\u00109\u001a\u00020\u00052\u0006\u00108\u001a\u00020\u0003H\u0016¢\u0006\u0004\b9\u0010\u0007J\u0017\u0010:\u001a\u00020\u00052\u0006\u00100\u001a\u00020\u0003H\u0016¢\u0006\u0004\b:\u0010\u0007J\u000f\u0010;\u001a\u00020\tH\u0007¢\u0006\u0004\b;\u0010<J\u0017\u0010>\u001a\u00020\u00052\b\b\u0001\u0010=\u001a\u00020\t¢\u0006\u0004\b>\u0010\fJ\u0015\u0010?\u001a\u00020\u00052\u0006\u0010 \u001a\u00020\t¢\u0006\u0004\b?\u0010\fJ\u0017\u0010A\u001a\u00020\u00052\u0006\u0010@\u001a\u00020\u0003H\u0002¢\u0006\u0004\bA\u0010\u0007R$\u0010I\u001a\u0004\u0018\u00010B8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\bC\u0010D\u001a\u0004\bE\u0010F\"\u0004\bG\u0010HR\u001b\u0010O\u001a\u00020J8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bK\u0010L\u001a\u0004\bM\u0010NR*\u0010S\u001a\u00020\u00032\u0006\u0010P\u001a\u00020\u00038G@GX\u0086\u000e¢\u0006\u0012\n\u0004\bQ\u0010R\u001a\u0004\bS\u0010T\"\u0004\bU\u0010\u0007R0\u0010\\\u001a\u00020\t2\u0006\u0010P\u001a\u00020\t8\u0006@FX\u0086\u000e¢\u0006\u0018\n\u0004\bV\u0010W\u0012\u0004\bZ\u0010[\u001a\u0004\bX\u0010<\"\u0004\bY\u0010\fR*\u0010^\u001a\u00020\u00032\u0006\u0010P\u001a\u00020\u00038G@GX\u0086\u000e¢\u0006\u0012\n\u0004\b]\u0010R\u001a\u0004\b^\u0010T\"\u0004\b_\u0010\u0007R\u0011\u0010c\u001a\u00020`8F¢\u0006\u0006\u001a\u0004\ba\u0010bR\u0011\u0010g\u001a\u00020d8F¢\u0006\u0006\u001a\u0004\be\u0010fR\u0011\u0010i\u001a\u00020d8F¢\u0006\u0006\u001a\u0004\bh\u0010fR\u0011\u0010k\u001a\u00020d8F¢\u0006\u0006\u001a\u0004\bj\u0010fR\u0011\u0010m\u001a\u00020d8F¢\u0006\u0006\u001a\u0004\bl\u0010fR\u0011\u0010o\u001a\u00020`8F¢\u0006\u0006\u001a\u0004\bn\u0010bR\u0014\u0010q\u001a\u00020\u00038AX\u0080\u0004¢\u0006\u0006\u001a\u0004\bp\u0010TR(\u0010w\u001a\u0004\u0018\u00010r2\b\u0010s\u001a\u0004\u0018\u00010r8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bt\u0010u\"\u0004\b\u000b\u0010vR(\u0010y\u001a\u0004\u0018\u00010r2\b\u0010s\u001a\u0004\u0018\u00010r8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bx\u0010u\"\u0004\b\r\u0010vR(\u0010{\u001a\u0004\u0018\u00010r2\b\u0010s\u001a\u0004\u0018\u00010r8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bz\u0010u\"\u0004\b\u000e\u0010vR(\u0010}\u001a\u0004\u0018\u00010r2\b\u0010s\u001a\u0004\u0018\u00010r8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b|\u0010u\"\u0004\b\u000f\u0010vR(\u0010\u007f\u001a\u0004\u0018\u00010r2\b\u0010s\u001a\u0004\u0018\u00010r8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b~\u0010u\"\u0004\b\u0010\u0010vR'\u0010\u0082\u0001\u001a\u00020\t2\u0006\u0010P\u001a\u00020\t8F@FX\u0086\u000e¢\u0006\u000e\u001a\u0005\b\u0080\u0001\u0010<\"\u0005\b\u0081\u0001\u0010\fR'\u0010\u0085\u0001\u001a\u00020\t2\u0006\u0010P\u001a\u00020\t8F@FX\u0086\u000e¢\u0006\u000e\u001a\u0005\b\u0083\u0001\u0010<\"\u0005\b\u0084\u0001\u0010\fR'\u0010\u0088\u0001\u001a\u00020\u00032\u0006\u0010s\u001a\u00020\u00038F@FX\u0086\u000e¢\u0006\u000e\u001a\u0005\b\u0086\u0001\u0010T\"\u0005\b\u0087\u0001\u0010\u0007R'\u0010\u008b\u0001\u001a\u00020\u00032\u0006\u0010s\u001a\u00020\u00038F@FX\u0086\u000e¢\u0006\u000e\u001a\u0005\b\u0089\u0001\u0010T\"\u0005\b\u008a\u0001\u0010\u0007R.\u0010\u008f\u0001\u001a\u00020\t2\u0006\u0010s\u001a\u00020\t8F@FX\u0086\u000e¢\u0006\u0015\u0012\u0005\b\u008e\u0001\u0010[\u001a\u0005\b\u008c\u0001\u0010<\"\u0005\b\u008d\u0001\u0010\fR.\u0010\u0093\u0001\u001a\u0004\u0018\u00010\t2\n\b\u0001\u0010s\u001a\u0004\u0018\u00010\t8F@FX\u0086\u000e¢\u0006\u000f\u001a\u0006\b\u0090\u0001\u0010\u0091\u0001\"\u0005\b\u0092\u0001\u0010\"R'\u0010\u0096\u0001\u001a\u00020\u00032\u0006\u0010s\u001a\u00020\u00038F@FX\u0086\u000e¢\u0006\u000e\u001a\u0005\b\u0094\u0001\u0010T\"\u0005\b\u0095\u0001\u0010\u0007R.\u0010\u009a\u0001\u001a\u00020\t2\u0006\u0010s\u001a\u00020\t8F@FX\u0086\u000e¢\u0006\u0015\u0012\u0005\b\u0099\u0001\u0010[\u001a\u0005\b\u0097\u0001\u0010<\"\u0005\b\u0098\u0001\u0010\fR.\u0010\u009d\u0001\u001a\u0004\u0018\u00010\t2\n\b\u0001\u0010s\u001a\u0004\u0018\u00010\t8F@FX\u0086\u000e¢\u0006\u000f\u001a\u0006\b\u009b\u0001\u0010\u0091\u0001\"\u0005\b\u009c\u0001\u0010\"R.\u0010¡\u0001\u001a\u00020\t2\u0006\u0010P\u001a\u00020\t8F@FX\u0086\u000e¢\u0006\u0015\u0012\u0005\b \u0001\u0010[\u001a\u0005\b\u009e\u0001\u0010<\"\u0005\b\u009f\u0001\u0010\fR'\u0010¤\u0001\u001a\u00020\u00032\u0006\u0010P\u001a\u00020\u00038F@FX\u0086\u000e¢\u0006\u000e\u001a\u0005\b¢\u0001\u0010T\"\u0005\b£\u0001\u0010\u0007R'\u0010§\u0001\u001a\u00020\u00032\u0006\u0010s\u001a\u00020\u00038F@FX\u0086\u000e¢\u0006\u000e\u001a\u0005\b¥\u0001\u0010T\"\u0005\b¦\u0001\u0010\u0007R'\u0010ª\u0001\u001a\u00020\u00032\u0006\u0010P\u001a\u00020\u00038F@FX\u0086\u000e¢\u0006\u000e\u001a\u0005\b¨\u0001\u0010T\"\u0005\b©\u0001\u0010\u0007R\u0017\u0010\u00ad\u0001\u001a\u00020#8BX\u0082\u0004¢\u0006\b\u001a\u0006\b«\u0001\u0010¬\u0001R\u0017\u0010¯\u0001\u001a\u00020#8BX\u0082\u0004¢\u0006\b\u001a\u0006\b®\u0001\u0010¬\u0001R\u0018\u0010³\u0001\u001a\u00030°\u00018BX\u0082\u0004¢\u0006\b\u001a\u0006\b±\u0001\u0010²\u0001¨\u0006´\u0001"}, d2 = {"Lcom/stepos/widget/list/StepOSListItem;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Landroid/widget/Checkable;", "", "active", "LC7/r;", "setSwipeAppearanceActive$StepOSWidget_release", "(Z)V", "setSwipeAppearanceActive", "", "resId", "setTitle", "(I)V", "setTitleEndText", "setSubtitle", "setValueText", "setRightText", "Landroid/graphics/drawable/Drawable;", "drawable", "setIcon", "(Landroid/graphics/drawable/Drawable;)V", "visible", "setIconVisible", "Landroid/content/res/ColorStateList;", "tint", "setIconTint", "(Landroid/content/res/ColorStateList;)V", "px", "setIconSize", "", "setIconCornerRadius", "(F)V", TypedValues.Custom.S_COLOR, "setIconBackgroundColor", "(Ljava/lang/Integer;)V", "Landroid/view/View;", "view", "setTrailingView", "(Landroid/view/View;)V", "LF6/g;", "listener", "setOnSwitchCheckedChangeListener", "(LF6/g;)V", "setAccessoryIcon", "show", "setShowAccessory", "setAccessoryTint", "setAccessorySize", "enabled", "setPressScaleEnabled", "LF6/f;", "setOnItemClickListener", "(LF6/f;)V", "LF6/e;", "setOnCheckedChangeListener", "(LF6/e;)V", "checked", "setChecked", "setEnabled", "getDividerInsetStart", "()I", "insetStart", "setDividerInsetStart", "setDividerColor", "hidden", "setNeighborBelowHidesDivider", "", "u", "Ljava/lang/Object;", "getSwitchHapticFeedbackOwner$StepOSWidget_release", "()Ljava/lang/Object;", "setSwitchHapticFeedbackOwner$StepOSWidget_release", "(Ljava/lang/Object;)V", "switchHapticFeedbackOwner", "Landroid/graphics/Paint;", "U", "LC7/f;", "getSwipeOverlayPaint", "()Landroid/graphics/Paint;", "swipeOverlayPaint", "value", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "Z", "isAdaptiveTextLayoutEnabled", "()Z", "setAdaptiveTextLayoutEnabled", ExifInterface.LONGITUDE_WEST, "I", "getIconStyle", "setIconStyle", "getIconStyle$annotations", "()V", "iconStyle", "a0", "isSwitchHapticFeedbackEnabled", "setSwitchHapticFeedbackEnabled", "Landroid/widget/ImageView;", "getIconView", "()Landroid/widget/ImageView;", "iconView", "Landroid/widget/TextView;", "getTitleView", "()Landroid/widget/TextView;", "titleView", "getTitleEndView", "titleEndView", "getSubtitleView", "subtitleView", "getValueView", "valueView", "getAccessoryView", "accessoryView", "getHidesAdjacentDividers$StepOSWidget_release", "hidesAdjacentDividers", "", "v", "getTitle", "()Ljava/lang/CharSequence;", "(Ljava/lang/CharSequence;)V", "title", "getTitleEndText", "titleEndText", "getSubtitle", "subtitle", "getValueText", "valueText", "getRightText", "rightText", "getLineMode", "setLineMode", "lineMode", "getTitleStyle", "setTitleStyle", "titleStyle", "getShowIcon", "setShowIcon", "showIcon", "getShowBadge", "setShowBadge", "showBadge", "getBadgeStyle", "setBadgeStyle", "getBadgeStyle$annotations", "badgeStyle", "getBadgeTint", "()Ljava/lang/Integer;", "setBadgeTint", "badgeTint", "getShowRightBadge", "setShowRightBadge", "showRightBadge", "getRightBadgeStyle", "setRightBadgeStyle", "getRightBadgeStyle$annotations", "rightBadgeStyle", "getRightBadgeTint", "setRightBadgeTint", "rightBadgeTint", "getTrailingType", "setTrailingType", "getTrailingType$annotations", "trailingType", "getReservesCheckSlot", "setReservesCheckSlot", "reservesCheckSlot", "getSwitchChecked", "setSwitchChecked", "switchChecked", "getPressFeedbackEnabled", "setPressFeedbackEnabled", "pressFeedbackEnabled", "getBadgeView", "()Landroid/view/View;", "badgeView", "getRightBadgeView", "rightBadgeView", "Landroid/widget/FrameLayout;", "getTrailingContainer", "()Landroid/widget/FrameLayout;", "trailingContainer", "StepOSWidget_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public class StepOSListItem extends ConstraintLayout implements Checkable {
    public static final int[] b0 = {R.attr.state_checked};

    /* renamed from: A, reason: collision with root package name */
    public Integer f4111A;

    /* renamed from: B, reason: collision with root package name */
    public boolean f4112B;

    /* renamed from: C, reason: collision with root package name */
    public int f4113C;

    /* renamed from: D, reason: collision with root package name */
    public Integer f4114D;
    public int E;

    /* renamed from: F, reason: collision with root package name */
    public boolean f4115F;

    /* renamed from: G, reason: collision with root package name */
    public int f4116G;

    /* renamed from: L, reason: collision with root package name */
    public int f4117L;

    /* renamed from: M, reason: collision with root package name */
    public CharSequence f4118M;

    /* renamed from: N, reason: collision with root package name */
    public int f4119N;

    /* renamed from: O, reason: collision with root package name */
    public ColorStateList f4120O;

    /* renamed from: P, reason: collision with root package name */
    public boolean f4121P;

    /* renamed from: Q, reason: collision with root package name */
    public final a f4122Q;

    /* renamed from: R, reason: collision with root package name */
    public boolean f4123R;

    /* renamed from: S, reason: collision with root package name */
    public boolean f4124S;

    /* renamed from: T, reason: collision with root package name */
    public boolean f4125T;

    /* renamed from: U, reason: collision with root package name */
    public final Object f4126U;

    /* renamed from: V, reason: collision with root package name and from kotlin metadata */
    public boolean isAdaptiveTextLayoutEnabled;

    /* renamed from: W, reason: collision with root package name and from kotlin metadata */
    public int iconStyle;

    /* renamed from: a, reason: collision with root package name */
    public final C2179a f4129a;

    /* renamed from: a0, reason: collision with root package name and from kotlin metadata */
    public boolean isSwitchHapticFeedbackEnabled;
    public int b;
    public int c;
    public int d;
    public int e;
    public f f;
    public g g;
    public boolean h;
    public boolean i;

    /* renamed from: j, reason: collision with root package name */
    public float[] f4131j;
    public int k;
    public boolean l;
    public float m;
    public Integer n;
    public boolean o;
    public boolean p;

    /* renamed from: q, reason: collision with root package name */
    public Integer f4132q;

    /* renamed from: r, reason: collision with root package name */
    public boolean f4133r;

    /* renamed from: s, reason: collision with root package name */
    public boolean f4134s;

    /* renamed from: t, reason: collision with root package name */
    public L6.a f4135t;

    /* renamed from: u, reason: from kotlin metadata */
    public Object switchHapticFeedbackOwner;

    /* renamed from: v, reason: collision with root package name */
    public TextView f4136v;

    /* renamed from: w, reason: collision with root package name */
    public View f4137w;

    /* renamed from: x, reason: collision with root package name */
    public ImageView f4138x;
    public boolean y;

    /* renamed from: z, reason: collision with root package name */
    public int f4139z;

    /* JADX WARN: Illegal instructions before constructor call */
    public StepOSListItem(Context context, AttributeSet attributeSet) {
        k.f(context, "context");
        AttributeSet attributeSet2 = (4 & 2) != 0 ? null : attributeSet;
        super(context, attributeSet2, com.stepos.ability.R.attr.steposListItemStyle);
        LayoutInflater.from(context).inflate(com.stepos.ability.R.layout.stepos_list_item, this);
        int i = com.stepos.ability.R.id.stepos_list_item_accessory;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(this, com.stepos.ability.R.id.stepos_list_item_accessory);
        if (imageView != null) {
            i = com.stepos.ability.R.id.stepos_list_item_badge;
            View viewFindChildViewById = ViewBindings.findChildViewById(this, com.stepos.ability.R.id.stepos_list_item_badge);
            if (viewFindChildViewById != null) {
                i = com.stepos.ability.R.id.stepos_list_item_leading_icon;
                ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(this, com.stepos.ability.R.id.stepos_list_item_leading_icon);
                if (imageView2 != null) {
                    i = com.stepos.ability.R.id.stepos_list_item_right_badge;
                    View viewFindChildViewById2 = ViewBindings.findChildViewById(this, com.stepos.ability.R.id.stepos_list_item_right_badge);
                    if (viewFindChildViewById2 != null) {
                        i = com.stepos.ability.R.id.stepos_list_item_subtitle;
                        TextView textView = (TextView) ViewBindings.findChildViewById(this, com.stepos.ability.R.id.stepos_list_item_subtitle);
                        if (textView != null) {
                            i = com.stepos.ability.R.id.stepos_list_item_title;
                            TextView textView2 = (TextView) ViewBindings.findChildViewById(this, com.stepos.ability.R.id.stepos_list_item_title);
                            if (textView2 != null) {
                                i = com.stepos.ability.R.id.stepos_list_item_title_end;
                                TextView textView3 = (TextView) ViewBindings.findChildViewById(this, com.stepos.ability.R.id.stepos_list_item_title_end);
                                if (textView3 != null) {
                                    i = com.stepos.ability.R.id.stepos_list_item_trailing;
                                    FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(this, com.stepos.ability.R.id.stepos_list_item_trailing);
                                    if (frameLayout != null) {
                                        i = com.stepos.ability.R.id.stepos_list_item_trailing_barrier;
                                        Barrier barrier = (Barrier) ViewBindings.findChildViewById(this, com.stepos.ability.R.id.stepos_list_item_trailing_barrier);
                                        if (barrier != null) {
                                            i = com.stepos.ability.R.id.stepos_list_item_value;
                                            TextView textView4 = (TextView) ViewBindings.findChildViewById(this, com.stepos.ability.R.id.stepos_list_item_value);
                                            if (textView4 != null) {
                                                this.f4129a = new C2179a(this, imageView, viewFindChildViewById, imageView2, viewFindChildViewById2, textView, textView2, textView3, frameLayout, barrier, textView4);
                                                this.h = true;
                                                this.i = true;
                                                this.o = true;
                                                this.p = true;
                                                this.f4133r = true;
                                                this.f4113C = 1;
                                                this.f4116G = 1;
                                                this.f4117L = 1;
                                                this.f4122Q = new a();
                                                this.f4126U = kotlin.a.b(LazyThreadSafetyMode.c, new c(context, 0));
                                                TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet2, AbstractC2104a.f, com.stepos.ability.R.attr.steposListItemStyle, com.stepos.ability.R.style.StepOSWidget_ListItem);
                                                try {
                                                    k.c(typedArrayObtainStyledAttributes);
                                                    h(this, typedArrayObtainStyledAttributes);
                                                    e.s(typedArrayObtainStyledAttributes, null);
                                                    return;
                                                } finally {
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(getResources().getResourceName(i)));
    }

    public static /* synthetic */ void getBadgeStyle$annotations() {
    }

    private final View getBadgeView() {
        View steposListItemBadge = this.f4129a.c;
        k.e(steposListItemBadge, "steposListItemBadge");
        return steposListItemBadge;
    }

    public static /* synthetic */ void getIconStyle$annotations() {
    }

    public static final b getImageLoader() {
        return null;
    }

    public static /* synthetic */ void getRightBadgeStyle$annotations() {
    }

    private final View getRightBadgeView() {
        View steposListItemRightBadge = this.f4129a.e;
        k.e(steposListItemRightBadge, "steposListItemRightBadge");
        return steposListItemRightBadge;
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [C7.f, java.lang.Object] */
    private final Paint getSwipeOverlayPaint() {
        return (Paint) this.f4126U.getF4884a();
    }

    private final FrameLayout getTrailingContainer() {
        FrameLayout steposListItemTrailing = this.f4129a.i;
        k.e(steposListItemTrailing, "steposListItemTrailing");
        return steposListItemTrailing;
    }

    public static /* synthetic */ void getTrailingType$annotations() {
    }

    public static void h(StepOSListItem stepOSListItem, TypedArray typedArray) {
        CharSequence charSequence;
        a aVar = stepOSListItem.f4122Q;
        Resources resources = stepOSListItem.getResources();
        int dimensionPixelSize = typedArray.getDimensionPixelSize(23, resources.getDimensionPixelSize(com.stepos.ability.R.dimen.stepos_list_item_height));
        int dimensionPixelSize2 = typedArray.getDimensionPixelSize(24, resources.getDimensionPixelSize(com.stepos.ability.R.dimen.stepos_list_item_padding_start));
        int dimensionPixelSize3 = typedArray.getDimensionPixelSize(25, resources.getDimensionPixelSize(com.stepos.ability.R.dimen.stepos_list_item_padding_vertical));
        int dimensionPixelSize4 = typedArray.getDimensionPixelSize(19, resources.getDimensionPixelSize(com.stepos.ability.R.dimen.stepos_list_item_icon_text_gap));
        stepOSListItem.c = typedArray.getDimensionPixelSize(45, resources.getDimensionPixelSize(com.stepos.ability.R.dimen.stepos_list_item_value_gap));
        stepOSListItem.d = resources.getDimensionPixelSize(com.stepos.ability.R.dimen.stepos_list_item_content_gap);
        stepOSListItem.b = dimensionPixelSize4;
        int resourceId = typedArray.getResourceId(42, 0);
        if (resourceId != 0) {
            stepOSListItem.getTitleView().setTextAppearance(resourceId);
        }
        stepOSListItem.f4120O = stepOSListItem.getTitleView().getTextColors();
        int resourceId2 = typedArray.getResourceId(37, 0);
        if (resourceId2 != 0) {
            stepOSListItem.getSubtitleView().setTextAppearance(resourceId2);
        }
        int resourceId3 = typedArray.getResourceId(46, 0);
        if (resourceId3 != 0) {
            stepOSListItem.getValueView().setTextAppearance(resourceId3);
        }
        int i = typedArray.getInt(36, 1);
        TextView subtitleView = stepOSListItem.getSubtitleView();
        if (i < 1) {
            i = 1;
        }
        subtitleView.setMaxLines(i);
        stepOSListItem.setAdaptiveTextLayoutEnabled(typedArray.getBoolean(3, false));
        stepOSListItem.setTitle(typedArray.getText(39));
        stepOSListItem.setTitleEndText(typedArray.getText(40));
        stepOSListItem.setSubtitle(typedArray.getText(35));
        CharSequence text = typedArray.getText(30);
        if (text == null) {
            text = typedArray.getText(44);
        }
        stepOSListItem.setValueText(text);
        stepOSListItem.n = typedArray.hasValue(15) ? Integer.valueOf(typedArray.getColor(15, 0)) : null;
        Drawable drawable = typedArray.getDrawable(14);
        if (drawable != null) {
            stepOSListItem.getIconView().setImageDrawable(drawable);
        }
        if (typedArray.hasValue(20)) {
            stepOSListItem.getIconView().setImageTintList(typedArray.getColorStateList(20));
        }
        stepOSListItem.f4133r = typedArray.getBoolean(21, true);
        stepOSListItem.setIconStyle(typedArray.getInt(18, 0));
        if (typedArray.hasValue(17)) {
            stepOSListItem.setIconSize(typedArray.getDimensionPixelSize(17, 0));
        }
        if (typedArray.hasValue(16)) {
            stepOSListItem.setIconCornerRadius(typedArray.getDimension(16, 0.0f));
        }
        stepOSListItem.f4139z = typedArray.getInt(4, 0);
        if (typedArray.hasValue(5)) {
            stepOSListItem.f4111A = Integer.valueOf(typedArray.getColor(5, 0));
        }
        stepOSListItem.y = typedArray.getBoolean(32, false);
        stepOSListItem.f4113C = typedArray.getInt(27, 1);
        if (typedArray.hasValue(28)) {
            stepOSListItem.f4114D = Integer.valueOf(typedArray.getColor(28, 0));
        }
        stepOSListItem.f4112B = typedArray.getBoolean(34, false);
        stepOSListItem.o = typedArray.getBoolean(31, true);
        Drawable drawable2 = typedArray.getDrawable(29);
        if (drawable2 == null) {
            drawable2 = typedArray.getDrawable(0);
        }
        int resourceId4 = typedArray.getResourceId(29, 0);
        Integer numValueOf = Integer.valueOf(resourceId4);
        if (resourceId4 == 0) {
            numValueOf = null;
        }
        stepOSListItem.p = drawable2 == null || (numValueOf != null ? numValueOf.intValue() : typedArray.getResourceId(0, com.stepos.ability.R.drawable.stepos_icon_arrow_right)) == com.stepos.ability.R.drawable.stepos_icon_arrow_right;
        ImageView accessoryView = stepOSListItem.getAccessoryView();
        if (drawable2 == null) {
            drawable2 = AppCompatResources.getDrawable(stepOSListItem.getContext(), com.stepos.ability.R.drawable.stepos_icon_arrow_right);
        }
        accessoryView.setImageDrawable(drawable2);
        if (typedArray.hasValue(2)) {
            stepOSListItem.getAccessoryView().setImageTintList(typedArray.getColorStateList(2));
        }
        stepOSListItem.f4132q = typedArray.hasValue(1) ? Integer.valueOf(typedArray.getDimensionPixelSize(1, 0)) : null;
        stepOSListItem.a();
        stepOSListItem.f4117L = typedArray.getInt(43, 1);
        CharSequence text2 = typedArray.getText(6);
        if (text2 != null) {
            stepOSListItem.f4118M = text2;
        }
        stepOSListItem.E = typedArray.getInt(22, 0);
        stepOSListItem.f4119N = typedArray.getInt(41, 0);
        boolean z10 = typedArray.getBoolean(7, false);
        stepOSListItem.setSwitchChecked(typedArray.getBoolean(38, false));
        stepOSListItem.h = typedArray.getBoolean(26, false);
        Drawable drawable3 = typedArray.hasValue(13) ? typedArray.getDrawable(13) : null;
        stepOSListItem.f4121P = typedArray.getBoolean(33, false);
        aVar.f195a = typedArray.getDimensionPixelSize(10, resources.getDimensionPixelSize(com.stepos.ability.R.dimen.stepos_divider_height));
        aVar.c = typedArray.getDimensionPixelSize(12, resources.getDimensionPixelSize(com.stepos.ability.R.dimen.stepos_divider_inset_start));
        aVar.d = typedArray.getDimensionPixelSize(11, resources.getDimensionPixelSize(com.stepos.ability.R.dimen.stepos_divider_inset_end));
        aVar.b = typedArray.getColor(9, stepOSListItem.getContext().getColor(com.stepos.ability.R.color.stepos_divider));
        stepOSListItem.setPaddingRelative(dimensionPixelSize2, dimensionPixelSize3, dimensionPixelSize2, dimensionPixelSize3);
        stepOSListItem.e = dimensionPixelSize3;
        stepOSListItem.setMinimumHeight(dimensionPixelSize);
        stepOSListItem.setClipChildren(false);
        stepOSListItem.e();
        stepOSListItem.w();
        stepOSListItem.setBackground(AppCompatResources.getDrawable(stepOSListItem.getContext(), com.stepos.ability.R.drawable.stepos_bg_list_item_selector));
        stepOSListItem.setForeground(drawable3);
        stepOSListItem.setStateListAnimator(stepOSListItem.h ? AnimatorInflater.loadStateListAnimator(stepOSListItem.getContext(), com.stepos.ability.R.animator.stepos_list_item_press) : null);
        stepOSListItem.c();
        stepOSListItem.f();
        stepOSListItem.setLineMode(stepOSListItem.E);
        stepOSListItem.i();
        stepOSListItem.setTrailingType(stepOSListItem.f4117L);
        if (stepOSListItem.f4117L == 3 && (charSequence = stepOSListItem.f4118M) != null) {
            stepOSListItem.f4118M = charSequence;
            TextView textViewN = stepOSListItem.n();
            textViewN.setText(charSequence);
            textViewN.setOnClickListener(null);
            stepOSListItem.setTrailingType(3);
        }
        stepOSListItem.setChecked(z10);
    }

    public static int m(TextView textView) {
        CharSequence text;
        if (textView.getVisibility() == 8) {
            return 0;
        }
        TransformationMethod transformationMethod = textView.getTransformationMethod();
        if (transformationMethod == null || (text = transformationMethod.getTransformation(textView.getText(), textView)) == null) {
            text = textView.getText();
        }
        return textView.getCompoundPaddingEnd() + textView.getCompoundPaddingStart() + ((int) Math.ceil(Layout.getDesiredWidth(text, textView.getPaint())));
    }

    public static final int q(StepOSListItem stepOSListItem, int i, int i6, View view) {
        if (view.getVisibility() == 8) {
            return 0;
        }
        boolean zIsLayoutRequested = view.isLayoutRequested();
        stepOSListItem.measureChildWithMargins(view, i, 0, i6, 0);
        if (zIsLayoutRequested) {
            view.forceLayout();
        }
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        k.d(layoutParams, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) layoutParams;
        return layoutParams2.getMarginEnd() + layoutParams2.getMarginStart() + view.getMeasuredWidth();
    }

    public static final void setImageLoader(b bVar) {
    }

    private final void setNeighborBelowHidesDivider(boolean hidden) {
        if (this.f4123R == hidden) {
            return;
        }
        this.f4123R = hidden;
        invalidate();
    }

    public static void t(StepOSListItem stepOSListItem, boolean z10) {
        a aVar = stepOSListItem.f4122Q;
        int dividerInsetStart = aVar.c;
        int i = aVar.d;
        stepOSListItem.f4121P = z10;
        aVar.d = i;
        if (z10) {
            dividerInsetStart = stepOSListItem.getDividerInsetStart();
        }
        aVar.c = dividerInsetStart;
        stepOSListItem.invalidate();
    }

    public static void u(ImageView imageView, int i, int i6) {
        ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
        if (layoutParams == null) {
            return;
        }
        layoutParams.width = i;
        layoutParams.height = i6;
        imageView.setLayoutParams(layoutParams);
    }

    public static void v(TextView textView, int i) {
        ViewGroup.LayoutParams layoutParams = textView.getLayoutParams();
        k.d(layoutParams, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) layoutParams;
        if (layoutParams2.getMarginEnd() == i && layoutParams2.goneEndMargin == i) {
            return;
        }
        layoutParams2.setMarginEnd(i);
        layoutParams2.goneEndMargin = i;
        textView.setLayoutParams(layoutParams2);
    }

    public final void a() {
        Integer num = this.f4132q;
        int iIntValue = num != null ? num.intValue() : getResources().getDimensionPixelSize(com.stepos.ability.R.dimen.stepos_list_item_accessory_size);
        int dimensionPixelSize = (this.p && this.f4132q == null) ? getResources().getDimensionPixelSize(com.stepos.ability.R.dimen.stepos_list_item_arrow_width) : iIntValue;
        getAccessoryView().setScaleType(ImageView.ScaleType.FIT_CENTER);
        ViewGroup.LayoutParams layoutParams = getAccessoryView().getLayoutParams();
        if (layoutParams.width == dimensionPixelSize && layoutParams.height == iIntValue) {
            return;
        }
        layoutParams.width = dimensionPixelSize;
        layoutParams.height = iIntValue;
        getAccessoryView().setLayoutParams(layoutParams);
    }

    public final void b(View view, boolean z10, int i, Integer num) {
        int color;
        if (!z10) {
            view.setVisibility(8);
            return;
        }
        if (num != null) {
            color = num.intValue();
        } else {
            color = getContext().getColor(i == 1 ? com.stepos.ability.R.color.stepos_list_item_badge_red : com.stepos.ability.R.color.stepos_list_item_badge_blue);
        }
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(1);
        gradientDrawable.setColor(color);
        view.setBackground(gradientDrawable);
        view.setImportantForAccessibility(2);
        view.setVisibility(0);
    }

    public final void c() {
        b(getBadgeView(), this.y, this.f4139z, this.f4111A);
        b(getRightBadgeView(), this.f4112B, this.f4113C, this.f4114D);
        f();
        j();
        r();
    }

    public final void d(float[] fArr, int i, boolean z10, int i6, int i10) {
        setPressScaleEnabled(false);
        this.f4131j = (float[]) fArr.clone();
        this.k = i;
        Context context = getContext();
        k.e(context, "getContext(...)");
        setBackground(N.n(context, fArr, i, this.i));
        setForeground(null);
        t(this, z10);
        setPaddingRelative(getPaddingStart(), this.e + i6, getPaddingEnd(), this.e + i10);
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup, android.view.View
    public final void dispatchDraw(Canvas canvas) {
        Canvas canvas2;
        k.f(canvas, "canvas");
        if (this.f4125T && isEnabled()) {
            canvas2 = canvas;
            canvas2.drawRect(0.0f, 0.0f, getWidth(), getHeight(), getSwipeOverlayPaint());
        } else {
            canvas2 = canvas;
        }
        super.dispatchDraw(canvas2);
        if (!this.f4121P || getHidesAdjacentDividers$StepOSWidget_release() || this.f4123R) {
            return;
        }
        int height = getHeight();
        a.a(this.f4122Q, canvas2, height - r0.f195a, getWidth(), getLayoutDirection());
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void drawableStateChanged() {
        super.drawableStateChanged();
        boolean zIsPressed = isPressed();
        if (zIsPressed == this.f4124S) {
            return;
        }
        this.f4124S = zIsPressed;
        p();
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x005b, code lost:
    
        if (r5.m >= ((java.lang.Math.min(r3, r0) / 2.0f) - 0.5f)) goto L18;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void e() {
        /*
            r5 = this;
            java.lang.Integer r0 = r5.n
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L32
            android.widget.ImageView r3 = r5.getIconView()
            android.graphics.drawable.GradientDrawable r4 = new android.graphics.drawable.GradientDrawable
            r4.<init>()
            r4.setShape(r2)
            float r2 = r5.m
            r4.setCornerRadius(r2)
            int r0 = r0.intValue()
            r4.setColor(r0)
            r3.setBackground(r4)
            android.widget.ImageView r0 = r5.getIconView()
            r0.setClipToOutline(r1)
            android.widget.ImageView r5 = r5.getIconView()
            android.widget.ImageView$ScaleType r0 = android.widget.ImageView.ScaleType.CENTER_CROP
            r5.setScaleType(r0)
            return
        L32:
            int r0 = r5.iconStyle
            r3 = 3
            if (r0 != r3) goto L38
            goto L5d
        L38:
            android.widget.ImageView r0 = r5.getIconView()
            android.view.ViewGroup$LayoutParams r0 = r0.getLayoutParams()
            if (r0 != 0) goto L43
            goto L85
        L43:
            int r3 = r0.width
            int r0 = r0.height
            if (r3 <= 0) goto L85
            if (r0 > 0) goto L4c
            goto L85
        L4c:
            float r4 = r5.m
            int r0 = java.lang.Math.min(r3, r0)
            float r0 = (float) r0
            r3 = 1073741824(0x40000000, float:2.0)
            float r0 = r0 / r3
            r3 = 1056964608(0x3f000000, float:0.5)
            float r0 = r0 - r3
            int r0 = (r4 > r0 ? 1 : (r4 == r0 ? 0 : -1))
            if (r0 < 0) goto L85
        L5d:
            android.widget.ImageView r0 = r5.getIconView()
            android.graphics.drawable.GradientDrawable r3 = new android.graphics.drawable.GradientDrawable
            r3.<init>()
            r3.setShape(r2)
            float r4 = r5.m
            r3.setCornerRadius(r4)
            r3.setColor(r2)
            r0.setBackground(r3)
            android.widget.ImageView r0 = r5.getIconView()
            r0.setClipToOutline(r1)
            android.widget.ImageView r5 = r5.getIconView()
            android.widget.ImageView$ScaleType r0 = android.widget.ImageView.ScaleType.CENTER_CROP
            r5.setScaleType(r0)
            return
        L85:
            int r0 = r5.iconStyle
            r3 = 4
            if (r0 == r3) goto La7
            r3 = 5
            if (r0 != r3) goto L8e
            goto La7
        L8e:
            android.widget.ImageView r0 = r5.getIconView()
            r1 = 0
            r0.setBackground(r1)
            android.widget.ImageView r0 = r5.getIconView()
            r0.setClipToOutline(r2)
            android.widget.ImageView r5 = r5.getIconView()
            android.widget.ImageView$ScaleType r0 = android.widget.ImageView.ScaleType.FIT_CENTER
            r5.setScaleType(r0)
            return
        La7:
            android.widget.ImageView r0 = r5.getIconView()
            android.graphics.drawable.GradientDrawable r3 = new android.graphics.drawable.GradientDrawable
            r3.<init>()
            r3.setShape(r2)
            float r4 = r5.m
            r3.setCornerRadius(r4)
            r3.setColor(r2)
            r0.setBackground(r3)
            android.widget.ImageView r0 = r5.getIconView()
            r0.setClipToOutline(r1)
            android.widget.ImageView r5 = r5.getIconView()
            android.widget.ImageView$ScaleType r0 = android.widget.ImageView.ScaleType.CENTER_CROP
            r5.setScaleType(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.widget.list.StepOSListItem.e():void");
    }

    public final void f() {
        boolean z10 = getBadgeView().getVisibility() == 0;
        boolean z11 = getIconView().getVisibility() == 0;
        ViewGroup.LayoutParams layoutParams = getBadgeView().getLayoutParams();
        k.d(layoutParams, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) layoutParams;
        layoutParams2.setMarginEnd((z10 && z11) ? this.b : 0);
        getBadgeView().setLayoutParams(layoutParams2);
        ViewGroup.LayoutParams layoutParams3 = getTitleView().getLayoutParams();
        k.d(layoutParams3, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        ConstraintLayout.LayoutParams layoutParams4 = (ConstraintLayout.LayoutParams) layoutParams3;
        if (z11) {
            layoutParams4.startToEnd = getIconView().getId();
            layoutParams4.startToStart = -1;
            layoutParams4.setMarginStart(this.b);
        } else if (z10) {
            layoutParams4.startToEnd = getBadgeView().getId();
            layoutParams4.startToStart = -1;
            layoutParams4.setMarginStart(this.b);
        } else {
            layoutParams4.startToEnd = -1;
            layoutParams4.startToStart = 0;
            layoutParams4.setMarginStart(0);
        }
        getTitleView().setLayoutParams(layoutParams4);
    }

    public final void g() {
        CharSequence text = getSubtitleView().getText();
        TextView subtitleView = getSubtitleView();
        int i = this.E;
        int i6 = 8;
        if (i != 1 && (i == 2 || (text != null && text.length() != 0))) {
            i6 = 0;
        }
        subtitleView.setVisibility(i6);
    }

    public final ImageView getAccessoryView() {
        ImageView steposListItemAccessory = this.f4129a.b;
        k.e(steposListItemAccessory, "steposListItemAccessory");
        return steposListItemAccessory;
    }

    /* renamed from: getBadgeStyle, reason: from getter */
    public final int getF4139z() {
        return this.f4139z;
    }

    /* renamed from: getBadgeTint, reason: from getter */
    public final Integer getF4111A() {
        return this.f4111A;
    }

    @Px
    public final int getDividerInsetStart() {
        int paddingStart = getPaddingStart();
        int dimensionPixelSize = getBadgeView().getVisibility() == 0 ? getResources().getDimensionPixelSize(com.stepos.ability.R.dimen.stepos_list_item_badge_size) + this.b : 0;
        if (getIconView().getVisibility() == 0) {
            int i = getIconView().getLayoutParams().width;
            dimensionPixelSize = dimensionPixelSize + (i >= 0 ? i : 0) + this.b;
        }
        return paddingStart + dimensionPixelSize;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public final boolean getHidesAdjacentDividers$StepOSWidget_release() {
        if (this.f4125T) {
            return true;
        }
        return this.i && isPressed();
    }

    public final int getIconStyle() {
        return this.iconStyle;
    }

    public final ImageView getIconView() {
        ImageView steposListItemLeadingIcon = this.f4129a.d;
        k.e(steposListItemLeadingIcon, "steposListItemLeadingIcon");
        return steposListItemLeadingIcon;
    }

    /* renamed from: getLineMode, reason: from getter */
    public final int getE() {
        return this.E;
    }

    /* renamed from: getPressFeedbackEnabled, reason: from getter */
    public final boolean getI() {
        return this.i;
    }

    /* renamed from: getReservesCheckSlot, reason: from getter */
    public final boolean getL() {
        return this.l;
    }

    /* renamed from: getRightBadgeStyle, reason: from getter */
    public final int getF4113C() {
        return this.f4113C;
    }

    /* renamed from: getRightBadgeTint, reason: from getter */
    public final Integer getF4114D() {
        return this.f4114D;
    }

    public final CharSequence getRightText() {
        return getValueText();
    }

    /* renamed from: getShowBadge, reason: from getter */
    public final boolean getY() {
        return this.y;
    }

    /* renamed from: getShowIcon, reason: from getter */
    public final boolean getF4133r() {
        return this.f4133r;
    }

    /* renamed from: getShowRightBadge, reason: from getter */
    public final boolean getF4112B() {
        return this.f4112B;
    }

    public final CharSequence getSubtitle() {
        return getSubtitleView().getText();
    }

    public final TextView getSubtitleView() {
        TextView steposListItemSubtitle = this.f4129a.f;
        k.e(steposListItemSubtitle, "steposListItemSubtitle");
        return steposListItemSubtitle;
    }

    public final boolean getSwitchChecked() {
        L6.a aVar = this.f4135t;
        if (aVar != null) {
            return aVar.isChecked();
        }
        return false;
    }

    /* renamed from: getSwitchHapticFeedbackOwner$StepOSWidget_release, reason: from getter */
    public final Object getSwitchHapticFeedbackOwner() {
        return this.switchHapticFeedbackOwner;
    }

    public final CharSequence getTitle() {
        return getTitleView().getText();
    }

    public final CharSequence getTitleEndText() {
        return getTitleEndView().getText();
    }

    public final TextView getTitleEndView() {
        TextView steposListItemTitleEnd = this.f4129a.h;
        k.e(steposListItemTitleEnd, "steposListItemTitleEnd");
        return steposListItemTitleEnd;
    }

    /* renamed from: getTitleStyle, reason: from getter */
    public final int getF4119N() {
        return this.f4119N;
    }

    public final TextView getTitleView() {
        TextView steposListItemTitle = this.f4129a.g;
        k.e(steposListItemTitle, "steposListItemTitle");
        return steposListItemTitle;
    }

    /* renamed from: getTrailingType, reason: from getter */
    public final int getF4117L() {
        return this.f4117L;
    }

    public final CharSequence getValueText() {
        return getValueView().getText();
    }

    public final TextView getValueView() {
        TextView steposListItemValue = this.f4129a.k;
        k.e(steposListItemValue, "steposListItemValue");
        return steposListItemValue;
    }

    public final void i() {
        if (this.f4119N == 1) {
            getTitleView().setTextColor(getContext().getColor(com.stepos.ability.R.color.stepos_list_item_title_link));
            return;
        }
        ColorStateList colorStateList = this.f4120O;
        if (colorStateList != null) {
            getTitleView().setTextColor(colorStateList);
        }
    }

    @Override // android.widget.Checkable
    public final boolean isChecked() {
        return this.f4134s;
    }

    public final void j() {
        boolean z10 = getRightBadgeView().getVisibility() == 0;
        boolean z11 = getTrailingContainer().getVisibility() == 0;
        ViewGroup.LayoutParams layoutParams = getValueView().getLayoutParams();
        k.d(layoutParams, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) layoutParams;
        if (z10) {
            layoutParams2.endToStart = getRightBadgeView().getId();
            layoutParams2.endToEnd = -1;
            layoutParams2.setMarginEnd(this.c);
        } else if (z11) {
            layoutParams2.endToStart = getTrailingContainer().getId();
            layoutParams2.endToEnd = -1;
            layoutParams2.setMarginEnd(this.d);
        } else {
            layoutParams2.endToStart = -1;
            layoutParams2.endToEnd = 0;
            layoutParams2.setMarginEnd(0);
        }
        getValueView().setLayoutParams(layoutParams2);
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void k(int r12) throws android.content.res.Resources.NotFoundException {
        /*
            Method dump skipped, instructions count: 296
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.widget.list.StepOSListItem.k(int):void");
    }

    public final void l(boolean z10) {
        if (this.f4115F == z10) {
            return;
        }
        this.f4115F = z10;
        Barrier steposListItemTrailingBarrier = this.f4129a.f6973j;
        k.e(steposListItemTrailingBarrier, "steposListItemTrailingBarrier");
        steposListItemTrailingBarrier.setReferencedIds(z10 ? new int[]{getRightBadgeView().getId(), getTrailingContainer().getId()} : new int[]{getValueView().getId(), getRightBadgeView().getId(), getTrailingContainer().getId()});
        ViewGroup.LayoutParams layoutParams = getSubtitleView().getLayoutParams();
        k.d(layoutParams, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) layoutParams;
        layoutParams2.bottomToBottom = z10 ? -1 : 0;
        layoutParams2.bottomToTop = z10 ? getValueView().getId() : -1;
        getSubtitleView().setLayoutParams(layoutParams2);
        ViewGroup.LayoutParams layoutParams3 = getValueView().getLayoutParams();
        k.d(layoutParams3, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        ConstraintLayout.LayoutParams layoutParams4 = (ConstraintLayout.LayoutParams) layoutParams3;
        ((ViewGroup.MarginLayoutParams) layoutParams4).width = z10 ? 0 : -2;
        layoutParams4.startToStart = z10 ? getTitleView().getId() : -1;
        layoutParams4.topToTop = z10 ? -1 : 0;
        layoutParams4.topToBottom = z10 ? getSubtitleView().getId() : -1;
        ((ViewGroup.MarginLayoutParams) layoutParams4).topMargin = z10 ? getResources().getDimensionPixelSize(com.stepos.ability.R.dimen.stepos_list_item_title_subtitle_gap) : 0;
        getValueView().setLayoutParams(layoutParams4);
        if (!z10) {
            getValueView().setMaxLines(this.f4116G);
        } else {
            this.f4116G = getValueView().getMaxLines();
            getValueView().setMaxLines(2);
        }
    }

    public final TextView n() {
        TextView textView = this.f4136v;
        if (textView != null) {
            return textView;
        }
        TextView textView2 = new TextView(getContext());
        textView2.setLayoutParams(new FrameLayout.LayoutParams(-2, -2, 16));
        textView2.setBackground(AppCompatResources.getDrawable(textView2.getContext(), com.stepos.ability.R.drawable.stepos_bg_list_button));
        textView2.setTextAppearance(com.stepos.ability.R.style.StepOSTextAppearance_ListItem_Button);
        textView2.setGravity(17);
        textView2.setMaxLines(2);
        textView2.setMinHeight(textView2.getResources().getDimensionPixelSize(com.stepos.ability.R.dimen.stepos_list_item_button_min_height));
        int dimensionPixelSize = textView2.getResources().getDimensionPixelSize(com.stepos.ability.R.dimen.stepos_list_item_button_padding_horizontal);
        int dimensionPixelSize2 = textView2.getResources().getDimensionPixelSize(com.stepos.ability.R.dimen.stepos_list_item_button_padding_vertical);
        textView2.setPaddingRelative(dimensionPixelSize, dimensionPixelSize2, dimensionPixelSize, dimensionPixelSize2);
        textView2.setContentDescription(textView2.getContext().getText(com.stepos.ability.R.string.stepos_list_item_button_desc));
        CharSequence charSequence = this.f4118M;
        if (charSequence != null) {
            textView2.setText(charSequence);
        }
        getTrailingContainer().addView(textView2);
        this.f4136v = textView2;
        return textView2;
    }

    public final L6.a o() {
        L6.a aVar = this.f4135t;
        if (aVar != null) {
            return aVar;
        }
        Context context = getContext();
        k.e(context, "getContext(...)");
        L6.a aVar2 = new L6.a(context, null, androidx.appcompat.R.attr.switchStyle);
        aVar2.d = true;
        aVar2.setBackground(null);
        aVar2.setTrackDrawable(AppCompatResources.getDrawable(context, com.stepos.ability.R.drawable.stepos_switch_track));
        aVar2.setThumbDrawable(AppCompatResources.getDrawable(context, com.stepos.ability.R.drawable.stepos_switch_thumb));
        aVar2.setTrackTintList(AppCompatResources.getColorStateList(context, com.stepos.ability.R.color.stepos_switch_track_tint));
        aVar2.setThumbTintList(AppCompatResources.getColorStateList(context, com.stepos.ability.R.color.stepos_switch_thumb_tint));
        aVar2.setShowText(false);
        aVar2.setSwitchMinWidth(aVar2.getResources().getDimensionPixelSize(com.stepos.ability.R.dimen.stepos_switch_track_width));
        aVar2.setSwitchHapticFeedbackEnabled(this.isSwitchHapticFeedbackEnabled);
        aVar2.setLayoutParams(new FrameLayout.LayoutParams(-2, -2, 16));
        aVar2.setContentDescription(aVar2.getContext().getText(com.stepos.ability.R.string.stepos_list_item_switch_desc));
        aVar2.setOnCheckedChangeListener(new d(0, this));
        getTrailingContainer().addView(aVar2);
        this.f4135t = aVar2;
        return aVar2;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final int[] onCreateDrawableState(int i) {
        int[] iArrOnCreateDrawableState = super.onCreateDrawableState(i + 1);
        if (this.f4134s) {
            View.mergeDrawableStates(iArrOnCreateDrawableState, b0);
        }
        k.c(iArrOnCreateDrawableState);
        return iArrOnCreateDrawableState;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        StepOSListItem stepOSListItemS = s();
        if (stepOSListItemS != null) {
            stepOSListItemS.setNeighborBelowHidesDivider(false);
        }
        super.onDetachedFromWindow();
        this.f4123R = false;
        this.f4124S = false;
        this.f4125T = false;
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.View
    public final void onMeasure(int i, int i6) {
        if (View.MeasureSpec.getMode(i) == 0) {
            l(false);
            getValueView().setMaxWidth(Integer.MAX_VALUE);
            getTitleEndView().setMaxWidth(Integer.MAX_VALUE);
            super.onMeasure(i, i6);
            return;
        }
        int iQ = q(this, i, i6, getIconView()) + q(this, i, i6, getBadgeView());
        int iQ2 = q(this, i, i6, getTrailingContainer()) + q(this, i, i6, getRightBadgeView());
        ViewGroup.LayoutParams layoutParams = getTitleView().getLayoutParams();
        k.d(layoutParams, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) layoutParams;
        boolean z10 = getValueView().getVisibility() != 8;
        boolean z11 = (getRightBadgeView().getVisibility() == 8 && getTrailingContainer().getVisibility() == 8) ? false : true;
        int i10 = getRightBadgeView().getVisibility() != 8 ? this.c : getTrailingContainer().getVisibility() != 8 ? this.d : 0;
        int i11 = (z10 || z11) ? this.c : 0;
        int size = ((((View.MeasureSpec.getSize(i) - getPaddingStart()) - getPaddingEnd()) - iQ) - layoutParams2.getMarginStart()) - iQ2;
        if (size < 0) {
            size = 0;
        }
        int i12 = (size - i11) - (z10 ? i10 : 0);
        if (i12 < 0) {
            i12 = 0;
        }
        int iM = m(getTitleView());
        int iM2 = m(getTitleEndView());
        int i13 = getTitleEndView().getVisibility() != 8 ? this.d : 0;
        int iMax = Math.max(iM + i13 + iM2, m(getSubtitleView()));
        int iM3 = m(getValueView());
        int iX = M.a.x(i12, iMax, iM3, 30);
        int i14 = i12 - iX;
        int i15 = i14 - i13;
        int iX2 = i15 - M.a.x(i15 < 0 ? 0 : i15, iM, iM2, 50);
        boolean z12 = this.isAdaptiveTextLayoutEnabled && z10 && (iM > (iX2 < 0 ? 0 : iX2) || (iMax > i14 && iM3 > iX));
        l(z12);
        if (z12) {
            i14 = size - (z11 ? this.c : 0);
            if (i14 < 0) {
                i14 = 0;
            }
        }
        int i16 = i14 - i13;
        if (i16 < 0) {
            i16 = 0;
        }
        int iX3 = M.a.x(i16, iM, iM2, 50);
        if (getTitleEndView().getMaxWidth() != iX3) {
            getTitleEndView().setMaxWidth(iX3);
        }
        if (z12) {
            int i17 = size - i10;
            iX = i17 < 0 ? 0 : i17;
        }
        if (getValueView().getMaxWidth() != iX) {
            getValueView().setMaxWidth(iX);
        }
        if (z12 && !z11) {
            i11 = 0;
        }
        v(getTitleView(), getTitleEndView().getVisibility() == 8 ? i11 : 0);
        v(getTitleEndView(), i11);
        v(getSubtitleView(), i11);
        super.onMeasure(i, i6);
    }

    public final void p() {
        invalidate();
        StepOSListItem stepOSListItemS = s();
        if (stepOSListItemS != null) {
            stepOSListItemS.setNeighborBelowHidesDivider(getHidesAdjacentDividers$StepOSWidget_release());
        }
        ViewParent parent = getParent();
        StepOSListGroup stepOSListGroup = parent instanceof StepOSListGroup ? (StepOSListGroup) parent : null;
        if (stepOSListGroup != null) {
            stepOSListGroup.invalidate();
        }
        ViewParent parent2 = getParent();
        RecyclerView recyclerView = parent2 instanceof RecyclerView ? (RecyclerView) parent2 : null;
        if (recyclerView != null) {
            recyclerView.invalidate();
        }
        getParent();
    }

    public final void r() {
        if (this.f4121P) {
            this.f4122Q.c = getDividerInsetStart();
            invalidate();
        }
    }

    public final StepOSListItem s() {
        View childAt;
        View view;
        ViewParent parent = getParent();
        if (parent instanceof RecyclerView) {
            RecyclerView recyclerView = (RecyclerView) parent;
            int childAdapterPosition = recyclerView.getChildAdapterPosition(this);
            if (childAdapterPosition <= 0) {
                return null;
            }
            RecyclerView.ViewHolder viewHolderFindViewHolderForAdapterPosition = recyclerView.findViewHolderForAdapterPosition(childAdapterPosition - 1);
            if (viewHolderFindViewHolderForAdapterPosition != null && (view = viewHolderFindViewHolderForAdapterPosition.itemView) != null) {
                stepOSListItem = view instanceof StepOSListItem ? (StepOSListItem) view : null;
                if (stepOSListItem == null) {
                    return (StepOSListItem) view.findViewById(com.stepos.ability.R.id.stepos_preference_bridge_row);
                }
            }
            return stepOSListItem;
        }
        if (parent instanceof StepOSListGroup) {
            return null;
        }
        if (parent instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) parent;
            int iIndexOfChild = viewGroup.indexOfChild(this);
            if (iIndexOfChild <= 0 || (childAt = viewGroup.getChildAt(iIndexOfChild - 1)) == null) {
                return null;
            }
            stepOSListItem = childAt instanceof StepOSListItem ? (StepOSListItem) childAt : null;
            if (stepOSListItem == null) {
                return (StepOSListItem) childAt.findViewById(com.stepos.ability.R.id.stepos_preference_bridge_row);
            }
        }
        return stepOSListItem;
    }

    public final void setAccessoryIcon(Drawable drawable) throws Resources.NotFoundException {
        this.p = false;
        getAccessoryView().setImageDrawable(drawable);
        a();
        k(this.f4117L);
    }

    public final void setAccessorySize(@Px int px) {
        if (px < 0) {
            throw new IllegalArgumentException(B7.a.h(px, "accessorySize must be >= 0 but was ").toString());
        }
        this.f4132q = Integer.valueOf(px);
        a();
    }

    public final void setAccessorySource(Object obj) throws Resources.NotFoundException {
        this.p = false;
        a();
        getAccessoryView().setImageDrawable(null);
        k(this.f4117L);
    }

    public final void setAccessoryTint(ColorStateList tint) {
        getAccessoryView().setImageTintList(tint);
    }

    @MainThread
    public final void setAdaptiveTextLayoutEnabled(boolean z10) {
        if (this.isAdaptiveTextLayoutEnabled == z10) {
            return;
        }
        this.isAdaptiveTextLayoutEnabled = z10;
        requestLayout();
    }

    public final void setBadgeStyle(int i) {
        this.f4139z = i;
        c();
    }

    public final void setBadgeTint(@ColorInt Integer num) {
        this.f4111A = num;
        c();
    }

    @Override // android.widget.Checkable
    public void setChecked(boolean checked) {
        if (this.f4134s == checked) {
            return;
        }
        this.f4134s = checked;
        k(this.f4117L);
    }

    public final void setDividerColor(int color) {
        this.f4122Q.b = color;
        invalidate();
    }

    public final void setDividerInsetStart(@Px int insetStart) {
        if (insetStart < 0) {
            insetStart = getDividerInsetStart();
        }
        this.f4122Q.c = insetStart;
        invalidate();
    }

    @Override // android.view.View
    public void setEnabled(boolean enabled) {
        super.setEnabled(enabled);
        setAlpha(enabled ? 1.0f : 0.3f);
    }

    public final void setIcon(Drawable drawable) {
        getIconView().setImageDrawable(drawable);
        w();
    }

    public final void setIconBackgroundColor(@ColorInt Integer color) {
        this.n = color;
        e();
    }

    public final void setIconCornerRadius(@Px float px) {
        this.m = px;
        e();
    }

    public final void setIconSize(@Px int px) {
        u(getIconView(), px, px);
    }

    public final void setIconSource(Object obj) {
        getIconView().setImageDrawable(null);
        getIconView().setVisibility(this.f4133r ? 0 : 8);
        r();
    }

    public final void setIconStyle(int i) {
        this.iconStyle = i;
        Resources resources = getResources();
        if (i == 1) {
            ImageView iconView = getIconView();
            int dimensionPixelSize = resources.getDimensionPixelSize(com.stepos.ability.R.dimen.stepos_list_item_icon_large);
            u(iconView, dimensionPixelSize, dimensionPixelSize);
            this.m = 0.0f;
        } else if (i == 2) {
            ImageView iconView2 = getIconView();
            int dimensionPixelSize2 = resources.getDimensionPixelSize(com.stepos.ability.R.dimen.stepos_list_item_icon_square);
            u(iconView2, dimensionPixelSize2, dimensionPixelSize2);
            this.m = resources.getDimension(com.stepos.ability.R.dimen.stepos_list_item_icon_radius_square);
        } else if (i == 3) {
            ImageView iconView3 = getIconView();
            int dimensionPixelSize3 = resources.getDimensionPixelSize(com.stepos.ability.R.dimen.stepos_list_item_icon_avatar);
            u(iconView3, dimensionPixelSize3, dimensionPixelSize3);
            this.m = resources.getDimension(com.stepos.ability.R.dimen.stepos_radius_full);
        } else if (i == 4) {
            u(getIconView(), resources.getDimensionPixelSize(com.stepos.ability.R.dimen.stepos_list_item_icon_preview_width), resources.getDimensionPixelSize(com.stepos.ability.R.dimen.stepos_list_item_icon_preview_height));
            this.m = resources.getDimension(com.stepos.ability.R.dimen.stepos_list_item_icon_radius_preview);
        } else if (i != 5) {
            ImageView iconView4 = getIconView();
            int dimensionPixelSize4 = resources.getDimensionPixelSize(com.stepos.ability.R.dimen.stepos_list_item_icon_small);
            u(iconView4, dimensionPixelSize4, dimensionPixelSize4);
            this.m = 0.0f;
        } else {
            u(getIconView(), resources.getDimensionPixelSize(com.stepos.ability.R.dimen.stepos_list_item_icon_preview_wide_width), resources.getDimensionPixelSize(com.stepos.ability.R.dimen.stepos_list_item_icon_preview_wide_height));
            this.m = resources.getDimension(com.stepos.ability.R.dimen.stepos_list_item_icon_radius_preview);
        }
        e();
        r();
    }

    public final void setIconTint(ColorStateList tint) {
        getIconView().setImageTintList(tint);
    }

    public final void setIconVisible(boolean visible) {
        setShowIcon(visible);
    }

    public final void setLineMode(int i) {
        this.E = i;
        g();
    }

    public final void setOnCheckedChangeListener(F6.e listener) {
    }

    public final void setOnItemClickListener(f listener) {
        this.f = listener;
        if (listener != null) {
            setOnClickListener(new A6.b(this, 1));
        } else {
            setOnClickListener(null);
            setClickable(false);
        }
    }

    public final void setOnSwitchCheckedChangeListener(g listener) {
        this.g = listener;
    }

    public final void setPressFeedbackEnabled(boolean z10) {
        Drawable drawable;
        if (this.i == z10) {
            return;
        }
        this.i = z10;
        float[] fArr = this.f4131j;
        if (fArr != null) {
            Context context = getContext();
            k.e(context, "getContext(...)");
            drawable = N.n(context, fArr, this.k, z10);
        } else {
            drawable = z10 ? AppCompatResources.getDrawable(getContext(), com.stepos.ability.R.drawable.stepos_bg_list_item_selector) : new ColorDrawable(0);
        }
        setBackground(drawable);
        p();
    }

    public final void setPressScaleEnabled(boolean enabled) {
        this.h = enabled;
        setStateListAnimator(enabled ? AnimatorInflater.loadStateListAnimator(getContext(), com.stepos.ability.R.animator.stepos_list_item_press) : null);
    }

    public final void setReservesCheckSlot(boolean z10) throws Resources.NotFoundException {
        if (this.l == z10) {
            return;
        }
        this.l = z10;
        k(this.f4117L);
    }

    public final void setRightBadgeStyle(int i) {
        this.f4113C = i;
        c();
    }

    public final void setRightBadgeTint(@ColorInt Integer num) {
        this.f4114D = num;
        c();
    }

    public final void setRightText(CharSequence charSequence) {
        setValueText(charSequence);
    }

    public final void setShowAccessory(boolean show) {
        this.o = show;
        k(this.f4117L);
    }

    public final void setShowBadge(boolean z10) {
        this.y = z10;
        c();
    }

    public final void setShowDivider(boolean z10) {
        t(this, z10);
    }

    public final void setShowIcon(boolean z10) {
        this.f4133r = z10;
        w();
    }

    public final void setShowRightBadge(boolean z10) {
        this.f4112B = z10;
        c();
    }

    public final void setSubtitle(CharSequence charSequence) {
        getSubtitleView().setText(charSequence);
        g();
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public final void setSwipeAppearanceActive$StepOSWidget_release(boolean active) {
        if (this.f4125T == active) {
            return;
        }
        this.f4125T = active;
        p();
    }

    public final void setSwitchChecked(boolean z10) {
        o().setChecked(z10);
    }

    @MainThread
    public final void setSwitchHapticFeedbackEnabled(boolean z10) {
        this.isSwitchHapticFeedbackEnabled = z10;
        L6.a aVar = this.f4135t;
        if (aVar != null) {
            aVar.setSwitchHapticFeedbackEnabled(z10);
        }
    }

    public final void setSwitchHapticFeedbackOwner$StepOSWidget_release(Object obj) {
        this.switchHapticFeedbackOwner = obj;
    }

    public final void setTitle(CharSequence charSequence) {
        getTitleView().setText(charSequence);
    }

    public final void setTitleEndText(CharSequence charSequence) {
        getTitleEndView().setText(charSequence);
        getTitleEndView().setVisibility((charSequence == null || charSequence.length() == 0) ? 8 : 0);
    }

    public final void setTitleStyle(int i) {
        this.f4119N = i;
        i();
    }

    public final void setTrailingType(int i) {
        this.f4117L = i;
        k(i);
    }

    public final void setTrailingView(View view) {
        View view2 = this.f4137w;
        if (view2 != null) {
            getTrailingContainer().removeView(view2);
        }
        this.f4137w = view;
        if (view == null) {
            if (this.f4117L == 4) {
                setTrailingType(0);
                return;
            }
            return;
        }
        ViewParent parent = view.getParent();
        ViewGroup viewGroup = parent instanceof ViewGroup ? (ViewGroup) parent : null;
        if (viewGroup != null) {
            ViewGroup viewGroup2 = viewGroup != getTrailingContainer() ? viewGroup : null;
            if (viewGroup2 != null) {
                viewGroup2.removeView(view);
            }
        }
        if (view.getLayoutParams() == null) {
            view.setLayoutParams(new FrameLayout.LayoutParams(-2, -2, 16));
        }
        getTrailingContainer().addView(view);
        setTrailingType(4);
    }

    public final void setValueText(CharSequence charSequence) {
        getValueView().setText(charSequence);
        getValueView().setVisibility((charSequence == null || charSequence.length() == 0) ? 8 : 0);
    }

    @Override // android.widget.Checkable
    public final void toggle() {
        setChecked(!this.f4134s);
    }

    public final void w() {
        getIconView().setVisibility((!this.f4133r || getIconView().getDrawable() == null) ? 8 : 0);
        f();
        r();
    }

    public final void setRightText(int resId) {
        setValueText(getContext().getText(resId));
    }

    public final void setTitle(int resId) {
        getTitleView().setText(resId);
    }

    public final void setIcon(int resId) {
        getIconView().setImageResource(resId);
        w();
    }

    public final void setSubtitle(int resId) {
        setSubtitle(getContext().getText(resId));
    }

    public final void setTitleEndText(int resId) {
        setTitleEndText(getContext().getText(resId));
    }

    public final void setValueText(int resId) {
        setValueText(getContext().getText(resId));
    }

    public final void setAccessoryIcon(@DrawableRes int resId) {
        this.p = resId == com.stepos.ability.R.drawable.stepos_icon_arrow_right;
        getAccessoryView().setImageResource(resId);
        a();
        k(this.f4117L);
    }
}
