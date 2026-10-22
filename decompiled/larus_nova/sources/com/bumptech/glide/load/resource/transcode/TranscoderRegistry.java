package com.bumptech.glide.load.resource.transcode;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes39.dex */
public class TranscoderRegistry {
    private final List<Entry<?, ?>> transcoders;

    public static final class Entry<Z, R> {
        private final Class<Z> fromClass;
        private final Class<R> toClass;
        final ResourceTranscoder<Z, R> transcoder;

        public boolean handles(Class<?> r100, Class<?> r101) {
            if (this.fromClass.isAssignableFrom(r100) == true) goto L5;
        L7:
            return false;
        L5:
            if (r101.isAssignableFrom(this.toClass) == false) goto L7;
            return true;
        }

        public Entry(Class<Z> r100, Class<R> r101, ResourceTranscoder<Z, R> r102) {
            this.fromClass = r100;
            this.toClass = r101;
            this.transcoder = r102;
        }
    }

    public TranscoderRegistry() {
        this.transcoders = new ArrayList();
    }

    public synchronized <Z, R> ResourceTranscoder<Z, R> get(Class<Z> r100, Class<R> r101) {
        monitor-enter(this);
    L20:
        th = move-exception;
        throw th;
    L4:
        if (r101.isAssignableFrom(r100) == false) goto L8;
        ResourceTranscoder<Z, R> r102 = UnitTranscoder.get();     // Catch: Throwable -> L20
        monitor-exit(this);
        return r102;
    L8:
        Iterator<Entry<?, ?>> r103 = this.transcoders.iterator();     // Catch: Throwable -> L20
    L10:
        if (r103.hasNext() == false) goto L19;
        Entry<?, ?> r104 = r103.next();     // Catch: Throwable -> L20
        if (r104 == null) goto L10;
        if (r104.handles(r100, r101) == false) goto L10;
        ResourceTranscoder<Z, R> r105 = (ResourceTranscoder<Z, R>) r104.transcoder;
        monitor-exit(this);
        return r105;
    L19:
        throw new IllegalArgumentException("No transcoder registered to transcode from " + r100 + " to " + r101);     // Catch: Throwable -> L20
    }

    public synchronized <Z, R> List<Class<R>> getTranscodeClasses(Class<Z> r100, Class<R> r101) {
        monitor-enter(this);
        ArrayList r102 = new ArrayList();     // Catch: Throwable -> L17
        if (r101.isAssignableFrom(r100) == false) goto L8;
        r102.add(r101);     // Catch: Throwable -> L17
        monitor-exit(this);
        return r102;
    L8:
        Iterator<Entry<?, ?>> r103 = this.transcoders.iterator();     // Catch: Throwable -> L17
    L10:
        if (r103.hasNext() == false) goto L15;
        if (r103.next().handles(r100, r101) == false) goto L10;
        r102.add(r101);     // Catch: Throwable -> L17
        goto L10
    L15:
        monitor-exit(this);
        return r102;
    L17:
        th = move-exception;
        throw th;
    }

    public synchronized <Z, R> void register(Class<Z> r100, Class<R> r101, ResourceTranscoder<Z, R> r102) {
        monitor-enter(this);
        this.transcoders.add(new Entry(r100, r101, r102));     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized <Z, R> void registerAtHead(Class<Z> r100, Class<R> r101, ResourceTranscoder<Z, R> r102) {
        monitor-enter(this);
        ListProtector.add(this.transcoders, 0, new Entry(r100, r101, r102));     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }
}
