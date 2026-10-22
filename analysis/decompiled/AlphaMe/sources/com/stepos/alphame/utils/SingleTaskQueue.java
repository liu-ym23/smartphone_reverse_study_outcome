package com.stepos.alphame.utils;

import androidx.annotation.Nullable;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public class SingleTaskQueue {
    private static final ExecutorService POOL = new ThreadPoolExecutor(0, 1, 60, TimeUnit.SECONDS, new LinkedBlockingQueue(), new NamedThreadFactory("single"));

    @Nullable
    public static <T> T runTaskAndWait(Callable<T> callable) {
        try {
            return POOL.submit(callable).get();
        } catch (Exception unused) {
            return null;
        }
    }
}
