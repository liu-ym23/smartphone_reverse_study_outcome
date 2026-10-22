package com.bytedance.android.shopping.anchorv4.data;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class a1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f166419a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.bytedance.android.chunkstreamprediction.network.c f166420b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Long f166421c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof a1) == false) goto L12;
        a1 r101 = (a1) r100;
        if (Intrinsics.areEqual(this.f166419a, r101.f166419a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f166420b, r101.f166420b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f166421c, r101.f166421c) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        Object r100 = this.f166419a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        com.bytedance.android.chunkstreamprediction.network.c r104 = this.f166420b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        Long r107 = this.f166421c;
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
        return "PrefInfo(ttNetExtraInfo=" + this.f166419a + ", chunkReporter=" + this.f166420b + ", firstChunkRecvTimestamp=" + this.f166421c + ")";
    }

    public a1(Object r100, com.bytedance.android.chunkstreamprediction.network.c r101, Long r102) {
        this.f166419a = r100;
        this.f166420b = r101;
        this.f166421c = r102;
    }
}
