package com.zyql.agentfront.bean;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.appfunctions.metadata.a;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.stepos.agentbus.generated.AgentBusWakeContract;
import com.stepos.agentframework.adapter.bff.BffConstant;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import k7.f;
import kotlin.Metadata;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b#\n\u0002\u0010\u0000\n\u0002\b#\b\u0086\b\u0018\u0000 i2\u00020\u0001:\u0001jBý\u0001\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u0010\b\u001a\u00020\u0002\u0012\b\b\u0002\u0010\t\u001a\u00020\u0002\u0012\b\b\u0002\u0010\n\u001a\u00020\u0002\u0012\u0010\b\u0002\u0010\r\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000e\u0012\u0010\b\u0002\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u000b\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0011\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0015\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0011\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0002\u0012\u0016\b\u0002\u0010\u001c\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u001b\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u001e\u0010\u001fB\u0011\b\u0016\u0012\u0006\u0010!\u001a\u00020 ¢\u0006\u0004\b\u001e\u0010\"J\u001f\u0010%\u001a\u00020$2\u0006\u0010!\u001a\u00020 2\u0006\u0010#\u001a\u00020\u0011H\u0016¢\u0006\u0004\b%\u0010&J\u000f\u0010'\u001a\u00020\u0011H\u0016¢\u0006\u0004\b'\u0010(J\u0012\u0010)\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b)\u0010*J\u0010\u0010+\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b+\u0010*J\u0010\u0010,\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b,\u0010-J\u0012\u0010.\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b.\u0010*J\u0010\u0010/\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b/\u0010*J\u0010\u00100\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b0\u0010*J\u0010\u00101\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b1\u0010*J\u0018\u00102\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bHÆ\u0003¢\u0006\u0004\b2\u00103J\u0012\u00104\u001a\u0004\u0018\u00010\u000eHÆ\u0003¢\u0006\u0004\b4\u00105J\u0018\u00106\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u000bHÆ\u0003¢\u0006\u0004\b6\u00103J\u0010\u00107\u001a\u00020\u0011HÆ\u0003¢\u0006\u0004\b7\u0010(J\u0010\u00108\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b8\u0010-J\u0010\u00109\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b9\u0010-J\u0010\u0010:\u001a\u00020\u0015HÆ\u0003¢\u0006\u0004\b:\u0010;J\u0012\u0010<\u001a\u0004\u0018\u00010\u0011HÆ\u0003¢\u0006\u0004\b<\u0010=J\u0012\u0010>\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b>\u0010*J\u0012\u0010?\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b?\u0010*J\u0012\u0010@\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b@\u0010*J\u001e\u0010A\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u001bHÆ\u0003¢\u0006\u0004\bA\u0010BJ\u0012\u0010C\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\bC\u0010*J\u0086\u0002\u0010D\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u00022\b\b\u0002\u0010\u0006\u001a\u00020\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\b\u001a\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\u00022\b\b\u0002\u0010\n\u001a\u00020\u00022\u0010\b\u0002\u0010\r\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\u0010\b\u0002\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u000b2\b\b\u0002\u0010\u0012\u001a\u00020\u00112\b\b\u0002\u0010\u0013\u001a\u00020\u00052\b\b\u0002\u0010\u0014\u001a\u00020\u00052\b\b\u0002\u0010\u0016\u001a\u00020\u00152\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u00022\u0016\b\u0002\u0010\u001c\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u001b2\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u0002HÆ\u0001¢\u0006\u0004\bD\u0010EJ\u0010\u0010F\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\bF\u0010*J\u0010\u0010G\u001a\u00020\u0011HÖ\u0001¢\u0006\u0004\bG\u0010(J\u001a\u0010J\u001a\u00020\u00052\b\u0010I\u001a\u0004\u0018\u00010HHÖ\u0003¢\u0006\u0004\bJ\u0010KR\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010L\u001a\u0004\bM\u0010*R\"\u0010\u0004\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010L\u001a\u0004\bN\u0010*\"\u0004\bO\u0010PR\u0017\u0010\u0006\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u0006\u0010Q\u001a\u0004\b\u0006\u0010-R$\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0007\u0010L\u001a\u0004\bR\u0010*\"\u0004\bS\u0010PR\u0017\u0010\b\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\b\u0010L\u001a\u0004\bT\u0010*R\u0017\u0010\t\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\t\u0010L\u001a\u0004\bU\u0010*R\u0017\u0010\n\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\n\u0010L\u001a\u0004\bV\u0010*R\u001f\u0010\r\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b8\u0006¢\u0006\f\n\u0004\b\r\u0010W\u001a\u0004\bX\u00103R\u0019\u0010\u000f\u001a\u0004\u0018\u00010\u000e8\u0006¢\u0006\f\n\u0004\b\u000f\u0010Y\u001a\u0004\bZ\u00105R\u001f\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u000b8\u0006¢\u0006\f\n\u0004\b\u0010\u0010W\u001a\u0004\b[\u00103R\u0017\u0010\u0012\u001a\u00020\u00118\u0006¢\u0006\f\n\u0004\b\u0012\u0010\\\u001a\u0004\b]\u0010(R\u0017\u0010\u0013\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u0013\u0010Q\u001a\u0004\b\u0013\u0010-R\u0017\u0010\u0014\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u0014\u0010Q\u001a\u0004\b\u0014\u0010-R\u0017\u0010\u0016\u001a\u00020\u00158\u0006¢\u0006\f\n\u0004\b\u0016\u0010^\u001a\u0004\b_\u0010;R\u0019\u0010\u0017\u001a\u0004\u0018\u00010\u00118\u0006¢\u0006\f\n\u0004\b\u0017\u0010`\u001a\u0004\ba\u0010=R\u0019\u0010\u0018\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0018\u0010L\u001a\u0004\bb\u0010*R$\u0010\u0019\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010L\u001a\u0004\bc\u0010*\"\u0004\bd\u0010PR\u0019\u0010\u001a\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u001a\u0010L\u001a\u0004\be\u0010*R%\u0010\u001c\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u001b8\u0006¢\u0006\f\n\u0004\b\u001c\u0010f\u001a\u0004\bg\u0010BR\u0019\u0010\u001d\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u001d\u0010L\u001a\u0004\bh\u0010*¨\u0006k"}, d2 = {"Lcom/zyql/agentfront/bean/Message;", "Landroid/os/Parcelable;", "", "originMessageId", "messageId", "", "isActive", "conversationId", "role", "type", "contentType", "", "Lcom/zyql/agentfront/bean/MessageContent;", "content", "Lcom/zyql/agentfront/bean/ToolCall;", "toolCall", "toolCalls", "", "state", "isFinish", "isStream", "", "timestamp", "errorCode", "errorMessage", "sourcePackage", "targetPackage", "", "extra", AgentBusWakeContract.EXTRA_TRACE_ID, AppAgent.CONSTRUCT, "(Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Lcom/zyql/agentfront/bean/ToolCall;Ljava/util/List;IZZJLjava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;Ljava/lang/String;)V", "Landroid/os/Parcel;", "parcel", "(Landroid/os/Parcel;)V", "flags", "LC7/r;", "writeToParcel", "(Landroid/os/Parcel;I)V", "describeContents", "()I", "component1", "()Ljava/lang/String;", "component2", "component3", "()Z", "component4", "component5", "component6", "component7", "component8", "()Ljava/util/List;", "component9", "()Lcom/zyql/agentfront/bean/ToolCall;", "component10", "component11", "component12", "component13", "component14", "()J", "component15", "()Ljava/lang/Integer;", "component16", "component17", "component18", "component19", "()Ljava/util/Map;", "component20", "copy", "(Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Lcom/zyql/agentfront/bean/ToolCall;Ljava/util/List;IZZJLjava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;Ljava/lang/String;)Lcom/zyql/agentfront/bean/Message;", "toString", "hashCode", "", "other", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getOriginMessageId", "getMessageId", "setMessageId", "(Ljava/lang/String;)V", "Z", "getConversationId", "setConversationId", "getRole", "getType", "getContentType", "Ljava/util/List;", "getContent", "Lcom/zyql/agentfront/bean/ToolCall;", "getToolCall", "getToolCalls", "I", "getState", "J", "getTimestamp", "Ljava/lang/Integer;", "getErrorCode", "getErrorMessage", "getSourcePackage", "setSourcePackage", "getTargetPackage", "Ljava/util/Map;", "getExtra", "getTraceId", "CREATOR", "k7/f", "bean_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class Message implements Parcelable {
    public static final f CREATOR = new f();
    private final List<MessageContent> content;
    private final String contentType;
    private String conversationId;
    private final Integer errorCode;
    private final String errorMessage;
    private final Map<String, String> extra;
    private final boolean isActive;
    private final boolean isFinish;
    private final boolean isStream;
    private String messageId;
    private final String originMessageId;
    private final String role;
    private String sourcePackage;
    private final int state;
    private final String targetPackage;
    private final long timestamp;
    private final ToolCall toolCall;
    private final List<ToolCall> toolCalls;
    private final String traceId;
    private final String type;

    public Message() {
        this(null, null, false, null, null, null, null, null, null, null, 0, false, false, 0L, null, null, null, null, null, null, 1048575, null);
    }

    public static /* synthetic */ Message copy$default(Message message, String str, String str2, boolean z10, String str3, String str4, String str5, String str6, List list, ToolCall toolCall, List list2, int i, boolean z11, boolean z12, long j5, Integer num, String str7, String str8, String str9, Map map, String str10, int i6, Object obj) {
        String str11;
        Map map2;
        String str12 = (i6 & 1) != 0 ? message.originMessageId : str;
        String str13 = (i6 & 2) != 0 ? message.messageId : str2;
        boolean z13 = (i6 & 4) != 0 ? message.isActive : z10;
        String str14 = (i6 & 8) != 0 ? message.conversationId : str3;
        String str15 = (i6 & 16) != 0 ? message.role : str4;
        String str16 = (i6 & 32) != 0 ? message.type : str5;
        String str17 = (i6 & 64) != 0 ? message.contentType : str6;
        List list3 = (i6 & 128) != 0 ? message.content : list;
        ToolCall toolCall2 = (i6 & 256) != 0 ? message.toolCall : toolCall;
        List list4 = (i6 & 512) != 0 ? message.toolCalls : list2;
        int i10 = (i6 & 1024) != 0 ? message.state : i;
        boolean z14 = (i6 & 2048) != 0 ? message.isFinish : z11;
        boolean z15 = (i6 & 4096) != 0 ? message.isStream : z12;
        String str18 = str12;
        String str19 = str13;
        long j6 = (i6 & 8192) != 0 ? message.timestamp : j5;
        Integer num2 = (i6 & 16384) != 0 ? message.errorCode : num;
        String str20 = (i6 & 32768) != 0 ? message.errorMessage : str7;
        String str21 = (i6 & 65536) != 0 ? message.sourcePackage : str8;
        String str22 = (i6 & 131072) != 0 ? message.targetPackage : str9;
        Map map3 = (i6 & 262144) != 0 ? message.extra : map;
        if ((i6 & 524288) != 0) {
            map2 = map3;
            str11 = message.traceId;
        } else {
            str11 = str10;
            map2 = map3;
        }
        return message.copy(str18, str19, z13, str14, str15, str16, str17, list3, toolCall2, list4, i10, z14, z15, j6, num2, str20, str21, str22, map2, str11);
    }

    /* renamed from: component1, reason: from getter */
    public final String getOriginMessageId() {
        return this.originMessageId;
    }

    public final List<ToolCall> component10() {
        return this.toolCalls;
    }

    /* renamed from: component11, reason: from getter */
    public final int getState() {
        return this.state;
    }

    /* renamed from: component12, reason: from getter */
    public final boolean getIsFinish() {
        return this.isFinish;
    }

    /* renamed from: component13, reason: from getter */
    public final boolean getIsStream() {
        return this.isStream;
    }

    /* renamed from: component14, reason: from getter */
    public final long getTimestamp() {
        return this.timestamp;
    }

    /* renamed from: component15, reason: from getter */
    public final Integer getErrorCode() {
        return this.errorCode;
    }

    /* renamed from: component16, reason: from getter */
    public final String getErrorMessage() {
        return this.errorMessage;
    }

    /* renamed from: component17, reason: from getter */
    public final String getSourcePackage() {
        return this.sourcePackage;
    }

    /* renamed from: component18, reason: from getter */
    public final String getTargetPackage() {
        return this.targetPackage;
    }

    public final Map<String, String> component19() {
        return this.extra;
    }

    /* renamed from: component2, reason: from getter */
    public final String getMessageId() {
        return this.messageId;
    }

    /* renamed from: component20, reason: from getter */
    public final String getTraceId() {
        return this.traceId;
    }

    /* renamed from: component3, reason: from getter */
    public final boolean getIsActive() {
        return this.isActive;
    }

    /* renamed from: component4, reason: from getter */
    public final String getConversationId() {
        return this.conversationId;
    }

    /* renamed from: component5, reason: from getter */
    public final String getRole() {
        return this.role;
    }

    /* renamed from: component6, reason: from getter */
    public final String getType() {
        return this.type;
    }

    /* renamed from: component7, reason: from getter */
    public final String getContentType() {
        return this.contentType;
    }

    public final List<MessageContent> component8() {
        return this.content;
    }

    /* renamed from: component9, reason: from getter */
    public final ToolCall getToolCall() {
        return this.toolCall;
    }

    public final Message copy(String originMessageId, String messageId, boolean isActive, String conversationId, String role, String type, String contentType, List<MessageContent> content, ToolCall toolCall, List<ToolCall> toolCalls, int state, boolean isFinish, boolean isStream, long timestamp, Integer errorCode, String errorMessage, String sourcePackage, String targetPackage, Map<String, String> extra, String traceId) {
        k.f(messageId, "messageId");
        k.f(role, "role");
        k.f(type, "type");
        k.f(contentType, "contentType");
        return new Message(originMessageId, messageId, isActive, conversationId, role, type, contentType, content, toolCall, toolCalls, state, isFinish, isStream, timestamp, errorCode, errorMessage, sourcePackage, targetPackage, extra, traceId);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Message)) {
            return false;
        }
        Message message = (Message) other;
        return k.b(this.originMessageId, message.originMessageId) && k.b(this.messageId, message.messageId) && this.isActive == message.isActive && k.b(this.conversationId, message.conversationId) && k.b(this.role, message.role) && k.b(this.type, message.type) && k.b(this.contentType, message.contentType) && k.b(this.content, message.content) && k.b(this.toolCall, message.toolCall) && k.b(this.toolCalls, message.toolCalls) && this.state == message.state && this.isFinish == message.isFinish && this.isStream == message.isStream && this.timestamp == message.timestamp && k.b(this.errorCode, message.errorCode) && k.b(this.errorMessage, message.errorMessage) && k.b(this.sourcePackage, message.sourcePackage) && k.b(this.targetPackage, message.targetPackage) && k.b(this.extra, message.extra) && k.b(this.traceId, message.traceId);
    }

    public final List<MessageContent> getContent() {
        return this.content;
    }

    public final String getContentType() {
        return this.contentType;
    }

    public final String getConversationId() {
        return this.conversationId;
    }

    public final Integer getErrorCode() {
        return this.errorCode;
    }

    public final String getErrorMessage() {
        return this.errorMessage;
    }

    public final Map<String, String> getExtra() {
        return this.extra;
    }

    public final String getMessageId() {
        return this.messageId;
    }

    public final String getOriginMessageId() {
        return this.originMessageId;
    }

    public final String getRole() {
        return this.role;
    }

    public final String getSourcePackage() {
        return this.sourcePackage;
    }

    public final int getState() {
        return this.state;
    }

    public final String getTargetPackage() {
        return this.targetPackage;
    }

    public final long getTimestamp() {
        return this.timestamp;
    }

    public final ToolCall getToolCall() {
        return this.toolCall;
    }

    public final List<ToolCall> getToolCalls() {
        return this.toolCalls;
    }

    public final String getTraceId() {
        return this.traceId;
    }

    public final String getType() {
        return this.type;
    }

    public int hashCode() {
        String str = this.originMessageId;
        int iD = a.d(B7.a.c((str == null ? 0 : str.hashCode()) * 31, 31, this.messageId), 31, this.isActive);
        String str2 = this.conversationId;
        int iC = B7.a.c(B7.a.c(B7.a.c((iD + (str2 == null ? 0 : str2.hashCode())) * 31, 31, this.role), 31, this.type), 31, this.contentType);
        List<MessageContent> list = this.content;
        int iHashCode = (iC + (list == null ? 0 : list.hashCode())) * 31;
        ToolCall toolCall = this.toolCall;
        int iHashCode2 = (iHashCode + (toolCall == null ? 0 : toolCall.hashCode())) * 31;
        List<ToolCall> list2 = this.toolCalls;
        int iC2 = a.c(a.d(a.d(androidx.constraintlayout.core.dsl.a.a(this.state, (iHashCode2 + (list2 == null ? 0 : list2.hashCode())) * 31, 31), 31, this.isFinish), 31, this.isStream), 31, this.timestamp);
        Integer num = this.errorCode;
        int iHashCode3 = (iC2 + (num == null ? 0 : num.hashCode())) * 31;
        String str3 = this.errorMessage;
        int iHashCode4 = (iHashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.sourcePackage;
        int iHashCode5 = (iHashCode4 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.targetPackage;
        int iHashCode6 = (iHashCode5 + (str5 == null ? 0 : str5.hashCode())) * 31;
        Map<String, String> map = this.extra;
        int iHashCode7 = (iHashCode6 + (map == null ? 0 : map.hashCode())) * 31;
        String str6 = this.traceId;
        return iHashCode7 + (str6 != null ? str6.hashCode() : 0);
    }

    public final boolean isActive() {
        return this.isActive;
    }

    public final boolean isFinish() {
        return this.isFinish;
    }

    public final boolean isStream() {
        return this.isStream;
    }

    public final void setConversationId(String str) {
        this.conversationId = str;
    }

    public final void setMessageId(String str) {
        k.f(str, "<set-?>");
        this.messageId = str;
    }

    public final void setSourcePackage(String str) {
        this.sourcePackage = str;
    }

    public String toString() {
        String str = this.originMessageId;
        String str2 = this.messageId;
        boolean z10 = this.isActive;
        String str3 = this.conversationId;
        String str4 = this.role;
        String str5 = this.type;
        String str6 = this.contentType;
        List<MessageContent> list = this.content;
        ToolCall toolCall = this.toolCall;
        List<ToolCall> list2 = this.toolCalls;
        int i = this.state;
        boolean z11 = this.isFinish;
        boolean z12 = this.isStream;
        long j5 = this.timestamp;
        Integer num = this.errorCode;
        String str7 = this.errorMessage;
        String str8 = this.sourcePackage;
        String str9 = this.targetPackage;
        Map<String, String> map = this.extra;
        String str10 = this.traceId;
        StringBuilder sbW = B7.a.w("Message(originMessageId=", str, ", messageId=", str2, ", isActive=");
        sbW.append(z10);
        sbW.append(", conversationId=");
        sbW.append(str3);
        sbW.append(", role=");
        androidx.constraintlayout.core.dsl.a.A(sbW, str4, ", type=", str5, ", contentType=");
        sbW.append(str6);
        sbW.append(", content=");
        sbW.append(list);
        sbW.append(", toolCall=");
        sbW.append(toolCall);
        sbW.append(", toolCalls=");
        sbW.append(list2);
        sbW.append(", state=");
        sbW.append(i);
        sbW.append(", isFinish=");
        sbW.append(z11);
        sbW.append(", isStream=");
        sbW.append(z12);
        sbW.append(", timestamp=");
        sbW.append(j5);
        sbW.append(", errorCode=");
        sbW.append(num);
        sbW.append(", errorMessage=");
        sbW.append(str7);
        androidx.constraintlayout.core.dsl.a.A(sbW, ", sourcePackage=", str8, ", targetPackage=", str9);
        sbW.append(", extra=");
        sbW.append(map);
        sbW.append(", traceId=");
        sbW.append(str10);
        sbW.append(")");
        return sbW.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        k.f(parcel, "parcel");
        parcel.writeString(this.originMessageId);
        parcel.writeString(this.messageId);
        parcel.writeByte(this.isActive ? (byte) 1 : (byte) 0);
        parcel.writeString(this.conversationId);
        parcel.writeString(this.role);
        parcel.writeString(this.type);
        parcel.writeString(this.contentType);
        parcel.writeTypedList(this.content);
        parcel.writeParcelable(this.toolCall, flags);
        parcel.writeTypedList(this.toolCalls);
        parcel.writeInt(this.state);
        parcel.writeByte(this.isFinish ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.isStream ? (byte) 1 : (byte) 0);
        parcel.writeLong(this.timestamp);
        parcel.writeValue(this.errorCode);
        parcel.writeString(this.errorMessage);
        parcel.writeString(this.sourcePackage);
        parcel.writeString(this.targetPackage);
        Map<String, String> map = this.extra;
        parcel.writeSerializable(map instanceof Serializable ? (Serializable) map : null);
        parcel.writeString(this.traceId);
    }

    public Message(String str, String messageId, boolean z10, String str2, String role, String type, String contentType, List<MessageContent> list, ToolCall toolCall, List<ToolCall> list2, int i, boolean z11, boolean z12, long j5, Integer num, String str3, String str4, String str5, Map<String, String> map, String str6) {
        k.f(messageId, "messageId");
        k.f(role, "role");
        k.f(type, "type");
        k.f(contentType, "contentType");
        this.originMessageId = str;
        this.messageId = messageId;
        this.isActive = z10;
        this.conversationId = str2;
        this.role = role;
        this.type = type;
        this.contentType = contentType;
        this.content = list;
        this.toolCall = toolCall;
        this.toolCalls = list2;
        this.state = i;
        this.isFinish = z11;
        this.isStream = z12;
        this.timestamp = j5;
        this.errorCode = num;
        this.errorMessage = str3;
        this.sourcePackage = str4;
        this.targetPackage = str5;
        this.extra = map;
        this.traceId = str6;
    }

    public /* synthetic */ Message(String str, String str2, boolean z10, String str3, String str4, String str5, String str6, List list, ToolCall toolCall, List list2, int i, boolean z11, boolean z12, long j5, Integer num, String str7, String str8, String str9, Map map, String str10, int i6, e eVar) {
        this((i6 & 1) != 0 ? null : str, (i6 & 2) != 0 ? "" : str2, (i6 & 4) != 0 ? false : z10, (i6 & 8) != 0 ? null : str3, (i6 & 16) != 0 ? BffConstant.Role.User : str4, (i6 & 32) != 0 ? "normal" : str5, (i6 & 64) != 0 ? "text" : str6, (i6 & 128) != 0 ? null : list, (i6 & 256) != 0 ? null : toolCall, (i6 & 512) != 0 ? null : list2, (i6 & 1024) != 0 ? 0 : i, (i6 & 2048) != 0 ? false : z11, (i6 & 4096) == 0 ? z12 : false, (i6 & 8192) != 0 ? System.currentTimeMillis() : j5, (i6 & 16384) != 0 ? null : num, (i6 & 32768) != 0 ? null : str7, (i6 & 65536) != 0 ? null : str8, (i6 & 131072) != 0 ? null : str9, (i6 & 262144) != 0 ? null : map, (i6 & 524288) != 0 ? null : str10);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public Message(Parcel parcel) {
        boolean z10;
        k.f(parcel, "parcel");
        String string = parcel.readString();
        String string2 = parcel.readString();
        String str = string2 == null ? "" : string2;
        boolean z11 = true;
        if (parcel.readByte() != 0) {
            z10 = true;
        } else {
            z10 = true;
            z11 = false;
        }
        String string3 = parcel.readString();
        String string4 = parcel.readString();
        string4 = string4 == null ? BffConstant.Role.User : string4;
        String string5 = parcel.readString();
        string5 = string5 == null ? "normal" : string5;
        String string6 = parcel.readString();
        string6 = string6 == null ? "text" : string6;
        ArrayList arrayListCreateTypedArrayList = parcel.createTypedArrayList(MessageContent.CREATOR);
        ToolCall toolCall = (ToolCall) parcel.readParcelable(ToolCall.class.getClassLoader());
        ArrayList arrayListCreateTypedArrayList2 = parcel.createTypedArrayList(ToolCall.CREATOR);
        int i = parcel.readInt();
        boolean z12 = parcel.readByte() != 0 ? z10 : false;
        boolean z13 = parcel.readByte() != 0 ? z10 : false;
        long j5 = parcel.readLong();
        Object value = parcel.readValue(Integer.TYPE.getClassLoader());
        Integer num = value instanceof Integer ? (Integer) value : null;
        String string7 = parcel.readString();
        String string8 = parcel.readString();
        String string9 = parcel.readString();
        Serializable serializable = parcel.readSerializable();
        this(string, str, z11, string3, string4, string5, string6, arrayListCreateTypedArrayList, toolCall, arrayListCreateTypedArrayList2, i, z12, z13, j5, num, string7, string8, string9, serializable instanceof Map ? (Map) serializable : null, parcel.readString());
    }
}
