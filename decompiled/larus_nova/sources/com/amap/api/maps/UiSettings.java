package com.amap.api.maps;

import android.graphics.Point;
import com.autonavi.amap.mapcore.interfaces.IUiSettings;

/* JADX INFO: loaded from: classes28.dex */
public final class UiSettings {
    private final IUiSettings uiSettingsDelegate;

    public static final enum ScaleControlsUnit extends Enum<ScaleControlsUnit> {
        private static final /* synthetic */ ScaleControlsUnit[] $VALUES = null;
        public static final ScaleControlsUnit IMPERIAL = null;
        public static final ScaleControlsUnit METRIC = null;

        static {
            ScaleControlsUnit r100 = new ScaleControlsUnit("METRIC", 0);
            METRIC = r100;
            ScaleControlsUnit r101 = new ScaleControlsUnit("IMPERIAL", 1);
            IMPERIAL = r101;
            $VALUES = new ScaleControlsUnit[]{r100, r101};
        }

        public static ScaleControlsUnit[] values() {
            return (ScaleControlsUnit[]) $VALUES.clone();
        }

        public static ScaleControlsUnit valueOf(String r100) {
            return (ScaleControlsUnit) r27.a.a(ScaleControlsUnit.class, r100);
        }

        private ScaleControlsUnit(String r100, int r101) {
            super(r100, r101);
        }
    }

    public void setLogoCenter(int r100, int r101) {
    }

    public int getLogoPosition() {
        return this.uiSettingsDelegate.getLogoPosition();
    L4:
        th = move-exception;
        th.printStackTrace();
        return 0;
    }

    public Point getLogoSize() {
        return this.uiSettingsDelegate.getLogoSize();
    L4:
        th = move-exception;
        th.printStackTrace();
        return new Point();
    }

    public float getLogoSizeScale() {
        return this.uiSettingsDelegate.getLogoSizeScale();
    L4:
        th = move-exception;
        th.printStackTrace();
        return 1.0f;
    }

    public ScaleControlsUnit getScaleControlsUnit() {
        return this.uiSettingsDelegate.getScaleControlsUnit();
    }

    public int getZoomPosition() {
        return this.uiSettingsDelegate.getZoomPosition();
    L4:
        th = move-exception;
        th.printStackTrace();
        return 2;
    }

    public boolean isCompassEnabled() {
        return this.uiSettingsDelegate.isCompassEnabled();
    L4:
        th = move-exception;
        th.printStackTrace();
        return false;
    }

    public boolean isGestureScaleByMapCenter() {
        return this.uiSettingsDelegate.isGestureScaleByMapCenter();
    L4:
        th = move-exception;
        th.printStackTrace();
        return false;
    }

    public boolean isIndoorSwitchEnabled() {
        return this.uiSettingsDelegate.isIndoorSwitchEnabled();
    L4:
        th = move-exception;
        th.printStackTrace();
        return false;
    }

    public boolean isLogoEnable() {
        return this.uiSettingsDelegate.isLogoEnable();
    L4:
        th = move-exception;
        th.printStackTrace();
        return true;
    }

    public boolean isMyLocationButtonEnabled() {
        return this.uiSettingsDelegate.isMyLocationButtonEnabled();
    L4:
        th = move-exception;
        th.printStackTrace();
        return false;
    }

    public boolean isRotateGesturesEnabled() {
        return this.uiSettingsDelegate.isRotateGesturesEnabled();
    L4:
        th = move-exception;
        th.printStackTrace();
        return true;
    }

    public boolean isScaleControlsEnabled() {
        return this.uiSettingsDelegate.isScaleControlsEnabled();
    L4:
        th = move-exception;
        th.printStackTrace();
        return false;
    }

    public boolean isScrollGesturesEnabled() {
        return this.uiSettingsDelegate.isScrollGesturesEnabled();
    L4:
        th = move-exception;
        th.printStackTrace();
        return true;
    }

    public boolean isTiltGesturesEnabled() {
        return this.uiSettingsDelegate.isTiltGesturesEnabled();
    L4:
        th = move-exception;
        th.printStackTrace();
        return true;
    }

    public boolean isZoomControlsEnabled() {
        return this.uiSettingsDelegate.isZoomControlsEnabled();
    L4:
        th = move-exception;
        th.printStackTrace();
        return true;
    }

    public boolean isZoomGesturesEnabled() {
        return this.uiSettingsDelegate.isZoomGesturesEnabled();
    L4:
        th = move-exception;
        th.printStackTrace();
        return true;
    }

    public UiSettings(IUiSettings r100) {
        this.uiSettingsDelegate = r100;
    }

    public float getLogoMarginRate(int r100) {
        return this.uiSettingsDelegate.getLogoMarginRate(r100);
    L4:
        th = move-exception;
        th.printStackTrace();
        return 0.0f;
    }

    public void setAllGesturesEnabled(boolean r100) {
        this.uiSettingsDelegate.setAllGesturesEnabled(r100);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        th.printStackTrace();
    }

    public void setCompassEnabled(boolean r100) {
        this.uiSettingsDelegate.setCompassEnabled(r100);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        th.printStackTrace();
    }

    public void setGestureScaleByMapCenter(boolean r100) {
        this.uiSettingsDelegate.setGestureScaleByMapCenter(r100);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        th.printStackTrace();
    }

    public void setIndoorSwitchEnabled(boolean r100) {
        this.uiSettingsDelegate.setIndoorSwitchEnabled(r100);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        th.printStackTrace();
    }

    public void setLayoutDirectionRtl(boolean r100) {
        this.uiSettingsDelegate.setLayoutDirectionRtl(r100);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        th.printStackTrace();
    }

    public final void setLogoBottomMargin(int r100) {
        this.uiSettingsDelegate.setLogoBottomMargin(r100);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        th.printStackTrace();
    }

    public void setLogoEnable(boolean r100) {
        this.uiSettingsDelegate.setLogoEnable(r100);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        th.printStackTrace();
    }

    public final void setLogoLeftMargin(int r100) {
        this.uiSettingsDelegate.setLogoLeftMargin(r100);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        th.printStackTrace();
    }

    public void setLogoPosition(int r100) {
        this.uiSettingsDelegate.setLogoPosition(r100);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        th.printStackTrace();
    }

    public void setLogoSizeScale(float r100) {
        this.uiSettingsDelegate.setLogoSizeScale(r100);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        th.printStackTrace();
    }

    public void setMyLocationButtonEnabled(boolean r100) {
        this.uiSettingsDelegate.setMyLocationButtonEnabled(r100);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        th.printStackTrace();
    }

    public void setRotateGesturesEnabled(boolean r100) {
        this.uiSettingsDelegate.setRotateGesturesEnabled(r100);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        th.printStackTrace();
    }

    public void setScaleControlsEnabled(boolean r100) {
        this.uiSettingsDelegate.setScaleControlsEnabled(r100);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        th.printStackTrace();
    }

    public void setScaleControlsPosition(Point r100) {
        this.uiSettingsDelegate.setScaleControlsPosition(r100);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        th.printStackTrace();
    }

    public void setScaleControlsUnit(ScaleControlsUnit r100) {
        this.uiSettingsDelegate.setScaleControlsUnit(r100);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        th.printStackTrace();
    }

    public void setScrollGesturesEnabled(boolean r100) {
        this.uiSettingsDelegate.setScrollGesturesEnabled(r100);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        th.printStackTrace();
    }

    public void setTiltGesturesEnabled(boolean r100) {
        this.uiSettingsDelegate.setTiltGesturesEnabled(r100);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        th.printStackTrace();
    }

    public void setZoomControlsEnabled(boolean r100) {
        this.uiSettingsDelegate.setZoomControlsEnabled(r100);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        th.printStackTrace();
    }

    public void setZoomGesturesEnabled(boolean r100) {
        this.uiSettingsDelegate.setZoomGesturesEnabled(r100);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        th.printStackTrace();
    }

    public void setZoomInByScreenCenter(boolean r100) {
        this.uiSettingsDelegate.setZoomInByScreenCenter(r100);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        th.printStackTrace();
    }

    public void setZoomPosition(int r100) {
        this.uiSettingsDelegate.setZoomPosition(r100);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        th.printStackTrace();
    }

    public final void setLogoMarginRate(int r100, float r101) {
        this.uiSettingsDelegate.setLogoMarginRate(r100, r101);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        th.printStackTrace();
    }
}
