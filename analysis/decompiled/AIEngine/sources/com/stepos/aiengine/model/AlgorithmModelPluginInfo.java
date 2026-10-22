package com.stepos.aiengine.model;

import a0.a;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.List;
import kotlin.collections.EmptyList;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.g;
import v1.d;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class AlgorithmModelPluginInfo implements Parcelable {
    public static final Parcelable.Creator<AlgorithmModelPluginInfo> CREATOR = new Creator();
    private final String description;
    private final List<String> files;
    private final String key;
    private final String name;
    private final long size;
    private final String type;
    private final int version;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class Creator implements Parcelable.Creator<AlgorithmModelPluginInfo> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final AlgorithmModelPluginInfo createFromParcel(Parcel parcel) {
            g.f(parcel, "parcel");
            return new AlgorithmModelPluginInfo(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readInt(), parcel.readLong(), parcel.createStringArrayList());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final AlgorithmModelPluginInfo[] newArray(int i10) {
            return new AlgorithmModelPluginInfo[i10];
        }
    }

    public AlgorithmModelPluginInfo() {
        this(null, null, null, null, 0, 0L, null, 127, null);
    }

    public static /* synthetic */ AlgorithmModelPluginInfo copy$default(AlgorithmModelPluginInfo algorithmModelPluginInfo, String str, String str2, String str3, String str4, int i10, long j10, List list, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = algorithmModelPluginInfo.type;
        }
        if ((i11 & 2) != 0) {
            str2 = algorithmModelPluginInfo.key;
        }
        if ((i11 & 4) != 0) {
            str3 = algorithmModelPluginInfo.name;
        }
        if ((i11 & 8) != 0) {
            str4 = algorithmModelPluginInfo.description;
        }
        if ((i11 & 16) != 0) {
            i10 = algorithmModelPluginInfo.version;
        }
        if ((i11 & 32) != 0) {
            j10 = algorithmModelPluginInfo.size;
        }
        if ((i11 & 64) != 0) {
            list = algorithmModelPluginInfo.files;
        }
        List list2 = list;
        long j11 = j10;
        int i12 = i10;
        String str5 = str3;
        return algorithmModelPluginInfo.copy(str, str2, str5, str4, i12, j11, list2);
    }

    public final String component1() {
        return this.type;
    }

    public final String component2() {
        return this.key;
    }

    public final String component3() {
        return this.name;
    }

    public final String component4() {
        return this.description;
    }

    public final int component5() {
        return this.version;
    }

    public final long component6() {
        return this.size;
    }

    public final List<String> component7() {
        return this.files;
    }

    public final AlgorithmModelPluginInfo copy(String type, String key, String name, String description, int i10, long j10, List<String> files) {
        g.f(type, "type");
        g.f(key, "key");
        g.f(name, "name");
        g.f(description, "description");
        g.f(files, "files");
        return new AlgorithmModelPluginInfo(type, key, name, description, i10, j10, files);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AlgorithmModelPluginInfo)) {
            return false;
        }
        AlgorithmModelPluginInfo algorithmModelPluginInfo = (AlgorithmModelPluginInfo) obj;
        return g.b(this.type, algorithmModelPluginInfo.type) && g.b(this.key, algorithmModelPluginInfo.key) && g.b(this.name, algorithmModelPluginInfo.name) && g.b(this.description, algorithmModelPluginInfo.description) && this.version == algorithmModelPluginInfo.version && this.size == algorithmModelPluginInfo.size && g.b(this.files, algorithmModelPluginInfo.files);
    }

    public final String getDescription() {
        return this.description;
    }

    public final List<String> getFiles() {
        return this.files;
    }

    public final String getKey() {
        return this.key;
    }

    public final String getName() {
        return this.name;
    }

    public final long getSize() {
        return this.size;
    }

    public final String getType() {
        return this.type;
    }

    public final int getVersion() {
        return this.version;
    }

    public int hashCode() {
        return this.files.hashCode() + a.c(ai.onnxruntime.a.d(this.version, d.a(d.a(d.a(this.type.hashCode() * 31, 31, this.key), 31, this.name), 31, this.description), 31), this.size, 31);
    }

    public String toString() {
        String str = this.type;
        String str2 = this.key;
        String str3 = this.name;
        String str4 = this.description;
        int i10 = this.version;
        long j10 = this.size;
        List<String> list = this.files;
        StringBuilder sbS = ai.onnxruntime.a.s("AlgorithmModelPluginInfo(type=", str, ", key=", str2, ", name=");
        ai.onnxruntime.a.z(sbS, str3, ", description=", str4, ", version=");
        com.stepos.core.ota.d.s(sbS, i10, ", size=", j10);
        sbS.append(", files=");
        sbS.append(list);
        sbS.append(")");
        return sbS.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel dest, int i10) {
        g.f(dest, "dest");
        dest.writeString(this.type);
        dest.writeString(this.key);
        dest.writeString(this.name);
        dest.writeString(this.description);
        dest.writeInt(this.version);
        dest.writeLong(this.size);
        dest.writeStringList(this.files);
    }

    public AlgorithmModelPluginInfo(String type, String key, String name, String description, int i10, long j10, List<String> files) {
        g.f(type, "type");
        g.f(key, "key");
        g.f(name, "name");
        g.f(description, "description");
        g.f(files, "files");
        this.type = type;
        this.key = key;
        this.name = name;
        this.description = description;
        this.version = i10;
        this.size = j10;
        this.files = files;
    }

    public AlgorithmModelPluginInfo(String str, String str2, String str3, String str4, int i10, long j10, List list, int i11, e eVar) {
        this((i11 & 1) != 0 ? "" : str, (i11 & 2) != 0 ? "" : str2, (i11 & 4) != 0 ? "" : str3, (i11 & 8) != 0 ? "" : str4, (i11 & 16) != 0 ? 0 : i10, (i11 & 32) != 0 ? 0L : j10, (i11 & 64) != 0 ? EmptyList.f10001a : list);
    }
}
