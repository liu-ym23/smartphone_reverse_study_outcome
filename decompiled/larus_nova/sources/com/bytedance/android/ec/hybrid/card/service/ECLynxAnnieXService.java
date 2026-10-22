package com.bytedance.android.ec.hybrid.card.service;

import android.app.Activity;
import android.content.ComponentCallbacks2;
import android.content.Context;
import android.net.Uri;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.OnLifecycleEvent;
import com.bytedance.android.anniex.ui.AnnieXLynxView;
import com.bytedance.android.ec.hybrid.ECHybridExtensionsKt;
import com.bytedance.android.ec.hybrid.anniex.ECLynxAnnieXCompat;
import com.bytedance.android.ec.hybrid.anniex.ECLynxAnnieXExperiment;
import com.bytedance.android.ec.hybrid.card.impl.h;
import com.bytedance.android.ec.hybrid.card.util.ECLynxBuildUtilKt;
import com.bytedance.android.ec.hybrid.card.util.j;
import com.bytedance.android.ec.hybrid.card.util.k;
import com.bytedance.mt.protector.impl.UriProtector;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import yj.g;

/* JADX INFO: loaded from: classes44.dex */
public final class ECLynxAnnieXService {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f46553a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f46554b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Object f46555c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Lazy f46556d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Lazy f46557e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Map<String, CopyOnWriteArraySet<Integer>> f46558f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final Object f46559g = null;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Context f46560a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f46561b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final List<Object> f46562c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final boolean f46563d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final boolean f46564e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final boolean f46565f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final boolean f46566g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final int f46567h;

        public final boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof a) == false) goto L22;
            a r101 = (a) r100;
            if (Intrinsics.areEqual(this.f46560a, r101.f46560a) == true) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.f46561b, r101.f46561b) == true) goto L10;
            return false;
        L10:
            if (Intrinsics.areEqual(this.f46562c, r101.f46562c) == true) goto L12;
            return false;
        L12:
            if (this.f46563d == r101.f46563d) goto L14;
            return false;
        L14:
            if (this.f46564e == r101.f46564e) goto L16;
            return false;
        L16:
            if (this.f46565f == r101.f46565f) goto L18;
            return false;
        L18:
            if (this.f46566g == r101.f46566g) goto L20;
            return false;
        L20:
            if (this.f46567h == r101.f46567h) goto L34;
            return false;
        L34:
            return true;
        L22:
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v10, types: [int] */
        /* JADX WARN: Type inference failed for: r0v12, types: [int] */
        /* JADX WARN: Type inference failed for: r0v14, types: [int] */
        /* JADX WARN: Type inference failed for: r0v8, types: [int] */
        /* JADX WARN: Type inference failed for: r1v10 */
        /* JADX WARN: Type inference failed for: r1v11 */
        /* JADX WARN: Type inference failed for: r1v12 */
        /* JADX WARN: Type inference failed for: r1v14 */
        /* JADX WARN: Type inference failed for: r1v15 */
        /* JADX WARN: Type inference failed for: r1v16 */
        /* JADX WARN: Type inference failed for: r1v3, types: [int] */
        /* JADX WARN: Type inference failed for: r1v5, types: [int] */
        /* JADX WARN: Type inference failed for: r1v7, types: [int] */
        /* JADX WARN: Type inference failed for: r2v4 */
        /* JADX WARN: Type inference failed for: r2v5, types: [int] */
        /* JADX WARN: Type inference failed for: r2v6 */
        public final int hashCode() {
            Context r100 = this.f46560a;
            int r101 = 0;
            if (r100 == null) goto L5;
            int r102 = r100.hashCode();
        L6:
            int r103 = r102 * 31;
            String r104 = this.f46561b;
            if (r104 == null) goto L9;
            int r105 = r104.hashCode();
        L10:
            int r106 = (r103 + r105) * 31;
            List<Object> r107 = this.f46562c;
            if (r107 == null) goto L13;
            r101 = r107.hashCode();
        L13:
            int r108 = (r106 + r101) * 31;
            boolean r109 = this.f46563d;
            ?? r110 = 1;
            ?? r111 = r109;
            if (r109 == false) goto L16;
            r111 = 1;
        L16:
            int r112 = (r108 + r111) * 31;
            boolean r113 = this.f46564e;
            ?? r114 = r113;
            if (r113 == false) goto L19;
            r114 = 1;
        L19:
            int r115 = (r112 + r114) * 31;
            boolean r116 = this.f46565f;
            ?? r117 = r116;
            if (r116 == false) goto L22;
            r117 = 1;
        L22:
            int r118 = (r115 + r117) * 31;
            boolean r119 = this.f46566g;
            if (r119 == true) goto L27;
            r110 = r119;
        L27:
            return ((r118 + r110) * 31) + this.f46567h;
        L9:
            r105 = 0;
            goto L10
        L5:
            r102 = 0;
            goto L6
        }

        public final String toString() {
            return "AnnieXPreCreateParams(context=" + this.f46560a + ", initData=" + this.f46561b + ", behaviors=" + this.f46562c + ", enableJSRuntime=" + this.f46563d + ", enableLoopAsync=" + this.f46564e + ", enableStrictMode=" + this.f46565f + ", enableSyncFlush=" + this.f46566g + ", lynxThreadStrategy=" + this.f46567h + ")";
        }

        public final Context getContext() {
            return this.f46560a;
        }

        public a(Context r100, String r101, List<? extends Object> r102, boolean r103, boolean r104, boolean r105, boolean r106, int r107) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            Intrinsics.checkNotNullParameter(r102, "behaviors");
            this.f46560a = r100;
            this.f46561b = r101;
            this.f46562c = r102;
            this.f46563d = r103;
            this.f46564e = r104;
            this.f46565f = r105;
            this.f46566g = r106;
            this.f46567h = r107;
        }
    }

    public static class b {
    }

    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public h f46568a;

        public c() {
        }

        public final AnnieXLynxView a() {
            h r100 = this.f46568a;
            if (r100 != null) goto L7;
            return null;
        L7:
            return r100.f46535b;
        }
    }

    public static final class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f46569a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f46570b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final xj.a f46571c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f46572d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final String f46573e;

        public final boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof d) == false) goto L18;
            d r101 = (d) r100;
            if (Intrinsics.areEqual(this.f46569a, r101.f46569a) == true) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.f46570b, r101.f46570b) == true) goto L10;
            return false;
        L10:
            if (Intrinsics.areEqual(this.f46571c, r101.f46571c) == false) goto L24;
            r101.getClass();
            if (Intrinsics.areEqual(null, null) == true) goto L14;
            return false;
        L14:
            if (this.f46572d == r101.f46572d) goto L16;
            return false;
        L16:
            if (Intrinsics.areEqual(this.f46573e, r101.f46573e) == true) goto L28;
            return false;
        L28:
            return true;
        L24:
            return false;
        L18:
            return false;
        }

        public final int hashCode() {
            String r100 = this.f46569a;
            int r101 = 0;
            if (r100 == null) goto L5;
            int r102 = r100.hashCode();
        L6:
            int r103 = r102 * 31;
            String r104 = this.f46570b;
            if (r104 == null) goto L9;
            int r105 = r104.hashCode();
        L10:
            int r106 = (r103 + r105) * 31;
            xj.a r107 = this.f46571c;
            if (r107 == null) goto L13;
            int r108 = r107.hashCode();
        L14:
            int r109 = (((((r106 + r108) * 31) + 0) * 31) + this.f46572d) * 31;
            String r110 = this.f46573e;
            if (r110 == null) goto L18;
            r101 = r110.hashCode();
        L18:
            return r109 + r101;
        L13:
            r108 = 0;
            goto L14
        L9:
            r105 = 0;
            goto L10
        L5:
            r102 = 0;
            goto L6
        }

        public final String toString() {
            return "ECLynxPreCreateExtraParams(alreadySetData=" + this.f46569a + ", loadSchema=" + this.f46570b + ", loadSession=" + this.f46571c + ", perfSession=null, itemType=" + this.f46572d + ", sceneId=" + this.f46573e + ")";
        }

        public d(String r100, String r101, xj.a r102, k r103, int r104, String r105) {
            Intrinsics.checkNotNullParameter(r101, "loadSchema");
            Intrinsics.checkNotNullParameter(r102, "loadSession");
            this.f46569a = r100;
            this.f46570b = r101;
            this.f46571c = r102;
            this.f46572d = r104;
            this.f46573e = r105;
        }
    }

    public static final class e {
        public e() {
            throw null;
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof e) == false) goto L24;
            e r101 = (e) r100;
            r101.getClass();
            if (Intrinsics.areEqual(null, null) == true) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(null, null) == true) goto L10;
            return false;
        L10:
            if (Intrinsics.areEqual(null, null) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(null, null) == true) goto L14;
            return false;
        L14:
            if (Intrinsics.areEqual(null, null) == false) goto L32;
            r101.getClass();
            if (Intrinsics.areEqual(null, null) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(null, null) == true) goto L20;
            return false;
        L20:
            if (Intrinsics.areEqual(null, null) == true) goto L22;
            return false;
        L22:
            if (Intrinsics.areEqual(null, null) == true) goto L37;
            return false;
        L37:
            return true;
        L32:
            return false;
        L24:
            return false;
        }

        public final int hashCode() {
            return ((((((((0 + 0) * 31) + 0) * 31) + 0) * 31) + 0) * 31) + 0;
        }

        public final String toString() {
            return "ECLynxPreLoadExtraParams(ecLoadSession=null, itemType=0, itemId=null, sceneId=null, schema=null, annieXLifecycle=null, lifecycleAdapter=null, ecJsEventSubscriber=null, lynxViewProvider=null, bridgeRegistry=null, screenWidth=0)";
        }
    }

    public static final class f implements LifecycleObserver {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f46574a;

        @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
        public final void clear() {
            Lazy r100 = ECLynxAnnieXService.f46553a;
            ECLynxAnnieXService.a(this.f46574a);
        }

        public f(String r100) {
            Intrinsics.checkNotNullParameter(r100, "pageKey");
            this.f46574a = r100;
        }
    }

    public static HashMap c() {
        return (HashMap) f46556d.getValue();
    }

    static {
        f46553a = LazyKt.lazy(ECLynxAnnieXService$preCreatePageCacheKey$2.INSTANCE);
        f46554b = LazyKt.lazy(ECLynxAnnieXService$preCreateItems$2.INSTANCE);
        f46555c = new Object();
        f46556d = LazyKt.lazy(ECLynxAnnieXService$preLoadPageCacheKey$2.INSTANCE);
        f46557e = LazyKt.lazy(ECLynxAnnieXService$preLoadBlockPageName$2.INSTANCE);
        f46558f = new LinkedHashMap();
        f46559g = new Object();
    }

    public static boolean b() {
        if (ECLynxAnnieXExperiment.c().f46260a == true) goto L5;
    L7:
        return false;
    L5:
        if (ECLynxAnnieXExperiment.c().f46271l == false) goto L7;
        return true;
    }

    public static void a(String r100) {
        Object r101 = f46555c;
        monitor-enter(r101);
        List r102 = (List) ((HashMap) f46553a.getValue()).remove(r100);     // Catch: Throwable -> L13
        Unit r103 = Unit.INSTANCE;     // Catch: Throwable -> L13
        monitor-exit(r101);
        if (r102 == null) goto L19;
        Iterator r104 = r102.iterator();
    L9:
        if (r104.hasNext() == false) goto L11;
        String r105 = h(r100, (String) r104.next());
        Lazy r106 = ECLynxAnnieXCompat.f46251a;
        ECLynxAnnieXCompat.b(r105);
        ECLynxAnnieXCompat.c(r105);
        goto L9
    L11:
        r102.clear();
        return;
    L19:
        return;
    L13:
        th = move-exception;
        throw th;
    }

    public static Pair e(com.bytedance.android.ec.hybrid.card.cache.view.a r210) {
        Intrinsics.checkNotNullParameter(r210, "params");
        boolean r100 = com.bytedance.android.ec.hybrid.monitor.f.f47559a;
        com.bytedance.android.ec.hybrid.monitor.f.c("create", -1, r210.f46460b, 0, r210.f46467i);
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L28
        Lazy r102 = ECLynxAnnieXCompat.f46251a;     // Catch: Throwable -> L28
        ECLynxAnnieXCompat.f(r210.getContext());     // Catch: Throwable -> L28
        xj.a r103 = new xj.a();     // Catch: Throwable -> L28
        r103.f564027d = Long.valueOf(System.currentTimeMillis());     // Catch: Throwable -> L28
        g r104 = com.bytedance.android.ec.hybrid.a.b();     // Catch: Throwable -> L28
        if (r104 == null) goto L6;
        r104.o();     // Catch: Throwable -> L28
    L6:
        int r105 = j.f46608a;     // Catch: Throwable -> L28
        Uri r106 = UriProtector.parse(r210.f46460b);     // Catch: Throwable -> L28
        String r107 = r210.f46467i;     // Catch: Throwable -> L28
        String r108 = r210.f46468j;     // Catch: Throwable -> L28
        Intrinsics.checkNotNullParameter(r106, "originSchema");     // Catch: Throwable -> L28
        if (r107 == null) goto L15;
        if (r108 == null) goto L15;
        uj.c r109 = ECLynxBuildUtilKt.b();     // Catch: Throwable -> L28
        if (r109 == null) goto L15;
        if (r109.a() != true) goto L15;
        r106 = j.f(r106, new uj.b(r108));     // Catch: Throwable -> L28
    L15:
        String r110 = r106.toString();     // Catch: Throwable -> L28
        boolean r111 = j.b(r106);     // Catch: Throwable -> L28
        String r112 = r210.f46467i;     // Catch: Throwable -> L28
        if (r112 == null) goto L25;
        uj.c r113 = ECLynxBuildUtilKt.b();     // Catch: Throwable -> L28
        if (r113 == null) goto L25;
        List<String> r114 = r113.c();     // Catch: Throwable -> L28
        if (r114 == null) goto L25;
        if (r114.contains(r112) == false) goto L25;
        boolean r115 = true;
    L26:
        boolean r211 = j.c(r106);     // Catch: Throwable -> L28
        int r212 = j.d(r106);     // Catch: Throwable -> L28
        ra.a r116 = ECLynxAnnieXCompat.s(r106, new a(r210.getContext(), r210.f46461c, r210.f46462d, r111, r115, r211, r210.f46463e, r212), new d(r210.f46461c, r110, r103, null, r210.f46465g, r210.f46468j));     // Catch: Throwable -> L28
        com.bytedance.android.anniex.assemble.a r117 = com.bytedance.android.anniex.assemble.a.f40251a;     // Catch: Throwable -> L28
        AnnieXLynxView r118 = com.bytedance.android.anniex.api.c.a(r210.getContext(), r116);     // Catch: Throwable -> L28
        com.bytedance.android.ec.hybrid.monitor.f.c("create", 1, r210.f46460b, 0, r210.f46467i);     // Catch: Throwable -> L28
        return new Pair(r116, r118);
    L25:
        r115 = false;
    L28:
        th = move-exception;
        Result.Companion r119 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        boolean r120 = com.bytedance.android.ec.hybrid.monitor.f.f47559a;
        com.bytedance.android.ec.hybrid.monitor.f.c("create", 0, r210.f46460b, 2, r210.f46467i);
        return null;
    }

    public static String d(Context r100, String r101) {
        Activity r102 = ECHybridExtensionsKt.a(r100);
        if (r102 == null) goto L5;
        Integer r103 = Integer.valueOf(r102.hashCode());
    L7:
        return String.valueOf(r103) + '_' + r101;
    L5:
        r103 = null;
        goto L7
    }

    public static String h(String r100, String r101) {
        return r100 + '_' + r101;
    }

    public static void f(Context r100, String r101, Pair r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "pageName");
        Intrinsics.checkNotNullParameter(r102, "pair");
        String r103 = d(r100, r101);
        String r104 = h(r103, ((ra.a) r102.getFirst()).f536743a);
        Object r105 = f46555c;
        monitor-enter(r105);
        Lazy r106 = f46553a;     // Catch: Throwable -> L31
        Object r107 = null;
        if (((HashMap) r106.getValue()).containsKey(r103) == true) goto L14;
        ((HashMap) r106.getValue()).put(r103, new ArrayList());     // Catch: Throwable -> L31
        ComponentCallbacks2 r108 = ECHybridExtensionsKt.a(r100);     // Catch: Throwable -> L31
        if ((r108 instanceof LifecycleOwner) == true) goto L9;
        r108 = null;
    L9:
        LifecycleOwner r109 = (LifecycleOwner) r108;     // Catch: Throwable -> L31
        if (r109 == null) goto L14;
        Lifecycle r110 = r109.getLifecycle();     // Catch: Throwable -> L31
        if (r110 == null) goto L14;
        r110.addObserver(new f(r103));     // Catch: Throwable -> L31
    L14:
        List r111 = (List) ((HashMap) r106.getValue()).get(r103);     // Catch: Throwable -> L31
        if (r111 == null) goto L17;
        r111.add(((ra.a) r102.getFirst()).f536743a);     // Catch: Throwable -> L31
    L17:
        Lazy r112 = ECLynxAnnieXCompat.f46251a;     // Catch: Throwable -> L31
        ECLynxAnnieXCompat.t(r104, (ra.a) r102.getFirst());     // Catch: Throwable -> L31
        ECLynxAnnieXCompat.u(r104, (AnnieXLynxView) r102.getSecond());     // Catch: Throwable -> L31
        Lazy r113 = f46554b;     // Catch: Throwable -> L31
        if (((HashMap) r113.getValue()).containsKey(r101) == true) goto L20;
        ((HashMap) r113.getValue()).put(r101, new CopyOnWriteArraySet());     // Catch: Throwable -> L31
    L20:
        Object r114 = ((ra.a) r102.getFirst()).f536747e;     // Catch: Throwable -> L31
        if ((r114 instanceof d) == false) goto L24;
        r107 = r114;
    L24:
        d r115 = (d) r107;     // Catch: Throwable -> L31
        if (r115 == null) goto L29;
        CopyOnWriteArraySet r116 = (CopyOnWriteArraySet) ((HashMap) r113.getValue()).get(r101);     // Catch: Throwable -> L31
        if (r116 == null) goto L29;
        r116.add(Integer.valueOf(r115.f46572d));     // Catch: Throwable -> L31
    L29:
        monitor-exit(r105);
        return;
    L31:
        th = move-exception;
        throw th;
    }

    public static String g(String r100, String r101, String r102) {
        if (r102 == null) goto L7;
        return r100 + '_' + r101 + '_' + r102;
    L7:
        return r100 + '_' + r101;
    }
}
