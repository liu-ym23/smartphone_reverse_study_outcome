package org.apache.http.protocol;

/* JADX INFO: loaded from: classes4.dex */
@Deprecated
public class SyncBasicHttpContext extends BasicHttpContext {
    public SyncBasicHttpContext(HttpContext r10) {
        super(r10);
    }

    @Override // org.apache.http.protocol.BasicHttpContext
    public synchronized void clear() {
        monitor-enter(this);
        super.clear();     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // org.apache.http.protocol.BasicHttpContext, org.apache.http.protocol.HttpContext
    public synchronized Object getAttribute(String r10) {
        monitor-enter(this);
        Object r11 = super.getAttribute(r10);     // Catch: Throwable -> L6
        monitor-exit(this);
        return r11;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // org.apache.http.protocol.BasicHttpContext, org.apache.http.protocol.HttpContext
    public synchronized Object removeAttribute(String r10) {
        monitor-enter(this);
        Object r11 = super.removeAttribute(r10);     // Catch: Throwable -> L6
        monitor-exit(this);
        return r11;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // org.apache.http.protocol.BasicHttpContext, org.apache.http.protocol.HttpContext
    public synchronized void setAttribute(String r10, Object r11) {
        monitor-enter(this);
        super.setAttribute(r10, r11);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public SyncBasicHttpContext() {
    }
}
