package androidx.compose.ui.text.style;

import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.text.internal.InlineClassHelperKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0013\u001a\u00020\u0003HÆ\u0003¢\u0006\u0004\b\u0014\u0010\u0007J\u001a\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bHÖ\u0003J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001R\u0013\u0010\u0002\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\t\u001a\u00020\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u0007R\u0016\u0010\u000b\u001a\u0004\u0018\u00010\f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u000f\u001a\u00020\u00108VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012¨\u0006 "}, d2 = {"Landroidx/compose/ui/text/style/ColorStyle;", "Landroidx/compose/ui/text/style/TextForegroundStyle;", "value", "Landroidx/compose/ui/graphics/Color;", "<init>", "(JLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getValue-0d7_KjU", "()J", "J", "color", "getColor-0d7_KjU", "brush", "Landroidx/compose/ui/graphics/Brush;", "getBrush", "()Landroidx/compose/ui/graphics/Brush;", "alpha", "", "getAlpha", "()F", "component1", "component1-0d7_KjU", "copy", "copy-8_81llA", "(J)Landroidx/compose/ui/text/style/ColorStyle;", "equals", "", "other", "", "hashCode", "", "toString", "", "ui-text"}, k = 1, mv = {2, 0, 0}, xi = 48)
final class ColorStyle implements TextForegroundStyle {
    private final long value;

    public /* synthetic */ ColorStyle(long r100, DefaultConstructorMarker r101) {
        this(r100);
    }

    /* JADX INFO: renamed from: copy-8_81llA$default, reason: not valid java name */
    public static /* synthetic */ ColorStyle m7305copy8_81llA$default(ColorStyle r100, long r101, int r102, Object r103) {
        if ((r102 & 1) == 0) goto L6;
        r101 = r100.value;
    L6:
        return r100.m7307copy8_81llA(r101);
    }

    /* JADX INFO: renamed from: component1-0d7_KjU, reason: not valid java name */
    public final long m7306component10d7_KjU() {
        return this.value;
    }

    /* JADX INFO: renamed from: copy-8_81llA, reason: not valid java name */
    public final ColorStyle m7307copy8_81llA(long r100) {
        return new ColorStyle(r100, null);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof ColorStyle) == true) goto L9;
        return false;
    L9:
        if (Color.m4828equalsimpl0(this.value, ((ColorStyle) r100).value) == true) goto L11;
        return false;
    L11:
        return true;
    }

    @Override // androidx.compose.ui.text.style.TextForegroundStyle
    public Brush getBrush() {
        return null;
    }

    public int hashCode() {
        return Color.m4834hashCodeimpl(this.value);
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
        return "ColorStyle(value=" + Color.m4835toStringimpl(this.value) + ')';
    }

    @Override // androidx.compose.ui.text.style.TextForegroundStyle
    public float getAlpha() {
        return Color.m4829getAlphaimpl(mo7304getColor0d7_KjU());
    }

    @Override // androidx.compose.ui.text.style.TextForegroundStyle
    /* JADX INFO: renamed from: getColor-0d7_KjU */
    public long mo7304getColor0d7_KjU() {
        return this.value;
    }

    /* JADX INFO: renamed from: getValue-0d7_KjU, reason: not valid java name */
    public final long m7308getValue0d7_KjU() {
        return this.value;
    }

    private ColorStyle(long r100) {
        this.value = r100;
        if (r100 == 16) goto L5;
        boolean r101 = true;
    L6:
        if (r101 == true) goto L9;
        InlineClassHelperKt.throwIllegalArgumentException("ColorStyle value must be specified, use TextForegroundStyle.Unspecified instead.");
        return;
    L9:
        return;
    L5:
        r101 = false;
        goto L6
    }
}
