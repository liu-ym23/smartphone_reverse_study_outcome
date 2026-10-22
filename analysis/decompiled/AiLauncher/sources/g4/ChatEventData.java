package g4;

import com.autonavi.aps.amapapi.config.Const;
import com.google.gson.annotations.SerializedName;
import com.stepos.agentframework.adapter.coze.bean.RequiredActionResult;
import com.stepos.agentframework.adapter.coze.bean.Type;
import com.stepos.ame.sdk.SkillStoreKt;
import com.stepos.common.MetaData;
import com.stepos.core.ability.converter.BundleContentBridge;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u0004R\u001a\u0010\u000f\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010\r\u001a\u0004\b\u0010\u0010\u0004R\u001a\u0010\u0011\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\r\u001a\u0004\b\u0012\u0010\u0004R\u001a\u0010\u0013\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010\r\u001a\u0004\b\u0014\u0010\u0004R\u001a\u0010\u0016\u001a\u00020\u00158\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R$\u0010\u001a\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\r\u001a\u0004\b\u001b\u0010\u0004\"\u0004\b\u001c\u0010\u001dR\u001a\u0010\u001e\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001e\u0010\r\u001a\u0004\b\u001f\u0010\u0004R\u001c\u0010!\u001a\u0004\u0018\u00010 8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$R6\u0010'\u001a\u0016\u0012\u0004\u0012\u00020\u0002\u0018\u00010%j\n\u0012\u0004\u0012\u00020\u0002\u0018\u0001`&8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\u001c\u0010-\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b-\u0010\r\u001a\u0004\b.\u0010\u0004R\u001c\u00100\u001a\u0004\u0018\u00010/8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b0\u00101\u001a\u0004\b2\u00103¨\u00064"}, d2 = {"Lg4/b;", "", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "id", "Ljava/lang/String;", "c", "conversationId", Const.INTENT_KEY_PKGNAME, "botId", "getBotId", BundleContentBridge.KEY_ROLE, "getRole", "Lcom/stepos/agentframework/adapter/coze/bean/Type;", "type", "Lcom/stepos/agentframework/adapter/coze/bean/Type;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "()Lcom/stepos/agentframework/adapter/coze/bean/Type;", SkillStoreKt.SKILL_DOC_TYPE_CONTENT, Const.INTENT_KEY_APIKEY, "setContent", "(Ljava/lang/String;)V", "sectionId", "getSectionId", "Lcom/stepos/agentframework/adapter/coze/bean/RequiredActionResult;", "required_action", "Lcom/stepos/agentframework/adapter/coze/bean/RequiredActionResult;", "f", "()Lcom/stepos/agentframework/adapter/coze/bean/RequiredActionResult;", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "suggest", "Ljava/util/ArrayList;", Const.INTENT_KEY_BACKGROUND_COMMAND, "()Ljava/util/ArrayList;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "(Ljava/util/ArrayList;)V", "reasoning_content", "e", "Lcom/stepos/common/MetaData;", "meta_data", "Lcom/stepos/common/MetaData;", Const.INTENT_KEY_UMID, "()Lcom/stepos/common/MetaData;", "protocol_coze_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: g4.b, reason: case insensitive filesystem and from toString */
/* loaded from: classes2.dex */
public final /* data */ class ChatEventData {

    @SerializedName("bot_id")
    private final String botId;

    @SerializedName(SkillStoreKt.SKILL_DOC_TYPE_CONTENT)
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

    @SerializedName(BundleContentBridge.KEY_ROLE)
    private final String role;

    @SerializedName("section_id")
    private final String sectionId;

    @SerializedName("suggest")
    private ArrayList<String> suggest;

    @SerializedName("type")
    private final Type type;

    /* renamed from: a, reason: from getter */
    public final String getContent() {
        return this.content;
    }

    /* renamed from: b, reason: from getter */
    public final String getConversationId() {
        return this.conversationId;
    }

    /* renamed from: c, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* renamed from: d, reason: from getter */
    public final MetaData getMeta_data() {
        return this.meta_data;
    }

    /* renamed from: e, reason: from getter */
    public final String getReasoning_content() {
        return this.reasoning_content;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ChatEventData)) {
            return false;
        }
        ChatEventData chatEventData = (ChatEventData) other;
        return p.d(this.id, chatEventData.id) && p.d(this.conversationId, chatEventData.conversationId) && p.d(this.botId, chatEventData.botId) && p.d(this.role, chatEventData.role) && this.type == chatEventData.type && p.d(this.content, chatEventData.content) && p.d(this.sectionId, chatEventData.sectionId) && p.d(this.required_action, chatEventData.required_action) && p.d(this.suggest, chatEventData.suggest) && p.d(this.reasoning_content, chatEventData.reasoning_content) && p.d(this.meta_data, chatEventData.meta_data);
    }

    /* renamed from: f, reason: from getter */
    public final RequiredActionResult getRequired_action() {
        return this.required_action;
    }

    public final ArrayList<String> g() {
        return this.suggest;
    }

    /* renamed from: h, reason: from getter */
    public final Type getType() {
        return this.type;
    }

    public int hashCode() {
        int iHashCode = ((((((((this.id.hashCode() * 31) + this.conversationId.hashCode()) * 31) + this.botId.hashCode()) * 31) + this.role.hashCode()) * 31) + this.type.hashCode()) * 31;
        String str = this.content;
        int iHashCode2 = (((iHashCode + (str == null ? 0 : str.hashCode())) * 31) + this.sectionId.hashCode()) * 31;
        RequiredActionResult requiredActionResult = this.required_action;
        int iHashCode3 = (iHashCode2 + (requiredActionResult == null ? 0 : requiredActionResult.hashCode())) * 31;
        ArrayList<String> arrayList = this.suggest;
        int iHashCode4 = (iHashCode3 + (arrayList == null ? 0 : arrayList.hashCode())) * 31;
        String str2 = this.reasoning_content;
        int iHashCode5 = (iHashCode4 + (str2 == null ? 0 : str2.hashCode())) * 31;
        MetaData metaData = this.meta_data;
        return iHashCode5 + (metaData != null ? metaData.hashCode() : 0);
    }

    public final void i(ArrayList<String> arrayList) {
        this.suggest = arrayList;
    }

    public String toString() {
        return "ChatEventData(id=" + this.id + ", conversationId=" + this.conversationId + ", botId=" + this.botId + ", role=" + this.role + ", type=" + this.type + ", content=" + this.content + ", sectionId=" + this.sectionId + ", required_action=" + this.required_action + ", suggest=" + this.suggest + ", reasoning_content=" + this.reasoning_content + ", meta_data=" + this.meta_data + ")";
    }
}
