package com.bef.effectsdk;

import com.ss.android.tecommonenvinitializer.diagnosis.b;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes39.dex */
public class BEFEffectNative {
    public static final int BEF_CLOCKWISE_ROTATE_0 = 0;
    public static final int BEF_CLOCKWISE_ROTATE_180 = 2;
    public static final int BEF_CLOCKWISE_ROTATE_270 = 3;
    public static final int BEF_CLOCKWISE_ROTATE_90 = 1;
    private static final List<String> list = null;

    public BEFEffectNative() {
    }

    private static native long nativeCreateHandle(boolean r100);

    private static native int nativeDestroyHandle(long r100);

    private static native String nativeGetEffectSDKVersion();

    private static native int nativeInitResourceFinder(long r100, ResourceFinder r101, int r102, int r103, String r104);

    private static native int nativeProcessAlgorithm(long r100, int r101, int r102, int r103, double r104);

    private static native int nativeProcessFrame(long r100, int r101, int r102, int r103, int r104, double r105);

    private static native int nativeReleaseResourceFinder(long r100, ResourceFinder r101);

    private static native int nativeSendMessage(long r100, long r101, long r102, long r103, String r104);

    private static native void nativeSetCameraPosition(long r100, boolean r101);

    private static native void nativeSetFrameOrientation(long r100, int r101);

    private static native void nativeSetOrientation(long r100, int r101);

    private static native int nativeSetStickerPath(long r100, String r101);

    private static native int nativeTouchEvent(long r100, int r101, int[] r102, float[] r103, float[] r104);

    static {
        List<String> r100 = Arrays.asList(new String[]{"effect"});
        list = r100;
        b.a(r100);     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        th.printStackTrace();
    }

    public static String getEffectSDKVersion() {
        return nativeGetEffectSDKVersion();
    }

    public static long createHandle(boolean r100) {
        return nativeCreateHandle(r100);
    }

    public static int destroyHandle(long r100) {
        return nativeDestroyHandle(r100);
    }

    public static int releaseResourceFinder(long r100, ResourceFinder r101) {
        return nativeReleaseResourceFinder(r100, r101);
    }

    public static void setCameraPosition(long r100, boolean r101) {
        nativeSetCameraPosition(r100, r101);
    }

    public static void setFrameOrientation(long r100, int r101) {
        nativeSetFrameOrientation(r100, r101);
    }

    public static void setOrientation(long r100, int r101) {
        nativeSetOrientation(r100, r101);
    }

    public static int setStickerPath(long r100, String r101) {
        return nativeSetStickerPath(r100, r101);
    }

    public static int touchBeginEvent(long r100, int[] r101, float[] r102, float[] r110) {
        return nativeTouchEvent(r100, 0, r101, r102, r110);
    }

    public static int touchEndEvent(long r100, int[] r101, float[] r102, float[] r110) {
        return nativeTouchEvent(r100, 2, r101, r102, r110);
    }

    public static int touchMoveEvent(long r100, int[] r101, float[] r102, float[] r110) {
        return nativeTouchEvent(r100, 1, r101, r102, r110);
    }

    public static int initResourceFinder(long r100, ResourceFinder r101, int r102, int r103, String r104) {
        return nativeInitResourceFinder(r100, r101, r102, r103, r104);
    }

    public static int processAlgorithm(long r100, int r101, int r102, int r103, double r104) {
        return nativeProcessAlgorithm(r100, r101, r102, r103, r104);
    }

    public static int sendMessage(long r100, long r101, long r102, long r103, String r104) {
        return nativeSendMessage(r100, r101, r102, r103, r104);
    }

    public static int processFrame(long r100, int r101, int r102, int r103, int r104, double r105) {
        return nativeProcessFrame(r100, r101, r102, r103, r104, r105);
    }
}
