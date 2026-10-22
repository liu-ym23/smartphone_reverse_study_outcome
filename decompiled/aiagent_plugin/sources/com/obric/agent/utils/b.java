package com.obric.agent.utils;

import android.net.Uri;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.TypeAdapterFactory;
import com.obric.agent.appintent.IntentAction;
import com.obric.agent.appintent.IntentData;
import com.obric.agent.appintent.IntentJob;
import com.obric.aiagent.assistant.idl.IFlowSettingsIDL;
import com.obric.aiagent.assistant.idl.at;
import com.obric.aiagent.platform.depend.ILogDepend;
import com.obric.capability.schedulekit.JobResultWrapper;
import com.obric.capabilitykit.common.execution.IntentExecutionRecord;
import com.obric.capabilitykit.common.execution.JobResult;
import com.obric.capabilitykit.common.intent.IntentParams;
import com.obric.capabilitykit.common.intent.IntentResult;
import com.obric.capabilitykit.entity.ExtraTypeAdapterFactory;
import com.obric.capabilitykit.entity.UriTypeAdapter;
import com.obric.capabilitykit.entity.memory.MemorySourceLinkType;
import com.obric.funcall_api.bean.IntentAppAction;
import com.ss.bduploader.BDImageUploader;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.ao;
import d.h.b.aa;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlinx.coroutines.am;
import kotlinx.coroutines.dg;
import org.json.JSONObject;

/* JADX INFO: compiled from: AppIntentHelper.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class b {
    private static final String TAG = "AppIntentHelper";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f15994a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final d.f f15995b = null;

    /* JADX INFO: compiled from: AppIntentHelper.kt */
    @d.c.b.a.f(b = "AppIntentHelper.kt", c = {109}, d = "dispatchAppIntent$agent_impl_release", e = "com.obric.agent.utils.AppIntentHelper")
    static final class a extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        /* synthetic */ Object f15996a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ b f15997b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int f15998c;

        a(b r3, d.c.d<? super a> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f15997b = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f15996a = r3;
            this.f15998c |= Integer.MIN_VALUE;
            return this.f15997b.a(null, null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: renamed from: com.obric.agent.utils.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: AppIntentHelper.kt */
    @d.c.b.a.f(b = "AppIntentHelper.kt", c = {}, d = "invokeSuspend", e = "com.obric.agent.utils.AppIntentHelper$execLocalAppIntent$1")
    static final class C0322b extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super d.x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f15999a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ long f16000b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f16001c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f16002d;

        C0322b(long r3, String r5, String r6, d.c.d<? super C0322b> r7) {
            d.c.d r8 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r7, d.c.d.class, "com.obric.aiagent.plugin");
            this.f16000b = r3;
            this.f16001c = r5;
            this.f16002d = r6;
            super(2, r8);
        }

        public final Object a(am r3, d.c.d<? super d.x> r4) {
            return ((C0322b) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), C0322b.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<d.x> create(Object r8, d.c.d<?> r9) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r9, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new C0322b(this.f16000b, this.f16001c, this.f16002d, r6), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super d.x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r18) {
            d.c.a.b.a();
            if (this.f15999a != 0) goto L7;
            d.o.a(r18);
            long r5 = this.f16000b;
            IntentAppAction r1 = new IntentAppAction(r5, r5, 0, this.f16001c, null, 0, 0, b.a(b.f15994a, null, 1, null), 116, null);
            ILogDepend.Companion.i(b.TAG, "execLocalAppIntent " + this.f16002d);
            com.obric.capability.schedulekit.a r0 = com.obric.capability.schedulekit.a.f31846a;
            String r2 = com.obric.capabilitykit.common.a.a().toJson(r1);
            d.h.b.o.c(r2, "toJson(...)");
            r0.a(r2, false);
            return d.x.f38692a;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: compiled from: AppIntentHelper.kt */
    @d.c.b.a.f(b = "AppIntentHelper.kt", c = {}, d = "invokeSuspend", e = "com.obric.agent.utils.AppIntentHelper$execLocalAppIntent$2")
    static final class c extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super d.x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f16003a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ long f16004b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ long f16005c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f16006d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ ConcurrentHashMap<String, String> f16007e;
        final /* synthetic */ String f;

        c(long r3, long r5, String r7, ConcurrentHashMap<String, String> r8, String r9, d.c.d<? super c> r10) {
            d.c.d r11 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r10, d.c.d.class, "com.obric.aiagent.plugin");
            this.f16004b = r3;
            this.f16005c = r5;
            this.f16006d = r7;
            this.f16007e = r8;
            this.f = r9;
            super(2, r11);
        }

        public final Object a(am r3, d.c.d<? super d.x> r4) {
            return ((c) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), c.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<d.x> create(Object r11, d.c.d<?> r12) {
            d.c.d r9 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r12, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new c(this.f16004b, this.f16005c, this.f16006d, this.f16007e, this.f, r9), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super d.x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r18) {
            d.c.a.b.a();
            if (this.f16003a != 0) goto L7;
            d.o.a(r18);
            IntentAppAction r1 = new IntentAppAction(this.f16004b, this.f16005c, 0, this.f16006d, null, 0, 0, this.f16007e, 116, null);
            ILogDepend.Companion.i(b.TAG, "execLocalAppIntent " + this.f);
            com.obric.capability.schedulekit.a r0 = com.obric.capability.schedulekit.a.f31846a;
            String r2 = com.obric.capabilitykit.common.a.a().toJson(r1);
            d.h.b.o.c(r2, "toJson(...)");
            r0.a(r2, false);
            return d.x.f38692a;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: compiled from: AppIntentHelper.kt */
    @d.c.b.a.f(b = "AppIntentHelper.kt", c = {228}, d = "suspendCancellableCoroutineWithTimeout", e = "com.obric.agent.utils.AppIntentHelper")
    static final class d<T> extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f16008a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        /* synthetic */ Object f16009b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ b f16010c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        int f16011d;

        d(b r3, d.c.d<? super d> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f16010c = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r7) {
            this.f16009b = r7;
            this.f16011d |= Integer.MIN_VALUE;
            return this.f16010c.a(0, null, null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: compiled from: AppIntentHelper.kt */
    @d.c.b.a.f(b = "AppIntentHelper.kt", c = {238}, d = "invokeSuspend", e = "com.obric.agent.utils.AppIntentHelper$suspendCancellableCoroutineWithTimeout$2")
    static final class e<T> extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super T>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f16012a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f16013b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ d.h.a.b<kotlinx.coroutines.n<? super T>, d.x> f16014c;

        e(d.h.a.b<? super kotlinx.coroutines.n<? super T>, d.x> r3, d.c.d<? super e> r4) {
            d.h.a.b<kotlinx.coroutines.n<? super T>, d.x> r5 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r3, d.h.a.b.class, "com.obric.aiagent.plugin");
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f16014c = r5;
            super(2, r6);
        }

        public final Object a(am r3, d.c.d<? super T> r4) {
            return ((e) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), e.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<d.x> create(Object r2, d.c.d<?> r3) {
            d.c.d r4 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new e(this.f16014c, r4), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, Object r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r6) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f16013b;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            d.h.a.b r5 = (d.h.a.b) ZeusTransformUtils.preCheckCast(this.f16012a, d.h.a.b.class, "com.obric.aiagent.plugin");
            d.o.a(r6);
        L13:
            return r6;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            d.o.a(r6);
            d.h.a.b<kotlinx.coroutines.n<? super T>, d.x> r7 = this.f16014c;
            this.f16012a = r7;
            this.f16013b = 1;
            kotlinx.coroutines.o r4 = new kotlinx.coroutines.o(d.c.a.b.a((d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin")), 1);
            r4.e();
            r7.invoke((kotlinx.coroutines.n) ZeusTransformUtils.preCheckCast(r4, kotlinx.coroutines.n.class, "com.obric.aiagent.plugin"));
            r6 = r4.h();
            if (r6 != d.c.a.b.a()) goto L11;
            d.c.b.a.h.c((d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        L11:
            if (r6 != r0) goto L13;
            return r0;
        }
    }

    /* JADX INFO: renamed from: lambda$sDC0P0UEo-SuKLeER03mxGnnQcA, reason: not valid java name */
    public static /* synthetic */ Gson m112lambda$sDC0P0UEoSuKLeER03mxGnnQcA() {
        return c();
    }

    private b() {
    }

    static {
        f15994a = new b();
        f15995b = d.g.a($$Lambda$b$sDC0P0UEoSuKLeER03mxGnnQcA.INSTANCE);
    }

    private final Gson a() {
        return (Gson) ZeusTransformUtils.preCheckCast(f15995b.b(), Gson.class, "com.obric.aiagent.plugin");
    }

    private static final Gson c() {
        return new GsonBuilder().registerTypeAdapter((Type) ZeusTransformUtils.preCheckCast(Uri.class, Type.class, "com.obric.aiagent.plugin"), new UriTypeAdapter()).registerTypeAdapterFactory((TypeAdapterFactory) ZeusTransformUtils.preCheckCast(new ExtraTypeAdapterFactory(), TypeAdapterFactory.class, "com.obric.aiagent.plugin")).create();
    }

    public final <T> JsonObject a(T r7) {
        JsonObject r6 = new JsonParser().parse(a().toJson(r7)).getAsJsonObject();
        JsonObject r8 = new JsonObject();
        Iterator<String> r0 = r6.keySet().iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        String r1 = (String) ZeusTransformUtils.preCheckCast(r0.next(), String.class, "com.obric.aiagent.plugin");
        JsonElement r2 = r6.get(r1);
        JsonObject r4 = new JsonObject();
        r4.add("value", r2);
        r8.add(r1, (JsonElement) ZeusTransformUtils.preCheckCast(r4, JsonElement.class, "com.obric.aiagent.plugin"));
        goto L4
    L6:
        return r8;
    }

    public final <T> T a(JsonObject r5, Class<T> r6) {
        d.h.b.o.e(r5, "jsonObject");
        d.h.b.o.e(r6, "classOfT");
        JsonObject r4 = r5.deepCopy();
        Iterator<String> r0 = r5.keySet().iterator();
    L4:
        if (r0.hasNext() == false) goto L11;
        String r1 = (String) ZeusTransformUtils.preCheckCast(r0.next(), String.class, "com.obric.aiagent.plugin");
        JsonElement r2 = r5.get(r1);
        if (r2.isJsonObject() == false) goto L4;
        JsonElement r3 = r2.getAsJsonObject().get("value");
        if (r3 == null) goto L4;
        r4.add(r1, r3);
        goto L4
    L11:
        return (T) com.obric.memorydata.sdk.b.f33832a.a().fromJson((JsonElement) ZeusTransformUtils.preCheckCast(r4, JsonElement.class, "com.obric.aiagent.plugin"), r6);
    }

    public final void a(String r9, JsonObject r10, String r11, long r12) {
        d.h.b.o.e(r9, MemorySourceLinkType.INTENT);
        String r4 = a(r9, r10, r11);
        kotlinx.coroutines.i.a(com.obric.agent.a.f14212a.a(), null, null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new C0322b(r12, r4, r9, null), d.h.a.m.class, "com.obric.aiagent.plugin"), 3, null);
    }

    public static /* synthetic */ Object a(b r1, String r2, IntentParams r3, d.c.d r4, int r5, Object r6) {
        IntentParams r7 = (IntentParams) ZeusTransformUtils.wrapperContextForParams(r3, IntentParams.class, "com.obric.aiagent.plugin");
        d.c.d<? super IntentResult<?>> r8 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
        if ((r5 & 2) == 0) goto L6;
        r7 = null;
    L6:
        return r1.a(r2, r7, r8);
    }

    public final Object a(String r17, IntentParams r18, d.c.d<? super IntentResult<?>> r19) {
        IntentParams r4 = (IntentParams) ZeusTransformUtils.wrapperContextForParams(r18, IntentParams.class, "com.obric.aiagent.plugin");
        d.c.d r0 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r19, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r0, a.class) == false) goto L7;
        a r2 = (a) ZeusTransformUtils.preCheckCast(r0, a.class, "com.obric.aiagent.plugin");
        if ((r2.f15998c & Integer.MIN_VALUE) == 0) goto L7;
        r2.f15998c -= Integer.MIN_VALUE;
    L8:
        a r12 = r2;
        Object r1 = r12.f15996a;
        Object r15 = d.c.a.b.a();
        int r3 = r12.f15998c;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        d.o.a(r1);
    L17:
        JobResultWrapper r5 = (JobResultWrapper) ZeusTransformUtils.preCheckCast(r1, JobResultWrapper.class, "com.obric.aiagent.plugin");
        if (r5 == null) goto L26;
        JobResult r6 = r5.getJobResult();
        if (r6 == null) goto L26;
        List<IntentExecutionRecord> r7 = r6.getExecRecords();
        if (r7 == null) goto L26;
        IntentExecutionRecord r8 = (IntentExecutionRecord) ZeusTransformUtils.preCheckCast(d.a.p.l(r7), IntentExecutionRecord.class, "com.obric.aiagent.plugin");
        if (r8 == null) goto L26;
        return r8.getResult();
    L26:
        return null;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        d.o.a(r1);
        com.obric.capability.schedulekit.a r9 = com.obric.capability.schedulekit.a.f31846a;
        r12.f15998c = 1;
        r1 = com.obric.capability.schedulekit.a.a(r9, r17, r4, 0, 0, null, false, null, r12, BDImageUploader.MessageIsPreHeatResultUsed, null);
        if (r1 != r15) goto L17;
        return r15;
    L7:
        r2 = new a(this, r0);
        goto L8
    }

    public final void a(String r13, JsonObject r14, String r15, long r16, long r18, Map<String, String> r20) {
        Map<String, String> r0 = (Map) ZeusTransformUtils.wrapperContextForParams(r20, Map.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r13, MemorySourceLinkType.INTENT);
        String r8 = a(r13, r14, r15);
        ConcurrentHashMap<String, String> r9 = b(r0);
        kotlinx.coroutines.i.a(com.obric.agent.a.f14212a.a(), null, null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new c(r16, r18, r8, r9, r13, null), d.h.a.m.class, "com.obric.aiagent.plugin"), 3, null);
    }

    public final String a(String r11, JsonObject r12, String r13) {
        d.h.b.o.e(r11, MemorySourceLinkType.INTENT);
        if (r13 != null) goto L5;
        List r6 = null;
    L6:
        IntentAction r0 = new IntentAction(r11, 0, r12, null, r6, 10, null);
        ILogDepend.Companion.i(TAG, "buildAppIntentContent " + r11);
        String r14 = com.obric.capabilitykit.common.a.a().toJson(new IntentData(d.a.p.a(new IntentJob(d.a.p.a(r0))), false, 2, null));
        d.h.b.o.c(r14, "toJson(...)");
        return a(r14);
    L5:
        r6 = d.a.p.a(new com.obric.agent.appintent.a(r13));
        goto L6
    }

    private final String a(String r3) {
        JSONObject r2 = new JSONObject();
        r2.put("Version", 3);
        String r4 = r2.put("Content", r3).toString();
        d.h.b.o.c(r4, "toString(...)");
        return r4;
    }

    static /* synthetic */ ConcurrentHashMap a(b r1, Map r2, int r3, Object r4) {
        Map<String, String> r5 = (Map) ZeusTransformUtils.wrapperContextForParams(r2, Map.class, "com.obric.aiagent.plugin");
        if ((r3 & 1) == 0) goto L6;
        r5 = null;
    L6:
        return r1.b(r5);
    }

    private final ConcurrentHashMap<String, String> b(Map<String, String> r2) {
        Map<? extends String, ? extends String> r1 = (Map) ZeusTransformUtils.wrapperContextForParams(r2, Map.class, "com.obric.aiagent.plugin");
        ConcurrentHashMap<String, String> r3 = new ConcurrentHashMap();
        if (r1 == null) goto L5;
        r3.putAll(r1);
    L5:
        r3.put("sender_id", "");
        r3.put("conversation_id", "");
        r3.put("to_server", "false");
        return r3;
    }

    public final void a(IntentAppAction r5) {
        d.h.b.o.e(r5, "result");
        if (r5.getExt() != null) goto L5;
        r5.setExt(new ConcurrentHashMap());
    L5:
        ConcurrentHashMap<String, String> r4 = r5.getExt();
        if (r4 == null) goto L10;
        String r6 = (String) ZeusTransformUtils.preCheckCast(r4.get("client_meta"), String.class, "com.obric.aiagent.plugin");
        if (r6 == null) goto L10;
        JSONObject r2 = new JSONObject(r6);
    L11:
        if (r2 != null) goto L13;
        r2 = new JSONObject();
    L13:
        r2.put("o_msg_middle_flag", "1");
        ConcurrentHashMap<String, String> r7 = r5.getExt();
        if (r7 == null) goto L17;
        String r8 = (String) ZeusTransformUtils.preCheckCast(r7.put("client_meta", r2.toString()), String.class, "com.obric.aiagent.plugin");
        return;
    L17:
        return;
    L10:
        r2 = null;
        goto L11
    }

    public final void a(Map<String, String> r3) {
        Map r4 = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r4, "ext");
        r4.putAll(b());
    }

    public final void b(IntentAppAction r2) {
        d.h.b.o.e(r2, "result");
        Map<String, String> r1 = b();
        if (r1.isEmpty() == false) goto L6;
        return;
    L6:
        if (r2.getExt() != null) goto L8;
        r2.setExt(new ConcurrentHashMap());
    L8:
        ConcurrentHashMap<String, String> r3 = r2.getExt();
        if (r3 == null) goto L12;
        r3.putAll(r1);
        return;
    }

    private final Map<String, String> b() {
        d.n.a r1 = d.n.f38560a;     // Catch: Throwable -> L33
        b r6 = (b) ZeusTransformUtils.preCheckCast(this, b.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L33
        IFlowSettingsIDL r7 = at.a(aa.b(IFlowSettingsIDL.class));     // Catch: Throwable -> L33
        Map r2 = null;
        if (r7 == null) goto L29;
        Map r8 = r7.getAutoExecuteAuthorizationStatusMap();     // Catch: Throwable -> L33
        if (r8 == null) goto L29;
        Collection r3 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L33
        Iterator r9 = r8.entrySet().iterator();     // Catch: Throwable -> L33
    L9:
        if (r9.hasNext() == false) goto L28;
        Map.Entry r4 = (Map.Entry) ZeusTransformUtils.preCheckCast(r9.next(), Map.Entry.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L33
        Object r5 = r4.getKey();     // Catch: Throwable -> L33
        Object r10 = r4.getValue();     // Catch: Throwable -> L33
        if (ZeusTransformUtils.instanceOf(r5, String.class) == false) goto L13;
        String r11 = (String) ZeusTransformUtils.preCheckCast(r5, String.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L33
    L14:
        if (r11 != null) goto L16;
    L15:
        d.m r12 = null;
    L26:
        if (r12 == null) goto L9;
        r3.add(r12);     // Catch: Throwable -> L33
        goto L9
    L16:
        if (r10 == null) goto L15;
        String r13 = r10.toString();     // Catch: Throwable -> L33
        if (r13 == null) goto L15;
        if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r11, CharSequence.class, "com.obric.aiagent.plugin"))) == true) goto L24;
        r11 = null;
    L24:
        if (r11 == null) goto L15;
        r12 = d.s.a(r11, r13);     // Catch: Throwable -> L33
        goto L26
    L13:
        r11 = null;
        goto L14
    L28:
        r2 = ao.a((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r3, List.class, "com.obric.aiagent.plugin"), Iterable.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L33
    L29:
        if (r2 != null) goto L31;
        r2 = ao.b();     // Catch: Throwable -> L33
    L31:
        Object r14 = d.n.f(r2);     // Catch: Throwable -> L33
    L35:
        Throwable r15 = d.n.c(r14);
        if (r15 == null) goto L38;
        ILogDepend.Companion.e(TAG, "getAutoExecuteAuthorizationStatusExt failed", r15);
    L38:
        Map r16 = ao.b();
        if (d.n.b(r14) == false) goto L42;
        r14 = r16;
    L42:
        return (Map) ZeusTransformUtils.preCheckCast(r14, Map.class, "com.obric.aiagent.plugin");
    L33:
        th = move-exception;
        d.n.a r17 = d.n.f38560a;
        r14 = d.n.f(d.o.a(th));
        goto L35
    }

    public final <T> Object a(long r5, T r7, d.h.a.b<? super kotlinx.coroutines.n<? super T>, d.x> r8, d.c.d<? super T> r9) {
        d.h.a.b r10 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r8, d.h.a.b.class, "com.obric.aiagent.plugin");
        d.c.d r11 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r9, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r11, d.class) == false) goto L7;
        d r0 = (d) ZeusTransformUtils.preCheckCast(r11, d.class, "com.obric.aiagent.plugin");
        if ((r0.f16011d & Integer.MIN_VALUE) == 0) goto L7;
        r0.f16011d -= Integer.MIN_VALUE;
    L8:
        Object r4 = r0.f16009b;
        Object r12 = d.c.a.b.a();
        int r2 = r0.f16011d;
        if (r2 == 0) goto L14;
        if (r2 != 1) goto L13;
        r7 = (T) r0.f16008a;
        d.o.a(r4);
    L17:
        if (r4 != null) goto L20;
        ILogDepend.Companion.i(TAG, "timeout");
        return r7;
    L20:
        return r4;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        d.o.a(r4);
        d.h.a.m r6 = (d.h.a.m) ZeusTransformUtils.preCheckCast(new e(r10, null), d.h.a.m.class, "com.obric.aiagent.plugin");
        r0.f16008a = r7;
        r0.f16011d = 1;
        r4 = dg.b(r5, r6, r0);
        if (r4 != r12) goto L17;
        return r12;
    L7:
        r0 = new d(this, r11);
        goto L8
    }
}
