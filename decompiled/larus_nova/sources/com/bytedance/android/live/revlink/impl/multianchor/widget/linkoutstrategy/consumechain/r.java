package com.bytedance.android.live.revlink.impl.multianchor.widget.linkoutstrategy.consumechain;

import com.bytedance.android.livesdk.link.model.q5;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final d11.g f95234a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final q5 f95235b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f95236c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof r) == false) goto L12;
        r r101 = (r) r100;
        if (Intrinsics.areEqual(this.f95234a, r101.f95234a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f95235b, r101.f95235b) == true) goto L10;
        return false;
    L10:
        if (this.f95236c == r101.f95236c) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        d11.g r100 = this.f95234a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        q5 r104 = this.f95235b;
        if (r104 == null) goto L9;
        r101 = r104.hashCode();
    L9:
        int r105 = (r103 + r101) * 31;
        long r106 = this.f95236c;
        return r105 + ((int) (r106 ^ (r106 >>> 32)));
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "ReplySuccessEvent(params=" + this.f95234a + ", replyResult=" + this.f95235b + ", startTime=" + this.f95236c + ")";
    }

    public r(d11.g r100, q5 r101, long r102) {
        Intrinsics.checkNotNullParameter(r100, "params");
        Intrinsics.checkNotNullParameter(r101, "replyResult");
        this.f95234a = r100;
        this.f95235b = r101;
        this.f95236c = r102;
    }
}
