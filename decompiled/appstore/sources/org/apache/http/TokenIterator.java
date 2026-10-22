package org.apache.http;

import java.util.Iterator;

/* JADX INFO: loaded from: classes4.dex */
public interface TokenIterator extends Iterator<Object> {
    @Override // java.util.Iterator
    boolean hasNext();

    String nextToken();
}
