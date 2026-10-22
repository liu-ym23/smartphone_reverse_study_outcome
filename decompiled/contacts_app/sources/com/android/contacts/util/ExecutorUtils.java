package com.android.contacts.util;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes2.dex */
public class ExecutorUtils {

    public static class NamedThreadFactory implements ThreadFactory {
        private static AtomicInteger sPoolNumber;
        private String mThreadName;

        static {
            sPoolNumber = new AtomicInteger(1);
        }

        public NamedThreadFactory(String r1) {
            this.mThreadName = r1;
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable r2) {
            Thread r0 = new Thread(r2);
            r0.setName(this.mThreadName + "-" + sPoolNumber.getAndIncrement());
            return r0;
        }
    }

    public ExecutorUtils() {
    }

    public static ExecutorService newSingleThreadExecutor(String r1) {
        return Executors.newSingleThreadExecutor(new NamedThreadFactory(r1));
    }

    public static ExecutorService newFixedThreadPool(int r1, String r2) {
        return Executors.newFixedThreadPool(r1, new NamedThreadFactory(r2));
    }
}
