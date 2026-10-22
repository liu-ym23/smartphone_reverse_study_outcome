package androidx.compose.material3;

import androidx.compose.ui.graphics.Color;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001b\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\b\n\u0000\b\u0007\u0018\u00002\u00020\u0001BW\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\u0006\u0010\f\u001a\u00020\u0003¢\u0006\u0004\b\r\u0010\u000eJq\u0010\u001b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u0003¢\u0006\u0004\b\u001c\u0010\u001dJ\u0017\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u001e\u001a\u00020\u001fH\u0001¢\u0006\u0004\b \u0010!J\u001f\u0010\"\u001a\u00020\u00032\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010#\u001a\u00020\u001fH\u0001¢\u0006\u0004\b$\u0010%J\u001f\u0010&\u001a\u00020\u00032\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010#\u001a\u00020\u001fH\u0001¢\u0006\u0004\b'\u0010%J\u0013\u0010(\u001a\u00020\u001f2\b\u0010)\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010*\u001a\u00020+H\u0016R\u0013\u0010\u0002\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\u0004\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u0012\u0010\u0010R\u0013\u0010\u0005\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u0013\u0010\u0010R\u0013\u0010\u0006\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u0014\u0010\u0010R\u0013\u0010\u0007\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u0015\u0010\u0010R\u0013\u0010\b\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u0016\u0010\u0010R\u0013\u0010\t\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u0017\u0010\u0010R\u0013\u0010\n\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u0018\u0010\u0010R\u0013\u0010\u000b\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u0019\u0010\u0010R\u0013\u0010\f\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u001a\u0010\u0010¨\u0006,"}, d2 = {"Landroidx/compose/material3/SliderColors;", "", "thumbColor", "Landroidx/compose/ui/graphics/Color;", "activeTrackColor", "activeTickColor", "inactiveTrackColor", "inactiveTickColor", "disabledThumbColor", "disabledActiveTrackColor", "disabledActiveTickColor", "disabledInactiveTrackColor", "disabledInactiveTickColor", "<init>", "(JJJJJJJJJJLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getThumbColor-0d7_KjU", "()J", "J", "getActiveTrackColor-0d7_KjU", "getActiveTickColor-0d7_KjU", "getInactiveTrackColor-0d7_KjU", "getInactiveTickColor-0d7_KjU", "getDisabledThumbColor-0d7_KjU", "getDisabledActiveTrackColor-0d7_KjU", "getDisabledActiveTickColor-0d7_KjU", "getDisabledInactiveTrackColor-0d7_KjU", "getDisabledInactiveTickColor-0d7_KjU", "copy", "copy--K518z4", "(JJJJJJJJJJ)Landroidx/compose/material3/SliderColors;", "enabled", "", "thumbColor-vNxB06k$material3", "(Z)J", "trackColor", "active", "trackColor-WaAFU9c$material3", "(ZZ)J", "tickColor", "tickColor-WaAFU9c$material3", "equals", "other", "hashCode", "", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class SliderColors {
    public static final int $stable = 0;
    private final long activeTickColor;
    private final long activeTrackColor;
    private final long disabledActiveTickColor;
    private final long disabledActiveTrackColor;
    private final long disabledInactiveTickColor;
    private final long disabledInactiveTrackColor;
    private final long disabledThumbColor;
    private final long inactiveTickColor;
    private final long inactiveTrackColor;
    private final long thumbColor;

    public /* synthetic */ SliderColors(long r100, long r101, long r102, long r103, long r104, long r110, long r111, long r112, long r113, long r114, DefaultConstructorMarker r210) {
        this(r100, r101, r102, r103, r104, r110, r111, r112, r113, r114);
    }

    public int hashCode() {
        return (((((((((((((((((Color.m4834hashCodeimpl(this.thumbColor) * 31) + Color.m4834hashCodeimpl(this.activeTrackColor)) * 31) + Color.m4834hashCodeimpl(this.activeTickColor)) * 31) + Color.m4834hashCodeimpl(this.inactiveTrackColor)) * 31) + Color.m4834hashCodeimpl(this.inactiveTickColor)) * 31) + Color.m4834hashCodeimpl(this.disabledThumbColor)) * 31) + Color.m4834hashCodeimpl(this.disabledActiveTrackColor)) * 31) + Color.m4834hashCodeimpl(this.disabledActiveTickColor)) * 31) + Color.m4834hashCodeimpl(this.disabledInactiveTrackColor)) * 31) + Color.m4834hashCodeimpl(this.disabledInactiveTickColor);
    }

    /* JADX INFO: renamed from: getActiveTickColor-0d7_KjU, reason: not valid java name */
    public final long m2637getActiveTickColor0d7_KjU() {
        return this.activeTickColor;
    }

    /* JADX INFO: renamed from: getActiveTrackColor-0d7_KjU, reason: not valid java name */
    public final long m2638getActiveTrackColor0d7_KjU() {
        return this.activeTrackColor;
    }

    /* JADX INFO: renamed from: getDisabledActiveTickColor-0d7_KjU, reason: not valid java name */
    public final long m2639getDisabledActiveTickColor0d7_KjU() {
        return this.disabledActiveTickColor;
    }

    /* JADX INFO: renamed from: getDisabledActiveTrackColor-0d7_KjU, reason: not valid java name */
    public final long m2640getDisabledActiveTrackColor0d7_KjU() {
        return this.disabledActiveTrackColor;
    }

    /* JADX INFO: renamed from: getDisabledInactiveTickColor-0d7_KjU, reason: not valid java name */
    public final long m2641getDisabledInactiveTickColor0d7_KjU() {
        return this.disabledInactiveTickColor;
    }

    /* JADX INFO: renamed from: getDisabledInactiveTrackColor-0d7_KjU, reason: not valid java name */
    public final long m2642getDisabledInactiveTrackColor0d7_KjU() {
        return this.disabledInactiveTrackColor;
    }

    /* JADX INFO: renamed from: getDisabledThumbColor-0d7_KjU, reason: not valid java name */
    public final long m2643getDisabledThumbColor0d7_KjU() {
        return this.disabledThumbColor;
    }

    /* JADX INFO: renamed from: getInactiveTickColor-0d7_KjU, reason: not valid java name */
    public final long m2644getInactiveTickColor0d7_KjU() {
        return this.inactiveTickColor;
    }

    /* JADX INFO: renamed from: getInactiveTrackColor-0d7_KjU, reason: not valid java name */
    public final long m2645getInactiveTrackColor0d7_KjU() {
        return this.inactiveTrackColor;
    }

    /* JADX INFO: renamed from: getThumbColor-0d7_KjU, reason: not valid java name */
    public final long m2646getThumbColor0d7_KjU() {
        return this.thumbColor;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if (r100 != null) goto L8;
    L41:
        return false;
    L8:
        if ((r100 instanceof SliderColors) == false) goto L41;
        SliderColors r101 = (SliderColors) r100;
        if (Color.m4828equalsimpl0(this.thumbColor, r101.thumbColor) == true) goto L14;
        return false;
    L14:
        if (Color.m4828equalsimpl0(this.activeTrackColor, r101.activeTrackColor) == true) goto L17;
        return false;
    L17:
        if (Color.m4828equalsimpl0(this.activeTickColor, r101.activeTickColor) == true) goto L20;
        return false;
    L20:
        if (Color.m4828equalsimpl0(this.inactiveTrackColor, r101.inactiveTrackColor) == true) goto L23;
        return false;
    L23:
        if (Color.m4828equalsimpl0(this.inactiveTickColor, r101.inactiveTickColor) == true) goto L26;
        return false;
    L26:
        if (Color.m4828equalsimpl0(this.disabledThumbColor, r101.disabledThumbColor) == true) goto L29;
        return false;
    L29:
        if (Color.m4828equalsimpl0(this.disabledActiveTrackColor, r101.disabledActiveTrackColor) == true) goto L32;
        return false;
    L32:
        if (Color.m4828equalsimpl0(this.disabledActiveTickColor, r101.disabledActiveTickColor) == true) goto L35;
        return false;
    L35:
        if (Color.m4828equalsimpl0(this.disabledInactiveTrackColor, r101.disabledInactiveTrackColor) == true) goto L38;
        return false;
    L38:
        if (Color.m4828equalsimpl0(this.disabledInactiveTickColor, r101.disabledInactiveTickColor) == true) goto L40;
        return false;
    L40:
        return true;
    }

    /* JADX INFO: renamed from: thumbColor-vNxB06k$material3, reason: not valid java name */
    public final long m2647thumbColorvNxB06k$material3(boolean r100) {
        if (r100 == false) goto L5;
        return this.thumbColor;
    L5:
        return this.disabledThumbColor;
    }

    /* JADX INFO: renamed from: tickColor-WaAFU9c$material3, reason: not valid java name */
    public final long m2648tickColorWaAFU9c$material3(boolean r100, boolean r101) {
        if (r100 == false) goto L6;
        if (r101 == false) goto L11;
        return this.activeTickColor;
    L11:
        return this.inactiveTickColor;
    L6:
        if (r101 == false) goto L9;
        return this.disabledActiveTickColor;
    L9:
        return this.disabledInactiveTickColor;
    }

    /* JADX INFO: renamed from: trackColor-WaAFU9c$material3, reason: not valid java name */
    public final long m2649trackColorWaAFU9c$material3(boolean r100, boolean r101) {
        if (r100 == false) goto L6;
        if (r101 == false) goto L11;
        return this.activeTrackColor;
    L11:
        return this.inactiveTrackColor;
    L6:
        if (r101 == false) goto L9;
        return this.disabledActiveTrackColor;
    L9:
        return this.disabledInactiveTrackColor;
    }

    private SliderColors(long r100, long r101, long r102, long r110, long r111, long r112, long r113, long r114, long r210, long r211) {
        this.thumbColor = r100;
        this.activeTrackColor = r101;
        this.activeTickColor = r102;
        this.inactiveTrackColor = r110;
        this.inactiveTickColor = r111;
        this.disabledThumbColor = r112;
        this.disabledActiveTrackColor = r113;
        this.disabledActiveTickColor = r114;
        this.disabledInactiveTrackColor = r210;
        this.disabledInactiveTickColor = r211;
    }

    /* JADX INFO: renamed from: copy--K518z4, reason: not valid java name */
    public final SliderColors m2636copyK518z4(long r310, long r311, long r312, long r313, long r314, long r410, long r411, long r412, long r413, long r414) {
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
        if (r313 == 16) goto L26;
        boolean r105 = true;
    L27:
        if (r105 == false) goto L29;
        long r112 = r313;
    L31:
        if (r314 == 16) goto L33;
        boolean r106 = true;
    L34:
        if (r106 == false) goto L36;
        long r113 = r314;
    L38:
        if (r410 == 16) goto L40;
        boolean r107 = true;
    L41:
        if (r107 == false) goto L43;
        long r114 = r410;
    L45:
        if (r411 == 16) goto L47;
        boolean r108 = true;
    L48:
        if (r108 == false) goto L50;
        long r210 = r411;
    L52:
        if (r412 == 16) goto L54;
        boolean r109 = true;
    L55:
        if (r109 == false) goto L57;
        long r211 = r412;
    L59:
        if (r413 == 16) goto L61;
        boolean r115 = true;
    L62:
        if (r115 == false) goto L64;
        long r212 = r413;
    L66:
        if (r414 != 16) goto L69;
        r100 = false;
    L69:
        if (r100 == false) goto L71;
        long r213 = r414;
    L73:
        return new SliderColors(r102, r110, r111, r112, r113, r114, r210, r211, r212, r213, null);
    L71:
        r213 = this.disabledInactiveTickColor;
        goto L73
    L64:
        r212 = this.disabledInactiveTrackColor;
        goto L66
    L61:
        r115 = false;
        goto L62
    L57:
        r211 = this.disabledActiveTickColor;
        goto L59
    L54:
        r109 = false;
        goto L55
    L50:
        r210 = this.disabledActiveTrackColor;
        goto L52
    L47:
        r108 = false;
        goto L48
    L43:
        r114 = this.disabledThumbColor;
        goto L45
    L40:
        r107 = false;
        goto L41
    L36:
        r113 = this.inactiveTickColor;
        goto L38
    L33:
        r106 = false;
        goto L34
    L29:
        r112 = this.inactiveTrackColor;
        goto L31
    L26:
        r105 = false;
        goto L27
    L22:
        r111 = this.activeTickColor;
        goto L24
    L19:
        r104 = false;
        goto L20
    L15:
        r110 = this.activeTrackColor;
        goto L17
    L12:
        r103 = false;
        goto L13
    L8:
        r102 = this.thumbColor;
        goto L10
    L5:
        r101 = false;
        goto L6
    }

    /* JADX INFO: renamed from: copy--K518z4$default, reason: not valid java name */
    public static /* synthetic */ SliderColors m2635copyK518z4$default(SliderColors r110, long r111, long r112, long r210, long r211, long r212, long r213, long r214, long r310, long r311, long r312, int r313, Object r314) {
        if ((r313 & 1) == 0) goto L5;
        long r100 = r110.thumbColor;
    L7:
        if ((r313 & 2) == 0) goto L9;
        long r101 = r110.activeTrackColor;
    L11:
        if ((r313 & 4) == 0) goto L13;
        long r102 = r110.activeTickColor;
    L15:
        if ((r313 & 8) == 0) goto L17;
        long r103 = r110.inactiveTrackColor;
    L19:
        if ((r313 & 16) == 0) goto L21;
        long r113 = r110.inactiveTickColor;
    L23:
        if ((r313 & 32) == 0) goto L25;
        long r114 = r110.disabledThumbColor;
    L27:
        if ((r313 & 64) == 0) goto L29;
        long r115 = r110.disabledActiveTrackColor;
    L30:
        long r215 = r115;
        if ((r313 & 128) == 0) goto L33;
        long r116 = r110.disabledActiveTickColor;
    L34:
        long r315 = r116;
        if ((r313 & 256) == 0) goto L37;
        long r117 = r110.disabledInactiveTrackColor;
    L38:
        long r316 = r117;
        if ((r313 & 512) == 0) goto L41;
        long r118 = r110.disabledInactiveTickColor;
    L43:
        return r110.m2636copyK518z4(r100, r101, r102, r103, r113, r114, r215, r315, r316, r118);
    L41:
        r118 = r312;
        goto L43
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
