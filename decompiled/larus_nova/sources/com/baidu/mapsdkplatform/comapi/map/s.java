package com.baidu.mapsdkplatform.comapi.map;

import android.os.Bundle;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.baidu.mapapi.map.WinRound;
import com.baidu.platform.comapi.basestruct.Point;

/* JADX INFO: loaded from: classes39.dex */
public class s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f32200a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f32201b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f32202c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public double f32203d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public double f32204e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f32205f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f32206g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public float f32207h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public float f32208i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public WinRound f32209j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public a f32210k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f32211l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public double f32212m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public double f32213n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f32214o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public String f32215p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public float f32216q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f32217r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public int f32218s;

    public class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public long f32219a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public long f32220b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public long f32221c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public long f32222d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public Point f32223e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public Point f32224f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public Point f32225g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public Point f32226h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        final /* synthetic */ s f32227i;

        public a(s r100) {
            this.f32227i = r100;
            this.f32219a = 0;
            this.f32220b = 0;
            this.f32221c = 0;
            this.f32222d = 0;
            this.f32223e = new Point(0, 0);
            this.f32224f = new Point(0, 0);
            this.f32225g = new Point(0, 0);
            this.f32226h = new Point(0, 0);
        }
    }

    public s() {
        this.f32200a = 12.0f;
        this.f32201b = 0;
        this.f32202c = 0;
        this.f32203d = 1.2958162E7d;
        this.f32204e = 4825907.0d;
        this.f32207h = 0.0f;
        this.f32208i = 0.0f;
        this.f32205f = -1;
        this.f32206g = -1;
        this.f32209j = new WinRound();
        this.f32210k = new a(this);
        this.f32211l = false;
    }

    public Bundle a(b r100) {
        float r101 = this.f32200a;
        float r102 = r100.f32104e;
        if (r101 >= r102) goto L5;
        this.f32200a = r102;
    L5:
        float r103 = this.f32200a;
        float r104 = r100.f32103d;
        if (r103 <= r104) goto L14;
        if (r103 != 1096.0f) goto L10;
    L13:
        this.f32200a = 26.0f;
        b.f32099a = 26.0f;
        goto L14
    L10:
        if (b.f32099a == 26.0f) goto L13;
        this.f32200a = r104;
    L14:
        int r105 = this.f32201b;
        if (r105 >= 0) goto L17;
        this.f32201b = r105 + 360;
        goto L14
    L17:
        this.f32201b = r105 % 360;
        if (this.f32202c <= 0) goto L21;
        this.f32202c = 0;
    L21:
        if (this.f32202c >= (-80)) goto L23;
        this.f32202c = -80;
    L23:
        Bundle r106 = new Bundle();
        r106.putDouble("level", this.f32200a);
        r106.putDouble("rotation", this.f32201b);
        r106.putDouble("overlooking", this.f32202c);
        r106.putDouble("centerptx", this.f32203d);
        r106.putDouble("centerpty", this.f32204e);
        r106.putInt("left", this.f32209j.left);
        r106.putInt("right", this.f32209j.right);
        r106.putInt("top", this.f32209j.top);
        r106.putInt("bottom", this.f32209j.bottom);
        int r107 = this.f32205f;
        if (r107 < 0) goto L34;
        int r108 = this.f32206g;
        if (r108 < 0) goto L34;
        WinRound r109 = this.f32209j;
        int r110 = r109.right;
        if (r107 > r110) goto L34;
        int r111 = r109.bottom;
        if (r108 > r111) goto L34;
        if (r110 <= 0) goto L34;
        if (r111 <= 0) goto L34;
        int r112 = (r110 - r109.left) / 2;
        int r113 = r108 - ((r111 - r109.top) / 2);
        float r114 = r107 - r112;
        this.f32207h = r114;
        this.f32208i = -r113;
        r106.putFloat("xoffset", r114);
        r106.putFloat("yoffset", this.f32208i);
    L34:
        r106.putInt("lbx", this.f32210k.f32223e.getIntX());
        r106.putInt("lby", this.f32210k.f32223e.getIntY());
        r106.putInt("ltx", this.f32210k.f32224f.getIntX());
        r106.putInt("lty", this.f32210k.f32224f.getIntY());
        r106.putInt("rtx", this.f32210k.f32225g.getIntX());
        r106.putInt("rty", this.f32210k.f32225g.getIntY());
        r106.putInt("rbx", this.f32210k.f32226h.getIntX());
        r106.putInt("rby", this.f32210k.f32226h.getIntY());
        r106.putLong("gleft", this.f32210k.f32219a);
        r106.putLong("gbottom", this.f32210k.f32222d);
        r106.putLong("gtop", this.f32210k.f32221c);
        r106.putLong("gright", this.f32210k.f32220b);
        r106.putInt("bfpp", this.f32211l ? 1 : 0);
        r106.putInt(GXTemplateKey.GAIAX_ANIMATION, 1);
        r106.putInt("animatime", this.f32214o);
        r106.putString("panoid", this.f32215p);
        r106.putInt("autolink", 0);
        r106.putFloat("siangle", this.f32216q);
        r106.putInt("isbirdeye", this.f32217r ? 1 : 0);
        r106.putInt("ssext", this.f32218s);
        return r106;
    }

    public void a(Bundle r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        this.f32200a = (float) r100.getDouble("level");
        this.f32201b = (int) r100.getDouble("rotation");
        this.f32202c = (int) r100.getDouble("overlooking");
        this.f32203d = r100.getDouble("centerptx");
        this.f32204e = r100.getDouble("centerpty");
        this.f32209j.left = r100.getInt("left");
        this.f32209j.right = r100.getInt("right");
        this.f32209j.top = r100.getInt("top");
        this.f32209j.bottom = r100.getInt("bottom");
        this.f32207h = r100.getFloat("xoffset");
        float r101 = r100.getFloat("yoffset");
        this.f32208i = r101;
        WinRound r102 = this.f32209j;
        int r103 = r102.right;
        if (r103 == 0) goto L9;
        int r104 = r102.bottom;
        if (r104 == 0) goto L9;
        int r105 = (r103 - r102.left) / 2;
        int r106 = (r104 - r102.top) / 2;
        this.f32205f = ((int) this.f32207h) + r105;
        this.f32206g = ((int) (-r101)) + r106;
    L9:
        this.f32210k.f32219a = r100.getLong("gleft");
        this.f32210k.f32220b = r100.getLong("gright");
        this.f32210k.f32221c = r100.getLong("gtop");
        this.f32210k.f32222d = r100.getLong("gbottom");
        a r107 = this.f32210k;
        if (r107.f32219a > (-20037508)) goto L13;
        r107.f32219a = -20037508;
    L13:
        if (r107.f32220b < 20037508) goto L16;
        r107.f32220b = 20037508;
    L16:
        if (r107.f32221c < 20037508) goto L19;
        r107.f32221c = 20037508;
    L19:
        if (r107.f32222d > (-20037508)) goto L21;
        r107.f32222d = -20037508;
    L21:
        Point r108 = r107.f32223e;
        double r109 = r107.f32219a;
        r108.doubleX = r109;
        double r110 = r107.f32222d;
        r108.doubleY = r110;
        Point r111 = r107.f32224f;
        r111.doubleX = r109;
        double r112 = r107.f32221c;
        r111.doubleY = r112;
        Point r113 = r107.f32225g;
        double r114 = r107.f32220b;
        r113.doubleX = r114;
        r113.doubleY = r112;
        Point r115 = r107.f32226h;
        r115.doubleX = r114;
        r115.doubleY = r110;
        boolean r116 = false;
        if (r100.getInt("bfpp") != 1) goto L24;
        boolean r117 = true;
    L25:
        this.f32211l = r117;
        this.f32212m = r100.getFloat("adapterZoomUnits");
        this.f32213n = r100.getDouble("zoomunit");
        this.f32215p = r100.getString("panoid");
        this.f32216q = r100.getFloat("siangle");
        if (r100.getInt("isbirdeye") == 0) goto L28;
        r116 = true;
    L28:
        this.f32217r = r116;
        this.f32218s = r100.getInt("ssext");
        return;
    L24:
        r117 = false;
        goto L25
    }
}
