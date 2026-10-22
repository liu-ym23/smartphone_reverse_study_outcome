package com.bytedance.android.livehostapi.platform.flavor.hotsoon;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import androidx.fragment.app.FragmentManager;
import com.bytedance.android.live.base.IService;
import com.bytedance.android.livehostapi.platform.base.IBaseHostAction;
import java.util.Map;

/* JADX INFO: loaded from: classes7.dex */
public interface IHostActionForHS extends IService, IBaseHostAction {
    int concatVideo(String[] r100, String r101);

    boolean getMuteStatus();

    void handleFeedKickOut(long r100);

    boolean handleSchema(Context r100, String r101, Bundle r102);

    void initLynxEnv();

    boolean openExternalUrl(Context r100, String r101, Uri r102);

    void openFeedBack(String r100, Context r101);

    void openLiveBrowser(String r100, Bundle r101, Context r102);

    void openLiveLynx(String r100, Bundle r101, Context r102);

    void openUserProfilePage(long r100, Map<String, String> r101);

    void showLocationPermissionDialog(Activity r100, FragmentManager r101);

    void startLive(Context r100, long r101, Bundle r102);

    void switchToLiveTab(int r100, String r101);
}
