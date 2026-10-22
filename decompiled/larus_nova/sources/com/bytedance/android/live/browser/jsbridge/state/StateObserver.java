package com.bytedance.android.live.browser.jsbridge.state;

import android.os.Handler;
import com.bytedance.android.annie.service.setting.AnnieConfigSettingKeys;
import com.bytedance.android.live.browser.BrowserServiceImpl;
import com.bytedance.android.live.browser.UtilsKt;
import com.bytedance.android.live.browser.jsbridge.i;
import com.bytedance.android.live.browser.w;
import com.bytedance.android.livesdk.config.t00;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.ies.web.jsbridge2.g;
import com.bytedance.mt.protector.impl.JSONArrayProtectorUtils;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.xiaomi.mipush.sdk.MiPushClient;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import javax.inject.Inject;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes45.dex */
public final class StateObserver implements i.d {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final a f63890h = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Inject
    public StateObservingService f63891a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Inject
    public w f63892b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ConcurrentHashMap<String, Disposable> f63893c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public JSONArray f63894d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f63895e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Function1<? super String, Unit> f63896f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f63897g;

    public static final class Companion {
        public static Pair c(String r110) {
            Intrinsics.checkNotNullParameter(r110, "keyParam");
            i.g.C1038i r100 = i.g.C1038i.f63219b;
            String r101 = ":";
            if (StringsKt.startsWith$default(r110, "setting", false, 2, null) == false) goto L5;
        L8:
            List r102 = StringsKt.split$default(r110, new String[]{r101}, false, 0, 6, null);
            if (r102.size() != 1) goto L12;
            return TuplesKt.to(r110, CollectionsKt.emptyList());
        L12:
            return new Pair(ListProtector.get(r102, 0), r102.subList(1, r102.size()));
        L5:
            if (StringsKt.contains$default(r110, ":", false, 2, null) == true) goto L8;
            r101 = ".";
            goto L8
        }

        public static JsonObject a(final StateObservingService r100, final JSONArray r101) {
            Intrinsics.checkNotNullParameter(r100, "stateObservingService");
            Intrinsics.checkNotNullParameter(r101, "jsonArray");
            JsonObject r102 = new JsonObject();
            Sequence r103 = SequencesKt.filter(SequencesKt.map(CollectionsKt.asSequence(RangesKt.until(0, r101.length())), new StateObserver$Companion$getValuesFromStates$$inlined$also$lambda$1(r101, r100)), StateObserver$Companion$getValuesFromStates$1$2.INSTANCE);
            LinkedHashMap r104 = new LinkedHashMap();
            Iterator r105 = r103.iterator();
        L4:
            if (r105.hasNext() == false) goto L9;
            String r106 = (String) r105.next();
            a r107 = StateObserver.f63890h;
            String r108 = (String) c(r106).getFirst();
            Object r109 = r104.get(r108);
            if (r109 != null) goto L8;
            r109 = new ArrayList();
            r104.put(r108, r109);
        L8:
            ((List) r109).add(r106);
            goto L4
        L9:
            Iterator r110 = r104.entrySet().iterator();
        L11:
            if (r110.hasNext() == false) goto L34;
            Map.Entry r111 = (Map.Entry) r110.next();
            String r112 = (String) r111.getKey();
            List r113 = (List) r111.getValue();
            Object r114 = ((ConcurrentHashMap) r100.f63906a).get(r112);
            if ((r114 instanceof com.bytedance.android.live.browser.jsbridge.state.a) == true) goto L15;
            r114 = null;
        L15:
            com.bytedance.android.live.browser.jsbridge.state.a r115 = (com.bytedance.android.live.browser.jsbridge.state.a) r114;
            if (r115 == null) goto L11;
            com.bytedance.android.live.browser.jsbridge.state.a r116 = r115.g();
            if (r116 == null) goto L11;
            String r117 = r116.getKey();
            if (r113.size() != 1) goto L23;
            JsonElement r118 = r116.e((String) CollectionsKt.single(r113));
        L33:
            r102.add(r117, r118);
            goto L11
        L23:
            JsonObject r119 = new JsonObject();
            Iterator r120 = r113.iterator();
        L25:
            if (r120.hasNext() == false) goto L32;
            JsonElement r121 = r116.e((String) r120.next());
            if ((r121 instanceof JsonObject) == true) goto L29;
            r121 = null;
        L29:
            JsonObject r122 = (JsonObject) r121;
            if (r122 == null) goto L25;
            a r123 = StateObserver.f63890h;
            b(r122, r119);
            goto L25
        L32:
            Unit r124 = Unit.INSTANCE;
            r118 = r119;
            goto L33
        L34:
            return r102;
        }

        public static JsonObject b(JsonObject r100, JsonObject r101) {
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
            a r108 = StateObserver.f63890h;
            JsonObject r109 = (JsonObject) r105;
            b((JsonObject) r104, r109);
            r101.add(r103, r109);
            goto L4
        L18:
            return r101;
        }
    }

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ConcurrentHashMap<String, AtomicInteger> f63898a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final AtomicInteger f63899b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Handler f63900c;

        public a() {
            this.f63898a = new ConcurrentHashMap();
            this.f63899b = new AtomicInteger();
            this.f63900c = new Handler();
        }
    }

    public final class b extends g<JsonObject, JsonObject> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ StateObserver f63901a;

        public b(StateObserver r100) {
            this.f63901a = r100;
        }

        @Override // com.bytedance.ies.web.jsbridge2.g
        public final JsonObject invoke(JsonObject r100, CallContext r101) {
            JsonObject r102 = r100;
            Intrinsics.checkNotNullParameter(r102, "param");
            Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
            JsonObject r103 = new JsonObject();
            JsonElement r104 = r102.get(MiPushClient.COMMAND_REGISTER);
            if (r104 == null) goto L12;
            JsonArray r105 = r104.getAsJsonArray();
            if (r105 == null) goto L12;
            Iterator<JsonElement> r106 = r105.iterator();
        L8:
            if (r106.hasNext() == false) goto L12;
            String r107 = r106.next().getAsString();
            if (r107 == null) goto L8;
            this.f63901a.d(r107, r103);
        L12:
            JsonElement r108 = r102.get(MiPushClient.COMMAND_UNREGISTER);
            if (r108 == null) goto L22;
            JsonArray r109 = r108.getAsJsonArray();
            if (r109 == null) goto L22;
            Iterator<JsonElement> r110 = r109.iterator();
        L18:
            if (r110.hasNext() == false) goto L22;
            String r111 = r110.next().getAsString();
            if (r111 == null) goto L18;
            this.f63901a.e(r111);
        L22:
            return r103;
        }
    }

    public static final class c<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ i.b f63902a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ StateObserver f63903b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f63904c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ String f63905d;

        public c(i.b r100, StateObserver r101, String r102, String r103) {
            this.f63902a = r100;
            this.f63903b = r101;
            this.f63904c = r102;
            this.f63905d = r103;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r110) {
            JsonElement r111 = (JsonElement) r110;
            StateObserver r100 = this.f63903b;
            String r101 = this.f63905d;
            r100.getClass();
            a r102 = StateObserver.f63890h;
            String r103 = r100.f63895e + ':' + r101;
            r102.getClass();
            Intrinsics.checkNotNullParameter(r103, "key");
            r102.f63898a.putIfAbsent(r103, new AtomicInteger());
            AtomicInteger r104 = r102.f63898a.get(r103);
            if (r104 != null) goto L5;
            r104 = new AtomicInteger();
            r102.f63898a.put(r103, r104);
        L5:
            r104.incrementAndGet();
            r102.f63900c.postDelayed(new f(r102, r103), 5000);
            int r105 = r102.f63899b.incrementAndGet();
            if (r105 <= t00.f121265a.getValue().intValue()) goto L23;
            JSONObject r112 = new JSONObject();
            r112.put(com.bytedance.android.ec.core.event.a.KEY_TOTAL_COUNT, r105);
            Iterator<Map.Entry<String, AtomicInteger>> r106 = r102.f63898a.entrySet().iterator();
        L9:
            if (r106.hasNext() == false) goto L14;
            Map.Entry<String, AtomicInteger> r107 = r106.next();
            if (r107.getValue().get() <= 0) goto L9;
            r112.put(r107.getKey(), r107.getValue().get());
            goto L9
        L14:
            if (r100.f63897g == false) goto L19;
            w r108 = r100.f63892b;
            if (r108 != null) goto L18;
            Intrinsics.throwUninitializedPropertyAccessException("lynxService");
        L18:
            r108.getHybridMonitor().reportCustomV2(null, "hybrid_state_observe_monitor", r100.f63895e, null, null, r112, null, 0);
            goto L23
        L19:
            w r109 = r100.f63892b;
            if (r109 != null) goto L22;
            Intrinsics.throwUninitializedPropertyAccessException("lynxService");
        L22:
            r109.getHybridMonitor().a(null, "hybrid_state_observe_monitor", r100.f63895e, null, null, r112, false);
        L23:
            Function1<? super String, Unit> r113 = this.f63903b.f63896f;
            if (r113 == null) goto L48;
            JsonObject r114 = new JsonObject();
            String r115 = this.f63902a.getKey();
            i.c r116 = this.f63902a;
            if ((r116 instanceof BaseObservableState) == true) goto L28;
            i.c r117 = null;
        L29:
            BaseObservableState r118 = (BaseObservableState) r117;
            if (r118 == null) goto L35;
            if (r118.f63888d != true) goto L35;
        L41:
            r114.add(r115, r111);
            Unit r119 = Unit.INSTANCE;
            Unit r120 = r113.invoke(UtilsKt.h(r114));
            return;
        L35:
            if ((r116 instanceof com.bytedance.android.live.browser.jsbridge.state.a) == true) goto L37;
            r116 = null;
        L37:
            com.bytedance.android.live.browser.jsbridge.state.a r121 = (com.bytedance.android.live.browser.jsbridge.state.a) r116;
            if (r121 == null) goto L40;
            r111 = r121.f(this.f63904c, r111);
            goto L41
        L40:
            r111 = null;
            goto L41
        L28:
            r117 = r116;
            goto L29
        }
    }

    public final void c() {
        monitor-enter(this);
        ConcurrentHashMap<String, Disposable> r100 = this.f63893c;     // Catch: Throwable -> L10
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
        f63890h = new a();
    }

    @Override // com.bytedance.android.live.browser.jsbridge.i.d
    public final JsonObject a() {
        JSONArray r100 = this.f63894d;
        if (r100 == null) goto L9;
        StateObservingService r101 = this.f63891a;
        if (r101 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("stateObservingService");
    L10:
        return Companion.a(r101, r100);
    L9:
        return new JsonObject();
    }

    public StateObserver() {
        this.f63893c = new ConcurrentHashMap();
        this.f63895e = "";
        this.f63897g = AnnieConfigSettingKeys.LIVE_HYBRID_USE_MONITOR_SAMPLE_RATE.a().booleanValue();
        BrowserServiceImpl.Companion.getClass();
        s20.a r100 = ((s20.b) BrowserServiceImpl.access$getDiComponent$cp()).a();
        this.f63891a = r100.f540207a.f540217j.get();
        this.f63892b = r100.f540207a.f540215h.get();
    }

    @Override // com.bytedance.android.live.browser.jsbridge.i.d
    public final void release() {
        c();
    }

    public final void e(String r100) {
        String r101 = (String) Companion.c(r100).getFirst();
        i.e.f r102 = i.e.f.f63209b;
        if (Intrinsics.areEqual(r101, "room_message") == true) goto L6;
        r100 = r101;
    L6:
        Disposable r103 = this.f63893c.get(r100);
        if (r103 == null) goto L10;
        r103.dispose();
        return;
    }

    public final void d(String r100, JsonObject r101) {
        String r102 = (String) Companion.c(r100).getFirst();
        StateObservingService r103 = this.f63891a;
        if (r103 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("stateObservingService");
    L5:
        i.c r104 = (i.c) ((ConcurrentHashMap) r103.f63906a).get(r102);
        if (r104 == null) goto L22;
        if (r101 == null) goto L10;
        r101.addProperty(r104.getKey(), 1);
    L10:
        if ((r104 instanceof i.b) == true) goto L12;
        r104 = null;
    L12:
        i.b r105 = (i.b) r104;
        if (r105 == null) goto L23;
        Disposable r106 = r105.a(r100).subscribe(new c(r105, this, r100, r102));
        if (r106 == null) goto L24;
        String r107 = (String) Companion.c(r100).getFirst();
        i.e.f r108 = i.e.f.f63209b;
        if (Intrinsics.areEqual(r107, "room_message") == true) goto L20;
        r100 = r107;
    L20:
        e(r100);
        this.f63893c.put(r100, r106);
        return;
    L24:
        return;
    L23:
        return;
    }

    @Override // com.bytedance.android.live.browser.jsbridge.i.d
    public final void b(String r100, JSONArray r101, Function2<? super String, ? super g<JsonObject, JsonObject>, Unit> r102, Function1<? super String, Unit> r103) {
        Intrinsics.checkNotNullParameter(r100, "url");
        Intrinsics.checkNotNullParameter(r102, "jsBridgeRegister");
        Intrinsics.checkNotNullParameter(r103, "stateSubscriber");
        Result.Companion r104 = Result.Companion;     // Catch: Throwable -> L5
        Object r105 = Result.m9449constructorimpl(UriProtector.parse(r100).getPath());     // Catch: Throwable -> L5
    L8:
        if (Result.m9455isFailureimpl(r105) == false) goto L10;
        r105 = "unknown path";
    L10:
        String r106 = (String) r105;
        if (r106 != null) goto L13;
        r106 = "";
    L13:
        this.f63895e = r106;
        this.f63894d = r101;
        c();
        this.f63896f = r103;
        if (r101 == null) goto L28;
        int r107 = r101.length();
        int r108 = 0;
    L16:
        if (r108 >= r107) goto L28;
        Result.Companion r109 = Result.Companion;     // Catch: Throwable -> L19
        Object r110 = Result.m9449constructorimpl(JSONArrayProtectorUtils.getString(r101, r108));     // Catch: Throwable -> L19
    L22:
        if (Result.m9455isFailureimpl(r110) == false) goto L24;
        r110 = null;
    L24:
        String r111 = (String) r110;
        if (r111 == null) goto L27;
        d(r111, null);
    L27:
        r108 = r108 + 1;
    L19:
        th = move-exception;
        Result.Companion r112 = Result.Companion;
        r110 = Result.m9449constructorimpl(ResultKt.createFailure(th));
    L28:
        r102.invoke("__updateStateObserve", new b(this));
        return;
    L5:
        th = move-exception;
        Result.Companion r113 = Result.Companion;
        r105 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L8
    }
}
