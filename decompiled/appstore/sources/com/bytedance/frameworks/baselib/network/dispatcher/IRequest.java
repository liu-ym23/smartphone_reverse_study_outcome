package com.bytedance.frameworks.baselib.network.dispatcher;

/* JADX INFO: loaded from: classes.dex */
public interface IRequest {

    public static final enum Priority extends Enum<Priority> {
        private static final /* synthetic */ Priority[] $VALUES = null;
        public static final Priority HIGH = null;
        public static final Priority IMMEDIATE = null;
        public static final Priority LOW = null;
        public static final Priority NORMAL = null;

        static {
            Priority r10 = new Priority("LOW", 0);
            LOW = r10;
            Priority r11 = new Priority("NORMAL", 1);
            NORMAL = r11;
            Priority r12 = new Priority("HIGH", 2);
            HIGH = r12;
            Priority r13 = new Priority("IMMEDIATE", 3);
            IMMEDIATE = r13;
            $VALUES = new Priority[]{r10, r11, r12, r13};
        }

        private Priority(String r10, int r11) {
            super(r10, r11);
        }

        public static Priority valueOf(String r10) {
            return (Priority) Enum.valueOf(Priority.class, r10);
        }

        public static Priority[] values() {
            return (Priority[]) $VALUES.clone();
        }
    }

    Priority getPriority();

    int getSequence();
}
