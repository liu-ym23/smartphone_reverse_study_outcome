package com.bytedance.shadowhook;

/* JADX INFO: loaded from: classes.dex */
public final class ShadowHook {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f8083a = 0;

    public interface ILibLoader {
        void loadLibrary(String r10);
    }

    public static final enum Mode extends Enum<Mode> {
        private static final /* synthetic */ Mode[] $VALUES = null;
        public static final Mode SHARED = null;
        public static final Mode UNIQUE = null;
        private final int value;

        static {
            Mode r10 = new Mode("SHARED", 0, 0);
            SHARED = r10;
            Mode r11 = new Mode("UNIQUE", 1, 1);
            UNIQUE = r11;
            $VALUES = new Mode[]{r10, r11};
        }

        private Mode(String r10, int r11, int r12) {
            super(r10, r11);
            this.value = r12;
        }

        public static Mode valueOf(String r10) {
            return (Mode) Enum.valueOf(Mode.class, r10);
        }

        public static Mode[] values() {
            return (Mode[]) $VALUES.clone();
        }

        public int getValue() {
            return this.value;
        }
    }

    public static final enum RecordItem extends Enum<RecordItem> {
        private static final /* synthetic */ RecordItem[] $VALUES = null;
        public static final RecordItem BACKUP_LEN = null;
        public static final RecordItem CALLER_LIB_NAME = null;
        public static final RecordItem ERRNO = null;
        public static final RecordItem LIB_NAME = null;
        public static final RecordItem NEW_ADDR = null;
        public static final RecordItem OP = null;
        public static final RecordItem STUB = null;
        public static final RecordItem SYM_ADDR = null;
        public static final RecordItem SYM_NAME = null;
        public static final RecordItem TIMESTAMP = null;

        static {
            RecordItem r10 = new RecordItem("TIMESTAMP", 0);
            TIMESTAMP = r10;
            RecordItem r11 = new RecordItem("CALLER_LIB_NAME", 1);
            CALLER_LIB_NAME = r11;
            RecordItem r12 = new RecordItem("OP", 2);
            OP = r12;
            RecordItem r13 = new RecordItem("LIB_NAME", 3);
            LIB_NAME = r13;
            RecordItem r14 = new RecordItem("SYM_NAME", 4);
            SYM_NAME = r14;
            RecordItem r15 = new RecordItem("SYM_ADDR", 5);
            SYM_ADDR = r15;
            RecordItem r16 = new RecordItem("NEW_ADDR", 6);
            NEW_ADDR = r16;
            RecordItem r17 = new RecordItem("BACKUP_LEN", 7);
            BACKUP_LEN = r17;
            RecordItem r18 = new RecordItem("ERRNO", 8);
            ERRNO = r18;
            RecordItem r19 = new RecordItem("STUB", 9);
            STUB = r19;
            $VALUES = new RecordItem[]{r10, r11, r12, r13, r14, r15, r16, r17, r18, r19};
        }

        private RecordItem(String r10, int r11) {
            super(r10, r11);
        }

        public static RecordItem valueOf(String r10) {
            return (RecordItem) Enum.valueOf(RecordItem.class, r10);
        }

        public static RecordItem[] values() {
            return (RecordItem[]) $VALUES.clone();
        }
    }

    static {
        f8083a = Mode.SHARED.getValue();
    }

    private static native String nativeGetArch();

    private static native int nativeGetInitErrno();

    private static native String nativeGetRecords(int r10);

    private static native int nativeInit(int r10, boolean r11);

    private static native void nativeSetDebuggable(boolean r10);

    private static native String nativeToErrmsg(int r10);
}
