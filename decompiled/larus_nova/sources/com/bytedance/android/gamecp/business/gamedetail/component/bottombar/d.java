package com.bytedance.android.gamecp.business.gamedetail.component.bottombar;

import com.bytedance.ies.sve_core.p;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes44.dex */
public final class d implements p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f53845a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f53846b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final JSONObject f53847c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f53848d;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof d) == false) goto L14;
        d r101 = (d) r100;
        if (this.f53845a == r101.f53845a) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f53846b, r101.f53846b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f53847c, r101.f53847c) == true) goto L12;
        return false;
    L12:
        if (this.f53848d == r101.f53848d) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v7, types: [int] */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r0v9 */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v2 */
    public final int hashCode() {
        boolean r100 = this.f53845a;
        ?? r101 = 1;
        ?? r102 = r100;
        if (r100 == false) goto L5;
        r102 = 1;
    L5:
        int r103 = r102 * 31;
        String r104 = this.f53846b;
        int r105 = 0;
        if (r104 == null) goto L8;
        int r106 = r104.hashCode();
    L9:
        int r107 = (r103 + r106) * 31;
        JSONObject r108 = this.f53847c;
        if (r108 == null) goto L12;
        r105 = r108.hashCode();
    L12:
        int r109 = (r107 + r105) * 31;
        boolean r110 = this.f53848d;
        if (r110 == true) goto L17;
        r101 = r110;
    L17:
        return r109 + r101;
    L8:
        r106 = 0;
        goto L9
    }

    public final String toString() {
        return "BottomContainerProps(enableShow=" + this.f53845a + ", barClazz=" + this.f53846b + ", barData=" + this.f53847c + ", display=" + this.f53848d + ")";
    }

    public d(boolean r100, String r101, JSONObject r102, boolean r103) {
        this.f53845a = r100;
        this.f53846b = r101;
        this.f53847c = r102;
        this.f53848d = r103;
    }
}
