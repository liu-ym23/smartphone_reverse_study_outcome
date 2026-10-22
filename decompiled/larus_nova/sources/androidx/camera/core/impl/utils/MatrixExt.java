package androidx.camera.core.impl.utils;

import android.opengl.Matrix;
import java.util.Locale;

/* JADX INFO: loaded from: classes2.dex */
public final class MatrixExt {
    private static final float[] sTemp = null;

    static {
        sTemp = new float[16];
    }

    private MatrixExt() {
    }

    public static void preVerticalFlip(float[] r100, float r101) {
        normalize(r100, 0.0f, r101);
        Matrix.scaleM(r100, 0, 1.0f, -1.0f, 1.0f);
        denormalize(r100, 0.0f, r101);
    }

    public static String toString(float[] r100, int r101) {
        return String.format(Locale.US, "Matrix:\n%2.1f %2.1f %2.1f %2.1f\n%2.1f %2.1f %2.1f %2.1f\n%2.1f %2.1f %2.1f %2.1f\n%2.1f %2.1f %2.1f %2.1f", new Object[]{Float.valueOf(r100[r101]), Float.valueOf(r100[r101 + 4]), Float.valueOf(r100[r101 + 8]), Float.valueOf(r100[r101 + 12]), Float.valueOf(r100[r101 + 1]), Float.valueOf(r100[r101 + 5]), Float.valueOf(r100[r101 + 9]), Float.valueOf(r100[r101 + 13]), Float.valueOf(r100[r101 + 2]), Float.valueOf(r100[r101 + 6]), Float.valueOf(r100[r101 + 10]), Float.valueOf(r100[r101 + 14]), Float.valueOf(r100[r101 + 3]), Float.valueOf(r100[r101 + 7]), Float.valueOf(r100[r101 + 11]), Float.valueOf(r100[r101 + 15])});
    }

    private static void denormalize(float[] r100, float r101, float r102) {
        Matrix.translateM(r100, 0, -r101, -r102, 0.0f);
    }

    private static void normalize(float[] r100, float r101, float r102) {
        Matrix.translateM(r100, 0, r101, r102, 0.0f);
    }

    public static void postRotate(float[] r100, float r101, float r102, float r110) {
        float[] r103 = sTemp;
        monitor-enter(r103);
        Matrix.setIdentityM(r103, 0);     // Catch: Throwable -> L8
        normalize(r103, r102, r110);     // Catch: Throwable -> L8
        Matrix.rotateM(r103, 0, r101, 0.0f, 0.0f, 1.0f);     // Catch: Throwable -> L8
        denormalize(r103, r102, r110);     // Catch: Throwable -> L8
        Matrix.multiplyMM(r100, 0, r103, 0, r100, 0);     // Catch: Throwable -> L8
        monitor-exit(r103);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    }

    public static void preRotate(float[] r100, float r101, float r102, float r103) {
        normalize(r100, r102, r103);
        Matrix.rotateM(r100, 0, r101, 0.0f, 0.0f, 1.0f);
        denormalize(r100, r102, r103);
    }

    public static void setRotate(float[] r100, float r101, float r102, float r103) {
        Matrix.setIdentityM(r100, 0);
        preRotate(r100, r101, r102, r103);
    }
}
