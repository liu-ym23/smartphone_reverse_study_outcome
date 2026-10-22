package cjc;

import android.util.Pair;
import android.view.View;
import com.ss.android.videoshop.mediaview.SurfaceContainerLayout;

/* JADX INFO: loaded from: classes40.dex */
public final class h {

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static String f24001p = "VideoViewOperator";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f24002a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f24003b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f24004c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f24005d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f24006e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f24007f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f24008g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public float f24009h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public float f24010i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f24011j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public gjc.a f24012k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public float[] f24013l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f24014m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f24015n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f24016o;

    public final float a() {
        int r100 = this.f24007f;
        if (r100 == 0) goto L17;
        int r101 = this.f24003b;
        if (r101 != 0) goto L8;
        return 0.0f;
    L8:
        if (this.f24012k != null) goto L15;
        float r102 = this.f24008g / r100;
        float r103 = this.f24004c / r101;
        Pair<Integer, Integer> r104 = b();
        int r105 = ((Integer) r104.first).intValue();
        int r106 = ((Integer) r104.second).intValue();
        if (r103 <= r102) goto L12;
        float r107 = this.f24007f * 1.0f;
        float r108 = r105;
    L14:
        return r107 / r108;
    L12:
        r107 = this.f24008g * 1.0f;
        r108 = r106;
        goto L14
    L15:
        int r109 = ((Integer) b().first).intValue();
        gjc.a r110 = this.f24012k;
        return this.f24007f / ((r110.f481514b - r110.f481513a) * r109);
    L17:
        return 0.0f;
    }

    public final Pair<Integer, Integer> b() {
        int r100 = this.f24003b;
        if (r100 <= 0) goto L14;
        int r101 = this.f24004c;
        if (r101 <= 0) goto L14;
        int r102 = this.f24008g;
        int r103 = this.f24007f;
        int r104 = (int) (r101 * ((r103 * 1.0f) / r100));
        if (r104 <= r102) goto L10;
        r103 = (int) (r100 * ((r102 * 1.0f) / r101));
    L12:
        return new Pair(Integer.valueOf(r103), Integer.valueOf(r102));
    L10:
        r102 = r104;
    L14:
        return new Pair(0, 0);
    }

    public final float c() {
        if (this.f24011j == 2) goto L7;
        return 1.0f;
    L7:
        return a();
    }

    public final float d() {
        return (this.f24002a.getLeft() + ((this.f24002a.getWidth() - (this.f24002a.getWidth() * this.f24002a.getScaleX())) / 2.0f)) + this.f24002a.getTranslationX();
    }

    public final float e() {
        return (this.f24002a.getTop() + ((this.f24002a.getHeight() - (this.f24002a.getHeight() * this.f24002a.getScaleY())) / 2.0f)) + this.f24002a.getTranslationY();
    }

    public final void h(int r100) {
        ajc.b.a(f24001p, "Set TextureLayout. oldTextureLayout=" + this.f24011j + ", newTextureLayout=" + r100);
        if (this.f24011j == r100) goto L5;
        this.f24011j = r100;
        this.f24002a.requestLayout();
    L5:
        ajc.b.a(f24001p, "Set TextureLayout and requestLayout.");
        ajc.b.a(f24001p, "Set TextureLayout over. parentSize:" + this.f24007f + "*" + this.f24008g + ", videoSize:" + this.f24003b + "*" + this.f24004c + ", newScaleFactor:" + c() + ", newScaledSize:" + (this.f24005d * c()) + "*" + (this.f24006e * c()));
    }

    public h(View r100, b r101) {
        this.f24009h = Float.MAX_VALUE;
        this.f24010i = 0.0f;
        this.f24011j = 0;
        this.f24014m = true;
        this.f24015n = false;
        this.f24016o = true;
        this.f24002a = r100;
        f24001p = r100.getClass().getSimpleName();
    }

    public final boolean g(float[] r100, float r101) {
        int r102 = this.f24008g;
        float r103 = r102;
        float r104 = (((-(r101 - 1.0f)) / 2.0f) * r103) + r100[1];
        float r105 = (r103 * r101) + r104;
        if (r104 < 2.0f) goto L5;
    L7:
        return false;
    L5:
        if (r105 <= (r102 - 2)) goto L7;
        return true;
    }

    public final void i(int r100, int r101) {
        if (this.f24003b == r100) goto L5;
    L6:
        this.f24003b = r100;
        this.f24004c = r101;
        this.f24005d = 0;
        this.f24006e = 0;
        ajc.b.a(f24001p, "setVideoSize videoWidth:" + r100 + " videoHeight:" + r101);
        this.f24002a.requestLayout();
        return;
    L5:
        if (this.f24004c != r101) goto L6;
    }

    public final Pair<Integer, Integer> f(int r110, int r111, int r112, int r113) {
        ajc.b.c(f24001p, "widthMeasureSpec:" + View.MeasureSpec.toString(r110));
        ajc.b.c(f24001p, "heightMeasureSpec:" + View.MeasureSpec.toString(r111));
        int r100 = View.MeasureSpec.getMode(r110);
        int r114 = View.MeasureSpec.getSize(r110);
        int r101 = View.MeasureSpec.getMode(r111);
        int r115 = View.MeasureSpec.getSize(r111);
        if (r100 != 1073741824) goto L5;
        r112 = r114;
    L7:
        if (r101 != 1073741824) goto L9;
        r113 = r115;
    L11:
        this.f24007f = r112;
        this.f24008g = r113;
        this.f24013l = null;
        this.f24002a.setTranslationX(0.0f);
        this.f24002a.setTranslationY(0.0f);
        float r116 = this.f24002a.getScaleX();
        int r117 = this.f24011j;
        if (r117 == 1) goto L100;
        int r102 = this.f24003b;
        if (r102 <= 0) goto L100;
        int r103 = this.f24004c;
        if (r103 <= 0) goto L100;
        int r104 = 0;
        if (r117 == (-1)) goto L25;
        if (r117 == 0) goto L25;
        if (r117 == 2) goto L25;
        int r118 = 0;
    L101:
        int r105 = this.f24005d;
        if (r105 != r104) goto L110;
        int r106 = this.f24006e;
        if (r106 != r118) goto L110;
        if ((this.f24002a instanceof SurfaceContainerLayout) == false) goto L112;
        int r107 = r105 + 1;
        int r108 = r106 + 1;
        this.f24005d = r107;
        this.f24006e = r108;
        ajc.b.a(f24001p, "set dummy dimension:" + r107 + "*" + r108);
        return new Pair(Integer.valueOf(r107), Integer.valueOf(r108));
    L112:
        return new Pair(Integer.valueOf(r104), Integer.valueOf(r118));
    L110:
        this.f24005d = r104;
        this.f24006e = r118;
        ajc.b.a(f24001p, "sv_size_Measure:" + r104 + "*" + r118 + " Parent:" + r112 + "*" + r113 + " textureLayout:" + this.f24011j + " Video:" + this.f24003b + "*" + this.f24004c + " scaleFactor:" + r116 + " scaled_size:" + (r104 * r116) + "*" + (r118 * r116));
    L25:
        if (this.f24016o == false) goto L78;
        Pair<Integer, Integer> r119 = b();
        float r109 = c();
        if (Math.abs(r116 - r109) >= 1.0E-5f) goto L29;
        boolean r120 = true;
    L30:
        if (r120 == true) goto L41;
        if (Float.isNaN(r109) == false) goto L34;
        float r121 = this.f24010i;
    L36:
        if (Float.isNaN(r109) == false) goto L38;
        float r122 = this.f24010i;
    L39:
        this.f24002a.setScaleX(r121);
        this.f24002a.setScaleY(r122);
        r116 = r109;
        goto L41
    L38:
        r122 = Math.max(Math.min(r109, this.f24009h), this.f24010i);
        goto L39
    L34:
        r121 = Math.max(Math.min(r109, this.f24009h), this.f24010i);
    L41:
        if (this.f24011j != 2) goto L99;
        float[] r123 = {0.0f, 0.0f};
        gjc.a r124 = this.f24012k;
        if (r124 == null) goto L71;
        if (this.f24013l != null) goto L74;
        int r125 = this.f24007f;
        if (r125 == 0) goto L76;
        if (this.f24008g == 0) goto L76;
        int r126 = this.f24003b;
        if (r126 == 0) goto L76;
        float r127 = r124.f481514b - r124.f481513a;
        float r128 = r125 / (r126 * r127);
        if (Math.abs(r127 - 1.0f) >= 1.0E-5f) goto L56;
        boolean r129 = true;
    L57:
        if (r129 == true) goto L59;
        float r130 = this.f24003b;
        gjc.a r131 = this.f24012k;
        r123[0] = ((r130 / 2.0f) - (((r131.f481514b + r131.f481513a) / 2.0f) * r130)) * r128;
    L59:
        gjc.a r132 = this.f24012k;
        if (Math.abs((r132.f481516d - r132.f481515c) - 1.0f) >= 1.0E-5f) goto L62;
        boolean r133 = true;
    L63:
        if (r133 == true) goto L65;
        float r134 = this.f24004c;
        gjc.a r135 = this.f24012k;
        r123[1] = ((r134 / 2.0f) - (((r135.f481516d + r135.f481515c) / 2.0f) * r134)) * r128;
    L65:
        this.f24013l = r123;
        if (this.f24014m == false) goto L74;
        if (g(r123, this.f24002a.getScaleX()) == true) goto L74;
        this.f24013l[1] = ((-(this.f24002a.getScaleX() - 1.0f)) / 2.0f) * this.f24008g;
        goto L74
    L62:
        r133 = false;
        goto L63
    L56:
        r129 = false;
    L76:
        if (g(r123, r116) == false) goto L99;
        this.f24002a.setTranslationX(r123[0]);
        this.f24002a.setTranslationY(r123[1]);
    L74:
        r123 = this.f24013l;
        goto L76
    L71:
        if (this.f24015n == false) goto L73;
        r123[1] = ((-(this.f24002a.getScaleX() - 1.0f)) / 2.0f) * this.f24008g;
    L73:
        this.f24013l = r123;
    L99:
        r104 = ((Integer) r119.first).intValue();
        r118 = ((Integer) r119.second).intValue();
        goto L101
    L29:
        r120 = false;
        goto L30
    L78:
        if (r117 != 0) goto L80;
        r119 = b();
    L91:
        if (Float.isNaN(1.0f) == false) goto L93;
        float r136 = this.f24010i;
    L95:
        if (Float.isNaN(1.0f) == false) goto L97;
        float r137 = this.f24010i;
    L98:
        this.f24002a.setScaleX(r136);
        this.f24002a.setScaleY(r137);
        goto L99
    L97:
        r137 = Math.max(Math.min(1.0f, this.f24009h), this.f24010i);
        goto L98
    L93:
        r136 = Math.max(Math.min(1.0f, this.f24009h), this.f24010i);
        goto L95
    L80:
        if (r102 <= 0) goto L88;
        if (r103 <= 0) goto L88;
        int r138 = this.f24008g;
        float r139 = r138;
        int r140 = this.f24007f;
        float r141 = r140;
        float r142 = r103;
        float r143 = r102;
        if ((r142 / r143) <= (r139 / r141)) goto L86;
        r138 = (int) (r142 * ((r141 * 1.0f) / r143));
    L87:
        Pair<Integer, Integer> r144 = new Pair(Integer.valueOf(r140), Integer.valueOf(r138));
    L89:
        r119 = r144;
        goto L91
    L86:
        r140 = (int) (r143 * ((r139 * 1.0f) / r142));
    L88:
        r144 = new Pair(0, 0);
    L100:
        r104 = r112;
        r118 = r113;
        goto L101
    L9:
        if (r101 != Integer.MIN_VALUE) goto L11;
        r113 = Math.min(r113, r115);
        goto L11
    L5:
        if (r100 != Integer.MIN_VALUE) goto L7;
        r112 = Math.min(r112, r114);
        goto L7
    }
}
