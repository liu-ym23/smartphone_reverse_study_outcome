package com.obric.aiagent.executionengine.eventstaskmanager;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.obric.aiagent.platform.depend.IAppContext;
import com.obric.aiagent.platform.depend.ILogDepend;
import com.obric.aiagent.product.ObricProductSdk;
import com.obric.aiagent.product.platform.api.sleepmode.IObricSleepModeManager;
import com.obric.autoaction.app.launcherpage.api.IAutoTaskApi;
import com.obric.event.task.nlp.api.INaturalLanguageInstructionCreateApi;
import com.obric.eventkit.EventsTaskSdk;
import com.obric.eventkit.ITaskManagerApi;
import com.obric.eventkit.logger.ILogger;
import com.obric.eventkit.task.api.IEventTaskRecordApi;
import com.obric.eventkit.task.model.ConditionGroup;
import com.obric.eventkit.task.model.ConditionTaskAction;
import com.obric.eventkit.task.model.ConditionTaskResult;
import com.obric.eventkit.task.model.EventTaskExecutionRecord;
import com.obric.eventkit.task.model.PeriodicPolicy;
import com.obric.eventkit.task.model.ShortcutTask;
import com.obric.eventkit.task.model.TaskKnowledge;
import com.obric.eventkit.task.model.TriggerControlPolicy;
import com.obric.memorydata.sdk.MemoryResponse;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.ss.bduploader.BDVideoUploaderBase;
import com.volcengine.zeus.receiver.PluginBroadcastReceiver;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.p;
import d.x;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlinx.coroutines.am;
import kotlinx.coroutines.an;
import kotlinx.coroutines.ax;
import kotlinx.coroutines.bd;
import kotlinx.coroutines.bs;
import kotlinx.coroutines.cx;

/* JADX INFO: compiled from: TaskManagerImpl.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class TaskManagerImpl implements ITaskManagerApi {
    public static final a Companion = null;
    private static final String TAG = "TaskManagerImpl";
    private final AtomicBoolean hasInit;
    private final h mTimeChangeReceiver;
    private final am operationScope;
    private String shortcutsPkgName;

    /* JADX INFO: compiled from: TaskManagerImpl.kt */
    public static final class a {
        public /* synthetic */ a(d.h.b.h r1) {
            this();
        }

        private a() {
        }
    }

    /* JADX INFO: compiled from: TaskManagerImpl.kt */
    @d.c.b.a.f(b = "TaskManagerImpl.kt", c = {}, d = "invokeSuspend", e = "com.obric.aiagent.executionengine.eventstaskmanager.TaskManagerImpl$getConditionSettingWithColdStartFallback$1")
    static final class b extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f16565a;

        b(d.c.d<? super b> r3) {
            super(2, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        public final Object a(am r3, d.c.d<? super x> r4) {
            return ((b) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), b.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r1, d.c.d<?> r2) {
            return (d.c.d) ZeusTransformUtils.preCheckCast(new b((d.c.d) ZeusTransformUtils.wrapperContextForParams(r2, d.c.d.class, "com.obric.aiagent.plugin")), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r1) {
            d.c.a.b.a();
            if (this.f16565a != 0) goto L7;
            d.o.a(r1);
            com.obric.event.task.base.c.a.f32688a.d();
            return x.f38692a;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: compiled from: TaskManagerImpl.kt */
    @d.c.b.a.f(b = "TaskManagerImpl.kt", c = {BDVideoUploaderBase.KeyIsPrivateVideo}, d = "getKnowledgeForNet", e = "com.obric.aiagent.executionengine.eventstaskmanager.TaskManagerImpl")
    static final class c extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        /* synthetic */ Object f16566a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ TaskManagerImpl f16567b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int f16568c;

        c(TaskManagerImpl r3, d.c.d<? super c> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f16567b = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f16566a = r3;
            this.f16568c |= Integer.MIN_VALUE;
            return this.f16567b.getKnowledgeForNet(null, null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: TaskManagerImpl.kt */
    public static final class d implements com.obric.aiagent.executionengine.eventstaskmanager.a.a.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.obric.eventkit.b f16569a;

        /* JADX INFO: compiled from: TaskManagerImpl.kt */
        @d.c.b.a.f(b = "TaskManagerImpl.kt", c = {410}, d = "postJson", e = "com.obric.aiagent.executionengine.eventstaskmanager.TaskManagerImpl$getKnowledgeForNet$result$1")
        static final class a extends d.c.b.a.d {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            /* synthetic */ Object f16570a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ d f16571b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            int f16572c;

            a(d r3, d.c.d<? super a> r4) {
                d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
                this.f16571b = r3;
                super(r5);
            }

            @Override // d.c.b.a.a
            public final Object invokeSuspend(Object r7) {
                this.f16570a = r7;
                this.f16572c |= Integer.MIN_VALUE;
                return this.f16571b.a(null, null, null, 0, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
            }
        }

        d(com.obric.eventkit.b r3) {
            this.f16569a = (com.obric.eventkit.b) ZeusTransformUtils.wrapperContextForParams(r3, com.obric.eventkit.b.class, "com.obric.aiagent.plugin");
        }

        @Override // com.obric.aiagent.executionengine.eventstaskmanager.a.a.a
        public Object a(String r9, Map<String, String> r10, String r11, int r12, d.c.d<? super com.obric.aiagent.executionengine.eventstaskmanager.a.a.b> r13) {
            Map<String, String> r4 = (Map) ZeusTransformUtils.wrapperContextForParams(r10, Map.class, "com.obric.aiagent.plugin");
            d.c.d r14 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r13, d.c.d.class, "com.obric.aiagent.plugin");
            if (ZeusTransformUtils.instanceOf(r14, a.class) == false) goto L7;
            a r15 = (a) ZeusTransformUtils.preCheckCast(r14, a.class, "com.obric.aiagent.plugin");
            if ((r15.f16572c & Integer.MIN_VALUE) == 0) goto L7;
            r15.f16572c -= Integer.MIN_VALUE;
        L8:
            a r7 = r15;
            Object r16 = r7.f16570a;
            Object r17 = d.c.a.b.a();
            int r0 = r7.f16572c;
            if (r0 == 0) goto L14;
            if (r0 != 1) goto L13;
            d.o.a(r16);
        L17:
            com.obric.eventkit.c r8 = (com.obric.eventkit.c) ZeusTransformUtils.preCheckCast(r16, com.obric.eventkit.c.class, "com.obric.aiagent.plugin");
            return new com.obric.aiagent.executionengine.eventstaskmanager.a.a.b(r8.a(), r8.b());
        L13:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L14:
            d.o.a(r16);
            com.obric.eventkit.b r18 = this.f16569a;
            r7.f16572c = 1;
            r16 = r18.a(r9, r4, r11, r12, r7);
            if (r16 != r17) goto L17;
            return r17;
        L7:
            r15 = new a(this, r14);
            goto L8
        }
    }

    /* JADX INFO: compiled from: TaskManagerImpl.kt */
    @d.c.b.a.f(b = "TaskManagerImpl.kt", c = {93, 94}, d = "invokeSuspend", e = "com.obric.aiagent.executionengine.eventstaskmanager.TaskManagerImpl$init$1")
    static final class e extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f16573a;

        e(d.c.d<? super e> r3) {
            super(2, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        public final Object a(am r3, d.c.d<? super x> r4) {
            return ((e) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), e.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r1, d.c.d<?> r2) {
            return (d.c.d) ZeusTransformUtils.preCheckCast(new e((d.c.d) ZeusTransformUtils.wrapperContextForParams(r2, d.c.d.class, "com.obric.aiagent.plugin")), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r8) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f16573a;
            if (r1 == 0) goto L10;
            if (r1 == 1) goto L9;
            if (r1 != 2) goto L8;
            d.o.a(r8);
        L17:
            return x.f38692a;
        L8:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L9:
            d.o.a(r8);
        L13:
            com.obric.aiagent.executionengine.eventstaskmanager.a r9 = com.obric.aiagent.executionengine.eventstaskmanager.a.f16607a;
            d.c.d<? super x> r2 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f16573a = 2;
            if (r9.a(r2) != r0) goto L17;
            return r0;
        L10:
            d.o.a(r8);
            d.c.d r10 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f16573a = 1;
            if (ax.a(10000, r10) != r0) goto L13;
            return r0;
        }
    }

    /* JADX INFO: compiled from: TaskManagerImpl.kt */
    public static final class f implements ILogger {
        @Override // com.obric.eventkit.logger.ILogger
        public boolean isDebug() {
            return true;
        }

        f() {
        }

        @Override // com.obric.eventkit.logger.ILogger
        public void d(String r1, String r2) {
            d.h.b.o.e(r1, "tag");
            ILogDepend.Companion.d(r1, r2);
        }

        @Override // com.obric.eventkit.logger.ILogger
        public void e(String r1, String r2) {
            d.h.b.o.e(r1, "tag");
            ILogDepend.Companion.e(r1, r2);
        }

        @Override // com.obric.eventkit.logger.ILogger
        public void e(String r1, String r2, Throwable r3) {
            d.h.b.o.e(r1, "tag");
            ILogDepend.Companion.e(r1, r2, r3);
        }

        @Override // com.obric.eventkit.logger.ILogger
        public void i(String r1, String r2) {
            d.h.b.o.e(r1, "tag");
            ILogDepend.Companion.i(r1, r2);
        }

        @Override // com.obric.eventkit.logger.ILogger
        public void v(String r1, String r2) {
            d.h.b.o.e(r1, "tag");
            ILogDepend.Companion.v(r1, r2);
        }

        @Override // com.obric.eventkit.logger.ILogger
        public void w(String r1, String r2) {
            d.h.b.o.e(r1, "tag");
            ILogDepend.Companion.w(r1, r2);
        }

        @Override // com.obric.eventkit.logger.ILogger
        public void w(String r1, String r2, Throwable r3) {
            d.h.b.o.e(r1, "tag");
            ILogDepend.Companion.w(r1, r2, r3);
        }

        @Override // com.obric.eventkit.logger.ILogger
        public void w(String r1, Throwable r2) {
            d.h.b.o.e(r1, "tag");
            ILogDepend.Companion.w(r1, r2);
        }
    }

    /* JADX INFO: compiled from: TaskManagerImpl.kt */
    @d.c.b.a.f(b = "TaskManagerImpl.kt", c = {377}, d = "isKnowledgeLearningSwitchOn", e = "com.obric.aiagent.executionengine.eventstaskmanager.TaskManagerImpl")
    static final class g extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f16574a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        /* synthetic */ Object f16575b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ TaskManagerImpl f16576c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        int f16577d;

        g(TaskManagerImpl r3, d.c.d<? super g> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f16576c = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f16575b = r3;
            this.f16577d |= Integer.MIN_VALUE;
            return this.f16576c.isKnowledgeLearningSwitchOn(null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: TaskManagerImpl.kt */
    public static final class h extends PluginBroadcastReceiver {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ TaskManagerImpl f16578a;

        /* JADX INFO: compiled from: TaskManagerImpl.kt */
        @d.c.b.a.f(b = "TaskManagerImpl.kt", c = {}, d = "invokeSuspend", e = "com.obric.aiagent.executionengine.eventstaskmanager.TaskManagerImpl$mTimeChangeReceiver$1$onReceive$1")
        static final class a extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super x>, Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            int f16579a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ TaskManagerImpl f16580b;

            a(TaskManagerImpl r3, d.c.d<? super a> r4) {
                d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
                this.f16580b = r3;
                super(2, r5);
            }

            public final Object a(am r3, d.c.d<? super x> r4) {
                return ((a) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), a.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
            }

            @Override // d.c.b.a.a
            public final d.c.d<x> create(Object r2, d.c.d<?> r3) {
                d.c.d r4 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
                return (d.c.d) ZeusTransformUtils.preCheckCast(new a(this.f16580b, r4), d.c.d.class, "com.obric.aiagent.plugin");
            }

            @Override // d.h.a.m
            public /* synthetic */ Object invoke(am r3, d.c.d<? super x> r4) {
                return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
            }

            @Override // d.c.b.a.a
            public final Object invokeSuspend(Object r2) {
                d.c.a.b.a();
                if (this.f16579a != 0) goto L7;
                d.o.a(r2);
                TaskManagerImpl.access$refreshAllTaskAfterTimeChange(this.f16580b);
                return x.f38692a;
            L7:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        h(TaskManagerImpl r1) {
            this.f16578a = r1;
        }

        public void onReceive(Context r9, Intent r10) {
            Context r11 = (Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.aiagent.plugin");
            if (r10 == null) goto L5;
            String r12 = r10.getAction();
        L7:
            if (d.h.b.o.a(r12, "android.intent.action.TIME_SET") == false) goto L10;
            ILogDepend.Companion.i(TaskManagerImpl.TAG, "System time changed, refreshing all tasks");
            kotlinx.coroutines.i.a((am) ZeusTransformUtils.preCheckCast(bs.f39169a, am.class, "com.obric.aiagent.plugin"), (d.c.g) ZeusTransformUtils.preCheckCast(bd.c(), d.c.g.class, "com.obric.aiagent.plugin"), null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new a(this.f16578a, null), d.h.a.m.class, "com.obric.aiagent.plugin"), 2, null);
            return;
        L10:
            return;
        L5:
            r12 = null;
            goto L7
        }
    }

    /* JADX INFO: compiled from: TaskManagerImpl.kt */
    @d.c.b.a.f(b = "TaskManagerImpl.kt", c = {134, 135, 136}, d = "invokeSuspend", e = "com.obric.aiagent.executionengine.eventstaskmanager.TaskManagerImpl$onLoginStateChange$1")
    static final class i extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f16581a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ boolean f16582b;

        i(boolean r3, d.c.d<? super i> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f16582b = r3;
            super(2, r5);
        }

        public final Object a(am r3, d.c.d<? super x> r4) {
            return ((i) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), i.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r2, d.c.d<?> r3) {
            d.c.d r4 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new i(this.f16582b, r4), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r7) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f16581a;
            if (r1 == 0) goto L12;
            if (r1 == 1) goto L11;
            if (r1 == 2) goto L10;
            if (r1 != 3) goto L9;
            d.o.a(r7);
        L25:
            return x.f38692a;
        L9:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L10:
            d.o.a(r7);
        L20:
            com.obric.aiagent.executionengine.eventstaskmanager.common.data.e r8 = com.obric.aiagent.executionengine.eventstaskmanager.common.data.e.f16691a;
            d.c.d<? super x> r2 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f16581a = 3;
            if (r8.b(r2) != r0) goto L25;
            return r0;
        L11:
            d.o.a(r7);
        L17:
            com.obric.aiagent.executionengine.eventstaskmanager.timertask.b r9 = com.obric.aiagent.executionengine.eventstaskmanager.timertask.b.f17879a;
            d.c.d<? super x> r3 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f16581a = 2;
            if (r9.a(r3) != r0) goto L20;
            return r0;
        L12:
            d.o.a(r7);
            if (this.f16582b == true) goto L23;
            com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.b r10 = com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.b.f16741a;
            d.c.d<? super x> r4 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f16581a = 1;
            if (r10.a(r4) != r0) goto L17;
            return r0;
        L23:
            com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.b.f16741a.a();
            com.obric.aiagent.executionengine.eventstaskmanager.timertask.b.f17879a.b();
            goto L25
        }
    }

    /* JADX INFO: compiled from: TaskManagerImpl.kt */
    @d.c.b.a.f(b = "TaskManagerImpl.kt", c = {461}, d = "invokeSuspend", e = "com.obric.aiagent.executionengine.eventstaskmanager.TaskManagerImpl$onOmniTaskEnd$1")
    static final class j extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f16583a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ EventTaskExecutionRecord f16584b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f16585c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f16586d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f16587e;
        private /* synthetic */ Object f;

        j(EventTaskExecutionRecord r3, String r4, int r5, String r6, d.c.d<? super j> r7) {
            d.c.d r8 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r7, d.c.d.class, "com.obric.aiagent.plugin");
            this.f16584b = r3;
            this.f16585c = r4;
            this.f16586d = r5;
            this.f16587e = r6;
            super(2, r8);
        }

        public final Object a(am r3, d.c.d<? super x> r4) {
            return ((j) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), j.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r9, d.c.d<?> r10) {
            d.c.d r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r10, d.c.d.class, "com.obric.aiagent.plugin");
            j r11 = new j(this.f16584b, this.f16585c, this.f16586d, this.f16587e, r7);
            r11.f = r9;
            return (d.c.d) ZeusTransformUtils.preCheckCast(r11, d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r7) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f16583a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            am r2 = (am) ZeusTransformUtils.preCheckCast(this.f, am.class, "com.obric.aiagent.plugin");
            d.o.a(r7);
        L13:
            List r8 = (List) ZeusTransformUtils.preCheckCast(r7, List.class, "com.obric.aiagent.plugin");
        L14:
            String r9 = this.f16585c;
            int r3 = this.f16586d;
            String r6 = this.f16587e;
            d.n.a r4 = d.n.f38560a;     // Catch: Throwable -> L21
            INaturalLanguageInstructionCreateApi r5 = (INaturalLanguageInstructionCreateApi) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(INaturalLanguageInstructionCreateApi.class), INaturalLanguageInstructionCreateApi.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L21
            if (r5 == null) goto L18;
            r5.onOmniTaskEnd(r9, r3, r6);     // Catch: Throwable -> L21
            x r10 = x.f38692a;     // Catch: Throwable -> L21
        L19:
            Object r11 = d.n.f(r10);     // Catch: Throwable -> L21
        L23:
            Throwable r12 = d.n.c(r11);
            if (r12 == null) goto L27;
            ILogDepend.Companion.e(TaskManagerImpl.TAG, "onOmniTaskEnd notify nlp failed", r12);
        L27:
            return x.f38692a;
        L18:
            r10 = null;
        L21:
            th = move-exception;
            d.n.a r13 = d.n.f38560a;
            r11 = d.n.f(d.o.a(th));
            goto L23
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            d.o.a(r7);
            am r14 = (am) ZeusTransformUtils.preCheckCast(this.f, am.class, "com.obric.aiagent.plugin");
            IEventTaskRecordApi r15 = (IEventTaskRecordApi) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IEventTaskRecordApi.class), IEventTaskRecordApi.class, "com.obric.aiagent.plugin");
            if (r15 == null) goto L14;
            List<EventTaskExecutionRecord> r16 = p.a(this.f16584b);
            d.c.d<? super List<EventTaskExecutionRecord>> r17 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f = r14;
            this.f16583a = 1;
            r7 = r15.addExecutionRecords(r16, r17);
            if (r7 != r0) goto L13;
            return r0;
        }
    }

    /* JADX INFO: compiled from: TaskManagerImpl.kt */
    @d.c.b.a.f(b = "TaskManagerImpl.kt", c = {359}, d = "setKnowledge", e = "com.obric.aiagent.executionengine.eventstaskmanager.TaskManagerImpl")
    static final class k extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        /* synthetic */ Object f16588a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ TaskManagerImpl f16589b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int f16590c;

        k(TaskManagerImpl r3, d.c.d<? super k> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f16589b = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r12) {
            this.f16588a = r12;
            this.f16590c |= Integer.MIN_VALUE;
            return this.f16589b.setKnowledge(null, 0, null, null, null, false, null, null, false, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: TaskManagerImpl.kt */
    public static final class l implements com.obric.aiagent.executionengine.eventstaskmanager.a.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.obric.eventkit.e f16591a;

        l(com.obric.eventkit.e r3) {
            this.f16591a = (com.obric.eventkit.e) ZeusTransformUtils.wrapperContextForParams(r3, com.obric.eventkit.e.class, "com.obric.aiagent.plugin");
        }

        @Override // com.obric.aiagent.executionengine.eventstaskmanager.a.a.d
        public boolean a(String r2) {
            d.h.b.o.e(r2, "content");
            return this.f16591a.a(r2);
        }
    }

    /* JADX INFO: compiled from: TaskManagerImpl.kt */
    @d.c.b.a.f(b = "TaskManagerImpl.kt", c = {394}, d = "setKnowledgeLearningSwitch", e = "com.obric.aiagent.executionengine.eventstaskmanager.TaskManagerImpl")
    static final class m extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        /* synthetic */ Object f16592a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ TaskManagerImpl f16593b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int f16594c;

        m(TaskManagerImpl r3, d.c.d<? super m> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f16593b = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f16592a = r3;
            this.f16594c |= Integer.MIN_VALUE;
            return this.f16593b.setKnowledgeLearningSwitch(null, 0, false, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: TaskManagerImpl.kt */
    @d.c.b.a.f(b = "TaskManagerImpl.kt", c = {330}, d = "setLocation", e = "com.obric.aiagent.executionengine.eventstaskmanager.TaskManagerImpl")
    static final class n extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f16595a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        /* synthetic */ Object f16596b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ TaskManagerImpl f16597c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        int f16598d;

        n(TaskManagerImpl r3, d.c.d<? super n> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f16597c = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r10) {
            this.f16596b = r10;
            this.f16598d |= Integer.MIN_VALUE;
            return this.f16597c.setLocation(null, 0.0d, 0.0d, null, null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: TaskManagerImpl.kt */
    @d.c.b.a.f(b = "TaskManagerImpl.kt", c = {115}, d = "tryRecoverFromSleepMode", e = "com.obric.aiagent.executionengine.eventstaskmanager.TaskManagerImpl")
    static final class o extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f16599a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f16600b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int f16601c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        /* synthetic */ Object f16602d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ TaskManagerImpl f16603e;
        int f;

        o(TaskManagerImpl r3, d.c.d<? super o> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f16603e = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f16602d = r3;
            this.f |= Integer.MIN_VALUE;
            return this.f16603e.tryRecoverFromSleepMode(null, 0, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    static {
        Companion = new a(null);
    }

    public TaskManagerImpl() {
        this.operationScope = an.a(cx.a(null, 1, null).plus((d.c.g) ZeusTransformUtils.preCheckCast(com.obric.aiagent.executionengine.eventstaskmanager.common.a.f16677a.b(), d.c.g.class, "com.obric.aiagent.plugin")));
        this.hasInit = new AtomicBoolean(false);
        this.shortcutsPkgName = "";
        this.mTimeChangeReceiver = new h(this);
    }

    public static final /* synthetic */ void access$refreshAllTaskAfterTimeChange(TaskManagerImpl r0) {
        r0.refreshAllTaskAfterTimeChange();
    }

    @Override // com.obric.eventkit.ITaskManagerApi
    public void init(Application r9) {
        Application r10 = (Application) ZeusTransformUtils.wrapperContextForParams(r9, Application.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r10, "application");
        if (this.hasInit.compareAndSet(false, true) == true) goto L6;
        ILogDepend.Companion.i(TAG, "init: already done, skip");
        return;
    L6:
        ILogDepend.Companion.i(TAG, "init: called");
        initSDKConfig(r10);
        com.obric.aiagent.executionengine.eventstaskmanager.timertask.b.f17879a.a();
        com.obric.aiagent.executionengine.eventstaskmanager.autoaction.a.f16671a.a();
        com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.b.f16741a.a((Context) ZeusTransformUtils.preCheckCast(r10, Context.class, "com.obric.aiagent.plugin"));
        com.obric.event.task.base.c.a.f32688a.c();
        com.obric.aiagent.executionengine.eventstaskmanager.timertask.a.f17861a.a();
        kotlinx.coroutines.i.a(this.operationScope, null, null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new e(null), d.h.a.m.class, "com.obric.aiagent.plugin"), 3, null);
        IAutoTaskApi r0 = (IAutoTaskApi) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IAutoTaskApi.class), IAutoTaskApi.class, "com.obric.aiagent.plugin");
        if (r0 == null) goto L9;
        Context r11 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r10.getApplicationContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        d.h.b.o.c(r11, "getApplicationContext(...)");
        r0.syncPinShortcut(r11);
    L9:
        IntentFilter r12 = new IntentFilter("android.intent.action.TIME_SET");
        ZeusTransformUtils.registerReceiver((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(IAppContext.Companion.getApplication(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin"), (PluginBroadcastReceiver) ZeusTransformUtils.preCheckCast(this.mTimeChangeReceiver, PluginBroadcastReceiver.class, "com.obric.aiagent.plugin"), r12, "com.obric.aiagent.plugin");
    }

    @Override // com.obric.eventkit.ITaskManagerApi
    public Object getEnableShortInstructShortcutTasks(d.c.d<? super List<ShortcutTask>> r2) {
        d.c.d<? super List<ShortcutTask>> r1 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r2, d.c.d.class, "com.obric.aiagent.plugin");
        return com.obric.aiagent.executionengine.eventstaskmanager.shortcuttask.a.f17459a.a(r1);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:19:0x00a2 -> B:21:0x00a5). Please report as a decompilation issue!!! */
    @Override // com.obric.eventkit.ITaskManagerApi
    public Object tryRecoverFromSleepMode(String r9, int r10, d.c.d<? super x> r11) {
        d.c.d r12 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r11, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r12, o.class) == false) goto L7;
        o r0 = (o) ZeusTransformUtils.preCheckCast(r12, o.class, "com.obric.aiagent.plugin");
        if ((r0.f & Integer.MIN_VALUE) == 0) goto L7;
        r0.f -= Integer.MIN_VALUE;
    L8:
        Object r8 = r0.f16602d;
        Object r13 = d.c.a.b.a();
        int r2 = r0.f;
        if (r2 == 0) goto L14;
        if (r2 != 1) goto L13;
        int r14 = r0.f16601c;
        int r15 = r0.f16600b;
        IObricSleepModeManager r1 = (IObricSleepModeManager) ZeusTransformUtils.preCheckCast(r0.f16599a, IObricSleepModeManager.class, "com.obric.aiagent.plugin");
        d.o.a(r8);
    L22:
        if (r1.inSleepMode() == true) goto L25;
        ILogDepend.Companion.i(TAG, "try recovery from sleep mode success");
        return x.f38692a;
    L25:
        r14 = r14 + 1;
    L17:
        if (r14 >= r15) goto L26;
        r0.f16599a = r1;
        r0.f16600b = r15;
        r0.f16601c = r14;
        r0.f = 1;
        if (ax.a(2000, r0) != r13) goto L22;
        return r13;
    L26:
        ILogDepend.Companion.i(TAG, "try recovery from sleep mode failed");
    L29:
        return x.f38692a;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        d.o.a(r8);
        IObricSleepModeManager r16 = ObricProductSdk.INSTANCE.platformService().sleepModeManager();
        if (r16.inSleepMode() == false) goto L27;
        ILogDepend.Companion.i(TAG, "in sleep mode try recovery from sleep mode");
        r16.forceExitSleepMode("com.obric.assistantaiagent", r9 + '#' + r10);
        r1 = r16;
        r15 = 30;
        r14 = 0;
        goto L17
    L27:
        ILogDepend.Companion.i(TAG, "not in sleep mode ");
    L7:
        r0 = new o(this, r12);
        goto L8
    }

    @Override // com.obric.eventkit.ITaskManagerApi
    public void onLoginStateChange(boolean r10) {
        notifyShortCutsRefresh();
        IAutoTaskApi r0 = (IAutoTaskApi) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IAutoTaskApi.class), IAutoTaskApi.class, "com.obric.aiagent.plugin");
        if (r0 == null) goto L5;
        r0.syncPinShortcut((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(IAppContext.Companion.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"));
    L5:
        kotlinx.coroutines.i.a(this.operationScope, null, null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new i(r10, null), d.h.a.m.class, "com.obric.aiagent.plugin"), 3, null);
    }

    @Override // com.obric.eventkit.ITaskManagerApi
    public void setShortcutsActivityPkgName(String r2) {
        d.h.b.o.e(r2, "pkgName");
        this.shortcutsPkgName = r2;
    }

    @Override // com.obric.eventkit.ITaskManagerApi
    public boolean updateEventTaskDisplayOrder(int r4, List<String> r5) {
        List<String> r3 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r3, "orderedTaskIds");
        String r6 = IAppContext.Companion.getPackageName();
        boolean r1 = true;
        if (r4 == 2) goto L11;
        if (r4 == 3) goto L8;
    L6:
        r1 = false;
    L12:
        ILogDepend.Companion.i(TAG, "updateEventTaskDisplayOrder type=" + r4 + ", count=" + r3.size() + ", success=" + r1);
        return r1;
    L8:
        if (com.obric.aiagent.executionengine.eventstaskmanager.shortcuttask.a.f17459a.a(r6, r3).getCode() != 0) goto L6;
    L11:
        if (com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.b.f16741a.a(r6, r3).getCode() != 0) goto L6;
        goto L6
    }

    @Override // com.obric.eventkit.ITaskManagerApi
    public ConditionTaskResult updateConditionTask(String r19, List<ConditionTaskAction> r20, String r21, ConditionGroup r22, PeriodicPolicy r23, TriggerControlPolicy r24, Integer r25, Map<String, String> r26, int r27, TaskKnowledge r28, String r29) {
        List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r20, List.class, "com.obric.aiagent.plugin");
        Map r11 = (Map) ZeusTransformUtils.wrapperContextForParams(r26, Map.class, "com.obric.aiagent.plugin");
        String r3 = com.obric.aiagent.executionengine.eventstaskmanager.timertask.a.a.f17874a.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(IAppContext.Companion.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"));
        return com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.b.a(com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.b.f16741a, r3, r19, r5, r21, r22, r23, r24, r25, r11, r27, r28, r29, null, 4096, null);
    }

    private final void notifyShortCutsRefresh() {
        String r2 = this.shortcutsPkgName;
        com.obric.aiagent.executionengine.eventstaskmanager.b.f16672a.a(r2, 1);
        com.obric.aiagent.executionengine.eventstaskmanager.b.f16672a.a(r2, 2);
        com.obric.aiagent.executionengine.eventstaskmanager.b.f16672a.a(r2, 3);
        com.obric.aiagent.executionengine.eventstaskmanager.b.f16672a.a(r2, 4);
        com.obric.aiagent.executionengine.eventstaskmanager.b.f16672a.a(r2, 5);
        com.obric.aiagent.executionengine.eventstaskmanager.b.f16672a.a(r2, 6);
        com.obric.aiagent.executionengine.eventstaskmanager.b.f16672a.a(r2, 7);
        com.obric.aiagent.executionengine.eventstaskmanager.b.f16672a.a(r2, 8);
    }

    private final void refreshAllTaskAfterTimeChange() {
        com.obric.aiagent.executionengine.eventstaskmanager.timertask.b.f17879a.c();
    }

    private final void initSDKConfig(Application r2) {
        EventsTaskSdk.init(new EventsTaskSdk.InitConfig((Application) ZeusTransformUtils.wrapperContextForParams(r2, Application.class, "com.obric.aiagent.plugin")));
        EventsTaskSdk.setLogger((ILogger) ZeusTransformUtils.preCheckCast(new f(), ILogger.class, "com.obric.aiagent.plugin"));
    }

    @Override // com.obric.eventkit.ITaskManagerApi
    public String getConditionTaskV2() {
        String r3 = getConditionSettingWithColdStartFallback(com.obric.event.task.base.c.a.f32688a.a());
        ILogDepend.Companion.i(TAG, "getConditionTaskV2: " + r3);
        if (r3 != null) goto L6;
        return "true";
    L6:
        return r3;
    }

    @Override // com.obric.eventkit.ITaskManagerApi
    public List<String> getSmsConditionTypeList() {
        String r8 = getConditionSettingWithColdStartFallback(com.obric.event.task.base.c.a.f32688a.b());
        ILogDepend.Companion.i(TAG, "getSmsConditionTypeList: " + r8);
        if (r8 == null) goto L13;
        List r9 = d.o.o.b((CharSequence) ZeusTransformUtils.preCheckCast(r8, CharSequence.class, "com.obric.aiagent.plugin"), new String[]{","}, false, 0, 6, null);
        if (r9 == null) goto L13;
        Iterable r10 = (Iterable) ZeusTransformUtils.preCheckCast(r9, Iterable.class, "com.obric.aiagent.plugin");
        Collection r0 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");
        Iterator r11 = r10.iterator();
    L8:
        if (r11.hasNext() == false) goto L20;
        Object r2 = r11.next();
        if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast((String) ZeusTransformUtils.preCheckCast(r2, String.class, "com.obric.aiagent.plugin"), CharSequence.class, "com.obric.aiagent.plugin"))) == false) goto L8;
        r0.add(r2);
        goto L8
    L20:
        return (List) ZeusTransformUtils.preCheckCast(r0, List.class, "com.obric.aiagent.plugin");
    L13:
        return null;
    }

    private final String getConditionSettingWithColdStartFallback(String r9) {
        String r8 = com.obric.event.task.base.c.a.f32688a.a(r9);
        CharSequence r0 = (CharSequence) ZeusTransformUtils.preCheckCast(r8, CharSequence.class, "com.obric.aiagent.plugin");
        if (r0 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == false) goto L12;
        com.obric.event.task.base.c.a.f32688a.d();
        return com.obric.event.task.base.c.a.f32688a.a(r9);
    L12:
        kotlinx.coroutines.i.a((am) ZeusTransformUtils.preCheckCast(bs.f39169a, am.class, "com.obric.aiagent.plugin"), (d.c.g) ZeusTransformUtils.preCheckCast(bd.c(), d.c.g.class, "com.obric.aiagent.plugin"), null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new b(null), d.h.a.m.class, "com.obric.aiagent.plugin"), 2, null);
        return r8;
    L5:
        if (r0.length() == 0) goto L8;
        r1 = false;
        goto L9
    }

    @Override // com.obric.eventkit.ITaskManagerApi
    public Object setLocation(String r13, double r14, double r16, String r18, String r19, d.c.d<? super Boolean> r20) {
        d.c.d r0 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r20, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r0, n.class) == false) goto L7;
        n r2 = (n) ZeusTransformUtils.preCheckCast(r0, n.class, "com.obric.aiagent.plugin");
        if ((r2.f16598d & Integer.MIN_VALUE) == 0) goto L7;
        r2.f16598d -= Integer.MIN_VALUE;
    L8:
        n r11 = r2;
        Object r1 = r11.f16596b;
        Object r3 = d.c.a.b.a();
        int r4 = r11.f16598d;
        if (r4 == 0) goto L14;
        if (r4 != 1) goto L13;
        String r5 = (String) ZeusTransformUtils.preCheckCast(r11.f16595a, String.class, "com.obric.aiagent.plugin");
        d.o.a(r1);
        Object r6 = r1;
        String r7 = r5;
    L17:
        MemoryResponse r8 = (MemoryResponse) ZeusTransformUtils.preCheckCast(r6, MemoryResponse.class, "com.obric.aiagent.plugin");
        boolean r9 = r8.isSuccess();
        if (r9 == false) goto L20;
        ILogDepend.Companion.i(TAG, "setLocation success, type: " + r7);
    L22:
        return d.c.b.a.b.a(r9);
    L20:
        ILogDepend.Companion.e(TAG, "setLocation failed, type: " + r7 + ", code: " + r8.getCode() + ", msg: " + r8.getMessage());
        goto L22
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        d.o.a(r1);
        com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.handler.d r10 = com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.handler.d.f17179a;
        r7 = r13;
        r11.f16595a = r7;
        r11.f16598d = 1;
        r6 = r10.a(r13, r14, r16, r18, r19, r11);
        if (r6 != r3) goto L17;
        return r3;
    L7:
        r2 = new n(this, r0);
        goto L8
    }

    @Override // com.obric.eventkit.ITaskManagerApi
    public Object setKnowledge(String r15, int r16, String r17, String r18, Integer r19, boolean r20, com.obric.eventkit.e r21, String r22, boolean r23, d.c.d<? super com.obric.eventkit.g> r24) {
        com.obric.eventkit.e r0 = (com.obric.eventkit.e) ZeusTransformUtils.wrapperContextForParams(r21, com.obric.eventkit.e.class, "com.obric.aiagent.plugin");
        d.c.d r2 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r24, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r2, k.class) == false) goto L7;
        k r3 = (k) ZeusTransformUtils.preCheckCast(r2, k.class, "com.obric.aiagent.plugin");
        if ((r3.f16590c & Integer.MIN_VALUE) == 0) goto L7;
        r3.f16590c -= Integer.MIN_VALUE;
    L8:
        k r13 = r3;
        Object r4 = r13.f16588a;
        Object r5 = d.c.a.b.a();
        int r6 = r13.f16590c;
        if (r6 == 0) goto L14;
        if (r6 != 1) goto L13;
        d.o.a(r4);
    L21:
        com.obric.aiagent.executionengine.eventstaskmanager.a.a.f r1 = (com.obric.aiagent.executionengine.eventstaskmanager.a.a.f) ZeusTransformUtils.preCheckCast(r4, com.obric.aiagent.executionengine.eventstaskmanager.a.a.f.class, "com.obric.aiagent.plugin");
        return new com.obric.eventkit.g(r1.a(), r1.b());
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        d.o.a(r4);
        if (r0 == null) goto L17;
        l r7 = new l(r0);
    L18:
        com.obric.aiagent.executionengine.eventstaskmanager.a.a.c r8 = new com.obric.aiagent.executionengine.eventstaskmanager.a.a.c((com.obric.aiagent.executionengine.eventstaskmanager.a.a.d) ZeusTransformUtils.preCheckCast(r7, com.obric.aiagent.executionengine.eventstaskmanager.a.a.d.class, "com.obric.aiagent.plugin"), null, 2, null);
        r13.f16590c = 1;
        r4 = r8.a(r15, r16, r17, r18, r19, r20, r22, r23, r13);
        if (r4 != r5) goto L21;
        return r5;
    L17:
        r7 = null;
    L7:
        r3 = new k(this, r2);
        goto L8
    }

    @Override // com.obric.eventkit.ITaskManagerApi
    public Object getKnowledge(String r3, d.c.d<? super String> r4) {
        d.c.d<? super String> r2 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
        return new com.obric.aiagent.executionengine.eventstaskmanager.a.a.c(null, null, 3, null).a(r3, r2);
    }

    @Override // com.obric.eventkit.ITaskManagerApi
    public Object isKnowledgeLearningSwitchOn(String r7, d.c.d<? super Boolean> r8) {
        d.c.d r9 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r8, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r9, g.class) == false) goto L7;
        g r0 = (g) ZeusTransformUtils.preCheckCast(r9, g.class, "com.obric.aiagent.plugin");
        if ((r0.f16577d & Integer.MIN_VALUE) == 0) goto L7;
        r0.f16577d -= Integer.MIN_VALUE;
    L8:
        Object r6 = r0.f16575b;
        Object r10 = d.c.a.b.a();
        int r2 = r0.f16577d;
        String r3 = null;
        if (r2 == 0) goto L14;
        if (r2 != 1) goto L13;
        r7 = (String) ZeusTransformUtils.preCheckCast(r0.f16574a, String.class, "com.obric.aiagent.plugin");
        d.o.a(r6);
    L17:
        TaskKnowledge r11 = (TaskKnowledge) ZeusTransformUtils.preCheckCast(r6, TaskKnowledge.class, "com.obric.aiagent.plugin");
        if (r11 == null) goto L20;
        boolean r12 = r11.getLearningSwitch();
    L21:
        ILogDepend.Companion r1 = ILogDepend.Companion;
        StringBuilder r13 = new StringBuilder().append("isKnowledgeLearningSwitchOn: taskId=").append(r7).append(", enabled=").append(r12).append(" (rawLearningSwitch=");
        if (r11 == null) goto L24;
        Boolean r4 = d.c.b.a.b.a(r11.getLearningSwitch());
    L25:
        StringBuilder r14 = r13.append(r4).append(", knowledgeNull=");
        boolean r5 = false;
        if (r11 != null) goto L28;
        boolean r15 = true;
    L29:
        StringBuilder r16 = r14.append(r15).append(", hasContent=");
        if (r11 == null) goto L32;
        r3 = r11.getContent();
    L32:
        CharSequence r17 = (CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.aiagent.plugin");
        if (r17 != null) goto L35;
    L36:
        r5 = true;
    L37:
        r1.i(TAG, r16.append(!r5).append(')').toString());
        return d.c.b.a.b.a(r12);
    L35:
        if (r17.length() != 0) goto L37;
    L28:
        r15 = false;
        goto L29
    L24:
        r4 = null;
        goto L25
    L20:
        r12 = true;
        goto L21
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        d.o.a(r6);
        com.obric.aiagent.executionengine.eventstaskmanager.a.a.c r18 = new com.obric.aiagent.executionengine.eventstaskmanager.a.a.c(null, null, 3, null);
        r0.f16574a = r7;
        r0.f16577d = 1;
        r6 = r18.b(r7, r0);
        if (r6 != r10) goto L17;
        return r10;
    L7:
        r0 = new g(this, r9);
        goto L8
    }

    @Override // com.obric.eventkit.ITaskManagerApi
    public Object setKnowledgeLearningSwitch(String r6, int r7, boolean r8, d.c.d<? super com.obric.eventkit.g> r9) {
        d.c.d r10 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r9, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r10, m.class) == false) goto L7;
        m r0 = (m) ZeusTransformUtils.preCheckCast(r10, m.class, "com.obric.aiagent.plugin");
        if ((r0.f16594c & Integer.MIN_VALUE) == 0) goto L7;
        r0.f16594c -= Integer.MIN_VALUE;
    L8:
        Object r5 = r0.f16592a;
        Object r11 = d.c.a.b.a();
        int r2 = r0.f16594c;
        if (r2 == 0) goto L14;
        if (r2 != 1) goto L13;
        d.o.a(r5);
    L17:
        com.obric.aiagent.executionengine.eventstaskmanager.a.a.f r12 = (com.obric.aiagent.executionengine.eventstaskmanager.a.a.f) ZeusTransformUtils.preCheckCast(r5, com.obric.aiagent.executionengine.eventstaskmanager.a.a.f.class, "com.obric.aiagent.plugin");
        return new com.obric.eventkit.g(r12.a(), r12.b());
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        d.o.a(r5);
        ILogDepend.Companion.i(TAG, "setKnowledgeLearningSwitch: taskId=" + r6 + ", taskType=" + r7 + ", enabled=" + r8);
        com.obric.aiagent.executionengine.eventstaskmanager.a.a.c r13 = new com.obric.aiagent.executionengine.eventstaskmanager.a.a.c(null, null, 3, null);
        r0.f16594c = 1;
        r5 = r13.a(r6, r7, r8, r0);
        if (r5 != r11) goto L17;
        return r11;
    L7:
        r0 = new m(this, r10);
        goto L8
    }

    @Override // com.obric.eventkit.ITaskManagerApi
    public Object getKnowledgeForNet(List<String> r7, com.obric.eventkit.b r8, d.c.d<? super com.obric.eventkit.f<com.obric.eventkit.d>> r9) {
        List<String> r10 = (List) ZeusTransformUtils.wrapperContextForParams(r7, List.class, "com.obric.aiagent.plugin");
        com.obric.eventkit.b r11 = (com.obric.eventkit.b) ZeusTransformUtils.wrapperContextForParams(r8, com.obric.eventkit.b.class, "com.obric.aiagent.plugin");
        d.c.d r12 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r9, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r12, c.class) == false) goto L7;
        c r0 = (c) ZeusTransformUtils.preCheckCast(r12, c.class, "com.obric.aiagent.plugin");
        if ((r0.f16568c & Integer.MIN_VALUE) == 0) goto L7;
        r0.f16568c -= Integer.MIN_VALUE;
    L8:
        Object r6 = r0.f16566a;
        Object r13 = d.c.a.b.a();
        int r2 = r0.f16568c;
        String r3 = null;
        boolean r4 = true;
        if (r2 == 0) goto L14;
        if (r2 != 1) goto L13;
        d.o.a(r6);
    L17:
        com.obric.aiagent.executionengine.eventstaskmanager.a.a.e r14 = (com.obric.aiagent.executionengine.eventstaskmanager.a.a.e) ZeusTransformUtils.preCheckCast(r6, com.obric.aiagent.executionengine.eventstaskmanager.a.a.e.class, "com.obric.aiagent.plugin");
        if (r14 != null) goto L20;
    L22:
        r4 = false;
    L23:
        if (r14 == null) goto L31;
        com.obric.aiagent.executionengine.eventstaskmanager.a.a.a.c r15 = (com.obric.aiagent.executionengine.eventstaskmanager.a.a.a.c) ZeusTransformUtils.preCheckCast(r14.b(), com.obric.aiagent.executionengine.eventstaskmanager.a.a.a.c.class, "com.obric.aiagent.plugin");
        if (r15 == null) goto L31;
        Iterable r16 = (Iterable) ZeusTransformUtils.preCheckCast(r15.a(), Iterable.class, "com.obric.aiagent.plugin");
        Collection r17 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(p.a(r16, 10)), Collection.class, "com.obric.aiagent.plugin");
        Iterator r18 = r16.iterator();
    L28:
        if (r18.hasNext() == false) goto L30;
        com.obric.aiagent.executionengine.eventstaskmanager.a.a.a.a r19 = (com.obric.aiagent.executionengine.eventstaskmanager.a.a.a.a) ZeusTransformUtils.preCheckCast(r18.next(), com.obric.aiagent.executionengine.eventstaskmanager.a.a.a.a.class, "com.obric.aiagent.plugin");
        r17.add(new com.obric.eventkit.a(r19.a(), r19.b(), r19.c()));
        goto L28
    L30:
        com.obric.eventkit.d r20 = new com.obric.eventkit.d((List) ZeusTransformUtils.preCheckCast(r17, List.class, "com.obric.aiagent.plugin"));
    L32:
        if (r14 == null) goto L35;
        r3 = r14.c();
    L35:
        return new com.obric.eventkit.f(r4, r20, r3);
    L31:
        r20 = null;
        goto L32
    L20:
        if (r14.a() != true) goto L22;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        d.o.a(r6);
        com.obric.aiagent.executionengine.eventstaskmanager.a.a.c r21 = new com.obric.aiagent.executionengine.eventstaskmanager.a.a.c(null, (com.obric.aiagent.executionengine.eventstaskmanager.a.a.a) ZeusTransformUtils.preCheckCast(new d(r11), com.obric.aiagent.executionengine.eventstaskmanager.a.a.a.class, "com.obric.aiagent.plugin"), 1, null);
        r0.f16568c = 1;
        r6 = r21.a(r10, r0);
        if (r6 != r13) goto L17;
        return r13;
    L7:
        r0 = new c(this, r12);
        goto L8
    }

    @Override // com.obric.eventkit.ITaskManagerApi
    public void onTaskScheduleStart(String r1, int r2, String r3) {
        com.obric.event.task.base.report.i.f32779a.a(r1, r2, r3);
    }

    @Override // com.obric.eventkit.ITaskManagerApi
    public void onTaskScheduleMessageSent(String r7) {
        com.obric.event.task.base.report.i.a(com.obric.event.task.base.report.i.f32779a, r7, 0, null, 6, null);
    }

    @Override // com.obric.eventkit.ITaskManagerApi
    public void onTaskScheduleFailed(String r1, int r2, String r3) {
        com.obric.event.task.base.report.i.f32779a.b(r1, r2, r3);
    }

    @Override // com.obric.eventkit.ITaskManagerApi
    public void onOmniTaskEnd(EventTaskExecutionRecord r9, String r10, int r11, String r12) {
        d.h.b.o.e(r9, "record");
        kotlinx.coroutines.i.a(this.operationScope, null, null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new j(r9, r10, r11, r12, null), d.h.a.m.class, "com.obric.aiagent.plugin"), 3, null);
    }
}
