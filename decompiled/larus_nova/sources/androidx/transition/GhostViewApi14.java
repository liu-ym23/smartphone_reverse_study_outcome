package androidx.transition;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes17.dex */
class GhostViewApi14 extends View implements GhostViewImpl {
    Matrix mCurrentMatrix;
    private int mDeltaX;
    private int mDeltaY;
    private final Matrix mMatrix;
    private final ViewTreeObserver.OnPreDrawListener mOnPreDrawListener;
    int mReferences;
    ViewGroup mStartParent;
    View mStartView;
    final View mView;

    @Override // android.view.View
    public void onDetachedFromWindow() {
        this.mView.getViewTreeObserver().removeOnPreDrawListener(this.mOnPreDrawListener);
        this.mView.setVisibility(0);
        setGhostView(this.mView, null);
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        setGhostView(this.mView, this);
        int[] r100 = new int[2];
        int[] r101 = new int[2];
        getLocationOnScreen(r100);
        this.mView.getLocationOnScreen(r101);
        r101[0] = (int) (r101[0] - this.mView.getTranslationX());
        int r102 = (int) (r101[1] - this.mView.getTranslationY());
        r101[1] = r102;
        this.mDeltaX = r101[0] - r100[0];
        this.mDeltaY = r102 - r100[1];
        this.mView.getViewTreeObserver().addOnPreDrawListener(this.mOnPreDrawListener);
        this.mView.setVisibility(4);
    }

    public GhostViewApi14(View r100) {
        super(r100.getContext());
        this.mMatrix = new Matrix();
        this.mOnPreDrawListener = new AnonymousClass1(this);
        this.mView = r100;
        setLayerType(2, null);
    }

    private static FrameLayout findFrameLayout(ViewGroup r100) {
    L3:
        if ((r100 instanceof FrameLayout) == true) goto L10;
        ViewParent r101 = r100.getParent();
        if ((r101 instanceof ViewGroup) == false) goto L6;
        r100 = (ViewGroup) r101;
        goto L3
    L6:
        return null;
    L10:
        return (FrameLayout) r100;
    }

    public static GhostViewApi14 getGhostView(View r100) {
        return (GhostViewApi14) r100.getTag(R.id.ghost_view);
    }

    public static void removeGhost(View r100) {
        GhostViewApi14 r101 = getGhostView(r100);
        if (r101 == null) goto L10;
        int r102 = r101.mReferences - 1;
        r101.mReferences = r102;
        if (r102 > 0) goto L11;
        ViewParent r103 = r101.getParent();
        if ((r103 instanceof ViewGroup) == false) goto L12;
        ViewGroup r104 = (ViewGroup) r103;
        r104.endViewTransition(r101);
        r104.removeView(r101);
        return;
    L12:
        return;
    L11:
        return;
    }

    @Override // android.view.View
    public void onDraw(Canvas r100) {
        this.mMatrix.set(this.mCurrentMatrix);
        this.mMatrix.postTranslate(this.mDeltaX, this.mDeltaY);
        r100.setMatrix(this.mMatrix);
        this.mView.draw(r100);
    }

    @Override // android.view.View, androidx.transition.GhostViewImpl
    public void setVisibility(int r100) {
        super.setVisibility(r100);
        View r101 = this.mView;
        if (r100 != 0) goto L5;
        int r102 = 4;
    L6:
        r101.setVisibility(r102);
        return;
    L5:
        r102 = 0;
        goto L6
    }

    public static GhostViewImpl addGhost(View r100, ViewGroup r101) {
        GhostViewApi14 r102 = getGhostView(r100);
        if (r102 != null) goto L9;
        FrameLayout r103 = findFrameLayout(r101);
        if (r103 != null) goto L8;
        return null;
    L8:
        r102 = new GhostViewApi14(r100);
        r103.addView(r102);
    L9:
        r102.mReferences++;
        return r102;
    }

    private static void setGhostView(View r100, GhostViewApi14 r101) {
        r100.setTag(R.id.ghost_view, r101);
    }

    @Override // androidx.transition.GhostViewImpl
    public void reserveEndViewTransition(ViewGroup r100, View r101) {
        this.mStartParent = r100;
        this.mStartView = r101;
    }
}
