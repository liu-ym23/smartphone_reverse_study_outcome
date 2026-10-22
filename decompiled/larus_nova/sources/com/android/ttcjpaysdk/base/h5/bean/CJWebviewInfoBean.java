package com.android.ttcjpaysdk.base.h5.bean;

import android.net.Uri;
import android.text.TextUtils;
import com.android.ttcjpaysdk.base.h5.CJPayH5Activity;
import com.android.ttcjpaysdk.base.h5.CJPayH5CommonConfig;
import com.android.ttcjpaysdk.base.h5.utils.CJPayUrlUtils;
import com.android.ttcjpaysdk.base.utils.CJBasicCommonUtils;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import java.io.Serializable;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/* JADX INFO: loaded from: classes28.dex */
public class CJWebviewInfoBean implements Serializable {
    public static String KernelType_HYBRIDKIT = "1";
    public static String KernelType_OLD = "0";
    private static final String TAG = "CJWebviewInfoBean2";
    public String abtestKeys;
    public String backButtonColor;
    public String backButtonIcon;
    public String backHookAction;
    public String backgroundColor;
    public String bankName;
    public boolean broadcastDOMContentLoaded;
    public int callbackId;
    public int canvasMode;
    public int disableClose;
    public int enableAnimation;
    public int enableFontScale;
    public int fullPage;
    public String hideStatusBar;
    public String hideTitleBar;
    public String hostBackUrl;
    public String htmlAppendCommonParams;
    public boolean isCaijingSaas;
    public boolean isDisableH5History;
    public boolean isFromBanner;
    public boolean isNeedTransparant;
    public boolean isQuickbindSafeStyle;
    public String keepOriginalQuery;
    private String kernelType;
    public String navigationBarColor;
    public String openMethod;
    public String postFormData;
    public String rifleMegaObject;
    public String rifleMegaObjectId;
    public String rightButtonColor;
    public String rightButtonType;
    public String schemaStr;
    public String settingsKeys;
    public int showLoading;
    public String statusBarColor;
    public String statusBarTextStyle;
    public int timeout;
    public String title;
    public String titleBarBgColor;
    public String titleTextColor;
    public String url;

    public boolean appendHtmlCommonParams() {
        if (TextUtils.equals(this.htmlAppendCommonParams, "1") == false) goto L6;
        return true;
    L6:
        return false;
    }

    public String getKernelType() {
        String r100 = this.kernelType;
        if (r100 == null) goto L6;
        return r100;
    L6:
        return KernelType_OLD;
    }

    public boolean isModalView() {
        if (this.fullPage != (-1)) goto L6;
        return false;
    L6:
        return true;
    }

    public CJWebviewInfoBean() {
        this.timeout = -1;
        this.disableClose = 0;
        this.canvasMode = 0;
        this.hostBackUrl = "";
        this.keepOriginalQuery = "";
        this.enableFontScale = 1;
        this.openMethod = MonitorConstants.CONNECT_TYPE_GET;
        this.postFormData = "";
        this.kernelType = KernelType_OLD;
        this.settingsKeys = "";
        this.abtestKeys = "";
        this.backHookAction = "";
        this.broadcastDOMContentLoaded = false;
        this.isCaijingSaas = false;
        this.htmlAppendCommonParams = "";
        this.navigationBarColor = "";
        this.fullPage = -1;
        this.isNeedTransparant = false;
        this.isFromBanner = false;
        this.callbackId = -1;
        this.isDisableH5History = false;
    }

    public CJWebviewInfoBean(Uri r110) {
        this.timeout = -1;
        this.disableClose = 0;
        this.canvasMode = 0;
        this.hostBackUrl = "";
        this.keepOriginalQuery = "";
        this.enableFontScale = 1;
        this.openMethod = MonitorConstants.CONNECT_TYPE_GET;
        this.postFormData = "";
        this.kernelType = KernelType_OLD;
        this.settingsKeys = "";
        this.abtestKeys = "";
        this.backHookAction = "";
        this.broadcastDOMContentLoaded = false;
        this.isCaijingSaas = false;
        this.htmlAppendCommonParams = "";
        this.navigationBarColor = "";
        this.fullPage = -1;
        this.isNeedTransparant = false;
        this.isFromBanner = false;
        this.callbackId = -1;
        this.isDisableH5History = false;
        this.schemaStr = r110.toString();
        this.url = getQueryParam(r110, "url");
        optKernelType(r110);
        this.title = getQueryParam(r110, "title");
        this.titleTextColor = getQueryParam(r110, "title_text_color");
        this.titleBarBgColor = getQueryParam(r110, "title_bar_bg_color");
        this.backButtonColor = getQueryParam(r110, "back_button_color");
        String r100 = getQueryParam(r110, "back_button_icon");
        this.backButtonIcon = r100;
        if (TextUtils.isEmpty(r100) == false) goto L5;
        String r101 = "arrow";
    L6:
        this.backButtonIcon = r101;
        String r102 = getQueryParam(r110, "hide_status_bar");
        this.hideStatusBar = r102;
        String r103 = "0";
        if (TextUtils.isEmpty(r102) == false) goto L9;
        String r104 = "0";
    L10:
        this.hideStatusBar = r104;
        this.statusBarTextStyle = getQueryParam(r110, "status_bar_text_style");
        this.backgroundColor = getQueryParam(r110, "background_color");
        this.bankName = getQueryParam(r110, "bank_name");
        if ("1".equals(getQueryParam(r110, "is_caijing_saas")) == false) goto L13;
        this.isCaijingSaas = true;
    L15:
        if ("1".equals(getQueryParam(r110, "bank_sign")) == false) goto L17;
        this.isQuickbindSafeStyle = true;
    L19:
        if ("1".equals(getQueryParam(r110, "disable_history")) == false) goto L21;
        this.isDisableH5History = true;
    L22:
        String r105 = getQueryParam(r110, "hide_title_bar");
        this.hideTitleBar = r105;
        if (TextUtils.isEmpty(r105) == true) goto L26;
        r103 = this.hideTitleBar;
    L26:
        this.hideTitleBar = r103;
        String r106 = getQueryParam(r110, CJPayH5CommonConfig.RIFLE_MEGA_OBJECT);
        this.rifleMegaObject = r106;
        if (TextUtils.isEmpty(r106) == false) goto L80;
    L32:
        this.rightButtonType = getQueryParam(r110, CJPayH5CommonConfig.RIGHT_BUTTON_TYPE);
        this.statusBarColor = getQueryParam(r110, CJPayH5CommonConfig.KEY_STATUS_BAR_COLOR);
        this.rightButtonColor = getQueryParam(r110, CJPayH5CommonConfig.RIGHT_BUTTON_COLOR);
        this.timeout = CastIntegerProtector.parseInt(getQueryParam(r110, "cj_timeout"));     // Catch: Exception -> L35
    L74:
        this.disableClose = CastIntegerProtector.parseInt(getQueryParam(r110, "cj_disable_close"));     // Catch: Exception -> L39
    L72:
        this.canvasMode = CastIntegerProtector.parseInt(getQueryParam(r110, "canvas_mode"));     // Catch: Exception -> L43
    L76:
        this.fullPage = CastIntegerProtector.valueOf(getQueryParam(r110, "fullpage")).intValue();     // Catch: Exception -> L47
    L50:
        if (this.fullPage == (-1)) goto L78;
        this.isNeedTransparant = true;
    L78:
        this.enableAnimation = CastIntegerProtector.valueOf(getQueryParam(r110, "enable_animation")).intValue();     // Catch: Exception -> L54
    L70:
        this.showLoading = CastIntegerProtector.valueOf(getQueryParam(r110, "show_loading")).intValue();     // Catch: Exception -> L58
    L84:
        this.enableFontScale = CastIntegerProtector.parseInt(getQueryParam(r110, "enable_font_scale"));     // Catch: Exception -> L62
    L82:
        this.openMethod = getQueryParam(r110, "open_method");     // Catch: Exception -> L66
    L68:
        this.postFormData = getQueryParam(r110, CJPayH5Activity.CJ_PAY_REQUEST_FORM_DATA);
        this.hostBackUrl = getQueryParam(r110, CJPayH5CommonConfig.KEY_PARAMS_HOST_BACK_URL);
        this.keepOriginalQuery = getQueryParam(r110, CJPayH5CommonConfig.KEY_KEEP_ORIGINAL_QUERY);
        this.settingsKeys = getQueryParam(r110, CJPayH5CommonConfig.CJ_SETTINGS_KEYS);
        this.abtestKeys = getQueryParam(r110, CJPayH5CommonConfig.CJ_ABTEST_KEYS);
        this.backHookAction = getQueryParam(r110, "back_hook_action");
        this.broadcastDOMContentLoaded = TextUtils.equals(getQueryParam(r110, "broadcast_dom_content_loaded"), "1");
        this.htmlAppendCommonParams = getQueryParam(r110, "append_common_params");
        this.navigationBarColor = getQueryParam(r110, "navigation_bar_color");
        return;
    L66:
        e = move-exception;
        CJBasicCommonUtils.reportCatchException("CJWebviewInfoBean#<init>#openMethod", e);
        CJBasicCommonUtils.logCatch("CJCatch", "CJWebviewInfoBean#<init>#openMethod", e);
        this.openMethod = MonitorConstants.CONNECT_TYPE_GET;
    L62:
        e = move-exception;
        CJBasicCommonUtils.logCatch("CJCatch", "CJWebviewInfoBean#<init>#enableFontScale", e);
        this.enableFontScale = 1;
    L58:
        e = move-exception;
        CJBasicCommonUtils.logCatch("CJCatch", "CJWebviewInfoBean#<init>#showLoading", e);
        this.showLoading = 1;
    L54:
        e = move-exception;
        CJBasicCommonUtils.logCatch("CJCatch", "CJWebviewInfoBean#<init>#enableAnimation", e);
        this.enableAnimation = 1;
    L47:
        e = move-exception;
        CJBasicCommonUtils.logCatch("CJCatch", "CJWebviewInfoBean#<init>#fullPage", e);
        this.fullPage = -1;
    L43:
        e = move-exception;
        CJBasicCommonUtils.logCatch("CJCatch", "CJWebviewInfoBean#<init>#canvasMode", e);
        this.canvasMode = 0;
    L39:
        e = move-exception;
        CJBasicCommonUtils.logCatch("CJCatch", "CJWebviewInfoBean#<init>#disableClose", e);
        this.disableClose = 0;
    L35:
        e = move-exception;
        CJBasicCommonUtils.logCatch("CJCatch", "CJWebviewInfoBean#<init>#timeout", e);
        this.timeout = -1;
        goto L74
    L80:
        this.rifleMegaObjectId = UUID.randomUUID().toString();     // Catch: Exception -> L30
        HashMap r107 = new HashMap();     // Catch: Exception -> L30
        r107.put(CJPayH5CommonConfig.RIFLE_MEGA_OBJECT_ID, this.rifleMegaObjectId);     // Catch: Exception -> L30
        this.url = CJPayUrlUtils.appendUrlParamsToScheme(this.url, r107);     // Catch: Exception -> L30
    L30:
        e = move-exception;
        CJBasicCommonUtils.reportCatchException("CJWebviewInfoBean#<init>#rifleMegaObject", e);
        CJBasicCommonUtils.logCatch("CJCatch", "CJWebviewInfoBean#<init>#rifleMegaObject", e);
        goto L32
    L21:
        this.isDisableH5History = false;
        goto L22
    L17:
        this.isQuickbindSafeStyle = false;
        goto L19
    L13:
        this.isCaijingSaas = false;
        goto L15
    L9:
        r104 = this.hideStatusBar;
        goto L10
    L5:
        r101 = this.backButtonIcon;
        goto L6
    }

    private void optKernelType(Uri r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (TextUtils.equals(getQueryParam(r100, CJPayH5CommonConfig.KERNEL_TYPE), KernelType_HYBRIDKIT) == false) goto L8;
        this.kernelType = KernelType_HYBRIDKIT;
        return;
    }

    public CJWebviewInfoBean(Uri r100, Map<String, String> r101) {
        this(r100);
        if (r101 == null) goto L6;
        this.url = CJPayUrlUtils.appendUrlParamsToScheme(this.url, r101);
        return;
    }

    private String getQueryParam(Uri r100, String r101) {
        if (TextUtils.isEmpty(UriProtector.getQueryParameter(r100, r101)) == false) goto L6;
        return "";
    L6:
        return URLDecoder.decode(UriProtector.getQueryParameter(r100, r101));
    }
}
