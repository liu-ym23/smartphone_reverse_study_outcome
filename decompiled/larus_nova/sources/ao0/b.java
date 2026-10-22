package ao0;

import com.bytedance.android.live.api.exceptions.local.ResponseNoDataException;
import com.bytedance.android.live.network.response.BaseResponse;
import com.bytedance.android.live.network.response.RequestError;
import com.bytedance.android.livesdkapi.ILiveResponseExtraInfo;

/* JADX INFO: loaded from: classes46.dex */
public final class b implements ILiveResponseExtraInfo {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ e f15697a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Throwable f15698b;

    @Override // com.bytedance.android.livesdkapi.ILiveResponseExtraInfo
    public final long getServerTimestamp() {
        BaseResponse r100 = ((ResponseNoDataException) this.f15698b).getResponse();
        if (r100 == null) goto L8;
        R r101 = r100.extra;
        if (r101 == 0) goto L8;
        return r101.now;
    L8:
        return System.currentTimeMillis();
    }

    @Override // com.bytedance.android.livesdkapi.ILiveResponseExtraInfo
    public final ILiveResponseExtraInfo.IStatusInfo getStatusInfo() {
        e r100 = this.f15697a;
        int r101 = ((ResponseNoDataException) this.f15698b).getErrorCode();
        String r102 = this.f15698b.getMessage();
        BaseResponse r103 = ((ResponseNoDataException) this.f15698b).getResponse();
        if (r103 == null) goto L7;
        RequestError r104 = r103.error;
        if (r104 == null) goto L7;
        String r105 = r104.prompts;
    L8:
        r100.getClass();
        return new a(r101, r102, r105);
    L7:
        r105 = null;
        goto L8
    }

    public b(e r100, Throwable r101) {
        this.f15697a = r100;
        this.f15698b = r101;
    }
}
