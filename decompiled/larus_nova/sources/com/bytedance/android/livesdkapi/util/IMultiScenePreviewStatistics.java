package com.bytedance.android.livesdkapi.util;

import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\r\bf\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001dJ6\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH&J\b\u0010\r\u001a\u00020\u0003H&JF\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u00072\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\n2\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0007H&J\b\u0010\u0014\u001a\u00020\u0003H&J \u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u00112\u0006\u0010\u0017\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\u0007H&J \u0010\u0019\u001a\u00020\u00032\u0006\u0010\u001a\u001a\u00020\n2\u0006\u0010\u001b\u001a\u00020\n2\u0006\u0010\u001c\u001a\u00020\nH&¨\u0006\u001e"}, d2 = {"Lcom/bytedance/android/livesdkapi/util/IMultiScenePreviewStatistics;", "Lcom/bytedance/android/livesdkapi/util/IMultiSceneCommonStatistics;", "init", "", "room", "Lcom/bytedance/android/livesdkapi/depend/model/live/IRoom;", "enterFromMerge", "", "enterMethod", "feedType", "", "bindTs", "", "onViewHolderUnSelected", "recordAudiencePreviewStayDuration", "viewName", "isClickEnterRoom", "", "seiVersion", "subScene", "startObserveLoadEnd", "updateIsPreload", "isPreload", "from", "loadFrom", "updateTalkRoomCommonParams", "seiVer", "scene", "uiLayout", "Companion", "livesdkapi-middleware_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface IMultiScenePreviewStatistics extends IMultiSceneCommonStatistics {
    public static final String BUSINESS_API_NAME = "business_api_name";
    public static final Companion Companion = null;
    public static final String MULTI_SCENE_PREVIEW = "multi_scene_preview";
    public static final String SERVICE_CHAT_ROOM_BUSINESS_LOGIC_SAMPLING = "ttlive_chat_room_business_logic_sampling";
    public static final String TALK_ROOM_FEED_VIEW_UI_FIRST_FRAME = "talk_room_feed_view_ui_first_frame";

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/bytedance/android/livesdkapi/util/IMultiScenePreviewStatistics$Companion;", "", "()V", "BUSINESS_API_NAME", "", "MULTI_SCENE_PREVIEW", "SERVICE_CHAT_ROOM_BUSINESS_LOGIC_SAMPLING", "TALK_ROOM_FEED_VIEW_UI_FIRST_FRAME", "livesdkapi-middleware_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = null;
        public static final String BUSINESS_API_NAME = "business_api_name";
        public static final String MULTI_SCENE_PREVIEW = "multi_scene_preview";
        public static final String SERVICE_CHAT_ROOM_BUSINESS_LOGIC_SAMPLING = "ttlive_chat_room_business_logic_sampling";
        public static final String TALK_ROOM_FEED_VIEW_UI_FIRST_FRAME = "talk_room_feed_view_ui_first_frame";

        private Companion() {
        }

        static {
            $$INSTANCE = new Companion();
        }
    }

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3})
    public static final class DefaultImpls {
        public static long checkDurationValid(IMultiScenePreviewStatistics r100, long r101) {
            return IMultiSceneCommonStatistics.DefaultImpls.checkDurationValid(r100, r101);
        }
    }

    static {
        Companion = Companion.$$INSTANCE;
    }

    void init(IRoom r100, String r101, String r102, int r103, long r104);

    void onViewHolderUnSelected();

    void recordAudiencePreviewStayDuration(String r100, IRoom r101, boolean r102, int r103, int r104, String r105, String r106);

    void startObserveLoadEnd();

    void updateIsPreload(boolean r100, String r101, String r102);

    void updateTalkRoomCommonParams(int r100, int r101, int r102);
}
