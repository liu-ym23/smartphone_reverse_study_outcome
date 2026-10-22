package com.stepos.taskrobot.taskmanager.experiencelib.model;

import B7.a;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.k;
import stepai.aios.guiagent.config.GuiAgentConfigKt;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u001f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001Bg\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\f\u0010\rJ\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\u0003HÆ\u0003Jo\u0010!\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\"\u001a\u00020#2\b\u0010$\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010%\u001a\u00020&HÖ\u0001J\t\u0010'\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000fR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000fR\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000fR\u0018\u0010\b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000fR\u0018\u0010\t\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000fR\u0016\u0010\n\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u000fR\u0018\u0010\u000b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u000f¨\u0006("}, d2 = {"Lcom/stepos/taskrobot/taskmanager/experiencelib/model/ExperienceRequest;", "", "userId", "", "appName", "appVersion", "deviceType", "fontSize", "resolution", "pixelLevel", "taskDesc", "actions", AppAgent.CONSTRUCT, "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getUserId", "()Ljava/lang/String;", "getAppName", "getAppVersion", "getDeviceType", "getFontSize", "getResolution", "getPixelLevel", "getTaskDesc", "getActions", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "hashCode", "", "toString", "experiencelib_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class ExperienceRequest {

    @SerializedName("actions")
    private final String actions;

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

    @SerializedName("resolution")
    private final String resolution;

    @SerializedName("task_desc")
    private final String taskDesc;

    @SerializedName("user_id")
    private final String userId;

    public ExperienceRequest(String userId, String appName, String str, String str2, String str3, String str4, String str5, String taskDesc, String str6) {
        k.f(userId, "userId");
        k.f(appName, "appName");
        k.f(taskDesc, "taskDesc");
        this.userId = userId;
        this.appName = appName;
        this.appVersion = str;
        this.deviceType = str2;
        this.fontSize = str3;
        this.resolution = str4;
        this.pixelLevel = str5;
        this.taskDesc = taskDesc;
        this.actions = str6;
    }

    public static /* synthetic */ ExperienceRequest copy$default(ExperienceRequest experienceRequest, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, int i, Object obj) {
        if ((i & 1) != 0) {
            str = experienceRequest.userId;
        }
        if ((i & 2) != 0) {
            str2 = experienceRequest.appName;
        }
        if ((i & 4) != 0) {
            str3 = experienceRequest.appVersion;
        }
        if ((i & 8) != 0) {
            str4 = experienceRequest.deviceType;
        }
        if ((i & 16) != 0) {
            str5 = experienceRequest.fontSize;
        }
        if ((i & 32) != 0) {
            str6 = experienceRequest.resolution;
        }
        if ((i & 64) != 0) {
            str7 = experienceRequest.pixelLevel;
        }
        if ((i & 128) != 0) {
            str8 = experienceRequest.taskDesc;
        }
        if ((i & 256) != 0) {
            str9 = experienceRequest.actions;
        }
        String str10 = str8;
        String str11 = str9;
        String str12 = str6;
        String str13 = str7;
        String str14 = str5;
        String str15 = str3;
        return experienceRequest.copy(str, str2, str15, str4, str14, str12, str13, str10, str11);
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
    public final String getTaskDesc() {
        return this.taskDesc;
    }

    /* renamed from: component9, reason: from getter */
    public final String getActions() {
        return this.actions;
    }

    public final ExperienceRequest copy(String userId, String appName, String appVersion, String deviceType, String fontSize, String resolution, String pixelLevel, String taskDesc, String actions) {
        k.f(userId, "userId");
        k.f(appName, "appName");
        k.f(taskDesc, "taskDesc");
        return new ExperienceRequest(userId, appName, appVersion, deviceType, fontSize, resolution, pixelLevel, taskDesc, actions);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ExperienceRequest)) {
            return false;
        }
        ExperienceRequest experienceRequest = (ExperienceRequest) other;
        return k.b(this.userId, experienceRequest.userId) && k.b(this.appName, experienceRequest.appName) && k.b(this.appVersion, experienceRequest.appVersion) && k.b(this.deviceType, experienceRequest.deviceType) && k.b(this.fontSize, experienceRequest.fontSize) && k.b(this.resolution, experienceRequest.resolution) && k.b(this.pixelLevel, experienceRequest.pixelLevel) && k.b(this.taskDesc, experienceRequest.taskDesc) && k.b(this.actions, experienceRequest.actions);
    }

    public final String getActions() {
        return this.actions;
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

    public final String getResolution() {
        return this.resolution;
    }

    public final String getTaskDesc() {
        return this.taskDesc;
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
        int iC2 = a.c((iHashCode4 + (str5 == null ? 0 : str5.hashCode())) * 31, 31, this.taskDesc);
        String str6 = this.actions;
        return iC2 + (str6 != null ? str6.hashCode() : 0);
    }

    public String toString() {
        String str = this.userId;
        String str2 = this.appName;
        String str3 = this.appVersion;
        String str4 = this.deviceType;
        String str5 = this.fontSize;
        String str6 = this.resolution;
        String str7 = this.pixelLevel;
        String str8 = this.taskDesc;
        String str9 = this.actions;
        StringBuilder sbW = a.w("ExperienceRequest(userId=", str, ", appName=", str2, ", appVersion=");
        androidx.constraintlayout.core.dsl.a.A(sbW, str3, ", deviceType=", str4, ", fontSize=");
        androidx.constraintlayout.core.dsl.a.A(sbW, str5, ", resolution=", str6, ", pixelLevel=");
        androidx.constraintlayout.core.dsl.a.A(sbW, str7, ", taskDesc=", str8, ", actions=");
        return a.q(sbW, str9, ")");
    }

    public /* synthetic */ ExperienceRequest(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, int i, e eVar) {
        this(str, str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? null : str4, (i & 16) != 0 ? null : str5, (i & 32) != 0 ? null : str6, (i & 64) != 0 ? null : str7, str8, (i & 256) != 0 ? null : str9);
    }
}
