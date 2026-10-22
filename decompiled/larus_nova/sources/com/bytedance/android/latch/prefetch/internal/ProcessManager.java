package com.bytedance.android.latch.prefetch.internal;

import com.bytedance.ugc.glue.monitor.UGCMonitor;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.concurrent.Executor;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes44.dex */
public final class ProcessManager implements l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Executor f58437a;

    @Override // com.bytedance.android.latch.prefetch.internal.l
    public final void a() {
    }

    public ProcessManager(Executor r100) {
        Intrinsics.checkNotNullParameter(r100, "workerExecutor");
        this.f58437a = r100;
    }

    @Override // com.bytedance.android.latch.prefetch.internal.l
    public final void c(PrefetchHandler$1.a r100) {
        Intrinsics.checkNotNullParameter(r100, "initCallback");
        this.f58437a.execute(new c0(r100));
    }

    public static final Object f(String r100, Function1<? super String, ? extends Object> r101) {
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L4
        Object r103 = Result.m9449constructorimpl(r101.invoke(r100));     // Catch: Throwable -> L4
    L7:
        if (Result.m9452exceptionOrNullimpl(r103) == null) goto L10;
        k r104 = n.f58484a;
        String r105 = "Failed to parse param value [" + r100 + "], keeping as String.";
        Intrinsics.checkNotNullParameter(r105, "message");
        n.f58484a.onLog(r105);
    L10:
        if (Result.m9455isFailureimpl(r103) == false) goto L13;
        return r100;
    L13:
        return r103;
    L4:
        th = move-exception;
        Result.Companion r106 = Result.Companion;
        r103 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L7
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final Object d(ProcessManager r100, f0 r101, String r102) {
        r100.getClass();
        if (r102 != null) goto L5;
        return null;
    L5:
        String r103 = ((f0.a) r101).getDataType();
        if (Intrinsics.areEqual(r103, "number") == false) goto L8;
        Object r104 = f(r102, ProcessManager$toSpecifiedType$1.INSTANCE);
    L12:
        return r104;
    L8:
        r104 = r102;
        if (Intrinsics.areEqual(r103, "bool") == false) goto L12;
        r104 = f(r102, ProcessManager$toSpecifiedType$2.INSTANCE);
        goto L12
    }

    public final JSONObject e(final SortedMap<String, String> r100, final SortedMap<String, String> r110, final SortedMap<String, ? extends Object> r111, SortedMap<String, f0<?>> r112, final com.bytedance.android.latch.a.b r113) {
        JSONObject r101 = new JSONObject();
        Iterator r102 = SequencesKt.mapNotNull(CollectionsKt.asSequence(r112.entrySet()), new ProcessManager$parsePostBodyToValues$1$1(r111, r100, r110, this, r113)).iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        Pair r114 = (Pair) r102.next();
        String r115 = (String) r114.component1();
        Object r116 = r114.component2();
        r101.put(r115, r116);
        k r117 = n.f58484a;
        n.a("Append param: " + r115 + " = " + r116);
        goto L4
    L6:
        return r101;
    }

    @Override // com.bytedance.android.latch.prefetch.internal.l
    public final void b(String r110, final SortedMap r111, final com.bytedance.android.latch.a.b r112, o r210, d0 r211, String r212) {
        Intrinsics.checkNotNullParameter(r112, "dataHolder");
        Intrinsics.checkNotNullParameter(r210, "bridge");
        Intrinsics.checkNotNullParameter(r211, "config");
        Intrinsics.checkNotNullParameter(r212, "callbackId");
        k r100 = n.f58484a;
        n.a("Start request: " + r211);
        SortedMap<String, f0<?>> r101 = r211.f58476d;
        final SortedMap r102 = null;
        if (r101 == null) goto L9;
        TreeMap r103 = new TreeMap();
        Iterator r104 = SequencesKt.mapNotNull(CollectionsKt.asSequence(r101.entrySet()), new ProcessManager$parseQueryToValues$1$1(r102, r102, r111, r112)).iterator();
    L6:
        if (r104.hasNext() == false) goto L8;
        Pair r105 = (Pair) r104.next();
        String r106 = (String) r105.component1();
        Object r107 = r105.component2();
        r103.put(r106, r107);
        k r113 = n.f58484a;
        n.a("Append param: " + r106 + " = " + r107);
        goto L6
    L8:
        TreeMap r114 = r103;
    L10:
        SortedMap<String, f0<?>> r108 = r211.f58477e;
        if (r108 == null) goto L13;
        JSONObject r115 = e(null, r111, null, r108, r112);
    L14:
        PrefetchRequest r109 = new PrefetchRequest(r211.f58473a, r211.f58474b, r211.f58475c, r114, r115, r211.f58478f, r212);
        String r116 = g0.a(r109.f58427a, r109.f58430d);
        String r117 = r109.f58428b;
        Locale r118 = Locale.ROOT;
        if (r117 == null) goto L41;
        String r119 = r117.toLowerCase(r118);
        if (Intrinsics.areEqual(r119, MonitorConstants.CONNECT_TYPE_GET) == false) goto L24;
        k r120 = n.f58484a;
        String r121 = "[request_key:" + r110 + "] get";
        Intrinsics.checkNotNullParameter(r121, "message");
        n.f58484a.onLog(r121);
        Map<String, String> r122 = r109.f58429c;
        if (r122 != null) goto L22;
        r122 = MapsKt.emptyMap();
    L22:
        r210.b(r116, r122, r109.f58432f, r109.f58433g);
        return;
    L24:
        if (Intrinsics.areEqual(r119, UGCMonitor.TYPE_POST) == false) goto L38;
        k r123 = n.f58484a;
        String r124 = "[request_key:" + r110 + "] post";
        Intrinsics.checkNotNullParameter(r124, "message");
        n.f58484a.onLog(r124);
        Map<String, String> r125 = r109.f58429c;
        if (r125 != null) goto L29;
        r125 = MapsKt.emptyMap();
    L29:
        Map<String, String> r126 = r125;
        SortedMap<String, String> r127 = r109.f58429c;
        if (r127 == null) goto L33;
        String r128 = r127.get("Content-Type");
        if (r128 == null) goto L33;
    L34:
        String r129 = r128;
        JSONObject r130 = r109.f58431e;
        if (r130 != null) goto L37;
        r130 = new JSONObject();
    L37:
        r210.a(r116, r126, r129, r130, r109.f58432f, r109.f58433g);
        return;
    L33:
        r128 = "application/x-www-form-urlencoded";
        goto L34
    L38:
        k r131 = n.f58484a;
        String r132 = "No network impl for method '" + r109.f58428b + '\'';
        Intrinsics.checkNotNullParameter(r132, "message");
        n.f58484a.onLog(r132);
        return;
    L41:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
    L13:
        r115 = null;
        goto L14
    L9:
        r114 = null;
        goto L10
    }
}
