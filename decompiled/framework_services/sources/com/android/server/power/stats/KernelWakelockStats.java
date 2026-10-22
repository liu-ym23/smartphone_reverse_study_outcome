package com.android.server.power.stats;

import java.util.HashMap;

/* JADX INFO: loaded from: classes3.dex */
public class KernelWakelockStats extends HashMap<String, Entry> {
    int kernelWakelockVersion;

    public static class Entry {
        public long activeTimeUs;
        public int count;
        public long totalTimeUs;
        public int version;

        Entry(int count, long totalTimeUs, long activeTimeUs, int version) {
            this.count = count;
            this.totalTimeUs = totalTimeUs;
            this.activeTimeUs = activeTimeUs;
            this.version = version;
        }
    }

    public KernelWakelockStats() {
    }
}
