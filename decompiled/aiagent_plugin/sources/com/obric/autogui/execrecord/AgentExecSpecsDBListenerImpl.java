package com.obric.autogui.execrecord;

import android.content.Context;
import android.os.Bundle;
import com.bytedance.common.wschannel.WsChannelMultiProcessSharedProvider;
import com.obric.aiagent.plugin.R;
import com.obric.autogui.common.api.AOSystemTools;
import com.obric.autogui.common.api.agent.BizStatus;
import com.obric.autogui.common.api.agent.IAutoActionAgentEventListener;
import com.obric.autogui.common.api.agent.QueueStatus;
import com.obric.autogui.common.api.app.AOHostAppTools;
import com.obric.autogui.common.api.logging.Loog;
import com.obric.autogui.common.api.threading.AOThreadingTools;
import com.obric.autogui.database.AutoActionDatabase;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.c.b.a.f;
import d.c.b.a.l;
import d.h.b.h;
import d.h.b.o;
import d.x;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: AgentExecSpecsDBListenerImpl.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class AgentExecSpecsDBListenerImpl implements IAutoActionAgentEventListener {
    public static final a Companion = null;
    private static final String TAG = "ExecRecorder-SPI";
    private final AOThreadingTools.SingleThreadCoroutineScopeWrapper mDbWorkerThread;
    private final com.obric.autogui.database.a mDba;
    private final HashMap<String, b> mSessionKey2RecordedData;

    /* JADX INFO: compiled from: AgentExecSpecsDBListenerImpl.kt */
    public static final class a {
        public /* synthetic */ a(h r1) {
            this();
        }

        private a() {
        }
    }

    /* JADX INFO: compiled from: AgentExecSpecsDBListenerImpl.kt */
    private static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private long f29090a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private String f29091b;

        public b() {
            this(0, null, 3, null);
        }

        public boolean equals(Object r9) {
            if (this != r9) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r9, b.class) == true) goto L8;
            return false;
        L8:
            b r10 = (b) ZeusTransformUtils.preCheckCast(r9, b.class, "com.obric.aiagent.plugin");
            if (this.f29090a == r10.f29090a) goto L12;
            return false;
        L12:
            if (o.a(this.f29091b, r10.f29091b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            int r0 = Long.hashCode(this.f29090a) * 31;
            String r2 = this.f29091b;
            if (r2 != null) goto L5;
            int r3 = 0;
        L7:
            return r0 + r3;
        L5:
            r3 = r2.hashCode();
            goto L7
        }

        public String toString() {
            return "SessionRecordedData(dbId=" + this.f29090a + ", summaryText=" + this.f29091b + ')';
        }

        public b(long r1, String r3) {
            this.f29090a = r1;
            this.f29091b = r3;
        }

        public /* synthetic */ b(long r1, String r3, int r4, h r5) {
            if ((r4 & 1) == 0) goto L6;
            r1 = -1;
        L6:
            if ((r4 & 2) == 0) goto L8;
            r3 = null;
        L8:
            this(r1, r3);
        }

        public final long a() {
            return this.f29090a;
        }

        public final void a(String r1) {
            this.f29091b = r1;
        }
    }

    /* JADX INFO: compiled from: AgentExecSpecsDBListenerImpl.kt */
    @f(b = "AgentExecSpecsDBListenerImpl.kt", c = {}, d = "invokeSuspend", e = "com.obric.autogui.execrecord.AgentExecSpecsDBListenerImpl$onAgentStep$1")
    static final class c extends l implements d.h.a.b<d.c.d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f29092a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ AgentExecSpecsDBListenerImpl f29093b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ IAutoActionAgentEventListener.SessionInfo f29094c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ IAutoActionAgentEventListener.AgentStepInfo f29095d;

        c(AgentExecSpecsDBListenerImpl r3, IAutoActionAgentEventListener.SessionInfo r4, IAutoActionAgentEventListener.AgentStepInfo r5, d.c.d<? super c> r6) {
            d.c.d r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin");
            this.f29093b = r3;
            this.f29094c = r4;
            this.f29095d = r5;
            super(1, r7);
        }

        public final Object a(d.c.d<? super x> r3) {
            return ((c) ZeusTransformUtils.preCheckCast(create((d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin")), c.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(d.c.d<?> r5) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new c(this.f29093b, this.f29094c, this.f29095d, r6), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.b
        public /* synthetic */ Object invoke(d.c.d<? super x> r3) {
            return a((d.c.d) ZeusTransformUtils.preCheckCast(r3, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r2) {
            d.c.a.b.a();
            if (this.f29092a != 0) goto L7;
            d.o.a(r2);
            AgentExecSpecsDBListenerImpl.access$updateSessionSummary(this.f29093b, this.f29094c, this.f29095d);
            return x.f38692a;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: compiled from: AgentExecSpecsDBListenerImpl.kt */
    @f(b = "AgentExecSpecsDBListenerImpl.kt", c = {}, d = "invokeSuspend", e = "com.obric.autogui.execrecord.AgentExecSpecsDBListenerImpl$onBizStatusChanged$1")
    static final class d extends l implements d.h.a.b<d.c.d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f29096a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ IAutoActionAgentEventListener.SessionInfo f29097b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ AgentExecSpecsDBListenerImpl f29098c;

        d(IAutoActionAgentEventListener.SessionInfo r3, AgentExecSpecsDBListenerImpl r4, d.c.d<? super d> r5) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            this.f29097b = r3;
            this.f29098c = r4;
            super(1, r6);
        }

        private static final String a() {
            return "delete record data";
        }

        /* JADX INFO: renamed from: lambda$XJc9o_E-XIxhdHP9skQuYs3vs9E, reason: not valid java name */
        public static /* synthetic */ String m817lambda$XJc9o_EXIxhdHP9skQuYs3vs9E() {
            return a();
        }

        /* JADX INFO: renamed from: lambda$zHLlyXqnVVe7o-y-Negw_PwPefc, reason: not valid java name */
        public static /* synthetic */ String m818lambda$zHLlyXqnVVe7oyNegw_PwPefc(IAutoActionAgentEventListener.SessionInfo r0) {
            return a(r0);
        }

        public final Object a(d.c.d<? super x> r3) {
            return ((d) ZeusTransformUtils.preCheckCast(create((d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin")), d.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(d.c.d<?> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new d(this.f29097b, this.f29098c, r5), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.b
        public /* synthetic */ Object invoke(d.c.d<? super x> r3) {
            return a((d.c.d) ZeusTransformUtils.preCheckCast(r3, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r4) {
            d.c.a.b.a();
            if (this.f29096a != 0) goto L11;
            d.o.a(r4);
            if (com.obric.autogui.common.b.b.f29001a.a() == false) goto L7;
            Loog.INSTANCE.i(AgentExecSpecsDBListenerImpl.TAG, "session cleansed: " + this.f29097b);
        L8:
            AgentExecSpecsDBListenerImpl.access$getMSessionKey2RecordedData$p(this.f29098c).remove(this.f29097b.getSessionKey());
            Loog r5 = Loog.INSTANCE;
            final IAutoActionAgentEventListener.SessionInfo r3 = this.f29097b;
            r5.ip(AgentExecSpecsDBListenerImpl.TAG, new $$Lambda$AgentExecSpecsDBListenerImpl$d$zHLlyXqnVVe7oyNegw_PwPefc(r3), $$Lambda$AgentExecSpecsDBListenerImpl$d$XJc9o_EXIxhdHP9skQuYs3vs9E.INSTANCE);
            return x.f38692a;
        L7:
            Loog.INSTANCE.i(AgentExecSpecsDBListenerImpl.TAG, "session cleansed:");
            goto L8
        L11:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        private static final String a(IAutoActionAgentEventListener.SessionInfo r2) {
            return "delete record data: " + r2.getSessionKey();
        }
    }

    /* JADX INFO: compiled from: AgentExecSpecsDBListenerImpl.kt */
    @f(b = "AgentExecSpecsDBListenerImpl.kt", c = {}, d = "invokeSuspend", e = "com.obric.autogui.execrecord.AgentExecSpecsDBListenerImpl$onSessionEnqueued$1")
    static final class e extends l implements d.h.a.b<d.c.d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f29099a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ AgentExecSpecsDBListenerImpl f29100b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ IAutoActionAgentEventListener.SessionInfo f29101c;

        e(AgentExecSpecsDBListenerImpl r3, IAutoActionAgentEventListener.SessionInfo r4, d.c.d<? super e> r5) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            this.f29100b = r3;
            this.f29101c = r4;
            super(1, r6);
        }

        public final Object a(d.c.d<? super x> r3) {
            return ((e) ZeusTransformUtils.preCheckCast(create((d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin")), e.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(d.c.d<?> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new e(this.f29100b, this.f29101c, r5), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.b
        public /* synthetic */ Object invoke(d.c.d<? super x> r3) {
            return a((d.c.d) ZeusTransformUtils.preCheckCast(r3, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r2) {
            d.c.a.b.a();
            if (this.f29099a != 0) goto L7;
            d.o.a(r2);
            AgentExecSpecsDBListenerImpl.access$insertSessionToLocalDb(this.f29100b, this.f29101c);
            return x.f38692a;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    static {
        Companion = new a(null);
    }

    private static final String insertSessionToLocalDb$lambda$4() {
        return "unable to add session to TaskDao";
    }

    private static final String insertSessionToLocalDb$lambda$6() {
        return "start to add session to TaskDao";
    }

    /* JADX INFO: renamed from: lambda$-gkU3Hh-ZzdMyuq39EIOctnqik4, reason: not valid java name */
    public static /* synthetic */ String m810lambda$gkU3HhZzdMyuq39EIOctnqik4(boolean r0) {
        return insertSessionToLocalDb$lambda$9$lambda$8(r0);
    }

    public static /* synthetic */ String lambda$2SqSKzOzHWF4pn20akHGPFzrL7k(long r0) {
        return updateSessionInLocalDb$lambda$23$lambda$15(r0);
    }

    public static /* synthetic */ x lambda$2zkfLIXsbY12ZINV9ogd5be_hH4(IAutoActionAgentEventListener.SessionInfo r0, boolean r1, long r2) {
        return onBizStatusChanged$lambda$2(r0, r1, r2);
    }

    public static /* synthetic */ String lambda$3ipSyEdaWvWiIyFXxU1A7DfV9Pc() {
        return updateSessionInLocalDb$lambda$23$lambda$19();
    }

    public static /* synthetic */ String lambda$75NFaCU3p3xbWmDRm9okwqvRj6w(long r0, com.obric.autogui.database.entity.a r2) {
        return updateSessionInLocalDb$lambda$23$lambda$18(r0, r2);
    }

    /* JADX INFO: renamed from: lambda$8tKkR_IjMBfm_5vohvaaYMgw-JY, reason: not valid java name */
    public static /* synthetic */ String m811lambda$8tKkR_IjMBfm_5vohvaaYMgwJY() {
        return insertSessionToLocalDb$lambda$6();
    }

    /* JADX INFO: renamed from: lambda$JJQBR9mMAjP-aA1mSC4E48UVkeI, reason: not valid java name */
    public static /* synthetic */ String m812lambda$JJQBR9mMAjPaA1mSC4E48UVkeI() {
        return updateSessionInLocalDb$lambda$23$lambda$22$lambda$21();
    }

    public static /* synthetic */ x lambda$MkjPSThWDISdDAZJGqhvb_kyxHg(long r0, IAutoActionAgentEventListener.SessionInfo r2, String r3, int r4, boolean r5, com.obric.autogui.database.entity.a r6) {
        return updateSessionSummary$lambda$12(r0, r2, r3, r4, r5, r6);
    }

    /* JADX INFO: renamed from: lambda$O--hqf1PNMDUbS1Z8Llsj0AqfP8, reason: not valid java name */
    public static /* synthetic */ String m813lambda$Ohqf1PNMDUbS1Z8Llsj0AqfP8() {
        return updateSessionSummary$lambda$11();
    }

    public static /* synthetic */ String lambda$O6BYwF1Awv5DPuy2m5Vo1xGtVkY(boolean r0, String r1, long r2) {
        return insertSessionToLocalDb$lambda$9$lambda$7(r0, r1, r2);
    }

    public static /* synthetic */ String lambda$PQ67mpNANKjUfr_jC6gDL4PXtCk() {
        return onBizStatusChanged$lambda$2$lambda$1();
    }

    /* JADX INFO: renamed from: lambda$RlI3QmJS96Zpk05T8Q0J56l9-MU, reason: not valid java name */
    public static /* synthetic */ x m814lambda$RlI3QmJS96Zpk05T8Q0J56l9MU(AgentExecSpecsDBListenerImpl r0, long r1, d.h.a.b r3, com.obric.autogui.database.entity.a r4) {
        return updateSessionInLocalDb$lambda$23(r0, r1, r3, r4);
    }

    public static /* synthetic */ String lambda$S6pDIHSGujwlvG9D4NvU6BVb6BY() {
        return updateSessionInLocalDb$lambda$23$lambda$16();
    }

    /* JADX INFO: renamed from: lambda$Vq1bH-r00DP1uRMP1N0WWY5VT3s, reason: not valid java name */
    public static /* synthetic */ x m815lambda$Vq1bHr00DP1uRMP1N0WWY5VT3s(long r0, com.obric.autogui.database.entity.a r2, boolean r3) {
        return updateSessionInLocalDb$lambda$23$lambda$22(r0, r2, r3);
    }

    public static /* synthetic */ String lambda$Wne49q_X9im4D6e07zZcfS_aZKg(IAutoActionAgentEventListener.SessionInfo r0) {
        return updateSessionInLocalDb$lambda$13(r0);
    }

    public static /* synthetic */ String lambda$YkOnub_sBUPj3nOQk85q5DHYzl0(String r0, String r1, String r2) {
        return insertSessionToLocalDb$lambda$3(r0, r1, r2);
    }

    public static /* synthetic */ String lambda$aWN7OeXmVPEcinpnf5A1D_POme4() {
        return insertSessionToLocalDb$lambda$4();
    }

    public static /* synthetic */ x lambda$dGRWx7vYw4mTdvjwsWcVTmoTc2M(AgentExecSpecsDBListenerImpl r0, String r1, boolean r2, long r3) {
        return insertSessionToLocalDb$lambda$9(r0, r1, r2, r3);
    }

    public static /* synthetic */ String lambda$eS6LxHtdC9lpRBICnnJhoJSNX1U(IAutoActionAgentEventListener.SessionInfo r0) {
        return updateSessionSummary$lambda$10(r0);
    }

    /* JADX INFO: renamed from: lambda$f-R4zZbKyAsJSgl6-TboFVAed6g, reason: not valid java name */
    public static /* synthetic */ String m816lambda$fR4zZbKyAsJSgl6TboFVAed6g() {
        return updateSessionInLocalDb$lambda$14();
    }

    public static /* synthetic */ String lambda$pTJstmmz9VGUQof_g5ymKSHZ_b4(boolean r0, long r1, com.obric.autogui.database.entity.a r3) {
        return updateSessionInLocalDb$lambda$23$lambda$22$lambda$20(r0, r1, r3);
    }

    public static /* synthetic */ String lambda$qjvJAso93umaWqtM5MMNoPP_WWI(boolean r0, IAutoActionAgentEventListener.SessionInfo r1, long r2) {
        return onBizStatusChanged$lambda$2$lambda$0(r0, r1, r2);
    }

    public static /* synthetic */ String lambda$wabLXIclL0NFcTzA_heU3VP5wM0(String r0, String r1) {
        return insertSessionToLocalDb$lambda$5(r0, r1);
    }

    private static final String onBizStatusChanged$lambda$2$lambda$1() {
        return "added session to TaskDao (ok=)";
    }

    private static final String updateSessionInLocalDb$lambda$14() {
        return "unable to update session: session not recorded";
    }

    private static final String updateSessionInLocalDb$lambda$23$lambda$16() {
        return "unable to update task is null";
    }

    private static final String updateSessionInLocalDb$lambda$23$lambda$19() {
        return "updating task";
    }

    private static final String updateSessionInLocalDb$lambda$23$lambda$22$lambda$21() {
        return "updated task";
    }

    private static final String updateSessionSummary$lambda$11() {
        return "unable to log step: session not recorded";
    }

    @Override // com.obric.autogui.common.api.agent.IAutoActionAgentEventListener
    public void afterAgentStep(IAutoActionAgentEventListener.SessionInfo r1, IAutoActionAgentEventListener.AgentStepInfo r2, IAutoActionAgentEventListener.AgentStepExecInfo r3) {
        o.e(r1, "sessionInfo");
        o.e(r2, "stepInfo");
        o.e(r3, "execInfo");
    }

    public AgentExecSpecsDBListenerImpl() {
        this.mDbWorkerThread = AOThreadingTools.createSingleThreadCoroutineScope$default(AOThreadingTools.INSTANCE, "db-worker", false, 2, null);
        this.mDba = new com.obric.autogui.database.a(AutoActionDatabase.f29019e.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")));
        this.mSessionKey2RecordedData = new HashMap();
    }

    public static final /* synthetic */ HashMap access$getMSessionKey2RecordedData$p(AgentExecSpecsDBListenerImpl r0) {
        return r0.mSessionKey2RecordedData;
    }

    public static final /* synthetic */ void access$insertSessionToLocalDb(AgentExecSpecsDBListenerImpl r0, IAutoActionAgentEventListener.SessionInfo r1) {
        r0.insertSessionToLocalDb(r1);
    }

    public static final /* synthetic */ void access$updateSessionSummary(AgentExecSpecsDBListenerImpl r0, IAutoActionAgentEventListener.SessionInfo r1, IAutoActionAgentEventListener.AgentStepInfo r2) {
        r0.updateSessionSummary(r1, r2);
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

    private final Context getContext() {
        return (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AOHostAppTools.INSTANCE.getAppContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
    }

    @Override // com.obric.autogui.common.api.agent.IAutoActionAgentEventListener
    public void onSessionEnqueued(IAutoActionAgentEventListener.SessionInfo r4) {
        o.e(r4, "sessionInfo");
        if (shouldSkipRecord(r4) == false) goto L5;
        return;
    L5:
        this.mDbWorkerThread.launch((d.h.a.b) ZeusTransformUtils.preCheckCast(new e(this, r4, null), d.h.a.b.class, "com.obric.aiagent.plugin"));
        if (com.obric.autogui.common.b.b.f29001a.a() == false) goto L8;
        Loog.INSTANCE.i(TAG, "session enqueued: " + r4);
        return;
    L8:
        Loog.INSTANCE.i(TAG, "session enqueued:");
    }

    @Override // com.obric.autogui.common.api.agent.IAutoActionAgentEventListener
    public void onAgentStep(IAutoActionAgentEventListener.SessionInfo r4, IAutoActionAgentEventListener.AgentStepInfo r5) {
        o.e(r4, "sessionInfo");
        o.e(r5, "stepInfo");
        if (shouldSkipRecord(r4) == false) goto L6;
        return;
    L6:
        if (r5.isLastStep() == false) goto L9;
        this.mDbWorkerThread.launch((d.h.a.b) ZeusTransformUtils.preCheckCast(new c(this, r4, r5, null), d.h.a.b.class, "com.obric.aiagent.plugin"));
        return;
    }

    @Override // com.obric.autogui.common.api.agent.IAutoActionAgentEventListener
    public void onBizStatusChanged(final IAutoActionAgentEventListener.SessionInfo r31, BizStatus r32, BizStatus r33, int r34, BizStatus.StatusChangedReasonStruct r35, Bundle r36) {
        o.e(r31, "sessionInfo");
        o.e(r32, "oldStatus");
        o.e(r33, "status");
        o.e(r35, "reasonDetails");
        if (shouldSkipRecord(r31) == false) goto L6;
        return;
    L6:
        if (r32 != BizStatus.TERMINATED) goto L11;
        if (r33 != BizStatus.IDLE) goto L11;
        this.mDbWorkerThread.launch((d.h.a.b) ZeusTransformUtils.preCheckCast(new d(r31, this, null), d.h.a.b.class, "com.obric.aiagent.plugin"));
    L11:
        if (r32 == BizStatus.QUEUEING) goto L13;
        return;
    L13:
        if (r33 == BizStatus.IDLE) goto L15;
        return;
    L15:
        if (r34 != com.obric.autogui.session.state.a.e.f31231b.a()) goto L31;
        String r16 = r31.getTask().getUserTask();
        if (r16 != null) goto L20;
        return;
    L20:
        if ((r31.getTask().getLaunchOrigin() & 240) != 0) goto L22;
        return;
    L22:
        com.obric.autogui.database.a r0 = this.mDba;
        int r18 = r31.getTask().getTaskCatalogueNumber();
        String r23 = r31.getSessionKey();
        String r22 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AOHostAppTools.INSTANCE.getAppContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getString(ZeusTransformUtils.mapRes(R.string.obric_exec_summary_network_disconnected, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_exec_summary_network_disconnected"));
        long r19 = System.currentTimeMillis() - r31.getCreatedTime().getTime();
        File r2 = (File) ZeusTransformUtils.preCheckCast(r31.getJournalPath().b(), File.class, "com.obric.aiagent.plugin");
        if (r2 == null) goto L26;
        String r3 = r2.getAbsolutePath();
        if (r3 == null) goto L26;
    L27:
        String r26 = r3;
        r0.a(new com.obric.autogui.database.entity.a(0, null, null, r31.getTask().getTimerTaskId(), 0, 0, r16, "", r18, r19, null, r22, r23, 3, 0, r26, false, 82999, null), new $$Lambda$AgentExecSpecsDBListenerImpl$2zkfLIXsbY12ZINV9ogd5be_hH4(r31));
        return;
    L26:
        r3 = "";
        goto L27
    }

    private static final x onBizStatusChanged$lambda$2(final IAutoActionAgentEventListener.SessionInfo r2, final boolean r3, final long r4) {
        Loog.INSTANCE.dp(TAG, new $$Lambda$AgentExecSpecsDBListenerImpl$qjvJAso93umaWqtM5MMNoPP_WWI(r3, r2, r4), $$Lambda$AgentExecSpecsDBListenerImpl$PQ67mpNANKjUfr_jC6gDL4PXtCk.INSTANCE);
        return x.f38692a;
    }

    private static final String onBizStatusChanged$lambda$2$lambda$0(boolean r2, IAutoActionAgentEventListener.SessionInfo r3, long r4) {
        return "added session to TaskDao (ok=" + r2 + "): k=" + r3.getSessionKey() + ", id=" + r4;
    }

    private final void insertSessionToLocalDb(IAutoActionAgentEventListener.SessionInfo r28) {
        final String r13 = r28.getSessionKey();
        final String r12 = r28.getSessionId();
        final String r11 = r28.getTask().getUserTask();
        if (r11 == null) goto L13;
        if (r12 == null) goto L13;
        Loog.INSTANCE.dp(TAG, new $$Lambda$AgentExecSpecsDBListenerImpl$wabLXIclL0NFcTzA_heU3VP5wM0(r13, r12), $$Lambda$AgentExecSpecsDBListenerImpl$8tKkR_IjMBfm_5vohvaaYMgwJY.INSTANCE);
        com.obric.autogui.database.a r14 = this.mDba;
        int r18 = r28.getTask().getTaskCatalogueNumber();
        File r1 = (File) ZeusTransformUtils.preCheckCast(r28.getJournalPath().b(), File.class, "com.obric.aiagent.plugin");
        if (r1 == null) goto L10;
        String r2 = r1.getAbsolutePath();
        if (r2 == null) goto L10;
    L11:
        String r21 = r2;
        r14.a(new com.obric.autogui.database.entity.a(0, null, null, r28.getTask().getTimerTaskId(), 0, 0, r11, r12, r18, 0, null, null, r13, 0, 0, r21, false, 93751, null), new $$Lambda$AgentExecSpecsDBListenerImpl$dGRWx7vYw4mTdvjwsWcVTmoTc2M(this, r13));
        return;
    L10:
        r2 = "";
    L13:
        Loog.INSTANCE.ep(TAG, new $$Lambda$AgentExecSpecsDBListenerImpl$YkOnub_sBUPj3nOQk85q5DHYzl0(r13, r12, r11), $$Lambda$AgentExecSpecsDBListenerImpl$aWN7OeXmVPEcinpnf5A1D_POme4.INSTANCE);
    }

    private static final String insertSessionToLocalDb$lambda$3(String r2, String r3, String r4) {
        return "unable to add session to TaskDao: k=" + r2 + ", i=" + r3 + ", q=" + r4;
    }

    private static final String insertSessionToLocalDb$lambda$5(String r2, String r3) {
        return "start to add session to TaskDao: k=" + r2 + ", i=" + r3;
    }

    private static final x insertSessionToLocalDb$lambda$9(AgentExecSpecsDBListenerImpl r6, final String r7, final boolean r8, final long r9) {
        Loog.INSTANCE.dp(TAG, new $$Lambda$AgentExecSpecsDBListenerImpl$O6BYwF1Awv5DPuy2m5Vo1xGtVkY(r8, r7, r9), new $$Lambda$AgentExecSpecsDBListenerImpl$gkU3HhZzdMyuq39EIOctnqik4(r8));
        ((Map) ZeusTransformUtils.preCheckCast(r6.mSessionKey2RecordedData, Map.class, "com.obric.aiagent.plugin")).put(r7, new b(r9, null, 2, null));
        return x.f38692a;
    }

    private static final String insertSessionToLocalDb$lambda$9$lambda$7(boolean r2, String r3, long r4) {
        return "added session to TaskDao (ok=" + r2 + "): k=" + r3 + ", id=" + r4;
    }

    private static final String insertSessionToLocalDb$lambda$9$lambda$8(boolean r2) {
        return "added session to TaskDao (ok=" + r2 + ')';
    }

    private final void updateSessionSummary(final IAutoActionAgentEventListener.SessionInfo r10, IAutoActionAgentEventListener.AgentStepInfo r11) {
        if (com.obric.autogui.common.b.b.f29001a.a() == false) goto L5;
        Loog.INSTANCE.d(TAG, "onStep. isFinal=" + r11.isLastStep() + "; thought=" + r11.getThought() + "; action=" + r11.getAction());
    L7:
        if (r11.isLastStep() == false) goto L26;
        b r0 = (b) ZeusTransformUtils.preCheckCast(this.mSessionKey2RecordedData.get(r10.getSessionKey()), b.class, "com.obric.aiagent.plugin");
        if (r0 != null) goto L12;
        Loog.INSTANCE.ep(TAG, new $$Lambda$AgentExecSpecsDBListenerImpl$eS6LxHtdC9lpRBICnnJhoJSNX1U(r10), $$Lambda$AgentExecSpecsDBListenerImpl$Ohqf1PNMDUbS1Z8Llsj0AqfP8.INSTANCE);
        return;
    L12:
        final long r3 = AOSystemTools.INSTANCE.nowTimeMillis();
        if (r11.isSuccess() == false) goto L16;
        int r1 = 0;
    L15:
        final int r7 = r1;
    L20:
        Bundle r2 = r11.getExtras();
        if (r2 == null) goto L23;
        final boolean r8 = r2.getBoolean("model_success");
    L24:
        final String r6 = r11.getThought();
        r0.a(r6);
        updateSessionInLocalDb(r10, new $$Lambda$AgentExecSpecsDBListenerImpl$MkjPSThWDISdDAZJGqhvb_kyxHg(r3, r10, r6, r7, r8));
        return;
    L23:
        r8 = true;
        goto L24
    L16:
        Bundle r4 = r11.getExtras();
        if (r4 == null) goto L19;
        r1 = r4.getInt("term_reason_type");
        goto L15
    L19:
        r7 = 1;
        goto L20
    L26:
        return;
    L5:
        Loog.INSTANCE.d(TAG, "onStep. isFinal=" + r11.isLastStep() + "; action_type=" + r11.getActionProtocolType());
        goto L7
    }

    private static final String updateSessionSummary$lambda$10(IAutoActionAgentEventListener.SessionInfo r2) {
        return "unable to log step: sesKey=" + r2.getSessionKey() + " not recorded.";
    }

    private static final x updateSessionSummary$lambda$12(long r4, IAutoActionAgentEventListener.SessionInfo r6, String r7, int r8, boolean r9, com.obric.autogui.database.entity.a r10) {
        o.e(r10, "$this$updateSessionInLocalDb");
        r10.a(System.currentTimeMillis());
        r10.b(r4 - r10.d());
        Object r5 = r6.getTask().getInternalExtras().get("_set_timer_task_success");
        if (ZeusTransformUtils.instanceOf(r5, Boolean.class) == false) goto L5;
        Boolean r11 = (Boolean) ZeusTransformUtils.preCheckCast(r5, Boolean.class, "com.obric.aiagent.plugin");
    L6:
        int r12 = 1;
        boolean r13 = o.a(r11, true);
        boolean r0 = r6.getNoActionStep();
        com.obric.autogui.common.b.a r1 = com.obric.autogui.common.b.a.f29000a;
        com.obric.autogui.common.b.a r2 = com.obric.autogui.common.b.a.f29000a;
        int r3 = r10.getType();
        if (r13 == false) goto L10;
        if (r0 == false) goto L10;
        boolean r14 = true;
    L11:
        r10.a(r1.a(r2.a(r3, 1, r14), 2, r6.getTask().isTestRun()));
        r10.b(r7);
        r10.a("");
        if (r8 == 0) goto L17;
        if (r8 == 2) goto L16;
        switch(r8) {
            case 106002: goto L16;
            case 106003: goto L16;
            case 106004: goto L16;
            case 106005: goto L16;
            case 106006: goto L16;
            case 106007: goto L16;
            default: goto L15;
        };
    L15:
        r12 = 3;
    L20:
        r10.b(r12);
        return x.f38692a;
    L16:
        r12 = 2;
        goto L20
    L17:
        if (r9 == true) goto L20;
        r12 = 4;
    L10:
        r14 = false;
        goto L11
    L5:
        r11 = null;
        goto L6
    }

    private final void updateSessionInLocalDb(final IAutoActionAgentEventListener.SessionInfo r4, d.h.a.b<? super com.obric.autogui.database.entity.a, x> r5) {
        final d.h.a.b r6 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r5, d.h.a.b.class, "com.obric.aiagent.plugin");
        b r0 = (b) ZeusTransformUtils.preCheckCast(this.mSessionKey2RecordedData.get(r4.getSessionKey()), b.class, "com.obric.aiagent.plugin");
        if (r0 != null) goto L6;
        Loog.INSTANCE.ep(TAG, new $$Lambda$AgentExecSpecsDBListenerImpl$Wne49q_X9im4D6e07zZcfS_aZKg(r4), $$Lambda$AgentExecSpecsDBListenerImpl$fR4zZbKyAsJSgl6TboFVAed6g.INSTANCE);
        return;
    L6:
        final long r1 = r0.a();
        this.mDba.a(r1, new $$Lambda$AgentExecSpecsDBListenerImpl$RlI3QmJS96Zpk05T8Q0J56l9MU(this, r1, r6));
    }

    private static final String updateSessionInLocalDb$lambda$13(IAutoActionAgentEventListener.SessionInfo r2) {
        return "unable to update session: sesKey=" + r2.getSessionKey() + " not recorded.";
    }

    private static final x updateSessionInLocalDb$lambda$23(AgentExecSpecsDBListenerImpl r3, final long r4, d.h.a.b r6, final com.obric.autogui.database.entity.a r7) {
        d.h.a.b r8 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r6, d.h.a.b.class, "com.obric.aiagent.plugin");
        if (r7 != null) goto L6;
        Loog.INSTANCE.ep(TAG, new $$Lambda$AgentExecSpecsDBListenerImpl$2SqSKzOzHWF4pn20akHGPFzrL7k(r4), $$Lambda$AgentExecSpecsDBListenerImpl$S6pDIHSGujwlvG9D4NvU6BVb6BY.INSTANCE);
        return x.f38692a;
    L6:
        r8.invoke(r7);
        r7.a(AOSystemTools.INSTANCE.nowTimeMillis());
        Loog.INSTANCE.dp(TAG, new $$Lambda$AgentExecSpecsDBListenerImpl$75NFaCU3p3xbWmDRm9okwqvRj6w(r4, r7), $$Lambda$AgentExecSpecsDBListenerImpl$3ipSyEdaWvWiIyFXxU1A7DfV9Pc.INSTANCE);
        r3.mDba.a(r7, new $$Lambda$AgentExecSpecsDBListenerImpl$Vq1bHr00DP1uRMP1N0WWY5VT3s(r4, r7));
        return x.f38692a;
    }

    private static final String updateSessionInLocalDb$lambda$23$lambda$15(long r2) {
        return "unable to update TaskId=" + r2 + ": task is null";
    }

    private static final String updateSessionInLocalDb$lambda$23$lambda$18(long r2, com.obric.autogui.database.entity.a r4) {
        return "updating TaskId=" + r2 + "; task=" + r4.a();
    }

    private static final x updateSessionInLocalDb$lambda$23$lambda$22(final long r2, final com.obric.autogui.database.entity.a r4, final boolean r5) {
        Loog.INSTANCE.dp(TAG, new $$Lambda$AgentExecSpecsDBListenerImpl$pTJstmmz9VGUQof_g5ymKSHZ_b4(r5, r2, r4), $$Lambda$AgentExecSpecsDBListenerImpl$JJQBR9mMAjPaA1mSC4E48UVkeI.INSTANCE);
        return x.f38692a;
    }

    private static final String updateSessionInLocalDb$lambda$23$lambda$22$lambda$20(boolean r2, long r3, com.obric.autogui.database.entity.a r5) {
        return "updated (ok=" + r2 + ") TaskId=" + r3 + "; task=" + r5.a() + ' ' + r5.g();
    }

    private final boolean shouldSkipRecord(IAutoActionAgentEventListener.SessionInfo r2) {
        if (r2.getTask().getLaunchOrigin() != 33) goto L5;
    L9:
        Loog.INSTANCE.i(TAG, "skip complex task");
        return true;
    L5:
        if (r2.getTask().getLaunchOrigin() == 36) goto L9;
        return false;
    }
}
