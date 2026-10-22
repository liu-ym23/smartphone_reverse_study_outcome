package com.bytedance.apm6.service.perf;

import android.util.Pair;
import java.util.LinkedList;

/* JADX INFO: loaded from: classes2.dex */
public interface ICpuDataService {

    public static class ThreadCpuItem {
        private double cpuUsage;
        private String threadName;
        private int tid;

        public ThreadCpuItem(String r1, double r2, int r4) {
            this.threadName = r1;
            this.cpuUsage = r2;
            this.tid = r4;
        }

        public String getThreadName() {
            return this.threadName;
        }

        public double getCpuUsage() {
            return this.cpuUsage;
        }

        public int getTid() {
            return this.tid;
        }
    }

    double getCpuRate();

    double getCpuSpeed();

    Pair<Long, LinkedList<ThreadCpuItem>> getExceptionThreadList();

    Pair<Long, LinkedList<ThreadCpuItem>> getThreadList();
}
