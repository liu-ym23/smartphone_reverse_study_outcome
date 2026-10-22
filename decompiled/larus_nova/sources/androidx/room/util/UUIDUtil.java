package androidx.room.util;

import java.nio.ByteBuffer;
import java.util.UUID;

/* JADX INFO: loaded from: classes17.dex */
public final class UUIDUtil {
    private UUIDUtil() {
    }

    public static UUID convertByteToUUID(byte[] r100) {
        ByteBuffer r101 = ByteBuffer.wrap(r100);
        return new UUID(r101.getLong(), r101.getLong());
    }

    public static byte[] convertUUIDToByte(UUID r100) {
        ByteBuffer r101 = ByteBuffer.wrap(new byte[16]);
        r101.putLong(r100.getMostSignificantBits());
        r101.putLong(r100.getLeastSignificantBits());
        return r101.array();
    }
}
