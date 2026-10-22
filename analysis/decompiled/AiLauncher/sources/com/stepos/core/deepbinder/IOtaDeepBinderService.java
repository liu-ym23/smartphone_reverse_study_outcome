package com.stepos.core.deepbinder;

import W4.b;
import android.os.Bundle;
import com.stepos.aiengine.model.AlgorithmModelInfo;
import com.stepos.aiengine.model.AvailableModelInfo;
import com.stepos.core.download.IDownloadCallback;
import com.stepos.core.download.ModelFlowMeta;
import com.stepos.deepbinder.annotation.type.AutoRecover;
import com.stepos.deepbinder.annotation.type.ServiceName;
import com.stepos.deepbinder.annotation.type.ValidityCheck;
import java.util.List;
import kotlin.Metadata;
import x5.d;

@AutoRecover
@ServiceName("com.stepos.core.ota.deepbinder.OtaDeepBinderServiceImpl")
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000e\bg\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u0019\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u000b\u0010\fJ\u001d\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u000f\u0010\u0010J\u0015\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\rH&¢\u0006\u0004\b\u0012\u0010\u0013J\u0015\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00110\rH&¢\u0006\u0004\b\u0014\u0010\u0013J\u0015\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00110\rH&¢\u0006\u0004\b\u0015\u0010\u0013J\u0017\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0016\u0010\u0006J\u0017\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0017\u0010\u0006J\u0017\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0018\u0010\u0006J\u0017\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0019\u0010\u0006J\u0017\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u001a\u0010\u0006J\u0017\u0010\u001b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u001b\u0010\fJ\u0017\u0010\u001c\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u001c\u0010\fJ\u0017\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u001e\u0010\u001fJ\u0017\u0010 \u001a\u00020\u001d2\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b \u0010\u001fJ\u0017\u0010!\u001a\u00020\u001d2\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b!\u0010\u001fJ\u001f\u0010$\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010#\u001a\u00020\"H&¢\u0006\u0004\b$\u0010%J\u001f\u0010&\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010#\u001a\u00020\"H&¢\u0006\u0004\b&\u0010%J\u0017\u0010(\u001a\u00020\u00042\u0006\u0010#\u001a\u00020'H&¢\u0006\u0004\b(\u0010)J\u0017\u0010*\u001a\u00020\u00042\u0006\u0010#\u001a\u00020'H&¢\u0006\u0004\b*\u0010)J\u0017\u0010+\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b+\u0010\tJ\u0017\u0010,\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b,\u0010\tJ\u0017\u0010-\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b-\u0010\tJ\u0017\u0010.\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b.\u0010\tJ\u000f\u0010/\u001a\u00020\u0007H&¢\u0006\u0004\b/\u00100J\u0017\u00103\u001a\u00020\u00072\u0006\u00102\u001a\u000201H&¢\u0006\u0004\b3\u00104J\u0017\u00105\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b5\u0010\u0006J\u0017\u00106\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b6\u0010\u0006J\u001f\u00108\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010#\u001a\u000207H&¢\u0006\u0004\b8\u00109J\u0017\u0010;\u001a\u00020\u00042\u0006\u0010:\u001a\u00020\u001dH&¢\u0006\u0004\b;\u0010<J'\u0010?\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010=\u001a\u00020\u001d2\u0006\u0010>\u001a\u00020\u001dH&¢\u0006\u0004\b?\u0010@J\u0017\u0010A\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\bA\u0010\fJ\u001f\u0010C\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010B\u001a\u00020\u001dH&¢\u0006\u0004\bC\u0010D¨\u0006E"}, d2 = {"Lcom/stepos/core/deepbinder/IOtaDeepBinderService;", "", "", "algorithmId", "LY8/t;", "triggerCheckUpdate", "(Ljava/lang/String;)V", "Landroid/os/Bundle;", "getUpdateInfo", "(Ljava/lang/String;)Landroid/os/Bundle;", "", "checkResources", "(Ljava/lang/String;)I", "", "Lcom/stepos/aiengine/model/AlgorithmModelInfo;", "getModels", "(Ljava/lang/String;)Ljava/util/List;", "Lcom/stepos/aiengine/model/AvailableModelInfo;", "getAvailableModels", "()Ljava/util/List;", "getAvailableModelsForce", "getPresetModels", "startDownload", "startUpdate", "pauseDownload", "resumeDownload", "cancelDownload", "getDownloadProgress", "getDownloadStatus", "", b.STEP_INSTALL, "(Ljava/lang/String;)Z", "uninstall", "reset", "Lcom/stepos/core/download/IDownloadCallback;", "callback", "registerDownloadCallback", "(Ljava/lang/String;Lcom/stepos/core/download/IDownloadCallback;)V", "unregisterDownloadCallback", "Lcom/stepos/core/deepbinder/IOtaTaskStateCallback;", "registerTaskStateCallback", "(Lcom/stepos/core/deepbinder/IOtaTaskStateCallback;)V", "unregisterTaskStateCallback", "queryDownloadMeta", "queryUpdateMeta", "fetchDownloadMeta", "fetchUpdateMeta", "queryPrecheckEnv", "()Landroid/os/Bundle;", "", "requiredBytes", "queryDownloadResourceGate", "(J)Landroid/os/Bundle;", "beginInteractiveSession", "endInteractiveSession", "Lcom/stepos/core/deepbinder/ICtaResultCallback;", "requestCta", "(Ljava/lang/String;Lcom/stepos/core/deepbinder/ICtaResultCallback;)V", d.EXTRA_ENABLED, "setWlanAutoUpgrade", "(Z)V", ModelFlowMeta.KEY_CELLULAR_ALLOWED, "enableWifiAuto", "executeDownload", "(Ljava/lang/String;ZZ)V", "queryNoNetworkPromptState", "scheduled", "recordNoNetworkDownloadDecision", "(Ljava/lang/String;Z)V", "shared-lib_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
@ValidityCheck
/* loaded from: classes3.dex */
public interface IOtaDeepBinderService {
    void beginInteractiveSession(String algorithmId);

    void cancelDownload(String algorithmId);

    int checkResources(String algorithmId);

    void endInteractiveSession(String algorithmId);

    void executeDownload(String algorithmId, boolean cellularAllowed, boolean enableWifiAuto);

    Bundle fetchDownloadMeta(String algorithmId);

    Bundle fetchUpdateMeta(String algorithmId);

    List<AvailableModelInfo> getAvailableModels();

    List<AvailableModelInfo> getAvailableModelsForce();

    int getDownloadProgress(String algorithmId);

    int getDownloadStatus(String algorithmId);

    List<AlgorithmModelInfo> getModels(String algorithmId);

    List<AvailableModelInfo> getPresetModels();

    Bundle getUpdateInfo(String algorithmId);

    boolean install(String algorithmId);

    void pauseDownload(String algorithmId);

    Bundle queryDownloadMeta(String algorithmId);

    Bundle queryDownloadResourceGate(long requiredBytes);

    int queryNoNetworkPromptState(String algorithmId);

    Bundle queryPrecheckEnv();

    Bundle queryUpdateMeta(String algorithmId);

    void recordNoNetworkDownloadDecision(String algorithmId, boolean scheduled);

    void registerDownloadCallback(String algorithmId, IDownloadCallback callback);

    void registerTaskStateCallback(IOtaTaskStateCallback callback);

    void requestCta(String algorithmId, ICtaResultCallback callback);

    boolean reset(String algorithmId);

    void resumeDownload(String algorithmId);

    void setWlanAutoUpgrade(boolean enabled);

    void startDownload(String algorithmId);

    void startUpdate(String algorithmId);

    void triggerCheckUpdate(String algorithmId);

    boolean uninstall(String algorithmId);

    void unregisterDownloadCallback(String algorithmId, IDownloadCallback callback);

    void unregisterTaskStateCallback(IOtaTaskStateCallback callback);
}
