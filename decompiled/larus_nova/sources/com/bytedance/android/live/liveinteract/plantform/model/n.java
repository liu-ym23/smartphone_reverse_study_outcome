package com.bytedance.android.live.liveinteract.plantform.model;

import com.bytedance.android.live.base.model.user.IBaseUser;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class n {
    public static final ILinkPlayerInfoBridge a(ILinkPlayerInfoBridge r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$copy");
        ILinkPlayerInfoBridge r101 = (ILinkPlayerInfoBridge) vh7.f.c(ILinkPlayerInfoBridge.class);
        r101.setFanTicket(r100.getFanTicket());
        r101.setFanTicketDisplayStr(r100.getFanTicketDisplayStr());
        String r102 = r100.getMInteractIdStr();
        String r103 = "";
        if (r102 != null) goto L5;
        r102 = "";
    L5:
        r101.setInteractId(r102);
        String r104 = r100.getMInteractIdStr();
        if (r104 == null) goto L9;
        r103 = r104;
    L9:
        r101.setLinkMicUniqueIdStr(r103);
        r101.setUser(r100.getUser());
        r101.setModifyTime(r100.getModifyTime());
        r101.setLinkStatus(r100.getLinkStatus());
        r101.setKSongUid(r100.getKSongUid());
        r101.setLinkType(r100.getLinkType());
        r101.setRoleType(r100.getRoleType());
        r101.setListUserRole(r100.getListUserRole());
        r101.setPaidMoney(r100.getPaidMoney());
        r101.setLinkDuration(r100.getLinkDuration());
        r101.setUserPosition(r100.getUserPosition());
        r101.setSilenceStatus(r100.getSilenceStatus());
        r101.setLocation(r100.getLocation());
        r101.setModifyTimeInNano(r100.getModifyTimeInNano());
        r101.setTalkState(r100.getTalkState());
        r101.setOpenSendGift(r100.isOpenSendGift());
        r101.setHasInvited(r100.isHasInvited());
        r101.setHasApplied(r100.isHasApplied());
        r101.setHost(r100.isHost());
        r101.setMediaType(r100.getMediaType());
        r101.setCornerMarkUrl(r100.getCornerMarkUrl());
        r101.setClientVersion(r100.getClientVersion());
        r101.setAppId(r100.getAppId());
        r101.setDevicePlatform(r100.getDevicePlatform());
        r101.setApplyType(r100.getApplyType());
        r101.setApplyTypeNew(r100.getApplyTypeNew());
        r101.setLinkedListUserInfo(r100.getLinkedListUserInfo());
        r101.setBackground(r100.isBackground());
        r101.setSelfBackground(r100.isSelfBackground());
        r101.setMatchEffect(r100.getMatchEffect());
        r101.setCityEffect(r100.getCityEffect());
        r101.setShowCityEffect(r100.getShowCityEffect());
        r101.setMIsJoinUser(r100.getMIsJoinUser());
        r101.setMicDress(r100.getMicDress());
        r101.setEnlarged(r100.isEnlarged());
        r101.setLinkmic2DAvatar(r100.getLinkmic2DAvatar());
        r101.setChorusGuestStatus(r100.getChorusGuestStatus());
        r101.setOriginLinkType(r100.getOriginLinkType());
        r101.setAiGuestType(r100.getAiGuestType());
        r101.setMicHidden(r100.isMicHidden());
        r101.setSelfDisciplineDuration(r100.getSelfDisciplineDuration());
        r101.setSelfDisciplineTargetDuration(r100.getSelfDisciplineTargetDuration());
        r101.setThemedCompetitionRole(r100.getThemedCompetitionRole());
        r101.setWaitingListUserInfo(r100.getWaitingListUserInfo());
        r101.setRank(r100.getRank());
        r101.setPaidCount(r100.getPaidCount());
        r101.setStats(r100.getStats());
        r101.setLinkRoomUser(r100.isLinkRoomUser());
        r101.setLinkRoomId(r100.getLinkRoomId());
        r101.setRoomLinkSilenceStatus(r100.getRoomLinkSilenceStatus());
        r101.setAnonymous(r100.isAnonymous());
        r101.setMicPosTagInfo(r100.getMicPosTagInfo());
        r101.setUserHighScoreSongTag(r100.getUserHighScoreSongTag());
        r101.setPaidUserLeave(r100.isPaidUserLeave());
        r101.setMcStatus(r100.getMcStatus());
        r101.setClientUIPosition(r100.getClientUIPosition());
        return r101;
    }

    public static final long b(ILinkPlayerInfoBridge r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$linkMicPosTagType");
        if (r100.getMicPosTagInfo() != null) goto L5;
        return 0;
    L5:
        g0 r101 = r100.getMicPosTagInfo();
        Intrinsics.checkNotNull(r101);
        return r101.getTagType();
    }

    public static final String c(ILinkPlayerInfoBridge r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$topR");
        if (r100.getRank() != 1) goto L6;
        return "top1";
    L6:
        if (r100.getRank() != 2) goto L9;
        return "top2";
    L9:
        if (r100.getRank() != 3) goto L11;
        return "top3";
    L11:
        return "null";
    }

    public static final IBaseUser d(ILinkPlayerInfoBridge r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$userKt");
        return r100.getUser();
    }

    public static final String e(String r100) {
        if (r100 != null) goto L4;
        return "";
    L4:
        if (r100.length() > 6) goto L9;
        return r100;
    L9:
        return r100.subSequence(0, 5).toString() + "...";
    }

    public static final boolean f(ILinkPlayerInfoBridge r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$hasSpecialRadioEffect");
        if (r100.getMicDress() == null) goto L7;
        kd1.b r101 = r100.getMicDress();
        Intrinsics.checkNotNull(r101);
        if (r101.getVoiceWave() == null) goto L7;
        return true;
    L7:
        return false;
    }

    public static final boolean g(ILinkPlayerInfoBridge r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$isKtvHost");
        if (r100.getMcStatus() != ILinkPlayerInfoBridge.McStatus.KTV_HOST.ordinal()) goto L5;
        return true;
    L5:
        return false;
    }

    public static final boolean h(ILinkPlayerInfoBridge r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$isTalking");
        if (r100.getTalkState() <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    public static final boolean i(ILinkPlayerInfoBridge r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$isUnSilence");
        if (r100.isLinkRoomUser() == false) goto L12;
        if (r100.getRoomLinkSilenceStatus() == 0) goto L7;
    L9:
        return false;
    L7:
        if (r100.getSilenceStatus() != 0) goto L9;
        return true;
    L12:
        if (r100.getSilenceStatus() == 0) goto L17;
        return false;
    L17:
        return true;
    }
}
