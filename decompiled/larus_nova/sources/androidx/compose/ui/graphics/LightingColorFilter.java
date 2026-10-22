package androidx.compose.ui.graphics;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0007\u0018\u00002\u00020\u0001B%\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\n\u0010\u0005\u001a\u00060\u0006j\u0002`\u0007¢\u0006\u0004\b\b\u0010\tB\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\b\u0010\nJ\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0096\u0002J\b\u0010\u0013\u001a\u00020\u0014H\u0016J\b\u0010\u0015\u001a\u00020\u0016H\u0016R\u0013\u0010\u0002\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0004\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000e\u0010\f¨\u0006\u0017"}, d2 = {"Landroidx/compose/ui/graphics/LightingColorFilter;", "Landroidx/compose/ui/graphics/ColorFilter;", "multiply", "Landroidx/compose/ui/graphics/Color;", "add", "nativeColorFilter", "Landroid/graphics/ColorFilter;", "Landroidx/compose/ui/graphics/NativeColorFilter;", "<init>", "(JJLandroid/graphics/ColorFilter;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "(JJLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getMultiply-0d7_KjU", "()J", "J", "getAdd-0d7_KjU", "equals", "", "other", "", "hashCode", "", "toString", "", "ui-graphics_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class LightingColorFilter extends ColorFilter {
    private final long add;
    private final long multiply;

    public /* synthetic */ LightingColorFilter(long r100, long r101, android.graphics.ColorFilter r102, DefaultConstructorMarker r103) {
        this(r100, r101, r102);
    }

    public /* synthetic */ LightingColorFilter(long r100, long r101, DefaultConstructorMarker r102) {
        this(r100, r101);
    }

    public int hashCode() {
        return (Color.m4834hashCodeimpl(this.multiply) * 31) + Color.m4834hashCodeimpl(this.add);
    }

    public String toString() {
        return "LightingColorFilter(multiply=" + Color.m4835toStringimpl(this.multiply) + ", add=" + Color.m4835toStringimpl(this.add) + ')';
    }

    /* JADX INFO: renamed from: getAdd-0d7_KjU, reason: not valid java name */
    public final long m5073getAdd0d7_KjU() {
        return this.add;
    }

    /* JADX INFO: renamed from: getMultiply-0d7_KjU, reason: not valid java name */
    public final long m5074getMultiply0d7_KjU() {
        return this.multiply;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof LightingColorFilter) == true) goto L8;
        return false;
    L8:
        LightingColorFilter r101 = (LightingColorFilter) r100;
        if (Color.m4828equalsimpl0(this.multiply, r101.multiply) == true) goto L12;
        return false;
    L12:
        if (Color.m4828equalsimpl0(this.add, r101.add) == true) goto L14;
        return false;
    L14:
        return true;
    }

    private LightingColorFilter(long r100, long r110) {
        this(r100, r110, AndroidColorFilter_androidKt.m4689actualLightingColorFilterOWjLjI(r100, r110), null);
    }

    private LightingColorFilter(long r100, long r101, android.graphics.ColorFilter r102) {
        super(r102);
        this.multiply = r100;
        this.add = r101;
    }
}
