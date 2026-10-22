package j1;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import java.util.HashMap;
import java.util.Iterator;

/* loaded from: classes.dex */
public final class w0 extends ViewGroup {

    /* renamed from: f, reason: collision with root package name */
    public final HashMap f5343f;

    /* renamed from: g, reason: collision with root package name */
    public final HashMap f5344g;

    public w0(Context context) {
        super(context);
        setClipChildren(false);
        this.f5343f = new HashMap();
        this.f5344g = new HashMap();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchDraw(Canvas canvas) {
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchTouchEvent(MotionEvent motionEvent) {
        return true;
    }

    public final HashMap<Object, i1.f0> getHolderToLayoutNode() {
        return this.f5343f;
    }

    public final HashMap<i1.f0, Object> getLayoutNodeToHolder() {
        return this.f5344g;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final /* bridge */ /* synthetic */ ViewParent invalidateChildInParent(int[] iArr, Rect rect) {
        return null;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void onDescendantInvalidated(View view, View view2) {
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z4, int i2, int i10, int i11, int i12) {
        Iterator it = this.f5343f.keySet().iterator();
        if (it.hasNext()) {
            it.next().getClass();
            throw new ClassCastException();
        }
    }

    @Override // android.view.View
    public final void onMeasure(int i2, int i10) {
        if (View.MeasureSpec.getMode(i2) != 1073741824) {
            f1.a.a("widthMeasureSpec should be EXACTLY");
        }
        if (View.MeasureSpec.getMode(i10) != 1073741824) {
            f1.a.a("heightMeasureSpec should be EXACTLY");
        }
        setMeasuredDimension(View.MeasureSpec.getSize(i2), View.MeasureSpec.getSize(i10));
        Iterator it = this.f5343f.keySet().iterator();
        if (it.hasNext()) {
            it.next().getClass();
            throw new ClassCastException();
        }
    }

    @Override // android.view.View, android.view.ViewParent
    public final void requestLayout() {
        cleanupLayoutState(this);
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            i1.f0 f0Var = (i1.f0) this.f5343f.get(childAt);
            if (childAt.isLayoutRequested() && f0Var != null) {
                i1.f0.M(f0Var, false, 7);
            }
        }
    }

    @Override // android.view.ViewGroup
    public final boolean shouldDelayChildPressedState() {
        return false;
    }
}
