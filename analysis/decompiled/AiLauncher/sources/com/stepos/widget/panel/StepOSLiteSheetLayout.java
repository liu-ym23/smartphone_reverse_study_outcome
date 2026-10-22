package com.stepos.widget.panel;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.core.view.C1337z;
import androidx.core.view.InterfaceC1336y;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.agent.receiver.SystemDeleteBroadcastReceiver;
import com.stepos.ailauncher.sla.G;
import com.stepos.widget.R;
import kotlin.Metadata;
import r9.C5227b;
import v9.C5685n;

@Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u0015\n\u0002\b\u001a\n\u0002\u0018\u0002\n\u0002\b-\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0001\u0018\u00002\u00020\u00012\u00020\u0002B\u001d\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u000f\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\tH\u0002¢\u0006\u0004\b\u000f\u0010\u0010J)\u0010\u0016\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u0013H\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u0019\u0010\u001a\u001a\u00020\u00192\b\u0010\u0018\u001a\u0004\u0018\u00010\u0011H\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ\u000f\u0010\u001d\u001a\u00020\u001cH\u0002¢\u0006\u0004\b\u001d\u0010\u001eJ\r\u0010\u001f\u001a\u00020\u001c¢\u0006\u0004\b\u001f\u0010\u001eJ\r\u0010 \u001a\u00020\u001c¢\u0006\u0004\b \u0010\u001eJ\u001f\u0010#\u001a\u00020\u001c2\u0006\u0010!\u001a\u00020\t2\u0006\u0010\"\u001a\u00020\tH\u0014¢\u0006\u0004\b#\u0010$J7\u0010*\u001a\u00020\u001c2\u0006\u0010%\u001a\u00020\u00192\u0006\u0010&\u001a\u00020\t2\u0006\u0010'\u001a\u00020\t2\u0006\u0010(\u001a\u00020\t2\u0006\u0010)\u001a\u00020\tH\u0014¢\u0006\u0004\b*\u0010+J\u0017\u0010.\u001a\u00020\u00192\u0006\u0010-\u001a\u00020,H\u0016¢\u0006\u0004\b.\u0010/J\u0017\u00100\u001a\u00020\u00192\u0006\u0010-\u001a\u00020,H\u0016¢\u0006\u0004\b0\u0010/J/\u00105\u001a\u00020\u00192\u0006\u00101\u001a\u00020\u00112\u0006\u00102\u001a\u00020\u00112\u0006\u00103\u001a\u00020\t2\u0006\u00104\u001a\u00020\tH\u0016¢\u0006\u0004\b5\u00106J/\u00107\u001a\u00020\u001c2\u0006\u00101\u001a\u00020\u00112\u0006\u00102\u001a\u00020\u00112\u0006\u00103\u001a\u00020\t2\u0006\u00104\u001a\u00020\tH\u0016¢\u0006\u0004\b7\u00108J7\u0010=\u001a\u00020\u001c2\u0006\u00102\u001a\u00020\u00112\u0006\u00109\u001a\u00020\t2\u0006\u0010:\u001a\u00020\t2\u0006\u0010<\u001a\u00020;2\u0006\u00104\u001a\u00020\tH\u0016¢\u0006\u0004\b=\u0010>JG\u0010C\u001a\u00020\u001c2\u0006\u00102\u001a\u00020\u00112\u0006\u0010?\u001a\u00020\t2\u0006\u0010@\u001a\u00020\t2\u0006\u0010A\u001a\u00020\t2\u0006\u0010B\u001a\u00020\t2\u0006\u00104\u001a\u00020\t2\u0006\u0010<\u001a\u00020;H\u0016¢\u0006\u0004\bC\u0010DJ'\u0010G\u001a\u00020\u00192\u0006\u00102\u001a\u00020\u00112\u0006\u0010E\u001a\u00020\u00132\u0006\u0010F\u001a\u00020\u0013H\u0016¢\u0006\u0004\bG\u0010HJ\u001f\u0010I\u001a\u00020\u001c2\u0006\u00102\u001a\u00020\u00112\u0006\u00104\u001a\u00020\tH\u0016¢\u0006\u0004\bI\u0010JJ\u000f\u0010K\u001a\u00020\tH\u0016¢\u0006\u0004\bK\u0010LJ'\u00105\u001a\u00020\u00192\u0006\u00101\u001a\u00020\u00112\u0006\u00102\u001a\u00020\u00112\u0006\u00103\u001a\u00020\tH\u0016¢\u0006\u0004\b5\u0010MJ'\u00107\u001a\u00020\u001c2\u0006\u00101\u001a\u00020\u00112\u0006\u00102\u001a\u00020\u00112\u0006\u00103\u001a\u00020\tH\u0016¢\u0006\u0004\b7\u0010NJ\u0017\u0010I\u001a\u00020\u001c2\u0006\u00102\u001a\u00020\u0011H\u0016¢\u0006\u0004\bI\u0010OJ/\u0010=\u001a\u00020\u001c2\u0006\u00102\u001a\u00020\u00112\u0006\u00109\u001a\u00020\t2\u0006\u0010:\u001a\u00020\t2\u0006\u0010<\u001a\u00020;H\u0016¢\u0006\u0004\b=\u0010PJ7\u0010C\u001a\u00020\u001c2\u0006\u00102\u001a\u00020\u00112\u0006\u0010?\u001a\u00020\t2\u0006\u0010@\u001a\u00020\t2\u0006\u0010A\u001a\u00020\t2\u0006\u0010B\u001a\u00020\tH\u0016¢\u0006\u0004\bC\u0010QJ?\u0010C\u001a\u00020\u001c2\u0006\u00102\u001a\u00020\u00112\u0006\u0010?\u001a\u00020\t2\u0006\u0010@\u001a\u00020\t2\u0006\u0010A\u001a\u00020\t2\u0006\u0010B\u001a\u00020\t2\u0006\u00104\u001a\u00020\tH\u0016¢\u0006\u0004\bC\u0010RJ/\u0010S\u001a\u00020\u00192\u0006\u00102\u001a\u00020\u00112\u0006\u0010E\u001a\u00020\u00132\u0006\u0010F\u001a\u00020\u00132\u0006\u0010<\u001a\u00020\u0019H\u0016¢\u0006\u0004\bS\u0010TJ\u000f\u0010U\u001a\u00020\u001cH\u0014¢\u0006\u0004\bU\u0010\u001eR\u0017\u0010W\u001a\u00020V8\u0006¢\u0006\f\n\u0004\bW\u0010X\u001a\u0004\bY\u0010ZR\"\u0010[\u001a\u00020\u00198\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b[\u0010\\\u001a\u0004\b]\u0010^\"\u0004\b_\u0010`R\"\u0010a\u001a\u00020\u00198\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\ba\u0010\\\u001a\u0004\bb\u0010^\"\u0004\bc\u0010`R\"\u0010d\u001a\u00020\u00138\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bd\u0010e\u001a\u0004\bf\u0010g\"\u0004\bh\u0010iR\"\u0010j\u001a\u00020\u00198\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bj\u0010\\\u001a\u0004\bk\u0010^\"\u0004\bl\u0010`R\"\u0010m\u001a\u00020\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bm\u0010n\u001a\u0004\bo\u0010L\"\u0004\bp\u0010qR\"\u0010r\u001a\u00020\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\br\u0010n\u001a\u0004\bs\u0010L\"\u0004\bt\u0010qR\"\u0010u\u001a\u00020\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bu\u0010n\u001a\u0004\bv\u0010L\"\u0004\bw\u0010qR\"\u0010x\u001a\u00020\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bx\u0010n\u001a\u0004\by\u0010L\"\u0004\bz\u0010qR\"\u0010{\u001a\u00020\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b{\u0010n\u001a\u0004\b|\u0010L\"\u0004\b}\u0010qR#\u0010~\u001a\u00020\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0013\n\u0004\b~\u0010n\u001a\u0004\b\u007f\u0010L\"\u0005\b\u0080\u0001\u0010qR\u0016\u0010\u0081\u0001\u001a\u00020\u00138\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\b\u0081\u0001\u0010eR\u0016\u0010\u0082\u0001\u001a\u00020\u00138\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\b\u0082\u0001\u0010eR\u0016\u0010\u0083\u0001\u001a\u00020\u00138\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\b\u0083\u0001\u0010eR\"\u0010\u0086\u0001\u001a\r \u0085\u0001*\u0005\u0018\u00010\u0084\u00010\u0084\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u0086\u0001\u0010\u0087\u0001R\u0018\u0010\u0089\u0001\u001a\u00030\u0088\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u0089\u0001\u0010\u008a\u0001R\u0019\u0010\u008b\u0001\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u008b\u0001\u0010\u008c\u0001R\u001c\u0010\u008e\u0001\u001a\u0005\u0018\u00010\u008d\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u008e\u0001\u0010\u008f\u0001R\u0018\u0010\u0090\u0001\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u0090\u0001\u0010nR\u0018\u0010\u0091\u0001\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u0091\u0001\u0010eR\u0018\u0010\u0092\u0001\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u0092\u0001\u0010eR\u0018\u0010\u0093\u0001\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u0093\u0001\u0010eR\u0018\u0010\u0094\u0001\u001a\u00020\u00198\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u0094\u0001\u0010\\R\u001b\u0010\u0095\u0001\u001a\u0004\u0018\u00010\u00118\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0095\u0001\u0010\u0096\u0001R\u001b\u0010\u0097\u0001\u001a\u0004\u0018\u00010\u00118\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0097\u0001\u0010\u0096\u0001R\u0018\u0010\u0098\u0001\u001a\u00020\u00198\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u0098\u0001\u0010\\R\u0018\u0010\u009c\u0001\u001a\u00030\u0099\u00018BX\u0082\u0004¢\u0006\b\u001a\u0006\b\u009a\u0001\u0010\u009b\u0001R\u0016\u0010\u009e\u0001\u001a\u00020\u00198BX\u0082\u0004¢\u0006\u0007\u001a\u0005\b\u009d\u0001\u0010^¨\u0006\u009f\u0001"}, d2 = {"Lcom/stepos/widget/panel/StepOSLiteSheetLayout;", "Landroid/widget/FrameLayout;", "Landroidx/core/view/y;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "height", "Lcom/stepos/widget/panel/StepOSLiteSheetGeometry;", "createGeometry", "(I)Lcom/stepos/widget/panel/StepOSLiteSheetGeometry;", "inset", "bottomPadding", "(I)I", "Landroid/view/View;", "view", "", "x", "y", G.JUDGE_HIT, "(Landroid/view/View;FF)Landroid/view/View;", "start", "", "canScrollUp", "(Landroid/view/View;)Z", "LY8/t;", "recycleTracker", "()V", "updatePosition", "resetGestures", "widthMeasureSpec", "heightMeasureSpec", "onMeasure", "(II)V", "changed", "l", "t", "r", Const.INTENT_KEY_PKGNAME, "onLayout", "(ZIIII)V", "Landroid/view/MotionEvent;", "event", "onInterceptTouchEvent", "(Landroid/view/MotionEvent;)Z", "onTouchEvent", "child", "target", "axes", "type", "onStartNestedScroll", "(Landroid/view/View;Landroid/view/View;II)Z", "onNestedScrollAccepted", "(Landroid/view/View;Landroid/view/View;II)V", "dx", "dy", "", "consumed", "onNestedPreScroll", "(Landroid/view/View;II[II)V", "dxConsumed", "dyConsumed", "dxUnconsumed", "dyUnconsumed", "onNestedScroll", "(Landroid/view/View;IIIII[I)V", "velocityX", "velocityY", "onNestedPreFling", "(Landroid/view/View;FF)Z", "onStopNestedScroll", "(Landroid/view/View;I)V", "getNestedScrollAxes", "()I", "(Landroid/view/View;Landroid/view/View;I)Z", "(Landroid/view/View;Landroid/view/View;I)V", "(Landroid/view/View;)V", "(Landroid/view/View;II[I)V", "(Landroid/view/View;IIII)V", "(Landroid/view/View;IIIII)V", "onNestedFling", "(Landroid/view/View;FFZ)Z", "onDetachedFromWindow", "Lcom/stepos/widget/panel/StepOSLiteSheetController;", "controller", "Lcom/stepos/widget/panel/StepOSLiteSheetController;", "getController", "()Lcom/stepos/widget/panel/StepOSLiteSheetController;", "draggable", "Z", "getDraggable", "()Z", "setDraggable", "(Z)V", "canDismiss", "getCanDismiss", "setCanDismiss", "cornerRadius", "F", "getCornerRadius", "()F", "setCornerRadius", "(F)V", "glassEnabled", "getGlassEnabled", "setGlassEnabled", "glassAppearance", "I", "getGlassAppearance", "setGlassAppearance", "(I)V", "safeTop", "getSafeTop", "setSafeTop", "safeStart", "getSafeStart", "setSafeStart", "safeEnd", "getSafeEnd", "setSafeEnd", "imeBottom", "getImeBottom", "setImeBottom", "navigationBottom", "getNavigationBottom", "setNavigationBottom", "margin", "halfRatio", "topRatio", "Landroid/view/ViewConfiguration;", "kotlin.jvm.PlatformType", "config", "Landroid/view/ViewConfiguration;", "Landroidx/core/view/z;", "helper", "Landroidx/core/view/z;", "geometry", "Lcom/stepos/widget/panel/StepOSLiteSheetGeometry;", "Landroid/view/VelocityTracker;", "tracker", "Landroid/view/VelocityTracker;", SystemDeleteBroadcastReceiver.PAYLOAD_MODE_POINTER, "downX", "downY", "lastY", "dragging", "touched", "Landroid/view/View;", "nestedTarget", "nestedFlung", "Lcom/stepos/widget/panel/StepOSLiteSheetSurface;", "getSurface", "()Lcom/stepos/widget/panel/StepOSLiteSheetSurface;", "surface", "getAcceptsDrag", "acceptsDrag", "StepOSWidget_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class StepOSLiteSheetLayout extends FrameLayout implements InterfaceC1336y {
    private boolean canDismiss;
    private final ViewConfiguration config;
    private final StepOSLiteSheetController controller;
    private float cornerRadius;
    private float downX;
    private float downY;
    private boolean draggable;
    private boolean dragging;
    private StepOSLiteSheetGeometry geometry;
    private int glassAppearance;
    private boolean glassEnabled;
    private final float halfRatio;
    private final C1337z helper;
    private int imeBottom;
    private float lastY;
    private final float margin;
    private int navigationBottom;
    private boolean nestedFlung;
    private View nestedTarget;
    private int pointer;
    private int safeEnd;
    private int safeStart;
    private int safeTop;
    private final float topRatio;
    private View touched;
    private VelocityTracker tracker;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public StepOSLiteSheetLayout(Context context) {
        this(context, null, 2, 0 == true ? 1 : 0);
        kotlin.jvm.internal.p.i(context, "context");
    }

    private final int bottomPadding(int inset) {
        if (this.imeBottom > 0) {
            return 0;
        }
        return C5685n.f(this.navigationBottom - inset, 0);
    }

    private final boolean canScrollUp(View start) {
        while (start != null && start != this) {
            if (start.canScrollVertically(-1)) {
                return true;
            }
            Object parent = start.getParent();
            start = parent instanceof View ? (View) parent : null;
        }
        return false;
    }

    private final StepOSLiteSheetGeometry createGeometry(int height) {
        return new StepOSLiteSheetGeometry(height, this.safeTop, this.imeBottom, this.margin, this.halfRatio, this.topRatio, this.controller.getMode() == 2);
    }

    private final boolean getAcceptsDrag() {
        return this.draggable && this.controller.getTarget() != 2;
    }

    private final StepOSLiteSheetSurface getSurface() {
        View childAt = getChildAt(1);
        kotlin.jvm.internal.p.g(childAt, "null cannot be cast to non-null type com.stepos.widget.panel.StepOSLiteSheetSurface");
        return (StepOSLiteSheetSurface) childAt;
    }

    private final View hit(View view, float x10, float y10) {
        View viewHit;
        if (view.getVisibility() != 0 || x10 < 0.0f || y10 < 0.0f || x10 >= view.getWidth() || y10 >= view.getHeight()) {
            return null;
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            do {
                childCount--;
                if (-1 < childCount) {
                    View childAt = viewGroup.getChildAt(childCount);
                    kotlin.jvm.internal.p.f(childAt);
                    viewHit = hit(childAt, (viewGroup.getScrollX() + x10) - childAt.getX(), (viewGroup.getScrollY() + y10) - childAt.getY());
                }
            } while (viewHit == null);
            return viewHit;
        }
        return view;
    }

    private final void recycleTracker() {
        VelocityTracker velocityTracker = this.tracker;
        if (velocityTracker != null) {
            velocityTracker.recycle();
        }
        this.tracker = null;
        this.pointer = -1;
    }

    public final boolean getCanDismiss() {
        return this.canDismiss;
    }

    public final StepOSLiteSheetController getController() {
        return this.controller;
    }

    public final float getCornerRadius() {
        return this.cornerRadius;
    }

    public final boolean getDraggable() {
        return this.draggable;
    }

    public final int getGlassAppearance() {
        return this.glassAppearance;
    }

    public final boolean getGlassEnabled() {
        return this.glassEnabled;
    }

    public final int getImeBottom() {
        return this.imeBottom;
    }

    public final int getNavigationBottom() {
        return this.navigationBottom;
    }

    @Override // android.view.ViewGroup
    public int getNestedScrollAxes() {
        return this.helper.a();
    }

    public final int getSafeEnd() {
        return this.safeEnd;
    }

    public final int getSafeStart() {
        return this.safeStart;
    }

    public final int getSafeTop() {
        return this.safeTop;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        recycleTracker();
        this.nestedTarget = null;
        this.touched = null;
        this.controller.dispose();
        super.onDetachedFromWindow();
    }

    /* JADX WARN: Removed duplicated region for block: B:41:0x0099  */
    @Override // android.view.ViewGroup
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean onInterceptTouchEvent(android.view.MotionEvent r7) {
        /*
            r6 = this;
            java.lang.String r0 = "event"
            kotlin.jvm.internal.p.i(r7, r0)
            boolean r0 = r6.getAcceptsDrag()
            r1 = 0
            if (r0 != 0) goto Ld
            return r1
        Ld:
            int r0 = r7.getActionMasked()
            if (r0 == 0) goto La1
            r2 = 1
            if (r0 == r2) goto L99
            r3 = 2
            if (r0 == r3) goto L1e
            r7 = 3
            if (r0 == r7) goto L99
            goto Le7
        L1e:
            int r0 = r6.pointer
            int r0 = r7.findPointerIndex(r0)
            if (r0 < 0) goto L98
            android.view.View r3 = r6.touched
            if (r3 != 0) goto L2b
            goto L98
        L2b:
            float r1 = r7.getY(r0)
            float r3 = r6.downY
            float r1 = r1 - r3
            float r3 = r7.getX(r0)
            float r4 = r6.downX
            float r3 = r3 - r4
            android.view.View r4 = r6.nestedTarget
            if (r4 != 0) goto L90
            float r4 = java.lang.Math.abs(r1)
            android.view.ViewConfiguration r5 = r6.config
            int r5 = r5.getScaledTouchSlop()
            float r5 = (float) r5
            int r4 = (r4 > r5 ? 1 : (r4 == r5 ? 0 : -1))
            if (r4 <= 0) goto L90
            float r4 = java.lang.Math.abs(r1)
            float r3 = java.lang.Math.abs(r3)
            int r3 = (r4 > r3 ? 1 : (r4 == r3 ? 0 : -1))
            if (r3 <= 0) goto L90
            r3 = 0
            int r4 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r4 >= 0) goto L6d
            com.stepos.widget.panel.StepOSLiteSheetController r4 = r6.controller
            float r4 = r4.getPosition()
            com.stepos.widget.panel.StepOSLiteSheetController r5 = r6.controller
            float r5 = r5.getMinPosition()
            int r4 = (r4 > r5 ? 1 : (r4 == r5 ? 0 : -1))
            if (r4 > 0) goto L79
        L6d:
            int r1 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r1 <= 0) goto L90
            android.view.View r1 = r6.touched
            boolean r1 = r6.canScrollUp(r1)
            if (r1 != 0) goto L90
        L79:
            r6.dragging = r2
            float r7 = r7.getY(r0)
            r6.lastY = r7
            com.stepos.widget.panel.StepOSLiteSheetController r7 = r6.controller
            r7.beginDrag()
            android.view.ViewParent r6 = r6.getParent()
            if (r6 == 0) goto L8f
            r6.requestDisallowInterceptTouchEvent(r2)
        L8f:
            return r2
        L90:
            android.view.VelocityTracker r0 = r6.tracker
            if (r0 == 0) goto Le7
            r0.addMovement(r7)
            goto Le7
        L98:
            return r1
        L99:
            boolean r7 = r6.dragging
            if (r7 != 0) goto Le7
            r6.recycleTracker()
            goto Le7
        La1:
            r6.recycleTracker()
            android.view.VelocityTracker r0 = android.view.VelocityTracker.obtain()
            r0.addMovement(r7)
            r6.tracker = r0
            int r0 = r7.getPointerId(r1)
            r6.pointer = r0
            float r0 = r7.getX()
            r6.downX = r0
            float r0 = r7.getY()
            r6.downY = r0
            r6.lastY = r0
            com.stepos.widget.panel.StepOSLiteSheetSurface r0 = r6.getSurface()
            float r2 = r7.getX()
            com.stepos.widget.panel.StepOSLiteSheetSurface r3 = r6.getSurface()
            float r3 = r3.getX()
            float r2 = r2 - r3
            float r7 = r7.getY()
            com.stepos.widget.panel.StepOSLiteSheetSurface r3 = r6.getSurface()
            float r3 = r3.getY()
            float r7 = r7 - r3
            android.view.View r7 = r6.hit(r0, r2, r7)
            r6.touched = r7
            r6.dragging = r1
        Le7:
            boolean r6 = r6.dragging
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.widget.panel.StepOSLiteSheetLayout.onInterceptTouchEvent(android.view.MotionEvent):boolean");
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean changed, int l10, int t10, int r10, int b10) {
        if (getChildCount() < 2) {
            return;
        }
        getChildAt(0).layout(0, 0, getWidth(), getHeight());
        int iB = this.safeStart + C5227b.b(this.geometry.inset(this.controller.getPosition()));
        int iB2 = C5227b.b(this.geometry.top(this.controller.getPosition()));
        getSurface().layout(iB, iB2, getSurface().getMeasuredWidth() + iB, getSurface().getMeasuredHeight() + iB2);
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int size = View.MeasureSpec.getSize(widthMeasureSpec);
        int size2 = View.MeasureSpec.getSize(heightMeasureSpec);
        setMeasuredDimension(size, size2);
        if (getChildCount() < 2) {
            return;
        }
        this.geometry = createGeometry(size2);
        getChildAt(0).measure(View.MeasureSpec.makeMeasureSpec(size, 1073741824), View.MeasureSpec.makeMeasureSpec(size2, 1073741824));
        int iB = C5227b.b(this.geometry.inset(this.controller.getPosition()));
        int iF = C5685n.f(((size - this.safeStart) - this.safeEnd) - (iB * 2), 0);
        int iF2 = C5685n.f(C5227b.b(this.geometry.height(this.controller.getPosition())), 0);
        int iBottomPadding = bottomPadding(iB);
        if (getSurface().getPaddingBottom() != iBottomPadding) {
            getSurface().setPaddingRelative(0, 0, 0, iBottomPadding);
        }
        getSurface().measure(View.MeasureSpec.makeMeasureSpec(iF, 1073741824), View.MeasureSpec.makeMeasureSpec(iF2, 1073741824));
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean onNestedFling(View target, float velocityX, float velocityY, boolean consumed) {
        kotlin.jvm.internal.p.i(target, "target");
        return false;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean onNestedPreFling(View target, float velocityX, float velocityY) {
        kotlin.jvm.internal.p.i(target, "target");
        boolean z10 = false;
        if (getAcceptsDrag() && target == this.nestedTarget && this.controller.getMotion() == 1) {
            if (this.controller.getPosition() > this.controller.getMinPosition() || (velocityY < 0.0f && !target.canScrollVertically(-1))) {
                z10 = true;
            }
            this.controller.release(-velocityY, this.config.getScaledMinimumFlingVelocity(), this.canDismiss);
            this.nestedFlung = true;
        }
        return z10;
    }

    @Override // androidx.core.view.InterfaceC1335x
    public void onNestedPreScroll(View target, int dx, int dy, int[] consumed, int type) {
        kotlin.jvm.internal.p.i(target, "target");
        kotlin.jvm.internal.p.i(consumed, "consumed");
        if (getAcceptsDrag() && target == this.nestedTarget && type == 0) {
            if ((dy <= 0 || this.controller.getPosition() <= this.controller.getMinPosition()) && (dy >= 0 || target.canScrollVertically(-1))) {
                return;
            }
            consumed[1] = consumed[1] + C5227b.b(-this.controller.drag(-dy, this.geometry, this.canDismiss));
        }
    }

    @Override // androidx.core.view.InterfaceC1336y
    public void onNestedScroll(View target, int dxConsumed, int dyConsumed, int dxUnconsumed, int dyUnconsumed, int type, int[] consumed) {
        kotlin.jvm.internal.p.i(target, "target");
        kotlin.jvm.internal.p.i(consumed, "consumed");
        if (getAcceptsDrag() && target == this.nestedTarget && type == 0 && dyUnconsumed < 0) {
            consumed[1] = consumed[1] + C5227b.b(-this.controller.drag(-dyUnconsumed, this.geometry, this.canDismiss));
        }
    }

    @Override // androidx.core.view.InterfaceC1335x
    public void onNestedScrollAccepted(View child, View target, int axes, int type) {
        kotlin.jvm.internal.p.i(child, "child");
        kotlin.jvm.internal.p.i(target, "target");
        this.helper.c(child, target, axes, type);
        this.nestedTarget = target;
        this.nestedFlung = false;
    }

    @Override // androidx.core.view.InterfaceC1335x
    public boolean onStartNestedScroll(View child, View target, int axes, int type) {
        kotlin.jvm.internal.p.i(child, "child");
        kotlin.jvm.internal.p.i(target, "target");
        return getAcceptsDrag() && type == 0 && (axes & 2) != 0;
    }

    @Override // androidx.core.view.InterfaceC1335x
    public void onStopNestedScroll(View target, int type) {
        kotlin.jvm.internal.p.i(target, "target");
        this.helper.e(target, type);
        if (target == this.nestedTarget && type == 0) {
            this.nestedTarget = null;
            if (!getAcceptsDrag() || this.nestedFlung) {
                return;
            }
            this.controller.release(0.0f, this.config.getScaledMinimumFlingVelocity(), this.canDismiss);
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent event) {
        kotlin.jvm.internal.p.i(event, "event");
        if (!getAcceptsDrag() || this.touched == null) {
            this.dragging = false;
            recycleTracker();
            return super.onTouchEvent(event);
        }
        VelocityTracker velocityTracker = this.tracker;
        if (velocityTracker != null) {
            velocityTracker.addMovement(event);
        }
        int actionMasked = event.getActionMasked();
        if (actionMasked == 1) {
            VelocityTracker velocityTracker2 = this.tracker;
            if (velocityTracker2 != null) {
                velocityTracker2.computeCurrentVelocity(1000, this.config.getScaledMaximumFlingVelocity());
            }
            if (this.dragging) {
                StepOSLiteSheetController stepOSLiteSheetController = this.controller;
                VelocityTracker velocityTracker3 = this.tracker;
                stepOSLiteSheetController.release(velocityTracker3 != null ? velocityTracker3.getYVelocity(this.pointer) : 0.0f, this.config.getScaledMinimumFlingVelocity(), this.canDismiss);
            }
            this.dragging = false;
            recycleTracker();
        } else if (actionMasked == 2) {
            int iFindPointerIndex = event.findPointerIndex(this.pointer);
            if (iFindPointerIndex < 0) {
                return false;
            }
            float y10 = event.getY(iFindPointerIndex);
            if (!this.dragging && Math.abs(y10 - this.downY) > this.config.getScaledTouchSlop()) {
                this.dragging = true;
                this.controller.beginDrag();
            }
            if (this.dragging) {
                this.controller.drag(y10 - this.lastY, this.geometry, this.canDismiss);
            }
            this.lastY = y10;
        } else if (actionMasked == 3) {
            if (this.dragging) {
                this.controller.cancelGesture();
            }
            this.dragging = false;
            recycleTracker();
        } else if (actionMasked == 6 && event.getPointerId(event.getActionIndex()) == this.pointer) {
            int i10 = event.getActionIndex() == 0 ? 1 : 0;
            this.pointer = event.getPointerId(i10);
            float y11 = event.getY(i10);
            this.lastY = y11;
            this.downY = y11;
            this.downX = event.getX(i10);
            VelocityTracker velocityTracker4 = this.tracker;
            if (velocityTracker4 != null) {
                velocityTracker4.clear();
            }
        }
        return true;
    }

    public final void resetGestures() {
        this.dragging = false;
        View view = this.nestedTarget;
        if (view != null) {
            this.helper.e(view, 0);
        }
        this.nestedTarget = null;
        this.touched = null;
        recycleTracker();
    }

    public final void setCanDismiss(boolean z10) {
        this.canDismiss = z10;
    }

    public final void setCornerRadius(float f10) {
        this.cornerRadius = f10;
    }

    public final void setDraggable(boolean z10) {
        this.draggable = z10;
    }

    public final void setGlassAppearance(int i10) {
        this.glassAppearance = i10;
    }

    public final void setGlassEnabled(boolean z10) {
        this.glassEnabled = z10;
    }

    public final void setImeBottom(int i10) {
        this.imeBottom = i10;
    }

    public final void setNavigationBottom(int i10) {
        this.navigationBottom = i10;
    }

    public final void setSafeEnd(int i10) {
        this.safeEnd = i10;
    }

    public final void setSafeStart(int i10) {
        this.safeStart = i10;
    }

    public final void setSafeTop(int i10) {
        this.safeTop = i10;
    }

    public final void updatePosition() {
        if (getChildCount() < 2) {
            return;
        }
        getChildAt(0).setAlpha(1.0f - this.controller.getDismissProgress());
        getSurface().update(this.controller.getVisualPosition(), this.cornerRadius, this.glassEnabled, this.glassAppearance);
        if (!isLaidOut() || isLayoutRequested()) {
            requestLayout();
            return;
        }
        StepOSLiteSheetGeometry stepOSLiteSheetGeometryCreateGeometry = createGeometry(getHeight());
        this.geometry = stepOSLiteSheetGeometryCreateGeometry;
        int iB = C5227b.b(stepOSLiteSheetGeometryCreateGeometry.inset(this.controller.getPosition()));
        if (getSurface().getLeft() == this.safeStart + iB && getSurface().getTop() == C5227b.b(this.geometry.top(this.controller.getPosition())) && getSurface().getWidth() == C5685n.f(((getWidth() - this.safeStart) - this.safeEnd) - (iB * 2), 0) && getSurface().getHeight() == C5685n.f(C5227b.b(this.geometry.height(this.controller.getPosition())), 0) && getSurface().getPaddingBottom() == bottomPadding(iB)) {
            return;
        }
        requestLayout();
    }

    public /* synthetic */ StepOSLiteSheetLayout(Context context, AttributeSet attributeSet, int i10, kotlin.jvm.internal.i iVar) {
        this(context, (i10 & 2) != 0 ? null : attributeSet);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean onStartNestedScroll(View child, View target, int axes) {
        kotlin.jvm.internal.p.i(child, "child");
        kotlin.jvm.internal.p.i(target, "target");
        return onStartNestedScroll(child, target, axes, 0);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StepOSLiteSheetLayout(Context context, AttributeSet attributeSet) throws Resources.NotFoundException {
        super(context, attributeSet);
        kotlin.jvm.internal.p.i(context, "context");
        this.controller = new StepOSLiteSheetController();
        this.draggable = true;
        this.canDismiss = true;
        this.cornerRadius = getResources().getDimension(R.dimen.stepos_lite_sheet_corner_radius);
        this.glassEnabled = true;
        float dimension = getResources().getDimension(R.dimen.stepos_lite_sheet_outer_margin);
        this.margin = dimension;
        float fraction = getResources().getFraction(R.fraction.stepos_lite_sheet_half_ratio, 1, 1);
        this.halfRatio = fraction;
        float fraction2 = getResources().getFraction(R.fraction.stepos_lite_sheet_expanded_top_ratio, 1, 1);
        this.topRatio = fraction2;
        this.config = ViewConfiguration.get(context);
        this.helper = new C1337z(this);
        this.geometry = new StepOSLiteSheetGeometry(0.0f, 0.0f, 0.0f, dimension, fraction, fraction2, false, 64, null);
        this.pointer = -1;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void onNestedScroll(View target, int dxConsumed, int dyConsumed, int dxUnconsumed, int dyUnconsumed) {
        kotlin.jvm.internal.p.i(target, "target");
        onNestedScroll(target, dxConsumed, dyConsumed, dxUnconsumed, dyUnconsumed, 0);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void onNestedPreScroll(View target, int dx, int dy, int[] consumed) {
        kotlin.jvm.internal.p.i(target, "target");
        kotlin.jvm.internal.p.i(consumed, "consumed");
        onNestedPreScroll(target, dx, dy, consumed, 0);
    }

    @Override // androidx.core.view.InterfaceC1335x
    public void onNestedScroll(View target, int dxConsumed, int dyConsumed, int dxUnconsumed, int dyUnconsumed, int type) {
        kotlin.jvm.internal.p.i(target, "target");
        onNestedScroll(target, dxConsumed, dyConsumed, dxUnconsumed, dyUnconsumed, type, new int[2]);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void onNestedScrollAccepted(View child, View target, int axes) {
        kotlin.jvm.internal.p.i(child, "child");
        kotlin.jvm.internal.p.i(target, "target");
        onNestedScrollAccepted(child, target, axes, 0);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void onStopNestedScroll(View target) {
        kotlin.jvm.internal.p.i(target, "target");
        onStopNestedScroll(target, 0);
    }
}
