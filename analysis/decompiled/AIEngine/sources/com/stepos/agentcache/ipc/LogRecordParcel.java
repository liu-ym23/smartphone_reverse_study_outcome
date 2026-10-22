package com.stepos.agentcache.ipc;

import ai.onnxruntime.a;
import android.os.Parcel;
import android.os.Parcelable;
import kotlin.jvm.internal.g;
import v1.d;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class LogRecordParcel implements Parcelable {
    public static final Parcelable.Creator<LogRecordParcel> CREATOR = new Creator();
    private final String appName;
    private final String appVersion;
    private final String messageJson;
    private final String nodeName;
    private final int statusCode;
    private final String timestamp;
    private final String traceId;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class Creator implements Parcelable.Creator<LogRecordParcel> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final LogRecordParcel createFromParcel(Parcel parcel) {
            g.f(parcel, "parcel");
            return new LogRecordParcel(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readInt(), parcel.readString(), parcel.readString(), parcel.readString());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final LogRecordParcel[] newArray(int i10) {
            return new LogRecordParcel[i10];
        }
    }

    public LogRecordParcel(String traceId, String nodeName, String timestamp, int i10, String appName, String appVersion, String messageJson) {
        g.f(traceId, "traceId");
        g.f(nodeName, "nodeName");
        g.f(timestamp, "timestamp");
        g.f(appName, "appName");
        g.f(appVersion, "appVersion");
        g.f(messageJson, "messageJson");
        this.traceId = traceId;
        this.nodeName = nodeName;
        this.timestamp = timestamp;
        this.statusCode = i10;
        this.appName = appName;
        this.appVersion = appVersion;
        this.messageJson = messageJson;
    }

    public static /* synthetic */ LogRecordParcel copy$default(LogRecordParcel logRecordParcel, String str, String str2, String str3, int i10, String str4, String str5, String str6, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = logRecordParcel.traceId;
        }
        if ((i11 & 2) != 0) {
            str2 = logRecordParcel.nodeName;
        }
        if ((i11 & 4) != 0) {
            str3 = logRecordParcel.timestamp;
        }
        if ((i11 & 8) != 0) {
            i10 = logRecordParcel.statusCode;
        }
        if ((i11 & 16) != 0) {
            str4 = logRecordParcel.appName;
        }
        if ((i11 & 32) != 0) {
            str5 = logRecordParcel.appVersion;
        }
        if ((i11 & 64) != 0) {
            str6 = logRecordParcel.messageJson;
        }
        String str7 = str5;
        String str8 = str6;
        String str9 = str4;
        String str10 = str3;
        return logRecordParcel.copy(str, str2, str10, i10, str9, str7, str8);
    }

    public final String component1() {
        return this.traceId;
    }

    public final String component2() {
        return this.nodeName;
    }

    public final String component3() {
        return this.timestamp;
    }

    public final int component4() {
        return this.statusCode;
    }

    public final String component5() {
        return this.appName;
    }

    public final String component6() {
        return this.appVersion;
    }

    public final String component7() {
        return this.messageJson;
    }

    public final LogRecordParcel copy(String traceId, String nodeName, String timestamp, int i10, String appName, String appVersion, String messageJson) {
        g.f(traceId, "traceId");
        g.f(nodeName, "nodeName");
        g.f(timestamp, "timestamp");
        g.f(appName, "appName");
        g.f(appVersion, "appVersion");
        g.f(messageJson, "messageJson");
        return new LogRecordParcel(traceId, nodeName, timestamp, i10, appName, appVersion, messageJson);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LogRecordParcel)) {
            return false;
        }
        LogRecordParcel logRecordParcel = (LogRecordParcel) obj;
        return g.b(this.traceId, logRecordParcel.traceId) && g.b(this.nodeName, logRecordParcel.nodeName) && g.b(this.timestamp, logRecordParcel.timestamp) && this.statusCode == logRecordParcel.statusCode && g.b(this.appName, logRecordParcel.appName) && g.b(this.appVersion, logRecordParcel.appVersion) && g.b(this.messageJson, logRecordParcel.messageJson);
    }

    public final String getAppName() {
        return this.appName;
    }

    public final String getAppVersion() {
        return this.appVersion;
    }

    public final String getMessageJson() {
        return this.messageJson;
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
        return this.messageJson.hashCode() + d.a(d.a(a.d(this.statusCode, d.a(d.a(this.traceId.hashCode() * 31, 31, this.nodeName), 31, this.timestamp), 31), 31, this.appName), 31, this.appVersion);
    }

    public String toString() {
        String str = this.traceId;
        String str2 = this.nodeName;
        String str3 = this.timestamp;
        int i10 = this.statusCode;
        String str4 = this.appName;
        String str5 = this.appVersion;
        String str6 = this.messageJson;
        StringBuilder sbS = a.s("LogRecordParcel(traceId=", str, ", nodeName=", str2, ", timestamp=");
        com.stepos.core.ota.d.o(i10, str3, ", statusCode=", ", appName=", sbS);
        a.z(sbS, str4, ", appVersion=", str5, ", messageJson=");
        return a.o(sbS, str6, ")");
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel dest, int i10) {
        g.f(dest, "dest");
        dest.writeString(this.traceId);
        dest.writeString(this.nodeName);
        dest.writeString(this.timestamp);
        dest.writeInt(this.statusCode);
        dest.writeString(this.appName);
        dest.writeString(this.appVersion);
        dest.writeString(this.messageJson);
    }
}
