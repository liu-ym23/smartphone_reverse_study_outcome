package com.autonavi.base.ae.gmap;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.alipay.sdk.m.c.a;
import com.amap.api.mapcore.util.p3;
import com.amap.api.mapcore.util.p5;
import com.amap.api.mapcore.util.t6;
import com.amap.api.mapcore.util.v3;
import com.amap.api.mapcore.util.w3;
import com.amap.api.maps.AMap;
import com.amap.api.maps.ITileLoadCallback;
import com.amap.api.maps.MapsInitializer;
import com.amap.api.maps.model.BitmapDescriptor;
import com.amap.api.maps.model.BitmapDescriptorFactory;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.MyTrafficStyle;
import com.amap.api.maps.model.PoiFilter;
import com.autonavi.amap.api.mapcore.IGLMapEngine;
import com.autonavi.amap.api.mapcore.IGLMapState;
import com.autonavi.amap.mapcore.AMapEngineUtils;
import com.autonavi.amap.mapcore.AbstractCameraUpdateMessage;
import com.autonavi.base.ae.gmap.bean.InitStorageParam;
import com.autonavi.base.ae.gmap.bean.TileProviderInner;
import com.autonavi.base.ae.gmap.gesture.EAMapPlatformGestureInfo;
import com.autonavi.base.ae.gmap.glanimation.AbstractAdglAnimation;
import com.autonavi.base.ae.gmap.glanimation.AdglMapAnimFling;
import com.autonavi.base.ae.gmap.glanimation.AdglMapAnimFlingP20;
import com.autonavi.base.ae.gmap.glanimation.AdglMapAnimGroup;
import com.autonavi.base.ae.gmap.glanimation.AdglMapAnimationMgr;
import com.autonavi.base.ae.gmap.gloverlay.BaseMapOverlay;
import com.autonavi.base.ae.gmap.gloverlay.GLOverlayBundle;
import com.autonavi.base.ae.gmap.gloverlay.GLTextureProperty;
import com.autonavi.base.ae.gmap.style.StyleItem;
import com.autonavi.base.amap.api.mapcore.IAMapDelegate;
import com.autonavi.base.amap.mapcore.FileUtil;
import com.autonavi.base.amap.mapcore.IAMapEngineCallback;
import com.autonavi.base.amap.mapcore.interfaces.IAMapListener;
import com.autonavi.base.amap.mapcore.maploader.AMapLoader;
import com.autonavi.base.amap.mapcore.maploader.NetworkState;
import com.autonavi.base.amap.mapcore.message.AbstractGestureMapMessage;
import com.autonavi.base.amap.mapcore.message.HoverGestureMapMessage;
import com.autonavi.base.amap.mapcore.message.MoveGestureMapMessage;
import com.autonavi.base.amap.mapcore.message.RotateGestureMapMessage;
import com.autonavi.base.amap.mapcore.message.ScaleGestureMapMessage;
import com.autonavi.base.amap.mapcore.tools.TextTextureGenerator;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import java.io.File;
import java.lang.reflect.Field;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes39.dex */
public class GLMapEngine implements IAMapEngineCallback, IGLMapEngine {
    private static volatile NetworkProxyManager sNetworkProxyManager;
    GLOverlayBundle<BaseMapOverlay<?, ?>> bundle;
    private Context context;
    private GLMapState copyGLMapState;
    private boolean isEngineRenderComplete;
    boolean isGestureStep;
    boolean isMoveCameraStep;
    boolean isNetworkConnected;
    private final List<AbstractCameraUpdateMessage> mAnimateStateMessageList;
    private int mEngineID;
    private List<AbstractGestureMapMessage> mGestureEndMessageList;
    private final List<AbstractGestureMapMessage> mGestureMessageList;
    private IAMapDelegate mGlMapView;
    private Lock mLock;
    private IAMapListener mMapListener;
    private long mNativeMapengineInstance;
    private NetworkState mNetworkState;
    boolean mRequestDestroy;
    private AtomicInteger mRequestID;
    private final List<AbstractCameraUpdateMessage> mStateMessageList;
    private TextTextureGenerator mTextTextureGenerator;
    private AdglMapAnimationMgr mapAnimationMgr;
    private int mapGestureCount;
    private Object mutLock;
    GLMapState state;
    private TerrainOverlayProvider terrainTileProvider;

    public static class InitParam {
        public String mConfigContent;
        public String mConfigPath;
        public String mIntersectionResPath;
        public String mOfflineDataPath;
        public String mOnlineMapDataPath;
        public String mP3dCrossPath;
        public String mRootPath;

        public InitParam() {
            this.mRootPath = "";
            this.mConfigPath = "";
            this.mConfigContent = "";
            this.mOnlineMapDataPath = "";
            this.mOfflineDataPath = "";
            this.mP3dCrossPath = "";
            this.mIntersectionResPath = "";
        }
    }

    public static class MapViewInitParam {
        public int engineId;
        public int height;
        public float mapZoomScale;
        public int screenHeight;
        public float screenScale;
        public int screenWidth;
        public int taskThreadCount;
        public float textScale;
        public int width;

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        public int f30025x;

        /* JADX INFO: renamed from: y, reason: collision with root package name */
        public int f30026y;

        public MapViewInitParam() {
            this.taskThreadCount = 8;
        }
    }

    public static /* synthetic */ Class access$001(String r100) throws ClassNotFoundException {
        return Class.forName(r100);
    }

    public static native void nativeAddGestureSingleTapMessage(int r100, long r101, float r102, float r103);

    public static native String nativeAddNativeOverlay(int r100, long r101, int r102, int r103);

    private static native boolean nativeAddOverlayTexture(int r100, long r101, int r102, int r103, float r104, float r105, Bitmap r106, boolean r107, boolean r108);

    private static native void nativeAddPoiFilter(int r100, long r101, PoiFilter r102);

    private static native void nativeCancelDownLoad(long r100);

    private static native boolean nativeCheckCustomStyleData(int r100, long r101, byte[] r102);

    private static native void nativeClearMapDataCache();

    private static native void nativeClearPoiFilter(int r100, long r101);

    private static native void nativeCreateAMapEngineWithFrame(long r100, int r101, int r102, int r103, int r104, int r105, int r106, int r107, float r108, float r110, float r111, int r112);

    private static native long nativeCreateAMapInstance(float r100, float r101, float r102, int r103, boolean r104);

    public static native long nativeCreateOverlay(int r100, long r101, int r102);

    private static native int nativeCreateTextureFromImage(int r100, long r101, Bitmap r102);

    private static native void nativeDestroy(long r100);

    private static native void nativeDestroyCurrentState(long r100, long r101);

    public static native void nativeDestroyOverlay(int r100, long r101);

    private static native void nativeFailedDownLoad(long r100, int r101);

    private static native void nativeFinishDownLoad(long r100);

    private static native void nativeGetCurTileIDs(int r100, long r101, int[] r102, int r103);

    private static native long nativeGetCurrentMapState(int r100, long r101);

    private static native long nativeGetGlOverlayMgrPtr(int r100, long r101);

    public static native String nativeGetMapEngineVersion(int r100);

    private static native int[] nativeGetMapModeState(int r100, long r101, boolean r102);

    public static native String nativeGetMapSDKDeps();

    public static native String nativeGetMapSDKVersion();

    public static native long nativeGetNativeMapController(int r100, long r101);

    public static native int[] nativeGetScreenShot(int r100, long r101, int r102, int r103, int r104, int r105);

    private static native boolean nativeGetSrvViewStateBoolValue(int r100, long r101, int r102);

    public static native int nativeHideBuildings(int r100, long r101, LatLng[] r102);

    private static native void nativeInitAMapEngineCallback(long r100, Object r101);

    private static native void nativeInitContourLineOptions(long r100, boolean r101);

    private static native void nativeInitOpenLayer(int r100, long r101, byte[] r102);

    private static native void nativeInitParam(String r100, String r101, String r102, String r103, String r104, String r105, String r106, String r107, String r108, String r109, int r110, int r111, LatLng r112, long r113, boolean r114);

    private static native boolean nativeIsEngineCreated(long r100, int r101);

    public static native void nativeMainThreadTrigger(int r100, long r101);

    private static native void nativePopRenderState(int r100, long r101);

    private static native void nativePostRenderAMap(long r100, int r101);

    private static native void nativePushRendererState(int r100, long r101);

    private static native void nativeReceiveNetData(byte[] r100, long r101, int r102);

    public static native void nativeRemoveNativeAllOverlay(int r100, long r101);

    public static native void nativeRemoveNativeOverlay(int r100, long r101, String r102);

    private static native void nativeRemovePoiFilter(int r100, long r101, String r102);

    private static native void nativeRenderAMap(long r100, int r101);

    private static native void nativeSetAllContentEnable(int r100, long r101, boolean r102);

    private static native void nativeSetBuildingEnable(int r100, long r101, boolean r102);

    private static native void nativeSetBuildingTextureEnable(int r100, long r101, boolean r102);

    public static native void nativeSetCurrentLocation(int r100, long r101, LatLng r102);

    private static native void nativeSetCustomStyleData(int r100, long r101, byte[] r102, byte[] r103);

    private static native void nativeSetCustomStyleTexture(int r100, long r101, byte[] r102);

    private static native void nativeSetCustomThirdLayerStyle(int r100, long r101, String r102);

    private static native void nativeSetHighlightSubwayEnable(int r100, long r101, boolean r102);

    private static native void nativeSetI18nPoiLocalLanguage(int r100, long r101, boolean r102);

    private static native void nativeSetIndoorBuildingToBeActive(int r100, long r101, String r102, int r103, String r104);

    private static native void nativeSetIndoorEnable(int r100, long r101, boolean r102);

    private static native void nativeSetLabelEnable(int r100, long r101, boolean r102);

    private static native boolean nativeSetMapModeAndStyle(int r100, long r101, int[] r102);

    private static native void nativeSetMapOptRecordState(int r100, long r101, boolean r102);

    private static native void nativeSetNaviLabelEnable(int r100, long r101, boolean r102, int r103, int r104);

    private static native void nativeSetOfflineDataEnable(int r100, long r101, boolean r102);

    private static native void nativeSetOpenLayerEnable(int r100, long r101, boolean r102);

    private static native void nativeSetParameter(int r100, long r101, int r102, int r103, int r104, int r105, int r106);

    private static native void nativeSetProjectionCenter(int r100, long r101, float r102, float r103);

    public static native void nativeSetRenderFlags(int r100, long r101, boolean r102);

    private static native void nativeSetRenderListenerStatus(int r100, long r101);

    private static native void nativeSetRoadArrowEnable(int r100, long r101, boolean r102);

    private static native void nativeSetServiceViewRect(int r100, long r101, int r102, int r103, int r104, int r105, int r106, int r107);

    private static native void nativeSetSetBackgroundTexture(int r100, long r101, byte[] r102);

    private static native void nativeSetSkyTexture(int r100, long r101, byte[] r102);

    private static native void nativeSetSrvViewStateBoolValue(int r100, long r101, int r102, boolean r103);

    private static native void nativeSetStyleChangeGradualEnable(int r100, long r101, boolean r102);

    public static native void nativeSetTerrainAuth(int r100, long r101, boolean r102);

    private static native void nativeSetTrafficEnable(int r100, long r101, boolean r102);

    private static native void nativeSetTrafficTexture(int r100, long r101, byte[] r102, long r103, int r104, int r105, int r106, int r107, int r110);

    private static native void nativeSetTrafficTextureAllInOne(int r100, long r101, byte[] r102);

    public static native void nativeSetVectorOverlayPath(int r100, long r101, String r102);

    public static native void nativeShowHideBuildings(int r100, long r101, int r102);

    public static native void nativeSwitchLanguage(int r100, long r101, String r102);

    public static native void nativeUpdateNativeArrowOverlay(int r100, long r101, String r102, int[] r103, int[] r104, int r105, int r106, int r107, float r108, boolean r110, int r111, int r112, int r113);

    private boolean processMessage() {
        GLMapState r100 = (GLMapState) getNewMapState(this.mEngineID);     // Catch: Exception -> L29
        boolean r101 = processGestureMessage(r100);     // Catch: Exception -> L29
        boolean r102 = true;
        if (this.mGestureMessageList.size() > 0) goto L11;
        if (r101 == false) goto L7;
    L10:
        r101 = true;
    L17:
        if (r101 == false) goto L19;
    L22:
        if (r102 == false) goto L24;
        float r103 = r100.getCameraDegree();     // Catch: Exception -> L29
        r100.setCameraDegree(w3.a(this.mGlMapView.getMapConfig(), r103, r100.getMapZoomer()));     // Catch: Exception -> L29
        setMapState(this.mEngineID, r100);     // Catch: Exception -> L29
    L24:
        r100.recycle();     // Catch: Exception -> L29
        return r102;
    L19:
        if (processAnimations(r100) == true) goto L22;
        r102 = false;
        goto L22
    L7:
        if (processStateMapMessage(r100) == true) goto L10;
        r101 = false;
        goto L17
    L11:
        List<AbstractCameraUpdateMessage> r104 = this.mStateMessageList;     // Catch: Exception -> L29
        monitor-enter(r104);     // Catch: Exception -> L29
    L26:
        th = move-exception;
        throw th;     // Catch: Exception -> L29
    L14:
        if (this.mStateMessageList.size() <= 0) goto L16;
        this.mStateMessageList.clear();     // Catch: Throwable -> L26
    L16:
        monitor-exit(r104);     // Catch: Throwable -> L26
    L29:
        e = move-exception;
        e.printStackTrace();
        return false;
    }

    public void changeSurface(int r100, int r101) {
    }

    public void clearAllMessages(int r100) {
    }

    public void destroyAMapEngine() {
        this.mRequestDestroy = true;     // Catch: Throwable -> L49
        Object r100 = this.mutLock;     // Catch: Throwable -> L49
        monitor-enter(r100);     // Catch: Throwable -> L49
        sNetworkProxyManager.notifyMapEngineDestroying(this.mEngineID);     // Catch: Throwable -> L46
    L43:
        th = move-exception;
        sNetworkProxyManager.notifyMapEngineDestroyed(this.mEngineID);     // Catch: Throwable -> L46
        throw th;     // Catch: Throwable -> L46
    L7:
        if (this.mNativeMapengineInstance == 0) goto L16;
        this.mLock.lock();     // Catch: Throwable -> L43
        GLMapState r101 = this.copyGLMapState;     // Catch: Throwable -> L13
        if (r101 == null) goto L12;
        r101.recycle();     // Catch: Throwable -> L13
    L12:
        this.mLock.unlock();     // Catch: Throwable -> L43
        nativeDestroyCurrentState(this.mNativeMapengineInstance, this.state.getNativeInstance());     // Catch: Throwable -> L43
        nativeDestroy(this.mNativeMapengineInstance);     // Catch: Throwable -> L43
    L13:
        th = move-exception;
        this.mLock.unlock();     // Catch: Throwable -> L43
        throw th;     // Catch: Throwable -> L43
    L16:
        this.mNativeMapengineInstance = 0;     // Catch: Throwable -> L43
        sNetworkProxyManager.notifyMapEngineDestroyed(this.mEngineID);     // Catch: Throwable -> L46
        monitor-exit(r100);     // Catch: Throwable -> L46
        this.mGlMapView = null;     // Catch: Throwable -> L49
        List<AbstractCameraUpdateMessage> r102 = this.mStateMessageList;     // Catch: Throwable -> L49
        monitor-enter(r102);     // Catch: Throwable -> L49
        this.mStateMessageList.clear();     // Catch: Throwable -> L40
        monitor-exit(r102);     // Catch: Throwable -> L40
        List<AbstractCameraUpdateMessage> r103 = this.mAnimateStateMessageList;     // Catch: Throwable -> L49
        monitor-enter(r103);     // Catch: Throwable -> L49
        this.mAnimateStateMessageList.clear();     // Catch: Throwable -> L37
        monitor-exit(r103);     // Catch: Throwable -> L37
        List<AbstractGestureMapMessage> r104 = this.mGestureMessageList;     // Catch: Throwable -> L49
        monitor-enter(r104);     // Catch: Throwable -> L49
        this.mGestureMessageList.clear();     // Catch: Throwable -> L34
        monitor-exit(r104);     // Catch: Throwable -> L34
        this.mGestureEndMessageList.clear();     // Catch: Throwable -> L49
        this.mMapListener = null;     // Catch: Throwable -> L49
        this.bundle = null;     // Catch: Throwable -> L49
        v3.a();     // Catch: Throwable -> L49
        return;
    L34:
        th = move-exception;
        throw th;     // Catch: Throwable -> L49
    L37:
        th = move-exception;
        throw th;     // Catch: Throwable -> L49
    L40:
        th = move-exception;
        throw th;     // Catch: Throwable -> L49
    L46:
        th = move-exception;
        throw th;     // Catch: Throwable -> L49
    L49:
        th = move-exception;
        th.printStackTrace();
        w3.a(th);
    }

    public boolean getIsProcessBuildingMark(int r100) {
        return false;
    }

    public long getMapStateInstance(int r100) {
        return 0;
    }

    public boolean isInMapAction(int r100) {
        return false;
    }

    public void onClearCache(int r100) {
    }

    public void putResourceData(int r100, byte[] r101) {
    }

    @Override // com.autonavi.base.amap.mapcore.IAMapEngineCallback
    public void reloadMapResource(int r100, String r101, int r102) {
    }

    @Override // com.autonavi.base.amap.mapcore.IAMapEngineCallback
    public void requireMapRender(int r100, int r101, int r102) {
    }

    public void setNetStatus(boolean r100) {
    }

    public void startCheckEngineRenderComplete() {
        this.isEngineRenderComplete = false;
    }

    public void startPivotZoomRotateAnim(int r100, Point r101, float r102, int r103, int r104) {
    }

    private void gestureBegin() {
        this.mapGestureCount++;
    }

    private void gestureEnd() {
        int r100 = this.mapGestureCount - 1;
        this.mapGestureCount = r100;
        if (r100 != 0) goto L6;
        recycleMessage();
        return;
    }

    private static String getEMUI() {
        Class r100 = INVOKESTATIC_com_autonavi_base_ae_gmap_GLMapEngine_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("android.os.SystemProperties");     // Catch: Exception -> L6
        return (String) r100.getDeclaredMethod(MonitorConstants.CONNECT_TYPE_GET, new Class[]{String.class}).invoke(r100, new Object[]{a.f25238a});
    L6:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    private void initAnimation() {
        if (this.mStateMessageList.size() <= 0) goto L5;
        return;
    L5:
        List<AbstractCameraUpdateMessage> r100 = this.mAnimateStateMessageList;
        monitor-enter(r100);
    L15:
        th = move-exception;
        throw th;
    L8:
        if (this.mAnimateStateMessageList.size() <= 0) goto L10;
        AbstractCameraUpdateMessage r101 = this.mAnimateStateMessageList.remove(0);     // Catch: Throwable -> L15
    L11:
        monitor-exit(r100);     // Catch: Throwable -> L15
        if (r101 == null) goto L20;
        r101.generateMapAnimation(this);
        return;
    L20:
        return;
    L10:
        r101 = null;
        goto L11
    }

    private void recycleMessage() {
    L3:
        if (this.mGestureEndMessageList.size() <= 0) goto L18;
        AbstractGestureMapMessage r100 = (AbstractGestureMapMessage) ListProtector.remove(this.mGestureEndMessageList, 0);
        if (r100 == null) goto L34;
        if ((r100 instanceof MoveGestureMapMessage) == true) goto L8;
        if ((r100 instanceof HoverGestureMapMessage) == true) goto L11;
        if ((r100 instanceof RotateGestureMapMessage) == true) goto L14;
        if ((r100 instanceof ScaleGestureMapMessage) == false) goto L3;
        ((ScaleGestureMapMessage) r100).recycle();
        goto L3
    L14:
        ((RotateGestureMapMessage) r100).recycle();
        goto L3
    L11:
        ((HoverGestureMapMessage) r100).recycle();
        goto L3
    L8:
        ((MoveGestureMapMessage) r100).recycle();
        goto L3
    L34:
        return;
    }

    public void clearPoiFilter() {
        long r100 = this.mNativeMapengineInstance;
        if (r100 != 0) goto L5;
        return;
    L5:
        nativeClearPoiFilter(this.mEngineID, r100);
    }

    @Override // com.autonavi.base.amap.mapcore.IAMapEngineCallback
    public int generateRequestId() {
        return this.mRequestID.incrementAndGet();
    }

    public int getAnimateionsCount() {
        if (this.mNativeMapengineInstance != 0) goto L5;
        return 0;
    L5:
        return this.mapAnimationMgr.getAnimationsCount();
    }

    public GLMapState getCloneMapState() {
        this.mLock.lock();
        long r100 = this.mNativeMapengineInstance;     // Catch: Throwable -> L11
        if (r100 != 0) goto L6;
    L9:
        this.mLock.unlock();
        return this.copyGLMapState;
    L6:
        if (this.copyGLMapState != null) goto L8;
        this.copyGLMapState = new GLMapState(this.mEngineID, r100);     // Catch: Throwable -> L11
    L8:
        this.copyGLMapState.setMapZoomer(this.mGlMapView.getMapConfig().getSZ());     // Catch: Throwable -> L11
        this.copyGLMapState.setCameraDegree(this.mGlMapView.getMapConfig().getSC());     // Catch: Throwable -> L11
        this.copyGLMapState.setMapAngle(this.mGlMapView.getMapConfig().getSR());     // Catch: Throwable -> L11
        this.copyGLMapState.setMapGeoCenter(this.mGlMapView.getMapConfig().getSX(), this.mGlMapView.getMapConfig().getSY());     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        this.mLock.unlock();
        throw th;
    }

    @Override // com.autonavi.base.amap.mapcore.IAMapEngineCallback
    public BitmapDescriptor getDefaultTerrainImage() {
        return this.terrainTileProvider.getDefaultTerrain();
    }

    @Override // com.autonavi.base.amap.mapcore.IAMapEngineCallback
    public List<BitmapDescriptor> getSkyBoxImages() {
        return this.terrainTileProvider.getSkyBoxImages();
    }

    public AbstractCameraUpdateMessage getStateMessage() {
        List<AbstractCameraUpdateMessage> r100 = this.mStateMessageList;
        monitor-enter(r100);
    L12:
        th = move-exception;
        throw th;
    L5:
        if (this.mStateMessageList.size() != 0) goto L9;
        monitor-exit(r100);     // Catch: Throwable -> L12
        return null;
    L9:
        AbstractCameraUpdateMessage r101 = this.mStateMessageList.remove(0);     // Catch: Throwable -> L12
        monitor-exit(r100);     // Catch: Throwable -> L12
        return r101;
    }

    public int getStateMessageCount() {
        return this.mStateMessageList.size();
    }

    @Override // com.autonavi.base.amap.mapcore.IAMapEngineCallback
    public TileProviderInner getTerrainTileProvider() {
        return this.terrainTileProvider.getTileProvider();
    }

    public void interruptAnimation() {
        if (isInMapAnimation(this.mEngineID) == false) goto L49;
        GLMapState r100 = null;
        AbstractAdglAnimation r101 = this.mapAnimationMgr.getCurrentAnimation();     // Catch: Throwable -> L24
        if (r101 == null) goto L14;
        GLMapState r102 = (GLMapState) getNewMapState(this.mEngineID);     // Catch: Throwable -> L24
        if (r102 != null) goto L66;
    L13:
        r100 = r102;
        goto L14
    L66:
        r101.applyFinalState(r102);     // Catch: Throwable -> L11
        r102.recalculate();     // Catch: Throwable -> L11
        r102.setCameraDegree(w3.a(this.mGlMapView.getMapConfig(), r102.getCameraDegree(), r102.getMapZoomer()));     // Catch: Throwable -> L11
        setMapState(this.mEngineID, r102);     // Catch: Throwable -> L11
    L11:
        Throwable th10 = th;
    L56:
        t6.a(th10, getClass().getName(), "CancelableCallback.onCancel");     // Catch: Throwable -> L37
        th10.printStackTrace();     // Catch: Throwable -> L37
        if (r102 == null) goto L58;
        r102.recycle();
    L58:
        doMapAnimationCancelCallback(this.mapAnimationMgr.getCancelCallback());     // Catch: Throwable -> L31
    L33:
        clearAnimations(this.mEngineID, false);
        return;
    L31:
        th = move-exception;
        t6.a(th, getClass().getName(), "CancelableCallback.onCancel");     // Catch: Throwable -> L34
        th.printStackTrace();     // Catch: Throwable -> L34
    L34:
        th = move-exception;
        clearAnimations(this.mEngineID, false);
        throw th;
    L37:
        th = move-exception;
        if (r102 == null) goto L54;
        r102.recycle();
    L54:
        doMapAnimationCancelCallback(this.mapAnimationMgr.getCancelCallback());     // Catch: Throwable -> L42
    L44:
        clearAnimations(this.mEngineID, false);
        throw th;
    L42:
        th = move-exception;
        t6.a(th, getClass().getName(), "CancelableCallback.onCancel");     // Catch: Throwable -> L46
        th.printStackTrace();     // Catch: Throwable -> L46
    L46:
        th = move-exception;
        clearAnimations(this.mEngineID, false);
        throw th;
    L14:
        if (r100 == null) goto L52;
        r100.recycle();
    L52:
        doMapAnimationCancelCallback(this.mapAnimationMgr.getCancelCallback());     // Catch: Throwable -> L18
    L18:
        th = move-exception;
        t6.a(th, getClass().getName(), "CancelableCallback.onCancel");     // Catch: Throwable -> L21
        th.printStackTrace();     // Catch: Throwable -> L21
    L21:
        th = move-exception;
        clearAnimations(this.mEngineID, false);
        throw th;
    L24:
        th = move-exception;
        r102 = null;
        th10 = th;
        goto L56
    }

    public void popRendererState() {
        long r100 = this.mNativeMapengineInstance;
        if (r100 == 0) goto L6;
        nativePopRenderState(this.mEngineID, r100);
        return;
    }

    public void pushRendererState() {
        long r100 = this.mNativeMapengineInstance;
        if (r100 == 0) goto L6;
        nativePushRendererState(this.mEngineID, r100);
        return;
    }

    public void renderAMap() {
        if (this.mNativeMapengineInstance == 0) goto L11;
        boolean r100 = processMessage();
        nativeRenderAMap(this.mNativeMapengineInstance, this.mEngineID);
        nativePostRenderAMap(this.mNativeMapengineInstance, this.mEngineID);
        initAnimation();
        if (r100 == false) goto L8;
        startCheckEngineRenderComplete();
    L8:
        if (this.isEngineRenderComplete == true) goto L12;
        nativeSetRenderListenerStatus(this.mEngineID, this.mNativeMapengineInstance);
        return;
    L12:
        return;
    }

    public void triggerMainThread() {
        nativeMainThreadTrigger(this.mEngineID, this.mNativeMapengineInstance);
    }

    @Override // com.autonavi.base.amap.mapcore.IAMapEngineCallback
    public InitStorageParam getStorageInitParam() {
        return InitStorageParam.obtain();
    }

    public static void clearMapDataCache() {
        nativeClearMapDataCache();
    }

    public Context getContext() {
        return this.context;
    }

    public IAMapDelegate getMapDelegate() {
        return this.mGlMapView;
    }

    public long getNativeInstance() {
        return this.mNativeMapengineInstance;
    }

    public boolean isNetworkConnected() {
        return this.isNetworkConnected;
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKESTATIC_com_autonavi_base_ae_gmap_GLMapEngine_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r100) throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r101 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r102 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class r103 = access$001(r100);     // Catch: Throwable -> L8
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a(r100);     // Catch: Throwable -> L8
    L7:
        return r103;
    L8:
        th = move-exception;
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b(r100);
    L12:
        throw th;
    L34:
        Class r104 = access$001(r100);     // Catch: Throwable -> L17
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a(r100);     // Catch: Throwable -> L17
    L16:
        return r104;
    L17:
        th = move-exception;
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b(r100);
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName(r100);
    }

    public static DisplayMetrics INVOKEVIRTUAL_com_autonavi_base_ae_gmap_GLMapEngine_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(Resources r100) {
        return WindowDisplayMetricsOverride.apply(r100, r100.getDisplayMetrics());
    }

    private void doMapAnimationCancelCallback(final AMap.CancelableCallback r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        IAMapDelegate r101 = this.mGlMapView;
        if (r101 == null) goto L8;
        r101.getMainHandler().post(new AnonymousClass1(this, r100));
        return;
    }

    private void doMapAnimationFinishCallback(final AMap.CancelableCallback r100) {
        IAMapListener r101 = this.mMapListener;
        if (r101 == null) goto L5;
        r101.afterAnimation();
    L5:
        if (r100 != null) goto L7;
        return;
    L7:
        IAMapDelegate r102 = this.mGlMapView;
        if (r102 == null) goto L11;
        r102.getMainHandler().post(new AnonymousClass2(this, r100));
        return;
    }

    public static void onTileRequestLogLevelChanged(int r100) {
        NetworkProxyManager r101 = sNetworkProxyManager;
        if (r101 == null) goto L6;
        r101.setTileRequestLogLevel(r100);
        return;
    }

    private boolean processAnimations(GLMapState r100) {
    L7:
        th = move-exception;
        th.printStackTrace();
        return false;
    L3:
        if (this.mapAnimationMgr.getAnimationsCount() <= 0) goto L13;
        r100.recalculate();     // Catch: Throwable -> L7
        this.mapAnimationMgr.doAnimations(r100);     // Catch: Throwable -> L7
        return true;
    L13:
        return false;
    }

    private boolean processGestureMessage(GLMapState r100) {
        if (this.mGestureMessageList.size() <= 0) goto L5;
        this.isGestureStep = true;
        if (r100 != null) goto L11;
        return false;
    L11:
        List<AbstractGestureMapMessage> r101 = this.mGestureMessageList;
        monitor-enter(r101);
    L40:
        th = move-exception;
        throw th;
    L14:
        if (this.mGestureMessageList.size() <= 0) goto L16;
        AbstractGestureMapMessage r102 = this.mGestureMessageList.remove(0);     // Catch: Throwable -> L40
    L17:
        if (r102 == null) goto L18;
        monitor-exit(r101);     // Catch: Throwable -> L40
        if (r102.width != 0) goto L28;
        r102.width = this.mGlMapView.getMapWidth();
    L28:
        if (r102.height != 0) goto L30;
        r102.height = this.mGlMapView.getMapHeight();
    L30:
        int r103 = r102.getMapGestureState();
        if (r103 != 100) goto L34;
        gestureBegin();
    L39:
        this.mGestureEndMessageList.add(r102);
        goto L11
    L34:
        if (r103 != 101) goto L37;
        r102.runCameraUpdate(r100);
        goto L39
    L37:
        if (r103 != 102) goto L39;
        gestureEnd();
        goto L39
    L18:
        monitor-exit(r101);     // Catch: Throwable -> L40
        if (this.mGestureEndMessageList.size() < 1) goto L22;
        recycleMessage();
    L22:
        return true;
    L16:
        r102 = null;
        goto L17
    L5:
        if (this.isGestureStep == false) goto L7;
        this.isGestureStep = false;
    L7:
        return false;
    }

    private boolean processStateMapMessage(GLMapState r100) {
        if (this.mStateMessageList.size() <= 0) goto L5;
        this.isMoveCameraStep = true;
        if (r100 != null) goto L11;
        return false;
    L11:
        List<AbstractCameraUpdateMessage> r101 = this.mStateMessageList;
        monitor-enter(r101);
    L28:
        th = move-exception;
        throw th;
    L14:
        if (this.mStateMessageList.size() <= 0) goto L16;
        AbstractCameraUpdateMessage r102 = this.mStateMessageList.remove(0);     // Catch: Throwable -> L28
    L17:
        if (r102 == null) goto L18;
        monitor-exit(r101);     // Catch: Throwable -> L28
        if (r102.width != 0) goto L25;
        r102.width = this.mGlMapView.getMapWidth();
    L25:
        if (r102.height != 0) goto L27;
        r102.height = this.mGlMapView.getMapHeight();
    L27:
        r100.recalculate();
        r102.runCameraUpdate(r100);
        goto L11
    L18:
        monitor-exit(r101);     // Catch: Throwable -> L28
        return true;
    L16:
        r102 = null;
        goto L17
    L5:
        if (this.isMoveCameraStep == false) goto L7;
        this.isMoveCameraStep = false;
    L7:
        return false;
    }

    public void addPoiFilter(PoiFilter r100) {
        long r101 = this.mNativeMapengineInstance;
        if (r101 != 0) goto L5;
        return;
    L5:
        nativeAddPoiFilter(this.mEngineID, r101, r100);
    }

    public boolean canStopMapRender(int r100) {
        return this.isEngineRenderComplete;
    }

    @Override // com.autonavi.base.amap.mapcore.IAMapEngineCallback
    public void cancelRequireMapData(Object r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        if ((r100 instanceof AMapLoader) == false) goto L8;
        ((AMapLoader) r100).doCancel();
        return;
    }

    public void createAMapEngineWithFrame(MapViewInitParam r110) {
        if (this.mNativeMapengineInstance != 0) goto L5;
        return;
    L5:
        monitor-enter(GLMapEngine.class);
        nativeCreateAMapEngineWithFrame(this.mNativeMapengineInstance, r110.engineId, r110.f30025x, r110.f30026y, r110.width, r110.height, r110.screenWidth, r110.screenHeight, r110.screenScale, r110.textScale, r110.mapZoomScale, r110.taskThreadCount);     // Catch: Throwable -> L11
        monitor-exit(GLMapEngine.class);     // Catch: Throwable -> L11
        if (this.mGlMapView.getMapConfig().isTerrainEnable() == false) goto L17;
        byte[] r100 = FileUtil.uncompressToByteArray(p3.c(this.context, "map_assets/style_1_17_for_terrain.data"));
        setCustomStyleData(r110.engineId, r100, null);
        return;
    L17:
        return;
    L11:
        th = move-exception;
        throw th;
    }

    public int getEngineIDWithGestureInfo(EAMapPlatformGestureInfo r100) {
        return this.mEngineID;
    }

    public int getEngineIDWithType(int r100) {
        return this.mEngineID;
    }

    public long getGlOverlayMgrPtr(int r100) {
        long r101 = this.mNativeMapengineInstance;
        if (r101 != 0) goto L5;
        return 0;
    L5:
        return nativeGetGlOverlayMgrPtr(r100, r101);
    }

    public GLMapState getMapState(int r110) {
        this.mLock.lock();
        long r100 = this.mNativeMapengineInstance;     // Catch: Throwable -> L12
        if (r100 != 0) goto L6;
    L10:
        this.mLock.unlock();
        return this.state;
    L6:
        if (this.state != null) goto L10;
        long r101 = nativeGetCurrentMapState(r110, r100);     // Catch: Throwable -> L12
        if (r101 == 0) goto L10;
        this.state = new GLMapState(r110, this.mNativeMapengineInstance, r101);     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        this.mLock.unlock();
        throw th;
    }

    public long getNativeMapController(int r100) {
        long r101 = this.mNativeMapengineInstance;
        if (r101 != 0) goto L5;
        return 0;
    L5:
        return nativeGetNativeMapController(r100, r101);
    }

    @Override // com.autonavi.amap.api.mapcore.IGLMapEngine
    public IGLMapState getNewMapState(int r100) {
        this.mLock.lock();
        long r101 = this.mNativeMapengineInstance;     // Catch: Throwable -> L10
        if (r101 == 0) goto L8;
        GLMapState r102 = new GLMapState(r100, r101);     // Catch: Throwable -> L10
        this.mLock.unlock();
        return r102;
    L8:
        this.mLock.unlock();
        return null;
    L10:
        th = move-exception;
        this.mLock.unlock();
        throw th;
    }

    public GLOverlayBundle getOverlayBundle(int r100) {
        return this.bundle;
    }

    public int hideBuildings(List<LatLng> r100) {
        if (this.mNativeMapengineInstance != 0) goto L6;
        return -1;
    L6:
        LatLng[] r101 = new LatLng[r100.size()];
        r100.toArray(r101);
        return nativeHideBuildings(this.mEngineID, this.mNativeMapengineInstance, r101);
    }

    public void initMapOpenLayer(String r100) {
        long r101 = this.mNativeMapengineInstance;
        if (r101 == 0) goto L7;
        if (r100 == null) goto L8;
        nativeInitOpenLayer(this.mEngineID, r101, r100.getBytes());
        return;
    L8:
        return;
    }

    public void initNativeTexture(int r100) {
        BitmapDescriptor r101 = BitmapDescriptorFactory.fromAsset("arrow/arrow_line_inner.png");     // Catch: Throwable -> L15
        Bitmap r102 = null;
        if (r101 == null) goto L5;
        Bitmap r103 = r101.getBitmap();     // Catch: Throwable -> L15
    L6:
        BitmapDescriptor r104 = BitmapDescriptorFactory.fromAsset("arrow/arrow_line_outer.png");     // Catch: Throwable -> L15
        if (r104 == null) goto L9;
        Bitmap r105 = r104.getBitmap();     // Catch: Throwable -> L15
    L10:
        BitmapDescriptor r106 = BitmapDescriptorFactory.fromAsset("arrow/arrow_line_shadow.png");     // Catch: Throwable -> L15
        if (r106 == null) goto L13;
        r102 = r106.getBitmap();     // Catch: Throwable -> L15
    L13:
        addOverlayTexture(r100, r103, 111, 4);     // Catch: Throwable -> L15
        addOverlayTexture(r100, r105, 222, 4);     // Catch: Throwable -> L15
        addOverlayTexture(r100, r102, 333, 4);     // Catch: Throwable -> L15
        return;
    L9:
        r105 = null;
        goto L10
    L5:
        r103 = null;
    L15:
        th = move-exception;
        th.printStackTrace();
    }

    public boolean isEngineCreated(int r100) {
        long r101 = this.mNativeMapengineInstance;
        if (r101 != 0) goto L5;
        return false;
    L5:
        return nativeIsEngineCreated(r101, r100);
    }

    public boolean isInMapAnimation(int r100) {
        if (getAnimateionsCount() <= 0) goto L6;
        return true;
    L6:
        return false;
    }

    @Override // com.autonavi.base.amap.mapcore.IAMapEngineCallback
    public void onAMapAppResourceRequest(AMapAppRequestParam r100) {
        IAMapDelegate r101 = this.mGlMapView;
        if (r101 == null) goto L6;
        r101.onAMapAppResourceRequest(r100);
        return;
    }

    @Override // com.autonavi.base.amap.mapcore.IAMapEngineCallback
    public void onMapPOIClick(MapPoi r100) {
        IAMapListener r101 = this.mMapListener;
        if (r101 == null) goto L6;
        r101.onMapPOIClick(r100);
        return;
    }

    public void removeNativeAllOverlay(int r100) {
        long r101 = this.mNativeMapengineInstance;
        if (r101 == 0) goto L6;
        nativeRemoveNativeAllOverlay(r100, r101);
        return;
    }

    public void removePoiFilter(String r100) {
        long r101 = this.mNativeMapengineInstance;
        if (r101 != 0) goto L5;
        return;
    L5:
        nativeRemovePoiFilter(this.mEngineID, r101, r100);
    }

    public void setCurrentLocation(LatLng r100) {
        long r101 = this.mNativeMapengineInstance;
        if (r101 != 0) goto L5;
        return;
    L5:
        nativeSetCurrentLocation(this.mEngineID, r101, r100);
    }

    public void setLocationOversea(boolean r100) {
        if (sNetworkProxyManager != null) goto L5;
        return;
    L5:
        sNetworkProxyManager.setLocationOversea(r100);
    }

    public void setMapListener(IAMapListener r100) {
        this.mMapListener = r100;
    }

    public void setMapOpenLayerEnable(boolean r100) {
        long r101 = this.mNativeMapengineInstance;
        if (r101 == 0) goto L6;
        nativeSetOpenLayerEnable(this.mEngineID, r101, r100);
        return;
    }

    public void setMapOptRecordState(boolean r100) {
        long r101 = this.mNativeMapengineInstance;
        if (r101 != 0) goto L5;
        return;
    L5:
        nativeSetMapOptRecordState(this.mEngineID, r101, r100);
    }

    public void setOverseaAuth(boolean r100) {
        if (sNetworkProxyManager != null) goto L5;
        return;
    L5:
        sNetworkProxyManager.setOverseaEnable(r100);
    }

    public void setRenderFlags(boolean r100) {
        long r101 = this.mNativeMapengineInstance;
        if (r101 != 0) goto L5;
        return;
    L5:
        nativeSetRenderFlags(this.mEngineID, r101, r100);
    }

    public void setTerrainAuth(boolean r100) {
        long r101 = this.mNativeMapengineInstance;
        if (r101 != 0) goto L5;
        return;
    L5:
        nativeSetTerrainAuth(this.mEngineID, r101, r100);
    }

    public void setTileLoadCallback(ITileLoadCallback r100) {
        if (sNetworkProxyManager != null) goto L5;
        return;
    L5:
        sNetworkProxyManager.setTileLoadCallback(r100);
    }

    public void setVectorOverlayPath(String r100) {
        long r101 = this.mNativeMapengineInstance;
        if (r101 != 0) goto L5;
        return;
    L5:
        nativeSetVectorOverlayPath(this.mEngineID, r101, r100);
    }

    public void showHideBuildings(int r100) {
        long r101 = this.mNativeMapengineInstance;
        if (r101 != 0) goto L5;
        return;
    L5:
        nativeShowHideBuildings(this.mEngineID, r101, r100);
    }

    public void switchLanguage(String r100) {
        long r101 = this.mNativeMapengineInstance;
        if (r101 != 0) goto L5;
        return;
    L5:
        nativeSwitchLanguage(this.mEngineID, r101, r100);
    }

    public GLMapEngine(Context r100, IAMapDelegate r101) {
        this.mNativeMapengineInstance = 0;
        this.mGlMapView = null;
        this.mStateMessageList = new Vector();
        this.mGestureMessageList = new Vector();
        this.mGestureEndMessageList = new Vector();
        this.mAnimateStateMessageList = new Vector();
        this.isMoveCameraStep = false;
        this.isGestureStep = false;
        this.mapGestureCount = 0;
        this.mapAnimationMgr = null;
        this.copyGLMapState = null;
        this.mLock = new ReentrantLock();
        this.mutLock = new Object();
        this.mNetworkState = null;
        this.bundle = null;
        this.isEngineRenderComplete = false;
        this.mRequestDestroy = false;
        this.isNetworkConnected = false;
        this.terrainTileProvider = null;
        this.mRequestID = new AtomicInteger(1);
        this.mRequestDestroy = false;
        if (r100 != null) goto L5;
        return;
    L5:
        this.context = r100.getApplicationContext();
        this.mGlMapView = r101;
        this.mTextTextureGenerator = new TextTextureGenerator();
        AdglMapAnimationMgr r102 = new AdglMapAnimationMgr();
        this.mapAnimationMgr = r102;
        r102.setMapAnimationListener(new AnonymousClass3(this));
        this.terrainTileProvider = new TerrainOverlayProvider(r101.getGlOverlayLayer(), this.context);
        this.mEngineID = GLEngineIDController.getController().generate();
        if (sNetworkProxyManager != null) goto L9;
        sNetworkProxyManager = new NetworkProxyManager();
        return;
    }

    public static /* synthetic */ void access$000(GLMapEngine r100, AMap.CancelableCallback r101) {
        r100.doMapAnimationFinishCallback(r101);
    }

    @Override // com.autonavi.base.amap.mapcore.IAMapEngineCallback
    public void OnIndoorBuildingActivity(int r100, byte[] r101) {
        IAMapDelegate r102 = this.mGlMapView;
        if (r102 == null) goto L11;
        r102.onIndoorBuildingActivity(r100, r101);     // Catch: Throwable -> L6
        return;
    L6:
        th = move-exception;
        th.printStackTrace();
        return;
    }

    public void addGestureSingleTapMessage(float r100, float r101) {
        nativeAddGestureSingleTapMessage(this.mEngineID, this.mNativeMapengineInstance, r100, r101);
    }

    public void addMessage(AbstractCameraUpdateMessage r100, boolean r101) {
        if (r101 == false) goto L11;
        List<AbstractCameraUpdateMessage> r102 = this.mAnimateStateMessageList;
        monitor-enter(r102);
        this.mAnimateStateMessageList.clear();     // Catch: Throwable -> L8
        this.mAnimateStateMessageList.add(r100);     // Catch: Throwable -> L8
        monitor-exit(r102);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    L11:
        List<AbstractCameraUpdateMessage> r103 = this.mStateMessageList;
        monitor-enter(r103);
        this.mStateMessageList.add(r100);     // Catch: Throwable -> L16
        monitor-exit(r103);     // Catch: Throwable -> L16
        return;
    L16:
        th = move-exception;
        throw th;
    }

    public void addOverlayTexture(int r110, GLTextureProperty r111) {
        if (this.mNativeMapengineInstance == 0) goto L11;
        if (r111 == null) goto L12;
        Bitmap r100 = r111.mBitmap;
        if (r100 != null) goto L8;
        return;
    L8:
        if (r100.isRecycled() == true) goto L14;
        nativeAddOverlayTexture(r110, this.mNativeMapengineInstance, r111.mId, r111.mAnchor, r111.mXRatio, r111.mYRatio, r111.mBitmap, r111.isGenMimps, r111.isRepeat);
        return;
    L14:
        return;
    L12:
        return;
    }

    public boolean checkCustomStyleData(int r100, byte[] r101) {
        if (r101 != null) goto L5;
        return false;
    L5:
        long r102 = this.mNativeMapengineInstance;
        if (r102 != 0) goto L9;
        return false;
    L9:
        return nativeCheckCustomStyleData(r100, r102, r101);
    }

    public void clearAnimations(int r100, boolean r101) {
        this.mapAnimationMgr.clearAnimations();
    }

    public boolean createAMapInstance(InitParam r210, float r310) {
        if (r210 != null) goto L6;
        return false;
    L6:
        monitor-enter(GLMapEngine.class);
        p5 r110 = p5.b(this.context);     // Catch: Throwable -> L25
        String r111 = "http://" + r110.a(21) + HTTP.URL_DEFAULT;     // Catch: Throwable -> L25
        String r112 = "http://" + r110.a(23);     // Catch: Throwable -> L25
        String r113 = "http://" + r110.a(20) + HTTP.URL_DEFAULT;     // Catch: Throwable -> L25
        String r211 = "http://" + r110.a(24) + HTTP.URL_DEFAULT;     // Catch: Throwable -> L25
        String r212 = "http://" + r110.a(25) + HTTP.URL_DEFAULT;     // Catch: Throwable -> L25
        DisplayMetrics r100 = INVOKEVIRTUAL_com_autonavi_base_ae_gmap_GLMapEngine_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(this.context.getResources());     // Catch: Throwable -> L25
        int r101 = r100.densityDpi;     // Catch: Throwable -> L25
        float r102 = r100.density;     // Catch: Throwable -> L25
        float r103 = adapterDpiScale(r100, r100.widthPixels, r100.heightPixels, r101);     // Catch: Throwable -> L25
        this.mGlMapView.getMapConfig().setTerrainEnable(MapsInitializer.isTerrainEnable());     // Catch: Throwable -> L25
        boolean r104 = MapsInitializer.isTerrainEnable();     // Catch: Throwable -> L25
        nativeInitParam(r210.mRootPath, r210.mConfigContent, r210.mOnlineMapDataPath, r210.mOfflineDataPath, r210.mP3dCrossPath, r111, r112, r113, r211, r212, r101, MapsInitializer.getRegionLanguageType(), MapsInitializer.getRegionLocation(), MapsInitializer.getAlcLogLevelMask(), MapsInitializer.isAlcRecordStorage());     // Catch: Throwable -> L25
        InitStorageParam.Holder.initPath(r210.mP3dCrossPath);     // Catch: Throwable -> L25
        if (r310 == 0.0f) goto L10;
        this.mNativeMapengineInstance = nativeCreateAMapInstance((int) (160.0f * r310), r310, r103, r104 ? 1 : 0, this.mGlMapView.isUseForNavi());     // Catch: Throwable -> L25
    L12:
        if (this.mNativeMapengineInstance != 0) goto L16;
        monitor-exit(GLMapEngine.class);     // Catch: Throwable -> L25
        return false;
    L16:
        if (MapsInitializer.isTerrainEnable() == false) goto L18;
        nativeInitContourLineOptions(this.mNativeMapengineInstance, MapsInitializer.isContourLineEnable());     // Catch: Throwable -> L25
    L18:
        nativeInitAMapEngineCallback(this.mNativeMapengineInstance, this);     // Catch: Throwable -> L25
        if (sNetworkProxyManager.isReady() == true) goto L21;
        sNetworkProxyManager.initContext(this.context);     // Catch: Throwable -> L25
        sNetworkProxyManager.init();     // Catch: Throwable -> L25
    L21:
        sNetworkProxyManager.notifyMapEngineCreated(this.mEngineID, this, this.mGlMapView);     // Catch: Throwable -> L25
        monitor-exit(GLMapEngine.class);     // Catch: Throwable -> L25
        return true;
    L10:
        this.mNativeMapengineInstance = nativeCreateAMapInstance(r101, r102, r103, r104 ? 1 : 0, this.mGlMapView.isUseForNavi());     // Catch: Throwable -> L25
    L25:
        th = move-exception;
        throw th;
    }

    public long createOverlay(int r100, int r101) {
        long r102 = this.mNativeMapengineInstance;
        if (r102 != 0) goto L5;
        return 0;
    L5:
        return nativeCreateOverlay(r100, r102, r101);
    }

    public int createOverlayTexture(int r100, Bitmap r101) {
        if (this.mNativeMapengineInstance == 0) goto L9;
        if (r101 != null) goto L6;
        return -1;
    L6:
        if (r101.isRecycled() == false) goto L8;
        return -1;
    L8:
        return nativeCreateTextureFromImage(r100, this.mNativeMapengineInstance, r101);
    L9:
        return -1;
    }

    public void destroyOverlay(int r100, long r101) {
        monitor-enter(GLMapEngine.class);
        nativeDestroyOverlay(r100, r101);     // Catch: Throwable -> L7
        monitor-exit(GLMapEngine.class);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void getCurTileIDs(int r100, int[] r101) {
        if (r101 == null) goto L10;
        int r102 = 0;
    L5:
        if (r102 >= r101.length) goto L7;
        r101[r102] = 0;
        r102 = r102 + 1;
        goto L5
    L7:
        nativeGetCurTileIDs(r100, this.mNativeMapengineInstance, r101, r101.length);
        return;
    }

    public int[] getMapModeState(int r100, boolean r101) {
        long r102 = this.mNativeMapengineInstance;
        if (r102 == 0) goto L7;
        nativeGetMapModeState(r100, r102, r101);
        return null;
    L7:
        return null;
    }

    public boolean getSrvViewStateBoolValue(int r100, int r101) {
        long r102 = this.mNativeMapengineInstance;
        if (r102 != 0) goto L5;
        return false;
    L5:
        return nativeGetSrvViewStateBoolValue(r100, r102, r101);
    }

    @Override // com.autonavi.base.amap.mapcore.IAMapEngineCallback
    public void onMapBlandClick(double r100, double r101) {
        IAMapListener r102 = this.mMapListener;
        if (r102 == null) goto L6;
        r102.onMapBlankClick(r100, r101);
        return;
    }

    @Override // com.autonavi.base.amap.mapcore.IAMapEngineCallback
    public void onMapRender(int r100, int r101) {
        if (r101 != 13) goto L5;
        this.isEngineRenderComplete = true;     // Catch: Throwable -> L27
    L28:
        return;
    L5:
        if (r101 != 4) goto L7;
        IAMapListener r102 = this.mMapListener;     // Catch: Throwable -> L27
        if (r102 == null) goto L28;
        r102.beforeDrawBuilding(r100, getMapState(r100));     // Catch: Throwable -> L27
        goto L28
    L7:
        if (r101 != 5) goto L9;
        IAMapListener r103 = this.mMapListener;     // Catch: Throwable -> L27
        if (r103 == null) goto L28;
        r103.afterDrawBuilding(r100, getMapState(r100));     // Catch: Throwable -> L27
        this.mMapListener.beforeDrawLabel(r100, getMapState(r100));     // Catch: Throwable -> L27
        goto L28
    L9:
        if (r101 != 6) goto L11;
        IAMapListener r104 = this.mMapListener;     // Catch: Throwable -> L27
        if (r104 == null) goto L28;
        r104.afterDrawLabel(r100, getMapState(r100));     // Catch: Throwable -> L27
        goto L28
    L11:
        if (r101 != 7) goto L31;
        IAMapListener r105 = this.mMapListener;     // Catch: Throwable -> L27
        if (r105 == null) goto L28;
        r105.afterRendererOver(r100, getMapState(r100));     // Catch: Throwable -> L27
        goto L28
    L31:
        return;
    }

    public void removeNativeOverlay(int r100, String r101) {
        long r102 = this.mNativeMapengineInstance;
        if (r102 == 0) goto L7;
        if (r101 == null) goto L8;
        nativeRemoveNativeOverlay(r100, r102, r101);
        return;
    L8:
        return;
    }

    @Override // com.autonavi.base.amap.mapcore.IAMapEngineCallback
    public byte[] requireMapResource(int r100, String r101) {
        if (r101 != null) goto L5;
        return null;
    L5:
        String r102 = "map_assets/".concat(r101);
    L29:
        th = move-exception;
        w3.a(th);
        return null;
    L7:
        if (this.mGlMapView.getMapConfig().isCustomStyleEnable() == true) goto L9;
    L27:
        return p3.c(this.context, r102);
    L9:
        if (this.mGlMapView.getCustomStyleManager() == null) goto L13;
        byte[] r103 = this.mGlMapView.getCustomStyleManager().b(r101);     // Catch: Throwable -> L29
        if (r103 == null) goto L15;
        return r103;
    L15:
        if (r101.startsWith("icons_5") == false) goto L21;
        if (this.mGlMapView.getMapConfig().getCustomTextureResourcePath() == null) goto L25;
        byte[] r104 = FileUtil.readFileContents(this.mGlMapView.getMapConfig().getCustomTextureResourcePath());     // Catch: Throwable -> L29
    L19:
        r103 = r104;
    L25:
        if (r103 == null) goto L27;
        return r103;
    L21:
        if (r101.startsWith("bktile") == false) goto L25;
        r103 = p3.c(this.context, r102);     // Catch: Throwable -> L29
        int r105 = this.mGlMapView.getMapConfig().getCustomBackgroundColor();     // Catch: Throwable -> L29
        if (r105 == 0) goto L25;
        r104 = w3.a(r103, r105, r105, true);     // Catch: Throwable -> L29
        goto L19
    L13:
        r103 = null;
        goto L15
    }

    public void setAllContentEnable(int r100, boolean r101) {
        long r102 = this.mNativeMapengineInstance;
        if (r102 == 0) goto L8;
        if (r101 == false) goto L6;
        nativeSetAllContentEnable(r100, r102, true);
        return;
    L6:
        nativeSetAllContentEnable(r100, r102, false);
        return;
    }

    public void setBackgroundTexture(int r100, byte[] r101) {
        if (r101 != null) goto L4;
        return;
    L4:
        long r102 = this.mNativeMapengineInstance;
        if (r102 == 0) goto L8;
        nativeSetSetBackgroundTexture(r100, r102, r101);
        return;
    }

    public void setBuildingEnable(int r100, boolean r101) {
        long r102 = this.mNativeMapengineInstance;
        if (r102 == 0) goto L6;
        nativeSetBuildingEnable(r100, r102, r101);
        return;
    }

    public void setBuildingTextureEnable(int r100, boolean r101) {
        long r102 = this.mNativeMapengineInstance;
        if (r102 == 0) goto L6;
        nativeSetBuildingTextureEnable(r100, r102, r101);
        return;
    }

    public void setCustomStyleTexture(int r100, byte[] r101) {
        if (r101 != null) goto L4;
        return;
    L4:
        long r102 = this.mNativeMapengineInstance;
        if (r102 == 0) goto L8;
        nativeSetCustomStyleTexture(r100, r102, r101);
        return;
    }

    public void setCustomThirdLayerStyle(int r100, String r101) {
        if (TextUtils.isEmpty(r101) == false) goto L5;
        return;
    L5:
        long r102 = this.mNativeMapengineInstance;
        if (r102 == 0) goto L9;
        nativeSetCustomThirdLayerStyle(this.mEngineID, r102, r101);
        return;
    }

    public void setHighlightSubwayEnable(int r100, boolean r101) {
        long r102 = this.mNativeMapengineInstance;
        if (r102 == 0) goto L6;
        nativeSetHighlightSubwayEnable(r100, r102, r101);
        return;
    }

    public void setI18nPoiLocalLanguage(int r100, boolean r101) {
        long r102 = this.mNativeMapengineInstance;
        if (r102 == 0) goto L6;
        nativeSetI18nPoiLocalLanguage(r100, r102, r101);
        return;
    }

    public void setIndoorEnable(int r100, boolean r101) {
        long r102 = this.mNativeMapengineInstance;
        if (r102 == 0) goto L6;
        nativeSetIndoorEnable(r100, r102, r101);
        return;
    }

    public void setLabelEnable(int r100, boolean r101) {
        long r102 = this.mNativeMapengineInstance;
        if (r102 == 0) goto L6;
        nativeSetLabelEnable(r100, r102, r101);
        return;
    }

    public void setMapState(int r100, GLMapState r101) {
        setMapState(r100, r101, true);
    }

    public void setOfflineDataEnable(int r100, boolean r101) {
        long r102 = this.mNativeMapengineInstance;
        if (r102 == 0) goto L6;
        nativeSetOfflineDataEnable(r100, r102, r101);
        return;
    }

    public void setOvelayBundle(int r100, GLOverlayBundle<BaseMapOverlay<?, ?>> r101) {
        this.bundle = r101;
    }

    public void setRoadArrowEnable(int r100, boolean r101) {
        long r102 = this.mNativeMapengineInstance;
        if (r102 == 0) goto L6;
        nativeSetRoadArrowEnable(r100, r102, r101);
        return;
    }

    public void setSkyTexture(int r100, byte[] r101) {
        if (r101 != null) goto L4;
        return;
    L4:
        long r102 = this.mNativeMapengineInstance;
        if (r102 == 0) goto L8;
        nativeSetSkyTexture(r100, r102, r101);
        return;
    }

    public void setStyleChangeGradualEnable(int r100, boolean r101) {
        long r102 = this.mNativeMapengineInstance;
        if (r102 == 0) goto L6;
        nativeSetStyleChangeGradualEnable(r100, r102, r101);
        return;
    }

    public void setTrafficEnable(int r100, boolean r101) {
        long r102 = this.mNativeMapengineInstance;
        if (r102 == 0) goto L6;
        nativeSetTrafficEnable(r100, r102, r101);
        return;
    }

    public void setTrafficStyleWithTextureData(int r100, byte[] r101) {
        long r102 = this.mNativeMapengineInstance;
        if (r102 == 0) goto L7;
        if (r101 == null) goto L8;
        nativeSetTrafficTextureAllInOne(r100, r102, r101);
        return;
    L8:
        return;
    }

    public String addNativeOverlay(int r100, int r101, int r102) {
        long r103 = this.mNativeMapengineInstance;
        if (r103 == 0) goto L8;
        String r104 = nativeAddNativeOverlay(r100, r103, r101, r102);
        if (TextUtils.isEmpty(r104) == false) goto L7;
        return null;
    L7:
        return r104;
    L8:
        return null;
    }

    public void clearAnimations(int r100, boolean r101, int r102) {
        this.mapAnimationMgr.clearAnimations();
    }

    @Override // com.autonavi.base.amap.mapcore.IAMapEngineCallback
    public byte[] requireCharBitmap(int r100, int r101, int r102) {
        return this.mTextTextureGenerator.getTextPixelBuffer(r101, r102);
    }

    public void setCustomStyleData(int r100, byte[] r101, byte[] r102) {
        if (r101 != null) goto L4;
        return;
    L4:
        long r103 = this.mNativeMapengineInstance;
        if (r103 == 0) goto L8;
        nativeSetCustomStyleData(r100, r103, r101, r102);
        return;
    }

    public void setMapState(int r100, GLMapState r101, boolean r102) {
        if (this.mNativeMapengineInstance == 0) goto L16;
        if (r102 == false) goto L10;
        IAMapDelegate r103 = this.mGlMapView;
        if (r103 == null) goto L10;
        if (r103.getMapConfig() == null) goto L10;
        this.mGlMapView.checkMapState(r101);
    L10:
        this.mLock.lock();
        r101.setNativeMapengineState(r100, this.mNativeMapengineInstance);     // Catch: Throwable -> L13
        this.mLock.unlock();
        return;
    L13:
        th = move-exception;
        this.mLock.unlock();
        throw th;
    }

    public boolean setNativeMapModeAndStyle(int r100, int r101, int r102) {
        long r103 = this.mNativeMapengineInstance;
        if (r103 != 0) goto L6;
        return false;
    L6:
        return nativeSetMapModeAndStyle(r100, r103, new int[]{r101, r102});
    }

    public void setProjectionCenter(int r100, int r101, int r102) {
        long r103 = this.mNativeMapengineInstance;
        if (r103 == 0) goto L6;
        nativeSetProjectionCenter(r100, r103, r101, r102);
        return;
    }

    public void setSrvViewStateBoolValue(int r100, int r101, boolean r102) {
        long r103 = this.mNativeMapengineInstance;
        if (r103 == 0) goto L6;
        nativeSetSrvViewStateBoolValue(r100, r103, r101, r102);
        return;
    }

    public void setTrafficStyleWithTexture(int r110, byte[] r111, MyTrafficStyle r112) {
        long r100 = this.mNativeMapengineInstance;
        if (r100 == 0) goto L8;
        if (r112 == null) goto L9;
        nativeSetTrafficTexture(r110, r100, r111, r111.length, r112.getExtremelySmoothColor(), r112.getSmoothColor(), r112.getSlowColor(), r112.getCongestedColor(), r112.getSeriousCongestedColor());
        return;
    L9:
        return;
    }

    private float adapterDpiScale(DisplayMetrics r100, int r101, int r110, int r111) {
        String r102 = getEMUI();
        if (r102 != null) goto L5;
        return 1.0f;
    L5:
        if (r102.isEmpty() == false) goto L7;
        return 1.0f;
    L7:
        if (r102.indexOf("EmotionUI_8") == (-1)) goto L9;
    L10:
        if (r111 <= 0) goto L52;
        int r103 = 0;
        Field r104 = DisplayMetrics.class.getDeclaredField("noncompatWidthPixels");     // Catch: IllegalAccessException -> L14 NoSuchFieldException -> L16
        r104.setAccessible(true);     // Catch: IllegalAccessException -> L14 NoSuchFieldException -> L16
        int r105 = r104.getInt(r100);     // Catch: IllegalAccessException -> L14 NoSuchFieldException -> L16
    L47:
        Field r106 = DisplayMetrics.class.getDeclaredField("noncompatHeightPixels");     // Catch: IllegalAccessException -> L21 NoSuchFieldException -> L23
        r106.setAccessible(true);     // Catch: IllegalAccessException -> L21 NoSuchFieldException -> L23
        int r107 = r106.getInt(r100);     // Catch: IllegalAccessException -> L21 NoSuchFieldException -> L23
    L45:
        Field r108 = DisplayMetrics.class.getDeclaredField("noncompatDensityDpi");     // Catch: IllegalAccessException -> L28 NoSuchFieldException -> L30
        r108.setAccessible(true);     // Catch: IllegalAccessException -> L28 NoSuchFieldException -> L30
        r103 = r108.getInt(r100);     // Catch: IllegalAccessException -> L28 NoSuchFieldException -> L30
    L32:
        if (r103 > r111) goto L35;
        if (r105 > r101) goto L35;
        if (r107 > r110) goto L35;
        return 1.0f;
    L35:
        float r109 = r103 / r111;
        if (r109 <= 2.0f) goto L39;
        r109 = 2.0f;
    L39:
        if (r109 >= 1.0f) goto L42;
        return 1.0f;
    L42:
        return r109;
    L28:
        e = move-exception;
        e.printStackTrace();
    L30:
        e = move-exception;
        e.printStackTrace();
        goto L32
    L21:
        e = move-exception;
        e.printStackTrace();
    L25:
        r107 = 0;
    L23:
        e = move-exception;
        e.printStackTrace();
    L14:
        e = move-exception;
        e.printStackTrace();
    L18:
        r105 = 0;
    L16:
        e = move-exception;
        e.printStackTrace();
        goto L18
    L52:
        return 1.0f;
    L9:
        if (r102.indexOf("EmotionUI_9") != (-1)) goto L10;
        return 1.0f;
    }

    public void addOverlayTexture(int r100, Bitmap r101, int r102, int r103) {
        GLTextureProperty r104 = new GLTextureProperty();
        r104.mId = r102;
        r104.mAnchor = r103;
        r104.mBitmap = r101;
        r104.mXRatio = 0.0f;
        r104.mYRatio = 0.0f;
        r104.isGenMimps = true;
        addOverlayTexture(r100, r104);
    }

    @Override // com.autonavi.base.amap.mapcore.IAMapEngineCallback
    public byte[] requireCharsWidths(int r100, int[] r101, int r102, int r103) {
        return this.mTextTextureGenerator.getCharsWidths(r101);
    }

    public void setIndoorBuildingToBeActive(int r100, String r101, int r110, String r111) {
        if (TextUtils.isEmpty(r101) == false) goto L5;
        return;
    L5:
        if (TextUtils.isEmpty(r111) == true) goto L13;
        long r102 = this.mNativeMapengineInstance;
        if (r102 == 0) goto L12;
        nativeSetIndoorBuildingToBeActive(r100, r102, r101, r110, r111);
        return;
    L12:
        return;
    }

    public void setNaviLabelEnable(int r100, boolean r101, int r102, int r110) {
        long r103 = this.mNativeMapengineInstance;
        if (r103 == 0) goto L6;
        nativeSetNaviLabelEnable(r100, r103, r101, r102, r110);
        return;
    }

    public void startMapSlidAnim(int r100, Point r101, float r102, float r110) {
        if (r101 != null) goto L33;
        return;
    L33:
        clearAnimations(r100, true);     // Catch: Throwable -> L30
        GLMapState r103 = getCloneMapState();     // Catch: Throwable -> L30
        r103.reset();     // Catch: Throwable -> L30
        r103.recalculate();     // Catch: Throwable -> L30
        float r104 = Math.abs(r102);     // Catch: Throwable -> L30
        float r105 = Math.abs(r110);     // Catch: Throwable -> L30
        if (r104 <= r105) goto L8;
        float r106 = r104;
    L9:
        float r107 = 12000;
        if (r106 <= r107) goto L23;
        if (r104 > r105) goto L14;
        r102 = r102 * (r107 / r105);     // Catch: Throwable -> L30
        if (r110 <= 0.0f) goto L21;
        r110 = r107;
        goto L23
    L21:
        r110 = -12000;
        goto L23
    L14:
        if (r102 <= 0.0f) goto L16;
        r102 = r107;
    L17:
        r110 = r110 * (r107 / r104);     // Catch: Throwable -> L30
        goto L23
    L16:
        r102 = -12000;
    L23:
        if (this.mGlMapView.getMapConfig().isTerrainEnable() == false) goto L25;
        AdglMapAnimFlingP20 r108 = new AdglMapAnimFlingP20(500);     // Catch: Throwable -> L30
        r108.setPositionAndVelocity(r102, r110);     // Catch: Throwable -> L30
        r108.commitAnimation(r103);     // Catch: Throwable -> L30
        this.mapAnimationMgr.addAnimation(r108, null);     // Catch: Throwable -> L30
        return;
    L25:
        int r109 = this.mGlMapView.getMapWidth() >> 1;     // Catch: Throwable -> L30
        int r111 = this.mGlMapView.getMapHeight() >> 1;     // Catch: Throwable -> L30
        if (this.mGlMapView.isUseAnchor() == false) goto L28;
        r109 = this.mGlMapView.getMapConfig().getAnchorX();     // Catch: Throwable -> L30
        r111 = this.mGlMapView.getMapConfig().getAnchorY();     // Catch: Throwable -> L30
    L28:
        AdglMapAnimFling r112 = new AdglMapAnimFling(500, r109, r111);     // Catch: Throwable -> L30
        r112.setPositionAndVelocity(r102, r110);     // Catch: Throwable -> L30
        r112.commitAnimation(r103);     // Catch: Throwable -> L30
        this.mapAnimationMgr.addAnimation(r112, null);     // Catch: Throwable -> L30
        return;
    L8:
        r106 = r105;
    L30:
        th = move-exception;
        th.printStackTrace();
    }

    public void addGestureMessage(int r100, AbstractGestureMapMessage r101, boolean r102, int r103, int r104) {
        if (r101 != null) goto L4;
        return;
    L4:
        r101.isGestureScaleByMapCenter = r102;
        List<AbstractGestureMapMessage> r105 = this.mGestureMessageList;
        monitor-enter(r105);
        this.mGestureMessageList.add(r101);     // Catch: Throwable -> L9
        monitor-exit(r105);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        throw th;
    }

    public Bitmap getScreenShot(int r100, int r101, int r110, int r111, int r112) {
        long r102 = this.mNativeMapengineInstance;
        if (r102 != 0) goto L5;
        return null;
    L5:
        return w3.a(nativeGetScreenShot(r100, r102, r101, r110, r111, r112), r111 - r101, r112 - r110, true);
    }

    public boolean setMapModeAndStyle(int r100, int r101, int r102, boolean r103, StyleItem[] r110) {
        if (this.mNativeMapengineInstance != 0) goto L6;
        return false;
    L6:
        boolean r104 = setNativeMapModeAndStyle(r100, r101, r102);
        if (r110 == null) goto L17;
        if (r103 == false) goto L17;
        int r105 = this.mGlMapView.getMapConfig().getCustomBackgroundColor();
        if (r105 == 0) goto L12;
        setBackgroundTexture(r100, w3.a(p3.c(this.context, AMapEngineUtils.MAP_CUSTOM_ASSETS_NAME + File.separator + AMapEngineUtils.MAP_MAP_ASSETS_CUSTOM_BACKGROUND_NAME), r105, r105, true));
    L12:
        String r106 = this.mGlMapView.getMapConfig().getCustomTextureResourcePath();
        if (this.mGlMapView.getMapConfig().isProFunctionAuthEnable() == true) goto L15;
    L20:
        return r104;
    L15:
        if (TextUtils.isEmpty(r106) == true) goto L20;
        this.mGlMapView.getMapConfig().setUseProFunction(true);
        setCustomStyleTexture(r100, FileUtil.readFileContents(r106));
    L17:
        if (r101 != 0) goto L20;
        if (r102 != 0) goto L20;
        Context r107 = this.context;
        StringBuilder r108 = new StringBuilder(AMapEngineUtils.MAP_MAP_ASSETS_NAME);
        String r111 = File.separator;
        r108.append(r111);
        r108.append(AMapEngineUtils.MAP_MAP_ASSETS_BACKGROUND_NAME);
        setBackgroundTexture(r100, p3.c(r107, r108.toString()));
        setCustomStyleTexture(r100, p3.c(this.context, AMapEngineUtils.MAP_MAP_ASSETS_NAME + r111 + AMapEngineUtils.MAP_MAP_ASSETS_ICON_5_NAME));
        goto L20
    }

    public void setParamater(int r110, int r111, int r112, int r113, int r114, int r115) {
        this.mLock.lock();
        long r100 = this.mNativeMapengineInstance;     // Catch: Throwable -> L8
        if (r100 == 0) goto L6;
        nativeSetParameter(r110, r100, r111, r112, r113, r114, r115);     // Catch: Throwable -> L8
    L6:
        this.mLock.unlock();
        return;
    L8:
        th = move-exception;
        this.mLock.unlock();
        throw th;
    }

    public void setServiceViewRect(int r110, int r111, int r112, int r113, int r114, int r115, int r116) {
        nativeSetServiceViewRect(r110, this.mNativeMapengineInstance, r111, r112, r113, r114, r115, r116);
    }

    @Override // com.autonavi.amap.api.mapcore.IGLMapEngine
    public void addGroupAnimation(int r100, int r101, float r102, int r103, int r104, int r105, int r106, AMap.CancelableCallback r107) {
        AdglMapAnimGroup r108 = new AdglMapAnimGroup(r101);
        r108.setToCameraDegree(r104, 0);
        r108.setToMapAngle(r103, 0);
        r108.setToMapLevel(r102, 0);
        r108.setToMapCenterGeo(r105, r106, 0);
        if (this.mapAnimationMgr != null) goto L5;
        return;
    L5:
        if (r108.isValid() == false) goto L9;
        this.mapAnimationMgr.addAnimation(r108, r107);
        return;
    }

    public void updateNativeArrowOverlay(int r110, String r111, int[] r112, int[] r113, int r210, int r211, int r212, float r213, int r214, int r215, int r216, boolean r217) {
        long r100 = this.mNativeMapengineInstance;
        if (r100 == 0) goto L7;
        if (r111 == null) goto L8;
        nativeUpdateNativeArrowOverlay(r110, r100, r111, r112, r113, r210, r211, r212, r213, r217, r214, r215, r216);
        return;
    L8:
        return;
    }
}
