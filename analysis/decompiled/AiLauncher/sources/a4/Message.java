package a4;

import Z8.C1173v;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.agentbus.generated.Role;
import com.stepos.ame.sdk.SkillStoreKt;
import com.stepos.core.ability.converter.BundleContentBridge;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0011\b\u0086\b\u0018\u00002\u00020\u0001Bg\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u0006\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0004\u0012\u0016\b\u0002\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00010\f\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0014\u001a\u00020\u0013HÖ\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u001a\u0010\u0018\u001a\u00020\u00172\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0018\u0010\u0019R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b\u001e\u0010\u0012R\u001d\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0006¢\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\u001a\u0010\"R\u001d\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u00068\u0006¢\u0006\f\n\u0004\b#\u0010!\u001a\u0004\b$\u0010\"R\u0019\u0010\u000b\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b%\u0010\u001f\u001a\u0004\b%\u0010\u0012R%\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00010\f8\u0006¢\u0006\f\n\u0004\b\u001c\u0010&\u001a\u0004\b#\u0010'R\u0019\u0010\u000e\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b$\u0010\u001f\u001a\u0004\b \u0010\u0012¨\u0006("}, d2 = {"La4/w;", "", "Lcom/stepos/agentbus/generated/Role;", BundleContentBridge.KEY_ROLE, "", SkillStoreKt.SKILL_DOC_TYPE_CONTENT, "", "La4/l;", "attachments", "La4/E;", "toolCalls", "replyTo", "", "metadata", "delta", "<init>", "(Lcom/stepos/agentbus/generated/Role;Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/lang/String;Ljava/util/Map;Ljava/lang/String;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", Const.INTENT_KEY_APIKEY, "Lcom/stepos/agentbus/generated/Role;", "f", "()Lcom/stepos/agentbus/generated/Role;", Const.INTENT_KEY_PKGNAME, "Ljava/lang/String;", "c", "Ljava/util/List;", "()Ljava/util/List;", Const.INTENT_KEY_UMID, Const.INTENT_KEY_BACKGROUND_COMMAND, "e", "Ljava/util/Map;", "()Ljava/util/Map;", "protocol_agentbus_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: a4.w, reason: from toString */
/* loaded from: classes2.dex */
public final /* data */ class Message {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    public final Role role;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    public final String content;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    public final List<Attachment> attachments;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    public final List<ToolCall> toolCalls;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    public final String replyTo;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
    public final Map<String, Object> metadata;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata and from toString */
    public final String delta;

    public Message(Role role, String content, List<Attachment> attachments, List<ToolCall> toolCalls, String str, Map<String, ? extends Object> metadata, String str2) {
        kotlin.jvm.internal.p.i(role, "role");
        kotlin.jvm.internal.p.i(content, "content");
        kotlin.jvm.internal.p.i(attachments, "attachments");
        kotlin.jvm.internal.p.i(toolCalls, "toolCalls");
        kotlin.jvm.internal.p.i(metadata, "metadata");
        this.role = role;
        this.content = content;
        this.attachments = attachments;
        this.toolCalls = toolCalls;
        this.replyTo = str;
        this.metadata = metadata;
        this.delta = str2;
    }

    public final List<Attachment> a() {
        return this.attachments;
    }

    /* renamed from: b, reason: from getter */
    public final String getContent() {
        return this.content;
    }

    /* renamed from: c, reason: from getter */
    public final String getDelta() {
        return this.delta;
    }

    public final Map<String, Object> d() {
        return this.metadata;
    }

    /* renamed from: e, reason: from getter */
    public final String getReplyTo() {
        return this.replyTo;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Message)) {
            return false;
        }
        Message message = (Message) other;
        return this.role == message.role && kotlin.jvm.internal.p.d(this.content, message.content) && kotlin.jvm.internal.p.d(this.attachments, message.attachments) && kotlin.jvm.internal.p.d(this.toolCalls, message.toolCalls) && kotlin.jvm.internal.p.d(this.replyTo, message.replyTo) && kotlin.jvm.internal.p.d(this.metadata, message.metadata) && kotlin.jvm.internal.p.d(this.delta, message.delta);
    }

    /* renamed from: f, reason: from getter */
    public final Role getRole() {
        return this.role;
    }

    public final List<ToolCall> g() {
        return this.toolCalls;
    }

    public int hashCode() {
        int iHashCode = ((((((this.role.hashCode() * 31) + this.content.hashCode()) * 31) + this.attachments.hashCode()) * 31) + this.toolCalls.hashCode()) * 31;
        String str = this.replyTo;
        int iHashCode2 = (((iHashCode + (str == null ? 0 : str.hashCode())) * 31) + this.metadata.hashCode()) * 31;
        String str2 = this.delta;
        return iHashCode2 + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        return "Message(role=" + this.role + ", content=" + this.content + ", attachments=" + this.attachments + ", toolCalls=" + this.toolCalls + ", replyTo=" + this.replyTo + ", metadata=" + this.metadata + ", delta=" + this.delta + ")";
    }

    public /* synthetic */ Message(Role role, String str, List list, List list2, String str2, Map map, String str3, int i10, kotlin.jvm.internal.i iVar) {
        this(role, str, (i10 & 4) != 0 ? C1173v.m() : list, (i10 & 8) != 0 ? C1173v.m() : list2, (i10 & 16) != 0 ? null : str2, (i10 & 32) != 0 ? kotlin.collections.a.i() : map, (i10 & 64) != 0 ? null : str3);
    }
}
