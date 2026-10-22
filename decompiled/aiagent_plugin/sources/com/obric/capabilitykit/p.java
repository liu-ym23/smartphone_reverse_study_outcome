package com.obric.capabilitykit;

import android.app.Application;
import android.app.KeyguardManager;
import android.content.Context;
import android.os.Parcelable;
import com.bytedance.common.wschannel.WsChannelMultiProcessSharedProvider;
import com.bytedance.common.wschannel.WsConstants;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.obric.aiagent.plugin.R;
import com.obric.cae.libs.useraware.ApWakeEvent;
import com.obric.capabilitykit.apphost.AppHost;
import com.obric.capabilitykit.common.DispatchContext;
import com.obric.capabilitykit.common.execution.IntentCalling;
import com.obric.capabilitykit.common.intent.IntentFunction;
import com.obric.capabilitykit.common.intent.IntentResult;
import com.obric.capabilitykit.entity.app.AppEntity;
import com.obric.capabilitykit.entity.app.EntityClassData;
import com.obric.capabilitykit.entity.app.EntityType;
import com.obric.capabilitykit.logger.Logger;
import com.ss.android.socialbase.downloader.constants.DownloadErrorCode;
import com.ss.bduploader.BDImageUploader;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.ao;
import d.h.b.ae;
import d.x;
import java.lang.reflect.Constructor;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import kotlinx.coroutines.am;
import kotlinx.coroutines.dg;

/* JADX INFO: loaded from: classes3.dex */
public final class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final p f32174a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final d.f f32175b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final d f32176c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final Gson f32177d = null;

    public static final class a implements JsonDeserializer<AppEntity> {
        public a() {
        }

        public AppEntity a(JsonElement r2, Type r3, JsonDeserializationContext r4) {
            Type r1 = (Type) ZeusTransformUtils.wrapperContextForParams(r3, Type.class, "com.obric.aiagent.plugin");
            JsonDeserializationContext r5 = (JsonDeserializationContext) ZeusTransformUtils.wrapperContextForParams(r4, JsonDeserializationContext.class, "com.obric.aiagent.plugin");
            Integer r6 = null;
            if (r2 == null) goto L5;
            JsonObject r7 = r2.getAsJsonObject();
        L6:
            if (r7 == null) goto L10;
            JsonElement r8 = r7.get("type");
            if (r8 == null) goto L10;
            r6 = Integer.valueOf(r8.getAsInt());
        L10:
            EntityClassData r9 = (EntityClassData) ZeusTransformUtils.preCheckCast(EntityType.INSTANCE.getClassMap().get(r6), EntityClassData.class, "com.obric.aiagent.plugin");
            if (r9 == null) goto L17;
            Class r10 = r9.getClazz();
            if (r10 == null) goto L17;
            Object r11 = com.obric.capabilitykit.common.a.a().fromJson(r2, r10);
            d.h.b.o.c(r11, "gson.fromJson(json, targetClass)");
            return (AppEntity) ZeusTransformUtils.preCheckCast(r11, AppEntity.class, "com.obric.aiagent.plugin");
        L17:
            throw new IllegalArgumentException("Unknown entity type: " + r6);
        L5:
            r7 = null;
            goto L6
        }

        @Override // com.google.gson.JsonDeserializer
        public /* synthetic */ AppEntity deserialize(JsonElement r3, Type r4, JsonDeserializationContext r5) {
            return a(r3, (Type) ZeusTransformUtils.wrapperContextForParams(r4, Type.class, "com.obric.aiagent.plugin"), (JsonDeserializationContext) ZeusTransformUtils.wrapperContextForParams(r5, JsonDeserializationContext.class, "com.obric.aiagent.plugin"));
        }
    }

    @d.c.b.a.f(b = "IntentExecutor.kt", c = {BDImageUploader.MessageIsPreHeatResultUsed, 129}, d = "handleIntentCalling", e = "com.obric.capabilitykit.execution.IntentExecutor")
    public static final class b extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Object f32178a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Object f32179b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Object f32180c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public /* synthetic */ Object f32181d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ p f32182e;
        public int f;

        public b(p r3, d.c.d<? super b> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f32182e = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r2) {
            this.f32181d = r2;
            this.f |= Integer.MIN_VALUE;
            return this.f32182e.a(null, null, null, this);
        }
    }

    @d.c.b.a.f(b = "IntentExecutor.kt", c = {ApWakeEvent.ACCELERATING_START}, d = "invokeSuspend", e = "com.obric.capabilitykit.execution.IntentExecutor$handleIntentCalling$result$1")
    public static final class c extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super IntentResult<? extends Object>>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f32183a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ IntentFunction<Parcelable, ?> f32184b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Parcelable f32185c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ DispatchContext f32186d;

        public c(IntentFunction<Parcelable, ?> r3, Parcelable r4, DispatchContext r5, d.c.d<? super c> r6) {
            IntentFunction<Parcelable, ?> r7 = (IntentFunction) ZeusTransformUtils.wrapperContextForParams(r3, IntentFunction.class, "com.obric.aiagent.plugin");
            Parcelable r8 = (Parcelable) ZeusTransformUtils.wrapperContextForParams(r4, Parcelable.class, "com.obric.aiagent.plugin");
            d.c.d r9 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin");
            this.f32184b = r7;
            this.f32185c = r8;
            this.f32186d = r5;
            super(2, r9);
        }

        public final Object a(am r3, d.c.d<? super IntentResult<? extends Object>> r4) {
            return ((c) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), c.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r3, d.c.d<?> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            return new c(this.f32184b, this.f32185c, this.f32186d, r5);
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super IntentResult<? extends Object>> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r5) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f32183a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            d.o.a(r5);
        L11:
            return r5;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            d.o.a(r5);
            IntentFunction<Parcelable, ?> r6 = this.f32184b;
            Parcelable r2 = this.f32185c;
            DispatchContext r3 = this.f32186d;
            this.f32183a = 1;
            r5 = r6.doAction(r2, r3, this);
            if (r5 != r0) goto L11;
            return r0;
        }
    }

    public static final class d extends LinkedHashMap<String, Set<d.m<? extends String, ? extends IntentFunction<?, ?>>>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f32187a;

        public d() {
            this.f32187a = 10;
        }

        public Set<Map.Entry<String, Set<d.m<String, IntentFunction<?, ?>>>>> a() {
            return super.entrySet();
        }

        public Set<d.m<String, IntentFunction<?, ?>>> a(String r2) {
            return (Set) ZeusTransformUtils.preCheckCast(super.remove(r2), Set.class, "com.obric.aiagent.plugin");
        }

        public boolean a(String r3, Set<d.m<String, IntentFunction<?, ?>>> r4) {
            return super.remove(r3, (Set) ZeusTransformUtils.wrapperContextForParams(r4, Set.class, "com.obric.aiagent.plugin"));
        }

        public boolean a(Set<d.m<String, IntentFunction<?, ?>>> r3) {
            return super.containsValue((Set) ZeusTransformUtils.wrapperContextForParams(r3, Set.class, "com.obric.aiagent.plugin"));
        }

        public Set<String> b() {
            return super.keySet();
        }

        public Set<d.m<String, IntentFunction<?, ?>>> b(String r3, Set<d.m<String, IntentFunction<?, ?>>> r4) {
            return (Set) ZeusTransformUtils.preCheckCast(super.getOrDefault(r3, (Set) ZeusTransformUtils.wrapperContextForParams(r4, Set.class, "com.obric.aiagent.plugin")), Set.class, "com.obric.aiagent.plugin");
        }

        public boolean b(String r1) {
            return super.containsKey(r1);
        }

        public Collection<Set<d.m<String, IntentFunction<?, ?>>>> c() {
            return super.values();
        }

        public Set<d.m<String, IntentFunction<?, ?>>> c(String r2) {
            return (Set) ZeusTransformUtils.preCheckCast(super.get(r2), Set.class, "com.obric.aiagent.plugin");
        }

        @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
        public final boolean containsKey(Object r3) {
            if (ZeusTransformUtils.instanceOf(r3, String.class) == true) goto L7;
            return false;
        L7:
            return b((String) ZeusTransformUtils.preCheckCast(r3, String.class, "com.obric.aiagent.plugin"));
        }

        @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
        public final boolean containsValue(Object r3) {
            if (ae.h(r3) == true) goto L7;
            return false;
        L7:
            return a((Set) ZeusTransformUtils.preCheckCast(r3, Set.class, "com.obric.aiagent.plugin"));
        }

        public int d() {
            return super.size();
        }

        @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
        public final Set<Map.Entry<String, Set<d.m<String, IntentFunction<?, ?>>>>> entrySet() {
            return a();
        }

        @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
        public final /* synthetic */ Object get(Object r3) {
            if (ZeusTransformUtils.instanceOf(r3, String.class) == true) goto L7;
            return null;
        L7:
            return c((String) ZeusTransformUtils.preCheckCast(r3, String.class, "com.obric.aiagent.plugin"));
        }

        @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.Map
        public final /* synthetic */ Object getOrDefault(Object r3, Object r4) {
            if (ZeusTransformUtils.instanceOf(r3, String.class) == true) goto L6;
            return r4;
        L6:
            return b((String) ZeusTransformUtils.preCheckCast(r3, String.class, "com.obric.aiagent.plugin"), (Set) ZeusTransformUtils.preCheckCast(r4, Set.class, "com.obric.aiagent.plugin"));
        }

        @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
        public final Set<String> keySet() {
            return b();
        }

        @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
        public final /* synthetic */ Object remove(Object r3) {
            if (ZeusTransformUtils.instanceOf(r3, String.class) == true) goto L7;
            return null;
        L7:
            return a((String) ZeusTransformUtils.preCheckCast(r3, String.class, "com.obric.aiagent.plugin"));
        }

        @Override // java.util.HashMap, java.util.Map
        public final boolean remove(Object r3, Object r4) {
            if (ZeusTransformUtils.instanceOf(r3, String.class) == true) goto L6;
            return false;
        L6:
            if (ae.h(r4) == true) goto L9;
            return false;
        L9:
            return a((String) ZeusTransformUtils.preCheckCast(r3, String.class, "com.obric.aiagent.plugin"), (Set) ZeusTransformUtils.preCheckCast(r4, Set.class, "com.obric.aiagent.plugin"));
        }

        @Override // java.util.LinkedHashMap
        public boolean removeEldestEntry(Map.Entry<String, Set<d.m<? extends String, ? extends IntentFunction<?, ?>>>> r3) {
            Map.Entry r4 = (Map.Entry) ZeusTransformUtils.wrapperContextForParams(r3, Map.Entry.class, "com.obric.aiagent.plugin");
            if (size() <= this.f32187a) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
        public final int size() {
            return d();
        }

        @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
        public final Collection<Set<d.m<String, IntentFunction<?, ?>>>> values() {
            return c();
        }
    }

    public static final class e extends d.h.b.p implements d.h.a.a<KeyguardManager> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final e f32188a = null;

        static {
            f32188a = new e();
        }

        public e() {
            super(0);
        }

        public final KeyguardManager a() {
            Object r2 = ((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppHost.Companion.getApplication(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin")).getSystemService("keyguard");
            d.h.b.o.a(r2, "null cannot be cast to non-null type android.app.KeyguardManager");
            return (KeyguardManager) ZeusTransformUtils.preCheckCast(r2, KeyguardManager.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.a
        public /* synthetic */ KeyguardManager invoke() {
            return a();
        }
    }

    static {
        f32174a = new p();
        f32175b = d.g.a(e.f32188a);
        f32176c = new d();
        f32177d = new GsonBuilder().registerTypeAdapter(AppEntity.class, new a()).create();
    }

    private p() {
    }

    private final IntentResult<?> a(String r14, int r15) {
        return new IntentResult(r15, null, null, r14, false, false, 0, null, null, null, DownloadErrorCode.ERROR_REMOVE_DOWNLOAD_RUNNABLE, null);
    }

    private final <T> Constructor<T> a(Class<T> r1) {
        return r1.getConstructor(new Class[0]);
    }

    private final Type a(String r4) {
        return ZeusTransformUtils.forName(r4, "com.obric.aiagent.plugin");
    L4:
        e = move-exception;
        Logger.INSTANCE.e("IntentExecutor", "queryIntentParamType -- invalid typeName=" + r4 + "; e=" + e);
        return null;
    }

    private final Object b(String r3, String r4, String r5) {
        Type r2 = a(r4);
        if (r2 != null) goto L10;
        return null;
    L10:
        return f32177d.fromJson(r5, r2);
    L7:
        e = move-exception;
        Logger.INSTANCE.e("IntentExecutor", "handleIntentCalling -- parsing InputParams for intent: `" + r3 + "`: jsonException=" + e);
        return null;
    }

    public final Boolean a(String r6, String r7) {
        d.h.b.o.e(r6, "messageId");
        d.h.b.o.e(r7, "jobId");
        d r5 = f32176c;
        monitor-enter(r5);
        Set r0 = (Set) ZeusTransformUtils.preCheckCast(r5.get(r6), Set.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L22
        if (r0 == null) goto L15;
        d.h.b.o.c(r0, "intentMap[messageId]");     // Catch: Throwable -> L22
        Iterator r1 = r0.iterator();     // Catch: Throwable -> L22
    L8:
        if (r1.hasNext() == false) goto L12;
        Object r2 = r1.next();     // Catch: Throwable -> L22
        if (d.h.b.o.a(((d.m) ZeusTransformUtils.preCheckCast(r2, d.m.class, "com.obric.aiagent.plugin")).a(), r7) == false) goto L8;
    L13:
        d.m r8 = (d.m) ZeusTransformUtils.preCheckCast(r2, d.m.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L22
    L16:
        monitor-exit(r5);
        if (r8 == null) goto L30;
        IntentFunction r9 = (IntentFunction) ZeusTransformUtils.preCheckCast(r8.b(), IntentFunction.class, "com.obric.aiagent.plugin");
        if (r9 != null) goto L21;
        return null;
    L21:
        return r9.isTaskOnGoing(new DispatchContext((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppHost.Companion.getApplication(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin"), Long.valueOf(Long.parseLong(r6)), ao.b()));
    L30:
        return null;
    L12:
        r2 = null;
        goto L13
    L15:
        r8 = null;
    L22:
        th = move-exception;
        throw th;
    }

    public final Object a(Context r19, IntentCalling r20, String r21, d.c.d<? super IntentResult<?>> r22) {
        p r1 = this;
        IntentCalling r2 = r20;
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r19, Context.class, "com.obric.aiagent.plugin");
        d.c.d r4 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r22, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r4, b.class) == false) goto L7;
        b r5 = (b) ZeusTransformUtils.preCheckCast(r4, b.class, "com.obric.aiagent.plugin");
        int r6 = r5.f;
        if ((r6 & Integer.MIN_VALUE) == 0) goto L7;
        r5.f = r6 - Integer.MIN_VALUE;
    L8:
        Object r7 = r5.f32181d;
        Object r8 = d.c.a.b.a();
        int r9 = r5.f;
        if (r9 == 0) goto L22;
        if (r9 == 1) goto L15;
        if (r9 != 2) goto L14;
        IntentCalling r10 = (IntentCalling) ZeusTransformUtils.preCheckCast(r5.f32180c, IntentCalling.class, "com.obric.aiagent.plugin");
        r3 = (Context) ZeusTransformUtils.preCheckCast(r5.f32179b, Context.class, "com.obric.aiagent.plugin");
        p r11 = (p) ZeusTransformUtils.preCheckCast(r5.f32178a, p.class, "com.obric.aiagent.plugin");
    L99:
        d.o.a(r7);     // Catch: Exception -> L18 ClassCastException -> L20
        p r17 = r11;
        r2 = r10;
        r1 = r17;
    L74:
        IntentResult r0 = (IntentResult) ZeusTransformUtils.preCheckCast(r7, IntentResult.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L78 ClassCastException -> L80
        if (r0 != null) goto L101;
        String r12 = r3.getString(ZeusTransformUtils.mapRes(R.string.obric_action_exec_started, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_action_exec_started"));
        d.h.b.o.c(r12, "context.getString(R.stri…bric_action_exec_started)");
        return new IntentResult(0, null, null, r12, false, false, 0, null, null, null, DownloadErrorCode.ERROR_REMOVE_DOWNLOAD_RUNNABLE, null);
    L101:
        return r0;
    L80:
        ClassCastException e2 = e;
    L83:
        Logger.INSTANCE.e("IntentExecutor", "execIntentAsync -- the injection of InputParams for intent: `" + r2.getIntentName() + "` failed at execution; e=" + e2);
        String r13 = r3.getString(ZeusTransformUtils.mapRes(R.string.obric_intent_app_exec_failed, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_intent_app_exec_failed"));
        d.h.b.o.c(r13, "context.getString(R.stri…c_intent_app_exec_failed)");
        int r14 = -1007;
    L28:
        return r1.a(r13, r14);
    L78:
        Exception e3 = e;
    L82:
        Logger.INSTANCE.e("IntentExecutor", "execIntentAsync -- the execution for intent: `" + r2.getIntentName() + "` failed; e=" + e3, e3);
        r13 = r3.getString(ZeusTransformUtils.mapRes(R.string.obric_intent_app_exec_failed, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_intent_app_exec_failed"));
        d.h.b.o.c(r13, "context.getString(R.stri…c_intent_app_exec_failed)");
        r14 = -1008;
        goto L28
    L20:
        e2 = e;
        p r18 = r11;
        r2 = r10;
        r1 = r18;
    L18:
        e3 = e;
        p r110 = r11;
        r2 = r10;
        r1 = r110;
        goto L82
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        r10 = (IntentCalling) ZeusTransformUtils.preCheckCast(r5.f32180c, IntentCalling.class, "com.obric.aiagent.plugin");
        r3 = (Context) ZeusTransformUtils.preCheckCast(r5.f32179b, Context.class, "com.obric.aiagent.plugin");
        r11 = (p) ZeusTransformUtils.preCheckCast(r5.f32178a, p.class, "com.obric.aiagent.plugin");
        goto L99
    L22:
        d.o.a(r7);
        Logger r15 = Logger.INSTANCE;
        r15.d("IntentExecutor", "handleIntentCalling = " + r20.getIntentName() + '/' + r20.getQuestionId());
        Class r16 = ZeusTransformUtils.forName(r20.getImplClassName(), "com.obric.aiagent.plugin");     // Catch: ClassNotFoundException -> L90
        d.h.b.o.c(r16, "intentClazz");
        Constructor r23 = r1.a(r16);
        if (r23 != null) goto L91;
        r15.d("IntentExecutor", "handleIntentCalling - impl `" + r20.getImplClassName() + "`: no constructor");
        r13 = r3.getString(ZeusTransformUtils.mapRes(R.string.obric_intent_app_exec_failed, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_intent_app_exec_failed"));
        d.h.b.o.c(r13, "context.getString(R.stri…c_intent_app_exec_failed)");
        r14 = -1001;
        goto L28
    L91:
        Object r24 = r23.newInstance(new Object[0]);     // Catch: Exception -> L88
        Class<?> r111 = null;
        if (ZeusTransformUtils.instanceOf(r24, IntentFunction.class) == false) goto L34;
        Object r25 = r24;
    L35:
        IntentFunction r26 = (IntentFunction) ZeusTransformUtils.preCheckCast(r25, IntentFunction.class, "com.obric.aiagent.plugin");
        if (r26 != null) goto L38;
        r15.d("IntentExecutor", "handleIntentCalling - impl `" + r20.getImplClassName() + "`: cannot cast intent object (" + r24 + ") to IntentFunction<Parcelable, *>");
        r13 = r3.getString(ZeusTransformUtils.mapRes(R.string.obric_intent_app_exec_failed, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_intent_app_exec_failed"));
        d.h.b.o.c(r13, "context.getString(R.stri…c_intent_app_exec_failed)");
        r14 = -1003;
        goto L28
    L38:
        d r27 = f32176c;
        monitor-enter(r27);
        String r112 = String.valueOf(r20.getQuestionId());     // Catch: Throwable -> L85
        Object r113 = r27.get(r112);     // Catch: Throwable -> L85
        if (r113 != null) goto L43;
        r113 = new LinkedHashSet();     // Catch: Throwable -> L85
        r27.put(r112, r113);     // Catch: Throwable -> L85
    L43:
        ((Set) ZeusTransformUtils.preCheckCast(r113, Set.class, "com.obric.aiagent.plugin")).add(d.s.a(r21, r26));     // Catch: Throwable -> L85
        monitor-exit(r27);
        if (r20.getInputParamsParcel() == null) goto L49;
        Object r28 = r20.getInputParamsParcel();
        d.h.b.o.a(r28);
    L56:
        if (ZeusTransformUtils.instanceOf(r28, Parcelable.class) == false) goto L58;
        Object r114 = r28;
    L59:
        Parcelable r115 = (Parcelable) ZeusTransformUtils.preCheckCast(r114, Parcelable.class, "com.obric.aiagent.plugin");
        if (r115 != null) goto L65;
        StringBuilder r29 = new StringBuilder().append("execIntentAsync -- casting InputParams for intent: `").append(r20.getIntentName()).append("` failed; required type = `Parcelable`; tried `");
        if (r28 == null) goto L64;
        r111 = r28.getClass();
    L64:
        r15.e("IntentExecutor", r29.append(r111).append('`').toString());
        r13 = r3.getString(ZeusTransformUtils.mapRes(R.string.obric_intent_app_exec_failed, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_intent_app_exec_failed"));
        d.h.b.o.c(r13, "context.getString(R.stri…c_intent_app_exec_failed)");
        r14 = -1006;
        goto L28
    L65:
        DispatchContext r30 = new DispatchContext(r3, d.c.b.a.b.a(r20.getQuestionId()), r20.getExt());
        if (r26.isBlock() == false) goto L71;
        r5.f32178a = r1;     // Catch: Exception -> L78 ClassCastException -> L80
        r5.f32179b = r3;     // Catch: Exception -> L78 ClassCastException -> L80
        r5.f32180c = r2;     // Catch: Exception -> L78 ClassCastException -> L80
        r5.f = 1;     // Catch: Exception -> L78 ClassCastException -> L80
        r7 = r26.doAction(r115, r30, r5);     // Catch: Exception -> L78 ClassCastException -> L80
        if (r7 != r8) goto L74;
        return r8;
    L71:
        c r31 = new c(r26, r115, r30, null);     // Catch: Exception -> L78 ClassCastException -> L80
        r5.f32178a = r1;     // Catch: Exception -> L78 ClassCastException -> L80
        r5.f32179b = r3;     // Catch: Exception -> L78 ClassCastException -> L80
        r5.f32180c = r2;     // Catch: Exception -> L78 ClassCastException -> L80
        r5.f = 2;     // Catch: Exception -> L78 ClassCastException -> L80
        r7 = dg.b(WsConstants.EXIT_DELAY_TIME, r31, r5);     // Catch: Exception -> L78 ClassCastException -> L80
        if (r7 != r8) goto L74;
        return r8;
    L58:
        r114 = null;
        goto L59
    L49:
        if (r20.getInputParamTypeName() != null) goto L51;
    L84:
        r15.e("IntentExecutor", "handleIntentCalling -- InputParams not available: (" + r2 + ')');
        r13 = r3.getString(ZeusTransformUtils.mapRes(R.string.obric_intent_app_exec_failed, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_intent_app_exec_failed"));
        d.h.b.o.c(r13, "context.getString(R.stri…c_intent_app_exec_failed)");
        r14 = -1005;
        goto L28
    L51:
        if (r20.getInputParams() == null) goto L84;
        String r32 = r20.getIntentName();
        String r116 = r20.getInputParamTypeName();
        d.h.b.o.a(r116);
        String r117 = r20.getInputParams();
        d.h.b.o.a(r117);
        r28 = r1.b(r32, r116, r117);
        if (r28 != null) goto L56;
        r13 = r3.getString(ZeusTransformUtils.mapRes(R.string.obric_intent_app_exec_failed, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_intent_app_exec_failed"));
        d.h.b.o.c(r13, "context.getString(R.stri…c_intent_app_exec_failed)");
        r14 = -1004;
    L85:
        th = move-exception;
        throw th;
    L34:
        r25 = null;
    L88:
        e = move-exception;
        Logger.INSTANCE.e("IntentExecutor", "handleIntentCalling - impl `" + r20.getImplClassName() + "`: creation of intent object failed; e=" + e, e);
        r13 = r3.getString(ZeusTransformUtils.mapRes(R.string.obric_intent_app_exec_failed, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_intent_app_exec_failed"));
        d.h.b.o.c(r13, "context.getString(R.stri…c_intent_app_exec_failed)");
        r14 = -1002;
    L90:
        Logger.INSTANCE.d("IntentExecutor", "handleIntentCalling - impl `" + r20.getImplClassName() + "`: not found");
        r13 = r3.getString(ZeusTransformUtils.mapRes(R.string.obric_action_not_support, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_action_not_support"));
        d.h.b.o.c(r13, "context.getString(R.stri…obric_action_not_support)");
        r14 = -1000;
    L7:
        r5 = new b(r1, r4);
        goto L8
    }

    public final LinkedHashMap<String, Set<d.m<String, IntentFunction<?, ?>>>> a() {
        return f32176c;
    }

    public final boolean a(String r6, String r7, String r8) {
        d.h.b.o.e(r6, "messageId");
        d.h.b.o.e(r7, "reason");
        d.h.b.o.e(r8, "jobId");
        Logger.INSTANCE.i("IntentExecutor", "ready to cancel task messageId " + r6 + ", reason=" + r7);
        d r5 = f32176c;
        monitor-enter(r5);
        Set r0 = (Set) ZeusTransformUtils.preCheckCast(r5.get(r6), Set.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L18
        d.m r1 = null;
        Object r2 = null;
        if (r0 == null) goto L13;
        d.h.b.o.c(r0, "intentMap[messageId]");     // Catch: Throwable -> L18
        Iterator r3 = r0.iterator();     // Catch: Throwable -> L18
    L8:
        if (r3.hasNext() == false) goto L12;
        Object r4 = r3.next();     // Catch: Throwable -> L18
        if (d.h.b.o.a(((d.m) ZeusTransformUtils.preCheckCast(r4, d.m.class, "com.obric.aiagent.plugin")).a(), r8) == false) goto L8;
        r2 = r4;
    L12:
        r1 = (d.m) ZeusTransformUtils.preCheckCast(r2, d.m.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L18
    L13:
        monitor-exit(r5);
        if (r1 == null) goto L16;
        boolean r9 = ((IntentFunction) ZeusTransformUtils.preCheckCast(r1.b(), IntentFunction.class, "com.obric.aiagent.plugin")).cancelTask(r7);
        Logger.INSTANCE.i("IntentExecutor", "Task cancellation for messageId " + r6 + ", jobId " + r8 + ": " + r9 + ", reason=" + r7);
        return r9;
    L16:
        Logger.INSTANCE.w("IntentExecutor", "No targetIntent found for messageId " + r6);
        return false;
    L18:
        th = move-exception;
        throw th;
    }
}
