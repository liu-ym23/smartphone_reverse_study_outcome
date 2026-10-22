package androidx.compose.material3;

import androidx.compose.ui.window.SecureFlagPolicy;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\b\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\t\b\u0016¢\u0006\u0004\b\u0002\u0010\u0003B\u001d\b\u0016\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0002\u0010\u0007B'\b\u0016\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0002\u0010\nB7\b\u0016\u0012\u0006\u0010\u000b\u001a\u00020\u0005\u0012\u0006\u0010\f\u001a\u00020\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0002\u0010\rB\u0011\b\u0017\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0002\u0010\u000eB\u001d\b\u0017\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0002\u0010\u000fB-\b\u0017\u0012\u0006\u0010\u000b\u001a\u00020\u0005\u0012\u0006\u0010\f\u001a\u00020\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0002\u0010\u0010J\u0013\u0010\u0019\u001a\u00020\u00052\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u001b\u001a\u00020\u001cH\u0016R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0013\u0010\u0006\u001a\u00020\u00058G¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0014R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\u0005X\u0080\u0004¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b\u0015\u0010\u0016R\u0018\u0010\f\u001a\u0004\u0018\u00010\u0005X\u0080\u0004¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b\u0018\u0010\u0016¨\u0006\u001d"}, d2 = {"Landroidx/compose/material3/ModalBottomSheetProperties;", "", "<init>", "()V", "shouldDismissOnBackPress", "", "shouldDismissOnClickOutside", "(ZZ)V", "securePolicy", "Landroidx/compose/ui/window/SecureFlagPolicy;", "(Landroidx/compose/ui/window/SecureFlagPolicy;ZZ)V", "isAppearanceLightStatusBars", "isAppearanceLightNavigationBars", "(ZZLandroidx/compose/ui/window/SecureFlagPolicy;ZZ)V", "(Z)V", "(Landroidx/compose/ui/window/SecureFlagPolicy;Z)V", "(ZZLandroidx/compose/ui/window/SecureFlagPolicy;Z)V", "getSecurePolicy", "()Landroidx/compose/ui/window/SecureFlagPolicy;", "getShouldDismissOnBackPress", "()Z", "isAppearanceLightStatusBars$material3", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "isAppearanceLightNavigationBars$material3", "equals", "other", "hashCode", "", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ModalBottomSheetProperties {
    public static final int $stable = 0;
    private final Boolean isAppearanceLightNavigationBars;
    private final Boolean isAppearanceLightStatusBars;
    private final SecureFlagPolicy securePolicy;
    private final boolean shouldDismissOnBackPress;
    private final boolean shouldDismissOnClickOutside;

    public int hashCode() {
        int r100 = this.securePolicy.hashCode() * 31;
        int r101 = 1231;
        if (this.shouldDismissOnBackPress == false) goto L5;
        int r102 = 1231;
    L6:
        int r103 = (r100 + r102) * 31;
        Boolean r104 = this.isAppearanceLightStatusBars;
        int r105 = 0;
        if (r104 == null) goto L9;
        int r106 = r104.hashCode();
    L10:
        int r107 = (r103 + r106) * 31;
        Boolean r108 = this.isAppearanceLightNavigationBars;
        if (r108 == null) goto L13;
        r105 = r108.hashCode();
    L13:
        int r109 = (r107 + r105) * 31;
        if (this.shouldDismissOnClickOutside == true) goto L18;
        r101 = 1237;
    L18:
        return r109 + r101;
    L9:
        r106 = 0;
        goto L10
    L5:
        r102 = 1237;
        goto L6
    }

    public ModalBottomSheetProperties() {
        this.securePolicy = SecureFlagPolicy.Inherit;
        this.shouldDismissOnBackPress = true;
        this.shouldDismissOnClickOutside = true;
        this.isAppearanceLightStatusBars = null;
        this.isAppearanceLightNavigationBars = null;
    }

    public final SecureFlagPolicy getSecurePolicy() {
        return this.securePolicy;
    }

    public final boolean getShouldDismissOnBackPress() {
        return this.shouldDismissOnBackPress;
    }

    public final Boolean isAppearanceLightNavigationBars$material3() {
        return this.isAppearanceLightNavigationBars;
    }

    public final Boolean isAppearanceLightStatusBars$material3() {
        return this.isAppearanceLightStatusBars;
    }

    public final boolean shouldDismissOnClickOutside() {
        return this.shouldDismissOnClickOutside;
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Replaced with additional shouldDismissOnScrimClick param constructor.")
    public /* synthetic */ ModalBottomSheetProperties(boolean r100) {
        this(r100, true);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof ModalBottomSheetProperties) == true) goto L8;
        return false;
    L8:
        ModalBottomSheetProperties r101 = (ModalBottomSheetProperties) r100;
        if (this.securePolicy == r101.securePolicy) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.isAppearanceLightStatusBars, r101.isAppearanceLightStatusBars) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.isAppearanceLightNavigationBars, r101.isAppearanceLightNavigationBars) == true) goto L18;
        return false;
    L18:
        if (this.shouldDismissOnClickOutside == r101.shouldDismissOnClickOutside) goto L21;
        return false;
    L21:
        if (this.shouldDismissOnBackPress == r101.shouldDismissOnBackPress) goto L23;
        return false;
    L23:
        return true;
    }

    public ModalBottomSheetProperties(boolean r100, boolean r101) {
        this.securePolicy = SecureFlagPolicy.Inherit;
        this.shouldDismissOnBackPress = r100;
        this.shouldDismissOnClickOutside = r101;
        this.isAppearanceLightNavigationBars = null;
        this.isAppearanceLightStatusBars = null;
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Use empty constructor or constructor including shouldDismissOnScrimClick param.")
    public /* synthetic */ ModalBottomSheetProperties(SecureFlagPolicy r100, boolean r101) {
        this(r100, r101, true);
    }

    public ModalBottomSheetProperties(SecureFlagPolicy r100, boolean r101, boolean r102) {
        this.securePolicy = r100;
        this.shouldDismissOnBackPress = r101;
        this.shouldDismissOnClickOutside = r102;
        this.isAppearanceLightNavigationBars = null;
        this.isAppearanceLightStatusBars = null;
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Use empty constructor or constructor including shouldDismissOnScrimClick param.")
    public /* synthetic */ ModalBottomSheetProperties(boolean r100, boolean r101, SecureFlagPolicy r102, boolean r103) {
        this.shouldDismissOnBackPress = r103;
        this.shouldDismissOnClickOutside = true;
        this.securePolicy = r102;
        this.isAppearanceLightStatusBars = Boolean.valueOf(r100);
        this.isAppearanceLightNavigationBars = Boolean.valueOf(r101);
    }

    public /* synthetic */ ModalBottomSheetProperties(SecureFlagPolicy r100, boolean r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 1) == 0) goto L6;
        r100 = SecureFlagPolicy.Inherit;
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = true;
    L8:
        this(r100, r101);
    }

    public /* synthetic */ ModalBottomSheetProperties(boolean r100, boolean r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 1) == 0) goto L6;
        r100 = true;
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = true;
    L8:
        this(r100, r101);
    }

    public ModalBottomSheetProperties(boolean r100, boolean r101, SecureFlagPolicy r102, boolean r103, boolean r104) {
        this.shouldDismissOnBackPress = r103;
        this.shouldDismissOnClickOutside = r104;
        this.securePolicy = r102;
        this.isAppearanceLightStatusBars = Boolean.valueOf(r100);
        this.isAppearanceLightNavigationBars = Boolean.valueOf(r101);
    }

    public /* synthetic */ ModalBottomSheetProperties(SecureFlagPolicy r100, boolean r101, boolean r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 1) == 0) goto L6;
        r100 = SecureFlagPolicy.Inherit;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r101 = true;
    L9:
        if ((r103 & 4) == 0) goto L11;
        r102 = true;
    L11:
        this(r100, r101, r102);
    }

    public /* synthetic */ ModalBottomSheetProperties(boolean r100, boolean r101, SecureFlagPolicy r102, boolean r103, int r104, DefaultConstructorMarker r105) {
        if ((r104 & 4) == 0) goto L6;
        r102 = SecureFlagPolicy.Inherit;
    L6:
        if ((r104 & 8) == 0) goto L8;
        r103 = true;
    L8:
        this(r100, r101, r102, r103);
    }

    public /* synthetic */ ModalBottomSheetProperties(boolean r100, boolean r101, SecureFlagPolicy r102, boolean r110, boolean r111, int r112, DefaultConstructorMarker r113) {
        if ((r112 & 4) == 0) goto L5;
        r102 = SecureFlagPolicy.Inherit;
    L5:
        SecureFlagPolicy r103 = r102;
        if ((r112 & 8) == 0) goto L8;
        boolean r104 = true;
    L10:
        if ((r112 & 16) == 0) goto L12;
        boolean r105 = true;
    L13:
        this(r100, r101, r103, r104, r105);
        return;
    L12:
        r105 = r111;
        goto L13
    L8:
        r104 = r110;
        goto L10
    }
}
