package a88;

import android.graphics.Bitmap;
import com.larus.audio.constant.GlobalAudioSceneEnum;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f2189a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f2190b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f2191c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f2192d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Bitmap f2193e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f2194f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f2195g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f2196h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f2197i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final String f2198j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final String f2199k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final String f2200l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final String f2201m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final String f2202n;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof e) == true) goto L8;
        return false;
    L8:
        e r101 = (e) r100;
        if (Intrinsics.areEqual(this.f2189a, r101.f2189a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f2190b, r101.f2190b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f2191c, r101.f2191c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f2192d, r101.f2192d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f2193e, r101.f2193e) == true) goto L24;
        return false;
    L24:
        if (this.f2194f == r101.f2194f) goto L27;
        return false;
    L27:
        if (this.f2195g == r101.f2195g) goto L30;
        return false;
    L30:
        if (this.f2196h == r101.f2196h) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.f2197i, r101.f2197i) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.f2198j, r101.f2198j) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.f2199k, r101.f2199k) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.f2200l, r101.f2200l) == true) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.f2201m, r101.f2201m) == true) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.f2202n, r101.f2202n) == true) goto L50;
        return false;
    L50:
        return true;
    }

    public final int hashCode() {
        int r100 = ((((((this.f2189a.hashCode() * 31) + this.f2190b.hashCode()) * 31) + this.f2191c.hashCode()) * 31) + this.f2192d.hashCode()) * 31;
        Bitmap r101 = this.f2193e;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        int r105 = 1231;
        if (this.f2194f == false) goto L9;
        int r106 = 1231;
    L10:
        int r107 = (r104 + r106) * 31;
        if (this.f2195g == false) goto L13;
        int r108 = 1231;
    L14:
        int r109 = (r107 + r108) * 31;
        if (this.f2196h == true) goto L18;
        r105 = 1237;
    L18:
        int r110 = (r109 + r105) * 31;
        String r111 = this.f2197i;
        if (r111 != null) goto L21;
        int r112 = 0;
    L22:
        int r113 = (r110 + r112) * 31;
        String r114 = this.f2198j;
        if (r114 != null) goto L25;
        int r115 = 0;
    L26:
        int r116 = (((((((r113 + r115) * 31) + this.f2199k.hashCode()) * 31) + this.f2200l.hashCode()) * 31) + this.f2201m.hashCode()) * 31;
        String r117 = this.f2202n;
        if (r117 == null) goto L31;
        r102 = r117.hashCode();
    L31:
        return r116 + r102;
    L25:
        r115 = r114.hashCode();
        goto L26
    L21:
        r112 = r111.hashCode();
        goto L22
    L13:
        r108 = 1237;
        goto L14
    L9:
        r106 = 1237;
        goto L10
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public final String toString() {
        return "MusicData(musicId=" + this.f2189a + ", videoModelJsonStr=" + this.f2190b + ", title=" + this.f2191c + ", artist=" + this.f2192d + ", albumArt=" + this.f2193e + ", disableFavorite=" + this.f2194f + ", isFavorite=" + this.f2195g + ", enableHidingSkip=" + this.f2196h + ", albumArtUrl=" + this.f2197i + ", callId=" + this.f2198j + ", conversationId=" + this.f2199k + ", messageId=" + this.f2200l + ", globalAudioEventScene=" + this.f2201m + ", appletAppId=" + this.f2202n + ')';
    }

    public e(String r100, String r101, String r102, String r103, boolean r104, boolean r105, boolean r106, String r110, String r111, String r112, String r113, String r114, int r115) {
        if ((r115 & 32) == 0) goto L6;
        r104 = false;
    L6:
        if ((r115 & 64) == 0) goto L9;
        r105 = false;
    L9:
        if ((r115 & 128) == 0) goto L12;
        r106 = false;
    L12:
        if ((r115 & 256) == 0) goto L15;
        r110 = null;
    L15:
        if ((r115 & 8192) == 0) goto L17;
        r114 = null;
    L17:
        Intrinsics.checkNotNullParameter(r100, "musicId");
        Intrinsics.checkNotNullParameter(r101, "videoModelJsonStr");
        Intrinsics.checkNotNullParameter(r102, "title");
        Intrinsics.checkNotNullParameter(r103, "artist");
        Intrinsics.checkNotNullParameter(r112, "conversationId");
        Intrinsics.checkNotNullParameter(r113, "messageId");
        Intrinsics.checkNotNullParameter(GlobalAudioSceneEnum.PLUGIN_MUSIC, "globalAudioEventScene");
        this.f2189a = r100;
        this.f2190b = r101;
        this.f2191c = r102;
        this.f2192d = r103;
        this.f2193e = null;
        this.f2194f = r104;
        this.f2195g = r105;
        this.f2196h = r106;
        this.f2197i = r110;
        this.f2198j = r111;
        this.f2199k = r112;
        this.f2200l = r113;
        this.f2201m = GlobalAudioSceneEnum.PLUGIN_MUSIC;
        this.f2202n = r114;
    }
}
