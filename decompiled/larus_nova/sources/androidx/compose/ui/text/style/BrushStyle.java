package androidx.compose.ui.text.style;

import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ShaderBrush;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aHÖ\u0003J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\r8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0010\u001a\u00020\u00118VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u001f"}, d2 = {"Landroidx/compose/ui/text/style/BrushStyle;", "Landroidx/compose/ui/text/style/TextForegroundStyle;", "value", "Landroidx/compose/ui/graphics/ShaderBrush;", "alpha", "", "<init>", "(Landroidx/compose/ui/graphics/ShaderBrush;F)V", "getValue", "()Landroidx/compose/ui/graphics/ShaderBrush;", "getAlpha", "()F", "color", "Landroidx/compose/ui/graphics/Color;", "getColor-0d7_KjU", "()J", "brush", "Landroidx/compose/ui/graphics/Brush;", "getBrush", "()Landroidx/compose/ui/graphics/Brush;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "ui-text"}, k = 1, mv = {2, 0, 0}, xi = 48)
final class BrushStyle implements TextForegroundStyle {
    private final float alpha;
    private final ShaderBrush value;

    public static /* synthetic */ BrushStyle copy$default(BrushStyle r100, ShaderBrush r101, float r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.value;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.alpha;
    L9:
        return r100.copy(r101, r102);
    }

    public final ShaderBrush component1() {
        return this.value;
    }

    public final float component2() {
        return this.alpha;
    }

    public final BrushStyle copy(ShaderBrush r100, float r101) {
        return new BrushStyle(r100, r101);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof BrushStyle) == true) goto L8;
        return false;
    L8:
        BrushStyle r101 = (BrushStyle) r100;
        if (Intrinsics.areEqual(this.value, r101.value) == true) goto L12;
        return false;
    L12:
        if (Float.compare(this.alpha, r101.alpha) == 0) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        return (this.value.hashCode() * 31) + Float.floatToIntBits(this.alpha);
    }

    @Override // androidx.compose.ui.text.style.TextForegroundStyle
    public final /* synthetic */ TextForegroundStyle merge(TextForegroundStyle r100) {
        return TextForegroundStyle.CC.$default$merge(this, r100);
    }

    @Override // androidx.compose.ui.text.style.TextForegroundStyle
    public final /* synthetic */ TextForegroundStyle takeOrElse(Function0 r100) {
        return TextForegroundStyle.CC.$default$takeOrElse(this, r100);
    }

    public String toString() {
        return "BrushStyle(value=" + this.value + ", alpha=" + this.alpha + ')';
    }

    @Override // androidx.compose.ui.text.style.TextForegroundStyle
    /* JADX INFO: renamed from: getColor-0d7_KjU, reason: not valid java name */
    public long mo7304getColor0d7_KjU() {
        return Color.Companion.m4863getUnspecified0d7_KjU();
    }

    @Override // androidx.compose.ui.text.style.TextForegroundStyle
    public float getAlpha() {
        return this.alpha;
    }

    @Override // androidx.compose.ui.text.style.TextForegroundStyle
    public Brush getBrush() {
        return this.value;
    }

    public final ShaderBrush getValue() {
        return this.value;
    }

    public BrushStyle(ShaderBrush r100, float r101) {
        this.value = r100;
        this.alpha = r101;
    }
}
