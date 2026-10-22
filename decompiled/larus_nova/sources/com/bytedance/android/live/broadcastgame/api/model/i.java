package com.bytedance.android.live.broadcastgame.api.model;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f59353a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f59354b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f59355c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f59356d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f59357e;

    public final String toString() {
        return "{appId:" + this.f59353a + ", gameId:" + this.f59354b + ", gameName: " + this.f59355c + ", audienceEnable:" + this.f59356d + " scoreEnable:" + this.f59357e + '}';
    }

    public i(String r100, long r101, String r102, boolean r103, boolean r104) {
        Intrinsics.checkNotNullParameter(r100, "appId");
        Intrinsics.checkNotNullParameter(r102, "gameName");
        this.f59353a = r100;
        this.f59354b = r101;
        this.f59355c = r102;
        this.f59356d = r103;
        this.f59357e = r104;
    }
}
