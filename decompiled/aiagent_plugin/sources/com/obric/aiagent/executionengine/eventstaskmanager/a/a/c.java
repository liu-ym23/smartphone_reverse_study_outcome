package com.obric.aiagent.executionengine.eventstaskmanager.a.a;

import android.util.Log;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.obric.eventkit.task.api.IEventTaskApi;
import com.obric.eventkit.task.model.ConditionTask;
import com.obric.eventkit.task.model.ConditionTaskSpec;
import com.obric.eventkit.task.model.EventTask;
import com.obric.eventkit.task.model.EventTaskResult;
import com.obric.eventkit.task.model.EventTaskSpec;
import com.obric.eventkit.task.model.ShortcutTask;
import com.obric.eventkit.task.model.ShortcutTaskSpec;
import com.obric.eventkit.task.model.TaskKnowledge;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.ao;
import d.a.p;
import d.c.b.a.l;
import d.g;
import d.h.a.m;
import d.h.b.h;
import d.o;
import d.s;
import d.x;
import java.util.List;
import java.util.Map;
import kotlinx.coroutines.am;
import kotlinx.coroutines.bd;
import kotlinx.coroutines.i;

/* JADX INFO: compiled from: KnowledgeRepository.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f16641a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final com.obric.aiagent.executionengine.eventstaskmanager.a.a.d f16642b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final com.obric.aiagent.executionengine.eventstaskmanager.a.a.a f16643c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final d.f f16644d;

    /* JADX INFO: compiled from: KnowledgeRepository.kt */
    public static final class a {
        public /* synthetic */ a(h r1) {
            this();
        }

        private a() {
        }
    }

    /* JADX INFO: compiled from: KnowledgeRepository.kt */
    @d.c.b.a.f(b = "KnowledgeRepository.kt", c = {181}, d = "invokeSuspend", e = "com.obric.aiagent.executionengine.eventstaskmanager.knowledge.datasource.KnowledgeRepository$getKnowledge$2")
    static final class b extends l implements m<am, d.c.d<? super String>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f16645a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f16646b;

        b(String r3, d.c.d<? super b> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f16646b = r3;
            super(2, r5);
        }

        public final Object a(am r3, d.c.d<? super String> r4) {
            return ((b) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), b.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r2, d.c.d<?> r3) {
            d.c.d r4 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new b(this.f16646b, r4), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super String> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r6) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f16645a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            o.a(r6);
        L13:
            EventTask r5 = (EventTask) ZeusTransformUtils.preCheckCast(r6, EventTask.class, "com.obric.aiagent.plugin");
            if (r5 == null) goto L18;
            TaskKnowledge r7 = r5.getTaskKnowledge();
            if (r7 == null) goto L18;
            return r7.getContent();
        L18:
            return null;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            o.a(r6);
            IEventTaskApi r8 = (IEventTaskApi) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IEventTaskApi.class), IEventTaskApi.class, "com.obric.aiagent.plugin");
            if (r8 == null) goto L18;
            String r2 = this.f16646b;
            d.c.d<? super EventTask> r4 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f16645a = 1;
            r6 = r8.getEventTask(r2, r4);
            if (r6 != r0) goto L13;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.obric.aiagent.executionengine.eventstaskmanager.a.a.c$c, reason: collision with other inner class name */
    /* JADX INFO: compiled from: KnowledgeRepository.kt */
    @d.c.b.a.f(b = "KnowledgeRepository.kt", c = {243}, d = "getKnowledgeForNet", e = "com.obric.aiagent.executionengine.eventstaskmanager.knowledge.datasource.KnowledgeRepository")
    static final class C0339c extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f16647a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        /* synthetic */ Object f16648b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ c f16649c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        int f16650d;

        C0339c(c r3, d.c.d<? super C0339c> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f16649c = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f16648b = r3;
            this.f16650d |= Integer.MIN_VALUE;
            return this.f16649c.a(null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: KnowledgeRepository.kt */
    @d.c.b.a.f(b = "KnowledgeRepository.kt", c = {185}, d = "invokeSuspend", e = "com.obric.aiagent.executionengine.eventstaskmanager.knowledge.datasource.KnowledgeRepository$getTaskKnowledge$2")
    static final class d extends l implements m<am, d.c.d<? super TaskKnowledge>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f16651a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f16652b;

        d(String r3, d.c.d<? super d> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f16652b = r3;
            super(2, r5);
        }

        public final Object a(am r3, d.c.d<? super TaskKnowledge> r4) {
            return ((d) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), d.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r2, d.c.d<?> r3) {
            d.c.d r4 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new d(this.f16652b, r4), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super TaskKnowledge> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r6) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f16651a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            o.a(r6);
        L13:
            EventTask r5 = (EventTask) ZeusTransformUtils.preCheckCast(r6, EventTask.class, "com.obric.aiagent.plugin");
            if (r5 != null) goto L18;
        L16:
            return null;
        L18:
            return r5.getTaskKnowledge();
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            o.a(r6);
            IEventTaskApi r7 = (IEventTaskApi) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IEventTaskApi.class), IEventTaskApi.class, "com.obric.aiagent.plugin");
            if (r7 == null) goto L16;
            String r2 = this.f16652b;
            d.c.d<? super EventTask> r4 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f16651a = 1;
            r6 = r7.getEventTask(r2, r4);
            if (r6 != r0) goto L13;
            return r0;
        }
    }

    /* JADX INFO: compiled from: KnowledgeRepository.kt */
    @d.c.b.a.f(b = "KnowledgeRepository.kt", c = {116, 155}, d = "invokeSuspend", e = "com.obric.aiagent.executionengine.eventstaskmanager.knowledge.datasource.KnowledgeRepository$setKnowledge$2")
    static final class e extends l implements m<am, d.c.d<? super com.obric.aiagent.executionengine.eventstaskmanager.a.a.f>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f16653a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f16654b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f16655c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f16656d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f16657e;
        final /* synthetic */ String f;
        final /* synthetic */ Integer g;
        final /* synthetic */ boolean h;
        final /* synthetic */ boolean i;
        final /* synthetic */ c j;
        final /* synthetic */ String k;
        private /* synthetic */ Object l;

        e(String r3, int r4, String r5, String r6, Integer r7, boolean r8, boolean r9, c r10, String r11, d.c.d<? super e> r12) {
            d.c.d r13 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r12, d.c.d.class, "com.obric.aiagent.plugin");
            this.f16655c = r3;
            this.f16656d = r4;
            this.f16657e = r5;
            this.f = r6;
            this.g = r7;
            this.h = r8;
            this.i = r9;
            this.j = r10;
            this.k = r11;
            super(2, r13);
        }

        public final Object a(am r3, d.c.d<? super com.obric.aiagent.executionengine.eventstaskmanager.a.a.f> r4) {
            return ((e) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), e.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r14, d.c.d<?> r15) {
            d.c.d r12 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r15, d.c.d.class, "com.obric.aiagent.plugin");
            e r16 = new e(this.f16655c, this.f16656d, this.f16657e, this.f, this.g, this.h, this.i, this.j, this.k, r12);
            r16.l = r14;
            return (d.c.d) ZeusTransformUtils.preCheckCast(r16, d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super com.obric.aiagent.executionengine.eventstaskmanager.a.a.f> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r28) {
            Object r1 = d.c.a.b.a();
            int r2 = this.f16654b;
            boolean r5 = false;
            EventTask r6 = null;
            if (r2 == 0) goto L10;
            if (r2 == 1) goto L9;
            if (r2 != 2) goto L8;
            o.a(r28);
            Object r0 = r28;
        L77:
            EventTaskResult r3 = (EventTaskResult) ZeusTransformUtils.preCheckCast(r0, EventTaskResult.class, "com.obric.aiagent.plugin");
        L79:
            if (r3 != null) goto L81;
        L83:
            if (r5 == false) goto L94;
            List<EventTask> r4 = r3.getData();
            if (r4 == null) goto L88;
            r6 = (EventTask) ZeusTransformUtils.preCheckCast(p.l(r4), EventTask.class, "com.obric.aiagent.plugin");
        L88:
            if (ZeusTransformUtils.instanceOf(r6, ConditionTask.class) == false) goto L91;
            com.obric.event.task.base.report.o.a(com.obric.event.task.base.report.o.f32870a, (ConditionTask) ZeusTransformUtils.preCheckCast(r6, ConditionTask.class, "com.obric.aiagent.plugin"), "update", "gui", null, null, 24, null);
        L101:
            return com.obric.aiagent.executionengine.eventstaskmanager.a.a.f.f16667a.a();
        L91:
            if (ZeusTransformUtils.instanceOf(r6, ShortcutTask.class) == false) goto L101;
            com.obric.event.task.base.report.o.a(com.obric.event.task.base.report.o.f32870a, (ShortcutTask) ZeusTransformUtils.preCheckCast(r6, ShortcutTask.class, "com.obric.aiagent.plugin"), "update", "gui", null, null, 24, null);
            goto L101
        L94:
            com.obric.aiagent.executionengine.eventstaskmanager.a.a.f.a r7 = com.obric.aiagent.executionengine.eventstaskmanager.a.a.f.f16667a;
            if (r3 == null) goto L98;
            String r8 = r3.getMsg();
            if (r8 == null) goto L98;
        L100:
            return r7.a(r8);
        L98:
            r8 = "updateEventTask failed";
            goto L100
        L81:
            if (r3.getCode() != 0) goto L83;
            r5 = true;
            goto L83
        L8:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L9:
            int r9 = this.f16653a;
            IEventTaskApi r10 = (IEventTaskApi) ZeusTransformUtils.preCheckCast(this.l, IEventTaskApi.class, "com.obric.aiagent.plugin");
            o.a(r28);
            Object r11 = r28;
        L35:
            EventTask r12 = (EventTask) ZeusTransformUtils.preCheckCast(r11, EventTask.class, "com.obric.aiagent.plugin");
            if (r12 == null) goto L38;
            TaskKnowledge r13 = r12.getTaskKnowledge();
            int r14 = r9;
        L39:
            if (r13 == null) goto L41;
            boolean r15 = r13.getLearningSwitch();
        L42:
            com.obric.aiagent.executionengine.eventstaskmanager.b.a r16 = com.obric.aiagent.executionengine.eventstaskmanager.b.a.f16675a;
            StringBuilder r17 = new StringBuilder().append("setKnowledge: preserve learningSwitch=").append(r15).append(" (from current=");
            if (r13 == null) goto L45;
            Boolean r18 = d.c.b.a.b.a(r13.getLearningSwitch());
        L46:
            StringBuilder r19 = r17.append(r18).append(", currentKnowledgeNull=");
            if (r13 != null) goto L49;
            boolean r110 = true;
        L50:
            r16.b("KnowledgeRepository", r19.append(r110).append("), taskId=").append(this.f16655c).toString());
            if (this.i == false) goto L54;
            String r20 = this.k;
        L53:
            String r111 = r20;
        L57:
            int r21 = this.f16656d;
            if (r21 == 2) goto L69;
            if (r21 == 3) goto L64;
            com.obric.aiagent.executionengine.eventstaskmanager.b.a.f16675a.d("KnowledgeRepository", "setKnowledge unknown task type: " + this.f16656d);
            return com.obric.aiagent.executionengine.eventstaskmanager.a.a.f.f16667a.a("unknown task type: " + this.f16656d);
        L64:
            if (((CharSequence) ZeusTransformUtils.preCheckCast(this.f, CharSequence.class, "com.obric.aiagent.plugin")).length() <= 0) goto L66;
            boolean r112 = true;
        L67:
            EventTaskSpec r22 = (EventTaskSpec) ZeusTransformUtils.preCheckCast(new ShortcutTaskSpec(null, null, new TaskKnowledge(r112, this.f16657e, this.f, r14, r15, r111), null, null, null, null, null, null, null, null, 2042, null), EventTaskSpec.class, "com.obric.aiagent.plugin");
        L73:
            if (r10 == null) goto L78;
            String r23 = this.f16655c;
            d.c.d<? super EventTaskResult> r113 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.l = null;
            this.f16654b = 2;
            r0 = r10.updateEventTask(r23, r22, r113);
            if (r0 != r1) goto L77;
            return r1;
        L78:
            r3 = null;
            goto L79
        L66:
            r112 = false;
            goto L67
        L69:
            if (((CharSequence) ZeusTransformUtils.preCheckCast(this.f, CharSequence.class, "com.obric.aiagent.plugin")).length() <= 0) goto L71;
            boolean r114 = true;
        L72:
            r22 = (EventTaskSpec) ZeusTransformUtils.preCheckCast(new ConditionTaskSpec(null, null, new TaskKnowledge(r114, this.f16657e, this.f, r14, r15, r111), null, null, null, null, null, null, null, null, null, 4090, null), EventTaskSpec.class, "com.obric.aiagent.plugin");
            goto L73
        L71:
            r114 = false;
            goto L72
        L54:
            if (r13 == null) goto L56;
            r20 = r13.getEvolutionInfo();
            goto L53
        L56:
            r111 = null;
            goto L57
        L49:
            r110 = false;
            goto L50
        L45:
            r18 = null;
            goto L46
        L41:
            r15 = true;
        L38:
            r14 = r9;
            r13 = null;
            goto L39
        L10:
            o.a(r28);
            am r24 = (am) ZeusTransformUtils.preCheckCast(this.l, am.class, "com.obric.aiagent.plugin");
            com.obric.aiagent.executionengine.eventstaskmanager.b.a.f16675a.b("KnowledgeRepository", "setKnowledge, taskId: " + this.f16655c + ", taskType: " + this.f16656d + ", sessionId: " + this.f16657e + ", knowledge: " + this.f + ", count: " + this.g + ", needSecurityCheck: " + this.h + ", updateEvolutionInfo: " + this.i);
            if (this.h == false) goto L20;
            com.obric.aiagent.executionengine.eventstaskmanager.a.a.d r25 = c.a(this.j);
            if (r25 != null) goto L15;
            com.obric.aiagent.executionengine.eventstaskmanager.b.a.f16675a.d("KnowledgeRepository", "setKnowledge failed, securityChecker is null");
            return com.obric.aiagent.executionengine.eventstaskmanager.a.a.f.f16667a.a("security checker is null");
        L15:
            if (r25.a(this.f) == true) goto L20;
            return com.obric.aiagent.executionengine.eventstaskmanager.a.a.f.f16667a.a("sensitive_words_check_fail");
        L20:
            Integer r26 = this.g;
            if (r26 == null) goto L24;
            r9 = r26.intValue();
        L30:
            r10 = (IEventTaskApi) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IEventTaskApi.class), IEventTaskApi.class, "com.obric.aiagent.plugin");
            if (r10 == null) goto L38;
            String r115 = this.f16655c;
            d.c.d<? super EventTask> r116 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.l = r10;
            this.f16653a = r9;
            this.f16654b = 1;
            r11 = r10.getEventTask(r115, r116);
            if (r11 != r1) goto L35;
            return r1;
        L24:
            if (((CharSequence) ZeusTransformUtils.preCheckCast(this.f, CharSequence.class, "com.obric.aiagent.plugin")).length() != 0) goto L26;
            boolean r27 = true;
        L27:
            if (r27 == false) goto L29;
            r9 = -2;
            goto L30
        L29:
            r9 = 2;
            goto L30
        L26:
            r27 = false;
            goto L27
        }
    }

    /* JADX INFO: compiled from: KnowledgeRepository.kt */
    @d.c.b.a.f(b = "KnowledgeRepository.kt", c = {199, 216}, d = "invokeSuspend", e = "com.obric.aiagent.executionengine.eventstaskmanager.knowledge.datasource.KnowledgeRepository$setLearningSwitch$2")
    static final class f extends l implements m<am, d.c.d<? super com.obric.aiagent.executionengine.eventstaskmanager.a.a.f>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f16658a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f16659b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f16660c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f16661d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ boolean f16662e;

        f(String r3, int r4, boolean r5, d.c.d<? super f> r6) {
            d.c.d r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin");
            this.f16660c = r3;
            this.f16661d = r4;
            this.f16662e = r5;
            super(2, r7);
        }

        public final Object a(am r3, d.c.d<? super com.obric.aiagent.executionengine.eventstaskmanager.a.a.f> r4) {
            return ((f) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), f.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r4, d.c.d<?> r5) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new f(this.f16660c, this.f16661d, this.f16662e, r6), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super com.obric.aiagent.executionengine.eventstaskmanager.a.a.f> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r35) {
            Object r1 = d.c.a.b.a();
            int r2 = this.f16659b;
            boolean r5 = true;
            String r8 = null;
            if (r2 == 0) goto L10;
            if (r2 == 1) goto L9;
            if (r2 != 2) goto L8;
            o.a(r35);
            Object r3 = r35;
        L46:
            EventTaskResult r4 = (EventTaskResult) ZeusTransformUtils.preCheckCast(r3, EventTaskResult.class, "com.obric.aiagent.plugin");
        L48:
            if (r4 != null) goto L50;
        L52:
            r5 = false;
        L53:
            if (r5 == false) goto L55;
            com.obric.aiagent.executionengine.eventstaskmanager.b.a.f16675a.b("KnowledgeRepository", "setLearningSwitch success, taskId: " + this.f16660c + ", enabled: " + this.f16662e);
            return com.obric.aiagent.executionengine.eventstaskmanager.a.a.f.f16667a.a();
        L55:
            com.obric.aiagent.executionengine.eventstaskmanager.b.a r6 = com.obric.aiagent.executionengine.eventstaskmanager.b.a.f16675a;
            StringBuilder r0 = new StringBuilder().append("setLearningSwitch failed, taskId: ").append(this.f16660c).append(", enabled: ").append(this.f16662e).append(", msg: ");
            if (r4 == null) goto L58;
            r8 = r4.getMsg();
        L58:
            r6.d("KnowledgeRepository", r0.append(r8).toString());
            com.obric.aiagent.executionengine.eventstaskmanager.a.a.f.a r7 = com.obric.aiagent.executionengine.eventstaskmanager.a.a.f.f16667a;
            if (r4 == null) goto L62;
            String r9 = r4.getMsg();
            if (r9 == null) goto L62;
        L64:
            return r7.a(r9);
        L62:
            r9 = "updateEventTask failed";
            goto L64
        L50:
            if (r4.getCode() != 0) goto L52;
        L8:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L9:
            IEventTaskApi r10 = (IEventTaskApi) ZeusTransformUtils.preCheckCast(this.f16658a, IEventTaskApi.class, "com.obric.aiagent.plugin");
            o.a(r35);
            Object r11 = r35;
        L15:
            EventTask r12 = (EventTask) ZeusTransformUtils.preCheckCast(r11, EventTask.class, "com.obric.aiagent.plugin");
            if (r12 == null) goto L18;
            TaskKnowledge r13 = r12.getTaskKnowledge();
        L19:
            if (r13 == null) goto L21;
            String r14 = r13.getSessionId();
        L22:
            if (r13 == null) goto L24;
            String r15 = r13.getContent();
        L25:
            if (r13 == null) goto L27;
            boolean r16 = r13.isEnable();
        L28:
            if (r13 == null) goto L30;
            int r17 = r13.getClarifyCount();
        L31:
            if (r13 == null) goto L33;
            String r18 = r13.getEvolutionInfo();
        L34:
            TaskKnowledge r22 = new TaskKnowledge(r16, r14, r15, r17, this.f16662e, r18);
            int r19 = this.f16661d;
            if (r19 != 2) goto L37;
            EventTaskSpec r110 = (EventTaskSpec) ZeusTransformUtils.preCheckCast(new ConditionTaskSpec(null, null, r22, null, null, null, null, null, null, null, null, null, 4090, null), EventTaskSpec.class, "com.obric.aiagent.plugin");
        L42:
            if (r10 == null) goto L47;
            String r111 = this.f16660c;
            d.c.d<? super EventTaskResult> r112 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f16658a = null;
            this.f16659b = 2;
            r3 = r10.updateEventTask(r111, r110, r112);
            if (r3 != r1) goto L46;
            return r1;
        L47:
            r4 = null;
            goto L48
        L37:
            if (r19 == 3) goto L40;
            com.obric.aiagent.executionengine.eventstaskmanager.b.a.f16675a.d("KnowledgeRepository", "setLearningSwitch unknown task type: " + this.f16661d);
            return com.obric.aiagent.executionengine.eventstaskmanager.a.a.f.f16667a.a("unknown task type: " + this.f16661d);
        L40:
            r110 = (EventTaskSpec) ZeusTransformUtils.preCheckCast(new ShortcutTaskSpec(null, null, r22, null, null, null, null, null, null, null, null, 2042, null), EventTaskSpec.class, "com.obric.aiagent.plugin");
            goto L42
        L33:
            r18 = null;
            goto L34
        L30:
            r17 = 0;
            goto L31
        L27:
            r16 = false;
            goto L28
        L24:
            r15 = null;
            goto L25
        L21:
            r14 = null;
        L18:
            r13 = null;
            goto L19
        L10:
            o.a(r35);
            com.obric.aiagent.executionengine.eventstaskmanager.b.a.f16675a.b("KnowledgeRepository", "setLearningSwitch, taskId: " + this.f16660c + ", taskType: " + this.f16661d + ", enabled: " + this.f16662e);
            r10 = (IEventTaskApi) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IEventTaskApi.class), IEventTaskApi.class, "com.obric.aiagent.plugin");
            if (r10 == null) goto L18;
            String r113 = this.f16660c;
            d.c.d<? super EventTask> r114 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f16658a = r10;
            this.f16659b = 1;
            r11 = r10.getEventTask(r113, r114);
            if (r11 != r1) goto L15;
            return r1;
        }
    }

    static {
        f16641a = new a(null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public c() {
        Object[] r0 = 0 == true ? 1 : 0;
        this(null, r0, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ Gson lambda$B31iYv1PFO4lAUOHRoYxxrZYNlo() {
        return b();
    }

    public c(com.obric.aiagent.executionengine.eventstaskmanager.a.a.d r3, com.obric.aiagent.executionengine.eventstaskmanager.a.a.a r4) {
        com.obric.aiagent.executionengine.eventstaskmanager.a.a.d r5 = (com.obric.aiagent.executionengine.eventstaskmanager.a.a.d) ZeusTransformUtils.wrapperContextForParams(r3, com.obric.aiagent.executionengine.eventstaskmanager.a.a.d.class, "com.obric.aiagent.plugin");
        com.obric.aiagent.executionengine.eventstaskmanager.a.a.a r6 = (com.obric.aiagent.executionengine.eventstaskmanager.a.a.a) ZeusTransformUtils.wrapperContextForParams(r4, com.obric.aiagent.executionengine.eventstaskmanager.a.a.a.class, "com.obric.aiagent.plugin");
        this.f16642b = r5;
        this.f16643c = r6;
        this.f16644d = g.a($$Lambda$c$B31iYv1PFO4lAUOHRoYxxrZYNlo.INSTANCE);
    }

    public /* synthetic */ c(com.obric.aiagent.executionengine.eventstaskmanager.a.a.d r2, com.obric.aiagent.executionengine.eventstaskmanager.a.a.a r3, int r4, h r5) {
        com.obric.aiagent.executionengine.eventstaskmanager.a.a.d r6 = (com.obric.aiagent.executionengine.eventstaskmanager.a.a.d) ZeusTransformUtils.wrapperContextForParams(r2, com.obric.aiagent.executionengine.eventstaskmanager.a.a.d.class, "com.obric.aiagent.plugin");
        com.obric.aiagent.executionengine.eventstaskmanager.a.a.a r7 = (com.obric.aiagent.executionengine.eventstaskmanager.a.a.a) ZeusTransformUtils.wrapperContextForParams(r3, com.obric.aiagent.executionengine.eventstaskmanager.a.a.a.class, "com.obric.aiagent.plugin");
        if ((r4 & 1) == 0) goto L6;
        r6 = null;
    L6:
        if ((r4 & 2) == 0) goto L8;
        r7 = null;
    L8:
        this(r6, r7);
    }

    public static final /* synthetic */ com.obric.aiagent.executionengine.eventstaskmanager.a.a.d a(c r0) {
        return r0.f16642b;
    }

    private final Gson a() {
        return (Gson) ZeusTransformUtils.preCheckCast(this.f16644d.b(), Gson.class, "com.obric.aiagent.plugin");
    }

    private static final Gson b() {
        return new GsonBuilder().create();
    }

    public Object a(String r16, int r17, String r18, String r19, Integer r20, boolean r21, String r22, boolean r23, d.c.d<? super com.obric.aiagent.executionengine.eventstaskmanager.a.a.f> r24) {
        d.c.d r0 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r24, d.c.d.class, "com.obric.aiagent.plugin");
        return i.a((d.c.g) ZeusTransformUtils.preCheckCast(bd.c(), d.c.g.class, "com.obric.aiagent.plugin"), (m) ZeusTransformUtils.preCheckCast(new e(r16, r17, r18, r19, r20, r21, r23, this, r22, null), m.class, "com.obric.aiagent.plugin"), r0);
    }

    public Object a(String r4, d.c.d<? super String> r5) {
        d.c.d r3 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
        return i.a((d.c.g) ZeusTransformUtils.preCheckCast(bd.c(), d.c.g.class, "com.obric.aiagent.plugin"), (m) ZeusTransformUtils.preCheckCast(new b(r4, null), m.class, "com.obric.aiagent.plugin"), r3);
    }

    public Object b(String r4, d.c.d<? super TaskKnowledge> r5) {
        d.c.d r3 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
        return i.a((d.c.g) ZeusTransformUtils.preCheckCast(bd.c(), d.c.g.class, "com.obric.aiagent.plugin"), (m) ZeusTransformUtils.preCheckCast(new d(r4, null), m.class, "com.obric.aiagent.plugin"), r3);
    }

    public Object a(String r4, int r5, boolean r6, d.c.d<? super com.obric.aiagent.executionengine.eventstaskmanager.a.a.f> r7) {
        d.c.d r3 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r7, d.c.d.class, "com.obric.aiagent.plugin");
        return i.a((d.c.g) ZeusTransformUtils.preCheckCast(bd.c(), d.c.g.class, "com.obric.aiagent.plugin"), (m) ZeusTransformUtils.preCheckCast(new f(r4, r5, r6, null), m.class, "com.obric.aiagent.plugin"), r3);
    }

    public Object a(List<String> r12, d.c.d<? super com.obric.aiagent.executionengine.eventstaskmanager.a.a.e<com.obric.aiagent.executionengine.eventstaskmanager.a.a.a.c>> r13) {
        List r14 = (List) ZeusTransformUtils.wrapperContextForParams(r12, List.class, "com.obric.aiagent.plugin");
        d.c.d r15 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r13, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r15, C0339c.class) == false) goto L7;
        C0339c r2 = (C0339c) ZeusTransformUtils.preCheckCast(r15, C0339c.class, "com.obric.aiagent.plugin");
        if ((r2.f16650d & Integer.MIN_VALUE) == 0) goto L7;
        r2.f16650d -= Integer.MIN_VALUE;
    L8:
        C0339c r9 = r2;
        Object r16 = r9.f16648b;
        Object r3 = d.c.a.b.a();
        int r4 = r9.f16650d;
        if (r4 == 0) goto L18;
        if (r4 != 1) goto L17;
        c this = (c) ZeusTransformUtils.preCheckCast(r9.f16647a, c.class, "com.obric.aiagent.plugin");
        o.a(r16);     // Catch: Throwable -> L14
    L26:
        com.obric.aiagent.executionengine.eventstaskmanager.a.a.b r17 = (com.obric.aiagent.executionengine.eventstaskmanager.a.a.b) ZeusTransformUtils.preCheckCast(r16, com.obric.aiagent.executionengine.eventstaskmanager.a.a.b.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L14
        if (r17.a() == true) goto L30;
        com.obric.aiagent.executionengine.eventstaskmanager.b.a.f16675a.d("KnowledgeRepository", "getKnowledgeForNet, request failed:");     // Catch: Throwable -> L14
        return com.obric.aiagent.executionengine.eventstaskmanager.a.a.e.f16663a.a("getKnowledgeForNet, request failed:");
    L30:
        JsonObject r18 = (JsonObject) ZeusTransformUtils.preCheckCast(this.a().fromJson(r17.b(), JsonObject.class), JsonObject.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L14
        int r19 = r18.get(MonitorConstants.CODE).getAsInt();     // Catch: Throwable -> L14
        String r1 = r18.get("msg").getAsString();     // Catch: Throwable -> L14
        String r5 = r18.get("log_id").getAsString();     // Catch: Throwable -> L14
        if (r19 == 0) goto L39;
        com.obric.aiagent.executionengine.eventstaskmanager.b.a.f16675a.d("KnowledgeRepository", "doCreateOrQueryTask failed, code: " + r19);     // Catch: Throwable -> L14
        return com.obric.aiagent.executionengine.eventstaskmanager.a.a.e.f16663a.a("doCreateOrQueryTask failed, code: " + r19 + ", message: " + r1 + ", logId: " + r5);
    L39:
        return com.obric.aiagent.executionengine.eventstaskmanager.a.a.e.f16663a.a((com.obric.aiagent.executionengine.eventstaskmanager.a.a.a.c) ZeusTransformUtils.preCheckCast(this.a().fromJson(r18.get("data"), com.obric.aiagent.executionengine.eventstaskmanager.a.a.a.c.class), com.obric.aiagent.executionengine.eventstaskmanager.a.a.a.c.class, "com.obric.aiagent.plugin"));
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        o.a(r16);
        com.obric.aiagent.executionengine.eventstaskmanager.a.a.a r6 = this.f16643c;
        if (r6 == null) goto L21;
        String r7 = a().toJson(new com.obric.aiagent.executionengine.eventstaskmanager.a.a.a.b(p.k((Iterable) ZeusTransformUtils.preCheckCast(r14, Iterable.class, "com.obric.aiagent.plugin"))));
        com.obric.aiagent.executionengine.eventstaskmanager.b.a.f16675a.a("KnowledgeRepository", "getKnowledgeForNet, requestBodyJson: " + r7);
        String r110 = com.obric.aiagent.product.a.a.f18769a.c() + "auto_action/api/task/knowledge";     // Catch: Throwable -> L14
        Map<String, String> r8 = ao.a(s.a("Content-type", "application/json"));     // Catch: Throwable -> L14
        d.h.b.o.a(r7);     // Catch: Throwable -> L14
        r9.f16647a = this;     // Catch: Throwable -> L14
        r9.f16650d = 1;     // Catch: Throwable -> L14
        r16 = r6.a(r110, r8, r7, 60000, r9);     // Catch: Throwable -> L14
        if (r16 != r3) goto L26;
        return r3;
    L21:
        return com.obric.aiagent.executionengine.eventstaskmanager.a.a.e.f16663a.a("network client is null");
    L14:
        th = move-exception;
        com.obric.aiagent.executionengine.eventstaskmanager.b.a.f16675a.d("KnowledgeRepository", "getKnowledgeForNet, request failed: " + Log.getStackTraceString(th));
        return com.obric.aiagent.executionengine.eventstaskmanager.a.a.e.f16663a.a("getKnowledgeForNet, request failed: " + th);
    L7:
        r2 = new C0339c(this, r15);
        goto L8
    }
}
