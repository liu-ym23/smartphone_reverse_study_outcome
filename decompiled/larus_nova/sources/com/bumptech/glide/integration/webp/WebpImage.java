package com.bumptech.glide.integration.webp;

import com.bumptech.glide.util.Preconditions;
import com.larus.utils.logger.FLogger;
import java.nio.ByteBuffer;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes39.dex */
public class WebpImage {
    private int mBackgroundColor;
    private int mDurationMs;
    private int mFrameCount;
    private int[] mFrameDurations;
    private int mHeigth;
    private int mLoopCount;
    private long mNativePtr;
    private int mWidth;

    public static /* synthetic */ void a(WebpImage r100) {
        r100.nativeFinalize();
    }

    public static /* synthetic */ void access$000(String r100) {
        System.loadLibrary(r100);
    }

    private static native WebpImage nativeCreateFromDirectByteBuffer(ByteBuffer r100);

    private native void nativeDispose();

    private native void nativeFinalize();

    private native WebpFrame nativeGetFrame(int r100);

    private native int nativeGetSizeInBytes();

    static {
        INVOKESTATIC_com_bumptech_glide_integration_webp_WebpImage_com_larus_home_impl_utils_SystemLoadLibraryHook_loadLibrary("glide-webp");
    }

    public void finalize() throws Throwable {
        super.finalize();
        WebpThread.execute(new c(this));
    }

    public int getSizeInBytes() {
        return nativeGetSizeInBytes();
    }

    public void dispose() {
        nativeDispose();
    }

    public int getBackgroundColor() {
        return this.mBackgroundColor;
    }

    public int getDuration() {
        return this.mDurationMs;
    }

    public int getFrameCount() {
        return this.mFrameCount;
    }

    public int[] getFrameDurations() {
        return this.mFrameDurations;
    }

    public int getHeight() {
        return this.mHeigth;
    }

    public int getLoopCount() {
        return this.mLoopCount;
    }

    public int getWidth() {
        return this.mWidth;
    }

    @JvmStatic
    public static void INVOKESTATIC_com_bumptech_glide_integration_webp_WebpImage_com_larus_home_impl_utils_SystemLoadLibraryHook_loadLibrary(String r100) {
        Intrinsics.checkNotNullParameter(r100, "libName");
        FLogger r101 = FLogger.f375446a;
        r101.i("Librarian_loadLib", "loadLibrary start libName -> " + r100);
        com.bytedance.librarian.a.c(r100);
        r101.i("Librarian_loadLib", "loadLibrary success by librarian -> " + r100);
    }

    public static WebpImage create(byte[] r100) {
        Preconditions.checkNotNull(r100);
        ByteBuffer r101 = ByteBuffer.allocateDirect(r100.length);
        r101.put(r100);
        r101.rewind();
        return nativeCreateFromDirectByteBuffer(r101);
    }

    private void fixFrameDurations(int[] r100) {
        int r101 = 0;
    L4:
        if (r101 >= r100.length) goto L9;
        if (r100[r101] >= 11) goto L8;
        r100[r101] = 100;
    L8:
        r101 = r101 + 1;
        goto L4
    }

    public WebpFrame getFrame(int r100) {
        return nativeGetFrame(r100);
    }

    public WebpFrameInfo getFrameInfo(int r100) {
        WebpFrame r101 = getFrame(r100);
        WebpFrameInfo r102 = new WebpFrameInfo(r100, r101);     // Catch: Throwable -> L6
        r101.dispose();
        return r102;
    L6:
        th = move-exception;
        r101.dispose();
        throw th;
    }

    public WebpImage(long r100, int r101, int r102, int r103, int r104, int[] r110, int r111, int r112) {
        if (r100 == 0) goto L7;
        this.mWidth = r101;
        this.mHeigth = r102;
        this.mFrameCount = r103;
        this.mDurationMs = r104;
        this.mFrameDurations = r110;
        this.mLoopCount = r111;
        fixFrameDurations(r110);
        this.mBackgroundColor = r112;
        this.mNativePtr = r100;
        return;
    L7:
        throw new RuntimeException("internal error: native WebpImage is 0");
    }
}
