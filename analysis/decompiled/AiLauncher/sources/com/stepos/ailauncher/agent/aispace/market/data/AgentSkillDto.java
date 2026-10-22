package com.stepos.ailauncher.agent.aispace.market.data;

import com.autonavi.aps.amapapi.config.Const;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u000e\b\u0080\b\u0018\u00002\u00020\u0001Bk\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u000f\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u001a\u0010\u0015\u001a\u00020\u00142\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0017\u001a\u0004\b\u0018\u0010\u0010R\u001a\u0010\u0004\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0017\u001a\u0004\b\u0019\u0010\u0010R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u0017\u001a\u0004\b\u001a\u0010\u0010R\u001a\u0010\u0006\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0006\u0010\u0017\u001a\u0004\b\u001b\u0010\u0010R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0017\u001a\u0004\b\u001c\u0010\u0010R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\u0017\u001a\u0004\b\u001d\u0010\u0010R\u001c\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0017\u001a\u0004\b\u001e\u0010\u0010R\u001c\u0010\n\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u0017\u001a\u0004\b\u001f\u0010\u0010R\u001a\u0010\f\u001a\u00020\u000b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010 \u001a\u0004\b!\u0010\u0012¨\u0006\""}, d2 = {"Lcom/stepos/ailauncher/agent/aispace/market/data/f;", "", "", "id", "agentId", "agentVersion", "skillId", "skillName", "skillDescription", "skillVersion", "skillMd", "", "status", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V", "toString", "()Ljava/lang/String;", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getId", Const.INTENT_KEY_APIKEY, "getAgentVersion", "c", "e", Const.INTENT_KEY_PKGNAME, "getSkillVersion", Const.INTENT_KEY_UMID, "I", "getStatus", "agent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.ailauncher.agent.aispace.market.data.f, reason: from toString */
/* loaded from: classes3.dex */
public final /* data */ class AgentSkillDto {

    @SerializedName(alternate = {"agent_id"}, value = "agentId")
    private final String agentId;

    @SerializedName(alternate = {"agent_version"}, value = "agentVersion")
    private final String agentVersion;

    @SerializedName("id")
    private final String id;

    @SerializedName(alternate = {"skill_description"}, value = "skillDescription")
    private final String skillDescription;

    @SerializedName(alternate = {"skill_id"}, value = "skillId")
    private final String skillId;

    @SerializedName(alternate = {"skill_md"}, value = "skillMd")
    private final String skillMd;

    @SerializedName(alternate = {"skill_name"}, value = "skillName")
    private final String skillName;

    @SerializedName(alternate = {"skill_version"}, value = "skillVersion")
    private final String skillVersion;

    @SerializedName("status")
    private final int status;

    public AgentSkillDto() {
        this(null, null, null, null, null, null, null, null, 0, 511, null);
    }

    /* renamed from: a, reason: from getter */
    public final String getAgentId() {
        return this.agentId;
    }

    /* renamed from: b, reason: from getter */
    public final String getSkillDescription() {
        return this.skillDescription;
    }

    /* renamed from: c, reason: from getter */
    public final String getSkillId() {
        return this.skillId;
    }

    /* renamed from: d, reason: from getter */
    public final String getSkillMd() {
        return this.skillMd;
    }

    /* renamed from: e, reason: from getter */
    public final String getSkillName() {
        return this.skillName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AgentSkillDto)) {
            return false;
        }
        AgentSkillDto agentSkillDto = (AgentSkillDto) other;
        return kotlin.jvm.internal.p.d(this.id, agentSkillDto.id) && kotlin.jvm.internal.p.d(this.agentId, agentSkillDto.agentId) && kotlin.jvm.internal.p.d(this.agentVersion, agentSkillDto.agentVersion) && kotlin.jvm.internal.p.d(this.skillId, agentSkillDto.skillId) && kotlin.jvm.internal.p.d(this.skillName, agentSkillDto.skillName) && kotlin.jvm.internal.p.d(this.skillDescription, agentSkillDto.skillDescription) && kotlin.jvm.internal.p.d(this.skillVersion, agentSkillDto.skillVersion) && kotlin.jvm.internal.p.d(this.skillMd, agentSkillDto.skillMd) && this.status == agentSkillDto.status;
    }

    public int hashCode() {
        int iHashCode = ((this.id.hashCode() * 31) + this.agentId.hashCode()) * 31;
        String str = this.agentVersion;
        int iHashCode2 = (((iHashCode + (str == null ? 0 : str.hashCode())) * 31) + this.skillId.hashCode()) * 31;
        String str2 = this.skillName;
        int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.skillDescription;
        int iHashCode4 = (iHashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.skillVersion;
        int iHashCode5 = (iHashCode4 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.skillMd;
        return ((iHashCode5 + (str5 != null ? str5.hashCode() : 0)) * 31) + Integer.hashCode(this.status);
    }

    public String toString() {
        return "AgentSkillDto(id=" + this.id + ", agentId=" + this.agentId + ", agentVersion=" + this.agentVersion + ", skillId=" + this.skillId + ", skillName=" + this.skillName + ", skillDescription=" + this.skillDescription + ", skillVersion=" + this.skillVersion + ", skillMd=" + this.skillMd + ", status=" + this.status + ")";
    }

    public AgentSkillDto(String id, String agentId, String str, String skillId, String str2, String str3, String str4, String str5, int i10) {
        kotlin.jvm.internal.p.i(id, "id");
        kotlin.jvm.internal.p.i(agentId, "agentId");
        kotlin.jvm.internal.p.i(skillId, "skillId");
        this.id = id;
        this.agentId = agentId;
        this.agentVersion = str;
        this.skillId = skillId;
        this.skillName = str2;
        this.skillDescription = str3;
        this.skillVersion = str4;
        this.skillMd = str5;
        this.status = i10;
    }

    public /* synthetic */ AgentSkillDto(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, int i10, int i11, kotlin.jvm.internal.i iVar) {
        this((i11 & 1) != 0 ? "" : str, (i11 & 2) != 0 ? "" : str2, (i11 & 4) != 0 ? null : str3, (i11 & 8) != 0 ? "" : str4, (i11 & 16) != 0 ? null : str5, (i11 & 32) != 0 ? null : str6, (i11 & 64) != 0 ? null : str7, (i11 & 128) != 0 ? null : str8, (i11 & 256) != 0 ? 0 : i10);
    }
}
