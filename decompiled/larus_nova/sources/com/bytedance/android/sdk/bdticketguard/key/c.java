package com.bytedance.android.sdk.bdticketguard.key;

import com.bytedance.android.sdk.bdticketguard.l1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public l1 f163884a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final l1 f163885b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final l1 f163886c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Boolean f163887d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f163888e;

    public c() {
        this(null, null, 31);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L5;
    L21:
        return true;
    L5:
        if ((r100 instanceof c) == false) goto L20;
        c r101 = (c) r100;
        if (Intrinsics.areEqual(this.f163884a, r101.f163884a) == false) goto L20;
        if (Intrinsics.areEqual(this.f163885b, r101.f163885b) == false) goto L20;
        if (Intrinsics.areEqual(this.f163886c, r101.f163886c) == false) goto L20;
        if (Intrinsics.areEqual(this.f163887d, r101.f163887d) == false) goto L20;
        if (this.f163888e != r101.f163888e) goto L17;
        boolean r102 = true;
    L18:
        if (r102 == false) goto L20;
    L17:
        r102 = false;
    L20:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v10, types: [int] */
    /* JADX WARN: Type inference failed for: r1v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v6 */
    public final int hashCode() {
        l1 r100 = this.f163884a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        l1 r104 = this.f163885b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        l1 r107 = this.f163886c;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        Boolean r110 = this.f163887d;
        if (r110 == null) goto L17;
        r101 = r110.hashCode();
    L17:
        int r111 = (r109 + r101) * 31;
        boolean r112 = this.f163888e;
        ?? r113 = r112;
        if (r112 == false) goto L21;
        r113 = 1;
    L21:
        return r111 + r113;
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
        return "GetKeyResult(containsAliasResult=" + this.f163884a + ", createKeyResult=" + this.f163885b + ", loadKeyResult=" + this.f163886c + ", keyStoreContainsAlias=" + this.f163887d + ", spContainsAlias=" + this.f163888e + ")";
    }

    public c(l1 r100, l1 r101, int r102) {
        if ((r102 & 2) == 0) goto L6;
        r100 = null;
    L6:
        if ((r102 & 4) == 0) goto L8;
        r101 = null;
    L8:
        this.f163884a = null;
        this.f163885b = r100;
        this.f163886c = r101;
        this.f163887d = null;
        this.f163888e = false;
    }
}
