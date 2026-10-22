package com;

import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;
import androidx.fragment.app.FragmentActivity;
import com.android.contacts.vcard.ExportSimContacts;
import com.android.contacts.vcard.ImportSimContacts;
import com.bytedance.sysoptimizer.BadParcelableCrashOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer;
import com.obric.olog.OLog;
import com.obric.oui.calendar.format.DayFormatter;
import com.obric.utils.ContactsLogHook;
import com.ttnet.org.chromium.base.BaseSwitches;
import kotlin.jvm.JvmStatic;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.NameRegex;
import me.ele.lancet.base.annotations.Proxy;
import me.ele.lancet.base.annotations.Skip;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: loaded from: classes.dex */
public class GlobalProxyLancet {
    private GlobalProxyLancet() {
    }

    @Proxy("getBundleExtra")
    @TargetClass("android.content.Intent")
    public static Bundle com_bytedance_sysoptimizer_BadParcelableLancet_getBundleExtra(Intent r0, String r1) {
        Bundle r2 = r0.getBundleExtra(r1);
        Context r3 = BadParcelableCrashOptimizer.getContext();
        if (r2 == null) goto L6;
        if (r3 == null) goto L6;
        r2.setClassLoader(r3.getClassLoader());
    L6:
        return r2;
    }

    @Proxy("registerReceiver")
    @TargetClass(scope = Scope.ALL_SELF, value = "android.content.Context")
    @Skip({"com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer"})
    public static Intent com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver(Application r1, BroadcastReceiver r2, IntentFilter r3) {
        return r1.registerReceiver(r2, r3);
    L4:
        e = move-exception;
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == true) goto L8;
        throw e;
    L8:
        return ReceiverRegisterCrashOptimizer.registerReceiver(r2, r3);
    }

    @Proxy("registerReceiver")
    @TargetClass(scope = Scope.ALL_SELF, value = "android.content.Context")
    @Skip({"com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer"})
    public static Intent com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver(Context r1, BroadcastReceiver r2, IntentFilter r3) {
        return r1.registerReceiver(r2, r3);
    L4:
        e = move-exception;
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == true) goto L8;
        throw e;
    L8:
        return ReceiverRegisterCrashOptimizer.registerReceiver(r2, r3);
    }

    @Proxy("registerReceiver")
    @TargetClass(scope = Scope.ALL_SELF, value = "android.content.Context")
    @Skip({"com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer"})
    public static Intent com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver(FragmentActivity r1, BroadcastReceiver r2, IntentFilter r3) {
        return r1.registerReceiver(r2, r3);
    L4:
        e = move-exception;
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == true) goto L8;
        throw e;
    L8:
        return ReceiverRegisterCrashOptimizer.registerReceiver(r2, r3);
    }

    @Proxy("registerReceiver")
    @TargetClass(scope = Scope.ALL_SELF, value = "android.content.Context")
    @Skip({"com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer"})
    public static Intent com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver(ExportSimContacts r1, BroadcastReceiver r2, IntentFilter r3) {
        return r1.registerReceiver(r2, r3);
    L4:
        e = move-exception;
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == true) goto L8;
        throw e;
    L8:
        return ReceiverRegisterCrashOptimizer.registerReceiver(r2, r3);
    }

    @Proxy("registerReceiver")
    @TargetClass(scope = Scope.ALL_SELF, value = "android.content.Context")
    @Skip({"com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer"})
    public static Intent com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver(ImportSimContacts r1, BroadcastReceiver r2, IntentFilter r3) {
        return r1.registerReceiver(r2, r3);
    L4:
        e = move-exception;
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == true) goto L8;
        throw e;
    L8:
        return ReceiverRegisterCrashOptimizer.registerReceiver(r2, r3);
    }

    @Proxy("registerReceiver")
    @TargetClass(scope = Scope.ALL_SELF, value = "android.content.Context")
    @Skip({"com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer"})
    public static Intent com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver(Context r1, BroadcastReceiver r2, IntentFilter r3, int r4) {
        return r1.registerReceiver(r2, r3, r4);
    L4:
        e = move-exception;
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == true) goto L8;
        throw e;
    L8:
        return ReceiverRegisterCrashOptimizer.registerReceiver(r2, r3, r4);
    }

    @JvmStatic
    @Proxy(globalProxyClass = true, value = DayFormatter.DEFAULT_FORMAT)
    @NameRegex(ContactsLogHook.NAME_REGEX)
    @TargetClass(ContactsLogHook.TARGET_CLASS)
    public static int com_obric_utils_ContactsLogHook_d(String r1, String r2) {
        ContactsLogHook r0 = ContactsLogHook.INSTANCE;
        if (r2 == null) goto L8;
        OLog.d(ContactsLogHook.TAG, r1 + " - " + r2);
        return 0;
    L8:
        return 0;
    }

    @Proxy("registerReceiver")
    @TargetClass(scope = Scope.ALL_SELF, value = "android.content.Context")
    @Skip({"com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer"})
    public static Intent com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver(Context r1, BroadcastReceiver r2, IntentFilter r3, String r4, Handler r5) {
        return r1.registerReceiver(r2, r3, r4, r5);
    L4:
        e = move-exception;
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == true) goto L8;
        throw e;
    L8:
        return ReceiverRegisterCrashOptimizer.registerReceiver(r2, r3, r4, r5);
    }

    @JvmStatic
    @Proxy(DayFormatter.DEFAULT_FORMAT)
    @NameRegex(ContactsLogHook.NAME_REGEX)
    @TargetClass(ContactsLogHook.TARGET_CLASS)
    public static int com_obric_utils_ContactsLogHook_d(String r3, String r4, Throwable r5) {
        ContactsLogHook r0 = ContactsLogHook.INSTANCE;
        if (r4 != null) goto L6;
        return 0;
    L6:
        if (r5 == null) goto L8;
        OLog.d(ContactsLogHook.TAG, r3 + " - " + r4, r5);
        return 0;
    L8:
        OLog.d(ContactsLogHook.TAG, r3 + " - " + r4);
        return 0;
    }

    @JvmStatic
    @Proxy("i")
    @NameRegex(ContactsLogHook.NAME_REGEX)
    @TargetClass(ContactsLogHook.TARGET_CLASS)
    public static int com_obric_utils_ContactsLogHook_i(String r1, String r2) {
        ContactsLogHook r0 = ContactsLogHook.INSTANCE;
        if (r2 == null) goto L8;
        OLog.i(ContactsLogHook.TAG, r1 + " - " + r2);
        return 0;
    L8:
        return 0;
    }

    @Proxy("registerReceiver")
    @TargetClass(scope = Scope.ALL_SELF, value = "android.content.Context")
    @Skip({"com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer"})
    public static Intent com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver(Context r1, BroadcastReceiver r2, IntentFilter r3, String r4, Handler r5, int r6) {
        return r1.registerReceiver(r2, r3, r4, r5, r6);
    L4:
        e = move-exception;
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == true) goto L8;
        throw e;
    L8:
        return ReceiverRegisterCrashOptimizer.registerReceiver(r2, r3, r4, r5, r6);
    }

    @JvmStatic
    @Proxy("i")
    @NameRegex(ContactsLogHook.NAME_REGEX)
    @TargetClass(ContactsLogHook.TARGET_CLASS)
    public static int com_obric_utils_ContactsLogHook_i(String r3, String r4, Throwable r5) {
        ContactsLogHook r0 = ContactsLogHook.INSTANCE;
        if (r4 != null) goto L6;
        return 0;
    L6:
        if (r5 == null) goto L8;
        OLog.i(ContactsLogHook.TAG, r3 + " - " + r4, r5);
        return 0;
    L8:
        OLog.i(ContactsLogHook.TAG, r3 + " - " + r4);
        return 0;
    }

    @JvmStatic
    @Proxy(BaseSwitches.V)
    @NameRegex(ContactsLogHook.NAME_REGEX)
    @TargetClass(ContactsLogHook.TARGET_CLASS)
    public static int com_obric_utils_ContactsLogHook_v(String r1, String r2) {
        ContactsLogHook r0 = ContactsLogHook.INSTANCE;
        if (r2 == null) goto L8;
        OLog.v(ContactsLogHook.TAG, r1 + " - " + r2);
        return 0;
    L8:
        return 0;
    }

    @JvmStatic
    @Proxy(BaseSwitches.V)
    @NameRegex(ContactsLogHook.NAME_REGEX)
    @TargetClass(ContactsLogHook.TARGET_CLASS)
    public static int com_obric_utils_ContactsLogHook_v(String r3, String r4, Throwable r5) {
        ContactsLogHook r0 = ContactsLogHook.INSTANCE;
        if (r4 != null) goto L6;
        return 0;
    L6:
        if (r5 == null) goto L8;
        OLog.v(ContactsLogHook.TAG, r3 + " - " + r4, r5);
        return 0;
    L8:
        OLog.v(ContactsLogHook.TAG, r3 + " - " + r4);
        return 0;
    }

    @JvmStatic
    @Proxy("e")
    @NameRegex(ContactsLogHook.NAME_REGEX)
    @TargetClass(ContactsLogHook.TARGET_CLASS)
    public static int com_obric_utils_ContactsLogHook_e(String r1, String r2) {
        ContactsLogHook r0 = ContactsLogHook.INSTANCE;
        if (r2 == null) goto L8;
        OLog.e(ContactsLogHook.TAG, r1 + " - " + r2);
        return 0;
    L8:
        return 0;
    }

    @JvmStatic
    @Proxy("e")
    @NameRegex(ContactsLogHook.NAME_REGEX)
    @TargetClass(ContactsLogHook.TARGET_CLASS)
    public static int com_obric_utils_ContactsLogHook_e(String r3, String r4, Throwable r5) {
        ContactsLogHook r0 = ContactsLogHook.INSTANCE;
        if (r4 != null) goto L6;
        return 0;
    L6:
        if (r5 == null) goto L8;
        OLog.e(ContactsLogHook.TAG, r3 + " - " + r4, r5);
        return 0;
    L8:
        OLog.e(ContactsLogHook.TAG, r3 + " - " + r4);
        return 0;
    }

    @JvmStatic
    @Proxy("w")
    @NameRegex(ContactsLogHook.NAME_REGEX)
    @TargetClass(ContactsLogHook.TARGET_CLASS)
    public static int com_obric_utils_ContactsLogHook_w(String r1, String r2) {
        ContactsLogHook r0 = ContactsLogHook.INSTANCE;
        if (r2 == null) goto L8;
        OLog.w(ContactsLogHook.TAG, r1 + " - " + r2);
        return 0;
    L8:
        return 0;
    }

    @JvmStatic
    @Proxy("w")
    @NameRegex(ContactsLogHook.NAME_REGEX)
    @TargetClass(ContactsLogHook.TARGET_CLASS)
    public static int com_obric_utils_ContactsLogHook_w(String r3, String r4, Throwable r5) {
        ContactsLogHook r0 = ContactsLogHook.INSTANCE;
        if (r4 != null) goto L6;
        return 0;
    L6:
        if (r5 == null) goto L8;
        OLog.w(ContactsLogHook.TAG, r3 + " - " + r4, r5);
        return 0;
    L8:
        OLog.w(ContactsLogHook.TAG, r3 + " - " + r4);
        return 0;
    }
}
