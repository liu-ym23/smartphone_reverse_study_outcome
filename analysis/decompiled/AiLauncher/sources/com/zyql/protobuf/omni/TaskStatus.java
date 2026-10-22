package com.zyql.protobuf.omni;

import com.google.protobuf.Internal;

/* loaded from: classes4.dex */
public enum TaskStatus implements Internal.EnumLite {
    UNKNOWN(0),
    PROGRESS(1),
    COMPLETED(2),
    FAILED(3),
    CANCELLED(4),
    PAUSED(5),
    ASK_FOR_INPUT(6),
    AUTHENTICATION(7),
    UNRECOGNIZED(-1);

    public static final int ASK_FOR_INPUT_VALUE = 6;
    public static final int AUTHENTICATION_VALUE = 7;
    public static final int CANCELLED_VALUE = 4;
    public static final int COMPLETED_VALUE = 2;
    public static final int FAILED_VALUE = 3;
    public static final int PAUSED_VALUE = 5;
    public static final int PROGRESS_VALUE = 1;
    public static final int UNKNOWN_VALUE = 0;
    private static final Internal.EnumLiteMap<TaskStatus> internalValueMap = new Internal.EnumLiteMap<TaskStatus>() { // from class: com.zyql.protobuf.omni.TaskStatus.1
        @Override // com.google.protobuf.Internal.EnumLiteMap
        public TaskStatus findValueByNumber(int i10) {
            return TaskStatus.forNumber(i10);
        }
    };
    private final int value;

    public static final class TaskStatusVerifier implements Internal.EnumVerifier {
        static final Internal.EnumVerifier INSTANCE = new TaskStatusVerifier();

        private TaskStatusVerifier() {
        }

        @Override // com.google.protobuf.Internal.EnumVerifier
        public boolean isInRange(int i10) {
            return TaskStatus.forNumber(i10) != null;
        }
    }

    TaskStatus(int i10) {
        this.value = i10;
    }

    public static TaskStatus forNumber(int i10) {
        switch (i10) {
            case 0:
                return UNKNOWN;
            case 1:
                return PROGRESS;
            case 2:
                return COMPLETED;
            case 3:
                return FAILED;
            case 4:
                return CANCELLED;
            case 5:
                return PAUSED;
            case 6:
                return ASK_FOR_INPUT;
            case 7:
                return AUTHENTICATION;
            default:
                return null;
        }
    }

    public static Internal.EnumLiteMap<TaskStatus> internalGetValueMap() {
        return internalValueMap;
    }

    public static Internal.EnumVerifier internalGetVerifier() {
        return TaskStatusVerifier.INSTANCE;
    }

    @Override // com.google.protobuf.Internal.EnumLite
    public final int getNumber() {
        if (this != UNRECOGNIZED) {
            return this.value;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }

    @Deprecated
    public static TaskStatus valueOf(int i10) {
        return forNumber(i10);
    }
}
