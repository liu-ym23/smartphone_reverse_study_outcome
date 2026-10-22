package androidx.compose.ui;

import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import org.bouncycastle.asn1.cmc.BodyPartID;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0087\b\u0018\u00002\u00020\u0001:\u0002\u001e\u001fB\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J'\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019HÖ\u0003J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006 "}, d2 = {"Landroidx/compose/ui/BiasAlignment;", "Landroidx/compose/ui/Alignment;", "horizontalBias", "", "verticalBias", "<init>", "(FF)V", "getHorizontalBias", "()F", "getVerticalBias", "align", "Landroidx/compose/ui/unit/IntOffset;", "size", "Landroidx/compose/ui/unit/IntSize;", "space", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "align-KFBX0sM", "(JJLandroidx/compose/ui/unit/LayoutDirection;)J", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "Horizontal", "Vertical", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class BiasAlignment implements Alignment {
    public static final int $stable = 0;
    private final float horizontalBias;
    private final float verticalBias;

    @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J \u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\rH\u0016J\u0011\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0096\u0002J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0010\u001a\u0004\u0018\u00010\u0016HÖ\u0003J\t\u0010\u0017\u001a\u00020\tHÖ\u0001J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u001a"}, d2 = {"Landroidx/compose/ui/BiasAlignment$Horizontal;", "Landroidx/compose/ui/Alignment$Horizontal;", "bias", "", "<init>", "(F)V", "getBias", "()F", "align", "", "size", "space", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "plus", "Landroidx/compose/ui/Alignment;", "other", "Landroidx/compose/ui/Alignment$Vertical;", "component1", "copy", "equals", "", "", "hashCode", "toString", "", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Horizontal implements Alignment.Horizontal {
        public static final int $stable = 0;
        private final float bias;

        public static /* synthetic */ Horizontal copy$default(Horizontal r100, float r101, int r102, Object r103) {
            if ((r102 & 1) == 0) goto L6;
            r101 = r100.bias;
        L6:
            return r100.copy(r101);
        }

        public final float component1() {
            return this.bias;
        }

        public final Horizontal copy(float r100) {
            return new Horizontal(r100);
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof Horizontal) == true) goto L9;
            return false;
        L9:
            if (Float.compare(this.bias, ((Horizontal) r100).bias) == 0) goto L11;
            return false;
        L11:
            return true;
        }

        public int hashCode() {
            return Float.floatToIntBits(this.bias);
        }

        public String toString() {
            return "Horizontal(bias=" + this.bias + ')';
        }

        public final float getBias() {
            return this.bias;
        }

        public Horizontal(float r100) {
            this.bias = r100;
        }

        @Override // androidx.compose.ui.Alignment.Horizontal
        public Alignment plus(Alignment.Vertical r100) {
            if ((r100 instanceof Vertical) == false) goto L6;
            return new BiasAlignment(this.bias, ((Vertical) r100).getBias());
        L6:
            return Alignment.Horizontal.CC.$default$plus(this, r100);
        }

        @Override // androidx.compose.ui.Alignment.Horizontal
        public int align(int r100, int r101, LayoutDirection r102) {
            float r103 = (r101 - r100) / 2.0f;
            if (r102 != LayoutDirection.Ltr) goto L5;
            float r104 = this.bias;
        L7:
            return Math.round(r103 * (1 + r104));
        L5:
            r104 = (-1) * this.bias;
            goto L7
        }
    }

    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0018\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\tH\u0016J\u0011\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0096\u0002J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u000e\u001a\u0004\u0018\u00010\u0014HÖ\u0003J\t\u0010\u0015\u001a\u00020\tHÖ\u0001J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0018"}, d2 = {"Landroidx/compose/ui/BiasAlignment$Vertical;", "Landroidx/compose/ui/Alignment$Vertical;", "bias", "", "<init>", "(F)V", "getBias", "()F", "align", "", "size", "space", "plus", "Landroidx/compose/ui/Alignment;", "other", "Landroidx/compose/ui/Alignment$Horizontal;", "component1", "copy", "equals", "", "", "hashCode", "toString", "", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Vertical implements Alignment.Vertical {
        public static final int $stable = 0;
        private final float bias;

        public static /* synthetic */ Vertical copy$default(Vertical r100, float r101, int r102, Object r103) {
            if ((r102 & 1) == 0) goto L6;
            r101 = r100.bias;
        L6:
            return r100.copy(r101);
        }

        public final float component1() {
            return this.bias;
        }

        public final Vertical copy(float r100) {
            return new Vertical(r100);
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof Vertical) == true) goto L9;
            return false;
        L9:
            if (Float.compare(this.bias, ((Vertical) r100).bias) == 0) goto L11;
            return false;
        L11:
            return true;
        }

        public int hashCode() {
            return Float.floatToIntBits(this.bias);
        }

        public String toString() {
            return "Vertical(bias=" + this.bias + ')';
        }

        public final float getBias() {
            return this.bias;
        }

        public Vertical(float r100) {
            this.bias = r100;
        }

        @Override // androidx.compose.ui.Alignment.Vertical
        public Alignment plus(Alignment.Horizontal r100) {
            if ((r100 instanceof Horizontal) == false) goto L6;
            return new BiasAlignment(((Horizontal) r100).getBias(), this.bias);
        L6:
            if ((r100 instanceof BiasAbsoluteAlignment.Horizontal) == false) goto L9;
            return new BiasAbsoluteAlignment(((BiasAbsoluteAlignment.Horizontal) r100).getBias(), this.bias);
        L9:
            return Alignment.Vertical.CC.$default$plus(this, r100);
        }

        @Override // androidx.compose.ui.Alignment.Vertical
        public int align(int r100, int r101) {
            return Math.round(((r101 - r100) / 2.0f) * (1 + this.bias));
        }
    }

    public static /* synthetic */ BiasAlignment copy$default(BiasAlignment r100, float r101, float r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.horizontalBias;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.verticalBias;
    L9:
        return r100.copy(r101, r102);
    }

    public final float component1() {
        return this.horizontalBias;
    }

    public final float component2() {
        return this.verticalBias;
    }

    public final BiasAlignment copy(float r100, float r101) {
        return new BiasAlignment(r100, r101);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof BiasAlignment) == true) goto L8;
        return false;
    L8:
        BiasAlignment r101 = (BiasAlignment) r100;
        if (Float.compare(this.horizontalBias, r101.horizontalBias) == 0) goto L12;
        return false;
    L12:
        if (Float.compare(this.verticalBias, r101.verticalBias) == 0) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        return (Float.floatToIntBits(this.horizontalBias) * 31) + Float.floatToIntBits(this.verticalBias);
    }

    public String toString() {
        return "BiasAlignment(horizontalBias=" + this.horizontalBias + ", verticalBias=" + this.verticalBias + ')';
    }

    public final float getHorizontalBias() {
        return this.horizontalBias;
    }

    public final float getVerticalBias() {
        return this.verticalBias;
    }

    public BiasAlignment(float r100, float r101) {
        this.horizontalBias = r100;
        this.verticalBias = r101;
    }

    @Override // androidx.compose.ui.Alignment
    /* JADX INFO: renamed from: align-KFBX0sM */
    public long mo4305alignKFBX0sM(long r100, long r101, LayoutDirection r110) {
        float r102 = (((int) (r101 >> 32)) - ((int) (r100 >> 32))) / 2.0f;
        float r103 = (((int) (r101 & BodyPartID.bodyIdMax)) - ((int) (r100 & BodyPartID.bodyIdMax))) / 2.0f;
        if (r110 != LayoutDirection.Ltr) goto L5;
        float r104 = this.horizontalBias;
    L6:
        float r105 = 1;
        float r106 = r103 * (r105 + this.verticalBias);
        return IntOffset.m7670constructorimpl((((long) Math.round(r102 * (r104 + r105))) << 32) | (((long) Math.round(r106)) & BodyPartID.bodyIdMax));
    L5:
        r104 = (-1) * this.horizontalBias;
        goto L6
    }
}
