package com.bytedance.android.live.tetris;

import am2.x;
import com.bytedance.android.live.LiveExpPushHelper;
import com.bytedance.android.live.base.model.push.LivePushInfo;
import com.bytedance.android.live.core.arch.mvvm.PropertyOwner;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.core.utils.z;
import com.bytedance.android.live.room.api.base.alog.SimpleAlogArgsBuilder;
import com.bytedance.android.live.room.api.experience.log.ExpOptLog;
import com.bytedance.android.live.room.api.experience.perf.LivePerfBizLevel;
import com.bytedance.android.live.room.api.experience.perf.LivePerfBizType;
import com.bytedance.android.live.room.api.experience.service.ILiveExpOptService;
import com.bytedance.android.live.room.api.experience.utils.PlatformExpUtils;
import com.bytedance.android.livehostapi.platform.IHostAction;
import com.bytedance.android.livesdk.chatroom.widget.RoomRecyclableWidget;
import com.bytedance.android.livesdk.log.u;
import com.bytedance.android.livesdk.utils.z0;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.optimize.statistics.FrescoMonitorConst;
import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.SingleEmitter;
import io.reactivex.SingleOnSubscribe;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import jc1.k;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import z51.e;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/live/tetris/ExpPushServiceWidget;", "Lcom/bytedance/android/livesdk/chatroom/widget/RoomRecyclableWidget;", "<init>", "()V", "experience-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ExpPushServiceWidget extends RoomRecyclableWidget {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f101921a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Disposable f101922b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final CompositeDisposable f101923c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f101924d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f101925e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f101926f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Disposable f101927g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Function1<LivePushInfo.f, Unit> f101928h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Function1<LivePushInfo.f, Unit> f101929i;

    public static final class a<T> implements SingleOnSubscribe {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f101930a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ com.bytedance.android.live.base.model.push.b f101931b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Map f101932c;

        public a(String r100, com.bytedance.android.live.base.model.push.b r101, Map r102) {
            this.f101930a = r100;
            this.f101931b = r101;
            this.f101932c = r102;
        }

        @Override // io.reactivex.SingleOnSubscribe
        public final void subscribe(SingleEmitter<Unit> r100) {
            Intrinsics.checkNotNullParameter(r100, "it");
            HashMap r101 = new HashMap();
            r101.put("action_type", this.f101930a);
            r101.put("content", String.valueOf(this.f101931b.getContent()));
            int r102 = z0.a();
            Integer r103 = z0.f159229d;
            if (r103 != null) goto L6;
        L8:
            String r104 = "non_low_level";
        L9:
            r101.put("machine_level", r104);
            r101.putAll(this.f101932c);
            int r105 = com.bytedance.android.live.room.api.experience.log.a.f98904a;
            com.bytedance.android.live.room.api.experience.log.a.c(this.f101930a, r101);
            u.l().sendLog("livesdk_live_common_inner_push", r101, new Object[]{x.class, Room.class});
            return;
        L6:
            if (r102 != r103.intValue()) goto L8;
            r104 = "low_level";
            goto L9
        }
    }

    public static final class b<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ExpPushServiceWidget f101933a;

        public b(ExpPushServiceWidget r100) {
            this.f101933a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r110) {
            final k61.a r100 = (k61.a) r110;
            boolean r101 = true;
            if (PlatformExpUtils.b() == false) goto L28;
            n61.a r102 = r100.f501946b;
            if (r102 != null) goto L7;
        L10:
            n61.a r103 = o61.a.f522156c;
            if (r103 == null) goto L13;
            r103.f518101b = false;
        L13:
            SimpleAlogArgsBuilder r104 = new SimpleAlogArgsBuilder();
            r104.d(this.f101933a.getTag());
            r104.c("handle push, shouldDelay:" + this.f101933a.f101924d + ", notShowPushThisTime:" + r101);
            ExpOptLog.d(r104.b());
            if (r101 == false) goto L86;
            ExpPushServiceWidget r105 = this.f101933a;
            boolean r106 = r105.f101924d;
            boolean r107 = LiveExpPushHelper.a();
            if (r107 == false) goto L18;
        L26:
            SimpleAlogArgsBuilder r108 = new SimpleAlogArgsBuilder();
            r108.d(r105.getTag());
            r108.c("流畅看播push无法展示，频控了, inInterval：" + r107 + "， hasShownPush：" + r105.f101926f);
            ExpOptLog.d(r108.b());
        L27:
            this.f101933a.f101924d = false;
            return;
        L18:
            if (r105.f101926f == true) goto L26;
            Disposable r109 = r105.f101927g;
            if (r109 == null) goto L23;
            r109.dispose();
        L23:
            if (r106 == false) goto L25;
            r105.f101927g = RxUtilKt.h(Observable.timer(r105.f101925e, TimeUnit.SECONDS)).subscribe(new com.bytedance.android.live.tetris.b(r105, r100));
            goto L27
        L25:
            r105.yq(r100);
            goto L27
        L86:
            return;
        L7:
            if (r102.f518101b != true) goto L10;
            r101 = false;
            goto L10
        L28:
            final ExpPushServiceWidget r111 = this.f101933a;
            r111.getClass();
            if (com.bytedance.android.live.room.api.experience.utils.a.f98913a.a() == false) goto L31;
            SimpleAlogArgsBuilder r112 = new SimpleAlogArgsBuilder();
            r112.d(r111.getTag());
            r112.c("强制降级阻断push");
            ExpOptLog.d(r112.b());
            return;
        L31:
            LivePerfBizType r113 = r100.getType();
            LivePerfBizType r114 = LivePerfBizType.Degrade;
            if (r113 != r114) goto L41;
            if (r100.f501948d != LivePerfBizLevel.P0) goto L41;
            n61.a r115 = r100.f501946b;
            if (r115 != null) goto L38;
        L39:
            SimpleAlogArgsBuilder r116 = new SimpleAlogArgsBuilder();
            r116.d(r111.getTag());
            r116.c("不处理非来自低电量导致的p0 push");
            ExpOptLog.d(r116.b());
            return;
        L38:
            if ((r115.f518102c instanceof n61.b.a) != true) goto L39;
        L41:
            if (r100.getType() != r114) goto L46;
            if (r100.f501948d == LivePerfBizLevel.P0) goto L46;
            boolean r117 = PlatformExpUtils.c().g().contains(Integer.valueOf(z0.a()));
        L50:
            if (r100.getType() == r114) goto L52;
        L72:
            SimpleAlogArgsBuilder r118 = new SimpleAlogArgsBuilder();
            r118.d(r111.getTag());
            r118.c("条件不满足，不处理push");
            int r119 = 0;
            Pair[] r120 = {TuplesKt.to("type", r100.getType().name()), TuplesKt.to("流畅看播开关", Boolean.valueOf(o61.a.f522157d)), TuplesKt.to("isTargetDevice:" + r117 + " 设备性能分级", Integer.valueOf(z0.a()))};
        L73:
            if (r119 >= 3) goto L80;
            Pair r121 = r120[r119];
            if (r121 == null) goto L79;
            Object r122 = r121.getSecond();
            if (r122 == null) goto L79;
            r118.a((String) r121.getFirst(), r122);
        L79:
            r119 = r119 + 1;
            goto L73
        L80:
            ExpOptLog.d(r118.b());
            return;
        L52:
            if (o61.a.f522157d == true) goto L72;
            if (r117 == false) goto L72;
            if (LiveExpPushHelper.a() == false) goto L57;
            SimpleAlogArgsBuilder r123 = new SimpleAlogArgsBuilder();
            r123.d(r111.getTag());
            r123.c("push处于频控中，不处理");
            ExpOptLog.d(r123.b());
            return;
        L57:
            LiveExpPushHelper.b();
            int r124 = com.bytedance.android.live.tetris.a.f101934a[r100.f501948d.ordinal()];
            if (r124 != 1) goto L60;
            SimpleAlogArgsBuilder r125 = new SimpleAlogArgsBuilder();
            r125.d(r111.getTag());
            r125.c(" p0 push");
            ExpOptLog.d(r125.b());
            ExpOptLog.f98903c.a("p0 push");
            IHostAction r126 = (IHostAction) k.f(IHostAction.class);
            if (r126 == null) goto L95;
            int r127 = LivePushInfo.f58904e;
            com.bytedance.android.live.base.model.push.b r128 = new com.bytedance.android.live.base.model.push.b();
            r128.setTitle("建议开启流畅看播");
            r128.setContent("当前电量较低，关闭高功耗功能");
            r128.setButtonText("去切换");
            r128.setScene(FrescoMonitorConst.IMAGE_QUALITY);
            r128.setDuration(PlatformExpUtils.d());
            Unit r129 = Unit.INSTANCE;
            LivePushInfo.a r130 = LivePushInfo.c.a(r128);
            r130.b(ExpPushServiceWidget$showP0Push$3.INSTANCE);
            r130.c(r111.f101929i);
            r130.a(new Pair[]{TuplesKt.to("push_reason", "low_battery"), TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_BUTTON_TYPE, "go_and_open"), TuplesKt.to("degrade_level", "0"), TuplesKt.to("is_low_degrade", "1")});
            r130.f58916d = true;
            r126.showLiveCommonInnerPush(new LivePushInfo(r130));
            return;
        L95:
            return;
        L60:
            if (r124 == 2) goto L66;
            if (r124 != 3) goto L97;
            SimpleAlogArgsBuilder r131 = new SimpleAlogArgsBuilder();
            r131.d(r111.getTag());
            r131.c(" p2 push");
            ExpOptLog.d(r131.b());
            ExpOptLog.f98903c.a("p2 push");
            IHostAction r132 = (IHostAction) k.f(IHostAction.class);
            if (r132 == null) goto L91;
            int r133 = LivePushInfo.f58904e;
            com.bytedance.android.live.base.model.push.b r134 = new com.bytedance.android.live.base.model.push.b();
            r134.setTitle("建议开启流畅看播");
            r134.setContent("当前耗能较高，关闭高功耗功能");
            r134.setButtonText("不切换");
            r134.setScene(FrescoMonitorConst.IMAGE_QUALITY);
            r134.setDuration(PlatformExpUtils.d());
            Unit r135 = Unit.INSTANCE;
            LivePushInfo.a r136 = LivePushInfo.c.a(r134);
            Function1<LivePushInfo.b, Unit> r137 = new ExpPushServiceWidget$showP2Push$3(r111, r100);
            Intrinsics.checkNotNullParameter(r137, "callback");
            r136.f58913a = r137;
            r136.c(r111.f101929i);
            r136.a(new Pair[]{TuplesKt.to("push_reason", "low_capacity_second_level_energy_consume"), TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_BUTTON_TYPE, "not_switch"), TuplesKt.to("degrade_level", "2"), TuplesKt.to("is_low_degrade", "1")});
            r136.f58916d = false;
            r132.showLiveCommonInnerPush(new LivePushInfo(r136));
            return;
        L91:
            return;
        L97:
            return;
        L66:
            SimpleAlogArgsBuilder r138 = new SimpleAlogArgsBuilder();
            r138.d(r111.getTag());
            r138.c(" p1 push");
            ExpOptLog.f98903c.a("p1 push");
            ExpOptLog.d(r138.b());
            IHostAction r139 = (IHostAction) k.f(IHostAction.class);
            if (r139 == null) goto L93;
            int r140 = LivePushInfo.f58904e;
            com.bytedance.android.live.base.model.push.b r141 = new com.bytedance.android.live.base.model.push.b();
            r141.setTitle("建议开启流畅看播");
            r141.setContent("当前耗能较高，关闭高功耗功能");
            r141.setButtonText("去切换");
            r141.setScene(FrescoMonitorConst.IMAGE_QUALITY);
            r141.setDuration(PlatformExpUtils.d());
            Unit r142 = Unit.INSTANCE;
            LivePushInfo.a r143 = LivePushInfo.c.a(r141);
            r143.b(ExpPushServiceWidget$showP1Push$3.INSTANCE);
            r143.c(r111.f101929i);
            r143.a(new Pair[]{TuplesKt.to("push_reason", "low_capacity_first_level_energy_consume"), TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_BUTTON_TYPE, "go_and_open"), TuplesKt.to("degrade_level", "1"), TuplesKt.to("is_low_degrade", "1")});
            r143.f58916d = true;
            r139.showLiveCommonInnerPush(new LivePushInfo(r143));
            return;
        L93:
            return;
        L46:
            if (r100.getType() != r114) goto L48;
            r117 = true;
            goto L50
        L48:
            r117 = false;
            goto L50
        }
    }

    public final String getTag() {
        return (String) this.f101921a.getValue();
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget
    public final void onInit(Object[] r100) {
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget
    public final void onUnload() {
        Disposable r100 = this.f101922b;
        if (r100 == null) goto L5;
        r100.dispose();
    L5:
        Disposable r101 = this.f101927g;
        if (r101 == null) goto L8;
        r101.dispose();
    L8:
        this.f101923c.clear();
        Lazy r102 = LiveExpPushHelper.f58519a;
        DataCenter r103 = this.dataCenter;
        if (r103 == null) goto L14;
        Room r104 = z.o(r103);
        if (r104 == null) goto L14;
        String r105 = String.valueOf(r104.getRoomId());
        if (r105 == null) goto L14;
    L15:
        Intrinsics.checkNotNullParameter(r105, "roomId");
        LiveExpPushHelper.f58522d.put(r105, Boolean.FALSE);
        return;
    L14:
        r105 = "";
        goto L15
    }

    public ExpPushServiceWidget() {
        this.f101921a = LazyKt.lazy(ExpPushServiceWidget$tag$2.INSTANCE);
        this.f101923c = new CompositeDisposable();
        this.f101925e = PlatformExpUtils.c().f();
        this.f101928h = new ExpPushServiceWidget$reportFluencyAction$1(this);
        this.f101929i = new ExpPushServiceWidget$reportAction$1(this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget
    public final void onLoad(Object[] r100) {
        SimpleAlogArgsBuilder r101 = new SimpleAlogArgsBuilder();
        r101.d(getTag());
        r101.c("监听体验性能处理push功能");
        ExpOptLog.d(r101.b());
        e61.a r102 = ((ILiveExpOptService) k.n(ILiveExpOptService.class)).dispatcher();
        if (r102 == null) goto L15;
        e r103 = r102.a();
        if (r103 == null) goto L15;
        if (sh6.c.b((sh6.b) r103.f570050a.f64752a) == null) goto L9;
        boolean r104 = true;
    L10:
        this.f101924d = r104;
        Unit r105 = Unit.INSTANCE;
        Observable<T> r106 = r103.a();
        if (r106 == 0) goto L15;
        Observable r107 = RxUtilKt.h(r106);
        if (r107 == null) goto L15;
        Disposable r108 = r107.subscribe(new b(this));
    L16:
        this.f101922b = r108;
        return;
    L9:
        r104 = false;
    L15:
        r108 = null;
        goto L16
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void yq(final k61.a r110) {
        if (r110 != null) goto L5;
        return;
    L5:
        if (r110.f501947c != LivePerfBizType.Degrade) goto L7;
        boolean r100 = true;
    L8:
        if (r100 != true) goto L58;
        PropertyOwner r101 = o61.a.f522159f;
        if (((Boolean) r101.f64752a).booleanValue() == true) goto L12;
    L15:
        String r111 = "not_switch";
        if (PlatformExpUtils.c().i() == false) goto L21;
        ExpOptLog.f98903c.a("流畅看播（理解性实验） push展示");
        IHostAction r102 = (IHostAction) k.f(IHostAction.class);
        if (r102 == null) goto L20;
        int r103 = LivePushInfo.f58904e;
        com.bytedance.android.live.base.model.push.b r104 = new com.bytedance.android.live.base.model.push.b();
        r104.setTitle("即将进入极致流畅模式");
        r104.setContent("检测设备性能差，为你关闭高能耗功能");
        r104.setButtonText("不切换");
        r104.setScene(FrescoMonitorConst.IMAGE_QUALITY);
        r104.setDuration(PlatformExpUtils.d());
        Unit r105 = Unit.INSTANCE;
        LivePushInfo.a r106 = LivePushInfo.c.a(r104);
        Function1<LivePushInfo.b, Unit> r107 = new ExpPushServiceWidget$showRadicalPush$2(this, r110);
        Intrinsics.checkNotNullParameter(r107, "callback");
        r106.f58913a = r107;
        r106.c(this.f101928h);
        r106.a(new Pair[]{TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_BUTTON_TYPE, "not_switch"), TuplesKt.to("is_low_degrade", "2"), TuplesKt.to("degrade_level", String.valueOf(r110.f501948d.getLevel()))});
        r106.f58916d = false;
        r102.showLiveCommonInnerPush(new LivePushInfo(r106));
    L20:
        LiveExpPushHelper.b();
        return;
    L21:
        LivePerfBizLevel r108 = r110.f501948d;
        if (r108 != LivePerfBizLevel.P0) goto L31;
        if (((Boolean) r101.f64752a).booleanValue() == false) goto L26;
        SimpleAlogArgsBuilder r109 = new SimpleAlogArgsBuilder();
        r109.d(getTag());
        r109.c("不展示普通流畅看播push，因为普通流畅看播开关打开了");
        ExpOptLog.d(r109.b());
        return;
    L26:
        ExpOptLog.f98903c.a("普通流畅看播push展示");
        IHostAction r112 = (IHostAction) k.f(IHostAction.class);
        if (r112 == null) goto L29;
        int r113 = LivePushInfo.f58904e;
        com.bytedance.android.live.base.model.push.b r114 = new com.bytedance.android.live.base.model.push.b();
        r114.setTitle("即将进入流畅看播");
        r114.setContent("检测设备性能差，为你开启功耗优化");
        r114.setButtonText("不切换");
        r114.setScene(FrescoMonitorConst.IMAGE_QUALITY);
        r114.setDuration(PlatformExpUtils.d());
        Unit r115 = Unit.INSTANCE;
        LivePushInfo.a r116 = LivePushInfo.c.a(r114);
        Function1<LivePushInfo.b, Unit> r117 = new ExpPushServiceWidget$showNormalFluencyPush$3(this, r110);
        Intrinsics.checkNotNullParameter(r117, "callback");
        r116.f58913a = r117;
        r116.c(this.f101928h);
        r116.a(new Pair[]{TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_BUTTON_TYPE, "not_switch"), TuplesKt.to("is_low_degrade", "2"), TuplesKt.to("degrade_level", String.valueOf(r110.f501948d.getLevel()))});
        r116.f58916d = false;
        r112.showLiveCommonInnerPush(new LivePushInfo(r116));
    L29:
        LiveExpPushHelper.b();
        return;
    L31:
        if (r108 == LivePerfBizLevel.P1) goto L33;
        return;
    L33:
        if (((Boolean) o61.a.f522161h.f64752a).booleanValue() == false) goto L35;
        SimpleAlogArgsBuilder r118 = new SimpleAlogArgsBuilder();
        r118.d(getTag());
        r118.c("不展示极致流畅看播push，因为极致流畅看播开关打开了");
        ExpOptLog.d(r118.b());
        return;
    L35:
        ExpOptLog.f98903c.a("极致流畅看播push展示");
        IHostAction r119 = (IHostAction) k.f(IHostAction.class);
        if (r119 == null) goto L55;
        int r120 = LivePushInfo.f58904e;
        com.bytedance.android.live.base.model.push.b r121 = new com.bytedance.android.live.base.model.push.b();
        r121.setTitle("即将进入极致流畅看播");
        if (PlatformExpUtils.f98912d == true) goto L45;
        r121.setContent("当前耗能较高，为你关闭特效动画");
        n61.a r122 = r110.f501946b;
        if (r122 != null) goto L42;
    L44:
        r121.setButtonText("不切换");
        r121.setScene(FrescoMonitorConst.IMAGE_QUALITY);
        r121.setDuration(PlatformExpUtils.d());
    L51:
        Unit r123 = Unit.INSTANCE;
        LivePushInfo.a r124 = LivePushInfo.c.a(r121);
        Function1<LivePushInfo.b, Unit> r125 = new ExpPushServiceWidget$showBestFluencyPush$3(this, r110);
        Intrinsics.checkNotNullParameter(r125, "callback");
        r124.f58913a = r125;
        r124.c(this.f101928h);
        Pair[] r126 = new Pair[3];
        if (PlatformExpUtils.f98912d == false) goto L54;
        r111 = "go_and_open";
    L54:
        r126[0] = TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_BUTTON_TYPE, r111);
        r126[1] = TuplesKt.to("is_low_degrade", "2");
        r126[2] = TuplesKt.to("degrade_level", String.valueOf(r110.f501948d.getLevel()));
        r124.a(r126);
        r124.f58916d = false;
        r119.showLiveCommonInnerPush(new LivePushInfo(r124));
        goto L55
    L42:
        if ((r122.f518102c instanceof n61.b.a) != true) goto L44;
        r121.setContent("当前电量较低，为你关闭特效动画");
        goto L44
    L45:
        r121.setTitle("建议开启极致流畅模式");
        r121.setContent("当前耗能较高，建议关闭特效动画");
        n61.a r127 = r110.f501946b;
        if (r127 != null) goto L48;
    L50:
        r121.setButtonText("去开启");
        goto L51
    L48:
        if ((r127.f518102c instanceof n61.b.a) != true) goto L50;
        r121.setContent("当前电量较低，建议关闭特效动画");
    L55:
        LiveExpPushHelper.b();
        return;
    L12:
        if (((Boolean) o61.a.f522161h.f64752a).booleanValue() == false) goto L15;
        SimpleAlogArgsBuilder r128 = new SimpleAlogArgsBuilder();
        r128.d(getTag());
        r128.c("不展示流畅看播push，普通和极致开关都打开了");
        ExpOptLog.d(r128.b());
        return;
    L58:
        return;
    L7:
        r100 = false;
        goto L8
    }

    public static void wq(com.bytedance.android.live.base.model.push.b r100, String r101, Map r102) {
        Intrinsics.checkNotNullParameter(r100, "pushMessage");
        Intrinsics.checkNotNullParameter(r101, "actType");
        Intrinsics.checkNotNullParameter(r102, "logExtra");
        Single.create(new a(r101, r100, r102)).subscribeOn(Schedulers.io()).subscribe();
    }

    public static void xq(com.bytedance.android.live.base.model.push.b r100, String r101, Map r102) {
        Intrinsics.checkNotNullParameter(r100, "pushMessage");
        Intrinsics.checkNotNullParameter(r101, "actType");
        Intrinsics.checkNotNullParameter(r102, "logExtra");
        HashMap r103 = new HashMap();
        String r104 = r100.getScene();
        if (r104 != null) goto L5;
        r104 = "";
    L5:
        r103.put("business_scene", r104);
        r103.put("action_type", r101);
        int r105 = z0.a();
        Integer r106 = z0.f159229d;
        if (r106 != null) goto L9;
    L11:
        String r107 = "non_low_level";
    L12:
        r103.put("machine_level", r107);
        r103.put("content", String.valueOf(r100.getContent()));
        r103.putAll(r102);
        com.bytedance.android.live.room.api.experience.log.a.c(r101, r103);
        u.l().sendLog("livesdk_live_common_inner_push", r103, new Object[]{x.class, Room.class});
        return;
    L9:
        if (r105 != r106.intValue()) goto L11;
        r107 = "low_level";
        goto L12
    }
}
