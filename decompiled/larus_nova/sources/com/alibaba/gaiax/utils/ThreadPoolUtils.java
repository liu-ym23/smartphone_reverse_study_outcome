package com.alibaba.gaiax.utils;

import com.ss.android.ugc.bytex.pthread.base.proxy.PThreadPoolExecutor;
import com.ss.android.ugc.bytex.thread_rename.base.DefaultThreadFactory;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004¨\u0006\u0005"}, d2 = {"Lcom/alibaba/gaiax/utils/ThreadPoolUtils;", "", "()V", "newSingleThreadPool", "Ljava/util/concurrent/ThreadPoolExecutor;", "GaiaXAndroidApi_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class ThreadPoolUtils {
    public static final ThreadPoolUtils INSTANCE = null;

    static {
        INSTANCE = new ThreadPoolUtils();
    }

    private ThreadPoolUtils() {
    }

    public final ThreadPoolExecutor newSingleThreadPool() {
        return new PThreadPoolExecutor(1, 1, 0, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(), new DefaultThreadFactory("ThreadPoolUtils"));
    }
}
