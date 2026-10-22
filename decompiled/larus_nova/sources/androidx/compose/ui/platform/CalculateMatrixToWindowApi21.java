package androidx.compose.ui.platform;

import android.graphics.Matrix;
import android.view.View;
import androidx.compose.ui.graphics.AndroidMatrixConversions_androidKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001f\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u001f\u0010\u0010\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0011\u0010\u000fJ\u001b\u0010\u0012\u001a\u00020\n*\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u0014H\u0002¢\u0006\u0004\b\u0015\u0010\u0016J#\u0010\u0017\u001a\u00020\n*\u00020\u00032\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0019H\u0002¢\u0006\u0004\b\u001b\u0010\u001cR\u0010\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0006R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Landroidx/compose/ui/platform/CalculateMatrixToWindowApi21;", "Landroidx/compose/ui/platform/CalculateMatrixToWindow;", "tmpMatrix", "Landroidx/compose/ui/graphics/Matrix;", "<init>", "([FLkotlin/jvm/internal/DefaultConstructorMarker;)V", "[F", "tmpLocation", "", "calculateMatrixToWindow", "", "view", "Landroid/view/View;", "matrix", "calculateMatrixToWindow-EL8BTi8", "(Landroid/view/View;[F)V", "transformMatrixToWindow", "transformMatrixToWindow-EL8BTi8", "preConcat", "other", "Landroid/graphics/Matrix;", "preConcat-tU-YjHk", "([FLandroid/graphics/Matrix;)V", "preTranslate", "x", "", "y", "preTranslate-3XD1CNM", "([FFF)V", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
final class CalculateMatrixToWindowApi21 implements CalculateMatrixToWindow {
    private final int[] tmpLocation;
    private final float[] tmpMatrix;

    public /* synthetic */ CalculateMatrixToWindowApi21(float[] r100, DefaultConstructorMarker r101) {
        this(r100);
    }

    private CalculateMatrixToWindowApi21(float[] r100) {
        this.tmpMatrix = r100;
        this.tmpLocation = new int[2];
    }

    /* JADX INFO: renamed from: preConcat-tU-YjHk, reason: not valid java name */
    private final void m6678preConcattUYjHk(float[] r100, Matrix r101) {
        AndroidMatrixConversions_androidKt.m4696setFromtUYjHk(this.tmpMatrix, r101);
        AndroidComposeView_androidKt.m6672access$preTransformJiSxe2E(r100, this.tmpMatrix);
    }

    /* JADX INFO: renamed from: transformMatrixToWindow-EL8BTi8, reason: not valid java name */
    private final void m6680transformMatrixToWindowEL8BTi8(View r100, float[] r101) {
        Object r102 = r100.getParent();
        if ((r102 instanceof View) == false) goto L5;
        m6680transformMatrixToWindowEL8BTi8((View) r102, r101);
        m6679preTranslate3XD1CNM(r101, -r100.getScrollX(), -r100.getScrollY());
        m6679preTranslate3XD1CNM(r101, r100.getLeft(), r100.getTop());
    L6:
        Matrix r103 = r100.getMatrix();
        if (r103.isIdentity() == true) goto L10;
        m6678preConcattUYjHk(r101, r103);
        return;
    L10:
        return;
    L5:
        int[] r104 = this.tmpLocation;
        r100.getLocationInWindow(r104);
        m6679preTranslate3XD1CNM(r101, -r100.getScrollX(), -r100.getScrollY());
        m6679preTranslate3XD1CNM(r101, r104[0], r104[1]);
        goto L6
    }

    @Override // androidx.compose.ui.platform.CalculateMatrixToWindow
    /* JADX INFO: renamed from: calculateMatrixToWindow-EL8BTi8 */
    public void mo6677calculateMatrixToWindowEL8BTi8(View r100, float[] r101) {
        androidx.compose.ui.graphics.Matrix.m5086resetimpl(r101);
        m6680transformMatrixToWindowEL8BTi8(r100, r101);
    }

    /* JADX INFO: renamed from: preTranslate-3XD1CNM, reason: not valid java name */
    private final void m6679preTranslate3XD1CNM(float[] r100, float r101, float r102) {
        AndroidComposeView_androidKt.m6673access$preTranslatecG2Xzmc(r100, r101, r102, this.tmpMatrix);
    }
}
