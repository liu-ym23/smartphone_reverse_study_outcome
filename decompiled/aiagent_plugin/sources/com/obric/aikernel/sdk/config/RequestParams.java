package com.obric.aikernel.sdk.config;

import android.os.Bundle;
import android.os.Process;
import android.os.SystemClock;
import com.bytedance.apm.battery.dao.DBHelper;
import com.obric.aikernel.core.data.IdlKeys;
import com.obric.aikernel.sdk.AIKernelConfig;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.f;
import d.g;
import d.h.a.a;
import d.h.a.b;
import d.h.b.h;
import d.h.b.o;
import d.x;
import java.util.UUID;

/* JADX INFO: compiled from: RequestParams.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class RequestParams {
    private static final String Args_EventComp = "_EComp";
    public static final String Args_Pid = "_cpid";
    private static final String Args_PkgName = "_PackageName";
    private static final String Args_PostEvent = "_PEvent";
    private static final String Args_SdkVer = "_SdkVer";
    public static final String Args_Uid = "_cuid";
    public static final String Args_llmUsageMode = "_llm_usage_mode";
    public static final int COMPONENT_CLIENT_MGR = 2;
    public static final int COMPONENT_PYVM = 1;
    public static final Companion Companion = null;
    public static final int EVENT_REQUEST_CANCELED = 1;
    public static final int EVENT_REQUEST_COMPLETE = 2;
    public static final int EVENT_REQUEST_EXCEPTION = 3;
    public static final int EVENT_RESUME_PENDING_DOWNLOADS_ON_BIND = 4;
    public static final int PRIORITY_HIGH = 1;
    public static final int PRIORITY_NORMAL = 0;
    public static final int USE_LLM_IN_BACKGROUND_ON_DEMAND = 1;
    private final Bundle backend;
    private final f clientId$delegate;
    private final f traceIdStr$delegate;
    private boolean useLocalPapaya;

    /* JADX INFO: compiled from: RequestParams.kt */
    public static final class Companion {
        public /* synthetic */ Companion(h r1) {
            this();
        }

        private Companion() {
        }

        public final void ensureCallerInfo(Bundle r2, int r3, int r4) {
            o.e(r2, "<this>");
            if (r2.containsKey(RequestParams.Args_Pid) == true) goto L6;
            r2.putInt(RequestParams.Args_Pid, r3);
        L6:
            if (r2.containsKey(RequestParams.Args_Uid) == true) goto L9;
            r2.putInt(RequestParams.Args_Uid, r4);
        L9:
            if (r2.containsKey(IdlKeys.Args_TraceId) == true) goto L12;
            r2.putString(IdlKeys.Args_TraceId, UUID.randomUUID().toString());
        L12:
            if (r2.containsKey(IdlKeys.Args_ReqTime) == true) goto L15;
            r2.putLong(IdlKeys.Args_ReqTime, SystemClock.elapsedRealtime());
        L15:
            if (r2.containsKey(IdlKeys.Args_Priority) == true) goto L18;
            r2.putInt(IdlKeys.Args_Priority, 0);
        L18:
            if (r2.containsKey(IdlKeys.Args_Force_Execute) == true) goto L21;
            r2.putInt(IdlKeys.Args_Force_Execute, 0);
            return;
        }
    }

    static {
        Companion = new Companion(null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public RequestParams() {
        Object[] r0 = 0 == true ? 1 : 0;
        this(null, r0, 3, 0 == true ? 1 : 0);
    }

    public RequestParams(Bundle r3, b<? super RequestParams, x> r4) {
        b r5 = (b) ZeusTransformUtils.wrapperContextForParams(r4, b.class, "com.obric.aiagent.plugin");
        o.e(r3, "backend");
        this.backend = r3;
        this.clientId$delegate = g.a((a) ZeusTransformUtils.preCheckCast(new RequestParams$clientId$2(this), a.class, "com.obric.aiagent.plugin"));
        this.traceIdStr$delegate = g.a((a) ZeusTransformUtils.preCheckCast(new RequestParams$traceIdStr$2(this), a.class, "com.obric.aiagent.plugin"));
        if (r5 == null) goto L6;
        r5.invoke(this);
        return;
    }

    public static final /* synthetic */ String access$getCallerName(RequestParams r0) {
        return r0.getCallerName();
    }

    public /* synthetic */ RequestParams(Bundle r2, b r3, int r4, h r5) {
        b r6 = (b) ZeusTransformUtils.wrapperContextForParams(r3, b.class, "com.obric.aiagent.plugin");
        if ((r4 & 1) == 0) goto L6;
        r2 = new Bundle();
    L6:
        if ((r4 & 2) == 0) goto L8;
        r6 = null;
    L8:
        this(r2, r6);
    }

    public final Bundle getBackend() {
        return this.backend;
    }

    public final String getClientId() {
        return (String) ZeusTransformUtils.preCheckCast(this.clientId$delegate.b(), String.class, "com.obric.aiagent.plugin");
    }

    public final String getTraceIdStr() {
        return (String) ZeusTransformUtils.preCheckCast(this.traceIdStr$delegate.b(), String.class, "com.obric.aiagent.plugin");
    }

    public final String getVersion() {
        String r1 = this.backend.getString("version");
        if (r1 != null) goto L6;
        return "";
    L6:
        return r1;
    }

    public final long getReqTime() {
        return this.backend.getLong(IdlKeys.Args_ReqTime);
    }

    public final boolean getUseLocalPapaya() {
        return this.useLocalPapaya;
    }

    public final void setUseLocalPapaya(boolean r1) {
        this.useLocalPapaya = r1;
    }

    public final void setTimeout(long r2) {
        this.backend.putLong(IdlKeys.Args_Timeout, r2);
    }

    public final long getTimeout() {
        return this.backend.getLong(IdlKeys.Args_Timeout);
    }

    public final void setEvent(int r2) {
        this.backend.putInt(Args_PostEvent, r2);
    }

    public final int getEvent() {
        return this.backend.getInt(Args_PostEvent);
    }

    public final void setTargetComponent(int r2) {
        this.backend.putInt(Args_EventComp, r2);
    }

    public final int getTargetComponent() {
        return this.backend.getInt(Args_EventComp);
    }

    public final void setUseStream(boolean r2) {
        this.backend.putBoolean(IdlKeys.Args_StreamingCall, r2);
    }

    public final boolean getUseStream() {
        return this.backend.getBoolean(IdlKeys.Args_StreamingCall);
    }

    private final void setCallerName(String r2) {
        this.backend.putString("_PackageName", r2);
    }

    private final String getCallerName() {
        return this.backend.getString("_PackageName");
    }

    public final void setSourcePackageName(String r2) {
        this.backend.putString(IdlKeys.Args_SourcePackageName, r2);
    }

    public final String getSourcePackageName() {
        return this.backend.getString(IdlKeys.Args_SourcePackageName);
    }

    public final void setPriority(int r2) {
        this.backend.putInt(IdlKeys.Args_Priority, r2);
    }

    public final int getPriority() {
        return this.backend.getInt(IdlKeys.Args_Priority, 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public RequestParams(RequestParams r3) {
        o.e(r3, DBHelper.BATTERY_COL_SOURCE);
        Bundle r0 = new Bundle();
        r0.putAll(r3.backend);
        this(r0, null, 2, 0 == true ? 1 : 0);
    }

    public final Bundle start() {
        if (this.backend.containsKey("_PackageName") == true) goto L10;
        Bundle r0 = this.backend;
        AIKernelConfig r2 = com.obric.aikernel.core.a.f22349a.a();
        if (r2 == null) goto L7;
        String r3 = r2.getPackageName();
    L8:
        r0.putString("_PackageName", r3);
        goto L10
    L7:
        r3 = null;
    L10:
        if (this.backend.containsKey("_SdkVer") == true) goto L12;
        this.backend.putString("_SdkVer", com.obric.aikernel.core.a.f22349a.b());
    L12:
        AIKernelConfig r1 = com.obric.aikernel.core.a.f22349a.a();
        if (r1 == null) goto L17;
        a<Integer> r4 = r1.getLlmUsageMode();
        if (r4 == null) goto L17;
        this.backend.putInt(Args_llmUsageMode, ((Number) ZeusTransformUtils.preCheckCast(r4.invoke(), Number.class, "com.obric.aiagent.plugin")).intValue());
    L17:
        Companion.ensureCallerInfo(this.backend, Process.myPid(), Process.myUid());
        return this.backend;
    }
}
