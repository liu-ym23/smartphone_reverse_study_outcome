package androidx.compose.material3;

import androidx.compose.runtime.Immutable;
import androidx.compose.ui.window.SecureFlagPolicy;
import kotlin.Metadata;
import kotlin.jvm.internal.e;

@Immutable
@ExperimentalMaterial3Api
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\b\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u001f\b\u0017\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\bB\u0019\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\tJ\u0013\u0010\u000e\u001a\u00020\u00032\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u0010\u001a\u00020\u0011H\u0016R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0012"}, d2 = {"Landroidx/compose/material3/ModalBottomSheetProperties;", "", "shouldDismissOnBackPress", "", "(Z)V", "securePolicy", "Landroidx/compose/ui/window/SecureFlagPolicy;", "isFocusable", "(Landroidx/compose/ui/window/SecureFlagPolicy;ZZ)V", "(Landroidx/compose/ui/window/SecureFlagPolicy;Z)V", "getSecurePolicy", "()Landroidx/compose/ui/window/SecureFlagPolicy;", "getShouldDismissOnBackPress", "()Z", "equals", "other", "hashCode", "", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class ModalBottomSheetProperties {
    public static final int $stable = 0;
    private final SecureFlagPolicy securePolicy;
    private final boolean shouldDismissOnBackPress;

    /* JADX WARN: Multi-variable type inference failed */
    public ModalBottomSheetProperties() {
        this(null, false, 3, 0 == true ? 1 : 0);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof ModalBottomSheetProperties) && this.securePolicy == ((ModalBottomSheetProperties) other).securePolicy;
    }

    public final SecureFlagPolicy getSecurePolicy() {
        return this.securePolicy;
    }

    public final boolean getShouldDismissOnBackPress() {
        return this.shouldDismissOnBackPress;
    }

    public int hashCode() {
        return Boolean.hashCode(this.shouldDismissOnBackPress) + (this.securePolicy.hashCode() * 31);
    }

    public ModalBottomSheetProperties(SecureFlagPolicy secureFlagPolicy, boolean z10) {
        this.securePolicy = secureFlagPolicy;
        this.shouldDismissOnBackPress = z10;
    }

    public /* synthetic */ ModalBottomSheetProperties(SecureFlagPolicy secureFlagPolicy, boolean z10, int i, e eVar) {
        this((i & 1) != 0 ? SecureFlagPolicy.Inherit : secureFlagPolicy, (i & 2) != 0 ? true : z10);
    }

    public /* synthetic */ ModalBottomSheetProperties(boolean z10, int i, e eVar) {
        this((i & 1) != 0 ? true : z10);
    }

    public ModalBottomSheetProperties(boolean z10) {
        this(SecureFlagPolicy.Inherit, z10);
    }

    @C7.c
    public ModalBottomSheetProperties(SecureFlagPolicy secureFlagPolicy, boolean z10, boolean z11) {
        this(secureFlagPolicy, z11);
    }
}
