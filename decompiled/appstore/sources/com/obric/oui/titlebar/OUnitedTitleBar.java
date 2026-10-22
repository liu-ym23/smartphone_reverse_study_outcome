package com.obric.oui.titlebar;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.bytedanceos.common.ui.animation.AnimationConstants;
import com.obric.common.oui.R$color;
import com.obric.common.oui.R$id;
import com.obric.common.oui.R$layout;
import com.obric.common.oui.R$styleable;
import com.obric.oui.button.OIconButton;
import com.obric.oui.titlebar.behavior.BaseBehavior;
import com.obric.oui.titlebar.behavior.HeaderBehavior;
import com.tmall.wireless.tangram.structure.card.FixCard;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import kotlin.jvm.internal.y;
import kotlinx.coroutines.channels.Channel;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tc.f;
import tc.l;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0096\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0010!\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 H2\u00020\u00012\u00020\u0002:\u0007\u009c\u0001J\u009d\u0001\u009e\u0001B\u001d\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\f\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u000e\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\u000e\u0010\rJ\u0015\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\b\u0011\u0010\u0012J\u0015\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\u0013¢\u0006\u0004\b\u0015\u0010\u0016J\u0015\u0010\u0019\u001a\u00020\u000b2\u0006\u0010\u0018\u001a\u00020\u0017¢\u0006\u0004\b\u0019\u0010\u001aJ\u001b\u0010\u001e\u001a\u0004\u0018\u00010\u001d2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001bH\u0014¢\u0006\u0004\b\u001e\u0010\u001fJ\u001b\u0010 \u001a\u0004\u0018\u00010\u001d2\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016¢\u0006\u0004\b \u0010!J\r\u0010\"\u001a\u00020\u000b¢\u0006\u0004\b\"\u0010#J\r\u0010$\u001a\u00020\u000b¢\u0006\u0004\b$\u0010#J\u0015\u0010'\u001a\u00020\u000b2\u0006\u0010&\u001a\u00020%¢\u0006\u0004\b'\u0010(J\u0015\u0010)\u001a\u00020\u000b2\u0006\u0010&\u001a\u00020%¢\u0006\u0004\b)\u0010(J\r\u0010*\u001a\u00020\u000f¢\u0006\u0004\b*\u0010+J\u0015\u0010-\u001a\u00020\u000f2\u0006\u0010,\u001a\u00020\u000f¢\u0006\u0004\b-\u0010.J\r\u0010/\u001a\u00020\u000f¢\u0006\u0004\b/\u0010+J\r\u00100\u001a\u00020\u0013¢\u0006\u0004\b0\u00101J\r\u00102\u001a\u00020\u0013¢\u0006\u0004\b2\u00101J\u0017\u00104\u001a\u00020\u000f2\b\u00103\u001a\u0004\u0018\u00010%¢\u0006\u0004\b4\u00105J\r\u00106\u001a\u00020\u0013¢\u0006\u0004\b6\u00101J\u0019\u00109\u001a\u0004\u0018\u0001072\b\u00108\u001a\u0004\u0018\u000107¢\u0006\u0004\b9\u0010:J\r\u0010;\u001a\u00020\u0013¢\u0006\u0004\b;\u00101J\r\u0010<\u001a\u00020\u000b¢\u0006\u0004\b<\u0010#J\r\u0010=\u001a\u00020\u000f¢\u0006\u0004\b=\u0010+J\r\u0010>\u001a\u00020\u0013¢\u0006\u0004\b>\u00101J\r\u0010?\u001a\u00020\u0013¢\u0006\u0004\b?\u00101J\u0013\u0010A\u001a\u0006\u0012\u0002\b\u00030@H\u0016¢\u0006\u0004\bA\u0010BJ!\u0010C\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0002¢\u0006\u0004\bC\u0010\bJ\u000f\u0010D\u001a\u00020\u0013H\u0002¢\u0006\u0004\bD\u00101J\u001b\u0010E\u001a\u0004\u0018\u00010%2\b\u00103\u001a\u0004\u0018\u00010%H\u0002¢\u0006\u0004\bE\u0010FJ\u000f\u0010G\u001a\u00020\u000bH\u0002¢\u0006\u0004\bG\u0010#J\u000f\u0010H\u001a\u00020\u000fH\u0002¢\u0006\u0004\bH\u0010+J\u000f\u0010I\u001a\u00020\u0013H\u0002¢\u0006\u0004\bI\u00101R\u0014\u0010L\u001a\u00020\u000f8\u0002X\u0082D¢\u0006\u0006\n\u0004\bJ\u0010KR$\u0010S\u001a\u0004\u0018\u00010M8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bN\u0010O\u001a\u0004\bP\u0010Q\"\u0004\b'\u0010RR$\u0010V\u001a\u0004\u0018\u00010M8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bT\u0010O\u001a\u0004\bU\u0010Q\"\u0004\b)\u0010RR$\u0010^\u001a\u0004\u0018\u00010W8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bX\u0010Y\u001a\u0004\bZ\u0010[\"\u0004\b\\\u0010]R$\u0010b\u001a\u0004\u0018\u00010W8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b_\u0010Y\u001a\u0004\b`\u0010[\"\u0004\ba\u0010]R$\u0010h\u001a\u0004\u0018\u00010%8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bc\u0010d\u001a\u0004\be\u0010f\"\u0004\bg\u0010(R$\u0010p\u001a\u0004\u0018\u00010i8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bj\u0010k\u001a\u0004\bl\u0010m\"\u0004\bn\u0010oR$\u0010x\u001a\u0004\u0018\u00010q8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\br\u0010s\u001a\u0004\bt\u0010u\"\u0004\bv\u0010wR$\u0010{\u001a\u0004\u0018\u00010q8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010s\u001a\u0004\by\u0010u\"\u0004\bz\u0010wR$\u0010~\u001a\u0004\u0018\u00010%8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bE\u0010d\u001a\u0004\b|\u0010f\"\u0004\b}\u0010(R(\u0010\u0083\u0001\u001a\u0004\u0018\u00010\u00178\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0004\b \u0010\u007f\u001a\u0006\b\u0080\u0001\u0010\u0081\u0001\"\u0005\b\u0082\u0001\u0010\u001aR&\u0010\u0087\u0001\u001a\u00020\u00138\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\b\u001e\u0010\u0084\u0001\u001a\u0005\b\u0085\u0001\u00101\"\u0005\b\u0086\u0001\u0010\u0016R\u0018\u0010\u0088\u0001\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b=\u0010\u0084\u0001R!\u0010\u008b\u0001\u001a\u000b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0089\u00018\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b/\u0010\u008a\u0001R%\u0010\u008e\u0001\u001a\u00020\u000f8\u0006@\u0006X\u0086\u000e¢\u0006\u0014\n\u0004\bC\u0010K\u001a\u0005\b\u008c\u0001\u0010+\"\u0005\b\u008d\u0001\u0010\u0012R&\u0010\u0091\u0001\u001a\u00020\u00138\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\b\u001c\u0010\u0084\u0001\u001a\u0005\b\u008f\u0001\u00101\"\u0005\b\u0090\u0001\u0010\u0016R\u001d\u0010\u0093\u0001\u001a\u00020\u00138\u0006X\u0086D¢\u0006\u000e\n\u0005\b*\u0010\u0084\u0001\u001a\u0005\b\u0092\u0001\u00101R\u0018\u0010\u0094\u0001\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b9\u0010\u0084\u0001R\u0016\u0010\u0095\u0001\u001a\u00020\u00138\u0002X\u0083D¢\u0006\u0007\n\u0005\b$\u0010\u0084\u0001R!\u0010\u0098\u0001\u001a\u000b\u0012\u0004\u0012\u00020%\u0018\u00010\u0096\u00018\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b<\u0010\u0097\u0001R\u001a\u0010\u009a\u0001\u001a\u0004\u0018\u0001078\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b-\u0010\u0099\u0001R\u0015\u0010\u009b\u0001\u001a\u00020\u000f8\u0002X\u0082D¢\u0006\u0006\n\u0004\b\"\u0010K¨\u0006\u009f\u0001"}, d2 = {"Lcom/obric/oui/titlebar/OUnitedTitleBar;", "Landroid/widget/FrameLayout;", "Landroidx/coordinatorlayout/widget/CoordinatorLayout$AttachedBehavior;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "Lcom/obric/oui/titlebar/OUnitedTitleBar$OnOffsetChangeListener;", "listener", "", "addOnOffsetChangeListener", "(Lcom/obric/oui/titlebar/OUnitedTitleBar$OnOffsetChangeListener;)V", "removeOnOffsetChangeListener", "", "expanded", "setExpanded", "(Z)V", "", "offset", "i", "(I)V", "Lcom/obric/oui/titlebar/OUnitedTitleBar$OnHeaderFlingUnConsumedListener;", "onHeaderFlingUnConsumedListener", "setOnHeaderFlingUnConsumedListener", "(Lcom/obric/oui/titlebar/OUnitedTitleBar$OnHeaderFlingUnConsumedListener;)V", "Landroid/view/ViewGroup$LayoutParams;", "p", "Lcom/obric/oui/titlebar/behavior/BaseBehavior$LayoutParams;", "l", "(Landroid/view/ViewGroup$LayoutParams;)Lcom/obric/oui/titlebar/behavior/BaseBehavior$LayoutParams;", "k", "(Landroid/util/AttributeSet;)Lcom/obric/oui/titlebar/behavior/BaseBehavior$LayoutParams;", "v", "()V", "s", "Landroid/view/View;", "view", "setLeftAction", "(Landroid/view/View;)V", "setRightAction", "q", "()Z", "lifted", "u", "(Z)Z", "n", "getDownNestedScrollRange", "()I", "getUpNestedPreScrollRange", "defaultScrollingView", FixCard.FixStyle.KEY_X, "(Landroid/view/View;)Z", "getTopInset", "Landroidx/core/view/WindowInsetsCompat;", "insets", "r", "(Landroidx/core/view/WindowInsetsCompat;)Landroidx/core/view/WindowInsetsCompat;", "getPendingAction", "t", "m", "getTotalScrollRange", "getDownNestedPreScrollRange", "Landroidx/coordinatorlayout/widget/CoordinatorLayout$Behavior;", "getBehavior", "()Landroidx/coordinatorlayout/widget/CoordinatorLayout$Behavior;", "o", "getSnapRange", "j", "(Landroid/view/View;)Landroid/view/View;", FixCard.FixStyle.KEY_Y, "w", "getScrollRange", "a", "Z", "liftOnScroll", "Landroid/view/ViewGroup;", "b", "Landroid/view/ViewGroup;", "getLeftAction", "()Landroid/view/ViewGroup;", "(Landroid/view/ViewGroup;)V", "leftAction", "c", "getRightAction", "rightAction", "Landroid/widget/TextView;", "d", "Landroid/widget/TextView;", "getMTvTitle", "()Landroid/widget/TextView;", "setMTvTitle", "(Landroid/widget/TextView;)V", "mTvTitle", "e", "getMTvSubTitle", "setMTvSubTitle", "mTvSubTitle", "f", "Landroid/view/View;", "getBottomAction", "()Landroid/view/View;", "setBottomAction", "bottomAction", "", "g", "Ljava/lang/String;", "getTitleText", "()Ljava/lang/String;", "setTitleText", "(Ljava/lang/String;)V", "titleText", "Landroid/graphics/drawable/Drawable;", "h", "Landroid/graphics/drawable/Drawable;", "getLeftActionSrc", "()Landroid/graphics/drawable/Drawable;", "setLeftActionSrc", "(Landroid/graphics/drawable/Drawable;)V", "leftActionSrc", "getRightActionSrc", "setRightActionSrc", "rightActionSrc", "getDivider", "setDivider", "divider", "Lcom/obric/oui/titlebar/OUnitedTitleBar$OnHeaderFlingUnConsumedListener;", "getMOnHeaderFlingUnConsumedListener", "()Lcom/obric/oui/titlebar/OUnitedTitleBar$OnHeaderFlingUnConsumedListener;", "setMOnHeaderFlingUnConsumedListener", "mOnHeaderFlingUnConsumedListener", "I", "getMCollapsePosition", "setMCollapsePosition", "mCollapsePosition", "mPendingAction", "", "Ljava/util/List;", "mOnOffsetChangeListeners", "getInDebug", "setInDebug", "inDebug", "getTextInitPos", "setTextInitPos", "textInitPos", "getINVALID_SCROLL_RANGE", "INVALID_SCROLL_RANGE", "downScrollRange", "liftOnScrollTargetViewId", "Ljava/lang/ref/WeakReference;", "Ljava/lang/ref/WeakReference;", "liftOnScrollTargetView", "Landroidx/core/view/WindowInsetsCompat;", "lastInsets", "haveChildWithInterpolator", "Behavior", "OnHeaderFlingUnConsumedListener", "OnOffsetChangeListener", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OUnitedTitleBar extends FrameLayout implements CoordinatorLayout.AttachedBehavior {
    public static final int A = 0;
    public static final int B = 0;
    public static final int C = 0;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final a f17453w = null;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final int f17454x = 0;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final int f17455y = 0;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final int f17456z = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f17457a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ViewGroup f17458b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ViewGroup f17459c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public TextView f17460d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public TextView f17461e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public View f17462f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f17463g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Drawable f17464h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Drawable f17465i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public View f17466j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public OnHeaderFlingUnConsumedListener f17467k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f17468l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f17469m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public List f17470n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f17471o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f17472p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final int f17473q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f17474r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final int f17475s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public WeakReference f17476t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public WindowInsetsCompat f17477u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final boolean f17478v;

    @Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0015\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001B\t\b\u0016¢\u0006\u0004\b\u0003\u0010\u0004B\u001d\b\u0016\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0003\u0010\tJ3\u0010\u0012\u001a\u00020\u00112\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\f\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\u0012\u0010\u0013J3\u0010\u0018\u001a\u00020\u00112\b\u0010\u0014\u001a\u0004\u0018\u00010\n2\b\u0010\u0015\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0016\u001a\u00020\r2\u0006\u0010\u0017\u001a\u00020\rH\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\u0019\u0010\u001c\u001a\u00020\u001b2\b\u0010\u001a\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u001c\u0010\u001dJ\u0017\u0010\u001e\u001a\u00020\r2\u0006\u0010\u001a\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u001e\u0010\u001fJ\u0017\u0010 \u001a\u00020\r2\u0006\u0010\u001a\u001a\u00020\u0002H\u0016¢\u0006\u0004\b \u0010\u001fJ;\u0010$\u001a\u00020\r2\b\u0010\u0014\u001a\u0004\u0018\u00010\n2\b\u0010\u0015\u001a\u0004\u0018\u00010\u00022\u0006\u0010!\u001a\u00020\r2\u0006\u0010\"\u001a\u00020\r2\u0006\u0010#\u001a\u00020\rH\u0016¢\u0006\u0004\b$\u0010%J9\u0010(\u001a\u00020\u001b2\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010&\u001a\u00020\u00022\u0006\u0010\"\u001a\u00020\r2\u0006\u0010#\u001a\u00020\r2\u0006\u0010'\u001a\u00020\u000fH\u0016¢\u0006\u0004\b(\u0010)J#\u0010*\u001a\u00020\u00112\b\u0010\u0014\u001a\u0004\u0018\u00010\n2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b*\u0010+J!\u0010,\u001a\u00020\u001b2\b\u0010\u0014\u001a\u0004\u0018\u00010\n2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b,\u0010-J'\u0010/\u001a\u00020\u001b2\u0006\u0010\u0014\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u00022\u0006\u0010.\u001a\u00020\rH\u0016¢\u0006\u0004\b/\u00100J7\u00104\u001a\u00020\u001b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u00022\u0006\u00102\u001a\u0002012\u0006\u0010\u0016\u001a\u0002012\u0006\u00103\u001a\u00020\rH\u0016¢\u0006\u0004\b4\u00105J?\u0010:\u001a\u00020\u00112\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u0002012\u0006\u00106\u001a\u00020\r2\u0006\u00107\u001a\u00020\r2\u0006\u00109\u001a\u000208H\u0016¢\u0006\u0004\b:\u0010;JG\u0010@\u001a\u00020\u00112\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u0002012\u0006\u0010<\u001a\u00020\r2\u0006\u0010=\u001a\u00020\r2\u0006\u0010>\u001a\u00020\r2\u0006\u0010?\u001a\u00020\rH\u0016¢\u0006\u0004\b@\u0010AJ'\u0010B\u001a\u00020\u00112\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u000201H\u0016¢\u0006\u0004\bB\u0010CJ7\u0010E\u001a\u00020\u001b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u0002012\u0006\u0010D\u001a\u00020\u000f2\u0006\u0010'\u001a\u00020\u000fH\u0016¢\u0006\u0004\bE\u0010FJ?\u0010G\u001a\u00020\u001b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u0002012\u0006\u0010D\u001a\u00020\u000f2\u0006\u0010'\u001a\u00020\u000f2\u0006\u00109\u001a\u00020\u001bH\u0016¢\u0006\u0004\bG\u0010HR\u0018\u0010K\u001a\u0004\u0018\u00010I8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b*\u0010JR\u0016\u0010M\u001a\u00020\u001b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b/\u0010LR\u001e\u0010P\u001a\n\u0012\u0004\u0012\u000201\u0018\u00010N8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bG\u0010OR\u0016\u0010Q\u001a\u00020\u001b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bE\u0010LR\u0016\u0010R\u001a\u00020\u001b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b:\u0010LR\u0016\u0010T\u001a\u00020\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b@\u0010SR\u0016\u0010U\u001a\u00020\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b4\u0010SR\u0016\u0010V\u001a\u00020\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bB\u0010S¨\u0006W"}, d2 = {"Lcom/obric/oui/titlebar/OUnitedTitleBar$Behavior;", "Lcom/obric/oui/titlebar/behavior/HeaderBehavior;", "Lcom/obric/oui/titlebar/OUnitedTitleBar;", "<init>", "()V", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "Landroidx/coordinatorlayout/widget/CoordinatorLayout;", "coordinatorLayout", "child", "", "offset", "", "velocity", "", "c", "(Landroidx/coordinatorlayout/widget/CoordinatorLayout;Lcom/obric/oui/titlebar/OUnitedTitleBar;IF)V", "parent", "header", "target", "duration", "d", "(Landroidx/coordinatorlayout/widget/CoordinatorLayout;Lcom/obric/oui/titlebar/OUnitedTitleBar;II)V", "view", "", "f", "(Lcom/obric/oui/titlebar/OUnitedTitleBar;)Z", "i", "(Lcom/obric/oui/titlebar/OUnitedTitleBar;)I", "j", "newOffset", "minOffset", "maxOffset", "s", "(Landroidx/coordinatorlayout/widget/CoordinatorLayout;Lcom/obric/oui/titlebar/OUnitedTitleBar;III)I", "layout", "velocityY", "h", "(Landroidx/coordinatorlayout/widget/CoordinatorLayout;Lcom/obric/oui/titlebar/OUnitedTitleBar;IIF)Z", "k", "(Landroidx/coordinatorlayout/widget/CoordinatorLayout;Lcom/obric/oui/titlebar/OUnitedTitleBar;)V", "g", "(Landroidx/coordinatorlayout/widget/CoordinatorLayout;Lcom/obric/oui/titlebar/OUnitedTitleBar;)Z", "layoutDirection", "l", "(Landroidx/coordinatorlayout/widget/CoordinatorLayout;Lcom/obric/oui/titlebar/OUnitedTitleBar;I)Z", "Landroid/view/View;", "directTargetChild", "nestedScrollAxes", "q", "(Landroidx/coordinatorlayout/widget/CoordinatorLayout;Lcom/obric/oui/titlebar/OUnitedTitleBar;Landroid/view/View;Landroid/view/View;I)Z", "dx", "dy", "", "consumed", "o", "(Landroidx/coordinatorlayout/widget/CoordinatorLayout;Lcom/obric/oui/titlebar/OUnitedTitleBar;Landroid/view/View;II[I)V", "dxConsumed", "dyConsumed", "dxUnconsumed", "dyUnconsumed", "p", "(Landroidx/coordinatorlayout/widget/CoordinatorLayout;Lcom/obric/oui/titlebar/OUnitedTitleBar;Landroid/view/View;IIII)V", "r", "(Landroidx/coordinatorlayout/widget/CoordinatorLayout;Lcom/obric/oui/titlebar/OUnitedTitleBar;Landroid/view/View;)V", "velocityX", "n", "(Landroidx/coordinatorlayout/widget/CoordinatorLayout;Lcom/obric/oui/titlebar/OUnitedTitleBar;Landroid/view/View;FF)Z", "m", "(Landroidx/coordinatorlayout/widget/CoordinatorLayout;Lcom/obric/oui/titlebar/OUnitedTitleBar;Landroid/view/View;FFZ)Z", "Landroid/animation/ValueAnimator;", "Landroid/animation/ValueAnimator;", "mOffsetAnimator", "Z", "mSkipNestedPreScroll", "Ljava/lang/ref/WeakReference;", "Ljava/lang/ref/WeakReference;", "mLastNestedScrollingChildRef", "mWasFlung", "mShouldDispatchFling", "I", "mTempFlingDispatchConsumed", "mTempFlingMinOffset", "mTempFlingMaxOffset", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Behavior extends HeaderBehavior<OUnitedTitleBar> {

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public ValueAnimator f17479k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public boolean f17480l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public WeakReference f17481m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public boolean f17482n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public boolean f17483o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public int f17484p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public int f17485q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public int f17486r;

        public Behavior() {
        }

        public static /* synthetic */ void b(Behavior r10, CoordinatorLayout r11, OUnitedTitleBar r12, ValueAnimator r13) {
            e(r10, r11, r12, r13);
        }

        public static final void e(Behavior r10, CoordinatorLayout r11, OUnitedTitleBar r12, ValueAnimator r13) {
            q.g(r10, "this$0");
            q.g(r13, "animation");
            Object r14 = r13.getAnimatedValue();
            if (r14 == null) goto L7;
            r10.setHeaderTopBottomOffset(r11, r12, ((Integer) r14).intValue());
            return;
        L7:
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
        }

        public final void c(CoordinatorLayout r10, OUnitedTitleBar r11, int r12, float r13) {
            int r14 = Math.abs(getTopBottomOffsetForScrollingSibling() - r12);
            float r15 = Math.abs(r13);
            if (r15 <= 0.0f) goto L5;
            int r16 = Math.round(1000 * (r14 / r15));
        L6:
            d(r10, r11, r12, r16);
            return;
        L5:
            q.d(r11);
            r16 = (int) (((r14 / r11.getHeight()) + 1) * AnimationConstants.DURATION_150);
            goto L6
        }

        @Override // com.obric.oui.titlebar.behavior.HeaderBehavior
        public /* bridge */ /* synthetic */ boolean canDragView(View r10) {
            return f((OUnitedTitleBar) r10);
        }

        public final void d(final CoordinatorLayout r10, final OUnitedTitleBar r11, int r12, int r13) {
            int r14 = getTopAndBottomOffset();
            if (r14 != r12) goto L7;
            ValueAnimator r15 = this.f17479k;
            if (r15 == null) goto L7;
            q.d(r15);
            r15.cancel();
        L7:
            ValueAnimator r16 = this.f17479k;
            if (r16 != null) goto L10;
            ValueAnimator r17 = new ValueAnimator();
            this.f17479k = r17;
            q.d(r17);
            r17.setInterpolator(new AccelerateDecelerateInterpolator());
            ValueAnimator r18 = this.f17479k;
            q.d(r18);
            r18.addUpdateListener(new c(this, r10, r11));
        L11:
            ValueAnimator r19 = this.f17479k;
            q.d(r19);
            r19.setDuration(r13);
            ValueAnimator r20 = this.f17479k;
            q.d(r20);
            r20.setIntValues(new int[]{r14, r12});
            ValueAnimator r21 = this.f17479k;
            q.d(r21);
            r21.start();
            return;
        L10:
            q.d(r16);
            r16.cancel();
            goto L11
        }

        public boolean f(OUnitedTitleBar r10) {
            WeakReference r11 = this.f17481m;
            if (r11 == null) goto L15;
            q.d(r11);
            View r12 = (View) r11.get();
            if (r12 != null) goto L7;
        L13:
            return false;
        L7:
            if (r12.isShown() == false) goto L13;
            if (ViewCompat.f(r12, -1) == true) goto L13;
            int r13 = getTopAndBottomOffset();
            q.d(r10);
            if (r13 <= (-OUnitedTitleBar.d(r10))) goto L13;
            return true;
        L15:
            return true;
        }

        @Override // com.obric.oui.titlebar.behavior.HeaderBehavior
        public /* bridge */ /* synthetic */ boolean fling(CoordinatorLayout r10, View r11, int r12, int r13, float r14) {
            return h(r10, (OUnitedTitleBar) r11, r12, r13, r14);
        }

        public final boolean g(CoordinatorLayout r10, OUnitedTitleBar r11) {
            int r12 = getTopAndBottomOffset();
            q.d(r11);
            int r13 = -OUnitedTitleBar.e(r11);
            if (r12 <= r13) goto L11;
            if (r12 >= 0) goto L11;
            if (r12 < (r13 / 2)) goto L9;
            r13 = 0;
        L9:
            c(r10, r11, r13, 0.0f);
            return true;
        L11:
            return false;
        }

        @Override // com.obric.oui.titlebar.behavior.HeaderBehavior
        public /* bridge */ /* synthetic */ int getMaxDragOffset(View r10) {
            return i((OUnitedTitleBar) r10);
        }

        @Override // com.obric.oui.titlebar.behavior.HeaderBehavior
        public /* bridge */ /* synthetic */ int getScrollRangeForDragFling(View r10) {
            return j((OUnitedTitleBar) r10);
        }

        public boolean h(CoordinatorLayout r10, OUnitedTitleBar r11, int r12, int r13, float r14) {
            q.g(r11, "layout");
            if (r14 >= 0.0f) goto L6;
            this.f17483o = true;
            this.f17484p = 0;
            this.f17485q = r12;
            this.f17486r = r13;
            r12 = Integer.MIN_VALUE;
            r13 = Channel.UNLIMITED;
        L6:
            return super.fling(r10, r11, r12, r13, r14);
        }

        public int i(OUnitedTitleBar r10) {
            q.g(r10, "view");
            return -OUnitedTitleBar.d(r10);
        }

        public int j(OUnitedTitleBar r10) {
            q.g(r10, "view");
            return OUnitedTitleBar.d(r10);
        }

        public void k(CoordinatorLayout r10, OUnitedTitleBar r11) {
            this.f17483o = false;
            g(r10, r11);
        }

        public boolean l(CoordinatorLayout r10, OUnitedTitleBar r11, int r12) {
            q.g(r10, "parent");
            q.g(r11, "child");
            boolean r13 = super.onLayoutChild(r10, r11, r12);
            if (OUnitedTitleBar.c(r11) != 0) goto L5;
        L10:
            r11.i(getTopAndBottomOffset());
            return r13;
        L5:
            if ((OUnitedTitleBar.c(r11) & 1) == 0) goto L8;
            setHeaderTopBottomOffset(r10, r11, -OUnitedTitleBar.d(r11));
            goto L10
        L8:
            if ((OUnitedTitleBar.c(r11) & 16) == 0) goto L10;
            setHeaderTopBottomOffset(r10, r11, 0);
            goto L10
        }

        public boolean m(CoordinatorLayout r10, OUnitedTitleBar r11, View r12, float r13, float r14, boolean r15) {
            q.g(r10, "coordinatorLayout");
            q.g(r11, "child");
            q.g(r12, "target");
            this.f17482n = true;
            return false;
        }

        public boolean n(CoordinatorLayout r10, OUnitedTitleBar r11, View r12, float r13, float r14) {
            q.g(r10, "coordinatorLayout");
            q.g(r11, "child");
            q.g(r12, "target");
            if (r14 > 0.0f) goto L5;
            return false;
        L5:
            if (getTopAndBottomOffset() <= (-OUnitedTitleBar.d(r11))) goto L10;
            h(r10, r11, -OUnitedTitleBar.d(r11), 0, -r14);
            this.f17482n = true;
            return true;
        L10:
            return false;
        }

        public void o(CoordinatorLayout r10, OUnitedTitleBar r11, View r12, int r13, int r14, int[] r15) {
            q.g(r10, "coordinatorLayout");
            q.g(r11, "child");
            q.g(r12, "target");
            q.g(r15, "consumed");
            if (r14 > 0) goto L5;
            return;
        L5:
            if (this.f17480l == true) goto L9;
            r15[1] = scroll(r10, r11, r14, -OUnitedTitleBar.d(r11), 0);
            return;
        }

        @Override // com.obric.oui.titlebar.behavior.HeaderBehavior
        public /* bridge */ /* synthetic */ void onFlingFinished(CoordinatorLayout r10, View r11) {
            k(r10, (OUnitedTitleBar) r11);
        }

        @Override // com.obric.oui.titlebar.behavior.HeaderBehavior, com.obric.oui.titlebar.behavior.ViewOffsetBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public /* bridge */ /* synthetic */ boolean onLayoutChild(CoordinatorLayout r10, View r11, int r12) {
            return l(r10, (OUnitedTitleBar) r11, r12);
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public /* bridge */ /* synthetic */ boolean onNestedFling(CoordinatorLayout r10, View r11, View r12, float r13, float r14, boolean r15) {
            return m(r10, (OUnitedTitleBar) r11, r12, r13, r14, r15);
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public /* bridge */ /* synthetic */ boolean onNestedPreFling(CoordinatorLayout r10, View r11, View r12, float r13, float r14) {
            return n(r10, (OUnitedTitleBar) r11, r12, r13, r14);
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public /* bridge */ /* synthetic */ void onNestedPreScroll(CoordinatorLayout r10, View r11, View r12, int r13, int r14, int[] r15) {
            o(r10, (OUnitedTitleBar) r11, r12, r13, r14, r15);
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public /* bridge */ /* synthetic */ void onNestedScroll(CoordinatorLayout r10, View r11, View r12, int r13, int r14, int r15, int r16) {
            p(r10, (OUnitedTitleBar) r11, r12, r13, r14, r15, r16);
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public /* bridge */ /* synthetic */ boolean onStartNestedScroll(CoordinatorLayout r10, View r11, View r12, View r13, int r14) {
            return q(r10, (OUnitedTitleBar) r11, r12, r13, r14);
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public /* bridge */ /* synthetic */ void onStopNestedScroll(CoordinatorLayout r10, View r11, View r12) {
            r(r10, (OUnitedTitleBar) r11, r12);
        }

        public void p(CoordinatorLayout r10, OUnitedTitleBar r11, View r12, int r13, int r14, int r15, int r16) {
            q.g(r10, "coordinatorLayout");
            q.g(r11, "child");
            q.g(r12, "target");
            if (r16 >= 0) goto L5;
            scroll(r10, r11, r16, -OUnitedTitleBar.d(r11), 0);
            boolean r17 = true;
        L6:
            this.f17480l = r17;
            return;
        L5:
            r17 = false;
            goto L6
        }

        public boolean q(CoordinatorLayout r10, OUnitedTitleBar r11, View r12, View r13, int r14) {
            q.g(r10, "coordinatorLayout");
            q.g(r11, "child");
            q.g(r12, "directTargetChild");
            q.g(r13, "target");
            if ((r14 & 2) > 0) goto L5;
        L9:
            boolean r15 = false;
        L10:
            if (r15 == false) goto L14;
            ValueAnimator r16 = this.f17479k;
            if (r16 == null) goto L14;
            q.d(r16);
            r16.cancel();
        L14:
            this.f17481m = null;
            this.f17482n = false;
            this.f17483o = false;
            a();
            return r15;
        L5:
            if (OUnitedTitleBar.d(r11) <= 0) goto L9;
            if ((r10.getHeight() - r12.getHeight()) > r11.getHeight()) goto L9;
            r15 = true;
            goto L10
        }

        public void r(CoordinatorLayout r10, OUnitedTitleBar r11, View r12) {
            q.g(r10, "coordinatorLayout");
            q.g(r11, "child");
            q.g(r12, "target");
            if (this.f17482n == true) goto L5;
            g(r10, r11);
        L5:
            this.f17480l = false;
            this.f17481m = new WeakReference(r12);
        }

        public int s(CoordinatorLayout r10, OUnitedTitleBar r11, int r12, int r13, int r14) {
            int r15 = getTopAndBottomOffset();
            if (this.f17483o == false) goto L5;
            r13 = Math.max(this.f17485q, r13);
            r14 = Math.min(this.f17486r, r14);
        L5:
            int r16 = super.setHeaderTopBottomOffset(r10, r11, r12, r13, r14);
            if (r11 == null) goto L9;
            r11.i(getTopAndBottomOffset());
        L9:
            int r17 = 0;
            if (this.f17483o == false) goto L20;
            if (r11 != null) goto L13;
            OnHeaderFlingUnConsumedListener r18 = null;
        L14:
            if (r18 == null) goto L20;
            int r19 = ((r12 - r15) + r16) - this.f17484p;
            if (r19 == 0) goto L18;
            q.d(r11);
            OnHeaderFlingUnConsumedListener r110 = r11.getMOnHeaderFlingUnConsumedListener();
            q.d(r110);
            r17 = r110.onFlingUnConsumed(r11, r12, r19);
        L18:
            this.f17484p += -r17;
            goto L20
        L13:
            r18 = r11.getMOnHeaderFlingUnConsumedListener();
        L20:
            return r16 + r17;
        }

        @Override // com.obric.oui.titlebar.behavior.HeaderBehavior
        public /* bridge */ /* synthetic */ int setHeaderTopBottomOffset(CoordinatorLayout r10, View r11, int r12, int r13, int r14) {
            return s(r10, (OUnitedTitleBar) r11, r12, r13, r14);
        }

        public Behavior(@Nullable Context r10, @Nullable AttributeSet r11) {
            super(r10, r11);
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\"\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0003H&¨\u0006\b"}, d2 = {"Lcom/obric/oui/titlebar/OUnitedTitleBar$OnHeaderFlingUnConsumedListener;", "", "onFlingUnConsumed", "", "header", "Lcom/obric/oui/titlebar/OUnitedTitleBar;", "targetOffset", "unconsumed", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface OnHeaderFlingUnConsumedListener {
        int onFlingUnConsumed(@Nullable OUnitedTitleBar r10, int r11, int r12);
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\bf\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\b"}, d2 = {"Lcom/obric/oui/titlebar/OUnitedTitleBar$OnOffsetChangeListener;", "", "onOffsetChanged", "", "header", "Lcom/obric/oui/titlebar/OUnitedTitleBar;", "currOffset", "", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface OnOffsetChangeListener {
        void onOffsetChanged(@Nullable OUnitedTitleBar r10, int r11);
    }

    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }

        public final int a() {
            return OUnitedTitleBar.b();
        }

        public final int b() {
            return OUnitedTitleBar.f();
        }

        public final int c() {
            return OUnitedTitleBar.g();
        }

        public final int d() {
            return OUnitedTitleBar.h();
        }

        public a() {
        }
    }

    public static final class b implements OnOffsetChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ OUnitedTitleBar f17487a;

        public b(OUnitedTitleBar r10) {
            this.f17487a = r10;
        }

        @Override // com.obric.oui.titlebar.OUnitedTitleBar.OnOffsetChangeListener
        public void onOffsetChanged(OUnitedTitleBar r11, int r12) {
            ViewGroup r13 = this.f17487a.getLeftAction();
            ViewGroup.MarginLayoutParams r10 = null;
            if (r13 != null) goto L5;
            ViewGroup.LayoutParams r14 = null;
        L7:
            if ((r14 instanceof ViewGroup.MarginLayoutParams) == false) goto L9;
            ViewGroup.MarginLayoutParams r15 = (ViewGroup.MarginLayoutParams) r14;
        L10:
            ViewGroup r16 = this.f17487a.getRightAction();
            if (r16 != null) goto L13;
            ViewGroup.LayoutParams r17 = null;
        L15:
            if ((r17 instanceof ViewGroup.MarginLayoutParams) == false) goto L17;
            ViewGroup.MarginLayoutParams r18 = (ViewGroup.MarginLayoutParams) r17;
        L18:
            TextView r19 = this.f17487a.getMTvTitle();
            if (r19 != null) goto L21;
            ViewGroup.LayoutParams r20 = null;
        L23:
            if ((r20 instanceof ViewGroup.MarginLayoutParams) == false) goto L25;
            r10 = (ViewGroup.MarginLayoutParams) r20;
        L25:
            OUnitedTitleBar r21 = this.f17487a;
            a r22 = OUnitedTitleBar.f17453w;
            int r23 = f.r(r21, r22.a());
            int r24 = f.r(this.f17487a, r22.d());
            int r25 = f.r(this.f17487a, r22.b());
            float r26 = (-r12) / this.f17487a.getTotalScrollRange();
            if (this.f17487a.getMCollapsePosition() != 1) goto L38;
            r25 = f.r(this.f17487a, r22.c());
            int[] r27 = new int[2];
            TextView r28 = this.f17487a.getMTvTitle();
            if (r28 == null) goto L31;
            r28.getLocationOnScreen(r27);
        L31:
            if (r12 != 0) goto L33;
            this.f17487a.setTextInitPos(r27[0]);
        L33:
            float r29 = (this.f17487a.getTextInitPos() + f.r(this.f17487a, 18)) * r26;
            if (r10 == null) goto L37;
            r10.leftMargin = -((int) r29);
        L37:
            float r30 = 20.0f;
        L40:
            if (r26 != 1.0f) goto L45;
            View r31 = this.f17487a.getDivider();
            if (r31 == null) goto L49;
            l.m(r31);
        L49:
            if (r15 == null) goto L52;
            r15.topMargin = (-r12) + r23;
        L52:
            if (r18 == null) goto L55;
            r18.topMargin = (-r12) + r23;
        L55:
            int r110 = (int) (r24 - ((r24 - r25) * r26));
            float r32 = ((r30 - 40.0f) * new AccelerateDecelerateInterpolator().getInterpolation(r26)) + 40.0f;
            TextView r33 = this.f17487a.getMTvTitle();
            if (r33 == null) goto L59;
            r33.setTextSize(2, r32);
        L59:
            if (r10 == null) goto L62;
            r10.bottomMargin = r110;
        L62:
            ViewGroup r111 = this.f17487a.getLeftAction();
            if (r111 == null) goto L66;
            r111.setLayoutParams(r15);
        L66:
            ViewGroup r112 = this.f17487a.getRightAction();
            if (r112 == null) goto L70;
            r112.setLayoutParams(r18);
        L70:
            TextView r113 = this.f17487a.getMTvTitle();
            if (r113 == null) goto L75;
            r113.setLayoutParams(r10);
            return;
        L75:
            return;
        L45:
            View r34 = this.f17487a.getDivider();
            if (r34 == null) goto L49;
            l.k(r34);
            goto L49
        L38:
            r30 = 16.0f;
            goto L40
        L21:
            r20 = r19.getLayoutParams();
            goto L23
        L17:
            r18 = null;
            goto L18
        L13:
            r17 = r16.getLayoutParams();
            goto L15
        L9:
            r15 = null;
            goto L10
        L5:
            r14 = r13.getLayoutParams();
            goto L7
        }
    }

    static {
        f17453w = new a(null);
        f17454x = 56;
        f17455y = 240;
        f17456z = 12;
        A = 92;
        B = 17;
        C = 14;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @JvmOverloads
    public OUnitedTitleBar(@NotNull Context r10) {
        q.g(r10, "context");
        this(r10, null, 2, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ WindowInsetsCompat a(OUnitedTitleBar r10, View r11, WindowInsetsCompat r12) {
        return p(r10, r11, r12);
    }

    public static final /* synthetic */ int b() {
        return f17456z;
    }

    public static final /* synthetic */ int c(OUnitedTitleBar r10) {
        return r10.f17469m;
    }

    public static final /* synthetic */ int d(OUnitedTitleBar r10) {
        return r10.getScrollRange();
    }

    public static final /* synthetic */ int e(OUnitedTitleBar r10) {
        return r10.getSnapRange();
    }

    public static final /* synthetic */ int f() {
        return B;
    }

    public static final /* synthetic */ int g() {
        return C;
    }

    private final int getScrollRange() {
        return f.r(this, f17455y - f17454x);
    }

    private final int getSnapRange() {
        return f.r(this, 56);
    }

    public static final /* synthetic */ int h() {
        return A;
    }

    private final void o(Context r10, AttributeSet r11) {
        TypedArray r12 = r10.obtainStyledAttributes(r11, R$styleable.OUnitedTitleBar);
        q.f(r12, "context.obtainStyledAttr…tyleable.OUnitedTitleBar)");
        this.f17463g = r12.getString(R$styleable.OUnitedTitleBar_oui_united_title);
        this.f17468l = r12.getInt(R$styleable.OUnitedTitleBar_oui_title_collapse_position, 0);
        this.f17464h = r12.getDrawable(R$styleable.OUnitedTitleBar_oui_left_action_src);
        this.f17465i = r12.getDrawable(R$styleable.OUnitedTitleBar_oui_right_action_src);
        r12.recycle();
        FrameLayout.inflate(r10, R$layout.o_united_titlebar, this);
        this.f17458b = (ViewGroup) findViewById(R$id.fl_left_container);
        this.f17459c = (ViewGroup) findViewById(R$id.fl_right_container);
        this.f17460d = (TextView) findViewById(R$id.tv_title_container);
        this.f17461e = (TextView) findViewById(R$id.tv_subtitle_container);
        this.f17462f = findViewById(R$id.fl_bottom_container);
        this.f17466j = findViewById(R$id.divider);
        TextView r13 = this.f17460d;
        if (r13 == null) goto L6;
        r13.setText(this.f17463g);
    L6:
        ViewCompat.C0(this, new com.obric.oui.titlebar.b(this));
        v();
        s();
    }

    public static final WindowInsetsCompat p(OUnitedTitleBar r10, View r11, WindowInsetsCompat r12) {
        q.g(r10, "this$0");
        WindowInsetsCompat r13 = r10.r(r12);
        q.d(r13);
        return r13;
    }

    public final void addOnOffsetChangeListener(@Nullable OnOffsetChangeListener r10) {
        if (this.f17470n != null) goto L5;
        this.f17470n = new ArrayList();
    L5:
        if (r10 == null) goto L10;
        List r11 = this.f17470n;
        q.d(r11);
        if (r11.contains(r10) == true) goto L11;
        List r12 = this.f17470n;
        q.d(r12);
        r12.add(r10);
        return;
    L11:
        return;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateLayoutParams(AttributeSet r10) {
        return k(r10);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.AttachedBehavior
    @NotNull
    public CoordinatorLayout.Behavior<?> getBehavior() {
        return new BaseBehavior.Behavior();
    }

    @Nullable
    public final View getBottomAction() {
        return this.f17462f;
    }

    @Nullable
    public final View getDivider() {
        return this.f17466j;
    }

    public final int getDownNestedPreScrollRange() {
        return 0;
    }

    public final int getDownNestedScrollRange() {
        return getTotalScrollRange();
    }

    public final int getINVALID_SCROLL_RANGE() {
        return this.f17473q;
    }

    public final boolean getInDebug() {
        return this.f17471o;
    }

    @Nullable
    public final ViewGroup getLeftAction() {
        return this.f17458b;
    }

    @Nullable
    public final Drawable getLeftActionSrc() {
        return this.f17464h;
    }

    public final int getMCollapsePosition() {
        return this.f17468l;
    }

    @Nullable
    public final OnHeaderFlingUnConsumedListener getMOnHeaderFlingUnConsumedListener() {
        return this.f17467k;
    }

    @Nullable
    public final TextView getMTvSubTitle() {
        return this.f17461e;
    }

    @Nullable
    public final TextView getMTvTitle() {
        return this.f17460d;
    }

    public final int getPendingAction() {
        return this.f17469m;
    }

    @Nullable
    public final ViewGroup getRightAction() {
        return this.f17459c;
    }

    @Nullable
    public final Drawable getRightActionSrc() {
        return this.f17465i;
    }

    public final int getTextInitPos() {
        return this.f17472p;
    }

    @Nullable
    public final String getTitleText() {
        return this.f17463g;
    }

    public final int getTopInset() {
        WindowInsetsCompat r10 = this.f17477u;
        if (r10 == null) goto L5;
        q.d(r10);
        return r10.m();
    L5:
        return 0;
    }

    public final int getTotalScrollRange() {
        return f.r(this, f17455y - f17454x);
    }

    public final int getUpNestedPreScrollRange() {
        return getTotalScrollRange();
    }

    public final void i(int r10) {
        List r11 = this.f17470n;
        if (r11 == null) goto L8;
        q.d(r11);
        Iterator r12 = r11.iterator();
    L6:
        if (r12.hasNext() == false) goto L10;
        ((OnOffsetChangeListener) r12.next()).onOffsetChanged(this, r10);
        goto L6
    L10:
        return;
    }

    public final View j(View r10) {
        if (this.f17476t != null) goto L19;
        int r11 = this.f17475s;
        if (r11 == (-1)) goto L19;
        if (r10 == null) goto L8;
        View r12 = r10.findViewById(r11);
    L9:
        if (r12 == null) goto L11;
    L17:
        if (r12 == null) goto L19;
        this.f17476t = new WeakReference(r12);
        goto L19
    L11:
        if ((getParent() instanceof ViewGroup) == false) goto L17;
        ViewParent r13 = getParent();
        if (r13 == null) goto L16;
        r12 = ((ViewGroup) r13).findViewById(this.f17475s);
        goto L17
    L16:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
    L8:
        r12 = null;
    L19:
        WeakReference r14 = this.f17476t;
        if (r14 != null) goto L23;
        return null;
    L23:
        return (View) r14.get();
    }

    public BaseBehavior.LayoutParams k(AttributeSet r10) {
        return new BaseBehavior.LayoutParams(getContext(), r10);
    }

    public BaseBehavior.LayoutParams l(ViewGroup.LayoutParams r10) {
        return new BaseBehavior.LayoutParams(r10);
    }

    public final boolean m() {
        return this.f17478v;
    }

    public final boolean n() {
        if (getTotalScrollRange() == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean q() {
        return this.f17457a;
    }

    public final WindowInsetsCompat r(WindowInsetsCompat r10) {
        if (ViewCompat.x(this) == false) goto L5;
        WindowInsetsCompat r11 = r10;
    L7:
        if (androidx.core.util.b.a(this.f17477u, r11) == true) goto L9;
        this.f17477u = r11;
        y();
        requestLayout();
    L9:
        return r10;
    L5:
        r11 = null;
        goto L7
    }

    public final void removeOnOffsetChangeListener(@Nullable OnOffsetChangeListener r10) {
        List r11 = this.f17470n;
        if (r11 == null) goto L7;
        y.a(r11).remove(r10);
        return;
    }

    public final void s() {
        addOnOffsetChangeListener(new b(this));
    }

    public final void setBottomAction(@Nullable View r10) {
        this.f17462f = r10;
    }

    public final void setDivider(@Nullable View r10) {
        this.f17466j = r10;
    }

    public final void setExpanded(boolean r10) {
        if (r10 == false) goto L4;
        int r11 = 16;
    L5:
        this.f17469m = r11;
        requestLayout();
        return;
    L4:
        r11 = 1;
        goto L5
    }

    public final void setInDebug(boolean r10) {
        this.f17471o = r10;
    }

    public final void setLeftAction(@Nullable ViewGroup r10) {
        this.f17458b = r10;
    }

    public final void setLeftActionSrc(@Nullable Drawable r10) {
        this.f17464h = r10;
    }

    public final void setMCollapsePosition(int r10) {
        this.f17468l = r10;
    }

    public final void setMOnHeaderFlingUnConsumedListener(@Nullable OnHeaderFlingUnConsumedListener r10) {
        this.f17467k = r10;
    }

    public final void setMTvSubTitle(@Nullable TextView r10) {
        this.f17461e = r10;
    }

    public final void setMTvTitle(@Nullable TextView r10) {
        this.f17460d = r10;
    }

    public final void setOnHeaderFlingUnConsumedListener(@NotNull OnHeaderFlingUnConsumedListener r10) {
        q.g(r10, "onHeaderFlingUnConsumedListener");
        this.f17467k = r10;
    }

    public final void setRightAction(@Nullable ViewGroup r10) {
        this.f17459c = r10;
    }

    public final void setRightActionSrc(@Nullable Drawable r10) {
        this.f17465i = r10;
    }

    public final void setTextInitPos(int r10) {
        this.f17472p = r10;
    }

    public final void setTitleText(@Nullable String r10) {
        this.f17463g = r10;
    }

    public final void t() {
        this.f17469m = 0;
    }

    public final boolean u(boolean r10) {
        return false;
    }

    public final void v() {
        if (this.f17464h == null) goto L6;
        Context r10 = getContext();
        q.f(r10, "context");
        OIconButton r11 = new OIconButton(r10, null, 0, 0, null, 28, null);
        r11.setImageDrawable(getLeftActionSrc());
        setLeftAction(r11);
    L6:
        if (this.f17465i == null) goto L8;
        Context r12 = getContext();
        q.f(r12, "context");
        OIconButton r13 = new OIconButton(r12, null, 0, 0, null, 28, null);
        r13.setImageDrawable(getRightActionSrc());
        setRightAction(r13);
    L8:
        setBackgroundColor(getResources().getColor(R$color.Transparent));
        if (this.f17471o == false) goto L23;
        ViewGroup r14 = this.f17458b;
        if (r14 == null) goto L14;
        r14.setBackgroundColor(getResources().getColor(R$color.oui_blue_2));
    L14:
        ViewGroup r15 = this.f17459c;
        if (r15 == null) goto L18;
        r15.setBackgroundColor(getResources().getColor(R$color.oui_blue_2));
    L18:
        setBackgroundColor(getResources().getColor(R$color.oui_red_2));
        TextView r16 = this.f17460d;
        if (r16 == null) goto L24;
        r16.setBackgroundColor(getResources().getColor(R$color.oui_yellow_1));
        return;
    L24:
        return;
    }

    public final boolean w() {
        if (getTopInset() <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean x(View r10) {
        View r11 = j(r10);
        if (r11 == null) goto L6;
        r10 = r11;
    L6:
        if (r10 != null) goto L8;
    L12:
        return false;
    L8:
        if (r10.canScrollVertically(-1) == false) goto L10;
    L11:
        return true;
    L10:
        if (r10.getScrollY() <= 0) goto L12;
        goto L11
    }

    public final void y() {
        setWillNotDraw(!w());
    }

    public /* synthetic */ OUnitedTitleBar(Context r10, AttributeSet r11, int r12, DefaultConstructorMarker r13) {
        if ((r12 & 2) == 0) goto L5;
        r11 = null;
    L5:
        this(r10, r11);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams r10) {
        return l(r10);
    }

    public final void setLeftAction(@NotNull View r10) {
        q.g(r10, "view");
        ViewGroup r11 = this.f17458b;
        if (r11 == null) goto L6;
        r11.removeAllViews();
    L6:
        ViewGroup r12 = this.f17458b;
        if (r12 == null) goto L11;
        r12.addView(r10);
        return;
    }

    public final void setRightAction(@NotNull View r10) {
        q.g(r10, "view");
        ViewGroup r11 = this.f17459c;
        if (r11 == null) goto L6;
        r11.removeAllViews();
    L6:
        ViewGroup r12 = this.f17459c;
        if (r12 == null) goto L11;
        r12.addView(r10);
        return;
    }

    @JvmOverloads
    public OUnitedTitleBar(@NotNull Context r10, @Nullable AttributeSet r11) {
        q.g(r10, "context");
        super(r10, r11);
        o(r10, r11);
        this.f17473q = -1;
        this.f17474r = -1;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public /* bridge */ /* synthetic */ FrameLayout.LayoutParams generateLayoutParams(AttributeSet r10) {
        return k(r10);
    }
}
