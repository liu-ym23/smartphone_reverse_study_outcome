package androidx.emoji2.text.flatbuffer;

import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes17.dex */
public class ByteBufferUtil {
    public ByteBufferUtil() {
    }

    public static int getSizePrefix(ByteBuffer r100) {
        return r100.getInt(r100.position());
    }

    public static ByteBuffer removeSizePrefix(ByteBuffer r100) {
        ByteBuffer r101 = r100.duplicate();
        r101.position(r101.position() + 4);
        return r101;
    }
}
