package com.bytedance.android.livesdk.slideuptip;

import am2.x;
import android.os.Handler;
import com.bytedance.android.live.browser.IBrowserService;
import com.bytedance.android.live.core.setting.SettingKey;
import com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget;
import com.bytedance.android.live.core.utils.z;
import com.bytedance.android.live.room.IRoomService;
import com.bytedance.android.livesdk.closeroom.CloseRoomInterceptList;
import com.bytedance.android.livesdk.config.LiveConfigSettingKeys;
import com.bytedance.android.livesdk.log.u;
import com.bytedance.android.livesdkapi.TTLiveService;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.hybridapi.SubscriberJsEvent;
import com.bytedance.android.livesdkapi.service.ILiveService;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livesdk/slideuptip/SlideTaskWidget;", "Lcom/bytedance/android/live/core/tetris/widgets/LiveRecyclableWidget;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "live-impl-saas_release"}, k = 1, mv = {1, 4, 3})
public final class SlideTaskWidget extends LiveRecyclableWidget {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final /* synthetic */ int f158384i = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f158385a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f158386b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f158387c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Lazy f158388d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Disposable f158389e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final b f158390f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long f158391g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final List<kf1.a> f158392h;

    public static final class a {
    }

    public static final class b implements kf1.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SlideTaskWidget f158393a;

        @Override // kf1.a
        public final String tag() {
            return "SlideTaskWidget";
        }

        @Override // kf1.a
        public final CloseRoomInterceptList config() {
            return CloseRoomInterceptList.SLIDE_TASK;
        }

        public b(SlideTaskWidget r100) {
            this.f158393a = r100;
        }

        @Override // kf1.a
        public final boolean qa(Runnable r100, boolean r110) {
            if (r110 == true) goto L78;
            SlideTaskWidget r111 = this.f158393a;
            if (r111.f158386b == true) goto L9;
        L33:
            boolean r112 = false;
        L38:
            if (r112 == true) goto L76;
            SlideTaskWidget r113 = this.f158393a;
            if (r113.f158385a == true) goto L44;
            return false;
        L44:
            if (g.f158409a == true) goto L80;
            Integer r101 = LiveConfigSettingKeys.GLIDE_TASK_GUIDE_STYLE.getValue();
            if (r101 != null) goto L50;
            return false;
        L50:
            if (r101.intValue() == 1) goto L53;
            return false;
        L53:
            if ((System.currentTimeMillis() - r113.f158391g) < (LiveConfigSettingKeys.GLIDE_TASK_GUIDE_TIME.getValue().longValue() * 1000)) goto L83;
            SettingKey<String> r102 = LiveConfigSettingKeys.GLIDE_TASK_GUIDE_SCHEMA;
            String r103 = r102.getValue();
            if (r103 != null) goto L58;
        L61:
            boolean r104 = true;
        L62:
            if (r104 == true) goto L84;
            Room r105 = ((IRoomService) jc1.k.n(IRoomService.class)).getCurrentRoom();
            if (r105 != null) goto L67;
        L69:
            com.bytedance.android.livesdk.sharedpref.e<Integer> r106 = com.bytedance.android.livesdk.sharedpref.b.f158169k1;
            Integer r107 = r106.getValue();
            if (r107.intValue() >= g.a()) goto L86;
            ILiveService r108 = TTLiveService.getLiveService();
            if (r108 == null) goto L75;
            r108.handleSchema(r113.getContext(), UriProtector.parse(r102.getValue()));
        L75:
            com.bytedance.android.livesdk.sharedpref.f.d(r106, Integer.valueOf(r107.intValue() + 1));
            g.f158409a = true;
            goto L76
        L86:
            return false;
        L67:
            if (r105.isMediaRoom() == false) goto L69;
            return false;
        L84:
            return false;
        L58:
            if (r103.length() == 0) goto L61;
            r104 = false;
            goto L62
        L83:
            return false;
        L80:
            return false;
        L76:
            return true;
        L9:
            if (r111.f158387c == true) goto L33;
            SettingKey<String> r109 = LiveConfigSettingKeys.GLIDE_TASK_REMAIN_SCHEMA;
            String r114 = r109.getValue();
            if (r114 != null) goto L14;
        L17:
            boolean r115 = true;
        L18:
            if (r115 == true) goto L33;
            Room r116 = ((IRoomService) jc1.k.n(IRoomService.class)).getCurrentRoom();
            if (r116 != null) goto L23;
        L25:
            com.bytedance.android.livesdk.sharedpref.e<Integer> r117 = com.bytedance.android.livesdk.sharedpref.b.f158174l1;
            Integer r118 = r117.getValue();
            int r119 = r118.intValue();
            boolean r120 = g.f158409a;
            SettingKey<Integer> r121 = LiveConfigSettingKeys.GLIDE_TASK_REMAIN_COUNT;
            Integer r122 = r121.getValue();
            if (r122 != null) goto L29;
        L31:
            int r123 = r121.getValue().intValue();
        L32:
            if (r119 >= r123) goto L33;
            ILiveService r124 = TTLiveService.getLiveService();
            if (r124 == null) goto L37;
            r124.handleSchema(r111.getContext(), UriProtector.parse(r109.getValue()));
        L37:
            com.bytedance.android.livesdk.sharedpref.f.d(r117, Integer.valueOf(r118.intValue() + 1));
            r111.f158387c = true;
            r112 = true;
            goto L38
        L29:
            if (r122.intValue() != (-1)) goto L31;
            r123 = Integer.MAX_VALUE;
            goto L32
        L23:
            if (r116.isMediaRoom() == false) goto L25;
        L14:
            if (r114.length() == 0) goto L17;
            r115 = false;
            goto L18
        L78:
            return false;
        }
    }

    public static final class c<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SlideTaskWidget f158394a;

        public c(SlideTaskWidget r100) {
            this.f158394a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r110) {
            SubscriberJsEvent r111 = (SubscriberJsEvent) r110;
            Map<String, Object> r100 = r111.getParams();
            Object r101 = null;
            if (r100 == null) goto L5;
            Object r102 = r100.get("showGuide");
        L6:
            boolean r103 = Intrinsics.areEqual(r102, 1);
            SlideTaskWidget r104 = this.f158394a;
            if (r104.f158385a == r103) goto L15;
            r104.f158385a = r103;
            r104.f158391g = System.currentTimeMillis();
            SlideTaskWidget r105 = this.f158394a;
            ((Handler) r105.f158388d.getValue()).removeCallbacksAndMessages("SlideTaskManager.token");
            if (r105.wq() == false) goto L15;
            boolean r106 = g.f158409a;
            long r107 = LiveConfigSettingKeys.GLIDE_TASK_GUIDE_TIME.getValue().longValue() * 1000;
            if (r107 > 1) goto L14;
            r105.xq();
            goto L15
        L14:
            ((Handler) r105.f158388d.getValue()).postDelayed(new h(r105), "SlideTaskManager.token", r107);
        L15:
            SlideTaskWidget r108 = this.f158394a;
            Map<String, Object> r112 = r111.getParams();
            if (r112 == null) goto L18;
            r101 = r112.get("showRemain");
        L18:
            r108.f158386b = Intrinsics.areEqual(r101, 1);
            return;
        L5:
            r102 = null;
            goto L6
        }
    }

    static {
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget
    public final void onInit(Object[] r100) {
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget
    public final void onUnload() {
        Disposable r100 = this.f158389e;
        if (r100 != null) goto L5;
    L10:
        this.f158385a = false;
        this.f158386b = false;
        this.f158387c = false;
        this.f158391g = Long.MAX_VALUE;
        this.f158392h.remove(this.f158390f);
        ((Handler) this.f158388d.getValue()).removeCallbacksAndMessages("SlideTaskManager.token");
        return;
    L5:
        if (r100.isDisposed() == true) goto L10;
        Disposable r101 = this.f158389e;
        if (r101 == null) goto L9;
        r101.dispose();
    L9:
        this.f158389e = null;
        goto L10
    }

    public final boolean wq() {
        if (this.f158385a == true) goto L6;
        return false;
    L6:
        if (g.f158409a == false) goto L9;
        return false;
    L9:
        if (g.f158410b == false) goto L11;
        return false;
    L11:
        Integer r100 = LiveConfigSettingKeys.GLIDE_TASK_GUIDE_STYLE.getValue();
        if (r100 != null) goto L15;
    L16:
        return false;
    L15:
        if (r100.intValue() != 2) goto L16;
        Room r101 = ((IRoomService) jc1.k.n(IRoomService.class)).getCurrentRoom();
        if (r101 == null) goto L23;
        if (r101.isMediaRoom() == false) goto L23;
        return false;
    L23:
        if (com.bytedance.android.livesdk.sharedpref.b.f158169k1.getValue().intValue() < g.a()) goto L25;
        return false;
    L25:
        return true;
    }

    public final void xq() {
        if (wq() == true) goto L6;
        return;
    L6:
        if (z.m(this.dataCenter, true) == true) goto L8;
        return;
    L8:
        com.bytedance.android.livesdk.e.b().getClass();
        if (com.bytedance.android.livesdk.e.c() == false) goto L11;
        return;
    L11:
        Function1<? super Boolean, Boolean> r100 = g.f158411c;
        if (r100 != null) goto L14;
    L16:
        boolean r101 = false;
    L17:
        if (r101 == false) goto L20;
        com.bytedance.android.livesdk.sharedpref.e<Integer> r102 = com.bytedance.android.livesdk.sharedpref.b.f158169k1;
        com.bytedance.android.livesdk.sharedpref.f.d(r102, Integer.valueOf(r102.getValue().intValue() + 1));
        g.f158409a = true;
        Intrinsics.checkNotNullParameter("tobsdk_livesdk_slide_task_guide_show", "key");
        u.l().d("tobsdk_livesdk_slide_task_guide_show", new Object[]{x.class, Room.class});
        return;
    L20:
        return;
    L14:
        if (r100.invoke(Boolean.TRUE).booleanValue() != true) goto L16;
        r101 = true;
        goto L17
    }

    public SlideTaskWidget(List<kf1.a> r100) {
        Intrinsics.checkNotNullParameter(r100, "interceptorList");
        this.f158392h = r100;
        this.f158388d = LazyKt.lazy(SlideTaskWidget$mainHandler$2.INSTANCE);
        this.f158390f = new b(this);
        this.f158391g = Long.MAX_VALUE;
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget
    public final void onLoad(Object[] r100) {
        IBrowserService r101 = (IBrowserService) jc1.k.f(IBrowserService.class);
        if (r101 == null) goto L9;
        Observable<SubscriberJsEvent> r102 = r101.registerJsEventSubscriber("webcast_saas_glideTask_msg");
        if (r102 == null) goto L9;
        Observable<SubscriberJsEvent> r103 = r102.observeOn(AndroidSchedulers.mainThread());
        if (r103 == null) goto L9;
        Disposable r104 = r103.subscribe(new c(this));
    L10:
        this.f158389e = r104;
        if (this.f158392h.contains(this.f158390f) == true) goto L14;
        ListProtector.add(this.f158392h, 0, this.f158390f);
        return;
    L14:
        return;
    L9:
        r104 = null;
        goto L10
    }
}
