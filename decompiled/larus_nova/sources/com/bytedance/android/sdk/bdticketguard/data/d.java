package com.bytedance.android.sdk.bdticketguard.data;

import com.bytedance.android.sdk.bdticketguard.l1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public f f163608a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public g f163609b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f163610c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Boolean f163611d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Boolean f163612e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public l1 f163613f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public l1 f163614g;

    public d() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L5;
    L25:
        return true;
    L5:
        if ((r100 instanceof d) == false) goto L24;
        d r101 = (d) r100;
        if (Intrinsics.areEqual(this.f163608a, r101.f163608a) == false) goto L24;
        if (Intrinsics.areEqual(this.f163609b, r101.f163609b) == false) goto L24;
        if (this.f163610c != r101.f163610c) goto L13;
        boolean r102 = true;
    L14:
        if (r102 == false) goto L24;
        if (Intrinsics.areEqual(this.f163611d, r101.f163611d) == false) goto L24;
        if (Intrinsics.areEqual(this.f163612e, r101.f163612e) == false) goto L24;
        if (Intrinsics.areEqual(this.f163613f, r101.f163613f) == false) goto L24;
        if (Intrinsics.areEqual(this.f163614g, r101.f163614g) == false) goto L24;
    L13:
        r102 = false;
    L24:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v6, types: [int] */
    /* JADX WARN: Type inference failed for: r2v18 */
    /* JADX WARN: Type inference failed for: r2v20 */
    /* JADX WARN: Type inference failed for: r2v4, types: [int] */
    public final int hashCode() {
        f r100 = this.f163608a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        g r104 = this.f163609b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        boolean r107 = this.f163610c;
        ?? r108 = r107;
        if (r107 == false) goto L13;
        r108 = 1;
    L13:
        int r109 = (r106 + r108) * 31;
        Boolean r110 = this.f163611d;
        if (r110 == null) goto L16;
        int r111 = r110.hashCode();
    L17:
        int r112 = (r109 + r111) * 31;
        Boolean r113 = this.f163612e;
        if (r113 == null) goto L20;
        int r114 = r113.hashCode();
    L21:
        int r115 = (r112 + r114) * 31;
        l1 r116 = this.f163613f;
        if (r116 == null) goto L24;
        int r117 = r116.hashCode();
    L25:
        int r118 = (r115 + r117) * 31;
        l1 r119 = this.f163614g;
        if (r119 == null) goto L29;
        r101 = r119.hashCode();
    L29:
        return r118 + r101;
    L24:
        r117 = 0;
        goto L25
    L20:
        r114 = 0;
        goto L21
    L16:
        r111 = 0;
        goto L17
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "TeeKeyExtras(keyGenData=" + this.f163608a + ", keyLoadData=" + this.f163609b + ", isLoadedWithNewProc=" + this.f163610c + ", spContainsAlias=" + this.f163611d + ", keyStoreContainsAlias=" + this.f163612e + ", containsAliasResult=" + this.f163613f + ", genKeyPairResult=" + this.f163614g + ")";
    }

    public d(int r100) {
        this.f163608a = null;
        this.f163609b = null;
        this.f163610c = false;
        this.f163611d = null;
        this.f163612e = null;
        this.f163613f = null;
        this.f163614g = null;
    }
}
