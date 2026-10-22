package com.bumptech.glide.provider;

import androidx.annotation.NonNull;
import com.bumptech.glide.load.ImageHeaderParser;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class ImageHeaderParserRegistry {
    private final List<ImageHeaderParser> parsers;

    public ImageHeaderParserRegistry() {
        this.parsers = new ArrayList();
    }

    public synchronized void add(@NonNull ImageHeaderParser r10) {
        monitor-enter(this);
        this.parsers.add(r10);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    @NonNull
    public synchronized List<ImageHeaderParser> getParsers() {
        monitor-enter(this);
        List<ImageHeaderParser> r10 = this.parsers;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r10;
    L6:
        th = move-exception;
        throw th;
    }
}
