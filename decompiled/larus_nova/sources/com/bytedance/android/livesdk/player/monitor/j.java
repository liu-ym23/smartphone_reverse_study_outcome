package com.bytedance.android.livesdk.player.monitor;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f155898a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f155899b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f155900c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f155901d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f155902e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f155903f;

    public static final class a {
    }

    static {
    }

    public final int hashCode() {
        return this.f155898a.hashCode();
    }

    public j() {
        this.f155898a = "";
        this.f155900c = "normal";
    }

    public final String getType() {
        return this.f155900c;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if (r100 == null) goto L8;
        Class<?> r101 = r100.getClass();
    L10:
        if ((!Intrinsics.areEqual(j.class, r101)) == false) goto L12;
        return false;
    L12:
        if (r100 == null) goto L18;
        if ((!Intrinsics.areEqual(this.f155898a, ((j) r100).f155898a)) == false) goto L16;
        return false;
    L16:
        return true;
    L18:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.player.monitor.PlayerExecuteCostInfo");
    L8:
        r101 = null;
        goto L10
    }
}
