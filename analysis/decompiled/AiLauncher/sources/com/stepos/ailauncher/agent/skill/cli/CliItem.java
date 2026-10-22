package com.stepos.ailauncher.agent.skill.cli;

import com.autonavi.aps.amapapi.config.Const;
import com.google.gson.annotations.SerializedName;
import com.stepos.ailauncher.agent.skill.SkillStatus;
import com.stepos.widget.recipient.StepOSRecipientEmailHistory;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\u000b\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\bHÖ\u0003¢\u0006\u0004\b\u000b\u0010\fR\u0017\u0010\r\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0004R\u0017\u0010\u0010\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u000e\u001a\u0004\b\u0011\u0010\u0004R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u000e\u001a\u0004\b\u0013\u0010\u0004R\u0017\u0010\u0014\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u000e\u001a\u0004\b\u0015\u0010\u0004R\u001a\u0010\u0017\u001a\u00020\u00168\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u001c\u0010\u001b\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001b\u0010\u000e\u001a\u0004\b\u001c\u0010\u0004R\u0019\u0010\u001e\u001a\u0004\u0018\u00010\u001d8\u0006¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!¨\u0006\""}, d2 = {"Lcom/stepos/ailauncher/agent/skill/cli/CliItem;", "Ljava/io/Serializable;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "id", "Ljava/lang/String;", "e", "name", "getName", "displayName", Const.INTENT_KEY_PKGNAME, "description", Const.INTENT_KEY_APIKEY, "", "downloadCount", "J", "c", "()J", "icon", Const.INTENT_KEY_UMID, "Lcom/stepos/ailauncher/agent/skill/SkillStatus;", "status", "Lcom/stepos/ailauncher/agent/skill/SkillStatus;", "f", "()Lcom/stepos/ailauncher/agent/skill/SkillStatus;", "agent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class CliItem implements Serializable {
    private final String description;

    @SerializedName(alternate = {"displayName"}, value = StepOSRecipientEmailHistory.DISPLAY_NAME)
    private final String displayName;

    @SerializedName(alternate = {"downloadCount"}, value = "download_count")
    private final long downloadCount;

    @SerializedName(alternate = {"iconUrl", "icon_url"}, value = "icon")
    private final String icon;
    private final String id;
    private final String name;
    private final SkillStatus status;

    /* renamed from: a, reason: from getter */
    public final String getDescription() {
        return this.description;
    }

    /* renamed from: b, reason: from getter */
    public final String getDisplayName() {
        return this.displayName;
    }

    /* renamed from: c, reason: from getter */
    public final long getDownloadCount() {
        return this.downloadCount;
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
        if (!(other instanceof CliItem)) {
            return false;
        }
        CliItem cliItem = (CliItem) other;
        return p.d(this.id, cliItem.id) && p.d(this.name, cliItem.name) && p.d(this.displayName, cliItem.displayName) && p.d(this.description, cliItem.description) && this.downloadCount == cliItem.downloadCount && p.d(this.icon, cliItem.icon) && this.status == cliItem.status;
    }

    /* renamed from: f, reason: from getter */
    public final SkillStatus getStatus() {
        return this.status;
    }

    public final String getName() {
        return this.name;
    }

    public int hashCode() {
        int iHashCode = ((this.id.hashCode() * 31) + this.name.hashCode()) * 31;
        String str = this.displayName;
        int iHashCode2 = (((((iHashCode + (str == null ? 0 : str.hashCode())) * 31) + this.description.hashCode()) * 31) + Long.hashCode(this.downloadCount)) * 31;
        String str2 = this.icon;
        int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        SkillStatus skillStatus = this.status;
        return iHashCode3 + (skillStatus != null ? skillStatus.hashCode() : 0);
    }

    public String toString() {
        return "CliItem(id=" + this.id + ", name=" + this.name + ", displayName=" + this.displayName + ", description=" + this.description + ", downloadCount=" + this.downloadCount + ", icon=" + this.icon + ", status=" + this.status + ")";
    }
}
