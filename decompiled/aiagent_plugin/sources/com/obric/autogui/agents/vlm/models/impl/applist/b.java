package com.obric.autogui.agents.vlm.models.impl.applist;

import android.content.Context;
import com.obric.autogui.common.api.AOBizTracking;
import com.obric.autogui.common.api.AOPackagesTools;
import com.obric.autogui.common.api.logging.Loog;
import com.obric.autogui.common.api.platform.packages.appinfo.OpenableAppInfo;
import com.obric.autogui.common.api.platform.tracking.IAutoActionTrackingApi;
import com.obric.autogui.common.api.threading.AOThreadingTools;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.p;
import d.c.b.a.d;
import d.c.b.a.f;
import d.c.b.a.l;
import d.h.a.m;
import d.h.b.h;
import d.o;
import d.x;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlinx.coroutines.am;
import org.json.JSONObject;

/* JADX INFO: compiled from: StdModelAppListHelper.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class b {
    private static final String TAG = "Std/AppListHelper";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f27337a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Context f27338b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Collection<OpenableAppInfo> f27339c;

    /* JADX INFO: compiled from: StdModelAppListHelper.kt */
    public static final class a {
        public /* synthetic */ a(h r1) {
            this();
        }

        private a() {
        }
    }

    /* JADX INFO: renamed from: com.obric.autogui.agents.vlm.models.impl.applist.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: StdModelAppListHelper.kt */
    @f(b = "StdModelAppListHelper.kt", c = {28}, d = "initAppList", e = "com.obric.autogui.agents.vlm.models.impl.applist.StdModelAppListHelper")
    static final class C0687b extends d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f27340a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        /* synthetic */ Object f27341b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ b f27342c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        int f27343d;

        C0687b(b r3, d.c.d<? super C0687b> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f27342c = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f27341b = r3;
            this.f27343d |= Integer.MIN_VALUE;
            return this.f27342c.a((d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: StdModelAppListHelper.kt */
    @f(b = "StdModelAppListHelper.kt", c = {}, d = "invokeSuspend", e = "com.obric.autogui.agents.vlm.models.impl.applist.StdModelAppListHelper$initAppList$2")
    static final class c extends l implements m<am, d.c.d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f27344a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ b f27345b;

        c(b r3, d.c.d<? super c> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f27345b = r3;
            super(2, r5);
        }

        public final Object a(am r3, d.c.d<? super x> r4) {
            return ((c) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), c.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r2, d.c.d<?> r3) {
            d.c.d r4 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new c(this.f27345b, r4), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            d.c.a.b.a();
            if (this.f27344a != 0) goto L12;
            o.a(r3);
            b.a(this.f27345b);     // Catch: Throwable -> L7
        L10:
            return x.f38692a;
        L7:
            th = move-exception;
            Loog.INSTANCE.e(b.TAG, "Failed to report duplicated apps", th);
            goto L10
        L12:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    static {
        f27337a = new a(null);
    }

    /* JADX INFO: renamed from: lambda$5mEYZq5SAQvCytZjGyol3z-HTzE, reason: not valid java name */
    public static /* synthetic */ CharSequence m746lambda$5mEYZq5SAQvCytZjGyol3zHTzE(Map.Entry r0) {
        return a(r0);
    }

    public b(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r4, "context");
        this.f27338b = ZeusTransformUtils.wrapperContext(r4, "com.obric.aiagent.plugin");
        this.f27339c = (Collection) ZeusTransformUtils.preCheckCast(p.b(), Collection.class, "com.obric.aiagent.plugin");
    }

    public static final /* synthetic */ void a(b r0) {
        r0.c();
    }

    public final Context getContext() {
        return this.f27338b;
    }

    public final Object a(d.c.d<? super b> r6) {
        d.c.d r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r7, C0687b.class) == false) goto L7;
        C0687b r0 = (C0687b) ZeusTransformUtils.preCheckCast(r7, C0687b.class, "com.obric.aiagent.plugin");
        if ((r0.f27343d & Integer.MIN_VALUE) == 0) goto L7;
        r0.f27343d -= Integer.MIN_VALUE;
    L8:
        Object r8 = r0.f27341b;
        Object r2 = d.c.a.b.a();
        int r3 = r0.f27343d;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        b this = (b) ZeusTransformUtils.preCheckCast(r0.f27340a, b.class, "com.obric.aiagent.plugin");
        o.a(r8);
    L17:
        this.f27339c = (Collection) ZeusTransformUtils.preCheckCast(r8, Collection.class, "com.obric.aiagent.plugin");
        AOThreadingTools.INSTANCE.launchIO((m) ZeusTransformUtils.preCheckCast(new c(this, null), m.class, "com.obric.aiagent.plugin"));
        return this;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        o.a(r8);
        AOPackagesTools r9 = AOPackagesTools.INSTANCE;
        Context r4 = this.f27338b;
        r0.f27340a = this;
        r0.f27343d = 1;
        r8 = r9.getOpenableApps(r4, r0);
        if (r8 != r2) goto L17;
        return r2;
    L7:
        r0 = new C0687b(this, r7);
        goto L8
    }

    public final List<String> a() {
        Iterable r0 = (Iterable) ZeusTransformUtils.preCheckCast(this.f27339c, Iterable.class, "com.obric.aiagent.plugin");
        Collection r1 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(p.a(r0, 10)), Collection.class, "com.obric.aiagent.plugin");
        Iterator r2 = r0.iterator();
    L4:
        if (r2.hasNext() == false) goto L7;
        r1.add(a((OpenableAppInfo) ZeusTransformUtils.preCheckCast(r2.next(), OpenableAppInfo.class, "com.obric.aiagent.plugin")));
        goto L4
    L7:
        return (List) ZeusTransformUtils.preCheckCast(r1, List.class, "com.obric.aiagent.plugin");
    }

    public final List<String[]> b() {
        Iterable r0 = (Iterable) ZeusTransformUtils.preCheckCast(this.f27339c, Iterable.class, "com.obric.aiagent.plugin");
        Collection r1 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(p.a(r0, 10)), Collection.class, "com.obric.aiagent.plugin");
        Iterator r2 = r0.iterator();
    L4:
        if (r2.hasNext() == false) goto L7;
        OpenableAppInfo r3 = (OpenableAppInfo) ZeusTransformUtils.preCheckCast(r2.next(), OpenableAppInfo.class, "com.obric.aiagent.plugin");
        r1.add(new String[]{a(r3), r3.getAppPackageName()});
        goto L4
    L7:
        return (List) ZeusTransformUtils.preCheckCast(r1, List.class, "com.obric.aiagent.plugin");
    }

    private final String a(OpenableAppInfo r1) {
        return r1.getAppLabel();
    }

    private final void c() {
        Iterable r14 = (Iterable) ZeusTransformUtils.preCheckCast(this.f27339c, Iterable.class, "com.obric.aiagent.plugin");
        Map r0 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.aiagent.plugin");
        Iterator r15 = r14.iterator();
    L4:
        if (r15.hasNext() == false) goto L9;
        Object r2 = r15.next();
        String r3 = ((OpenableAppInfo) ZeusTransformUtils.preCheckCast(r2, OpenableAppInfo.class, "com.obric.aiagent.plugin")).getAppLabel();
        Object r4 = r0.get(r3);
        if (r4 != null) goto L8;
        r4 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.aiagent.plugin");
        r0.put(r3, r4);
    L8:
        ((List) ZeusTransformUtils.preCheckCast(r4, List.class, "com.obric.aiagent.plugin")).add(r2);
        goto L4
    L9:
        Iterable r16 = (Iterable) ZeusTransformUtils.preCheckCast(r0.entrySet(), Iterable.class, "com.obric.aiagent.plugin");
        Collection r1 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");
        Iterator r17 = r16.iterator();
    L10:
        boolean r5 = true;
        if (r17.hasNext() == false) goto L18;
        Object r6 = r17.next();
        if (((List) ZeusTransformUtils.preCheckCast(((Map.Entry) ZeusTransformUtils.preCheckCast(r6, Map.Entry.class, "com.obric.aiagent.plugin")).getValue(), List.class, "com.obric.aiagent.plugin")).size() > 1) goto L16;
        r5 = false;
    L16:
        if (r5 == false) goto L10;
        r1.add(r6);
        goto L10
    L18:
        List r18 = (List) ZeusTransformUtils.preCheckCast(r1, List.class, "com.obric.aiagent.plugin");
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r18, Collection.class, "com.obric.aiagent.plugin")).isEmpty()) == false) goto L30;
        JSONObject r7 = new JSONObject();
        r7.put("case_type", "duplicated_apps");
        r7.put("string_value", p.a((Iterable) ZeusTransformUtils.preCheckCast(r18, Iterable.class, "com.obric.aiagent.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast(",", CharSequence.class, "com.obric.aiagent.plugin"), null, null, 0, null, $$Lambda$b$5mEYZq5SAQvCytZjGyol3zHTzE.INSTANCE, 30, null));
        IAutoActionTrackingApi.DefaultImpls.reportEvent$default((IAutoActionTrackingApi) ZeusTransformUtils.preCheckCast(AOBizTracking.INSTANCE, IAutoActionTrackingApi.class, "com.obric.aiagent.plugin"), "technical_recorded_case", r7, false, false, null, 28, null);
        return;
    }

    private static final CharSequence a(Map.Entry r11) {
        Map.Entry r12 = (Map.Entry) ZeusTransformUtils.wrapperContextForParams(r11, Map.Entry.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r12, "<destruct>");
        String r0 = (String) ZeusTransformUtils.preCheckCast(r12.getKey(), String.class, "com.obric.aiagent.plugin");
        Iterable r13 = (Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r12.getValue(), List.class, "com.obric.aiagent.plugin"), Iterable.class, "com.obric.aiagent.plugin");
        Collection r2 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(p.a(r13, 10)), Collection.class, "com.obric.aiagent.plugin");
        Iterator r14 = r13.iterator();
    L4:
        if (r14.hasNext() == false) goto L7;
        r2.add(((OpenableAppInfo) ZeusTransformUtils.preCheckCast(r14.next(), OpenableAppInfo.class, "com.obric.aiagent.plugin")).getType());
        goto L4
    L7:
        return (CharSequence) ZeusTransformUtils.preCheckCast(r0 + ": [" + p.a((Iterable) ZeusTransformUtils.preCheckCast(p.s((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r2, List.class, "com.obric.aiagent.plugin"), Iterable.class, "com.obric.aiagent.plugin")), Iterable.class, "com.obric.aiagent.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast(",", CharSequence.class, "com.obric.aiagent.plugin"), null, null, 0, null, null, 62, null) + ']', CharSequence.class, "com.obric.aiagent.plugin");
    }
}
