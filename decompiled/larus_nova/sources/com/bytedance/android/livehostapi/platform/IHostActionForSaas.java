package com.bytedance.android.livehostapi.platform;

import android.app.Activity;
import android.app.Notification;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import com.bytedance.android.livehostapi.business.depend.notification.NotificationData;
import com.bytedance.android.livehostapi.platform.depend.IPopTuringVerifyCallback;
import com.bytedance.android.livehostapi.platform.depend.IScanResultHandler;
import com.bytedance.android.livesdkapi.service.ILiveCallback;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes7.dex */
public interface IHostActionForSaas {
    public static final int HAR_BY_CAR = 1;
    public static final int HAR_DEFAULT = 0;
    public static final int HAR_DISABLE = -1;
    public static final int HAR_ERROR = -2;
    public static final int HAR_LYING = 3;
    public static final int HAR_STATIC = 0;
    public static final int HAR_WALKING = 2;

    /* JADX INFO: renamed from: com.bytedance.android.livehostapi.platform.IHostActionForSaas$-CC, reason: invalid class name */
    public final /* synthetic */ class CC {
        public static IBeautyValueChangeService $default$getBeautyValueChangeService(IHostActionForSaas r100) {
            return null;
        }

        public static Activity[] $default$getHostActivityStack(IHostActionForSaas r100) {
            return null;
        }

        public static Notification $default$getLivePlayNotification(IHostActionForSaas r100, NotificationData r101, Context r102) {
            return null;
        }

        public static boolean $default$isGreyMode(IHostActionForSaas r100) {
            return false;
        }

        public static void $default$openDouyinProfilePage(IHostActionForSaas r100, String r101, Map r102) {
        }

        public static boolean $default$openMarket(IHostActionForSaas r100, Context r101, String r102) {
            return false;
        }

        public static void $default$openSignActivity(IHostActionForSaas r100, Context r101, Intent r102) {
        }

        public static void $default$openUserProfilePage(IHostActionForSaas r100, String r101, Map r102) {
        }

        public static void $default$openUserProfilePageBySchema(IHostActionForSaas r100, Context r101, Uri r102) {
        }

        public static void $default$popTuringVerifyViewForJSB(IHostActionForSaas r100, Context r101, String r102, IPopTuringVerifyCallback r103) {
        }

        public static void $default$reportTask(IHostActionForSaas r100, int r101, int r102, String r103, int r104) {
        }

        public static void $default$requestBlockGc(IHostActionForSaas r100, Context r101, int r102) {
        }

        public static void $default$startBroadcast(IHostActionForSaas r100, Context r101, Bundle r102) {
        }

        public static void $default$startFeed(IHostActionForSaas r100, Context r101, String r102) {
        }

        public static void $default$startQrScanCode(IHostActionForSaas r100, Context r101, boolean r102, boolean r103, IScanResultHandler r104) {
        }

        public static void $default$doActionWithToken(IHostActionForSaas r100, String r101, String r102, String r103, JSONObject r104, ILiveCallback r105) {
            r105.onFailed(new IllegalStateException("no impl"));
        }
    }

    public interface IBeautyValueChangeService {
        public static final String GENDER_ALL = "2";
        public static final String GENDER_FEMALE = "1";
        public static final String GENDER_MALE = "0";
        public static final int RESCODE_PARAMS_INVALID = 1;
        public static final int RESCODE_SUC = 0;

        boolean couldOpenDataSync();
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface LiveHarStatus {
    }

    void doActionWithToken(String r100, String r101, String r102, JSONObject r103, ILiveCallback<JSONObject> r104);

    IBeautyValueChangeService getBeautyValueChangeService();

    Activity[] getHostActivityStack();

    Notification getLivePlayNotification(NotificationData r100, Context r101);

    boolean isGreyMode();

    void openDouyinProfilePage(String r100, Map<String, String> r101);

    boolean openMarket(Context r100, String r101);

    void openSignActivity(Context r100, Intent r101);

    void openUserProfilePage(String r100, Map<String, String> r101);

    void openUserProfilePageBySchema(Context r100, Uri r101);

    void popTuringVerifyViewForJSB(Context r100, String r101, IPopTuringVerifyCallback r102);

    void reportTask(int r100, int r101, String r102, int r103);

    void requestBlockGc(Context r100, int r101);

    void startBroadcast(Context r100, Bundle r101);

    void startFeed(Context r100, String r101);

    void startQrScanCode(Context r100, boolean r101, boolean r102, IScanResultHandler r103);
}
