package org.libpag;

import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.Matrix;

/* loaded from: classes.dex */
public class PAGImage {
    long nativeContext;

    static {
        P4.a.a("pag");
        nativeInit();
    }

    PAGImage(long j5) {
        this.nativeContext = j5;
    }

    public static PAGImage FromAssets(AssetManager assetManager, String str) {
        long jLoadFromAssets = LoadFromAssets(assetManager, str);
        if (jLoadFromAssets == 0) {
            return null;
        }
        return new PAGImage(jLoadFromAssets);
    }

    public static PAGImage FromBitmap(Bitmap bitmap) {
        if (bitmap != null && bitmap.getConfig() == Bitmap.Config.ARGB_4444) {
            bitmap = bitmap.copy(Bitmap.Config.ARGB_8888, false);
        }
        long jLoadFromBitmap = LoadFromBitmap(bitmap);
        if (jLoadFromBitmap == 0) {
            return null;
        }
        return new PAGImage(jLoadFromBitmap);
    }

    public static PAGImage FromBytes(byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            return null;
        }
        long jLoadFromBytes = LoadFromBytes(bArr, bArr.length);
        if (jLoadFromBytes == 0) {
            return null;
        }
        return new PAGImage(jLoadFromBytes);
    }

    public static PAGImage FromPath(String str) {
        long jLoadFromPath = LoadFromPath(str);
        if (jLoadFromPath == 0) {
            return null;
        }
        return new PAGImage(jLoadFromPath);
    }

    public static PAGImage FromTexture(int i5, int i6, int i7, int i8) {
        return FromTexture(i5, i6, i7, i8, false);
    }

    private static native long LoadFromAssets(AssetManager assetManager, String str);

    private static native long LoadFromBitmap(Bitmap bitmap);

    private static native long LoadFromBytes(byte[] bArr, int i5);

    private static native long LoadFromPath(String str);

    private static native long LoadFromTexture(int i5, int i6, int i7, int i8, boolean z5);

    private native void nativeFinalize();

    private native void nativeGetMatrix(float[] fArr);

    private static final native void nativeInit();

    private final native void nativeRelease();

    private native void nativeSetMatrix(float f5, float f6, float f7, float f8, float f9, float f10);

    protected void finalize() {
        nativeFinalize();
    }

    public native int height();

    public Matrix matrix() {
        float[] fArr = new float[9];
        nativeGetMatrix(fArr);
        Matrix matrix = new Matrix();
        matrix.setValues(fArr);
        return matrix;
    }

    public void release() {
        nativeRelease();
    }

    public native int scaleMode();

    public void setMatrix(Matrix matrix) {
        float[] fArr = new float[9];
        matrix.getValues(fArr);
        nativeSetMatrix(fArr[0], fArr[3], fArr[1], fArr[4], fArr[2], fArr[5]);
    }

    public native void setScaleMode(int i5);

    public native int width();

    public static PAGImage FromTexture(int i5, int i6, int i7, int i8, boolean z5) {
        long jLoadFromTexture = LoadFromTexture(i5, i6, i7, i8, z5);
        if (jLoadFromTexture == 0) {
            return null;
        }
        return new PAGImage(jLoadFromTexture);
    }
}
