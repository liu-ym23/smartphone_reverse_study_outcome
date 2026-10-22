package com.stepos.agentcache.ipc;

import a1.a;
import android.os.Parcel;
import android.os.Parcelable;
import com.stepos.agentcache.core.ServiceContract;
import kotlin.Metadata;
import m.x;
import n.f;
import q7.k;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\f\b\u0087\b\u0018\u00002\u00020\u0001B?\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\u0006\u0010\n\u001a\u00020\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u001d\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u0006¢\u0006\u0004\b\u0011\u0010\u0012J\r\u0010\u0013\u001a\u00020\u0006¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0015\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0017\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0017\u0010\u0016J\u0010\u0010\u0018\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0018\u0010\u0016J\u0010\u0010\u0019\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\u0019\u0010\u0014J\u0010\u0010\u001a\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u001a\u0010\u0016J\u0010\u0010\u001b\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u001b\u0010\u0016J\u0010\u0010\u001c\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u001c\u0010\u0016JV\u0010\u001d\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00022\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\u00022\b\b\u0002\u0010\n\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u001d\u0010\u001eJ\u0010\u0010\u001f\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u001f\u0010\u0016J\u0010\u0010 \u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b \u0010\u0014J\u001a\u0010$\u001a\u00020#2\b\u0010\"\u001a\u0004\u0018\u00010!HÖ\u0003¢\u0006\u0004\b$\u0010%R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010&\u001a\u0004\b'\u0010\u0016R\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010&\u001a\u0004\b(\u0010\u0016R\u0017\u0010\u0005\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0005\u0010&\u001a\u0004\b)\u0010\u0016R\u0017\u0010\u0007\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010*\u001a\u0004\b+\u0010\u0014R\u0017\u0010\b\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\b\u0010&\u001a\u0004\b,\u0010\u0016R\u0017\u0010\t\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\t\u0010&\u001a\u0004\b-\u0010\u0016R\u0017\u0010\n\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\n\u0010&\u001a\u0004\b.\u0010\u0016¨\u0006/"}, d2 = {"Lcom/stepos/agentcache/ipc/LogRecordParcel;", "Landroid/os/Parcelable;", "", ServiceContract.RequiredKeys.TRACE_ID, ServiceContract.RequiredKeys.NODE_NAME, "timestamp", "", "statusCode", ServiceContract.RequiredKeys.APP_NAME, ServiceContract.RequiredKeys.APP_VERSION, "messageJson", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "Landroid/os/Parcel;", "dest", "flags", "Lc7/r;", "writeToParcel", "(Landroid/os/Parcel;I)V", "describeContents", "()I", "component1", "()Ljava/lang/String;", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/stepos/agentcache/ipc/LogRecordParcel;", "toString", "hashCode", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getTraceId", "getNodeName", "getTimestamp", "I", "getStatusCode", "getAppName", "getAppVersion", "getMessageJson", "sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final /* data */ class LogRecordParcel implements Parcelable {
    public static final Parcelable.Creator<LogRecordParcel> CREATOR = new Creator();
    private final String appName;
    private final String appVersion;
    private final String messageJson;
    private final String nodeName;
    private final int statusCode;
    private final String timestamp;
    private final String traceId;

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<LogRecordParcel> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final LogRecordParcel createFromParcel(Parcel parcel) {
            k.e(parcel, "parcel");
            return new LogRecordParcel(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readInt(), parcel.readString(), parcel.readString(), parcel.readString());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final LogRecordParcel[] newArray(int i2) {
            return new LogRecordParcel[i2];
        }
    }

    public LogRecordParcel(String str, String str2, String str3, int i2, String str4, String str5, String str6) {
        k.e(str, ServiceContract.RequiredKeys.TRACE_ID);
        k.e(str2, ServiceContract.RequiredKeys.NODE_NAME);
        k.e(str3, "timestamp");
        k.e(str4, ServiceContract.RequiredKeys.APP_NAME);
        k.e(str5, ServiceContract.RequiredKeys.APP_VERSION);
        k.e(str6, "messageJson");
        this.traceId = str;
        this.nodeName = str2;
        this.timestamp = str3;
        this.statusCode = i2;
        this.appName = str4;
        this.appVersion = str5;
        this.messageJson = str6;
    }

    public static /* synthetic */ LogRecordParcel copy$default(LogRecordParcel logRecordParcel, String str, String str2, String str3, int i2, String str4, String str5, String str6, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = logRecordParcel.traceId;
        }
        if ((i10 & 2) != 0) {
            str2 = logRecordParcel.nodeName;
        }
        if ((i10 & 4) != 0) {
            str3 = logRecordParcel.timestamp;
        }
        if ((i10 & 8) != 0) {
            i2 = logRecordParcel.statusCode;
        }
        if ((i10 & 16) != 0) {
            str4 = logRecordParcel.appName;
        }
        if ((i10 & 32) != 0) {
            str5 = logRecordParcel.appVersion;
        }
        if ((i10 & 64) != 0) {
            str6 = logRecordParcel.messageJson;
        }
        String str7 = str5;
        String str8 = str6;
        String str9 = str4;
        String str10 = str3;
        return logRecordParcel.copy(str, str2, str10, i2, str9, str7, str8);
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
    public final String getTimestamp() {
        return this.timestamp;
    }

    /* renamed from: component4, reason: from getter */
    public final int getStatusCode() {
        return this.statusCode;
    }

    /* renamed from: component5, reason: from getter */
    public final String getAppName() {
        return this.appName;
    }

    /* renamed from: component6, reason: from getter */
    public final String getAppVersion() {
        return this.appVersion;
    }

    /* renamed from: component7, reason: from getter */
    public final String getMessageJson() {
        return this.messageJson;
    }

    public final LogRecordParcel copy(String traceId, String nodeName, String timestamp, int statusCode, String appName, String appVersion, String messageJson) {
        k.e(traceId, ServiceContract.RequiredKeys.TRACE_ID);
        k.e(nodeName, ServiceContract.RequiredKeys.NODE_NAME);
        k.e(timestamp, "timestamp");
        k.e(appName, ServiceContract.RequiredKeys.APP_NAME);
        k.e(appVersion, ServiceContract.RequiredKeys.APP_VERSION);
        k.e(messageJson, "messageJson");
        return new LogRecordParcel(traceId, nodeName, timestamp, statusCode, appName, appVersion, messageJson);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof LogRecordParcel)) {
            return false;
        }
        LogRecordParcel logRecordParcel = (LogRecordParcel) other;
        return k.a(this.traceId, logRecordParcel.traceId) && k.a(this.nodeName, logRecordParcel.nodeName) && k.a(this.timestamp, logRecordParcel.timestamp) && this.statusCode == logRecordParcel.statusCode && k.a(this.appName, logRecordParcel.appName) && k.a(this.appVersion, logRecordParcel.appVersion) && k.a(this.messageJson, logRecordParcel.messageJson);
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
        return this.messageJson.hashCode() + x.g(this.appVersion, x.g(this.appName, f.b(this.statusCode, x.g(this.timestamp, x.g(this.nodeName, this.traceId.hashCode() * 31, 31), 31), 31), 31), 31);
    }

    public String toString() {
        String str = this.traceId;
        String str2 = this.nodeName;
        String str3 = this.timestamp;
        int i2 = this.statusCode;
        String str4 = this.appName;
        String str5 = this.appVersion;
        String str6 = this.messageJson;
        StringBuilder sbP = a.p("LogRecordParcel(traceId=", str, ", nodeName=", str2, ", timestamp=");
        sbP.append(str3);
        sbP.append(", statusCode=");
        sbP.append(i2);
        sbP.append(", appName=");
        x.w(sbP, str4, ", appVersion=", str5, ", messageJson=");
        return a.m(sbP, str6, ")");
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel dest, int flags) {
        k.e(dest, "dest");
        dest.writeString(this.traceId);
        dest.writeString(this.nodeName);
        dest.writeString(this.timestamp);
        dest.writeInt(this.statusCode);
        dest.writeString(this.appName);
        dest.writeString(this.appVersion);
        dest.writeString(this.messageJson);
    }
}
