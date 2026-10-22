package com.google.android.libraries.barhopper;

import android.graphics.Bitmap;
import android.util.Log;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.C1758r0;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzer;
import f3.C4053a;
import java.io.Closeable;
import java.nio.ByteBuffer;
import z3.C6339a;

/* loaded from: classes2.dex */
public class BarhopperV3 implements Closeable {

    /* renamed from: b, reason: collision with root package name */
    public static final String f20199b = "BarhopperV3";

    /* renamed from: a, reason: collision with root package name */
    public long f20200a;

    public BarhopperV3() {
        System.loadLibrary("barhopper_v3");
    }

    private native void closeNative(long j10);

    private native long createNative();

    private native long createNativeWithClientOptions(byte[] bArr);

    public static C6339a l(byte[] bArr) {
        bArr.getClass();
        try {
            return C6339a.I(bArr, C1758r0.a());
        } catch (zzer e10) {
            throw new IllegalStateException("Received unexpected BarhopperResponse buffer: {0}", e10);
        }
    }

    private native byte[] recognizeBitmapNative(long j10, Bitmap bitmap, RecognitionOptions recognitionOptions);

    private native byte[] recognizeBufferNative(long j10, int i10, int i11, ByteBuffer byteBuffer, RecognitionOptions recognitionOptions);

    private native byte[] recognizeNative(long j10, int i10, int i11, byte[] bArr, RecognitionOptions recognitionOptions);

    private native byte[] recognizeStridedBufferNative(long j10, int i10, int i11, int i12, ByteBuffer byteBuffer, RecognitionOptions recognitionOptions);

    private native byte[] recognizeStridedNative(long j10, int i10, int i11, int i12, byte[] bArr, RecognitionOptions recognitionOptions);

    public void b(C4053a c4053a) {
        if (this.f20200a != 0) {
            Log.w(f20199b, "Native pointer already exists.");
            return;
        }
        long jCreateNativeWithClientOptions = createNativeWithClientOptions(c4053a.c());
        this.f20200a = jCreateNativeWithClientOptions;
        if (jCreateNativeWithClientOptions == 0) {
            throw new IllegalArgumentException("Failed to create native pointer with client options.");
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        long j10 = this.f20200a;
        if (j10 != 0) {
            closeNative(j10);
            this.f20200a = 0L;
        }
    }

    public C6339a e(int i10, int i11, ByteBuffer byteBuffer, RecognitionOptions recognitionOptions) {
        long j10 = this.f20200a;
        if (j10 != 0) {
            return l(recognizeBufferNative(j10, i10, i11, byteBuffer, recognitionOptions));
        }
        throw new IllegalStateException("Native pointer does not exist.");
    }

    public C6339a g(int i10, int i11, byte[] bArr, RecognitionOptions recognitionOptions) {
        long j10 = this.f20200a;
        if (j10 != 0) {
            return l(recognizeNative(j10, i10, i11, bArr, recognitionOptions));
        }
        throw new IllegalStateException("Native pointer does not exist.");
    }

    public C6339a i(Bitmap bitmap, RecognitionOptions recognitionOptions) {
        if (this.f20200a == 0) {
            throw new IllegalStateException("Native pointer does not exist.");
        }
        Bitmap.Config config = bitmap.getConfig();
        Bitmap.Config config2 = Bitmap.Config.ARGB_8888;
        if (config != config2) {
            Log.d(f20199b, "Input bitmap config is not ARGB_8888. Converting it to ARGB_8888 from ".concat(String.valueOf(bitmap.getConfig())));
            bitmap = bitmap.copy(config2, bitmap.isMutable());
        }
        return l(recognizeBitmapNative(this.f20200a, bitmap, recognitionOptions));
    }
}
