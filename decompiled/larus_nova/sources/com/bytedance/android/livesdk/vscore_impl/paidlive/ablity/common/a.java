package com.bytedance.android.livesdk.vscore_impl.paidlive.ablity.common;

import android.text.TextUtils;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.core.utils.v;
import com.bytedance.android.live.network.response.Response;
import com.bytedance.android.livesdk.chatroom.api.RoomRetrofitApi;
import com.bytedance.android.livesdk.config.hf0;
import com.bytedance.android.livesdk.config.if0;
import com.bytedance.android.livesdk.vscore_api.paid.PaidSceneEnum;
import com.bytedance.android.livesdkapi.depend.live.vs.VSConstants;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.depend.model.live.episode.VSCameraInfo;
import com.bytedance.android.livesdkapi.paidlive.IPaidLiveTraceMonitor;
import com.bytedance.android.livesdkapi.roomplayer.IPaidLiveRefreshStreamListener;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import pu2.n;

/* JADX INFO: loaded from: classes11.dex */
public class a implements n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public CompositeDisposable f160125a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Disposable f160126b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<IPaidLiveRefreshStreamListener> f160127c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f160128d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f160129e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f160130f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long f160131g;

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.vscore_impl.paidlive.ablity.common.a$a, reason: collision with other inner class name */
    public static final class C2451a {
    }

    public static final class b<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f160132a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ long f160133b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ long f160134c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ String f160135d;

        public b(a r100, long r101, long r102, String r103) {
            this.f160132a = r100;
            this.f160133b = r101;
            this.f160134c = r102;
            this.f160135d = r103;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            Long r101 = (Long) r100;
            this.f160132a.f(this.f160133b, this.f160134c, this.f160135d);
        }
    }

    static {
    }

    @Override // pu2.n
    public void Fi(Room r100) {
    }

    @Override // pu2.n
    public void S7(Long r100, Boolean r101) {
    }

    public String c() {
        throw null;
    }

    public String d() {
        throw null;
    }

    public void i(String r100, int r101) {
    }

    public void j(PaidSceneEnum r100) {
        throw null;
    }

    @Override // pu2.n
    public void l6(boolean r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "reportReason");
    }

    @Override // com.bytedance.android.scope.o
    public final void onStart() {
    }

    @Override // com.bytedance.android.scope.o
    public final void onStop() {
    }

    @Override // pu2.n
    public void release() {
        CompositeDisposable r100 = this.f160125a;
        if (r100 == null) goto L5;
        r100.dispose();
    L5:
        this.f160125a = null;
        ((ArrayList) this.f160127c).clear();
        Disposable r101 = this.f160126b;
        if (r101 == null) goto L9;
        r101.dispose();
        return;
    }

    public a() {
        this.f160127c = new ArrayList();
        this.f160129e = "";
    }

    @Override // pu2.n
    public final void m8(PaidSceneEnum r100) {
        j(r100);
    }

    @Override // pu2.n
    public final void nd(IPaidLiveRefreshStreamListener r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        if (((ArrayList) this.f160127c).contains(r100) == true) goto L6;
        ((ArrayList) this.f160127c).add(r100);
        return;
    }

    public final void a(String r110, String r111, Map<String, String> r112) {
        Intrinsics.checkNotNullParameter(r111, "msg");
        if (r110 == null) goto L8;
        Map r100 = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("room_id", String.valueOf(this.f160128d)), TuplesKt.to(VSConstants.VS_CAMERA_ID, this.f160129e), TuplesKt.to("extra_message", r111), TuplesKt.to("stream_ability_hash", String.valueOf(hashCode()))});
        if (r112 == null) goto L7;
        r100.putAll(r112);
    L7:
        IPaidLiveTraceMonitor.DefaultImpls.trace$default(com.bytedance.android.livesdk.vscore_api.paidlive.g.f159443e, r110, null, r100, d(), c(), 2, null);
    L8:
        ALogger.i("PaidLiveTraceMonitorPaidRefreshStreamAbility-PaidRefreshStreamAbility[" + hashCode() + ']', "PaidLiveRefreshStreamAbility, roomId: " + this.f160128d + ", cameraId: " + this.f160129e + ", " + r111);
    }

    public void f(long r100, long r110, String r111) {
        h(r100, r110, r111, 2);
    }

    public void g(Room r100, List<? extends VSCameraInfo> r101, int r102) {
        Iterator r103 = ((ArrayList) this.f160127c).iterator();
    L4:
        if (r103.hasNext() == false) goto L13;
        IPaidLiveRefreshStreamListener r104 = (IPaidLiveRefreshStreamListener) r103.next();
        if (r102 != 1) goto L8;
        r104.requestStream4BuyTicket(r100, r101);
    L12:
        a(null, "listener " + r104 + " notify request new stream url in legacy", MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("refresh_scene", String.valueOf(r102))}));
        goto L4
    L8:
        if (r102 != 2) goto L12;
        r104.requestStream4TempWatch(r100, r101);
        goto L12
    }

    @Override // pu2.n
    public void Ri(long r110, long r111, String r112, Long r113) {
        if (r111 == 0) goto L30;
        Disposable r100 = this.f160126b;
        if (r100 != null) goto L7;
    L9:
        Disposable r101 = this.f160126b;
        if (r101 == null) goto L13;
        r101.dispose();
    L13:
        if (if0.f120448a.getValue().booleanValue() == true) goto L15;
    L18:
        if (r113 == null) goto L20;
        long r102 = r113.longValue();
    L22:
        if (r102 > 0) goto L24;
        long r103 = 30;
    L17:
        long r104 = r103;
        this.f160126b = Observable.interval(0, r104, TimeUnit.SECONDS).repeat(Long.MAX_VALUE).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new b(this, r110, r111, r112));
        a("paidlive_refresh_timer_start", "start timer, interval " + r104, null);
        return;
    L24:
        if (r113 == null) goto L26;
        long r105 = r113.longValue();
    L27:
        r103 = r105 / ((long) 2);
        goto L17
    L26:
        r105 = 60;
        goto L27
    L20:
        r102 = 0;
        goto L22
    L15:
        if (v.a() == false) goto L18;
        r103 = hf0.f120372a.getValue().c();
        goto L17
    L7:
        if (r100.isDisposed() == true) goto L9;
    L30:
        StringBuilder r106 = new StringBuilder("startRefreshStreamTimer fail, room id ");
        r106.append(r111);
        r106.append(", time disposable ");
        r106.append(this.f160126b);
        r106.append(", is disposed ");
        Disposable r107 = this.f160126b;
        if (r107 == null) goto L33;
        Boolean r108 = Boolean.valueOf(r107.isDisposed());
    L34:
        r106.append(r108);
        a(null, r106.toString(), null);
        return;
    L33:
        r108 = null;
        goto L34
    }

    public final void h(long r100, long r110, String r111, int r112) {
        this.f160128d = r110;
        if (r111 != null) goto L5;
        String r101 = "";
    L6:
        this.f160129e = r101;
        a(null, "requestFullRightStream: start request, room id " + this.f160128d + ", camera id " + this.f160129e + ", isPreview=" + (this instanceof com.bytedance.android.livesdk.vscore_impl.paidlive.ablity.preview.a), null);
        if (this.f160125a != null) goto L10;
        this.f160125a = new CompositeDisposable();
    L10:
        if (r111 != null) goto L12;
    L26:
        a("paidlive_refresh_stream_start", "start request room stream url", MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("paidlive_scene", "paid_room"), TuplesKt.to("refresh_scene", String.valueOf(r112))}));
        RxUtilKt.c(((RoomRetrofitApi) com.bytedance.android.live.network.c.b().e(RoomRetrofitApi.class)).getRoomInfoByScene(r110, "paid_live_change_stream").subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new d(this, r112), new e(this, r112)), this.f160125a);
        return;
    L12:
        if (TextUtils.isEmpty(r111) == true) goto L26;
        if (TextUtils.equals(r111, "0") == true) goto L26;
        a("paidlive_refresh_stream_start", "start request multi camera info", MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("paidlive_scene", "paid_camera"), TuplesKt.to("refresh_scene", String.valueOf(r112))}));
        nm1.a r113 = (nm1.a) pm1.h.f529822d.c(nm1.a.class);
        if (r113 == null) goto L28;
        Observable<Response<com.bytedance.android.livesdk.vscore_impl.component.multicamera.linkedroom.util.f>> r102 = r113.c(r100, r110);
        if (r102 == null) goto L29;
        Observable<Response<com.bytedance.android.livesdk.vscore_impl.component.multicamera.linkedroom.util.f>> r103 = r102.subscribeOn(Schedulers.io());
        if (r103 == null) goto L30;
        Observable<Response<com.bytedance.android.livesdk.vscore_impl.component.multicamera.linkedroom.util.f>> r104 = r103.observeOn(AndroidSchedulers.mainThread());
        if (r104 == null) goto L31;
        Disposable r105 = r104.subscribe(new com.bytedance.android.livesdk.vscore_impl.paidlive.ablity.common.b(this, r112), new c(this, r112));
        if (r105 == null) goto L32;
        RxUtilKt.c(r105, this.f160125a);
        return;
    L32:
        return;
    L31:
        return;
    L30:
        return;
    L29:
        return;
    L28:
        return;
    L5:
        r101 = r111;
        goto L6
    }
}
