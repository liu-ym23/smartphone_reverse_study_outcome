package com.google.android.material.internal;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.core.view.ViewCompat;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes2.dex */
class ViewOverlayApi14 implements q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected OverlayViewGroup f13429a;

    static class OverlayViewGroup extends ViewGroup {
        static Method invalidateChildInParentFastMethod;
        private boolean disposed;
        ArrayList<Drawable> drawables;
        ViewGroup hostView;
        View requestingView;
        ViewOverlayApi14 viewOverlay;

        @Override // android.view.ViewGroup, android.view.View
        public boolean dispatchTouchEvent(MotionEvent r1) {
            return false;
        }

        @Override // android.view.ViewGroup, android.view.View
        public void onLayout(boolean r1, int r2, int r3, int r4, int r5) {
        }

        static {
            invalidateChildInParentFastMethod = ViewGroup.class.getDeclaredMethod("invalidateChildInParentFast", new Class[]{Integer.TYPE, Integer.TYPE, Rect.class});     // Catch: NoSuchMethodException -> L4
            return;
        }

        OverlayViewGroup(Context r3, ViewGroup r4, View r5, ViewOverlayApi14 r6) {
            super((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin"));
            this.drawables = null;
            this.hostView = r4;
            this.requestingView = r5;
            setRight(r4.getWidth());
            setBottom(r4.getHeight());
            r4.addView(this);
            this.viewOverlay = r6;
        }

        public void add(Drawable r2) {
            assertNotDisposed();
            if (this.drawables != null) goto L6;
            this.drawables = new ArrayList();
        L6:
            if (this.drawables.contains(r2) == true) goto L9;
            this.drawables.add(r2);
            invalidate(r2.getBounds());
            r2.setCallback(this);
            return;
        }

        public void remove(Drawable r2) {
            ArrayList<Drawable> r0 = this.drawables;
            if (r0 == null) goto L6;
            r0.remove(r2);
            invalidate(r2.getBounds());
            r2.setCallback(null);
            disposeIfEmpty();
            return;
        }

        @Override // android.view.View
        public boolean verifyDrawable(Drawable r2) {
            if (super.verifyDrawable(r2) == true) goto L10;
            ArrayList<Drawable> r1 = this.drawables;
            if (r1 != null) goto L7;
        L9:
            return false;
        L7:
            if (r1.contains(r2) == false) goto L9;
        L10:
            return true;
        }

        public void add(View r6) {
            assertNotDisposed();
            if (ZeusTransformUtils.instanceOf(r6.getParent(), ViewGroup.class) == false) goto L14;
            ViewGroup r0 = (ViewGroup) ZeusTransformUtils.preCheckCast(r6.getParent(), ViewGroup.class, "com.obric.aiagent.plugin");
            if (r0 != this.hostView) goto L7;
        L11:
            r0.removeView(r6);
            if (r6.getParent() == null) goto L14;
            r0.removeView(r6);
            goto L14
        L7:
            if (r0.getParent() == null) goto L11;
            if (ViewCompat.I(r0) == false) goto L11;
            int[] r2 = new int[2];
            int[] r1 = new int[2];
            r0.getLocationOnScreen(r2);
            this.hostView.getLocationOnScreen(r1);
            ViewCompat.g(r6, r2[0] - r1[0]);
            ViewCompat.f(r6, r2[1] - r1[1]);
        L14:
            super.addView(r6);
        }

        public void remove(View r1) {
            super.removeView(r1);
            disposeIfEmpty();
        }

        private void assertNotDisposed() {
            if (this.disposed == true) goto L6;
            return;
        L6:
            throw new IllegalStateException("This overlay was disposed already. Please use a new one via ViewGroupUtils.getOverlay()");
        }

        private void disposeIfEmpty() {
            if (getChildCount() != 0) goto L10;
            ArrayList<Drawable> r0 = this.drawables;
            if (r0 != null) goto L7;
        L8:
            this.disposed = true;
            this.hostView.removeView(this);
            return;
        L7:
            if (r0.size() == 0) goto L8;
            return;
        }

        @Override // android.view.View, android.graphics.drawable.Drawable.Callback
        public void invalidateDrawable(Drawable r1) {
            invalidate(r1.getBounds());
        }

        @Override // android.view.ViewGroup, android.view.View
        public void dispatchDraw(Canvas r6) {
            int[] r1 = new int[2];
            int[] r0 = new int[2];
            this.hostView.getLocationOnScreen(r1);
            this.requestingView.getLocationOnScreen(r0);
            int r2 = 0;
            r6.translate(r0[0] - r1[0], r0[1] - r1[1]);
            r6.clipRect(new Rect(0, 0, this.requestingView.getWidth(), this.requestingView.getHeight()));
            super.dispatchDraw(r6);
            ArrayList<Drawable> r3 = this.drawables;
            if (r3 != null) goto L5;
            int r4 = 0;
        L6:
            if (r2 >= r4) goto L8;
            ((Drawable) ZeusTransformUtils.preCheckCast(this.drawables.get(r2), Drawable.class, "com.obric.aiagent.plugin")).draw(r6);
            r2 = r2 + 1;
            goto L6
        L8:
            return;
        L5:
            r4 = r3.size();
            goto L6
        }

        private void getOffset(int[] r5) {
            int[] r1 = new int[2];
            int[] r0 = new int[2];
            this.hostView.getLocationOnScreen(r1);
            this.requestingView.getLocationOnScreen(r0);
            r5[0] = r0[0] - r1[0];
            r5[1] = r0[1] - r1[1];
        }

        public ViewParent invalidateChildInParentFast(int r5, int r6, Rect r7) {
            if (this.hostView != null) goto L5;
            return null;
        L5:
            if (invalidateChildInParentFastMethod != null) goto L15;
            return null;
        L15:
            getOffset(new int[2]);     // Catch: InvocationTargetException -> L9 IllegalAccessException -> L11
            invalidateChildInParentFastMethod.invoke(this.hostView, new Object[]{Integer.valueOf(r5), Integer.valueOf(r6), r7});     // Catch: InvocationTargetException -> L9 IllegalAccessException -> L11
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

        @Override // android.view.ViewGroup, android.view.ViewParent
        public ViewParent invalidateChildInParent(int[] r5, Rect r6) {
            if (this.hostView == null) goto L11;
            r6.offset(r5[0], r5[1]);
            if (this.hostView == null) goto L8;
            r5[0] = 0;
            r5[1] = 0;
            int[] r1 = new int[2];
            getOffset(r1);
            r6.offset(r1[0], r1[1]);
            return super.invalidateChildInParent(r5, r6);
        L8:
            invalidate(r6);
            return null;
        L11:
            return null;
        }
    }

    ViewOverlayApi14(Context r3, ViewGroup r4, View r5) {
        this.f13429a = new OverlayViewGroup((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin"), r4, r5, this);
    }

    static ViewOverlayApi14 a(View r6) {
        ViewGroup r0 = r.f(r6);
        if (r0 == null) goto L14;
        int r1 = r0.getChildCount();
        int r2 = 0;
    L6:
        if (r2 >= r1) goto L13;
        View r4 = r0.getChildAt(r2);
        if (ZeusTransformUtils.instanceOf(r4, OverlayViewGroup.class) == true) goto L10;
        r2 = r2 + 1;
        goto L6
    L10:
        return ((OverlayViewGroup) ZeusTransformUtils.preCheckCast(r4, OverlayViewGroup.class, "com.obric.aiagent.plugin")).viewOverlay;
    L13:
        return new n((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r0.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), r0, r6);
    L14:
        return null;
    }

    @Override // com.google.android.material.internal.q
    public void a(Drawable r1) {
        this.f13429a.add(r1);
    }

    @Override // com.google.android.material.internal.q
    public void b(Drawable r1) {
        this.f13429a.remove(r1);
    }
}
