package androidx.compose.foundation.layout;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.core.graphics.Insets;
import androidx.core.view.WindowInsetsCompat;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0001\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0018\u0010\u001a\u001a\u00020\u00032\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001eH\u0016J\u0010\u0010\u001f\u001a\u00020\u00032\u0006\u0010\u001b\u001a\u00020\u001cH\u0016J\u0018\u0010 \u001a\u00020\u00032\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001eH\u0016J\u0010\u0010!\u001a\u00020\u00032\u0006\u0010\u001b\u001a\u00020\u001cH\u0016J\u001d\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\u0003H\u0000¢\u0006\u0002\b'J\u0013\u0010(\u001a\u00020\u00142\b\u0010)\u001a\u0004\u0018\u00010*H\u0096\u0002J\b\u0010+\u001a\u00020\u0003H\u0016J\b\u0010,\u001a\u00020\u0005H\u0016R\u0014\u0010\u0002\u001a\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R0\u0010\r\u001a\u00020\u000b2\u000b\u0010\n\u001a\u00070\u000b¢\u0006\u0002\b\f8@@@X\u0080\u008e\u0002¢\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R+\u0010\u0015\u001a\u00020\u00142\u0006\u0010\n\u001a\u00020\u00148F@BX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b\u0019\u0010\u0013\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018¨\u0006-"}, d2 = {"Landroidx/compose/foundation/layout/AndroidWindowInsets;", "Landroidx/compose/foundation/layout/WindowInsets;", "type", "", "name", "", "<init>", "(ILjava/lang/String;)V", "getType$foundation_layout", "()I", "<set-?>", "Landroidx/core/graphics/Insets;", "Lkotlin/jvm/internal/EnhancedNullability;", "insets", "getInsets$foundation_layout", "()Landroidx/core/graphics/Insets;", "setInsets$foundation_layout", "(Landroidx/core/graphics/Insets;)V", "insets$delegate", "Landroidx/compose/runtime/MutableState;", "", "isVisible", "()Z", "setVisible", "(Z)V", "isVisible$delegate", "getLeft", "density", "Landroidx/compose/ui/unit/Density;", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "getTop", "getRight", "getBottom", "update", "", "windowInsetsCompat", "Landroidx/core/view/WindowInsetsCompat;", "typeMask", "update$foundation_layout", "equals", "other", "", "hashCode", "toString", "foundation-layout"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class AndroidWindowInsets implements WindowInsets {
    public static final int $stable = 0;
    private final MutableState insets$delegate;
    private final MutableState isVisible$delegate;
    private final String name;
    private final int type;

    /* JADX WARN: Multi-variable type inference failed */
    public final Insets getInsets$foundation_layout() {
        return (Insets) this.insets$delegate.getValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean isVisible() {
        return ((Boolean) this.isVisible$delegate.getValue()).booleanValue();
    }

    public String toString() {
        return this.name + '(' + getInsets$foundation_layout().left + ", " + getInsets$foundation_layout().top + ", " + getInsets$foundation_layout().right + ", " + getInsets$foundation_layout().bottom + ')';
    }

    public final int getType$foundation_layout() {
        return this.type;
    }

    public int hashCode() {
        return this.type;
    }

    private final void setVisible(boolean r100) {
        this.isVisible$delegate.setValue(Boolean.valueOf(r100));
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof AndroidWindowInsets) == true) goto L9;
        return false;
    L9:
        if (this.type == ((AndroidWindowInsets) r100).type) goto L13;
        return false;
    L13:
        return true;
    }

    @Override // androidx.compose.foundation.layout.WindowInsets
    public int getBottom(Density r100) {
        return getInsets$foundation_layout().bottom;
    }

    @Override // androidx.compose.foundation.layout.WindowInsets
    public int getTop(Density r100) {
        return getInsets$foundation_layout().top;
    }

    public final void setInsets$foundation_layout(Insets r100) {
        this.insets$delegate.setValue(r100);
    }

    public AndroidWindowInsets(int r100, String r101) {
        this.type = r100;
        this.name = r101;
        this.insets$delegate = SnapshotStateKt.mutableStateOf$default(Insets.NONE, null, 2, null);
        this.isVisible$delegate = SnapshotStateKt.mutableStateOf$default(Boolean.TRUE, null, 2, null);
    }

    @Override // androidx.compose.foundation.layout.WindowInsets
    public int getLeft(Density r100, LayoutDirection r101) {
        return getInsets$foundation_layout().left;
    }

    @Override // androidx.compose.foundation.layout.WindowInsets
    public int getRight(Density r100, LayoutDirection r101) {
        return getInsets$foundation_layout().right;
    }

    public final void update$foundation_layout(WindowInsetsCompat r100, int r101) {
        if (r101 != 0) goto L4;
    L5:
        setInsets$foundation_layout(r100.getInsets(this.type));
        setVisible(r100.isVisible(this.type));
        return;
    L4:
        if ((r101 & this.type) != 0) goto L5;
    }
}
