package com.bytedance.android.livesdkapi.depend.live;

import androidx.fragment.app.Fragment;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;

/* JADX INFO: loaded from: classes12.dex */
public interface IMiddlewareLiveRoomPlayFragment {
    IRoom getCurRoom();

    Fragment getFragment();

    boolean prePrepare(String r100);

    void prePullStream(boolean r100, String r101);

    void preRequestRoomPreload(boolean r100);
}
