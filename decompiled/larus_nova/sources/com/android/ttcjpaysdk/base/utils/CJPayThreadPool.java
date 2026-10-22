package com.android.ttcjpaysdk.base.utils;

import android.os.Handler;
import android.os.Looper;
import com.ss.android.ugc.bytex.pthread.base.PThreadExecutorsUtils;
import com.ss.android.ugc.bytex.thread_rename.base.DefaultThreadFactory;
import java.util.concurrent.ExecutorService;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nJ\u000e\u0010\u000b\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/android/ttcjpaysdk/base/utils/CJPayThreadPool;", "", "()V", "cachedThreadPool", "Ljava/util/concurrent/ExecutorService;", "handler", "Landroid/os/Handler;", "startThread", "", "runnable", "Ljava/lang/Runnable;", "startUIThread", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CJPayThreadPool {
    public static final CJPayThreadPool INSTANCE = null;
    private static ExecutorService cachedThreadPool;
    private static Handler handler;

    private CJPayThreadPool() {
    }

    static {
        INSTANCE = new CJPayThreadPool();
        cachedThreadPool = PThreadExecutorsUtils.newCachedThreadPool(new DefaultThreadFactory("CJPayThreadPool"));
        handler = new Handler(Looper.getMainLooper());
    }

    public final void startThread(Runnable r100) {
        Intrinsics.checkNotNullParameter(r100, "runnable");
        cachedThreadPool.execute(r100);
    }

    public final void startUIThread(Runnable r100) {
        Intrinsics.checkNotNullParameter(r100, "runnable");
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper()) == false) goto L5;
        r100.run();
        return;
    L5:
        handler.post(r100);
    }
}
