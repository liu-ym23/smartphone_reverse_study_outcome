package com.bytedanceos.common.ad.common;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.bytedance.apm.constant.PerfConsts;
import com.bytedanceos.common.R$anim;
import com.bytedanceos.common.R$string;
import com.bytedanceos.common.ad.entity.rep.RepCreativeEntity;
import com.bytedanceos.common.ad.entity.rep.media.RepSplashMediaEntity;
import com.bytedanceos.common.model.AppInfo;
import com.bytedanceos.common.model.Topic;
import com.bytedanceos.common.model.WebParam;
import com.bytedanceos.common.toolbox.c;
import com.bytedanceos.common.toolbox.e;
import com.bytedanceos.common.ui.WebActivity;
import com.bytedanceos.common.ui.listener.AppStateHelper;

/* JADX INFO: loaded from: classes2.dex */
public class AdJumpUtil {
    private static final int MAX_TIME_WAIT_DPL = 5000;
    private static final int MSG_REPORT_SNS_FAIL = 101;
    private static final int MSG_REPORT_SNS_SUCCESS = 100;
    private static AppStateListener mAppStateListener;
    private static ReportHandler mReportHandler;

    /* JADX INFO: renamed from: com.bytedanceos.common.ad.common.AdJumpUtil$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public static class AppStateListener implements AppStateHelper.AppStateChangeListener {
        private String ext;

        private AppStateListener() {
            this.ext = "";
        }

        @Override // com.bytedanceos.common.ui.listener.AppStateHelper.AppStateChangeListener
        public void onBackground(Activity r10) {
            AdJumpUtil.access$200(true, this.ext, false);
        }

        @Override // com.bytedanceos.common.ui.listener.AppStateHelper.AppStateChangeListener
        public void onForeground(Activity r10) {
        }

        public void setExt(String r10) {
            this.ext = r10;
        }

        public /* synthetic */ AppStateListener(AnonymousClass1 r10) {
            this();
        }
    }

    public static class ReportHandler extends Handler {
        private ReportHandler() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message r10) {
            int r11 = r10.what;
            if (r11 != 100) goto L5;
            Object r12 = r10.obj;
            if (r12 != null) goto L15;
            return;
        L15:
            if ((r12 instanceof String) == false) goto L22;
            AdReportUtil.reportSnsEvent(8, (String) r12);
            return;
        L22:
            return;
        L5:
            if (r11 != 101) goto L23;
            Object r13 = r10.obj;
            if (r13 != null) goto L10;
            return;
        L10:
            if ((r13 instanceof String) == false) goto L19;
            AdReportUtil.reportSnsEvent(9, (String) r13);
            return;
        L19:
            return;
        }

        public /* synthetic */ ReportHandler(AnonymousClass1 r10) {
            this();
        }
    }

    static {
        AnonymousClass1 r10 = null;
        mReportHandler = new ReportHandler(r10);
        mAppStateListener = new AppStateListener(r10);
    }

    public AdJumpUtil() {
    }

    public static /* synthetic */ void access$200(boolean r10, String r11, boolean r12) {
        sendDplReportMsg(r10, r11, r12);
    }

    private static boolean deepLink(Activity r10, String r11) {
        if (TextUtils.isEmpty(r11) == false) goto L15;
        return false;
    L15:
        Intent r12 = new Intent("android.intent.action.VIEW", Uri.parse(r11));     // Catch: Exception -> L14
        r12.addFlags(67108864);     // Catch: Exception -> L14
        r12.setFlags(268435456);     // Catch: Exception -> L14
        if (c.a(r10.getPackageManager().queryIntentActivities(r12, 0)) == true) goto L13;
        if (AppStateHelper.getInstance().isSingleActivity() == false) goto L10;
        startMainPage(r10);     // Catch: Exception -> L14
    L10:
        r10.startActivity(r12);     // Catch: Exception -> L14
        r10.finish();     // Catch: Exception -> L14
        return true;
    L13:
        return false;
    }

    public static void jump(Activity r10, RepCreativeEntity<RepSplashMediaEntity> r11) {
        if (r10 == null) goto L18;
        if (r11 == null) goto L22;
        RepSplashMediaEntity r12 = (RepSplashMediaEntity) r11.getMedia();
        if (r12 == null) goto L19;
        int r13 = r12.getCreative_type();
        if (r13 != 2) goto L10;
        openAdWeb(r10, r12, r11.getDsp());
        return;
    L10:
        if (r13 != 3) goto L12;
        startTopic(r10, r12.getSubject());
        return;
    L12:
        if (r13 != 4) goto L23;
        startAppDetail(r10, r12.getPkg());
        return;
    L23:
        return;
    L19:
        return;
    L22:
        return;
    }

    private static void openAdWeb(Activity r10, RepSplashMediaEntity r11, String r12) {
        if (r10 == null) goto L15;
        if (r11 != null) goto L6;
        return;
    L6:
        if (TextUtils.isEmpty(r11.getDeeplink_url()) == false) goto L8;
        openWeb(r10, r11, r12);
        return;
    L8:
        sendDplReportMsg(true, r11.getExt(), true);
        AppStateListener r13 = mAppStateListener;
        if (r13 == null) goto L12;
        r13.setExt(r11.getExt());
        AppStateHelper.getInstance().addListener(mAppStateListener);
    L12:
        if (deepLink(r10, r11.getDeeplink_url()) == true) goto L17;
        openWeb(r10, r11, r12);
        sendDplReportMsg(false, r11.getExt(), false);
        return;
    L17:
        return;
    }

    private static void openWeb(Activity r10, RepSplashMediaEntity r11, String r12) {
        if (r11 != null) goto L4;
        return;
    L4:
        if (TextUtils.isEmpty(r11.getWeb_url()) == true) goto L9;
        TextUtils.isEmpty(r11.getTitle());
        String r13 = r11.getSubject();
        WebParam r14 = new WebParam();
        r14.setTitle(r13);
        r14.setPkg(r11.getPkg());
        r14.setAdExtra(r11.getExt());
        r14.setAdDsp(r12);
        r14.setAppName(r11.getApp_name());
        openWeb(r10, r11.getWeb_url(), r14);
        return;
    }

    private static void sendDplReportMsg(boolean r10, String r11, boolean r12) {
        if (mAppStateListener == null) goto L6;
        AppStateHelper.getInstance().removeListener(mAppStateListener);
    L6:
        if (mReportHandler == null) goto L16;
        Message r13 = new Message();
        r13.obj = r11;
        if (r10 == false) goto L10;
        int r14 = 100;
    L11:
        r13.what = r14;
        mReportHandler.removeMessages(100);
        mReportHandler.removeMessages(101);
        if (r12 == false) goto L14;
        mReportHandler.sendMessageDelayed(r13, PerfConsts.DEFAULT_SERIOUS_BLOCK_INTERVAL_MS);
        return;
    L14:
        mReportHandler.sendMessage(r13);
        return;
    L10:
        r14 = 101;
        goto L11
    }

    private static void startAppDetail(Activity r10, String r11) {
        if (r10 != null) goto L4;
        return;
    L4:
        if (TextUtils.isEmpty(r11) == false) goto L7;
        return;
    L7:
        if (AppStateHelper.getInstance().isSingleActivity() == false) goto L9;
        startMainPage(r10);
    L9:
        AppInfo r12 = new AppInfo();
        r12.appPackageName = r11;
        r12.mPageTitle = r10.getString(R$string.splash_app_detail);
        r12.tabSource = "splash_ad";
        e.e1(r10, r12, 0, null);
        r10.overridePendingTransition(R$anim.slide_in_from_right, R$anim.slide_out_to_left);
        r10.finish();
    }

    public static void startMainPage(Activity r10) {
        Intent r11 = new Intent(r10.getString(R$string.action_main));     // Catch: Exception -> L4
        r11.setPackage(r10.getPackageName());     // Catch: Exception -> L4
        r10.startActivity(r11);     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        e.printStackTrace();
    }

    private static void startTopic(Activity r10, String r11) {
        if (r10 != null) goto L4;
        return;
    L4:
        if (TextUtils.isEmpty(r11) == false) goto L7;
        return;
    L7:
        if (AppStateHelper.getInstance().isSingleActivity() == false) goto L9;
        startMainPage(r10);
    L9:
        Topic r12 = new Topic();
        r12.setId(r11);
        r12.setTabSource("splash_ad");
        e.L0(r10, r12);
        r10.overridePendingTransition(R$anim.slide_in_from_right, R$anim.slide_out_to_left);
        r10.finish();
    }

    public static void openWeb(Activity r10, String r11, WebParam r12) {
        if (r10 != null) goto L4;
        return;
    L4:
        if (TextUtils.isEmpty(r11) == false) goto L7;
        return;
    L7:
        if (AppStateHelper.getInstance().isSingleActivity() == false) goto L9;
        startMainPage(r10);
    L9:
        WebActivity.start(r10, r11, r12);
        r10.overridePendingTransition(R$anim.slide_in_from_right, R$anim.slide_out_to_left);
        r10.finish();
    }
}
