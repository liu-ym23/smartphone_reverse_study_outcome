package com.bytedance.android.livehostapi.foundation.flavor.hotsoon;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.live.base.IService;
import com.bytedance.android.livehostapi.foundation.base.IBaseHostApp;
import com.bytedance.android.livehostapi.foundation.depend.IHostAppMonitorListener;
import com.bytedance.android.livehostapi.foundation.depend.OnBindPhoneListener;
import java.io.File;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes7.dex */
public interface IHostAppForHS extends IService, IBaseHostApp {
    void centerToast(Context r100, String r101, int r102);

    void checkAndShowGuide(FragmentActivity r100, String r101, String r102);

    void checkBindHelpShow(FragmentActivity r100, String r101);

    void enterRecorderActivity(Activity r100);

    List<Class> getAllLiveActivity();

    String getAudioAccessibilityServiceName();

    String getBgBroadcastServiceName();

    Activity getCurrentActivity();

    Class getHostActivity(int r100);

    String getSessionId();

    Activity getTopActivity();

    Uri getUriForFile(Context r100, File r101);

    void openWallet(Activity r100);

    void registerLiveLifeCycleListener(IHostAppMonitorListener r100);

    boolean shouldUseScopedStorage();

    void startBindMobileFullFragment(Activity r100, String r101, String r102, OnBindPhoneListener r103);

    void startBindPhoneDialogFragment(Activity r100, String r101, String r102, OnBindPhoneListener r103);

    boolean startVideoRecordActivity(Activity r100, String r101);

    void systemToast(Context r100, String r101, int r102);

    void transCloudControlCommand(JSONObject r100);
}
