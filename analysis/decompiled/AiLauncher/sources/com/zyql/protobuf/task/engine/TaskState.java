package com.zyql.protobuf.task.engine;

import com.google.protobuf.Internal;

/* loaded from: classes4.dex */
public enum TaskState implements Internal.EnumLite {
    Running(0),
    Stop(1),
    Pending(2),
    Complete(3),
    Failed(4),
    Canceled(5),
    UNRECOGNIZED(-1);

    public static final int Canceled_VALUE = 5;
    public static final int Complete_VALUE = 3;
    public static final int Failed_VALUE = 4;
    public static final int Pending_VALUE = 2;
    public static final int Running_VALUE = 0;
    public static final int Stop_VALUE = 1;
    private static final Internal.EnumLiteMap<TaskState> internalValueMap = new Internal.EnumLiteMap<TaskState>() { // from class: com.zyql.protobuf.task.engine.TaskState.1
        @Override // com.google.protobuf.Internal.EnumLiteMap
        public TaskState findValueByNumber(int i10) {
            return TaskState.forNumber(i10);
        }
    };
    private final int value;

    public static final class TaskStateVerifier implements Internal.EnumVerifier {
        static final Internal.EnumVerifier INSTANCE = new TaskStateVerifier();

        private TaskStateVerifier() {
        }

        @Override // com.google.protobuf.Internal.EnumVerifier
        public boolean isInRange(int i10) {
            return TaskState.forNumber(i10) != null;
        }
    }

    TaskState(int i10) {
        this.value = i10;
    }

    public static TaskState forNumber(int i10) {
        if (i10 == 0) {
            return Running;
        }
        if (i10 == 1) {
            return Stop;
        }
        if (i10 == 2) {
            return Pending;
        }
        if (i10 == 3) {
            return Complete;
        }
        if (i10 == 4) {
            return Failed;
        }
        if (i10 != 5) {
            return null;
        }
        return Canceled;
    }

    public static Internal.EnumLiteMap<TaskState> internalGetValueMap() {
        return internalValueMap;
    }

    public static Internal.EnumVerifier internalGetVerifier() {
        return TaskStateVerifier.INSTANCE;
    }

    @Override // com.google.protobuf.Internal.EnumLite
    public final int getNumber() {
        if (this != UNRECOGNIZED) {
            return this.value;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }

    @Deprecated
    public static TaskState valueOf(int i10) {
        return forNumber(i10);
    }
}
