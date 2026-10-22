package com.stepos.ailauncher.agent.aispace.connect.data;

import com.autonavi.aps.amapapi.config.Const;
import com.google.gson.annotations.SerializedName;
import com.stepos.statsapp.v3.lib.plugin.constants.Parameters;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0011\b\u0080\b\u0018\u00002\u00020\u0001B\u008d\u0001\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u0010\t\u001a\u00020\b\u0012\b\b\u0002\u0010\n\u001a\u00020\b\u0012\b\b\u0002\u0010\u000b\u001a\u00020\b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u0010\r\u001a\u00020\b\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0012\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0014\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u001a\u0010\u0018\u001a\u00020\u00172\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0018\u0010\u0019R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u001a\u001a\u0004\b\u001b\u0010\u0013R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u001a\u001a\u0004\b\u001c\u0010\u0013R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u001a\u001a\u0004\b\u001d\u0010\u0013R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0006\u0010\u001a\u001a\u0004\b\u001e\u0010\u0013R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u001a\u001a\u0004\b\u001f\u0010\u0013R\u001a\u0010\t\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010 \u001a\u0004\b!\u0010\u0015R\u001a\u0010\n\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010 \u001a\u0004\b\"\u0010\u0015R\u001a\u0010\u000b\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010 \u001a\u0004\b#\u0010\u0015R\u001c\u0010\f\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\u001a\u001a\u0004\b$\u0010\u0013R\u001a\u0010\r\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010 \u001a\u0004\b%\u0010\u0015R\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u001a\u001a\u0004\b&\u0010\u0013R\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u001a\u001a\u0004\b'\u0010\u0013¨\u0006("}, d2 = {"Lcom/stepos/ailauncher/agent/aispace/connect/data/q;", "", "", "deviceId", "deviceName", "cliVersion", Parameters.OS, "homeDir", "", "claudeEnabled", "codexEnabled", "stepaiEnabled", "primaryAgent", "status", "lastActiveTime", "matchAt", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IIILjava/lang/String;ILjava/lang/String;Ljava/lang/String;)V", "toString", "()Ljava/lang/String;", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", Const.INTENT_KEY_UMID, "e", Const.INTENT_KEY_PKGNAME, Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "f", "I", Const.INTENT_KEY_APIKEY, "c", "l", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "k", Const.INTENT_KEY_BACKGROUND_COMMAND, Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "agent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.ailauncher.agent.aispace.connect.data.q, reason: from toString */
/* loaded from: classes3.dex */
public final /* data */ class DeviceInfoDto {

    @SerializedName("claude_enabled")
    private final int claudeEnabled;

    @SerializedName("cli_version")
    private final String cliVersion;

    @SerializedName("codex_enabled")
    private final int codexEnabled;

    @SerializedName(Parameters.DEVICE_ID)
    private final String deviceId;

    @SerializedName("device_name")
    private final String deviceName;

    @SerializedName("home_dir")
    private final String homeDir;

    @SerializedName("last_active_time")
    private final String lastActiveTime;

    @SerializedName("match_at")
    private final String matchAt;

    @SerializedName(Parameters.OS)
    private final String os;

    @SerializedName("primary_agent")
    private final String primaryAgent;

    @SerializedName("status")
    private final int status;

    @SerializedName("stepai_enabled")
    private final int stepaiEnabled;

    public DeviceInfoDto() {
        this(null, null, null, null, null, 0, 0, 0, null, 0, null, null, 4095, null);
    }

    /* renamed from: a, reason: from getter */
    public final int getClaudeEnabled() {
        return this.claudeEnabled;
    }

    /* renamed from: b, reason: from getter */
    public final String getCliVersion() {
        return this.cliVersion;
    }

    /* renamed from: c, reason: from getter */
    public final int getCodexEnabled() {
        return this.codexEnabled;
    }

    /* renamed from: d, reason: from getter */
    public final String getDeviceId() {
        return this.deviceId;
    }

    /* renamed from: e, reason: from getter */
    public final String getDeviceName() {
        return this.deviceName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DeviceInfoDto)) {
            return false;
        }
        DeviceInfoDto deviceInfoDto = (DeviceInfoDto) other;
        return kotlin.jvm.internal.p.d(this.deviceId, deviceInfoDto.deviceId) && kotlin.jvm.internal.p.d(this.deviceName, deviceInfoDto.deviceName) && kotlin.jvm.internal.p.d(this.cliVersion, deviceInfoDto.cliVersion) && kotlin.jvm.internal.p.d(this.os, deviceInfoDto.os) && kotlin.jvm.internal.p.d(this.homeDir, deviceInfoDto.homeDir) && this.claudeEnabled == deviceInfoDto.claudeEnabled && this.codexEnabled == deviceInfoDto.codexEnabled && this.stepaiEnabled == deviceInfoDto.stepaiEnabled && kotlin.jvm.internal.p.d(this.primaryAgent, deviceInfoDto.primaryAgent) && this.status == deviceInfoDto.status && kotlin.jvm.internal.p.d(this.lastActiveTime, deviceInfoDto.lastActiveTime) && kotlin.jvm.internal.p.d(this.matchAt, deviceInfoDto.matchAt);
    }

    /* renamed from: f, reason: from getter */
    public final String getHomeDir() {
        return this.homeDir;
    }

    /* renamed from: g, reason: from getter */
    public final String getLastActiveTime() {
        return this.lastActiveTime;
    }

    /* renamed from: h, reason: from getter */
    public final String getMatchAt() {
        return this.matchAt;
    }

    public int hashCode() {
        int iHashCode = this.deviceId.hashCode() * 31;
        String str = this.deviceName;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.cliVersion;
        int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.os;
        int iHashCode4 = (iHashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.homeDir;
        int iHashCode5 = (((((((iHashCode4 + (str4 == null ? 0 : str4.hashCode())) * 31) + Integer.hashCode(this.claudeEnabled)) * 31) + Integer.hashCode(this.codexEnabled)) * 31) + Integer.hashCode(this.stepaiEnabled)) * 31;
        String str5 = this.primaryAgent;
        int iHashCode6 = (((iHashCode5 + (str5 == null ? 0 : str5.hashCode())) * 31) + Integer.hashCode(this.status)) * 31;
        String str6 = this.lastActiveTime;
        int iHashCode7 = (iHashCode6 + (str6 == null ? 0 : str6.hashCode())) * 31;
        String str7 = this.matchAt;
        return iHashCode7 + (str7 != null ? str7.hashCode() : 0);
    }

    /* renamed from: i, reason: from getter */
    public final String getOs() {
        return this.os;
    }

    /* renamed from: j, reason: from getter */
    public final String getPrimaryAgent() {
        return this.primaryAgent;
    }

    /* renamed from: k, reason: from getter */
    public final int getStatus() {
        return this.status;
    }

    /* renamed from: l, reason: from getter */
    public final int getStepaiEnabled() {
        return this.stepaiEnabled;
    }

    public String toString() {
        return "DeviceInfoDto(deviceId=" + this.deviceId + ", deviceName=" + this.deviceName + ", cliVersion=" + this.cliVersion + ", os=" + this.os + ", homeDir=" + this.homeDir + ", claudeEnabled=" + this.claudeEnabled + ", codexEnabled=" + this.codexEnabled + ", stepaiEnabled=" + this.stepaiEnabled + ", primaryAgent=" + this.primaryAgent + ", status=" + this.status + ", lastActiveTime=" + this.lastActiveTime + ", matchAt=" + this.matchAt + ")";
    }

    public DeviceInfoDto(String deviceId, String str, String str2, String str3, String str4, int i10, int i11, int i12, String str5, int i13, String str6, String str7) {
        kotlin.jvm.internal.p.i(deviceId, "deviceId");
        this.deviceId = deviceId;
        this.deviceName = str;
        this.cliVersion = str2;
        this.os = str3;
        this.homeDir = str4;
        this.claudeEnabled = i10;
        this.codexEnabled = i11;
        this.stepaiEnabled = i12;
        this.primaryAgent = str5;
        this.status = i13;
        this.lastActiveTime = str6;
        this.matchAt = str7;
    }

    public /* synthetic */ DeviceInfoDto(String str, String str2, String str3, String str4, String str5, int i10, int i11, int i12, String str6, int i13, String str7, String str8, int i14, kotlin.jvm.internal.i iVar) {
        this((i14 & 1) != 0 ? "" : str, (i14 & 2) != 0 ? null : str2, (i14 & 4) != 0 ? null : str3, (i14 & 8) != 0 ? null : str4, (i14 & 16) != 0 ? null : str5, (i14 & 32) != 0 ? 0 : i10, (i14 & 64) != 0 ? 0 : i11, (i14 & 128) != 0 ? 0 : i12, (i14 & 256) != 0 ? null : str6, (i14 & 512) == 0 ? i13 : 0, (i14 & 1024) != 0 ? null : str7, (i14 & 2048) != 0 ? null : str8);
    }
}
