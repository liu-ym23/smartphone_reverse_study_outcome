package androidx.compose.ui.graphics;

import java.util.Arrays;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u001f\b\u0000\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\u0010\u0004\u001a\u00060\u0005j\u0002`\u0006¢\u0006\u0004\b\u0007\u0010\bB\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\tJ\u0017\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u0003¢\u0006\u0004\b\r\u0010\u000eJ\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0096\u0002J\u000f\u0010\u0013\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\b\u0010\u0016\u001a\u00020\u0017H\u0016J\b\u0010\u0018\u001a\u00020\u0019H\u0016R\u0012\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\n¨\u0006\u001a"}, d2 = {"Landroidx/compose/ui/graphics/ColorMatrixColorFilter;", "Landroidx/compose/ui/graphics/ColorFilter;", "colorMatrix", "Landroidx/compose/ui/graphics/ColorMatrix;", "nativeColorFilter", "Landroid/graphics/ColorFilter;", "Landroidx/compose/ui/graphics/NativeColorFilter;", "<init>", "([FLandroid/graphics/ColorFilter;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "([FLkotlin/jvm/internal/DefaultConstructorMarker;)V", "[F", "copyColorMatrix", "targetColorMatrix", "copyColorMatrix-gBh15pI", "([F)[F", "equals", "", "other", "", "obtainColorMatrix", "obtainColorMatrix-p10-uLo", "()[F", "hashCode", "", "toString", "", "ui-graphics_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ColorMatrixColorFilter extends ColorFilter {
    private float[] colorMatrix;

    public /* synthetic */ ColorMatrixColorFilter(float[] r100, android.graphics.ColorFilter r101, DefaultConstructorMarker r102) {
        this(r100, r101);
    }

    public /* synthetic */ ColorMatrixColorFilter(float[] r100, DefaultConstructorMarker r101) {
        this(r100);
    }

    /* JADX INFO: renamed from: obtainColorMatrix-p10-uLo, reason: not valid java name */
    private final float[] m4904obtainColorMatrixp10uLo() {
        float[] r100 = this.colorMatrix;
        if (r100 != null) goto L6;
        float[] r101 = AndroidColorFilter_androidKt.actualColorMatrixFromFilter(getNativeColorFilter$ui_graphics_release());
        this.colorMatrix = r101;
        return r101;
    L6:
        return r100;
    }

    public int hashCode() {
        float[] r100 = this.colorMatrix;
        if (r100 != null) goto L7;
        return 0;
    L7:
        return ColorMatrix.m4890hashCodeimpl(r100);
    }

    public String toString() {
        StringBuilder r100 = new StringBuilder("ColorMatrixColorFilter(colorMatrix=");
        float[] r101 = this.colorMatrix;
        if (r101 != null) goto L5;
        String r102 = "null";
    L6:
        r100.append(r102);
        r100.append(')');
        return r100.toString();
    L5:
        r102 = ColorMatrix.m4901toStringimpl(r101);
        goto L6
    }

    private ColorMatrixColorFilter(float[] r100) {
        this(r100, AndroidColorFilter_androidKt.m4688actualColorMatrixColorFilterjHGOpc(r100), null);
    }

    /* JADX INFO: renamed from: copyColorMatrix-gBh15pI, reason: not valid java name */
    public final float[] m4905copyColorMatrixgBh15pI(float[] r100) {
        ArraysKt.copyInto$default(m4904obtainColorMatrixp10uLo(), r100, 0, 0, 0, 14, null);
        return r100;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof ColorMatrixColorFilter) == true) goto L9;
        return false;
    L9:
        if (Arrays.equals(m4904obtainColorMatrixp10uLo(), ((ColorMatrixColorFilter) r100).m4904obtainColorMatrixp10uLo()) == true) goto L11;
        return false;
    L11:
        return true;
    }

    private ColorMatrixColorFilter(float[] r100, android.graphics.ColorFilter r101) {
        super(r101);
        this.colorMatrix = r100;
    }

    /* JADX INFO: renamed from: copyColorMatrix-gBh15pI$default, reason: not valid java name */
    public static /* synthetic */ float[] m4903copyColorMatrixgBh15pI$default(ColorMatrixColorFilter r100, float[] r101, int r102, Object r103) {
        if ((r102 & 1) == 0) goto L6;
        r101 = ColorMatrix.m4884constructorimpl$default(null, 1, null);
    L6:
        return r100.m4905copyColorMatrixgBh15pI(r101);
    }
}
