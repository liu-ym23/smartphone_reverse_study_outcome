package com.stepos.agentcache.sdk.utils;

import kotlin.Metadata;
import q7.f;
import q7.k;
import t7.a;
import t7.d;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\u0018\u0000 \u00042\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/stepos/agentcache/sdk/utils/ULID;", "", "<init>", "()V", "Companion", "sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class ULID {
    private static final int DEFAULT_ENTROPY_SIZE = 10;
    public static final long TIMESTAMP_MAX = 281474976710655L;
    public static final long TIMESTAMP_MIN = 0;
    private static final int ULID_LENGTH = 26;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final char[] charMapping = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'J', 'K', 'M', 'N', 'P', 'Q', 'R', 'S', 'T', 'V', 'W', 'X', 'Y', 'Z'};
    private static final byte[] charToByteMapping = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, -1, -1, -1, -1, -1, -1, -1, 10, 11, 12, 13, 14, 15, 16, 17, -1, 18, 19, -1, 20, 21, -1, 22, 23, 24, 25, 26, -1, 27, 28, 29, 30, 31, -1, -1, -1, -1, -1, -1, 10, 11, 12, 13, 14, 15, 16, 17, -1, 18, 19, -1, 20, 21, -1, 22, 23, 24, 25, 26, -1, 27, 28, 29, 30, 31, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};

    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0019\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000fJ\u0006\u0010\u0011\u001a\u00020\u000fJ\u0018\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u00072\b\u0010\u0014\u001a\u0004\u0018\u00010\rJ\u0010\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u000fJ\u000e\u0010\u0018\u001a\u00020\u00072\u0006\u0010\u0017\u001a\u00020\u0019J\u000e\u0010\u001a\u001a\u00020\r2\u0006\u0010\u0017\u001a\u00020\u0019R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcom/stepos/agentcache/sdk/utils/ULID$Companion;", "", "<init>", "()V", "DEFAULT_ENTROPY_SIZE", "", "TIMESTAMP_MAX", "", "TIMESTAMP_MIN", "ULID_LENGTH", "charMapping", "", "charToByteMapping", "", "fromString", "", "string", "random", "generate", "time", "entropy", "isValid", "", "ulid", "getTimestamp", "", "getEntropy", "sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(f fVar) {
            this();
        }

        public final String fromString(String string) {
            k.e(string, "string");
            if (isValid(string)) {
                return string;
            }
            throw new IllegalArgumentException("Invalid string value for an ulid");
        }

        public final String generate(long time, byte[] entropy) {
            if (time < 0 || time > ULID.TIMESTAMP_MAX || entropy == null || entropy.length < 10) {
                throw new IllegalArgumentException("Time is too long, or entropy is less than 10 bytes or null");
            }
            return new String(new char[]{ULID.charMapping[((int) (time >>> 45)) & 31], ULID.charMapping[((int) (time >>> 40)) & 31], ULID.charMapping[((int) (time >>> 35)) & 31], ULID.charMapping[((int) (time >>> 30)) & 31], ULID.charMapping[((int) (time >>> 25)) & 31], ULID.charMapping[((int) (time >>> 20)) & 31], ULID.charMapping[((int) (time >>> 15)) & 31], ULID.charMapping[((int) (time >>> 10)) & 31], ULID.charMapping[((int) (time >>> 5)) & 31], ULID.charMapping[((int) time) & 31], ULID.charMapping[((short) (entropy[0] & 255)) >>> 3], ULID.charMapping[((entropy[0] << 2) | (((short) (entropy[1] & 255)) >>> 6)) & 31], ULID.charMapping[(((short) (entropy[1] & 255)) >>> 1) & 31], ULID.charMapping[((entropy[1] << 4) | (((short) (entropy[2] & 255)) >>> 4)) & 31], ULID.charMapping[((entropy[2] << 5) | (((short) (entropy[3] & 255)) >>> 7)) & 31], ULID.charMapping[(((short) (entropy[3] & 255)) >>> 2) & 31], ULID.charMapping[((entropy[3] << 3) | (((short) (entropy[4] & 255)) >>> 5)) & 31], ULID.charMapping[entropy[4] & 31], ULID.charMapping[((short) (entropy[5] & 255)) >>> 3], ULID.charMapping[((entropy[5] << 2) | (((short) (entropy[6] & 255)) >>> 6)) & 31], ULID.charMapping[(((short) (entropy[6] & 255)) >>> 1) & 31], ULID.charMapping[((entropy[6] << 4) | (((short) (entropy[7] & 255)) >>> 4)) & 31], ULID.charMapping[((entropy[7] << 5) | (((short) (entropy[8] & 255)) >>> 7)) & 31], ULID.charMapping[(((short) (entropy[8] & 255)) >>> 2) & 31], ULID.charMapping[((entropy[8] << 3) | (((short) (entropy[9] & 255)) >>> 5)) & 31], ULID.charMapping[entropy[9] & 31]});
        }

        public final byte[] getEntropy(CharSequence ulid) {
            k.e(ulid, "ulid");
            return new byte[]{(byte) ((ULID.charToByteMapping[ulid.charAt(10)] << 3) | (ULID.charToByteMapping[ulid.charAt(11)] >>> 2)), (byte) ((ULID.charToByteMapping[ulid.charAt(11)] << 6) | (ULID.charToByteMapping[ulid.charAt(12)] << 1) | (ULID.charToByteMapping[ulid.charAt(13)] >>> 4)), (byte) ((ULID.charToByteMapping[ulid.charAt(13)] << 4) | (ULID.charToByteMapping[ulid.charAt(14)] >>> 1)), (byte) ((ULID.charToByteMapping[ulid.charAt(14)] << 7) | (ULID.charToByteMapping[ulid.charAt(15)] << 2) | (ULID.charToByteMapping[ulid.charAt(16)] >>> 3)), (byte) ((ULID.charToByteMapping[ulid.charAt(16)] << 5) | ULID.charToByteMapping[ulid.charAt(17)]), (byte) ((ULID.charToByteMapping[ulid.charAt(18)] << 3) | (ULID.charToByteMapping[ulid.charAt(19)] >>> 2)), (byte) ((ULID.charToByteMapping[ulid.charAt(19)] << 6) | (ULID.charToByteMapping[ulid.charAt(20)] << 1) | (ULID.charToByteMapping[ulid.charAt(21)] >>> 4)), (byte) ((ULID.charToByteMapping[ulid.charAt(21)] << 4) | (ULID.charToByteMapping[ulid.charAt(22)] >>> 1)), (byte) ((ULID.charToByteMapping[ulid.charAt(22)] << 7) | (ULID.charToByteMapping[ulid.charAt(23)] << 2) | (ULID.charToByteMapping[ulid.charAt(24)] >>> 3)), (byte) (ULID.charToByteMapping[ulid.charAt(25)] | (ULID.charToByteMapping[ulid.charAt(24)] << 5))};
        }

        public final long getTimestamp(CharSequence ulid) {
            k.e(ulid, "ulid");
            return ULID.charToByteMapping[ulid.charAt(9)] | (ULID.charToByteMapping[ulid.charAt(0)] << 45) | (ULID.charToByteMapping[ulid.charAt(1)] << 40) | (ULID.charToByteMapping[ulid.charAt(2)] << 35) | (ULID.charToByteMapping[ulid.charAt(3)] << 30) | (ULID.charToByteMapping[ulid.charAt(4)] << 25) | (ULID.charToByteMapping[ulid.charAt(5)] << 20) | (ULID.charToByteMapping[ulid.charAt(6)] << 15) | (ULID.charToByteMapping[ulid.charAt(7)] << 10) | (ULID.charToByteMapping[ulid.charAt(8)] << 5);
        }

        public final boolean isValid(String ulid) {
            if (ulid == null || ulid.length() != ULID.ULID_LENGTH) {
                return false;
            }
            for (int i2 = 0; i2 < ulid.length(); i2++) {
                char cCharAt = ulid.charAt(i2);
                if (cCharAt < 0 || cCharAt > ULID.charToByteMapping.length || ULID.charToByteMapping[cCharAt] == -1) {
                    return false;
                }
            }
            return true;
        }

        public final String random() {
            long jCurrentTimeMillis = System.currentTimeMillis();
            a aVar = d.f9771f;
            a aVar2 = d.f9771f;
            aVar2.getClass();
            byte[] bArr = new byte[10];
            aVar2.a().nextBytes(bArr);
            return generate(jCurrentTimeMillis, bArr);
        }

        private Companion() {
        }
    }
}
