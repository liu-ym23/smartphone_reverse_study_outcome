package com.obric.capabilitykit.entity;

import androidx.annotation.Keep;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.d0;
import kotlinx.coroutines.x0;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes3.dex */
@Keep
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0007\u0018\u0000 \u00032\u00020\u0001:\u0002\u0003\u0004B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0005"}, d2 = {"Lcom/obric/capabilitykit/entity/EntityThreadContainer;", "", "()V", "Companion", "CustomThreadFactory", "capabilitykit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class EntityThreadContainer {

    @NotNull
    public static final Companion Companion = null;
    private static final int corePoolSize = 0;

    @Keep
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0087\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0005\u001a\u00020\u0006R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/obric/capabilitykit/entity/EntityThreadContainer$Companion;", "", "()V", "corePoolSize", "", "getScope", "Lkotlinx/coroutines/CoroutineScope;", "capabilitykit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        @NotNull
        public final CoroutineScope getScope() {
            return d0.a(x0.b(new ThreadPoolExecutor(EntityThreadContainer.access$getCorePoolSize$cp(), 50, 30, TimeUnit.SECONDS, new LinkedBlockingQueue(300), new a(""))));
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r10) {
            this();
        }
    }

    public static final class a implements ThreadFactory {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public ThreadGroup f11316a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f11317b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public AtomicInteger f11318c;

        public a(String r10) {
            q.g(r10, "prefix");
            this.f11317b = r10;
            this.f11318c = new AtomicInteger(1);
            SecurityManager r11 = System.getSecurityManager();
            if (r11 == null) goto L5;
            ThreadGroup r12 = r11.getThreadGroup();
        L6:
            this.f11316a = r12;
            return;
        L5:
            r12 = Thread.currentThread().getThreadGroup();
            goto L6
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable r10) {
            StringBuilder r11 = new StringBuilder();
            r11.append(this.f11317b);
            r11.append('-');
            AtomicInteger r12 = this.f11318c;
            q.d(r12);
            r11.append(r12.getAndIncrement());
            String r13 = r11.toString();
            Thread r14 = new Thread(this.f11316a, r10, r13, 0);
            if (r14.isDaemon() == false) goto L5;
            r14.setDaemon(false);
        L5:
            return r14;
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
