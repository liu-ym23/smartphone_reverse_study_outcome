package com.bytedance.android.shopping.mall.homepage.tools;

import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes13.dex */
public final class FavRefreshParams {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final /* synthetic */ int f178478f = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f178479a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<String, Object> f178480b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f178481c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final com.bytedance.android.shopping.mall.opt.g f178482d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Function1<com.bytedance.android.shopping.api.mall.c, Unit> f178483e;

    public static final class Companion {
        public static FavRefreshParams a(boolean r100, JSONObject r101, String r110, boolean r111, com.bytedance.android.shopping.mall.opt.g r112) {
            if (r101 != null) goto L7;
            if (r110 != null) goto L7;
            if (r100 == true) goto L7;
            LinkedHashMap r102 = null;
        L8:
            LinkedHashMap r103 = r102;
            if (r101 == null) goto L12;
            if (r103 == null) goto L12;
            r103.put("pitaya_actions", r101);
        L12:
            if (r110 == null) goto L15;
            if (r103 == null) goto L15;
            r103.put("revert_filters", r110);
        L15:
            if (r103 == null) goto L18;
            r103.put("skip_reset_params", Boolean.valueOf(r100));
        L18:
            return new FavRefreshParams(false, r103, r111, r112, FavRefreshParams$Companion$valueOf$3.INSTANCE, 1);
        L7:
            r102 = new LinkedHashMap();
            goto L8
        }
    }

    static {
    }

    public FavRefreshParams() {
        throw null;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof FavRefreshParams) == false) goto L16;
        FavRefreshParams r101 = (FavRefreshParams) r100;
        if (this.f178479a == r101.f178479a) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f178480b, r101.f178480b) == true) goto L10;
        return false;
    L10:
        if (this.f178481c == r101.f178481c) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f178482d, r101.f178482d) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.f178483e, r101.f178483e) == true) goto L25;
        return false;
    L25:
        return true;
    L16:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v10 */
    /* JADX WARN: Type inference failed for: r0v11 */
    /* JADX WARN: Type inference failed for: r0v5, types: [int] */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v7 */
    public final int hashCode() {
        boolean r100 = this.f178479a;
        ?? r101 = 1;
        ?? r102 = r100;
        if (r100 == false) goto L5;
        r102 = 1;
    L5:
        int r103 = r102 * 31;
        Map<String, Object> r104 = this.f178480b;
        int r105 = 0;
        if (r104 == null) goto L8;
        int r106 = r104.hashCode();
    L9:
        int r107 = (r103 + r106) * 31;
        boolean r108 = this.f178481c;
        if (r108 == true) goto L13;
        r101 = r108;
    L13:
        int r109 = (r107 + r101) * 31;
        com.bytedance.android.shopping.mall.opt.g r110 = this.f178482d;
        if (r110 == null) goto L16;
        int r111 = r110.hashCode();
    L17:
        int r112 = (r109 + r111) * 31;
        Function1<com.bytedance.android.shopping.api.mall.c, Unit> r113 = this.f178483e;
        if (r113 == null) goto L21;
        r105 = r113.hashCode();
    L21:
        return r112 + r105;
    L16:
        r111 = 0;
        goto L17
    L8:
        r106 = 0;
        goto L9
    }

    public final String toString() {
        return "FavRefreshParams(requestButRefresh=" + this.f178479a + ", insertParams=" + this.f178480b + ", allowTabNot0=" + this.f178481c + ", event=" + this.f178482d + ", requestResult=" + this.f178483e + ")";
    }

    public FavRefreshParams(boolean r100, Map r101, boolean r102, com.bytedance.android.shopping.mall.opt.g r103, Function1 r104, int r105) {
        if ((r105 & 1) == 0) goto L6;
        r100 = false;
    L6:
        if ((r105 & 2) == 0) goto L9;
        r101 = null;
    L9:
        if ((r105 & 4) == 0) goto L12;
        r102 = false;
    L12:
        if ((r105 & 8) == 0) goto L14;
        r103 = null;
    L14:
        Intrinsics.checkNotNullParameter(r104, "requestResult");
        this.f178479a = r100;
        this.f178480b = r101;
        this.f178481c = r102;
        this.f178482d = r103;
        this.f178483e = r104;
    }
}
