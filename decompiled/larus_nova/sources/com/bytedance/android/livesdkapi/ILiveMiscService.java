package com.bytedance.android.livesdkapi;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.android.live.base.IService;
import com.bytedance.android.live.utility.ServiceLookup;
import com.bytedance.android.livesdkapi.util.IClassLoadOptHelper;
import com.bytedance.android.livesdkapi.util.IScreenRotateMonitor;
import com.bytedance.android.livesdkapi.util.IStatusBarAdapterHelper;
import com.bytedance.android.livesdkapi.util.IVBoostHelper;
import java.util.Map;
import kotlin.Metadata;
import org.json.JSONObject;
import uw2.a;

/* JADX INFO: loaded from: classes12.dex */
@ServiceLookup("com.bytedance.android.livesdk.service.LiveMiscService")
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0000\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u001a\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H&J)\u0010\f\u001a\u00020\u000b\"\b\b\u0000\u0010\b*\u00020\u00072\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00028\u0000H&¢\u0006\u0004\b\f\u0010\rJ)\u0010\u000e\u001a\u00028\u0000\"\b\b\u0000\u0010\b*\u00020\u00072\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00028\u0000H&¢\u0006\u0004\b\u000e\u0010\u000fJ\b\u0010\u0010\u001a\u00020\u0004H&J\u0012\u0010\u0012\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0011\u001a\u00020\u0004H&J.\u0010\u0018\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u00142\u0014\u0010\u0017\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0016H&J\"\u0010\u0018\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u00142\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019H&J*\u0010\u001d\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u001c\u001a\u00020\u001b2\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019H&J6\u0010\u001d\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u001c\u001a\u00020\u001b2\u0014\u0010\u0017\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0016H&J\b\u0010\u001e\u001a\u00020\u0002H&J\b\u0010\u001f\u001a\u00020\u0002H&J\n\u0010!\u001a\u0004\u0018\u00010 H&J\b\u0010#\u001a\u00020\"H&J\b\u0010%\u001a\u00020$H&J\u0010\u0010'\u001a\u00020\u000b2\u0006\u0010&\u001a\u00020\u0007H&J\b\u0010)\u001a\u00020(H&J\b\u0010+\u001a\u00020*H&J\n\u0010-\u001a\u0004\u0018\u00010,H&¨\u0006."}, d2 = {"Lcom/bytedance/android/livesdkapi/ILiveMiscService;", "Lcom/bytedance/android/live/base/IService;", "", "isLive", "", "targetValue", "getOriginalResolutionName", "", ExifInterface.GPS_DIRECTION_TRUE, "key", "defaultValue", "", "setLiveProperties", "(Ljava/lang/String;Ljava/lang/Object;)V", "getLiveProperties", "(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;", "getCurrentUserId", "channel", "getChannelPath", "serviceName", "", "status", "", "extra", "monitorStatus", "Lorg/json/JSONObject;", "jsonObject", "", "duration", "monitorStatusWithDuration", "isPadInVSFullScreen", "isPadABOn", "Luw2/a;", "getLogObserver", "Lxs2/a;", "getRxBus", "Lcom/bytedance/android/livesdkapi/util/IStatusBarAdapterHelper;", "getStatusBarAdapterHelper", "builder", "monitorImageNetwork", "Lcom/bytedance/android/livesdkapi/util/IVBoostHelper;", "getVBootHelper", "Lcom/bytedance/android/livesdkapi/util/IClassLoadOptHelper;", "getClassLoadOptHelper", "Lcom/bytedance/android/livesdkapi/util/IScreenRotateMonitor;", "screenRotateMonitor", "livesdkapi_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface ILiveMiscService extends IService {
    String getChannelPath(String r100);

    IClassLoadOptHelper getClassLoadOptHelper();

    String getCurrentUserId();

    <T> T getLiveProperties(String r100, T r101);

    a getLogObserver();

    String getOriginalResolutionName(boolean r100, String r101);

    xs2.a getRxBus();

    IStatusBarAdapterHelper getStatusBarAdapterHelper();

    IVBoostHelper getVBootHelper();

    boolean isPadABOn();

    boolean isPadInVSFullScreen();

    void monitorImageNetwork(Object r100);

    void monitorStatus(String r100, int r101, Map<String, ? extends Object> r102);

    void monitorStatus(String r100, int r101, JSONObject r102);

    void monitorStatusWithDuration(String r100, int r101, long r102, Map<String, ? extends Object> r103);

    void monitorStatusWithDuration(String r100, int r101, long r102, JSONObject r103);

    IScreenRotateMonitor screenRotateMonitor();

    <T> void setLiveProperties(String r100, T r101);
}
