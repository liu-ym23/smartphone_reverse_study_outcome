package com.bytedance.android.livesdk.chatroom.end.vip;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.bytedance.android.live.browser.IBaseBrowserService;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.chatroom.end.vip.repos.RestartLiveStateRepository;
import com.bytedance.android.livesdk.chatroom.end.vip.repos.VipStateRepository;
import com.bytedance.android.livesdk.chatroom.end.vip.utils.EndRoomMessageType;
import com.bytedance.android.livesdk.chatroom.end.vip.view.CountDownProgressView;
import com.bytedance.android.livesdk.config.ho0;
import com.bytedance.android.livesdk.config.io0;
import com.bytedance.android.livesdk.end.EndingPageGuideCardInfo;
import com.bytedance.android.livesdk.end.LiveEndPageData;
import com.bytedance.android.livesdk.end.VipLiveEndData;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdk.schema.interfaces.IBaseLiveActionHandler;
import com.bytedance.android.livesdk.utils.f5;
import com.bytedance.android.livesdk.utils.u6;
import com.bytedance.android.livesdk.utils.v6;
import com.bytedance.android.livesdk.utils.z4;
import com.bytedance.android.livesdkapi.message.ExternalMessageInject;
import com.larus.nova.R;
import io.reactivex.Completable;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposables;
import io.reactivex.subjects.BehaviorSubject;
import java.util.concurrent.TimeUnit;
import jc1.k;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class VipLiveEndService {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Function1<? super String, Unit> f106126a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public View f106127b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public TextView f106128c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public TextView f106129d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public CountDownProgressView f106130e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final BehaviorSubject<Boolean> f106131f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Lazy f106132g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Lazy f106133h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Lazy f106134i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Lazy f106135j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public VipLiveEndData f106136k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final CompositeDisposable f106137l;

    private final Context getContext() {
        return (Context) this.f106135j.getValue();
    }

    public final void c() {
        TextView r100 = this.f106128c;
        if (r100 == null) goto L5;
        Object r101 = r100.getParent();
    L7:
        if ((r101 instanceof View) == true) goto L9;
        r101 = null;
    L9:
        View r102 = (View) r101;
        if (r102 == null) goto L12;
        UtilityKotlinExtentionsKt.t(r102);
    L12:
        this.f106137l.clear();
        ((RestartLiveStateRepository) this.f106133h.getValue()).dispose();
        ((VipStateRepository) this.f106134i.getValue()).dispose();
        this.f106126a = null;
        return;
    L5:
        r101 = null;
        goto L7
    }

    public VipLiveEndService() {
        this.f106131f = BehaviorSubject.createDefault(Boolean.TRUE);
        this.f106132g = LazyKt.lazy(VipLiveEndService$countDownSeconds$2.INSTANCE);
        this.f106133h = LazyKt.lazy(VipLiveEndService$liveStateRepos$2.INSTANCE);
        this.f106134i = LazyKt.lazy(VipLiveEndService$vipStateRepos$2.INSTANCE);
        this.f106135j = LazyKt.lazy(VipLiveEndService$context$2.INSTANCE);
        this.f106137l = new CompositeDisposable();
    }

    public static final void a(VipLiveEndService r100) {
        r100.getClass();
        if (v6.b().isLogin() == true) goto L5;
        f2.b(R.string.ttlive_vip_end_user_unlogin, 0);
        return;
    L5:
        u6 r101 = new u6(ho0.f120393a.getValue());
        u6 r102 = r101.d("url");
        VipLiveEndData r103 = r100.f106136k;
        if (r103 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("vipLiveEndData");
    L8:
        r102.b("anchor_id", r103.getAnchorId());
        VipLiveEndData r104 = r100.f106136k;
        if (r104 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("vipLiveEndData");
    L11:
        r102.b("author_id", r104.getAnchorId());
        Context r105 = r100.getContext();
        if (r105 == null) goto L16;
        ((IBaseLiveActionHandler) k.n(IBaseLiveActionHandler.class)).handle(r105, r101.c());
        return;
    }

    public final LiveEndPageData b(EndingPageGuideCardInfo r110) {
        View r100 = null;
        if (r110 == null) goto L5;
        VipLiveEndData r101 = r110.getVipLiveEndData();
    L6:
        if (r101 != null) goto L8;
        return null;
    L8:
        j0 r102 = j0.l();
        Pair[] r103 = new Pair[2];
        boolean r104 = false;
        r103[0] = TuplesKt.to("anchor_id", r101.getAnchorId());
        if (Intrinsics.areEqual(r101.isVip(), Boolean.TRUE) == false) goto L11;
        String r105 = "1";
    L12:
        r103[1] = TuplesKt.to("vip_status", r105);
        r102.sendLog("livesdk_livevip_stream_wait_page_show", MapsKt.mapOf(r103), new Object[0]);
        ExternalMessageInject r106 = ExternalMessageInject.getInstance();
        EndRoomMessageType.Companion.getClass();
        r106.inject(EndRoomMessageType.access$getInjectInfoList$cp());
        this.f106126a = r110.getUpdateTitle();
        LiveEndPageData r111 = new LiveEndPageData();
        r111.setOnHideFragmentCallback(new VipLiveEndService$getDynamicComponent$liveEndPageData$1$1(this));
        r111.setOnShowFragmentCallback(new VipLiveEndService$getDynamicComponent$liveEndPageData$1$2(this));
        r111.setOnUnloadCallback(new VipLiveEndService$getDynamicComponent$liveEndPageData$1$3(this));
        r111.setTopView("name");
        r111.setHideViews(CollectionsKt.arrayListOf(new String[]{LiveEndPageData.TAG_SUBSCRIPTION, LiveEndPageData.TAG_APPOINTMENT_V2, LiveEndPageData.TAG_OPEN_PUSH}));
        r111.setMargins(CollectionsKt.listOf(new Integer[]{0, 34, 0, 0}));
        View r107 = LayoutInflater.from(getContext()).inflate(R.layout.ttlive_vip_live_end_layout, null);
        if (r107 == null) goto L35;
        this.f106127b = r107.findViewById(R.id.open_vip_button);
        this.f106130e = (CountDownProgressView) r107.findViewById(R.id.count_down_view);
        this.f106128c = (TextView) r107.findViewById(R.id.vip_main_text);
        this.f106129d = (TextView) r107.findViewById(R.id.vip_sub_text);
        View r108 = this.f106127b;
        if (r108 == null) goto L18;
        r108.setOnClickListener(new g(new VipLiveEndService$setupView$1(this)));
    L18:
        Boolean r109 = r101.isVip();
        if (r109 == null) goto L21;
        r104 = r109.booleanValue();
    L21:
        long r112 = r101.getRoomID();
        long r113 = r101.getNewRoomID();
        RestartLiveStateRepository r114 = (RestartLiveStateRepository) this.f106133h.getValue();
        if (r113 <= 0) goto L24;
        r114.getClass();
        RxUtilKt.c(Completable.timer(2, TimeUnit.SECONDS).subscribe(new com.bytedance.android.livesdk.chatroom.end.vip.repos.d(r114, r113)), r114.f106146a);
    L31:
        BehaviorSubject r115 = (BehaviorSubject) r114.f106151f.getValue();
        VipStateRepository r116 = (VipStateRepository) this.f106134i.getValue();
        ((BehaviorSubject) r116.f106154c.getValue()).onNext(Boolean.valueOf(r104));
        if (r104 == true) goto L34;
        RxUtilKt.c(((IBaseBrowserService) k.n(IBaseBrowserService.class)).registerJsEventSubscriber("subscription.vipsendnewpurchase").subscribe(new com.bytedance.android.livesdk.chatroom.end.vip.repos.e(r116)), r116.f106152a);
    L34:
        RxUtilKt.c(RxUtilKt.h(Observable.combineLatest(r115, (BehaviorSubject) r116.f106154c.getValue(), this.f106131f, a.f106138a).filter(new b(this)).distinctUntilChanged()).subscribe(new e(this), f.f106143a), this.f106137l);
        r100 = r107;
        goto L35
    L24:
        r114.f106150e = z4.b(r114.f106149d, r112, s1.getContext(), MapsKt.emptyMap());
        RxUtilKt.c(Disposables.fromAction(new com.bytedance.android.livesdk.chatroom.end.vip.repos.b(r114)), r114.f106146a);
        f5 r117 = r114.f106150e;
        if (r117 != null) goto L27;
        Intrinsics.throwUninitializedPropertyAccessException("imManager");
    L27:
        r117.addMessageListener(EndRoomMessageType.VipEndRoom.getMessageIntType(), new com.bytedance.android.livesdk.chatroom.end.vip.repos.c(r114));
        f5 r118 = r114.f106150e;
        if (r118 != null) goto L30;
        Intrinsics.throwUninitializedPropertyAccessException("imManager");
    L30:
        r118.startMessage();
        Unit r119 = Unit.INSTANCE;
        r114.f106148c = Observable.timer(io0.f120469a.getValue().longValue(), TimeUnit.SECONDS).subscribe(new com.bytedance.android.livesdk.chatroom.end.vip.repos.a(r114));
    L35:
        r111.setContent(r100);
        this.f106136k = r101;
        return r111;
    L11:
        r105 = "0";
        goto L12
    L5:
        r101 = null;
        goto L6
    }
}
