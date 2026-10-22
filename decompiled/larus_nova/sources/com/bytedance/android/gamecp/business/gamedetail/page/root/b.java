package com.bytedance.android.gamecp.business.gamedetail.page.root;

import com.bytedance.android.gamecp.common.model.GameStageType;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class b implements com.bytedance.ies.sve_core.s {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final int f55465i = 0;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final int f55466j = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f55467a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f55468b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f55469c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Float f55470d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final p0 f55471e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f55472f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f55473g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f55474h;

    public static final class a {
    }

    public b() {
        this(null, 0, 0, 0, 255);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof b) == false) goto L22;
        b r101 = (b) r100;
        if (Intrinsics.areEqual(this.f55467a, r101.f55467a) == true) goto L8;
        return false;
    L8:
        if (this.f55468b == r101.f55468b) goto L10;
        return false;
    L10:
        if (this.f55469c == r101.f55469c) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f55470d, r101.f55470d) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.f55471e, r101.f55471e) == true) goto L16;
        return false;
    L16:
        if (this.f55472f == r101.f55472f) goto L18;
        return false;
    L18:
        if (this.f55473g == r101.f55473g) goto L20;
        return false;
    L20:
        if (this.f55474h == r101.f55474h) goto L34;
        return false;
    L34:
        return true;
    L22:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v16, types: [int] */
    /* JADX WARN: Type inference failed for: r1v5, types: [int] */
    /* JADX WARN: Type inference failed for: r1v6 */
    /* JADX WARN: Type inference failed for: r1v8 */
    public final int hashCode() {
        String r100 = this.f55467a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = ((((r102 * 31) + this.f55468b) * 31) + this.f55469c) * 31;
        Float r104 = this.f55470d;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        p0 r107 = this.f55471e;
        if (r107 == null) goto L13;
        r101 = r107.hashCode();
    L13:
        int r108 = (((((r106 + r101) * 31) + this.f55472f) * 31) + this.f55473g) * 31;
        boolean r109 = this.f55474h;
        ?? r110 = r109;
        if (r109 == false) goto L17;
        r110 = 1;
    L17:
        return r108 + r110;
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "AudienceGameAppearance(currentTab=" + this.f55467a + ", gameStage=" + this.f55468b + ", dialogState=" + this.f55469c + ", dialogSlideOffset=" + this.f55470d + ", outerRVScrollData=" + this.f55471e + ", screenOrientation=" + this.f55472f + ", bottomBar=" + this.f55473g + ", showBottomBar=" + this.f55474h + ")";
    }

    static {
        f55465i = GameStageType.RESERVATION.getType();
        f55466j = GameStageType.DOWNLOAD.getType();
    }

    public /* synthetic */ b(String r110, int r111, int r112, int r113, int r114) {
        if ((r114 & 1) == 0) goto L5;
        r110 = "tab_game_detail";
    L5:
        String r100 = r110;
        if ((r114 & 2) == 0) goto L8;
        r111 = f55466j;
    L8:
        int r101 = r111;
        if ((r114 & 4) == 0) goto L11;
        int r102 = 1;
    L13:
        if ((r114 & 16) == 0) goto L15;
        p0 r115 = new p0(0);
    L16:
        p0 r103 = r115;
        if ((r114 & 32) == 0) goto L19;
        int r104 = 1;
    L21:
        if ((r114 & 64) == 0) goto L23;
        int r105 = 1;
    L25:
        if ((r114 & 128) == 0) goto L27;
        boolean r106 = true;
    L28:
        this(r100, r101, r102, null, r103, r104, r105, r106);
        return;
    L27:
        r106 = false;
        goto L28
    L23:
        r105 = 0;
        goto L25
    L19:
        r104 = r113;
        goto L21
    L15:
        r115 = null;
        goto L16
    L11:
        r102 = r112;
        goto L13
    }

    public b(String r100, int r101, int r102, Float r103, p0 r104, int r105, int r106, boolean r107) {
        Intrinsics.checkNotNullParameter(r100, "currentTab");
        Intrinsics.checkNotNullParameter(r104, "outerRVScrollData");
        this.f55467a = r100;
        this.f55468b = r101;
        this.f55469c = r102;
        this.f55470d = r103;
        this.f55471e = r104;
        this.f55472f = r105;
        this.f55473g = r106;
        this.f55474h = r107;
    }

    public static b c(b r110, String r111, int r112, Float r113, p0 r114, int r115, boolean r116, int r117) {
        if ((r117 & 1) == 0) goto L5;
        String r100 = r110.f55467a;
    L7:
        if ((r117 & 2) == 0) goto L9;
        int r101 = r110.f55468b;
    L11:
        if ((r117 & 4) == 0) goto L13;
        int r102 = r110.f55469c;
    L15:
        if ((r117 & 8) == 0) goto L17;
        Float r103 = r110.f55470d;
    L19:
        if ((r117 & 16) == 0) goto L21;
        p0 r104 = r110.f55471e;
    L23:
        if ((r117 & 32) == 0) goto L25;
        int r105 = r110.f55472f;
    L27:
        if ((r117 & 64) == 0) goto L29;
        int r118 = r110.f55473g;
    L31:
        if ((r117 & 128) == 0) goto L33;
        boolean r119 = r110.f55474h;
    L34:
        r110.getClass();
        Intrinsics.checkNotNullParameter(r100, "currentTab");
        Intrinsics.checkNotNullParameter(r104, "outerRVScrollData");
        return new b(r100, r101, r102, r103, r104, r105, r118, r119);
    L33:
        r119 = r116;
        goto L34
    L29:
        r118 = r115;
        goto L31
    L25:
        r105 = 0;
        goto L27
    L21:
        r104 = r114;
        goto L23
    L17:
        r103 = r113;
        goto L19
    L13:
        r102 = r112;
        goto L15
    L9:
        r101 = 0;
        goto L11
    L5:
        r100 = r111;
        goto L7
    }
}
