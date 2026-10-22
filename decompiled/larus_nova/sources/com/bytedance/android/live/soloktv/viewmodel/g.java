package com.bytedance.android.live.soloktv.viewmodel;

import com.bytedance.android.live.ktv.common.model.bean.h;
import com.ss.bytedance.ies.videoclip.api.player.IPlayer;
import java.util.List;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f101908a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f101909b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f101910c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final float f101911d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f101912e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final IPlayer.PlayerStatus f101913f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f101914g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Pair<h, Boolean> f101915h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final List<h> f101916i;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof g) == false) goto L24;
        g r101 = (g) r100;
        if (this.f101908a == r101.f101908a) goto L8;
        return false;
    L8:
        if (this.f101909b == r101.f101909b) goto L10;
        return false;
    L10:
        if (this.f101910c == r101.f101910c) goto L12;
        return false;
    L12:
        if (Float.compare(this.f101911d, r101.f101911d) == 0) goto L14;
        return false;
    L14:
        if (this.f101912e == r101.f101912e) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.f101913f, r101.f101913f) == true) goto L18;
        return false;
    L18:
        if (this.f101914g == r101.f101914g) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.f101915h, r101.f101915h) == true) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.f101916i, r101.f101916i) == true) goto L37;
        return false;
    L37:
        return true;
    L24:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v12, types: [int] */
    /* JADX WARN: Type inference failed for: r1v10, types: [int] */
    /* JADX WARN: Type inference failed for: r1v16 */
    /* JADX WARN: Type inference failed for: r1v18 */
    public final int hashCode() {
        int r100 = ((((((this.f101908a * 31) + this.f101909b) * 31) + this.f101910c) * 31) + Float.floatToIntBits(this.f101911d)) * 31;
        long r101 = this.f101912e;
        int r102 = (r100 + ((int) (r101 ^ (r101 >>> 32)))) * 31;
        IPlayer.PlayerStatus r103 = this.f101913f;
        int r104 = 0;
        if (r103 == null) goto L5;
        int r105 = r103.hashCode();
    L6:
        int r106 = (r102 + r105) * 31;
        boolean r107 = this.f101914g;
        ?? r108 = r107;
        if (r107 == false) goto L9;
        r108 = 1;
    L9:
        int r109 = (r106 + r108) * 31;
        Pair<h, Boolean> r110 = this.f101915h;
        if (r110 == null) goto L12;
        int r111 = r110.hashCode();
    L13:
        int r112 = (r109 + r111) * 31;
        List<h> r113 = this.f101916i;
        if (r113 == null) goto L17;
        r104 = r113.hashCode();
    L17:
        return r112 + r104;
    L12:
        r111 = 0;
        goto L13
    L5:
        r105 = 0;
        goto L6
    }

    public final String toString() {
        return "SoloKtvEditUIState(voiceVolume=" + this.f101908a + ", musicVolume=" + this.f101909b + ", voiceAlign=" + this.f101910c + ", playProgress=" + this.f101911d + ", playTime=" + this.f101912e + ", playStatus=" + this.f101913f + ", loadingTuningEffects=" + this.f101914g + ", selectedTuningEffect=" + this.f101915h + ", tuningEffectList=" + this.f101916i + ")";
    }

    public g(int r100, int r101, int r102, float r103, long r104, IPlayer.PlayerStatus r105, boolean r106, Pair<h, Boolean> r107, List<h> r110) {
        this.f101908a = r100;
        this.f101909b = r101;
        this.f101910c = r102;
        this.f101911d = r103;
        this.f101912e = r104;
        this.f101913f = r105;
        this.f101914g = r106;
        this.f101915h = r107;
        this.f101916i = r110;
    }

    public static g a(g r110, int r111, int r112, int r113, float r114, long r115, IPlayer.PlayerStatus r116, Pair r117, List r210, int r211) {
        if ((r211 & 1) == 0) goto L5;
        int r100 = r110.f101908a;
    L7:
        if ((r211 & 2) == 0) goto L9;
        int r101 = r110.f101909b;
    L11:
        if ((r211 & 4) == 0) goto L13;
        int r102 = r110.f101910c;
    L15:
        if ((r211 & 8) == 0) goto L17;
        float r103 = r110.f101911d;
    L19:
        if ((r211 & 16) == 0) goto L21;
        long r104 = r110.f101912e;
    L23:
        if ((r211 & 32) == 0) goto L25;
        IPlayer.PlayerStatus r105 = r110.f101913f;
    L27:
        if ((r211 & 64) == 0) goto L29;
        boolean r106 = r110.f101914g;
    L31:
        if ((r211 & 128) == 0) goto L33;
        Pair r118 = r110.f101915h;
    L35:
        if ((r211 & 256) == 0) goto L37;
        List r107 = r110.f101916i;
    L38:
        r110.getClass();
        return new g(r100, r101, r102, r103, r104, r105, r106, r118, r107);
    L37:
        r107 = r210;
        goto L38
    L33:
        r118 = r117;
        goto L35
    L29:
        r106 = false;
        goto L31
    L25:
        r105 = r116;
        goto L27
    L21:
        r104 = r115;
        goto L23
    L17:
        r103 = r114;
        goto L19
    L13:
        r102 = r113;
        goto L15
    L9:
        r101 = r112;
        goto L11
    L5:
        r100 = r111;
        goto L7
    }
}
