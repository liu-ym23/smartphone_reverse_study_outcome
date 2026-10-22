package com.stepos.agentcache.ipc;

import ai.onnxruntime.a;
import android.os.Parcel;
import android.os.Parcelable;
import com.stepos.core.common.util.TraceIdKeys;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.g;
import v1.d;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class LogEventParcel implements Parcelable {
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

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class Creator implements Parcelable.Creator<LogEventParcel> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final LogEventParcel createFromParcel(Parcel parcel) {
            g.f(parcel, "parcel");
            return new LogEventParcel(parcel.readString(), parcel.readString(), parcel.readLong(), parcel.readString(), parcel.readInt(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final LogEventParcel[] newArray(int i10) {
            return new LogEventParcel[i10];
        }
    }

    public LogEventParcel(String traceId, String nodeName, long j10, String timestamp, int i10, String appName, String appVersion, String commonFieldsJson, String bizDataJson) {
        g.f(traceId, "traceId");
        g.f(nodeName, "nodeName");
        g.f(timestamp, "timestamp");
        g.f(appName, "appName");
        g.f(appVersion, "appVersion");
        g.f(commonFieldsJson, "commonFieldsJson");
        g.f(bizDataJson, "bizDataJson");
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
        if ((i11 & TraceIdKeys.MAX_LENGTH) != 0) {
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

    public final String component1() {
        return this.traceId;
    }

    public final String component2() {
        return this.nodeName;
    }

    public final long component3() {
        return this.eventTime;
    }

    public final String component4() {
        return this.timestamp;
    }

    public final int component5() {
        return this.statusCode;
    }

    public final String component6() {
        return this.appName;
    }

    public final String component7() {
        return this.appVersion;
    }

    public final String component8() {
        return this.commonFieldsJson;
    }

    public final String component9() {
        return this.bizDataJson;
    }

    public final LogEventParcel copy(String traceId, String nodeName, long j10, String timestamp, int i10, String appName, String appVersion, String commonFieldsJson, String bizDataJson) {
        g.f(traceId, "traceId");
        g.f(nodeName, "nodeName");
        g.f(timestamp, "timestamp");
        g.f(appName, "appName");
        g.f(appVersion, "appVersion");
        g.f(commonFieldsJson, "commonFieldsJson");
        g.f(bizDataJson, "bizDataJson");
        return new LogEventParcel(traceId, nodeName, j10, timestamp, i10, appName, appVersion, commonFieldsJson, bizDataJson);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LogEventParcel)) {
            return false;
        }
        LogEventParcel logEventParcel = (LogEventParcel) obj;
        return g.b(this.traceId, logEventParcel.traceId) && g.b(this.nodeName, logEventParcel.nodeName) && this.eventTime == logEventParcel.eventTime && g.b(this.timestamp, logEventParcel.timestamp) && this.statusCode == logEventParcel.statusCode && g.b(this.appName, logEventParcel.appName) && g.b(this.appVersion, logEventParcel.appVersion) && g.b(this.commonFieldsJson, logEventParcel.commonFieldsJson) && g.b(this.bizDataJson, logEventParcel.bizDataJson);
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
        return this.bizDataJson.hashCode() + d.a(d.a(d.a(a.d(this.statusCode, d.a(a0.a.c(d.a(this.traceId.hashCode() * 31, 31, this.nodeName), this.eventTime, 31), 31, this.timestamp), 31), 31, this.appName), 31, this.appVersion), 31, this.commonFieldsJson);
    }

    public String toString() {
        String str = this.traceId;
        String str2 = this.nodeName;
        long j10 = this.eventTime;
        String str3 = this.timestamp;
        int i10 = this.statusCode;
        String str4 = this.appName;
        String str5 = this.appVersion;
        String str6 = this.commonFieldsJson;
        String str7 = this.bizDataJson;
        StringBuilder sbS = a.s("LogEventParcel(traceId=", str, ", nodeName=", str2, ", eventTime=");
        a.u(j10, ", timestamp=", str3, sbS);
        sbS.append(", statusCode=");
        sbS.append(i10);
        sbS.append(", appName=");
        sbS.append(str4);
        a.z(sbS, ", appVersion=", str5, ", commonFieldsJson=", str6);
        return a.p(sbS, ", bizDataJson=", str7, ")");
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel dest, int i10) {
        g.f(dest, "dest");
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

    public /* synthetic */ LogEventParcel(String str, String str2, long j10, String str3, int i10, String str4, String str5, String str6, String str7, int i11, e eVar) {
        this(str, str2, j10, str3, i10, str4, str5, (i11 & TraceIdKeys.MAX_LENGTH) != 0 ? "{}" : str6, (i11 & 256) != 0 ? "{}" : str7);
    }
}
