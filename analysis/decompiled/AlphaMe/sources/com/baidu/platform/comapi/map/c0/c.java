package com.baidu.platform.comapi.map.c0;

import com.baidu.platform.comapi.basestruct.GeoPoint;
import com.baidu.platform.comapi.map.MapController;
import com.baidu.platform.comapi.map.MapViewInterface;
import java.util.IllegalFormatException;

/* loaded from: classes.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    private float f9071a;

    /* renamed from: b, reason: collision with root package name */
    private StringBuffer f9072b = new StringBuffer();

    /* renamed from: c, reason: collision with root package name */
    private StringBuffer f9073c = new StringBuffer();

    /* renamed from: d, reason: collision with root package name */
    private MapController f9074d;

    public static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f9075a;

        static {
            int[] iArr = new int[b.values().length];
            f9075a = iArr;
            try {
                iArr[b.MOVE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f9075a[b.FLING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f9075a[b.ZOOM_OUT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f9075a[b.ZOOM_IN.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f9075a[b.ROTATE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f9075a[b.DOUBLE_CLICK_ZOOM_IN.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f9075a[b.TWO_CLICK_ZOOM_OUT.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f9075a[b.MOVE_OVERLOOK.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
        }
    }

    public enum b {
        ZOOM_OUT,
        ZOOM_IN,
        FLING,
        MOVE,
        ROTATE,
        DOUBLE_CLICK_ZOOM_IN,
        TWO_CLICK_ZOOM_OUT,
        MOVE_OVERLOOK
    }

    public c(MapController mapController) {
        this.f9074d = mapController;
    }

    private void d(float f4) {
        this.f9071a = f4;
    }

    private boolean e(float f4) {
        return f4 < this.f9071a;
    }

    private boolean f(float f4) {
        return f4 > this.f9071a;
    }

    public void a() {
        a(b.FLING);
    }

    public void b(float f4) {
        a(b.TWO_CLICK_ZOOM_OUT);
        d(f4);
    }

    public void c(float f4) {
        if (f(f4)) {
            a(b.ZOOM_OUT);
        }
        if (e(f4)) {
            a(b.ZOOM_IN);
        }
        d(f4);
    }

    public void a(float f4) {
        a(b.DOUBLE_CLICK_ZOOM_IN);
        d(f4);
    }

    public void d() {
        a(b.MOVE);
    }

    public void b() {
        a(b.MOVE_OVERLOOK);
    }

    private void a(b bVar) {
        MapViewInterface mapView;
        String strB;
        MapController mapController = this.f9074d;
        if (mapController == null || (mapView = mapController.getMapView()) == null) {
            return;
        }
        GeoPoint mapCenter = mapView.getMapCenter();
        try {
            strB = String.format("(%s,%d,%d,%d,%d)", b(bVar), Double.valueOf(mapCenter.getLongitudeE6()), Double.valueOf(mapCenter.getLatitudeE6()), Integer.valueOf((int) mapView.getZoomLevel()), Long.valueOf(System.currentTimeMillis()));
        } catch (IllegalFormatException unused) {
            strB = b(bVar);
        }
        StringBuffer stringBuffer = this.f9072b;
        if (stringBuffer == null) {
            return;
        }
        stringBuffer.append(strB);
        StringBuffer stringBuffer2 = this.f9073c;
        if (stringBuffer2 == null) {
            return;
        }
        stringBuffer2.append(b(bVar));
    }

    private String b(b bVar) {
        switch (a.f9075a[bVar.ordinal()]) {
            case 1:
            case 2:
                return "0";
            case 3:
                return "1";
            case 4:
                return "2";
            case 5:
                return "3";
            case 6:
                return "4";
            case 7:
                return "5";
            case 8:
                return "6";
            default:
                return "";
        }
    }

    public void c() {
        a(b.ROTATE);
    }
}
