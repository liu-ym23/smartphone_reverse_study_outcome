package androidx.compose.ui.graphics;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0007\u0018\u00002\u00020\u0001B%\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\u0010\u0006\u001a\u00060\u0007j\u0002`\b¢\u0006\u0004\b\t\u0010\nB\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\t\u0010\u000bJ\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0096\u0002J\b\u0010\u0016\u001a\u00020\u0017H\u0016J\b\u0010\u0018\u001a\u00020\u0019H\u0016R\u0013\u0010\u0002\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0004\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001a"}, d2 = {"Landroidx/compose/ui/graphics/BlendModeColorFilter;", "Landroidx/compose/ui/graphics/ColorFilter;", "color", "Landroidx/compose/ui/graphics/Color;", "blendMode", "Landroidx/compose/ui/graphics/BlendMode;", "nativeColorFilter", "Landroid/graphics/ColorFilter;", "Landroidx/compose/ui/graphics/NativeColorFilter;", "<init>", "(JILandroid/graphics/ColorFilter;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "(JILkotlin/jvm/internal/DefaultConstructorMarker;)V", "getColor-0d7_KjU", "()J", "J", "getBlendMode-0nO6VwU", "()I", "I", "equals", "", "other", "", "hashCode", "", "toString", "", "ui-graphics_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class BlendModeColorFilter extends ColorFilter {
    private final int blendMode;
    private final long color;

    public /* synthetic */ BlendModeColorFilter(long r100, int r101, android.graphics.ColorFilter r102, DefaultConstructorMarker r103) {
        this(r100, r101, r102);
    }

    public /* synthetic */ BlendModeColorFilter(long r100, int r101, DefaultConstructorMarker r102) {
        this(r100, r101);
    }

    public int hashCode() {
        return (Color.m4834hashCodeimpl(this.color) * 31) + BlendMode.m4738hashCodeimpl(this.blendMode);
    }

    public String toString() {
        return "BlendModeColorFilter(color=" + Color.m4835toStringimpl(this.color) + ", blendMode=" + BlendMode.m4739toStringimpl(this.blendMode) + ')';
    }

    /* JADX INFO: renamed from: getBlendMode-0nO6VwU, reason: not valid java name */
    public final int m4770getBlendMode0nO6VwU() {
        return this.blendMode;
    }

    /* JADX INFO: renamed from: getColor-0d7_KjU, reason: not valid java name */
    public final long m4771getColor0d7_KjU() {
        return this.color;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof BlendModeColorFilter) == true) goto L8;
        return false;
    L8:
        BlendModeColorFilter r101 = (BlendModeColorFilter) r100;
        if (Color.m4828equalsimpl0(this.color, r101.color) == true) goto L12;
        return false;
    L12:
        if (BlendMode.m4737equalsimpl0(this.blendMode, r101.blendMode) == true) goto L14;
        return false;
    L14:
        return true;
    }

    private BlendModeColorFilter(long r100, int r101) {
        this(r100, r101, AndroidColorFilter_androidKt.m4690actualTintColorFilterxETnrds(r100, r101), null);
    }

    private BlendModeColorFilter(long r100, int r101, android.graphics.ColorFilter r102) {
        super(r102);
        this.color = r100;
        this.blendMode = r101;
    }
}
