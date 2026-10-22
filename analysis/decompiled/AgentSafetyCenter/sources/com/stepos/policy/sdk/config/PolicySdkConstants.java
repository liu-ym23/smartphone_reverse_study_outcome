package com.stepos.policy.sdk.config;

import jb.a;
import yb.k;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
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
    public static final String VERSION_NAME = "1.0.15_20260708_195137";
    public static final int grant_need = 1;
    public static final int grant_no_need = 0;
    public static final String policyFileDir = "policy";

    private PolicySdkConstants() {
    }

    public static final boolean isOnlinePolicyViewerUri(String str) {
        return k.a(str, ONLINE_POLICY_HTML_VIEWER) || k.a(str, ONLINE_POLICY_WEB_VIEW);
    }

    @a
    public static /* synthetic */ void getONLINE_POLICY_WEB_VIEW$annotations() {
    }

    @a
    public static /* synthetic */ void getPOLICY_OPEN_BY_WEBVIEW$annotations() {
    }
}
