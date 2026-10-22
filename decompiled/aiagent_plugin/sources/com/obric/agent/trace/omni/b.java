package com.obric.agent.trace.omni;

import com.google.gson.Gson;
import com.obric.aiagent.assistant.idl.bean.IMMessage;
import com.obric.aiagent.platform.depend.ISecureLogDepend;
import com.obric.assistant.dm.api.statemachine.core.ComplexTaskState;
import com.obric.assistant.dm.api.statemachine.core.DMEvent;
import com.obric.assistant.dm.api.statemachine.core.DMState;
import com.obric.assistant.dm.api.statemachine.core.State;
import com.obric.assistant.dm.api.statemachine.core.TaskId;
import com.obric.assistant.dm.api.statemachine.core.TaskInfo;
import com.obric.assistant.dm.api.statemachine.core.TaskState;
import com.obric.assistant.dm.api.statemachine.core.TaskType;
import com.obric.assistant.dm.api.statemachine.manager.IDialogStateManager;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.ao;
import d.h.b.aa;
import d.x;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlinx.coroutines.am;

/* JADX INFO: compiled from: DmStateListener.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class b implements com.obric.assistant.dm.api.statemachine.core.b {
    private static final String TAG = "DmStateListener";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f15609a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final am f15610b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final d.h.a.r<String, com.obric.agent.trace.omni.a, Map<String, String>, Boolean, x> f15611c;

    /* JADX INFO: compiled from: DmStateListener.kt */
    public static final class a {
        public /* synthetic */ a(d.h.b.h r1) {
            this();
        }

        private a() {
        }
    }

    /* JADX INFO: renamed from: com.obric.agent.trace.omni.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: DmStateListener.kt */
    @d.c.b.a.f(b = "DmStateListener.kt", c = {}, d = "invokeSuspend", e = "com.obric.agent.trace.omni.DmStateListener$onTaskAdded$1")
    static final class C0318b extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f15612a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ b f15613b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f15614c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f15615d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ long f15616e;

        C0318b(b r3, String r4, String r5, long r6, d.c.d<? super C0318b> r8) {
            d.c.d r9 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r8, d.c.d.class, "com.obric.aiagent.plugin");
            this.f15613b = r3;
            this.f15614c = r4;
            this.f15615d = r5;
            this.f15616e = r6;
            super(2, r9);
        }

        public final Object a(am r3, d.c.d<? super x> r4) {
            return ((C0318b) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), C0318b.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r9, d.c.d<?> r10) {
            d.c.d r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r10, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new C0318b(this.f15613b, this.f15614c, this.f15615d, this.f15616e, r7), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r5) {
            d.c.a.b.a();
            if (this.f15612a != 0) goto L7;
            d.o.a(r5);
            b.a(this.f15613b, this.f15614c, this.f15615d, this.f15616e);
            return x.f38692a;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: compiled from: DmStateListener.kt */
    @d.c.b.a.f(b = "DmStateListener.kt", c = {}, d = "invokeSuspend", e = "com.obric.agent.trace.omni.DmStateListener$onTaskEnd$1")
    static final class c extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f15617a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ b f15618b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ TaskInfo f15619c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f15620d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ long f15621e;
        final /* synthetic */ String f;
        final /* synthetic */ IMMessage g;

        c(b r3, TaskInfo r4, String r5, long r6, String r8, IMMessage r9, d.c.d<? super c> r10) {
            d.c.d r11 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r10, d.c.d.class, "com.obric.aiagent.plugin");
            this.f15618b = r3;
            this.f15619c = r4;
            this.f15620d = r5;
            this.f15621e = r6;
            this.f = r8;
            this.g = r9;
            super(2, r11);
        }

        public final Object a(am r3, d.c.d<? super x> r4) {
            return ((c) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), c.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r11, d.c.d<?> r12) {
            d.c.d r9 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r12, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new c(this.f15618b, this.f15619c, this.f15620d, this.f15621e, this.f, this.g, r9), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r10) {
            d.c.a.b.a();
            if (this.f15617a != 0) goto L7;
            d.o.a(r10);
            b r1 = this.f15618b;
            TaskId r2 = this.f15619c.getTaskId();
            String r3 = this.f15620d;
            long r4 = this.f15621e;
            String r6 = this.f;
            d.h.b.o.a(r6);
            b.a(r1, r2, r3, r4, r6, this.g, this.f15619c);
            return x.f38692a;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: compiled from: DmStateListener.kt */
    /* synthetic */ class d extends d.h.b.l implements d.h.a.r<String, com.obric.agent.trace.omni.a, Map<String, ? extends String>, Boolean, x> {
        d(Object r8) {
            super(4, r8, b.class, "reportWithCommonParams", "reportWithCommonParams(Ljava/lang/String;Lcom/obric/agent/trace/omni/BucketSnapshot;Ljava/util/Map;Z)V", 0);
        }

        @Override // d.h.a.r
        public /* synthetic */ x a(String r3, com.obric.agent.trace.omni.a r4, Map<String, ? extends String> r5, Boolean r6) {
            a((String) ZeusTransformUtils.preCheckCast(r3, String.class, "com.obric.aiagent.plugin"), (com.obric.agent.trace.omni.a) ZeusTransformUtils.preCheckCast(r4, com.obric.agent.trace.omni.a.class, "com.obric.aiagent.plugin"), (Map) ZeusTransformUtils.preCheckCast(r5, Map.class, "com.obric.aiagent.plugin"), ((Boolean) ZeusTransformUtils.preCheckCast(r6, Boolean.class, "com.obric.aiagent.plugin")).booleanValue());
            return x.f38692a;
        }

        public final void a(String r3, com.obric.agent.trace.omni.a r4, Map<String, String> r5, boolean r6) {
            Map<String, String> r7 = (Map) ZeusTransformUtils.wrapperContextForParams(r5, Map.class, "com.obric.aiagent.plugin");
            d.h.b.o.e(r3, "p0");
            d.h.b.o.e(r4, "p1");
            d.h.b.o.e(r7, "p2");
            ((b) ZeusTransformUtils.preCheckCast(this.receiver, b.class, "com.obric.aiagent.plugin")).a(r3, r4, r7, r6);
        }
    }

    /* JADX INFO: compiled from: DmStateListener.kt */
    @d.c.b.a.f(b = "DmStateListener.kt", c = {}, d = "invokeSuspend", e = "com.obric.agent.trace.omni.DmStateListener$onTaskStateChanged$1")
    static final class e extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f15622a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ b f15623b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f15624c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f15625d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ State f15626e;
        final /* synthetic */ State f;
        final /* synthetic */ long g;

        e(b r3, String r4, String r5, State r6, State r7, long r8, d.c.d<? super e> r10) {
            d.c.d r11 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r10, d.c.d.class, "com.obric.aiagent.plugin");
            this.f15623b = r3;
            this.f15624c = r4;
            this.f15625d = r5;
            this.f15626e = r6;
            this.f = r7;
            this.g = r8;
            super(2, r11);
        }

        public final Object a(am r3, d.c.d<? super x> r4) {
            return ((e) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), e.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r11, d.c.d<?> r12) {
            d.c.d r9 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r12, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new e(this.f15623b, this.f15624c, this.f15625d, this.f15626e, this.f, this.g, r9), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r9) {
            d.c.a.b.a();
            if (this.f15622a != 0) goto L7;
            d.o.a(r9);
            b.a(this.f15623b, this.f15624c, this.f15625d, this.f15626e, this.f, this.g);
            return x.f38692a;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    static {
        f15609a = new a(null);
    }

    public static /* synthetic */ Map lambda$6KkuILA35wkpa8Gey_pcKw2cZnE(String r0, long r1, b r3, com.obric.agent.trace.omni.a r4) {
        return a(r0, r1, r3, r4);
    }

    public static /* synthetic */ Map lambda$7WIOyiXdZUyShLFVbQPI71CdHIA(long r0, b r2, com.obric.agent.trace.omni.a r3) {
        return a(r0, r2, r3);
    }

    public static /* synthetic */ Map lambda$HBm9sQn2KogwEZPKzqM4jhoVzbM(long r0, b r2, com.obric.agent.trace.omni.a r3) {
        return c(r0, r2, r3);
    }

    public static /* synthetic */ Map lambda$_bzpJDlS_4UC6FuAB2is0UuITV0(long r0, b r2, com.obric.agent.trace.omni.a r3) {
        return d(r0, r2, r3);
    }

    public static /* synthetic */ Map lambda$fqH1ieMizJMeMmYBYXr3T7dxQqs(String r0, long r1, b r3, com.obric.agent.trace.omni.a r4) {
        return b(r0, r1, r3, r4);
    }

    /* JADX INFO: renamed from: lambda$zDq7TYcmhCXMrOnt8Jmf4ui-g_w, reason: not valid java name */
    public static /* synthetic */ Map m107lambda$zDq7TYcmhCXMrOnt8Jmf4uig_w(long r0, b r2, com.obric.agent.trace.omni.a r3) {
        return b(r0, r2, r3);
    }

    @Override // com.obric.assistant.dm.api.statemachine.core.b
    public void a(DMState r1) {
        d.h.b.o.e(r1, "status");
    }

    @Override // com.obric.assistant.dm.api.statemachine.core.b
    public void a(TaskInfo r1, State r2, DMEvent r3, Exception r4) {
        d.h.b.o.e(r1, "taskInfo");
        d.h.b.o.e(r2, "currentState");
        d.h.b.o.e(r4, "exception");
    }

    public b(am r3, d.h.a.r<? super String, ? super com.obric.agent.trace.omni.a, ? super Map<String, String>, ? super Boolean, x> r4) {
        am r5 = (am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin");
        d.h.a.r<String, com.obric.agent.trace.omni.a, Map<String, String>, Boolean, x> r6 = (d.h.a.r) ZeusTransformUtils.wrapperContextForParams(r4, d.h.a.r.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r5, "scope");
        d.h.b.o.e(r6, "doReportWithCommonParams");
        this.f15610b = r5;
        this.f15611c = r6;
    }

    public static final /* synthetic */ void a(b r0, TaskId r1, String r2, long r3, String r5, IMMessage r6, TaskInfo r7) {
        r0.a(r1, r2, r3, r5, r6, r7);
    }

    public static final /* synthetic */ void a(b r0, String r1, String r2, long r3) {
        r0.a(r1, r2, r3);
    }

    public static final /* synthetic */ void a(b r0, String r1, String r2, State r3, State r4, long r5) {
        r0.a(r1, r2, r3, r4, r5);
    }

    public static /* synthetic */ void a(b r1, String r2, com.obric.agent.trace.omni.a r3, Map r4, boolean r5, int r6, Object r7) {
        Map<String, String> r8 = (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.aiagent.plugin");
        if ((r6 & 8) == 0) goto L5;
        r5 = false;
    L5:
        r1.a(r2, r3, r8, r5);
    }

    public final void a(String r3, com.obric.agent.trace.omni.a r4, Map<String, String> r5, boolean r6) {
        Map<String, String> r7 = (Map) ZeusTransformUtils.wrapperContextForParams(r5, Map.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r3, "eventName");
        d.h.b.o.e(r4, "snapshot");
        d.h.b.o.e(r7, "otherParams");
        this.f15611c.a(r3, r4, r7, Boolean.valueOf(r6));
    }

    @Override // com.obric.assistant.dm.api.statemachine.core.b
    public void a(TaskInfo r14) {
        d.h.b.o.e(r14, "taskInfo");
        if (r14.getTaskType() == TaskType.COMPLEX) goto L6;
        ISecureLogDepend.Companion.i(TAG, "onTaskAdded ignored: taskType is not complex, task: " + r14.getTaskId().getValue());
        return;
    L6:
        long r5 = System.currentTimeMillis();
        String r3 = r14.getTaskId().getValue();
        kotlinx.coroutines.i.a(this.f15610b, null, null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new C0318b(this, r3, com.obric.agent.trace.omni.c.a(TaskId.Companion.a(r3)), r5, null), d.h.a.m.class, "com.obric.aiagent.plugin"), 3, null);
    }

    @Override // com.obric.assistant.dm.api.statemachine.core.b
    public void b(TaskInfo r18) {
        d.h.b.o.e(r18, "taskInfo");
        if (r18.getTaskType() == TaskType.COMPLEX) goto L6;
        ISecureLogDepend.Companion.i(TAG, "onTaskEnd ignored: taskType is not complex, task: " + r18.getTaskId().getValue());
        return;
    L6:
        long r5 = System.currentTimeMillis();
        String r4 = com.obric.agent.trace.omni.c.a(TaskId.Companion.a(r18.getTaskId().getValue()));
        String r7 = new Gson().toJson(r18.getMessage());
        ISecureLogDepend.Companion.i(TAG, "onTaskEndInner, messageId: " + r4 + ", " + new Gson().toJson(r18.getExt()));
        IDialogStateManager r0 = (IDialogStateManager) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IDialogStateManager.class), IDialogStateManager.class, "com.obric.aiagent.plugin");
        if (r0 == null) goto L9;
        DMState r1 = r0.getCurrentDMState();
    L10:
        if (r1 == null) goto L23;
        List<State> r2 = r1.getActiveTasks();
        if (r2 == null) goto L23;
        Iterator r3 = ((Iterable) ZeusTransformUtils.preCheckCast(r2, Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L15:
        if (r3.hasNext() == false) goto L19;
        Object r6 = r3.next();
        if (d.h.b.o.a(((State) ZeusTransformUtils.preCheckCast(r6, State.class, "com.obric.aiagent.plugin")).getTaskId(), r18.getTaskId()) == false) goto L15;
    L20:
        State r8 = (State) ZeusTransformUtils.preCheckCast(r6, State.class, "com.obric.aiagent.plugin");
        if (r8 == null) goto L23;
        TaskState r9 = (TaskState) ZeusTransformUtils.preCheckCast(r8, TaskState.class, "com.obric.aiagent.plugin");
    L24:
        if (r9 == null) goto L30;
        Map<String, String> r10 = r9.getExtra();
        if (r10 == null) goto L30;
        String r11 = (String) ZeusTransformUtils.preCheckCast(r10.get("message_reply"), String.class, "com.obric.aiagent.plugin");
        if (r11 == null) goto L30;
        IMMessage r12 = (IMMessage) ZeusTransformUtils.preCheckCast(com.obric.eventkit.eventstaskmanager.b.a().fromJson(r11, IMMessage.class), IMMessage.class, "com.obric.aiagent.plugin");
    L31:
        kotlinx.coroutines.i.a(this.f15610b, null, null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new c(this, r18, r4, r5, r7, r12, null), d.h.a.m.class, "com.obric.aiagent.plugin"), 3, null);
        return;
    L30:
        r12 = null;
        goto L31
    L19:
        r6 = null;
    L23:
        r9 = null;
        goto L24
    L9:
        r1 = null;
        goto L10
    }

    @Override // com.obric.assistant.dm.api.statemachine.core.b
    public void a(TaskInfo r16, State r17, State r18, DMEvent r19) {
        d.h.b.o.e(r16, "taskInfo");
        d.h.b.o.e(r18, "newState");
        if (r16.getTaskType() == TaskType.COMPLEX) goto L6;
        ISecureLogDepend.Companion.i(TAG, "onTaskStateChanged ignored: taskType is not complex, task: " + r16.getTaskId().getValue());
        return;
    L6:
        long r7 = System.currentTimeMillis();
        String r3 = r16.getTaskId().getValue();
        kotlinx.coroutines.i.a(this.f15610b, null, null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new e(this, r3, com.obric.agent.trace.omni.c.a(TaskId.Companion.a(r3)), r17, r18, r7, null), d.h.a.m.class, "com.obric.aiagent.plugin"), 3, null);
    }

    private final void a(String r4, String r5, long r6) {
        CharSequence r3 = (CharSequence) ZeusTransformUtils.preCheckCast(r5, CharSequence.class, "com.obric.aiagent.plugin");
        if (r3 != null) goto L5;
    L8:
        boolean r7 = true;
    L10:
        if (r7 == false) goto L13;
        ISecureLogDepend.Companion.e(TAG, "onTaskAddedInner ignored: messageId is blank, taskId: " + r4);
        return;
    L13:
        ISecureLogDepend.Companion.i(TAG, "onTaskAddedInner, taskId: " + r4 + ", messageId: " + r5);
        k.f15686a.a(r5, ao.a(d.s.a("task_added", Long.valueOf(r6))));
        return;
    L5:
        if (r3.length() == 0) goto L8;
        r7 = false;
        goto L10
    }

    private final void a(TaskId r11, String r12, long r13, String r15, IMMessage r16, TaskInfo r17) {
        m.f15694a.a(r12, r11.getValue(), r13, r15, r16, r17.getExt(), ao.a(d.s.a("report_type", "normal")), (d.h.a.r) ZeusTransformUtils.preCheckCast(new d(this), d.h.a.r.class, "com.obric.aiagent.plugin"));
    }

    private final void a(String r8, final String r9, State r10, State r11, final long r12) {
        if (r10 != null) goto L5;
    L7:
        boolean r2 = false;
    L8:
        if (r2 == false) goto L10;
        return;
    L10:
        CharSequence r3 = (CharSequence) ZeusTransformUtils.preCheckCast(r9, CharSequence.class, "com.obric.aiagent.plugin");
        if (r3 != null) goto L13;
    L16:
        boolean r4 = true;
    L18:
        if (r4 == false) goto L21;
        ISecureLogDepend.Companion.e(TAG, "onTaskStateChangedInner ignored: messageId is blank, taskId: " + r8);
        return;
    L21:
        ISecureLogDepend.Companion r13 = ISecureLogDepend.Companion;
        StringBuilder r5 = new StringBuilder().append("onTaskStateChangedInner, messageId: ").append(r9).append(", previousState: ");
        if (r10 == null) goto L24;
        String r6 = aa.b(r10.getClass()).b();
    L25:
        r13.i(TAG, r5.append(r6).append(", newState: ").append(aa.b(r11.getClass()).b()).toString());
        if (ZeusTransformUtils.instanceOf(r10, ComplexTaskState.Queueing.class) == false) goto L29;
        k.f15686a.a(r9, ao.a(d.s.a("queueing_end", Long.valueOf(r12))));
    L37:
        if (ZeusTransformUtils.instanceOf(r11, ComplexTaskState.Queueing.class) == false) goto L40;
        k.f15686a.a(r9, ao.a(d.s.a("queueing_start", Long.valueOf(r12))));
        return;
    L40:
        if (ZeusTransformUtils.instanceOf(r11, ComplexTaskState.Clarify.class) == false) goto L43;
        k.f15686a.a(r9, new $$Lambda$b$zDq7TYcmhCXMrOnt8Jmf4uig_w(r12, this));
        return;
    L43:
        if (ZeusTransformUtils.instanceOf(r11, ComplexTaskState.ClarifyAck.class) == false) goto L46;
        k.f15686a.a(r9, new $$Lambda$b$HBm9sQn2KogwEZPKzqM4jhoVzbM(r12, this));
        return;
    L46:
        if (ZeusTransformUtils.instanceOf(r11, ComplexTaskState.CallUser.class) == false) goto L49;
        k.f15686a.a(r9, new $$Lambda$b$_bzpJDlS_4UC6FuAB2is0UuITV0(r12, this));
        return;
    L49:
        if (ZeusTransformUtils.instanceOf(r11, ComplexTaskState.TakingOver.class) == false) goto L52;
        k.f15686a.a(r9, new $$Lambda$b$fqH1ieMizJMeMmYBYXr3T7dxQqs(r9, r12, this));
        return;
    L52:
        if (ZeusTransformUtils.instanceOf(r11, ComplexTaskState.Terminated.class) == false) goto L66;
        ISecureLogDepend.Companion r7 = ISecureLogDepend.Companion;
        StringBuilder r14 = new StringBuilder().append("onTaskStateChangedInner, messageId: ").append(r9).append(", task ext: ");
        TaskInfo r15 = ((ComplexTaskState.Terminated) ZeusTransformUtils.preCheckCast(r11, ComplexTaskState.Terminated.class, "com.obric.aiagent.plugin")).getTaskInfo();
        if (r15 == null) goto L58;
        Map<String, String> r16 = r15.getExt();
        if (r16 == null) goto L58;
        String r17 = r16.toString();
    L59:
        r7.i(TAG, r14.append(r17).append(", state ext: ").append(((ComplexTaskState.Terminated) ZeusTransformUtils.preCheckCast(r11, ComplexTaskState.Terminated.class, "com.obric.aiagent.plugin")).getExtra()).toString());
        k.f15686a.a(r9, ao.a(new d.m[]{d.s.a("is_interrupted", true), d.s.a("mark_interrupted_position", "dm")}));
        return;
    L58:
        r17 = null;
        goto L59
    L66:
        return;
    L29:
        if (ZeusTransformUtils.instanceOf(r10, ComplexTaskState.CallUser.class) == false) goto L34;
        if (ZeusTransformUtils.instanceOf(r11, ComplexTaskState.TakingOver.class) == true) goto L37;
        k.f15686a.a(r9, new $$Lambda$b$7WIOyiXdZUyShLFVbQPI71CdHIA(r12, this));
        goto L37
    L34:
        if (ZeusTransformUtils.instanceOf(r10, ComplexTaskState.TakingOver.class) == false) goto L37;
        k.f15686a.a(r9, new $$Lambda$b$6KkuILA35wkpa8Gey_pcKw2cZnE(r9, r12, this));
        goto L37
    L24:
        r6 = "";
        goto L25
    L13:
        if (r3.length() == 0) goto L16;
        r4 = false;
        goto L18
    L5:
        if (r10.getState() != r11.getState()) goto L7;
        r2 = true;
        goto L8
    }

    private static final Map b(long r14, b r16, com.obric.agent.trace.omni.a r17) {
        if (r17 == null) goto L4;
        t r0 = r16.a(r17);
    L5:
        if (r17 == null) goto L11;
        Map r3 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.aiagent.plugin");
        if (r0 == null) goto L9;
        r3.put("current_tool_name", r0.b());
        r3.put("current_tool_id", r0.a());
    L9:
        x r1 = x.f38692a;
        a(r16, "obric_omni_model_clarify_start", r17, r3, false, 8, null);
    L11:
        return ao.a(d.s.a("clarify_start", new s(r14, 0, 2, null)));
    L4:
        r0 = null;
        goto L5
    }

    private static final Map d(long r16, b r18, com.obric.agent.trace.omni.a r19) {
        if (r19 == null) goto L4;
        t r0 = r18.a(r19);
    L5:
        if (r19 == null) goto L11;
        Map r3 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.aiagent.plugin");
        if (r0 == null) goto L9;
        r3.put("current_tool_name", r0.b());
        r3.put("current_tool_id", r0.a());
    L9:
        x r1 = x.f38692a;
        a(r18, "obric_omni_model_call_user_start", r19, r3, false, 8, null);
    L11:
        return ao.a(d.s.a("call_user_start", new r(r16, 0, 0, 6, null)));
    L4:
        r0 = null;
        goto L5
    }

    private final t a(com.obric.agent.trace.omni.a r4) {
        if (r4 != null) goto L5;
        return null;
    L5:
        List r0 = (List) ZeusTransformUtils.preCheckCast(r4.b().get("dispatch_intent_start"), List.class, "com.obric.aiagent.plugin");
        if (r0 == null) goto L13;
        Object r1 = d.a.p.n(r0);
        if (r1 == null) goto L13;
        if (ZeusTransformUtils.instanceOf(r1, t.class) == false) goto L13;
    L14:
        t r2 = (t) ZeusTransformUtils.preCheckCast(r1, t.class, "com.obric.aiagent.plugin");
        List r5 = (List) ZeusTransformUtils.preCheckCast(r4.b().get("dispatch_intent_end"), List.class, "com.obric.aiagent.plugin");
        if (r5 == null) goto L22;
        Object r6 = d.a.p.n(r5);
        if (r6 == null) goto L22;
        if (ZeusTransformUtils.instanceOf(r6, t.class) == false) goto L22;
    L23:
        t r7 = (t) ZeusTransformUtils.preCheckCast(r6, t.class, "com.obric.aiagent.plugin");
        if (r2 != null) goto L26;
        return null;
    L26:
        if (r7 != null) goto L29;
        return r2;
    L29:
        if (d.h.b.o.a(r2.b(), r7.b()) == true) goto L31;
        return r2;
    L31:
        return r7;
    L22:
        r6 = null;
    L13:
        r1 = null;
        goto L14
    }

    private static final Map a(long r11, b r13, com.obric.agent.trace.omni.a r14) {
        if (r14 == null) goto L14;
        List r1 = (List) ZeusTransformUtils.preCheckCast(r14.b().get("call_user_start"), List.class, "com.obric.aiagent.plugin");
        if (r1 == null) goto L12;
        Object r2 = d.a.p.n(r1);
        if (r2 == null) goto L12;
        if (ZeusTransformUtils.instanceOf(r2, r.class) == false) goto L12;
    L13:
        r r3 = (r) ZeusTransformUtils.preCheckCast(r2, r.class, "com.obric.aiagent.plugin");
    L15:
        if (r3 != null) goto L18;
        ISecureLogDepend.Companion.e(TAG, "onTaskStateChangedInner ignored: call user start is null");
        return null;
    L18:
        r r12 = r.a(r3, 0, 0, r11, 3, null);
        long r4 = r12.c() - r3.a();
        t r15 = r13.a(r14);
        Map r6 = ao.b(new d.m[]{d.s.a("duration", String.valueOf(r4)), d.s.a("call_user_type", "model")});
        if (r15 == null) goto L21;
        r6.put("current_tool_name", r15.b());
        r6.put("current_tool_id", r15.a());
    L21:
        x r16 = x.f38692a;
        a(r13, "obric_omni_user_call_user_finish", r14, r6, false, 8, null);
        return ao.a(d.s.a("call_user_end", r12));
    L12:
        r2 = null;
        goto L13
    L14:
        r3 = null;
        goto L15
    }

    private static final Map a(String r20, long r21, b r23, com.obric.agent.trace.omni.a r24) {
        if (r24 == null) goto L23;
        List r3 = (List) ZeusTransformUtils.preCheckCast(r24.b().get("taking_over_start"), List.class, "com.obric.aiagent.plugin");
        if (r3 == null) goto L12;
        Object r4 = d.a.p.n(r3);
        if (r4 == null) goto L12;
        if (ZeusTransformUtils.instanceOf(r4, u.class) == false) goto L12;
    L13:
        Object r5 = (u) ZeusTransformUtils.preCheckCast(r4, u.class, "com.obric.aiagent.plugin");
        if (r5 != null) goto L25;
        List r6 = (List) ZeusTransformUtils.preCheckCast(r24.b().get("taking_over_start"), List.class, "com.obric.aiagent.plugin");
        if (r6 == null) goto L23;
        r5 = d.a.p.n(r6);
        if (r5 == null) goto L23;
        if (ZeusTransformUtils.instanceOf(r5, r.class) == false) goto L23;
    L25:
        if (r5 != null) goto L28;
        ISecureLogDepend.Companion.e(TAG, "onTaskStateChangedInner ignored: taking over start is null");
        return null;
    L28:
        Map r10 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r5, u.class) == false) goto L32;
        ISecureLogDepend.Companion.i(TAG, "onTaskStateChangedInner, messageId: " + r20 + ", taking over end");
        u r0 = u.a((u) ZeusTransformUtils.preCheckCast(r5, u.class, "com.obric.aiagent.plugin"), 0, r21, 1, null);
        r10.put("taking_over_end", r0);
        r10.put("call_user_end", r0);
        long r1 = r0.b() - ((u) ZeusTransformUtils.preCheckCast(r5, u.class, "com.obric.aiagent.plugin")).a();
        String r2 = "user";
    L34:
        t r7 = r23.a(r24);
        Map r8 = ao.b(new d.m[]{d.s.a("duration", String.valueOf(r1)), d.s.a("call_user_type", r2)});
        if (r7 == null) goto L37;
        r8.put("current_tool_name", r7.b());
        r8.put("current_tool_id", r7.a());
    L37:
        x r9 = x.f38692a;
        a(r23, "obric_omni_user_call_user_finish", r24, r8, false, 8, null);
        return r10;
    L32:
        if (ZeusTransformUtils.instanceOf(r5, r.class) == false) goto L39;
        ISecureLogDepend.Companion.i(TAG, "onTaskStateChangedInner, messageId: " + r20 + ", call user and taking over end");
        r r11 = r.a((r) ZeusTransformUtils.preCheckCast(r5, r.class, "com.obric.aiagent.plugin"), 0, 0, r21, 3, null);
        r10.put("taking_over_end", r11);
        r10.put("call_user_end", r11);
        r1 = r11.c() - ((r) ZeusTransformUtils.preCheckCast(r5, r.class, "com.obric.aiagent.plugin")).a();
        r2 = "model";
        goto L34
    L39:
        ISecureLogDepend.Companion.e(TAG, "onTaskStateChangedInner ignored: unknown bean type");
        return null;
    L12:
        r4 = null;
    L23:
        r5 = null;
        goto L25
    }

    private static final Map c(long r10, b r12, com.obric.agent.trace.omni.a r13) {
        if (r13 == null) goto L14;
        List r1 = (List) ZeusTransformUtils.preCheckCast(r13.b().get("clarify_start"), List.class, "com.obric.aiagent.plugin");
        if (r1 == null) goto L12;
        Object r2 = d.a.p.n(r1);
        if (r2 == null) goto L12;
        if (ZeusTransformUtils.instanceOf(r2, s.class) == false) goto L12;
    L13:
        s r3 = (s) ZeusTransformUtils.preCheckCast(r2, s.class, "com.obric.aiagent.plugin");
    L15:
        if (r3 != null) goto L18;
        ISecureLogDepend.Companion.e(TAG, "onTaskStateChangedInner ignored: clarify start is null");
        return null;
    L18:
        s r11 = s.a(r3, 0, r10, 1, null);
        t r14 = r12.a(r13);
        Map r6 = ao.b(new d.m[]{d.s.a("duration", String.valueOf(r11.b() - r3.a()))});
        if (r14 == null) goto L21;
        r6.put("current_tool_name", r14.b());
        r6.put("current_tool_id", r14.a());
    L21:
        x r15 = x.f38692a;
        a(r12, "obric_omni_user_reply_clarify_finish", r13, r6, false, 8, null);
        return ao.a(d.s.a("clarify_end", r11));
    L12:
        r2 = null;
        goto L13
    L14:
        r3 = null;
        goto L15
    }

    private static final Map b(String r15, long r16, b r18, com.obric.agent.trace.omni.a r19) {
        t r1 = null;
        if (r19 == null) goto L14;
        List r2 = (List) ZeusTransformUtils.preCheckCast(r19.b().get("call_user_start"), List.class, "com.obric.aiagent.plugin");
        if (r2 == null) goto L12;
        Object r3 = d.a.p.n(r2);
        if (r3 == null) goto L12;
        if (ZeusTransformUtils.instanceOf(r3, r.class) == false) goto L12;
    L13:
        r r7 = (r) ZeusTransformUtils.preCheckCast(r3, r.class, "com.obric.aiagent.plugin");
    L15:
        ISecureLogDepend.Companion r4 = ISecureLogDepend.Companion;
        StringBuilder r5 = new StringBuilder().append("onTaskStateChangedInner, messageId: ").append(r15).append(", taking over start, ");
        if (r7 == null) goto L18;
        Long r6 = Long.valueOf(r7.a());
    L19:
        r4.i(TAG, r5.append(r6).toString());
        if (r19 == null) goto L22;
        r1 = r18.a(r19);
    L22:
        if (r19 == null) goto L28;
        Map r8 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.aiagent.plugin");
        if (r1 == null) goto L26;
        r8.put("current_tool_name", r1.b());
        r8.put("current_tool_id", r1.a());
    L26:
        x r0 = x.f38692a;
        a(r18, "obric_omni_user_operate_start", r19, r8, false, 8, null);
    L28:
        if (r7 != null) goto L31;
        return ao.a(d.s.a("taking_over_start", new u(r16, 0, 2, null)));
    L31:
        return ao.a(d.s.a("taking_over_start", r.a(r7, 0, r16, 0, 5, null)));
    L18:
        r6 = null;
    L12:
        r3 = null;
        goto L13
    L14:
        r7 = null;
        goto L15
    }
}
