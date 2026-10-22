package com.obric.agent.intents;

import android.content.Context;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import com.obric.agent.trace.q;
import com.obric.aiagent.assistant.idl.IFlowAppIntentIDL;
import com.obric.aiagent.assistant.idl.bean.IMMessage;
import com.obric.aiagent.assistant.idl.r;
import com.obric.aiagent.executionengine.scheduler.api.IJobManagerApi;
import com.obric.aiagent.platform.depend.ILogDepend;
import com.obric.assistant.dm.api.statemachine.core.TaskInfo;
import com.obric.assistant.dm.api.statemachine.manager.IDialogStateManager;
import com.obric.capabilitykit.common.AppAction;
import com.obric.capabilitykit.common.DispatchContext;
import com.obric.capabilitykit.common.IGetRunningTaskCallback;
import com.obric.capabilitykit.common.IMAppAction;
import com.obric.capabilitykit.common.intent.BaseSystemHeartBeatIntent;
import com.obric.capabilitykit.common.intent.Empty;
import com.obric.capabilitykit.common.intent.IntentResult;
import com.obric.capabilitykit.common.intent.SystemHeartBeatParams;
import com.ss.android.socialbase.downloader.constants.DownloadErrorCode;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.p;
import d.h.b.aa;
import d.h.b.h;
import d.h.b.o;
import d.n.j;
import d.n.m;
import java.util.List;
import kotlinx.coroutines.n;

/* JADX INFO: compiled from: HeartBeatIntent.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class HeartBeatIntent extends BaseSystemHeartBeatIntent {

    /* JADX INFO: compiled from: HeartBeatIntent.kt */
    private static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @SerializedName("actionName")
        private final String f14616a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @SerializedName("action")
        private final String f14617b;

        /* JADX WARN: Multi-variable type inference failed */
        public a() {
            Object[] r0 = 0 == true ? 1 : 0;
            this(null, r0, 3, 0 == true ? 1 : 0);
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, a.class) == true) goto L8;
            return false;
        L8:
            a r6 = (a) ZeusTransformUtils.preCheckCast(r5, a.class, "com.obric.aiagent.plugin");
            if (o.a(this.f14616a, r6.f14616a) == true) goto L12;
            return false;
        L12:
            if (o.a(this.f14617b, r6.f14617b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            String r0 = this.f14616a;
            int r1 = 0;
            if (r0 != null) goto L5;
            int r2 = 0;
        L6:
            int r3 = r2 * 31;
            String r4 = this.f14617b;
            if (r4 == null) goto L11;
            r1 = r4.hashCode();
        L11:
            return r3 + r1;
        L5:
            r2 = r0.hashCode();
            goto L6
        }

        public String toString() {
            return "EcaAction(actionName=" + this.f14616a + ", action=" + this.f14617b + ')';
        }

        public a(String r1, String r2) {
            this.f14616a = r1;
            this.f14617b = r2;
        }

        public /* synthetic */ a(String r2, String r3, int r4, h r5) {
            if ((r4 & 1) == 0) goto L6;
            r2 = null;
        L6:
            if ((r4 & 2) == 0) goto L8;
            r3 = null;
        L8:
            this(r2, r3);
        }

        public final String a() {
            return this.f14616a;
        }

        public final String b() {
            return this.f14617b;
        }
    }

    /* JADX INFO: compiled from: HeartBeatIntent.kt */
    private static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @SerializedName("Version")
        private final Integer f14618a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @SerializedName("Content")
        private final String f14619b;

        /* JADX WARN: Multi-variable type inference failed */
        public b() {
            Object[] r0 = 0 == true ? 1 : 0;
            this(null, r0, 3, 0 == true ? 1 : 0);
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, b.class) == true) goto L8;
            return false;
        L8:
            b r6 = (b) ZeusTransformUtils.preCheckCast(r5, b.class, "com.obric.aiagent.plugin");
            if (o.a(this.f14618a, r6.f14618a) == true) goto L12;
            return false;
        L12:
            if (o.a(this.f14619b, r6.f14619b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            Integer r0 = this.f14618a;
            int r1 = 0;
            if (r0 != null) goto L5;
            int r2 = 0;
        L6:
            int r3 = r2 * 31;
            String r4 = this.f14619b;
            if (r4 == null) goto L11;
            r1 = r4.hashCode();
        L11:
            return r3 + r1;
        L5:
            r2 = r0.hashCode();
            goto L6
        }

        public String toString() {
            return "EcaEnvelope(version=" + this.f14618a + ", content=" + this.f14619b + ')';
        }

        public b(Integer r1, String r2) {
            this.f14618a = r1;
            this.f14619b = r2;
        }

        public /* synthetic */ b(Integer r2, String r3, int r4, h r5) {
            if ((r4 & 1) == 0) goto L6;
            r2 = null;
        L6:
            if ((r4 & 2) == 0) goto L8;
            r3 = null;
        L8:
            this(r2, r3);
        }

        public final String a() {
            return this.f14619b;
        }
    }

    /* JADX INFO: compiled from: HeartBeatIntent.kt */
    private static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @SerializedName("actions")
        private final List<a> f14620a;

        /* JADX WARN: Multi-variable type inference failed */
        public c() {
            this(null, 1, 0 == true ? 1 : 0);
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, c.class) == true) goto L8;
            return false;
        L8:
            c r6 = (c) ZeusTransformUtils.preCheckCast(r5, c.class, "com.obric.aiagent.plugin");
            if (o.a(this.f14620a, r6.f14620a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public int hashCode() {
            List<a> r0 = this.f14620a;
            if (r0 != null) goto L6;
            return 0;
        L6:
            return r0.hashCode();
        }

        public String toString() {
            return "EcaEvent(actions=" + this.f14620a + ')';
        }

        public c(List<a> r3) {
            this.f14620a = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
        }

        public /* synthetic */ c(List r2, int r3, h r4) {
            List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.aiagent.plugin");
            if ((r3 & 1) == 0) goto L5;
            r5 = null;
        L5:
            this(r5);
        }

        public final List<a> a() {
            return this.f14620a;
        }
    }

    /* JADX INFO: compiled from: HeartBeatIntent.kt */
    private static final class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @SerializedName("actions")
        private final List<a> f14621a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @SerializedName("events")
        private final List<c> f14622b;

        /* JADX WARN: Multi-variable type inference failed */
        public d() {
            Object[] r0 = 0 == true ? 1 : 0;
            this(null, r0, 3, 0 == true ? 1 : 0);
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, d.class) == true) goto L8;
            return false;
        L8:
            d r6 = (d) ZeusTransformUtils.preCheckCast(r5, d.class, "com.obric.aiagent.plugin");
            if (o.a(this.f14621a, r6.f14621a) == true) goto L12;
            return false;
        L12:
            if (o.a(this.f14622b, r6.f14622b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            List<a> r0 = this.f14621a;
            int r1 = 0;
            if (r0 != null) goto L5;
            int r2 = 0;
        L6:
            int r3 = r2 * 31;
            List<c> r4 = this.f14622b;
            if (r4 == null) goto L11;
            r1 = r4.hashCode();
        L11:
            return r3 + r1;
        L5:
            r2 = r0.hashCode();
            goto L6
        }

        public String toString() {
            return "EcaJob(actions=" + this.f14621a + ", events=" + this.f14622b + ')';
        }

        public d(List<a> r3, List<c> r4) {
            List<a> r5 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
            List<c> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.aiagent.plugin");
            this.f14621a = r5;
            this.f14622b = r6;
        }

        public /* synthetic */ d(List r2, List r3, int r4, h r5) {
            List r6 = (List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.aiagent.plugin");
            List r7 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
            if ((r4 & 1) == 0) goto L6;
            r6 = null;
        L6:
            if ((r4 & 2) == 0) goto L8;
            r7 = null;
        L8:
            this(r6, r7);
        }

        public final List<a> a() {
            return this.f14621a;
        }

        public final List<c> b() {
            return this.f14622b;
        }
    }

    /* JADX INFO: compiled from: HeartBeatIntent.kt */
    private static final class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @SerializedName("jobs")
        private final List<d> f14623a;

        /* JADX WARN: Multi-variable type inference failed */
        public e() {
            this(null, 1, 0 == true ? 1 : 0);
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, e.class) == true) goto L8;
            return false;
        L8:
            e r6 = (e) ZeusTransformUtils.preCheckCast(r5, e.class, "com.obric.aiagent.plugin");
            if (o.a(this.f14623a, r6.f14623a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public int hashCode() {
            List<d> r0 = this.f14623a;
            if (r0 != null) goto L6;
            return 0;
        L6:
            return r0.hashCode();
        }

        public String toString() {
            return "EcaPayload(jobs=" + this.f14623a + ')';
        }

        public e(List<d> r3) {
            this.f14623a = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
        }

        public /* synthetic */ e(List r2, int r3, h r4) {
            List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.aiagent.plugin");
            if ((r3 & 1) == 0) goto L5;
            r5 = null;
        L5:
            this(r5);
        }

        public final List<d> a() {
            return this.f14623a;
        }
    }

    /* JADX INFO: compiled from: HeartBeatIntent.kt */
    @d.c.b.a.f(b = "HeartBeatIntent.kt", c = {181}, d = "doAction", e = "com.obric.agent.intents.HeartBeatIntent")
    static final class f extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f14624a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f14625b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Object f14626c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        /* synthetic */ Object f14627d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ HeartBeatIntent f14628e;
        int f;

        f(HeartBeatIntent r3, d.c.d<? super f> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f14628e = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f14627d = r3;
            this.f |= Integer.MIN_VALUE;
            return this.f14628e.doAction(null, null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    public static /* synthetic */ j lambda$OvupzBJGOys4w4xcoHX43Nn4_eY(c r0) {
        return extractActionNameFromContent$lambda$10$lambda$8(r0);
    }

    /* JADX INFO: renamed from: lambda$X9VSbE-Ohu1vjMtjFgKyZYHQhAU, reason: not valid java name */
    public static /* synthetic */ String m80lambda$X9VSbEOhu1vjMtjFgKyZYHQhAU(d r0) {
        return extractActionNameFromContent$lambda$10(r0);
    }

    public static /* synthetic */ String lambda$xuI8Dg0eEl1R9oUzzRPAEEM4iow(a r0) {
        return extractActionNameFromContent$lambda$10$lambda$9(r0);
    }

    public static /* synthetic */ String lambda$zxDyqXCVd7WoZPaI2F7A0N6KWzc(a r0) {
        return extractActionNameFromContent$lambda$10$lambda$7(r0);
    }

    public HeartBeatIntent() {
    }

    public static final /* synthetic */ String access$extractActionName(HeartBeatIntent r0, IMAppAction r1) {
        return r0.extractActionName(r1);
    }

    @Override // com.obric.capabilitykit.common.intent.BaseSystemHeartBeatIntent, com.obric.capabilitykit.common.intent.IntentFunction
    public /* synthetic */ Object doAction(Parcelable r3, DispatchContext r4, d.c.d<? super IntentResult<Empty>> r5) {
        Parcelable r6 = (Parcelable) ZeusTransformUtils.wrapperContextForParams(r3, Parcelable.class, "com.obric.aiagent.plugin");
        d.c.d<? super IntentResult<Empty>> r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
        return doAction((SystemHeartBeatParams) ZeusTransformUtils.preCheckCast(r6, SystemHeartBeatParams.class, "com.obric.aiagent.plugin"), r4, r7);
    }

    @Override // com.obric.capabilitykit.common.intent.BaseSystemHeartBeatIntent
    public Object doAction(SystemHeartBeatParams r36, DispatchContext r37, d.c.d<? super IntentResult<Empty>> r38) {
        final HeartBeatIntent r0 = this;
        d.c.d r2 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r38, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r2, f.class) == false) goto L7;
        f r4 = (f) ZeusTransformUtils.preCheckCast(r2, f.class, "com.obric.aiagent.plugin");
        if ((r4.f & Integer.MIN_VALUE) == 0) goto L7;
        r4.f -= Integer.MIN_VALUE;
    L8:
        Object r3 = r4.f14627d;
        Object r5 = d.c.a.b.a();
        int r6 = r4.f;
        if (r6 == 0) goto L14;
        if (r6 != 1) goto L13;
        String r1 = (String) ZeusTransformUtils.preCheckCast(r4.f14626c, String.class, "com.obric.aiagent.plugin");
        String r7 = (String) ZeusTransformUtils.preCheckCast(r4.f14625b, String.class, "com.obric.aiagent.plugin");
        r0 = (HeartBeatIntent) ZeusTransformUtils.preCheckCast(r4.f14624a, HeartBeatIntent.class, "com.obric.aiagent.plugin");
        d.o.a(r3);
    L56:
        ILogDepend.Companion.i(r0.getName(), "result = " + r3);
        return new IntentResult(0, null, null, r3.toString(), false, false, 0, null, null, null, DownloadErrorCode.ERROR_REMOVE_DOWNLOAD_RUNNABLE, null);
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        d.o.a(r3);
        ILogDepend.Companion.i(getName(), "doAction - heartBeat=" + r36.getQuestionId() + "，expiryTimestamp=" + r36.getExpiryTimestamp() + "，timeUntilNextHeartbeat=" + r36.getTimeUntilNextHeartbeat());
        final String r8 = r36.getQuestionId();
        q r9 = q.f15713a;
        if (r8 != null) goto L17;
        String r10 = "suibian";
    L18:
        r9.a(r10, true);
        Context r11 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r37.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        IFlowAppIntentIDL r12 = r.a(aa.b(IFlowAppIntentIDL.class));
        Long r13 = null;
        if (r12 == null) goto L21;
        Long r14 = d.c.b.a.b.a(r12.currentTimeMillis());
    L22:
        if (r14 != null) goto L24;
    L29:
        if (r8 == null) goto L31;
        IDialogStateManager r15 = (IDialogStateManager) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IDialogStateManager.class), IDialogStateManager.class, "com.obric.aiagent.plugin");
        if (r15 == null) goto L35;
        TaskInfo r16 = r15.getStateMachinesFromQuestionId(String.valueOf(r36.getQuestionId()));
    L36:
        if (r16 == null) goto L40;
        IMMessage r17 = r16.getMessage();
        if (r17 == null) goto L40;
        String r18 = r17.getMessageId();
    L41:
        if (r16 == null) goto L58;
        com.obric.agent.complextask.c r19 = com.obric.agent.complextask.c.f14330a;
        Long r110 = r36.getTimeUntilNextHeartbeat();
        if (r110 == null) goto L45;
        long r111 = r110.longValue();
    L46:
        r19.a(r8, r111, r16);
        ILogDepend.Companion.i(getName(), "ref messageId: " + r18);
        r4.f14624a = r0;
        r4.f14625b = r8;
        r4.f14626c = r18;
        r4.f = 1;
        kotlinx.coroutines.o r20 = new kotlinx.coroutines.o(d.c.a.b.a((d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin")), 1);
        r20.e();
        final n r21 = (n) ZeusTransformUtils.preCheckCast(r20, n.class, "com.obric.aiagent.plugin");
        IJobManagerApi r22 = (IJobManagerApi) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IJobManagerApi.class), IJobManagerApi.class, "com.obric.aiagent.plugin");
        if (r22 == null) goto L51;
        if (r18 == null) goto L50;
        r13 = d.c.b.a.b.a(Long.parseLong(r18));
    L50:
        r22.findActionByQuestionId(r13, (IGetRunningTaskCallback) ZeusTransformUtils.preCheckCast(new HeartBeatIntent$doAction$result$1$1(r8, r0, r21), IGetRunningTaskCallback.class, "com.obric.aiagent.plugin"));
    L51:
        r3 = r20.h();
        if (r3 != d.c.a.b.a()) goto L54;
        d.c.b.a.h.c((d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
    L54:
        if (r3 != r5) goto L56;
        return r5;
    L45:
        r111 = com.obric.assistant.dm.api.statemachine.core.a.f22459a.a();
        goto L46
    L58:
        ILogDepend.Companion.e(((HeartBeatIntent) ZeusTransformUtils.preCheckCast(r0, HeartBeatIntent.class, "com.obric.aiagent.plugin")).getName(), "heartBeat error, questionId=" + r36.getQuestionId() + " not found taskInfo");
        return new IntentResult(1, null, null, "task is not found with questionId:" + r8, false, false, 0, null, null, null, DownloadErrorCode.ERROR_REMOVE_DOWNLOAD_RUNNABLE, null);
    L40:
        r18 = null;
        goto L41
    L35:
        r16 = null;
        goto L36
    L31:
        return new IntentResult(4, null, null, "questionId is null, not support!", false, false, 0, null, null, null, DownloadErrorCode.ERROR_REMOVE_DOWNLOAD_RUNNABLE, null);
    L24:
        if (r36.getExpiryTimestamp() == null) goto L29;
        Long r23 = r36.getExpiryTimestamp();
        o.a(r23);
        if (r23.longValue() >= r14.longValue()) goto L29;
        return new IntentResult(4, null, null, "Outdated Heartbeat", false, false, 0, null, null, null, DownloadErrorCode.ERROR_REMOVE_DOWNLOAD_RUNNABLE, null);
    L21:
        r14 = null;
        goto L22
    L17:
        r10 = r8;
    L7:
        r4 = new f(r0, r2);
        goto L8
    }

    private final String extractActionName(IMAppAction r5) {
        d.n.a r2 = d.n.f38560a;     // Catch: Throwable -> L9
        HeartBeatIntent r3 = (HeartBeatIntent) ZeusTransformUtils.preCheckCast(this, HeartBeatIntent.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L9
        AppAction r4 = r5.getAction();     // Catch: Throwable -> L9
        if (r4 == null) goto L6;
        String r6 = r4.getAction();     // Catch: Throwable -> L9
    L7:
        Object r7 = d.n.f(r6);     // Catch: Throwable -> L9
    L12:
        if (d.n.b(r7) == false) goto L14;
        r7 = null;
    L14:
        String r8 = (String) ZeusTransformUtils.preCheckCast(r7, String.class, "com.obric.aiagent.plugin");
        CharSequence r0 = (CharSequence) ZeusTransformUtils.preCheckCast(r8, CharSequence.class, "com.obric.aiagent.plugin");
        if (r0 != null) goto L17;
    L20:
        boolean r1 = true;
    L21:
        if (r1 == true) goto L23;
        return r8;
    L23:
        String r9 = r5.getContent();
        if (r9 != null) goto L27;
        return null;
    L27:
        return extractActionNameFromContent(r9);
    L17:
        if (r0.length() == 0) goto L20;
        r1 = false;
        goto L21
    L6:
        r6 = null;
    L9:
        th = move-exception;
        d.n.a r10 = d.n.f38560a;
        r7 = d.n.f(d.o.a(th));
        goto L12
    }

    private final String extractActionNameFromContent(String r6) {
        d.n.a r3 = d.n.f38560a;     // Catch: Throwable -> L13
        HeartBeatIntent r4 = (HeartBeatIntent) ZeusTransformUtils.preCheckCast(this, HeartBeatIntent.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L13
        String r5 = ((b) ZeusTransformUtils.preCheckCast(com.obric.capabilitykit.common.a.a().fromJson(r6, b.class), b.class, "com.obric.aiagent.plugin")).a();     // Catch: Throwable -> L13
        if (r5 != null) goto L6;
    L10:
        String r7 = r6;
    L11:
        Object r8 = d.n.f(r7);     // Catch: Throwable -> L13
    L15:
        Object r9 = r6;
        if (d.n.b(r8) == true) goto L19;
        r9 = r8;
    L19:
        String r10 = (String) ZeusTransformUtils.preCheckCast(r9, String.class, "com.obric.aiagent.plugin");
        d.n.a r11 = d.n.f38560a;     // Catch: Throwable -> L22
        HeartBeatIntent r12 = (HeartBeatIntent) ZeusTransformUtils.preCheckCast(this, HeartBeatIntent.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L22
        Object r13 = d.n.f((e) ZeusTransformUtils.preCheckCast(com.obric.capabilitykit.common.a.a().fromJson(r10, e.class), e.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L22
    L25:
        if (d.n.b(r13) == false) goto L27;
        r13 = null;
    L27:
        e r14 = (e) ZeusTransformUtils.preCheckCast(r13, e.class, "com.obric.aiagent.plugin");
        if (r14 != null) goto L30;
        return null;
    L30:
        List<d> r15 = r14.a();
        if (r15 == null) goto L42;
        j r16 = p.y((Iterable) ZeusTransformUtils.preCheckCast(r15, Iterable.class, "com.obric.aiagent.plugin"));
        if (r16 == null) goto L43;
        j r17 = m.e(r16, $$Lambda$HeartBeatIntent$X9VSbEOhu1vjMtjFgKyZYHQhAU.INSTANCE);
        if (r17 != null) goto L37;
        return null;
    L37:
        return (String) ZeusTransformUtils.preCheckCast(m.d(r17), String.class, "com.obric.aiagent.plugin");
    L43:
        return null;
    L42:
        return null;
    L22:
        th = move-exception;
        d.n.a r18 = d.n.f38560a;
        r13 = d.n.f(d.o.a(th));
        goto L25
    L6:
        if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r5, CharSequence.class, "com.obric.aiagent.plugin"))) == false) goto L8;
        r7 = r5;
    L9:
        if (r7 != null) goto L11;
    L8:
        r7 = null;
    L13:
        th = move-exception;
        d.n.a r19 = d.n.f38560a;
        r8 = d.n.f(d.o.a(th));
        goto L15
    }

    private static final String extractActionNameFromContent$lambda$10(d r3) {
        o.e(r3, "job");
        List<a> r0 = r3.a();
        if (r0 == null) goto L11;
        j r1 = p.y((Iterable) ZeusTransformUtils.preCheckCast(r0, Iterable.class, "com.obric.aiagent.plugin"));
        if (r1 == null) goto L11;
        j r2 = m.e(r1, $$Lambda$HeartBeatIntent$zxDyqXCVd7WoZPaI2F7A0N6KWzc.INSTANCE);
        if (r2 == null) goto L11;
        String r4 = (String) ZeusTransformUtils.preCheckCast(m.d(r2), String.class, "com.obric.aiagent.plugin");
        if (r4 == null) goto L11;
        return r4;
    L11:
        List<c> r5 = r3.b();
        if (r5 == null) goto L20;
        j r6 = p.y((Iterable) ZeusTransformUtils.preCheckCast(r5, Iterable.class, "com.obric.aiagent.plugin"));
        if (r6 == null) goto L20;
        j r7 = m.c(r6, $$Lambda$HeartBeatIntent$OvupzBJGOys4w4xcoHX43Nn4_eY.INSTANCE);
        if (r7 == null) goto L20;
        j r8 = m.e(r7, $$Lambda$HeartBeatIntent$xuI8Dg0eEl1R9oUzzRPAEEM4iow.INSTANCE);
        if (r8 == null) goto L20;
        return (String) ZeusTransformUtils.preCheckCast(m.d(r8), String.class, "com.obric.aiagent.plugin");
    L20:
        return null;
    }

    private static final String extractActionNameFromContent$lambda$10$lambda$7(a r1) {
        o.e(r1, "it");
        String r0 = r1.a();
        if (r0 == null) goto L5;
        return r0;
    L5:
        return r1.b();
    }

    private static final j extractActionNameFromContent$lambda$10$lambda$8(c r2) {
        o.e(r2, "it");
        List<a> r3 = r2.a();
        if (r3 != null) goto L6;
        r3 = p.b();
    L6:
        return p.y((Iterable) ZeusTransformUtils.preCheckCast(r3, Iterable.class, "com.obric.aiagent.plugin"));
    }

    private static final String extractActionNameFromContent$lambda$10$lambda$9(a r1) {
        o.e(r1, "it");
        String r0 = r1.a();
        if (r0 == null) goto L5;
        return r0;
    L5:
        return r1.b();
    }
}
