package com.android.server.pm;

import java.io.File;

/* JADX INFO: loaded from: classes2.dex */
final class OriginInfo {
    final boolean mExisting;
    final File mFile;
    final File mResolvedFile;
    final String mResolvedPath;
    final boolean mStaged;

    static OriginInfo fromNothing() {
        return new OriginInfo(null, false, false);
    }

    static OriginInfo fromExistingFile(File file) {
        return new OriginInfo(file, false, true);
    }

    static OriginInfo fromStagedFile(File file) {
        return new OriginInfo(file, true, false);
    }

    private OriginInfo(File file, boolean staged, boolean existing) {
        this.mFile = file;
        this.mStaged = staged;
        this.mExisting = existing;
        if (file == null) goto L5;
        this.mResolvedPath = file.getAbsolutePath();
        this.mResolvedFile = file;
        return;
    L5:
        this.mResolvedPath = null;
        this.mResolvedFile = null;
    }
}
