package com.stepos.aiengine.model;

import W4.b;
import Y8.t;
import Z8.C1173v;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.core.deepbinder.IOtaDeepBinderService;
import com.stepos.statsapp.v3.lib.plugin.constants.Parameters;
import java.util.List;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0013\b\u0000\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u0015\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0016¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J!\u0010\u0014\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0017\u001a\u00020\u0016H\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ\u0017\u0010\u001c\u001a\u00020\u000e2\u0006\u0010\u001b\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u001c\u0010\u001dJ\u000f\u0010\u001e\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u001e\u0010\u001fJ\u000f\u0010 \u001a\u00020\u000eH\u0016¢\u0006\u0004\b \u0010\u001fJ\u0017\u0010\"\u001a\u00020\u000e2\u0006\u0010!\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\"\u0010\u001dR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b#\u0010$R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b%\u0010&R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b'\u0010(R\u0014\u0010*\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b)\u0010$¨\u0006+"}, d2 = {"Lcom/stepos/aiengine/model/RemoteModelManager;", "Lcom/stepos/aiengine/model/IModelManager;", "", "algorithmId", "Lcom/stepos/core/deepbinder/IOtaDeepBinderService;", "svc", "Landroid/content/Context;", "context", "<init>", "(Ljava/lang/String;Lcom/stepos/core/deepbinder/IOtaDeepBinderService;Landroid/content/Context;)V", "", "Lcom/stepos/aiengine/model/AlgorithmModelInfo;", "getModels", "()Ljava/util/List;", "", "checkRemote", "checkUpdate", "(Z)Z", "needNewVersion", "Lcom/stepos/aiengine/model/RemoteModel;", "getUpdate", "(ZZ)Lcom/stepos/aiengine/model/RemoteModel;", "Landroid/os/Bundle;", "args", "Lcom/stepos/aiengine/model/IDownloader;", "getDownloader", "(Landroid/os/Bundle;)Lcom/stepos/aiengine/model/IDownloader;", "sourcePath", b.STEP_INSTALL, "(Ljava/lang/String;)Z", "uninstall", "()Z", "reset", "modelId", "setDefaultModel", Const.INTENT_KEY_APIKEY, "Ljava/lang/String;", Const.INTENT_KEY_PKGNAME, "Lcom/stepos/core/deepbinder/IOtaDeepBinderService;", "c", "Landroid/content/Context;", Const.INTENT_KEY_UMID, "TAG", "aiengine-api_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class RemoteModelManager implements IModelManager {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final String algorithmId;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final IOtaDeepBinderService svc;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public final Context context;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public final String TAG;

    public RemoteModelManager(String algorithmId, IOtaDeepBinderService svc, Context context) {
        p.i(algorithmId, "algorithmId");
        p.i(svc, "svc");
        p.i(context, "context");
        this.algorithmId = algorithmId;
        this.svc = svc;
        this.context = context;
        this.TAG = "RemoteModelManager[" + algorithmId + "]";
    }

    @Override // com.stepos.aiengine.model.IModelManager
    public boolean checkUpdate(boolean checkRemote) {
        Object objB;
        Object objB2;
        Log.d(this.TAG, "checkUpdate checkRemote=" + checkRemote);
        if (checkRemote) {
            try {
                Result.Companion companion = Result.INSTANCE;
                this.svc.triggerCheckUpdate(this.algorithmId);
                objB = Result.b(t.f7040a);
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                objB = Result.b(C4849c.a(th));
            }
            Throwable thE = Result.e(objB);
            if (thE != null) {
                Log.e(this.TAG, "triggerCheckUpdate failed", thE);
            }
        }
        try {
            Result.Companion companion3 = Result.INSTANCE;
            objB2 = Result.b(Boolean.valueOf(this.svc.getUpdateInfo(this.algorithmId) != null));
        } catch (Throwable th2) {
            Result.Companion companion4 = Result.INSTANCE;
            objB2 = Result.b(C4849c.a(th2));
        }
        Throwable thE2 = Result.e(objB2);
        if (thE2 != null) {
            Log.e(this.TAG, "getUpdateInfo failed", thE2);
        }
        Boolean bool = Boolean.FALSE;
        if (Result.g(objB2)) {
            objB2 = bool;
        }
        return ((Boolean) objB2).booleanValue();
    }

    @Override // com.stepos.aiengine.model.IModelManager
    public IDownloader getDownloader(Bundle args) {
        p.i(args, "args");
        Log.d(this.TAG, "getDownloader");
        return new RemoteDownloader(this.algorithmId, this.svc, this.context);
    }

    @Override // com.stepos.aiengine.model.IModelManager
    public List<AlgorithmModelInfo> getModels() {
        Object objB;
        Log.d(this.TAG, "getModels");
        try {
            Result.Companion companion = Result.INSTANCE;
            objB = Result.b(this.svc.getModels(this.algorithmId));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        Throwable thE = Result.e(objB);
        if (thE != null) {
            Log.e(this.TAG, "getModels failed", thE);
        }
        List listM = C1173v.m();
        if (Result.g(objB)) {
            objB = listM;
        }
        return (List) objB;
    }

    @Override // com.stepos.aiengine.model.IModelManager
    public RemoteModel getUpdate(boolean checkRemote, boolean needNewVersion) {
        Object objB;
        Object objB2;
        Log.d(this.TAG, "getUpdate checkRemote=" + checkRemote);
        if (checkRemote) {
            try {
                Result.Companion companion = Result.INSTANCE;
                this.svc.triggerCheckUpdate(this.algorithmId);
                objB = Result.b(t.f7040a);
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                objB = Result.b(C4849c.a(th));
            }
            Throwable thE = Result.e(objB);
            if (thE != null) {
                Log.e(this.TAG, "triggerCheckUpdate failed", thE);
            }
        }
        try {
            Result.Companion companion3 = Result.INSTANCE;
            objB2 = Result.b(this.svc.getUpdateInfo(this.algorithmId));
        } catch (Throwable th2) {
            Result.Companion companion4 = Result.INSTANCE;
            objB2 = Result.b(C4849c.a(th2));
        }
        Throwable thE2 = Result.e(objB2);
        if (thE2 != null) {
            Log.e(this.TAG, "getUpdateInfo failed", thE2);
        }
        if (Result.g(objB2)) {
            objB2 = null;
        }
        Bundle bundle = (Bundle) objB2;
        if (bundle == null) {
            Log.d(this.TAG, "getUpdate: getUpdateInfo returned null (no remote update or not in updates list) checkRemote=" + checkRemote);
            return null;
        }
        String string = bundle.getString("name", "");
        p.h(string, "getString(...)");
        int i10 = bundle.getInt("versionCode", 0);
        String string2 = bundle.getString("url", "");
        p.h(string2, "getString(...)");
        long j10 = bundle.getLong("fileSize");
        String string3 = bundle.getString(Parameters.UPLOAD_REQUEST_PARAM_MD5, "");
        p.h(string3, "getString(...)");
        String string4 = bundle.getString("updateInfo", "");
        p.h(string4, "getString(...)");
        long j11 = bundle.getLong("updateTime", 0L);
        List stringArrayList = bundle.getStringArrayList("abilities");
        if (stringArrayList == null) {
            stringArrayList = C1173v.m();
        }
        List list = stringArrayList;
        List stringArrayList2 = bundle.getStringArrayList("dependencies");
        if (stringArrayList2 == null) {
            stringArrayList2 = C1173v.m();
        }
        RemoteModel remoteModel = new RemoteModel(string, i10, string2, j10, string3, string4, j11, list, stringArrayList2);
        Log.i(this.TAG, "getUpdate: " + remoteModel);
        return remoteModel;
    }

    @Override // com.stepos.aiengine.model.IModelManager
    public boolean install(String sourcePath) {
        Object objB;
        p.i(sourcePath, "sourcePath");
        Log.d(this.TAG, "install sourcePath=" + sourcePath);
        try {
            Result.Companion companion = Result.INSTANCE;
            objB = Result.b(Boolean.valueOf(this.svc.install(this.algorithmId)));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        Throwable thE = Result.e(objB);
        if (thE != null) {
            Log.e(this.TAG, "install failed", thE);
        }
        Boolean bool = Boolean.FALSE;
        if (Result.g(objB)) {
            objB = bool;
        }
        return ((Boolean) objB).booleanValue();
    }

    @Override // com.stepos.aiengine.model.IModelManager
    public boolean reset() {
        Object objB;
        Log.i(this.TAG, "reset");
        try {
            Result.Companion companion = Result.INSTANCE;
            objB = Result.b(Boolean.valueOf(this.svc.reset(this.algorithmId)));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        Throwable thE = Result.e(objB);
        if (thE != null) {
            Log.e(this.TAG, "reset failed", thE);
        }
        Boolean bool = Boolean.FALSE;
        if (Result.g(objB)) {
            objB = bool;
        }
        return ((Boolean) objB).booleanValue();
    }

    @Override // com.stepos.aiengine.model.IModelManager
    public boolean setDefaultModel(String modelId) {
        p.i(modelId, "modelId");
        return true;
    }

    @Override // com.stepos.aiengine.model.IModelManager
    public boolean uninstall() {
        Object objB;
        Log.i(this.TAG, "uninstall");
        try {
            Result.Companion companion = Result.INSTANCE;
            objB = Result.b(Boolean.valueOf(this.svc.uninstall(this.algorithmId)));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        Throwable thE = Result.e(objB);
        if (thE != null) {
            Log.e(this.TAG, "uninstall failed", thE);
        }
        Boolean bool = Boolean.FALSE;
        if (Result.g(objB)) {
            objB = bool;
        }
        return ((Boolean) objB).booleanValue();
    }
}
