package androidx.compose.material3;

import androidx.compose.ui.graphics.Color;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b \n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\b\n\u0000\b\u0007\u0018\u00002\u00020\u0001Bg\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\u0006\u0010\f\u001a\u00020\u0003\u0012\u0006\u0010\r\u001a\u00020\u0003\u0012\u0006\u0010\u000e\u001a\u00020\u0003¢\u0006\u0004\b\u000f\u0010\u0010J\u0085\u0001\u0010\u001f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u0003¢\u0006\u0004\b \u0010!J\u001f\u0010\"\u001a\u00020\u00032\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020$H\u0001¢\u0006\u0004\b&\u0010'J\u001f\u0010(\u001a\u00020\u00032\u0006\u0010#\u001a\u00020$2\u0006\u0010)\u001a\u00020$H\u0001¢\u0006\u0004\b*\u0010'J\u001f\u0010+\u001a\u00020\u00032\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020$H\u0001¢\u0006\u0004\b,\u0010'J\u0013\u0010-\u001a\u00020$2\b\u0010.\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010/\u001a\u000200H\u0016R\u0013\u0010\u0002\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0011\u0010\u0012R\u0013\u0010\u0004\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0014\u0010\u0012R\u0013\u0010\u0005\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0015\u0010\u0012R\u0013\u0010\u0006\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0016\u0010\u0012R\u0013\u0010\u0007\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0017\u0010\u0012R\u0013\u0010\b\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0018\u0010\u0012R\u0013\u0010\t\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0019\u0010\u0012R\u0013\u0010\n\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u001a\u0010\u0012R\u0013\u0010\u000b\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u001b\u0010\u0012R\u0013\u0010\f\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u001c\u0010\u0012R\u0013\u0010\r\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u001d\u0010\u0012R\u0013\u0010\u000e\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u001e\u0010\u0012¨\u00061"}, d2 = {"Landroidx/compose/material3/SegmentedButtonColors;", "", "activeContainerColor", "Landroidx/compose/ui/graphics/Color;", "activeContentColor", "activeBorderColor", "inactiveContainerColor", "inactiveContentColor", "inactiveBorderColor", "disabledActiveContainerColor", "disabledActiveContentColor", "disabledActiveBorderColor", "disabledInactiveContainerColor", "disabledInactiveContentColor", "disabledInactiveBorderColor", "<init>", "(JJJJJJJJJJJJLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getActiveContainerColor-0d7_KjU", "()J", "J", "getActiveContentColor-0d7_KjU", "getActiveBorderColor-0d7_KjU", "getInactiveContainerColor-0d7_KjU", "getInactiveContentColor-0d7_KjU", "getInactiveBorderColor-0d7_KjU", "getDisabledActiveContainerColor-0d7_KjU", "getDisabledActiveContentColor-0d7_KjU", "getDisabledActiveBorderColor-0d7_KjU", "getDisabledInactiveContainerColor-0d7_KjU", "getDisabledInactiveContentColor-0d7_KjU", "getDisabledInactiveBorderColor-0d7_KjU", "copy", "copy-2qZNXz8", "(JJJJJJJJJJJJ)Landroidx/compose/material3/SegmentedButtonColors;", "borderColor", "enabled", "", "active", "borderColor-WaAFU9c$material3", "(ZZ)J", "contentColor", "checked", "contentColor-WaAFU9c$material3", "containerColor", "containerColor-WaAFU9c$material3", "equals", "other", "hashCode", "", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class SegmentedButtonColors {
    public static final int $stable = 0;
    private final long activeBorderColor;
    private final long activeContainerColor;
    private final long activeContentColor;
    private final long disabledActiveBorderColor;
    private final long disabledActiveContainerColor;
    private final long disabledActiveContentColor;
    private final long disabledInactiveBorderColor;
    private final long disabledInactiveContainerColor;
    private final long disabledInactiveContentColor;
    private final long inactiveBorderColor;
    private final long inactiveContainerColor;
    private final long inactiveContentColor;

    public /* synthetic */ SegmentedButtonColors(long r100, long r101, long r102, long r103, long r104, long r110, long r111, long r112, long r113, long r114, long r210, long r211, DefaultConstructorMarker r212) {
        this(r100, r101, r102, r103, r104, r110, r111, r112, r113, r114, r210, r211);
    }

    public int hashCode() {
        return (((((((((((((((((((((Color.m4834hashCodeimpl(this.activeBorderColor) * 31) + Color.m4834hashCodeimpl(this.activeContentColor)) * 31) + Color.m4834hashCodeimpl(this.activeContainerColor)) * 31) + Color.m4834hashCodeimpl(this.inactiveBorderColor)) * 31) + Color.m4834hashCodeimpl(this.inactiveContentColor)) * 31) + Color.m4834hashCodeimpl(this.inactiveContainerColor)) * 31) + Color.m4834hashCodeimpl(this.disabledActiveBorderColor)) * 31) + Color.m4834hashCodeimpl(this.disabledActiveContentColor)) * 31) + Color.m4834hashCodeimpl(this.disabledActiveContainerColor)) * 31) + Color.m4834hashCodeimpl(this.disabledInactiveBorderColor)) * 31) + Color.m4834hashCodeimpl(this.disabledInactiveContentColor)) * 31) + Color.m4834hashCodeimpl(this.disabledInactiveContainerColor);
    }

    /* JADX INFO: renamed from: getActiveBorderColor-0d7_KjU, reason: not valid java name */
    public final long m2584getActiveBorderColor0d7_KjU() {
        return this.activeBorderColor;
    }

    /* JADX INFO: renamed from: getActiveContainerColor-0d7_KjU, reason: not valid java name */
    public final long m2585getActiveContainerColor0d7_KjU() {
        return this.activeContainerColor;
    }

    /* JADX INFO: renamed from: getActiveContentColor-0d7_KjU, reason: not valid java name */
    public final long m2586getActiveContentColor0d7_KjU() {
        return this.activeContentColor;
    }

    /* JADX INFO: renamed from: getDisabledActiveBorderColor-0d7_KjU, reason: not valid java name */
    public final long m2587getDisabledActiveBorderColor0d7_KjU() {
        return this.disabledActiveBorderColor;
    }

    /* JADX INFO: renamed from: getDisabledActiveContainerColor-0d7_KjU, reason: not valid java name */
    public final long m2588getDisabledActiveContainerColor0d7_KjU() {
        return this.disabledActiveContainerColor;
    }

    /* JADX INFO: renamed from: getDisabledActiveContentColor-0d7_KjU, reason: not valid java name */
    public final long m2589getDisabledActiveContentColor0d7_KjU() {
        return this.disabledActiveContentColor;
    }

    /* JADX INFO: renamed from: getDisabledInactiveBorderColor-0d7_KjU, reason: not valid java name */
    public final long m2590getDisabledInactiveBorderColor0d7_KjU() {
        return this.disabledInactiveBorderColor;
    }

    /* JADX INFO: renamed from: getDisabledInactiveContainerColor-0d7_KjU, reason: not valid java name */
    public final long m2591getDisabledInactiveContainerColor0d7_KjU() {
        return this.disabledInactiveContainerColor;
    }

    /* JADX INFO: renamed from: getDisabledInactiveContentColor-0d7_KjU, reason: not valid java name */
    public final long m2592getDisabledInactiveContentColor0d7_KjU() {
        return this.disabledInactiveContentColor;
    }

    /* JADX INFO: renamed from: getInactiveBorderColor-0d7_KjU, reason: not valid java name */
    public final long m2593getInactiveBorderColor0d7_KjU() {
        return this.inactiveBorderColor;
    }

    /* JADX INFO: renamed from: getInactiveContainerColor-0d7_KjU, reason: not valid java name */
    public final long m2594getInactiveContainerColor0d7_KjU() {
        return this.inactiveContainerColor;
    }

    /* JADX INFO: renamed from: getInactiveContentColor-0d7_KjU, reason: not valid java name */
    public final long m2595getInactiveContentColor0d7_KjU() {
        return this.inactiveContentColor;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if (r100 != null) goto L9;
        return false;
    L9:
        if (SegmentedButtonColors.class == r100.getClass()) goto L11;
        return false;
    L11:
        SegmentedButtonColors r101 = (SegmentedButtonColors) r100;
        if (Color.m4828equalsimpl0(this.activeBorderColor, r101.activeBorderColor) == true) goto L15;
        return false;
    L15:
        if (Color.m4828equalsimpl0(this.activeContentColor, r101.activeContentColor) == true) goto L18;
        return false;
    L18:
        if (Color.m4828equalsimpl0(this.activeContainerColor, r101.activeContainerColor) == true) goto L21;
        return false;
    L21:
        if (Color.m4828equalsimpl0(this.inactiveBorderColor, r101.inactiveBorderColor) == true) goto L24;
        return false;
    L24:
        if (Color.m4828equalsimpl0(this.inactiveContentColor, r101.inactiveContentColor) == true) goto L27;
        return false;
    L27:
        if (Color.m4828equalsimpl0(this.inactiveContainerColor, r101.inactiveContainerColor) == true) goto L30;
        return false;
    L30:
        if (Color.m4828equalsimpl0(this.disabledActiveBorderColor, r101.disabledActiveBorderColor) == true) goto L33;
        return false;
    L33:
        if (Color.m4828equalsimpl0(this.disabledActiveContentColor, r101.disabledActiveContentColor) == true) goto L36;
        return false;
    L36:
        if (Color.m4828equalsimpl0(this.disabledActiveContainerColor, r101.disabledActiveContainerColor) == true) goto L39;
        return false;
    L39:
        if (Color.m4828equalsimpl0(this.disabledInactiveBorderColor, r101.disabledInactiveBorderColor) == true) goto L42;
        return false;
    L42:
        if (Color.m4828equalsimpl0(this.disabledInactiveContentColor, r101.disabledInactiveContentColor) == true) goto L45;
        return false;
    L45:
        if (Color.m4828equalsimpl0(this.disabledInactiveContainerColor, r101.disabledInactiveContainerColor) == true) goto L47;
        return false;
    L47:
        return true;
    }

    /* JADX INFO: renamed from: borderColor-WaAFU9c$material3, reason: not valid java name */
    public final long m2580borderColorWaAFU9c$material3(boolean r100, boolean r101) {
        if (r100 == false) goto L5;
        if (r101 == false) goto L5;
        return this.activeBorderColor;
    L5:
        if (r100 == false) goto L8;
        if (r101 == true) goto L8;
        return this.inactiveBorderColor;
    L8:
        if (r100 == true) goto L12;
        if (r101 == false) goto L12;
        return this.disabledActiveBorderColor;
    L12:
        return this.disabledInactiveBorderColor;
    }

    /* JADX INFO: renamed from: containerColor-WaAFU9c$material3, reason: not valid java name */
    public final long m2581containerColorWaAFU9c$material3(boolean r100, boolean r101) {
        if (r100 == false) goto L5;
        if (r101 == false) goto L5;
        return this.activeContainerColor;
    L5:
        if (r100 == false) goto L8;
        if (r101 == true) goto L8;
        return this.inactiveContainerColor;
    L8:
        if (r100 == true) goto L12;
        if (r101 == false) goto L12;
        return this.disabledActiveContainerColor;
    L12:
        return this.disabledInactiveContainerColor;
    }

    /* JADX INFO: renamed from: contentColor-WaAFU9c$material3, reason: not valid java name */
    public final long m2582contentColorWaAFU9c$material3(boolean r100, boolean r101) {
        if (r100 == false) goto L5;
        if (r101 == false) goto L5;
        return this.activeContentColor;
    L5:
        if (r100 == false) goto L8;
        if (r101 == true) goto L8;
        return this.inactiveContentColor;
    L8:
        if (r100 == true) goto L12;
        if (r101 == false) goto L12;
        return this.disabledActiveContentColor;
    L12:
        return this.disabledInactiveContentColor;
    }

    private SegmentedButtonColors(long r100, long r101, long r102, long r110, long r111, long r112, long r113, long r114, long r210, long r211, long r212, long r213) {
        this.activeContainerColor = r100;
        this.activeContentColor = r101;
        this.activeBorderColor = r102;
        this.inactiveContainerColor = r110;
        this.inactiveContentColor = r111;
        this.inactiveBorderColor = r112;
        this.disabledActiveContainerColor = r113;
        this.disabledActiveContentColor = r114;
        this.disabledActiveBorderColor = r210;
        this.disabledInactiveContainerColor = r211;
        this.disabledInactiveContentColor = r212;
        this.disabledInactiveBorderColor = r213;
    }

    /* JADX INFO: renamed from: copy-2qZNXz8, reason: not valid java name */
    public final SegmentedButtonColors m2583copy2qZNXz8(long r310, long r311, long r312, long r410, long r411, long r412, long r413, long r414, long r510, long r511, long r512, long r513) {
        boolean r100 = true;
        if (r310 == 16) goto L5;
        boolean r101 = true;
    L6:
        if (r101 == false) goto L8;
        long r102 = r310;
    L10:
        if (r311 == 16) goto L12;
        boolean r103 = true;
    L13:
        if (r103 == false) goto L15;
        long r110 = r311;
    L17:
        if (r312 == 16) goto L19;
        boolean r104 = true;
    L20:
        if (r104 == false) goto L22;
        long r111 = r312;
    L24:
        if (r410 == 16) goto L26;
        boolean r105 = true;
    L27:
        if (r105 == false) goto L29;
        long r112 = r410;
    L31:
        if (r411 == 16) goto L33;
        boolean r106 = true;
    L34:
        if (r106 == false) goto L36;
        long r113 = r411;
    L38:
        if (r412 == 16) goto L40;
        boolean r107 = true;
    L41:
        if (r107 == false) goto L43;
        long r114 = r412;
    L45:
        if (r413 == 16) goto L47;
        boolean r108 = true;
    L48:
        if (r108 == false) goto L50;
        long r210 = r413;
    L52:
        if (r414 == 16) goto L54;
        boolean r109 = true;
    L55:
        if (r109 == false) goto L57;
        long r211 = r414;
    L59:
        if (r510 == 16) goto L61;
        boolean r115 = true;
    L62:
        if (r115 == false) goto L64;
        long r212 = r510;
    L66:
        if (r511 == 16) goto L68;
        boolean r116 = true;
    L69:
        if (r116 == false) goto L71;
        long r213 = r511;
    L73:
        if (r512 == 16) goto L75;
        boolean r117 = true;
    L76:
        if (r117 == false) goto L78;
        long r214 = r512;
    L80:
        if (r513 != 16) goto L83;
        r100 = false;
    L83:
        if (r100 == false) goto L85;
        long r313 = r513;
    L87:
        return new SegmentedButtonColors(r102, r110, r111, r112, r113, r114, r210, r211, r212, r213, r214, r313, null);
    L85:
        r313 = this.disabledInactiveBorderColor;
        goto L87
    L78:
        r214 = this.disabledInactiveContentColor;
        goto L80
    L75:
        r117 = false;
        goto L76
    L71:
        r213 = this.disabledInactiveContainerColor;
        goto L73
    L68:
        r116 = false;
        goto L69
    L64:
        r212 = this.disabledActiveBorderColor;
        goto L66
    L61:
        r115 = false;
        goto L62
    L57:
        r211 = this.disabledActiveContentColor;
        goto L59
    L54:
        r109 = false;
        goto L55
    L50:
        r210 = this.disabledActiveContainerColor;
        goto L52
    L47:
        r108 = false;
        goto L48
    L43:
        r114 = this.inactiveBorderColor;
        goto L45
    L40:
        r107 = false;
        goto L41
    L36:
        r113 = this.inactiveContentColor;
        goto L38
    L33:
        r106 = false;
        goto L34
    L29:
        r112 = this.inactiveContainerColor;
        goto L31
    L26:
        r105 = false;
        goto L27
    L22:
        r111 = this.activeBorderColor;
        goto L24
    L19:
        r104 = false;
        goto L20
    L15:
        r110 = this.activeContentColor;
        goto L17
    L12:
        r103 = false;
        goto L13
    L8:
        r102 = this.activeContainerColor;
        goto L10
    L5:
        r101 = false;
        goto L6
    }

    /* JADX INFO: renamed from: copy-2qZNXz8$default, reason: not valid java name */
    public static /* synthetic */ SegmentedButtonColors m2579copy2qZNXz8$default(SegmentedButtonColors r110, long r111, long r112, long r210, long r211, long r212, long r213, long r214, long r310, long r311, long r312, long r313, long r314, int r410, Object r411) {
        if ((r410 & 1) == 0) goto L5;
        long r100 = r110.activeContainerColor;
    L7:
        if ((r410 & 2) == 0) goto L9;
        long r101 = r110.activeContentColor;
    L11:
        if ((r410 & 4) == 0) goto L13;
        long r102 = r110.activeBorderColor;
    L15:
        if ((r410 & 8) == 0) goto L17;
        long r103 = r110.inactiveContainerColor;
    L19:
        if ((r410 & 16) == 0) goto L21;
        long r113 = r110.inactiveContentColor;
    L23:
        if ((r410 & 32) == 0) goto L25;
        long r114 = r110.inactiveBorderColor;
    L27:
        if ((r410 & 64) == 0) goto L29;
        long r115 = r110.disabledActiveContainerColor;
    L30:
        long r215 = r115;
        if ((r410 & 128) == 0) goto L33;
        long r116 = r110.disabledActiveContentColor;
    L34:
        long r315 = r116;
        if ((r410 & 256) == 0) goto L37;
        long r117 = r110.disabledActiveBorderColor;
    L38:
        long r316 = r117;
        if ((r410 & 512) == 0) goto L41;
        long r118 = r110.disabledInactiveContainerColor;
    L42:
        long r317 = r118;
        if ((r410 & 1024) == 0) goto L45;
        long r119 = r110.disabledInactiveContentColor;
    L46:
        long r318 = r119;
        if ((r410 & 2048) == 0) goto L49;
        long r120 = r110.disabledInactiveBorderColor;
    L51:
        return r110.m2583copy2qZNXz8(r100, r101, r102, r103, r113, r114, r215, r315, r316, r317, r318, r120);
    L49:
        r120 = r314;
        goto L51
    L45:
        r119 = r313;
        goto L46
    L41:
        r118 = r312;
        goto L42
    L37:
        r117 = r311;
        goto L38
    L33:
        r116 = r310;
        goto L34
    L29:
        r115 = r214;
        goto L30
    L25:
        r114 = r213;
        goto L27
    L21:
        r113 = r212;
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
