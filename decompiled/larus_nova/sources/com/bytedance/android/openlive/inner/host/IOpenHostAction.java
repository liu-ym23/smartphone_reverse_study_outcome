package com.bytedance.android.openlive.inner.host;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import com.bytedance.android.live.base.IService;
import com.bytedance.android.livehostapi.foundation.depend.IHostAppMonitorListener;
import com.bytedance.android.livehostapi.platform.depend.IPopTuringVerifyCallback;
import com.bytedance.android.livehostapi.platform.depend.user.ISimpleLoginCallback;
import com.bytedance.android.livehostapi.platform.depend.user.UserChangedCallback;
import java.util.Map;

/* JADX INFO: loaded from: classes12.dex */
public interface IOpenHostAction extends IService {

    /* JADX INFO: renamed from: com.bytedance.android.openlive.inner.host.IOpenHostAction$-CC, reason: invalid class name */
    public final /* synthetic */ class CC {
        public static boolean $default$isLogin(IOpenHostAction r100) {
            return false;
        }

        public static void $default$openUserProfilePage(IOpenHostAction r100, String r101, Map r102) {
        }

        public static void $default$popTuringVerifyViewForJSB(IOpenHostAction r100, Context r101, String r102, IPopTuringVerifyCallback r103) {
        }
    }

    boolean handleSchema(Context r100, String r101, Bundle r102);

    void hostUserLogin(Activity r100, ISimpleLoginCallback r101);

    void initXBridge();

    boolean isLogin();

    void logEvent(boolean r100, String r101, String r102, Map<String, String> r103);

    void openLiveBrowser(String r100, Bundle r101, Context r102);

    void openLiveLynx(String r100, Bundle r101, Context r102);

    void openUserProfilePage(String r100, Map<String, String> r101);

    void popTuringVerifyViewForJSB(Context r100, String r101, IPopTuringVerifyCallback r102);

    void registerCurrentUserUpdateListener(UserChangedCallback r100);

    void registerLiveLifeCycleListener(IHostAppMonitorListener r100);

    void startBroadcast(Context r100, Bundle r101);

    void startFeed(Context r100, String r101);

    void startLive(Context r100, long r101, Bundle r102);

    void unRegisterCurrentUserUpdateListener(UserChangedCallback r100);

    void verifyForStartLive(Activity r100, int r101, String r102, Bundle r103);
}
