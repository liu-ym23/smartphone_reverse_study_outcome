package b30;

import com.bytedance.android.livesdkapi.depend.model.live.emoji.ISelfEmoji;
import com.bytedance.android.livesdkapi.depend.model.live.episode.SelectAtUser;
import com.google.gson.JsonObject;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f17135a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f17136b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f17137c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f17138d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final a f17139e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final h f17140f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f17141g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f17142h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final long f17143i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final boolean f17144j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final JsonObject f17145k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final String f17146l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final String f17147m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final String f17148n;

    public interface a {

        /* JADX INFO: renamed from: b30.i$a$a, reason: collision with other inner class name */
        public static class C0256a implements a {
            public C0256a() {
            }

            @Override // b30.i.a
            public final void onCommentSuccess(CharSequence r100, ISelfEmoji r101, List<SelectAtUser> r102) {
            }
        }

        void onCommentSuccess(CharSequence r100, ISelfEmoji r101, List<SelectAtUser> r102);
    }

    public static final class b {
    }

    static {
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof i) == false) goto L32;
        i r101 = (i) r100;
        if (Intrinsics.areEqual(this.f17136b, r101.f17136b) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f17137c, r101.f17137c) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f17138d, r101.f17138d) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f17139e, r101.f17139e) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.f17140f, r101.f17140f) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.f17141g, r101.f17141g) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f17142h, r101.f17142h) == true) goto L20;
        return false;
    L20:
        if (this.f17143i == r101.f17143i) goto L22;
        return false;
    L22:
        if (this.f17144j == r101.f17144j) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f17145k, r101.f17145k) == true) goto L26;
        return false;
    L26:
        if (Intrinsics.areEqual(this.f17146l, r101.f17146l) == true) goto L28;
        return false;
    L28:
        if (Intrinsics.areEqual(this.f17147m, r101.f17147m) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f17148n, r101.f17148n) == true) goto L49;
        return false;
    L49:
        return true;
    L32:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v18, types: [int] */
    /* JADX WARN: Type inference failed for: r2v21, types: [int] */
    /* JADX WARN: Type inference failed for: r2v35 */
    /* JADX WARN: Type inference failed for: r2v42 */
    public final int hashCode() {
        String r100 = this.f17136b;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.f17137c;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.f17138d;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        a r110 = this.f17139e;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        h r113 = this.f17140f;
        if (r113 == null) goto L21;
        int r114 = r113.hashCode();
    L22:
        int r115 = (r112 + r114) * 31;
        String r116 = this.f17141g;
        if (r116 == null) goto L25;
        int r117 = r116.hashCode();
    L26:
        int r118 = (r115 + r117) * 31;
        String r119 = this.f17142h;
        if (r119 == null) goto L29;
        int r120 = r119.hashCode();
    L30:
        int r121 = (r118 + r120) * 31;
        long r122 = this.f17143i;
        int r123 = (r121 + ((int) (r122 ^ (r122 >>> 32)))) * 31;
        boolean r124 = this.f17144j;
        ?? r125 = r124;
        if (r124 == false) goto L33;
        r125 = 1;
    L33:
        int r126 = (r123 + r125) * 31;
        JsonObject r127 = this.f17145k;
        if (r127 == null) goto L36;
        int r128 = r127.hashCode();
    L37:
        int r129 = (r126 + r128) * 31;
        String r130 = this.f17146l;
        if (r130 == null) goto L40;
        int r131 = r130.hashCode();
    L41:
        int r132 = (r129 + r131) * 31;
        String r133 = this.f17147m;
        if (r133 == null) goto L44;
        int r134 = r133.hashCode();
    L45:
        int r135 = (r132 + r134) * 31;
        String r136 = this.f17148n;
        if (r136 == null) goto L49;
        r101 = r136.hashCode();
    L49:
        return r135 + r101;
    L44:
        r134 = 0;
        goto L45
    L40:
        r131 = 0;
        goto L41
    L36:
        r128 = 0;
        goto L37
    L29:
        r120 = 0;
        goto L30
    L25:
        r117 = 0;
        goto L26
    L21:
        r114 = 0;
        goto L22
    L17:
        r111 = 0;
        goto L18
    L13:
        r108 = 0;
        goto L14
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "OpenCommentPanelEvent(content=" + this.f17136b + ", requestPage=" + this.f17137c + ", messageSource=" + this.f17138d + ", commentCallback=" + this.f17139e + ", atUserParam=" + this.f17140f + ", requestSource=" + this.f17141g + ", defaultPanel=" + this.f17142h + ", createTime=" + this.f17143i + ", isFromJsb=" + this.f17144j + ", trackParams=" + this.f17145k + ", previewGuideText=" + this.f17146l + ", roomId=" + this.f17147m + ", hint=" + this.f17148n + ")";
    }

    public i(String r110, String r111, String r112, a r113, h r210, String r211, String r212, long r213, boolean r214, JsonObject r215, String r216, String r217, String r218, int r310) {
        boolean r100 = false;
        if ((r310 & 16) == 0) goto L5;
        h r101 = new h(0);
    L6:
        String r102 = "";
        if ((r310 & 32) == 0) goto L9;
        String r103 = "";
    L10:
        String r114 = null;
        if ((r310 & 64) == 0) goto L13;
        String r104 = null;
    L15:
        if ((r310 & 128) == 0) goto L17;
        long r115 = System.currentTimeMillis();
    L19:
        if ((r310 & 256) != 0) goto L23;
        r100 = r214;
    L23:
        if ((r310 & 512) == 0) goto L25;
        JsonObject r116 = null;
    L27:
        if ((r310 & 1024) != 0) goto L31;
        r102 = r216;
    L31:
        if ((r310 & 2048) == 0) goto L33;
        String r117 = null;
    L35:
        if ((r310 & 4096) != 0) goto L38;
        r114 = r218;
    L38:
        Intrinsics.checkNotNullParameter(r111, "requestPage");
        Intrinsics.checkNotNullParameter(r112, "messageSource");
        Intrinsics.checkNotNullParameter(r113, "commentCallback");
        Intrinsics.checkNotNullParameter(r101, "atUserParam");
        Intrinsics.checkNotNullParameter(r102, "previewGuideText");
        this.f17136b = r110;
        this.f17137c = r111;
        this.f17138d = r112;
        this.f17139e = r113;
        this.f17140f = r101;
        this.f17141g = r103;
        this.f17142h = r104;
        this.f17143i = r115;
        this.f17144j = r100;
        this.f17145k = r116;
        this.f17146l = r102;
        this.f17147m = r117;
        this.f17148n = r114;
        return;
    L33:
        r117 = r217;
        goto L35
    L25:
        r116 = r215;
        goto L27
    L17:
        r115 = r213;
        goto L19
    L13:
        r104 = r212;
        goto L15
    L9:
        r103 = r211;
        goto L10
    L5:
        r101 = r210;
        goto L6
    }
}
