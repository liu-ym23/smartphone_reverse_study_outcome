package androidx.webkit.internal;

import androidx.webkit.WebViewFeature;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;

/* JADX INFO: loaded from: classes17.dex */
public class WebViewFeatureInternal {
    public static final ApiFeature.NoFramework ALGORITHMIC_DARKENING = null;
    public static final ApiFeature.M CREATE_WEB_MESSAGE_CHANNEL = null;
    public static final ApiFeature.N DISABLED_ACTION_MODE_MENU_ITEMS = null;
    public static final ApiFeature.NoFramework DOCUMENT_START_SCRIPT = null;
    public static final ApiFeature.NoFramework ENTERPRISE_AUTHENTICATION_APP_LINK_POLICY = null;
    public static final ApiFeature.NoFramework FORCE_DARK = null;
    public static final ApiFeature.NoFramework FORCE_DARK_STRATEGY = null;
    public static final ApiFeature.NoFramework GET_VARIATIONS_HEADER = null;
    public static final ApiFeature.O GET_WEB_CHROME_CLIENT = null;
    public static final ApiFeature.O GET_WEB_VIEW_CLIENT = null;
    public static final ApiFeature.Q GET_WEB_VIEW_RENDERER = null;
    public static final ApiFeature.NoFramework MULTI_PROCESS = null;
    public static final ApiFeature.M OFF_SCREEN_PRERASTER = null;
    public static final ApiFeature.M POST_WEB_MESSAGE = null;
    public static final ApiFeature.NoFramework PROXY_OVERRIDE = null;
    public static final ApiFeature.NoFramework PROXY_OVERRIDE_REVERSE_BYPASS = null;
    public static final ApiFeature.M RECEIVE_HTTP_ERROR = null;
    public static final ApiFeature.M RECEIVE_WEB_RESOURCE_ERROR = null;
    public static final ApiFeature.NoFramework REQUESTED_WITH_HEADER_CONTROL = null;
    public static final ApiFeature.O_MR1 SAFE_BROWSING_ALLOWLIST_DEPRECATED_TO_DEPRECATED = null;
    public static final ApiFeature.O_MR1 SAFE_BROWSING_ALLOWLIST_DEPRECATED_TO_PREFERRED = null;
    public static final ApiFeature.O_MR1 SAFE_BROWSING_ALLOWLIST_PREFERRED_TO_DEPRECATED = null;
    public static final ApiFeature.O_MR1 SAFE_BROWSING_ALLOWLIST_PREFERRED_TO_PREFERRED = null;
    public static final ApiFeature.O SAFE_BROWSING_ENABLE = null;
    public static final ApiFeature.O_MR1 SAFE_BROWSING_HIT = null;
    public static final ApiFeature.O_MR1 SAFE_BROWSING_PRIVACY_POLICY_URL = null;
    public static final ApiFeature.O_MR1 SAFE_BROWSING_RESPONSE_BACK_TO_SAFETY = null;
    public static final ApiFeature.O_MR1 SAFE_BROWSING_RESPONSE_PROCEED = null;
    public static final ApiFeature.O_MR1 SAFE_BROWSING_RESPONSE_SHOW_INTERSTITIAL = null;
    public static final ApiFeature.N SERVICE_WORKER_BASIC_USAGE = null;
    public static final ApiFeature.N SERVICE_WORKER_BLOCK_NETWORK_LOADS = null;
    public static final ApiFeature.N SERVICE_WORKER_CACHE_MODE = null;
    public static final ApiFeature.N SERVICE_WORKER_CONTENT_ACCESS = null;
    public static final ApiFeature.N SERVICE_WORKER_FILE_ACCESS = null;
    public static final ApiFeature.N SERVICE_WORKER_SHOULD_INTERCEPT_REQUEST = null;
    public static final ApiFeature.N SHOULD_OVERRIDE_WITH_REDIRECTS = null;
    public static final ApiFeature.O_MR1 START_SAFE_BROWSING = null;
    public static final ApiFeature.NoFramework SUPPRESS_ERROR_PAGE = null;
    public static final ApiFeature.P TRACING_CONTROLLER_BASIC_USAGE = null;
    public static final ApiFeature.M VISUAL_STATE_CALLBACK = null;
    public static final ApiFeature.M WEB_MESSAGE_CALLBACK_ON_MESSAGE = null;
    public static final ApiFeature.NoFramework WEB_MESSAGE_LISTENER = null;
    public static final ApiFeature.M WEB_MESSAGE_PORT_CLOSE = null;
    public static final ApiFeature.M WEB_MESSAGE_PORT_POST_MESSAGE = null;
    public static final ApiFeature.M WEB_MESSAGE_PORT_SET_MESSAGE_CALLBACK = null;
    public static final ApiFeature.M WEB_RESOURCE_ERROR_GET_CODE = null;
    public static final ApiFeature.M WEB_RESOURCE_ERROR_GET_DESCRIPTION = null;
    public static final ApiFeature.N WEB_RESOURCE_REQUEST_IS_REDIRECT = null;
    public static final ApiFeature.Q WEB_VIEW_RENDERER_CLIENT_BASIC_USAGE = null;
    public static final ApiFeature.Q WEB_VIEW_RENDERER_TERMINATE = null;

    static {
        VISUAL_STATE_CALLBACK = new ApiFeature.M(WebViewFeature.VISUAL_STATE_CALLBACK, WebViewFeature.VISUAL_STATE_CALLBACK);
        OFF_SCREEN_PRERASTER = new ApiFeature.M(WebViewFeature.OFF_SCREEN_PRERASTER, WebViewFeature.OFF_SCREEN_PRERASTER);
        SAFE_BROWSING_ENABLE = new ApiFeature.O(WebViewFeature.SAFE_BROWSING_ENABLE, WebViewFeature.SAFE_BROWSING_ENABLE);
        DISABLED_ACTION_MODE_MENU_ITEMS = new ApiFeature.N(WebViewFeature.DISABLED_ACTION_MODE_MENU_ITEMS, WebViewFeature.DISABLED_ACTION_MODE_MENU_ITEMS);
        START_SAFE_BROWSING = new ApiFeature.O_MR1(WebViewFeature.START_SAFE_BROWSING, WebViewFeature.START_SAFE_BROWSING);
        SAFE_BROWSING_ALLOWLIST_DEPRECATED_TO_DEPRECATED = new ApiFeature.O_MR1(WebViewFeature.SAFE_BROWSING_WHITELIST, WebViewFeature.SAFE_BROWSING_WHITELIST);
        SAFE_BROWSING_ALLOWLIST_DEPRECATED_TO_PREFERRED = new ApiFeature.O_MR1(WebViewFeature.SAFE_BROWSING_WHITELIST, WebViewFeature.SAFE_BROWSING_ALLOWLIST);
        SAFE_BROWSING_ALLOWLIST_PREFERRED_TO_DEPRECATED = new ApiFeature.O_MR1(WebViewFeature.SAFE_BROWSING_ALLOWLIST, WebViewFeature.SAFE_BROWSING_WHITELIST);
        SAFE_BROWSING_ALLOWLIST_PREFERRED_TO_PREFERRED = new ApiFeature.O_MR1(WebViewFeature.SAFE_BROWSING_ALLOWLIST, WebViewFeature.SAFE_BROWSING_ALLOWLIST);
        SAFE_BROWSING_PRIVACY_POLICY_URL = new ApiFeature.O_MR1(WebViewFeature.SAFE_BROWSING_PRIVACY_POLICY_URL, WebViewFeature.SAFE_BROWSING_PRIVACY_POLICY_URL);
        SERVICE_WORKER_BASIC_USAGE = new ApiFeature.N(WebViewFeature.SERVICE_WORKER_BASIC_USAGE, WebViewFeature.SERVICE_WORKER_BASIC_USAGE);
        SERVICE_WORKER_CACHE_MODE = new ApiFeature.N(WebViewFeature.SERVICE_WORKER_CACHE_MODE, WebViewFeature.SERVICE_WORKER_CACHE_MODE);
        SERVICE_WORKER_CONTENT_ACCESS = new ApiFeature.N(WebViewFeature.SERVICE_WORKER_CONTENT_ACCESS, WebViewFeature.SERVICE_WORKER_CONTENT_ACCESS);
        SERVICE_WORKER_FILE_ACCESS = new ApiFeature.N(WebViewFeature.SERVICE_WORKER_FILE_ACCESS, WebViewFeature.SERVICE_WORKER_FILE_ACCESS);
        SERVICE_WORKER_BLOCK_NETWORK_LOADS = new ApiFeature.N(WebViewFeature.SERVICE_WORKER_BLOCK_NETWORK_LOADS, WebViewFeature.SERVICE_WORKER_BLOCK_NETWORK_LOADS);
        SERVICE_WORKER_SHOULD_INTERCEPT_REQUEST = new ApiFeature.N(WebViewFeature.SERVICE_WORKER_SHOULD_INTERCEPT_REQUEST, WebViewFeature.SERVICE_WORKER_SHOULD_INTERCEPT_REQUEST);
        RECEIVE_WEB_RESOURCE_ERROR = new ApiFeature.M(WebViewFeature.RECEIVE_WEB_RESOURCE_ERROR, WebViewFeature.RECEIVE_WEB_RESOURCE_ERROR);
        RECEIVE_HTTP_ERROR = new ApiFeature.M(WebViewFeature.RECEIVE_HTTP_ERROR, WebViewFeature.RECEIVE_HTTP_ERROR);
        SHOULD_OVERRIDE_WITH_REDIRECTS = new ApiFeature.N(WebViewFeature.SHOULD_OVERRIDE_WITH_REDIRECTS, WebViewFeature.SHOULD_OVERRIDE_WITH_REDIRECTS);
        SAFE_BROWSING_HIT = new ApiFeature.O_MR1(WebViewFeature.SAFE_BROWSING_HIT, WebViewFeature.SAFE_BROWSING_HIT);
        WEB_RESOURCE_REQUEST_IS_REDIRECT = new ApiFeature.N(WebViewFeature.WEB_RESOURCE_REQUEST_IS_REDIRECT, WebViewFeature.WEB_RESOURCE_REQUEST_IS_REDIRECT);
        WEB_RESOURCE_ERROR_GET_DESCRIPTION = new ApiFeature.M(WebViewFeature.WEB_RESOURCE_ERROR_GET_DESCRIPTION, WebViewFeature.WEB_RESOURCE_ERROR_GET_DESCRIPTION);
        WEB_RESOURCE_ERROR_GET_CODE = new ApiFeature.M(WebViewFeature.WEB_RESOURCE_ERROR_GET_CODE, WebViewFeature.WEB_RESOURCE_ERROR_GET_CODE);
        SAFE_BROWSING_RESPONSE_BACK_TO_SAFETY = new ApiFeature.O_MR1(WebViewFeature.SAFE_BROWSING_RESPONSE_BACK_TO_SAFETY, WebViewFeature.SAFE_BROWSING_RESPONSE_BACK_TO_SAFETY);
        SAFE_BROWSING_RESPONSE_PROCEED = new ApiFeature.O_MR1(WebViewFeature.SAFE_BROWSING_RESPONSE_PROCEED, WebViewFeature.SAFE_BROWSING_RESPONSE_PROCEED);
        SAFE_BROWSING_RESPONSE_SHOW_INTERSTITIAL = new ApiFeature.O_MR1(WebViewFeature.SAFE_BROWSING_RESPONSE_SHOW_INTERSTITIAL, WebViewFeature.SAFE_BROWSING_RESPONSE_SHOW_INTERSTITIAL);
        WEB_MESSAGE_PORT_POST_MESSAGE = new ApiFeature.M(WebViewFeature.WEB_MESSAGE_PORT_POST_MESSAGE, WebViewFeature.WEB_MESSAGE_PORT_POST_MESSAGE);
        WEB_MESSAGE_PORT_CLOSE = new ApiFeature.M(WebViewFeature.WEB_MESSAGE_PORT_CLOSE, WebViewFeature.WEB_MESSAGE_PORT_CLOSE);
        WEB_MESSAGE_PORT_SET_MESSAGE_CALLBACK = new ApiFeature.M(WebViewFeature.WEB_MESSAGE_PORT_SET_MESSAGE_CALLBACK, WebViewFeature.WEB_MESSAGE_PORT_SET_MESSAGE_CALLBACK);
        CREATE_WEB_MESSAGE_CHANNEL = new ApiFeature.M(WebViewFeature.CREATE_WEB_MESSAGE_CHANNEL, WebViewFeature.CREATE_WEB_MESSAGE_CHANNEL);
        POST_WEB_MESSAGE = new ApiFeature.M(WebViewFeature.POST_WEB_MESSAGE, WebViewFeature.POST_WEB_MESSAGE);
        WEB_MESSAGE_CALLBACK_ON_MESSAGE = new ApiFeature.M(WebViewFeature.WEB_MESSAGE_CALLBACK_ON_MESSAGE, WebViewFeature.WEB_MESSAGE_CALLBACK_ON_MESSAGE);
        GET_WEB_VIEW_CLIENT = new ApiFeature.O(WebViewFeature.GET_WEB_VIEW_CLIENT, WebViewFeature.GET_WEB_VIEW_CLIENT);
        GET_WEB_CHROME_CLIENT = new ApiFeature.O(WebViewFeature.GET_WEB_CHROME_CLIENT, WebViewFeature.GET_WEB_CHROME_CLIENT);
        GET_WEB_VIEW_RENDERER = new ApiFeature.Q(WebViewFeature.GET_WEB_VIEW_RENDERER, WebViewFeature.GET_WEB_VIEW_RENDERER);
        WEB_VIEW_RENDERER_TERMINATE = new ApiFeature.Q(WebViewFeature.WEB_VIEW_RENDERER_TERMINATE, WebViewFeature.WEB_VIEW_RENDERER_TERMINATE);
        TRACING_CONTROLLER_BASIC_USAGE = new ApiFeature.P(WebViewFeature.TRACING_CONTROLLER_BASIC_USAGE, WebViewFeature.TRACING_CONTROLLER_BASIC_USAGE);
        WEB_VIEW_RENDERER_CLIENT_BASIC_USAGE = new ApiFeature.Q(WebViewFeature.WEB_VIEW_RENDERER_CLIENT_BASIC_USAGE, WebViewFeature.WEB_VIEW_RENDERER_CLIENT_BASIC_USAGE);
        PROXY_OVERRIDE = new ApiFeature.NoFramework(WebViewFeature.PROXY_OVERRIDE, "PROXY_OVERRIDE:3");
        SUPPRESS_ERROR_PAGE = new ApiFeature.NoFramework(WebViewFeature.SUPPRESS_ERROR_PAGE, WebViewFeature.SUPPRESS_ERROR_PAGE);
        MULTI_PROCESS = new ApiFeature.NoFramework(WebViewFeature.MULTI_PROCESS, "MULTI_PROCESS_QUERY");
        FORCE_DARK = new ApiFeature.NoFramework(WebViewFeature.FORCE_DARK, WebViewFeature.FORCE_DARK);
        FORCE_DARK_STRATEGY = new ApiFeature.NoFramework(WebViewFeature.FORCE_DARK_STRATEGY, "FORCE_DARK_BEHAVIOR");
        ALGORITHMIC_DARKENING = new ApiFeature.NoFramework(WebViewFeature.ALGORITHMIC_DARKENING, WebViewFeature.ALGORITHMIC_DARKENING);
        WEB_MESSAGE_LISTENER = new ApiFeature.NoFramework(WebViewFeature.WEB_MESSAGE_LISTENER, WebViewFeature.WEB_MESSAGE_LISTENER);
        DOCUMENT_START_SCRIPT = new ApiFeature.NoFramework(WebViewFeature.DOCUMENT_START_SCRIPT, "DOCUMENT_START_SCRIPT:1");
        PROXY_OVERRIDE_REVERSE_BYPASS = new ApiFeature.NoFramework(WebViewFeature.PROXY_OVERRIDE_REVERSE_BYPASS, WebViewFeature.PROXY_OVERRIDE_REVERSE_BYPASS);
        GET_VARIATIONS_HEADER = new ApiFeature.NoFramework(WebViewFeature.GET_VARIATIONS_HEADER, WebViewFeature.GET_VARIATIONS_HEADER);
        REQUESTED_WITH_HEADER_CONTROL = new ApiFeature.NoFramework(WebViewFeature.REQUESTED_WITH_HEADER_CONTROL, WebViewFeature.REQUESTED_WITH_HEADER_CONTROL);
        ENTERPRISE_AUTHENTICATION_APP_LINK_POLICY = new ApiFeature.NoFramework(WebViewFeature.ENTERPRISE_AUTHENTICATION_APP_LINK_POLICY, WebViewFeature.ENTERPRISE_AUTHENTICATION_APP_LINK_POLICY);
    }

    public static UnsupportedOperationException getUnsupportedOperationException() {
        return new UnsupportedOperationException("This method is not supported by the current version of the framework and the current WebView APK");
    }

    private WebViewFeatureInternal() {
    }

    public static boolean isSupported(String r100) {
        return isSupported(r100, ApiFeature.values());
    }

    public static <T extends ConditionallySupportedFeature> boolean isSupported(String r100, Collection<T> r101) {
        HashSet r102 = new HashSet();
        Iterator<T> r103 = r101.iterator();
    L4:
        if (r103.hasNext() == false) goto L9;
        T r104 = r103.next();
        if (r104.getPublicFeatureName().equals(r100) == false) goto L4;
        r102.add(r104);
        goto L4
    L9:
        if (r102.isEmpty() == true) goto L20;
        Iterator r105 = r102.iterator();
    L12:
        if (r105.hasNext() == false) goto L17;
        if (((ConditionallySupportedFeature) r105.next()).isSupported() == false) goto L12;
        return true;
    L17:
        return false;
    L20:
        throw new RuntimeException("Unknown feature " + r100);
    }
}
