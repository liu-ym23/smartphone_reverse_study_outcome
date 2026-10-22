package com.bumptech.glide.load.data;

import androidx.annotation.NonNull;
import com.bumptech.glide.util.Preconditions;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class DataRewinderRegistry {
    private static final DataRewinder.Factory<?> DEFAULT_FACTORY = null;
    private final Map<Class<?>, DataRewinder.Factory<?>> rewinders;

    public static final class DefaultRewinder implements DataRewinder<Object> {
        private final Object data;

        public DefaultRewinder(@NonNull Object r10) {
            this.data = r10;
        }

        @Override // com.bumptech.glide.load.data.DataRewinder
        public void cleanup() {
        }

        @Override // com.bumptech.glide.load.data.DataRewinder
        @NonNull
        public Object rewindAndGet() {
            return this.data;
        }
    }

    static {
        DEFAULT_FACTORY = new AnonymousClass1();
    }

    public DataRewinderRegistry() {
        this.rewinders = new HashMap();
    }

    @NonNull
    public synchronized <T> DataRewinder<T> build(@NonNull T r10) {
        monitor-enter(this);
        Preconditions.checkNotNull(r10);     // Catch: Throwable -> L11
        DataRewinder.Factory<?> r11 = this.rewinders.get(r10.getClass());     // Catch: Throwable -> L11
        if (r11 != null) goto L13;
        Iterator<DataRewinder.Factory<?>> r12 = this.rewinders.values().iterator();     // Catch: Throwable -> L11
    L7:
        if (r12.hasNext() == false) goto L13;
        DataRewinder.Factory<?> r13 = r12.next();     // Catch: Throwable -> L11
        if (r13.getDataClass().isAssignableFrom(r10.getClass()) == false) goto L7;
        r11 = r13;
    L13:
        if (r11 != null) goto L15;
        r11 = DEFAULT_FACTORY;     // Catch: Throwable -> L11
    L15:
        DataRewinder<T> r14 = (DataRewinder<T>) r11.build(r10);
        monitor-exit(this);
        return r14;
    L11:
        th = move-exception;
        throw th;
    }

    public synchronized void register(@NonNull DataRewinder.Factory<?> r10) {
        monitor-enter(this);
        this.rewinders.put(r10.getDataClass(), r10);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }
}
