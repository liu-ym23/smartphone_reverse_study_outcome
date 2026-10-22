package com.stepos.aiengine.model;

import La.H;
import Z8.C1173v;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.chat.trace.ChatTracker;
import com.stepos.statsapp.v3.lib.plugin.constants.Parameters;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0016\n\u0002\u0010\u000b\n\u0002\b+\b\u0086\b\u0018\u00002\u00020\u0001Bm\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0002\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007\u0012\b\b\u0002\u0010\t\u001a\u00020\u0002\u0012\b\b\u0002\u0010\n\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0007\u0012\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00020\f\u0012\u000e\b\u0002\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00020\f¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0013\u001a\u00020\u0004HÆ\u0003¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0015\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0015\u0010\u0012J\u0010\u0010\u0016\u001a\u00020\u0007HÆ\u0003¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0018\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0018\u0010\u0012J\u0010\u0010\u0019\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0019\u0010\u0012J\u0010\u0010\u001a\u001a\u00020\u0007HÆ\u0003¢\u0006\u0004\b\u001a\u0010\u0017J\u0016\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00020\fHÆ\u0003¢\u0006\u0004\b\u001b\u0010\u001cJ\u0016\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00020\fHÆ\u0003¢\u0006\u0004\b\u001d\u0010\u001cJv\u0010\u001e\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u00022\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u00022\b\b\u0002\u0010\n\u001a\u00020\u00022\b\b\u0002\u0010\u000b\u001a\u00020\u00072\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00020\f2\u000e\b\u0002\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00020\fHÆ\u0001¢\u0006\u0004\b\u001e\u0010\u001fJ\u0010\u0010 \u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b \u0010\u0012J\u0010\u0010!\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b!\u0010\u0014J\u001a\u0010$\u001a\u00020#2\b\u0010\"\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b$\u0010%R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b&\u0010'\u001a\u0004\b(\u0010\u0012R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b)\u0010*\u001a\u0004\b+\u0010\u0014R\u0017\u0010\u0006\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b,\u0010'\u001a\u0004\b-\u0010\u0012R\u0017\u0010\b\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b.\u0010/\u001a\u0004\b0\u0010\u0017R\u0017\u0010\t\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b1\u0010'\u001a\u0004\b2\u0010\u0012R\u0017\u0010\n\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b3\u0010'\u001a\u0004\b4\u0010\u0012R\u0017\u0010\u000b\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b5\u0010/\u001a\u0004\b6\u0010\u0017R\u001d\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00020\f8\u0006¢\u0006\f\n\u0004\b7\u00108\u001a\u0004\b9\u0010\u001cR\u001d\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00020\f8\u0006¢\u0006\f\n\u0004\b:\u00108\u001a\u0004\b;\u0010\u001cR \u0010?\u001a\b\u0012\u0004\u0012\u00020\u00020\f8FX\u0087\u0004¢\u0006\f\u0012\u0004\b=\u0010>\u001a\u0004\b<\u0010\u001cR\u0011\u0010@\u001a\u00020#8F¢\u0006\u0006\u001a\u0004\b@\u0010AR\u0011\u0010C\u001a\u00020\u00028F¢\u0006\u0006\u001a\u0004\bB\u0010\u0012R\u0011\u0010E\u001a\u00020\u00028F¢\u0006\u0006\u001a\u0004\bD\u0010\u0012R\u0011\u0010G\u001a\u00020\u00048G¢\u0006\u0006\u001a\u0004\bF\u0010\u0014R\u0011\u0010I\u001a\u00020\u00078G¢\u0006\u0006\u001a\u0004\bH\u0010\u0017R\u0011\u0010K\u001a\u00020\u00028G¢\u0006\u0006\u001a\u0004\bJ\u0010\u0012R\u0011\u0010M\u001a\u00020\u00078G¢\u0006\u0006\u001a\u0004\bL\u0010\u0017¨\u0006N"}, d2 = {"Lcom/stepos/aiengine/model/RemoteModel;", "", "", "name", "", "versionCode", "url", "", "fileSize", Parameters.UPLOAD_REQUEST_PARAM_MD5, "updateInfo", "updateTime", "", "abilities", "dependencies", "<init>", "(Ljava/lang/String;ILjava/lang/String;JLjava/lang/String;Ljava/lang/String;JLjava/util/List;Ljava/util/List;)V", "component1", "()Ljava/lang/String;", "component2", "()I", "component3", "component4", "()J", "component5", "component6", "component7", "component8", "()Ljava/util/List;", "component9", ChatTracker.CLICK_COPY, "(Ljava/lang/String;ILjava/lang/String;JLjava/lang/String;Ljava/lang/String;JLjava/util/List;Ljava/util/List;)Lcom/stepos/aiengine/model/RemoteModel;", "toString", "hashCode", "other", "", "equals", "(Ljava/lang/Object;)Z", Const.INTENT_KEY_APIKEY, "Ljava/lang/String;", "getName", Const.INTENT_KEY_PKGNAME, "I", "getVersionCode", "c", "getUrl", Const.INTENT_KEY_UMID, "J", "getFileSize", "e", "getMd5", "f", "getUpdateInfo", Const.INTENT_KEY_BACKGROUND_COMMAND, "getUpdateTime", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "Ljava/util/List;", "getAbilities", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "getDependencies", "getModels", "getModels$annotations", "()V", "models", "isPlugin", "()Z", "getBaseModelName", "baseModelName", "getPluginName", "pluginName", "getVersion_code", "version_code", "getFile_size", "file_size", "getUpdate_info", "update_info", "getUpdate_time", "update_time", "shared-lib_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes2.dex */
public final /* data */ class RemoteModel {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    public final String name;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    public final int versionCode;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    public final String url;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    public final long fileSize;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    public final String md5;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
    public final String updateInfo;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata and from toString */
    public final long updateTime;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata and from toString */
    public final List<String> abilities;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata and from toString */
    public final List<String> dependencies;

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
        if ((i11 & 128) != 0) {
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

    public static /* synthetic */ void getModels$annotations() {
    }

    /* renamed from: component1, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* renamed from: component2, reason: from getter */
    public final int getVersionCode() {
        return this.versionCode;
    }

    /* renamed from: component3, reason: from getter */
    public final String getUrl() {
        return this.url;
    }

    /* renamed from: component4, reason: from getter */
    public final long getFileSize() {
        return this.fileSize;
    }

    /* renamed from: component5, reason: from getter */
    public final String getMd5() {
        return this.md5;
    }

    /* renamed from: component6, reason: from getter */
    public final String getUpdateInfo() {
        return this.updateInfo;
    }

    /* renamed from: component7, reason: from getter */
    public final long getUpdateTime() {
        return this.updateTime;
    }

    public final List<String> component8() {
        return this.abilities;
    }

    public final List<String> component9() {
        return this.dependencies;
    }

    public final RemoteModel copy(String name, int versionCode, String url, long fileSize, String md5, String updateInfo, long updateTime, List<String> abilities, List<String> dependencies) {
        p.i(name, "name");
        p.i(url, "url");
        p.i(md5, "md5");
        p.i(updateInfo, "updateInfo");
        p.i(abilities, "abilities");
        p.i(dependencies, "dependencies");
        return new RemoteModel(name, versionCode, url, fileSize, md5, updateInfo, updateTime, abilities, dependencies);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof RemoteModel)) {
            return false;
        }
        RemoteModel remoteModel = (RemoteModel) other;
        return p.d(this.name, remoteModel.name) && this.versionCode == remoteModel.versionCode && p.d(this.url, remoteModel.url) && this.fileSize == remoteModel.fileSize && p.d(this.md5, remoteModel.md5) && p.d(this.updateInfo, remoteModel.updateInfo) && this.updateTime == remoteModel.updateTime && p.d(this.abilities, remoteModel.abilities) && p.d(this.dependencies, remoteModel.dependencies);
    }

    public final List<String> getAbilities() {
        return this.abilities;
    }

    public final String getBaseModelName() {
        boolean zIsPlugin = isPlugin();
        String str = this.name;
        return zIsPlugin ? H.x1(str, ".", null, 2, null) : str;
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
        return C1173v.m();
    }

    public final String getName() {
        return this.name;
    }

    public final String getPluginName() {
        return isPlugin() ? H.p1(this.name, ".", null, 2, null) : "";
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
        return (((((((((((((((this.name.hashCode() * 31) + Integer.hashCode(this.versionCode)) * 31) + this.url.hashCode()) * 31) + Long.hashCode(this.fileSize)) * 31) + this.md5.hashCode()) * 31) + this.updateInfo.hashCode()) * 31) + Long.hashCode(this.updateTime)) * 31) + this.abilities.hashCode()) * 31) + this.dependencies.hashCode();
    }

    public final boolean isPlugin() {
        return H.g0(this.name, ".", false, 2, null);
    }

    public String toString() {
        return "RemoteModel(name=" + this.name + ", versionCode=" + this.versionCode + ", url=" + this.url + ", fileSize=" + this.fileSize + ", md5=" + this.md5 + ", updateInfo=" + this.updateInfo + ", updateTime=" + this.updateTime + ", abilities=" + this.abilities + ", dependencies=" + this.dependencies + ")";
    }

    public RemoteModel(String name, int i10, String url, long j10, String md5, String updateInfo, long j11, List<String> abilities, List<String> dependencies) {
        p.i(name, "name");
        p.i(url, "url");
        p.i(md5, "md5");
        p.i(updateInfo, "updateInfo");
        p.i(abilities, "abilities");
        p.i(dependencies, "dependencies");
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

    public /* synthetic */ RemoteModel(String str, int i10, String str2, long j10, String str3, String str4, long j11, List list, List list2, int i11, i iVar) {
        this((i11 & 1) != 0 ? "" : str, (i11 & 2) != 0 ? 0 : i10, (i11 & 4) != 0 ? "" : str2, (i11 & 8) != 0 ? 0L : j10, (i11 & 16) != 0 ? "" : str3, (i11 & 32) == 0 ? str4 : "", (i11 & 64) == 0 ? j11 : 0L, (i11 & 128) != 0 ? C1173v.m() : list, (i11 & 256) != 0 ? C1173v.m() : list2);
    }
}
