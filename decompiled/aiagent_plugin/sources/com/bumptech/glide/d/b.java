package com.bumptech.glide.d;

import com.bumptech.glide.load.ImageHeaderParser;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: ImageHeaderParserRegistry.java */
/* JADX INFO: loaded from: classes.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List<ImageHeaderParser> f3280a;

    public b() {
        this.f3280a = new ArrayList();
    }

    public synchronized List<ImageHeaderParser> a() {
        monitor-enter(this);
        List<ImageHeaderParser> r0 = this.f3280a;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized void a(ImageHeaderParser r3) {
        monitor-enter(this);
        ImageHeaderParser r4 = (ImageHeaderParser) ZeusTransformUtils.wrapperContextForParams(r3, ImageHeaderParser.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L6
        this.f3280a.add(r4);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }
}
