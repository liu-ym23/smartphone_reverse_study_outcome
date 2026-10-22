package a40;

import com.bytedance.android.live.cloudgrouplive.utils.CloudGroupLiveTraceEvent;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes45.dex */
public final class e<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ m f1719a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ long f1720b;

    public e(com.bytedance.android.live.cloudgrouplive.core.c r100, long r101) {
        this.f1719a = r100;
        this.f1720b = r101;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        com.bytedance.android.live.network.response.a r101 = (com.bytedance.android.live.network.response.a) r100;
        int r102 = f40.a.f475503a;
        f40.a.d(CloudGroupLiveTraceEvent.API_MANAGER, "JoinCloudGroupLiveSuccess", 0, null, 28);
        m r103 = this.f1719a;
        if (r103 == null) goto L6;
        r103.b3(dc6.a.a(this.f1720b));
        return;
    }
}
