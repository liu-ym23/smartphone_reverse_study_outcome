package androidx.compose.material3;

import androidx.compose.ui.graphics.Color;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b$\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0010\b\n\u0000\b\u0007\u0018\u00002\u00020\u0001Bw\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\u0006\u0010\f\u001a\u00020\u0003\u0012\u0006\u0010\r\u001a\u00020\u0003\u0012\u0006\u0010\u000e\u001a\u00020\u0003\u0012\u0006\u0010\u000f\u001a\u00020\u0003\u0012\u0006\u0010\u0010\u001a\u00020\u0003¢\u0006\u0004\b\u0011\u0010\u0012J\u0099\u0001\u0010#\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u00032\b\b\u0002\u0010\u000f\u001a\u00020\u00032\b\b\u0002\u0010\u0010\u001a\u00020\u0003¢\u0006\u0004\b$\u0010%J\u0017\u0010&\u001a\u00020\u00032\u0006\u0010'\u001a\u00020(H\u0001¢\u0006\u0004\b)\u0010*J\u0017\u0010+\u001a\u00020\u00032\u0006\u0010'\u001a\u00020(H\u0001¢\u0006\u0004\b,\u0010*J\u0017\u0010-\u001a\u00020\u00032\u0006\u0010'\u001a\u00020(H\u0001¢\u0006\u0004\b.\u0010*J\u0017\u0010/\u001a\u00020\u00032\u0006\u0010'\u001a\u00020(H\u0001¢\u0006\u0004\b0\u0010*J\u0017\u00101\u001a\u00020\u00032\u0006\u0010'\u001a\u00020(H\u0001¢\u0006\u0004\b2\u0010*J\u0013\u00103\u001a\u00020(2\b\u00104\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u00105\u001a\u000206H\u0016R\u0013\u0010\u0002\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b\u0013\u0010\u0014R\u0013\u0010\u0004\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b\u0016\u0010\u0014R\u0013\u0010\u0005\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b\u0017\u0010\u0014R\u0013\u0010\u0006\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b\u0018\u0010\u0014R\u0013\u0010\u0007\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b\u0019\u0010\u0014R\u0013\u0010\b\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b\u001a\u0010\u0014R\u0013\u0010\t\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b\u001b\u0010\u0014R\u0013\u0010\n\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b\u001c\u0010\u0014R\u0013\u0010\u000b\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b\u001d\u0010\u0014R\u0013\u0010\f\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b\u001e\u0010\u0014R\u0013\u0010\r\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b\u001f\u0010\u0014R\u0013\u0010\u000e\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b \u0010\u0014R\u0013\u0010\u000f\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b!\u0010\u0014R\u0013\u0010\u0010\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b\"\u0010\u0014¨\u00067"}, d2 = {"Landroidx/compose/material3/TimePickerColors;", "", "clockDialColor", "Landroidx/compose/ui/graphics/Color;", "selectorColor", "containerColor", "periodSelectorBorderColor", "clockDialSelectedContentColor", "clockDialUnselectedContentColor", "periodSelectorSelectedContainerColor", "periodSelectorUnselectedContainerColor", "periodSelectorSelectedContentColor", "periodSelectorUnselectedContentColor", "timeSelectorSelectedContainerColor", "timeSelectorUnselectedContainerColor", "timeSelectorSelectedContentColor", "timeSelectorUnselectedContentColor", "<init>", "(JJJJJJJJJJJJJJLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getClockDialColor-0d7_KjU", "()J", "J", "getSelectorColor-0d7_KjU", "getContainerColor-0d7_KjU", "getPeriodSelectorBorderColor-0d7_KjU", "getClockDialSelectedContentColor-0d7_KjU", "getClockDialUnselectedContentColor-0d7_KjU", "getPeriodSelectorSelectedContainerColor-0d7_KjU", "getPeriodSelectorUnselectedContainerColor-0d7_KjU", "getPeriodSelectorSelectedContentColor-0d7_KjU", "getPeriodSelectorUnselectedContentColor-0d7_KjU", "getTimeSelectorSelectedContainerColor-0d7_KjU", "getTimeSelectorUnselectedContainerColor-0d7_KjU", "getTimeSelectorSelectedContentColor-0d7_KjU", "getTimeSelectorUnselectedContentColor-0d7_KjU", "copy", "copy-dVHXu7A", "(JJJJJJJJJJJJJJ)Landroidx/compose/material3/TimePickerColors;", "periodSelectorContainerColor", "selected", "", "periodSelectorContainerColor-vNxB06k$material3", "(Z)J", "periodSelectorContentColor", "periodSelectorContentColor-vNxB06k$material3", "timeSelectorContainerColor", "timeSelectorContainerColor-vNxB06k$material3", "timeSelectorContentColor", "timeSelectorContentColor-vNxB06k$material3", "clockDialContentColor", "clockDialContentColor-vNxB06k$material3", "equals", "other", "hashCode", "", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class TimePickerColors {
    public static final int $stable = 0;
    private final long clockDialColor;
    private final long clockDialSelectedContentColor;
    private final long clockDialUnselectedContentColor;
    private final long containerColor;
    private final long periodSelectorBorderColor;
    private final long periodSelectorSelectedContainerColor;
    private final long periodSelectorSelectedContentColor;
    private final long periodSelectorUnselectedContainerColor;
    private final long periodSelectorUnselectedContentColor;
    private final long selectorColor;
    private final long timeSelectorSelectedContainerColor;
    private final long timeSelectorSelectedContentColor;
    private final long timeSelectorUnselectedContainerColor;
    private final long timeSelectorUnselectedContentColor;

    public /* synthetic */ TimePickerColors(long r100, long r101, long r102, long r103, long r104, long r110, long r111, long r112, long r113, long r114, long r210, long r211, long r212, long r213, DefaultConstructorMarker r214) {
        this(r100, r101, r102, r103, r104, r110, r111, r112, r113, r114, r210, r211, r212, r213);
    }

    public int hashCode() {
        return (((((((((((((((((((((Color.m4834hashCodeimpl(this.clockDialColor) * 31) + Color.m4834hashCodeimpl(this.selectorColor)) * 31) + Color.m4834hashCodeimpl(this.containerColor)) * 31) + Color.m4834hashCodeimpl(this.periodSelectorBorderColor)) * 31) + Color.m4834hashCodeimpl(this.periodSelectorSelectedContainerColor)) * 31) + Color.m4834hashCodeimpl(this.periodSelectorUnselectedContainerColor)) * 31) + Color.m4834hashCodeimpl(this.periodSelectorSelectedContentColor)) * 31) + Color.m4834hashCodeimpl(this.periodSelectorUnselectedContentColor)) * 31) + Color.m4834hashCodeimpl(this.timeSelectorSelectedContainerColor)) * 31) + Color.m4834hashCodeimpl(this.timeSelectorUnselectedContainerColor)) * 31) + Color.m4834hashCodeimpl(this.timeSelectorSelectedContentColor)) * 31) + Color.m4834hashCodeimpl(this.timeSelectorUnselectedContentColor);
    }

    /* JADX INFO: renamed from: getClockDialColor-0d7_KjU, reason: not valid java name */
    public final long m2857getClockDialColor0d7_KjU() {
        return this.clockDialColor;
    }

    /* JADX INFO: renamed from: getClockDialSelectedContentColor-0d7_KjU, reason: not valid java name */
    public final long m2858getClockDialSelectedContentColor0d7_KjU() {
        return this.clockDialSelectedContentColor;
    }

    /* JADX INFO: renamed from: getClockDialUnselectedContentColor-0d7_KjU, reason: not valid java name */
    public final long m2859getClockDialUnselectedContentColor0d7_KjU() {
        return this.clockDialUnselectedContentColor;
    }

    /* JADX INFO: renamed from: getContainerColor-0d7_KjU, reason: not valid java name */
    public final long m2860getContainerColor0d7_KjU() {
        return this.containerColor;
    }

    /* JADX INFO: renamed from: getPeriodSelectorBorderColor-0d7_KjU, reason: not valid java name */
    public final long m2861getPeriodSelectorBorderColor0d7_KjU() {
        return this.periodSelectorBorderColor;
    }

    /* JADX INFO: renamed from: getPeriodSelectorSelectedContainerColor-0d7_KjU, reason: not valid java name */
    public final long m2862getPeriodSelectorSelectedContainerColor0d7_KjU() {
        return this.periodSelectorSelectedContainerColor;
    }

    /* JADX INFO: renamed from: getPeriodSelectorSelectedContentColor-0d7_KjU, reason: not valid java name */
    public final long m2863getPeriodSelectorSelectedContentColor0d7_KjU() {
        return this.periodSelectorSelectedContentColor;
    }

    /* JADX INFO: renamed from: getPeriodSelectorUnselectedContainerColor-0d7_KjU, reason: not valid java name */
    public final long m2864getPeriodSelectorUnselectedContainerColor0d7_KjU() {
        return this.periodSelectorUnselectedContainerColor;
    }

    /* JADX INFO: renamed from: getPeriodSelectorUnselectedContentColor-0d7_KjU, reason: not valid java name */
    public final long m2865getPeriodSelectorUnselectedContentColor0d7_KjU() {
        return this.periodSelectorUnselectedContentColor;
    }

    /* JADX INFO: renamed from: getSelectorColor-0d7_KjU, reason: not valid java name */
    public final long m2866getSelectorColor0d7_KjU() {
        return this.selectorColor;
    }

    /* JADX INFO: renamed from: getTimeSelectorSelectedContainerColor-0d7_KjU, reason: not valid java name */
    public final long m2867getTimeSelectorSelectedContainerColor0d7_KjU() {
        return this.timeSelectorSelectedContainerColor;
    }

    /* JADX INFO: renamed from: getTimeSelectorSelectedContentColor-0d7_KjU, reason: not valid java name */
    public final long m2868getTimeSelectorSelectedContentColor0d7_KjU() {
        return this.timeSelectorSelectedContentColor;
    }

    /* JADX INFO: renamed from: getTimeSelectorUnselectedContainerColor-0d7_KjU, reason: not valid java name */
    public final long m2869getTimeSelectorUnselectedContainerColor0d7_KjU() {
        return this.timeSelectorUnselectedContainerColor;
    }

    /* JADX INFO: renamed from: getTimeSelectorUnselectedContentColor-0d7_KjU, reason: not valid java name */
    public final long m2870getTimeSelectorUnselectedContentColor0d7_KjU() {
        return this.timeSelectorUnselectedContentColor;
    }

    /* JADX INFO: renamed from: clockDialContentColor-vNxB06k$material3, reason: not valid java name */
    public final long m2855clockDialContentColorvNxB06k$material3(boolean r100) {
        if (r100 == false) goto L5;
        return this.clockDialSelectedContentColor;
    L5:
        return this.clockDialUnselectedContentColor;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if (r100 != null) goto L9;
        return false;
    L9:
        if (TimePickerColors.class == r100.getClass()) goto L11;
        return false;
    L11:
        TimePickerColors r101 = (TimePickerColors) r100;
        if (Color.m4828equalsimpl0(this.clockDialColor, r101.clockDialColor) == true) goto L15;
        return false;
    L15:
        if (Color.m4828equalsimpl0(this.selectorColor, r101.selectorColor) == true) goto L18;
        return false;
    L18:
        if (Color.m4828equalsimpl0(this.containerColor, r101.containerColor) == true) goto L21;
        return false;
    L21:
        if (Color.m4828equalsimpl0(this.periodSelectorBorderColor, r101.periodSelectorBorderColor) == true) goto L24;
        return false;
    L24:
        if (Color.m4828equalsimpl0(this.periodSelectorSelectedContainerColor, r101.periodSelectorSelectedContainerColor) == true) goto L27;
        return false;
    L27:
        if (Color.m4828equalsimpl0(this.periodSelectorUnselectedContainerColor, r101.periodSelectorUnselectedContainerColor) == true) goto L30;
        return false;
    L30:
        if (Color.m4828equalsimpl0(this.periodSelectorSelectedContentColor, r101.periodSelectorSelectedContentColor) == true) goto L33;
        return false;
    L33:
        if (Color.m4828equalsimpl0(this.periodSelectorUnselectedContentColor, r101.periodSelectorUnselectedContentColor) == true) goto L36;
        return false;
    L36:
        if (Color.m4828equalsimpl0(this.timeSelectorSelectedContainerColor, r101.timeSelectorSelectedContainerColor) == true) goto L39;
        return false;
    L39:
        if (Color.m4828equalsimpl0(this.timeSelectorUnselectedContainerColor, r101.timeSelectorUnselectedContainerColor) == true) goto L42;
        return false;
    L42:
        if (Color.m4828equalsimpl0(this.timeSelectorSelectedContentColor, r101.timeSelectorSelectedContentColor) == true) goto L45;
        return false;
    L45:
        if (Color.m4828equalsimpl0(this.timeSelectorUnselectedContentColor, r101.timeSelectorUnselectedContentColor) == true) goto L47;
        return false;
    L47:
        return true;
    }

    /* JADX INFO: renamed from: periodSelectorContainerColor-vNxB06k$material3, reason: not valid java name */
    public final long m2871periodSelectorContainerColorvNxB06k$material3(boolean r100) {
        if (r100 == false) goto L5;
        return this.periodSelectorSelectedContainerColor;
    L5:
        return this.periodSelectorUnselectedContainerColor;
    }

    /* JADX INFO: renamed from: periodSelectorContentColor-vNxB06k$material3, reason: not valid java name */
    public final long m2872periodSelectorContentColorvNxB06k$material3(boolean r100) {
        if (r100 == false) goto L5;
        return this.periodSelectorSelectedContentColor;
    L5:
        return this.periodSelectorUnselectedContentColor;
    }

    /* JADX INFO: renamed from: timeSelectorContainerColor-vNxB06k$material3, reason: not valid java name */
    public final long m2873timeSelectorContainerColorvNxB06k$material3(boolean r100) {
        if (r100 == false) goto L5;
        return this.timeSelectorSelectedContainerColor;
    L5:
        return this.timeSelectorUnselectedContainerColor;
    }

    /* JADX INFO: renamed from: timeSelectorContentColor-vNxB06k$material3, reason: not valid java name */
    public final long m2874timeSelectorContentColorvNxB06k$material3(boolean r100) {
        if (r100 == false) goto L5;
        return this.timeSelectorSelectedContentColor;
    L5:
        return this.timeSelectorUnselectedContentColor;
    }

    private TimePickerColors(long r100, long r101, long r102, long r110, long r111, long r112, long r113, long r114, long r210, long r211, long r212, long r213, long r214, long r310) {
        this.clockDialColor = r100;
        this.selectorColor = r101;
        this.containerColor = r102;
        this.periodSelectorBorderColor = r110;
        this.clockDialSelectedContentColor = r111;
        this.clockDialUnselectedContentColor = r112;
        this.periodSelectorSelectedContainerColor = r113;
        this.periodSelectorUnselectedContainerColor = r114;
        this.periodSelectorSelectedContentColor = r210;
        this.periodSelectorUnselectedContentColor = r211;
        this.timeSelectorSelectedContainerColor = r212;
        this.timeSelectorUnselectedContainerColor = r213;
        this.timeSelectorSelectedContentColor = r214;
        this.timeSelectorUnselectedContentColor = r310;
    }

    /* JADX INFO: renamed from: copy-dVHXu7A, reason: not valid java name */
    public final TimePickerColors m2856copydVHXu7A(long r310, long r410, long r411, long r412, long r413, long r414, long r510, long r511, long r512, long r513, long r514, long r610, long r611, long r612) {
        boolean r100 = true;
        if (r310 == 16) goto L5;
        boolean r101 = true;
    L6:
        if (r101 == false) goto L8;
        long r102 = r310;
    L10:
        if (r410 == 16) goto L12;
        boolean r103 = true;
    L13:
        if (r103 == false) goto L15;
        long r110 = r410;
    L17:
        if (r411 == 16) goto L19;
        boolean r104 = true;
    L20:
        if (r104 == false) goto L22;
        long r111 = r411;
    L24:
        if (r412 == 16) goto L26;
        boolean r105 = true;
    L27:
        if (r105 == false) goto L29;
        long r112 = r412;
    L31:
        if (r413 == 16) goto L33;
        boolean r106 = true;
    L34:
        if (r106 == false) goto L36;
        long r113 = r413;
    L38:
        if (r414 == 16) goto L40;
        boolean r107 = true;
    L41:
        if (r107 == false) goto L43;
        long r114 = r414;
    L45:
        if (r510 == 16) goto L47;
        boolean r108 = true;
    L48:
        if (r108 == false) goto L50;
        long r210 = r510;
    L52:
        if (r511 == 16) goto L54;
        boolean r109 = true;
    L55:
        if (r109 == false) goto L57;
        long r211 = r511;
    L59:
        if (r512 == 16) goto L61;
        boolean r115 = true;
    L62:
        if (r115 == false) goto L64;
        long r212 = r512;
    L66:
        if (r513 == 16) goto L68;
        boolean r116 = true;
    L69:
        if (r116 == false) goto L71;
        long r213 = r513;
    L73:
        if (r514 == 16) goto L75;
        boolean r117 = true;
    L76:
        if (r117 == false) goto L78;
        long r214 = r514;
    L80:
        if (r610 == 16) goto L82;
        boolean r118 = true;
    L83:
        if (r118 == false) goto L85;
        long r311 = r610;
    L87:
        if (r611 == 16) goto L89;
        boolean r119 = true;
    L90:
        if (r119 == false) goto L92;
        long r312 = r611;
    L94:
        if (r612 != 16) goto L97;
        r100 = false;
    L97:
        if (r100 == false) goto L99;
        long r313 = r612;
    L101:
        return new TimePickerColors(r102, r110, r111, r112, r113, r114, r210, r211, r212, r213, r214, r311, r312, r313, null);
    L99:
        r313 = this.timeSelectorUnselectedContentColor;
        goto L101
    L92:
        r312 = this.timeSelectorSelectedContentColor;
        goto L94
    L89:
        r119 = false;
        goto L90
    L85:
        r311 = this.timeSelectorUnselectedContainerColor;
        goto L87
    L82:
        r118 = false;
        goto L83
    L78:
        r214 = this.timeSelectorSelectedContainerColor;
        goto L80
    L75:
        r117 = false;
        goto L76
    L71:
        r213 = this.periodSelectorUnselectedContentColor;
        goto L73
    L68:
        r116 = false;
        goto L69
    L64:
        r212 = this.periodSelectorSelectedContentColor;
        goto L66
    L61:
        r115 = false;
        goto L62
    L57:
        r211 = this.periodSelectorUnselectedContainerColor;
        goto L59
    L54:
        r109 = false;
        goto L55
    L50:
        r210 = this.periodSelectorSelectedContainerColor;
        goto L52
    L47:
        r108 = false;
        goto L48
    L43:
        r114 = this.clockDialUnselectedContentColor;
        goto L45
    L40:
        r107 = false;
        goto L41
    L36:
        r113 = this.clockDialSelectedContentColor;
        goto L38
    L33:
        r106 = false;
        goto L34
    L29:
        r112 = this.periodSelectorBorderColor;
        goto L31
    L26:
        r105 = false;
        goto L27
    L22:
        r111 = this.containerColor;
        goto L24
    L19:
        r104 = false;
        goto L20
    L15:
        r110 = this.selectorColor;
        goto L17
    L12:
        r103 = false;
        goto L13
    L8:
        r102 = this.clockDialColor;
        goto L10
    L5:
        r101 = false;
        goto L6
    }

    /* JADX INFO: renamed from: copy-dVHXu7A$default, reason: not valid java name */
    public static /* synthetic */ TimePickerColors m2854copydVHXu7A$default(TimePickerColors r110, long r111, long r112, long r210, long r211, long r212, long r213, long r214, long r310, long r311, long r312, long r313, long r314, long r410, long r411, int r412, Object r413) {
        if ((r412 & 1) == 0) goto L5;
        long r100 = r110.containerColor;
    L7:
        if ((r412 & 2) == 0) goto L9;
        long r101 = r110.selectorColor;
    L11:
        if ((r412 & 4) == 0) goto L13;
        long r102 = r110.containerColor;
    L15:
        if ((r412 & 8) == 0) goto L17;
        long r103 = r110.periodSelectorBorderColor;
    L19:
        if ((r412 & 16) == 0) goto L21;
        long r113 = r110.clockDialSelectedContentColor;
    L23:
        if ((r412 & 32) == 0) goto L25;
        long r114 = r110.clockDialUnselectedContentColor;
    L27:
        if ((r412 & 64) == 0) goto L29;
        long r115 = r110.periodSelectorSelectedContainerColor;
    L30:
        long r215 = r115;
        if ((r412 & 128) == 0) goto L33;
        long r116 = r110.periodSelectorUnselectedContainerColor;
    L34:
        long r315 = r116;
        if ((r412 & 256) == 0) goto L37;
        long r117 = r110.periodSelectorSelectedContentColor;
    L38:
        long r316 = r117;
        if ((r412 & 512) == 0) goto L41;
        long r118 = r110.periodSelectorUnselectedContentColor;
    L42:
        long r317 = r118;
        if ((r412 & 1024) == 0) goto L45;
        long r119 = r110.timeSelectorSelectedContainerColor;
    L46:
        long r318 = r119;
        if ((r412 & 2048) == 0) goto L49;
        long r120 = r110.timeSelectorUnselectedContainerColor;
    L50:
        long r319 = r120;
        if ((r412 & 4096) == 0) goto L53;
        long r121 = r110.timeSelectorSelectedContentColor;
    L54:
        long r414 = r121;
        if ((r412 & 8192) == 0) goto L57;
        long r122 = r110.timeSelectorUnselectedContentColor;
    L59:
        return r110.m2856copydVHXu7A(r100, r101, r102, r103, r113, r114, r215, r315, r316, r317, r318, r319, r414, r122);
    L57:
        r122 = r411;
        goto L59
    L53:
        r121 = r410;
        goto L54
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
