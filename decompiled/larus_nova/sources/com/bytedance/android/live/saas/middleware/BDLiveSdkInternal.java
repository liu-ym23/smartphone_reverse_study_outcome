package com.bytedance.android.live.saas.middleware;

import android.content.Context;
import androidx.exifinterface.media.ExifInterface;
import com.bytedance.android.live.saas.middleware.utils.AppContextWrapper;
import com.ss.android.lark.utils.statistics.PerfLog;
import eta.b;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0016\u0010\u0015J5\u0010\u000b\u001a\u00020\n\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u00028\u00002\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000b\u0010\fR(\u0010\u000e\u001a\u00020\r8\u0006@\u0006X\u0087.¢\u0006\u0018\n\u0004\b\u000e\u0010\u000f\u0012\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013¨\u0006\u0017"}, d2 = {"Lcom/bytedance/android/live/saas/middleware/BDLiveSdkInternal;", "Lcom/bytedance/android/live/saas/middleware/IBDLiveSdkInit;", ExifInterface.GPS_DIRECTION_TRUE, PerfLog.PARAM_KEY_CONTEXT_ID, "Lcom/bytedance/android/live/saas/middleware/BDLiveSdkConfig;", "sdkConfig", "Lcom/bytedance/android/live/saas/middleware/IAppInfo;", "appInfo", "", "async", "", "initialize", "(Ljava/lang/Object;Lcom/bytedance/android/live/saas/middleware/BDLiveSdkConfig;Lcom/bytedance/android/live/saas/middleware/IAppInfo;Z)V", "Leta/b;", "appContext", "Leta/b;", "getAppContext", "()Leta/b;", "setAppContext", "(Leta/b;)V", "getAppContext$annotations", "()V", "<init>", "middleware_release"}, k = 1, mv = {1, 4, 3})
public final class BDLiveSdkInternal implements IBDLiveSdkInit {
    public static final BDLiveSdkInternal INSTANCE = null;
    public static b appContext;

    private BDLiveSdkInternal() {
    }

    @JvmStatic
    public static /* synthetic */ void getAppContext$annotations() {
    }

    static {
        INSTANCE = new BDLiveSdkInternal();
    }

    public static final b getAppContext() {
        b r100 = appContext;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("appContext");
    L5:
        return r100;
    }

    public static final void setAppContext(b r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        appContext = r100;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.android.live.saas.middleware.IBDLiveSdkInit
    public <T> void initialize(T r100, BDLiveSdkConfig r101, IAppInfo r102, boolean r103) {
        Intrinsics.checkNotNullParameter(r101, "sdkConfig");
        Intrinsics.checkNotNullParameter(r102, "appInfo");
        if ((r100 instanceof b) == false) goto L6;
        b r104 = (b) r100;
        appContext = r104;
        BDLiveSdk.initialize(r104.getContext(), r101, r102, r103);
        return;
    L6:
        if ((r100 instanceof Context) == false) goto L10;
        Context r105 = (Context) r100;
        appContext = new AppContextWrapper(r105, r102);
        BDLiveSdk.initialize(r105, r101, r102, r103);
        return;
    L10:
        throw new IllegalArgumentException("context is not AppContext or Context");
    }
}
