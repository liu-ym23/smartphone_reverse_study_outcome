package com.zyql.agentfront.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.chat.trace.ChatTracker;
import com.stepos.ailauncher.foundation.appui.card.provider.didi.DidiCardProvider;
import io.ktor.http.ContentDisposition;
import java.io.Serializable;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\r\b\u0086\b\u0018\u0000 -2\u00020\u0001:\u0001.BE\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0016\b\u0002\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bB\u0011\b\u0016\u0012\u0006\u0010\r\u001a\u00020\f¢\u0006\u0004\b\n\u0010\u000eJ\u001f\u0010\u0011\u001a\u00020\u00102\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0015\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0017\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0017\u0010\u0016J\u001e\u0010\u0018\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0018\u0010\u0019J\u0012\u0010\u001a\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u001a\u0010\u0016J\u0010\u0010\u001b\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\u001b\u0010\u0014JR\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u00022\u0016\b\u0002\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\t\u001a\u00020\bHÆ\u0001¢\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u001e\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u001e\u0010\u0016J\u0010\u0010\u001f\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\u001f\u0010\u0014J\u001a\u0010#\u001a\u00020\"2\b\u0010!\u001a\u0004\u0018\u00010 HÖ\u0003¢\u0006\u0004\b#\u0010$R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010%\u001a\u0004\b&\u0010\u0016R\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010%\u001a\u0004\b'\u0010\u0016R%\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00058\u0006¢\u0006\f\n\u0004\b\u0006\u0010(\u001a\u0004\b)\u0010\u0019R\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0007\u0010%\u001a\u0004\b*\u0010\u0016R\u0017\u0010\t\u001a\u00020\b8\u0006¢\u0006\f\n\u0004\b\t\u0010+\u001a\u0004\b,\u0010\u0014¨\u0006/"}, d2 = {"Lcom/zyql/agentfront/bean/PauseTaskRequest;", "Landroid/os/Parcelable;", "", "taskId", "conversationId", "", "extra", DidiCardProvider.KEY_TRACE_ID, "", "versionCode", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;Ljava/lang/String;I)V", "Landroid/os/Parcel;", "parcel", "(Landroid/os/Parcel;)V", "flags", "LY8/t;", "writeToParcel", "(Landroid/os/Parcel;I)V", "describeContents", "()I", "component1", "()Ljava/lang/String;", "component2", "component3", "()Ljava/util/Map;", "component4", "component5", ChatTracker.CLICK_COPY, "(Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;Ljava/lang/String;I)Lcom/zyql/agentfront/bean/PauseTaskRequest;", "toString", "hashCode", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getTaskId", "getConversationId", "Ljava/util/Map;", "getExtra", "getTraceId", "I", "getVersionCode", "CREATOR", Const.INTENT_KEY_APIKEY, "bean_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class PauseTaskRequest implements Parcelable {

    /* renamed from: CREATOR, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final String conversationId;
    private final Map<String, String> extra;
    private final String taskId;
    private final String traceId;
    private final int versionCode;

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u001f\u0010\f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lcom/zyql/agentfront/bean/PauseTaskRequest$a;", "Landroid/os/Parcelable$Creator;", "Lcom/zyql/agentfront/bean/PauseTaskRequest;", "<init>", "()V", "Landroid/os/Parcel;", "parcel", Const.INTENT_KEY_APIKEY, "(Landroid/os/Parcel;)Lcom/zyql/agentfront/bean/PauseTaskRequest;", "", ContentDisposition.Parameters.Size, "", Const.INTENT_KEY_PKGNAME, "(I)[Lcom/zyql/agentfront/bean/PauseTaskRequest;", "bean_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.zyql.agentfront.bean.PauseTaskRequest$a, reason: from kotlin metadata */
    public static final class Companion implements Parcelable.Creator<PauseTaskRequest> {
        public /* synthetic */ Companion(i iVar) {
            this();
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public PauseTaskRequest createFromParcel(Parcel parcel) {
            p.i(parcel, "parcel");
            return new PauseTaskRequest(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public PauseTaskRequest[] newArray(int size) {
            return new PauseTaskRequest[size];
        }

        public Companion() {
        }
    }

    public PauseTaskRequest(String taskId, String conversationId, Map<String, String> map, String str, int i10) {
        p.i(taskId, "taskId");
        p.i(conversationId, "conversationId");
        this.taskId = taskId;
        this.conversationId = conversationId;
        this.extra = map;
        this.traceId = str;
        this.versionCode = i10;
    }

    public static /* synthetic */ PauseTaskRequest copy$default(PauseTaskRequest pauseTaskRequest, String str, String str2, Map map, String str3, int i10, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = pauseTaskRequest.taskId;
        }
        if ((i11 & 2) != 0) {
            str2 = pauseTaskRequest.conversationId;
        }
        if ((i11 & 4) != 0) {
            map = pauseTaskRequest.extra;
        }
        if ((i11 & 8) != 0) {
            str3 = pauseTaskRequest.traceId;
        }
        if ((i11 & 16) != 0) {
            i10 = pauseTaskRequest.versionCode;
        }
        int i12 = i10;
        Map map2 = map;
        return pauseTaskRequest.copy(str, str2, map2, str3, i12);
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
        p.i(taskId, "taskId");
        p.i(conversationId, "conversationId");
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
        return p.d(this.taskId, pauseTaskRequest.taskId) && p.d(this.conversationId, pauseTaskRequest.conversationId) && p.d(this.extra, pauseTaskRequest.extra) && p.d(this.traceId, pauseTaskRequest.traceId) && this.versionCode == pauseTaskRequest.versionCode;
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
        int iHashCode = ((this.taskId.hashCode() * 31) + this.conversationId.hashCode()) * 31;
        Map<String, String> map = this.extra;
        int iHashCode2 = (iHashCode + (map == null ? 0 : map.hashCode())) * 31;
        String str = this.traceId;
        return ((iHashCode2 + (str != null ? str.hashCode() : 0)) * 31) + Integer.hashCode(this.versionCode);
    }

    public String toString() {
        return "PauseTaskRequest(taskId=" + this.taskId + ", conversationId=" + this.conversationId + ", extra=" + this.extra + ", traceId=" + this.traceId + ", versionCode=" + this.versionCode + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        p.i(parcel, "parcel");
        parcel.writeString(this.taskId);
        parcel.writeString(this.conversationId);
        Map<String, String> map = this.extra;
        parcel.writeSerializable(map instanceof Serializable ? (Serializable) map : null);
        parcel.writeString(this.traceId);
        parcel.writeInt(this.versionCode);
    }

    public /* synthetic */ PauseTaskRequest(String str, String str2, Map map, String str3, int i10, int i11, i iVar) {
        this(str, str2, (i11 & 4) != 0 ? null : map, (i11 & 8) != 0 ? null : str3, (i11 & 16) != 0 ? 0 : i10);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public PauseTaskRequest(Parcel parcel) {
        p.i(parcel, "parcel");
        String string = parcel.readString();
        String str = string == null ? "" : string;
        String string2 = parcel.readString();
        String str2 = string2 == null ? "" : string2;
        Serializable serializable = parcel.readSerializable();
        this(str, str2, serializable instanceof Map ? (Map) serializable : null, parcel.readString(), parcel.readInt());
    }
}
