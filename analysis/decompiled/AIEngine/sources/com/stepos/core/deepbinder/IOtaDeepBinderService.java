package com.stepos.core.deepbinder;

import android.os.Bundle;
import com.stepos.aiengine.model.AlgorithmModelInfo;
import com.stepos.aiengine.model.AvailableModelInfo;
import com.stepos.core.download.IDownloadCallback;
import com.stepos.deepbinder.annotation.parameter.WeakRef;
import com.stepos.deepbinder.annotation.type.AutoRecover;
import com.stepos.deepbinder.annotation.type.ServiceName;
import com.stepos.deepbinder.annotation.type.ValidityCheck;
import java.util.List;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
@AutoRecover
@ServiceName("com.stepos.core.ota.deepbinder.OtaDeepBinderServiceImpl")
@ValidityCheck
/* loaded from: classes.dex */
public interface IOtaDeepBinderService {
    void beginInteractiveSession(String str);

    void cancelDownload(String str);

    int checkResources(String str);

    void endInteractiveSession(String str);

    void executeDownload(String str, boolean z, boolean z3);

    Bundle fetchDownloadMeta(String str);

    Bundle fetchUpdateMeta(String str);

    List<AvailableModelInfo> getAvailableModels();

    List<AvailableModelInfo> getAvailableModelsForce();

    int getDownloadProgress(String str);

    int getDownloadStatus(String str);

    List<AlgorithmModelInfo> getModels(String str);

    List<AvailableModelInfo> getPresetModels();

    Bundle getUpdateInfo(String str);

    boolean install(String str);

    void pauseDownload(String str);

    Bundle queryDownloadMeta(String str);

    Bundle queryDownloadResourceGate(long j10);

    int queryNoNetworkPromptState(String str);

    Bundle queryPrecheckEnv();

    Bundle queryUpdateMeta(String str);

    void recordNoNetworkDownloadDecision(String str, boolean z);

    void registerDownloadCallback(String str, @WeakRef IDownloadCallback iDownloadCallback);

    void registerTaskStateCallback(@WeakRef IOtaTaskStateCallback iOtaTaskStateCallback);

    void requestCta(String str, @WeakRef ICtaResultCallback iCtaResultCallback);

    boolean reset(String str);

    void resumeDownload(String str);

    void setWlanAutoUpgrade(boolean z);

    void startDownload(String str);

    void startUpdate(String str);

    void triggerCheckUpdate(String str);

    boolean uninstall(String str);

    void unregisterDownloadCallback(String str, @WeakRef IDownloadCallback iDownloadCallback);

    void unregisterTaskStateCallback(@WeakRef IOtaTaskStateCallback iOtaTaskStateCallback);
}
