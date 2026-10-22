package com.amap.api.maps.model;

import android.graphics.PointF;
import android.text.TextUtils;
import com.amap.api.col.jmsl.W1;
import com.autonavi.amap.mapcore.FPoint;
import java.lang.ref.WeakReference;

/* loaded from: classes.dex */
public final class Marker extends BasePointOverlay {
    private WeakReference<W1> glOverlayLayerRef;
    private boolean isRemoved;
    private Object object;
    private MarkerOptions options;

    public Marker(W1 w12, MarkerOptions markerOptions, String str) {
        super(str);
        this.isRemoved = false;
        this.glOverlayLayerRef = new WeakReference<>(w12);
        this.options = markerOptions;
    }

    private void a() {
        try {
            synchronized (this) {
                try {
                    W1 w12 = this.glOverlayLayerRef.get();
                    if (!TextUtils.isEmpty(this.overlayName) && w12 != null) {
                        w12.g(this.overlayName, this.options);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        } catch (Throwable unused) {
        }
    }

    @Override // com.amap.api.maps.model.BasePointOverlay
    public void destroy() {
        try {
            remove();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public boolean equals(Object obj) {
        MarkerOptions markerOptions;
        if (obj != null) {
            try {
                if ((obj instanceof Marker) && (markerOptions = this.options) != null && markerOptions.equals(((Marker) obj).options)) {
                    if (this.overlayName.equals(((Marker) obj).overlayName)) {
                        return true;
                    }
                }
                return false;
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return false;
    }

    public float getAnchorU() {
        MarkerOptions markerOptions = this.options;
        if (markerOptions != null) {
            return markerOptions.getAnchorU();
        }
        return 0.0f;
    }

    public float getAnchorV() {
        MarkerOptions markerOptions = this.options;
        if (markerOptions != null) {
            return markerOptions.getAnchorV();
        }
        return 0.0f;
    }

    public BitmapDescriptor getIcon() {
        try {
            return this.options.getIcon();
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    @Override // com.amap.api.maps.model.BasePointOverlay
    public String getId() {
        try {
            return this.overlayName;
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    @Override // com.amap.api.maps.model.BasePointOverlay
    public Object getObject() {
        return this.object;
    }

    @Override // com.amap.api.maps.model.BasePointOverlay
    public LatLng getPosition() {
        try {
            if (this.options == null || isViewMode()) {
                return null;
            }
            return this.options.getPosition();
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return null;
    }

    public void getRealInfoWindowOffset(FPoint fPoint) {
        int infoWindowOffsetX = this.options.getInfoWindowOffsetX();
        int infoWindowOffsetY = this.options.getInfoWindowOffsetY();
        BitmapDescriptor icon = this.options.getIcon();
        int height = icon != null ? infoWindowOffsetY - icon.getHeight() : infoWindowOffsetY - 74;
        ((PointF) fPoint).x = infoWindowOffsetX;
        ((PointF) fPoint).y = height;
    }

    @Override // com.amap.api.maps.model.BasePointOverlay
    public float getRotateAngle() {
        MarkerOptions markerOptions = this.options;
        if (markerOptions != null) {
            return markerOptions.getRotateAngle();
        }
        return 0.0f;
    }

    @Override // com.amap.api.maps.model.BasePointOverlay
    public String getSnippet() {
        try {
            MarkerOptions markerOptions = this.options;
            if (markerOptions != null) {
                return markerOptions.getSnippet();
            }
            return null;
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    @Override // com.amap.api.maps.model.BasePointOverlay
    public String getTitle() {
        try {
            MarkerOptions markerOptions = this.options;
            if (markerOptions != null) {
                return markerOptions.getTitle();
            }
            return null;
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public float getZIndex() {
        MarkerOptions markerOptions = this.options;
        if (markerOptions != null) {
            return markerOptions.getZIndex();
        }
        return 0.0f;
    }

    public int hashCode() {
        if (this.options == null) {
            return super.hashCode();
        }
        String str = this.overlayName;
        return (((str == null ? 0 : str.hashCode()) + 31) * 31) + this.options.hashCode();
    }

    public void hideInfoWindow() {
        try {
            W1 w12 = this.glOverlayLayerRef.get();
            if (TextUtils.isEmpty(this.overlayName) || w12 == null) {
                return;
            }
            w12.m();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public boolean isClickable() {
        MarkerOptions markerOptions = this.options;
        if (markerOptions != null) {
            return markerOptions.isClickable();
        }
        return false;
    }

    public boolean isDraggable() {
        MarkerOptions markerOptions = this.options;
        if (markerOptions != null) {
            return markerOptions.isDraggable();
        }
        return false;
    }

    @Override // com.amap.api.maps.model.BasePointOverlay
    public boolean isInfoWindowEnable() {
        MarkerOptions markerOptions = this.options;
        if (markerOptions != null) {
            return markerOptions.isInfoWindowEnable();
        }
        return false;
    }

    public boolean isInfoWindowShown() {
        W1 w12 = this.glOverlayLayerRef.get();
        if (TextUtils.isEmpty(this.overlayName) || w12 == null) {
            return false;
        }
        return w12.o();
    }

    public boolean isRemoved() {
        return this.isRemoved;
    }

    public boolean isViewMode() {
        MarkerOptions markerOptions = this.options;
        if (markerOptions != null) {
            return markerOptions.isViewMode();
        }
        return false;
    }

    @Override // com.amap.api.maps.model.BasePointOverlay
    public boolean isVisible() {
        try {
            MarkerOptions markerOptions = this.options;
            if (markerOptions != null) {
                return markerOptions.isVisible();
            }
            return false;
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    @Override // com.amap.api.maps.model.BasePointOverlay
    public void remove() {
        try {
            W1 w12 = this.glOverlayLayerRef.get();
            if (w12 != null) {
                w12.q(this.overlayName);
            }
            this.isRemoved = true;
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void setAnchor(float f10, float f11) {
        try {
            MarkerOptions markerOptions = this.options;
            if (markerOptions != null) {
                markerOptions.anchor(f10, f11);
                a();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void setClickable(boolean z10) {
        MarkerOptions markerOptions = this.options;
        if (markerOptions != null) {
            markerOptions.clickable(z10);
            a();
        }
    }

    public void setDraggable(boolean z10) {
        try {
            MarkerOptions markerOptions = this.options;
            if (markerOptions != null) {
                markerOptions.draggable(z10);
                a();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void setIcon(BitmapDescriptor bitmapDescriptor) {
        if (bitmapDescriptor != null) {
            try {
                MarkerOptions markerOptions = this.options;
                if (markerOptions != null) {
                    markerOptions.icon(bitmapDescriptor);
                    a();
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public void setInfoWindowEnable(boolean z10) {
        MarkerOptions markerOptions = this.options;
        if (markerOptions != null) {
            markerOptions.infoWindowEnable(z10);
            a();
        }
    }

    public void setMarkerOptions(MarkerOptions markerOptions) {
        this.options = markerOptions;
        a();
    }

    @Override // com.amap.api.maps.model.BasePointOverlay
    public void setObject(Object obj) {
        this.object = obj;
    }

    @Override // com.amap.api.maps.model.BasePointOverlay
    public void setPosition(LatLng latLng) {
        try {
            this.options.position(latLng);
            a();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.amap.api.maps.model.BasePointOverlay
    public void setRotateAngle(float f10) {
        try {
            MarkerOptions markerOptions = this.options;
            if (markerOptions != null) {
                markerOptions.rotateAngle(f10);
                a();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.amap.api.maps.model.BasePointOverlay
    public void setSnippet(String str) {
        try {
            MarkerOptions markerOptions = this.options;
            if (markerOptions != null) {
                markerOptions.snippet(str);
                a();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.amap.api.maps.model.BasePointOverlay
    public void setTitle(String str) {
        try {
            MarkerOptions markerOptions = this.options;
            if (markerOptions != null) {
                markerOptions.title(str);
                a();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.amap.api.maps.model.BasePointOverlay
    public void setVisible(boolean z10) {
        try {
            MarkerOptions markerOptions = this.options;
            if (markerOptions != null) {
                markerOptions.visible(z10);
                a();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void setZIndex(float f10) {
        MarkerOptions markerOptions = this.options;
        if (markerOptions != null) {
            markerOptions.zIndex(f10);
            a();
        }
    }

    @Override // com.amap.api.maps.model.BasePointOverlay
    public void showInfoWindow() {
        try {
            W1 w12 = this.glOverlayLayerRef.get();
            if (TextUtils.isEmpty(this.overlayName) || w12 == null) {
                return;
            }
            w12.r(this.overlayName);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
