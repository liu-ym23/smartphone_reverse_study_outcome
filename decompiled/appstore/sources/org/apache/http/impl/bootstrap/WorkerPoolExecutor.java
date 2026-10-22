package org.apache.http.impl.bootstrap;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes4.dex */
class WorkerPoolExecutor extends ThreadPoolExecutor {
    private final Map<Worker, Boolean> workerSet;

    public WorkerPoolExecutor(int r10, int r11, long r12, TimeUnit r13, BlockingQueue<Runnable> r14, ThreadFactory r15) {
        super(r10, r11, r12, r13, r14, r15);
        this.workerSet = new ConcurrentHashMap();
    }

    @Override // java.util.concurrent.ThreadPoolExecutor
    public void afterExecute(Runnable r10, Throwable r11) {
        if ((r10 instanceof Worker) == false) goto L6;
        this.workerSet.remove(r10);
        return;
    }

    @Override // java.util.concurrent.ThreadPoolExecutor
    public void beforeExecute(Thread r10, Runnable r11) {
        if ((r11 instanceof Worker) == false) goto L6;
        this.workerSet.put((Worker) r11, Boolean.TRUE);
        return;
    }

    public Set<Worker> getWorkers() {
        return new HashSet(this.workerSet.keySet());
    }
}
