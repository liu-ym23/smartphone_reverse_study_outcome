package com.stepos.widget.toolbar;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import android.widget.LinearLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.RecyclerView;
import com.stepos.widget.R;
import com.stepos.widget.toolbar.StepOSAppBarLayout;
import java.lang.ref.WeakReference;
import kotlin.C4848b;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.internal.Ref$IntRef;
import p9.InterfaceC5063a;
import r9.C5227b;
import v9.C5685n;

@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\b\u0016\u0018\u00002\u00020\u00012\u00020\u0002:\u0001/B1\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007\u0012\b\b\u0002\u0010\t\u001a\u00020\u0007¢\u0006\u0004\b\n\u0010\u000bJ\u0013\u0010\r\u001a\u0006\u0012\u0002\b\u00030\fH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\r\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\b\u0010\u0010\u0011J\r\u0010\u0012\u001a\u00020\u000f¢\u0006\u0004\b\u0012\u0010\u0011J\r\u0010\u0013\u001a\u00020\u000f¢\u0006\u0004\b\u0013\u0010\u0011J\r\u0010\u0015\u001a\u00020\u0014¢\u0006\u0004\b\u0015\u0010\u0016J\u0015\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0017\u001a\u00020\u000f¢\u0006\u0004\b\u0019\u0010\u001aJ\u0015\u0010\u001b\u001a\u00020\u00182\u0006\u0010\u0017\u001a\u00020\u000f¢\u0006\u0004\b\u001b\u0010\u001aJ\u0015\u0010\u001c\u001a\u00020\u00182\u0006\u0010\u0017\u001a\u00020\u000f¢\u0006\u0004\b\u001c\u0010\u001aJ\u000f\u0010\u001e\u001a\u0004\u0018\u00010\u001d¢\u0006\u0004\b\u001e\u0010\u001fJ\u000f\u0010!\u001a\u0004\u0018\u00010 ¢\u0006\u0004\b!\u0010\"R\u001b\u0010(\u001a\u00020#8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'R\u0016\u0010)\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b)\u0010*R\u0016\u0010+\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b+\u0010*R\u0016\u0010,\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b,\u0010*R\u0016\u0010-\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b-\u0010.¨\u00060"}, d2 = {"Lcom/stepos/widget/toolbar/StepOSAppBarLayout;", "Landroid/widget/LinearLayout;", "Landroidx/coordinatorlayout/widget/CoordinatorLayout$b;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "defStyleRes", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "Landroidx/coordinatorlayout/widget/CoordinatorLayout$c;", "getBehavior", "()Landroidx/coordinatorlayout/widget/CoordinatorLayout$c;", "", "isSnapEnabled", "()Z", "isDragEnabled", "isNestedScrollEnabled", "", "getSnapDelay", "()J", x5.d.EXTRA_ENABLED, "LY8/t;", "setSnapEnabled", "(Z)V", "setDragEnabled", "setNestedScrollEnabled", "Lcom/stepos/widget/toolbar/StepOSCollapsingTitleBar;", "findCollapsingTitleBar", "()Lcom/stepos/widget/toolbar/StepOSCollapsingTitleBar;", "Lcom/stepos/widget/toolbar/StepOSTitleBar;", "findTitleBar", "()Lcom/stepos/widget/toolbar/StepOSTitleBar;", "Lcom/stepos/widget/toolbar/StepOSAppBarLayout$Behavior;", "attachedBehavior$delegate", "LY8/h;", "getAttachedBehavior", "()Lcom/stepos/widget/toolbar/StepOSAppBarLayout$Behavior;", "attachedBehavior", "snapEnabled", "Z", "dragEnabled", "nestedScrollEnabled", "snapDelay", "J", "Behavior", "StepOSWidget_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes4.dex */
public class StepOSAppBarLayout extends LinearLayout implements CoordinatorLayout.b {

    /* renamed from: attachedBehavior$delegate, reason: from kotlin metadata */
    private final Y8.h attachedBehavior;
    private boolean dragEnabled;
    private boolean nestedScrollEnabled;
    private long snapDelay;
    private boolean snapEnabled;

    @Metadata(d1 = {"\u0000\u008a\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0015\n\u0002\b!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 |2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001|B\t\b\u0016¢\u0006\u0004\b\u0003\u0010\u0004B\u0019\b\u0016\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\u0003\u0010\tJ\u0017\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u000e\u0010\u0004J\u000f\u0010\u000f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u000f\u0010\u0004J\u000f\u0010\u0010\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u0010\u0010\u0004J\u001f\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u0011H\u0002¢\u0006\u0004\b\u0014\u0010\u0015J'\u0010\u001a\u001a\u00020\u00112\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0013\u001a\u00020\u00112\u0006\u0010\u0019\u001a\u00020\u0018H\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ'\u0010\u001d\u001a\u00020\u00112\u0006\u0010\u0017\u001a\u00020\u001c2\u0006\u0010\u0013\u001a\u00020\u00112\u0006\u0010\u0019\u001a\u00020\u0018H\u0002¢\u0006\u0004\b\u001d\u0010\u001eJ\u001f\u0010\u001f\u001a\u00020\u000b2\u0006\u0010\u0017\u001a\u00020\u001c2\u0006\u0010\u0019\u001a\u00020\u0018H\u0002¢\u0006\u0004\b\u001f\u0010 J\u000f\u0010!\u001a\u00020\u000bH\u0002¢\u0006\u0004\b!\u0010\u0004J\u001f\u0010#\u001a\u00020\u000b2\u0006\u0010\u0017\u001a\u00020\u001c2\u0006\u0010\"\u001a\u00020\u0011H\u0002¢\u0006\u0004\b#\u0010$J\u0017\u0010%\u001a\u00020\u000b2\u0006\u0010\u0017\u001a\u00020\u001cH\u0002¢\u0006\u0004\b%\u0010&J\u0019\u0010'\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0017\u001a\u00020\u001cH\u0002¢\u0006\u0004\b'\u0010(J\u001f\u0010)\u001a\u00020\u000b2\u0006\u0010\u0017\u001a\u00020\u001c2\u0006\u0010\u0019\u001a\u00020\u0018H\u0002¢\u0006\u0004\b)\u0010 J'\u0010+\u001a\u00020\u000b2\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010*\u001a\u00020\u00112\u0006\u0010\u0019\u001a\u00020\u0018H\u0002¢\u0006\u0004\b+\u0010,J\u001f\u0010-\u001a\u00020\u000b2\u0006\u0010\u0017\u001a\u00020\u001c2\u0006\u0010\u0019\u001a\u00020\u0018H\u0002¢\u0006\u0004\b-\u0010 J'\u00102\u001a\u0002012\u0006\u0010.\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u00100\u001a\u00020/H\u0002¢\u0006\u0004\b2\u00103J\u001f\u00104\u001a\u0002012\u0006\u0010\n\u001a\u00020\u00022\u0006\u00100\u001a\u00020/H\u0002¢\u0006\u0004\b4\u00105J'\u0010:\u001a\u0002012\u0006\u00106\u001a\u00020\u00162\u0006\u00108\u001a\u0002072\u0006\u00109\u001a\u000207H\u0002¢\u0006\u0004\b:\u0010;J?\u0010A\u001a\u0002012\u0006\u0010=\u001a\u00020<2\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010>\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010?\u001a\u00020\u00112\u0006\u0010@\u001a\u00020\u0011H\u0016¢\u0006\u0004\bA\u0010BJG\u0010F\u001a\u00020\u000b2\u0006\u0010=\u001a\u00020<2\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010C\u001a\u00020\u00112\u0006\u0010\"\u001a\u00020\u00112\u0006\u0010E\u001a\u00020D2\u0006\u0010@\u001a\u00020\u0011H\u0016¢\u0006\u0004\bF\u0010GJW\u0010L\u001a\u00020\u000b2\u0006\u0010=\u001a\u00020<2\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010H\u001a\u00020\u00112\u0006\u0010I\u001a\u00020\u00112\u0006\u0010J\u001a\u00020\u00112\u0006\u0010K\u001a\u00020\u00112\u0006\u0010@\u001a\u00020\u00112\u0006\u0010E\u001a\u00020DH\u0016¢\u0006\u0004\bL\u0010MJ7\u0010P\u001a\u0002012\u0006\u0010=\u001a\u00020<2\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010N\u001a\u0002072\u0006\u0010O\u001a\u000207H\u0016¢\u0006\u0004\bP\u0010QJ?\u0010R\u001a\u0002012\u0006\u0010=\u001a\u00020<2\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010N\u001a\u0002072\u0006\u0010O\u001a\u0002072\u0006\u0010E\u001a\u000201H\u0016¢\u0006\u0004\bR\u0010SJ/\u0010T\u001a\u00020\u000b2\u0006\u0010=\u001a\u00020<2\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010@\u001a\u00020\u0011H\u0016¢\u0006\u0004\bT\u0010UJ'\u0010W\u001a\u0002012\u0006\u0010=\u001a\u00020<2\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010V\u001a\u00020/H\u0016¢\u0006\u0004\bW\u0010XJ'\u0010Y\u001a\u0002012\u0006\u0010=\u001a\u00020<2\u0006\u0010\n\u001a\u00020\u00022\u0006\u00100\u001a\u00020/H\u0016¢\u0006\u0004\bY\u0010XJ'\u0010[\u001a\u0002012\u0006\u0010=\u001a\u00020<2\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010Z\u001a\u00020\u0011H\u0016¢\u0006\u0004\b[\u0010\\J\u000f\u0010]\u001a\u00020\u000bH\u0016¢\u0006\u0004\b]\u0010\u0004R\u0016\u0010^\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b^\u0010_R\u0016\u0010`\u001a\u0002078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b`\u0010aR\u0016\u0010b\u001a\u0002018\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bb\u0010cR\u0016\u0010d\u001a\u0002018\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bd\u0010cR\u0016\u0010e\u001a\u0002018\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\be\u0010cR\u0018\u0010g\u001a\u0004\u0018\u00010f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bg\u0010hR\u001e\u0010j\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010i8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bj\u0010kR\u001e\u0010l\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010i8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bl\u0010kR\u001e\u0010m\u001a\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010i8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bm\u0010kR\u001e\u0010n\u001a\n\u0012\u0004\u0012\u00020\u001c\u0018\u00010i8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bn\u0010kR\u0018\u0010p\u001a\u0004\u0018\u00010o8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bp\u0010qR\u0016\u0010r\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\br\u0010_R\u0016\u0010s\u001a\u0002018\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bs\u0010cR\u0016\u0010t\u001a\u0002018\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bt\u0010cR\u0016\u0010u\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bu\u0010_R\u0016\u0010v\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bv\u0010_R\u0016\u0010w\u001a\u0002018\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bw\u0010cR\u0018\u0010x\u001a\u0004\u0018\u00010f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bx\u0010hR\u0018\u0010z\u001a\u0004\u0018\u00010y8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bz\u0010{¨\u0006}"}, d2 = {"Lcom/stepos/widget/toolbar/StepOSAppBarLayout$Behavior;", "Landroidx/coordinatorlayout/widget/CoordinatorLayout$c;", "Lcom/stepos/widget/toolbar/StepOSAppBarLayout;", "<init>", "()V", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "child", "LY8/t;", "cancelPendingSnap", "(Lcom/stepos/widget/toolbar/StepOSAppBarLayout;)V", "cancelSnapAnimator", "cancelRecyclerSnap", "cancelRecyclerSnapSettle", "", "offset", "expandRange", "snapTarget", "(II)I", "Landroid/view/View;", "target", "Lcom/stepos/widget/toolbar/StepOSCollapsingTitleBar;", "titleBar", "contentScrollOffset", "(Landroid/view/View;ILcom/stepos/widget/toolbar/StepOSCollapsingTitleBar;)I", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerViewScrollOffset", "(Landroidx/recyclerview/widget/RecyclerView;ILcom/stepos/widget/toolbar/StepOSCollapsingTitleBar;)I", "attachRecyclerTracker", "(Landroidx/recyclerview/widget/RecyclerView;Lcom/stepos/widget/toolbar/StepOSCollapsingTitleBar;)V", "detachRecyclerTracker", "dy", "updateRecyclerOffsetFromScroll", "(Landroidx/recyclerview/widget/RecyclerView;I)V", "syncRecyclerOffsetFromLayout", "(Landroidx/recyclerview/widget/RecyclerView;)V", "exactRecyclerOffset", "(Landroidx/recyclerview/widget/RecyclerView;)Ljava/lang/Integer;", "applyRecyclerTitleOffset", "scrollY", "smoothScrollTo", "(Landroid/view/View;ILcom/stepos/widget/toolbar/StepOSCollapsingTitleBar;)V", "finishRecyclerSnap", "appBar", "Landroid/view/MotionEvent;", "event", "", "isActionPoint", "(Lcom/stepos/widget/toolbar/StepOSAppBarLayout;Lcom/stepos/widget/toolbar/StepOSCollapsingTitleBar;Landroid/view/MotionEvent;)Z", "isInsideChild", "(Lcom/stepos/widget/toolbar/StepOSAppBarLayout;Landroid/view/MotionEvent;)Z", "view", "", "x", "y", "isInside", "(Landroid/view/View;FF)Z", "Landroidx/coordinatorlayout/widget/CoordinatorLayout;", "parent", "directTargetChild", "axes", "type", "onStartNestedScroll", "(Landroidx/coordinatorlayout/widget/CoordinatorLayout;Lcom/stepos/widget/toolbar/StepOSAppBarLayout;Landroid/view/View;Landroid/view/View;II)Z", "dx", "", "consumed", "onNestedPreScroll", "(Landroidx/coordinatorlayout/widget/CoordinatorLayout;Lcom/stepos/widget/toolbar/StepOSAppBarLayout;Landroid/view/View;II[II)V", "dxConsumed", "dyConsumed", "dxUnconsumed", "dyUnconsumed", "onNestedScroll", "(Landroidx/coordinatorlayout/widget/CoordinatorLayout;Lcom/stepos/widget/toolbar/StepOSAppBarLayout;Landroid/view/View;IIIII[I)V", "velocityX", "velocityY", "onNestedPreFling", "(Landroidx/coordinatorlayout/widget/CoordinatorLayout;Lcom/stepos/widget/toolbar/StepOSAppBarLayout;Landroid/view/View;FF)Z", "onNestedFling", "(Landroidx/coordinatorlayout/widget/CoordinatorLayout;Lcom/stepos/widget/toolbar/StepOSAppBarLayout;Landroid/view/View;FFZ)Z", "onStopNestedScroll", "(Landroidx/coordinatorlayout/widget/CoordinatorLayout;Lcom/stepos/widget/toolbar/StepOSAppBarLayout;Landroid/view/View;I)V", "ev", "onInterceptTouchEvent", "(Landroidx/coordinatorlayout/widget/CoordinatorLayout;Lcom/stepos/widget/toolbar/StepOSAppBarLayout;Landroid/view/MotionEvent;)Z", "onTouchEvent", "layoutDirection", "onLayoutChild", "(Landroidx/coordinatorlayout/widget/CoordinatorLayout;Lcom/stepos/widget/toolbar/StepOSAppBarLayout;I)Z", "onDetachedFromLayoutParams", "touchSlop", "I", "lastTouchY", "F", "dragging", "Z", "ignoreTouch", "touchStartedInChild", "Ljava/lang/Runnable;", "pendingSnapRunnable", "Ljava/lang/Runnable;", "Ljava/lang/ref/WeakReference;", "scrollTargetRef", "Ljava/lang/ref/WeakReference;", "behaviorHostRef", "titleBarRef", "recyclerTargetRef", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "recyclerScrollListener", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "recyclerAbsoluteOffset", "recyclerOffsetKnown", "recyclerSnapInProgress", "recyclerSnapTarget", "recyclerSnapRange", "suppressRecyclerTracking", "recyclerSnapSettleRunnable", "Landroid/animation/ValueAnimator;", "snapAnimator", "Landroid/animation/ValueAnimator;", "Companion", "StepOSWidget_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Behavior extends CoordinatorLayout.c<StepOSAppBarLayout> {
        private static final Companion Companion = new Companion(null);
        private static final long SNAP_ANIMATION_DURATION_MILLIS = 250;
        private static final long SNAP_SETTLE_GRACE_MILLIS = 180;
        private WeakReference<StepOSAppBarLayout> behaviorHostRef;
        private boolean dragging;
        private boolean ignoreTouch;
        private float lastTouchY;
        private Runnable pendingSnapRunnable;
        private int recyclerAbsoluteOffset;
        private boolean recyclerOffsetKnown;
        private RecyclerView.OnScrollListener recyclerScrollListener;
        private boolean recyclerSnapInProgress;
        private int recyclerSnapRange;
        private Runnable recyclerSnapSettleRunnable;
        private int recyclerSnapTarget;
        private WeakReference<RecyclerView> recyclerTargetRef;
        private WeakReference<View> scrollTargetRef;
        private ValueAnimator snapAnimator;
        private boolean suppressRecyclerTracking;
        private WeakReference<StepOSCollapsingTitleBar> titleBarRef;
        private int touchSlop;
        private boolean touchStartedInChild;

        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/stepos/widget/toolbar/StepOSAppBarLayout$Behavior$Companion;", "", "<init>", "()V", "SNAP_ANIMATION_DURATION_MILLIS", "", "SNAP_SETTLE_GRACE_MILLIS", "StepOSWidget_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(kotlin.jvm.internal.i iVar) {
                this();
            }

            private Companion() {
            }
        }

        public Behavior() {
            this.touchSlop = -1;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void applyRecyclerTitleOffset(RecyclerView target, StepOSCollapsingTitleBar titleBar) {
            int scrollRange = titleBar.getScrollRange();
            titleBar.setScrollOffset(C5685n.n(this.recyclerOffsetKnown ? this.recyclerAbsoluteOffset : scrollRange, 0, scrollRange), scrollRange);
        }

        private final void attachRecyclerTracker(RecyclerView target, StepOSCollapsingTitleBar titleBar) {
            WeakReference<StepOSAppBarLayout> weakReference = this.behaviorHostRef;
            if (weakReference == null) {
                ViewParent parent = target.getParent();
                weakReference = new WeakReference<>(parent instanceof StepOSAppBarLayout ? (StepOSAppBarLayout) parent : null);
            }
            this.behaviorHostRef = weakReference;
            this.titleBarRef = new WeakReference<>(titleBar);
            WeakReference<RecyclerView> weakReference2 = this.recyclerTargetRef;
            if ((weakReference2 != null ? weakReference2.get() : null) == target && this.recyclerScrollListener != null) {
                syncRecyclerOffsetFromLayout(target);
                return;
            }
            detachRecyclerTracker();
            this.recyclerTargetRef = new WeakReference<>(target);
            this.recyclerAbsoluteOffset = 0;
            this.recyclerOffsetKnown = false;
            RecyclerView.OnScrollListener onScrollListener = new RecyclerView.OnScrollListener() { // from class: com.stepos.widget.toolbar.StepOSAppBarLayout$Behavior$attachRecyclerTracker$listener$1
                @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
                public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                    StepOSCollapsingTitleBar stepOSCollapsingTitleBar;
                    kotlin.jvm.internal.p.i(recyclerView, "recyclerView");
                    WeakReference weakReference3 = this.this$0.recyclerTargetRef;
                    if ((weakReference3 != null ? (RecyclerView) weakReference3.get() : null) == recyclerView && newState == 0) {
                        this.this$0.syncRecyclerOffsetFromLayout(recyclerView);
                        WeakReference weakReference4 = this.this$0.titleBarRef;
                        if (weakReference4 == null || (stepOSCollapsingTitleBar = (StepOSCollapsingTitleBar) weakReference4.get()) == null) {
                            return;
                        }
                        StepOSAppBarLayout.Behavior behavior = this.this$0;
                        behavior.applyRecyclerTitleOffset(recyclerView, stepOSCollapsingTitleBar);
                        if (behavior.recyclerSnapInProgress) {
                            behavior.finishRecyclerSnap(recyclerView, stepOSCollapsingTitleBar);
                        }
                    }
                }

                @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
                public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                    StepOSCollapsingTitleBar stepOSCollapsingTitleBar;
                    kotlin.jvm.internal.p.i(recyclerView, "recyclerView");
                    WeakReference weakReference3 = this.this$0.recyclerTargetRef;
                    if ((weakReference3 != null ? (RecyclerView) weakReference3.get() : null) != recyclerView || this.this$0.suppressRecyclerTracking) {
                        return;
                    }
                    this.this$0.updateRecyclerOffsetFromScroll(recyclerView, dy);
                    WeakReference weakReference4 = this.this$0.titleBarRef;
                    if (weakReference4 == null || (stepOSCollapsingTitleBar = (StepOSCollapsingTitleBar) weakReference4.get()) == null) {
                        return;
                    }
                    this.this$0.applyRecyclerTitleOffset(recyclerView, stepOSCollapsingTitleBar);
                }
            };
            this.recyclerScrollListener = onScrollListener;
            target.addOnScrollListener(onScrollListener);
            syncRecyclerOffsetFromLayout(target);
        }

        private final void cancelPendingSnap(StepOSAppBarLayout child) {
            Runnable runnable = this.pendingSnapRunnable;
            if (runnable != null) {
                child.removeCallbacks(runnable);
            }
            this.pendingSnapRunnable = null;
        }

        private final void cancelRecyclerSnap() {
            cancelRecyclerSnapSettle();
            WeakReference<RecyclerView> weakReference = this.recyclerTargetRef;
            RecyclerView recyclerView = weakReference != null ? weakReference.get() : null;
            if (this.recyclerSnapInProgress && recyclerView != null) {
                recyclerView.stopScroll();
            }
            this.recyclerSnapInProgress = false;
            this.recyclerSnapTarget = 0;
            this.recyclerSnapRange = 0;
        }

        private final void cancelRecyclerSnapSettle() {
            RecyclerView recyclerView;
            Runnable runnable = this.recyclerSnapSettleRunnable;
            if (runnable == null) {
                return;
            }
            this.recyclerSnapSettleRunnable = null;
            WeakReference<RecyclerView> weakReference = this.recyclerTargetRef;
            if (weakReference == null || (recyclerView = weakReference.get()) == null) {
                return;
            }
            recyclerView.removeCallbacks(runnable);
        }

        private final void cancelSnapAnimator() {
            ValueAnimator valueAnimator = this.snapAnimator;
            if (valueAnimator != null) {
                valueAnimator.cancel();
            }
            this.snapAnimator = null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final int contentScrollOffset(View target, int expandRange, StepOSCollapsingTitleBar titleBar) {
            return target instanceof NestedScrollView ? ((NestedScrollView) target).getScrollY() : target instanceof RecyclerView ? recyclerViewScrollOffset((RecyclerView) target, expandRange, titleBar) : target.getScrollY();
        }

        private final void detachRecyclerTracker() {
            cancelRecyclerSnapSettle();
            WeakReference<RecyclerView> weakReference = this.recyclerTargetRef;
            RecyclerView recyclerView = weakReference != null ? weakReference.get() : null;
            RecyclerView.OnScrollListener onScrollListener = this.recyclerScrollListener;
            if (onScrollListener != null && recyclerView != null) {
                recyclerView.removeOnScrollListener(onScrollListener);
            }
            this.recyclerTargetRef = null;
            this.recyclerScrollListener = null;
            this.recyclerAbsoluteOffset = 0;
            this.recyclerOffsetKnown = false;
            this.recyclerSnapInProgress = false;
        }

        private final Integer exactRecyclerOffset(RecyclerView target) {
            View viewFindViewByPosition;
            RecyclerView.LayoutManager layoutManager = target.getLayoutManager();
            if (layoutManager == null || (viewFindViewByPosition = layoutManager.findViewByPosition(0)) == null) {
                return null;
            }
            return Integer.valueOf(C5685n.f(target.getPaddingTop() - layoutManager.getDecoratedTop(viewFindViewByPosition), 0));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void finishRecyclerSnap(RecyclerView target, StepOSCollapsingTitleBar titleBar) {
            int i10;
            if (this.recyclerSnapInProgress) {
                WeakReference<RecyclerView> weakReference = this.recyclerTargetRef;
                if ((weakReference != null ? weakReference.get() : null) != target) {
                    return;
                }
                cancelRecyclerSnapSettle();
                int i11 = this.recyclerSnapTarget;
                Integer numValueOf = Integer.valueOf(this.recyclerSnapRange);
                Integer num = numValueOf.intValue() > 0 ? numValueOf : null;
                int iIntValue = num != null ? num.intValue() : titleBar.getScrollRange();
                target.stopScroll();
                syncRecyclerOffsetFromLayout(target);
                if (this.recyclerOffsetKnown && (i10 = this.recyclerAbsoluteOffset) != i11) {
                    this.suppressRecyclerTracking = true;
                    target.scrollBy(0, i11 - i10);
                    this.suppressRecyclerTracking = false;
                    syncRecyclerOffsetFromLayout(target);
                }
                this.recyclerAbsoluteOffset = i11;
                this.recyclerOffsetKnown = true;
                this.recyclerSnapInProgress = false;
                this.recyclerSnapTarget = 0;
                this.recyclerSnapRange = 0;
                titleBar.setScrollOffset(C5685n.n(i11, 0, iIntValue), iIntValue);
            }
        }

        private final boolean isActionPoint(StepOSAppBarLayout appBar, StepOSCollapsingTitleBar titleBar, MotionEvent event) {
            float x10 = (event.getX() - appBar.getLeft()) - titleBar.getLeft();
            float y10 = (event.getY() - appBar.getTop()) - titleBar.getTop();
            return isInside(titleBar.getStartActionContainer(), x10, y10) || isInside(titleBar.getEndActionContainer(), x10, y10);
        }

        private final boolean isInside(View view, float x10, float y10) {
            return view.getVisibility() == 0 && x10 >= ((float) view.getLeft()) && x10 < ((float) view.getRight()) && y10 >= ((float) view.getTop()) && y10 < ((float) view.getBottom());
        }

        private final boolean isInsideChild(StepOSAppBarLayout child, MotionEvent event) {
            float x10 = event.getX() - child.getLeft();
            float y10 = event.getY() - child.getTop();
            return x10 >= 0.0f && x10 < ((float) child.getWidth()) && y10 >= 0.0f && y10 < ((float) child.getHeight());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void onStopNestedScroll$lambda$0(Behavior behavior, StepOSCollapsingTitleBar stepOSCollapsingTitleBar, View view) {
            behavior.pendingSnapRunnable = null;
            int scrollRange = stepOSCollapsingTitleBar.getScrollRange();
            int iContentScrollOffset = behavior.contentScrollOffset(view, scrollRange, stepOSCollapsingTitleBar);
            if (1 > iContentScrollOffset || iContentScrollOffset >= scrollRange) {
                return;
            }
            behavior.smoothScrollTo(view, behavior.snapTarget(iContentScrollOffset, scrollRange), stepOSCollapsingTitleBar);
        }

        private final int recyclerViewScrollOffset(RecyclerView target, int expandRange, StepOSCollapsingTitleBar titleBar) {
            attachRecyclerTracker(target, titleBar);
            syncRecyclerOffsetFromLayout(target);
            return this.recyclerOffsetKnown ? C5685n.f(this.recyclerAbsoluteOffset, 0) : expandRange;
        }

        private final void smoothScrollTo(final View target, int scrollY, final StepOSCollapsingTitleBar titleBar) {
            cancelSnapAnimator();
            final int scrollRange = titleBar.getScrollRange();
            int iContentScrollOffset = contentScrollOffset(target, scrollRange, titleBar);
            if (iContentScrollOffset == scrollY) {
                return;
            }
            if (!(target instanceof RecyclerView)) {
                final Ref$IntRef ref$IntRef = new Ref$IntRef();
                ref$IntRef.f34818a = iContentScrollOffset;
                ValueAnimator valueAnimatorOfInt = ValueAnimator.ofInt(iContentScrollOffset, scrollY);
                valueAnimatorOfInt.setDuration(250L);
                valueAnimatorOfInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.stepos.widget.toolbar.c
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                        StepOSAppBarLayout.Behavior.smoothScrollTo$lambda$5$lambda$4(target, ref$IntRef, this, scrollRange, titleBar, valueAnimator);
                    }
                });
                valueAnimatorOfInt.addListener(new AnimatorListenerAdapter() { // from class: com.stepos.widget.toolbar.StepOSAppBarLayout$Behavior$smoothScrollTo$1$2
                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationCancel(Animator animation) {
                        kotlin.jvm.internal.p.i(animation, "animation");
                        this.this$0.snapAnimator = null;
                    }

                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animation) {
                        kotlin.jvm.internal.p.i(animation, "animation");
                        titleBar.setScrollOffset(C5685n.n(this.this$0.contentScrollOffset(target, scrollRange, titleBar), 0, scrollRange), scrollRange);
                        this.this$0.snapAnimator = null;
                    }
                });
                valueAnimatorOfInt.start();
                this.snapAnimator = valueAnimatorOfInt;
                return;
            }
            RecyclerView recyclerView = (RecyclerView) target;
            recyclerView.stopScroll();
            attachRecyclerTracker(recyclerView, titleBar);
            syncRecyclerOffsetFromLayout(recyclerView);
            if (this.recyclerOffsetKnown) {
                int i10 = this.recyclerAbsoluteOffset;
                if (i10 == scrollY) {
                    titleBar.setScrollOffset(C5685n.n(scrollY, 0, scrollRange), scrollRange);
                    return;
                }
                this.recyclerSnapInProgress = true;
                this.recyclerSnapTarget = scrollY;
                this.recyclerSnapRange = scrollRange;
                recyclerView.smoothScrollBy(0, scrollY - i10);
                cancelRecyclerSnapSettle();
                Runnable runnable = new Runnable() { // from class: com.stepos.widget.toolbar.b
                    @Override // java.lang.Runnable
                    public final void run() {
                        StepOSAppBarLayout.Behavior.smoothScrollTo$lambda$3(this.f31389a, target, titleBar);
                    }
                };
                this.recyclerSnapSettleRunnable = runnable;
                target.postDelayed(runnable, 430L);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void smoothScrollTo$lambda$3(Behavior behavior, View view, StepOSCollapsingTitleBar stepOSCollapsingTitleBar) {
            behavior.recyclerSnapSettleRunnable = null;
            if (behavior.recyclerSnapInProgress) {
                WeakReference<RecyclerView> weakReference = behavior.recyclerTargetRef;
                if ((weakReference != null ? weakReference.get() : null) == view) {
                    behavior.finishRecyclerSnap((RecyclerView) view, stepOSCollapsingTitleBar);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void smoothScrollTo$lambda$5$lambda$4(View view, Ref$IntRef ref$IntRef, Behavior behavior, int i10, StepOSCollapsingTitleBar stepOSCollapsingTitleBar, ValueAnimator animator) {
            kotlin.jvm.internal.p.i(animator, "animator");
            Object animatedValue = animator.getAnimatedValue();
            kotlin.jvm.internal.p.g(animatedValue, "null cannot be cast to non-null type kotlin.Int");
            int iIntValue = ((Integer) animatedValue).intValue();
            if (view instanceof NestedScrollView) {
                ((NestedScrollView) view).scrollTo(0, iIntValue);
            } else if (view instanceof RecyclerView) {
                int i11 = iIntValue - ref$IntRef.f34818a;
                if (i11 != 0) {
                    ((RecyclerView) view).scrollBy(0, i11);
                }
            } else {
                view.scrollTo(0, iIntValue);
            }
            ref$IntRef.f34818a = iIntValue;
            stepOSCollapsingTitleBar.setScrollOffset(C5685n.n(behavior.contentScrollOffset(view, i10, stepOSCollapsingTitleBar), 0, i10), i10);
        }

        private final int snapTarget(int offset, int expandRange) {
            if (offset / expandRange < 0.5f) {
                return 0;
            }
            return expandRange;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void syncRecyclerOffsetFromLayout(RecyclerView target) {
            Integer numExactRecyclerOffset = exactRecyclerOffset(target);
            if (numExactRecyclerOffset != null) {
                this.recyclerAbsoluteOffset = numExactRecyclerOffset.intValue();
                this.recyclerOffsetKnown = true;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void updateRecyclerOffsetFromScroll(RecyclerView target, int dy) {
            Integer numExactRecyclerOffset = exactRecyclerOffset(target);
            if (numExactRecyclerOffset != null) {
                this.recyclerAbsoluteOffset = numExactRecyclerOffset.intValue();
                this.recyclerOffsetKnown = true;
            } else if (this.recyclerOffsetKnown) {
                this.recyclerAbsoluteOffset = C5685n.f(this.recyclerAbsoluteOffset + dy, 0);
            }
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        public void onDetachedFromLayoutParams() {
            StepOSAppBarLayout stepOSAppBarLayout;
            WeakReference<StepOSAppBarLayout> weakReference = this.behaviorHostRef;
            if (weakReference != null && (stepOSAppBarLayout = weakReference.get()) != null) {
                cancelPendingSnap(stepOSAppBarLayout);
            }
            cancelSnapAnimator();
            cancelRecyclerSnap();
            detachRecyclerTracker();
            this.behaviorHostRef = null;
            this.titleBarRef = null;
            this.scrollTargetRef = null;
            super.onDetachedFromLayoutParams();
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        public boolean onNestedFling(CoordinatorLayout parent, StepOSAppBarLayout child, View target, float velocityX, float velocityY, boolean consumed) {
            kotlin.jvm.internal.p.i(parent, "parent");
            kotlin.jvm.internal.p.i(child, "child");
            kotlin.jvm.internal.p.i(target, "target");
            return false;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        public boolean onNestedPreFling(CoordinatorLayout parent, StepOSAppBarLayout child, View target, float velocityX, float velocityY) {
            kotlin.jvm.internal.p.i(parent, "parent");
            kotlin.jvm.internal.p.i(child, "child");
            kotlin.jvm.internal.p.i(target, "target");
            return false;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        public void onNestedPreScroll(CoordinatorLayout parent, StepOSAppBarLayout child, View target, int dx, int dy, int[] consumed, int type) {
            kotlin.jvm.internal.p.i(parent, "parent");
            kotlin.jvm.internal.p.i(child, "child");
            kotlin.jvm.internal.p.i(target, "target");
            kotlin.jvm.internal.p.i(consumed, "consumed");
        }

        /* JADX WARN: Removed duplicated region for block: B:30:0x0075  */
        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public boolean onInterceptTouchEvent(androidx.coordinatorlayout.widget.CoordinatorLayout r4, com.stepos.widget.toolbar.StepOSAppBarLayout r5, android.view.MotionEvent r6) {
            /*
                r3 = this;
                java.lang.String r0 = "parent"
                kotlin.jvm.internal.p.i(r4, r0)
                java.lang.String r4 = "child"
                kotlin.jvm.internal.p.i(r5, r4)
                java.lang.String r4 = "ev"
                kotlin.jvm.internal.p.i(r6, r4)
                boolean r4 = r5.getDragEnabled()
                r0 = 0
                if (r4 == 0) goto L98
                boolean r4 = r5.getNestedScrollEnabled()
                if (r4 != 0) goto L1e
                goto L98
            L1e:
                int r4 = r3.touchSlop
                if (r4 >= 0) goto L30
                android.content.Context r4 = r5.getContext()
                android.view.ViewConfiguration r4 = android.view.ViewConfiguration.get(r4)
                int r4 = r4.getScaledTouchSlop()
                r3.touchSlop = r4
            L30:
                com.stepos.widget.toolbar.StepOSCollapsingTitleBar r4 = r5.findCollapsingTitleBar()
                int r1 = r6.getActionMasked()
                r2 = 1
                if (r1 == 0) goto L7c
                if (r1 == r2) goto L75
                r5 = 2
                if (r1 == r5) goto L44
                r4 = 3
                if (r1 == r4) goto L75
                goto L95
            L44:
                boolean r5 = r3.ignoreTouch
                if (r5 != 0) goto L74
                boolean r5 = r3.touchStartedInChild
                if (r5 != 0) goto L4d
                goto L74
            L4d:
                float r5 = r3.lastTouchY
                float r0 = r6.getY()
                float r5 = r5 - r0
                float r0 = java.lang.Math.abs(r5)
                int r1 = r3.touchSlop
                float r1 = (float) r1
                int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
                if (r0 <= 0) goto L95
                if (r4 == 0) goto L95
                int r5 = r9.C5227b.b(r5)
                boolean r4 = r4.canConsumeNestedScroll(r5)
                if (r4 == 0) goto L95
                r3.dragging = r2
                float r4 = r6.getY()
                r3.lastTouchY = r4
                goto L95
            L74:
                return r0
            L75:
                r3.dragging = r0
                r3.ignoreTouch = r0
                r3.touchStartedInChild = r0
                goto L95
            L7c:
                float r1 = r6.getY()
                r3.lastTouchY = r1
                r3.dragging = r0
                if (r4 == 0) goto L8d
                boolean r4 = r3.isActionPoint(r5, r4, r6)
                if (r4 == 0) goto L8d
                r0 = r2
            L8d:
                r3.ignoreTouch = r0
                boolean r4 = r3.isInsideChild(r5, r6)
                r3.touchStartedInChild = r4
            L95:
                boolean r3 = r3.dragging
                return r3
            L98:
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.stepos.widget.toolbar.StepOSAppBarLayout.Behavior.onInterceptTouchEvent(androidx.coordinatorlayout.widget.CoordinatorLayout, com.stepos.widget.toolbar.StepOSAppBarLayout, android.view.MotionEvent):boolean");
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        public boolean onLayoutChild(CoordinatorLayout parent, StepOSAppBarLayout child, int layoutDirection) {
            kotlin.jvm.internal.p.i(parent, "parent");
            kotlin.jvm.internal.p.i(child, "child");
            parent.Q(child, layoutDirection);
            return true;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        public void onNestedScroll(CoordinatorLayout parent, StepOSAppBarLayout child, View target, int dxConsumed, int dyConsumed, int dxUnconsumed, int dyUnconsumed, int type, int[] consumed) {
            kotlin.jvm.internal.p.i(parent, "parent");
            kotlin.jvm.internal.p.i(child, "child");
            kotlin.jvm.internal.p.i(target, "target");
            kotlin.jvm.internal.p.i(consumed, "consumed");
            StepOSCollapsingTitleBar stepOSCollapsingTitleBarFindCollapsingTitleBar = child.findCollapsingTitleBar();
            if (stepOSCollapsingTitleBarFindCollapsingTitleBar == null) {
                return;
            }
            this.scrollTargetRef = new WeakReference<>(target);
            this.titleBarRef = new WeakReference<>(stepOSCollapsingTitleBarFindCollapsingTitleBar);
            int scrollRange = stepOSCollapsingTitleBarFindCollapsingTitleBar.getScrollRange();
            int iContentScrollOffset = contentScrollOffset(target, scrollRange, stepOSCollapsingTitleBarFindCollapsingTitleBar);
            stepOSCollapsingTitleBarFindCollapsingTitleBar.setScrollOffset(C5685n.j(iContentScrollOffset, scrollRange), scrollRange);
            if (dyUnconsumed >= 0 || iContentScrollOffset != 0) {
                return;
            }
            consumed[1] = consumed[1] + dyUnconsumed;
            if (stepOSCollapsingTitleBarFindCollapsingTitleBar.getOverScrollTranslationY() > 0.0f) {
                stepOSCollapsingTitleBarFindCollapsingTitleBar.resetOverScroll(false);
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:14:0x003e  */
        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public boolean onStartNestedScroll(androidx.coordinatorlayout.widget.CoordinatorLayout r2, com.stepos.widget.toolbar.StepOSAppBarLayout r3, android.view.View r4, android.view.View r5, int r6, int r7) {
            /*
                r1 = this;
                java.lang.String r0 = "parent"
                kotlin.jvm.internal.p.i(r2, r0)
                java.lang.String r2 = "child"
                kotlin.jvm.internal.p.i(r3, r2)
                java.lang.String r2 = "directTargetChild"
                kotlin.jvm.internal.p.i(r4, r2)
                java.lang.String r2 = "target"
                kotlin.jvm.internal.p.i(r5, r2)
                java.lang.ref.WeakReference r2 = new java.lang.ref.WeakReference
                r2.<init>(r3)
                r1.behaviorHostRef = r2
                com.stepos.widget.toolbar.StepOSCollapsingTitleBar r2 = r3.findCollapsingTitleBar()
                boolean r4 = r5 instanceof androidx.recyclerview.widget.RecyclerView
                if (r4 == 0) goto L2b
                if (r2 == 0) goto L2b
                r4 = r5
                androidx.recyclerview.widget.RecyclerView r4 = (androidx.recyclerview.widget.RecyclerView) r4
                r1.attachRecyclerTracker(r4, r2)
            L2b:
                boolean r2 = r1.recyclerSnapInProgress
                if (r2 == 0) goto L3e
                java.lang.ref.WeakReference<androidx.recyclerview.widget.RecyclerView> r2 = r1.recyclerTargetRef
                if (r2 == 0) goto L3a
                java.lang.Object r2 = r2.get()
                androidx.recyclerview.widget.RecyclerView r2 = (androidx.recyclerview.widget.RecyclerView) r2
                goto L3b
            L3a:
                r2 = 0
            L3b:
                if (r2 != r5) goto L3e
                goto L49
            L3e:
                r1.cancelPendingSnap(r3)
                r1.cancelSnapAnimator()
                if (r7 != 0) goto L49
                r1.cancelRecyclerSnap()
            L49:
                boolean r1 = r3.getNestedScrollEnabled()
                if (r1 == 0) goto L55
                r1 = r6 & 2
                if (r1 == 0) goto L55
                r1 = 1
                return r1
            L55:
                r1 = 0
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.stepos.widget.toolbar.StepOSAppBarLayout.Behavior.onStartNestedScroll(androidx.coordinatorlayout.widget.CoordinatorLayout, com.stepos.widget.toolbar.StepOSAppBarLayout, android.view.View, android.view.View, int, int):boolean");
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        public void onStopNestedScroll(CoordinatorLayout parent, StepOSAppBarLayout child, final View target, int type) {
            kotlin.jvm.internal.p.i(parent, "parent");
            kotlin.jvm.internal.p.i(child, "child");
            kotlin.jvm.internal.p.i(target, "target");
            final StepOSCollapsingTitleBar stepOSCollapsingTitleBarFindCollapsingTitleBar = child.findCollapsingTitleBar();
            if (stepOSCollapsingTitleBarFindCollapsingTitleBar == null) {
                return;
            }
            this.titleBarRef = new WeakReference<>(stepOSCollapsingTitleBarFindCollapsingTitleBar);
            if (this.recyclerSnapInProgress) {
                WeakReference<RecyclerView> weakReference = this.recyclerTargetRef;
                if ((weakReference != null ? weakReference.get() : null) == target) {
                    return;
                }
            }
            stepOSCollapsingTitleBarFindCollapsingTitleBar.onOverScrollStateChanged(0);
            int scrollRange = stepOSCollapsingTitleBarFindCollapsingTitleBar.getScrollRange();
            int iContentScrollOffset = contentScrollOffset(target, scrollRange, stepOSCollapsingTitleBarFindCollapsingTitleBar);
            stepOSCollapsingTitleBarFindCollapsingTitleBar.setScrollOffset(C5685n.j(iContentScrollOffset, scrollRange), scrollRange);
            if (child.getSnapEnabled() && 1 <= iContentScrollOffset && iContentScrollOffset < scrollRange) {
                Runnable runnable = new Runnable() { // from class: com.stepos.widget.toolbar.d
                    @Override // java.lang.Runnable
                    public final void run() {
                        StepOSAppBarLayout.Behavior.onStopNestedScroll$lambda$0(this.f31397a, stepOSCollapsingTitleBarFindCollapsingTitleBar, target);
                    }
                };
                this.pendingSnapRunnable = runnable;
                if (type == 0) {
                    child.postDelayed(runnable, child.getSnapDelay());
                } else {
                    child.post(runnable);
                }
            }
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        public boolean onTouchEvent(CoordinatorLayout parent, StepOSAppBarLayout child, MotionEvent event) {
            kotlin.jvm.internal.p.i(parent, "parent");
            kotlin.jvm.internal.p.i(child, "child");
            kotlin.jvm.internal.p.i(event, "event");
            StepOSCollapsingTitleBar stepOSCollapsingTitleBarFindCollapsingTitleBar = child.findCollapsingTitleBar();
            int actionMasked = event.getActionMasked();
            if (actionMasked == 0) {
                if (!this.touchStartedInChild || (stepOSCollapsingTitleBarFindCollapsingTitleBar != null && isActionPoint(child, stepOSCollapsingTitleBarFindCollapsingTitleBar, event))) {
                    return false;
                }
                this.lastTouchY = event.getY();
                this.dragging = false;
                return true;
            }
            if (actionMasked != 1) {
                if (actionMasked == 2) {
                    int iB = C5227b.b(this.lastTouchY - event.getY());
                    this.lastTouchY = event.getY();
                    if (Math.abs(iB) > 0 && stepOSCollapsingTitleBarFindCollapsingTitleBar != null) {
                        stepOSCollapsingTitleBarFindCollapsingTitleBar.consumeNestedScrollDelta(iB);
                        this.dragging = true;
                    }
                    return true;
                }
                if (actionMasked != 3) {
                    return true;
                }
            }
            if (this.dragging && child.getSnapEnabled() && stepOSCollapsingTitleBarFindCollapsingTitleBar != null) {
                WeakReference<View> weakReference = this.scrollTargetRef;
                View view = weakReference != null ? weakReference.get() : null;
                int scrollRange = stepOSCollapsingTitleBarFindCollapsingTitleBar.getScrollRange();
                int scrollOffset = stepOSCollapsingTitleBarFindCollapsingTitleBar.getScrollOffset();
                if (1 <= scrollOffset && scrollOffset < scrollRange) {
                    if (view != null) {
                        smoothScrollTo(view, snapTarget(scrollOffset, scrollRange), stepOSCollapsingTitleBarFindCollapsingTitleBar);
                    } else {
                        stepOSCollapsingTitleBarFindCollapsingTitleBar.snapToNearest(true);
                    }
                }
            }
            this.dragging = false;
            this.touchStartedInChild = false;
            return true;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Behavior(Context context, AttributeSet attrs) {
            super(context, attrs);
            kotlin.jvm.internal.p.i(context, "context");
            kotlin.jvm.internal.p.i(attrs, "attrs");
            this.touchSlop = -1;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public StepOSAppBarLayout(Context context) {
        this(context, null, 0, 0, 14, null);
        kotlin.jvm.internal.p.i(context, "context");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Behavior attachedBehavior_delegate$lambda$0() {
        return new Behavior();
    }

    private final Behavior getAttachedBehavior() {
        return (Behavior) this.attachedBehavior.getValue();
    }

    public final StepOSCollapsingTitleBar findCollapsingTitleBar() {
        int childCount = getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = getChildAt(i10);
            if (childAt instanceof StepOSCollapsingTitleBar) {
                return (StepOSCollapsingTitleBar) childAt;
            }
        }
        return null;
    }

    public final StepOSTitleBar findTitleBar() {
        int childCount = getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = getChildAt(i10);
            if (childAt instanceof StepOSTitleBar) {
                return (StepOSTitleBar) childAt;
            }
        }
        return null;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.b
    public CoordinatorLayout.c<?> getBehavior() {
        return getAttachedBehavior();
    }

    public final long getSnapDelay() {
        return this.snapDelay;
    }

    /* renamed from: isDragEnabled, reason: from getter */
    public final boolean getDragEnabled() {
        return this.dragEnabled;
    }

    /* renamed from: isNestedScrollEnabled, reason: from getter */
    public final boolean getNestedScrollEnabled() {
        return this.nestedScrollEnabled;
    }

    /* renamed from: isSnapEnabled, reason: from getter */
    public final boolean getSnapEnabled() {
        return this.snapEnabled;
    }

    public final void setDragEnabled(boolean enabled) {
        this.dragEnabled = enabled;
    }

    public final void setNestedScrollEnabled(boolean enabled) {
        this.nestedScrollEnabled = enabled;
    }

    public final void setSnapEnabled(boolean enabled) {
        this.snapEnabled = enabled;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public StepOSAppBarLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 0, 12, null);
        kotlin.jvm.internal.p.i(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public StepOSAppBarLayout(Context context, AttributeSet attributeSet, int i10) {
        this(context, attributeSet, i10, 0, 8, null);
        kotlin.jvm.internal.p.i(context, "context");
    }

    public /* synthetic */ StepOSAppBarLayout(Context context, AttributeSet attributeSet, int i10, int i11, int i12, kotlin.jvm.internal.i iVar) {
        this(context, (i12 & 2) != 0 ? null : attributeSet, (i12 & 4) != 0 ? R.attr.steposAppBarLayoutStyle : i10, (i12 & 8) != 0 ? R.style.StepOSWidget_AppBarLayout : i11);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StepOSAppBarLayout(Context context, AttributeSet attributeSet, int i10, int i11) {
        super(context, attributeSet, i10, i11);
        kotlin.jvm.internal.p.i(context, "context");
        this.attachedBehavior = C4848b.a(LazyThreadSafetyMode.NONE, new InterfaceC5063a() { // from class: com.stepos.widget.toolbar.a
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return StepOSAppBarLayout.attachedBehavior_delegate$lambda$0();
            }
        });
        setOrientation(1);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.StepOSAppBarLayout, i10, i11);
        kotlin.jvm.internal.p.h(typedArrayObtainStyledAttributes, "obtainStyledAttributes(...)");
        this.snapEnabled = typedArrayObtainStyledAttributes.getBoolean(R.styleable.StepOSAppBarLayout_steposAppBarSnapEnabled, true);
        this.dragEnabled = typedArrayObtainStyledAttributes.getBoolean(R.styleable.StepOSAppBarLayout_steposAppBarDragEnabled, false);
        this.nestedScrollEnabled = typedArrayObtainStyledAttributes.getBoolean(R.styleable.StepOSAppBarLayout_steposAppBarNestedScrollEnabled, true);
        this.snapDelay = C5685n.g(typedArrayObtainStyledAttributes.getInt(R.styleable.StepOSAppBarLayout_steposAppBarSnapDelay, 140), 0L);
        typedArrayObtainStyledAttributes.recycle();
    }
}
