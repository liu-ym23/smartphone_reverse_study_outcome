package com.stepos.ailauncher.agent.skill.detail;

import com.autonavi.aps.amapapi.config.Const;
import com.google.gson.annotations.SerializedName;
import com.stepos.aiengine.args.QueryAlgorithmBundle;
import com.stepos.ailauncher.agent.skill.SkillStatus;
import com.stepos.ailauncher.chat.trace.ChatTracker;
import com.stepos.ailauncher.contract.api.homegesture.HomeGestureEligibilityContract;
import io.requery.android.database.sqlite.SQLiteDatabase;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b$\b\u0080\b\u0018\u00002\u00020\u0001Bý\u0001\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\n\u0012\b\u0010\r\u001a\u0004\u0018\u00010\f\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\f\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\f\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\f\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\f\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u0010\u0017\u001a\u00020\f\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0002\u0012\u0010\b\u0002\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u001a\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001c¢\u0006\u0004\b\u001e\u0010\u001fJ¨\u0002\u0010 \u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\u0017\u001a\u00020\f2\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u00022\u0010\b\u0002\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u001a2\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001cHÆ\u0001¢\u0006\u0004\b \u0010!J\u0010\u0010\"\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\"\u0010#J\u0010\u0010$\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b$\u0010%J\u001a\u0010(\u001a\u00020'2\b\u0010&\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b(\u0010)R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010*\u001a\u0004\b+\u0010#R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0004\u0010*\u001a\u0004\b,\u0010#R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0005\u0010*\u001a\u0004\b-\u0010#R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0006\u0010*\u001a\u0004\b.\u0010#R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010*\u001a\u0004\b/\u0010#R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010*\u001a\u0004\b0\u0010#R\u001c\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010*\u001a\u0004\b1\u0010#R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u00102\u001a\u0004\b3\u00104R\u001c\u0010\r\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u00105\u001a\u0004\b6\u00107R\u001c\u0010\u000e\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u00105\u001a\u0004\b8\u00107R\u001c\u0010\u000f\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u00105\u001a\u0004\b9\u00107R\u001c\u0010\u0010\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u00105\u001a\u0004\b:\u00107R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010*\u001a\u0004\b;\u0010#R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010*\u001a\u0004\b<\u0010#R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010*\u001a\u0004\b=\u0010#R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0014\u0010*\u001a\u0004\b>\u0010#R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0015\u00105\u001a\u0004\b?\u00107R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0016\u0010*\u001a\u0004\b@\u0010#R\u001a\u0010\u0017\u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0017\u0010A\u001a\u0004\bB\u0010%R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0018\u0010*\u001a\u0004\bC\u0010#R\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0019\u0010*\u001a\u0004\bD\u0010#R\"\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u001a8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001b\u0010E\u001a\u0004\bF\u0010GR\u0019\u0010\u001d\u001a\u0004\u0018\u00010\u001c8\u0006¢\u0006\f\n\u0004\b\u001d\u0010H\u001a\u0004\bI\u0010J¨\u0006K"}, d2 = {"Lcom/stepos/ailauncher/agent/skill/detail/F;", "", "", "id", "name", "version", "displayName", "description", QueryAlgorithmBundle.KEY_CATEGORY, "developer", "", "downloadCount", "", HomeGestureEligibilityContract.EXTRA_SCENE, "necessary", ChatTracker.RETRY_RELOAD, "fromSource", "packageUrl", "icon", "createdAt", "updatedAt", "installStatus", "skillMd", "needUpdate", "installVersion", "packageSize", "", "changelog", "Lcom/stepos/ailauncher/agent/skill/SkillStatus;", "status", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/util/List;Lcom/stepos/ailauncher/agent/skill/SkillStatus;)V", Const.INTENT_KEY_APIKEY, "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/util/List;Lcom/stepos/ailauncher/agent/skill/SkillStatus;)Lcom/stepos/ailauncher/agent/skill/detail/F;", "toString", "()Ljava/lang/String;", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "l", "n", "v", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "f", "c", Const.INTENT_KEY_BACKGROUND_COMMAND, "Ljava/lang/Long;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "()Ljava/lang/Long;", "Ljava/lang/Integer;", "r", "()Ljava/lang/Integer;", "o", "getReload", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "getPackageUrl", "k", "e", "u", "getInstallStatus", "s", "I", "p", "m", "q", "Ljava/util/List;", Const.INTENT_KEY_UMID, "()Ljava/util/List;", "Lcom/stepos/ailauncher/agent/skill/SkillStatus;", "t", "()Lcom/stepos/ailauncher/agent/skill/SkillStatus;", "agent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.ailauncher.agent.skill.detail.F, reason: from toString */
/* loaded from: classes3.dex */
public final /* data */ class SkillDetailDto {

    @SerializedName(QueryAlgorithmBundle.KEY_CATEGORY)
    private final String category;

    @SerializedName("changelog")
    private final List<String> changelog;

    @SerializedName("createdAt")
    private final String createdAt;

    @SerializedName("description")
    private final String description;

    @SerializedName("developer")
    private final String developer;

    @SerializedName("displayName")
    private final String displayName;

    @SerializedName("downloadCount")
    private final Long downloadCount;

    @SerializedName("fromSource")
    private final Integer fromSource;

    @SerializedName(alternate = {"iconUrl", "icon_url"}, value = "icon")
    private final String icon;

    @SerializedName("id")
    private final String id;

    @SerializedName("installStatus")
    private final Integer installStatus;

    @SerializedName("installVersion")
    private final String installVersion;

    @SerializedName("name")
    private final String name;

    @SerializedName("necessary")
    private final Integer necessary;

    @SerializedName("needUpdate")
    private final int needUpdate;

    @SerializedName("package_size")
    private final String packageSize;

    @SerializedName("packageUrl")
    private final String packageUrl;

    @SerializedName(ChatTracker.RETRY_RELOAD)
    private final Integer reload;

    @SerializedName(HomeGestureEligibilityContract.EXTRA_SCENE)
    private final Integer scene;

    @SerializedName("skillMd")
    private final String skillMd;
    private final SkillStatus status;

    @SerializedName("updatedAt")
    private final String updatedAt;

    @SerializedName("version")
    private final String version;

    public SkillDetailDto(String str, String str2, String str3, String str4, String str5, String str6, String str7, Long l10, Integer num, Integer num2, Integer num3, Integer num4, String str8, String str9, String str10, String str11, Integer num5, String str12, int i10, String str13, String str14, List<String> list, SkillStatus skillStatus) {
        this.id = str;
        this.name = str2;
        this.version = str3;
        this.displayName = str4;
        this.description = str5;
        this.category = str6;
        this.developer = str7;
        this.downloadCount = l10;
        this.scene = num;
        this.necessary = num2;
        this.reload = num3;
        this.fromSource = num4;
        this.packageUrl = str8;
        this.icon = str9;
        this.createdAt = str10;
        this.updatedAt = str11;
        this.installStatus = num5;
        this.skillMd = str12;
        this.needUpdate = i10;
        this.installVersion = str13;
        this.packageSize = str14;
        this.changelog = list;
        this.status = skillStatus;
    }

    public static /* synthetic */ SkillDetailDto b(SkillDetailDto skillDetailDto, String str, String str2, String str3, String str4, String str5, String str6, String str7, Long l10, Integer num, Integer num2, Integer num3, Integer num4, String str8, String str9, String str10, String str11, Integer num5, String str12, int i10, String str13, String str14, List list, SkillStatus skillStatus, int i11, Object obj) {
        SkillStatus skillStatus2;
        List list2;
        String str15 = (i11 & 1) != 0 ? skillDetailDto.id : str;
        String str16 = (i11 & 2) != 0 ? skillDetailDto.name : str2;
        String str17 = (i11 & 4) != 0 ? skillDetailDto.version : str3;
        String str18 = (i11 & 8) != 0 ? skillDetailDto.displayName : str4;
        String str19 = (i11 & 16) != 0 ? skillDetailDto.description : str5;
        String str20 = (i11 & 32) != 0 ? skillDetailDto.category : str6;
        String str21 = (i11 & 64) != 0 ? skillDetailDto.developer : str7;
        Long l11 = (i11 & 128) != 0 ? skillDetailDto.downloadCount : l10;
        Integer num6 = (i11 & 256) != 0 ? skillDetailDto.scene : num;
        Integer num7 = (i11 & 512) != 0 ? skillDetailDto.necessary : num2;
        Integer num8 = (i11 & 1024) != 0 ? skillDetailDto.reload : num3;
        Integer num9 = (i11 & 2048) != 0 ? skillDetailDto.fromSource : num4;
        String str22 = (i11 & 4096) != 0 ? skillDetailDto.packageUrl : str8;
        String str23 = (i11 & com.stepos.agentframework.chatui.longtext.b.THRESHOLD) != 0 ? skillDetailDto.icon : str9;
        String str24 = str15;
        String str25 = (i11 & 16384) != 0 ? skillDetailDto.createdAt : str10;
        String str26 = (i11 & 32768) != 0 ? skillDetailDto.updatedAt : str11;
        Integer num10 = (i11 & 65536) != 0 ? skillDetailDto.installStatus : num5;
        String str27 = (i11 & SQLiteDatabase.OPEN_SHAREDCACHE) != 0 ? skillDetailDto.skillMd : str12;
        int i12 = (i11 & SQLiteDatabase.OPEN_PRIVATECACHE) != 0 ? skillDetailDto.needUpdate : i10;
        String str28 = (i11 & 524288) != 0 ? skillDetailDto.installVersion : str13;
        String str29 = (i11 & 1048576) != 0 ? skillDetailDto.packageSize : str14;
        List list3 = (i11 & 2097152) != 0 ? skillDetailDto.changelog : list;
        if ((i11 & 4194304) != 0) {
            list2 = list3;
            skillStatus2 = skillDetailDto.status;
        } else {
            skillStatus2 = skillStatus;
            list2 = list3;
        }
        return skillDetailDto.a(str24, str16, str17, str18, str19, str20, str21, l11, num6, num7, num8, num9, str22, str23, str25, str26, num10, str27, i12, str28, str29, list2, skillStatus2);
    }

    public final SkillDetailDto a(String id, String name, String version, String displayName, String description, String category, String developer, Long downloadCount, Integer scene, Integer necessary, Integer reload, Integer fromSource, String packageUrl, String icon, String createdAt, String updatedAt, Integer installStatus, String skillMd, int needUpdate, String installVersion, String packageSize, List<String> changelog, SkillStatus status) {
        return new SkillDetailDto(id, name, version, displayName, description, category, developer, downloadCount, scene, necessary, reload, fromSource, packageUrl, icon, createdAt, updatedAt, installStatus, skillMd, needUpdate, installVersion, packageSize, changelog, status);
    }

    /* renamed from: c, reason: from getter */
    public final String getCategory() {
        return this.category;
    }

    public final List<String> d() {
        return this.changelog;
    }

    /* renamed from: e, reason: from getter */
    public final String getCreatedAt() {
        return this.createdAt;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SkillDetailDto)) {
            return false;
        }
        SkillDetailDto skillDetailDto = (SkillDetailDto) other;
        return kotlin.jvm.internal.p.d(this.id, skillDetailDto.id) && kotlin.jvm.internal.p.d(this.name, skillDetailDto.name) && kotlin.jvm.internal.p.d(this.version, skillDetailDto.version) && kotlin.jvm.internal.p.d(this.displayName, skillDetailDto.displayName) && kotlin.jvm.internal.p.d(this.description, skillDetailDto.description) && kotlin.jvm.internal.p.d(this.category, skillDetailDto.category) && kotlin.jvm.internal.p.d(this.developer, skillDetailDto.developer) && kotlin.jvm.internal.p.d(this.downloadCount, skillDetailDto.downloadCount) && kotlin.jvm.internal.p.d(this.scene, skillDetailDto.scene) && kotlin.jvm.internal.p.d(this.necessary, skillDetailDto.necessary) && kotlin.jvm.internal.p.d(this.reload, skillDetailDto.reload) && kotlin.jvm.internal.p.d(this.fromSource, skillDetailDto.fromSource) && kotlin.jvm.internal.p.d(this.packageUrl, skillDetailDto.packageUrl) && kotlin.jvm.internal.p.d(this.icon, skillDetailDto.icon) && kotlin.jvm.internal.p.d(this.createdAt, skillDetailDto.createdAt) && kotlin.jvm.internal.p.d(this.updatedAt, skillDetailDto.updatedAt) && kotlin.jvm.internal.p.d(this.installStatus, skillDetailDto.installStatus) && kotlin.jvm.internal.p.d(this.skillMd, skillDetailDto.skillMd) && this.needUpdate == skillDetailDto.needUpdate && kotlin.jvm.internal.p.d(this.installVersion, skillDetailDto.installVersion) && kotlin.jvm.internal.p.d(this.packageSize, skillDetailDto.packageSize) && kotlin.jvm.internal.p.d(this.changelog, skillDetailDto.changelog) && this.status == skillDetailDto.status;
    }

    /* renamed from: f, reason: from getter */
    public final String getDescription() {
        return this.description;
    }

    /* renamed from: g, reason: from getter */
    public final String getDeveloper() {
        return this.developer;
    }

    /* renamed from: h, reason: from getter */
    public final String getDisplayName() {
        return this.displayName;
    }

    public int hashCode() {
        String str = this.id;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.name;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.version;
        int iHashCode3 = (iHashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.displayName;
        int iHashCode4 = (iHashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.description;
        int iHashCode5 = (iHashCode4 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.category;
        int iHashCode6 = (iHashCode5 + (str6 == null ? 0 : str6.hashCode())) * 31;
        String str7 = this.developer;
        int iHashCode7 = (iHashCode6 + (str7 == null ? 0 : str7.hashCode())) * 31;
        Long l10 = this.downloadCount;
        int iHashCode8 = (iHashCode7 + (l10 == null ? 0 : l10.hashCode())) * 31;
        Integer num = this.scene;
        int iHashCode9 = (iHashCode8 + (num == null ? 0 : num.hashCode())) * 31;
        Integer num2 = this.necessary;
        int iHashCode10 = (iHashCode9 + (num2 == null ? 0 : num2.hashCode())) * 31;
        Integer num3 = this.reload;
        int iHashCode11 = (iHashCode10 + (num3 == null ? 0 : num3.hashCode())) * 31;
        Integer num4 = this.fromSource;
        int iHashCode12 = (iHashCode11 + (num4 == null ? 0 : num4.hashCode())) * 31;
        String str8 = this.packageUrl;
        int iHashCode13 = (iHashCode12 + (str8 == null ? 0 : str8.hashCode())) * 31;
        String str9 = this.icon;
        int iHashCode14 = (iHashCode13 + (str9 == null ? 0 : str9.hashCode())) * 31;
        String str10 = this.createdAt;
        int iHashCode15 = (iHashCode14 + (str10 == null ? 0 : str10.hashCode())) * 31;
        String str11 = this.updatedAt;
        int iHashCode16 = (iHashCode15 + (str11 == null ? 0 : str11.hashCode())) * 31;
        Integer num5 = this.installStatus;
        int iHashCode17 = (iHashCode16 + (num5 == null ? 0 : num5.hashCode())) * 31;
        String str12 = this.skillMd;
        int iHashCode18 = (((iHashCode17 + (str12 == null ? 0 : str12.hashCode())) * 31) + Integer.hashCode(this.needUpdate)) * 31;
        String str13 = this.installVersion;
        int iHashCode19 = (iHashCode18 + (str13 == null ? 0 : str13.hashCode())) * 31;
        String str14 = this.packageSize;
        int iHashCode20 = (iHashCode19 + (str14 == null ? 0 : str14.hashCode())) * 31;
        List<String> list = this.changelog;
        int iHashCode21 = (iHashCode20 + (list == null ? 0 : list.hashCode())) * 31;
        SkillStatus skillStatus = this.status;
        return iHashCode21 + (skillStatus != null ? skillStatus.hashCode() : 0);
    }

    /* renamed from: i, reason: from getter */
    public final Long getDownloadCount() {
        return this.downloadCount;
    }

    /* renamed from: j, reason: from getter */
    public final Integer getFromSource() {
        return this.fromSource;
    }

    /* renamed from: k, reason: from getter */
    public final String getIcon() {
        return this.icon;
    }

    /* renamed from: l, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* renamed from: m, reason: from getter */
    public final String getInstallVersion() {
        return this.installVersion;
    }

    /* renamed from: n, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* renamed from: o, reason: from getter */
    public final Integer getNecessary() {
        return this.necessary;
    }

    /* renamed from: p, reason: from getter */
    public final int getNeedUpdate() {
        return this.needUpdate;
    }

    /* renamed from: q, reason: from getter */
    public final String getPackageSize() {
        return this.packageSize;
    }

    /* renamed from: r, reason: from getter */
    public final Integer getScene() {
        return this.scene;
    }

    /* renamed from: s, reason: from getter */
    public final String getSkillMd() {
        return this.skillMd;
    }

    /* renamed from: t, reason: from getter */
    public final SkillStatus getStatus() {
        return this.status;
    }

    public String toString() {
        return "SkillDetailDto(id=" + this.id + ", name=" + this.name + ", version=" + this.version + ", displayName=" + this.displayName + ", description=" + this.description + ", category=" + this.category + ", developer=" + this.developer + ", downloadCount=" + this.downloadCount + ", scene=" + this.scene + ", necessary=" + this.necessary + ", reload=" + this.reload + ", fromSource=" + this.fromSource + ", packageUrl=" + this.packageUrl + ", icon=" + this.icon + ", createdAt=" + this.createdAt + ", updatedAt=" + this.updatedAt + ", installStatus=" + this.installStatus + ", skillMd=" + this.skillMd + ", needUpdate=" + this.needUpdate + ", installVersion=" + this.installVersion + ", packageSize=" + this.packageSize + ", changelog=" + this.changelog + ", status=" + this.status + ")";
    }

    /* renamed from: u, reason: from getter */
    public final String getUpdatedAt() {
        return this.updatedAt;
    }

    /* renamed from: v, reason: from getter */
    public final String getVersion() {
        return this.version;
    }
}
