package com.bytedance.android.latch.internal;

import android.text.TextUtils;
import com.bytedance.android.latch.LatchProcessOptions;
import com.bytedance.android.latch.internal.perf.LatchPerfMetricCollector;
import com.bytedance.android.latch.internal.util.LatchException;
import com.bytedance.locallife.cube.PrefetchTiming;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import io.reactivex.Maybe;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.subjects.BehaviorSubject;
import io.reactivex.subjects.PublishSubject;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes44.dex */
public final class LatchStateHolder extends com.bytedance.android.latch.internal.util.a implements com.bytedance.android.latch.internal.jsb.c {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final f f58258b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Function0<Unit> f58259c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Function0<Unit> f58260d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Function1<LatchException, Unit> f58261e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Function0<BaseLatchProcess.g> f58262f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final LatchPerfMetricCollector f58263g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final CompositeDisposable f58264h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final BehaviorSubject<JSONObject> f58265i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final AtomicInteger f58266j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final PublishSubject<Pair<String, JSONObject>> f58267k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Set<JsonPath> f58268l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final com.bytedance.android.latch.b f58269m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public String f58270n;

    public static final class JsonPath {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final JsonPath f58271c = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f58272a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final JsonPath f58273b;

        public static final class a {
        }

        static {
            f58271c = new JsonPath("__root", null);
        }

        public final Sequence<JsonPath> a() {
            return SequencesKt.sequence(new LatchStateHolder$JsonPath$walkBottomUp$1(this, null));
        }

        public JsonPath(String r100, JsonPath r101) {
            Intrinsics.checkNotNullParameter(r100, "key");
            this.f58272a = r100;
            this.f58273b = r101;
        }
    }

    @Override // com.bytedance.android.latch.internal.jsb.c
    public final Maybe<JSONObject> d() {
        BaseLatchProcess.g r100 = this.f58262f.invoke();
        if ((r100 instanceof BaseLatchProcess.g.c) == false) goto L6;
        return Maybe.error(new LatchException(-1003, "Script content still loading", null, 4, null));
    L6:
        if ((r100 instanceof BaseLatchProcess.g.b) == false) goto L9;
        return Maybe.error(((BaseLatchProcess.g.b) r100).f58251a);
    L9:
        return this.f58265i.firstElement();
    }

    @Override // com.bytedance.android.latch.internal.util.a
    public final void j() {
        this.f58264h.dispose();
    }

    @Override // com.bytedance.android.latch.internal.jsb.c
    public final Set<JsonPath> b() {
        return this.f58268l;
    }

    @Override // com.bytedance.android.latch.internal.jsb.c
    public final void e(JSONObject r100) {
        Intrinsics.checkNotNullParameter(r100, "json");
        com.bytedance.android.latch.b r101 = this.f58269m;
        Boolean r102 = Boolean.TRUE;
        String r103 = r101.f58214a.get(r101.f58215b);
        KClass r104 = Reflection.getOrCreateKotlinClass(Boolean.class);
        Object r105 = null;
        if (Intrinsics.areEqual(r104, Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L17;
        if (r103 != null) goto L44;
        Integer r106 = null;
    L9:
        if ((r106 instanceof Boolean) == false) goto L12;
        r105 = r106;
    L12:
        Boolean r107 = (Boolean) r105;     // Catch: Exception -> L6
        if (r107 == null) goto L35;
        r102 = r107;
    L35:
        if (r102.booleanValue() == true) goto L37;
        return;
    L37:
        String r108 = this.f58270n;
        if (r108 != null) goto L41;
        return;
    L41:
        if (TextUtils.equals(r108, r100.optString("version")) == true) goto L46;
        this.f58261e.invoke(new LatchException(-1004, "template version is invalid.", null, 4, null));
        return;
    L46:
        return;
    L44:
        r106 = Integer.valueOf(CastIntegerProtector.parseInt(r103));     // Catch: Exception -> L6
        goto L9
    L17:
        if (Intrinsics.areEqual(r104, Reflection.getOrCreateKotlinClass(Boolean.TYPE)) == false) goto L26;
        if (r103 == null) goto L35;
        if (Intrinsics.areEqual(r103, "1") == true) goto L35;
        if (Intrinsics.areEqual(r103, "0") == false) goto L35;
        r102 = Boolean.FALSE;
        goto L35
    L26:
        if (Intrinsics.areEqual(r104, Reflection.getOrCreateKotlinClass(String.class)) == false) goto L35;
        boolean r109 = r103 instanceof Boolean;
        Object r110 = r103;
        if (r109 == true) goto L30;
        r110 = null;
    L30:
        Boolean r111 = (Boolean) r110;
        if (r111 == null) goto L35;
        r102 = r111;
        goto L35
    }

    public final List<Pair<JsonPath, JSONObject>> k(Object r100) {
        if ((r100 instanceof JSONObject) == false) goto L9;
        if (Intrinsics.areEqual(((JSONObject) r100).optString("__type"), PrefetchTiming.JSB) == false) goto L9;
        return CollectionsKt.listOf(TuplesKt.to(JsonPath.f58271c, r100));
    L9:
        return CollectionsKt.emptyList();
    }

    public final void m(JSONObject r100) {
        Intrinsics.checkNotNullParameter(r100, "returnValue");
        if (r100.has("data") == false) goto L11;
        Object r101 = r100.get("data");
        if ((r101 instanceof JSONObject) == false) goto L10;
        JSONObject r102 = (JSONObject) r101;
        if (Intrinsics.areEqual(r102.optString("__type"), PrefetchTiming.JSB) == false) goto L9;
        final List<Pair<JsonPath, JSONObject>> r103 = k(r101);
    L12:
        LatchPerfMetricCollector r104 = this.f58263g;
        if ((!r103.isEmpty()) == false) goto L15;
        LatchPerfMetricCollector.TransferType r105 = LatchPerfMetricCollector.TransferType.OPTIMIZE;
    L16:
        r104.f(r105);
        Iterator<T> r106 = r103.iterator();
    L18:
        if (r106.hasNext() == false) goto L20;
        this.f58268l.add((JsonPath) ((Pair) r106.next()).getFirst());
        goto L18
    L20:
        this.f58265i.onNext(r100);
        this.f58266j.set(r103.size());
        Iterator<T> r107 = r103.iterator();
    L22:
        if (r107.hasNext() == false) goto L24;
        Pair r108 = (Pair) r107.next();
        JsonPath r109 = (JsonPath) r108.getFirst();
        JSONObject r110 = (JSONObject) r108.getSecond();
        this.f58268l.add(r109);
        com.bytedance.android.latch.internal.util.b.d(this.f58258b.a(JSONObjectProtectorUtils.getString(r110, "__callback_id")).subscribe(new e(r109, this, r110)), this.f58264h);
        goto L22
    L24:
        this.f58259c.invoke();
        if (this.f58266j.get() != 0) goto L30;
        this.f58260d.invoke();
        return;
    L30:
        return;
    L15:
        r105 = LatchPerfMetricCollector.TransferType.NORMAL;
        goto L16
    L9:
        r103 = new ArrayList();
        l(r102, JsonPath.f58271c, new LatchStateHolder$handleStructResult$1(this, r103));
        goto L12
    L10:
        r103 = k(r101);
        goto L12
    L11:
        r103 = CollectionsKt.emptyList();
        goto L12
    }

    public static final void l(JSONObject r100, JsonPath r101, Function2<? super JsonPath, ? super JSONObject, Boolean> r102) {
        Iterator<String> r103 = r100.keys();
    L4:
        if (r103.hasNext() == false) goto L14;
        String r104 = r103.next();
        Object r105 = r100.get(r104);
        if ((r105 instanceof JSONObject) == false) goto L8;
        JSONObject r106 = (JSONObject) r105;
    L9:
        if (r106 == null) goto L4;
        JsonPath r107 = new JsonPath(r104, r101);
        if (r102.invoke(r107, r106).booleanValue() == true) goto L4;
        l(r106, r107, r102);
        goto L4
    L8:
        r106 = null;
        goto L9
    }

    /* JADX WARN: Multi-variable type inference failed */
    public LatchStateHolder(f r100, Function0<Unit> r101, Function0<Unit> r102, Function1<? super LatchException, Unit> r103, Function0<? extends BaseLatchProcess.g> r104, LatchPerfMetricCollector r105, LatchProcessOptions r106) {
        Intrinsics.checkNotNullParameter(r100, "methodListenerStore");
        Intrinsics.checkNotNullParameter(r101, "jsEvaluationFinishCallback");
        Intrinsics.checkNotNullParameter(r102, "allFinishCallback");
        Intrinsics.checkNotNullParameter(r103, "errorCallback");
        Intrinsics.checkNotNullParameter(r104, "currentState");
        Intrinsics.checkNotNullParameter(r105, "perfMetric");
        Intrinsics.checkNotNullParameter(r106, "options");
        this.f58258b = r100;
        this.f58259c = r101;
        this.f58260d = r102;
        this.f58261e = r103;
        this.f58262f = r104;
        this.f58263g = r105;
        this.f58264h = new CompositeDisposable();
        this.f58265i = BehaviorSubject.create();
        this.f58266j = new AtomicInteger(0);
        this.f58267k = PublishSubject.create();
        this.f58268l = Collections.newSetFromMap(new ConcurrentHashMap());
        this.f58269m = new com.bytedance.android.latch.b(r106.f58209f, "enableCheckVersion");
    }
}
