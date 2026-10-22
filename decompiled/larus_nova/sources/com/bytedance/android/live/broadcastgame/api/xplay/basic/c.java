package com.bytedance.android.live.broadcastgame.api.xplay.basic;

import android.content.Context;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f59445a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f59446b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f59447c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f59448d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f59449e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final e f59450f;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof c) == false) goto L18;
        c r101 = (c) r100;
        if (Intrinsics.areEqual(this.f59445a, r101.f59445a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f59446b, r101.f59446b) == true) goto L10;
        return false;
    L10:
        if (this.f59447c == r101.f59447c) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f59448d, r101.f59448d) == true) goto L14;
        return false;
    L14:
        if (this.f59449e == r101.f59449e) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.f59450f, r101.f59450f) == true) goto L28;
        return false;
    L28:
        return true;
    L18:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v6, types: [int] */
    /* JADX WARN: Type inference failed for: r2v11 */
    /* JADX WARN: Type inference failed for: r2v13 */
    /* JADX WARN: Type inference failed for: r2v4, types: [int] */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1, types: [int] */
    /* JADX WARN: Type inference failed for: r3v2 */
    public final int hashCode() {
        Context r100 = this.f59445a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.f59446b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        boolean r107 = this.f59447c;
        ?? r108 = 1;
        ?? r109 = r107;
        if (r107 == false) goto L13;
        r109 = 1;
    L13:
        int r110 = (r106 + r109) * 31;
        String r111 = this.f59448d;
        if (r111 == null) goto L16;
        int r112 = r111.hashCode();
    L17:
        int r113 = (r110 + r112) * 31;
        boolean r114 = this.f59449e;
        if (r114 == true) goto L21;
        r108 = r114;
    L21:
        int r115 = (r113 + r108) * 31;
        e r116 = this.f59450f;
        if (r116 == null) goto L25;
        r101 = r116.hashCode();
    L25:
        return r115 + r101;
    L16:
        r112 = 0;
        goto L17
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "XplayBasicEnv(context=" + this.f59445a + ", roomOwnerUserId=" + this.f59446b + ", isAnchor=" + this.f59447c + ", userId=" + this.f59448d + ", isSilent=" + this.f59449e + ", startParams=" + this.f59450f + ")";
    }

    public final Context getContext() {
        return this.f59445a;
    }

    public c(Context r100, String r101, boolean r102, String r103, e r104) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "roomOwnerUserId");
        Intrinsics.checkNotNullParameter(r103, "userId");
        Intrinsics.checkNotNullParameter(r104, "startParams");
        this.f59445a = r100;
        this.f59446b = r101;
        this.f59447c = r102;
        this.f59448d = r103;
        this.f59449e = true;
        this.f59450f = r104;
    }
}
