package com.stepos.aiengine.model;

import Q4.g;
import W4.b;
import Z8.C1173v;
import android.os.Bundle;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0016J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bH\u0016J\u001a\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\bH\u0016J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u0010\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\b\u0010\u0014\u001a\u00020\bH\u0016J\b\u0010\u0015\u001a\u00020\bH\u0016J\u0010\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\u0013H\u0016¨\u0006\u0018"}, d2 = {"Lcom/stepos/aiengine/model/StubModelManager;", "Lcom/stepos/aiengine/model/IModelManager;", "<init>", "()V", "getModels", "", "Lcom/stepos/aiengine/model/AlgorithmModelInfo;", "checkUpdate", "", "checkRemote", "getUpdate", "Lcom/stepos/aiengine/model/RemoteModel;", "needNewVersion", "getDownloader", "Lcom/stepos/aiengine/model/IDownloader;", "args", "Landroid/os/Bundle;", b.STEP_INSTALL, "sourcePath", "", "uninstall", "reset", "setDefaultModel", "modelId", "aiengine-api_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class StubModelManager implements IModelManager {
    @Override // com.stepos.aiengine.model.IModelManager
    public boolean checkUpdate(boolean checkRemote) {
        return false;
    }

    @Override // com.stepos.aiengine.model.IModelManager
    public IDownloader getDownloader(Bundle args) {
        p.i(args, "args");
        return new g();
    }

    @Override // com.stepos.aiengine.model.IModelManager
    public List<AlgorithmModelInfo> getModels() {
        return C1173v.m();
    }

    @Override // com.stepos.aiengine.model.IModelManager
    public RemoteModel getUpdate(boolean checkRemote, boolean needNewVersion) {
        return null;
    }

    @Override // com.stepos.aiengine.model.IModelManager
    public boolean install(String sourcePath) {
        p.i(sourcePath, "sourcePath");
        return false;
    }

    @Override // com.stepos.aiengine.model.IModelManager
    public boolean reset() {
        return false;
    }

    @Override // com.stepos.aiengine.model.IModelManager
    public boolean setDefaultModel(String modelId) {
        p.i(modelId, "modelId");
        return false;
    }

    @Override // com.stepos.aiengine.model.IModelManager
    public boolean uninstall() {
        return false;
    }
}
