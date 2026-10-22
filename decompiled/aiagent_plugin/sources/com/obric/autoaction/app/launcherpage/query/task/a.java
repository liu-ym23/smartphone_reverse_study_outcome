package com.obric.autoaction.app.launcherpage.query.task;

import android.app.Application;
import android.content.Context;
import com.bytedance.security.zenmobile.io.SensitiveType;
import com.google.gson.Gson;
import com.obric.agent.IAgentService;
import com.obric.aiagent.assistant.idl.IFlowFindMessageCallbackIDL;
import com.obric.aiagent.assistant.idl.IFlowMessageIDL;
import com.obric.aiagent.assistant.idl.ak;
import com.obric.aiagent.assistant.idl.bean.AppIntentCardData;
import com.obric.aiagent.assistant.idl.bean.AppIntentMessage;
import com.obric.aiagent.assistant.idl.bean.DataSource;
import com.obric.aiagent.assistant.idl.bean.IMMessage;
import com.obric.aiagent.assistant.idl.bean.OAppIntentBizContentType;
import com.obric.aiagent.platform.depend.ILogDepend;
import com.obric.autoaction.app.launcherpage.condition.config.condition.AutoCondition;
import com.obric.autoaction.app.launcherpage.utils.m;
import com.obric.cae.libs.useraware.ApWakeEvent;
import com.obric.capabilitykit.apphost.AppHost;
import com.obric.capabilitykit.common.intent.IntentParams;
import com.obric.capabilitykit.common.intent.SystemAutoActionParams;
import com.obric.capabilitykit.entity.EntityExtKt;
import com.obric.capabilitykit.entity.app.AppEntity;
import com.obric.capabilitykit.entity.app.EventTaskEntity;
import com.obric.eventkit.task.api.IEventTaskApi;
import com.obric.eventkit.task.model.Condition;
import com.obric.eventkit.task.model.ConditionGroup;
import com.obric.eventkit.task.model.ConditionTask;
import com.obric.eventkit.task.model.ConditionTaskAction;
import com.obric.eventkit.task.model.EventTask;
import com.ss.android.socialbase.downloader.constants.DownloadConstants;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.p;
import d.h.b.aa;
import d.o;
import d.x;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlinx.coroutines.n;
import org.json.JSONObject;

/* JADX INFO: compiled from: EventTaskCardManager.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class a {
    private static final String TAG = "EventTaskCardManager";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f24297a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final ConcurrentHashMap<String, String> f24298b = null;

    /* JADX INFO: renamed from: com.obric.autoaction.app.launcherpage.query.task.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: EventTaskCardManager.kt */
    @d.c.b.a.f(b = "EventTaskCardManager.kt", c = {139, ApWakeEvent.OTHER_START}, d = "appendTaskExtForCard", e = "com.obric.autoaction.app.launcherpage.query.task.EventTaskCardManager")
    static final class C0556a extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f24299a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f24300b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Object f24301c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        /* synthetic */ Object f24302d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ a f24303e;
        int f;

        C0556a(a r3, d.c.d<? super C0556a> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f24303e = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f24302d = r3;
            this.f |= Integer.MIN_VALUE;
            return this.f24303e.a(null, null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: EventTaskCardManager.kt */
    @d.c.b.a.f(b = "EventTaskCardManager.kt", c = {122}, d = "findAndVerifyPreDataList", e = "com.obric.autoaction.app.launcherpage.query.task.EventTaskCardManager")
    static final class b extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f24304a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        /* synthetic */ Object f24305b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ a f24306c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        int f24307d;

        b(a r3, d.c.d<? super b> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f24306c = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f24305b = r3;
            this.f24307d |= Integer.MIN_VALUE;
            return a.a(this.f24306c, null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: EventTaskCardManager.kt */
    @d.c.b.a.f(b = "EventTaskCardManager.kt", c = {203}, d = "findEventTaskDataV2ByMsgId", e = "com.obric.autoaction.app.launcherpage.query.task.EventTaskCardManager")
    static final class c extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        /* synthetic */ Object f24308a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ a f24309b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int f24310c;

        c(a r3, d.c.d<? super c> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f24309b = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f24308a = r3;
            this.f24310c |= Integer.MIN_VALUE;
            return a.c(this.f24309b, null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: EventTaskCardManager.kt */
    @d.c.b.a.f(b = "EventTaskCardManager.kt", c = {171}, d = "findLocalMessageIdFromDao", e = "com.obric.autoaction.app.launcherpage.query.task.EventTaskCardManager")
    static final class d extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f24311a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        /* synthetic */ Object f24312b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ a f24313c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        int f24314d;

        d(a r3, d.c.d<? super d> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f24313c = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f24312b = r3;
            this.f24314d |= Integer.MIN_VALUE;
            return a.b(this.f24313c, null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: EventTaskCardManager.kt */
    @d.c.b.a.f(b = "EventTaskCardManager.kt", c = {161}, d = "obtainLocalMsgId", e = "com.obric.autoaction.app.launcherpage.query.task.EventTaskCardManager")
    static final class e extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f24315a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        /* synthetic */ Object f24316b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ a f24317c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        int f24318d;

        e(a r3, d.c.d<? super e> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f24317c = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f24316b = r3;
            this.f24318d |= Integer.MIN_VALUE;
            return a.a(this.f24317c, null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: EventTaskCardManager.kt */
    @d.c.b.a.f(b = "EventTaskCardManager.kt", c = {185}, d = "obtainMsgCardDataList", e = "com.obric.autoaction.app.launcherpage.query.task.EventTaskCardManager")
    static final class f extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f24319a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f24320b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Object f24321c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        /* synthetic */ Object f24322d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ a f24323e;
        int f;

        f(a r3, d.c.d<? super f> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f24323e = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f24322d = r3;
            this.f |= Integer.MIN_VALUE;
            return a.a(this.f24323e, null, null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: EventTaskCardManager.kt */
    @d.c.b.a.f(b = "EventTaskCardManager.kt", c = {82}, d = "onEventTaskDelete", e = "com.obric.autoaction.app.launcherpage.query.task.EventTaskCardManager")
    static final class g extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f24324a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        /* synthetic */ Object f24325b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ a f24326c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        int f24327d;

        g(a r3, d.c.d<? super g> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f24326c = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f24325b = r3;
            this.f24327d |= Integer.MIN_VALUE;
            return this.f24326c.b(null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: EventTaskCardManager.kt */
    @d.c.b.a.f(b = "EventTaskCardManager.kt", c = {56}, d = "onEventTaskUpdate", e = "com.obric.autoaction.app.launcherpage.query.task.EventTaskCardManager")
    static final class h extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f24328a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f24329b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        /* synthetic */ Object f24330c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ a f24331d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        int f24332e;

        h(a r3, d.c.d<? super h> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f24331d = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f24330c = r3;
            this.f24332e |= Integer.MIN_VALUE;
            return this.f24331d.a(null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: EventTaskCardManager.kt */
    @d.c.b.a.f(b = "EventTaskCardManager.kt", c = {236}, d = "showTaskCard", e = "com.obric.autoaction.app.launcherpage.query.task.EventTaskCardManager")
    static final class i extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f24333a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f24334b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Object f24335c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        /* synthetic */ Object f24336d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ a f24337e;
        int f;

        i(a r3, d.c.d<? super i> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f24337e = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f24336d = r3;
            this.f |= Integer.MIN_VALUE;
            return this.f24337e.a(null, null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    public static /* synthetic */ CharSequence lambda$mdZKK0HHyD7WhtLeG4y3SvzaQWg(AppIntentCardData r0) {
        return a(r0);
    }

    private a() {
    }

    public static final /* synthetic */ Object a(a r2, ConditionTask r3, d.c.d r4) {
        return r2.c(r3, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    public static final /* synthetic */ Object a(a r2, String r3, EventTaskEntity r4, d.c.d r5) {
        return r2.a(r3, r4, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    public static final /* synthetic */ Object a(a r2, String r3, d.c.d r4) {
        return r2.a(r3, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    public static final /* synthetic */ Object b(a r2, String r3, d.c.d r4) {
        return r2.b(r3, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    public static final /* synthetic */ Object c(a r2, String r3, d.c.d r4) {
        return r2.c(r3, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    static {
        f24297a = new a();
        f24298b = new ConcurrentHashMap();
    }

    public final Object a(ConditionTask r22, d.c.d<? super x> r23) {
        a r0 = this;
        ConditionTask r1 = r22;
        d.c.d r2 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r23, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r2, h.class) == false) goto L7;
        h r4 = (h) ZeusTransformUtils.preCheckCast(r2, h.class, "com.obric.aiagent.plugin");
        if ((r4.f24332e & Integer.MIN_VALUE) == 0) goto L7;
        r4.f24332e -= Integer.MIN_VALUE;
    L8:
        Object r3 = r4.f24330c;
        Object r5 = d.c.a.b.a();
        int r6 = r4.f24332e;
        if (r6 == 0) goto L14;
        if (r6 != 1) goto L13;
        ConditionTask r7 = (ConditionTask) ZeusTransformUtils.preCheckCast(r4.f24329b, ConditionTask.class, "com.obric.aiagent.plugin");
        a r8 = (a) ZeusTransformUtils.preCheckCast(r4.f24328a, a.class, "com.obric.aiagent.plugin");
        o.a(r3);
        r1 = r7;
        r0 = r8;
    L17:
        List r9 = (List) ZeusTransformUtils.preCheckCast(r3, List.class, "com.obric.aiagent.plugin");
        if (r9 == null) goto L20;
        Iterator r10 = r9.iterator();
        int r11 = 0;
        int r12 = 0;
    L23:
        if (r10.hasNext() == false) goto L34;
        AppEntity r13 = ((AppIntentCardData) ZeusTransformUtils.preCheckCast(r10.next(), AppIntentCardData.class, "com.obric.aiagent.plugin")).getAppEntity();
        String r14 = null;
        if (ZeusTransformUtils.instanceOf(r13, EventTaskEntity.class) == false) goto L27;
        EventTaskEntity r15 = (EventTaskEntity) ZeusTransformUtils.preCheckCast(r13, EventTaskEntity.class, "com.obric.aiagent.plugin");
    L28:
        if (r15 == null) goto L31;
        r14 = r15.getId();
    L31:
        if (d.h.b.o.a(r14, r1.getId()) == true) goto L35;
        r12 = r12 + 1;
    L35:
        String r16 = m.a(r1);
        EventTaskEntity r17 = r0.a(r1);
        Gson r18 = EntityExtKt.a();
        DataSource r19 = new DataSource("EventTask", "EventTask_SubmitTask", "EventTaskSubmitTaskIntent");
        Iterable r20 = (Iterable) ZeusTransformUtils.preCheckCast(r9, Iterable.class, "com.obric.aiagent.plugin");
        Collection r21 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(p.a(r20, 10)), Collection.class, "com.obric.aiagent.plugin");
        Iterator r24 = r20.iterator();
    L37:
        if (r24.hasNext() == false) goto L45;
        Object r25 = r24.next();
        int r110 = r11 + 1;
        if (r11 >= 0) goto L41;
        p.c();
    L41:
        AppIntentCardData r26 = (AppIntentCardData) ZeusTransformUtils.preCheckCast(r25, AppIntentCardData.class, "com.obric.aiagent.plugin");
        if (r12 != r11) goto L44;
        r26 = AppIntentCardData.Companion.a((AppEntity) ZeusTransformUtils.preCheckCast(r17, AppEntity.class, "com.obric.aiagent.plugin"));
    L44:
        r21.add(r26);
        r11 = r110;
        goto L37
    L45:
        String r27 = r18.toJson(new AppIntentMessage(r19, true, false, "", "", false, false, null, (List) ZeusTransformUtils.preCheckCast(r21, List.class, "com.obric.aiagent.plugin"), null, 736, null));
        IFlowMessageIDL r28 = ak.a(aa.b(IFlowMessageIDL.class));
        if (r28 == null) goto L49;
        r28.updateMutableMessageContent(r16, r27);
    L49:
        return x.f38692a;
    L27:
        r15 = null;
        goto L28
    L34:
        r12 = -1;
        goto L35
    L20:
        return x.f38692a;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        o.a(r3);
        r4.f24328a = r0;
        r4.f24329b = r1;
        r4.f24332e = 1;
        r3 = r0.c(r1, r4);
        if (r3 != r5) goto L17;
        return r5;
    L7:
        r4 = new h(r0, r2);
        goto L8
    }

    public final Object b(ConditionTask r20, d.c.d<? super x> r21) {
        d.c.d r2 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r21, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r2, g.class) == false) goto L7;
        g r4 = (g) ZeusTransformUtils.preCheckCast(r2, g.class, "com.obric.aiagent.plugin");
        if ((r4.f24327d & Integer.MIN_VALUE) == 0) goto L7;
        r4.f24327d -= Integer.MIN_VALUE;
    L8:
        Object r3 = r4.f24325b;
        Object r5 = d.c.a.b.a();
        int r6 = r4.f24327d;
        if (r6 == 0) goto L14;
        if (r6 != 1) goto L13;
        ConditionTask r0 = (ConditionTask) ZeusTransformUtils.preCheckCast(r4.f24324a, ConditionTask.class, "com.obric.aiagent.plugin");
        o.a(r3);
    L18:
        List r1 = (List) ZeusTransformUtils.preCheckCast(r3, List.class, "com.obric.aiagent.plugin");
        if (r1 == null) goto L21;
        Iterator r7 = r1.iterator();
        int r8 = 0;
        int r9 = 0;
    L24:
        if (r7.hasNext() == false) goto L35;
        AppEntity r10 = ((AppIntentCardData) ZeusTransformUtils.preCheckCast(r7.next(), AppIntentCardData.class, "com.obric.aiagent.plugin")).getAppEntity();
        String r11 = null;
        if (ZeusTransformUtils.instanceOf(r10, EventTaskEntity.class) == false) goto L28;
        EventTaskEntity r12 = (EventTaskEntity) ZeusTransformUtils.preCheckCast(r10, EventTaskEntity.class, "com.obric.aiagent.plugin");
    L29:
        if (r12 == null) goto L32;
        r11 = r12.getId();
    L32:
        if (d.h.b.o.a(r11, r0.getId()) == true) goto L36;
        r9 = r9 + 1;
    L36:
        String r13 = m.a(r0);
        Gson r14 = EntityExtKt.a();
        DataSource r15 = new DataSource("EventTask", "EventTask_SubmitTask", "EventTaskSubmitTaskIntent");
        Iterable r16 = (Iterable) ZeusTransformUtils.preCheckCast(r1, Iterable.class, "com.obric.aiagent.plugin");
        Collection r17 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(p.a(r16, 10)), Collection.class, "com.obric.aiagent.plugin");
        Iterator r18 = r16.iterator();
    L38:
        if (r18.hasNext() == false) goto L46;
        Object r19 = r18.next();
        int r22 = r8 + 1;
        if (r8 >= 0) goto L42;
        p.c();
    L42:
        AppIntentCardData r23 = (AppIntentCardData) ZeusTransformUtils.preCheckCast(r19, AppIntentCardData.class, "com.obric.aiagent.plugin");
        if (r9 != r8) goto L45;
        r23 = new AppIntentCardData(0, r23.getAppEntity(), null, true, false, 20, null);
    L45:
        r17.add(r23);
        r8 = r22;
        goto L38
    L46:
        String r24 = r14.toJson(new AppIntentMessage(r15, true, false, "", "", false, false, null, (List) ZeusTransformUtils.preCheckCast(r17, List.class, "com.obric.aiagent.plugin"), null, 736, null));
        IFlowMessageIDL r25 = ak.a(aa.b(IFlowMessageIDL.class));
        if (r25 == null) goto L50;
        r25.updateMutableMessageContent(r13, r24);
    L50:
        return x.f38692a;
    L28:
        r12 = null;
        goto L29
    L35:
        r9 = -1;
        goto L36
    L21:
        return x.f38692a;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        o.a(r3);
        r4.f24324a = r20;
        r4.f24327d = 1;
        r3 = c(r20, r4);
        if (r3 != r5) goto L17;
        return r5;
    L17:
        r0 = r20;
    L7:
        r4 = new g(this, r2);
        goto L8
    }

    private final Object c(ConditionTask r20, d.c.d<? super List<AppIntentCardData>> r21) {
        d.c.d r1 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r21, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r1, b.class) == false) goto L7;
        b r3 = (b) ZeusTransformUtils.preCheckCast(r1, b.class, "com.obric.aiagent.plugin");
        if ((r3.f24307d & Integer.MIN_VALUE) == 0) goto L7;
        r3.f24307d -= Integer.MIN_VALUE;
    L8:
        Object r2 = r3.f24305b;
        Object r4 = d.c.a.b.a();
        int r5 = r3.f24307d;
        boolean r6 = true;
        if (r5 == 0) goto L14;
        if (r5 != 1) goto L13;
        ConditionTask r0 = (ConditionTask) ZeusTransformUtils.preCheckCast(r3.f24304a, ConditionTask.class, "com.obric.aiagent.plugin");
        o.a(r2);
    L26:
        List r7 = (List) ZeusTransformUtils.preCheckCast(r2, List.class, "com.obric.aiagent.plugin");
        Collection r8 = (Collection) ZeusTransformUtils.preCheckCast(r7, Collection.class, "com.obric.aiagent.plugin");
        int r9 = 0;
        if (r8 != null) goto L29;
    L32:
        if (r6 == false) goto L35;
        ILogDepend.Companion.i(TAG, "findAndVerifyPreEntityList " + r0.getId() + ": not find preList");
        return null;
    L35:
        Iterator r10 = r7.iterator();
    L37:
        if (r10.hasNext() == false) goto L49;
        AppEntity r11 = ((AppIntentCardData) ZeusTransformUtils.preCheckCast(r10.next(), AppIntentCardData.class, "com.obric.aiagent.plugin")).getAppEntity();
        if (ZeusTransformUtils.instanceOf(r11, EventTaskEntity.class) == false) goto L41;
        EventTaskEntity r12 = (EventTaskEntity) ZeusTransformUtils.preCheckCast(r11, EventTaskEntity.class, "com.obric.aiagent.plugin");
    L42:
        if (r12 == null) goto L44;
        String r13 = r12.getId();
    L46:
        if (d.h.b.o.a(r13, r0.getId()) == true) goto L50;
        r9 = r9 + 1;
    L50:
        if (r9 >= 0) goto L53;
        ILogDepend.Companion.i(TAG, "findAndVerifyPreEntityList " + r0.getId() + ": preList no task " + p.a((Iterable) ZeusTransformUtils.preCheckCast(r7, Iterable.class, "com.obric.aiagent.plugin"), null, null, null, 0, null, $$Lambda$a$mdZKK0HHyD7WhtLeG4y3SvzaQWg.INSTANCE, 31, null));
        return null;
    L53:
        return r7;
    L44:
        r13 = null;
        goto L46
    L41:
        r12 = null;
        goto L42
    L49:
        r9 = -1;
        goto L50
    L29:
        if (r8.isEmpty() == true) goto L32;
        r6 = false;
        goto L32
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        o.a(r2);
        String r14 = m.a(r20);
        if (r14 != null) goto L18;
        ILogDepend.Companion.i(TAG, "findAndVerifyPreEntityList " + r20.getId() + " no messageId");
        return null;
    L18:
        String r15 = m.b(r20);
        if (r15 != null) goto L22;
        ILogDepend.Companion.i(TAG, "findAndVerifyPreEntityList " + r20.getId() + " no questionId");
        return null;
    L22:
        ILogDepend.Companion.i(TAG, "findAndVerifyPreEntityList " + r20.getId() + ": messageId " + r14 + " questionId " + r15);
        r3.f24304a = r20;
        r3.f24307d = 1;
        r2 = c(r14, r3);
        if (r2 != r4) goto L25;
        return r4;
    L25:
        r0 = r20;
    L7:
        r3 = new b(this, r1);
        goto L8
    }

    private static final CharSequence a(AppIntentCardData r2) {
        d.h.b.o.e(r2, "it");
        return (CharSequence) ZeusTransformUtils.preCheckCast('\n' + r2 + ".id", CharSequence.class, "com.obric.aiagent.plugin");
    }

    public final Object a(Map<String, String> r9, String r10, d.c.d<? super Map<String, String>> r11) {
        Map r12 = (Map) ZeusTransformUtils.wrapperContextForParams(r9, Map.class, "com.obric.aiagent.plugin");
        d.c.d r13 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r11, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r13, C0556a.class) == false) goto L7;
        C0556a r0 = (C0556a) ZeusTransformUtils.preCheckCast(r13, C0556a.class, "com.obric.aiagent.plugin");
        if ((r0.f & Integer.MIN_VALUE) == 0) goto L7;
        r0.f -= Integer.MIN_VALUE;
    L8:
        Object r14 = r0.f24302d;
        Object r2 = d.c.a.b.a();
        int r3 = r0.f;
        boolean r5 = true;
        if (r3 == 0) goto L16;
        if (r3 == 1) goto L15;
        if (r3 != 2) goto L14;
        String r8 = (String) ZeusTransformUtils.preCheckCast(r0.f24301c, String.class, "com.obric.aiagent.plugin");
        String r15 = (String) ZeusTransformUtils.preCheckCast(r0.f24300b, String.class, "com.obric.aiagent.plugin");
        Map r16 = (Map) ZeusTransformUtils.preCheckCast(r0.f24299a, Map.class, "com.obric.aiagent.plugin");
        o.a(r14);
    L23:
        IMMessage r17 = (IMMessage) ZeusTransformUtils.preCheckCast(r14, IMMessage.class, "com.obric.aiagent.plugin");
        if (r17 == null) goto L26;
        String r18 = com.obric.agent.im.b.a(r17);
    L27:
        if (r18 != null) goto L29;
        r18 = "";
    L29:
        HashMap r1 = new HashMap();
        if (r16 == null) goto L32;
        r1.putAll(r16);
    L32:
        ((Map) ZeusTransformUtils.preCheckCast(r1, Map.class, "com.obric.aiagent.plugin")).put("obric_client_flow_local_message_id", r8);
        ((Map) ZeusTransformUtils.preCheckCast(r1, Map.class, "com.obric.aiagent.plugin")).put("obric_client_flow_question_id", r15);
        ((Map) ZeusTransformUtils.preCheckCast(r1, Map.class, "com.obric.aiagent.plugin")).put("obric_client_task_create_from", DownloadConstants.QUERY_KEY);
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r18, CharSequence.class, "com.obric.aiagent.plugin")).length() > 0) goto L36;
        r5 = false;
    L36:
        if (r5 == false) goto L38;
        ((Map) ZeusTransformUtils.preCheckCast(r1, Map.class, "com.obric.aiagent.plugin")).put("obric_client_task_create_origin_query", r18);
    L39:
        return r1;
    L38:
        ILogDepend.Companion.i(TAG, "appendTaskExtForCard originQuery empty, questionId=" + r15);
        goto L39
    L26:
        r18 = null;
        goto L27
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        r10 = (String) ZeusTransformUtils.preCheckCast(r0.f24301c, String.class, "com.obric.aiagent.plugin");
        r12 = (Map) ZeusTransformUtils.preCheckCast(r0.f24300b, Map.class, "com.obric.aiagent.plugin");
        a this = (a) ZeusTransformUtils.preCheckCast(r0.f24299a, a.class, "com.obric.aiagent.plugin");
        o.a(r14);
    L19:
        String r19 = (String) ZeusTransformUtils.preCheckCast(r14, String.class, "com.obric.aiagent.plugin");
        r0.f24299a = r12;
        r0.f24300b = r10;
        r0.f24301c = r19;
        r0.f = 2;
        Object r20 = this.d(r10, r0);
        if (r20 != r2) goto L22;
        return r2;
    L22:
        r14 = r20;
        r8 = r19;
        String r7 = r10;
        r16 = r12;
        r15 = r7;
        goto L23
    L16:
        o.a(r14);
        r0.f24299a = this;
        r0.f24300b = r12;
        r0.f24301c = r10;
        r0.f = 1;
        r14 = a(r10, r0);
        if (r14 != r2) goto L19;
        return r2;
    L7:
        r0 = new C0556a(this, r13);
        goto L8
    }

    private final Object a(String r7, d.c.d<? super String> r8) {
        d.c.d r9 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r8, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r9, e.class) == false) goto L7;
        e r0 = (e) ZeusTransformUtils.preCheckCast(r9, e.class, "com.obric.aiagent.plugin");
        if ((r0.f24318d & Integer.MIN_VALUE) == 0) goto L7;
        r0.f24318d -= Integer.MIN_VALUE;
    L8:
        Object r10 = r0.f24316b;
        Object r2 = d.c.a.b.a();
        int r3 = r0.f24318d;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        String r6 = (String) ZeusTransformUtils.preCheckCast(r0.f24315a, String.class, "com.obric.aiagent.plugin");
        o.a(r10);
        r7 = r6;
    L25:
        String r11 = (String) ZeusTransformUtils.preCheckCast(r10, String.class, "com.obric.aiagent.plugin");
        if (r11 != null) goto L33;
        IFlowMessageIDL r12 = ak.a(aa.b(IFlowMessageIDL.class));
        if (r12 == null) goto L30;
        r11 = r12.generateLocalMessageId();
    L31:
        if (r11 != null) goto L33;
        r11 = "";
        goto L33
    L30:
        r11 = null;
    L33:
        String r13 = r11;
    L35:
        ILogDepend.Companion.i(TAG, "obtainLocalMsgId questionId = " + r7 + ", msgId = " + r13);
        return r13;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        o.a(r10);
        r13 = (String) ZeusTransformUtils.preCheckCast(f24298b.get(r7), String.class, "com.obric.aiagent.plugin");
        CharSequence r4 = (CharSequence) ZeusTransformUtils.preCheckCast(r13, CharSequence.class, "com.obric.aiagent.plugin");
        if (r4 != null) goto L17;
    L20:
        boolean r5 = true;
    L21:
        if (r5 == false) goto L34;
        r0.f24315a = r7;
        r0.f24318d = 1;
        r10 = b(r7, r0);
        if (r10 != r2) goto L25;
        return r2;
    L34:
        ILogDepend.Companion.i(TAG, "obtainLocalMsgId get msgId from msgIdMap: " + r13);
        goto L35
    L17:
        if (r4.length() == 0) goto L20;
        r5 = false;
    L7:
        r0 = new e(this, r9);
        goto L8
    }

    private final Object b(String r7, d.c.d<? super String> r8) {
        d.c.d r9 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r8, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r9, d.class) == false) goto L7;
        d r0 = (d) ZeusTransformUtils.preCheckCast(r9, d.class, "com.obric.aiagent.plugin");
        if ((r0.f24314d & Integer.MIN_VALUE) == 0) goto L7;
        r0.f24314d -= Integer.MIN_VALUE;
    L8:
        Object r6 = r0.f24312b;
        Object r10 = d.c.a.b.a();
        int r2 = r0.f24314d;
        if (r2 == 0) goto L14;
        if (r2 != 1) goto L13;
        r7 = (String) ZeusTransformUtils.preCheckCast(r0.f24311a, String.class, "com.obric.aiagent.plugin");
        o.a(r6);
    L19:
        List r11 = (List) ZeusTransformUtils.preCheckCast(r6, List.class, "com.obric.aiagent.plugin");
        if (r11 == null) goto L33;
        Iterator r12 = ((Iterable) ZeusTransformUtils.preCheckCast(r11, Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L23:
        if (r12.hasNext() == false) goto L33;
        EventTask r13 = (EventTask) ZeusTransformUtils.preCheckCast(r12.next(), EventTask.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r13, ConditionTask.class) == false) goto L27;
        ConditionTask r14 = (ConditionTask) ZeusTransformUtils.preCheckCast(r13, ConditionTask.class, "com.obric.aiagent.plugin");
    L28:
        if (r14 == null) goto L23;
        if (d.h.b.o.a(m.b(r14), r7) == false) goto L23;
        ILogDepend.Companion.i(TAG, "obtainLocalMsgId findLocalMessageIdFromDao:" + m.a(r14));
        return m.a(r14);
    L27:
        r14 = null;
    L33:
        ILogDepend.Companion.i(TAG, "obtainLocalMsgId findLocalMessageIdFromDao: not find");
        return null;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        o.a(r6);
        IEventTaskApi r15 = (IEventTaskApi) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IEventTaskApi.class), IEventTaskApi.class, "com.obric.aiagent.plugin");
        if (r15 == null) goto L33;
        r0.f24311a = r7;
        r0.f24314d = 1;
        r6 = r15.getAllEventTasks(r0);
        if (r6 != r10) goto L19;
        return r10;
    L7:
        r0 = new d(this, r9);
        goto L8
    }

    private final Object a(String r9, EventTaskEntity r10, d.c.d<? super CopyOnWriteArrayList<AppIntentCardData>> r11) {
        d.c.d r12 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r11, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r12, f.class) == false) goto L7;
        f r0 = (f) ZeusTransformUtils.preCheckCast(r12, f.class, "com.obric.aiagent.plugin");
        if ((r0.f & Integer.MIN_VALUE) == 0) goto L7;
        r0.f -= Integer.MIN_VALUE;
    L8:
        Object r13 = r0.f24322d;
        Object r2 = d.c.a.b.a();
        int r3 = r0.f;
        boolean r4 = true;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        CopyOnWriteArrayList r8 = (CopyOnWriteArrayList) ZeusTransformUtils.preCheckCast(r0.f24321c, CopyOnWriteArrayList.class, "com.obric.aiagent.plugin");
        r10 = (EventTaskEntity) ZeusTransformUtils.preCheckCast(r0.f24320b, EventTaskEntity.class, "com.obric.aiagent.plugin");
        r9 = (String) ZeusTransformUtils.preCheckCast(r0.f24319a, String.class, "com.obric.aiagent.plugin");
        o.a(r13);
    L18:
        List r14 = (List) ZeusTransformUtils.preCheckCast(r13, List.class, "com.obric.aiagent.plugin");
        Collection r1 = (Collection) ZeusTransformUtils.preCheckCast(r14, Collection.class, "com.obric.aiagent.plugin");
        int r5 = 0;
        if (r1 == null) goto L25;
        if (r1.isEmpty() == true) goto L25;
        r4 = false;
    L25:
        if (r4 == true) goto L27;
        ILogDepend.Companion.i(TAG, "obtainMsgCardDataList msgId = " + r9 + ", find preList, size = " + r14.size());
        r8.addAll((Collection) ZeusTransformUtils.preCheckCast(r14, Collection.class, "com.obric.aiagent.plugin"));
    L27:
        Iterator r15 = ((List) ZeusTransformUtils.preCheckCast(r8, List.class, "com.obric.aiagent.plugin")).iterator();
    L29:
        if (r15.hasNext() == false) goto L38;
        AppEntity r6 = ((AppIntentCardData) ZeusTransformUtils.preCheckCast(r15.next(), AppIntentCardData.class, "com.obric.aiagent.plugin")).getAppEntity();
        if (r6 == null) goto L33;
        String r7 = r6.getId();
    L35:
        if (d.h.b.o.a(r7, r10.getId()) == true) goto L39;
        r5 = r5 + 1;
    L39:
        if (r5 >= 0) goto L41;
        d.c.b.a.b.a(r8.add(AppIntentCardData.Companion.a((AppEntity) ZeusTransformUtils.preCheckCast(r10, AppEntity.class, "com.obric.aiagent.plugin"))));
    L42:
        ILogDepend.Companion.i(TAG, "obtainMsgCardDataList msgId = " + r9 + ", size = " + r8.size());
        return r8;
    L41:
        r8.set(r5, AppIntentCardData.Companion.a((AppEntity) ZeusTransformUtils.preCheckCast(r10, AppEntity.class, "com.obric.aiagent.plugin")));
        goto L42
    L33:
        r7 = null;
        goto L35
    L38:
        r5 = -1;
        goto L39
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        o.a(r13);
        CopyOnWriteArrayList r16 = new CopyOnWriteArrayList();
        r0.f24319a = r9;
        r0.f24320b = r10;
        r0.f24321c = r16;
        r0.f = 1;
        Object r17 = c(r9, r0);
        if (r17 != r2) goto L17;
        return r2;
    L17:
        r13 = r17;
        r8 = r16;
    L7:
        r0 = new f(this, r12);
        goto L8
    }

    private final Object c(String r6, d.c.d<? super List<AppIntentCardData>> r7) {
        d.c.d r8 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r7, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r8, c.class) == false) goto L7;
        c r0 = (c) ZeusTransformUtils.preCheckCast(r8, c.class, "com.obric.aiagent.plugin");
        if ((r0.f24310c & Integer.MIN_VALUE) == 0) goto L7;
        r0.f24310c -= Integer.MIN_VALUE;
    L8:
        Object r9 = r0.f24308a;
        Object r2 = d.c.a.b.a();
        int r3 = r0.f24310c;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        o.a(r9);
    L17:
        IMMessage r5 = (IMMessage) ZeusTransformUtils.preCheckCast(r9, IMMessage.class, "com.obric.aiagent.plugin");
        if (r5 != null) goto L20;
        return null;
    L20:
        return ((AppIntentMessage) ZeusTransformUtils.preCheckCast(EntityExtKt.a().fromJson(r5.getContent(), AppIntentMessage.class), AppIntentMessage.class, "com.obric.aiagent.plugin")).getDataV2();
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        o.a(r9);
        r0.f24310c = 1;
        r9 = d(r6, r0);
        if (r9 != r2) goto L17;
        return r2;
    L7:
        r0 = new c(this, r8);
        goto L8
    }

    public final Object a(ConditionTask r8, String r9, d.c.d<? super x> r10) {
        d.c.d r11 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r10, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r11, i.class) == false) goto L7;
        i r0 = (i) ZeusTransformUtils.preCheckCast(r11, i.class, "com.obric.aiagent.plugin");
        if ((r0.f & Integer.MIN_VALUE) == 0) goto L7;
        r0.f -= Integer.MIN_VALUE;
    L8:
        Object r12 = r0.f24336d;
        Object r2 = d.c.a.b.a();
        int r3 = r0.f;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        String r7 = (String) ZeusTransformUtils.preCheckCast(r0.f24335c, String.class, "com.obric.aiagent.plugin");
        r9 = (String) ZeusTransformUtils.preCheckCast(r0.f24334b, String.class, "com.obric.aiagent.plugin");
        a r13 = (a) ZeusTransformUtils.preCheckCast(r0.f24333a, a.class, "com.obric.aiagent.plugin");
        o.a(r12);
        String r14 = r7;
        a this = r13;
        Object r15 = r12;
    L20:
        this.a((List) ZeusTransformUtils.preCheckCast((CopyOnWriteArrayList) ZeusTransformUtils.preCheckCast(r15, CopyOnWriteArrayList.class, "com.obric.aiagent.plugin"), List.class, "com.obric.aiagent.plugin"), r9, r14);
        return x.f38692a;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        o.a(r12);
        ILogDepend.Companion.i(TAG, "showTaskCard questionId = " + r9);
        r14 = m.a(r8);
        if (r14 != null) goto L17;
        r14 = "";
    L17:
        EventTaskEntity r16 = a(r8);
        r0.f24333a = this;
        r0.f24334b = r9;
        r0.f24335c = r14;
        r0.f = 1;
        r15 = a(r14, r16, r0);
        if (r15 != r2) goto L20;
        return r2;
    L7:
        r0 = new i(this, r11);
        goto L8
    }

    private final void a(List<AppIntentCardData> r25, String r26, String r27) {
        List r11 = (List) ZeusTransformUtils.wrapperContextForParams(r25, List.class, "com.obric.aiagent.plugin");
        String r17 = EntityExtKt.a().toJson(new AppIntentMessage(new DataSource("EventTask", "EventTask_SubmitTask", "EventTaskSubmitTaskIntent"), true, false, "", "", false, false, null, r11, null, 736, null));
        IAgentService r16 = (IAgentService) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IAgentService.class), IAgentService.class, "com.obric.aiagent.plugin");
        if (r16 == null) goto L6;
        d.h.b.o.a(r17);
        IAgentService.a.a(r16, r17, OAppIntentBizContentType.EVENT_TASK_CARD, r26, 0, r27, 8, null);
        return;
    }

    private final EventTaskEntity a(ConditionTask r15) {
        com.obric.autoaction.app.launcherpage.api.a.a r0 = b(r15);
        Set<String> r14 = a(r15.getConditions(), aa.b(Condition.class));
        String r1 = r15.getId();
        if (r1 != null) goto L5;
        String r4 = "";
    L6:
        long r5 = System.currentTimeMillis();
        long r7 = System.currentTimeMillis();
        String r2 = r0.a();
        if (r2 != null) goto L9;
        String r9 = "";
    L10:
        String r3 = r0.b();
        if (r3 != null) goto L13;
        String r11 = "";
    L14:
        String r6 = r0.c();
        if (r6 != null) goto L17;
        String r10 = "";
    L18:
        EventTaskEntity r16 = new EventTaskEntity(r4, r5, r7, r9, r10, r11, false, p.o((Iterable) ZeusTransformUtils.preCheckCast(r14, Iterable.class, "com.obric.aiagent.plugin")));
        r16.setExtraData(f24297a.a(r15.getExt()));
        return r16;
    L17:
        r10 = r6;
        goto L18
    L13:
        r11 = r3;
        goto L14
    L9:
        r9 = r2;
        goto L10
    L5:
        r4 = r1;
        goto L6
    }

    private final String a(Map<String, String> r8) {
        Map r7 = (Map) ZeusTransformUtils.wrapperContextForParams(r8, Map.class, "com.obric.aiagent.plugin");
        String r1 = null;
        if (r7 == null) goto L5;
        String r2 = (String) ZeusTransformUtils.preCheckCast(r7.get("o_semantic_icon_color_key"), String.class, "com.obric.aiagent.plugin");
    L7:
        if (r7 == null) goto L9;
        String r9 = (String) ZeusTransformUtils.preCheckCast(r7.get("o_semantic_icon_key"), String.class, "com.obric.aiagent.plugin");
    L10:
        CharSequence r4 = (CharSequence) ZeusTransformUtils.preCheckCast(r2, CharSequence.class, "com.obric.aiagent.plugin");
        boolean r5 = false;
        if (r4 != null) goto L13;
    L16:
        boolean r6 = true;
    L17:
        if (r6 == false) goto L25;
        CharSequence r10 = (CharSequence) ZeusTransformUtils.preCheckCast(r9, CharSequence.class, "com.obric.aiagent.plugin");
        if (r10 != null) goto L21;
    L22:
        r5 = true;
    L23:
        if (r5 == false) goto L25;
        return null;
    L21:
        if (d.o.o.d(r10) == false) goto L23;
    L25:
        JSONObject r11 = new JSONObject();
        if (r2 != null) goto L28;
    L33:
        if (r9 == null) goto L40;
        if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r9, CharSequence.class, "com.obric.aiagent.plugin"))) == false) goto L37;
        r1 = r9;
    L37:
        if (r1 == null) goto L40;
        r11.put("o_semantic_icon_key", r1);
    L40:
        return r11.toString();
    L28:
        if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r2, CharSequence.class, "com.obric.aiagent.plugin"))) == true) goto L31;
        r2 = null;
    L31:
        if (r2 == null) goto L33;
        r11.put("o_semantic_icon_color_key", r2);
        goto L33
    L13:
        if (d.o.o.d(r4) == true) goto L16;
        r6 = false;
        goto L17
    L9:
        r9 = null;
        goto L10
    L5:
        r2 = null;
        goto L7
    }

    private final com.obric.autoaction.app.launcherpage.api.a.a b(ConditionTask r6) {
        List<AutoCondition> r0 = com.obric.autoaction.app.launcherpage.condition.a.a.a(r6.getConditions());
        Context r1 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppHost.Companion.getApplication(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin")).getApplicationContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        d.h.b.o.c(r1, "getApplicationContext(...)");
        String r2 = com.obric.autoaction.app.launcherpage.condition.a.a.a(r0, r1);
        String r3 = com.obric.autoaction.app.launcherpage.condition.a.a.a(r6.getPeriodicPolicy());
        ConditionTaskAction r7 = (ConditionTaskAction) ZeusTransformUtils.preCheckCast(p.l(r6.getActions()), ConditionTaskAction.class, "com.obric.aiagent.plugin");
        SystemAutoActionParams r4 = null;
        if (r7 == null) goto L5;
        IntentParams r8 = r7.getParams();
    L7:
        if (ZeusTransformUtils.instanceOf(r8, SystemAutoActionParams.class) == false) goto L9;
        r4 = (SystemAutoActionParams) ZeusTransformUtils.preCheckCast(r8, SystemAutoActionParams.class, "com.obric.aiagent.plugin");
    L9:
        if (r4 == null) goto L12;
        String r9 = r4.getInstruction();
        if (r9 == null) goto L12;
    L14:
        return new com.obric.autoaction.app.launcherpage.api.a.a(r2, r3, r9);
    L12:
        r9 = "";
        goto L14
    L5:
        r8 = null;
        goto L7
    }

    private final <T extends Condition> Set<String> a(ConditionGroup r4, d.m.c<T> r5) {
        d.m.c r3 = (d.m.c) ZeusTransformUtils.wrapperContextForParams(r5, d.m.c.class, "com.obric.aiagent.plugin");
        HashSet r6 = new HashSet();
        LinkedList r1 = new LinkedList((Collection) ZeusTransformUtils.preCheckCast(p.a(r4), Collection.class, "com.obric.aiagent.plugin"));
    L4:
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r1, Collection.class, "com.obric.aiagent.plugin")).isEmpty()) == false) goto L16;
        Condition r7 = (Condition) ZeusTransformUtils.preCheckCast(r1.poll(), Condition.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r7, ConditionGroup.class) == true) goto L7;
        if (r7 == null) goto L4;
        if (r3.a(r7) == false) goto L4;
        String r8 = aa.b(r7.getClass()).b();
        if (r8 != null) goto L14;
        r8 = SensitiveType.UNKNOWN;
    L14:
        r6.add(r8);
        goto L4
    L7:
        r1.addAll((Collection) ZeusTransformUtils.preCheckCast(((ConditionGroup) ZeusTransformUtils.preCheckCast(r7, ConditionGroup.class, "com.obric.aiagent.plugin")).getConditions(), Collection.class, "com.obric.aiagent.plugin"));
        goto L4
    L16:
        return (Set) ZeusTransformUtils.preCheckCast(r6, Set.class, "com.obric.aiagent.plugin");
    }

    private final Object d(final String r5, d.c.d<? super IMMessage> r6) {
        d.c.d r4 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin");
        kotlinx.coroutines.o r7 = new kotlinx.coroutines.o(d.c.a.b.a(r4), 1);
        r7.e();
        final n r1 = (n) ZeusTransformUtils.preCheckCast(r7, n.class, "com.obric.aiagent.plugin");
        IFlowMessageIDL r2 = ak.a(aa.b(IFlowMessageIDL.class));
        if (r2 == null) goto L5;
        r2.findMessagebyId(r5, (IFlowFindMessageCallbackIDL) ZeusTransformUtils.preCheckCast(new EventTaskCardManager$findMessageByMsgId$2$1(r1, r5), IFlowFindMessageCallbackIDL.class, "com.obric.aiagent.plugin"));
    L6:
        Object r8 = r7.h();
        if (r8 != d.c.a.b.a()) goto L9;
        d.c.b.a.h.c(r4);
    L9:
        return r8;
    L5:
        ILogDepend.Companion.e(TAG, "findMessageByMsgId IPC not available");
        d.c.d r9 = (d.c.d) ZeusTransformUtils.preCheckCast(r1, d.c.d.class, "com.obric.aiagent.plugin");
        d.n.a r0 = d.n.f38560a;
        r9.resumeWith(d.n.f(null));
        goto L6
    }
}
