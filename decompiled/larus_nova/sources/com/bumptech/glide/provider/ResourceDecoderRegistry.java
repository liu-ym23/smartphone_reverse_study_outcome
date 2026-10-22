package com.bumptech.glide.provider;

import com.bumptech.glide.load.ResourceDecoder;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes39.dex */
public class ResourceDecoderRegistry {
    private final List<String> bucketPriorityList;
    private final Map<String, List<Entry<?, ?>>> decoders;

    public static class Entry<T, R> {
        private final Class<T> dataClass;
        final ResourceDecoder<T, R> decoder;
        final Class<R> resourceClass;

        public boolean handles(Class<?> r100, Class<?> r101) {
            if (this.dataClass.isAssignableFrom(r100) == true) goto L5;
        L7:
            return false;
        L5:
            if (r101.isAssignableFrom(this.resourceClass) == false) goto L7;
            return true;
        }

        public Entry(Class<T> r100, Class<R> r101, ResourceDecoder<T, R> r102) {
            this.dataClass = r100;
            this.resourceClass = r101;
            this.decoder = r102;
        }
    }

    public ResourceDecoderRegistry() {
        this.bucketPriorityList = new ArrayList();
        this.decoders = new HashMap();
    }

    private synchronized List<Entry<?, ?>> getOrAddEntryList(String r100) {
        monitor-enter(this);
    L11:
        th = move-exception;
        throw th;
    L4:
        if (this.bucketPriorityList.contains(r100) == true) goto L6;
        this.bucketPriorityList.add(r100);     // Catch: Throwable -> L11
    L6:
        List<Entry<?, ?>> r101 = this.decoders.get(r100);     // Catch: Throwable -> L11
        if (r101 != null) goto L9;
        r101 = new ArrayList();     // Catch: Throwable -> L11
        this.decoders.put(r100, r101);     // Catch: Throwable -> L11
    L9:
        monitor-exit(this);
        return r101;
    }

    public synchronized void setBucketPriorityList(List<String> r100) {
        monitor-enter(this);
        ArrayList r101 = new ArrayList(this.bucketPriorityList);     // Catch: Throwable -> L16
        this.bucketPriorityList.clear();     // Catch: Throwable -> L16
        Iterator<String> r102 = r100.iterator();     // Catch: Throwable -> L16
    L5:
        if (r102.hasNext() == false) goto L7;
        String r103 = r102.next();     // Catch: Throwable -> L16
        this.bucketPriorityList.add(r103);     // Catch: Throwable -> L16
        goto L5
    L7:
        Iterator r104 = r101.iterator();     // Catch: Throwable -> L16
    L8:
        if (r104.hasNext() == false) goto L14;
        String r105 = (String) r104.next();     // Catch: Throwable -> L16
        if (r100.contains(r105) == true) goto L8;
        this.bucketPriorityList.add(r105);     // Catch: Throwable -> L16
        goto L8
    L14:
        monitor-exit(this);
        return;
    L16:
        th = move-exception;
        throw th;
    }

    public synchronized <T, R> List<ResourceDecoder<T, R>> getDecoders(Class<T> r100, Class<R> r101) {
        monitor-enter(this);
        ArrayList r102 = new ArrayList();     // Catch: Throwable -> L18
        Iterator<String> r103 = this.bucketPriorityList.iterator();     // Catch: Throwable -> L18
    L5:
        if (r103.hasNext() == false) goto L16;
        String r104 = r103.next();     // Catch: Throwable -> L18
        List<Entry<?, ?>> r105 = this.decoders.get(r104);     // Catch: Throwable -> L18
        if (r105 == null) goto L5;
        Iterator<Entry<?, ?>> r106 = r105.iterator();     // Catch: Throwable -> L18
    L11:
        if (r106.hasNext() == false) goto L5;
        Entry<?, ?> r107 = r106.next();     // Catch: Throwable -> L18
        if (r107.handles(r100, r101) == false) goto L11;
        r102.add(r107.decoder);     // Catch: Throwable -> L18
        goto L11
    L16:
        monitor-exit(this);
        return r102;
    L18:
        th = move-exception;
        throw th;
    }

    public synchronized <T, R> List<Class<R>> getResourceClasses(Class<T> r100, Class<R> r101) {
        monitor-enter(this);
        ArrayList r102 = new ArrayList();     // Catch: Throwable -> L20
        Iterator<String> r103 = this.bucketPriorityList.iterator();     // Catch: Throwable -> L20
    L5:
        if (r103.hasNext() == false) goto L18;
        String r104 = r103.next();     // Catch: Throwable -> L20
        List<Entry<?, ?>> r105 = this.decoders.get(r104);     // Catch: Throwable -> L20
        if (r105 == null) goto L5;
        Iterator<Entry<?, ?>> r106 = r105.iterator();     // Catch: Throwable -> L20
    L11:
        if (r106.hasNext() == false) goto L5;
        Entry<?, ?> r107 = r106.next();     // Catch: Throwable -> L20
        if (r107.handles(r100, r101) == false) goto L11;
        if (r102.contains(r107.resourceClass) == true) goto L11;
        r102.add(r107.resourceClass);     // Catch: Throwable -> L20
        goto L11
    L18:
        monitor-exit(this);
        return r102;
    L20:
        th = move-exception;
        throw th;
    }

    public synchronized <T, R> void append(String r100, ResourceDecoder<T, R> r101, Class<T> r102, Class<R> r103) {
        monitor-enter(this);
        getOrAddEntryList(r100).add(new Entry(r102, r103, r101));     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized <T, R> void prepend(String r100, ResourceDecoder<T, R> r101, Class<T> r102, Class<R> r103) {
        monitor-enter(this);
        ListProtector.add(getOrAddEntryList(r100), 0, new Entry(r102, r103, r101));     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }
}
