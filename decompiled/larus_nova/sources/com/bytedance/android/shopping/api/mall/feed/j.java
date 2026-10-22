package com.bytedance.android.shopping.api.mall.feed;

import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes13.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f170543a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f170544b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final JSONObject f170545c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof j) == false) goto L12;
        j r101 = (j) r100;
        if (Intrinsics.areEqual(this.f170543a, r101.f170543a) == true) goto L8;
        return false;
    L8:
        if (this.f170544b == r101.f170544b) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f170545c, r101.f170545c) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v4, types: [int] */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v3 */
    /* JADX WARN: Type inference failed for: r2v4 */
    public final int hashCode() {
        String r100 = this.f170543a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        boolean r104 = this.f170544b;
        ?? r105 = r104;
        if (r104 == false) goto L9;
        r105 = 1;
    L9:
        int r106 = (r103 + r105) * 31;
        JSONObject r107 = this.f170545c;
        if (r107 == null) goto L13;
        r101 = r107.hashCode();
    L13:
        return r106 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "MallSaasPrefetchParams(pageName=" + this.f170543a + ", generateReqId=" + this.f170544b + ", globalProps=" + this.f170545c + ")";
    }

    public j(String r100) {
        Intrinsics.checkNotNullParameter(r100, "pageName");
        this.f170543a = r100;
        this.f170544b = true;
        this.f170545c = null;
    }
}
