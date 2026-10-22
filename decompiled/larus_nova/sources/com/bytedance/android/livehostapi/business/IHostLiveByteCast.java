package com.bytedance.android.livehostapi.business;

import android.content.Context;
import android.content.Intent;
import android.view.Display;
import com.bytedance.android.livehostapi.business.base.IBaseLiveHostByteCast;
import com.bytedance.android.livehostapi.business.castscreen.interfaces.ILiveCastSourceUIDepend;
import com.bytedance.android.livehostapi.business.castscreen.interfaces.IMiracastStateListener;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003J\b\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0007H&J\b\u0010\b\u001a\u00020\u0005H&J\b\u0010\t\u001a\u00020\u0005H&J\n\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J\u0012\u0010\f\u001a\u00020\u00052\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016J\u0018\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u00102\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\n\u0010\u0014\u001a\u0004\u0018\u00010\u000bH&J\u000f\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016¢\u0006\u0002\u0010\u0017J\b\u0010\u0018\u001a\u00020\u0005H\u0016J\b\u0010\u0019\u001a\u00020\u0005H&J\u000f\u0010\u001a\u001a\u0004\u0018\u00010\u0005H\u0016¢\u0006\u0002\u0010\u001bJ\b\u0010\u001c\u001a\u00020\u0005H\u0016J\b\u0010\u001d\u001a\u00020\u0005H\u0016J\b\u0010\u001e\u001a\u00020\u0011H&J\b\u0010\u001f\u001a\u00020\u0005H\u0016J\b\u0010 \u001a\u00020!H\u0016J\b\u0010\"\u001a\u00020\u0007H\u0016J\u001a\u0010#\u001a\u00020\u00072\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010$\u001a\u00020%H\u0016J\u001a\u0010&\u001a\u00020\u00072\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010$\u001a\u00020%H\u0016J\u001a\u0010'\u001a\u00020\u00072\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010$\u001a\u00020%H\u0016J\u0010\u0010(\u001a\u00020\u00072\u0006\u0010)\u001a\u00020\u0005H\u0016J\u0010\u0010*\u001a\u00020\u00072\u0006\u0010+\u001a\u00020,H\u0016J\"\u0010-\u001a\u00020!2\u0006\u0010.\u001a\u00020/2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u00100\u001a\u00020\u0005H&J\u0010\u00101\u001a\u00020\u00072\u0006\u0010+\u001a\u00020,H\u0016J\b\u00102\u001a\u00020\u0005H\u0016J \u00103\u001a\u00020\u00052\u0006\u00104\u001a\u00020\u00112\u0006\u0010.\u001a\u00020/2\u0006\u00105\u001a\u000206H&¨\u00067À\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livehostapi/business/IHostLiveByteCast;", "Lcom/bytedance/android/livehostapi/business/IMiddlewareHostLiveByteCast;", "Lcom/bytedance/android/livehostapi/business/base/IBaseLiveHostByteCast;", "Lcom/bytedance/android/livehostapi/business/IHostLiveByteCastForSaas;", "canShowBtn", "", "clearCompatibleResolution", "", "enableCastPreSearch", "enableCompatible", "getDisplay", "Landroid/view/Display;", "getMiracastExperimentValue", "depend", "Lcom/bytedance/android/livehostapi/business/castscreen/interfaces/ILiveCastSourceUIDepend;", "getOrderedLiveStreamList", "", "", "room", "Lcom/bytedance/android/livesdkapi/depend/model/live/Room;", "getRemoteDisplay", "getSearchTimeoutPeriodWifiXsg", "", "()Ljava/lang/Long;", "isSysMiracast", "isValid", "isXsgDeviceShowNotBDLink", "()Ljava/lang/Boolean;", "liveCastH265Disable", "liveCastUseStreamData", "liveClarityStrategy", "liveOnlySupportXsg", "liveOnlySupportXsgForMatchRoom", "", "loadPlugin", "logCastClose", "params", "Lorg/json/JSONObject;", "logCastStart", "logMiraFetchMedia", "notifyExtendedCastMode", "enter", "registerMiracastStateListener", "listener", "Lcom/bytedance/android/livehostapi/business/castscreen/interfaces/IMiracastStateListener;", "startCast", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "isLandscape", "unregisterMiracastStateListener", "useNewPortraitUi", "useRouteOutCertIdToIntent", "scene", "intent", "Landroid/content/Intent;", "hostapp-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface IHostLiveByteCast extends IMiddlewareHostLiveByteCast, IBaseLiveHostByteCast, IHostLiveByteCastForSaas {

    /* JADX INFO: renamed from: com.bytedance.android.livehostapi.business.IHostLiveByteCast$-CC, reason: invalid class name */
    public final /* synthetic */ class CC {
        public static Display $default$getDisplay(IHostLiveByteCast r100) {
            return null;
        }

        public static boolean $default$getMiracastExperimentValue(IHostLiveByteCast r100, ILiveCastSourceUIDepend r101) {
            return false;
        }

        public static List $default$getOrderedLiveStreamList(IHostLiveByteCast r100, Room r101) {
            Intrinsics.checkNotNullParameter(r101, "room");
            return null;
        }

        public static Long $default$getSearchTimeoutPeriodWifiXsg(IHostLiveByteCast r100) {
            return null;
        }

        public static boolean $default$isSysMiracast(IHostLiveByteCast r100) {
            return false;
        }

        public static Boolean $default$isXsgDeviceShowNotBDLink(IHostLiveByteCast r100) {
            return null;
        }

        public static boolean $default$liveCastH265Disable(IHostLiveByteCast r100) {
            return false;
        }

        public static boolean $default$liveCastUseStreamData(IHostLiveByteCast r100) {
            return false;
        }

        public static boolean $default$liveOnlySupportXsg(IHostLiveByteCast r100) {
            return true;
        }

        public static int $default$liveOnlySupportXsgForMatchRoom(IHostLiveByteCast r100) {
            return 0;
        }

        public static void $default$loadPlugin(IHostLiveByteCast r100) {
        }

        public static void $default$logCastClose(IHostLiveByteCast r100, ILiveCastSourceUIDepend r101, JSONObject r102) {
            Intrinsics.checkNotNullParameter(r102, "params");
        }

        public static void $default$logCastStart(IHostLiveByteCast r100, ILiveCastSourceUIDepend r101, JSONObject r102) {
            Intrinsics.checkNotNullParameter(r102, "params");
        }

        public static void $default$logMiraFetchMedia(IHostLiveByteCast r100, ILiveCastSourceUIDepend r101, JSONObject r102) {
            Intrinsics.checkNotNullParameter(r102, "params");
        }

        public static void $default$notifyExtendedCastMode(IHostLiveByteCast r100, boolean r101) {
        }

        public static void $default$registerMiracastStateListener(IHostLiveByteCast r100, IMiracastStateListener r101) {
            Intrinsics.checkNotNullParameter(r101, "listener");
        }

        public static void $default$unregisterMiracastStateListener(IHostLiveByteCast r100, IMiracastStateListener r101) {
            Intrinsics.checkNotNullParameter(r101, "listener");
        }

        public static boolean $default$useNewPortraitUi(IHostLiveByteCast r100) {
            return false;
        }

        public static /* synthetic */ boolean access$castEnabled$jd(IHostLiveByteCast r100) {
            return IMiddlewareHostLiveByteCast.CC.$default$castEnabled(r100);
        }

        public static /* synthetic */ Display access$getDisplay$jd(IHostLiveByteCast r100) {
            return $default$getDisplay(r100);
        }

        public static /* synthetic */ Long access$getSearchTimeoutPeriodWifiXsg$jd(IHostLiveByteCast r100) {
            return $default$getSearchTimeoutPeriodWifiXsg(r100);
        }

        public static /* synthetic */ boolean access$hostEntryEnable$jd(IHostLiveByteCast r100) {
            return IMiddlewareHostLiveByteCast.CC.$default$hostEntryEnable(r100);
        }

        public static /* synthetic */ boolean access$isSysMiracast$jd(IHostLiveByteCast r100) {
            return $default$isSysMiracast(r100);
        }

        public static /* synthetic */ Boolean access$isXsgDeviceShowNotBDLink$jd(IHostLiveByteCast r100) {
            return $default$isXsgDeviceShowNotBDLink(r100);
        }

        public static /* synthetic */ boolean access$liveCastH265Disable$jd(IHostLiveByteCast r100) {
            return $default$liveCastH265Disable(r100);
        }

        public static /* synthetic */ boolean access$liveCastUseStreamData$jd(IHostLiveByteCast r100) {
            return $default$liveCastUseStreamData(r100);
        }

        public static /* synthetic */ boolean access$liveOnlySupportXsg$jd(IHostLiveByteCast r100) {
            return $default$liveOnlySupportXsg(r100);
        }

        public static /* synthetic */ int access$liveOnlySupportXsgForMatchRoom$jd(IHostLiveByteCast r100) {
            return $default$liveOnlySupportXsgForMatchRoom(r100);
        }

        public static /* synthetic */ void access$loadPlugin$jd(IHostLiveByteCast r100) {
            $default$loadPlugin(r100);
        }

        public static /* synthetic */ boolean access$useNewPortraitUi$jd(IHostLiveByteCast r100) {
            return $default$useNewPortraitUi(r100);
        }

        public static /* synthetic */ boolean access$getMiracastExperimentValue$jd(IHostLiveByteCast r100, ILiveCastSourceUIDepend r101) {
            return $default$getMiracastExperimentValue(r100, r101);
        }

        public static /* synthetic */ List access$getOrderedLiveStreamList$jd(IHostLiveByteCast r100, Room r101) {
            return $default$getOrderedLiveStreamList(r100, r101);
        }

        public static /* synthetic */ void access$notifyExtendedCastMode$jd(IHostLiveByteCast r100, boolean r101) {
            $default$notifyExtendedCastMode(r100, r101);
        }

        public static /* synthetic */ void access$registerMiracastStateListener$jd(IHostLiveByteCast r100, IMiracastStateListener r101) {
            $default$registerMiracastStateListener(r100, r101);
        }

        public static /* synthetic */ void access$unregisterMiracastStateListener$jd(IHostLiveByteCast r100, IMiracastStateListener r101) {
            $default$unregisterMiracastStateListener(r100, r101);
        }

        public static /* synthetic */ void access$logCastClose$jd(IHostLiveByteCast r100, ILiveCastSourceUIDepend r101, JSONObject r102) {
            $default$logCastClose(r100, r101, r102);
        }

        public static /* synthetic */ void access$logCastStart$jd(IHostLiveByteCast r100, ILiveCastSourceUIDepend r101, JSONObject r102) {
            $default$logCastStart(r100, r101, r102);
        }

        public static /* synthetic */ void access$logMiraFetchMedia$jd(IHostLiveByteCast r100, ILiveCastSourceUIDepend r101, JSONObject r102) {
            $default$logMiraFetchMedia(r100, r101, r102);
        }

        public static /* synthetic */ boolean access$useRouteOutCertIdToIntentReplay$jd(IHostLiveByteCast r100, String r101, Context r102, Intent r103) {
            return IMiddlewareHostLiveByteCast.CC.$default$useRouteOutCertIdToIntentReplay(r100, r101, r102, r103);
        }
    }

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3})
    public static final class DefaultImpls {
        public static boolean castEnabled(IHostLiveByteCast r100) {
            return CC.access$castEnabled$jd(r100);
        }

        public static Display getDisplay(IHostLiveByteCast r100) {
            return CC.access$getDisplay$jd(r100);
        }

        public static Long getSearchTimeoutPeriodWifiXsg(IHostLiveByteCast r100) {
            return CC.access$getSearchTimeoutPeriodWifiXsg$jd(r100);
        }

        public static boolean hostEntryEnable(IHostLiveByteCast r100) {
            return CC.access$hostEntryEnable$jd(r100);
        }

        public static boolean isSysMiracast(IHostLiveByteCast r100) {
            return CC.access$isSysMiracast$jd(r100);
        }

        public static Boolean isXsgDeviceShowNotBDLink(IHostLiveByteCast r100) {
            return CC.access$isXsgDeviceShowNotBDLink$jd(r100);
        }

        public static boolean liveCastH265Disable(IHostLiveByteCast r100) {
            return CC.access$liveCastH265Disable$jd(r100);
        }

        public static boolean liveCastUseStreamData(IHostLiveByteCast r100) {
            return CC.access$liveCastUseStreamData$jd(r100);
        }

        public static boolean liveOnlySupportXsg(IHostLiveByteCast r100) {
            return CC.access$liveOnlySupportXsg$jd(r100);
        }

        public static int liveOnlySupportXsgForMatchRoom(IHostLiveByteCast r100) {
            return CC.access$liveOnlySupportXsgForMatchRoom$jd(r100);
        }

        public static void loadPlugin(IHostLiveByteCast r100) {
            CC.access$loadPlugin$jd(r100);
        }

        public static boolean useNewPortraitUi(IHostLiveByteCast r100) {
            return CC.access$useNewPortraitUi$jd(r100);
        }

        public static boolean getMiracastExperimentValue(IHostLiveByteCast r100, ILiveCastSourceUIDepend r101) {
            return CC.access$getMiracastExperimentValue$jd(r100, r101);
        }

        public static List<String> getOrderedLiveStreamList(IHostLiveByteCast r100, Room r101) {
            return CC.access$getOrderedLiveStreamList$jd(r100, r101);
        }

        public static void notifyExtendedCastMode(IHostLiveByteCast r100, boolean r101) {
            CC.access$notifyExtendedCastMode$jd(r100, r101);
        }

        public static void registerMiracastStateListener(IHostLiveByteCast r100, IMiracastStateListener r101) {
            CC.access$registerMiracastStateListener$jd(r100, r101);
        }

        public static void unregisterMiracastStateListener(IHostLiveByteCast r100, IMiracastStateListener r101) {
            CC.access$unregisterMiracastStateListener$jd(r100, r101);
        }

        public static void logCastClose(IHostLiveByteCast r100, ILiveCastSourceUIDepend r101, JSONObject r102) {
            CC.access$logCastClose$jd(r100, r101, r102);
        }

        public static void logCastStart(IHostLiveByteCast r100, ILiveCastSourceUIDepend r101, JSONObject r102) {
            CC.access$logCastStart$jd(r100, r101, r102);
        }

        public static void logMiraFetchMedia(IHostLiveByteCast r100, ILiveCastSourceUIDepend r101, JSONObject r102) {
            CC.access$logMiraFetchMedia$jd(r100, r101, r102);
        }

        public static boolean useRouteOutCertIdToIntentReplay(IHostLiveByteCast r100, String r101, Context r102, Intent r103) {
            return CC.access$useRouteOutCertIdToIntentReplay$jd(r100, r101, r102, r103);
        }
    }

    boolean canShowBtn();

    void clearCompatibleResolution();

    boolean enableCastPreSearch();

    boolean enableCompatible();

    Display getDisplay();

    boolean getMiracastExperimentValue(ILiveCastSourceUIDepend r100);

    List<String> getOrderedLiveStreamList(Room r100);

    Display getRemoteDisplay();

    Long getSearchTimeoutPeriodWifiXsg();

    boolean isSysMiracast();

    boolean isValid();

    Boolean isXsgDeviceShowNotBDLink();

    boolean liveCastH265Disable();

    boolean liveCastUseStreamData();

    String liveClarityStrategy();

    boolean liveOnlySupportXsg();

    int liveOnlySupportXsgForMatchRoom();

    void loadPlugin();

    void logCastClose(ILiveCastSourceUIDepend r100, JSONObject r101);

    void logCastStart(ILiveCastSourceUIDepend r100, JSONObject r101);

    void logMiraFetchMedia(ILiveCastSourceUIDepend r100, JSONObject r101);

    void notifyExtendedCastMode(boolean r100);

    void registerMiracastStateListener(IMiracastStateListener r100);

    int startCast(Context r100, ILiveCastSourceUIDepend r101, boolean r102);

    void unregisterMiracastStateListener(IMiracastStateListener r100);

    boolean useNewPortraitUi();

    boolean useRouteOutCertIdToIntent(String r100, Context r101, Intent r102);
}
