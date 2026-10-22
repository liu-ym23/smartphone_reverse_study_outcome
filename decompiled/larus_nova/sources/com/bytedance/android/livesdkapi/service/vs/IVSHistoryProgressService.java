package com.bytedance.android.livesdkapi.service.vs;

import com.bytedance.android.live.base.IService;
import com.bytedance.android.live.utility.ServiceLookup;
import com.bytedance.sdk.account.platform.base.OnekeyLoginConstants;
import io.reactivex.Observable;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@ServiceLookup("com.bytedance.android.livesdk.chatroom.vs.cache.VSHistoryProgressServiceImp")
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\bg\u0018\u00002\u00020\u0001J\u0017\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¢\u0006\u0002\u0010\u0006J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0003H&J\u001a\u0010\t\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\n2\u0006\u0010\b\u001a\u00020\u0003H&J\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\b\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u0003H&J \u0010\u000e\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u0012H&J\u0018\u0010\u0013\u001a\u00020\f2\u0006\u0010\b\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u0003H&J\u0018\u0010\u0014\u001a\u00020\f2\u0006\u0010\b\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u0003H&J(\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\n2\u0006\u0010\u0016\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u0018H&¨\u0006\u0019"}, d2 = {"Lcom/bytedance/android/livesdkapi/service/vs/IVSHistoryProgressService;", "Lcom/bytedance/android/live/base/IService;", "getFirstShowTime", "", "any", "", "(Ljava/lang/Object;)Ljava/lang/Long;", "getLocalPlayProgress", "episodeId", "getServerPlayProgress", "Lio/reactivex/Observable;", "leave", "", "leaveLocation", "saveFirstShowProgressToLocal", "roomId", "duration", "hasClickLatest", "", "saveProgressToLocal", "saveProgressToServer", "synPlayHistory", "seasonId", OnekeyLoginConstants.CU_KEY_SEQ, "", "livesdkapi-middleware_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface IVSHistoryProgressService extends IService {
    Long getFirstShowTime(Object r100);

    long getLocalPlayProgress(long r100);

    Observable<Long> getServerPlayProgress(long r100);

    void leave(long r100, long r101);

    void saveFirstShowProgressToLocal(long r100, long r101, boolean r102);

    void saveProgressToLocal(long r100, long r101);

    void saveProgressToServer(long r100, long r101);

    Observable<Object> synPlayHistory(long r100, long r101, int r102);
}
