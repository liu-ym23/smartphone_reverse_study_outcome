package androidx.compose.ui.graphics.layer.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.compose.ui.graphics.AndroidCanvas_androidKt;
import androidx.compose.ui.graphics.layer.ViewLayer;
import com.byted.cast.common.CastMonitor;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\b\u0010\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J0\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\fH\u0014J\u0018\u0010\u0010\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\fH\u0014J\b\u0010\u0013\u001a\u00020\tH\u0017J\b\u0010\u0014\u001a\u00020\tH\u0016J\u001e\u0010\u0015\u001a\u0004\u0018\u00010\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016J\u0010\u0010\u001b\u001a\u00020\t2\u0006\u0010\u001c\u001a\u00020\u001dH\u0014J\b\u0010\u001e\u001a\u00020\fH\u0016J%\u0010\u001f\u001a\u00020\t2\u0006\u0010\u001c\u001a\u00020 2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$H\u0000¢\u0006\u0002\b%R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006&"}, d2 = {"Landroidx/compose/ui/graphics/layer/view/DrawChildContainer;", "Landroid/view/ViewGroup;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "isDrawing", "", "onLayout", "", CastMonitor.EVENT_PARAM_BYTECAST_NETWORK_STATE_CHANGED, "l", "", "t", "r", "b", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "requestLayout", "forceLayout", "invalidateChildInParent", "Landroid/view/ViewParent;", "location", "", "dirty", "Landroid/graphics/Rect;", "dispatchDraw", "canvas", "Landroid/graphics/Canvas;", "getChildCount", "drawChild", "Landroidx/compose/ui/graphics/Canvas;", "view", "Landroid/view/View;", "drawingTime", "", "drawChild$ui_graphics_release", "ui-graphics_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public class DrawChildContainer extends ViewGroup {
    private boolean isDrawing;

    @Override // android.view.View
    public void forceLayout() {
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public ViewParent invalidateChildInParent(int[] r100, Rect r101) {
        return null;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean r100, int r101, int r102, int r103, int r104) {
    }

    @Override // android.view.View, android.view.ViewParent
    public void requestLayout() {
    }

    @Override // android.view.ViewGroup
    public int getChildCount() {
        if (this.isDrawing == true) goto L7;
        return 0;
    L7:
        return super.getChildCount();
    }

    public DrawChildContainer(Context r100) {
        super(r100);
        setClipChildren(false);
        setClipToPadding(false);
        setTag(R.id.hide_graphics_layer_in_inspector_tag, Boolean.TRUE);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas r100) {
        int r101 = super.getChildCount();
        int r102 = 0;
    L4:
        if (r102 >= r101) goto L9;
        View r103 = getChildAt(r102);
        Intrinsics.checkNotNull(r103, "null cannot be cast to non-null type androidx.compose.ui.graphics.layer.ViewLayer");
        if (((ViewLayer) r103).isInvalidated() == true) goto L7;
        r102 = r102 + 1;
        goto L4
    L7:
        boolean r104 = true;
    L10:
        if (r104 == false) goto L17;
        this.isDrawing = true;
        super.dispatchDraw(r100);     // Catch: Throwable -> L14
        this.isDrawing = false;
        return;
    L14:
        th = move-exception;
        this.isDrawing = false;
        throw th;
    L17:
        return;
    L9:
        r104 = false;
        goto L10
    }

    @Override // android.view.View
    public void onMeasure(int r100, int r101) {
        setMeasuredDimension(0, 0);
    }

    public final void drawChild$ui_graphics_release(androidx.compose.ui.graphics.Canvas r100, View r101, long r102) {
        super.drawChild(AndroidCanvas_androidKt.getNativeCanvas(r100), r101, r102);
    }
}
