package com.bytedance.android.livesdk.microom;

import com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget;
import com.bytedance.android.live.room.IMicRoomService;
import com.bytedance.android.live.room.IMiddlewareMicRoomService;
import com.bytedance.android.live.room.IRoomService;
import com.bytedance.android.live.room.api.INavigationService;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.config.f90;
import com.bytedance.android.livesdk.config.mu0;
import com.bytedance.android.livesdk.microom.enhance.MicRoomCenterCountDownWidget;
import com.bytedance.android.livesdk.microom.enhance.NormalRoomMicListWidget;
import com.bytedance.android.livesdk.utils.ntp.e;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import hd0.c;
import jc1.k;

/* JADX INFO: loaded from: classes11.dex */
public class MicRoomService implements IMicRoomService {
    private boolean anchorDisable;
    private int anchorStatus;
    private boolean isLoyalAudience;
    private boolean isPseudoLiving;
    private String micRoomJumpType;

    @Override // com.bytedance.android.live.room.IMicRoomService
    public boolean disableReEnterRoomForLinkGuest() {
        if (f90.f120183a.getValue().booleanValue() == true) goto L6;
        return false;
    L6:
        if (RoomContext.getShared() == null) goto L17;
        if (RoomContext.getShared().isAnchor().getValue().booleanValue() == false) goto L10;
    L15:
        return false;
    L10:
        if (RoomContext.getShared().getRoom().getValue() == null) goto L17;
        if (RoomContext.getShared().getRoom().getValue().officialChannelInfo == null) goto L17;
        if (RoomContext.getShared().getRoom().getValue().officialChannelInfo.getHasHostPermission() == true) goto L15;
    L17:
        return c.f().h();
    }

    @Override // com.bytedance.android.live.room.IMicRoomService
    public String getChangeTypeForLog() {
        Room r100 = ((IRoomService) k.f(IRoomService.class)).getCurrentRoom();
        if (r100 != null) goto L6;
        return "";
    L6:
        if (isMicRoom(r100) == true) goto L11;
        if (IMicRoomService.NON_CAROUSEL_TO_CAROUSEL_AUTO.equals(this.micRoomJumpType) == true) goto L11;
        return "";
    L11:
        if (isMicRoom(r100) == false) goto L19;
        if (IMicRoomService.CAROUSEL_ANCHOR_CHANGE_AUTO.equals(this.micRoomJumpType) == true) goto L19;
        if (IMicRoomService.CAROUSEL_TO_NON_CAROUSEL_AUTO.equals(this.micRoomJumpType) == true) goto L19;
        return IMicRoomService.LEAVE_CAROUSEL_ROOM;
    L19:
        return this.micRoomJumpType;
    }

    @Override // com.bytedance.android.live.room.IMicRoomService
    public Class<? extends LiveRecyclableWidget> getMicRoomOfficialInfoWidget() {
        if (mu0.f120784a.getValue().booleanValue() == false) goto L7;
        return MicRoomChannelInfoWidget.class;
    L7:
        if (RoomContext.getShared() != null) goto L9;
        return MicRoomChannelInfoWidget.class;
    L9:
        if (RoomContext.getShared().getTemplateContext() != null) goto L11;
        return MicRoomChannelInfoWidget.class;
    L11:
        if (RoomContext.getShared().getTemplateContext().getValue() != null) goto L13;
        return MicRoomChannelInfoWidget.class;
    L13:
        if (RoomContext.getShared().getTemplateContext().getValue().j("anchor_avatar") == true) goto L15;
        return MicRoomChannelInfoWidget.class;
    L15:
        return ((INavigationService) k.f(INavigationService.class)).getNewLiveRoomUserInfoWidgetClass();
    }

    @Override // com.bytedance.android.live.room.IMiddlewareMicRoomService
    public boolean isLoyalAudience() {
        if (this.isPseudoLiving == false) goto L6;
        this.isLoyalAudience = false;
        return false;
    L6:
        boolean r100 = this.isLoyalAudience;
        if (r100 == false) goto L10;
        return true;
    L10:
        return r100;
    }

    public MicRoomService() {
        this.anchorDisable = false;
        this.isPseudoLiving = false;
        this.isLoyalAudience = false;
        this.anchorStatus = 0;
        this.micRoomJumpType = "";
        k.l(IMicRoomService.class, this);
        k.l(IMiddlewareMicRoomService.class, this);
    }

    @Override // com.bytedance.android.live.room.IMicRoomService
    public Class<? extends LiveRecyclableWidget> getMicRoomAnchorGrabMicWidget() {
        return MicRoomAnchorGrabMicWidget.class;
    }

    @Override // com.bytedance.android.live.room.IMicRoomService
    public Class<? extends LiveRecyclableWidget> getMicRoomAnchorTimeControlWidget() {
        return MicRoomAnchorTimeControlWidget.class;
    }

    @Override // com.bytedance.android.live.room.IMicRoomService
    public Class<? extends LiveRecyclableWidget> getMicRoomAnchorWidget() {
        return MicRoomAnchorInfoWidget.class;
    }

    @Override // com.bytedance.android.live.room.IMicRoomService
    public Class<? extends LiveRecyclableWidget> getMicRoomAudienceControlWidget() {
        return MicRoomAudienceTimeControlWidget.class;
    }

    @Override // com.bytedance.android.live.room.IMicRoomService
    public Class<? extends LiveRecyclableWidget> getMicRoomBackUpRoomWidget() {
        return MicRoomBackupRoomWidget.class;
    }

    @Override // com.bytedance.android.live.room.IMicRoomService
    public Class<? extends LiveRecyclableWidget> getMicRoomCenterCountDownWidget() {
        return MicRoomCenterCountDownWidget.class;
    }

    @Override // com.bytedance.android.live.room.IMicRoomService
    public Class<? extends LiveRecyclableWidget> getMicRoomCountDownWidget() {
        return MicRoomCountDownWidget.class;
    }

    @Override // com.bytedance.android.live.room.IMicRoomService
    public Class<? extends LiveRecyclableWidget> getMicRoomEnterOfficialWidget() {
        return MicRoomEnterOfficialWidget.class;
    }

    @Override // com.bytedance.android.live.room.IMicRoomService
    public String getMicRoomJumpType() {
        return this.micRoomJumpType;
    }

    @Override // com.bytedance.android.live.room.IMicRoomService
    public Class<? extends LiveRecyclableWidget> getNormalRoomMicListWidget() {
        return NormalRoomMicListWidget.class;
    }

    @Override // com.bytedance.android.live.room.IMicRoomService
    public Class<? extends LiveRecyclableWidget> getNormalRoomShowListWidget() {
        return NormalRoomShowListWidget.class;
    }

    @Override // com.bytedance.android.live.room.IMicRoomService
    public boolean isPseudoLiving() {
        return this.isPseudoLiving;
    }

    @Override // com.bytedance.android.live.room.IMiddlewareMicRoomService
    public boolean isMicRoom(IRoom r100) {
        Room r101 = (Room) r100;
        if (r101 == null) goto L9;
        if (r101.hasMicRoomField() == false) goto L9;
        if (r101.officialChannelInfo == null) goto L9;
    L10:
        return true;
    L9:
        if (this.anchorStatus == 2) goto L10;
        return false;
    }

    @Override // com.bytedance.android.live.room.IMicRoomService
    public void setAnchorDisable(boolean r100) {
        this.anchorDisable = r100;
    }

    @Override // com.bytedance.android.live.room.IMicRoomService
    public void setAnchorMicRoomStatus(int r100) {
        this.anchorStatus = r100;
    }

    @Override // com.bytedance.android.live.room.IMiddlewareMicRoomService
    public void setLoyalAudience(boolean r100) {
        this.isLoyalAudience = r100;
    }

    @Override // com.bytedance.android.live.room.IMicRoomService
    public void setMicRoomJumpType(String r100) {
        this.micRoomJumpType = r100;
    }

    @Override // com.bytedance.android.live.room.IMicRoomService
    public void setPseudoLiving(boolean r100) {
        this.isPseudoLiving = r100;
    }

    @Override // com.bytedance.android.live.room.IMicRoomService
    public boolean willNext(IRoom r100) {
        if (this.anchorDisable == false) goto L5;
        return true;
    L5:
        Room r101 = (Room) r100;
        if (r101.officialChannelInfo != null) goto L8;
        return false;
    L8:
        long r102 = e.a() / 1000;
        if ((r101.officialChannelInfo.getEndTimeStamp() - r102) <= r101.officialChannelInfo.getForbiddenBeforeEnd()) goto L13;
        return false;
    L13:
        return true;
    }
}
