package androidx.compose.ui.graphics.painter;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.RectKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.AndroidPaint_androidKt;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.Paint;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.bouncycastle.asn1.cmc.BodyPartID;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\b&\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0006\u001a\u00020\u0005H\u0002J\u0012\u0010\u000b\u001a\u00020\f2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0002J\u0010\u0010\u000f\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0002J\u0010\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\u0011H\u0002J\f\u0010\u001c\u001a\u00020\f*\u00020\u0016H$J\u0010\u0010\u001d\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u000eH\u0014J\u0012\u0010\u001e\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0014J\u0010\u0010\u001f\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u0011H\u0014J/\u0010 \u001a\u00020\f*\u00020\u00162\u0006\u0010!\u001a\u00020\u00192\b\b\u0002\u0010\r\u001a\u00020\u000e2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\"\u0010#R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u001f\u0010\u0014\u001a\u0013\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\f0\u0015¢\u0006\u0002\b\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0018\u001a\u00020\u0019X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001b¨\u0006$"}, d2 = {"Landroidx/compose/ui/graphics/painter/Painter;", "", "<init>", "()V", "layerPaint", "Landroidx/compose/ui/graphics/Paint;", "obtainPaint", "useLayer", "", "colorFilter", "Landroidx/compose/ui/graphics/ColorFilter;", "configureColorFilter", "", "alpha", "", "configureAlpha", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "configureLayoutDirection", "rtl", "drawLambda", "Lkotlin/Function1;", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "Lkotlin/ExtensionFunctionType;", "intrinsicSize", "Landroidx/compose/ui/geometry/Size;", "getIntrinsicSize-NH-jbRc", "()J", "onDraw", "applyAlpha", "applyColorFilter", "applyLayoutDirection", "draw", "size", "draw-x_KDEd0", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;JFLandroidx/compose/ui/graphics/ColorFilter;)V", "ui-graphics_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public abstract class Painter {
    private float alpha;
    private ColorFilter colorFilter;
    private final Function1<DrawScope, Unit> drawLambda;
    private Paint layerPaint;
    private LayoutDirection layoutDirection;
    private boolean useLayer;

    public boolean applyAlpha(float r100) {
        return false;
    }

    public boolean applyColorFilter(ColorFilter r100) {
        return false;
    }

    public boolean applyLayoutDirection(LayoutDirection r100) {
        return false;
    }

    /* JADX INFO: renamed from: getIntrinsicSize-NH-jbRc */
    public abstract long mo5530getIntrinsicSizeNHjbRc();

    public abstract void onDraw(DrawScope r100);

    private final Paint obtainPaint() {
        Paint r100 = this.layerPaint;
        if (r100 != null) goto L6;
        Paint r101 = AndroidPaint_androidKt.Paint();
        this.layerPaint = r101;
        return r101;
    L6:
        return r100;
    }

    public Painter() {
        this.alpha = 1.0f;
        this.layoutDirection = LayoutDirection.Ltr;
        this.drawLambda = new Painter$drawLambda$1(this);
    }

    private final void configureAlpha(float r100) {
        if (this.alpha != r100) goto L5;
        boolean r101 = true;
    L6:
        if (r101 == false) goto L8;
        return;
    L8:
        if (applyAlpha(r100) == false) goto L10;
    L19:
        this.alpha = r100;
        return;
    L10:
        if (r100 != 1.0f) goto L12;
        boolean r102 = true;
    L13:
        if (r102 == false) goto L18;
        Paint r103 = this.layerPaint;
        if (r103 == null) goto L17;
        r103.setAlpha(r100);
    L17:
        this.useLayer = false;
        goto L19
    L18:
        obtainPaint().setAlpha(r100);
        this.useLayer = true;
        goto L19
    L12:
        r102 = false;
        goto L13
    L5:
        r101 = false;
        goto L6
    }

    private final void configureColorFilter(ColorFilter r100) {
        if (Intrinsics.areEqual(this.colorFilter, r100) == false) goto L5;
        return;
    L5:
        if (applyColorFilter(r100) == true) goto L12;
        if (r100 != null) goto L11;
        Paint r101 = this.layerPaint;
        if (r101 == null) goto L10;
        r101.setColorFilter(null);
    L10:
        this.useLayer = false;
        goto L12
    L11:
        obtainPaint().setColorFilter(r100);
        this.useLayer = true;
    L12:
        this.colorFilter = r100;
    }

    private final void configureLayoutDirection(LayoutDirection r100) {
        if (this.layoutDirection == r100) goto L6;
        applyLayoutDirection(r100);
        this.layoutDirection = r100;
        return;
    }

    /* JADX INFO: renamed from: draw-x_KDEd0, reason: not valid java name */
    public final void m5536drawx_KDEd0(DrawScope r110, long r111, float r112, ColorFilter r113) {
        configureAlpha(r112);
        configureColorFilter(r113);
        configureLayoutDirection(r110.getLayoutDirection());
        int r100 = (int) (r111 >> 32);
        float r101 = Float.intBitsToFloat((int) (r110.mo5322getSizeNHjbRc() >> 32)) - Float.intBitsToFloat(r100);
        float r102 = Float.intBitsToFloat((int) (r110.mo5322getSizeNHjbRc() & BodyPartID.bodyIdMax));
        int r114 = (int) (r111 & BodyPartID.bodyIdMax);
        float r103 = r102 - Float.intBitsToFloat(r114);
        r110.getDrawContext().getTransform().inset(0.0f, 0.0f, r101, r103);
        if (r112 > 0.0f) goto L25;
    L21:
        r110.getDrawContext().getTransform().inset(-0.0f, -0.0f, -r101, -r103);
        return;
    L25:
    L18:
        th = move-exception;
        r110.getDrawContext().getTransform().inset(-0.0f, -0.0f, -r101, -r103);
        throw th;
    L5:
        if (Float.intBitsToFloat(r100) <= 0.0f) goto L21;
        if (Float.intBitsToFloat(r114) <= 0.0f) goto L21;
        if (this.useLayer == false) goto L16;
        long r104 = Offset.Companion.m4598getZeroF1C5BW0();     // Catch: Throwable -> L18
        float r115 = Float.intBitsToFloat(r100);     // Catch: Throwable -> L18
        float r116 = Float.intBitsToFloat(r114);     // Catch: Throwable -> L18
        long r105 = Float.floatToRawIntBits(r115);     // Catch: Throwable -> L18
        Rect r117 = RectKt.m4622Recttz77jQw(r104, Size.m4642constructorimpl((((long) Float.floatToRawIntBits(r116)) & BodyPartID.bodyIdMax) | (r105 << 32)));     // Catch: Throwable -> L18
        Canvas r118 = r110.getDrawContext().getCanvas();     // Catch: Throwable -> L18
        r118.saveLayer(r117, obtainPaint());     // Catch: Throwable -> L13
        onDraw(r110);     // Catch: Throwable -> L13
        r118.restore();     // Catch: Throwable -> L18
        goto L21
    L13:
        th = move-exception;
        r118.restore();     // Catch: Throwable -> L18
        throw th;     // Catch: Throwable -> L18
    L16:
        onDraw(r110);     // Catch: Throwable -> L18
        goto L21
    }

    /* JADX INFO: renamed from: draw-x_KDEd0$default, reason: not valid java name */
    public static /* synthetic */ void m5535drawx_KDEd0$default(Painter r100, DrawScope r101, long r102, float r110, ColorFilter r111, int r112, Object r113) {
        if (r113 != null) goto L13;
        if ((r112 & 2) == 0) goto L6;
        float r103 = 1.0f;
    L8:
        if ((r112 & 4) == 0) goto L10;
        r111 = null;
    L10:
        r100.m5536drawx_KDEd0(r101, r102, r103, r111);
        return;
    L6:
        r103 = r110;
        goto L8
    L13:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: draw-x_KDEd0");
    }
}
