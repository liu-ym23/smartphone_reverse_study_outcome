package bl6;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes20.dex */
public final class d implements k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f19471a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f19472b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final float f19473c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f19474d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f19475e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f19476f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f19477g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f19478h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final int f19479i;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof d) == false) goto L24;
        d r101 = (d) r100;
        if (Float.compare(this.f19471a, r101.f19471a) == 0) goto L8;
        return false;
    L8:
        if (Float.compare(this.f19472b, r101.f19472b) == 0) goto L10;
        return false;
    L10:
        if (Float.compare(this.f19473c, r101.f19473c) == 0) goto L12;
        return false;
    L12:
        if (this.f19474d == r101.f19474d) goto L14;
        return false;
    L14:
        if (this.f19475e == r101.f19475e) goto L16;
        return false;
    L16:
        if (this.f19476f == r101.f19476f) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f19477g, r101.f19477g) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.f19478h, r101.f19478h) == true) goto L22;
        return false;
    L22:
        if (this.f19479i == r101.f19479i) goto L37;
        return false;
    L37:
        return true;
    L24:
        return false;
    }

    public final int hashCode() {
        int r100 = ((((((((((Float.floatToIntBits(this.f19471a) * 31) + Float.floatToIntBits(this.f19472b)) * 31) + Float.floatToIntBits(this.f19473c)) * 31) + this.f19474d) * 31) + this.f19475e) * 31) + this.f19476f) * 31;
        String r101 = this.f19477g;
        int r102 = 0;
        if (r101 == null) goto L5;
        int r103 = r101.hashCode();
    L6:
        int r104 = (r100 + r103) * 31;
        String r105 = this.f19478h;
        if (r105 == null) goto L10;
        r102 = r105.hashCode();
    L10:
        return ((r104 + r102) * 31) + this.f19479i;
    L5:
        r103 = 0;
        goto L6
    }

    public final String toString() {
        return "MidiHitSeiPayload(cur_tone=" + this.f19471a + ", standard_tone=" + this.f19472b + ", score=" + this.f19473c + ", sentence_index=" + this.f19474d + ", hit_type=" + this.f19475e + ", combo=" + this.f19476f + ", anchor_id=" + this.f19477g + ", sender_user_id=" + this.f19478h + ", forward=" + this.f19479i + ")";
    }

    public d(float r100, float r101, float r102, int r103, int r104, int r105, String r106) {
        this.f19471a = r100;
        this.f19472b = r101;
        this.f19473c = r102;
        this.f19474d = r103;
        this.f19475e = r104;
        this.f19476f = r105;
        this.f19477g = null;
        this.f19478h = r106;
        this.f19479i = 0;
    }
}
