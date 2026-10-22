package com.stepos.aiengine.model;

import android.os.Bundle;
import androidx.autofill.HintConstants;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.stepos.agentframework.adapter.bff.BffConstant;
import com.stepos.core.deepbinder.IOtaDeepBinderService;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.EmptyList;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0015\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000e\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ!\u0010\u0012\u001a\u0004\u0018\u00010\u00112\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\fH\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0015\u001a\u00020\u0014H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u0017\u0010\u001a\u001a\u00020\f2\u0006\u0010\u0019\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ\u000f\u0010\u001c\u001a\u00020\fH\u0016¢\u0006\u0004\b\u001c\u0010\u001dJ\u000f\u0010\u001e\u001a\u00020\fH\u0016¢\u0006\u0004\b\u001e\u0010\u001dJ\u0017\u0010 \u001a\u00020\f2\u0006\u0010\u001f\u001a\u00020\u0004H\u0016¢\u0006\u0004\b \u0010\u001b¨\u0006!"}, d2 = {"Lcom/stepos/aiengine/model/IModelManagerImpl;", "Lcom/stepos/aiengine/model/IModelManager;", "Lcom/stepos/core/deepbinder/IOtaDeepBinderService;", "svc", "", "algorithmId", AppAgent.CONSTRUCT, "(Lcom/stepos/core/deepbinder/IOtaDeepBinderService;Ljava/lang/String;)V", "", "Lcom/stepos/aiengine/model/AlgorithmModelInfo;", "getModels", "()Ljava/util/List;", "", "checkRemote", "checkUpdate", "(Z)Z", "needNewVersion", "Lcom/stepos/aiengine/model/RemoteModel;", "getUpdate", "(ZZ)Lcom/stepos/aiengine/model/RemoteModel;", "Landroid/os/Bundle;", "args", "Lcom/stepos/aiengine/model/IDownloader;", "getDownloader", "(Landroid/os/Bundle;)Lcom/stepos/aiengine/model/IDownloader;", "sourcePath", "install", "(Ljava/lang/String;)Z", "uninstall", "()Z", "reset", "modelId", "setDefaultModel", "aiengine-api_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class IModelManagerImpl implements IModelManager {

    /* renamed from: a, reason: collision with root package name */
    public final IOtaDeepBinderService f3529a;
    public final String b;

    public IModelManagerImpl(IOtaDeepBinderService svc, String algorithmId) {
        k.f(svc, "svc");
        k.f(algorithmId, "algorithmId");
        this.f3529a = svc;
        this.b = algorithmId;
    }

    @Override // com.stepos.aiengine.model.IModelManager
    public boolean checkUpdate(boolean checkRemote) {
        String str = this.b;
        IOtaDeepBinderService iOtaDeepBinderService = this.f3529a;
        if (checkRemote) {
            iOtaDeepBinderService.triggerCheckUpdate(str);
        }
        return iOtaDeepBinderService.getUpdateInfo(str) != null;
    }

    @Override // com.stepos.aiengine.model.IModelManager
    public IDownloader getDownloader(Bundle args) {
        k.f(args, "args");
        return new IDownloaderImpl(this.f3529a, this.b);
    }

    @Override // com.stepos.aiengine.model.IModelManager
    public List<AlgorithmModelInfo> getModels() {
        return this.f3529a.getModels(this.b);
    }

    @Override // com.stepos.aiengine.model.IModelManager
    public RemoteModel getUpdate(boolean checkRemote, boolean needNewVersion) {
        String str = this.b;
        IOtaDeepBinderService iOtaDeepBinderService = this.f3529a;
        if (checkRemote) {
            iOtaDeepBinderService.triggerCheckUpdate(str);
        }
        Bundle updateInfo = iOtaDeepBinderService.getUpdateInfo(str);
        if (updateInfo == null) {
            return null;
        }
        String string = updateInfo.getString(HintConstants.AUTOFILL_HINT_NAME);
        if (string == null) {
            string = "";
        }
        int i = updateInfo.getInt("versionCode", 0);
        String string2 = updateInfo.getString(BffConstant.Type.Url);
        if (string2 == null) {
            return null;
        }
        long j5 = updateInfo.getLong("fileSize", 0L);
        String string3 = updateInfo.getString("md5");
        if (string3 == null) {
            string3 = "";
        }
        String string4 = updateInfo.getString("updateInfo");
        String str2 = string4 != null ? string4 : "";
        long j6 = updateInfo.getLong("updateTime", 0L);
        List stringArrayList = updateInfo.getStringArrayList("abilities");
        if (stringArrayList == null) {
            stringArrayList = EmptyList.f4893a;
        }
        List list = stringArrayList;
        List stringArrayList2 = updateInfo.getStringArrayList("dependencies");
        if (stringArrayList2 == null) {
            stringArrayList2 = EmptyList.f4893a;
        }
        return new RemoteModel(string, i, string2, j5, string3, str2, j6, list, stringArrayList2);
    }

    @Override // com.stepos.aiengine.model.IModelManager
    public boolean install(String sourcePath) {
        k.f(sourcePath, "sourcePath");
        return this.f3529a.install(this.b);
    }

    @Override // com.stepos.aiengine.model.IModelManager
    public boolean reset() {
        return this.f3529a.reset(this.b);
    }

    @Override // com.stepos.aiengine.model.IModelManager
    public boolean setDefaultModel(String modelId) {
        k.f(modelId, "modelId");
        return false;
    }

    @Override // com.stepos.aiengine.model.IModelManager
    public boolean uninstall() {
        return this.f3529a.uninstall(this.b);
    }
}
