package com.google.common.collect;

import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
public interface PeekingIterator<E> extends Iterator<E> {
    E next();

    E peek();

    @Override // java.util.Iterator
    void remove();
}
