package com.bytedance.android.live.broadcastgame.opengame.runtime;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<com.bytedance.android.live.broadcastgame.opengame.network.a.C0989a> f60839a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<com.bytedance.android.live.broadcastgame.opengame.network.a.c> f60840b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f60841c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f60842d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final List<Integer> f60843e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f60844f;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof j) == false) goto L18;
        j r101 = (j) r100;
        if (Intrinsics.areEqual(this.f60839a, r101.f60839a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f60840b, r101.f60840b) == true) goto L10;
        return false;
    L10:
        if (this.f60841c == r101.f60841c) goto L12;
        return false;
    L12:
        if (this.f60842d == r101.f60842d) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.f60843e, r101.f60843e) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.f60844f, r101.f60844f) == true) goto L28;
        return false;
    L28:
        return true;
    L18:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v11 */
    /* JADX WARN: Type inference failed for: r2v13 */
    /* JADX WARN: Type inference failed for: r2v4, types: [int] */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1, types: [int] */
    /* JADX WARN: Type inference failed for: r3v2 */
    public final int hashCode() {
        List<com.bytedance.android.live.broadcastgame.opengame.network.a.C0989a> r100 = this.f60839a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        List<com.bytedance.android.live.broadcastgame.opengame.network.a.c> r104 = this.f60840b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        boolean r107 = this.f60841c;
        ?? r108 = 1;
        ?? r109 = r107;
        if (r107 == false) goto L13;
        r109 = 1;
    L13:
        int r110 = (r106 + r109) * 31;
        boolean r111 = this.f60842d;
        if (r111 == true) goto L17;
        r108 = r111;
    L17:
        int r112 = (r110 + r108) * 31;
        List<Integer> r113 = this.f60843e;
        if (r113 == null) goto L20;
        int r114 = r113.hashCode();
    L21:
        int r115 = (r112 + r114) * 31;
        String r116 = this.f60844f;
        if (r116 == null) goto L25;
        r101 = r116.hashCode();
    L25:
        return r115 + r101;
    L20:
        r114 = 0;
        goto L21
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "GameScopeInfo(info=" + this.f60839a + ", domainList=" + this.f60840b + ", disableInteractIm=" + this.f60841c + ", blockConsumeList=" + this.f60842d + ", supportLiveSceneList=" + this.f60843e + ", gameType=" + this.f60844f + ")";
    }

    public j(List<com.bytedance.android.live.broadcastgame.opengame.network.a.C0989a> r100, List<com.bytedance.android.live.broadcastgame.opengame.network.a.c> r101, boolean r102, boolean r103, List<Integer> r104, String r105) {
        Intrinsics.checkNotNullParameter(r100, "info");
        Intrinsics.checkNotNullParameter(r101, "domainList");
        Intrinsics.checkNotNullParameter(r105, "gameType");
        this.f60839a = r100;
        this.f60840b = r101;
        this.f60841c = r102;
        this.f60842d = r103;
        this.f60843e = r104;
        this.f60844f = r105;
    }
}
