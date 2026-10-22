package com.stepos.aiengine.model;

import a0.a;
import android.os.Parcel;
import android.os.Parcelable;
import com.stepos.core.ability.speech.VadSessionManager;
import com.stepos.core.common.util.TraceIdKeys;
import h0.e;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.EmptyList;
import kotlin.jvm.internal.g;
import v1.d;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class AlgorithmModelInfo implements Parcelable {
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

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class Creator implements Parcelable.Creator<AlgorithmModelInfo> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final AlgorithmModelInfo createFromParcel(Parcel parcel) {
            g.f(parcel, "parcel");
            String string = parcel.readString();
            String string2 = parcel.readString();
            long j10 = parcel.readLong();
            String string3 = parcel.readString();
            String string4 = parcel.readString();
            ArrayList<String> arrayListCreateStringArrayList = parcel.createStringArrayList();
            int i10 = parcel.readInt();
            ArrayList arrayList = new ArrayList(i10);
            for (int i11 = 0; i11 != i10; i11++) {
                arrayList.add(AlgorithmModelPluginInfo.CREATOR.createFromParcel(parcel));
            }
            return new AlgorithmModelInfo(string, string2, j10, string3, string4, arrayListCreateStringArrayList, arrayList, parcel.readLong(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readInt() != 0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final AlgorithmModelInfo[] newArray(int i10) {
            return new AlgorithmModelInfo[i10];
        }
    }

    public AlgorithmModelInfo(String algorithmId, String modelId, long j10, String versionName, String modelPath, List<String> fileList, List<AlgorithmModelPluginInfo> pluginList, long j11, String type, String name, String description, boolean z) {
        g.f(algorithmId, "algorithmId");
        g.f(modelId, "modelId");
        g.f(versionName, "versionName");
        g.f(modelPath, "modelPath");
        g.f(fileList, "fileList");
        g.f(pluginList, "pluginList");
        g.f(type, "type");
        g.f(name, "name");
        g.f(description, "description");
        this.algorithmId = algorithmId;
        this.modelId = modelId;
        this.versionCode = j10;
        this.versionName = versionName;
        this.modelPath = modelPath;
        this.fileList = fileList;
        this.pluginList = pluginList;
        this.sizeBytes = j11;
        this.type = type;
        this.name = name;
        this.description = description;
        this.isDefault = z;
    }

    public final String component1() {
        return this.algorithmId;
    }

    public final String component10() {
        return this.name;
    }

    public final String component11() {
        return this.description;
    }

    public final boolean component12() {
        return this.isDefault;
    }

    public final String component2() {
        return this.modelId;
    }

    public final long component3() {
        return this.versionCode;
    }

    public final String component4() {
        return this.versionName;
    }

    public final String component5() {
        return this.modelPath;
    }

    public final List<String> component6() {
        return this.fileList;
    }

    public final List<AlgorithmModelPluginInfo> component7() {
        return this.pluginList;
    }

    public final long component8() {
        return this.sizeBytes;
    }

    public final String component9() {
        return this.type;
    }

    public final AlgorithmModelInfo copy(String algorithmId, String modelId, long j10, String versionName, String modelPath, List<String> fileList, List<AlgorithmModelPluginInfo> pluginList, long j11, String type, String name, String description, boolean z) {
        g.f(algorithmId, "algorithmId");
        g.f(modelId, "modelId");
        g.f(versionName, "versionName");
        g.f(modelPath, "modelPath");
        g.f(fileList, "fileList");
        g.f(pluginList, "pluginList");
        g.f(type, "type");
        g.f(name, "name");
        g.f(description, "description");
        return new AlgorithmModelInfo(algorithmId, modelId, j10, versionName, modelPath, fileList, pluginList, j11, type, name, description, z);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AlgorithmModelInfo)) {
            return false;
        }
        AlgorithmModelInfo algorithmModelInfo = (AlgorithmModelInfo) obj;
        return g.b(this.algorithmId, algorithmModelInfo.algorithmId) && g.b(this.modelId, algorithmModelInfo.modelId) && this.versionCode == algorithmModelInfo.versionCode && g.b(this.versionName, algorithmModelInfo.versionName) && g.b(this.modelPath, algorithmModelInfo.modelPath) && g.b(this.fileList, algorithmModelInfo.fileList) && g.b(this.pluginList, algorithmModelInfo.pluginList) && this.sizeBytes == algorithmModelInfo.sizeBytes && g.b(this.type, algorithmModelInfo.type) && g.b(this.name, algorithmModelInfo.name) && g.b(this.description, algorithmModelInfo.description) && this.isDefault == algorithmModelInfo.isDefault;
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
        return Boolean.hashCode(this.isDefault) + d.a(d.a(d.a(a.c(e.b(this.pluginList, e.b(this.fileList, d.a(d.a(a.c(d.a(this.algorithmId.hashCode() * 31, 31, this.modelId), this.versionCode, 31), 31, this.versionName), 31, this.modelPath), 31), 31), this.sizeBytes, 31), 31, this.type), 31, this.name), 31, this.description);
    }

    public final boolean isDefault() {
        return this.isDefault;
    }

    public String toString() {
        String str = this.algorithmId;
        String str2 = this.modelId;
        long j10 = this.versionCode;
        String str3 = this.versionName;
        String str4 = this.modelPath;
        List<String> list = this.fileList;
        List<AlgorithmModelPluginInfo> list2 = this.pluginList;
        long j11 = this.sizeBytes;
        String str5 = this.type;
        String str6 = this.name;
        String str7 = this.description;
        boolean z = this.isDefault;
        StringBuilder sbS = ai.onnxruntime.a.s("AlgorithmModelInfo(algorithmId=", str, ", modelId=", str2, ", versionCode=");
        ai.onnxruntime.a.u(j10, ", versionName=", str3, sbS);
        sbS.append(", modelPath=");
        sbS.append(str4);
        sbS.append(", fileList=");
        sbS.append(list);
        sbS.append(", pluginList=");
        sbS.append(list2);
        sbS.append(", sizeBytes=");
        ai.onnxruntime.a.u(j11, ", type=", str5, sbS);
        ai.onnxruntime.a.z(sbS, ", name=", str6, ", description=", str7);
        sbS.append(", isDefault=");
        sbS.append(z);
        sbS.append(")");
        return sbS.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel dest, int i10) {
        g.f(dest, "dest");
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
            it.next().writeToParcel(dest, i10);
        }
        dest.writeLong(this.sizeBytes);
        dest.writeString(this.type);
        dest.writeString(this.name);
        dest.writeString(this.description);
        dest.writeInt(this.isDefault ? 1 : 0);
    }

    public AlgorithmModelInfo(String str, String str2, long j10, String str3, String str4, List list, List list2, long j11, String str5, String str6, String str7, boolean z, int i10, kotlin.jvm.internal.e eVar) {
        this(str, str2, (i10 & 4) != 0 ? 0L : j10, (i10 & 8) != 0 ? "" : str3, (i10 & 16) != 0 ? "" : str4, (i10 & 32) != 0 ? EmptyList.f10001a : list, (i10 & 64) != 0 ? EmptyList.f10001a : list2, (i10 & TraceIdKeys.MAX_LENGTH) != 0 ? 0L : j11, (i10 & 256) != 0 ? "" : str5, (i10 & VadSessionManager.FRAME_BYTES) != 0 ? "" : str6, (i10 & 1024) != 0 ? "" : str7, (i10 & 2048) != 0 ? false : z);
    }
}
