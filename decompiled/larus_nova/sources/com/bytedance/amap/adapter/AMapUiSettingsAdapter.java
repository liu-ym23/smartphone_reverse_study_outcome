package com.bytedance.amap.adapter;

import com.amap.api.maps.AMap;
import com.amap.api.maps.AMapOptions;
import com.amap.api.maps.UiSettings;
import com.bytedance.map.api.logger.MapLogger;
import com.bytedance.map.api.model.BDMapUiConfigs;
import com.bytedance.map.api.monitor.MapMonitor;

/* JADX INFO: loaded from: classes43.dex */
public final class AMapUiSettingsAdapter {
    private static final int AMAP_ZOOM_POSITION_RIGHT_BOTTOM = 0;
    private static final int AMAP_ZOOM_POSITION_RIGHT_CENTER = 0;
    private static final String TAG = "AMapUiSettingsAdapter";

    private AMapUiSettingsAdapter() {
    }

    static {
        AMAP_ZOOM_POSITION_RIGHT_CENTER = resolveAmapOptionConstant(1, new String[]{"ZOOM_POSITION_RIGHT_CENTER"});
        AMAP_ZOOM_POSITION_RIGHT_BOTTOM = resolveAmapOptionConstant(2, new String[]{"ZOOM_POSITION_RIGHT_BOTTOM", "ZOOM_POSITION_RIGHT_BUTTOM"});
    }

    public static int getLogoPosition(AMap r100) {
        UiSettings r101 = getUi(r100);
        if (r101 != null) goto L5;
        return 0;
    L5:
        int r102 = r101.getLogoPosition();
        int r103 = 1;
        if (r102 == 1) goto L10;
        r103 = 2;
        if (r102 == 2) goto L10;
        return 0;
    L10:
        return r103;
    }

    private static UiSettings getUi(AMap r100) {
        if (r100 != null) goto L5;
        return null;
    L5:
        return r100.getUiSettings();
    }

    public static int getZoomPosition(AMap r100) {
        UiSettings r101 = getUi(r100);
        if (r101 != null) goto L6;
        return 2;
    L6:
        if (r101.getZoomPosition() != AMAP_ZOOM_POSITION_RIGHT_CENTER) goto L9;
        return 1;
    L9:
        return 2;
    }

    public static boolean isCompassEnabled(AMap r100) {
        UiSettings r101 = getUi(r100);
        if (r101 != null) goto L7;
        return false;
    L7:
        return r101.isCompassEnabled();
    }

    public static boolean isGestureScaleByMapCenter(AMap r100) {
        UiSettings r101 = getUi(r100);
        if (r101 != null) goto L7;
        return false;
    L7:
        return r101.isGestureScaleByMapCenter();
    }

    public static boolean isIndoorSwitchEnabled(AMap r100) {
        UiSettings r101 = getUi(r100);
        if (r101 != null) goto L7;
        return false;
    L7:
        return r101.isIndoorSwitchEnabled();
    }

    public static boolean isMyLocationButtonEnabled(AMap r100) {
        UiSettings r101 = getUi(r100);
        if (r101 != null) goto L7;
        return false;
    L7:
        return r101.isMyLocationButtonEnabled();
    }

    public static boolean isRotateGesturesEnabled(AMap r100) {
        UiSettings r101 = getUi(r100);
        if (r101 != null) goto L7;
        return false;
    L7:
        return r101.isRotateGesturesEnabled();
    }

    public static boolean isScaleControlsEnabled(AMap r100) {
        UiSettings r101 = getUi(r100);
        if (r101 != null) goto L7;
        return false;
    L7:
        return r101.isScaleControlsEnabled();
    }

    public static boolean isScrollGesturesEnabled(AMap r100) {
        UiSettings r101 = getUi(r100);
        if (r101 != null) goto L7;
        return false;
    L7:
        return r101.isScrollGesturesEnabled();
    }

    public static boolean isTiltGesturesEnabled(AMap r100) {
        UiSettings r101 = getUi(r100);
        if (r101 != null) goto L7;
        return false;
    L7:
        return r101.isTiltGesturesEnabled();
    }

    public static boolean isZoomControlsEnabled(AMap r100) {
        UiSettings r101 = getUi(r100);
        if (r101 != null) goto L7;
        return false;
    L7:
        return r101.isZoomControlsEnabled();
    }

    public static boolean isZoomGesturesEnabled(AMap r100) {
        UiSettings r101 = getUi(r100);
        if (r101 != null) goto L7;
        return false;
    L7:
        return r101.isZoomGesturesEnabled();
    }

    public static void apply(AMap r100, BDMapUiConfigs r101) {
        if (r100 == null) goto L76;
        if (r101 == null) goto L78;
        UiSettings r102 = r100.getUiSettings();     // Catch: Exception -> L71
        if (r102 != null) goto L9;
        return;
    L9:
        if (r101.getScaleControlsEnabled() == null) goto L12;
        r102.setScaleControlsEnabled(r101.getScaleControlsEnabled().booleanValue());     // Catch: Exception -> L71
    L12:
        if (r101.getZoomControlsEnabled() == null) goto L15;
        r102.setZoomControlsEnabled(r101.getZoomControlsEnabled().booleanValue());     // Catch: Exception -> L71
    L15:
        if (r101.getMyLocationButtonEnabled() == null) goto L18;
        r102.setMyLocationButtonEnabled(r101.getMyLocationButtonEnabled().booleanValue());     // Catch: Exception -> L71
    L18:
        if (r101.getCompassEnabled() == null) goto L21;
        r102.setCompassEnabled(r101.getCompassEnabled().booleanValue());     // Catch: Exception -> L71
    L21:
        if (r101.getAllGesturesEnabled() == null) goto L24;
        r102.setAllGesturesEnabled(r101.getAllGesturesEnabled().booleanValue());     // Catch: Exception -> L71
    L24:
        if (r101.getRotateGesturesEnabled() == null) goto L27;
        r102.setRotateGesturesEnabled(r101.getRotateGesturesEnabled().booleanValue());     // Catch: Exception -> L71
    L27:
        if (r101.getZoomGesturesEnabled() == null) goto L30;
        r102.setZoomGesturesEnabled(r101.getZoomGesturesEnabled().booleanValue());     // Catch: Exception -> L71
    L30:
        if (r101.getScrollGesturesEnabled() == null) goto L33;
        r102.setScrollGesturesEnabled(r101.getScrollGesturesEnabled().booleanValue());     // Catch: Exception -> L71
    L33:
        if (r101.getTiltGesturesEnabled() == null) goto L36;
        r102.setTiltGesturesEnabled(r101.getTiltGesturesEnabled().booleanValue());     // Catch: Exception -> L71
    L36:
        if (r101.getGestureScaleByMapCenter() == null) goto L39;
        r102.setGestureScaleByMapCenter(r101.getGestureScaleByMapCenter().booleanValue());     // Catch: Exception -> L71
    L39:
        if (r101.getLogoPosition() == null) goto L52;
        int r103 = r101.getLogoPosition().intValue();     // Catch: Exception -> L71
        if (r103 == 1) goto L49;
        int r104 = 2;
        if (r103 != 2) goto L45;
    L50:
        r102.setLogoPosition(r104);     // Catch: Exception -> L71
        goto L52
    L45:
        if (r103 == 4) goto L49;
        if (r103 == 5) goto L50;
        r104 = 0;
    L49:
        r104 = 1;
    L52:
        if (r101.getZoomPosition() == null) goto L59;
        if (r101.getZoomPosition().intValue() == 1) goto L56;
        int r105 = AMAP_ZOOM_POSITION_RIGHT_BOTTOM;     // Catch: Exception -> L71
    L57:
        r102.setZoomPosition(r105);     // Catch: Exception -> L71
        goto L59
    L56:
        r105 = AMAP_ZOOM_POSITION_RIGHT_CENTER;     // Catch: Exception -> L71
    L59:
        if (r101.getIndoorSwitchEnabled() == null) goto L62;
        r102.setIndoorSwitchEnabled(r101.getIndoorSwitchEnabled().booleanValue());     // Catch: Exception -> L71
    L62:
        if (r101.getLogoLeftMargin() == null) goto L65;
        r102.setLogoLeftMargin(r101.getLogoLeftMargin().intValue());     // Catch: Exception -> L71
    L65:
        if (r101.getLogoBottomMargin() == null) goto L68;
        r102.setLogoBottomMargin(r101.getLogoBottomMargin().intValue());     // Catch: Exception -> L71
    L68:
        if (r101.getZoomInByScreenCenter() == null) goto L77;
        r102.setZoomInByScreenCenter(r101.getZoomInByScreenCenter().booleanValue());     // Catch: Exception -> L71
        return;
    L77:
        return;
    L71:
        e = move-exception;
        MapMonitor.amapExceptionMonitor(e);
        MapLogger.i(TAG, "apply ui settings error:" + e.getMessage());
        return;
    L78:
        return;
    }

    public static BDMapUiConfigs getUiSettings(AMap r100, int r101) {
        BDMapUiConfigs.Builder r102 = new BDMapUiConfigs.Builder();
        r102.setScaleControlsEnabled(isScaleControlsEnabled(r100));
        r102.setZoomControlsEnabled(isZoomControlsEnabled(r100));
        r102.setCompassEnabled(isCompassEnabled(r100));
        r102.setMyLocationButtonEnabled(isMyLocationButtonEnabled(r100));
        r102.setScrollGesturesEnabled(isScrollGesturesEnabled(r100));
        r102.setZoomGesturesEnabled(isZoomGesturesEnabled(r100));
        r102.setTiltGesturesEnabled(isTiltGesturesEnabled(r100));
        r102.setRotateGesturesEnabled(isRotateGesturesEnabled(r100));
        r102.setGestureScaleByMapCenter(isGestureScaleByMapCenter(r100));
        r102.setLogoPosition(r101);
        r102.setZoomPosition(getZoomPosition(r100));
        r102.setIndoorSwitchEnabled(isIndoorSwitchEnabled(r100));
        r102.setZoomInByScreenCenter(isGestureScaleByMapCenter(r100));
        return r102.build();
    }

    private static int resolveAmapOptionConstant(int r100, String... r101) {
        int r102 = 0;
    L3:
        if (r102 >= r101.length) goto L8;
        return AMapOptions.class.getField(r101[r102]).getInt(null);
    L7:
        r102 = r102 + 1;
        goto L3
    L8:
        MapLogger.i(TAG, "resolve AMap option constant failed, fallback=" + r100);
        return r100;
    }
}
