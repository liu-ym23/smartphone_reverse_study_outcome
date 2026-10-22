package com.android.server.net.watchlist;

import com.android.internal.util.HexDump;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
class HarmfulDigests {
    private final Set<String> mDigestSet;

    HarmfulDigests(List<byte[]> digests) {
        HashSet<String> tmpDigestSet = new HashSet();
        int size = digests.size();
        int i = 0;
    L3:
        if (i >= size) goto L5;
        tmpDigestSet.add(HexDump.toHexString(digests.get(i)));
        i = i + 1;
        goto L3
    L5:
        this.mDigestSet = Collections.unmodifiableSet(tmpDigestSet);
    }

    public boolean contains(byte[] digest) {
        return this.mDigestSet.contains(HexDump.toHexString(digest));
    }

    public void dump(FileDescriptor fd, PrintWriter pw, String[] args) {
        Iterator<String> r0 = this.mDigestSet.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        String digest = r0.next();
        pw.println(digest);
        goto L4
    L6:
        pw.println("");
    }
}
