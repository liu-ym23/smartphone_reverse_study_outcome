package net.jpountz.lz4;

import java.nio.ByteBuffer;
import net.jpountz.util.Native;

/* loaded from: classes5.dex */
enum LZ4JNI {
    ;

    static {
        Native.load();
        init();
    }

    public static native int LZ4_compressBound(int i10);

    public static native int LZ4_compressHC(byte[] bArr, ByteBuffer byteBuffer, int i10, int i11, byte[] bArr2, ByteBuffer byteBuffer2, int i12, int i13, int i14);

    public static native int LZ4_compress_limitedOutput(byte[] bArr, ByteBuffer byteBuffer, int i10, int i11, byte[] bArr2, ByteBuffer byteBuffer2, int i12, int i13);

    public static native int LZ4_decompress_fast(byte[] bArr, ByteBuffer byteBuffer, int i10, byte[] bArr2, ByteBuffer byteBuffer2, int i11, int i12);

    public static native int LZ4_decompress_safe(byte[] bArr, ByteBuffer byteBuffer, int i10, int i11, byte[] bArr2, ByteBuffer byteBuffer2, int i12, int i13);

    public static native void init();
}
