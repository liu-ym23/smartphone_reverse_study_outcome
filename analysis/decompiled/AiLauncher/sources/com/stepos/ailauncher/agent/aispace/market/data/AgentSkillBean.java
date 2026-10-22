package com.stepos.ailauncher.agent.aispace.market.data;

import com.autonavi.aps.amapapi.config.Const;
import com.google.gson.annotations.SerializedName;
import com.stepos.aiengine.args.QueryAlgorithmBundle;
import com.stepos.ailauncher.chat.trace.ChatTracker;
import com.stepos.ailauncher.contract.api.homegesture.HomeGestureEligibilityContract;
import com.stepos.ailauncher.taskstore.provider.c;
import com.stepos.widget.recipient.StepOSRecipientEmailHistory;
import io.requery.android.database.sqlite.SQLiteDatabase;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0017\n\u0002\u0010\u000b\n\u0002\b\u001c\b\u0080\b\u0018\u00002\u00020\u0001Bñ\u0001\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0002\u0012\b\b\u0002\u0010\b\u001a\u00020\u0002\u0012\b\b\u0002\u0010\t\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u000b\u001a\u00020\n\u0012\b\b\u0002\u0010\f\u001a\u00020\n\u0012\b\b\u0002\u0010\r\u001a\u00020\n\u0012\b\b\u0002\u0010\u000e\u001a\u00020\n\u0012\b\b\u0002\u0010\u000f\u001a\u00020\n\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0013\u001a\u00020\n\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0018\u001a\u00020\n\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u001d\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u001d\u0010\u001eJ\u0010\u0010\u001f\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u001f\u0010 J\u001a\u0010#\u001a\u00020\"2\b\u0010!\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b#\u0010$R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010%\u001a\u0004\b&\u0010\u001eR\u001a\u0010\u0004\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0004\u0010%\u001a\u0004\b'\u0010\u001eR\u001a\u0010\u0005\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0005\u0010%\u001a\u0004\b(\u0010\u001eR\u001a\u0010\u0006\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0006\u0010%\u001a\u0004\b)\u0010\u001eR\u001a\u0010\u0007\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010%\u001a\u0004\b*\u0010\u001eR\u001a\u0010\b\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010%\u001a\u0004\b+\u0010\u001eR\u001a\u0010\t\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010%\u001a\u0004\b,\u0010\u001eR\u001a\u0010\u000b\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010-\u001a\u0004\b.\u0010 R\u001a\u0010\f\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010-\u001a\u0004\b/\u0010 R\u001a\u0010\r\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010-\u001a\u0004\b0\u0010 R\u001a\u0010\u000e\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010-\u001a\u0004\b1\u0010 R\u001a\u0010\u000f\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010-\u001a\u0004\b2\u0010 R\u001a\u0010\u0010\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010%\u001a\u0004\b3\u0010\u001eR\u001a\u0010\u0011\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010%\u001a\u0004\b4\u0010\u001eR\u001a\u0010\u0012\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010%\u001a\u0004\b5\u0010\u001eR\u001a\u0010\u0013\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010-\u001a\u0004\b6\u0010 R\u001a\u0010\u0014\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0014\u0010%\u001a\u0004\b7\u0010\u001eR\u001a\u0010\u0015\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0015\u0010%\u001a\u0004\b8\u0010\u001eR\u001a\u0010\u0016\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0016\u0010%\u001a\u0004\b9\u0010\u001eR\u001a\u0010\u0017\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0017\u0010%\u001a\u0004\b:\u0010\u001eR\u001a\u0010\u0018\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0018\u0010-\u001a\u0004\b;\u0010 R\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0019\u0010%\u001a\u0004\b<\u0010\u001eR\u001c\u0010\u001a\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001a\u0010%\u001a\u0004\b=\u0010\u001e¨\u0006>"}, d2 = {"Lcom/stepos/ailauncher/agent/aispace/market/data/e;", "", "", "id", "name", "version", "displayName", "description", QueryAlgorithmBundle.KEY_CATEGORY, "developer", "", "downloadCount", HomeGestureEligibilityContract.EXTRA_SCENE, "necessary", ChatTracker.RETRY_RELOAD, "fromSource", "packageUrl", "createdAt", "updatedAt", "installStatus", "skillMd", "status", "source", "installVersion", "needUpdate", "icon", "env", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IIIIILjava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V", "toString", "()Ljava/lang/String;", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "e", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "k", Const.INTENT_KEY_PKGNAME, Const.INTENT_KEY_APIKEY, "getCategory", "getDeveloper", "I", "getDownloadCount", "getScene", "getNecessary", "getReload", "getFromSource", "getPackageUrl", "getCreatedAt", "getUpdatedAt", "f", "getSkillMd", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "getSource", Const.INTENT_KEY_BACKGROUND_COMMAND, Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, Const.INTENT_KEY_UMID, "c", "agent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.ailauncher.agent.aispace.market.data.e, reason: from toString */
/* loaded from: classes3.dex */
public final /* data */ class AgentSkillBean {

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
    private final int downloadCount;

    @SerializedName("env")
    private final String env;

    @SerializedName(alternate = {"from_source"}, value = "fromSource")
    private final int fromSource;

    @SerializedName(alternate = {"iconUrl", "icon_url"}, value = "icon")
    private final String icon;

    @SerializedName("id")
    private final String id;

    @SerializedName(alternate = {"install_status"}, value = "installStatus")
    private final int installStatus;

    @SerializedName(alternate = {"install_version"}, value = "installVersion")
    private final String installVersion;

    @SerializedName("name")
    private final String name;

    @SerializedName("necessary")
    private final int necessary;

    @SerializedName(alternate = {"need_update"}, value = "needUpdate")
    private final int needUpdate;

    @SerializedName(alternate = {"package_url"}, value = "packageUrl")
    private final String packageUrl;

    @SerializedName(ChatTracker.RETRY_RELOAD)
    private final int reload;

    @SerializedName(HomeGestureEligibilityContract.EXTRA_SCENE)
    private final int scene;

    @SerializedName(alternate = {"skill_md"}, value = "skillMd")
    private final String skillMd;

    @SerializedName("source")
    private final String source;

    @SerializedName("status")
    private final String status;

    @SerializedName(alternate = {c.a.COL_UPDATED_AT}, value = "updatedAt")
    private final String updatedAt;

    @SerializedName("version")
    private final String version;

    public AgentSkillBean() {
        this(null, null, null, null, null, null, null, 0, 0, 0, 0, 0, null, null, null, 0, null, null, null, null, 0, null, null, 8388607, null);
    }

    /* renamed from: a, reason: from getter */
    public final String getDescription() {
        return this.description;
    }

    /* renamed from: b, reason: from getter */
    public final String getDisplayName() {
        return this.displayName;
    }

    /* renamed from: c, reason: from getter */
    public final String getEnv() {
        return this.env;
    }

    /* renamed from: d, reason: from getter */
    public final String getIcon() {
        return this.icon;
    }

    /* renamed from: e, reason: from getter */
    public final String getId() {
        return this.id;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AgentSkillBean)) {
            return false;
        }
        AgentSkillBean agentSkillBean = (AgentSkillBean) other;
        return kotlin.jvm.internal.p.d(this.id, agentSkillBean.id) && kotlin.jvm.internal.p.d(this.name, agentSkillBean.name) && kotlin.jvm.internal.p.d(this.version, agentSkillBean.version) && kotlin.jvm.internal.p.d(this.displayName, agentSkillBean.displayName) && kotlin.jvm.internal.p.d(this.description, agentSkillBean.description) && kotlin.jvm.internal.p.d(this.category, agentSkillBean.category) && kotlin.jvm.internal.p.d(this.developer, agentSkillBean.developer) && this.downloadCount == agentSkillBean.downloadCount && this.scene == agentSkillBean.scene && this.necessary == agentSkillBean.necessary && this.reload == agentSkillBean.reload && this.fromSource == agentSkillBean.fromSource && kotlin.jvm.internal.p.d(this.packageUrl, agentSkillBean.packageUrl) && kotlin.jvm.internal.p.d(this.createdAt, agentSkillBean.createdAt) && kotlin.jvm.internal.p.d(this.updatedAt, agentSkillBean.updatedAt) && this.installStatus == agentSkillBean.installStatus && kotlin.jvm.internal.p.d(this.skillMd, agentSkillBean.skillMd) && kotlin.jvm.internal.p.d(this.status, agentSkillBean.status) && kotlin.jvm.internal.p.d(this.source, agentSkillBean.source) && kotlin.jvm.internal.p.d(this.installVersion, agentSkillBean.installVersion) && this.needUpdate == agentSkillBean.needUpdate && kotlin.jvm.internal.p.d(this.icon, agentSkillBean.icon) && kotlin.jvm.internal.p.d(this.env, agentSkillBean.env);
    }

    /* renamed from: f, reason: from getter */
    public final int getInstallStatus() {
        return this.installStatus;
    }

    /* renamed from: g, reason: from getter */
    public final String getInstallVersion() {
        return this.installVersion;
    }

    /* renamed from: h, reason: from getter */
    public final String getName() {
        return this.name;
    }

    public int hashCode() {
        int iHashCode = ((((((((((((((((((((((((((((((((((((((((this.id.hashCode() * 31) + this.name.hashCode()) * 31) + this.version.hashCode()) * 31) + this.displayName.hashCode()) * 31) + this.description.hashCode()) * 31) + this.category.hashCode()) * 31) + this.developer.hashCode()) * 31) + Integer.hashCode(this.downloadCount)) * 31) + Integer.hashCode(this.scene)) * 31) + Integer.hashCode(this.necessary)) * 31) + Integer.hashCode(this.reload)) * 31) + Integer.hashCode(this.fromSource)) * 31) + this.packageUrl.hashCode()) * 31) + this.createdAt.hashCode()) * 31) + this.updatedAt.hashCode()) * 31) + Integer.hashCode(this.installStatus)) * 31) + this.skillMd.hashCode()) * 31) + this.status.hashCode()) * 31) + this.source.hashCode()) * 31) + this.installVersion.hashCode()) * 31) + Integer.hashCode(this.needUpdate)) * 31;
        String str = this.icon;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.env;
        return iHashCode2 + (str2 != null ? str2.hashCode() : 0);
    }

    /* renamed from: i, reason: from getter */
    public final int getNeedUpdate() {
        return this.needUpdate;
    }

    /* renamed from: j, reason: from getter */
    public final String getStatus() {
        return this.status;
    }

    /* renamed from: k, reason: from getter */
    public final String getVersion() {
        return this.version;
    }

    public String toString() {
        return "AgentSkillBean(id=" + this.id + ", name=" + this.name + ", version=" + this.version + ", displayName=" + this.displayName + ", description=" + this.description + ", category=" + this.category + ", developer=" + this.developer + ", downloadCount=" + this.downloadCount + ", scene=" + this.scene + ", necessary=" + this.necessary + ", reload=" + this.reload + ", fromSource=" + this.fromSource + ", packageUrl=" + this.packageUrl + ", createdAt=" + this.createdAt + ", updatedAt=" + this.updatedAt + ", installStatus=" + this.installStatus + ", skillMd=" + this.skillMd + ", status=" + this.status + ", source=" + this.source + ", installVersion=" + this.installVersion + ", needUpdate=" + this.needUpdate + ", icon=" + this.icon + ", env=" + this.env + ")";
    }

    public AgentSkillBean(String id, String name, String version, String displayName, String description, String category, String developer, int i10, int i11, int i12, int i13, int i14, String packageUrl, String createdAt, String updatedAt, int i15, String skillMd, String status, String source, String installVersion, int i16, String str, String str2) {
        kotlin.jvm.internal.p.i(id, "id");
        kotlin.jvm.internal.p.i(name, "name");
        kotlin.jvm.internal.p.i(version, "version");
        kotlin.jvm.internal.p.i(displayName, "displayName");
        kotlin.jvm.internal.p.i(description, "description");
        kotlin.jvm.internal.p.i(category, "category");
        kotlin.jvm.internal.p.i(developer, "developer");
        kotlin.jvm.internal.p.i(packageUrl, "packageUrl");
        kotlin.jvm.internal.p.i(createdAt, "createdAt");
        kotlin.jvm.internal.p.i(updatedAt, "updatedAt");
        kotlin.jvm.internal.p.i(skillMd, "skillMd");
        kotlin.jvm.internal.p.i(status, "status");
        kotlin.jvm.internal.p.i(source, "source");
        kotlin.jvm.internal.p.i(installVersion, "installVersion");
        this.id = id;
        this.name = name;
        this.version = version;
        this.displayName = displayName;
        this.description = description;
        this.category = category;
        this.developer = developer;
        this.downloadCount = i10;
        this.scene = i11;
        this.necessary = i12;
        this.reload = i13;
        this.fromSource = i14;
        this.packageUrl = packageUrl;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.installStatus = i15;
        this.skillMd = skillMd;
        this.status = status;
        this.source = source;
        this.installVersion = installVersion;
        this.needUpdate = i16;
        this.icon = str;
        this.env = str2;
    }

    public /* synthetic */ AgentSkillBean(String str, String str2, String str3, String str4, String str5, String str6, String str7, int i10, int i11, int i12, int i13, int i14, String str8, String str9, String str10, int i15, String str11, String str12, String str13, String str14, int i16, String str15, String str16, int i17, kotlin.jvm.internal.i iVar) {
        this((i17 & 1) != 0 ? "" : str, (i17 & 2) != 0 ? "" : str2, (i17 & 4) != 0 ? "" : str3, (i17 & 8) != 0 ? "" : str4, (i17 & 16) != 0 ? "" : str5, (i17 & 32) != 0 ? "" : str6, (i17 & 64) != 0 ? "" : str7, (i17 & 128) != 0 ? 0 : i10, (i17 & 256) != 0 ? 0 : i11, (i17 & 512) != 0 ? 0 : i12, (i17 & 1024) != 0 ? 0 : i13, (i17 & 2048) != 0 ? 0 : i14, (i17 & 4096) != 0 ? "" : str8, (i17 & com.stepos.agentframework.chatui.longtext.b.THRESHOLD) != 0 ? "" : str9, (i17 & 16384) != 0 ? "" : str10, (i17 & 32768) != 0 ? 0 : i15, (i17 & 65536) != 0 ? "" : str11, (i17 & SQLiteDatabase.OPEN_SHAREDCACHE) != 0 ? "" : str12, (i17 & SQLiteDatabase.OPEN_PRIVATECACHE) != 0 ? "" : str13, (i17 & 524288) == 0 ? str14 : "", (i17 & 1048576) != 0 ? 0 : i16, (i17 & 2097152) != 0 ? null : str15, (i17 & 4194304) != 0 ? null : str16);
    }
}
