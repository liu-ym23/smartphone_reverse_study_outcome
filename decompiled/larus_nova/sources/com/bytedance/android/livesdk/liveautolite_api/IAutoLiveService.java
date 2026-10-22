package com.bytedance.android.livesdk.liveautolite_api;

import android.view.ViewStub;
import com.bytedance.android.live.base.IService;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0;
import com.bytedance.ies.sdk.widgets.Widget;

/* JADX INFO: loaded from: classes10.dex */
public interface IAutoLiveService extends IService {

    public interface IRoomService {
        c0.b getAutoToolbarBehavior(ViewStub r100);
    }

    public interface IStartService {
        String getAutoParams();

        Widget getLiveStartWidget();

        void inflateStartView(ViewStub r100);
    }

    IRoomService getRoomService();

    IStartService getStartService();
}
