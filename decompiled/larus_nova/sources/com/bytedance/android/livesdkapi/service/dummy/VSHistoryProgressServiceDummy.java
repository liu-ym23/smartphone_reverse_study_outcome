package com.bytedance.android.livesdkapi.service.dummy;

import com.bytedance.android.livesdkapi.service.vs.IVSHistoryProgressService;
import com.bytedance.sdk.account.platform.base.OnekeyLoginConstants;
import io.reactivex.Observable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0017\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¢\u0006\u0002\u0010\u0007J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0004H\u0016J\u001a\u0010\n\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u000b2\u0006\u0010\t\u001a\u00020\u0004H\u0016J\u0018\u0010\f\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u0004H\u0016J \u0010\u000f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\u0018\u0010\u0014\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0004H\u0016J\u0018\u0010\u0015\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0004H\u0016J(\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u000b2\u0006\u0010\u0017\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u0019H\u0016¨\u0006\u001a"}, d2 = {"Lcom/bytedance/android/livesdkapi/service/dummy/VSHistoryProgressServiceDummy;", "Lcom/bytedance/android/livesdkapi/service/vs/IVSHistoryProgressService;", "()V", "getFirstShowTime", "", "any", "", "(Ljava/lang/Object;)Ljava/lang/Long;", "getLocalPlayProgress", "episodeId", "getServerPlayProgress", "Lio/reactivex/Observable;", "leave", "", "leaveLocation", "saveFirstShowProgressToLocal", "roomId", "duration", "hasClickLatest", "", "saveProgressToLocal", "saveProgressToServer", "synPlayHistory", "seasonId", OnekeyLoginConstants.CU_KEY_SEQ, "", "livesdkapi_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class VSHistoryProgressServiceDummy implements IVSHistoryProgressService {
    public VSHistoryProgressServiceDummy() {
    }

    @Override // com.bytedance.android.livesdkapi.service.vs.IVSHistoryProgressService
    public Long getFirstShowTime(Object r100) {
        Intrinsics.checkNotNullParameter(r100, "any");
        return null;
    }

    @Override // com.bytedance.android.livesdkapi.service.vs.IVSHistoryProgressService
    public long getLocalPlayProgress(long r100) {
        return 0;
    }

    @Override // com.bytedance.android.livesdkapi.service.vs.IVSHistoryProgressService
    public Observable<Long> getServerPlayProgress(long r100) {
        return null;
    }

    @Override // com.bytedance.android.livesdkapi.service.vs.IVSHistoryProgressService
    public void leave(long r100, long r101) {
    }

    @Override // com.bytedance.android.livesdkapi.service.vs.IVSHistoryProgressService
    public void saveFirstShowProgressToLocal(long r100, long r101, boolean r102) {
    }

    @Override // com.bytedance.android.livesdkapi.service.vs.IVSHistoryProgressService
    public void saveProgressToLocal(long r100, long r101) {
    }

    @Override // com.bytedance.android.livesdkapi.service.vs.IVSHistoryProgressService
    public void saveProgressToServer(long r100, long r101) {
    }

    @Override // com.bytedance.android.livesdkapi.service.vs.IVSHistoryProgressService
    public Observable<Object> synPlayHistory(long r100, long r101, int r102) {
        return null;
    }
}
