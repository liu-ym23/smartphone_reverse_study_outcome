package com.zyql.agentfront.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.chat.trace.ChatTracker;
import com.stepos.ailauncher.foundation.appui.card.provider.didi.DidiCardProvider;
import io.ktor.http.ContentDisposition;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\f\b\u0086\b\u0018\u0000 ,2\u00020\u0001:\u0001-BC\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\t\u0010\nB\u0011\b\u0016\u0012\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\t\u0010\rJ\u001f\u0010\u0011\u001a\u00020\u00102\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u0012\u0010\u0015\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0017\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0017\u0010\u0016J\u0010\u0010\u0018\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0018\u0010\u0016J\u0010\u0010\u0019\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0019\u0010\u0016J\u0012\u0010\u001a\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u001a\u0010\u0016J\u0012\u0010\u001b\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u001b\u0010\u0016JR\u0010\u001c\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00022\b\b\u0002\u0010\u0006\u001a\u00020\u00022\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0002HÆ\u0001¢\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u001e\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u001e\u0010\u0016J\u0010\u0010\u001f\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\b\u001f\u0010\u0014J\u001a\u0010#\u001a\u00020\"2\b\u0010!\u001a\u0004\u0018\u00010 HÖ\u0003¢\u0006\u0004\b#\u0010$R\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010%\u001a\u0004\b&\u0010\u0016R\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010%\u001a\u0004\b'\u0010\u0016R\u0017\u0010\u0005\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0005\u0010%\u001a\u0004\b(\u0010\u0016R\u0017\u0010\u0006\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0006\u0010%\u001a\u0004\b)\u0010\u0016R\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0007\u0010%\u001a\u0004\b*\u0010\u0016R\u0019\u0010\b\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\b\u0010%\u001a\u0004\b+\u0010\u0016¨\u0006."}, d2 = {"Lcom/zyql/agentfront/bean/ToolCallRequest;", "Landroid/os/Parcelable;", "", "originMessageId", "toolCallId", "conversationId", "toolName", "arguments", DidiCardProvider.KEY_TRACE_ID, "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "Landroid/os/Parcel;", "parcel", "(Landroid/os/Parcel;)V", "", "flags", "LY8/t;", "writeToParcel", "(Landroid/os/Parcel;I)V", "describeContents", "()I", "component1", "()Ljava/lang/String;", "component2", "component3", "component4", "component5", "component6", ChatTracker.CLICK_COPY, "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/zyql/agentfront/bean/ToolCallRequest;", "toString", "hashCode", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getOriginMessageId", "getToolCallId", "getConversationId", "getToolName", "getArguments", "getTraceId", "CREATOR", Const.INTENT_KEY_APIKEY, "bean_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class ToolCallRequest implements Parcelable {

    /* renamed from: CREATOR, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final String arguments;
    private final String conversationId;
    private final String originMessageId;
    private final String toolCallId;
    private final String toolName;
    private final String traceId;

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u001f\u0010\f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lcom/zyql/agentfront/bean/ToolCallRequest$a;", "Landroid/os/Parcelable$Creator;", "Lcom/zyql/agentfront/bean/ToolCallRequest;", "<init>", "()V", "Landroid/os/Parcel;", "parcel", Const.INTENT_KEY_APIKEY, "(Landroid/os/Parcel;)Lcom/zyql/agentfront/bean/ToolCallRequest;", "", ContentDisposition.Parameters.Size, "", Const.INTENT_KEY_PKGNAME, "(I)[Lcom/zyql/agentfront/bean/ToolCallRequest;", "bean_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.zyql.agentfront.bean.ToolCallRequest$a, reason: from kotlin metadata */
    public static final class Companion implements Parcelable.Creator<ToolCallRequest> {
        public /* synthetic */ Companion(i iVar) {
            this();
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public ToolCallRequest createFromParcel(Parcel parcel) {
            p.i(parcel, "parcel");
            return new ToolCallRequest(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public ToolCallRequest[] newArray(int size) {
            return new ToolCallRequest[size];
        }

        public Companion() {
        }
    }

    public ToolCallRequest(String str, String toolCallId, String conversationId, String toolName, String str2, String str3) {
        p.i(toolCallId, "toolCallId");
        p.i(conversationId, "conversationId");
        p.i(toolName, "toolName");
        this.originMessageId = str;
        this.toolCallId = toolCallId;
        this.conversationId = conversationId;
        this.toolName = toolName;
        this.arguments = str2;
        this.traceId = str3;
    }

    public static /* synthetic */ ToolCallRequest copy$default(ToolCallRequest toolCallRequest, String str, String str2, String str3, String str4, String str5, String str6, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = toolCallRequest.originMessageId;
        }
        if ((i10 & 2) != 0) {
            str2 = toolCallRequest.toolCallId;
        }
        if ((i10 & 4) != 0) {
            str3 = toolCallRequest.conversationId;
        }
        if ((i10 & 8) != 0) {
            str4 = toolCallRequest.toolName;
        }
        if ((i10 & 16) != 0) {
            str5 = toolCallRequest.arguments;
        }
        if ((i10 & 32) != 0) {
            str6 = toolCallRequest.traceId;
        }
        String str7 = str5;
        String str8 = str6;
        return toolCallRequest.copy(str, str2, str3, str4, str7, str8);
    }

    /* renamed from: component1, reason: from getter */
    public final String getOriginMessageId() {
        return this.originMessageId;
    }

    /* renamed from: component2, reason: from getter */
    public final String getToolCallId() {
        return this.toolCallId;
    }

    /* renamed from: component3, reason: from getter */
    public final String getConversationId() {
        return this.conversationId;
    }

    /* renamed from: component4, reason: from getter */
    public final String getToolName() {
        return this.toolName;
    }

    /* renamed from: component5, reason: from getter */
    public final String getArguments() {
        return this.arguments;
    }

    /* renamed from: component6, reason: from getter */
    public final String getTraceId() {
        return this.traceId;
    }

    public final ToolCallRequest copy(String originMessageId, String toolCallId, String conversationId, String toolName, String arguments, String traceId) {
        p.i(toolCallId, "toolCallId");
        p.i(conversationId, "conversationId");
        p.i(toolName, "toolName");
        return new ToolCallRequest(originMessageId, toolCallId, conversationId, toolName, arguments, traceId);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ToolCallRequest)) {
            return false;
        }
        ToolCallRequest toolCallRequest = (ToolCallRequest) other;
        return p.d(this.originMessageId, toolCallRequest.originMessageId) && p.d(this.toolCallId, toolCallRequest.toolCallId) && p.d(this.conversationId, toolCallRequest.conversationId) && p.d(this.toolName, toolCallRequest.toolName) && p.d(this.arguments, toolCallRequest.arguments) && p.d(this.traceId, toolCallRequest.traceId);
    }

    public final String getArguments() {
        return this.arguments;
    }

    public final String getConversationId() {
        return this.conversationId;
    }

    public final String getOriginMessageId() {
        return this.originMessageId;
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
        String str = this.originMessageId;
        int iHashCode = (((((((str == null ? 0 : str.hashCode()) * 31) + this.toolCallId.hashCode()) * 31) + this.conversationId.hashCode()) * 31) + this.toolName.hashCode()) * 31;
        String str2 = this.arguments;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.traceId;
        return iHashCode2 + (str3 != null ? str3.hashCode() : 0);
    }

    public String toString() {
        return "ToolCallRequest(originMessageId=" + this.originMessageId + ", toolCallId=" + this.toolCallId + ", conversationId=" + this.conversationId + ", toolName=" + this.toolName + ", arguments=" + this.arguments + ", traceId=" + this.traceId + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        p.i(parcel, "parcel");
        parcel.writeString(this.originMessageId);
        parcel.writeString(this.toolCallId);
        parcel.writeString(this.conversationId);
        parcel.writeString(this.toolName);
        parcel.writeString(this.arguments);
        parcel.writeString(this.traceId);
    }

    public /* synthetic */ ToolCallRequest(String str, String str2, String str3, String str4, String str5, String str6, int i10, i iVar) {
        this((i10 & 1) != 0 ? null : str, str2, str3, str4, (i10 & 16) != 0 ? null : str5, (i10 & 32) != 0 ? null : str6);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public ToolCallRequest(Parcel parcel) {
        p.i(parcel, "parcel");
        String string = parcel.readString();
        String string2 = parcel.readString();
        String str = string2 == null ? "" : string2;
        String string3 = parcel.readString();
        String str2 = string3 == null ? "" : string3;
        String string4 = parcel.readString();
        this(string, str, str2, string4 == null ? "" : string4, parcel.readString(), parcel.readString());
    }
}
