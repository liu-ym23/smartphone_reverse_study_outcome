package com.bytedance.android.livesdkapi.feed;

import kotlin.Metadata;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J\n\u0010\u0002\u001a\u0004\u0018\u00010\u0003H&J(\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0007H&J\u0018\u0010\r\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0007H&J\u0010\u0010\u000e\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u000bH&J\u0010\u0010\u000f\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u000bH&J\u0010\u0010\u0010\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u000bH&¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/livesdkapi/feed/ILiveFeedParamService;", "", "getFirstRecommendFeedParams", "Lorg/json/JSONObject;", "recordLiveShowAction", "", "scene", "", "isPause", "", "roomId", "", "anchorId", "recordRoomEnter", "recordRoomExit", "recordRoomPause", "recordRoomResume", "livebase-model_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface ILiveFeedParamService {
    JSONObject getFirstRecommendFeedParams();

    void recordLiveShowAction(String r100, boolean r101, long r102, String r103);

    void recordRoomEnter(long r100, String r101);

    void recordRoomExit(long r100);

    void recordRoomPause(long r100);

    void recordRoomResume(long r100);
}
