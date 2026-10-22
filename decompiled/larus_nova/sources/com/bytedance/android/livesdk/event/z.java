package com.bytedance.android.livesdk.event;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class z implements j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ISendCommentEvent f123383a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f123384b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f123385c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof z) == false) goto L12;
        z r101 = (z) r100;
        if (Intrinsics.areEqual(this.f123383a, r101.f123383a) == true) goto L8;
        return false;
    L8:
        if (this.f123384b == r101.f123384b) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f123385c, r101.f123385c) == true) goto L19;
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
        ISendCommentEvent r100 = this.f123383a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        boolean r104 = this.f123384b;
        ?? r105 = r104;
        if (r104 == false) goto L9;
        r105 = 1;
    L9:
        int r106 = (r103 + r105) * 31;
        String r107 = this.f123385c;
        if (r107 == null) goto L13;
        r101 = r107.hashCode();
    L13:
        return r106 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "SendCommentResult(subject=" + this.f123383a + ", success=" + this.f123384b + ", extra=" + this.f123385c + ")";
    }

    public z(ISendCommentEvent r100, boolean r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, com.bytedance.android.ec.core.event.a.KEY_SUBJECT);
        this.f123383a = r100;
        this.f123384b = r101;
        this.f123385c = r102;
    }
}
