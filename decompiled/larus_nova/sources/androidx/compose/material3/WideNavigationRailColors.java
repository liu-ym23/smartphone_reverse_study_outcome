package androidx.compose.material3;

import androidx.compose.ui.graphics.Color;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0007\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003¢\u0006\u0004\b\b\u0010\tJ?\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u0003¢\u0006\u0004\b\u0012\u0010\u0013J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u0017\u001a\u00020\u0018H\u0016R\u0013\u0010\u0002\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0004\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\r\u0010\u000bR\u0013\u0010\u0005\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\u000e\u0010\u000bR\u0013\u0010\u0006\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\u000f\u0010\u000bR\u0013\u0010\u0007\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\u0010\u0010\u000b¨\u0006\u0019"}, d2 = {"Landroidx/compose/material3/WideNavigationRailColors;", "", "containerColor", "Landroidx/compose/ui/graphics/Color;", "contentColor", "modalContainerColor", "modalScrimColor", "modalContentColor", "<init>", "(JJJJJLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getContainerColor-0d7_KjU", "()J", "J", "getContentColor-0d7_KjU", "getModalContainerColor-0d7_KjU", "getModalScrimColor-0d7_KjU", "getModalContentColor-0d7_KjU", "copy", "copy-t635Npw", "(JJJJJ)Landroidx/compose/material3/WideNavigationRailColors;", "equals", "", "other", "hashCode", "", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class WideNavigationRailColors {
    public static final int $stable = 0;
    private final long containerColor;
    private final long contentColor;
    private final long modalContainerColor;
    private final long modalContentColor;
    private final long modalScrimColor;

    public /* synthetic */ WideNavigationRailColors(long r100, long r101, long r102, long r103, long r104, DefaultConstructorMarker r110) {
        this(r100, r101, r102, r103, r104);
    }

    public int hashCode() {
        return (((((((Color.m4834hashCodeimpl(this.containerColor) * 31) + Color.m4834hashCodeimpl(this.contentColor)) * 31) + Color.m4834hashCodeimpl(this.modalContainerColor)) * 31) + Color.m4834hashCodeimpl(this.modalScrimColor)) * 31) + Color.m4834hashCodeimpl(this.modalContentColor);
    }

    /* JADX INFO: renamed from: getContainerColor-0d7_KjU, reason: not valid java name */
    public final long m3082getContainerColor0d7_KjU() {
        return this.containerColor;
    }

    /* JADX INFO: renamed from: getContentColor-0d7_KjU, reason: not valid java name */
    public final long m3083getContentColor0d7_KjU() {
        return this.contentColor;
    }

    /* JADX INFO: renamed from: getModalContainerColor-0d7_KjU, reason: not valid java name */
    public final long m3084getModalContainerColor0d7_KjU() {
        return this.modalContainerColor;
    }

    /* JADX INFO: renamed from: getModalContentColor-0d7_KjU, reason: not valid java name */
    public final long m3085getModalContentColor0d7_KjU() {
        return this.modalContentColor;
    }

    /* JADX INFO: renamed from: getModalScrimColor-0d7_KjU, reason: not valid java name */
    public final long m3086getModalScrimColor0d7_KjU() {
        return this.modalScrimColor;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if (r100 != null) goto L8;
    L23:
        return false;
    L8:
        if ((r100 instanceof WideNavigationRailColors) == false) goto L23;
        WideNavigationRailColors r101 = (WideNavigationRailColors) r100;
        if (Color.m4828equalsimpl0(this.containerColor, r101.containerColor) == true) goto L14;
        return false;
    L14:
        if (Color.m4828equalsimpl0(this.contentColor, r101.contentColor) == true) goto L17;
        return false;
    L17:
        if (Color.m4828equalsimpl0(this.modalContainerColor, r101.modalContainerColor) == true) goto L20;
        return false;
    L20:
        if (Color.m4828equalsimpl0(this.modalScrimColor, r101.modalScrimColor) == true) goto L22;
        return false;
    L22:
        return true;
    }

    private WideNavigationRailColors(long r100, long r101, long r102, long r103, long r104) {
        this.containerColor = r100;
        this.contentColor = r101;
        this.modalContainerColor = r102;
        this.modalScrimColor = r103;
        this.modalContentColor = r104;
    }

    /* JADX INFO: renamed from: copy-t635Npw, reason: not valid java name */
    public final WideNavigationRailColors m3081copyt635Npw(long r210, long r211, long r212, long r213, long r214) {
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
        if (r214 != 16) goto L34;
        r100 = false;
    L34:
        if (r100 == false) goto L36;
        long r113 = r214;
    L38:
        return new WideNavigationRailColors(r102, r110, r111, r112, r113, null);
    L36:
        r113 = this.modalContentColor;
        goto L38
    L29:
        r112 = this.modalScrimColor;
        goto L31
    L26:
        r105 = false;
        goto L27
    L22:
        r111 = this.modalContainerColor;
        goto L24
    L19:
        r104 = false;
        goto L20
    L15:
        r110 = this.contentColor;
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

    /* JADX INFO: renamed from: copy-t635Npw$default, reason: not valid java name */
    public static /* synthetic */ WideNavigationRailColors m3080copyt635Npw$default(WideNavigationRailColors r110, long r111, long r112, long r113, long r114, long r210, int r211, Object r212) {
        if ((r211 & 1) == 0) goto L5;
        long r100 = r110.containerColor;
    L7:
        if ((r211 & 2) == 0) goto L9;
        long r101 = r110.contentColor;
    L11:
        if ((r211 & 4) == 0) goto L13;
        long r102 = r110.modalContainerColor;
    L15:
        if ((r211 & 8) == 0) goto L17;
        long r103 = r110.modalScrimColor;
    L19:
        if ((r211 & 16) == 0) goto L21;
        long r104 = r110.modalContentColor;
    L23:
        return r110.m3081copyt635Npw(r100, r101, r102, r103, r104);
    L21:
        r104 = r210;
        goto L23
    L17:
        r103 = r114;
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
