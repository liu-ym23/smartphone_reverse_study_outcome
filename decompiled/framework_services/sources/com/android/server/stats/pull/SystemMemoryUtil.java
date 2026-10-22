package com.android.server.stats.pull;

import android.os.Debug;

/* JADX INFO: loaded from: classes3.dex */
final class SystemMemoryUtil {

    static final class Metrics {
        public int activeAnonKb;
        public int activeFileKb;
        public int activeKb;
        public int availableKb;
        public int cmaFreeKb;
        public int cmaTotalKb;
        public int dmaBufTotalExportedKb;
        public int freeKb;
        public int gpuPrivateAllocationsKb;
        public int gpuTotalUsageKb;
        public int inactiveAnonKb;
        public int inactiveFileKb;
        public int inactiveKb;
        public int kernelStackKb;
        public int pageTablesKb;
        public int shmemKb;
        public int swapFreeKb;
        public int swapTotalKb;
        public int totalIonKb;
        public int totalKb;
        public int unaccountedKb;
        public int unreclaimableSlabKb;
        public int vmallocUsedKb;

        Metrics() {
        }
    }

    private SystemMemoryUtil() {
    }

    static Metrics getMetrics() {
        int totalIonKb = (int) Debug.getDmabufHeapTotalExportedKb();
        int gpuTotalUsageKb = (int) Debug.getGpuTotalUsageKb();
        int gpuPrivateAllocationsKb = (int) Debug.getGpuPrivateMemoryKb();
        int dmaBufTotalExportedKb = (int) Debug.getDmabufTotalExportedKb();
        long[] mInfos = new long[31];
        Debug.getMemInfo(mInfos);
        long kReclaimableKb = mInfos[16];
        if (kReclaimableKb != 0) goto L5;
        kReclaimableKb = mInfos[6];
    L5:
        long accountedKb = ((((((((mInfos[1] + mInfos[10]) + mInfos[2]) + mInfos[17]) + mInfos[18]) + mInfos[19]) + mInfos[7]) + kReclaimableKb) + mInfos[12]) + mInfos[13];
        if (Debug.isVmapStack() == true) goto L9;
        accountedKb = accountedKb + mInfos[15];
    L9:
        if (dmaBufTotalExportedKb < 0) goto L12;
        if (gpuPrivateAllocationsKb < 0) goto L12;
        char r17 = 1;
        char r18 = 17;
        char r19 = 18;
        long accountedKb2 = accountedKb + ((long) (dmaBufTotalExportedKb + gpuPrivateAllocationsKb));
    L17:
        Metrics result = new Metrics();
        result.unreclaimableSlabKb = (int) mInfos[7];
        result.vmallocUsedKb = (int) mInfos[12];
        result.pageTablesKb = (int) mInfos[13];
        result.kernelStackKb = (int) mInfos[15];
        result.shmemKb = (int) mInfos[4];
        result.totalKb = (int) mInfos[0];
        result.freeKb = (int) mInfos[r17];
        result.availableKb = (int) mInfos[20];
        result.activeKb = (int) mInfos[r18];
        result.inactiveKb = (int) mInfos[r19];
        result.activeAnonKb = (int) mInfos[21];
        result.inactiveAnonKb = (int) mInfos[22];
        result.activeFileKb = (int) mInfos[23];
        result.inactiveFileKb = (int) mInfos[24];
        result.swapTotalKb = (int) mInfos[8];
        result.swapFreeKb = (int) mInfos[9];
        result.cmaTotalKb = (int) mInfos[25];
        result.cmaFreeKb = (int) mInfos[26];
        result.totalIonKb = totalIonKb;
        result.gpuTotalUsageKb = gpuTotalUsageKb;
        result.gpuPrivateAllocationsKb = gpuPrivateAllocationsKb;
        result.dmaBufTotalExportedKb = dmaBufTotalExportedKb;
        result.unaccountedKb = (int) (mInfos[0] - accountedKb2);
        return result;
    L12:
        r17 = 1;
        r18 = 17;
        r19 = 18;
        accountedKb2 = accountedKb + ((long) Math.max(0, gpuTotalUsageKb));
        if (dmaBufTotalExportedKb < 0) goto L15;
        accountedKb2 = accountedKb2 + ((long) dmaBufTotalExportedKb);
        goto L17
    L15:
        if (totalIonKb < 0) goto L17;
        accountedKb2 = accountedKb2 + ((long) totalIonKb);
        goto L17
    }
}
