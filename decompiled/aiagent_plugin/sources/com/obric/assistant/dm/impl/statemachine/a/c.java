package com.obric.assistant.dm.impl.statemachine.a;

import com.obric.agent.complextask.IComplexTaskService;
import com.obric.aiagent.assistant.idl.bean.IMMessage;
import com.obric.aiagent.platform.depend.ILogDepend;
import com.obric.aiagent.platform.depend.ISecureLogDepend;
import com.obric.assistant.dm.api.statemachine.core.ComplexTaskEvent;
import com.obric.assistant.dm.api.statemachine.core.ComplexTaskState;
import com.obric.assistant.dm.api.statemachine.core.DMEvent;
import com.obric.assistant.dm.api.statemachine.core.DMState;
import com.obric.assistant.dm.api.statemachine.core.OAutoTaskEvent;
import com.obric.assistant.dm.api.statemachine.core.OAutoTaskState;
import com.obric.assistant.dm.api.statemachine.core.SimpleTaskEvent;
import com.obric.assistant.dm.api.statemachine.core.SimpleTaskState;
import com.obric.assistant.dm.api.statemachine.core.State;
import com.obric.assistant.dm.api.statemachine.core.TaskId;
import com.obric.assistant.dm.api.statemachine.core.TaskInfo;
import com.obric.assistant.dm.api.statemachine.core.TaskType;
import com.obric.livecard.api.entity.IslandSession;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import com.ss.android.socialbase.downloader.constants.DownloadConstants;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.ao;
import d.a.p;
import d.c.b.a.l;
import d.c.g;
import d.h.a.m;
import d.h.b.aa;
import d.o;
import d.s;
import d.x;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import kotlinx.coroutines.am;
import kotlinx.coroutines.ax;
import kotlinx.coroutines.bd;
import kotlinx.coroutines.bs;
import kotlinx.coroutines.ca;
import kotlinx.coroutines.i;

/* JADX INFO: compiled from: DialogStateMachine.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class c {
    private static final String TAG = "DialogStateMachine";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f22509a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final LinkedHashMap<TaskId, TaskInfo> f22510b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final LinkedHashMap<TaskId, com.obric.assistant.dm.api.statemachine.core.d<?, ?>> f22511c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static boolean f22512d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final Map<String, IMMessage> f22513e = null;
    private static IslandSession f;
    private static final CopyOnWriteArrayList<com.obric.assistant.dm.api.statemachine.core.b> g = null;
    private static final ReentrantReadWriteLock h = null;
    private static ca i;

    /* JADX INFO: compiled from: DialogStateMachine.kt */
    public static final class a implements com.obric.assistant.dm.api.statemachine.core.e<ComplexTaskState> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ TaskInfo f22514a;

        /* JADX INFO: renamed from: com.obric.assistant.dm.impl.statemachine.a.c$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: DialogStateMachine.kt */
        @d.c.b.a.f(b = "DialogStateMachine.kt", c = {435}, d = "invokeSuspend", e = "com.obric.assistant.dm.impl.statemachine.core.DialogStateMachine$createComplexTaskStateListener$1$onStateChanged$1")
        static final class C0489a extends l implements m<am, d.c.d<? super x>, Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            int f22515a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ TaskInfo f22516b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final /* synthetic */ ComplexTaskState f22517c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            final /* synthetic */ ComplexTaskState f22518d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            final /* synthetic */ DMEvent f22519e;

            C0489a(TaskInfo r3, ComplexTaskState r4, ComplexTaskState r5, DMEvent r6, d.c.d<? super C0489a> r7) {
                d.c.d r8 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r7, d.c.d.class, "com.obric.aiagent.plugin");
                this.f22516b = r3;
                this.f22517c = r4;
                this.f22518d = r5;
                this.f22519e = r6;
                super(2, r8);
            }

            public final Object a(am r3, d.c.d<? super x> r4) {
                return ((C0489a) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), C0489a.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
            }

            @Override // d.c.b.a.a
            public final d.c.d<x> create(Object r8, d.c.d<?> r9) {
                d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r9, d.c.d.class, "com.obric.aiagent.plugin");
                return (d.c.d) ZeusTransformUtils.preCheckCast(new C0489a(this.f22516b, this.f22517c, this.f22518d, this.f22519e, r6), d.c.d.class, "com.obric.aiagent.plugin");
            }

            @Override // d.h.a.m
            public /* synthetic */ Object invoke(am r3, d.c.d<? super x> r4) {
                return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
            }

            @Override // d.c.b.a.a
            public final Object invokeSuspend(Object r8) {
                Object r0 = d.c.a.b.a();
                int r1 = this.f22515a;
                if (r1 == 0) goto L8;
                if (r1 != 1) goto L7;
                o.a(r8);
            L26:
                if (ZeusTransformUtils.instanceOf(this.f22518d, ComplexTaskState.Terminated.class) == false) goto L35;
                Map<String, String> r9 = this.f22516b.getExt();
                if (r9 == null) goto L35;
                Iterator<Map.Entry<String, String>> r2 = ((ComplexTaskState.Terminated) ZeusTransformUtils.preCheckCast(this.f22518d, ComplexTaskState.Terminated.class, "com.obric.aiagent.plugin")).getExtra().entrySet().iterator();
            L31:
                if (r2.hasNext() == false) goto L35;
                Map.Entry r3 = (Map.Entry) ZeusTransformUtils.preCheckCast(r2.next(), Map.Entry.class, "com.obric.aiagent.plugin");
                String r4 = (String) ZeusTransformUtils.preCheckCast(r3.getKey(), String.class, "com.obric.aiagent.plugin");
                String r5 = (String) ZeusTransformUtils.preCheckCast(r3.getValue(), String.class, "com.obric.aiagent.plugin");
                if (r5 == null) goto L31;
                r9.put(r4, r5);
            L35:
                c.a(c.f22509a, this.f22516b.getTaskId());
            L37:
                return x.f38692a;
            L7:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            L8:
                o.a(r8);
                c.a(c.f22509a, this.f22516b, (State) ZeusTransformUtils.preCheckCast(this.f22517c, State.class, "com.obric.aiagent.plugin"), (State) ZeusTransformUtils.preCheckCast(this.f22518d, State.class, "com.obric.aiagent.plugin"), this.f22519e);
                c.a(c.f22509a);
                if (ZeusTransformUtils.instanceOf(this.f22519e, ComplexTaskEvent.TaskCompleted.class) == false) goto L11;
            L14:
                boolean r10 = true;
            L16:
                if (this.f22518d.isCompletedOrCanceled() == false) goto L37;
                ComplexTaskState r6 = this.f22517c;
                if (r6 == null) goto L37;
                if (r6.isIdle() == false) goto L22;
                if (r10 == false) goto L37;
            L22:
                ILogDepend.Companion.i(c.TAG, "Task " + this.f22516b.getTaskId() + " completed, removing from active tasks");
                d.c.d r11 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
                this.f22515a = 1;
                if (ax.a(10, r11) != r0) goto L26;
                return r0;
            L11:
                if (ZeusTransformUtils.instanceOf(this.f22519e, ComplexTaskEvent.InterruptTask.class) == true) goto L14;
                r10 = false;
                goto L16
            }
        }

        /* JADX INFO: compiled from: DialogStateMachine.kt */
        @d.c.b.a.f(b = "DialogStateMachine.kt", c = {}, d = "invokeSuspend", e = "com.obric.assistant.dm.impl.statemachine.core.DialogStateMachine$createComplexTaskStateListener$1$onTransitionFailed$1")
        static final class b extends l implements m<am, d.c.d<? super x>, Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            int f22520a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ TaskInfo f22521b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final /* synthetic */ ComplexTaskState f22522c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            final /* synthetic */ DMEvent f22523d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            final /* synthetic */ Exception f22524e;

            b(TaskInfo r3, ComplexTaskState r4, DMEvent r5, Exception r6, d.c.d<? super b> r7) {
                d.c.d r8 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r7, d.c.d.class, "com.obric.aiagent.plugin");
                this.f22521b = r3;
                this.f22522c = r4;
                this.f22523d = r5;
                this.f22524e = r6;
                super(2, r8);
            }

            public final Object a(am r3, d.c.d<? super x> r4) {
                return ((b) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), b.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
            }

            @Override // d.c.b.a.a
            public final d.c.d<x> create(Object r8, d.c.d<?> r9) {
                d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r9, d.c.d.class, "com.obric.aiagent.plugin");
                return (d.c.d) ZeusTransformUtils.preCheckCast(new b(this.f22521b, this.f22522c, this.f22523d, this.f22524e, r6), d.c.d.class, "com.obric.aiagent.plugin");
            }

            @Override // d.h.a.m
            public /* synthetic */ Object invoke(am r3, d.c.d<? super x> r4) {
                return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
            }

            @Override // d.c.b.a.a
            public final Object invokeSuspend(Object r5) {
                d.c.a.b.a();
                if (this.f22520a != 0) goto L7;
                o.a(r5);
                c.a(c.f22509a, this.f22521b, (State) ZeusTransformUtils.preCheckCast(this.f22522c, State.class, "com.obric.aiagent.plugin"), this.f22523d, this.f22524e);
                return x.f38692a;
            L7:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        a(TaskInfo r1) {
            this.f22514a = r1;
        }

        @Override // com.obric.assistant.dm.api.statemachine.core.e
        public /* synthetic */ void a(State r3, DMEvent r4, Exception r5) {
            a((ComplexTaskState) ZeusTransformUtils.preCheckCast(r3, ComplexTaskState.class, "com.obric.aiagent.plugin"), r4, r5);
        }

        @Override // com.obric.assistant.dm.api.statemachine.core.e
        public /* synthetic */ void a(State r3, State r4, DMEvent r5) {
            a((ComplexTaskState) ZeusTransformUtils.preCheckCast(r3, ComplexTaskState.class, "com.obric.aiagent.plugin"), (ComplexTaskState) ZeusTransformUtils.preCheckCast(r4, ComplexTaskState.class, "com.obric.aiagent.plugin"), r5);
        }

        public void a(ComplexTaskState r9, ComplexTaskState r10, DMEvent r11) {
            d.h.b.o.e(r10, "newState");
            i.a(com.obric.assistant.dm.impl.statemachine.a.b.f22507a.a(), null, null, (m) ZeusTransformUtils.preCheckCast(new C0489a(this.f22514a, r9, r10, r11, null), m.class, "com.obric.aiagent.plugin"), 3, null);
        }

        public void a(ComplexTaskState r9, DMEvent r10, Exception r11) {
            d.h.b.o.e(r9, "currentState");
            d.h.b.o.e(r11, "exception");
            i.a(com.obric.assistant.dm.impl.statemachine.a.b.f22507a.a(), null, null, (m) ZeusTransformUtils.preCheckCast(new b(this.f22514a, r9, r10, r11, null), m.class, "com.obric.aiagent.plugin"), 3, null);
        }
    }

    /* JADX INFO: compiled from: DialogStateMachine.kt */
    public static final class b implements com.obric.assistant.dm.api.statemachine.core.e<OAutoTaskState> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ TaskInfo f22525a;

        /* JADX INFO: compiled from: DialogStateMachine.kt */
        @d.c.b.a.f(b = "DialogStateMachine.kt", c = {394}, d = "invokeSuspend", e = "com.obric.assistant.dm.impl.statemachine.core.DialogStateMachine$createOAutoTaskStateListener$1$onStateChanged$1")
        static final class a extends l implements m<am, d.c.d<? super x>, Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            int f22526a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ TaskInfo f22527b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final /* synthetic */ OAutoTaskState f22528c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            final /* synthetic */ OAutoTaskState f22529d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            final /* synthetic */ DMEvent f22530e;

            a(TaskInfo r3, OAutoTaskState r4, OAutoTaskState r5, DMEvent r6, d.c.d<? super a> r7) {
                d.c.d r8 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r7, d.c.d.class, "com.obric.aiagent.plugin");
                this.f22527b = r3;
                this.f22528c = r4;
                this.f22529d = r5;
                this.f22530e = r6;
                super(2, r8);
            }

            public final Object a(am r3, d.c.d<? super x> r4) {
                return ((a) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), a.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
            }

            @Override // d.c.b.a.a
            public final d.c.d<x> create(Object r8, d.c.d<?> r9) {
                d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r9, d.c.d.class, "com.obric.aiagent.plugin");
                return (d.c.d) ZeusTransformUtils.preCheckCast(new a(this.f22527b, this.f22528c, this.f22529d, this.f22530e, r6), d.c.d.class, "com.obric.aiagent.plugin");
            }

            @Override // d.h.a.m
            public /* synthetic */ Object invoke(am r3, d.c.d<? super x> r4) {
                return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
            }

            @Override // d.c.b.a.a
            public final Object invokeSuspend(Object r8) {
                Object r0 = d.c.a.b.a();
                int r1 = this.f22526a;
                if (r1 == 0) goto L8;
                if (r1 != 1) goto L7;
                o.a(r8);
            L17:
                c.a(c.f22509a, this.f22527b.getTaskId());
            L19:
                return x.f38692a;
            L7:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            L8:
                o.a(r8);
                c.a(c.f22509a, this.f22527b, (State) ZeusTransformUtils.preCheckCast(this.f22528c, State.class, "com.obric.aiagent.plugin"), (State) ZeusTransformUtils.preCheckCast(this.f22529d, State.class, "com.obric.aiagent.plugin"), this.f22530e);
                c.a(c.f22509a);
                if (this.f22529d.isCompletedOrCanceled() == false) goto L19;
                OAutoTaskState r9 = this.f22528c;
                if (r9 == null) goto L19;
                if (r9.isIdle() == true) goto L19;
                ILogDepend.Companion.i(c.TAG, "Task " + this.f22527b.getTaskId() + " completed, removing from active tasks");
                d.c.d r10 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
                this.f22526a = 1;
                if (ax.a(10, r10) != r0) goto L17;
                return r0;
            }
        }

        /* JADX INFO: renamed from: com.obric.assistant.dm.impl.statemachine.a.c$b$b, reason: collision with other inner class name */
        /* JADX INFO: compiled from: DialogStateMachine.kt */
        @d.c.b.a.f(b = "DialogStateMachine.kt", c = {}, d = "invokeSuspend", e = "com.obric.assistant.dm.impl.statemachine.core.DialogStateMachine$createOAutoTaskStateListener$1$onTransitionFailed$1")
        static final class C0490b extends l implements m<am, d.c.d<? super x>, Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            int f22531a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ TaskInfo f22532b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final /* synthetic */ OAutoTaskState f22533c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            final /* synthetic */ DMEvent f22534d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            final /* synthetic */ Exception f22535e;

            C0490b(TaskInfo r3, OAutoTaskState r4, DMEvent r5, Exception r6, d.c.d<? super C0490b> r7) {
                d.c.d r8 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r7, d.c.d.class, "com.obric.aiagent.plugin");
                this.f22532b = r3;
                this.f22533c = r4;
                this.f22534d = r5;
                this.f22535e = r6;
                super(2, r8);
            }

            public final Object a(am r3, d.c.d<? super x> r4) {
                return ((C0490b) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), C0490b.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
            }

            @Override // d.c.b.a.a
            public final d.c.d<x> create(Object r8, d.c.d<?> r9) {
                d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r9, d.c.d.class, "com.obric.aiagent.plugin");
                return (d.c.d) ZeusTransformUtils.preCheckCast(new C0490b(this.f22532b, this.f22533c, this.f22534d, this.f22535e, r6), d.c.d.class, "com.obric.aiagent.plugin");
            }

            @Override // d.h.a.m
            public /* synthetic */ Object invoke(am r3, d.c.d<? super x> r4) {
                return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
            }

            @Override // d.c.b.a.a
            public final Object invokeSuspend(Object r5) {
                d.c.a.b.a();
                if (this.f22531a != 0) goto L7;
                o.a(r5);
                c.a(c.f22509a, this.f22532b, (State) ZeusTransformUtils.preCheckCast(this.f22533c, State.class, "com.obric.aiagent.plugin"), this.f22534d, this.f22535e);
                return x.f38692a;
            L7:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        b(TaskInfo r1) {
            this.f22525a = r1;
        }

        @Override // com.obric.assistant.dm.api.statemachine.core.e
        public /* synthetic */ void a(State r3, DMEvent r4, Exception r5) {
            a((OAutoTaskState) ZeusTransformUtils.preCheckCast(r3, OAutoTaskState.class, "com.obric.aiagent.plugin"), r4, r5);
        }

        @Override // com.obric.assistant.dm.api.statemachine.core.e
        public /* synthetic */ void a(State r3, State r4, DMEvent r5) {
            a((OAutoTaskState) ZeusTransformUtils.preCheckCast(r3, OAutoTaskState.class, "com.obric.aiagent.plugin"), (OAutoTaskState) ZeusTransformUtils.preCheckCast(r4, OAutoTaskState.class, "com.obric.aiagent.plugin"), r5);
        }

        public void a(OAutoTaskState r9, OAutoTaskState r10, DMEvent r11) {
            d.h.b.o.e(r10, "newState");
            i.a(com.obric.assistant.dm.impl.statemachine.a.b.f22507a.a(), null, null, (m) ZeusTransformUtils.preCheckCast(new a(this.f22525a, r9, r10, r11, null), m.class, "com.obric.aiagent.plugin"), 3, null);
        }

        public void a(OAutoTaskState r9, DMEvent r10, Exception r11) {
            d.h.b.o.e(r9, "currentState");
            d.h.b.o.e(r11, "exception");
            i.a(com.obric.assistant.dm.impl.statemachine.a.b.f22507a.a(), null, null, (m) ZeusTransformUtils.preCheckCast(new C0490b(this.f22525a, r9, r10, r11, null), m.class, "com.obric.aiagent.plugin"), 3, null);
        }
    }

    /* JADX INFO: renamed from: com.obric.assistant.dm.impl.statemachine.a.c$c, reason: collision with other inner class name */
    /* JADX INFO: compiled from: DialogStateMachine.kt */
    public static final class C0491c implements com.obric.assistant.dm.api.statemachine.core.e<SimpleTaskState> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ TaskInfo f22536a;

        /* JADX INFO: renamed from: com.obric.assistant.dm.impl.statemachine.a.c$c$a */
        /* JADX INFO: compiled from: DialogStateMachine.kt */
        @d.c.b.a.f(b = "DialogStateMachine.kt", c = {354}, d = "invokeSuspend", e = "com.obric.assistant.dm.impl.statemachine.core.DialogStateMachine$createSimpleTaskStateListener$1$onStateChanged$1")
        static final class a extends l implements m<am, d.c.d<? super x>, Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            int f22537a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ TaskInfo f22538b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final /* synthetic */ SimpleTaskState f22539c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            final /* synthetic */ SimpleTaskState f22540d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            final /* synthetic */ DMEvent f22541e;

            a(TaskInfo r3, SimpleTaskState r4, SimpleTaskState r5, DMEvent r6, d.c.d<? super a> r7) {
                d.c.d r8 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r7, d.c.d.class, "com.obric.aiagent.plugin");
                this.f22538b = r3;
                this.f22539c = r4;
                this.f22540d = r5;
                this.f22541e = r6;
                super(2, r8);
            }

            public final Object a(am r3, d.c.d<? super x> r4) {
                return ((a) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), a.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
            }

            @Override // d.c.b.a.a
            public final d.c.d<x> create(Object r8, d.c.d<?> r9) {
                d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r9, d.c.d.class, "com.obric.aiagent.plugin");
                return (d.c.d) ZeusTransformUtils.preCheckCast(new a(this.f22538b, this.f22539c, this.f22540d, this.f22541e, r6), d.c.d.class, "com.obric.aiagent.plugin");
            }

            @Override // d.h.a.m
            public /* synthetic */ Object invoke(am r3, d.c.d<? super x> r4) {
                return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
            }

            @Override // d.c.b.a.a
            public final Object invokeSuspend(Object r8) {
                Object r0 = d.c.a.b.a();
                int r1 = this.f22537a;
                if (r1 == 0) goto L8;
                if (r1 != 1) goto L7;
                o.a(r8);
            L17:
                c.a(c.f22509a, this.f22538b.getTaskId());
            L19:
                return x.f38692a;
            L7:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            L8:
                o.a(r8);
                c.a(c.f22509a, this.f22538b, (State) ZeusTransformUtils.preCheckCast(this.f22539c, State.class, "com.obric.aiagent.plugin"), (State) ZeusTransformUtils.preCheckCast(this.f22540d, State.class, "com.obric.aiagent.plugin"), this.f22541e);
                c.a(c.f22509a);
                if (this.f22540d.isCompletedOrCanceled() == false) goto L19;
                SimpleTaskState r9 = this.f22539c;
                if (r9 == null) goto L19;
                if (r9.isIdle() == true) goto L19;
                ILogDepend.Companion.i(c.TAG, "Task " + this.f22538b.getTaskId() + " completed, removing from active tasks");
                d.c.d r10 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
                this.f22537a = 1;
                if (ax.a(10, r10) != r0) goto L17;
                return r0;
            }
        }

        /* JADX INFO: renamed from: com.obric.assistant.dm.impl.statemachine.a.c$c$b */
        /* JADX INFO: compiled from: DialogStateMachine.kt */
        @d.c.b.a.f(b = "DialogStateMachine.kt", c = {}, d = "invokeSuspend", e = "com.obric.assistant.dm.impl.statemachine.core.DialogStateMachine$createSimpleTaskStateListener$1$onTransitionFailed$1")
        static final class b extends l implements m<am, d.c.d<? super x>, Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            int f22542a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ TaskInfo f22543b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final /* synthetic */ SimpleTaskState f22544c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            final /* synthetic */ DMEvent f22545d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            final /* synthetic */ Exception f22546e;

            b(TaskInfo r3, SimpleTaskState r4, DMEvent r5, Exception r6, d.c.d<? super b> r7) {
                d.c.d r8 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r7, d.c.d.class, "com.obric.aiagent.plugin");
                this.f22543b = r3;
                this.f22544c = r4;
                this.f22545d = r5;
                this.f22546e = r6;
                super(2, r8);
            }

            public final Object a(am r3, d.c.d<? super x> r4) {
                return ((b) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), b.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
            }

            @Override // d.c.b.a.a
            public final d.c.d<x> create(Object r8, d.c.d<?> r9) {
                d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r9, d.c.d.class, "com.obric.aiagent.plugin");
                return (d.c.d) ZeusTransformUtils.preCheckCast(new b(this.f22543b, this.f22544c, this.f22545d, this.f22546e, r6), d.c.d.class, "com.obric.aiagent.plugin");
            }

            @Override // d.h.a.m
            public /* synthetic */ Object invoke(am r3, d.c.d<? super x> r4) {
                return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
            }

            @Override // d.c.b.a.a
            public final Object invokeSuspend(Object r5) {
                d.c.a.b.a();
                if (this.f22542a != 0) goto L7;
                o.a(r5);
                c.a(c.f22509a, this.f22543b, (State) ZeusTransformUtils.preCheckCast(this.f22544c, State.class, "com.obric.aiagent.plugin"), this.f22545d, this.f22546e);
                return x.f38692a;
            L7:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        C0491c(TaskInfo r1) {
            this.f22536a = r1;
        }

        @Override // com.obric.assistant.dm.api.statemachine.core.e
        public /* synthetic */ void a(State r3, DMEvent r4, Exception r5) {
            a((SimpleTaskState) ZeusTransformUtils.preCheckCast(r3, SimpleTaskState.class, "com.obric.aiagent.plugin"), r4, r5);
        }

        @Override // com.obric.assistant.dm.api.statemachine.core.e
        public /* synthetic */ void a(State r3, State r4, DMEvent r5) {
            a((SimpleTaskState) ZeusTransformUtils.preCheckCast(r3, SimpleTaskState.class, "com.obric.aiagent.plugin"), (SimpleTaskState) ZeusTransformUtils.preCheckCast(r4, SimpleTaskState.class, "com.obric.aiagent.plugin"), r5);
        }

        public void a(SimpleTaskState r11, SimpleTaskState r12, DMEvent r13) {
            d.h.b.o.e(r12, "newState");
            ILogDepend.Companion r0 = ILogDepend.Companion;
            StringBuilder r1 = new StringBuilder().append("onStateChanged ");
            if (r11 == null) goto L5;
            String r2 = r11.getStateName();
        L6:
            r0.i(c.TAG, r1.append(r2).append(" -> ").append(r12.getStateName()).toString());
            i.a(com.obric.assistant.dm.impl.statemachine.a.b.f22507a.a(), null, null, (m) ZeusTransformUtils.preCheckCast(new a(this.f22536a, r11, r12, r13, null), m.class, "com.obric.aiagent.plugin"), 3, null);
            return;
        L5:
            r2 = null;
            goto L6
        }

        public void a(SimpleTaskState r9, DMEvent r10, Exception r11) {
            d.h.b.o.e(r9, "currentState");
            d.h.b.o.e(r11, "exception");
            i.a(com.obric.assistant.dm.impl.statemachine.a.b.f22507a.a(), null, null, (m) ZeusTransformUtils.preCheckCast(new b(this.f22536a, r9, r10, r11, null), m.class, "com.obric.aiagent.plugin"), 3, null);
        }
    }

    /* JADX INFO: compiled from: DialogStateMachine.kt */
    @d.c.b.a.f(b = "DialogStateMachine.kt", c = {}, d = "invokeSuspend", e = "com.obric.assistant.dm.impl.statemachine.core.DialogStateMachine$setTaskInfoExt$1$1")
    static final class d extends l implements m<am, d.c.d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f22547a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ TaskInfo f22548b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ State f22549c;

        d(TaskInfo r3, State r4, d.c.d<? super d> r5) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            this.f22548b = r3;
            this.f22549c = r4;
            super(2, r6);
        }

        public final Object a(am r3, d.c.d<? super x> r4) {
            return ((d) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), d.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r3, d.c.d<?> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new d(this.f22548b, this.f22549c, r5), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            d.c.a.b.a();
            if (this.f22547a != 0) goto L7;
            o.a(r3);
            c r4 = c.f22509a;
            TaskInfo r0 = this.f22548b;
            State r2 = this.f22549c;
            c.a(r4, r0, r2, r2, null);
            c.a(c.f22509a);
            return x.f38692a;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: compiled from: DialogStateMachine.kt */
    @d.c.b.a.f(b = "DialogStateMachine.kt", c = {}, d = "invokeSuspend", e = "com.obric.assistant.dm.impl.statemachine.core.DialogStateMachine$setTaskProgress$1$1")
    static final class e extends l implements m<am, d.c.d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f22550a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ TaskInfo f22551b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ State f22552c;

        e(TaskInfo r3, State r4, d.c.d<? super e> r5) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            this.f22551b = r3;
            this.f22552c = r4;
            super(2, r6);
        }

        public final Object a(am r3, d.c.d<? super x> r4) {
            return ((e) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), e.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r3, d.c.d<?> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new e(this.f22551b, this.f22552c, r5), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            d.c.a.b.a();
            if (this.f22550a != 0) goto L7;
            o.a(r3);
            c r4 = c.f22509a;
            TaskInfo r0 = this.f22551b;
            State r2 = this.f22552c;
            c.a(r4, r0, r2, r2, null);
            c.a(c.f22509a);
            return x.f38692a;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: compiled from: DialogStateMachine.kt */
    @d.c.b.a.f(b = "DialogStateMachine.kt", c = {638}, d = "invokeSuspend", e = "com.obric.assistant.dm.impl.statemachine.core.DialogStateMachine$startQueryingTimeout$1")
    static final class f extends l implements m<am, d.c.d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f22553a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ List<String> f22554b;

        f(List<String> r3, d.c.d<? super f> r4) {
            List<String> r5 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f22554b = r5;
            super(2, r6);
        }

        public final Object a(am r3, d.c.d<? super x> r4) {
            return ((f) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), f.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r2, d.c.d<?> r3) {
            d.c.d r4 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new f(this.f22554b, r4), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r11) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f22553a;
            boolean r3 = true;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            o.a(r11);
        L11:
            ReentrantReadWriteLock r12 = c.c();
            List<String> r10 = this.f22554b;
            ReentrantReadWriteLock.ReadLock r2 = r12.readLock();
            int r4 = 0;
            if (r12.getWriteHoldCount() != 0) goto L14;
            int r5 = r12.getReadHoldCount();
        L15:
            int r6 = 0;
        L16:
            if (r6 >= r5) goto L18;
            r2.unlock();
            r6 = r6 + 1;
            goto L16
        L18:
            ReentrantReadWriteLock.WriteLock r13 = r12.writeLock();
            r13.lock();
            Iterator r14 = ((Iterable) ZeusTransformUtils.preCheckCast(r10, Iterable.class, "com.obric.aiagent.plugin")).iterator();     // Catch: Throwable -> L34
        L21:
            if (r14.hasNext() == false) goto L25;
            String r7 = (String) ZeusTransformUtils.preCheckCast(r14.next(), String.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L34
            if (c.d().remove(r7) == null) goto L21;
            ILogDepend.Companion.i(c.TAG, "Removed expired query message: " + r7);     // Catch: Throwable -> L34
            goto L21
        L25:
            c r15 = c.f22509a;     // Catch: Throwable -> L34
            if (c.d().isEmpty() == false) goto L29;
            r3 = false;
        L29:
            c.a(r3);     // Catch: Throwable -> L34
            x r16 = x.f38692a;     // Catch: Throwable -> L34
        L30:
            if (r4 >= r5) goto L32;
            r2.lock();
            r4 = r4 + 1;
            goto L30
        L32:
            r13.unlock();
            c.a(c.f22509a);
            return x.f38692a;
        L34:
            th = move-exception;
        L35:
            if (r4 >= r5) goto L37;
            r2.lock();
            r4 = r4 + 1;
            goto L35
        L37:
            r13.unlock();
            throw th;
        L14:
            r5 = 0;
            goto L15
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            o.a(r11);
            d.c.d r17 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f22553a = 1;
            if (ax.a(1000, r17) != r0) goto L11;
            return r0;
        }
    }

    private c() {
    }

    public static final /* synthetic */ void a(c r0) {
        r0.e();
    }

    public static final /* synthetic */ void a(c r0, TaskId r1) {
        r0.b(r1);
    }

    public static final /* synthetic */ void a(c r0, TaskInfo r1, State r2, DMEvent r3, Exception r4) {
        r0.a(r1, r2, r3, r4);
    }

    public static final /* synthetic */ void a(c r0, TaskInfo r1, State r2, State r3, DMEvent r4) {
        r0.a(r1, r2, r3, r4);
    }

    public static final /* synthetic */ void a(boolean r0) {
        f22512d = r0;
    }

    public static final /* synthetic */ ReentrantReadWriteLock c() {
        return h;
    }

    public static final /* synthetic */ Map d() {
        return f22513e;
    }

    static {
        f22509a = new c();
        f22510b = new LinkedHashMap(3, 0.75f, false);
        f22511c = new LinkedHashMap(3, 0.75f, false);
        f22513e = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.aiagent.plugin");
        g = new CopyOnWriteArrayList();
        h = new ReentrantReadWriteLock();
    }

    public final void a(com.obric.assistant.dm.api.statemachine.core.b r8) {
        com.obric.assistant.dm.api.statemachine.core.b r7 = (com.obric.assistant.dm.api.statemachine.core.b) ZeusTransformUtils.wrapperContextForParams(r8, com.obric.assistant.dm.api.statemachine.core.b.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r7, "listener");
        ReentrantReadWriteLock r9 = h;
        ReentrantReadWriteLock.ReadLock r0 = r9.readLock();
        int r2 = 0;
        if (r9.getWriteHoldCount() != 0) goto L5;
        int r1 = r9.getReadHoldCount();
    L6:
        int r3 = 0;
    L7:
        if (r3 >= r1) goto L9;
        r0.unlock();
        r3 = r3 + 1;
        goto L7
    L9:
        ReentrantReadWriteLock.WriteLock r10 = r9.writeLock();
        r10.lock();
        g.add(r7);     // Catch: Throwable -> L15
        ILogDepend.Companion.i(TAG, "Added conversation listener: " + aa.b(r7.getClass()).b());     // Catch: Throwable -> L15
        x r11 = x.f38692a;     // Catch: Throwable -> L15
    L11:
        if (r2 >= r1) goto L13;
        r0.lock();
        r2 = r2 + 1;
        goto L11
    L13:
        r10.unlock();
        return;
    L15:
        th = move-exception;
    L16:
        if (r2 >= r1) goto L18;
        r0.lock();
        r2 = r2 + 1;
        goto L16
    L18:
        r10.unlock();
        throw th;
    L5:
        r1 = 0;
        goto L6
    }

    public final com.obric.assistant.dm.impl.statemachine.a.e a(String r24, TaskId r25, IMMessage r26) {
        d.h.b.o.e(r25, DBDefinition.TASK_ID);
        ReentrantReadWriteLock r1 = h;
        ReentrantReadWriteLock.ReadLock r14 = r1.readLock();
        if (r1.getWriteHoldCount() != 0) goto L5;
        int r12 = r1.getReadHoldCount();
    L6:
        int r2 = 0;
    L7:
        if (r2 >= r12) goto L9;
        r14.unlock();
        r2 = r2 + 1;
        goto L7
    L9:
        ReentrantReadWriteLock.WriteLock r16 = r1.writeLock();
        r16.lock();
        LinkedHashMap<TaskId, TaskInfo> r11 = f22510b;     // Catch: Throwable -> L27
        if (r11.containsKey(r25) == false) goto L15;
        ILogDepend.Companion.w(TAG, "SimpleTask " + r25 + " already exists, cannot create new one");     // Catch: Throwable -> L27
        com.obric.assistant.dm.impl.statemachine.a.e r0 = null;
        ReentrantReadWriteLock.ReadLock r17 = r14;
        int r15 = r12;
    L18:
        int r18 = 0;
    L19:
        if (r18 >= r15) goto L21;
        r17.lock();
        r18 = r18 + 1;
        goto L19
    L21:
        r16.unlock();
        if (r0 == null) goto L24;
        f22509a.e();
    L24:
        return r0;
    L15:
        r17 = r14;
        r15 = r12;
        TaskInfo r9 = new TaskInfo(r25, TaskType.SIMPLE, r26, 0, r24, null, null, 0, 232, null);     // Catch: Throwable -> L25
        com.obric.assistant.dm.impl.statemachine.a.e r3 = new com.obric.assistant.dm.impl.statemachine.a.e(r25, "SimpleTask_" + r25, r9);     // Catch: Throwable -> L25
        c r4 = f22509a;     // Catch: Throwable -> L25
        r3.a(r4.a(r9));     // Catch: Throwable -> L25
        ((Map) ZeusTransformUtils.preCheckCast(r11, Map.class, "com.obric.aiagent.plugin")).put(r25, r9);     // Catch: Throwable -> L25
        ((Map) ZeusTransformUtils.preCheckCast(f22511c, Map.class, "com.obric.aiagent.plugin")).put(r25, r3);     // Catch: Throwable -> L25
        ILogDepend.Companion.i(TAG, "Created simple task: " + r25);     // Catch: Throwable -> L25
        r4.d(r9);     // Catch: Throwable -> L25
        r0 = r3;
    L25:
        th = th;
    L29:
        int r19 = 0;
    L30:
        if (r19 >= r15) goto L32;
        r17.lock();
        r19 = r19 + 1;
        goto L30
    L32:
        r16.unlock();
        throw th;
    L27:
        th = th;
        r17 = r14;
        r15 = r12;
        goto L29
    L5:
        r12 = 0;
        goto L6
    }

    public final com.obric.assistant.dm.impl.statemachine.a.d b(String r24, TaskId r25, IMMessage r26) {
        d.h.b.o.e(r24, "messageId");
        d.h.b.o.e(r25, DBDefinition.TASK_ID);
        ReentrantReadWriteLock r1 = h;
        ReentrantReadWriteLock.ReadLock r14 = r1.readLock();
        if (r1.getWriteHoldCount() != 0) goto L5;
        int r12 = r1.getReadHoldCount();
    L6:
        int r2 = 0;
    L7:
        if (r2 >= r12) goto L9;
        r14.unlock();
        r2 = r2 + 1;
        goto L7
    L9:
        ReentrantReadWriteLock.WriteLock r16 = r1.writeLock();
        r16.lock();
        LinkedHashMap<TaskId, TaskInfo> r11 = f22510b;     // Catch: Throwable -> L27
        if (r11.containsKey(r25) == false) goto L15;
        ILogDepend.Companion.w(TAG, "OAutoTask " + r25 + " already exists, cannot create new one");     // Catch: Throwable -> L27
        com.obric.assistant.dm.impl.statemachine.a.d r0 = null;
        ReentrantReadWriteLock.ReadLock r17 = r14;
        int r15 = r12;
    L18:
        int r18 = 0;
    L19:
        if (r18 >= r15) goto L21;
        r17.lock();
        r18 = r18 + 1;
        goto L19
    L21:
        r16.unlock();
        if (r0 == null) goto L24;
        f22509a.e();
    L24:
        return r0;
    L15:
        r17 = r14;
        r15 = r12;
        TaskInfo r9 = new TaskInfo(r25, TaskType.OAUTO, r26, 0, r24, null, null, 0, 232, null);     // Catch: Throwable -> L25
        com.obric.assistant.dm.impl.statemachine.a.d r3 = new com.obric.assistant.dm.impl.statemachine.a.d(r25, "OAutoTask_" + r25, r9);     // Catch: Throwable -> L25
        c r4 = f22509a;     // Catch: Throwable -> L25
        r3.a(r4.b(r9));     // Catch: Throwable -> L25
        ((Map) ZeusTransformUtils.preCheckCast(r11, Map.class, "com.obric.aiagent.plugin")).put(r25, r9);     // Catch: Throwable -> L25
        ((Map) ZeusTransformUtils.preCheckCast(f22511c, Map.class, "com.obric.aiagent.plugin")).put(r25, r3);     // Catch: Throwable -> L25
        ILogDepend.Companion.i(TAG, "Created OAuto task: " + r25);     // Catch: Throwable -> L25
        r4.d(r9);     // Catch: Throwable -> L25
        r0 = r3;
    L25:
        th = th;
    L29:
        int r19 = 0;
    L30:
        if (r19 >= r15) goto L32;
        r17.lock();
        r19 = r19 + 1;
        goto L30
    L32:
        r16.unlock();
        throw th;
    L27:
        th = th;
        r17 = r14;
        r15 = r12;
        goto L29
    L5:
        r12 = 0;
        goto L6
    }

    public final com.obric.assistant.dm.impl.statemachine.a.a c(String r25, TaskId r26, IMMessage r27) {
        d.h.b.o.e(r25, "messageId");
        d.h.b.o.e(r26, DBDefinition.TASK_ID);
        ReentrantReadWriteLock r1 = h;
        ReentrantReadWriteLock.ReadLock r14 = r1.readLock();
        if (r1.getWriteHoldCount() != 0) goto L5;
        int r12 = r1.getReadHoldCount();
    L6:
        int r2 = 0;
    L7:
        if (r2 >= r12) goto L9;
        r14.unlock();
        r2 = r2 + 1;
        goto L7
    L9:
        ReentrantReadWriteLock.WriteLock r16 = r1.writeLock();
        r16.lock();
        LinkedHashMap<TaskId, TaskInfo> r11 = f22510b;     // Catch: Throwable -> L36
        String r17 = null;
        com.obric.assistant.dm.impl.statemachine.a.a r18 = null;
        if (r11.containsKey(r26) == false) goto L15;
        ILogDepend.Companion.w(TAG, "ComplexTask " + r26 + " already exists, cannot create new one");     // Catch: Throwable -> L36
        ReentrantReadWriteLock.ReadLock r19 = r14;
        int r15 = r12;
    L27:
        int r110 = 0;
    L28:
        if (r110 >= r15) goto L30;
        r19.lock();
        r110 = r110 + 1;
        goto L28
    L30:
        r16.unlock();
        if (r18 == null) goto L33;
        f22509a.e();
    L33:
        return r18;
    L15:
        r19 = r14;
        r15 = r12;
        TaskInfo r9 = new TaskInfo(r26, TaskType.COMPLEX, r27, 0, r25, null, null, 0, 232, null);     // Catch: Throwable -> L34
        com.obric.assistant.dm.impl.statemachine.a.a r3 = new com.obric.assistant.dm.impl.statemachine.a.a(r26, "ComplexTask_" + r26, r9);     // Catch: Throwable -> L34
        c r4 = f22509a;     // Catch: Throwable -> L34
        r3.a(r4.c(r9));     // Catch: Throwable -> L34
        ((Map) ZeusTransformUtils.preCheckCast(r11, Map.class, "com.obric.aiagent.plugin")).put(r26, r9);     // Catch: Throwable -> L34
        ((Map) ZeusTransformUtils.preCheckCast(f22511c, Map.class, "com.obric.aiagent.plugin")).put(r26, r3);     // Catch: Throwable -> L34
        ILogDepend.Companion r5 = ILogDepend.Companion;     // Catch: Throwable -> L34
        StringBuilder r0 = new StringBuilder().append("Created complex task: ").append(r26).append(" message:");     // Catch: Throwable -> L34
        if (r27 == null) goto L19;
        r17 = r27.getMessageId();     // Catch: Throwable -> L34
    L19:
        r5.i(TAG, r0.append(r17).toString());     // Catch: Throwable -> L34
        r4.d(r9);     // Catch: Throwable -> L34
        IComplexTaskService r6 = (IComplexTaskService) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IComplexTaskService.class), IComplexTaskService.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L34
        if (r6 == null) goto L26;
        if (r27 == null) goto L24;
        String r7 = r27.getMessageId();     // Catch: Throwable -> L34
        if (r7 == null) goto L24;
    L25:
        r6.addComplexTaskExt(r7);     // Catch: Throwable -> L34
    L24:
        r7 = "";
    L26:
        r18 = r3;
    L34:
        th = th;
    L38:
        int r111 = 0;
    L39:
        if (r111 >= r15) goto L41;
        r19.lock();
        r111 = r111 + 1;
        goto L39
    L41:
        r16.unlock();
        throw th;
    L36:
        th = th;
        r19 = r14;
        r15 = r12;
        goto L38
    L5:
        r12 = 0;
        goto L6
    }

    public final TaskInfo a(String r5) {
        d.h.b.o.e(r5, "questionId");
        ReentrantReadWriteLock.ReadLock r0 = h.readLock();
        r0.lock();
        Collection<TaskInfo> r1 = f22510b.values();     // Catch: Throwable -> L13
        d.h.b.o.c(r1, "<get-values>(...)");     // Catch: Throwable -> L13
        Iterator r2 = ((Iterable) ZeusTransformUtils.preCheckCast(r1, Iterable.class, "com.obric.aiagent.plugin")).iterator();     // Catch: Throwable -> L13
    L5:
        if (r2.hasNext() == false) goto L9;
        Object r3 = r2.next();     // Catch: Throwable -> L13
        if (d.h.b.o.a(((TaskInfo) ZeusTransformUtils.preCheckCast(r3, TaskInfo.class, "com.obric.aiagent.plugin")).getQueryId(), r5) == false) goto L5;
    L10:
        TaskInfo r4 = (TaskInfo) ZeusTransformUtils.preCheckCast(r3, TaskInfo.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L13
        r0.unlock();
        return r4;
    L9:
        r3 = null;
    L13:
        th = move-exception;
        r0.unlock();
        throw th;
    }

    public final TaskInfo a(TaskId r3) {
        d.h.b.o.e(r3, DBDefinition.TASK_ID);
        ReentrantReadWriteLock.ReadLock r2 = h.readLock();
        r2.lock();
        TaskInfo r4 = (TaskInfo) ZeusTransformUtils.preCheckCast(f22510b.get(r3), TaskInfo.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L6
        r2.unlock();
        return r4;
    L6:
        th = move-exception;
        r2.unlock();
        throw th;
    }

    public final void a(TaskId r13, int r14) {
        d.h.b.o.e(r13, DBDefinition.TASK_ID);
        ReentrantReadWriteLock r0 = h;
        ReentrantReadWriteLock.ReadLock r1 = r0.readLock();
        int r3 = 0;
        if (r0.getWriteHoldCount() != 0) goto L5;
        int r2 = r0.getReadHoldCount();
    L6:
        int r4 = 0;
    L7:
        if (r4 >= r2) goto L9;
        r1.unlock();
        r4 = r4 + 1;
        goto L7
    L9:
        ReentrantReadWriteLock.WriteLock r5 = r0.writeLock();
        r5.lock();
        TaskInfo r6 = (TaskInfo) ZeusTransformUtils.preCheckCast(f22510b.get(r13), TaskInfo.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L31
        if (r6 != null) goto L13;
    L12:
        d.m r15 = null;
    L25:
        if (r3 >= r2) goto L27;
        r1.lock();
        r3 = r3 + 1;
        goto L25
    L27:
        r5.unlock();
        if (r15 == null) goto L42;
        i.a(com.obric.assistant.dm.impl.statemachine.a.b.f22507a.a(), null, null, (m) ZeusTransformUtils.preCheckCast(new e((TaskInfo) ZeusTransformUtils.preCheckCast(r15.c(), TaskInfo.class, "com.obric.aiagent.plugin"), (State) ZeusTransformUtils.preCheckCast(r15.d(), State.class, "com.obric.aiagent.plugin"), null), m.class, "com.obric.aiagent.plugin"), 3, null);
        return;
    L42:
        return;
    L13:
        Integer r7 = r6.getProgress();     // Catch: Throwable -> L31
        if (r7 != null) goto L17;
    L19:
        r6.setProgress(Integer.valueOf(r14));     // Catch: Throwable -> L31
        com.obric.assistant.dm.api.statemachine.core.d r16 = (com.obric.assistant.dm.api.statemachine.core.d) ZeusTransformUtils.preCheckCast(f22511c.get(r13), com.obric.assistant.dm.api.statemachine.core.d.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L31
        if (r16 == null) goto L12;
        State r17 = r16.a();     // Catch: Throwable -> L31
        if (r17 == null) goto L12;
        r15 = s.a(f22509a.f(r6), r17);     // Catch: Throwable -> L31
        goto L25
    L17:
        if (r7.intValue() != r14) goto L19;
    L31:
        th = move-exception;
    L32:
        if (r3 >= r2) goto L34;
        r1.lock();
        r3 = r3 + 1;
        goto L32
    L34:
        r5.unlock();
        throw th;
    L5:
        r2 = 0;
        goto L6
    }

    public final boolean b(TaskId r6, int r7) {
        d.h.b.o.e(r6, DBDefinition.TASK_ID);
        ReentrantReadWriteLock r5 = h;
        ReentrantReadWriteLock.ReadLock r0 = r5.readLock();
        int r2 = 0;
        if (r5.getWriteHoldCount() != 0) goto L5;
        int r1 = r5.getReadHoldCount();
    L6:
        int r3 = 0;
    L7:
        if (r3 >= r1) goto L9;
        r0.unlock();
        r3 = r3 + 1;
        goto L7
    L9:
        ReentrantReadWriteLock.WriteLock r8 = r5.writeLock();
        r8.lock();
        TaskInfo r9 = (TaskInfo) ZeusTransformUtils.preCheckCast(f22510b.get(r6), TaskInfo.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L21
        if (r9 != null) goto L13;
    L16:
        boolean r10 = true;
    L17:
        if (r2 >= r1) goto L19;
        r0.lock();
        r2 = r2 + 1;
        goto L17
    L19:
        r8.unlock();
        return r10;
    L13:
        if (r7 > r9.getIndex()) goto L15;
        r10 = false;
        goto L17
    L15:
        r9.setIndex(r7);     // Catch: Throwable -> L21
    L21:
        th = move-exception;
    L22:
        if (r2 >= r1) goto L24;
        r0.lock();
        r2 = r2 + 1;
        goto L22
    L24:
        r8.unlock();
        throw th;
    L5:
        r1 = 0;
        goto L6
    }

    public final void a(TaskId r13, String r14, String r15) {
        d.h.b.o.e(r13, DBDefinition.TASK_ID);
        d.h.b.o.e(r14, "key");
        d.h.b.o.e(r15, "value");
        ReentrantReadWriteLock r0 = h;
        ReentrantReadWriteLock.ReadLock r1 = r0.readLock();
        int r3 = 0;
        if (r0.getWriteHoldCount() != 0) goto L5;
        int r2 = r0.getReadHoldCount();
    L6:
        int r4 = 0;
    L7:
        if (r4 >= r2) goto L9;
        r1.unlock();
        r4 = r4 + 1;
        goto L7
    L9:
        ReentrantReadWriteLock.WriteLock r5 = r0.writeLock();
        r5.lock();
        TaskInfo r6 = (TaskInfo) ZeusTransformUtils.preCheckCast(f22510b.get(r13), TaskInfo.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L35
        if (r6 != null) goto L13;
    L12:
        d.m r16 = null;
    L29:
        if (r3 >= r2) goto L31;
        r1.lock();
        r3 = r3 + 1;
        goto L29
    L31:
        r5.unlock();
        if (r16 == null) goto L46;
        i.a(com.obric.assistant.dm.impl.statemachine.a.b.f22507a.a(), null, null, (m) ZeusTransformUtils.preCheckCast(new d((TaskInfo) ZeusTransformUtils.preCheckCast(r16.c(), TaskInfo.class, "com.obric.aiagent.plugin"), (State) ZeusTransformUtils.preCheckCast(r16.d(), State.class, "com.obric.aiagent.plugin"), null), m.class, "com.obric.aiagent.plugin"), 3, null);
        return;
    L46:
        return;
    L13:
        Map<String, String> r7 = r6.getExt();     // Catch: Throwable -> L35
        if (r7 == null) goto L16;
        String r8 = (String) ZeusTransformUtils.preCheckCast(r7.get(r14), String.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L35
    L18:
        if (d.h.b.o.a(r8, r15) == true) goto L12;
        Map<String, String> r9 = r6.getExt();     // Catch: Throwable -> L35
        if (r9 == null) goto L23;
        String r17 = (String) ZeusTransformUtils.preCheckCast(r9.put(r14, r15), String.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L35
    L23:
        com.obric.assistant.dm.api.statemachine.core.d r18 = (com.obric.assistant.dm.api.statemachine.core.d) ZeusTransformUtils.preCheckCast(f22511c.get(r13), com.obric.assistant.dm.api.statemachine.core.d.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L35
        if (r18 == null) goto L12;
        State r19 = r18.a();     // Catch: Throwable -> L35
        if (r19 == null) goto L12;
        r16 = s.a(f22509a.f(r6), r19);     // Catch: Throwable -> L35
        goto L29
    L16:
        r8 = null;
    L35:
        th = move-exception;
    L36:
        if (r3 >= r2) goto L38;
        r1.lock();
        r3 = r3 + 1;
        goto L36
    L38:
        r5.unlock();
        throw th;
    L5:
        r2 = 0;
        goto L6
    }

    public final void a(TaskId r21, Map<String, String> r22) {
        Map r2 = (Map) ZeusTransformUtils.wrapperContextForParams(r22, Map.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r21, DBDefinition.TASK_ID);
        ReentrantReadWriteLock r4 = h;
        ReentrantReadWriteLock.ReadLock r5 = r4.readLock();
        int r7 = 0;
        if (r4.getWriteHoldCount() != 0) goto L5;
        int r6 = r4.getReadHoldCount();
    L6:
        int r8 = 0;
    L7:
        if (r8 >= r6) goto L9;
        r5.unlock();
        r8 = r8 + 1;
        goto L7
    L9:
        ReentrantReadWriteLock.WriteLock r9 = r4.writeLock();
        r9.lock();
        ILogDepend.Companion r10 = ILogDepend.Companion;     // Catch: Throwable -> L95
        StringBuilder r11 = new StringBuilder().append("updateStateExt ");     // Catch: Throwable -> L95
        LinkedHashMap<TaskId, com.obric.assistant.dm.api.statemachine.core.d<?, ?>> r12 = f22511c;     // Catch: Throwable -> L95
        com.obric.assistant.dm.api.statemachine.core.d r13 = (com.obric.assistant.dm.api.statemachine.core.d) ZeusTransformUtils.preCheckCast(r12.get(r21), com.obric.assistant.dm.api.statemachine.core.d.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L95
        if (r13 == null) goto L15;
        State r14 = r13.a();     // Catch: Throwable -> L95
        if (r14 == null) goto L15;
        String r15 = r14.getStateName();     // Catch: Throwable -> L95
    L16:
        r10.i(TAG, r11.append(r15).append(", ").append(r2).toString());     // Catch: Throwable -> L95
        com.obric.assistant.dm.api.statemachine.core.d<?, ?> r0 = r12.get(r21);     // Catch: Throwable -> L95
        if (ZeusTransformUtils.instanceOf(r0, com.obric.assistant.dm.impl.statemachine.a.a.class) == false) goto L20;
        com.obric.assistant.dm.impl.statemachine.a.a r1 = (com.obric.assistant.dm.impl.statemachine.a.a) ZeusTransformUtils.preCheckCast(r0, com.obric.assistant.dm.impl.statemachine.a.a.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L95
    L21:
        if (r1 != null) goto L26;
    L22:
        if (r7 >= r6) goto L24;
        r5.lock();
        r7 = r7 + 1;
        goto L22
    L24:
        r9.unlock();
        return;
    L26:
        ComplexTaskState r16 = (ComplexTaskState) ZeusTransformUtils.preCheckCast(r1.a(), ComplexTaskState.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L95
        boolean r17 = true;
        if (r2 != null) goto L29;
    L32:
        boolean r18 = true;
    L33:
        if (r18 == false) goto L39;
    L34:
        if (r7 >= r6) goto L36;
        r5.lock();
        r7 = r7 + 1;
        goto L34
    L36:
        r9.unlock();
        return;
    L39:
        if (r2.isEmpty() == false) goto L41;
    L40:
        r17 = false;
    L47:
        if (r17 == true) goto L52;
    L48:
        if (r7 >= r6) goto L50;
        r5.lock();
        r7 = r7 + 1;
        goto L48
    L50:
        r9.unlock();
        return;
    L52:
        ILogDepend.Companion.i(TAG, "updateStateExt hasChanged!");     // Catch: Throwable -> L95
        Map r3 = ao.e(r16.getExtra());     // Catch: Throwable -> L95
        Iterator r19 = r2.entrySet().iterator();     // Catch: Throwable -> L95
    L54:
        if (r19.hasNext() == false) goto L57;
        Map.Entry r20 = (Map.Entry) ZeusTransformUtils.preCheckCast(r19.next(), Map.Entry.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L95
        r3.put((String) ZeusTransformUtils.preCheckCast(r20.getKey(), String.class, "com.obric.aiagent.plugin"), (String) ZeusTransformUtils.preCheckCast(r20.getValue(), String.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L95
        goto L54
    L57:
        if (ZeusTransformUtils.instanceOf(r16, ComplexTaskState.Idle.class) == false) goto L60;
        ComplexTaskState r23 = (ComplexTaskState) ZeusTransformUtils.preCheckCast(ComplexTaskState.Idle.copy$default((ComplexTaskState.Idle) ZeusTransformUtils.preCheckCast(r16, ComplexTaskState.Idle.class, "com.obric.aiagent.plugin"), null, null, 0, r3, 7, null), ComplexTaskState.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L95
    L86:
        r1.a((State) ZeusTransformUtils.preCheckCast(r23, State.class, "com.obric.aiagent.plugin"), null);     // Catch: Throwable -> L95
    L87:
        if (r7 >= r6) goto L89;
        r5.lock();
        r7 = r7 + 1;
        goto L87
    L89:
        r9.unlock();
        return;
    L60:
        if (ZeusTransformUtils.instanceOf(r16, ComplexTaskState.Queueing.class) == false) goto L63;
        r23 = (ComplexTaskState) ZeusTransformUtils.preCheckCast(ComplexTaskState.Queueing.copy$default((ComplexTaskState.Queueing) ZeusTransformUtils.preCheckCast(r16, ComplexTaskState.Queueing.class, "com.obric.aiagent.plugin"), null, null, 0, r3, 7, null), ComplexTaskState.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L95
        goto L86
    L63:
        if (ZeusTransformUtils.instanceOf(r16, ComplexTaskState.Thinking.class) == false) goto L66;
        r23 = (ComplexTaskState) ZeusTransformUtils.preCheckCast(ComplexTaskState.Thinking.copy$default((ComplexTaskState.Thinking) ZeusTransformUtils.preCheckCast(r16, ComplexTaskState.Thinking.class, "com.obric.aiagent.plugin"), null, null, 0, r3, 7, null), ComplexTaskState.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L95
        goto L86
    L66:
        if (ZeusTransformUtils.instanceOf(r16, ComplexTaskState.Clarify.class) == false) goto L69;
        r23 = (ComplexTaskState) ZeusTransformUtils.preCheckCast(ComplexTaskState.Clarify.copy$default((ComplexTaskState.Clarify) ZeusTransformUtils.preCheckCast(r16, ComplexTaskState.Clarify.class, "com.obric.aiagent.plugin"), null, null, 0, r3, 7, null), ComplexTaskState.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L95
        goto L86
    L69:
        if (ZeusTransformUtils.instanceOf(r16, ComplexTaskState.ClarifyAck.class) == false) goto L72;
        r23 = (ComplexTaskState) ZeusTransformUtils.preCheckCast(ComplexTaskState.ClarifyAck.copy$default((ComplexTaskState.ClarifyAck) ZeusTransformUtils.preCheckCast(r16, ComplexTaskState.ClarifyAck.class, "com.obric.aiagent.plugin"), null, null, 0, r3, 7, null), ComplexTaskState.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L95
        goto L86
    L72:
        if (ZeusTransformUtils.instanceOf(r16, ComplexTaskState.TakingOver.class) == false) goto L75;
        r23 = (ComplexTaskState) ZeusTransformUtils.preCheckCast(ComplexTaskState.TakingOver.copy$default((ComplexTaskState.TakingOver) ZeusTransformUtils.preCheckCast(r16, ComplexTaskState.TakingOver.class, "com.obric.aiagent.plugin"), null, null, 0, r3, 7, null), ComplexTaskState.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L95
        goto L86
    L75:
        if (ZeusTransformUtils.instanceOf(r16, ComplexTaskState.CallUser.class) == false) goto L78;
        r23 = (ComplexTaskState) ZeusTransformUtils.preCheckCast(ComplexTaskState.CallUser.copy$default((ComplexTaskState.CallUser) ZeusTransformUtils.preCheckCast(r16, ComplexTaskState.CallUser.class, "com.obric.aiagent.plugin"), null, null, 0, r3, 7, null), ComplexTaskState.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L95
        goto L86
    L78:
        if (ZeusTransformUtils.instanceOf(r16, ComplexTaskState.ThinkingCompleted.class) == false) goto L81;
        r23 = (ComplexTaskState) ZeusTransformUtils.preCheckCast(ComplexTaskState.ThinkingCompleted.copy$default((ComplexTaskState.ThinkingCompleted) ZeusTransformUtils.preCheckCast(r16, ComplexTaskState.ThinkingCompleted.class, "com.obric.aiagent.plugin"), null, null, 0, r3, 7, null), ComplexTaskState.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L95
        goto L86
    L81:
        if (ZeusTransformUtils.instanceOf(r16, ComplexTaskState.Terminated.class) == false) goto L84;
        r23 = (ComplexTaskState) ZeusTransformUtils.preCheckCast(ComplexTaskState.Terminated.copy$default((ComplexTaskState.Terminated) ZeusTransformUtils.preCheckCast(r16, ComplexTaskState.Terminated.class, "com.obric.aiagent.plugin"), null, null, 0, r3, 7, null), ComplexTaskState.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L95
        goto L86
    L84:
        if (ZeusTransformUtils.instanceOf(r16, ComplexTaskState.TTS.class) == false) goto L91;
        r23 = (ComplexTaskState) ZeusTransformUtils.preCheckCast(ComplexTaskState.TTS.copy$default((ComplexTaskState.TTS) ZeusTransformUtils.preCheckCast(r16, ComplexTaskState.TTS.class, "com.obric.aiagent.plugin"), null, null, 0, r3, 7, null), ComplexTaskState.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L95
    L91:
        if (r7 >= r6) goto L93;
        r5.lock();
        r7 = r7 + 1;
        goto L91
    L93:
        r9.unlock();
        return;
    L41:
        Iterator r110 = r2.entrySet().iterator();     // Catch: Throwable -> L95
    L43:
        if (r110.hasNext() == false) goto L40;
        Map.Entry r111 = (Map.Entry) ZeusTransformUtils.preCheckCast(r110.next(), Map.Entry.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L95
        String r112 = (String) ZeusTransformUtils.preCheckCast(r111.getKey(), String.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L95
        if ((!d.h.b.o.a(r16.getExtra().get(r112), (String) ZeusTransformUtils.preCheckCast(r111.getValue(), String.class, "com.obric.aiagent.plugin"))) == false) goto L43;
    L29:
        if (r2.isEmpty() == true) goto L32;
        r18 = false;
        goto L33
    L20:
        r1 = null;
    L15:
        r15 = null;
    L95:
        th = move-exception;
    L96:
        if (r7 >= r6) goto L98;
        r5.lock();
        r7 = r7 + 1;
        goto L96
    L98:
        r9.unlock();
        throw th;
    L5:
        r6 = 0;
        goto L6
    }

    private final void b(TaskId r8) {
        ReentrantReadWriteLock r1 = h;
        ReentrantReadWriteLock.ReadLock r2 = r1.readLock();
        int r4 = 0;
        if (r1.getWriteHoldCount() != 0) goto L5;
        int r3 = r1.getReadHoldCount();
    L6:
        int r5 = 0;
    L7:
        if (r5 >= r3) goto L9;
        r2.unlock();
        r5 = r5 + 1;
        goto L7
    L9:
        ReentrantReadWriteLock.WriteLock r6 = r1.writeLock();
        r6.lock();
        TaskInfo r7 = (TaskInfo) ZeusTransformUtils.preCheckCast(f22510b.remove(r8), TaskInfo.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L23
        if (r7 == null) goto L16;
        f22509a.e(r7);     // Catch: Throwable -> L23
        com.obric.assistant.dm.api.statemachine.core.d r9 = (com.obric.assistant.dm.api.statemachine.core.d) ZeusTransformUtils.preCheckCast(f22511c.remove(r8), com.obric.assistant.dm.api.statemachine.core.d.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L23
        if (r9 == null) goto L17;
        r9.b();     // Catch: Throwable -> L23
    L17:
        if (r4 >= r3) goto L19;
        r2.lock();
        r4 = r4 + 1;
        goto L17
    L19:
        r6.unlock();
        if (r7 == null) goto L34;
        e();
        return;
    L34:
        return;
    L16:
        r7 = null;
    L23:
        th = move-exception;
    L24:
        if (r4 >= r3) goto L26;
        r2.lock();
        r4 = r4 + 1;
        goto L24
    L26:
        r6.unlock();
        throw th;
    L5:
        r3 = 0;
        goto L6
    }

    public final DMState a() {
        ReentrantReadWriteLock.ReadLock r0 = h.readLock();
        r0.lock();
        Collection<com.obric.assistant.dm.api.statemachine.core.d<?, ?>> r1 = f22511c.values();     // Catch: Throwable -> L16
        d.h.b.o.c(r1, "<get-values>(...)");     // Catch: Throwable -> L16
        Iterable r2 = (Iterable) ZeusTransformUtils.preCheckCast(p.o((Iterable) ZeusTransformUtils.preCheckCast(r1, Iterable.class, "com.obric.aiagent.plugin")), Iterable.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L16
        Collection r3 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(p.a(r2, 10)), Collection.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L16
        Iterator r4 = r2.iterator();     // Catch: Throwable -> L16
    L5:
        if (r4.hasNext() == false) goto L7;
        r3.add(((com.obric.assistant.dm.api.statemachine.core.d) ZeusTransformUtils.preCheckCast(r4.next(), com.obric.assistant.dm.api.statemachine.core.d.class, "com.obric.aiagent.plugin")).a());     // Catch: Throwable -> L16
        goto L5
    L7:
        List r5 = (List) ZeusTransformUtils.preCheckCast(r3, List.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L16
        if (r5.isEmpty() == true) goto L10;
    L12:
        boolean r6 = false;
    L13:
        DMState r7 = new DMState(r6, f22512d, r5, f);     // Catch: Throwable -> L16
        r0.unlock();
        return r7;
    L10:
        if (f22512d == true) goto L12;
        r6 = true;
    L16:
        th = move-exception;
        r0.unlock();
        throw th;
    }

    private final com.obric.assistant.dm.api.statemachine.core.e<SimpleTaskState> a(TaskInfo r2) {
        return (com.obric.assistant.dm.api.statemachine.core.e) ZeusTransformUtils.preCheckCast(new C0491c(r2), com.obric.assistant.dm.api.statemachine.core.e.class, "com.obric.aiagent.plugin");
    }

    private final com.obric.assistant.dm.api.statemachine.core.e<OAutoTaskState> b(TaskInfo r2) {
        return (com.obric.assistant.dm.api.statemachine.core.e) ZeusTransformUtils.preCheckCast(new b(r2), com.obric.assistant.dm.api.statemachine.core.e.class, "com.obric.aiagent.plugin");
    }

    private final com.obric.assistant.dm.api.statemachine.core.e<ComplexTaskState> c(TaskInfo r2) {
        return (com.obric.assistant.dm.api.statemachine.core.e) ZeusTransformUtils.preCheckCast(new a(r2), com.obric.assistant.dm.api.statemachine.core.e.class, "com.obric.aiagent.plugin");
    }

    private final void e() {
        DMState r6 = a();
        Iterator r0 = ((Iterable) ZeusTransformUtils.preCheckCast(g, Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L4:
        if (r0.hasNext() == false) goto L10;
        ((com.obric.assistant.dm.api.statemachine.core.b) ZeusTransformUtils.preCheckCast(r0.next(), com.obric.assistant.dm.api.statemachine.core.b.class, "com.obric.aiagent.plugin")).a(r6);     // Catch: Exception -> L8
    L8:
        e = move-exception;
        ISecureLogDepend.Companion.e(TAG, "Error notifying conversation state change: " + e.getMessage(), (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
        goto L4
    }

    private final void d(TaskInfo r6) {
        Iterator r5 = ((Iterable) ZeusTransformUtils.preCheckCast(g, Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L4:
        if (r5.hasNext() == false) goto L10;
        ((com.obric.assistant.dm.api.statemachine.core.b) ZeusTransformUtils.preCheckCast(r5.next(), com.obric.assistant.dm.api.statemachine.core.b.class, "com.obric.aiagent.plugin")).a(r6);     // Catch: Exception -> L8
    L8:
        e = move-exception;
        ISecureLogDepend.Companion.e(TAG, "Error notifying task added: " + e.getMessage(), (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
        goto L4
    }

    private final void e(TaskInfo r6) {
        Iterator r5 = ((Iterable) ZeusTransformUtils.preCheckCast(g, Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L4:
        if (r5.hasNext() == false) goto L10;
        ((com.obric.assistant.dm.api.statemachine.core.b) ZeusTransformUtils.preCheckCast(r5.next(), com.obric.assistant.dm.api.statemachine.core.b.class, "com.obric.aiagent.plugin")).b(r6);     // Catch: Exception -> L8
    L8:
        e = move-exception;
        ISecureLogDepend.Companion.e(TAG, "Error notifying task removed: " + e.getMessage(), (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
        goto L4
    }

    private final void a(TaskInfo r6, State r7, DMEvent r8, Exception r9) {
        Iterator r5 = ((Iterable) ZeusTransformUtils.preCheckCast(g, Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L4:
        if (r5.hasNext() == false) goto L10;
        ((com.obric.assistant.dm.api.statemachine.core.b) ZeusTransformUtils.preCheckCast(r5.next(), com.obric.assistant.dm.api.statemachine.core.b.class, "com.obric.aiagent.plugin")).a(r6, r7, r8, r9);     // Catch: Exception -> L8
    L8:
        e = move-exception;
        ISecureLogDepend.Companion.e(TAG, "onTransitionFailed Error : " + e.getMessage(), (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
        goto L4
    }

    private final void a(TaskInfo r6, State r7, State r8, DMEvent r9) {
        Iterator r5 = ((Iterable) ZeusTransformUtils.preCheckCast(g, Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L4:
        if (r5.hasNext() == false) goto L10;
        ((com.obric.assistant.dm.api.statemachine.core.b) ZeusTransformUtils.preCheckCast(r5.next(), com.obric.assistant.dm.api.statemachine.core.b.class, "com.obric.aiagent.plugin")).a(r6, r7, r8, r9);     // Catch: Exception -> L8
    L8:
        e = move-exception;
        ISecureLogDepend.Companion.e(TAG, "Error notifying task state change: " + e.getMessage(), (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
        goto L4
    }

    private final TaskInfo f(TaskInfo r13) {
        Integer r7 = r13.getProgress();
        Map<String, String> r12 = r13.getExt();
        if (r12 == null) goto L5;
        Map r14 = ao.e(r12);
    L7:
        return TaskInfo.copy$default(r13, null, null, null, 0, null, r7, r14, r13.getIndex(), 31, null);
    L5:
        r14 = null;
        goto L7
    }

    public final void a(IMMessage r8) {
        d.h.b.o.e(r8, DownloadConstants.QUERY_KEY);
        ReentrantReadWriteLock r0 = h;
        ReentrantReadWriteLock.ReadLock r1 = r0.readLock();
        int r3 = 0;
        if (r0.getWriteHoldCount() != 0) goto L5;
        int r2 = r0.getReadHoldCount();
    L6:
        int r4 = 0;
    L7:
        if (r4 >= r2) goto L9;
        r1.unlock();
        r4 = r4 + 1;
        goto L7
    L9:
        ReentrantReadWriteLock.WriteLock r5 = r0.writeLock();
        r5.lock();
        Map<String, IMMessage> r6 = f22513e;     // Catch: Throwable -> L28
        r6.put(r8.getMessageId(), r8);     // Catch: Throwable -> L28
        boolean r7 = true;
        if (f22512d == true) goto L21;
        ca r9 = i;     // Catch: Throwable -> L28
        if (r9 == null) goto L16;
        ca.a.a(r9, null, 1, null);     // Catch: Throwable -> L28
    L16:
        if (r6.isEmpty() == true) goto L18;
        boolean r10 = true;
    L19:
        f22512d = r10;     // Catch: Throwable -> L28
    L22:
        if (r3 >= r2) goto L24;
        r1.lock();
        r3 = r3 + 1;
        goto L22
    L24:
        r5.unlock();
        if (r7 == false) goto L39;
        e();
        return;
    L39:
        return;
    L18:
        r10 = false;
        goto L19
    L21:
        r7 = false;
    L28:
        th = move-exception;
    L29:
        if (r3 >= r2) goto L31;
        r1.lock();
        r3 = r3 + 1;
        goto L29
    L31:
        r5.unlock();
        throw th;
    L5:
        r2 = 0;
        goto L6
    }

    public final boolean b(IMMessage r2) {
        d.h.b.o.e(r2, DownloadConstants.QUERY_KEY);
        ReentrantReadWriteLock.ReadLock r1 = h.readLock();
        r1.lock();
        boolean r3 = f22513e.containsKey(r2.getMessageId());     // Catch: Throwable -> L6
        r1.unlock();
        return r3;
    L6:
        th = move-exception;
        r1.unlock();
        throw th;
    }

    public final boolean b() {
        ReentrantReadWriteLock.ReadLock r0 = h.readLock();
        r0.lock();
        List<State> r1 = f22509a.a().getActiveTasks();     // Catch: Throwable -> L22
        boolean r3 = false;
        if (r1.isEmpty() == false) goto L8;
        r0.unlock();
        return false;
    L8:
        Iterable r2 = (Iterable) ZeusTransformUtils.preCheckCast(r1, Iterable.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L22
        if (ZeusTransformUtils.instanceOf(r2, Collection.class) == true) goto L11;
    L13:
        Iterator r4 = r2.iterator();     // Catch: Throwable -> L22
    L14:
        if (r4.hasNext() == false) goto L19;
        if (ZeusTransformUtils.instanceOf((State) ZeusTransformUtils.preCheckCast(r4.next(), State.class, "com.obric.aiagent.plugin"), ComplexTaskState.Queueing.class) == true) goto L14;
    L20:
        r0.unlock();
        return r3;
    L19:
        r3 = true;
        goto L20
    L11:
        if (((Collection) ZeusTransformUtils.preCheckCast(r2, Collection.class, "com.obric.aiagent.plugin")).isEmpty() == false) goto L13;
    L22:
        th = move-exception;
        r0.unlock();
        throw th;
    }

    public final IMMessage b(String r17) {
        d.h.b.o.e(r17, "msgId");
        ReentrantReadWriteLock r2 = h;
        ReentrantReadWriteLock.ReadLock r3 = r2.readLock();
        if (r2.getWriteHoldCount() != 0) goto L5;
        int r4 = r2.getReadHoldCount();
    L6:
        int r6 = 0;
    L7:
        if (r6 >= r4) goto L9;
        r3.unlock();
        r6 = r6 + 1;
        goto L7
    L9:
        ReentrantReadWriteLock.WriteLock r5 = r2.writeLock();
        r5.lock();
        Map<String, IMMessage> r7 = f22513e;     // Catch: Throwable -> L70
        IMMessage r8 = (IMMessage) ZeusTransformUtils.preCheckCast(r7.get(r17), IMMessage.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L70
        if (r8 != null) goto L18;
        int r9 = 0;
    L14:
        if (r9 >= r4) goto L16;
        r3.lock();
        r9 = r9 + 1;
        goto L14
    L16:
        r5.unlock();
        return null;
    L18:
        Map<String, String> r10 = r8.getExt();     // Catch: Throwable -> L70
        if (r10 == null) goto L22;
        String r11 = (String) ZeusTransformUtils.preCheckCast(r10.get("collection_id"), String.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L70
    L23:
        List<String> r12 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L70
        Iterator<Map.Entry<String, IMMessage>> r13 = r7.entrySet().iterator();     // Catch: Throwable -> L70
    L24:
        boolean r14 = true;
        if (r13.hasNext() == false) goto L42;
        Map.Entry r15 = (Map.Entry) ZeusTransformUtils.preCheckCast(r13.next(), Map.Entry.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L70
        String r16 = (String) ZeusTransformUtils.preCheckCast(r15.getKey(), String.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L70
        IMMessage r18 = (IMMessage) ZeusTransformUtils.preCheckCast(r15.getValue(), IMMessage.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L70
        if (d.h.b.o.a(r16, r17) == true) goto L42;
        CharSequence r19 = (CharSequence) ZeusTransformUtils.preCheckCast(r11, CharSequence.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L70
        if (r19 != null) goto L31;
    L34:
        if (r14 == true) goto L41;
        Map<String, String> r110 = r18.getExt();     // Catch: Throwable -> L70
        if (r110 == null) goto L38;
        String r111 = (String) ZeusTransformUtils.preCheckCast(r110.get("collection_id"), String.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L70
    L40:
        if (d.h.b.o.a(r111, r11) == true) goto L24;
    L38:
        r111 = null;
    L41:
        r12.add(r16);     // Catch: Throwable -> L70
        goto L24
    L31:
        if (r19.length() == 0) goto L34;
        r14 = false;
    L42:
        Map<String, IMMessage> r20 = f22513e;     // Catch: Throwable -> L70
        r20.remove(r17);     // Catch: Throwable -> L70
        CharSequence r0 = (CharSequence) ZeusTransformUtils.preCheckCast(r11, CharSequence.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L70
        if (r0 != null) goto L45;
    L48:
        boolean r1 = true;
    L49:
        if (r1 == true) goto L60;
        Iterator<Map.Entry<String, IMMessage>> r21 = r20.entrySet().iterator();     // Catch: Throwable -> L70
    L52:
        if (r21.hasNext() == false) goto L60;
        Map.Entry r22 = (Map.Entry) ZeusTransformUtils.preCheckCast(r21.next(), Map.Entry.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L70
        Map<String, String> r112 = ((IMMessage) ZeusTransformUtils.preCheckCast(r22.getValue(), IMMessage.class, "com.obric.aiagent.plugin")).getExt();     // Catch: Throwable -> L70
        if (r112 == null) goto L56;
        String r113 = (String) ZeusTransformUtils.preCheckCast(r112.get("collection_id"), String.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L70
    L58:
        if (d.h.b.o.a(r113, r11) == false) goto L52;
        ILogDepend.Companion.i(TAG, "Removed resolved sibling query: " + ((String) ZeusTransformUtils.preCheckCast(r22.getKey(), String.class, "com.obric.aiagent.plugin")) + ", collectionId=" + r11);     // Catch: Throwable -> L70
        r21.remove();     // Catch: Throwable -> L70
        goto L52
    L56:
        r113 = null;
    L60:
        c r23 = f22509a;     // Catch: Throwable -> L70
        if (f22513e.isEmpty() == false) goto L64;
        r14 = false;
    L64:
        f22512d = r14;     // Catch: Throwable -> L70
        r23.a(r12);     // Catch: Throwable -> L70
        int r24 = 0;
    L66:
        if (r24 >= r4) goto L68;
        r3.lock();
        r24 = r24 + 1;
        goto L66
    L68:
        r5.unlock();
        return r8;
    L45:
        if (r0.length() == 0) goto L48;
        r1 = false;
        goto L49
    L22:
        r11 = null;
    L70:
        th = move-exception;
        int r25 = 0;
    L72:
        if (r25 >= r4) goto L74;
        r3.lock();
        r25 = r25 + 1;
        goto L72
    L74:
        r5.unlock();
        throw th;
    L5:
        r4 = 0;
        goto L6
    }

    public final void a(DMEvent r7) {
        d.h.b.o.e(r7, "event");
        ReentrantReadWriteLock.ReadLock r0 = h.readLock();
        r0.lock();
        com.obric.assistant.dm.api.statemachine.core.d r1 = (com.obric.assistant.dm.api.statemachine.core.d) ZeusTransformUtils.preCheckCast(((Map) ZeusTransformUtils.preCheckCast(f22511c, Map.class, "com.obric.aiagent.plugin")).get(r7.getTaskId()), com.obric.assistant.dm.api.statemachine.core.d.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L23
        if (r1 == null) goto L21;
        ILogDepend.Companion.d(TAG, "handleEvent " + r7);     // Catch: Throwable -> L23
        if (ZeusTransformUtils.instanceOf(r1, com.obric.assistant.dm.impl.statemachine.a.e.class) == false) goto L11;
        if (ZeusTransformUtils.instanceOf(r7, SimpleTaskEvent.class) == false) goto L11;
        Boolean.valueOf(((com.obric.assistant.dm.impl.statemachine.a.e) ZeusTransformUtils.preCheckCast(r1, com.obric.assistant.dm.impl.statemachine.a.e.class, "com.obric.aiagent.plugin")).a((SimpleTaskEvent) ZeusTransformUtils.preCheckCast(r7, SimpleTaskEvent.class, "com.obric.aiagent.plugin")));     // Catch: Throwable -> L23
    L11:
        if (ZeusTransformUtils.instanceOf(r1, com.obric.assistant.dm.impl.statemachine.a.d.class) == false) goto L16;
        if (ZeusTransformUtils.instanceOf(r7, OAutoTaskEvent.class) == false) goto L16;
        Boolean.valueOf(((com.obric.assistant.dm.impl.statemachine.a.d) ZeusTransformUtils.preCheckCast(r1, com.obric.assistant.dm.impl.statemachine.a.d.class, "com.obric.aiagent.plugin")).a((OAutoTaskEvent) ZeusTransformUtils.preCheckCast(r7, OAutoTaskEvent.class, "com.obric.aiagent.plugin")));     // Catch: Throwable -> L23
    L16:
        if (ZeusTransformUtils.instanceOf(r1, com.obric.assistant.dm.impl.statemachine.a.a.class) == true) goto L18;
    L20:
        x r6 = x.f38692a;     // Catch: Throwable -> L23
        goto L21
    L18:
        if (ZeusTransformUtils.instanceOf(r7, ComplexTaskEvent.class) == false) goto L20;
        Boolean.valueOf(((com.obric.assistant.dm.impl.statemachine.a.a) ZeusTransformUtils.preCheckCast(r1, com.obric.assistant.dm.impl.statemachine.a.a.class, "com.obric.aiagent.plugin")).a((ComplexTaskEvent) ZeusTransformUtils.preCheckCast(r7, ComplexTaskEvent.class, "com.obric.aiagent.plugin")));     // Catch: Throwable -> L23
    L21:
        r0.unlock();
        return;
    L23:
        th = move-exception;
        r0.unlock();
        throw th;
    }

    public final void a(IslandSession r6) {
        ReentrantReadWriteLock r0 = h;
        ReentrantReadWriteLock.ReadLock r1 = r0.readLock();
        int r3 = 0;
        if (r0.getWriteHoldCount() != 0) goto L5;
        int r2 = r0.getReadHoldCount();
    L6:
        int r4 = 0;
    L7:
        if (r4 >= r2) goto L9;
        r1.unlock();
        r4 = r4 + 1;
        goto L7
    L9:
        ReentrantReadWriteLock.WriteLock r5 = r0.writeLock();
        r5.lock();
        f = r6;     // Catch: Throwable -> L15
        x r7 = x.f38692a;     // Catch: Throwable -> L15
    L11:
        if (r3 >= r2) goto L13;
        r1.lock();
        r3 = r3 + 1;
        goto L11
    L13:
        r5.unlock();
        e();
        return;
    L15:
        th = move-exception;
    L16:
        if (r3 >= r2) goto L18;
        r1.lock();
        r3 = r3 + 1;
        goto L16
    L18:
        r5.unlock();
        throw th;
    L5:
        r2 = 0;
        goto L6
    }

    private final void a(List<String> r9) {
        List r8 = (List) ZeusTransformUtils.wrapperContextForParams(r9, List.class, "com.obric.aiagent.plugin");
        ca r10 = i;
        if (r10 == null) goto L5;
        ca.a.a(r10, null, 1, null);
    L5:
        i = i.a((am) ZeusTransformUtils.preCheckCast(bs.f39169a, am.class, "com.obric.aiagent.plugin"), (g) ZeusTransformUtils.preCheckCast(bd.b(), g.class, "com.obric.aiagent.plugin"), null, (m) ZeusTransformUtils.preCheckCast(new f(r8, null), m.class, "com.obric.aiagent.plugin"), 2, null);
    }

    public final void a(Map<String, String> r7) {
        Map r6 = (Map) ZeusTransformUtils.wrapperContextForParams(r7, Map.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r6, "extra");
        ReentrantReadWriteLock.ReadLock r8 = h.readLock();
        r8.lock();
        Map r1 = (Map) ZeusTransformUtils.preCheckCast(f22511c, Map.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L15
        LinkedHashMap r2 = new LinkedHashMap();     // Catch: Throwable -> L15
        Iterator r3 = r1.entrySet().iterator();     // Catch: Throwable -> L15
    L5:
        if (r3.hasNext() == false) goto L9;
        Map.Entry r4 = (Map.Entry) ZeusTransformUtils.preCheckCast(r3.next(), Map.Entry.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L15
        if (ZeusTransformUtils.instanceOf((com.obric.assistant.dm.api.statemachine.core.d) ZeusTransformUtils.preCheckCast(r4.getValue(), com.obric.assistant.dm.api.statemachine.core.d.class, "com.obric.aiagent.plugin"), com.obric.assistant.dm.impl.statemachine.a.a.class) == false) goto L5;
        r2.put(r4.getKey(), r4.getValue());     // Catch: Throwable -> L15
        goto L5
    L9:
        List r5 = p.o((Iterable) ZeusTransformUtils.preCheckCast(((Map) ZeusTransformUtils.preCheckCast(r2, Map.class, "com.obric.aiagent.plugin")).keySet(), Iterable.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L15
        r8.unlock();
        Iterator r9 = ((Iterable) ZeusTransformUtils.preCheckCast(r5, Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L12:
        if (r9.hasNext() == false) goto L14;
        TaskId r10 = (TaskId) ZeusTransformUtils.preCheckCast(r9.next(), TaskId.class, "com.obric.aiagent.plugin");
        f22509a.a((DMEvent) ZeusTransformUtils.preCheckCast(new ComplexTaskEvent.InterruptTask(r10, r6), DMEvent.class, "com.obric.aiagent.plugin"));
        goto L12
    L14:
        return;
    L15:
        th = move-exception;
        r8.unlock();
        throw th;
    }
}
