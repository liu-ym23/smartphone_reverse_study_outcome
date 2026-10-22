package com.bytedance.android.livesdk.ktvimpl.ktvroom.challenge.vm;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f144685a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f144686b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f144687c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f144688d;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof a) == false) goto L14;
        a r101 = (a) r100;
        if (this.f144685a == r101.f144685a) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f144686b, r101.f144686b) == true) goto L10;
        return false;
    L10:
        if (this.f144687c == r101.f144687c) goto L12;
        return false;
    L12:
        if (this.f144688d == r101.f144688d) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v6, types: [int] */
    /* JADX WARN: Type inference failed for: r1v5, types: [int] */
    /* JADX WARN: Type inference failed for: r1v6 */
    /* JADX WARN: Type inference failed for: r1v8 */
    public final int hashCode() {
        int r100 = this.f144685a * 31;
        String r101 = this.f144686b;
        if (r101 == null) goto L5;
        int r102 = r101.hashCode();
    L6:
        int r103 = (((r100 + r102) * 31) + this.f144687c) * 31;
        boolean r104 = this.f144688d;
        ?? r105 = r104;
        if (r104 == false) goto L10;
        r105 = 1;
    L10:
        return r103 + r105;
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "KtvChallengeSettingData(challengeType=" + this.f144685a + ", content=" + this.f144686b + ", settingType=" + this.f144687c + ", isCustom=" + this.f144688d + ")";
    }

    public a(int r100, String r101, int r102, boolean r103) {
        Intrinsics.checkNotNullParameter(r101, "content");
        this.f144685a = r100;
        this.f144686b = r101;
        this.f144687c = r102;
        this.f144688d = r103;
    }
}
