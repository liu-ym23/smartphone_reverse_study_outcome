package com.bytedance.android.ec.hybrid.card.api;

import com.bytedance.android.ec.hybrid.card.bridge.ECBridgeMethodFinder;
import com.bytedance.android.ec.hybrid.card.impl.j;
import com.bytedance.android.ec.hybrid.card.util.k;
import com.ss.android.lark.openplatform.common.constant.AppbrandHostConstants;
import kotlin.jvm.internal.Intrinsics;
import zz6.IKitView;

/* JADX INFO: loaded from: classes44.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final IKitView f46363a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final j f46364b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final b07.a f46365c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final com.bytedance.lynx.service.model.a f46366d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final xj.a f46367e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final ECBridgeMethodFinder f46368f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f46369g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f46370h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final int f46371i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final String f46372j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final String f46373k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final int f46374l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final String f46375m;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof a) == false) goto L34;
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f46363a, r101.f46363a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f46364b, r101.f46364b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f46365c, r101.f46365c) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f46366d, r101.f46366d) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.f46367e, r101.f46367e) == false) goto L42;
        r101.getClass();
        if (Intrinsics.areEqual(null, null) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f46368f, r101.f46368f) == true) goto L20;
        return false;
    L20:
        if (this.f46369g == r101.f46369g) goto L22;
        return false;
    L22:
        if (this.f46370h == r101.f46370h) goto L24;
        return false;
    L24:
        if (this.f46371i == r101.f46371i) goto L26;
        return false;
    L26:
        if (Intrinsics.areEqual(this.f46372j, r101.f46372j) == true) goto L28;
        return false;
    L28:
        if (Intrinsics.areEqual(this.f46373k, r101.f46373k) == true) goto L30;
        return false;
    L30:
        if (this.f46374l == r101.f46374l) goto L32;
        return false;
    L32:
        if (Intrinsics.areEqual(this.f46375m, r101.f46375m) == true) goto L52;
        return false;
    L52:
        return true;
    L42:
        return false;
    L34:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v16, types: [int] */
    /* JADX WARN: Type inference failed for: r2v16, types: [int] */
    /* JADX WARN: Type inference failed for: r2v29 */
    /* JADX WARN: Type inference failed for: r2v35 */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1, types: [int] */
    /* JADX WARN: Type inference failed for: r3v2 */
    public final int hashCode() {
        IKitView r100 = this.f46363a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        j r104 = this.f46364b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        b07.a r107 = this.f46365c;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        com.bytedance.lynx.service.model.a r110 = this.f46366d;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        xj.a r113 = this.f46367e;
        if (r113 == null) goto L21;
        int r114 = r113.hashCode();
    L22:
        int r115 = (((r112 + r114) * 31) + 0) * 31;
        ECBridgeMethodFinder r116 = this.f46368f;
        if (r116 == null) goto L25;
        int r117 = r116.hashCode();
    L26:
        int r118 = (r115 + r117) * 31;
        boolean r119 = this.f46369g;
        ?? r120 = 1;
        ?? r121 = r119;
        if (r119 == false) goto L29;
        r121 = 1;
    L29:
        int r122 = (r118 + r121) * 31;
        boolean r123 = this.f46370h;
        if (r123 == true) goto L33;
        r120 = r123;
    L33:
        int r124 = (((r122 + r120) * 31) + this.f46371i) * 31;
        String r125 = this.f46372j;
        if (r125 == null) goto L36;
        int r126 = r125.hashCode();
    L37:
        int r127 = (r124 + r126) * 31;
        String r128 = this.f46373k;
        if (r128 == null) goto L40;
        int r129 = r128.hashCode();
    L41:
        int r130 = (((r127 + r129) * 31) + this.f46374l) * 31;
        String r131 = this.f46375m;
        if (r131 == null) goto L45;
        r101 = r131.hashCode();
    L45:
        return r130 + r101;
    L40:
        r129 = 0;
        goto L41
    L36:
        r126 = 0;
        goto L37
    L25:
        r117 = 0;
        goto L26
    L21:
        r114 = 0;
        goto L22
    L17:
        r111 = 0;
        goto L18
    L13:
        r108 = 0;
        goto L14
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "ECKitViewCacheParams(kitView=" + this.f46363a + ", hybridKitLifeCycle=" + this.f46364b + ", hybridContext=" + this.f46365c + ", kitInitParam=" + this.f46366d + ", session=" + this.f46367e + ", perfSession=null, jsbFinder=" + this.f46368f + ", enableJSRuntime=" + this.f46369g + ", enableStrictMode=" + this.f46370h + ", lynxThreadStrategy=" + this.f46371i + ", alreadySetData=" + this.f46372j + ", loadSchema=" + this.f46373k + ", itemType=" + this.f46374l + ", sceneId=" + this.f46375m + ")";
    }

    public a(IKitView r100, j r101, b07.a r102, com.bytedance.lynx.service.model.a r103, xj.a r104, k r105, ECBridgeMethodFinder r106, boolean r107, boolean r108, int r110, String r111, String r112, int r113, String r114) {
        Intrinsics.checkNotNullParameter(r100, "kitView");
        Intrinsics.checkNotNullParameter(r101, "hybridKitLifeCycle");
        Intrinsics.checkNotNullParameter(r102, "hybridContext");
        Intrinsics.checkNotNullParameter(r103, "kitInitParam");
        Intrinsics.checkNotNullParameter(r104, AppbrandHostConstants.SCHEMA_INSPECT.SESSION);
        Intrinsics.checkNotNullParameter(r106, "jsbFinder");
        Intrinsics.checkNotNullParameter(r111, "alreadySetData");
        Intrinsics.checkNotNullParameter(r112, "loadSchema");
        this.f46363a = r100;
        this.f46364b = r101;
        this.f46365c = r102;
        this.f46366d = r103;
        this.f46367e = r104;
        this.f46368f = r106;
        this.f46369g = r107;
        this.f46370h = r108;
        this.f46371i = r110;
        this.f46372j = r111;
        this.f46373k = r112;
        this.f46374l = r113;
        this.f46375m = r114;
    }
}
