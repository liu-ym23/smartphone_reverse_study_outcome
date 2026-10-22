package com.bytedance.android.live.liveinteract.digitavatar.videoavatar;

import com.bytedance.kmp.live.livelink.api.model.VideoShowMode;
import com.huawei.hms.push.constant.RemoteMessageConst;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final VideoShowMode f72712a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final VideoShowMode f72713b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f72714c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof d) == false) goto L12;
        d r101 = (d) r100;
        if (Intrinsics.areEqual(this.f72712a, r101.f72712a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f72713b, r101.f72713b) == true) goto L10;
        return false;
    L10:
        if (this.f72714c == r101.f72714c) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v6, types: [int] */
    /* JADX WARN: Type inference failed for: r1v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v6 */
    public final int hashCode() {
        VideoShowMode r100 = this.f72712a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        VideoShowMode r104 = this.f72713b;
        if (r104 == null) goto L9;
        r101 = r104.hashCode();
    L9:
        int r105 = (r103 + r101) * 31;
        boolean r106 = this.f72714c;
        ?? r107 = r106;
        if (r106 == false) goto L13;
        r107 = 1;
    L13:
        return r105 + r107;
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "SetVideoShowModeResult(from=" + this.f72712a + ", to=" + this.f72713b + ", isSuccess=" + this.f72714c + ")";
    }

    public d(VideoShowMode r100, VideoShowMode r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r100, "from");
        Intrinsics.checkNotNullParameter(r101, RemoteMessageConst.TO);
        this.f72712a = r100;
        this.f72713b = r101;
        this.f72714c = r102;
    }
}
