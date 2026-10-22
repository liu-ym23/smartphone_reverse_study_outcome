package com.obric.privacy;

import com.android.contacts.common.util.PermissionsUtil;
import java.util.Collections;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PrivacyConstants.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010 \n\u0000\n\u0002\u0010!\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0007\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0006\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u0016\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00010\b8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000\"5\u0010\t\u001a&\u0012\f\u0012\n \u000b*\u0004\u0018\u00010\u00010\u0001 \u000b*\u0012\u0012\f\u0012\n \u000b*\u0004\u0018\u00010\u00010\u0001\u0018\u00010\b0\n¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r\"\u0016\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00010\b8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u000f\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0010\u001a\u00020\u0011X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0012\u001a\u00020\u0011X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0013\u001a\u00020\u0011X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0014\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0015\u001a\u00020\u0011X\u0086T¢\u0006\u0002\n\u0000\"5\u0010\u0016\u001a&\u0012\f\u0012\n \u000b*\u0004\u0018\u00010\u00010\u0001 \u000b*\u0012\u0012\f\u0012\n \u000b*\u0004\u0018\u00010\u00010\u0001\u0018\u00010\b0\n¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\r¨\u0006\u0018"}, d2 = {"ACTION_PERMISSION_APPLY", "", "EXTRA_PRIVACY_SHEET_LOCALE_TAG", "EXTRA_PRIVACY_SHEET_NIGHT_MODE", "KEY_PHOTO_PERM_USERSET", "KEY_RECORD_PERM_USERSET", "KEY_SMS_PERM_USERSET", "PERMS_FOR_PHOTO", "", "PERMS_FOR_RECORD", "", "kotlin.jvm.PlatformType", "getPERMS_FOR_RECORD", "()Ljava/util/List;", "PERMS_FOR_SMS", "PRIVACY_TAG", "REQ_CODE_FOR_PHOTO_PERMS", "", "REQ_CODE_FOR_RECORD_PERMS", "REQ_CODE_FOR_SMS_PERMS", "SP_KEY_PRIVACY_DIALOG_AGREE", "SP_PRIVACY_AGREE", "basePermissionList", "getBasePermissionList", "app_QssiCnRelease"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class PrivacyConstantsKt {
    public static final String ACTION_PERMISSION_APPLY = "com.bytedanceos.contacts.action.PERMISSION_APPLY";
    public static final String EXTRA_PRIVACY_SHEET_LOCALE_TAG = "extra_privacy_sheet_locale_tag";
    public static final String EXTRA_PRIVACY_SHEET_NIGHT_MODE = "extra_privacy_sheet_night_mode";
    public static final String KEY_PHOTO_PERM_USERSET = "key_photo_perm_userset";
    public static final String KEY_RECORD_PERM_USERSET = "key_record_perm_userset";
    public static final String KEY_SMS_PERM_USERSET = "key_sms_perm_userset";
    public static final List<String> PERMS_FOR_PHOTO = null;
    private static final List<String> PERMS_FOR_RECORD = null;
    public static final List<String> PERMS_FOR_SMS = null;
    public static final String PRIVACY_TAG = "PrivacyTag";
    public static final int REQ_CODE_FOR_PHOTO_PERMS = 12;
    public static final int REQ_CODE_FOR_RECORD_PERMS = 13;
    public static final int REQ_CODE_FOR_SMS_PERMS = 11;
    public static final String SP_KEY_PRIVACY_DIALOG_AGREE = "contacts_privacy_dialog_agree";
    public static final int SP_PRIVACY_AGREE = 1;
    private static final List<String> basePermissionList = null;

    public static final List<String> getBasePermissionList() {
        return basePermissionList;
    }

    static {
        basePermissionList = Collections.unmodifiableList(CollectionsKt.listOf(new String[]{PermissionsUtil.PHONE, "android.permission.READ_PHONE_STATE", PermissionsUtil.CONTACTS, "android.permission.WRITE_CONTACTS", "android.permission.READ_CALL_LOG", "android.permission.WRITE_CALL_LOG"}));
        List<String> r0 = Collections.unmodifiableList(CollectionsKt.listOf("android.permission.READ_SMS"));
        Intrinsics.checkNotNullExpressionValue(r0, "unmodifiableList(listOf(…est.permission.READ_SMS))");
        PERMS_FOR_SMS = r0;
        List<String> r1 = Collections.unmodifiableList(CollectionsKt.listOf("android.permission.READ_MEDIA_IMAGES"));
        Intrinsics.checkNotNullExpressionValue(r1, "unmodifiableList(listOf(…ssion.READ_MEDIA_IMAGES))");
        PERMS_FOR_PHOTO = r1;
        PERMS_FOR_RECORD = Collections.unmodifiableList(CollectionsKt.listOf("android.permission.RECORD_AUDIO"));
    }

    public static final List<String> getPERMS_FOR_RECORD() {
        return PERMS_FOR_RECORD;
    }
}
