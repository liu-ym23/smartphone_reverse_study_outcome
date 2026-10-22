package com.stepos.ability.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.stepos.ailauncher.chat.trace.ChatTracker;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0010\b\u0087\b\u0018\u00002\u00020\u0001B\u008b\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\r\u0010\u0014\u001a\u00020\u0013¢\u0006\u0004\b\u0014\u0010\u0015J\u001d\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u0013¢\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u001c\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u001c\u0010\u0012J\u0012\u0010\u001d\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u001d\u0010\u0012J\u0010\u0010\u001e\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u001e\u0010\u0012J\u0010\u0010\u001f\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u001f\u0010\u0012J\u0012\u0010 \u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b \u0010\u0012J\u0012\u0010!\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b!\u0010\u0012J\u0012\u0010\"\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\"\u0010\u0012J\u0012\u0010#\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b#\u0010\u0012J\u0012\u0010$\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b$\u0010\u0012J\u0012\u0010%\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b%\u0010\u0012J\u0012\u0010&\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b&\u0010\u0012J\u0012\u0010'\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b'\u0010\u0012J\u009a\u0001\u0010(\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00022\b\b\u0002\u0010\u0006\u001a\u00020\u00022\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0002HÆ\u0001¢\u0006\u0004\b(\u0010)J\u0010\u0010*\u001a\u00020\u0013HÖ\u0001¢\u0006\u0004\b*\u0010\u0015J\u001a\u0010.\u001a\u00020-2\b\u0010,\u001a\u0004\u0018\u00010+HÖ\u0003¢\u0006\u0004\b.\u0010/R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u00100\u001a\u0004\b1\u0010\u0012R\u0019\u0010\u0004\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u00100\u001a\u0004\b2\u0010\u0012R\u0017\u0010\u0005\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0005\u00100\u001a\u0004\b3\u0010\u0012R\u0017\u0010\u0006\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0006\u00100\u001a\u0004\b4\u0010\u0012R\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0007\u00100\u001a\u0004\b5\u0010\u0012R\u0019\u0010\b\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\b\u00100\u001a\u0004\b6\u0010\u0012R\u0019\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\t\u00100\u001a\u0004\b7\u0010\u0012R\u0019\u0010\n\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\n\u00100\u001a\u0004\b8\u0010\u0012R\u0019\u0010\u000b\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u000b\u00100\u001a\u0004\b9\u0010\u0012R\u0019\u0010\f\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\f\u00100\u001a\u0004\b:\u0010\u0012R\u0019\u0010\r\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\r\u00100\u001a\u0004\b;\u0010\u0012R\u0019\u0010\u000e\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u000e\u00100\u001a\u0004\b<\u0010\u0012¨\u0006="}, d2 = {"Lcom/stepos/ability/bean/OriginalTaskConfig;", "Landroid/os/Parcelable;", "", "taskId", "parentTaskId", "name", "status", "description", "toolName", "toolParams", "resultType", "resultSrc", "resultContent", "coverUrl", "type", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "toString", "()Ljava/lang/String;", "", "describeContents", "()I", "Landroid/os/Parcel;", "dest", "flags", "LY8/t;", "writeToParcel", "(Landroid/os/Parcel;I)V", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", ChatTracker.CLICK_COPY, "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/stepos/ability/bean/OriginalTaskConfig;", "hashCode", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getTaskId", "getParentTaskId", "getName", "getStatus", "getDescription", "getToolName", "getToolParams", "getResultType", "getResultSrc", "getResultContent", "getCoverUrl", "getType", "bean_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes2.dex */
public final /* data */ class OriginalTaskConfig implements Parcelable {
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

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final class a implements Parcelable.Creator<OriginalTaskConfig> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final OriginalTaskConfig createFromParcel(Parcel parcel) {
            p.i(parcel, "parcel");
            return new OriginalTaskConfig(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString());
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final OriginalTaskConfig[] newArray(int i10) {
            return new OriginalTaskConfig[i10];
        }
    }

    public OriginalTaskConfig(String taskId, String str, String name, String status, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9) {
        p.i(taskId, "taskId");
        p.i(name, "name");
        p.i(status, "status");
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
        if ((i10 & 128) != 0) {
            str8 = originalTaskConfig.resultType;
        }
        if ((i10 & 256) != 0) {
            str9 = originalTaskConfig.resultSrc;
        }
        if ((i10 & 512) != 0) {
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

    /* renamed from: component1, reason: from getter */
    public final String getTaskId() {
        return this.taskId;
    }

    /* renamed from: component10, reason: from getter */
    public final String getResultContent() {
        return this.resultContent;
    }

    /* renamed from: component11, reason: from getter */
    public final String getCoverUrl() {
        return this.coverUrl;
    }

    /* renamed from: component12, reason: from getter */
    public final String getType() {
        return this.type;
    }

    /* renamed from: component2, reason: from getter */
    public final String getParentTaskId() {
        return this.parentTaskId;
    }

    /* renamed from: component3, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* renamed from: component4, reason: from getter */
    public final String getStatus() {
        return this.status;
    }

    /* renamed from: component5, reason: from getter */
    public final String getDescription() {
        return this.description;
    }

    /* renamed from: component6, reason: from getter */
    public final String getToolName() {
        return this.toolName;
    }

    /* renamed from: component7, reason: from getter */
    public final String getToolParams() {
        return this.toolParams;
    }

    /* renamed from: component8, reason: from getter */
    public final String getResultType() {
        return this.resultType;
    }

    /* renamed from: component9, reason: from getter */
    public final String getResultSrc() {
        return this.resultSrc;
    }

    public final OriginalTaskConfig copy(String taskId, String parentTaskId, String name, String status, String description, String toolName, String toolParams, String resultType, String resultSrc, String resultContent, String coverUrl, String type) {
        p.i(taskId, "taskId");
        p.i(name, "name");
        p.i(status, "status");
        return new OriginalTaskConfig(taskId, parentTaskId, name, status, description, toolName, toolParams, resultType, resultSrc, resultContent, coverUrl, type);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof OriginalTaskConfig)) {
            return false;
        }
        OriginalTaskConfig originalTaskConfig = (OriginalTaskConfig) other;
        return p.d(this.taskId, originalTaskConfig.taskId) && p.d(this.parentTaskId, originalTaskConfig.parentTaskId) && p.d(this.name, originalTaskConfig.name) && p.d(this.status, originalTaskConfig.status) && p.d(this.description, originalTaskConfig.description) && p.d(this.toolName, originalTaskConfig.toolName) && p.d(this.toolParams, originalTaskConfig.toolParams) && p.d(this.resultType, originalTaskConfig.resultType) && p.d(this.resultSrc, originalTaskConfig.resultSrc) && p.d(this.resultContent, originalTaskConfig.resultContent) && p.d(this.coverUrl, originalTaskConfig.coverUrl) && p.d(this.type, originalTaskConfig.type);
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
        int iHashCode2 = (((((iHashCode + (str == null ? 0 : str.hashCode())) * 31) + this.name.hashCode()) * 31) + this.status.hashCode()) * 31;
        String str2 = this.description;
        int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.toolName;
        int iHashCode4 = (iHashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.toolParams;
        int iHashCode5 = (iHashCode4 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.resultType;
        int iHashCode6 = (iHashCode5 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.resultSrc;
        int iHashCode7 = (iHashCode6 + (str6 == null ? 0 : str6.hashCode())) * 31;
        String str7 = this.resultContent;
        int iHashCode8 = (iHashCode7 + (str7 == null ? 0 : str7.hashCode())) * 31;
        String str8 = this.coverUrl;
        int iHashCode9 = (iHashCode8 + (str8 == null ? 0 : str8.hashCode())) * 31;
        String str9 = this.type;
        return iHashCode9 + (str9 != null ? str9.hashCode() : 0);
    }

    public String toString() {
        String str = this.taskId;
        String str2 = this.parentTaskId;
        String str3 = this.name;
        String str4 = this.status;
        String str5 = this.toolName;
        String str6 = this.type;
        String str7 = this.resultType;
        String str8 = this.resultSrc;
        boolean z10 = str8 == null || str8.length() == 0;
        StringBuilder sb2 = new StringBuilder();
        sb2.append("OriginalTaskConfig(taskId=");
        sb2.append(str);
        sb2.append(", parentTaskId=");
        sb2.append(str2);
        sb2.append(", name=");
        sb2.append(str3);
        sb2.append(", status=");
        sb2.append(str4);
        sb2.append(", toolName=");
        sb2.append(str5);
        sb2.append(", type=");
        sb2.append(str6);
        sb2.append(", resultType=");
        sb2.append(str7);
        sb2.append(", toolParams=<redacted>, resultContent=<redacted>, hasResultSrc=");
        sb2.append(!z10);
        sb2.append(")");
        return sb2.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel dest, int flags) {
        p.i(dest, "dest");
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

    public /* synthetic */ OriginalTaskConfig(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, int i10, i iVar) {
        this(str, (i10 & 2) != 0 ? null : str2, str3, str4, (i10 & 16) != 0 ? null : str5, (i10 & 32) != 0 ? null : str6, (i10 & 64) != 0 ? null : str7, (i10 & 128) != 0 ? null : str8, (i10 & 256) != 0 ? null : str9, (i10 & 512) != 0 ? null : str10, (i10 & 1024) != 0 ? null : str11, (i10 & 2048) != 0 ? null : str12);
    }
}
