package com.bytedance.android.live.room;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.text.Spannable;
import android.view.MotionEvent;
import android.view.View;
import com.bytedance.android.live.base.model.ImageModel;
import com.bytedance.android.live.base.model.user.IUser;
import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget;
import com.bytedance.android.live.core.utils.j0;
import com.bytedance.android.live.network.response.Response;
import com.bytedance.android.live.utility.ServiceLookup;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import com.bytedance.android.livesdk.schema.interfaces.IBaseLiveActionHandler;
import com.bytedance.android.livesdk.schema.interfaces.ILiveActionHandler;
import com.bytedance.android.livesdkapi.depend.live.ILiveRecordService;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomService;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.message.Text;
import com.bytedance.android.livesdkapi.sti.IShortTermIndicatorManager;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.Widget;
import com.bytedance.livesdk.preview.merge.AbsMergeWidget;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.HashMap;

/* JADX INFO: loaded from: classes47.dex */
@ServiceLookup("com.bytedance.android.livesdk.module.RoomService")
public interface IRoomService extends IMiddlewareRoomService, ILiveRoomService {

    /* JADX INFO: renamed from: com.bytedance.android.live.room.IRoomService$-CC, reason: invalid class name */
    public final /* synthetic */ class CC {
        public static /* bridge */ /* synthetic */ IBaseLiveActionHandler $default$actionHandler(IRoomService r100) {
            return r100.actionHandler();
        }
    }

    @Override // com.bytedance.android.live.room.IMiddlewareRoomService
    /* bridge */ /* synthetic */ IBaseLiveActionHandler actionHandler();

    @Override // com.bytedance.android.live.room.IMiddlewareRoomService
    ILiveActionHandler actionHandler();

    com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.u getAnimatedButtonController();

    com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.u getAnimatedButtonController(long r100, long r101);

    Class<? extends AbsMergeWidget> getCardPlaceWidgetClass();

    AbsMergeWidget getCardPlaceWidgetInstance();

    a91.a getCrossRoomGift();

    Dialog getEnsureKickOutDialog(Context r100, long r101, String r102, String r103, String r104);

    @Override // com.bytedance.android.live.room.IMiddlewareRoomService
    j0 getFontManager();

    int getInteractionLayoutId();

    int getLiveCurType();

    com.bytedance.android.live.room.utils.a getLiveMultiTabHandler();

    String getLiveType(Room r100);

    Dialog getManageDialog(Context r100, Room r101, User r102, boolean r103, boolean r104, boolean r105, UserProfileEvent r106, Bundle r107, boolean r108);

    ILiveRecordService getRecordService();

    RoomContext getRoomDataContext(DataCenter r100);

    tlc.d getRoomPushMessage(long r100, ImageModel r101, String r102, int r103, String r104, String r105, String r106, String r107);

    IShortTermIndicatorManager getShortTermIndicatorManager(DataCenter r100);

    u getToolbarConfig();

    @Override // com.bytedance.android.live.room.IMiddlewareRoomService
    Class<? extends Widget> getToolbarWidgetClass();

    Class<? extends Widget> getTopRightBannerWidgetClass();

    LiveRecyclableWidget getUnionAnchorInfoWidget(boolean r100);

    HashMap<String, Class<? extends LiveRecyclableWidget>> getWidgetPool();

    void gotoLiveByProfile(Activity r100, DataCenter r101, String r102, String r103, long r104);

    Disposable inviteUserForGame(DataCenter r100, long r101);

    boolean isAudienceNewMorePanel(DataCenter r100);

    boolean isAudienceNewMorePanelLightTheme(DataCenter r100);

    @Override // com.bytedance.android.live.room.IMiddlewareRoomService
    boolean isClearRecord();

    @Override // com.bytedance.android.live.room.IMiddlewareRoomService
    boolean isClearScreenDisableGuide();

    @Override // com.bytedance.android.live.room.IMiddlewareRoomService
    boolean isNewFeedStyle(DataCenter r100);

    @Override // com.bytedance.android.live.room.IMiddlewareRoomService
    boolean isNewStyleForTTLite(DataCenter r100);

    @Override // com.bytedance.android.live.room.IMiddlewareRoomService
    boolean isOnNeedMuteAudioFullPage();

    @Override // com.bytedance.android.live.room.IMiddlewareRoomService
    boolean isOpenCropImagePage();

    @Override // com.bytedance.android.live.room.IMiddlewareRoomService
    boolean isOpenImagePickerForCustomEmoji();

    boolean isStopPlayingOnBg();

    boolean isVrCamera(DataCenter r100);

    @Override // com.bytedance.android.live.room.IMiddlewareRoomService
    boolean judgeTargetOnClearScreenForSingleView(int r100, int r101, View r102, MotionEvent r103);

    n messageManagerHelper();

    boolean needHideShare(IUser r100);

    PermissionGrantStatus obtainPermissionGrantStatus();

    void openDrawer(Activity r100, boolean r101, Bundle r102, DataCenter r103);

    Spannable parsePatternAndGetSpannable(Text r100, String r101);

    Spannable parsePatternAndGetSpannable(String r100, Text r101);

    void preOpenLynxDrawer(Activity r100, boolean r101, Bundle r102, DataCenter r103);

    void registerActions();

    void savePermissionGrantStatus(PermissionGrantStatus r100);

    void setBroadcastActivityDirectlyShow(boolean r100);

    a91.a setCrossRoomGift(a91.a r100);

    @Override // com.bytedance.android.live.room.IMiddlewareRoomService
    void setIsOpenCropImagePage(boolean r100);

    void setLiveCurType(int r100);

    void setLiveRoomDetail(DataCenter r100);

    @Override // com.bytedance.android.live.room.IMiddlewareRoomService
    boolean shouldFeedbackInterceptLeaveRoom(DataCenter r100, int r101);

    Disposable silenceAnonymousUser(long r100, boolean r101, Consumer<Response<Object>> r102, Consumer<Throwable> r103);

    @Override // com.bytedance.android.live.room.IMiddlewareRoomService
    void stopMultiLinkNotification();

    IToolbarManagerHelper toolbarManagerHelper();

    @Override // com.bytedance.android.live.room.IMiddlewareRoomService
    void updateMultiLinkNotificationStatus(boolean r100);

    @Override // com.bytedance.android.live.room.IMiddlewareRoomService
    void userInfoAutoAntiDeterioration();
}
