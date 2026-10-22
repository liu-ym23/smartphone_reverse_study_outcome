package com.stepos.agentframework.adapter.coze.bean;

import B7.a;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.google.gson.annotations.SerializedName;
import com.stepos.common.MetaData;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b#\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0083\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\u001a\u0010\r\u001a\u0016\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u000ej\n\u0012\u0004\u0012\u00020\u0003\u0018\u0001`\u000f\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0012¢\u0006\u0004\b\u0013\u0010\u0014J\t\u0010)\u001a\u00020\u0003HÆ\u0003J\t\u0010*\u001a\u00020\u0003HÆ\u0003J\t\u0010+\u001a\u00020\u0003HÆ\u0003J\t\u0010,\u001a\u00020\u0003HÆ\u0003J\t\u0010-\u001a\u00020\bHÆ\u0003J\u000b\u0010.\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010/\u001a\u00020\u0003HÆ\u0003J\u000b\u00100\u001a\u0004\u0018\u00010\fHÆ\u0003J\u001d\u00101\u001a\u0016\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u000ej\n\u0012\u0004\u0012\u00020\u0003\u0018\u0001`\u000fHÆ\u0003J\u000b\u00102\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00103\u001a\u0004\u0018\u00010\u0012HÆ\u0003J\u0093\u0001\u00104\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\u001c\b\u0002\u0010\r\u001a\u0016\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u000ej\n\u0012\u0004\u0012\u00020\u0003\u0018\u0001`\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÆ\u0001J\u0013\u00105\u001a\u0002062\b\u00107\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00108\u001a\u000209HÖ\u0001J\t\u0010:\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0016R\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0016R\u0016\u0010\u0006\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0016R\u0016\u0010\u0007\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR \u0010\t\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0016\"\u0004\b\u001d\u0010\u001eR\u0016\u0010\n\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0016R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R2\u0010\r\u001a\u0016\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u000ej\n\u0012\u0004\u0012\u00020\u0003\u0018\u0001`\u000f8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u0016R\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u00128\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b'\u0010(¨\u0006;"}, d2 = {"Lcom/stepos/agentframework/adapter/coze/bean/ChatEventData;", "", "id", "", "conversationId", "botId", "role", "type", "Lcom/stepos/agentframework/adapter/coze/bean/Type;", "content", "sectionId", "required_action", "Lcom/stepos/agentframework/adapter/coze/bean/RequiredActionResult;", "suggest", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "reasoning_content", "meta_data", "Lcom/stepos/common/MetaData;", AppAgent.CONSTRUCT, "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/stepos/agentframework/adapter/coze/bean/Type;Ljava/lang/String;Ljava/lang/String;Lcom/stepos/agentframework/adapter/coze/bean/RequiredActionResult;Ljava/util/ArrayList;Ljava/lang/String;Lcom/stepos/common/MetaData;)V", "getId", "()Ljava/lang/String;", "getConversationId", "getBotId", "getRole", "getType", "()Lcom/stepos/agentframework/adapter/coze/bean/Type;", "getContent", "setContent", "(Ljava/lang/String;)V", "getSectionId", "getRequired_action", "()Lcom/stepos/agentframework/adapter/coze/bean/RequiredActionResult;", "getSuggest", "()Ljava/util/ArrayList;", "setSuggest", "(Ljava/util/ArrayList;)V", "getReasoning_content", "getMeta_data", "()Lcom/stepos/common/MetaData;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "copy", "equals", "", "other", "hashCode", "", "toString", "coze_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class ChatEventData {

    @SerializedName("bot_id")
    private final String botId;

    @SerializedName("content")
    private String content;

    @SerializedName("conversation_id")
    private final String conversationId;

    @SerializedName("id")
    private final String id;

    @SerializedName("meta_data")
    private final MetaData meta_data;

    @SerializedName("reasoning_content")
    private final String reasoning_content;

    @SerializedName("required_action")
    private final RequiredActionResult required_action;

    @SerializedName("role")
    private final String role;

    @SerializedName("section_id")
    private final String sectionId;

    @SerializedName("suggest")
    private ArrayList<String> suggest;

    @SerializedName("type")
    private final Type type;

    public ChatEventData(String id, String conversationId, String botId, String role, Type type, String str, String sectionId, RequiredActionResult requiredActionResult, ArrayList<String> arrayList, String str2, MetaData metaData) {
        k.f(id, "id");
        k.f(conversationId, "conversationId");
        k.f(botId, "botId");
        k.f(role, "role");
        k.f(type, "type");
        k.f(sectionId, "sectionId");
        this.id = id;
        this.conversationId = conversationId;
        this.botId = botId;
        this.role = role;
        this.type = type;
        this.content = str;
        this.sectionId = sectionId;
        this.required_action = requiredActionResult;
        this.suggest = arrayList;
        this.reasoning_content = str2;
        this.meta_data = metaData;
    }

    public static /* synthetic */ ChatEventData copy$default(ChatEventData chatEventData, String str, String str2, String str3, String str4, Type type, String str5, String str6, RequiredActionResult requiredActionResult, ArrayList arrayList, String str7, MetaData metaData, int i, Object obj) {
        if ((i & 1) != 0) {
            str = chatEventData.id;
        }
        if ((i & 2) != 0) {
            str2 = chatEventData.conversationId;
        }
        if ((i & 4) != 0) {
            str3 = chatEventData.botId;
        }
        if ((i & 8) != 0) {
            str4 = chatEventData.role;
        }
        if ((i & 16) != 0) {
            type = chatEventData.type;
        }
        if ((i & 32) != 0) {
            str5 = chatEventData.content;
        }
        if ((i & 64) != 0) {
            str6 = chatEventData.sectionId;
        }
        if ((i & 128) != 0) {
            requiredActionResult = chatEventData.required_action;
        }
        if ((i & 256) != 0) {
            arrayList = chatEventData.suggest;
        }
        if ((i & 512) != 0) {
            str7 = chatEventData.reasoning_content;
        }
        if ((i & 1024) != 0) {
            metaData = chatEventData.meta_data;
        }
        String str8 = str7;
        MetaData metaData2 = metaData;
        RequiredActionResult requiredActionResult2 = requiredActionResult;
        ArrayList arrayList2 = arrayList;
        String str9 = str5;
        String str10 = str6;
        Type type2 = type;
        String str11 = str3;
        return chatEventData.copy(str, str2, str11, str4, type2, str9, str10, requiredActionResult2, arrayList2, str8, metaData2);
    }

    /* renamed from: component1, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* renamed from: component10, reason: from getter */
    public final String getReasoning_content() {
        return this.reasoning_content;
    }

    /* renamed from: component11, reason: from getter */
    public final MetaData getMeta_data() {
        return this.meta_data;
    }

    /* renamed from: component2, reason: from getter */
    public final String getConversationId() {
        return this.conversationId;
    }

    /* renamed from: component3, reason: from getter */
    public final String getBotId() {
        return this.botId;
    }

    /* renamed from: component4, reason: from getter */
    public final String getRole() {
        return this.role;
    }

    /* renamed from: component5, reason: from getter */
    public final Type getType() {
        return this.type;
    }

    /* renamed from: component6, reason: from getter */
    public final String getContent() {
        return this.content;
    }

    /* renamed from: component7, reason: from getter */
    public final String getSectionId() {
        return this.sectionId;
    }

    /* renamed from: component8, reason: from getter */
    public final RequiredActionResult getRequired_action() {
        return this.required_action;
    }

    public final ArrayList<String> component9() {
        return this.suggest;
    }

    public final ChatEventData copy(String id, String conversationId, String botId, String role, Type type, String content, String sectionId, RequiredActionResult required_action, ArrayList<String> suggest, String reasoning_content, MetaData meta_data) {
        k.f(id, "id");
        k.f(conversationId, "conversationId");
        k.f(botId, "botId");
        k.f(role, "role");
        k.f(type, "type");
        k.f(sectionId, "sectionId");
        return new ChatEventData(id, conversationId, botId, role, type, content, sectionId, required_action, suggest, reasoning_content, meta_data);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ChatEventData)) {
            return false;
        }
        ChatEventData chatEventData = (ChatEventData) other;
        return k.b(this.id, chatEventData.id) && k.b(this.conversationId, chatEventData.conversationId) && k.b(this.botId, chatEventData.botId) && k.b(this.role, chatEventData.role) && this.type == chatEventData.type && k.b(this.content, chatEventData.content) && k.b(this.sectionId, chatEventData.sectionId) && k.b(this.required_action, chatEventData.required_action) && k.b(this.suggest, chatEventData.suggest) && k.b(this.reasoning_content, chatEventData.reasoning_content) && k.b(this.meta_data, chatEventData.meta_data);
    }

    public final String getBotId() {
        return this.botId;
    }

    public final String getContent() {
        return this.content;
    }

    public final String getConversationId() {
        return this.conversationId;
    }

    public final String getId() {
        return this.id;
    }

    public final MetaData getMeta_data() {
        return this.meta_data;
    }

    public final String getReasoning_content() {
        return this.reasoning_content;
    }

    public final RequiredActionResult getRequired_action() {
        return this.required_action;
    }

    public final String getRole() {
        return this.role;
    }

    public final String getSectionId() {
        return this.sectionId;
    }

    public final ArrayList<String> getSuggest() {
        return this.suggest;
    }

    public final Type getType() {
        return this.type;
    }

    public int hashCode() {
        int iHashCode = (this.type.hashCode() + a.c(a.c(a.c(this.id.hashCode() * 31, 31, this.conversationId), 31, this.botId), 31, this.role)) * 31;
        String str = this.content;
        int iC = a.c((iHashCode + (str == null ? 0 : str.hashCode())) * 31, 31, this.sectionId);
        RequiredActionResult requiredActionResult = this.required_action;
        int iHashCode2 = (iC + (requiredActionResult == null ? 0 : requiredActionResult.hashCode())) * 31;
        ArrayList<String> arrayList = this.suggest;
        int iHashCode3 = (iHashCode2 + (arrayList == null ? 0 : arrayList.hashCode())) * 31;
        String str2 = this.reasoning_content;
        int iHashCode4 = (iHashCode3 + (str2 == null ? 0 : str2.hashCode())) * 31;
        MetaData metaData = this.meta_data;
        return iHashCode4 + (metaData != null ? metaData.hashCode() : 0);
    }

    public final void setContent(String str) {
        this.content = str;
    }

    public final void setSuggest(ArrayList<String> arrayList) {
        this.suggest = arrayList;
    }

    public String toString() {
        String str = this.id;
        String str2 = this.conversationId;
        String str3 = this.botId;
        String str4 = this.role;
        Type type = this.type;
        String str5 = this.content;
        String str6 = this.sectionId;
        RequiredActionResult requiredActionResult = this.required_action;
        ArrayList<String> arrayList = this.suggest;
        String str7 = this.reasoning_content;
        MetaData metaData = this.meta_data;
        StringBuilder sbW = a.w("ChatEventData(id=", str, ", conversationId=", str2, ", botId=");
        androidx.constraintlayout.core.dsl.a.A(sbW, str3, ", role=", str4, ", type=");
        sbW.append(type);
        sbW.append(", content=");
        sbW.append(str5);
        sbW.append(", sectionId=");
        sbW.append(str6);
        sbW.append(", required_action=");
        sbW.append(requiredActionResult);
        sbW.append(", suggest=");
        sbW.append(arrayList);
        sbW.append(", reasoning_content=");
        sbW.append(str7);
        sbW.append(", meta_data=");
        sbW.append(metaData);
        sbW.append(")");
        return sbW.toString();
    }

    public /* synthetic */ ChatEventData(String str, String str2, String str3, String str4, Type type, String str5, String str6, RequiredActionResult requiredActionResult, ArrayList arrayList, String str7, MetaData metaData, int i, e eVar) {
        this(str, str2, str3, str4, type, (i & 32) != 0 ? null : str5, str6, (i & 128) != 0 ? null : requiredActionResult, arrayList, (i & 512) != 0 ? null : str7, (i & 1024) != 0 ? null : metaData);
    }
}
