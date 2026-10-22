package com.stepos.ailauncher.agent.aispace.market.data;

import com.autonavi.aps.amapapi.config.Const;
import com.google.gson.annotations.SerializedName;
import com.stepos.widget.recipient.StepOSRecipientEmailHistory;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0010\b\u0080\b\u0018\u00002\u00020\u0001B\u0087\u0001\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u0010\r\u001a\u00020\f\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0013\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u001a\u0010\u0017\u001a\u00020\u00162\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0019\u001a\u0004\b\u001a\u0010\u0012R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0019\u001a\u0004\b\u001b\u0010\u0012R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u0019\u001a\u0004\b\u001c\u0010\u0012R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0006\u0010\u0019\u001a\u0004\b\u001d\u0010\u0012R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0019\u001a\u0004\b\u001e\u0010\u0012R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\u0019\u001a\u0004\b\u001f\u0010\u0012R\u001c\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0019\u001a\u0004\b \u0010\u0012R\u001c\u0010\n\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u0019\u001a\u0004\b!\u0010\u0012R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0019\u001a\u0004\b\"\u0010\u0012R\u001a\u0010\r\u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010#\u001a\u0004\b$\u0010\u0014R\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u0019\u001a\u0004\b%\u0010\u0012¨\u0006&"}, d2 = {"Lcom/stepos/ailauncher/agent/aispace/market/data/g;", "", "", "appId", "name", "displayName", "description", "version", "appType", "packageName", "h5Url", "icon", "", "status", "env", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;)V", "toString", "()Ljava/lang/String;", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", Const.INTENT_KEY_APIKEY, Const.INTENT_KEY_BACKGROUND_NOTIFICATION, Const.INTENT_KEY_UMID, "c", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, Const.INTENT_KEY_PKGNAME, Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "f", Const.INTENT_KEY_BACKGROUND_COMMAND, "I", "getStatus", "e", "agent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.ailauncher.agent.aispace.market.data.g, reason: from toString */
/* loaded from: classes3.dex */
public final /* data */ class AppItemDto {

    @SerializedName(alternate = {"app_id"}, value = "appId")
    private final String appId;

    @SerializedName(alternate = {"app_type"}, value = "appType")
    private final String appType;

    @SerializedName("description")
    private final String description;

    @SerializedName(alternate = {StepOSRecipientEmailHistory.DISPLAY_NAME}, value = "displayName")
    private final String displayName;

    @SerializedName("env")
    private final String env;

    @SerializedName(alternate = {"h5_url"}, value = "h5Url")
    private final String h5Url;

    @SerializedName(alternate = {"iconUrl", "icon_url"}, value = "icon")
    private final String icon;

    @SerializedName("name")
    private final String name;

    @SerializedName(alternate = {"package_name"}, value = "packageName")
    private final String packageName;

    @SerializedName("status")
    private final int status;

    @SerializedName("version")
    private final String version;

    public AppItemDto() {
        this(null, null, null, null, null, null, null, null, null, 0, null, 2047, null);
    }

    /* renamed from: a, reason: from getter */
    public final String getAppId() {
        return this.appId;
    }

    /* renamed from: b, reason: from getter */
    public final String getAppType() {
        return this.appType;
    }

    /* renamed from: c, reason: from getter */
    public final String getDescription() {
        return this.description;
    }

    /* renamed from: d, reason: from getter */
    public final String getDisplayName() {
        return this.displayName;
    }

    /* renamed from: e, reason: from getter */
    public final String getEnv() {
        return this.env;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AppItemDto)) {
            return false;
        }
        AppItemDto appItemDto = (AppItemDto) other;
        return kotlin.jvm.internal.p.d(this.appId, appItemDto.appId) && kotlin.jvm.internal.p.d(this.name, appItemDto.name) && kotlin.jvm.internal.p.d(this.displayName, appItemDto.displayName) && kotlin.jvm.internal.p.d(this.description, appItemDto.description) && kotlin.jvm.internal.p.d(this.version, appItemDto.version) && kotlin.jvm.internal.p.d(this.appType, appItemDto.appType) && kotlin.jvm.internal.p.d(this.packageName, appItemDto.packageName) && kotlin.jvm.internal.p.d(this.h5Url, appItemDto.h5Url) && kotlin.jvm.internal.p.d(this.icon, appItemDto.icon) && this.status == appItemDto.status && kotlin.jvm.internal.p.d(this.env, appItemDto.env);
    }

    /* renamed from: f, reason: from getter */
    public final String getH5Url() {
        return this.h5Url;
    }

    /* renamed from: g, reason: from getter */
    public final String getIcon() {
        return this.icon;
    }

    /* renamed from: h, reason: from getter */
    public final String getName() {
        return this.name;
    }

    public int hashCode() {
        int iHashCode = this.appId.hashCode() * 31;
        String str = this.name;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.displayName;
        int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.description;
        int iHashCode4 = (iHashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.version;
        int iHashCode5 = (iHashCode4 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.appType;
        int iHashCode6 = (iHashCode5 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.packageName;
        int iHashCode7 = (iHashCode6 + (str6 == null ? 0 : str6.hashCode())) * 31;
        String str7 = this.h5Url;
        int iHashCode8 = (iHashCode7 + (str7 == null ? 0 : str7.hashCode())) * 31;
        String str8 = this.icon;
        int iHashCode9 = (((iHashCode8 + (str8 == null ? 0 : str8.hashCode())) * 31) + Integer.hashCode(this.status)) * 31;
        String str9 = this.env;
        return iHashCode9 + (str9 != null ? str9.hashCode() : 0);
    }

    /* renamed from: i, reason: from getter */
    public final String getPackageName() {
        return this.packageName;
    }

    /* renamed from: j, reason: from getter */
    public final String getVersion() {
        return this.version;
    }

    public String toString() {
        return "AppItemDto(appId=" + this.appId + ", name=" + this.name + ", displayName=" + this.displayName + ", description=" + this.description + ", version=" + this.version + ", appType=" + this.appType + ", packageName=" + this.packageName + ", h5Url=" + this.h5Url + ", icon=" + this.icon + ", status=" + this.status + ", env=" + this.env + ")";
    }

    public AppItemDto(String appId, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, int i10, String str9) {
        kotlin.jvm.internal.p.i(appId, "appId");
        this.appId = appId;
        this.name = str;
        this.displayName = str2;
        this.description = str3;
        this.version = str4;
        this.appType = str5;
        this.packageName = str6;
        this.h5Url = str7;
        this.icon = str8;
        this.status = i10;
        this.env = str9;
    }

    /*  JADX ERROR: NullPointerException in pass: InitCodeVariables
        java.lang.NullPointerException
        */
    public /* synthetic */ AppItemDto(java.lang.String r2, java.lang.String r3, java.lang.String r4, java.lang.String r5, java.lang.String r6, java.lang.String r7, java.lang.String r8, java.lang.String r9, java.lang.String r10, int r11, java.lang.String r12, int r13, kotlin.jvm.internal.i r14) {
        /*
            r1 = this;
            r14 = r13 & 1
            if (r14 == 0) goto L6
            java.lang.String r2 = ""
        L6:
            r14 = r13 & 2
            r0 = 0
            if (r14 == 0) goto Lc
            r3 = r0
        Lc:
            r14 = r13 & 4
            if (r14 == 0) goto L11
            r4 = r0
        L11:
            r14 = r13 & 8
            if (r14 == 0) goto L16
            r5 = r0
        L16:
            r14 = r13 & 16
            if (r14 == 0) goto L1b
            r6 = r0
        L1b:
            r14 = r13 & 32
            if (r14 == 0) goto L20
            r7 = r0
        L20:
            r14 = r13 & 64
            if (r14 == 0) goto L25
            r8 = r0
        L25:
            r14 = r13 & 128(0x80, float:1.8E-43)
            if (r14 == 0) goto L2a
            r9 = r0
        L2a:
            r14 = r13 & 256(0x100, float:3.59E-43)
            if (r14 == 0) goto L2f
            r10 = r0
        L2f:
            r14 = r13 & 512(0x200, float:7.17E-43)
            if (r14 == 0) goto L34
            r11 = 0
        L34:
            r13 = r13 & 1024(0x400, float:1.435E-42)
            if (r13 == 0) goto L45
            r14 = r0
            r12 = r10
            r13 = r11
            r10 = r8
            r11 = r9
            r8 = r6
            r9 = r7
            r6 = r4
            r7 = r5
            r4 = r2
            r5 = r3
            r3 = r1
            goto L51
        L45:
            r14 = r12
            r13 = r11
            r11 = r9
            r12 = r10
            r9 = r7
            r10 = r8
            r7 = r5
            r8 = r6
            r5 = r3
            r6 = r4
            r3 = r1
            r4 = r2
        L51:
            r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.agent.aispace.market.data.AppItemDto.<init>(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, int, java.lang.String, int, kotlin.jvm.internal.i):void");
    }
}
