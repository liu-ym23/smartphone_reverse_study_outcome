package com.obric.matrix.platform.sdk.ones.commonmonitor.fps;

import androidx.annotation.WorkerThread;
import dc.d;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/obric/matrix/platform/sdk/ones/commonmonitor/fps/IFPSCallBack;", "", "Ldc/d;", "fpsBean", "", "fpsCallBack", "(Ldc/d;)V", "sdk_platform_ones_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface IFPSCallBack {
    @WorkerThread
    void fpsCallBack(@Nullable d r10);
}
