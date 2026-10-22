package org.apache.http.impl.pool;

import java.util.concurrent.atomic.AtomicLong;
import org.apache.http.HttpClientConnection;
import org.apache.http.HttpHost;
import org.apache.http.annotation.Contract;
import org.apache.http.annotation.ThreadingBehavior;
import org.apache.http.config.ConnectionConfig;
import org.apache.http.config.SocketConfig;
import org.apache.http.params.HttpParams;
import org.apache.http.pool.AbstractConnPool;
import org.apache.http.pool.ConnFactory;
import org.apache.http.pool.PoolEntry;

/* JADX INFO: loaded from: classes4.dex */
@Contract(threading = ThreadingBehavior.SAFE_CONDITIONAL)
public class BasicConnPool extends AbstractConnPool<HttpHost, HttpClientConnection, BasicPoolEntry> {
    private static final AtomicLong COUNTER = null;

    static {
        COUNTER = new AtomicLong();
    }

    public BasicConnPool(ConnFactory<HttpHost, HttpClientConnection> r10) {
        super(r10, 2, 20);
    }

    @Override // org.apache.http.pool.AbstractConnPool
    public /* bridge */ /* synthetic */ PoolEntry createEntry(HttpHost r10, HttpClientConnection r11) {
        return createEntry2(r10, r11);
    }

    @Override // org.apache.http.pool.AbstractConnPool
    public /* bridge */ /* synthetic */ boolean validate(PoolEntry r10) {
        return validate((BasicPoolEntry) r10);
    }

    @Deprecated
    public BasicConnPool(HttpParams r10) {
        super(new BasicConnFactory(r10), 2, 20);
    }

    /* JADX INFO: renamed from: createEntry, reason: avoid collision after fix types in other method */
    public BasicPoolEntry createEntry2(HttpHost r10, HttpClientConnection r11) {
        return new BasicPoolEntry(Long.toString(COUNTER.getAndIncrement()), r10, r11);
    }

    public boolean validate(BasicPoolEntry r10) {
        return !r10.getConnection().isStale();
    }

    public BasicConnPool(SocketConfig r10, ConnectionConfig r11) {
        super(new BasicConnFactory(r10, r11), 2, 20);
    }

    public BasicConnPool() {
        super(new BasicConnFactory(SocketConfig.DEFAULT, ConnectionConfig.DEFAULT), 2, 20);
    }
}
