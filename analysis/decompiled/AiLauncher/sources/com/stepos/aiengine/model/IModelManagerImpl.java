package com.stepos.aiengine.model;

import W4.b;
import Z8.C1173v;
import android.content.Context;
import android.os.Bundle;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.core.deepbinder.IOtaDeepBinderService;
import com.stepos.statsapp.v3.lib.plugin.constants.Parameters;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\b\u0000\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u0015\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0016¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J!\u0010\u0014\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0017\u001a\u00020\u0016H\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ\u0017\u0010\u001c\u001a\u00020\u000e2\u0006\u0010\u001b\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u001c\u0010\u001dJ\u000f\u0010\u001e\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u001e\u0010\u001fJ\u000f\u0010 \u001a\u00020\u000eH\u0016¢\u0006\u0004\b \u0010\u001fJ\u0017\u0010\"\u001a\u00020\u000e2\u0006\u0010!\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\"\u0010\u001dR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b#\u0010$R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b%\u0010&R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b'\u0010(¨\u0006)"}, d2 = {"Lcom/stepos/aiengine/model/IModelManagerImpl;", "Lcom/stepos/aiengine/model/IModelManager;", "Lcom/stepos/core/deepbinder/IOtaDeepBinderService;", "svc", "", "algorithmId", "Landroid/content/Context;", "context", "<init>", "(Lcom/stepos/core/deepbinder/IOtaDeepBinderService;Ljava/lang/String;Landroid/content/Context;)V", "", "Lcom/stepos/aiengine/model/AlgorithmModelInfo;", "getModels", "()Ljava/util/List;", "", "checkRemote", "checkUpdate", "(Z)Z", "needNewVersion", "Lcom/stepos/aiengine/model/RemoteModel;", "getUpdate", "(ZZ)Lcom/stepos/aiengine/model/RemoteModel;", "Landroid/os/Bundle;", "args", "Lcom/stepos/aiengine/model/IDownloader;", "getDownloader", "(Landroid/os/Bundle;)Lcom/stepos/aiengine/model/IDownloader;", "sourcePath", b.STEP_INSTALL, "(Ljava/lang/String;)Z", "uninstall", "()Z", "reset", "modelId", "setDefaultModel", Const.INTENT_KEY_APIKEY, "Lcom/stepos/core/deepbinder/IOtaDeepBinderService;", Const.INTENT_KEY_PKGNAME, "Ljava/lang/String;", "c", "Landroid/content/Context;", "aiengine-api_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class IModelManagerImpl implements IModelManager {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final IOtaDeepBinderService svc;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final String algorithmId;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public final Context context;

    public IModelManagerImpl(IOtaDeepBinderService svc, String algorithmId, Context context) {
        p.i(svc, "svc");
        p.i(algorithmId, "algorithmId");
        p.i(context, "context");
        this.svc = svc;
        this.algorithmId = algorithmId;
        this.context = context;
    }

    @Override // com.stepos.aiengine.model.IModelManager
    public boolean checkUpdate(boolean checkRemote) {
        if (checkRemote) {
            this.svc.triggerCheckUpdate(this.algorithmId);
        }
        return this.svc.getUpdateInfo(this.algorithmId) != null;
    }

    @Override // com.stepos.aiengine.model.IModelManager
    public IDownloader getDownloader(Bundle args) {
        p.i(args, "args");
        return new IDownloaderImpl(this.svc, this.algorithmId, this.context);
    }

    @Override // com.stepos.aiengine.model.IModelManager
    public List<AlgorithmModelInfo> getModels() {
        return this.svc.getModels(this.algorithmId);
    }

    @Override // com.stepos.aiengine.model.IModelManager
    public RemoteModel getUpdate(boolean checkRemote, boolean needNewVersion) {
        if (checkRemote) {
            this.svc.triggerCheckUpdate(this.algorithmId);
        }
        Bundle updateInfo = this.svc.getUpdateInfo(this.algorithmId);
        if (updateInfo == null) {
            return null;
        }
        String string = updateInfo.getString("name");
        if (string == null) {
            string = "";
        }
        int i10 = updateInfo.getInt("versionCode", 0);
        String string2 = updateInfo.getString("url");
        if (string2 == null) {
            return null;
        }
        long j10 = updateInfo.getLong("fileSize", 0L);
        String string3 = updateInfo.getString(Parameters.UPLOAD_REQUEST_PARAM_MD5);
        if (string3 == null) {
            string3 = "";
        }
        String string4 = updateInfo.getString("updateInfo");
        String str = string4 != null ? string4 : "";
        long j11 = updateInfo.getLong("updateTime", 0L);
        List stringArrayList = updateInfo.getStringArrayList("abilities");
        if (stringArrayList == null) {
            stringArrayList = C1173v.m();
        }
        List list = stringArrayList;
        List stringArrayList2 = updateInfo.getStringArrayList("dependencies");
        if (stringArrayList2 == null) {
            stringArrayList2 = C1173v.m();
        }
        return new RemoteModel(string, i10, string2, j10, string3, str, j11, list, stringArrayList2);
    }

    @Override // com.stepos.aiengine.model.IModelManager
    public boolean install(String sourcePath) {
        p.i(sourcePath, "sourcePath");
        return this.svc.install(this.algorithmId);
    }

    @Override // com.stepos.aiengine.model.IModelManager
    public boolean reset() {
        return this.svc.reset(this.algorithmId);
    }

    @Override // com.stepos.aiengine.model.IModelManager
    public boolean setDefaultModel(String modelId) {
        p.i(modelId, "modelId");
        return false;
    }

    @Override // com.stepos.aiengine.model.IModelManager
    public boolean uninstall() {
        return this.svc.uninstall(this.algorithmId);
    }
}
