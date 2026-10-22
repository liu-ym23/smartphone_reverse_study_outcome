package com.bytedance.android.livesdkapi.roomplayer;

import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.episode.VSCameraInfo;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\bf\u0018\u00002\u00020\u0001J\"\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007H&J\"\u0010\t\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007H\u0016J\u001a\u0010\n\u001a\u00020\u00032\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\r\u001a\u00020\u000eH&¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/livesdkapi/roomplayer/IPaidLiveRefreshStreamListener;", "", "requestStream4BuyTicket", "", "room", "Lcom/bytedance/android/livesdkapi/depend/model/live/IRoom;", "cameraInfos", "", "Lcom/bytedance/android/livesdkapi/depend/model/live/episode/VSCameraInfo;", "requestStream4TempWatch", "requestStreamFail", "reason", "", "scene", "", "vs-model_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface IPaidLiveRefreshStreamListener {

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3})
    public static final class DefaultImpls {
        public static void requestStream4TempWatch(IPaidLiveRefreshStreamListener r100, IRoom r101, List<? extends VSCameraInfo> r102) {
        }
    }

    void requestStream4BuyTicket(IRoom r100, List<? extends VSCameraInfo> r101);

    void requestStream4TempWatch(IRoom r100, List<? extends VSCameraInfo> r101);

    void requestStreamFail(String r100, int r101);
}
