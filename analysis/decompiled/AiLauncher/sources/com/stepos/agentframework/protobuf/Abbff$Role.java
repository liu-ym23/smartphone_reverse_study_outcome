package com.stepos.agentframework.protobuf;

import com.google.protobuf.Internal;

/* loaded from: classes2.dex */
public enum Abbff$Role implements Internal.EnumLite {
    ROLE_UNSPECIFIED(0),
    USER(1),
    ASSISTANT(2),
    SYSTEM(3),
    TOOL(4),
    UNRECOGNIZED(-1);

    public static final int ASSISTANT_VALUE = 2;
    public static final int ROLE_UNSPECIFIED_VALUE = 0;
    public static final int SYSTEM_VALUE = 3;
    public static final int TOOL_VALUE = 4;
    public static final int USER_VALUE = 1;
    private static final Internal.EnumLiteMap<Abbff$Role> internalValueMap = new Internal.EnumLiteMap<Abbff$Role>() { // from class: com.stepos.agentframework.protobuf.Abbff$Role.a
        @Override // com.google.protobuf.Internal.EnumLiteMap
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Abbff$Role findValueByNumber(int i10) {
            return Abbff$Role.forNumber(i10);
        }
    };
    private final int value;

    public static final class b implements Internal.EnumVerifier {
        static final Internal.EnumVerifier INSTANCE = new b();

        @Override // com.google.protobuf.Internal.EnumVerifier
        public boolean isInRange(int i10) {
            return Abbff$Role.forNumber(i10) != null;
        }
    }

    Abbff$Role(int i10) {
        this.value = i10;
    }

    public static Abbff$Role forNumber(int i10) {
        if (i10 == 0) {
            return ROLE_UNSPECIFIED;
        }
        if (i10 == 1) {
            return USER;
        }
        if (i10 == 2) {
            return ASSISTANT;
        }
        if (i10 == 3) {
            return SYSTEM;
        }
        if (i10 != 4) {
            return null;
        }
        return TOOL;
    }

    public static Internal.EnumLiteMap<Abbff$Role> internalGetValueMap() {
        return internalValueMap;
    }

    public static Internal.EnumVerifier internalGetVerifier() {
        return b.INSTANCE;
    }

    @Override // com.google.protobuf.Internal.EnumLite
    public final int getNumber() {
        if (this != UNRECOGNIZED) {
            return this.value;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }

    @Deprecated
    public static Abbff$Role valueOf(int i10) {
        return forNumber(i10);
    }
}
