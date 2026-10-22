package com.obric.event.task.nlp.b;

import com.bytedance.apm.battery.dao.DBHelper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.obric.autoaction.app.launcherpage.api.IAutoTaskApi;
import com.obric.capabilitykit.common.ErrorCode;
import com.obric.capabilitykit.common.intent.IntentParams;
import com.obric.capabilitykit.common.intent.SystemAutoActionParams;
import com.obric.event.task.nlp.api.q;
import com.obric.event.task.nlp.spi.IEventTaskNlpDepend;
import com.obric.eventkit.task.api.IEventTaskApi;
import com.obric.eventkit.task.model.BluetoothCondition;
import com.obric.eventkit.task.model.Condition;
import com.obric.eventkit.task.model.ConditionGroup;
import com.obric.eventkit.task.model.ConditionTaskAction;
import com.obric.eventkit.task.model.ConditionTaskSpec;
import com.obric.eventkit.task.model.EventTask;
import com.obric.eventkit.task.model.LocationCondition;
import com.obric.eventkit.task.model.PeriodicPolicy;
import com.obric.eventkit.task.model.SmsCondition;
import com.obric.eventkit.task.model.TimeCondition;
import com.obric.eventkit.task.model.TriggerControlPolicy;
import com.obric.eventkit.task.model.WifiCondition;
import com.obric.oui.dialog.base.AbstractDialog;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.ao;
import d.a.p;
import d.o;
import d.x;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlinx.coroutines.am;
import kotlinx.coroutines.bd;

/* JADX INFO: compiled from: EventTaskParser.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class g {
    private static final String TAG = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final g f32990a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Gson f32991b = null;

    /* JADX INFO: compiled from: EventTaskParser.kt */
    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f32992a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f32993b = null;

        static {
            int[] r0 = new int[com.obric.event.task.nlp.api.f.values().length];
            r0[com.obric.event.task.nlp.api.f.f32907d.ordinal()] = 1;     // Catch: NoSuchFieldError -> L24
        L47:
            r0[com.obric.event.task.nlp.api.f.f32908e.ordinal()] = 2;     // Catch: NoSuchFieldError -> L25
        L61:
            r0[com.obric.event.task.nlp.api.f.f.ordinal()] = 3;     // Catch: NoSuchFieldError -> L26
        L49:
            r0[com.obric.event.task.nlp.api.f.f32904a.ordinal()] = 4;     // Catch: NoSuchFieldError -> L27
        L51:
            r0[com.obric.event.task.nlp.api.f.f32906c.ordinal()] = 5;     // Catch: NoSuchFieldError -> L28
        L37:
            r0[com.obric.event.task.nlp.api.f.f32905b.ordinal()] = 6;     // Catch: NoSuchFieldError -> L29
        L14:
            f32992a = r0;
            int[] r1 = new int[com.obric.event.task.nlp.api.l.values().length];
            r1[com.obric.event.task.nlp.api.l.f32930a.ordinal()] = 1;     // Catch: NoSuchFieldError -> L30
        L57:
            r1[com.obric.event.task.nlp.api.l.f32931b.ordinal()] = 2;     // Catch: NoSuchFieldError -> L31
        L41:
            r1[com.obric.event.task.nlp.api.l.f.ordinal()] = 3;     // Catch: NoSuchFieldError -> L32
        L55:
            r1[com.obric.event.task.nlp.api.l.g.ordinal()] = 4;     // Catch: NoSuchFieldError -> L33
        L39:
            r1[com.obric.event.task.nlp.api.l.f32932c.ordinal()] = 5;     // Catch: NoSuchFieldError -> L34
        L53:
            r1[com.obric.event.task.nlp.api.l.f32933d.ordinal()] = 6;     // Catch: NoSuchFieldError -> L35
        L45:
            r1[com.obric.event.task.nlp.api.l.f32934e.ordinal()] = 7;     // Catch: NoSuchFieldError -> L36
        L22:
            f32993b = r1;
        }
    }

    /* JADX INFO: compiled from: EventTaskParser.kt */
    @d.c.b.a.f(b = "EventTaskParser.kt", c = {45, 47}, d = "invokeSuspend", e = "com.obric.event.task.nlp.manager.EventTaskParser$getAvailableTaskCount$2")
    static final class b extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super Integer>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f32994a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f32995b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int f32996c;

        b(d.c.d<? super b> r3) {
            super(2, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        public final Object a(am r3, d.c.d<? super Integer> r4) {
            return ((b) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), b.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r1, d.c.d<?> r2) {
            return (d.c.d) ZeusTransformUtils.preCheckCast(new b((d.c.d) ZeusTransformUtils.wrapperContextForParams(r2, d.c.d.class, "com.obric.aiagent.plugin")), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super Integer> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r12) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f32996c;
            int r5 = 0;
            if (r1 == 0) goto L10;
            if (r1 == 1) goto L9;
            if (r1 != 2) goto L8;
            int r11 = this.f32995b;
            o.a(r12);
        L36:
            List r13 = (List) ZeusTransformUtils.preCheckCast(r12, List.class, "com.obric.aiagent.plugin");
            if (r13 == null) goto L51;
            Iterable r14 = (Iterable) ZeusTransformUtils.preCheckCast(r13, Iterable.class, "com.obric.aiagent.plugin");
            Collection r2 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");
            Iterator r15 = r14.iterator();
        L40:
            if (r15.hasNext() == false) goto L50;
            Object r3 = r15.next();
            Integer r4 = ((EventTask) ZeusTransformUtils.preCheckCast(r3, EventTask.class, "com.obric.aiagent.plugin")).getEnableStatus();
            if (r4 != null) goto L45;
        L47:
            boolean r6 = false;
        L48:
            if (r6 == false) goto L40;
            r2.add(r3);
            goto L40
        L45:
            if (r4.intValue() != 0) goto L47;
            r6 = true;
            goto L48
        L50:
            r5 = ((List) ZeusTransformUtils.preCheckCast(r2, List.class, "com.obric.aiagent.plugin")).size();
        L54:
            return d.c.b.a.b.a(r11 + r5);
        L51:
            int r16 = r11;
        L52:
            r11 = r16;
            goto L54
        L8:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L9:
            IEventTaskApi r7 = (IEventTaskApi) ZeusTransformUtils.preCheckCast(this.f32994a, IEventTaskApi.class, "com.obric.aiagent.plugin");
            o.a(r12);
        L15:
            List r17 = (List) ZeusTransformUtils.preCheckCast(r12, List.class, "com.obric.aiagent.plugin");
            if (r17 == null) goto L30;
            Iterable r18 = (Iterable) ZeusTransformUtils.preCheckCast(r17, Iterable.class, "com.obric.aiagent.plugin");
            Collection r8 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");
            Iterator r19 = r18.iterator();
        L19:
            if (r19.hasNext() == false) goto L29;
            Object r9 = r19.next();
            Integer r10 = ((EventTask) ZeusTransformUtils.preCheckCast(r9, EventTask.class, "com.obric.aiagent.plugin")).getEnableStatus();
            if (r10 != null) goto L24;
        L26:
            boolean r20 = false;
        L27:
            if (r20 == false) goto L19;
            r8.add(r9);
            goto L19
        L24:
            if (r10.intValue() != 0) goto L26;
            r20 = true;
            goto L27
        L29:
            r16 = ((List) ZeusTransformUtils.preCheckCast(r8, List.class, "com.obric.aiagent.plugin")).size();
        L31:
            if (r7 == null) goto L52;
            d.c.d<? super List<? extends EventTask>> r21 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f32994a = null;
            this.f32995b = r16;
            this.f32996c = 2;
            Object r110 = r7.getEventTasksByType(2, 0, Integer.MAX_VALUE, r21);
            if (r110 != r0) goto L35;
            return r0;
        L35:
            int r111 = r16;
            r12 = r110;
            r11 = r111;
        L30:
            r16 = 0;
            goto L31
        L10:
            o.a(r12);
            r7 = (IEventTaskApi) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IEventTaskApi.class), IEventTaskApi.class, "com.obric.aiagent.plugin");
            if (r7 == null) goto L30;
            d.c.d<? super List<? extends EventTask>> r112 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f32994a = r7;
            this.f32996c = 1;
            r12 = r7.getEventTasksByType(1, 0, Integer.MAX_VALUE, r112);
            if (r12 != r0) goto L15;
            return r0;
        }
    }

    /* JADX INFO: compiled from: EventTaskParser.kt */
    @d.c.b.a.f(b = "EventTaskParser.kt", c = {123, 153, AbstractDialog.HORIZONTAL_TOP_SYSBAR_HEIGHT}, d = "parseEventTaskFromDto", e = "com.obric.event.task.nlp.manager.EventTaskParser")
    static final class c extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f32997a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f32998b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Object f32999c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        Object f33000d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        Object f33001e;
        Object f;
        int g;
        /* synthetic */ Object h;
        final /* synthetic */ g i;
        int j;

        c(g r3, d.c.d<? super c> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.i = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.h = r3;
            this.j |= Integer.MIN_VALUE;
            return this.i.a(null, null, null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    private g() {
    }

    static {
        f32990a = new g();
        TAG = "EventTaskParser";
        f32991b = new GsonBuilder().registerTypeAdapter((Type) ZeusTransformUtils.preCheckCast(com.obric.event.task.nlp.api.e.class, Type.class, "com.obric.aiagent.plugin"), new d()).registerTypeAdapter((Type) ZeusTransformUtils.preCheckCast(com.obric.event.task.nlp.api.e.class, Type.class, "com.obric.aiagent.plugin"), new e()).create();
    }

    private final Object a(d.c.d<? super Integer> r4) {
        d.c.d r3 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
        return kotlinx.coroutines.i.a((d.c.g) ZeusTransformUtils.preCheckCast(bd.c(), d.c.g.class, "com.obric.aiagent.plugin"), (d.h.a.m) ZeusTransformUtils.preCheckCast(new b(null), d.h.a.m.class, "com.obric.aiagent.plugin"), r3);
    }

    public final com.obric.event.task.nlp.api.d<com.obric.event.task.nlp.api.g> a(String r8) {
        d.h.b.o.e(r8, "eventTaskJson");
        return new com.obric.event.task.nlp.api.d((com.obric.event.task.nlp.api.g) ZeusTransformUtils.preCheckCast(f32991b.fromJson(r8, com.obric.event.task.nlp.api.g.class), com.obric.event.task.nlp.api.g.class, "com.obric.aiagent.plugin"), null, 0, null, 10, null);
    L5:
        e = move-exception;
        com.obric.event.task.nlp.a.a.f32889a.b(TAG, "parseJSON2DTO error", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
        return new com.obric.event.task.nlp.api.d(null, "parseJSON2DTO error, " + e.getMessage(), ErrorCode.EventTask.JSON_PARSE_ERROR, null, 8, null);
    }

    public final com.obric.event.task.nlp.api.d<String> a(com.obric.event.task.nlp.api.g r8) {
        d.h.b.o.e(r8, "dto");
        return new com.obric.event.task.nlp.api.d(f32991b.toJson(r8), null, 0, null, 10, null);
    L5:
        e = move-exception;
        com.obric.event.task.nlp.a.a.f32889a.b(TAG, "convertDto2Json error", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
        return new com.obric.event.task.nlp.api.d(null, "convertDto2Json error, " + e.getMessage(), ErrorCode.EventTask.PARSE_ENTITY_TO_JSON_ERROR, null, 8, null);
    }

    public final com.obric.event.task.nlp.api.d<String> a(String r10, String r11) {
        d.h.b.o.e(r10, "originJsonStr");
        d.h.b.o.e(r11, "updateJsonStr");
        JsonElement r12 = JsonParser.parseString(r10);     // Catch: Exception -> L13
        if (r12.isJsonObject() == true) goto L7;
        com.obric.event.task.nlp.a.a.f32889a.d(TAG, "jsonDeepMerge error, originJsonStr is not json object");     // Catch: Exception -> L13
        return new com.obric.event.task.nlp.api.d(null, "jsonDeepMerge error, originJsonStr is not json object", ErrorCode.EventTask.JSON_MERGE_ERROR, null, 8, null);
    L7:
        JsonElement r13 = JsonParser.parseString(r11);     // Catch: Exception -> L13
        if (r13.isJsonObject() == true) goto L11;
        com.obric.event.task.nlp.a.a.f32889a.d(TAG, "jsonDeepMerge error, updateJsonStr is not json object");     // Catch: Exception -> L13
        return new com.obric.event.task.nlp.api.d(null, "jsonDeepMerge error, updateJsonStr is not json object", ErrorCode.EventTask.JSON_MERGE_ERROR, null, 8, null);
    L11:
        JsonObject r14 = r12.getAsJsonObject().deepCopy();     // Catch: Exception -> L13
        d.h.b.o.a(r14);     // Catch: Exception -> L13
        JsonObject r15 = r13.getAsJsonObject();     // Catch: Exception -> L13
        d.h.b.o.c(r15, "getAsJsonObject(...)");     // Catch: Exception -> L13
        a(r14, r15);     // Catch: Exception -> L13
        return new com.obric.event.task.nlp.api.d(r14.toString(), null, 0, null, 10, null);
    L13:
        e = move-exception;
        com.obric.event.task.nlp.a.a.f32889a.b(TAG, "jsonDeepMerge error", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
        return new com.obric.event.task.nlp.api.d(null, "jsonDeepMerge error, " + e.getMessage(), ErrorCode.EventTask.JSON_MERGE_ERROR, null, 8, null);
    }

    public final Object a(String r30, String r31, com.obric.event.task.nlp.api.g r32, d.c.d<? super com.obric.event.task.nlp.api.d<ConditionTaskSpec>> r33) {
        d.c.d r1 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r33, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r1, c.class) == false) goto L7;
        c r3 = (c) ZeusTransformUtils.preCheckCast(r1, c.class, "com.obric.aiagent.plugin");
        if ((r3.j & Integer.MIN_VALUE) == 0) goto L7;
        r3.j -= Integer.MIN_VALUE;
    L8:
        Object r2 = r3.h;
        Object r4 = d.c.a.b.a();
        int r5 = r3.j;
        if (r5 == 0) goto L18;
        if (r5 == 1) goto L17;
        if (r5 == 2) goto L16;
        if (r5 != 3) goto L15;
        int r0 = r3.g;
        Map<String, String> r6 = (Map) ZeusTransformUtils.preCheckCast(r3.f, Map.class, "com.obric.aiagent.plugin");
        ConditionTaskAction r7 = (ConditionTaskAction) ZeusTransformUtils.preCheckCast(r3.f33001e, ConditionTaskAction.class, "com.obric.aiagent.plugin");
        TriggerControlPolicy r8 = (TriggerControlPolicy) ZeusTransformUtils.preCheckCast(r3.f33000d, TriggerControlPolicy.class, "com.obric.aiagent.plugin");
        com.obric.event.task.nlp.api.d<PeriodicPolicy> r9 = (com.obric.event.task.nlp.api.d) ZeusTransformUtils.preCheckCast(r3.f32999c, com.obric.event.task.nlp.api.d.class, "com.obric.aiagent.plugin");
        com.obric.event.task.nlp.api.d<ConditionGroup> r10 = (com.obric.event.task.nlp.api.d) ZeusTransformUtils.preCheckCast(r3.f32998b, com.obric.event.task.nlp.api.d.class, "com.obric.aiagent.plugin");
        com.obric.event.task.nlp.api.g r11 = (com.obric.event.task.nlp.api.g) ZeusTransformUtils.preCheckCast(r3.f32997a, com.obric.event.task.nlp.api.g.class, "com.obric.aiagent.plugin");
        o.a(r2);
    L67:
        Map<String, String> r12 = (Map) ZeusTransformUtils.preCheckCast(r2, Map.class, "com.obric.aiagent.plugin");
        if (r12 == null) goto L70;
        Map<String, String> r16 = r12;
        TriggerControlPolicy r20 = r8;
    L72:
        String r13 = r11.a();
        List r17 = p.a(r7);
        ConditionGroup r18 = (ConditionGroup) ZeusTransformUtils.preCheckCast(r10.a(), ConditionGroup.class, "com.obric.aiagent.plugin");
        PeriodicPolicy r19 = (PeriodicPolicy) ZeusTransformUtils.preCheckCast(r9.a(), PeriodicPolicy.class, "com.obric.aiagent.plugin");
        String r14 = r11.j();
        if (r14 == null) goto L77;
        int r15 = 1;
        if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r14, CharSequence.class, "com.obric.aiagent.plugin"))) == true) goto L79;
    L78:
        r14 = null;
    L79:
        if (r14 != null) goto L81;
        String r110 = "";
    L83:
        return new com.obric.event.task.nlp.api.d(new ConditionTaskSpec(r13, d.c.b.a.b.a(r15), null, null, r110, null, d.c.b.a.b.a(r0), r16, r17, r18, r19, r20), null, 0, null, 10, null);
    L81:
        r110 = r14;
        goto L83
    L77:
        r15 = 1;
        goto L78
    L70:
        com.obric.event.task.nlp.api.g r111 = r11;
        ConditionTaskAction r112 = r7;
        TriggerControlPolicy r21 = r8;
        Map<String, String> r22 = r6;
    L71:
        r16 = r22;
        r20 = r21;
        r7 = r112;
        r11 = r111;
        goto L72
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        r0 = r3.g;
        ConditionTaskAction r23 = (ConditionTaskAction) ZeusTransformUtils.preCheckCast(r3.f33001e, ConditionTaskAction.class, "com.obric.aiagent.plugin");
        TriggerControlPolicy r24 = (TriggerControlPolicy) ZeusTransformUtils.preCheckCast(r3.f33000d, TriggerControlPolicy.class, "com.obric.aiagent.plugin");
        com.obric.event.task.nlp.api.d<PeriodicPolicy> r113 = (com.obric.event.task.nlp.api.d) ZeusTransformUtils.preCheckCast(r3.f32999c, com.obric.event.task.nlp.api.d.class, "com.obric.aiagent.plugin");
        com.obric.event.task.nlp.api.d<ConditionGroup> r114 = (com.obric.event.task.nlp.api.d) ZeusTransformUtils.preCheckCast(r3.f32998b, com.obric.event.task.nlp.api.d.class, "com.obric.aiagent.plugin");
        r111 = (com.obric.event.task.nlp.api.g) ZeusTransformUtils.preCheckCast(r3.f32997a, com.obric.event.task.nlp.api.g.class, "com.obric.aiagent.plugin");
        o.a(r2);
    L50:
        Map<String, String> r25 = (Map) ZeusTransformUtils.preCheckCast(r2, Map.class, "com.obric.aiagent.plugin");
        if (r25 == null) goto L53;
        r21 = r24;
        r9 = r113;
        r10 = r114;
        r112 = r23;
        r22 = r25;
    L58:
        IAutoTaskApi r26 = (IAutoTaskApi) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IAutoTaskApi.class), IAutoTaskApi.class, "com.obric.aiagent.plugin");
        if (r26 == null) goto L71;
        String r115 = r111.b();
        if (r115 != null) goto L63;
        r115 = "";
    L63:
        r3.f32997a = r111;
        r3.f32998b = r10;
        r3.f32999c = r9;
        r3.f33000d = r21;
        r3.f33001e = r112;
        r3.f = r22;
        r3.g = r0;
        r3.j = 3;
        r2 = r26.appendSemanticIconExt(r115, r22, r3);
        if (r2 != r4) goto L66;
        return r4;
    L66:
        r6 = r22;
        r8 = r21;
        r7 = r112;
        r11 = r111;
        goto L67
    L53:
        int r116 = r0;
        r21 = r24;
        com.obric.event.task.nlp.api.d<ConditionGroup> r27 = r114;
        com.obric.event.task.nlp.api.g r28 = r111;
        r112 = r23;
    L54:
        r22 = r28.k();
        if (r22 != null) goto L57;
        r22 = ao.b();
    L57:
        r111 = r28;
        r9 = r113;
        r0 = r116;
        r10 = r27;
        goto L58
    L17:
        r28 = (com.obric.event.task.nlp.api.g) ZeusTransformUtils.preCheckCast(r3.f33000d, com.obric.event.task.nlp.api.g.class, "com.obric.aiagent.plugin");
        String r29 = (String) ZeusTransformUtils.preCheckCast(r3.f32999c, String.class, "com.obric.aiagent.plugin");
        String r117 = (String) ZeusTransformUtils.preCheckCast(r3.f32998b, String.class, "com.obric.aiagent.plugin");
        g r118 = (g) ZeusTransformUtils.preCheckCast(r3.f32997a, g.class, "com.obric.aiagent.plugin");
        o.a(r2);
        Object r119 = r2;
        String r34 = r117;
    L22:
        int r120 = ((Number) ZeusTransformUtils.preCheckCast(r119, Number.class, "com.obric.aiagent.plugin")).intValue();
        IEventTaskNlpDepend r121 = (IEventTaskNlpDepend) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IEventTaskNlpDepend.class), IEventTaskNlpDepend.class, "com.obric.aiagent.plugin");
        if (r121 == null) goto L25;
        int r122 = r121.getMaxTaskCount();
    L26:
        r116 = 0;
        if (r120 < r122) goto L29;
        boolean r123 = true;
    L30:
        if (r123 == false) goto L32;
        r116 = 2;
    L32:
        com.obric.event.task.nlp.a.a r124 = com.obric.event.task.nlp.a.a.f32889a;
        String r125 = TAG;
        r124.b(r125, "parseEventTaskFromDto enableStatus: " + r116);
        r27 = r118.a(r34, r28);
        if (r27.a() != null) goto L36;
        com.obric.event.task.nlp.a.a.f32889a.d(r125, "parseEventTaskToSpec conditionData error");
        return new com.obric.event.task.nlp.api.d(null, r27.b(), r27.c(), null, 8, null);
    L36:
        r113 = r118.a(r28.e(), r28.f(), r28.c(), r28.d());
        if (r113.a() != null) goto L40;
        com.obric.event.task.nlp.a.a.f32889a.d(r125, "parseEventTaskToSpec periodicPolicyData error");
        return new com.obric.event.task.nlp.api.d(null, r113.b(), r113.c(), null, 8, null);
    L40:
        r21 = (TriggerControlPolicy) ZeusTransformUtils.preCheckCast(r118.a(r28.l()).a(), TriggerControlPolicy.class, "com.obric.aiagent.plugin");
        String r126 = r28.b();
        if (r126 != null) goto L43;
        String r127 = "";
    L44:
        r112 = new ConditionTaskAction("System_AutoAction", (IntentParams) ZeusTransformUtils.preCheckCast(new SystemAutoActionParams(r127, null, null, null, null, null, null, null, 254, null), IntentParams.class, "com.obric.aiagent.plugin"));
        IEventTaskNlpDepend r128 = (IEventTaskNlpDepend) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IEventTaskNlpDepend.class), IEventTaskNlpDepend.class, "com.obric.aiagent.plugin");
        if (r128 == null) goto L54;
        Map<String, String> r129 = r28.k();
        r3.f32997a = r28;
        r3.f32998b = r27;
        r3.f32999c = r113;
        r3.f33000d = r21;
        r3.f33001e = r112;
        r3.g = r116;
        r3.j = 2;
        Object r35 = r128.appendTaskExtForCard(r129, r29, r3);
        if (r35 != r4) goto L49;
        return r4;
    L49:
        r111 = r28;
        r24 = r21;
        r0 = r116;
        r114 = r27;
        r2 = r35;
        r23 = r112;
        goto L50
    L43:
        r127 = r126;
        goto L44
    L29:
        r123 = false;
        goto L30
    L25:
        r122 = 5;
        goto L26
    L18:
        o.a(r2);
        r3.f32997a = this;
        r34 = r30;
        r3.f32998b = r34;
        r29 = r31;
        r3.f32999c = r29;
        r3.f33000d = r32;
        r3.j = 1;
        Object r130 = a(r3);
        if (r130 != r4) goto L21;
        return r4;
    L21:
        r118 = this;
        r28 = r32;
        r119 = r130;
    L7:
        r3 = new c(this, r1);
        goto L8
    }

    public final void a(JsonObject r5, JsonObject r6) {
        d.h.b.o.e(r5, "target");
        d.h.b.o.e(r6, DBHelper.BATTERY_COL_SOURCE);
        Iterator<Map.Entry<String, JsonElement>> r7 = r6.entrySet().iterator();
    L4:
        if (r7.hasNext() == false) goto L17;
        Map.Entry r0 = (Map.Entry) ZeusTransformUtils.preCheckCast(r7.next(), Map.Entry.class, "com.obric.aiagent.plugin");
        d.h.b.o.a(r0);
        String r1 = (String) ZeusTransformUtils.preCheckCast(r0.getKey(), String.class, "com.obric.aiagent.plugin");
        JsonElement r2 = (JsonElement) ZeusTransformUtils.preCheckCast(r0.getValue(), JsonElement.class, "com.obric.aiagent.plugin");
        if (r2.isJsonNull() == true) goto L7;
        if (r2.isJsonObject() == true) goto L10;
        r5.add(r1, r2.deepCopy());
        goto L4
    L10:
        JsonObject r3 = r2.getAsJsonObject();
        if (r5.has(r1) == false) goto L15;
        if (r5.get(r1).isJsonObject() == false) goto L15;
        JsonObject r4 = r5.get(r1).getAsJsonObject();
        d.h.b.o.a(r4);
        d.h.b.o.a(r3);
        a(r4, r3);
    L15:
        r5.add(r1, (JsonElement) ZeusTransformUtils.preCheckCast(r3.deepCopy(), JsonElement.class, "com.obric.aiagent.plugin"));
        goto L4
    L7:
        r5.remove(r1);
        goto L4
    }

    private final com.obric.event.task.nlp.api.d<ConditionGroup> a(String r11, com.obric.event.task.nlp.api.g r12) {
        com.obric.event.task.nlp.a.a r10 = com.obric.event.task.nlp.a.a.f32889a;
        String r0 = TAG;
        r10.b(r0, "parseCondition key = " + r11);
        ArrayList r13 = new ArrayList();
        com.obric.event.task.nlp.api.o r1 = r12.g();
        if (r1 == null) goto L9;
        com.obric.event.task.nlp.api.d<TimeCondition> r2 = k.f33005a.a(r1);
        if (r2.a() == null) goto L7;
        TimeCondition r3 = r2.a();
        d.h.b.o.a(r3);
        r13.add(r3);
        goto L9
    L7:
        return new com.obric.event.task.nlp.api.d(null, r2.b(), r2.c(), null, 8, null);
    L9:
        com.obric.event.task.nlp.api.i r4 = r12.h();
        if (r4 == null) goto L16;
        com.obric.event.task.nlp.api.d<LocationCondition> r5 = h.f33002a.a(r11, r4);
        if (r5.a() == null) goto L14;
        LocationCondition r6 = r5.a();
        d.h.b.o.a(r6);
        r13.add(r6);
        goto L16
    L14:
        return new com.obric.event.task.nlp.api.d(null, r5.b(), r5.c(), null, 8, null);
    L16:
        List<com.obric.event.task.nlp.api.e> r14 = r12.i();
        if (r14 == null) goto L24;
        com.obric.event.task.nlp.api.d<Condition> r15 = f32990a.a(r11, r14);
        if (r15.a() != null) goto L22;
        String r7 = r15.b();
        com.obric.event.task.nlp.a.a.f32889a.d(r0, "parseCondition parseDeviceCondition error, msg = " + r7);
        return new com.obric.event.task.nlp.api.d(null, r7, r15.c(), null, 8, null);
    L22:
        Condition r16 = r15.a();
        d.h.b.o.a(r16);
        r13.add(r16);
    L24:
        return new com.obric.event.task.nlp.api.d(new ConditionGroup("and", r13), null, 0, null, 10, null);
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    private final com.obric.event.task.nlp.api.d<Condition> a(String r12, List<com.obric.event.task.nlp.api.e> r13) {
        List r11 = (List) ZeusTransformUtils.wrapperContextForParams(r13, List.class, "com.obric.aiagent.plugin");
        com.obric.event.task.nlp.a.a r14 = com.obric.event.task.nlp.a.a.f32889a;
        String r1 = TAG;
        r14.b(r1, "parseDeviceCondition");
        int r15 = r11.size();
        if (r11.isEmpty() == false) goto L5;
    L114:
        com.obric.event.task.nlp.a.a.f32889a.d(r1, "parseDeviceCondition device condition size > 1, size = " + r15);
        return new com.obric.event.task.nlp.api.d(null, "device size error size = " + r15, ErrorCode.EventTask.DEVICE_CONDITION_SIZE_ERROR, null, 8, null);
    L5:
        if (r15 > 1) goto L114;
        com.obric.event.task.nlp.api.e r16 = (com.obric.event.task.nlp.api.e) ZeusTransformUtils.preCheckCast(r11.get(0), com.obric.event.task.nlp.api.e.class, "com.obric.aiagent.plugin");
        com.obric.event.task.nlp.api.f r17 = r16.getType();
        if (r17 != null) goto L10;
        int r18 = -1;
    L11:
        Integer r3 = null;
        com.obric.event.task.nlp.api.a r4 = null;
        com.obric.event.task.nlp.api.a r5 = null;
        com.obric.event.task.nlp.api.a r6 = null;
        Integer r7 = null;
        Integer r8 = null;
        switch(r18) {
            case 1: goto L96;
            case 2: goto L80;
            case 3: goto L64;
            case 4: goto L47;
            case 5: goto L31;
            case 6: goto L15;
            default: goto L13;
        };
    L13:
        com.obric.event.task.nlp.a.a.f32889a.d(r1, "parseDeviceCondition type error");
        return new com.obric.event.task.nlp.api.d(null, "device condition type error", ErrorCode.EventTask.DEVICE_CONDITION_TYPE_ERROR, null, 8, null);
    L15:
        Map<String, Object> r19 = r16.a();
        if (r19 == null) goto L18;
        Object r110 = r19.get(com.obric.event.task.nlp.api.h.b());
    L20:
        if (ZeusTransformUtils.instanceOf(r110, com.obric.event.task.nlp.api.a.class) == false) goto L23;
        r4 = (com.obric.event.task.nlp.api.a) ZeusTransformUtils.preCheckCast(r110, com.obric.event.task.nlp.api.a.class, "com.obric.aiagent.plugin");
    L23:
        if (r4 != null) goto L26;
        com.obric.event.task.nlp.a.a.f32889a.d(r1, "parseDeviceCondition bluetooth info error = bluetooth params empty");
        return new com.obric.event.task.nlp.api.d(null, "bluetooth params empty", ErrorCode.EventTask.BLUETOOTH_PARAMS_EMPTY, null, 8, null);
    L26:
        com.obric.event.task.nlp.api.d<BluetoothCondition> r111 = com.obric.event.task.nlp.b.b.f32951a.a(r12, r4);
        if (r111.a() != null) goto L30;
        com.obric.event.task.nlp.a.a.f32889a.d(r1, "parseDeviceCondition bluetooth info error = " + r111.b());
        return new com.obric.event.task.nlp.api.d(null, r111.b(), r111.c(), null, 8, null);
    L30:
        Condition r112 = (Condition) ZeusTransformUtils.preCheckCast(r111.a(), Condition.class, "com.obric.aiagent.plugin");
    L63:
        Condition r9 = r112;
        com.obric.event.task.nlp.a.a.f32889a.b(r1, "parseDeviceCondition success");
        return new com.obric.event.task.nlp.api.d(r9, null, 0, null, 10, null);
    L18:
        r110 = null;
        goto L20
    L31:
        Map<String, Object> r113 = r16.a();
        if (r113 == null) goto L34;
        Object r114 = r113.get(com.obric.event.task.nlp.api.h.a());
    L36:
        if (ZeusTransformUtils.instanceOf(r114, com.obric.event.task.nlp.api.a.class) == false) goto L39;
        r5 = (com.obric.event.task.nlp.api.a) ZeusTransformUtils.preCheckCast(r114, com.obric.event.task.nlp.api.a.class, "com.obric.aiagent.plugin");
    L39:
        if (r5 != null) goto L42;
        com.obric.event.task.nlp.a.a.f32889a.d(r1, "parseDeviceCondition wifi info error = wifi params empty");
        return new com.obric.event.task.nlp.api.d(null, "wifi params empty", ErrorCode.EventTask.WIFI_PARAMS_EMPTY, null, 8, null);
    L42:
        com.obric.event.task.nlp.api.d<WifiCondition> r115 = m.f33011a.a(r12, r5);
        if (r115.a() != null) goto L46;
        com.obric.event.task.nlp.a.a.f32889a.d(r1, "parseDeviceCondition wifi info error = " + r115.b());
        return new com.obric.event.task.nlp.api.d(null, r115.b(), r115.c(), null, 8, null);
    L46:
        r112 = (Condition) ZeusTransformUtils.preCheckCast(r115.a(), Condition.class, "com.obric.aiagent.plugin");
        goto L63
    L34:
        r114 = null;
        goto L36
    L47:
        Map<String, Object> r116 = r16.a();
        if (r116 == null) goto L50;
        Object r117 = r116.get(com.obric.event.task.nlp.api.h.c());
    L52:
        if (ZeusTransformUtils.instanceOf(r117, com.obric.event.task.nlp.api.a.class) == false) goto L55;
        r6 = (com.obric.event.task.nlp.api.a) ZeusTransformUtils.preCheckCast(r117, com.obric.event.task.nlp.api.a.class, "com.obric.aiagent.plugin");
    L55:
        if (r6 != null) goto L58;
        com.obric.event.task.nlp.a.a.f32889a.d(r1, "parseDeviceCondition sms info error = sms params empty");
        return new com.obric.event.task.nlp.api.d(null, "sms params empty", ErrorCode.EventTask.SMS_PARAMS_EMPTY, null, 8, null);
    L58:
        com.obric.event.task.nlp.api.d<SmsCondition> r118 = i.f33003a.b(r12, r6);
        if (r118.a() != null) goto L62;
        com.obric.event.task.nlp.a.a.f32889a.d(r1, "parseDeviceCondition sms info error = " + r118.b());
        return new com.obric.event.task.nlp.api.d(null, r118.b(), r118.c(), null, 8, null);
    L62:
        r112 = (Condition) ZeusTransformUtils.preCheckCast(r118.a(), Condition.class, "com.obric.aiagent.plugin");
        goto L63
    L50:
        r117 = null;
        goto L52
    L64:
        Map<String, Object> r119 = r16.a();
        if (r119 == null) goto L67;
        Object r120 = r119.get(com.obric.event.task.nlp.api.h.d());
    L69:
        if (ZeusTransformUtils.instanceOf(r120, Integer.class) == false) goto L71;
        r7 = (Integer) ZeusTransformUtils.preCheckCast(r120, Integer.class, "com.obric.aiagent.plugin");
    L71:
        if (r7 != null) goto L73;
    L78:
        com.obric.event.task.nlp.a.a.f32889a.d(r1, "parseDeviceCondition storage params empty or illegal value");
        return new com.obric.event.task.nlp.api.d(null, "storage params empty or illegal value", ErrorCode.EventTask.STORAGE_LOW_TO_PARAMS_EMPTY, null, 8, null);
    L73:
        if (r7.intValue() < 0) goto L78;
        if (r7.intValue() > 100) goto L78;
        r112 = (Condition) ZeusTransformUtils.preCheckCast(j.f33004a.a(r7.intValue()), Condition.class, "com.obric.aiagent.plugin");
        goto L63
    L67:
        r120 = null;
        goto L69
    L80:
        Map<String, Object> r121 = r16.a();
        if (r121 == null) goto L83;
        Object r122 = r121.get(com.obric.event.task.nlp.api.h.d());
    L85:
        if (ZeusTransformUtils.instanceOf(r122, Integer.class) == false) goto L87;
        r8 = (Integer) ZeusTransformUtils.preCheckCast(r122, Integer.class, "com.obric.aiagent.plugin");
    L87:
        if (r8 != null) goto L89;
    L94:
        com.obric.event.task.nlp.a.a.f32889a.d(r1, "parseDeviceCondition battery disChargeTo params empty or illegal value");
        return new com.obric.event.task.nlp.api.d(null, "battery disChargeTo params empty or illegal value", ErrorCode.EventTask.BATTERY_DISCHARGED_TO_PARAMS_EMPTY, null, 8, null);
    L89:
        if (r8.intValue() < 0) goto L94;
        if (r8.intValue() > 100) goto L94;
        r112 = (Condition) ZeusTransformUtils.preCheckCast(com.obric.event.task.nlp.b.a.f32950a.b(r8.intValue()), Condition.class, "com.obric.aiagent.plugin");
        goto L63
    L83:
        r122 = null;
        goto L85
    L96:
        Map<String, Object> r123 = r16.a();
        if (r123 == null) goto L99;
        Object r124 = r123.get(com.obric.event.task.nlp.api.h.d());
    L101:
        if (ZeusTransformUtils.instanceOf(r124, Integer.class) == false) goto L103;
        r3 = (Integer) ZeusTransformUtils.preCheckCast(r124, Integer.class, "com.obric.aiagent.plugin");
    L103:
        if (r3 != null) goto L105;
    L112:
        com.obric.event.task.nlp.a.a.f32889a.d(r1, "parseDeviceCondition battery chargedTo params empty or illegal value");
        return new com.obric.event.task.nlp.api.d(null, "battery chargedTo params empty or illegal value", ErrorCode.EventTask.BATTERY_CHARGED_TO_PARAMS_EMPTY, null, 8, null);
    L105:
        if (r3.intValue() < 0) goto L112;
        if (r3.intValue() > 100) goto L112;
        r112 = (Condition) ZeusTransformUtils.preCheckCast(com.obric.event.task.nlp.b.a.f32950a.a(r3.intValue()), Condition.class, "com.obric.aiagent.plugin");
        goto L63
    L99:
        r124 = null;
        goto L101
    L10:
        r18 = a.f32992a[r17.ordinal()];
        goto L11
    }

    private final com.obric.event.task.nlp.api.d<TriggerControlPolicy> a(q r16) {
        com.obric.event.task.nlp.a.a.f32889a.b(TAG, "parseTriggerControlPolicy");
        if (r16 == null) goto L5;
        Boolean r1 = r16.a();
        Long r2 = r16.b();
        if (r2 == null) goto L9;
        long r3 = r2.longValue();
    L11:
        return new com.obric.event.task.nlp.api.d(new TriggerControlPolicy(r1, Long.valueOf(r3)), null, 0, null, 10, null);
    L9:
        r3 = 600000;
        goto L11
    L5:
        return new com.obric.event.task.nlp.api.d(new TriggerControlPolicy(null, null, 3, null), null, 0, null, 10, null);
    }

    private final com.obric.event.task.nlp.api.d<PeriodicPolicy> a(com.obric.event.task.nlp.api.l r22, List<String> r23, String r24, String r25) {
        com.obric.event.task.nlp.api.l r0 = r22;
        List<String> r3 = (List) ZeusTransformUtils.wrapperContextForParams(r23, List.class, "com.obric.aiagent.plugin");
        com.obric.event.task.nlp.a.a r5 = com.obric.event.task.nlp.a.a.f32889a;
        String r6 = TAG;
        r5.b(r6, "parsePeriodicPolicy repeatType = " + r0);
        if (r0 != null) goto L5;
        r0 = com.obric.event.task.nlp.api.l.f32931b;
        com.obric.event.task.nlp.a.a.f32889a.b(r6, "parsePeriodicPolicy repeatType empty use default");
    L5:
        String r7 = null;
        if (r25 == null) goto L8;
        String r2 = l.f33006a.c(r25);
    L9:
        if (r24 == null) goto L11;
        r7 = l.f33006a.c(r24);
    L11:
        CharSequence r1 = (CharSequence) ZeusTransformUtils.preCheckCast(r7, CharSequence.class, "com.obric.aiagent.plugin");
        boolean r8 = false;
        if (r1 != null) goto L14;
    L17:
        boolean r4 = true;
    L18:
        if (r4 == false) goto L20;
        String r9 = l.f33006a.c();
    L21:
        com.obric.event.task.nlp.a.a.f32889a.b(r6, "parsePeriodicPolicy repeatType = " + r0 + ", repeatValues = " + r3 + ", startDate = " + r9 + ", expireDate = " + r2);
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r9, CharSequence.class, "com.obric.aiagent.plugin")).length() <= 0) goto L24;
        boolean r10 = true;
    L26:
        if (r10 == false) goto L41;
        CharSequence r11 = (CharSequence) ZeusTransformUtils.preCheckCast(r2, CharSequence.class, "com.obric.aiagent.plugin");
        if (r11 != null) goto L30;
    L33:
        boolean r12 = true;
    L34:
        if (r12 == true) goto L41;
        Integer r13 = l.f33006a.a(r9, r2);
        if (r13 != null) goto L38;
    L39:
        com.obric.event.task.nlp.a.a.f32889a.d(r6, "parsePeriodicPolicy start date is later than end date, invalid.");
        return new com.obric.event.task.nlp.api.d(null, "start date is later than end date, invalid.", ErrorCode.EventTask.START_TIME_OR_END_TIME_ERROR, null, 8, null);
    L38:
        if (r13.intValue() != 1) goto L41;
    L30:
        if (r11.length() == 0) goto L33;
        r12 = false;
    L41:
        if (r0 != null) goto L43;
        int r14 = -1;
    L44:
        switch(r14) {
            case 1: goto L67;
            case 2: goto L74;
            case 3: goto L73;
            case 4: goto L72;
            case 5: goto L58;
            case 6: goto L53;
            case 7: goto L46;
            default: goto L45;
        };
    L45:
        com.obric.event.task.nlp.a.a.f32889a.d(r6, "parsePeriodicPolicy periodicPolicy repeat type error");
        return new com.obric.event.task.nlp.api.d(null, "periodicPolicy repeat type error", ErrorCode.EventTask.REPEATTYPE_ERROR, null, 8, null);
    L46:
        String r15 = l.f33006a.c(r3);
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r15, CharSequence.class, "com.obric.aiagent.plugin")).length() != 0) goto L49;
        r8 = true;
    L49:
        if (r8 == false) goto L69;
        com.obric.event.task.nlp.a.a.f32889a.b(r6, "parsePeriodicPolicy periodicPolicy yearly values error");
        return new com.obric.event.task.nlp.api.d(null, "periodicPolicy yearly values error", ErrorCode.EventTask.REPEATTYPE_YEARLY_PARAMS_ERROR, null, 8, null);
    L69:
        return new com.obric.event.task.nlp.api.d(new PeriodicPolicy(false, null, 0, r15, false, false, r2, false, r9, 183, null), null, 0, null, 10, null);
    L53:
        int r16 = l.f33006a.b(r3);
        if (r16 >= 0) goto L70;
        com.obric.event.task.nlp.a.a.f32889a.b(r6, "parsePeriodicPolicy periodicPolicy monthly values error");
        return new com.obric.event.task.nlp.api.d(null, "periodicPolicy monthly values error", ErrorCode.EventTask.REPEATTYPE_MONTHLY_PARAMS_ERROR, null, 8, null);
    L70:
        return new com.obric.event.task.nlp.api.d(new PeriodicPolicy(false, null, r16, null, false, false, r2, false, r9, 187, null), null, 0, null, 10, null);
    L58:
        List<Integer> r17 = l.f33006a.a(r3);
        if (r17.isEmpty() == false) goto L71;
        com.obric.event.task.nlp.a.a.f32889a.b(r6, "parsePeriodicPolicy periodicPolicy weekly values error");
        return new com.obric.event.task.nlp.api.d(null, "periodicPolicy weekly values error", ErrorCode.EventTask.REPEATTYPE_WEEKLY_PARAMS_ERROR, null, 8, null);
    L71:
        return new com.obric.event.task.nlp.api.d(new PeriodicPolicy(false, p.e((Collection) ZeusTransformUtils.preCheckCast(r17, Collection.class, "com.obric.aiagent.plugin")), 0, null, false, false, r2, false, r9, 189, null), null, 0, null, 10, null);
    L72:
        return new com.obric.event.task.nlp.api.d(new PeriodicPolicy(false, null, 0, null, true, false, r2, false, r9, 175, null), null, 0, null, 10, null);
    L73:
        return new com.obric.event.task.nlp.api.d(new PeriodicPolicy(false, null, 0, null, false, true, r2, false, r9, 159, null), null, 0, null, 10, null);
    L74:
        return new com.obric.event.task.nlp.api.d(new PeriodicPolicy(true, null, 0, null, false, false, r2, false, r9, 190, null), null, 0, null, 10, null);
    L67:
        return new com.obric.event.task.nlp.api.d(new PeriodicPolicy(false, null, 0, null, false, false, r2, true, r9, 63, null), null, 0, null, 10, null);
    L43:
        r14 = a.f32993b[r0.ordinal()];
        goto L44
    L24:
        r10 = false;
        goto L26
    L20:
        r9 = r7;
        goto L21
    L14:
        if (r1.length() == 0) goto L17;
        r4 = false;
        goto L18
    L8:
        r2 = null;
        goto L9
    }
}
