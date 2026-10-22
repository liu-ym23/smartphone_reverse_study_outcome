package com.stepos.aiengine.model;

import a0.a;
import com.stepos.core.common.util.TraceIdKeys;
import gc.q;
import h0.e;
import java.util.List;
import kotlin.collections.EmptyList;
import kotlin.jvm.internal.g;
import v1.d;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class RemoteModel {
    private final List<String> abilities;
    private final List<String> dependencies;
    private final long fileSize;
    private final String md5;
    private final String name;
    private final String updateInfo;
    private final long updateTime;
    private final String url;
    private final int versionCode;

    public RemoteModel() {
        this(null, 0, null, 0L, null, null, 0L, null, null, 511, null);
    }

    public static /* synthetic */ RemoteModel copy$default(RemoteModel remoteModel, String str, int i10, String str2, long j10, String str3, String str4, long j11, List list, List list2, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = remoteModel.name;
        }
        if ((i11 & 2) != 0) {
            i10 = remoteModel.versionCode;
        }
        if ((i11 & 4) != 0) {
            str2 = remoteModel.url;
        }
        if ((i11 & 8) != 0) {
            j10 = remoteModel.fileSize;
        }
        if ((i11 & 16) != 0) {
            str3 = remoteModel.md5;
        }
        if ((i11 & 32) != 0) {
            str4 = remoteModel.updateInfo;
        }
        if ((i11 & 64) != 0) {
            j11 = remoteModel.updateTime;
        }
        if ((i11 & TraceIdKeys.MAX_LENGTH) != 0) {
            list = remoteModel.abilities;
        }
        if ((i11 & 256) != 0) {
            list2 = remoteModel.dependencies;
        }
        long j12 = j11;
        String str5 = str3;
        long j13 = j10;
        String str6 = str2;
        return remoteModel.copy(str, i10, str6, j13, str5, str4, j12, list, list2);
    }

    public final String component1() {
        return this.name;
    }

    public final int component2() {
        return this.versionCode;
    }

    public final String component3() {
        return this.url;
    }

    public final long component4() {
        return this.fileSize;
    }

    public final String component5() {
        return this.md5;
    }

    public final String component6() {
        return this.updateInfo;
    }

    public final long component7() {
        return this.updateTime;
    }

    public final List<String> component8() {
        return this.abilities;
    }

    public final List<String> component9() {
        return this.dependencies;
    }

    public final RemoteModel copy(String name, int i10, String url, long j10, String md5, String updateInfo, long j11, List<String> abilities, List<String> dependencies) {
        g.f(name, "name");
        g.f(url, "url");
        g.f(md5, "md5");
        g.f(updateInfo, "updateInfo");
        g.f(abilities, "abilities");
        g.f(dependencies, "dependencies");
        return new RemoteModel(name, i10, url, j10, md5, updateInfo, j11, abilities, dependencies);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RemoteModel)) {
            return false;
        }
        RemoteModel remoteModel = (RemoteModel) obj;
        return g.b(this.name, remoteModel.name) && this.versionCode == remoteModel.versionCode && g.b(this.url, remoteModel.url) && this.fileSize == remoteModel.fileSize && g.b(this.md5, remoteModel.md5) && g.b(this.updateInfo, remoteModel.updateInfo) && this.updateTime == remoteModel.updateTime && g.b(this.abilities, remoteModel.abilities) && g.b(this.dependencies, remoteModel.dependencies);
    }

    public final List<String> getAbilities() {
        return this.abilities;
    }

    public final String getBaseModelName() {
        boolean zIsPlugin = isPlugin();
        String str = this.name;
        return zIsPlugin ? q.K0(str, ".") : str;
    }

    public final List<String> getDependencies() {
        return this.dependencies;
    }

    public final long getFileSize() {
        return this.fileSize;
    }

    public final long getFile_size() {
        return this.fileSize;
    }

    public final String getMd5() {
        return this.md5;
    }

    public final List<String> getModels() {
        return EmptyList.f10001a;
    }

    public final String getName() {
        return this.name;
    }

    public final String getPluginName() {
        return isPlugin() ? q.G0(this.name, ".") : "";
    }

    public final String getUpdateInfo() {
        return this.updateInfo;
    }

    public final long getUpdateTime() {
        return this.updateTime;
    }

    public final String getUpdate_info() {
        return this.updateInfo;
    }

    public final long getUpdate_time() {
        return this.updateTime;
    }

    public final String getUrl() {
        return this.url;
    }

    public final int getVersionCode() {
        return this.versionCode;
    }

    public final int getVersion_code() {
        return this.versionCode;
    }

    public int hashCode() {
        return this.dependencies.hashCode() + e.b(this.abilities, a.c(d.a(d.a(a.c(d.a(ai.onnxruntime.a.d(this.versionCode, this.name.hashCode() * 31, 31), 31, this.url), this.fileSize, 31), 31, this.md5), 31, this.updateInfo), this.updateTime, 31), 31);
    }

    public final boolean isPlugin() {
        return q.l0(this.name, ".", false);
    }

    public String toString() {
        String str = this.name;
        int i10 = this.versionCode;
        String str2 = this.url;
        long j10 = this.fileSize;
        String str3 = this.md5;
        String str4 = this.updateInfo;
        long j11 = this.updateTime;
        List<String> list = this.abilities;
        List<String> list2 = this.dependencies;
        StringBuilder sbF = e.f("RemoteModel(name=", str, ", versionCode=", i10, ", url=");
        com.stepos.core.ota.d.p(j10, str2, ", fileSize=", sbF);
        ai.onnxruntime.a.z(sbF, ", md5=", str3, ", updateInfo=", str4);
        a.s(j11, ", updateTime=", ", abilities=", sbF);
        sbF.append(list);
        sbF.append(", dependencies=");
        sbF.append(list2);
        sbF.append(")");
        return sbF.toString();
    }

    public RemoteModel(String name, int i10, String url, long j10, String md5, String updateInfo, long j11, List<String> abilities, List<String> dependencies) {
        g.f(name, "name");
        g.f(url, "url");
        g.f(md5, "md5");
        g.f(updateInfo, "updateInfo");
        g.f(abilities, "abilities");
        g.f(dependencies, "dependencies");
        this.name = name;
        this.versionCode = i10;
        this.url = url;
        this.fileSize = j10;
        this.md5 = md5;
        this.updateInfo = updateInfo;
        this.updateTime = j11;
        this.abilities = abilities;
        this.dependencies = dependencies;
    }

    public RemoteModel(String str, int i10, String str2, long j10, String str3, String str4, long j11, List list, List list2, int i11, kotlin.jvm.internal.e eVar) {
        this((i11 & 1) != 0 ? "" : str, (i11 & 2) != 0 ? 0 : i10, (i11 & 4) != 0 ? "" : str2, (i11 & 8) != 0 ? 0L : j10, (i11 & 16) != 0 ? "" : str3, (i11 & 32) == 0 ? str4 : "", (i11 & 64) == 0 ? j11 : 0L, (i11 & TraceIdKeys.MAX_LENGTH) != 0 ? EmptyList.f10001a : list, (i11 & 256) != 0 ? EmptyList.f10001a : list2);
    }

    public static /* synthetic */ void getModels$annotations() {
    }
}
