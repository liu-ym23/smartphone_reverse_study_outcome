package com.amap.api.maps.model;

import android.text.TextUtils;
import com.amap.api.col.jmsl.C1541c2;
import com.amap.api.col.jmsl.C1570k;
import com.amap.api.col.jmsl.W1;
import com.amap.api.maps.AMapUtils;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.List;

/* loaded from: classes.dex */
public class Polyline extends BaseOverlay {
    private WeakReference<W1> glOverlayLayerRef;
    private PolylineOptions options;

    public Polyline(W1 w12, PolylineOptions polylineOptions) {
        super("");
        this.glOverlayLayerRef = new WeakReference<>(w12);
        this.options = polylineOptions;
    }

    private void a() {
        try {
            synchronized (this) {
                try {
                    W1 w12 = this.glOverlayLayerRef.get();
                    if (!TextUtils.isEmpty(this.overlayName) && w12 != null) {
                        setOptionPointList(this.options);
                        w12.g(this.overlayName, this.options);
                    }
                } finally {
                }
            }
        } catch (Throwable unused) {
        }
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Polyline)) {
            return false;
        }
        try {
            if (super.equals(obj)) {
                return true;
            }
            return ((Polyline) obj).getId() == getId();
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    public int getColor() {
        try {
            PolylineOptions polylineOptions = this.options;
            if (polylineOptions != null) {
                return polylineOptions.getColor();
            }
            return 0;
        } catch (Throwable th) {
            th.printStackTrace();
            return 0;
        }
    }

    public String getId() {
        try {
            return this.overlayName;
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public LatLng getNearestLatLng(LatLng latLng) {
        List<LatLng> points;
        PolylineOptions polylineOptions = this.options;
        HashMap<String, Long> map = C1570k.f16700b;
        if (latLng != null && polylineOptions != null && (points = polylineOptions.getPoints()) != null && points.size() != 0) {
            float fCalculateLineDistance = 0.0f;
            int i10 = 0;
            for (int i11 = 0; i11 < points.size(); i11++) {
                try {
                    if (i11 == 0) {
                        fCalculateLineDistance = AMapUtils.calculateLineDistance(latLng, points.get(i11));
                    } else {
                        float fCalculateLineDistance2 = AMapUtils.calculateLineDistance(latLng, points.get(i11));
                        if (fCalculateLineDistance > fCalculateLineDistance2) {
                            i10 = i11;
                            fCalculateLineDistance = fCalculateLineDistance2;
                        }
                    }
                } catch (Throwable th) {
                    C1541c2.b(th, "PolylineDelegate", "getNearestLatLng");
                    th.printStackTrace();
                }
            }
            return points.get(i10);
        }
        return null;
    }

    public PolylineOptions getOptions() {
        return this.options;
    }

    public List<LatLng> getPoints() {
        try {
            PolylineOptions polylineOptions = this.options;
            if (polylineOptions != null) {
                return polylineOptions.getPoints();
            }
            return null;
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public float getWidth() {
        try {
            PolylineOptions polylineOptions = this.options;
            if (polylineOptions != null) {
                return polylineOptions.getWidth();
            }
            return 0.0f;
        } catch (Throwable th) {
            th.printStackTrace();
            return 0.0f;
        }
    }

    public float getZIndex() {
        try {
            PolylineOptions polylineOptions = this.options;
            if (polylineOptions != null) {
                return polylineOptions.getZIndex();
            }
            return 0.0f;
        } catch (Throwable th) {
            th.printStackTrace();
            return 0.0f;
        }
    }

    public int hashCode() {
        try {
            return super.hashCode();
        } catch (Throwable th) {
            th.printStackTrace();
            return 0;
        }
    }

    public boolean isDottedLine() {
        PolylineOptions polylineOptions = this.options;
        if (polylineOptions != null) {
            return polylineOptions.isDottedLine();
        }
        return false;
    }

    public boolean isGeodesic() {
        PolylineOptions polylineOptions = this.options;
        return polylineOptions != null && polylineOptions.isGeodesic();
    }

    public boolean isVisible() {
        try {
            PolylineOptions polylineOptions = this.options;
            if (polylineOptions != null) {
                return polylineOptions.isVisible();
            }
            return false;
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    public void remove() {
        try {
            W1 w12 = this.glOverlayLayerRef.get();
            if (w12 != null) {
                w12.q(this.overlayName);
            }
            this.overlayName = null;
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void setColor(int i10) {
        try {
            PolylineOptions polylineOptions = this.options;
            if (polylineOptions != null) {
                polylineOptions.color(i10);
                a();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void setDottedLine(boolean z10) {
        PolylineOptions polylineOptions = this.options;
        if (polylineOptions != null) {
            polylineOptions.setDottedLine(z10);
            a();
        }
    }

    public void setGeodesic(boolean z10) {
        try {
            PolylineOptions polylineOptions = this.options;
            if (polylineOptions != null) {
                polylineOptions.geodesic(z10);
                a();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void setOptionPointList(Object obj) {
        try {
            Class<?> cls = obj.getClass();
            Field declaredField = cls.getDeclaredField("isPointsUpdated");
            if (declaredField == null) {
                return;
            }
            declaredField.setAccessible(true);
            if (declaredField.getBoolean(obj)) {
                List<LatLng> points = ((PolylineOptions) obj).getPoints();
                double[] dArr = new double[points.size() * 2];
                for (int i10 = 0; i10 < points.size(); i10++) {
                    int i11 = i10 * 2;
                    dArr[i11] = points.get(i10).latitude;
                    dArr[i11 + 1] = points.get(i10).longitude;
                }
                Field declaredField2 = cls.getDeclaredField("pointList");
                if (declaredField2 == null) {
                    return;
                }
                declaredField2.setAccessible(true);
                declaredField2.set(obj, dArr);
            }
        } catch (Throwable th) {
            C1541c2.b(th, "Polyline", "setOptionPointList");
        }
    }

    public void setOptions(PolylineOptions polylineOptions) {
        this.options = polylineOptions;
        a();
    }

    public void setPoints(List<LatLng> list) {
        try {
            synchronized (this) {
                try {
                    PolylineOptions polylineOptions = this.options;
                    if (polylineOptions != null) {
                        polylineOptions.setPoints(list);
                        a();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public void setTransparency(float f10) {
        PolylineOptions polylineOptions = this.options;
        if (polylineOptions != null) {
            polylineOptions.transparency(f10);
            a();
        }
    }

    public void setVisible(boolean z10) {
        try {
            PolylineOptions polylineOptions = this.options;
            if (polylineOptions != null) {
                polylineOptions.visible(z10);
                a();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void setWidth(float f10) {
        try {
            PolylineOptions polylineOptions = this.options;
            if (polylineOptions != null) {
                polylineOptions.width(f10);
                a();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void setZIndex(float f10) {
        try {
            PolylineOptions polylineOptions = this.options;
            if (polylineOptions != null) {
                polylineOptions.zIndex(f10);
                a();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public Polyline(W1 w12, PolylineOptions polylineOptions, String str) {
        super(str);
        this.glOverlayLayerRef = new WeakReference<>(w12);
        this.options = polylineOptions;
    }
}
