package com.bytedance.android.livesdk.chatroom.end;

import android.os.Bundle;
import android.view.View;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.ies.sdk.widgets.DataCenter;

/* JADX INFO: loaded from: classes7.dex */
public interface b {
    void T30(int r100);

    View W5();

    void a9();

    boolean ca();

    Room getCurRoom();

    View getView();

    void onHideFragment();

    void onShowFragment();

    void setDataCenter(DataCenter r100);

    void setUserVisibleHint(boolean r100);

    void sw(Room r100, aj1.f r101, String r102, Bundle r103);

    void z3(boolean r100);
}
