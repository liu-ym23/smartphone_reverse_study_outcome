package com.ttnet.org.chromium.base.library_loader;

/* JADX INFO: loaded from: classes4.dex */
public class ProcessInitException extends RuntimeException {
    public ProcessInitException(int r10) {
        super("errorCode=" + r10);
    }

    public ProcessInitException(int r10, Throwable r11) {
        super("errorCode=" + r10, r11);
    }
}
