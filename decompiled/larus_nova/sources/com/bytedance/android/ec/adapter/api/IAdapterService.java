package com.bytedance.android.ec.adapter.api;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.widget.FrameLayout;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.MutableLiveData;
import com.byted.cast.linkcommon.cybergarage.upnp.device.ST;
import com.bytedance.android.ec.adapter.api.player.IECPlayerViewService;
import com.bytedance.android.live.core.monitor.NewBroadcastMonitor;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000\u0086\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\u001d\u0010\u0007\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u00062\u0006\u0010\u0003\u001a\u00028\u0000H&¢\u0006\u0004\b\u0007\u0010\bJ+\u0010\f\u001a\u0004\u0018\u00018\u0000\"\b\b\u0000\u0010\u0006*\u00020\u00012\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00028\u0000H&¢\u0006\u0004\b\f\u0010\rJ\u0012\u0010\u000e\u001a\u0004\u0018\u00010\u00012\u0006\u0010\n\u001a\u00020\tH&J.\u0010\u0017\u001a\u00020\u00132\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u00112\b\b\u0002\u0010\u0014\u001a\u00020\u00132\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0015H&J\u0010\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u0018H&J\b\u0010\u001b\u001a\u00020\u0004H&J\u0010\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u0018H&J\n\u0010\u001f\u001a\u0004\u0018\u00010\u001eH&J\n\u0010!\u001a\u0004\u0018\u00010 H&J\n\u0010#\u001a\u0004\u0018\u00010\"H&J\n\u0010%\u001a\u0004\u0018\u00010$H&J\b\u0010&\u001a\u00020\u0013H&J\b\u0010'\u001a\u00020\u0004H&J\b\u0010(\u001a\u00020\u0004H&J\u0011\u0010)\u001a\u0004\u0018\u00010\u0013H&¢\u0006\u0004\b)\u0010*J \u00100\u001a\u00020\u00042\u0006\u0010,\u001a\u00020+2\u0006\u0010-\u001a\u00020\u00182\u0006\u0010/\u001a\u00020.H&J0\u00106\u001a\u00020\u00042\u0006\u00101\u001a\u00020\u00132\u0006\u00102\u001a\u00020\u00182\u0006\u00103\u001a\u00020.2\u0006\u00104\u001a\u00020.2\u0006\u00105\u001a\u00020\u0013H&J0\u00107\u001a\u00020\u00042\u0006\u00101\u001a\u00020\u00132\u0006\u00102\u001a\u00020\u00182\u0006\u00103\u001a\u00020.2\u0006\u00104\u001a\u00020.2\u0006\u00105\u001a\u00020\u0013H&J\u0010\u00109\u001a\u00020\u00042\u0006\u00108\u001a\u00020\u0013H&J\n\u0010;\u001a\u0004\u0018\u00010:H&J\b\u0010<\u001a\u00020\u0013H&J\n\u0010=\u001a\u0004\u0018\u00010\tH&J\n\u0010?\u001a\u0004\u0018\u00010>H&J\n\u0010@\u001a\u0004\u0018\u00010\tH&J4\u0010D\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\t2\"\u0010C\u001a\u001e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0Aj\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t`BH&J\u0018\u0010G\u001a\u00020\u00042\u0006\u0010E\u001a\u00020\u00132\u0006\u0010F\u001a\u00020\u0015H&J\"\u0010L\u001a\u00020\u00042\u0006\u0010H\u001a\u00020\u00132\u0006\u0010I\u001a\u00020\u00132\b\u0010K\u001a\u0004\u0018\u00010JH&J\b\u0010M\u001a\u00020\u0004H&J\u0010\u0010O\u001a\u00020\u00042\u0006\u0010N\u001a\u00020\u0001H\u0016J\u0018\u0010Q\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010P\u001a\u00020\tH&J\u0010\u0010T\u001a\u00020\u00042\u0006\u0010S\u001a\u00020RH&J\b\u0010U\u001a\u00020\u0004H&J\u001c\u0010X\u001a\u00020\u00042\u0012\u0010W\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00040VH&J\u001c\u0010Y\u001a\u00020\u00042\u0012\u0010W\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00040VH&J,\u0010]\u001a\u00020\u00042\u0006\u0010[\u001a\u00020Z2\u0006\u0010\\\u001a\u00020\t2\u0012\u0010W\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00040VH&J\n\u0010_\u001a\u0004\u0018\u00010^H&JN\u0010e\u001a\u0004\u0018\u00010d2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\\\u001a\u00020\t2\u0010\b\u0002\u0010a\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010`2\u0010\b\u0002\u0010b\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010`2\u000e\u0010c\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010`H&J\\\u0010h\u001a\u00020\u00042\u0006\u0010[\u001a\u00020Z2\b\b\u0002\u0010P\u001a\u00020\t2\b\b\u0002\u0010f\u001a\u00020\t2\b\b\u0002\u0010\\\u001a\u00020\t2\b\b\u0002\u0010g\u001a\u00020\u00132\u0010\b\u0002\u0010a\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010`2\u0010\b\u0002\u0010b\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010`H&J\u0010\u0010j\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010iH&J\n\u0010l\u001a\u0004\u0018\u00010kH&J\u0010\u0010o\u001a\u00020\u00042\u0006\u0010n\u001a\u00020mH&J\u0014\u0010p\u001a\u00020\u00042\n\b\u0002\u0010/\u001a\u0004\u0018\u00010\tH&J.\u0010z\u001a\u0004\u0018\u00010y2\u0006\u0010r\u001a\u00020q2\u0006\u0010t\u001a\u00020s2\u0006\u0010v\u001a\u00020u2\n\b\u0002\u0010x\u001a\u0004\u0018\u00010wH&J\n\u0010|\u001a\u0004\u0018\u00010{H&J\u0010\u0010}\u001a\u00020\u00042\u0006\u0010/\u001a\u00020\tH&J\u0010\u0010~\u001a\u00020\u00042\u0006\u0010/\u001a\u00020\tH&J\u0010\u0010\u007f\u001a\u00020\u00042\u0006\u0010/\u001a\u00020\tH&J\u001c\u0010\u0083\u0001\u001a\u00020\u00042\u0007\u0010\u0080\u0001\u001a\u00020\t2\b\u0010\u0082\u0001\u001a\u00030\u0081\u0001H&J\u000b\u0010\u0084\u0001\u001a\u0004\u0018\u00010\tH&J\n\u0010\u0086\u0001\u001a\u00030\u0085\u0001H&¨\u0006\u0087\u0001"}, d2 = {"Lcom/bytedance/android/ec/adapter/api/IAdapterService;", "", "Lrd/b;", "controllerProvider", "", "injectRoomControllerProvider", ExifInterface.GPS_DIRECTION_TRUE, "injectRoomControllerProviderV2", "(Ljava/lang/Object;)V", "", "key", "defaultValue", "getLiveSettingsValue", "(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;", "getOriginSettingValue", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/net/Uri;", "uri", "", "withHost", "Landroid/os/Bundle;", "bundle", "handleSchemaWithLive", "", "status", "notifyPushStream", "notifyShowBubble", "count", "notifyMiniApp", "Lcom/bytedance/android/ec/adapter/api/e;", "getFragmentDispatcher", "Lcom/bytedance/android/ec/adapter/api/j;", "getLiveWindowService", "Lcom/bytedance/android/ec/adapter/api/i;", "getUxTracerService", "Lpd/e;", "getIExternaHybridService", "isLiveServiceReady", "muteLiveRoom", "cancelMuteLiveRoom", "hasLivePlayingMute", "()Ljava/lang/Boolean;", "", "factor", "totalHeight", "", "roomId", "onOffsetChanged", "open", "panelHeight", "openAnimatorDuration", "closeAnimatorDuration", "syncNotify", "notifyPanelEventByLiveList", "notifyPanelEventByLiveCard", "autoUnmute", "setAutoUnmute", "Lcom/bytedance/android/ec/adapter/api/player/IECPlayerViewService;", "getPlayerViewService", "isLiving", "getIfClearModeValueWithClick", "Lcom/bytedance/android/ec/adapter/api/g;", "getLivePerformanceManager", "getIfClearModeValueWithIntroCardShow", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "map", "sendLiveLogger", "isWrite", "noFilterStatus", "preOperateNoFilterStatus", "hasCommodity", "isNoFilterEnable", "Lcom/bytedance/android/ec/adapter/api/b;", "callBack", "notifyCommodityNoFilterStatus", "injectMessage", "injectionStub", "injectMessageOnSaas", "enterFrom", "requestForShoppingAccess", "Lke/a;", "performanceStrategyTask", "registerPerformanceStrategyTask", "unregisterPerformanceStrategyTask", "Lkotlin/Function1;", "callback", "getCurrentAccountPhoneNumber", "isPhoneNumberUsedInDouyin", "Landroid/app/Activity;", "activity", "source", "doDouyinAuth", "Lod/a;", "getAuthReport", "Lkotlin/Function0;", "onResultOK", "onResultError", "onExtra", "Landroid/app/Dialog;", "showProtocolConfirmDialog", "enterMethod", "userAgreeAuth", "loginUserAgreeAuth", "Landroidx/lifecycle/MutableLiveData;", "getAppEnterBackgroundOb", "Loe/a;", "getStrategyService", "Lhe/a;", "message", "sendMessage", "forceResumePlayer", "Landroid/widget/FrameLayout;", "rootView", "Landroidx/fragment/app/FragmentManager;", "fm", "Lcom/bytedance/android/ec/adapter/api/a;", "floatExtra", "Lcom/bytedance/android/ec/adapter/api/d;", "iFloatLiveWindow", "Landroidx/fragment/app/Fragment;", "showFloatLiveWindow", "Lfe/b;", "getMessageManagerService", "excActionBySetting", "showInteractionMask", "showInteractionAndEnterRoom", ST.UUID_DEVICE, "Lcom/bytedance/android/ec/adapter/api/h;", NewBroadcastMonitor.STAGE.LIFECYCLE, "ecAnnieLifeCallback", "getWebcastAppId", "Lwu1/a;", "getECLiveStateController", "ec-adapter-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface IAdapterService {

    public static final class a {
        public static /* synthetic */ boolean a(IAdapterService r100, Context r101, Uri r102, boolean r103, int r104) {
            if ((r104 & 4) == 0) goto L6;
            r103 = false;
        L6:
            if ((r104 & 8) == 0) goto L8;
            Bundle r105 = new Bundle();
        L10:
            return r100.handleSchemaWithLive(r101, r102, r103, r105);
        L8:
            r105 = null;
            goto L10
        }
    }

    void cancelMuteLiveRoom();

    void doDouyinAuth(Activity r100, String r101, Function1<? super Boolean, Unit> r102);

    void ecAnnieLifeCallback(String r100, h r101);

    void excActionBySetting(String r100);

    void forceResumePlayer(String r100);

    MutableLiveData<Boolean> getAppEnterBackgroundOb();

    od.a getAuthReport();

    void getCurrentAccountPhoneNumber(Function1<? super String, Unit> r100);

    wu1.a getECLiveStateController();

    e getFragmentDispatcher();

    pd.e getIExternaHybridService();

    String getIfClearModeValueWithClick();

    String getIfClearModeValueWithIntroCardShow();

    g getLivePerformanceManager();

    <T> T getLiveSettingsValue(String r100, T r101);

    j getLiveWindowService();

    fe.b getMessageManagerService();

    Object getOriginSettingValue(String r100);

    IECPlayerViewService getPlayerViewService();

    oe.a getStrategyService();

    i getUxTracerService();

    String getWebcastAppId();

    boolean handleSchemaWithLive(Context r100, Uri r101, boolean r102, Bundle r103);

    Boolean hasLivePlayingMute();

    void injectMessage();

    void injectMessageOnSaas(Object r100);

    void injectRoomControllerProvider(rd.b r100);

    <T> void injectRoomControllerProviderV2(T r100);

    boolean isLiveServiceReady();

    boolean isLiving();

    void isPhoneNumberUsedInDouyin(Function1<? super Boolean, Unit> r100);

    void loginUserAgreeAuth(Activity r100, String r101, String r102, String r103, boolean r104, Function0<Unit> r105, Function0<Unit> r106);

    void muteLiveRoom();

    void notifyCommodityNoFilterStatus(boolean r100, boolean r101, b r102);

    void notifyMiniApp(int r100);

    void notifyPanelEventByLiveCard(boolean r100, int r101, long r102, long r103, boolean r104);

    void notifyPanelEventByLiveList(boolean r100, int r101, long r102, long r103, boolean r104);

    void notifyPushStream(int r100);

    void notifyShowBubble();

    void onOffsetChanged(float r100, int r101, long r102);

    void preOperateNoFilterStatus(boolean r100, Bundle r101);

    void registerPerformanceStrategyTask(ke.a r100);

    void requestForShoppingAccess(Context r100, String r101);

    void sendLiveLogger(String r100, HashMap<String, String> r101);

    void sendMessage(he.a r100);

    void setAutoUnmute(boolean r100);

    Fragment showFloatLiveWindow(FrameLayout r100, FragmentManager r101, com.bytedance.android.ec.adapter.api.a r102, d r103);

    void showInteractionAndEnterRoom(String r100);

    void showInteractionMask(String r100);

    Dialog showProtocolConfirmDialog(Context r100, String r101, Function0<Unit> r102, Function0<Unit> r103, Function0<Unit> r104);

    void unregisterPerformanceStrategyTask();
}
