package com.bytedance.apm6.service.perf;

import android.util.Pair;
import java.util.LinkedList;

/* JADX INFO: loaded from: classes.dex */
public interface ICpuDataService {

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f6818a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public double f6819b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f6820c;

        public a(String r10, double r11, int r12) {
            this.f6818a = r10;
            this.f6819b = r11;
            this.f6820c = r12;
        }

        public double a() {
            return this.f6819b;
        }
    }

    double getCpuRate();

    double getCpuSpeed();

    Pair<Long, LinkedList<a>> getExceptionThreadList();

    Pair<Long, LinkedList<a>> getThreadList();
}
