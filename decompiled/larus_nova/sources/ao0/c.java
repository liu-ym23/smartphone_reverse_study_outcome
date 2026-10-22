package ao0;

import com.bytedance.android.live.api.exceptions.local.ApiLocalException;
import com.bytedance.android.livesdkapi.ILiveResponseExtraInfo;

/* JADX INFO: loaded from: classes46.dex */
public final class c implements ILiveResponseExtraInfo {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ e f15699a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Throwable f15700b;

    @Override // com.bytedance.android.livesdkapi.ILiveResponseExtraInfo
    public final long getServerTimestamp() {
        return -1;
    }

    @Override // com.bytedance.android.livesdkapi.ILiveResponseExtraInfo
    public final ILiveResponseExtraInfo.IStatusInfo getStatusInfo() {
        e r100 = this.f15699a;
        int r101 = ((ApiLocalException) this.f15700b).getErrorCode();
        String r102 = this.f15700b.getMessage();
        r100.getClass();
        return new a(r101, r102, "");
    }

    public c(e r100, Throwable r101) {
        this.f15699a = r100;
        this.f15700b = r101;
    }
}
