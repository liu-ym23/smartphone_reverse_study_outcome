package com.baidu.platform.comapi.map.c0;

import com.baidu.platform.comapi.basestruct.GeoPoint;
import com.baidu.platform.comapi.map.MapController;
import com.baidu.platform.comapi.map.MapViewInterface;
import java.util.IllegalFormatException;

/* JADX INFO: loaded from: classes39.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private float f33176a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private StringBuffer f33177b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private StringBuffer f33178c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private MapController f33179d;

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f33180a = null;

        static {
            int[] r100 = new int[b.values().length];
            f33180a = r100;
            r100[b.f33184d.ordinal()] = 1;     // Catch: NoSuchFieldError -> L12
        L20:
            f33180a[b.f33183c.ordinal()] = 2;     // Catch: NoSuchFieldError -> L13
        L24:
            f33180a[b.f33181a.ordinal()] = 3;     // Catch: NoSuchFieldError -> L14
        L34:
            f33180a[b.f33182b.ordinal()] = 4;     // Catch: NoSuchFieldError -> L15
        L22:
            f33180a[b.f33185e.ordinal()] = 5;     // Catch: NoSuchFieldError -> L16
        L26:
            f33180a[b.f33186f.ordinal()] = 6;     // Catch: NoSuchFieldError -> L17
        L28:
            f33180a[b.f33187g.ordinal()] = 7;     // Catch: NoSuchFieldError -> L18
        L30:
            f33180a[b.f33188h.ordinal()] = 8;     // Catch: NoSuchFieldError -> L19
            return;
        }
    }

    public static final enum b extends Enum<b> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f33181a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final b f33182b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final b f33183c = null;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final b f33184d = null;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final b f33185e = null;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final b f33186f = null;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final b f33187g = null;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public static final b f33188h = null;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private static final /* synthetic */ b[] f33189i = null;

        static {
            b r100 = new b("ZOOM_OUT", 0);
            f33181a = r100;
            b r101 = new b("ZOOM_IN", 1);
            f33182b = r101;
            b r102 = new b("FLING", 2);
            f33183c = r102;
            b r103 = new b("MOVE", 3);
            f33184d = r103;
            b r104 = new b("ROTATE", 4);
            f33185e = r104;
            b r105 = new b("DOUBLE_CLICK_ZOOM_IN", 5);
            f33186f = r105;
            b r110 = new b("TWO_CLICK_ZOOM_OUT", 6);
            f33187g = r110;
            b r111 = new b("MOVE_OVERLOOK", 7);
            f33188h = r111;
            f33189i = new b[]{r100, r101, r102, r103, r104, r105, r110, r111};
        }

        public static b[] values() {
            return (b[]) f33189i.clone();
        }

        public static b valueOf(String r100) {
            return (b) r27.a.a(b.class, r100);
        }

        private b(String r100, int r101) {
            super(r100, r101);
        }
    }

    public void a() {
        a(b.f33183c);
    }

    public void b() {
        a(b.f33188h);
    }

    public void c() {
        a(b.f33185e);
    }

    public void d() {
        a(b.f33184d);
    }

    public c(MapController r100) {
        this.f33177b = new StringBuffer();
        this.f33178c = new StringBuffer();
        this.f33179d = r100;
    }

    private void a(b r100) {
        MapController r101 = this.f33179d;
        if (r101 != null) goto L5;
        return;
    L5:
        MapViewInterface r102 = r101.getMapView();
        if (r102 != null) goto L8;
        return;
    L8:
        GeoPoint r103 = r102.getMapCenter();
        String r104 = String.format("(%s,%d,%d,%d,%d)", new Object[]{b(r100), Double.valueOf(r103.getLongitudeE6()), Double.valueOf(r103.getLatitudeE6()), Integer.valueOf((int) r102.getZoomLevel()), Long.valueOf(System.currentTimeMillis())});     // Catch: IllegalFormatException -> L11
    L12:
        StringBuffer r105 = this.f33177b;
        if (r105 != null) goto L15;
        return;
    L15:
        r105.append(r104);
        StringBuffer r106 = this.f33178c;
        if (r106 != null) goto L18;
        return;
    L18:
        r106.append(b(r100));
        return;
    L11:
        r104 = b(r100);
        goto L12
    }

    private String b(b r100) {
        switch(a.f33180a[r100.ordinal()]) {
            case 1: goto L11;
            case 2: goto L11;
            case 3: goto L10;
            case 4: goto L9;
            case 5: goto L8;
            case 6: goto L7;
            case 7: goto L6;
            case 8: goto L5;
            default: goto L4;
        };
    L4:
        return "";
    L5:
        return "6";
    L6:
        return "5";
    L7:
        return "4";
    L8:
        return "3";
    L9:
        return "2";
    L10:
        return "1";
    L11:
        return "0";
    }

    private void d(float r100) {
        this.f33176a = r100;
    }

    private boolean e(float r100) {
        if (r100 >= this.f33176a) goto L5;
        return true;
    L5:
        return false;
    }

    private boolean f(float r100) {
        if (r100 <= this.f33176a) goto L5;
        return true;
    L5:
        return false;
    }

    public void c(float r100) {
        if (f(r100) == false) goto L6;
        a(b.f33181a);
    L6:
        if (e(r100) == false) goto L8;
        a(b.f33182b);
    L8:
        d(r100);
    }

    public void a(float r100) {
        a(b.f33186f);
        d(r100);
    }

    public void b(float r100) {
        a(b.f33187g);
        d(r100);
    }
}
