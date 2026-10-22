package a40;

import com.bytedance.android.live.base.exception.ApiException;
import com.bytedance.android.live.cloudgrouplive.utils.CloudGroupLiveTraceEvent;
import com.ss.android.ttvecamera.TECameraSettings;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes45.dex */
public final class f<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ m f1721a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ long f1722b;

    public f(com.bytedance.android.live.cloudgrouplive.core.c r100, long r101) {
        this.f1721a = r100;
        this.f1722b = r101;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Throwable r101 = (Throwable) r100;
        int r102 = f40.a.f475503a;
        CloudGroupLiveTraceEvent r103 = CloudGroupLiveTraceEvent.API_MANAGER;
        StringBuilder r104 = new StringBuilder(TECameraSettings.PictureCallback.ERROR_CODE_SPLIT_REGEX);
        Integer r105 = null;
        if ((r101 instanceof ApiException) == true) goto L5;
        Throwable r106 = null;
    L6:
        ApiException r107 = (ApiException) r106;
        if (r107 == null) goto L9;
        r105 = Integer.valueOf(r107.getErrorCode());
    L9:
        r104.append(r105);
        r104.append(", errorMsg=");
        r104.append(r101.getMessage());
        f40.a.d(r103, "JoinCloudGroupLiveFailed", 0, r104.toString(), 20);
        m r108 = this.f1721a;
        if (r108 == null) goto L13;
        r108.a3(dc6.a.a(this.f1722b), r101);
        return;
    L13:
        return;
    L5:
        r106 = r101;
        goto L6
    }
}
