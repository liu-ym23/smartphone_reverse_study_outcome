package androidx.compose.ui.graphics;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J'\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0096\u0002J\b\u0010\u0017\u001a\u00020\u0018H\u0016J\b\u0010\u0019\u001a\u00020\u001aH\u0016R\u0013\u0010\u0002\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u001b"}, d2 = {"Landroidx/compose/ui/graphics/SolidColor;", "Landroidx/compose/ui/graphics/Brush;", "value", "Landroidx/compose/ui/graphics/Color;", "<init>", "(JLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getValue-0d7_KjU", "()J", "J", "applyTo", "", "size", "Landroidx/compose/ui/geometry/Size;", "p", "Landroidx/compose/ui/graphics/Paint;", "alpha", "", "applyTo-Pq9zytI", "(JLandroidx/compose/ui/graphics/Paint;F)V", "equals", "", "other", "", "hashCode", "", "toString", "", "ui-graphics_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class SolidColor extends Brush {
    private final long value;

    public /* synthetic */ SolidColor(long r100, DefaultConstructorMarker r101) {
        this(r100);
    }

    public int hashCode() {
        return Color.m4834hashCodeimpl(this.value);
    }

    public String toString() {
        return "SolidColor(value=" + Color.m4835toStringimpl(this.value) + ')';
    }

    /* JADX INFO: renamed from: getValue-0d7_KjU, reason: not valid java name */
    public final long m5188getValue0d7_KjU() {
        return this.value;
    }

    private SolidColor(long r100) {
        super(null);
        this.value = r100;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof SolidColor) == true) goto L9;
        return false;
    L9:
        if (Color.m4828equalsimpl0(this.value, ((SolidColor) r100).value) == true) goto L11;
        return false;
    L11:
        return true;
    }

    @Override // androidx.compose.ui.graphics.Brush
    /* JADX INFO: renamed from: applyTo-Pq9zytI */
    public void mo4773applyToPq9zytI(long r100, Paint r110, float r111) {
        r110.setAlpha(1.0f);
        if (r111 != 1.0f) goto L5;
        boolean r101 = true;
    L6:
        if (r101 == true) goto L8;
        long r102 = this.value;
        long r103 = Color.m4826copywmQWz5c$default(r102, Color.m4829getAlphaimpl(r102) * r111, 0.0f, 0.0f, 0.0f, 14, null);
    L9:
        r110.mo4704setColor8_81llA(r103);
        if (r110.getShader() == null) goto L13;
        r110.setShader(null);
        return;
    L13:
        return;
    L8:
        r103 = this.value;
        goto L9
    L5:
        r101 = false;
        goto L6
    }
}
