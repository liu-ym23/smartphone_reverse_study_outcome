package com.bytedance.android.livesdk.banner;

import am2.x;
import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.OnLifecycleEvent;
import com.bytedance.android.live.base.model.message.i1;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.browser.IBaseBrowserService;
import com.bytedance.android.live.core.activity.BannerFullMonitor;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.monitor.BaseMonitor;
import com.bytedance.android.live.core.monitor.LiveTracingMonitor;
import com.bytedance.android.live.core.setting.LiveInfraSettingKeys;
import com.bytedance.android.live.core.setting.j2;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.rxutils.autodispose.AutoDispose;
import com.bytedance.android.live.core.utils.rxutils.autodispose.ObservableSubscribeProxy;
import com.bytedance.android.live.network.response.Response;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livesdk.api.IRoomModuleService;
import com.bytedance.android.livesdk.chatroom.api.IBannerServiceApi;
import com.bytedance.android.livesdk.chatroom.model.BannerInRoomCollection;
import com.bytedance.android.livesdk.chatroom.o;
import com.bytedance.android.livesdk.chatroom.r;
import com.bytedance.android.livesdk.chatroom.room.backend.g;
import com.bytedance.android.livesdk.chatroom.room.backend.i;
import com.bytedance.android.livesdk.gift.model.b1;
import com.bytedance.android.livesdk.interactivity.api.entity.k;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdk.schema.interfaces.IBaseLiveActionHandler;
import com.bytedance.android.livesdk.utils.r0;
import com.bytedance.android.livesdkapi.LiveCommonConstants;
import com.bytedance.android.livesdkapi.banner.BannerData;
import com.bytedance.android.livesdkapi.banner.IBannerManager;
import com.bytedance.android.livesdkapi.depend.message.MessageType;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.util.url.UrlBuilder;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.bytedance.live.datacontext.j;
import com.bytedance.live.datacontext.m;
import com.bytedance.live.datacontext.n;
import com.bytedance.mt.protector.impl.UriProtector;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Predicate;
import io.reactivex.subjects.BehaviorSubject;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import vlc.l;
import zg1.i2;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003:\u0001\u0007J\b\u0010\u0005\u001a\u00020\u0004H\u0007J\b\u0010\u0006\u001a\u00020\u0004H\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/android/livesdk/banner/InRoomBannerManager;", "Landroidx/lifecycle/LifecycleObserver;", "Lvlc/l;", "Lcom/bytedance/android/livesdkapi/banner/IBannerManager;", "", WidgetCostModule.TYPE_ON_CREATE, LiveCommonConstants.REASON_ON_DEDTROY, BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "livedynamic_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class InRoomBannerManager implements LifecycleObserver, l, IBannerManager {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final /* synthetic */ int f104248g = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f104249a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f104250b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final BehaviorSubject<BannerData> f104251c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public LifecycleOwner f104252d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f104253e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Disposable f104254f;

    public static final class a {
    }

    public static final class b<T> implements Predicate {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Long f104255a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f104256b;

        public b(Long r100, int r101) {
            this.f104255a = r100;
            this.f104256b = r101;
        }

        @Override // io.reactivex.functions.Predicate
        public final boolean test(Object r100) {
            BannerData r101 = (BannerData) r100;
            Intrinsics.checkNotNullParameter(r101, "data");
            long r102 = r101.getRoomId();
            Long r103 = this.f104255a;
            if (r103 != null) goto L6;
            return false;
        L6:
            if (r102 != r103.longValue()) goto L23;
            int r104 = this.f104256b;
            int r105 = r101.getPosition();
            int r106 = so1.b.f542701a;
            if (r104 != 0) goto L10;
            boolean r107 = true;
        L11:
            if (r107 == true) goto L19;
            if (r105 != 0) goto L14;
            boolean r108 = true;
        L15:
            if (r108 == true) goto L19;
            if (r104 == r105) goto L19;
            boolean r109 = false;
        L20:
            if (r109 == false) goto L24;
            return true;
        L24:
            return false;
        L14:
            r108 = false;
        L19:
            r109 = true;
            goto L20
        L10:
            r107 = false;
            goto L11
        L23:
            return false;
        }
    }

    public static final class c<T> implements Consumer {
        public c(InRoomBannerManager r100) {
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            ((if1.a) r100).getClass();
            ALogger.i("LiveByteSync", "receive banner refresh event, max delay: 0");
        }
    }

    public static final class d<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ InRoomBannerManager f104257a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ tlc.d f104258b;

        public d(InRoomBannerManager r100, tlc.d r101) {
            this.f104257a = r100;
            this.f104258b = r101;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            Integer r101 = (Integer) r100;
            InRoomBannerManager r102 = this.f104257a;
            long r103 = r102.f104249a;
            boolean r104 = r102.f104250b;
            int r105 = ((i1) this.f104258b).getPosition();
            um0.a r106 = om0.c.i();
            if (r106 == null) goto L6;
            IBannerServiceApi r107 = (IBannerServiceApi) r106.getService(IBannerServiceApi.class);
            if (r107 == null) goto L6;
        L7:
            if (r104 == false) goto L9;
            int r108 = 2;
        L10:
            ((ObservableSubscribeProxy) r107.queryLiveRoomBanner(r103, r108, r102.f104253e).compose(RxUtil.rxSchedulerHelper()).as(AutoDispose.bind(r102.f104252d))).subscribe(new com.bytedance.android.livesdk.banner.a(r102, r103, r105), new com.bytedance.android.livesdk.banner.b(r102, r105, r103));
            return;
        L9:
            r108 = 1;
        L6:
            r107 = (IBannerServiceApi) com.bytedance.android.live.network.c.b().e(IBannerServiceApi.class);
            goto L7
        }
    }

    public static final class e<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ InRoomBannerManager f104259a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ long f104260b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ int f104261c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ boolean f104262d;

        public e(InRoomBannerManager r100, long r101, int r102, boolean r103) {
            this.f104259a = r100;
            this.f104260b = r101;
            this.f104261c = r102;
            this.f104262d = r103;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            Response r101 = (Response) r100;
            this.f104259a.f104251c.onNext(new BannerData(r101.logId, this.f104260b, (BannerInRoomCollection) r101.data, this.f104261c));
            if (this.f104262d == false) goto L6;
            InRoomBannerManager.a(this.f104259a, this.f104260b);
            return;
        }
    }

    public static final class f<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ InRoomBannerManager f104263a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f104264b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ long f104265c;

        public f(InRoomBannerManager r100, int r101, long r102) {
            this.f104263a = r100;
            this.f104264b = r101;
            this.f104265c = r102;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            Throwable r101 = (Throwable) r100;
            int r102 = InRoomBannerManager.f104248g;
            ALogger.e("InRoomBannerManager", r101);
            InRoomBannerManager.b(this.f104263a, this.f104264b, this.f104265c, r101);
        }
    }

    static {
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    public final void onCreate() {
        vlc.d r100 = null;
        r r101 = z51.a.c(null, this.f104249a);
        if (r101 == null) goto L7;
        j<vlc.d> r102 = r101.getMessageManager();
        if (r102 == null) goto L7;
        r100 = r102.getValue();
    L7:
        if (r100 == null) goto L9;
        r100.addMessageListener(MessageType.IN_ROOM_BANNER_REFRESH_MESSAGE.getWsMethod(), this);
    L9:
        ALogger.i("LiveByteSync", "register rx bus");
        this.f104254f = xs2.b.a().b(if1.a.class).subscribe(new c(this));
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public final void onDestroy() {
        r r100 = z51.a.c(null, this.f104249a);
        if (r100 == null) goto L7;
        j<vlc.d> r101 = r100.getMessageManager();
        if (r101 == null) goto L7;
        vlc.d r102 = r101.getValue();
    L8:
        if (r102 == null) goto L10;
        r102.removeMessageListener(this);
    L10:
        this.f104252d = null;
        ALogger.i("LiveByteSync", "unregister rx bus");
        Disposable r103 = this.f104254f;
        if (r103 == null) goto L13;
        r103.dispose();
    L13:
        this.f104254f = null;
        return;
    L7:
        r102 = null;
        goto L8
    }

    public InRoomBannerManager(LifecycleOwner r100) {
        Intrinsics.checkNotNullParameter(r100, "lifecycleOwner");
        this.f104249a = -1;
        this.f104251c = BehaviorSubject.create();
        this.f104252d = r100;
        r100.getLifecycle().addObserver(this);
    }

    @Override // vlc.l
    public final void onMessage(tlc.d r100) {
        if (r100 == null) goto L4;
        String r101 = r100.getMessageMethod();
    L6:
        if (TextUtils.equals(r101, k.f133172a) == true) goto L8;
        return;
    L8:
        if ((r100 instanceof i1) == false) goto L15;
        i1 r102 = (i1) r100;
        if (r102.E() > 0) goto L12;
        return;
    L12:
        ((ObservableSubscribeProxy) Observable.just(1).delay(new Random().nextInt((int) r102.E()), TimeUnit.SECONDS).observeOn(AndroidSchedulers.mainThread()).subscribeOn(AndroidSchedulers.mainThread()).doOnNext(new d(this, r100)).as(AutoDispose.bind(this.f104252d))).subscribe();
        return;
    L15:
        return;
    L4:
        r101 = null;
        goto L6
    }

    public static final void a(InRoomBannerManager r100, long r101) {
        r100.getClass();
        if (j2.f65330a.getValue().disable_backend_monitor == true) goto L19;
        o r102 = z51.a.f(null, r101);
        if (r102 == null) goto L15;
        m<Long> r103 = r102.I2();
        if (r103 == null) goto L16;
        Long r104 = r103.getValue();
        if (r104 == null) goto L17;
        long r105 = r104.longValue();
        if (r105 <= 0) goto L18;
        j0.l().sendLog("livesdk_backend_banner_monitor", MapsKt.mapOf(TuplesKt.to("user_time_from_enter", String.valueOf(System.currentTimeMillis() - r105))), new Object[]{IRoom.class, x.class});
        return;
    L18:
        return;
    L17:
        return;
    L16:
        return;
    L15:
        return;
    }

    @Override // com.bytedance.android.livesdkapi.banner.IBannerManager
    public final void bannerClick(Context r100, b1 r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "banner");
        int r102 = r101.getActionType();
        if (r102 != 1) goto L5;
        UrlBuilder r103 = new UrlBuilder(r101.getSchemaUrl());
        r103.addParam("title", r101.getTitle());
        Uri r104 = UriProtector.parse(r103.build());
        ((IBaseLiveActionHandler) jc1.k.n(IBaseLiveActionHandler.class)).handle(r100, r104);
        return;
    L5:
        if (r102 != 2) goto L7;
        UrlBuilder r105 = new UrlBuilder(r101.getSchemaUrl());
        com.bytedance.android.livesdk.user.e r106 = ((IMiddlewareUserService) jc1.k.n(IMiddlewareUserService.class)).user();
        if (r106 == null) goto L15;
        IBaseUser r107 = r106.b();
        if (r107 == null) goto L15;
        r105.addParam("is_first_consume", String.valueOf(r0.a(r107)));
    L15:
        xs2.b.a().post(new i2(r105.build()));
        return;
    L7:
        if (r102 == 3) goto L9;
        UrlBuilder r108 = new UrlBuilder(r101.getSchemaUrl());
        r108.addParam("title", r101.getTitle());
        Uri r109 = UriProtector.parse(r108.build());
        ((IBaseLiveActionHandler) jc1.k.n(IBaseLiveActionHandler.class)).handle(r100, r109);
        return;
    L9:
        ((IBaseBrowserService) jc1.k.n(IBaseBrowserService.class)).buildFullScreenWebPage(r100, r101.getSchemaUrl()).setTitle(r101.getTitle()).b();
    }

    public final Observable<BannerData> d(Long r100, int r101) {
        return this.f104251c.filter(new b(r100, r101));
    }

    @Override // com.bytedance.android.livesdkapi.banner.IBannerManager
    public final Observable<BannerData> observeBanner(long r100, int r101) {
        return d(Long.valueOf(r100), r101);
    }

    public static Observable c(final InRoomBannerManager r210, final long r211, final boolean r212) {
        final int r110 = 0;
        if (r211 == r210.f104249a) goto L38;
        r210.f104249a = r211;
        r210.f104250b = r212;
        um0.a r100 = om0.c.i();
        if (r100 == null) goto L9;
        IBannerServiceApi r101 = (IBannerServiceApi) r100.getService(IBannerServiceApi.class);
        if (r101 == null) goto L9;
    L10:
        final IBannerServiceApi r102 = r101;
        r r103 = z51.a.c(null, r210.f104249a);
        if (r103 == null) goto L15;
        n<Boolean> r104 = r103.K();
        if (r104 == null) goto L15;
        Boolean r105 = r104.getValue();
    L16:
        if (r212 == true) goto L30;
        a50.a r106 = LiveInfraSettingKeys.LIVE_ROOM_BACKEND_BUSINESS_SWITCH.getValue();
        if (r106 == null) goto L30;
        if (r106.a() != true) goto L30;
        if ((!Intrinsics.areEqual(r105, Boolean.TRUE)) == false) goto L30;
        IRoomModuleService r107 = (IRoomModuleService) jc1.k.f(IRoomModuleService.class);
        if (r107 == null) goto L29;
        g r111 = r107.getLiveRoomBackendUtils();
        if (r111 == null) goto L29;
        g.a.a(r111, r211, null, BannerInRoomCollection.class, new InRoomBannerManager$fetch$1(r210, r102, r211, r212, r110), null, new InRoomBannerManager$fetch$2(r210, r211, r110, r102, r212), null, r210.f104252d, null, false, false, 3664);
    L29:
        DataCenter r108 = null;
        int r109 = 0;
    L31:
        r r112 = z51.a.c(r108, r210.f104249a);
        if (r112 == null) goto L37;
        n<Boolean> r113 = r112.K();
        if (r113 == null) goto L37;
        r113.setValue(Boolean.TRUE);
    L37:
        return r210.d(Long.valueOf(r211), r109);
    L30:
        r109 = 0;
        r108 = null;
        r210.e(r102, r211, r212, 0, true);
    L15:
        r105 = null;
    L9:
        r101 = (IBannerServiceApi) com.bytedance.android.live.network.c.b().e(IBannerServiceApi.class);
        goto L10
    L38:
        return r210.d(Long.valueOf(r211), 0);
    }

    public static final void b(InRoomBannerManager r100, int r101, long r102, Throwable r103) {
        r100.getClass();
        if (r101 != 1) goto L5;
        BannerFullMonitor.BannerType r104 = BannerFullMonitor.BannerType.BOTTOM_RIGHT;
    L9:
        String r105 = null;
        if (r103 == null) goto L12;
        String r106 = r103.getLocalizedMessage();
    L13:
        String r107 = String.valueOf(r102);
        if (r103 == null) goto L16;
        r105 = r103.getMessage();
    L16:
        BannerFullMonitor.b(-1, r106, r107, r104, r105);
        return;
    L12:
        r106 = null;
        goto L13
    L5:
        if (r101 == 5) goto L7;
        r104 = BannerFullMonitor.BannerType.OTHER;
        goto L9
    L7:
        r104 = BannerFullMonitor.BannerType.TOP_RIGHT;
        goto L9
    }

    public final void e(IBannerServiceApi r110, long r111, boolean r112, int r113, boolean r114) {
        if (r110 != null) goto L4;
        return;
    L4:
        if (r112 == true) goto L21;
        IRoomModuleService r100 = (IRoomModuleService) jc1.k.f(IRoomModuleService.class);
        if (r100 == null) goto L21;
        if (r100.getLiveRoomBackendMonitor() == null) goto L21;
        String r101 = String.valueOf(r111);
        r r102 = z51.a.c(null, this.f104249a);
        if (r102 == null) goto L16;
        n<Boolean> r103 = r102.K();
        if (r103 == null) goto L16;
        Boolean r104 = r103.getValue();
        if (r104 == null) goto L16;
        boolean r105 = r104.booleanValue();
    L17:
        Intrinsics.checkNotNullParameter(r101, "roomId");
        if (LiveInfraSettingKeys.LIVE_BACKEND_TASK_CONFIG.getValue().canUseBackendTask() == false) goto L21;
        JSONObject r106 = new JSONObject();
        BaseMonitor.add(r106, "stack_trace", i.l());
        BaseMonitor.add(r106, "room_id", r101);
        BaseMonitor.add(r106, "has_init", r105);
        LiveTracingMonitor.e("ttlive_banner_backend_fail", LiveTracingMonitor.EventModule.BANNER, LiveTracingMonitor.EventType.SERVER_API_CALL, null, null, r106);
    L16:
        r105 = false;
    L21:
        if (r112 == false) goto L23;
        int r115 = 2;
    L24:
        ((ObservableSubscribeProxy) r110.queryLiveRoomBanner(r111, r115, this.f104253e).compose(RxUtil.rxSchedulerHelper()).as(AutoDispose.bind(this.f104252d))).subscribe(new e(this, r111, r113, r114), new f(this, r113, r111));
        return;
    L23:
        r115 = 1;
        goto L24
    }
}
