package com.autonavi.base.ae.gmap.gloverlay;

import android.util.SparseArray;
import com.autonavi.base.ae.gmap.gloverlay.BaseMapOverlay;
import com.autonavi.base.amap.api.mapcore.IAMapDelegate;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes39.dex */
public class GLOverlayBundle<E extends BaseMapOverlay<?, ?>> {
    private int mEngineID;
    private long mNativeInstance;
    private final List<E> mOverlayList;
    private SparseArray<GLOverlayTexture> mTextureCaches;

    public static class GLAmapFocusHits {
        public long mHitedIndex;
        public long mHitedTimes;
        public long mOverlayHashCode;

        public GLAmapFocusHits() {
            this.mOverlayHashCode = 0;
            this.mHitedIndex = 0;
            this.mHitedTimes = 1000;
        }
    }

    private int getOverlyExType(E r100) {
        return 0;
    }

    private static native void nativeAddGLOverlay(long r100, long r101, long r102);

    private static native void nativeAddGLOverlayEx(long r100, long r101, long r102, int r103);

    private static native void nativeClearAllGLOverlay(long r100, boolean r101);

    private static native boolean nativeOnSingleTapLineOverlay(long r100, int r101, int r102, long[] r103);

    private static native boolean nativeOnSingleTapPointOverlay(long r100, int r101, int r102, long[] r103);

    private static native void nativeRemoveGLOverlay(long r100, long r101);

    private static native void nativeRemoveGLOverlayEx(long r100, long r101, int r102);

    private static native void nativeSortAllGLOverlay(long r100);

    public boolean onSingleTapLines(int r100, int r101, int r102) {
        return false;
    }

    public boolean onSingleTapPoints(int r100, int r101, int r102) {
        return false;
    }

    public void reculateRouteBoard(IAMapDelegate r100) {
    }

    public void clearFocus() {
        List<E> r100 = this.mOverlayList;
        if (r100 == null) goto L17;
        monitor-enter(r100);
        int r101 = 0;
    L18:
    L14:
        th = move-exception;
        throw th;
    L7:
        if (r101 >= this.mOverlayList.size()) goto L12;
        E r102 = this.mOverlayList.get(r101);     // Catch: Throwable -> L14
        if (r102 == null) goto L11;
        r102.clearFocus();     // Catch: Throwable -> L14
    L11:
        r101 = r101 + 1;     // Catch: Throwable -> L14
        goto L18
    L12:
        monitor-exit(r100);     // Catch: Throwable -> L14
        return;
    }

    public void clearOverlayTexture() {
        SparseArray<GLOverlayTexture> r100 = this.mTextureCaches;
        monitor-enter(r100);
        this.mTextureCaches.clear();     // Catch: Throwable -> L7
        monitor-exit(r100);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public int getOverlayCount() {
        List<E> r100 = this.mOverlayList;
        monitor-enter(r100);
        int r101 = this.mOverlayList.size();     // Catch: Throwable -> L7
        monitor-exit(r100);     // Catch: Throwable -> L7
        return r101;
    L7:
        th = move-exception;
        throw th;
    }

    public void sortOverlay() {
        nativeSortAllGLOverlay(this.mNativeInstance);
    }

    public void addOverlay(E r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        nativeAddGLOverlay(this.mNativeInstance, r100.getGLOverlay().getNativeInstatnce(), r100.getGLOverlay().getCode());
        r100.getGLOverlay().mIsInBundle = true;
        List<E> r101 = this.mOverlayList;
        monitor-enter(r101);
        this.mOverlayList.add(r100);     // Catch: Throwable -> L9
        monitor-exit(r101);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        throw th;
    }

    public boolean cotainsOverlay(E r100) {
        if (r100 != null) goto L5;
        return false;
    L5:
        List<E> r101 = this.mOverlayList;
        monitor-enter(r101);
        boolean r102 = this.mOverlayList.contains(r100);     // Catch: Throwable -> L10
        monitor-exit(r101);     // Catch: Throwable -> L10
        return r102;
    L10:
        th = move-exception;
        throw th;
    }

    public E getOverlay(int r100) {
        List<E> r101 = this.mOverlayList;
        monitor-enter(r101);
        if (r100 >= 0) goto L18;
    L13:
        monitor-exit(r101);     // Catch: Throwable -> L11
        return null;
    L18:
    L11:
        th = move-exception;
        throw th;
    L6:
        if (r100 > (this.mOverlayList.size() - 1)) goto L13;
        E r102 = this.mOverlayList.get(r100);     // Catch: Throwable -> L11
        monitor-exit(r101);     // Catch: Throwable -> L11
        return r102;
    }

    public GLOverlayTexture getOverlayTextureItem(int r100) {
        SparseArray<GLOverlayTexture> r101 = this.mTextureCaches;
        monitor-enter(r101);
        GLOverlayTexture r102 = this.mTextureCaches.get(r100);     // Catch: Throwable -> L7
        monitor-exit(r101);     // Catch: Throwable -> L7
        return r102;
    L7:
        th = move-exception;
        throw th;
    }

    public void removeAll(boolean r100) {
        nativeClearAllGLOverlay(this.mNativeInstance, r100);
        List<E> r101 = this.mOverlayList;
        monitor-enter(r101);
        int r102 = 0;
    L17:
    L14:
        th = move-exception;
        throw th;
    L6:
        if (r102 >= this.mOverlayList.size()) goto L11;
        E r103 = this.mOverlayList.get(r102);     // Catch: Throwable -> L14
        if (r103 == null) goto L10;
        r103.getGLOverlay().mIsInBundle = false;     // Catch: Throwable -> L14
        r103.getGLOverlay().releaseInstance();     // Catch: Throwable -> L14
    L10:
        r102 = r102 + 1;     // Catch: Throwable -> L14
        goto L17
    L11:
        this.mOverlayList.clear();     // Catch: Throwable -> L14
        monitor-exit(r101);     // Catch: Throwable -> L14
    }

    public void removeOverlay(E r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        nativeRemoveGLOverlay(this.mNativeInstance, r100.getGLOverlay().getNativeInstatnce());
        r100.getGLOverlay().mIsInBundle = false;
        List<E> r101 = this.mOverlayList;
        monitor-enter(r101);
        this.mOverlayList.remove(r100);     // Catch: Throwable -> L9
        monitor-exit(r101);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        throw th;
    }

    public GLOverlayBundle(int r100, IAMapDelegate r101) {
        this.mOverlayList = new ArrayList();
        this.mNativeInstance = 0;
        this.mTextureCaches = new SparseArray();
        this.mEngineID = r100;
        if (r101 == null) goto L9;
        this.mNativeInstance = r101.getGLMapEngine().getGlOverlayMgrPtr(this.mEngineID);     // Catch: Throwable -> L6
        return;
    L10:
        return;
    }

    public static void intClr2PVRClr(float[] r100, int r101) {
        r100[2] = (r101 & 255) / 255.0f;
        r100[1] = ((r101 >> 8) & 255) / 255.0f;
        r100[0] = ((r101 >> 16) & 255) / 255.0f;
        r100[3] = ((r101 >> 24) & 255) / 255.0f;
    }

    public long checkSingleTapOnLine(int r100, int r101) {
        long[] r102 = new long[3];
        if (nativeOnSingleTapLineOverlay(this.mNativeInstance, r100, r101, r102) == true) goto L5;
        return -1;
    L5:
        return r102[0];
    }

    public long checkSingleTapOnPoint(int r100, int r101) {
        long[] r102 = new long[3];
        if (nativeOnSingleTapPointOverlay(this.mNativeInstance, r100, r101, r102) == true) goto L5;
        return -1;
    L5:
        return r102[0];
    }

    public boolean addOverlayTextureItem(int r100, int r101, int r102, int r103) {
        GLOverlayTexture r104 = new GLOverlayTexture(r100, r101, r102, r103);
        SparseArray<GLOverlayTexture> r105 = this.mTextureCaches;
        monitor-enter(r105);
        this.mTextureCaches.put(r100, r104);     // Catch: Throwable -> L8
        monitor-exit(r105);     // Catch: Throwable -> L8
        return true;
    L8:
        th = move-exception;
        throw th;
    }

    public boolean onSingleTap(int r100, int r101, int r102, int r103) {
        if ((r103 & 1) != 1) goto L5;
        boolean r104 = onSingleTapPoints(r100, r101, r102);
    L6:
        if (r104 == false) goto L9;
        return true;
    L9:
        if ((r103 & 2) != 2) goto L11;
        r104 = onSingleTapLines(r100, r101, r102);
    L11:
        if (r104 == false) goto L13;
        return true;
    L13:
        return false;
    L5:
        r104 = false;
        goto L6
    }

    public boolean addOverlayTextureItem(int r100, int r110, float r111, float r112, int r113, int r114) {
        GLOverlayTexture r101 = new GLOverlayTexture(r100, r110, r111, r112, r113, r114);
        SparseArray<GLOverlayTexture> r115 = this.mTextureCaches;
        monitor-enter(r115);
        this.mTextureCaches.put(r100, r101);     // Catch: Throwable -> L8
        monitor-exit(r115);     // Catch: Throwable -> L8
        return true;
    L8:
        th = move-exception;
        throw th;
    }
}
