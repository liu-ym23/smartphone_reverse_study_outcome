package com.jeffmony.async;

/* JADX INFO: loaded from: classes3.dex */
public class AsyncSSLException extends Exception {
    private boolean mIgnore;

    public AsyncSSLException(Throwable r10) {
        super("Peer not trusted by any of the system trust managers.", r10);
        this.mIgnore = false;
    }

    public boolean getIgnore() {
        return this.mIgnore;
    }

    public void setIgnore(boolean r10) {
        this.mIgnore = r10;
    }
}
