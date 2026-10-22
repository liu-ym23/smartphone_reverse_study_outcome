package com.zyql.protobuf.common;

import com.google.protobuf.Internal;

/* loaded from: classes4.dex */
public enum HookLayer implements Internal.EnumLite {
    HOOK_LAYER_UNSPECIFIED(0),
    HOOK_LAYER_APP(1),
    HOOK_LAYER_AGENT(2),
    UNRECOGNIZED(-1);

    public static final int HOOK_LAYER_AGENT_VALUE = 2;
    public static final int HOOK_LAYER_APP_VALUE = 1;
    public static final int HOOK_LAYER_UNSPECIFIED_VALUE = 0;
    private static final Internal.EnumLiteMap<HookLayer> internalValueMap = new Internal.EnumLiteMap<HookLayer>() { // from class: com.zyql.protobuf.common.HookLayer.1
        @Override // com.google.protobuf.Internal.EnumLiteMap
        public HookLayer findValueByNumber(int i10) {
            return HookLayer.forNumber(i10);
        }
    };
    private final int value;

    public static final class HookLayerVerifier implements Internal.EnumVerifier {
        static final Internal.EnumVerifier INSTANCE = new HookLayerVerifier();

        private HookLayerVerifier() {
        }

        @Override // com.google.protobuf.Internal.EnumVerifier
        public boolean isInRange(int i10) {
            return HookLayer.forNumber(i10) != null;
        }
    }

    HookLayer(int i10) {
        this.value = i10;
    }

    public static HookLayer forNumber(int i10) {
        if (i10 == 0) {
            return HOOK_LAYER_UNSPECIFIED;
        }
        if (i10 == 1) {
            return HOOK_LAYER_APP;
        }
        if (i10 != 2) {
            return null;
        }
        return HOOK_LAYER_AGENT;
    }

    public static Internal.EnumLiteMap<HookLayer> internalGetValueMap() {
        return internalValueMap;
    }

    public static Internal.EnumVerifier internalGetVerifier() {
        return HookLayerVerifier.INSTANCE;
    }

    @Override // com.google.protobuf.Internal.EnumLite
    public final int getNumber() {
        if (this != UNRECOGNIZED) {
            return this.value;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }

    @Deprecated
    public static HookLayer valueOf(int i10) {
        return forNumber(i10);
    }
}
