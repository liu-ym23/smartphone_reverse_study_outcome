package com.bytedance.android.live.browser;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import androidx.exifinterface.media.ExifInterface;
import com.bytedance.android.annie.api.card.HybridCard;
import com.bytedance.android.annie.api.container.HybridDialog;
import com.bytedance.android.annie.api.container.HybridFragment;
import com.bytedance.android.live.base.IService;
import com.bytedance.android.live.utility.ServiceLookup;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.hybridapi.BaseJsBridgeMethodFactory;
import com.bytedance.android.livesdkapi.hybridapi.IJsBridgeManager;
import com.bytedance.android.livesdkapi.hybridapi.SubscriberJsEvent;
import com.bytedance.ies.bullet.service.base.utils.KitType;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import io.reactivex.Observable;
import java.util.ArrayList;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Unit;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes45.dex */
@ServiceLookup("com.bytedance.android.live.browser.BrowserServiceImpl")
@Metadata(d1 = {"\u0000ú\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\bg\u0018\u0000 h2\u00020\u0001:\u0003ijkJ\b\u0010\u0003\u001a\u00020\u0002H&J\u0018\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H'J\u0018\u0010\u000b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u0006H&J\u0010\u0010\f\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H&J8\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u000e\u001a\u00020\r2\b\b\u0002\u0010\u0010\u001a\u00020\u000f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00112\b\u0010\u0013\u001a\u0004\u0018\u00010\u0006H&J*\u0010\u001a\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\u0018H'J\u0014\u0010\u001d\u001a\u00020\u00022\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001bH&J\b\u0010\u001e\u001a\u00020\u0002H&J\u0010\u0010\u001f\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&J%\u0010#\u001a\u00020\u0002\"\u0004\b\u0000\u0010 2\u0006\u0010!\u001a\u00020\u00062\u0006\u0010\"\u001a\u00028\u0000H&¢\u0006\u0004\b#\u0010$J\b\u0010&\u001a\u00020%H&J\u0018\u0010*\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030)2\u0006\u0010(\u001a\u00020'H&J\u0016\u0010.\u001a\b\u0012\u0004\u0012\u00020\u00020-2\u0006\u0010,\u001a\u00020+H'J\u0016\u00101\u001a\b\u0012\u0004\u0012\u0002000-2\u0006\u0010/\u001a\u00020\u0006H&J\u0010\u00102\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H'J\u0010\u00103\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H&J\u0018\u00106\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u00105\u001a\u000204H&J\u0018\u0010:\u001a\u0002092\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u00108\u001a\u000207H&J0\u0010@\u001a\u00020\u00022&\u0010?\u001a\"\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020=0<0;j\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020=0<`>H&J\b\u0010A\u001a\u00020\u0002H&J&\u0010G\u001a\u0004\u0018\u00010F2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010C\u001a\u00020B2\n\b\u0002\u0010E\u001a\u0004\u0018\u00010DH&J0\u0010J\u001a\u0004\u0018\u00010F2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010C\u001a\u00020B2\n\b\u0002\u0010E\u001a\u0004\u0018\u00010D2\b\u0010I\u001a\u0004\u0018\u00010HH&J>\u0010G\u001a\u0004\u0018\u00010F2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010C\u001a\u00020B2\n\b\u0002\u0010E\u001a\u0004\u0018\u00010D2\n\b\u0002\u0010L\u001a\u0004\u0018\u00010K2\n\b\u0002\u0010I\u001a\u0004\u0018\u00010HH&J0\u0010M\u001a\u00020\u00182\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010C\u001a\u00020B2\n\b\u0002\u0010E\u001a\u0004\u0018\u00010D2\n\b\u0002\u0010L\u001a\u0004\u0018\u00010KH&J&\u0010O\u001a\u0004\u0018\u00010N2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010C\u001a\u00020B2\n\b\u0002\u0010E\u001a\u0004\u0018\u00010DH&J2\u0010O\u001a\u0004\u0018\u00010N2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010C\u001a\u00020B2\n\b\u0002\u0010E\u001a\u0004\u0018\u00010D2\n\b\u0002\u0010L\u001a\u0004\u0018\u00010KH&J.\u0010O\u001a\u0004\u0018\u00010N2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010C\u001a\u00020B2\u0006\u0010P\u001a\u00020\r2\n\b\u0002\u0010E\u001a\u0004\u0018\u00010DH&J&\u0010R\u001a\u0004\u0018\u00010Q2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010C\u001a\u00020B2\n\b\u0002\u0010E\u001a\u0004\u0018\u00010DH&J2\u0010R\u001a\u0004\u0018\u00010Q2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010C\u001a\u00020B2\n\b\u0002\u0010E\u001a\u0004\u0018\u00010D2\n\b\u0002\u0010L\u001a\u0004\u0018\u00010KH&J\b\u0010S\u001a\u00020\u0002H&J\b\u0010U\u001a\u00020TH&J\u0018\u0010V\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030)2\u0006\u0010(\u001a\u00020'H&J\u0018\u0010W\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030)2\u0006\u0010(\u001a\u00020'H&J\u0018\u0010X\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030)2\u0006\u0010(\u001a\u00020'H&JX\u0010b\u001a\u00020\u00022\b\u0010Z\u001a\u0004\u0018\u00010Y2\b\u0010[\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010]\u001a\u0004\u0018\u00010\\2\b\u0010^\u001a\u0004\u0018\u00010\\2\b\u0010_\u001a\u0004\u0018\u00010\\2\n\b\u0002\u0010`\u001a\u0004\u0018\u00010\\2\u0006\u0010a\u001a\u00020\rH&J\b\u0010d\u001a\u00020cH&J(\u0010g\u001a\u00020\u00022\u0006\u0010f\u001a\u00020e2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010C\u001a\u00020B2\u0006\u0010L\u001a\u00020KH&¨\u0006l"}, d2 = {"Lcom/bytedance/android/live/browser/IBaseBrowserService;", "Lcom/bytedance/android/live/base/IService;", "", "initAnnie", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "", "url", "Lu30/b;", "buildFullScreenWebPage", "tag", "useOldContainerSchemaMonitor", "getRenderUrlByH5Service", "", "presetWidth", "Lcom/bytedance/android/live/browser/LynxThreadStrategy;", "threadStrategy", "Lcom/bytedance/android/live/browser/d0;", "lynxCallback", "resPrefix", "Lcom/bytedance/android/live/lynx/api/b;", "createOpenLynxComponent", "Landroid/view/ViewGroup;", "viewGroup", "", "isLynx", "addHybridDebugTool", "Landroid/app/Activity;", "activity", "dismissAllWebDialogs", "initPrefetch", "tryInitEnvIfNeeded", ExifInterface.GPS_DIRECTION_TRUE, "event", "params", "sendEventToAllJsBridges", "(Ljava/lang/String;Ljava/lang/Object;)V", "Lv30/a;", "webViewMonitorHelper", "Lcom/bytedance/ies/sdk/widgets/DataCenter;", "dataCenter", "Lcom/bytedance/ies/web/jsbridge2/f;", "provideRegisterMessageLatchMethod", "Lcom/bytedance/android/livesdkapi/hybridapi/BaseJsBridgeMethodFactory;", "factory", "Lio/reactivex/Observable;", "registerExternalMethodFactory", "eventName", "Lcom/bytedance/android/livesdkapi/hybridapi/SubscriberJsEvent;", "registerJsEventSubscriber", "filterRequestUrl", "appendCommonParams", "Lcom/bytedance/android/livesdkapi/depend/model/live/IRoom;", "room", "appendFeedCommonParams", "Lcom/bytedance/ies/web/jsbridge2/b;", "bridgeImpl", "Lcom/bytedance/android/livesdkapi/hybridapi/IJsBridgeManager;", "createJsBridgeManager", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "", "Lkotlin/collections/ArrayList;", "arrayList", "addXBridgeList", "idleInit", "Landroid/net/Uri;", "uri", "Lb7/a;", "commonLifecycle", "Lcom/bytedance/android/annie/api/container/HybridDialog;", "showHybridDialog", "Landroid/content/DialogInterface$OnDismissListener;", "dismissListener", "showHybridDialogWithListener", "Landroid/os/Bundle;", "bundle", "showLitePage", "Lcom/bytedance/android/annie/api/card/HybridCard;", "getHybridCard", "presetWidthPx", "Lcom/bytedance/android/annie/api/container/HybridFragment;", "getHybridFragment", "initRedirectProcessor", "Lcom/bytedance/android/live/schema/api/d;", "createRedirectProcessor", "provideRegisterWRDSMethod", "provideDynamicUnRegisterWRDSMethod", "provideGetLiveNtpTimeMethod", "Landroid/view/View;", "view", "eventType", "Lorg/json/JSONObject;", "category", "metric", "extra", "common", "canSample", "reportCustomV2", "Lcom/bytedance/android/live/lynx/api/a;", "provideJsb2MethodFinder", "Lcom/bytedance/ies/bullet/service/base/utils/KitType;", "kitType", "anniePreload", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "PageErrorListener", "PageFinishedListener", "livehybrid-middleware-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface IBaseBrowserService extends IService {
    public static final a Companion = null;
    public static final int DEFAULT_HALF_SCREEN_HEIGHT_DP_LANDSCAPE = 320;
    public static final int DEFAULT_HALF_SCREEN_HEIGHT_DP_PORTRAIT = 400;
    public static final int DEFAULT_HALF_SCREEN_RADIUS_DP = 8;
    public static final int DEFAULT_HALF_SCREEN_WIDTH_DP_LANDSCAPE = 240;
    public static final int DEFAULT_HALF_SCREEN_WIDTH_DP_PORTRAIT = 300;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\"\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u0007H&¨\u0006\t"}, d2 = {"Lcom/bytedance/android/live/browser/IBaseBrowserService$PageErrorListener;", "", "onReceiveError", "", "webView", "Landroid/webkit/WebView;", "url", "", "msg", "livehybrid-middleware-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public interface PageErrorListener {
        void onReceiveError(WebView r100, String r101, String r102);
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bg\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\b"}, d2 = {"Lcom/bytedance/android/live/browser/IBaseBrowserService$PageFinishedListener;", "", "onPageFinished", "", "webView", "Landroid/webkit/WebView;", "url", "", "livehybrid-middleware-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public interface PageFinishedListener {
        void onPageFinished(WebView r100, String r101);
    }

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f62566a = null;

        public a() {
        }

        static {
            f62566a = new a();
        }
    }

    public static final class b {
        public static /* synthetic */ HybridDialog a(IBaseBrowserService r100, Context r101, Uri r102) {
            return r100.showHybridDialog(r101, r102, null);
        }
    }

    static {
        Companion = a.f62566a;
    }

    void addHybridDebugTool(Context r100, ViewGroup r101, String r102, boolean r103);

    void addXBridgeList(ArrayList<Class<? extends Object>> r100);

    void anniePreload(KitType r100, Context r101, Uri r102, Bundle r103);

    String appendCommonParams(String r100);

    String appendFeedCommonParams(String r100, IRoom r101);

    u30.b buildFullScreenWebPage(Context r100, String r101);

    IJsBridgeManager createJsBridgeManager(Activity r100, com.bytedance.ies.web.jsbridge2.b r101);

    com.bytedance.android.live.lynx.api.b createOpenLynxComponent(Context r100, int r101, LynxThreadStrategy r102, d0 r103, String r104);

    com.bytedance.android.live.schema.api.d createRedirectProcessor();

    void dismissAllWebDialogs(Activity r100);

    @Deprecated(message = "新增代码勿用此方法")
    String filterRequestUrl(String r100);

    HybridCard getHybridCard(Context r100, Uri r101, int r102, b7.a r103);

    HybridCard getHybridCard(Context r100, Uri r101, b7.a r102);

    HybridCard getHybridCard(Context r100, Uri r101, b7.a r102, Bundle r103);

    HybridFragment getHybridFragment(Context r100, Uri r101, b7.a r102);

    HybridFragment getHybridFragment(Context r100, Uri r101, b7.a r102, Bundle r103);

    String getRenderUrlByH5Service(String r100);

    void idleInit();

    void initAnnie();

    void initPrefetch();

    void initRedirectProcessor();

    com.bytedance.ies.web.jsbridge2.f<?, ?> provideDynamicUnRegisterWRDSMethod(DataCenter r100);

    com.bytedance.ies.web.jsbridge2.f<?, ?> provideGetLiveNtpTimeMethod(DataCenter r100);

    com.bytedance.android.live.lynx.api.a provideJsb2MethodFinder();

    com.bytedance.ies.web.jsbridge2.f<?, ?> provideRegisterMessageLatchMethod(DataCenter r100);

    com.bytedance.ies.web.jsbridge2.f<?, ?> provideRegisterWRDSMethod(DataCenter r100);

    Observable<Unit> registerExternalMethodFactory(BaseJsBridgeMethodFactory r100);

    Observable<SubscriberJsEvent> registerJsEventSubscriber(String r100);

    void reportCustomV2(View r100, String r101, String r102, JSONObject r103, JSONObject r104, JSONObject r105, JSONObject r106, int r107);

    <T> void sendEventToAllJsBridges(String r100, T r101);

    HybridDialog showHybridDialog(Context r100, Uri r101, b7.a r102);

    HybridDialog showHybridDialog(Context r100, Uri r101, b7.a r102, Bundle r103, DialogInterface.OnDismissListener r104);

    HybridDialog showHybridDialogWithListener(Context r100, Uri r101, b7.a r102, DialogInterface.OnDismissListener r103);

    boolean showLitePage(Context r100, Uri r101, b7.a r102, Bundle r103);

    void tryInitEnvIfNeeded(Context r100);

    void useOldContainerSchemaMonitor(String r100, String r101);

    v30.a webViewMonitorHelper();
}
