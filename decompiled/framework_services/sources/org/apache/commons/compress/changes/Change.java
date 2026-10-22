package org.apache.commons.compress.changes;

import java.io.InputStream;
import org.apache.commons.compress.archivers.ArchiveEntry;

/* JADX INFO: loaded from: classes3.dex */
class Change {
    static final int TYPE_ADD = 2;
    static final int TYPE_DELETE = 1;
    static final int TYPE_DELETE_DIR = 4;
    static final int TYPE_MOVE = 3;
    private final ArchiveEntry entry;
    private final InputStream input;
    private final boolean replaceMode;
    private final String targetFile;
    private final int type;

    Change(String pFilename, int type) {
        if (pFilename == null) goto L7;
        this.targetFile = pFilename;
        this.type = type;
        this.input = null;
        this.entry = null;
        this.replaceMode = true;
        return;
    L7:
        throw new NullPointerException();
    }

    Change(ArchiveEntry pEntry, InputStream pInput, boolean replace) {
        if (pEntry == null) goto L8;
        if (pInput == null) goto L8;
        this.entry = pEntry;
        this.input = pInput;
        this.type = 2;
        this.targetFile = null;
        this.replaceMode = replace;
        return;
    L8:
        throw new NullPointerException();
    }

    ArchiveEntry getEntry() {
        return this.entry;
    }

    InputStream getInput() {
        return this.input;
    }

    String targetFile() {
        return this.targetFile;
    }

    int type() {
        return this.type;
    }

    boolean isReplaceMode() {
        return this.replaceMode;
    }
}
