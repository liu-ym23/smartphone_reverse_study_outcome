package com.stepos.taskrobot.taskmanager.experiencelib.model;

import B7.a;
import androidx.annotation.Keep;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.google.gson.annotations.SerializedName;
import com.stepos.ability.beaninternal.task.GuiTaskProgressKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.k;
import stepai.aios.guiagent.config.GuiAgentConfigKt;

@Keep
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u001b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0087\b\u0018\u00002\u00020\u0001:\u0001.B]\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f\u0012\u0006\u0010\u000e\u001a\u00020\u0003¢\u0006\u0004\b\u000f\u0010\u0010J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\t\u0010 \u001a\u00020\u0003HÆ\u0003J\t\u0010!\u001a\u00020\u0003HÆ\u0003J\t\u0010\"\u001a\u00020\u0003HÆ\u0003J\t\u0010#\u001a\u00020\u0003HÆ\u0003J\t\u0010$\u001a\u00020\u0003HÆ\u0003J\u000f\u0010%\u001a\b\u0012\u0004\u0012\u00020\r0\fHÆ\u0003J\t\u0010&\u001a\u00020\u0003HÆ\u0003Js\u0010'\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f2\b\b\u0002\u0010\u000e\u001a\u00020\u0003HÆ\u0001J\u0013\u0010(\u001a\u00020)2\b\u0010*\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010+\u001a\u00020,HÖ\u0001J\t\u0010-\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0012R\u0016\u0010\u0006\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0012R\u0016\u0010\u0007\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0012R\u0016\u0010\b\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0012R\u0016\u0010\t\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0012R\u0016\u0010\n\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0012R\u001c\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0016\u0010\u000e\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0012¨\u0006/"}, d2 = {"Lcom/stepos/taskrobot/taskmanager/experiencelib/model/SearchExperienceResult;", "", "appName", "", "appVersion", "deviceType", "error", "fontSize", "pixelLevel", "query", "resolution", "result", "", "Lcom/stepos/taskrobot/taskmanager/experiencelib/model/SearchExperienceResult$Result;", "userId", AppAgent.CONSTRUCT, "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;)V", "getAppName", "()Ljava/lang/String;", "getAppVersion", "getDeviceType", "getError", "getFontSize", "getPixelLevel", "getQuery", "getResolution", "getResult", "()Ljava/util/List;", "getUserId", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "copy", "equals", "", "other", "hashCode", "", "toString", "Result", "experiencelib_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class SearchExperienceResult {

    @SerializedName(GuiAgentConfigKt.META_KEY_APP_NAME)
    private final String appName;

    @SerializedName("app_version")
    private final String appVersion;

    @SerializedName("device_type")
    private final String deviceType;

    @SerializedName("error")
    private final String error;

    @SerializedName("font_size")
    private final String fontSize;

    @SerializedName("pixel_level")
    private final String pixelLevel;

    @SerializedName("query")
    private final String query;

    @SerializedName("resolution")
    private final String resolution;

    @SerializedName("result")
    private final List<Result> result;

    @SerializedName("user_id")
    private final String userId;

    @Keep
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J;\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u0005HÖ\u0001J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0016\u0010\u0006\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0016\u0010\u0007\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\fR\u0016\u0010\b\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\f¨\u0006\u001d"}, d2 = {"Lcom/stepos/taskrobot/taskmanager/experiencelib/model/SearchExperienceResult$Result;", "", "actions", "", "createTime", "", "position", "taskDesc", GuiTaskProgressKt.GuiTaskProgress_KEY_TASK_ID, AppAgent.CONSTRUCT, "(Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;)V", "getActions", "()Ljava/lang/String;", "getCreateTime", "()I", "getPosition", "getTaskDesc", "getTaskId", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "toString", "experiencelib_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class Result {

        @SerializedName("actions")
        private final String actions;

        @SerializedName("create_time")
        private final int createTime;

        @SerializedName("position")
        private final int position;

        @SerializedName("task_desc")
        private final String taskDesc;

        @SerializedName("task_id")
        private final String taskId;

        public Result(String actions, int i, int i6, String taskDesc, String taskId) {
            k.f(actions, "actions");
            k.f(taskDesc, "taskDesc");
            k.f(taskId, "taskId");
            this.actions = actions;
            this.createTime = i;
            this.position = i6;
            this.taskDesc = taskDesc;
            this.taskId = taskId;
        }

        public static /* synthetic */ Result copy$default(Result result, String str, int i, int i6, String str2, String str3, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                str = result.actions;
            }
            if ((i10 & 2) != 0) {
                i = result.createTime;
            }
            if ((i10 & 4) != 0) {
                i6 = result.position;
            }
            if ((i10 & 8) != 0) {
                str2 = result.taskDesc;
            }
            if ((i10 & 16) != 0) {
                str3 = result.taskId;
            }
            String str4 = str3;
            int i11 = i6;
            return result.copy(str, i, i11, str2, str4);
        }

        /* renamed from: component1, reason: from getter */
        public final String getActions() {
            return this.actions;
        }

        /* renamed from: component2, reason: from getter */
        public final int getCreateTime() {
            return this.createTime;
        }

        /* renamed from: component3, reason: from getter */
        public final int getPosition() {
            return this.position;
        }

        /* renamed from: component4, reason: from getter */
        public final String getTaskDesc() {
            return this.taskDesc;
        }

        /* renamed from: component5, reason: from getter */
        public final String getTaskId() {
            return this.taskId;
        }

        public final Result copy(String actions, int createTime, int position, String taskDesc, String taskId) {
            k.f(actions, "actions");
            k.f(taskDesc, "taskDesc");
            k.f(taskId, "taskId");
            return new Result(actions, createTime, position, taskDesc, taskId);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Result)) {
                return false;
            }
            Result result = (Result) other;
            return k.b(this.actions, result.actions) && this.createTime == result.createTime && this.position == result.position && k.b(this.taskDesc, result.taskDesc) && k.b(this.taskId, result.taskId);
        }

        public final String getActions() {
            return this.actions;
        }

        public final int getCreateTime() {
            return this.createTime;
        }

        public final int getPosition() {
            return this.position;
        }

        public final String getTaskDesc() {
            return this.taskDesc;
        }

        public final String getTaskId() {
            return this.taskId;
        }

        public int hashCode() {
            return this.taskId.hashCode() + a.c(androidx.constraintlayout.core.dsl.a.a(this.position, androidx.constraintlayout.core.dsl.a.a(this.createTime, this.actions.hashCode() * 31, 31), 31), 31, this.taskDesc);
        }

        public String toString() {
            String str = this.actions;
            int i = this.createTime;
            int i6 = this.position;
            String str2 = this.taskDesc;
            String str3 = this.taskId;
            StringBuilder sbT = androidx.appfunctions.metadata.a.t(i, "Result(actions=", str, ", createTime=", ", position=");
            sbT.append(i6);
            sbT.append(", taskDesc=");
            sbT.append(str2);
            sbT.append(", taskId=");
            return a.q(sbT, str3, ")");
        }
    }

    public SearchExperienceResult(String appName, String appVersion, String deviceType, String error, String fontSize, String pixelLevel, String query, String resolution, List<Result> result, String userId) {
        k.f(appName, "appName");
        k.f(appVersion, "appVersion");
        k.f(deviceType, "deviceType");
        k.f(error, "error");
        k.f(fontSize, "fontSize");
        k.f(pixelLevel, "pixelLevel");
        k.f(query, "query");
        k.f(resolution, "resolution");
        k.f(result, "result");
        k.f(userId, "userId");
        this.appName = appName;
        this.appVersion = appVersion;
        this.deviceType = deviceType;
        this.error = error;
        this.fontSize = fontSize;
        this.pixelLevel = pixelLevel;
        this.query = query;
        this.resolution = resolution;
        this.result = result;
        this.userId = userId;
    }

    public static /* synthetic */ SearchExperienceResult copy$default(SearchExperienceResult searchExperienceResult, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, List list, String str9, int i, Object obj) {
        if ((i & 1) != 0) {
            str = searchExperienceResult.appName;
        }
        if ((i & 2) != 0) {
            str2 = searchExperienceResult.appVersion;
        }
        if ((i & 4) != 0) {
            str3 = searchExperienceResult.deviceType;
        }
        if ((i & 8) != 0) {
            str4 = searchExperienceResult.error;
        }
        if ((i & 16) != 0) {
            str5 = searchExperienceResult.fontSize;
        }
        if ((i & 32) != 0) {
            str6 = searchExperienceResult.pixelLevel;
        }
        if ((i & 64) != 0) {
            str7 = searchExperienceResult.query;
        }
        if ((i & 128) != 0) {
            str8 = searchExperienceResult.resolution;
        }
        if ((i & 256) != 0) {
            list = searchExperienceResult.result;
        }
        if ((i & 512) != 0) {
            str9 = searchExperienceResult.userId;
        }
        List list2 = list;
        String str10 = str9;
        String str11 = str7;
        String str12 = str8;
        String str13 = str5;
        String str14 = str6;
        return searchExperienceResult.copy(str, str2, str3, str4, str13, str14, str11, str12, list2, str10);
    }

    /* renamed from: component1, reason: from getter */
    public final String getAppName() {
        return this.appName;
    }

    /* renamed from: component10, reason: from getter */
    public final String getUserId() {
        return this.userId;
    }

    /* renamed from: component2, reason: from getter */
    public final String getAppVersion() {
        return this.appVersion;
    }

    /* renamed from: component3, reason: from getter */
    public final String getDeviceType() {
        return this.deviceType;
    }

    /* renamed from: component4, reason: from getter */
    public final String getError() {
        return this.error;
    }

    /* renamed from: component5, reason: from getter */
    public final String getFontSize() {
        return this.fontSize;
    }

    /* renamed from: component6, reason: from getter */
    public final String getPixelLevel() {
        return this.pixelLevel;
    }

    /* renamed from: component7, reason: from getter */
    public final String getQuery() {
        return this.query;
    }

    /* renamed from: component8, reason: from getter */
    public final String getResolution() {
        return this.resolution;
    }

    public final List<Result> component9() {
        return this.result;
    }

    public final SearchExperienceResult copy(String appName, String appVersion, String deviceType, String error, String fontSize, String pixelLevel, String query, String resolution, List<Result> result, String userId) {
        k.f(appName, "appName");
        k.f(appVersion, "appVersion");
        k.f(deviceType, "deviceType");
        k.f(error, "error");
        k.f(fontSize, "fontSize");
        k.f(pixelLevel, "pixelLevel");
        k.f(query, "query");
        k.f(resolution, "resolution");
        k.f(result, "result");
        k.f(userId, "userId");
        return new SearchExperienceResult(appName, appVersion, deviceType, error, fontSize, pixelLevel, query, resolution, result, userId);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SearchExperienceResult)) {
            return false;
        }
        SearchExperienceResult searchExperienceResult = (SearchExperienceResult) other;
        return k.b(this.appName, searchExperienceResult.appName) && k.b(this.appVersion, searchExperienceResult.appVersion) && k.b(this.deviceType, searchExperienceResult.deviceType) && k.b(this.error, searchExperienceResult.error) && k.b(this.fontSize, searchExperienceResult.fontSize) && k.b(this.pixelLevel, searchExperienceResult.pixelLevel) && k.b(this.query, searchExperienceResult.query) && k.b(this.resolution, searchExperienceResult.resolution) && k.b(this.result, searchExperienceResult.result) && k.b(this.userId, searchExperienceResult.userId);
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

    public final String getError() {
        return this.error;
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

    public final List<Result> getResult() {
        return this.result;
    }

    public final String getUserId() {
        return this.userId;
    }

    public int hashCode() {
        return this.userId.hashCode() + androidx.appfunctions.metadata.a.e(this.result, a.c(a.c(a.c(a.c(a.c(a.c(a.c(this.appName.hashCode() * 31, 31, this.appVersion), 31, this.deviceType), 31, this.error), 31, this.fontSize), 31, this.pixelLevel), 31, this.query), 31, this.resolution), 31);
    }

    public String toString() {
        String str = this.appName;
        String str2 = this.appVersion;
        String str3 = this.deviceType;
        String str4 = this.error;
        String str5 = this.fontSize;
        String str6 = this.pixelLevel;
        String str7 = this.query;
        String str8 = this.resolution;
        List<Result> list = this.result;
        String str9 = this.userId;
        StringBuilder sbW = a.w("SearchExperienceResult(appName=", str, ", appVersion=", str2, ", deviceType=");
        androidx.constraintlayout.core.dsl.a.A(sbW, str3, ", error=", str4, ", fontSize=");
        androidx.constraintlayout.core.dsl.a.A(sbW, str5, ", pixelLevel=", str6, ", query=");
        androidx.constraintlayout.core.dsl.a.A(sbW, str7, ", resolution=", str8, ", result=");
        sbW.append(list);
        sbW.append(", userId=");
        sbW.append(str9);
        sbW.append(")");
        return sbW.toString();
    }
}
