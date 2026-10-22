package a78;

import com.larus.audio.call.plugins.RealtimeCallSubtitlePlugin;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f2049a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f2050b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f2051c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f2052d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f2053e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f2054f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f2055g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f2056h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f2057i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final RealtimeCallSubtitlePlugin.b f2058j;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f2049a, r101.f2049a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f2050b, r101.f2050b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f2051c, r101.f2051c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f2052d, r101.f2052d) == true) goto L21;
        return false;
    L21:
        if (this.f2053e == r101.f2053e) goto L24;
        return false;
    L24:
        if (this.f2054f == r101.f2054f) goto L27;
        return false;
    L27:
        if (this.f2055g == r101.f2055g) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f2056h, r101.f2056h) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.f2057i, r101.f2057i) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.f2058j, r101.f2058j) == true) goto L38;
        return false;
    L38:
        return true;
    }

    public final int hashCode() {
        String r100 = this.f2049a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.f2050b;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.f2051c;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.f2052d;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (((r109 + r111) * 31) + this.f2053e) * 31;
        int r113 = 1231;
        if (this.f2054f == false) goto L21;
        int r114 = 1231;
    L22:
        int r115 = (r112 + r114) * 31;
        if (this.f2055g == true) goto L26;
        r113 = 1237;
    L26:
        int r116 = (((((r115 + r113) * 31) + this.f2056h.hashCode()) * 31) + this.f2057i.hashCode()) * 31;
        RealtimeCallSubtitlePlugin.b r117 = this.f2058j;
        if (r117 == null) goto L31;
        r101 = r117.hashCode();
    L31:
        return r116 + r101;
    L21:
        r114 = 1237;
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
        return "TTSSubtitleData(sectionId=" + this.f2049a + ", messageId=" + this.f2050b + ", text=" + this.f2051c + ", ttsTaskId=" + this.f2052d + ", isFromHello=" + this.f2053e + ", needReplace=" + this.f2054f + ", useTextContent=" + this.f2055g + ", queryRound=" + this.f2056h + ", questionId=" + this.f2057i + ", blockContent=" + this.f2058j + ')';
    }

    public a(String r100, String r101, String r102, String r103, int r104, boolean r105, boolean r106, String r107, String r110, RealtimeCallSubtitlePlugin.b r111) {
        Intrinsics.checkNotNullParameter(r107, "queryRound");
        Intrinsics.checkNotNullParameter(r110, "questionId");
        this.f2049a = r100;
        this.f2050b = r101;
        this.f2051c = r102;
        this.f2052d = r103;
        this.f2053e = r104;
        this.f2054f = r105;
        this.f2055g = r106;
        this.f2056h = r107;
        this.f2057i = r110;
        this.f2058j = r111;
    }

    public /* synthetic */ a(String r110, String r111, String r112, String r113, int r114, boolean r210, boolean r211, String r212, String r213, RealtimeCallSubtitlePlugin.b r214, int r215) {
        if ((r215 & 16) == 0) goto L5;
        int r100 = 0;
    L7:
        if ((r215 & 32) == 0) goto L9;
        boolean r101 = false;
    L11:
        if ((r215 & 64) == 0) goto L13;
        boolean r115 = false;
    L15:
        if ((r215 & 128) == 0) goto L17;
        String r116 = "";
    L19:
        if ((r215 & 256) == 0) goto L21;
        String r117 = "";
    L22:
        this(r110, r111, r112, r113, r100, r101, r115, r116, r117, r214);
        return;
    L21:
        r117 = r213;
        goto L22
    L17:
        r116 = r212;
        goto L19
    L13:
        r115 = r211;
        goto L15
    L9:
        r101 = r210;
        goto L11
    L5:
        r100 = r114;
        goto L7
    }
}
