package com.bytedance.android.live.revlink.impl.multianchor.transfer;

import com.bytedance.android.livesdkapi.depend.model.live.ILiveMode;
import com.bytedance.android.livesdkapi.roomplayer.AbsLivePlayerView;
import k31.k;
import kotlin.jvm.internal.Intrinsics;
import rc0.q;

/* JADX INFO: loaded from: classes47.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f94703a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f94704b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f94705c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final AbsLivePlayerView f94706d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f94707e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final ILiveMode f94708f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f94709g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final k31.f f94710h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final q f94711i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final k f94712j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final k31.a f94713k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final boolean f94714l;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof d) == false) goto L30;
        d r101 = (d) r100;
        if (this.f94703a == r101.f94703a) goto L8;
        return false;
    L8:
        if (this.f94704b == r101.f94704b) goto L10;
        return false;
    L10:
        if (this.f94705c == r101.f94705c) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f94706d, r101.f94706d) == true) goto L14;
        return false;
    L14:
        if (this.f94707e == r101.f94707e) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.f94708f, r101.f94708f) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f94709g, r101.f94709g) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.f94710h, r101.f94710h) == true) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.f94711i, r101.f94711i) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f94712j, r101.f94712j) == true) goto L26;
        return false;
    L26:
        if (Intrinsics.areEqual(this.f94713k, r101.f94713k) == true) goto L28;
        return false;
    L28:
        if (this.f94714l == r101.f94714l) goto L46;
        return false;
    L46:
        return true;
    L30:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v22, types: [int] */
    /* JADX WARN: Type inference failed for: r0v4, types: [int] */
    /* JADX WARN: Type inference failed for: r0v8, types: [int] */
    /* JADX WARN: Type inference failed for: r1v2, types: [int] */
    /* JADX WARN: Type inference failed for: r1v30 */
    /* JADX WARN: Type inference failed for: r1v32 */
    /* JADX WARN: Type inference failed for: r1v33 */
    /* JADX WARN: Type inference failed for: r1v34 */
    /* JADX WARN: Type inference failed for: r1v7, types: [int] */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v2 */
    public final int hashCode() {
        int r100 = ((this.f94703a * 31) + this.f94704b) * 31;
        boolean r101 = this.f94705c;
        ?? r102 = 1;
        ?? r103 = r101;
        if (r101 == false) goto L5;
        r103 = 1;
    L5:
        int r104 = (r100 + r103) * 31;
        AbsLivePlayerView r105 = this.f94706d;
        int r106 = 0;
        if (r105 == null) goto L8;
        int r107 = r105.hashCode();
    L9:
        int r108 = (r104 + r107) * 31;
        boolean r109 = this.f94707e;
        ?? r110 = r109;
        if (r109 == false) goto L12;
        r110 = 1;
    L12:
        int r111 = (r108 + r110) * 31;
        ILiveMode r112 = this.f94708f;
        if (r112 == null) goto L15;
        int r113 = r112.hashCode();
    L16:
        int r114 = (r111 + r113) * 31;
        String r115 = this.f94709g;
        if (r115 == null) goto L19;
        int r116 = r115.hashCode();
    L20:
        int r117 = (r114 + r116) * 31;
        k31.f r118 = this.f94710h;
        if (r118 == null) goto L23;
        int r119 = r118.hashCode();
    L24:
        int r120 = (r117 + r119) * 31;
        q r121 = this.f94711i;
        if (r121 == null) goto L27;
        int r122 = r121.hashCode();
    L28:
        int r123 = (r120 + r122) * 31;
        k r124 = this.f94712j;
        if (r124 == null) goto L31;
        int r125 = r124.hashCode();
    L32:
        int r126 = (r123 + r125) * 31;
        k31.a r127 = this.f94713k;
        if (r127 == null) goto L35;
        r106 = r127.hashCode();
    L35:
        int r128 = (r126 + r106) * 31;
        boolean r129 = this.f94714l;
        if (r129 == true) goto L40;
        r102 = r129;
    L40:
        return r128 + r102;
    L31:
        r125 = 0;
        goto L32
    L27:
        r122 = 0;
        goto L28
    L23:
        r119 = 0;
        goto L24
    L19:
        r116 = 0;
        goto L20
    L15:
        r113 = 0;
        goto L16
    L8:
        r107 = 0;
        goto L9
    }

    public final String toString() {
        return "StreamTransferParamValid(containerWidth=" + this.f94703a + ", containerHeight=" + this.f94704b + ", isFullScreen=" + this.f94705c + ", playerView=" + this.f94706d + ", isPortrait=" + this.f94707e + ", liveMode=" + this.f94708f + ", sei=" + this.f94709g + ", seiCache=" + this.f94710h + ", seiOptExtra=" + this.f94711i + ", statusBarOption=" + this.f94712j + ", componentsOption=" + this.f94713k + ", allowRotateScreen=" + this.f94714l + ")";
    }

    public d(int r100, int r101, boolean r102, AbsLivePlayerView r103, boolean r104, ILiveMode r105, String r106, k31.f r107, q r110, k r111, k31.a r112, boolean r113) {
        Intrinsics.checkNotNullParameter(r103, "playerView");
        Intrinsics.checkNotNullParameter(r105, "liveMode");
        Intrinsics.checkNotNullParameter(r111, "statusBarOption");
        this.f94703a = r100;
        this.f94704b = r101;
        this.f94705c = r102;
        this.f94706d = r103;
        this.f94707e = r104;
        this.f94708f = r105;
        this.f94709g = r106;
        this.f94710h = r107;
        this.f94711i = r110;
        this.f94712j = r111;
        this.f94713k = r112;
        this.f94714l = r113;
    }
}
