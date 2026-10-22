package com.stepos.policy.sdk.config;

import C7.c;
import kotlin.Metadata;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u000e\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u001d\u001a\u00020\b2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0004H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\u00020\u00048\u0006X\u0087T¢\u0006\b\n\u0000\u0012\u0004\b\u000b\u0010\u0002R\u000e\u0010\f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\bX\u0086T¢\u0006\u0002\n\u0000R\u0016\u0010\u0014\u001a\u00020\b8\u0006X\u0087T¢\u0006\b\n\u0000\u0012\u0004\b\u0015\u0010\u0002R\u000e\u0010\u0016\u001a\u00020\bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u000eX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u000eX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lcom/stepos/policy/sdk/config/PolicySdkConstants;", "", "()V", "BUNDLE_KEY_CATEGORY", "", "BUNDLE_KEY_LANGUAGE", "BUNDLE_KEY_VERSION", "HIDE_SETTING_BUTTON", "", "ONLINE_POLICY_HTML_VIEWER", "ONLINE_POLICY_WEB_VIEW", "getONLINE_POLICY_WEB_VIEW$annotations", "ONLINE_POLICY_WEB_VIEW_BUNDLE_KEY", "ONLINE_POLICY_WEB_VIEW_DEFAULT", "", "POLICY_AUTO_RECORD", "POLICY_NEWEST_VERSION_DEFAULT", "", "POLICY_NOT_AUTO_RECORD", "POLICY_OPEN_BY_BROWSER", "POLICY_OPEN_BY_WEBVIEW", "getPOLICY_OPEN_BY_WEBVIEW$annotations", "POLICY_OPEN_IN_APP", "SHOW_SETTING_BUTTON", "TEMP", "VERSION_NAME", "grant_need", "grant_no_need", "policyFileDir", "isOnlinePolicyViewerUri", "uri", "policysdk_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class PolicySdkConstants {
    public static final String BUNDLE_KEY_CATEGORY = "bundle_key_category";
    public static final String BUNDLE_KEY_LANGUAGE = "bundle_key_language";
    public static final String BUNDLE_KEY_VERSION = "bundle_key_version";
    public static final boolean HIDE_SETTING_BUTTON = false;
    public static final PolicySdkConstants INSTANCE = new PolicySdkConstants();
    public static final String ONLINE_POLICY_HTML_VIEWER = "online_policy_html_viewer";
    public static final String ONLINE_POLICY_WEB_VIEW = "online_policy_web_view";
    public static final String ONLINE_POLICY_WEB_VIEW_BUNDLE_KEY = "bundle_key_errorCode";
    public static final int ONLINE_POLICY_WEB_VIEW_DEFAULT = 0;
    public static final boolean POLICY_AUTO_RECORD = true;
    public static final long POLICY_NEWEST_VERSION_DEFAULT = 0;
    public static final boolean POLICY_NOT_AUTO_RECORD = false;
    public static final boolean POLICY_OPEN_BY_BROWSER = false;
    public static final boolean POLICY_OPEN_BY_WEBVIEW = true;
    public static final boolean POLICY_OPEN_IN_APP = true;
    public static final boolean SHOW_SETTING_BUTTON = true;
    public static final String TEMP = "policy_temp";
    public static final String VERSION_NAME = "1.0.18_20260724_152936";
    public static final int grant_need = 1;
    public static final int grant_no_need = 0;
    public static final String policyFileDir = "policy";

    private PolicySdkConstants() {
    }

    @c
    public static /* synthetic */ void getONLINE_POLICY_WEB_VIEW$annotations() {
    }

    @c
    public static /* synthetic */ void getPOLICY_OPEN_BY_WEBVIEW$annotations() {
    }

    public static final boolean isOnlinePolicyViewerUri(String uri) {
        return k.b(uri, ONLINE_POLICY_HTML_VIEWER) || k.b(uri, ONLINE_POLICY_WEB_VIEW);
    }
}
