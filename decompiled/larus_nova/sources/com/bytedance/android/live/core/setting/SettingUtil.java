package com.bytedance.android.live.core.setting;

import android.widget.Toast;
import com.bytedance.android.live.core.setting.v2.update.SettingIncStrategy;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.Gson;
import java.lang.reflect.Type;
import java.util.Locale;

/* JADX INFO: loaded from: classes45.dex */
public final class SettingUtil {
    public static final String KEY_SERVER_SETTING_VALUES = "key_ttlive_sdk_setting";
    public static final String KEY_TT_APP_SETTING = "TT_APP_SETTING";
    public static final String KEY_TT_USER_SETTING = "TT_USER_SETTING";
    private static Gson gson;
    private static boolean isLocalTest;
    private static boolean sDebugMode;
    public static c70.b sTestSettingCallback;

    static {
        gson = t6.f65418a;
    }

    public static String getCacheRate() {
        v60.a r100 = v60.a.f553369a;
        return SettingIncStrategy.f65434a.f558393a.f566315f;
    }

    public static boolean isDebugMode() {
        if (sDebugMode == true) goto L8;
        int r100 = d6.f65283a;
        wa1.a r101 = wa1.d.f558803a;
        if (r101 == null) goto L7;
        r101.b();
    L7:
        return false;
    L8:
        return true;
    }

    private SettingUtil() {
    }

    public static Gson getGson() {
        return gson;
    }

    public static boolean isLocalTest() {
        return isLocalTest;
    }

    public static <T> T getDebugValue(SettingKey<T> r100) {
        return r100.getDebugValue();
    }

    public static <T> T getDefaultValue(SettingKey<T> r100) {
        return r100.getDefaultValue();
    }

    public static String getLocalValue(SettingKey r100) {
        return c7.c(r100);
    }

    public static String getServerValue(SettingKey r100) {
        int r101 = c7.f65275a;
        return GsonProtectorUtils.toJson(t6.f65418a, v60.a.f553369a.k(r100.getName(), r100.getDefaultValue(), r100.getType(), r100.isSticky(), false, false));
    }

    public static String getSettingKeyDescription(SettingKey r100) {
        return r100.getDescription();
    }

    public static String getSettingKeyName(SettingKey r100) {
        return r100.getName();
    }

    public static String[] getSettingKeyOption(SettingKey r100) {
        return r100.getOption();
    }

    public static Type getSettingKeyType(SettingKey r100) {
        return r100.getType();
    }

    public static void setDebugMode(boolean r100) {
        sDebugMode = r100;
    }

    public static void setGson(Gson r100) {
        gson = r100;
    }

    public static void setLocalTest(boolean r100) {
        isLocalTest = r100;
    }

    public static String getLocalValue(String r100, String r101) {
        String r102 = c7.c(new SettingKey(r100, r101));
        if (r102 != null) goto L6;
        return r101;
    L6:
        return r102;
    }

    public static Object getRawValue(String r100, String r101) {
        return c7.d(r101);
    }

    public static boolean updateLocal(SettingKey r100, String r101) {
        int r102 = c7.f65275a;
        v60.a r103 = v60.a.f553369a;     // Catch: NumberFormatException -> L5
        return v60.a.l(r100.getName(), r101, r100.getType());
    L5:
        Toast.makeText(c7.getContext(), String.format(Locale.US, "Illegal value of %s : %s", new Object[]{r100.getName(), String.valueOf(r101)}), 0).show();
        return false;
    }

    public static <T> T getValue(String r100, String r101, Type r102, T r103) {
        return (T) c7.e(r101, r102, r103, false, false);
    }

    public static <T> T getValue(String r100, String r101, Type r102, T r103, boolean r104) {
        return (T) c7.e(r101, r102, r103, r104, false);
    }

    public static <T> T getValue(String r100, String r101, Type r102, T r103, T r104, boolean r105) {
        return (T) c7.e(r101, r102, r103, r105, false);
    }

    public static <T> T getValue(String r100, String r101, Type r102, T r103, T r104, boolean r105, boolean r106) {
        return (T) c7.e(r101, r102, r103, r105, r106);
    }

    public static <T> T getValue(String r100, String r101, Type r102, T r110, T r111, boolean r112, boolean r113, boolean r114) {
        int r103 = c7.f65275a;
        if (r113 == false) goto L5;
        v60.a r104 = v60.a.f553369a;
        int r105 = d6.f65283a;
        return (T) v60.a.i(r101, r102, wa1.d.f558804b);
    L5:
        v60.a r106 = v60.a.f553369a;
        int r107 = d6.f65283a;
        return (T) r106.k(r101, r110, r102, r112, wa1.d.f558804b, r114);
    }
}
