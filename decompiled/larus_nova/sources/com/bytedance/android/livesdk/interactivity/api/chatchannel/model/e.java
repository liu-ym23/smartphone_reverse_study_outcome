package com.bytedance.android.livesdk.interactivity.api.chatchannel.model;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f132928a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f132929b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f132930c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f132931d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f132932e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f132933f;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof e) == false) goto L18;
        e r101 = (e) r100;
        if (Intrinsics.areEqual(this.f132928a, r101.f132928a) == true) goto L8;
        return false;
    L8:
        if (this.f132929b == r101.f132929b) goto L10;
        return false;
    L10:
        if (this.f132930c == r101.f132930c) goto L12;
        return false;
    L12:
        if (this.f132931d == r101.f132931d) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.f132932e, r101.f132932e) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.f132933f, r101.f132933f) == true) goto L28;
        return false;
    L28:
        return true;
    L18:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v4, types: [int] */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v10 */
    /* JADX WARN: Type inference failed for: r2v9 */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1, types: [int] */
    /* JADX WARN: Type inference failed for: r3v2 */
    public final int hashCode() {
        String r100 = this.f132928a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        boolean r104 = this.f132929b;
        ?? r105 = 1;
        ?? r106 = r104;
        if (r104 == false) goto L9;
        r106 = 1;
    L9:
        int r107 = (r103 + r106) * 31;
        boolean r108 = this.f132930c;
        if (r108 == true) goto L13;
        r105 = r108;
    L13:
        int r109 = (((r107 + r105) * 31) + this.f132931d) * 31;
        String r110 = this.f132932e;
        if (r110 == null) goto L16;
        int r111 = r110.hashCode();
    L17:
        int r112 = (r109 + r111) * 31;
        String r113 = this.f132933f;
        if (r113 == null) goto L21;
        r101 = r113.hashCode();
    L21:
        return r112 + r101;
    L16:
        r111 = 0;
        goto L17
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "CreateChannelLogInfo(enterFrom=" + this.f132928a + ", isGroup=" + this.f132929b + ", isRepeat=" + this.f132930c + ", number=" + this.f132931d + ", friendList=" + this.f132932e + ", groupList=" + this.f132933f + ")";
    }

    public /* synthetic */ e(String r100) {
        this(r100, false, false, 0, null, null);
    }

    public e(String r100, boolean r101, boolean r102, int r103, String r104, String r105) {
        this.f132928a = r100;
        this.f132929b = r101;
        this.f132930c = r102;
        this.f132931d = r103;
        this.f132932e = r104;
        this.f132933f = r105;
    }
}
