package com.bytedance.android.live.liveinteract.voicechat.util;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f80878a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f80879b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f80880c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f80881d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f80882e;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof v) == false) goto L16;
        v r101 = (v) r100;
        if (this.f80878a == r101.f80878a) goto L8;
        return false;
    L8:
        if (this.f80879b == r101.f80879b) goto L10;
        return false;
    L10:
        if (this.f80880c == r101.f80880c) goto L12;
        return false;
    L12:
        if (this.f80881d == r101.f80881d) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.f80882e, r101.f80882e) == true) goto L25;
        return false;
    L25:
        return true;
    L16:
        return false;
    }

    public final int hashCode() {
        int r100 = ((((((this.f80878a * 31) + this.f80879b) * 31) + this.f80880c) * 31) + this.f80881d) * 31;
        String r101 = this.f80882e;
        if (r101 == null) goto L5;
        int r102 = r101.hashCode();
    L7:
        return r100 + r102;
    L5:
        r102 = 0;
        goto L7
    }

    public final String toString() {
        return "VoiceSceneSwitchConfirmDialogParam(fromSubScene=" + this.f80878a + ", toSubScene=" + this.f80879b + ", fromUILayout=" + this.f80880c + ", toUILayout=" + this.f80881d + ", reason=" + this.f80882e + ")";
    }

    public v(int r100, int r101, int r102, int r103, String r104) {
        Intrinsics.checkNotNullParameter(r104, "reason");
        this.f80878a = r100;
        this.f80879b = r101;
        this.f80880c = r102;
        this.f80881d = r103;
        this.f80882e = r104;
    }
}
