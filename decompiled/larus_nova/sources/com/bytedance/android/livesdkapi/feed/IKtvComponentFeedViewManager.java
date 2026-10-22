package com.bytedance.android.livesdkapi.feed;

import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.feed.data.IPreviewMultiLinkOuterConfigProvider;
import com.bytedance.android.livesdkapi.ktv.IKtvComponentFeedView;
import com.bytedance.android.livesdkapi.model.ParseSeiData;
import java.util.HashMap;
import kotlin.Metadata;
import ld0.a;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H&J\u0012\u0010\b\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H&J\u0010\u0010\u000b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\tH&J\b\u0010\f\u001a\u00020\u0006H&J\n\u0010\u000e\u001a\u0004\u0018\u00010\rH&J\u0010\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u000fH&J\u0010\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u0012H&J\u0010\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u0015H&J\n\u0010\u0018\u001a\u0004\u0018\u00010\u0001H&J(\u0010\u001b\u001a\"\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0019j\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u0001`\u001aH&J\b\u0010\u001c\u001a\u00020\u000fH&J\b\u0010\u001d\u001a\u00020\u0006H&J\b\u0010\u001f\u001a\u00020\u001eH&J\u0010\u0010!\u001a\u00020\u00062\u0006\u0010 \u001a\u00020\u001eH&¨\u0006\""}, d2 = {"Lcom/bytedance/android/livesdkapi/feed/IKtvComponentFeedViewManager;", "", "Lcom/bytedance/android/livesdkapi/feed/data/IPreviewMultiLinkOuterConfigProvider;", "configOuterProvider", "Lcom/bytedance/android/livesdkapi/feed/ILivePreviewMultiLinkCommonWidget;", "configInnerProvider", "", "init", "updateMultiLinkCommonWidget", "Lcom/bytedance/android/livesdkapi/depend/model/live/IRoom;", "room", "onBind", "unBind", "Lcom/bytedance/android/livesdkapi/ktv/IKtvComponentFeedView;", "getKtvComponentFeedPreview", "", "sei", "onSeiUpdateRaw", "Lld0/a;", "videoSei", "onKtvVideoStateChange", "Lcom/bytedance/android/livesdkapi/model/ParseSeiData;", "seiAppData", "updateSceneByVer", "getKtvSeiModelObject", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "getKtvEnterRoomExtraParam", "getCurrentSingUserIdString", "notifyComponentUpdateLp", "", "getKtvComponentLyricsViewShowStatus", "show", "updateKtvComponentLyricsViewShowStatus", "livesdkapi-middleware_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface IKtvComponentFeedViewManager {
    String getCurrentSingUserIdString();

    IKtvComponentFeedView getKtvComponentFeedPreview();

    boolean getKtvComponentLyricsViewShowStatus();

    HashMap<String, Object> getKtvEnterRoomExtraParam();

    Object getKtvSeiModelObject();

    void init(IPreviewMultiLinkOuterConfigProvider r100, ILivePreviewMultiLinkCommonWidget r101);

    void notifyComponentUpdateLp();

    void onBind(IRoom r100);

    void onKtvVideoStateChange(a r100);

    void onSeiUpdateRaw(String r100);

    void unBind();

    void updateKtvComponentLyricsViewShowStatus(boolean r100);

    void updateMultiLinkCommonWidget(ILivePreviewMultiLinkCommonWidget r100);

    void updateSceneByVer(ParseSeiData r100);
}
