package com.bumptech.glide.provider;

import androidx.annotation.NonNull;
import com.bumptech.glide.load.ResourceDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class ResourceDecoderRegistry {
    private final List<String> bucketPriorityList;
    private final Map<String, List<Entry<?, ?>>> decoders;

    public static class Entry<T, R> {
        private final Class<T> dataClass;
        final ResourceDecoder<T, R> decoder;
        final Class<R> resourceClass;

        public Entry(@NonNull Class<T> r10, @NonNull Class<R> r11, ResourceDecoder<T, R> r12) {
            this.dataClass = r10;
            this.resourceClass = r11;
            this.decoder = r12;
        }

        public boolean handles(@NonNull Class<?> r10, @NonNull Class<?> r11) {
            if (this.dataClass.isAssignableFrom(r10) == true) goto L5;
        L7:
            return false;
        L5:
            if (r11.isAssignableFrom(this.resourceClass) == false) goto L7;
            return true;
        }
    }

    public ResourceDecoderRegistry() {
        this.bucketPriorityList = new ArrayList();
        this.decoders = new HashMap();
    }

    @NonNull
    private synchronized List<Entry<?, ?>> getOrAddEntryList(@NonNull String r10) {
        monitor-enter(this);
    L6:
        th = move-exception;
        throw th;
    L4:
        if (this.bucketPriorityList.contains(r10) == true) goto L8;
        this.bucketPriorityList.add(r10);     // Catch: Throwable -> L6
    L8:
        List<Entry<?, ?>> r11 = this.decoders.get(r10);     // Catch: Throwable -> L6
        if (r11 != null) goto L11;
        r11 = new ArrayList();     // Catch: Throwable -> L6
        this.decoders.put(r10, r11);     // Catch: Throwable -> L6
    L11:
        monitor-exit(this);
        return r11;
    }

    public synchronized <T, R> void append(@NonNull String r10, @NonNull ResourceDecoder<T, R> r11, @NonNull Class<T> r12, @NonNull Class<R> r13) {
        monitor-enter(this);
        getOrAddEntryList(r10).add(new Entry(r12, r13, r11));     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    @NonNull
    public synchronized <T, R> List<ResourceDecoder<T, R>> getDecoders(@NonNull Class<T> r10, @NonNull Class<R> r11) {
        monitor-enter(this);
        ArrayList r12 = new ArrayList();     // Catch: Throwable -> L16
        Iterator<String> r13 = this.bucketPriorityList.iterator();     // Catch: Throwable -> L16
    L5:
        if (r13.hasNext() == false) goto L18;
        String r14 = r13.next();     // Catch: Throwable -> L16
        List<Entry<?, ?>> r15 = this.decoders.get(r14);     // Catch: Throwable -> L16
        if (r15 == null) goto L5;
        Iterator<Entry<?, ?>> r16 = r15.iterator();     // Catch: Throwable -> L16
    L11:
        if (r16.hasNext() == false) goto L5;
        Entry<?, ?> r17 = r16.next();     // Catch: Throwable -> L16
        if (r17.handles(r10, r11) == false) goto L11;
        r12.add(r17.decoder);     // Catch: Throwable -> L16
        goto L11
    L18:
        monitor-exit(this);
        return r12;
    L16:
        th = move-exception;
        throw th;
    }

    @NonNull
    public synchronized <T, R> List<Class<R>> getResourceClasses(@NonNull Class<T> r10, @NonNull Class<R> r11) {
        monitor-enter(this);
        ArrayList r12 = new ArrayList();     // Catch: Throwable -> L18
        Iterator<String> r13 = this.bucketPriorityList.iterator();     // Catch: Throwable -> L18
    L5:
        if (r13.hasNext() == false) goto L20;
        String r14 = r13.next();     // Catch: Throwable -> L18
        List<Entry<?, ?>> r15 = this.decoders.get(r14);     // Catch: Throwable -> L18
        if (r15 == null) goto L5;
        Iterator<Entry<?, ?>> r16 = r15.iterator();     // Catch: Throwable -> L18
    L11:
        if (r16.hasNext() == false) goto L5;
        Entry<?, ?> r17 = r16.next();     // Catch: Throwable -> L18
        if (r17.handles(r10, r11) == false) goto L11;
        if (r12.contains(r17.resourceClass) == true) goto L11;
        r12.add(r17.resourceClass);     // Catch: Throwable -> L18
        goto L11
    L20:
        monitor-exit(this);
        return r12;
    L18:
        th = move-exception;
        throw th;
    }

    public synchronized <T, R> void prepend(@NonNull String r10, @NonNull ResourceDecoder<T, R> r11, @NonNull Class<T> r12, @NonNull Class<R> r13) {
        monitor-enter(this);
        getOrAddEntryList(r10).add(0, new Entry(r12, r13, r11));     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized void setBucketPriorityList(@NonNull List<String> r10) {
        monitor-enter(this);
        ArrayList r11 = new ArrayList(this.bucketPriorityList);     // Catch: Throwable -> L10
        this.bucketPriorityList.clear();     // Catch: Throwable -> L10
        this.bucketPriorityList.addAll(r10);     // Catch: Throwable -> L10
        Iterator r12 = r11.iterator();     // Catch: Throwable -> L10
    L5:
        if (r12.hasNext() == false) goto L12;
        String r13 = (String) r12.next();     // Catch: Throwable -> L10
        if (r10.contains(r13) == true) goto L5;
        this.bucketPriorityList.add(r13);     // Catch: Throwable -> L10
        goto L5
    L12:
        monitor-exit(this);
        return;
    L10:
        th = move-exception;
        throw th;
    }
}
