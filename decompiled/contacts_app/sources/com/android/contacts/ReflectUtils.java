package com.android.contacts;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Context;
import android.content.IContentService;
import android.os.Build;
import android.os.IBinder;
import android.os.ServiceManager;
import android.telephony.TelephonyManager;
import bytedanceos.util.MultiSimAdapter;
import com.GlobalProxyLancet;
import com.android.contacts.common.compat.TelephonyManagerCompat;
import com.android.contacts.common.compat.telecom.TelecomManagerCompat;
import com.android.contacts.common.reflection.IIccPhoneBookUtil;
import com.android.contacts.util.Constants;
import com.android.internal.telephony.ITelephony;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Locale;
import libcore.icu.ICU;

/* JADX INFO: loaded from: classes.dex */
public class ReflectUtils {
    private static final String TAG = "ReflectUtils";

    public ReflectUtils() {
    }

    public static String getNetworkOperatorName(int r12) {
        ITelephony r0 = ITelephony.Stub.asInterface(ServiceManager.getService("phone"));
        if (r0 == null) goto L11;
        return (String) ITelephony.class.getMethod("getDisplayPlmnMsim", new Class[]{String.class, String.class, String.class, Boolean.TYPE, Integer.TYPE}).invoke(r0, new Object[]{null, null, null, false, Integer.valueOf(r12)});
    L6:
        e = move-exception;
        e.printStackTrace();
        return null;
    L11:
        return null;
    }

    public static boolean showCallScreen(Context r1) {
        if (Constants.ANDROID50 == false) goto L13;
        if (r1 == null) goto L8;
        return showInCallScreen_v50(r1);
    L8:
        if (ContactsUtils.DEBUG == false) goto L14;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(TAG, "cancelMissedCallsNotification: context is null");
        return false;
    L14:
        return false;
    L13:
        return showInCallScreen_v44();
    }

    private static boolean showInCallScreen_v44() {
        ITelephony r0 = ITelephony.Stub.asInterface(ServiceManager.getService("phone"));
        if (r0 != null) goto L9;
    L8:
        return false;
    L9:
        return ((Boolean) ITelephony.class.getMethod("showCallScreen", new Class[0]).invoke(r0, new Object[0])).booleanValue();
    L6:
        e = move-exception;
        e.printStackTrace();
        goto L8
    }

    private static boolean showInCallScreen_v50(Context r6) {
        Object r7 = r6.getSystemService("telecom");
        if (r7 != null) goto L9;
    L8:
        return false;
    L9:
        Class.forName(TelecomManagerCompat.TELECOM_MANAGER_CLASS).getMethod("showInCallScreen", new Class[]{Boolean.TYPE}).invoke(r7, new Object[]{false});     // Catch: Exception -> L6
        return true;
    L6:
        e = move-exception;
        e.printStackTrace();
        goto L8
    }

    public static void cancelMissedCallsNotification(Context r1) {
        if (Constants.ANDROID50 == false) goto L9;
        if (r1 == null) goto L7;
        cancelMissedCallsNotification_v50(r1);
        return;
    L7:
        if (ContactsUtils.DEBUG == false) goto L12;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(TAG, "cancelMissedCallsNotification: context is null");
        return;
    L12:
        return;
    L9:
        cancelMissedCallsNotification_v44();
    }

    private static void cancelMissedCallsNotification_v44() {
        ITelephony r0 = ITelephony.Stub.asInterface(ServiceManager.getService("phone"));
        if (r0 == null) goto L11;
        ITelephony.class.getMethod("cancelMissedCallsNotification", new Class[0]).invoke(r0, new Object[0]);     // Catch: Exception -> L6
        return;
    L6:
        e = move-exception;
        e.printStackTrace();
        return;
    }

    private static void cancelMissedCallsNotification_v50(Context r4) {
        Object r5 = r4.getSystemService("telecom");
        if (r5 == null) goto L11;
        Class.forName(TelecomManagerCompat.TELECOM_MANAGER_CLASS).getMethod("cancelMissedCallsNotification", new Class[0]).invoke(r5, new Object[0]);     // Catch: Exception -> L6
        return;
    L6:
        e = move-exception;
        e.printStackTrace();
        return;
    }

    public static boolean isSyncActive(Context r1, Account r2, String r3) {
        if (Constants.ANDROID50 == false) goto L7;
        return isSyncActive_v50(r1, r2, r3);
    L7:
        return isSyncActive_v44(r1, r2, r3);
    }

    private static boolean isSyncActive_v44(Context r7, Account r8, String r9) {
        IContentService r0 = ContentResolver.getContentService();     // Catch: Throwable -> L5
        return ((Boolean) IContentService.class.getMethod("isSyncActive", new Class[]{Account.class, String.class}).invoke(r0, new Object[]{r8, r9})).booleanValue();
    L5:
        th = move-exception;
        th.printStackTrace();
        return false;
    }

    private static boolean isSyncActive_v50(Context r8, Account r9, String r10) {
        IContentService r0 = ContentResolver.getContentService();     // Catch: Throwable -> L5
        return ((Boolean) IContentService.class.getMethod("isSyncActive", new Class[]{Account.class, String.class, ComponentName.class}).invoke(r0, new Object[]{r9, r10, null})).booleanValue();
    L5:
        th = move-exception;
        th.printStackTrace();
        return false;
    }

    public static String getBestDateTimePattern(String r7, Locale r8) {
        if (Constants.ANDROID50 == false) goto L7;
        return (String) ICU.class.getMethod("getBestDateTimePattern", new Class[]{String.class, Locale.class}).invoke(ICU.class, new Object[]{r7, r8});
    L7:
        return (String) ICU.class.getMethod("getBestDateTimePattern", new Class[]{String.class, String.class}).invoke(ICU.class, new Object[]{r7, r8.toString()});
    L8:
        return null;
    }

    public static void testReflect() {
        Context r0 = ContactsApplication.getInstance().getApplicationContext();
        showCallScreen(r0);
        cancelMissedCallsNotification(r0);
        isSyncActive(r0);
        getBestDateTimePattern("yyyyMMMdd", Locale.getDefault());
    }

    private static boolean isSyncActive(Context r6) {
        Account[] r0 = AccountManager.get(r6).getAccounts();
        if (r0 != null) goto L5;
    L13:
        return false;
    L5:
        if (r0.length <= 0) goto L13;
        int r2 = r0.length;
        int r3 = 0;
    L7:
        if (r3 >= r2) goto L13;
        if (isSyncActive(r6, r0[r3], "com.android.contacts") == true) goto L10;
        r3 = r3 + 1;
        goto L7
    L10:
        return true;
    }

    public static int getMSimCardMaxCount(int r14) {
        int r5 = 0;
    L29:
        e = move-exception;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_e(TAG, "Failed to IIccPhoneBookMSim", e);
    L31:
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(TAG, "getMSimCardMaxCount: " + r5);
        return r5;
    L4:
        List r13 = null;
        if (DSUtils.sIsAndroidSAbove == false) goto L11;
        int r15 = MultiSimAdapter.slot2Sub(r14);     // Catch: Exception -> L29
        if (MultiSimAdapter.isValidSubId(r15) == false) goto L26;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(TAG, "getMSimCardMaxCount in Android 12, for subscription " + r15);     // Catch: Exception -> L29
        Class<?> r1 = Class.forName("com.android.internal.telephony.IIccPhoneBook");     // Catch: Exception -> L29
        Class<?> r2 = Class.forName("com.android.internal.telephony.IIccPhoneBook$Stub");     // Catch: Exception -> L29
        Method r3 = r2.getMethod("asInterface", new Class[]{IBinder.class});     // Catch: Exception -> L29
        Method r4 = r1.getMethod("getAdnRecordsCapacityForSubscriber", new Class[]{Integer.TYPE});     // Catch: Exception -> L29
        Class<?> r6 = Class.forName("com.android.internal.telephony.uicc.AdnCapacity");     // Catch: Exception -> L29
        Method r7 = r6.getMethod("getMaxAdnCount", new Class[0]);     // Catch: Exception -> L29
        Method r8 = r6.getMethod("getUsedAdnCount", new Class[0]);     // Catch: Exception -> L29
        Object r16 = r4.invoke(r3.invoke(r2, new Object[]{ServiceManager.getService("simphonebook")}), new Object[]{Integer.valueOf(r15)});     // Catch: Exception -> L29
        return ((Integer) r7.invoke(r16, new Object[0])).intValue() - ((Integer) r8.invoke(r16, new Object[0])).intValue();
    L26:
        if (r13 == null) goto L31;
        r5 = r13.size();     // Catch: Exception -> L29
        goto L31
    L11:
        if (DSUtils.sIsAndroidNAbove == false) goto L21;
        int r17 = MultiSimAdapter.slot2Sub(r14);     // Catch: Exception -> L29
        if (MultiSimAdapter.isValidSubId(r17) == false) goto L26;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(TAG, "getMSimCardMaxCount in Android N, for subscription " + r17);     // Catch: Exception -> L29
        Class<?> r9 = Class.forName("com.android.internal.telephony.IIccPhoneBook");     // Catch: Exception -> L29
        Class<?> r10 = Class.forName("com.android.internal.telephony.IIccPhoneBook$Stub");     // Catch: Exception -> L29
        int[] r18 = (int[]) r9.getMethod("getAdnRecordsCapacityForSubscriber", new Class[]{Integer.TYPE}).invoke(r10.getMethod("asInterface", new Class[]{IBinder.class}).invoke(r10, new Object[]{ServiceManager.getService("simphonebook")}), new Object[]{Integer.valueOf(r17)});     // Catch: Exception -> L29
        if (r18 == null) goto L26;
        if (r18.length <= 0) goto L26;
        return r18[0];
    L21:
        if (DSUtils.sIsAndroidLAbove == false) goto L25;
        int r19 = MultiSimAdapter.slot2Sub(r14);     // Catch: Exception -> L29
        if (MultiSimAdapter.isValidSubId(r19) == false) goto L26;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(TAG, "getMSimCardMaxCount in Android L, for subscription " + r19);     // Catch: Exception -> L29
        Class<?> r11 = Class.forName("com.android.internal.telephony.IIccPhoneBook");     // Catch: Exception -> L29
        Class<?> r12 = Class.forName("com.android.internal.telephony.IIccPhoneBook$Stub");     // Catch: Exception -> L29
        r13 = (List) r11.getMethod("getAdnRecordsInEfForSubscriber", new Class[]{Integer.TYPE, Integer.TYPE}).invoke(r12.getMethod("asInterface", new Class[]{IBinder.class}).invoke(r12, new Object[]{ServiceManager.getService("simphonebook")}), new Object[]{Integer.valueOf(r19), Integer.valueOf(IIccPhoneBookUtil.EF_ADN)});     // Catch: Exception -> L29
        goto L26
    L25:
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(TAG, "getMSimCardMaxCount for subscription " + r14);     // Catch: Exception -> L29
        Class<?> r20 = Class.forName("com.android.internal.telephony.msim.IIccPhoneBookMSim");     // Catch: Exception -> L29
        Class<?> r21 = Class.forName("com.android.internal.telephony.msim.IIccPhoneBookMSim$Stub");     // Catch: Exception -> L29
        r13 = (List) r20.getMethod("getAdnRecordsInEf", new Class[]{Integer.TYPE, Integer.TYPE}).invoke(r21.getMethod("asInterface", new Class[]{IBinder.class}).invoke(r21, new Object[]{ServiceManager.getService("simphonebook_msim")}), new Object[]{Integer.valueOf(IIccPhoneBookUtil.EF_ADN), Integer.valueOf(r14)});     // Catch: Exception -> L29
        goto L26
    }

    public static boolean isNoSpaceException(IOException r8) {
        Class<?> r2 = Class.forName("android.system.ErrnoException");     // Catch: Exception -> L12
        Field r3 = r2.getDeclaredField("errno");     // Catch: Exception -> L12
        Field r4 = Class.forName("android.system.OsConstants").getDeclaredField("ENOSPC");     // Catch: Exception -> L12
        if (ContactsUtils.DEBUG == false) goto L7;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(TAG, "OsConstants.ENOSPC = " + r4.get(null));     // Catch: Exception -> L12
    L7:
        if (r2.isInstance(r8.getCause()) == false) goto L15;
        if (r3.get(r8.getCause()).equals(r4.get(null)) == false) goto L16;
        return true;
    L16:
        return false;
    L15:
        return false;
    L17:
        return false;
    }

    public static String getImei(TelephonyManager r6) {
        String r1 = "";
        String r7 = (String) Class.forName(TelephonyManagerCompat.TELEPHONY_MANAGER_CLASS).getMethod("getImei", new Class[0]).invoke(r6, new Object[0]);     // Catch: Exception -> L10
    L8:
        e = e;
        r1 = r7;
    L11:
        e.printStackTrace();
        return r1;
    L5:
        if (ContactsUtils.DEBUG == false) goto L17;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(TAG, "ReflectUtils.getImei = " + r7);     // Catch: Exception -> L8
        return r7;
    L17:
        return r7;
    L10:
        e = e;
        goto L11
    }

    public static String getImei(TelephonyManager r8, int r9) {
        String r1 = "";
        String r10 = (String) Class.forName(TelephonyManagerCompat.TELEPHONY_MANAGER_CLASS).getMethod("getImei", new Class[]{Integer.TYPE}).invoke(r8, new Object[]{Integer.valueOf(r9)});     // Catch: Exception -> L10
    L8:
        e = e;
        r1 = r10;
    L11:
        e.printStackTrace();
        return r1;
    L5:
        if (ContactsUtils.DEBUG == false) goto L17;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(TAG, "ReflectUtils.getImei(" + r9 + ")= " + r10);     // Catch: Exception -> L8
        return r10;
    L17:
        return r10;
    L10:
        e = e;
        goto L11
    }

    public static String getMeid(TelephonyManager r8, int r9) {
        String r1 = "";
        String r10 = (String) Class.forName(TelephonyManagerCompat.TELEPHONY_MANAGER_CLASS).getMethod("getMeid", new Class[]{Integer.TYPE}).invoke(r8, new Object[]{Integer.valueOf(r9)});     // Catch: Exception -> L10
    L8:
        e = e;
        r1 = r10;
    L11:
        e.printStackTrace();
        return r1;
    L5:
        if (ContactsUtils.DEBUG == false) goto L17;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(TAG, "ReflectUtils.getMeid(" + r9 + ")= " + r10);     // Catch: Exception -> L8
        return r10;
    L17:
        return r10;
    L10:
        e = e;
        goto L11
    }

    public static String getSn() {
        String r1 = Build.getSerial();     // Catch: Exception -> L9
        if (r1 == null) goto L14;
        if (r1.isEmpty() == false) goto L15;
        return "UNKNOWN";
    L15:
        return r1;
    L14:
        return "UNKNOWN";
    L9:
        e = move-exception;
        e.printStackTrace();
        return "UNKNOWN";
    }
}
