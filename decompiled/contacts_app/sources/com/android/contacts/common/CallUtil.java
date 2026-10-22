package com.android.contacts.common;

import android.app.AlertDialog;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.provider.Settings;
import android.telecom.PhoneAccount;
import android.telecom.PhoneAccountHandle;
import android.telecom.TelecomManager;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import com.android.contacts.common.compat.CompatUtils;
import com.android.contacts.common.util.PermissionsUtil;
import com.android.contacts.common.util.PhoneNumberHelper;
import com.android.contacts.util.Constants;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public class CallUtil {
    private static final int CAPABILITY_EMERGENCY_VIDEO_CALLING = 512;
    public static final String CONFIG_VIDEO_CALLING = "config_video_calling";
    public static final String DIALOG_VIDEO_CALLING = "display_video_call_dialog";
    public static final int DISABLE_VIDEO_CALLING = 2;
    public static final int ENABLE_VIDEO_CALLING = 1;
    private static final int MAX_PHONE_NUM = 7;
    public static final int VIDEO_CALLING_DISABLED = 0;
    public static final int VIDEO_CALLING_ENABLED = 1;
    public static final int VIDEO_CALLING_PRESENCE = 2;
    private static AlertDialog mAlertDialog;

    static {
    }

    public CallUtil() {
    }

    static /* synthetic */ AlertDialog access$000() {
        return mAlertDialog;
    }

    static /* synthetic */ AlertDialog access$002(AlertDialog r0) {
        mAlertDialog = r0;
        return r0;
    }

    public static Intent getCallWithSubjectIntent(String r1, PhoneAccountHandle r2, String r3) {
        Intent r4 = getCallIntent(getCallUri(r1));
        r4.putExtra("android.telecom.extra.CALL_SUBJECT", r3);
        if (r2 == null) goto L5;
        r4.putExtra("android.telecom.extra.PHONE_ACCOUNT_HANDLE", r2);
    L5:
        return r4;
    }

    public static Intent getCallIntent(String r0) {
        return getCallIntent(getCallUri(r0));
    }

    public static Intent getCallIntent(Uri r2) {
        return new Intent("android.intent.action.CALL", r2);
    }

    public static Intent getVideoCallIntent(String r2, String r3) {
        Intent r0 = new Intent("android.intent.action.CALL", getCallUri(r2));
        r0.putExtra(Constants.EXTRA_START_CALL_WITH_VIDEO_STATE, 3);
        if (TextUtils.isEmpty(r3) == true) goto L5;
        r0.putExtra("com.android.phone.CALL_ORIGIN", r3);
    L5:
        return r0;
    }

    public static Uri getCallUri(String r2) {
        if (PhoneNumberHelper.isUriNumber(r2) == false) goto L7;
        return Uri.fromParts(Constants.SCHEME_SIP, r2, null);
    L7:
        return Uri.fromParts(Constants.SCHEME_TEL, r2, null);
    }

    public static Uri getVoicemailUri() {
        return Uri.fromParts("voicemail", "", null);
    }

    public static int getVideoCallingAvailability(Context r4) {
        if (PermissionsUtil.hasPermission(r4, "android.permission.READ_PHONE_STATE") == true) goto L5;
    L26:
        return 0;
    L5:
        if (CompatUtils.isVideoCompatible() == false) goto L26;
        TelecomManager r5 = (TelecomManager) r4.getSystemService("telecom");
        if (r5 != null) goto L10;
        return 0;
    L10:
        Iterator<PhoneAccountHandle> r0 = r5.getCallCapablePhoneAccounts().iterator();
    L12:
        if (r0.hasNext() == false) goto L26;
        PhoneAccount r2 = r5.getPhoneAccount(r0.next());
        if (r2 == null) goto L12;
        if (r2.hasCapabilities(8) == true) goto L20;
        if (r2.hasCapabilities(512) == false) goto L12;
    L20:
        if (CompatUtils.isVideoPresenceCompatible() == true) goto L23;
        return 1;
    L23:
        if (r2.hasCapabilities(256) == false) goto L34;
        return 3;
    L34:
        return 1;
    }

    public static boolean isVideoEnabled(Context r2) {
        boolean r1 = true;
        if ((getVideoCallingAvailability(r2) & 1) != 0) goto L6;
        r1 = false;
    L6:
        saveVideoCallConfig(r2, r1);
        return r1;
    }

    public static boolean saveVideoCallConfig(Context r1, boolean r2) {
        if (Settings.System.canWrite(r1) == false) goto L10;
        ContentResolver r3 = r1.getContentResolver();
        if (r2 == false) goto L7;
        int r4 = 1;
    L9:
        return Settings.System.putInt(r3, CONFIG_VIDEO_CALLING, r4);
    L7:
        r4 = 2;
        goto L9
    L10:
        return false;
    }

    public static boolean isCallWithSubjectSupported(Context r4) {
        if (PermissionsUtil.hasPermission(r4, "android.permission.READ_PHONE_STATE") == true) goto L5;
    L19:
        return false;
    L5:
        if (CompatUtils.isCallSubjectCompatible() == false) goto L19;
        TelecomManager r5 = (TelecomManager) r4.getSystemService("telecom");
        if (r5 != null) goto L10;
        return false;
    L10:
        Iterator<PhoneAccountHandle> r0 = r5.getCallCapablePhoneAccounts().iterator();
    L12:
        if (r0.hasNext() == false) goto L19;
        PhoneAccount r2 = r5.getPhoneAccount(r0.next());
        if (r2 == null) goto L12;
        if (r2.hasCapabilities(64) == false) goto L12;
        return true;
    }

    public static boolean isVideoCallNumValid(String r3) {
        if (r3 != null) goto L6;
        return false;
    L6:
        if (r3.contains(com.android.contacts.ContactsUtils.CHAR_POUND) == false) goto L8;
    L23:
        return false;
    L8:
        if (r3.contains("+") == false) goto L12;
        if (r3.indexOf("+") != 0) goto L23;
    L12:
        if (r3.contains(SimContactsConstants.EMAIL_SEP) == true) goto L23;
        if (r3.contains(";") == true) goto L23;
        if (r3.contains(com.android.contacts.ContactsUtils.CHAR_STAR) == true) goto L23;
        if (PhoneNumberHelper.normalizeNumber(r3).length() >= 7) goto L21;
        return false;
    L21:
        return true;
    }

    public static void createVideoCallingDialog(boolean r4, final Context r5) {
        int r0 = Settings.System.getInt(r5.getContentResolver(), DIALOG_VIDEO_CALLING, 2);
        if (mAlertDialog != null) goto L11;
        if (r0 != 2) goto L12;
        View r1 = LayoutInflater.from(r5).inflate(R.layout.hint_dialog_layout, null);
        CheckBox r2 = (CheckBox) r1.findViewById(R.id.videocall);
        ((Button) r1.findViewById(R.id.btn_ok)).setOnClickListener(new AnonymousClass1());
        TextView r3 = (TextView) r1.findViewById(R.id.txt_message);
        if (r4 == false) goto L8;
        int r6 = R.string.video_call_message_on;
    L9:
        r3.setText(r6);
        r2.setOnCheckedChangeListener(new AnonymousClass2(r5));
        AlertDialog.Builder r7 = new AlertDialog.Builder(r5);
        r7.setView(r1);
        r7.create().setCancelable(false);
        mAlertDialog = r7.show();
        return;
    L8:
        r6 = R.string.video_call_message_off;
        goto L9
    L12:
        return;
    }
}
