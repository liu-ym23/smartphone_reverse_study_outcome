package com.bytedance.android.shopping.api.video;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class l {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final /* synthetic */ int f170671i = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AVScene f170672a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f170673b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f170674c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f170675d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f170676e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final SelectBitrateResolutionStrategy f170677f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f170678g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f170679h;

    public static final class a {
    }

    static {
    }

    public l() {
        this(null, false, false, false, null, false, false, 255);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof l) == false) goto L22;
        l r101 = (l) r100;
        if (Intrinsics.areEqual(this.f170672a, r101.f170672a) == true) goto L8;
        return false;
    L8:
        if (this.f170673b == r101.f170673b) goto L10;
        return false;
    L10:
        if (this.f170674c == r101.f170674c) goto L12;
        return false;
    L12:
        if (this.f170675d == r101.f170675d) goto L14;
        return false;
    L14:
        if (this.f170676e == r101.f170676e) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.f170677f, r101.f170677f) == true) goto L18;
        return false;
    L18:
        if (this.f170678g == r101.f170678g) goto L20;
        return false;
    L20:
        if (this.f170679h == r101.f170679h) goto L34;
        return false;
    L34:
        return true;
    L22:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v14, types: [int] */
    /* JADX WARN: Type inference failed for: r0v16, types: [int] */
    /* JADX WARN: Type inference failed for: r0v4, types: [int] */
    /* JADX WARN: Type inference failed for: r1v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v5 */
    /* JADX WARN: Type inference failed for: r1v7 */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v10 */
    /* JADX WARN: Type inference failed for: r2v11 */
    /* JADX WARN: Type inference failed for: r2v12 */
    /* JADX WARN: Type inference failed for: r2v13 */
    /* JADX WARN: Type inference failed for: r2v3, types: [int] */
    /* JADX WARN: Type inference failed for: r2v6, types: [int] */
    /* JADX WARN: Type inference failed for: r2v8 */
    /* JADX WARN: Type inference failed for: r2v9 */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1, types: [int] */
    /* JADX WARN: Type inference failed for: r3v2 */
    public final int hashCode() {
        AVScene r100 = this.f170672a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        boolean r104 = this.f170673b;
        ?? r105 = 1;
        ?? r106 = r104;
        if (r104 == false) goto L9;
        r106 = 1;
    L9:
        int r107 = (r103 + r106) * 31;
        boolean r108 = this.f170674c;
        ?? r109 = r108;
        if (r108 == false) goto L12;
        r109 = 1;
    L12:
        int r110 = (((r107 + r109) * 31) + this.f170675d) * 31;
        boolean r111 = this.f170676e;
        ?? r112 = r111;
        if (r111 == false) goto L15;
        r112 = 1;
    L15:
        int r113 = (r110 + r112) * 31;
        SelectBitrateResolutionStrategy r114 = this.f170677f;
        if (r114 == null) goto L18;
        r101 = r114.hashCode();
    L18:
        int r115 = (r113 + r101) * 31;
        boolean r116 = this.f170678g;
        ?? r117 = r116;
        if (r116 == false) goto L21;
        r117 = 1;
    L21:
        int r118 = (r115 + r117) * 31;
        boolean r119 = this.f170679h;
        if (r119 == true) goto L26;
        r105 = r119;
    L26:
        return r118 + r105;
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "SimPlayerStrategyConfig(scene=" + this.f170672a + ", delayInitPlayer=" + this.f170673b + ", enablePlayerPoolManager=" + this.f170674c + ", playerPoolSize=" + this.f170675d + ", enableStopReleaseHelper=" + this.f170676e + ", videoBitrateStrategy=" + this.f170677f + ", keepScreenOnPlaying=" + this.f170678g + ", adaptVideoSizeChange=" + this.f170679h + ")";
    }

    public l(AVScene r100, boolean r101, boolean r102, boolean r103, SelectBitrateResolutionStrategy r104, boolean r105, boolean r110, int r111) {
        if ((r111 & 1) == 0) goto L6;
        r100 = AVScene.CONTENT_DEFAULT;
    L6:
        if ((r111 & 2) == 0) goto L9;
        r101 = false;
    L9:
        if ((r111 & 4) == 0) goto L12;
        r102 = false;
    L12:
        if ((r111 & 8) == 0) goto L14;
        int r106 = 3;
    L16:
        if ((r111 & 16) == 0) goto L19;
        r103 = false;
    L19:
        if ((r111 & 32) == 0) goto L22;
        r104 = SelectBitrateResolutionStrategy.DEFAULT;
    L22:
        if ((r111 & 64) == 0) goto L25;
        r105 = false;
    L25:
        if ((r111 & 128) == 0) goto L27;
        r110 = false;
    L27:
        Intrinsics.checkNotNullParameter(r100, "scene");
        Intrinsics.checkNotNullParameter(r104, "videoBitrateStrategy");
        this.f170672a = r100;
        this.f170673b = r101;
        this.f170674c = r102;
        this.f170675d = r106;
        this.f170676e = r103;
        this.f170677f = r104;
        this.f170678g = r105;
        this.f170679h = r110;
        return;
    L14:
        r106 = 0;
        goto L16
    }
}
