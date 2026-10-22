package com.bytedance.android.livesdkapi.service;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import androidx.exifinterface.media.ExifInterface;
import com.bytedance.android.live.core.monitor.NewBroadcastMonitor;
import com.bytedance.android.livesdkapi.hybridapi.SubscriberJsEvent;
import com.bytedance.android.livesdkapi.jsb.IExternalAnnieLifecycle;
import com.bytedance.android.livesdkapi.jsb.IExternalLiveAnnieComponent;
import com.bytedance.android.livesdkapi.room.controller.ILiveRoomControllerProvider;
import com.bytedance.android.livesdkapi.room.state.AppState;
import com.ss.android.lark.utils.statistics.PerfLog;
import io.reactivex.Observable;
import java.util.List;
import kotlin.Metadata;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\"\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH&J$\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H&J\u0018\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u00132\u0006\u0010\u0018\u001a\u00020\u0019H&J\b\u0010\u001a\u001a\u00020\u001bH&J\u000e\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00010\u001dH&J'\u0010\u001e\u001a\u0002H\u001f\"\b\b\u0000\u0010\u001f*\u00020\u00012\u0006\u0010 \u001a\u00020\u00132\u0006\u0010!\u001a\u0002H\u001fH&¢\u0006\u0002\u0010\"J\u001a\u0010#\u001a\u00020\u00032\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000bH&J\u0012\u0010$\u001a\u00020\u00032\b\u0010%\u001a\u0004\u0018\u00010&H&J\u0016\u0010'\u001a\b\u0012\u0004\u0012\u00020)0(2\u0006\u0010\u0017\u001a\u00020\u0013H&J#\u0010*\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u001f2\u0006\u0010+\u001a\u00020\u00132\u0006\u0010\u0018\u001a\u0002H\u001fH&¢\u0006\u0002\u0010,¨\u0006-"}, d2 = {"Lcom/bytedance/android/livesdkapi/service/IInternalBusinessService;", "", "asyncCommerceGoodsPageStatus", "", "status", "", "createHybrideCard", "Lcom/bytedance/android/livesdkapi/jsb/IExternalLiveAnnieComponent;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "uri", "Landroid/net/Uri;", NewBroadcastMonitor.STAGE.LIFECYCLE, "Lcom/bytedance/android/livesdkapi/jsb/IExternalAnnieLifecycle;", "createLynxComponent", "Lcom/bytedance/android/livesdkapi/service/IExternalLynxComponent;", "activity", "Landroid/app/Activity;", "url", "", "callback", "Lcom/bytedance/android/livesdkapi/service/IExternalLiveLynxCallback;", "enqueueEvent", "eventName", "params", "Lorg/json/JSONObject;", "getAppState", "Lcom/bytedance/android/livesdkapi/room/state/AppState;", "getLiveExportedXElements", "", "getLiveSettingValue", ExifInterface.GPS_DIRECTION_TRUE, "key", "defaultValue", "(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;", "handleSchema", "injectRoomControllerProvider", "controllerProvider", "Lcom/bytedance/android/livesdkapi/room/controller/ILiveRoomControllerProvider;", "registerJsEventSubscriber", "Lio/reactivex/Observable;", "Lcom/bytedance/android/livesdkapi/hybridapi/SubscriberJsEvent;", "sendEventToAllJsBridges", "event", "(Ljava/lang/String;Ljava/lang/Object;)V", "livesdkapi_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface IInternalBusinessService {
    void asyncCommerceGoodsPageStatus(int r100);

    IExternalLiveAnnieComponent createHybrideCard(Context r100, Uri r101, IExternalAnnieLifecycle r102);

    IExternalLynxComponent createLynxComponent(Activity r100, String r101, IExternalLiveLynxCallback r102);

    void enqueueEvent(String r100, JSONObject r101);

    AppState getAppState();

    List<Object> getLiveExportedXElements();

    <T> T getLiveSettingValue(String r100, T r101);

    void handleSchema(Context r100, Uri r101);

    void injectRoomControllerProvider(ILiveRoomControllerProvider r100);

    Observable<SubscriberJsEvent> registerJsEventSubscriber(String r100);

    <T> void sendEventToAllJsBridges(String r100, T r101);
}
