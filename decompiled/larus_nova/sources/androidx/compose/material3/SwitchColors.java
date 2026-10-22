package androidx.compose.material3;

import androidx.compose.ui.graphics.Color;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b(\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\b\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0087\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\u0006\u0010\f\u001a\u00020\u0003\u0012\u0006\u0010\r\u001a\u00020\u0003\u0012\u0006\u0010\u000e\u001a\u00020\u0003\u0012\u0006\u0010\u000f\u001a\u00020\u0003\u0012\u0006\u0010\u0010\u001a\u00020\u0003\u0012\u0006\u0010\u0011\u001a\u00020\u0003\u0012\u0006\u0010\u0012\u001a\u00020\u0003¢\u0006\u0004\b\u0013\u0010\u0014J\u00ad\u0001\u0010'\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u00032\b\b\u0002\u0010\u000f\u001a\u00020\u00032\b\b\u0002\u0010\u0010\u001a\u00020\u00032\b\b\u0002\u0010\u0011\u001a\u00020\u00032\b\b\u0002\u0010\u0012\u001a\u00020\u0003¢\u0006\u0004\b(\u0010)J\u001f\u0010*\u001a\u00020\u00032\u0006\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020,H\u0001¢\u0006\u0004\b.\u0010/J\u001f\u00100\u001a\u00020\u00032\u0006\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020,H\u0001¢\u0006\u0004\b1\u0010/J\u001f\u00102\u001a\u00020\u00032\u0006\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020,H\u0001¢\u0006\u0004\b3\u0010/J\u001f\u00104\u001a\u00020\u00032\u0006\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020,H\u0001¢\u0006\u0004\b5\u0010/J\u0013\u00106\u001a\u00020,2\b\u00107\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u00108\u001a\u000209H\u0016R\u0013\u0010\u0002\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b\u0015\u0010\u0016R\u0013\u0010\u0004\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b\u0018\u0010\u0016R\u0013\u0010\u0005\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b\u0019\u0010\u0016R\u0013\u0010\u0006\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b\u001a\u0010\u0016R\u0013\u0010\u0007\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b\u001b\u0010\u0016R\u0013\u0010\b\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b\u001c\u0010\u0016R\u0013\u0010\t\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b\u001d\u0010\u0016R\u0013\u0010\n\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b\u001e\u0010\u0016R\u0013\u0010\u000b\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b\u001f\u0010\u0016R\u0013\u0010\f\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b \u0010\u0016R\u0013\u0010\r\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b!\u0010\u0016R\u0013\u0010\u000e\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b\"\u0010\u0016R\u0013\u0010\u000f\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b#\u0010\u0016R\u0013\u0010\u0010\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b$\u0010\u0016R\u0013\u0010\u0011\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b%\u0010\u0016R\u0013\u0010\u0012\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b&\u0010\u0016¨\u0006:"}, d2 = {"Landroidx/compose/material3/SwitchColors;", "", "checkedThumbColor", "Landroidx/compose/ui/graphics/Color;", "checkedTrackColor", "checkedBorderColor", "checkedIconColor", "uncheckedThumbColor", "uncheckedTrackColor", "uncheckedBorderColor", "uncheckedIconColor", "disabledCheckedThumbColor", "disabledCheckedTrackColor", "disabledCheckedBorderColor", "disabledCheckedIconColor", "disabledUncheckedThumbColor", "disabledUncheckedTrackColor", "disabledUncheckedBorderColor", "disabledUncheckedIconColor", "<init>", "(JJJJJJJJJJJJJJJJLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getCheckedThumbColor-0d7_KjU", "()J", "J", "getCheckedTrackColor-0d7_KjU", "getCheckedBorderColor-0d7_KjU", "getCheckedIconColor-0d7_KjU", "getUncheckedThumbColor-0d7_KjU", "getUncheckedTrackColor-0d7_KjU", "getUncheckedBorderColor-0d7_KjU", "getUncheckedIconColor-0d7_KjU", "getDisabledCheckedThumbColor-0d7_KjU", "getDisabledCheckedTrackColor-0d7_KjU", "getDisabledCheckedBorderColor-0d7_KjU", "getDisabledCheckedIconColor-0d7_KjU", "getDisabledUncheckedThumbColor-0d7_KjU", "getDisabledUncheckedTrackColor-0d7_KjU", "getDisabledUncheckedBorderColor-0d7_KjU", "getDisabledUncheckedIconColor-0d7_KjU", "copy", "copy-Q_H9qLU", "(JJJJJJJJJJJJJJJJ)Landroidx/compose/material3/SwitchColors;", "thumbColor", "enabled", "", "checked", "thumbColor-WaAFU9c$material3", "(ZZ)J", "trackColor", "trackColor-WaAFU9c$material3", "borderColor", "borderColor-WaAFU9c$material3", "iconColor", "iconColor-WaAFU9c$material3", "equals", "other", "hashCode", "", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class SwitchColors {
    public static final int $stable = 0;
    private final long checkedBorderColor;
    private final long checkedIconColor;
    private final long checkedThumbColor;
    private final long checkedTrackColor;
    private final long disabledCheckedBorderColor;
    private final long disabledCheckedIconColor;
    private final long disabledCheckedThumbColor;
    private final long disabledCheckedTrackColor;
    private final long disabledUncheckedBorderColor;
    private final long disabledUncheckedIconColor;
    private final long disabledUncheckedThumbColor;
    private final long disabledUncheckedTrackColor;
    private final long uncheckedBorderColor;
    private final long uncheckedIconColor;
    private final long uncheckedThumbColor;
    private final long uncheckedTrackColor;

    public /* synthetic */ SwitchColors(long r100, long r101, long r102, long r103, long r104, long r110, long r111, long r112, long r113, long r114, long r210, long r211, long r212, long r213, long r214, long r310, DefaultConstructorMarker r311) {
        this(r100, r101, r102, r103, r104, r110, r111, r112, r113, r114, r210, r211, r212, r213, r214, r310);
    }

    public int hashCode() {
        return (((((((((((((((((((((((((((((Color.m4834hashCodeimpl(this.checkedThumbColor) * 31) + Color.m4834hashCodeimpl(this.checkedTrackColor)) * 31) + Color.m4834hashCodeimpl(this.checkedBorderColor)) * 31) + Color.m4834hashCodeimpl(this.checkedIconColor)) * 31) + Color.m4834hashCodeimpl(this.uncheckedThumbColor)) * 31) + Color.m4834hashCodeimpl(this.uncheckedTrackColor)) * 31) + Color.m4834hashCodeimpl(this.uncheckedBorderColor)) * 31) + Color.m4834hashCodeimpl(this.uncheckedIconColor)) * 31) + Color.m4834hashCodeimpl(this.disabledCheckedThumbColor)) * 31) + Color.m4834hashCodeimpl(this.disabledCheckedTrackColor)) * 31) + Color.m4834hashCodeimpl(this.disabledCheckedBorderColor)) * 31) + Color.m4834hashCodeimpl(this.disabledCheckedIconColor)) * 31) + Color.m4834hashCodeimpl(this.disabledUncheckedThumbColor)) * 31) + Color.m4834hashCodeimpl(this.disabledUncheckedTrackColor)) * 31) + Color.m4834hashCodeimpl(this.disabledUncheckedBorderColor)) * 31) + Color.m4834hashCodeimpl(this.disabledUncheckedIconColor);
    }

    /* JADX INFO: renamed from: getCheckedBorderColor-0d7_KjU, reason: not valid java name */
    public final long m2719getCheckedBorderColor0d7_KjU() {
        return this.checkedBorderColor;
    }

    /* JADX INFO: renamed from: getCheckedIconColor-0d7_KjU, reason: not valid java name */
    public final long m2720getCheckedIconColor0d7_KjU() {
        return this.checkedIconColor;
    }

    /* JADX INFO: renamed from: getCheckedThumbColor-0d7_KjU, reason: not valid java name */
    public final long m2721getCheckedThumbColor0d7_KjU() {
        return this.checkedThumbColor;
    }

    /* JADX INFO: renamed from: getCheckedTrackColor-0d7_KjU, reason: not valid java name */
    public final long m2722getCheckedTrackColor0d7_KjU() {
        return this.checkedTrackColor;
    }

    /* JADX INFO: renamed from: getDisabledCheckedBorderColor-0d7_KjU, reason: not valid java name */
    public final long m2723getDisabledCheckedBorderColor0d7_KjU() {
        return this.disabledCheckedBorderColor;
    }

    /* JADX INFO: renamed from: getDisabledCheckedIconColor-0d7_KjU, reason: not valid java name */
    public final long m2724getDisabledCheckedIconColor0d7_KjU() {
        return this.disabledCheckedIconColor;
    }

    /* JADX INFO: renamed from: getDisabledCheckedThumbColor-0d7_KjU, reason: not valid java name */
    public final long m2725getDisabledCheckedThumbColor0d7_KjU() {
        return this.disabledCheckedThumbColor;
    }

    /* JADX INFO: renamed from: getDisabledCheckedTrackColor-0d7_KjU, reason: not valid java name */
    public final long m2726getDisabledCheckedTrackColor0d7_KjU() {
        return this.disabledCheckedTrackColor;
    }

    /* JADX INFO: renamed from: getDisabledUncheckedBorderColor-0d7_KjU, reason: not valid java name */
    public final long m2727getDisabledUncheckedBorderColor0d7_KjU() {
        return this.disabledUncheckedBorderColor;
    }

    /* JADX INFO: renamed from: getDisabledUncheckedIconColor-0d7_KjU, reason: not valid java name */
    public final long m2728getDisabledUncheckedIconColor0d7_KjU() {
        return this.disabledUncheckedIconColor;
    }

    /* JADX INFO: renamed from: getDisabledUncheckedThumbColor-0d7_KjU, reason: not valid java name */
    public final long m2729getDisabledUncheckedThumbColor0d7_KjU() {
        return this.disabledUncheckedThumbColor;
    }

    /* JADX INFO: renamed from: getDisabledUncheckedTrackColor-0d7_KjU, reason: not valid java name */
    public final long m2730getDisabledUncheckedTrackColor0d7_KjU() {
        return this.disabledUncheckedTrackColor;
    }

    /* JADX INFO: renamed from: getUncheckedBorderColor-0d7_KjU, reason: not valid java name */
    public final long m2731getUncheckedBorderColor0d7_KjU() {
        return this.uncheckedBorderColor;
    }

    /* JADX INFO: renamed from: getUncheckedIconColor-0d7_KjU, reason: not valid java name */
    public final long m2732getUncheckedIconColor0d7_KjU() {
        return this.uncheckedIconColor;
    }

    /* JADX INFO: renamed from: getUncheckedThumbColor-0d7_KjU, reason: not valid java name */
    public final long m2733getUncheckedThumbColor0d7_KjU() {
        return this.uncheckedThumbColor;
    }

    /* JADX INFO: renamed from: getUncheckedTrackColor-0d7_KjU, reason: not valid java name */
    public final long m2734getUncheckedTrackColor0d7_KjU() {
        return this.uncheckedTrackColor;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if (r100 != null) goto L8;
    L59:
        return false;
    L8:
        if ((r100 instanceof SwitchColors) == false) goto L59;
        SwitchColors r101 = (SwitchColors) r100;
        if (Color.m4828equalsimpl0(this.checkedThumbColor, r101.checkedThumbColor) == true) goto L14;
        return false;
    L14:
        if (Color.m4828equalsimpl0(this.checkedTrackColor, r101.checkedTrackColor) == true) goto L17;
        return false;
    L17:
        if (Color.m4828equalsimpl0(this.checkedBorderColor, r101.checkedBorderColor) == true) goto L20;
        return false;
    L20:
        if (Color.m4828equalsimpl0(this.checkedIconColor, r101.checkedIconColor) == true) goto L23;
        return false;
    L23:
        if (Color.m4828equalsimpl0(this.uncheckedThumbColor, r101.uncheckedThumbColor) == true) goto L26;
        return false;
    L26:
        if (Color.m4828equalsimpl0(this.uncheckedTrackColor, r101.uncheckedTrackColor) == true) goto L29;
        return false;
    L29:
        if (Color.m4828equalsimpl0(this.uncheckedBorderColor, r101.uncheckedBorderColor) == true) goto L32;
        return false;
    L32:
        if (Color.m4828equalsimpl0(this.uncheckedIconColor, r101.uncheckedIconColor) == true) goto L35;
        return false;
    L35:
        if (Color.m4828equalsimpl0(this.disabledCheckedThumbColor, r101.disabledCheckedThumbColor) == true) goto L38;
        return false;
    L38:
        if (Color.m4828equalsimpl0(this.disabledCheckedTrackColor, r101.disabledCheckedTrackColor) == true) goto L41;
        return false;
    L41:
        if (Color.m4828equalsimpl0(this.disabledCheckedBorderColor, r101.disabledCheckedBorderColor) == true) goto L44;
        return false;
    L44:
        if (Color.m4828equalsimpl0(this.disabledCheckedIconColor, r101.disabledCheckedIconColor) == true) goto L47;
        return false;
    L47:
        if (Color.m4828equalsimpl0(this.disabledUncheckedThumbColor, r101.disabledUncheckedThumbColor) == true) goto L50;
        return false;
    L50:
        if (Color.m4828equalsimpl0(this.disabledUncheckedTrackColor, r101.disabledUncheckedTrackColor) == true) goto L53;
        return false;
    L53:
        if (Color.m4828equalsimpl0(this.disabledUncheckedBorderColor, r101.disabledUncheckedBorderColor) == true) goto L56;
        return false;
    L56:
        if (Color.m4828equalsimpl0(this.disabledUncheckedIconColor, r101.disabledUncheckedIconColor) == true) goto L58;
        return false;
    L58:
        return true;
    }

    /* JADX INFO: renamed from: borderColor-WaAFU9c$material3, reason: not valid java name */
    public final long m2717borderColorWaAFU9c$material3(boolean r100, boolean r101) {
        if (r100 == false) goto L6;
        if (r101 == false) goto L11;
        return this.checkedBorderColor;
    L11:
        return this.uncheckedBorderColor;
    L6:
        if (r101 == false) goto L9;
        return this.disabledCheckedBorderColor;
    L9:
        return this.disabledUncheckedBorderColor;
    }

    /* JADX INFO: renamed from: iconColor-WaAFU9c$material3, reason: not valid java name */
    public final long m2735iconColorWaAFU9c$material3(boolean r100, boolean r101) {
        if (r100 == false) goto L6;
        if (r101 == false) goto L11;
        return this.checkedIconColor;
    L11:
        return this.uncheckedIconColor;
    L6:
        if (r101 == false) goto L9;
        return this.disabledCheckedIconColor;
    L9:
        return this.disabledUncheckedIconColor;
    }

    /* JADX INFO: renamed from: thumbColor-WaAFU9c$material3, reason: not valid java name */
    public final long m2736thumbColorWaAFU9c$material3(boolean r100, boolean r101) {
        if (r100 == false) goto L6;
        if (r101 == false) goto L11;
        return this.checkedThumbColor;
    L11:
        return this.uncheckedThumbColor;
    L6:
        if (r101 == false) goto L9;
        return this.disabledCheckedThumbColor;
    L9:
        return this.disabledUncheckedThumbColor;
    }

    /* JADX INFO: renamed from: trackColor-WaAFU9c$material3, reason: not valid java name */
    public final long m2737trackColorWaAFU9c$material3(boolean r100, boolean r101) {
        if (r100 == false) goto L6;
        if (r101 == false) goto L11;
        return this.checkedTrackColor;
    L11:
        return this.uncheckedTrackColor;
    L6:
        if (r101 == false) goto L9;
        return this.disabledCheckedTrackColor;
    L9:
        return this.disabledUncheckedTrackColor;
    }

    private SwitchColors(long r100, long r101, long r102, long r110, long r111, long r112, long r113, long r114, long r210, long r211, long r212, long r213, long r214, long r310, long r311, long r312) {
        this.checkedThumbColor = r100;
        this.checkedTrackColor = r101;
        this.checkedBorderColor = r102;
        this.checkedIconColor = r110;
        this.uncheckedThumbColor = r111;
        this.uncheckedTrackColor = r112;
        this.uncheckedBorderColor = r113;
        this.uncheckedIconColor = r114;
        this.disabledCheckedThumbColor = r210;
        this.disabledCheckedTrackColor = r211;
        this.disabledCheckedBorderColor = r212;
        this.disabledCheckedIconColor = r213;
        this.disabledUncheckedThumbColor = r214;
        this.disabledUncheckedTrackColor = r310;
        this.disabledUncheckedBorderColor = r311;
        this.disabledUncheckedIconColor = r312;
    }

    /* JADX INFO: renamed from: copy-Q_H9qLU, reason: not valid java name */
    public final SwitchColors m2718copyQ_H9qLU(long r410, long r411, long r412, long r413, long r510, long r511, long r512, long r513, long r514, long r610, long r611, long r612, long r613, long r614, long r710, long r711) {
        boolean r100 = true;
        if (r410 == 16) goto L5;
        boolean r101 = true;
    L6:
        if (r101 == false) goto L8;
        long r102 = r410;
    L10:
        if (r411 == 16) goto L12;
        boolean r103 = true;
    L13:
        if (r103 == false) goto L15;
        long r110 = r411;
    L17:
        if (r412 == 16) goto L19;
        boolean r104 = true;
    L20:
        if (r104 == false) goto L22;
        long r111 = r412;
    L24:
        if (r413 == 16) goto L26;
        boolean r105 = true;
    L27:
        if (r105 == false) goto L29;
        long r112 = r413;
    L31:
        if (r510 == 16) goto L33;
        boolean r106 = true;
    L34:
        if (r106 == false) goto L36;
        long r113 = r510;
    L38:
        if (r511 == 16) goto L40;
        boolean r107 = true;
    L41:
        if (r107 == false) goto L43;
        long r114 = r511;
    L45:
        if (r512 == 16) goto L47;
        boolean r108 = true;
    L48:
        if (r108 == false) goto L50;
        long r210 = r512;
    L52:
        if (r513 == 16) goto L54;
        boolean r109 = true;
    L55:
        if (r109 == false) goto L57;
        long r211 = r513;
    L59:
        if (r514 == 16) goto L61;
        boolean r115 = true;
    L62:
        if (r115 == false) goto L64;
        long r212 = r514;
    L66:
        if (r610 == 16) goto L68;
        boolean r116 = true;
    L69:
        if (r116 == false) goto L71;
        long r213 = r610;
    L73:
        if (r611 == 16) goto L75;
        boolean r117 = true;
    L76:
        if (r117 == false) goto L78;
        long r214 = r611;
    L80:
        if (r612 == 16) goto L82;
        boolean r118 = true;
    L83:
        if (r118 == false) goto L85;
        long r310 = r612;
    L87:
        if (r613 == 16) goto L89;
        boolean r119 = true;
    L90:
        if (r119 == false) goto L92;
        long r311 = r613;
    L94:
        if (r614 == 16) goto L96;
        boolean r120 = true;
    L97:
        if (r120 == false) goto L99;
        long r312 = r614;
    L101:
        if (r710 == 16) goto L103;
        boolean r121 = true;
    L104:
        if (r121 == false) goto L106;
        long r313 = r710;
    L108:
        if (r711 != 16) goto L111;
        r100 = false;
    L111:
        if (r100 == false) goto L113;
        long r314 = r711;
    L115:
        return new SwitchColors(r102, r110, r111, r112, r113, r114, r210, r211, r212, r213, r214, r310, r311, r312, r313, r314, null);
    L113:
        r314 = this.disabledUncheckedIconColor;
        goto L115
    L106:
        r313 = this.disabledUncheckedBorderColor;
        goto L108
    L103:
        r121 = false;
        goto L104
    L99:
        r312 = this.disabledUncheckedTrackColor;
        goto L101
    L96:
        r120 = false;
        goto L97
    L92:
        r311 = this.disabledUncheckedThumbColor;
        goto L94
    L89:
        r119 = false;
        goto L90
    L85:
        r310 = this.disabledCheckedIconColor;
        goto L87
    L82:
        r118 = false;
        goto L83
    L78:
        r214 = this.disabledCheckedBorderColor;
        goto L80
    L75:
        r117 = false;
        goto L76
    L71:
        r213 = this.disabledCheckedTrackColor;
        goto L73
    L68:
        r116 = false;
        goto L69
    L64:
        r212 = this.disabledCheckedThumbColor;
        goto L66
    L61:
        r115 = false;
        goto L62
    L57:
        r211 = this.uncheckedIconColor;
        goto L59
    L54:
        r109 = false;
        goto L55
    L50:
        r210 = this.uncheckedBorderColor;
        goto L52
    L47:
        r108 = false;
        goto L48
    L43:
        r114 = this.uncheckedTrackColor;
        goto L45
    L40:
        r107 = false;
        goto L41
    L36:
        r113 = this.uncheckedThumbColor;
        goto L38
    L33:
        r106 = false;
        goto L34
    L29:
        r112 = this.checkedIconColor;
        goto L31
    L26:
        r105 = false;
        goto L27
    L22:
        r111 = this.checkedBorderColor;
        goto L24
    L19:
        r104 = false;
        goto L20
    L15:
        r110 = this.checkedTrackColor;
        goto L17
    L12:
        r103 = false;
        goto L13
    L8:
        r102 = this.checkedThumbColor;
        goto L10
    L5:
        r101 = false;
        goto L6
    }

    /* JADX INFO: renamed from: copy-Q_H9qLU$default, reason: not valid java name */
    public static /* synthetic */ SwitchColors m2716copyQ_H9qLU$default(SwitchColors r110, long r111, long r210, long r211, long r212, long r213, long r214, long r310, long r311, long r312, long r313, long r314, long r410, long r411, long r412, long r413, long r414, int r510, Object r511) {
        if ((r510 & 1) == 0) goto L5;
        long r100 = r110.checkedThumbColor;
    L7:
        if ((r510 & 2) == 0) goto L9;
        long r101 = r110.checkedTrackColor;
    L11:
        if ((r510 & 4) == 0) goto L13;
        long r102 = r110.checkedBorderColor;
    L15:
        if ((r510 & 8) == 0) goto L17;
        long r103 = r110.checkedIconColor;
    L19:
        if ((r510 & 16) == 0) goto L21;
        long r112 = r110.uncheckedThumbColor;
    L23:
        if ((r510 & 32) == 0) goto L25;
        long r113 = r110.uncheckedTrackColor;
    L27:
        if ((r510 & 64) == 0) goto L29;
        long r114 = r110.uncheckedBorderColor;
    L30:
        long r315 = r114;
        if ((r510 & 128) == 0) goto L33;
        long r115 = r110.uncheckedIconColor;
    L34:
        long r316 = r115;
        if ((r510 & 256) == 0) goto L37;
        long r116 = r110.disabledCheckedThumbColor;
    L38:
        long r317 = r116;
        if ((r510 & 512) == 0) goto L41;
        long r117 = r110.disabledCheckedTrackColor;
    L42:
        long r318 = r117;
        if ((r510 & 1024) == 0) goto L45;
        long r118 = r110.disabledCheckedBorderColor;
    L46:
        long r319 = r118;
        if ((r510 & 2048) == 0) goto L49;
        long r119 = r110.disabledCheckedIconColor;
    L50:
        long r415 = r119;
        if ((r510 & 4096) == 0) goto L53;
        long r120 = r110.disabledUncheckedThumbColor;
    L54:
        long r416 = r120;
        if ((r510 & 8192) == 0) goto L57;
        long r121 = r110.disabledUncheckedTrackColor;
    L58:
        long r417 = r121;
        if ((r510 & 16384) == 0) goto L61;
        long r122 = r110.disabledUncheckedBorderColor;
    L62:
        long r418 = r122;
        if ((r510 & 32768) == 0) goto L65;
        long r123 = r110.disabledUncheckedIconColor;
    L67:
        return r110.m2718copyQ_H9qLU(r100, r101, r102, r103, r112, r113, r315, r316, r317, r318, r319, r415, r416, r417, r418, r123);
    L65:
        r123 = r414;
        goto L67
    L61:
        r122 = r413;
        goto L62
    L57:
        r121 = r412;
        goto L58
    L53:
        r120 = r411;
        goto L54
    L49:
        r119 = r410;
        goto L50
    L45:
        r118 = r314;
        goto L46
    L41:
        r117 = r313;
        goto L42
    L37:
        r116 = r312;
        goto L38
    L33:
        r115 = r311;
        goto L34
    L29:
        r114 = r310;
        goto L30
    L25:
        r113 = r214;
        goto L27
    L21:
        r112 = r213;
        goto L23
    L17:
        r103 = r212;
        goto L19
    L13:
        r102 = r211;
        goto L15
    L9:
        r101 = r210;
        goto L11
    L5:
        r100 = r111;
        goto L7
    }
}
