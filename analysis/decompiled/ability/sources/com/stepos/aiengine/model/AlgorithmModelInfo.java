package com.stepos.aiengine.model;

import B7.a;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.autofill.HintConstants;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.stepos.aiengine.api.IAlgorithmProperties;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.EmptyList;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0010\u0000\n\u0002\b\u001f\b\u0087\b\u0018\u00002\u00020\u0001B\u0087\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0002\u0012\b\b\u0002\u0010\b\u001a\u00020\u0002\u0012\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00020\t\u0012\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\t\u0012\b\b\u0002\u0010\r\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0011¢\u0006\u0004\b\u0013\u0010\u0014J\r\u0010\u0015\u001a\u00020\u0011¢\u0006\u0004\b\u0015\u0010\u0016J\r\u0010\u0017\u001a\u00020\u0011¢\u0006\u0004\b\u0017\u0010\u0016J\u001d\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u001a¢\u0006\u0004\b\u001d\u0010\u001eJ\r\u0010\u001f\u001a\u00020\u001a¢\u0006\u0004\b\u001f\u0010 J\u0010\u0010!\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b!\u0010\"J\u0010\u0010#\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b#\u0010\"J\u0010\u0010$\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b$\u0010%J\u0010\u0010&\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b&\u0010\"J\u0010\u0010'\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b'\u0010\"J\u0016\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00020\tHÆ\u0003¢\u0006\u0004\b(\u0010)J\u0016\u0010*\u001a\b\u0012\u0004\u0012\u00020\u000b0\tHÆ\u0003¢\u0006\u0004\b*\u0010)J\u0010\u0010+\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b+\u0010%J\u0010\u0010,\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b,\u0010\"J\u0010\u0010-\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b-\u0010\"J\u0010\u0010.\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b.\u0010\"J\u0010\u0010/\u001a\u00020\u0011HÆ\u0003¢\u0006\u0004\b/\u0010\u0016J\u0094\u0001\u00100\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u00022\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00022\b\b\u0002\u0010\b\u001a\u00020\u00022\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00020\t2\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\t2\b\b\u0002\u0010\r\u001a\u00020\u00052\b\b\u0002\u0010\u000e\u001a\u00020\u00022\b\b\u0002\u0010\u000f\u001a\u00020\u00022\b\b\u0002\u0010\u0010\u001a\u00020\u00022\b\b\u0002\u0010\u0012\u001a\u00020\u0011HÆ\u0001¢\u0006\u0004\b0\u00101J\u0010\u00102\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b2\u0010\"J\u0010\u00103\u001a\u00020\u001aHÖ\u0001¢\u0006\u0004\b3\u0010 J\u001a\u00106\u001a\u00020\u00112\b\u00105\u001a\u0004\u0018\u000104HÖ\u0003¢\u0006\u0004\b6\u00107R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u00108\u001a\u0004\b9\u0010\"R\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u00108\u001a\u0004\b:\u0010\"R\u0017\u0010\u0006\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u0006\u0010;\u001a\u0004\b<\u0010%R\u0017\u0010\u0007\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0007\u00108\u001a\u0004\b=\u0010\"R\u0017\u0010\b\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\b\u00108\u001a\u0004\b>\u0010\"R\u001d\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00020\t8\u0006¢\u0006\f\n\u0004\b\n\u0010?\u001a\u0004\b@\u0010)R\u001d\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\t8\u0006¢\u0006\f\n\u0004\b\f\u0010?\u001a\u0004\bA\u0010)R\u0017\u0010\r\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\r\u0010;\u001a\u0004\bB\u0010%R\u0017\u0010\u000e\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u000e\u00108\u001a\u0004\bC\u0010\"R\u0017\u0010\u000f\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u000f\u00108\u001a\u0004\bD\u0010\"R\u0017\u0010\u0010\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0010\u00108\u001a\u0004\bE\u0010\"R\u0017\u0010\u0012\u001a\u00020\u00118\u0006¢\u0006\f\n\u0004\b\u0012\u0010F\u001a\u0004\b\u0012\u0010\u0016R\u0011\u0010H\u001a\u00020\u00028F¢\u0006\u0006\u001a\u0004\bG\u0010\"R\u0011\u0010J\u001a\u00020\u00028F¢\u0006\u0006\u001a\u0004\bI\u0010\"R\u0011\u0010L\u001a\u00020\u001a8F¢\u0006\u0006\u001a\u0004\bK\u0010 R\u0011\u0010N\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\bM\u0010%R\u0017\u0010P\u001a\b\u0012\u0004\u0012\u00020\u00020\t8F¢\u0006\u0006\u001a\u0004\bO\u0010)R\u0017\u0010R\u001a\b\u0012\u0004\u0012\u00020\u000b0\t8F¢\u0006\u0006\u001a\u0004\bQ\u0010)¨\u0006S"}, d2 = {"Lcom/stepos/aiengine/model/AlgorithmModelInfo;", "Landroid/os/Parcelable;", "", "algorithmId", "modelId", "", "versionCode", "versionName", "modelPath", "", "fileList", "Lcom/stepos/aiengine/model/AlgorithmModelPluginInfo;", "pluginList", "sizeBytes", "type", HintConstants.AUTOFILL_HINT_NAME, "description", "", "isDefault", AppAgent.CONSTRUCT, "(Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/List;JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V", "hasPlugin", "()Z", "hasFiles", "Landroid/os/Parcel;", "dest", "", "flags", "LC7/r;", "writeToParcel", "(Landroid/os/Parcel;I)V", "describeContents", "()I", "component1", "()Ljava/lang/String;", "component2", "component3", "()J", "component4", "component5", "component6", "()Ljava/util/List;", "component7", "component8", "component9", "component10", "component11", "component12", "copy", "(Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/List;JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)Lcom/stepos/aiengine/model/AlgorithmModelInfo;", "toString", "hashCode", "", "other", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getAlgorithmId", "getModelId", "J", "getVersionCode", "getVersionName", "getModelPath", "Ljava/util/List;", "getFileList", "getPluginList", "getSizeBytes", "getType", "getName", "getDescription", "Z", "getAlgorithm", "algorithm", "getKey", "key", "getVersion", "version", "getSize", "size", "getFiles", "files", "getPlugins", IAlgorithmProperties.PLUGINS, "shared-lib_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class AlgorithmModelInfo implements Parcelable {
    public static final Parcelable.Creator<AlgorithmModelInfo> CREATOR = new Creator();
    private final String algorithmId;
    private final String description;
    private final List<String> fileList;
    private final boolean isDefault;
    private final String modelId;
    private final String modelPath;
    private final String name;
    private final List<AlgorithmModelPluginInfo> pluginList;
    private final long sizeBytes;
    private final String type;
    private final long versionCode;
    private final String versionName;

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<AlgorithmModelInfo> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final AlgorithmModelInfo createFromParcel(Parcel parcel) {
            k.f(parcel, "parcel");
            String string = parcel.readString();
            String string2 = parcel.readString();
            long j5 = parcel.readLong();
            String string3 = parcel.readString();
            String string4 = parcel.readString();
            ArrayList<String> arrayListCreateStringArrayList = parcel.createStringArrayList();
            int i = parcel.readInt();
            ArrayList arrayList = new ArrayList(i);
            for (int i6 = 0; i6 != i; i6++) {
                arrayList.add(AlgorithmModelPluginInfo.CREATOR.createFromParcel(parcel));
            }
            return new AlgorithmModelInfo(string, string2, j5, string3, string4, arrayListCreateStringArrayList, arrayList, parcel.readLong(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readInt() != 0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final AlgorithmModelInfo[] newArray(int i) {
            return new AlgorithmModelInfo[i];
        }
    }

    public AlgorithmModelInfo(String algorithmId, String modelId, long j5, String versionName, String modelPath, List<String> fileList, List<AlgorithmModelPluginInfo> pluginList, long j6, String type, String name, String description, boolean z10) {
        k.f(algorithmId, "algorithmId");
        k.f(modelId, "modelId");
        k.f(versionName, "versionName");
        k.f(modelPath, "modelPath");
        k.f(fileList, "fileList");
        k.f(pluginList, "pluginList");
        k.f(type, "type");
        k.f(name, "name");
        k.f(description, "description");
        this.algorithmId = algorithmId;
        this.modelId = modelId;
        this.versionCode = j5;
        this.versionName = versionName;
        this.modelPath = modelPath;
        this.fileList = fileList;
        this.pluginList = pluginList;
        this.sizeBytes = j6;
        this.type = type;
        this.name = name;
        this.description = description;
        this.isDefault = z10;
    }

    /* renamed from: component1, reason: from getter */
    public final String getAlgorithmId() {
        return this.algorithmId;
    }

    /* renamed from: component10, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* renamed from: component11, reason: from getter */
    public final String getDescription() {
        return this.description;
    }

    /* renamed from: component12, reason: from getter */
    public final boolean getIsDefault() {
        return this.isDefault;
    }

    /* renamed from: component2, reason: from getter */
    public final String getModelId() {
        return this.modelId;
    }

    /* renamed from: component3, reason: from getter */
    public final long getVersionCode() {
        return this.versionCode;
    }

    /* renamed from: component4, reason: from getter */
    public final String getVersionName() {
        return this.versionName;
    }

    /* renamed from: component5, reason: from getter */
    public final String getModelPath() {
        return this.modelPath;
    }

    public final List<String> component6() {
        return this.fileList;
    }

    public final List<AlgorithmModelPluginInfo> component7() {
        return this.pluginList;
    }

    /* renamed from: component8, reason: from getter */
    public final long getSizeBytes() {
        return this.sizeBytes;
    }

    /* renamed from: component9, reason: from getter */
    public final String getType() {
        return this.type;
    }

    public final AlgorithmModelInfo copy(String algorithmId, String modelId, long versionCode, String versionName, String modelPath, List<String> fileList, List<AlgorithmModelPluginInfo> pluginList, long sizeBytes, String type, String name, String description, boolean isDefault) {
        k.f(algorithmId, "algorithmId");
        k.f(modelId, "modelId");
        k.f(versionName, "versionName");
        k.f(modelPath, "modelPath");
        k.f(fileList, "fileList");
        k.f(pluginList, "pluginList");
        k.f(type, "type");
        k.f(name, "name");
        k.f(description, "description");
        return new AlgorithmModelInfo(algorithmId, modelId, versionCode, versionName, modelPath, fileList, pluginList, sizeBytes, type, name, description, isDefault);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AlgorithmModelInfo)) {
            return false;
        }
        AlgorithmModelInfo algorithmModelInfo = (AlgorithmModelInfo) other;
        return k.b(this.algorithmId, algorithmModelInfo.algorithmId) && k.b(this.modelId, algorithmModelInfo.modelId) && this.versionCode == algorithmModelInfo.versionCode && k.b(this.versionName, algorithmModelInfo.versionName) && k.b(this.modelPath, algorithmModelInfo.modelPath) && k.b(this.fileList, algorithmModelInfo.fileList) && k.b(this.pluginList, algorithmModelInfo.pluginList) && this.sizeBytes == algorithmModelInfo.sizeBytes && k.b(this.type, algorithmModelInfo.type) && k.b(this.name, algorithmModelInfo.name) && k.b(this.description, algorithmModelInfo.description) && this.isDefault == algorithmModelInfo.isDefault;
    }

    public final String getAlgorithm() {
        return this.algorithmId;
    }

    public final String getAlgorithmId() {
        return this.algorithmId;
    }

    public final String getDescription() {
        return this.description;
    }

    public final List<String> getFileList() {
        return this.fileList;
    }

    public final List<String> getFiles() {
        return this.fileList;
    }

    public final String getKey() {
        return this.modelId;
    }

    public final String getModelId() {
        return this.modelId;
    }

    public final String getModelPath() {
        return this.modelPath;
    }

    public final String getName() {
        return this.name;
    }

    public final List<AlgorithmModelPluginInfo> getPluginList() {
        return this.pluginList;
    }

    public final List<AlgorithmModelPluginInfo> getPlugins() {
        return this.pluginList;
    }

    public final long getSize() {
        return this.sizeBytes;
    }

    public final long getSizeBytes() {
        return this.sizeBytes;
    }

    public final String getType() {
        return this.type;
    }

    public final int getVersion() {
        return (int) this.versionCode;
    }

    public final long getVersionCode() {
        return this.versionCode;
    }

    public final String getVersionName() {
        return this.versionName;
    }

    public final boolean hasFiles() {
        return !this.fileList.isEmpty();
    }

    public final boolean hasPlugin() {
        return !this.pluginList.isEmpty();
    }

    public int hashCode() {
        return Boolean.hashCode(this.isDefault) + a.c(a.c(a.c(androidx.appfunctions.metadata.a.c(androidx.appfunctions.metadata.a.e(this.pluginList, androidx.appfunctions.metadata.a.e(this.fileList, a.c(a.c(androidx.appfunctions.metadata.a.c(a.c(this.algorithmId.hashCode() * 31, 31, this.modelId), 31, this.versionCode), 31, this.versionName), 31, this.modelPath), 31), 31), 31, this.sizeBytes), 31, this.type), 31, this.name), 31, this.description);
    }

    public final boolean isDefault() {
        return this.isDefault;
    }

    public String toString() {
        String str = this.algorithmId;
        String str2 = this.modelId;
        long j5 = this.versionCode;
        String str3 = this.versionName;
        String str4 = this.modelPath;
        List<String> list = this.fileList;
        List<AlgorithmModelPluginInfo> list2 = this.pluginList;
        long j6 = this.sizeBytes;
        String str5 = this.type;
        String str6 = this.name;
        String str7 = this.description;
        boolean z10 = this.isDefault;
        StringBuilder sbW = a.w("AlgorithmModelInfo(algorithmId=", str, ", modelId=", str2, ", versionCode=");
        sbW.append(j5);
        sbW.append(", versionName=");
        sbW.append(str3);
        sbW.append(", modelPath=");
        sbW.append(str4);
        sbW.append(", fileList=");
        sbW.append(list);
        sbW.append(", pluginList=");
        sbW.append(list2);
        sbW.append(", sizeBytes=");
        sbW.append(j6);
        sbW.append(", type=");
        sbW.append(str5);
        androidx.constraintlayout.core.dsl.a.A(sbW, ", name=", str6, ", description=", str7);
        sbW.append(", isDefault=");
        sbW.append(z10);
        sbW.append(")");
        return sbW.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel dest, int flags) {
        k.f(dest, "dest");
        dest.writeString(this.algorithmId);
        dest.writeString(this.modelId);
        dest.writeLong(this.versionCode);
        dest.writeString(this.versionName);
        dest.writeString(this.modelPath);
        dest.writeStringList(this.fileList);
        List<AlgorithmModelPluginInfo> list = this.pluginList;
        dest.writeInt(list.size());
        Iterator<AlgorithmModelPluginInfo> it = list.iterator();
        while (it.hasNext()) {
            it.next().writeToParcel(dest, flags);
        }
        dest.writeLong(this.sizeBytes);
        dest.writeString(this.type);
        dest.writeString(this.name);
        dest.writeString(this.description);
        dest.writeInt(this.isDefault ? 1 : 0);
    }

    public AlgorithmModelInfo(String str, String str2, long j5, String str3, String str4, List list, List list2, long j6, String str5, String str6, String str7, boolean z10, int i, e eVar) {
        this(str, str2, (i & 4) != 0 ? 0L : j5, (i & 8) != 0 ? "" : str3, (i & 16) != 0 ? "" : str4, (i & 32) != 0 ? EmptyList.f4893a : list, (i & 64) != 0 ? EmptyList.f4893a : list2, (i & 128) != 0 ? 0L : j6, (i & 256) != 0 ? "" : str5, (i & 512) != 0 ? "" : str6, (i & 1024) != 0 ? "" : str7, (i & 2048) != 0 ? false : z10);
    }
}
