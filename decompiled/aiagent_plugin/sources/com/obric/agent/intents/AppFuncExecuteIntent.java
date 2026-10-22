package com.obric.agent.intents;

import android.os.Parcelable;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.obric.agent.IAppIntentFeedback;
import com.obric.aiagent.platform.depend.ILogDepend;
import com.obric.capabilitykit.common.DispatchContext;
import com.obric.capabilitykit.common.execution.IntentExecutionRecord;
import com.obric.capabilitykit.common.execution.JobResult;
import com.obric.capabilitykit.common.intent.AppFuncExecuteParams;
import com.obric.capabilitykit.common.intent.BaseAppFuncExecuteIntent;
import com.obric.capabilitykit.common.intent.Empty;
import com.obric.capabilitykit.common.intent.IntentResult;
import com.obric.capabilitykit.corecommon.JsonParserExt;
import com.obric.funcall_api.bean.IntentAppAction;
import com.ss.android.socialbase.downloader.constants.DownloadErrorCode;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.p;
import d.c.b.a.l;
import d.h.a.m;
import d.h.b.h;
import d.o;
import d.x;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import kotlinx.coroutines.am;
import kotlinx.coroutines.dg;
import kotlinx.coroutines.i;
import kotlinx.coroutines.n;

/* JADX INFO: compiled from: AppFuncExecuteIntent.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class AppFuncExecuteIntent extends BaseAppFuncExecuteIntent {
    public static final a Companion = null;
    private static final long FORWARD_TIMEOUT_MS = 28000;
    private static final String TAG = "AppFuncExecuteIntent";

    /* JADX INFO: compiled from: AppFuncExecuteIntent.kt */
    public static final class a {
        public /* synthetic */ a(h r1) {
            this();
        }

        private a() {
        }
    }

    /* JADX INFO: compiled from: AppFuncExecuteIntent.kt */
    static final class b implements d.h.a.b<Throwable, x> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ IAppIntentFeedback f14590a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ d f14591b;

        b(IAppIntentFeedback r3, d r4) {
            this.f14590a = (IAppIntentFeedback) ZeusTransformUtils.wrapperContextForParams(r3, IAppIntentFeedback.class, "com.obric.aiagent.plugin");
            this.f14591b = r4;
        }

        @Override // d.h.a.b
        public /* synthetic */ x invoke(Throwable r3) {
            a((Throwable) ZeusTransformUtils.preCheckCast(r3, Throwable.class, "com.obric.aiagent.plugin"));
            return x.f38692a;
        }

        public final void a(Throwable r3) {
            this.f14590a.removeActionFinishedListener((com.obric.agent.f) ZeusTransformUtils.preCheckCast(this.f14591b, com.obric.agent.f.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: AppFuncExecuteIntent.kt */
    @d.c.b.a.f(b = "AppFuncExecuteIntent.kt", c = {}, d = "invokeSuspend", e = "com.obric.agent.intents.AppFuncExecuteIntent$dispatchAndAwait$2$2")
    static final class c extends l implements m<am, d.c.d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f14592a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f14593b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ JsonObject f14594c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ long f14595d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ Long f14596e;
        final /* synthetic */ Map<String, String> f;

        c(String r3, JsonObject r4, long r5, Long r7, Map<String, String> r8, d.c.d<? super c> r9) {
            Map<String, String> r10 = (Map) ZeusTransformUtils.wrapperContextForParams(r8, Map.class, "com.obric.aiagent.plugin");
            d.c.d r11 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r9, d.c.d.class, "com.obric.aiagent.plugin");
            this.f14593b = r3;
            this.f14594c = r4;
            this.f14595d = r5;
            this.f14596e = r7;
            this.f = r10;
            super(2, r11);
        }

        public final Object a(am r3, d.c.d<? super x> r4) {
            return ((c) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), c.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r10, d.c.d<?> r11) {
            d.c.d r8 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r11, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new c(this.f14593b, this.f14594c, this.f14595d, this.f14596e, this.f, r8), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r11) {
            d.c.a.b.a();
            if (this.f14592a != 0) goto L11;
            o.a(r11);
            com.obric.agent.utils.b r1 = com.obric.agent.utils.b.f15994a;
            String r2 = this.f14593b;
            JsonObject r3 = this.f14594c;
            long r5 = this.f14595d;
            Long r12 = this.f14596e;
            if (r12 == null) goto L7;
            long r7 = r12.longValue();
        L8:
            r1.a(r2, r3, null, r5, r7, this.f);
            return x.f38692a;
        L7:
            r7 = r5;
            goto L8
        L11:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: compiled from: AppFuncExecuteIntent.kt */
    public static final class d implements com.obric.agent.f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ long f14597a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ IAppIntentFeedback f14598b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ n<IntentResult<Empty>> f14599c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ AppFuncExecuteIntent f14600d;

        d(long r3, IAppIntentFeedback r5, n<? super IntentResult<Empty>> r6, AppFuncExecuteIntent r7) {
            IAppIntentFeedback r8 = (IAppIntentFeedback) ZeusTransformUtils.wrapperContextForParams(r5, IAppIntentFeedback.class, "com.obric.aiagent.plugin");
            n<IntentResult<Empty>> r9 = (n) ZeusTransformUtils.wrapperContextForParams(r6, n.class, "com.obric.aiagent.plugin");
            this.f14597a = r3;
            this.f14598b = r8;
            this.f14599c = r9;
            this.f14600d = r7;
        }

        @Override // com.obric.agent.f
        public Object a(IntentAppAction r7, JobResult r8, d.c.d<? super x> r9) {
            d.c.d r10 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r9, d.c.d.class, "com.obric.aiagent.plugin");
            if (r7.getMessageId() != this.f14597a) goto L5;
            this.f14598b.removeActionFinishedListener((com.obric.agent.f) ZeusTransformUtils.preCheckCast(this, com.obric.agent.f.class, "com.obric.aiagent.plugin"));
            if (this.f14599c.a() == false) goto L10;
            d.c.d r11 = (d.c.d) ZeusTransformUtils.preCheckCast(this.f14599c, d.c.d.class, "com.obric.aiagent.plugin");
            d.n.a r12 = d.n.f38560a;
            r11.resumeWith(d.n.f(AppFuncExecuteIntent.access$toIntentResult(this.f14600d, r8)));
        L10:
            return x.f38692a;
        L5:
            return x.f38692a;
        }
    }

    /* JADX INFO: compiled from: AppFuncExecuteIntent.kt */
    @d.c.b.a.f(b = "AppFuncExecuteIntent.kt", c = {62}, d = "doAction", e = "com.obric.agent.intents.AppFuncExecuteIntent")
    static final class e extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f14601a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f14602b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        /* synthetic */ Object f14603c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ AppFuncExecuteIntent f14604d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        int f14605e;

        e(AppFuncExecuteIntent r3, d.c.d<? super e> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f14604d = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f14603c = r3;
            this.f14605e |= Integer.MIN_VALUE;
            return this.f14604d.doAction(null, null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: AppFuncExecuteIntent.kt */
    @d.c.b.a.f(b = "AppFuncExecuteIntent.kt", c = {63}, d = "invokeSuspend", e = "com.obric.agent.intents.AppFuncExecuteIntent$doAction$result$1")
    static final class f extends l implements m<am, d.c.d<? super IntentResult<Empty>>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f14606a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ AppFuncExecuteIntent f14607b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f14608c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ JsonObject f14609d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ DispatchContext f14610e;

        f(AppFuncExecuteIntent r3, String r4, JsonObject r5, DispatchContext r6, d.c.d<? super f> r7) {
            d.c.d r8 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r7, d.c.d.class, "com.obric.aiagent.plugin");
            this.f14607b = r3;
            this.f14608c = r4;
            this.f14609d = r5;
            this.f14610e = r6;
            super(2, r8);
        }

        public final Object a(am r3, d.c.d<? super IntentResult<Empty>> r4) {
            return ((f) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), f.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r8, d.c.d<?> r9) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r9, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new f(this.f14607b, this.f14608c, this.f14609d, this.f14610e, r6), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super IntentResult<Empty>> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r9) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f14606a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            o.a(r9);
        L11:
            return r9;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            o.a(r9);
            AppFuncExecuteIntent r2 = this.f14607b;
            String r10 = this.f14608c;
            JsonObject r3 = this.f14609d;
            Long r4 = this.f14610e.getQuestionId();
            Map<String, String> r5 = this.f14610e.getExt();
            d.c.d r6 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f14606a = 1;
            r9 = AppFuncExecuteIntent.access$dispatchAndAwait(r2, r10, r3, r4, r5, r6);
            if (r9 != r0) goto L11;
            return r0;
        }
    }

    static {
        Companion = new a(null);
    }

    @Override // com.obric.capabilitykit.common.intent.BaseAppFuncExecuteIntent, com.obric.capabilitykit.common.intent.IntentFunction
    public boolean isBlock() {
        return true;
    }

    public AppFuncExecuteIntent() {
    }

    public static final /* synthetic */ Object access$dispatchAndAwait(AppFuncExecuteIntent r8, String r9, JsonObject r10, Long r11, Map r12, d.c.d r13) {
        return r8.dispatchAndAwait(r9, r10, r11, (Map) ZeusTransformUtils.wrapperContextForParams(r12, Map.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r13, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    public static final /* synthetic */ IntentResult access$toIntentResult(AppFuncExecuteIntent r0, JobResult r1) {
        return r0.toIntentResult(r1);
    }

    @Override // com.obric.capabilitykit.common.intent.BaseAppFuncExecuteIntent, com.obric.capabilitykit.common.intent.IntentFunction
    public /* synthetic */ Object doAction(Parcelable r3, DispatchContext r4, d.c.d<? super IntentResult<Empty>> r5) {
        Parcelable r6 = (Parcelable) ZeusTransformUtils.wrapperContextForParams(r3, Parcelable.class, "com.obric.aiagent.plugin");
        d.c.d<? super IntentResult<Empty>> r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
        return doAction((AppFuncExecuteParams) ZeusTransformUtils.preCheckCast(r6, AppFuncExecuteParams.class, "com.obric.aiagent.plugin"), r4, r7);
    }

    @Override // com.obric.capabilitykit.common.intent.BaseAppFuncExecuteIntent
    public Object doAction(AppFuncExecuteParams r17, DispatchContext r18, d.c.d<? super IntentResult<Empty>> r19) {
        d.c.d r0 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r19, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r0, e.class) == false) goto L7;
        e r1 = (e) ZeusTransformUtils.preCheckCast(r0, e.class, "com.obric.aiagent.plugin");
        if ((r1.f14605e & Integer.MIN_VALUE) == 0) goto L7;
        r1.f14605e -= Integer.MIN_VALUE;
    L8:
        e r8 = r1;
        Object r2 = r8.f14603c;
        Object r9 = d.c.a.b.a();
        int r3 = r8.f14605e;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        String r4 = (String) ZeusTransformUtils.preCheckCast(r8.f14602b, String.class, "com.obric.aiagent.plugin");
        AppFuncExecuteIntent r5 = (AppFuncExecuteIntent) ZeusTransformUtils.preCheckCast(r8.f14601a, AppFuncExecuteIntent.class, "com.obric.aiagent.plugin");
        o.a(r2);
    L43:
        IntentResult r6 = (IntentResult) ZeusTransformUtils.preCheckCast(r2, IntentResult.class, "com.obric.aiagent.plugin");
        if (r6 != null) goto L47;
        ILogDepend.Companion.e(TAG, "forward timeout, toolName=" + r4);
        return r5.failure(4, "AppFunction execution timed out");
    L47:
        ILogDepend.Companion.i(TAG, "forward finish, toolName=" + r4 + ", ret=" + r6.getRet());
        return r6;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        o.a(r2);
        String r7 = r17.getToolName();
        if (r7 == null) goto L17;
        String r10 = d.o.o.a((CharSequence) ZeusTransformUtils.preCheckCast(r7, CharSequence.class, "com.obric.aiagent.plugin")).toString();
    L18:
        String r12 = r10;
        CharSequence r11 = (CharSequence) ZeusTransformUtils.preCheckCast(r12, CharSequence.class, "com.obric.aiagent.plugin");
        if (r11 != null) goto L21;
    L24:
        boolean r13 = true;
    L25:
        if (r13 == false) goto L29;
        return failure(-2004, "toolName is required");
    L29:
        if (d.h.b.o.a(r12, getName()) == false) goto L33;
        return failure(103, "toolName cannot be " + getName());
    L33:
        if (ILogDepend.Companion.isDebug() == false) goto L35;
        ILogDepend.Companion.i(TAG, "toolName=" + r12 + ", parameters=" + r17.getParameters());
    L35:
        JsonObject r14 = parseParameters(r17.getParameters());
        if (r14 == null) goto L38;
        m r15 = (m) ZeusTransformUtils.preCheckCast(new f(this, r12, com.obric.agent.utils.b.f15994a.a(r14), r18, null), m.class, "com.obric.aiagent.plugin");
        r8.f14601a = this;
        r8.f14602b = r12;
        r8.f14605e = 1;
        r2 = dg.b(FORWARD_TIMEOUT_MS, r15, r8);
        if (r2 != r9) goto L42;
        return r9;
    L42:
        r5 = this;
        r4 = r12;
        goto L43
    L38:
        return failure(103, "parameters must be a JSON object");
    L21:
        if (r11.length() == 0) goto L24;
        r13 = false;
        goto L25
    L17:
        r10 = null;
    L7:
        r1 = new e(this, r0);
        goto L8
    }

    private final JsonObject parseParameters(String r4) {
        CharSequence r3 = (CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.aiagent.plugin");
        if (r3 != null) goto L5;
    L8:
        boolean r5 = true;
    L9:
        if (r5 == false) goto L23;
        return new JsonObject();
    L23:
        JsonElement r6 = JsonParserExt.INSTANCE.parseString(r4);     // Catch: Exception -> L20
        if (r6.isJsonObject() == true) goto L17;
        r6 = null;
    L17:
        if (r6 == null) goto L25;
        return r6.getAsJsonObject();
    L25:
        return null;
    L20:
        e = move-exception;
        ILogDepend.Companion.e(TAG, "parse parameters failed", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
        return null;
    L5:
        if (d.o.o.d(r3) == true) goto L8;
        r5 = false;
        goto L9
    }

    private final Object dispatchAndAwait(String r17, JsonObject r18, Long r19, Map<String, String> r20, d.c.d<? super IntentResult<Empty>> r21) {
        Map r8 = (Map) ZeusTransformUtils.wrapperContextForParams(r20, Map.class, "com.obric.aiagent.plugin");
        d.c.d r0 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r21, d.c.d.class, "com.obric.aiagent.plugin");
        IAppIntentFeedback r2 = (IAppIntentFeedback) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IAppIntentFeedback.class), IAppIntentFeedback.class, "com.obric.aiagent.plugin");
        if (r2 == null) goto L5;
        long r5 = UUID.randomUUID().toString().hashCode() & Integer.MAX_VALUE;
        kotlinx.coroutines.o r15 = new kotlinx.coroutines.o(d.c.a.b.a(r0), 1);
        r15.e();
        n r3 = (n) ZeusTransformUtils.preCheckCast(r15, n.class, "com.obric.aiagent.plugin");
        d r7 = new d(r5, r2, r3, this);
        r3.a((d.h.a.b) ZeusTransformUtils.preCheckCast(new b(r2, r7), d.h.a.b.class, "com.obric.aiagent.plugin"));
        r2.addLocalActionFinishedListener((com.obric.agent.f) ZeusTransformUtils.preCheckCast(r7, com.obric.agent.f.class, "com.obric.aiagent.plugin"));
        i.a(com.obric.agent.e.f14435a.a(), null, null, (m) ZeusTransformUtils.preCheckCast(new c(r17, r18, r5, r19, r8, null), m.class, "com.obric.aiagent.plugin"), 3, null);
        Object r1 = r15.h();
        if (r1 != d.c.a.b.a()) goto L9;
        d.c.b.a.h.c(r0);
    L9:
        return r1;
    L5:
        return failure(1, "AppIntent feedback service is unavailable");
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final IntentResult<Empty> toIntentResult(JobResult r4) {
        IntentResult<Empty> r0 = 0;
        if (r4 == null) goto L9;
        List<IntentExecutionRecord> r5 = r4.getExecRecords();
        if (r5 == null) goto L9;
        IntentExecutionRecord r6 = (IntentExecutionRecord) ZeusTransformUtils.preCheckCast(p.l(r5), IntentExecutionRecord.class, "com.obric.aiagent.plugin");
        if (r6 == null) goto L9;
        IntentResult<?> r7 = r6.getResult();
    L11:
        if (ZeusTransformUtils.instanceOf(r7, IntentResult.class) == false) goto L13;
        r0 = r7;
    L13:
        if (r0 == 0) goto L15;
        return r0;
    L15:
        return failure(1, "AppFunction returned no execution result");
    L9:
        r7 = null;
        goto L11
    }

    private final IntentResult<Empty> failure(int r14, String r15) {
        return new IntentResult(r14, null, null, r15, false, false, 0, null, null, null, DownloadErrorCode.ERROR_REMOVE_DOWNLOAD_RUNNABLE, null);
    }
}
