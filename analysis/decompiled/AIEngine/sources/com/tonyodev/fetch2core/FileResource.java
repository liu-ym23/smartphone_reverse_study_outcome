package com.tonyodev.fetch2core;

import android.os.Parcel;
import android.os.Parcelable;
import java.io.Serializable;
import java.util.HashMap;
import kotlin.jvm.internal.g;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class FileResource implements Parcelable, Serializable {
    public static final a CREATOR = new a();
    private Extras extras;

    /* renamed from: id, reason: collision with root package name */
    private long f8217id;
    private long length;
    private String md5;
    private String file = "";
    private String name = "";

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class a implements Parcelable.Creator<FileResource> {
        @Override // android.os.Parcelable.Creator
        public final FileResource createFromParcel(Parcel source) {
            g.f(source, "source");
            FileResource fileResource = new FileResource();
            fileResource.setId(source.readLong());
            String string = source.readString();
            if (string == null) {
                string = "";
            }
            fileResource.setName(string);
            fileResource.setLength(source.readLong());
            String string2 = source.readString();
            if (string2 == null) {
                string2 = "";
            }
            fileResource.setFile(string2);
            Serializable serializable = source.readSerializable();
            g.d(serializable, "null cannot be cast to non-null type java.util.HashMap<kotlin.String, kotlin.String>");
            fileResource.setExtras(new Extras((HashMap) serializable));
            String string3 = source.readString();
            fileResource.setMd5(string3 != null ? string3 : "");
            return fileResource;
        }

        @Override // android.os.Parcelable.Creator
        public final FileResource[] newArray(int i10) {
            return new FileResource[i10];
        }
    }

    public FileResource() {
        Extras.CREATOR.getClass();
        this.extras = Extras.emptyExtras;
        this.md5 = "";
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!FileResource.class.equals(obj != null ? obj.getClass() : null)) {
            return false;
        }
        g.d(obj, "null cannot be cast to non-null type com.tonyodev.fetch2core.FileResource");
        FileResource fileResource = (FileResource) obj;
        return this.f8217id == fileResource.f8217id && this.length == fileResource.length && g.b(this.file, fileResource.file) && g.b(this.name, fileResource.name) && g.b(this.extras, fileResource.extras) && g.b(this.md5, fileResource.md5);
    }

    public final Extras getExtras() {
        return this.extras;
    }

    public final String getFile() {
        return this.file;
    }

    public final long getId() {
        return this.f8217id;
    }

    public final long getLength() {
        return this.length;
    }

    public final String getMd5() {
        return this.md5;
    }

    public final String getName() {
        return this.name;
    }

    public int hashCode() {
        return this.md5.hashCode() + ((this.extras.hashCode() + v1.d.a(v1.d.a(a0.a.c(Long.hashCode(this.f8217id) * 31, this.length, 31), 31, this.file), 31, this.name)) * 31);
    }

    public final void setExtras(Extras value) {
        g.f(value, "value");
        this.extras = value.copy();
    }

    public final void setFile(String str) {
        g.f(str, "<set-?>");
        this.file = str;
    }

    public final void setId(long j10) {
        this.f8217id = j10;
    }

    public final void setLength(long j10) {
        this.length = j10;
    }

    public final void setMd5(String str) {
        g.f(str, "<set-?>");
        this.md5 = str;
    }

    public final void setName(String str) {
        g.f(str, "<set-?>");
        this.name = str;
    }

    public String toString() {
        long j10 = this.f8217id;
        long j11 = this.length;
        String str = this.file;
        String str2 = this.name;
        Extras extras = this.extras;
        String str3 = this.md5;
        StringBuilder sbQ = ai.onnxruntime.a.q(j10, "FileResource(id=", ", length=");
        ai.onnxruntime.a.u(j11, ", file='", str, sbQ);
        sbQ.append("', name='");
        sbQ.append(str2);
        sbQ.append("', extras='");
        sbQ.append(extras);
        return ai.onnxruntime.a.p(sbQ, "', md5='", str3, "')");
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int i10) {
        g.f(dest, "dest");
        dest.writeLong(this.f8217id);
        dest.writeString(this.name);
        dest.writeLong(this.length);
        dest.writeString(this.file);
        dest.writeSerializable(new HashMap(this.extras.getMap()));
        dest.writeString(this.md5);
    }
}
