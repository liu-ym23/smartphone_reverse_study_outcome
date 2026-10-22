package com.zyql.agentfront.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.agentframework.chatui.longtext.b;
import com.stepos.ailauncher.chat.trace.ChatTracker;
import com.stepos.ailauncher.chat.voicewakeup.VoiceWakeupReceiver;
import com.stepos.ailauncher.foundation.appui.card.provider.didi.DidiCardProvider;
import com.stepos.ame.sdk.SkillStoreKt;
import com.stepos.core.ability.converter.BundleContentBridge;
import io.ktor.http.ContentDisposition;
import io.requery.android.database.sqlite.SQLiteDatabase;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b#\n\u0002\u0010\u0000\n\u0002\b#\b\u0086\b\u0018\u0000 i2\u00020\u0001:\u0001jBý\u0001\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u0010\b\u001a\u00020\u0002\u0012\b\b\u0002\u0010\t\u001a\u00020\u0002\u0012\b\b\u0002\u0010\n\u001a\u00020\u0002\u0012\u0010\b\u0002\u0010\r\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000e\u0012\u0010\b\u0002\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u000b\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0011\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0015\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0011\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0002\u0012\u0016\b\u0002\u0010\u001c\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u001b\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u001e\u0010\u001fB\u0011\b\u0016\u0012\u0006\u0010!\u001a\u00020 ¢\u0006\u0004\b\u001e\u0010\"J\u001f\u0010%\u001a\u00020$2\u0006\u0010!\u001a\u00020 2\u0006\u0010#\u001a\u00020\u0011H\u0016¢\u0006\u0004\b%\u0010&J\u000f\u0010'\u001a\u00020\u0011H\u0016¢\u0006\u0004\b'\u0010(J\u0012\u0010)\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b)\u0010*J\u0010\u0010+\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b+\u0010*J\u0010\u0010,\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b,\u0010-J\u0012\u0010.\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b.\u0010*J\u0010\u0010/\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b/\u0010*J\u0010\u00100\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b0\u0010*J\u0010\u00101\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b1\u0010*J\u0018\u00102\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bHÆ\u0003¢\u0006\u0004\b2\u00103J\u0012\u00104\u001a\u0004\u0018\u00010\u000eHÆ\u0003¢\u0006\u0004\b4\u00105J\u0018\u00106\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u000bHÆ\u0003¢\u0006\u0004\b6\u00103J\u0010\u00107\u001a\u00020\u0011HÆ\u0003¢\u0006\u0004\b7\u0010(J\u0010\u00108\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b8\u0010-J\u0010\u00109\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b9\u0010-J\u0010\u0010:\u001a\u00020\u0015HÆ\u0003¢\u0006\u0004\b:\u0010;J\u0012\u0010<\u001a\u0004\u0018\u00010\u0011HÆ\u0003¢\u0006\u0004\b<\u0010=J\u0012\u0010>\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b>\u0010*J\u0012\u0010?\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b?\u0010*J\u0012\u0010@\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b@\u0010*J\u001e\u0010A\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u001bHÆ\u0003¢\u0006\u0004\bA\u0010BJ\u0012\u0010C\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\bC\u0010*J\u0086\u0002\u0010D\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u00022\b\b\u0002\u0010\u0006\u001a\u00020\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\b\u001a\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\u00022\b\b\u0002\u0010\n\u001a\u00020\u00022\u0010\b\u0002\u0010\r\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\u0010\b\u0002\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u000b2\b\b\u0002\u0010\u0012\u001a\u00020\u00112\b\b\u0002\u0010\u0013\u001a\u00020\u00052\b\b\u0002\u0010\u0014\u001a\u00020\u00052\b\b\u0002\u0010\u0016\u001a\u00020\u00152\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u00022\u0016\b\u0002\u0010\u001c\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u001b2\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u0002HÆ\u0001¢\u0006\u0004\bD\u0010EJ\u0010\u0010F\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\bF\u0010*J\u0010\u0010G\u001a\u00020\u0011HÖ\u0001¢\u0006\u0004\bG\u0010(J\u001a\u0010J\u001a\u00020\u00052\b\u0010I\u001a\u0004\u0018\u00010HHÖ\u0003¢\u0006\u0004\bJ\u0010KR\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010L\u001a\u0004\bM\u0010*R\"\u0010\u0004\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010L\u001a\u0004\bN\u0010*\"\u0004\bO\u0010PR\u0017\u0010\u0006\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u0006\u0010Q\u001a\u0004\b\u0006\u0010-R$\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0007\u0010L\u001a\u0004\bR\u0010*\"\u0004\bS\u0010PR\u0017\u0010\b\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\b\u0010L\u001a\u0004\bT\u0010*R\u0017\u0010\t\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\t\u0010L\u001a\u0004\bU\u0010*R\u0017\u0010\n\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\n\u0010L\u001a\u0004\bV\u0010*R\u001f\u0010\r\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b8\u0006¢\u0006\f\n\u0004\b\r\u0010W\u001a\u0004\bX\u00103R\u0019\u0010\u000f\u001a\u0004\u0018\u00010\u000e8\u0006¢\u0006\f\n\u0004\b\u000f\u0010Y\u001a\u0004\bZ\u00105R\u001f\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u000b8\u0006¢\u0006\f\n\u0004\b\u0010\u0010W\u001a\u0004\b[\u00103R\u0017\u0010\u0012\u001a\u00020\u00118\u0006¢\u0006\f\n\u0004\b\u0012\u0010\\\u001a\u0004\b]\u0010(R\u0017\u0010\u0013\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u0013\u0010Q\u001a\u0004\b\u0013\u0010-R\u0017\u0010\u0014\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u0014\u0010Q\u001a\u0004\b\u0014\u0010-R\u0017\u0010\u0016\u001a\u00020\u00158\u0006¢\u0006\f\n\u0004\b\u0016\u0010^\u001a\u0004\b_\u0010;R\u0019\u0010\u0017\u001a\u0004\u0018\u00010\u00118\u0006¢\u0006\f\n\u0004\b\u0017\u0010`\u001a\u0004\ba\u0010=R\u0019\u0010\u0018\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0018\u0010L\u001a\u0004\bb\u0010*R$\u0010\u0019\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010L\u001a\u0004\bc\u0010*\"\u0004\bd\u0010PR\u0019\u0010\u001a\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u001a\u0010L\u001a\u0004\be\u0010*R%\u0010\u001c\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u001b8\u0006¢\u0006\f\n\u0004\b\u001c\u0010f\u001a\u0004\bg\u0010BR\u0019\u0010\u001d\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u001d\u0010L\u001a\u0004\bh\u0010*¨\u0006k"}, d2 = {"Lcom/zyql/agentfront/bean/Message;", "Landroid/os/Parcelable;", "", "originMessageId", "messageId", "", "isActive", "conversationId", BundleContentBridge.KEY_ROLE, "type", "contentType", "", "Lcom/zyql/agentfront/bean/MessageContent;", SkillStoreKt.SKILL_DOC_TYPE_CONTENT, "Lcom/zyql/agentfront/bean/ToolCall;", "toolCall", "toolCalls", "", VoiceWakeupReceiver.EXTRA_STATE, "isFinish", "isStream", "", "timestamp", "errorCode", "errorMessage", "sourcePackage", "targetPackage", "", "extra", DidiCardProvider.KEY_TRACE_ID, "<init>", "(Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Lcom/zyql/agentfront/bean/ToolCall;Ljava/util/List;IZZJLjava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;Ljava/lang/String;)V", "Landroid/os/Parcel;", "parcel", "(Landroid/os/Parcel;)V", "flags", "LY8/t;", "writeToParcel", "(Landroid/os/Parcel;I)V", "describeContents", "()I", "component1", "()Ljava/lang/String;", "component2", "component3", "()Z", "component4", "component5", "component6", "component7", "component8", "()Ljava/util/List;", "component9", "()Lcom/zyql/agentfront/bean/ToolCall;", "component10", "component11", "component12", "component13", "component14", "()J", "component15", "()Ljava/lang/Integer;", "component16", "component17", "component18", "component19", "()Ljava/util/Map;", "component20", ChatTracker.CLICK_COPY, "(Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Lcom/zyql/agentfront/bean/ToolCall;Ljava/util/List;IZZJLjava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;Ljava/lang/String;)Lcom/zyql/agentfront/bean/Message;", "toString", "hashCode", "", "other", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getOriginMessageId", "getMessageId", "setMessageId", "(Ljava/lang/String;)V", "Z", "getConversationId", "setConversationId", "getRole", "getType", "getContentType", "Ljava/util/List;", "getContent", "Lcom/zyql/agentfront/bean/ToolCall;", "getToolCall", "getToolCalls", "I", "getState", "J", "getTimestamp", "Ljava/lang/Integer;", "getErrorCode", "getErrorMessage", "getSourcePackage", "setSourcePackage", "getTargetPackage", "Ljava/util/Map;", "getExtra", "getTraceId", "CREATOR", Const.INTENT_KEY_APIKEY, "bean_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class Message implements Parcelable {

    /* renamed from: CREATOR, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
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

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u001f\u0010\f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lcom/zyql/agentfront/bean/Message$a;", "Landroid/os/Parcelable$Creator;", "Lcom/zyql/agentfront/bean/Message;", "<init>", "()V", "Landroid/os/Parcel;", "parcel", Const.INTENT_KEY_APIKEY, "(Landroid/os/Parcel;)Lcom/zyql/agentfront/bean/Message;", "", ContentDisposition.Parameters.Size, "", Const.INTENT_KEY_PKGNAME, "(I)[Lcom/zyql/agentfront/bean/Message;", "bean_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.zyql.agentfront.bean.Message$a, reason: from kotlin metadata */
    public static final class Companion implements Parcelable.Creator<Message> {
        public /* synthetic */ Companion(i iVar) {
            this();
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Message createFromParcel(Parcel parcel) {
            p.i(parcel, "parcel");
            return new Message(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public Message[] newArray(int size) {
            return new Message[size];
        }

        public Companion() {
        }
    }

    public Message() {
        this(null, null, false, null, null, null, null, null, null, null, 0, false, false, 0L, null, null, null, null, null, null, 1048575, null);
    }

    public static /* synthetic */ Message copy$default(Message message, String str, String str2, boolean z10, String str3, String str4, String str5, String str6, List list, ToolCall toolCall, List list2, int i10, boolean z11, boolean z12, long j10, Integer num, String str7, String str8, String str9, Map map, String str10, int i11, Object obj) {
        String str11;
        Map map2;
        String str12 = (i11 & 1) != 0 ? message.originMessageId : str;
        String str13 = (i11 & 2) != 0 ? message.messageId : str2;
        boolean z13 = (i11 & 4) != 0 ? message.isActive : z10;
        String str14 = (i11 & 8) != 0 ? message.conversationId : str3;
        String str15 = (i11 & 16) != 0 ? message.role : str4;
        String str16 = (i11 & 32) != 0 ? message.type : str5;
        String str17 = (i11 & 64) != 0 ? message.contentType : str6;
        List list3 = (i11 & 128) != 0 ? message.content : list;
        ToolCall toolCall2 = (i11 & 256) != 0 ? message.toolCall : toolCall;
        List list4 = (i11 & 512) != 0 ? message.toolCalls : list2;
        int i12 = (i11 & 1024) != 0 ? message.state : i10;
        boolean z14 = (i11 & 2048) != 0 ? message.isFinish : z11;
        boolean z15 = (i11 & 4096) != 0 ? message.isStream : z12;
        String str18 = str12;
        String str19 = str13;
        long j11 = (i11 & b.THRESHOLD) != 0 ? message.timestamp : j10;
        Integer num2 = (i11 & 16384) != 0 ? message.errorCode : num;
        String str20 = (i11 & 32768) != 0 ? message.errorMessage : str7;
        String str21 = (i11 & 65536) != 0 ? message.sourcePackage : str8;
        String str22 = (i11 & SQLiteDatabase.OPEN_SHAREDCACHE) != 0 ? message.targetPackage : str9;
        Map map3 = (i11 & SQLiteDatabase.OPEN_PRIVATECACHE) != 0 ? message.extra : map;
        if ((i11 & 524288) != 0) {
            map2 = map3;
            str11 = message.traceId;
        } else {
            str11 = str10;
            map2 = map3;
        }
        return message.copy(str18, str19, z13, str14, str15, str16, str17, list3, toolCall2, list4, i12, z14, z15, j11, num2, str20, str21, str22, map2, str11);
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
        p.i(messageId, "messageId");
        p.i(role, "role");
        p.i(type, "type");
        p.i(contentType, "contentType");
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
        return p.d(this.originMessageId, message.originMessageId) && p.d(this.messageId, message.messageId) && this.isActive == message.isActive && p.d(this.conversationId, message.conversationId) && p.d(this.role, message.role) && p.d(this.type, message.type) && p.d(this.contentType, message.contentType) && p.d(this.content, message.content) && p.d(this.toolCall, message.toolCall) && p.d(this.toolCalls, message.toolCalls) && this.state == message.state && this.isFinish == message.isFinish && this.isStream == message.isStream && this.timestamp == message.timestamp && p.d(this.errorCode, message.errorCode) && p.d(this.errorMessage, message.errorMessage) && p.d(this.sourcePackage, message.sourcePackage) && p.d(this.targetPackage, message.targetPackage) && p.d(this.extra, message.extra) && p.d(this.traceId, message.traceId);
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
        int iHashCode = (((((str == null ? 0 : str.hashCode()) * 31) + this.messageId.hashCode()) * 31) + Boolean.hashCode(this.isActive)) * 31;
        String str2 = this.conversationId;
        int iHashCode2 = (((((((iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31) + this.role.hashCode()) * 31) + this.type.hashCode()) * 31) + this.contentType.hashCode()) * 31;
        List<MessageContent> list = this.content;
        int iHashCode3 = (iHashCode2 + (list == null ? 0 : list.hashCode())) * 31;
        ToolCall toolCall = this.toolCall;
        int iHashCode4 = (iHashCode3 + (toolCall == null ? 0 : toolCall.hashCode())) * 31;
        List<ToolCall> list2 = this.toolCalls;
        int iHashCode5 = (((((((((iHashCode4 + (list2 == null ? 0 : list2.hashCode())) * 31) + Integer.hashCode(this.state)) * 31) + Boolean.hashCode(this.isFinish)) * 31) + Boolean.hashCode(this.isStream)) * 31) + Long.hashCode(this.timestamp)) * 31;
        Integer num = this.errorCode;
        int iHashCode6 = (iHashCode5 + (num == null ? 0 : num.hashCode())) * 31;
        String str3 = this.errorMessage;
        int iHashCode7 = (iHashCode6 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.sourcePackage;
        int iHashCode8 = (iHashCode7 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.targetPackage;
        int iHashCode9 = (iHashCode8 + (str5 == null ? 0 : str5.hashCode())) * 31;
        Map<String, String> map = this.extra;
        int iHashCode10 = (iHashCode9 + (map == null ? 0 : map.hashCode())) * 31;
        String str6 = this.traceId;
        return iHashCode10 + (str6 != null ? str6.hashCode() : 0);
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
        p.i(str, "<set-?>");
        this.messageId = str;
    }

    public final void setSourcePackage(String str) {
        this.sourcePackage = str;
    }

    public String toString() {
        return "Message(originMessageId=" + this.originMessageId + ", messageId=" + this.messageId + ", isActive=" + this.isActive + ", conversationId=" + this.conversationId + ", role=" + this.role + ", type=" + this.type + ", contentType=" + this.contentType + ", content=" + this.content + ", toolCall=" + this.toolCall + ", toolCalls=" + this.toolCalls + ", state=" + this.state + ", isFinish=" + this.isFinish + ", isStream=" + this.isStream + ", timestamp=" + this.timestamp + ", errorCode=" + this.errorCode + ", errorMessage=" + this.errorMessage + ", sourcePackage=" + this.sourcePackage + ", targetPackage=" + this.targetPackage + ", extra=" + this.extra + ", traceId=" + this.traceId + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        p.i(parcel, "parcel");
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

    public Message(String str, String messageId, boolean z10, String str2, String role, String type, String contentType, List<MessageContent> list, ToolCall toolCall, List<ToolCall> list2, int i10, boolean z11, boolean z12, long j10, Integer num, String str3, String str4, String str5, Map<String, String> map, String str6) {
        p.i(messageId, "messageId");
        p.i(role, "role");
        p.i(type, "type");
        p.i(contentType, "contentType");
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
        this.state = i10;
        this.isFinish = z11;
        this.isStream = z12;
        this.timestamp = j10;
        this.errorCode = num;
        this.errorMessage = str3;
        this.sourcePackage = str4;
        this.targetPackage = str5;
        this.extra = map;
        this.traceId = str6;
    }

    public /* synthetic */ Message(String str, String str2, boolean z10, String str3, String str4, String str5, String str6, List list, ToolCall toolCall, List list2, int i10, boolean z11, boolean z12, long j10, Integer num, String str7, String str8, String str9, Map map, String str10, int i11, i iVar) {
        this((i11 & 1) != 0 ? null : str, (i11 & 2) != 0 ? "" : str2, (i11 & 4) != 0 ? false : z10, (i11 & 8) != 0 ? null : str3, (i11 & 16) != 0 ? "user" : str4, (i11 & 32) != 0 ? "normal" : str5, (i11 & 64) != 0 ? "text" : str6, (i11 & 128) != 0 ? null : list, (i11 & 256) != 0 ? null : toolCall, (i11 & 512) != 0 ? null : list2, (i11 & 1024) != 0 ? 0 : i10, (i11 & 2048) != 0 ? false : z11, (i11 & 4096) == 0 ? z12 : false, (i11 & b.THRESHOLD) != 0 ? System.currentTimeMillis() : j10, (i11 & 16384) != 0 ? null : num, (i11 & 32768) != 0 ? null : str7, (i11 & 65536) != 0 ? null : str8, (i11 & SQLiteDatabase.OPEN_SHAREDCACHE) != 0 ? null : str9, (i11 & SQLiteDatabase.OPEN_PRIVATECACHE) != 0 ? null : map, (i11 & 524288) != 0 ? null : str10);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public Message(Parcel parcel) {
        boolean z10;
        p.i(parcel, "parcel");
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
        string4 = string4 == null ? "user" : string4;
        String string5 = parcel.readString();
        string5 = string5 == null ? "normal" : string5;
        String string6 = parcel.readString();
        string6 = string6 == null ? "text" : string6;
        ArrayList arrayListCreateTypedArrayList = parcel.createTypedArrayList(MessageContent.INSTANCE);
        ToolCall toolCall = (ToolCall) parcel.readParcelable(ToolCall.class.getClassLoader());
        ArrayList arrayListCreateTypedArrayList2 = parcel.createTypedArrayList(ToolCall.INSTANCE);
        int i10 = parcel.readInt();
        boolean z12 = parcel.readByte() != 0 ? z10 : false;
        boolean z13 = parcel.readByte() != 0 ? z10 : false;
        long j10 = parcel.readLong();
        Object value = parcel.readValue(Integer.TYPE.getClassLoader());
        Integer num = value instanceof Integer ? (Integer) value : null;
        String string7 = parcel.readString();
        String string8 = parcel.readString();
        String string9 = parcel.readString();
        Serializable serializable = parcel.readSerializable();
        this(string, str, z11, string3, string4, string5, string6, arrayListCreateTypedArrayList, toolCall, arrayListCreateTypedArrayList2, i10, z12, z13, j10, num, string7, string8, string9, serializable instanceof Map ? (Map) serializable : null, parcel.readString());
    }
}
