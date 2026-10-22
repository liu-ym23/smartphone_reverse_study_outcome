package androidx.webkit;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Looper;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.webkit.internal.ApiFeature;
import androidx.webkit.internal.ApiHelperForM;
import androidx.webkit.internal.ApiHelperForO;
import androidx.webkit.internal.ApiHelperForOMR1;
import androidx.webkit.internal.ApiHelperForP;
import androidx.webkit.internal.ApiHelperForQ;
import androidx.webkit.internal.WebMessagePortImpl;
import androidx.webkit.internal.WebViewFeatureInternal;
import androidx.webkit.internal.WebViewGlueCommunicator;
import androidx.webkit.internal.WebViewProviderAdapter;
import androidx.webkit.internal.WebViewProviderFactory;
import androidx.webkit.internal.WebViewRenderProcessClientFrameworkAdapter;
import androidx.webkit.internal.WebViewRenderProcessImpl;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.bytedance.mt.protector.impl.UriProtector;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import el9.a;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import me.ele.lancet.base.annotations.Skip;
import org.chromium.support_lib_boundary.WebViewProviderBoundaryInterface;

/* JADX INFO: loaded from: classes17.dex */
public class WebViewCompat {
    private static final Uri EMPTY_URI = null;
    private static final Uri WILDCARD_URI = null;

    public interface VisualStateCallback {
        void onComplete(long r100);
    }

    public interface WebMessageListener {
        void onPostMessage(WebView r100, WebMessageCompat r101, Uri r102, boolean r103, JavaScriptReplyProxy r104);
    }

    private WebViewCompat() {
    }

    public static /* synthetic */ Class access$000(String r100) throws ClassNotFoundException {
        return Class.forName(r100);
    }

    static {
        WILDCARD_URI = UriProtector.parse("*");
        EMPTY_URI = UriProtector.parse("");
    }

    private static PackageInfo getLoadedWebViewPackageInfo() throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        return (PackageInfo) INVOKESTATIC_androidx_webkit_WebViewCompat_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("android.webkit.WebViewFactory").getMethod("getLoadedPackageInfo", new Class[0]).invoke(null, new Object[0]);
    }

    public static Uri getSafeBrowsingPrivacyPolicyUrl() {
        ApiFeature.O_MR1 r100 = WebViewFeatureInternal.SAFE_BROWSING_PRIVACY_POLICY_URL;
        if (r100.isSupportedByFramework() == false) goto L7;
        return ApiHelperForOMR1.getSafeBrowsingPrivacyPolicyUrl();
    L7:
        if (r100.isSupportedByWebView() == false) goto L11;
        return getFactory().getStatics().getSafeBrowsingPrivacyPolicyUrl();
    L11:
        throw WebViewFeatureInternal.getUnsupportedOperationException();
    }

    public static String getVariationsHeader() {
        if (WebViewFeatureInternal.GET_VARIATIONS_HEADER.isSupportedByWebView() == false) goto L7;
        return getFactory().getStatics().getVariationsHeader();
    L7:
        throw WebViewFeatureInternal.getUnsupportedOperationException();
    }

    public static boolean isMultiProcessEnabled() {
        if (WebViewFeatureInternal.MULTI_PROCESS.isSupportedByWebView() == false) goto L7;
        return getFactory().getStatics().isMultiProcessEnabled();
    L7:
        throw WebViewFeatureInternal.getUnsupportedOperationException();
    }

    private static WebViewProviderFactory getFactory() {
        return WebViewGlueCommunicator.getFactory();
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKESTATIC_androidx_webkit_WebViewCompat_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r100) throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r101 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r102 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (a.a() == true) goto L34;
        Class r103 = access$000(r100);     // Catch: Throwable -> L8
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a(r100);     // Catch: Throwable -> L8
    L7:
        return r103;
    L8:
        th = move-exception;
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b(r100);
    L12:
        throw th;
    L34:
        Class r104 = access$000(r100);     // Catch: Throwable -> L17
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a(r100);     // Catch: Throwable -> L17
    L16:
        return r104;
    L17:
        th = move-exception;
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b(r100);
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName(r100);
    }

    private static void checkThread(WebView r100) {
        if (Build.VERSION.SDK_INT < 28) goto L20;
        Looper r101 = ApiHelperForP.getWebViewLooper(r100);
        if (r101 != Looper.myLooper()) goto L8;
        return;
    L8:
        throw new RuntimeException("A WebView method was called on thread '" + ThreadMethodProxy.currentThread().getName() + "'. All WebView methods must be called on the same thread. (Expected Looper " + r101 + " called on " + Looper.myLooper() + ", FYI main Looper is " + Looper.getMainLooper() + ")");
    L20:
        Method r102 = WebView.class.getDeclaredMethod("checkThread", new Class[0]);     // Catch: InvocationTargetException -> L11 IllegalAccessException -> L14 NoSuchMethodException -> L17
        r102.setAccessible(true);     // Catch: InvocationTargetException -> L11 IllegalAccessException -> L14 NoSuchMethodException -> L17
        r102.invoke(r100, new Object[0]);     // Catch: InvocationTargetException -> L11 IllegalAccessException -> L14 NoSuchMethodException -> L17
        return;
    L14:
        e = move-exception;
        throw new RuntimeException(e);
    L17:
        e = move-exception;
        throw new RuntimeException(e);
    L11:
        e = move-exception;
        throw new RuntimeException(e);
    }

    private static WebViewProviderBoundaryInterface createProvider(WebView r100) {
        return getFactory().createWebView(r100);
    }

    public static WebMessagePortCompat[] createWebMessageChannel(WebView r100) {
        ApiFeature.M r101 = WebViewFeatureInternal.CREATE_WEB_MESSAGE_CHANNEL;
        if (r101.isSupportedByFramework() == false) goto L7;
        return WebMessagePortImpl.portsToCompat(ApiHelperForM.createWebMessageChannel(r100));
    L7:
        if (r101.isSupportedByWebView() == false) goto L11;
        return getProvider(r100).createWebMessageChannel();
    L11:
        throw WebViewFeatureInternal.getUnsupportedOperationException();
    }

    public static PackageInfo getCurrentWebViewPackage(Context r100) {
        if (Build.VERSION.SDK_INT >= 26) goto L5;
        PackageInfo r101 = getLoadedWebViewPackageInfo();     // Catch: Throwable -> L11
        if (r101 == null) goto L10;
        return r101;
    L10:
        return getNotYetLoadedWebViewPackageInfo(r100);
    L11:
        return null;
    L5:
        return ApiHelperForO.getCurrentWebViewPackage();
    }

    private static PackageInfo getNotYetLoadedWebViewPackageInfo(Context r100) {
    L11:
        return null;
    L4:
        if (Build.VERSION.SDK_INT > 23) goto L6;
        String r101 = (String) INVOKESTATIC_androidx_webkit_WebViewCompat_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("android.webkit.WebViewFactory").getMethod("getWebViewPackageName", new Class[0]).invoke(null, new Object[0]);     // Catch: Throwable -> L11
    L7:
        if (r101 != null) goto L10;
        return null;
    L10:
        return r100.getPackageManager().getPackageInfo(r101, 0);
    L6:
        r101 = (String) INVOKESTATIC_androidx_webkit_WebViewCompat_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("android.webkit.WebViewUpdateService").getMethod("getCurrentWebViewPackageName", new Class[0]).invoke(null, new Object[0]);     // Catch: Throwable -> L11
        goto L7
    }

    private static WebViewProviderAdapter getProvider(WebView r100) {
        return new WebViewProviderAdapter(createProvider(r100));
    }

    public static WebChromeClient getWebChromeClient(WebView r100) {
        ApiFeature.O r101 = WebViewFeatureInternal.GET_WEB_CHROME_CLIENT;
        if (r101.isSupportedByFramework() == false) goto L7;
        return ApiHelperForO.getWebChromeClient(r100);
    L7:
        if (r101.isSupportedByWebView() == false) goto L11;
        return getProvider(r100).getWebChromeClient();
    L11:
        throw WebViewFeatureInternal.getUnsupportedOperationException();
    }

    public static WebViewClient getWebViewClient(WebView r100) {
        ApiFeature.O r101 = WebViewFeatureInternal.GET_WEB_VIEW_CLIENT;
        if (r101.isSupportedByFramework() == false) goto L7;
        return ApiHelperForO.getWebViewClient(r100);
    L7:
        if (r101.isSupportedByWebView() == false) goto L11;
        return getProvider(r100).getWebViewClient();
    L11:
        throw WebViewFeatureInternal.getUnsupportedOperationException();
    }

    public static WebViewRenderProcess getWebViewRenderProcess(WebView r100) {
        ApiFeature.Q r101 = WebViewFeatureInternal.GET_WEB_VIEW_RENDERER;
        if (r101.isSupportedByFramework() == false) goto L10;
        android.webkit.WebViewRenderProcess r102 = ApiHelperForQ.getWebViewRenderProcess(r100);
        if (r102 != null) goto L15;
        return null;
    L15:
        return WebViewRenderProcessImpl.forFrameworkObject(r102);
    L10:
        if (r101.isSupportedByWebView() == false) goto L14;
        return getProvider(r100).getWebViewRenderProcess();
    L14:
        throw WebViewFeatureInternal.getUnsupportedOperationException();
    }

    public static WebViewRenderProcessClient getWebViewRenderProcessClient(WebView r100) {
        ApiFeature.Q r101 = WebViewFeatureInternal.WEB_VIEW_RENDERER_CLIENT_BASIC_USAGE;
        if (r101.isSupportedByFramework() == false) goto L14;
        android.webkit.WebViewRenderProcessClient r102 = ApiHelperForQ.getWebViewRenderProcessClient(r100);
        if (r102 != null) goto L7;
        return null;
    L7:
        if ((r102 instanceof WebViewRenderProcessClientFrameworkAdapter) == true) goto L10;
        return null;
    L10:
        return ((WebViewRenderProcessClientFrameworkAdapter) r102).getFrameworkRenderProcessClient();
    L14:
        if (r101.isSupportedByWebView() == false) goto L18;
        return getProvider(r100).getWebViewRenderProcessClient();
    L18:
        throw WebViewFeatureInternal.getUnsupportedOperationException();
    }

    public static void removeWebMessageListener(WebView r100, String r101) {
        if (WebViewFeatureInternal.WEB_MESSAGE_LISTENER.isSupportedByWebView() == false) goto L7;
        getProvider(r100).removeWebMessageListener(r101);
        return;
    L7:
        throw WebViewFeatureInternal.getUnsupportedOperationException();
    }

    public static void setSafeBrowsingAllowlist(Set<String> r100, ValueCallback<Boolean> r101) {
        ApiFeature.O_MR1 r102 = WebViewFeatureInternal.SAFE_BROWSING_ALLOWLIST_PREFERRED_TO_PREFERRED;
        ApiFeature.O_MR1 r103 = WebViewFeatureInternal.SAFE_BROWSING_ALLOWLIST_PREFERRED_TO_DEPRECATED;
        if (r102.isSupportedByWebView() == false) goto L6;
        getFactory().getStatics().setSafeBrowsingAllowlist(r100, r101);
        return;
    L6:
        ArrayList r104 = new ArrayList(r100);
        if (r103.isSupportedByFramework() == false) goto L10;
        ApiHelperForOMR1.setSafeBrowsingWhitelist(r104, r101);
        return;
    L10:
        if (r103.isSupportedByWebView() == false) goto L14;
        getFactory().getStatics().setSafeBrowsingWhitelist(r104, r101);
        return;
    L14:
        throw WebViewFeatureInternal.getUnsupportedOperationException();
    }

    public static void setSafeBrowsingWhitelist(List<String> r100, ValueCallback<Boolean> r101) {
        setSafeBrowsingAllowlist(new HashSet(r100), r101);
    }

    public static void setWebViewRenderProcessClient(WebView r100, WebViewRenderProcessClient r101) {
        ApiFeature.Q r102 = WebViewFeatureInternal.WEB_VIEW_RENDERER_CLIENT_BASIC_USAGE;
        if (r102.isSupportedByFramework() == false) goto L6;
        ApiHelperForQ.setWebViewRenderProcessClient(r100, r101);
        return;
    L6:
        if (r102.isSupportedByWebView() == false) goto L10;
        getProvider(r100).setWebViewRenderProcessClient(null, r101);
        return;
    L10:
        throw WebViewFeatureInternal.getUnsupportedOperationException();
    }

    public static void startSafeBrowsing(Context r100, ValueCallback<Boolean> r101) {
        ApiFeature.O_MR1 r102 = WebViewFeatureInternal.START_SAFE_BROWSING;
        if (r102.isSupportedByFramework() == false) goto L6;
        ApiHelperForOMR1.startSafeBrowsing(r100, r101);
        return;
    L6:
        if (r102.isSupportedByWebView() == false) goto L10;
        getFactory().getStatics().initSafeBrowsing(r100, r101);
        return;
    L10:
        throw WebViewFeatureInternal.getUnsupportedOperationException();
    }

    public static ScriptHandler addDocumentStartJavaScript(WebView r100, String r101, Set<String> r102) {
        if (WebViewFeatureInternal.DOCUMENT_START_SCRIPT.isSupportedByWebView() == false) goto L7;
        return getProvider(r100).addDocumentStartJavaScript(r101, (String[]) r102.toArray(new String[0]));
    L7:
        throw WebViewFeatureInternal.getUnsupportedOperationException();
    }

    public static void postVisualStateCallback(WebView r100, long r101, VisualStateCallback r102) {
        ApiFeature.M r103 = WebViewFeatureInternal.VISUAL_STATE_CALLBACK;
        if (r103.isSupportedByFramework() == false) goto L6;
        ApiHelperForM.postVisualStateCallback(r100, r101, r102);
        return;
    L6:
        if (r103.isSupportedByWebView() == false) goto L10;
        checkThread(r100);
        getProvider(r100).insertVisualStateCallback(r101, r102);
        return;
    L10:
        throw WebViewFeatureInternal.getUnsupportedOperationException();
    }

    public static void postWebMessage(WebView r100, WebMessageCompat r101, Uri r102) {
        if (WILDCARD_URI.equals(r102) == false) goto L5;
        r102 = EMPTY_URI;
    L5:
        ApiFeature.M r103 = WebViewFeatureInternal.POST_WEB_MESSAGE;
        if (r103.isSupportedByFramework() == false) goto L9;
        ApiHelperForM.postWebMessage(r100, WebMessagePortImpl.compatToFrameworkMessage(r101), r102);
        return;
    L9:
        if (r103.isSupportedByWebView() == false) goto L13;
        getProvider(r100).postWebMessage(r101, r102);
        return;
    L13:
        throw WebViewFeatureInternal.getUnsupportedOperationException();
    }

    public static void setWebViewRenderProcessClient(WebView r100, Executor r101, WebViewRenderProcessClient r102) {
        ApiFeature.Q r103 = WebViewFeatureInternal.WEB_VIEW_RENDERER_CLIENT_BASIC_USAGE;
        if (r103.isSupportedByFramework() == false) goto L6;
        ApiHelperForQ.setWebViewRenderProcessClient(r100, r101, r102);
        return;
    L6:
        if (r103.isSupportedByWebView() == false) goto L10;
        getProvider(r100).setWebViewRenderProcessClient(r101, r102);
        return;
    L10:
        throw WebViewFeatureInternal.getUnsupportedOperationException();
    }

    public static void addWebMessageListener(WebView r100, String r101, Set<String> r102, WebMessageListener r103) {
        if (WebViewFeatureInternal.WEB_MESSAGE_LISTENER.isSupportedByWebView() == false) goto L7;
        getProvider(r100).addWebMessageListener(r101, (String[]) r102.toArray(new String[0]), r103);
        return;
    L7:
        throw WebViewFeatureInternal.getUnsupportedOperationException();
    }
}
