package org.apache.commons.compress.utils;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.ServiceConfigurationError;
import java.util.ServiceLoader;

/* JADX INFO: loaded from: classes3.dex */
public class ServiceLoaderIterator<E> implements Iterator<E> {
    private E nextServiceLoader;
    private final Class<E> service;
    private final Iterator<E> serviceLoaderIterator;

    public ServiceLoaderIterator(Class<E> service) {
        this(service, ClassLoader.getSystemClassLoader());
    }

    public ServiceLoaderIterator(Class<E> service, ClassLoader classLoader) {
        this.service = service;
        ServiceLoader<E> serviceLoader = ServiceLoader.load(service, classLoader);
        this.serviceLoaderIterator = serviceLoader.iterator();
        this.nextServiceLoader = null;
    }

    private boolean getNextServiceLoader() {
    L3:
        if (this.nextServiceLoader != null) goto L15;
    L10:
        e = move-exception;
        if ((e.getCause() instanceof SecurityException) == true) goto L3;
        throw e;
    L5:
        if (this.serviceLoaderIterator.hasNext() == false) goto L6;
        this.nextServiceLoader = this.serviceLoaderIterator.next();     // Catch: ServiceConfigurationError -> L10
        goto L3
    L6:
        return false;
    L15:
        return true;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return getNextServiceLoader();
    }

    @Override // java.util.Iterator
    public E next() {
        if (getNextServiceLoader() == false) goto L7;
        E tempNext = this.nextServiceLoader;
        this.nextServiceLoader = null;
        return tempNext;
    L7:
        throw new NoSuchElementException("No more elements for service " + this.service.getName());
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("service=" + this.service.getName());
    }
}
