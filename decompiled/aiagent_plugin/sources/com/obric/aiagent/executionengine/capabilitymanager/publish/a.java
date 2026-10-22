package com.obric.aiagent.executionengine.capabilitymanager.publish;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import com.bytedance.common.wschannel.WsChannelMultiProcessSharedProvider;
import com.obric.aiagent.platform.depend.IAppContext;
import com.obric.aiagent.platform.depend.ILogDepend;
import com.obric.aiagent.plugin.R;
import com.obric.capabilitykit.common.intent.AppIntentImplInfo;
import com.obric.capabilitykit.common.intent.IntentFunction;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.ao;
import d.a.p;
import d.c.b.a.l;
import d.h.a.m;
import d.l.n;
import d.o;
import d.x;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import kotlinx.coroutines.am;
import kotlinx.coroutines.an;

/* JADX INFO: compiled from: IntentInfoManager.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class a {
    private static final String TAG = "IntentInfoManager";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f16520a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final com.obric.aiagent.executionengine.capabilitymanager.data.b.c f16521b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final am f16522c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final HashSet<InterfaceC0336a> f16523d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final AtomicBoolean f16524e = null;
    private static volatile List<com.obric.aiagent.executionengine.capabilitymanager.data.bean.a> f;
    private static final kotlinx.coroutines.f.a g = null;
    private static final AtomicLong h = null;

    /* JADX INFO: renamed from: com.obric.aiagent.executionengine.capabilitymanager.publish.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: IntentInfoManager.kt */
    public interface InterfaceC0336a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final C0337a f16525a = null;

        /* JADX INFO: renamed from: com.obric.aiagent.executionengine.capabilitymanager.publish.a$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: IntentInfoManager.kt */
        public static final class C0337a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            static final /* synthetic */ C0337a f16526a = null;

            static {
                f16526a = new C0337a();
            }

            private C0337a() {
            }
        }

        static {
            f16525a = C0337a.f16526a;
        }

        void a(String r1, List<String> r2, int r3);
    }

    /* JADX INFO: compiled from: IntentInfoManager.kt */
    @d.c.b.a.f(b = "IntentInfoManager.kt", c = {92}, d = "getDispatchIntentServiceName", e = "com.obric.aiagent.executionengine.capabilitymanager.publish.IntentInfoManager")
    static final class b extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f16527a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        /* synthetic */ Object f16528b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ a f16529c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        int f16530d;

        b(a r3, d.c.d<? super b> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f16529c = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f16528b = r3;
            this.f16530d |= Integer.MIN_VALUE;
            return this.f16529c.a(null, null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: IntentInfoManager.kt */
    @d.c.b.a.f(b = "IntentInfoManager.kt", c = {220}, d = "loadEnabledIntents", e = "com.obric.aiagent.executionengine.capabilitymanager.publish.IntentInfoManager")
    static final class c extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f16531a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        long f16532b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        /* synthetic */ Object f16533c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ a f16534d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        int f16535e;

        c(a r3, d.c.d<? super c> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f16534d = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f16533c = r3;
            this.f16535e |= Integer.MIN_VALUE;
            return a.a(this.f16534d, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: IntentInfoManager.kt */
    @d.c.b.a.f(b = "IntentInfoManager.kt", c = {}, d = "invokeSuspend", e = "com.obric.aiagent.executionengine.capabilitymanager.publish.IntentInfoManager$loadEnabledIntents$loaded$1")
    static final class d extends l implements m<am, d.c.d<? super List<? extends com.obric.aiagent.executionengine.capabilitymanager.data.bean.a>>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f16536a;

        d(d.c.d<? super d> r3) {
            super(2, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        public final Object a(am r3, d.c.d<? super List<com.obric.aiagent.executionengine.capabilitymanager.data.bean.a>> r4) {
            return ((d) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), d.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r1, d.c.d<?> r2) {
            return (d.c.d) ZeusTransformUtils.preCheckCast(new d((d.c.d) ZeusTransformUtils.wrapperContextForParams(r2, d.c.d.class, "com.obric.aiagent.plugin")), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super List<? extends com.obric.aiagent.executionengine.capabilitymanager.data.bean.a>> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r1) {
            d.c.a.b.a();
            if (this.f16536a != 0) goto L10;
            o.a(r1);
            List<String> r0 = a.b().a();
            if (r0.isEmpty() == false) goto L8;
            return p.b();
        L8:
            return a.b().a(r0);
        L10:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: compiled from: IntentInfoManager.kt */
    @d.c.b.a.f(b = "IntentInfoManager.kt", c = {252, 213}, d = "queryEnabledIntentsForMatch", e = "com.obric.aiagent.executionengine.capabilitymanager.publish.IntentInfoManager")
    static final class e extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f16537a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        /* synthetic */ Object f16538b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ a f16539c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        int f16540d;

        e(a r3, d.c.d<? super e> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f16539c = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f16538b = r3;
            this.f16540d |= Integer.MIN_VALUE;
            return this.f16539c.b((d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: IntentInfoManager.kt */
    @d.c.b.a.f(b = "IntentInfoManager.kt", c = {76}, d = "queryIntentInfo", e = "com.obric.aiagent.executionengine.capabilitymanager.publish.IntentInfoManager")
    static final class f extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f16541a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f16542b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        /* synthetic */ Object f16543c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ a f16544d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        int f16545e;

        f(a r3, d.c.d<? super f> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f16544d = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f16543c = r3;
            this.f16545e |= Integer.MIN_VALUE;
            return this.f16544d.a(null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: IntentInfoManager.kt */
    @d.c.b.a.f(b = "IntentInfoManager.kt", c = {100}, d = "invokeSuspend", e = "com.obric.aiagent.executionengine.capabilitymanager.publish.IntentInfoManager$registerIntent$1")
    static final class g extends l implements m<am, d.c.d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f16546a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ com.obric.aiagent.executionengine.capabilitymanager.data.bean.a f16547b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f16548c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f16549d;

        g(com.obric.aiagent.executionengine.capabilitymanager.data.bean.a r3, String r4, String r5, d.c.d<? super g> r6) {
            d.c.d r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin");
            this.f16547b = r3;
            this.f16548c = r4;
            this.f16549d = r5;
            super(2, r7);
        }

        public final Object a(am r3, d.c.d<? super x> r4) {
            return ((g) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), g.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r4, d.c.d<?> r5) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new g(this.f16547b, this.f16548c, this.f16549d, r6), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r9) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f16546a;
            boolean r2 = true;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            o.a(r9);
        L11:
            d.m r10 = (d.m) ZeusTransformUtils.preCheckCast(r9, d.m.class, "com.obric.aiagent.plugin");
            if (((Number) ZeusTransformUtils.preCheckCast(r10.a(), Number.class, "com.obric.aiagent.plugin")).intValue() != 0) goto L15;
            com.obric.aiagent.executionengine.capabilitymanager.publish.b.f16563a.a(0, ((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(IAppContext.Companion.getApplication(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin")).getString(ZeusTransformUtils.mapRes(R.string.intent_registration_success, WsChannelMultiProcessSharedProvider.STRING_TYPE, "intent_registration_success")));
            return x.f38692a;
        L15:
            com.obric.aiagent.executionengine.capabilitymanager.publish.b r3 = com.obric.aiagent.executionengine.capabilitymanager.publish.b.f16563a;
            int r5 = ((Number) ZeusTransformUtils.preCheckCast(r10.a(), Number.class, "com.obric.aiagent.plugin")).intValue();
            CharSequence r6 = (CharSequence) ZeusTransformUtils.preCheckCast(r10.b(), CharSequence.class, "com.obric.aiagent.plugin");
            if (r6 != null) goto L18;
        L21:
            if (r2 == false) goto L23;
            String r4 = ((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(IAppContext.Companion.getApplication(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin")).getString(ZeusTransformUtils.mapRes(R.string.intent_registration_failure, WsChannelMultiProcessSharedProvider.STRING_TYPE, "intent_registration_failure"));
        L24:
            r3.a(r5, r4);
            ILogDepend.Companion.e(a.TAG, "fail to register intent " + this.f16548c + " from " + this.f16549d + ", result = " + r10);
            return x.f38692a;
        L23:
            r4 = (String) ZeusTransformUtils.preCheckCast(r10.b(), String.class, "com.obric.aiagent.plugin");
            goto L24
        L18:
            if (r6.length() == 0) goto L21;
            r2 = false;
            goto L21
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            o.a(r9);
            com.obric.aiagent.executionengine.capabilitymanager.data.b.c r11 = a.b();
            com.obric.aiagent.executionengine.capabilitymanager.data.bean.a r7 = this.f16547b;
            d.c.d<? super d.m<Integer, String>> r8 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f16546a = 1;
            r9 = r11.a(r7, r8);
            if (r9 != r0) goto L11;
            return r0;
        }
    }

    /* JADX INFO: compiled from: IntentInfoManager.kt */
    @d.c.b.a.f(b = "IntentInfoManager.kt", c = {151, 157}, d = "scanIntentsForAllPackage", e = "com.obric.aiagent.executionengine.capabilitymanager.publish.IntentInfoManager")
    static final class h extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f16550a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        /* synthetic */ Object f16551b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ a f16552c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        int f16553d;

        h(a r3, d.c.d<? super h> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f16552c = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f16551b = r3;
            this.f16553d |= Integer.MIN_VALUE;
            return this.f16552c.a((d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: IntentInfoManager.kt */
    @d.c.b.a.f(b = "IntentInfoManager.kt", c = {181, 182, 183}, d = "syncToStorage", e = "com.obric.aiagent.executionengine.capabilitymanager.publish.IntentInfoManager")
    static final class i extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f16554a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f16555b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        /* synthetic */ Object f16556c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ a f16557d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        int f16558e;

        i(a r3, d.c.d<? super i> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f16557d = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f16556c = r3;
            this.f16558e |= Integer.MIN_VALUE;
            return a.a(this.f16557d, null, null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: IntentInfoManager.kt */
    @d.c.b.a.f(b = "IntentInfoManager.kt", c = {121}, d = "invokeSuspend", e = "com.obric.aiagent.executionengine.capabilitymanager.publish.IntentInfoManager$unregisterIntent$1")
    static final class j extends l implements m<am, d.c.d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f16559a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f16560b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f16561c;

        j(String r3, String r4, d.c.d<? super j> r5) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            this.f16560b = r3;
            this.f16561c = r4;
            super(2, r6);
        }

        public final Object a(am r3, d.c.d<? super x> r4) {
            return ((j) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), j.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r3, d.c.d<?> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new j(this.f16560b, this.f16561c, r5), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r7) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f16559a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            o.a(r7);
        L12:
            if (((Number) ZeusTransformUtils.preCheckCast(r7, Number.class, "com.obric.aiagent.plugin")).intValue() <= 0) goto L15;
            com.obric.aiagent.executionengine.capabilitymanager.publish.b.f16563a.a(0, ((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(IAppContext.Companion.getApplication(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin")).getString(ZeusTransformUtils.mapRes(R.string.intent_deregistration_success, WsChannelMultiProcessSharedProvider.STRING_TYPE, "intent_deregistration_success")));
            return x.f38692a;
        L15:
            com.obric.aiagent.executionengine.capabilitymanager.publish.b.f16563a.a(105, ((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(IAppContext.Companion.getApplication(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin")).getString(ZeusTransformUtils.mapRes(R.string.intent_deregistration_failure, WsChannelMultiProcessSharedProvider.STRING_TYPE, "intent_deregistration_failure")));
            ILogDepend.Companion.e(a.TAG, "fail to unregister, there's no such entry");
            return x.f38692a;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            o.a(r7);
            com.obric.aiagent.executionengine.capabilitymanager.data.b.c r8 = a.b();
            String r2 = this.f16560b;
            String r4 = this.f16561c;
            d.c.d<? super Integer> r5 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f16559a = 1;
            r7 = r8.a(r2, r4, r5);
            if (r7 != r0) goto L12;
            return r0;
        }
    }

    private a() {
    }

    public static final /* synthetic */ Object a(a r2, d.c.d r3) {
        return r2.c((d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    public static final /* synthetic */ Object a(a r2, String r3, List r4, d.c.d r5) {
        return r2.a(r3, (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    public static final /* synthetic */ com.obric.aiagent.executionengine.capabilitymanager.data.b.c b() {
        return f16521b;
    }

    static {
        f16520a = new a();
        f16521b = new com.obric.aiagent.executionengine.capabilitymanager.data.b.c();
        f16522c = an.a((d.c.g) ZeusTransformUtils.preCheckCast(com.obric.aiagent.executionengine.capabilitymanager.a.f16395a.b(), d.c.g.class, "com.obric.aiagent.plugin"));
        f16523d = new HashSet();
        f16524e = new AtomicBoolean(false);
        g = kotlinx.coroutines.f.c.a(false, 1, null);
        h = new AtomicLong(0);
    }

    public final void a() {
        ILogDepend.Companion.i(TAG, "IntentInfoManager init");
    }

    public final Object a(String r13, d.c.d<? super com.obric.aiagent.executionengine.capabilitymanager.api.publish.a> r14) {
        d.c.d r15 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r14, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r15, f.class) == false) goto L7;
        f r0 = (f) ZeusTransformUtils.preCheckCast(r15, f.class, "com.obric.aiagent.plugin");
        if ((r0.f16545e & Integer.MIN_VALUE) == 0) goto L7;
        r0.f16545e -= Integer.MIN_VALUE;
    L8:
        Object r12 = r0.f16543c;
        Object r16 = d.c.a.b.a();
        int r2 = r0.f16545e;
        if (r2 == 0) goto L14;
        if (r2 != 1) goto L13;
        Type r17 = (Type) ZeusTransformUtils.preCheckCast(r0.f16542b, Type.class, "com.obric.aiagent.plugin");
        String r18 = (String) ZeusTransformUtils.preCheckCast(r0.f16541a, String.class, "com.obric.aiagent.plugin");
        o.a(r12);
        Type r19 = r17;
        r13 = r18;
    L32:
        Iterable r110 = (Iterable) ZeusTransformUtils.preCheckCast(r12, Iterable.class, "com.obric.aiagent.plugin");
        Collection r1 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(p.a(r110, 10)), Collection.class, "com.obric.aiagent.plugin");
        Iterator r111 = r110.iterator();
    L34:
        if (r111.hasNext() == false) goto L36;
        com.obric.aiagent.executionengine.capabilitymanager.data.bean.a r3 = (com.obric.aiagent.executionengine.capabilitymanager.data.bean.a) ZeusTransformUtils.preCheckCast(r111.next(), com.obric.aiagent.executionengine.capabilitymanager.data.bean.a.class, "com.obric.aiagent.plugin");
        r1.add(new AppIntentImplInfo(r3.b(), r3.c()));
        goto L34
    L36:
        List r112 = (List) ZeusTransformUtils.preCheckCast(r1, List.class, "com.obric.aiagent.plugin");
        d.h.b.o.a(r19);
        return new com.obric.aiagent.executionengine.capabilitymanager.api.publish.a(r13, r112, r19);
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        o.a(r12);
        Set r113 = ServiceManager.get().getServices(IntentFunction.class);
        d.h.b.o.b(r113, "ServiceManager.get().getServices(T::class.java)");
        Iterator r114 = ((Iterable) ZeusTransformUtils.preCheckCast(r113, Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L16:
        if (r114.hasNext() == false) goto L20;
        Object r4 = r114.next();
        if (d.h.b.o.a(((IntentFunction) ZeusTransformUtils.preCheckCast(r4, IntentFunction.class, "com.obric.aiagent.plugin")).getName(), r13) == false) goto L16;
    L21:
        IntentFunction r115 = (IntentFunction) ZeusTransformUtils.preCheckCast(r4, IntentFunction.class, "com.obric.aiagent.plugin");
        if (r115 != null) goto L24;
        return null;
    L24:
        Type[] r116 = r115.getClass().getGenericInterfaces();
        d.h.b.o.c(r116, "getGenericInterfaces(...)");
        Object[] r117 = (Object[]) ZeusTransformUtils.preCheckCast(r116, Object[].class, "com.obric.aiagent.plugin");
        int r5 = r117.length;
        int r6 = 0;
    L25:
        if (r6 >= r5) goto L40;
        Object r7 = r117[r6];
        CharSequence r8 = (CharSequence) ZeusTransformUtils.preCheckCast(((Type) ZeusTransformUtils.preCheckCast(r7, Type.class, "com.obric.aiagent.plugin")).toString(), CharSequence.class, "com.obric.aiagent.plugin");
        String r9 = IntentFunction.class.getSimpleName();
        d.h.b.o.c(r9, "getSimpleName(...)");
        if (d.o.o.c(r8, (CharSequence) ZeusTransformUtils.preCheckCast(r9, CharSequence.class, "com.obric.aiagent.plugin"), false, 2, null) == true) goto L28;
        r6 = r6 + 1;
        goto L25
    L28:
        d.h.b.o.a(r7, "null cannot be cast to non-null type java.lang.reflect.ParameterizedType");
        Type r118 = ((ParameterizedType) ZeusTransformUtils.preCheckCast(r7, ParameterizedType.class, "com.obric.aiagent.plugin")).getActualTypeArguments()[0];
        com.obric.aiagent.executionengine.capabilitymanager.data.b.c r10 = f16521b;
        r0.f16541a = r13;
        r0.f16542b = r118;
        r0.f16545e = 1;
        Object r11 = r10.a(r13, r0);
        if (r11 != r16) goto L31;
        return r16;
    L31:
        r19 = r118;
        r12 = r11;
        goto L32
    L40:
        throw new NoSuchElementException("Array contains no element matching the predicate.");
    L20:
        r4 = null;
    L7:
        r0 = new f(this, r15);
        goto L8
    }

    public final Object a(String r6, String r7, d.c.d<? super String> r8) {
        d.c.d r9 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r8, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r9, b.class) == false) goto L7;
        b r0 = (b) ZeusTransformUtils.preCheckCast(r9, b.class, "com.obric.aiagent.plugin");
        if ((r0.f16530d & Integer.MIN_VALUE) == 0) goto L7;
        r0.f16530d -= Integer.MIN_VALUE;
    L8:
        Object r5 = r0.f16528b;
        Object r10 = d.c.a.b.a();
        int r2 = r0.f16530d;
        if (r2 == 0) goto L14;
        if (r2 != 1) goto L13;
        r7 = (String) ZeusTransformUtils.preCheckCast(r0.f16527a, String.class, "com.obric.aiagent.plugin");
        o.a(r5);
    L20:
        Iterator r11 = ((Iterable) ZeusTransformUtils.preCheckCast(r5, Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L22:
        if (r11.hasNext() == false) goto L26;
        Object r12 = r11.next();
        if (d.h.b.o.a(((com.obric.aiagent.executionengine.capabilitymanager.data.bean.a) ZeusTransformUtils.preCheckCast(r12, com.obric.aiagent.executionengine.capabilitymanager.data.bean.a.class, "com.obric.aiagent.plugin")).b(), r7) == false) goto L22;
    L27:
        com.obric.aiagent.executionengine.capabilitymanager.data.bean.a r13 = (com.obric.aiagent.executionengine.capabilitymanager.data.bean.a) ZeusTransformUtils.preCheckCast(r12, com.obric.aiagent.executionengine.capabilitymanager.data.bean.a.class, "com.obric.aiagent.plugin");
        if (r13 != null) goto L30;
        return null;
    L30:
        return r13.h();
    L26:
        r12 = null;
        goto L27
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        o.a(r5);
        if (r6 != null) goto L17;
        return null;
    L17:
        com.obric.aiagent.executionengine.capabilitymanager.data.b.c r14 = f16521b;
        r0.f16527a = r7;
        r0.f16530d = 1;
        r5 = r14.a(r6, r0);
        if (r5 != r10) goto L20;
        return r10;
    L7:
        r0 = new b(this, r9);
        goto L8
    }

    public final void a(String r21, String r22, String r23, String r24) {
        ILogDepend.Companion.i(TAG, r21 + " registerIntent " + r22 + ' ' + r23 + ' ' + r24);
        if (r22 == null) goto L8;
        if (r23 == null) goto L9;
        if (r21 == null) goto L10;
        kotlinx.coroutines.i.a(f16522c, null, null, (m) ZeusTransformUtils.preCheckCast(new g(new com.obric.aiagent.executionengine.capabilitymanager.data.bean.a(r22, r21, r23, false, null, false, 0, r24, 112, null), r22, r21, null), m.class, "com.obric.aiagent.plugin"), 3, null);
        return;
    L10:
        return;
    L9:
        return;
    }

    public final void a(String r9, String r10, String r11) {
        ILogDepend.Companion.i(TAG, r9 + " unregisterIntent " + r10 + ' ' + r11);
        if (r10 == null) goto L8;
        if (r11 == null) goto L9;
        if (r9 == null) goto L10;
        kotlinx.coroutines.i.a(f16522c, null, null, (m) ZeusTransformUtils.preCheckCast(new j(r9, r10, null), m.class, "com.obric.aiagent.plugin"), 3, null);
        return;
    L10:
        return;
    L9:
        return;
    }

    public final Object a(d.c.d<? super x> r23) {
        d.c.d r0 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r23, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r0, h.class) == false) goto L7;
        h r2 = (h) ZeusTransformUtils.preCheckCast(r0, h.class, "com.obric.aiagent.plugin");
        if ((r2.f16553d & Integer.MIN_VALUE) == 0) goto L7;
        r2.f16553d -= Integer.MIN_VALUE;
    L8:
        Object r1 = r2.f16551b;
        Object r3 = d.c.a.b.a();
        int r4 = r2.f16553d;
        if (r4 == 0) goto L16;
        if (r4 == 1) goto L15;
        if (r4 != 2) goto L14;
        Iterator r5 = (Iterator) ZeusTransformUtils.preCheckCast(r2.f16550a, Iterator.class, "com.obric.aiagent.plugin");
        o.a(r1);
    L56:
        if (r5.hasNext() == false) goto L60;
        Map.Entry r6 = (Map.Entry) ZeusTransformUtils.preCheckCast(r5.next(), Map.Entry.class, "com.obric.aiagent.plugin");
        String r7 = (String) ZeusTransformUtils.preCheckCast(r6.getKey(), String.class, "com.obric.aiagent.plugin");
        List<com.obric.aiagent.executionengine.capabilitymanager.data.bean.a> r8 = (List) ZeusTransformUtils.preCheckCast(r6.getValue(), List.class, "com.obric.aiagent.plugin");
        a r9 = f16520a;
        d.h.b.o.a(r7);
        r2.f16550a = r5;
        r2.f16553d = 2;
        if (r9.a(r7, r8, r2) != r3) goto L56;
        return r3;
    L60:
        f16524e.set(false);
        return x.f38692a;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        List r10 = (List) ZeusTransformUtils.preCheckCast(r2.f16550a, List.class, "com.obric.aiagent.plugin");
        o.a(r1);
    L44:
        Iterable r11 = (Iterable) ZeusTransformUtils.preCheckCast(r10, Iterable.class, "com.obric.aiagent.plugin");
        LinkedHashMap r12 = new LinkedHashMap(n.c(ao.a(p.a(r11, 10)), 16));
        Iterator r13 = r11.iterator();
    L46:
        if (r13.hasNext() == false) goto L48;
        Object r14 = r13.next();
        Map r15 = (Map) ZeusTransformUtils.preCheckCast(r12, Map.class, "com.obric.aiagent.plugin");
        String r16 = (String) ZeusTransformUtils.preCheckCast(r14, String.class, "com.obric.aiagent.plugin");
        com.obric.aiagent.executionengine.capabilitymanager.publish.a.a r17 = com.obric.aiagent.executionengine.capabilitymanager.publish.a.a.f16562a;
        Context r18 = (Context) ZeusTransformUtils.preCheckCast((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(IAppContext.Companion.getApplication(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        d.h.b.o.a(r16);
        r15.put(r14, r17.a(r18, r16));
        goto L46
    L48:
        Map r19 = (Map) ZeusTransformUtils.preCheckCast(r12, Map.class, "com.obric.aiagent.plugin");
        Map r20 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.aiagent.plugin");
        Iterator r21 = r19.entrySet().iterator();
    L50:
        if (r21.hasNext() == false) goto L54;
        Map.Entry r22 = (Map.Entry) ZeusTransformUtils.preCheckCast(r21.next(), Map.Entry.class, "com.obric.aiagent.plugin");
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r22.getValue(), Collection.class, "com.obric.aiagent.plugin")).isEmpty()) == false) goto L50;
        r20.put(r22.getKey(), r22.getValue());
        goto L50
    L54:
        r5 = r20.entrySet().iterator();
        goto L56
    L16:
        o.a(r1);
        AtomicBoolean r24 = f16524e;
        if (r24.get() == true) goto L19;
        r24.set(true);
        ILogDepend.Companion.i(TAG, "scanIntentsForAllPackage");
        List<ResolveInfo> r25 = ((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(IAppContext.Companion.getApplication(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin")).getPackageManager().queryIntentServices(new Intent("com.obric.capabilitykit.CapabilityHandleService"), 0);
        d.h.b.o.c(r25, "queryIntentServices(...)");
        Iterable r26 = (Iterable) ZeusTransformUtils.preCheckCast(r25, Iterable.class, "com.obric.aiagent.plugin");
        Collection r27 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(p.a(r26, 10)), Collection.class, "com.obric.aiagent.plugin");
        Iterator r28 = r26.iterator();
    L22:
        if (r28.hasNext() == false) goto L24;
        r27.add(((ResolveInfo) ZeusTransformUtils.preCheckCast(r28.next(), ResolveInfo.class, "com.obric.aiagent.plugin")).serviceInfo.packageName);
        goto L22
    L24:
        List r29 = (List) ZeusTransformUtils.preCheckCast(r27, List.class, "com.obric.aiagent.plugin");
        Iterable r30 = (Iterable) ZeusTransformUtils.preCheckCast(f16521b.a(), Iterable.class, "com.obric.aiagent.plugin");
        Collection r110 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");
        Iterator r31 = r30.iterator();
    L26:
        if (r31.hasNext() == false) goto L40;
        Object r111 = r31.next();
        String r112 = (String) ZeusTransformUtils.preCheckCast(r111, String.class, "com.obric.aiagent.plugin");
        Iterable r113 = (Iterable) ZeusTransformUtils.preCheckCast(r29, Iterable.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r113, Collection.class) == true) goto L30;
    L32:
        Iterator r114 = r113.iterator();
    L34:
        if (r114.hasNext() == false) goto L31;
        if ((!d.h.b.o.a((String) ZeusTransformUtils.preCheckCast(r114.next(), String.class, "com.obric.aiagent.plugin"), r112)) == true) goto L34;
        boolean r115 = false;
    L38:
        if (r115 == false) goto L26;
        r110.add(r111);
    L31:
        r115 = true;
        goto L38
    L30:
        if (((Collection) ZeusTransformUtils.preCheckCast(r113, Collection.class, "com.obric.aiagent.plugin")).isEmpty() == false) goto L32;
    L40:
        List<String> r32 = (List) ZeusTransformUtils.preCheckCast(r110, List.class, "com.obric.aiagent.plugin");
        ILogDepend.Companion.i(TAG, "uninstalledPackages: " + p.a((Iterable) ZeusTransformUtils.preCheckCast(r32, Iterable.class, "com.obric.aiagent.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast(",", CharSequence.class, "com.obric.aiagent.plugin"), null, null, 0, null, null, 62, null));
        com.obric.aiagent.executionengine.capabilitymanager.data.b.c r33 = f16521b;
        r2.f16550a = r29;
        r2.f16553d = 1;
        if (r33.b(r32, r2) != r3) goto L43;
        return r3;
    L43:
        r10 = r29;
        goto L44
    L19:
        return x.f38692a;
    L7:
        r2 = new h(this, r0);
        goto L8
    }

    private final Object a(String r17, List<com.obric.aiagent.executionengine.capabilitymanager.data.bean.a> r18, d.c.d<? super x> r19) {
        List r0 = (List) ZeusTransformUtils.wrapperContextForParams(r18, List.class, "com.obric.aiagent.plugin");
        d.c.d r2 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r19, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r2, i.class) == false) goto L7;
        i r3 = (i) ZeusTransformUtils.preCheckCast(r2, i.class, "com.obric.aiagent.plugin");
        if ((r3.f16558e & Integer.MIN_VALUE) == 0) goto L7;
        r3.f16558e -= Integer.MIN_VALUE;
    L8:
        Object r4 = r3.f16556c;
        Object r5 = d.c.a.b.a();
        int r6 = r3.f16558e;
        if (r6 == 0) goto L18;
        if (r6 == 1) goto L17;
        if (r6 == 2) goto L16;
        if (r6 != 3) goto L15;
        o.a(r4);
    L52:
        return x.f38692a;
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        ArrayList r1 = (ArrayList) ZeusTransformUtils.preCheckCast(r3.f16554a, ArrayList.class, "com.obric.aiagent.plugin");
        o.a(r4);
    L48:
        com.obric.aiagent.executionengine.capabilitymanager.data.b.c r7 = f16521b;
        List<com.obric.aiagent.executionengine.capabilitymanager.data.bean.a> r8 = (List) ZeusTransformUtils.preCheckCast(r1, List.class, "com.obric.aiagent.plugin");
        r3.f16554a = null;
        r3.f16558e = 3;
        if (r7.d(r8, r3) != r5) goto L52;
        return r5;
    L17:
        ArrayList r9 = (ArrayList) ZeusTransformUtils.preCheckCast(r3.f16555b, ArrayList.class, "com.obric.aiagent.plugin");
        ArrayList r10 = (ArrayList) ZeusTransformUtils.preCheckCast(r3.f16554a, ArrayList.class, "com.obric.aiagent.plugin");
        o.a(r4);
    L44:
        com.obric.aiagent.executionengine.capabilitymanager.data.b.c r11 = f16521b;
        List<com.obric.aiagent.executionengine.capabilitymanager.data.bean.a> r12 = (List) ZeusTransformUtils.preCheckCast(r9, List.class, "com.obric.aiagent.plugin");
        r3.f16554a = r10;
        r3.f16555b = null;
        r3.f16558e = 2;
        if (r11.c(r12, r3) != r5) goto L47;
        return r5;
    L47:
        r1 = r10;
        goto L48
    L18:
        o.a(r4);
        List<com.obric.aiagent.executionengine.capabilitymanager.data.bean.a> r13 = f16521b.a(p.a(r17));
        ArrayList r14 = new ArrayList((Collection) ZeusTransformUtils.preCheckCast(r0, Collection.class, "com.obric.aiagent.plugin"));
        ArrayList r15 = new ArrayList();
        ArrayList r16 = new ArrayList();
        Iterator r20 = ((Iterable) ZeusTransformUtils.preCheckCast(r13, Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L20:
        if (r20.hasNext() == false) goto L40;
        com.obric.aiagent.executionengine.capabilitymanager.data.bean.a r110 = (com.obric.aiagent.executionengine.capabilitymanager.data.bean.a) ZeusTransformUtils.preCheckCast(r20.next(), com.obric.aiagent.executionengine.capabilitymanager.data.bean.a.class, "com.obric.aiagent.plugin");
        Iterator r111 = ((Iterable) ZeusTransformUtils.preCheckCast(r0, Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L23:
        if (r111.hasNext() == false) goto L28;
        Object r112 = r111.next();
        if (d.h.b.o.a(((com.obric.aiagent.executionengine.capabilitymanager.data.bean.a) ZeusTransformUtils.preCheckCast(r112, com.obric.aiagent.executionengine.capabilitymanager.data.bean.a.class, "com.obric.aiagent.plugin")).e(), r110.e()) == false) goto L23;
    L29:
        com.obric.aiagent.executionengine.capabilitymanager.data.bean.a r21 = (com.obric.aiagent.executionengine.capabilitymanager.data.bean.a) ZeusTransformUtils.preCheckCast(r112, com.obric.aiagent.executionengine.capabilitymanager.data.bean.a.class, "com.obric.aiagent.plugin");
        if (d.h.b.o.a(r21, r110) == false) goto L34;
        r14.remove(r110);
        if (d.n.b(f16521b.a(r110)) == false) goto L20;
        r16.add(r110);
        goto L20
    L34:
        if (r21 == null) goto L37;
        r14.remove(r21);
        r15.add(r21);
        goto L20
    L37:
        if (r110.d() == false) goto L20;
        r16.add(r110);
        goto L20
    L28:
        r112 = null;
        goto L29
    L40:
        com.obric.aiagent.executionengine.capabilitymanager.data.b.c r22 = f16521b;
        List<com.obric.aiagent.executionengine.capabilitymanager.data.bean.a> r23 = (List) ZeusTransformUtils.preCheckCast(r14, List.class, "com.obric.aiagent.plugin");
        r3.f16554a = r15;
        r3.f16555b = r16;
        r3.f16558e = 1;
        if (r22.a(r23, r3) != r5) goto L43;
        return r5;
    L43:
        r10 = r15;
        r9 = r16;
    L7:
        r3 = new i(this, r2);
        goto L8
    }

    public final void a(String r4, List<String> r5, int r6) {
        List<String> r7 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r4, "packageName");
        d.h.b.o.e(r7, "intents");
        c();
        Iterator r3 = ((Iterable) ZeusTransformUtils.preCheckCast(f16523d, Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L4:
        if (r3.hasNext() == false) goto L6;
        ((InterfaceC0336a) ZeusTransformUtils.preCheckCast(r3.next(), InterfaceC0336a.class, "com.obric.aiagent.plugin")).a(r4, r7, r6);
        goto L4
    }

    public final Object b(d.c.d<? super List<com.obric.aiagent.executionengine.capabilitymanager.data.bean.a>> r8) {
        d.c.d r9 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r8, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r9, e.class) == false) goto L7;
        e r0 = (e) ZeusTransformUtils.preCheckCast(r9, e.class, "com.obric.aiagent.plugin");
        if ((r0.f16540d & Integer.MIN_VALUE) == 0) goto L7;
        r0.f16540d -= Integer.MIN_VALUE;
    L8:
        Object r7 = r0.f16538b;
        Object r10 = d.c.a.b.a();
        int r2 = r0.f16540d;
        if (r2 == 0) goto L20;
        if (r2 == 1) goto L19;
        if (r2 != 2) goto L18;
        kotlinx.coroutines.f.a r11 = (kotlinx.coroutines.f.a) ZeusTransformUtils.preCheckCast(r0.f16537a, kotlinx.coroutines.f.a.class, "com.obric.aiagent.plugin");
        o.a(r7);     // Catch: Throwable -> L15
    L32:
        List<com.obric.aiagent.executionengine.capabilitymanager.data.bean.a> r3 = (List) ZeusTransformUtils.preCheckCast(r7, List.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L15
        kotlinx.coroutines.f.a r12 = r11;
    L34:
        r12.b(null);
        return r3;
    L15:
        Throwable th = th;
    L38:
        r11.b(null);
        throw th;
    L18:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L19:
        kotlinx.coroutines.f.a r4 = (kotlinx.coroutines.f.a) ZeusTransformUtils.preCheckCast(r0.f16537a, kotlinx.coroutines.f.a.class, "com.obric.aiagent.plugin");
        o.a(r7);
        r12 = r4;
    L40:
        r3 = f;     // Catch: Throwable -> L36
        if (r3 != null) goto L34;
        a r5 = f16520a;     // Catch: Throwable -> L36
        r0.f16537a = r12;     // Catch: Throwable -> L36
        r0.f16540d = 2;     // Catch: Throwable -> L36
        Object r1 = r5.c(r0);     // Catch: Throwable -> L36
        if (r1 != r10) goto L31;
        return r10;
    L31:
        r11 = r12;
        r7 = r1;
    L36:
        th = move-exception;
        r11 = r12;
        th = th;
        goto L38
    L20:
        o.a(r7);
        List<com.obric.aiagent.executionengine.capabilitymanager.data.bean.a> r13 = f;
        if (r13 == null) goto L23;
        return r13;
    L23:
        r12 = g;
        r0.f16537a = r12;
        r0.f16540d = 1;
        if (r12.a(null, r0) != r10) goto L40;
        return r10;
    L7:
        r0 = new e(this, r9);
        goto L8
    }

    private final Object c(d.c.d<? super List<com.obric.aiagent.executionengine.capabilitymanager.data.bean.a>> r9) {
        d.c.d r10 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r9, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r10, c.class) == false) goto L7;
        c r0 = (c) ZeusTransformUtils.preCheckCast(r10, c.class, "com.obric.aiagent.plugin");
        if ((r0.f16535e & Integer.MIN_VALUE) == 0) goto L7;
        r0.f16535e -= Integer.MIN_VALUE;
    L8:
        Object r11 = r0.f16533c;
        Object r2 = d.c.a.b.a();
        int r3 = r0.f16535e;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        long r4 = r0.f16532b;
        a r8 = (a) ZeusTransformUtils.preCheckCast(r0.f16531a, a.class, "com.obric.aiagent.plugin");
        o.a(r11);
    L18:
        List<com.obric.aiagent.executionengine.capabilitymanager.data.bean.a> r12 = (List) ZeusTransformUtils.preCheckCast(r11, List.class, "com.obric.aiagent.plugin");
        if (h.get() != r4) goto L21;
        f = r12;
    L21:
        return r12;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        o.a(r11);
        long r5 = h.get();
        d.c.g r13 = (d.c.g) ZeusTransformUtils.preCheckCast(com.obric.aiagent.executionengine.capabilitymanager.a.f16395a.a(), d.c.g.class, "com.obric.aiagent.plugin");
        m r6 = (m) ZeusTransformUtils.preCheckCast(new d(null), m.class, "com.obric.aiagent.plugin");
        r0.f16531a = this;
        r0.f16532b = r5;
        r0.f16535e = 1;
        r11 = kotlinx.coroutines.i.a(r13, r6, r0);
        if (r11 != r2) goto L17;
        return r2;
    L17:
        r4 = r5;
    L7:
        r0 = new c(this, r10);
        goto L8
    }

    private final void c() {
        f = null;
        h.incrementAndGet();
    }

    public final boolean a(String r5) {
        d.h.b.o.e(r5, "name");
        Set r4 = ServiceManager.get().getServices(IntentFunction.class);
        d.h.b.o.b(r4, "ServiceManager.get().getServices(T::class.java)");
        Iterable r6 = (Iterable) ZeusTransformUtils.preCheckCast(r4, Iterable.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r6, Collection.class) == true) goto L5;
    L7:
        Iterator r7 = r6.iterator();
    L9:
        if (r7.hasNext() == false) goto L18;
        if (d.h.b.o.a(((IntentFunction) ZeusTransformUtils.preCheckCast(r7.next(), IntentFunction.class, "com.obric.aiagent.plugin")).getName(), r5) == false) goto L9;
        return true;
    L18:
        return false;
    L5:
        if (((Collection) ZeusTransformUtils.preCheckCast(r6, Collection.class, "com.obric.aiagent.plugin")).isEmpty() == false) goto L7;
        return false;
    }
}
