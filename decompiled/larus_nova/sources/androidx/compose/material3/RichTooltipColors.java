package androidx.compose.material3;

import androidx.compose.ui.graphics.Color;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0007\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bJ5\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0010\u0010\u0011J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u0015\u001a\u00020\u0016H\u0016R\u0013\u0010\u0002\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\t\u0010\nR\u0013\u0010\u0004\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\f\u0010\nR\u0013\u0010\u0005\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\r\u0010\nR\u0013\u0010\u0006\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\u000e\u0010\n¨\u0006\u0017"}, d2 = {"Landroidx/compose/material3/RichTooltipColors;", "", "containerColor", "Landroidx/compose/ui/graphics/Color;", "contentColor", "titleContentColor", "actionContentColor", "<init>", "(JJJJLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getContainerColor-0d7_KjU", "()J", "J", "getContentColor-0d7_KjU", "getTitleContentColor-0d7_KjU", "getActionContentColor-0d7_KjU", "copy", "copy-jRlVdoo", "(JJJJ)Landroidx/compose/material3/RichTooltipColors;", "equals", "", "other", "hashCode", "", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class RichTooltipColors {
    public static final int $stable = 0;
    private final long actionContentColor;
    private final long containerColor;
    private final long contentColor;
    private final long titleContentColor;

    public /* synthetic */ RichTooltipColors(long r100, long r101, long r102, long r103, DefaultConstructorMarker r104) {
        this(r100, r101, r102, r103);
    }

    public int hashCode() {
        return (((((Color.m4834hashCodeimpl(this.containerColor) * 31) + Color.m4834hashCodeimpl(this.contentColor)) * 31) + Color.m4834hashCodeimpl(this.titleContentColor)) * 31) + Color.m4834hashCodeimpl(this.actionContentColor);
    }

    /* JADX INFO: renamed from: getActionContentColor-0d7_KjU, reason: not valid java name */
    public final long m2535getActionContentColor0d7_KjU() {
        return this.actionContentColor;
    }

    /* JADX INFO: renamed from: getContainerColor-0d7_KjU, reason: not valid java name */
    public final long m2536getContainerColor0d7_KjU() {
        return this.containerColor;
    }

    /* JADX INFO: renamed from: getContentColor-0d7_KjU, reason: not valid java name */
    public final long m2537getContentColor0d7_KjU() {
        return this.contentColor;
    }

    /* JADX INFO: renamed from: getTitleContentColor-0d7_KjU, reason: not valid java name */
    public final long m2538getTitleContentColor0d7_KjU() {
        return this.titleContentColor;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof RichTooltipColors) == true) goto L8;
        return false;
    L8:
        RichTooltipColors r101 = (RichTooltipColors) r100;
        if (Color.m4828equalsimpl0(this.containerColor, r101.containerColor) == true) goto L12;
        return false;
    L12:
        if (Color.m4828equalsimpl0(this.contentColor, r101.contentColor) == true) goto L15;
        return false;
    L15:
        if (Color.m4828equalsimpl0(this.titleContentColor, r101.titleContentColor) == true) goto L18;
        return false;
    L18:
        if (Color.m4828equalsimpl0(this.actionContentColor, r101.actionContentColor) == true) goto L20;
        return false;
    L20:
        return true;
    }

    private RichTooltipColors(long r100, long r101, long r102, long r103) {
        this.containerColor = r100;
        this.contentColor = r101;
        this.titleContentColor = r102;
        this.actionContentColor = r103;
    }

    /* JADX INFO: renamed from: copy-jRlVdoo, reason: not valid java name */
    public final RichTooltipColors m2534copyjRlVdoo(long r110, long r210, long r211, long r212) {
        boolean r100 = true;
        if (r110 == 16) goto L5;
        boolean r101 = true;
    L6:
        if (r101 == false) goto L8;
        long r102 = r110;
    L10:
        if (r210 == 16) goto L12;
        boolean r103 = true;
    L13:
        if (r103 == false) goto L15;
        long r111 = r210;
    L17:
        if (r211 == 16) goto L19;
        boolean r104 = true;
    L20:
        if (r104 == false) goto L22;
        long r112 = r211;
    L24:
        if (r212 != 16) goto L27;
        r100 = false;
    L27:
        if (r100 == false) goto L29;
        long r113 = r212;
    L31:
        return new RichTooltipColors(r102, r111, r112, r113, null);
    L29:
        r113 = this.actionContentColor;
        goto L31
    L22:
        r112 = this.titleContentColor;
        goto L24
    L19:
        r104 = false;
        goto L20
    L15:
        r111 = this.contentColor;
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

    /* JADX INFO: renamed from: copy-jRlVdoo$default, reason: not valid java name */
    public static /* synthetic */ RichTooltipColors m2533copyjRlVdoo$default(RichTooltipColors r100, long r110, long r111, long r112, long r113, int r114, Object r115) {
        if ((r114 & 1) == 0) goto L5;
        long r101 = r100.containerColor;
    L7:
        if ((r114 & 2) == 0) goto L9;
        long r102 = r100.contentColor;
    L11:
        if ((r114 & 4) == 0) goto L13;
        long r103 = r100.titleContentColor;
    L15:
        if ((r114 & 8) == 0) goto L17;
        long r104 = r100.actionContentColor;
    L19:
        return r100.m2534copyjRlVdoo(r101, r102, r103, r104);
    L17:
        r104 = r113;
        goto L19
    L13:
        r103 = r112;
        goto L15
    L9:
        r102 = r111;
        goto L11
    L5:
        r101 = r110;
        goto L7
    }
}
