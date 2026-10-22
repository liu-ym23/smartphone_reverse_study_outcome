package com.bytedance.android.livesdkapi.depend.live;

import android.content.Context;
import android.os.Bundle;
import com.bytedance.android.live.base.IService;
import com.bytedance.android.live.network.response.Response;
import com.bytedance.android.live.utility.ServiceLookup;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import io.reactivex.Observable;
import io.reactivex.subjects.PublishSubject;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes12.dex */
@ServiceLookup("com.bytedance.android.livesdk.module.RoomService")
public interface ILiveRoomService extends IService {

    /* JADX INFO: renamed from: com.bytedance.android.livesdkapi.depend.live.ILiveRoomService$-CC, reason: invalid class name */
    public final /* synthetic */ class CC {
        public static void $default$liveLog(ILiveRoomService r100, String r101, Map r102, boolean r103) {
        }

        public static Long $default$getCurrentCameraIdFromRoomContext(ILiveRoomService r100) {
            return 0L;
        }
    }

    void checkAndFinishBroadcastActivityBefore();

    void createAudioRoomForTest(HashMap<String, String> r100, IRoomCreatedListener r101);

    boolean getBroadcastActivityDirectlyShow();

    Long getCurrentCameraIdFromRoomContext();

    Room getCurrentRoom();

    Room getCurrentRoomFromRoomContext();

    String getIfClearModeValueWithClick();

    String getIfClearModeValueWithIconShow();

    String getIfClearModeValueWithIntroCardShow();

    List<Long> getLivingRoomIds() throws Exception;

    Room getPreviewRoomFromRoomContext(Long r100, String r101, String r102);

    Context getRoomContext();

    Room getRoomDataByUniqueKey(String r100);

    Room getStreamerRoom();

    boolean inLivingRoom();

    HashMap<String, String> initLiveParams();

    void interceptLinkRequest(String r100);

    boolean isDrawerEnable(Room r100);

    boolean isInGroupLiveChorus();

    boolean isInGroupLiveGameRoom();

    boolean isInteracting();

    boolean isStreaming();

    void liveLog(String r100, Map<String, String> r101, boolean r102);

    PublishSubject<Boolean> onFollowStatusChange();

    void onRoomFragmentCreate(Context r100);

    void onRoomFragmentDestroy();

    Observable<Response<Object>> preEnter(long r100, long r101, int r102, long r103, HashMap<String, String> r104);

    boolean preEnterRoom(long r100, Bundle r101);

    void prepareLiveFeedCache(long r100, Bundle r101);

    void recordEnterStart(EntryType r100);

    void registerInteractStateChangeListener(IInteractStateChangeListener r100);

    void removeInteractStateChangeListener(IInteractStateChangeListener r100);

    void sendLiveLogger(String r100, HashMap<String, String> r101);

    void setCurrentRoom(Room r100);

    void setStreamerRoom(Room r100);

    void switchOrientation(int r100, String r101);
}
