package bl6;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes20.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0087\b\u0018\u00002\u00020\u0001R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR0\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"Lbl6/b;", "", "", "percent", "Ljava/lang/Integer;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/lang/Integer;", "setPercent", "(Ljava/lang/Integer;)V", "", "", "Lbl6/i;", "scoreRanges", "Ljava/util/Map;", "b", "()Ljava/util/Map;", "setScoreRanges", "(Ljava/util/Map;)V", "livektv-common_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f19440a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f19441b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final float f19442c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f19443d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final float f19444e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Integer f19445f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Integer f19446g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Integer f19447h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Integer f19448i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Boolean f19449j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Integer f19450k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Float f19451l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Boolean f19452m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Boolean f19453n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final Integer f19454o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final Integer f19455p;

    @SerializedName("score_reporting_threshold_sung_percent")
    private Integer percent;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final Integer f19456q;

    @SerializedName("rate_feedback")
    private Map<String, i> scoreRanges;

    public b() {
        this(null, null, 524287);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof b) == false) goto L44;
        b r101 = (b) r100;
        if (this.f19440a == r101.f19440a) goto L8;
        return false;
    L8:
        if (this.f19441b == r101.f19441b) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.percent, r101.percent) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.scoreRanges, r101.scoreRanges) == true) goto L14;
        return false;
    L14:
        if (Float.compare(this.f19442c, r101.f19442c) == 0) goto L16;
        return false;
    L16:
        if (this.f19443d == r101.f19443d) goto L18;
        return false;
    L18:
        if (Float.compare(this.f19444e, r101.f19444e) == 0) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.f19445f, r101.f19445f) == true) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.f19446g, r101.f19446g) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f19447h, r101.f19447h) == true) goto L26;
        return false;
    L26:
        if (Intrinsics.areEqual(this.f19448i, r101.f19448i) == true) goto L28;
        return false;
    L28:
        if (Intrinsics.areEqual(this.f19449j, r101.f19449j) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f19450k, r101.f19450k) == true) goto L32;
        return false;
    L32:
        if (Intrinsics.areEqual(this.f19451l, r101.f19451l) == true) goto L34;
        return false;
    L34:
        if (Intrinsics.areEqual(this.f19452m, r101.f19452m) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.f19453n, r101.f19453n) == true) goto L38;
        return false;
    L38:
        if (Intrinsics.areEqual(this.f19454o, r101.f19454o) == true) goto L40;
        return false;
    L40:
        if (Intrinsics.areEqual(this.f19455p, r101.f19455p) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.f19456q, r101.f19456q) == true) goto L67;
        return false;
    L67:
        return true;
    L44:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v10, types: [int] */
    /* JADX WARN: Type inference failed for: r1v10, types: [int] */
    /* JADX WARN: Type inference failed for: r1v58 */
    /* JADX WARN: Type inference failed for: r1v61 */
    public final int hashCode() {
        int r100 = ((this.f19440a * 31) + this.f19441b) * 31;
        Integer r101 = this.percent;
        int r102 = 0;
        if (r101 == null) goto L5;
        int r103 = r101.hashCode();
    L6:
        int r104 = (r100 + r103) * 31;
        Map<String, i> r105 = this.scoreRanges;
        if (r105 == null) goto L9;
        int r106 = r105.hashCode();
    L10:
        int r107 = (((r104 + r106) * 31) + Float.floatToIntBits(this.f19442c)) * 31;
        boolean r108 = this.f19443d;
        ?? r109 = r108;
        if (r108 == false) goto L13;
        r109 = 1;
    L13:
        int r110 = (((r107 + r109) * 31) + Float.floatToIntBits(this.f19444e)) * 31;
        Integer r111 = this.f19445f;
        if (r111 == null) goto L16;
        int r112 = r111.hashCode();
    L17:
        int r113 = (r110 + r112) * 31;
        Integer r114 = this.f19446g;
        if (r114 == null) goto L20;
        int r115 = r114.hashCode();
    L21:
        int r116 = (r113 + r115) * 31;
        Integer r117 = this.f19447h;
        if (r117 == null) goto L24;
        int r118 = r117.hashCode();
    L25:
        int r119 = (r116 + r118) * 31;
        Integer r120 = this.f19448i;
        if (r120 == null) goto L28;
        int r121 = r120.hashCode();
    L29:
        int r122 = (r119 + r121) * 31;
        Boolean r123 = this.f19449j;
        if (r123 == null) goto L32;
        int r124 = r123.hashCode();
    L33:
        int r125 = (r122 + r124) * 31;
        Integer r126 = this.f19450k;
        if (r126 == null) goto L36;
        int r127 = r126.hashCode();
    L37:
        int r128 = (r125 + r127) * 31;
        Float r129 = this.f19451l;
        if (r129 == null) goto L40;
        int r130 = r129.hashCode();
    L41:
        int r131 = (r128 + r130) * 31;
        Boolean r132 = this.f19452m;
        if (r132 == null) goto L44;
        int r133 = r132.hashCode();
    L45:
        int r134 = (r131 + r133) * 31;
        Boolean r135 = this.f19453n;
        if (r135 == null) goto L48;
        int r136 = r135.hashCode();
    L49:
        int r137 = (r134 + r136) * 31;
        Integer r138 = this.f19454o;
        if (r138 == null) goto L52;
        int r139 = r138.hashCode();
    L53:
        int r140 = (r137 + r139) * 31;
        Integer r141 = this.f19455p;
        if (r141 == null) goto L56;
        int r142 = r141.hashCode();
    L57:
        int r143 = (r140 + r142) * 31;
        Integer r144 = this.f19456q;
        if (r144 == null) goto L61;
        r102 = r144.hashCode();
    L61:
        return r143 + r102;
    L56:
        r142 = 0;
        goto L57
    L52:
        r139 = 0;
        goto L53
    L48:
        r136 = 0;
        goto L49
    L44:
        r133 = 0;
        goto L45
    L40:
        r130 = 0;
        goto L41
    L36:
        r127 = 0;
        goto L37
    L32:
        r124 = 0;
        goto L33
    L28:
        r121 = 0;
        goto L29
    L24:
        r118 = 0;
        goto L25
    L20:
        r115 = 0;
        goto L21
    L16:
        r112 = 0;
        goto L17
    L9:
        r106 = 0;
        goto L10
    L5:
        r103 = 0;
        goto L6
    }

    public final String toString() {
        return "MidiConfig(hitAnimationCount=" + this.f19440a + ", comboTarget=" + this.f19441b + ", percent=" + this.percent + ", scoreRanges=" + this.scoreRanges + ", scoreFactor=" + this.f19442c + ", enableMockScore=" + this.f19443d + ", mockScoreValue=" + this.f19444e + ", defaultToneMin=" + this.f19445f + ", defaultToneMax=" + this.f19446g + ", seekShakeRangeMs=" + this.f19447h + ", segmentHysteresisMs=" + this.f19448i + ", allowBackwardSeek=" + this.f19449j + ", seiMinIntervalMs=" + this.f19450k + ", pitchHitDiffThreshold=" + this.f19451l + ", intersectStartInclusive=" + this.f19452m + ", intersectEndInclusive=" + this.f19453n + ", matchDebounceMs=" + this.f19454o + ", matchedDurationMaxCapacity=" + this.f19455p + ", matchedDurationMinSpanMs=" + this.f19456q + ")";
    }

    public final Integer a() {
        return this.percent;
    }

    public final Map<String, i> b() {
        return this.scoreRanges;
    }

    public b(Integer r100, Map r101, int r110) {
        boolean r102 = false;
        if ((r110 & 1) == 0) goto L5;
        int r103 = 3;
    L7:
        if ((r110 & 2) == 0) goto L9;
        int r104 = 5;
    L11:
        if ((r110 & 4) == 0) goto L14;
        r100 = null;
    L14:
        if ((r110 & 8) == 0) goto L16;
        r101 = null;
    L16:
        float r105 = 0.0f;
        if ((r110 & 16) == 0) goto L19;
        float r106 = 1.2f;
    L21:
        if ((r110 & 32) == 0) goto L24;
        r102 = true;
    L24:
        if ((r110 & 64) == 0) goto L26;
        r105 = 100.0f;
    L26:
        this.f19440a = r103;
        this.f19441b = r104;
        this.percent = r100;
        this.scoreRanges = r101;
        this.f19442c = r106;
        this.f19443d = r102;
        this.f19444e = r105;
        this.f19445f = null;
        this.f19446g = null;
        this.f19447h = null;
        this.f19448i = null;
        this.f19449j = null;
        this.f19450k = null;
        this.f19451l = null;
        this.f19452m = null;
        this.f19453n = null;
        this.f19454o = null;
        this.f19455p = null;
        this.f19456q = null;
        return;
    L19:
        r106 = 0.0f;
        goto L21
    L9:
        r104 = 0;
        goto L11
    L5:
        r103 = 0;
        goto L7
    }
}
