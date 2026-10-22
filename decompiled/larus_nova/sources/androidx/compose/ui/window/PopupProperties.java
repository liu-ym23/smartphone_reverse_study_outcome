package androidx.compose.ui.window;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0012\b\u0007\u0018\u00002\u00020\u0001BA\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0005\u0012\b\b\u0002\u0010\t\u001a\u00020\u0005¢\u0006\u0004\b\n\u0010\u000bB1\b\u0016\u0012\b\b\u0002\u0010\f\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005\u0012\b\b\u0002\u0010\r\u001a\u00020\u0005¢\u0006\u0004\b\n\u0010\u000eBE\b\u0016\u0012\b\b\u0002\u0010\f\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0010\u0012\b\b\u0002\u0010\b\u001a\u00020\u0005\u0012\b\b\u0002\u0010\r\u001a\u00020\u0005¢\u0006\u0004\b\n\u0010\u0011BO\b\u0016\u0012\b\b\u0002\u0010\f\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0010\u0012\b\b\u0002\u0010\b\u001a\u00020\u0005\u0012\b\b\u0002\u0010\r\u001a\u00020\u0005\u0012\b\b\u0002\u0010\t\u001a\u00020\u0005¢\u0006\u0004\b\n\u0010\u0012J\u0013\u0010\u001f\u001a\u00020\u00052\b\u0010 \u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010!\u001a\u00020\u0003H\u0016R\u0014\u0010\u0002\u001a\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0004\u001a\u00020\u0005X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0016R\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0016R\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0016R\u0011\u0010\t\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0016R\u0011\u0010\f\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u0016R\u0011\u0010\u000f\u001a\u00020\u00108F¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001dR\u0011\u0010\r\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u0016¨\u0006\""}, d2 = {"Landroidx/compose/ui/window/PopupProperties;", "", "flags", "", "inheritSecurePolicy", "", "dismissOnBackPress", "dismissOnClickOutside", "excludeFromSystemGesture", "usePlatformDefaultWidth", "<init>", "(IZZZZZ)V", "focusable", "clippingEnabled", "(ZZZZ)V", "securePolicy", "Landroidx/compose/ui/window/SecureFlagPolicy;", "(ZZZLandroidx/compose/ui/window/SecureFlagPolicy;ZZ)V", "(ZZZLandroidx/compose/ui/window/SecureFlagPolicy;ZZZ)V", "getFlags$ui_release", "()I", "getInheritSecurePolicy$ui_release", "()Z", "getDismissOnBackPress", "getDismissOnClickOutside", "getExcludeFromSystemGesture", "getUsePlatformDefaultWidth", "getFocusable", "getSecurePolicy", "()Landroidx/compose/ui/window/SecureFlagPolicy;", "getClippingEnabled", "equals", "other", "hashCode", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class PopupProperties {
    public static final int $stable = 0;
    private final boolean dismissOnBackPress;
    private final boolean dismissOnClickOutside;
    private final boolean excludeFromSystemGesture;
    private final int flags;
    private final boolean inheritSecurePolicy;
    private final boolean usePlatformDefaultWidth;

    public final boolean getClippingEnabled() {
        if ((this.flags & 512) != 0) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean getFocusable() {
        if ((this.flags & 8) != 0) goto L5;
        return true;
    L5:
        return false;
    }

    public final SecureFlagPolicy getSecurePolicy() {
        if (this.inheritSecurePolicy == false) goto L6;
        return SecureFlagPolicy.Inherit;
    L6:
        if ((this.flags & 8192) != 0) goto L9;
        return SecureFlagPolicy.SecureOff;
    L9:
        return SecureFlagPolicy.SecureOn;
    }

    public int hashCode() {
        int r100 = this.flags * 31;
        int r101 = 1231;
        if (this.inheritSecurePolicy == false) goto L5;
        int r102 = 1231;
    L6:
        int r103 = (r100 + r102) * 31;
        if (this.dismissOnBackPress == false) goto L9;
        int r104 = 1231;
    L10:
        int r105 = (r103 + r104) * 31;
        if (this.dismissOnClickOutside == false) goto L13;
        int r106 = 1231;
    L14:
        int r107 = (r105 + r106) * 31;
        if (this.excludeFromSystemGesture == false) goto L17;
        int r108 = 1231;
    L18:
        int r109 = (r107 + r108) * 31;
        if (this.usePlatformDefaultWidth == true) goto L23;
        r101 = 1237;
    L23:
        return r109 + r101;
    L17:
        r108 = 1237;
        goto L18
    L13:
        r106 = 1237;
        goto L14
    L9:
        r104 = 1237;
        goto L10
    L5:
        r102 = 1237;
        goto L6
    }

    public final boolean getDismissOnBackPress() {
        return this.dismissOnBackPress;
    }

    public final boolean getDismissOnClickOutside() {
        return this.dismissOnClickOutside;
    }

    public final boolean getExcludeFromSystemGesture() {
        return this.excludeFromSystemGesture;
    }

    public final int getFlags$ui_release() {
        return this.flags;
    }

    public final boolean getInheritSecurePolicy$ui_release() {
        return this.inheritSecurePolicy;
    }

    public final boolean getUsePlatformDefaultWidth() {
        return this.usePlatformDefaultWidth;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof PopupProperties) == true) goto L8;
        return false;
    L8:
        PopupProperties r101 = (PopupProperties) r100;
        if (this.flags == r101.flags) goto L12;
        return false;
    L12:
        if (this.inheritSecurePolicy == r101.inheritSecurePolicy) goto L15;
        return false;
    L15:
        if (this.dismissOnBackPress == r101.dismissOnBackPress) goto L18;
        return false;
    L18:
        if (this.dismissOnClickOutside == r101.dismissOnClickOutside) goto L21;
        return false;
    L21:
        if (this.excludeFromSystemGesture == r101.excludeFromSystemGesture) goto L24;
        return false;
    L24:
        if (this.usePlatformDefaultWidth == r101.usePlatformDefaultWidth) goto L26;
        return false;
    L26:
        return true;
    }

    public PopupProperties(boolean r100, boolean r101, boolean r110, boolean r111) {
        this(r100, r101, r110, SecureFlagPolicy.Inherit, true, r111);
    }

    public /* synthetic */ PopupProperties(boolean r100, boolean r101, boolean r102, boolean r103, int r104, DefaultConstructorMarker r105) {
        if ((r104 & 1) == 0) goto L6;
        r100 = false;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r101 = true;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r102 = true;
    L12:
        if ((r104 & 8) == 0) goto L14;
        r103 = true;
    L14:
        this(r100, r101, r102, r103);
    }

    public PopupProperties(int r100, boolean r101, boolean r102, boolean r103, boolean r104, boolean r105) {
        this.flags = r100;
        this.inheritSecurePolicy = r101;
        this.dismissOnBackPress = r102;
        this.dismissOnClickOutside = r103;
        this.excludeFromSystemGesture = r104;
        this.usePlatformDefaultWidth = r105;
    }

    public PopupProperties(boolean r100, boolean r110, boolean r111, SecureFlagPolicy r112, boolean r113, boolean r114) {
        this(r100, r110, r111, r112, r113, r114, false);
    }

    public PopupProperties(boolean r100, boolean r101, boolean r110, SecureFlagPolicy r111, boolean r112, boolean r113, boolean r114) {
        int r102 = AndroidPopup_androidKt.access$createFlags(r100, r111, r113);
        if (r111 != SecureFlagPolicy.Inherit) goto L5;
        boolean r103 = true;
    L6:
        this(r102, r103, r101, r110, r112, r114);
        return;
    L5:
        r103 = false;
        goto L6
    }

    public /* synthetic */ PopupProperties(boolean r100, boolean r101, boolean r102, SecureFlagPolicy r103, boolean r104, boolean r110, int r111, DefaultConstructorMarker r112) {
        if ((r111 & 1) == 0) goto L5;
        r100 = false;
    L5:
        boolean r105 = true;
        if ((r111 & 2) == 0) goto L8;
        boolean r113 = true;
    L10:
        if ((r111 & 4) == 0) goto L12;
        boolean r106 = true;
    L14:
        if ((r111 & 8) == 0) goto L16;
        r103 = SecureFlagPolicy.Inherit;
    L16:
        SecureFlagPolicy r107 = r103;
        if ((r111 & 16) == 0) goto L19;
        boolean r108 = true;
    L21:
        if ((r111 & 32) != 0) goto L24;
        r105 = r110;
    L24:
        this(r100, r113, r106, r107, r108, r105);
        return;
    L19:
        r108 = r104;
        goto L21
    L12:
        r106 = r102;
        goto L14
    L8:
        r113 = r101;
        goto L10
    }

    public /* synthetic */ PopupProperties(int r100, boolean r101, boolean r102, boolean r103, boolean r110, boolean r111, int r112, DefaultConstructorMarker r113) {
        boolean r104 = true;
        if ((r112 & 2) == 0) goto L5;
        boolean r105 = true;
    L7:
        if ((r112 & 4) == 0) goto L9;
        boolean r106 = true;
    L11:
        if ((r112 & 8) == 0) goto L13;
        boolean r107 = true;
    L15:
        if ((r112 & 16) != 0) goto L19;
        r104 = r110;
    L19:
        if ((r112 & 32) == 0) goto L21;
        boolean r108 = false;
    L22:
        this(r100, r105, r106, r107, r104, r108);
        return;
    L21:
        r108 = r111;
        goto L22
    L13:
        r107 = r103;
        goto L15
    L9:
        r106 = r102;
        goto L11
    L5:
        r105 = r101;
        goto L7
    }

    public /* synthetic */ PopupProperties(boolean r100, boolean r101, boolean r102, SecureFlagPolicy r110, boolean r111, boolean r112, boolean r113, int r114, DefaultConstructorMarker r115) {
        if ((r114 & 1) == 0) goto L5;
        boolean r116 = false;
    L6:
        boolean r103 = true;
        if ((r114 & 2) == 0) goto L9;
        boolean r104 = true;
    L11:
        if ((r114 & 4) == 0) goto L13;
        boolean r105 = true;
    L15:
        if ((r114 & 8) == 0) goto L17;
        r110 = SecureFlagPolicy.Inherit;
    L17:
        SecureFlagPolicy r106 = r110;
        if ((r114 & 16) == 0) goto L20;
        boolean r107 = true;
    L22:
        if ((r114 & 32) != 0) goto L26;
        r103 = r112;
    L26:
        if ((r114 & 64) == 0) goto L28;
        boolean r117 = false;
    L29:
        this(r116, r104, r105, r106, r107, r103, r117);
        return;
    L28:
        r117 = r113;
        goto L29
    L20:
        r107 = r111;
        goto L22
    L13:
        r105 = r102;
        goto L15
    L9:
        r104 = r101;
        goto L11
    L5:
        r116 = r100;
        goto L6
    }
}
