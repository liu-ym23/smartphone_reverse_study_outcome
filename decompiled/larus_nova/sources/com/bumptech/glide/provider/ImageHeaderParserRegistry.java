package com.bumptech.glide.provider;

import com.bumptech.glide.load.ImageHeaderParser;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes39.dex */
public final class ImageHeaderParserRegistry {
    private final List<ImageHeaderParser> parsers;

    public synchronized List<ImageHeaderParser> getParsers() {
        monitor-enter(this);
        List<ImageHeaderParser> r100 = this.parsers;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r100;
    L6:
        th = move-exception;
        throw th;
    }

    public ImageHeaderParserRegistry() {
        this.parsers = new ArrayList();
    }

    public synchronized void add(ImageHeaderParser r100) {
        monitor-enter(this);
        this.parsers.add(r100);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }
}
