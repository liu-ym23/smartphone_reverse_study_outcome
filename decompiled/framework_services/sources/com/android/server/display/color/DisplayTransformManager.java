package com.android.server.display.color;

import android.app.ActivityTaskManager;
import android.opengl.Matrix;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import android.os.ServiceManager;
import android.os.SystemProperties;
import android.pico.utils.ExtImplFactory;
import android.util.Slog;
import android.util.SparseArray;
import java.lang.reflect.Array;
import java.util.Arrays;

/* JADX INFO: loaded from: classes2.dex */
public class DisplayTransformManager {
    private static final float COLOR_SATURATION_BOOSTED = 1.1f;
    private static final float COLOR_SATURATION_NATURAL = 1.0f;
    private static final int DISPLAY_COLOR_ENHANCED = 2;
    private static final int DISPLAY_COLOR_MANAGED = 0;
    private static final int DISPLAY_COLOR_UNMANAGED = 1;
    public static final int LEVEL_COLOR_MATRIX_DISPLAY_WHITE_BALANCE = 125;
    public static final int LEVEL_COLOR_MATRIX_GRAYSCALE = 200;
    public static final int LEVEL_COLOR_MATRIX_INVERT_COLOR = 300;
    public static final int LEVEL_COLOR_MATRIX_NIGHT_DISPLAY = 100;
    public static final int LEVEL_COLOR_MATRIX_REDUCE_BRIGHT_COLORS = 250;
    public static final int LEVEL_COLOR_MATRIX_SATURATION = 150;
    static final String PERSISTENT_PROPERTY_COMPOSITION_COLOR_MODE = "persist.sys.sf.color_mode";
    static final String PERSISTENT_PROPERTY_DISPLAY_COLOR = "persist.sys.sf.native_mode";
    static final String PERSISTENT_PROPERTY_SATURATION = "persist.sys.sf.color_saturation";
    private static final String SURFACE_FLINGER = "SurfaceFlinger";
    private static final int SURFACE_FLINGER_TRANSACTION_COLOR_MATRIX = 1015;
    private static final int SURFACE_FLINGER_TRANSACTION_DALTONIZER = 1014;
    private static final int SURFACE_FLINGER_TRANSACTION_DISPLAY_COLOR = 1023;
    private static final int SURFACE_FLINGER_TRANSACTION_QUERY_COLOR_MANAGED = 1030;
    private static final int SURFACE_FLINGER_TRANSACTION_SATURATION = 1022;
    private static final String TAG = "DisplayTransformManager";
    private static final IBinder sFlinger = null;
    private final SparseArray<float[]> mColorMatrix;
    int mDaltonizerLevel;
    int mDaltonizerMode;
    final Object mDaltonizerModeLock;
    private IExtDisplayTransformManager mExt;
    private final float[][] mTempColorMatrix;

    static {
        sFlinger = ServiceManager.getService(SURFACE_FLINGER);
    }

    DisplayTransformManager() {
        this.mColorMatrix = new SparseArray(10);
        this.mTempColorMatrix = (float[][]) Array.newInstance(Float.TYPE, new int[]{2, 16});
        this.mDaltonizerModeLock = new Object();
        this.mDaltonizerMode = -1;
        this.mDaltonizerLevel = -1;
        this.mExt = (IExtDisplayTransformManager) ExtImplFactory.getImpl(IExtDisplayTransformManager.class, new Object[]{this});
    }

    public float[] getColorMatrix(int key) {
        SparseArray<float[]> r0 = this.mColorMatrix;
        monitor-enter(r0);
        float[] value = this.mColorMatrix.get(key);     // Catch: Throwable -> L10
        if (value != null) goto L7;
        float[] r2 = null;
    L8:
        monitor-exit(r0);     // Catch: Throwable -> L10
        return r2;
    L7:
        r2 = Arrays.copyOf(value, value.length);     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    }

    public void setColorMatrix(int level, float[] value) {
        if (value != null) goto L4;
    L8:
        SparseArray<float[]> r0 = this.mColorMatrix;
        monitor-enter(r0);
        float[] oldValue = this.mColorMatrix.get(level);     // Catch: Throwable -> L14
        this.mExt.setColorMatrix(level, oldValue, value, this.mColorMatrix);     // Catch: Throwable -> L14
        if (Arrays.equals(oldValue, value) == true) goto L20;
        if (value != null) goto L16;
        this.mColorMatrix.remove(level);     // Catch: Throwable -> L14
    L19:
        applyColorMatrix(computeColorMatrixLocked());     // Catch: Throwable -> L14
        goto L20
    L16:
        if (oldValue != null) goto L18;
        this.mColorMatrix.put(level, Arrays.copyOf(value, value.length));     // Catch: Throwable -> L14
        goto L19
    L18:
        System.arraycopy(value, 0, oldValue, 0, value.length);     // Catch: Throwable -> L14
    L20:
        monitor-exit(r0);     // Catch: Throwable -> L14
        return;
    L14:
        th = move-exception;
        throw th;
    L4:
        if (value.length == 16) goto L8;
        throw new IllegalArgumentException("Expected length: 16 (4x4 matrix), actual length: " + value.length);
    }

    public void setDaltonizerMode(int mode, int level) {
        Object r0 = this.mDaltonizerModeLock;
        monitor-enter(r0);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (this.mDaltonizerMode != mode) goto L11;
        if (this.mDaltonizerLevel != level) goto L11;
    L12:
        monitor-exit(r0);     // Catch: Throwable -> L9
        return;
    L11:
        this.mDaltonizerMode = mode;     // Catch: Throwable -> L9
        this.mDaltonizerLevel = level;     // Catch: Throwable -> L9
        applyDaltonizerMode(mode, level);     // Catch: Throwable -> L9
        goto L12
    }

    private float[] computeColorMatrixLocked() {
        int count = this.mColorMatrix.size();
        if (count != 0) goto L6;
        return null;
    L6:
        float[][] result = this.mTempColorMatrix;
        Matrix.setIdentityM(result[0], 0);
        int i = 0;
    L7:
        if (i >= count) goto L9;
        float[] rhs = this.mColorMatrix.valueAt(i);
        Matrix.multiplyMM(result[(i + 1) % 2], 0, result[i % 2], 0, rhs, 0);
        i = i + 1;
        goto L7
    L9:
        int i2 = count % 2;
        return result[i2];
    }

    private static void applyColorMatrix(float[] m) {
        if (getCacheExt() == null) goto L5;
        getCacheExt().applyColorMatrix(m);
    L5:
        Parcel data = Parcel.obtain();
        data.writeInterfaceToken("android.ui.ISurfaceComposer");
        if (m == null) goto L12;
        data.writeInt(1);
        int i = 0;
    L9:
        if (i >= 16) goto L23;
        data.writeFloat(m[i]);
        i = i + 1;
    L23:
        sFlinger.transact(1015, data, null, 0);     // Catch: Throwable -> L15 RemoteException -> L17
    L14:
        data.recycle();
        return;
    L17:
        ex = move-exception;
        Slog.e(TAG, "Failed to set color transform", ex);     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        data.recycle();
        throw th;
    L12:
        data.writeInt(0);
        goto L23
    }

    private static void applyDaltonizerMode(int mode, int level) {
        if (getCacheExt() == null) goto L5;
        getCacheExt().applyDaltonizerMode(mode, level);
    L5:
        Parcel data = Parcel.obtain();
        data.writeInterfaceToken("android.ui.ISurfaceComposer");
        data.writeInt(mode);
        data.writeInt(level);
        sFlinger.transact(1014, data, null, 0);     // Catch: Throwable -> L8 RemoteException -> L10
    L7:
        data.recycle();
        return;
    L10:
        ex = move-exception;
        Slog.e(TAG, "Failed to set Daltonizer mode", ex);     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        data.recycle();
        throw th;
    }

    public boolean needsLinearColorMatrix() {
        if (SystemProperties.getInt(PERSISTENT_PROPERTY_DISPLAY_COLOR, 1) != 1) goto L7;
        return false;
    L7:
        return true;
    }

    public boolean needsLinearColorMatrix(int colorMode) {
        if (colorMode == 2) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean setColorMode(int colorMode, float[] nightDisplayMatrix, float[] rbcMatrix, int compositionColorMode) {
        if (colorMode != 0) goto L5;
        applySaturation(1.0f);
        setDisplayColor(0, compositionColorMode);
    L18:
        setColorMatrix(100, nightDisplayMatrix);
        setColorMatrix(250, rbcMatrix);
        updateConfiguration();
        return true;
    L5:
        if (colorMode != 1) goto L8;
        applySaturation(COLOR_SATURATION_BOOSTED);
        setDisplayColor(0, compositionColorMode);
        goto L18
    L8:
        if (colorMode != 2) goto L11;
        applySaturation(1.0f);
        setDisplayColor(1, compositionColorMode);
        goto L18
    L11:
        if (colorMode != 3) goto L14;
        applySaturation(1.0f);
        setDisplayColor(2, compositionColorMode);
        goto L18
    L14:
        if (colorMode < 256) goto L18;
        if (colorMode > 511) goto L18;
        applySaturation(1.0f);
        setDisplayColor(colorMode, compositionColorMode);
        goto L18
    }

    public boolean isDeviceColorManaged() {
        Parcel data = Parcel.obtain();
        Parcel reply = Parcel.obtain();
        data.writeInterfaceToken("android.ui.ISurfaceComposer");
        sFlinger.transact(SURFACE_FLINGER_TRANSACTION_QUERY_COLOR_MANAGED, data, reply, 0);     // Catch: Throwable -> L6 RemoteException -> L8
        boolean r2 = reply.readBoolean();     // Catch: Throwable -> L6 RemoteException -> L8
        data.recycle();
        reply.recycle();
        return r2;
    L6:
        th = move-exception;
        data.recycle();
        reply.recycle();
        throw th;
    L8:
        ex = move-exception;
        Slog.e(TAG, "Failed to query wide color support", ex);     // Catch: Throwable -> L6
        data.recycle();
        reply.recycle();
        return false;
    }

    private void applySaturation(float saturation) {
        if (getCacheExt() == null) goto L5;
        getCacheExt().applySaturation(saturation);
    L5:
        SystemProperties.set(PERSISTENT_PROPERTY_SATURATION, Float.toString(saturation));
        Parcel data = Parcel.obtain();
        data.writeInterfaceToken("android.ui.ISurfaceComposer");
        data.writeFloat(saturation);
        sFlinger.transact(SURFACE_FLINGER_TRANSACTION_SATURATION, data, null, 0);     // Catch: Throwable -> L8 RemoteException -> L10
    L7:
        data.recycle();
        return;
    L8:
        th = move-exception;
        data.recycle();
        throw th;
    L10:
        ex = move-exception;
        Slog.e(TAG, "Failed to set saturation", ex);     // Catch: Throwable -> L8
        goto L7
    }

    private void setDisplayColor(int color, int compositionColorMode) {
        if (getCacheExt() == null) goto L5;
        getCacheExt().setDisplayColor(color, compositionColorMode);
    L5:
        SystemProperties.set(PERSISTENT_PROPERTY_DISPLAY_COLOR, Integer.toString(color));
        if (compositionColorMode == (-1)) goto L8;
        SystemProperties.set(PERSISTENT_PROPERTY_COMPOSITION_COLOR_MODE, Integer.toString(compositionColorMode));
    L8:
        Parcel data = Parcel.obtain();
        data.writeInterfaceToken("android.ui.ISurfaceComposer");
        data.writeInt(color);
        if (compositionColorMode == (-1)) goto L21;
        data.writeInt(compositionColorMode);
    L21:
        sFlinger.transact(SURFACE_FLINGER_TRANSACTION_DISPLAY_COLOR, data, null, 0);     // Catch: Throwable -> L13 RemoteException -> L15
    L12:
        data.recycle();
        return;
    L13:
        th = move-exception;
        data.recycle();
        throw th;
    L15:
        ex = move-exception;
        Slog.e(TAG, "Failed to set display color", ex);     // Catch: Throwable -> L13
        goto L12
    }

    private void updateConfiguration() {
        ActivityTaskManager.getService().updateConfiguration(null);     // Catch: RemoteException -> L4
        return;
    L4:
        e = move-exception;
        Slog.e(TAG, "Could not update configuration", e);
    }

    private static IExtDisplayTransformManager getCacheExt() {
        return IExtDisplayTransformManager.sCacheInstances.get(IExtDisplayTransformManager.class);
    }

    public IExtDisplayTransformManager getExt() {
        return this.mExt;
    }
}
