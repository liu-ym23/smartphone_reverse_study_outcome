package com.bytedance.android.live.broadcastgame.opengame.message;

import com.bytedance.android.livesdk.message.model.uh;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<uh> f60258a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f60259b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f60260c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f60261d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f60262e;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof n) == false) goto L16;
        n r101 = (n) r100;
        if (Intrinsics.areEqual(this.f60258a, r101.f60258a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f60259b, r101.f60259b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f60260c, r101.f60260c) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f60261d, r101.f60261d) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.f60262e, r101.f60262e) == true) goto L25;
        return false;
    L25:
        return true;
    L16:
        return false;
    }

    public final int hashCode() {
        List<uh> r100 = this.f60258a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.f60259b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.f60260c;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.f60261d;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.f60262e;
        if (r113 == null) goto L22;
        r101 = r113.hashCode();
    L22:
        return r112 + r101;
    L17:
        r111 = 0;
        goto L18
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
        return "Comment(toUsers=" + this.f60258a + ", secNickname=" + this.f60259b + ", secAvatarURL=" + this.f60260c + ", content=" + this.f60261d + ", timestamp=" + this.f60262e + ")";
    }

    public n(List<uh> r100, String r101, String r102, String r103, String r104) {
        Intrinsics.checkNotNullParameter(r100, "toUsers");
        Intrinsics.checkNotNullParameter(r101, "secNickname");
        Intrinsics.checkNotNullParameter(r102, "secAvatarURL");
        Intrinsics.checkNotNullParameter(r103, "content");
        Intrinsics.checkNotNullParameter(r104, "timestamp");
        this.f60258a = r100;
        this.f60259b = r101;
        this.f60260c = r102;
        this.f60261d = r103;
        this.f60262e = r104;
    }
}
