package android.app;

import android.R;
import android.content.Context;
import android.content.res.Resources;
import stepos.app.StepOSWindowManager;

/* loaded from: classes.dex */
public final class CtaPermissionTexts {
    private CtaPermissionTexts() {
    }

    public static class TitleAndContent {
        public String content;
        public String title;

        public TitleAndContent(String title, String content) {
            this.title = "";
            this.content = "";
            this.title = title;
            this.content = content;
        }
    }

    public static TitleAndContent getAppOpsDetails(Context context, int op) throws Resources.NotFoundException {
        String title = String.format("unknown perm(op=%d)", Integer.valueOf(op));
        String content = title;
        switch (op) {
            case 0:
            case 1:
                title = context.getResources().getString(R.string.notification_channel_network_alert);
                content = context.getResources().getString(R.string.notification_channel_network_alerts);
                break;
            case 4:
                title = context.getResources().getString(R.string.dynamic_mode_notification_title);
                content = context.getResources().getString(R.string.dynamic_mode_notification_title_v2);
                break;
            case 5:
                title = context.getResources().getString(17042739);
                content = context.getResources().getString(17042740);
                break;
            case 6:
                title = context.getResources().getString(R.string.concurrent_display_notification_name);
                content = context.getResources().getString(R.string.concurrent_display_notification_power_save_content);
                break;
            case 7:
                title = context.getResources().getString(17042737);
                content = context.getResources().getString(17042738);
                break;
            case 8:
                content = "读取日历数据";
                title = "读取日历数据";
                break;
            case 9:
                content = "写入/删除日历数据";
                title = "写入/删除日历数据";
                break;
            case 13:
                title = context.getResources().getString(R.string.concurrent_display_notification_active_content);
                content = context.getResources().getString(R.string.concurrent_display_notification_active_title);
                break;
            case 14:
                title = context.getResources().getString(17042047);
                content = context.getResources().getString(17042048);
                break;
            case 15:
                title = context.getResources().getString(17042743);
                content = context.getResources().getString(17042744);
                break;
            case 16:
                content = "接收短信";
                title = "接收短信";
                break;
            case 18:
                content = "接收彩信";
                title = "接收彩信";
                break;
            case 20:
                title = context.getResources().getString(17042163);
                content = context.getResources().getString(17042164);
                break;
            case StepOSWindowManager.STEPOS_FEATURE_DISABLE_ORIENTATION_EVENT /* 26 */:
                title = context.getResources().getString(R.string.permlab_startViewPermissionUsage);
                content = context.getResources().getString(R.string.permlab_statusBar);
                break;
            case 27:
                title = context.getResources().getString(R.string.permlab_uninstall_shortcut);
                content = context.getResources().getString(R.string.permlab_updatePackagesWithoutUserAction);
                break;
            case 46:
                content = "录制或投射内容";
                title = "录制或投射内容";
                break;
            case StepOSWindowManager.STEPOS_FEATURE_RECENTS_TRANSITION /* 47 */:
            case 94:
                content = "开启VPN";
                title = "开启VPN";
                break;
            case 51:
                content = "读取设备状态信息";
                title = "读取设备状态信息";
                break;
            case 55:
                content = "读取指纹识别信息";
                title = "读取指纹识别信息";
                break;
            case 56:
                content = "读取身体传感器数据";
                title = "读取身体传感器数据";
                break;
            case 65:
                content = "读取用户本机号码";
                title = "读取用户本机号码";
                break;
            case 66:
            case 91:
                title = context.getResources().getString(R.string.permlab_statusBarService);
                content = context.getResources().getString(R.string.permlab_subscribedFeedsRead);
                break;
            case 71:
                title = context.getResources().getString(17042291);
                content = context.getResources().getString(17042292);
                break;
            case 78:
                content = "读取生物特征识别信息";
                title = "读取生物特征识别信息";
                break;
            case 79:
                content = "识别健身运动类型和状态";
                title = "识别健身运动类型和状态";
                break;
            case 81:
                content = "读取音频文件";
                title = "读取音频文件";
                break;
            case 82:
                content = "写入/删除音频文件";
                title = "写入/删除音频文件";
                break;
            case 83:
                content = "读取视频文件";
                title = "读取视频文件";
                break;
            case 84:
                content = "写入/删除视频文件";
                title = "写入/删除视频文件";
                break;
            case 85:
                content = "读取图片或照片文件";
                title = "读取图片或照片文件";
                break;
            case 86:
                content = "写入/删除图片或照片文件";
                title = "写入/删除图片或照片文件";
                break;
            case 89:
                title = context.getResources().getString(R.string.permlab_systemAlertWindow);
                content = context.getResources().getString(R.string.permlab_systemCamera);
                break;
            case 90:
                title = context.getResources().getString(R.string.permlab_readSyncSettings);
                content = context.getResources().getString(R.string.permlab_readSyncStats);
                break;
            case 110:
                content = "管理媒体文件";
                title = "管理媒体文件";
                break;
            case 111:
                content = "开启/关闭/连接蓝牙";
                title = "开启/关闭/连接蓝牙";
                break;
        }
        return new TitleAndContent(title, content);
    }

    public static TitleAndContent getPermissonTypeDetails(Context mContext, int code) throws Resources.NotFoundException {
        String title = String.format("unknown perm(op=%d)", Integer.valueOf(code));
        String content = title;
        switch (code) {
            case 4:
                title = mContext.getResources().getString(R.string.dynamic_mode_notification_title);
                content = mContext.getResources().getString(R.string.dynamic_mode_notification_title_v2);
                break;
            case 5:
                title = mContext.getResources().getString(17042739);
                content = mContext.getResources().getString(17042740);
                break;
            case 6:
                title = mContext.getResources().getString(R.string.concurrent_display_notification_name);
                content = mContext.getResources().getString(R.string.concurrent_display_notification_power_save_content);
                break;
            case 7:
                title = mContext.getResources().getString(17042737);
                content = mContext.getResources().getString(17042738);
                break;
            case 13:
                title = mContext.getResources().getString(R.string.concurrent_display_notification_active_content);
                content = mContext.getResources().getString(R.string.concurrent_display_notification_active_title);
                break;
            case 14:
                title = mContext.getResources().getString(17042047);
                content = mContext.getResources().getString(17042048);
                break;
            case 15:
                title = mContext.getResources().getString(17042743);
                content = mContext.getResources().getString(17042744);
                break;
            case 20:
                title = mContext.getResources().getString(17042163);
                content = mContext.getResources().getString(17042164);
                break;
            case 23:
                title = mContext.getResources().getString(R.string.permlab_useBiometric);
                content = mContext.getResources().getString(R.string.permlab_useDataInBackground);
                break;
            case 27:
                title = mContext.getResources().getString(R.string.permlab_uninstall_shortcut);
                content = mContext.getResources().getString(R.string.permlab_updatePackagesWithoutUserAction);
                break;
            case 56:
                title = mContext.getResources().getString(R.string.permlab_statusBarService);
                content = mContext.getResources().getString(R.string.permlab_subscribedFeedsRead);
                break;
            case 58:
                content = "联网";
                title = "联网";
                break;
            case 59:
                title = mContext.getResources().getString(R.string.permlab_useFingerprint);
                content = mContext.getResources().getString(R.string.permlab_use_exact_alarm);
                break;
            case 60:
                title = mContext.getResources().getString(17042741);
                content = mContext.getResources().getString(17042742);
                break;
            case 61:
                title = mContext.getResources().getString(R.string.expand_button_content_description_collapsed);
                content = mContext.getResources().getString(R.string.expand_button_content_description_expanded);
                break;
            case 62:
                title = mContext.getResources().getString(R.string.eventTypeOther);
                content = mContext.getResources().getString(R.string.expand_action_accessibility);
                break;
            case 63:
                title = mContext.getResources().getString(R.string.eventTypeBirthday);
                content = mContext.getResources().getString(R.string.eventTypeCustom);
                break;
            case 64:
                title = mContext.getResources().getString(R.string.etws_primary_default_message_tsunami);
                content = mContext.getResources().getString(R.string.eventTypeAnniversary);
                break;
            case 66:
                title = mContext.getResources().getString(17042045);
                content = mContext.getResources().getString(17042046);
                break;
            case 67:
                title = mContext.getResources().getString(17042161);
                content = mContext.getResources().getString(17042162);
                break;
            case 68:
                title = mContext.getResources().getString(17042291);
                content = mContext.getResources().getString(17042292);
                break;
            case 69:
                title = mContext.getResources().getString(17042287);
                content = mContext.getResources().getString(17042288);
                break;
            case 73:
                title = mContext.getResources().getString(R.string.permlab_systemAlertWindow);
                content = mContext.getResources().getString(R.string.permlab_systemCamera);
                break;
            case 75:
                title = mContext.getResources().getString(R.string.notification_channel_network_alert);
                content = mContext.getResources().getString(R.string.notification_channel_network_alerts);
                break;
            case 76:
                title = mContext.getResources().getString(R.string.permlab_startViewPermissionUsage);
                content = mContext.getResources().getString(R.string.permlab_statusBar);
                break;
            case 77:
                title = mContext.getResources().getString(17042285);
                content = mContext.getResources().getString(17042286);
                break;
            case 80:
                content = "获取Mac地址";
                title = "获取Mac地址";
                break;
            case 100:
                title = mContext.getResources().getString(R.string.permlab_readSyncSettings);
                content = mContext.getResources().getString(R.string.permlab_readSyncStats);
                break;
        }
        return new TitleAndContent(title, content);
    }

    public static String getDirName(int op) {
        Context ctx = ActivityThread.currentApplication().getApplicationContext();
        switch (op) {
            case 203:
                return ctx.getResources().getString(R.string.permlab_recordAudio);
            case 204:
                return ctx.getResources().getString(R.string.permlab_sdcardRead);
            case 205:
                return ctx.getResources().getString(R.string.permlab_route_media_output);
            case 206:
                return ctx.getResources().getString(R.string.permlab_requestPasswordComplexity);
            case 207:
                return ctx.getResources().getString(R.string.permlab_receiveWapPush);
            case 208:
            case 210:
                return ctx.getResources().getString(R.string.permlab_startViewAppFeatures);
            case 209:
                return ctx.getResources().getString(R.string.permlab_startReviewPermissionDecisions);
            default:
                return "";
        }
    }
}
