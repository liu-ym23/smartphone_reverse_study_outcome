package com.bumptech.glide.integration.webp;

import com.ss.android.ugc.bytex.pthread.base.proxy.PThreadPoolExecutor;
import com.ss.android.ugc.bytex.thread_rename.base.DefaultThreadFactory;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes39.dex */
public class WebpThread {
    private static final ThreadPoolExecutor sExecutor = null;

    public WebpThread() {
    }

    static {
        sExecutor = new PThreadPoolExecutor(0, 2, 1, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(), new DefaultThreadFactory("bp/WebpThread"));
    }

    public static void execute(Runnable r100) {
        sExecutor.execute(r100);
    }
}
