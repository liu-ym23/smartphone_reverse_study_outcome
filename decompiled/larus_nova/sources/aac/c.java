package aac;

import com.bytedance.lark.pb.settings.v1.ExternalDisplayTimezoneSetting;
import com.bytedance.lark.pb.settings.v1.GetUserSettingResponse;
import com.bytedance.lark.pb.settings.v1.PushUserSetting;
import com.ss.android.lark.usersetting.base.UserSetting;
import com.ss.android.lark.usersetting.entity.BadgeStyle;
import com.ss.android.lark.usersetting.entity.NotificationSettingV2;
import com.ss.android.lark.usersetting.entity.SmsPhoneUrgentSetting;
import com.ss.android.lark.usersetting.service.timeformat.TimeFormatSetting;
import com.ss.android.lark.usersetting.service.timezone.ExposureTimeZoneSetting;

/* JADX INFO: loaded from: classes38.dex */
public final class c {
    public static UserSetting a(PushUserSetting r110) {
        BadgeStyle r100 = BadgeStyle.forNumber(r110.badge_style.getValue());
        boolean r101 = r110.navigation_show_mute_badge.booleanValue();
        TimeFormatSetting r102 = new TimeFormatSetting();
        com.bytedance.lark.pb.settings.v1.TimeFormatSetting r103 = r110.time_format;
        if (r103 == null) goto L5;
        r102.setTimeFormat(TimeFormatSetting.TimeFormat.forNumber(r103.time_format.getValue()));
    L5:
        boolean r104 = r110.auto_audio_to_text.booleanValue();
        long r105 = r110.do_not_disturb_end_time.longValue();
        SmsPhoneUrgentSetting r111 = new SmsPhoneUrgentSetting();
        com.bytedance.lark.pb.settings.v1.SmsPhoneUrgentSetting r106 = r110.sms_phone_urgent_setting;
        if (r106 == null) goto L8;
        r111.setAccept(r106.accept.booleanValue());
        r111.setCanModify(r106.can_modify.booleanValue());
        r111.setCanSend(r106.can_send.booleanValue());
        r111.setNeedConfirm(r106.need_confirm.booleanValue());
    L8:
        NotificationSettingV2 r112 = com.ss.android.lark.usersetting.entity.a.a(r110.notification_setting_v2);
        long r113 = r110.update_time.longValue();
        boolean r114 = r110.message_notifications_off_during_calls.booleanValue();
        ExternalDisplayTimezoneSetting r107 = r110.external_display_timezone;
        if (r107 == null) goto L11;
        ExposureTimeZoneSetting r115 = new ExposureTimeZoneSetting(r107.type, r107.timezone, r107.timezone_offset.intValue());
    L13:
        return new UserSetting(true, r100, r101, r102, r104, r105, r111, r112, r113, r114, r115);
    L11:
        r115 = new ExposureTimeZoneSetting();
        goto L13
    }

    public static UserSetting b(GetUserSettingResponse r110) {
        boolean r100 = r110.auto_update_work_status.booleanValue();
        BadgeStyle r101 = BadgeStyle.forNumber(r110.badge_style.getValue());
        boolean r102 = r110.navigation_show_mute_badge.booleanValue();
        TimeFormatSetting r103 = new TimeFormatSetting();
        com.bytedance.lark.pb.settings.v1.TimeFormatSetting r104 = r110.time_format;
        if (r104 == null) goto L5;
        r103.setTimeFormat(TimeFormatSetting.TimeFormat.forNumber(r104.time_format.getValue()));
    L5:
        boolean r105 = r110.auto_audio_to_text.booleanValue();
        long r106 = r110.do_not_disturb_end_time.longValue();
        SmsPhoneUrgentSetting r111 = new SmsPhoneUrgentSetting();
        com.bytedance.lark.pb.settings.v1.SmsPhoneUrgentSetting r107 = r110.sms_phone_urgent_setting;
        if (r107 == null) goto L8;
        r111.setAccept(r107.accept.booleanValue());
        r111.setCanModify(r107.can_modify.booleanValue());
        r111.setCanSend(r107.can_send.booleanValue());
        r111.setNeedConfirm(r107.need_confirm.booleanValue());
    L8:
        NotificationSettingV2 r112 = com.ss.android.lark.usersetting.entity.a.a(r110.notification_setting_v2);
        long r113 = r110.update_time.longValue();
        boolean r114 = r110.message_notifications_off_during_calls.booleanValue();
        ExternalDisplayTimezoneSetting r108 = r110.external_display_timezone;
        if (r108 == null) goto L11;
        ExposureTimeZoneSetting r115 = new ExposureTimeZoneSetting(r108.type, r108.timezone, r108.timezone_offset.intValue());
    L13:
        return new UserSetting(r100, r101, r102, r103, r105, r106, r111, r112, r113, r114, r115);
    L11:
        r115 = new ExposureTimeZoneSetting();
        goto L13
    }
}
