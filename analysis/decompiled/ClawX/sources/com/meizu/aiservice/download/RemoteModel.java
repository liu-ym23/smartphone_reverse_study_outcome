package com.meizu.aiservice.download;

import a8.b;
import android.os.Parcel;
import android.os.Parcelable;
import b.a;
import java.util.List;
import java.util.Objects;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
@a
/* loaded from: classes.dex */
public final class RemoteModel implements Parcelable {
    public static final Parcelable.Creator<RemoteModel> CREATOR = new a3.a(7);
    public List<String> abilities;
    public List<String> dependencies;
    public long file_size;
    public String md5;

    @Deprecated
    public List<String> models;
    public String name;
    public String update_info;
    public long update_time;
    public String url;
    public int version_code;

    public RemoteModel() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || RemoteModel.class != obj.getClass()) {
            return false;
        }
        RemoteModel remoteModel = (RemoteModel) obj;
        if (this.version_code == remoteModel.version_code && this.file_size == remoteModel.file_size && this.update_time == remoteModel.update_time && this.name.equals(remoteModel.name) && this.models.equals(remoteModel.models) && this.url.equals(remoteModel.url) && this.md5.equals(remoteModel.md5) && this.update_info.equals(remoteModel.update_info) && this.abilities.equals(remoteModel.abilities)) {
            return Objects.equals(this.dependencies, remoteModel.dependencies);
        }
        return false;
    }

    public String getBaseModelName() {
        if (!isPlugin()) {
            return this.name;
        }
        String str = this.name;
        return str.substring(0, str.indexOf("."));
    }

    public String getPluginName() {
        String str = this.name;
        return str.substring(str.indexOf(".") + 1);
    }

    public int hashCode() {
        int iF = b.f((((this.models.hashCode() + (this.name.hashCode() * 31)) * 31) + this.version_code) * 31, 31, this.url);
        long j4 = this.file_size;
        int iF2 = b.f(b.f((iF + ((int) (j4 ^ (j4 >>> 32)))) * 31, 31, this.md5), 31, this.update_info);
        long j8 = this.update_time;
        int iHashCode = (this.abilities.hashCode() + ((iF2 + ((int) (j8 ^ (j8 >>> 32)))) * 31)) * 31;
        List<String> list = this.dependencies;
        return iHashCode + (list != null ? list.hashCode() : 0);
    }

    public boolean isPlugin() {
        return this.name.contains(".");
    }

    public String toDumpString() {
        return "version_code:" + this.version_code + "  " + this.models + "  dependencies:" + this.dependencies + "  abilities:" + this.abilities + "\n    file_size:" + this.file_size + "  md5='" + this.md5 + "'  url='" + this.url + '\'';
    }

    public String toString() {
        return "RemoteModel{name='" + this.name + "', models=" + this.models + ", version_code=" + this.version_code + ", url='" + this.url + "', file_size=" + this.file_size + ", md5='" + this.md5 + "', update_info='" + this.update_info + "', update_time=" + this.update_time + ", abilities=" + this.abilities + ", dependencies=" + this.dependencies + AbstractJsonLexerKt.END_OBJ;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i8) {
        parcel.writeString(this.name);
        parcel.writeStringList(this.models);
        parcel.writeInt(this.version_code);
        parcel.writeString(this.url);
        parcel.writeLong(this.file_size);
        parcel.writeString(this.md5);
        parcel.writeString(this.update_info);
        parcel.writeLong(this.update_time);
        parcel.writeStringList(this.abilities);
        parcel.writeStringList(this.dependencies);
    }

    public RemoteModel(Parcel parcel) {
        this.name = parcel.readString();
        this.models = parcel.createStringArrayList();
        this.version_code = parcel.readInt();
        this.url = parcel.readString();
        this.file_size = parcel.readLong();
        this.md5 = parcel.readString();
        this.update_info = parcel.readString();
        this.update_time = parcel.readLong();
        this.abilities = parcel.createStringArrayList();
        this.dependencies = parcel.createStringArrayList();
    }
}
