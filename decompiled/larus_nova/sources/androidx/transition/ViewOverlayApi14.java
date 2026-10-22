package androidx.transition;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.core.view.ViewCompat;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes17.dex */
class ViewOverlayApi14 implements ViewOverlayImpl {
    protected OverlayViewGroup mOverlayViewGroup;

    public static class OverlayViewGroup extends ViewGroup {
        static Method sInvalidateChildInParentFastMethod;
        ArrayList<Drawable> mDrawables;
        ViewGroup mHostView;
        View mRequestingView;
        ViewOverlayApi14 mViewOverlay;

        public static class TouchInterceptor extends View {
            public TouchInterceptor(Context r100) {
                super(r100);
            }
        }

        @Override // android.view.ViewGroup, android.view.View
        public boolean dispatchTouchEvent(MotionEvent r100) {
            return false;
        }

        @Override // android.view.ViewGroup, android.view.View
        public void onLayout(boolean r100, int r101, int r102, int r103, int r104) {
        }

        static {
            Class r100 = Integer.TYPE;     // Catch: NoSuchMethodException -> L4
            sInvalidateChildInParentFastMethod = ViewGroup.class.getDeclaredMethod("invalidateChildInParentFast", new Class[]{r100, r100, Rect.class});     // Catch: NoSuchMethodException -> L4
            return;
        }

        public void clear() {
            removeAllViews();
            ArrayList<Drawable> r100 = this.mDrawables;
            if (r100 == null) goto L6;
            r100.clear();
            return;
        }

        public boolean isEmpty() {
            if (getChildCount() != 0) goto L9;
            ArrayList<Drawable> r100 = this.mDrawables;
            if (r100 != null) goto L7;
        L8:
            return true;
        L7:
            if (r100.size() == 0) goto L8;
        L9:
            return false;
        }

        private void getOffset(int[] r100) {
            int[] r101 = new int[2];
            int[] r102 = new int[2];
            this.mHostView.getLocationOnScreen(r101);
            this.mRequestingView.getLocationOnScreen(r102);
            r100[0] = r102[0] - r101[0];
            r100[1] = r102[1] - r101[1];
        }

        public void add(View r100) {
            if ((r100.getParent() instanceof ViewGroup) == false) goto L14;
            ViewGroup r101 = (ViewGroup) r100.getParent();
            if (r101 != this.mHostView) goto L7;
        L11:
            r101.removeView(r100);
            if (r100.getParent() == null) goto L14;
            r101.removeView(r100);
            goto L14
        L7:
            if (r101.getParent() == null) goto L11;
            if (ViewCompat.isAttachedToWindow(r101) == false) goto L11;
            int[] r102 = new int[2];
            int[] r103 = new int[2];
            r101.getLocationOnScreen(r102);
            this.mHostView.getLocationOnScreen(r103);
            ViewCompat.offsetLeftAndRight(r100, r102[0] - r103[0]);
            ViewCompat.offsetTopAndBottom(r100, r102[1] - r103[1]);
        L14:
            super.addView(r100, getChildCount() - 1);
        }

        @Override // android.view.ViewGroup, android.view.View
        public void dispatchDraw(Canvas r100) {
            int[] r101 = new int[2];
            int[] r102 = new int[2];
            this.mHostView.getLocationOnScreen(r101);
            this.mRequestingView.getLocationOnScreen(r102);
            int r103 = 0;
            r100.translate(r102[0] - r101[0], r102[1] - r101[1]);
            r100.clipRect(new Rect(0, 0, this.mRequestingView.getWidth(), this.mRequestingView.getHeight()));
            super.dispatchDraw(r100);
            ArrayList<Drawable> r104 = this.mDrawables;
            if (r104 != null) goto L5;
            int r105 = 0;
        L6:
            if (r103 >= r105) goto L8;
            ((Drawable) ListProtector.get(this.mDrawables, r103)).draw(r100);
            r103 = r103 + 1;
            goto L6
        L8:
            return;
        L5:
            r105 = r104.size();
            goto L6
        }

        @Override // android.view.View, android.graphics.drawable.Drawable.Callback
        public void invalidateDrawable(Drawable r100) {
            invalidate(r100.getBounds());
        }

        public void remove(Drawable r100) {
            ArrayList<Drawable> r101 = this.mDrawables;
            if (r101 == null) goto L6;
            r101.remove(r100);
            invalidate(r100.getBounds());
            r100.setCallback(null);
            return;
        }

        @Override // android.view.View
        public boolean verifyDrawable(Drawable r100) {
            if (super.verifyDrawable(r100) == true) goto L10;
            ArrayList<Drawable> r101 = this.mDrawables;
            if (r101 != null) goto L7;
        L9:
            return false;
        L7:
            if (r101.contains(r100) == false) goto L9;
        L10:
            return true;
        }

        public void add(Drawable r100) {
            if (this.mDrawables != null) goto L6;
            this.mDrawables = new ArrayList();
        L6:
            if (this.mDrawables.contains(r100) == true) goto L9;
            this.mDrawables.add(r100);
            invalidate(r100.getBounds());
            r100.setCallback(this);
            return;
        }

        public void remove(View r100) {
            super.removeView(r100);
            if (isEmpty() == false) goto L6;
            this.mHostView.removeView(this);
            return;
        }

        public void invalidateChildFast(View r100, Rect r101) {
            if (this.mHostView == null) goto L6;
            int r102 = r100.getLeft();
            int r103 = r100.getTop();
            int[] r104 = new int[2];
            getOffset(r104);
            r101.offset(r102 + r104[0], r103 + r104[1]);
            this.mHostView.invalidate(r101);
            return;
        }

        @Override // android.view.ViewGroup, android.view.ViewParent
        public ViewParent invalidateChildInParent(int[] r100, Rect r101) {
            if (this.mHostView == null) goto L11;
            r101.offset(r100[0], r100[1]);
            if ((this.mHostView instanceof ViewGroup) == false) goto L8;
            r100[0] = 0;
            r100[1] = 0;
            int[] r102 = new int[2];
            getOffset(r102);
            r101.offset(r102[0], r102[1]);
            return super.invalidateChildInParent(r100, r101);
        L8:
            invalidate(r101);
            return null;
        L11:
            return null;
        }

        public ViewParent invalidateChildInParentFast(int r100, int r101, Rect r102) {
            if ((this.mHostView instanceof ViewGroup) == true) goto L5;
            return null;
        L5:
            if (sInvalidateChildInParentFastMethod != null) goto L15;
            return null;
        L15:
            getOffset(new int[2]);     // Catch: InvocationTargetException -> L9 IllegalAccessException -> L11
            sInvalidateChildInParentFastMethod.invoke(this.mHostView, new Object[]{Integer.valueOf(r100), Integer.valueOf(r101), r102});     // Catch: InvocationTargetException -> L9 IllegalAccessException -> L11
        L20:
            return null;
        L11:
            e = move-exception;
            e.printStackTrace();
            return null;
        L9:
            e = move-exception;
            e.printStackTrace();
            return null;
        }

        public OverlayViewGroup(Context r100, ViewGroup r101, View r102, ViewOverlayApi14 r103) {
            super(r100);
            this.mDrawables = null;
            this.mHostView = r101;
            this.mRequestingView = r102;
            setRight(r101.getWidth());
            setBottom(r101.getHeight());
            r101.addView(this);
            this.mViewOverlay = r103;
        }
    }

    @Override // androidx.transition.ViewOverlayImpl
    public void clear() {
        this.mOverlayViewGroup.clear();
    }

    public boolean isEmpty() {
        return this.mOverlayViewGroup.isEmpty();
    }

    private ViewOverlayApi14() {
    }

    public ViewGroup getOverlayView() {
        return this.mOverlayViewGroup;
    }

    public static ViewOverlayApi14 createFrom(View r100) {
        ViewGroup r101 = getContentView(r100);
        if (r101 == null) goto L13;
        int r102 = r101.getChildCount();
        int r103 = 0;
    L5:
        if (r103 >= r102) goto L12;
        View r104 = r101.getChildAt(r103);
        if ((r104 instanceof OverlayViewGroup) == true) goto L9;
        r103 = r103 + 1;
        goto L5
    L9:
        return ((OverlayViewGroup) r104).mViewOverlay;
    L12:
        return new ViewGroupOverlayApi14(r101.getContext(), r101, r100);
    L13:
        return null;
    }

    public static ViewGroup getContentView(View r100) {
    L2:
        if (r100 == null) goto L12;
        if (r100.getId() != 16908290) goto L10;
        if ((r100 instanceof ViewGroup) == false) goto L10;
        return (ViewGroup) r100;
    L10:
        if ((r100.getParent() instanceof ViewGroup) == false) goto L2;
        r100 = (ViewGroup) r100.getParent();
        goto L2
    L12:
        return null;
    }

    @Override // androidx.transition.ViewOverlayImpl
    public void add(Drawable r100) {
        this.mOverlayViewGroup.add(r100);
    }

    @Override // androidx.transition.ViewOverlayImpl
    public void remove(Drawable r100) {
        this.mOverlayViewGroup.remove(r100);
    }

    public ViewOverlayApi14(Context r100, ViewGroup r101, View r102) {
        this.mOverlayViewGroup = new OverlayViewGroup(r100, r101, r102, this);
    }
}
