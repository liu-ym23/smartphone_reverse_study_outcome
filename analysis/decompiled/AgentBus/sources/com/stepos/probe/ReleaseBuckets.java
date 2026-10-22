package com.stepos.probe;

import c7.j;
import d7.e0;
import d7.m;
import d7.r;
import d7.t;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import m.x;
import nb.i;
import q7.k;

@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\bÆ\u0002\u0018\u00002\u00020\u0001:\u0002=>B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\r\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\r\u0010\u000bJ\r\u0010\u000e\u001a\u00020\t¢\u0006\u0004\b\u000e\u0010\u0003J\r\u0010\u000f\u001a\u00020\t¢\u0006\u0004\b\u000f\u0010\u0003J\r\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u0011\u0010\u0012JE\u0010\u001b\u001a\u00020\t2\b\u0010\u0014\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0015\u001a\u00020\u00132\b\u0010\u0016\u001a\u0004\u0018\u00010\u00132\u0012\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u00130\u00172\u0006\u0010\u001a\u001a\u00020\u0010¢\u0006\u0004\b\u001b\u0010\u001cJ+\u0010\u001f\u001a\u00020\t2\u0006\u0010\u001d\u001a\u00020\u00042\u0014\u0010\u001e\u001a\u0010\u0012\u0004\u0012\u00020\u0018\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0017¢\u0006\u0004\b\u001f\u0010 J\u0013\u0010#\u001a\b\u0012\u0004\u0012\u00020\"0!¢\u0006\u0004\b#\u0010$J\u0013\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00180!¢\u0006\u0004\b%\u0010$R\u0014\u0010&\u001a\u00020\u00138\u0002X\u0082T¢\u0006\u0006\n\u0004\b&\u0010'R\u0014\u0010)\u001a\u00020(8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b)\u0010*R\"\u0010+\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b+\u0010,\u001a\u0004\b-\u0010.\"\u0004\b/\u0010\u000bR\u001a\u00101\u001a\b\u0012\u0004\u0012\u00020\"008\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b1\u00102R\u0018\u00104\u001a\u0004\u0018\u0001038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b4\u00105RD\u00107\u001a\u0012\u0012\u0004\u0012\u00020\u0018\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u00172\u0016\u00106\u001a\u0012\u0012\u0004\u0012\u00020\u0018\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u00178\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b7\u00108\u001a\u0004\b9\u0010:R$\u0010;\u001a\u00020\u00042\u0006\u00106\u001a\u00020\u00048\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b;\u0010,\u001a\u0004\b<\u0010.¨\u0006?"}, d2 = {"Lcom/stepos/probe/ReleaseBuckets;", "", "<init>", "()V", "", "ms", "alignDown", "(J)J", "now", "Lc7/r;", "rollover", "(J)V", "endMs", "closeAt", "start", "stop", "", "isActive", "()Z", "", "powerMw", "energyUwh", "cpuPct", "", "", "temps", "charging", "addSample", "(Ljava/lang/Integer;ILjava/lang/Integer;Ljava/util/Map;Z)V", "eventMs", "event", "addEvent", "(JLjava/util/Map;)V", "", "Lcom/stepos/probe/ReleaseBuckets$BucketRecord;", "snapshot", "()Ljava/util/List;", "snapshotJsonLines", "MAX_CLOSED", "I", "Ljava/text/SimpleDateFormat;", "hms", "Ljava/text/SimpleDateFormat;", "windowMs", "J", "getWindowMs", "()J", "setWindowMs", "Ld7/m;", "closed", "Ld7/m;", "Lcom/stepos/probe/ReleaseBuckets$OpenBucket;", "open", "Lcom/stepos/probe/ReleaseBuckets$OpenBucket;", "value", "lastEvent", "Ljava/util/Map;", "getLastEvent", "()Ljava/util/Map;", "lastEventMs", "getLastEventMs", "BucketRecord", "OpenBucket", "probe-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class ReleaseBuckets {
    private static final int MAX_CLOSED = 10;
    private static volatile Map<String, ? extends Object> lastEvent;
    private static volatile long lastEventMs;
    private static OpenBucket open;
    public static final ReleaseBuckets INSTANCE = new ReleaseBuckets();
    private static final SimpleDateFormat hms = new SimpleDateFormat("HH:mm:ss", Locale.US);
    private static volatile long windowMs = 60000;
    private static final m closed = new m();

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B?\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012&\u0010\u0005\u001a\"\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0006j\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u0001`\b¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J)\u0010\u0012\u001a\"\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0006j\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u0001`\bHÆ\u0003JG\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032(\b\u0002\u0010\u0005\u001a\"\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0006j\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u0001`\bHÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0007HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR1\u0010\u0005\u001a\"\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0006j\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u0001`\b¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001a"}, d2 = {"Lcom/stepos/probe/ReleaseBuckets$BucketRecord;", "", "startMs", "", "endMs", "json", "Ljava/util/LinkedHashMap;", "", "Lkotlin/collections/LinkedHashMap;", "<init>", "(JJLjava/util/LinkedHashMap;)V", "getStartMs", "()J", "getEndMs", "getJson", "()Ljava/util/LinkedHashMap;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "probe-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final /* data */ class BucketRecord {
        private final long endMs;
        private final LinkedHashMap<String, Object> json;
        private final long startMs;

        public BucketRecord(long j2, long j4, LinkedHashMap<String, Object> linkedHashMap) {
            k.e(linkedHashMap, "json");
            this.startMs = j2;
            this.endMs = j4;
            this.json = linkedHashMap;
        }

        public static /* synthetic */ BucketRecord copy$default(BucketRecord bucketRecord, long j2, long j4, LinkedHashMap linkedHashMap, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                j2 = bucketRecord.startMs;
            }
            long j10 = j2;
            if ((i2 & 2) != 0) {
                j4 = bucketRecord.endMs;
            }
            long j11 = j4;
            if ((i2 & 4) != 0) {
                linkedHashMap = bucketRecord.json;
            }
            return bucketRecord.copy(j10, j11, linkedHashMap);
        }

        /* renamed from: component1, reason: from getter */
        public final long getStartMs() {
            return this.startMs;
        }

        /* renamed from: component2, reason: from getter */
        public final long getEndMs() {
            return this.endMs;
        }

        public final LinkedHashMap<String, Object> component3() {
            return this.json;
        }

        public final BucketRecord copy(long startMs, long endMs, LinkedHashMap<String, Object> json) {
            k.e(json, "json");
            return new BucketRecord(startMs, endMs, json);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof BucketRecord)) {
                return false;
            }
            BucketRecord bucketRecord = (BucketRecord) other;
            return this.startMs == bucketRecord.startMs && this.endMs == bucketRecord.endMs && k.a(this.json, bucketRecord.json);
        }

        public final long getEndMs() {
            return this.endMs;
        }

        public final LinkedHashMap<String, Object> getJson() {
            return this.json;
        }

        public final long getStartMs() {
            return this.startMs;
        }

        public int hashCode() {
            return this.json.hashCode() + x.f(this.endMs, Long.hashCode(this.startMs) * 31, 31);
        }

        public String toString() {
            return "BucketRecord(startMs=" + this.startMs + ", endMs=" + this.endMs + ", json=" + this.json + ")";
        }
    }

    @Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u001f\u0010\n\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u001d\u0010\u000f\u001a\u00020\r2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\fH\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0013\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0011H\u0002¢\u0006\u0004\b\u0013\u0010\u0014JE\u0010\u001e\u001a\u00020\u001d2\b\u0010\u0015\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0016\u001a\u00020\r2\b\u0010\u0017\u001a\u0004\u0018\u00010\r2\u0012\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\r0\u00182\u0006\u0010\u001c\u001a\u00020\u001b¢\u0006\u0004\b\u001e\u0010\u001fJ#\u0010!\u001a\u00020\u001d2\u0014\u0010 \u001a\u0010\u0012\u0004\u0012\u00020\u0019\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0018¢\u0006\u0004\b!\u0010\"J\u001d\u0010#\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b#\u0010\u000bJ\u001d\u0010%\u001a\u00020\t2\u0006\u0010$\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b%\u0010\u000bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010&\u001a\u0004\b'\u0010(R\u0016\u0010)\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b)\u0010*R\u0016\u0010+\u001a\u00020\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b+\u0010,R\u0016\u0010-\u001a\u00020\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b-\u0010,R\u0018\u0010.\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b.\u0010/R\u0016\u00100\u001a\u00020\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b0\u0010,R$\u00103\u001a\u0012\u0012\u0004\u0012\u00020\r01j\b\u0012\u0004\u0012\u00020\r`28\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b3\u00104R0\u00107\u001a\u001e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\r05j\u000e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\r`68\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b7\u00108R@\u00109\u001a.\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0019\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u001801j\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0019\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0018`28\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b9\u00104R\u0016\u0010\u001c\u001a\u00020\u001b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001c\u0010:¨\u0006;"}, d2 = {"Lcom/stepos/probe/ReleaseBuckets$OpenBucket;", "", "", "startMs", "<init>", "(J)V", "endMs", "Ljava/text/SimpleDateFormat;", "fmt", "Lcom/stepos/probe/ReleaseBuckets$BucketRecord;", "build", "(JLjava/text/SimpleDateFormat;)Lcom/stepos/probe/ReleaseBuckets$BucketRecord;", "", "", "values", "p95", "(Ljava/util/List;)I", "", "v", "round3", "(D)D", "powerMw", "energyUwh", "cpuPct", "", "", "t", "", "charging", "Lc7/r;", "addSample", "(Ljava/lang/Integer;ILjava/lang/Integer;Ljava/util/Map;Z)V", "e", "addEvent", "(Ljava/util/Map;)V", "close", "nowMs", "snapshot", "J", "getStartMs", "()J", "powerSum", "D", "powerCnt", "I", "powerMax", "energyStart", "Ljava/lang/Integer;", "energyEnd", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "cpuPcts", "Ljava/util/ArrayList;", "Ljava/util/LinkedHashMap;", "Lkotlin/collections/LinkedHashMap;", "temps", "Ljava/util/LinkedHashMap;", "events", "Z", "probe-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class OpenBucket {
        private boolean charging;
        private int energyEnd;
        private Integer energyStart;
        private int powerCnt;
        private int powerMax;
        private double powerSum;
        private final long startMs;
        private final ArrayList<Integer> cpuPcts = new ArrayList<>();
        private final LinkedHashMap<String, Integer> temps = new LinkedHashMap<>();
        private final ArrayList<Map<String, Object>> events = new ArrayList<>();

        public OpenBucket(long j2) {
            this.startMs = j2;
        }

        private final BucketRecord build(long endMs, SimpleDateFormat fmt) {
            Comparable comparable;
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            linkedHashMap.put("time", fmt.format(new Date(this.startMs)) + "-" + fmt.format(new Date(endMs)));
            linkedHashMap.put("charging", Boolean.valueOf(this.charging));
            if (!this.cpuPcts.isEmpty()) {
                ArrayList<Integer> arrayList = this.cpuPcts;
                k.e(arrayList, "<this>");
                Iterator<T> it = arrayList.iterator();
                double dIntValue = 0.0d;
                int i2 = 0;
                while (it.hasNext()) {
                    dIntValue += ((Number) it.next()).intValue();
                    i2++;
                    if (i2 < 0) {
                        throw new ArithmeticException("Count overflow has happened.");
                    }
                }
                j jVar = new j("avg", Integer.valueOf((int) (i2 == 0 ? Double.NaN : dIntValue / i2)));
                ArrayList<Integer> arrayList2 = this.cpuPcts;
                k.e(arrayList2, "<this>");
                Iterator<T> it2 = arrayList2.iterator();
                if (it2.hasNext()) {
                    Comparable comparable2 = (Comparable) it2.next();
                    while (it2.hasNext()) {
                        Comparable comparable3 = (Comparable) it2.next();
                        if (comparable2.compareTo(comparable3) < 0) {
                            comparable2 = comparable3;
                        }
                    }
                    comparable = comparable2;
                } else {
                    comparable = null;
                }
                Integer num = (Integer) comparable;
                linkedHashMap.put("cpu", e0.R(jVar, new j("max", Integer.valueOf(num != null ? num.intValue() : 0)), new j("p95", Integer.valueOf(p95(this.cpuPcts)))));
            }
            if (this.powerCnt > 0) {
                int i10 = this.energyEnd;
                linkedHashMap.put("power", e0.R(new j("avg_mw", Integer.valueOf((int) (this.powerSum / this.powerCnt))), new j("max_mw", Integer.valueOf(this.powerMax)), new j("total_mwh", Double.valueOf(round3((i10 - (this.energyStart != null ? r0.intValue() : i10)) / 1000.0d)))));
            }
            if (!this.temps.isEmpty()) {
                linkedHashMap.put("temp", new LinkedHashMap(this.temps));
            }
            if (!this.events.isEmpty()) {
                linkedHashMap.put("events", new ArrayList(this.events));
            }
            return new BucketRecord(this.startMs, endMs, linkedHashMap);
        }

        private final int p95(List<Integer> values) {
            if (values.isEmpty()) {
                return 0;
            }
            List listI1 = r.i1(values);
            return ((Number) listI1.get(i.k((int) Math.ceil(listI1.size() * 0.95d), 1, listI1.size()) - 1)).intValue();
        }

        private final double round3(double v10) {
            return Math.round(v10 * 1000.0d) / 1000.0d;
        }

        public final void addEvent(Map<String, ? extends Object> e10) {
            k.e(e10, "e");
            this.events.add(e10);
        }

        public final void addSample(Integer powerMw, int energyUwh, Integer cpuPct, Map<String, Integer> t2, boolean charging) {
            k.e(t2, "t");
            if (powerMw != null) {
                this.powerSum += powerMw.intValue();
                this.powerCnt++;
                if (powerMw.intValue() > this.powerMax) {
                    this.powerMax = powerMw.intValue();
                }
            }
            if (this.energyStart == null) {
                this.energyStart = Integer.valueOf(energyUwh);
            }
            this.energyEnd = energyUwh;
            if (cpuPct != null) {
                this.cpuPcts.add(cpuPct);
            }
            this.temps.putAll(t2);
            if (charging) {
                this.charging = true;
            }
        }

        public final BucketRecord close(long endMs, SimpleDateFormat fmt) {
            k.e(fmt, "fmt");
            return build(endMs, fmt);
        }

        public final long getStartMs() {
            return this.startMs;
        }

        public final BucketRecord snapshot(long nowMs, SimpleDateFormat fmt) {
            k.e(fmt, "fmt");
            return build(nowMs, fmt);
        }
    }

    private ReleaseBuckets() {
    }

    private final long alignDown(long ms) {
        return ms - (ms % windowMs);
    }

    private final void closeAt(long endMs) {
        OpenBucket openBucket = open;
        if (openBucket == null) {
            return;
        }
        BucketRecord bucketRecordClose = openBucket.close(endMs, hms);
        m mVar = closed;
        mVar.addLast(bucketRecordClose);
        if (mVar.a() > 10) {
            mVar.removeFirst();
        }
        ProbeStore.INSTANCE.append("buckets", ProbeJson.INSTANCE.stringify(bucketRecordClose.getJson()));
        open = new OpenBucket(endMs);
    }

    private final void rollover(long now) {
        OpenBucket openBucket = open;
        if (openBucket == null) {
            return;
        }
        while (now - openBucket.getStartMs() >= windowMs) {
            closeAt(openBucket.getStartMs() + windowMs);
            openBucket = open;
            if (openBucket == null) {
                return;
            }
        }
    }

    public final synchronized void addEvent(long eventMs, Map<String, ? extends Object> event) {
        k.e(event, "event");
        lastEvent = event;
        lastEventMs = eventMs;
        rollover(eventMs);
        OpenBucket openBucket = open;
        if (openBucket != null) {
            openBucket.addEvent(event);
        }
    }

    public final synchronized void addSample(Integer powerMw, int energyUwh, Integer cpuPct, Map<String, Integer> temps, boolean charging) {
        k.e(temps, "temps");
        rollover(System.currentTimeMillis());
        OpenBucket openBucket = open;
        if (openBucket != null) {
            openBucket.addSample(powerMw, energyUwh, cpuPct, temps, charging);
        }
    }

    public final Map<String, Object> getLastEvent() {
        return lastEvent;
    }

    public final long getLastEventMs() {
        return lastEventMs;
    }

    public final long getWindowMs() {
        return windowMs;
    }

    public final boolean isActive() {
        return open != null;
    }

    public final void setWindowMs(long j2) {
        windowMs = j2;
    }

    public final synchronized List<BucketRecord> snapshot() {
        ArrayList arrayList;
        arrayList = new ArrayList(closed);
        OpenBucket openBucket = open;
        if (openBucket != null) {
            arrayList.add(openBucket.snapshot(System.currentTimeMillis(), hms));
        }
        return arrayList;
    }

    public final List<String> snapshotJsonLines() {
        List<BucketRecord> listSnapshot = snapshot();
        ArrayList arrayList = new ArrayList(t.A0(listSnapshot, 10));
        Iterator<T> it = listSnapshot.iterator();
        while (it.hasNext()) {
            arrayList.add(ProbeJson.INSTANCE.stringify(((BucketRecord) it.next()).getJson()));
        }
        return arrayList;
    }

    public final synchronized void start() {
        closed.clear();
        open = new OpenBucket(alignDown(System.currentTimeMillis()));
        lastEvent = null;
        lastEventMs = 0L;
    }

    public final synchronized void stop() {
        try {
            long jCurrentTimeMillis = System.currentTimeMillis();
            if (open != null) {
                INSTANCE.closeAt(jCurrentTimeMillis);
            }
            open = null;
        } catch (Throwable th) {
            throw th;
        }
    }
}
