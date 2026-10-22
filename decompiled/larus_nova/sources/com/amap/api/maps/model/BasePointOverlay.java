package com.amap.api.maps.model;

import com.amap.api.maps.model.animation.Animation;
import com.autonavi.amap.mapcore.IPoint;

/* JADX INFO: loaded from: classes28.dex */
public abstract class BasePointOverlay extends BaseOverlay {
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

    public abstract void setAnimation(Animation r100);

    public abstract void setGeoPoint(IPoint r100);

    public abstract void setObject(Object r100);

    public abstract void setPosition(LatLng r100);

    public abstract void setRotateAngle(float r100);

    public abstract void setSnippet(String r100);

    public abstract void setTitle(String r100);

    public abstract void setVisible(boolean r100);

    public abstract void showInfoWindow();

    public abstract boolean startAnimation();

    public BasePointOverlay(String r100) {
        super(r100);
    }
}
