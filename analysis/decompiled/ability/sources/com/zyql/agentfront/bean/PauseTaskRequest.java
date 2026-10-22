package com.zyql.agentfront.bean;

import B7.a;
import android.os.Parcel;
import android.os.Parcelable;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.stepos.ability.beaninternal.task.GuiTaskProgressKt;
import com.stepos.agentbus.generated.AgentBusWakeContract;
import java.io.Serializable;
import java.util.Map;
import k7.h;
import kotlin.Metadata;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\r\b\u0086\b\u0018\u0000 -2\u00020\u0001:\u0001.BE\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0016\b\u0002\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bB\u0011\b\u0016\u0012\u0006\u0010\r\u001a\u00020\f¢\u0006\u0004\b\n\u0010\u000eJ\u001f\u0010\u0011\u001a\u00020\u00102\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0015\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0017\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0017\u0010\u0016J\u001e\u0010\u0018\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0018\u0010\u0019J\u0012\u0010\u001a\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u001a\u0010\u0016J\u0010\u0010\u001b\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\u001b\u0010\u0014JR\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u00022\u0016\b\u0002\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\t\u001a\u00020\bHÆ\u0001¢\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u001e\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u001e\u0010\u0016J\u0010\u0010\u001f\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\u001f\u0010\u0014J\u001a\u0010#\u001a\u00020\"2\b\u0010!\u001a\u0004\u0018\u00010 HÖ\u0003¢\u0006\u0004\b#\u0010$R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010%\u001a\u0004\b&\u0010\u0016R\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010%\u001a\u0004\b'\u0010\u0016R%\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00058\u0006¢\u0006\f\n\u0004\b\u0006\u0010(\u001a\u0004\b)\u0010\u0019R\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0007\u0010%\u001a\u0004\b*\u0010\u0016R\u0017\u0010\t\u001a\u00020\b8\u0006¢\u0006\f\n\u0004\b\t\u0010+\u001a\u0004\b,\u0010\u0014¨\u0006/"}, d2 = {"Lcom/zyql/agentfront/bean/PauseTaskRequest;", "Landroid/os/Parcelable;", "", GuiTaskProgressKt.GuiTaskProgress_KEY_TASK_ID, "conversationId", "", "extra", AgentBusWakeContract.EXTRA_TRACE_ID, "", "versionCode", AppAgent.CONSTRUCT, "(Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;Ljava/lang/String;I)V", "Landroid/os/Parcel;", "parcel", "(Landroid/os/Parcel;)V", "flags", "LC7/r;", "writeToParcel", "(Landroid/os/Parcel;I)V", "describeContents", "()I", "component1", "()Ljava/lang/String;", "component2", "component3", "()Ljava/util/Map;", "component4", "component5", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;Ljava/lang/String;I)Lcom/zyql/agentfront/bean/PauseTaskRequest;", "toString", "hashCode", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getTaskId", "getConversationId", "Ljava/util/Map;", "getExtra", "getTraceId", "I", "getVersionCode", "CREATOR", "k7/h", "bean_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class PauseTaskRequest implements Parcelable {
    public static final h CREATOR = new h();
    private final String conversationId;
    private final Map<String, String> extra;
    private final String taskId;
    private final String traceId;
    private final int versionCode;

    public PauseTaskRequest(String taskId, String conversationId, Map<String, String> map, String str, int i) {
        k.f(taskId, "taskId");
        k.f(conversationId, "conversationId");
        this.taskId = taskId;
        this.conversationId = conversationId;
        this.extra = map;
        this.traceId = str;
        this.versionCode = i;
    }

    public static /* synthetic */ PauseTaskRequest copy$default(PauseTaskRequest pauseTaskRequest, String str, String str2, Map map, String str3, int i, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            str = pauseTaskRequest.taskId;
        }
        if ((i6 & 2) != 0) {
            str2 = pauseTaskRequest.conversationId;
        }
        if ((i6 & 4) != 0) {
            map = pauseTaskRequest.extra;
        }
        if ((i6 & 8) != 0) {
            str3 = pauseTaskRequest.traceId;
        }
        if ((i6 & 16) != 0) {
            i = pauseTaskRequest.versionCode;
        }
        int i10 = i;
        Map map2 = map;
        return pauseTaskRequest.copy(str, str2, map2, str3, i10);
    }

    /* renamed from: component1, reason: from getter */
    public final String getTaskId() {
        return this.taskId;
    }

    /* renamed from: component2, reason: from getter */
    public final String getConversationId() {
        return this.conversationId;
    }

    public final Map<String, String> component3() {
        return this.extra;
    }

    /* renamed from: component4, reason: from getter */
    public final String getTraceId() {
        return this.traceId;
    }

    /* renamed from: component5, reason: from getter */
    public final int getVersionCode() {
        return this.versionCode;
    }

    public final PauseTaskRequest copy(String taskId, String conversationId, Map<String, String> extra, String traceId, int versionCode) {
        k.f(taskId, "taskId");
        k.f(conversationId, "conversationId");
        return new PauseTaskRequest(taskId, conversationId, extra, traceId, versionCode);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PauseTaskRequest)) {
            return false;
        }
        PauseTaskRequest pauseTaskRequest = (PauseTaskRequest) other;
        return k.b(this.taskId, pauseTaskRequest.taskId) && k.b(this.conversationId, pauseTaskRequest.conversationId) && k.b(this.extra, pauseTaskRequest.extra) && k.b(this.traceId, pauseTaskRequest.traceId) && this.versionCode == pauseTaskRequest.versionCode;
    }

    public final String getConversationId() {
        return this.conversationId;
    }

    public final Map<String, String> getExtra() {
        return this.extra;
    }

    public final String getTaskId() {
        return this.taskId;
    }

    public final String getTraceId() {
        return this.traceId;
    }

    public final int getVersionCode() {
        return this.versionCode;
    }

    public int hashCode() {
        int iC = a.c(this.taskId.hashCode() * 31, 31, this.conversationId);
        Map<String, String> map = this.extra;
        int iHashCode = (iC + (map == null ? 0 : map.hashCode())) * 31;
        String str = this.traceId;
        return Integer.hashCode(this.versionCode) + ((iHashCode + (str != null ? str.hashCode() : 0)) * 31);
    }

    public String toString() {
        String str = this.taskId;
        String str2 = this.conversationId;
        Map<String, String> map = this.extra;
        String str3 = this.traceId;
        int i = this.versionCode;
        StringBuilder sbW = a.w("PauseTaskRequest(taskId=", str, ", conversationId=", str2, ", extra=");
        sbW.append(map);
        sbW.append(", traceId=");
        sbW.append(str3);
        sbW.append(", versionCode=");
        return androidx.appfunctions.metadata.a.o(sbW, ")", i);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        k.f(parcel, "parcel");
        parcel.writeString(this.taskId);
        parcel.writeString(this.conversationId);
        Map<String, String> map = this.extra;
        parcel.writeSerializable(map instanceof Serializable ? (Serializable) map : null);
        parcel.writeString(this.traceId);
        parcel.writeInt(this.versionCode);
    }

    public /* synthetic */ PauseTaskRequest(String str, String str2, Map map, String str3, int i, int i6, e eVar) {
        this(str, str2, (i6 & 4) != 0 ? null : map, (i6 & 8) != 0 ? null : str3, (i6 & 16) != 0 ? 0 : i);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public PauseTaskRequest(Parcel parcel) {
        k.f(parcel, "parcel");
        String string = parcel.readString();
        String str = string == null ? "" : string;
        String string2 = parcel.readString();
        String str2 = string2 == null ? "" : string2;
        Serializable serializable = parcel.readSerializable();
        this(str, str2, serializable instanceof Map ? (Map) serializable : null, parcel.readString(), parcel.readInt());
    }
}
