package com.stepos.ability.beaninternal.ability;

import androidx.constraintlayout.core.dsl.a;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.stepos.ability.beaninternal.task.GuiTaskProgressKt;
import com.stepos.ability.commoninternal.Key;
import com.stepos.agentbus.generated.AgentBusWakeContract;
import com.stepos.taskrobot.llmapi.stepfun.InjectExperienceResult;
import kotlin.Metadata;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b0\b\u0086\b\u0018\u00002\u00020\u0001B\u0091\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\u000b\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0012\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0003\u0012\u0006\u0010\u0015\u001a\u00020\u000b¢\u0006\u0004\b\u0016\u0010\u0017J\t\u0010.\u001a\u00020\u0003HÆ\u0003J\u0010\u0010/\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u001bJ\u000b\u00100\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00101\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u00102\u001a\u00020\u0003HÆ\u0003J\t\u00103\u001a\u00020\u0003HÆ\u0003J\t\u00104\u001a\u00020\u000bHÆ\u0003J\t\u00105\u001a\u00020\u000bHÆ\u0003J\u000b\u00106\u001a\u0004\u0018\u00010\u000eHÆ\u0003J\u000b\u00107\u001a\u0004\u0018\u00010\u0010HÆ\u0003J\t\u00108\u001a\u00020\u0012HÆ\u0003J\t\u00109\u001a\u00020\u0003HÆ\u0003J\t\u0010:\u001a\u00020\u0003HÆ\u0003J\t\u0010;\u001a\u00020\u000bHÆ\u0003J¤\u0001\u0010<\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u000b2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u00032\b\b\u0002\u0010\u0014\u001a\u00020\u00032\b\b\u0002\u0010\u0015\u001a\u00020\u000bHÆ\u0001¢\u0006\u0002\u0010=J\u0013\u0010>\u001a\u00020\u00122\b\u0010?\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010@\u001a\u00020\u000bHÖ\u0001J\t\u0010A\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u001c\u001a\u0004\b\u001a\u0010\u001bR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0019R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0019R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0019R\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0019R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u001a\u0010\f\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\"\"\u0004\b$\u0010%R\u0013\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\b\n\u0000\u001a\u0004\b&\u0010'R\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0010¢\u0006\b\n\u0000\u001a\u0004\b(\u0010)R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010*R\u0011\u0010\u0013\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b+\u0010\u0019R\u0011\u0010\u0014\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b,\u0010\u0019R\u0011\u0010\u0015\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b-\u0010\"¨\u0006B"}, d2 = {"Lcom/stepos/ability/beaninternal/ability/AbilityTask;", "", "taskCode", "", "abilityId", "", "params", "extra", "pkgName", GuiTaskProgressKt.GuiTaskProgress_KEY_METHOD, "priority", "", "retryTimes", "callerContext", "Lcom/stepos/ability/beaninternal/ability/AbilityCallerContext;", "callback", "Lcom/stepos/ability/beaninternal/ability/IAbilityExecuteCallback;", "isCloudAbility", "", AgentBusWakeContract.EXTRA_TRACE_ID, Key.KEY_TOOL_CALL_ID, InjectExperienceResult.REASON_TIMEOUT, AppAgent.CONSTRUCT, "(Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILcom/stepos/ability/beaninternal/ability/AbilityCallerContext;Lcom/stepos/ability/beaninternal/ability/IAbilityExecuteCallback;ZLjava/lang/String;Ljava/lang/String;I)V", "getTaskCode", "()Ljava/lang/String;", "getAbilityId", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getParams", "getExtra", "getPkgName", "getMethod", "getPriority", "()I", "getRetryTimes", "setRetryTimes", "(I)V", "getCallerContext", "()Lcom/stepos/ability/beaninternal/ability/AbilityCallerContext;", "getCallback", "()Lcom/stepos/ability/beaninternal/ability/IAbilityExecuteCallback;", "()Z", "getTraceId", "getToolCallId", "getTimeout", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "copy", "(Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILcom/stepos/ability/beaninternal/ability/AbilityCallerContext;Lcom/stepos/ability/beaninternal/ability/IAbilityExecuteCallback;ZLjava/lang/String;Ljava/lang/String;I)Lcom/stepos/ability/beaninternal/ability/AbilityTask;", "equals", "other", "hashCode", "toString", "beanInternal_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class AbilityTask {
    private final Long abilityId;
    private final IAbilityExecuteCallback callback;
    private final AbilityCallerContext callerContext;
    private final String extra;
    private final boolean isCloudAbility;
    private final String method;
    private final String params;
    private final String pkgName;
    private final int priority;
    private int retryTimes;
    private final String taskCode;
    private final int timeout;
    private final String toolCallId;
    private final String traceId;

    public AbilityTask(String taskCode, Long l, String str, String str2, String pkgName, String method, int i, int i6, AbilityCallerContext abilityCallerContext, IAbilityExecuteCallback iAbilityExecuteCallback, boolean z10, String traceId, String toolCallId, int i10) {
        k.f(taskCode, "taskCode");
        k.f(pkgName, "pkgName");
        k.f(method, "method");
        k.f(traceId, "traceId");
        k.f(toolCallId, "toolCallId");
        this.taskCode = taskCode;
        this.abilityId = l;
        this.params = str;
        this.extra = str2;
        this.pkgName = pkgName;
        this.method = method;
        this.priority = i;
        this.retryTimes = i6;
        this.callerContext = abilityCallerContext;
        this.callback = iAbilityExecuteCallback;
        this.isCloudAbility = z10;
        this.traceId = traceId;
        this.toolCallId = toolCallId;
        this.timeout = i10;
    }

    /* renamed from: component1, reason: from getter */
    public final String getTaskCode() {
        return this.taskCode;
    }

    /* renamed from: component10, reason: from getter */
    public final IAbilityExecuteCallback getCallback() {
        return this.callback;
    }

    /* renamed from: component11, reason: from getter */
    public final boolean getIsCloudAbility() {
        return this.isCloudAbility;
    }

    /* renamed from: component12, reason: from getter */
    public final String getTraceId() {
        return this.traceId;
    }

    /* renamed from: component13, reason: from getter */
    public final String getToolCallId() {
        return this.toolCallId;
    }

    /* renamed from: component14, reason: from getter */
    public final int getTimeout() {
        return this.timeout;
    }

    /* renamed from: component2, reason: from getter */
    public final Long getAbilityId() {
        return this.abilityId;
    }

    /* renamed from: component3, reason: from getter */
    public final String getParams() {
        return this.params;
    }

    /* renamed from: component4, reason: from getter */
    public final String getExtra() {
        return this.extra;
    }

    /* renamed from: component5, reason: from getter */
    public final String getPkgName() {
        return this.pkgName;
    }

    /* renamed from: component6, reason: from getter */
    public final String getMethod() {
        return this.method;
    }

    /* renamed from: component7, reason: from getter */
    public final int getPriority() {
        return this.priority;
    }

    /* renamed from: component8, reason: from getter */
    public final int getRetryTimes() {
        return this.retryTimes;
    }

    /* renamed from: component9, reason: from getter */
    public final AbilityCallerContext getCallerContext() {
        return this.callerContext;
    }

    public final AbilityTask copy(String taskCode, Long abilityId, String params, String extra, String pkgName, String method, int priority, int retryTimes, AbilityCallerContext callerContext, IAbilityExecuteCallback callback, boolean isCloudAbility, String traceId, String toolCallId, int timeout) {
        k.f(taskCode, "taskCode");
        k.f(pkgName, "pkgName");
        k.f(method, "method");
        k.f(traceId, "traceId");
        k.f(toolCallId, "toolCallId");
        return new AbilityTask(taskCode, abilityId, params, extra, pkgName, method, priority, retryTimes, callerContext, callback, isCloudAbility, traceId, toolCallId, timeout);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AbilityTask)) {
            return false;
        }
        AbilityTask abilityTask = (AbilityTask) other;
        return k.b(this.taskCode, abilityTask.taskCode) && k.b(this.abilityId, abilityTask.abilityId) && k.b(this.params, abilityTask.params) && k.b(this.extra, abilityTask.extra) && k.b(this.pkgName, abilityTask.pkgName) && k.b(this.method, abilityTask.method) && this.priority == abilityTask.priority && this.retryTimes == abilityTask.retryTimes && k.b(this.callerContext, abilityTask.callerContext) && k.b(this.callback, abilityTask.callback) && this.isCloudAbility == abilityTask.isCloudAbility && k.b(this.traceId, abilityTask.traceId) && k.b(this.toolCallId, abilityTask.toolCallId) && this.timeout == abilityTask.timeout;
    }

    public final Long getAbilityId() {
        return this.abilityId;
    }

    public final IAbilityExecuteCallback getCallback() {
        return this.callback;
    }

    public final AbilityCallerContext getCallerContext() {
        return this.callerContext;
    }

    public final String getExtra() {
        return this.extra;
    }

    public final String getMethod() {
        return this.method;
    }

    public final String getParams() {
        return this.params;
    }

    public final String getPkgName() {
        return this.pkgName;
    }

    public final int getPriority() {
        return this.priority;
    }

    public final int getRetryTimes() {
        return this.retryTimes;
    }

    public final String getTaskCode() {
        return this.taskCode;
    }

    public final int getTimeout() {
        return this.timeout;
    }

    public final String getToolCallId() {
        return this.toolCallId;
    }

    public final String getTraceId() {
        return this.traceId;
    }

    public int hashCode() {
        int iHashCode = this.taskCode.hashCode() * 31;
        Long l = this.abilityId;
        int iHashCode2 = (iHashCode + (l == null ? 0 : l.hashCode())) * 31;
        String str = this.params;
        int iHashCode3 = (iHashCode2 + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.extra;
        int iA = a.a(this.retryTimes, a.a(this.priority, B7.a.c(B7.a.c((iHashCode3 + (str2 == null ? 0 : str2.hashCode())) * 31, 31, this.pkgName), 31, this.method), 31), 31);
        AbilityCallerContext abilityCallerContext = this.callerContext;
        int iHashCode4 = (iA + (abilityCallerContext == null ? 0 : abilityCallerContext.hashCode())) * 31;
        IAbilityExecuteCallback iAbilityExecuteCallback = this.callback;
        return Integer.hashCode(this.timeout) + B7.a.c(B7.a.c(androidx.appfunctions.metadata.a.d((iHashCode4 + (iAbilityExecuteCallback != null ? iAbilityExecuteCallback.hashCode() : 0)) * 31, 31, this.isCloudAbility), 31, this.traceId), 31, this.toolCallId);
    }

    public final boolean isCloudAbility() {
        return this.isCloudAbility;
    }

    public final void setRetryTimes(int i) {
        this.retryTimes = i;
    }

    public String toString() {
        String str = this.taskCode;
        Long l = this.abilityId;
        String str2 = this.params;
        String str3 = this.extra;
        String str4 = this.pkgName;
        String str5 = this.method;
        int i = this.priority;
        int i6 = this.retryTimes;
        AbilityCallerContext abilityCallerContext = this.callerContext;
        IAbilityExecuteCallback iAbilityExecuteCallback = this.callback;
        boolean z10 = this.isCloudAbility;
        String str6 = this.traceId;
        String str7 = this.toolCallId;
        int i10 = this.timeout;
        StringBuilder sb = new StringBuilder("AbilityTask(taskCode=");
        sb.append(str);
        sb.append(", abilityId=");
        sb.append(l);
        sb.append(", params=");
        a.A(sb, str2, ", extra=", str3, ", pkgName=");
        a.A(sb, str4, ", method=", str5, ", priority=");
        a.y(sb, i, ", retryTimes=", i6, ", callerContext=");
        sb.append(abilityCallerContext);
        sb.append(", callback=");
        sb.append(iAbilityExecuteCallback);
        sb.append(", isCloudAbility=");
        sb.append(z10);
        sb.append(", traceId=");
        sb.append(str6);
        sb.append(", toolCallId=");
        sb.append(str7);
        sb.append(", timeout=");
        sb.append(i10);
        sb.append(")");
        return sb.toString();
    }

    public /* synthetic */ AbilityTask(String str, Long l, String str2, String str3, String str4, String str5, int i, int i6, AbilityCallerContext abilityCallerContext, IAbilityExecuteCallback iAbilityExecuteCallback, boolean z10, String str6, String str7, int i10, int i11, e eVar) {
        this(str, l, str2, (i11 & 8) != 0 ? null : str3, str4, str5, (i11 & 64) != 0 ? 0 : i, (i11 & 128) != 0 ? 0 : i6, (i11 & 256) != 0 ? null : abilityCallerContext, (i11 & 512) != 0 ? null : iAbilityExecuteCallback, (i11 & 1024) != 0 ? false : z10, (i11 & 2048) != 0 ? "" : str6, (i11 & 4096) != 0 ? "" : str7, i10);
    }
}
