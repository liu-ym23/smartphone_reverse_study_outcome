package com.ttnet.org.chromium.net;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes4.dex */
public abstract class TTThreadConfigInfoProvider {

    public static class ThreadConfigInfo {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private c f37871a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f37872b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private int f37873c;

        public ThreadConfigInfo() {
            this.f37872b = 20;
        }

        public void a(c r1) {
            this.f37871a = r1;
        }

        public int getThreadType() {
            return this.f37871a.ordinal();
        }

        public void a(int r1) {
            this.f37872b = r1;
        }

        public int getThreadPriority() {
            return this.f37872b;
        }

        public void b(int r1) {
            this.f37873c = r1;
        }

        public int getThreadStackSize() {
            return this.f37873c;
        }
    }

    public static final enum a extends Enum<a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f37874a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final a f37875b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final a f37876c = null;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final a f37877d = null;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private static final /* synthetic */ a[] f37878e = null;

        private a(String r1, int r2) {
            super(r1, r2);
        }

        public static a valueOf(String r2) {
            return (a) ZeusTransformUtils.preCheckCast(Enum.valueOf(a.class, r2), a.class, "com.obric.aiagent.plugin");
        }

        public static a[] values() {
            return (a[]) ZeusTransformUtils.preCheckCast(f37878e.clone(), a[].class, "com.obric.aiagent.plugin");
        }

        static {
            a r0 = new a("DEFAULT", 0);
            f37874a = r0;
            a r1 = new a("BIG_CORE", 1);
            f37875b = r1;
            a r3 = new a("LITTLE_CORE", 2);
            f37876c = r3;
            a r5 = new a("CANCEL_BIND", 3);
            f37877d = r5;
            f37878e = new a[]{r0, r1, r3, r5};
        }
    }

    public interface b {
        void bindBigCore(int r1);

        void bindLittleCore(int r1);

        void resetCoreBind(int r1);
    }

    public static final enum c extends Enum<c> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c f37879a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final c f37880b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final c f37881c = null;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final c f37882d = null;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final c f37883e = null;
        private static final /* synthetic */ c[] f = null;

        private c(String r1, int r2) {
            super(r1, r2);
        }

        public static c valueOf(String r2) {
            return (c) ZeusTransformUtils.preCheckCast(Enum.valueOf(c.class, r2), c.class, "com.obric.aiagent.plugin");
        }

        public static c[] values() {
            return (c[]) ZeusTransformUtils.preCheckCast(f.clone(), c[].class, "com.obric.aiagent.plugin");
        }

        static {
            c r0 = new c("INIT_THREAD", 0);
            f37879a = r0;
            c r1 = new c("NETWORK_THREAD", 1);
            f37880b = r1;
            c r3 = new c("FILE_THREAD", 2);
            f37881c = r3;
            c r5 = new c("THREAD_POOL_SERVICE_THREAD", 3);
            f37882d = r5;
            c r7 = new c("WORKER_THREAD", 4);
            f37883e = r7;
            f = new c[]{r0, r1, r3, r5, r7};
        }
    }
}
