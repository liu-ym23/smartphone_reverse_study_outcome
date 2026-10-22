package com.bytedance.android.livesdk.service;

import android.text.TextUtils;
import androidx.exifinterface.media.ExifInterface;
import com.bytedance.android.live.core.monitor.LiveSlardarMonitor;
import com.bytedance.android.live.core.utils.fresco.ImageNetworkRequestsMonitor;
import com.bytedance.android.live.room.api.screenrotation.api.IScreenRotateService;
import com.bytedance.android.live.user.IUserService;
import com.bytedance.android.livesdk.chatroom.resolution.AudienceVideoResolutionManager;
import com.bytedance.android.livesdk.gecko.LiveGeckoClientImpl;
import com.bytedance.android.livesdk.gecko.LiveGeckoConfig;
import com.bytedance.android.livesdk.padutils.PadConfigUtils;
import com.bytedance.android.livesdk.utils.h6;
import com.bytedance.android.livesdk.utils.k0;
import com.bytedance.android.livesdk.utils.y6;
import com.bytedance.android.livesdkapi.ILiveMiscService;
import com.bytedance.android.livesdkapi.util.IClassLoadOptHelper;
import com.bytedance.android.livesdkapi.util.IScreenRotateMonitor;
import com.bytedance.android.livesdkapi.util.IStatusBarAdapterHelper;
import com.bytedance.android.livesdkapi.util.IVBoostHelper;
import com.bytedance.geckox.utils.ResLoadUtils;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import java.util.Iterator;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0000\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0017\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b.\u0010/J\u001a\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J)\u0010\f\u001a\u00020\u000b\"\b\b\u0000\u0010\b*\u00020\u00072\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\f\u0010\rJ)\u0010\u000e\u001a\u00028\u0000\"\b\b\u0000\u0010\b*\u00020\u00072\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\b\u0010\u0010\u001a\u00020\u0004H\u0016J\u0012\u0010\u0012\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0011\u001a\u00020\u0004H\u0016J.\u0010\u0018\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u00142\u0014\u0010\u0017\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0016H\u0016J\"\u0010\u0018\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u00142\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019H\u0016J*\u0010\u001d\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u001c\u001a\u00020\u001b2\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019H\u0016J6\u0010\u001d\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u001c\u001a\u00020\u001b2\u0014\u0010\u0017\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0016H\u0016J\n\u0010\u001f\u001a\u0004\u0018\u00010\u001eH\u0016J\b\u0010 \u001a\u00020\u0002H\u0016J\b\u0010!\u001a\u00020\u0002H\u0016J\b\u0010#\u001a\u00020\"H\u0016J\b\u0010%\u001a\u00020$H\u0016J\b\u0010'\u001a\u00020&H\u0016J\u0010\u0010)\u001a\u00020\u000b2\u0006\u0010(\u001a\u00020\u0007H\u0016J\b\u0010+\u001a\u00020*H\u0016J\n\u0010-\u001a\u0004\u0018\u00010,H\u0016¨\u00060"}, d2 = {"Lcom/bytedance/android/livesdk/service/LiveMiscService;", "Lcom/bytedance/android/livesdkapi/ILiveMiscService;", "", "isLive", "", "targetValue", "getOriginalResolutionName", "", ExifInterface.GPS_DIRECTION_TRUE, "key", "defaultValue", "", "setLiveProperties", "(Ljava/lang/String;Ljava/lang/Object;)V", "getLiveProperties", "(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;", "getCurrentUserId", "channel", "getChannelPath", "serviceName", "", "status", "", "extra", "monitorStatus", "Lorg/json/JSONObject;", "jsonObject", "", "duration", "monitorStatusWithDuration", "Luw2/a;", "getLogObserver", "isPadInVSFullScreen", "isPadABOn", "Lxs2/a;", "getRxBus", "Lcom/bytedance/android/livesdkapi/util/IStatusBarAdapterHelper;", "getStatusBarAdapterHelper", "Lcom/bytedance/android/livesdkapi/util/IVBoostHelper;", "getVBootHelper", "builder", "monitorImageNetwork", "Lcom/bytedance/android/livesdkapi/util/IClassLoadOptHelper;", "getClassLoadOptHelper", "Lcom/bytedance/android/livesdkapi/util/IScreenRotateMonitor;", "screenRotateMonitor", "<init>", "()V", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public class LiveMiscService implements ILiveMiscService {
    public LiveMiscService() {
    }

    @Override // com.bytedance.android.livesdkapi.ILiveMiscService
    public String getCurrentUserId() {
        return ((IUserService) jc1.k.n(IUserService.class)).user().n();
    }

    @Override // com.bytedance.android.livesdkapi.ILiveMiscService
    public uw2.a getLogObserver() {
        int r100 = com.bytedance.android.live.core.tetris.widgets.e.f65982a;
        return new uw2.a();
    }

    @Override // com.bytedance.android.livesdkapi.ILiveMiscService
    public IScreenRotateMonitor screenRotateMonitor() {
        return ((IScreenRotateService) jc1.k.n(IScreenRotateService.class)).rotateMonitor(null);
    }

    @Override // com.bytedance.android.livesdkapi.ILiveMiscService
    public xs2.a getRxBus() {
        return xs2.b.a();
    }

    @Override // com.bytedance.android.livesdkapi.ILiveMiscService
    public boolean isPadABOn() {
        return PadConfigUtils.c();
    }

    @Override // com.bytedance.android.livesdkapi.ILiveMiscService
    public boolean isPadInVSFullScreen() {
        PadConfigUtils.c();
        return false;
    }

    @Override // com.bytedance.android.livesdkapi.ILiveMiscService
    public IClassLoadOptHelper getClassLoadOptHelper() {
        return k0.f159004a;
    }

    @Override // com.bytedance.android.livesdkapi.ILiveMiscService
    public IStatusBarAdapterHelper getStatusBarAdapterHelper() {
        return h6.f158978a;
    }

    @Override // com.bytedance.android.livesdkapi.ILiveMiscService
    public IVBoostHelper getVBootHelper() {
        return y6.f159224a;
    }

    @Override // com.bytedance.android.livesdkapi.ILiveMiscService
    public String getChannelPath(String r100) {
        Intrinsics.checkNotNullParameter(r100, "channel");
        Lazy r101 = LiveGeckoClientImpl.f125774f;
        LiveGeckoClientImpl r102 = (LiveGeckoClientImpl) LiveGeckoClientImpl.f125774f.getValue();
        r102.getClass();
        Intrinsics.checkNotNullParameter(r100, "channel");
        return ResLoadUtils.getChannelPath(r102.f125779d, LiveGeckoConfig.b(), r100);
    }

    @Override // com.bytedance.android.livesdkapi.ILiveMiscService
    public void monitorImageNetwork(Object r100) {
        Intrinsics.checkNotNullParameter(r100, "builder");
        new ImageNetworkRequestsMonitor().monitor((ImageRequestBuilder) r100);     // Catch: Exception -> L5
        return;
    }

    @Override // com.bytedance.android.livesdkapi.ILiveMiscService
    public <T> T getLiveProperties(String r100, T r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter(r101, "defaultValue");
        T r102 = (T) new com.bytedance.android.livesdk.sharedpref.e(r100, r101).getValue();
        if (r102 != null) goto L6;
        return r101;
    L6:
        return r102;
    }

    @Override // com.bytedance.android.livesdkapi.ILiveMiscService
    public String getOriginalResolutionName(boolean r100, String r101) {
        Intrinsics.checkNotNull(r101);
        int r102 = AudienceVideoResolutionManager.f110411a;
        Intrinsics.checkNotNullParameter(r101, "targetValue");
        if (r100 == false) goto L10;
        Iterator<String> r103 = AudienceVideoResolutionManager.f110436z.keySet().iterator();
    L6:
        if (r103.hasNext() == false) goto L25;
        String r104 = r103.next();
        if (TextUtils.equals(AudienceVideoResolutionManager.f110436z.get(r104), r101) == false) goto L6;
    L24:
        return r104;
    L25:
        return r101;
    L10:
        Iterator<String> r105 = AudienceVideoResolutionManager.f110434x.keySet().iterator();
    L12:
        if (r105.hasNext() == false) goto L16;
        r104 = r105.next();
        if (TextUtils.equals(AudienceVideoResolutionManager.f110434x.get(r104), r101) == false) goto L12;
    L16:
        return "1080p";
    }

    @Override // com.bytedance.android.livesdkapi.ILiveMiscService
    public <T> void setLiveProperties(String r100, T r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter(r101, "defaultValue");
        com.bytedance.android.livesdk.sharedpref.f.d(new com.bytedance.android.livesdk.sharedpref.e(r100, r101), r101);
    }

    @Override // com.bytedance.android.livesdkapi.ILiveMiscService
    public void monitorStatus(String r100, int r101, Map<String, ? extends Object> r102) {
        Intrinsics.checkNotNullParameter(r100, "serviceName");
        LiveSlardarMonitor.monitorStatus(r100, r101, r102);
    }

    @Override // com.bytedance.android.livesdkapi.ILiveMiscService
    public void monitorStatus(String r100, int r101, JSONObject r102) {
        Intrinsics.checkNotNullParameter(r100, "serviceName");
        LiveSlardarMonitor.monitorStatus(r100, r101, r102);
    }

    @Override // com.bytedance.android.livesdkapi.ILiveMiscService
    public void monitorStatusWithDuration(String r100, int r101, long r102, Map<String, ? extends Object> r103) {
        Intrinsics.checkNotNullParameter(r100, "serviceName");
        LiveSlardarMonitor.monitorStatusAndDuration(r100, r101, r102, r103);
    }

    @Override // com.bytedance.android.livesdkapi.ILiveMiscService
    public void monitorStatusWithDuration(String r100, int r101, long r102, JSONObject r103) {
        Intrinsics.checkNotNullParameter(r100, "serviceName");
        LiveSlardarMonitor.monitorStatusAndDuration(r100, r101, r102, r103);
    }
}
