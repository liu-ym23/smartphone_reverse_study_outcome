package com.obric.capabilitykit.entity;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import kotlinx.coroutines.am;
import kotlinx.coroutines.an;
import kotlinx.coroutines.br;

/* JADX INFO: loaded from: classes4.dex */
public final class EntityThreadContainer {
    public static final Companion Companion = null;
    private static final int corePoolSize = 0;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(h r1) {
            this();
        }

        public final am getScope() {
            return an.a(br.a(new ThreadPoolExecutor(EntityThreadContainer.access$getCorePoolSize$cp(), 50, 30, TimeUnit.SECONDS, new LinkedBlockingQueue(300), new a(""))));
        }
    }

    public static final class a implements ThreadFactory {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private ThreadGroup f32084a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private String f32085b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private AtomicInteger f32086c;

        public a(String r2) {
            o.e(r2, "prefix");
            this.f32085b = r2;
            this.f32086c = new AtomicInteger(1);
            SecurityManager r3 = System.getSecurityManager();
            if (r3 == null) goto L5;
            ThreadGroup r4 = r3.getThreadGroup();
        L6:
            this.f32084a = r4;
            return;
        L5:
            r4 = Thread.currentThread().getThreadGroup();
            goto L6
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable r7) {
            Runnable r2 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r7, Runnable.class, "com.obric.aiagent.plugin");
            StringBuilder r8 = new StringBuilder().append(this.f32085b).append('-');
            AtomicInteger r0 = this.f32086c;
            o.a(r0);
            String r3 = r8.append(r0.getAndIncrement()).toString();
            Thread r9 = new Thread(this.f32084a, r2, r3, 0);
            if (r9.isDaemon() == false) goto L5;
            r9.setDaemon(false);
        L5:
            return r9;
        }
    }

    static {
        Companion = new Companion(null);
        corePoolSize = Runtime.getRuntime().availableProcessors() + 1;
    }

    public EntityThreadContainer() {
    }

    public static final /* synthetic */ int access$getCorePoolSize$cp() {
        return corePoolSize;
    }
}
