package androidx.compose.ui.graphics;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0007\u0018\u00002\u00020\u0001B-\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\b\u0010\u000b\u001a\u00020\fH\u0015J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0096\u0002J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\b\u0010\u0013\u001a\u00020\u0014H\u0016R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\n¨\u0006\u0015"}, d2 = {"Landroidx/compose/ui/graphics/BlurEffect;", "Landroidx/compose/ui/graphics/RenderEffect;", "renderEffect", "radiusX", "", "radiusY", "edgeTreatment", "Landroidx/compose/ui/graphics/TileMode;", "<init>", "(Landroidx/compose/ui/graphics/RenderEffect;FFILkotlin/jvm/internal/DefaultConstructorMarker;)V", "I", "createRenderEffect", "Landroid/graphics/RenderEffect;", "equals", "", "other", "", "hashCode", "", "toString", "", "ui-graphics_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class BlurEffect extends RenderEffect {
    private final int edgeTreatment;
    private final float radiusX;
    private final float radiusY;
    private final RenderEffect renderEffect;

    public /* synthetic */ BlurEffect(RenderEffect r100, float r101, float r102, int r103, DefaultConstructorMarker r104) {
        this(r100, r101, r102, r103);
    }

    @Override // androidx.compose.ui.graphics.RenderEffect
    public android.graphics.RenderEffect createRenderEffect() {
        return RenderEffectVerificationHelper.INSTANCE.m5158createBlurEffect8A3gB4(this.renderEffect, this.radiusX, this.radiusY, this.edgeTreatment);
    }

    public int hashCode() {
        RenderEffect r100 = this.renderEffect;
        if (r100 == null) goto L5;
        int r101 = r100.hashCode();
    L7:
        return (((((r101 * 31) + Float.floatToIntBits(this.radiusX)) * 31) + Float.floatToIntBits(this.radiusY)) * 31) + TileMode.m5223hashCodeimpl(this.edgeTreatment);
    L5:
        r101 = 0;
        goto L7
    }

    public String toString() {
        return "BlurEffect(renderEffect=" + this.renderEffect + ", radiusX=" + this.radiusX + ", radiusY=" + this.radiusY + ", edgeTreatment=" + TileMode.m5224toStringimpl(this.edgeTreatment) + ')';
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof BlurEffect) == true) goto L8;
        return false;
    L8:
        BlurEffect r101 = (BlurEffect) r100;
        if (this.radiusX != r101.radiusX) goto L11;
        boolean r102 = true;
    L12:
        if (r102 == true) goto L15;
        return false;
    L15:
        if (this.radiusY != r101.radiusY) goto L17;
        boolean r103 = true;
    L18:
        if (r103 == true) goto L21;
        return false;
    L21:
        if (TileMode.m5222equalsimpl0(this.edgeTreatment, r101.edgeTreatment) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.renderEffect, r101.renderEffect) == true) goto L26;
        return false;
    L26:
        return true;
    L17:
        r103 = false;
        goto L18
    L11:
        r102 = false;
        goto L12
    }

    private BlurEffect(RenderEffect r100, float r101, float r102, int r103) {
        super(null);
        this.renderEffect = r100;
        this.radiusX = r101;
        this.radiusY = r102;
        this.edgeTreatment = r103;
    }

    public /* synthetic */ BlurEffect(RenderEffect r100, float r101, float r102, int r110, int r111, DefaultConstructorMarker r112) {
        if ((r111 & 4) == 0) goto L5;
        float r103 = r101;
    L7:
        if ((r111 & 8) == 0) goto L9;
        r110 = TileMode.Companion.m5226getClamp3opZhB0();
    L9:
        this(r100, r101, r103, r110, null);
        return;
    L5:
        r103 = r102;
        goto L7
    }
}
