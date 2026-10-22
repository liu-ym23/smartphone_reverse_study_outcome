package androidx.compose.material3;

import androidx.compose.ui.graphics.Color;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\b\n\u0000\b\u0007\u0018\u00002\u00020\u0001B?\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003¢\u0006\u0004\b\n\u0010\u000bJS\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u0003¢\u0006\u0004\b\u0016\u0010\u0017J\u001f\u0010\u0018\u001a\u00020\u00032\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001aH\u0001¢\u0006\u0004\b\u001c\u0010\u001dJ\u001f\u0010\u001e\u001a\u00020\u00032\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001aH\u0001¢\u0006\u0004\b\u001f\u0010\u001dJ\u0013\u0010\"\u001a\u00020\u001a2\b\u0010#\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010$\u001a\u00020%H\u0016R\u0013\u0010\u0002\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0004\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\u000f\u0010\rR\u0013\u0010\u0005\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\u0010\u0010\rR\u0013\u0010\u0006\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\u0011\u0010\rR\u0013\u0010\u0007\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\u0012\u0010\rR\u0013\u0010\b\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\u0013\u0010\rR\u0013\u0010\t\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\u0014\u0010\rR\u0014\u0010 \u001a\u00020\u00038@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b!\u0010\r¨\u0006&"}, d2 = {"Landroidx/compose/material3/NavigationBarItemColors;", "", "selectedIconColor", "Landroidx/compose/ui/graphics/Color;", "selectedTextColor", "selectedIndicatorColor", "unselectedIconColor", "unselectedTextColor", "disabledIconColor", "disabledTextColor", "<init>", "(JJJJJJJLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getSelectedIconColor-0d7_KjU", "()J", "J", "getSelectedTextColor-0d7_KjU", "getSelectedIndicatorColor-0d7_KjU", "getUnselectedIconColor-0d7_KjU", "getUnselectedTextColor-0d7_KjU", "getDisabledIconColor-0d7_KjU", "getDisabledTextColor-0d7_KjU", "copy", "copy-4JmcsL4", "(JJJJJJJ)Landroidx/compose/material3/NavigationBarItemColors;", "iconColor", "selected", "", "enabled", "iconColor-WaAFU9c$material3", "(ZZ)J", "textColor", "textColor-WaAFU9c$material3", "indicatorColor", "getIndicatorColor-0d7_KjU$material3", "equals", "other", "hashCode", "", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class NavigationBarItemColors {
    public static final int $stable = 0;
    private final long disabledIconColor;
    private final long disabledTextColor;
    private final long selectedIconColor;
    private final long selectedIndicatorColor;
    private final long selectedTextColor;
    private final long unselectedIconColor;
    private final long unselectedTextColor;

    public /* synthetic */ NavigationBarItemColors(long r100, long r101, long r102, long r103, long r104, long r110, long r111, DefaultConstructorMarker r112) {
        this(r100, r101, r102, r103, r104, r110, r111);
    }

    public int hashCode() {
        return (((((((((((Color.m4834hashCodeimpl(this.selectedIconColor) * 31) + Color.m4834hashCodeimpl(this.unselectedIconColor)) * 31) + Color.m4834hashCodeimpl(this.selectedTextColor)) * 31) + Color.m4834hashCodeimpl(this.unselectedTextColor)) * 31) + Color.m4834hashCodeimpl(this.selectedIndicatorColor)) * 31) + Color.m4834hashCodeimpl(this.disabledIconColor)) * 31) + Color.m4834hashCodeimpl(this.disabledTextColor);
    }

    /* JADX INFO: renamed from: getDisabledIconColor-0d7_KjU, reason: not valid java name */
    public final long m2401getDisabledIconColor0d7_KjU() {
        return this.disabledIconColor;
    }

    /* JADX INFO: renamed from: getDisabledTextColor-0d7_KjU, reason: not valid java name */
    public final long m2402getDisabledTextColor0d7_KjU() {
        return this.disabledTextColor;
    }

    /* JADX INFO: renamed from: getIndicatorColor-0d7_KjU$material3, reason: not valid java name */
    public final long m2403getIndicatorColor0d7_KjU$material3() {
        return this.selectedIndicatorColor;
    }

    /* JADX INFO: renamed from: getSelectedIconColor-0d7_KjU, reason: not valid java name */
    public final long m2404getSelectedIconColor0d7_KjU() {
        return this.selectedIconColor;
    }

    /* JADX INFO: renamed from: getSelectedIndicatorColor-0d7_KjU, reason: not valid java name */
    public final long m2405getSelectedIndicatorColor0d7_KjU() {
        return this.selectedIndicatorColor;
    }

    /* JADX INFO: renamed from: getSelectedTextColor-0d7_KjU, reason: not valid java name */
    public final long m2406getSelectedTextColor0d7_KjU() {
        return this.selectedTextColor;
    }

    /* JADX INFO: renamed from: getUnselectedIconColor-0d7_KjU, reason: not valid java name */
    public final long m2407getUnselectedIconColor0d7_KjU() {
        return this.unselectedIconColor;
    }

    /* JADX INFO: renamed from: getUnselectedTextColor-0d7_KjU, reason: not valid java name */
    public final long m2408getUnselectedTextColor0d7_KjU() {
        return this.unselectedTextColor;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if (r100 != null) goto L8;
    L32:
        return false;
    L8:
        if ((r100 instanceof NavigationBarItemColors) == false) goto L32;
        NavigationBarItemColors r101 = (NavigationBarItemColors) r100;
        if (Color.m4828equalsimpl0(this.selectedIconColor, r101.selectedIconColor) == true) goto L14;
        return false;
    L14:
        if (Color.m4828equalsimpl0(this.unselectedIconColor, r101.unselectedIconColor) == true) goto L17;
        return false;
    L17:
        if (Color.m4828equalsimpl0(this.selectedTextColor, r101.selectedTextColor) == true) goto L20;
        return false;
    L20:
        if (Color.m4828equalsimpl0(this.unselectedTextColor, r101.unselectedTextColor) == true) goto L23;
        return false;
    L23:
        if (Color.m4828equalsimpl0(this.selectedIndicatorColor, r101.selectedIndicatorColor) == true) goto L26;
        return false;
    L26:
        if (Color.m4828equalsimpl0(this.disabledIconColor, r101.disabledIconColor) == true) goto L29;
        return false;
    L29:
        if (Color.m4828equalsimpl0(this.disabledTextColor, r101.disabledTextColor) == true) goto L31;
        return false;
    L31:
        return true;
    }

    /* JADX INFO: renamed from: iconColor-WaAFU9c$material3, reason: not valid java name */
    public final long m2409iconColorWaAFU9c$material3(boolean r100, boolean r101) {
        if (r101 == false) goto L8;
        if (r100 == false) goto L7;
        return this.selectedIconColor;
    L7:
        return this.unselectedIconColor;
    L8:
        return this.disabledIconColor;
    }

    /* JADX INFO: renamed from: textColor-WaAFU9c$material3, reason: not valid java name */
    public final long m2410textColorWaAFU9c$material3(boolean r100, boolean r101) {
        if (r101 == false) goto L8;
        if (r100 == false) goto L7;
        return this.selectedTextColor;
    L7:
        return this.unselectedTextColor;
    L8:
        return this.disabledTextColor;
    }

    private NavigationBarItemColors(long r100, long r101, long r102, long r103, long r104, long r110, long r111) {
        this.selectedIconColor = r100;
        this.selectedTextColor = r101;
        this.selectedIndicatorColor = r102;
        this.unselectedIconColor = r103;
        this.unselectedTextColor = r104;
        this.disabledIconColor = r110;
        this.disabledTextColor = r111;
    }

    /* JADX INFO: renamed from: copy-4JmcsL4, reason: not valid java name */
    public final NavigationBarItemColors m2400copy4JmcsL4(long r210, long r211, long r212, long r310, long r311, long r312, long r313) {
        boolean r100 = true;
        if (r210 == 16) goto L5;
        boolean r101 = true;
    L6:
        if (r101 == false) goto L8;
        long r102 = r210;
    L10:
        if (r211 == 16) goto L12;
        boolean r103 = true;
    L13:
        if (r103 == false) goto L15;
        long r110 = r211;
    L17:
        if (r212 == 16) goto L19;
        boolean r104 = true;
    L20:
        if (r104 == false) goto L22;
        long r111 = r212;
    L24:
        if (r310 == 16) goto L26;
        boolean r105 = true;
    L27:
        if (r105 == false) goto L29;
        long r112 = r310;
    L31:
        if (r311 == 16) goto L33;
        boolean r106 = true;
    L34:
        if (r106 == false) goto L36;
        long r113 = r311;
    L38:
        if (r312 == 16) goto L40;
        boolean r107 = true;
    L41:
        if (r107 == false) goto L43;
        long r114 = r312;
    L45:
        if (r313 != 16) goto L48;
        r100 = false;
    L48:
        if (r100 == false) goto L50;
        long r213 = r313;
    L52:
        return new NavigationBarItemColors(r102, r110, r111, r112, r113, r114, r213, null);
    L50:
        r213 = this.disabledTextColor;
        goto L52
    L43:
        r114 = this.disabledIconColor;
        goto L45
    L40:
        r107 = false;
        goto L41
    L36:
        r113 = this.unselectedTextColor;
        goto L38
    L33:
        r106 = false;
        goto L34
    L29:
        r112 = this.unselectedIconColor;
        goto L31
    L26:
        r105 = false;
        goto L27
    L22:
        r111 = this.selectedIndicatorColor;
        goto L24
    L19:
        r104 = false;
        goto L20
    L15:
        r110 = this.selectedTextColor;
        goto L17
    L12:
        r103 = false;
        goto L13
    L8:
        r102 = this.selectedIconColor;
        goto L10
    L5:
        r101 = false;
        goto L6
    }

    /* JADX INFO: renamed from: copy-4JmcsL4$default, reason: not valid java name */
    public static /* synthetic */ NavigationBarItemColors m2399copy4JmcsL4$default(NavigationBarItemColors r110, long r111, long r112, long r210, long r211, long r212, long r213, long r214, int r310, Object r311) {
        if ((r310 & 1) == 0) goto L5;
        long r100 = r110.selectedIconColor;
    L7:
        if ((r310 & 2) == 0) goto L9;
        long r101 = r110.selectedTextColor;
    L11:
        if ((r310 & 4) == 0) goto L13;
        long r102 = r110.selectedIndicatorColor;
    L15:
        if ((r310 & 8) == 0) goto L17;
        long r103 = r110.unselectedIconColor;
    L19:
        if ((r310 & 16) == 0) goto L21;
        long r104 = r110.unselectedTextColor;
    L23:
        if ((r310 & 32) == 0) goto L25;
        long r113 = r110.disabledIconColor;
    L27:
        if ((r310 & 64) == 0) goto L29;
        long r114 = r110.disabledTextColor;
    L31:
        return r110.m2400copy4JmcsL4(r100, r101, r102, r103, r104, r113, r114);
    L29:
        r114 = r214;
        goto L31
    L25:
        r113 = r213;
        goto L27
    L21:
        r104 = r212;
        goto L23
    L17:
        r103 = r211;
        goto L19
    L13:
        r102 = r210;
        goto L15
    L9:
        r101 = r112;
        goto L11
    L5:
        r100 = r111;
        goto L7
    }
}
