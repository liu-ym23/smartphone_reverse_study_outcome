package com.stepos.agentcache.ipc;

import android.os.Parcel;
import android.os.Parcelable;
import com.stepos.ailauncher.chat.trace.ChatTracker;
import com.stepos.ailauncher.foundation.appui.card.provider.didi.DidiCardProvider;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000f\b\u0087\b\u0018\u00002\u00020\u0001BS\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\n\u001a\u00020\u0002\u0012\u0006\u0010\u000b\u001a\u00020\u0002\u0012\b\b\u0002\u0010\f\u001a\u00020\u0002\u0012\b\b\u0002\u0010\r\u001a\u00020\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u001d\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\b¢\u0006\u0004\b\u0014\u0010\u0015J\r\u0010\u0016\u001a\u00020\b¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0018\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u001a\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u001a\u0010\u0019J\u0010\u0010\u001b\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u001d\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u001d\u0010\u0019J\u0010\u0010\u001e\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\u001e\u0010\u0017J\u0010\u0010\u001f\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u001f\u0010\u0019J\u0010\u0010 \u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b \u0010\u0019J\u0010\u0010!\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b!\u0010\u0019J\u0010\u0010\"\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\"\u0010\u0019Jj\u0010#\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u00022\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\u00022\b\b\u0002\u0010\u000b\u001a\u00020\u00022\b\b\u0002\u0010\f\u001a\u00020\u00022\b\b\u0002\u0010\r\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b#\u0010$J\u0010\u0010%\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b%\u0010\u0019J\u0010\u0010&\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b&\u0010\u0017J\u001a\u0010*\u001a\u00020)2\b\u0010(\u001a\u0004\u0018\u00010'HÖ\u0003¢\u0006\u0004\b*\u0010+R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010,\u001a\u0004\b-\u0010\u0019R\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010,\u001a\u0004\b.\u0010\u0019R\u0017\u0010\u0006\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u0006\u0010/\u001a\u0004\b0\u0010\u001cR\u0017\u0010\u0007\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0007\u0010,\u001a\u0004\b1\u0010\u0019R\u0017\u0010\t\u001a\u00020\b8\u0006¢\u0006\f\n\u0004\b\t\u00102\u001a\u0004\b3\u0010\u0017R\u0017\u0010\n\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\n\u0010,\u001a\u0004\b4\u0010\u0019R\u0017\u0010\u000b\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u000b\u0010,\u001a\u0004\b5\u0010\u0019R\u0017\u0010\f\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\f\u0010,\u001a\u0004\b6\u0010\u0019R\u0017\u0010\r\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\r\u0010,\u001a\u0004\b7\u0010\u0019¨\u00068"}, d2 = {"Lcom/stepos/agentcache/ipc/LogEventParcel;", "Landroid/os/Parcelable;", "", DidiCardProvider.KEY_TRACE_ID, "nodeName", "", "eventTime", "timestamp", "", "statusCode", "appName", "appVersion", "commonFieldsJson", "bizDataJson", "<init>", "(Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "Landroid/os/Parcel;", "dest", "flags", "LY8/t;", "writeToParcel", "(Landroid/os/Parcel;I)V", "describeContents", "()I", "component1", "()Ljava/lang/String;", "component2", "component3", "()J", "component4", "component5", "component6", "component7", "component8", "component9", ChatTracker.CLICK_COPY, "(Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/stepos/agentcache/ipc/LogEventParcel;", "toString", "hashCode", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getTraceId", "getNodeName", "J", "getEventTime", "getTimestamp", "I", "getStatusCode", "getAppName", "getAppVersion", "getCommonFieldsJson", "getBizDataJson", "sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes2.dex */
public final /* data */ class LogEventParcel implements Parcelable {
    public static final Parcelable.Creator<LogEventParcel> CREATOR = new Creator();
    private final String appName;
    private final String appVersion;
    private final String bizDataJson;
    private final String commonFieldsJson;
    private final long eventTime;
    private final String nodeName;
    private final int statusCode;
    private final String timestamp;
    private final String traceId;

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<LogEventParcel> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final LogEventParcel createFromParcel(Parcel parcel) {
            p.i(parcel, "parcel");
            return new LogEventParcel(parcel.readString(), parcel.readString(), parcel.readLong(), parcel.readString(), parcel.readInt(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final LogEventParcel[] newArray(int i10) {
            return new LogEventParcel[i10];
        }
    }

    public LogEventParcel(String traceId, String nodeName, long j10, String timestamp, int i10, String appName, String appVersion, String commonFieldsJson, String bizDataJson) {
        p.i(traceId, "traceId");
        p.i(nodeName, "nodeName");
        p.i(timestamp, "timestamp");
        p.i(appName, "appName");
        p.i(appVersion, "appVersion");
        p.i(commonFieldsJson, "commonFieldsJson");
        p.i(bizDataJson, "bizDataJson");
        this.traceId = traceId;
        this.nodeName = nodeName;
        this.eventTime = j10;
        this.timestamp = timestamp;
        this.statusCode = i10;
        this.appName = appName;
        this.appVersion = appVersion;
        this.commonFieldsJson = commonFieldsJson;
        this.bizDataJson = bizDataJson;
    }

    public static /* synthetic */ LogEventParcel copy$default(LogEventParcel logEventParcel, String str, String str2, long j10, String str3, int i10, String str4, String str5, String str6, String str7, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = logEventParcel.traceId;
        }
        if ((i11 & 2) != 0) {
            str2 = logEventParcel.nodeName;
        }
        if ((i11 & 4) != 0) {
            j10 = logEventParcel.eventTime;
        }
        if ((i11 & 8) != 0) {
            str3 = logEventParcel.timestamp;
        }
        if ((i11 & 16) != 0) {
            i10 = logEventParcel.statusCode;
        }
        if ((i11 & 32) != 0) {
            str4 = logEventParcel.appName;
        }
        if ((i11 & 64) != 0) {
            str5 = logEventParcel.appVersion;
        }
        if ((i11 & 128) != 0) {
            str6 = logEventParcel.commonFieldsJson;
        }
        if ((i11 & 256) != 0) {
            str7 = logEventParcel.bizDataJson;
        }
        String str8 = str6;
        String str9 = str7;
        long j11 = j10;
        return logEventParcel.copy(str, str2, j11, str3, i10, str4, str5, str8, str9);
    }

    /* renamed from: component1, reason: from getter */
    public final String getTraceId() {
        return this.traceId;
    }

    /* renamed from: component2, reason: from getter */
    public final String getNodeName() {
        return this.nodeName;
    }

    /* renamed from: component3, reason: from getter */
    public final long getEventTime() {
        return this.eventTime;
    }

    /* renamed from: component4, reason: from getter */
    public final String getTimestamp() {
        return this.timestamp;
    }

    /* renamed from: component5, reason: from getter */
    public final int getStatusCode() {
        return this.statusCode;
    }

    /* renamed from: component6, reason: from getter */
    public final String getAppName() {
        return this.appName;
    }

    /* renamed from: component7, reason: from getter */
    public final String getAppVersion() {
        return this.appVersion;
    }

    /* renamed from: component8, reason: from getter */
    public final String getCommonFieldsJson() {
        return this.commonFieldsJson;
    }

    /* renamed from: component9, reason: from getter */
    public final String getBizDataJson() {
        return this.bizDataJson;
    }

    public final LogEventParcel copy(String traceId, String nodeName, long eventTime, String timestamp, int statusCode, String appName, String appVersion, String commonFieldsJson, String bizDataJson) {
        p.i(traceId, "traceId");
        p.i(nodeName, "nodeName");
        p.i(timestamp, "timestamp");
        p.i(appName, "appName");
        p.i(appVersion, "appVersion");
        p.i(commonFieldsJson, "commonFieldsJson");
        p.i(bizDataJson, "bizDataJson");
        return new LogEventParcel(traceId, nodeName, eventTime, timestamp, statusCode, appName, appVersion, commonFieldsJson, bizDataJson);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof LogEventParcel)) {
            return false;
        }
        LogEventParcel logEventParcel = (LogEventParcel) other;
        return p.d(this.traceId, logEventParcel.traceId) && p.d(this.nodeName, logEventParcel.nodeName) && this.eventTime == logEventParcel.eventTime && p.d(this.timestamp, logEventParcel.timestamp) && this.statusCode == logEventParcel.statusCode && p.d(this.appName, logEventParcel.appName) && p.d(this.appVersion, logEventParcel.appVersion) && p.d(this.commonFieldsJson, logEventParcel.commonFieldsJson) && p.d(this.bizDataJson, logEventParcel.bizDataJson);
    }

    public final String getAppName() {
        return this.appName;
    }

    public final String getAppVersion() {
        return this.appVersion;
    }

    public final String getBizDataJson() {
        return this.bizDataJson;
    }

    public final String getCommonFieldsJson() {
        return this.commonFieldsJson;
    }

    public final long getEventTime() {
        return this.eventTime;
    }

    public final String getNodeName() {
        return this.nodeName;
    }

    public final int getStatusCode() {
        return this.statusCode;
    }

    public final String getTimestamp() {
        return this.timestamp;
    }

    public final String getTraceId() {
        return this.traceId;
    }

    public int hashCode() {
        return (((((((((((((((this.traceId.hashCode() * 31) + this.nodeName.hashCode()) * 31) + Long.hashCode(this.eventTime)) * 31) + this.timestamp.hashCode()) * 31) + Integer.hashCode(this.statusCode)) * 31) + this.appName.hashCode()) * 31) + this.appVersion.hashCode()) * 31) + this.commonFieldsJson.hashCode()) * 31) + this.bizDataJson.hashCode();
    }

    public String toString() {
        return "LogEventParcel(traceId=" + this.traceId + ", nodeName=" + this.nodeName + ", eventTime=" + this.eventTime + ", timestamp=" + this.timestamp + ", statusCode=" + this.statusCode + ", appName=" + this.appName + ", appVersion=" + this.appVersion + ", commonFieldsJson=" + this.commonFieldsJson + ", bizDataJson=" + this.bizDataJson + ")";
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel dest, int flags) {
        p.i(dest, "dest");
        dest.writeString(this.traceId);
        dest.writeString(this.nodeName);
        dest.writeLong(this.eventTime);
        dest.writeString(this.timestamp);
        dest.writeInt(this.statusCode);
        dest.writeString(this.appName);
        dest.writeString(this.appVersion);
        dest.writeString(this.commonFieldsJson);
        dest.writeString(this.bizDataJson);
    }

    public /* synthetic */ LogEventParcel(String str, String str2, long j10, String str3, int i10, String str4, String str5, String str6, String str7, int i11, i iVar) {
        this(str, str2, j10, str3, i10, str4, str5, (i11 & 128) != 0 ? "{}" : str6, (i11 & 256) != 0 ? "{}" : str7);
    }
}
