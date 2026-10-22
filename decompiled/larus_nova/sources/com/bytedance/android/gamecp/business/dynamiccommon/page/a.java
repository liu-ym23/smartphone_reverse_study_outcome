package com.bytedance.android.gamecp.business.dynamiccommon.page;

import com.bytedance.ies.sve_core.s;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class a<T> implements s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f53136a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f53137b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f53138c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final T f53139d;

    public a() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof a) == false) goto L14;
        a r101 = (a) r100;
        if (this.f53136a == r101.f53136a) goto L8;
        return false;
    L8:
        if (this.f53137b == r101.f53137b) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f53138c, r101.f53138c) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f53139d, r101.f53139d) == true) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r0v9 */
    public final int hashCode() {
        boolean r100 = this.f53136a;
        ?? r101 = r100;
        if (r100 == false) goto L5;
        r101 = 1;
    L5:
        int r102 = ((r101 * 31) + this.f53137b) * 31;
        String r103 = this.f53138c;
        int r104 = 0;
        if (r103 == null) goto L8;
        int r105 = r103.hashCode();
    L9:
        int r106 = (r102 + r105) * 31;
        T r107 = this.f53139d;
        if (r107 == null) goto L13;
        r104 = r107.hashCode();
    L13:
        return r106 + r104;
    L8:
        r105 = 0;
        goto L9
    }

    public final String toString() {
        return "CommonPageState(loading=" + this.f53136a + ", errorCode=" + this.f53137b + ", errorMessage=" + this.f53138c + ", data=" + this.f53139d + ")";
    }

    public /* synthetic */ a(int r100) {
        this(true, 200, null, null);
    }

    public a(boolean r100, int r101, String r102, T r103) {
        this.f53136a = r100;
        this.f53137b = r101;
        this.f53138c = r102;
        this.f53139d = r103;
    }

    public static a c(a r100, boolean r101, int r102, String r103, Object r104, int r105) {
        if ((r105 & 1) == 0) goto L6;
        r101 = r100.f53136a;
    L6:
        if ((r105 & 2) == 0) goto L9;
        r102 = r100.f53137b;
    L9:
        if ((r105 & 4) == 0) goto L12;
        r103 = r100.f53138c;
    L12:
        if ((r105 & 8) == 0) goto L14;
        r104 = r100.f53139d;
    L14:
        r100.getClass();
        return new a(r101, r102, r103, r104);
    }
}
