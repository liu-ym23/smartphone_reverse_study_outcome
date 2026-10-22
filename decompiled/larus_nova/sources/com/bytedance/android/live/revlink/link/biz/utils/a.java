package com.bytedance.android.live.revlink.link.biz.utils;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f98248a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f98249b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f98250c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f98251d;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof a) == false) goto L14;
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f98248a, r101.f98248a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f98249b, r101.f98249b) == true) goto L10;
        return false;
    L10:
        if (this.f98250c == r101.f98250c) goto L12;
        return false;
    L12:
        if (this.f98251d == r101.f98251d) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v6, types: [int] */
    /* JADX WARN: Type inference failed for: r1v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v6 */
    /* JADX WARN: Type inference failed for: r1v8 */
    public final int hashCode() {
        String r100 = this.f98248a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.f98249b;
        if (r104 == null) goto L9;
        r101 = r104.hashCode();
    L9:
        int r105 = (r103 + r101) * 31;
        boolean r106 = this.f98250c;
        ?? r107 = r106;
        if (r106 == false) goto L12;
        r107 = 1;
    L12:
        int r108 = (r105 + r107) * 31;
        long r109 = this.f98251d;
        return r108 + ((int) (r109 ^ (r109 >>> 32)));
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "BattleInviteBizData(titleStr=" + this.f98248a + ", inviteMode=" + this.f98249b + ", isOnceMore=" + this.f98250c + ", duration=" + this.f98251d + ")";
    }

    public a(String r100, String r101, boolean r102, long r103) {
        Intrinsics.checkNotNullParameter(r100, "titleStr");
        Intrinsics.checkNotNullParameter(r101, "inviteMode");
        this.f98248a = r100;
        this.f98249b = r101;
        this.f98250c = r102;
        this.f98251d = r103;
    }
}
