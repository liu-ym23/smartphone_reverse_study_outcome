package com.autonavi.base.ae.gmap.gloverlay;

import android.content.Context;
import android.graphics.Bitmap;
import com.autonavi.amap.mapcore.interfaces.IAMap;
import com.autonavi.base.ae.gmap.gloverlay.GLOverlay;
import com.autonavi.base.amap.api.mapcore.IAMapDelegate;
import java.io.Serializable;
import java.util.List;
import java.util.Vector;

/* JADX INFO: loaded from: classes39.dex */
public abstract class BaseMapOverlay<T extends GLOverlay, E> implements Serializable {
    private static final long serialVersionUID = 1;
    protected Context mContext;
    protected int mEngineID;
    protected T mGLOverlay;
    protected Vector<E> mItemList;
    protected int mLastFocusedIndex;
    protected IAMapDelegate mMapView;

    public abstract void addItem(E r100);

    public void clearFocus() {
        this.mLastFocusedIndex = -1;
        this.mGLOverlay.clearFocus();
    }

    public abstract void iniGLOverlay();

    public abstract void resumeMarker(Bitmap r100);

    public abstract void setVisible(boolean r100);

    public boolean clear() {
        this.mItemList.clear();     // Catch: Exception -> L7
        clearFocus();     // Catch: Exception -> L7
        T r100 = this.mGLOverlay;     // Catch: Exception -> L7
        if (r100 == null) goto L11;
        r100.removeAll();     // Catch: Exception -> L7
        return true;
    L11:
        return true;
    L7:
        return false;
    }

    public int getSize() {
        return this.mItemList.size();
    }

    public boolean isClickable() {
        T r100 = this.mGLOverlay;
        if (r100 != null) goto L5;
        return false;
    L5:
        return r100.isClickable();
    }

    public boolean isVisible() {
        T r100 = this.mGLOverlay;
        if (r100 != null) goto L5;
        return false;
    L5:
        return r100.isVisible();
    }

    public void releaseInstance() {
        if (getGLOverlay() == null) goto L11;
        IAMapDelegate r100 = this.mMapView;
        if (r100 != null) goto L7;
    L9:
        getGLOverlay().releaseInstance();
        this.mGLOverlay = null;
        return;
    L7:
        if (r100.isMaploaded() == false) goto L9;
        this.mMapView.removeEngineGLOverlay(this);
        goto L9
    }

    public boolean removeAll() {
        return clear();
    }

    public T getGLOverlay() {
        return this.mGLOverlay;
    }

    public List<E> getItems() {
        return this.mItemList;
    }

    public final E getItem(int r100) {
        Vector<E> r101 = this.mItemList;     // Catch: IndexOutOfBoundsException -> L18
        monitor-enter(r101);     // Catch: IndexOutOfBoundsException -> L18
        if (r100 >= 0) goto L20;
    L14:
        monitor-exit(r101);     // Catch: Throwable -> L12
        return null;
    L20:
    L12:
        th = move-exception;
        throw th;     // Catch: IndexOutOfBoundsException -> L18
    L7:
        if (r100 > (this.mItemList.size() - 1)) goto L14;
        E r102 = this.mItemList.get(r100);     // Catch: Throwable -> L12
        monitor-exit(r101);     // Catch: Throwable -> L12
        return r102;
    L18:
        return null;
    }

    public void removeItem(int r100) {
        if (r100 < 0) goto L16;
        if (r100 <= (this.mItemList.size() - 1)) goto L7;
        return;
    L7:
        if (r100 != this.mLastFocusedIndex) goto L9;
        this.mLastFocusedIndex = -1;     // Catch: IndexOutOfBoundsException -> L13
        clearFocus();     // Catch: IndexOutOfBoundsException -> L13
    L9:
        this.mItemList.remove(r100);     // Catch: IndexOutOfBoundsException -> L13
        T r101 = this.mGLOverlay;     // Catch: IndexOutOfBoundsException -> L13
        if (r101 == null) goto L18;
        r101.removeItem(r100);     // Catch: IndexOutOfBoundsException -> L13
        return;
    L18:
        return;
    L19:
        return;
    }

    public void setClickable(boolean r100) {
        T r101 = this.mGLOverlay;
        if (r101 == null) goto L6;
        r101.setClickable(r100);
        return;
    }

    public void removeItem(E r100) {
        if (r100 != null) goto L16;
        return;
    L16:
        Vector<E> r101 = this.mItemList;     // Catch: IndexOutOfBoundsException -> L13
        monitor-enter(r101);     // Catch: IndexOutOfBoundsException -> L13
        removeItem(this.mItemList.indexOf(r100));     // Catch: Throwable -> L9
        monitor-exit(r101);     // Catch: Throwable -> L9
        goto L18
    L12:
        return;
    L9:
        th = move-exception;
        throw th;     // Catch: IndexOutOfBoundsException -> L13
    }

    public BaseMapOverlay(int r100, Context r101, IAMap r102) {
        this.mItemList = null;
        this.mEngineID = r100;
        this.mContext = r101;
        this.mMapView = (IAMapDelegate) r102;     // Catch: Throwable -> L6
    L4:
        this.mItemList = new Vector();
        iniGLOverlay();
    }
}
