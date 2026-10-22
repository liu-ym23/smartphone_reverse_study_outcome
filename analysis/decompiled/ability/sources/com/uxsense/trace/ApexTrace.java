package com.uxsense.trace;

import D7.v;
import N9.j;
import O7.i;
import androidx.appfunctions.metadata.a;
import androidx.autofill.HintConstants;
import androidx.exifinterface.media.ExifInterface;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.uxsense.core.ApexMetadataFileManager;
import com.uxsense.utils.ALog;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001)B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J/\u0010\t\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00042\u0006\u0010\u0006\u001a\u00020\u00052\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007H\u0086\bø\u0001\u0000¢\u0006\u0004\b\t\u0010\nJ\u001f\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u000bH\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\r\u0010\u0010\u001a\u00020\r¢\u0006\u0004\b\u0010\u0010\u0003J\u0017\u0010\u0012\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0011\u001a\u00020\u0005¢\u0006\u0004\b\u0012\u0010\u0013J\r\u0010\u0014\u001a\u00020\r¢\u0006\u0004\b\u0014\u0010\u0003R\u0014\u0010\u0015\u001a\u00020\u00058\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\"\u0010\u0018\u001a\u00020\u00178\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR,\u0010!\u001a\u001a\u0012\u0004\u0012\u00020\u0005\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020\u000b0\u001f0\u001e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b!\u0010\"R\u001a\u0010%\u001a\b\u0012\u0004\u0012\u00020$0#8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b%\u0010&R\u0014\u0010'\u001a\u00020 8\u0002X\u0082T¢\u0006\u0006\n\u0004\b'\u0010(\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006*"}, d2 = {"Lcom/uxsense/trace/ApexTrace;", "", AppAgent.CONSTRUCT, "()V", ExifInterface.GPS_DIRECTION_TRUE, "", HintConstants.AUTOFILL_HINT_NAME, "Lkotlin/Function0;", "block", "trace", "(Ljava/lang/String;LS7/a;)Ljava/lang/Object;", "", "durationNs", "LC7/r;", "record", "(Ljava/lang/String;J)V", "printSummary", "appName", "saveToFile", "(Ljava/lang/String;)Ljava/lang/String;", "clear", "TAG", "Ljava/lang/String;", "", "enabled", "Z", "getEnabled", "()Z", "setEnabled", "(Z)V", "", "Lkotlin/Pair;", "", "stats", "Ljava/util/Map;", "", "Lcom/uxsense/trace/ApexTrace$TraceRecord;", "recentTraces", "Ljava/util/List;", "MAX_RECENT", "I", "TraceRecord", "uxsense_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ApexTrace {
    private static final int MAX_RECENT = 500;
    private static final String TAG = "ApexTrace";
    public static final ApexTrace INSTANCE = new ApexTrace();
    private static volatile boolean enabled = true;
    private static final Map<String, Pair<Integer, Long>> stats = new LinkedHashMap();
    private static final List<TraceRecord> recentTraces = new ArrayList();

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0082\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J'\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\f¨\u0006\u0018"}, d2 = {"Lcom/uxsense/trace/ApexTrace$TraceRecord;", "", HintConstants.AUTOFILL_HINT_NAME, "", "durationNs", "", "timestamp", AppAgent.CONSTRUCT, "(Ljava/lang/String;JJ)V", "getName", "()Ljava/lang/String;", "getDurationNs", "()J", "getTimestamp", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "uxsense_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final /* data */ class TraceRecord {
        private final long durationNs;
        private final String name;
        private final long timestamp;

        public TraceRecord(String name, long j5, long j6) {
            k.f(name, "name");
            this.name = name;
            this.durationNs = j5;
            this.timestamp = j6;
        }

        public static /* synthetic */ TraceRecord copy$default(TraceRecord traceRecord, String str, long j5, long j6, int i, Object obj) {
            if ((i & 1) != 0) {
                str = traceRecord.name;
            }
            if ((i & 2) != 0) {
                j5 = traceRecord.durationNs;
            }
            if ((i & 4) != 0) {
                j6 = traceRecord.timestamp;
            }
            return traceRecord.copy(str, j5, j6);
        }

        /* renamed from: component1, reason: from getter */
        public final String getName() {
            return this.name;
        }

        /* renamed from: component2, reason: from getter */
        public final long getDurationNs() {
            return this.durationNs;
        }

        /* renamed from: component3, reason: from getter */
        public final long getTimestamp() {
            return this.timestamp;
        }

        public final TraceRecord copy(String name, long durationNs, long timestamp) {
            k.f(name, "name");
            return new TraceRecord(name, durationNs, timestamp);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof TraceRecord)) {
                return false;
            }
            TraceRecord traceRecord = (TraceRecord) other;
            return k.b(this.name, traceRecord.name) && this.durationNs == traceRecord.durationNs && this.timestamp == traceRecord.timestamp;
        }

        public final long getDurationNs() {
            return this.durationNs;
        }

        public final String getName() {
            return this.name;
        }

        public final long getTimestamp() {
            return this.timestamp;
        }

        public int hashCode() {
            return Long.hashCode(this.timestamp) + a.c(this.name.hashCode() * 31, 31, this.durationNs);
        }

        public String toString() {
            StringBuilder sb = new StringBuilder("TraceRecord(name=");
            sb.append(this.name);
            sb.append(", durationNs=");
            sb.append(this.durationNs);
            sb.append(", timestamp=");
            return B7.a.p(sb, this.timestamp, ')');
        }
    }

    private ApexTrace() {
    }

    public final void clear() {
        Map<String, Pair<Integer, Long>> map = stats;
        synchronized (map) {
            map.clear();
            recentTraces.clear();
        }
    }

    public final boolean getEnabled() {
        return enabled;
    }

    public final void printSummary() {
        Map<String, Pair<Integer, Long>> map = stats;
        synchronized (map) {
            if (map.isEmpty()) {
                ALog.i$default(TAG, "No trace data", null, 4, null);
                return;
            }
            ALog.i$default(TAG, "========== Apex Trace Summary ==========", null, 4, null);
            for (Map.Entry entry : v.Z0(map.entrySet(), new Comparator() { // from class: com.uxsense.trace.ApexTrace$printSummary$lambda$3$$inlined$sortedByDescending$1
                @Override // java.util.Comparator
                public final int compare(T t9, T t10) {
                    return j.m((Long) ((Pair) ((Map.Entry) t10).getValue()).b, (Long) ((Pair) ((Map.Entry) t9).getValue()).b);
                }
            })) {
                String str = (String) entry.getKey();
                int iIntValue = ((Number) ((Pair) entry.getValue()).f4886a).intValue();
                double dLongValue = ((Number) r3.b).longValue() / 1000000.0d;
                ALog.i$default(TAG, '[' + str + "] count=" + iIntValue + ", total=" + String.format("%.2f", Arrays.copyOf(new Object[]{Double.valueOf(dLongValue)}, 1)) + "ms, avg=" + String.format("%.2f", Arrays.copyOf(new Object[]{Double.valueOf(dLongValue / iIntValue)}, 1)) + "ms", null, 4, null);
            }
            ALog.i$default(TAG, "=========================================", null, 4, null);
        }
    }

    public final void record(String name, long durationNs) {
        k.f(name, "name");
        Map<String, Pair<Integer, Long>> map = stats;
        synchronized (map) {
            try {
                Pair<Integer, Long> pair = map.get(name);
                if (pair == null) {
                    pair = new Pair<>(0, 0L);
                }
                map.put(name, new Pair<>(Integer.valueOf(((Number) pair.f4886a).intValue() + 1), Long.valueOf(((Number) pair.b).longValue() + durationNs)));
                List<TraceRecord> list = recentTraces;
                if (list.size() >= 500) {
                    list.remove(0);
                }
                list.add(new TraceRecord(name, durationNs, System.currentTimeMillis()));
            } catch (Throwable th) {
                throw th;
            }
        }
        long j5 = durationNs / 1000000;
        if (j5 > 10) {
            ALog.w$default(TAG, "⚠️ [" + name + "] took " + j5 + "ms", null, 4, null);
        }
    }

    public final String saveToFile(String appName) {
        k.f(appName, "appName");
        try {
            File file = new File(ApexMetadataFileManager.INSTANCE.getBasePath$uxsense_release(), appName.concat("/trace"));
            file.mkdirs();
            String str = new SimpleDateFormat("yyyyMMdd_HHmmss", Locale.getDefault()).format(new Date());
            File file2 = new File(file, "trace_" + str + ".txt");
            StringBuilder sb = new StringBuilder();
            sb.append("Apex Trace Report - " + str);
            sb.append('\n');
            sb.append("App: ".concat(appName));
            sb.append('\n');
            sb.append('\n');
            Map<String, Pair<Integer, Long>> map = stats;
            synchronized (map) {
                try {
                    sb.append("=== Summary ===");
                    sb.append('\n');
                    for (Map.Entry entry : v.Z0(map.entrySet(), new Comparator() { // from class: com.uxsense.trace.ApexTrace$saveToFile$lambda$7$$inlined$sortedByDescending$1
                        @Override // java.util.Comparator
                        public final int compare(T t9, T t10) {
                            return j.m((Long) ((Pair) ((Map.Entry) t10).getValue()).b, (Long) ((Pair) ((Map.Entry) t9).getValue()).b);
                        }
                    })) {
                        String str2 = (String) entry.getKey();
                        int iIntValue = ((Number) ((Pair) entry.getValue()).f4886a).intValue();
                        double dLongValue = ((Number) r2.b).longValue() / 1000000.0d;
                        sb.append('[' + str2 + "] count=" + iIntValue + ", total=" + String.format("%.2f", Arrays.copyOf(new Object[]{Double.valueOf(dLongValue)}, 1)) + "ms, avg=" + String.format("%.2f", Arrays.copyOf(new Object[]{Double.valueOf(dLongValue / iIntValue)}, 1)) + "ms");
                        sb.append('\n');
                    }
                    sb.append('\n');
                    sb.append("=== Recent Traces ===");
                    sb.append('\n');
                    Iterator it = v.b1(100, recentTraces).iterator();
                    while (it.hasNext()) {
                        sb.append('[' + ((TraceRecord) it.next()).getName() + "] " + String.format("%.2f", Arrays.copyOf(new Object[]{Double.valueOf(r2.getDurationNs() / 1000000.0d)}, 1)) + "ms");
                        sb.append('\n');
                    }
                } finally {
                }
            }
            String string = sb.toString();
            k.e(string, "toString(...)");
            i.Y(file2, string);
            ALog.i$default(TAG, "Trace saved to: " + file2.getAbsolutePath(), null, 4, null);
            return file2.getAbsolutePath();
        } catch (Exception e) {
            ALog.e(TAG, "Failed to save trace", e);
            return null;
        }
    }

    public final void setEnabled(boolean z10) {
        enabled = z10;
    }

    public final <T> T trace(String name, S7.a block) {
        k.f(name, "name");
        k.f(block, "block");
        if (!getEnabled()) {
            return (T) block.invoke();
        }
        long jNanoTime = System.nanoTime();
        try {
            return (T) block.invoke();
        } finally {
            record(name, System.nanoTime() - jNanoTime);
        }
    }
}
