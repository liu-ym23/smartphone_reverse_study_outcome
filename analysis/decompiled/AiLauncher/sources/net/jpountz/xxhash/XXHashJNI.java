package net.jpountz.xxhash;

import java.nio.ByteBuffer;
import net.jpountz.util.Native;

/* loaded from: classes5.dex */
enum XXHashJNI {
    ;

    static {
        Native.load();
        init();
    }

    public static native int XXH32(byte[] bArr, int i10, int i11, int i12);

    public static native int XXH32BB(ByteBuffer byteBuffer, int i10, int i11, int i12);

    public static native int XXH32_digest(long j10);

    public static native void XXH32_free(long j10);

    public static native long XXH32_init(int i10);

    public static native void XXH32_update(long j10, byte[] bArr, int i10, int i11);

    public static native long XXH64(byte[] bArr, int i10, int i11, long j10);

    public static native long XXH64BB(ByteBuffer byteBuffer, int i10, int i11, long j10);

    public static native long XXH64_digest(long j10);

    public static native void XXH64_free(long j10);

    public static native long XXH64_init(long j10);

    public static native void XXH64_update(long j10, byte[] bArr, int i10, int i11);

    private static native void init();
}
