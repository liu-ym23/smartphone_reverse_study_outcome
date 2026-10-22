package bw3;

import com.bytedance.applet.audio.inner.InnerAudioPlaybackState;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes14.dex */
public final class h0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f21079a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f21080b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f21081c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f21082d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f21083e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public double f21084f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public double f21085g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public double f21086h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f21087i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public double f21088j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public double f21089k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public double f21090l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public InnerAudioPlaybackState f21091m;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof h0) == true) goto L8;
        return false;
    L8:
        h0 r101 = (h0) r100;
        if (Intrinsics.areEqual(this.f21079a, r101.f21079a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f21080b, r101.f21080b) == true) goto L15;
        return false;
    L15:
        if (this.f21081c == r101.f21081c) goto L18;
        return false;
    L18:
        if (this.f21082d == r101.f21082d) goto L21;
        return false;
    L21:
        if (this.f21083e == r101.f21083e) goto L24;
        return false;
    L24:
        if (Double.compare(this.f21084f, r101.f21084f) == 0) goto L27;
        return false;
    L27:
        if (Double.compare(this.f21085g, r101.f21085g) == 0) goto L30;
        return false;
    L30:
        if (Double.compare(this.f21086h, r101.f21086h) == 0) goto L33;
        return false;
    L33:
        if (this.f21087i == r101.f21087i) goto L36;
        return false;
    L36:
        if (Double.compare(this.f21088j, r101.f21088j) == 0) goto L39;
        return false;
    L39:
        if (Double.compare(this.f21089k, r101.f21089k) == 0) goto L42;
        return false;
    L42:
        if (Double.compare(this.f21090l, r101.f21090l) == 0) goto L45;
        return false;
    L45:
        if (this.f21091m == r101.f21091m) goto L47;
        return false;
    L47:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f21079a.hashCode() * 31;
        String r101 = this.f21080b;
        if (r101 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = (r100 + r102) * 31;
        int r104 = 1231;
        if (this.f21081c == false) goto L9;
        int r105 = 1231;
    L10:
        int r106 = (r103 + r105) * 31;
        if (this.f21082d == false) goto L13;
        int r107 = 1231;
    L14:
        int r108 = (r106 + r107) * 31;
        if (this.f21083e == false) goto L17;
        int r109 = 1231;
    L18:
        long r110 = Double.doubleToLongBits(this.f21084f);
        int r111 = (((r108 + r109) * 31) + ((int) (r110 ^ (r110 >>> 32)))) * 31;
        long r112 = Double.doubleToLongBits(this.f21085g);
        int r113 = (r111 + ((int) (r112 ^ (r112 >>> 32)))) * 31;
        long r114 = Double.doubleToLongBits(this.f21086h);
        int r115 = (r113 + ((int) (r114 ^ (r114 >>> 32)))) * 31;
        if (this.f21087i == true) goto L22;
        r104 = 1237;
    L22:
        int r116 = (r115 + r104) * 31;
        long r117 = Double.doubleToLongBits(this.f21088j);
        int r118 = (r116 + ((int) (r117 ^ (r117 >>> 32)))) * 31;
        long r119 = Double.doubleToLongBits(this.f21089k);
        int r120 = (r118 + ((int) (r119 ^ (r119 >>> 32)))) * 31;
        long r121 = Double.doubleToLongBits(this.f21090l);
        return ((r120 + ((int) (r121 ^ (r121 >>> 32)))) * 31) + this.f21091m.hashCode();
    L17:
        r109 = 1237;
        goto L18
    L13:
        r107 = 1237;
        goto L14
    L9:
        r105 = 1237;
        goto L10
    L5:
        r102 = r101.hashCode();
        goto L6
    }

    public final String toString() {
        return "InnerAudioState(audioId=" + this.f21079a + ", src=" + this.f21080b + ", autoplay=" + this.f21081c + ", loop=" + this.f21082d + ", obeyMuteSwitch=" + this.f21083e + ", startTime=" + this.f21084f + ", currentTime=" + this.f21085g + ", duration=" + this.f21086h + ", paused=" + this.f21087i + ", buffered=" + this.f21088j + ", volume=" + this.f21089k + ", playbackRate=" + this.f21090l + ", playbackState=" + this.f21091m + ')';
    }

    public final String b() {
        String[] r100 = new String[10];
        boolean r101 = false;
        r100[0] = "audioId: " + this.f21079a;
        StringBuilder r102 = new StringBuilder("hasSrc: ");
        String r103 = this.f21080b;
        if (r103 != null) goto L5;
    L7:
        r102.append(r101);
        r100[1] = r102.toString();
        r100[2] = "state: " + this.f21091m.getValue();
        r100[3] = "paused: " + this.f21087i;
        r100[4] = "startTime: " + i0.a(this.f21084f);
        r100[5] = "currentTime: " + i0.a(this.f21085g);
        r100[6] = "duration: " + i0.a(this.f21086h);
        r100[7] = "buffered: " + i0.a(this.f21088j);
        r100[8] = "volume: " + i0.a(this.f21089k);
        r100[9] = "playbackRate: " + i0.a(this.f21090l);
        return CollectionsKt.joinToString$default(CollectionsKt.listOf(r100), ", ", null, null, 0, null, null, 62, null);
    L5:
        if ((!StringsKt.isBlank(r103)) != true) goto L7;
        r101 = true;
        goto L7
    }

    public static h0 a(h0 r210) {
        String r100 = r210.f21079a;
        String r101 = r210.f21080b;
        boolean r102 = r210.f21081c;
        boolean r103 = r210.f21082d;
        boolean r104 = r210.f21083e;
        double r105 = r210.f21084f;
        double r106 = r210.f21085g;
        double r110 = r210.f21086h;
        boolean r111 = r210.f21087i;
        double r112 = r210.f21088j;
        double r113 = r210.f21089k;
        double r114 = r210.f21090l;
        InnerAudioPlaybackState r115 = r210.f21091m;
        r210.getClass();
        Intrinsics.checkNotNullParameter(r100, "audioId");
        Intrinsics.checkNotNullParameter(r115, "playbackState");
        return new h0(r100, r101, r102, r103, r104, r105, r106, r110, r111, r112, r113, r114, r115);
    }

    public final void d(InnerAudioPlaybackState r100) {
        Intrinsics.checkNotNullParameter(r100, "nextPlaybackState");
        this.f21091m = r100;
        if (r100 == InnerAudioPlaybackState.PLAYING) goto L5;
        boolean r101 = true;
    L6:
        this.f21087i = r101;
        return;
    L5:
        r101 = false;
        goto L6
    }

    public static void c(h0 r100, double r101, double r102) {
        r100.getClass();
        r100.f21085g = i0.b(r101);
        r100.f21086h = i0.b(r102);
        r100.f21088j = i0.b(r102);
    }

    public h0(String r100, String r101, boolean r102, boolean r103, boolean r110, double r111, double r112, double r113, boolean r114, double r115, double r210, double r211, InnerAudioPlaybackState r212) {
        Intrinsics.checkNotNullParameter(r100, "audioId");
        Intrinsics.checkNotNullParameter(r212, "playbackState");
        this.f21079a = r100;
        this.f21080b = r101;
        this.f21081c = r102;
        this.f21082d = r103;
        this.f21083e = r110;
        this.f21084f = r111;
        this.f21085g = r112;
        this.f21086h = r113;
        this.f21087i = r114;
        this.f21088j = r115;
        this.f21089k = r210;
        this.f21090l = r211;
        this.f21091m = r212;
    }
}
