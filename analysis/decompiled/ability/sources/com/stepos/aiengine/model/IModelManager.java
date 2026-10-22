package com.stepos.aiengine.model;

import android.os.Bundle;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\u000e\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H&J\u0012\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u0006H&J\u001e\u0010\b\u001a\u0004\u0018\u00010\t2\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\n\u001a\u00020\u0006H&J\u0012\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000eH&J\u0010\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u0011H&J\b\u0010\u0012\u001a\u00020\u0006H&J\b\u0010\u0013\u001a\u00020\u0006H&J\u0010\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u0011H&¨\u0006\u0016"}, d2 = {"Lcom/stepos/aiengine/model/IModelManager;", "", "getModels", "", "Lcom/stepos/aiengine/model/AlgorithmModelInfo;", "checkUpdate", "", "checkRemote", "getUpdate", "Lcom/stepos/aiengine/model/RemoteModel;", "needNewVersion", "getDownloader", "Lcom/stepos/aiengine/model/IDownloader;", "args", "Landroid/os/Bundle;", "install", "sourcePath", "", "uninstall", "reset", "setDefaultModel", "modelId", "shared-lib_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public interface IModelManager {

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class DefaultImpls {
        public static /* synthetic */ boolean checkUpdate$default(IModelManager iModelManager, boolean z10, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: checkUpdate");
            }
            if ((i & 1) != 0) {
                z10 = false;
            }
            return iModelManager.checkUpdate(z10);
        }

        public static /* synthetic */ IDownloader getDownloader$default(IModelManager iModelManager, Bundle bundle, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getDownloader");
            }
            if ((i & 1) != 0) {
                bundle = Bundle.EMPTY;
            }
            return iModelManager.getDownloader(bundle);
        }

        public static /* synthetic */ RemoteModel getUpdate$default(IModelManager iModelManager, boolean z10, boolean z11, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getUpdate");
            }
            if ((i & 1) != 0) {
                z10 = false;
            }
            if ((i & 2) != 0) {
                z11 = true;
            }
            return iModelManager.getUpdate(z10, z11);
        }
    }

    boolean checkUpdate(boolean checkRemote);

    IDownloader getDownloader(Bundle args);

    List<AlgorithmModelInfo> getModels();

    RemoteModel getUpdate(boolean checkRemote, boolean needNewVersion);

    boolean install(String sourcePath);

    boolean reset();

    boolean setDefaultModel(String modelId);

    boolean uninstall();
}
