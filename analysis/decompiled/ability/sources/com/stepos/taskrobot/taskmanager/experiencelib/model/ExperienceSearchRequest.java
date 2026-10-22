package com.stepos.taskrobot.taskmanager.experiencelib.model;

import B7.a;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.k;
import stepai.aios.guiagent.config.GuiAgentConfigKt;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0018\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001Be\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f¢\u0006\u0004\b\r\u0010\u000eJ\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010!\u001a\u00020\u0003HÆ\u0003J\t\u0010\"\u001a\u00020\fHÆ\u0003Jm\u0010#\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\fHÆ\u0001J\u0013\u0010$\u001a\u00020%2\b\u0010&\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010'\u001a\u00020\fHÖ\u0001J\t\u0010(\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0010R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0010R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0010R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0010R\u0018\u0010\t\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0010R\u0016\u0010\n\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0010R\u0016\u0010\u000b\u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019¨\u0006)"}, d2 = {"Lcom/stepos/taskrobot/taskmanager/experiencelib/model/ExperienceSearchRequest;", "", "userId", "", "appName", "appVersion", "deviceType", "fontSize", "resolution", "pixelLevel", "query", "top_k", "", AppAgent.CONSTRUCT, "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V", "getUserId", "()Ljava/lang/String;", "getAppName", "getAppVersion", "getDeviceType", "getFontSize", "getResolution", "getPixelLevel", "getQuery", "getTop_k", "()I", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "hashCode", "toString", "experiencelib_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class ExperienceSearchRequest {

    @SerializedName(GuiAgentConfigKt.META_KEY_APP_NAME)
    private final String appName;

    @SerializedName("app_version")
    private final String appVersion;

    @SerializedName("device_type")
    private final String deviceType;

    @SerializedName("font_size")
    private final String fontSize;

    @SerializedName("pixel_level")
    private final String pixelLevel;

    @SerializedName("query")
    private final String query;

    @SerializedName("resolution")
    private final String resolution;

    @SerializedName("top_k")
    private final int top_k;

    @SerializedName("user_id")
    private final String userId;

    public ExperienceSearchRequest(String userId, String appName, String str, String str2, String str3, String str4, String str5, String query, int i) {
        k.f(userId, "userId");
        k.f(appName, "appName");
        k.f(query, "query");
        this.userId = userId;
        this.appName = appName;
        this.appVersion = str;
        this.deviceType = str2;
        this.fontSize = str3;
        this.resolution = str4;
        this.pixelLevel = str5;
        this.query = query;
        this.top_k = i;
    }

    public static /* synthetic */ ExperienceSearchRequest copy$default(ExperienceSearchRequest experienceSearchRequest, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, int i, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            str = experienceSearchRequest.userId;
        }
        if ((i6 & 2) != 0) {
            str2 = experienceSearchRequest.appName;
        }
        if ((i6 & 4) != 0) {
            str3 = experienceSearchRequest.appVersion;
        }
        if ((i6 & 8) != 0) {
            str4 = experienceSearchRequest.deviceType;
        }
        if ((i6 & 16) != 0) {
            str5 = experienceSearchRequest.fontSize;
        }
        if ((i6 & 32) != 0) {
            str6 = experienceSearchRequest.resolution;
        }
        if ((i6 & 64) != 0) {
            str7 = experienceSearchRequest.pixelLevel;
        }
        if ((i6 & 128) != 0) {
            str8 = experienceSearchRequest.query;
        }
        if ((i6 & 256) != 0) {
            i = experienceSearchRequest.top_k;
        }
        String str9 = str8;
        int i10 = i;
        String str10 = str6;
        String str11 = str7;
        String str12 = str5;
        String str13 = str3;
        return experienceSearchRequest.copy(str, str2, str13, str4, str12, str10, str11, str9, i10);
    }

    /* renamed from: component1, reason: from getter */
    public final String getUserId() {
        return this.userId;
    }

    /* renamed from: component2, reason: from getter */
    public final String getAppName() {
        return this.appName;
    }

    /* renamed from: component3, reason: from getter */
    public final String getAppVersion() {
        return this.appVersion;
    }

    /* renamed from: component4, reason: from getter */
    public final String getDeviceType() {
        return this.deviceType;
    }

    /* renamed from: component5, reason: from getter */
    public final String getFontSize() {
        return this.fontSize;
    }

    /* renamed from: component6, reason: from getter */
    public final String getResolution() {
        return this.resolution;
    }

    /* renamed from: component7, reason: from getter */
    public final String getPixelLevel() {
        return this.pixelLevel;
    }

    /* renamed from: component8, reason: from getter */
    public final String getQuery() {
        return this.query;
    }

    /* renamed from: component9, reason: from getter */
    public final int getTop_k() {
        return this.top_k;
    }

    public final ExperienceSearchRequest copy(String userId, String appName, String appVersion, String deviceType, String fontSize, String resolution, String pixelLevel, String query, int top_k) {
        k.f(userId, "userId");
        k.f(appName, "appName");
        k.f(query, "query");
        return new ExperienceSearchRequest(userId, appName, appVersion, deviceType, fontSize, resolution, pixelLevel, query, top_k);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ExperienceSearchRequest)) {
            return false;
        }
        ExperienceSearchRequest experienceSearchRequest = (ExperienceSearchRequest) other;
        return k.b(this.userId, experienceSearchRequest.userId) && k.b(this.appName, experienceSearchRequest.appName) && k.b(this.appVersion, experienceSearchRequest.appVersion) && k.b(this.deviceType, experienceSearchRequest.deviceType) && k.b(this.fontSize, experienceSearchRequest.fontSize) && k.b(this.resolution, experienceSearchRequest.resolution) && k.b(this.pixelLevel, experienceSearchRequest.pixelLevel) && k.b(this.query, experienceSearchRequest.query) && this.top_k == experienceSearchRequest.top_k;
    }

    public final String getAppName() {
        return this.appName;
    }

    public final String getAppVersion() {
        return this.appVersion;
    }

    public final String getDeviceType() {
        return this.deviceType;
    }

    public final String getFontSize() {
        return this.fontSize;
    }

    public final String getPixelLevel() {
        return this.pixelLevel;
    }

    public final String getQuery() {
        return this.query;
    }

    public final String getResolution() {
        return this.resolution;
    }

    public final int getTop_k() {
        return this.top_k;
    }

    public final String getUserId() {
        return this.userId;
    }

    public int hashCode() {
        int iC = a.c(this.userId.hashCode() * 31, 31, this.appName);
        String str = this.appVersion;
        int iHashCode = (iC + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.deviceType;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.fontSize;
        int iHashCode3 = (iHashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.resolution;
        int iHashCode4 = (iHashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.pixelLevel;
        return Integer.hashCode(this.top_k) + a.c((iHashCode4 + (str5 != null ? str5.hashCode() : 0)) * 31, 31, this.query);
    }

    public String toString() {
        String str = this.userId;
        String str2 = this.appName;
        String str3 = this.appVersion;
        String str4 = this.deviceType;
        String str5 = this.fontSize;
        String str6 = this.resolution;
        String str7 = this.pixelLevel;
        String str8 = this.query;
        int i = this.top_k;
        StringBuilder sbW = a.w("ExperienceSearchRequest(userId=", str, ", appName=", str2, ", appVersion=");
        androidx.constraintlayout.core.dsl.a.A(sbW, str3, ", deviceType=", str4, ", fontSize=");
        androidx.constraintlayout.core.dsl.a.A(sbW, str5, ", resolution=", str6, ", pixelLevel=");
        androidx.constraintlayout.core.dsl.a.A(sbW, str7, ", query=", str8, ", top_k=");
        return androidx.appfunctions.metadata.a.o(sbW, ")", i);
    }

    public /* synthetic */ ExperienceSearchRequest(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, int i, int i6, e eVar) {
        this(str, str2, (i6 & 4) != 0 ? null : str3, (i6 & 8) != 0 ? null : str4, (i6 & 16) != 0 ? null : str5, (i6 & 32) != 0 ? null : str6, (i6 & 64) != 0 ? null : str7, str8, (i6 & 256) != 0 ? 1 : i);
    }
}
