package com.autonavi.base.amap.mapcore;

import android.graphics.Rect;
import com.amap.api.maps.model.BaseOptions;
import com.amap.api.maps.model.BitmapDescriptor;
import com.amap.api.maps.model.ImageOptions;
import com.amap.api.maps.model.LatLng;
import com.autonavi.base.ae.gmap.AMapAppRequestParam;
import com.autonavi.base.amap.mapcore.annotations.ParameterIsClass;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* JADX INFO: loaded from: classes39.dex */
public class AMapNativeGlOverlayLayer extends NativeBase {
    private int mEngineId;
    protected long mNative;
    private NativeFunCallListener nativeFunCallListener;
    private ReentrantReadWriteLock readWriteLock;

    public interface NativeFunCallListener {
        void getAMapResource(AMapAppRequestParam r100);

        BitmapDescriptor getBuildInImageData(int r100);

        BitmapDescriptor getCustomImageData(ImageOptions r100);

        BitmapDescriptor getInfoContents(String r100);

        BitmapDescriptor getInfoWindow(String r100);

        BitmapDescriptor getInfoWindowClick(String r100);

        long getInfoWindowUpdateOffsetTime(String r100);

        BitmapDescriptor getOverturnInfoWindow(String r100);

        BitmapDescriptor getOverturnInfoWindowClick(String r100);

        void onRedrawInfowindow();

        void onSetRunLowFrame(boolean r100);
    }

    private native void nativeClear(String[] r100);

    private native String nativeContain(Object r100, int r101);

    private native void nativeCreate(long r100);

    private native void nativeCreateOverlay(String r100, Object r101);

    private native void nativeDestroy();

    private native void nativeFinalize();

    private native int nativeGetCurrentParticleNum(String r100);

    private native Object nativeGetNativeOverlayProperties(String r100, String r101, Object[] r102);

    private native void nativeGetOverlayBoundRect(String r100, Object r101);

    private native void nativeRemoveOverlay(String r100);

    private native void nativeRender(int r100, int r101, int r102, boolean r103, boolean r104);

    private native void nativeSetAMapEngine(long r100);

    private native void nativeUpdateOptions(String r100, Object r101);

    @Override // com.autonavi.base.amap.mapcore.NativeBase
    public void createNative() {
    }

    private void redrawInfoWindow() {
        NativeFunCallListener r100 = this.nativeFunCallListener;
        if (r100 == null) goto L6;
        r100.onRedrawInfowindow();
        return;
    }

    public AMapNativeGlOverlayLayer() {
        this.mNative = 0;
        this.mEngineId = 0;
        this.readWriteLock = new ReentrantReadWriteLock();
    }

    @Override // com.autonavi.base.amap.mapcore.NativeBase
    public void destroy() {
        super.destroy();     // Catch: Throwable -> L5
        this.readWriteLock.writeLock().lock();     // Catch: Throwable -> L5
        nativeDestroy();     // Catch: Throwable -> L5
        this.readWriteLock.writeLock().unlock();
        return;
    L5:
        th = move-exception;
        this.readWriteLock.writeLock().unlock();
        throw th;
    }

    @Override // com.autonavi.base.amap.mapcore.NativeBase
    public void finalizeNative() {
        nativeFinalize();
    }

    public int getEngineId() {
        return this.mEngineId;
    }

    @Override // com.autonavi.base.amap.mapcore.NativeBase
    public long getNative() {
        return this.mNative;
    }

    private void getAMapResource(AMapAppRequestParam r100) {
        NativeFunCallListener r101 = this.nativeFunCallListener;
        if (r101 != null) goto L5;
        return;
    L5:
        r101.getAMapResource(r100);
    }

    private BitmapDescriptor getBuildInImageData(int r100) {
        NativeFunCallListener r101 = this.nativeFunCallListener;
        if (r101 != null) goto L5;
        return null;
    L5:
        return r101.getBuildInImageData(r100);
    }

    private BitmapDescriptor getImagedData(ImageOptions r100) {
        NativeFunCallListener r101 = this.nativeFunCallListener;
        if (r101 != null) goto L5;
        return null;
    L5:
        return r101.getCustomImageData(r100);
    }

    private BitmapDescriptor getInfoContents(String r100) {
        NativeFunCallListener r101 = this.nativeFunCallListener;
        if (r101 != null) goto L5;
        return null;
    L5:
        return r101.getInfoContents(r100);
    }

    private BitmapDescriptor getInfoWindow(String r100) {
        NativeFunCallListener r101 = this.nativeFunCallListener;
        if (r101 != null) goto L5;
        return null;
    L5:
        return r101.getInfoWindow(r100);
    }

    private BitmapDescriptor getInfoWindowClick(String r100) {
        NativeFunCallListener r101 = this.nativeFunCallListener;
        if (r101 != null) goto L5;
        return null;
    L5:
        return r101.getInfoWindowClick(r100);
    }

    private long getInfoWindowUpdateOffsetTime(String r100) {
        NativeFunCallListener r101 = this.nativeFunCallListener;
        if (r101 != null) goto L5;
        return 0;
    L5:
        return r101.getInfoWindowUpdateOffsetTime(r100);
    }

    private BitmapDescriptor getOverturnInfoWindow(String r100) {
        NativeFunCallListener r101 = this.nativeFunCallListener;
        if (r101 != null) goto L5;
        return null;
    L5:
        return r101.getOverturnInfoWindow(r100);
    }

    private BitmapDescriptor getOverturnInfoWindowClick(String r100) {
        NativeFunCallListener r101 = this.nativeFunCallListener;
        if (r101 != null) goto L5;
        return null;
    L5:
        return r101.getOverturnInfoWindowClick(r100);
    }

    private void setRunLowFrame(boolean r100) {
        NativeFunCallListener r101 = this.nativeFunCallListener;
        if (r101 == null) goto L6;
        r101.onSetRunLowFrame(r100);
        return;
    }

    @ParameterIsClass
    public void clear(final String... r100) {
        if (isReady() == true) goto L5;
        storeUncallFunctionArray(this, new AnonymousClass3(this, r100), (String[]) r100.clone(), NativeFunctionRunnable.CLEAR_OVERLAY_FUNC, r100);
        return;
    L5:
        callAllFunction();
        this.readWriteLock.readLock().lock();     // Catch: Throwable -> L9
        nativeClear(r100);     // Catch: Throwable -> L9
        this.readWriteLock.readLock().unlock();
        return;
    L9:
        th = move-exception;
        this.readWriteLock.readLock().unlock();
        throw th;
    }

    public void createNative(long r100) {
    L16:
        e = move-exception;
        e.toString();
        return;
    L4:
        if (this.mNative != 0) goto L23;
        ReentrantReadWriteLock r101 = this.readWriteLock;     // Catch: Throwable -> L12
        if (r101 == null) goto L8;
        r101.writeLock().lock();     // Catch: Throwable -> L12
    L8:
        nativeCreate(r100);     // Catch: Throwable -> L12
        ReentrantReadWriteLock r102 = this.readWriteLock;     // Catch: UnsatisfiedLinkError -> L16
        if (r102 != null) goto L14;
        return;
    L14:
        r102.writeLock().unlock();     // Catch: UnsatisfiedLinkError -> L16
        return;
    L12:
        r102 = this.readWriteLock;     // Catch: UnsatisfiedLinkError -> L16
        if (r102 != null) goto L14;
        return;
    }

    public int getCurrentParticleNum(String r100) {
        if (isReady() == true) goto L5;
        return 0;
    L5:
        callAllFunction();
        this.readWriteLock.readLock().lock();     // Catch: Throwable -> L9
        int r101 = nativeGetCurrentParticleNum(r100);     // Catch: Throwable -> L9
        this.readWriteLock.readLock().unlock();
        return r101;
    L9:
        th = move-exception;
        this.readWriteLock.readLock().unlock();
        throw th;
    }

    public Rect getOverlayBoundRect(final String r100) {
        if (isReady() == false) goto L16;
        if (r100 == null) goto L16;
        this.readWriteLock.readLock().lock();     // Catch: Throwable -> L13
        if (this.destroy == false) goto L10;
        this.readWriteLock.readLock().unlock();
        return null;
    L10:
        Rect r101 = new Rect();     // Catch: Throwable -> L13
        nativeGetOverlayBoundRect(r100, r101);     // Catch: Throwable -> L13
        this.readWriteLock.readLock().unlock();
        return r101;
    L13:
        th = move-exception;
        this.readWriteLock.readLock().unlock();
        throw th;
    L16:
        storeUncallFunction(this, new AnonymousClass6(this, r100), r100, NativeFunctionRunnable.GET_OVERLAY_BOUND_RECT, new Object[0]);
        return null;
    }

    @ParameterIsClass
    public void removeOverlay(final String r100) {
        if (isReady() == true) goto L5;
        storeUncallFunction(this, new AnonymousClass2(this, r100), r100, NativeFunctionRunnable.REMOVE_OVERLAY_FUNC, new Object[0]);
        return;
    L5:
        callAllFunction();
        this.readWriteLock.readLock().lock();     // Catch: Throwable -> L9
        nativeRemoveOverlay(r100);     // Catch: Throwable -> L9
        this.readWriteLock.readLock().unlock();
        return;
    L9:
        th = move-exception;
        this.readWriteLock.readLock().unlock();
        throw th;
    }

    public void setAMapEngine(long r100) {
        this.readWriteLock.readLock().lock();     // Catch: Throwable -> L5
        nativeSetAMapEngine(r100);     // Catch: Throwable -> L5
        this.readWriteLock.readLock().unlock();
        return;
    L5:
        th = move-exception;
        this.readWriteLock.readLock().unlock();
        throw th;
    }

    public void setEngineId(int r100) {
        this.mEngineId = r100;
    }

    public void setNativeFunCallListener(NativeFunCallListener r100) {
        this.nativeFunCallListener = r100;
    }

    public static /* synthetic */ void access$000(AMapNativeGlOverlayLayer r100, boolean r101) {
        r100.setRunLowFrame(r101);
    }

    public String contain(LatLng r100, int r101) {
        if (isReady() == true) goto L5;
        return "";
    L5:
        callAllFunction();
        this.readWriteLock.readLock().lock();     // Catch: Throwable -> L9
        String r102 = nativeContain(r100, r101);     // Catch: Throwable -> L9
        this.readWriteLock.readLock().unlock();
        return r102;
    L9:
        th = move-exception;
        this.readWriteLock.readLock().unlock();
        throw th;
    }

    public void createOverlay(final String r100, final BaseOptions r101) {
        if (isReady() == true) goto L5;
        storeUncallFunction(this, new AnonymousClass1(this, r100, r101), r100, NativeFunctionRunnable.CREATE_OVERLAY_FUNC, new Object[]{r101});
        return;
    L5:
        callAllFunction();
        this.readWriteLock.readLock().lock();     // Catch: Throwable -> L9
        nativeCreateOverlay(r100, r101);     // Catch: Throwable -> L9
        this.readWriteLock.readLock().unlock();
        return;
    L9:
        th = move-exception;
        this.readWriteLock.readLock().unlock();
        throw th;
    }

    @ParameterIsClass
    public void updateOptions(final String r100, final BaseOptions r101) {
    L15:
        th = move-exception;
        th.printStackTrace();
        th.getMessage();
        return;
    L3:
        if (isReady() == false) goto L6;
        callAllFunction();     // Catch: Throwable -> L15
        this.readWriteLock.readLock().lock();     // Catch: Throwable -> L12
        nativeUpdateOptions(r100, r101);     // Catch: Throwable -> L12
        if (r101 == null) goto L11;
        r101.resetUpdateFlags();     // Catch: Throwable -> L12
    L11:
        this.readWriteLock.readLock().unlock();     // Catch: Throwable -> L15
        return;
    L12:
        th = move-exception;
        this.readWriteLock.readLock().unlock();     // Catch: Throwable -> L15
        throw th;     // Catch: Throwable -> L15
    L6:
        storeUncallFunction(this, new AnonymousClass4(this, r100, r101), r100, NativeFunctionRunnable.UPDATE_OPTIONS_FUNC, new Object[]{r101});     // Catch: Throwable -> L15
    }

    public Object getNativeProperties(final String r100, final String r110, final Object[] r111) {
        if (isReady() == false) goto L16;
        if (r100 == null) goto L16;
        this.readWriteLock.readLock().lock();     // Catch: Throwable -> L13
        if (this.destroy == false) goto L10;
        this.readWriteLock.readLock().unlock();
        return null;
    L10:
        Object r101 = nativeGetNativeOverlayProperties(r100, r110, r111);     // Catch: Throwable -> L13
        this.readWriteLock.readLock().unlock();
        return r101;
    L13:
        th = move-exception;
        this.readWriteLock.readLock().unlock();
        throw th;
    L16:
        storeUncallFunction(this, new AnonymousClass5(this, r100, r110, r111), r100, r110, r111);
        return null;
    }

    public void render(int r100, int r101, int r102, boolean r103, boolean r104) {
        callAllFunction();
        this.readWriteLock.readLock().lock();     // Catch: Throwable -> L6
        nativeRender(r100, r101, r102, r103, r104);     // Catch: Throwable -> L6
        this.readWriteLock.readLock().unlock();
        return;
    L6:
        th = move-exception;
        this.readWriteLock.readLock().unlock();
        throw th;
    }
}
