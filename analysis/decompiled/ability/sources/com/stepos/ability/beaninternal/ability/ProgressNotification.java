package com.stepos.ability.beaninternal.ability;

import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.k;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\b\u0016\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\b\u0018\u0000 %2\u00020\u0001:\u0001%BM\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0001\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0016\b\u0002\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0001\u0018\u00010\t¢\u0006\u0004\b\n\u0010\u000bJ\u0006\u0010\u0017\u001a\u00020\u0007J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0004HÆ\u0003J\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u0004HÆ\u0003¢\u0006\u0002\u0010\u0011J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u0017\u0010\u001c\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0001\u0018\u00010\tHÆ\u0003JT\u0010\u001d\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00012\b\b\u0002\u0010\u0003\u001a\u00020\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0016\b\u0002\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0001\u0018\u00010\tHÆ\u0001¢\u0006\u0002\u0010\u001eJ\u0013\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\"\u001a\u00020#HÖ\u0001J\t\u0010$\u001a\u00020\u0007HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0001¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0015\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u001f\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0001\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016¨\u0006&"}, d2 = {"Lcom/stepos/ability/beaninternal/ability/ProgressNotification;", "", "progressToken", "progress", "", "total", "message", "", "meta", "", AppAgent.CONSTRUCT, "(Ljava/lang/Object;DLjava/lang/Double;Ljava/lang/String;Ljava/util/Map;)V", "getProgressToken", "()Ljava/lang/Object;", "getProgress", "()D", "getTotal", "()Ljava/lang/Double;", "Ljava/lang/Double;", "getMessage", "()Ljava/lang/String;", "getMeta", "()Ljava/util/Map;", "toJsonString", "component1", "component2", "component3", "component4", "component5", "copy", "(Ljava/lang/Object;DLjava/lang/Double;Ljava/lang/String;Ljava/util/Map;)Lcom/stepos/ability/beaninternal/ability/ProgressNotification;", "equals", "", "other", "hashCode", "", "toString", "Companion", "beanInternal_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class ProgressNotification {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final String message;
    private final Map<String, Object> meta;
    private final double progress;
    private final Object progressToken;
    private final Double total;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, d2 = {"Lcom/stepos/ability/beaninternal/ability/ProgressNotification$Companion;", "", AppAgent.CONSTRUCT, "()V", "fromJson", "Lcom/stepos/ability/beaninternal/ability/ProgressNotification;", "jsonString", "", "beanInternal_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(e eVar) {
            this();
        }

        public final ProgressNotification fromJson(String jsonString) {
            LinkedHashMap linkedHashMap;
            k.f(jsonString, "jsonString");
            try {
                JSONObject jSONObject = new JSONObject(jsonString);
                Object objOpt = jSONObject.opt("progressToken");
                double dOptDouble = jSONObject.optDouble("progress", 0.0d);
                Double dValueOf = Double.valueOf(jSONObject.optDouble("total", Double.NaN));
                Double d = !Double.isNaN(dValueOf.doubleValue()) ? dValueOf : null;
                String strOptString = jSONObject.optString("message", null);
                JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("_meta");
                if (jSONObjectOptJSONObject != null) {
                    LinkedHashMap linkedHashMap2 = new LinkedHashMap();
                    Iterator<String> itKeys = jSONObjectOptJSONObject.keys();
                    k.e(itKeys, "keys(...)");
                    while (itKeys.hasNext()) {
                        String next = itKeys.next();
                        linkedHashMap2.put(next, jSONObjectOptJSONObject.get(next));
                    }
                    if (linkedHashMap2.isEmpty()) {
                        linkedHashMap2 = null;
                    }
                    linkedHashMap = linkedHashMap2;
                } else {
                    linkedHashMap = null;
                }
                return new ProgressNotification(objOpt, dOptDouble, d, strOptString, linkedHashMap);
            } catch (Exception unused) {
                return null;
            }
        }

        private Companion() {
        }
    }

    public ProgressNotification() {
        this(null, 0.0d, null, null, null, 31, null);
    }

    public static /* synthetic */ ProgressNotification copy$default(ProgressNotification progressNotification, Object obj, double d, Double d6, String str, Map map, int i, Object obj2) {
        if ((i & 1) != 0) {
            obj = progressNotification.progressToken;
        }
        if ((i & 2) != 0) {
            d = progressNotification.progress;
        }
        if ((i & 4) != 0) {
            d6 = progressNotification.total;
        }
        if ((i & 8) != 0) {
            str = progressNotification.message;
        }
        if ((i & 16) != 0) {
            map = progressNotification.meta;
        }
        Map map2 = map;
        Double d10 = d6;
        return progressNotification.copy(obj, d, d10, str, map2);
    }

    /* renamed from: component1, reason: from getter */
    public final Object getProgressToken() {
        return this.progressToken;
    }

    /* renamed from: component2, reason: from getter */
    public final double getProgress() {
        return this.progress;
    }

    /* renamed from: component3, reason: from getter */
    public final Double getTotal() {
        return this.total;
    }

    /* renamed from: component4, reason: from getter */
    public final String getMessage() {
        return this.message;
    }

    public final Map<String, Object> component5() {
        return this.meta;
    }

    public final ProgressNotification copy(Object progressToken, double progress, Double total, String message, Map<String, ? extends Object> meta) {
        return new ProgressNotification(progressToken, progress, total, message, meta);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ProgressNotification)) {
            return false;
        }
        ProgressNotification progressNotification = (ProgressNotification) other;
        return k.b(this.progressToken, progressNotification.progressToken) && Double.compare(this.progress, progressNotification.progress) == 0 && k.b(this.total, progressNotification.total) && k.b(this.message, progressNotification.message) && k.b(this.meta, progressNotification.meta);
    }

    public final String getMessage() {
        return this.message;
    }

    public final Map<String, Object> getMeta() {
        return this.meta;
    }

    public final double getProgress() {
        return this.progress;
    }

    public final Object getProgressToken() {
        return this.progressToken;
    }

    public final Double getTotal() {
        return this.total;
    }

    public int hashCode() {
        Object obj = this.progressToken;
        int iHashCode = (Double.hashCode(this.progress) + ((obj == null ? 0 : obj.hashCode()) * 31)) * 31;
        Double d = this.total;
        int iHashCode2 = (iHashCode + (d == null ? 0 : d.hashCode())) * 31;
        String str = this.message;
        int iHashCode3 = (iHashCode2 + (str == null ? 0 : str.hashCode())) * 31;
        Map<String, Object> map = this.meta;
        return iHashCode3 + (map != null ? map.hashCode() : 0);
    }

    public final String toJsonString() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        Object obj = this.progressToken;
        if (obj != null) {
            jSONObject.put("progressToken", obj);
        }
        jSONObject.put("progress", this.progress);
        Double d = this.total;
        if (d != null) {
            jSONObject.put("total", d.doubleValue());
        }
        String str = this.message;
        if (str != null) {
            jSONObject.put("message", str);
        }
        Map<String, Object> map = this.meta;
        if (map != null) {
            JSONObject jSONObject2 = new JSONObject();
            for (Map.Entry<String, Object> entry : map.entrySet()) {
                jSONObject2.put(entry.getKey(), entry.getValue());
            }
            jSONObject.put("_meta", jSONObject2);
        }
        String string = jSONObject.toString();
        k.e(string, "toString(...)");
        return string;
    }

    public String toString() {
        return "ProgressNotification(progressToken=" + this.progressToken + ", progress=" + this.progress + ", total=" + this.total + ", message=" + this.message + ", meta=" + this.meta + ")";
    }

    public ProgressNotification(Object obj, double d, Double d6, String str, Map<String, ? extends Object> map) {
        this.progressToken = obj;
        this.progress = d;
        this.total = d6;
        this.message = str;
        this.meta = map;
    }

    public /* synthetic */ ProgressNotification(Object obj, double d, Double d6, String str, Map map, int i, e eVar) {
        this((i & 1) != 0 ? null : obj, (i & 2) != 0 ? 0.0d : d, (i & 4) != 0 ? null : d6, (i & 8) != 0 ? null : str, (i & 16) != 0 ? null : map);
    }
}
