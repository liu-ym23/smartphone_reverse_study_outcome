package com.bytedance.android.gamecp.business.gamedetail.component.tab;

import com.bytedance.ies.sve_core.p;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes44.dex */
public final class a implements p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f55053a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f55054b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final JSONObject f55055c;

    public a() {
        this(7);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof a) == false) goto L12;
        a r101 = (a) r100;
        if (this.f55053a == r101.f55053a) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f55054b, r101.f55054b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f55055c, r101.f55055c) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7 */
    public final int hashCode() {
        boolean r100 = this.f55053a;
        ?? r101 = r100;
        if (r100 == false) goto L5;
        r101 = 1;
    L5:
        int r102 = r101 * 31;
        String r103 = this.f55054b;
        int r104 = 0;
        if (r103 == null) goto L8;
        int r105 = r103.hashCode();
    L9:
        int r106 = (r102 + r105) * 31;
        JSONObject r107 = this.f55055c;
        if (r107 == null) goto L13;
        r104 = r107.hashCode();
    L13:
        return r106 + r104;
    L8:
        r105 = 0;
        goto L9
    }

    public final String toString() {
        return "AudienceBottomBarProps(show=" + this.f55053a + ", barClazz=" + this.f55054b + ", barData=" + this.f55055c + ")";
    }

    public /* synthetic */ a(int r100) {
        this(false, null, null);
    }

    public a(boolean r100, String r101, JSONObject r102) {
        this.f55053a = r100;
        this.f55054b = r101;
        this.f55055c = r102;
    }
}
