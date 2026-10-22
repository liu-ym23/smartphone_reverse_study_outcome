package com.bytedance.android.live.revlink.impl.pk.vm.pk;

import com.bytedance.android.livesdk.link.model.IBattleConfigSetting;
import com.bytedance.android.livesdk.link.model.v3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final IBattleConfigSetting f97267a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f97268b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f97269c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f97270d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final v3 f97271e;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof a) == false) goto L16;
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f97267a, r101.f97267a) == true) goto L8;
        return false;
    L8:
        if (this.f97268b == r101.f97268b) goto L10;
        return false;
    L10:
        if (this.f97269c == r101.f97269c) goto L12;
        return false;
    L12:
        if (this.f97270d == r101.f97270d) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.f97271e, r101.f97271e) == true) goto L25;
        return false;
    L25:
        return true;
    L16:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v6, types: [int] */
    /* JADX WARN: Type inference failed for: r2v3, types: [int] */
    /* JADX WARN: Type inference failed for: r2v7 */
    /* JADX WARN: Type inference failed for: r2v8 */
    public final int hashCode() {
        IBattleConfigSetting r100 = this.f97267a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        long r103 = this.f97268b;
        int r104 = ((r102 * 31) + ((int) (r103 ^ (r103 >>> 32)))) * 31;
        boolean r105 = this.f97269c;
        ?? r106 = r105;
        if (r105 == false) goto L9;
        r106 = 1;
    L9:
        int r107 = (r104 + r106) * 31;
        long r108 = this.f97270d;
        int r109 = (r107 + ((int) (r108 ^ (r108 >>> 32)))) * 31;
        v3 r110 = this.f97271e;
        if (r110 == null) goto L13;
        r101 = r110.hashCode();
    L13:
        return r109 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "BattleInviteParam(battleConfigSetting=" + this.f97267a + ", duration=" + this.f97268b + ", isOnceMore=" + this.f97269c + ", decideDuration=" + this.f97270d + ", clientAttachedInfo=" + this.f97271e + ")";
    }

    public a(IBattleConfigSetting r100, v3 r101) {
        long r102 = l51.a.j();
        Intrinsics.checkNotNullParameter(r100, "battleConfigSetting");
        this.f97267a = r100;
        this.f97268b = r102;
        this.f97269c = false;
        this.f97270d = 0;
        this.f97271e = r101;
    }
}
