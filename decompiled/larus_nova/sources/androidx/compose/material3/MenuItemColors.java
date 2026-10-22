package androidx.compose.material3;

import androidx.compose.ui.graphics.Color;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\b\n\u0000\b\u0007\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003¢\u0006\u0004\b\t\u0010\nJI\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u0003¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u0017H\u0001¢\u0006\u0004\b\u0018\u0010\u0019J\u0017\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u0017H\u0001¢\u0006\u0004\b\u001a\u0010\u0019J\u0017\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u0017H\u0001¢\u0006\u0004\b\u001b\u0010\u0019J\u0013\u0010\u001c\u001a\u00020\u00172\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u001e\u001a\u00020\u001fH\u0016R\u0013\u0010\u0002\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0004\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000e\u0010\fR\u0013\u0010\u0005\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000f\u0010\fR\u0013\u0010\u0006\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u0010\u0010\fR\u0013\u0010\u0007\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u0011\u0010\fR\u0013\u0010\b\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u0012\u0010\f¨\u0006 "}, d2 = {"Landroidx/compose/material3/MenuItemColors;", "", "textColor", "Landroidx/compose/ui/graphics/Color;", "leadingIconColor", "trailingIconColor", "disabledTextColor", "disabledLeadingIconColor", "disabledTrailingIconColor", "<init>", "(JJJJJJLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getTextColor-0d7_KjU", "()J", "J", "getLeadingIconColor-0d7_KjU", "getTrailingIconColor-0d7_KjU", "getDisabledTextColor-0d7_KjU", "getDisabledLeadingIconColor-0d7_KjU", "getDisabledTrailingIconColor-0d7_KjU", "copy", "copy-tNS2XkQ", "(JJJJJJ)Landroidx/compose/material3/MenuItemColors;", "enabled", "", "textColor-vNxB06k$material3", "(Z)J", "leadingIconColor-vNxB06k$material3", "trailingIconColor-vNxB06k$material3", "equals", "other", "hashCode", "", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class MenuItemColors {
    public static final int $stable = 0;
    private final long disabledLeadingIconColor;
    private final long disabledTextColor;
    private final long disabledTrailingIconColor;
    private final long leadingIconColor;
    private final long textColor;
    private final long trailingIconColor;

    public /* synthetic */ MenuItemColors(long r100, long r101, long r102, long r103, long r104, long r110, DefaultConstructorMarker r111) {
        this(r100, r101, r102, r103, r104, r110);
    }

    public int hashCode() {
        return (((((((((Color.m4834hashCodeimpl(this.textColor) * 31) + Color.m4834hashCodeimpl(this.leadingIconColor)) * 31) + Color.m4834hashCodeimpl(this.trailingIconColor)) * 31) + Color.m4834hashCodeimpl(this.disabledTextColor)) * 31) + Color.m4834hashCodeimpl(this.disabledLeadingIconColor)) * 31) + Color.m4834hashCodeimpl(this.disabledTrailingIconColor);
    }

    /* JADX INFO: renamed from: getDisabledLeadingIconColor-0d7_KjU, reason: not valid java name */
    public final long m2378getDisabledLeadingIconColor0d7_KjU() {
        return this.disabledLeadingIconColor;
    }

    /* JADX INFO: renamed from: getDisabledTextColor-0d7_KjU, reason: not valid java name */
    public final long m2379getDisabledTextColor0d7_KjU() {
        return this.disabledTextColor;
    }

    /* JADX INFO: renamed from: getDisabledTrailingIconColor-0d7_KjU, reason: not valid java name */
    public final long m2380getDisabledTrailingIconColor0d7_KjU() {
        return this.disabledTrailingIconColor;
    }

    /* JADX INFO: renamed from: getLeadingIconColor-0d7_KjU, reason: not valid java name */
    public final long m2381getLeadingIconColor0d7_KjU() {
        return this.leadingIconColor;
    }

    /* JADX INFO: renamed from: getTextColor-0d7_KjU, reason: not valid java name */
    public final long m2382getTextColor0d7_KjU() {
        return this.textColor;
    }

    /* JADX INFO: renamed from: getTrailingIconColor-0d7_KjU, reason: not valid java name */
    public final long m2383getTrailingIconColor0d7_KjU() {
        return this.trailingIconColor;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if (r100 != null) goto L8;
    L29:
        return false;
    L8:
        if ((r100 instanceof MenuItemColors) == false) goto L29;
        MenuItemColors r101 = (MenuItemColors) r100;
        if (Color.m4828equalsimpl0(this.textColor, r101.textColor) == true) goto L14;
        return false;
    L14:
        if (Color.m4828equalsimpl0(this.leadingIconColor, r101.leadingIconColor) == true) goto L17;
        return false;
    L17:
        if (Color.m4828equalsimpl0(this.trailingIconColor, r101.trailingIconColor) == true) goto L20;
        return false;
    L20:
        if (Color.m4828equalsimpl0(this.disabledTextColor, r101.disabledTextColor) == true) goto L23;
        return false;
    L23:
        if (Color.m4828equalsimpl0(this.disabledLeadingIconColor, r101.disabledLeadingIconColor) == true) goto L26;
        return false;
    L26:
        if (Color.m4828equalsimpl0(this.disabledTrailingIconColor, r101.disabledTrailingIconColor) == true) goto L28;
        return false;
    L28:
        return true;
    }

    /* JADX INFO: renamed from: leadingIconColor-vNxB06k$material3, reason: not valid java name */
    public final long m2384leadingIconColorvNxB06k$material3(boolean r100) {
        if (r100 == false) goto L5;
        return this.leadingIconColor;
    L5:
        return this.disabledLeadingIconColor;
    }

    /* JADX INFO: renamed from: textColor-vNxB06k$material3, reason: not valid java name */
    public final long m2385textColorvNxB06k$material3(boolean r100) {
        if (r100 == false) goto L5;
        return this.textColor;
    L5:
        return this.disabledTextColor;
    }

    /* JADX INFO: renamed from: trailingIconColor-vNxB06k$material3, reason: not valid java name */
    public final long m2386trailingIconColorvNxB06k$material3(boolean r100) {
        if (r100 == false) goto L5;
        return this.trailingIconColor;
    L5:
        return this.disabledTrailingIconColor;
    }

    private MenuItemColors(long r100, long r101, long r102, long r103, long r104, long r110) {
        this.textColor = r100;
        this.leadingIconColor = r101;
        this.trailingIconColor = r102;
        this.disabledTextColor = r103;
        this.disabledLeadingIconColor = r104;
        this.disabledTrailingIconColor = r110;
    }

    /* JADX INFO: renamed from: copy-tNS2XkQ, reason: not valid java name */
    public final MenuItemColors m2377copytNS2XkQ(long r210, long r211, long r212, long r213, long r310, long r311) {
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
        if (r213 == 16) goto L26;
        boolean r105 = true;
    L27:
        if (r105 == false) goto L29;
        long r112 = r213;
    L31:
        if (r310 == 16) goto L33;
        boolean r106 = true;
    L34:
        if (r106 == false) goto L36;
        long r113 = r310;
    L38:
        if (r311 != 16) goto L41;
        r100 = false;
    L41:
        if (r100 == false) goto L43;
        long r114 = r311;
    L45:
        return new MenuItemColors(r102, r110, r111, r112, r113, r114, null);
    L43:
        r114 = this.disabledTrailingIconColor;
        goto L45
    L36:
        r113 = this.disabledLeadingIconColor;
        goto L38
    L33:
        r106 = false;
        goto L34
    L29:
        r112 = this.disabledTextColor;
        goto L31
    L26:
        r105 = false;
        goto L27
    L22:
        r111 = this.trailingIconColor;
        goto L24
    L19:
        r104 = false;
        goto L20
    L15:
        r110 = this.leadingIconColor;
        goto L17
    L12:
        r103 = false;
        goto L13
    L8:
        r102 = this.textColor;
        goto L10
    L5:
        r101 = false;
        goto L6
    }

    /* JADX INFO: renamed from: copy-tNS2XkQ$default, reason: not valid java name */
    public static /* synthetic */ MenuItemColors m2376copytNS2XkQ$default(MenuItemColors r110, long r111, long r112, long r113, long r210, long r211, long r212, int r213, Object r214) {
        if ((r213 & 1) == 0) goto L5;
        long r100 = r110.textColor;
    L7:
        if ((r213 & 2) == 0) goto L9;
        long r101 = r110.leadingIconColor;
    L11:
        if ((r213 & 4) == 0) goto L13;
        long r102 = r110.trailingIconColor;
    L15:
        if ((r213 & 8) == 0) goto L17;
        long r103 = r110.disabledTextColor;
    L19:
        if ((r213 & 16) == 0) goto L21;
        long r104 = r110.disabledLeadingIconColor;
    L23:
        if ((r213 & 32) == 0) goto L25;
        long r114 = r110.disabledTrailingIconColor;
    L27:
        return r110.m2377copytNS2XkQ(r100, r101, r102, r103, r104, r114);
    L25:
        r114 = r212;
        goto L27
    L21:
        r104 = r211;
        goto L23
    L17:
        r103 = r210;
        goto L19
    L13:
        r102 = r113;
        goto L15
    L9:
        r101 = r112;
        goto L11
    L5:
        r100 = r111;
        goto L7
    }
}
