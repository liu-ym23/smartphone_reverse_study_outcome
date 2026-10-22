package com.bytedance.memory.b;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

/* JADX INFO: compiled from: MemoryExecutorSupplier.java */
/* JADX INFO: loaded from: classes.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Deprecated
    public static final ScheduledExecutorService f8770a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f8771b = null;

    /* JADX INFO: compiled from: MemoryExecutorSupplier.java */
    public interface a {
        void a(Runnable r1, String r2);
    }

    static {
        f8770a = Executors.newScheduledThreadPool(1, new f("CheckToDump"));
        f8771b = new AnonymousClass1();
    }
}
