package com.obric.autogui.biztrack;

import android.os.Bundle;
import com.obric.autogui.agents.scripted.impl.w;
import com.obric.autogui.common.AutoOperateTask;
import com.obric.autogui.common.api.AOBizTracking;
import com.obric.autogui.common.api.AOSystemTools;
import com.obric.autogui.common.api.agent.BizStatus;
import com.obric.autogui.common.api.agent.IAutoActionAgentEventListener;
import com.obric.autogui.common.api.agent.QueueStatus;
import com.obric.autogui.common.api.logging.LogUtil;
import com.obric.autogui.common.api.logging.Loog;
import com.obric.autogui.common.api.platform.tracking.IAutoActionTrackingApi;
import com.obric.autogui.common.b.d;
import com.obric.autogui.session.state.a.e;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;
import d.x;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import org.json.JSONObject;

/* JADX INFO: compiled from: OperatorBizTrackingListener.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class OperatorBizTrackingListener implements IAutoActionAgentEventListener {
    public static final a Companion = null;
    private static final String TAG = "Operator-BizTrack";

    /* JADX INFO: compiled from: OperatorBizTrackingListener.kt */
    public static final class a {
        public /* synthetic */ a(h r1) {
            this();
        }

        private a() {
        }
    }

    /* JADX INFO: compiled from: OperatorBizTrackingListener.kt */
    private static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private long f28942a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private long f28943b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private int f28944c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private String f28945d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private int f28946e;
        private boolean f;
        private Bundle g;
        private List<c> h;
        private List<String> i;

        /* JADX INFO: compiled from: OperatorBizTrackingListener.kt */
        public static final class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private long f28947a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private long f28948b;

            public a() {
                this(0, 0, 3, null);
            }

            public boolean equals(Object r9) {
                if (this != r9) goto L6;
                return true;
            L6:
                if (ZeusTransformUtils.instanceOf(r9, a.class) == true) goto L8;
                return false;
            L8:
                a r10 = (a) ZeusTransformUtils.preCheckCast(r9, a.class, "com.obric.aiagent.plugin");
                if (this.f28947a == r10.f28947a) goto L12;
                return false;
            L12:
                if (this.f28948b == r10.f28948b) goto L14;
                return false;
            L14:
                return true;
            }

            public int hashCode() {
                return (Long.hashCode(this.f28947a) * 31) + Long.hashCode(this.f28948b);
            }

            public String toString() {
                return "SessionTimings(operatingDurationMillis=" + this.f28947a + ", pausedDurationMillis=" + this.f28948b + ')';
            }

            public a(long r1, long r3) {
                this.f28947a = r1;
                this.f28948b = r3;
            }

            public /* synthetic */ a(long r3, long r5, int r7, h r8) {
                if ((r7 & 1) == 0) goto L6;
                r3 = 0;
            L6:
                if ((r7 & 2) == 0) goto L8;
                r5 = 0;
            L8:
                this(r3, r5);
            }

            public final long a() {
                return this.f28947a;
            }

            public final void a(long r1) {
                this.f28947a = r1;
            }

            public final long b() {
                return this.f28948b;
            }

            public final void b(long r1) {
                this.f28948b = r1;
            }
        }

        /* JADX INFO: renamed from: com.obric.autogui.biztrack.OperatorBizTrackingListener$b$b, reason: collision with other inner class name */
        /* JADX INFO: compiled from: OperatorBizTrackingListener.kt */
        public /* synthetic */ class C0725b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f28949a = null;

            static {
                int[] r0 = new int[BizStatus.values().length];
                r0[BizStatus.OPERATING.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
            L11:
                r0[BizStatus.PAUSED.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
            L15:
                r0[BizStatus.USER_INTERRUPTED.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
            L6:
                f28949a = r0;
            }
        }

        public b() {
            this(0, 0, 0, null, 0, false, null, null, null, 511, null);
        }

        public boolean equals(Object r9) {
            if (this != r9) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r9, b.class) == true) goto L8;
            return false;
        L8:
            b r10 = (b) ZeusTransformUtils.preCheckCast(r9, b.class, "com.obric.aiagent.plugin");
            if (this.f28942a == r10.f28942a) goto L12;
            return false;
        L12:
            if (this.f28943b == r10.f28943b) goto L15;
            return false;
        L15:
            if (this.f28944c == r10.f28944c) goto L18;
            return false;
        L18:
            if (o.a(this.f28945d, r10.f28945d) == true) goto L21;
            return false;
        L21:
            if (this.f28946e == r10.f28946e) goto L24;
            return false;
        L24:
            if (this.f == r10.f) goto L27;
            return false;
        L27:
            if (o.a(this.g, r10.g) == true) goto L30;
            return false;
        L30:
            if (o.a(this.h, r10.h) == true) goto L33;
            return false;
        L33:
            if (o.a(this.i, r10.i) == true) goto L35;
            return false;
        L35:
            return true;
        }

        public int hashCode() {
            int r0 = ((((Long.hashCode(this.f28942a) * 31) + Long.hashCode(this.f28943b)) * 31) + Integer.hashCode(this.f28944c)) * 31;
            String r1 = this.f28945d;
            int r2 = 0;
            if (r1 != null) goto L5;
            int r3 = 0;
        L6:
            int r4 = (((((r0 + r3) * 31) + Integer.hashCode(this.f28946e)) * 31) + Boolean.hashCode(this.f)) * 31;
            Bundle r5 = this.g;
            if (r5 == null) goto L11;
            r2 = r5.hashCode();
        L11:
            return ((((r4 + r2) * 31) + this.h.hashCode()) * 31) + this.i.hashCode();
        L5:
            r3 = r1.hashCode();
            goto L6
        }

        public String toString() {
            return "SessionExecutionTracker(startedBootTime=" + this.f28942a + ", finishedBootTime=" + this.f28943b + ", terminationType=" + this.f28944c + ", terminationReason=" + this.f28945d + ", stepCount=" + this.f28946e + ", hasExecutedScript=" + this.f + ", extras=" + this.g + ", stateChangeRecords=" + this.h + ", actionTypeRecords=" + this.i + ')';
        }

        public b(long r3, long r5, int r7, String r8, int r9, boolean r10, Bundle r11, List<c> r12, List<String> r13) {
            List<c> r14 = (List) ZeusTransformUtils.wrapperContextForParams(r12, List.class, "com.obric.aiagent.plugin");
            List<String> r15 = (List) ZeusTransformUtils.wrapperContextForParams(r13, List.class, "com.obric.aiagent.plugin");
            o.e(r14, "stateChangeRecords");
            o.e(r15, "actionTypeRecords");
            this.f28942a = r3;
            this.f28943b = r5;
            this.f28944c = r7;
            this.f28945d = r8;
            this.f28946e = r9;
            this.f = r10;
            this.g = r11;
            this.h = r14;
            this.i = r15;
        }

        public final void a(long r1) {
            this.f28943b = r1;
        }

        public final void a(int r1) {
            this.f28944c = r1;
        }

        public final void a(String r1) {
            this.f28945d = r1;
        }

        public final int a() {
            return this.f28946e;
        }

        public final void b(int r1) {
            this.f28946e = r1;
        }

        public final void a(Bundle r1) {
            this.g = r1;
        }

        public /* synthetic */ b(long r15, long r17, int r19, String r20, int r21, boolean r22, Bundle r23, List r24, List r25, int r26, h r27) {
            List r1 = (List) ZeusTransformUtils.wrapperContextForParams(r24, List.class, "com.obric.aiagent.plugin");
            List r3 = (List) ZeusTransformUtils.wrapperContextForParams(r25, List.class, "com.obric.aiagent.plugin");
            long r5 = 0;
            if ((r26 & 1) == 0) goto L5;
            long r7 = 0;
        L7:
            if ((r26 & 2) != 0) goto L11;
            r5 = r17;
        L11:
            if ((r26 & 4) == 0) goto L13;
            int r4 = 2;
        L14:
            Bundle r10 = null;
            if ((r26 & 8) == 0) goto L17;
            String r9 = null;
        L18:
            boolean r12 = false;
            if ((r26 & 16) == 0) goto L21;
            int r11 = 0;
        L23:
            if ((r26 & 32) != 0) goto L27;
            r12 = r22;
        L27:
            if ((r26 & 64) != 0) goto L31;
            r10 = r23;
        L31:
            if ((r26 & 128) == 0) goto L34;
            r1 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.aiagent.plugin");
        L34:
            if ((r26 & 256) == 0) goto L36;
            r3 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.aiagent.plugin");
        L36:
            this(r7, r5, r4, r9, r11, r12, r10, r1, r3);
            return;
        L21:
            r11 = r21;
            goto L23
        L17:
            r9 = r20;
            goto L18
        L13:
            r4 = r19;
            goto L14
        L5:
            r7 = r15;
            goto L7
        }

        public final List<c> b() {
            return this.h;
        }

        public final List<String> c() {
            return this.i;
        }

        private final int e() {
            int r1 = 0;
            int r2 = 0;
        L4:
            if (r1 >= this.i.size()) goto L16;
            if (o.a(this.i.get(r1), "open_app") == false) goto L7;
            r1 = r1 + 1;
            int r3 = 0;
        L10:
            if (r1 >= this.i.size()) goto L14;
            if (o.a(this.i.get(r1), "wait") == false) goto L14;
            r3 = r3 + 1;
            r1 = r1 + 1;
        L14:
            if (r3 <= r2) goto L4;
            r2 = r3;
            goto L4
        L7:
            r1 = r1 + 1;
            goto L4
        L16:
            return r2;
        }

        public final void a(IAutoActionAgentEventListener.SessionInfo r14) {
            o.e(r14, "sessionInfo");
            long r0 = this.f28943b - this.f28942a;
            a r2 = a((Collection) ZeusTransformUtils.preCheckCast(this.h, Collection.class, "com.obric.aiagent.plugin"));
            IAutoActionTrackingApi r5 = (IAutoActionTrackingApi) ZeusTransformUtils.preCheckCast(AOBizTracking.INSTANCE, IAutoActionTrackingApi.class, "com.obric.aiagent.plugin");
            JSONObject r7 = new JSONObject();
            Bundle r3 = this.g;
            if (r3 == null) goto L5;
            Bundle r4 = r3.getBundle("task_end_reports");
        L6:
            r7.put("duration", r0);
            r7.put("term_type", this.f28944c);
            String r1 = this.f28945d;
            if (r1 != null) goto L9;
        L17:
            d r6 = d.f29009a;
            int r8 = this.f28944c;
            if (r4 == null) goto L20;
            String r9 = r4.getString("model_end_reason");
        L21:
            r7.put("term_type_v2", r6.a(r8, r9));
            r7.put("step_count", this.f28946e);
            r7.put("open_app_follow_wait_count", e());
            r7.put("exec_duration", r2.a());
            r7.put("wait_duration", r2.b());
            r7.put("state_change_records", this.h);
            r7.put("has_executed_script", this.f);
            if (this.f == false) goto L31;
            Object r10 = r14.getTask().getInternalExtras().get("ao_script_version_snapshot");
            if (ZeusTransformUtils.instanceOf(r10, w.a.class) == false) goto L26;
            w.a r11 = (w.a) ZeusTransformUtils.preCheckCast(r10, w.a.class, "com.obric.aiagent.plugin");
        L27:
            if (r11 != null) goto L29;
            r11 = w.f27103a.a();
        L29:
            if (r11 == null) goto L31;
            r11.a(r7);
            goto L31
        L26:
            r11 = null;
        L31:
            if (r4 == null) goto L36;
            Set<String> r12 = r4.keySet();
            o.c(r12, "keySet(...)");
            Iterator r13 = ((Iterable) ZeusTransformUtils.preCheckCast(r12, Iterable.class, "com.obric.aiagent.plugin")).iterator();
        L34:
            if (r13.hasNext() == false) goto L36;
            String r15 = (String) ZeusTransformUtils.preCheckCast(r13.next(), String.class, "com.obric.aiagent.plugin");
            r7.putOpt(r15, r4.get(r15));
        L36:
            Bundle r16 = this.g;
            if (r16 == null) goto L48;
            Set<String> r17 = r16.keySet();
            if (r17 == null) goto L48;
            Iterator r18 = ((Iterable) ZeusTransformUtils.preCheckCast(r17, Iterable.class, "com.obric.aiagent.plugin")).iterator();
        L42:
            if (r18.hasNext() == false) goto L48;
            String r19 = (String) ZeusTransformUtils.preCheckCast(r18.next(), String.class, "com.obric.aiagent.plugin");
            Bundle r20 = this.g;
            if (r20 == null) goto L46;
            Object r21 = r20.get(r19);
        L47:
            r7.put(r19, r21);
            goto L42
        L46:
            r21 = null;
        L48:
            com.obric.autogui.session.c.b.a(r7, r14);
            x r110 = x.f38692a;
            IAutoActionTrackingApi.DefaultImpls.reportEvent$default(r5, "exec_record", r7, false, false, null, 28, null);
            return;
        L20:
            r9 = null;
            goto L21
        L9:
            if (((CharSequence) ZeusTransformUtils.preCheckCast(r1, CharSequence.class, "com.obric.aiagent.plugin")).length() <= 0) goto L11;
            boolean r22 = true;
        L12:
            if (r22 == true) goto L15;
            r1 = null;
        L15:
            if (r1 == null) goto L17;
            r7.put("term_reason", r1);
            goto L17
        L11:
            r22 = false;
            goto L12
        L5:
            r4 = null;
            goto L6
        }

        private final a a(Collection<c> r10) {
            Collection r11 = (Collection) ZeusTransformUtils.wrapperContextForParams(r10, Collection.class, "com.obric.aiagent.plugin");
            a r0 = new a(0, 0, 3, null);
            if (r11.isEmpty() == false) goto L5;
            return r0;
        L5:
            c r2 = null;
            Iterator r3 = r11.iterator();
        L7:
            if (r3.hasNext() == false) goto L25;
            c r4 = (c) ZeusTransformUtils.preCheckCast(r3.next(), c.class, "com.obric.aiagent.plugin");
            if (r2 == null) goto L24;
            if (r2.b() != r4.a()) goto L13;
            long r5 = r4.c() - r2.c();
            int r6 = C0725b.f28949a[r2.b().ordinal()];
            if (r6 != 1) goto L18;
            r0.a(r0.a() + r5);
            goto L24
        L18:
            if (r6 != 2) goto L20;
        L22:
            r0.b(r0.b() + r5);
            goto L24
        L20:
            if (r6 == 3) goto L22;
        L13:
            Loog.INSTANCE.e(LogUtil.INSTANCE.getCLAZZ_TAG(this), "weird state-change data: " + r11);
            return r0;
        L24:
            r2 = r4;
            goto L7
        L25:
            return r0;
        }

        public final void d() {
            this.f = true;
        }
    }

    /* JADX INFO: compiled from: OperatorBizTrackingListener.kt */
    private static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final BizStatus f28950a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final BizStatus f28951b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final long f28952c;

        public boolean equals(Object r7) {
            if (this != r7) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r7, c.class) == true) goto L8;
            return false;
        L8:
            c r8 = (c) ZeusTransformUtils.preCheckCast(r7, c.class, "com.obric.aiagent.plugin");
            if (this.f28950a == r8.f28950a) goto L12;
            return false;
        L12:
            if (this.f28951b == r8.f28951b) goto L15;
            return false;
        L15:
            if (this.f28952c == r8.f28952c) goto L17;
            return false;
        L17:
            return true;
        }

        public int hashCode() {
            return (((this.f28950a.hashCode() * 31) + this.f28951b.hashCode()) * 31) + Long.hashCode(this.f28952c);
        }

        public String toString() {
            return "StateChangeRecord(fromState=" + this.f28950a + ", toState=" + this.f28951b + ", atMillis=" + this.f28952c + ')';
        }

        public c(BizStatus r2, BizStatus r3, long r4) {
            o.e(r2, "fromState");
            o.e(r3, "toState");
            this.f28950a = r2;
            this.f28951b = r3;
            this.f28952c = r4;
        }

        public final BizStatus a() {
            return this.f28950a;
        }

        public final BizStatus b() {
            return this.f28951b;
        }

        public final long c() {
            return this.f28952c;
        }
    }

    static {
        Companion = new a(null);
    }

    public OperatorBizTrackingListener() {
    }

    @Override // com.obric.autogui.common.api.agent.IAutoActionAgentEventListener
    public void afterAgentStep(IAutoActionAgentEventListener.SessionInfo r1, IAutoActionAgentEventListener.AgentStepInfo r2, IAutoActionAgentEventListener.AgentStepExecInfo r3) {
        IAutoActionAgentEventListener.DefaultImpls.afterAgentStep(this, r1, r2, r3);
    }

    @Override // com.obric.autogui.common.api.agent.IAutoActionAgentEventListener
    public void onOperatingAppChanged(IAutoActionAgentEventListener.SessionInfo r1, IAutoActionAgentEventListener.OperatingAppInfo r2) {
        IAutoActionAgentEventListener.DefaultImpls.onOperatingAppChanged(this, r1, r2);
    }

    @Override // com.obric.autogui.common.api.agent.IAutoActionAgentEventListener
    public void onQueueStatusChanged(IAutoActionAgentEventListener.SessionInfo r1, QueueStatus r2) {
        IAutoActionAgentEventListener.DefaultImpls.onQueueStatusChanged(this, r1, r2);
    }

    @Override // com.obric.autogui.common.api.agent.IAutoActionAgentEventListener
    public void onUIOperationHangup(IAutoActionAgentEventListener.SessionInfo r1) {
        IAutoActionAgentEventListener.DefaultImpls.onUIOperationHangup(this, r1);
    }

    @Override // com.obric.autogui.common.api.agent.IAutoActionAgentEventListener
    public int order() {
        return IAutoActionAgentEventListener.DefaultImpls.order(this);
    }

    private final b getSessionExecTracker(IAutoActionAgentEventListener.SessionInfo r2) {
        return (b) ZeusTransformUtils.preCheckCast(r2.getTask().getInternalExtras().get(AutoOperateTask.KEY_EXTRA_SESSION_EXECUTION_TRACKER), b.class, "com.obric.aiagent.plugin");
    }

    private final b createSessionExecTracker(IAutoActionAgentEventListener.SessionInfo r19) {
        long r0 = r19.getTask().getTriggeredBootTime();
        if (r0 > 0) goto L5;
        r0 = AOSystemTools.INSTANCE.bootTimeMillis();
    L5:
        b r15 = new b(r0, 0, 0, null, 0, false, null, null, null, 510, null);
        Loog.INSTANCE.d(TAG, "NewSession: " + r19.getSessionKey() + ", started=" + r0);
        r19.getTask().getInternalExtras().put(AutoOperateTask.KEY_EXTRA_SESSION_EXECUTION_TRACKER, r15);
        return r15;
    }

    private final void addStateChangeRecord(IAutoActionAgentEventListener.SessionInfo r3, BizStatus r4, BizStatus r5) {
        b r2 = getSessionExecTracker(r3);
        if (r2 == null) goto L8;
        List<c> r6 = r2.b();
        if (r6 == null) goto L9;
        r6.add(new c(r4, r5, AOSystemTools.INSTANCE.nowTimeMillis()));
        return;
    L9:
        return;
    }

    @Override // com.obric.autogui.common.api.agent.IAutoActionAgentEventListener
    public void onSessionEnqueued(IAutoActionAgentEventListener.SessionInfo r9) {
        o.e(r9, "sessionInfo");
        IAutoActionTrackingApi r0 = (IAutoActionTrackingApi) ZeusTransformUtils.preCheckCast(AOBizTracking.INSTANCE, IAutoActionTrackingApi.class, "com.obric.aiagent.plugin");
        JSONObject r2 = new JSONObject();
        com.obric.autogui.session.c.b.a(r2, r9);
        x r8 = x.f38692a;
        IAutoActionTrackingApi.DefaultImpls.reportEvent$default(r0, "start_task", r2, false, false, null, 28, null);
    }

    @Override // com.obric.autogui.common.api.agent.IAutoActionAgentEventListener
    public void onBizStatusChanged(IAutoActionAgentEventListener.SessionInfo r9, BizStatus r10, BizStatus r11, int r12, BizStatus.StatusChangedReasonStruct r13, Bundle r14) {
        o.e(r9, "sessionInfo");
        o.e(r10, "oldStatus");
        o.e(r11, "status");
        o.e(r13, "reasonDetails");
        if (r10 == BizStatus.IDLE) goto L5;
    L7:
        addStateChangeRecord(r9, r10, r11);
        if (r10 != BizStatus.QUEUEING) goto L24;
        if (r11 != BizStatus.IDLE) goto L24;
        if (r12 != e.f31231b.a()) goto L17;
        b r8 = getSessionExecTracker(r9);
        if (r8 == null) goto L44;
        r8.a(AOSystemTools.INSTANCE.bootTimeMillis());
        r8.a(101001);
        r8.a("network-linkage-not-ready");
        r8.b(0);
        r8.a(r9);
        return;
    L44:
        return;
    L17:
        if (r12 != e.f31232c.a()) goto L21;
        b r15 = getSessionExecTracker(r9);
        if (r15 == null) goto L46;
        r15.a(AOSystemTools.INSTANCE.bootTimeMillis());
        r15.a(104003);
        r15.a("not-logged-in");
        r15.b(0);
        r15.a(r9);
        return;
    L46:
        return;
    L21:
        e.f31230a.a();
        return;
    L24:
        if (r10 != BizStatus.PREPARING) goto L29;
        if (r11 != BizStatus.OPERATING) goto L29;
        IAutoActionTrackingApi r0 = (IAutoActionTrackingApi) ZeusTransformUtils.preCheckCast(AOBizTracking.INSTANCE, IAutoActionTrackingApi.class, "com.obric.aiagent.plugin");
        JSONObject r2 = new JSONObject();
        com.obric.autogui.session.c.b.a(r2, r9);
        x r16 = x.f38692a;
        IAutoActionTrackingApi.DefaultImpls.reportEvent$default(r0, "oauto_real_start_task", r2, false, false, null, 28, null);
    L29:
        if (r11 == BizStatus.TERMINATED) goto L31;
        return;
    L31:
        if (r14 == null) goto L33;
        int r17 = r14.getInt("term_reason_type", -1);
    L34:
        if (r14 == null) goto L36;
        CharSequence r18 = r14.getCharSequence("early_term_reason");
    L37:
        long r1 = AOSystemTools.INSTANCE.bootTimeMillis();
        if (r17 != (-1)) goto L40;
        Loog.INSTANCE.e(TAG, "onBizStatusChanged: termReasonType is -1, ses=" + r9.getSessionKey() + '/' + r9.getSessionId());
        return;
    L40:
        b r19 = getSessionExecTracker(r9);
        if (r19 == null) goto L50;
        r19.a(r1);
        r19.a(r17);
        r19.a(String.valueOf(r18));
        r19.a(r14);
        r19.a(r9);
        return;
    L50:
        return;
    L36:
        r18 = null;
        goto L37
    L33:
        r17 = -1;
        goto L34
    L5:
        if (r11 == BizStatus.IDLE) goto L7;
        createSessionExecTracker(r9);
        goto L7
    }

    @Override // com.obric.autogui.common.api.agent.IAutoActionAgentEventListener
    public void onAgentStep(IAutoActionAgentEventListener.SessionInfo r4, IAutoActionAgentEventListener.AgentStepInfo r5) {
        o.e(r4, "sessionInfo");
        o.e(r5, "stepInfo");
        b r3 = getSessionExecTracker(r4);
        if (r3 == null) goto L8;
        r3.b(r3.a() + 1);
        List<String> r6 = r3.c();
        String r0 = d.o.o.a((CharSequence) ZeusTransformUtils.preCheckCast(r5.getActionProtocolType(), CharSequence.class, "com.obric.aiagent.plugin")).toString().toLowerCase(Locale.ROOT);
        o.c(r0, "toLowerCase(...)");
        r6.add(r0);
        if (o.a(r5.getActionProtocolType(), "run_script_by_ability") == false) goto L9;
        r3.d();
        return;
    L9:
        return;
    }
}
