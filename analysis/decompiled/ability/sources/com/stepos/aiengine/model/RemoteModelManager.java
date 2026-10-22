package com.stepos.aiengine.model;

import B7.a;
import C7.r;
import android.os.Bundle;
import android.util.Log;
import androidx.autofill.HintConstants;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.stepos.agentframework.adapter.bff.BffConstant;
import com.stepos.core.deepbinder.IOtaDeepBinderService;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.b;
import kotlin.collections.EmptyList;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0015\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000e\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ!\u0010\u0012\u001a\u0004\u0018\u00010\u00112\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\fH\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0015\u001a\u00020\u0014H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u0017\u0010\u001a\u001a\u00020\f2\u0006\u0010\u0019\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ\u000f\u0010\u001c\u001a\u00020\fH\u0016¢\u0006\u0004\b\u001c\u0010\u001dJ\u000f\u0010\u001e\u001a\u00020\fH\u0016¢\u0006\u0004\b\u001e\u0010\u001dJ\u0017\u0010 \u001a\u00020\f2\u0006\u0010\u001f\u001a\u00020\u0002H\u0016¢\u0006\u0004\b \u0010\u001b¨\u0006!"}, d2 = {"Lcom/stepos/aiengine/model/RemoteModelManager;", "Lcom/stepos/aiengine/model/IModelManager;", "", "algorithmId", "Lcom/stepos/core/deepbinder/IOtaDeepBinderService;", "svc", AppAgent.CONSTRUCT, "(Ljava/lang/String;Lcom/stepos/core/deepbinder/IOtaDeepBinderService;)V", "", "Lcom/stepos/aiengine/model/AlgorithmModelInfo;", "getModels", "()Ljava/util/List;", "", "checkRemote", "checkUpdate", "(Z)Z", "needNewVersion", "Lcom/stepos/aiengine/model/RemoteModel;", "getUpdate", "(ZZ)Lcom/stepos/aiengine/model/RemoteModel;", "Landroid/os/Bundle;", "args", "Lcom/stepos/aiengine/model/IDownloader;", "getDownloader", "(Landroid/os/Bundle;)Lcom/stepos/aiengine/model/IDownloader;", "sourcePath", "install", "(Ljava/lang/String;)Z", "uninstall", "()Z", "reset", "modelId", "setDefaultModel", "aiengine-api_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class RemoteModelManager implements IModelManager {

    /* renamed from: a, reason: collision with root package name */
    public final String f3532a;
    public final IOtaDeepBinderService b;
    public final String c;

    public RemoteModelManager(String algorithmId, IOtaDeepBinderService svc) {
        k.f(algorithmId, "algorithmId");
        k.f(svc, "svc");
        this.f3532a = algorithmId;
        this.b = svc;
        this.c = a.m("RemoteModelManager[", algorithmId, "]");
    }

    @Override // com.stepos.aiengine.model.IModelManager
    public boolean checkUpdate(boolean checkRemote) {
        Object objA;
        Object objA2;
        String str = this.c;
        Log.d(str, "checkUpdate checkRemote=" + checkRemote);
        String str2 = this.f3532a;
        IOtaDeepBinderService iOtaDeepBinderService = this.b;
        if (checkRemote) {
            try {
                iOtaDeepBinderService.triggerCheckUpdate(str2);
                objA = r.f317a;
            } catch (Throwable th) {
                objA = b.a(th);
            }
            Throwable thA = Result.a(objA);
            if (thA != null) {
                Log.e(str, "triggerCheckUpdate failed", thA);
            }
        }
        try {
            objA2 = Boolean.valueOf(iOtaDeepBinderService.getUpdateInfo(str2) != null);
        } catch (Throwable th2) {
            objA2 = b.a(th2);
        }
        Throwable thA2 = Result.a(objA2);
        if (thA2 != null) {
            Log.e(str, "getUpdateInfo failed", thA2);
        }
        Boolean bool = Boolean.FALSE;
        if (objA2 instanceof Result.Failure) {
            objA2 = bool;
        }
        return ((Boolean) objA2).booleanValue();
    }

    @Override // com.stepos.aiengine.model.IModelManager
    public IDownloader getDownloader(Bundle args) {
        k.f(args, "args");
        Log.d(this.c, "getDownloader");
        return new RemoteDownloader(this.f3532a, this.b);
    }

    @Override // com.stepos.aiengine.model.IModelManager
    public List<AlgorithmModelInfo> getModels() {
        Object objA;
        String str = this.c;
        Log.d(str, "getModels");
        try {
            objA = this.b.getModels(this.f3532a);
        } catch (Throwable th) {
            objA = b.a(th);
        }
        Throwable thA = Result.a(objA);
        if (thA != null) {
            Log.e(str, "getModels failed", thA);
        }
        EmptyList emptyList = EmptyList.f4893a;
        if (objA instanceof Result.Failure) {
            objA = emptyList;
        }
        return (List) objA;
    }

    @Override // com.stepos.aiengine.model.IModelManager
    public RemoteModel getUpdate(boolean checkRemote, boolean needNewVersion) {
        Object objA;
        Object objA2;
        String str = this.c;
        Log.d(str, "getUpdate checkRemote=" + checkRemote);
        String str2 = this.f3532a;
        IOtaDeepBinderService iOtaDeepBinderService = this.b;
        if (checkRemote) {
            try {
                iOtaDeepBinderService.triggerCheckUpdate(str2);
                objA2 = r.f317a;
            } catch (Throwable th) {
                objA2 = b.a(th);
            }
            Throwable thA = Result.a(objA2);
            if (thA != null) {
                Log.e(str, "triggerCheckUpdate failed", thA);
            }
        }
        try {
            objA = iOtaDeepBinderService.getUpdateInfo(str2);
        } catch (Throwable th2) {
            objA = b.a(th2);
        }
        Throwable thA2 = Result.a(objA);
        if (thA2 != null) {
            Log.e(str, "getUpdateInfo failed", thA2);
        }
        if (objA instanceof Result.Failure) {
            objA = null;
        }
        Bundle bundle = (Bundle) objA;
        if (bundle == null) {
            Log.d(str, "getUpdate: getUpdateInfo returned null (no remote update or not in updates list) checkRemote=" + checkRemote);
            return null;
        }
        String string = bundle.getString(HintConstants.AUTOFILL_HINT_NAME, "");
        k.e(string, "getString(...)");
        int i = bundle.getInt("versionCode", 0);
        String string2 = bundle.getString(BffConstant.Type.Url, "");
        k.e(string2, "getString(...)");
        long j5 = bundle.getLong("fileSize");
        String string3 = bundle.getString("md5", "");
        k.e(string3, "getString(...)");
        String string4 = bundle.getString("updateInfo", "");
        k.e(string4, "getString(...)");
        long j6 = bundle.getLong("updateTime", 0L);
        List stringArrayList = bundle.getStringArrayList("abilities");
        if (stringArrayList == null) {
            stringArrayList = EmptyList.f4893a;
        }
        List list = stringArrayList;
        List stringArrayList2 = bundle.getStringArrayList("dependencies");
        if (stringArrayList2 == null) {
            stringArrayList2 = EmptyList.f4893a;
        }
        RemoteModel remoteModel = new RemoteModel(string, i, string2, j5, string3, string4, j6, list, stringArrayList2);
        Log.i(str, "getUpdate: " + remoteModel);
        return remoteModel;
    }

    @Override // com.stepos.aiengine.model.IModelManager
    public boolean install(String sourcePath) {
        Object objA;
        k.f(sourcePath, "sourcePath");
        String strConcat = "install sourcePath=".concat(sourcePath);
        String str = this.c;
        Log.d(str, strConcat);
        try {
            objA = Boolean.valueOf(this.b.install(this.f3532a));
        } catch (Throwable th) {
            objA = b.a(th);
        }
        Throwable thA = Result.a(objA);
        if (thA != null) {
            Log.e(str, "install failed", thA);
        }
        Boolean bool = Boolean.FALSE;
        if (objA instanceof Result.Failure) {
            objA = bool;
        }
        return ((Boolean) objA).booleanValue();
    }

    @Override // com.stepos.aiengine.model.IModelManager
    public boolean reset() {
        Object objA;
        String str = this.c;
        Log.i(str, "reset");
        try {
            objA = Boolean.valueOf(this.b.reset(this.f3532a));
        } catch (Throwable th) {
            objA = b.a(th);
        }
        Throwable thA = Result.a(objA);
        if (thA != null) {
            Log.e(str, "reset failed", thA);
        }
        Boolean bool = Boolean.FALSE;
        if (objA instanceof Result.Failure) {
            objA = bool;
        }
        return ((Boolean) objA).booleanValue();
    }

    @Override // com.stepos.aiengine.model.IModelManager
    public boolean setDefaultModel(String modelId) {
        k.f(modelId, "modelId");
        return true;
    }

    @Override // com.stepos.aiengine.model.IModelManager
    public boolean uninstall() {
        Object objA;
        String str = this.c;
        Log.i(str, "uninstall");
        try {
            objA = Boolean.valueOf(this.b.uninstall(this.f3532a));
        } catch (Throwable th) {
            objA = b.a(th);
        }
        Throwable thA = Result.a(objA);
        if (thA != null) {
            Log.e(str, "uninstall failed", thA);
        }
        Boolean bool = Boolean.FALSE;
        if (objA instanceof Result.Failure) {
            objA = bool;
        }
        return ((Boolean) objA).booleanValue();
    }
}
