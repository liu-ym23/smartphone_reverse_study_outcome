package androidx.compose.material;

import androidx.compose.ui.unit.Density;
import androidx.compose.ui.util.MathHelpersKt;
import kotlin.Deprecated;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Deprecated(message = "Material's Swipeable has been replaced by Foundation's AnchoredDraggable APIs. Please see developer.android.com for an overview of the changes and a migration guide.")
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001c\u0010\u0006\u001a\u00020\u0003*\u00020\u00072\u0006\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u0003H\u0016J\t\u0010\n\u001a\u00020\u0003HÂ\u0003J\u0013\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Landroidx/compose/material/FractionalThreshold;", "Landroidx/compose/material/ThresholdConfig;", "fraction", "", "<init>", "(F)V", "computeThreshold", "Landroidx/compose/ui/unit/Density;", "fromValue", "toValue", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "material"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class FractionalThreshold implements ThresholdConfig {
    public static final int $stable = 0;
    private final float fraction;

    private final float component1() {
        return this.fraction;
    }

    public static /* synthetic */ FractionalThreshold copy$default(FractionalThreshold r100, float r101, int r102, Object r103) {
        if ((r102 & 1) == 0) goto L6;
        r101 = r100.fraction;
    L6:
        return r100.copy(r101);
    }

    public final FractionalThreshold copy(float r100) {
        return new FractionalThreshold(r100);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof FractionalThreshold) == true) goto L9;
        return false;
    L9:
        if (Float.compare(this.fraction, ((FractionalThreshold) r100).fraction) == 0) goto L11;
        return false;
    L11:
        return true;
    }

    public int hashCode() {
        return Float.floatToIntBits(this.fraction);
    }

    public String toString() {
        return "FractionalThreshold(fraction=" + this.fraction + ')';
    }

    public FractionalThreshold(float r100) {
        this.fraction = r100;
    }

    @Override // androidx.compose.material.ThresholdConfig
    public float computeThreshold(Density r100, float r101, float r102) {
        return MathHelpersKt.lerp(r101, r102, this.fraction);
    }
}
