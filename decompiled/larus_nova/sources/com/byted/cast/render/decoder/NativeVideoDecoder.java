package com.byted.cast.render.decoder;

import com.byted.cast.mediacommon.render.MediaRenderState;
import com.byted.cast.mediacommon.render.parameters.CodecId;
import com.bytedance.librarian.a;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public class NativeVideoDecoder implements IMediaDecoder {
    private final CodecId codecId;
    private long ffmpegDecoder;
    private boolean isRunning;
    private IMediaDecoderListener listener;
    private MediaRenderState state;
    private final String userId;

    public static /* synthetic */ void access$000(String r100) {
        System.loadLibrary(r100);
    }

    private native void nativeSendPacket(long r100, byte[] r101, int r102, long r103);

    private native long nativeStart();

    private native boolean nativeStop(long r100);

    @Override // com.byted.cast.render.decoder.IMediaDecoder
    public boolean stop() {
        this.isRunning = false;
        if (nativeStop(this.ffmpegDecoder) == false) goto L6;
        this.state = MediaRenderState.STATE_UNINITIALIZED;
        this.ffmpegDecoder = 0;
        return true;
    L6:
        return false;
    }

    @Override // com.byted.cast.render.decoder.IMediaDecoder
    public boolean start() {
        INVOKESTATIC_com_byted_cast_render_decoder_NativeVideoDecoder_com_larus_home_impl_utils_SystemLoadLibraryHook_loadLibrary("MediaRenderJni");     // Catch: Exception -> L5
        this.ffmpegDecoder = nativeStart();
        this.state = MediaRenderState.STATE_EXECUTING;
        this.isRunning = true;
        return true;
    L5:
        e = move-exception;
        e.printStackTrace();
        return false;
    }

    @Override // com.byted.cast.render.decoder.IMediaDecoder
    public MediaRenderState getState() {
        return this.state;
    }

    @JvmStatic
    public static void INVOKESTATIC_com_byted_cast_render_decoder_NativeVideoDecoder_com_larus_home_impl_utils_SystemLoadLibraryHook_loadLibrary(String r100) {
        Intrinsics.checkNotNullParameter(r100, "libName");
        FLogger r101 = FLogger.f375446a;
        r101.i("Librarian_loadLib", "loadLibrary start libName -> " + r100);
        a.c(r100);
        r101.i("Librarian_loadLib", "loadLibrary success by librarian -> " + r100);
    }

    @Override // com.byted.cast.render.decoder.IMediaDecoder
    public void setMediaDecoderListener(IMediaDecoderListener r100) {
        this.listener = r100;
    }

    public NativeVideoDecoder(String r100, CodecId r101) {
        this.state = MediaRenderState.STATE_UNINITIALIZED;
        this.ffmpegDecoder = 0;
        this.isRunning = false;
        this.userId = r100;
        this.codecId = r101;
    }

    public void OnAVFrameAvailable(byte[] r100, long r101) {
        IMediaDecoderListener r102 = this.listener;
        if (r102 == null) goto L6;
        r102.OnAVFrameAvailable(r100, r101);
        return;
    }

    @Override // com.byted.cast.render.decoder.IMediaDecoder
    public boolean sendPacket(byte[] r100, long r101) {
        if (this.isRunning == true) goto L6;
        return false;
    L6:
        long r102 = this.ffmpegDecoder;
        if (r102 == 0) goto L11;
        nativeSendPacket(r102, r100, r100.length, r101);
        return true;
    L11:
        return true;
    }

    public void OnVideoSizeChanged(int r100, int r101, int r102, int r110) {
        IMediaDecoderListener r103 = this.listener;
        if (r103 == null) goto L6;
        r103.OnVideoSizeChanged(r100, r101, r102, r101, r110);
        return;
    }
}
