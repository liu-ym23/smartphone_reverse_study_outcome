package com.bytedance.apm.agent.v2.instrumentation;

import android.os.SystemClock;
import androidx.annotation.Keep;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
@Keep
public class BatteryAgent {
    private static boolean hasHook;
    private static final Map<String, MethodExecutedValue> sExecutedRecord = null;
    private static ThreadLocal<HashMap<String, MethodExecutingValue>> sExecutingRecord;

    public static class MethodExecutedValue {
        private int cpuCost;
        private int exeCount;

        public MethodExecutedValue() {
            this.exeCount = 0;
            this.cpuCost = 0;
        }

        public static /* synthetic */ int access$300(MethodExecutedValue r10) {
            return r10.cpuCost;
        }

        public void addValue(MethodExecutingValue r10) {
            this.exeCount += MethodExecutingValue.access$000(r10);
            this.cpuCost = (int) (((long) this.cpuCost) + (MethodExecutingValue.access$100(r10) - MethodExecutingValue.access$200(r10)));
        }

        public int getCost() {
            return this.cpuCost;
        }

        public int getCount() {
            return this.exeCount;
        }

        public String toString() {
            return "MethodExecutedValue{exeCount=" + this.exeCount + ", cpuCost=" + this.cpuCost + '}';
        }
    }

    public static class MethodExecutingValue {
        private long end;
        private int exeCount;
        private int leftCount;
        private long start;

        public MethodExecutingValue() {
            this.start = 0;
            this.end = 0;
            this.leftCount = 0;
            this.exeCount = 0;
        }

        public static /* synthetic */ int access$000(MethodExecutingValue r10) {
            return r10.exeCount;
        }

        public static /* synthetic */ long access$100(MethodExecutingValue r10) {
            return r10.end;
        }

        public static /* synthetic */ long access$200(MethodExecutingValue r10) {
            return r10.start;
        }

        public void methodIn() {
            if (this.exeCount != 0) goto L5;
            this.start = SystemClock.currentThreadTimeMillis();
        L5:
            this.leftCount++;
            this.exeCount++;
        }

        public boolean methodOut() {
            int r10 = this.leftCount - 1;
            this.leftCount = r10;
            if (r10 != 0) goto L6;
            this.end = SystemClock.currentThreadTimeMillis();
            return true;
        L6:
            return false;
        }
    }

    static {
        sExecutedRecord = new HashMap();
        sExecutingRecord = new ThreadLocal();
        hasHook = false;
    }

    public BatteryAgent() {
    }

    @Keep
    public static void e(String r10) {
        HashMap<String, MethodExecutingValue> r11 = sExecutingRecord.get();
        if (r11 != null) goto L5;
        return;
    L5:
        MethodExecutingValue r12 = r11.get(r10);
        if (r12 != null) goto L9;
        return;
    L9:
        if (r12.methodOut() == false) goto L22;
        r11.remove(r10);
        Map<String, MethodExecutedValue> r13 = sExecutedRecord;
        monitor-enter(r13);
        MethodExecutedValue r14 = r13.get(r10);     // Catch: Throwable -> L15
        if (r14 != null) goto L17;
        r14 = new MethodExecutedValue();     // Catch: Throwable -> L15
        r13.put(r10, r14);     // Catch: Throwable -> L15
    L17:
        r14.addValue(r12);     // Catch: Throwable -> L15
        monitor-exit(r13);     // Catch: Throwable -> L15
        return;
    L15:
        th = move-exception;
        throw th;
    }

    public static Map<String, MethodExecutedValue> filterResultAndClear(long r10) {
        HashMap r11 = new HashMap();
        Map<String, MethodExecutedValue> r12 = sExecutedRecord;
        if (r12.isEmpty() == false) goto L5;
        return r11;
    L5:
        monitor-enter(r12);
        Iterator<Map.Entry<String, MethodExecutedValue>> r13 = r12.entrySet().iterator();     // Catch: Throwable -> L12
    L8:
        if (r13.hasNext() == false) goto L14;
        Map.Entry<String, MethodExecutedValue> r14 = r13.next();     // Catch: Throwable -> L12
        if (MethodExecutedValue.access$300(r14.getValue()) <= r10) goto L8;
        r11.put(r14.getKey(), r14.getValue());     // Catch: Throwable -> L12
        goto L8
    L14:
        sExecutedRecord.clear();     // Catch: Throwable -> L12
        monitor-exit(r12);     // Catch: Throwable -> L12
        return r11;
    L12:
        th = move-exception;
        throw th;
    }

    public static boolean hasHook() {
        return hasHook;
    }

    @Keep
    public static void s(String r10) {
        hasHook = true;
        HashMap<String, MethodExecutingValue> r11 = sExecutingRecord.get();
        if (r11 != null) goto L5;
        r11 = new HashMap();
        sExecutingRecord.set(r11);
    L5:
        MethodExecutingValue r12 = r11.get(r10);
        if (r12 != null) goto L8;
        r12 = new MethodExecutingValue();
        r11.put(r10, r12);
    L8:
        r12.methodIn();
    }
}
