package com.google.crypto.tink.proto;

import com.google.crypto.tink.shaded.protobuf.Internal;
import g5.f;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public enum JwtEcdsaAlgorithm implements Internal.EnumLite {
    ES_UNKNOWN(0),
    ES256(1),
    ES384(2),
    ES512(3),
    UNRECOGNIZED(-1);

    public static final int ES256_VALUE = 1;
    public static final int ES384_VALUE = 2;
    public static final int ES512_VALUE = 3;
    public static final int ES_UNKNOWN_VALUE = 0;
    private static final Internal.EnumLiteMap<JwtEcdsaAlgorithm> internalValueMap = new Internal.EnumLiteMap<JwtEcdsaAlgorithm>() { // from class: com.google.crypto.tink.proto.JwtEcdsaAlgorithm.1
        @Override // com.google.crypto.tink.shaded.protobuf.Internal.EnumLiteMap
        public JwtEcdsaAlgorithm findValueByNumber(int i) {
            return JwtEcdsaAlgorithm.forNumber(i);
        }
    };
    private final int value;

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    public static final class JwtEcdsaAlgorithmVerifier implements Internal.EnumVerifier {
        static final Internal.EnumVerifier INSTANCE = new JwtEcdsaAlgorithmVerifier();

        private JwtEcdsaAlgorithmVerifier() {
        }

        @Override // com.google.crypto.tink.shaded.protobuf.Internal.EnumVerifier
        public boolean isInRange(int i) {
            return JwtEcdsaAlgorithm.forNumber(i) != null;
        }
    }

    JwtEcdsaAlgorithm(int i) {
        this.value = i;
    }

    public static JwtEcdsaAlgorithm forNumber(int i) {
        if (i == 0) {
            return ES_UNKNOWN;
        }
        if (i == 1) {
            return ES256;
        }
        if (i == 2) {
            return ES384;
        }
        if (i != 3) {
            return null;
        }
        return ES512;
    }

    public static Internal.EnumLiteMap<JwtEcdsaAlgorithm> internalGetValueMap() {
        return internalValueMap;
    }

    public static Internal.EnumVerifier internalGetVerifier() {
        return JwtEcdsaAlgorithmVerifier.INSTANCE;
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
    public static JwtEcdsaAlgorithm valueOf(int i) {
        return forNumber(i);
    }
}
