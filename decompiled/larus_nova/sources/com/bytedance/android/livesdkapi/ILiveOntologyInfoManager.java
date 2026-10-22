package com.bytedance.android.livesdkapi;

import android.os.Bundle;
import androidx.fragment.app.FragmentActivity;
import ng2.c;

/* JADX INFO: loaded from: classes12.dex */
public interface ILiveOntologyInfoManager {
    public static final int DEFAULT_ACTIVITY_TAG = -1;

    void clear(FragmentActivity r100);

    void enableMakeSureLiveDrawerUrlNotNULL();

    Integer getBackRoomInfo(long r100);

    int getCreatedTimes();

    int getDrawerJumpFromTabType();

    String getDrawerUrl();

    String getEnterFromMerge();

    String getEnterMethod();

    long getFirstRoomId();

    int getInnerFlowTrackDelaySeconds();

    String getInnerUrl();

    c getLiveDrawerUrl();

    String getReqFrom();

    String getTitle();

    String getVSDrawerUrl();

    String getVSInnerUrl();

    boolean isAuthRewardRoom();

    boolean isEmbeddedLiveRoom();

    boolean isEnableMultiTab();

    boolean isEnableReplaceRecommend();

    boolean isFirstRoom(long r100);

    boolean isFromMatchRoom();

    boolean isInnerFlowAdRoom(long r100);

    boolean isLiveRoomCanPreview();

    void recordBackRoomInfo(long r100, int r101);

    boolean shouldHandleCommerceJob(long r100, Bundle r101);
}
