package com.bytedance.android.livesdk.interactivity.api.publicscreen.highlight;

import com.bytedance.android.livesdk.chatroom.MiddlewareRoomContext;
import com.bytedance.ies.sdk.widgets.DataCenter;

/* JADX INFO: loaded from: classes9.dex */
public interface k {
    void bindContainer(j r100);

    void dismiss(AbsPSHighlightComp r100);

    /* JADX INFO: renamed from: getContainer */
    j mo8241getContainer();

    DataCenter getDataCenter();

    boolean getHasComponentShow();

    /* JADX INFO: renamed from: getLaunchManager */
    h mo8242getLaunchManager();

    MiddlewareRoomContext getRoomContext();

    m.c getTriggerMapper();

    void release();

    void setHasComponentShow(boolean r100);

    void show(AbsPSHighlightComp r100);

    l stateCenter();
}
