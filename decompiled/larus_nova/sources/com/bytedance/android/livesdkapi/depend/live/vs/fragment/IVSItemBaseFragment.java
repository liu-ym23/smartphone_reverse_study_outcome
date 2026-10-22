package com.bytedance.android.livesdkapi.depend.live.vs.fragment;

import android.content.res.Configuration;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import com.bytedance.android.livesdkapi.depend.live.LiveRoomState;
import io.reactivex.subjects.PublishSubject;

/* JADX INFO: loaded from: classes12.dex */
public interface IVSItemBaseFragment {
    LiveRoomState getCurState();

    Fragment getFragment();

    int getStartOrientation();

    void initLogger(Bundle r100);

    boolean onBackPressed();

    void onPageScrollStateChanged(int r100);

    void onSelectedConfigurationChanged(Configuration r100);

    void onUserLeaveHint();

    void setRefreshStatusObservable(PublishSubject<Boolean> r100);

    void setScrollStatusObservable(PublishSubject<Boolean> r100);

    void setStartOrientation(int r100);

    void setUserVisibleHint(boolean r100);

    void startPlay();

    void stopPlay();

    void updateCurrentController();

    void updateEnterMonitor();

    void updateStartTimeForLog(long r100);
}
