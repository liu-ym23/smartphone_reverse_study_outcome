package com.bytedance.android.livesdk.microom.enhance;

import android.graphics.drawable.Drawable;
import android.text.TextPaint;
import android.view.View;
import android.widget.TextView;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.a1;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.core.utils.rxutils.autodispose.ObservableSubscribeProxy;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.network.response.Response;
import com.bytedance.android.live.rowcontract.RowRecyclableWidget;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.chatroom.api.RoomRetrofitApi;
import com.bytedance.android.livesdk.crash.SourceType;
import com.bytedance.android.livesdk.microom.NormalRoomShowListWidget;
import com.bytedance.android.livesdk.schema.interfaces.ILiveActionHandler;
import com.bytedance.android.livesdkapi.depend.model.live.OfficialChannelExtraInfo;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.KVData;
import com.larus.nova.R;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u00022\b\u0012\u0004\u0012\u00020\u00040\u0003B\u0007¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/livesdk/microom/enhance/NormalRoomMicListWidget;", "Lcom/bytedance/android/live/rowcontract/RowRecyclableWidget;", "Lcom/bytedance/android/live/room/x;", "Lcom/ss/android/ugc/aweme/compat/nullable/Observer;", "Lcom/bytedance/ies/sdk/widgets/KVData;", "<init>", "()V", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class NormalRoomMicListWidget extends RowRecyclableWidget implements com.bytedance.android.live.room.x, Observer<KVData> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public View f153822a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public TextView f153823b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public View f153824c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public View f153825d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f153826e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Room f153827f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public CompositeDisposable f153828g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Disposable f153829h;

    public static final class a<T, R> implements Function {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f153830a;

        public a(int r100) {
            this.f153830a = r100;
        }

        @Override // io.reactivex.functions.Function
        public final Object apply(Object r100) {
            Long r101 = (Long) r100;
            Intrinsics.checkNotNullParameter(r101, "it");
            return Long.valueOf((((long) this.f153830a) - r101.longValue()) - 1);
        }
    }

    public static final class b implements io.reactivex.Observer<Long> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ NormalRoomMicListWidget f153831a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ boolean f153832b;

        @Override // io.reactivex.Observer
        public final void onError(Throwable r100) {
            Intrinsics.checkNotNullParameter(r100, "e");
        }

        @Override // io.reactivex.Observer
        public final void onComplete() {
            NormalRoomMicListWidget r100 = this.f153831a;
            View r101 = r100.f153825d;
            if (r101 == null) goto L5;
            r101.setBackgroundDrawable(null);
        L5:
            x r102 = new x(r100);
            View r103 = r100.f153822a;
            if (r103 == null) goto L9;
            r103.post(new NormalRoomMicListWidget$doWithAnimation$1(r100, true, false, r102));
            return;
        }

        @Override // io.reactivex.Observer
        public final void onNext(Long r100) {
            long r101 = r100.longValue();
            NormalRoomMicListWidget r102 = this.f153831a;
            if (this.f153832b == false) goto L5;
            r102.getClass();
            String r103 = s1.C(R.string.ttlive_normal_room_mic_tips_end_count_down, new Object[]{Long.valueOf(r101)});
        L6:
            r102.Aq(r103);
            return;
        L5:
            r102.getClass();
            r103 = s1.C(R.string.ttlive_normal_room_mic_tips_begin_count_down, new Object[]{Long.valueOf(r101)});
            goto L6
        }

        @Override // io.reactivex.Observer
        public final void onSubscribe(Disposable r100) {
            Intrinsics.checkNotNullParameter(r100, "d");
            NormalRoomMicListWidget r101 = this.f153831a;
            r101.f153829h = r100;
            r101.f153828g.add(r100);
        }

        public b(NormalRoomMicListWidget r100, boolean r101) {
            this.f153831a = r100;
            this.f153832b = r101;
        }
    }

    @Override // com.bytedance.ies.sdk.widgets.Widget
    public final int getLayoutId() {
        return R.layout.ttlive_normal_room_mic_entrance_layout;
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget
    public final void onUnload() {
        this.f153828g.clear();
        DataCenter r100 = this.dataCenter;
        if (r100 == null) goto L6;
        r100.removeObserver(this);
        return;
    }

    public final void yq() {
        Room r100 = this.f153827f;
        if (r100 == null) goto L7;
        OfficialChannelExtraInfo r101 = r100.getOfficialChannelExtraInfo();
        if (r101 == null) goto L7;
        long r102 = r101.getShowStartTime();
    L8:
        long r103 = 1000;
        long r104 = r102 - (com.bytedance.android.livesdk.utils.ntp.e.a() / r103);
        long r105 = this.f153826e;
        Object r106 = null;
        boolean r107 = false;
        if (r104 <= r105) goto L26;
        Object[] r108 = new Object[1];
        long r109 = r103 * r102;
        Result.Companion r110 = Result.Companion;     // Catch: Throwable -> L13
        Object r111 = Result.m9449constructorimpl(new SimpleDateFormat("HH:mm", Locale.CHINA).format(new Date(r109)));     // Catch: Throwable -> L13
    L16:
        if (Result.m9455isFailureimpl(r111) == true) goto L19;
        r106 = r111;
    L19:
        String r112 = (String) r106;
        if (r112 != null) goto L22;
        r112 = "";
    L22:
        r108[0] = r112;
        Aq(s1.C(R.string.ttlive_normal_room_mic_tips_begin, r108));
        y r113 = new y(this, r104);
        View r114 = this.f153822a;
        if (r114 == null) goto L39;
        r114.post(new NormalRoomMicListWidget$doWithAnimation$1(this, true, true, r113));
    L39:
        DataCenter r115 = this.dataCenter;
        if (r115 == null) goto L44;
        Boolean r116 = (Boolean) r115.get("data_is_anchor", Boolean.FALSE);
        if (r116 == null) goto L44;
        r107 = r116.booleanValue();
    L44:
        if (r107 == false) goto L49;
        MicRoomStatusViewModel.a r117 = MicRoomStatusViewModel.Companion;
        DataCenter r118 = this.dataCenter;
        r117.getClass();
        RxUtilKt.c(MicRoomStatusViewModel.a.a(r118).getAnchorCountDown().subscribe(new s(this)), this.f153828g);
        return;
    L49:
        return;
    L13:
        th = move-exception;
        Result.Companion r119 = Result.Companion;
        r111 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L16
    L26:
        if (5 <= r104) goto L29;
    L33:
        View r120 = this.f153825d;
        if (r120 == null) goto L36;
        r120.setBackgroundDrawable(null);
    L36:
        x r121 = new x(this);
        View r122 = this.f153822a;
        if (r122 == null) goto L39;
        r122.post(new NormalRoomMicListWidget$doWithAnimation$1(this, true, false, r121));
        goto L39
    L29:
        if (r105 < r104) goto L33;
        Aq(s1.C(R.string.ttlive_normal_room_mic_tips_begin_count_down, new Object[]{Long.valueOf(r104)}));
        w r123 = new w(this, r104);
        View r124 = this.f153822a;
        if (r124 == null) goto L39;
        r124.post(new NormalRoomMicListWidget$doWithAnimation$1(this, true, true, r123));
    L7:
        r102 = 0;
        goto L8
    }

    public NormalRoomMicListWidget() {
        this.f153826e = 60;
        this.f153828g = new CompositeDisposable();
    }

    public static final float wq(NormalRoomMicListWidget r100) {
        r100.getClass();
        float r101 = UtilityKotlinExtentionsKt.i(16);
        TextView r102 = r100.f153823b;
        if (r102 == null) goto L14;
        TextPaint r103 = r102.getPaint();
        if (r103 == null) goto L14;
        TextView r104 = r100.f153823b;
        if (r104 == null) goto L12;
        CharSequence r105 = r104.getText();
        if (r105 == null) goto L12;
        String r106 = r105.toString();
        if (r106 == null) goto L12;
    L13:
        float r107 = r103.measureText(r106);
    L16:
        return r101 + r107;
    L12:
        r106 = "";
    L14:
        r107 = 0.0f;
        goto L16
    }

    @Override // com.bytedance.android.live.room.x
    public final void Af(Room r100) {
        StringBuilder r101 = new StringBuilder("refresh st:");
        String r102 = null;
        if (r100 == null) goto L7;
        OfficialChannelExtraInfo r103 = r100.getOfficialChannelExtraInfo();
        if (r103 == null) goto L7;
        Long r104 = Long.valueOf(r103.getShowStartTime());
    L8:
        r101.append(r104);
        com.bytedance.android.livesdk.config.setting.r.b(r101.toString());
        this.f153828g.clear();
        Room r105 = this.f153827f;
        if (r105 == null) goto L18;
        OfficialChannelExtraInfo r106 = r105.getOfficialChannelExtraInfo();
        if (r106 == null) goto L18;
        if (r100 == null) goto L16;
        OfficialChannelExtraInfo r107 = r100.getOfficialChannelExtraInfo();
        if (r107 == null) goto L16;
        Long r108 = Long.valueOf(r107.getShowStartTime());
    L17:
        Intrinsics.checkNotNull(r108);
        r106.setShowStartTime(r108.longValue());
    L16:
        r108 = null;
    L18:
        Room r109 = this.f153827f;
        if (r109 == null) goto L27;
        OfficialChannelExtraInfo r110 = r109.getOfficialChannelExtraInfo();
        if (r110 == null) goto L27;
        if (r100 == null) goto L26;
        OfficialChannelExtraInfo r111 = r100.getOfficialChannelExtraInfo();
        if (r111 == null) goto L26;
        r102 = r111.getShowListSchema();
    L26:
        Intrinsics.checkNotNull(r102);
        r110.setShowListSchema(r102);
    L27:
        yq();
        return;
    L7:
        r104 = null;
        goto L8
    }

    public final void Aq(String r100) {
        View r101 = this.f153825d;
        if (r101 == null) goto L5;
        Drawable r102 = r101.getBackground();
    L6:
        if (r102 != null) goto L10;
        View r103 = this.f153825d;
        if (r103 == null) goto L10;
        r103.setBackgroundDrawable(s1.m(R.drawable.ttlive_mic_room_show_list_bg_retangle));
    L10:
        TextView r104 = this.f153823b;
        if (r104 == null) goto L14;
        r104.setText(r100);
        return;
    L14:
        return;
    L5:
        r102 = null;
        goto L6
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        KVData r101 = (KVData) r100;
        Intrinsics.checkNotNullParameter(r101, "kvData");
        if (Intrinsics.areEqual(r101.getKey(), "cmd_mic_room_anchor_status") == false) goto L30;
        Integer r102 = (Integer) r101.getData(0);
        if (r102 != null) goto L8;
        return;
    L8:
        if (r102.intValue() == 3) goto L10;
        return;
    L10:
        if (this.f153827f == null) goto L39;
        com.bytedance.android.livesdk.service.l.d().getClass();
        com.bytedance.android.live.network.c r103 = com.bytedance.android.live.network.c.b();
        if (r103 == null) goto L32;
        RoomRetrofitApi r104 = (RoomRetrofitApi) r103.e(RoomRetrofitApi.class);
        if (r104 == null) goto L33;
        Room r105 = this.f153827f;
        if (r105 == null) goto L19;
        long r106 = r105.f162599id;
    L20:
        Observable<Response<Room>> r107 = r104.getRoomInfoByScene(r106, "ofchannel_anchor_room");
        if (r107 == null) goto L34;
        Observable<Response<Room>> r108 = r107.observeOn(AndroidSchedulers.mainThread());
        if (r108 == null) goto L35;
        Observable<Response<Room>> r109 = r108.subscribeOn(Schedulers.io());
        if (r109 == null) goto L36;
        Disposable r110 = r109.subscribe(new q(this), r.f153885a);
        if (r110 == null) goto L37;
        RxUtilKt.c(r110, this.f153828g);
        return;
    L37:
        return;
    L36:
        return;
    L35:
        return;
    L34:
        return;
    L19:
        r106 = 0;
        goto L20
    L33:
        return;
    L32:
        return;
    L39:
        return;
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget
    public final void onInit(Object[] r100) {
        View r101 = this.contentView;
        View r102 = null;
        if (r101 == null) goto L5;
        View r103 = r101.findViewById(R.id.show_list_entrance_normal);
    L6:
        this.f153822a = r103;
        View r104 = this.contentView;
        if (r104 == null) goto L9;
        TextView r105 = (TextView) r104.findViewById(R.id.count_down_text_normal);
    L10:
        this.f153823b = r105;
        View r106 = this.contentView;
        if (r106 == null) goto L13;
        View r107 = r106.findViewById(R.id.count_down_text_container);
    L14:
        this.f153824c = r107;
        View r108 = this.contentView;
        if (r108 == null) goto L17;
        r102 = r108.findViewById(R.id.show_list_bg_container);
    L17:
        this.f153825d = r102;
        return;
    L13:
        r107 = null;
        goto L14
    L9:
        r105 = null;
        goto L10
    L5:
        r103 = null;
        goto L6
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget
    public final void onLoad(Object[] r100) {
        this.f153828g = new CompositeDisposable();
        View r101 = this.f153824c;
        if (r101 == null) goto L5;
        a1.p(r101, 0);
    L5:
        DataCenter r102 = this.dataCenter;
        if (r102 == null) goto L8;
        r102.observe("cmd_mic_room_anchor_status", this);
    L8:
        t r103 = new t(new AnonymousClass1(this));
        RoomContext r104 = RoomContext.a.c(RoomContext.Companion, this.dataCenter, 0, 2);
        if (r104 == null) goto L17;
        Room r105 = r104.getInteractionDataPrepared().getValue();
        if (r105 == null) goto L14;
        r103.accept(r105);
        return;
    L14:
        ((ObservableSubscribeProxy) r104.getInteractionDataPrepared().a().as(autoDispose())).subscribe(new u(r103));
        return;
    }

    public static final void xq(NormalRoomMicListWidget r100, String r101, boolean r102) {
        r100.getClass();
        if (r101 != null) goto L5;
        return;
    L5:
        if (r101.length() <= 0) goto L7;
        boolean r103 = true;
    L8:
        if (r103 != true) goto L17;
        if (r102 == false) goto L11;
        String r104 = "anchor";
    L12:
        NormalRoomShowListWidget.f153806g.getClass();
        String r105 = NormalRoomShowListWidget.a.a(r101, "user_identity", r104);
        ILiveActionHandler r106 = (ILiveActionHandler) jc1.k.f(ILiveActionHandler.class);
        if (r106 == null) goto L18;
        r106.handle(com.bytedance.android.live.core.utils.a.d(), r105);
        return;
    L18:
        return;
    L11:
        r104 = SourceType.DEFAULT;
        goto L12
    L17:
        return;
    L7:
        r103 = false;
        goto L8
    }

    public final void zq(int r100, int r101, boolean r102) {
        TextView r103 = this.f153823b;
        if (r103 == null) goto L5;
        a1.p(r103, -2);
    L5:
        Disposable r104 = this.f153829h;
        if (r104 != null) goto L8;
    L12:
        Observable.interval(1, TimeUnit.SECONDS).map(new a(r100)).take(r101).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new b(this, r102));
        return;
    L8:
        if (r104.isDisposed() == true) goto L12;
        Disposable r105 = this.f153829h;
        if (r105 == null) goto L12;
        r105.dispose();
        goto L12
    }
}
