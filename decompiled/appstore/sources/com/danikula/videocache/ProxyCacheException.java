package com.danikula.videocache;

/* JADX INFO: loaded from: classes2.dex */
public class ProxyCacheException extends Exception {
    private static final String LIBRARY_VERSION = ". Version: 1.0";

    public ProxyCacheException(String r10) {
        super(r10 + LIBRARY_VERSION);
    }

    public ProxyCacheException(String r10, Throwable r11) {
        super(r10 + LIBRARY_VERSION, r11);
    }

    public ProxyCacheException(Throwable r10) {
        super("No explanation error. Version: 1.0", r10);
    }
}
