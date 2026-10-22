package com.amap.api.maps.model;

/* loaded from: classes.dex */
public abstract class BasePointOverlay extends BaseOverlay {
    public BasePointOverlay(String str) {
        super(str);
    }

    public abstract void destroy();

    public abstract String getId();

    public abstract Object getObject();

    public abstract LatLng getPosition();

    public abstract float getRotateAngle();

    public abstract String getSnippet();

    public abstract String getTitle();

    public abstract boolean isInfoWindowEnable();

    public abstract boolean isVisible();

    public abstract void remove();

    public abstract void setObject(Object obj);

    public abstract void setPosition(LatLng latLng);

    public abstract void setRotateAngle(float f10);

    public abstract void setSnippet(String str);

    public abstract void setTitle(String str);

    public abstract void setVisible(boolean z10);

    public abstract void showInfoWindow();
}
