package com.android.ttcjpaysdk.base.service.bean;

import android.content.Context;
import android.text.TextUtils;
import com.android.ttcjpaysdk.base.utils.CJBasicCommonUtils;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class H5ParamBuilder {
    private String abtestKeys;
    private String backButtonColor;
    private String backButtonIcon;
    private String backHookAction;
    private String bankName;
    private int callbackId;
    private int canvasMode;
    private String cashdeskScene;
    private JSONObject channelInfo;
    private Context context;
    private int disableClose;
    private boolean disableH5History;
    private boolean enableAnim;
    public int enableFontScale;
    private String enterFrom;
    private Map<String, String> extendParams;
    private String formData;
    private String hideLoading;
    private String hostBackUrl;
    private JSONObject hostInfo;
    private boolean isCaijingSaas;
    private boolean isFromBanner;
    private boolean isFromDouPlus;
    private boolean isFromWxIndependentSign;
    private Boolean isHideWebView;
    private boolean isNeedTransparentActivity;
    private boolean isPreFetchData;
    private boolean isQuickbindSafeStyle;
    private boolean isShowTitle;
    private boolean isShowTitleBar;
    private String isTransTitleBar;
    private String keepOriginalQuery;
    private String kernelType;
    private String modalViewBgcolor;
    private String navigationBarColor;
    private JSONObject orderInfo;
    private String referer;
    private String requestType;
    private String rifleMegaObject;
    private String rifleMegaObjectId;
    private String rightBtnColor;
    private String rightButtonType;
    private JSONObject riskInfo;
    private int screenType;
    private String settingsKeys;
    private boolean showLoading;
    private String statusBarColor;
    private String statusBarColor2;
    private String statusBarTextStyle;
    private int timeout;
    private String title;
    private String titleBarBgColor;
    private String titleTextColor;
    private String url;

    public String getExtendParams() {
        if (this.extendParams.isEmpty() == false) goto L9;
    L8:
        return "";
    L9:
        return new JSONObject(this.extendParams).toString();
    L6:
        e = move-exception;
        CJBasicCommonUtils.reportCatchException("H5ParamBuilder#getExtendParams", e);
        CJBasicCommonUtils.logCatch("CJCatch", "H5ParamBuilder#getExtendParams", e);
        e.printStackTrace();
        goto L8
    }

    public String getRightBtnColor() {
        if (TextUtils.isEmpty(this.rightBtnColor) == false) goto L6;
        return "#161823";
    L6:
        return this.rightBtnColor;
    }

    public String getStatusBarColor() {
        if (TextUtils.isEmpty(this.statusBarColor) == false) goto L6;
        return "#ffffff";
    L6:
        return this.statusBarColor;
    }

    public String getTitle() {
        if ("0".equals(this.isTransTitleBar) == true) goto L7;
        return "";
    L7:
        return this.title;
    }

    public boolean isShowTitle() {
        return "0".equals(this.isTransTitleBar);
    }

    public H5ParamBuilder() {
        this.title = "";
        this.isShowTitle = true;
        this.isShowTitleBar = true;
        this.isTransTitleBar = "0";
        this.statusBarColor = "";
        this.statusBarColor2 = "";
        this.rightBtnColor = "";
        this.backButtonColor = "";
        this.backButtonIcon = "arrow";
        this.screenType = 0;
        this.showLoading = true;
        this.disableClose = 0;
        this.timeout = -1;
        this.canvasMode = 0;
        this.hideLoading = "";
        this.isPreFetchData = true;
        this.hostBackUrl = "";
        this.keepOriginalQuery = "";
        this.extendParams = new HashMap();
        this.callbackId = -1;
        this.enableFontScale = 1;
        this.rifleMegaObject = "";
        this.rifleMegaObjectId = "";
        this.rightButtonType = "";
        this.kernelType = "";
        this.settingsKeys = "";
        this.abtestKeys = "";
        this.backHookAction = "";
        this.isCaijingSaas = false;
    }

    public String getAbtestKeys() {
        return this.abtestKeys;
    }

    public String getBackButtonColor() {
        return this.backButtonColor;
    }

    public String getBackButtonIcon() {
        return this.backButtonIcon;
    }

    public String getBackHookAction() {
        return this.backHookAction;
    }

    public String getBankName() {
        return this.bankName;
    }

    public int getCallbackId() {
        return this.callbackId;
    }

    public int getCanvasMode() {
        return this.canvasMode;
    }

    public String getCashdeskScene() {
        return this.cashdeskScene;
    }

    public JSONObject getChannelInfo() {
        return this.channelInfo;
    }

    public Context getContext() {
        return this.context;
    }

    public int getDisableClose() {
        return this.disableClose;
    }

    public int getEnableFontScale() {
        return this.enableFontScale;
    }

    public String getEnterFrom() {
        return this.enterFrom;
    }

    public String getFormData() {
        return this.formData;
    }

    public String getHideLoading() {
        return this.hideLoading;
    }

    public Boolean getHideWebView() {
        return this.isHideWebView;
    }

    public String getHostBackUrl() {
        return this.hostBackUrl;
    }

    public JSONObject getHostInfo() {
        return this.hostInfo;
    }

    public boolean getIsCaijingSaas() {
        return this.isCaijingSaas;
    }

    public String getIsTransTitleBar() {
        return this.isTransTitleBar;
    }

    public String getKeepOriginalQuery() {
        return this.keepOriginalQuery;
    }

    public String getKernelType() {
        return this.kernelType;
    }

    public String getModalViewBgcolor() {
        return this.modalViewBgcolor;
    }

    public String getNavigationBarColor() {
        return this.navigationBarColor;
    }

    public JSONObject getOrderInfo() {
        return this.orderInfo;
    }

    public String getReferer() {
        return this.referer;
    }

    public String getRequestType() {
        return this.requestType;
    }

    public String getRifleMegaObject() {
        return this.rifleMegaObject;
    }

    public String getRifleMegaObjectId() {
        return this.rifleMegaObjectId;
    }

    public String getRightButtonType() {
        return this.rightButtonType;
    }

    public JSONObject getRiskInfo() {
        return this.riskInfo;
    }

    public int getScreenType() {
        return this.screenType;
    }

    public String getSettingsKeys() {
        return this.settingsKeys;
    }

    public String getStatusBarColor2() {
        return this.statusBarColor2;
    }

    public String getStatusBarTextStyle() {
        return this.statusBarTextStyle;
    }

    public int getTimeout() {
        return this.timeout;
    }

    public String getTitleBarBgColor() {
        return this.titleBarBgColor;
    }

    public String getTitleTextColor() {
        return this.titleTextColor;
    }

    public String getUrl() {
        return this.url;
    }

    public boolean isDisableH5History() {
        return this.disableH5History;
    }

    public boolean isEnableAnim() {
        return this.enableAnim;
    }

    public boolean isFromBanner() {
        return this.isFromBanner;
    }

    public boolean isFromDouPlus() {
        return this.isFromDouPlus;
    }

    public boolean isFromWxIndependentSign() {
        return this.isFromWxIndependentSign;
    }

    public boolean isNeedTransparentActivity() {
        return this.isNeedTransparentActivity;
    }

    public boolean isPreFetchData() {
        return this.isPreFetchData;
    }

    public boolean isQuickbindSafeStyle() {
        return this.isQuickbindSafeStyle;
    }

    public boolean isShowLoading() {
        return this.showLoading;
    }

    public boolean isShowTitleBar() {
        return this.isShowTitleBar;
    }

    public String isTransTitleBar() {
        return this.isTransTitleBar;
    }

    public H5ParamBuilder setAbtestKeys(String r100) {
        this.abtestKeys = r100;
        return this;
    }

    public H5ParamBuilder setBackButtonColor(String r100) {
        this.backButtonColor = r100;
        return this;
    }

    public H5ParamBuilder setBackButtonIcon(String r100) {
        this.backButtonIcon = r100;
        return this;
    }

    public H5ParamBuilder setBackHookAction(String r100) {
        this.backHookAction = r100;
        return this;
    }

    public H5ParamBuilder setBankName(String r100) {
        this.bankName = r100;
        return this;
    }

    public H5ParamBuilder setCallbackId(int r100) {
        this.callbackId = r100;
        return this;
    }

    public H5ParamBuilder setCanvasMode(int r100) {
        this.canvasMode = r100;
        return this;
    }

    public H5ParamBuilder setCashDeskScene(String r100) {
        this.cashdeskScene = r100;
        return this;
    }

    public H5ParamBuilder setChannelInfo(JSONObject r100) {
        this.channelInfo = r100;
        return this;
    }

    public H5ParamBuilder setContext(Context r100) {
        this.context = r100;
        return this;
    }

    public H5ParamBuilder setDisableClose(int r100) {
        this.disableClose = r100;
        return this;
    }

    public H5ParamBuilder setDisableH5History(boolean r100) {
        this.disableH5History = r100;
        return this;
    }

    public H5ParamBuilder setEnableAnim(boolean r100) {
        this.enableAnim = r100;
        return this;
    }

    public H5ParamBuilder setEnableFontScale(int r100) {
        this.enableFontScale = r100;
        return this;
    }

    public H5ParamBuilder setEnterFrom(String r100) {
        this.enterFrom = r100;
        return this;
    }

    public H5ParamBuilder setExtendParams(Map<String, String> r100) {
        this.extendParams = r100;
        return this;
    }

    public H5ParamBuilder setFormData(String r100) {
        this.formData = r100;
        return this;
    }

    public H5ParamBuilder setFromBanner(boolean r100) {
        this.isFromBanner = r100;
        return this;
    }

    public H5ParamBuilder setFromDouPlus(boolean r100) {
        this.isFromDouPlus = r100;
        return this;
    }

    public H5ParamBuilder setFromWxIndependentSign(boolean r100) {
        this.isFromWxIndependentSign = r100;
        return this;
    }

    public H5ParamBuilder setHideLoading(String r100) {
        this.hideLoading = r100;
        return this;
    }

    public H5ParamBuilder setHideWebView(Boolean r100) {
        this.isHideWebView = r100;
        return this;
    }

    public H5ParamBuilder setHostBackUrl(String r100) {
        this.hostBackUrl = r100;
        return this;
    }

    public H5ParamBuilder setHostInfo(JSONObject r100) {
        this.hostInfo = r100;
        return this;
    }

    public H5ParamBuilder setIsCaijingSaas(boolean r100) {
        this.isCaijingSaas = r100;
        return this;
    }

    public H5ParamBuilder setIsTransTitleBar(String r100) {
        this.isTransTitleBar = r100;
        return this;
    }

    public H5ParamBuilder setKeepOriginalQuery(String r100) {
        this.keepOriginalQuery = r100;
        return this;
    }

    public H5ParamBuilder setKernelType(String r100) {
        this.kernelType = r100;
        return this;
    }

    public H5ParamBuilder setModalViewBgcolor(String r100) {
        this.modalViewBgcolor = r100;
        return this;
    }

    public H5ParamBuilder setNavigationBarColor(String r100) {
        this.navigationBarColor = r100;
        return this;
    }

    public H5ParamBuilder setNeedTransparentActivity(boolean r100) {
        this.isNeedTransparentActivity = r100;
        return this;
    }

    public H5ParamBuilder setOrderInfo(JSONObject r100) {
        this.orderInfo = r100;
        return this;
    }

    public H5ParamBuilder setPreFetchData(boolean r100) {
        this.isPreFetchData = r100;
        return this;
    }

    public H5ParamBuilder setQuickbindSafeStyle(boolean r100) {
        this.isQuickbindSafeStyle = r100;
        return this;
    }

    public H5ParamBuilder setReferer(String r100) {
        this.referer = r100;
        return this;
    }

    public H5ParamBuilder setRequestType(String r100) {
        this.requestType = r100;
        return this;
    }

    public H5ParamBuilder setRifleMegaObject(String r100) {
        this.rifleMegaObject = r100;
        return this;
    }

    public H5ParamBuilder setRifleMegaObjectId(String r100) {
        this.rifleMegaObjectId = r100;
        return this;
    }

    public H5ParamBuilder setRightBtnColor(String r100) {
        this.rightBtnColor = r100;
        return this;
    }

    public H5ParamBuilder setRightButtonType(String r100) {
        this.rightButtonType = r100;
        return this;
    }

    public H5ParamBuilder setRiskInfo(JSONObject r100) {
        this.riskInfo = r100;
        return this;
    }

    public H5ParamBuilder setScreenType(int r100) {
        this.screenType = r100;
        return this;
    }

    public H5ParamBuilder setSettingsKeys(String r100) {
        this.settingsKeys = r100;
        return this;
    }

    public H5ParamBuilder setShowLoading(boolean r100) {
        this.showLoading = r100;
        return this;
    }

    public H5ParamBuilder setShowTitle(boolean r100) {
        this.isShowTitle = r100;
        return this;
    }

    public H5ParamBuilder setShowTitleBar(boolean r100) {
        this.isShowTitleBar = r100;
        return this;
    }

    public H5ParamBuilder setStatusBarColor(String r100) {
        this.statusBarColor = r100;
        return this;
    }

    public H5ParamBuilder setStatusBarColor2(String r100) {
        this.statusBarColor2 = r100;
        return this;
    }

    public H5ParamBuilder setStatusBarTextStyle(String r100) {
        this.statusBarTextStyle = r100;
        return this;
    }

    public H5ParamBuilder setTimeout(int r100) {
        this.timeout = r100;
        return this;
    }

    public H5ParamBuilder setTitle(String r100) {
        this.title = r100;
        return this;
    }

    public H5ParamBuilder setTitleBarBgColor(String r100) {
        this.titleBarBgColor = r100;
        return this;
    }

    public H5ParamBuilder setTitleTextColor(String r100) {
        this.titleTextColor = r100;
        return this;
    }

    public H5ParamBuilder setUrl(String r100) {
        this.url = r100;
        return this;
    }
}
