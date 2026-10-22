package com.bytedance.android.live.saas.middleware;

import androidx.exifinterface.media.ExifInterface;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J5\u0010\u0002\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u00042\u0006\u0010\u0005\u001a\u0002H\u00042\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000bH&¢\u0006\u0002\u0010\f¨\u0006\r"}, d2 = {"Lcom/bytedance/android/live/saas/middleware/IBDLiveSdkInit;", "", "initialize", "", ExifInterface.GPS_DIRECTION_TRUE, PerfLog.PARAM_KEY_CONTEXT_ID, "sdkConfig", "Lcom/bytedance/android/live/saas/middleware/BDLiveSdkConfig;", "appInfo", "Lcom/bytedance/android/live/saas/middleware/IAppInfo;", "async", "", "(Ljava/lang/Object;Lcom/bytedance/android/live/saas/middleware/BDLiveSdkConfig;Lcom/bytedance/android/live/saas/middleware/IAppInfo;Z)V", "middleware_release"}, k = 1, mv = {1, 4, 3})
public interface IBDLiveSdkInit {

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3})
    public static final class DefaultImpls {
        public static /* synthetic */ void initialize$default(IBDLiveSdkInit r100, Object r101, BDLiveSdkConfig r102, IAppInfo r103, boolean r104, int r105, Object r106) {
            if (r106 != null) goto L9;
            if ((r105 & 8) == 0) goto L6;
            r104 = false;
        L6:
            r100.initialize(r101, r102, r103, r104);
            return;
        L9:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: initialize");
        }
    }

    <T> void initialize(T r100, BDLiveSdkConfig r101, IAppInfo r102, boolean r103);
}
