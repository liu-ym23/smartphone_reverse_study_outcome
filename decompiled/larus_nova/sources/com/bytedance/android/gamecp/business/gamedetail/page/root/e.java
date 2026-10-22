package com.bytedance.android.gamecp.business.gamedetail.page.root;

import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes44.dex */
public final class e implements com.bytedance.ies.sve_core.s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final JSONObject f55485a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f55486b;

    public static final class a {
    }

    static {
    }

    public /* synthetic */ e() {
        this(null, null);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof e) == false) goto L10;
        e r101 = (e) r100;
        if (Intrinsics.areEqual(this.f55485a, r101.f55485a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f55486b, r101.f55486b) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        JSONObject r100 = this.f55485a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.f55486b;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        return r103 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "AudienceGameDetailNextPageDataState(nextPageData=" + this.f55485a + ", errorMsg=" + this.f55486b + ")";
    }

    public e(JSONObject r100, String r101) {
        this.f55485a = r100;
        this.f55486b = r101;
    }
}
