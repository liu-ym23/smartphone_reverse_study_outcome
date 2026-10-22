package org.tensorflow.lite;

/* JADX INFO: loaded from: classes5.dex */
final class NativeSignatureRunnerWrapper {
    private static native void nativeAllocateTensors(long r0, long r2);

    private static native int nativeGetInputIndex(long r0, String r2);

    private static native int nativeGetOutputIndex(long r0, String r2);

    private static native long nativeGetSignatureRunner(long r0, String r2);

    private static native int nativeGetSubgraphIndex(long r0);

    private static native String[] nativeInputNames(long r0);

    private static native void nativeInvoke(long r0, long r2);

    private static native String[] nativeOutputNames(long r0);

    private static native boolean nativeResizeInput(long r0, long r2, String r4, int[] r5);
}
