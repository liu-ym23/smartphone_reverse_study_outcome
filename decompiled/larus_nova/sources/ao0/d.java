package ao0;

import com.bytedance.android.live.base.exception.ApiServerException;
import com.bytedance.android.livesdkapi.ILiveResponseExtraInfo;

/* JADX INFO: loaded from: classes46.dex */
public final class d implements ILiveResponseExtraInfo {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ e f15701a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Throwable f15702b;

    @Override // com.bytedance.android.livesdkapi.ILiveResponseExtraInfo
    public final long getServerTimestamp() {
        return -1;
    }

    @Override // com.bytedance.android.livesdkapi.ILiveResponseExtraInfo
    public final ILiveResponseExtraInfo.IStatusInfo getStatusInfo() {
        e r100 = this.f15701a;
        int r101 = ((ApiServerException) this.f15702b).getErrorCode();
        String r102 = this.f15702b.getMessage();
        String r103 = ((ApiServerException) this.f15702b).getPrompt();
        r100.getClass();
        return new a(r101, r102, r103);
    }

    public d(e r100, Throwable r101) {
        this.f15701a = r100;
        this.f15702b = r101;
    }
}
