package com.bytedance.android.live.ktv.common.speech;

import com.bytedance.android.livesdk.message.model.MusicInterval;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f70453a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f70454b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f70455c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final double f70456d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f70457e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f70458f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final long f70459g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f70460h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final int f70461i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final String f70462j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final String f70463k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final List<MusicInterval> f70464l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final String f70465m;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof k) == false) goto L32;
        k r101 = (k) r100;
        if (this.f70453a == r101.f70453a) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f70454b, r101.f70454b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f70455c, r101.f70455c) == true) goto L12;
        return false;
    L12:
        if (Double.compare(this.f70456d, r101.f70456d) == 0) goto L14;
        return false;
    L14:
        if (this.f70457e == r101.f70457e) goto L16;
        return false;
    L16:
        if (this.f70458f == r101.f70458f) goto L18;
        return false;
    L18:
        if (this.f70459g == r101.f70459g) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.f70460h, r101.f70460h) == true) goto L22;
        return false;
    L22:
        if (this.f70461i == r101.f70461i) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f70462j, r101.f70462j) == true) goto L26;
        return false;
    L26:
        if (Intrinsics.areEqual(this.f70463k, r101.f70463k) == true) goto L28;
        return false;
    L28:
        if (Intrinsics.areEqual(this.f70464l, r101.f70464l) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f70465m, r101.f70465m) == true) goto L49;
        return false;
    L49:
        return true;
    L32:
        return false;
    }

    public final int hashCode() {
        int r100 = this.f70453a * 31;
        String r101 = this.f70454b;
        int r102 = 0;
        if (r101 == null) goto L5;
        int r103 = r101.hashCode();
    L6:
        int r104 = (r100 + r103) * 31;
        String r105 = this.f70455c;
        if (r105 == null) goto L9;
        int r106 = r105.hashCode();
    L10:
        long r107 = Double.doubleToLongBits(this.f70456d);
        int r108 = (((((((r104 + r106) * 31) + ((int) (r107 ^ (r107 >>> 32)))) * 31) + this.f70457e) * 31) + this.f70458f) * 31;
        long r109 = this.f70459g;
        int r110 = (r108 + ((int) (r109 ^ (r109 >>> 32)))) * 31;
        String r111 = this.f70460h;
        if (r111 == null) goto L13;
        int r112 = r111.hashCode();
    L14:
        int r113 = (((r110 + r112) * 31) + this.f70461i) * 31;
        String r114 = this.f70462j;
        if (r114 == null) goto L17;
        int r115 = r114.hashCode();
    L18:
        int r116 = (r113 + r115) * 31;
        String r117 = this.f70463k;
        if (r117 == null) goto L21;
        int r118 = r117.hashCode();
    L22:
        int r119 = (r116 + r118) * 31;
        List<MusicInterval> r120 = this.f70464l;
        if (r120 == null) goto L25;
        int r121 = r120.hashCode();
    L26:
        int r122 = (r119 + r121) * 31;
        String r123 = this.f70465m;
        if (r123 == null) goto L30;
        r102 = r123.hashCode();
    L30:
        return r122 + r102;
    L25:
        r121 = 0;
        goto L26
    L21:
        r118 = 0;
        goto L22
    L17:
        r115 = 0;
        goto L18
    L13:
        r112 = 0;
        goto L14
    L9:
        r106 = 0;
        goto L10
    L5:
        r103 = 0;
        goto L6
    }

    public final String toString() {
        return "RecognitionResult(type=" + this.f70453a + ", songId=" + this.f70454b + ", songUrl=" + this.f70455c + ", matchEndTime=" + this.f70456d + ", songDuration=" + this.f70457e + ", similarity=" + this.f70458f + ", startTime=" + this.f70459g + ", songName=" + this.f70460h + ", lyricType=" + this.f70461i + ", artistName=" + this.f70462j + ", songEmoTag=" + this.f70463k + ", musicClimax=" + this.f70464l + ", fontInfo=" + this.f70465m + ")";
    }

    public final int getType() {
        return this.f70453a;
    }

    public k(int r100, String r101, String r102, double r110, int r111, int r112, long r113, String r114, int r115, String r116, String r117, List<MusicInterval> r210, String r211) {
        Intrinsics.checkNotNullParameter(r101, "songId");
        Intrinsics.checkNotNullParameter(r102, "songUrl");
        Intrinsics.checkNotNullParameter(r114, "songName");
        Intrinsics.checkNotNullParameter(r116, "artistName");
        this.f70453a = r100;
        this.f70454b = r101;
        this.f70455c = r102;
        this.f70456d = r110;
        this.f70457e = r111;
        this.f70458f = r112;
        this.f70459g = r113;
        this.f70460h = r114;
        this.f70461i = r115;
        this.f70462j = r116;
        this.f70463k = r117;
        this.f70464l = r210;
        this.f70465m = r211;
    }
}
