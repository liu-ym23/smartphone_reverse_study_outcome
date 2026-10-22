package com.baidu.mapsdkplatform.comapi.map;

import android.os.Bundle;
import com.baidu.mapapi.map.WinRound;
import com.baidu.platform.comapi.basestruct.Point;
import com.stepos.activeview.moveline.item.ViewTweenItem;
import com.stepos.alphame.utils.Property;

/* loaded from: classes.dex */
public class s {

    /* renamed from: m, reason: collision with root package name */
    public double f8111m;

    /* renamed from: n, reason: collision with root package name */
    public double f8112n;

    /* renamed from: o, reason: collision with root package name */
    public int f8113o;

    /* renamed from: p, reason: collision with root package name */
    public String f8114p;

    /* renamed from: q, reason: collision with root package name */
    public float f8115q;

    /* renamed from: r, reason: collision with root package name */
    public boolean f8116r;

    /* renamed from: s, reason: collision with root package name */
    public int f8117s;

    /* renamed from: a, reason: collision with root package name */
    public float f8099a = 12.0f;

    /* renamed from: b, reason: collision with root package name */
    public int f8100b = 0;

    /* renamed from: c, reason: collision with root package name */
    public int f8101c = 0;

    /* renamed from: d, reason: collision with root package name */
    public double f8102d = 1.2958162E7d;

    /* renamed from: e, reason: collision with root package name */
    public double f8103e = 4825907.0d;

    /* renamed from: h, reason: collision with root package name */
    public float f8106h = Property.DEFAULT_FLOAT_VALUE;

    /* renamed from: i, reason: collision with root package name */
    public float f8107i = Property.DEFAULT_FLOAT_VALUE;

    /* renamed from: f, reason: collision with root package name */
    public int f8104f = -1;

    /* renamed from: g, reason: collision with root package name */
    public int f8105g = -1;

    /* renamed from: j, reason: collision with root package name */
    public WinRound f8108j = new WinRound();

    /* renamed from: k, reason: collision with root package name */
    public a f8109k = new a();

    /* renamed from: l, reason: collision with root package name */
    public boolean f8110l = false;

    public class a {

        /* renamed from: a, reason: collision with root package name */
        public long f8118a = 0;

        /* renamed from: b, reason: collision with root package name */
        public long f8119b = 0;

        /* renamed from: c, reason: collision with root package name */
        public long f8120c = 0;

        /* renamed from: d, reason: collision with root package name */
        public long f8121d = 0;

        /* renamed from: e, reason: collision with root package name */
        public Point f8122e = new Point(0, 0);

        /* renamed from: f, reason: collision with root package name */
        public Point f8123f = new Point(0, 0);

        /* renamed from: g, reason: collision with root package name */
        public Point f8124g = new Point(0, 0);

        /* renamed from: h, reason: collision with root package name */
        public Point f8125h = new Point(0, 0);

        public a() {
        }
    }

    public void a(Bundle bundle) {
        int i4;
        if (bundle == null) {
            return;
        }
        this.f8099a = (float) bundle.getDouble("level");
        this.f8100b = (int) bundle.getDouble("rotation");
        this.f8101c = (int) bundle.getDouble("overlooking");
        this.f8102d = bundle.getDouble("centerptx");
        this.f8103e = bundle.getDouble("centerpty");
        this.f8108j.left = bundle.getInt(ViewTweenItem.LEFT);
        this.f8108j.right = bundle.getInt("right");
        this.f8108j.top = bundle.getInt(ViewTweenItem.TOP);
        this.f8108j.bottom = bundle.getInt("bottom");
        this.f8106h = bundle.getFloat("xoffset");
        float f4 = bundle.getFloat("yoffset");
        this.f8107i = f4;
        WinRound winRound = this.f8108j;
        int i5 = winRound.right;
        if (i5 != 0 && (i4 = winRound.bottom) != 0) {
            int i6 = (i5 - winRound.left) / 2;
            int i7 = (i4 - winRound.top) / 2;
            this.f8104f = ((int) this.f8106h) + i6;
            this.f8105g = ((int) (-f4)) + i7;
        }
        this.f8109k.f8118a = bundle.getLong("gleft");
        this.f8109k.f8119b = bundle.getLong("gright");
        this.f8109k.f8120c = bundle.getLong("gtop");
        this.f8109k.f8121d = bundle.getLong("gbottom");
        a aVar = this.f8109k;
        if (aVar.f8118a <= -20037508) {
            aVar.f8118a = -20037508L;
        }
        if (aVar.f8119b >= 20037508) {
            aVar.f8119b = 20037508L;
        }
        if (aVar.f8120c >= 20037508) {
            aVar.f8120c = 20037508L;
        }
        if (aVar.f8121d <= -20037508) {
            aVar.f8121d = -20037508L;
        }
        Point point = aVar.f8122e;
        double d4 = aVar.f8118a;
        point.doubleX = d4;
        double d5 = aVar.f8121d;
        point.doubleY = d5;
        Point point2 = aVar.f8123f;
        point2.doubleX = d4;
        double d6 = aVar.f8120c;
        point2.doubleY = d6;
        Point point3 = aVar.f8124g;
        double d7 = aVar.f8119b;
        point3.doubleX = d7;
        point3.doubleY = d6;
        Point point4 = aVar.f8125h;
        point4.doubleX = d7;
        point4.doubleY = d5;
        this.f8110l = bundle.getInt("bfpp") == 1;
        this.f8111m = bundle.getFloat("adapterZoomUnits");
        this.f8112n = bundle.getDouble("zoomunit");
        this.f8114p = bundle.getString("panoid");
        this.f8115q = bundle.getFloat("siangle");
        this.f8116r = bundle.getInt("isbirdeye") != 0;
        this.f8117s = bundle.getInt("ssext");
    }

    public Bundle a(b bVar) {
        int i4;
        int i5;
        WinRound winRound;
        int i6;
        int i7;
        float f4 = this.f8099a;
        float f5 = bVar.f8003e;
        if (f4 < f5) {
            this.f8099a = f5;
        }
        float f6 = this.f8099a;
        float f7 = bVar.f8002d;
        if (f6 > f7) {
            if (f6 != 1096.0f && b.f7975a != 26.0f) {
                this.f8099a = f7;
            } else {
                this.f8099a = 26.0f;
                b.f7975a = 26.0f;
            }
        }
        while (true) {
            i4 = this.f8100b;
            if (i4 >= 0) {
                break;
            }
            this.f8100b = i4 + 360;
        }
        this.f8100b = i4 % 360;
        if (this.f8101c > 0) {
            this.f8101c = 0;
        }
        if (this.f8101c < -45) {
            this.f8101c = -45;
        }
        Bundle bundle = new Bundle();
        bundle.putDouble("level", this.f8099a);
        bundle.putDouble("rotation", this.f8100b);
        bundle.putDouble("overlooking", this.f8101c);
        bundle.putDouble("centerptx", this.f8102d);
        bundle.putDouble("centerpty", this.f8103e);
        bundle.putInt(ViewTweenItem.LEFT, this.f8108j.left);
        bundle.putInt("right", this.f8108j.right);
        bundle.putInt(ViewTweenItem.TOP, this.f8108j.top);
        bundle.putInt("bottom", this.f8108j.bottom);
        int i8 = this.f8104f;
        if (i8 >= 0 && (i5 = this.f8105g) >= 0 && i8 <= (i6 = (winRound = this.f8108j).right) && i5 <= (i7 = winRound.bottom) && i6 > 0 && i7 > 0) {
            int i9 = (i6 - winRound.left) / 2;
            int i10 = i5 - ((i7 - winRound.top) / 2);
            float f8 = i8 - i9;
            this.f8106h = f8;
            this.f8107i = -i10;
            bundle.putFloat("xoffset", f8);
            bundle.putFloat("yoffset", this.f8107i);
        }
        bundle.putInt("lbx", this.f8109k.f8122e.getIntX());
        bundle.putInt("lby", this.f8109k.f8122e.getIntY());
        bundle.putInt("ltx", this.f8109k.f8123f.getIntX());
        bundle.putInt("lty", this.f8109k.f8123f.getIntY());
        bundle.putInt("rtx", this.f8109k.f8124g.getIntX());
        bundle.putInt("rty", this.f8109k.f8124g.getIntY());
        bundle.putInt("rbx", this.f8109k.f8125h.getIntX());
        bundle.putInt("rby", this.f8109k.f8125h.getIntY());
        bundle.putLong("gleft", this.f8109k.f8118a);
        bundle.putLong("gbottom", this.f8109k.f8121d);
        bundle.putLong("gtop", this.f8109k.f8120c);
        bundle.putLong("gright", this.f8109k.f8119b);
        bundle.putInt("bfpp", this.f8110l ? 1 : 0);
        bundle.putInt("animation", 1);
        bundle.putInt("animatime", this.f8113o);
        bundle.putString("panoid", this.f8114p);
        bundle.putInt("autolink", 0);
        bundle.putFloat("siangle", this.f8115q);
        bundle.putInt("isbirdeye", this.f8116r ? 1 : 0);
        bundle.putInt("ssext", this.f8117s);
        return bundle;
    }
}
