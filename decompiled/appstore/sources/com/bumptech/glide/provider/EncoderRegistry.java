package com.bumptech.glide.provider;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.load.Encoder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class EncoderRegistry {
    private final List<Entry<?>> encoders;

    public static final class Entry<T> {
        private final Class<T> dataClass;
        final Encoder<T> encoder;

        public Entry(@NonNull Class<T> r10, @NonNull Encoder<T> r11) {
            this.dataClass = r10;
            this.encoder = r11;
        }

        public boolean handles(@NonNull Class<?> r10) {
            return this.dataClass.isAssignableFrom(r10);
        }
    }

    public EncoderRegistry() {
        this.encoders = new ArrayList();
    }

    public synchronized <T> void append(@NonNull Class<T> r10, @NonNull Encoder<T> r11) {
        monitor-enter(this);
        this.encoders.add(new Entry(r10, r11));     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    @Nullable
    public synchronized <T> Encoder<T> getEncoder(@NonNull Class<T> r10) {
        monitor-enter(this);
        Iterator<Entry<?>> r11 = this.encoders.iterator();     // Catch: Throwable -> L11
    L5:
        if (r11.hasNext() == false) goto L13;
        Entry<?> r12 = r11.next();     // Catch: Throwable -> L11
        if (r12.handles(r10) == false) goto L5;
        Encoder<T> r13 = (Encoder<T>) r12.encoder;
        monitor-exit(this);
        return r13;
    L13:
        monitor-exit(this);
        return null;
    L11:
        th = move-exception;
        throw th;
    }

    public synchronized <T> void prepend(@NonNull Class<T> r10, @NonNull Encoder<T> r11) {
        monitor-enter(this);
        this.encoders.add(0, new Entry(r10, r11));     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }
}
