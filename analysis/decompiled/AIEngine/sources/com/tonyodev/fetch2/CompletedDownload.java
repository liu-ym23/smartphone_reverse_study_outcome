package com.tonyodev.fetch2;

import android.os.Parcel;
import android.os.Parcelable;
import com.tonyodev.fetch2core.Extras;
import java.io.Serializable;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import kotlin.collections.b;
import kotlin.jvm.internal.g;
import v1.d;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public class CompletedDownload implements Parcelable, Serializable {
    public static final a CREATOR = new a();
    private Extras extras;
    private long fileByteSize;
    private int group;
    private long identifier;
    private String tag;
    private String url = "";
    private String file = "";
    private Map<String, String> headers = b.d0();
    private long created = Calendar.getInstance().getTimeInMillis();

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class a implements Parcelable.Creator<CompletedDownload> {
        @Override // android.os.Parcelable.Creator
        public final CompletedDownload createFromParcel(Parcel source) {
            g.f(source, "source");
            String string = source.readString();
            if (string == null) {
                string = "";
            }
            String string2 = source.readString();
            String str = string2 != null ? string2 : "";
            int i10 = source.readInt();
            long j10 = source.readLong();
            Serializable serializable = source.readSerializable();
            g.d(serializable, "null cannot be cast to non-null type kotlin.collections.Map<kotlin.String, kotlin.String>");
            String string3 = source.readString();
            long j11 = source.readLong();
            long j12 = source.readLong();
            Serializable serializable2 = source.readSerializable();
            g.d(serializable2, "null cannot be cast to non-null type kotlin.collections.Map<kotlin.String, kotlin.String>");
            CompletedDownload completedDownload = new CompletedDownload();
            completedDownload.setUrl(string);
            completedDownload.setFile(str);
            completedDownload.setGroup(i10);
            completedDownload.setFileByteSize(j10);
            completedDownload.setHeaders((Map) serializable);
            completedDownload.setTag(string3);
            completedDownload.setIdentifier(j11);
            completedDownload.setCreated(j12);
            completedDownload.setExtras(new Extras((Map) serializable2));
            return completedDownload;
        }

        @Override // android.os.Parcelable.Creator
        public final CompletedDownload[] newArray(int i10) {
            return new CompletedDownload[i10];
        }
    }

    public CompletedDownload() {
        Extras.CREATOR.getClass();
        this.extras = Extras.emptyExtras;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!getClass().equals(obj != null ? obj.getClass() : null)) {
            return false;
        }
        g.d(obj, "null cannot be cast to non-null type com.tonyodev.fetch2.CompletedDownload");
        CompletedDownload completedDownload = (CompletedDownload) obj;
        return g.b(this.url, completedDownload.url) && g.b(this.file, completedDownload.file) && this.group == completedDownload.group && g.b(this.headers, completedDownload.headers) && g.b(this.tag, completedDownload.tag) && this.identifier == completedDownload.identifier && this.created == completedDownload.created && g.b(this.extras, completedDownload.extras);
    }

    public final long getCreated() {
        return this.created;
    }

    public final Extras getExtras() {
        return this.extras;
    }

    public final String getFile() {
        return this.file;
    }

    public final long getFileByteSize() {
        return this.fileByteSize;
    }

    public final int getGroup() {
        return this.group;
    }

    public final Map<String, String> getHeaders() {
        return this.headers;
    }

    public final long getIdentifier() {
        return this.identifier;
    }

    public final String getTag() {
        return this.tag;
    }

    public final String getUrl() {
        return this.url;
    }

    public int hashCode() {
        int iHashCode = (this.headers.hashCode() + ((d.a(this.url.hashCode() * 31, 31, this.file) + this.group) * 31)) * 31;
        String str = this.tag;
        return this.extras.hashCode() + a0.a.c(a0.a.c((iHashCode + (str != null ? str.hashCode() : 0)) * 31, this.identifier, 31), this.created, 31);
    }

    public final void setCreated(long j10) {
        this.created = j10;
    }

    public final void setExtras(Extras extras) {
        g.f(extras, "<set-?>");
        this.extras = extras;
    }

    public final void setFile(String str) {
        g.f(str, "<set-?>");
        this.file = str;
    }

    public final void setFileByteSize(long j10) {
        this.fileByteSize = j10;
    }

    public final void setGroup(int i10) {
        this.group = i10;
    }

    public final void setHeaders(Map<String, String> map) {
        g.f(map, "<set-?>");
        this.headers = map;
    }

    public final void setIdentifier(long j10) {
        this.identifier = j10;
    }

    public final void setTag(String str) {
        this.tag = str;
    }

    public final void setUrl(String str) {
        g.f(str, "<set-?>");
        this.url = str;
    }

    public String toString() {
        String str = this.url;
        String str2 = this.file;
        int i10 = this.group;
        Map<String, String> map = this.headers;
        String str3 = this.tag;
        long j10 = this.identifier;
        long j11 = this.created;
        Extras extras = this.extras;
        StringBuilder sbS = ai.onnxruntime.a.s("CompletedDownload(url='", str, "', file='", str2, "', groupId=");
        sbS.append(i10);
        sbS.append(", headers=");
        sbS.append(map);
        sbS.append(", tag=");
        com.stepos.core.ota.d.p(j10, str3, ", identifier=", sbS);
        a0.a.s(j11, ", created=", ", extras=", sbS);
        sbS.append(extras);
        sbS.append(")");
        return sbS.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int i10) {
        g.f(dest, "dest");
        dest.writeString(this.url);
        dest.writeString(this.file);
        dest.writeInt(this.group);
        dest.writeLong(this.fileByteSize);
        dest.writeSerializable(new HashMap(this.headers));
        dest.writeString(this.tag);
        dest.writeLong(this.identifier);
        dest.writeLong(this.created);
        dest.writeSerializable(new HashMap(this.extras.getMap()));
    }
}
