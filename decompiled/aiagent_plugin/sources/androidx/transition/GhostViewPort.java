package androidx.transition;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import com.bytedance.bdturing.localstorage.DbHelper;
import com.obric.aiagent.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
class GhostViewPort extends ViewGroup implements i {
    private Matrix mMatrix;
    private final ViewTreeObserver.OnPreDrawListener mOnPreDrawListener;
    int mReferences;
    ViewGroup mStartParent;
    View mStartView;
    final View mView;

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean r1, int r2, int r3, int r4, int r5) {
    }

    GhostViewPort(View r4) {
        super((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r4.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"));
        this.mOnPreDrawListener = new AnonymousClass1(this);
        this.mView = r4;
        setWillNotDraw(false);
        setLayerType(2, null);
    }

    @Override // android.view.View, androidx.transition.i
    public void setVisibility(int r2) {
        super.setVisibility(r2);
        if (getGhostView(this.mView) != this) goto L9;
        if (r2 != 0) goto L6;
        int r3 = 4;
    L7:
        af.a(this.mView, r3);
        return;
    L6:
        r3 = 0;
        goto L7
    }

    void setMatrix(Matrix r1) {
        this.mMatrix = r1;
    }

    @Override // androidx.transition.i
    public void reserveEndViewTransition(ViewGroup r1, View r2) {
        this.mStartParent = r1;
        this.mStartView = r2;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        setGhostView(this.mView, this);
        this.mView.getViewTreeObserver().addOnPreDrawListener(this.mOnPreDrawListener);
        af.a(this.mView, 4);
        if (this.mView.getParent() == null) goto L6;
        ((View) ZeusTransformUtils.preCheckCast(this.mView.getParent(), View.class, "com.obric.aiagent.plugin")).invalidate();
        return;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        this.mView.getViewTreeObserver().removeOnPreDrawListener(this.mOnPreDrawListener);
        af.a(this.mView, 0);
        setGhostView(this.mView, null);
        if (this.mView.getParent() == null) goto L5;
        ((View) ZeusTransformUtils.preCheckCast(this.mView.getParent(), View.class, "com.obric.aiagent.plugin")).invalidate();
    L5:
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    public void onDraw(Canvas r5) {
        d.a(r5, true);
        r5.setMatrix(this.mMatrix);
        af.a(this.mView, 0);
        this.mView.invalidate();
        af.a(this.mView, 4);
        drawChild(r5, this.mView, getDrawingTime());
        d.a(r5, false);
    }

    static void copySize(View r4, View r5) {
        af.a(r5, r5.getLeft(), r5.getTop(), r5.getLeft() + r4.getWidth(), r5.getTop() + r4.getHeight());
    }

    static GhostViewPort getGhostView(View r3) {
        return (GhostViewPort) ZeusTransformUtils.preCheckCast(r3.getTag(ZeusTransformUtils.mapRes(R.id.ghost_view, DbHelper.COL_ID, "ghost_view")), GhostViewPort.class, "com.obric.aiagent.plugin");
    }

    static void setGhostView(View r3, GhostViewPort r4) {
        r3.setTag(ZeusTransformUtils.mapRes(R.id.ghost_view, DbHelper.COL_ID, "ghost_view"), r4);
    }

    static void calculateMatrix(View r2, ViewGroup r3, Matrix r4) {
        ViewGroup r5 = (ViewGroup) ZeusTransformUtils.preCheckCast(r2.getParent(), ViewGroup.class, "com.obric.aiagent.plugin");
        r4.reset();
        af.a(r5, r4);
        r4.preTranslate(-r5.getScrollX(), -r5.getScrollY());
        af.b(r3, r4);
    }

    static GhostViewPort addGhost(View r6, ViewGroup r7, Matrix r8) {
        if (ZeusTransformUtils.instanceOf(r6.getParent(), ViewGroup.class) == false) goto L22;
        GhostViewHolder r0 = GhostViewHolder.getHolder(r7);
        GhostViewPort r1 = getGhostView(r6);
        int r2 = 0;
        if (r1 == null) goto L9;
        GhostViewHolder r3 = (GhostViewHolder) ZeusTransformUtils.preCheckCast(r1.getParent(), GhostViewHolder.class, "com.obric.aiagent.plugin");
        if (r3 == r0) goto L9;
        r2 = r1.mReferences;
        r3.removeView(r1);
        r1 = null;
    L9:
        if (r1 != null) goto L17;
        if (r8 != null) goto L12;
        r8 = new Matrix();
        calculateMatrix(r6, r7, r8);
    L12:
        r1 = new GhostViewPort(r6);
        r1.setMatrix(r8);
        if (r0 != null) goto L15;
        r0 = new GhostViewHolder(r7);
    L16:
        copySize(r7, r0);
        copySize(r7, r1);
        r0.addGhostView(r1);
        r1.mReferences = r2;
    L19:
        r1.mReferences++;
        return r1;
    L15:
        r0.popToOverlayTop();
        goto L16
    L17:
        if (r8 == null) goto L19;
        r1.setMatrix(r8);
        goto L19
    L22:
        throw new IllegalArgumentException("Ghosted views must be parented by a ViewGroup");
    }

    static void removeGhost(View r3) {
        GhostViewPort r4 = getGhostView(r3);
        if (r4 == null) goto L8;
        int r0 = r4.mReferences - 1;
        r4.mReferences = r0;
        if (r0 > 0) goto L9;
        ((GhostViewHolder) ZeusTransformUtils.preCheckCast(r4.getParent(), GhostViewHolder.class, "com.obric.aiagent.plugin")).removeView(r4);
        return;
    L9:
        return;
    }
}
