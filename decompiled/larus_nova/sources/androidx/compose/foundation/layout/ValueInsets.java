package androidx.compose.foundation.layout;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0001\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0018\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\u0010\u0010\u0018\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\u0018\u0010\u0019\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\u0010\u0010\u001a\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0096\u0002J\b\u0010\u001f\u001a\u00020\u0013H\u0016J\b\u0010 \u001a\u00020\u0005H\u0016R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR+\u0010\u000b\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u00038@@@X\u0080\u008e\u0002¢\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006!"}, d2 = {"Landroidx/compose/foundation/layout/ValueInsets;", "Landroidx/compose/foundation/layout/WindowInsets;", "insets", "Landroidx/compose/foundation/layout/InsetsValues;", "name", "", "<init>", "(Landroidx/compose/foundation/layout/InsetsValues;Ljava/lang/String;)V", "getName", "()Ljava/lang/String;", "<set-?>", "value", "getValue$foundation_layout", "()Landroidx/compose/foundation/layout/InsetsValues;", "setValue$foundation_layout", "(Landroidx/compose/foundation/layout/InsetsValues;)V", "value$delegate", "Landroidx/compose/runtime/MutableState;", "getLeft", "", "density", "Landroidx/compose/ui/unit/Density;", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "getTop", "getRight", "getBottom", "equals", "", "other", "", "hashCode", "toString", "foundation-layout"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ValueInsets implements WindowInsets {
    public static final int $stable = 0;
    private final String name;
    private final MutableState value$delegate;

    /* JADX WARN: Multi-variable type inference failed */
    public final InsetsValues getValue$foundation_layout() {
        return (InsetsValues) this.value$delegate.getValue();
    }

    public int hashCode() {
        return this.name.hashCode();
    }

    public String toString() {
        return this.name + "(left=" + getValue$foundation_layout().getLeft() + ", top=" + getValue$foundation_layout().getTop() + ", right=" + getValue$foundation_layout().getRight() + ", bottom=" + getValue$foundation_layout().getBottom() + ')';
    }

    public final String getName() {
        return this.name;
    }

    public boolean equals(Object r100) {
        if (r100 != this) goto L6;
        return true;
    L6:
        if ((r100 instanceof ValueInsets) == true) goto L10;
        return false;
    L10:
        return Intrinsics.areEqual(getValue$foundation_layout(), ((ValueInsets) r100).getValue$foundation_layout());
    }

    @Override // androidx.compose.foundation.layout.WindowInsets
    public int getBottom(Density r100) {
        return getValue$foundation_layout().getBottom();
    }

    @Override // androidx.compose.foundation.layout.WindowInsets
    public int getTop(Density r100) {
        return getValue$foundation_layout().getTop();
    }

    public final void setValue$foundation_layout(InsetsValues r100) {
        this.value$delegate.setValue(r100);
    }

    public ValueInsets(InsetsValues r100, String r101) {
        this.name = r101;
        this.value$delegate = SnapshotStateKt.mutableStateOf$default(r100, null, 2, null);
    }

    @Override // androidx.compose.foundation.layout.WindowInsets
    public int getLeft(Density r100, LayoutDirection r101) {
        return getValue$foundation_layout().getLeft();
    }

    @Override // androidx.compose.foundation.layout.WindowInsets
    public int getRight(Density r100, LayoutDirection r101) {
        return getValue$foundation_layout().getRight();
    }
}
