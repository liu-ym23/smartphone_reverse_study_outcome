package com.bytedance.ai.applet.app.foundation.performance;

import android.content.Context;
import com.bytedance.ee.bear.wikiv2.browser.plugin.WikiFolderPushPlugin;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class c implements com.bytedance.ai.applet.app.foundation.w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f34270a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f34271b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Object f34272c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ArrayDeque<f> f34273d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Map<Long, k> f34274e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f34275f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Long f34276g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f34277h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f34278i;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.ai.applet.app.foundation.w
    public final void d() {
    }

    public final List<f> c() {
        Object r100 = this.f34272c;
        monitor-enter(r100);
        List<f> r101 = CollectionsKt.toList(this.f34273d);     // Catch: Throwable -> L7
        monitor-exit(r100);
        return r101;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // com.bytedance.ai.applet.app.foundation.w
    public final void onDestroy() {
        Object r100 = this.f34272c;
        monitor-enter(r100);
    L14:
        th = move-exception;
        throw th;
    L5:
        if (this.f34278i == false) goto L7;
        List r101 = CollectionsKt.emptyList();     // Catch: Throwable -> L14
    L8:
        monitor-exit(r100);
        Iterator r102 = r101.iterator();
    L11:
        if (r102.hasNext() == false) goto L13;
        k r103 = (k) r102.next();
        r103.getClass();
        k.d(r103, AppletPerformanceOutcome.CANCELLED, 0, AppletPerformanceErrorCode.CANCELLED, "applet_destroyed", 2);
        goto L11
    L13:
        return;
    L7:
        this.f34278i = true;     // Catch: Throwable -> L14
        this.f34276g = null;     // Catch: Throwable -> L14
        r101 = CollectionsKt.toList(((LinkedHashMap) this.f34274e).values());     // Catch: Throwable -> L14
        ((LinkedHashMap) this.f34274e).clear();     // Catch: Throwable -> L14
        this.f34273d.clear();     // Catch: Throwable -> L14
        goto L8
    }

    @Override // com.bytedance.ai.applet.app.foundation.w
    public final void a(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
    }

    public final r b(p r100) {
        Intrinsics.checkNotNullParameter(r100, "config");
        r r101 = new r(this, r100);
        Object r102 = this.f34272c;
        monitor-enter(r102);
        this.f34274e.put(Long.valueOf(r101.f34341c), r101);     // Catch: Throwable -> L7
        Unit r103 = Unit.INSTANCE;     // Catch: Throwable -> L7
        monitor-exit(r102);
        return r101;
    L7:
        th = move-exception;
        throw th;
    }

    public final List<f> e(String r100) {
        Intrinsics.checkNotNullParameter(r100, "entryType");
        Object r101 = this.f34272c;
        monitor-enter(r101);
        ArrayDeque<f> r102 = this.f34273d;     // Catch: Throwable -> L13
        ArrayList r103 = new ArrayList();     // Catch: Throwable -> L13
        Iterator<f> r104 = r102.iterator();     // Catch: Throwable -> L13
    L6:
        if (r104.hasNext() == false) goto L11;
        f r105 = r104.next();     // Catch: Throwable -> L13
        if (Intrinsics.areEqual(r105.a().getEntryType().getValue(), r100) == false) goto L6;
        r103.add(r105);     // Catch: Throwable -> L13
        goto L6
    L11:
        monitor-exit(r101);
        return r103;
    L13:
        th = move-exception;
        throw th;
    }

    public final r f(long r100) {
        if (r100 <= 0) goto L5;
        boolean r101 = true;
    L6:
        r r102 = null;
        if (r101 == true) goto L9;
        return null;
    L9:
        Object r103 = this.f34272c;
        monitor-enter(r103);
        Map<Long, k> r104 = this.f34274e;     // Catch: Throwable -> L16
        LinkedHashMap r105 = (LinkedHashMap) r104;     // Catch: Throwable -> L16
        Object r106 = r105.get(Long.valueOf(r100));     // Catch: Throwable -> L16
        if ((r106 instanceof r) == false) goto L14;
        r102 = (r) r106;     // Catch: Throwable -> L16
    L14:
        monitor-exit(r103);
        return r102;
    L16:
        th = move-exception;
        throw th;
    L5:
        r101 = false;
        goto L6
    }

    @Override // com.bytedance.ai.applet.app.foundation.w
    public final void g(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
    }

    @Override // com.bytedance.ai.applet.app.foundation.w
    public final void h(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v2, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r1v3, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r1v4, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r4v0 */
    public final void j(f r100) {
        Intrinsics.checkNotNullParameter(r100, "entry");
        com.bytedance.ai.applet.base.log.b r101 = com.bytedance.ai.applet.base.log.a.f34518a;
        com.bytedance.ai.applet.base.log.a.c("AppletPerformance", "record entry: " + r100);
        if (r100.e() == true) goto L6;
        k("record", "invalid entry: " + r100);
        return;
    L6:
        List r102 = CollectionsKt.listOf(r100);
        Intrinsics.checkNotNullParameter(r102, "entries");
        ?? r103 = new ArrayList();
        Iterator r104 = r102.iterator();
    L8:
        if (r104.hasNext() == false) goto L12;
        Object r105 = r104.next();
        if (((f) r105).e() == false) goto L8;
        r103.add(r105);
        goto L8
    L12:
        int r106 = r102.size() - r103.size();
        if (r106 <= 0) goto L16;
        k("recordAll", "discarded " + r106 + " invalid entries");
    L16:
        if (r103.isEmpty() == true) goto L62;
        Object r107 = this.f34272c;
        monitor-enter(r107);
    L46:
        th = move-exception;
        throw th;
    L21:
        if (this.f34278i == true) goto L29;
        Iterator r108 = r103.iterator();     // Catch: Throwable -> L46
    L24:
        if (r108.hasNext() == false) goto L30;
        this.f34273d.addLast((f) r108.next());     // Catch: Throwable -> L46
    L27:
        if (this.f34273d.size() <= this.f34275f) goto L24;
        this.f34273d.removeFirst();     // Catch: Throwable -> L46
    L30:
        monitor-exit(r107);
        if (r103.isEmpty() == false) goto L49;
        com.bytedance.ai.applet.base.log.a.b("AppletPerformance", "publishPerformanceEntries: empty entries", null);
        return;
    L49:
        Result.Companion r109 = Result.Companion;     // Catch: Throwable -> L40
        JsonObject r110 = new JsonObject();     // Catch: Throwable -> L40
        Gson r111 = com.bytedance.ai.applet.base.gson.c.a();     // Catch: Throwable -> L40
        Iterable r112 = (Iterable) r103;     // Catch: Throwable -> L40
        ArrayList r113 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r112, 10));     // Catch: Throwable -> L40
        Iterator r114 = r112.iterator();     // Catch: Throwable -> L40
    L36:
        if (r114.hasNext() == false) goto L38;
        r113.add(e4.a.b((f) r114.next()));     // Catch: Throwable -> L40
        goto L36
    L38:
        r110.add("entries", r111.toJsonTree(r113));     // Catch: Throwable -> L40
        com.bytedance.ai.applet.base.log.b r115 = com.bytedance.ai.applet.base.log.a.f34518a;     // Catch: Throwable -> L40
        com.bytedance.ai.applet.base.log.a.c("AppletPerformance", "publishPerformanceEntries: " + r110);     // Catch: Throwable -> L40
        l3.a r116 = new l3.a("doubao.onPerformanceEntries", r110, 4);     // Catch: Throwable -> L40
        r116.f507199d = this.f34270a;     // Catch: Throwable -> L40
        l3.d.c(r116);     // Catch: Throwable -> L40
        Object r117 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L40
    L42:
        Throwable r118 = Result.m9452exceptionOrNullimpl(r117);
        if (r118 == null) goto L61;
        k("publishPerformanceEntries", "failed to publish " + r103.size() + " entries: " + r118.getMessage());
        return;
    L61:
        return;
    L40:
        th = move-exception;
        Result.Companion r119 = Result.Companion;
        r117 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L42
    L29:
        r103 = CollectionsKt.emptyList();     // Catch: Throwable -> L46
        goto L30
    }

    public final boolean l(long r100) {
        boolean r101 = false;
        if (h.a(r100) == true) goto L6;
        k("startAppLaunch", "invalid startTime: " + r100);
        return false;
    L6:
        Object r102 = this.f34272c;
        monitor-enter(r102);
    L21:
        th = move-exception;
        throw th;
    L9:
        if (this.f34278i == false) goto L11;
    L17:
        monitor-exit(r102);
        if (r101 == true) goto L20;
        k("startAppLaunch", "launch already started, completed, or destroyed");
    L20:
        return r101;
    L11:
        if (this.f34277h == true) goto L17;
        if (this.f34276g != null) goto L17;
        this.f34276g = Long.valueOf(r100);     // Catch: Throwable -> L21
        r101 = true;
        goto L17
    }

    public c(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "appId");
        Intrinsics.checkNotNullParameter(r101, "appName");
        this.f34270a = r100;
        this.f34271b = r101;
        this.f34272c = new Object();
        this.f34273d = new ArrayDeque();
        this.f34274e = new LinkedHashMap();
        this.f34275f = 30;
    }

    public static void k(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, WikiFolderPushPlugin.OPT);
        Intrinsics.checkNotNullParameter(r101, "reason");
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L5
        com.bytedance.ai.applet.base.log.b r103 = com.bytedance.ai.applet.base.log.a.f34518a;     // Catch: Throwable -> L5
        com.bytedance.ai.applet.base.log.a.b("AppletPerformance", r100 + " ignored: " + r101, null);     // Catch: Throwable -> L5
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        Result.Companion r104 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
    }

    public final void i(k r100, e r101) {
        Intrinsics.checkNotNullParameter(r100, com.bytedance.android.ec.core.event.a.KEY_TRACKER);
        Object r102 = this.f34272c;
        monitor-enter(r102);
        this.f34274e.remove(Long.valueOf(r100.f34341c), r100);     // Catch: Throwable -> L9
        monitor-exit(r102);
        if (r101 == null) goto L14;
        Intrinsics.checkNotNullParameter(r101, "event");
        Map<String, Object> r103 = r101.c();
        com.bytedance.ai.applet.base.log.b r104 = com.bytedance.ai.applet.base.log.a.f34518a;
        com.bytedance.ai.applet.base.log.a.c("AppletPerformance", "reportAnalyticsEvent: " + r103);
        AtomicBoolean r105 = com.bytedance.ai.monitor.b.f37194a;
        com.bytedance.ai.monitor.b.d(r101.b(), new d(r103));
        return;
    L14:
        return;
    L9:
        th = move-exception;
        throw th;
    }
}
