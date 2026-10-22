package org.apache.http.params;

import org.apache.http.annotation.Contract;
import org.apache.http.annotation.ThreadingBehavior;

/* JADX INFO: loaded from: classes4.dex */
@Contract(threading = ThreadingBehavior.SAFE)
@Deprecated
public class SyncBasicHttpParams extends BasicHttpParams {
    private static final long serialVersionUID = 5387834869062660642L;

    public SyncBasicHttpParams() {
    }

    @Override // org.apache.http.params.BasicHttpParams
    public synchronized void clear() {
        monitor-enter(this);
        super.clear();     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // org.apache.http.params.BasicHttpParams
    public synchronized Object clone() throws CloneNotSupportedException {
        monitor-enter(this);
        Object r10 = super.clone();     // Catch: Throwable -> L6
        monitor-exit(this);
        return r10;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // org.apache.http.params.BasicHttpParams, org.apache.http.params.HttpParams
    public synchronized Object getParameter(String r10) {
        monitor-enter(this);
        Object r11 = super.getParameter(r10);     // Catch: Throwable -> L6
        monitor-exit(this);
        return r11;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // org.apache.http.params.BasicHttpParams
    public synchronized boolean isParameterSet(String r10) {
        monitor-enter(this);
        boolean r11 = super.isParameterSet(r10);     // Catch: Throwable -> L6
        monitor-exit(this);
        return r11;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // org.apache.http.params.BasicHttpParams
    public synchronized boolean isParameterSetLocally(String r10) {
        monitor-enter(this);
        boolean r11 = super.isParameterSetLocally(r10);     // Catch: Throwable -> L6
        monitor-exit(this);
        return r11;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // org.apache.http.params.BasicHttpParams, org.apache.http.params.HttpParams
    public synchronized boolean removeParameter(String r10) {
        monitor-enter(this);
        boolean r11 = super.removeParameter(r10);     // Catch: Throwable -> L6
        monitor-exit(this);
        return r11;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // org.apache.http.params.BasicHttpParams, org.apache.http.params.HttpParams
    public synchronized HttpParams setParameter(String r10, Object r11) {
        monitor-enter(this);
        HttpParams r12 = super.setParameter(r10, r11);     // Catch: Throwable -> L6
        monitor-exit(this);
        return r12;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // org.apache.http.params.BasicHttpParams
    public synchronized void setParameters(String[] r10, Object r11) {
        monitor-enter(this);
        super.setParameters(r10, r11);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }
}
