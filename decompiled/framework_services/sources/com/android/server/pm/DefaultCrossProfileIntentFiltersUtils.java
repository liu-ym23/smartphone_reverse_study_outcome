package com.android.server.pm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class DefaultCrossProfileIntentFiltersUtils {
    private static final DefaultCrossProfileIntentFilter ACTION_PICK_DATA = null;
    private static final DefaultCrossProfileIntentFilter ACTION_PICK_IMAGES = null;
    private static final DefaultCrossProfileIntentFilter ACTION_PICK_IMAGES_WITH_DATA_TYPES = null;
    private static final DefaultCrossProfileIntentFilter ACTION_PICK_RAW = null;
    private static final DefaultCrossProfileIntentFilter ACTION_SEND = null;
    private static final DefaultCrossProfileIntentFilter CALL_BUTTON = null;
    private static final DefaultCrossProfileIntentFilter CALL_BUTTON_PRIVATE_PROFILE = null;
    private static final DefaultCrossProfileIntentFilter CALL_MANAGED_PROFILE = null;
    private static final DefaultCrossProfileIntentFilter CALL_PRIVATE_PROFILE = null;
    private static final DefaultCrossProfileIntentFilter CLONE_TO_PARENT_ACTION_PICK_IMAGES = null;
    private static final DefaultCrossProfileIntentFilter CLONE_TO_PARENT_ACTION_PICK_IMAGES_WITH_DATA_TYPES = null;
    private static final DefaultCrossProfileIntentFilter CLONE_TO_PARENT_DIAL_DATA = null;
    private static final DefaultCrossProfileIntentFilter CLONE_TO_PARENT_MEDIA_CAPTURE = null;
    private static final DefaultCrossProfileIntentFilter CLONE_TO_PARENT_PHOTOPICKER_SELECTION = null;
    private static final DefaultCrossProfileIntentFilter CLONE_TO_PARENT_PICK_INSERT_ACTION = null;
    private static final DefaultCrossProfileIntentFilter CLONE_TO_PARENT_SEND_ACTION = null;
    private static final DefaultCrossProfileIntentFilter CLONE_TO_PARENT_SMS_MMS = null;
    private static final DefaultCrossProfileIntentFilter CLONE_TO_PARENT_VIEW_ACTION = null;
    private static final DefaultCrossProfileIntentFilter CLONE_TO_PARENT_WEB_VIEW_ACTION = null;
    public static final DefaultCrossProfileIntentFilter CTS_VERIFIER_REQUIRE = null;
    public static final DefaultCrossProfileIntentFilter CTS_VERIFIER_REQUIRE_VIEW = null;
    private static final DefaultCrossProfileIntentFilter DIAL_DATA = null;
    private static final DefaultCrossProfileIntentFilter DIAL_DATA_MANAGED_PROFILE = null;
    private static final DefaultCrossProfileIntentFilter DIAL_DATA_PRIVATE_PROFILE = null;
    private static final DefaultCrossProfileIntentFilter DIAL_MIME = null;
    private static final DefaultCrossProfileIntentFilter DIAL_MIME_MANAGED_PROFILE = null;
    private static final DefaultCrossProfileIntentFilter DIAL_MIME_PRIVATE_PROFILE = null;
    private static final DefaultCrossProfileIntentFilter DIAL_RAW = null;
    private static final DefaultCrossProfileIntentFilter DIAL_RAW_MANAGED_PROFILE = null;
    private static final DefaultCrossProfileIntentFilter DIAL_RAW_PRIVATE_PROFILE = null;
    private static final DefaultCrossProfileIntentFilter EMERGENCY_CALL_DATA = null;
    private static final DefaultCrossProfileIntentFilter EMERGENCY_CALL_MIME = null;
    private static final DefaultCrossProfileIntentFilter GET_CONTENT = null;
    static final DefaultCrossProfileIntentFilter HOME = null;
    private static final DefaultCrossProfileIntentFilter MEDIA_CAPTURE = null;
    private static final DefaultCrossProfileIntentFilter MOBILE_NETWORK_SETTINGS = null;
    private static final DefaultCrossProfileIntentFilter OPEN_DOCUMENT = null;
    private static final DefaultCrossProfileIntentFilter PARENT_TO_CLONE_DIAL_DATA = null;
    static final DefaultCrossProfileIntentFilter PARENT_TO_CLONE_NFC_NDEF_DISCOVERED = null;
    static final DefaultCrossProfileIntentFilter PARENT_TO_CLONE_NFC_TAG_DISCOVERED = null;
    static final DefaultCrossProfileIntentFilter PARENT_TO_CLONE_NFC_TECH_DISCOVERED = null;
    private static final DefaultCrossProfileIntentFilter PARENT_TO_CLONE_PICK_INSERT_ACTION = null;
    private static final DefaultCrossProfileIntentFilter PARENT_TO_CLONE_SEND_ACTION = null;
    private static final DefaultCrossProfileIntentFilter PARENT_TO_CLONE_WEB_VIEW_ACTION = null;
    private static final DefaultCrossProfileIntentFilter RECOGNIZE_SPEECH = null;
    private static final DefaultCrossProfileIntentFilter SET_ALARM = null;
    private static final DefaultCrossProfileIntentFilter SMS_MMS = null;
    private static final DefaultCrossProfileIntentFilter SMS_MMS_MANAGED_PROFILE = null;
    private static final DefaultCrossProfileIntentFilter SMS_MMS_PRIVATE_PROFILE = null;
    private static final DefaultCrossProfileIntentFilter USB_DEVICE_ATTACHED = null;

    private DefaultCrossProfileIntentFiltersUtils() {
    }

    static {
        EMERGENCY_CALL_MIME = new DefaultCrossProfileIntentFilter.Builder(0, 2, false).addAction("android.intent.action.CALL_EMERGENCY").addAction("android.intent.action.CALL_PRIVILEGED").addCategory("android.intent.category.DEFAULT").addCategory("android.intent.category.BROWSABLE").addDataType("vnd.android.cursor.item/phone").addDataType("vnd.android.cursor.item/phone_v2").addDataType("vnd.android.cursor.item/person").addDataType("vnd.android.cursor.dir/calls").addDataType("vnd.android.cursor.item/calls").build();
        EMERGENCY_CALL_DATA = new DefaultCrossProfileIntentFilter.Builder(0, 2, false).addAction("android.intent.action.CALL_EMERGENCY").addAction("android.intent.action.CALL_PRIVILEGED").addCategory("android.intent.category.DEFAULT").addCategory("android.intent.category.BROWSABLE").addDataScheme("tel").addDataScheme("sip").addDataScheme("voicemail").build();
        DIAL_MIME = new DefaultCrossProfileIntentFilter.Builder(0, 4, false).addAction("android.intent.action.DIAL").addAction("android.intent.action.VIEW").addCategory("android.intent.category.DEFAULT").addCategory("android.intent.category.BROWSABLE").addDataType("vnd.android.cursor.item/phone").addDataType("vnd.android.cursor.item/phone_v2").addDataType("vnd.android.cursor.item/person").addDataType("vnd.android.cursor.dir/calls").addDataType("vnd.android.cursor.item/calls").build();
        DIAL_MIME_MANAGED_PROFILE = new DefaultCrossProfileIntentFilter.Builder(1, 2, false).addAction("android.intent.action.DIAL").addAction("android.intent.action.VIEW").addCategory("android.intent.category.DEFAULT").addCategory("android.intent.category.BROWSABLE").addDataType("vnd.android.cursor.item/phone").addDataType("vnd.android.cursor.item/phone_v2").addDataType("vnd.android.cursor.item/person").addDataType("vnd.android.cursor.dir/calls").addDataType("vnd.android.cursor.item/calls").build();
        DIAL_DATA = new DefaultCrossProfileIntentFilter.Builder(0, 4, false).addAction("android.intent.action.DIAL").addAction("android.intent.action.VIEW").addCategory("android.intent.category.DEFAULT").addCategory("android.intent.category.BROWSABLE").addDataScheme("tel").addDataScheme("sip").addDataScheme("voicemail").build();
        DIAL_DATA_MANAGED_PROFILE = new DefaultCrossProfileIntentFilter.Builder(1, 2, false).addAction("android.intent.action.DIAL").addAction("android.intent.action.VIEW").addCategory("android.intent.category.DEFAULT").addCategory("android.intent.category.BROWSABLE").addDataScheme("tel").addDataScheme("sip").addDataScheme("voicemail").build();
        DIAL_RAW = new DefaultCrossProfileIntentFilter.Builder(0, 4, false).addAction("android.intent.action.DIAL").addCategory("android.intent.category.DEFAULT").addCategory("android.intent.category.BROWSABLE").build();
        DIAL_RAW_MANAGED_PROFILE = new DefaultCrossProfileIntentFilter.Builder(1, 2, false).addAction("android.intent.action.DIAL").addCategory("android.intent.category.DEFAULT").addCategory("android.intent.category.BROWSABLE").build();
        CALL_BUTTON = new DefaultCrossProfileIntentFilter.Builder(0, 4, false).addAction("android.intent.action.CALL_BUTTON").addCategory("android.intent.category.DEFAULT").build();
        SMS_MMS = new DefaultCrossProfileIntentFilter.Builder(0, 2, false).addAction("android.intent.action.VIEW").addAction("android.intent.action.SENDTO").addCategory("android.intent.category.DEFAULT").addCategory("android.intent.category.BROWSABLE").addDataScheme("sms").addDataScheme("smsto").addDataScheme("mms").addDataScheme("mmsto").build();
        SMS_MMS_MANAGED_PROFILE = new DefaultCrossProfileIntentFilter.Builder(1, 2, false).addAction("android.intent.action.VIEW").addAction("android.intent.action.SENDTO").addCategory("android.intent.category.DEFAULT").addCategory("android.intent.category.BROWSABLE").addDataScheme("sms").addDataScheme("smsto").addDataScheme("mms").addDataScheme("mmsto").build();
        MOBILE_NETWORK_SETTINGS = new DefaultCrossProfileIntentFilter.Builder(0, 2, false).addAction("android.settings.DATA_ROAMING_SETTINGS").addAction("android.settings.NETWORK_OPERATOR_SETTINGS").addCategory("android.intent.category.DEFAULT").build();
        CTS_VERIFIER_REQUIRE_VIEW = new DefaultCrossProfileIntentFilter.Builder(0, 2, false).addAction("android.intent.action.VIEW").addCategory("android.intent.category.BROWSABLE").addCategory("android.intent.category.DEFAULT").addDataScheme("tel").build();
        CTS_VERIFIER_REQUIRE = new DefaultCrossProfileIntentFilter.Builder(0, 2, false).addAction("android.settings.ACCESSIBILITY_SETTINGS").addAction("android.settings.CAPTIONING_SETTINGS").addAction("android.settings.DATE_SETTINGS").addAction("android.settings.DEVICE_INFO_SETTINGS").addAction("android.settings.DISPLAY_SETTINGS").addAction("android.settings.LOCALE_SETTINGS").addAction("android.settings.PRIVACY_SETTINGS").addAction("android.settings.SETTINGS").addAction("android.settings.WIRELESS_SETTINGS").addAction("android.net.vpn.SETTINGS").addAction("android.settings.VPN_SETTINGS").addAction("android.settings.BATTERY_SAVER_SETTINGS").addAction("android.settings.LICENSE").addAction("android.settings.NOTIFICATION_SETTINGS").addAction("android.settings.ZEN_MODE_SETTINGS").addAction("com.android.settings.TTS_SETTINGS").addAction("android.settings.INTERNAL_STORAGE_SETTINGS").addAction("android.settings.APN_SETTINGS").addAction("android.settings.NFC_SETTINGS").addAction("android.nfc.cardemulation.action.ACTION_CHANGE_DEFAULT").addAction("android.settings.NFC_PAYMENT_SETTINGS").addAction("android.settings.MEMORY_CARD_SETTINGS").addAction("android.settings.WIFI_IP_SETTINGS").addAction("android.settings.WIFI_SETTINGS").addAction("android.settings.SOUND_SETTINGS").addAction("android.settings.AIRPLANE_MODE_SETTINGS").addAction("android.settings.ACCESSIBILITY_SETTINGS").addAction("android.settings.CAPTIONING_SETTINGS").addAction("android.settings.DATE_SETTINGS").addAction("android.settings.DEVICE_INFO_SETTINGS").addAction("android.settings.DISPLAY_SETTINGS").addAction("android.settings.LOCALE_SETTINGS").addAction("android.settings.PRIVACY_SETTINGS").addAction("android.settings.SETTINGS").addAction("android.settings.WIRELESS_SETTINGS").addAction("android.net.vpn.SETTINGS").addAction("android.settings.VPN_SETTINGS").addAction("android.settings.BATTERY_SAVER_SETTINGS").addAction("android.settings.LICENSE").addAction("android.settings.NOTIFICATION_SETTINGS").addAction("android.settings.ZEN_MODE_SETTINGS").addAction("com.android.settings.ACCESSIBILITY_COLOR_SPACE_SETTINGS").addAction("com.android.settings.TTS_SETTINGS").addAction("android.settings.INTERNAL_STORAGE_SETTINGS").addAction("android.settings.USER_SETTINGS").addAction("android.settings.APN_SETTINGS").addAction("android.settings.NFC_SETTINGS").addAction("android.nfc.cardemulation.action.ACTION_CHANGE_DEFAULT").addAction("android.settings.NFC_PAYMENT_SETTINGS").addAction("android.settings.MEMORY_CARD_SETTINGS").addAction("android.settings.WIFI_IP_SETTINGS").addAction("android.settings.WIFI_SETTINGS").addAction("android.settings.SOUND_SETTINGS").addAction("android.settings.ACTION_OTHER_SOUND_SETTINGS").addAction("android.settings.DREAM_SETTINGS").addAction("android.settings.AIRPLANE_MODE_SETTINGS").addCategory("android.intent.category.DEFAULT").build();
        HOME = new DefaultCrossProfileIntentFilter.Builder(0, 2, false).addAction("android.intent.action.MAIN").addCategory("android.intent.category.DEFAULT").addCategory("android.intent.category.HOME").build();
        GET_CONTENT = new DefaultCrossProfileIntentFilter.Builder(0, 0, true).addAction("android.intent.action.GET_CONTENT").addCategory("android.intent.category.DEFAULT").addCategory("android.intent.category.OPENABLE").addDataType("*/*").build();
        ACTION_PICK_IMAGES = new DefaultCrossProfileIntentFilter.Builder(0, 0, true).addAction("android.provider.action.PICK_IMAGES").addCategory("android.intent.category.DEFAULT").build();
        ACTION_PICK_IMAGES_WITH_DATA_TYPES = new DefaultCrossProfileIntentFilter.Builder(0, 0, true).addAction("android.provider.action.PICK_IMAGES").addCategory("android.intent.category.DEFAULT").addDataType("image/*").addDataType("video/*").build();
        OPEN_DOCUMENT = new DefaultCrossProfileIntentFilter.Builder(0, 0, true).addAction("android.intent.action.OPEN_DOCUMENT").addCategory("android.intent.category.DEFAULT").addCategory("android.intent.category.OPENABLE").addDataType("*/*").build();
        ACTION_PICK_DATA = new DefaultCrossProfileIntentFilter.Builder(0, 0, true).addAction("android.intent.action.PICK").addCategory("android.intent.category.DEFAULT").addDataType("*/*").build();
        ACTION_PICK_RAW = new DefaultCrossProfileIntentFilter.Builder(0, 0, true).addAction("android.intent.action.PICK").addCategory("android.intent.category.DEFAULT").build();
        RECOGNIZE_SPEECH = new DefaultCrossProfileIntentFilter.Builder(0, 4, false).addAction("android.speech.action.RECOGNIZE_SPEECH").addCategory("android.intent.category.DEFAULT").build();
        MEDIA_CAPTURE = new DefaultCrossProfileIntentFilter.Builder(0, 4, true).addAction("android.media.action.IMAGE_CAPTURE").addAction("android.media.action.IMAGE_CAPTURE_SECURE").addAction("android.provider.action.MOTION_PHOTO_CAPTURE").addAction("android.provider.action.MOTION_PHOTO_CAPTURE_SECURE").addAction("android.media.action.VIDEO_CAPTURE").addAction("android.provider.MediaStore.RECORD_SOUND").addAction("android.media.action.STILL_IMAGE_CAMERA").addAction("android.media.action.STILL_IMAGE_CAMERA_SECURE").addAction("android.media.action.VIDEO_CAMERA").addCategory("android.intent.category.DEFAULT").build();
        SET_ALARM = new DefaultCrossProfileIntentFilter.Builder(0, 0, false).addAction("android.intent.action.SET_ALARM").addAction("android.intent.action.SHOW_ALARMS").addAction("android.intent.action.SET_TIMER").addCategory("android.intent.category.DEFAULT").build();
        ACTION_SEND = new DefaultCrossProfileIntentFilter.Builder(1, 0, true).addAction("android.intent.action.SEND").addAction("android.intent.action.SEND_MULTIPLE").addCategory("android.intent.category.DEFAULT").addDataType("*/*").build();
        USB_DEVICE_ATTACHED = new DefaultCrossProfileIntentFilter.Builder(1, 0, false).addAction("android.hardware.usb.action.USB_DEVICE_ATTACHED").addAction("android.hardware.usb.action.USB_ACCESSORY_ATTACHED").addCategory("android.intent.category.DEFAULT").build();
        CALL_MANAGED_PROFILE = new DefaultCrossProfileIntentFilter.Builder(1, 2, false).addAction("android.intent.action.CALL").addCategory("android.intent.category.DEFAULT").addDataScheme("tel").build();
        CLONE_TO_PARENT_MEDIA_CAPTURE = new DefaultCrossProfileIntentFilter.Builder(0, 24, false).addAction("android.media.action.IMAGE_CAPTURE").addAction("android.media.action.IMAGE_CAPTURE_SECURE").addAction("android.provider.action.MOTION_PHOTO_CAPTURE").addAction("android.provider.action.MOTION_PHOTO_CAPTURE_SECURE").addAction("android.media.action.VIDEO_CAPTURE").addAction("android.provider.MediaStore.RECORD_SOUND").addAction("android.media.action.STILL_IMAGE_CAMERA").addAction("android.media.action.STILL_IMAGE_CAMERA_SECURE").addAction("android.media.action.VIDEO_CAMERA").addCategory("android.intent.category.DEFAULT").build();
        CLONE_TO_PARENT_PHOTOPICKER_SELECTION = new DefaultCrossProfileIntentFilter.Builder(0, 24, false).addAction("android.provider.action.USER_SELECT_IMAGES_FOR_APP").addCategory("android.intent.category.DEFAULT").build();
        CLONE_TO_PARENT_SEND_ACTION = new DefaultCrossProfileIntentFilter.Builder(0, 24, false).addAction("android.intent.action.SEND").addAction("android.intent.action.SEND_MULTIPLE").addAction("android.intent.action.SENDTO").addDataType("*/*").build();
        PARENT_TO_CLONE_SEND_ACTION = new DefaultCrossProfileIntentFilter.Builder(1, 24, false).addAction("android.intent.action.SEND").addAction("android.intent.action.SEND_MULTIPLE").addAction("android.intent.action.SENDTO").addDataType("*/*").build();
        CLONE_TO_PARENT_WEB_VIEW_ACTION = new DefaultCrossProfileIntentFilter.Builder(0, 24, false).addAction("android.intent.action.VIEW").addDataScheme("https").addDataScheme("http").build();
        PARENT_TO_CLONE_WEB_VIEW_ACTION = new DefaultCrossProfileIntentFilter.Builder(1, 24, false).addAction("android.intent.action.VIEW").addDataScheme("https").addDataScheme("http").build();
        CLONE_TO_PARENT_VIEW_ACTION = new DefaultCrossProfileIntentFilter.Builder(0, 24, false).addAction("android.intent.action.VIEW").addDataType("*/*").build();
        CLONE_TO_PARENT_PICK_INSERT_ACTION = new DefaultCrossProfileIntentFilter.Builder(0, 24, false).addAction("android.intent.action.PICK").addAction("android.intent.action.GET_CONTENT").addAction("android.intent.action.EDIT").addAction("android.intent.action.INSERT").addAction("android.intent.action.INSERT_OR_EDIT").addAction("android.intent.action.OPEN_DOCUMENT").addDataType("*/*").addCategory("android.intent.category.DEFAULT").addCategory("android.intent.category.OPENABLE").build();
        PARENT_TO_CLONE_PICK_INSERT_ACTION = new DefaultCrossProfileIntentFilter.Builder(1, 24, false).addAction("android.intent.action.PICK").addAction("android.intent.action.GET_CONTENT").addAction("android.intent.action.EDIT").addAction("android.intent.action.INSERT").addAction("android.intent.action.INSERT_OR_EDIT").addAction("android.intent.action.OPEN_DOCUMENT").addDataType("*/*").addCategory("android.intent.category.DEFAULT").addCategory("android.intent.category.OPENABLE").build();
        PARENT_TO_CLONE_DIAL_DATA = new DefaultCrossProfileIntentFilter.Builder(1, 24, false).addAction("android.intent.action.DIAL").addAction("android.intent.action.VIEW").addCategory("android.intent.category.DEFAULT").addCategory("android.intent.category.BROWSABLE").addDataScheme("tel").addDataScheme("sip").addDataScheme("voicemail").build();
        CLONE_TO_PARENT_DIAL_DATA = new DefaultCrossProfileIntentFilter.Builder(0, 24, false).addAction("android.intent.action.DIAL").addAction("android.intent.action.VIEW").addCategory("android.intent.category.DEFAULT").addCategory("android.intent.category.BROWSABLE").addDataScheme("tel").addDataScheme("sip").addDataScheme("voicemail").build();
        CLONE_TO_PARENT_SMS_MMS = new DefaultCrossProfileIntentFilter.Builder(0, 24, false).addAction("android.intent.action.VIEW").addAction("android.intent.action.SENDTO").addCategory("android.intent.category.DEFAULT").addCategory("android.intent.category.BROWSABLE").addDataScheme("sms").addDataScheme("smsto").addDataScheme("mms").addDataScheme("mmsto").build();
        CLONE_TO_PARENT_ACTION_PICK_IMAGES = new DefaultCrossProfileIntentFilter.Builder(0, 24, false).addAction("android.provider.action.PICK_IMAGES").addCategory("android.intent.category.DEFAULT").build();
        CLONE_TO_PARENT_ACTION_PICK_IMAGES_WITH_DATA_TYPES = new DefaultCrossProfileIntentFilter.Builder(0, 24, false).addAction("android.provider.action.PICK_IMAGES").addCategory("android.intent.category.DEFAULT").addDataType("image/*").addDataType("video/*").build();
        PARENT_TO_CLONE_NFC_TAG_DISCOVERED = new DefaultCrossProfileIntentFilter.Builder(1, 0, false).addAction("android.nfc.action.TAG_DISCOVERED").build();
        PARENT_TO_CLONE_NFC_TECH_DISCOVERED = new DefaultCrossProfileIntentFilter.Builder(1, 0, false).addAction("android.nfc.action.TECH_DISCOVERED").build();
        PARENT_TO_CLONE_NFC_NDEF_DISCOVERED = new DefaultCrossProfileIntentFilter.Builder(1, 0, false).addAction("android.nfc.action.NDEF_DISCOVERED").build();
        CALL_PRIVATE_PROFILE = new DefaultCrossProfileIntentFilter.Builder(0, 2, false).addAction("android.intent.action.CALL").addCategory("android.intent.category.DEFAULT").addDataScheme("tel").addDataScheme("sip").addDataScheme("voicemail").build();
        CALL_BUTTON_PRIVATE_PROFILE = new DefaultCrossProfileIntentFilter.Builder(0, 4, false).addAction("android.intent.action.CALL_BUTTON").addCategory("android.intent.category.DEFAULT").build();
        DIAL_MIME_PRIVATE_PROFILE = new DefaultCrossProfileIntentFilter.Builder(0, 4, false).addAction("android.intent.action.DIAL").addAction("android.intent.action.VIEW").addCategory("android.intent.category.DEFAULT").addCategory("android.intent.category.BROWSABLE").addDataType("vnd.android.cursor.item/phone").addDataType("vnd.android.cursor.item/phone_v2").addDataType("vnd.android.cursor.item/person").addDataType("vnd.android.cursor.dir/calls").addDataType("vnd.android.cursor.item/calls").build();
        DIAL_DATA_PRIVATE_PROFILE = new DefaultCrossProfileIntentFilter.Builder(0, 4, false).addAction("android.intent.action.DIAL").addAction("android.intent.action.VIEW").addCategory("android.intent.category.DEFAULT").addCategory("android.intent.category.BROWSABLE").addDataScheme("tel").addDataScheme("sip").addDataScheme("voicemail").build();
        DIAL_RAW_PRIVATE_PROFILE = new DefaultCrossProfileIntentFilter.Builder(0, 4, false).addAction("android.intent.action.DIAL").addCategory("android.intent.category.DEFAULT").addCategory("android.intent.category.BROWSABLE").build();
        SMS_MMS_PRIVATE_PROFILE = new DefaultCrossProfileIntentFilter.Builder(0, 2, false).addAction("android.intent.action.VIEW").addAction("android.intent.action.SENDTO").addCategory("android.intent.category.DEFAULT").addCategory("android.intent.category.BROWSABLE").addDataScheme("sms").addDataScheme("smsto").addDataScheme("mms").addDataScheme("mmsto").build();
    }

    public static List<DefaultCrossProfileIntentFilter> getDefaultManagedProfileFilters() {
        List<DefaultCrossProfileIntentFilter> filters = new ArrayList();
        filters.addAll(Arrays.asList(new DefaultCrossProfileIntentFilter[]{EMERGENCY_CALL_MIME, EMERGENCY_CALL_DATA, CALL_BUTTON, SET_ALARM, MEDIA_CAPTURE, RECOGNIZE_SPEECH, ACTION_PICK_RAW, ACTION_PICK_DATA, ACTION_PICK_IMAGES, ACTION_PICK_IMAGES_WITH_DATA_TYPES, OPEN_DOCUMENT, GET_CONTENT, USB_DEVICE_ATTACHED, ACTION_SEND, HOME, MOBILE_NETWORK_SETTINGS}));
        filters.addAll(getDefaultCrossProfileTelephonyIntentFilters(false));
        return filters;
    }

    public static List<DefaultCrossProfileIntentFilter> getDefaultCrossProfileTelephonyIntentFilters(boolean telephonyOnlyInManagedProfile) {
        if (telephonyOnlyInManagedProfile == false) goto L6;
        return Arrays.asList(new DefaultCrossProfileIntentFilter[]{DIAL_DATA_MANAGED_PROFILE, DIAL_MIME_MANAGED_PROFILE, DIAL_RAW_MANAGED_PROFILE, CALL_MANAGED_PROFILE, SMS_MMS_MANAGED_PROFILE});
    L6:
        return Arrays.asList(new DefaultCrossProfileIntentFilter[]{DIAL_DATA, DIAL_MIME, DIAL_RAW, SMS_MMS});
    }

    public static List<DefaultCrossProfileIntentFilter> getDefaultCloneProfileFilters() {
        return Arrays.asList(new DefaultCrossProfileIntentFilter[]{PARENT_TO_CLONE_SEND_ACTION, PARENT_TO_CLONE_WEB_VIEW_ACTION, PARENT_TO_CLONE_PICK_INSERT_ACTION, PARENT_TO_CLONE_DIAL_DATA, CLONE_TO_PARENT_MEDIA_CAPTURE, CLONE_TO_PARENT_SEND_ACTION, CLONE_TO_PARENT_WEB_VIEW_ACTION, CLONE_TO_PARENT_VIEW_ACTION, CLONE_TO_PARENT_PICK_INSERT_ACTION, CLONE_TO_PARENT_DIAL_DATA, CLONE_TO_PARENT_SMS_MMS, CLONE_TO_PARENT_PHOTOPICKER_SELECTION, CLONE_TO_PARENT_ACTION_PICK_IMAGES, CLONE_TO_PARENT_ACTION_PICK_IMAGES_WITH_DATA_TYPES, PARENT_TO_CLONE_NFC_TAG_DISCOVERED, PARENT_TO_CLONE_NFC_TECH_DISCOVERED, PARENT_TO_CLONE_NFC_NDEF_DISCOVERED});
    }

    public static List<DefaultCrossProfileIntentFilter> getDefaultPrivateProfileFilters() {
        return Arrays.asList(new DefaultCrossProfileIntentFilter[]{DIAL_MIME_PRIVATE_PROFILE, DIAL_DATA_PRIVATE_PROFILE, DIAL_RAW_PRIVATE_PROFILE, CALL_PRIVATE_PROFILE, CALL_BUTTON_PRIVATE_PROFILE, EMERGENCY_CALL_DATA, EMERGENCY_CALL_MIME, SMS_MMS_PRIVATE_PROFILE});
    }
}
