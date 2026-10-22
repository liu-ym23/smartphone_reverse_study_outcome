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

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\r\b\u0086\b\u0018\u0000 /2\u00020\u0001:\u00010BO\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0002\u0012\u0016\b\u0002\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0007\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\n\u0010\u000bB\u0011\b\u0016\u0012\u0006\u0010\r\u001a\u00020\f¢\u0006\u0004\b\n\u0010\u000eJ\u001f\u0010\u0012\u001a\u00020\u00112\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0016\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0018\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0018\u0010\u0017J\u0010\u0010\u0019\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0019\u0010\u0017J\u0012\u0010\u001a\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u001a\u0010\u0017J\u001e\u0010\u001b\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0007HÆ\u0003¢\u0006\u0004\b\u001b\u0010\u001cJ\u0012\u0010\u001d\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u001d\u0010\u0017J^\u0010\u001e\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00022\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00022\u0016\b\u0002\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0002HÆ\u0001¢\u0006\u0004\b\u001e\u0010\u001fJ\u0010\u0010 \u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b \u0010\u0017J\u0010\u0010!\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b!\u0010\u0015J\u001a\u0010%\u001a\u00020$2\b\u0010#\u001a\u0004\u0018\u00010\"HÖ\u0003¢\u0006\u0004\b%\u0010&R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010'\u001a\u0004\b(\u0010\u0017R\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010'\u001a\u0004\b)\u0010\u0017R\u0017\u0010\u0005\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0005\u0010'\u001a\u0004\b*\u0010\u0017R\u0019\u0010\u0006\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0006\u0010'\u001a\u0004\b+\u0010\u0017R%\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00078\u0006¢\u0006\f\n\u0004\b\b\u0010,\u001a\u0004\b-\u0010\u001cR\u0019\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\t\u0010'\u001a\u0004\b.\u0010\u0017¨\u00061"}, d2 = {"Lcom/zyql/agentfront/bean/ToolResultRequest;", "Landroid/os/Parcelable;", "", "toolCallId", "toolName", "result", "sourcePackage", "", "extra", DidiCardProvider.KEY_TRACE_ID, "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;Ljava/lang/String;)V", "Landroid/os/Parcel;", "parcel", "(Landroid/os/Parcel;)V", "", "flags", "LY8/t;", "writeToParcel", "(Landroid/os/Parcel;I)V", "describeContents", "()I", "component1", "()Ljava/lang/String;", "component2", "component3", "component4", "component5", "()Ljava/util/Map;", "component6", ChatTracker.CLICK_COPY, "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;Ljava/lang/String;)Lcom/zyql/agentfront/bean/ToolResultRequest;", "toString", "hashCode", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getToolCallId", "getToolName", "getResult", "getSourcePackage", "Ljava/util/Map;", "getExtra", "getTraceId", "CREATOR", Const.INTENT_KEY_APIKEY, "bean_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class ToolResultRequest implements Parcelable {

    /* renamed from: CREATOR, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final Map<String, String> extra;
    private final String result;
    private final String sourcePackage;
    private final String toolCallId;
    private final String toolName;
    private final String traceId;

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u001f\u0010\f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lcom/zyql/agentfront/bean/ToolResultRequest$a;", "Landroid/os/Parcelable$Creator;", "Lcom/zyql/agentfront/bean/ToolResultRequest;", "<init>", "()V", "Landroid/os/Parcel;", "parcel", Const.INTENT_KEY_APIKEY, "(Landroid/os/Parcel;)Lcom/zyql/agentfront/bean/ToolResultRequest;", "", ContentDisposition.Parameters.Size, "", Const.INTENT_KEY_PKGNAME, "(I)[Lcom/zyql/agentfront/bean/ToolResultRequest;", "bean_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.zyql.agentfront.bean.ToolResultRequest$a, reason: from kotlin metadata */
    public static final class Companion implements Parcelable.Creator<ToolResultRequest> {
        public /* synthetic */ Companion(i iVar) {
            this();
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public ToolResultRequest createFromParcel(Parcel parcel) {
            p.i(parcel, "parcel");
            return new ToolResultRequest(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public ToolResultRequest[] newArray(int size) {
            return new ToolResultRequest[size];
        }

        public Companion() {
        }
    }

    public ToolResultRequest(String toolCallId, String toolName, String result, String str, Map<String, String> map, String str2) {
        p.i(toolCallId, "toolCallId");
        p.i(toolName, "toolName");
        p.i(result, "result");
        this.toolCallId = toolCallId;
        this.toolName = toolName;
        this.result = result;
        this.sourcePackage = str;
        this.extra = map;
        this.traceId = str2;
    }

    public static /* synthetic */ ToolResultRequest copy$default(ToolResultRequest toolResultRequest, String str, String str2, String str3, String str4, Map map, String str5, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = toolResultRequest.toolCallId;
        }
        if ((i10 & 2) != 0) {
            str2 = toolResultRequest.toolName;
        }
        if ((i10 & 4) != 0) {
            str3 = toolResultRequest.result;
        }
        if ((i10 & 8) != 0) {
            str4 = toolResultRequest.sourcePackage;
        }
        if ((i10 & 16) != 0) {
            map = toolResultRequest.extra;
        }
        if ((i10 & 32) != 0) {
            str5 = toolResultRequest.traceId;
        }
        Map map2 = map;
        String str6 = str5;
        return toolResultRequest.copy(str, str2, str3, str4, map2, str6);
    }

    /* renamed from: component1, reason: from getter */
    public final String getToolCallId() {
        return this.toolCallId;
    }

    /* renamed from: component2, reason: from getter */
    public final String getToolName() {
        return this.toolName;
    }

    /* renamed from: component3, reason: from getter */
    public final String getResult() {
        return this.result;
    }

    /* renamed from: component4, reason: from getter */
    public final String getSourcePackage() {
        return this.sourcePackage;
    }

    public final Map<String, String> component5() {
        return this.extra;
    }

    /* renamed from: component6, reason: from getter */
    public final String getTraceId() {
        return this.traceId;
    }

    public final ToolResultRequest copy(String toolCallId, String toolName, String result, String sourcePackage, Map<String, String> extra, String traceId) {
        p.i(toolCallId, "toolCallId");
        p.i(toolName, "toolName");
        p.i(result, "result");
        return new ToolResultRequest(toolCallId, toolName, result, sourcePackage, extra, traceId);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ToolResultRequest)) {
            return false;
        }
        ToolResultRequest toolResultRequest = (ToolResultRequest) other;
        return p.d(this.toolCallId, toolResultRequest.toolCallId) && p.d(this.toolName, toolResultRequest.toolName) && p.d(this.result, toolResultRequest.result) && p.d(this.sourcePackage, toolResultRequest.sourcePackage) && p.d(this.extra, toolResultRequest.extra) && p.d(this.traceId, toolResultRequest.traceId);
    }

    public final Map<String, String> getExtra() {
        return this.extra;
    }

    public final String getResult() {
        return this.result;
    }

    public final String getSourcePackage() {
        return this.sourcePackage;
    }

    public final String getToolCallId() {
        return this.toolCallId;
    }

    public final String getToolName() {
        return this.toolName;
    }

    public final String getTraceId() {
        return this.traceId;
    }

    public int hashCode() {
        int iHashCode = ((((this.toolCallId.hashCode() * 31) + this.toolName.hashCode()) * 31) + this.result.hashCode()) * 31;
        String str = this.sourcePackage;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        Map<String, String> map = this.extra;
        int iHashCode3 = (iHashCode2 + (map == null ? 0 : map.hashCode())) * 31;
        String str2 = this.traceId;
        return iHashCode3 + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        return "ToolResultRequest(toolCallId=" + this.toolCallId + ", toolName=" + this.toolName + ", result=" + this.result + ", sourcePackage=" + this.sourcePackage + ", extra=" + this.extra + ", traceId=" + this.traceId + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        p.i(parcel, "parcel");
        parcel.writeString(this.toolCallId);
        parcel.writeString(this.toolName);
        parcel.writeString(this.result);
        parcel.writeString(this.sourcePackage);
        Map<String, String> map = this.extra;
        parcel.writeSerializable(map instanceof Serializable ? (Serializable) map : null);
        parcel.writeString(this.traceId);
    }

    public /* synthetic */ ToolResultRequest(String str, String str2, String str3, String str4, Map map, String str5, int i10, i iVar) {
        this(str, str2, str3, (i10 & 8) != 0 ? null : str4, (i10 & 16) != 0 ? null : map, (i10 & 32) != 0 ? null : str5);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public ToolResultRequest(Parcel parcel) {
        p.i(parcel, "parcel");
        String string = parcel.readString();
        String str = string == null ? "" : string;
        String string2 = parcel.readString();
        String str2 = string2 == null ? "" : string2;
        String string3 = parcel.readString();
        String str3 = string3 == null ? "" : string3;
        String string4 = parcel.readString();
        Serializable serializable = parcel.readSerializable();
        this(str, str2, str3, string4, serializable instanceof Map ? (Map) serializable : null, parcel.readString());
    }
}
