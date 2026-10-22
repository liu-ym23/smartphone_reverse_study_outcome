package com.stepos.ability.monitor.model;

import B7.a;
import androidx.compose.foundation.b;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.stepos.ability.beaninternal.task.GuiTaskProgressKt;
import kotlin.Metadata;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b.\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001Bs\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\u0006\u0010\t\u001a\u00020\u0005\u0012\u0006\u0010\n\u001a\u00020\u0005\u0012\u0006\u0010\u000b\u001a\u00020\u0005\u0012\u0006\u0010\f\u001a\u00020\u0003\u0012\u0006\u0010\r\u001a\u00020\u0003\u0012\u0006\u0010\u000e\u001a\u00020\u0003\u0012\u0006\u0010\u000f\u001a\u00020\u0005\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010$\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0014J\t\u0010%\u001a\u00020\u0005HÆ\u0003J\t\u0010&\u001a\u00020\u0005HÆ\u0003J\t\u0010'\u001a\u00020\u0005HÆ\u0003J\t\u0010(\u001a\u00020\u0005HÆ\u0003J\t\u0010)\u001a\u00020\u0005HÆ\u0003J\t\u0010*\u001a\u00020\u0005HÆ\u0003J\t\u0010+\u001a\u00020\u0005HÆ\u0003J\t\u0010,\u001a\u00020\u0003HÆ\u0003J\t\u0010-\u001a\u00020\u0003HÆ\u0003J\t\u0010.\u001a\u00020\u0003HÆ\u0003J\t\u0010/\u001a\u00020\u0005HÆ\u0003J\u000b\u00100\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0094\u0001\u00101\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\u00052\b\b\u0002\u0010\n\u001a\u00020\u00052\b\b\u0002\u0010\u000b\u001a\u00020\u00052\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u00032\b\b\u0002\u0010\u000f\u001a\u00020\u00052\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u00102J\u0013\u00103\u001a\u0002042\b\u00105\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00106\u001a\u000207HÖ\u0001J\t\u00108\u001a\u00020\u0005HÖ\u0001R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0017R\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0017R\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0017R\u0011\u0010\t\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0017R\u0011\u0010\n\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0017R\u0011\u0010\u000b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0017R\u0011\u0010\f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0011\u0010\r\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u001fR\u0011\u0010\u000e\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u001fR\u0011\u0010\u000f\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0017R\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u0017¨\u00069"}, d2 = {"Lcom/stepos/ability/monitor/model/MonitorRecordItem;", "", "abilityId", "", "pkgName", "", GuiTaskProgressKt.GuiTaskProgress_KEY_METHOD, "taskCode", "fromPkg", "fromSign", "toPkg", "toSign", "taskTime", "callTime", "cost", "status", "errorMsg", AppAgent.CONSTRUCT, "(Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JJJLjava/lang/String;Ljava/lang/String;)V", "getAbilityId", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getPkgName", "()Ljava/lang/String;", "getMethod", "getTaskCode", "getFromPkg", "getFromSign", "getToPkg", "getToSign", "getTaskTime", "()J", "getCallTime", "getCost", "getStatus", "getErrorMsg", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "copy", "(Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JJJLjava/lang/String;Ljava/lang/String;)Lcom/stepos/ability/monitor/model/MonitorRecordItem;", "equals", "", "other", "hashCode", "", "toString", "monitor_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class MonitorRecordItem {
    private final Long abilityId;
    private final long callTime;
    private final long cost;
    private final String errorMsg;
    private final String fromPkg;
    private final String fromSign;
    private final String method;
    private final String pkgName;
    private final String status;
    private final String taskCode;
    private final long taskTime;
    private final String toPkg;
    private final String toSign;

    public MonitorRecordItem(Long l, String pkgName, String method, String taskCode, String fromPkg, String fromSign, String toPkg, String toSign, long j5, long j6, long j10, String status, String str) {
        k.f(pkgName, "pkgName");
        k.f(method, "method");
        k.f(taskCode, "taskCode");
        k.f(fromPkg, "fromPkg");
        k.f(fromSign, "fromSign");
        k.f(toPkg, "toPkg");
        k.f(toSign, "toSign");
        k.f(status, "status");
        this.abilityId = l;
        this.pkgName = pkgName;
        this.method = method;
        this.taskCode = taskCode;
        this.fromPkg = fromPkg;
        this.fromSign = fromSign;
        this.toPkg = toPkg;
        this.toSign = toSign;
        this.taskTime = j5;
        this.callTime = j6;
        this.cost = j10;
        this.status = status;
        this.errorMsg = str;
    }

    /* renamed from: component1, reason: from getter */
    public final Long getAbilityId() {
        return this.abilityId;
    }

    /* renamed from: component10, reason: from getter */
    public final long getCallTime() {
        return this.callTime;
    }

    /* renamed from: component11, reason: from getter */
    public final long getCost() {
        return this.cost;
    }

    /* renamed from: component12, reason: from getter */
    public final String getStatus() {
        return this.status;
    }

    /* renamed from: component13, reason: from getter */
    public final String getErrorMsg() {
        return this.errorMsg;
    }

    /* renamed from: component2, reason: from getter */
    public final String getPkgName() {
        return this.pkgName;
    }

    /* renamed from: component3, reason: from getter */
    public final String getMethod() {
        return this.method;
    }

    /* renamed from: component4, reason: from getter */
    public final String getTaskCode() {
        return this.taskCode;
    }

    /* renamed from: component5, reason: from getter */
    public final String getFromPkg() {
        return this.fromPkg;
    }

    /* renamed from: component6, reason: from getter */
    public final String getFromSign() {
        return this.fromSign;
    }

    /* renamed from: component7, reason: from getter */
    public final String getToPkg() {
        return this.toPkg;
    }

    /* renamed from: component8, reason: from getter */
    public final String getToSign() {
        return this.toSign;
    }

    /* renamed from: component9, reason: from getter */
    public final long getTaskTime() {
        return this.taskTime;
    }

    public final MonitorRecordItem copy(Long abilityId, String pkgName, String method, String taskCode, String fromPkg, String fromSign, String toPkg, String toSign, long taskTime, long callTime, long cost, String status, String errorMsg) {
        k.f(pkgName, "pkgName");
        k.f(method, "method");
        k.f(taskCode, "taskCode");
        k.f(fromPkg, "fromPkg");
        k.f(fromSign, "fromSign");
        k.f(toPkg, "toPkg");
        k.f(toSign, "toSign");
        k.f(status, "status");
        return new MonitorRecordItem(abilityId, pkgName, method, taskCode, fromPkg, fromSign, toPkg, toSign, taskTime, callTime, cost, status, errorMsg);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MonitorRecordItem)) {
            return false;
        }
        MonitorRecordItem monitorRecordItem = (MonitorRecordItem) other;
        return k.b(this.abilityId, monitorRecordItem.abilityId) && k.b(this.pkgName, monitorRecordItem.pkgName) && k.b(this.method, monitorRecordItem.method) && k.b(this.taskCode, monitorRecordItem.taskCode) && k.b(this.fromPkg, monitorRecordItem.fromPkg) && k.b(this.fromSign, monitorRecordItem.fromSign) && k.b(this.toPkg, monitorRecordItem.toPkg) && k.b(this.toSign, monitorRecordItem.toSign) && this.taskTime == monitorRecordItem.taskTime && this.callTime == monitorRecordItem.callTime && this.cost == monitorRecordItem.cost && k.b(this.status, monitorRecordItem.status) && k.b(this.errorMsg, monitorRecordItem.errorMsg);
    }

    public final Long getAbilityId() {
        return this.abilityId;
    }

    public final long getCallTime() {
        return this.callTime;
    }

    public final long getCost() {
        return this.cost;
    }

    public final String getErrorMsg() {
        return this.errorMsg;
    }

    public final String getFromPkg() {
        return this.fromPkg;
    }

    public final String getFromSign() {
        return this.fromSign;
    }

    public final String getMethod() {
        return this.method;
    }

    public final String getPkgName() {
        return this.pkgName;
    }

    public final String getStatus() {
        return this.status;
    }

    public final String getTaskCode() {
        return this.taskCode;
    }

    public final long getTaskTime() {
        return this.taskTime;
    }

    public final String getToPkg() {
        return this.toPkg;
    }

    public final String getToSign() {
        return this.toSign;
    }

    public int hashCode() {
        Long l = this.abilityId;
        int iC = a.c(androidx.appfunctions.metadata.a.c(androidx.appfunctions.metadata.a.c(androidx.appfunctions.metadata.a.c(a.c(a.c(a.c(a.c(a.c(a.c(a.c((l == null ? 0 : l.hashCode()) * 31, 31, this.pkgName), 31, this.method), 31, this.taskCode), 31, this.fromPkg), 31, this.fromSign), 31, this.toPkg), 31, this.toSign), 31, this.taskTime), 31, this.callTime), 31, this.cost), 31, this.status);
        String str = this.errorMsg;
        return iC + (str != null ? str.hashCode() : 0);
    }

    public String toString() {
        Long l = this.abilityId;
        String str = this.pkgName;
        String str2 = this.method;
        String str3 = this.taskCode;
        String str4 = this.fromPkg;
        String str5 = this.fromSign;
        String str6 = this.toPkg;
        String str7 = this.toSign;
        long j5 = this.taskTime;
        long j6 = this.callTime;
        long j10 = this.cost;
        String str8 = this.status;
        String str9 = this.errorMsg;
        StringBuilder sb = new StringBuilder("MonitorRecordItem(abilityId=");
        sb.append(l);
        sb.append(", pkgName=");
        sb.append(str);
        sb.append(", method=");
        androidx.constraintlayout.core.dsl.a.A(sb, str2, ", taskCode=", str3, ", fromPkg=");
        androidx.constraintlayout.core.dsl.a.A(sb, str4, ", fromSign=", str5, ", toPkg=");
        androidx.constraintlayout.core.dsl.a.A(sb, str6, ", toSign=", str7, ", taskTime=");
        sb.append(j5);
        b.y(j6, ", callTime=", ", cost=", sb);
        sb.append(j10);
        sb.append(", status=");
        sb.append(str8);
        return androidx.constraintlayout.core.dsl.a.j(sb, ", errorMsg=", str9, ")");
    }
}
