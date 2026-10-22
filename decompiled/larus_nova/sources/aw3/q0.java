package aw3;

import androidx.camera.video.AudioStats;
import com.bytedance.applet.audio.background.BackgroundAudioPlaybackState;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes14.dex */
public final class q0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f16479a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f16480b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f16481c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f16482d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f16483e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f16484f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public double f16485g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public double f16486h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public double f16487i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f16488j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public double f16489k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public double f16490l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public BackgroundAudioPlaybackState f16491m;

    public q0() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof q0) == true) goto L8;
        return false;
    L8:
        q0 r101 = (q0) r100;
        if (Intrinsics.areEqual(this.f16479a, r101.f16479a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f16480b, r101.f16480b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f16481c, r101.f16481c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f16482d, r101.f16482d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f16483e, r101.f16483e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f16484f, r101.f16484f) == true) goto L27;
        return false;
    L27:
        if (Double.compare(this.f16485g, r101.f16485g) == 0) goto L30;
        return false;
    L30:
        if (Double.compare(this.f16486h, r101.f16486h) == 0) goto L33;
        return false;
    L33:
        if (Double.compare(this.f16487i, r101.f16487i) == 0) goto L36;
        return false;
    L36:
        if (this.f16488j == r101.f16488j) goto L39;
        return false;
    L39:
        if (Double.compare(this.f16489k, r101.f16489k) == 0) goto L42;
        return false;
    L42:
        if (Double.compare(this.f16490l, r101.f16490l) == 0) goto L45;
        return false;
    L45:
        if (this.f16491m == r101.f16491m) goto L47;
        return false;
    L47:
        return true;
    }

    public final int hashCode() {
        String r100 = this.f16479a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.f16480b;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.f16481c;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.f16482d;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.f16483e;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        String r116 = this.f16484f;
        if (r116 == null) goto L26;
        r101 = r116.hashCode();
    L26:
        int r117 = (r115 + r101) * 31;
        long r118 = Double.doubleToLongBits(this.f16485g);
        int r119 = (r117 + ((int) (r118 ^ (r118 >>> 32)))) * 31;
        long r120 = Double.doubleToLongBits(this.f16486h);
        int r121 = (r119 + ((int) (r120 ^ (r120 >>> 32)))) * 31;
        long r122 = Double.doubleToLongBits(this.f16487i);
        int r123 = (r121 + ((int) (r122 ^ (r122 >>> 32)))) * 31;
        if (this.f16488j == false) goto L29;
        int r124 = 1231;
    L30:
        int r125 = (r123 + r124) * 31;
        long r126 = Double.doubleToLongBits(this.f16489k);
        int r127 = (r125 + ((int) (r126 ^ (r126 >>> 32)))) * 31;
        long r128 = Double.doubleToLongBits(this.f16490l);
        return ((r127 + ((int) (r128 ^ (r128 >>> 32)))) * 31) + this.f16491m.hashCode();
    L29:
        r124 = 1237;
        goto L30
    L21:
        r114 = r113.hashCode();
        goto L22
    L17:
        r111 = r110.hashCode();
        goto L18
    L13:
        r108 = r107.hashCode();
        goto L14
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "BackgroundAudioState(src=" + this.f16479a + ", title=" + this.f16480b + ", epname=" + this.f16481c + ", singer=" + this.f16482d + ", coverImgUrl=" + this.f16483e + ", webUrl=" + this.f16484f + ", startTime=" + this.f16485g + ", currentTime=" + this.f16486h + ", duration=" + this.f16487i + ", paused=" + this.f16488j + ", buffered=" + this.f16489k + ", playbackRate=" + this.f16490l + ", playbackState=" + this.f16491m + ')';
    }

    public final String b() {
        String[] r100 = new String[10];
        StringBuilder r101 = new StringBuilder("hasSrc: ");
        String r102 = this.f16479a;
        boolean r103 = true;
        if (r102 != null) goto L5;
    L10:
        boolean r104 = false;
    L11:
        r101.append(r104);
        r100[0] = r101.toString();
        StringBuilder r105 = new StringBuilder("hasTitle: ");
        String r106 = this.f16480b;
        if (r106 != null) goto L14;
    L19:
        boolean r107 = false;
    L20:
        r105.append(r107);
        r100[1] = r105.toString();
        StringBuilder r108 = new StringBuilder("hasCover: ");
        String r109 = this.f16483e;
        if (r109 != null) goto L23;
    L28:
        r103 = false;
    L29:
        r108.append(r103);
        r100[2] = r108.toString();
        r100[3] = "state: " + this.f16491m.getValue();
        r100[4] = "paused: " + this.f16488j;
        r100[5] = "startTime: " + r0.a(this.f16485g);
        r100[6] = "currentTime: " + r0.a(this.f16486h);
        r100[7] = "duration: " + r0.a(this.f16487i);
        r100[8] = "buffered: " + r0.a(this.f16489k);
        r100[9] = "playbackRate: " + r0.a(this.f16490l);
        return CollectionsKt.joinToString$default(CollectionsKt.listOf(r100), ", ", null, null, 0, null, null, 62, null);
    L23:
        if (r109.length() <= 0) goto L25;
        boolean r110 = true;
    L26:
        if (r110 != true) goto L28;
    L25:
        r110 = false;
        goto L26
    L14:
        if (r106.length() <= 0) goto L16;
        boolean r111 = true;
    L17:
        if (r111 != true) goto L19;
        r107 = true;
        goto L20
    L16:
        r111 = false;
        goto L17
    L5:
        if (r102.length() <= 0) goto L7;
        boolean r112 = true;
    L8:
        if (r112 != true) goto L10;
        r104 = true;
        goto L11
    L7:
        r112 = false;
        goto L8
    }

    public /* synthetic */ q0(int r210) {
        this(null, null, null, null, null, null, AudioStats.AUDIO_AMPLITUDE_NONE, AudioStats.AUDIO_AMPLITUDE_NONE, AudioStats.AUDIO_AMPLITUDE_NONE, true, AudioStats.AUDIO_AMPLITUDE_NONE, 1.0d, BackgroundAudioPlaybackState.STOPPED);
    }

    public static q0 a(q0 r210) {
        String r100 = r210.f16479a;
        String r101 = r210.f16480b;
        String r102 = r210.f16481c;
        String r103 = r210.f16482d;
        String r104 = r210.f16483e;
        String r105 = r210.f16484f;
        double r106 = r210.f16485g;
        double r107 = r210.f16486h;
        double r110 = r210.f16487i;
        boolean r111 = r210.f16488j;
        double r112 = r210.f16489k;
        double r113 = r210.f16490l;
        BackgroundAudioPlaybackState r114 = r210.f16491m;
        r210.getClass();
        Intrinsics.checkNotNullParameter(r114, "playbackState");
        return new q0(r100, r101, r102, r103, r104, r105, r106, r107, r110, r111, r112, r113, r114);
    }

    public final void c(s0 r100) {
        Intrinsics.checkNotNullParameter(r100, "stateUpdate");
        String r101 = r100.f16494a;
        if (r101 == null) goto L5;
        this.f16479a = r101;
    L5:
        String r102 = r100.f16495b;
        if (r102 == null) goto L8;
        this.f16480b = r102;
    L8:
        String r103 = r100.f16496c;
        if (r103 == null) goto L11;
        this.f16481c = r103;
    L11:
        String r104 = r100.f16497d;
        if (r104 == null) goto L14;
        this.f16482d = r104;
    L14:
        String r105 = r100.f16498e;
        if (r105 == null) goto L17;
        this.f16483e = r105;
    L17:
        String r106 = r100.f16499f;
        if (r106 == null) goto L20;
        this.f16484f = r106;
    L20:
        Double r107 = r100.f16500g;
        if (r107 == null) goto L23;
        this.f16485g = RangesKt.coerceAtLeast(r107.doubleValue(), AudioStats.AUDIO_AMPLITUDE_NONE);
    L23:
        Double r108 = r100.f16501h;
        if (r108 == null) goto L27;
        this.f16490l = r108.doubleValue();
        return;
    }

    public final void d(double r100) {
        this.f16486h = RangesKt.coerceAtLeast(r100, AudioStats.AUDIO_AMPLITUDE_NONE);
    }

    public final void e(BackgroundAudioPlaybackState r100) {
        Intrinsics.checkNotNullParameter(r100, "nextPlaybackState");
        this.f16491m = r100;
        if (r100 == BackgroundAudioPlaybackState.PLAYING) goto L5;
        boolean r101 = true;
    L6:
        this.f16488j = r101;
        return;
    L5:
        r101 = false;
        goto L6
    }

    public q0(String r100, String r101, String r102, String r103, String r104, String r110, double r111, double r112, double r113, boolean r114, double r115, double r210, BackgroundAudioPlaybackState r211) {
        Intrinsics.checkNotNullParameter(r211, "playbackState");
        this.f16479a = r100;
        this.f16480b = r101;
        this.f16481c = r102;
        this.f16482d = r103;
        this.f16483e = r104;
        this.f16484f = r110;
        this.f16485g = r111;
        this.f16486h = r112;
        this.f16487i = r113;
        this.f16488j = r114;
        this.f16489k = r115;
        this.f16490l = r210;
        this.f16491m = r211;
    }
}
