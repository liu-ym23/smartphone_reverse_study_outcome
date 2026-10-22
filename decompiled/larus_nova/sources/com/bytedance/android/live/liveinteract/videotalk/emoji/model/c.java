package com.bytedance.android.live.liveinteract.videotalk.emoji.model;

import com.bytedance.android.livesdk.gift.model.h2;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f79373a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f79374b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public List<String> f79375c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f79376d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f79377e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final long f79378f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f79379g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f79380h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final long f79381i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final String f79382j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final h2 f79383k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final String f79384l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final s f79385m;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof c) == false) goto L32;
        c r101 = (c) r100;
        if (Intrinsics.areEqual(this.f79373a, r101.f79373a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f79374b, r101.f79374b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f79375c, r101.f79375c) == true) goto L12;
        return false;
    L12:
        if (this.f79376d == r101.f79376d) goto L14;
        return false;
    L14:
        if (this.f79377e == r101.f79377e) goto L16;
        return false;
    L16:
        if (this.f79378f == r101.f79378f) goto L18;
        return false;
    L18:
        if (this.f79379g == r101.f79379g) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.f79380h, r101.f79380h) == true) goto L22;
        return false;
    L22:
        if (this.f79381i == r101.f79381i) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f79382j, r101.f79382j) == true) goto L26;
        return false;
    L26:
        if (Intrinsics.areEqual(this.f79383k, r101.f79383k) == true) goto L28;
        return false;
    L28:
        if (Intrinsics.areEqual(this.f79384l, r101.f79384l) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f79385m, r101.f79385m) == true) goto L49;
        return false;
    L49:
        return true;
    L32:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v10, types: [int] */
    /* JADX WARN: Type inference failed for: r2v31 */
    /* JADX WARN: Type inference failed for: r2v34 */
    /* JADX WARN: Type inference failed for: r2v8, types: [int] */
    public final int hashCode() {
        String r100 = this.f79373a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.f79374b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        List<String> r107 = this.f79375c;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (((r106 + r108) * 31) + this.f79376d) * 31;
        boolean r110 = this.f79377e;
        ?? r111 = r110;
        if (r110 == false) goto L17;
        r111 = 1;
    L17:
        int r112 = (r109 + r111) * 31;
        long r113 = this.f79378f;
        int r114 = (((r112 + ((int) (r113 ^ (r113 >>> 32)))) * 31) + this.f79379g) * 31;
        String r115 = this.f79380h;
        if (r115 == null) goto L20;
        int r116 = r115.hashCode();
    L21:
        int r117 = (r114 + r116) * 31;
        long r118 = this.f79381i;
        int r119 = (r117 + ((int) (r118 ^ (r118 >>> 32)))) * 31;
        String r120 = this.f79382j;
        if (r120 == null) goto L24;
        int r121 = r120.hashCode();
    L25:
        int r122 = (r119 + r121) * 31;
        h2 r123 = this.f79383k;
        if (r123 == null) goto L28;
        int r124 = r123.hashCode();
    L29:
        int r125 = (r122 + r124) * 31;
        String r126 = this.f79384l;
        if (r126 == null) goto L32;
        int r127 = r126.hashCode();
    L33:
        int r128 = (r125 + r127) * 31;
        s r129 = this.f79385m;
        if (r129 == null) goto L37;
        r101 = r129.hashCode();
    L37:
        return r128 + r101;
    L32:
        r127 = 0;
        goto L33
    L28:
        r124 = 0;
        goto L29
    L24:
        r121 = 0;
        goto L25
    L20:
        r116 = 0;
        goto L21
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
        return "id:" + this.f79373a + ",type:" + this.f79376d + ",isFirst:" + this.f79377e + ",micAnimIndex:" + this.f79379g + ",scriptRelPath:" + this.f79380h + ",duration:" + this.f79381i;
    }

    public c(String r100, String r101, List<String> r102, int r103, boolean r104, long r110, int r111, String r112, long r113, String r114, h2 r115, String r116, s r117) {
        Intrinsics.checkNotNullParameter(r100, "animationId");
        Intrinsics.checkNotNullParameter(r102, "receiverUids");
        this.f79373a = r100;
        this.f79374b = r101;
        this.f79375c = r102;
        this.f79376d = r103;
        this.f79377e = r104;
        this.f79378f = r110;
        this.f79379g = r111;
        this.f79380h = r112;
        this.f79381i = r113;
        this.f79382j = r114;
        this.f79383k = r115;
        this.f79384l = r116;
        this.f79385m = r117;
    }
}
