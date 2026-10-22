package com.bytedance.android.live.broadcastgame.opengame.openapi;

import android.content.Context;
import com.bytedance.android.live.broadcastgame.opengame.runtime.LaunchMode;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class g0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f60471a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f60472b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Context f60473c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final LaunchMode f60474d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f60475e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f60476f;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof g0) == false) goto L18;
        g0 r101 = (g0) r100;
        if (Intrinsics.areEqual(this.f60471a, r101.f60471a) == true) goto L8;
        return false;
    L8:
        if (this.f60472b == r101.f60472b) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f60473c, r101.f60473c) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f60474d, r101.f60474d) == true) goto L14;
        return false;
    L14:
        if (this.f60475e == r101.f60475e) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.f60476f, r101.f60476f) == true) goto L28;
        return false;
    L28:
        return true;
    L18:
        return false;
    }

    public final int hashCode() {
        String r100 = this.f60471a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        long r103 = this.f60472b;
        int r104 = ((r102 * 31) + ((int) (r103 ^ (r103 >>> 32)))) * 31;
        Context r105 = this.f60473c;
        if (r105 == null) goto L9;
        int r106 = r105.hashCode();
    L10:
        int r107 = (r104 + r106) * 31;
        LaunchMode r108 = this.f60474d;
        if (r108 == null) goto L13;
        int r109 = r108.hashCode();
    L14:
        int r110 = (r107 + r109) * 31;
        long r111 = this.f60475e;
        int r112 = (r110 + ((int) (r111 ^ (r111 >>> 32)))) * 31;
        String r113 = this.f60476f;
        if (r113 == null) goto L18;
        r101 = r113.hashCode();
    L18:
        return r112 + r101;
    L13:
        r109 = 0;
        goto L14
    L9:
        r106 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "OpenApiParams(appId=" + this.f60471a + ", roomId=" + this.f60472b + ", context=" + this.f60473c + ", launchMode=" + this.f60474d + ", gameId=" + this.f60475e + ", appName=" + this.f60476f + ")";
    }

    public final Context getContext() {
        return this.f60473c;
    }

    public g0(String r100, long r101, Context r102, LaunchMode r103, long r104, String r105) {
        Intrinsics.checkNotNullParameter(r100, "appId");
        Intrinsics.checkNotNullParameter(r102, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r103, "launchMode");
        Intrinsics.checkNotNullParameter(r105, "appName");
        this.f60471a = r100;
        this.f60472b = r101;
        this.f60473c = r102;
        this.f60474d = r103;
        this.f60475e = r104;
        this.f60476f = r105;
    }
}
