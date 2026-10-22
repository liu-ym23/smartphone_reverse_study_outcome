package com.baidu.platform.comjni.map.basemap;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.Surface;
import com.baidu.mapsdkplatform.comjni.map.basemap.MapSDKLayerDataInterface;
import com.baidu.platform.comapi.map.i;
import java.util.List;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import org.json.JSONException;

/* loaded from: classes.dex */
public class AppBaseMap {

    /* renamed from: b, reason: collision with root package name */
    private NABaseMap f9319b;

    /* renamed from: a, reason: collision with root package name */
    private long f9318a = 0;

    /* renamed from: c, reason: collision with root package name */
    private final ReadWriteLock f9320c = new ReentrantReadWriteLock(true);

    public AppBaseMap() {
        this.f9319b = null;
        this.f9319b = new NABaseMap();
    }

    public static void renderClearShaderCache(String str) {
        NABaseMap.renderClearShaderCache(str);
    }

    public void AddItemData(Bundle bundle) {
        AddItemData(bundle, false);
    }

    public long AddLayer(int i4, int i5, String str) {
        return this.f9319b.addLayer(i4, i5, str);
    }

    public void AddPopupData(Bundle bundle) {
        this.f9319b.addPopupData(bundle);
    }

    public void AddRtPopData(Bundle bundle) {
        this.f9319b.addRtPopData(bundle);
    }

    public void AddStreetCustomMarker(Bundle bundle, Bitmap bitmap) {
        if (this.f9318a != 0) {
            this.f9319b.addStreetCustomMarker(bundle, bitmap);
        }
    }

    public void BeginLocationLayerAnimation() {
        this.f9319b.beginLocationLayerAnimation();
    }

    public void ClearLayer(long j4) {
        this.f9319b.clearLayer(j4);
    }

    public void ClearLocationLayerData(Bundle bundle) {
        this.f9319b.clearLocationLayerData(bundle);
    }

    public void ClearMistmapLayer() {
        this.f9319b.clearMistmapLayer();
    }

    public void ClearSDKLayer(long j4) {
        this.f9319b.clearSDKLayer(j4);
    }

    public boolean CloseCache() {
        return this.f9319b.closeCache();
    }

    public boolean Create() {
        try {
            this.f9320c.writeLock().lock();
            this.f9318a = this.f9319b.create();
            this.f9320c.writeLock().unlock();
            return true;
        } catch (Throwable th) {
            this.f9320c.writeLock().unlock();
            throw th;
        }
    }

    public boolean CreateByDuplicate(long j4) {
        long jCreateByDuplicate = this.f9319b.createByDuplicate(j4);
        this.f9318a = jCreateByDuplicate;
        return jCreateByDuplicate != 0;
    }

    public long CreateDuplicate() {
        return this.f9319b.createDuplicate();
    }

    public int Draw() {
        if (this.f9318a != 0) {
            return this.f9319b.draw();
        }
        return 0;
    }

    public String GeoPtToScrPoint(int i4, int i5) {
        return this.f9319b.geoPtToScrPoint(i4, i5);
    }

    public float GetAdapterZoomUnitsEx() {
        return this.f9319b.getAdapterZoomUnitsEx();
    }

    public int GetCacheSize(int i4) {
        return this.f9319b.getCacheSize(i4);
    }

    public String GetCityInfoByID(int i4) {
        return this.f9319b.getCityInfoByID(i4);
    }

    public Bundle GetDrawingMapStatus() {
        return this.f9319b.getDrawingMapStatus();
    }

    public float GetFZoomToBoundF(Bundle bundle, Bundle bundle2) {
        return this.f9319b.getFZoomToBoundF(bundle, bundle2);
    }

    public String GetFocusedBaseIndoorMapInfo() {
        if (this.f9318a != 0) {
            return this.f9319b.getFocusedBaseIndoorMapInfo();
        }
        return null;
    }

    public long GetId() {
        return this.f9318a;
    }

    public int GetMapRenderType() {
        return this.f9319b.getMapRenderType();
    }

    public Bundle GetMapStatus(boolean z4) {
        return this.f9319b.getMapStatus(z4);
    }

    public String GetNearlyObjID(long j4, int i4, int i5, int i6) {
        return this.f9319b.getNearlyObjID(j4, i4, i5, i6);
    }

    public int GetVMPMapCityInfo(Bundle bundle) {
        return this.f9319b.getVMPMapCityInfo(bundle);
    }

    public float GetZoomToBound(Bundle bundle, int i4, int i5) {
        return this.f9319b.getZoomToBound(bundle, i4, i5);
    }

    public float GetZoomToBoundF(Bundle bundle) {
        return this.f9319b.getZoomToBoundF(bundle);
    }

    @Deprecated
    public boolean Init(String str, String str2, String str3, String str4, String str5, String str6, String str7, int i4, int i5, int i6, int i7, int i8, int i9, int i10, boolean z4, boolean z5) {
        return this.f9318a != 0 && this.f9319b.init(str, str2, str3, str4, str5, str6, str7, i4, i5, i6, i7, i8, i9, i10, z4, z5);
    }

    public boolean IsBaseIndoorMapMode() {
        return this.f9318a != 0 && this.f9319b.isBaseIndoorMapMode();
    }

    public boolean IsPointInFocusBarBorder(double d4, double d5, double d6) {
        return this.f9318a != 0 && this.f9319b.isPointInFocusBarBorder(d4, d5, d6);
    }

    public boolean IsPointInFocusIDRBorder(double d4, double d5) {
        return this.f9318a != 0 && this.f9319b.isPointInFocusIDRBorder(d4, d5);
    }

    public boolean IsStreetArrowShown() {
        return this.f9319b.isStreetArrowShown();
    }

    public boolean IsStreetCustomMarkerShown() {
        return this.f9319b.isStreetCustomMarkerShown();
    }

    public boolean IsStreetPOIMarkerShown() {
        return this.f9318a != 0 && this.f9319b.isStreetPOIMarkerShown();
    }

    public boolean IsStreetRoadClickable() {
        return this.f9319b.isStreetRoadClickable();
    }

    public boolean LayersIsShow(long j4) {
        return this.f9319b.layersIsShow(j4);
    }

    public void MoveToScrPoint(int i4, int i5) {
        this.f9319b.moveToScrPoint(i4, i5);
    }

    public void OnBackground() {
        try {
            this.f9320c.readLock().lock();
            if (this.f9318a != 0) {
                this.f9319b.onBackground();
            }
        } finally {
            this.f9320c.readLock().unlock();
        }
    }

    public void OnForeground() {
        try {
            this.f9320c.readLock().lock();
            if (this.f9318a != 0) {
                this.f9319b.onForeground();
            }
        } finally {
            this.f9320c.readLock().unlock();
        }
    }

    public String OnHotcityGet() {
        return this.f9319b.onHotcityGet();
    }

    public void OnPause() {
        try {
            this.f9320c.readLock().lock();
            if (this.f9318a != 0) {
                this.f9319b.onPause();
            }
        } finally {
            this.f9320c.readLock().unlock();
        }
    }

    public boolean OnRecordAdd(int i4) {
        return this.f9319b.onRecordAdd(i4);
    }

    public String OnRecordGetAll() {
        return this.f9319b.onRecordGetAll();
    }

    public String OnRecordGetAt(int i4) {
        return this.f9319b.onRecordGetAt(i4);
    }

    public boolean OnRecordImport(boolean z4, boolean z5) {
        return this.f9319b.onRecordImport(z4, z5);
    }

    public boolean OnRecordReload(int i4, boolean z4) {
        return this.f9319b.onRecordReload(i4, z4);
    }

    public boolean OnRecordRemove(int i4, boolean z4) {
        return this.f9319b.onRecordRemove(i4, z4);
    }

    public boolean OnRecordStart(int i4, boolean z4, int i5) {
        return this.f9319b.onRecordStart(i4, z4, i5);
    }

    public boolean OnRecordSuspend(int i4, boolean z4, int i5) {
        return this.f9319b.onRecordSuspend(i4, z4, i5);
    }

    public void OnResume() {
        try {
            this.f9320c.readLock().lock();
            if (this.f9318a != 0) {
                this.f9319b.onResume();
            }
        } finally {
            this.f9320c.readLock().unlock();
        }
    }

    public String OnSchcityGet(String str) {
        return this.f9319b.onSchcityGet(str);
    }

    public boolean OnUsrcityMsgInterval(int i4) {
        return this.f9319b.onUsrcityMsgInterval(i4);
    }

    public int OnWifiRecordAdd(int i4) {
        return this.f9319b.onWifiRecordAdd(i4);
    }

    public boolean Release() {
        try {
            this.f9320c.writeLock().lock();
            long j4 = this.f9318a;
            if (j4 == 0) {
                this.f9320c.writeLock().unlock();
                return false;
            }
            BaseMapCallback.release(j4);
            this.f9319b.dispose();
            this.f9318a = 0L;
            this.f9320c.writeLock().unlock();
            return true;
        } catch (Throwable th) {
            this.f9320c.writeLock().unlock();
            throw th;
        }
    }

    public void Remo() {
    }

    public boolean RemoveItemData(Bundle bundle) {
        return this.f9319b.removeItemData(bundle);
    }

    public void RemoveLayer(long j4) {
        this.f9319b.removeLayer(j4);
    }

    public void RemoveStreetAllCustomMarker() {
        this.f9319b.removeStreetAllCustomMarker();
    }

    public void RemoveStreetCustomMaker(String str) {
        this.f9319b.removeStreetCustomMaker(str);
    }

    public void ResetImageRes() {
        if (this.f9318a != 0) {
            this.f9319b.resetImageRes();
        }
    }

    public boolean ResumeCache() {
        return this.f9319b.resumeCache();
    }

    public boolean SaveCache() {
        try {
            return this.f9319b.saveCache();
        } catch (Throwable unused) {
            return false;
        }
    }

    public void SaveScreenToLocal(String str, String str2) {
        this.f9319b.saveScreenToLocal(str, str2);
    }

    public String ScrPtToGeoPoint(int i4, int i5) {
        return this.f9319b.scrPtToGeoPoint(i4, i5);
    }

    public void SetAllStreetCustomMarkerVisibility(boolean z4) {
        if (this.f9318a != 0) {
            this.f9319b.setAllStreetCustomMarkerVisibility(z4);
        }
    }

    public boolean SetCallback(a aVar) {
        if (aVar != null) {
            long j4 = this.f9318a;
            if (j4 != 0 && BaseMapCallback.setMapCallback(j4, aVar)) {
                return true;
            }
        }
        return false;
    }

    public void SetFocus(long j4, long j5, boolean z4, Bundle bundle) {
        this.f9319b.setFocus(j4, j5, z4, bundle);
    }

    public boolean SetItsPreTime(int i4, int i5, int i6) {
        return this.f9319b.setItsPreTime(i4, i5, i6);
    }

    public boolean SetLayerSceneMode(long j4, int i4) {
        return this.f9319b.setLayerSceneMode(j4, i4);
    }

    public void SetLayersClickable(long j4, boolean z4) {
        this.f9319b.setLayersClickable(j4, z4);
    }

    public void SetLocationLayerData(Bundle bundle) {
        this.f9319b.setLocationLayerData(bundle);
    }

    public int SetMapControlMode(int i4) {
        return this.f9319b.setMapControlMode(i4);
    }

    public void SetMapStatus(Bundle bundle) {
        this.f9319b.setMapStatus(bundle);
    }

    public void SetNewMapStatus(Bundle bundle) {
        this.f9319b.setNewMapStatus(bundle);
    }

    public boolean SetSDKLayerCallback(MapSDKLayerDataInterface mapSDKLayerDataInterface) {
        if (mapSDKLayerDataInterface != null) {
            long j4 = this.f9318a;
            if (j4 != 0 && BaseMapCallback.setMapSDKCallback(j4, mapSDKLayerDataInterface)) {
                return true;
            }
        }
        return false;
    }

    public void SetStreetArrowShow(boolean z4) {
        this.f9319b.setStreetArrowShow(z4);
    }

    public void SetStreetMarkerClickable(String str, boolean z4) {
        this.f9319b.setStreetMarkerClickable(str, z4);
    }

    public void SetStreetRoadClickable(boolean z4) {
        this.f9319b.setStreetRoadClickable(z4);
    }

    public void SetStyleMode(int i4) {
        this.f9319b.setStyleMode(i4);
    }

    public void SetTargetStreetCustomMarkerVisibility(boolean z4, String str) {
        if (this.f9318a != 0) {
            this.f9319b.setTargetStreetCustomMarkerVisibility(z4, str);
        }
    }

    public void ShowBaseIndoorMap(boolean z4) {
        this.f9319b.showBaseIndoorMap(z4);
    }

    public void ShowHotMap(boolean z4, int i4) {
        this.f9319b.showHotMap(z4, i4);
    }

    public void ShowLayers(long j4, boolean z4) {
        if (this.f9318a != 0) {
            this.f9319b.showLayers(j4, z4);
        }
    }

    public void ShowMistMap(boolean z4, String str) {
        this.f9319b.showMistMap(z4, str);
    }

    public void ShowSatelliteMap(boolean z4) {
        this.f9319b.showSatelliteMap(z4);
    }

    public void ShowStreetPOIMarker(boolean z4) {
        if (this.f9318a != 0) {
            this.f9319b.showStreetPOIMarker(z4);
        }
    }

    public void ShowStreetRoadMap(boolean z4) {
        this.f9319b.showStreetRoadMap(z4);
    }

    public void ShowTrafficMap(boolean z4) {
        this.f9319b.showTrafficMap(z4);
    }

    public void StartIndoorAnimation() {
        this.f9319b.startIndoorAnimation();
    }

    public boolean SwitchBaseIndoorMapFloor(String str, String str2) {
        return this.f9319b.switchBaseIndoorMapFloor(str, str2);
    }

    public boolean SwitchLayer(long j4, long j5) {
        return this.f9319b.switchLayer(j4, j5);
    }

    public void UpdateLayers(long j4) {
        this.f9319b.updateLayers(j4);
    }

    public void add3DModelIDForFilterList(String str) {
        this.f9319b.add3DModelIDForFilterList(str);
    }

    public boolean addBmLayerBelow(long j4, long j5, int i4, int i5) {
        return this.f9319b.addBmLayerBelow(j4, j5, i4, i5);
    }

    public void addHexagonMapData(long j4, Bundle bundle) {
        NABaseMap nABaseMap = this.f9319b;
        if (nABaseMap == null) {
            return;
        }
        nABaseMap.addHexagonMapData(j4, bundle);
    }

    public void addOneOverlayItem(Bundle bundle) {
        this.f9319b.addOneOverlayItem(bundle);
    }

    public void addOverlayItems(Bundle[] bundleArr, int i4) {
        this.f9319b.addOverlayItems(bundleArr, i4);
    }

    public boolean addSDKTileData(Bundle bundle) {
        return this.f9319b.nativeAddTileOverlay(this.f9318a, bundle);
    }

    public void cancelPreload(int i4) {
        this.f9319b.cancelPreload(i4);
    }

    public boolean cleanCache(int i4, boolean z4) {
        return this.f9319b.cleanCache(i4, z4);
    }

    public boolean cleanSDKTileDataCache(long j4) {
        return this.f9319b.nativeCleanSDKTileDataCache(this.f9318a, j4);
    }

    public void clearFullscreenMaskColor() {
        this.f9319b.clearFullscreenMaskColor();
    }

    public void clearHeatMapLayerCache(long j4) {
        NABaseMap nABaseMap = this.f9319b;
        if (nABaseMap == null) {
            return;
        }
        nABaseMap.clearHeatMapLayerCache(j4);
    }

    public void clearHexagonLayerCache(long j4) {
        NABaseMap nABaseMap = this.f9319b;
        if (nABaseMap == null) {
            return;
        }
        nABaseMap.clearHexagonLayerCache(j4);
    }

    public void clearParticleSystemMemory() {
        this.f9319b.clearParticleSystemMemory();
    }

    public void clearUniversalLayer() {
        this.f9319b.clearUniversalLayer();
    }

    public void closeParticleEffect(String str) {
        this.f9319b.closeParticleEffect(str);
    }

    public void closeParticleEffectByType(int i4) {
        this.f9319b.closeParticleEffectByType(i4);
    }

    public boolean customParticleEffectByType(int i4, Bundle bundle) {
        return this.f9319b.customParticleEffectByType(i4, bundle);
    }

    public void enablePOIAnimation(boolean z4) {
        try {
            this.f9320c.readLock().lock();
            this.f9319b.enablePOIAnimation(z4);
        } finally {
            this.f9320c.readLock().unlock();
        }
    }

    public void entryFeedTopic(int i4, String str, String str2) {
        this.f9319b.entrySearchTopic(i4, str, str2);
    }

    public void entrySearchTopic(int i4) {
        this.f9319b.entrySearchTopic(i4, "", "");
    }

    public void exitSearchTopic() {
        this.f9319b.exitSearchTopic();
    }

    public void focusTrafficUGCLabel() {
        this.f9319b.focusTrafficUGCLabel();
    }

    public String geoPt3ToScrPoint(int i4, int i5, int i6) {
        return this.f9319b.geoPt3ToScrPoint(i4, i5, i6);
    }

    public boolean get3DModelEnable() {
        return this.f9319b.get3DModelEnable();
    }

    public Bundle getBaseRoadData() {
        NABaseMap nABaseMap;
        if (isSupBackgroundDraw() && (nABaseMap = this.f9319b) != null) {
            return nABaseMap.getBaseRoadData();
        }
        return null;
    }

    public boolean getCityInfoByBound(Bundle bundle) {
        return this.f9319b.getCityInfoByBound(bundle);
    }

    public String getCurDrawPoiInfo(int i4) {
        return this.f9319b.getCurDrawPoiInfo(i4);
    }

    public boolean getCustomTrafficColorEnable() {
        return this.f9319b.getCustomTrafficColorEnable();
    }

    public boolean getDEMEnable() {
        return this.f9319b.getDEMEnable();
    }

    public float getDpiScale() {
        return this.f9319b.getDpiScale();
    }

    public boolean getDrawHouseHeightEnable() {
        NABaseMap nABaseMap = this.f9319b;
        if (nABaseMap == null) {
            return false;
        }
        return nABaseMap.getDrawHouseHeightEnable();
    }

    public int getFontSizeLevel() {
        return this.f9319b.getFontSizeLevel();
    }

    public int getHouseSmoothLevel() {
        return this.f9319b.getHouseSmoothLevel();
    }

    public int getIndoorMapShowMode(String str) {
        return this.f9319b.getIndoorMapShowMode(str);
    }

    public long getLayerIDByTag(String str) {
        NABaseMap nABaseMap = this.f9319b;
        if (nABaseMap == null) {
            return 0L;
        }
        return nABaseMap.getLayerIDByTag(str);
    }

    public boolean getMapBarData(Bundle bundle) {
        return this.f9319b.getMapBarData(bundle);
    }

    public int getMapLanguage() {
        NABaseMap nABaseMap = this.f9319b;
        if (nABaseMap == null) {
            return 0;
        }
        return nABaseMap.getMapLanguage();
    }

    public int getMapScene() {
        return this.f9319b.getMapScene();
    }

    public int getMapSceneAttr() {
        return this.f9319b.getMapSceneAttr();
    }

    public Bundle getMapStatusLimits() {
        NABaseMap nABaseMap = this.f9319b;
        if (nABaseMap == null) {
            return null;
        }
        return nABaseMap.getMapStatusLimits();
    }

    public boolean getMapStatusLimitsLevel(int[] iArr) {
        return this.f9319b.getMapStatusLimitsLevel(iArr);
    }

    public int getMapTheme() {
        return this.f9319b.getMapTheme();
    }

    public String getPoiMarkData(int i4, int i5, int i6, int i7, boolean z4) {
        return this.f9319b.getPoiMarkData(i4, i5, i6, i7, z4);
    }

    public boolean getPoiTagEnable(int i4) {
        return this.f9319b.getPoiTagEnable(i4);
    }

    public float[] getProjectionMatrix() {
        NABaseMap nABaseMap = this.f9319b;
        if (nABaseMap == null) {
            return null;
        }
        float[] fArr = new float[16];
        nABaseMap.getProjectMatrix(fArr);
        return fArr;
    }

    public String getProjectionPt(String str) {
        return this.f9319b.getProjectionPt(str);
    }

    public int getScaleLevel(int i4, int i5) {
        return this.f9319b.getScaleLevel(i4, i5);
    }

    public int getSkyboxStyle() {
        return this.f9319b.getSkyboxStyle();
    }

    public String getStreetRoadNearPointFromCenter(double d4, double d5, int i4) {
        return this.f9319b.getStreetRoadNearPointFromCenter(d4, d5, i4);
    }

    public float[] getViewMatrix() {
        NABaseMap nABaseMap = this.f9319b;
        if (nABaseMap == null) {
            return null;
        }
        float[] fArr = new float[16];
        nABaseMap.getViewMatrix(fArr);
        return fArr;
    }

    public boolean getVirtualPoiShowEnable() {
        return this.f9319b.getVirtualPoiShowEnable();
    }

    public boolean importMapTheme(int i4) {
        return this.f9319b.importMapTheme(i4);
    }

    public boolean initCustomStyle(String str, String str2) {
        NABaseMap nABaseMap = this.f9319b;
        if (nABaseMap == null) {
            return false;
        }
        return nABaseMap.initCustomStyle(str, str2);
    }

    public void initHeatMapData(long j4, Bundle bundle) {
        NABaseMap nABaseMap = this.f9319b;
        if (nABaseMap == null) {
            return;
        }
        nABaseMap.initHeatMapData(j4, bundle);
    }

    public boolean initWithOptions(Bundle bundle, boolean z4) {
        return this.f9318a != 0 && this.f9319b.initWithOptions(bundle, z4);
    }

    public void interruptDraw(boolean z4) {
        this.f9319b.interruptDraw(z4);
    }

    public boolean isAnimationRunning() {
        return this.f9319b.isAnimationRunning();
    }

    public boolean isBaseIndoorMapShow() {
        return this.f9318a != 0 && this.f9319b.isBaseIndoorMapShow();
    }

    public boolean isEnableIndoor3D() {
        return this.f9319b.isEnableIndoor3D();
    }

    public boolean isNaviMode() {
        return this.f9319b.isNaviMode();
    }

    public boolean isSupBackgroundDraw() {
        NABaseMap nABaseMap = this.f9319b;
        if (nABaseMap == null) {
            return false;
        }
        return nABaseMap.isSupBackgroundDraw();
    }

    public boolean moveLayerBelow(long j4, String str) {
        return this.f9319b.moveLayerBelow(j4, str);
    }

    public boolean moveLayerBelowTo(long j4, int i4) {
        return this.f9319b.moveLayerBelowTo(j4, i4);
    }

    public boolean performAction(String str) {
        return this.f9319b.performAction(str);
    }

    public boolean preLoad(int i4, List<i> list) {
        return this.f9319b.preLoad(i4, list);
    }

    public void preLoadParticleFile(String str) {
        this.f9319b.preLoadParticleFile(str);
    }

    public byte[] readMapResData(String str) {
        return this.f9319b.readMapResData(str);
    }

    public void recycleMemory(int i4) {
        this.f9319b.recycleMemory(i4);
    }

    public boolean releaseFromOfflineMap() {
        try {
            this.f9320c.writeLock().lock();
            if (this.f9318a == 0) {
                this.f9320c.writeLock().unlock();
                return false;
            }
            this.f9319b.dispose();
            this.f9318a = 0L;
            this.f9320c.writeLock().unlock();
            return true;
        } catch (Throwable th) {
            this.f9320c.writeLock().unlock();
            throw th;
        }
    }

    public void remove3DModelIDForFilterList(String str) {
        this.f9319b.remove3DModelIDForFilterList(str);
    }

    public void removeBmLayer(long j4) {
        this.f9319b.removeBmLayer(j4);
    }

    public void removeOneOverlayItem(Bundle bundle) {
        this.f9319b.removeOneOverlayItem(bundle);
    }

    public void removeOverlayItems(Bundle[] bundleArr) {
        this.f9319b.removeOneOverlayItems(bundleArr);
    }

    public void renderDone() {
        try {
            this.f9320c.readLock().lock();
            this.f9319b.renderDone();
        } finally {
            this.f9320c.readLock().unlock();
        }
    }

    public void renderInit(int i4, int i5, Surface surface, int i6) {
        try {
            this.f9320c.readLock().lock();
            this.f9319b.renderInit(i4, i5, surface, i6);
        } finally {
            this.f9320c.readLock().unlock();
        }
    }

    public int renderRender() {
        try {
            this.f9320c.readLock().lock();
            return this.f9319b.renderRender();
        } finally {
            this.f9320c.readLock().unlock();
        }
    }

    public void renderResize(int i4, int i5) {
        try {
            this.f9320c.readLock().lock();
            this.f9319b.renderResize(i4, i5);
        } finally {
            this.f9320c.readLock().unlock();
        }
    }

    public void resize(int i4, int i5) {
        if (this.f9318a != 0) {
            this.f9319b.renderResize(i4, i5);
        }
    }

    public void set3DModelEnable(boolean z4) {
        this.f9319b.set3DModelEnable(z4);
    }

    public void setAutoEnter3DByZoomIn(boolean z4) {
        this.f9319b.setAutoEnter3DByZoomIn(z4);
    }

    public void setBackgroundColor(int i4) {
        this.f9319b.setBackgroundColor(i4);
    }

    public void setCustomStyleEnable(boolean z4) {
        NABaseMap nABaseMap = this.f9319b;
        if (nABaseMap == null) {
            return;
        }
        nABaseMap.setCustomStyleEnable(z4);
    }

    public void setCustomTrafficColor(int i4, int i5, int i6, int i7) {
        this.f9319b.setCustomTrafficColor(i4, i5, i6, i7);
    }

    public void setCustomTrafficColorEnable(boolean z4) {
        this.f9319b.setCustomTrafficColorEnable(z4);
    }

    public void setDEMEnable(boolean z4) {
        this.f9319b.setDEMEnable(z4);
    }

    public void setDpiScale(float f4) {
        this.f9319b.setDpiScale(f4);
    }

    public void setDrawHouseHeightEnable(boolean z4) {
        NABaseMap nABaseMap = this.f9319b;
        if (nABaseMap == null) {
            return;
        }
        nABaseMap.setDrawHouseHeightEnable(z4);
    }

    public void setEnableIndoor3D(boolean z4) {
        this.f9319b.setEnableIndoor3D(z4);
    }

    public void setFeatureConfig(String str) throws JSONException {
        this.f9319b.setFeatureConfig(str);
    }

    public void setFontSizeLevel(int i4) {
        this.f9319b.setFontSizeLevel(i4);
    }

    public void setFullscreenMaskColor(int i4) {
        this.f9319b.setFullscreenMaskColor(i4);
    }

    public void setGlobalLightEnable(boolean z4) {
        this.f9319b.setGlobalLightEnable(z4);
    }

    public void setHeatMapFrameAnimationIndex(long j4, int i4) {
        NABaseMap nABaseMap = this.f9319b;
        if (nABaseMap == null) {
            return;
        }
        nABaseMap.setHeatMapFrameAnimationIndex(j4, i4);
    }

    public void setHouseSmoothLevel(int i4) {
        this.f9319b.setHouseSmoothLevel(i4);
    }

    public void setIndoorMapShowMode(String str, int i4) {
        this.f9319b.setIndoorMapShowMode(str, i4);
    }

    public void setLittle3DEnable(boolean z4) {
        this.f9319b.setLittle3DEnable(z4);
    }

    public void setMapBackgroundImage(Bundle bundle) {
        this.f9319b.setMapBackgroundImage(bundle);
    }

    public void setMapLanguage(int i4, boolean z4) {
        NABaseMap nABaseMap = this.f9319b;
        if (nABaseMap == null) {
            return;
        }
        nABaseMap.setMapLanguage(i4, z4);
    }

    public void setMapScene(int i4) {
        this.f9319b.setMapScene(i4);
    }

    public boolean setMapSceneAttr(int i4) {
        return this.f9319b.setMapSceneAttr(i4);
    }

    public void setMapStatusLimits(Bundle bundle) {
        NABaseMap nABaseMap = this.f9319b;
        if (nABaseMap == null) {
            return;
        }
        nABaseMap.setMapStatusLimits(bundle);
    }

    public boolean setMapStatusLimitsLevel(int i4, int i5) {
        return this.f9319b.setMapStatusLimitsLevel(i4, i5);
    }

    public boolean setMapTheme(int i4, Bundle bundle) {
        return this.f9319b.setMapTheme(i4, bundle);
    }

    public boolean setMapThemeScene(int i4, int i5, Bundle bundle) {
        return this.f9319b.setMapThemeScene(i4, i5, bundle);
    }

    public void setMaxAndMinZoomLevel(Bundle bundle) {
        NABaseMap nABaseMap = this.f9319b;
        if (nABaseMap == null) {
            return;
        }
        nABaseMap.setMaxAndMinZoomLevel(bundle);
    }

    public void setPoiTagEnable(int i4, boolean z4) {
        this.f9319b.setPoiTagEnable(i4, z4);
    }

    public void setRecommendPOIScene(int i4) {
        this.f9319b.setRecommendPOIScene(i4);
    }

    public void setSkyboxStyle(int i4) {
        this.f9319b.setSkyboxStyle(i4);
    }

    public void setStreetLayerNewDesignFlag(boolean z4) {
        this.f9319b.setStreetLayerNewDesignFlag(z4);
    }

    public void setSupBackgroundDraw(boolean z4) {
        NABaseMap nABaseMap = this.f9319b;
        if (nABaseMap == null) {
            return;
        }
        nABaseMap.setSupBackgroundDraw(z4);
    }

    public boolean setTestSwitch(boolean z4) {
        return this.f9319b.setTestSwitch(z4);
    }

    public void setTrafficUGCData(String str) {
        this.f9319b.setTrafficUGCData(str);
    }

    public void setUniversalFilter(String str) {
        this.f9319b.setUniversalFilter(str);
    }

    public void setVirtualPoiShowEnable(boolean z4) {
        this.f9319b.setVirtualPoiShowEnable(z4);
    }

    public void showFootMarkGrid(boolean z4, String str) {
        this.f9319b.showFootMarkGrid(z4, str);
    }

    public void showOperatorDataByType(boolean z4, int i4) {
        this.f9319b.showOperatorDataByType(z4, i4);
    }

    public boolean showParticleEffect(int i4) {
        return this.f9319b.showParticleEffect(i4);
    }

    public boolean showParticleEffectByFileName(String str) {
        return this.f9319b.showParticleEffectByFileName(str);
    }

    public boolean showParticleEffectByFilenameAndPos(String str, float f4, float f5, float f6) {
        return this.f9319b.showParticleEffectByFilenameAndPos(str, f4, f5, f6);
    }

    public boolean showParticleEffectByName(String str, boolean z4) {
        return this.f9319b.showParticleEffectByName(str, z4);
    }

    public boolean showParticleEffectByType(int i4) {
        return this.f9319b.showParticleEffectByType(i4);
    }

    public boolean showParticleEffectByTypeAndPos(int i4, float f4, float f5, float f6) {
        return this.f9319b.showParticleEffectByTypeAndPos(i4, f4, f5, f6);
    }

    public boolean showParticleEffectByTypeAndStyleID(int i4, int i5) {
        return this.f9319b.showParticleEffectByTypeAndStyleID(i4, i5);
    }

    public void showStreetPopup(boolean z4) {
        this.f9319b.showStreetPopup(z4);
    }

    public void showTopicPOI(String str, boolean z4, String str2, boolean z5) {
        this.f9319b.showTopicPOI(str, z4, str2, z5);
    }

    public void showTrafficUGCMap(boolean z4) {
        this.f9319b.showTrafficUGCMap(z4);
    }

    public void showUniversalLayer(Bundle bundle) {
        this.f9319b.showUniversalLayer(bundle);
    }

    public void startHeatMapFrameAnimation(long j4) {
        NABaseMap nABaseMap = this.f9319b;
        if (nABaseMap == null) {
            return;
        }
        nABaseMap.startHeatMapFrameAnimation(j4);
    }

    public void stopHeatMapFrameAnimation(long j4) {
        NABaseMap nABaseMap = this.f9319b;
        if (nABaseMap == null) {
            return;
        }
        nABaseMap.stopHeatMapFrameAnimation(j4);
    }

    public void surfaceDestroyed(Surface surface) {
        try {
            this.f9320c.readLock().lock();
            this.f9319b.surfaceDestroyed(surface);
        } finally {
            this.f9320c.readLock().unlock();
        }
    }

    public void switchDayOrDarkTheme(int i4, boolean z4) {
        this.f9319b.switchDayOrDarkTheme(i4, z4);
    }

    public void unFocusTrafficUGCLabel() {
        this.f9319b.unFocusTrafficUGCLabel();
    }

    public void updateBaseLayers() {
        this.f9319b.updateBaseLayers();
    }

    public void updateDrawFPS() {
        this.f9319b.updateDrawFPS();
    }

    public void updateFootMarkGrid() {
        this.f9319b.updateFootMarkGrid();
    }

    public void updateHeatMapData(long j4, Bundle bundle) {
        NABaseMap nABaseMap = this.f9319b;
        if (nABaseMap == null) {
            return;
        }
        nABaseMap.updateHeatMapData(j4, bundle);
    }

    public void updateOneOverlayItem(Bundle bundle) {
        this.f9319b.updateOneOverlayItem(bundle);
    }

    public boolean updateSDKTile(Bundle bundle) {
        return this.f9319b.nativeUpdateSDKTile(this.f9318a, bundle);
    }

    public String worldPointToScreenPoint(float f4, float f5, float f6) {
        return this.f9319b.worldPointToScreenPoint(f4, f5, f6);
    }

    public void AddItemData(Bundle bundle, boolean z4) {
        this.f9319b.addItemData(bundle, z4);
    }

    public Bundle GetMapStatus() {
        return this.f9319b.getMapStatus(true);
    }

    public void ShowHotMap(boolean z4, int i4, String str) {
        this.f9319b.showHotMap(z4, i4, str);
    }

    public void setCustomTrafficColor(int i4, int i5, int i6, int i7, boolean z4) {
        NABaseMap nABaseMap = this.f9319b;
        if (nABaseMap == null) {
            return;
        }
        nABaseMap.setCustomTrafficColorEnable(z4);
        this.f9319b.setCustomTrafficColor(i4, i5, i6, i7);
    }
}
