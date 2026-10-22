package com.bytedance.android.live.liveinteract.voicechat.emoji.sound;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f80280a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f80281b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f80282c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof b) == false) goto L12;
        b r101 = (b) r100;
        if (Intrinsics.areEqual(this.f80280a, r101.f80280a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f80281b, r101.f80281b) == true) goto L10;
        return false;
    L10:
        if (this.f80282c == r101.f80282c) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        String r100 = this.f80280a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.f80281b;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        return ((r103 + r101) * 31) + this.f80282c;
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "EmojiSound(id=" + this.f80280a + ", url=" + this.f80281b + ", level=" + this.f80282c + ")";
    }

    public b(String r100, String r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "id");
        Intrinsics.checkNotNullParameter(r101, "url");
        this.f80280a = r100;
        this.f80281b = r101;
        this.f80282c = r102;
    }
}
