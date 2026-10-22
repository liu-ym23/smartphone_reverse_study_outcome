package androidx.compose.foundation.layout;

import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0010\u0010\f\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\u0018\u0010\r\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0010\u0010\u000e\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\b\u0010\u000f\u001a\u00020\u0010H\u0016J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0096\u0002J\b\u0010\u0015\u001a\u00020\u0007H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Landroidx/compose/foundation/layout/PaddingValuesInsets;", "Landroidx/compose/foundation/layout/WindowInsets;", "paddingValues", "Landroidx/compose/foundation/layout/PaddingValues;", "<init>", "(Landroidx/compose/foundation/layout/PaddingValues;)V", "getLeft", "", "density", "Landroidx/compose/ui/unit/Density;", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "getTop", "getRight", "getBottom", "toString", "", "equals", "", "other", "", "hashCode", "foundation-layout"}, k = 1, mv = {2, 0, 0}, xi = 48)
final class PaddingValuesInsets implements WindowInsets {
    private final PaddingValues paddingValues;

    public int hashCode() {
        return this.paddingValues.hashCode();
    }

    public String toString() {
        LayoutDirection r100 = LayoutDirection.Ltr;
        return "PaddingValues(" + Dp.m7555toStringimpl(this.paddingValues.mo681calculateLeftPaddingu2uoSUM(r100)) + ", " + Dp.m7555toStringimpl(this.paddingValues.mo683calculateTopPaddingD9Ej5fM()) + ", " + Dp.m7555toStringimpl(this.paddingValues.mo682calculateRightPaddingu2uoSUM(r100)) + ", " + Dp.m7555toStringimpl(this.paddingValues.mo680calculateBottomPaddingD9Ej5fM()) + ')';
    }

    public PaddingValuesInsets(PaddingValues r100) {
        this.paddingValues = r100;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof PaddingValuesInsets) == true) goto L10;
        return false;
    L10:
        return Intrinsics.areEqual(((PaddingValuesInsets) r100).paddingValues, this.paddingValues);
    }

    @Override // androidx.compose.foundation.layout.WindowInsets
    public int getBottom(Density r100) {
        return r100.mo365roundToPx0680j_4(this.paddingValues.mo680calculateBottomPaddingD9Ej5fM());
    }

    @Override // androidx.compose.foundation.layout.WindowInsets
    public int getTop(Density r100) {
        return r100.mo365roundToPx0680j_4(this.paddingValues.mo683calculateTopPaddingD9Ej5fM());
    }

    @Override // androidx.compose.foundation.layout.WindowInsets
    public int getLeft(Density r100, LayoutDirection r101) {
        return r100.mo365roundToPx0680j_4(this.paddingValues.mo681calculateLeftPaddingu2uoSUM(r101));
    }

    @Override // androidx.compose.foundation.layout.WindowInsets
    public int getRight(Density r100, LayoutDirection r101) {
        return r100.mo365roundToPx0680j_4(this.paddingValues.mo682calculateRightPaddingu2uoSUM(r101));
    }
}
