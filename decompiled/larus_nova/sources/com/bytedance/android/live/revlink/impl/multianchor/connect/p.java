package com.bytedance.android.live.revlink.impl.multianchor.connect;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f93207a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Long f93208b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof p) == false) goto L10;
        p r101 = (p) r100;
        if (this.f93207a == r101.f93207a) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f93208b, r101.f93208b) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        long r100 = this.f93207a;
        int r101 = ((int) (r100 ^ (r100 >>> 32))) * 31;
        Long r102 = this.f93208b;
        if (r102 == null) goto L5;
        int r103 = r102.hashCode();
    L7:
        return r101 + r103;
    L5:
        r103 = 0;
        goto L7
    }

    public final String toString() {
        return "SwitchChannelInfoVersion(version=" + this.f93207a + ", messageId=" + this.f93208b + ")";
    }

    public p(long r100, Long r101) {
        this.f93207a = r100;
        this.f93208b = r101;
    }
}
