package com.android.server.pinner;

import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
public final class PinnedFile implements AutoCloseable {
    public final long bytesPinned;
    final String fileName;
    String groupName;
    private long mAddress;
    final long mapSize;
    ArrayList<PinnedFile> pinnedDeps;
    boolean used_pinlist;

    public PinnedFile(long address, long mapSize, String fileName, long bytesPinned) {
        this.groupName = "";
        this.pinnedDeps = new ArrayList();
        this.mAddress = address;
        this.mapSize = mapSize;
        this.fileName = fileName;
        this.bytesPinned = bytesPinned;
    }

    @Override // java.lang.AutoCloseable
    public void close() {
        if (this.mAddress < 0) goto L5;
        PinnerUtils.safeMunmap(this.mAddress, this.mapSize);
        this.mAddress = -1;
    L5:
        Iterator<PinnedFile> r0 = this.pinnedDeps.iterator();
    L7:
        if (r0.hasNext() == false) goto L12;
        PinnedFile dep = r0.next();
        if (dep == null) goto L7;
        dep.close();
        goto L7
    }

    public void finalize() {
        close();
    }
}
