package androidx.compose.material3;

import androidx.compose.ui.window.SecureFlagPolicy;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\b\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007B\u0013\b\u0016\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\bJ\u0013\u0010\r\u001a\u00020\u00052\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u000f\u001a\u00020\u0010H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0011"}, d2 = {"Landroidx/compose/material3/ModalWideNavigationRailProperties;", "", "securePolicy", "Landroidx/compose/ui/window/SecureFlagPolicy;", "shouldDismissOnBackPress", "", "<init>", "(Landroidx/compose/ui/window/SecureFlagPolicy;Z)V", "(Z)V", "getSecurePolicy", "()Landroidx/compose/ui/window/SecureFlagPolicy;", "getShouldDismissOnBackPress", "()Z", "equals", "other", "hashCode", "", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ModalWideNavigationRailProperties {
    public static final int $stable = 0;
    private final SecureFlagPolicy securePolicy;
    private final boolean shouldDismissOnBackPress;

    /* JADX WARN: Multi-variable type inference failed */
    public ModalWideNavigationRailProperties() {
        SecureFlagPolicy r100 = null;
        this(r100, false, 3, 0 == true ? 1 : 0);
    }

    public int hashCode() {
        int r100 = this.securePolicy.hashCode() * 31;
        if (this.shouldDismissOnBackPress == false) goto L5;
        int r101 = 1231;
    L7:
        return r100 + r101;
    L5:
        r101 = 1237;
        goto L7
    }

    public final SecureFlagPolicy getSecurePolicy() {
        return this.securePolicy;
    }

    public final boolean getShouldDismissOnBackPress() {
        return this.shouldDismissOnBackPress;
    }

    public ModalWideNavigationRailProperties(boolean r100) {
        this(SecureFlagPolicy.Inherit, r100);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof ModalWideNavigationRailProperties) == true) goto L9;
        return false;
    L9:
        if (this.securePolicy == ((ModalWideNavigationRailProperties) r100).securePolicy) goto L11;
        return false;
    L11:
        return true;
    }

    public ModalWideNavigationRailProperties(SecureFlagPolicy r100, boolean r101) {
        this.securePolicy = r100;
        this.shouldDismissOnBackPress = r101;
    }

    public /* synthetic */ ModalWideNavigationRailProperties(boolean r100, int r101, DefaultConstructorMarker r102) {
        if ((r101 & 1) == 0) goto L5;
        r100 = true;
    L5:
        this(r100);
    }

    public /* synthetic */ ModalWideNavigationRailProperties(SecureFlagPolicy r100, boolean r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 1) == 0) goto L6;
        r100 = SecureFlagPolicy.Inherit;
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = true;
    L8:
        this(r100, r101);
    }
}
