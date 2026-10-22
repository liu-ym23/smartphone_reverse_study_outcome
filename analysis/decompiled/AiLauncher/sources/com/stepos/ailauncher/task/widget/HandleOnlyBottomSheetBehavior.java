package com.stepos.ailauncher.task.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.exifinterface.media.ExifInterface;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\b\u0012\u0004\u0012\u00028\u00000\u0003B\u001d\b\u0007\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\b\u0010\tJ'\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00028\u00002\u0006\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J'\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00028\u00002\u0006\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u0012\u0010\u0011J?\u0010\u0019\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\n2\u0006\u0010\f\u001a\u00028\u00002\u0006\u0010\u0014\u001a\u00020\u00012\u0006\u0010\u0015\u001a\u00020\u00012\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u0016H\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ\u001f\u0010\u001b\u001a\u00020\u000f2\u0006\u0010\f\u001a\u00028\u00002\u0006\u0010\u000e\u001a\u00020\rH\u0002¢\u0006\u0004\b\u001b\u0010\u001cR$\u0010\u001d\u001a\u0004\u0018\u00010\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u0014\u0010$\u001a\u00020#8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b$\u0010%R\u0016\u0010&\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b&\u0010'¨\u0006("}, d2 = {"Lcom/stepos/ailauncher/task/widget/HandleOnlyBottomSheetBehavior;", "Landroid/view/View;", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "Lcom/google/android/material/bottomsheet/BottomSheetBehavior;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "Landroidx/coordinatorlayout/widget/CoordinatorLayout;", "parent", "child", "Landroid/view/MotionEvent;", "event", "", "onInterceptTouchEvent", "(Landroidx/coordinatorlayout/widget/CoordinatorLayout;Landroid/view/View;Landroid/view/MotionEvent;)Z", "onTouchEvent", "coordinatorLayout", "directTargetChild", "target", "", "axes", "type", "onStartNestedScroll", "(Landroidx/coordinatorlayout/widget/CoordinatorLayout;Landroid/view/View;Landroid/view/View;Landroid/view/View;II)Z", "L0", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", "handleView", "Landroid/view/View;", "getHandleView", "()Landroid/view/View;", "setHandleView", "(Landroid/view/View;)V", "Landroid/graphics/Rect;", "handleRect", "Landroid/graphics/Rect;", "allowGesture", "Z", "task_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class HandleOnlyBottomSheetBehavior<V extends View> extends BottomSheetBehavior<V> {
    private boolean allowGesture;
    private final Rect handleRect;
    private View handleView;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HandleOnlyBottomSheetBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        p.i(context, "context");
        this.handleRect = new Rect();
    }

    public final boolean L0(V child, MotionEvent event) {
        View view = this.handleView;
        if (view == null || !view.isAttachedToWindow()) {
            return false;
        }
        view.getHitRect(this.handleRect);
        return this.handleRect.contains((int) (event.getX() - child.getLeft()), (int) (event.getY() - child.getTop()));
    }

    @Override // com.google.android.material.bottomsheet.BottomSheetBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean onInterceptTouchEvent(CoordinatorLayout parent, V child, MotionEvent event) {
        p.i(parent, "parent");
        p.i(child, "child");
        p.i(event, "event");
        if (event.getActionMasked() == 0) {
            this.allowGesture = L0(child, event);
        }
        if (this.allowGesture) {
            return super.onInterceptTouchEvent(parent, child, event);
        }
        return false;
    }

    @Override // com.google.android.material.bottomsheet.BottomSheetBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean onStartNestedScroll(CoordinatorLayout coordinatorLayout, V child, View directTargetChild, View target, int axes, int type) {
        p.i(coordinatorLayout, "coordinatorLayout");
        p.i(child, "child");
        p.i(directTargetChild, "directTargetChild");
        p.i(target, "target");
        return false;
    }

    @Override // com.google.android.material.bottomsheet.BottomSheetBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean onTouchEvent(CoordinatorLayout parent, V child, MotionEvent event) {
        p.i(parent, "parent");
        p.i(child, "child");
        p.i(event, "event");
        if (event.getActionMasked() == 0) {
            this.allowGesture = L0(child, event);
        }
        if (this.allowGesture) {
            return super.onTouchEvent(parent, child, event);
        }
        return false;
    }
}
