package com.fasterxml.jackson.core.util;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.ReentrantLock;

/* loaded from: classes.dex */
class ThreadLocalBufferManager {
    private final ReentrantLock RELEASE_LOCK = new ReentrantLock();
    private final Map<SoftReference<BufferRecycler>, Boolean> _trackedRecyclers = new ConcurrentHashMap();
    private final ReferenceQueue<BufferRecycler> _refQueue = new ReferenceQueue<>();

    public static final class ThreadLocalBufferManagerHolder {
        static final ThreadLocalBufferManager manager = new ThreadLocalBufferManager();

        private ThreadLocalBufferManagerHolder() {
        }
    }

    public static ThreadLocalBufferManager instance() {
        return ThreadLocalBufferManagerHolder.manager;
    }

    private void removeSoftRefsClearedByGc() {
        while (true) {
            SoftReference softReference = (SoftReference) this._refQueue.poll();
            if (softReference == null) {
                return;
            } else {
                this._trackedRecyclers.remove(softReference);
            }
        }
    }

    public int releaseBuffers() {
        this.RELEASE_LOCK.lock();
        try {
            removeSoftRefsClearedByGc();
            Iterator<SoftReference<BufferRecycler>> it = this._trackedRecyclers.keySet().iterator();
            int i10 = 0;
            while (it.hasNext()) {
                it.next().clear();
                i10++;
            }
            this._trackedRecyclers.clear();
            this.RELEASE_LOCK.unlock();
            return i10;
        } catch (Throwable th) {
            this.RELEASE_LOCK.unlock();
            throw th;
        }
    }

    public SoftReference<BufferRecycler> wrapAndTrack(BufferRecycler bufferRecycler) {
        SoftReference<BufferRecycler> softReference = new SoftReference<>(bufferRecycler, this._refQueue);
        this._trackedRecyclers.put(softReference, Boolean.TRUE);
        removeSoftRefsClearedByGc();
        return softReference;
    }
}
