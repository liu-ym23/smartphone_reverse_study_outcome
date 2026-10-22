package com.bytedance.android.live.revenuelink;

import androidx.lifecycle.LiveData;
import com.bytedance.android.live.anchorlink.linksecurity.LinkSecurityApi$VideoCaptureType;
import com.bytedance.android.live.base.model.Extra;
import com.bytedance.android.live.network.response.ExtraResponse;
import com.bytedance.android.live.revenue.platform.network.api.INetworkService;
import com.bytedance.android.livesdk.link.model.t3;
import com.bytedance.android.livesdk.link.model.u3;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomBase;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomKtKt;
import com.bytedance.revenue.platform.api.core.rx.p;
import fr2.i0;
import fr2.k1;
import io.reactivex.Observable;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.TypesJVMKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes47.dex */
public final class b implements com.bytedance.android.live.revenuelink.e {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final CompositeDisposable f91712b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<String> f91713c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f91714d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f91715e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final com.bytedance.android.live.revenuelink.withroom.a f91716f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final yz0.g f91717g;

    public static final class a {
    }

    /* JADX INFO: renamed from: com.bytedance.android.live.revenuelink.b$b, reason: collision with other inner class name */
    public static final class C1421b<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f91718a;

        public C1421b(b r100) {
            this.f91718a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            ExtraResponse r101 = (ExtraResponse) r100;
            if (r101 != null) goto L5;
            return;
        L5:
            if (((u3) r101.data).getSleepTime() <= 1) goto L7;
            b r102 = this.f91718a;
            r102.f91714d = ((u3) r101.data).getSleepTime();
        L7:
            b.c(this.f91718a);
        }
    }

    public static final class c<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f91719a;

        public c(b r100) {
            this.f91719a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            Throwable r101 = (Throwable) r100;
            b.c(this.f91719a);
        }
    }

    public static final class d<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f91720a;

        public d(b r100) {
            this.f91720a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            ExtraResponse r101 = (ExtraResponse) r100;
            if (r101 == null) goto L5;
            t3 r102 = (t3) r101.data;
        L6:
            if (r102 != null) goto L8;
        L10:
            b.c(this.f91720a);
            return;
        L8:
            if (r102.getSleepSecond() <= 1) goto L10;
            b r103 = this.f91720a;
            r103.f91714d = r102.getSleepSecond();
            goto L10
        L5:
            r102 = null;
            goto L6
        }
    }

    public static final class e<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f91721a;

        public e(b r100) {
            this.f91721a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            Throwable r101 = (Throwable) r100;
            b.c(this.f91721a);
        }
    }

    static {
    }

    @Override // com.bytedance.android.live.revenuelink.e
    public final void dispose() {
        this.f91715e = false;
        ((CopyOnWriteArrayList) this.f91713c).clear();
        if (this.f91712b.isDisposed() == true) goto L6;
        this.f91712b.dispose();
        return;
    }

    public static final void c(b r100) {
        r100.getClass();
        com.bytedance.revenue.platform.api.core.rx.l r101 = com.bytedance.revenue.platform.api.core.rx.l.f267516a;
        long r102 = r100.f91714d * ((long) 1000);
        int r103 = p.f267522a;
        Scheduler r104 = Schedulers.computation();
        Disposable r105 = Observable.timer(r102, TimeUnit.MILLISECONDS, r104).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new com.bytedance.android.live.revenuelink.c(r100), com.bytedance.android.live.revenuelink.d.f91828a);
        r100.f91712b.add(r105);
    }

    public static String d(List r100) {
        StringBuilder r101 = new StringBuilder();
        Iterator r102 = ((CopyOnWriteArrayList) r100).iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        r101.append((String) r102.next());
        r101.append(",");
        goto L4
    L6:
        String r103 = r101.toString();
        if (StringsKt.endsWith$default(r103, ",", false, 2, null) == true) goto L9;
        return r103;
    L9:
        return r103.substring(0, r103.length() - 1);
    }

    @Override // com.bytedance.android.live.revenuelink.e
    public final void a(boolean r100) {
        this.f91715e = r100;
    }

    @Override // com.bytedance.android.live.revenuelink.e
    public final void b(String r310) {
        Intrinsics.checkNotNullParameter(r310, "reqSource");
        h11.a r100 = h11.a.f483518f;
        r100.getClass();
        if (((Boolean) h11.a.f483516d.getValue(r100, h11.a.f483513a[2])).booleanValue() == true) goto L5;
        return;
    L5:
        IRoomBase r101 = this.f91717g.getRoom();
        this.f91717g.getUser();
        if (this.f91717g.isAnchor() == true) goto L8;
        return;
    L8:
        com.bytedance.android.live.revenuelink.connect.f r102 = this.f91716f.Z0();
        if (r102 == null) goto L13;
        LiveData<ey.f> r103 = r102.connectState();
        if (r103 == null) goto L13;
        ey.f r104 = r103.getValue();
    L14:
        if (r104 == null) goto L16;
        long r105 = r104.f474771a;
    L17:
        boolean r106 = false;
        if (this.f91716f.m0() == null) goto L51;
        com.bytedance.android.live.revenuelink.rtc.f r107 = this.f91716f.m0();
        if (r107 == null) goto L22;
        com.bytedance.android.live.revenuelink.rtc.i r108 = r107.getRtcManager();
    L23:
        if (r108 == null) goto L51;
        com.bytedance.android.live.revenuelink.rtc.f r109 = this.f91716f.m0();
        if (r109 == null) goto L29;
        com.bytedance.android.live.revenuelink.rtc.i r110 = r109.getRtcManager();
        if (r110 == null) goto L29;
        vc0.a r111 = r110.getLiveCore();
    L30:
        if (r111 == null) goto L51;
        com.bytedance.android.live.revenuelink.rtc.f r112 = this.f91716f.m0();
        if (r112 == null) goto L36;
        com.bytedance.android.live.revenuelink.rtc.i r113 = r112.getRtcManager();
        if (r113 == null) goto L36;
        r113.getLiveCore();
    L36:
        com.bytedance.android.live.revenuelink.rtc.f r114 = this.f91716f.m0();
        if (r114 == null) goto L41;
        com.bytedance.android.live.revenuelink.rtc.i r115 = r114.getRtcManager();
        if (r115 == null) goto L41;
        vc0.a r116 = r115.getLiveCore();
    L42:
        if (r116 == null) goto L44;
        fr2.p r117 = i0.a(r116);
    L45:
        if (r117 == null) goto L51;
        if (r117.getBuilder() == null) goto L51;
        k1 r118 = r117.getBuilder();
        if (r118 == null) goto L51;
        int r119 = r118.e();
    L53:
        if (r119 == 0) goto L61;
        if (r119 == 1) goto L60;
        if (r119 == 2) goto L60;
        if (r119 == 5) goto L59;
        LinkSecurityApi$VideoCaptureType r120 = LinkSecurityApi$VideoCaptureType.VIDEO_CAPTURE_DEVICE_UNKNOWN;
    L62:
        int r121 = r120.ordinal();
        String r122 = "";
        if (this.f91716f.m0() == null) goto L82;
        com.bytedance.android.live.revenuelink.rtc.f r123 = this.f91716f.m0();
        if (r123 == null) goto L67;
        com.bytedance.android.live.revenuelink.rtc.i r124 = r123.getRtcManager();
    L68:
        if (r124 == null) goto L82;
        com.bytedance.android.live.revenuelink.rtc.f r125 = this.f91716f.m0();
        if (r125 == null) goto L74;
        com.bytedance.android.live.revenuelink.rtc.i r126 = r125.getRtcManager();
        if (r126 == null) goto L74;
        int r127 = r126.getMixType();
    L75:
        com.bytedance.android.live.revenuelink.rtc.f r128 = this.f91716f.m0();
        if (r128 == null) goto L83;
        com.bytedance.android.live.revenuelink.rtc.i r129 = r128.getRtcManager();
        if (r129 == null) goto L83;
        String r130 = r129.getRtcExtInfo();
        if (r130 == null) goto L83;
    L85:
        if (r130.length() != 0) goto L87;
        r106 = true;
    L87:
        if (r106 == false) goto L92;
        if (r104 == null) goto L91;
        r130 = r104.f474776f;
        if (r130 != null) goto L92;
    L91:
        r130 = "";
    L92:
        if (r104 == null) goto L97;
        String r131 = r104.f474775e;
        if (r131 == null) goto L97;
        r122 = r131;
    L97:
        long r132 = r105;
        String r133 = r122;
        if (this.f91715e == false) goto L125;
        if (e11.c.f470689a == null) goto L120;
        long r134 = IRoomKtKt.getId(r101);
        String r135 = d(this.f91713c);
        long r136 = r127;
        Intrinsics.checkNotNullParameter(r135, "linkmicIdList");
        Intrinsics.checkNotNullParameter(r310, "source");
        Intrinsics.checkNotNullParameter(r130, "rtcInfo");
        tz0.b r137 = tz0.b.f548039a;
        uz0.c r138 = new uz0.c();
        r137.getClass();
        Intrinsics.checkNotNullParameter(r138, "$this$beforeConfigureRequest");
        Map<String, String> r139 = r138.f552161b;
        Intrinsics.checkNotNullParameter(r139, "queriesMap");
        String r140 = Long.valueOf(r134).toString();
        Intrinsics.checkNotNullParameter("room_id", "$this$setTo");
        if (r140 == null) goto L104;
        r139.put("room_id", r140);
    L104:
        Intrinsics.checkNotNullParameter("linkmic_id_list", "$this$setTo");
        if (r135 == null) goto L107;
        r139.put("linkmic_id_list", r135);
    L107:
        Intrinsics.checkNotNullParameter("request_source", "$this$setTo");
        r139.put("request_source", r310);
        String r141 = Long.valueOf(r136).toString();
        Intrinsics.checkNotNullParameter("mix_type", "$this$setTo");
        if (r141 == null) goto L110;
        r139.put("mix_type", r141);
    L110:
        Intrinsics.checkNotNullParameter("rtc_ext_info", "$this$setTo");
        r139.put("rtc_ext_info", r130);
        String r142 = Integer.valueOf(r121).toString();
        Intrinsics.checkNotNullParameter("video_capture_type", "$this$setTo");
        if (r142 == null) goto L113;
        r139.put("video_capture_type", r142);
    L113:
        Intrinsics.checkNotNullParameter(r138, "$this$afterConfigureRequest");
        Observable r143 = ((INetworkService) com.bytedance.android.live.revenue.core.util.f.a(INetworkService.class)).x0(INetworkService.Biz.Revenue, "/webcast/linkmic_audience/check_linkers/", TypesJVMKt.getJavaType(Reflection.typeOf(u3.class)), Extra.class, r138.f552163d, r138.f552160a, r138.f552161b, r138.f552162c);
        if (r143 == null) goto L120;
        int r144 = p.f267522a;
        Observable r145 = r143.subscribeOn(Schedulers.io());
        if (r145 == null) goto L120;
        Observable r146 = r145.observeOn(AndroidSchedulers.mainThread());
        if (r146 == null) goto L120;
        Disposable r147 = r146.subscribe(new C1421b(this), new c(this));
    L121:
        if (r147 == null) goto L139;
        this.f91712b.add(r147);
    L139:
        return;
    L120:
        r147 = null;
        goto L121
    L125:
        if (e11.c.f470689a == null) goto L134;
        long r148 = IRoomKtKt.getId(r101);
        String r149 = d(this.f91713c);
        long r150 = r127;
        Intrinsics.checkNotNullParameter(r133, "ownerLinkmicId");
        Intrinsics.checkNotNullParameter(r149, "linkmicIdList");
        Intrinsics.checkNotNullParameter(r310, "source");
        Intrinsics.checkNotNullParameter(r130, "rtcInfo");
        tz0.b r151 = tz0.b.f548039a;
        uz0.c r152 = new uz0.c();
        r151.getClass();
        Intrinsics.checkNotNullParameter(r152, "$this$beforeConfigureRequest");
        uz0.f r153 = new uz0.f(r152.f552161b);
        r153.a("linker_id", Long.valueOf(r132).toString());
        r153.a("room_id", Long.valueOf(r148).toString());
        r153.a("owner_linkmic_id", r133);
        r153.a("linkmic_id_list", r149);
        r153.a("request_source", r310);
        r153.a("mix_type", Long.valueOf(r150).toString());
        r153.a("rtc_ext_info", r130);
        Intrinsics.checkNotNullParameter(r152, "$this$afterConfigureRequest");
        Observable r154 = ((INetworkService) com.bytedance.android.live.revenue.core.util.f.a(INetworkService.class)).x0(INetworkService.Biz.Revenue, "/webcast/linkmic/check_anchor_linkers/", TypesJVMKt.getJavaType(Reflection.typeOf(t3.class)), Extra.class, r152.f552163d, r152.f552160a, r152.f552161b, r152.f552162c);
        if (r154 == null) goto L133;
        int r155 = p.f267522a;
        Observable r156 = r154.subscribeOn(Schedulers.io());
        if (r156 == null) goto L133;
        Observable r157 = r156.observeOn(AndroidSchedulers.mainThread());
        if (r157 == null) goto L133;
        b r158 = this;
        Disposable r159 = r157.subscribe(new d(r158), new e(r158));
    L136:
        if (r159 == null) goto L140;
        r158.f91712b.add(r159);
        return;
    L140:
        return;
    L133:
        r158 = this;
    L135:
        r159 = null;
        goto L136
    L134:
        r158 = this;
    L83:
        r130 = "";
    L74:
        r127 = 0;
        goto L75
    L67:
        r124 = null;
    L82:
        r127 = -1;
        goto L83
    L59:
        r120 = LinkSecurityApi$VideoCaptureType.VIDEO_CAPTURE_RADIO_MODE;
    L60:
        r120 = LinkSecurityApi$VideoCaptureType.VIDEO_CAPTURE_VIDEO;
        goto L62
    L61:
        r120 = LinkSecurityApi$VideoCaptureType.VIDEO_CAPTURE_DEVICE_NONE;
        goto L62
    L44:
        r117 = null;
    L41:
        r116 = null;
    L29:
        r111 = null;
        goto L30
    L22:
        r108 = null;
    L51:
        r119 = 0;
        goto L53
    L16:
        r105 = 0;
    L13:
        r104 = null;
        goto L14
    }

    public b(com.bytedance.android.live.revenuelink.withroom.a r100, yz0.g r101) {
        Intrinsics.checkNotNullParameter(r100, "storeService");
        Intrinsics.checkNotNullParameter(r101, "roomDataService");
        this.f91716f = r100;
        this.f91717g = r101;
        this.f91712b = new CompositeDisposable();
        this.f91713c = new CopyOnWriteArrayList();
        h11.a r102 = h11.a.f483518f;
        r102.getClass();
        this.f91714d = ((Number) h11.a.f483515c.getValue(r102, h11.a.f483513a[1])).intValue();
    }
}
