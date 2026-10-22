package com.stepos.aiengine.model;

import android.os.Bundle;
import java.util.List;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public interface IModelManager {

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class DefaultImpls {
        public static /* synthetic */ boolean checkUpdate$default(IModelManager iModelManager, boolean z, int i10, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: checkUpdate");
            }
            if ((i10 & 1) != 0) {
                z = false;
            }
            return iModelManager.checkUpdate(z);
        }

        public static /* synthetic */ IDownloader getDownloader$default(IModelManager iModelManager, Bundle bundle, int i10, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getDownloader");
            }
            if ((i10 & 1) != 0) {
                bundle = Bundle.EMPTY;
            }
            return iModelManager.getDownloader(bundle);
        }

        public static /* synthetic */ RemoteModel getUpdate$default(IModelManager iModelManager, boolean z, boolean z3, int i10, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getUpdate");
            }
            if ((i10 & 1) != 0) {
                z = false;
            }
            if ((i10 & 2) != 0) {
                z3 = true;
            }
            return iModelManager.getUpdate(z, z3);
        }
    }

    boolean checkUpdate(boolean z);

    IDownloader getDownloader(Bundle bundle);

    List<AlgorithmModelInfo> getModels();

    RemoteModel getUpdate(boolean z, boolean z3);

    boolean install(String str);

    boolean reset();

    boolean setDefaultModel(String str);

    boolean uninstall();
}
