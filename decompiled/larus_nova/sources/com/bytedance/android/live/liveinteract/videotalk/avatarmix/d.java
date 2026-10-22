package com.bytedance.android.live.liveinteract.videotalk.avatarmix;

import com.ss.android.ugc.effectmanager.EffectConfiguration;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f79075a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final MicseatType f79076b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f79077c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ti6.f f79078d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ti6.f f79079e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f79080f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f79081g;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof d) == false) goto L20;
        d r101 = (d) r100;
        if (Intrinsics.areEqual(this.f79075a, r101.f79075a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f79076b, r101.f79076b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f79077c, r101.f79077c) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f79078d, r101.f79078d) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.f79079e, r101.f79079e) == true) goto L16;
        return false;
    L16:
        if (this.f79080f == r101.f79080f) goto L18;
        return false;
    L18:
        if (this.f79081g == r101.f79081g) goto L31;
        return false;
    L31:
        return true;
    L20:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v14, types: [int] */
    /* JADX WARN: Type inference failed for: r1v4, types: [int] */
    /* JADX WARN: Type inference failed for: r1v5 */
    /* JADX WARN: Type inference failed for: r1v7 */
    public final int hashCode() {
        String r100 = this.f79075a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        MicseatType r104 = this.f79076b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.f79077c;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        ti6.f r110 = this.f79078d;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        ti6.f r113 = this.f79079e;
        if (r113 == null) goto L21;
        r101 = r113.hashCode();
    L21:
        int r114 = (((r112 + r101) * 31) + this.f79080f) * 31;
        boolean r115 = this.f79081g;
        ?? r116 = r115;
        if (r115 == false) goto L25;
        r116 = 1;
    L25:
        return r114 + r116;
    L17:
        r111 = 0;
        goto L18
    L13:
        r108 = 0;
        goto L14
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "MicseatStruct(interactId='" + this.f79075a + "', type=" + this.f79076b + ", url='" + this.f79077c + "')";
    }

    public final MicseatType getType() {
        return this.f79076b;
    }

    public d(String r100, MicseatType r101, String r102, ti6.f r103, ti6.f r104, int r105) {
        Intrinsics.checkNotNullParameter(r100, "interactId");
        Intrinsics.checkNotNullParameter(r101, "type");
        Intrinsics.checkNotNullParameter(r102, "url");
        Intrinsics.checkNotNullParameter(r103, EffectConfiguration.KEY_REGION);
        Intrinsics.checkNotNullParameter(r104, "originRegion");
        this.f79075a = r100;
        this.f79076b = r101;
        this.f79077c = r102;
        this.f79078d = r103;
        this.f79079e = r104;
        this.f79080f = r105;
        this.f79081g = false;
    }
}
