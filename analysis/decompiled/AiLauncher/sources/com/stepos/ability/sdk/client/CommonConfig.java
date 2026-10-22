package com.stepos.ability.sdk.client;

import android.os.Bundle;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ability.bean.TaskUiInfo;
import java.util.UUID;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0010\b\u0086\b\u0018\u00002\u00020\u0001BK\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000e\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0010\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0014\u001a\u00020\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0014\u0010\u0015R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u000fR\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u0017\u0010\u0007\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001d\u0010\u0011R\u0019\u0010\b\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u0017\u001a\u0004\b\u001f\u0010\u000fR\u0019\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u001b\u0010\u0017\u001a\u0004\b\u0016\u0010\u000fR\u0019\u0010\u000b\u001a\u0004\u0018\u00010\n8\u0006¢\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\u0019\u0010\"¨\u0006#"}, d2 = {"Lcom/stepos/ability/sdk/client/q;", "", "", "taskId", "Lcom/stepos/ability/bean/TaskUiInfo;", "taskUiInfo", "", "priority", "parentTaskId", "condition", "Landroid/os/Bundle;", "extra", "<init>", "(Ljava/lang/String;Lcom/stepos/ability/bean/TaskUiInfo;ILjava/lang/String;Ljava/lang/String;Landroid/os/Bundle;)V", "toString", "()Ljava/lang/String;", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", Const.INTENT_KEY_APIKEY, "Ljava/lang/String;", Const.INTENT_KEY_UMID, Const.INTENT_KEY_PKGNAME, "Lcom/stepos/ability/bean/TaskUiInfo;", "e", "()Lcom/stepos/ability/bean/TaskUiInfo;", "c", "I", "getParentTaskId", "f", "Landroid/os/Bundle;", "()Landroid/os/Bundle;", "sdk_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.ability.sdk.client.q, reason: from toString */
/* loaded from: classes2.dex */
public final /* data */ class CommonConfig {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    public final String taskId;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    public final TaskUiInfo taskUiInfo;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    public final int priority;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    public final String parentTaskId;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    public final String condition;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
    public final Bundle extra;

    public CommonConfig() {
        this(null, null, 0, null, null, null, 63, null);
    }

    /* renamed from: a, reason: from getter */
    public final String getCondition() {
        return this.condition;
    }

    /* renamed from: b, reason: from getter */
    public final Bundle getExtra() {
        return this.extra;
    }

    /* renamed from: c, reason: from getter */
    public final int getPriority() {
        return this.priority;
    }

    /* renamed from: d, reason: from getter */
    public final String getTaskId() {
        return this.taskId;
    }

    /* renamed from: e, reason: from getter */
    public final TaskUiInfo getTaskUiInfo() {
        return this.taskUiInfo;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CommonConfig)) {
            return false;
        }
        CommonConfig commonConfig = (CommonConfig) other;
        return kotlin.jvm.internal.p.d(this.taskId, commonConfig.taskId) && kotlin.jvm.internal.p.d(this.taskUiInfo, commonConfig.taskUiInfo) && this.priority == commonConfig.priority && kotlin.jvm.internal.p.d(this.parentTaskId, commonConfig.parentTaskId) && kotlin.jvm.internal.p.d(this.condition, commonConfig.condition) && kotlin.jvm.internal.p.d(this.extra, commonConfig.extra);
    }

    public int hashCode() {
        int iHashCode = this.taskId.hashCode() * 31;
        TaskUiInfo taskUiInfo = this.taskUiInfo;
        int iHashCode2 = (((iHashCode + (taskUiInfo == null ? 0 : taskUiInfo.hashCode())) * 31) + Integer.hashCode(this.priority)) * 31;
        String str = this.parentTaskId;
        int iHashCode3 = (iHashCode2 + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.condition;
        int iHashCode4 = (iHashCode3 + (str2 == null ? 0 : str2.hashCode())) * 31;
        Bundle bundle = this.extra;
        return iHashCode4 + (bundle != null ? bundle.hashCode() : 0);
    }

    public String toString() {
        return "CommonConfig(taskId=" + this.taskId + ", taskUiInfo=" + this.taskUiInfo + ", priority=" + this.priority + ", parentTaskId=" + this.parentTaskId + ", condition=" + this.condition + ", extra=" + this.extra + ")";
    }

    public CommonConfig(String taskId, TaskUiInfo taskUiInfo, int i10, String str, String str2, Bundle bundle) {
        kotlin.jvm.internal.p.i(taskId, "taskId");
        this.taskId = taskId;
        this.taskUiInfo = taskUiInfo;
        this.priority = i10;
        this.parentTaskId = str;
        this.condition = str2;
        this.extra = bundle;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ CommonConfig(String str, TaskUiInfo taskUiInfo, int i10, String str2, String str3, Bundle bundle, int i11, kotlin.jvm.internal.i iVar) {
        if ((i11 & 1) != 0) {
            str = UUID.randomUUID().toString();
            kotlin.jvm.internal.p.h(str, "toString(...)");
        }
        this(str, (i11 & 2) != 0 ? null : taskUiInfo, (i11 & 4) != 0 ? 2 : i10, (i11 & 8) != 0 ? null : str2, (i11 & 16) != 0 ? null : str3, (i11 & 32) != 0 ? null : bundle);
    }
}
