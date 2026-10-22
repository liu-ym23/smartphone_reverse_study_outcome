package com.bytedance.android.livehostapi.platform;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Looper;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.hostadapter.image.FrescoHelper;
import com.bytedance.android.live.saas.middleware.BDLiveSdk;
import com.bytedance.android.livehostapi.business.depend.IPluginInstallCallback;
import com.bytedance.android.livehostapi.business.depend.feed.IHostAvatarBorderController;
import com.bytedance.android.livehostapi.business.depend.feed.IHostLiveCircleView;
import com.bytedance.android.livehostapi.business.depend.gamecenter.IHostGameCenterService;
import com.bytedance.android.livehostapi.business.depend.hashtag.ILiveHashTagCallback;
import com.bytedance.android.livehostapi.business.depend.hashtag.LiveHashTagParams;
import com.bytedance.android.livehostapi.business.depend.openplatform.IHostOpenPlatformGameService;
import com.bytedance.android.livehostapi.foundation.IHostApp;
import com.bytedance.android.livehostapi.foundation.depend.IHostAppMonitorListener;
import com.bytedance.android.livehostapi.foundation.depend.ILocalDoActionRequestCallback;
import com.bytedance.android.livehostapi.foundation.depend.IWebViewContainer;
import com.bytedance.android.livehostapi.foundation.depend.OnBindPhoneListener;
import com.bytedance.android.livehostapi.wrap.AbsHostApp;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.larus.nova.R;
import io.reactivex.Observable;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import jc1.j;
import jc1.k;
import me.ele.lancet.base.annotations.Skip;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes7.dex */
public class LiveHostApp extends AbsHostApp {
    private static final int SHOW_INTERVAL = 2500;
    private static String sLastToastStr = "";
    private static long sLastToastTime;
    private int toastTextViewId;

    public static /* synthetic */ Class access$000(String r100) throws ClassNotFoundException {
        return Class.forName(r100);
    }

    @Override // com.bytedance.android.livehostapi.hostdefault.HostAppDefault, com.bytedance.android.livehostapi.foundation.IHostApp, com.bytedance.android.livehostapi.foundation.IMiddlewareHostApp
    public IHostAvatarBorderController avatarBorderController() {
        return null;
    }

    @Override // com.bytedance.android.livehostapi.hostdefault.HostAppDefault, com.bytedance.android.livehostapi.foundation.IHostApp, com.bytedance.android.livehostapi.foundation.IMiddlewareHostApp
    public void centerIconToast(Context r100, Map<String, Object> r101) {
    }

    @Override // com.bytedance.android.livehostapi.wrap.AbsHostApp, com.bytedance.android.livehostapi.hostdefault.HostAppDefault, com.bytedance.android.livehostapi.foundation.IHostAppForSaas
    public void checkUploadPlugin(Context r100, Boolean r101, IPluginInstallCallback r102) {
    }

    @Override // com.bytedance.android.livehostapi.hostdefault.HostAppDefault, com.bytedance.android.livehostapi.foundation.IHostApp, com.bytedance.android.livehostapi.foundation.IMiddlewareHostApp
    public IWebViewContainer createHostWebViewHolder(Activity r100) {
        return null;
    }

    @Override // com.bytedance.android.livehostapi.hostdefault.HostAppDefault, com.bytedance.android.livehostapi.foundation.IHostApp
    public void doActionWithToken(String r100, String r101, String r102, JSONObject r103, ILocalDoActionRequestCallback r104) {
    }

    @Override // com.bytedance.android.livehostapi.hostdefault.HostAppDefault, com.bytedance.android.livehostapi.foundation.IHostApp, com.bytedance.android.livehostapi.foundation.IMiddlewareHostApp
    public List<Class> getAllLiveActivity() {
        return null;
    }

    @Override // com.bytedance.android.livehostapi.hostdefault.HostAppDefault, com.bytedance.android.livehostapi.foundation.IHostApp, com.bytedance.android.livehostapi.foundation.IMiddlewareHostApp
    public String getAudioAccessibilityServiceName() {
        return null;
    }

    @Override // com.bytedance.android.livehostapi.hostdefault.HostAppDefault, com.bytedance.android.livehostapi.foundation.IHostApp, com.bytedance.android.livehostapi.foundation.IMiddlewareHostApp
    public Activity getCurrentActivity() {
        return null;
    }

    @Override // com.bytedance.android.livehostapi.hostdefault.HostAppDefault, com.bytedance.android.livehostapi.foundation.IHostApp
    public IHostGameCenterService getGameCenterService() {
        return null;
    }

    @Override // com.bytedance.android.livehostapi.hostdefault.HostAppDefault, com.bytedance.android.livehostapi.foundation.IHostApp
    public IHostOpenPlatformGameService getOpenPlatformGameService() {
        return null;
    }

    @Override // com.bytedance.android.livehostapi.hostdefault.HostAppDefault, com.bytedance.android.livehostapi.foundation.IHostApp
    public Activity getPreviousActivity() {
        return null;
    }

    @Override // com.bytedance.android.livehostapi.hostdefault.HostAppDefault, com.bytedance.android.livehostapi.foundation.IHostApp, com.bytedance.android.livehostapi.foundation.IMiddlewareHostApp
    public Observable<String> getRecommendHashTag(LiveHashTagParams r100) {
        return null;
    }

    @Override // com.bytedance.android.livehostapi.hostdefault.HostAppDefault, com.bytedance.android.livehostapi.foundation.IHostApp
    public String getRecordServiceName() {
        return "com.bytedance.android.openlive.record.DefaultRecordService";
    }

    @Override // com.bytedance.android.livehostapi.hostdefault.HostAppDefault, com.bytedance.android.livehostapi.foundation.IHostApp, com.bytedance.android.livehostapi.foundation.IMiddlewareHostApp
    public String getSessionId() {
        return null;
    }

    @Override // com.bytedance.android.livehostapi.hostdefault.HostAppDefault, com.bytedance.android.livehostapi.foundation.IHostApp
    public String getTimingCloseActivityName() {
        return "";
    }

    @Override // com.bytedance.android.livehostapi.hostdefault.HostAppDefault, com.bytedance.android.livehostapi.foundation.IHostApp, com.bytedance.android.livehostapi.foundation.IMiddlewareHostApp
    public Activity getTopActivity() {
        return null;
    }

    @Override // com.bytedance.android.livehostapi.hostdefault.HostAppDefault, com.bytedance.android.livehostapi.foundation.IHostApp, com.bytedance.android.livehostapi.foundation.IMiddlewareHostApp
    public Boolean isHostPlaying() {
        return null;
    }

    @Override // com.bytedance.android.livehostapi.hostdefault.HostAppDefault, com.bytedance.android.livehostapi.foundation.IHostApp
    public Boolean isHostUnMutePlaying() {
        return null;
    }

    @Override // com.bytedance.android.livehostapi.hostdefault.HostAppDefault, com.bytedance.android.livehostapi.foundation.IHostApp, com.bytedance.android.livehostapi.foundation.IMiddlewareHostApp
    public IHostLiveCircleView liveCircleView(Context r100) {
        return null;
    }

    @Override // com.bytedance.android.livehostapi.hostdefault.HostAppDefault, com.bytedance.android.livehostapi.foundation.IHostApp
    public void makeShowCustomToast(String r100, int r101, boolean r102) {
    }

    @Override // com.bytedance.android.livehostapi.hostdefault.HostAppDefault, com.bytedance.android.livehostapi.foundation.IHostApp, com.bytedance.android.livehostapi.foundation.IMiddlewareHostApp
    public void openWallet(Activity r100) {
    }

    @Override // com.bytedance.android.livehostapi.hostdefault.HostAppDefault, com.bytedance.android.livehostapi.foundation.IHostApp, com.bytedance.android.livehostapi.foundation.IMiddlewareHostApp
    public void registerLiveLifeCycleListener(IHostAppMonitorListener r100) {
    }

    @Override // com.bytedance.android.livehostapi.hostdefault.HostAppDefault, com.bytedance.android.livehostapi.foundation.IHostApp, com.bytedance.android.livehostapi.foundation.IMiddlewareHostApp
    public Dialog selectHashTag(Context r100, LiveHashTagParams r101, ILiveHashTagCallback r102) {
        return null;
    }

    @Override // com.bytedance.android.livehostapi.hostdefault.HostAppDefault, com.bytedance.android.livehostapi.foundation.IHostApp, com.bytedance.android.livehostapi.foundation.IMiddlewareHostApp
    public void sendHostLogEvent(String r100, Bundle r101) {
    }

    @Override // com.bytedance.android.livehostapi.hostdefault.HostAppDefault, com.bytedance.android.livehostapi.foundation.IHostApp, com.bytedance.android.livehostapi.foundation.IMiddlewareHostApp
    public void startBindMobileFullFragment(Activity r100, String r101, String r102, OnBindPhoneListener r103) {
    }

    @Override // com.bytedance.android.livehostapi.hostdefault.HostAppDefault, com.bytedance.android.livehostapi.foundation.IHostApp, com.bytedance.android.livehostapi.foundation.IMiddlewareHostApp
    public void startBindPhoneDialogFragment(Activity r100, String r101, String r102, OnBindPhoneListener r103) {
    }

    @Override // com.bytedance.android.livehostapi.hostdefault.HostAppDefault, com.bytedance.android.livehostapi.foundation.IHostApp, com.bytedance.android.livehostapi.foundation.IMiddlewareHostApp
    public void startBindSafeMobileFullFragment(Activity r100, String r101, String r102, Bundle r103, OnBindPhoneListener r104) {
    }

    @Override // com.bytedance.android.livehostapi.hostdefault.HostAppDefault, com.bytedance.android.livehostapi.foundation.IHostApp, com.bytedance.android.livehostapi.foundation.IMiddlewareHostApp
    public boolean startVideoRecordActivity(Activity r100, String r101) {
        return false;
    }

    @Override // com.bytedance.android.livehostapi.hostdefault.HostAppDefault, com.bytedance.android.livehostapi.foundation.IHostApp, com.bytedance.android.livehostapi.foundation.IMiddlewareHostApp
    public List<Activity> getAllActivity() {
        return new LinkedList();
    }

    @Override // com.bytedance.android.livehostapi.wrap.AbsHostApp, com.bytedance.android.livehostapi.hostdefault.HostAppDefault, com.bytedance.android.livehostapi.foundation.IHostApp, com.bytedance.android.livehostapi.foundation.IMiddlewareHostApp
    public boolean shouldUseScopedStorage() {
        if (Build.VERSION.SDK_INT < 30) goto L5;
        return true;
    L5:
        return false;
    }

    public LiveHostApp() {
        k.l(IHostApp.class, (IHostApp) j.a(this, IHostApp.class));
    }

    @Override // com.bytedance.android.livehostapi.hostdefault.HostAppDefault, com.bytedance.android.livehostapi.foundation.IHostApp
    public List<Class> getAllWatchLiveActivity() {
        return getAllLiveActivity();
    }

    @Override // com.bytedance.android.livehostapi.wrap.AbsHostApp
    public String getAppLogSessionId() {
        if (BDLiveSdk.appLog() != null) goto L7;
        return "";
    L7:
        return BDLiveSdk.appLog().getCurrentSessionId();
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKESTATIC_com_bytedance_android_livehostapi_platform_LiveHostApp_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r100) throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r101 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r102 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class r103 = access$000(r100);     // Catch: Throwable -> L8
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a(r100);     // Catch: Throwable -> L8
    L7:
        return r103;
    L8:
        th = move-exception;
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b(r100);
    L12:
        throw th;
    L34:
        Class r104 = access$000(r100);     // Catch: Throwable -> L17
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a(r100);     // Catch: Throwable -> L17
    L16:
        return r104;
    L17:
        th = move-exception;
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b(r100);
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName(r100);
    }

    private static boolean isDownloaded(Uri r100) {
        if (r100 != null) goto L6;
        return false;
    L6:
        return FrescoHelper.isDownloaded(r100);
    }

    @Override // com.bytedance.android.livehostapi.hostdefault.HostAppDefault, com.bytedance.android.livehostapi.foundation.IHostApp
    public List<Class> getAllWatchLiveActivity(boolean r100) {
        return getAllLiveActivity();
    }

    @Override // com.bytedance.android.livehostapi.hostdefault.HostAppDefault, com.bytedance.android.livehostapi.foundation.IMiddlewareHostApp
    public Long getDelayTimeDirect(String r100) {
        return 0L;
    }

    @Override // com.bytedance.android.livehostapi.hostdefault.HostAppDefault, com.bytedance.android.livehostapi.foundation.IHostApp, com.bytedance.android.livehostapi.foundation.IMiddlewareHostApp
    public Class getHostActivity(int r100) {
        if (r100 == 5) goto L10;
        if (r100 == 6) goto L8;
        return null;
    L8:
        return INVOKESTATIC_com_bytedance_android_livehostapi_platform_LiveHostApp_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("com.bytedance.android.live.broadcast.LiveBgBroadcastActivity");
    L10:
        return INVOKESTATIC_com_bytedance_android_livehostapi_platform_LiveHostApp_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("com.bytedance.android.live.broadcast.LiveBroadcastActivity");
    L15:
        return null;
    }

    @Override // com.bytedance.android.livehostapi.wrap.AbsHostApp, com.bytedance.android.livehostapi.hostdefault.HostAppDefault, com.bytedance.android.livehostapi.foundation.IHostApp, com.bytedance.android.livehostapi.foundation.IMiddlewareHostApp
    public void systemToast(Context r100, String r101, int r102) {
        centerToast(r100, r101, r102);
    }

    @Override // com.bytedance.android.livehostapi.wrap.AbsHostApp, com.bytedance.android.livehostapi.hostdefault.HostAppDefault, com.bytedance.android.livehostapi.foundation.IHostApp, com.bytedance.android.livehostapi.foundation.IMiddlewareHostApp
    public void centerToast(Context r100, String r101, int r102, boolean r103) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (TextUtils.isEmpty(r101) == false) goto L7;
        return;
    L7:
        if (Looper.myLooper() != null) goto L11;
        ALogger.w("ToastUtil", "toast on wrong thread, won't show, content:" + r101);
        return;
    L11:
        if (r101.equals(sLastToastStr) == true) goto L13;
    L15:
        View r104 = ((LayoutInflater) r100.getSystemService("layout_inflater")).inflate(R.layout.ttlive_view_live_custom_toast_douyin, null);
        if ((r104 instanceof TextView) == true) goto L18;
        return;
    L18:
        ((TextView) r104).setText(r101);
        Toast r105 = new Toast(r100);
        if (r103 == false) goto L21;
        r105.setGravity(17, 0, 0);
    L21:
        r105.setView(r104);
        r105.setDuration(r102);
        r105.show();
        sLastToastStr = r101;
        sLastToastTime = System.currentTimeMillis();
        return;
    L13:
        if ((System.currentTimeMillis() - sLastToastTime) >= 2500) goto L15;
    }
}
