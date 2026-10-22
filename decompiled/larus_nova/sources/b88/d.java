package b88;

import android.graphics.Bitmap;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes24.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f18187a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f18188b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f18189c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f18190d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f18191e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f18192f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Bitmap f18193g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f18194h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f18195i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final String f18196j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final String f18197k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final JSONObject f18198l;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof d) == true) goto L8;
        return false;
    L8:
        d r101 = (d) r100;
        if (Intrinsics.areEqual(this.f18187a, r101.f18187a) == true) goto L12;
        return false;
    L12:
        if (this.f18188b == r101.f18188b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f18189c, r101.f18189c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f18190d, r101.f18190d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f18191e, r101.f18191e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f18192f, r101.f18192f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f18193g, r101.f18193g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f18194h, r101.f18194h) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.f18195i, r101.f18195i) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.f18196j, r101.f18196j) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.f18197k, r101.f18197k) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.f18198l, r101.f18198l) == true) goto L44;
        return false;
    L44:
        return true;
    }

    public final int hashCode() {
        int r100 = ((((((((((this.f18187a.hashCode() * 31) + this.f18188b) * 31) + this.f18189c.hashCode()) * 31) + this.f18190d.hashCode()) * 31) + this.f18191e.hashCode()) * 31) + this.f18192f.hashCode()) * 31;
        Bitmap r101 = this.f18193g;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        String r105 = this.f18194h;
        if (r105 != null) goto L9;
        int r106 = 0;
    L10:
        int r107 = (r104 + r106) * 31;
        String r108 = this.f18195i;
        if (r108 != null) goto L13;
        int r109 = 0;
    L14:
        int r110 = (r107 + r109) * 31;
        String r111 = this.f18196j;
        if (r111 != null) goto L17;
        int r112 = 0;
    L18:
        int r113 = (r110 + r112) * 31;
        String r114 = this.f18197k;
        if (r114 != null) goto L21;
        int r115 = 0;
    L22:
        int r116 = (r113 + r115) * 31;
        JSONObject r117 = this.f18198l;
        if (r117 == null) goto L27;
        r102 = r117.hashCode();
    L27:
        return r116 + r102;
    L21:
        r115 = r114.hashCode();
        goto L22
    L17:
        r112 = r111.hashCode();
        goto L18
    L13:
        r109 = r108.hashCode();
        goto L14
    L9:
        r106 = r105.hashCode();
        goto L10
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public final String toString() {
        return "NewsAudioData(scene=" + this.f18187a + ", sourceType=" + this.f18188b + ", url=" + this.f18189c + ", videoModelStr=" + this.f18190d + ", title=" + this.f18191e + ", artist=" + this.f18192f + ", albumArt=" + this.f18193g + ", albumArtUrl=" + this.f18194h + ", conversationId=" + this.f18195i + ", messageId=" + this.f18196j + ", appletId=" + this.f18197k + ", extra=" + this.f18198l + ')';
    }

    public /* synthetic */ d(String r110, int r111, String r112, String r113, String r114, String r115, String r116, String r210, String r211, String r212) {
        this(r110, r111, r112, r113, r114, r115, r116, r210, r211, r212, null);
    }

    public d(String r100, int r101, String r102, String r103, String r104, String r105, String r106, String r107, String r110, String r111, JSONObject r112) {
        Intrinsics.checkNotNullParameter(r100, "scene");
        Intrinsics.checkNotNullParameter(r102, "url");
        Intrinsics.checkNotNullParameter(r103, "videoModelStr");
        Intrinsics.checkNotNullParameter(r104, "title");
        Intrinsics.checkNotNullParameter(r105, "artist");
        this.f18187a = r100;
        this.f18188b = r101;
        this.f18189c = r102;
        this.f18190d = r103;
        this.f18191e = r104;
        this.f18192f = r105;
        this.f18193g = null;
        this.f18194h = r106;
        this.f18195i = r107;
        this.f18196j = r110;
        this.f18197k = r111;
        this.f18198l = r112;
    }
}
