package androidx.compose.material3;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import java.util.Arrays;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.ClosedFloatingPointRange;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes2.dex */
@Deprecated(message = "Not necessary with the introduction of Slider state")
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0014\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0007\u0018\u00002\u00020\u0001B!\u0012\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u001a\u001a\u00020\u001bH\u0016R7\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038F@@X\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR+\u0010\u0011\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u00068F@@X\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b\u0016\u0010\u0010\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015¨\u0006\u001c"}, d2 = {"Landroidx/compose/material3/SliderPositions;", "", "initialActiveRange", "Lkotlin/ranges/ClosedFloatingPointRange;", "", "initialTickFractions", "", "<init>", "(Lkotlin/ranges/ClosedFloatingPointRange;[F)V", "<set-?>", "activeRange", "getActiveRange", "()Lkotlin/ranges/ClosedFloatingPointRange;", "setActiveRange$material3", "(Lkotlin/ranges/ClosedFloatingPointRange;)V", "activeRange$delegate", "Landroidx/compose/runtime/MutableState;", "tickFractions", "getTickFractions", "()[F", "setTickFractions$material3", "([F)V", "tickFractions$delegate", "equals", "", "other", "hashCode", "", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class SliderPositions {
    public static final int $stable = 0;
    private final MutableState activeRange$delegate;
    private final MutableState tickFractions$delegate;

    /* JADX WARN: Multi-variable type inference failed */
    public SliderPositions() {
        Object[] r100 = 0 == true ? 1 : 0;
        this(null, r100, 3, 0 == true ? 1 : 0);
    }

    public final ClosedFloatingPointRange<Float> getActiveRange() {
        return (ClosedFloatingPointRange) this.activeRange$delegate.getValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final float[] getTickFractions() {
        return (float[]) this.tickFractions$delegate.getValue();
    }

    public int hashCode() {
        return (getActiveRange().hashCode() * 31) + Arrays.hashCode(getTickFractions());
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof SliderPositions) == true) goto L8;
        return false;
    L8:
        SliderPositions r101 = (SliderPositions) r100;
        if (Intrinsics.areEqual(getActiveRange(), r101.getActiveRange()) == true) goto L12;
        return false;
    L12:
        if (Arrays.equals(getTickFractions(), r101.getTickFractions()) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final void setActiveRange$material3(ClosedFloatingPointRange<Float> r100) {
        this.activeRange$delegate.setValue(r100);
    }

    public final void setTickFractions$material3(float[] r100) {
        this.tickFractions$delegate.setValue(r100);
    }

    public SliderPositions(ClosedFloatingPointRange<Float> r100, float[] r101) {
        this.activeRange$delegate = SnapshotStateKt.mutableStateOf$default(r100, null, 2, null);
        this.tickFractions$delegate = SnapshotStateKt.mutableStateOf$default(r101, null, 2, null);
    }

    public /* synthetic */ SliderPositions(ClosedFloatingPointRange r100, float[] r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 1) == 0) goto L6;
        r100 = RangesKt.rangeTo(0.0f, 1.0f);
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = new float[0];
    L8:
        this(r100, r101);
    }
}
