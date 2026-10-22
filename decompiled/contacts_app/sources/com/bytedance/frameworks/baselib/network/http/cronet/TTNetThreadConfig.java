package com.bytedance.frameworks.baselib.network.http.cronet;

/* JADX INFO: loaded from: classes2.dex */
public class TTNetThreadConfig {
    private static final int INVALID_THREAD_PRIORITY = 20;
    public int mThreadPriority;
    public int mThreadStackSize;
    public ThreadType mThreadType;

    public interface Callback {
        void bindBigCore(int r1);

        void bindLittleCore(int r1);

        void resetCoreBind(int r1);
    }

    public static final enum ThreadStackInitReason extends Enum<ThreadStackInitReason> {
        private static final /* synthetic */ ThreadStackInitReason[] $VALUES = null;
        public static final ThreadStackInitReason CALLED_MULIT_TIMES = null;
        public static final ThreadStackInitReason CRASH_HAPPENED = null;
        public static final ThreadStackInitReason FALLBACK_FIX = null;
        public static final ThreadStackInitReason HAS_EXCEPTION = null;
        public static final ThreadStackInitReason OPT_EFFECTIVE = null;
        public static final ThreadStackInitReason PROCESS_NAME_NULL = null;
        public static final ThreadStackInitReason TNC_DISABLED = null;

        private ThreadStackInitReason(String r1, int r2) {
            super(r1, r2);
        }

        public static ThreadStackInitReason valueOf(String r1) {
            return (ThreadStackInitReason) Enum.valueOf(ThreadStackInitReason.class, r1);
        }

        public static ThreadStackInitReason[] values() {
            return (ThreadStackInitReason[]) $VALUES.clone();
        }

        static {
            ThreadStackInitReason r0 = new ThreadStackInitReason("CALLED_MULIT_TIMES", 0);
            CALLED_MULIT_TIMES = r0;
            ThreadStackInitReason r1 = new ThreadStackInitReason("PROCESS_NAME_NULL", 1);
            PROCESS_NAME_NULL = r1;
            ThreadStackInitReason r3 = new ThreadStackInitReason("TNC_DISABLED", 2);
            TNC_DISABLED = r3;
            ThreadStackInitReason r5 = new ThreadStackInitReason("CRASH_HAPPENED", 3);
            CRASH_HAPPENED = r5;
            ThreadStackInitReason r7 = new ThreadStackInitReason("OPT_EFFECTIVE", 4);
            OPT_EFFECTIVE = r7;
            ThreadStackInitReason r9 = new ThreadStackInitReason("FALLBACK_FIX", 5);
            FALLBACK_FIX = r9;
            ThreadStackInitReason r11 = new ThreadStackInitReason("HAS_EXCEPTION", 6);
            HAS_EXCEPTION = r11;
            $VALUES = new ThreadStackInitReason[]{r0, r1, r3, r5, r7, r9, r11};
        }
    }

    public static final enum ThreadType extends Enum<ThreadType> {
        private static final /* synthetic */ ThreadType[] $VALUES = null;
        public static final ThreadType FILE_THREAD = null;
        public static final ThreadType INIT_THREAD = null;
        public static final ThreadType NETWORK_THREAD = null;
        public static final ThreadType THREAD_POOL_SERVICE_THREAD = null;
        public static final ThreadType WORKER_THREAD = null;

        private ThreadType(String r1, int r2) {
            super(r1, r2);
        }

        public static ThreadType valueOf(String r1) {
            return (ThreadType) Enum.valueOf(ThreadType.class, r1);
        }

        public static ThreadType[] values() {
            return (ThreadType[]) $VALUES.clone();
        }

        static {
            ThreadType r0 = new ThreadType("INIT_THREAD", 0);
            INIT_THREAD = r0;
            ThreadType r1 = new ThreadType("NETWORK_THREAD", 1);
            NETWORK_THREAD = r1;
            ThreadType r3 = new ThreadType("FILE_THREAD", 2);
            FILE_THREAD = r3;
            ThreadType r5 = new ThreadType("THREAD_POOL_SERVICE_THREAD", 3);
            THREAD_POOL_SERVICE_THREAD = r5;
            ThreadType r7 = new ThreadType("WORKER_THREAD", 4);
            WORKER_THREAD = r7;
            $VALUES = new ThreadType[]{r0, r1, r3, r5, r7};
        }
    }

    public TTNetThreadConfig() {
        this.mThreadPriority = 20;
        this.mThreadStackSize = 0;
    }
}
