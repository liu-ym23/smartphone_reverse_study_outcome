package com.android.server.net.watchlist;

import android.hardware.tv.hdmi.cec.CecDeviceType;
import com.android.internal.util.HexDump;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
class HarmfulCrcs {
    private final Set<Integer> mCrcSet;

    HarmfulCrcs(List<byte[]> digests) {
        HashSet<Integer> crcSet = new HashSet();
        int size = digests.size();
        int i = 0;
    L3:
        if (i >= size) goto L11;
        byte[] bytes = digests.get(i);
        if (bytes.length > 4) goto L10;
        int crc = 0;
        int r5 = bytes.length;
        int r6 = 0;
    L7:
        if (r6 >= r5) goto L9;
        byte b = bytes[r6];
        crc = (crc << 8) | (b & CecDeviceType.INACTIVE);
        r6 = r6 + 1;
        goto L7
    L9:
        crcSet.add(Integer.valueOf(crc));
    L10:
        i = i + 1;
        goto L3
    L11:
        this.mCrcSet = Collections.unmodifiableSet(crcSet);
    }

    public boolean contains(int crc) {
        return this.mCrcSet.contains(Integer.valueOf(crc));
    }

    public void dump(FileDescriptor fd, PrintWriter pw, String[] args) {
        Iterator<Integer> r0 = this.mCrcSet.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        int crc = r0.next().intValue();
        pw.println(HexDump.toHexString(crc));
        goto L4
    L6:
        pw.println("");
    }
}
