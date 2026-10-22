package com.google.crypto.tink.proto;

import com.google.crypto.tink.shaded.protobuf.Internal;
import g5.f;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public enum JwtHmacAlgorithm implements Internal.EnumLite {
    HS_UNKNOWN(0),
    HS256(1),
    HS384(2),
    HS512(3),
    UNRECOGNIZED(-1);

    public static final int HS256_VALUE = 1;
    public static final int HS384_VALUE = 2;
    public static final int HS512_VALUE = 3;
    public static final int HS_UNKNOWN_VALUE = 0;
    private static final Internal.EnumLiteMap<JwtHmacAlgorithm> internalValueMap = new Internal.EnumLiteMap<JwtHmacAlgorithm>() { // from class: com.google.crypto.tink.proto.JwtHmacAlgorithm.1
        @Override // com.google.crypto.tink.shaded.protobuf.Internal.EnumLiteMap
        public JwtHmacAlgorithm findValueByNumber(int i) {
            return JwtHmacAlgorithm.forNumber(i);
        }
    };
    private final int value;

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    public static final class JwtHmacAlgorithmVerifier implements Internal.EnumVerifier {
        static final Internal.EnumVerifier INSTANCE = new JwtHmacAlgorithmVerifier();

        private JwtHmacAlgorithmVerifier() {
        }

        @Override // com.google.crypto.tink.shaded.protobuf.Internal.EnumVerifier
        public boolean isInRange(int i) {
            return JwtHmacAlgorithm.forNumber(i) != null;
        }
    }

    JwtHmacAlgorithm(int i) {
        this.value = i;
    }

    public static JwtHmacAlgorithm forNumber(int i) {
        if (i == 0) {
            return HS_UNKNOWN;
        }
        if (i == 1) {
            return HS256;
        }
        if (i == 2) {
            return HS384;
        }
        if (i != 3) {
            return null;
        }
        return HS512;
    }

    public static Internal.EnumLiteMap<JwtHmacAlgorithm> internalGetValueMap() {
        return internalValueMap;
    }

    public static Internal.EnumVerifier internalGetVerifier() {
        return JwtHmacAlgorithmVerifier.INSTANCE;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Internal.EnumLite
    public final int getNumber() {
        if (this != UNRECOGNIZED) {
            return this.value;
        }
        f.s("Can't get the number of an unknown enum value.");
        return 0;
    }

    @Deprecated
    public static JwtHmacAlgorithm valueOf(int i) {
        return forNumber(i);
    }
}
