package com.tonyodev.fetch2core.server;

import android.os.Parcel;
import android.os.Parcelable;
import com.stepos.core.ability.speech.VadSessionManager;
import com.stepos.core.common.util.TraceIdKeys;
import com.tonyodev.fetch2core.Extras;
import h0.e;
import java.io.Serializable;
import java.util.HashMap;
import kotlin.jvm.internal.g;
import v1.d;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class FileRequest implements Parcelable, Serializable {
    public static final String CATALOG_FILE = "/Catalog.json";
    public static final long CATALOG_ID = -1;
    public static final String CATALOG_NAME = "Catalog.json";
    public static final a CREATOR = new a();
    public static final String FIELD_AUTHORIZATION = "Authorization";
    public static final String FIELD_CLIENT = "Client";
    public static final String FIELD_EXTRAS = "Extras";
    public static final String FIELD_FILE_RESOURCE_ID = "FileResourceId";
    public static final String FIELD_PAGE = "Page";
    public static final String FIELD_PERSIST_CONNECTION = "Persist-Connection";
    public static final String FIELD_RANGE_END = "Range-End";
    public static final String FIELD_RANGE_START = "Range-Start";
    public static final String FIELD_SIZE = "Size";
    public static final String FIELD_TYPE = "Type";
    public static final int TYPE_CATALOG = 2;
    public static final int TYPE_FILE = 1;
    public static final int TYPE_INVALID = -1;
    public static final int TYPE_PING = 0;
    private final String authorization;
    private final String client;
    private final Extras extras;
    private final String fileResourceId;
    private final int page;
    private final boolean persistConnection;
    private final long rangeEnd;
    private final long rangeStart;
    private final int size;
    private final int type;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class a implements Parcelable.Creator<FileRequest> {
        @Override // android.os.Parcelable.Creator
        public final FileRequest createFromParcel(Parcel source) {
            g.f(source, "source");
            int i10 = source.readInt();
            String string = source.readString();
            if (string == null) {
                string = "";
            }
            long j10 = source.readLong();
            long j11 = source.readLong();
            String string2 = source.readString();
            if (string2 == null) {
                string2 = "";
            }
            String string3 = source.readString();
            if (string3 == null) {
                string3 = "";
            }
            Serializable serializable = source.readSerializable();
            g.d(serializable, "null cannot be cast to non-null type java.util.HashMap<kotlin.String, kotlin.String>");
            return new FileRequest(i10, string, j10, j11, string2, string3, new Extras((HashMap) serializable), source.readInt(), source.readInt(), source.readInt() == 1);
        }

        @Override // android.os.Parcelable.Creator
        public final FileRequest[] newArray(int i10) {
            return new FileRequest[i10];
        }
    }

    public FileRequest() {
        this(0, null, 0L, 0L, null, null, null, 0, 0, false, 1023, null);
    }

    public static /* synthetic */ FileRequest copy$default(FileRequest fileRequest, int i10, String str, long j10, long j11, String str2, String str3, Extras extras, int i11, int i12, boolean z, int i13, Object obj) {
        if ((i13 & 1) != 0) {
            i10 = fileRequest.type;
        }
        if ((i13 & 2) != 0) {
            str = fileRequest.fileResourceId;
        }
        if ((i13 & 4) != 0) {
            j10 = fileRequest.rangeStart;
        }
        if ((i13 & 8) != 0) {
            j11 = fileRequest.rangeEnd;
        }
        if ((i13 & 16) != 0) {
            str2 = fileRequest.authorization;
        }
        if ((i13 & 32) != 0) {
            str3 = fileRequest.client;
        }
        if ((i13 & 64) != 0) {
            extras = fileRequest.extras;
        }
        if ((i13 & TraceIdKeys.MAX_LENGTH) != 0) {
            i11 = fileRequest.page;
        }
        if ((i13 & 256) != 0) {
            i12 = fileRequest.size;
        }
        if ((i13 & VadSessionManager.FRAME_BYTES) != 0) {
            z = fileRequest.persistConnection;
        }
        int i14 = i12;
        boolean z3 = z;
        long j12 = j11;
        long j13 = j10;
        return fileRequest.copy(i10, str, j13, j12, str2, str3, extras, i11, i14, z3);
    }

    public final int component1() {
        return this.type;
    }

    public final boolean component10() {
        return this.persistConnection;
    }

    public final String component2() {
        return this.fileResourceId;
    }

    public final long component3() {
        return this.rangeStart;
    }

    public final long component4() {
        return this.rangeEnd;
    }

    public final String component5() {
        return this.authorization;
    }

    public final String component6() {
        return this.client;
    }

    public final Extras component7() {
        return this.extras;
    }

    public final int component8() {
        return this.page;
    }

    public final int component9() {
        return this.size;
    }

    public final FileRequest copy(int i10, String fileResourceId, long j10, long j11, String authorization, String client, Extras extras, int i11, int i12, boolean z) {
        g.f(fileResourceId, "fileResourceId");
        g.f(authorization, "authorization");
        g.f(client, "client");
        g.f(extras, "extras");
        return new FileRequest(i10, fileResourceId, j10, j11, authorization, client, extras, i11, i12, z);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FileRequest)) {
            return false;
        }
        FileRequest fileRequest = (FileRequest) obj;
        return this.type == fileRequest.type && g.b(this.fileResourceId, fileRequest.fileResourceId) && this.rangeStart == fileRequest.rangeStart && this.rangeEnd == fileRequest.rangeEnd && g.b(this.authorization, fileRequest.authorization) && g.b(this.client, fileRequest.client) && g.b(this.extras, fileRequest.extras) && this.page == fileRequest.page && this.size == fileRequest.size && this.persistConnection == fileRequest.persistConnection;
    }

    public final String getAuthorization() {
        return this.authorization;
    }

    public final String getClient() {
        return this.client;
    }

    public final Extras getExtras() {
        return this.extras;
    }

    public final String getFileResourceId() {
        return this.fileResourceId;
    }

    public final int getPage() {
        return this.page;
    }

    public final boolean getPersistConnection() {
        return this.persistConnection;
    }

    public final long getRangeEnd() {
        return this.rangeEnd;
    }

    public final long getRangeStart() {
        return this.rangeStart;
    }

    public final int getSize() {
        return this.size;
    }

    public final String getToJsonString() {
        StringBuilder sb2 = new StringBuilder("{\"Type\":");
        sb2.append(this.type);
        sb2.append(",\"FileResourceId\":");
        sb2.append("\"" + this.fileResourceId + "\"");
        sb2.append(",\"Range-Start\":");
        sb2.append(this.rangeStart);
        sb2.append(",\"Range-End\":");
        sb2.append(this.rangeEnd);
        sb2.append(",\"Authorization\":");
        sb2.append("\"" + this.authorization + "\"");
        sb2.append(",\"Client\":");
        sb2.append("\"" + this.client + "\"");
        sb2.append(",\"Extras\":");
        sb2.append(this.extras.toJSONString());
        sb2.append(",\"Page\":");
        sb2.append(this.page);
        sb2.append(",\"Size\":");
        sb2.append(this.size);
        sb2.append(",\"Persist-Connection\":");
        sb2.append(this.persistConnection);
        sb2.append('}');
        String string = sb2.toString();
        g.e(string, "toString(...)");
        return string;
    }

    public final int getType() {
        return this.type;
    }

    public int hashCode() {
        return Boolean.hashCode(this.persistConnection) + ai.onnxruntime.a.d(this.size, ai.onnxruntime.a.d(this.page, (this.extras.hashCode() + d.a(d.a(a0.a.c(a0.a.c(d.a(Integer.hashCode(this.type) * 31, 31, this.fileResourceId), this.rangeStart, 31), this.rangeEnd, 31), 31, this.authorization), 31, this.client)) * 31, 31), 31);
    }

    public String toString() {
        int i10 = this.type;
        String str = this.fileResourceId;
        long j10 = this.rangeStart;
        long j11 = this.rangeEnd;
        String str2 = this.authorization;
        String str3 = this.client;
        Extras extras = this.extras;
        int i11 = this.page;
        int i12 = this.size;
        boolean z = this.persistConnection;
        StringBuilder sbE = e.e("FileRequest(type=", i10, ", fileResourceId=", str, ", rangeStart=");
        sbE.append(j10);
        a0.a.s(j11, ", rangeEnd=", ", authorization=", sbE);
        ai.onnxruntime.a.z(sbE, str2, ", client=", str3, ", extras=");
        sbE.append(extras);
        sbE.append(", page=");
        sbE.append(i11);
        sbE.append(", size=");
        sbE.append(i12);
        sbE.append(", persistConnection=");
        sbE.append(z);
        sbE.append(")");
        return sbE.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int i10) {
        g.f(dest, "dest");
        dest.writeInt(this.type);
        dest.writeString(this.fileResourceId);
        dest.writeLong(this.rangeStart);
        dest.writeLong(this.rangeEnd);
        dest.writeString(this.authorization);
        dest.writeString(this.client);
        dest.writeSerializable(new HashMap(this.extras.getMap()));
        dest.writeInt(this.page);
        dest.writeInt(this.size);
        dest.writeInt(this.persistConnection ? 1 : 0);
    }

    public FileRequest(int i10, String fileResourceId, long j10, long j11, String authorization, String client, Extras extras, int i11, int i12, boolean z) {
        g.f(fileResourceId, "fileResourceId");
        g.f(authorization, "authorization");
        g.f(client, "client");
        g.f(extras, "extras");
        this.type = i10;
        this.fileResourceId = fileResourceId;
        this.rangeStart = j10;
        this.rangeEnd = j11;
        this.authorization = authorization;
        this.client = client;
        this.extras = extras;
        this.page = i11;
        this.size = i12;
        this.persistConnection = z;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public FileRequest(int i10, String str, long j10, long j11, String str2, String str3, Extras extras, int i11, int i12, boolean z, int i13, kotlin.jvm.internal.e eVar) {
        i10 = (i13 & 1) != 0 ? -1 : i10;
        str = (i13 & 2) != 0 ? "-1" : str;
        j10 = (i13 & 4) != 0 ? 0L : j10;
        j11 = (i13 & 8) != 0 ? -1L : j11;
        str2 = (i13 & 16) != 0 ? "" : str2;
        str3 = (i13 & 32) != 0 ? "" : str3;
        if ((i13 & 64) != 0) {
            Extras.CREATOR.getClass();
            extras = Extras.emptyExtras;
        }
        this(i10, str, j10, j11, str2, str3, extras, (i13 & TraceIdKeys.MAX_LENGTH) != 0 ? 0 : i11, (i13 & 256) != 0 ? 0 : i12, (i13 & VadSessionManager.FRAME_BYTES) != 0 ? true : z);
    }
}
