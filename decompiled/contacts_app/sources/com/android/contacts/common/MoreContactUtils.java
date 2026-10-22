package com.android.contacts.common;

import android.accounts.Account;
import android.app.AlertDialog;
import android.content.ComponentName;
import android.content.ContentProviderOperation;
import android.content.ContentProviderResult;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.OperationApplicationException;
import android.database.Cursor;
import android.database.sqlite.SQLiteException;
import android.graphics.Rect;
import android.net.Uri;
import android.os.RemoteException;
import android.provider.ContactsContract;
import android.provider.Settings;
import android.telecom.PhoneAccountHandle;
import android.telephony.PhoneNumberUtils;
import android.telephony.SubscriptionInfo;
import android.telephony.SubscriptionManager;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import com.GlobalProxyLancet;
import com.android.contacts.common.model.account.AccountType;
import com.android.contacts.common.reflection.IIccPhoneBookUtil;
import com.android.contacts.common.reflection.SubscriptionManagerUtil;
import com.android.contacts.common.reflection.SystemPropertiesUtil;
import com.android.contacts.common.reflection.TelephonyManagerUtil;
import com.android.contacts.group.GroupSelectionActivity;
import com.bytedance.framwork.core.sdklib.DBHelper;
import com.google.i18n.phonenumbers.NumberParseException;
import com.google.i18n.phonenumbers.PhoneNumberUtil;
import java.util.ArrayList;
import java.util.List;
import obric.api.TelephonySmt;

/* JADX INFO: loaded from: classes.dex */
public class MoreContactUtils {
    private static final int ADN_COUNT_POS = 0;
    public static final int ADN_USED_POS = 1;
    private static final int ANR_COUNT_POS = 4;
    private static final int ANR_POS = 3;
    private static final int ANR_USED_POS = 5;
    private static final boolean DBG = true;
    private static final int EMAIL_COUNT_POS = 2;
    private static final int EMAIL_POS = 2;
    private static final int EMAIL_USED_POS = 3;
    public static final int[] IC_SIM_PICTURE = null;
    public static final String[] IPCALL_PREFIX = null;
    public static final int MAX_LENGTH_EMAIL_IN_SIM = 40;
    public static final int MAX_LENGTH_NAME_IN_SIM = 14;
    public static final int MAX_LENGTH_NAME_WITH_CHINESE_IN_SIM = 6;
    public static final int MAX_LENGTH_NUMBER_IN_SIM = 40;
    public static final String[] MULTI_SIM_NAME = null;
    private static final int NAME_POS = 0;
    private static final int NUMBER_POS = 1;
    private static final String PHONEBOOK = "simphonebook";
    public static final String PREFERRED_SIM_ICON_INDEX = "preferred_sim_icon_index";
    public static final String SIM1_TYPE = "SIM1";
    public static final String SIM2_TYPE = "SIM2";
    private static final String TAG = "MoreContactUtils";
    private static final String WAIT_SYMBOL_AS_STRING = null;

    /* JADX INFO: renamed from: com.android.contacts.common.MoreContactUtils$3, reason: invalid class name */
    static /* synthetic */ class AnonymousClass3 {
        static final /* synthetic */ int[] $SwitchMap$com$google$i18n$phonenumbers$PhoneNumberUtil$MatchType = null;

        static {
            int[] r0 = new int[PhoneNumberUtil.MatchType.values().length];
            $SwitchMap$com$google$i18n$phonenumbers$PhoneNumberUtil$MatchType = r0;
            r0[PhoneNumberUtil.MatchType.NOT_A_NUMBER.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L14:
            $SwitchMap$com$google$i18n$phonenumbers$PhoneNumberUtil$MatchType[PhoneNumberUtil.MatchType.NO_MATCH.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L18:
            $SwitchMap$com$google$i18n$phonenumbers$PhoneNumberUtil$MatchType[PhoneNumberUtil.MatchType.EXACT_MATCH.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L22:
            $SwitchMap$com$google$i18n$phonenumbers$PhoneNumberUtil$MatchType[PhoneNumberUtil.MatchType.NSN_MATCH.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L16:
            $SwitchMap$com$google$i18n$phonenumbers$PhoneNumberUtil$MatchType[PhoneNumberUtil.MatchType.SHORT_NSN_MATCH.ordinal()] = 5;     // Catch: NoSuchFieldError -> L13
            return;
        }
    }

    public static int getEmailCount(Context r0, int r1) {
        return 0;
    }

    public static int getSpareAnrCount(int r0) {
        return 0;
    }

    public static int getSpareEmailCount(int r0) {
        return 0;
    }

    public MoreContactUtils() {
    }

    static {
        WAIT_SYMBOL_AS_STRING = String.valueOf(';');
        IC_SIM_PICTURE = new int[]{R.drawable.ic_contact_picture_sim_1, R.drawable.ic_contact_picture_sim_2, R.drawable.ic_contact_picture_sim_personal, R.drawable.ic_contact_picture_sim_business, R.drawable.ic_contact_picture_sim_primary};
        MULTI_SIM_NAME = new String[]{"perferred_name_sub1", "perferred_name_sub2"};
        IPCALL_PREFIX = new String[]{"ipcall_prefix1", "ipcall_prefix2"};
    }

    public static boolean shouldCollapse(CharSequence r1, CharSequence r2, CharSequence r3, CharSequence r4) {
        if (TextUtils.equals(r1, r3) == true) goto L6;
        return false;
    L6:
        if (TextUtils.equals(r2, r4) == false) goto L9;
        return true;
    L9:
        if (r2 == null) goto L17;
        if (r4 == null) goto L17;
        if (TextUtils.equals("vnd.android.cursor.item/phone_v2", r1) == true) goto L16;
        return false;
    L16:
        return shouldCollapsePhoneNumbers(r2.toString(), r4.toString());
    L17:
        return false;
    }

    private static boolean shouldCollapsePhoneNumbers(String r8, String r9) {
        if (r8.contains(com.android.contacts.ContactsUtils.CHAR_POUND) == r9.contains(com.android.contacts.ContactsUtils.CHAR_POUND)) goto L5;
    L43:
        return false;
    L5:
        if (r8.contains(com.android.contacts.ContactsUtils.CHAR_STAR) != r9.contains(com.android.contacts.ContactsUtils.CHAR_STAR)) goto L43;
        String r0 = WAIT_SYMBOL_AS_STRING;
        String[] r10 = r8.split(r0);
        String[] r11 = r9.split(r0);
        if (r10.length == r11.length) goto L10;
        return false;
    L10:
        PhoneNumberUtil r1 = PhoneNumberUtil.getInstance();
        int r2 = 0;
    L12:
        if (r2 >= r10.length) goto L42;
        String r3 = PhoneNumberUtils.convertKeypadLettersToDigits(r10[r2]);
        String r5 = r11[r2];
        if (TextUtils.equals(r3, r5) == true) goto L40;
        int r6 = AnonymousClass3.$SwitchMap$com$google$i18n$phonenumbers$PhoneNumberUtil$MatchType[r1.isNumberMatch(r3, r5).ordinal()];
        if (r6 == 1) goto L41;
        if (r6 == 2) goto L41;
        if (r6 == 3) goto L40;
        if (r6 != 4) goto L25;
    L38:
        r1.parse(r5, null);     // Catch: NumberParseException -> L44
    L39:
        return false;
    L31:
        if (r1.parse(r3, null) == null) goto L39;
        if (r1.parse(r3, null).getCountryCode() != 1) goto L39;
        if (r5.trim().charAt(0) != '1') goto L40;
        return false;
    L25:
        if (r6 != 5) goto L28;
        return false;
    L28:
        throw new IllegalStateException("Unknown result value from phone number library");
    L41:
        return false;
    L40:
        r2 = r2 + 1;
        goto L12
    L42:
        return true;
    }

    public static Rect getTargetRectFromView(View r5) {
        int[] r0 = new int[2];
        r5.getLocationOnScreen(r0);
        Rect r1 = new Rect();
        r1.left = r0[0];
        r1.top = r0[1];
        r1.right = r0[0] + r5.getWidth();
        r1.bottom = r0[1] + r5.getHeight();
        return r1;
    }

    public static boolean shouldShowOperator(Context r1) {
        return r1.getResources().getBoolean(R.bool.config_show_operator);
    }

    public static String getNetworkSpnName(Context r4, int r5) {
        TelephonyManager r0 = (TelephonyManager) r4.getSystemService("phone");
        if (r0 == null) goto L15;
        String r1 = r0.getNetworkOperatorName();
        if (TextUtils.isEmpty(r1) == false) goto L17;
        List<SubscriptionInfo> r6 = SubscriptionManager.from(r4).getActiveSubscriptionInfoList();
        if (r6 == null) goto L17;
        int r2 = 0;
    L10:
        if (r2 >= r6.size()) goto L17;
        SubscriptionInfo r3 = r6.get(r2);
        if (r3.getSubscriptionId() == r5) goto L13;
        r2 = r2 + 1;
        goto L10
    L13:
        r1 = (String) r3.getDisplayName();
    L17:
        return toUpperCaseFirstOne(r1);
    L15:
        r1 = "";
        goto L17
    }

    private static String toUpperCaseFirstOne(String r2) {
        if (TextUtils.isEmpty(r2) == false) goto L6;
        return r2;
    L6:
        if (Character.isUpperCase(r2.charAt(0)) == false) goto L9;
        return r2;
    L9:
        return Character.toUpperCase(r2.charAt(0)) + r2.substring(1);
    }

    public static TextView createHeaderView(Context r2, int r3) {
        TextView r0 = (TextView) View.inflate(r2, R.layout.list_separator, null);
        r0.setText(r2.getString(r3));
        return r0;
    }

    public static void setHeaderViewBottomPadding(Context r2, TextView r3, boolean r4) {
        if (r4 == false) goto L4;
        float r5 = r2.getResources().getDimension(R.dimen.frequently_contacted_title_top_margin_when_first_row);
    L5:
        int r6 = r3.getPaddingStart();
        r3.setPaddingRelative(r6, (int) r5, r3.getPaddingEnd(), r3.getPaddingBottom());
        return;
    L4:
        r5 = r2.getResources().getDimension(R.dimen.frequently_contacted_title_top_margin);
        goto L5
    }

    public static Intent getInvitableIntent(AccountType r2, Uri r3) {
        String r0 = r2.syncAdapterPackageName;
        String r4 = r2.getInviteContactActivityClassName();
        if (TextUtils.isEmpty(r0) == false) goto L5;
        return null;
    L5:
        if (TextUtils.isEmpty(r4) == true) goto L11;
        Intent r1 = new Intent();
        r1.setClassName(r0, r4);
        r1.setAction("com.android.contacts.action.INVITE_CONTACT");
        r1.setData(r3);
        return r1;
    L11:
        return null;
    }

    public static String getDisabledSimFilter() {
        int r0 = TelephonyManagerUtil.getDefault().getPhoneCount();
        StringBuilder r1 = new StringBuilder("");
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L9;
        if (TelephonyManagerUtil.getDefault().getSimState(r2) != 0) goto L7;
        r1.append(getSimAccountName(r2) + ',');
    L7:
        r2 = r2 + 1;
        goto L3
    L9:
        return r1.toString();
    }

    public static boolean isAPMOnAndSIMPowerDown(Context r3) {
        if (r3 != null) goto L6;
        return false;
    L6:
        if (Settings.System.getInt(r3.getContentResolver(), "airplane_mode_on", 0) != 1) goto L8;
        boolean r4 = true;
    L10:
        if (SystemPropertiesUtil.getInt("persist.radio.apm_sim_not_pwdn", 0) != 0) goto L12;
        boolean r2 = true;
    L13:
        if (r4 == false) goto L17;
        if (r2 == true) goto L16;
        return false;
    L16:
        return true;
    L17:
        return false;
    L12:
        r2 = false;
        goto L13
    L8:
        r4 = false;
        goto L10
    }

    public static String getSimAccountName(int r2) {
        if (TelephonyManagerUtil.isMultiSimEnabled() == true) goto L5;
        return SimContactsConstants.SIM_NAME;
    L5:
        return SimContactsConstants.SIM_NAME + (r2 + 1);
    }

    public static String getSimAccountName(Context r2, int r3) {
        if (((TelephonyManager) r2.getSystemService("phone")).getPhoneCount() > 1) goto L5;
        return SimContactsConstants.SIM_NAME;
    L5:
        return SimContactsConstants.SIM_NAME + (r3 + 1);
    }

    public static int getSubscription(String r2, String r3) {
        if (r2 == null) goto L18;
        if (r3 != null) goto L7;
        return -1;
    L7:
        if (r2.equals("com.android.sim") == true) goto L9;
        return -1;
    L9:
        if (r3.equals(SimContactsConstants.SIM_NAME) == false) goto L11;
    L16:
        return 0;
    L11:
        if (r3.equals("SIM1") == true) goto L16;
        if (r3.equals("SIM2") == false) goto L20;
        return 1;
    L20:
        return -1;
    L18:
        return -1;
    }

    public static int getAnrCount(int r3) {
        int[] r4 = SubscriptionManagerUtil.getSubId(r3);
        if (r4 != null) goto L14;
    L7:
        Object r5 = IIccPhoneBookUtil.getAdnRecordsCapacity();     // Catch: Exception -> L13
    L8:
        if (r5 == null) goto L12;
        return IIccPhoneBookUtil.readCapacityInt(r5, "getMaxAnrCount") - IIccPhoneBookUtil.readCapacityInt(r5, "getUsedAnrCount");
    L12:
        return 0;
    L14:
        if (TelephonyManagerUtil.isMultiSimEnabled() == false) goto L7;
        r5 = IIccPhoneBookUtil.getAdnRecordsCapacityForSubscriber(r4[0]);     // Catch: Exception -> L13
        goto L8
    }

    public static int getAdnCount(int r3) {
        int[] r4 = SubscriptionManagerUtil.getSubId(r3);
        if (r4 != null) goto L14;
    L7:
        Object r5 = IIccPhoneBookUtil.getAdnRecordsCapacity();     // Catch: Exception -> L13
    L8:
        if (r5 == null) goto L12;
        return IIccPhoneBookUtil.readCapacityInt(r5, "getMaxAdnCount") - IIccPhoneBookUtil.readCapacityInt(r5, "getUsedAdnCount");
    L12:
        return 0;
    L14:
        if (TelephonyManagerUtil.isMultiSimEnabled() == false) goto L7;
        r5 = IIccPhoneBookUtil.getAdnRecordsCapacityForSubscriber(r4[0]);     // Catch: Exception -> L13
        goto L8
    }

    public static int getEmailCount(int r3) {
        int[] r4 = SubscriptionManagerUtil.getSubId(r3);
        if (r4 != null) goto L14;
    L7:
        Object r5 = IIccPhoneBookUtil.getAdnRecordsCapacity();     // Catch: Exception -> L13
    L8:
        if (r5 == null) goto L12;
        return IIccPhoneBookUtil.readCapacityInt(r5, "getMaxEmailCount") - IIccPhoneBookUtil.readCapacityInt(r5, "getUsedEmailCount");
    L12:
        return 0;
    L14:
        if (TelephonyManagerUtil.isMultiSimEnabled() == false) goto L7;
        r5 = IIccPhoneBookUtil.getAdnRecordsCapacityForSubscriber(r4[0]);     // Catch: Exception -> L13
        goto L8
    }

    public static boolean canSaveEmail(int r0) {
        if (getEmailCount(r0) <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    public static boolean canSaveEmail(Context r0, int r1) {
        if (getEmailCount(r0, r1) <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    public static int getOneSimAnrCount(Context r1, int r2) {
        int r3 = getAnrCount(r2);
        int r4 = getAdnCount(r2);
        if (r4 > 0) goto L5;
        return 0;
    L5:
        if ((r3 % r4) == 0) goto L11;
        return (r3 / r4) + 1;
    L11:
        return r3 / r4;
    }

    public static int getOneSimEmailCount(Context r1, int r2) {
        int r3 = getEmailCount(r1, r2);
        int r4 = getAdnCount(r2);
        if (r4 > 0) goto L5;
        return 0;
    L5:
        if ((r3 % r4) == 0) goto L11;
        return (r3 / r4) + 1;
    L11:
        return r3 / r4;
    }

    public static int getOneSimAnrCount(int r2) {
        int r0 = getAnrCount(r2);
        int r3 = getAdnCount(r2);
        if (r3 > 0) goto L5;
        return 0;
    L5:
        if ((r0 % r3) == 0) goto L11;
        return (r0 / r3) + 1;
    L11:
        return r0 / r3;
    }

    public static int getOneSimEmailCount(int r2) {
        int r0 = getEmailCount(r2);
        int r3 = getAdnCount(r2);
        if (r3 > 0) goto L5;
        return 0;
    L5:
        if ((r0 % r3) == 0) goto L11;
        return (r0 / r3) + 1;
    L11:
        return r0 / r3;
    }

    public static Account getAcount(Context r2, int r3) {
        if (((TelephonyManager) r2.getSystemService("phone")).getPhoneCount() <= 1) goto L8;
        if (r3 != 0) goto L6;
        Account r4 = new Account("SIM1", "com.android.sim");
    L11:
        if (r4 == null) goto L13;
        return r4;
    L13:
        return new Account(SimContactsConstants.PHONE_NAME, "com.android.localphone");
    L6:
        if (r3 != 1) goto L10;
        r4 = new Account("SIM2", "com.android.sim");
    L10:
        r4 = null;
        goto L11
    L8:
        if (r3 != 0) goto L10;
        r4 = new Account(SimContactsConstants.SIM_NAME, "com.android.sim");
        goto L11
    }

    public static int getEnabledSimCount() {
        int r0 = TelephonyManagerUtil.getDefault().getPhoneCount();
        int r1 = 0;
        int r2 = 0;
    L3:
        if (r1 >= r0) goto L8;
        if (5 != TelephonyManagerUtil.getDefault().getSimState(r1)) goto L7;
        r2 = r2 + 1;
    L7:
        r1 = r1 + 1;
        goto L3
    L8:
        return r2;
    }

    public static int getSimFreeCount(Context r8, int r9) {
        int r0 = 0;
        if (r8 != null) goto L5;
        return 0;
    L5:
        Cursor r10 = r8.getContentResolver().query(ContactsContract.RawContacts.CONTENT_URI, new String[]{"_id"}, "account_name = '" + getAcount(r8, r9).name + "' AND deleted = 0", null, null);
        if (r10 == null) goto L13;
        r0 = r10.getCount();     // Catch: Throwable -> L9
        r10.close();
    L9:
        th = move-exception;
        r10.close();
        throw th;
    L13:
        return getAdnCount(r9) - r0;
    }

    public static int getActiveSubId(Context r0, int r1) {
        SubscriptionInfo r2 = SubscriptionManager.from(r0).getActiveSubscriptionInfoForSimSlotIndex(r1);     // Catch: Exception -> L4
    L5:
        if (r2 != null) goto L7;
        return -1;
    L7:
        return r2.getSubscriptionId();
    L4:
        r2 = null;
        goto L5
    }

    public static int getActiveSlotId(Context r0, int r1) {
        SubscriptionInfo r2 = SubscriptionManager.from(r0).getActiveSubscriptionInfo(r1);     // Catch: Exception -> L4
    L5:
        if (r2 != null) goto L7;
        return -1;
    L7:
        return r2.getSimSlotIndex();
    L4:
        r2 = null;
        goto L5
    }

    private static boolean hasChinese(String r1) {
        if (r1 != null) goto L4;
    L6:
        return false;
    L4:
        if (r1.getBytes().length <= r1.length()) goto L6;
        return true;
    }

    public static String getMultiSimAliasesName(Context r1, int r2) {
        if (r1 == null) goto L13;
        if (r2 >= 0) goto L6;
        return null;
    L6:
        if (TelephonyManagerUtil.isMultiSimEnabled() == false) goto L8;
        String r3 = Settings.System.getString(r1.getContentResolver(), MULTI_SIM_NAME[r2]);
    L10:
        if (TextUtils.isEmpty(r3) == true) goto L12;
        return r3;
    L12:
        return getSimAccountName(r2);
    L8:
        r3 = "";
        goto L10
    L13:
        return null;
    }

    public static boolean insertToPhone(String[] r17, Context r18, int r19) {
        Account r0 = getAcount(r18, r19);
        String r3 = r17[0];
        String r6 = r17[1];
        String r8 = r17[2];
        String r10 = r17[3];
        String[] r12 = null;
        if (TextUtils.isEmpty(r8) == true) goto L5;
        String[] r11 = r8.split(SimContactsConstants.EMAIL_SEP);
    L7:
        if (TextUtils.isEmpty(r10) == true) goto L9;
        r12 = r10.split(SimContactsConstants.ANR_SEP);
    L9:
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(TAG, "insertToPhone: name= " + r3 + ", phoneNumber= " + r6 + ", emails= " + r8 + ", anrs= " + r10 + ", account= " + r0);
        ArrayList<ContentProviderOperation> r9 = new ArrayList();
        ContentProviderOperation.Builder r13 = ContentProviderOperation.newInsert(ContactsContract.RawContacts.CONTENT_URI);
        r13.withValue("aggregation_mode", 3);
        if (r0 == null) goto L12;
        r13.withValue("account_name", r0.name);
        r13.withValue("account_type", r0.type);
    L12:
        r9.add(r13.build());
        if (TextUtils.isEmpty(r3) == true) goto L16;
        ContentProviderOperation.Builder r1 = ContentProviderOperation.newInsert(ContactsContract.Data.CONTENT_URI);
        r1.withValueBackReference(GroupSelectionActivity.EXTRA_RAW_CONTACT_ID, 0);
        r1.withValue("mimetype", "vnd.android.cursor.item/name");
        r1.withValue("data1", r3);
        r9.add(r1.build());
    L16:
        if (TextUtils.isEmpty(r6) == true) goto L18;
        ContentProviderOperation.Builder r2 = ContentProviderOperation.newInsert(ContactsContract.Data.CONTENT_URI);
        r2.withValueBackReference(GroupSelectionActivity.EXTRA_RAW_CONTACT_ID, 0);
        r2.withValue("mimetype", "vnd.android.cursor.item/phone_v2");
        r2.withValue(DBHelper.COL_DATA2, 2);
        r2.withValue("data1", r6);
        r2.withValue("is_primary", 1);
        r9.add(r2.build());
    L18:
        if (r12 == null) goto L25;
        int r4 = r12.length;
        int r5 = 0;
    L20:
        if (r5 >= r4) goto L25;
        String r7 = r12[r5];
        if (TextUtils.isEmpty(r7) == true) goto L24;
        ContentProviderOperation.Builder r14 = ContentProviderOperation.newInsert(ContactsContract.Data.CONTENT_URI);
        r14.withValueBackReference(GroupSelectionActivity.EXTRA_RAW_CONTACT_ID, 0);
        r14.withValue("mimetype", "vnd.android.cursor.item/phone_v2");
        r14.withValue(DBHelper.COL_DATA2, 1);
        r14.withValue("data1", r7);
        r9.add(r14.build());
    L24:
        r5 = r5 + 1;
    L25:
        if (r11 == null) goto L49;
        int r15 = r11.length;
        int r16 = 0;
    L27:
        if (r16 >= r15) goto L49;
        String r20 = r11[r16];
        if (TextUtils.isEmpty(r20) == true) goto L31;
        ContentProviderOperation.Builder r21 = ContentProviderOperation.newInsert(ContactsContract.Data.CONTENT_URI);
        r21.withValueBackReference(GroupSelectionActivity.EXTRA_RAW_CONTACT_ID, 0);
        r21.withValue("mimetype", "vnd.android.cursor.item/email_v2");
        r21.withValue(DBHelper.COL_DATA2, 4);
        r21.withValue("data1", r20);
        r9.add(r21.build());
    L31:
        r16 = r16 + 1;
    L49:
        ContentProviderResult[] r22 = r18.getContentResolver().applyBatch("com.android.contacts", r9);     // Catch: SQLiteException -> L40 OperationApplicationException -> L43 RemoteException -> L46
        int r23 = r22.length;     // Catch: SQLiteException -> L40 OperationApplicationException -> L43 RemoteException -> L46
        int r24 = 0;
    L33:
        if (r24 >= r23) goto L38;
        if (r22[r24].uri == null) goto L58;
        r24 = r24 + 1;
        goto L33
    L58:
        return false;
    L38:
        return true;
    L43:
        e = move-exception;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_e(TAG, String.format("%s: %s", new Object[]{e.toString(), e.getMessage()}));
        return false;
    L40:
        e = move-exception;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_e(TAG, String.format("%s: %s", new Object[]{e.toString(), e.getMessage()}));
        return false;
    L46:
        e = move-exception;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_e(TAG, String.format("%s: %s", new Object[]{e.toString(), e.getMessage()}));
        return false;
    L5:
        r11 = null;
        goto L7
    }

    public static Uri insertToCard(Context r7, String r8, String r9, String r10, String r11, int r12) {
        return insertToCard(r7, r8, r9, r10, r11, r12, true);
    }

    public static Uri insertToCard(Context r4, String r5, String r6, String r7, String r8, int r9, boolean r10) {
        if (TextUtils.isEmpty(r5) == false) goto L5;
    L11:
        ContentValues r0 = new ContentValues();
        r0.clear();
        r0.put(SimContactsConstants.STR_TAG, r5);
        if (TextUtils.isEmpty(r6) == true) goto L15;
        r6 = PhoneNumberUtils.stripSeparators(r6);
        r0.put("number", r6);
    L15:
        if (TextUtils.isEmpty(r7) == true) goto L18;
        r0.put(SimContactsConstants.STR_EMAILS, r7);
    L18:
        if (TextUtils.isEmpty(r8) == true) goto L20;
        r8 = r8.replaceAll("[^0123456789PWN\\,\\;\\*\\#\\+\\:]", "");
        r0.put(SimContactsConstants.STR_ANRS, r8);
    L20:
        Uri r1 = new SimContactsOperation(r4).insert(r0, r9);
        if (r1 == null) goto L24;
        if (r10 == false) goto L25;
        insertToPhone(new String[]{r5, r6, r7, r8}, r4, r9);
    L25:
        return r1;
    L24:
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_e(TAG, "export contact: [" + r5 + ", " + r6 + ", " + r7 + "] to slot " + r9 + " failed");
        goto L25
    L5:
        if (hasChinese(r5) == false) goto L7;
        int r2 = 6;
    L9:
        if (r5.length() <= r2) goto L11;
        r5 = r5.substring(0, r2);
        goto L11
    L7:
        r2 = 14;
        goto L9
    }

    public static boolean insertToPhone(String[] r17, ContentResolver r18, int r19) {
        Account r0 = getAcount(r19);
        String r3 = r17[0];
        String r6 = r17[1];
        String r8 = r17[2];
        String r10 = r17[3];
        String[] r12 = null;
        if (TextUtils.isEmpty(r8) == true) goto L5;
        String[] r11 = r8.split(SimContactsConstants.EMAIL_SEP);
    L7:
        if (TextUtils.isEmpty(r10) == true) goto L9;
        r12 = r10.split(SimContactsConstants.ANR_SEP);
    L9:
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(TAG, "insertToPhone: name= " + r3 + ", phoneNumber= " + r6 + ", emails= " + r8 + ", anrs= " + r10 + ", account= " + r0);
        ArrayList<ContentProviderOperation> r9 = new ArrayList();
        ContentProviderOperation.Builder r13 = ContentProviderOperation.newInsert(ContactsContract.RawContacts.CONTENT_URI);
        r13.withValue("aggregation_mode", 3);
        if (r0 == null) goto L12;
        r13.withValue("account_name", r0.name);
        r13.withValue("account_type", r0.type);
    L12:
        r9.add(r13.build());
        if (TextUtils.isEmpty(r3) == true) goto L16;
        ContentProviderOperation.Builder r1 = ContentProviderOperation.newInsert(ContactsContract.Data.CONTENT_URI);
        r1.withValueBackReference(GroupSelectionActivity.EXTRA_RAW_CONTACT_ID, 0);
        r1.withValue("mimetype", "vnd.android.cursor.item/name");
        r1.withValue("data1", r3);
        r9.add(r1.build());
    L16:
        if (TextUtils.isEmpty(r6) == true) goto L18;
        ContentProviderOperation.Builder r2 = ContentProviderOperation.newInsert(ContactsContract.Data.CONTENT_URI);
        r2.withValueBackReference(GroupSelectionActivity.EXTRA_RAW_CONTACT_ID, 0);
        r2.withValue("mimetype", "vnd.android.cursor.item/phone_v2");
        r2.withValue(DBHelper.COL_DATA2, 2);
        r2.withValue("data1", r6);
        r2.withValue("is_primary", 1);
        r9.add(r2.build());
    L18:
        if (r12 == null) goto L25;
        int r4 = r12.length;
        int r5 = 0;
    L20:
        if (r5 >= r4) goto L25;
        String r7 = r12[r5];
        if (TextUtils.isEmpty(r7) == true) goto L24;
        ContentProviderOperation.Builder r14 = ContentProviderOperation.newInsert(ContactsContract.Data.CONTENT_URI);
        r14.withValueBackReference(GroupSelectionActivity.EXTRA_RAW_CONTACT_ID, 0);
        r14.withValue("mimetype", "vnd.android.cursor.item/phone_v2");
        r14.withValue(DBHelper.COL_DATA2, 1);
        r14.withValue("data1", r7);
        r9.add(r14.build());
    L24:
        r5 = r5 + 1;
    L25:
        if (r11 == null) goto L46;
        int r15 = r11.length;
        int r16 = 0;
    L27:
        if (r16 >= r15) goto L46;
        String r20 = r11[r16];
        if (TextUtils.isEmpty(r20) == true) goto L31;
        ContentProviderOperation.Builder r21 = ContentProviderOperation.newInsert(ContactsContract.Data.CONTENT_URI);
        r21.withValueBackReference(GroupSelectionActivity.EXTRA_RAW_CONTACT_ID, 0);
        r21.withValue("mimetype", "vnd.android.cursor.item/email_v2");
        r21.withValue(DBHelper.COL_DATA2, 4);
        r21.withValue("data1", r20);
        r9.add(r21.build());
    L31:
        r16 = r16 + 1;
    L46:
        ContentProviderResult[] r22 = r18.applyBatch("com.android.contacts", r9);     // Catch: OperationApplicationException -> L40 RemoteException -> L43
        int r23 = r22.length;     // Catch: OperationApplicationException -> L40 RemoteException -> L43
        int r24 = 0;
    L33:
        if (r24 >= r23) goto L38;
        if (r22[r24].uri == null) goto L55;
        r24 = r24 + 1;
        goto L33
    L55:
        return false;
    L38:
        return true;
    L40:
        e = move-exception;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_e(TAG, String.format("%s: %s", new Object[]{e.toString(), e.getMessage()}));
        return false;
    L43:
        e = move-exception;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_e(TAG, String.format("%s: %s", new Object[]{e.toString(), e.getMessage()}));
        return false;
    L5:
        r11 = null;
        goto L7
    }

    public static Account getAcount(int r2) {
        if (TelephonyManagerUtil.isMultiSimEnabled() == false) goto L9;
        if (r2 != 0) goto L7;
        Account r3 = new Account("SIM1", "com.android.sim");
    L12:
        if (r3 == null) goto L14;
        return r3;
    L14:
        return new Account(SimContactsConstants.PHONE_NAME, "com.android.localphone");
    L7:
        if (r2 != 1) goto L11;
        r3 = new Account("SIM2", "com.android.sim");
    L11:
        r3 = null;
        goto L12
    L9:
        if (r2 != 0) goto L11;
        r3 = new Account(SimContactsConstants.SIM_NAME, "com.android.sim");
        goto L12
    }

    public static int getCurrentSimIconIndex(Context r2, int r3) {
        if (r2 != null) goto L5;
        return -1;
    L5:
        TelephonyManager r1 = (TelephonyManager) r2.getSystemService("phone");
        if (r1 == null) goto L19;
        if (r3 < 0) goto L19;
        if (r3 >= r1.getPhoneCount()) goto L19;
        String r4 = Settings.System.getString(r2.getContentResolver(), PREFERRED_SIM_ICON_INDEX);
        if (TextUtils.isEmpty(r4) == false) goto L14;
        return r3;
    L14:
        String[] r5 = r4.split(SimContactsConstants.EMAIL_SEP);
        if (r3 < r5.length) goto L18;
        return -1;
    L18:
        return Integer.parseInt(r5[r3]);
    L19:
        return -1;
    }

    public static String getSimFilter(Context r5) {
        int r0 = ((TelephonyManager) r5.getSystemService("phone")).getPhoneCount();
        StringBuilder r1 = new StringBuilder("");
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L9;
        if (canSaveEmail(r5, r2) == true) goto L7;
        r1.append(getSimAccountName(r5, r2) + ',');
    L7:
        r2 = r2 + 1;
        goto L3
    L9:
        return r1.toString();
    }

    public static void showNoIPNumberDialog(final Context r3, final int r4) {
        new AlertDialog.Builder(r3).setTitle(R.string.no_ip_number).setMessage(R.string.no_ip_number_on_sim_card).setPositiveButton(R.string.set_ip_number, new AnonymousClass1(r3, r4)).setNegativeButton(android.R.string.cancel, null).show();     // Catch: Exception -> L4
        return;
    }

    public static void setIPNumber(final Context r5, final int r6) {
        View r0 = LayoutInflater.from(r5).inflate(R.layout.ip_prefix_dialog, null);     // Catch: Exception -> L4
        final EditText r1 = (EditText) r0.findViewById(R.id.ip_prefix_dialog_edit);     // Catch: Exception -> L4
        r1.setText(Settings.System.getString(r5.getContentResolver(), IPCALL_PREFIX[r6]));     // Catch: Exception -> L4
        new AlertDialog.Builder(r5).setTitle(R.string.ipcall_dialog_title).setIcon(android.R.drawable.ic_dialog_info).setView(r0).setPositiveButton(android.R.string.ok, new AnonymousClass2(r1, r5, r6)).setNegativeButton(android.R.string.cancel, null).show();     // Catch: Exception -> L4
        return;
    }

    public static boolean isMultiSimEnable(Context r2, int r3) {
        if (Settings.System.getInt(r2.getContentResolver(), "airplane_mode_on", 0) == 0) goto L5;
    L9:
        return false;
    L5:
        if (5 != TelephonyManagerUtil.getDefault().getSimState(r3)) goto L9;
        return true;
    }

    public static String getIPCallPrefix(Context r1, int r2) {
        if (TelephonyManagerUtil.isMultiSimEnabled() == true) goto L6;
        return Settings.System.getString(r1.getContentResolver(), "ipcall_prefix");
    L6:
        return Settings.System.getString(r1.getContentResolver(), IPCALL_PREFIX[r2]);
    }

    public static PhoneAccountHandle getAccount(int r3) {
        return new PhoneAccountHandle(new ComponentName(TelephonySmt.DEFAULT_NOTIFICATION_PACKAGE_NAME, "com.android.services.telephony.TelephonyConnectionService"), String.valueOf(SubscriptionManagerUtil.getSubId(r3)[0]));
    }
}
