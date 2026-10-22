package com.bef.effectsdk.game;

import com.ss.android.tecommonenvinitializer.diagnosis.b;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes39.dex */
public class NativeInterface {
    private static final List<String> list = null;

    public interface NativeMessageListener {
        int nativeOnMsgReceived(long r100, long r101, long r102, String r103);
    }

    public NativeInterface() {
    }

    private static native int nativeAddMessageListener(long r100, NativeMessageListener r101);

    private static native void nativeCreateHandle(long[] r100);

    private static native int nativeDestroy(long r100);

    private static native int nativeInit(long r100, int r101, int r102);

    private static native int nativePause(long r100);

    private static native int nativePostMessage(long r100, long r101, long r102, long r103, String r104);

    private static native int nativeProcess(long r100, int r101, int r102, double r103);

    private static native int nativeRemoveMessageListener(long r100, NativeMessageListener r101);

    private static native int nativeResume(long r100);

    private static native int nativeSetSize(long r100, int r101, int r102);

    private static native int nativeSetStickerPath(long r100, String r101);

    private static native int nativeTouchesBegin(long r100, int[] r101, float[] r102, float[] r103);

    private static native int nativeTouchesEnd(long r100, int[] r101, float[] r102, float[] r103);

    private static native int nativeTouchesMove(long r100, int[] r101, float[] r102, float[] r103);

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
        nativeCreateHandle(r100);
    }

    public static int destroy(long r100) {
        return nativeDestroy(r100);
    }

    public static int pause(long r100) {
        return nativePause(r100);
    }

    public static int resume(long r100) {
        return nativeResume(r100);
    }

    public static int addMessageListener(long r100, NativeMessageListener r101) {
        return nativeAddMessageListener(r100, r101);
    }

    public static int removeMessageListener(long r100, NativeMessageListener r101) {
        return nativeRemoveMessageListener(r100, r101);
    }

    public static int setGameBundlePath(long r100, String r101) {
        return nativeSetStickerPath(r100, r101);
    }

    public static int init(long r100, int r101, int r102) {
        return nativeInit(r100, r101, r102);
    }

    public static int setSize(long r100, int r101, int r102) {
        return nativeSetSize(r100, r101, r102);
    }

    public static int processFrame(long r100, int r101, int r102, double r103) {
        return nativeProcess(r100, r101, r102, r103);
    }

    public static int touchesBegin(long r100, int[] r101, float[] r102, float[] r103) {
        return nativeTouchesBegin(r100, r101, r102, r103);
    }

    public static int touchesEnd(long r100, int[] r101, float[] r102, float[] r103) {
        return nativeTouchesEnd(r100, r101, r102, r103);
    }

    public static int touchesMove(long r100, int[] r101, float[] r102, float[] r103) {
        return nativeTouchesMove(r100, r101, r102, r103);
    }

    public static int postMessage(long r100, long r101, long r102, long r103, String r104) {
        return nativePostMessage(r100, r101, r102, r103, r104);
    }
}
