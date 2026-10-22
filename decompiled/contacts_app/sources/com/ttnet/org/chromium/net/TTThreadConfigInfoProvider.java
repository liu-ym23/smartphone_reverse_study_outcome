package com.ttnet.org.chromium.net;

import com.ttnet.org.chromium.base.annotations.JNINamespace;

/* JADX INFO: loaded from: classes4.dex */
@JNINamespace("cronet")
public abstract class TTThreadConfigInfoProvider {
    public static final int INVALID_THREAD_PRIORITY = 20;

    public static final enum BindCore extends Enum<BindCore> {
        private static final /* synthetic */ BindCore[] $VALUES = null;
        public static final BindCore BIG_CORE = null;
        public static final BindCore CANCEL_BIND = null;
        public static final BindCore DEFAULT = null;
        public static final BindCore LITTLE_CORE = null;

        private BindCore(String r1, int r2) {
            super(r1, r2);
        }

        public static BindCore valueOf(String r1) {
            return (BindCore) Enum.valueOf(BindCore.class, r1);
        }

        public static BindCore[] values() {
            return (BindCore[]) $VALUES.clone();
        }

        static {
            BindCore r0 = new BindCore("DEFAULT", 0);
            DEFAULT = r0;
            BindCore r1 = new BindCore("BIG_CORE", 1);
            BIG_CORE = r1;
            BindCore r3 = new BindCore("LITTLE_CORE", 2);
            LITTLE_CORE = r3;
            BindCore r5 = new BindCore("CANCEL_BIND", 3);
            CANCEL_BIND = r5;
            $VALUES = new BindCore[]{r0, r1, r3, r5};
        }
    }

    public interface Callback {
        void bindBigCore(int r1);

        void bindLittleCore(int r1);

        void resetCoreBind(int r1);
    }

    public static class ThreadConfigInfo {
        private BindCore mBindCore;
        private int mThreadPriority;
        private int mThreadStackSize;
        private ThreadType mThreadType;

        public ThreadConfigInfo() {
            this.mThreadPriority = 20;
        }

        public void setThreadType(ThreadType r1) {
            this.mThreadType = r1;
        }

        public int getThreadType() {
            return this.mThreadType.ordinal();
        }

        public void setThreadPriority(int r1) {
            this.mThreadPriority = r1;
        }

        public int getThreadPriority() {
            return this.mThreadPriority;
        }

        public void setThreadStackSize(int r1) {
            this.mThreadStackSize = r1;
        }

        public int getThreadStackSize() {
            return this.mThreadStackSize;
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

    public TTThreadConfigInfoProvider() {
    }
}
