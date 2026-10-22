package com.obric.oui.swipeaction;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Point;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import androidx.core.view.GestureDetectorCompat;
import androidx.core.view.ViewCompat;
import bg.h;
import com.bytedance.apm.constant.CommonKey;
import com.bytedance.common.wschannel.WsConstants;
import com.obric.common.oui.R$styleable;
import com.tmall.wireless.tangram.structure.card.FixCard;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
@Deprecated(message = "使用 OSwipeLayout")
@Metadata(d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b(\n\u0002\u0010\u0006\n\u0002\b\u001e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0017\b\u0007\u0018\u0000 32\u00020\u0001:\u0003Cª\u0001B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000e\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0010\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0010\u0010\u000fJ\u001f\u0010\u0012\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u0014H\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u0014H\u0002¢\u0006\u0004\b\u0018\u0010\u0017J\u0017\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u0014H\u0002¢\u0006\u0004\b\u0019\u0010\u0017J\u0017\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u0015\u001a\u00020\u0014H\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ\u0017\u0010\u001d\u001a\u00020\u001a2\u0006\u0010\u0015\u001a\u00020\u0014H\u0002¢\u0006\u0004\b\u001d\u0010\u001cJ\u0017\u0010\u001e\u001a\u00020\u001a2\u0006\u0010\u0015\u001a\u00020\u0014H\u0002¢\u0006\u0004\b\u001e\u0010\u001cJ\u0017\u0010\u001f\u001a\u00020\u001a2\u0006\u0010\u0015\u001a\u00020\u0014H\u0002¢\u0006\u0004\b\u001f\u0010\u001cJ\u0017\u0010 \u001a\u00020\u001a2\u0006\u0010\u0015\u001a\u00020\u0014H\u0002¢\u0006\u0004\b \u0010\u001cJ\u000f\u0010!\u001a\u00020\nH\u0002¢\u0006\u0004\b!\u0010\fJ\u001f\u0010&\u001a\u00020\u001a2\u0006\u0010#\u001a\u00020\"2\u0006\u0010%\u001a\u00020$H\u0002¢\u0006\u0004\b&\u0010'J#\u0010,\u001a\u0004\u0018\u00010\"2\u0006\u0010)\u001a\u00020(2\b\u0010+\u001a\u0004\u0018\u00010*H\u0002¢\u0006\u0004\b,\u0010-J\u0019\u0010.\u001a\u00020\u001a2\b\u0010#\u001a\u0004\u0018\u00010\"H\u0002¢\u0006\u0004\b.\u0010/J\u0017\u00100\u001a\u00020\u001a2\u0006\u0010)\u001a\u00020(H\u0002¢\u0006\u0004\b0\u00101J\u0017\u00103\u001a\u00020\u001a2\u0006\u00102\u001a\u00020\u0006H\u0002¢\u0006\u0004\b3\u00104J\u000f\u00105\u001a\u00020\nH\u0002¢\u0006\u0004\b5\u0010\fJ/\u0010:\u001a\u00020\n2\u0006\u00106\u001a\u00020\u00062\u0006\u00107\u001a\u00020\u00062\u0006\u00108\u001a\u00020\u00062\u0006\u00109\u001a\u00020\u0006H\u0014¢\u0006\u0004\b:\u0010;J\u0017\u0010<\u001a\u00020\u001a2\u0006\u0010)\u001a\u00020(H\u0016¢\u0006\u0004\b<\u00101J\u0017\u0010>\u001a\u00020\n2\u0006\u0010=\u001a\u00020\u001aH\u0016¢\u0006\u0004\b>\u0010?J\u000f\u0010@\u001a\u00020\nH\u0014¢\u0006\u0004\b@\u0010\fJ\u0017\u0010A\u001a\u00020\u001a2\u0006\u0010)\u001a\u00020(H\u0016¢\u0006\u0004\bA\u00101J\u000f\u0010B\u001a\u00020\nH\u0016¢\u0006\u0004\bB\u0010\fR\"\u0010H\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bC\u00103\u001a\u0004\bD\u0010E\"\u0004\bF\u0010GR\"\u0010N\u001a\u00020\u001a8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bI\u0010J\u001a\u0004\bK\u0010L\"\u0004\bM\u0010?R\"\u0010R\u001a\u00020\u001a8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bO\u0010J\u001a\u0004\bP\u0010L\"\u0004\bQ\u0010?R\u0014\u0010U\u001a\u00020S8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bT\u0010\u0018R\u0016\u0010W\u001a\u00020\u001a8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bV\u0010JR\u0016\u0010Y\u001a\u00020\u001a8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bX\u0010JR\u0014\u0010[\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bZ\u00103R\u0014\u0010\\\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b7\u00103R\u0014\u0010^\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b]\u00103R\u0014\u0010`\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b_\u00103R\u0014\u0010b\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\ba\u00103R\u0014\u0010d\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bc\u00103R\u0014\u0010f\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\be\u00103R\u0016\u0010h\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bg\u00103R$\u0010l\u001a\u00020\u00062\u0006\u0010i\u001a\u00020\u00068\u0002@BX\u0082\u000e¢\u0006\f\n\u0004\bj\u00103\"\u0004\bk\u0010GR\u0016\u0010n\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bm\u00103R\u0016\u0010=\u001a\u00020\u001a8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bo\u0010JR\u0016\u0010q\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bp\u00103R\u0018\u0010u\u001a\u0004\u0018\u00010r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bs\u0010tR\u0018\u0010y\u001a\u0004\u0018\u00010v8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bw\u0010xR\u0016\u0010{\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bz\u00103R\u0016\u0010}\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b|\u00103R\u0016\u0010~\u001a\u00020\u001a8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b6\u0010JR\u0017\u0010\u0080\u0001\u001a\u00020\u001a8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u007f\u0010JR\u001a\u0010\u0082\u0001\u001a\u0004\u0018\u00010\"8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u0012\u0010\u0081\u0001R\u001a\u0010\u0083\u0001\u001a\u0004\u0018\u00010\"8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u000e\u0010\u0081\u0001R\u001a\u0010\u0084\u0001\u001a\u0004\u0018\u00010\"8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u0010\u0010\u0081\u0001R\u0017\u0010\u0085\u0001\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0019\u00103R\u001a\u0010\u0086\u0001\u001a\u0004\u0018\u00010\"8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u0016\u0010\u0081\u0001R\u001a\u0010\u0087\u0001\u001a\u0004\u0018\u00010\"8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u0018\u0010\u0081\u0001R\u0017\u0010\u0088\u0001\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b,\u00103R,\u0010\u0090\u0001\u001a\u0005\u0018\u00010\u0089\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b\u008a\u0001\u0010\u008b\u0001\u001a\u0006\b\u008c\u0001\u0010\u008d\u0001\"\u0006\b\u008e\u0001\u0010\u008f\u0001R\u0017\u0010\u0093\u0001\u001a\u00030\u0091\u00018\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\b\u001d\u0010\u0092\u0001R\u0017\u0010\u0096\u0001\u001a\u00030\u0094\u00018\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\b\u001b\u0010\u0095\u0001R\u0016\u0010\u0098\u0001\u001a\u00020\u001a8BX\u0082\u0004¢\u0006\u0007\u001a\u0005\b\u0097\u0001\u0010LR\u0016\u0010\u0099\u0001\u001a\u00020\u001a8BX\u0082\u0004¢\u0006\u0007\u001a\u0005\b\u008a\u0001\u0010LR\u0016\u0010\u009b\u0001\u001a\u00020\u00068BX\u0082\u0004¢\u0006\u0007\u001a\u0005\b\u009a\u0001\u0010ER\u0016\u0010\u009d\u0001\u001a\u00020\u001a8BX\u0082\u0004¢\u0006\u0007\u001a\u0005\b\u009c\u0001\u0010LR\u0016\u0010\u009f\u0001\u001a\u00020\u001a8BX\u0082\u0004¢\u0006\u0007\u001a\u0005\b\u009e\u0001\u0010LR\u0016\u0010¡\u0001\u001a\u00020\u001a8BX\u0082\u0004¢\u0006\u0007\u001a\u0005\b \u0001\u0010LR\u0016\u0010£\u0001\u001a\u00020\u001a8BX\u0082\u0004¢\u0006\u0007\u001a\u0005\b¢\u0001\u0010LR\u0016\u0010¥\u0001\u001a\u00020\u00068BX\u0082\u0004¢\u0006\u0007\u001a\u0005\b¤\u0001\u0010ER\u0016\u0010§\u0001\u001a\u00020\u00068BX\u0082\u0004¢\u0006\u0007\u001a\u0005\b¦\u0001\u0010ER\u0016\u0010©\u0001\u001a\u00020\u001a8BX\u0082\u0004¢\u0006\u0007\u001a\u0005\b¨\u0001\u0010L¨\u0006«\u0001"}, d2 = {"Lcom/obric/oui/swipeaction/OSwipeActionLayout;", "Landroid/widget/FrameLayout;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "", "S", "()V", "left", "z", "(I)I", "A", "dx", FixCard.FixStyle.KEY_Y, "(II)I", "", "xVel", "C", "(F)I", "D", "B", "", "H", "(F)Z", "G", "M", "L", "K", "R", "Landroid/view/View;", "view", "Landroid/graphics/Point;", "point", "P", "(Landroid/view/View;Landroid/graphics/Point;)Z", "Landroid/view/MotionEvent;", "event", "Landroid/view/ViewGroup;", "rootView", "E", "(Landroid/view/MotionEvent;Landroid/view/ViewGroup;)Landroid/view/View;", "O", "(Landroid/view/View;)Z", "N", "(Landroid/view/MotionEvent;)Z", WsConstants.KEY_CONNECTION_STATE, "I", "(I)Z", "Q", "w", "h", "oldW", "oldH", "onSizeChanged", "(IIII)V", "onInterceptTouchEvent", "disallowIntercept", "requestDisallowInterceptTouchEvent", "(Z)V", "onFinishInflate", "onTouchEvent", "computeScroll", "a", "getDirection", "()I", "setDirection", "(I)V", "direction", "b", "Z", "getSwipeEnabled", "()Z", "setSwipeEnabled", "swipeEnabled", "c", "getContinuousSwipe", "setContinuousSwipe", "continuousSwipe", "", "d", "autoOpenSpeed", "e", "dragAfterOpened", "f", "freeDrag", "g", "rightViewId", "rightViewBgId", "i", "rightItemFirstExpendWidth", "j", "leftViewId", "k", "leftViewBgId", "l", "leftItemFirstExpendWidth", "m", "draggedViewId", "n", "previousUnprocessedPixel", CommonKey.KEY_VALUE, "o", "setRightViewPadding", "rightViewPadding", "p", "leftViewPadding", "q", "r", "curDraggingState", "Landroidx/customview/widget/b;", "s", "Landroidx/customview/widget/b;", "dragHelper", "Landroidx/core/view/GestureDetectorCompat;", "t", "Landroidx/core/view/GestureDetectorCompat;", "gestureDetector", "u", "draggingViewLeft", "v", "horizontalWidth", "leftOpen", FixCard.FixStyle.KEY_X, "rightOpen", "Landroid/view/View;", "draggedView", "rightView", "rightViewBg", "rightFullOpenPending", "leftView", "leftViewBg", "leftFullOpenPending", "Lcom/obric/oui/swipeaction/OSwipeActionLayout$SwipeActionsListener;", "F", "Lcom/obric/oui/swipeaction/OSwipeActionLayout$SwipeActionsListener;", "getActionsListener", "()Lcom/obric/oui/swipeaction/OSwipeActionLayout$SwipeActionsListener;", "setActionsListener", "(Lcom/obric/oui/swipeaction/OSwipeActionLayout$SwipeActionsListener;)V", "actionsListener", "Landroid/view/GestureDetector$OnGestureListener;", "Landroid/view/GestureDetector$OnGestureListener;", "gestureDetectorCallBack", "Landroidx/customview/widget/b$c;", "Landroidx/customview/widget/b$c;", "dragHelperCallback", "J", "isMoving", "isClosed", "getPreviousPosition", "previousPosition", "getRightViewOpened", "rightViewOpened", "getLeftViewOpened", "leftViewOpened", "getRightOpenFinished", "rightOpenFinished", "getLeftOpenFinished", "leftOpenFinished", "getLViewWidth", "lViewWidth", "getRViewWidth", "rViewWidth", "getRightViewEmpty", "rightViewEmpty", "SwipeActionsListener", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OSwipeActionLayout extends FrameLayout {
    public static final a I = null;
    public View A;
    public int B;
    public View C;
    public View D;
    public int E;
    public SwipeActionsListener F;
    public final GestureDetector.OnGestureListener G;
    public final androidx.customview.widget.b.c H;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f17027a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f17028b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f17029c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final double f17030d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f17031e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f17032f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f17033g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f17034h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final int f17035i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final int f17036j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final int f17037k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final int f17038l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final int f17039m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f17040n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f17041o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f17042p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f17043q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f17044r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public androidx.customview.widget.b f17045s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public GestureDetectorCompat f17046t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public int f17047u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f17048v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public boolean f17049w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public boolean f17050x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public View f17051y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public View f17052z;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0018\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH&J\b\u0010\t\u001a\u00020\u0003H&¨\u0006\n"}, d2 = {"Lcom/obric/oui/swipeaction/OSwipeActionLayout$SwipeActionsListener;", "", "onClose", "", "onOpen", "direction", "", "isContinuous", "", "onToOpen", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface SwipeActionsListener {
        void onClose();

        void onOpen(int r10, boolean r11);

        void onToOpen();
    }

    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }

        public a() {
        }
    }

    public static final class b extends androidx.customview.widget.b.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ OSwipeActionLayout f17053a;

        public b(OSwipeActionLayout r10) {
            this.f17053a = r10;
        }

        @Override // androidx.customview.widget.b.c
        public int clampViewPositionHorizontal(View r10, int r11, int r12) {
            q.g(r10, "child");
            if (this.f17053a.getSwipeEnabled() == true) goto L5;
            return 0;
        L5:
            int r13 = this.f17053a.getDirection();
            if (r13 == 1) goto L15;
            if (r13 == 2) goto L17;
            if (r13 == 3) goto L16;
            return 0;
        L16:
            return OSwipeActionLayout.b(this.f17053a, r11, r12);
        L17:
            return OSwipeActionLayout.d(this.f17053a, r11);
        L15:
            return OSwipeActionLayout.c(this.f17053a, r11);
        }

        @Override // androidx.customview.widget.b.c
        public int getViewHorizontalDragRange(View r10) {
            q.g(r10, "child");
            return OSwipeActionLayout.k(this.f17053a);
        }

        @Override // androidx.customview.widget.b.c
        public void onViewDragStateChanged(int r10) {
            if (r10 != OSwipeActionLayout.e(this.f17053a)) goto L6;
            return;
        L6:
            if (OSwipeActionLayout.t(this.f17053a, r10) == false) goto L9;
            OSwipeActionLayout.x(this.f17053a);
        L26:
            OSwipeActionLayout.u(this.f17053a, r10);
            return;
        L9:
            if (r10 != 1) goto L26;
            SwipeActionsListener r11 = this.f17053a.getActionsListener();
            if (r11 == null) goto L15;
            r11.onToOpen();
        L15:
            if (OSwipeActionLayout.q(this.f17053a) == true) goto L21;
            View r12 = OSwipeActionLayout.r(this.f17053a);
            if (r12 == null) goto L21;
            View r13 = OSwipeActionLayout.r(this.f17053a);
            q.d(r13);
            r12.offsetLeftAndRight((r13.getWidth() / 2) * (-1));
        L21:
            if (OSwipeActionLayout.l(this.f17053a) == true) goto L26;
            View r14 = OSwipeActionLayout.m(this.f17053a);
            if (r14 == null) goto L26;
            View r15 = OSwipeActionLayout.m(this.f17053a);
            q.d(r15);
            r14.offsetLeftAndRight(r15.getWidth() / 2);
            goto L26
        }

        @Override // androidx.customview.widget.b.c
        public void onViewPositionChanged(View r10, int r11, int r12, int r13, int r14) {
            q.g(r10, "changedView");
            OSwipeActionLayout.v(this.f17053a, r11);
            int r15 = r13 % 2;
            if (r15 != 0) goto L5;
        L8:
            int r16 = this.f17053a.getDirection();
            if (r16 == 1) goto L26;
            if (r16 != 2) goto L12;
            View r17 = OSwipeActionLayout.n(this.f17053a);
            q.d(r17);
            View r18 = OSwipeActionLayout.g(this.f17053a);
            q.d(r18);
            r17.setRight(r18.getLeft());
            View r19 = OSwipeActionLayout.m(this.f17053a);
            if (r19 == null) goto L35;
            r19.offsetLeftAndRight(r13 / 2);
            return;
        L35:
            return;
        L12:
            if (r16 != 3) goto L33;
            View r20 = OSwipeActionLayout.m(this.f17053a);
            if (r20 == null) goto L18;
            r20.offsetLeftAndRight(r13);
        L18:
            View r21 = OSwipeActionLayout.r(this.f17053a);
            if (r21 == null) goto L34;
            r21.offsetLeftAndRight(r13);
            return;
        L34:
            return;
        L33:
            return;
        L26:
            View r22 = OSwipeActionLayout.s(this.f17053a);
            q.d(r22);
            View r23 = OSwipeActionLayout.g(this.f17053a);
            q.d(r23);
            r22.setLeft(r23.getRight());
            View r24 = OSwipeActionLayout.r(this.f17053a);
            if (r24 == null) goto L36;
            r24.offsetLeftAndRight(r13 / 2);
            return;
        L36:
            return;
        L5:
            if (OSwipeActionLayout.p(this.f17053a) == 0) goto L7;
            r13 = r13 + OSwipeActionLayout.p(this.f17053a);
            OSwipeActionLayout.w(this.f17053a, 0);
            goto L8
        L7:
            OSwipeActionLayout.w(this.f17053a, r15);
            goto L8
        }

        @Override // androidx.customview.widget.b.c
        public void onViewReleased(View r10, float r11, float r12) {
            q.g(r10, "releasedChild");
            if (this.f17053a.getDirection() != 1) goto L6;
            int r13 = OSwipeActionLayout.i(this.f17053a, r11);
        L14:
            androidx.customview.widget.b r14 = OSwipeActionLayout.f(this.f17053a);
            q.d(r14);
            View r15 = OSwipeActionLayout.g(this.f17053a);
            q.d(r15);
            if (r14.O(r13, r15.getTop()) == false) goto L18;
            ViewCompat.g0(this.f17053a);
            return;
        L18:
            return;
        L6:
            if (this.f17053a.getDirection() != 2) goto L9;
            r13 = OSwipeActionLayout.j(this.f17053a, r11);
            goto L14
        L9:
            if (this.f17053a.getDirection() != 3) goto L13;
            r13 = OSwipeActionLayout.h(this.f17053a, r11);
            if (r13 != (-1)) goto L14;
            r13 = OSwipeActionLayout.o(this.f17053a);
            goto L14
        L13:
            r13 = 0;
            goto L14
        }

        @Override // androidx.customview.widget.b.c
        public boolean tryCaptureView(View r10, int r11) {
            q.g(r10, "view");
            View r12 = OSwipeActionLayout.g(this.f17053a);
            if (r12 != null) goto L6;
            return false;
        L6:
            if (r10.getId() != r12.getId()) goto L9;
            return true;
        L9:
            return false;
        }
    }

    public static final class c extends GestureDetector.SimpleOnGestureListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ OSwipeActionLayout f17054a;

        public c(OSwipeActionLayout r10) {
            this.f17054a = r10;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent r10, MotionEvent r11, float r12, float r13) {
            q.g(r10, "e1");
            q.g(r11, "e2");
            ViewParent r14 = this.f17054a.getParent();
            if (r14 == null) goto L8;
            r14.requestDisallowInterceptTouchEvent(true);
            return false;
        L8:
            return false;
        }
    }

    static {
        I = new a(null);
    }

    @JvmOverloads
    public OSwipeActionLayout(@NotNull Context r10) {
        q.g(r10, "context");
        AttributeSet r11 = null;
        int r12 = 0;
        this(r10, r11, r12, 6, null);
    }

    public static /* synthetic */ void a(OSwipeActionLayout r10) {
        m26setupPost$lambda2(r10);
    }

    public static final /* synthetic */ int b(OSwipeActionLayout r10, int r11, int r12) {
        return r10.y(r11, r12);
    }

    public static final /* synthetic */ int c(OSwipeActionLayout r10, int r11) {
        return r10.z(r11);
    }

    public static final /* synthetic */ int d(OSwipeActionLayout r10, int r11) {
        return r10.A(r11);
    }

    public static final /* synthetic */ int e(OSwipeActionLayout r10) {
        return r10.f17044r;
    }

    public static final /* synthetic */ androidx.customview.widget.b f(OSwipeActionLayout r10) {
        return r10.f17045s;
    }

    public static final /* synthetic */ View g(OSwipeActionLayout r10) {
        return r10.f17051y;
    }

    private final int getLViewWidth() {
        return this.f17038l;
    }

    private final boolean getLeftOpenFinished() {
        if (this.f17047u != (this.f17048v - this.E)) goto L5;
        return true;
    L5:
        return false;
    }

    private final boolean getLeftViewOpened() {
        if (this.C != null) goto L5;
    L7:
        return false;
    L5:
        if (this.f17047u != getLViewWidth()) goto L7;
        return true;
    }

    private final int getPreviousPosition() {
        if (this.f17049w == false) goto L6;
        return getLViewWidth();
    L6:
        if (this.f17050x == true) goto L11;
        return 0;
    L11:
        return -getRViewWidth();
    }

    private final int getRViewWidth() {
        return this.f17035i;
    }

    private final boolean getRightOpenFinished() {
        if (this.f17047u != ((-this.f17048v) + this.B)) goto L5;
        return true;
    L5:
        return false;
    }

    private final boolean getRightViewEmpty() {
        if (this.f17052z != null) goto L5;
        return true;
    L5:
        return false;
    }

    private final boolean getRightViewOpened() {
        if (this.f17052z != null) goto L5;
    L7:
        return false;
    L5:
        if (this.f17047u != (-getRViewWidth())) goto L7;
        return true;
    }

    public static final /* synthetic */ int h(OSwipeActionLayout r10, float r11) {
        return r10.B(r11);
    }

    public static final /* synthetic */ int i(OSwipeActionLayout r10, float r11) {
        return r10.C(r11);
    }

    public static final /* synthetic */ int j(OSwipeActionLayout r10, float r11) {
        return r10.D(r11);
    }

    public static final /* synthetic */ int k(OSwipeActionLayout r10) {
        return r10.f17048v;
    }

    public static final /* synthetic */ boolean l(OSwipeActionLayout r10) {
        return r10.f17049w;
    }

    public static final /* synthetic */ View m(OSwipeActionLayout r10) {
        return r10.C;
    }

    public static final /* synthetic */ View n(OSwipeActionLayout r10) {
        return r10.D;
    }

    public static final /* synthetic */ int o(OSwipeActionLayout r10) {
        return r10.getPreviousPosition();
    }

    public static final /* synthetic */ int p(OSwipeActionLayout r10) {
        return r10.f17040n;
    }

    public static final /* synthetic */ boolean q(OSwipeActionLayout r10) {
        return r10.f17050x;
    }

    public static final /* synthetic */ View r(OSwipeActionLayout r10) {
        return r10.f17052z;
    }

    public static final /* synthetic */ View s(OSwipeActionLayout r10) {
        return r10.A;
    }

    private final void setRightViewPadding(int r10) {
        this.f17041o = r10;
        Q();
    }

    /* JADX INFO: renamed from: setupPost$lambda-2, reason: not valid java name */
    private static final void m26setupPost$lambda2(OSwipeActionLayout r10) {
        q.g(r10, "this$0");
        int r11 = r10.f17027a;
        if (r11 != 1) goto L5;
        View r12 = r10.f17052z;
        q.d(r12);
        r12.setX(r10.f17048v);
        return;
    L5:
        if (r11 != 2) goto L7;
        View r13 = r10.C;
        q.d(r13);
        View r14 = r10.C;
        q.d(r14);
        r13.setX(-r14.getWidth());
        return;
    L7:
        if (r11 != 3) goto L15;
        View r15 = r10.f17052z;
        q.d(r15);
        r15.setX(r10.f17048v);
        View r16 = r10.C;
        q.d(r16);
        View r17 = r10.C;
        q.d(r17);
        r16.setX(-r17.getWidth());
        return;
    }

    public static final /* synthetic */ boolean t(OSwipeActionLayout r10, int r11) {
        return r10.I(r11);
    }

    public static final /* synthetic */ void u(OSwipeActionLayout r10, int r11) {
        r10.f17044r = r11;
    }

    public static final /* synthetic */ void v(OSwipeActionLayout r10, int r11) {
        r10.f17047u = r11;
    }

    public static final /* synthetic */ void w(OSwipeActionLayout r10, int r11) {
        r10.f17040n = r11;
    }

    public static final /* synthetic */ void x(OSwipeActionLayout r10) {
        r10.S();
    }

    public final int A(int r10) {
        if (this.f17029c == false) goto L17;
        if (getRightViewEmpty() == false) goto L17;
        if (this.f17032f == false) goto L12;
        int r11 = this.f17048v;
        if (r10 >= (-r11)) goto L41;
        return -r11;
    L41:
        return h.g(r10, r11);
    L12:
        if (r10 >= 0) goto L15;
        return 0;
    L15:
        return h.g(r10, this.f17048v);
    L17:
        if (this.f17031e == false) goto L30;
        if (this.f17032f == false) goto L25;
        int r12 = this.f17048v;
        if (r10 >= (-r12)) goto L24;
        return -r12;
    L24:
        return h.g(r10, r12 - this.f17041o);
    L25:
        if (r10 >= 0) goto L28;
        return 0;
    L28:
        return h.g(r10, this.f17048v - this.f17041o);
    L30:
        if (this.f17032f == false) goto L36;
        int r13 = this.f17048v;
        if (r10 >= (-r13)) goto L35;
        return -r13;
    L35:
        return h.g(r10, getLViewWidth());
    L36:
        if (r10 >= 0) goto L39;
        return 0;
    L39:
        return h.g(r10, getLViewWidth());
    }

    public final int B(float r10) {
        if (L(r10) == false) goto L7;
        return getLViewWidth();
    L7:
        if (M(r10) == false) goto L11;
        return -getRViewWidth();
    L11:
        if (K(r10) == false) goto L14;
        return 0;
    L14:
        return -1;
    }

    public final int C(float r10) {
        if (this.f17029c == true) goto L5;
    L18:
        double r11 = r10;
        double r12 = this.f17030d;
        if (r11 <= r12) goto L22;
        return 0;
    L22:
        if (r11 < (-r12)) goto L34;
        int r13 = this.f17047u;
        if (r13 < 0) goto L27;
    L29:
        int r14 = this.f17047u;
        if (r14 >= 0) goto L35;
        Math.abs(r14);
        int r15 = getRViewWidth() / 2;
        return 0;
    L35:
        return 0;
    L27:
        if (Math.abs(r13) <= (getRViewWidth() / 2)) goto L29;
    L34:
        return -getRViewWidth();
    L5:
        if (getRightViewEmpty() == false) goto L15;
        int r16 = this.f17047u;
        if (r16 >= 0) goto L11;
        if (Math.abs(r16) <= (this.f17048v / 2)) goto L11;
    L13:
        return (-this.f17048v) + this.B;
    L11:
        if (r10 < (-this.f17030d)) goto L13;
        return 0;
    L15:
        if (G(r10) == false) goto L18;
        return (-this.f17048v) + this.B;
    }

    public final int D(float r10) {
        if (this.f17029c == true) goto L5;
    L18:
        double r11 = r10;
        double r12 = this.f17030d;
        if (r11 > r12) goto L34;
        if (r11 < (-r12)) goto L36;
        int r13 = this.f17047u;
        if (r13 > 0) goto L27;
    L29:
        int r14 = this.f17047u;
        if (r14 <= 0) goto L35;
        Math.abs(r14);
        int r15 = getLViewWidth() / 2;
        return 0;
    L35:
        return 0;
    L27:
        if (Math.abs(r13) <= (getLViewWidth() / 2)) goto L29;
    L36:
        return 0;
    L34:
        return getLViewWidth();
    L5:
        if (getRightViewEmpty() == false) goto L15;
        int r16 = this.f17047u;
        if (r16 <= 0) goto L11;
        if (Math.abs(r16) <= (this.f17048v / 2)) goto L11;
    L13:
        return this.f17048v - this.E;
    L11:
        if (r10 > this.f17030d) goto L13;
        return 0;
    L15:
        if (H(r10) == false) goto L18;
        return this.f17048v - this.E;
    }

    public final View E(MotionEvent r10, ViewGroup r11) {
        q.d(r11);
        if (r11.onInterceptTouchEvent(r10) == false) goto L5;
        return r11;
    L5:
        int r12 = r11.getChildCount();
        int r13 = 0;
    L6:
        if (r13 >= r12) goto L12;
        int r14 = r13 + 1;
        View r15 = r11.getChildAt(r13);
        q.f(r15, "rootView.getChildAt(i)");
        if (O(r15) == true) goto L11;
        r13 = r14;
        goto L6
    L11:
        return E(r10, (ViewGroup) r15);
    L12:
        return null;
    }

    public final boolean F() {
        if (this.f17047u != 0) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean G(float r10) {
        if (r10 < (-this.f17030d)) goto L5;
    L6:
        int r11 = this.f17047u;
        if (r11 < 0) goto L9;
    L11:
        return false;
    L9:
        if (Math.abs(r11) <= (this.f17048v / 2)) goto L11;
    L10:
        return true;
    L5:
        if (Math.abs(this.f17047u) > getRViewWidth()) goto L10;
        goto L6
    }

    public final boolean H(float r10) {
        if (r10 > this.f17030d) goto L5;
    L6:
        int r11 = this.f17047u;
        if (r11 > 0) goto L9;
    L11:
        return false;
    L9:
        if (Math.abs(r11) <= (this.f17048v / 2)) goto L11;
    L10:
        return true;
    L5:
        if (Math.abs(this.f17047u) > getLViewWidth()) goto L10;
        goto L6
    }

    public final boolean I(int r10) {
        int r11 = this.f17044r;
        if (r11 != 1) goto L5;
    L6:
        if (r10 == 0) goto L10;
    L8:
        return false;
    L10:
        return true;
    L5:
        if (r11 != 2) goto L8;
        goto L6
    }

    public final boolean J() {
        int r10 = this.f17044r;
        if (r10 != 1) goto L5;
        return true;
    L5:
        if (r10 == 2) goto L10;
        return false;
    L10:
        return true;
    }

    public final boolean K(float r10) {
        int r11 = this.f17047u;
        if (r11 >= 0) goto L5;
    L6:
        if (r11 <= 0) goto L8;
    L9:
        if (r11 >= 0) goto L11;
    L12:
        int r12 = this.f17047u;
        if (r12 <= 0) goto L15;
    L17:
        return false;
    L15:
        if (Math.abs(r12) >= (getRViewWidth() / 2)) goto L17;
    L16:
        return true;
    L11:
        if (Math.abs(r11) < (getLViewWidth() / 2)) goto L16;
    L8:
        if (r10 > this.f17030d) goto L16;
    L5:
        if (r10 < (-this.f17030d)) goto L16;
        goto L6
    }

    public final boolean L(float r10) {
        if (r10 >= 0.0f) goto L5;
        return false;
    L5:
        int r11 = this.f17047u;
        if (r11 > 0) goto L8;
    L9:
        if (r11 > 0) goto L11;
        return false;
    L11:
        if (Math.abs(r11) <= (getLViewWidth() / 2)) goto L15;
    L12:
        return true;
    L15:
        return false;
    L8:
        if (r10 > this.f17030d) goto L12;
        goto L9
    }

    public final boolean M(float r10) {
        if (r10 <= 0.0f) goto L5;
        return false;
    L5:
        int r11 = this.f17047u;
        if (r11 < 0) goto L8;
    L9:
        if (r11 < 0) goto L11;
        return false;
    L11:
        if (Math.abs(r11) <= (getRViewWidth() / 2)) goto L15;
    L12:
        return true;
    L15:
        return false;
    L8:
        if (r10 < (-this.f17030d)) goto L12;
        goto L9
    }

    public final boolean N(MotionEvent r10) {
        int[] r11 = new int[2];
        View r12 = this.f17051y;
        q.d(r12);
        r12.getLocationOnScreen(r11);
        int r13 = r11[1];
        View r14 = this.f17051y;
        q.d(r14);
        int r15 = r13 + r14.getMeasuredHeight();
        int r16 = r11[1];
        int r17 = (int) r10.getRawY();
        if ((r16 + 1) > r17) goto L7;
        if (r17 >= r15) goto L7;
        return true;
    L7:
        return false;
    }

    public final boolean O(View r10) {
        return r10 instanceof ViewGroup;
    }

    public final boolean P(View r10, Point r11) {
        if (r11.y >= r10.getTop()) goto L5;
    L11:
        return false;
    L5:
        if (r11.y >= r10.getBottom()) goto L11;
        if (r11.x < r10.getLeft()) goto L11;
        if (r11.y >= r10.getRight()) goto L11;
        return true;
    }

    public final void Q() {
        if (this.f17029c == false) goto L8;
        if (this.f17027a == 3) goto L8;
        this.f17031e = true;
    L8:
        if (this.f17027a != 3) goto L11;
        setRightViewPadding(0);
        this.f17042p = 0;
        return;
    }

    public final void R() {
        post(new com.obric.oui.swipeaction.a(this));
    }

    public final void S() {
        if (F() == false) goto L18;
        this.f17049w = false;
        this.f17050x = false;
        SwipeActionsListener r10 = this.F;
        if (r10 == null) goto L8;
        r10.onClose();
    L8:
        View r11 = this.f17052z;
        if (r11 == null) goto L12;
        r11.layout(0, r11.getTop(), r11.getWidth(), r11.getBottom());
    L12:
        View r12 = this.C;
        if (r12 == null) goto L16;
        r12.layout(0, r12.getTop(), r12.getWidth(), r12.getBottom());
    L16:
        this.f17040n = 0;
        return;
    L18:
        if (getLeftOpenFinished() == false) goto L20;
    L30:
        this.f17049w = true;
        this.f17050x = false;
        SwipeActionsListener r13 = this.F;
        if (r13 == null) goto L39;
        r13.onOpen(2, getLeftOpenFinished());
        return;
    L39:
        return;
    L20:
        if (getLeftViewOpened() == true) goto L30;
        if (getRightOpenFinished() == false) goto L25;
    L26:
        this.f17049w = false;
        this.f17050x = true;
        SwipeActionsListener r14 = this.F;
        if (r14 == null) goto L38;
        r14.onOpen(1, getRightOpenFinished());
        return;
    L38:
        return;
    L25:
        if (getRightViewOpened() == true) goto L26;
    }

    @Override // android.view.View
    public void computeScroll() {
        androidx.customview.widget.b r10 = this.f17045s;
        q.d(r10);
        if (r10.n(true) == false) goto L6;
        ViewCompat.g0(this);
        return;
    }

    @Nullable
    public final SwipeActionsListener getActionsListener() {
        return this.F;
    }

    public final boolean getContinuousSwipe() {
        return this.f17029c;
    }

    public final int getDirection() {
        return this.f17027a;
    }

    public final boolean getSwipeEnabled() {
        return this.f17028b;
    }

    @Override // android.view.View
    public void onFinishInflate() {
        int r10 = this.f17039m;
        if (r10 == 0) goto L5;
        this.f17051y = findViewById(r10);
    L5:
        int r11 = this.f17036j;
        if (r11 == 0) goto L8;
        this.C = findViewById(r11);
    L8:
        int r12 = this.f17033g;
        if (r12 == 0) goto L11;
        this.f17052z = findViewById(r12);
    L11:
        int r13 = this.f17034h;
        if (r13 == 0) goto L14;
        this.A = findViewById(r13);
    L14:
        int r14 = this.f17037k;
        if (r14 == 0) goto L18;
        this.D = findViewById(r14);
    L18:
        if (this.f17051y == null) goto L61;
        int r15 = this.f17027a;
        if (r15 != 1) goto L27;
        if (this.f17052z != null) goto L27;
        throw new RuntimeException("'oui_sal_rightItem' must be specified");
    L27:
        if (r15 == 2) goto L29;
    L33:
        if (r15 == 1) goto L35;
    L41:
        if (r15 != 2) goto L50;
        if (this.f17029c == true) goto L50;
        if (this.C != null) goto L50;
        throw new RuntimeException("Must be specified 'oui_sal_leftItem'  or flag oui_sal_continuousSwipe = true");
    L50:
        if (r15 == 3) goto L52;
    L58:
        this.f17045s = androidx.customview.widget.b.o(this, 1.0f, this.H);
        this.f17046t = new GestureDetectorCompat(getContext(), this.G);
        R();
        super.onFinishInflate();
        return;
    L52:
        if (this.f17052z == null) goto L57;
        if (this.C != null) goto L58;
    L57:
        throw new RuntimeException("'oui_sal_leftItem' and 'oui_sal_rightItem' must be specified");
    L35:
        if (this.f17029c == true) goto L41;
        if (this.f17052z != null) goto L41;
        throw new RuntimeException("Must be specified 'oui_sal_rightItem' or flag oui_sal_continuousSwipe = true");
    L29:
        if (this.C != null) goto L33;
        throw new RuntimeException("'oui_sal_leftItem' must be specified");
    L61:
        throw new RuntimeException("'oui_sal_draggedItem' must be specified");
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent r10) {
        q.g(r10, "event");
        if (this.f17043q == false) goto L12;
        if (O(this.f17051y) == false) goto L12;
        View r11 = E(r10, (ViewGroup) this.f17051y);
        Point r12 = new Point((int) r10.getX(), (int) r10.getY());
        if (r11 == null) goto L12;
        if (P(r11, r12) == false) goto L12;
        return false;
    L12:
        if (N(r10) == false) goto L17;
        androidx.customview.widget.b r13 = this.f17045s;
        q.d(r13);
        if (r13.P(r10) == false) goto L18;
        return true;
    L18:
        return false;
    L17:
        return false;
    }

    @Override // android.view.View
    public void onSizeChanged(int r10, int r11, int r12, int r13) {
        this.f17048v = r10;
        super.onSizeChanged(r10, r11, r12, r13);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent r10) {
        q.g(r10, "event");
        if (N(r10) == false) goto L5;
    L8:
        GestureDetectorCompat r11 = this.f17046t;
        q.d(r11);
        r11.a(r10);
        androidx.customview.widget.b r12 = this.f17045s;
        q.d(r12);
        r12.processTouchEvent(r10);
        return true;
    L5:
        if (J() == true) goto L8;
        return super.onTouchEvent(r10);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean r10) {
        super.requestDisallowInterceptTouchEvent(r10);
        this.f17043q = r10;
    }

    public final void setActionsListener(@Nullable SwipeActionsListener r10) {
        this.F = r10;
    }

    public final void setContinuousSwipe(boolean r10) {
        this.f17029c = r10;
    }

    public final void setDirection(int r10) {
        this.f17027a = r10;
    }

    public final void setSwipeEnabled(boolean r10) {
        this.f17028b = r10;
    }

    public final int y(int r10, int r11) {
        boolean r12 = this.f17032f;
        if (r12 == false) goto L5;
    L9:
        if (r12 == false) goto L11;
    L15:
        boolean r13 = this.f17031e;
        if (r13 == true) goto L20;
        if (r10 <= 0) goto L20;
        return h.g(r10, getLViewWidth());
    L20:
        if (r13 == true) goto L24;
        if (r10 >= 0) goto L24;
        return h.d(r10, -getRViewWidth());
    L24:
        if (r10 >= 0) goto L27;
        return h.d(r10, this.f17042p - this.f17048v);
    L27:
        return h.g(r10, this.f17048v - this.f17041o);
    L11:
        if (this.f17050x == false) goto L15;
        if (r11 <= 0) goto L15;
        return h.g(r10, 0);
    L5:
        if (this.f17049w == false) goto L9;
        if (r11 >= 0) goto L9;
        return h.d(r10, 0);
    }

    public final int z(int r10) {
        if (this.f17029c == false) goto L17;
        if (getRightViewEmpty() == false) goto L17;
        if (this.f17032f == false) goto L12;
        int r11 = this.f17048v;
        if (r10 <= r11) goto L40;
        return 0;
    L40:
        return h.d(r10, -r11);
    L12:
        if (r10 <= 0) goto L15;
        return 0;
    L15:
        return h.d(r10, -this.f17048v);
    L17:
        if (this.f17031e == false) goto L30;
        if (this.f17032f == false) goto L25;
        int r12 = this.f17048v;
        if (r10 <= r12) goto L24;
        return 0;
    L24:
        return h.d(r10, this.f17042p - r12);
    L25:
        if (r10 <= 0) goto L28;
        return 0;
    L28:
        return h.d(r10, this.f17042p - this.f17048v);
    L30:
        if (this.f17032f == true) goto L32;
        if (r10 <= 0) goto L39;
        return 0;
    L39:
        return h.d(r10, -getRViewWidth());
    L32:
        if (r10 <= this.f17048v) goto L35;
        return 0;
    L35:
        return h.d(r10, -getRViewWidth());
    }

    @JvmOverloads
    public OSwipeActionLayout(@NotNull Context r10, @Nullable AttributeSet r11) {
        q.g(r10, "context");
        int r12 = 0;
        this(r10, r11, r12, 4, null);
    }

    public /* synthetic */ OSwipeActionLayout(Context r10, AttributeSet r11, int r12, int r13, DefaultConstructorMarker r14) {
        if ((r13 & 2) == 0) goto L6;
        r11 = null;
    L6:
        if ((r13 & 4) == 0) goto L8;
        r12 = 0;
    L8:
        this(r10, r11, r12);
    }

    @JvmOverloads
    public OSwipeActionLayout(@NotNull Context r10, @Nullable AttributeSet r11, int r12) {
        q.g(r10, "context");
        super(r10, r11, r12);
        this.f17027a = 1;
        this.f17043q = true;
        TypedArray r13 = getContext().obtainStyledAttributes(r11, R$styleable.OSwipeActionLayout);
        q.f(r13, "getContext().obtainStyle…eable.OSwipeActionLayout)");
        this.f17027a = 1;
        this.f17028b = r13.getBoolean(R$styleable.OSwipeActionLayout_oui_sal_swipeEnabled, true);
        this.f17029c = r13.getBoolean(R$styleable.OSwipeActionLayout_oui_sal_continuousSwipe, true);
        this.f17030d = r13.getInt(R$styleable.OSwipeActionLayout_oui_sal_autoMovingSensitivity, 1000);
        this.f17031e = r13.getBoolean(R$styleable.OSwipeActionLayout_oui_sal_dragAfterOpened, false);
        this.f17032f = r13.getBoolean(R$styleable.OSwipeActionLayout_oui_sal_freeDrag, true);
        this.f17033g = r13.getResourceId(R$styleable.OSwipeActionLayout_oui_sal_rightItem, 0);
        this.f17034h = r13.getResourceId(R$styleable.OSwipeActionLayout_oui_sal_rightItem_bg, 0);
        this.f17035i = (int) r13.getDimension(R$styleable.OSwipeActionLayout_oui_sal_rightItem_first_expand_width, 0.0f);
        this.B = (int) r13.getDimension(R$styleable.OSwipeActionLayout_oui_sal_rightItem_full_open_pending, 0.0f);
        this.f17036j = r13.getResourceId(R$styleable.OSwipeActionLayout_oui_sal_leftItem, 0);
        this.f17037k = r13.getResourceId(R$styleable.OSwipeActionLayout_oui_sal_leftItem_bg, 0);
        this.f17038l = (int) r13.getDimension(R$styleable.OSwipeActionLayout_oui_sal_leftItem_first_expand_width, 0.0f);
        this.E = (int) r13.getDimension(R$styleable.OSwipeActionLayout_oui_sal_leftItem_full_open_pending, 0.0f);
        this.f17039m = r13.getResourceId(R$styleable.OSwipeActionLayout_oui_sal_draggedItem, 0);
        setRightViewPadding((int) r13.getDimension(R$styleable.OSwipeActionLayout_oui_sal_rightViewPadding, 0.0f));
        this.f17042p = (int) r13.getDimension(R$styleable.OSwipeActionLayout_oui_sal_leftViewPadding, 0.0f);
        Q();
        r13.recycle();
        this.G = new c(this);
        this.H = new b(this);
    }
}
