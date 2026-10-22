package com.stepos.ailauncher.agent.aispace.market.data;

import com.autonavi.aps.amapapi.config.Const;
import com.google.gson.annotations.SerializedName;
import com.stepos.aiengine.args.QueryAlgorithmBundle;
import com.stepos.ailauncher.taskstore.provider.c;
import com.stepos.widget.recipient.StepOSRecipientEmailHistory;
import io.requery.android.database.sqlite.SQLiteDatabase;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u001c\b\u0080\b\u0018\u00002\u00020\u0001Bõ\u0001\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u0010\r\u001a\u00020\f\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0010\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0010\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0010\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0010\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u001c\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u001e\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u001e\u0010\u001fJ\u001a\u0010\"\u001a\u00020!2\b\u0010 \u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\"\u0010#R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010$\u001a\u0004\b%\u0010\u001dR\u001a\u0010\u0004\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0004\u0010$\u001a\u0004\b&\u0010\u001dR\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0005\u0010$\u001a\u0004\b'\u0010\u001dR\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0006\u0010$\u001a\u0004\b(\u0010\u001dR\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010$\u001a\u0004\b)\u0010\u001dR\u001c\u0010\b\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010$\u001a\u0004\b*\u0010\u001dR\u001c\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010$\u001a\u0004\b+\u0010\u001dR\u001c\u0010\n\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010$\u001a\u0004\b,\u0010\u001dR\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010$\u001a\u0004\b-\u0010\u001dR\u001a\u0010\r\u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010.\u001a\u0004\b/\u00100R\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010$\u001a\u0004\b1\u0010\u001dR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010$\u001a\u0004\b2\u0010\u001dR\u001a\u0010\u0011\u001a\u00020\u00108\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u00103\u001a\u0004\b4\u0010\u001fR\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010$\u001a\u0004\b5\u0010\u001dR\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010$\u001a\u0004\b6\u0010\u001dR\u001a\u0010\u0014\u001a\u00020\u00108\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0014\u00103\u001a\u0004\b7\u0010\u001fR\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0015\u0010$\u001a\u0004\b8\u0010\u001dR\u001a\u0010\u0016\u001a\u00020\u00108\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0016\u00103\u001a\u0004\b9\u0010\u001fR\u001a\u0010\u0017\u001a\u00020\u00108\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0017\u00103\u001a\u0004\b:\u0010\u001fR\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0018\u0010$\u001a\u0004\b;\u0010\u001dR\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0019\u0010$\u001a\u0004\b<\u0010\u001d¨\u0006="}, d2 = {"Lcom/stepos/ailauncher/agent/aispace/market/data/b;", "", "", "id", "agentId", "name", "version", "reversionId", "displayName", "description", "developer", QueryAlgorithmBundle.KEY_CATEGORY, "", "downloadCount", "readmeMd", "memoryMd", "", "status", "createdAt", "updatedAt", "installStatus", "installVersion", "needUpdate", x5.d.EXTRA_ENABLED, "icon", "env", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;ILjava/lang/String;IILjava/lang/String;Ljava/lang/String;)V", "toString", "()Ljava/lang/String;", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getId", Const.INTENT_KEY_APIKEY, "m", "r", "p", "f", Const.INTENT_KEY_UMID, "e", Const.INTENT_KEY_PKGNAME, "J", Const.INTENT_KEY_BACKGROUND_COMMAND, "()J", "o", "getMemoryMd", "I", "getStatus", "c", "q", "k", "l", "n", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "agent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.ailauncher.agent.aispace.market.data.b, reason: case insensitive filesystem and from toString */
/* loaded from: classes3.dex */
public final /* data */ class AgentMarketItemDto {

    @SerializedName(alternate = {"agent_id"}, value = "agentId")
    private final String agentId;

    @SerializedName(QueryAlgorithmBundle.KEY_CATEGORY)
    private final String category;

    @SerializedName(alternate = {c.a.COL_CREATED_AT}, value = "createdAt")
    private final String createdAt;

    @SerializedName("description")
    private final String description;

    @SerializedName("developer")
    private final String developer;

    @SerializedName(alternate = {StepOSRecipientEmailHistory.DISPLAY_NAME}, value = "displayName")
    private final String displayName;

    @SerializedName(alternate = {"download_count"}, value = "downloadCount")
    private final long downloadCount;

    @SerializedName(x5.d.EXTRA_ENABLED)
    private final int enabled;

    @SerializedName("env")
    private final String env;

    @SerializedName(alternate = {"iconUrl", "icon_url"}, value = "icon")
    private final String icon;

    @SerializedName("id")
    private final String id;

    @SerializedName(alternate = {"install_status"}, value = "installStatus")
    private final int installStatus;

    @SerializedName(alternate = {"install_version"}, value = "installVersion")
    private final String installVersion;

    @SerializedName(alternate = {"memory_md"}, value = "memoryMd")
    private final String memoryMd;

    @SerializedName("name")
    private final String name;

    @SerializedName(alternate = {"need_update"}, value = "needUpdate")
    private final int needUpdate;

    @SerializedName(alternate = {"readme_md"}, value = "readmeMd")
    private final String readmeMd;

    @SerializedName(alternate = {"reversion_id"}, value = "reversionId")
    private final String reversionId;

    @SerializedName("status")
    private final int status;

    @SerializedName(alternate = {c.a.COL_UPDATED_AT}, value = "updatedAt")
    private final String updatedAt;

    @SerializedName("version")
    private final String version;

    public AgentMarketItemDto() {
        this(null, null, null, null, null, null, null, null, null, 0L, null, null, 0, null, null, 0, null, 0, 0, null, null, 2097151, null);
    }

    /* renamed from: a, reason: from getter */
    public final String getAgentId() {
        return this.agentId;
    }

    /* renamed from: b, reason: from getter */
    public final String getCategory() {
        return this.category;
    }

    /* renamed from: c, reason: from getter */
    public final String getCreatedAt() {
        return this.createdAt;
    }

    /* renamed from: d, reason: from getter */
    public final String getDescription() {
        return this.description;
    }

    /* renamed from: e, reason: from getter */
    public final String getDeveloper() {
        return this.developer;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AgentMarketItemDto)) {
            return false;
        }
        AgentMarketItemDto agentMarketItemDto = (AgentMarketItemDto) other;
        return kotlin.jvm.internal.p.d(this.id, agentMarketItemDto.id) && kotlin.jvm.internal.p.d(this.agentId, agentMarketItemDto.agentId) && kotlin.jvm.internal.p.d(this.name, agentMarketItemDto.name) && kotlin.jvm.internal.p.d(this.version, agentMarketItemDto.version) && kotlin.jvm.internal.p.d(this.reversionId, agentMarketItemDto.reversionId) && kotlin.jvm.internal.p.d(this.displayName, agentMarketItemDto.displayName) && kotlin.jvm.internal.p.d(this.description, agentMarketItemDto.description) && kotlin.jvm.internal.p.d(this.developer, agentMarketItemDto.developer) && kotlin.jvm.internal.p.d(this.category, agentMarketItemDto.category) && this.downloadCount == agentMarketItemDto.downloadCount && kotlin.jvm.internal.p.d(this.readmeMd, agentMarketItemDto.readmeMd) && kotlin.jvm.internal.p.d(this.memoryMd, agentMarketItemDto.memoryMd) && this.status == agentMarketItemDto.status && kotlin.jvm.internal.p.d(this.createdAt, agentMarketItemDto.createdAt) && kotlin.jvm.internal.p.d(this.updatedAt, agentMarketItemDto.updatedAt) && this.installStatus == agentMarketItemDto.installStatus && kotlin.jvm.internal.p.d(this.installVersion, agentMarketItemDto.installVersion) && this.needUpdate == agentMarketItemDto.needUpdate && this.enabled == agentMarketItemDto.enabled && kotlin.jvm.internal.p.d(this.icon, agentMarketItemDto.icon) && kotlin.jvm.internal.p.d(this.env, agentMarketItemDto.env);
    }

    /* renamed from: f, reason: from getter */
    public final String getDisplayName() {
        return this.displayName;
    }

    /* renamed from: g, reason: from getter */
    public final long getDownloadCount() {
        return this.downloadCount;
    }

    /* renamed from: h, reason: from getter */
    public final int getEnabled() {
        return this.enabled;
    }

    public int hashCode() {
        int iHashCode = ((this.id.hashCode() * 31) + this.agentId.hashCode()) * 31;
        String str = this.name;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.version;
        int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.reversionId;
        int iHashCode4 = (iHashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.displayName;
        int iHashCode5 = (iHashCode4 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.description;
        int iHashCode6 = (iHashCode5 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.developer;
        int iHashCode7 = (iHashCode6 + (str6 == null ? 0 : str6.hashCode())) * 31;
        String str7 = this.category;
        int iHashCode8 = (((iHashCode7 + (str7 == null ? 0 : str7.hashCode())) * 31) + Long.hashCode(this.downloadCount)) * 31;
        String str8 = this.readmeMd;
        int iHashCode9 = (iHashCode8 + (str8 == null ? 0 : str8.hashCode())) * 31;
        String str9 = this.memoryMd;
        int iHashCode10 = (((iHashCode9 + (str9 == null ? 0 : str9.hashCode())) * 31) + Integer.hashCode(this.status)) * 31;
        String str10 = this.createdAt;
        int iHashCode11 = (iHashCode10 + (str10 == null ? 0 : str10.hashCode())) * 31;
        String str11 = this.updatedAt;
        int iHashCode12 = (((iHashCode11 + (str11 == null ? 0 : str11.hashCode())) * 31) + Integer.hashCode(this.installStatus)) * 31;
        String str12 = this.installVersion;
        int iHashCode13 = (((((iHashCode12 + (str12 == null ? 0 : str12.hashCode())) * 31) + Integer.hashCode(this.needUpdate)) * 31) + Integer.hashCode(this.enabled)) * 31;
        String str13 = this.icon;
        int iHashCode14 = (iHashCode13 + (str13 == null ? 0 : str13.hashCode())) * 31;
        String str14 = this.env;
        return iHashCode14 + (str14 != null ? str14.hashCode() : 0);
    }

    /* renamed from: i, reason: from getter */
    public final String getEnv() {
        return this.env;
    }

    /* renamed from: j, reason: from getter */
    public final String getIcon() {
        return this.icon;
    }

    /* renamed from: k, reason: from getter */
    public final int getInstallStatus() {
        return this.installStatus;
    }

    /* renamed from: l, reason: from getter */
    public final String getInstallVersion() {
        return this.installVersion;
    }

    /* renamed from: m, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* renamed from: n, reason: from getter */
    public final int getNeedUpdate() {
        return this.needUpdate;
    }

    /* renamed from: o, reason: from getter */
    public final String getReadmeMd() {
        return this.readmeMd;
    }

    /* renamed from: p, reason: from getter */
    public final String getReversionId() {
        return this.reversionId;
    }

    /* renamed from: q, reason: from getter */
    public final String getUpdatedAt() {
        return this.updatedAt;
    }

    /* renamed from: r, reason: from getter */
    public final String getVersion() {
        return this.version;
    }

    public String toString() {
        return "AgentMarketItemDto(id=" + this.id + ", agentId=" + this.agentId + ", name=" + this.name + ", version=" + this.version + ", reversionId=" + this.reversionId + ", displayName=" + this.displayName + ", description=" + this.description + ", developer=" + this.developer + ", category=" + this.category + ", downloadCount=" + this.downloadCount + ", readmeMd=" + this.readmeMd + ", memoryMd=" + this.memoryMd + ", status=" + this.status + ", createdAt=" + this.createdAt + ", updatedAt=" + this.updatedAt + ", installStatus=" + this.installStatus + ", installVersion=" + this.installVersion + ", needUpdate=" + this.needUpdate + ", enabled=" + this.enabled + ", icon=" + this.icon + ", env=" + this.env + ")";
    }

    public AgentMarketItemDto(String id, String agentId, String str, String str2, String str3, String str4, String str5, String str6, String str7, long j10, String str8, String str9, int i10, String str10, String str11, int i11, String str12, int i12, int i13, String str13, String str14) {
        kotlin.jvm.internal.p.i(id, "id");
        kotlin.jvm.internal.p.i(agentId, "agentId");
        this.id = id;
        this.agentId = agentId;
        this.name = str;
        this.version = str2;
        this.reversionId = str3;
        this.displayName = str4;
        this.description = str5;
        this.developer = str6;
        this.category = str7;
        this.downloadCount = j10;
        this.readmeMd = str8;
        this.memoryMd = str9;
        this.status = i10;
        this.createdAt = str10;
        this.updatedAt = str11;
        this.installStatus = i11;
        this.installVersion = str12;
        this.needUpdate = i12;
        this.enabled = i13;
        this.icon = str13;
        this.env = str14;
    }

    public /* synthetic */ AgentMarketItemDto(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, long j10, String str10, String str11, int i10, String str12, String str13, int i11, String str14, int i12, int i13, String str15, String str16, int i14, kotlin.jvm.internal.i iVar) {
        this((i14 & 1) != 0 ? "" : str, (i14 & 2) == 0 ? str2 : "", (i14 & 4) != 0 ? null : str3, (i14 & 8) != 0 ? null : str4, (i14 & 16) != 0 ? null : str5, (i14 & 32) != 0 ? null : str6, (i14 & 64) != 0 ? null : str7, (i14 & 128) != 0 ? null : str8, (i14 & 256) != 0 ? null : str9, (i14 & 512) != 0 ? 0L : j10, (i14 & 1024) != 0 ? null : str10, (i14 & 2048) != 0 ? null : str11, (i14 & 4096) != 0 ? 0 : i10, (i14 & com.stepos.agentframework.chatui.longtext.b.THRESHOLD) != 0 ? null : str12, (i14 & 16384) != 0 ? null : str13, (i14 & 32768) != 0 ? 0 : i11, (i14 & 65536) != 0 ? null : str14, (i14 & SQLiteDatabase.OPEN_SHAREDCACHE) != 0 ? 0 : i12, (i14 & SQLiteDatabase.OPEN_PRIVATECACHE) == 0 ? i13 : 0, (i14 & 524288) != 0 ? null : str15, (i14 & 1048576) != 0 ? null : str16);
    }
}
