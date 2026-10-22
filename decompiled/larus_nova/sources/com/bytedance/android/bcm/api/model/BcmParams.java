package com.bytedance.android.bcm.api.model;

import androidx.camera.video.AudioStats;
import com.bytedance.android.btm.api.BtmSDK;
import com.bytedance.android.livesdk.schema.BasicTestActionHandler;
import com.bytedance.mt.protector.impl.string2number.CastDoubleProtector;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import jc.c;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010%\n\u0002\b\r\b\u0017\u0018\u0000 .2\u00020\u0001:\u0001/B\u0007¢\u0006\u0004\b,\u0010-J\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u001a\u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0007\u001a\u00020\u0006H\u0007J\u001a\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0007\u001a\u00020\tH\u0007J\u001a\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0007\u001a\u00020\u000bH\u0007J\u001a\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0007\u001a\u00020\rH\u0007J\u001e\u0010\u000f\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0003\u001a\u00020\u00022\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0002H\u0007J\u0016\u0010\u0011\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u0006J\u0016\u0010\u0011\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\tJ\u0016\u0010\u0011\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u0012J\u0016\u0010\u0011\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u000bJ\u0018\u0010\u0011\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0010\u001a\u0004\u0018\u00010\u0002J\u001a\u0010\u0011\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0010\u001a\u0004\u0018\u00010\u0004H\u0007J=\u0010\u0011\u001a\u00020\u00002.\u0010\u0015\u001a\u0018\u0012\u0014\b\u0001\u0012\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u00140\u0013\"\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0014¢\u0006\u0004\b\u0011\u0010\u0016J\u0018\u0010\u0017\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0010\u001a\u0004\u0018\u00010\u0004J\u0018\u0010\u0018\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0010\u001a\u0004\u0018\u00010\u0004J\u000e\u0010\u0019\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002J=\u0010\u001a\u001a\u00020\u00002.\u0010\u0015\u001a\u0018\u0012\u0014\b\u0001\u0012\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u00140\u0013\"\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0014¢\u0006\u0004\b\u001a\u0010\u0016J\u001e\u0010\u001a\u001a\u00020\u00002\u0016\u0010\u001c\u001a\u0012\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u001bJ\u0010\u0010\u001a\u001a\u00020\u00002\b\u0010\u001d\u001a\u0004\u0018\u00010\u0000J\u0010\u0010\u001a\u001a\u00020\u00002\b\u0010\u001f\u001a\u0004\u0018\u00010\u001eJ\u0010\u0010\u001a\u001a\u00020\u00002\b\u0010 \u001a\u0004\u0018\u00010\u0002J\u0012\u0010!\u001a\u00020\u00002\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u0000J\u0006\u0010\"\u001a\u00020\u0000J\u0012\u0010$\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00040#J\u0006\u0010%\u001a\u00020\u001eJ\u0006\u0010&\u001a\u00020\u0002J\b\u0010'\u001a\u00020\u0002H\u0016R&\u0010(\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00040#8\u0004X\u0084\u0004¢\u0006\f\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+¨\u00060"}, d2 = {"Lcom/bytedance/android/bcm/api/model/BcmParams;", "Ljava/io/Serializable;", "", "key", "", "opt", "", "fallback", "optInt", "", "optLong", "", "optDouble", "", "optBoolean", "optString", "value", "put", "", "", "Lkotlin/Pair;", "pairs", "([Lkotlin/Pair;)Lcom/bytedance/android/bcm/api/model/BcmParams;", "putIfNull", "putOrRemove", "remove", "merge", "", "params", "bcmParams", "Lorg/json/JSONObject;", "trackParamsJSON", "trackParamsStr", BasicTestActionHandler.TEST_ACTION_RESET, "copy", "", "toMap", "toJSONObject", "toJSON", "toString", "map", "Ljava/util/Map;", "getMap", "()Ljava/util/Map;", "<init>", "()V", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "btm-api_cnRelease"}, k = 1, mv = {1, 4, 0})
public class BcmParams implements Serializable {
    public static final a Companion = null;
    private final Map<String, Object> map;

    public static final class a {
        public a() {
        }

        @JvmStatic
        public static BcmParams a(String r100) {
            return new BcmParams().merge(r100);
        }

        @JvmStatic
        public static BcmParams b(JSONObject r100) {
            return new BcmParams().merge(r100);
        }

        @JvmStatic
        public static BcmParams c(Map r100) {
            return new BcmParams().merge(r100);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @JvmStatic
        public static BcmParams d(Map r100) {
            BcmParams r101 = new BcmParams();
            if (r100 == null) goto L10;
            Iterator r102 = r100.entrySet().iterator();
        L6:
            if (r102.hasNext() == false) goto L10;
            Map.Entry r103 = (Map.Entry) r102.next();
            Object r104 = r103.getValue();
            if (r104 == null) goto L6;
            r101.getMap().put(r103.getKey(), r104);
        L10:
            return r101;
        }
    }

    static {
        Companion = new a();
    }

    @JvmStatic
    public static final BcmParams fromJSON(String r100) {
        Companion.getClass();
        return a.a(r100);
    }

    @JvmStatic
    public static final BcmParams fromJSON(JSONObject r100) {
        Companion.getClass();
        return a.b(r100);
    }

    @JvmStatic
    public static final BcmParams fromMap(Map<String, ? extends Object> r100) {
        Companion.getClass();
        return a.c(r100);
    }

    @JvmStatic
    public static final BcmParams fromMapNew(Map<String, ? extends Object> r100) {
        Companion.getClass();
        return a.d(r100);
    }

    public final boolean optBoolean(String r100) {
        return optBoolean$default(this, r100, false, 2, null);
    }

    public final double optDouble(String r100) {
        return optDouble$default(this, r100, AudioStats.AUDIO_AMPLITUDE_NONE, 2, null);
    }

    public final int optInt(String r100) {
        return optInt$default(this, r100, 0, 2, null);
    }

    public final long optLong(String r100) {
        return optLong$default(this, r100, 0, 2, null);
    }

    public final String optString(String r100) {
        return optString$default(this, r100, null, 2, null);
    }

    public final BcmParams copy() {
        BcmParams r100 = new BcmParams();
        Map<String, Object> r101 = this.map;
        monitor-enter(r101);
        r100.map.putAll(this.map);     // Catch: Throwable -> L7
        Unit r102 = Unit.INSTANCE;     // Catch: Throwable -> L7
        monitor-exit(r101);
        return r100;
    L7:
        th = move-exception;
        throw th;
    }

    public final JSONObject toJSONObject() {
        return cd.a.c(this.map);
    }

    public final Map<String, Object> toMap() {
        return new HashMap(this.map);
    }

    public BcmParams() {
        this.map = new ConcurrentHashMap();
    }

    public final String toJSON() {
        return toJSONObject().toString();
    }

    public String toString() {
        return toJSON();
    }

    public final Map<String, Object> getMap() {
        return this.map;
    }

    public final BcmParams merge(Map<String, ? extends Object> r100) {
        if (r100 != null) goto L4;
        return this;
    L4:
        Iterator<Map.Entry<String, ? extends Object>> r101 = r100.entrySet().iterator();
    L6:
        if (r101.hasNext() == false) goto L8;
        Map.Entry<String, ? extends Object> r102 = r101.next();
        put(r102.getKey(), r102.getValue());
        goto L6
    L8:
        return this;
    }

    public final Object opt(String r100) {
        return this.map.get(r100);
    }

    public final BcmParams put(Pair<String, ? extends Object>... r100) {
        int r101 = r100.length;
        int r102 = 0;
    L3:
        if (r102 >= r101) goto L5;
        Pair<String, ? extends Object> r103 = r100[r102];
        put(r103.getFirst(), r103.getSecond());
        r102 = r102 + 1;
        goto L3
    L5:
        return this;
    }

    public final BcmParams remove(String r100) {
        this.map.remove(r100);
        return this;
    }

    public final BcmParams reset(BcmParams r100) {
        this.map.clear();
        if (r100 == null) goto L5;
        this.map.putAll(r100.toMap());
    L5:
        return this;
    }

    public final BcmParams merge(JSONObject r100) {
        if (r100 != null) goto L12;
    L10:
        return this;
    L12:
        if (r100.length() <= 0) goto L10;
        Iterator<String> r101 = r100.keys();     // Catch: JSONException -> L11
    L7:
        if (r101.hasNext() == false) goto L10;
        String r102 = r101.next();     // Catch: JSONException -> L11
        put(r102, r100.get(r102));     // Catch: JSONException -> L11
        goto L7
    }

    public final BcmParams merge(String r100) {
        if (r100 != null) goto L4;
    L9:
        return this;
    L4:
        if (r100.length() <= 0) goto L6;
        boolean r101 = true;
    L7:
        if (r101 != true) goto L9;
        merge(new JSONObject(r100));     // Catch: Exception -> L10
        goto L9
    L6:
        r101 = false;
        goto L7
    }

    public final BcmParams merge(Pair<String, ? extends Object>... r100) {
        int r101 = r100.length;
        int r102 = 0;
    L3:
        if (r102 >= r101) goto L5;
        Pair<String, ? extends Object> r103 = r100[r102];
        put(r103.getFirst(), r103.getSecond());
        r102 = r102 + 1;
        goto L3
    L5:
        return this;
    }

    public final BcmParams merge(BcmParams r100) {
        if (r100 == null) goto L4;
        merge(r100.map);
    L4:
        return this;
    }

    public final boolean optBoolean(String r100, boolean r101) {
        int r102 = c.f498068a;
        Object r103 = this.map.get(r100);
        if ((r103 instanceof Boolean) == false) goto L6;
        Boolean r104 = (Boolean) r103;
    L14:
        if (r104 != null) goto L16;
        return r101;
    L16:
        return r104.booleanValue();
    L6:
        if ((r103 instanceof String) == false) goto L13;
        String r105 = (String) r103;
        if (StringsKt.equals("true", r105, true) == false) goto L11;
        r104 = Boolean.TRUE;
        goto L14
    L11:
        if (StringsKt.equals("false", r105, true) == false) goto L13;
        r104 = Boolean.FALSE;
    L13:
        r104 = null;
        goto L14
    }

    public final double optDouble(String r100, double r101) {
        int r102 = c.f498068a;
        Object r103 = this.map.get(r100);
        if ((r103 instanceof Double) == false) goto L6;
        Double r104 = (Double) r103;
    L13:
        if (r104 != null) goto L15;
        return r101;
    L15:
        return r104.doubleValue();
    L6:
        if ((r103 instanceof Number) == false) goto L9;
        r104 = Double.valueOf(((Number) r103).doubleValue());
        goto L13
    L9:
        if ((r103 instanceof String) == true) goto L17;
    L12:
        r104 = null;
        goto L13
    L17:
        r104 = CastDoubleProtector.valueOf((String) r103);     // Catch: NumberFormatException -> L16
        goto L13
    }

    public final int optInt(String r100, int r101) {
        int r102 = c.f498068a;
        Object r103 = this.map.get(r100);
        if ((r103 instanceof Integer) == false) goto L6;
        Integer r104 = (Integer) r103;
    L14:
        if (r104 != null) goto L16;
        return r101;
    L16:
        return r104.intValue();
    L6:
        if ((r103 instanceof Number) == false) goto L9;
        r104 = Integer.valueOf(((Number) r103).intValue());
        goto L14
    L9:
        if ((r103 instanceof String) == true) goto L18;
    L13:
        r104 = null;
        goto L14
    L18:
        r104 = 0;     // Catch: NumberFormatException -> L17
        goto L14
    }

    public final long optLong(String r100, long r101) {
        int r102 = c.f498068a;
        Object r103 = this.map.get(r100);
        if ((r103 instanceof Long) == false) goto L6;
        Long r104 = (Long) r103;
    L14:
        if (r104 != null) goto L16;
        return r101;
    L16:
        return r104.longValue();
    L6:
        if ((r103 instanceof Number) == false) goto L9;
        r104 = Long.valueOf(((Number) r103).longValue());
        goto L14
    L9:
        if ((r103 instanceof String) == true) goto L18;
    L13:
        r104 = null;
        goto L14
    L18:
        r104 = 0L;     // Catch: NumberFormatException -> L17
        goto L14
    }

    public final String optString(String r100, String r101) {
        int r102 = c.f498068a;
        Object r103 = this.map.get(r100);
        if ((r103 instanceof String) == false) goto L5;
        String r104 = (String) r103;
    L8:
        if (r104 != null) goto L10;
        return r101;
    L10:
        return r104;
    L5:
        if (r103 == null) goto L7;
        r104 = r103.toString();
        goto L8
    L7:
        r104 = null;
        goto L8
    }

    @Deprecated(message = "only basic types are supported")
    public final BcmParams put(String r100, Object r101) {
        if (r101 != null) goto L5;
    L23:
        return this;
    L5:
        if ((r101 instanceof String) == true) goto L13;
        if ((r101 instanceof Number) == true) goto L13;
        if ((r101 instanceof Boolean) == true) goto L13;
        if ((r101 instanceof JSONObject) == false) goto L20;
        this.map.put(r100, r101);
        goto L23
    L20:
        if ((r101 instanceof JSONArray) == false) goto L22;
        this.map.put(r100, r101);
        goto L23
    L22:
        this.map.put(r100, JSONObject.wrap(r101));
    L13:
        if (BtmSDK.INSTANCE.fixBcmValueNotConvert() == false) goto L15;
        this.map.put(r100, r101);
        goto L23
    L15:
        this.map.put(r100, r101.toString());
        goto L23
    }

    public final BcmParams putIfNull(String r100, Object r101) {
        Map<String, Object> r102 = this.map;
        monitor-enter(r102);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (this.map.get(r100) != null) goto L7;
        put(r100, r101);     // Catch: Throwable -> L10
    L7:
        Unit r103 = Unit.INSTANCE;     // Catch: Throwable -> L10
        monitor-exit(r102);
        return this;
    }

    public final BcmParams putOrRemove(String r100, Object r101) {
        if (r101 != null) goto L4;
        remove(r100);
    L5:
        return this;
    L4:
        put(r100, r101);
        goto L5
    }

    public final BcmParams put(String r100, double r101) {
        this.map.put(r100, Double.valueOf(r101));
        return this;
    }

    public final BcmParams put(String r100, float r101) {
        this.map.put(r100, Float.valueOf(r101));
        return this;
    }

    public final BcmParams put(String r100, int r101) {
        this.map.put(r100, Integer.valueOf(r101));
        return this;
    }

    public final BcmParams put(String r100, long r101) {
        this.map.put(r100, Long.valueOf(r101));
        return this;
    }

    public final BcmParams put(String r100, String r101) {
        if (r101 == null) goto L4;
        this.map.put(r100, r101);
    L4:
        return this;
    }

    public static /* synthetic */ BcmParams reset$default(BcmParams r100, BcmParams r101, int r102, Object r103) {
        if (r103 != null) goto L9;
        if ((r102 & 1) == 0) goto L7;
        r101 = null;
    L7:
        return r100.reset(r101);
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: reset");
    }

    public static /* synthetic */ boolean optBoolean$default(BcmParams r100, String r101, boolean r102, int r103, Object r104) {
        if (r104 != null) goto L9;
        if ((r103 & 2) == 0) goto L7;
        r102 = false;
    L7:
        return r100.optBoolean(r101, r102);
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: optBoolean");
    }

    public static /* synthetic */ double optDouble$default(BcmParams r100, String r101, double r102, int r103, Object r104) {
        if (r104 != null) goto L9;
        if ((r103 & 2) == 0) goto L7;
        r102 = Double.NaN;
    L7:
        return r100.optDouble(r101, r102);
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: optDouble");
    }

    public static /* synthetic */ int optInt$default(BcmParams r100, String r101, int r102, int r103, Object r104) {
        if (r104 != null) goto L9;
        if ((r103 & 2) == 0) goto L7;
        r102 = 0;
    L7:
        return r100.optInt(r101, r102);
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: optInt");
    }

    public static /* synthetic */ long optLong$default(BcmParams r100, String r101, long r102, int r103, Object r104) {
        if (r104 != null) goto L9;
        if ((r103 & 2) == 0) goto L7;
        r102 = 0;
    L7:
        return r100.optLong(r101, r102);
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: optLong");
    }

    public static /* synthetic */ String optString$default(BcmParams r100, String r101, String r102, int r103, Object r104) {
        if (r104 != null) goto L9;
        if ((r103 & 2) == 0) goto L7;
        r102 = null;
    L7:
        return r100.optString(r101, r102);
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: optString");
    }
}
