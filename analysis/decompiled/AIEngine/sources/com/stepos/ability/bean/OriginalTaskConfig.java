package com.stepos.ability.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.stepos.core.ability.speech.VadSessionManager;
import com.stepos.core.common.util.TraceIdKeys;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.g;
import v1.d;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class OriginalTaskConfig implements Parcelable {
    public static final Parcelable.Creator<OriginalTaskConfig> CREATOR = new a();
    private final String coverUrl;
    private final String description;
    private final String name;
    private final String parentTaskId;
    private final String resultContent;
    private final String resultSrc;
    private final String resultType;
    private final String status;
    private final String taskId;
    private final String toolName;
    private final String toolParams;
    private final String type;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class a implements Parcelable.Creator<OriginalTaskConfig> {
        @Override // android.os.Parcelable.Creator
        public final OriginalTaskConfig createFromParcel(Parcel parcel) {
            g.f(parcel, "parcel");
            return new OriginalTaskConfig(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString());
        }

        @Override // android.os.Parcelable.Creator
        public final OriginalTaskConfig[] newArray(int i10) {
            return new OriginalTaskConfig[i10];
        }
    }

    public OriginalTaskConfig(String taskId, String str, String name, String status, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9) {
        g.f(taskId, "taskId");
        g.f(name, "name");
        g.f(status, "status");
        this.taskId = taskId;
        this.parentTaskId = str;
        this.name = name;
        this.status = status;
        this.description = str2;
        this.toolName = str3;
        this.toolParams = str4;
        this.resultType = str5;
        this.resultSrc = str6;
        this.resultContent = str7;
        this.coverUrl = str8;
        this.type = str9;
    }

    public static /* synthetic */ OriginalTaskConfig copy$default(OriginalTaskConfig originalTaskConfig, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = originalTaskConfig.taskId;
        }
        if ((i10 & 2) != 0) {
            str2 = originalTaskConfig.parentTaskId;
        }
        if ((i10 & 4) != 0) {
            str3 = originalTaskConfig.name;
        }
        if ((i10 & 8) != 0) {
            str4 = originalTaskConfig.status;
        }
        if ((i10 & 16) != 0) {
            str5 = originalTaskConfig.description;
        }
        if ((i10 & 32) != 0) {
            str6 = originalTaskConfig.toolName;
        }
        if ((i10 & 64) != 0) {
            str7 = originalTaskConfig.toolParams;
        }
        if ((i10 & TraceIdKeys.MAX_LENGTH) != 0) {
            str8 = originalTaskConfig.resultType;
        }
        if ((i10 & 256) != 0) {
            str9 = originalTaskConfig.resultSrc;
        }
        if ((i10 & VadSessionManager.FRAME_BYTES) != 0) {
            str10 = originalTaskConfig.resultContent;
        }
        if ((i10 & 1024) != 0) {
            str11 = originalTaskConfig.coverUrl;
        }
        if ((i10 & 2048) != 0) {
            str12 = originalTaskConfig.type;
        }
        String str13 = str11;
        String str14 = str12;
        String str15 = str9;
        String str16 = str10;
        String str17 = str7;
        String str18 = str8;
        String str19 = str5;
        String str20 = str6;
        return originalTaskConfig.copy(str, str2, str3, str4, str19, str20, str17, str18, str15, str16, str13, str14);
    }

    public final String component1() {
        return this.taskId;
    }

    public final String component10() {
        return this.resultContent;
    }

    public final String component11() {
        return this.coverUrl;
    }

    public final String component12() {
        return this.type;
    }

    public final String component2() {
        return this.parentTaskId;
    }

    public final String component3() {
        return this.name;
    }

    public final String component4() {
        return this.status;
    }

    public final String component5() {
        return this.description;
    }

    public final String component6() {
        return this.toolName;
    }

    public final String component7() {
        return this.toolParams;
    }

    public final String component8() {
        return this.resultType;
    }

    public final String component9() {
        return this.resultSrc;
    }

    public final OriginalTaskConfig copy(String taskId, String str, String name, String status, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9) {
        g.f(taskId, "taskId");
        g.f(name, "name");
        g.f(status, "status");
        return new OriginalTaskConfig(taskId, str, name, status, str2, str3, str4, str5, str6, str7, str8, str9);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof OriginalTaskConfig)) {
            return false;
        }
        OriginalTaskConfig originalTaskConfig = (OriginalTaskConfig) obj;
        return g.b(this.taskId, originalTaskConfig.taskId) && g.b(this.parentTaskId, originalTaskConfig.parentTaskId) && g.b(this.name, originalTaskConfig.name) && g.b(this.status, originalTaskConfig.status) && g.b(this.description, originalTaskConfig.description) && g.b(this.toolName, originalTaskConfig.toolName) && g.b(this.toolParams, originalTaskConfig.toolParams) && g.b(this.resultType, originalTaskConfig.resultType) && g.b(this.resultSrc, originalTaskConfig.resultSrc) && g.b(this.resultContent, originalTaskConfig.resultContent) && g.b(this.coverUrl, originalTaskConfig.coverUrl) && g.b(this.type, originalTaskConfig.type);
    }

    public final String getCoverUrl() {
        return this.coverUrl;
    }

    public final String getDescription() {
        return this.description;
    }

    public final String getName() {
        return this.name;
    }

    public final String getParentTaskId() {
        return this.parentTaskId;
    }

    public final String getResultContent() {
        return this.resultContent;
    }

    public final String getResultSrc() {
        return this.resultSrc;
    }

    public final String getResultType() {
        return this.resultType;
    }

    public final String getStatus() {
        return this.status;
    }

    public final String getTaskId() {
        return this.taskId;
    }

    public final String getToolName() {
        return this.toolName;
    }

    public final String getToolParams() {
        return this.toolParams;
    }

    public final String getType() {
        return this.type;
    }

    public int hashCode() {
        int iHashCode = this.taskId.hashCode() * 31;
        String str = this.parentTaskId;
        int iA = d.a(d.a((iHashCode + (str == null ? 0 : str.hashCode())) * 31, 31, this.name), 31, this.status);
        String str2 = this.description;
        int iHashCode2 = (iA + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.toolName;
        int iHashCode3 = (iHashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.toolParams;
        int iHashCode4 = (iHashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.resultType;
        int iHashCode5 = (iHashCode4 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.resultSrc;
        int iHashCode6 = (iHashCode5 + (str6 == null ? 0 : str6.hashCode())) * 31;
        String str7 = this.resultContent;
        int iHashCode7 = (iHashCode6 + (str7 == null ? 0 : str7.hashCode())) * 31;
        String str8 = this.coverUrl;
        int iHashCode8 = (iHashCode7 + (str8 == null ? 0 : str8.hashCode())) * 31;
        String str9 = this.type;
        return iHashCode8 + (str9 != null ? str9.hashCode() : 0);
    }

    public String toString() {
        String str = this.taskId;
        String str2 = this.parentTaskId;
        String str3 = this.name;
        String str4 = this.status;
        String str5 = this.description;
        String str6 = this.toolName;
        String str7 = this.toolParams;
        String str8 = this.resultType;
        String str9 = this.resultSrc;
        String str10 = this.resultContent;
        String str11 = this.coverUrl;
        String str12 = this.type;
        StringBuilder sbS = ai.onnxruntime.a.s("OriginalTaskConfig(taskId=", str, ", parentTaskId=", str2, ", name=");
        ai.onnxruntime.a.z(sbS, str3, ", status=", str4, ", description=");
        ai.onnxruntime.a.z(sbS, str5, ", toolName=", str6, ", toolParams=");
        ai.onnxruntime.a.z(sbS, str7, ", resultType=", str8, ", resultSrc=");
        ai.onnxruntime.a.z(sbS, str9, ", resultContent=", str10, ", coverUrl=");
        return com.stepos.core.ota.d.j(sbS, str11, ", type=", str12, ")");
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel dest, int i10) {
        g.f(dest, "dest");
        dest.writeString(this.taskId);
        dest.writeString(this.parentTaskId);
        dest.writeString(this.name);
        dest.writeString(this.status);
        dest.writeString(this.description);
        dest.writeString(this.toolName);
        dest.writeString(this.toolParams);
        dest.writeString(this.resultType);
        dest.writeString(this.resultSrc);
        dest.writeString(this.resultContent);
        dest.writeString(this.coverUrl);
        dest.writeString(this.type);
    }

    public /* synthetic */ OriginalTaskConfig(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, int i10, e eVar) {
        this(str, (i10 & 2) != 0 ? null : str2, str3, str4, (i10 & 16) != 0 ? null : str5, (i10 & 32) != 0 ? null : str6, (i10 & 64) != 0 ? null : str7, (i10 & TraceIdKeys.MAX_LENGTH) != 0 ? null : str8, (i10 & 256) != 0 ? null : str9, (i10 & VadSessionManager.FRAME_BYTES) != 0 ? null : str10, (i10 & 1024) != 0 ? null : str11, (i10 & 2048) != 0 ? null : str12);
    }
}
