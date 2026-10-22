package com.tmall.wireless.tangram.eventbus;

import androidx.annotation.NonNull;
import androidx.collection.ArrayMap;
import androidx.core.util.Pools$SynchronizedPool;

/* JADX INFO: loaded from: classes4.dex */
class EventPool {
    private Pools$SynchronizedPool recyclePool;

    /* JADX INFO: renamed from: com.tmall.wireless.tangram.eventbus.EventPool$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public static class EventPoolHolder {
        private static final EventPool sharedInstance = null;

        static {
            sharedInstance = new EventPool(null);
        }

        private EventPoolHolder() {
        }

        public static /* synthetic */ EventPool access$100() {
            return sharedInstance;
        }
    }

    public /* synthetic */ EventPool(AnonymousClass1 r10) {
        this();
    }

    public static EventPool sharedInstance() {
        return EventPoolHolder.access$100();
    }

    @NonNull
    public Event acquire() {
        Event r10 = (Event) this.recyclePool.acquire();
        if (r10 == null) goto L5;
        return r10;
    L5:
        return new Event();
    }

    public boolean release(@NonNull Event r10) {
        r10.type = null;
        r10.sourceId = null;
        ArrayMap r11 = r10.args;
        if (r11 == null) goto L5;
        r11.clear();
    L5:
        r10.eventContext = null;
        return this.recyclePool.release(r10);
    }

    private EventPool() {
        this.recyclePool = new Pools$SynchronizedPool(25);
    }
}
