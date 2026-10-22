package com.bytedance.android.livesdk.ktvimpl.base.sei;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Long f143303a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f143304b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f143305c;

    public e() {
        this(null, null, "");
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof e) == false) goto L12;
        e r101 = (e) r100;
        if (Intrinsics.areEqual(this.f143303a, r101.f143303a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f143304b, r101.f143304b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f143305c, r101.f143305c) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        Long r100 = this.f143303a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        Object r104 = this.f143304b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.f143305c;
        if (r107 == null) goto L14;
        r101 = r107.hashCode();
    L14:
        return r106 + r101;
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "KtvLastSeiEvent(songId=" + this.f143303a + ", seiParseResult=" + this.f143304b + ", lastSeiEventSource=" + this.f143305c + ")";
    }

    public e(Long r100, Object r101, String r102) {
        this.f143303a = r100;
        this.f143304b = r101;
        this.f143305c = r102;
    }
}
