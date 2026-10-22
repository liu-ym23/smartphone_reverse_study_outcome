package com.bytedance.apm.agent.v2.instrumentation;

import android.os.SystemClock;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public class BatteryAgent {
    private static boolean hasHook;
    private static final Map<String, MethodExecutedValue> sExecutedRecord = null;
    private static ThreadLocal<HashMap<String, MethodExecutingValue>> sExecutingRecord;

    /* JADX INFO: loaded from: classes14.dex */
    public static class MethodExecutedValue {
        private int cpuCost;
        private int exeCount;

        public String toString() {
            return "MethodExecutedValue{exeCount=" + this.exeCount + ", cpuCost=" + this.cpuCost + '}';
        }

        public MethodExecutedValue() {
            this.exeCount = 0;
            this.cpuCost = 0;
        }

        public int getCost() {
            return this.cpuCost;
        }

        public int getCount() {
            return this.exeCount;
        }

        public static /* synthetic */ int access$300(MethodExecutedValue r100) {
            return r100.cpuCost;
        }

        public void addValue(MethodExecutingValue r100) {
            this.exeCount += MethodExecutingValue.access$000(r100);
            this.cpuCost = (int) (((long) this.cpuCost) + (MethodExecutingValue.access$100(r100) - MethodExecutingValue.access$200(r100)));
        }
    }

    /* JADX INFO: loaded from: classes14.dex */
    public static class MethodExecutingValue {
        private long end;
        private int exeCount;
        private int leftCount;
        private long start;

        public void methodIn() {
            if (this.exeCount != 0) goto L5;
            this.start = SystemClock.currentThreadTimeMillis();
        L5:
            this.leftCount++;
            this.exeCount++;
        }

        public boolean methodOut() {
            int r100 = this.leftCount - 1;
            this.leftCount = r100;
            if (r100 != 0) goto L6;
            this.end = SystemClock.currentThreadTimeMillis();
            return true;
        L6:
            return false;
        }

        public MethodExecutingValue() {
            this.start = 0;
            this.end = 0;
            this.leftCount = 0;
            this.exeCount = 0;
        }

        public static /* synthetic */ int access$000(MethodExecutingValue r100) {
            return r100.exeCount;
        }

        public static /* synthetic */ long access$100(MethodExecutingValue r100) {
            return r100.end;
        }

        public static /* synthetic */ long access$200(MethodExecutingValue r100) {
            return r100.start;
        }
    }

    public BatteryAgent() {
    }

    static {
        sExecutedRecord = new HashMap();
        sExecutingRecord = new ThreadLocal();
        hasHook = false;
    }

    public static boolean hasHook() {
        return hasHook;
    }

    public static void e(String r100) {
        HashMap<String, MethodExecutingValue> r101 = sExecutingRecord.get();
        if (r101 != null) goto L5;
        return;
    L5:
        MethodExecutingValue r102 = r101.get(r100);
        if (r102 != null) goto L9;
        return;
    L9:
        if (r102.methodOut() == false) goto L21;
        r101.remove(r100);
        Map<String, MethodExecutedValue> r103 = sExecutedRecord;
        monitor-enter(r103);
        MethodExecutedValue r104 = r103.get(r100);     // Catch: Throwable -> L18
        if (r104 != null) goto L15;
        r104 = new MethodExecutedValue();     // Catch: Throwable -> L18
        r103.put(r100, r104);     // Catch: Throwable -> L18
    L15:
        r104.addValue(r102);     // Catch: Throwable -> L18
        monitor-exit(r103);     // Catch: Throwable -> L18
        return;
    L18:
        th = move-exception;
        throw th;
    }

    public static Map<String, MethodExecutedValue> filterResultAndClear(long r100) {
        Map<String, MethodExecutedValue> r101 = sExecutedRecord;
        if (r101.isEmpty() == false) goto L6;
        return null;
    L6:
        monitor-enter(r101);
        HashMap r102 = new HashMap();     // Catch: Throwable -> L16
        Iterator<Map.Entry<String, MethodExecutedValue>> r103 = r101.entrySet().iterator();     // Catch: Throwable -> L16
    L9:
        if (r103.hasNext() == false) goto L13;
        Map.Entry<String, MethodExecutedValue> r104 = r103.next();     // Catch: Throwable -> L16
        if (MethodExecutedValue.access$300(r104.getValue()) <= r100) goto L9;
        r102.put(r104.getKey(), r104.getValue());     // Catch: Throwable -> L16
        goto L9
    L13:
        sExecutedRecord.clear();     // Catch: Throwable -> L16
        monitor-exit(r101);     // Catch: Throwable -> L16
        return r102;
    L16:
        th = move-exception;
        throw th;
    }

    public static void s(String r100) {
        hasHook = true;
        HashMap<String, MethodExecutingValue> r101 = sExecutingRecord.get();
        if (r101 != null) goto L5;
        r101 = new HashMap();
        sExecutingRecord.set(r101);
    L5:
        MethodExecutingValue r102 = r101.get(r100);
        if (r102 != null) goto L8;
        r102 = new MethodExecutingValue();
        r101.put(r100, r102);
    L8:
        r102.methodIn();
    }
}
