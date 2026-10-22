package com.bytedance.android.livesdk.gift.model;

import com.bytedance.android.live.base.model.message.a5;
import com.bytedance.android.live.base.model.user.IBaseUser;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class t3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a5 f126419a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f126420b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f126421c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final IBaseUser f126422d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f126423e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Map<String, String> f126424f;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof t3) == false) goto L18;
        t3 r101 = (t3) r100;
        if (Intrinsics.areEqual(this.f126419a, r101.f126419a) == true) goto L8;
        return false;
    L8:
        if (this.f126420b == r101.f126420b) goto L10;
        return false;
    L10:
        if (this.f126421c == r101.f126421c) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f126422d, r101.f126422d) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.f126423e, r101.f126423e) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.f126424f, r101.f126424f) == true) goto L28;
        return false;
    L28:
        return true;
    L18:
        return false;
    }

    public final int hashCode() {
        a5 r100 = this.f126419a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = ((((r102 * 31) + this.f126420b) * 31) + this.f126421c) * 31;
        IBaseUser r104 = this.f126422d;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.f126423e;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        Map<String, String> r110 = this.f126424f;
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
        return "TextPrivilegeInfo(text=" + this.f126419a + ", width=" + this.f126420b + ", height=" + this.f126421c + ", user=" + this.f126422d + ", finishSelfSchema=" + this.f126423e + ", trackingMap=" + this.f126424f + ")";
    }

    public t3(a5 r100, int r101, int r102, IBaseUser r103, String r104, Map<String, String> r105) {
        Intrinsics.checkNotNullParameter(r100, "text");
        Intrinsics.checkNotNullParameter(r103, "user");
        Intrinsics.checkNotNullParameter(r104, "finishSelfSchema");
        Intrinsics.checkNotNullParameter(r105, "trackingMap");
        this.f126419a = r100;
        this.f126420b = r101;
        this.f126421c = r102;
        this.f126422d = r103;
        this.f126423e = r104;
        this.f126424f = r105;
    }
}
