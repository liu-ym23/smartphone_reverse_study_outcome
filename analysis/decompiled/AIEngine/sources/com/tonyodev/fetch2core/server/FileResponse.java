package com.tonyodev.fetch2core.server;

import android.os.Parcel;
import android.os.Parcelable;
import h0.e;
import java.io.Serializable;
import java.util.Date;
import kotlin.jvm.internal.g;
import v1.d;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class FileResponse implements Parcelable, Serializable {
    public static final int CLOSE_CONNECTION = 0;
    public static final a CREATOR = new a();
    public static final String FIELD_CONNECTION = "connection";
    public static final String FIELD_CONTENT_LENGTH = "content-length";
    public static final String FIELD_DATE = "date";
    public static final String FIELD_MD5 = "md5";
    public static final String FIELD_SESSION_ID = "sessionid";
    public static final String FIELD_STATUS = "status";
    public static final String FIELD_TYPE = "type";
    public static final int OPEN_CONNECTION = 1;
    private final int connection;
    private final long contentLength;
    private final long date;
    private final String md5;
    private final String sessionId;
    private final int status;
    private final int type;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class a implements Parcelable.Creator<FileResponse> {
        @Override // android.os.Parcelable.Creator
        public final FileResponse createFromParcel(Parcel source) {
            g.f(source, "source");
            int i10 = source.readInt();
            int i11 = source.readInt();
            int i12 = source.readInt();
            long j10 = source.readLong();
            long j11 = source.readLong();
            String string = source.readString();
            if (string == null) {
                string = "";
            }
            String string2 = source.readString();
            return new FileResponse(i10, i11, i12, j10, j11, string, string2 == null ? "" : string2);
        }

        @Override // android.os.Parcelable.Creator
        public final FileResponse[] newArray(int i10) {
            return new FileResponse[i10];
        }
    }

    public FileResponse() {
        this(0, 0, 0, 0L, 0L, null, null, 127, null);
    }

    public static /* synthetic */ FileResponse copy$default(FileResponse fileResponse, int i10, int i11, int i12, long j10, long j11, String str, String str2, int i13, Object obj) {
        if ((i13 & 1) != 0) {
            i10 = fileResponse.status;
        }
        if ((i13 & 2) != 0) {
            i11 = fileResponse.type;
        }
        if ((i13 & 4) != 0) {
            i12 = fileResponse.connection;
        }
        if ((i13 & 8) != 0) {
            j10 = fileResponse.date;
        }
        if ((i13 & 16) != 0) {
            j11 = fileResponse.contentLength;
        }
        if ((i13 & 32) != 0) {
            str = fileResponse.md5;
        }
        if ((i13 & 64) != 0) {
            str2 = fileResponse.sessionId;
        }
        long j12 = j11;
        long j13 = j10;
        int i14 = i12;
        return fileResponse.copy(i10, i11, i14, j13, j12, str, str2);
    }

    public final int component1() {
        return this.status;
    }

    public final int component2() {
        return this.type;
    }

    public final int component3() {
        return this.connection;
    }

    public final long component4() {
        return this.date;
    }

    public final long component5() {
        return this.contentLength;
    }

    public final String component6() {
        return this.md5;
    }

    public final String component7() {
        return this.sessionId;
    }

    public final FileResponse copy(int i10, int i11, int i12, long j10, long j11, String md5, String sessionId) {
        g.f(md5, "md5");
        g.f(sessionId, "sessionId");
        return new FileResponse(i10, i11, i12, j10, j11, md5, sessionId);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FileResponse)) {
            return false;
        }
        FileResponse fileResponse = (FileResponse) obj;
        return this.status == fileResponse.status && this.type == fileResponse.type && this.connection == fileResponse.connection && this.date == fileResponse.date && this.contentLength == fileResponse.contentLength && g.b(this.md5, fileResponse.md5) && g.b(this.sessionId, fileResponse.sessionId);
    }

    public final int getConnection() {
        return this.connection;
    }

    public final long getContentLength() {
        return this.contentLength;
    }

    public final long getDate() {
        return this.date;
    }

    public final String getMd5() {
        return this.md5;
    }

    public final String getSessionId() {
        return this.sessionId;
    }

    public final int getStatus() {
        return this.status;
    }

    public final String getToJsonString() {
        StringBuilder sb2 = new StringBuilder("{\"Status\":");
        sb2.append(this.status);
        sb2.append(",\"Md5\":");
        sb2.append("\"" + this.md5 + "\"");
        sb2.append(",\"Connection\":");
        sb2.append(this.connection);
        sb2.append(",\"Date\":");
        sb2.append(this.date);
        sb2.append(",\"Content-Length\":");
        sb2.append(this.contentLength);
        sb2.append(",\"Type\":");
        sb2.append(this.type);
        sb2.append(",\"SessionId\":");
        sb2.append(this.sessionId);
        sb2.append('}');
        String string = sb2.toString();
        g.e(string, "toString(...)");
        return string;
    }

    public final int getType() {
        return this.type;
    }

    public int hashCode() {
        return this.sessionId.hashCode() + d.a(a0.a.c(a0.a.c(ai.onnxruntime.a.d(this.connection, ai.onnxruntime.a.d(this.type, Integer.hashCode(this.status) * 31, 31), 31), this.date, 31), this.contentLength, 31), 31, this.md5);
    }

    public String toString() {
        int i10 = this.status;
        int i11 = this.type;
        int i12 = this.connection;
        long j10 = this.date;
        long j11 = this.contentLength;
        String str = this.md5;
        String str2 = this.sessionId;
        StringBuilder sbD = e.d(i10, "FileResponse(status=", i11, ", type=", ", connection=");
        com.stepos.core.ota.d.s(sbD, i12, ", date=", j10);
        a0.a.s(j11, ", contentLength=", ", md5=", sbD);
        return com.stepos.core.ota.d.j(sbD, str, ", sessionId=", str2, ")");
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int i10) {
        g.f(dest, "dest");
        dest.writeInt(this.status);
        dest.writeInt(this.type);
        dest.writeInt(this.connection);
        dest.writeLong(this.date);
        dest.writeLong(this.contentLength);
        dest.writeString(this.md5);
        dest.writeString(this.sessionId);
    }

    public FileResponse(int i10, int i11, int i12, long j10, long j11, String md5, String sessionId) {
        g.f(md5, "md5");
        g.f(sessionId, "sessionId");
        this.status = i10;
        this.type = i11;
        this.connection = i12;
        this.date = j10;
        this.contentLength = j11;
        this.md5 = md5;
        this.sessionId = sessionId;
    }

    public /* synthetic */ FileResponse(int i10, int i11, int i12, long j10, long j11, String str, String str2, int i13, kotlin.jvm.internal.e eVar) {
        this((i13 & 1) != 0 ? 415 : i10, (i13 & 2) != 0 ? -1 : i11, (i13 & 4) != 0 ? 0 : i12, (i13 & 8) != 0 ? new Date().getTime() : j10, (i13 & 16) != 0 ? 0L : j11, (i13 & 32) != 0 ? "" : str, (i13 & 64) != 0 ? "" : str2);
    }
}
