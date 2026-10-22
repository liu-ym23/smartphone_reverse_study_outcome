package com.bytedance.android.annie.service.data;

import android.os.Handler;
import com.bytedance.android.annie.Annie;
import com.bytedance.android.annie.api.data.subscribe.e;
import com.bytedance.android.annie.bridge.JSBridgeManager;
import com.bytedance.android.annie.param.GsonMap;
import com.bytedance.android.annie.param.UtilsKt;
import com.bytedance.android.annie.service.setting.AnnieConfigSettingKeys;
import com.bytedance.ies.bullet.base.utils.logger.HybridLogger;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.ies.web.jsbridge2.g;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.xiaomi.mipush.sdk.MiPushClient;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes43.dex */
public final class DataProviderService {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final ImitateRedisEngine f39852g = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f39853a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ConcurrentHashMap<String, Disposable> f39854b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public JSONArray f39855c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f39856d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f39857e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Function1<? super String, Unit> f39858f;

    public static final class ImitateRedisEngine {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ConcurrentHashMap<String, AtomicInteger> f39859a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final AtomicInteger f39860b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Lazy f39861c;

        public ImitateRedisEngine() {
            this.f39859a = new ConcurrentHashMap();
            this.f39860b = new AtomicInteger();
            this.f39861c = LazyKt.lazy(DataProviderService$ImitateRedisEngine$mainExecutor$2.INSTANCE);
        }
    }

    public static final class a {
        public static Pair b(String r110) {
            Intrinsics.checkNotNullParameter(r110, "keyParam");
            Iterator r100 = ((ConcurrentHashMap) com.bytedance.android.annie.service.data.b.f39871c).entrySet().iterator();
        L4:
            if (r100.hasNext() == false) goto L12;
            List r101 = StringsKt.split$default(r110, new char[]{((Character) ((Map.Entry) r100.next()).getKey()).charValue()}, false, 2, 2, null);
            if (((ConcurrentHashMap) com.bytedance.android.annie.service.data.b.f39870b).containsKey(ListProtector.get(r101, 0)) == false) goto L4;
            if (r101.size() != 1) goto L11;
            return new Pair(ListProtector.get(r101, 0), "");
        L11:
            return new Pair(ListProtector.get(r101, 0), ListProtector.get(r101, 1));
        L12:
            return null;
        }

        public static JsonObject a(JsonObject r100, JsonObject r101) {
            Iterator<T> r102 = r100.keySet().iterator();
        L4:
            if (r102.hasNext() == false) goto L18;
            String r103 = (String) r102.next();
            JsonElement r104 = r100.get(r103);
            JsonElement r105 = r101.get(r103);
            if ((r104 instanceof JsonObject) == true) goto L8;
            if ((r104 instanceof JsonArray) == true) goto L14;
            r101.add(r103, r104);
            goto L4
        L14:
            if ((r105 instanceof JsonArray) == true) goto L15;
            r101.add(r103, r104);
            goto L4
        L15:
            JsonArray r106 = new JsonArray();
            r106.addAll((JsonArray) r105);
            r106.addAll((JsonArray) r104);
            Unit r107 = Unit.INSTANCE;
            r101.add(r103, r106);
            goto L4
        L8:
            if ((r105 instanceof JsonObject) == true) goto L9;
            r101.add(r103, r104);
            goto L4
        L9:
            ImitateRedisEngine r108 = DataProviderService.f39852g;
            JsonObject r109 = (JsonObject) r105;
            a((JsonObject) r104, r109);
            r101.add(r103, r109);
            goto L4
        L18:
            return r101;
        }
    }

    public final class b extends g<JsonObject, JsonObject> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ DataProviderService f39862a;

        public b(DataProviderService r100) {
            this.f39862a = r100;
        }

        @Override // com.bytedance.ies.web.jsbridge2.g
        public final JsonObject invoke(JsonObject r100, CallContext r101) {
            JsonObject r102 = r100;
            Intrinsics.checkNotNullParameter(r102, "param");
            Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
            JsonObject r103 = new JsonObject();
            DataProviderService r104 = this.f39862a;
            JsonElement r105 = r102.get(MiPushClient.COMMAND_REGISTER);
            if (r105 == null) goto L12;
            JsonArray r106 = r105.getAsJsonArray();
            if (r106 == null) goto L12;
            Iterator<JsonElement> r107 = r106.iterator();
        L8:
            if (r107.hasNext() == false) goto L12;
            String r108 = r107.next().getAsString();
            if (r108 == null) goto L8;
            JSONArray r109 = new JSONArray();
            r109.put(r108);
            r104.e(r109, r103);
        L12:
            JsonElement r110 = r102.get(MiPushClient.COMMAND_UNREGISTER);
            if (r110 == null) goto L24;
            JsonArray r111 = r110.getAsJsonArray();
            if (r111 == null) goto L24;
            Iterator<JsonElement> r112 = r111.iterator();
        L18:
            if (r112.hasNext() == false) goto L24;
            String r113 = r112.next().getAsString();
            if (r113 == null) goto L18;
            Disposable r114 = r104.f39854b.get(r113);
            if (r114 == null) goto L18;
            r114.dispose();
        L24:
            return r103;
        }
    }

    public static final class c<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ DataProviderService f39863a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f39864b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ e<?> f39865c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ Map.Entry<String, List<String>> f39866d;

        /* JADX WARN: Multi-variable type inference failed */
        public c(DataProviderService r100, String r101, e<?> r102, Map.Entry<String, ? extends List<String>> r103) {
            this.f39863a = r100;
            this.f39864b = r101;
            this.f39865c = r102;
            this.f39866d = r103;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r1v4, types: [com.google.gson.JsonElement, com.google.gson.JsonObject] */
        /* JADX WARN: Type inference failed for: r9v1, types: [com.google.gson.JsonElement] */
        /* JADX WARN: Type inference failed for: r9v12, types: [com.google.gson.JsonElement] */
        /* JADX WARN: Type inference failed for: r9v2, types: [com.google.gson.JsonElement] */
        /* JADX WARN: Type inference failed for: r9v7, types: [com.google.gson.JsonObject] */
        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            ?? r101 = (JsonElement) r100;
            DataProviderService r102 = this.f39863a;
            String r103 = this.f39864b;
            String r104 = r102.f39853a;
            ImitateRedisEngine r105 = DataProviderService.f39852g;
            String r106 = r102.f39856d + ':' + r103;
            r105.getClass();
            Intrinsics.checkNotNullParameter(r106, "key");
            r105.f39859a.putIfAbsent(r106, new AtomicInteger());
            AtomicInteger r107 = r105.f39859a.get(r106);
            if (r107 != null) goto L5;
            r107 = new AtomicInteger();
            r105.f39859a.put(r106, r107);
        L5:
            r107.incrementAndGet();
            ((Handler) r105.f39861c.getValue()).postDelayed(new com.bytedance.android.annie.service.data.a(r105, r106), 5000);
            int r108 = r105.f39860b.incrementAndGet();
            if (r108 <= AnnieConfigSettingKeys.LIVE_HYBRID_SEND_SUBSCRIBER_THRESHOLD.a().intValue()) goto L14;
            JSONObject r109 = new JSONObject();
            r109.put(com.bytedance.android.ec.core.event.a.KEY_TOTAL_COUNT, r108);
            Iterator<Map.Entry<String, AtomicInteger>> r110 = r105.f39859a.entrySet().iterator();
        L9:
            if (r110.hasNext() == false) goto L13;
            Map.Entry<String, AtomicInteger> r111 = r110.next();
            if (r111.getValue().get() <= 0) goto L9;
            r109.put(r111.getKey(), r111.getValue().get());
            goto L9
        L13:
            ((k9.c) Annie.getService(k9.c.class, r104)).a1(r102.f39856d, r109);
        L14:
            Function1<? super String, Unit> r112 = this.f39863a.f39858f;
            if (r112 == null) goto L53;
            ?? r113 = new JsonObject();
            e<?> r114 = this.f39865c;
            Map.Entry<String, List<String>> r115 = this.f39866d;
            String r116 = r114.key();
            if ((r114 instanceof com.bytedance.android.annie.api.data.subscribe.a) == false) goto L19;
            com.bytedance.android.annie.api.data.subscribe.a r117 = (com.bytedance.android.annie.api.data.subscribe.a) r114;
        L21:
            if (r117 != null) goto L23;
        L25:
            boolean r118 = false;
        L26:
            if (r118 == false) goto L29;
        L41:
            r113.add(r116, r101);
            r112.invoke(UtilsKt.h(r113));
            return;
        L29:
            if (r115.getValue().size() != 1) goto L31;
            r101 = r114.a((String) CollectionsKt.single(r115.getValue()));
            goto L41
        L31:
            r101 = new JsonObject();
            Iterator<T> r119 = r115.getValue().iterator();
        L33:
            if (r119.hasNext() == false) goto L40;
            JsonElement r120 = r114.a((String) r119.next());
            if ((r120 instanceof JsonObject) == false) goto L37;
            JsonObject r121 = (JsonObject) r120;
        L38:
            if (r121 == null) goto L33;
            ImitateRedisEngine r122 = DataProviderService.f39852g;
            a.a(r121, r101);
            goto L33
        L37:
            r121 = null;
            goto L38
        L40:
            Unit r123 = Unit.INSTANCE;
            goto L41
        L23:
            if (r117.f38403b != true) goto L25;
            r118 = true;
            goto L26
        L19:
            r117 = null;
            goto L21
        }
    }

    public final void a() {
        monitor-enter(this);
        ConcurrentHashMap<String, Disposable> r100 = this.f39854b;     // Catch: Throwable -> L10
        Iterator<T> r101 = r100.values().iterator();     // Catch: Throwable -> L10
    L5:
        if (r101.hasNext() == false) goto L7;
        ((Disposable) r101.next()).dispose();     // Catch: Throwable -> L10
        goto L5
    L7:
        r100.clear();     // Catch: Throwable -> L10
        monitor-exit(this);
        return;
    L10:
        th = move-exception;
        throw th;
    }

    static {
        f39852g = new ImitateRedisEngine();
    }

    public final GsonMap b() {
        JsonObject r100 = new JsonObject();
        Map r101 = d(this.f39855c);
        if (r101 == null) goto L25;
        Iterator r102 = r101.entrySet().iterator();
    L6:
        if (r102.hasNext() == false) goto L25;
        Map.Entry r103 = (Map.Entry) r102.next();
        HybridLogger r104 = HybridLogger.f246343a;
        HybridLogger.m("DataProviderService", "DataProviderService request param, pair:(" + ((String) r103.getKey()) + ',' + r103.getValue() + ')', null, null, 12);
        ConcurrentHashMap r105 = (ConcurrentHashMap) com.bytedance.android.annie.service.data.b.f39870b;
        if (r105.containsKey(r103.getKey()) == false) goto L6;
        Object r106 = r105.get(r103.getKey());
        Intrinsics.checkNotNull(r106);
        com.bytedance.android.annie.api.data.subscribe.g r107 = ((com.bytedance.android.annie.api.data.subscribe.g) r106).c();
        if (((List) r103.getValue()).size() != 1) goto L13;
        JsonElement r108 = r107.e((String) CollectionsKt.single((List) r103.getValue()), this.f39857e);
    L23:
        HybridLogger r109 = HybridLogger.f246343a;
        HybridLogger.m("DataProviderService", "DataProviderService return, key:{" + r107.key() + ", value:" + r108 + '}', null, null, 12);
        r100.add(r107.key(), r108);
        goto L6
    L13:
        JsonObject r110 = new JsonObject();
        Iterator r111 = ((Iterable) r103.getValue()).iterator();
    L15:
        if (r111.hasNext() == false) goto L22;
        JsonElement r112 = r107.a((String) r111.next());
        if ((r112 instanceof JsonObject) == false) goto L19;
        JsonObject r113 = (JsonObject) r112;
    L20:
        if (r113 == null) goto L15;
        a.a(r113, r110);
        goto L15
    L19:
        r113 = null;
        goto L20
    L22:
        r108 = r110;
    L25:
        return UtilsKt.i(r100);
    }

    public DataProviderService(String r100) {
        Intrinsics.checkNotNullParameter(r100, "bizKey");
        this.f39853a = r100;
        this.f39854b = new ConcurrentHashMap();
        this.f39856d = "";
        this.f39857e = "";
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static Map d(final JSONArray r100) {
        if (r100 == null) goto L33;
        Sequence r101 = SequencesKt.filterNotNull(SequencesKt.map(SequencesKt.filterNotNull(SequencesKt.map(CollectionsKt.asSequence(RangesKt.until(0, r100.length())), new DataProviderService$preDealProps$1$1(r100))), DataProviderService$preDealProps$1$2.INSTANCE));
        Intrinsics.checkNotNullParameter(r101, "<this>");
        if (r101.iterator().hasNext() == false) goto L34;
        LinkedHashMap r102 = new LinkedHashMap();
        Iterator r103 = r101.iterator();
    L9:
        if (r103.hasNext() == false) goto L21;
        Pair r104 = (Pair) r103.next();
        if (r102.containsKey(r104.getFirst()) == true) goto L12;
        r102.put(r104.getFirst(), CollectionsKt.mutableListOf(new String[]{r104.getSecond()}));
        goto L9
    L12:
        Object r105 = r102.get(r104.getFirst());
        Intrinsics.checkNotNull(r105);
        Iterator r106 = ((List) r105).iterator();
    L14:
        if (r106.hasNext() == false) goto L18;
        if (StringsKt.startsWith$default((String) r106.next(), (String) r104.getSecond(), false, 2, null) == false) goto L14;
        r106.remove();
        goto L14
    L18:
        Object r107 = r102.get(r104.getFirst());
        Intrinsics.checkNotNull(r107);
        ((List) r107).add(r104.getSecond());
        goto L9
    L21:
        return r102;
    L34:
        return null;
    L33:
        return null;
    }

    public final void e(JSONArray r100, JsonObject r101) {
        Map r102 = d(r100);
        if (r102 == null) goto L29;
        Iterator r103 = r102.entrySet().iterator();
    L6:
        if (r103.hasNext() == false) goto L45;
        Map.Entry r104 = (Map.Entry) r103.next();
        String r105 = (String) r104.getKey();
        com.bytedance.android.annie.api.data.subscribe.g r106 = (com.bytedance.android.annie.api.data.subscribe.g) ((ConcurrentHashMap) com.bytedance.android.annie.service.data.b.f39870b).get(r105);
        if (r106 == null) goto L6;
        if (r101 == null) goto L12;
        r101.addProperty(r106.key(), 1);
    L12:
        if ((r106 instanceof e) == false) goto L14;
        e r107 = (e) r106;
    L15:
        if (r107 == null) goto L6;
        Iterator r108 = ((Iterable) r104.getValue()).iterator();
    L18:
        if (r108.hasNext() == false) goto L6;
        Pair<String, Observable<JsonElement>> r109 = r107.b((String) r108.next());
        if (this.f39854b.containsKey(r109.getFirst()) == true) goto L18;
        Observable<JsonElement> r110 = r109.getSecond();
        if (r110 == null) goto L18;
        Disposable r111 = r110.subscribe(new c(this, r105, r107, r104));
        if (r111 == null) goto L18;
        String r112 = r109.getFirst();
        Disposable r113 = this.f39854b.get(r112);
        if (r113 == null) goto L28;
        r113.dispose();
    L28:
        this.f39854b.put(r112, r111);
        goto L18
    L14:
        r107 = null;
        goto L15
    L45:
        return;
    }

    public final void c(String r100, JSONArray r101, JSBridgeManager r102, Function1 r103) {
        Intrinsics.checkNotNullParameter(r100, "url");
        Intrinsics.checkNotNullParameter(r103, "stateSubscriber");
        Result.Companion r104 = Result.Companion;     // Catch: Throwable -> L5
        Object r105 = Result.m9449constructorimpl(UriProtector.parse(r100).getPath());     // Catch: Throwable -> L5
    L8:
        if (Result.m9455isFailureimpl(r105) == false) goto L10;
        r105 = "unknown path";
    L10:
        Intrinsics.checkNotNull(r105);
        this.f39856d = (String) r105;
        this.f39857e = r100;
        this.f39855c = r101;
        this.f39858f = r103;
        HybridLogger r106 = HybridLogger.f246343a;
        HybridLogger.m("DataProviderService", "DataProviderService observeWith, url:" + this.f39856d + ", initialProps:" + r101, null, null, 12);
        a();
        e(r101, null);
        if (r102 == null) goto L16;
        r102.registerMethod("__updateStateObserve", new b(this));
        return;
    L16:
        return;
    L5:
        th = move-exception;
        Result.Companion r107 = Result.Companion;
        r105 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L8
    }
}
