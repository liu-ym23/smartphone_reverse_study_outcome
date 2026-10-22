package androidx.compose.ui.unit;

import androidx.compose.ui.geometry.Rect;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\u0004\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0015"}, d2 = {"Landroidx/compose/ui/unit/DensityImpl;", "Landroidx/compose/ui/unit/Density;", "density", "", "fontScale", "<init>", "(FF)V", "getDensity", "()F", "getFontScale", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "ui-unit"}, k = 1, mv = {2, 0, 0}, xi = 48)
final class DensityImpl implements Density {
    private final float density;
    private final float fontScale;

    public static /* synthetic */ DensityImpl copy$default(DensityImpl r100, float r101, float r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.density;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.fontScale;
    L9:
        return r100.copy(r101, r102);
    }

    public final float component1() {
        return this.density;
    }

    public final float component2() {
        return this.fontScale;
    }

    public final DensityImpl copy(float r100, float r101) {
        return new DensityImpl(r100, r101);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof DensityImpl) == true) goto L8;
        return false;
    L8:
        DensityImpl r101 = (DensityImpl) r100;
        if (Float.compare(this.density, r101.density) == 0) goto L12;
        return false;
    L12:
        if (Float.compare(this.fontScale, r101.fontScale) == 0) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        return (Float.floatToIntBits(this.density) * 31) + Float.floatToIntBits(this.fontScale);
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

    @Override // androidx.compose.ui.unit.FontScaling
    /* JADX INFO: renamed from: toDp-GaN1DYA */
    public final /* synthetic */ float mo366toDpGaN1DYA(long r100) {
        return FontScaling.CC.m7653$default$toDpGaN1DYA(this, r100);
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

    @Override // androidx.compose.ui.unit.FontScaling
    /* JADX INFO: renamed from: toSp-0xMU5do */
    public final /* synthetic */ long mo373toSp0xMU5do(float r100) {
        return FontScaling.CC.m7654$default$toSp0xMU5do(this, r100);
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
        return "DensityImpl(density=" + this.density + ", fontScale=" + this.fontScale + ')';
    }

    @Override // androidx.compose.ui.unit.Density
    public float getDensity() {
        return this.density;
    }

    @Override // androidx.compose.ui.unit.FontScaling
    public float getFontScale() {
        return this.fontScale;
    }

    public DensityImpl(float r100, float r101) {
        this.density = r100;
        this.fontScale = r101;
    }
}
