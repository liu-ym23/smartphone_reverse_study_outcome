package com.bytedance.android.live.broadcastgame.opengame.message;

import com.bytedance.android.livesdk.message.model.uh;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<uh> f60276a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f60277b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f60278c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f60279d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f60280e;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof t) == false) goto L16;
        t r101 = (t) r100;
        if (Intrinsics.areEqual(this.f60276a, r101.f60276a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f60277b, r101.f60277b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f60278c, r101.f60278c) == true) goto L12;
        return false;
    L12:
        if (this.f60279d == r101.f60279d) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.f60280e, r101.f60280e) == true) goto L25;
        return false;
    L25:
        return true;
    L16:
        return false;
    }

    public final int hashCode() {
        List<uh> r100 = this.f60276a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.f60277b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.f60278c;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (((r106 + r108) * 31) + this.f60279d) * 31;
        String r110 = this.f60280e;
        if (r110 == null) goto L18;
        r101 = r110.hashCode();
    L18:
        return r109 + r101;
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
        return "FollowAction(toUsers=" + this.f60276a + ", secNickname=" + this.f60277b + ", secAvatarURL=" + this.f60278c + ", action=" + this.f60279d + ", timestamp=" + this.f60280e + ")";
    }

    public t(List<uh> r100, String r101, String r102, int r103, String r104) {
        Intrinsics.checkNotNullParameter(r100, "toUsers");
        Intrinsics.checkNotNullParameter(r101, "secNickname");
        Intrinsics.checkNotNullParameter(r102, "secAvatarURL");
        Intrinsics.checkNotNullParameter(r104, "timestamp");
        this.f60276a = r100;
        this.f60277b = r101;
        this.f60278c = r102;
        this.f60279d = r103;
        this.f60280e = r104;
    }
}
