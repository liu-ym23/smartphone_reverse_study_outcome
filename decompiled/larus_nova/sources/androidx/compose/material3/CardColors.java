package androidx.compose.material3;

import androidx.compose.ui.graphics.Color;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\b\u0007\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bJ5\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u0013H\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u0013H\u0001¢\u0006\u0004\b\u0016\u0010\u0015J\u0013\u0010\u0017\u001a\u00020\u00132\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u0019\u001a\u00020\u001aH\u0016R\u0013\u0010\u0002\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\t\u0010\nR\u0013\u0010\u0004\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\f\u0010\nR\u0013\u0010\u0005\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\r\u0010\nR\u0013\u0010\u0006\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\u000e\u0010\n¨\u0006\u001b"}, d2 = {"Landroidx/compose/material3/CardColors;", "", "containerColor", "Landroidx/compose/ui/graphics/Color;", "contentColor", "disabledContainerColor", "disabledContentColor", "<init>", "(JJJJLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getContainerColor-0d7_KjU", "()J", "J", "getContentColor-0d7_KjU", "getDisabledContainerColor-0d7_KjU", "getDisabledContentColor-0d7_KjU", "copy", "copy-jRlVdoo", "(JJJJ)Landroidx/compose/material3/CardColors;", "enabled", "", "containerColor-vNxB06k$material3", "(Z)J", "contentColor-vNxB06k$material3", "equals", "other", "hashCode", "", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class CardColors {
    public static final int $stable = 0;
    private final long containerColor;
    private final long contentColor;
    private final long disabledContainerColor;
    private final long disabledContentColor;

    public /* synthetic */ CardColors(long r100, long r101, long r102, long r103, DefaultConstructorMarker r104) {
        this(r100, r101, r102, r103);
    }

    public int hashCode() {
        return (((((Color.m4834hashCodeimpl(this.containerColor) * 31) + Color.m4834hashCodeimpl(this.contentColor)) * 31) + Color.m4834hashCodeimpl(this.disabledContainerColor)) * 31) + Color.m4834hashCodeimpl(this.disabledContentColor);
    }

    /* JADX INFO: renamed from: getContainerColor-0d7_KjU, reason: not valid java name */
    public final long m1919getContainerColor0d7_KjU() {
        return this.containerColor;
    }

    /* JADX INFO: renamed from: getContentColor-0d7_KjU, reason: not valid java name */
    public final long m1920getContentColor0d7_KjU() {
        return this.contentColor;
    }

    /* JADX INFO: renamed from: getDisabledContainerColor-0d7_KjU, reason: not valid java name */
    public final long m1921getDisabledContainerColor0d7_KjU() {
        return this.disabledContainerColor;
    }

    /* JADX INFO: renamed from: getDisabledContentColor-0d7_KjU, reason: not valid java name */
    public final long m1922getDisabledContentColor0d7_KjU() {
        return this.disabledContentColor;
    }

    /* JADX INFO: renamed from: containerColor-vNxB06k$material3, reason: not valid java name */
    public final long m1916containerColorvNxB06k$material3(boolean r100) {
        if (r100 == false) goto L5;
        return this.containerColor;
    L5:
        return this.disabledContainerColor;
    }

    /* JADX INFO: renamed from: contentColor-vNxB06k$material3, reason: not valid java name */
    public final long m1917contentColorvNxB06k$material3(boolean r100) {
        if (r100 == false) goto L5;
        return this.contentColor;
    L5:
        return this.disabledContentColor;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if (r100 != null) goto L8;
    L23:
        return false;
    L8:
        if ((r100 instanceof CardColors) == false) goto L23;
        CardColors r101 = (CardColors) r100;
        if (Color.m4828equalsimpl0(this.containerColor, r101.containerColor) == true) goto L14;
        return false;
    L14:
        if (Color.m4828equalsimpl0(this.contentColor, r101.contentColor) == true) goto L17;
        return false;
    L17:
        if (Color.m4828equalsimpl0(this.disabledContainerColor, r101.disabledContainerColor) == true) goto L20;
        return false;
    L20:
        if (Color.m4828equalsimpl0(this.disabledContentColor, r101.disabledContentColor) == true) goto L22;
        return false;
    L22:
        return true;
    }

    private CardColors(long r100, long r101, long r102, long r103) {
        this.containerColor = r100;
        this.contentColor = r101;
        this.disabledContainerColor = r102;
        this.disabledContentColor = r103;
    }

    /* JADX INFO: renamed from: copy-jRlVdoo, reason: not valid java name */
    public final CardColors m1918copyjRlVdoo(long r110, long r210, long r211, long r212) {
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
        return new CardColors(r102, r111, r112, r113, null);
    L29:
        r113 = this.disabledContentColor;
        goto L31
    L22:
        r112 = this.disabledContainerColor;
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
    public static /* synthetic */ CardColors m1915copyjRlVdoo$default(CardColors r100, long r110, long r111, long r112, long r113, int r114, Object r115) {
        if ((r114 & 1) == 0) goto L5;
        long r101 = r100.containerColor;
    L7:
        if ((r114 & 2) == 0) goto L9;
        long r102 = r100.contentColor;
    L11:
        if ((r114 & 4) == 0) goto L13;
        long r103 = r100.disabledContainerColor;
    L15:
        if ((r114 & 8) == 0) goto L17;
        long r104 = r100.disabledContentColor;
    L19:
        return r100.m1918copyjRlVdoo(r101, r102, r103, r104);
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
