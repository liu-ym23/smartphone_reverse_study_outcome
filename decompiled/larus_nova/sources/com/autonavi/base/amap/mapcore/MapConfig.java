package com.autonavi.base.amap.mapcore;

import android.opengl.Matrix;
import androidx.camera.video.AudioStats;
import com.amap.api.maps.model.LatLngBounds;
import com.autonavi.amap.mapcore.DPoint;
import com.autonavi.amap.mapcore.IPoint;
import com.autonavi.amap.mapcore.interfaces.IMapConfig;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes39.dex */
public class MapConfig implements Cloneable, IMapConfig {
    public static final int DEFAULT_RATIO = 1;
    private static final int GEO_POINT_ZOOM = 20;
    public static final float MAX_ZOOM = 20.0f;
    public static final float MAX_ZOOM_INDOOR = 20.0f;
    public static final float MIN_ZOOM = 3.0f;
    public static final int MSG_ACTION_MAINTHREAD_TRIGGER = 30;
    public static final int MSG_ACTION_NATIVE_OVERLAYS_POSITION_UPDATE = 41;
    public static final int MSG_ACTION_NATIVE_OVERLAYS_REFRESH = 40;
    public static final int MSG_ACTION_ONBASEPOICLICK = 20;
    public static final int MSG_ACTION_ONMAPCLICK = 19;
    public static final int MSG_AUTH_FAILURE = 2;
    public static final int MSG_CALLBACK_MAPLOADED = 16;
    public static final int MSG_CALLBACK_ONTOUCHEVENT = 14;
    public static final int MSG_CALLBACK_SCREENSHOT = 15;
    public static final int MSG_CAMERAUPDATE_CHANGE = 10;
    public static final int MSG_CAMERAUPDATE_FINISH = 11;
    public static final int MSG_COMPASSVIEW_CHANGESTATE = 13;
    public static final int MSG_INFOWINDOW_UPDATE = 18;
    public static final int MSG_TILEOVERLAY_REFRESH = 17;
    public static final int MSG_ZOOMVIEW_CHANGESTATE = 12;
    private static final int TILE_SIZE_POW = 8;
    private int abroadState;
    private int anchorX;
    private int anchorY;
    private volatile double changeGridRatio;
    private volatile double changeRatio;
    private AtomicInteger changedCounter;
    private int customBackgroundColor;
    private String customTextureResourcePath;
    private Rectangle geoRectangle;
    private int gridX;
    private int gridY;
    private boolean isAbroadEnable;
    private boolean isBearingChanged;
    private boolean isBuildingEnable;
    private boolean isCenterChanged;
    private boolean isCustomStyleEnabled;
    private boolean isHideLogoEnable;
    private boolean isIndoorEnable;
    private boolean isMapTextEnable;
    private boolean isNeedUpdateMapRectNextFrame;
    private boolean isNeedUpdateZoomControllerState;
    private boolean isProFunctionAuthEnable;
    private boolean isSetLimitZoomLevel;
    private boolean isTerrainEnable;
    private boolean isTiltChanged;
    private boolean isTouchPoiEnable;
    private boolean isTrafficEnabled;
    private boolean isUseProFunction;
    private boolean isWorldMapEnable;
    private boolean isZoomChanged;
    MapConfig lastMapconfig;
    private IPoint[] limitIPoints;
    private LatLngBounds limitLatLngBounds;
    private String mCustomStyleID;
    private String mCustomStylePath;
    private String mMapLanguage;
    private int mMapStyleMode;
    private int mMapStyleTime;
    private boolean mapEnable;
    private DPoint mapGeoCenter;
    private int mapHeight;
    private float mapPerPixelUnitLength;
    private FPoint[] mapRect;
    private int mapWidth;
    private float mapZoomScale;
    public float maxZoomLevel;
    public float minZoomLevel;
    float[] mvpMatrix;
    float[] projectionMatrix;
    private float sC;
    private float sR;
    private double sX;
    private double sY;
    private float sZ;
    private boolean showsLocalLanguage;
    private float skyHeight;
    private int[] tilsIDs;
    float[] viewMatrix;

    private void changeRatio() {
        double r100 = this.lastMapconfig.getSX();
        double r101 = this.lastMapconfig.getSY();
        float r102 = this.lastMapconfig.getSZ();
        float r103 = this.lastMapconfig.getSC();
        float r104 = this.lastMapconfig.getSR();
        this.changeRatio = Math.abs(this.sX - r100) + Math.abs(this.sY - r101);
        double r105 = 1.0d;
        if (this.changeRatio != AudioStats.AUDIO_AMPLITUDE_NONE) goto L5;
        double r106 = 1.0d;
    L6:
        this.changeRatio = r106;
        double r107 = this.changeRatio;
        float r110 = this.sZ;
        if (r102 != r110) goto L9;
        double r111 = 1.0d;
    L10:
        this.changeRatio = r107 * r111;
        float r108 = this.sC;
        float r109 = 1.0f;
        if (r103 != r108) goto L13;
        float r112 = 1.0f;
    L14:
        float r113 = this.sR;
        if (r104 == r113) goto L18;
        r109 = Math.abs(r104 - r113);
    L18:
        double r114 = r112;
        this.changeRatio *= r114;
        double r115 = r109;
        this.changeRatio *= r115;
        this.changeGridRatio = Math.abs(this.lastMapconfig.getGridX() - this.gridX) + (this.lastMapconfig.getGridY() - this.gridY);
        if (this.changeGridRatio == AudioStats.AUDIO_AMPLITUDE_NONE) goto L22;
        r105 = this.changeGridRatio * 2.0d;
    L22:
        this.changeGridRatio = r105;
        this.changeGridRatio *= r114;
        this.changeGridRatio *= r115;
        return;
    L13:
        r112 = Math.abs(r103 - r108);
        goto L14
    L9:
        r111 = Math.abs(r102 - r110);
        goto L10
    L5:
        r106 = this.changeRatio * 2.0d;
        goto L6
    }

    public void addChangedCounter() {
        this.changedCounter.incrementAndGet();
    }

    public int getChangedCounter() {
        return this.changedCounter.get();
    }

    public boolean isMapStateChange() {
        MapConfig r100 = this.lastMapconfig;
        if (r100 == null) goto L49;
        double r101 = r100.getSX();
        double r102 = this.lastMapconfig.getSY();
        float r103 = this.lastMapconfig.getSZ();
        float r104 = this.lastMapconfig.getSC();
        float r105 = this.lastMapconfig.getSR();
        double r106 = this.sX;
        boolean r110 = true;
        if (r101 == r106) goto L7;
        boolean r107 = true;
    L8:
        this.isCenterChanged = r107;
        double r111 = this.sY;
        if (r102 == r111) goto L11;
        r107 = true;
    L11:
        this.isCenterChanged = r107;
        float r108 = this.sZ;
        if (r103 == r108) goto L14;
        boolean r109 = true;
    L15:
        this.isZoomChanged = r109;
        if (r109 == false) goto L29;
        float r112 = this.minZoomLevel;
        if (r103 > r112) goto L20;
    L27:
        this.isNeedUpdateZoomControllerState = true;
        goto L29
    L20:
        if (r108 <= r112) goto L27;
        float r113 = this.maxZoomLevel;
        if (r103 >= r113) goto L27;
        if (r108 >= r113) goto L27;
        this.isNeedUpdateZoomControllerState = false;
    L29:
        if (r104 == this.sC) goto L31;
        boolean r114 = true;
    L32:
        this.isTiltChanged = r114;
        if (r105 == this.sR) goto L35;
        boolean r115 = true;
    L36:
        this.isBearingChanged = r115;
        if (r107 == true) goto L45;
        if (r109 == true) goto L45;
        if (r114 == true) goto L45;
        if (r115 == true) goto L45;
        if (this.isNeedUpdateMapRectNextFrame == true) goto L45;
        r110 = false;
    L45:
        if (r110 == false) goto L48;
        this.isNeedUpdateMapRectNextFrame = false;
        int r116 = (20 - ((int) r108)) + 8;
        setGridXY(((int) r106) >> r116, ((int) r111) >> r116);
        changeRatio();
    L48:
        return r110;
    L35:
        r115 = false;
        goto L36
    L31:
        r114 = false;
        goto L32
    L14:
        r109 = false;
        goto L15
    L7:
        r107 = false;
        goto L8
    L49:
        return false;
    }

    public void resetChangedCounter() {
        this.changedCounter.set(0);
    }

    public void resetMinMaxZoomPreference() {
        this.minZoomLevel = 3.0f;
        this.maxZoomLevel = 20.0f;
        this.isSetLimitZoomLevel = false;
    }

    public String toString() {
        return " sX: " + this.sX + " sY: " + this.sY + " sZ: " + this.sZ + " sC: " + this.sC + " sR: " + this.sR + " skyHeight: " + this.skyHeight;
    }

    public void updateFinalMatrix() {
        Matrix.multiplyMM(this.mvpMatrix, 0, this.projectionMatrix, 0, this.viewMatrix, 0);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IMapConfig
    public int getAbroadState() {
        return this.abroadState;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IMapConfig
    public int getAnchorX() {
        return this.anchorX;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IMapConfig
    public int getAnchorY() {
        return this.anchorY;
    }

    public double getChangeGridRatio() {
        return this.changeGridRatio;
    }

    public double getChangeRatio() {
        return this.changeRatio;
    }

    public int getCustomBackgroundColor() {
        return this.customBackgroundColor;
    }

    public String getCustomStyleID() {
        return this.mCustomStyleID;
    }

    public String getCustomStylePath() {
        return this.mCustomStylePath;
    }

    public String getCustomTextureResourcePath() {
        return this.customTextureResourcePath;
    }

    public Rectangle getGeoRectangle() {
        return this.geoRectangle;
    }

    public int getGridX() {
        return this.gridX;
    }

    public int getGridY() {
        return this.gridY;
    }

    public IPoint[] getLimitIPoints() {
        return this.limitIPoints;
    }

    public LatLngBounds getLimitLatLngBounds() {
        return this.limitLatLngBounds;
    }

    public DPoint getMapGeoCenter() {
        return this.mapGeoCenter;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IMapConfig
    public int getMapHeight() {
        return this.mapHeight;
    }

    public String getMapLanguage() {
        return this.mMapLanguage;
    }

    public int getMapStyleMode() {
        return this.mMapStyleMode;
    }

    public int getMapStyleTime() {
        return this.mMapStyleTime;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IMapConfig
    public int getMapWidth() {
        return this.mapWidth;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IMapConfig
    public float getMapZoomScale() {
        return this.mapZoomScale;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IMapConfig
    public float getMaxZoomLevel() {
        return this.maxZoomLevel;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IMapConfig
    public float getMinZoomLevel() {
        return this.minZoomLevel;
    }

    public float[] getMvpMatrix() {
        return this.mvpMatrix;
    }

    public float[] getProjectionMatrix() {
        return this.projectionMatrix;
    }

    public float getSC() {
        return this.sC;
    }

    public float getSR() {
        return this.sR;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IMapConfig
    public double getSX() {
        return this.sX;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IMapConfig
    public double getSY() {
        return this.sY;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IMapConfig
    public float getSZ() {
        return this.sZ;
    }

    public float getSkyHeight() {
        return this.skyHeight;
    }

    public float[] getViewMatrix() {
        return this.viewMatrix;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IMapConfig
    public boolean isAbroadEnable() {
        return this.isAbroadEnable;
    }

    public boolean isBearingChanged() {
        return this.isBearingChanged;
    }

    public boolean isBuildingEnable() {
        return this.isBuildingEnable;
    }

    public boolean isCustomStyleEnable() {
        return this.isCustomStyleEnabled;
    }

    public boolean isHideLogoEnable() {
        return this.isHideLogoEnable;
    }

    public boolean isIndoorEnable() {
        return this.isIndoorEnable;
    }

    public boolean isMapEnable() {
        return this.mapEnable;
    }

    public boolean isMapTextEnable() {
        return this.isMapTextEnable;
    }

    public boolean isNeedUpdateZoomControllerState() {
        return this.isNeedUpdateZoomControllerState;
    }

    public boolean isProFunctionAuthEnable() {
        return this.isProFunctionAuthEnable;
    }

    public boolean isSetLimitZoomLevel() {
        return this.isSetLimitZoomLevel;
    }

    public boolean isShowsLocalLanguage() {
        return this.showsLocalLanguage;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IMapConfig
    public boolean isTerrainEnable() {
        return this.isTerrainEnable;
    }

    public boolean isTiltChanged() {
        return this.isTiltChanged;
    }

    public boolean isTouchPoiEnable() {
        return this.isTouchPoiEnable;
    }

    public boolean isTrafficEnabled() {
        return this.isTrafficEnabled;
    }

    public boolean isUseProFunction() {
        return this.isUseProFunction;
    }

    public boolean isWorldMapEnable() {
        return this.isWorldMapEnable;
    }

    public boolean isZoomChanged() {
        return this.isZoomChanged;
    }

    public MapConfig(boolean r100) {
        this.maxZoomLevel = 20.0f;
        this.minZoomLevel = 3.0f;
        this.mapRect = null;
        this.geoRectangle = new Rectangle();
        this.isIndoorEnable = false;
        this.isBuildingEnable = true;
        this.isMapTextEnable = true;
        this.isTrafficEnabled = false;
        this.isCustomStyleEnabled = false;
        this.sX = 2.21010267E8d;
        this.sY = 1.01697799E8d;
        this.mapGeoCenter = new DPoint(this.sX, this.sY);
        this.sZ = 10.0f;
        this.sC = 0.0f;
        this.sR = 0.0f;
        this.lastMapconfig = null;
        this.isCenterChanged = false;
        this.isZoomChanged = false;
        this.isTiltChanged = false;
        this.isBearingChanged = false;
        this.isNeedUpdateZoomControllerState = false;
        this.isNeedUpdateMapRectNextFrame = false;
        this.mMapStyleMode = 0;
        this.mMapStyleTime = 0;
        this.anchorX = 0;
        this.mMapLanguage = "zh_cn";
        this.showsLocalLanguage = true;
        this.isHideLogoEnable = false;
        this.isWorldMapEnable = false;
        this.isTouchPoiEnable = true;
        this.abroadState = 1;
        this.isAbroadEnable = false;
        this.isTerrainEnable = false;
        this.viewMatrix = new float[16];
        this.projectionMatrix = new float[16];
        this.mvpMatrix = new float[16];
        this.tilsIDs = new int[100];
        this.mapEnable = true;
        this.anchorY = 0;
        this.isProFunctionAuthEnable = true;
        this.isUseProFunction = false;
        this.customBackgroundColor = -1;
        this.mapZoomScale = 1.0f;
        this.changedCounter = new AtomicInteger(0);
        this.changeRatio = 1.0d;
        this.changeGridRatio = 1.0d;
        this.gridX = 0;
        this.gridY = 0;
        if (r100 == false) goto L6;
        MapConfig r101 = new MapConfig(false);
        this.lastMapconfig = r101;
        r101.setGridXY(0, 0);
        this.lastMapconfig.setSX(AudioStats.AUDIO_AMPLITUDE_NONE);
        this.lastMapconfig.setSY(AudioStats.AUDIO_AMPLITUDE_NONE);
        this.lastMapconfig.setSZ(0.0f);
        this.lastMapconfig.setSC(0.0f);
        this.lastMapconfig.setSR(0.0f);
        return;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IMapConfig
    public void setAbroadEnable(boolean r100) {
        this.isAbroadEnable = r100;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IMapConfig
    public void setAbroadState(int r100) {
        this.abroadState = r100;
    }

    public void setAnchorX(int r100) {
        this.anchorX = r100;
    }

    public void setAnchorY(int r100) {
        this.anchorY = r100;
    }

    public void setBuildingEnable(boolean r100) {
        this.isBuildingEnable = r100;
    }

    public void setCustomBackgroundColor(int r100) {
        this.customBackgroundColor = r100;
    }

    public void setCustomStyleEnable(boolean r100) {
        this.isCustomStyleEnabled = r100;
    }

    public void setCustomStyleID(String r100) {
        this.mCustomStyleID = r100;
    }

    public void setCustomStylePath(String r100) {
        this.mCustomStylePath = r100;
    }

    public void setCustomTextureResourcePath(String r100) {
        this.customTextureResourcePath = r100;
    }

    public void setHideLogoEnble(boolean r100) {
        this.isHideLogoEnable = r100;
    }

    public void setIndoorEnable(boolean r100) {
        this.isIndoorEnable = r100;
    }

    public void setLimitIPoints(IPoint[] r100) {
        this.limitIPoints = r100;
    }

    public void setLimitLatLngBounds(LatLngBounds r100) {
        this.limitLatLngBounds = r100;
        if (r100 != null) goto L6;
        resetMinMaxZoomPreference();
        return;
    }

    public void setMapEnable(boolean r100) {
        this.mapEnable = r100;
    }

    public void setMapHeight(int r100) {
        this.mapHeight = r100;
    }

    public void setMapLanguage(String r100) {
        this.mMapLanguage = r100;
    }

    public void setMapStyleMode(int r100) {
        this.mMapStyleMode = r100;
    }

    public void setMapStyleTime(int r100) {
        this.mMapStyleTime = r100;
    }

    public void setMapTextEnable(boolean r100) {
        this.isMapTextEnable = r100;
    }

    public void setMapWidth(int r100) {
        this.mapWidth = r100;
    }

    public void setMapZoomScale(float r100) {
        this.mapZoomScale = r100;
    }

    public void setMaxZoomLevel(float r100) {
        if (r100 <= 20.0f) goto L6;
        r100 = 20.0f;
    L6:
        if (r100 >= 3.0f) goto L9;
        r100 = 3.0f;
    L9:
        if (r100 >= getMinZoomLevel()) goto L11;
        r100 = getMinZoomLevel();
    L11:
        this.isSetLimitZoomLevel = true;
        this.maxZoomLevel = r100;
    }

    public void setMinZoomLevel(float r100) {
        if (r100 >= 3.0f) goto L6;
        r100 = 3.0f;
    L6:
        if (r100 <= 20.0f) goto L9;
        r100 = 20.0f;
    L9:
        if (r100 <= getMaxZoomLevel()) goto L11;
        r100 = getMaxZoomLevel();
    L11:
        this.isSetLimitZoomLevel = true;
        this.minZoomLevel = r100;
    }

    public void setProFunctionAuthEnable(boolean r100) {
        this.isProFunctionAuthEnable = r100;
    }

    public void setSC(float r100) {
        MapConfig r101 = this.lastMapconfig;
        if (r101 == null) goto L5;
        r101.setSC(this.sC);
    L5:
        this.sC = r100;
    }

    public void setSR(float r100) {
        MapConfig r101 = this.lastMapconfig;
        if (r101 == null) goto L5;
        r101.setSR(this.sR);
    L5:
        this.sR = r100;
    }

    public void setSX(double r100) {
        MapConfig r101 = this.lastMapconfig;
        if (r101 == null) goto L5;
        r101.setSX(this.sX);
    L5:
        this.sX = r100;
        this.mapGeoCenter.f30021x = r100;
    }

    public void setSY(double r100) {
        MapConfig r101 = this.lastMapconfig;
        if (r101 == null) goto L5;
        r101.setSY(this.sY);
    L5:
        this.sY = r100;
        this.mapGeoCenter.f30021x = r100;
    }

    public void setSZ(float r100) {
        MapConfig r101 = this.lastMapconfig;
        if (r101 == null) goto L5;
        r101.setSZ(this.sZ);
    L5:
        this.sZ = r100;
    }

    public void setShowsLocalLanguage(boolean r100) {
        this.showsLocalLanguage = r100;
    }

    public void setSkyHeight(float r100) {
        this.skyHeight = r100;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IMapConfig
    public void setTerrainEnable(boolean r100) {
        this.isTerrainEnable = r100;
    }

    public void setTouchPoiEnable(boolean r100) {
        this.isTouchPoiEnable = r100;
    }

    public void setTrafficEnabled(boolean r100) {
        this.isTrafficEnabled = r100;
    }

    public void setUseProFunction(boolean r100) {
        this.isUseProFunction = r100;
    }

    public void setWorldMapEnable(boolean r100) {
        this.isWorldMapEnable = r100;
    }

    public void updateMapRectNextFrame(boolean r100) {
        this.isNeedUpdateMapRectNextFrame = r100;
    }

    public void setGridXY(int r100, int r101) {
        MapConfig r102 = this.lastMapconfig;
        if (r102 == null) goto L5;
        r102.setGridXY(this.gridX, this.gridY);
    L5:
        this.gridX = r100;
        this.gridY = r101;
    }
}
