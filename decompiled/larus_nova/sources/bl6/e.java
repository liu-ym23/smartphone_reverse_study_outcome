package bl6;

import com.bytedance.livesdk.ktvcommon.midi.model.HitType;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes20.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f19480a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f19481b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final float f19482c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final float f19483d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final float f19484e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f19485f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final float f19486g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final HitType f19487h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final int f19488i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final boolean f19489j;

    public e() {
        this(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, 0.0f, null, 0, 1023);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof e) == false) goto L26;
        e r101 = (e) r100;
        if (Float.compare(this.f19480a, r101.f19480a) == 0) goto L8;
        return false;
    L8:
        if (Float.compare(this.f19481b, r101.f19481b) == 0) goto L10;
        return false;
    L10:
        if (Float.compare(this.f19482c, r101.f19482c) == 0) goto L12;
        return false;
    L12:
        if (Float.compare(this.f19483d, r101.f19483d) == 0) goto L14;
        return false;
    L14:
        if (Float.compare(this.f19484e, r101.f19484e) == 0) goto L16;
        return false;
    L16:
        if (this.f19485f == r101.f19485f) goto L18;
        return false;
    L18:
        if (Float.compare(this.f19486g, r101.f19486g) == 0) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.f19487h, r101.f19487h) == true) goto L22;
        return false;
    L22:
        if (this.f19488i == r101.f19488i) goto L24;
        return false;
    L24:
        if (this.f19489j == r101.f19489j) goto L40;
        return false;
    L40:
        return true;
    L26:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v19, types: [int] */
    /* JADX WARN: Type inference failed for: r1v16, types: [int] */
    /* JADX WARN: Type inference failed for: r1v17 */
    /* JADX WARN: Type inference failed for: r1v19 */
    public final int hashCode() {
        int r100 = ((((((((((((Float.floatToIntBits(this.f19480a) * 31) + Float.floatToIntBits(this.f19481b)) * 31) + Float.floatToIntBits(this.f19482c)) * 31) + Float.floatToIntBits(this.f19483d)) * 31) + Float.floatToIntBits(this.f19484e)) * 31) + this.f19485f) * 31) + Float.floatToIntBits(this.f19486g)) * 31;
        HitType r101 = this.f19487h;
        if (r101 == null) goto L5;
        int r102 = r101.hashCode();
    L6:
        int r103 = (((r100 + r102) * 31) + this.f19488i) * 31;
        boolean r104 = this.f19489j;
        ?? r105 = r104;
        if (r104 == false) goto L10;
        r105 = 1;
    L10:
        return r103 + r105;
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "MidiScoreInfo(sentenceScore=" + this.f19480a + ", avgScore=" + this.f19481b + ", songScore=" + this.f19482c + ", userPitch=" + this.f19483d + ", refPitch=" + this.f19484e + ", sentenceIndex=" + this.f19485f + ", timeMilliseconds=" + this.f19486g + ", hitType=" + this.f19487h + ", comboCount=" + this.f19488i + ", isSeekData=" + this.f19489j + ")";
    }

    public e(float r100, float r101, float r102, float r103, float r104, int r105, float r110, HitType r111, int r112, int r113) {
        if ((r113 & 1) == 0) goto L6;
        r100 = 0.0f;
    L6:
        if ((r113 & 2) == 0) goto L9;
        r101 = 0.0f;
    L9:
        if ((r113 & 4) == 0) goto L12;
        r102 = 0.0f;
    L12:
        if ((r113 & 8) == 0) goto L15;
        r103 = 0.0f;
    L15:
        if ((r113 & 16) == 0) goto L18;
        r104 = 0.0f;
    L18:
        if ((r113 & 32) == 0) goto L21;
        r105 = 0;
    L21:
        if ((r113 & 64) == 0) goto L24;
        r110 = 0.0f;
    L24:
        if ((r113 & 128) == 0) goto L27;
        r111 = HitType.MISS;
    L27:
        if ((r113 & 256) == 0) goto L29;
        r112 = 0;
    L29:
        Intrinsics.checkNotNullParameter(r111, "hitType");
        this.f19480a = r100;
        this.f19481b = r101;
        this.f19482c = r102;
        this.f19483d = r103;
        this.f19484e = r104;
        this.f19485f = r105;
        this.f19486g = r110;
        this.f19487h = r111;
        this.f19488i = r112;
        this.f19489j = false;
    }
}
