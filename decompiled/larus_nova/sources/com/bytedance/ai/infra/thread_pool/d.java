package com.bytedance.ai.infra.thread_pool;

import android.os.Process;
import com.bytedance.common.utility.Logger;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class d implements ThreadFactory {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f36605a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ThreadPriority f36606b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final AtomicInteger f36607c;

    public static final class a {
    }

    public static final class b extends PthreadThreadV2 {

        /* JADX INFO: renamed from: v, reason: collision with root package name */
        public final /* synthetic */ d f36608v;

        public /* synthetic */ class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f36609a = null;

            static {
                int[] r100 = new int[ThreadPriority.values().length];
                r100[ThreadPriority.LOW.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
            L9:
                r100[ThreadPriority.HIGH.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
            L5:
                f36609a = r100;
            }
        }

        @Override // com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2, java.lang.Thread, java.lang.Runnable
        public final void run() {
            ThreadPriority r100 = this.f36608v.f36606b;     // Catch: Throwable -> L11
            int r101 = a.f36609a[r100.ordinal()];     // Catch: Throwable -> L11
            if (r101 != 1) goto L5;
            Process.setThreadPriority(10);     // Catch: Throwable -> L11
        L9:
            super.run();     // Catch: Throwable -> L11
            return;
        L5:
            if (r101 != 2) goto L9;
            Process.setThreadPriority(-4);     // Catch: Throwable -> L11
        L11:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L15;
            return;
        L15:
            throw th;
        }

        public b(Runnable r100, String r101, d r102) {
            this.f36608v = r102;
            super(r100, r101);
        }
    }

    static {
    }

    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(Runnable r100) {
        Intrinsics.checkNotNullParameter(r100, "r");
        String r101 = this.f36605a + '-' + this.f36607c.incrementAndGet();
        Logger.d("DefaultThreadFactory", "Create New Thread: " + r101);
        return new b(r100, r101, this);
    }

    public d(String r100, ThreadPriority r101) {
        Intrinsics.checkNotNullParameter(r100, "namePrefix");
        Intrinsics.checkNotNullParameter(r101, "threadPriority");
        this.f36605a = r100;
        this.f36606b = r101;
        this.f36607c = new AtomicInteger(0);
    }
}
