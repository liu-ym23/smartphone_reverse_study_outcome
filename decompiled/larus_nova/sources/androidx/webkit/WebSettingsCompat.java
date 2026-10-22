package androidx.webkit;

import android.webkit.WebSettings;
import androidx.webkit.internal.ApiFeature;
import androidx.webkit.internal.ApiHelperForM;
import androidx.webkit.internal.ApiHelperForN;
import androidx.webkit.internal.ApiHelperForO;
import androidx.webkit.internal.ApiHelperForQ;
import androidx.webkit.internal.WebSettingsAdapter;
import androidx.webkit.internal.WebViewFeatureInternal;
import androidx.webkit.internal.WebViewGlueCommunicator;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* JADX INFO: loaded from: classes17.dex */
public class WebSettingsCompat {
    public static final int DARK_STRATEGY_PREFER_WEB_THEME_OVER_USER_AGENT_DARKENING = 2;
    public static final int DARK_STRATEGY_USER_AGENT_DARKENING_ONLY = 0;
    public static final int DARK_STRATEGY_WEB_THEME_DARKENING_ONLY = 1;
    public static final int FORCE_DARK_AUTO = 1;
    public static final int FORCE_DARK_OFF = 0;
    public static final int FORCE_DARK_ON = 2;
    public static final int REQUESTED_WITH_HEADER_MODE_APP_PACKAGE_NAME = 1;
    public static final int REQUESTED_WITH_HEADER_MODE_NO_HEADER = 0;

    @Target({ElementType.PARAMETER, ElementType.METHOD})
    @Retention(RetentionPolicy.SOURCE)
    public @interface ForceDark {
    }

    @Target({ElementType.PARAMETER, ElementType.METHOD})
    @Retention(RetentionPolicy.SOURCE)
    public @interface ForceDarkStrategy {
    }

    @Target({ElementType.PARAMETER, ElementType.METHOD})
    @Retention(RetentionPolicy.SOURCE)
    public @interface MenuItemFlags {
    }

    @Target({ElementType.PARAMETER, ElementType.METHOD})
    @Retention(RetentionPolicy.SOURCE)
    public @interface RequestedWithHeaderMode {
    }

    private WebSettingsCompat() {
    }

    private static WebSettingsAdapter getAdapter(WebSettings r100) {
        return WebViewGlueCommunicator.getCompatConverter().convertSettings(r100);
    }

    public static int getDisabledActionModeMenuItems(WebSettings r100) {
        ApiFeature.N r101 = WebViewFeatureInternal.DISABLED_ACTION_MODE_MENU_ITEMS;
        if (r101.isSupportedByFramework() == false) goto L7;
        return ApiHelperForN.getDisabledActionModeMenuItems(r100);
    L7:
        if (r101.isSupportedByWebView() == false) goto L11;
        return getAdapter(r100).getDisabledActionModeMenuItems();
    L11:
        throw WebViewFeatureInternal.getUnsupportedOperationException();
    }

    public static boolean getEnterpriseAuthenticationAppLinkPolicyEnabled(WebSettings r100) {
        if (WebViewFeatureInternal.ENTERPRISE_AUTHENTICATION_APP_LINK_POLICY.isSupportedByWebView() == false) goto L7;
        return getAdapter(r100).getEnterpriseAuthenticationAppLinkPolicyEnabled();
    L7:
        throw WebViewFeatureInternal.getUnsupportedOperationException();
    }

    public static int getForceDark(WebSettings r100) {
        ApiFeature.NoFramework r101 = WebViewFeatureInternal.FORCE_DARK;
        if (r101.isSupportedByFramework() == false) goto L7;
        return ApiHelperForQ.getForceDark(r100);
    L7:
        if (r101.isSupportedByWebView() == false) goto L11;
        return getAdapter(r100).getForceDark();
    L11:
        throw WebViewFeatureInternal.getUnsupportedOperationException();
    }

    public static int getForceDarkStrategy(WebSettings r100) {
        if (WebViewFeatureInternal.FORCE_DARK_STRATEGY.isSupportedByWebView() == false) goto L7;
        return getAdapter(r100).getForceDark();
    L7:
        throw WebViewFeatureInternal.getUnsupportedOperationException();
    }

    public static boolean getOffscreenPreRaster(WebSettings r100) {
        ApiFeature.M r101 = WebViewFeatureInternal.OFF_SCREEN_PRERASTER;
        if (r101.isSupportedByFramework() == false) goto L7;
        return ApiHelperForM.getOffscreenPreRaster(r100);
    L7:
        if (r101.isSupportedByWebView() == false) goto L11;
        return getAdapter(r100).getOffscreenPreRaster();
    L11:
        throw WebViewFeatureInternal.getUnsupportedOperationException();
    }

    public static int getRequestedWithHeaderMode(WebSettings r100) {
        if (WebViewFeatureInternal.REQUESTED_WITH_HEADER_CONTROL.isSupportedByWebView() == false) goto L7;
        return getAdapter(r100).getRequestedWithHeaderMode();
    L7:
        throw WebViewFeatureInternal.getUnsupportedOperationException();
    }

    public static boolean getSafeBrowsingEnabled(WebSettings r100) {
        ApiFeature.O r101 = WebViewFeatureInternal.SAFE_BROWSING_ENABLE;
        if (r101.isSupportedByFramework() == false) goto L7;
        return ApiHelperForO.getSafeBrowsingEnabled(r100);
    L7:
        if (r101.isSupportedByWebView() == false) goto L11;
        return getAdapter(r100).getSafeBrowsingEnabled();
    L11:
        throw WebViewFeatureInternal.getUnsupportedOperationException();
    }

    public static boolean isAlgorithmicDarkeningAllowed(WebSettings r100) {
        if (WebViewFeatureInternal.ALGORITHMIC_DARKENING.isSupportedByWebView() == false) goto L7;
        return getAdapter(r100).isAlgorithmicDarkeningAllowed();
    L7:
        throw WebViewFeatureInternal.getUnsupportedOperationException();
    }

    public static boolean willSuppressErrorPage(WebSettings r100) {
        if (WebViewFeatureInternal.SUPPRESS_ERROR_PAGE.isSupportedByWebView() == false) goto L7;
        return getAdapter(r100).willSuppressErrorPage();
    L7:
        throw WebViewFeatureInternal.getUnsupportedOperationException();
    }

    public static void setAlgorithmicDarkeningAllowed(WebSettings r100, boolean r101) {
        if (WebViewFeatureInternal.ALGORITHMIC_DARKENING.isSupportedByWebView() == false) goto L7;
        getAdapter(r100).setAlgorithmicDarkeningAllowed(r101);
        return;
    L7:
        throw WebViewFeatureInternal.getUnsupportedOperationException();
    }

    public static void setDisabledActionModeMenuItems(WebSettings r100, int r101) {
        ApiFeature.N r102 = WebViewFeatureInternal.DISABLED_ACTION_MODE_MENU_ITEMS;
        if (r102.isSupportedByFramework() == false) goto L6;
        ApiHelperForN.setDisabledActionModeMenuItems(r100, r101);
        return;
    L6:
        if (r102.isSupportedByWebView() == false) goto L10;
        getAdapter(r100).setDisabledActionModeMenuItems(r101);
        return;
    L10:
        throw WebViewFeatureInternal.getUnsupportedOperationException();
    }

    public static void setEnterpriseAuthenticationAppLinkPolicyEnabled(WebSettings r100, boolean r101) {
        if (WebViewFeatureInternal.ENTERPRISE_AUTHENTICATION_APP_LINK_POLICY.isSupportedByWebView() == false) goto L7;
        getAdapter(r100).setEnterpriseAuthenticationAppLinkPolicyEnabled(r101);
        return;
    L7:
        throw WebViewFeatureInternal.getUnsupportedOperationException();
    }

    public static void setForceDark(WebSettings r100, int r101) {
        ApiFeature.NoFramework r102 = WebViewFeatureInternal.FORCE_DARK;
        if (r102.isSupportedByFramework() == false) goto L6;
        ApiHelperForQ.setForceDark(r100, r101);
        return;
    L6:
        if (r102.isSupportedByWebView() == false) goto L10;
        getAdapter(r100).setForceDark(r101);
        return;
    L10:
        throw WebViewFeatureInternal.getUnsupportedOperationException();
    }

    public static void setForceDarkStrategy(WebSettings r100, int r101) {
        if (WebViewFeatureInternal.FORCE_DARK_STRATEGY.isSupportedByWebView() == false) goto L7;
        getAdapter(r100).setForceDarkStrategy(r101);
        return;
    L7:
        throw WebViewFeatureInternal.getUnsupportedOperationException();
    }

    public static void setOffscreenPreRaster(WebSettings r100, boolean r101) {
        ApiFeature.M r102 = WebViewFeatureInternal.OFF_SCREEN_PRERASTER;
        if (r102.isSupportedByFramework() == false) goto L6;
        ApiHelperForM.setOffscreenPreRaster(r100, r101);
        return;
    L6:
        if (r102.isSupportedByWebView() == false) goto L10;
        getAdapter(r100).setOffscreenPreRaster(r101);
        return;
    L10:
        throw WebViewFeatureInternal.getUnsupportedOperationException();
    }

    public static void setRequestedWithHeaderMode(WebSettings r100, int r101) {
        if (WebViewFeatureInternal.REQUESTED_WITH_HEADER_CONTROL.isSupportedByWebView() == false) goto L7;
        getAdapter(r100).setRequestedWithHeaderMode(r101);
        return;
    L7:
        throw WebViewFeatureInternal.getUnsupportedOperationException();
    }

    public static void setSafeBrowsingEnabled(WebSettings r100, boolean r101) {
        ApiFeature.O r102 = WebViewFeatureInternal.SAFE_BROWSING_ENABLE;
        if (r102.isSupportedByFramework() == false) goto L6;
        ApiHelperForO.setSafeBrowsingEnabled(r100, r101);
        return;
    L6:
        if (r102.isSupportedByWebView() == false) goto L10;
        getAdapter(r100).setSafeBrowsingEnabled(r101);
        return;
    L10:
        throw WebViewFeatureInternal.getUnsupportedOperationException();
    }

    public static void setWillSuppressErrorPage(WebSettings r100, boolean r101) {
        if (WebViewFeatureInternal.SUPPRESS_ERROR_PAGE.isSupportedByWebView() == false) goto L7;
        getAdapter(r100).setWillSuppressErrorPage(r101);
        return;
    L7:
        throw WebViewFeatureInternal.getUnsupportedOperationException();
    }
}
