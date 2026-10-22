package org.apache.http.pool;

import java.io.IOException;

/* JADX INFO: loaded from: classes4.dex */
public interface ConnFactory<T, C> {
    C create(T r10) throws IOException;
}
