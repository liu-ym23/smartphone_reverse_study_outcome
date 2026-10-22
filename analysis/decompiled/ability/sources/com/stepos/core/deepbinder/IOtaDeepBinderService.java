package com.stepos.core.deepbinder;

import android.os.Bundle;
import com.stepos.aiengine.model.AlgorithmModelInfo;
import com.stepos.aiengine.model.AvailableModelInfo;
import com.stepos.deepbinder.annotation.type.AutoRecover;
import com.stepos.deepbinder.annotation.type.ServiceName;
import com.stepos.deepbinder.annotation.type.ValidityCheck;
import f5.InterfaceC1435a;
import java.util.List;
import kotlin.Metadata;

@AutoRecover
@ServiceName("com.stepos.core.ota.deepbinder.OtaDeepBinderServiceImpl")
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\bg\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u0019\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u000b\u0010\fJ\u001d\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u000f\u0010\u0010J\u0015\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\rH&¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0014\u0010\u0006J\u0017\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0015\u0010\u0006J\u0017\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0016\u0010\u0006J\u0017\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0017\u0010\u0006J\u0017\u0010\u0018\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0018\u0010\fJ\u0017\u0010\u0019\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0019\u0010\fJ\u0017\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u001b\u0010\u001cJ\u0017\u0010\u001d\u001a\u00020\u001a2\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u001d\u0010\u001cJ\u0017\u0010\u001e\u001a\u00020\u001a2\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u001e\u0010\u001cJ\u001f\u0010!\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010 \u001a\u00020\u001fH&¢\u0006\u0004\b!\u0010\"J\u001f\u0010#\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010 \u001a\u00020\u001fH&¢\u0006\u0004\b#\u0010\"¨\u0006$"}, d2 = {"Lcom/stepos/core/deepbinder/IOtaDeepBinderService;", "", "", "algorithmId", "LC7/r;", "triggerCheckUpdate", "(Ljava/lang/String;)V", "Landroid/os/Bundle;", "getUpdateInfo", "(Ljava/lang/String;)Landroid/os/Bundle;", "", "checkResources", "(Ljava/lang/String;)I", "", "Lcom/stepos/aiengine/model/AlgorithmModelInfo;", "getModels", "(Ljava/lang/String;)Ljava/util/List;", "Lcom/stepos/aiengine/model/AvailableModelInfo;", "getAvailableModels", "()Ljava/util/List;", "startDownload", "pauseDownload", "resumeDownload", "cancelDownload", "getDownloadProgress", "getDownloadStatus", "", "install", "(Ljava/lang/String;)Z", "uninstall", "reset", "Lf5/a;", "callback", "registerDownloadCallback", "(Ljava/lang/String;Lf5/a;)V", "unregisterDownloadCallback", "shared-lib_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
@ValidityCheck
/* loaded from: classes3.dex */
public interface IOtaDeepBinderService {
    void cancelDownload(String algorithmId);

    int checkResources(String algorithmId);

    List<AvailableModelInfo> getAvailableModels();

    int getDownloadProgress(String algorithmId);

    int getDownloadStatus(String algorithmId);

    List<AlgorithmModelInfo> getModels(String algorithmId);

    Bundle getUpdateInfo(String algorithmId);

    boolean install(String algorithmId);

    void pauseDownload(String algorithmId);

    void registerDownloadCallback(String algorithmId, InterfaceC1435a callback);

    boolean reset(String algorithmId);

    void resumeDownload(String algorithmId);

    void startDownload(String algorithmId);

    void triggerCheckUpdate(String algorithmId);

    boolean uninstall(String algorithmId);

    void unregisterDownloadCallback(String algorithmId, InterfaceC1435a callback);
}
