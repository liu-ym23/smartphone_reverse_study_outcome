package com.stepos.aiengine.model;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.appfunctions.metadata.a;
import androidx.autofill.HintConstants;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.EmptyList;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000e\b\u0087\b\u0018\u00002\u00020\u0001BS\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0002\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007\u0012\b\b\u0002\u0010\n\u001a\u00020\t\u0012\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00020\u000b¢\u0006\u0004\b\r\u0010\u000eJ\u001d\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u0007¢\u0006\u0004\b\u0013\u0010\u0014J\r\u0010\u0015\u001a\u00020\u0007¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0017\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u0019\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0019\u0010\u0018J\u0010\u0010\u001a\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u001a\u0010\u0018J\u0010\u0010\u001b\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u001b\u0010\u0018J\u0010\u0010\u001c\u001a\u00020\u0007HÆ\u0003¢\u0006\u0004\b\u001c\u0010\u0016J\u0010\u0010\u001d\u001a\u00020\tHÆ\u0003¢\u0006\u0004\b\u001d\u0010\u001eJ\u0016\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00020\u000bHÆ\u0003¢\u0006\u0004\b\u001f\u0010 J\\\u0010!\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00022\b\b\u0002\u0010\u0006\u001a\u00020\u00022\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\n\u001a\u00020\t2\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00020\u000bHÆ\u0001¢\u0006\u0004\b!\u0010\"J\u0010\u0010#\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b#\u0010\u0018J\u0010\u0010$\u001a\u00020\u0007HÖ\u0001¢\u0006\u0004\b$\u0010\u0016J\u001a\u0010(\u001a\u00020'2\b\u0010&\u001a\u0004\u0018\u00010%HÖ\u0003¢\u0006\u0004\b(\u0010)R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010*\u001a\u0004\b+\u0010\u0018R\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010*\u001a\u0004\b,\u0010\u0018R\u0017\u0010\u0005\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0005\u0010*\u001a\u0004\b-\u0010\u0018R\u0017\u0010\u0006\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0006\u0010*\u001a\u0004\b.\u0010\u0018R\u0017\u0010\b\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\b\u0010/\u001a\u0004\b0\u0010\u0016R\u0017\u0010\n\u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b\n\u00101\u001a\u0004\b2\u0010\u001eR\u001d\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00020\u000b8\u0006¢\u0006\f\n\u0004\b\f\u00103\u001a\u0004\b4\u0010 ¨\u00065"}, d2 = {"Lcom/stepos/aiengine/model/AlgorithmModelPluginInfo;", "Landroid/os/Parcelable;", "", "type", "key", HintConstants.AUTOFILL_HINT_NAME, "description", "", "version", "", "size", "", "files", AppAgent.CONSTRUCT, "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IJLjava/util/List;)V", "Landroid/os/Parcel;", "dest", "flags", "LC7/r;", "writeToParcel", "(Landroid/os/Parcel;I)V", "describeContents", "()I", "component1", "()Ljava/lang/String;", "component2", "component3", "component4", "component5", "component6", "()J", "component7", "()Ljava/util/List;", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IJLjava/util/List;)Lcom/stepos/aiengine/model/AlgorithmModelPluginInfo;", "toString", "hashCode", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getType", "getKey", "getName", "getDescription", "I", "getVersion", "J", "getSize", "Ljava/util/List;", "getFiles", "shared-lib_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class AlgorithmModelPluginInfo implements Parcelable {
    public static final Parcelable.Creator<AlgorithmModelPluginInfo> CREATOR = new Creator();
    private final String description;
    private final List<String> files;
    private final String key;
    private final String name;
    private final long size;
    private final String type;
    private final int version;

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<AlgorithmModelPluginInfo> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final AlgorithmModelPluginInfo createFromParcel(Parcel parcel) {
            k.f(parcel, "parcel");
            return new AlgorithmModelPluginInfo(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readInt(), parcel.readLong(), parcel.createStringArrayList());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final AlgorithmModelPluginInfo[] newArray(int i) {
            return new AlgorithmModelPluginInfo[i];
        }
    }

    public AlgorithmModelPluginInfo() {
        this(null, null, null, null, 0, 0L, null, 127, null);
    }

    public static /* synthetic */ AlgorithmModelPluginInfo copy$default(AlgorithmModelPluginInfo algorithmModelPluginInfo, String str, String str2, String str3, String str4, int i, long j5, List list, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            str = algorithmModelPluginInfo.type;
        }
        if ((i6 & 2) != 0) {
            str2 = algorithmModelPluginInfo.key;
        }
        if ((i6 & 4) != 0) {
            str3 = algorithmModelPluginInfo.name;
        }
        if ((i6 & 8) != 0) {
            str4 = algorithmModelPluginInfo.description;
        }
        if ((i6 & 16) != 0) {
            i = algorithmModelPluginInfo.version;
        }
        if ((i6 & 32) != 0) {
            j5 = algorithmModelPluginInfo.size;
        }
        if ((i6 & 64) != 0) {
            list = algorithmModelPluginInfo.files;
        }
        List list2 = list;
        long j6 = j5;
        int i10 = i;
        String str5 = str3;
        return algorithmModelPluginInfo.copy(str, str2, str5, str4, i10, j6, list2);
    }

    /* renamed from: component1, reason: from getter */
    public final String getType() {
        return this.type;
    }

    /* renamed from: component2, reason: from getter */
    public final String getKey() {
        return this.key;
    }

    /* renamed from: component3, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* renamed from: component4, reason: from getter */
    public final String getDescription() {
        return this.description;
    }

    /* renamed from: component5, reason: from getter */
    public final int getVersion() {
        return this.version;
    }

    /* renamed from: component6, reason: from getter */
    public final long getSize() {
        return this.size;
    }

    public final List<String> component7() {
        return this.files;
    }

    public final AlgorithmModelPluginInfo copy(String type, String key, String name, String description, int version, long size, List<String> files) {
        k.f(type, "type");
        k.f(key, "key");
        k.f(name, "name");
        k.f(description, "description");
        k.f(files, "files");
        return new AlgorithmModelPluginInfo(type, key, name, description, version, size, files);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AlgorithmModelPluginInfo)) {
            return false;
        }
        AlgorithmModelPluginInfo algorithmModelPluginInfo = (AlgorithmModelPluginInfo) other;
        return k.b(this.type, algorithmModelPluginInfo.type) && k.b(this.key, algorithmModelPluginInfo.key) && k.b(this.name, algorithmModelPluginInfo.name) && k.b(this.description, algorithmModelPluginInfo.description) && this.version == algorithmModelPluginInfo.version && this.size == algorithmModelPluginInfo.size && k.b(this.files, algorithmModelPluginInfo.files);
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
        return this.files.hashCode() + a.c(androidx.constraintlayout.core.dsl.a.a(this.version, B7.a.c(B7.a.c(B7.a.c(this.type.hashCode() * 31, 31, this.key), 31, this.name), 31, this.description), 31), 31, this.size);
    }

    public String toString() {
        String str = this.type;
        String str2 = this.key;
        String str3 = this.name;
        String str4 = this.description;
        int i = this.version;
        long j5 = this.size;
        List<String> list = this.files;
        StringBuilder sbW = B7.a.w("AlgorithmModelPluginInfo(type=", str, ", key=", str2, ", name=");
        androidx.constraintlayout.core.dsl.a.A(sbW, str3, ", description=", str4, ", version=");
        sbW.append(i);
        sbW.append(", size=");
        sbW.append(j5);
        sbW.append(", files=");
        sbW.append(list);
        sbW.append(")");
        return sbW.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel dest, int flags) {
        k.f(dest, "dest");
        dest.writeString(this.type);
        dest.writeString(this.key);
        dest.writeString(this.name);
        dest.writeString(this.description);
        dest.writeInt(this.version);
        dest.writeLong(this.size);
        dest.writeStringList(this.files);
    }

    public AlgorithmModelPluginInfo(String type, String key, String name, String description, int i, long j5, List<String> files) {
        k.f(type, "type");
        k.f(key, "key");
        k.f(name, "name");
        k.f(description, "description");
        k.f(files, "files");
        this.type = type;
        this.key = key;
        this.name = name;
        this.description = description;
        this.version = i;
        this.size = j5;
        this.files = files;
    }

    public AlgorithmModelPluginInfo(String str, String str2, String str3, String str4, int i, long j5, List list, int i6, e eVar) {
        this((i6 & 1) != 0 ? "" : str, (i6 & 2) != 0 ? "" : str2, (i6 & 4) != 0 ? "" : str3, (i6 & 8) != 0 ? "" : str4, (i6 & 16) != 0 ? 0 : i, (i6 & 32) != 0 ? 0L : j5, (i6 & 64) != 0 ? EmptyList.f4893a : list);
    }
}
