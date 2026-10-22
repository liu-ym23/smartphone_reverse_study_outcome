package com.bytedance.android.livesdkapi.feed.data;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.android.livesdkapi.depend.message.RoomLinkMicSyncData;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.feed.IKtvComponentFeedViewManager;
import com.bytedance.android.livesdkapi.feed.IPreviewPlayerContainerAbility;
import com.bytedance.android.livesdkapi.roomplayer.ILivePlayerClient;
import com.bytedance.android.livesdkapi.roomplayer.LivePlayerView;
import com.bytedance.android.livesdkapi.service.MessageHub;
import com.bytedance.ies.sdk.widgets.DataCenter;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\bf\u0018\u00002\u00020\u0001:\u0001-J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0007H&J\n\u0010\b\u001a\u0004\u0018\u00010\tH&J\n\u0010\n\u001a\u0004\u0018\u00010\tH&J\b\u0010\u000b\u001a\u00020\u0007H&J\n\u0010\f\u001a\u0004\u0018\u00010\rH&J\b\u0010\u000e\u001a\u00020\tH&J\n\u0010\u000f\u001a\u0004\u0018\u00010\u0010H&J\n\u0010\u0011\u001a\u0004\u0018\u00010\u0012H&J\b\u0010\u0013\u001a\u00020\u0014H&J\n\u0010\u0015\u001a\u0004\u0018\u00010\u0016H&J\n\u0010\u0017\u001a\u0004\u0018\u00010\u0018H&J\b\u0010\u0019\u001a\u00020\u001aH&J\b\u0010\u001b\u001a\u00020\u0007H&J\b\u0010\u001c\u001a\u00020\u001dH&J\b\u0010\u001e\u001a\u00020\u001fH&J\u0012\u0010 \u001a\u00020\u001f2\b\u0010!\u001a\u0004\u0018\u00010\"H\u0016J\u0010\u0010#\u001a\u00020\u001f2\u0006\u0010$\u001a\u00020\u0007H\u0016J\u0012\u0010%\u001a\u00020\u001f2\b\u0010&\u001a\u0004\u0018\u00010'H\u0016J*\u0010(\u001a\u00020\u001f2\u0006\u0010)\u001a\u00020\t2\u0006\u0010*\u001a\u00020\u00072\u0006\u0010+\u001a\u00020\t2\b\b\u0002\u0010,\u001a\u00020\u001dH&¨\u0006."}, d2 = {"Lcom/bytedance/android/livesdkapi/feed/data/IPreviewMultiLinkOuterConfigProvider;", "", "getContainerView", "Landroid/widget/FrameLayout;", "getContext", "Landroid/content/Context;", "getDesiredTopSpaceHeight", "", "getEnterFromMerge", "", "getEnterMethod", "getFeedLiveType", "getKtvComponentFeedViewManager", "Lcom/bytedance/android/livesdkapi/feed/IKtvComponentFeedViewManager;", "getLastAppData", "getLivePlayerClient", "Lcom/bytedance/android/livesdkapi/roomplayer/ILivePlayerClient;", "getLivePlayerView", "Lcom/bytedance/android/livesdkapi/roomplayer/LivePlayerView;", "getMessageHub", "Lcom/bytedance/android/livesdkapi/service/MessageHub;", "getPlayerContainerAbility", "Lcom/bytedance/android/livesdkapi/feed/IPreviewPlayerContainerAbility;", "getPreloadRoomLinkMicSyncData", "Lcom/bytedance/android/livesdkapi/depend/message/RoomLinkMicSyncData;", "getRoom", "Lcom/bytedance/android/livesdkapi/depend/model/live/IRoom;", "getShowFrom", "isLiveAlive", "", "notifyKtvComponentUpdateLocation", "", "onMultiLinkDynamicInitialComplete", "dataCenter", "Lcom/bytedance/ies/sdk/widgets/DataCenter;", "onMultiLinkFeedTypeChanged", "uiLayout", "onMultiLinkFeedViewCreate", KtvSubElement.CONTAINER, "Landroid/view/ViewGroup;", "printALogger", "subTag", "hashCode", "content", "needHighLight", "IMobLoggerProvider", "livesdkapi-middleware_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface IPreviewMultiLinkOuterConfigProvider {

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3})
    public static final class DefaultImpls {
        public static void onMultiLinkDynamicInitialComplete(IPreviewMultiLinkOuterConfigProvider r100, DataCenter r101) {
        }

        public static void onMultiLinkFeedTypeChanged(IPreviewMultiLinkOuterConfigProvider r100, int r101) {
        }

        public static void onMultiLinkFeedViewCreate(IPreviewMultiLinkOuterConfigProvider r100, ViewGroup r101) {
        }

        public static /* synthetic */ void printALogger$default(IPreviewMultiLinkOuterConfigProvider r100, String r101, int r102, String r103, boolean r104, int r105, Object r106) {
            if (r106 != null) goto L9;
            if ((r105 & 8) == 0) goto L6;
            r104 = false;
        L6:
            r100.printALogger(r101, r102, r103, r104);
            return;
        L9:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: printALogger");
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/livesdkapi/feed/data/IPreviewMultiLinkOuterConfigProvider$IMobLoggerProvider;", "", "logLiveDuration", "", "logLiveShow", "livesdkapi-middleware_saasRelease"}, k = 1, mv = {1, 4, 3})
    public interface IMobLoggerProvider {
        void logLiveDuration();

        void logLiveShow();
    }

    FrameLayout getContainerView();

    Context getContext();

    int getDesiredTopSpaceHeight();

    String getEnterFromMerge();

    String getEnterMethod();

    int getFeedLiveType();

    IKtvComponentFeedViewManager getKtvComponentFeedViewManager();

    String getLastAppData();

    ILivePlayerClient getLivePlayerClient();

    LivePlayerView getLivePlayerView();

    MessageHub getMessageHub();

    IPreviewPlayerContainerAbility getPlayerContainerAbility();

    RoomLinkMicSyncData getPreloadRoomLinkMicSyncData();

    IRoom getRoom();

    int getShowFrom();

    boolean isLiveAlive();

    void notifyKtvComponentUpdateLocation();

    void onMultiLinkDynamicInitialComplete(DataCenter r100);

    void onMultiLinkFeedTypeChanged(int r100);

    void onMultiLinkFeedViewCreate(ViewGroup r100);

    void printALogger(String r100, int r101, String r102, boolean r103);
}
