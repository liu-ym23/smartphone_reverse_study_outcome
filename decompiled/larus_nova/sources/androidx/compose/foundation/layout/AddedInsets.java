package androidx.compose.foundation.layout;

import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import com.bytedance.android.live.soloktv.SoloKtvContext;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0001¢\u0006\u0004\b\u0004\u0010\u0005J\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0010\u0010\f\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\u0018\u0010\r\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0010\u0010\u000e\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\b\u0010\u000f\u001a\u00020\u0007H\u0016J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0096\u0002J\b\u0010\u0014\u001a\u00020\u0015H\u0016R\u000e\u0010\u0002\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Landroidx/compose/foundation/layout/AddedInsets;", "Landroidx/compose/foundation/layout/WindowInsets;", SoloKtvContext.SOLO_PAGE_FIRST, "second", "<init>", "(Landroidx/compose/foundation/layout/WindowInsets;Landroidx/compose/foundation/layout/WindowInsets;)V", "getLeft", "", "density", "Landroidx/compose/ui/unit/Density;", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "getTop", "getRight", "getBottom", "hashCode", "equals", "", "other", "", "toString", "", "foundation-layout"}, k = 1, mv = {2, 0, 0}, xi = 48)
final class AddedInsets implements WindowInsets {
    private final WindowInsets first;
    private final WindowInsets second;

    public int hashCode() {
        return this.first.hashCode() + (this.second.hashCode() * 31);
    }

    public String toString() {
        return "(" + this.first + " + " + this.second + ')';
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof AddedInsets) == true) goto L8;
        return false;
    L8:
        AddedInsets r101 = (AddedInsets) r100;
        if (Intrinsics.areEqual(r101.first, this.first) == true) goto L11;
    L13:
        return false;
    L11:
        if (Intrinsics.areEqual(r101.second, this.second) == false) goto L13;
        return true;
    }

    @Override // androidx.compose.foundation.layout.WindowInsets
    public int getBottom(Density r100) {
        return this.first.getBottom(r100) + this.second.getBottom(r100);
    }

    @Override // androidx.compose.foundation.layout.WindowInsets
    public int getTop(Density r100) {
        return this.first.getTop(r100) + this.second.getTop(r100);
    }

    public AddedInsets(WindowInsets r100, WindowInsets r101) {
        this.first = r100;
        this.second = r101;
    }

    @Override // androidx.compose.foundation.layout.WindowInsets
    public int getLeft(Density r100, LayoutDirection r101) {
        return this.first.getLeft(r100, r101) + this.second.getLeft(r100, r101);
    }

    @Override // androidx.compose.foundation.layout.WindowInsets
    public int getRight(Density r100, LayoutDirection r101) {
        return this.first.getRight(r100, r101) + this.second.getRight(r100, r101);
    }
}
