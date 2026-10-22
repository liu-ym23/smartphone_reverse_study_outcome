package androidx.webkit.internal;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;

/* JADX INFO: compiled from: WebViewFeatureInternal.java */
/* JADX INFO: loaded from: classes.dex */
public class p {
    public static final a.b A = null;
    public static final a.b B = null;
    public static final a.d C = null;
    public static final a.b D = null;
    public static final a.b E = null;
    public static final a.b F = null;
    public static final a.b G = null;
    public static final a.e H = null;
    public static final a.e I = null;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public static final a.h f3000J = null;
    public static final a.h K = null;
    public static final a.g L = null;
    public static final l.b M = null;
    public static final l.a N = null;
    public static final a.h O = null;
    public static final a.i P = null;
    public static final a.d Q = null;
    public static final a.d R = null;
    public static final a.h S = null;
    public static final a.d T = null;
    public static final a.d U = null;
    public static final a.d V = null;
    public static final a.d W = null;
    public static final a.d X = null;
    public static final a.d Y = null;
    public static final a.d Z = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a.b f3001a = null;
    public static final a.d aa = null;
    public static final a.d ab = null;
    public static final a.d ac = null;
    public static final a.d ad = null;
    public static final a.d ae = null;
    public static final a.d af = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a.b f3002b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final a.e f3003c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final a.c f3004d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final a.f f3005e = null;

    @Deprecated
    public static final a.f f = null;

    @Deprecated
    public static final a.f g = null;
    public static final a.f h = null;
    public static final a.f i = null;
    public static final a.f j = null;
    public static final a.c k = null;
    public static final a.c l = null;
    public static final a.c m = null;
    public static final a.c n = null;
    public static final a.c o = null;
    public static final a.c p = null;
    public static final a.b q = null;
    public static final a.b r = null;
    public static final a.c s = null;
    public static final a.f t = null;
    public static final a.c u = null;
    public static final a.b v = null;
    public static final a.b w = null;
    public static final a.f x = null;
    public static final a.f y = null;
    public static final a.f z = null;

    static {
        f3001a = new a.b("VISUAL_STATE_CALLBACK", "VISUAL_STATE_CALLBACK");
        f3002b = new a.b("OFF_SCREEN_PRERASTER", "OFF_SCREEN_PRERASTER");
        f3003c = new a.e("SAFE_BROWSING_ENABLE", "SAFE_BROWSING_ENABLE");
        f3004d = new a.c("DISABLED_ACTION_MODE_MENU_ITEMS", "DISABLED_ACTION_MODE_MENU_ITEMS");
        f3005e = new a.f("START_SAFE_BROWSING", "START_SAFE_BROWSING");
        f = new a.f("SAFE_BROWSING_WHITELIST", "SAFE_BROWSING_WHITELIST");
        g = new a.f("SAFE_BROWSING_WHITELIST", "SAFE_BROWSING_ALLOWLIST");
        h = new a.f("SAFE_BROWSING_ALLOWLIST", "SAFE_BROWSING_WHITELIST");
        i = new a.f("SAFE_BROWSING_ALLOWLIST", "SAFE_BROWSING_ALLOWLIST");
        j = new a.f("SAFE_BROWSING_PRIVACY_POLICY_URL", "SAFE_BROWSING_PRIVACY_POLICY_URL");
        k = new a.c("SERVICE_WORKER_BASIC_USAGE", "SERVICE_WORKER_BASIC_USAGE");
        l = new a.c("SERVICE_WORKER_CACHE_MODE", "SERVICE_WORKER_CACHE_MODE");
        m = new a.c("SERVICE_WORKER_CONTENT_ACCESS", "SERVICE_WORKER_CONTENT_ACCESS");
        n = new a.c("SERVICE_WORKER_FILE_ACCESS", "SERVICE_WORKER_FILE_ACCESS");
        o = new a.c("SERVICE_WORKER_BLOCK_NETWORK_LOADS", "SERVICE_WORKER_BLOCK_NETWORK_LOADS");
        p = new a.c("SERVICE_WORKER_SHOULD_INTERCEPT_REQUEST", "SERVICE_WORKER_SHOULD_INTERCEPT_REQUEST");
        q = new a.b("RECEIVE_WEB_RESOURCE_ERROR", "RECEIVE_WEB_RESOURCE_ERROR");
        r = new a.b("RECEIVE_HTTP_ERROR", "RECEIVE_HTTP_ERROR");
        s = new a.c("SHOULD_OVERRIDE_WITH_REDIRECTS", "SHOULD_OVERRIDE_WITH_REDIRECTS");
        t = new a.f("SAFE_BROWSING_HIT", "SAFE_BROWSING_HIT");
        u = new a.c("WEB_RESOURCE_REQUEST_IS_REDIRECT", "WEB_RESOURCE_REQUEST_IS_REDIRECT");
        v = new a.b("WEB_RESOURCE_ERROR_GET_DESCRIPTION", "WEB_RESOURCE_ERROR_GET_DESCRIPTION");
        w = new a.b("WEB_RESOURCE_ERROR_GET_CODE", "WEB_RESOURCE_ERROR_GET_CODE");
        x = new a.f("SAFE_BROWSING_RESPONSE_BACK_TO_SAFETY", "SAFE_BROWSING_RESPONSE_BACK_TO_SAFETY");
        y = new a.f("SAFE_BROWSING_RESPONSE_PROCEED", "SAFE_BROWSING_RESPONSE_PROCEED");
        z = new a.f("SAFE_BROWSING_RESPONSE_SHOW_INTERSTITIAL", "SAFE_BROWSING_RESPONSE_SHOW_INTERSTITIAL");
        A = new a.b("WEB_MESSAGE_PORT_POST_MESSAGE", "WEB_MESSAGE_PORT_POST_MESSAGE");
        B = new a.b("WEB_MESSAGE_PORT_CLOSE", "WEB_MESSAGE_PORT_CLOSE");
        C = new a.d("WEB_MESSAGE_ARRAY_BUFFER", "WEB_MESSAGE_ARRAY_BUFFER");
        D = new a.b("WEB_MESSAGE_PORT_SET_MESSAGE_CALLBACK", "WEB_MESSAGE_PORT_SET_MESSAGE_CALLBACK");
        E = new a.b("CREATE_WEB_MESSAGE_CHANNEL", "CREATE_WEB_MESSAGE_CHANNEL");
        F = new a.b("POST_WEB_MESSAGE", "POST_WEB_MESSAGE");
        G = new a.b("WEB_MESSAGE_CALLBACK_ON_MESSAGE", "WEB_MESSAGE_CALLBACK_ON_MESSAGE");
        H = new a.e("GET_WEB_VIEW_CLIENT", "GET_WEB_VIEW_CLIENT");
        I = new a.e("GET_WEB_CHROME_CLIENT", "GET_WEB_CHROME_CLIENT");
        f3000J = new a.h("GET_WEB_VIEW_RENDERER", "GET_WEB_VIEW_RENDERER");
        K = new a.h("WEB_VIEW_RENDERER_TERMINATE", "WEB_VIEW_RENDERER_TERMINATE");
        L = new a.g("TRACING_CONTROLLER_BASIC_USAGE", "TRACING_CONTROLLER_BASIC_USAGE");
        M = new l.b("STARTUP_FEATURE_SET_DATA_DIRECTORY_SUFFIX", "STARTUP_FEATURE_SET_DATA_DIRECTORY_SUFFIX");
        N = new l.a("STARTUP_FEATURE_SET_DIRECTORY_BASE_PATHS", "STARTUP_FEATURE_SET_DIRECTORY_BASE_PATH");
        O = new a.h("WEB_VIEW_RENDERER_CLIENT_BASIC_USAGE", "WEB_VIEW_RENDERER_CLIENT_BASIC_USAGE");
        final String r1 = "ALGORITHMIC_DARKENING";
        final String r2 = "ALGORITHMIC_DARKENING";
        P = new AnonymousClass1(r1, r2);
        Q = new a.d("PROXY_OVERRIDE", "PROXY_OVERRIDE:3");
        R = new a.d("MULTI_PROCESS", "MULTI_PROCESS_QUERY");
        S = new a.h("FORCE_DARK", "FORCE_DARK");
        T = new a.d("FORCE_DARK_STRATEGY", "FORCE_DARK_BEHAVIOR");
        U = new a.d("WEB_MESSAGE_LISTENER", "WEB_MESSAGE_LISTENER");
        V = new a.d("DOCUMENT_START_SCRIPT", "DOCUMENT_START_SCRIPT:1");
        W = new a.d("PROXY_OVERRIDE_REVERSE_BYPASS", "PROXY_OVERRIDE_REVERSE_BYPASS");
        X = new a.d("GET_VARIATIONS_HEADER", "GET_VARIATIONS_HEADER");
        Y = new a.d("ENTERPRISE_AUTHENTICATION_APP_LINK_POLICY", "ENTERPRISE_AUTHENTICATION_APP_LINK_POLICY");
        Z = new a.d("GET_COOKIE_INFO", "GET_COOKIE_INFO");
        aa = new a.d("REQUESTED_WITH_HEADER_ALLOW_LIST", "REQUESTED_WITH_HEADER_ALLOW_LIST");
        ab = new a.d("USER_AGENT_METADATA", "USER_AGENT_METADATA");
        final String r3 = "MULTI_PROFILE";
        final String r4 = "MULTI_PROFILE";
        ac = new AnonymousClass2(r3, r4);
        ad = new a.d("ATTRIBUTION_REGISTRATION_BEHAVIOR", "ATTRIBUTION_BEHAVIOR");
        ae = new a.d("WEBVIEW_MEDIA_INTEGRITY_API_STATUS", "WEBVIEW_INTEGRITY_API_STATUS");
        af = new a.d("MUTE_AUDIO", "MUTE_AUDIO");
    }

    public static boolean a(String r1) {
        return a(r1, a.e());
    }

    public static <T extends g> boolean a(String r4, Collection<T> r5) {
        Collection r6 = (Collection) ZeusTransformUtils.wrapperContextForParams(r5, Collection.class, "com.obric.aiagent.plugin");
        HashSet r0 = new HashSet();
        Iterator r7 = r6.iterator();
    L4:
        if (r7.hasNext() == false) goto L9;
        g r2 = (g) ZeusTransformUtils.preCheckCast(r7.next(), g.class, "com.obric.aiagent.plugin");
        if (r2.a().equals(r4) == false) goto L4;
        r0.add(r2);
        goto L4
    L9:
        if (r0.isEmpty() == true) goto L20;
        Iterator r8 = r0.iterator();
    L12:
        if (r8.hasNext() == false) goto L17;
        if (((g) ZeusTransformUtils.preCheckCast(r8.next(), g.class, "com.obric.aiagent.plugin")).b() == false) goto L12;
        return true;
    L17:
        return false;
    L20:
        throw new RuntimeException("Unknown feature " + r4);
    }

    public static UnsupportedOperationException a() {
        return new UnsupportedOperationException("This method is not supported by the current version of the framework and the current WebView APK");
    }
}
