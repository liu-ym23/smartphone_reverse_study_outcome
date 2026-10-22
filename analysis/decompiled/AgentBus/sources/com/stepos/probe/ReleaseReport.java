package com.stepos.probe;

import com.stepos.probe.ReleaseBuckets;
import d7.r;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import m.x;
import q7.k;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u0019B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0004\u001a\u00020\u0005J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0002J \u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\f\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u000b2\u0006\u0010\b\u001a\u00020\tH\u0002J&\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u000b2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\fH\u0002J(\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\f0\u00102\u0006\u0010\u0011\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\t2\b\u0010\u0013\u001a\u0004\u0018\u00010\tH\u0002J'\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0016\u001a\u00020\f2\u0006\u0010\u0017\u001a\u00020\fH\u0002¢\u0006\u0002\u0010\u0018¨\u0006\u001a"}, d2 = {"Lcom/stepos/probe/ReleaseReport;", "", "<init>", "()V", "build", "Lcom/stepos/probe/ReleaseReport$Result;", "hasEvents", "", "rec", "Lcom/stepos/probe/ReleaseBuckets$BucketRecord;", "firstEvent", "", "", "withRole", "role", "aiDelta", "", "baseline", "active", "tail", "intOf", "", "group", "key", "(Lcom/stepos/probe/ReleaseBuckets$BucketRecord;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/Integer;", "Result", "probe-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class ReleaseReport {
    public static final ReleaseReport INSTANCE = new ReleaseReport();

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00030\u0006HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J9\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u0006¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000b¨\u0006\u001b"}, d2 = {"Lcom/stepos/probe/ReleaseReport$Result;", "", "json", "", "pretty", "deltaLines", "", "note", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;)V", "getJson", "()Ljava/lang/String;", "getPretty", "getDeltaLines", "()Ljava/util/List;", "getNote", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "probe-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final /* data */ class Result {
        private final List<String> deltaLines;
        private final String json;
        private final String note;
        private final String pretty;

        public Result(String str, String str2, List<String> list, String str3) {
            k.e(str, "json");
            k.e(str2, "pretty");
            k.e(list, "deltaLines");
            this.json = str;
            this.pretty = str2;
            this.deltaLines = list;
            this.note = str3;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Result copy$default(Result result, String str, String str2, List list, String str3, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                str = result.json;
            }
            if ((i2 & 2) != 0) {
                str2 = result.pretty;
            }
            if ((i2 & 4) != 0) {
                list = result.deltaLines;
            }
            if ((i2 & 8) != 0) {
                str3 = result.note;
            }
            return result.copy(str, str2, list, str3);
        }

        /* renamed from: component1, reason: from getter */
        public final String getJson() {
            return this.json;
        }

        /* renamed from: component2, reason: from getter */
        public final String getPretty() {
            return this.pretty;
        }

        public final List<String> component3() {
            return this.deltaLines;
        }

        /* renamed from: component4, reason: from getter */
        public final String getNote() {
            return this.note;
        }

        public final Result copy(String json, String pretty, List<String> deltaLines, String note) {
            k.e(json, "json");
            k.e(pretty, "pretty");
            k.e(deltaLines, "deltaLines");
            return new Result(json, pretty, deltaLines, note);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Result)) {
                return false;
            }
            Result result = (Result) other;
            return k.a(this.json, result.json) && k.a(this.pretty, result.pretty) && k.a(this.deltaLines, result.deltaLines) && k.a(this.note, result.note);
        }

        public final List<String> getDeltaLines() {
            return this.deltaLines;
        }

        public final String getJson() {
            return this.json;
        }

        public final String getNote() {
            return this.note;
        }

        public final String getPretty() {
            return this.pretty;
        }

        public int hashCode() {
            int iH = x.h(this.deltaLines, x.g(this.pretty, this.json.hashCode() * 31, 31), 31);
            String str = this.note;
            return iH + (str == null ? 0 : str.hashCode());
        }

        public String toString() {
            String str = this.json;
            String str2 = this.pretty;
            List<String> list = this.deltaLines;
            String str3 = this.note;
            StringBuilder sbP = a1.a.p("Result(json=", str, ", pretty=", str2, ", deltaLines=");
            sbP.append(list);
            sbP.append(", note=");
            sbP.append(str3);
            sbP.append(")");
            return sbP.toString();
        }
    }

    private ReleaseReport() {
    }

    private final List<String> aiDelta(ReleaseBuckets.BucketRecord baseline, ReleaseBuckets.BucketRecord active, ReleaseBuckets.BucketRecord tail) {
        Integer numIntOf;
        ArrayList arrayList = new ArrayList();
        Integer numIntOf2 = intOf(active, "power", "avg_mw");
        if (numIntOf2 != null) {
            int iIntValue = numIntOf2.intValue();
            Integer numIntOf3 = INSTANCE.intOf(baseline, "power", "avg_mw");
            if (numIntOf3 != null) {
                int iIntValue2 = numIntOf3.intValue();
                arrayList.add("AI 能耗增量: active " + iIntValue + "mW - baseline " + iIntValue2 + "mW = " + (iIntValue - iIntValue2) + "mW");
            }
        }
        Integer numIntOf4 = intOf(active, "cpu", "avg");
        if (numIntOf4 != null) {
            int iIntValue3 = numIntOf4.intValue();
            Integer numIntOf5 = INSTANCE.intOf(baseline, "cpu", "avg");
            if (numIntOf5 != null) {
                int iIntValue4 = numIntOf5.intValue();
                arrayList.add("AI CPU 增量: " + iIntValue3 + "% - " + iIntValue4 + "% = " + (iIntValue3 - iIntValue4) + "%");
            }
        }
        Integer numIntOf6 = intOf(active, "temp", "battery");
        if (numIntOf6 != null) {
            int iIntValue5 = numIntOf6.intValue();
            Integer numIntOf7 = INSTANCE.intOf(baseline, "temp", "battery");
            if (numIntOf7 != null) {
                int iIntValue6 = numIntOf7.intValue();
                arrayList.add("AI 温升(battery): " + iIntValue5 + "°C - " + iIntValue6 + "°C = " + (iIntValue5 - iIntValue6) + "°C");
            }
        }
        if (tail != null && (numIntOf = intOf(tail, "power", "avg_mw")) != null) {
            int iIntValue7 = numIntOf.intValue();
            Integer numIntOf8 = INSTANCE.intOf(baseline, "power", "avg_mw");
            if (numIntOf8 != null) {
                int iIntValue8 = numIntOf8.intValue();
                arrayList.add("尾效能耗: tail " + iIntValue7 + "mW - baseline " + iIntValue8 + "mW = " + (iIntValue7 - iIntValue8) + "mW");
            }
        }
        return arrayList;
    }

    private final Map<String, Object> firstEvent(ReleaseBuckets.BucketRecord rec) {
        Object obj = rec.getJson().get("events");
        List list = obj instanceof List ? (List) obj : null;
        if (list == null) {
            return null;
        }
        Object objP0 = r.P0(list);
        if (objP0 instanceof Map) {
            return (Map) objP0;
        }
        return null;
    }

    private final boolean hasEvents(ReleaseBuckets.BucketRecord rec) {
        Object obj = rec.getJson().get("events");
        if ((obj instanceof List ? (List) obj : null) == null) {
            return false;
        }
        return !r0.isEmpty();
    }

    private final Integer intOf(ReleaseBuckets.BucketRecord rec, String group, String key) {
        Object obj = rec.getJson().get(group);
        Map map = obj instanceof Map ? (Map) obj : null;
        if (map == null) {
            return null;
        }
        Object obj2 = map.get(key);
        Number number = obj2 instanceof Number ? (Number) obj2 : null;
        if (number != null) {
            return Integer.valueOf(number.intValue());
        }
        return null;
    }

    private final Map<String, Object> withRole(ReleaseBuckets.BucketRecord rec, String role) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("time", rec.getJson().get("time"));
        linkedHashMap.put("role", role);
        for (Map.Entry<String, Object> entry : rec.getJson().entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();
            if (!k.a(key, "time")) {
                linkedHashMap.put(key, value);
            }
        }
        return linkedHashMap;
    }

    /* JADX WARN: Removed duplicated region for block: B:67:0x0171 A[PHI: r13
      0x0171: PHI (r13v12 java.lang.Object) = (r13v2 java.lang.Object), (r13v3 java.lang.Object) binds: [B:66:0x016f, B:69:0x017e] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final com.stepos.probe.ReleaseReport.Result build() {
        /*
            Method dump skipped, instructions count: 609
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.probe.ReleaseReport.build():com.stepos.probe.ReleaseReport$Result");
    }
}
