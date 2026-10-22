package androidx.compose.material3;

import androidx.compose.ui.graphics.Color;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\b\n\u0000\b\u0007\u0018\u00002\u00020\u0001Bo\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\u0006\u0010\f\u001a\u00020\u0003\u0012\u0006\u0010\r\u001a\u00020\u0003\u0012\u0006\u0010\u000e\u001a\u00020\u0003\u0012\u0006\u0010\u000f\u001a\u00020\u0003¢\u0006\u0004\b\u0010\u0010\u0011J\u008f\u0001\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u00032\b\b\u0002\u0010\u000f\u001a\u00020\u0003¢\u0006\u0004\b\u0014\u0010\u0015J\u001f\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0017H\u0001¢\u0006\u0004\b\u0019\u0010\u001aJ\u001f\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0017H\u0001¢\u0006\u0004\b\u001b\u0010\u001aJ\u001f\u0010\u001c\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0017H\u0001¢\u0006\u0004\b\u001d\u0010\u001aJ\u001f\u0010\u001e\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0017H\u0001¢\u0006\u0004\b\u001f\u0010\u001aJ\u0013\u0010 \u001a\u00020\u00172\b\u0010!\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\"\u001a\u00020#H\u0016R\u0010\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0012R\u0010\u0010\u0004\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0012R\u0010\u0010\u0005\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0012R\u0010\u0010\u0006\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0012R\u0010\u0010\u0007\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0012R\u0010\u0010\b\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0012R\u0010\u0010\t\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0012R\u0010\u0010\n\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0012R\u0010\u0010\u000b\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0012R\u0010\u0010\f\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0012R\u0010\u0010\r\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0012R\u0010\u0010\u000e\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0012R\u0010\u0010\u000f\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0012¨\u0006$"}, d2 = {"Landroidx/compose/material3/SelectableChipColors;", "", "containerColor", "Landroidx/compose/ui/graphics/Color;", "labelColor", "leadingIconColor", "trailingIconColor", "disabledContainerColor", "disabledLabelColor", "disabledLeadingIconColor", "disabledTrailingIconColor", "selectedContainerColor", "disabledSelectedContainerColor", "selectedLabelColor", "selectedLeadingIconColor", "selectedTrailingIconColor", "<init>", "(JJJJJJJJJJJJJLkotlin/jvm/internal/DefaultConstructorMarker;)V", "J", "copy", "copy-daRQuJA", "(JJJJJJJJJJJJJ)Landroidx/compose/material3/SelectableChipColors;", "enabled", "", "selected", "containerColor-WaAFU9c$material3", "(ZZ)J", "labelColor-WaAFU9c$material3", "leadingIconContentColor", "leadingIconContentColor-WaAFU9c$material3", "trailingIconContentColor", "trailingIconContentColor-WaAFU9c$material3", "equals", "other", "hashCode", "", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class SelectableChipColors {
    public static final int $stable = 0;
    private final long containerColor;
    private final long disabledContainerColor;
    private final long disabledLabelColor;
    private final long disabledLeadingIconColor;
    private final long disabledSelectedContainerColor;
    private final long disabledTrailingIconColor;
    private final long labelColor;
    private final long leadingIconColor;
    private final long selectedContainerColor;
    private final long selectedLabelColor;
    private final long selectedLeadingIconColor;
    private final long selectedTrailingIconColor;
    private final long trailingIconColor;

    public /* synthetic */ SelectableChipColors(long r100, long r101, long r102, long r103, long r104, long r110, long r111, long r112, long r113, long r114, long r210, long r211, long r212, DefaultConstructorMarker r213) {
        this(r100, r101, r102, r103, r104, r110, r111, r112, r113, r114, r210, r211, r212);
    }

    public int hashCode() {
        return (((((((((((((((((((((((Color.m4834hashCodeimpl(this.containerColor) * 31) + Color.m4834hashCodeimpl(this.labelColor)) * 31) + Color.m4834hashCodeimpl(this.leadingIconColor)) * 31) + Color.m4834hashCodeimpl(this.trailingIconColor)) * 31) + Color.m4834hashCodeimpl(this.disabledContainerColor)) * 31) + Color.m4834hashCodeimpl(this.disabledLabelColor)) * 31) + Color.m4834hashCodeimpl(this.disabledLeadingIconColor)) * 31) + Color.m4834hashCodeimpl(this.disabledTrailingIconColor)) * 31) + Color.m4834hashCodeimpl(this.selectedContainerColor)) * 31) + Color.m4834hashCodeimpl(this.disabledSelectedContainerColor)) * 31) + Color.m4834hashCodeimpl(this.selectedLabelColor)) * 31) + Color.m4834hashCodeimpl(this.selectedLeadingIconColor)) * 31) + Color.m4834hashCodeimpl(this.selectedTrailingIconColor);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if (r100 != null) goto L8;
    L50:
        return false;
    L8:
        if ((r100 instanceof SelectableChipColors) == false) goto L50;
        SelectableChipColors r101 = (SelectableChipColors) r100;
        if (Color.m4828equalsimpl0(this.containerColor, r101.containerColor) == true) goto L14;
        return false;
    L14:
        if (Color.m4828equalsimpl0(this.labelColor, r101.labelColor) == true) goto L17;
        return false;
    L17:
        if (Color.m4828equalsimpl0(this.leadingIconColor, r101.leadingIconColor) == true) goto L20;
        return false;
    L20:
        if (Color.m4828equalsimpl0(this.trailingIconColor, r101.trailingIconColor) == true) goto L23;
        return false;
    L23:
        if (Color.m4828equalsimpl0(this.disabledContainerColor, r101.disabledContainerColor) == true) goto L26;
        return false;
    L26:
        if (Color.m4828equalsimpl0(this.disabledLabelColor, r101.disabledLabelColor) == true) goto L29;
        return false;
    L29:
        if (Color.m4828equalsimpl0(this.disabledLeadingIconColor, r101.disabledLeadingIconColor) == true) goto L32;
        return false;
    L32:
        if (Color.m4828equalsimpl0(this.disabledTrailingIconColor, r101.disabledTrailingIconColor) == true) goto L35;
        return false;
    L35:
        if (Color.m4828equalsimpl0(this.selectedContainerColor, r101.selectedContainerColor) == true) goto L38;
        return false;
    L38:
        if (Color.m4828equalsimpl0(this.disabledSelectedContainerColor, r101.disabledSelectedContainerColor) == true) goto L41;
        return false;
    L41:
        if (Color.m4828equalsimpl0(this.selectedLabelColor, r101.selectedLabelColor) == true) goto L44;
        return false;
    L44:
        if (Color.m4828equalsimpl0(this.selectedLeadingIconColor, r101.selectedLeadingIconColor) == true) goto L47;
        return false;
    L47:
        if (Color.m4828equalsimpl0(this.selectedTrailingIconColor, r101.selectedTrailingIconColor) == true) goto L49;
        return false;
    L49:
        return true;
    }

    /* JADX INFO: renamed from: containerColor-WaAFU9c$material3, reason: not valid java name */
    public final long m2604containerColorWaAFU9c$material3(boolean r100, boolean r101) {
        if (r100 == true) goto L6;
        if (r101 == false) goto L11;
        return this.disabledSelectedContainerColor;
    L11:
        return this.disabledContainerColor;
    L6:
        if (r101 == true) goto L9;
        return this.containerColor;
    L9:
        return this.selectedContainerColor;
    }

    /* JADX INFO: renamed from: labelColor-WaAFU9c$material3, reason: not valid java name */
    public final long m2606labelColorWaAFU9c$material3(boolean r100, boolean r101) {
        if (r100 == false) goto L8;
        if (r101 == true) goto L7;
        return this.labelColor;
    L7:
        return this.selectedLabelColor;
    L8:
        return this.disabledLabelColor;
    }

    /* JADX INFO: renamed from: leadingIconContentColor-WaAFU9c$material3, reason: not valid java name */
    public final long m2607leadingIconContentColorWaAFU9c$material3(boolean r100, boolean r101) {
        if (r100 == false) goto L8;
        if (r101 == true) goto L7;
        return this.leadingIconColor;
    L7:
        return this.selectedLeadingIconColor;
    L8:
        return this.disabledLeadingIconColor;
    }

    /* JADX INFO: renamed from: trailingIconContentColor-WaAFU9c$material3, reason: not valid java name */
    public final long m2608trailingIconContentColorWaAFU9c$material3(boolean r100, boolean r101) {
        if (r100 == false) goto L8;
        if (r101 == true) goto L7;
        return this.trailingIconColor;
    L7:
        return this.selectedTrailingIconColor;
    L8:
        return this.disabledTrailingIconColor;
    }

    private SelectableChipColors(long r100, long r101, long r102, long r110, long r111, long r112, long r113, long r114, long r210, long r211, long r212, long r213, long r214) {
        this.containerColor = r100;
        this.labelColor = r101;
        this.leadingIconColor = r102;
        this.trailingIconColor = r110;
        this.disabledContainerColor = r111;
        this.disabledLabelColor = r112;
        this.disabledLeadingIconColor = r113;
        this.disabledTrailingIconColor = r114;
        this.selectedContainerColor = r210;
        this.disabledSelectedContainerColor = r211;
        this.selectedLabelColor = r212;
        this.selectedLeadingIconColor = r213;
        this.selectedTrailingIconColor = r214;
    }

    /* JADX INFO: renamed from: copy-daRQuJA, reason: not valid java name */
    public final SelectableChipColors m2605copydaRQuJA(long r310, long r311, long r410, long r411, long r412, long r413, long r414, long r510, long r511, long r512, long r513, long r514, long r610) {
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
        if (r410 == 16) goto L19;
        boolean r104 = true;
    L20:
        if (r104 == false) goto L22;
        long r111 = r410;
    L24:
        if (r411 == 16) goto L26;
        boolean r105 = true;
    L27:
        if (r105 == false) goto L29;
        long r112 = r411;
    L31:
        if (r412 == 16) goto L33;
        boolean r106 = true;
    L34:
        if (r106 == false) goto L36;
        long r113 = r412;
    L38:
        if (r413 == 16) goto L40;
        boolean r107 = true;
    L41:
        if (r107 == false) goto L43;
        long r114 = r413;
    L45:
        if (r414 == 16) goto L47;
        boolean r108 = true;
    L48:
        if (r108 == false) goto L50;
        long r210 = r414;
    L52:
        if (r510 == 16) goto L54;
        boolean r109 = true;
    L55:
        if (r109 == false) goto L57;
        long r211 = r510;
    L59:
        if (r511 == 16) goto L61;
        boolean r115 = true;
    L62:
        if (r115 == false) goto L64;
        long r212 = r511;
    L66:
        if (r512 == 16) goto L68;
        boolean r116 = true;
    L69:
        if (r116 == false) goto L71;
        long r213 = r512;
    L73:
        if (r513 == 16) goto L75;
        boolean r117 = true;
    L76:
        if (r117 == false) goto L78;
        long r214 = r513;
    L80:
        if (r514 == 16) goto L82;
        boolean r118 = true;
    L83:
        if (r118 == false) goto L85;
        long r312 = r514;
    L87:
        if (r610 != 16) goto L90;
        r100 = false;
    L90:
        if (r100 == false) goto L92;
        long r313 = r610;
    L94:
        return new SelectableChipColors(r102, r110, r111, r112, r113, r114, r210, r211, r212, r213, r214, r312, r313, null);
    L92:
        r313 = this.selectedTrailingIconColor;
        goto L94
    L85:
        r312 = this.selectedLeadingIconColor;
        goto L87
    L82:
        r118 = false;
        goto L83
    L78:
        r214 = this.selectedLabelColor;
        goto L80
    L75:
        r117 = false;
        goto L76
    L71:
        r213 = this.disabledSelectedContainerColor;
        goto L73
    L68:
        r116 = false;
        goto L69
    L64:
        r212 = this.selectedContainerColor;
        goto L66
    L61:
        r115 = false;
        goto L62
    L57:
        r211 = this.disabledTrailingIconColor;
        goto L59
    L54:
        r109 = false;
        goto L55
    L50:
        r210 = this.disabledLeadingIconColor;
        goto L52
    L47:
        r108 = false;
        goto L48
    L43:
        r114 = this.disabledLabelColor;
        goto L45
    L40:
        r107 = false;
        goto L41
    L36:
        r113 = this.disabledContainerColor;
        goto L38
    L33:
        r106 = false;
        goto L34
    L29:
        r112 = this.trailingIconColor;
        goto L31
    L26:
        r105 = false;
        goto L27
    L22:
        r111 = this.leadingIconColor;
        goto L24
    L19:
        r104 = false;
        goto L20
    L15:
        r110 = this.labelColor;
        goto L17
    L12:
        r103 = false;
        goto L13
    L8:
        r102 = this.containerColor;
        goto L10
    L5:
        r101 = false;
        goto L6
    }

    /* JADX INFO: renamed from: copy-daRQuJA$default, reason: not valid java name */
    public static /* synthetic */ SelectableChipColors m2603copydaRQuJA$default(SelectableChipColors r110, long r111, long r112, long r210, long r211, long r212, long r213, long r214, long r310, long r311, long r312, long r313, long r314, long r410, int r411, Object r412) {
        if ((r411 & 1) == 0) goto L5;
        long r100 = r110.containerColor;
    L7:
        if ((r411 & 2) == 0) goto L9;
        long r101 = r110.labelColor;
    L11:
        if ((r411 & 4) == 0) goto L13;
        long r102 = r110.leadingIconColor;
    L15:
        if ((r411 & 8) == 0) goto L17;
        long r103 = r110.trailingIconColor;
    L19:
        if ((r411 & 16) == 0) goto L21;
        long r113 = r110.disabledContainerColor;
    L23:
        if ((r411 & 32) == 0) goto L25;
        long r114 = r110.disabledLabelColor;
    L27:
        if ((r411 & 64) == 0) goto L29;
        long r115 = r110.disabledLeadingIconColor;
    L30:
        long r215 = r115;
        if ((r411 & 128) == 0) goto L33;
        long r116 = r110.disabledTrailingIconColor;
    L34:
        long r315 = r116;
        if ((r411 & 256) == 0) goto L37;
        long r117 = r110.selectedContainerColor;
    L38:
        long r316 = r117;
        if ((r411 & 512) == 0) goto L41;
        long r118 = r110.disabledSelectedContainerColor;
    L42:
        long r317 = r118;
        if ((r411 & 1024) == 0) goto L45;
        long r119 = r110.selectedLabelColor;
    L46:
        long r318 = r119;
        if ((r411 & 2048) == 0) goto L49;
        long r120 = r110.selectedLeadingIconColor;
    L50:
        long r319 = r120;
        if ((r411 & 4096) == 0) goto L53;
        long r121 = r110.selectedTrailingIconColor;
    L55:
        return r110.m2605copydaRQuJA(r100, r101, r102, r103, r113, r114, r215, r315, r316, r317, r318, r319, r121);
    L53:
        r121 = r410;
        goto L55
    L49:
        r120 = r314;
        goto L50
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
