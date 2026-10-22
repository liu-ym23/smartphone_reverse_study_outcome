package com.android.server.inputmethod;

import android.R;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.os.Parcel;
import android.os.ResultReceiver;
import android.os.SystemClock;
import android.os.SystemProperties;
import android.os.UserHandle;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.ReflectUtil;
import android.util.Slog;
import android.view.inputmethod.InputMethodInfo;
import com.android.internal.view.IInputMethodManagerSmtEx;
import com.android.server.ISmtResourceControl;
import com.android.server.am.ActivityManagerService;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import org.apache.commons.compress.archivers.zip.UnixStat;

/* JADX INFO: loaded from: classes2.dex */
public class InputMethodManagerServiceSmtEx extends IInputMethodManagerSmtEx.Stub {
    protected static final long HIDE_NOTIFICATION_DELAY = 300;
    private static final String IMI_ID_BYTEDANCE = "com.bytedanceos.ime/.BytedanceIME";
    private static final String IMI_ID_IFLY = "com.iflytek.inputmethod.bytedance/com.iflytek.inputmethod.FlyIME";
    protected static final String IMI_ID_LATIN = "com.android.inputmethod.latin/.LatinIME";
    private static final String IMI_ID_SOGOU = "com.sohu.inputmethod.sogou.chuizi/.SogouIME";
    protected static final String IMI_ID_Security = "com.obric.security.ime/.SecurityIME";
    private static final String IMI_ID_TOUCHPAL = "com.cootek.smartinputv5.bytedance/com.cootek.smartinput5.TouchPalIME";
    static final int MSG_SET_HAS_BEEN_INACTIVE = 3080;
    protected static final int SECURITY_KEYBOARD_ON = 1;
    protected static final List<String> SYSTEM_BUILT_IN_INPUT_METHOD = null;
    private static final boolean ctaModeEnabled = false;
    protected static boolean sAccessibilityEnabled = false;
    private static final String sSecurityImeCls = "com.obric.security.ime.SecurityIME";
    private static final String sSecurityImePkg = "com.obric.security.ime";
    protected ActivityManagerService mAMS;
    protected boolean mChangingInputMethod;
    private long mClickSwitchBtnTime;
    protected Runnable mHideNotification;
    private boolean mIMEIsShowWhenClickSwitchBtn;
    private InputMethodManagerService mInputMethodManagerService;
    protected int passwordType;
    List<String> whitePkgList;

    static {
        boolean r1 = false;
        if (SystemProperties.getInt("persist.radio.cta.test.mode", 0) != 1) goto L5;
        r1 = true;
    L5:
        ctaModeEnabled = r1;
        SYSTEM_BUILT_IN_INPUT_METHOD = new ArrayList();
        SYSTEM_BUILT_IN_INPUT_METHOD.add(IMI_ID_LATIN);
        SYSTEM_BUILT_IN_INPUT_METHOD.add(IMI_ID_SOGOU);
        SYSTEM_BUILT_IN_INPUT_METHOD.add(IMI_ID_BYTEDANCE);
        SYSTEM_BUILT_IN_INPUT_METHOD.add(IMI_ID_TOUCHPAL);
        SYSTEM_BUILT_IN_INPUT_METHOD.add(IMI_ID_IFLY);
    }

    public InputMethodManagerServiceSmtEx(InputMethodManagerService inputMethodManagerService) {
        this.mChangingInputMethod = false;
        this.mIMEIsShowWhenClickSwitchBtn = false;
        this.mClickSwitchBtnTime = 0;
        this.whitePkgList = new ArrayList(Arrays.asList(new String[]{"com.baidu.input", "com.sohu.inputmethod.sogou"}));
        this.passwordType = -1;
        this.mHideNotification = new AnonymousClass1(this);
        this.mInputMethodManagerService = inputMethodManagerService;
    }

    boolean onTransactSmtEx(int code, Parcel data, Parcel reply, int flags) {
        switch(code) {
            case 1030: goto L5;
            default: goto L3;
        };
    L3:
        return false;
    L5:
        return true;
    }

    public boolean hideCurrentSoft(int flags, ResultReceiver resultReceiver) {
        monitor-enter(ImfLock.class);
        long ident = Binder.clearCallingIdentity();     // Catch: Throwable -> L9
        Object curFocusedWindow = ReflectUtil.acquireField(this.mInputMethodManagerService, "mCurFocusedWindow");     // Catch: Throwable -> L11
        boolean r5 = ((Boolean) ReflectUtil.invokeMethod(this.mInputMethodManagerService, "hideCurrentInputLocked", new Class[]{IBinder.class, Integer.TYPE, ResultReceiver.class, Integer.TYPE}, new Object[]{curFocusedWindow, Integer.valueOf(flags), resultReceiver, 4})).booleanValue();     // Catch: Throwable -> L11
        Binder.restoreCallingIdentity(ident);     // Catch: Throwable -> L9
        monitor-exit(ImfLock.class);     // Catch: Throwable -> L9
        return r5;
    L11:
        th = move-exception;
        Binder.restoreCallingIdentity(ident);     // Catch: Throwable -> L9
        throw th;     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        throw th;
    }

    public ComponentName getSaftKeyboardComponentName() {
        return new ComponentName(sSecurityImePkg, sSecurityImeCls);
    }

    protected boolean needPopSecurityKeyboard(String pkgName) {
        return !this.whitePkgList.contains(pkgName);
    }

    protected boolean isSameInputType(int type1, int type2) {
        Slog.d("InputMethodManagerService", "type1: " + type1 + ", type2: " + type2);
        if (type1 != type2) goto L6;
        return true;
    L6:
        if (isPasswordType(type1) == false) goto L11;
        if (isPasswordType(type2) == false) goto L11;
        return true;
    L11:
        if (isPasswordType(type1) == false) goto L13;
        return false;
    L13:
        if (isPasswordType(type2) == true) goto L17;
        return true;
    L17:
        return false;
    }

    protected boolean isPasswordType(int inputType) {
        if (isPasswordInputType(inputType) == false) goto L5;
    L8:
        return true;
    L5:
        if (isVisiblePasswordInputType(inputType) == true) goto L8;
        return false;
    }

    private boolean isPasswordInputType(int inputType) {
        int variation = inputType & UnixStat.PERM_MASK;
        switch(variation) {
            case 18: goto L6;
            case 128: goto L6;
            case 129: goto L6;
            case 224: goto L6;
            case 225: goto L6;
            default: goto L4;
        };
    L4:
        return false;
    L6:
        return true;
    }

    private boolean isVisiblePasswordInputType(int inputType) {
        int variation = inputType & UnixStat.PERM_MASK;
        if (variation != 145) goto L5;
        return true;
    L5:
        return false;
    }

    public static boolean isAccessibilityEnabled(Context context) {
        String servicesSettings = Settings.Secure.getString(context.getContentResolver(), "enabled_accessibility_services");
        int r1 = 0;
        if (servicesSettings != null) goto L5;
        return false;
    L5:
        String[] talkbackApps = context.getResources().getStringArray(R.array.carrier_properties);
        int r4 = talkbackApps.length;
    L7:
        if (r1 >= r4) goto L15;
        String service = talkbackApps[r1];
        if (servicesSettings.contains(service) == true) goto L10;
        r1 = r1 + 1;
        goto L7
    L10:
        return true;
    L15:
        return false;
    }

    protected InputMethodInfo findMustEnableIme(ArrayList<InputMethodInfo> imis) {
        int i = 0;
    L4:
        if (i >= imis.size()) goto L9;
        InputMethodInfo imi = imis.get(i);
        if (IMI_ID_LATIN.equals(imi.getId()) == true) goto L7;
        i = i + 1;
        goto L4
    L7:
        return imi;
    L9:
        return null;
    }

    protected void hideSelectInputMethodNotification() {
    }

    public static boolean isSystemIme(InputMethodInfo inputMethod) {
        if ((inputMethod.getServiceInfo().applicationInfo.flags & 1) != 0) goto L7;
        return false;
    L7:
        return true;
    }

    public static boolean isCurrentLocaleChinese(Context context) {
        Locale locale = getSystemLocaleFromContext(context);
        if (Locale.SIMPLIFIED_CHINESE.equals(locale) == false) goto L5;
    L8:
        return true;
    L5:
        if (Locale.TRADITIONAL_CHINESE.equals(locale) == true) goto L8;
        return false;
    }

    private static Locale getSystemLocaleFromContext(Context context) {
        return context.getResources().getConfiguration().locale;
    L5:
        return null;
    }

    private void showConfigureInputMethodsSetting(String packageName, String settingsActivityName) {
        if (TextUtils.isEmpty(packageName) == false) goto L5;
    L12:
        Slog.w("InputMethodManagerService", "showConfigureInputMethodsSetting Activity invalid");
        return;
    L5:
        if (TextUtils.isEmpty(settingsActivityName) == true) goto L12;
        Intent intent = new Intent();     // Catch: Exception -> L9
        intent.setClassName(packageName, settingsActivityName);     // Catch: Exception -> L9
        intent.setFlags(337641472);     // Catch: Exception -> L9
        this.mInputMethodManagerService.mContext.startActivityAsUser(intent, null, UserHandle.CURRENT);     // Catch: Exception -> L9
        return;
    L9:
        e = move-exception;
        e.printStackTrace();
    }

    protected static boolean ignoreInputMethodInQueryProcess(String inputMethodId) {
        if (IMI_ID_Security.equals(inputMethodId) == false) goto L7;
        Slog.w("InputMethodManagerService", "Skip securityIme");
        return true;
    L7:
        if (sAccessibilityEnabled == false) goto L13;
        if (IMI_ID_SOGOU.equals(inputMethodId) == false) goto L13;
        Slog.w("InputMethodManagerService", "Skip SogouIme in accessibility mode");
        return true;
    L13:
        if (ctaModeEnabled == true) goto L15;
        return false;
    L15:
        if (IMI_ID_BYTEDANCE.equals(inputMethodId) == false) goto L20;
        Slog.w("InputMethodManagerService", "Skip BytedanceIME in CTA mode");
        return true;
    L20:
        return false;
    }

    public void setActivityManagerService(ActivityManagerService service) {
        this.mAMS = service;
    }

    public void switchImeByImeChooserDialog(boolean showRequested) {
        this.mIMEIsShowWhenClickSwitchBtn = showRequested;
        this.mClickSwitchBtnTime = SystemClock.uptimeMillis();
    }

    public boolean allowShowImeOnAttachNewInput() {
        if ((SystemClock.uptimeMillis() - this.mClickSwitchBtnTime) < ISmtResourceControl.LAUNCH_CPUSET_EFFECTIVE_TIME) goto L5;
    L7:
        boolean showIme = false;
    L8:
        this.mIMEIsShowWhenClickSwitchBtn = false;
        return showIme;
    L5:
        if (this.mIMEIsShowWhenClickSwitchBtn == false) goto L7;
        showIme = true;
        goto L8
    }
}
