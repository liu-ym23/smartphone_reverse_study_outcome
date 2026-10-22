package com.obric.memorydata.sdk.intent;

import com.google.gson.JsonSyntaxException;
import com.obric.capabilitykit.common.intent.AppIntentImplInfo;
import com.obric.capabilitykit.common.intent.IntentResult;
import com.obric.capabilitykit.entity.app.AppEntity;
import com.obric.capabilitykit.entity.search.InAppSearchEntity;
import com.obric.capabilitykit.entity.search.InAppSearchRequest;
import com.obric.capabilitykit.entity.search.InAppSearchResult;
import com.obric.capabilitykit.entity.search.InAppSearchResultWithoutEntity;
import com.obric.capabilitykit.search.IAppSearchCallback;
import com.obric.capabilitykit.search.InAppSearchClient;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.p;
import d.c.b.a.f;
import d.c.b.a.l;
import d.h.a.m;
import d.h.b.o;
import d.x;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlinx.coroutines.am;
import kotlinx.coroutines.dg;
import kotlinx.coroutines.w;
import kotlinx.coroutines.y;

/* JADX INFO: compiled from: InAppSearchIntentExecutor.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f33834a = null;

    /* JADX INFO: renamed from: com.obric.memorydata.sdk.intent.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: InAppSearchIntentExecutor.kt */
    public static final class C0917a extends Exception {
        public C0917a(String r2) {
            o.e(r2, "message");
            super(r2);
        }
    }

    /* JADX INFO: compiled from: InAppSearchIntentExecutor.kt */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final AppEntity[] f33835a;

        public b(AppEntity[] r2) {
            o.e(r2, "entities");
            this.f33835a = r2;
        }

        public final AppEntity[] a() {
            return this.f33835a;
        }
    }

    /* JADX INFO: compiled from: InAppSearchIntentExecutor.kt */
    @f(b = "InAppSearchIntentExecutor.kt", c = {82}, d = "doAction", e = "com.obric.memorydata.sdk.intent.InAppSearchIntentExecutor")
    static final class c extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        /* synthetic */ Object f33836a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ a f33837b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int f33838c;

        c(a r3, d.c.d<? super c> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f33837b = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r8) {
            this.f33836a = r8;
            this.f33838c |= Integer.MIN_VALUE;
            return this.f33837b.a(null, null, 0, null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: InAppSearchIntentExecutor.kt */
    public static final class d implements IAppSearchCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ List<AppEntity> f33839a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ w<IntentResult<AppEntity[]>> f33840b;

        @Override // com.obric.capabilitykit.search.IAppSearchCallback
        public void onSearchResultWithoutEntity(InAppSearchResultWithoutEntity r1) {
            o.e(r1, "result");
        }

        d(List<AppEntity> r3, w<IntentResult<AppEntity[]>> r4) {
            List<AppEntity> r5 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
            w<IntentResult<AppEntity[]>> r6 = (w) ZeusTransformUtils.wrapperContextForParams(r4, w.class, "com.obric.aiagent.plugin");
            this.f33839a = r5;
            this.f33840b = r6;
        }

        @Override // com.obric.capabilitykit.search.IAppSearchCallback
        public void onCompleted() {
            List<AppEntity> r0 = this.f33839a;
            w<IntentResult<AppEntity[]>> r15 = this.f33840b;
            monitor-enter(r0);
            r15.a(new IntentResult(0, (AppEntity[]) ZeusTransformUtils.preCheckCast(((Collection) ZeusTransformUtils.preCheckCast(r0, Collection.class, "com.obric.aiagent.plugin")).toArray(new AppEntity[0]), AppEntity[].class, "com.obric.aiagent.plugin"), null, null, false, false, 256, null, null, null, 956, null));     // Catch: Throwable -> L7
            monitor-exit(r0);
            return;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // com.obric.capabilitykit.search.IAppSearchCallback
        public void onError(int r14, String r15) {
            o.e(r15, "errorMsg");
            this.f33840b.a(new IntentResult(-2002, null, null, "InAppSearch errorCode: " + r14 + ", errorMsg: " + r15, false, false, 256, null, null, null, 950, null));
        }

        @Override // com.obric.capabilitykit.search.IAppSearchCallback
        public void onSearchResult(InAppSearchResult r5) {
            o.e(r5, "result");
            List<AppEntity> r4 = this.f33839a;
            monitor-enter(r4);
            Iterable r6 = (Iterable) ZeusTransformUtils.preCheckCast(r5.getEntities(), Iterable.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L11
            Collection r0 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(p.a(r6, 10)), Collection.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L11
            Iterator r7 = r6.iterator();     // Catch: Throwable -> L11
        L6:
            if (r7.hasNext() == false) goto L8;
            r0.add(((InAppSearchEntity) ZeusTransformUtils.preCheckCast(r7.next(), InAppSearchEntity.class, "com.obric.aiagent.plugin")).getAppEntity());     // Catch: Throwable -> L11
            goto L6
        L8:
            r4.addAll((Collection) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r0, List.class, "com.obric.aiagent.plugin"), Collection.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L11
            monitor-exit(r4);
            return;
        L11:
            th = move-exception;
            throw th;
        }
    }

    /* JADX INFO: compiled from: InAppSearchIntentExecutor.kt */
    @f(b = "InAppSearchIntentExecutor.kt", c = {83}, d = "invokeSuspend", e = "com.obric.memorydata.sdk.intent.InAppSearchIntentExecutor$doAction$result$1")
    static final class e extends l implements m<am, d.c.d<? super IntentResult<AppEntity[]>>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f33841a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ w<IntentResult<AppEntity[]>> f33842b;

        e(w<IntentResult<AppEntity[]>> r3, d.c.d<? super e> r4) {
            w<IntentResult<AppEntity[]>> r5 = (w) ZeusTransformUtils.wrapperContextForParams(r3, w.class, "com.obric.aiagent.plugin");
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f33842b = r5;
            super(2, r6);
        }

        public final Object a(am r3, d.c.d<? super IntentResult<AppEntity[]>> r4) {
            return ((e) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), e.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r2, d.c.d<?> r3) {
            d.c.d r4 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new e(this.f33842b, r4), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super IntentResult<AppEntity[]>> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r5) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f33841a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            d.o.a(r5);
        L11:
            return r5;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            d.o.a(r5);
            w<IntentResult<AppEntity[]>> r6 = this.f33842b;
            d.c.d<? super IntentResult<AppEntity[]>> r2 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f33841a = 1;
            r5 = r6.a(r2);
            if (r5 != r0) goto L11;
            return r0;
        }
    }

    static {
        f33834a = new a();
    }

    private final AppIntentImplInfo a() {
        return null;
    }

    private a() {
    }

    public static /* synthetic */ Object a(a r7, String r8, String r9, long r10, String r12, d.c.d r13, int r14, Object r15) {
        d.c.d<? super b> r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r13, d.c.d.class, "com.obric.aiagent.plugin");
        if ((r14 & 4) == 0) goto L5;
        r10 = 5000;
    L5:
        long r3 = r10;
        if ((r14 & 8) == 0) goto L9;
        r12 = "MemorySdkInAppSearch";
    L9:
        return r7.a(r8, r9, r3, r12, r6);
    }

    public final Object a(String r20, String r21, long r22, String r24, d.c.d<? super b> r25) {
        d.c.d r0 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r25, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r0, c.class) == false) goto L7;
        c r2 = (c) ZeusTransformUtils.preCheckCast(r0, c.class, "com.obric.aiagent.plugin");
        if ((r2.f33838c & Integer.MIN_VALUE) == 0) goto L7;
        r2.f33838c -= Integer.MIN_VALUE;
    L8:
        Object r1 = r2.f33836a;
        Object r4 = d.c.a.b.a();
        int r5 = r2.f33838c;
        if (r5 == 0) goto L14;
        if (r5 != 1) goto L13;
        d.o.a(r1);
    L31:
        IntentResult r3 = (IntentResult) ZeusTransformUtils.preCheckCast(r1, IntentResult.class, "com.obric.aiagent.plugin");
        if (r3 == null) goto L46;
        if (r3.getRet() != 0) goto L40;
        AppEntity[] r6 = (AppEntity[]) ZeusTransformUtils.preCheckCast(r3.getEntity(), AppEntity[].class, "com.obric.aiagent.plugin");
        if (r6 != null) goto L39;
        r6 = new AppEntity[0];
    L39:
        return new b(r6);
    L40:
        String r7 = r3.getDetails();
        if (r7 != null) goto L44;
        r7 = "unknown error";
    L44:
        throw new C0917a(r7);
    L46:
        throw new C0917a("InAppSearch timeout");
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        d.o.a(r1);
        if (a() != null) goto L50;
        List r8 = (List) ZeusTransformUtils.preCheckCast(com.obric.memorydata.sdk.b.f33832a.a().fromJson(r21, new InAppSearchIntentExecutor$doAction$quResults$1().getType()), List.class, "com.obric.aiagent.plugin");     // Catch: JsonSyntaxException -> L19
    L20:
        Collection r9 = (Collection) ZeusTransformUtils.preCheckCast(r8, Collection.class, "com.obric.aiagent.plugin");
        if (r9 != null) goto L23;
    L26:
        boolean r10 = true;
    L27:
        if (r10 == true) goto L48;
        w r11 = y.a(null, 1, null);
        List r12 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.aiagent.plugin");
        InAppSearchClient.INSTANCE.prepareSearch();
        InAppSearchClient r13 = InAppSearchClient.INSTANCE;
        InAppSearchRequest r15 = new InAppSearchRequest(r20, 0, false, false, 0, 30, null);
        r15.setPresetQUResult(com.obric.memorydata.sdk.b.f33832a.a().toJson(p.k(r8)));
        x r14 = x.f38692a;
        r13.startAppSearch("MemorySdkInAppSearch", r15, (IAppSearchCallback) ZeusTransformUtils.preCheckCast(new d(r12, r11), IAppSearchCallback.class, "com.obric.aiagent.plugin"));
        m r16 = (m) ZeusTransformUtils.preCheckCast(new e(r11, null), m.class, "com.obric.aiagent.plugin");
        r2.f33838c = 1;
        r1 = dg.b(r22, r16, r2);
        if (r1 != r4) goto L31;
        return r4;
    L48:
        throw new C0917a("quResult is null");
    L23:
        if (r9.isEmpty() == true) goto L26;
        r10 = false;
    L19:
        r8 = null;
        goto L20
    L50:
        throw new UnsupportedOperationException("not support dispatch intent");
    L7:
        r2 = new c(this, r0);
        goto L8
    }
}
