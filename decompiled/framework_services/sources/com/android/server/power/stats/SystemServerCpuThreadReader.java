package com.android.server.power.stats;

import android.os.Process;
import com.android.internal.os.KernelSingleProcessCpuThreadReader;
import java.io.IOException;

/* JADX INFO: loaded from: classes3.dex */
public class SystemServerCpuThreadReader {
    private final SystemServiceCpuThreadTimes mDeltaCpuThreadTimes;
    private final KernelSingleProcessCpuThreadReader mKernelCpuThreadReader;
    private long[] mLastBinderThreadCpuTimesUs;
    private long[] mLastThreadCpuTimesUs;

    public static class SystemServiceCpuThreadTimes {
        public long[] binderThreadCpuTimesUs;
        public long[] threadCpuTimesUs;

        public SystemServiceCpuThreadTimes() {
        }
    }

    public static SystemServerCpuThreadReader create() {
        return new SystemServerCpuThreadReader(KernelSingleProcessCpuThreadReader.create(Process.myPid()));
    }

    public SystemServerCpuThreadReader(int pid, KernelSingleProcessCpuThreadReader.CpuTimeInStateReader cpuTimeInStateReader) throws IOException {
        this(new KernelSingleProcessCpuThreadReader(pid, cpuTimeInStateReader));
    }

    public SystemServerCpuThreadReader(KernelSingleProcessCpuThreadReader kernelCpuThreadReader) {
        this.mDeltaCpuThreadTimes = new SystemServiceCpuThreadTimes();
        this.mKernelCpuThreadReader = kernelCpuThreadReader;
    }

    public void startTrackingThreadCpuTime() {
        this.mKernelCpuThreadReader.startTrackingThreadCpuTimes();
    }

    public void setBinderThreadNativeTids(int[] nativeTids) {
        this.mKernelCpuThreadReader.setSelectedThreadIds(nativeTids);
    }

    public SystemServiceCpuThreadTimes readDelta() {
        int numCpuFrequencies = this.mKernelCpuThreadReader.getCpuFrequencyCount();
        if (this.mLastThreadCpuTimesUs != null) goto L5;
        this.mLastThreadCpuTimesUs = new long[numCpuFrequencies];
        this.mLastBinderThreadCpuTimesUs = new long[numCpuFrequencies];
        this.mDeltaCpuThreadTimes.threadCpuTimesUs = new long[numCpuFrequencies];
        this.mDeltaCpuThreadTimes.binderThreadCpuTimesUs = new long[numCpuFrequencies];
    L5:
        KernelSingleProcessCpuThreadReader.ProcessCpuUsage processCpuUsage = this.mKernelCpuThreadReader.getProcessCpuUsage();
        if (processCpuUsage != null) goto L9;
        return null;
    L9:
        int i = numCpuFrequencies - 1;
    L10:
        if (i < 0) goto L13;
        long threadCpuTimesUs = processCpuUsage.threadCpuTimesMillis[i] * 1000;
        long binderThreadCpuTimesUs = processCpuUsage.selectedThreadCpuTimesMillis[i] * 1000;
        this.mDeltaCpuThreadTimes.threadCpuTimesUs[i] = Math.max(0, threadCpuTimesUs - this.mLastThreadCpuTimesUs[i]);
        this.mDeltaCpuThreadTimes.binderThreadCpuTimesUs[i] = Math.max(0, binderThreadCpuTimesUs - this.mLastBinderThreadCpuTimesUs[i]);
        this.mLastThreadCpuTimesUs[i] = threadCpuTimesUs;
        this.mLastBinderThreadCpuTimesUs[i] = binderThreadCpuTimesUs;
        i = i - 1;
        goto L10
    L13:
        return this.mDeltaCpuThreadTimes;
    }

    public SystemServiceCpuThreadTimes readAbsolute() {
        int numCpuFrequencies = this.mKernelCpuThreadReader.getCpuFrequencyCount();
        KernelSingleProcessCpuThreadReader.ProcessCpuUsage processCpuUsage = this.mKernelCpuThreadReader.getProcessCpuUsage();
        if (processCpuUsage != null) goto L6;
        return null;
    L6:
        SystemServiceCpuThreadTimes result = new SystemServiceCpuThreadTimes();
        result.threadCpuTimesUs = new long[numCpuFrequencies];
        result.binderThreadCpuTimesUs = new long[numCpuFrequencies];
        int i = 0;
    L7:
        if (i >= numCpuFrequencies) goto L10;
        result.threadCpuTimesUs[i] = processCpuUsage.threadCpuTimesMillis[i] * 1000;
        result.binderThreadCpuTimesUs[i] = processCpuUsage.selectedThreadCpuTimesMillis[i] * 1000;
        i = i + 1;
        goto L7
    L10:
        return result;
    }
}
