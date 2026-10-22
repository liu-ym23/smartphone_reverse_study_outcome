package com.android.server.notification;

import android.content.Context;
import android.net.Uri;
import android.os.VibrationEffect;
import android.provider.Settings;
import android.util.Slog;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public class NotificationAttentionHelperSmtEx {
    private static final String CALENDAR_PACKAGE = "com.obric.calendar";
    private static final Uri CALENDAR_VIBRATION_EFFECT_URI = null;
    public static final String EXTRA_SIM_SLOT_ID = "android.sim.slotId";
    private static final String MAIL_PACKAGE = "com.android.email";
    private static final Uri MAIL_VIBRATION_EFFECT_URI = null;
    private static final String MMS_PACKAGE = "com.android.mms";
    private static final Uri NOTIFICATION_VIBRATION_EFFECT_URI = null;
    private static final Uri SMS_1_VIBRATION_EFFECT_URI = null;
    private static final Uri SMS_2_VIBRATION_EFFECT_URI = null;
    static final String TAG = "NotifAttentionHelperSmtEx";
    private static final Set<String> WHITELISTED_APPS = null;
    private String mCalendarVibrationEffectUri;
    private final Context mContext;
    private final NotificationAttentionHelper mHelper;
    private String mMailVibrationEffectUri;
    private String mNotificationVibrationEffectUri;
    private String mSms1VibrationEffectUri;
    private String mSms2VibrationEffectUri;

    static {
        WHITELISTED_APPS = new HashSet(Set.of(CALENDAR_PACKAGE, MAIL_PACKAGE, MMS_PACKAGE));
        CALENDAR_VIBRATION_EFFECT_URI = Settings.Global.getUriFor("calendar_vibration_effect_uri");
        SMS_1_VIBRATION_EFFECT_URI = Settings.Global.getUriFor("sms_1_vibration_effect_uri");
        SMS_2_VIBRATION_EFFECT_URI = Settings.Global.getUriFor("sms_2_vibration_effect_uri");
        MAIL_VIBRATION_EFFECT_URI = Settings.Global.getUriFor("mail_vibration_effect_uri");
        NOTIFICATION_VIBRATION_EFFECT_URI = Settings.Global.getUriFor("notification_vibration_effect_uri");
    }

    public NotificationAttentionHelperSmtEx(NotificationAttentionHelper record, Context context) {
        this.mCalendarVibrationEffectUri = "";
        this.mSms1VibrationEffectUri = "";
        this.mSms2VibrationEffectUri = "";
        this.mMailVibrationEffectUri = "";
        this.mNotificationVibrationEffectUri = "";
        this.mHelper = record;
        this.mContext = context;
    }

    public void onSettingsChanged(boolean selfChange, Uri uri) {
        if (CALENDAR_VIBRATION_EFFECT_URI.equals(uri) == false) goto L6;
        this.mCalendarVibrationEffectUri = Settings.Global.getStringForUser(this.mContext.getContentResolver(), "calendar_vibration_effect_uri", -1);
    L6:
        if (SMS_1_VIBRATION_EFFECT_URI.equals(uri) == false) goto L9;
        this.mSms1VibrationEffectUri = Settings.Global.getStringForUser(this.mContext.getContentResolver(), "sms_1_vibration_effect_uri", -1);
    L9:
        if (SMS_2_VIBRATION_EFFECT_URI.equals(uri) == false) goto L12;
        this.mSms2VibrationEffectUri = Settings.Global.getStringForUser(this.mContext.getContentResolver(), "sms_2_vibration_effect_uri", -1);
    L12:
        if (MAIL_VIBRATION_EFFECT_URI.equals(uri) == false) goto L15;
        this.mMailVibrationEffectUri = Settings.Global.getStringForUser(this.mContext.getContentResolver(), "mail_vibration_effect_uri", -1);
    L15:
        if (NOTIFICATION_VIBRATION_EFFECT_URI.equals(uri) == false) goto L18;
        this.mNotificationVibrationEffectUri = Settings.Global.getStringForUser(this.mContext.getContentResolver(), "notification_vibration_effect_uri", -1);
        return;
    }

    public void registerSettingsObserver(NotificationAttentionHelper.SettingsObserver settingsObserver) {
        this.mContext.getContentResolver().registerContentObserver(CALENDAR_VIBRATION_EFFECT_URI, false, settingsObserver, -1);
        this.mContext.getContentResolver().registerContentObserver(SMS_1_VIBRATION_EFFECT_URI, false, settingsObserver, -1);
        this.mContext.getContentResolver().registerContentObserver(SMS_2_VIBRATION_EFFECT_URI, false, settingsObserver, -1);
        this.mContext.getContentResolver().registerContentObserver(MAIL_VIBRATION_EFFECT_URI, false, settingsObserver, -1);
        this.mContext.getContentResolver().registerContentObserver(NOTIFICATION_VIBRATION_EFFECT_URI, false, settingsObserver, -1);
    }

    public void loadUserSettings() {
        this.mCalendarVibrationEffectUri = Settings.Global.getStringForUser(this.mContext.getContentResolver(), "calendar_vibration_effect_uri", -1);
        this.mSms1VibrationEffectUri = Settings.Global.getStringForUser(this.mContext.getContentResolver(), "sms_1_vibration_effect_uri", -1);
        this.mSms2VibrationEffectUri = Settings.Global.getStringForUser(this.mContext.getContentResolver(), "sms_2_vibration_effect_uri", -1);
        this.mMailVibrationEffectUri = Settings.Global.getStringForUser(this.mContext.getContentResolver(), "mail_vibration_effect_uri", -1);
        this.mNotificationVibrationEffectUri = Settings.Global.getStringForUser(this.mContext.getContentResolver(), "notification_vibration_effect_uri", -1);
    }

    protected VibrationEffect calculateVibrationEffect(NotificationRecord record) {
    L7:
        e = move-exception;
        Slog.w(TAG, "calculateVibrationEffect: " + e.getMessage());
        return null;
    L4:
        if (record.sbn.getPackageName().contains(CALENDAR_PACKAGE) == false) goto L10;
        return VibrationEffect.getEffectByUri(Uri.parse(this.mCalendarVibrationEffectUri), this.mContext);
    L10:
        if (record.sbn.getPackageName().contains(MAIL_PACKAGE) == false) goto L14;
        return VibrationEffect.getEffectByUri(Uri.parse(this.mMailVibrationEffectUri), this.mContext);
    L14:
        if (record.sbn.getPackageName().contains(MMS_PACKAGE) == false) goto L26;
        int simSlotId = getSimSlotId(record);     // Catch: Exception -> L7
        if (simSlotId != 0) goto L20;
        return VibrationEffect.getEffectByUri(Uri.parse(this.mSms1VibrationEffectUri), this.mContext);
    L20:
        if (simSlotId == 1) goto L22;
        Slog.e(TAG, "calculateVibrationEffect: invalid sim slot id");     // Catch: Exception -> L7
        return null;
    L22:
        return VibrationEffect.getEffectByUri(Uri.parse(this.mSms2VibrationEffectUri), this.mContext);
    L26:
        return VibrationEffect.getEffectByUri(Uri.parse(this.mNotificationVibrationEffectUri), this.mContext);
    }

    protected int getSimSlotId(NotificationRecord record) {
        if (record.getNotification().extras != null) goto L5;
    L8:
        Slog.i(TAG, "getSimSlotId: no EXTRA_SIM_SLOT_ID");
        return -1;
    L5:
        if (record.getNotification().extras.containsKey(EXTRA_SIM_SLOT_ID) == false) goto L8;
        int slotId = record.getNotification().extras.getInt(EXTRA_SIM_SLOT_ID, -1);
        Slog.d(TAG, "getSimSlotId: " + slotId);
        return slotId;
    }
}
