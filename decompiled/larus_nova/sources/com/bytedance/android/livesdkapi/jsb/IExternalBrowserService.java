package com.bytedance.android.livesdkapi.jsb;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import androidx.exifinterface.media.ExifInterface;
import com.bytedance.android.live.base.IService;
import com.bytedance.android.live.core.monitor.NewBroadcastMonitor;
import com.bytedance.android.live.utility.ServiceLookup;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes12.dex */
@ServiceLookup("com.bytedance.android.live.browser.ExternalBrowserService")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\bg\u0018\u00002\u00020\u00012\u00020\u0002J \u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0004H\u0016J\"\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH&J\"\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J.\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00042\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\b\b\u0002\u0010\u001b\u001a\u00020\u001cH&J.\u0010\u001d\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00042\b\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\b\b\u0002\u0010\u001b\u001a\u00020\u001cH&J\u0018\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u00042\u0006\u0010#\u001a\u00020$H&J\b\u0010%\u001a\u00020!H&J\b\u0010&\u001a\u00020\u001cH&J\"\u0010'\u001a\u0004\u0018\u00010$2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0004H\u0016J#\u0010(\u001a\u00020!\"\u0004\b\u0000\u0010)2\u0006\u0010*\u001a\u00020\u00042\u0006\u0010#\u001a\u0002H)H&¢\u0006\u0002\u0010+¨\u0006,"}, d2 = {"Lcom/bytedance/android/livesdkapi/jsb/IExternalBrowserService;", "Lcom/bytedance/android/live/base/IService;", "Lcom/bytedance/android/livesdkapi/jsb/IExternalBrowserServiceForSaas;", "conversionUrlToGeckoUrl", "", "pageUrl", "channel", "configName", "createAnnieCardComponent", "Lcom/bytedance/android/livesdkapi/jsb/IOuterAnnieCardComponent;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "uri", "Landroid/net/Uri;", "callback", "Lcom/bytedance/android/livesdkapi/jsb/IOuterAnnieCardCallback;", "createHybrideCard", "Lcom/bytedance/android/livesdkapi/jsb/IExternalLiveAnnieComponent;", NewBroadcastMonitor.STAGE.LIFECYCLE, "Lcom/bytedance/android/livesdkapi/jsb/IExternalAnnieLifecycle;", "createLynxComponent", "Lcom/bytedance/android/livesdkapi/jsb/IExternalLiveHybridComponent;", "activity", "Landroid/app/Activity;", "url", "lynxCallback", "Lcom/bytedance/android/livesdkapi/jsb/IExternalLiveLynxCallback;", "useAnnie", "", "createWebViewRecord", "webCallback", "Lcom/bytedance/android/livesdkapi/jsb/IExternalLiveWebCallback;", "enqueueEvent", "", "eventName", "params", "Lorg/json/JSONObject;", "initAnnie", "initAnnieXCardLiveEnv", "readGeckoFromChannel", "sendEventToAllJsBridges", ExifInterface.GPS_DIRECTION_TRUE, "event", "(Ljava/lang/String;Ljava/lang/Object;)V", "livesdkapi_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface IExternalBrowserService extends IService, IExternalBrowserServiceForSaas {

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3})
    public static final class DefaultImpls {
        public static String conversionUrlToGeckoUrl(IExternalBrowserService r100, String r101, String r102, String r103) {
            Intrinsics.checkNotNullParameter(r101, "pageUrl");
            Intrinsics.checkNotNullParameter(r102, "channel");
            Intrinsics.checkNotNullParameter(r103, "configName");
            return "";
        }

        public static IExternalLiveAnnieComponent createHybrideCard(IExternalBrowserService r100, Context r101, Uri r102, IExternalAnnieLifecycle r103) {
            Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
            Intrinsics.checkNotNullParameter(r102, "uri");
            Intrinsics.checkNotNullParameter(r103, NewBroadcastMonitor.STAGE.LIFECYCLE);
            return null;
        }

        public static IExternalLiveHybridComponent createLynxComponent(IExternalBrowserService r100, Activity r101, String r102, IExternalLiveLynxCallback r103) {
            Intrinsics.checkNotNullParameter(r101, "activity");
            Intrinsics.checkNotNullParameter(r102, "url");
            return IExternalBrowserServiceForSaas.DefaultImpls.createLynxComponent(r100, r101, r102, r103);
        }

        public static IExternalLiveHybridComponent createWebViewRecord(IExternalBrowserService r100, Activity r101, String r102, IExternalLiveWebCallback r103) {
            Intrinsics.checkNotNullParameter(r101, "activity");
            Intrinsics.checkNotNullParameter(r102, "url");
            return IExternalBrowserServiceForSaas.DefaultImpls.createWebViewRecord(r100, r101, r102, r103);
        }

        public static JSONObject readGeckoFromChannel(IExternalBrowserService r100, String r101, String r102, String r103) {
            Intrinsics.checkNotNullParameter(r101, "pageUrl");
            Intrinsics.checkNotNullParameter(r102, "channel");
            Intrinsics.checkNotNullParameter(r103, "configName");
            return null;
        }

        public static /* synthetic */ IExternalLiveHybridComponent createLynxComponent$default(IExternalBrowserService r100, Activity r101, String r102, IExternalLiveLynxCallback r103, boolean r104, int r105, Object r106) {
            if (r106 != null) goto L9;
            if ((r105 & 8) == 0) goto L7;
            r104 = true;
        L7:
            return r100.createLynxComponent(r101, r102, r103, r104);
        L9:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: createLynxComponent");
        }

        public static /* synthetic */ IExternalLiveHybridComponent createWebViewRecord$default(IExternalBrowserService r100, Activity r101, String r102, IExternalLiveWebCallback r103, boolean r104, int r105, Object r106) {
            if (r106 != null) goto L9;
            if ((r105 & 8) == 0) goto L7;
            r104 = true;
        L7:
            return r100.createWebViewRecord(r101, r102, r103, r104);
        L9:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: createWebViewRecord");
        }
    }

    String conversionUrlToGeckoUrl(String r100, String r101, String r102);

    IOuterAnnieCardComponent createAnnieCardComponent(Context r100, Uri r101, IOuterAnnieCardCallback r102);

    IExternalLiveAnnieComponent createHybrideCard(Context r100, Uri r101, IExternalAnnieLifecycle r102);

    IExternalLiveHybridComponent createLynxComponent(Activity r100, String r101, IExternalLiveLynxCallback r102, boolean r103);

    IExternalLiveHybridComponent createWebViewRecord(Activity r100, String r101, IExternalLiveWebCallback r102, boolean r103);

    void enqueueEvent(String r100, JSONObject r101);

    void initAnnie();

    boolean initAnnieXCardLiveEnv();

    JSONObject readGeckoFromChannel(String r100, String r101, String r102);

    <T> void sendEventToAllJsBridges(String r100, T r101);
}
