package bd0;

import android.view.View;
import com.bytedance.android.live.core.widget.HSImageView;
import com.lynx.serval.svg.SVGRenderEngine;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f18628a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final View f18629b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f18630c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f18631d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final float f18632e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final float f18633f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f18634g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f18635h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f18636i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Integer f18637j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final String f18638k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Integer f18639l;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof c) == false) goto L30;
        c r101 = (c) r100;
        if (Intrinsics.areEqual(this.f18628a, r101.f18628a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f18629b, r101.f18629b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f18630c, r101.f18630c) == true) goto L12;
        return false;
    L12:
        if (this.f18631d == r101.f18631d) goto L14;
        return false;
    L14:
        if (Float.compare(this.f18632e, r101.f18632e) == 0) goto L16;
        return false;
    L16:
        if (Float.compare(this.f18633f, r101.f18633f) == 0) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f18634g, r101.f18634g) == true) goto L20;
        return false;
    L20:
        if (this.f18635h == r101.f18635h) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.f18636i, r101.f18636i) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f18637j, r101.f18637j) == true) goto L26;
        return false;
    L26:
        if (Intrinsics.areEqual(this.f18638k, r101.f18638k) == true) goto L28;
        return false;
    L28:
        if (Intrinsics.areEqual(this.f18639l, r101.f18639l) == true) goto L46;
        return false;
    L46:
        return true;
    L30:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v8, types: [int] */
    /* JADX WARN: Type inference failed for: r2v30 */
    /* JADX WARN: Type inference failed for: r2v33 */
    /* JADX WARN: Type inference failed for: r2v7, types: [int] */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1, types: [int] */
    /* JADX WARN: Type inference failed for: r3v2 */
    public final int hashCode() {
        View r100 = this.f18628a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        View r104 = this.f18629b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.f18630c;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        boolean r110 = this.f18631d;
        ?? r111 = 1;
        ?? r112 = r110;
        if (r110 == false) goto L17;
        r112 = 1;
    L17:
        int r113 = (((((r109 + r112) * 31) + Float.floatToIntBits(this.f18632e)) * 31) + Float.floatToIntBits(this.f18633f)) * 31;
        String r114 = this.f18634g;
        if (r114 == null) goto L20;
        int r115 = r114.hashCode();
    L21:
        int r116 = (r113 + r115) * 31;
        boolean r117 = this.f18635h;
        if (r117 == true) goto L25;
        r111 = r117;
    L25:
        int r118 = (r116 + r111) * 31;
        String r119 = this.f18636i;
        if (r119 == null) goto L28;
        int r120 = r119.hashCode();
    L29:
        int r121 = (r118 + r120) * 31;
        Integer r122 = this.f18637j;
        if (r122 == null) goto L32;
        int r123 = r122.hashCode();
    L33:
        int r124 = (r121 + r123) * 31;
        String r125 = this.f18638k;
        if (r125 == null) goto L36;
        int r126 = r125.hashCode();
    L37:
        int r127 = (r124 + r126) * 31;
        Integer r128 = this.f18639l;
        if (r128 == null) goto L41;
        r101 = r128.hashCode();
    L41:
        return r127 + r101;
    L36:
        r126 = 0;
        goto L37
    L32:
        r123 = 0;
        goto L33
    L28:
        r120 = 0;
        goto L29
    L20:
        r115 = 0;
        goto L21
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
        return "TakeOverInfo(takeOverView=" + this.f18628a + ", takeOverBgView=" + this.f18629b + ", uid=" + this.f18630c + ", useCustomVector=" + this.f18631d + ", customX=" + this.f18632e + ", customY=" + this.f18633f + ", avatarUrl=" + this.f18634g + ", noAvatar=" + this.f18635h + ", shape=" + this.f18636i + ", radius=" + this.f18637j + ", linkType=" + this.f18638k + ", position=" + this.f18639l + ")";
    }

    public c(View r110, HSImageView r111, String r112, boolean r113, float r114, float r115, String r116, boolean r117, String r210, Integer r211, String r212, Integer r213, int r214) {
        if ((r214 & 8) == 0) goto L5;
        boolean r100 = false;
    L6:
        float r101 = 0.0f;
        if ((r214 & 16) == 0) goto L9;
        float r102 = 0.0f;
    L11:
        if ((r214 & 32) != 0) goto L15;
        r101 = r115;
    L15:
        if ((r214 & 64) == 0) goto L17;
        String r103 = null;
    L19:
        if ((r214 & 128) == 0) goto L21;
        boolean r104 = false;
    L23:
        if ((r214 & 256) == 0) goto L25;
        String r105 = SVGRenderEngine.CIRCLE;
    L27:
        if ((r214 & 512) == 0) goto L29;
        Integer r106 = 0;
    L31:
        if ((r214 & 1024) == 0) goto L33;
        String r107 = "";
    L35:
        if ((r214 & 2048) == 0) goto L37;
        Integer r108 = -1;
    L38:
        Intrinsics.checkNotNullParameter(r107, "linkType");
        this.f18628a = r110;
        this.f18629b = r111;
        this.f18630c = r112;
        this.f18631d = r100;
        this.f18632e = r102;
        this.f18633f = r101;
        this.f18634g = r103;
        this.f18635h = r104;
        this.f18636i = r105;
        this.f18637j = r106;
        this.f18638k = r107;
        this.f18639l = r108;
        return;
    L37:
        r108 = r213;
        goto L38
    L33:
        r107 = r212;
        goto L35
    L29:
        r106 = r211;
        goto L31
    L25:
        r105 = r210;
        goto L27
    L21:
        r104 = r117;
        goto L23
    L17:
        r103 = r116;
        goto L19
    L9:
        r102 = r114;
        goto L11
    L5:
        r100 = r113;
        goto L6
    }
}
