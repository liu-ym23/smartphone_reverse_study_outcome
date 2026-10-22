package com.bytedance.android.annie.bridge;

import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\t\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u00102\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0011B\u0007¢\u0006\u0004\b\u000e\u0010\u000fJ\u0006\u0010\u0005\u001a\u00020\u0004J\u0006\u0010\u0006\u001a\u00020\u0004J\u0006\u0010\u0007\u001a\u00020\u0004J\u0012\u0010\n\u001a\u00020\u00042\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\bJ\u0012\u0010\n\u001a\u00020\u00042\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u000bJ\u000e\u0010\r\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u0002¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/annie/bridge/FetchTimingSession;", "Ljava/util/concurrent/ConcurrentHashMap;", "", "", "", "recordJsbStartTiming", "recordNetStartTiming", "recordNetEndTiming", "Lorg/json/JSONObject;", "json", "recordJsbEndTiming", "Lcom/google/gson/JsonObject;", "timingName", "recordTiming", "<init>", "()V", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "annie_release"}, k = 1, mv = {1, 4, 3})
public final class FetchTimingSession extends ConcurrentHashMap<String, Long> {
    public static final a Companion = null;

    public static final class a {
        public a() {
        }

        public static FetchTimingSession a(JsonObject r100) {
            Intrinsics.checkNotNullParameter(r100, "params");
            JsonPrimitive r101 = r100.getAsJsonPrimitive("enable_timing");
            if (r101 != null) goto L5;
            return null;
        L5:
            if (r101.isBoolean() == true) goto L8;
            r101 = null;
        L8:
            if (r101 == null) goto L20;
            boolean r102 = r101.getAsBoolean();
            FetchTimingSession.Companion.getClass();
            Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L14
            if (r102 == false) goto L21;
            FetchTimingSession r104 = new FetchTimingSession();     // Catch: Throwable -> L14
            r104.recordJsbStartTiming();     // Catch: Throwable -> L14
            return r104;
        L21:
            return null;
        L14:
            th = move-exception;
            Result.Companion r105 = Result.Companion;
            Result.m9449constructorimpl(ResultKt.createFailure(th));
            return null;
        L20:
            return null;
        }
    }

    static {
        Companion = new a();
    }

    public final void recordJsbStartTiming() {
        recordTiming("native_jsb_start_time");
    }

    public final void recordNetEndTiming() {
        recordTiming("native_net_end_time");
    }

    public final void recordNetStartTiming() {
        recordTiming("native_net_start_time");
    }

    @Override // java.util.concurrent.ConcurrentHashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ Set<Map.Entry<String, Long>> entrySet() {
        return getEntries();
    }

    public /* bridge */ Set<Map.Entry<String, Long>> getEntries() {
        return super.entrySet();
    }

    public /* bridge */ Set<String> getKeys() {
        return super.keySet();
    }

    public /* bridge */ int getSize() {
        return super.size();
    }

    public /* bridge */ Collection<Long> getValues() {
        return super.values();
    }

    @Override // java.util.concurrent.ConcurrentHashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ Set<String> keySet() {
        return getKeys();
    }

    @Override // java.util.concurrent.ConcurrentHashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ int size() {
        return getSize();
    }

    @Override // java.util.concurrent.ConcurrentHashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ Collection<Long> values() {
        return getValues();
    }

    public FetchTimingSession() {
    }

    @Override // java.util.concurrent.ConcurrentHashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ boolean containsKey(Object r100) {
        if ((r100 instanceof String) == true) goto L7;
        return false;
    L7:
        return containsKey((String) r100);
    }

    @Override // java.util.concurrent.ConcurrentHashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ boolean containsValue(Object r100) {
        if ((r100 instanceof Long) == true) goto L7;
        return false;
    L7:
        return containsValue((Long) r100);
    }

    @Override // java.util.concurrent.ConcurrentHashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ Long get(Object r100) {
        if ((r100 instanceof String) == true) goto L7;
        return null;
    L7:
        return get((String) r100);
    }

    public final void recordJsbEndTiming(JSONObject r100) {
        recordTiming("native_jsb_end_time");
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L9
        if (r100 == null) goto L6;
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type kotlin.collections.Map<*, *>");     // Catch: Throwable -> L9
        JSONObject r102 = r100.putOpt("perf_timing", new JSONObject(this));     // Catch: Throwable -> L9
    L7:
        Result.m9449constructorimpl(r102);     // Catch: Throwable -> L9
        return;
    L6:
        r102 = null;
    L9:
        th = move-exception;
        Result.Companion r103 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
    }

    public final void recordTiming(String r100) {
        Intrinsics.checkNotNullParameter(r100, "timingName");
        put(r100, Long.valueOf(System.currentTimeMillis()));
    }

    @Override // java.util.concurrent.ConcurrentHashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ Long remove(Object r100) {
        if ((r100 instanceof String) == true) goto L7;
        return null;
    L7:
        return remove((String) r100);
    }

    public /* bridge */ boolean containsKey(String r100) {
        return super.containsKey(r100);
    }

    public /* bridge */ boolean containsValue(Long r100) {
        return super.containsValue(r100);
    }

    @Override // java.util.concurrent.ConcurrentHashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ /* synthetic */ Object get(Object r100) {
        if ((r100 instanceof String) == true) goto L7;
        return null;
    L7:
        return get((String) r100);
    }

    public final void recordJsbEndTiming(JsonObject r100) {
        recordTiming("native_jsb_end_time");
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L9
        if (r100 == null) goto L6;
        r100.add("perf_timing", com.bytedance.android.annie.api.data.subscribe.d.b(this));     // Catch: Throwable -> L9
        Unit r102 = Unit.INSTANCE;     // Catch: Throwable -> L9
    L7:
        Result.m9449constructorimpl(r102);     // Catch: Throwable -> L9
        return;
    L6:
        r102 = null;
    L9:
        th = move-exception;
        Result.Companion r103 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
    }

    @Override // java.util.concurrent.ConcurrentHashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ /* synthetic */ Object remove(Object r100) {
        if ((r100 instanceof String) == true) goto L7;
        return null;
    L7:
        return remove((String) r100);
    }

    public /* bridge */ Long get(String r100) {
        return (Long) super.get(r100);
    }

    public /* bridge */ Long remove(String r100) {
        return (Long) super.remove(r100);
    }

    @Override // java.util.concurrent.ConcurrentHashMap, java.util.Map, java.util.concurrent.ConcurrentMap
    public final /* bridge */ /* synthetic */ Object getOrDefault(Object r100, Object r101) {
        if ((r100 instanceof String) == true) goto L6;
        return r101;
    L6:
        return getOrDefault((String) r100, (Long) r101);
    }

    @Override // java.util.concurrent.ConcurrentHashMap, java.util.Map, java.util.concurrent.ConcurrentMap
    public final /* bridge */ boolean remove(Object r100, Object r101) {
        if ((r100 instanceof String) == true) goto L6;
        return false;
    L6:
        if ((r101 instanceof Long) == true) goto L9;
        return false;
    L9:
        return remove((String) r100, (Long) r101);
    }

    public final /* bridge */ Long getOrDefault(Object r100, Long r101) {
        if ((r100 instanceof String) == true) goto L6;
        return r101;
    L6:
        return getOrDefault((String) r100, r101);
    }

    public /* bridge */ boolean remove(String r100, Long r101) {
        return super.remove(r100, r101);
    }

    public /* bridge */ Long getOrDefault(String r100, Long r101) {
        return (Long) super.getOrDefault(r100, r101);
    }

    public static /* synthetic */ void recordJsbEndTiming$default(FetchTimingSession r100, JsonObject r101, int r102, Object r103) {
        if ((r102 & 1) == 0) goto L5;
        r101 = null;
    L5:
        r100.recordJsbEndTiming(r101);
    }

    public static /* synthetic */ void recordJsbEndTiming$default(FetchTimingSession r100, JSONObject r101, int r102, Object r103) {
        if ((r102 & 1) == 0) goto L5;
        r101 = null;
    L5:
        r100.recordJsbEndTiming(r101);
    }
}
