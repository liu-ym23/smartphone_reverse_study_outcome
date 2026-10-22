package com.bytedance.android.annie.bridge.method.permission;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes43.dex */
public final class PermissionConstants {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String[] f38755a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String[] f38756b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String[] f38757c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String[] f38758d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final String[] f38759e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final String[] f38760f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final String[] f38761g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final String[] f38762h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final String[] f38763i = null;

    @Retention(RetentionPolicy.SOURCE)
    public @interface PermissionGroup {
    }

    static {
        f38755a = new String[]{"android.permission.READ_CALENDAR", "android.permission.WRITE_CALENDAR"};
        f38756b = new String[]{"android.permission.CAMERA"};
        f38757c = new String[]{"android.permission.READ_CONTACTS", "android.permission.WRITE_CONTACTS", "android.permission.GET_ACCOUNTS"};
        f38758d = new String[]{"android.permission.RECORD_AUDIO"};
        f38759e = new String[]{"android.permission.READ_PHONE_STATE", "android.permission.READ_PHONE_NUMBERS", "android.permission.CALL_PHONE", "android.permission.READ_CALL_LOG", "android.permission.WRITE_CALL_LOG", "com.android.voicemail.permission.ADD_VOICEMAIL", "android.permission.USE_SIP", "android.permission.PROCESS_OUTGOING_CALLS", "android.permission.ANSWER_PHONE_CALLS"};
        f38760f = new String[]{"android.permission.READ_PHONE_STATE", "android.permission.READ_PHONE_NUMBERS", "android.permission.CALL_PHONE", "android.permission.READ_CALL_LOG", "android.permission.WRITE_CALL_LOG", "com.android.voicemail.permission.ADD_VOICEMAIL", "android.permission.USE_SIP", "android.permission.PROCESS_OUTGOING_CALLS"};
        f38761g = new String[]{"android.permission.BODY_SENSORS"};
        f38762h = new String[]{"android.permission.SEND_SMS", "android.permission.RECEIVE_SMS", "android.permission.READ_SMS", "android.permission.RECEIVE_WAP_PUSH", "android.permission.RECEIVE_MMS"};
        f38763i = new String[]{"android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE"};
    }
}
