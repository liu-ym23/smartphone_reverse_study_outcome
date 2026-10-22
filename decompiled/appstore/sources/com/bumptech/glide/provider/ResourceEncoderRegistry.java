package com.bumptech.glide.provider;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.load.ResourceEncoder;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class ResourceEncoderRegistry {
    private final List<Entry<?>> encoders;

    public static final class Entry<T> {
        final ResourceEncoder<T> encoder;
        private final Class<T> resourceClass;

        public Entry(@NonNull Class<T> r10, @NonNull ResourceEncoder<T> r11) {
            this.resourceClass = r10;
            this.encoder = r11;
        }

        public boolean handles(@NonNull Class<?> r10) {
            return this.resourceClass.isAssignableFrom(r10);
        }
    }

    public ResourceEncoderRegistry() {
        this.encoders = new ArrayList();
    }

    public synchronized <Z> void append(@NonNull Class<Z> r10, @NonNull ResourceEncoder<Z> r11) {
        monitor-enter(this);
        this.encoders.add(new Entry(r10, r11));     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    @Nullable
    public synchronized <Z> ResourceEncoder<Z> get(@NonNull Class<Z> r10) {
        monitor-enter(this);
        int r11 = this.encoders.size();     // Catch: Throwable -> L10
        int r12 = 0;
    L4:
        if (r12 >= r11) goto L13;
        Entry<?> r13 = this.encoders.get(r12);     // Catch: Throwable -> L10
        if (r13.handles(r10) == true) goto L7;
        r12 = r12 + 1;
        goto L4
    L7:
        ResourceEncoder<Z> r14 = (ResourceEncoder<Z>) r13.encoder;
        monitor-exit(this);
        return r14;
    L13:
        monitor-exit(this);
        return null;
    L10:
        th = move-exception;
        throw th;
    }

    public synchronized <Z> void prepend(@NonNull Class<Z> r10, @NonNull ResourceEncoder<Z> r11) {
        monitor-enter(this);
        this.encoders.add(0, new Entry(r10, r11));     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }
}
