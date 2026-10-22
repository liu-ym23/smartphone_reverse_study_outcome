package com.stepos.core.common.telemetry;

import kotlin.coroutines.d;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class TrackerContext extends kotlin.coroutines.a {
    public static final Key Key = new Key(null);
    private static final ThreadLocal<Object> threadLocal = new ThreadLocal<>();
    private final Object tracker;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class Key implements d.b<TrackerContext> {
        public /* synthetic */ Key(kotlin.jvm.internal.e eVar) {
            this();
        }

        public final Object currentTracker(qb.b<Object> bVar) {
            Object tracker;
            TrackerContext trackerContext = (TrackerContext) bVar.getContext().get(TrackerContext.Key);
            return (trackerContext == null || (tracker = trackerContext.getTracker()) == null) ? getThreadLocal().get() : tracker;
        }

        public final Object currentTrackerBlocking() {
            return getThreadLocal().get();
        }

        public final ThreadLocal<Object> getThreadLocal() {
            return TrackerContext.threadLocal;
        }

        public final <R> R withTrackerOnThread(Object obj, zb.a<? extends R> block) {
            kotlin.jvm.internal.g.f(block, "block");
            Object obj2 = getThreadLocal().get();
            getThreadLocal().set(obj);
            try {
                R rInvoke = block.invoke();
                ThreadLocal<Object> threadLocal = getThreadLocal();
                if (obj2 == null) {
                    threadLocal.remove();
                } else {
                    threadLocal.set(obj2);
                }
                return rInvoke;
            } catch (Throwable th) {
                ThreadLocal<Object> threadLocal2 = getThreadLocal();
                if (obj2 == null) {
                    threadLocal2.remove();
                } else {
                    threadLocal2.set(obj2);
                }
                throw th;
            }
        }

        private Key() {
        }

        public static /* synthetic */ void getThreadLocal$annotations() {
        }
    }

    public TrackerContext(Object obj) {
        super(Key);
        this.tracker = obj;
    }

    public final Object getTracker() {
        return this.tracker;
    }
}
