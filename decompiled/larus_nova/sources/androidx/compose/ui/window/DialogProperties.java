package androidx.compose.ui.window;

import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0011\n\u0002\u0010\b\n\u0000\b\u0007\u0018\u00002\u00020\u0001BC\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fB'\b\u0016\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003¢\u0006\u0004\b\u000b\u0010\rB;\b\u0017\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003¢\u0006\u0004\b\u000b\u0010\u000eB'\b\u0017\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u000b\u0010\u000fJ\u0013\u0010\u0019\u001a\u00020\u00032\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u001b\u001a\u00020\u001cH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0011R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0011R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018¨\u0006\u001d"}, d2 = {"Landroidx/compose/ui/window/DialogProperties;", "", "dismissOnBackPress", "", "dismissOnClickOutside", "securePolicy", "Landroidx/compose/ui/window/SecureFlagPolicy;", "usePlatformDefaultWidth", "decorFitsSystemWindows", "windowTitle", "", "<init>", "(ZZLandroidx/compose/ui/window/SecureFlagPolicy;ZZLjava/lang/String;)V", "(ZZZ)V", "(ZZLandroidx/compose/ui/window/SecureFlagPolicy;ZZ)V", "(ZZLandroidx/compose/ui/window/SecureFlagPolicy;)V", "getDismissOnBackPress", "()Z", "getDismissOnClickOutside", "getSecurePolicy", "()Landroidx/compose/ui/window/SecureFlagPolicy;", "getUsePlatformDefaultWidth", "getDecorFitsSystemWindows", "getWindowTitle", "()Ljava/lang/String;", "equals", "other", "hashCode", "", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class DialogProperties {
    public static final int $stable = 0;
    private final boolean decorFitsSystemWindows;
    private final boolean dismissOnBackPress;
    private final boolean dismissOnClickOutside;
    private final SecureFlagPolicy securePolicy;
    private final boolean usePlatformDefaultWidth;
    private final String windowTitle;

    public DialogProperties() {
        this(false, false, null, false, false, null, 63, null);
    }

    public int hashCode() {
        int r100 = 1231;
        if (this.dismissOnBackPress == false) goto L5;
        int r101 = 1231;
    L6:
        int r102 = r101 * 31;
        if (this.dismissOnClickOutside == false) goto L9;
        int r103 = 1231;
    L10:
        int r104 = (((r102 + r103) * 31) + this.securePolicy.hashCode()) * 31;
        if (this.usePlatformDefaultWidth == false) goto L13;
        int r105 = 1231;
    L14:
        int r106 = (r104 + r105) * 31;
        if (this.decorFitsSystemWindows == true) goto L19;
        r100 = 1237;
    L19:
        return r106 + r100;
    L13:
        r105 = 1237;
        goto L14
    L9:
        r103 = 1237;
        goto L10
    L5:
        r101 = 1237;
        goto L6
    }

    public final boolean getDecorFitsSystemWindows() {
        return this.decorFitsSystemWindows;
    }

    public final boolean getDismissOnBackPress() {
        return this.dismissOnBackPress;
    }

    public final boolean getDismissOnClickOutside() {
        return this.dismissOnClickOutside;
    }

    public final SecureFlagPolicy getSecurePolicy() {
        return this.securePolicy;
    }

    public final boolean getUsePlatformDefaultWidth() {
        return this.usePlatformDefaultWidth;
    }

    public final String getWindowTitle() {
        return this.windowTitle;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof DialogProperties) == true) goto L8;
        return false;
    L8:
        DialogProperties r101 = (DialogProperties) r100;
        if (this.dismissOnBackPress == r101.dismissOnBackPress) goto L12;
        return false;
    L12:
        if (this.dismissOnClickOutside == r101.dismissOnClickOutside) goto L15;
        return false;
    L15:
        if (this.securePolicy == r101.securePolicy) goto L18;
        return false;
    L18:
        if (this.usePlatformDefaultWidth == r101.usePlatformDefaultWidth) goto L21;
        return false;
    L21:
        if (this.decorFitsSystemWindows == r101.decorFitsSystemWindows) goto L23;
        return false;
    L23:
        return true;
    }

    public DialogProperties(boolean r110, boolean r111, boolean r112) {
        this(r110, r111, SecureFlagPolicy.Inherit, r112, true, null, 32, null);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Maintained for binary compatibility")
    public /* synthetic */ DialogProperties(boolean r110, boolean r111, SecureFlagPolicy r112) {
        this(r110, r111, r112, true, true, null, 32, null);
    }

    public /* synthetic */ DialogProperties(boolean r100, boolean r101, SecureFlagPolicy r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 1) == 0) goto L6;
        r100 = true;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r101 = true;
    L9:
        if ((r103 & 4) == 0) goto L11;
        r102 = SecureFlagPolicy.Inherit;
    L11:
        this(r100, r101, r102);
    }

    public /* synthetic */ DialogProperties(boolean r100, boolean r101, boolean r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 1) == 0) goto L6;
        r100 = true;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r101 = true;
    L9:
        if ((r103 & 4) == 0) goto L11;
        r102 = true;
    L11:
        this(r100, r101, r102);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Maintained for binary compatibility")
    public /* synthetic */ DialogProperties(boolean r100, boolean r101, SecureFlagPolicy r110, boolean r111, boolean r112) {
        this(r100, r101, SecureFlagPolicy.Inherit, r111, true, "");
    }

    public DialogProperties(boolean r100, boolean r101, SecureFlagPolicy r102, boolean r103, boolean r104, String r105) {
        this.dismissOnBackPress = r100;
        this.dismissOnClickOutside = r101;
        this.securePolicy = r102;
        this.usePlatformDefaultWidth = r103;
        this.decorFitsSystemWindows = r104;
        this.windowTitle = r105;
    }

    public /* synthetic */ DialogProperties(boolean r100, boolean r101, SecureFlagPolicy r102, boolean r103, boolean r104, int r110, DefaultConstructorMarker r111) {
        if ((r110 & 1) == 0) goto L5;
        boolean r112 = true;
    L7:
        if ((r110 & 2) == 0) goto L9;
        boolean r105 = true;
    L11:
        if ((r110 & 4) == 0) goto L13;
        r102 = SecureFlagPolicy.Inherit;
    L13:
        SecureFlagPolicy r106 = r102;
        if ((r110 & 8) == 0) goto L16;
        boolean r107 = true;
    L18:
        if ((r110 & 16) == 0) goto L20;
        boolean r113 = true;
    L21:
        this(r112, r105, r106, r107, r113);
        return;
    L20:
        r113 = r104;
        goto L21
    L16:
        r107 = r103;
        goto L18
    L9:
        r105 = r101;
        goto L11
    L5:
        r112 = r100;
        goto L7
    }

    public /* synthetic */ DialogProperties(boolean r100, boolean r101, SecureFlagPolicy r102, boolean r103, boolean r104, String r110, int r111, DefaultConstructorMarker r112) {
        boolean r105 = true;
        if ((r111 & 1) == 0) goto L5;
        boolean r113 = true;
    L7:
        if ((r111 & 2) == 0) goto L9;
        boolean r106 = true;
    L11:
        if ((r111 & 4) == 0) goto L13;
        r102 = SecureFlagPolicy.Inherit;
    L13:
        SecureFlagPolicy r107 = r102;
        if ((r111 & 8) == 0) goto L16;
        boolean r108 = true;
    L18:
        if ((r111 & 16) != 0) goto L22;
        r105 = r104;
    L22:
        if ((r111 & 32) == 0) goto L24;
        r110 = "";
    L24:
        String r114 = r110;
        this(r113, r106, r107, r108, r105, r114);
        return;
    L16:
        r108 = r103;
        goto L18
    L9:
        r106 = r101;
        goto L11
    L5:
        r113 = r100;
        goto L7
    }
}
