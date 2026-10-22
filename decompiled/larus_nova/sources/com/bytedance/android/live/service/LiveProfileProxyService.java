package com.bytedance.android.live.service;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.android.live.openplatform.api.model.datacontext.MiniAppDataContext;
import com.bytedance.android.live.platformplayer.LivePlatformPlayerManager;
import com.bytedance.android.live.profile.api.service.ILiveProfileProxyService;
import com.bytedance.android.livesdk.test.network.TestHttpClient;
import com.bytedance.android.livesdkapi.business.IHsLiveAdMocService;
import com.bytedance.android.livesdkapi.model.PlayerExtraRenderInfo;
import com.bytedance.android.livesdkapi.model.RenderDescInfo;
import com.bytedance.android.livesdkapi.roomplayer.ILivePlayerClient;
import com.bytedance.android.livesdkapi.roomplayer.ILivePlayerExtraRenderController;
import com.bytedance.retrofit2.Retrofit;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import mv0.b0;
import mv0.c;
import mv0.c0;
import mv0.e0;
import mv0.g;
import mv0.h;
import mv0.i;
import mv0.k;
import mv0.l;
import mv0.n;
import mv0.o;
import mv0.s;
import mv0.t;
import mv0.u;
import qs0.d;
import qs0.e;
import qs0.f;
import qs0.j;
import qs0.m;
import qs0.q;
import qs0.r;
import qs0.v;
import qs0.w;
import qs0.x;
import zg1.h1;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000Ä\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010$\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b\u0017\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\bH\u0010IJ)\u0010\u0006\u001a\u0004\u0018\u00018\u0000\"\b\b\u0000\u0010\u0003*\u00020\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\t\u001a\u00020\bH\u0016J\b\u0010\u000b\u001a\u00020\nH\u0016J\b\u0010\r\u001a\u00020\fH\u0016J\b\u0010\u000f\u001a\u00020\u000eH\u0016J\b\u0010\u0011\u001a\u00020\u0010H\u0016J\b\u0010\u0013\u001a\u00020\u0012H\u0016J\b\u0010\u0015\u001a\u00020\u0014H\u0016J\b\u0010\u0017\u001a\u00020\u0016H\u0016J\b\u0010\u0019\u001a\u00020\u0018H\u0016J\b\u0010\u001b\u001a\u00020\u001aH\u0016J\b\u0010\u001d\u001a\u00020\u001cH\u0016J\b\u0010\u001f\u001a\u00020\u001eH\u0016J\b\u0010!\u001a\u00020 H\u0016J\n\u0010#\u001a\u0004\u0018\u00010\"H\u0016J8\u0010+\u001a\u00020*2\u0006\u0010%\u001a\u00020$2\u0006\u0010&\u001a\u00020\"2\u0006\u0010'\u001a\u00020\"2\u0016\u0010)\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\"\u0012\u0006\u0012\u0004\u0018\u00010\"0(H\u0016J\b\u0010-\u001a\u00020,H\u0016J\b\u0010/\u001a\u00020.H\u0016J\b\u00101\u001a\u000200H\u0016J\b\u00103\u001a\u000202H\u0016J\b\u00105\u001a\u000204H\u0016J\b\u00107\u001a\u000206H\u0016J\b\u00109\u001a\u000208H\u0016J\u0016\u0010=\u001a\u00020<2\f\u0010;\u001a\b\u0012\u0004\u0012\u00020*0:H\u0016J\b\u0010>\u001a\u00020$H\u0016J\b\u0010@\u001a\u00020?H\u0016J\n\u0010B\u001a\u0004\u0018\u00010AH\u0016R\u001d\u0010G\u001a\u0004\u0018\u00010A8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bC\u0010D\u001a\u0004\bE\u0010F¨\u0006J"}, d2 = {"Lcom/bytedance/android/live/service/LiveProfileProxyService;", "Lcom/bytedance/android/live/profile/api/service/ILiveProfileProxyService;", "", ExifInterface.GPS_DIRECTION_TRUE, "Ljava/lang/Class;", "clz", "getTestHttpClientService", "(Ljava/lang/Class;)Ljava/lang/Object;", "Lqs0/u;", "getIPkAudienceLinkOutServiceProxy", "Lqs0/i;", "getIInteractService", "Lqs0/v;", "getRoomServiceProxy", "Lqs0/o;", "getLiveSdkLogUtil", "Lqs0/s;", "getIMicRoomService", "Lqs0/x;", "getVrUtils", "Lqs0/k;", "getLinkPlayerState", "Lqs0/n;", "getLiveRoomEventParamUtils", "Lqs0/q;", "getILiveVideoFloatWindowService", "Lqs0/m;", "getILiveOntologyInfoManager", "Lqs0/r;", "getIMediaLinkOutService", "Lqs0/d;", "getIBroadcastService", "Lqs0/l;", "getLiveCommonConstants", "", "getPlayerUgcRoomUser", "", "isV1", "event", "label", "", "extra", "", "hsLiveAdMocServiceLogEvent", "Lqs0/b;", "getAudienceGameContext", "Lqs0/f;", "getIHostGameCP", "Lqs0/h;", "getInteractLogUtils", "Lqs0/c;", "getBackToRoomDataUtils", "Lqs0/j;", "getIKtvService", "Lqs0/e;", "getIHostCommerceServiceLive", "Lqs0/g;", "getIHostLiveLocalLife", "Lkotlin/Function0;", "action", "Lio/reactivex/disposables/Disposable;", "registerLiveEventEnd", "isShelfInfoNotNull", "Lqs0/t;", "getMultiAnchorOutService", "Lqs0/w;", "getSaaSAdapterService", "saaSAdapterServiceCache$delegate", "Lkotlin/Lazy;", "getSaaSAdapterServiceCache", "()Lqs0/w;", "saaSAdapterServiceCache", "<init>", "()V", "experience-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public class LiveProfileProxyService implements ILiveProfileProxyService {
    private final Lazy saaSAdapterServiceCache$delegate;

    public static final class a<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function0 f100854a;

        public a(Function0 r100) {
            this.f100854a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            if (((h1) r100).f571836a != 7) goto L6;
            this.f100854a.invoke();
            return;
        }
    }

    private final w getSaaSAdapterServiceCache() {
        return (w) this.saaSAdapterServiceCache$delegate.getValue();
    }

    @Override // com.bytedance.android.live.profile.api.service.ILiveProfileProxyService
    public qs0.b getAudienceGameContext() {
        return new mv0.a();
    }

    @Override // com.bytedance.android.live.profile.api.service.ILiveProfileProxyService
    public d getIBroadcastService() {
        return new c();
    }

    @Override // com.bytedance.android.live.profile.api.service.ILiveProfileProxyService
    public e getIHostCommerceServiceLive() {
        return new g();
    }

    @Override // com.bytedance.android.live.profile.api.service.ILiveProfileProxyService
    public f getIHostGameCP() {
        return new h();
    }

    @Override // com.bytedance.android.live.profile.api.service.ILiveProfileProxyService
    public qs0.g getIHostLiveLocalLife() {
        return new i();
    }

    @Override // com.bytedance.android.live.profile.api.service.ILiveProfileProxyService
    public qs0.i getIInteractService() {
        return new k();
    }

    @Override // com.bytedance.android.live.profile.api.service.ILiveProfileProxyService
    public j getIKtvService() {
        return new l();
    }

    @Override // com.bytedance.android.live.profile.api.service.ILiveProfileProxyService
    public m getILiveOntologyInfoManager() {
        return new o();
    }

    @Override // com.bytedance.android.live.profile.api.service.ILiveProfileProxyService
    public q getILiveVideoFloatWindowService() {
        return new s();
    }

    @Override // com.bytedance.android.live.profile.api.service.ILiveProfileProxyService
    public r getIMediaLinkOutService() {
        return new t();
    }

    @Override // com.bytedance.android.live.profile.api.service.ILiveProfileProxyService
    public qs0.s getIMicRoomService() {
        return new u();
    }

    @Override // com.bytedance.android.live.profile.api.service.ILiveProfileProxyService
    public qs0.u getIPkAudienceLinkOutServiceProxy() {
        return new b0();
    }

    @Override // com.bytedance.android.live.profile.api.service.ILiveProfileProxyService
    public qs0.k getLinkPlayerState() {
        return new mv0.m();
    }

    @Override // com.bytedance.android.live.profile.api.service.ILiveProfileProxyService
    public qs0.o getLiveSdkLogUtil() {
        return new mv0.r();
    }

    @Override // com.bytedance.android.live.profile.api.service.ILiveProfileProxyService
    public qs0.t getMultiAnchorOutService() {
        return new mv0.w();
    }

    @Override // com.bytedance.android.live.profile.api.service.ILiveProfileProxyService
    public v getRoomServiceProxy() {
        return new c0();
    }

    @Override // com.bytedance.android.live.profile.api.service.ILiveProfileProxyService
    public x getVrUtils() {
        return new e0();
    }

    @Override // com.bytedance.android.live.profile.api.service.ILiveProfileProxyService
    public boolean isShelfInfoNotNull() {
        MiniAppDataContext.Companion.getClass();
        if (MiniAppDataContext.a.b() == null) goto L5;
        return true;
    L5:
        return false;
    }

    public LiveProfileProxyService() {
        this.saaSAdapterServiceCache$delegate = LazyKt.lazy(LiveProfileProxyService$saaSAdapterServiceCache$2.INSTANCE);
    }

    @Override // com.bytedance.android.live.profile.api.service.ILiveProfileProxyService
    public String getPlayerUgcRoomUser() {
        as0.a r100 = LivePlatformPlayerManager.b();
        if (r100 == null) goto L13;
        ILivePlayerClient r101 = r100.player();
        if (r101 == null) goto L13;
        ILivePlayerExtraRenderController r102 = r101.extraRenderController();
        if (r102 == null) goto L13;
        PlayerExtraRenderInfo r103 = r102.renderInfo();
        if (r103 == null) goto L13;
        RenderDescInfo r104 = r103.getDescInfo();
        if (r104 == null) goto L13;
        return r104.getUserId();
    L13:
        return null;
    }

    @Override // com.bytedance.android.live.profile.api.service.ILiveProfileProxyService
    public w getSaaSAdapterService() {
        return getSaaSAdapterServiceCache();
    }

    @Override // com.bytedance.android.live.profile.api.service.ILiveProfileProxyService
    public qs0.c getBackToRoomDataUtils() {
        return mv0.b.f515817a;
    }

    @Override // com.bytedance.android.live.profile.api.service.ILiveProfileProxyService
    public qs0.h getInteractLogUtils() {
        return mv0.j.f515823a;
    }

    @Override // com.bytedance.android.live.profile.api.service.ILiveProfileProxyService
    public qs0.l getLiveCommonConstants() {
        return n.f515824a;
    }

    @Override // com.bytedance.android.live.profile.api.service.ILiveProfileProxyService
    public qs0.n getLiveRoomEventParamUtils() {
        return mv0.q.f515826a;
    }

    @Override // com.bytedance.android.live.profile.api.service.ILiveProfileProxyService
    public <T> T getTestHttpClientService(Class<T> r100) {
        Intrinsics.checkNotNullParameter(r100, "clz");
        Lazy r101 = TestHttpClient.f158512a;
        Intrinsics.checkNotNullParameter(r100, "clz");
        Lazy r102 = TestHttpClient.f158512a;
        if (((ConcurrentHashMap) r102.getValue()).contains(r100) == true) goto L9;
        Retrofit r103 = (Retrofit) TestHttpClient.f158514c.getValue();
        if (r103 == null) goto L9;
        Object r104 = r103.create(r100);
        if (r104 == null) goto L9;
        ((ConcurrentHashMap) r102.getValue()).putIfAbsent(r100, r104);
    L9:
        T r105 = (T) ((ConcurrentHashMap) r102.getValue()).get(r100);
        if ((r105 instanceof Object) == true) goto L12;
        r105 = null;
    L12:
        if (r105 == null) goto L14;
        return r105;
    L14:
        return (T) com.bytedance.android.live.network.c.b().e(r100);
    }

    @Override // com.bytedance.android.live.profile.api.service.ILiveProfileProxyService
    public Disposable registerLiveEventEnd(Function0<Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "action");
        return xs2.b.a().b(h1.class).observeOn(AndroidSchedulers.mainThread()).subscribe(new a(r100));
    }

    @Override // com.bytedance.android.live.profile.api.service.ILiveProfileProxyService
    public void hsLiveAdMocServiceLogEvent(boolean r100, String r101, String r102, Map<String, String> r103) {
        Intrinsics.checkNotNullParameter(r101, "event");
        Intrinsics.checkNotNullParameter(r102, "label");
        Intrinsics.checkNotNullParameter(r103, "extra");
        LinkedHashMap r104 = new LinkedHashMap();
        Iterator<Map.Entry<String, String>> r105 = r103.entrySet().iterator();
    L4:
        if (r105.hasNext() == false) goto L9;
        Map.Entry<String, String> r106 = r105.next();
        String r107 = r106.getKey();
        String r108 = r106.getValue();
        if (r107 == null) goto L4;
        if (r108 == null) goto L4;
        r104.put(r107, r108);
        goto L4
    L9:
        ((IHsLiveAdMocService) jc1.k.n(IHsLiveAdMocService.class)).logEvent(r100, r101, r102, r104);
    }
}
