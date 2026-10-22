package com.bytedance.android.live.feature.api;

import android.os.Bundle;
import com.bytedance.android.live.base.IService;
import com.bytedance.android.live.utility.ServiceLookup;
import com.bytedance.android.livesdk.log.g;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.ss.ttvideoengine.TextureRenderStrategyInterface;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import org.json.JSONObject;
import z90.a;
import z90.b;
import z90.c;

/* JADX INFO: loaded from: classes45.dex */
@ServiceLookup("com.bytedance.android.live.impl.FeatureService")
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u000f\bg\u0018\u00002\u00020\u0001J\u001e\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H&J\b\u0010\n\u001a\u00020\tH&J\u0010\u0010\r\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u000bH&J\u0010\u0010\u000e\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u000bH&J\b\u0010\u0010\u001a\u00020\u000fH&J\n\u0010\u0012\u001a\u0004\u0018\u00010\u0011H&J\u0012\u0010\u0015\u001a\u00020\u00072\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H&J\u0012\u0010\u0016\u001a\u00020\u00072\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H&J\u001e\u0010\u001c\u001a\u00020\u001b2\b\b\u0002\u0010\u0018\u001a\u00020\u00172\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0019H&J\b\u0010\u001d\u001a\u00020\u001bH&J\u0010\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u001eH&J\u001a\u0010$\u001a\u00020\u00072\b\u0010!\u001a\u0004\u0018\u00010 2\u0006\u0010#\u001a\u00020\"H&J\u001a\u0010%\u001a\u00020\u00072\b\u0010!\u001a\u0004\u0018\u00010 2\u0006\u0010#\u001a\u00020\"H&J\u001a\u0010&\u001a\u00020\u00072\b\u0010!\u001a\u0004\u0018\u00010 2\u0006\u0010#\u001a\u00020\"H&J\u001a\u0010'\u001a\u00020\u00072\b\u0010!\u001a\u0004\u0018\u00010 2\u0006\u0010#\u001a\u00020\"H&J\u0012\u0010(\u001a\u00020\u00072\b\u0010!\u001a\u0004\u0018\u00010 H&J\b\u0010)\u001a\u00020\u0007H&J\b\u0010*\u001a\u00020\u0002H&J\u0012\u0010+\u001a\u00020\u00072\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H&J\u0018\u0010-\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010,\u001a\u00020\u0017H&J\"\u00100\u001a\u00020\u00072\u0006\u0010#\u001a\u00020\u001b2\u0006\u0010.\u001a\u00020\u001b2\b\u0010/\u001a\u0004\u0018\u00010\u0019H&¨\u00061"}, d2 = {"Lcom/bytedance/android/live/feature/api/IFeatureService;", "Lcom/bytedance/android/live/base/IService;", "", TextureRenderStrategyInterface.KEY_TRERENDERCONFIG_ASYNCINIT, "Lkotlin/Function0;", "Lcom/bytedance/android/livesdk/log/g;", "liveLoggerSupplier", "", "init", "Lz90/a;", "getFeatureManager", "", "listener", "setFeatureImListener", "setByteLinkListener", "Lz90/b;", "getFeedFeatureManager", "Lz90/c;", "getLivePortraitCenterService", "Lcom/bytedance/android/livesdkapi/depend/model/live/IRoom;", "room", "handleRoom", "unifyHandleRoom", "", "type", "Lorg/json/JSONObject;", "extraParams", "", "getRealtimeSequenceJson", "getSkipSequenceJson", "Ljava/lang/ref/WeakReference;", "getWeakRoom", "Landroid/os/Bundle;", "bundle", "", "roomId", "onLivePlayActivityCreate", "onLivePlayActivityDestroy", "onDetailModelStartRoom", "onDetailModelStopRoom", "onLiveRoomFragmentCreate", "onLiveRoomFragmentDestroy", "featureServiceHaveInit", "onPreviewVHShow", "roomIndex", "saveUnreadRoomFeature", "enterFromMerge", "featuresInfo", "addShuffleSequenceFeature", "livefeature-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface IFeatureService extends IService {
    void addShuffleSequenceFeature(String r100, String r101, JSONObject r102);

    boolean featureServiceHaveInit();

    a getFeatureManager();

    b getFeedFeatureManager();

    c getLivePortraitCenterService();

    String getRealtimeSequenceJson(int r100, JSONObject r101);

    String getSkipSequenceJson();

    WeakReference<IRoom> getWeakRoom();

    void handleRoom(IRoom r100);

    void init(boolean r100, Function0<? extends g> r101);

    void onDetailModelStartRoom(Bundle r100, long r101);

    void onDetailModelStopRoom(Bundle r100, long r101);

    void onLivePlayActivityCreate(Bundle r100, long r101);

    void onLivePlayActivityDestroy(Bundle r100, long r101);

    void onLiveRoomFragmentCreate(Bundle r100);

    void onLiveRoomFragmentDestroy();

    void onPreviewVHShow(IRoom r100);

    void saveUnreadRoomFeature(IRoom r100, int r101);

    void setByteLinkListener(Object r100);

    void setFeatureImListener(Object r100);

    void unifyHandleRoom(IRoom r100);
}
