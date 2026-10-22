package kotlin.reflect.jvm.internal.impl.protobuf;

import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes4.dex */
public class Internal {
    public static final byte[] EMPTY_BYTE_ARRAY = null;
    public static final ByteBuffer EMPTY_BYTE_BUFFER = null;

    public interface EnumLite {
        int getNumber();
    }

    public interface EnumLiteMap<T extends EnumLite> {
        T findValueByNumber(int r1);
    }

    public static boolean isValidUtf8(byte[] r0) {
        return Utf8.isValidUtf8(r0);
    }

    public static String toStringUtf8(byte[] r2) {
        return new String(r2, "UTF-8");
    L4:
        e = move-exception;
        throw new RuntimeException("UTF-8 not supported?", e);
    }

    static {
        byte[] r0 = new byte[0];
        EMPTY_BYTE_ARRAY = r0;
        EMPTY_BYTE_BUFFER = ByteBuffer.wrap(r0);
    }
}
