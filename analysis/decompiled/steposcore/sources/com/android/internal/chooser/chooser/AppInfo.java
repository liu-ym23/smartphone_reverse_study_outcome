package com.android.internal.chooser.chooser;

import android.content.Context;
import android.content.pm.ComponentInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import java.util.Locale;

/* loaded from: classes.dex */
public enum AppInfo {
    WECHAT_FRIEND("com.tencent.mm", "com.tencent.mm.ui.tools.ShareImgUI", true, 0, false, "微信好友", 0),
    QQ_FRIEND("com.tencent.mobileqq", "com.tencent.mobileqq.activity.JumpActivity", true, 1, false, "QQ 好友", 0),
    NOTE_COLLECT("com.stepos.notepaper", "com.stepos.memory.page.CollectActivity", true, 2, false, null, 0),
    FEI_SHU("com.ss.android.lark", "com.ss.android.lark.share.impl.systemshare.ShareActivity", true, 3, false, null, 0),
    FEI_SHU_YKT("com.ss.android.lark.ykt", "com.ss.android.lark.share.impl.systemshare.ShareActivity", true, 4, false, null, 0),
    WE_WORK("com.tencent.wework", "com.tencent.wework.launch.AppSchemeLaunchActivity", true, 5, false, "企业微信", 0),
    DING_DING("com.alibaba.android.rimet", "com.alibaba.android.rimet.biz.BokuiActivity", true, 6, false, null, 0),
    QQ_FILE("com.tencent.mobileqq", "com.tencent.mobileqq.activity.qfileJumpActivity", true, 7, false, "我的电脑", 0),
    WECHAT_MOMENT("com.tencent.mm", "com.tencent.mm.ui.tools.ShareToTimeLineUI", true, 8, false, "朋友圈", 0),
    WECHAT_FAVOIRTE("com.tencent.mm", "com.tencent.mm.ui.tools.AddFavoriteUI", true, 9, false, "微信收藏", 0),
    WEIBO("com.sina.weibo", "com.sina.weibo.composerinde.ComposerDispatchActivity", true, 10, false, null, 0),
    EMAIL("com.android.email", "com.android.email.activity.MessageCompose", true, 11, false, null, 0),
    QR_FILE("com.stepos.filemanager", "com.stepos.filemanager.qrcode.ui.QrFilesCheckActivity", true, 12, false, null, 0),
    NOTE("com.stepos.notepaper", "com.stepos.notepaper.app.ShareStubActivity", true, 13, false, null, 0),
    TODO("com.stepos.todolist", "com.stepos.todolist.ui.TodoDetailActivity", true, 14, false, null, 0),
    SHARE_AGENT("com.stepos.ailauncher", "com.stepos.ailauncher.chat.activity.ShareActivity", false, -1, true, null, 17304664),
    MUTUAL_SENDING("com.stepos.share", "com.stepos.share.mutual.MutualSendingActivity", false, 0, true, null, 17304661),
    BLUETOOTH("com.android.bluetooth", "com.android.bluetooth.opp.BluetoothOppLauncherActivity", false, 1, true, null, 17304651),
    BLUETOOTH_F10("com.stepos.share", "com.stepos.share.BluetoothOppLauncherActivity", false, 1, true, null, 17304651),
    PRINT_IMAGE("com.android.bips", "com.android.bips.ImagePrintActivity", false, 2, true, null, 17304662),
    PRINT_PDF("com.android.bips", "com.android.bips.PdfPrintActivity", false, 2, true, null, 17304662);

    public static final String WPS_PACKAGE_NAME = "cn.wps.moffice.lite.wisdom_leaps";
    private String className;
    private String customLabel;
    private int drawableRes;
    private boolean isDefaultFavorite;
    private boolean isDeviceApp;
    private String packageName;
    private int weight;

    AppInfo(String packageName, String className, boolean isDefaultFavorite, int weight, boolean isDeviceApp, String customLabel, int drawableRes) {
        this.packageName = packageName;
        this.className = className;
        this.isDefaultFavorite = isDefaultFavorite;
        this.weight = weight;
        this.isDeviceApp = isDeviceApp;
        this.customLabel = customLabel;
        this.drawableRes = drawableRes;
    }

    private static AppInfo getAppInfo(ComponentInfo info) {
        for (AppInfo appInfo : values()) {
            if (info.packageName.equals(appInfo.packageName) && info.name.equals(appInfo.className)) {
                return appInfo;
            }
        }
        return null;
    }

    public static int getAppWeight(ResolveInfo info) {
        AppInfo appInfo = getAppInfo(info.getComponentInfo());
        if (appInfo != null) {
            return appInfo.weight;
        }
        return Integer.MAX_VALUE;
    }

    public static boolean isDevice(ResolveInfo info) {
        AppInfo appInfo = getAppInfo(info.getComponentInfo());
        return appInfo != null && appInfo.isDeviceApp;
    }

    public static boolean isDefaultFavorite(ResolveInfo info) {
        AppInfo appInfo = getAppInfo(info.getComponentInfo());
        return appInfo != null && appInfo.isDefaultFavorite;
    }

    public static int getAppIcon(ResolveInfo info) {
        AppInfo appInfo = getAppInfo(info.getComponentInfo());
        if (appInfo != null) {
            return appInfo.drawableRes;
        }
        return 0;
    }

    public static String getCustomLabel(Context context, ResolveInfo info) {
        if (!Locale.SIMPLIFIED_CHINESE.equals(Locale.getDefault())) {
            return null;
        }
        if (WPS_PACKAGE_NAME.equals(info.getComponentInfo().packageName)) {
            if (isFileManagerInstalled(context)) {
                return context.getResources().getString(17042472);
            }
            return context.getResources().getString(17042471);
        }
        AppInfo appInfo = getAppInfo(info.getComponentInfo());
        if (appInfo != null) {
            return appInfo.customLabel;
        }
        return null;
    }

    public static String getCustomAppName(Context context, ResolveInfo info) {
        if (Locale.SIMPLIFIED_CHINESE.equals(Locale.getDefault()) && WPS_PACKAGE_NAME.equals(info.getComponentInfo().packageName)) {
            return context.getResources().getString(17042475);
        }
        return null;
    }

    public static boolean isMutual(ResolveInfo info) {
        AppInfo appInfo = getAppInfo(info.getComponentInfo());
        return appInfo != null && appInfo.equals(MUTUAL_SENDING);
    }

    private static boolean isFileManagerInstalled(Context context) throws PackageManager.NameNotFoundException {
        PackageManager packageManager = context.getPackageManager();
        try {
            packageManager.getPackageInfo("com.stepos.filemanager", 1);
            return true;
        } catch (PackageManager.NameNotFoundException e) {
            return false;
        }
    }
}
