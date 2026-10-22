package com.android.contacts;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.app.ActivityManager;
import android.app.AlertDialog;
import android.content.ActivityNotFoundException;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.ComponentName;
import android.content.ContentProviderOperation;
import android.content.ContentProviderResult;
import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Paint;
import android.graphics.Rect;
import android.location.Country;
import android.location.CountryDetector;
import android.location.LocationManager;
import android.media.Ringtone;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Debug;
import android.os.Environment;
import android.os.IBinder;
import android.os.PowerManager;
import android.os.Process;
import android.os.RemoteException;
import android.os.ServiceManager;
import android.os.SystemProperties;
import android.os.UserHandle;
import android.os.storage.IStorageManager;
import android.os.storage.VolumeInfo;
import android.preference.PreferenceManager;
import android.provider.CallLog;
import android.provider.ContactsContract;
import android.provider.Settings;
import android.telephony.PhoneNumberUtils;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Base64;
import android.util.LruCache;
import android.view.LayoutInflater;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import bytedanceos.api.ActivityManagerSmt;
import bytedanceos.api.PowerManagerSmt;
import bytedanceos.util.NameAvatarController;
import bytedanceos.util.PinyinHelper;
import com.GlobalProxyLancet;
import com.android.contacts.common.SimContactsConstants;
import com.android.contacts.list.SamContact;
import com.android.contacts.model.AccountTypeManager;
import com.android.contacts.model.BytedanceAccountType;
import com.android.contacts.model.CamCardSearchParam;
import com.android.contacts.model.EntityDelta;
import com.android.contacts.model.EntityDeltaList;
import com.android.contacts.model.EntityModifier;
import com.android.contacts.util.BytedanceApi;
import com.android.contacts.util.Constants;
import com.android.contacts.util.ContactBadgeUtil;
import com.android.contacts.util.ContactLocaleUtils;
import com.android.contacts.util.ContactTypeLabelUtils;
import com.android.contacts.util.DateUtils;
import com.android.contacts.util.HanziToPinyin;
import com.android.contacts.util.ProductUtils;
import com.android.i18n.phonenumbers.NumberParseException;
import com.android.i18n.phonenumbers.PhoneNumberUtil;
import com.android.i18n.phonenumbers.Phonenumber;
import com.bytedance.apm.battery.config.BatteryTypeInf;
import com.bytedance.framwork.core.sdklib.DBHelper;
import com.google.common.collect.Lists;
import com.intsig.sdk.ScpSDK;
import com.obric.account.LocalAccountContactsUtils;
import com.obric.oui.button.OButton;
import com.obric.oui.sheet.OInsetSheet;
import com.obric.oui.sheet.OInsetSheetTitleBar;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Timer;
import java.util.regex.Pattern;
import obric.api.TelephonySmt;
import obric.app.MenuDialog;
import obric.app.MenuDialogListAdapter;
import obric.util.config.Features;

/* JADX INFO: loaded from: classes.dex */
public class ContactsUtils {
    public static final String CAM_CARD_COMPANY_ACTION = "action_cam_card";
    public static final String CAM_CARD_COMPANY_MIMETYPE = "mimetype_cam_card";
    public static final String CAM_CARD_COMPANY_PARAM = "param_cam_search";
    public static final String CHAR_POUND = "#";
    public static final String CHAR_STAR = "*";
    public static final String CONTACT_ADDED_TIME_MIMETYPE = "vnd.android.cursor.item/added_time";
    public static final String CONTACT_LOCATION_MIMETYPE = "vnd.android.cursor.item/location";
    public static final int DATE_PICKER_MIN_DAY = 1;
    public static final int DATE_PICKER_MIN_MONTH = 0;
    public static final int DATE_PICKER_MIN_YEAR = 1900;
    public static final boolean DEBUG = false;
    public static final boolean DEBUG_PERFORMANCE = false;
    private static final int DELAY_TIME = 500;
    private static final String EMERGENCY_CONTACT_MIGRATED = "emergency_contact_migrated";
    private static final String EMERGENCY_CONTACT_PREFS = "emergency_contact_prefs";
    public static final String EXTRA_COUNTRY_ISO = "com.android.contacts.extra_COUNTRY_ISO";
    public static final String EXTRA_ENTER_FROM = "enter_from";
    public static final String EXTRA_HIDE_STRANGER_CALL_LOG = "com.android.contacts.extra.HIDE_STRANGER_CALL_LOG";
    public static final String EXTRA_INTERCEPT_TYPE = "com.android.contacts.extra.INTERCEPT_TYPE";
    public static final String EXTRA_LABEL = "com.android.contacts.extra_LABEL";
    public static final String EXTRA_PHONE_NUMBERS = "com.android.contacts.extra.PHONE_NUMBERS";
    public static final String EXTRA_PHONE_NUMBERS_HIGHLIGHT = "com.android.contacts.extra.PHONE_NUMBERS_HIGHLIGHT";
    public static final String EXTRA_PHONE_NUMBERS_PRESENTATION = "com.android.contacts.extra.PHONE_NUMBERS_PRESENTATION";
    public static final String EXTRA_PUBLIC_LOGO = "publicLogo";
    public static boolean FEATURE_CMCC = false;
    public static boolean FEATURE_CT = false;
    public static boolean FEATURE_CU = false;
    public static boolean FEATURE_SIM_PHONEBOOK = false;
    private static final int HPROF_COUNT = 4;
    private static final String HPROF_NAME = "contact_%d_%d.hprof";
    private static final String HPROF_PREFIX = "contact_";
    private static final String HPROF_SUFFIX = ".hprof";
    public static final String IMPORT_OTHER_PHONE_ACTIVITY_NAME = "com.android.settings.bluetooth.BluetoothPbapClientActivity";
    public static final String IMPORT_OTHER_PHONE_PACKAGE_NAME = "com.android.settings";
    private static char[] JAPANESE_LETTERS = null;
    private static char[] KOREA_LETTERS = null;
    public static final boolean KSA_VERSION = false;
    public static final String LAUNCH_RECONGNIZE_SERVICE = "android.intent.action.VoiceAssistantService";
    public static final int LISTVIEW_ITEM_HEIGHT_DIP = 59;
    public static final String LOCAL_ACCOUNT_NAME = "default";
    public static final String LOCAL_ACCOUNT_TYPE = "contacts.bytedance.default";
    public static final int MAX_DB_OPERATION_NUMBER = 400;
    public static final String OLD_LOCAL_ACCOUNT_TYPE = null;
    public static final String PERFORMANCE_TAG = "Contacts_Performance";
    private static final String PHONE_NUMBER_SEPARATORS = " ()-.";
    private static final String PHONE_NUMBER_SEPARATORS_FOR_STAR = " ()-./";
    public static final String PREF_LAST_NETWORK_COUNTRY_ISO = "network_country_iso";
    public static final String PROPERTY_DBG_VOLTE_AVAIL_OVERRIDE = "persist.dbg.volte_avail_ovr";
    public static final int PROPERTY_DBG_VOLTE_AVAIL_OVERRIDE_DEFAULT = 0;
    public static final String QQ_MIMETYPE = "vnd.android.cursor.item/vnd.com.tencent.mobileqq.voicecall.profile";
    private static char[] RUSSIAN_LETTERS = null;
    public static final int SELECT_SIM_TYPE_CALL = 1;
    public static final int SELECT_SIM_TYPE_MMS = 2;
    public static final int SELECT_SIM_TYPE_VOICE_MAIL = 3;
    private static final String SETTINGS_CONTACTS_EMERGENCY_NAME = "contacts_emergency_name";
    private static final String SETTINGS_CONTACTS_EMERGENCY_NUMBER = "contacts_emergency_number";
    private static final String SETTINGS_CONTACTS_EMERGENCY_PHONE_DATA_URI = "contacts_emergency_phone_data_uri";
    private static final String TAG = "ContactsUtils";
    private static final List<String> UNKNOWN_CITY_LIST = null;
    public static boolean USER_LOG_ON = false;
    public static final String VOICE_ASSISTANT_PACKAGE = "com.bytedanceos.voice";
    private static final String WAIT_SYMBOL_AS_STRING = null;
    public static final int WAIT_SYNC_TIME = 2000;
    public static final String WECHAT_ACCOUNT_TYPE = "com.tencent.mm.account";
    public static final String WECHAT_MIMETYPE = "vnd.android.cursor.item/vnd.com.tencent.mm.chatting.profile";
    public static final String WECHAT_MIMETYPE_PREFIX = "vnd.android.cursor.item/vnd.com.tencent.mm";
    public static final String WHATSAPP_CONTACT_PREFIX_CHINA = "86";
    public static final String WHATSAPP_CONTACT_SUFFIX = "@s.whatsapp.net";
    public static final String WHATSAPP_MINTYPE = "vnd.android.cursor.item/vnd.com.whatsapp";
    public static final String WHATSAPP_MINTYPE_PROFILE = "vnd.android.cursor.item/vnd.com.whatsapp.profile";
    public static final String WHATSAPP_MINTYPE_VIDEO_CALL = "vnd.android.cursor.item/vnd.com.whatsapp.video.call";
    public static final String WHATSAPP_MINTYPE_VOIP_CALL = "vnd.android.cursor.item/vnd.com.whatsapp.voip.call";
    private static boolean ctaModeEnabled;
    private static Boolean isFeatureRTLDualSim;
    private static Boolean isFeatureUS;
    private static DateFormat mDateFormat;
    private static boolean mDelayClickFlag;
    private static boolean mHasContact;
    private static DateFormat mTimeFormat;
    private static String mVoiceMailNumberCache;
    private static LruCache<String, String> sFormatNumberCache;
    private static final ArrayList<String> sPowerSaveWhiteList = null;
    private static int sThumbnailSize;
    private static boolean sVoiceEnabled;

    /* JADX INFO: renamed from: com.android.contacts.ContactsUtils$18, reason: invalid class name */
    static /* synthetic */ class AnonymousClass18 {
        static final /* synthetic */ int[] $SwitchMap$com$android$i18n$phonenumbers$PhoneNumberUtil$MatchType = null;

        static {
            int[] r0 = new int[PhoneNumberUtil.MatchType.values().length];
            $SwitchMap$com$android$i18n$phonenumbers$PhoneNumberUtil$MatchType = r0;
            r0[PhoneNumberUtil.MatchType.NOT_A_NUMBER.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L14:
            $SwitchMap$com$android$i18n$phonenumbers$PhoneNumberUtil$MatchType[PhoneNumberUtil.MatchType.NO_MATCH.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L18:
            $SwitchMap$com$android$i18n$phonenumbers$PhoneNumberUtil$MatchType[PhoneNumberUtil.MatchType.EXACT_MATCH.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L22:
            $SwitchMap$com$android$i18n$phonenumbers$PhoneNumberUtil$MatchType[PhoneNumberUtil.MatchType.NSN_MATCH.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L16:
            $SwitchMap$com$android$i18n$phonenumbers$PhoneNumberUtil$MatchType[PhoneNumberUtil.MatchType.SHORT_NSN_MATCH.ordinal()] = 5;     // Catch: NoSuchFieldError -> L13
            return;
        }
    }

    public interface ProviderNames {
        public static final String AIM = "AIM";
        public static final String GTALK = "GTalk";
        public static final String ICQ = "ICQ";
        public static final String JABBER = "JABBER";
        public static final String MSN = "MSN";
        public static final String QQ = "QQ";
        public static final String SKYPE = "SKYPE";
        public static final String XMPP = "XMPP";
        public static final String YAHOO = "Yahoo";
    }

    public static int getFeaturePhoneModeHintId() {
        return R.string.cannot_by_power_save_mode;
    }

    public static boolean isBytedanceFeatureTestEnabled() {
        return false;
    }

    public static boolean isBytedanceFeatureVersion_2_2_0_Enabled() {
        return true;
    }

    public static boolean isBytedanceFeatureVersion_3_0_Enabled() {
        return false;
    }

    public static boolean isEnglishLetter(char r1) {
        if (r1 < 'a') goto L7;
        if (r1 > 'z') goto L7;
    L10:
        return true;
    L7:
        if (r1 >= 'A') goto L9;
    L11:
        return false;
    L9:
        if (r1 > 'Z') goto L11;
        goto L10
    }

    public static boolean isRechargeSupport() {
        return false;
    }

    public static String lookupProviderNameFromId(int r0) {
        switch(r0) {
            case 0: goto L19;
            case 1: goto L17;
            case 2: goto L15;
            case 3: goto L13;
            case 4: goto L11;
            case 5: goto L9;
            case 6: goto L7;
            case 7: goto L5;
            default: goto L3;
        };
    L3:
        return null;
    L5:
        return "JABBER";
    L7:
        return "ICQ";
    L9:
        return "GTalk";
    L11:
        return "QQ";
    L13:
        return "SKYPE";
    L15:
        return "Yahoo";
    L17:
        return "MSN";
    L19:
        return "AIM";
    }

    public static void releaseCpuBoost() {
    }

    public static void setCpuBoost(int r0) {
    }

    public ContactsUtils() {
    }

    static /* synthetic */ boolean access$002(boolean r0) {
        mDelayClickFlag = r0;
        return r0;
    }

    static /* synthetic */ void access$100(Context r0, int r1) {
        addVoiceMailNumberPanel(r0, r1);
    }

    static {
        FEATURE_CMCC = "cmcc".equals(SystemProperties.get("ro.build.operator", "open"));
        FEATURE_CT = "ct".equals(SystemProperties.get("ro.build.operator", "open"));
        boolean r0 = "cu".equals(SystemProperties.get("ro.build.operator", "open"));
        FEATURE_CU = r0;
        boolean r2 = true;
        if (FEATURE_CMCC == false) goto L5;
    L9:
        boolean r1 = true;
    L10:
        FEATURE_SIM_PHONEBOOK = r1;
        WAIT_SYMBOL_AS_STRING = String.valueOf(';');
        if (SystemProperties.getInt("ro.voice_assistant_enable", 0) != 1) goto L13;
        boolean r3 = true;
    L14:
        sVoiceEnabled = r3;
        DEBUG = SystemProperties.get("ro.build.type").equals("userdebug");
        KSA_VERSION = SystemProperties.get("ro.build.tags").equals("release-keys");
        USER_LOG_ON = false;
        OLD_LOCAL_ACCOUNT_TYPE = new String(Base64.decode("Y29udGFjdHMuc21hcnRpc2FuLmRlZmF1bHQ=", 0));
        mHasContact = false;
        KOREA_LETTERS = new char[]{12593, 12596, 12599, 12601, 12609, 12610, 12613, 12615, 12616, 12618, 12619, 12620, 12621, 12622};
        JAPANESE_LETTERS = new char[]{12354, 12363, 12373, 12383, 12394, 12399, 12414, 12420, 12425, 12431};
        RUSSIAN_LETTERS = new char[]{1040, 1041, 1042, 1043, 1044, 1045, 1025, 1046, 1047, 1048, 1049, 1050, 1051, 1052, 1053, 1054, 1055, 1056, 1057, 1058, 1059, 1060, 1061, 1062, 1063, 1064, 1065, 1066, 1067, 1068, 1069, 1070, 1071, 1072, 1073, 1074, 1075, 1076, 1077, 1105, 1078, 1079, 1080, 1081, 1082, 1083, 1084, 1085, 1086, 1087, 1088, 1089, 1090, 1091, 1092, 1093, 1094, 1095, 1096, 1097, 1098, 1099, 1100, 1101, 1102, 1103};
        sThumbnailSize = -1;
        if (SystemProperties.getInt("persist.radio.cta.test.mode", 0) == 1) goto L18;
        r2 = false;
    L18:
        ctaModeEnabled = r2;
        ArrayList<String> r4 = new ArrayList();
        sPowerSaveWhiteList = r4;
        r4.add("com.android.mms");
        r4.add("com.android.contacts");
        if (Constants.ANDROID50 == false) goto L21;
        String r5 = TelephonySmt.MISSED_CALL_NOTIFICATION_PACKAGE_NAME;
    L22:
        r4.add(r5);
        isFeatureUS = null;
        isFeatureRTLDualSim = null;
        mDelayClickFlag = false;
        sFormatNumberCache = new LruCache(20);
        UNKNOWN_CITY_LIST = Lists.newArrayList(new String[]{"本地电话", "热线电话", "中国"});
        return;
    L21:
        r5 = TelephonySmt.DEFAULT_NOTIFICATION_PACKAGE_NAME;
        goto L22
    L13:
        r3 = false;
        goto L14
    L5:
        if (FEATURE_CT == true) goto L9;
        if (r0 == true) goto L9;
        r1 = false;
        goto L10
    }

    public static boolean isCtaMode() {
        return ctaModeEnabled;
    }

    public static boolean compareWithVoiceNumber(String r1) {
        String r2 = PhoneNumberUtils.extractNetworkPortionAlt(r1);
        if (TextUtils.isEmpty(r2) == false) goto L5;
    L7:
        return false;
    L5:
        if (PhoneNumberUtils.compare(r2, mVoiceMailNumberCache) == false) goto L7;
        return true;
    }

    public static String getVoiceNumber() {
        fatchVoiceMailNumber();
        return mVoiceMailNumberCache;
    }

    public static boolean isEmergencyNumber(String r1) {
        return BytedanceApi.isLocalEmergencyNumber(r1, ContactsApplication.getInstance());
    }

    public static void fatchVoiceMailNumber() {
    L7:
        String r0 = null;
    L8:
        mVoiceMailNumberCache = r0;
        return;
    L3:
        if (DSUtils.isMultiSimEnabled() == false) goto L5;
        r0 = DSUtils.getVoiceMailNumber(DSUtils.getDefaultCallSim());     // Catch: SecurityException -> L7
    L10:
        goto L8
    L5:
        r0 = TelephonyManager.getDefault().getVoiceMailNumber();     // Catch: SecurityException -> L7
        goto L10
    }

    public static boolean isGraphic(CharSequence r1) {
        if (TextUtils.isEmpty(r1) == false) goto L5;
    L7:
        return false;
    L5:
        if (TextUtils.isGraphic(r1) == false) goto L7;
        return true;
    }

    public static boolean areObjectsEqual(Object r0, Object r1) {
        if (r0 == r1) goto L8;
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.equals(r1) == false) goto L7;
    L8:
        return true;
    }

    public static final boolean shouldCollapse(CharSequence r6, CharSequence r7, CharSequence r8, CharSequence r9) {
        return shouldCollapse(r6, r7, r8, r9, false, false);
    }

    public static final boolean shouldCollapse(CharSequence r1, CharSequence r2, CharSequence r3, CharSequence r4, boolean r5, boolean r6) {
        if (TextUtils.equals(r1, r3) == true) goto L5;
        return false;
    L5:
        if (r5 == true) goto L11;
        if (TextUtils.equals(r2, r4) == false) goto L13;
        return true;
    L13:
        if (r2 == null) goto L21;
        if (r4 == null) goto L21;
        if (TextUtils.equals("vnd.android.cursor.item/phone_v2", r1) == true) goto L20;
        return false;
    L20:
        return shouldCollapsePhoneNumbers(r2.toString(), r4.toString());
    L21:
        return false;
    L11:
        if (TextUtils.equals(r2, r4) == false) goto L13;
        return r6;
    }

    private static boolean shouldCollapsePhoneNumbers(String r8, String r9) {
        String r0 = WAIT_SYMBOL_AS_STRING;
        String[] r10 = r8.split(r0);
        String[] r11 = r9.split(r0);
        if (r10.length == r11.length) goto L5;
        return false;
    L5:
        PhoneNumberUtil r1 = PhoneNumberUtil.getInstance();
        int r2 = 0;
    L7:
        if (r2 >= r10.length) goto L37;
        String r3 = PhoneNumberUtils.convertKeypadLettersToDigits(r10[r2]);
        String r5 = r11[r2];
        if (TextUtils.equals(r3, r5) == true) goto L35;
        int r6 = AnonymousClass18.$SwitchMap$com$android$i18n$phonenumbers$PhoneNumberUtil$MatchType[r1.isNumberMatch(r3, r5).ordinal()];
        if (r6 == 1) goto L36;
        if (r6 == 2) goto L36;
        if (r6 == 3) goto L35;
        if (r6 != 4) goto L20;
        Phonenumber.PhoneNumber r4 = r1.parse(r3, null);     // Catch: NumberParseException -> L33
        if (r4 == null) goto L34;
        if (r4.getCountryCode() != 1) goto L34;
        if (r5.trim().charAt(0) != '1') goto L35;
        return false;
    L34:
        return false;
    L33:
        r1.parse(r5, null);     // Catch: NumberParseException -> L38
    L20:
        if (r6 != 5) goto L23;
        return false;
    L23:
        throw new IllegalStateException("Unknown result value from phone number library");
    L36:
        return false;
    L35:
        r2 = r2 + 1;
        goto L7
    L37:
        return true;
    }

    public static final String getCurrentCountryIso(Context r2) {
        String r0 = ((TelephonyManager) r2.getSystemService("phone")).getSimCountryIso();
        if (TextUtils.isEmpty(r0) == false) goto L5;
        Country r3 = ((CountryDetector) r2.getSystemService("country_detector")).detectCountry();
        if (r3 == null) goto L10;
        r0 = r3.getCountryIso();
    L10:
        if (TextUtils.isEmpty(r0) == true) goto L14;
        return r0.toUpperCase(Locale.US);
    L14:
        return Locale.getDefault().getCountry().toUpperCase(Locale.US);
    L5:
        return r0.toUpperCase(Locale.US);
    }

    public static boolean areContactWritableAccountsAvailable(Context r1) {
        return !AccountTypeManager.getInstance(r1).getAccounts(true).isEmpty();
    }

    public static boolean areGroupWritableAccountsAvailable(Context r0) {
        return !AccountTypeManager.getInstance(r0).getGroupWritableAccounts().isEmpty();
    }

    public static View createHeaderView(Context r2, int r3) {
        View r0 = View.inflate(r2, R.layout.list_separator, null);
        ((TextView) r0.findViewById(R.id.title)).setText(r2.getString(r3));
        return r0;
    }

    public static Rect getTargetRectFromView(Context r6, View r7) {
        float r8 = r6.getResources().getCompatibilityInfo().applicationScale;
        int[] r0 = new int[2];
        r7.getLocationOnScreen(r0);
        Rect r1 = new Rect();
        r1.left = (int) ((r0[0] * r8) + 0.5f);
        r1.top = (int) ((r0[1] * r8) + 0.5f);
        r1.right = (int) (((r0[0] + r7.getWidth()) * r8) + 0.5f);
        r1.bottom = (int) (((r0[1] + r7.getHeight()) * r8) + 0.5f);
        return r1;
    }

    public static String getContactRingtoneTitle(Context r1, Uri r2) {
        if (r1 == null) goto L13;
        if (r2 != null) goto L5;
        return null;
    L5:
        if (TextUtils.isEmpty(r2.toString()) == true) goto L16;
        String r0 = getRingTongTitle(r1, r2);
        if (existMediaStoreRingtone(r1, r2, r0) == false) goto L12;
        return translateRingtoneTitle(r0);
    L12:
        return r1.getString(R.string.default_ringtone);
    L16:
        return null;
    L13:
        return null;
    }

    private static String translateRingtoneTitle(String r6) {
        ContactsApplication r0 = ContactsApplication.getInstance();
        String[] r1 = r0.getResources().getStringArray(R.array.internal_ringtone_title);
        String[] r2 = r0.getResources().getStringArray(R.array.internal_ringtone_title_en);
        String[] r3 = r0.getResources().getStringArray(R.array.internal_ringtone_title_tw);
        Configuration r4 = getConfiguration(r0);
        if (r4 != null) goto L5;
        return r6;
    L5:
        int r5 = 0;
        if (r4.locale.toString().equals(Locale.TRADITIONAL_CHINESE.toString()) == false) goto L15;
    L8:
        if (r5 >= r1.length) goto L23;
        if (r1[r5].equals(r6) == true) goto L12;
        r5 = r5 + 1;
        goto L8
    L12:
        return r3[r5];
    L23:
        return r6;
    L15:
        if (r4.locale.toString().equals(Locale.SIMPLIFIED_CHINESE.toString()) == true) goto L23;
    L17:
        if (r5 >= r1.length) goto L23;
        if (r1[r5].equals(r6) == true) goto L21;
        r5 = r5 + 1;
        goto L17
    L21:
        return r2[r5];
    }

    public static Configuration getConfiguration(Context r2) {
        if (r2 != null) goto L5;
        return null;
    L5:
        ActivityManager r3 = (ActivityManager) r2.getSystemService("activity");
        return ActivityManagerSmt.getInstance().getConfiguration(r3);
    L8:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    public static String getRingTongTitle(Context r2, Uri r3) {
        Ringtone r0 = new Ringtone(r2, false);     // Catch: Exception -> L4
        r0.setUri(r3);     // Catch: Exception -> L4
        return r0.getTitle(r2);
    L4:
        e = move-exception;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_e(TAG, "getRingTongTitle: ", e);
        return "";
    }

    public static boolean existMediaStoreRingtone(Context r2, Uri r3, String r4) {
        if (r3 != null) goto L5;
        return false;
    L5:
        if (TextUtils.isEmpty(r3.toString()) == false) goto L7;
        return false;
    L7:
        if (TextUtils.isEmpty(r4) == false) goto L10;
        return false;
    L10:
        if ("media".equals(r3.getAuthority()) == true) goto L12;
    L14:
        return true;
    L12:
        if (r4.equals(r3.getLastPathSegment()) == false) goto L14;
        return false;
    }

    public static String getContactName(Context r1, String r2) {
        if (TextUtils.isEmpty(r2) == true) goto L5;
        return r2;
    L5:
        return r1.getResources().getString(R.string.missing_name);
    }

    public static String getContactSection(String r1) {
        if (TextUtils.isEmpty(r1) == true) goto L8;
        char r2 = r1.charAt(0);
        if (Character.isLetter(r2) == true) goto L7;
        return CHAR_POUND;
    L7:
        return Character.toString(Character.toUpperCase(r2));
    L8:
        return CHAR_POUND;
    }

    public static String getContactSection(String r5, String r6) {
        if (TextUtils.isEmpty(r5) == true) goto L34;
        boolean r0 = false;
        char r7 = r5.charAt(0);
        if (isBytedanceFeatureVersion_2_2_0_Enabled() == true) goto L7;
    L22:
        if (r0 == false) goto L25;
        return r6;
    L25:
        if (isEnglishLetter(r7) == false) goto L29;
        return Character.toString(Character.toUpperCase(r7));
    L29:
        if (isRussianLetter(r7) == true) goto L31;
        return CHAR_POUND;
    L31:
        if ("ru".equals(Locale.getDefault().getLanguage()) == true) goto L33;
        return CHAR_POUND;
    L33:
        return Character.toString(Character.toUpperCase(r7));
    L7:
        if (Locale.KOREA.getLanguage().equals(Locale.getDefault().getLanguage()) == true) goto L9;
    L13:
        boolean r1 = false;
    L15:
        if (Locale.JAPAN.getLanguage().equals(Locale.getDefault().getLanguage()) == true) goto L17;
    L21:
        r0 = r0 | r1;
        goto L22
    L17:
        if (TextUtils.isEmpty(r6) == true) goto L21;
        if (isJapaneseLetter(r6.charAt(0)) == false) goto L21;
        r0 = true;
        goto L21
    L9:
        if (TextUtils.isEmpty(r6) == true) goto L13;
        if (isKoreaLetter(r6.charAt(0)) == false) goto L13;
        r1 = true;
        goto L15
    L34:
        return CHAR_POUND;
    }

    public static boolean isKoreaLetter(char r5) {
        char[] r0 = KOREA_LETTERS;
        int r1 = r0.length;
        int r3 = 0;
    L3:
        if (r3 >= r1) goto L9;
        if (r5 == r0[r3]) goto L6;
        r3 = r3 + 1;
        goto L3
    L6:
        return true;
    L9:
        return false;
    }

    public static boolean isJapaneseLetter(char r5) {
        char[] r0 = JAPANESE_LETTERS;
        int r1 = r0.length;
        int r3 = 0;
    L3:
        if (r3 >= r1) goto L9;
        if (r5 == r0[r3]) goto L6;
        r3 = r3 + 1;
        goto L3
    L6:
        return true;
    L9:
        return false;
    }

    public static boolean isRussianLetter(char r5) {
        char[] r0 = RUSSIAN_LETTERS;
        int r1 = r0.length;
        int r3 = 0;
    L3:
        if (r3 >= r1) goto L9;
        if (r5 == r0[r3]) goto L6;
        r3 = r3 + 1;
        goto L3
    L6:
        return true;
    L9:
        return false;
    }

    public static String getContactPhoneDescribe(Context r0, int r1, CharSequence r2, String r3) {
        return String.format("%s  %s", new Object[]{formatNumberForT9(r3), ContactTypeLabelUtils.getPhoneTypeLabel(r0, Integer.valueOf(r1), r2)});
    }

    public static String getContactPostalAddressDescribe(Context r0, int r1, CharSequence r2, String r3) {
        return String.format("%s  %s", new Object[]{formatNumber(r3), ContactTypeLabelUtils.getPostalTypeLabel(r0, Integer.valueOf(r1), r2)});
    }

    public static String getContactEmailDescrib(Resources r1, int r2, CharSequence r3, String r4) {
        if (r2 == 0) goto L4;
    L6:
        Object r5 = ContactsContract.CommonDataKinds.Email.getTypeLabel(r1, r2, r3);
    L8:
        return String.format("%s  %s", new Object[]{r4, r5});
    L4:
        if (TextUtils.isEmpty(r3) == false) goto L6;
        r5 = r1.getString(EntityModifier.guessBestValidLabelResourceFromMimeType("vnd.android.cursor.item/email_v2"));
        goto L8
    }

    public static boolean isNoSim(Context r1) {
        return !((TelephonyManager) r1.getSystemService("phone")).hasIccCard();
    }

    public static int dipTopx(Context r2, double r3) {
        return (int) ((r3 * ((double) r2.getResources().getDisplayMetrics().density)) + 0.5d);
    }

    public static int pxTodip(Context r0, int r1) {
        return (int) ((r1 / r0.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static int getScreenWidth(Context r0) {
        return r0.getResources().getDisplayMetrics().widthPixels;
    }

    public static int getScreenHeight(Context r0) {
        return r0.getResources().getDisplayMetrics().heightPixels;
    }

    public static int getSmallestScreenWidth(Context r0) {
        return r0.getResources().getConfiguration().smallestScreenWidthDp;
    }

    public static boolean isPhoneNumber(String r2) {
        if (TextUtils.isEmpty(r2) == false) goto L6;
        return false;
    L6:
        if (countPhoneNumberDigits(r2) <= 0) goto L9;
        return true;
    L9:
        return false;
    }

    public static int countPhoneNumberDigits(String r6) {
        int r0 = r6.length();
        int r2 = 0;
        int r3 = 0;
    L3:
        if (r2 >= r0) goto L34;
        char r4 = r6.charAt(r2);
        if (Character.isDigit(r4) == false) goto L8;
        r3 = r3 + 1;
    L33:
        r2 = r2 + 1;
        goto L3
    L8:
        if (r4 == '*') goto L33;
        if (r4 == '#') goto L33;
        if (r4 == 'N') goto L33;
        if (r4 == '.') goto L33;
        if (r4 == ';') goto L33;
        if (r4 == '-') goto L33;
        if (r4 == '(') goto L33;
        if (r4 == ')') goto L33;
        if (r4 == ' ') goto L33;
        if (r4 == ',') goto L33;
        if (r4 != '+') goto L32;
        if (r3 == 0) goto L33;
    L32:
        return 0;
    L34:
        return r3;
    }

    public static boolean canStar(String r5) {
        if (TextUtils.isEmpty(r5) == false) goto L5;
        return false;
    L5:
        int r0 = r5.length();
        int r2 = 0;
    L6:
        if (r2 >= r0) goto L13;
        char r3 = r5.charAt(r2);
        if (PhoneNumberUtils.isNonSeparator(r3) == true) goto L12;
        if (PHONE_NUMBER_SEPARATORS_FOR_STAR.indexOf(r3) >= 0) goto L12;
        return false;
    L12:
        r2 = r2 + 1;
        goto L6
    L13:
        return true;
    }

    public static boolean isStartWithPhoneNumber(String r5) {
        if (TextUtils.isEmpty(r5) == false) goto L5;
        return false;
    L5:
        int r0 = r5.length();
        int r2 = 0;
    L6:
        if (r2 >= r0) goto L18;
        char r3 = r5.charAt(r2);
        if (PHONE_NUMBER_SEPARATORS.indexOf(r3) >= 0) goto L13;
        if (r3 != '+') goto L15;
        if (r2 == 0) goto L13;
    L15:
        if (Character.isDigit(r3) == false) goto L18;
        return true;
    L13:
        r2 = r2 + 1;
    L18:
        return false;
    }

    public static boolean hasInvalidInformation(Context r1, EntityDeltaList r2) {
        Iterator<EntityDelta> r3 = r2.iterator();
    L4:
        if (r3.hasNext() == false) goto L9;
        if (hasInvalidNumber(r1, r3.next()) == false) goto L4;
        return true;
    L9:
        return false;
    }

    private static boolean hasInvalidNumber(Context r4, EntityDelta r5) {
        ArrayList<EntityDelta.ValuesDelta> r6 = r5.getMimeEntries("vnd.android.cursor.item/phone_v2");
        if (r6 == null) goto L13;
        Iterator<EntityDelta.ValuesDelta> r7 = r6.iterator();
    L6:
        if (r7.hasNext() == false) goto L13;
        String r1 = r7.next().getAsString("data1");
        if (TextUtils.isEmpty(r1) == true) goto L6;
        if (isPhoneNumber(r1) == true) goto L6;
        new AlertDialog.Builder(r4).setMessage(r4.getResources().getString(R.string.dialog_message_did_not_save_due_invalid_number, new Object[]{r1})).setNegativeButton(R.string.common_ok, new AnonymousClass1()).show();
        return true;
    L13:
        return false;
    }

    public static void toggleInputMethod(Context r1, View r2) {
        ((InputMethodManager) r1.getSystemService("input_method")).toggleSoftInput(0, 2);
    }

    public static void hideInputMethod(Context r1, IBinder r2) {
        if (r1 == null) goto L6;
        if (r2 == null) goto L7;
        ((InputMethodManager) r1.getSystemService("input_method")).hideSoftInputFromWindow(r2, 0);
        return;
    L7:
        return;
    }

    public static void showKeyBoard(Context r1, View r2) {
        if (r1 == null) goto L6;
        if (r2 == null) goto L7;
        ((InputMethodManager) r1.getSystemService("input_method")).showSoftInput(r2, 0);
        return;
    L7:
        return;
    }

    public static Bitmap creatBitmapFromName(Context r1, String r2) {
        NameAvatarController.getContactPhotoName(r1, r2);
        Bitmap r3 = ContactBadgeUtil.loadDefaultAvatarPhoto(r1, true, false);
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_e(TAG, "creatBitmapFromName: , result = " + r3);
        return r3;
    }

    public static byte[] Bitmap2Bytes(Bitmap r3) {
        ByteArrayOutputStream r0 = new ByteArrayOutputStream();
        r3.compress(Bitmap.CompressFormat.PNG, 100, r0);
        return r0.toByteArray();
    }

    public static boolean isAirplaneModeOn(Context r2) {
        if (Settings.System.getInt(r2.getContentResolver(), "airplane_mode_on", 0) == 1) goto L5;
        return false;
    L5:
        return true;
    }

    public static boolean isOneHandModeLeft(Context r2) {
        if (Settings.Global.getInt(r2.getContentResolver(), "launcher_switching_orientation", 0) == 1) goto L5;
        return false;
    L5:
        return true;
    }

    public static boolean isScaledFontApplied(Context r2) {
        if (Math.abs(Settings.System.getFloat(r2.getContentResolver(), "font_scale", 1.0f) - 1.0f) < 0.01f) goto L5;
        return true;
    L5:
        return false;
    }

    public static boolean isQuerySimContactsCommand(String r2) {
        if (r2 != null) goto L5;
    L9:
        return false;
    L5:
        if (r2.endsWith(CHAR_POUND) == false) goto L9;
        return Pattern.compile("[0-9]*").matcher(r2.substring(0, r2.length() - 1)).matches();
    }

    public static boolean gpsIsWork(Context r1) {
        return ((LocationManager) r1.getSystemService(BatteryTypeInf.BATTERY_LOC_API)).isProviderEnabled("gps");
    }

    public static int getFavoriteLastIndex(Context r6) {
        Cursor r7 = r6.getContentResolver().query(ContactsContract.Data.CONTENT_URI, new String[]{"data14"}, "data15 =1 and mimetype='vnd.android.cursor.item/phone_v2'", null, null);
        if (r7 != null) goto L21;
    L14:
        int r2 = Integer.MIN_VALUE;
    L15:
        if (r7 == null) goto L17;
        r7.close();
    L17:
        if (r2 != Integer.MIN_VALUE) goto L20;
        return 0;
    L20:
        return r2;
    L21:
    L10:
        th = move-exception;
        if (r7 == null) goto L13;
        r7.close();
    L13:
        throw th;
    L5:
        if (r7.moveToFirst() == false) goto L14;
        r2 = Integer.MIN_VALUE;
    L7:
        r2 = Math.max(r2, r7.getInt(0));     // Catch: Throwable -> L10
        if (r7.moveToNext() == true) goto L7;
        goto L15
    }

    public static boolean isJustClicked() {
        boolean r0 = mDelayClickFlag;
        if (r0 == true) goto L6;
        new Timer().schedule(new AnonymousClass2(), 500);
        mDelayClickFlag = true;
        return false;
    L6:
        return r0;
    }

    public static boolean canUseChineseNumberLocation() {
        String r0 = ContactsApplication.getSimCountryIso();
        if (DEBUG == false) goto L6;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(TAG, "simCountryIso = " + r0);
    L6:
        if (TextUtils.isEmpty(r0) == false) goto L8;
    L11:
        boolean r1 = true;
    L13:
        if (isFeatureUSEnabled() == false) goto L15;
        return false;
    L15:
        if (isFeatureDomestic() == false) goto L20;
        if (r1 == true) goto L18;
        return false;
    L18:
        return true;
    L20:
        return false;
    L8:
        if (RegionConstants.REGION.equalsIgnoreCase(r0) == true) goto L11;
        r1 = false;
        goto L13
    }

    public static String formatNumber(String r1) {
        if (TextUtils.isEmpty(r1) == false) goto L5;
    L9:
        String r0 = formatNumberForT9(r1);
        if (r0 != null) goto L12;
        return r1;
    L12:
        return r0;
    L5:
        if (r1.indexOf(44) < 0) goto L7;
    L8:
        return r1;
    L7:
        if (r1.indexOf(59) < 0) goto L9;
        goto L8
    }

    public static String formatNumberForT9(String r2) {
        if (TextUtils.isEmpty(r2) == false) goto L5;
        return r2;
    L5:
        String r0 = sFormatNumberCache.get(r2);
        if (TextUtils.isEmpty(r0) == false) goto L10;
        r0 = PhoneNumberUtils.formatNumber(r2, ContactsApplication.getCountryIso());
        if (TextUtils.isEmpty(r0) == true) goto L10;
        sFormatNumberCache.put(r2, r0);
    L10:
        if (r0 != null) goto L13;
        return r2;
    L13:
        return r0;
    }

    public static void showNumberForFreeCall(final Context r4, ArrayList<String> r5) {
        ArrayList r0 = new ArrayList(r5.size());
        Iterator<String> r1 = r5.iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        final String r2 = r1.next();
        r0.add(new AnonymousClass3(r4, r2));
        goto L4
    L6:
        MenuDialog r3 = new MenuDialog(r4);
        r3.setTitle(R.string.free_call_dialog_title);
        r3.setAdapter(new MenuDialogListAdapter(r4, r5, r0));
        r3.show();
    }

    public static void showCopyToClipboardDialog(final Context r9, final String r10, final String[] r11, final String r12, boolean r13) {
        ArrayList r0 = new ArrayList();
        ArrayList r1 = new ArrayList();
        if (r11 != null) goto L5;
    L13:
        r0.add(r9.getString(R.string.copy_text));
        final OInsetSheet r14 = new OInsetSheet(r9);
        final String r4 = r12;
        r1.add(new AnonymousClass6(r9, r4, r10, r11, r14));
        r14.setRootWidth(OInsetSheet.PanelWidth.NARROW_WIDTH);
        r14.setHeaderView(genHeaderView(r9, r14, r12));
        r14.setContainerView(genContentView(r9, r0, r1));
        r14.setFooterView(null);
        r14.show();
        return;
    L5:
        if (r11.length != 1) goto L13;
        if ("vnd.android.cursor.item/phone_v2".equals(r11[0]) == false) goto L13;
        r12 = r12.replaceAll(HanziToPinyin.Token.SEPARATOR, "").replaceAll("-", "");
        if (r13 == false) goto L13;
        if (DSUtils.useDSFeature() == false) goto L13;
        String r15 = DSUtils.getSimName(r9, 0);
        String r2 = DSUtils.getSimName(r9, 1);
        r0.add(r9.getString(R.string.call_by_sim, new Object[]{r15}));
        r0.add(r9.getString(R.string.call_by_sim, new Object[]{r2}));
        r1.add(new AnonymousClass4(r9, r12));
        r1.add(new AnonymousClass5(r9, r12));
        goto L13
    }

    public static void copyToClipboard(Context r3, String r4, String[] r5, String r6) {
        if (r5 != null) goto L5;
    L9:
        ((ClipboardManager) r3.getSystemService("clipboard")).setPrimaryClip(new ClipData(r4, r5, new ClipData.Item(r6)));
        Toast.makeText(r3, R.string.toast_text_copied, 0).show();
        return;
    L5:
        if (r5.length != 1) goto L9;
        if ("vnd.android.cursor.item/phone_v2".equals(r5[0]) == false) goto L9;
        r6 = r6.replaceAll(HanziToPinyin.Token.SEPARATOR, "").replaceAll("-", "");
        goto L9
    }

    private static View genContentView(Context r9, ArrayList<String> r10, ArrayList<View.OnClickListener> r11) {
        LinearLayout r0 = new LinearLayout(r9);
        r0.setOrientation(1);
        r0.setPadding(0, 0, 0, dipTopx(r9, 5.0d));
        int r3 = Math.min(r10.size(), r11.size());
        int r5 = 0;
    L3:
        if (r5 >= r3) goto L5;
        OButton r6 = (OButton) LayoutInflater.from(r9).inflate(R.layout.sheet_button_left_center_black, null);
        r6.setText(r10.get(r5));
        r6.setOnClickListener(r11.get(r5));
        r6.setWidth(dipTopx(r9, 296.0d));
        r6.setHeight(dipTopx(r9, 56.0d));
        LinearLayout.LayoutParams r7 = new LinearLayout.LayoutParams(-2, -2);
        r7.gravity = 17;
        r7.bottomMargin = dipTopx(r9, 5.0d);
        r0.addView(r6, r7);
        r5 = r5 + 1;
        goto L3
    L5:
        r0.setPadding(0, 0, 0, dipTopx(r9, 15.0d));
        return r0;
    }

    private static View genHeaderView(Context r2, final OInsetSheet r3, String r4) {
        OInsetSheetTitleBar r0 = new OInsetSheetTitleBar(r2);
        r0.setShowLeftBack(false);
        r0.setTitleText(r4);
        OButton r5 = r0.createNeutralButton(r2, r0.mRightContainer);
        r5.setButtonSourceBitmap(R.drawable.o_ic_close);
        r5.setOnClickListener(new AnonymousClass7(r3));
        return r0;
    }

    public static String getGroupName(Context r1, String r2, String r3) {
        if (LocalAccountContactsUtils.isLocalAccount(r3, r2) == false) goto L7;
        return r1.getString(R.string.local_group);
    L7:
        return getAccountName(r1, r2, r3);
    }

    public static String getAccountName(Context r1, Account r2) {
        if (r2 != null) goto L6;
        return null;
    L6:
        return getAccountName(r1, r2.type, r2.name);
    }

    public static String getAccountName(Context r2, String r3, String r4) {
        if (BytedanceAccountType.ACCOUNT_TYPE.equals(r3) == false) goto L10;
        String r5 = getBytedanceAccountName(r2);
        if (TextUtils.isEmpty(r5) == true) goto L7;
        return r5;
    L7:
        return r2.getString(R.string.local_bytedance_contact);
    L10:
        if (LocalAccountContactsUtils.isLocalAccount(r4, r3) == true) goto L12;
        return r4;
    L12:
        return r2.getString(R.string.local_bytedance_contact);
    }

    public static String getBytedanceAccountName(Context r3) {
        AccountManager r4 = AccountManager.get(r3);
        Account[] r0 = r4.getAccountsByType(BytedanceAccountType.ACCOUNT_TYPE);
        if (r0 != null) goto L5;
        return null;
    L5:
        if (r0.length == 0) goto L14;
        Account r1 = r0[0];
        String r2 = r4.getUserData(r1, "email_addr");
        if (TextUtils.isEmpty(r2) == true) goto L10;
        return r2;
    L10:
        return r4.getUserData(r1, "phone_num");
    L14:
        return null;
    }

    public static String getPinyinName(String r2) {
        if (TextUtils.isEmpty(r2) == false) goto L7;
        return "";
    L7:
        if (isChinese(r2) == false) goto L16;
        StringBuilder r0 = new StringBuilder();
        Iterator<String> r3 = ContactLocaleUtils.getInstance().getChineseNameKeys(r2);
        if (r3 == null) goto L14;
    L11:
        if (r3.hasNext() == false) goto L14;
        r0.append(r3.next());
    L14:
        return r0.toString();
    L16:
        return r2;
    }

    public static String getPinyinChineseName(String r2) {
        if (TextUtils.isEmpty(r2) == false) goto L7;
        return "";
    L7:
        if (isChinese(r2) == false) goto L16;
        StringBuilder r0 = new StringBuilder();
        Iterator<String> r3 = ContactLocaleUtils.getInstance().getPinyinChineseNameKeys(r2);
        if (r3 == null) goto L14;
    L11:
        if (r3.hasNext() == false) goto L14;
        r0.append(r3.next());
    L14:
        return r0.toString();
    L16:
        return r2;
    }

    public static String getPinyinName(String r2, ArrayList<String> r3, ArrayList<Integer> r4) {
        StringBuilder r0 = new StringBuilder();
        Iterator<String> r5 = ContactLocaleUtils.getInstance().getChineseNameKeys(r2, r3, r4);
        if (r5 == null) goto L8;
    L5:
        if (r5.hasNext() == false) goto L8;
        r0.append(r5.next());
    L8:
        return r0.toString();
    }

    public static boolean isChinese(String r5) {
        if (TextUtils.isEmpty(r5) == true) goto L22;
        int r0 = r5.length();
        int r2 = 0;
    L5:
        if (r2 >= r0) goto L22;
        Character.UnicodeBlock r3 = Character.UnicodeBlock.of(r5.charAt(r2));
        if (r3 == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS) goto L20;
        if (r3 == Character.UnicodeBlock.CJK_COMPATIBILITY_IDEOGRAPHS) goto L30;
        if (r3 == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_A) goto L31;
        if (r3 == Character.UnicodeBlock.GENERAL_PUNCTUATION) goto L32;
        if (r3 == Character.UnicodeBlock.CJK_SYMBOLS_AND_PUNCTUATION) goto L33;
        if (r3 == Character.UnicodeBlock.HALFWIDTH_AND_FULLWIDTH_FORMS) goto L34;
        r2 = r2 + 1;
        goto L5
    L34:
        return true;
    L33:
        return true;
    L32:
        return true;
    L31:
        return true;
    L30:
        return true;
    L20:
        return true;
    L22:
        return false;
    }

    public static boolean isChinese(char r1) {
        Character.UnicodeBlock r2 = Character.UnicodeBlock.of(r1);
        if (r2 != Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS) goto L5;
        return true;
    L5:
        if (r2 != Character.UnicodeBlock.CJK_COMPATIBILITY_IDEOGRAPHS) goto L7;
        return true;
    L7:
        if (r2 != Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_A) goto L9;
        return true;
    L9:
        if (r2 != Character.UnicodeBlock.GENERAL_PUNCTUATION) goto L11;
        return true;
    L11:
        if (r2 != Character.UnicodeBlock.CJK_SYMBOLS_AND_PUNCTUATION) goto L13;
        return true;
    L13:
        if (r2 == Character.UnicodeBlock.HALFWIDTH_AND_FULLWIDTH_FORMS) goto L23;
        return false;
    L23:
        return true;
    }

    public static ContentProviderResult[] runApplyBatch(ContentResolver r7, String r8, ArrayList<ContentProviderOperation> r9) {
        if (r9 != null) goto L4;
    L24:
        return null;
    L4:
        if (r9.isEmpty() == true) goto L24;
        ContentProviderResult[] r0 = new ContentProviderResult[r9.size()];
        if (r9.size() <= 400) goto L34;
        ArrayList r1 = new ArrayList();
        ArrayList r3 = new ArrayList();
    L9:
        if (r9.size() <= 0) goto L19;
        r3.clear();
        int r4 = 0;
    L11:
        if (r4 >= 400) goto L17;
        if (r9.size() == 0) goto L17;
        r3.add(r9.remove(0));
        r4 = r4 + 1;
    L17:
        if (r3.size() <= 0) goto L9;
        r1.add(directApplyBatch(r7, r8, r3));
        goto L9
    L19:
        int r10 = 0;
    L21:
        if (r10 >= r1.size()) goto L35;
        ContentProviderResult[] r11 = (ContentProviderResult[]) r1.get(r10);
        System.arraycopy(r11, 0, r0, r10 * 400, r11.length);
        r10 = r10 + 1;
        goto L21
    L35:
        return r0;
    L34:
        return directApplyBatch(r7, r8, r9);
    }

    private static ContentProviderResult[] directApplyBatch(ContentResolver r2, String r3, ArrayList<ContentProviderOperation> r4) {
        ContentProviderResult[] r5 = r2.applyBatch(r3, r4);     // Catch: Throwable -> L6 Exception -> L8
        r4.clear();
        return r5;
    L8:
        e = move-exception;
        throw new RuntimeException("Failed to store new contact, and operationsList size is : " + r4.size(), e);     // Catch: Throwable -> L6
    L6:
        th = move-exception;
        r4.clear();
        throw th;
    }

    public static boolean accountIsExist(Context r3, String r4, String r5) {
        if (TextUtils.isEmpty(r4) == true) goto L5;
    L7:
        Account[] r6 = AccountManager.get(r3).getAccountsByType(r4);
        if (r6 != null) goto L10;
        return false;
    L10:
        if (r6.length <= 0) goto L20;
        int r7 = r6.length;
        int r0 = 0;
    L12:
        if (r0 >= r7) goto L22;
        if (r6[r0].name.equals(r5) == true) goto L15;
        r0 = r0 + 1;
        goto L12
    L15:
        return true;
    L22:
        return false;
    L20:
        return false;
    L5:
        if (TextUtils.isEmpty(r5) == false) goto L7;
        return false;
    }

    public static void dumpQueryResult(Context r6, Uri r7, String r8) {
        if (r7 != null) goto L4;
        return;
    L4:
        Cursor r9 = r6.getContentResolver().query(r7, null, null, null, null);
        dumpCursor(r9, r8);
        if (r9 == null) goto L8;
        r9.close();
        return;
    }

    public static void dumpCursor(Cursor r3, String r4) {
        if (r3 != null) goto L19;
        return;
    L19:
    L15:
        th = move-exception;
        r3.moveToFirst();
        throw th;
    L5:
        if (r3.moveToFirst() == false) goto L14;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(r4, "///// dump begin; count:" + r3.getCount());     // Catch: Throwable -> L15
    L7:
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(r4, "/----- position:" + r3.getPosition());     // Catch: Throwable -> L15
        int r0 = 0;
    L9:
        if (r0 >= r3.getColumnCount()) goto L12;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(r4, "/  " + r3.getColumnName(r0) + SimContactsConstants.ANR_SEP + r3.getString(r0));     // Catch: Throwable -> L15
        r0 = r0 + 1;     // Catch: Throwable -> L15
        goto L9
    L12:
        if (r3.moveToNext() == true) goto L7;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(r4, "///// dump end");     // Catch: Throwable -> L15
    L14:
        r3.moveToFirst();
    }

    public static void deleteAllContacts(final Context r2) {
        new Thread(new AnonymousClass8(r2), "deleteAllContacts").start();
    }

    public static boolean isTopOfStack(Context r2) {
        String r3 = ((ActivityManager) r2.getSystemService("activity")).getRunningTasks(1).get(0).topActivity.getPackageName();
        if (r3 != null) goto L5;
        return false;
    L5:
        if (DEBUG == false) goto L8;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(TAG, "isTopOfStack currentPackageName:" + r3);
    L8:
        return r3.equals("com.android.contacts");
    }

    public static void setAnimatorScale(Context r2) {
        ValueAnimator.setDurationScale(Settings.Global.getFloat(r2.getContentResolver(), "animator_duration_scale", 1.0f));
    }

    public static boolean readBooleanQueryParameter(Uri r2, String r3, boolean r4) {
        String r5 = r2.getEncodedQuery();
        if (r5 != null) goto L5;
        return r4;
    L5:
        int r0 = r5.indexOf(r3);
        if (r0 != (-1)) goto L8;
        return r4;
    L8:
        int r1 = r0 + r3.length();
        if (matchQueryParameter(r5, r1, "=0", false) == false) goto L11;
        return false;
    L11:
        if (matchQueryParameter(r5, r1, "=false", true) == false) goto L13;
        return false;
    L13:
        return true;
    }

    private static boolean matchQueryParameter(String r7, int r8, String r9, boolean r10) {
        int r6 = r9.length();
        if (r7.regionMatches(r10, r8, r9, 0, r6) == false) goto L9;
        int r11 = r8 + r6;
        if (r7.length() != r11) goto L7;
    L8:
        return true;
    L7:
        if (r7.charAt(r11) == '&') goto L8;
    L9:
        return false;
    }

    public static boolean isExistInList(List<String> r3, String r4) {
        if (r3 == null) goto L12;
        Iterator<String> r1 = r3.iterator();
    L6:
        if (r1.hasNext() == false) goto L11;
        if (PhoneNumberUtils.compare(r1.next(), r4) == false) goto L6;
        return true;
    L11:
        r3.add(r4);
    L12:
        return false;
    }

    public static byte[] InputStreamToByte(InputStream r3) throws IOException {
        ByteArrayOutputStream r0 = new ByteArrayOutputStream();
    L12:
        int r1 = r3.read();     // Catch: Throwable -> L9
        if (r1 == (-1)) goto L6;
        r0.write(r1);     // Catch: Throwable -> L9
        goto L12
    L6:
        byte[] r4 = r0.toByteArray();     // Catch: Throwable -> L9
        r0.close();
        return r4;
    L9:
        th = move-exception;
        r0.close();
        throw th;
    }

    public static SamContact generateIfFamilyNameNeedPolyphone(SamContact r6) {
        if (r6.hasname == false) goto L23;
        boolean r2 = false;
        String[] r0 = PinyinHelper.getPolyphonyFamilyName(r6.name.charAt(0));
        if (r0 == null) goto L23;
        boolean r4 = true;
        if (1 != r0.length) goto L11;
        r6.sortkey = r6.sortkey.replaceFirst(r6.sortkey.split(HanziToPinyin.Token.SEPARATOR)[0], r0[0]);
        r6.section = getContactSection(r6.sortkey);
        return null;
    L11:
        if (2 != r0.length) goto L23;
        SamContact r7 = r6.getCopy();
        String r3 = r0[0];
        String r1 = r0[1];
        if (r7.sortkey.startsWith(r3) == false) goto L15;
        r7.sortkey = r7.sortkey.replaceFirst(r3, r1);
        r2 = true;
    L15:
        if (r2 == false) goto L17;
    L19:
        r4 = r2;
    L20:
        if (r4 == false) goto L23;
        r7.section = getContactSection(r7.sortkey);
        return r7;
    L17:
        if (r7.sortkey.startsWith(r1) == false) goto L19;
        r7.sortkey = r7.sortkey.replaceFirst(r1, r3);
    L23:
        return null;
    }

    public static int getEventTypeResource(Integer r3) {
        if (r3 != null) goto L6;
        return R.string.common_other;
    L6:
        if (4 != r3.intValue()) goto L9;
        return R.string.event_type_birthday_lunar;
    L9:
        int r4 = r3.intValue();
        if (r4 != 1) goto L12;
        return R.string.editor_event_type_anniversary;
    L12:
        if (r4 != 2) goto L14;
        return R.string.common_other;
    L14:
        if (r4 == 3) goto L17;
        return R.string.common_custom;
    L17:
        return R.string.common_birthday;
    }

    public static void updateDateAndTimeFormat() {
        ContactsApplication r0 = ContactsApplication.getInstance();
        mDateFormat = DateUtils.getDateFormat(r0);
        mTimeFormat = android.text.format.DateFormat.getTimeFormat(r0);
    }

    public static DateFormat getDateFormat() {
        if (mDateFormat != null) goto L6;
        updateDateAndTimeFormat();
    L6:
        return mDateFormat;
    }

    public static DateFormat getTimeFormat() {
        if (mTimeFormat != null) goto L6;
        updateDateAndTimeFormat();
    L6:
        return mTimeFormat;
    }

    public static int getThumbnailSize(Context r8) {
        if (sThumbnailSize != (-1)) goto L11;
        Cursor r9 = r8.getContentResolver().query(ContactsContract.DisplayPhoto.CONTENT_MAX_DIMENSIONS_URI, new String[]{"thumbnail_max_dim"}, null, null, null);
        r9.moveToFirst();     // Catch: Throwable -> L7
        sThumbnailSize = r9.getInt(0);     // Catch: Throwable -> L7
        r9.close();
    L7:
        th = move-exception;
        r9.close();
        throw th;
    L11:
        return sThumbnailSize;
    }

    public static void showSelectSimDialog(Context r1, String r2, String r3, int r4) {
        showSelectSimDialog(r1, r2, r3, r4, false);
    }

    public static void showSelectSimDialog(Context r6, String r7, String r8, int r9, boolean r10) {
        showSelectSimDialog(r6, r7, r8, r9, r10, false);
    }

    public static void showSelectSimDialog(final Context r10, String r11, final String r12, int r13, final boolean r14, final boolean r15) {
        final OInsetSheet r6 = new OInsetSheet(r10);
        ArrayList r7 = new ArrayList(2);
        ArrayList r8 = new ArrayList(2);
        String r2 = DSUtils.getSimName(r10, 0);
        String r4 = DSUtils.getSimName(r10, 1);
        if (r13 != 1) goto L5;
        r7.add(r10.getString(R.string.call_by_sim, new Object[]{r2}));
        r7.add(r10.getString(R.string.call_by_sim, new Object[]{r4}));
        r8.add(new AnonymousClass9(r6, r10, r12, r14, r15));
        r8.add(new AnonymousClass10(r6, r10, r12, r14, r15));
    L19:
        if (TextUtils.isEmpty(r11) == false) goto L21;
        r11 = r12;
    L21:
        r6.setRootWidth(OInsetSheet.PanelWidth.NARROW_WIDTH);
        r6.setHeaderView(getSelectSimHeaderView(r10, r6, r11));
        r6.setContainerView(getSelectSimContentView(r10, r7, r8));
        r6.setFooterView(null);
        r6.show();
        return;
    L5:
        if (r13 != 2) goto L8;
        r7.add(r10.getString(R.string.send_message_by_sim, new Object[]{r2}));
        r7.add(r10.getString(R.string.send_message_by_sim, new Object[]{r4}));
        r8.add(new AnonymousClass11(r6, r10, r12));
        r8.add(new AnonymousClass12(r6, r10, r12));
        goto L19
    L8:
        if (r13 != 3) goto L19;
        final boolean r16 = !TextUtils.isEmpty(DSUtils.getVoiceMailNumber(0));
        final boolean r17 = !TextUtils.isEmpty(DSUtils.getVoiceMailNumber(1));
        int r18 = R.string.voice_mail_call_by_sim;
        if (r16 == false) goto L12;
        int r5 = R.string.voice_mail_call_by_sim;
    L13:
        r7.add(r10.getString(r5, new Object[]{r2}));
        if (r17 == true) goto L17;
        r18 = R.string.set_voice_mail_call_by_sim;
    L17:
        r7.add(r10.getString(r18, new Object[]{r4}));
        r8.add(new AnonymousClass13(r6, r16, r10));
        r8.add(new AnonymousClass14(r6, r17, r10));
        goto L19
    L12:
        r5 = R.string.set_voice_mail_call_by_sim;
        goto L13
    }

    private static View getSelectSimContentView(Context r9, ArrayList<String> r10, ArrayList<View.OnClickListener> r11) {
        LinearLayout r0 = new LinearLayout(r9);
        r0.setOrientation(1);
        r0.setPadding(0, dipTopx(r9, 5.0d), 0, dipTopx(r9, 5.0d));
        int r3 = Math.min(r10.size(), r11.size());
        int r4 = 0;
    L3:
        if (r4 >= r3) goto L5;
        OButton r6 = (OButton) LayoutInflater.from(r9).inflate(R.layout.sheet_button_left_center_black, null);
        r6.setText(r10.get(r4));
        r6.setOnClickListener(r11.get(r4));
        r6.setWidth(dipTopx(r9, 296.0d));
        r6.setHeight(dipTopx(r9, 56.0d));
        LinearLayout.LayoutParams r7 = new LinearLayout.LayoutParams(-2, -2);
        r7.gravity = 17;
        r7.bottomMargin = dipTopx(r9, 5.0d);
        r0.addView(r6, r7);
        r4 = r4 + 1;
        goto L3
    L5:
        r0.setPadding(0, 0, 0, dipTopx(r9, 15.0d));
        return r0;
    }

    private static View getSelectSimHeaderView(Context r2, final OInsetSheet r3, String r4) {
        if (TextUtils.isEmpty(r4) == false) goto L6;
        return null;
    L6:
        OInsetSheetTitleBar r0 = new OInsetSheetTitleBar(r2);
        r0.setShowLeftBack(false);
        r0.setTitleText(r4);
        OButton r5 = r0.createNeutralButton(r2, r0.mRightContainer);
        r5.setButtonSourceBitmap(R.drawable.o_ic_close);
        r5.setOnClickListener(new AnonymousClass15(r3));
        return r0;
    }

    private static void addVoiceMailNumberPanel(Context r2, int r3) {
        if (r2 != null) goto L4;
        return;
    L4:
        Intent r0 = new Intent("com.android.phone.CallFeaturesSetting.ADD_VOICEMAIL");
        r0.putExtra("slot", r3);
        r0.setClassName(TelephonySmt.DEFAULT_NOTIFICATION_PACKAGE_NAME, "com.bytedanceos.phone.settings.settings.VoiceMailSetting");
        r0.putExtra("back_style", 1);
        r2.startActivity(r0);     // Catch: ActivityNotFoundException -> L7
        return;
    L7:
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_e(TAG, "launch VoiceMailSetting failed");
    }

    public static boolean contactsWithPhoneOnly(Context r5) {
        ContentResolver r1 = r5.getContentResolver();
        int r6 = Settings.Global.getInt(r1, "list_contacts_with_phones_only");     // Catch: Settings.SettingNotFoundException -> L5
    L7:
        if (r6 == 1) goto L9;
        return false;
    L9:
        return true;
    L5:
        SharedPreferences r7 = PreferenceManager.getDefaultSharedPreferences(r5);
        boolean r4 = r7.getBoolean("HAS_PHONE_NUM", false);
        r7.edit().remove("HAS_PHONE_NUM").commit();
        Settings.Global.putInt(r1, "list_contacts_with_phones_only", r4 ? 1 : 0);
        r6 = r4 ? 1 : 0;
        goto L7
    }

    public static boolean isFeaturePhoneMode() {
        PowerManager r0 = (PowerManager) ContactsApplication.getInstance().getSystemService("power");
        return PowerManagerSmt.getInstance().isFeaturePhoneMode(r0);
    }

    public static boolean inPowerSaveWhiteList(String r1) {
        return sPowerSaveWhiteList.contains(r1);
    }

    public static boolean inPowerSaveWhiteList(Context r4, Intent r5) {
        String r0 = r5.getPackage();
        if (TextUtils.isEmpty(r0) == false) goto L8;
        ComponentName r1 = r5.getComponent();
        if (r1 == null) goto L8;
        r0 = r1.getPackageName();
    L8:
        if (TextUtils.isEmpty(r0) == false) goto L10;
        List<ResolveInfo> r6 = r4.getPackageManager().queryIntentActivities(r5, 1);
        if (r6 != null) goto L15;
    L28:
        return false;
    L15:
        if (r6.size() == 0) goto L28;
        Iterator<ResolveInfo> r7 = r6.iterator();
    L19:
        if (r7.hasNext() == false) goto L27;
        ResolveInfo r8 = r7.next();
        if (r8.activityInfo != null) goto L23;
        String r9 = null;
    L25:
        if (inPowerSaveWhiteList(r9) == true) goto L19;
        return false;
    L23:
        r9 = r8.activityInfo.packageName;
    L27:
        return true;
    L10:
        if (inPowerSaveWhiteList(r0) == true) goto L27;
        return false;
    }

    public static boolean isFeatureUSEnabled() {
        if (isFeatureUS != null) goto L6;
        isFeatureUS = Features.isFeatureUSEnabled(ContactsApplication.getInstance());
    L6:
        return isFeatureUS.booleanValue();
    }

    public static boolean isSingleSimVtCapable() {
        ContactsTelephonyUtil r0 = ContactsApplication.getInstance().getTelephonyUtil();
        if (r0.isDualVolteSupport() == false) goto L12;
        boolean r1 = r0.isVtCapableForSlot(0);
        boolean r2 = r0.isVtCapableForSlot(1);
        if (r1 == true) goto L7;
        if (r2 == true) goto L7;
    L10:
        return false;
    L7:
        if (r1 == false) goto L11;
        if (r2 == true) goto L10;
    L11:
        return true;
    L12:
        return false;
    }

    public static int getSingleVtCapableSimCardId() {
        if (isSingleSimVtCapable() == false) goto L11;
        ContactsTelephonyUtil r0 = ContactsApplication.getInstance().getTelephonyUtil();
        if (r0.isVtCapableForSlot(0) == false) goto L8;
        return 0;
    L8:
        if (r0.isVtCapableForSlot(1) == false) goto L11;
        return 1;
    L11:
        if (DEBUG == false) goto L14;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_e(TAG, "not single sim card volte enabled");
    L14:
        return DSUtils.getDefaultCallSim();
    }

    public static boolean isFeatureDomestic() {
        return Features.isFeatureDomestic(ContactsApplication.getInstance());
    }

    public static ArrayList<String> getSimNumber(Context r2) {
        ArrayList<String> r0 = new ArrayList();
        if (DSUtils.useDSFeature() == false) goto L5;
        addSimNumber(DSUtils.getSimNumber(r2, 0), r0);
        addSimNumber(DSUtils.getSimNumber(r2, 1), r0);
    L6:
        return r0;
    L5:
        addSimNumber(((TelephonyManager) r2.getSystemService("phone")).getLine1Number(), r0);
        goto L6
    }

    private static void addSimNumber(String r1, ArrayList<String> r2) {
        if (isFeatureUSEnabled() == true) goto L10;
        if (TextUtils.isEmpty(r1) == true) goto L10;
        if (r1.startsWith("+86") == false) goto L10;
        r1 = r1.substring(3).trim();
    L10:
        if (TextUtils.isEmpty(r1) == true) goto L13;
        r2.add(r1);
        return;
    }

    public static int getNetworkType(Context r1) {
        NetworkInfo r2 = ((ConnectivityManager) r1.getSystemService("connectivity")).getActiveNetworkInfo();
        if (r2 != null) goto L5;
        return -1;
    L5:
        if (r2.isConnected() == true) goto L7;
        return -1;
    L7:
        return r2.getType();
    }

    public static boolean isNetworkConnected(Context r1) {
        NetworkInfo r2 = ((ConnectivityManager) r1.getSystemService("connectivity")).getActiveNetworkInfo();
        if (r2 != null) goto L5;
        return false;
    L5:
        if (r2.isConnected() == false) goto L10;
        return true;
    L10:
        return false;
    }

    public static void showRightSwipeToast() {
        ContactsApplication.showToast(R.string.toast_swipe_right, 0);
    }

    public static void launchCompanySearch(Activity r10, Intent r11) {
        boolean r1 = DEBUG;
        if (r1 == false) goto L6;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(TAG, "do ScpSDK.LaunchCompanySearch");
    L6:
        if (isFeatureDomestic() == true) goto L8;
        return;
    L8:
        CamCardSearchParam r12 = (CamCardSearchParam) r11.getParcelableExtra(CAM_CARD_COMPANY_PARAM);
        if (r10 == null) goto L24;
        if (r12 == null) goto L24;
        if (r12.isValid() == false) goto L24;
        int r13 = ScpSDK.LaunchCompanySearch(r10, r12.getCompany(), r12.getJobTitle(), r12.getName(), r12.getEmail(), r12.getPhone());     // Catch: Exception -> L21
        if (r1 == false) goto L18;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(TAG, "ScpSDK.LaunchCompanySearch return: " + r13);     // Catch: Exception -> L21
    L18:
        if (r13 != (-1)) goto L28;
        ComponentName r14 = new ComponentName("com.obric.appstore", "com.bytedanceos.appstore.AppStoreActivity");     // Catch: Exception -> L21
        Intent r2 = new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=com.intsig.BizCardReader"));     // Catch: Exception -> L21
        r2.addFlags(268435456);     // Catch: Exception -> L21
        r2.setComponent(r14);     // Catch: Exception -> L21
        r10.startActivity(r2);     // Catch: Exception -> L21
        return;
    L28:
        return;
    L21:
        e = move-exception;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(TAG, "ScpSDK.LaunchCompanySearch occurred exception.");
        e.printStackTrace();
        return;
    L24:
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_e(TAG, "searchParam is invalid");
    }

    public static boolean getBtnInContactsEnabled() {
        if (Settings.Global.getInt(ContactsApplication.getInstance().getContentResolver(), "contacts_voice_search_btn_enabled", 0) == 1) goto L5;
        return false;
    L5:
        return true;
    }

    private static int getClickVoiceBtnCount() {
        return PreferenceManager.getDefaultSharedPreferences(ContactsApplication.getInstance()).getInt("click_voice_btn_count", 0);
    }

    private static void increaseClickVoiceBtnCount() {
        SharedPreferences r0 = PreferenceManager.getDefaultSharedPreferences(ContactsApplication.getInstance());
        int r1 = r0.getInt("click_voice_btn_count", 0);
        r0.edit().putInt("click_voice_btn_count", r1 + 1).commit();
    }

    public static boolean showToastForClickVoiceBtn() {
        if (getClickVoiceBtnCount() != 0) goto L6;
        increaseClickVoiceBtnCount();
        return false;
    L6:
        return true;
    }

    public static boolean isVoiceSearchEnabled() {
        if (isFeatureDomestic() == true) goto L6;
        return false;
    L6:
        if (sVoiceEnabled == true) goto L9;
        return false;
    L9:
        if (getBtnInContactsEnabled() == true) goto L12;
        return false;
    L12:
        if (ContactsApplication.getInstance().getResources().getConfiguration().locale.getLanguage().endsWith("zh") == true) goto L14;
        return false;
    L14:
        return true;
    }

    public static void setHasContact(boolean r0) {
        mHasContact = r0;
    }

    public static boolean hasContacts() {
        return mHasContact;
    }

    public static boolean isBytedanceServiceContact(Context r9, long r10) {
        boolean r0 = false;
        if (r9 != null) goto L5;
        return false;
    L5:
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(TAG, "to tracing the bug of 0110778");
        Cursor r11 = r9.getContentResolver().query(Uri.withAppendedPath(ContactsContract.AUTHORITY_URI, "bytedance_service_rawcontact"), new String[]{"_id"}, null, null, null);
        if (r11 != null) goto L20;
    L17:
        if (r11 == null) goto L19;
        r11.close();
    L19:
        return r0;
    L20:
    L13:
        th = move-exception;
        if (r11 == null) goto L16;
        r11.close();
    L16:
        throw th;
    L8:
        if (r11.moveToFirst() == false) goto L17;
        if (r10 != r11.getInt(0)) goto L17;
        r0 = true;
        goto L17
    }

    public static boolean isOnlyIncludeProfile(ArrayList<SamContact> r3) {
        if (r3 != null) goto L5;
        return false;
    L5:
        if (r3.size() == 2) goto L7;
        return false;
    L7:
        if (r3.get(0).getType() == 1) goto L9;
        return false;
    L9:
        if (r3.get(1).getType() == 3) goto L11;
        return false;
    L11:
        return true;
    }

    public static void checkIfRecordDeleted(Context r18, long r19, String r21) {
        if (TextUtils.isEmpty(r21) == true) goto L57;
        String r8 = "_id IN (" + r21 + ")";
        ArrayList r11 = new ArrayList(Arrays.asList(r21.split(SimContactsConstants.EMAIL_SEP)));
        Cursor r2 = null;
        Cursor r5 = r18.getContentResolver().query(Uri.parse("content://com.obric.recorder.provider/recorderentry/recorder_files"), new String[]{"_id", "duration"}, r8, null, null);     // Catch: Throwable -> L42 Exception -> L44
        int r6 = 0;
        if (r5 != null) goto L64;
    L17:
        String[] r7 = new String[0];     // Catch: Throwable -> L11 Exception -> L14
        Cursor r9 = r18.getContentResolver().query(ContentUris.withAppendedId(CallLog.Calls.CONTENT_URI, r19), new String[]{"record_uri"}, null, null, null);     // Catch: Throwable -> L11 Exception -> L14
        if (r9 != null) goto L62;
    L24:
        String r10 = null;
    L25:
        ArrayList r12 = new ArrayList();     // Catch: Throwable -> L38 Exception -> L40
        int r13 = r7.length;     // Catch: Throwable -> L38 Exception -> L40
    L26:
        if (r6 >= r13) goto L31;
        String r14 = r7[r6];     // Catch: Throwable -> L38 Exception -> L40
        if (r11.contains(r14) == true) goto L30;
        r12.add(r14);     // Catch: Throwable -> L38 Exception -> L40
    L30:
        r6 = r6 + 1;     // Catch: Throwable -> L38 Exception -> L40
        goto L26
    L31:
        String r4 = TextUtils.join(SimContactsConstants.EMAIL_SEP, r12);     // Catch: Throwable -> L38 Exception -> L40
        if (r4.equals(r10) == true) goto L34;
        ContentValues r15 = new ContentValues();     // Catch: Throwable -> L38 Exception -> L40
        r15.put("record_uri", r4);     // Catch: Throwable -> L38 Exception -> L40
        r18.getContentResolver().update(ContentUris.withAppendedId(CallLog.Calls.CONTENT_URI, r19), r15, null, null);     // Catch: Throwable -> L38 Exception -> L40
    L40:
        e = e;
    L16:
        r2 = r5;
    L58:
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_e(TAG, "checkIfRecordDeleted exception: " + e.getMessage());     // Catch: Throwable -> L51
        if (r2 == null) goto L49;
        r2.close();
    L49:
        if (r9 == null) goto L71;
    L50:
        r9.close();
        return;
    L71:
        return;
    L51:
        th = th;
    L52:
        if (r2 == null) goto L54;
        r2.close();
    L54:
        if (r9 == null) goto L56;
        r9.close();
    L56:
        throw th;
    L38:
        th = th;
    L13:
        r2 = r5;
    L34:
        if (r5 == null) goto L36;
        r5.close();
    L36:
        if (r9 != null) goto L50;
        return;
    L62:
        if (r9.moveToFirst() == false) goto L24;
        r10 = r9.getString(0);     // Catch: Throwable -> L38 Exception -> L40
        if (TextUtils.isEmpty(r10) == true) goto L25;
        r7 = r10.split(SimContactsConstants.EMAIL_SEP);     // Catch: Throwable -> L38 Exception -> L40
        goto L25
    L14:
        e = e;
        r9 = null;
    L11:
        th = th;
        r9 = null;
    L64:
        if (r5.moveToNext() == false) goto L17;
        r11.remove(String.valueOf(r5.getLong(0)));     // Catch: Throwable -> L11 Exception -> L14
        goto L64
    L44:
        e = e;
        r9 = null;
    L42:
        th = th;
        r9 = null;
        goto L52
    }

    public static String checkIfRecordExists(Context r20, long r21, String r23) {
        if (TextUtils.isEmpty(r23) == true) goto L49;
        String r5 = r23;
        String r9 = "_id IN (" + r5 + ")";
        StringBuilder r4 = new StringBuilder();
        StringBuilder r12 = new StringBuilder();
        Cursor r13 = null;
        Cursor r6 = r20.getContentResolver().query(Uri.parse("content://com.obric.recorder.provider/recorderentry/recorder_files"), new String[]{"_id", "duration"}, r9, null, null);     // Catch: Throwable -> L40
        if (r6 == null) goto L21;
        boolean r10 = true;
    L9:
        if (r6.moveToNext() == false) goto L20;
        long r11 = r6.getLong(0);     // Catch: Throwable -> L40
        if (r10 == true) goto L13;
        r4.append(SimContactsConstants.EMAIL_SEP);     // Catch: Throwable -> L40
        if (r6.getLong(1) <= 0) goto L19;
        r12.append(SimContactsConstants.EMAIL_SEP);     // Catch: Throwable -> L40
        r12.append(r11);     // Catch: Throwable -> L40
    L19:
        r4.append(r11);     // Catch: Throwable -> L40
        goto L9
    L13:
        if (r6.getLong(1) <= 0) goto L15;
        r12.append(r11);     // Catch: Throwable -> L40
    L15:
        r10 = false;
        goto L19
    L20:
        r6.close();     // Catch: Throwable -> L40
    L21:
        String r3 = r4.toString();     // Catch: Throwable -> L40
        Cursor r7 = r20.getContentResolver().query(ContentUris.withAppendedId(CallLog.Calls.CONTENT_URI, r21), new String[]{"record_uri"}, null, null, null);     // Catch: Throwable -> L38
        if (r7 != null) goto L52;
    L29:
        String r8 = null;
    L30:
        if (r8 != null) goto L32;
    L33:
        ContentValues r14 = new ContentValues();     // Catch: Throwable -> L27
        r14.put("record_uri", r3);     // Catch: Throwable -> L27
        r20.getContentResolver().update(ContentUris.withAppendedId(CallLog.Calls.CONTENT_URI, r21), r14, null, null);     // Catch: Throwable -> L27
    L34:
        String r0 = r12.toString();     // Catch: Throwable -> L27
        if (r7 == null) goto L62;
        r7.close();
    L62:
        return r0;
    L27:
        th = th;
        r5 = r3;
        r13 = r7;
    L56:
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_e(TAG, "checkIfRecordExists exception: " + th.getMessage());     // Catch: Throwable -> L44
        if (r13 == null) goto L63;
        r13.close();
        return r5;
    L63:
        return r5;
    L44:
        th = move-exception;
        if (r13 == null) goto L47;
        r13.close();
    L47:
        throw th;
    L32:
        if (r8.equals(r3) == true) goto L34;
    L52:
        if (r7.moveToFirst() == false) goto L29;
        r8 = r7.getString(0);     // Catch: Throwable -> L27
    L38:
        th = th;
        r5 = r3;
    L40:
        th = th;
        goto L56
    L49:
        return r23;
    }

    public static Intent getViewRecordIntent(String r4) {
        Intent r0 = new Intent();
        if (TextUtils.isEmpty(r4) == false) goto L5;
    L17:
        r0.putExtra(com.obric.contacts.Constants.get_EXTRA_BYTEDANCE_ANIM_RESOURCE_ID(), new int[]{0, R.anim.slide_down_out});
        r0.putExtra("RECORD_URI", r4);
        return r0;
    L5:
        if (checkRecordFilesIfExists(r4) == false) goto L7;
        String[] r1 = r4.split(SimContactsConstants.EMAIL_SEP);
        if (r1.length != 1) goto L15;
        r0.setAction("bytedance.action.VIEW_SINGLE_RECORD");
        goto L17
    L15:
        if (r1.length <= 1) goto L17;
        r0.setAction("bytedance.action.VIEW_RECORD");
        goto L17
    L7:
        if (DEBUG == false) goto L9;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(TAG, "record files of id " + r4 + " are gone, just return");
    L9:
        ContactsApplication.showToast(R.string.recorder_file_not_exist, 0);
        return null;
    }

    private static boolean checkRecordFilesIfExists(String r8) {
        if (TextUtils.isEmpty(r8) == true) goto L28;
        Cursor r1 = null;
        Uri r3 = Uri.parse("content://com.obric.recorder.provider/recorderentry/recorder_files");     // Catch: Throwable -> L20
        r1 = ContactsApplication.getInstance().getContentResolver().query(r3, new String[]{"_id", "path"}, "_id IN (" + r8 + ")", null, null);     // Catch: Throwable -> L20
        if (r1 != null) goto L8;
    L18:
        if (r1 == null) goto L42;
    L23:
        r1.close();
        return false;
    L42:
        return false;
    L8:
        if (r1.moveToNext() == false) goto L18;
        String r0 = r1.getString(1);     // Catch: Throwable -> L20
        if (TextUtils.isEmpty(r0) == true) goto L8;
        File r2 = new File(r0);     // Catch: Throwable -> L20
        if (r2.isFile() == false) goto L8;
        if (r2.exists() == false) goto L8;
        if (r1 == null) goto L17;
        r1.close();
    L17:
        return true;
    L20:
        th = move-exception;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_e(TAG, "checkRecordFilesIfExists exception: " + th.getMessage());     // Catch: Throwable -> L24
        if (r1 != null) goto L23;
        return false;
    L24:
        th = move-exception;
        if (r1 == null) goto L27;
        r1.close();
    L27:
        throw th;
    L28:
        return false;
    }

    private static SharedPreferences getEmergencyContactPreferences(Context r2) {
        return r2.createDeviceProtectedStorageContext().getSharedPreferences(EMERGENCY_CONTACT_PREFS, 0);
    }

    public static void migrateEmergencyContactToSharedPreferences(Context r10) {
        SharedPreferences r0 = getEmergencyContactPreferences(r10);
        if (r0.getBoolean(EMERGENCY_CONTACT_MIGRATED, false) == false) goto L5;
        return;
    L5:
        ContentResolver r11 = r10.getContentResolver();
        String r3 = Settings.System.getString(r11, SETTINGS_CONTACTS_EMERGENCY_PHONE_DATA_URI);
        String r5 = Settings.System.getString(r11, SETTINGS_CONTACTS_EMERGENCY_NAME);
        String r7 = Settings.System.getString(r11, SETTINGS_CONTACTS_EMERGENCY_NUMBER);
        SharedPreferences.Editor r1 = r0.edit();
        if (TextUtils.isEmpty(r3) == true) goto L9;
        r1.putString(SETTINGS_CONTACTS_EMERGENCY_PHONE_DATA_URI, r3);
        Settings.System.putString(r11, SETTINGS_CONTACTS_EMERGENCY_PHONE_DATA_URI, null);
    L9:
        if (TextUtils.isEmpty(r5) == true) goto L12;
        r1.putString(SETTINGS_CONTACTS_EMERGENCY_NAME, r5);
        Settings.System.putString(r11, SETTINGS_CONTACTS_EMERGENCY_NAME, null);
    L12:
        if (TextUtils.isEmpty(r7) == true) goto L14;
        r1.putString(SETTINGS_CONTACTS_EMERGENCY_NUMBER, r7);
        Settings.System.putString(r11, SETTINGS_CONTACTS_EMERGENCY_NUMBER, null);
    L14:
        r1.putBoolean(EMERGENCY_CONTACT_MIGRATED, true);
        r1.apply();
    }

    public static Uri getEmergencyContactPhoneUri(Context r2) {
        migrateEmergencyContactToSharedPreferences(r2);
        String r3 = getEmergencyContactPreferences(r2).getString(SETTINGS_CONTACTS_EMERGENCY_PHONE_DATA_URI, null);
        if (TextUtils.isEmpty(r3) == false) goto L6;
        return null;
    L6:
        return Uri.parse(r3);
    }

    public static void setEmergencyContactPhoneUri(Context r1, Uri r2) {
        migrateEmergencyContactToSharedPreferences(r1);
        if (r2 != null) goto L5;
        String r3 = "";
    L6:
        getEmergencyContactPreferences(r1).edit().putString(SETTINGS_CONTACTS_EMERGENCY_PHONE_DATA_URI, r3).apply();
        return;
    L5:
        r3 = r2.toString();
        goto L6
    }

    public static void setEmergencyContactInfos(Context r1, String r2, String r3) {
        migrateEmergencyContactToSharedPreferences(r1);
        if (r3 != null) goto L5;
        r3 = "";
    L5:
        SharedPreferences.Editor r4 = getEmergencyContactPreferences(r1).edit();
        if (TextUtils.isEmpty(r2) == false) goto L9;
        r2 = r3;
    L9:
        r4.putString(SETTINGS_CONTACTS_EMERGENCY_NAME, r2).putString(SETTINGS_CONTACTS_EMERGENCY_NUMBER, r3).apply();
    }

    public static ContentValues getEmergencyContactInfos(Context r9) {
        migrateEmergencyContactToSharedPreferences(r9);
        Uri r1 = getEmergencyContactPhoneUri(r9);
        if (r1 != null) goto L5;
        return null;
    L5:
        Cursor r0 = r9.getContentResolver().query(r1, new String[]{"display_name", "data1"}, null, null, null);
        if (r0 != null) goto L31;
        ContentValues r2 = null;
    L17:
        if (r2 != null) goto L30;
        SharedPreferences r10 = getEmergencyContactPreferences(r9);
        String r3 = r10.getString(SETTINGS_CONTACTS_EMERGENCY_NAME, null);
        String r11 = r10.getString(SETTINGS_CONTACTS_EMERGENCY_NUMBER, null);
        if (TextUtils.isEmpty(r3) == true) goto L21;
    L22:
        r2 = new ContentValues();
        if (TextUtils.isEmpty(r3) == false) goto L26;
        r3 = r11;
    L26:
        r2.put("display_name", r3);
        if (r11 != null) goto L29;
        r11 = "";
    L29:
        r2.put("data1", r11);
        goto L30
    L21:
        if (TextUtils.isEmpty(r11) == false) goto L22;
    L30:
        return r2;
    L31:
    L13:
        th = move-exception;
        r0.close();
        throw th;
    L8:
        if (r0.moveToFirst() == false) goto L11;
        r2 = new ContentValues();     // Catch: Throwable -> L13
        r2.put("display_name", r0.getString(0));     // Catch: Throwable -> L13
        r2.put("data1", r0.getString(1));     // Catch: Throwable -> L13
    L12:
        r0.close();
        goto L17
    L11:
        r2 = null;
        goto L12
    }

    public static boolean isChineseLocale() {
        Locale r0 = Locale.getDefault();
        if (Locale.SIMPLIFIED_CHINESE.equals(r0) == false) goto L5;
    L8:
        return true;
    L5:
        if (Locale.TRADITIONAL_CHINESE.equals(r0) == true) goto L8;
        return false;
    }

    public static boolean isFuzzyTonesEnabled() {
        if (isChineseLocale() == true) goto L5;
        return false;
    L5:
        if (Settings.Global.getInt(ContactsApplication.getInstance().getContentResolver(), "fuzzy_tones_enabled", 0) == 1) goto L7;
        return false;
    L7:
        return true;
    }

    public static boolean isFeatureRTLDualSim() {
        if (isFeatureRTLDualSim != null) goto L9;
        if (ProductUtils.isSim1InLeft() == false) goto L7;
        isFeatureRTLDualSim = false;
        goto L9
    L7:
        isFeatureRTLDualSim = true;
    L9:
        return isFeatureRTLDualSim.booleanValue();
    }

    public static File getExternalSdcardDirectory() {
        String r0 = getExternalSdcardPath();
        if (TextUtils.isEmpty(r0) == false) goto L5;
        return null;
    L5:
        File r1 = new File(r0);
        if (r1.exists() == true) goto L8;
    L12:
        return null;
    L8:
        if (r1.isDirectory() == false) goto L12;
        if (r1.canRead() == false) goto L12;
        return r1;
    }

    public static String getExternalSdcardExportDirectoryPath() {
        String r0 = getExternalSdcardPath();
        if (TextUtils.isEmpty(r0) == false) goto L5;
        return null;
    L5:
        String r1 = r0 + "/bytedance/contact";
        File r2 = new File(r1);
        if (r2.exists() == false) goto L12;
        if (r2.isDirectory() == false) goto L12;
        if (r2.canRead() == false) goto L12;
    L14:
        return r1;
    L12:
        if (r2.mkdirs() == true) goto L14;
        return null;
    }

    public static String getExternalSdcardPath() {
        IStorageManager r2 = IStorageManager.Stub.asInterface(ServiceManager.getService("mount"));     // Catch: RemoteException -> L21
        if (r2 != null) goto L7;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_e(TAG, "mount service is not initialized!");     // Catch: RemoteException -> L21
        return "";
    L7:
        int r3 = UserHandle.myUserId();     // Catch: RemoteException -> L21
        int r4 = 0;
        VolumeInfo[] r5 = r2.getVolumes(0);     // Catch: RemoteException -> L21
    L9:
        if (r4 >= r5.length) goto L32;
        VolumeInfo r6 = r5[r4];     // Catch: RemoteException -> L21
        String r7 = r6.getDiskId();     // Catch: RemoteException -> L21
        if (r7 == null) goto L20;
        if (r6.isVisibleForWrite(r3) == false) goto L20;
        if (r6.getState() != 2) goto L20;
        if (r7.startsWith("disk:179") == false) goto L20;
        return r6.getPathForUser(r3).getAbsolutePath();
    L20:
        r4 = r4 + 1;
        goto L9
    L32:
        return "";
    L21:
        e = move-exception;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_e(TAG, "RemoteException when getExternalStoragePath:" + e);
        return "";
    }

    public static boolean isUnknownLocation(String r1) {
        if (TextUtils.isEmpty(r1) == false) goto L7;
        return true;
    L7:
        return UNKNOWN_CITY_LIST.contains(r1.trim());
    }

    public static String getUnknownLocationLabel() {
        ContactsApplication r0 = ContactsApplication.getInstance();
        String r1 = ((TelephonyManager) r0.getSystemService("phone")).getNetworkCountryIso();
        if (TextUtils.isEmpty(r1) == true) goto L10;
        if (RegionConstants.REGION.equalsIgnoreCase(r1) == true) goto L10;
        return String.format("%s %s", new Object[]{r0.getString(R.string.china_country), r0.getString(R.string.unknown_location)});
    L10:
        return r0.getString(R.string.unknown_location);
    }

    public static String getUnknownCountryIso() {
        return ((TelephonyManager) ContactsApplication.getInstance().getSystemService("phone")).getNetworkCountryIso();
    }

    public static boolean isBytedanceCloudExist() {
        ContactsApplication.getInstance().getPackageManager().getApplicationInfo(Constants.CLOUDSYNC_PACKAGE_NAME, 8192);     // Catch: PackageManager.NameNotFoundException -> L5
        return true;
    L5:
        e = move-exception;
        e.printStackTrace();
        return false;
    }

    public static void catchHprofs() {
        Debug.dumpHprofData(Environment.getExternalStorageDirectory() + File.separator + String.format(HPROF_NAME, new Object[]{Long.valueOf(System.currentTimeMillis()), Integer.valueOf(Process.myPid())}));     // Catch: Throwable -> L4 Exception -> L9
    L4:
        th = move-exception;
        deleteOldHprofs();
        throw th;
    L7:
        deleteOldHprofs();
    }

    static void deleteOldHprofs() {
        File[] r0 = Environment.getExternalStorageDirectory().listFiles(new AnonymousClass16());
        if (r0 == null) goto L8;
        Arrays.sort(r0, new AnonymousClass17());
        int r1 = 0;
    L6:
        if (r1 >= (r0.length - 4)) goto L10;
        r0[r1].delete();
        r1 = r1 + 1;
        goto L6
    L10:
        return;
    }

    public static float calculateTextWidth(TextView r2) {
        Paint r0 = new Paint();
        r0.setTextSize(r2.getTextSize());
        CharSequence r3 = r2.getText();
        if (r3 != null) goto L7;
        return 0.0f;
    L7:
        return r0.measureText(r3.toString());
    }

    public static void updateCalllogLabel(Context r2, String r3, String r4, String r5) {
        if (r2 == null) goto L5;
        ContentValues r0 = new ContentValues();
        r0.put("numberlabel", r5);
        Intent r6 = CallLogSaveService.createUpdateCallLogIntent(r2, r0);
        r6.putExtra("number", r3);
        r6.putExtra("countryiso", r4);
        r2.startService(r6);
        return;
    }

    public static ArrayList<Long> queryRefsIdFromWallet(Context r13, Uri r14) {
        if (r14 != null) goto L6;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_e(TAG, "Invalid arguments for deleteContact request");
        return new ArrayList();
    L6:
        ArrayList<Long> r1 = new ArrayList();
        Cursor r15 = r13.getContentResolver().query(r14, new String[]{"_id"}, null, null, null);
        if (r15 != null) goto L9;
    L27:
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_e(TAG, "Invalid cursor");
    L28:
        if (r15 == null) goto L30;
        r15.close();
    L30:
        return r1;
    L9:
        if (r15.moveToFirst() == false) goto L27;
        long r2 = r15.getLong(r15.getColumnIndex("_id"));
        Cursor r4 = r13.getContentResolver().query(ContactsContract.Data.CONTENT_URI, new String[]{"contact_id", "mimetype", DBHelper.COL_DATA3}, "contact_id=" + r2, null, null);
        if (r4 != null) goto L13;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_e(TAG, "Invalid infoCursor");
    L13:
        if (r4.moveToNext() == false) goto L25;
        int r0 = r4.getColumnIndex("mimetype");
        int r7 = r4.getColumnIndex(DBHelper.COL_DATA3);
        if (r0 < 0) goto L13;
        if (r7 < 0) goto L13;
        if (r4.getString(r0).equals("vnd.android.cursor.item/card_id") == false) goto L13;
        long r8 = r4.getLong(r7);
        if (r8 < 0) goto L24;
        r1.add(Long.valueOf(r8));
    L24:
        updateRefId(r13.getContentResolver(), r2);
        goto L13
    L25:
        r4.close();
        goto L28
    }

    public static Uri getContactUriFromRawContactUri(Context r7, Uri r8) {
        String[] r5 = {r8.getLastPathSegment()};
        Cursor r9 = r7.getContentResolver().query(ContactsContract.RawContacts.CONTENT_URI, new String[]{"contact_id"}, "_id= ?", r5, null);
        if (r9 != null) goto L5;
    L7:
        long r0 = -1;
    L9:
        return Uri.withAppendedPath(ContactsContract.Contacts.CONTENT_URI, String.valueOf(r0));
    L5:
        if (r9.moveToFirst() == false) goto L7;
        r0 = r9.getLong(r9.getColumnIndex("contact_id"));
        r9.close();
        goto L9
    }

    private static void updateRefId(ContentResolver r3, long r4) {
        ContentValues r0 = new ContentValues();
        r0.put(DBHelper.COL_DATA3, -1);
        r3.update(ContactsContract.Data.CONTENT_URI, r0, "contact_id=" + r4 + " AND mimetype='vnd.android.cursor.item/card_id'", null);
    }

    public static void debugLogD(String r1, String r2) {
        if (DEBUG == false) goto L6;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(r1, r2);
        return;
    }
}
