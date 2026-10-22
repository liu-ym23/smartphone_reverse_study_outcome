package com.bytedance.android.livesdkapi.performance;

import com.bytedance.android.live.base.IService;
import com.bytedance.android.live.utility.ServiceLookup;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@ServiceLookup("com.bytedance.android.livesdk.performance.HotRoomCollectLogService")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J(\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\bH&J\u0018\u0010\f\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\bH&J0\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\bH&¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/livesdkapi/performance/IHotRoomLogCollectService;", "Lcom/bytedance/android/live/base/IService;", "collectPerformance", "", "performance", "Lcom/bytedance/android/livesdkapi/performance/Performance;", "enterRoom", "roomId", "", "roomName", "anchorId", "anchorName", "exitRoom", "exitReason", "sendComment", "content", "livesdkapi_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface IHotRoomLogCollectService extends IService {
    void collectPerformance(Performance r100);

    void enterRoom(String r100, String r101, String r102, String r103);

    void exitRoom(String r100, String r101);

    void sendComment(String r100, String r101, String r102, String r103, String r104);
}
