package com.android.server.am;

/* JADX INFO: loaded from: classes.dex */
public class FreezeErrorData {
    public final String msg;
    public final int pid;
    public final String processName;
    public final ErrorType type;
    public final int uid;

    public static final enum ErrorType extends Enum<ErrorType> {
        private static final /* synthetic */ ErrorType[] $VALUES = null;
        public static final ErrorType APP_NOT_RESPONDING = null;
        public static final ErrorType BROADCAST_NOT_RESPOND = null;
        public static final ErrorType INPUT_ANR = null;
        public static final ErrorType SYNC_BINDER_UNFREEZE_TIMEOUT = null;
        public static final ErrorType UNFREEZE_UID_PID_NOT_MATCH = null;
        private final int value;

        private static /* synthetic */ ErrorType[] $values() {
            return new ErrorType[]{UNFREEZE_UID_PID_NOT_MATCH, BROADCAST_NOT_RESPOND, INPUT_ANR, APP_NOT_RESPONDING, SYNC_BINDER_UNFREEZE_TIMEOUT};
        }

        public static ErrorType valueOf(String name) {
            return (ErrorType) Enum.valueOf(ErrorType.class, name);
        }

        public static ErrorType[] values() {
            return (ErrorType[]) $VALUES.clone();
        }

        static {
            UNFREEZE_UID_PID_NOT_MATCH = new ErrorType("UNFREEZE_UID_PID_NOT_MATCH", 0, 1);
            BROADCAST_NOT_RESPOND = new ErrorType("BROADCAST_NOT_RESPOND", 1, 2);
            INPUT_ANR = new ErrorType("INPUT_ANR", 2, 3);
            APP_NOT_RESPONDING = new ErrorType("APP_NOT_RESPONDING", 3, 4);
            SYNC_BINDER_UNFREEZE_TIMEOUT = new ErrorType("SYNC_BINDER_UNFREEZE_TIMEOUT", 4, 5);
            $VALUES = $values();
        }

        private ErrorType(String r1, int r2, int v) {
            super(r1, r2);
            this.value = v;
        }

        public int getValue() {
            return this.value;
        }
    }

    public FreezeErrorData(ErrorType type, int uid, int pid, String processName, String msg) {
        this.type = type;
        this.uid = uid;
        this.pid = pid;
        this.processName = processName;
        this.msg = msg;
    }

    public String toString() {
        return "FreezeErrorData [type=" + this.type + ", uid=" + this.uid + ", pid=" + this.pid + ", processName=" + this.processName + ", msg=" + this.msg + "]";
    }
}
