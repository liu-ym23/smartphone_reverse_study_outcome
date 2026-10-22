package com.bytedance.android.livesdk.audiencerecord;

import android.animation.ValueAnimator;
import android.text.TextUtils;
import android.view.animation.LinearInterpolator;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.network.response.Response;
import com.bytedance.android.livesdk.audiencerecord.api.BacktrackState;
import com.bytedance.android.livesdk.audiencerecord.api.LiveAudienceBackRecordApi;
import com.bytedance.android.livesdk.config.bg;
import com.bytedance.android.livesdk.config.cg;
import com.bytedance.android.livesdk.message.model.j0;
import com.bytedance.android.livesdkapi.depend.live.ILiveRecordService;
import com.bytedance.android.livesdkapi.depend.message.MessageType;
import com.bytedance.android.livesdkapi.depend.model.backtrace.AudienceBackRecordData;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.model.ListenLiveStatus;
import com.bytedance.ee.bear.unbundle.BenefitStore;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.KVData;
import com.larus.nova.R;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\b\u0012\u0004\u0012\u00020\u00050\u0004¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/livesdk/audiencerecord/BacktrackServiceImp;", "Lse1/c;", "Lvlc/l;", "Lcom/bytedance/android/livesdkapi/depend/live/ILiveRecordService$PublishStatusListener;", "Lcom/ss/android/ugc/aweme/compat/nullable/Observer;", "Lcom/bytedance/ies/sdk/widgets/KVData;", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class BacktrackServiceImp implements se1.c, vlc.l, ILiveRecordService.PublishStatusListener, Observer<KVData> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final o f103977a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ue1.b f103978b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final a0 f103979c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final CompositeDisposable f103980d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public vlc.d f103981e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Disposable f103982f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public ValueAnimator f103983g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public AudienceBackRecordData f103984h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f103985i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f103986j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final DataCenter f103987k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Room f103988l;

    public static final class a<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ BacktrackServiceImp f103989a;

        public a(BacktrackServiceImp r100) {
            this.f103989a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            AudienceBackRecordData r101 = (AudienceBackRecordData) ((Response) r100).data;
            if (r101 == null) goto L37;
            this.f103989a.f103984h = r101;
            AudienceBackRecordData r102 = null;
            List<String> r103 = null;
            if (r101.tsUrls == null) goto L18;
            Intrinsics.checkNotNull(r101);
            if (r101.tsUrls.size() <= 0) goto L18;
            AudienceBackRecordData r104 = this.f103989a.f103984h;
            if (r104 == null) goto L11;
            String r105 = r104.m3u8Url;
        L13:
            if (TextUtils.isEmpty(r105) == true) goto L18;
            BacktrackServiceImp r106 = this.f103989a;
            r106.getClass();
            ArrayList r107 = new ArrayList();
            long r108 = System.currentTimeMillis();
            r106.f103977a.f(BacktrackState.BACKTRACK_DOING);
            a0 r109 = r106.f103979c;
            AudienceBackRecordData r110 = r106.f103984h;
            if (r110 == null) goto L17;
            r103 = r110.tsUrls;
        L17:
            r109.getClass();
            r106.f103980d.add(x.a(r103, r107, 0.0f, 90.0f).compose(RxUtil.rxSchedulerHelper()).doOnDispose(new h(r107)).subscribe(new i(r106), new j(r106), new k(r106, r108, r107)));
            return;
        L11:
            r105 = null;
        L18:
            BacktrackServiceImp r111 = this.f103989a;
            AudienceBackRecordData r112 = r111.f103984h;
            if (r112 != null) goto L21;
        L36:
            r111.f(BenefitStore.FROM_SERVER);
            Unit r113 = Unit.INSTANCE;
            return;
        L21:
            if (r112.waitSeconds >= 0) goto L23;
        L25:
            boolean r114 = false;
        L26:
            if (r114 == false) goto L28;
            r102 = r112;
        L28:
            if (r102 == null) goto L36;
            ValueAnimator r115 = r111.f103983g;
            if (r115 == null) goto L32;
            r115.cancel();
        L32:
            r111.f103977a.f(BacktrackState.BACKTRACK_DOING);
            ValueAnimator r116 = ValueAnimator.ofFloat(new float[]{0.0f, 50.0f});
            r116.setInterpolator(new LinearInterpolator());
            long r117 = 1000;
            r116.setDuration(r102.waitSeconds * r117);
            r116.addUpdateListener(new com.bytedance.android.livesdk.audiencerecord.a(r111));
            Unit r118 = Unit.INSTANCE;
            r111.f103983g = r116;
            r116.start();
            Disposable r119 = r111.f103982f;
            if (r119 == null) goto L35;
            r119.dispose();
        L35:
            Disposable r120 = Observable.just(r111).delay(r102.timeOutSeconds * r117, TimeUnit.MILLISECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(new com.bytedance.android.livesdk.audiencerecord.b(r111), new c(r111));
            r111.f103980d.add(r120);
            r111.f103982f = r120;
            return;
        L23:
            if (r112.timeOutSeconds < 0) goto L25;
            r114 = true;
            goto L26
        L37:
            this.f103989a.f(BenefitStore.FROM_SERVER);
            Unit r121 = Unit.INSTANCE;
        }
    }

    public static final class b<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ BacktrackServiceImp f103990a;

        public b(BacktrackServiceImp r100) {
            this.f103990a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            Throwable r101 = (Throwable) r100;
            this.f103990a.f(BenefitStore.FROM_SERVER);
        }
    }

    @Override // se1.c
    public final void b() {
        this.f103985i = null;
        this.f103986j = false;
        this.f103980d.clear();
        ValueAnimator r100 = this.f103983g;
        if (r100 == null) goto L5;
        r100.cancel();
    L5:
        Disposable r101 = this.f103982f;
        if (r101 == null) goto L8;
        r101.dispose();
    L8:
        this.f103977a.f(BacktrackState.IDLE);
        startBacktrack();
    }

    @Override // se1.c
    public final void c() {
        this.f103986j = true;
    }

    @Override // se1.c
    public final void cancel() {
        g(BacktrackState.IDLE);
    }

    @Override // se1.c
    public final void release() {
        if (this.f103977a.f104061a != BacktrackState.BACKTRACK_DOING) goto L5;
        this.f103978b.a(ListenLiveStatus.END_EXIT_ROOM);
    L5:
        g(BacktrackState.IDLE);
        vlc.d r100 = this.f103981e;
        if (r100 == null) goto L8;
        r100.removeMessageListener(this);
    L8:
        com.bytedance.android.livesdk.service.l.d().e().removePublishStatusListener(this);
    }

    @Override // se1.c
    public final void startBacktrack() {
        this.f103977a.f(BacktrackState.STARTED);
        com.bytedance.android.livesdk.service.l.d().getClass();
        LiveAudienceBackRecordApi r100 = (LiveAudienceBackRecordApi) com.bytedance.android.live.network.c.b().e(LiveAudienceBackRecordApi.class);
        Room r101 = this.f103988l;
        long r102 = 0;
        if (r101 == null) goto L5;
        long r103 = r101.f162599id;
    L6:
        long r104 = cg.f119945a.getValue().longValue();
        long r105 = bg.f119865a.getValue().longValue();
        AudienceBackRecordData r106 = this.f103984h;
        if (r106 == null) goto L9;
        r102 = r106.endTime;
    L9:
        Observable<Response<AudienceBackRecordData>> r107 = r100.queryAudienceBacktrack(r103, r104, r105, r102);
        if (r107 == null) goto L17;
        Observable<R> r108 = r107.compose(RxUtil.rxSchedulerHelper());
        if (r108 == 0) goto L18;
        Disposable r109 = r108.subscribe(new a(this), new b(this));
        if (r109 == null) goto L19;
        this.f103980d.add(r109);
        return;
    L19:
        return;
    L18:
        return;
    L17:
        return;
    L5:
        r103 = 0;
        goto L6
    }

    @Override // se1.c
    public final o a() {
        return this.f103977a;
    }

    @Override // se1.c
    public final AudienceBackRecordData d() {
        return this.f103984h;
    }

    @Override // se1.c
    public final String e() {
        return this.f103985i;
    }

    public final void f(String r100) {
        g(BacktrackState.ERROR);
        f2.b(R.string.ttlive_live_backtrack_failed_toast, 0);
        this.f103978b.a(r100);
    }

    public final void g(BacktrackState r100) {
        this.f103985i = null;
        this.f103986j = false;
        this.f103984h = null;
        this.f103980d.clear();
        ValueAnimator r101 = this.f103983g;
        if (r101 == null) goto L5;
        r101.cancel();
    L5:
        Disposable r102 = this.f103982f;
        if (r102 == null) goto L8;
        r102.dispose();
    L8:
        this.f103977a.f(r100);
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        KVData r101 = (KVData) r100;
        if (r101 == null) goto L17;
        Object r102 = null;
        if ("data_message_manager".equals(r101.getKey()) == false) goto L7;
        KVData r103 = r101;
    L8:
        if (r103 == null) goto L18;
        Object r104 = r101.getData();
        if ((r104 instanceof vlc.d) == false) goto L13;
        r102 = r104;
    L13:
        vlc.d r105 = (vlc.d) r102;
        this.f103981e = r105;
        if (r105 == null) goto L19;
        r105.addMessageListener(MessageType.ANCHOR_BACK_RECORD_MESSAGE.getIntType(), this);
        return;
    L19:
        return;
    L18:
        return;
    L7:
        r103 = null;
        goto L8
    }

    @Override // vlc.l
    public final void onMessage(tlc.d r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        if ((r100 instanceof j0) == false) goto L29;
        Disposable r101 = this.f103982f;
        if (r101 == null) goto L8;
        r101.dispose();
    L8:
        ValueAnimator r102 = this.f103983g;
        if (r102 == null) goto L11;
        r102.cancel();
    L11:
        j0 r103 = (j0) r100;
        if (r103.getSucceed() == false) goto L26;
        String r104 = r103.E();
        AudienceBackRecordData r105 = this.f103984h;
        List<String> r106 = null;
        if (r105 == null) goto L16;
        String r107 = r105.executionId;
    L18:
        if (TextUtils.equals(r104, r107) == false) goto L26;
        AudienceBackRecordData r108 = this.f103984h;
        if (r108 == null) goto L22;
        r108.m3u8Url = r103.G();
        r108.tsUrls = r103.H();
    L22:
        this.f103977a.f(BacktrackState.PREVIEWING);
        float r109 = this.f103977a.f104062b;
        String r110 = ue1.a.b();
        this.f103977a.f(BacktrackState.BACKTRACK_DOING);
        a0 r111 = this.f103979c;
        AudienceBackRecordData r112 = this.f103984h;
        if (r112 == null) goto L25;
        r106 = r112.tsUrls;
    L25:
        r111.getClass();
        ArrayList r113 = new ArrayList();
        this.f103980d.add(Observable.concat(x.a(r106, r113, r109, 98.0f), Observable.create(new u(r113, r110))).doOnDispose(new y(r113)).doOnComplete(new z(r113)).compose(RxUtil.rxSchedulerHelper()).subscribe(new l(this), new m(this), new n(this, r110)));
        return;
    L16:
        r107 = null;
    L26:
        f(BenefitStore.FROM_SERVER);
        return;
    }

    public BacktrackServiceImp(DataCenter r100, Room r101) {
        Intrinsics.checkNotNullParameter(r100, "dataCenter");
        this.f103987k = r100;
        this.f103988l = r101;
        o r102 = new o();
        this.f103977a = r102;
        this.f103978b = new ue1.b(r101, r102);
        this.f103979c = new a0();
        this.f103980d = new CompositeDisposable();
        vlc.d r103 = (vlc.d) r100.get("data_message_manager");
        this.f103981e = r103;
        if (r103 == null) goto L5;
        r103.addMessageListener(MessageType.ANCHOR_BACK_RECORD_MESSAGE.getIntType(), this);
    L6:
        com.bytedance.android.livesdk.service.l.d().e().addPublishStatusListener(this);
        return;
    L5:
        r100.observe("data_message_manager", this);
        goto L6
    }

    @Override // com.bytedance.android.livesdkapi.depend.live.ILiveRecordService.PublishStatusListener
    public final void onChange(ILiveRecordService.PublishStatus r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "status");
        if (r100 == ILiveRecordService.PublishStatus.PUBLISH_FINISH) goto L5;
        return;
    L5:
        if (this.f103986j == false) goto L9;
        g(BacktrackState.IDLE);
        return;
    }
}
