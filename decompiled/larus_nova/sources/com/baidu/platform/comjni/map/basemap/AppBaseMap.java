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

/* JADX INFO: loaded from: classes39.dex */
public class AppBaseMap {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private long f33439a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private NABaseMap f33440b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final ReadWriteLock f33441c;

    public void Remo() {
    }

    public void BeginLocationLayerAnimation() {
        this.f33440b.beginLocationLayerAnimation();
    }

    public void ClearMistmapLayer() {
        this.f33440b.clearMistmapLayer();
    }

    public boolean CloseCache() {
        return this.f33440b.closeCache();
    }

    public boolean Create() {
        this.f33441c.writeLock().lock();     // Catch: Throwable -> L5
        this.f33439a = this.f33440b.create();     // Catch: Throwable -> L5
        this.f33441c.writeLock().unlock();
        return true;
    L5:
        th = move-exception;
        this.f33441c.writeLock().unlock();
        throw th;
    }

    public long CreateDuplicate() {
        return this.f33440b.createDuplicate();
    }

    public int Draw() {
        if (this.f33439a != 0) goto L5;
        return 0;
    L5:
        return this.f33440b.draw();
    }

    public float GetAdapterZoomUnitsEx() {
        return this.f33440b.getAdapterZoomUnitsEx();
    }

    public Bundle GetDrawingMapStatus() {
        return this.f33440b.getDrawingMapStatus();
    }

    public String GetFocusedBaseIndoorMapInfo() {
        if (this.f33439a != 0) goto L5;
        return null;
    L5:
        return this.f33440b.getFocusedBaseIndoorMapInfo();
    }

    public int GetMapRenderType() {
        return this.f33440b.getMapRenderType();
    }

    public Bundle GetMapStatus() {
        return this.f33440b.getMapStatus(true);
    }

    public boolean IsBaseIndoorMapMode() {
        if (this.f33439a != 0) goto L5;
    L7:
        return false;
    L5:
        if (this.f33440b.isBaseIndoorMapMode() == false) goto L7;
        return true;
    }

    public boolean IsStreetArrowShown() {
        return this.f33440b.isStreetArrowShown();
    }

    public boolean IsStreetCustomMarkerShown() {
        return this.f33440b.isStreetCustomMarkerShown();
    }

    public boolean IsStreetPOIMarkerShown() {
        if (this.f33439a != 0) goto L5;
    L7:
        return false;
    L5:
        if (this.f33440b.isStreetPOIMarkerShown() == false) goto L7;
        return true;
    }

    public boolean IsStreetRoadClickable() {
        return this.f33440b.isStreetRoadClickable();
    }

    public void OnBackground() {
        this.f33441c.readLock().lock();     // Catch: Throwable -> L7
        if (this.f33439a == 0) goto L5;
        this.f33440b.onBackground();     // Catch: Throwable -> L7
    L5:
        this.f33441c.readLock().unlock();
        return;
    L7:
        th = move-exception;
        this.f33441c.readLock().unlock();
        throw th;
    }

    public void OnForeground() {
        this.f33441c.readLock().lock();     // Catch: Throwable -> L7
        if (this.f33439a == 0) goto L5;
        this.f33440b.onForeground();     // Catch: Throwable -> L7
    L5:
        this.f33441c.readLock().unlock();
        return;
    L7:
        th = move-exception;
        this.f33441c.readLock().unlock();
        throw th;
    }

    public String OnHotcityGet() {
        return this.f33440b.onHotcityGet();
    }

    public void OnPause() {
        this.f33441c.readLock().lock();     // Catch: Throwable -> L7
        if (this.f33439a == 0) goto L5;
        this.f33440b.onPause();     // Catch: Throwable -> L7
    L5:
        this.f33441c.readLock().unlock();
        return;
    L7:
        th = move-exception;
        this.f33441c.readLock().unlock();
        throw th;
    }

    public String OnRecordGetAll() {
        return this.f33440b.onRecordGetAll();
    }

    public void OnResume() {
        this.f33441c.readLock().lock();     // Catch: Throwable -> L7
        if (this.f33439a == 0) goto L5;
        this.f33440b.onResume();     // Catch: Throwable -> L7
    L5:
        this.f33441c.readLock().unlock();
        return;
    L7:
        th = move-exception;
        this.f33441c.readLock().unlock();
        throw th;
    }

    public boolean Release() {
        this.f33441c.writeLock().lock();     // Catch: Throwable -> L9
        long r100 = this.f33439a;     // Catch: Throwable -> L9
        if (r100 == 0) goto L7;
        BaseMapCallback.release(r100);     // Catch: Throwable -> L9
        this.f33440b.dispose();     // Catch: Throwable -> L9
        this.f33439a = 0;     // Catch: Throwable -> L9
        this.f33441c.writeLock().unlock();
        return true;
    L7:
        this.f33441c.writeLock().unlock();
        return false;
    L9:
        th = move-exception;
        this.f33441c.writeLock().unlock();
        throw th;
    }

    public void RemoveStreetAllCustomMarker() {
        this.f33440b.removeStreetAllCustomMarker();
    }

    public void ResetImageRes() {
        if (this.f33439a == 0) goto L6;
        this.f33440b.resetImageRes();
        return;
    }

    public boolean ResumeCache() {
        return this.f33440b.resumeCache();
    }

    public boolean SaveCache() {
        return this.f33440b.saveCache();
    L4:
        return false;
    }

    public void StartIndoorAnimation() {
        this.f33440b.startIndoorAnimation();
    }

    public void clearFullscreenMaskColor() {
        this.f33440b.clearFullscreenMaskColor();
    }

    public void clearParticleSystemMemory() {
        this.f33440b.clearParticleSystemMemory();
    }

    public void clearUniversalLayer() {
        this.f33440b.clearUniversalLayer();
    }

    public void exitSearchTopic() {
        this.f33440b.exitSearchTopic();
    }

    public void focusTrafficUGCLabel() {
        this.f33440b.focusTrafficUGCLabel();
    }

    public boolean get3DModelEnable() {
        return this.f33440b.get3DModelEnable();
    }

    public boolean getCustomTrafficColorEnable() {
        return this.f33440b.getCustomTrafficColorEnable();
    }

    public boolean getDEMEnable() {
        return this.f33440b.getDEMEnable();
    }

    public float getDpiScale() {
        return this.f33440b.getDpiScale();
    }

    public boolean getDrawHouseHeightEnable() {
        NABaseMap r100 = this.f33440b;
        if (r100 != null) goto L7;
        return false;
    L7:
        return r100.getDrawHouseHeightEnable();
    }

    public int getFontSizeLevel() {
        return this.f33440b.getFontSizeLevel();
    }

    public int getHouseSmoothLevel() {
        return this.f33440b.getHouseSmoothLevel();
    }

    public int getMapLanguage() {
        NABaseMap r100 = this.f33440b;
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.getMapLanguage();
    }

    public int getMapScene() {
        return this.f33440b.getMapScene();
    }

    public int getMapSceneAttr() {
        return this.f33440b.getMapSceneAttr();
    }

    public Bundle getMapStatusLimits() {
        NABaseMap r100 = this.f33440b;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getMapStatusLimits();
    }

    public int getMapTheme() {
        return this.f33440b.getMapTheme();
    }

    public float[] getProjectionMatrix() {
        NABaseMap r100 = this.f33440b;
        if (r100 != null) goto L6;
        return null;
    L6:
        float[] r101 = new float[16];
        r100.getProjectMatrix(r101);
        return r101;
    }

    public int getSkyboxStyle() {
        return this.f33440b.getSkyboxStyle();
    }

    public float[] getViewMatrix() {
        NABaseMap r100 = this.f33440b;
        if (r100 != null) goto L6;
        return null;
    L6:
        float[] r101 = new float[16];
        r100.getViewMatrix(r101);
        return r101;
    }

    public boolean getVirtualPoiShowEnable() {
        return this.f33440b.getVirtualPoiShowEnable();
    }

    public boolean isAnimationRunning() {
        return this.f33440b.isAnimationRunning();
    }

    public boolean isBaseIndoorMapShow() {
        if (this.f33439a != 0) goto L5;
    L7:
        return false;
    L5:
        if (this.f33440b.isBaseIndoorMapShow() == false) goto L7;
        return true;
    }

    public boolean isEnableIndoor3D() {
        return this.f33440b.isEnableIndoor3D();
    }

    public boolean isNaviMode() {
        return this.f33440b.isNaviMode();
    }

    public boolean isSupBackgroundDraw() {
        NABaseMap r100 = this.f33440b;
        if (r100 != null) goto L7;
        return false;
    L7:
        return r100.isSupBackgroundDraw();
    }

    public boolean releaseFromOfflineMap() {
        this.f33441c.writeLock().lock();     // Catch: Throwable -> L9
        if (this.f33439a == 0) goto L7;
        this.f33440b.dispose();     // Catch: Throwable -> L9
        this.f33439a = 0;     // Catch: Throwable -> L9
        this.f33441c.writeLock().unlock();
        return true;
    L7:
        this.f33441c.writeLock().unlock();
        return false;
    L9:
        th = move-exception;
        this.f33441c.writeLock().unlock();
        throw th;
    }

    public void renderDone() {
        this.f33441c.readLock().lock();     // Catch: Throwable -> L5
        this.f33440b.renderDone();     // Catch: Throwable -> L5
        this.f33441c.readLock().unlock();
        return;
    L5:
        th = move-exception;
        this.f33441c.readLock().unlock();
        throw th;
    }

    public int renderRender() {
        this.f33441c.readLock().lock();     // Catch: Throwable -> L5
        int r100 = this.f33440b.renderRender();     // Catch: Throwable -> L5
        this.f33441c.readLock().unlock();
        return r100;
    L5:
        th = move-exception;
        this.f33441c.readLock().unlock();
        throw th;
    }

    public void unFocusTrafficUGCLabel() {
        this.f33440b.unFocusTrafficUGCLabel();
    }

    public void updateBaseLayers() {
        if (this.f33439a == 0) goto L6;
        this.f33440b.updateBaseLayers();
        return;
    }

    public void updateDrawFPS() {
        this.f33440b.updateDrawFPS();
    }

    public void updateFootMarkGrid() {
        this.f33440b.updateFootMarkGrid();
    }

    public AppBaseMap() {
        this.f33439a = 0;
        this.f33440b = null;
        this.f33441c = new ReentrantReadWriteLock(true);
        this.f33440b = new NABaseMap();
    }

    public Bundle getBaseRoadData() {
        if (isSupBackgroundDraw() == true) goto L5;
        return null;
    L5:
        NABaseMap r100 = this.f33440b;
        if (r100 != null) goto L9;
        return null;
    L9:
        return r100.getBaseRoadData();
    }

    public long GetId() {
        return this.f33439a;
    }

    public static void renderClearShaderCache(String r100) {
        NABaseMap.renderClearShaderCache(r100);
    }

    public void AddItemData(Bundle r100) {
        AddItemData(r100, false);
    }

    public void AddPopupData(Bundle r100) {
        this.f33440b.addPopupData(r100);
    }

    public void AddRtPopData(Bundle r100) {
        this.f33440b.addRtPopData(r100);
    }

    public void ClearLayer(long r100) {
        this.f33440b.clearLayer(r100);
    }

    public void ClearLocationLayerData(Bundle r100) {
        this.f33440b.clearLocationLayerData(r100);
    }

    public void ClearSDKLayer(long r100) {
        this.f33440b.clearSDKLayer(r100);
    }

    public boolean CreateByDuplicate(long r100) {
        long r101 = this.f33440b.createByDuplicate(r100);
        this.f33439a = r101;
        if (r101 == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public int GetCacheSize(int r100) {
        return this.f33440b.getCacheSize(r100);
    }

    public String GetCityInfoByID(int r100) {
        return this.f33440b.getCityInfoByID(r100);
    }

    public Bundle GetMapStatus(boolean r100) {
        return this.f33440b.getMapStatus(r100);
    }

    public int GetVMPMapCityInfo(Bundle r100) {
        return this.f33440b.getVMPMapCityInfo(r100);
    }

    public float GetZoomToBoundF(Bundle r100) {
        return this.f33440b.getZoomToBoundF(r100);
    }

    public boolean LayersIsShow(long r100) {
        return this.f33440b.layersIsShow(r100);
    }

    public boolean OnRecordAdd(int r100) {
        return this.f33440b.onRecordAdd(r100);
    }

    public String OnRecordGetAt(int r100) {
        return this.f33440b.onRecordGetAt(r100);
    }

    public String OnSchcityGet(String r100) {
        return this.f33440b.onSchcityGet(r100);
    }

    public boolean OnUsrcityMsgInterval(int r100) {
        return this.f33440b.onUsrcityMsgInterval(r100);
    }

    public int OnWifiRecordAdd(int r100) {
        return this.f33440b.onWifiRecordAdd(r100);
    }

    public boolean RemoveItemData(Bundle r100) {
        return this.f33440b.removeItemData(r100);
    }

    public void RemoveLayer(long r100) {
        this.f33440b.removeLayer(r100);
    }

    public void RemoveStreetCustomMaker(String r100) {
        this.f33440b.removeStreetCustomMaker(r100);
    }

    public void SetAllStreetCustomMarkerVisibility(boolean r100) {
        if (this.f33439a == 0) goto L6;
        this.f33440b.setAllStreetCustomMarkerVisibility(r100);
        return;
    }

    public boolean SetCallback(a r100) {
        if (r100 == null) goto L8;
        long r101 = this.f33439a;
        if (r101 == 0) goto L8;
        if (BaseMapCallback.setMapCallback(r101, r100) == false) goto L8;
        return true;
    L8:
        return false;
    }

    public void SetLocationLayerData(Bundle r100) {
        this.f33440b.setLocationLayerData(r100);
    }

    public int SetMapControlMode(int r100) {
        return this.f33440b.setMapControlMode(r100);
    }

    public void SetMapStatus(Bundle r100) {
        this.f33440b.setMapStatus(r100);
    }

    public void SetNewMapStatus(Bundle r100) {
        this.f33440b.setNewMapStatus(r100);
    }

    public boolean SetSDKLayerCallback(MapSDKLayerDataInterface r100) {
        if (r100 == null) goto L8;
        long r101 = this.f33439a;
        if (r101 == 0) goto L8;
        if (BaseMapCallback.setMapSDKCallback(r101, r100) == false) goto L8;
        return true;
    L8:
        return false;
    }

    public void SetStreetArrowShow(boolean r100) {
        this.f33440b.setStreetArrowShow(r100);
    }

    public void SetStreetRoadClickable(boolean r100) {
        this.f33440b.setStreetRoadClickable(r100);
    }

    public void SetStyleMode(int r100) {
        this.f33440b.setStyleMode(r100);
    }

    public void ShowBaseIndoorMap(boolean r100) {
        this.f33440b.showBaseIndoorMap(r100);
    }

    public void ShowSatelliteMap(boolean r100) {
        this.f33440b.showSatelliteMap(r100);
    }

    public void ShowStreetPOIMarker(boolean r100) {
        if (this.f33439a == 0) goto L6;
        this.f33440b.showStreetPOIMarker(r100);
        return;
    }

    public void ShowStreetRoadMap(boolean r100) {
        this.f33440b.showStreetRoadMap(r100);
    }

    public void ShowTrafficMap(boolean r100) {
        this.f33440b.showTrafficMap(r100);
    }

    public void UpdateLayers(long r100) {
        this.f33440b.updateLayers(r100);
    }

    public void add3DModelIDForFilterList(String r100) {
        this.f33440b.add3DModelIDForFilterList(r100);
    }

    public void addOneOverlayItem(Bundle r100) {
        this.f33440b.addOneOverlayItem(r100);
    }

    public boolean addSDKTileData(Bundle r100) {
        return this.f33440b.nativeAddTileOverlay(this.f33439a, r100);
    }

    public void cancelPreload(int r100) {
        this.f33440b.cancelPreload(r100);
    }

    public boolean cleanSDKTileDataCache(long r100) {
        return this.f33440b.nativeCleanSDKTileDataCache(this.f33439a, r100);
    }

    public void clearHeatMapLayerCache(long r100) {
        NABaseMap r101 = this.f33440b;
        if (r101 != null) goto L5;
        return;
    L5:
        r101.clearHeatMapLayerCache(r100);
    }

    public void clearHexagonLayerCache(long r100) {
        NABaseMap r101 = this.f33440b;
        if (r101 != null) goto L5;
        return;
    L5:
        r101.clearHexagonLayerCache(r100);
    }

    public void closeParticleEffect(String r100) {
        this.f33440b.closeParticleEffect(r100);
    }

    public void closeParticleEffectByType(int r100) {
        this.f33440b.closeParticleEffectByType(r100);
    }

    public boolean downloadMapStyle(String r100) {
        return this.f33440b.downloadMapStyle(r100);
    }

    public void enablePOIAnimation(boolean r100) {
        this.f33441c.readLock().lock();     // Catch: Throwable -> L5
        this.f33440b.enablePOIAnimation(r100);     // Catch: Throwable -> L5
        this.f33441c.readLock().unlock();
        return;
    L5:
        th = move-exception;
        this.f33441c.readLock().unlock();
        throw th;
    }

    public void entrySearchTopic(int r100) {
        this.f33440b.entrySearchTopic(r100, "", "");
    }

    public boolean getCityInfoByBound(Bundle r100) {
        return this.f33440b.getCityInfoByBound(r100);
    }

    public String getCurDrawPoiInfo(int r100) {
        return this.f33440b.getCurDrawPoiInfo(r100);
    }

    public int getIndoorMapShowMode(String r100) {
        return this.f33440b.getIndoorMapShowMode(r100);
    }

    public long getLayerIDByTag(String r100) {
        NABaseMap r101 = this.f33440b;
        if (r101 != null) goto L7;
        return 0;
    L7:
        return r101.getLayerIDByTag(r100);
    }

    public boolean getMapBarData(Bundle r100) {
        return this.f33440b.getMapBarData(r100);
    }

    public boolean getMapStatusLimitsLevel(int[] r100) {
        return this.f33440b.getMapStatusLimitsLevel(r100);
    }

    public boolean getPoiTagEnable(int r100) {
        return this.f33440b.getPoiTagEnable(r100);
    }

    public String getProjectionPt(String r100) {
        return this.f33440b.getProjectionPt(r100);
    }

    public boolean importMapTheme(int r100) {
        return this.f33440b.importMapTheme(r100);
    }

    public void interruptDraw(boolean r100) {
        this.f33440b.interruptDraw(r100);
    }

    public boolean performAction(String r100) {
        return this.f33440b.performAction(r100);
    }

    public void preLoadParticleFile(String r100) {
        this.f33440b.preLoadParticleFile(r100);
    }

    public byte[] readMapResData(String r100) {
        return this.f33440b.readMapResData(r100);
    }

    public void recycleMemory(int r100) {
        this.f33440b.recycleMemory(r100);
    }

    public void remove3DModelIDForFilterList(String r100) {
        this.f33440b.remove3DModelIDForFilterList(r100);
    }

    public void removeBmLayer(long r100) {
        this.f33440b.removeBmLayer(r100);
    }

    public void removeOneOverlayItem(Bundle r100) {
        this.f33440b.removeOneOverlayItem(r100);
    }

    public void removeOverlayItems(Bundle[] r100) {
        this.f33440b.removeOneOverlayItems(r100);
    }

    public void set3DModelEnable(boolean r100) {
        this.f33440b.set3DModelEnable(r100);
    }

    public void setAutoEnter3DByZoomIn(boolean r100) {
        this.f33440b.setAutoEnter3DByZoomIn(r100);
    }

    public void setBackgroundColor(int r100) {
        this.f33440b.setBackgroundColor(r100);
    }

    public void setCustomStyleEnable(boolean r100) {
        NABaseMap r101 = this.f33440b;
        if (r101 != null) goto L5;
        return;
    L5:
        r101.setCustomStyleEnable(r100);
    }

    public void setCustomTrafficColorEnable(boolean r100) {
        this.f33440b.setCustomTrafficColorEnable(r100);
    }

    public void setDEMEnable(boolean r100) {
        this.f33440b.setDEMEnable(r100);
    }

    public void setDotPoiShowEnable(boolean r100) {
        NABaseMap r101 = this.f33440b;
        if (r101 != null) goto L5;
        return;
    L5:
        r101.setDotPoiShowEnable(r100);
    }

    public void setDpiScale(float r100) {
        this.f33440b.setDpiScale(r100);
    }

    public void setDrawHouseHeightEnable(boolean r100) {
        NABaseMap r101 = this.f33440b;
        if (r101 != null) goto L5;
        return;
    L5:
        r101.setDrawHouseHeightEnable(r100);
    }

    public void setEnableIndoor3D(boolean r100) {
        this.f33440b.setEnableIndoor3D(r100);
    }

    public void setFeatureConfig(String r100) throws JSONException {
        this.f33440b.setFeatureConfig(r100);
    }

    public void setFontSizeLevel(int r100) {
        this.f33440b.setFontSizeLevel(r100);
    }

    public void setFullscreenMaskColor(int r100) {
        this.f33440b.setFullscreenMaskColor(r100);
    }

    public void setGlobalLightEnable(boolean r100) {
        this.f33440b.setGlobalLightEnable(r100);
    }

    public void setHouseSmoothLevel(int r100) {
        this.f33440b.setHouseSmoothLevel(r100);
    }

    public void setLittle3DEnable(boolean r100) {
        this.f33440b.setLittle3DEnable(r100);
    }

    public void setMapBackgroundImage(Bundle r100) {
        this.f33440b.setMapBackgroundImage(r100);
    }

    public void setMapScene(int r100) {
        this.f33440b.setMapScene(r100);
    }

    public boolean setMapSceneAttr(int r100) {
        return this.f33440b.setMapSceneAttr(r100);
    }

    public void setMapStatusLimits(Bundle r100) {
        NABaseMap r101 = this.f33440b;
        if (r101 != null) goto L5;
        return;
    L5:
        r101.setMapStatusLimits(r100);
    }

    public void setMaxAndMinZoomLevel(Bundle r100) {
        NABaseMap r101 = this.f33440b;
        if (r101 != null) goto L5;
        return;
    L5:
        r101.setMaxAndMinZoomLevel(r100);
    }

    public void setRecommendPOIScene(int r100) {
        this.f33440b.setRecommendPOIScene(r100);
    }

    public void setSkyboxStyle(int r100) {
        this.f33440b.setSkyboxStyle(r100);
    }

    public void setStreetLayerNewDesignFlag(boolean r100) {
        this.f33440b.setStreetLayerNewDesignFlag(r100);
    }

    public void setSupBackgroundDraw(boolean r100) {
        NABaseMap r101 = this.f33440b;
        if (r101 != null) goto L5;
        return;
    L5:
        r101.setSupBackgroundDraw(r100);
    }

    public boolean setTestSwitch(boolean r100) {
        return this.f33440b.setTestSwitch(r100);
    }

    public void setTrafficUGCData(String r100) {
        this.f33440b.setTrafficUGCData(r100);
    }

    public void setUniversalFilter(String r100) {
        this.f33440b.setUniversalFilter(r100);
    }

    public void setVirtualPoiShowEnable(boolean r100) {
        this.f33440b.setVirtualPoiShowEnable(r100);
    }

    public boolean showParticleEffect(int r100) {
        return this.f33440b.showParticleEffect(r100);
    }

    public boolean showParticleEffectByFileName(String r100) {
        return this.f33440b.showParticleEffectByFileName(r100);
    }

    public boolean showParticleEffectByType(int r100) {
        return this.f33440b.showParticleEffectByType(r100);
    }

    public void showStreetPopup(boolean r100) {
        this.f33440b.showStreetPopup(r100);
    }

    public void showTrafficUGCMap(boolean r100) {
        this.f33440b.showTrafficUGCMap(r100);
    }

    public void showUniversalLayer(Bundle r100) {
        this.f33440b.showUniversalLayer(r100);
    }

    public void startHeatMapFrameAnimation(long r100) {
        NABaseMap r101 = this.f33440b;
        if (r101 != null) goto L5;
        return;
    L5:
        r101.startHeatMapFrameAnimation(r100);
    }

    public void stopHeatMapFrameAnimation(long r100) {
        NABaseMap r101 = this.f33440b;
        if (r101 != null) goto L5;
        return;
    L5:
        r101.stopHeatMapFrameAnimation(r100);
    }

    public void surfaceDestroyed(Surface r100) {
        this.f33441c.readLock().lock();     // Catch: Throwable -> L5
        this.f33440b.surfaceDestroyed(r100);     // Catch: Throwable -> L5
        this.f33441c.readLock().unlock();
        return;
    L5:
        th = move-exception;
        this.f33441c.readLock().unlock();
        throw th;
    }

    public void updateOneOverlayItem(Bundle r100) {
        this.f33440b.updateOneOverlayItem(r100);
    }

    public boolean updateSDKTile(Bundle r100) {
        return this.f33440b.nativeUpdateSDKTile(this.f33439a, r100);
    }

    public void AddItemData(Bundle r100, boolean r101) {
        this.f33440b.addItemData(r100, r101);
    }

    public void AddStreetCustomMarker(Bundle r100, Bitmap r101) {
        if (this.f33439a == 0) goto L6;
        this.f33440b.addStreetCustomMarker(r100, r101);
        return;
    }

    public String GeoPtToScrPoint(int r100, int r101) {
        return this.f33440b.geoPtToScrPoint(r100, r101);
    }

    public float GetFZoomToBoundF(Bundle r100, Bundle r101) {
        return this.f33440b.getFZoomToBoundF(r100, r101);
    }

    public boolean IsPointInFocusIDRBorder(double r100, double r101) {
        if (this.f33439a != 0) goto L5;
    L7:
        return false;
    L5:
        if (this.f33440b.isPointInFocusIDRBorder(r100, r101) == false) goto L7;
        return true;
    }

    public void MoveToScrPoint(int r100, int r101) {
        this.f33440b.moveToScrPoint(r100, r101);
    }

    public boolean OnRecordImport(boolean r100, boolean r101) {
        return this.f33440b.onRecordImport(r100, r101);
    }

    public boolean OnRecordReload(int r100, boolean r101) {
        return this.f33440b.onRecordReload(r100, r101);
    }

    public boolean OnRecordRemove(int r100, boolean r101) {
        return this.f33440b.onRecordRemove(r100, r101);
    }

    public void SaveScreenToLocal(String r100, String r101) {
        this.f33440b.saveScreenToLocal(r100, r101);
    }

    public String ScrPtToGeoPoint(int r100, int r101) {
        return this.f33440b.scrPtToGeoPoint(r100, r101);
    }

    public boolean SetLayerSceneMode(long r100, int r101) {
        return this.f33440b.setLayerSceneMode(r100, r101);
    }

    public void SetLayersClickable(long r100, boolean r101) {
        this.f33440b.setLayersClickable(r100, r101);
    }

    public void SetStreetMarkerClickable(String r100, boolean r101) {
        this.f33440b.setStreetMarkerClickable(r100, r101);
    }

    public void SetTargetStreetCustomMarkerVisibility(boolean r100, String r101) {
        if (this.f33439a == 0) goto L6;
        this.f33440b.setTargetStreetCustomMarkerVisibility(r100, r101);
        return;
    }

    public void ShowHotMap(boolean r100, int r101) {
        this.f33440b.showHotMap(r100, r101);
    }

    public void ShowLayers(long r100, boolean r101) {
        if (this.f33439a == 0) goto L6;
        this.f33440b.showLayers(r100, r101);
        return;
    }

    public void ShowMistMap(boolean r100, String r101) {
        this.f33440b.showMistMap(r100, r101);
    }

    public boolean SwitchBaseIndoorMapFloor(String r100, String r101) {
        return this.f33440b.switchBaseIndoorMapFloor(r100, r101);
    }

    public boolean SwitchLayer(long r100, long r101) {
        return this.f33440b.switchLayer(r100, r101);
    }

    public void addHexagonMapData(long r100, Bundle r101) {
        NABaseMap r102 = this.f33440b;
        if (r102 != null) goto L5;
        return;
    L5:
        r102.addHexagonMapData(r100, r101);
    }

    public void addOverlayItems(Bundle[] r100, int r101) {
        this.f33440b.addOverlayItems(r100, r101);
    }

    public boolean cleanCache(int r100, boolean r101) {
        return this.f33440b.cleanCache(r100, r101);
    }

    public boolean customParticleEffectByType(int r100, Bundle r101) {
        return this.f33440b.customParticleEffectByType(r100, r101);
    }

    public int getScaleLevel(int r100, int r101) {
        return this.f33440b.getScaleLevel(r100, r101);
    }

    public boolean initCustomStyle(String r100, String r101) {
        NABaseMap r102 = this.f33440b;
        if (r102 != null) goto L7;
        return false;
    L7:
        return r102.initCustomStyle(r100, r101);
    }

    public void initHeatMapData(long r100, Bundle r101) {
        NABaseMap r102 = this.f33440b;
        if (r102 != null) goto L5;
        return;
    L5:
        r102.initHeatMapData(r100, r101);
    }

    public boolean initWithOptions(Bundle r100, boolean r101) {
        if (this.f33439a != 0) goto L5;
    L7:
        return false;
    L5:
        if (this.f33440b.initWithOptions(r100, r101) == false) goto L7;
        return true;
    }

    public boolean moveLayerBelow(long r100, String r101) {
        return this.f33440b.moveLayerBelow(r100, r101);
    }

    public boolean moveLayerBelowTo(long r100, int r101) {
        return this.f33440b.moveLayerBelowTo(r100, r101);
    }

    public boolean preLoad(int r100, List<i> r101) {
        return this.f33440b.preLoad(r100, r101);
    }

    public void renderResize(int r100, int r101) {
        this.f33441c.readLock().lock();     // Catch: Throwable -> L5
        this.f33440b.renderResize(r100, r101);     // Catch: Throwable -> L5
        this.f33441c.readLock().unlock();
        return;
    L5:
        th = move-exception;
        this.f33441c.readLock().unlock();
        throw th;
    }

    public void resize(int r100, int r101) {
        if (this.f33439a == 0) goto L6;
        this.f33440b.renderResize(r100, r101);
        return;
    }

    public void setHeatMapFrameAnimationIndex(long r100, int r101) {
        NABaseMap r102 = this.f33440b;
        if (r102 != null) goto L5;
        return;
    L5:
        r102.setHeatMapFrameAnimationIndex(r100, r101);
    }

    public void setIndoorMapShowMode(String r100, int r101) {
        this.f33440b.setIndoorMapShowMode(r100, r101);
    }

    public void setMapLanguage(int r100, boolean r101) {
        NABaseMap r102 = this.f33440b;
        if (r102 != null) goto L5;
        return;
    L5:
        r102.setMapLanguage(r100, r101);
    }

    public boolean setMapStatusLimitsLevel(int r100, int r101) {
        return this.f33440b.setMapStatusLimitsLevel(r100, r101);
    }

    public boolean setMapTheme(int r100, Bundle r101) {
        return this.f33440b.setMapTheme(r100, r101);
    }

    public void setPoiTagEnable(int r100, boolean r101) {
        this.f33440b.setPoiTagEnable(r100, r101);
    }

    public void showFootMarkGrid(boolean r100, String r101) {
        this.f33440b.showFootMarkGrid(r100, r101);
    }

    public void showOperatorDataByType(boolean r100, int r101) {
        this.f33440b.showOperatorDataByType(r100, r101);
    }

    public boolean showParticleEffectByName(String r100, boolean r101) {
        return this.f33440b.showParticleEffectByName(r100, r101);
    }

    public boolean showParticleEffectByTypeAndStyleID(int r100, int r101) {
        return this.f33440b.showParticleEffectByTypeAndStyleID(r100, r101);
    }

    public void switchDayOrDarkTheme(int r100, boolean r101) {
        this.f33440b.switchDayOrDarkTheme(r100, r101);
    }

    public void updateHeatMapData(long r100, Bundle r101) {
        NABaseMap r102 = this.f33440b;
        if (r102 != null) goto L5;
        return;
    L5:
        r102.updateHeatMapData(r100, r101);
    }

    public long AddLayer(int r100, int r101, String r102) {
        return this.f33440b.addLayer(r100, r101, r102);
    }

    public float GetZoomToBound(Bundle r100, int r101, int r102) {
        return this.f33440b.getZoomToBound(r100, r101, r102);
    }

    public boolean IsPointInFocusBarBorder(double r110, double r111, double r112) {
        if (this.f33439a != 0) goto L5;
    L7:
        return false;
    L5:
        if (this.f33440b.isPointInFocusBarBorder(r110, r111, r112) == false) goto L7;
        return true;
    }

    public boolean OnRecordStart(int r100, boolean r101, int r102) {
        return this.f33440b.onRecordStart(r100, r101, r102);
    }

    public boolean OnRecordSuspend(int r100, boolean r101, int r102) {
        return this.f33440b.onRecordSuspend(r100, r101, r102);
    }

    public boolean SetItsPreTime(int r100, int r101, int r102) {
        return this.f33440b.setItsPreTime(r100, r101, r102);
    }

    public void ShowHotMap(boolean r100, int r101, String r102) {
        this.f33440b.showHotMap(r100, r101, r102);
    }

    public void entryFeedTopic(int r100, String r101, String r102) {
        this.f33440b.entrySearchTopic(r100, r101, r102);
    }

    public String geoPt3ToScrPoint(int r100, int r101, int r102) {
        return this.f33440b.geoPt3ToScrPoint(r100, r101, r102);
    }

    public String getStreetRoadNearPointFromCenter(double r100, double r101, int r110) {
        return this.f33440b.getStreetRoadNearPointFromCenter(r100, r101, r110);
    }

    public boolean setMapThemeScene(int r100, int r101, Bundle r102) {
        return this.f33440b.setMapThemeScene(r100, r101, r102);
    }

    public String worldPointToScreenPoint(float r100, float r101, float r102) {
        return this.f33440b.worldPointToScreenPoint(r100, r101, r102);
    }

    public String GetNearlyObjID(long r100, int r101, int r110, int r111) {
        return this.f33440b.getNearlyObjID(r100, r101, r110, r111);
    }

    public void SetFocus(long r100, long r110, boolean r111, Bundle r112) {
        this.f33440b.setFocus(r100, r110, r111, r112);
    }

    public boolean addBmLayerBelow(long r100, long r110, int r111, int r112) {
        return this.f33440b.addBmLayerBelow(r100, r110, r111, r112);
    }

    public void renderInit(int r100, int r101, Surface r102, int r103) {
        this.f33441c.readLock().lock();     // Catch: Throwable -> L5
        this.f33440b.renderInit(r100, r101, r102, r103);     // Catch: Throwable -> L5
        this.f33441c.readLock().unlock();
        return;
    L5:
        th = move-exception;
        this.f33441c.readLock().unlock();
        throw th;
    }

    public void setCustomTrafficColor(int r100, int r101, int r102, int r103) {
        this.f33440b.setCustomTrafficColor(r100, r101, r102, r103);
    }

    public boolean showParticleEffectByFilenameAndPos(String r100, float r101, float r102, float r103) {
        return this.f33440b.showParticleEffectByFilenameAndPos(r100, r101, r102, r103);
    }

    public boolean showParticleEffectByTypeAndPos(int r100, float r101, float r102, float r103) {
        return this.f33440b.showParticleEffectByTypeAndPos(r100, r101, r102, r103);
    }

    public void showTopicPOI(String r100, boolean r101, String r102, boolean r103) {
        this.f33440b.showTopicPOI(r100, r101, r102, r103);
    }

    public String getPoiMarkData(int r100, int r101, int r102, int r110, boolean r111) {
        return this.f33440b.getPoiMarkData(r100, r101, r102, r110, r111);
    }

    public void setCustomTrafficColor(int r100, int r101, int r102, int r103, boolean r104) {
        NABaseMap r105 = this.f33440b;
        if (r105 != null) goto L5;
        return;
    L5:
        r105.setCustomTrafficColorEnable(r104);
        this.f33440b.setCustomTrafficColor(r100, r101, r102, r103);
    }

    public boolean Init(String r210, String r211, String r212, String r213, String r214, String r215, String r310, int r311, int r312, int r313, int r314, int r315, int r316, int r317, boolean r318, boolean r319) {
        if (this.f33439a != 0) goto L5;
    L7:
        return false;
    L5:
        if (this.f33440b.init(r210, r211, r212, r213, r214, r215, r310, r311, r312, r313, r314, r315, r316, r317, r318, r319) == false) goto L7;
        return true;
    }
}
