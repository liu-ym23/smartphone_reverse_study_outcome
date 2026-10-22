package com.bytedance.android.live.impl;

import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.util.LongSparseArray;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.base.model.user.UserEvent;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.i0;
import com.bytedance.android.live.core.utils.k0;
import com.bytedance.android.live.core.utils.screen.FoldScreenUtils;
import com.bytedance.android.live.feature.api.FeatureType;
import com.bytedance.android.live.feature.api.IFeatureService;
import com.bytedance.android.live.feature.config.LiveFeatureConfig;
import com.bytedance.android.live.impl.applogListener.FeatureApplogListener;
import com.bytedance.android.live.impl.logInterceptor.ShuffleSequenceInterceptor;
import com.bytedance.android.live.impl.logfilter.DeviceFeatureFilter;
import com.bytedance.android.live.impl.logfilter.RealtimeSequenceFilter;
import com.bytedance.android.live.impl.logfilter.SkipSequenceHelper;
import com.bytedance.android.live.impl.logfilter.UserFeatureInRoomFilter;
import com.bytedance.android.live.impl.logfilter.e;
import com.bytedance.android.live.impl.logfilter.f;
import com.bytedance.android.live.impl.logfilter.r;
import com.bytedance.android.live.impl.service.FeatureManager;
import com.bytedance.android.live.impl.service.FeedFeatureManager;
import com.bytedance.android.live.impl.service.LivePortraitCenterService;
import com.bytedance.android.live.impl.service.RoomService;
import com.bytedance.android.live.impl.utils.LimitSizeQueue;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livehostapi.IMiddleHostService;
import com.bytedance.android.livehostapi.TTMiddlewareLiveSDK;
import com.bytedance.android.livehostapi.business.IMiddlewareHostBusiness;
import com.bytedance.android.livehostapi.foundation.IMiddleWareHostContext;
import com.bytedance.android.livehostapi.platform.IMiddlewareHostAction;
import com.bytedance.android.livesdk.log.g;
import com.bytedance.android.livesdk.padutils.PadConfigUtils;
import com.bytedance.android.livesdk.utils.e5;
import com.bytedance.android.livesdkapi.api.IUtilsCommonService;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomStats;
import com.bytedance.android.livesdkapi.depend.prefs.Property;
import com.bytedance.android.livesdkapi.model.LiveUnifyBoxConfig;
import com.bytedance.common.utility.concurrent.TTExecutors;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.dypay.api.DyPayConstant;
import com.ss.android.socialbase.appdownloader.util.RomUtils;
import com.ss.ttvideoengine.TextureRenderStrategyInterface;
import io.reactivex.Flowable;
import j40.a2;
import j40.c0;
import j40.n3;
import j40.t2;
import j40.u2;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
import jc1.k;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONObject;
import py.j;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000f\b\u0017\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\bK\u0010LJ\u001e\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0002J\u0016\u0010\t\u001a\u00020\u00072\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0002J\b\u0010\n\u001a\u00020\u0007H\u0002J\b\u0010\u000b\u001a\u00020\u0007H\u0002J\b\u0010\f\u001a\u00020\u0007H\u0002J\b\u0010\r\u001a\u00020\u0007H\u0002J\b\u0010\u000e\u001a\u00020\u0007H\u0002J\b\u0010\u000f\u001a\u00020\u0007H\u0002J\b\u0010\u0010\u001a\u00020\u0007H\u0002J\u001e\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0016J\b\u0010\u0013\u001a\u00020\u0012H\u0016J\u0010\u0010\u0016\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u0014H\u0016J\u0010\u0010\u0017\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u0014H\u0016J\b\u0010\u0019\u001a\u00020\u0018H\u0016J\n\u0010\u001b\u001a\u0004\u0018\u00010\u001aH\u0016J\u0012\u0010\u001e\u001a\u00020\u00072\b\u0010\u001d\u001a\u0004\u0018\u00010\u001cH\u0016J\u0012\u0010\u001f\u001a\u00020\u00072\b\u0010\u001d\u001a\u0004\u0018\u00010\u001cH\u0016J\u001a\u0010%\u001a\u00020$2\u0006\u0010!\u001a\u00020 2\b\u0010#\u001a\u0004\u0018\u00010\"H\u0016J\b\u0010&\u001a\u00020$H\u0016J\u0010\u0010(\u001a\n\u0012\u0004\u0012\u00020\u001c\u0018\u00010'H\u0016J\u001a\u0010-\u001a\u00020\u00072\b\u0010*\u001a\u0004\u0018\u00010)2\u0006\u0010,\u001a\u00020+H\u0016J\u001a\u0010.\u001a\u00020\u00072\b\u0010*\u001a\u0004\u0018\u00010)2\u0006\u0010,\u001a\u00020+H\u0016J\u001a\u0010/\u001a\u00020\u00072\b\u0010*\u001a\u0004\u0018\u00010)2\u0006\u0010,\u001a\u00020+H\u0016J\u001a\u00100\u001a\u00020\u00072\b\u0010*\u001a\u0004\u0018\u00010)2\u0006\u0010,\u001a\u00020+H\u0016J\u0012\u00101\u001a\u00020\u00072\b\u0010*\u001a\u0004\u0018\u00010)H\u0016J\b\u00102\u001a\u00020\u0007H\u0016J\b\u00103\u001a\u00020\u0002H\u0016J\u0012\u00104\u001a\u00020\u00072\b\u0010\u001d\u001a\u0004\u0018\u00010\u001cH\u0016J\u0018\u00106\u001a\u00020\u00072\u0006\u0010\u001d\u001a\u00020\u001c2\u0006\u00105\u001a\u00020 H\u0016J\"\u00109\u001a\u00020\u00072\u0006\u0010,\u001a\u00020$2\u0006\u00107\u001a\u00020$2\b\u00108\u001a\u0004\u0018\u00010\"H\u0016R\u001c\u0010<\u001a\n ;*\u0004\u0018\u00010:0:8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b<\u0010=R#\u0010C\u001a\n ;*\u0004\u0018\u00010>0>8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b?\u0010@\u001a\u0004\bA\u0010BR\u0014\u0010D\u001a\u00020+8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bD\u0010ER\u0016\u0010F\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bF\u0010GR\u0018\u0010H\u001a\u0004\u0018\u00010\u00148\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bH\u0010IR\u0018\u0010J\u001a\u0004\u0018\u00010\u00148\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bJ\u0010I¨\u0006M"}, d2 = {"Lcom/bytedance/android/live/impl/FeatureService;", "Lcom/bytedance/android/live/feature/api/IFeatureService;", "", TextureRenderStrategyInterface.KEY_TRERENDERCONFIG_ASYNCINIT, "Lkotlin/Function0;", "Lcom/bytedance/android/livesdk/log/g;", "liveLoggerSupplier", "", "initService", "addSendLogFilter", "realInit", "addFilter", "addShuffleSequenceInterceptor", "addFeatureInterceptor", "addApplogListener", "addFeatureLogLogicFeatureProvider", "setupLivePortraitCenterService", "init", "Lz90/a;", "getFeatureManager", "", "listener", "setFeatureImListener", "setByteLinkListener", "Lz90/b;", "getFeedFeatureManager", "Lz90/c;", "getLivePortraitCenterService", "Lcom/bytedance/android/livesdkapi/depend/model/live/IRoom;", "room", "handleRoom", "unifyHandleRoom", "", "type", "Lorg/json/JSONObject;", "extraParams", "", "getRealtimeSequenceJson", "getSkipSequenceJson", "Ljava/lang/ref/WeakReference;", "getWeakRoom", "Landroid/os/Bundle;", "bundle", "", "roomId", "onLivePlayActivityCreate", "onLivePlayActivityDestroy", "onDetailModelStartRoom", "onDetailModelStopRoom", "onLiveRoomFragmentCreate", "onLiveRoomFragmentDestroy", "featureServiceHaveInit", "onPreviewVHShow", "roomIndex", "saveUnreadRoomFeature", "enterFromMerge", "featuresInfo", "addShuffleSequenceFeature", "Lcom/bytedance/android/live/feature/config/LiveFeatureConfig;", "kotlin.jvm.PlatformType", "liveFeatureConfig", "Lcom/bytedance/android/live/feature/config/LiveFeatureConfig;", "Lcom/bytedance/android/livesdkapi/model/LiveUnifyBoxConfig;", "unifyBoxConfig$delegate", "Lkotlin/Lazy;", "getUnifyBoxConfig", "()Lcom/bytedance/android/livesdkapi/model/LiveUnifyBoxConfig;", "unifyBoxConfig", DyPayConstant.KEY_START_TIME, "J", "serviceInited", "Z", "featureImListener", "Ljava/lang/Object;", "byteLinkListener", "<init>", "()V", "livefeature-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public class FeatureService implements IFeatureService {
    private Object byteLinkListener;
    private Object featureImListener;
    private final LiveFeatureConfig liveFeatureConfig;
    private volatile boolean serviceInited;
    private final long startTime;
    private final Lazy unifyBoxConfig$delegate;

    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ FeatureService f69027a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Function0 f69028b;

        public a(FeatureService r100, Function0 r101) {
            this.f69027a = r100;
            this.f69028b = r101;
        }

        @Override // java.lang.Runnable
        public final void run() {
            FeatureService.access$addSendLogFilter(this.f69027a, this.f69028b);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ FeatureService f69029a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Function0 f69030b;

        public b(FeatureService r100, Function0 r101) {
            this.f69029a = r100;
            this.f69030b = r101;
        }

        @Override // java.lang.Runnable
        public final void run() {
            FeatureService.access$addSendLogFilter(this.f69029a, this.f69030b);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ FeatureService f69031a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Function0 f69032b;

        public c(FeatureService r100, Function0 r101) {
            this.f69031a = r100;
            this.f69032b = r101;
        }

        @Override // java.lang.Runnable
        public final void run() {
            FeatureService.access$addSendLogFilter(this.f69031a, this.f69032b);     // Catch: Throwable -> L4
            FeatureService.access$realInit(this.f69031a);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    private final LiveUnifyBoxConfig getUnifyBoxConfig() {
        return (LiveUnifyBoxConfig) this.unifyBoxConfig$delegate.getValue();
    }

    private final void addApplogListener() {
        c0 r100 = c0.f497176a;
        if (r100.getValue().getFeatureApplogListenerEnable() == false) goto L12;
        FeatureApplogListener r101 = FeatureApplogListener.f69055b;
        if (r100.getValue().getFeatureApplogListenerEnable() == false) goto L13;
        IMiddleHostService r102 = TTMiddlewareLiveSDK.hostMiddlewareService();
        if (r102 == null) goto L14;
        IMiddlewareHostAction r103 = r102.action();
        if (r103 == null) goto L15;
        r103.addAppLogLiveListener(r101, (Set) FeatureApplogListener.f69054a.getValue());
        return;
    L15:
        return;
    L14:
        return;
    L13:
        return;
    }

    private final void addFeatureInterceptor() {
        if (c0.f497176a.getValue().getFeatureInterceptorEnable() == false) goto L10;
        Integer r100 = com.bytedance.android.live.impl.logInterceptor.a.f69083a;
        IMiddleHostService r101 = TTMiddlewareLiveSDK.hostMiddlewareService();
        if (r101 == null) goto L11;
        IMiddlewareHostAction r102 = r101.action();
        if (r102 == null) goto L12;
        r102.addLiveFeatureInterceptor(com.bytedance.android.live.impl.logInterceptor.a.f69090h);
        return;
    L12:
        return;
    L11:
        return;
    }

    private final void addFeatureLogLogicFeatureProvider() {
        if (c0.f497176a.getValue().getFeatureLogLogicFeatureProviderEnable() == false) goto L10;
        ConcurrentHashMap<String, IMiddlewareHostAction.ILiveLogLogicFeatureProvider> r100 = com.bytedance.android.live.impl.applogListener.a.f69056a;
        IMiddleHostService r101 = TTMiddlewareLiveSDK.hostMiddlewareService();
        if (r101 == null) goto L11;
        IMiddlewareHostAction r102 = r101.action();
        if (r102 == null) goto L12;
        r102.addLogLogicFeatureProviders(com.bytedance.android.live.impl.applogListener.a.f69056a);
        return;
    L12:
        return;
    L11:
        return;
    }

    private final void addFilter() {
        CopyOnWriteArraySet<f> r100 = com.bytedance.android.live.impl.logfilter.c.f69212a;
        com.bytedance.android.live.impl.logfilter.c.a(com.bytedance.android.live.impl.logfilter.b.f69211c);
        com.bytedance.android.live.impl.logfilter.c.a(UserFeatureInRoomFilter.f69201y1);
        com.bytedance.android.live.impl.logfilter.c.a(DeviceFeatureFilter.O);
        com.bytedance.android.live.impl.logfilter.c.a(r.f69234a);
        if (a2.f497166a.getValue().isEnable() == false) goto L6;
        com.bytedance.android.live.impl.logfilter.c.a(RealtimeSequenceFilter.A);
    L6:
        if (n3.f497270a.getValue().a() == false) goto L9;
        com.bytedance.android.live.impl.logfilter.c.a(e.f69220g);
        return;
    }

    private final void addShuffleSequenceInterceptor() {
        if (u2.f497307a.getValue().intValue() <= 0) goto L62;
        ShuffleSequenceInterceptor r100 = ShuffleSequenceInterceptor.f69082l;
        r100.getClass();
        Iterator<String> r101 = ShuffleSequenceInterceptor.f69076f.iterator();
    L6:
        if (r101.hasNext() == false) goto L8;
        String r102 = r101.next();
        ShuffleSequenceInterceptor.f69079i.add(r102);
        goto L6
    L8:
        t2 r103 = t2.f497302a;
        if (r103.getValue().getEnableUploadLiveRevenueFeature() == false) goto L28;
        Map<String, Boolean> r104 = r103.getValue().getLiveRevenueFeaturesMap();
        if (r104 == null) goto L19;
        LinkedHashMap r105 = new LinkedHashMap();
        Iterator<Map.Entry<String, Boolean>> r106 = r104.entrySet().iterator();
    L14:
        if (r106.hasNext() == false) goto L18;
        Map.Entry<String, Boolean> r107 = r106.next();
        if (r107.getValue().booleanValue() == false) goto L14;
        r105.put(r107.getKey(), r107.getValue());
        goto L14
    L18:
        Set r108 = r105.keySet();
    L20:
        if (r108 == null) goto L23;
        List r109 = CollectionsKt.toList(r108);
        if (r109 == null) goto L23;
    L24:
        Iterator r110 = r109.iterator();
    L26:
        if (r110.hasNext() == false) goto L28;
        String r111 = (String) r110.next();
        ShuffleSequenceInterceptor.f69079i.add(r111);
    L23:
        r109 = CollectionsKt.emptyList();
        goto L24
    L19:
        r108 = null;
    L28:
        u2 r112 = u2.f497307a;
        Integer r113 = r112.getValue();
        if (r113 != null) goto L32;
    L33:
        Integer r114 = r112.getValue();
        if (r114 != null) goto L37;
    L43:
        Integer r115 = r112.getValue();
        if (r115 != null) goto L47;
    L48:
        Integer r116 = r112.getValue();
        if (r116 != null) goto L52;
        return;
    L52:
        if (r116.intValue() != 3) goto L78;
    L54:
        Iterator<String> r117 = ShuffleSequenceInterceptor.f69079i.iterator();
    L56:
        if (r117.hasNext() == false) goto L79;
        String r118 = r117.next();
        IMiddleHostService r119 = TTMiddlewareLiveSDK.hostMiddlewareService();
        if (r119 == null) goto L56;
        IMiddlewareHostAction r120 = r119.action();
        if (r120 == null) goto L56;
        r120.addSequenceItemProvider(r118, r100);
        goto L56
    L79:
        return;
    L78:
        return;
    L47:
        if (r115.intValue() == 1) goto L54;
    L37:
        if (r114.intValue() != 2) goto L43;
    L38:
        IMiddleHostService r121 = TTMiddlewareLiveSDK.hostMiddlewareService();
        if (r121 == null) goto L43;
        IMiddlewareHostAction r122 = r121.action();
        if (r122 == null) goto L43;
        r122.addShuffleSequenceProvider(r100);
        goto L43
    L32:
        if (r113.intValue() == 1) goto L38;
    }

    private final void realInit() {
        FeatureManager.f69275u.getClass();
        IUtilsCommonService r100 = (IUtilsCommonService) k.f(IUtilsCommonService.class);
        boolean r101 = false;
        String r102 = null;
        if (r100 == null) goto L5;
        Float r103 = Float.valueOf(r100.deviceScoreHelperGetScore(false));
    L6:
        FeatureManager.q("device_score", r103);
        IUtilsCommonService r104 = (IUtilsCommonService) k.f(IUtilsCommonService.class);
        if (r104 == null) goto L9;
        Float r105 = Float.valueOf(r104.deviceScoreHelperGetScore(true));
    L10:
        FeatureManager.q("anchor_device_score", r105);
        FeatureManager.q("system_version", Integer.valueOf(Build.VERSION.SDK_INT));
        IMiddlewareUserService r106 = (IMiddlewareUserService) k.f(IMiddlewareUserService.class);
        if (r106 == null) goto L17;
        com.bytedance.android.livesdk.user.e r107 = r106.user();
        if (r107 == null) goto L17;
        String r108 = r107.n();
        if (r108 == null) goto L17;
    L18:
        FeatureManager.q("user_id", r108);
        IMiddleWareHostContext r109 = (IMiddleWareHostContext) k.f(IMiddleWareHostContext.class);
        if (r109 == null) goto L23;
        String r110 = r109.getServerDeviceId();
        if (r110 == null) goto L23;
    L24:
        FeatureManager.q("device_id", r110);
        if (PadConfigUtils.c() == false) goto L27;
        int r111 = 2;
    L28:
        FeatureManager.q("device_type", Integer.valueOf(r111));
        FeatureManager.q("last_play_resolution_key", new Property("audience_resolution_last_play_resolution_key", "").getValue());
        String r112 = Build.BRAND;
        Locale r113 = Locale.ROOT;
        if (r112 == null) goto L78;
        FeatureManager.q("device_brand", r112.toLowerCase(r113));
        String r114 = Build.MODEL;
        if (r114 == null) goto L76;
        FeatureManager.q("device_model", r114.toLowerCase(r113));
        Class r115 = FeatureManager.k();     // Catch: Throwable -> L38
        Object r116 = r115.getMethod("getOsBrand", new Class[0]).invoke(r115, new Object[0]);     // Catch: Throwable -> L38
        if (r116 == null) goto L39;
        boolean r117 = StringsKt.equals(RomUtils.OS_HARMONY, r116.toString(), true);     // Catch: Throwable -> L38
    L40:
        FeatureManager.q("is_harmony", Boolean.valueOf(r117));
        IMiddleWareHostContext r118 = (IMiddleWareHostContext) k.f(IMiddleWareHostContext.class);
        if (r118 == null) goto L45;
        String r119 = r118.getChannel();
        if (r119 == null) goto L45;
        r102 = r119.toLowerCase(Locale.ROOT);
    L45:
        FeatureManager.q("app_channel", r102);
        FeatureManager.q("is_in_inner_live", Boolean.FALSE);
        FeatureManager.q("is_fold_device", Boolean.valueOf(FoldScreenUtils.f()));
        FeatureManager.q("fold_type", Integer.valueOf(FoldScreenUtils.a()));
        FeatureManager.q("watch_live_orientation", Boolean.valueOf(e5.l()));
        FeatureManager.q("aweme_live_preview_pcu", 0L);
        IMiddlewareHostBusiness r120 = (IMiddlewareHostBusiness) k.f(IMiddlewareHostBusiness.class);
        if (r120 == null) goto L48;
        boolean r121 = r120.hasCellularPermission();
    L49:
        FeatureManager.q("has_cellular_permission", Boolean.valueOf(r121));
        k0 r122 = FeatureManager.f69271q;
        JSONObject r123 = r122.b("store_features");
        if (r123 == null) goto L53;
        FeatureManager.r("", r123);
    L53:
        IMiddlewareUserService r124 = (IMiddlewareUserService) k.f(IMiddlewareUserService.class);
        if (r124 == null) goto L63;
        com.bytedance.android.livesdk.user.e r125 = r124.user();
        if (r125 == null) goto L63;
        FeatureManager r126 = FeatureManager.f69275u;
        int r127 = !r125.isLogin() ? 1 : 0;
        Handler r128 = UtilityKotlinExtentionsKt.f66103a;
        Integer r129 = Integer.valueOf(r127);
        r126.getClass();
        FeatureManager.q("user_login_status", r129);
        JSONObject r130 = r122.b("user_features");
        if (r130 == null) goto L60;
        FeatureManager.r("user_features", r130);
    L60:
        Flowable<UserEvent> r131 = r125.m().onBackpressureLatest();
        if (r131 == null) goto L63;
        r131.subscribe(com.bytedance.android.live.impl.service.e.f69295a);
    L63:
        c0 r132 = c0.f497176a;
        if (r132.getValue().getFeatureTestEnable() == false) goto L66;
        i0.c().post(FeatureManager.f69273s);
    L66:
        Map<String, Object> r133 = r132.getValue().getTimerUpdateFeatureMap();
        if (r133 != null) goto L69;
    L70:
        r101 = true;
    L71:
        if (r101 == true) goto L73;
        i0.c().postDelayed(FeatureManager.f69274t, 5000);
    L73:
        addFilter();
        addApplogListener();
        addFeatureLogLogicFeatureProvider();
        addFeatureInterceptor();
        setupLivePortraitCenterService();
        addShuffleSequenceInterceptor();
        FeatureManager.f69275u.i("feature_service_init_duration", Long.valueOf(System.currentTimeMillis() - this.startTime), FeatureType.STATIC);
        boolean r134 = com.bytedance.android.live.impl.utils.a.f69317a;
        com.bytedance.android.live.impl.utils.a.d("LFM-FeatureService", new C98881(this));
        return;
    L69:
        if (r133.isEmpty() == false) goto L71;
    L48:
        r121 = false;
    L39:
        r117 = false;
        goto L40
    L76:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
    L78:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
    L27:
        r111 = 1;
    L23:
        r110 = "";
    L17:
        r108 = "";
        goto L18
    L9:
        r105 = null;
        goto L10
    L5:
        r103 = null;
        goto L6
    }

    private final void setupLivePortraitCenterService() {
        c0 r100 = c0.f497176a;
        if (r100.getValue().getPortraitCenterEnable() == true) goto L5;
        return;
    L5:
        if (r100.getValue().getPortraitCenterSetupEnable() == false) goto L9;
        LivePortraitCenterService r101 = LivePortraitCenterService.f69280b;
        LivePortraitCenterService.b();
        return;
    }

    @Override // com.bytedance.android.live.feature.api.IFeatureService
    public z90.c getLivePortraitCenterService() {
        if (c0.f497176a.getValue().getPortraitCenterEnable() == true) goto L5;
        return null;
    L5:
        return LivePortraitCenterService.f69280b;
    }

    @Override // com.bytedance.android.live.feature.api.IFeatureService
    public WeakReference<IRoom> getWeakRoom() {
        WeakReference<IRoom> r100 = RoomService.f69281a;
        return RoomService.f69281a;
    }

    @Override // com.bytedance.android.live.feature.api.IFeatureService
    public void onLiveRoomFragmentDestroy() {
        int r100 = com.bytedance.android.live.impl.service.a.f69291b;
        com.bytedance.android.live.impl.service.a.f69290a--;
        FeatureManager r101 = FeatureManager.f69275u;
        if (com.bytedance.android.live.impl.service.a.f69290a <= 0) goto L5;
        boolean r102 = true;
    L6:
        r101.i("is_in_inner_live", Boolean.valueOf(r102), FeatureType.MONITOR);
        return;
    L5:
        r102 = false;
        goto L6
    }

    public FeatureService() {
        this.liveFeatureConfig = c0.f497176a.getValue();
        this.unifyBoxConfig$delegate = LazyKt.lazy(FeatureService$unifyBoxConfig$2.INSTANCE);
        this.startTime = System.currentTimeMillis();
        if (k.h(IFeatureService.class) == true) goto L6;
        k.l(IFeatureService.class, this);
        return;
    }

    @Override // com.bytedance.android.live.feature.api.IFeatureService
    public String getSkipSequenceJson() {
        return SkipSequenceHelper.b();
    }

    @Override // com.bytedance.android.live.feature.api.IFeatureService
    public boolean featureServiceHaveInit() {
        return this.serviceInited;
    }

    @Override // com.bytedance.android.live.feature.api.IFeatureService
    public z90.a getFeatureManager() {
        return FeatureManager.f69275u;
    }

    @Override // com.bytedance.android.live.feature.api.IFeatureService
    public z90.b getFeedFeatureManager() {
        return FeedFeatureManager.f69278c;
    }

    public static final /* synthetic */ LiveFeatureConfig access$getLiveFeatureConfig$p(FeatureService r100) {
        return r100.liveFeatureConfig;
    }

    public static final /* synthetic */ long access$getStartTime$p(FeatureService r100) {
        return r100.startTime;
    }

    public static final /* synthetic */ void access$realInit(FeatureService r100) {
        r100.realInit();
    }

    private final void addSendLogFilter(Function0<? extends g> r100) {
        final boolean r101 = r100.invoke().addSendLogFilter("LFM-FeatureService", com.bytedance.android.live.impl.logfilter.c.f69213b);
        boolean r102 = com.bytedance.android.live.impl.utils.a.f69317a;
        com.bytedance.android.live.impl.utils.a.a("LFM-FeatureService", new AnonymousClass1(r101));
    }

    @Override // com.bytedance.android.live.feature.api.IFeatureService
    public void handleRoom(IRoom r100) {
        if (getUnifyBoxConfig().getHandleRoomMove() == true) goto L5;
    L6:
        RoomService.c(r100);
        return;
    L5:
        if (LiveUnifyBoxConfig.Companion.getUnifyServiceInit() == false) goto L6;
    }

    @Override // com.bytedance.android.live.feature.api.IFeatureService
    public void onLiveRoomFragmentCreate(Bundle r100) {
        int r101 = com.bytedance.android.live.impl.service.a.f69291b;
        com.bytedance.android.live.impl.service.a.f69290a++;
        FeatureManager r102 = FeatureManager.f69275u;
        if (com.bytedance.android.live.impl.service.a.f69290a <= 0) goto L5;
        boolean r103 = true;
    L6:
        r102.i("is_in_inner_live", Boolean.valueOf(r103), FeatureType.MONITOR);
        return;
    L5:
        r103 = false;
        goto L6
    }

    @Override // com.bytedance.android.live.feature.api.IFeatureService
    public void onPreviewVHShow(IRoom r100) {
        if (n3.f497270a.getValue().a() == false) goto L6;
        e.f69220g.getClass();
        e.f69219f = r100;
        return;
    }

    @Override // com.bytedance.android.live.feature.api.IFeatureService
    public void setByteLinkListener(Object r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        this.byteLinkListener = r100;
    }

    @Override // com.bytedance.android.live.feature.api.IFeatureService
    public void setFeatureImListener(Object r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        this.featureImListener = r100;
    }

    @Override // com.bytedance.android.live.feature.api.IFeatureService
    public void unifyHandleRoom(IRoom r100) {
        RoomService.c(r100);
    }

    public static final /* synthetic */ void access$addSendLogFilter(FeatureService r100, Function0 r101) {
        r100.addSendLogFilter(r101);
    }

    private final void initService(final boolean r100, Function0<? extends g> r101) {
        if (this.serviceInited == false) goto L5;
        return;
    L5:
        this.serviceInited = true;
        if (r100 == false) goto L8;
        addSendLogFilter(r101);
        realInit();
    L20:
        boolean r102 = com.bytedance.android.live.impl.utils.a.f69317a;
        com.bytedance.android.live.impl.utils.a.d("LFM-FeatureService", new AnonymousClass4(this, r100));
        return;
    L8:
        int r103 = this.liveFeatureConfig.getInitType();
        if (r103 == 0) goto L19;
        if (r103 != 1) goto L12;
        i0.c().postDelayed(new b(this, r101), 1000);
        realInit();
        goto L20
    L12:
        if (r103 != 2) goto L14;
        addSendLogFilter(r101);
        realInit();
        goto L20
    L14:
        if (r103 != 3) goto L20;
        TTExecutors.getSerialThreadPool().submit(new c(this, r101));
        goto L20
    L19:
        i0.c().post(new a(this, r101));
        realInit();
        goto L20
    }

    @Override // com.bytedance.android.live.feature.api.IFeatureService
    public String getRealtimeSequenceJson(int r100, JSONObject r101) {
        return RealtimeSequenceFilter.A.c(r100, r101);
    }

    @Override // com.bytedance.android.live.feature.api.IFeatureService
    public void init(boolean r100, Function0<? extends g> r101) {
        Intrinsics.checkNotNullParameter(r101, "liveLoggerSupplier");
        initService(r100, r101);
    }

    @Override // com.bytedance.android.live.feature.api.IFeatureService
    public void onDetailModelStartRoom(Bundle r100, long r101) {
        e.f69220g.getClass();
        e.f69218e = r101;
        e.f69219f = null;
        e.f69216c.add(new LimitSizeQueue(e.f69215b.d()));
    }

    @Override // com.bytedance.android.live.feature.api.IFeatureService
    public void onDetailModelStopRoom(Bundle r100, long r101) {
        e.f69220g.getClass();
    }

    @Override // com.bytedance.android.live.feature.api.IFeatureService
    public void onLivePlayActivityCreate(Bundle r100, long r101) {
        int r102 = com.bytedance.android.live.impl.service.a.f69291b;
        if (n3.f497270a.getValue().a() == false) goto L6;
        e.f69220g.getClass();
        e.f69218e = r101;
        e.f69219f = null;
        e.f69216c.add(new LimitSizeQueue(e.f69215b.d()));
        return;
    }

    @Override // com.bytedance.android.live.feature.api.IFeatureService
    public void onLivePlayActivityDestroy(Bundle r100, long r101) {
        int r102 = com.bytedance.android.live.impl.service.a.f69291b;
        if (n3.f497270a.getValue().a() == false) goto L6;
        e.f69220g.getClass();
        e.f69217d.clear();
        FeatureManager.f69275u.g("live_selected_position");
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v0, types: [java.lang.Object, org.json.JSONObject] */
    /* JADX WARN: Type inference failed for: r8v0 */
    /* JADX WARN: Type inference failed for: r8v1, types: [int] */
    /* JADX WARN: Type inference failed for: r8v3 */
    @Override // com.bytedance.android.live.feature.api.IFeatureService
    public void saveUnreadRoomFeature(IRoom r110, int r111) {
        Intrinsics.checkNotNullParameter(r110, "room");
        if (n3.f497270a.getValue().a() == false) goto L53;
        e.f69220g.getClass();
        Intrinsics.checkNotNullParameter(r110, "room");
        LongSparseArray r100 = (LongSparseArray) FeatureManager.f69275u.getFeature("live_room_type", new LongSparseArray());     // Catch: Exception -> L48
        ConcurrentHashMap<Long, JSONObject> r101 = e.f69217d;     // Catch: Exception -> L48
        Long r102 = Long.valueOf(r110.getRoomId());     // Catch: Exception -> L48
        ?? r103 = new JSONObject();     // Catch: Exception -> L48
        r103.put("room_id", r110.getId());     // Catch: Exception -> L48
        r103.put("room_user_count", r110.getUserCount());     // Catch: Exception -> L48
        IRoomStats r104 = r110.getStats();     // Catch: Exception -> L48
        ?? r105 = 0;
        if (r104 == null) goto L8;
        int r106 = r104.getTotalUser();     // Catch: Exception -> L48
    L9:
        r103.put("room_total_user_count", r106);     // Catch: Exception -> L48
        IBaseUser r107 = r110.getOwner();     // Catch: Exception -> L48
        long r108 = 0;
        if (r107 == null) goto L14;
        j r109 = r107.getFollowInfo();     // Catch: Exception -> L48
        if (r109 == null) goto L14;
        long r112 = r109.getFollowStatus();     // Catch: Exception -> L48
    L15:
        r103.put("follow_status", r112);     // Catch: Exception -> L48
        String r113 = (String) r100.get(r110.getRoomId());     // Catch: Exception -> L48
        if (r113 == null) goto L19;
        List r114 = StringsKt.split$default(r113, new String[]{","}, false, 0, 6, null);     // Catch: Exception -> L48
        if (r114 == null) goto L19;
    L20:
        r103.putOpt("room_tags", new JSONArray(r114));     // Catch: Exception -> L48
        r103.put("live_room_type", e.h(r110));     // Catch: Exception -> L48
        String r115 = r110.getItemExplicitInfo();     // Catch: Exception -> L48
        String r116 = "";
        if (r115 != null) goto L24;
        r115 = "";
    L24:
        r103.put(ILiveRoomPlayFragmentConstant.EXTRA_LIVE_RECOMMEND_INFO, r115);     // Catch: Exception -> L48
        r103.put("room_position", r111);     // Catch: Exception -> L48
        r103.put("live_mode", r110.getStreamType().ordinal());     // Catch: Exception -> L48
        IBaseUser r117 = r110.getOwner();     // Catch: Exception -> L48
        if (r117 == null) goto L29;
        j r118 = r117.getFollowInfo();     // Catch: Exception -> L48
        if (r118 == null) goto L29;
        long r119 = r118.getFollowerCount();     // Catch: Exception -> L48
    L30:
        r103.put("anchor_fans_count", r119);     // Catch: Exception -> L48
        IBaseUser r120 = r110.getOwner();     // Catch: Exception -> L48
        if (r120 == null) goto L35;
        j r121 = r120.getFollowInfo();     // Catch: Exception -> L48
        if (r121 == null) goto L35;
        r108 = r121.getFollowingCount();     // Catch: Exception -> L48
    L35:
        r103.put("anchor_follow_count", r108);     // Catch: Exception -> L48
        IBaseUser r122 = r110.getOwner();     // Catch: Exception -> L48
        if (r122 == null) goto L38;
        int r123 = r122.getGender();     // Catch: Exception -> L48
    L39:
        r103.put("anchor_gender", r123);     // Catch: Exception -> L48
        String r124 = r110.getAnchorId();     // Catch: Exception -> L48
        if (r124 == null) goto L43;
        r116 = r124;
    L43:
        r103.put("anchor_id", r116);     // Catch: Exception -> L48
        com.bytedance.android.livesdk.strategy.a r125 = r110.getAdStrategyFeatures();     // Catch: Exception -> L48
        if (r125 == null) goto L46;
        boolean r126 = r125.a();     // Catch: Exception -> L48
        Handler r127 = UtilityKotlinExtentionsKt.f66103a;     // Catch: Exception -> L48
        r105 = r126;
    L46:
        r103.put("live_is_ad", r105);     // Catch: Exception -> L48
        Unit r128 = Unit.INSTANCE;     // Catch: Exception -> L48
        r101.put(r102, (JSONObject) r103);     // Catch: Exception -> L48
        return;
    L38:
        r123 = 0;
    L29:
        r119 = 0;
    L19:
        r114 = CollectionsKt.emptyList();     // Catch: Exception -> L48
    L14:
        r112 = 0;
        goto L15
    L8:
        r106 = 0;
    L48:
        e = move-exception;
        ALogger.e("LiveTabGuideFeatureFilter", String.valueOf(e));
        return;
    }

    @Override // com.bytedance.android.live.feature.api.IFeatureService
    public void addShuffleSequenceFeature(String r100, String r101, JSONObject r102) {
        Intrinsics.checkNotNullParameter(r100, "roomId");
        Intrinsics.checkNotNullParameter(r101, "enterFromMerge");
        ShuffleSequenceInterceptor.f69082l.getClass();
        Intrinsics.checkNotNullParameter(r100, "roomId");
        Intrinsics.checkNotNullParameter(r101, "enterFromMerge");
        Pair r103 = new Pair(r100, r101);
        HashMap r104 = (HashMap) ShuffleSequenceInterceptor.f69071a;
        if (r104.containsKey(r103) == true) goto L5;
        r104.put(r103, new LinkedHashMap());
    L5:
        Map r105 = (Map) r104.get(r103);
        if (r102 == null) goto L13;
        Iterator<String> r106 = r102.keys();
    L9:
        if (r106.hasNext() == false) goto L19;
        String r107 = r106.next();
        if (r105 == null) goto L9;
        r105.put(r107, r102.get(r107));
        goto L9
    L19:
        return;
    }
}
