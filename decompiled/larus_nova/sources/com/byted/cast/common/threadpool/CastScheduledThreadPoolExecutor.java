package com.byted.cast.common.threadpool;

import com.ss.android.ugc.bytex.pthread.base.proxy.PThreadScheduledThreadPoolExecutor;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;

/* JADX INFO: loaded from: classes39.dex */
public class CastScheduledThreadPoolExecutor extends PThreadScheduledThreadPoolExecutor {
    private static final String TAG = null;

    static {
        TAG = "CastScheduledThreadPoolExecutor";
    }

    public CastScheduledThreadPoolExecutor(int r100) {
        this(r100, new CastThreadFactory(TAG));
    }

    public CastScheduledThreadPoolExecutor(int r100, RejectedExecutionHandler r101) {
        this(r100, new CastThreadFactory(TAG), r101);
    }

    public CastScheduledThreadPoolExecutor(int r100, ThreadFactory r101) {
        this(r100, r101, new ThreadPoolExecutor.AbortPolicy());
    }

    public CastScheduledThreadPoolExecutor(int r100, ThreadFactory r101, RejectedExecutionHandler r102) {
        super(r100, r101, r102);
    }
}
