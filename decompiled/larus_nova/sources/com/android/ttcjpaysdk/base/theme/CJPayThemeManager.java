package com.android.ttcjpaysdk.base.theme;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import com.android.ttcjpaysdk.base.CJPayHostInfo;
import com.android.ttcjpaysdk.base.settings.CJPaySettingsManager;
import com.android.ttcjpaysdk.base.settings.abtest.CJPayABExperimentKeys;
import com.android.ttcjpaysdk.base.statusbar.CJPayImmersedStatusBarUtils;
import com.android.ttcjpaysdk.base.utils.CJBasicCommonUtils;
import com.android.ttcjpaysdk.base.utils.CJUiOptimizeUtil;
import com.bytedance.caijing.sdk.infra.base.env.CJEnv;
import com.bytedance.ee.bear.document.customheader.CustomHeaderConfig;
import com.bytedance.mt.protector.impl.JSONArrayProtectorUtils;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.larus.nova.R;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes28.dex */
public class CJPayThemeManager {
    public static final String THEME_TYPE_DARK = "dark";
    public static final String THEME_TYPE_LARK = "lark";
    public static final String THEME_TYPE_LIGHT = "light";
    public static List<String> defaultMultipleThemeForH5Paths;
    public static CJPayThemeManager instance;
    private ThemeInfo mThemeInfo;
    private HashMap<String, String> mThemeMap;
    public boolean uiComponentNeedDark;

    public static class AgreementTextInfo {
        public String textColor;

        public AgreementTextInfo() {
            this.textColor = "#04498D";
        }
    }

    public static class ButtonInfo {
        public String corner;
        public double disableAlpha;
        public String disableEndBgColor;
        public String disableStartBgColor;
        public String disableTextColor;
        public String endBgColor;
        public String highlightEndColor;
        public String highlightStartColor;
        public String startBgColor;
        public String textColor;

        public ButtonInfo() {
            this.startBgColor = CJPayColorConstants.CJ_PAY_RED;
            this.endBgColor = CJPayColorConstants.CJ_PAY_RED;
            this.highlightStartColor = "";
            this.highlightEndColor = "";
            this.disableStartBgColor = "#4D8F8E8F";
            this.disableEndBgColor = "#4D8F8E8F";
            this.textColor = CustomHeaderConfig.COLOR_LIGHT;
            this.corner = "2";
            this.disableAlpha = 0.5d;
            this.disableTextColor = "";
        }
    }

    public static class CheckBoxInfo {
        public String bgColor;

        public CheckBoxInfo() {
            this.bgColor = CJPayColorConstants.CJ_PAY_RED;
        }
    }

    public static class CursorInfo {
        public String cursorColor;

        public CursorInfo() {
            this.cursorColor = CJPayColorConstants.CJ_PAY_RED;
        }
    }

    public static class LinkTextInfo {
        public String textColor;

        public LinkTextInfo() {
            this.textColor = CJPayColorConstants.CJ_PAY_RED;
        }
    }

    public class ThemeInfo {
        public AgreementTextInfo agreementTextInfo;
        public ButtonInfo buttonInfo;
        public CheckBoxInfo checkBoxInfo;
        public CursorInfo cursorInfo;
        public LinkTextInfo linkTextInfo;
        public List<String> paths;
        public String themeType;
        final /* synthetic */ CJPayThemeManager this$0;

        public ThemeInfo(CJPayThemeManager r100) {
            this.this$0 = r100;
            this.themeType = "dark";
            this.checkBoxInfo = new CheckBoxInfo();
            this.buttonInfo = new ButtonInfo();
            this.linkTextInfo = new LinkTextInfo();
            this.agreementTextInfo = new AgreementTextInfo();
            this.cursorInfo = new CursorInfo();
            this.paths = CJPayThemeManager.defaultMultipleThemeForH5Paths;
            if ("6589".equals(CJEnv.e()) == false) goto L6;
            this.themeType = "light";
            return;
        }
    }

    static {
        defaultMultipleThemeForH5Paths = new AnonymousClass1();
    }

    public static CJPayThemeManager getInstance() {
        if (instance != null) goto L15;
        monitor-enter(CJPayThemeManager.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (instance != null) goto L9;
        instance = new CJPayThemeManager();     // Catch: Throwable -> L11
    L9:
        monitor-exit(CJPayThemeManager.class);     // Catch: Throwable -> L11
    L15:
        return instance;
    }

    private ThemeInfo getThemeInfoForSp() {
        String r100 = CJPaySettingsManager.getInstance().getSettingsInfo("new_cjpay_theme_info");
        if (r100 == null) goto L37;
        if (r100.isEmpty() == true) goto L37;
        ThemeInfo r101 = new ThemeInfo(this);     // Catch: Exception -> L33
        JSONObject r102 = new JSONObject(r100);     // Catch: Exception -> L33
        r101.themeType = r102.optString("theme_type");     // Catch: Exception -> L33
        JSONObject r103 = r102.optJSONObject("button_info");     // Catch: Exception -> L33
        ButtonInfo r104 = new ButtonInfo();     // Catch: Exception -> L33
        if (r103 == null) goto L11;
        r104.startBgColor = r103.optString("start_bg_color");     // Catch: Exception -> L33
        r104.endBgColor = r103.optString("end_bg_color");     // Catch: Exception -> L33
        r104.highlightStartColor = r103.optString("highlight_start_color");     // Catch: Exception -> L33
        r104.highlightEndColor = r103.optString("highlight_end_color");     // Catch: Exception -> L33
        r104.disableStartBgColor = r103.optString("disable_start_color");     // Catch: Exception -> L33
        r104.disableEndBgColor = r103.optString("disable_start_color");     // Catch: Exception -> L33
        r104.textColor = r103.optString("text_color");     // Catch: Exception -> L33
        r104.corner = r103.optString("corner");     // Catch: Exception -> L33
        r104.disableAlpha = r103.optDouble("disable_alpha");     // Catch: Exception -> L33
        r104.disableTextColor = r103.optString("disable_text_color");     // Catch: Exception -> L33
        r101.buttonInfo = r104;     // Catch: Exception -> L33
    L11:
        JSONObject r105 = r102.optJSONObject("checkbox_info");     // Catch: Exception -> L33
        CheckBoxInfo r106 = new CheckBoxInfo();     // Catch: Exception -> L33
        if (r105 == null) goto L14;
        r106.bgColor = r105.optString("bg_color");     // Catch: Exception -> L33
        r101.checkBoxInfo = r106;     // Catch: Exception -> L33
    L14:
        JSONObject r107 = r102.optJSONObject("link_text_info");     // Catch: Exception -> L33
        LinkTextInfo r108 = new LinkTextInfo();     // Catch: Exception -> L33
        if (r107 == null) goto L17;
        r108.textColor = r107.optString("text_color");     // Catch: Exception -> L33
        r101.linkTextInfo = r108;     // Catch: Exception -> L33
    L17:
        JSONObject r109 = r102.optJSONObject("cursor_info");     // Catch: Exception -> L33
        CursorInfo r110 = new CursorInfo();     // Catch: Exception -> L33
        if (r109 == null) goto L20;
        r110.cursorColor = r109.optString("cursor_color");     // Catch: Exception -> L33
        r101.cursorInfo = r110;     // Catch: Exception -> L33
    L20:
        JSONObject r111 = r102.optJSONObject("agreement_text_info");     // Catch: Exception -> L33
        AgreementTextInfo r112 = new AgreementTextInfo();     // Catch: Exception -> L33
        if (r111 == null) goto L23;
        r112.textColor = r111.optString("text_color");     // Catch: Exception -> L33
        r101.agreementTextInfo = r112;     // Catch: Exception -> L33
    L23:
        JSONArray r113 = r102.optJSONArray("is_support_multiple_h5_path");     // Catch: Exception -> L33
        if (r113 != null) goto L26;
    L32:
        return r101;
    L26:
        if (r113.length() <= 0) goto L32;
        ArrayList r114 = new ArrayList();     // Catch: Exception -> L33
        int r115 = 0;
    L29:
        if (r115 >= r113.length()) goto L31;
        r114.add(JSONArrayProtectorUtils.getString(r113, r115));     // Catch: Exception -> L33
        r115 = r115 + 1;     // Catch: Exception -> L33
        goto L29
    L31:
        r101.paths = r114;     // Catch: Exception -> L33
    L33:
        e = move-exception;
        CJBasicCommonUtils.reportCatchException("CJPayThemeManager#getThemeInfoForSp", e);
        CJBasicCommonUtils.logCatch("CJCatch", "CJPayThemeManager#getThemeInfoForSp", e);
        return null;
    L37:
        return new ThemeInfo(this);
    }

    public int getAgreementTextColor() {
        int r100 = ColorProtector.parseColor("#155494");
        if (getThemeInfo() != null) goto L5;
        return r100;
    L5:
        if (getThemeInfo().agreementTextInfo != null) goto L7;
        return r100;
    L7:
        if (TextUtils.isEmpty(getThemeInfo().agreementTextInfo.textColor) == false) goto L9;
        return r100;
    L9:
        return ColorProtector.parseColor(getThemeInfo().agreementTextInfo.textColor);
    }

    public ThemeInfo getThemeInfo() {
        if (this.mThemeInfo != null) goto L6;
        this.mThemeInfo = getThemeInfoForSp();
    L6:
        return this.mThemeInfo;
    }

    public String getThemeType() {
        String r100 = CJPayHostInfo.inheritTheme;
        if (TextUtils.isEmpty(r100) == true) goto L6;
        return r100;
    L6:
        if (CJEnv.o() == true) goto L8;
    L12:
        return "light";
    L8:
        if (AppCompatDelegate.getDefaultNightMode() != 2) goto L11;
        return "dark";
    L11:
        AppCompatDelegate.getDefaultNightMode();
        goto L12
    }

    private CJPayThemeManager() {
        this.uiComponentNeedDark = false;
        this.mThemeMap = new HashMap();
    }

    private boolean isDouYin() {
        String r100 = CJEnv.e();
        if (TextUtils.isEmpty(r100) == false) goto L5;
    L9:
        return false;
    L5:
        if ("1128".equals(r100) == false) goto L7;
    L8:
        return true;
    L7:
        if ("2329".equals(r100) == false) goto L9;
        goto L8
    }

    private boolean isUseDp() {
        return "1".equals(CJPayABExperimentKeys.getBindCardFontSize().value(true));
    }

    public int getUnit() {
        if (isUseDp() == false) goto L5;
        return 1;
    L5:
        return 2;
    }

    public static boolean isSupportMultipleThemeForH5(String r100) {
        String r101 = UriProtector.parse(r100).getPath();
        if (getInstance().getThemeInfo() == null) goto L13;
        if (getInstance().getThemeInfo().paths == null) goto L13;
        if (getInstance().getThemeInfo().paths.contains(r101) == false) goto L11;
        return true;
    L11:
        return defaultMultipleThemeForH5Paths.contains(r101);
    L13:
        return defaultMultipleThemeForH5Paths.contains(r101);
    }

    public boolean isThemeDark(Context r100) {
        return TextUtils.equals(this.mThemeMap.get(r100.getClass().getName()), "dark");
    L4:
        return false;
    }

    public boolean isThemeLight(Context r100) {
        return TextUtils.equals(this.mThemeMap.get(r100.getClass().getName()), "light");
    L4:
        return true;
    }

    private void setThemeDark(Activity r100, boolean r101, boolean r102) {
        if (r101 == false) goto L9;
        if (r102 == true) goto L5;
    L7:
        int r103 = R.style.CJ_Pay_Swipe_Theme_Dark_Sp;
    L8:
        r100.setTheme(r103);
    L15:
        this.mThemeMap.put(r100.getClass().getName(), "dark");
        return;
    L5:
        if (isUseDp() == false) goto L7;
        r103 = R.style.CJ_Pay_Swipe_Theme_Dark_Dp;
        goto L8
    L9:
        if (r102 == true) goto L11;
    L13:
        int r104 = R.style.CJ_Pay_Theme_Dark_Sp;
    L14:
        r100.setTheme(r104);
        goto L15
    L11:
        if (isUseDp() == false) goto L13;
        r104 = R.style.CJ_Pay_Theme_Dark_Dp;
        goto L14
    }

    private void setThemeLark(Activity r100, boolean r101, boolean r102) {
        if (r101 == false) goto L9;
        if (r102 == true) goto L5;
    L7:
        int r103 = R.style.CJ_Pay_Swipe_Theme_Lark_Sp;
    L8:
        r100.setTheme(r103);
    L15:
        this.mThemeMap.put(r100.getClass().getName(), "lark");
        return;
    L5:
        if (isUseDp() == false) goto L7;
        r103 = R.style.CJ_Pay_Swipe_Theme_Lark_Dp;
        goto L8
    L9:
        if (r102 == true) goto L11;
    L13:
        int r104 = R.style.CJ_Pay_Theme_Lark_Sp;
    L14:
        r100.setTheme(r104);
        goto L15
    L11:
        if (isUseDp() == false) goto L13;
        r104 = R.style.CJ_Pay_Theme_Lark_Dp;
        goto L14
    }

    private void setThemeLight(Activity r100, boolean r101, boolean r102) {
        if (r101 == false) goto L9;
        if (r102 == true) goto L5;
    L7:
        int r103 = R.style.CJ_Pay_Swipe_Theme_Light_Sp;
    L8:
        r100.setTheme(r103);
    L15:
        this.mThemeMap.put(r100.getClass().getName(), "light");
        return;
    L5:
        if (isUseDp() == false) goto L7;
        r103 = R.style.CJ_Pay_Swipe_Theme_Light_Dp;
        goto L8
    L9:
        if (r102 == true) goto L11;
    L13:
        int r104 = R.style.CJ_Pay_Theme_Light_Sp;
    L14:
        r100.setTheme(r104);
        goto L15
    L11:
        if (isUseDp() == false) goto L13;
        r104 = R.style.CJ_Pay_Theme_Light_Dp;
        goto L14
    }

    public void adjustStatusBarMode(Activity r100, View r101, boolean r102) {
        if (r102 == false) goto L37;
        String r103 = CJPayHostInfo.inheritTheme;
        if (TextUtils.isEmpty(r103) == true) goto L13;
        if ("light".equals(r103) == false) goto L10;
        CJPayImmersedStatusBarUtils.setStatusBarLightModeCompatLollipop(r100, true);
    L38:
        if (r101 == null) goto L41;
        r101.setBackgroundColor(CJPayThemeUtils.getColor(r100, R.attr.cj_pay_page_bg_color));
        return;
    L41:
        return;
    L10:
        if ("dark".equals(r103) == false) goto L38;
        CJPayImmersedStatusBarUtils.setStatusBarLightModeCompatLollipop(r100, false);
        goto L38
    L13:
        if (CJEnv.o() == true) goto L15;
        ThemeInfo r104 = getThemeInfo();
        if (r104 == null) goto L34;
        String r105 = r104.themeType;
        if ("light".equals(r105) == false) goto L27;
        CJPayImmersedStatusBarUtils.setStatusBarLightModeCompatLollipop(r100, true);
        goto L38
    L27:
        if ("dark".equals(r105) == false) goto L30;
        CJPayImmersedStatusBarUtils.setStatusBarLightModeCompatLollipop(r100, false);
        goto L38
    L30:
        if ("lark".equals(r105) == false) goto L32;
        CJPayImmersedStatusBarUtils.setStatusBarLightModeCompatLollipop(r100, true);
        goto L38
    L32:
        CJPayImmersedStatusBarUtils.setStatusBarLightModeCompatLollipop(r100, true);
        goto L38
    L34:
        if (isDouYin() == false) goto L36;
        CJPayImmersedStatusBarUtils.setStatusBarLightModeCompatLollipop(r100, false);
        goto L38
    L36:
        CJPayImmersedStatusBarUtils.setStatusBarLightModeCompatLollipop(r100, true);
        goto L38
    L15:
        if (AppCompatDelegate.getDefaultNightMode() != 2) goto L18;
        CJPayImmersedStatusBarUtils.setStatusBarLightModeCompatLollipop(r100, false);
        goto L38
    L18:
        if (AppCompatDelegate.getDefaultNightMode() != 1) goto L20;
        CJPayImmersedStatusBarUtils.setStatusBarLightModeCompatLollipop(r100, true);
        goto L38
    L20:
        CJPayImmersedStatusBarUtils.setStatusBarLightModeCompatLollipop(r100, true);
        goto L38
    L37:
        CJPayImmersedStatusBarUtils.setStatusBarLightModeCompatLollipop(r100, true);
        goto L38
    }

    public void applyDarkTheme(AppCompatActivity r100, boolean r101, boolean r102) {
        if (r101 == false) goto L5;
        return;
    L5:
        if (CJUiOptimizeUtil.INSTANCE.isUseDarkOpt() == true) goto L7;
    L9:
        setTheme(r100, "light", false, r102);
        this.uiComponentNeedDark = false;
        return;
    L7:
        if (CJEnv.f().isDarkMode() == false) goto L9;
        setTheme(r100, "dark", false, r102);
        this.uiComponentNeedDark = true;
    }

    public void setStatusBar(Activity r100, View r101, boolean r102) {
        if (r102 == false) goto L34;
        String r103 = CJPayHostInfo.inheritTheme;
        if (TextUtils.isEmpty(r103) == true) goto L13;
        if ("light".equals(r103) == false) goto L10;
        CJPayImmersedStatusBarUtils.adjustStatusBarLightMode(r100, r101, true);
    L35:
        if (r101 == null) goto L38;
        r101.setBackgroundColor(CJPayThemeUtils.getColor(r100, R.attr.cj_pay_page_bg_color));
        return;
    L38:
        return;
    L10:
        if ("dark".equals(r103) == false) goto L35;
        CJPayImmersedStatusBarUtils.adjustStatusBarLightMode(r100, r101, false);
        goto L35
    L13:
        if (CJEnv.o() == true) goto L15;
        ThemeInfo r104 = getThemeInfo();
        if (r104 == null) goto L33;
        String r105 = r104.themeType;
        if ("light".equals(r105) == false) goto L27;
        CJPayImmersedStatusBarUtils.adjustStatusBarLightMode(r100, r101, true);
        goto L35
    L27:
        if ("dark".equals(r105) == false) goto L30;
        CJPayImmersedStatusBarUtils.adjustStatusBarLightMode(r100, r101, false);
        goto L35
    L30:
        if ("lark".equals(r105) == false) goto L32;
        CJPayImmersedStatusBarUtils.adjustStatusBarLightMode(r100, r101, true);
        goto L35
    L32:
        CJPayImmersedStatusBarUtils.adjustStatusBarLightMode(r100, r101, true);
        goto L35
    L33:
        CJPayImmersedStatusBarUtils.adjustStatusBarLightMode(r100, r101, true);
        goto L35
    L15:
        if (AppCompatDelegate.getDefaultNightMode() != 2) goto L18;
        CJPayImmersedStatusBarUtils.adjustStatusBarLightMode(r100, r101, false);
        goto L35
    L18:
        if (AppCompatDelegate.getDefaultNightMode() != 1) goto L20;
        CJPayImmersedStatusBarUtils.adjustStatusBarLightMode(r100, r101, true);
        goto L35
    L20:
        CJPayImmersedStatusBarUtils.adjustStatusBarLightMode(r100, r101, true);
        goto L35
    L34:
        CJPayImmersedStatusBarUtils.adjustStatusBarLightMode(r100, r101, true);
        goto L35
    }

    private void setTheme(Activity r100, String r101, boolean r102, boolean r103) {
        r101.getClass();
        byte r104 = -1;
        switch(r101.hashCode()) {
            case 3075958: goto L14;
            case 3314286: goto L10;
            case 102970646: goto L6;
            default: goto L17;
        };
    L17:
        switch(r104) {
            case 0: goto L21;
            case 1: goto L20;
            case 2: goto L19;
            default: goto L18;
        };
    L18:
        setThemeLight(r100, r102, r103);
        return;
    L19:
        setThemeLight(r100, r102, r103);
        return;
    L20:
        setThemeLark(r100, r102, r103);
        return;
    L21:
        setThemeDark(r100, r102, r103);
        return;
    L6:
        if (r101.equals("light") == false) goto L17;
        r104 = 2;
        goto L17
    L10:
        if (r101.equals("lark") == false) goto L17;
        r104 = 1;
        goto L17
    L14:
        if (r101.equals("dark") == false) goto L17;
        r104 = 0;
        goto L17
    }

    public void applyStyle(Activity r100, boolean r101, boolean r102, boolean r103) {
        if (r101 == false) goto L38;
        String r104 = CJPayHostInfo.inheritTheme;
        if (TextUtils.isEmpty(r104) == true) goto L14;
        if ("light".equals(r104) == false) goto L10;
        setTheme(r100, "light", r102, r103);
        return;
    L10:
        if ("dark".equals(r104) == false) goto L12;
        setTheme(r100, "dark", r102, r103);
        return;
    L12:
        setTheme(r100, "light", r102, r103);
        return;
    L14:
        if (CJEnv.o() == true) goto L16;
        ThemeInfo r105 = getThemeInfo();
        if (r105 == null) goto L35;
        String r106 = r105.themeType;
        if ("light".equals(r106) == false) goto L28;
        setTheme(r100, "light", r102, r103);
        return;
    L28:
        if ("dark".equals(r106) == false) goto L31;
        setTheme(r100, "dark", r102, r103);
        return;
    L31:
        if ("lark".equals(r106) == false) goto L33;
        setTheme(r100, "lark", r102, r103);
        return;
    L33:
        setTheme(r100, "light", r102, r103);
        return;
    L35:
        if (isDouYin() == false) goto L37;
        setTheme(r100, "dark", r102, r103);
        return;
    L37:
        setTheme(r100, "light", r102, r103);
        return;
    L16:
        if (AppCompatDelegate.getDefaultNightMode() != 2) goto L19;
        setTheme(r100, "dark", r102, r103);
        return;
    L19:
        if (AppCompatDelegate.getDefaultNightMode() != 1) goto L21;
        setTheme(r100, "light", r102, r103);
        return;
    L21:
        setTheme(r100, "light", r102, r103);
        return;
    L38:
        setTheme(r100, "light", r102, r103);
    }
}
