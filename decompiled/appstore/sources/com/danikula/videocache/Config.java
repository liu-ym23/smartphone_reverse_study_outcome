package com.danikula.videocache;

import com.danikula.videocache.file.DiskUsage;
import com.danikula.videocache.file.FileNameGenerator;
import com.danikula.videocache.headers.HeaderInjector;
import com.danikula.videocache.sourcestorage.SourceInfoStorage;
import java.io.File;

/* JADX INFO: loaded from: classes2.dex */
class Config {
    public final File cacheRoot;
    public final DiskUsage diskUsage;
    public final FileNameGenerator fileNameGenerator;
    public final HeaderInjector headerInjector;
    public final SourceInfoStorage sourceInfoStorage;

    public Config(File r10, FileNameGenerator r11, DiskUsage r12, SourceInfoStorage r13, HeaderInjector r14) {
        this.cacheRoot = r10;
        this.fileNameGenerator = r11;
        this.diskUsage = r12;
        this.sourceInfoStorage = r13;
        this.headerInjector = r14;
    }

    public File generateCacheFile(String r10) {
        String r11 = this.fileNameGenerator.generate(r10);
        return new File(this.cacheRoot, r11);
    }
}
