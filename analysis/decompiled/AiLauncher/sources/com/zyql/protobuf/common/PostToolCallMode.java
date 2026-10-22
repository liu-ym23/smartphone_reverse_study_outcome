package com.zyql.protobuf.common;

import com.google.protobuf.Internal;

/* loaded from: classes4.dex */
public enum PostToolCallMode implements Internal.EnumLite {
    POST_TOOL_CALL_MODE_UNSPECIFIED(0),
    POST_TOOL_CALL_MODE_IGNORE(1),
    POST_TOOL_CALL_MODE_BLOCK(2),
    UNRECOGNIZED(-1);

    public static final int POST_TOOL_CALL_MODE_BLOCK_VALUE = 2;
    public static final int POST_TOOL_CALL_MODE_IGNORE_VALUE = 1;
    public static final int POST_TOOL_CALL_MODE_UNSPECIFIED_VALUE = 0;
    private static final Internal.EnumLiteMap<PostToolCallMode> internalValueMap = new Internal.EnumLiteMap<PostToolCallMode>() { // from class: com.zyql.protobuf.common.PostToolCallMode.1
        @Override // com.google.protobuf.Internal.EnumLiteMap
        public PostToolCallMode findValueByNumber(int i10) {
            return PostToolCallMode.forNumber(i10);
        }
    };
    private final int value;

    public static final class PostToolCallModeVerifier implements Internal.EnumVerifier {
        static final Internal.EnumVerifier INSTANCE = new PostToolCallModeVerifier();

        private PostToolCallModeVerifier() {
        }

        @Override // com.google.protobuf.Internal.EnumVerifier
        public boolean isInRange(int i10) {
            return PostToolCallMode.forNumber(i10) != null;
        }
    }

    PostToolCallMode(int i10) {
        this.value = i10;
    }

    public static PostToolCallMode forNumber(int i10) {
        if (i10 == 0) {
            return POST_TOOL_CALL_MODE_UNSPECIFIED;
        }
        if (i10 == 1) {
            return POST_TOOL_CALL_MODE_IGNORE;
        }
        if (i10 != 2) {
            return null;
        }
        return POST_TOOL_CALL_MODE_BLOCK;
    }

    public static Internal.EnumLiteMap<PostToolCallMode> internalGetValueMap() {
        return internalValueMap;
    }

    public static Internal.EnumVerifier internalGetVerifier() {
        return PostToolCallModeVerifier.INSTANCE;
    }

    @Override // com.google.protobuf.Internal.EnumLite
    public final int getNumber() {
        if (this != UNRECOGNIZED) {
            return this.value;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }

    @Deprecated
    public static PostToolCallMode valueOf(int i10) {
        return forNumber(i10);
    }
}
