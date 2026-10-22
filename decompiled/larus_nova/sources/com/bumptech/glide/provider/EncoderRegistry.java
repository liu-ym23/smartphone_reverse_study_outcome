package com.bumptech.glide.provider;

import com.bumptech.glide.load.Encoder;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes39.dex */
public class EncoderRegistry {
    private final List<Entry<?>> encoders;

    public static final class Entry<T> {
        private final Class<T> dataClass;
        final Encoder<T> encoder;

        public boolean handles(Class<?> r100) {
            return this.dataClass.isAssignableFrom(r100);
        }

        public Entry(Class<T> r100, Encoder<T> r101) {
            this.dataClass = r100;
            this.encoder = r101;
        }
    }

    public EncoderRegistry() {
        this.encoders = new ArrayList();
    }

    public synchronized <T> Encoder<T> getEncoder(Class<T> r100) {
        monitor-enter(this);
        Iterator<Entry<?>> r101 = this.encoders.iterator();     // Catch: Throwable -> L14
    L5:
        if (r101.hasNext() == false) goto L11;
        Entry<?> r102 = r101.next();     // Catch: Throwable -> L14
        if (r102.handles(r100) == false) goto L5;
        Encoder<T> r103 = (Encoder<T>) r102.encoder;
        monitor-exit(this);
        return r103;
    L11:
        monitor-exit(this);
        return null;
    L14:
        th = move-exception;
        throw th;
    }

    public synchronized <T> void append(Class<T> r100, Encoder<T> r101) {
        monitor-enter(this);
        this.encoders.add(new Entry(r100, r101));     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized <T> void prepend(Class<T> r100, Encoder<T> r101) {
        monitor-enter(this);
        ListProtector.add(this.encoders, 0, new Entry(r100, r101));     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }
}
