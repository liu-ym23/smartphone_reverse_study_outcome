package com.bumptech.glide.load.resource.transcode;

import androidx.annotation.NonNull;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class TranscoderRegistry {
    private final List<Entry<?, ?>> transcoders;

    public static final class Entry<Z, R> {
        private final Class<Z> fromClass;
        private final Class<R> toClass;
        final ResourceTranscoder<Z, R> transcoder;

        public Entry(@NonNull Class<Z> r10, @NonNull Class<R> r11, @NonNull ResourceTranscoder<Z, R> r12) {
            this.fromClass = r10;
            this.toClass = r11;
            this.transcoder = r12;
        }

        public boolean handles(@NonNull Class<?> r10, @NonNull Class<?> r11) {
            if (this.fromClass.isAssignableFrom(r10) == true) goto L5;
        L7:
            return false;
        L5:
            if (r11.isAssignableFrom(this.toClass) == false) goto L7;
            return true;
        }
    }

    public TranscoderRegistry() {
        this.transcoders = new ArrayList();
    }

    @NonNull
    public synchronized <Z, R> ResourceTranscoder<Z, R> get(@NonNull Class<Z> r10, @NonNull Class<R> r11) {
        monitor-enter(this);
    L8:
        th = move-exception;
        throw th;
    L4:
        if (r11.isAssignableFrom(r10) == false) goto L10;
        ResourceTranscoder<Z, R> r12 = UnitTranscoder.get();     // Catch: Throwable -> L8
        monitor-exit(this);
        return r12;
    L10:
        Iterator<Entry<?, ?>> r13 = this.transcoders.iterator();     // Catch: Throwable -> L8
    L12:
        if (r13.hasNext() == false) goto L19;
        Entry<?, ?> r14 = r13.next();     // Catch: Throwable -> L8
        if (r14.handles(r10, r11) == false) goto L12;
        ResourceTranscoder<Z, R> r15 = (ResourceTranscoder<Z, R>) r14.transcoder;
        monitor-exit(this);
        return r15;
    L19:
        throw new IllegalArgumentException("No transcoder registered to transcode from " + r10 + " to " + r11);     // Catch: Throwable -> L8
    }

    @NonNull
    public synchronized <Z, R> List<Class<R>> getTranscodeClasses(@NonNull Class<Z> r10, @NonNull Class<R> r11) {
        monitor-enter(this);
        ArrayList r12 = new ArrayList();     // Catch: Throwable -> L8
        if (r11.isAssignableFrom(r10) == false) goto L10;
        r12.add(r11);     // Catch: Throwable -> L8
        monitor-exit(this);
        return r12;
    L10:
        Iterator<Entry<?, ?>> r13 = this.transcoders.iterator();     // Catch: Throwable -> L8
    L12:
        if (r13.hasNext() == false) goto L17;
        if (r13.next().handles(r10, r11) == false) goto L12;
        r12.add(r11);     // Catch: Throwable -> L8
        goto L12
    L17:
        monitor-exit(this);
        return r12;
    L8:
        th = move-exception;
        throw th;
    }

    public synchronized <Z, R> void register(@NonNull Class<Z> r10, @NonNull Class<R> r11, @NonNull ResourceTranscoder<Z, R> r12) {
        monitor-enter(this);
        this.transcoders.add(new Entry(r10, r11, r12));     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }
}
