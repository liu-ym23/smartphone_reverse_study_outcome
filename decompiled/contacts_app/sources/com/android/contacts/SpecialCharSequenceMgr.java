package com.android.contacts;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.AsyncQueryHandler;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.os.Looper;
import android.os.Message;
import android.os.ServiceManager;
import android.os.SystemProperties;
import android.provider.Settings;
import android.telephony.PhoneNumberUtils;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.core.os.EnvironmentCompat;
import bytedanceos.util.MultiSimAdapter;
import com.GlobalProxyLancet;
import com.android.contacts.util.Constants;
import com.android.contacts.util.OreoApiUtils;
import com.android.contacts.widget.ProgressDialog;
import com.android.internal.telephony.ITelephony;
import com.obric.matrix.platform.sdk.ones.producttype.ProductTypeUtils;
import com.obric.oui.dialog.alert.OAlertDialog;
import com.obric.oui.dialog.alert.OAlertDialogBuilder;
import com.obric.thread.ThreadPoolManager;
import com.ttnet.org.chromium.base.BaseSwitches;
import obric.api.TelephonySmt;

/* JADX INFO: loaded from: classes.dex */
public class SpecialCharSequenceMgr {
    private static final String ADN_NAME_COLUMN_NAME = "name";
    private static final String ADN_PHONE_NUMBER_COLUMN_NAME = "number";
    private static final int ADN_QUERY_TOKEN = -1;
    private static final boolean CHINA_TELECOM_TEST = false;
    private static final boolean CMCC_TEST = false;
    private static final String HW_DETAIL_INFO_DISPLAY = "*#778099#";
    private static final String MMI_IMEI_DISPLAY = "*#06#";
    private static final String MMI_REGULATORY_INFO_DISPLAY = "*#07#";
    private static final String PRODUCT_NAME = null;
    private static final boolean SHOW_IMEI_MEID_BOTH = false;
    private static final String SW_HW_DISPLAY = "*#1234#";
    private static final String TAG = "SpecialCharSequenceMgr";
    private static final String TELECOM_VERSION_DISPLAY = "*#0000#";
    private static QueryHandler sPreviousAdnQueryHandler;

    /* JADX INFO: renamed from: com.android.contacts.SpecialCharSequenceMgr$1, reason: invalid class name */
    class AnonymousClass1 implements Runnable {
        final /* synthetic */ Context val$context;
        final /* synthetic */ boolean[] val$handled;
        final /* synthetic */ String val$input;
        final /* synthetic */ TelephonyManager val$telephonyManager;
        final /* synthetic */ EditText val$textField;

        AnonymousClass1(TelephonyManager r1, Context r2, String r3, boolean[] r4, EditText r5) {
            this.val$telephonyManager = r1;
            this.val$context = r2;
            this.val$input = r3;
            this.val$handled = r4;
            this.val$textField = r5;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.val$telephonyManager.getCurrentPhoneType() == 1) goto L5;
            return;
        L5:
            ((Activity) this.val$context).runOnUiThread(new RunnableC00091(this));
        }
    }

    private static class QueryHandler extends AsyncQueryHandler {
        private static final int DELAY_TIME = 500;
        private final int EVENT_DISMISS_DIALOG;
        private boolean mCanceled;

        @Override // android.content.AsyncQueryHandler, android.os.Handler
        public void handleMessage(Message r3) {
            if (r3.what != 1) goto L6;
            ((SimContactQueryCookie) r3.obj).progressDialog.dismiss();
            return;
        L6:
            super.handleMessage(r3);
        }

        public QueryHandler(ContentResolver r1) {
            super(r1);
            this.EVENT_DISMISS_DIALOG = 1;
        }

        @Override // android.content.AsyncQueryHandler
        protected void onQueryComplete(int r4, Object r5, Cursor r6) {
            SpecialCharSequenceMgr.access$002(null);
            if (this.mCanceled == false) goto L5;
            return;
        L5:
            SimContactQueryCookie r7 = (SimContactQueryCookie) r5;
            EditText r8 = r7.getTextField();
            if (r6 == null) goto L17;
            if (r8 == null) goto L17;
            if (r6.moveToPosition(r7.contactNum) == false) goto L17;
            r7.progressDialog.dismiss();
            String r3 = r6.getString(r6.getColumnIndexOrThrow("name"));
            String r9 = r6.getString(r6.getColumnIndexOrThrow("number"));
            Context r10 = r7.progressDialog.getContext();
            if (TextUtils.isEmpty(r9) == false) goto L13;
            Toast.makeText(r10, r10.getString(R.string.toast_no_number), 0).show();
            return;
        L13:
            r8.getText().replace(0, 0, r9);
            Object[] r11 = new Object[1];
            if (TextUtils.isEmpty(r3) == false) goto L16;
            r3 = r9;
        L16:
            r11[0] = r3;
            Toast.makeText(r10, r10.getString(R.string.common_call_value, r11), 0).show();
            return;
        L17:
            Context r12 = r7.progressDialog.getContext();
            if (r6 != null) goto L20;
        L22:
            Toast.makeText(r12, r12.getString(R.string.simContacts_query_count_0), 0).show();
        L23:
            Message r13 = new Message();
            r13.what = 1;
            r13.obj = r7;
            sendMessageDelayed(r13, 500);
            return;
        L20:
            if (r6.getCount() != 0) goto L22;
            Toast.makeText(r12, r12.getString(R.string.simContacts_empty), 0).show();
            goto L23
        }

        public void cancel() {
            this.mCanceled = true;
            cancelOperation(-1);
        }
    }

    private static class SimContactQueryCookie implements DialogInterface.OnCancelListener {
        public int contactNum;
        private QueryHandler mHandler;
        private int mToken;
        public ProgressDialog progressDialog;
        private EditText textField;

        public SimContactQueryCookie(int r1, QueryHandler r2, int r3) {
            this.contactNum = r1;
            this.mHandler = r2;
            this.mToken = r3;
        }

        public synchronized EditText getTextField() {
            monitor-enter(this);
            EditText r0 = this.textField;     // Catch: Throwable -> L6
            monitor-exit(this);
            return r0;
        L6:
            th = move-exception;
            throw th;
        }

        public synchronized void setTextField(EditText r1) {
            monitor-enter(this);
            this.textField = r1;     // Catch: Throwable -> L6
            monitor-exit(this);
            return;
        L6:
            th = move-exception;
            throw th;
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public synchronized void onCancel(DialogInterface r2) {
            monitor-enter(this);
            ProgressDialog r3 = this.progressDialog;     // Catch: Throwable -> L9
            if (r3 == null) goto L6;
            r3.dismiss();     // Catch: Throwable -> L9
        L6:
            this.textField = null;     // Catch: Throwable -> L9
            this.mHandler.cancelOperation(this.mToken);     // Catch: Throwable -> L9
            monitor-exit(this);
            return;
        L9:
            th = move-exception;
            throw th;
        }
    }

    static /* synthetic */ QueryHandler access$000() {
        return sPreviousAdnQueryHandler;
    }

    static /* synthetic */ QueryHandler access$002(QueryHandler r0) {
        sPreviousAdnQueryHandler = r0;
        return r0;
    }

    static /* synthetic */ void access$100(Context r0, boolean r1, TelephonyManager r2) {
        showIMEIPanel(r0, r1, r2);
    }

    static /* synthetic */ void access$200(Context r0, boolean r1, TelephonyManager r2) {
        showMEIDPanel(r0, r1, r2);
    }

    static {
        CHINA_TELECOM_TEST = ContactsUtils.FEATURE_CT;
        CMCC_TEST = ContactsUtils.FEATURE_CMCC;
        PRODUCT_NAME = SystemProperties.get("ro.product.name", EnvironmentCompat.MEDIA_UNKNOWN);
        SHOW_IMEI_MEID_BOTH = DSUtils.isMultiSimEnabled();
    }

    private SpecialCharSequenceMgr() {
    }

    public static boolean handleChars(Context r1, String r2, EditText r3) {
        return handleChars(r1, r2, false, r3);
    }

    static boolean handleChars(Context r2, String r3) {
        return handleChars(r2, r3, false, null);
    }

    static boolean handleChars(Context r0, String r1, boolean r2, EditText r3) {
        String r4 = PhoneNumberUtils.stripSeparators(r1);
        if (handleIMEIDisplay(r0, r4, r2) == false) goto L5;
        return true;
    L5:
        if (handlePinEntry(r0, r4) == false) goto L7;
        return true;
    L7:
        if (handleAdnEntry(r0, r4, r3) == false) goto L9;
        return true;
    L9:
        if (handlePikeSecretCode(r0, r4) == false) goto L11;
        return true;
    L11:
        if (handleSecretCode(r0, r4) == false) goto L13;
        return true;
    L13:
        if (handleSelfSecretCode(r0, r4) == true) goto L23;
        return false;
    L23:
        return true;
    }

    static boolean handlePikeSecretCode(Context r1, String r2) {
        if (ProductTypeUtils.INSTANCE.isPike() == true) goto L5;
        return false;
    L5:
        if (MMI_REGULATORY_INFO_DISPLAY.equals(r2) == false) goto L10;
        r1.startActivity(new Intent("android.settings.SHOW_REGULATORY_INFO"));
        return true;
    L10:
        return false;
    }

    static boolean handleSelfSecretCode(Context r2, String r3) {
        if ("**815##".equals(r3) == false) goto L7;
        ContactsUtils.USER_LOG_ON = true;
        ContactsApplication.showToast("User log has been ON", 0);
        return true;
    L7:
        if ("**815815##".equals(r3) == false) goto L10;
        ContactsUtils.USER_LOG_ON = false;
        ContactsApplication.showToast("User log has been OFF", 0);
        return true;
    L10:
        return false;
    }

    public static void cleanup() {
        if (Looper.myLooper() == Looper.getMainLooper()) goto L6;
        Log.wtf(TAG, "cleanup() is called outside the main thread");
        return;
    L6:
        QueryHandler r0 = sPreviousAdnQueryHandler;
        if (r0 == null) goto L10;
        r0.cancel();
        sPreviousAdnQueryHandler = null;
        return;
    }

    static boolean handleSecretCode(Context r2, String r3) {
        int r0 = r3.length();
        if (r0 > 8) goto L5;
        return false;
    L5:
        if (r3.startsWith("*#*#") == true) goto L7;
        return false;
    L7:
        if (r3.endsWith("#*#*") == false) goto L13;
        OreoApiUtils.sendDialerSpecialCode(r2, r3.substring(4, r0 - 4));
        return true;
    L13:
        return false;
    }

    static boolean handleAdnEntry(Context r9, String r10, EditText r11) {
        TelephonyManager r2 = (TelephonyManager) r9.getSystemService("phone");
        if (r2 != null) goto L5;
        return false;
    L5:
        ThreadPoolManager.INSTANCE.getSingleThreadExecutor().execute(new AnonymousClass1(r2, r9, r10, new boolean[]{false}, r11));
        return false;
    }

    static boolean handlePinEntry(Context r1, String r2) {
        if (r2.startsWith("**04") == true) goto L7;
        if (r2.startsWith("**05") == true) goto L7;
    L11:
        return false;
    L7:
        if (r2.endsWith(ContactsUtils.CHAR_POUND) == false) goto L11;
        return ITelephony.Stub.asInterface(ServiceManager.getService("phone")).handlePinMmi(r2);
    L10:
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_e(TAG, "Failed to handlePinMmi due to remote exception");
        goto L11
    }

    static boolean handleIMEIDisplay(final Context r4, String r5, final boolean r6) {
        final TelephonyManager r0 = (TelephonyManager) r4.getSystemService("phone");
        if (r0 != null) goto L5;
    L31:
        return false;
    L5:
        if (r5.equals(MMI_IMEI_DISPLAY) == false) goto L13;
        if (SHOW_IMEI_MEID_BOTH == false) goto L10;
        showIMEIAndMEIDPanel(r4, r6, r0);
        return true;
    L10:
        ThreadPoolManager.INSTANCE.getSingleThreadExecutor().execute(new AnonymousClass2(r0, r4, r6));
        return true;
    L13:
        if (r5.equals(SW_HW_DISPLAY) == false) goto L17;
        showSWHWPanel(r4, r0);
        return true;
    L17:
        if (r5.equals(HW_DETAIL_INFO_DISPLAY) == false) goto L21;
        showHWDetailPanel(r4);
        return true;
    L21:
        if (r5.equals(TELECOM_VERSION_DISPLAY) == false) goto L31;
        if (CHINA_TELECOM_TEST == true) goto L32;
        showSWHWPanel(r4, r0);
        return true;
    L32:
        Intent r7 = new Intent();     // Catch: Exception -> L26
        r7.setComponent(new ComponentName(TelephonySmt.DEFAULT_NOTIFICATION_PACKAGE_NAME, "com.android.phone.TelecomVersionInfo"));     // Catch: Exception -> L26
        r4.startActivity(r7);     // Catch: Exception -> L26
        return true;
    L26:
        e = move-exception;
        e.printStackTrace();
        return false;
    }

    private static void showIMEIPanel(Context r4, boolean r5, TelephonyManager r6) {
        if (DSUtils.isMultiSimEnabled() == false) goto L8;
        String r7 = MultiSimAdapter.getDeviceId(0);
        String r8 = MultiSimAdapter.getDeviceId(1);
        if (TextUtils.isEmpty(r8) == false) goto L7;
        r8 = r7;
    L7:
        String r0 = normalize(r7, true, 1) + "\n" + normalize(r8, true, 2);
        String r9 = r7 + "\n" + r8;
    L9:
        String r10 = ReflectUtils.getSn();
        showDialogWithCopy(r4, r0 + "\nSN: " + r10, r4.getString(R.string.meid), r9 + "\n" + r10);
        return;
    L8:
        r0 = normalize(r6.getDeviceId(), true, 0);
        r9 = r6.getDeviceId();
        goto L9
    }

    private static void showIMEIAndMEIDPanel(Context r7, boolean r8, TelephonyManager r9) {
        String r3 = null;
        if (DSUtils.isMultiSimEnabled() == false) goto L8;
        String r10 = getImei(r9, 0);
        String r4 = getImei(r9, 1);
        if (TextUtils.isEmpty(r4) == false) goto L7;
        r4 = r10;
    L7:
        String r1 = normalize(r10, true, 1) + "\n" + normalize(r4, true, 2);
        String r5 = r10 + "\n" + r4;
    L10:
        if (Constants.ANDROID80 == false) goto L12;
        r3 = ReflectUtils.getMeid(r9, 0);
    L17:
        if (TextUtils.isEmpty(r3) == false) goto L19;
    L22:
        String r11 = ReflectUtils.getSn();
        showDialogWithCopy(r7, r1 + "\nSN: " + r11, r7.getString(R.string.meid), r5 + "\n" + r11);
        return;
    L19:
        if (allZero(r3) == true) goto L22;
        r1 = r1 + "\n" + normalize(r3, false, 0);
        r5 = r5 + "\n" + r3;
        goto L22
    L12:
        if (r10 == null) goto L17;
        if (r10.length() < 14) goto L17;
        r3 = r10.substring(0, 14);
        goto L17
    L8:
        r1 = normalize(ReflectUtils.getImei(r9), true, 0);
        r5 = ReflectUtils.getImei(r9);
        r10 = null;
        goto L10
    }

    private static void showDialogWithCopy(final Context r2, String r3, String r4, final String r5) {
        OAlertDialog r6 = new OAlertDialogBuilder(r2).autoDismiss(false).title(r4, false).message(r3).negativeButton(R.string.common_cancel, new AnonymousClass4()).positiveButton(R.string.copy, new AnonymousClass3(r2, r5)).build();
        TextView r7 = r6.getMessageView();
        if (r7 != null) goto L5;
    L7:
        r6.setCancelable(true);
        r6.setOnCancelListener(new AnonymousClass5());
        r6.show();
        return;
    L5:
        if (r7.getLayoutParams() == null) goto L7;
        r7.getLayoutParams().width = -2;
        r7.setGravity(17);
        goto L7
    }

    private static boolean allZero(String r5) {
        char[] r6 = r5.toCharArray();
        int r0 = r6.length;
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L8;
        if (r6[r2] != '0') goto L6;
        r2 = r2 + 1;
        goto L3
    L6:
        return false;
    L8:
        return true;
    }

    private static String getImei(TelephonyManager r1, int r2) {
        if (isValidSlotId(r1, r2) == false) goto L12;
        return ReflectUtils.getImei(r1, r2);
    L6:
        e = move-exception;
        e.printStackTrace();
        return null;
    L12:
        return null;
    }

    private static boolean isValidSlotId(TelephonyManager r0, int r1) {
        int r2 = DSUtils.getPhoneCount();
        if (r1 < 0) goto L6;
        if (r1 >= r2) goto L6;
        return true;
    L6:
        return false;
    }

    private static String normalize(String r1, boolean r2, int r3) {
        if (SHOW_IMEI_MEID_BOTH == false) goto L12;
        if (r2 == false) goto L11;
        if (r3 > 0) goto L9;
        return "IMEI: " + r1;
    L9:
        return "IMEI" + r3 + ": " + r1;
    L11:
        return "MEID:  " + r1;
    L12:
        return r1;
    }

    private static void showMEIDPanel(Context r5, boolean r6, TelephonyManager r7) {
        if (DSUtils.isMultiSimEnabled() == true) goto L5;
    L10:
        String r1 = normalize(r7.getDeviceId(), true, 0);
        String r8 = r7.getDeviceId();
    L11:
        String r9 = ReflectUtils.getSn();
        showDialogWithCopy(r5, r1 + "\nSN: " + r9, r5.getString(R.string.meid), r8 + "\n" + r9);
        return;
    L5:
        if (ContactsUtils.FEATURE_CMCC == true) goto L10;
        String r10 = MultiSimAdapter.getDeviceId(0);
        String r11 = MultiSimAdapter.getDeviceId(1);
        if (TextUtils.isEmpty(r11) == false) goto L9;
        r11 = r10;
    L9:
        r1 = normalize(r10, true, 0) + "\n" + normalize(r11, true, 0);
        r8 = r10 + "\n" + r11;
        goto L11
    }

    private static String appendSumToIMEI14(String r6) {
        char[] r0 = r6.toCharArray();
        int r1 = 0;
        int r2 = 0;
    L23:
        if (r1 >= r0.length) goto L17;
        if ((r1 % 2) == 0) goto L13;
        int r4 = Integer.valueOf(String.valueOf(r0[r1])).intValue() * 2;     // Catch: Exception -> L15
        if (r4 < 10) goto L11;
        r2 = r2 + ((r4 / 10) + (r4 % 10));     // Catch: Exception -> L15
    L14:
        r1 = r1 + 1;
        goto L23
    L11:
        r2 = r2 + r4;     // Catch: Exception -> L15
        goto L14
    L13:
        r2 = r2 + Integer.valueOf(String.valueOf(r0[r1])).intValue();
    L17:
        int r3 = r2 % 10;
        if (r3 == 0) goto L22;
        r3 = 10 - r3;
    L22:
        return r6 + r3;
    L15:
        e = move-exception;
        System.out.print("parser error " + e.getMessage());
        goto L17
    }

    private static void showSWHWPanel(Context r6, TelephonyManager r7) {
        View r8 = LayoutInflater.from(r6).inflate(R.layout.sw_hw_dialog_layout, null);
        TextView r0 = (TextView) r8.findViewById(R.id.hw_content_txt);
        TextView r2 = (TextView) r8.findViewById(R.id.sw_content_txt);
        String r3 = PRODUCT_NAME;
        if (TextUtils.equals(r3, "odin") == false) goto L5;
    L21:
        String r4 = SystemProperties.get("ro.product.model", "OD101");
        if (TextUtils.equals(r4, "OD101") == false) goto L25;
        r0.setText("MMR500030");
    L30:
        new AlertDialog.Builder(r6, 5).setTitle(R.string.sw_hw_title).setView(r8).setPositiveButton(android.R.string.ok, null).setCancelable(false).show();
        return;
    L25:
        if (TextUtils.equals(r4, "OD103") == false) goto L28;
        r0.setText("MMR500030");
        goto L30
    L28:
        if (TextUtils.equals(r4, "OD105") == false) goto L30;
        r0.setText("MMR500032");
        goto L30
    L5:
        if (TextUtils.equals(r3, "odin_cmcc") == true) goto L21;
        if (TextUtils.equals(r3, "odin_ct") == true) goto L21;
        if (TextUtils.equals(r3, "osborn") == false) goto L12;
    L18:
        r2.setText(getSoftwareVersion());
        r0.setText("MMR500040");
        if (TextUtils.equals(SystemProperties.get("ro.product.model", "OS105"), "OS105") == false) goto L30;
        r0.setText("MMR500040");
        goto L30
    L12:
        if (TextUtils.equals(r3, "osborn_cu") == true) goto L18;
        if (TextUtils.equals(r3, "oscar") == false) goto L17;
        r0.setText("OSC_P1");
        r2.setText(getSoftwareVersion());
        goto L30
    L17:
        r0.setText(getHardwareVersion());
        r2.setText(getSoftwareVersion());
        goto L30
    }

    private static String getSoftwareVersion() {
        String r0 = SystemProperties.get("ro.os.ota.version");
        if (r0 == null) goto L9;
        String[] r1 = r0.split("-");
        if (r1 == null) goto L9;
        if (r1.length <= 0) goto L9;
        StringBuilder r2 = new StringBuilder(BaseSwitches.V).append(r1[0]);
    L10:
        if (r2 != null) goto L12;
        return r0;
    L12:
        return r2.toString();
    L9:
        r2 = null;
        goto L10
    }

    private static String getHardwareVersion() {
        return SystemProperties.get("ro.product.hw.version", "");
    }

    private static void showHWDetailPanel(Context r4) {
        String r1 = Settings.Global.getString(r4.getContentResolver(), "hardware_detail_info");     // Catch: Exception -> L5
    L6:
        if (r1 != null) goto L8;
        return;
    L8:
        new AlertDialog.Builder(r4, 5).setTitle("HWDetail info").setMessage(r1).setPositiveButton(android.R.string.ok, null).setCancelable(false).show();
        return;
    L5:
        r1 = null;
        goto L6
    }
}
