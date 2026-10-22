package com.bytedance.android.live.revlink.impl.control.dialog;

import com.lynx.tasm.LynxError;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f92386a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f92387b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Throwable f92388c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f92389d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f92390e;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof f) == false) goto L16;
        f r101 = (f) r100;
        if (this.f92386a == r101.f92386a) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f92387b, r101.f92387b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f92388c, r101.f92388c) == true) goto L12;
        return false;
    L12:
        if (this.f92389d == r101.f92389d) goto L14;
        return false;
    L14:
        if (this.f92390e == r101.f92390e) goto L25;
        return false;
    L25:
        return true;
    L16:
        return false;
    }

    public final int hashCode() {
        int r100 = this.f92386a * 31;
        String r101 = this.f92387b;
        int r102 = 0;
        if (r101 == null) goto L5;
        int r103 = r101.hashCode();
    L6:
        int r104 = (r100 + r103) * 31;
        Throwable r105 = this.f92388c;
        if (r105 == null) goto L9;
        r102 = r105.hashCode();
    L9:
        long r106 = this.f92389d;
        int r107 = (((r104 + r102) * 31) + ((int) (r106 ^ (r106 >>> 32)))) * 31;
        long r108 = this.f92390e;
        return r107 + ((int) (r108 ^ (r108 >>> 32)));
    L5:
        r103 = 0;
        goto L6
    }

    public final String toString() {
        return "RecommendFailCacheData(loadType=" + this.f92386a + ", activityId=" + this.f92387b + ", throwable=" + this.f92388c + ", startLoadingTs=" + this.f92389d + ", loadedTs=" + this.f92390e + ")";
    }

    public f(int r100, String r101, Throwable r102, long r103, long r104) {
        Intrinsics.checkNotNullParameter(r101, "activityId");
        Intrinsics.checkNotNullParameter(r102, LynxError.LYNX_THROWABLE);
        this.f92386a = r100;
        this.f92387b = r101;
        this.f92388c = r102;
        this.f92389d = r103;
        this.f92390e = r104;
    }
}
