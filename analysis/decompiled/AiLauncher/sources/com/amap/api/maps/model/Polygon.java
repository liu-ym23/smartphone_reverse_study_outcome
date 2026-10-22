package com.amap.api.maps.model;

import android.text.TextUtils;
import com.amap.api.col.jmsl.C1570k;
import com.amap.api.col.jmsl.W1;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public final class Polygon extends BaseOverlay {
    private WeakReference<W1> glOverlayLayerRef;
    private PolygonOptions options;

    public Polygon(W1 w12, PolygonOptions polygonOptions, String str) {
        super(str);
        this.glOverlayLayerRef = new WeakReference<>(w12);
        this.options = polygonOptions;
    }

    private void a() {
        try {
            W1 w12 = this.glOverlayLayerRef.get();
            if (TextUtils.isEmpty(this.overlayName) || w12 == null) {
                return;
            }
            w12.g(this.overlayName, this.options);
        } catch (Throwable unused) {
        }
    }

    public boolean contains(LatLng latLng) {
        try {
            return C1570k.o(this.options, latLng);
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof Polygon)) {
            try {
                if (super.equals(obj)) {
                    return true;
                }
                return ((Polygon) obj).getId() == getId();
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return false;
    }

    public int getFillColor() {
        try {
            PolygonOptions polygonOptions = this.options;
            if (polygonOptions != null) {
                return polygonOptions.getFillColor();
            }
            return 0;
        } catch (Throwable th) {
            th.printStackTrace();
            return 0;
        }
    }

    public List<BaseHoleOptions> getHoleOptions() {
        try {
            PolygonOptions polygonOptions = this.options;
            if (polygonOptions != null) {
                return polygonOptions.getHoleOptions();
            }
            return null;
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
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

    public List<LatLng> getPoints() {
        try {
            PolygonOptions polygonOptions = this.options;
            if (polygonOptions != null) {
                return polygonOptions.getPoints();
            }
            return null;
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public int getStrokeColor() {
        try {
            PolygonOptions polygonOptions = this.options;
            if (polygonOptions != null) {
                return polygonOptions.getStrokeColor();
            }
            return 0;
        } catch (Throwable th) {
            th.printStackTrace();
            return 0;
        }
    }

    public float getStrokeWidth() {
        try {
            PolygonOptions polygonOptions = this.options;
            if (polygonOptions != null) {
                return polygonOptions.getStrokeWidth();
            }
            return 0.0f;
        } catch (Throwable th) {
            th.printStackTrace();
            return 0.0f;
        }
    }

    public float getZIndex() {
        try {
            PolygonOptions polygonOptions = this.options;
            if (polygonOptions != null) {
                return polygonOptions.getZIndex();
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
        } catch (Throwable unused) {
            return super.hashCode();
        }
    }

    public boolean isVisible() {
        try {
            PolygonOptions polygonOptions = this.options;
            if (polygonOptions != null) {
                return polygonOptions.isVisible();
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
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void setFillColor(int i10) {
        try {
            PolygonOptions polygonOptions = this.options;
            if (polygonOptions != null) {
                polygonOptions.fillColor(i10);
                a();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void setHoleOptions(List<BaseHoleOptions> list) {
        if (list == null) {
            try {
                list = new ArrayList<>();
            } catch (Throwable th) {
                th.printStackTrace();
                return;
            }
        }
        this.options.setHoleOptions(list);
        a();
    }

    public void setPoints(List<LatLng> list) {
        try {
            this.options.setPoints(list);
            a();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void setStrokeColor(int i10) {
        try {
            PolygonOptions polygonOptions = this.options;
            if (polygonOptions != null) {
                polygonOptions.strokeColor(i10);
                a();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void setStrokeWidth(float f10) {
        try {
            this.options.strokeWidth(f10);
            a();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void setVisible(boolean z10) {
        try {
            PolygonOptions polygonOptions = this.options;
            if (polygonOptions != null) {
                polygonOptions.visible(z10);
                a();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void setZIndex(float f10) {
        try {
            PolygonOptions polygonOptions = this.options;
            if (polygonOptions != null) {
                polygonOptions.zIndex(f10);
                a();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
