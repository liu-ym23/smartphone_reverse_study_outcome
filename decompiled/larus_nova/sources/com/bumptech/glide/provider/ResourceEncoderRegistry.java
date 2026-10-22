package com.bumptech.glide.provider;

import com.bumptech.glide.load.ResourceEncoder;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes39.dex */
public class ResourceEncoderRegistry {
    private final List<Entry<?>> encoders;

    public static final class Entry<T> {
        final ResourceEncoder<T> encoder;
        private final Class<T> resourceClass;

        public boolean handles(Class<?> r100) {
            return this.resourceClass.isAssignableFrom(r100);
        }

        public Entry(Class<T> r100, ResourceEncoder<T> r101) {
            this.resourceClass = r100;
            this.encoder = r101;
        }
    }

    public ResourceEncoderRegistry() {
        this.encoders = new ArrayList();
    }

    public synchronized <Z> ResourceEncoder<Z> get(Class<Z> r100) {
        monitor-enter(this);
        int r101 = this.encoders.size();     // Catch: Throwable -> L14
        int r102 = 0;
    L4:
        if (r102 >= r101) goto L11;
        Entry r103 = (Entry) ListProtector.get(this.encoders, r102);     // Catch: Throwable -> L14
        if (r103.handles(r100) == true) goto L7;
        r102 = r102 + 1;
        goto L4
    L7:
        ResourceEncoder<Z> r104 = (ResourceEncoder<Z>) r103.encoder;
        monitor-exit(this);
        return r104;
    L11:
        monitor-exit(this);
        return null;
    L14:
        th = move-exception;
        throw th;
    }

    public synchronized <Z> void append(Class<Z> r100, ResourceEncoder<Z> r101) {
        monitor-enter(this);
        this.encoders.add(new Entry(r100, r101));     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized <Z> void prepend(Class<Z> r100, ResourceEncoder<Z> r101) {
        monitor-enter(this);
        ListProtector.add(this.encoders, 0, new Entry(r100, r101));     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }
}
