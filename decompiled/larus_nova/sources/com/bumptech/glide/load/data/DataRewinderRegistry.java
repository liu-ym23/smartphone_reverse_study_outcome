package com.bumptech.glide.load.data;

import com.bumptech.glide.util.Preconditions;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes39.dex */
public class DataRewinderRegistry {
    private static final DataRewinder.Factory<?> DEFAULT_FACTORY = null;
    private final Map<Class<?>, DataRewinder.Factory<?>> rewinders;

    public static final class DefaultRewinder implements DataRewinder<Object> {
        private final Object data;

        @Override // com.bumptech.glide.load.data.DataRewinder
        public void cleanup() {
        }

        @Override // com.bumptech.glide.load.data.DataRewinder
        public Object rewindAndGet() {
            return this.data;
        }

        public DefaultRewinder(Object r100) {
            this.data = r100;
        }
    }

    static {
        DEFAULT_FACTORY = new AnonymousClass1();
    }

    public DataRewinderRegistry() {
        this.rewinders = new HashMap();
    }

    public synchronized <T> DataRewinder<T> build(T r100) {
        monitor-enter(this);
        Preconditions.checkNotNull(r100);     // Catch: Throwable -> L16
        DataRewinder.Factory<?> r101 = this.rewinders.get(r100.getClass());     // Catch: Throwable -> L16
        if (r101 != null) goto L11;
        Iterator<DataRewinder.Factory<?>> r102 = this.rewinders.values().iterator();     // Catch: Throwable -> L16
    L7:
        if (r102.hasNext() == false) goto L11;
        DataRewinder.Factory<?> r103 = r102.next();     // Catch: Throwable -> L16
        if (r103.getDataClass().isAssignableFrom(r100.getClass()) == false) goto L7;
        r101 = r103;
    L11:
        if (r101 != null) goto L13;
        r101 = DEFAULT_FACTORY;     // Catch: Throwable -> L16
    L13:
        DataRewinder<T> r104 = (DataRewinder<T>) r101.build(r100);
        monitor-exit(this);
        return r104;
    L16:
        th = move-exception;
        throw th;
    }

    public synchronized void register(DataRewinder.Factory<?> r100) {
        monitor-enter(this);
        this.rewinders.put(r100.getDataClass(), r100);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }
}
