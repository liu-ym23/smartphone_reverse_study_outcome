package com.bytedance.android.gamecp.common.utils.rx.autodispose;

/* JADX INFO: loaded from: classes44.dex */
public class OutsideScopeException extends RuntimeException {
    @Override // java.lang.Throwable
    public final synchronized Throwable fillInStackTrace() {
        monitor-enter(this);
        monitor-exit(this);
        return this;
    }

    public OutsideScopeException(String r100) {
        super(r100);
    }
}
