package com.obric.aiagent.executionengine.scheduler.impl.appfunction.a;

import com.obric.aiagent.executionengine.capabilitymanager.api.appfunction.AppFunctionCallResult;
import com.obric.aiagent.executionengine.capabilitymanager.api.appfunction.IAppFunctionInvoker;
import com.obric.aiagent.executionengine.scheduler.api.IJobManagerApi;
import com.obric.aiagent.platform.depend.ILogDepend;
import com.obric.capabilitykit.common.Ext;
import com.obric.capabilitykit.common.intent.IntentResult;
import com.ss.android.socialbase.downloader.constants.DownloadErrorCode;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.ao;
import d.a.p;
import d.c.b.a.d;
import d.c.b.a.f;
import d.c.b.a.l;
import d.c.g;
import d.h.a.m;
import d.n;
import d.o;
import d.s;
import d.x;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlinx.coroutines.am;
import kotlinx.coroutines.an;
import kotlinx.coroutines.bd;
import kotlinx.coroutines.ca;
import kotlinx.coroutines.cx;
import kotlinx.coroutines.i;

/* JADX INFO: compiled from: PrivacyConsentWaiter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class a {
    private static final String TAG = "PrivacyConsentWaiter";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f18146a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final am f18147b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final ConcurrentHashMap<Long, ca> f18148c = null;

    /* JADX INFO: renamed from: com.obric.aiagent.executionengine.scheduler.impl.appfunction.a.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: PrivacyConsentWaiter.kt */
    @f(b = "PrivacyConsentWaiter.kt", c = {97}, d = "observe", e = "com.obric.aiagent.executionengine.scheduler.impl.appfunction.privacy.PrivacyConsentWaiter")
    static final class C0376a extends d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        /* synthetic */ Object f18149a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ a f18150b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int f18151c;

        C0376a(a r3, d.c.d<? super C0376a> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f18150b = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f18149a = r3;
            this.f18151c |= Integer.MIN_VALUE;
            return a.a(this.f18150b, null, null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: PrivacyConsentWaiter.kt */
    @f(b = "PrivacyConsentWaiter.kt", c = {63}, d = "invokeSuspend", e = "com.obric.aiagent.executionengine.scheduler.impl.appfunction.privacy.PrivacyConsentWaiter$watch$job$1")
    static final class b extends l implements m<am, d.c.d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f18152a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ long f18153b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f18154c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f18155d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ com.obric.aiagent.executionengine.scheduler.impl.appfunction.registry.m f18156e;
        private /* synthetic */ Object f;

        b(long r3, String r5, String r6, com.obric.aiagent.executionengine.scheduler.impl.appfunction.registry.m r7, d.c.d<? super b> r8) {
            d.c.d r9 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r8, d.c.d.class, "com.obric.aiagent.plugin");
            this.f18153b = r3;
            this.f18154c = r5;
            this.f18155d = r6;
            this.f18156e = r7;
            super(2, r9);
        }

        public final Object a(am r3, d.c.d<? super x> r4) {
            return ((b) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), b.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r10, d.c.d<?> r11) {
            d.c.d r8 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r11, d.c.d.class, "com.obric.aiagent.plugin");
            b r12 = new b(this.f18153b, this.f18154c, this.f18155d, this.f18156e, r8);
            r12.f = r10;
            return (d.c.d) ZeusTransformUtils.preCheckCast(r12, d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r7) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f18152a;
            if (r1 == 0) goto L9;
            if (r1 != 1) goto L8;
            o.a(r7);     // Catch: Throwable -> L15
        L13:
            Object r8 = n.f(d.c.b.a.b.a(((Boolean) ZeusTransformUtils.preCheckCast(r7, Boolean.class, "com.obric.aiagent.plugin")).booleanValue()));     // Catch: Throwable -> L15
        L17:
            String r2 = this.f18155d;
            Throwable r3 = n.c(r8);
            if (r3 == null) goto L21;
            ILogDepend.Companion.e(a.TAG, "observe failed pkg=" + r2, r3);
            r8 = d.c.b.a.b.a(false);
        L21:
            boolean r9 = ((Boolean) ZeusTransformUtils.preCheckCast(r8, Boolean.class, "com.obric.aiagent.plugin")).booleanValue();
            ILogDepend.Companion.i(a.TAG, "consent observe result=" + r9 + ", questionId=" + this.f18153b);
            if (r9 == false) goto L25;
            a.a(a.f18146a, this.f18153b, this.f18154c);
        L25:
            return x.f38692a;
        L8:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L9:
            o.a(r7);
            am r10 = (am) ZeusTransformUtils.preCheckCast(this.f, am.class, "com.obric.aiagent.plugin");
            String r11 = this.f18155d;
            com.obric.aiagent.executionengine.scheduler.impl.appfunction.registry.m r4 = this.f18156e;
            n.a r5 = n.f38560a;     // Catch: Throwable -> L15
            a r6 = a.f18146a;     // Catch: Throwable -> L15
            String r12 = r4.d();     // Catch: Throwable -> L15
            this.f18152a = 1;     // Catch: Throwable -> L15
            r7 = a.a(r6, r11, r12, this);     // Catch: Throwable -> L15
            if (r7 != r0) goto L13;
            return r0;
        L15:
            th = move-exception;
            n.a r13 = n.f38560a;
            r8 = n.f(o.a(th));
            goto L17
        }
    }

    public static /* synthetic */ x lambda$ePvvVC6UkM6hnm05tAMK9nAd_Bk(long r0, ca r2, Throwable r3) {
        return a(r0, r2, r3);
    }

    private a() {
    }

    public static final /* synthetic */ Object a(a r2, String r3, String r4, d.c.d r5) {
        return r2.a(r3, r4, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    public static final /* synthetic */ void a(a r0, long r1, String r3) {
        r0.a(r1, r3);
    }

    static {
        f18146a = new a();
        f18147b = an.a(cx.a(null, 1, null).plus((g) ZeusTransformUtils.preCheckCast(bd.c(), g.class, "com.obric.aiagent.plugin")));
        f18148c = new ConcurrentHashMap();
    }

    public final void a(final long r12, String r14, String r15) {
        d.h.b.o.e(r14, "packageName");
        d.h.b.o.e(r15, "intentName");
        com.obric.aiagent.executionengine.scheduler.impl.appfunction.registry.m r7 = com.obric.aiagent.executionengine.scheduler.impl.appfunction.registry.x.f18310a.a(r14, "Privacy", "Observe");
        if (r7 != null) goto L6;
        ILogDepend.Companion.w(TAG, "no Privacy_Observe for pkg=" + r14 + ", skip consent watch");
        return;
    L6:
        ConcurrentHashMap<Long, ca> r0 = f18148c;
        if (r0.containsKey(Long.valueOf(r12)) == false) goto L10;
        ILogDepend.Companion.i(TAG, "already watching questionId=" + r12 + ", ignore");
        return;
    L10:
        final ca r11 = i.a(f18147b, null, null, (m) ZeusTransformUtils.preCheckCast(new b(r12, r15, r14, r7, null), m.class, "com.obric.aiagent.plugin"), 3, null);
        ((Map) ZeusTransformUtils.preCheckCast(r0, Map.class, "com.obric.aiagent.plugin")).put(Long.valueOf(r12), r11);
        r11.a_(new $$Lambda$a$ePvvVC6UkM6hnm05tAMK9nAd_Bk(r12, r11));
    }

    private static final x a(long r1, ca r3, Throwable r4) {
        ca r5 = (ca) ZeusTransformUtils.wrapperContextForParams(r3, ca.class, "com.obric.aiagent.plugin");
        f18148c.remove(Long.valueOf(r1), r5);
        return x.f38692a;
    }

    public final void a(long r3) {
        ca r2 = (ca) ZeusTransformUtils.preCheckCast(f18148c.remove(Long.valueOf(r3)), ca.class, "com.obric.aiagent.plugin");
        if (r2 == null) goto L6;
        ca.a.a(r2, null, 1, null);
        ILogDepend.Companion.i(TAG, "cancel consent watch, questionId=" + r3);
        return;
    }

    public final void a() {
        ConcurrentHashMap<Long, ca> r6 = f18148c;
        if (r6.isEmpty() == false) goto L5;
        return;
    L5:
        Set<Long> r7 = r6.keySet();
        d.h.b.o.c(r7, "<get-keys>(...)");
        List r8 = p.o((Iterable) ZeusTransformUtils.preCheckCast(r7, Iterable.class, "com.obric.aiagent.plugin"));
        Iterator r0 = ((Iterable) ZeusTransformUtils.preCheckCast(r8, Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L7:
        if (r0.hasNext() == false) goto L9;
        Long r2 = (Long) ZeusTransformUtils.preCheckCast(r0.next(), Long.class, "com.obric.aiagent.plugin");
        a r3 = f18146a;
        d.h.b.o.a(r2);
        r3.a(r2.longValue());
        goto L7
    L9:
        ILogDepend.Companion.i(TAG, "cancelAll consent watch, count=" + r8.size());
    }

    private final Object a(String r6, String r7, d.c.d<? super Boolean> r8) {
        d.c.d r9 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r8, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r9, C0376a.class) == false) goto L7;
        C0376a r0 = (C0376a) ZeusTransformUtils.preCheckCast(r9, C0376a.class, "com.obric.aiagent.plugin");
        if ((r0.f18151c & Integer.MIN_VALUE) == 0) goto L7;
        r0.f18151c -= Integer.MIN_VALUE;
    L8:
        Object r5 = r0.f18149a;
        Object r10 = d.c.a.b.a();
        int r2 = r0.f18151c;
        boolean r3 = false;
        if (r2 == 0) goto L14;
        if (r2 != 1) goto L13;
        o.a(r5);
    L21:
        AppFunctionCallResult r11 = (AppFunctionCallResult) ZeusTransformUtils.preCheckCast(r5, AppFunctionCallResult.class, "com.obric.aiagent.plugin");
        if (r11.isStandardResult() == false) goto L30;
        Integer r12 = r11.getStandardCode();
        if (r12 == null) goto L30;
        if (r12.intValue() != 0) goto L30;
        r3 = true;
    L30:
        return d.c.b.a.b.a(r3);
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        o.a(r5);
        IAppFunctionInvoker r13 = (IAppFunctionInvoker) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IAppFunctionInvoker.class), IAppFunctionInvoker.class, "com.obric.aiagent.plugin");
        if (r13 == null) goto L17;
        r0.f18151c = 1;
        r5 = r13.execute(r6, r7, "{}", r0);
        if (r5 != r10) goto L21;
        return r10;
    L17:
        return d.c.b.a.b.a(false);
    L7:
        r0 = new C0376a(this, r9);
        goto L8
    }

    private final void a(long r15, String r17) {
        IntentResult<?> r13 = new IntentResult(0, null, null, null, false, false, 0, null, null, null, DownloadErrorCode.ERROR_NO_CONNECTION, null);
        ConcurrentHashMap<String, String> r0 = new ConcurrentHashMap();
        r0.put(Ext.KEY_PRIVACY_STATEMENT_AGREED, "1");
        r13.setExt(r0);
        Map<?, ?> r5 = ao.a(s.a(Ext.KEY_INTENT_NAME, r17));
        IJobManagerApi r1 = (IJobManagerApi) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IJobManagerApi.class), IJobManagerApi.class, "com.obric.aiagent.plugin");
        if (r1 == null) goto L5;
        r1.updateIntentResult(r15, r13, false, r5);
        return;
    L5:
        ILogDepend.Companion.e(TAG, "IJobManagerApi unavailable, cannot retrigger questionId=" + r15);
    }
}
