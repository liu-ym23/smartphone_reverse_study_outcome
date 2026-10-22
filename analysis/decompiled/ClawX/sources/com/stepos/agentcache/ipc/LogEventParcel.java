package com.stepos.agentcache.ipc;

import a8.b;
import android.os.Parcel;
import android.os.Parcelable;
import com.stepos.stepclaw.SecurePrefs;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000f\b\u0087\b\u0018\u00002\u00020\u0001BS\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\n\u001a\u00020\u0002\u0012\u0006\u0010\u000b\u001a\u00020\u0002\u0012\b\b\u0002\u0010\f\u001a\u00020\u0002\u0012\b\b\u0002\u0010\r\u001a\u00020\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u001d\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\b¢\u0006\u0004\b\u0014\u0010\u0015J\r\u0010\u0016\u001a\u00020\b¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0018\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u001a\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u001a\u0010\u0019J\u0010\u0010\u001b\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u001d\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u001d\u0010\u0019J\u0010\u0010\u001e\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\u001e\u0010\u0017J\u0010\u0010\u001f\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u001f\u0010\u0019J\u0010\u0010 \u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b \u0010\u0019J\u0010\u0010!\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b!\u0010\u0019J\u0010\u0010\"\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\"\u0010\u0019Jj\u0010#\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u00022\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\u00022\b\b\u0002\u0010\u000b\u001a\u00020\u00022\b\b\u0002\u0010\f\u001a\u00020\u00022\b\b\u0002\u0010\r\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b#\u0010$J\u0010\u0010%\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b%\u0010\u0019J\u0010\u0010&\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b&\u0010\u0017J\u001a\u0010*\u001a\u00020)2\b\u0010(\u001a\u0004\u0018\u00010'HÖ\u0003¢\u0006\u0004\b*\u0010+R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010,\u001a\u0004\b-\u0010\u0019R\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010,\u001a\u0004\b.\u0010\u0019R\u0017\u0010\u0006\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u0006\u0010/\u001a\u0004\b0\u0010\u001cR\u0017\u0010\u0007\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0007\u0010,\u001a\u0004\b1\u0010\u0019R\u0017\u0010\t\u001a\u00020\b8\u0006¢\u0006\f\n\u0004\b\t\u00102\u001a\u0004\b3\u0010\u0017R\u0017\u0010\n\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\n\u0010,\u001a\u0004\b4\u0010\u0019R\u0017\u0010\u000b\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u000b\u0010,\u001a\u0004\b5\u0010\u0019R\u0017\u0010\f\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\f\u0010,\u001a\u0004\b6\u0010\u0019R\u0017\u0010\r\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\r\u0010,\u001a\u0004\b7\u0010\u0019¨\u00068"}, d2 = {"Lcom/stepos/agentcache/ipc/LogEventParcel;", "Landroid/os/Parcelable;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "traceId", "nodeName", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "eventTime", "timestamp", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "statusCode", "appName", "appVersion", "commonFieldsJson", "bizDataJson", "<init>", "(Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "Landroid/os/Parcel;", "dest", "flags", "Lb5/a0;", "writeToParcel", "(Landroid/os/Parcel;I)V", "describeContents", "()I", "component1", "()Ljava/lang/String;", "component2", "component3", "()J", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/stepos/agentcache/ipc/LogEventParcel;", "toString", "hashCode", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "other", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getTraceId", "getNodeName", "J", "getEventTime", "getTimestamp", "I", "getStatusCode", "getAppName", "getAppVersion", "getCommonFieldsJson", "getBizDataJson", "sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
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

    /* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<LogEventParcel> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final LogEventParcel createFromParcel(Parcel parcel) {
            p.e(parcel, "parcel");
            return new LogEventParcel(parcel.readString(), parcel.readString(), parcel.readLong(), parcel.readString(), parcel.readInt(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final LogEventParcel[] newArray(int i8) {
            return new LogEventParcel[i8];
        }
    }

    public LogEventParcel(String traceId, String nodeName, long j4, String timestamp, int i8, String appName, String appVersion, String commonFieldsJson, String bizDataJson) {
        p.e(traceId, "traceId");
        p.e(nodeName, "nodeName");
        p.e(timestamp, "timestamp");
        p.e(appName, "appName");
        p.e(appVersion, "appVersion");
        p.e(commonFieldsJson, "commonFieldsJson");
        p.e(bizDataJson, "bizDataJson");
        this.traceId = traceId;
        this.nodeName = nodeName;
        this.eventTime = j4;
        this.timestamp = timestamp;
        this.statusCode = i8;
        this.appName = appName;
        this.appVersion = appVersion;
        this.commonFieldsJson = commonFieldsJson;
        this.bizDataJson = bizDataJson;
    }

    public static /* synthetic */ LogEventParcel copy$default(LogEventParcel logEventParcel, String str, String str2, long j4, String str3, int i8, String str4, String str5, String str6, String str7, int i9, Object obj) {
        if ((i9 & 1) != 0) {
            str = logEventParcel.traceId;
        }
        if ((i9 & 2) != 0) {
            str2 = logEventParcel.nodeName;
        }
        if ((i9 & 4) != 0) {
            j4 = logEventParcel.eventTime;
        }
        if ((i9 & 8) != 0) {
            str3 = logEventParcel.timestamp;
        }
        if ((i9 & 16) != 0) {
            i8 = logEventParcel.statusCode;
        }
        if ((i9 & 32) != 0) {
            str4 = logEventParcel.appName;
        }
        if ((i9 & 64) != 0) {
            str5 = logEventParcel.appVersion;
        }
        if ((i9 & 128) != 0) {
            str6 = logEventParcel.commonFieldsJson;
        }
        if ((i9 & 256) != 0) {
            str7 = logEventParcel.bizDataJson;
        }
        String str8 = str6;
        String str9 = str7;
        long j8 = j4;
        return logEventParcel.copy(str, str2, j8, str3, i8, str4, str5, str8, str9);
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
        p.e(traceId, "traceId");
        p.e(nodeName, "nodeName");
        p.e(timestamp, "timestamp");
        p.e(appName, "appName");
        p.e(appVersion, "appVersion");
        p.e(commonFieldsJson, "commonFieldsJson");
        p.e(bizDataJson, "bizDataJson");
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
        return p.a(this.traceId, logEventParcel.traceId) && p.a(this.nodeName, logEventParcel.nodeName) && this.eventTime == logEventParcel.eventTime && p.a(this.timestamp, logEventParcel.timestamp) && this.statusCode == logEventParcel.statusCode && p.a(this.appName, logEventParcel.appName) && p.a(this.appVersion, logEventParcel.appVersion) && p.a(this.commonFieldsJson, logEventParcel.commonFieldsJson) && p.a(this.bizDataJson, logEventParcel.bizDataJson);
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
        return this.bizDataJson.hashCode() + b.f(b.f(b.f(b.C(this.statusCode, b.f(b.e(b.f(this.traceId.hashCode() * 31, 31, this.nodeName), 31, this.eventTime), 31, this.timestamp), 31), 31, this.appName), 31, this.appVersion), 31, this.commonFieldsJson);
    }

    public String toString() {
        String str = this.traceId;
        String str2 = this.nodeName;
        long j4 = this.eventTime;
        String str3 = this.timestamp;
        int i8 = this.statusCode;
        String str4 = this.appName;
        String str5 = this.appVersion;
        String str6 = this.commonFieldsJson;
        String str7 = this.bizDataJson;
        StringBuilder sbV = b.v("LogEventParcel(traceId=", str, ", nodeName=", str2, ", eventTime=");
        sbV.append(j4);
        sbV.append(", timestamp=");
        sbV.append(str3);
        sbV.append(", statusCode=");
        sbV.append(i8);
        sbV.append(", appName=");
        sbV.append(str4);
        b.A(sbV, ", appVersion=", str5, ", commonFieldsJson=", str6);
        sbV.append(", bizDataJson=");
        sbV.append(str7);
        sbV.append(")");
        return sbV.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel dest, int flags) {
        p.e(dest, "dest");
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

    public /* synthetic */ LogEventParcel(String str, String str2, long j4, String str3, int i8, String str4, String str5, String str6, String str7, int i9, i iVar) {
        this(str, str2, j4, str3, i8, str4, str5, (i9 & 128) != 0 ? "{}" : str6, (i9 & 256) != 0 ? "{}" : str7);
    }
}
