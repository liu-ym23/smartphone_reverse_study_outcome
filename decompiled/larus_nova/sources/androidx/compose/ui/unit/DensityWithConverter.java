package androidx.compose.ui.unit;

import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.unit.fontscaling.FontScaleConverter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0013\u0010\f\u001a\u00020\r*\u00020\u000eH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u0013\u0010\u0011\u001a\u00020\u000e*\u00020\rH\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0006HÂ\u0003J'\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bHÖ\u0003J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0014\u0010\u0004\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Landroidx/compose/ui/unit/DensityWithConverter;", "Landroidx/compose/ui/unit/Density;", "density", "", "fontScale", "converter", "Landroidx/compose/ui/unit/fontscaling/FontScaleConverter;", "<init>", "(FFLandroidx/compose/ui/unit/fontscaling/FontScaleConverter;)V", "getDensity", "()F", "getFontScale", "toSp", "Landroidx/compose/ui/unit/TextUnit;", "Landroidx/compose/ui/unit/Dp;", "toSp-0xMU5do", "(F)J", "toDp", "toDp-GaN1DYA", "(J)F", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "ui-unit"}, k = 1, mv = {2, 0, 0}, xi = 48)
final class DensityWithConverter implements Density {
    private final FontScaleConverter converter;
    private final float density;
    private final float fontScale;

    private final FontScaleConverter component3() {
        return this.converter;
    }

    public static /* synthetic */ DensityWithConverter copy$default(DensityWithConverter r100, float r101, float r102, FontScaleConverter r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = r100.density;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = r100.fontScale;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r103 = r100.converter;
    L12:
        return r100.copy(r101, r102, r103);
    }

    public final float component1() {
        return this.density;
    }

    public final float component2() {
        return this.fontScale;
    }

    public final DensityWithConverter copy(float r100, float r101, FontScaleConverter r102) {
        return new DensityWithConverter(r100, r101, r102);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof DensityWithConverter) == true) goto L8;
        return false;
    L8:
        DensityWithConverter r101 = (DensityWithConverter) r100;
        if (Float.compare(this.density, r101.density) == 0) goto L12;
        return false;
    L12:
        if (Float.compare(this.fontScale, r101.fontScale) == 0) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.converter, r101.converter) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        return (((Float.floatToIntBits(this.density) * 31) + Float.floatToIntBits(this.fontScale)) * 31) + this.converter.hashCode();
    }

    @Override // androidx.compose.ui.unit.Density
    /* JADX INFO: renamed from: roundToPx--R2X_6o */
    public final /* synthetic */ int mo364roundToPxR2X_6o(long r100) {
        return Density.CC.m7508$default$roundToPxR2X_6o(this, r100);
    }

    @Override // androidx.compose.ui.unit.Density
    /* JADX INFO: renamed from: roundToPx-0680j_4 */
    public final /* synthetic */ int mo365roundToPx0680j_4(float r100) {
        return Density.CC.m7509$default$roundToPx0680j_4(this, r100);
    }

    @Override // androidx.compose.ui.unit.Density
    /* JADX INFO: renamed from: toDp-u2uoSUM */
    public final /* synthetic */ float mo367toDpu2uoSUM(float r100) {
        return Density.CC.m7510$default$toDpu2uoSUM(this, r100);
    }

    @Override // androidx.compose.ui.unit.Density
    /* JADX INFO: renamed from: toDp-u2uoSUM */
    public final /* synthetic */ float mo368toDpu2uoSUM(int r100) {
        return Density.CC.m7511$default$toDpu2uoSUM(this, r100);
    }

    @Override // androidx.compose.ui.unit.Density
    /* JADX INFO: renamed from: toDpSize-k-rfVVM */
    public final /* synthetic */ long mo369toDpSizekrfVVM(long r100) {
        return Density.CC.m7512$default$toDpSizekrfVVM(this, r100);
    }

    @Override // androidx.compose.ui.unit.Density
    /* JADX INFO: renamed from: toPx--R2X_6o */
    public final /* synthetic */ float mo370toPxR2X_6o(long r100) {
        return Density.CC.m7513$default$toPxR2X_6o(this, r100);
    }

    @Override // androidx.compose.ui.unit.Density
    /* JADX INFO: renamed from: toPx-0680j_4 */
    public final /* synthetic */ float mo371toPx0680j_4(float r100) {
        return Density.CC.m7514$default$toPx0680j_4(this, r100);
    }

    @Override // androidx.compose.ui.unit.Density
    public final /* synthetic */ Rect toRect(DpRect r100) {
        return Density.CC.$default$toRect(this, r100);
    }

    @Override // androidx.compose.ui.unit.Density
    /* JADX INFO: renamed from: toSize-XkaWNTQ */
    public final /* synthetic */ long mo372toSizeXkaWNTQ(long r100) {
        return Density.CC.m7515$default$toSizeXkaWNTQ(this, r100);
    }

    @Override // androidx.compose.ui.unit.Density
    /* JADX INFO: renamed from: toSp-kPz2Gy4 */
    public final /* synthetic */ long mo374toSpkPz2Gy4(float r100) {
        return Density.CC.m7516$default$toSpkPz2Gy4(this, r100);
    }

    @Override // androidx.compose.ui.unit.Density
    /* JADX INFO: renamed from: toSp-kPz2Gy4 */
    public final /* synthetic */ long mo375toSpkPz2Gy4(int r100) {
        return Density.CC.m7517$default$toSpkPz2Gy4(this, r100);
    }

    public String toString() {
        return "DensityWithConverter(density=" + this.density + ", fontScale=" + this.fontScale + ", converter=" + this.converter + ')';
    }

    @Override // androidx.compose.ui.unit.Density
    public float getDensity() {
        return this.density;
    }

    @Override // androidx.compose.ui.unit.FontScaling
    public float getFontScale() {
        return this.fontScale;
    }

    @Override // androidx.compose.ui.unit.FontScaling
    /* JADX INFO: renamed from: toDp-GaN1DYA */
    public float mo366toDpGaN1DYA(long r100) {
        if (TextUnitType.m7770equalsimpl0(TextUnit.m7741getTypeUIouoOA(r100), TextUnitType.Companion.m7775getSpUIouoOA()) == false) goto L7;
        return Dp.m7544constructorimpl(this.converter.convertSpToDp(TextUnit.m7742getValueimpl(r100)));
    L7:
        throw new IllegalStateException("Only Sp can convert to Px".toString());
    }

    @Override // androidx.compose.ui.unit.FontScaling
    /* JADX INFO: renamed from: toSp-0xMU5do */
    public long mo373toSp0xMU5do(float r100) {
        return TextUnitKt.getSp(this.converter.convertDpToSp(r100));
    }

    public DensityWithConverter(float r100, float r101, FontScaleConverter r102) {
        this.density = r100;
        this.fontScale = r101;
        this.converter = r102;
    }
}
