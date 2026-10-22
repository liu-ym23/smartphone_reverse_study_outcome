package com.bytedance.android.live.broadcastgame;

import com.bytedance.ies.sdk.widgets.DataCenter;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class z extends e10.a.C5727a {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final a f62492k = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final DataCenter f62493a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f62494b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f62495c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f62496d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f62497e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f62498f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f62499g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f62500h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final int f62501i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final int f62502j;

    public static final class a {
        public a() {
        }
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof z) == false) goto L26;
        z r101 = (z) r100;
        if (Intrinsics.areEqual(this.f62493a, r101.f62493a) == true) goto L8;
        return false;
    L8:
        if (this.f62494b == r101.f62494b) goto L10;
        return false;
    L10:
        if (this.f62495c == r101.f62495c) goto L12;
        return false;
    L12:
        if (this.f62496d == r101.f62496d) goto L14;
        return false;
    L14:
        if (this.f62497e == r101.f62497e) goto L16;
        return false;
    L16:
        if (this.f62498f == r101.f62498f) goto L18;
        return false;
    L18:
        if (this.f62499g == r101.f62499g) goto L20;
        return false;
    L20:
        if (this.f62500h == r101.f62500h) goto L22;
        return false;
    L22:
        if (this.f62501i == r101.f62501i) goto L24;
        return false;
    L24:
        if (this.f62502j == r101.f62502j) goto L40;
        return false;
    L40:
        return true;
    L26:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v12, types: [int] */
    /* JADX WARN: Type inference failed for: r0v14, types: [int] */
    /* JADX WARN: Type inference failed for: r0v16, types: [int] */
    /* JADX WARN: Type inference failed for: r0v6, types: [int] */
    /* JADX WARN: Type inference failed for: r0v8, types: [int] */
    /* JADX WARN: Type inference failed for: r1v13 */
    /* JADX WARN: Type inference failed for: r1v14 */
    /* JADX WARN: Type inference failed for: r1v15 */
    /* JADX WARN: Type inference failed for: r1v16 */
    /* JADX WARN: Type inference failed for: r1v17 */
    /* JADX WARN: Type inference failed for: r1v18 */
    /* JADX WARN: Type inference failed for: r1v19 */
    /* JADX WARN: Type inference failed for: r1v2, types: [int] */
    /* JADX WARN: Type inference failed for: r1v20 */
    /* JADX WARN: Type inference failed for: r1v4, types: [int] */
    /* JADX WARN: Type inference failed for: r1v7, types: [int] */
    /* JADX WARN: Type inference failed for: r1v9, types: [int] */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v2 */
    public final int hashCode() {
        DataCenter r100 = this.f62493a;
        if (r100 == null) goto L5;
        int r101 = r100.hashCode();
    L6:
        int r102 = ((r101 * 31) + this.f62494b) * 31;
        boolean r103 = this.f62495c;
        ?? r104 = 1;
        ?? r105 = r103;
        if (r103 == false) goto L9;
        r105 = 1;
    L9:
        int r106 = (r102 + r105) * 31;
        boolean r107 = this.f62496d;
        ?? r108 = r107;
        if (r107 == false) goto L12;
        r108 = 1;
    L12:
        int r109 = (((r106 + r108) * 31) + this.f62497e) * 31;
        boolean r110 = this.f62498f;
        ?? r111 = r110;
        if (r110 == false) goto L15;
        r111 = 1;
    L15:
        int r112 = (r109 + r111) * 31;
        boolean r113 = this.f62499g;
        ?? r114 = r113;
        if (r113 == false) goto L18;
        r114 = 1;
    L18:
        int r115 = (r112 + r114) * 31;
        boolean r116 = this.f62500h;
        if (r116 == true) goto L23;
        r104 = r116;
    L23:
        return ((((r115 + r104) * 31) + this.f62501i) * 31) + this.f62502j;
    L5:
        r101 = 0;
        goto L6
    }

    public final String toString() {
        return "SceneFilterContext(dataCenter=" + this.f62493a + ", linkState=" + this.f62494b + ", inPk=" + this.f62495c + ", inMultiAnchorLink=" + this.f62496d + ", anchorLinkNum=" + this.f62497e + ", inAudienceLink=" + this.f62498f + ", haveAudienceRealLinked=" + this.f62499g + ", inMultiMode=" + this.f62500h + ", interactScene=" + this.f62501i + ", supportLiveMode=" + this.f62502j + ")";
    }

    static {
        f62492k = new a();
    }

    public z(DataCenter r100, int r101, boolean r102, boolean r103, int r104, boolean r105, boolean r106, boolean r107, int r110, int r111) {
        Intrinsics.checkNotNullParameter(r100, "dataCenter");
        this.f62493a = r100;
        this.f62494b = r101;
        this.f62495c = r102;
        this.f62496d = r103;
        this.f62497e = r104;
        this.f62498f = r105;
        this.f62499g = r106;
        this.f62500h = r107;
        this.f62501i = r110;
        this.f62502j = r111;
    }
}
