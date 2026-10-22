package com.ttnet.org.chromium.net.impl;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: JavaUrlRequestUtils.java */
/* JADX INFO: loaded from: classes4.dex */
public final class t {

    /* JADX INFO: renamed from: com.ttnet.org.chromium.net.impl.t$1, reason: invalid class name */
    /* JADX INFO: compiled from: JavaUrlRequestUtils.java */
    static /* synthetic */ class AnonymousClass1 {
    }

    /* JADX INFO: compiled from: JavaUrlRequestUtils.java */
    public interface a {
        void a();
    }

    /* JADX INFO: compiled from: JavaUrlRequestUtils.java */
    public static final class b implements Executor {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Executor f38236a;

        /* JADX INFO: compiled from: JavaUrlRequestUtils.java */
        private static final class a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private final Runnable f38237a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private Thread f38238b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            private com.ttnet.org.chromium.net.l f38239c;

            /* synthetic */ a(Runnable r2, Thread r3, AnonymousClass1 r4) {
                this((Runnable) ZeusTransformUtils.wrapperContextForParams(r2, Runnable.class, "com.obric.aiagent.plugin"), r3);
            }

            static /* synthetic */ com.ttnet.org.chromium.net.l a(a r0) {
                return r0.f38239c;
            }

            static /* synthetic */ Thread a(a r0, Thread r1) {
                r0.f38238b = r1;
                return r1;
            }

            private a(Runnable r3, Thread r4) {
                this.f38237a = (Runnable) ZeusTransformUtils.wrapperContextForParams(r3, Runnable.class, "com.obric.aiagent.plugin");
                this.f38238b = r4;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (Thread.currentThread() != this.f38238b) goto L6;
                this.f38239c = new com.ttnet.org.chromium.net.l();
                return;
            L6:
                this.f38237a.run();
            }
        }

        public b(Executor r3) {
            this.f38236a = (Executor) ZeusTransformUtils.wrapperContextForParams(r3, Executor.class, "com.obric.aiagent.plugin");
        }

        @Override // java.util.concurrent.Executor
        public void execute(Runnable r4) {
            a r1 = new a((Runnable) ZeusTransformUtils.wrapperContextForParams(r4, Runnable.class, "com.obric.aiagent.plugin"), Thread.currentThread(), null);
            this.f38236a.execute(r1);
            if (a.a(r1) != null) goto L7;
            a.a(r1, null);
            return;
        L7:
            throw a.a(r1);
        }
    }
}
