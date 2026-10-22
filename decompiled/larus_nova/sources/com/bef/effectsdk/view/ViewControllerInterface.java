package com.bef.effectsdk.view;

import com.ss.android.tecommonenvinitializer.diagnosis.b;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes39.dex */
public class ViewControllerInterface {
    private static final List<String> list = null;

    public interface NativeMessageListener {
        int nativeOnMsgReceived(long r100, long r101, long r102, String r103);
    }

    public ViewControllerInterface() {
    }

    private static native int nativeAddMessageListener(long r100, NativeMessageListener r101);

    private static native int nativeAttachEffect(long r100, long r101);

    private static native void nativeCreateHandle(long[] r100);

    private static native void nativeCreateHandle(long[] r100, int r101);

    private static native int nativeCreateTexture(int r100, int r101, int r102, int r103, int r104);

    private static native int nativeDeleteTexture(int r100);

    private static native int nativeDestroy(long r100);

    private static native int nativeInit(long r100, int r101, int r102);

    private static native void nativeOnPause(long r100);

    private static native void nativeOnResume(long r100);

    private static native int nativePostMessage(long r100, long r101, long r102, long r103, String r104);

    private static native int nativeProcess(long r100, int r101, int r102, int r103, float[] r104, float[] r105, double r106);

    private static native int nativeRemoveMessageListener(long r100, NativeMessageListener r101);

    private static native int nativeSetRenderCacheData(long r100, String r101, String r102);

    private static native int nativeSetRenderCacheTexture(long r100, String r101, String r102);

    private static native int nativeSetRenderCacheTextureWithBuffer(long r100, String r101, byte[] r102, int r103, int r104);

    private static native int nativeSetResourceFinder(long r100, long r101, long r102);

    private static native int nativeSetStickerPath(long r100, String r101);

    private static native int nativeTouchEvent(long r100, int r101, int[] r102, float[] r103, float[] r104, int r105);

    static {
        List<String> r100 = Arrays.asList(new String[]{"effect"});
        list = r100;
        b.a(r100);     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        th.printStackTrace();
    }

    public static void createHandle(long[] r100) {
        nativeCreateHandle(r100, 0);
    }

    public static int deleteTexture(int r100) {
        return nativeDeleteTexture(r100);
    }

    public static int destroy(long r100) {
        return nativeDestroy(r100);
    }

    public static void onPause(long r100) {
        nativeOnPause(r100);
    }

    public static void onResume(long r100) {
        nativeOnResume(r100);
    }

    public static int addMessageListener(long r100, NativeMessageListener r101) {
        return nativeAddMessageListener(r100, r101);
    }

    public static int attachEffect(long r100, long r101) {
        return nativeAttachEffect(r100, r101);
    }

    public static void createHandle(long[] r100, int r101) {
        nativeCreateHandle(r100, r101);
    }

    public static int removeMessageListener(long r100, NativeMessageListener r101) {
        return nativeRemoveMessageListener(r100, r101);
    }

    public static int setStickerPath(long r100, String r101) {
        return nativeSetStickerPath(r100, r101);
    }

    public static int init(long r100, int r101, int r102) {
        return nativeInit(r100, r101, r102);
    }

    public static int setRenderCacheData(long r100, String r101, String r102) {
        return nativeSetRenderCacheData(r100, r101, r102);
    }

    public static int setRenderCacheTexture(long r100, String r101, String r102) {
        return nativeSetRenderCacheTexture(r100, r101, r102);
    }

    public static int setResourceFinder(long r100, long r101, long r102) {
        return nativeSetResourceFinder(r100, r101, r102);
    }

    public static int touchBeginEvent(long r100, int[] r101, float[] r110, float[] r111) {
        return nativeTouchEvent(r100, 0, r101, r110, r111, r101.length);
    }

    public static int touchEndEvent(long r100, int[] r101, float[] r110, float[] r111) {
        return nativeTouchEvent(r100, 1, r101, r110, r111, r101.length);
    }

    public static int touchMoveEvent(long r100, int[] r101, float[] r110, float[] r111) {
        return nativeTouchEvent(r100, 2, r101, r110, r111, r101.length);
    }

    public static int createTexture(int r100, int r101, int r102, int r103, int r104) {
        return nativeCreateTexture(r100, r101, r102, r103, r104);
    }

    public static int postMessage(long r100, long r101, long r102, long r103, String r104) {
        return nativePostMessage(r100, r101, r102, r103, r104);
    }

    public static int setRenderCacheTextureWithBuffer(long r100, String r101, byte[] r102, int r103, int r104) {
        return nativeSetRenderCacheTextureWithBuffer(r100, r101, r102, r103, r104);
    }

    public static int touchBeginEvent(long r100, int[] r101, float[] r110, float[] r111, int r112) {
        return nativeTouchEvent(r100, 0, r101, r110, r111, r112);
    }

    public static int touchEndEvent(long r100, int[] r101, float[] r110, float[] r111, int r112) {
        return nativeTouchEvent(r100, 1, r101, r110, r111, r112);
    }

    public static int touchMoveEvent(long r100, int[] r101, float[] r110, float[] r111, int r112) {
        return nativeTouchEvent(r100, 2, r101, r110, r111, r112);
    }

    public static int processFrame(long r100, int r101, int r102, int r103, float[] r104, float[] r105, double r106) {
        return nativeProcess(r100, r101, r102, r103, r104, r105, r106);
    }
}
