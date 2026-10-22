package com.bytedance.android.livesdk.interactivity.api;

import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.rxutils.autodispose.AutoDispose;
import com.bytedance.android.live.core.utils.rxutils.autodispose.ObservableSubscribeProxy;
import com.bytedance.android.livesdk.interactivity.api.roomintro.api.RoomIntroApi;
import com.bytedance.android.livesdk.interactivity.roomintro.view.RoomIntroDialog;
import com.bytedance.android.livesdk.interactivity.roomintro.view.RoomIntroDialogV2;
import com.bytedance.android.livesdk.interactivity.roomintro.view.b0;
import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import io.reactivex.Observable;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import r52.a4;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0017\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0018\u0010\u0019J|\u0010\u0014\u001a\u00020\r2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0014\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f2#\u0010\u0013\u001a\u001f\u0012\u0013\u0012\u00110\u000f¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0012\u0012\u0004\u0012\u00020\r\u0018\u00010\fH\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\b\u0010\u0017\u001a\u00020\u0016H\u0016¨\u0006\u001a"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/api/RoomIntroService;", "Lcom/bytedance/android/livesdk/interactivity/api/IRoomIntroService;", "Landroidx/fragment/app/FragmentActivity;", "activity", "Lcom/bytedance/android/livesdkapi/depend/model/live/Room;", "room", "Lcom/bytedance/android/livesdkapi/depend/model/live/LiveMode;", "liveMode", "", "gameCategory", "Lgz/b;", "inputPoiStruct", "Lkotlin/Function1;", "", "poiChangeCallback", "", "Lkotlin/ParameterName;", "name", "isNewRoomIntroOn", "onRoomIntroChangeCallback", "openRoomIntroDialog", "(Landroidx/fragment/app/FragmentActivity;Lcom/bytedance/android/livesdkapi/depend/model/live/Room;Lcom/bytedance/android/livesdkapi/depend/model/live/LiveMode;Ljava/lang/Long;Lgz/b;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "", "getRoomIntroDialogTag", "<init>", "()V", "interactivity-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public class RoomIntroService implements IRoomIntroService {
    public RoomIntroService() {
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.IRoomIntroService
    public String getRoomIntroDialogTag() {
        return "com.bytedance.android.livesdk.interactivity.roomintro.view.RoomIntroDialog";
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.IRoomIntroService
    public void openRoomIntroDialog(FragmentActivity r110, Room r111, LiveMode r112, Long r113, gz.b r114, Function1<? super gz.b, Unit> r115, Function1<? super Boolean, Unit> r116) {
        if (a4.f536150a.getValue().a() == false) goto L12;
        int r100 = RoomIntroDialogV2.f140697u;
        com.bytedance.android.livesdk.interactivity.roomintro.v2.c r101 = new com.bytedance.android.livesdk.interactivity.roomintro.v2.c(r111, r112, r113, r114, r115, r116);
        Intrinsics.checkNotNullParameter(r101, "params");
        if (r110 == null) goto L27;
        Observable<R> r102 = ((RoomIntroApi) com.bytedance.android.live.network.c.b().e(RoomIntroApi.class)).getRoomIntro(r101.d(), r101.c(), r101.b()).compose(RxUtil.rxSchedulerHelper());
        if (r102 == 0) goto L22;
        ObservableSubscribeProxy r103 = (ObservableSubscribeProxy) r102.as(AutoDispose.bind(r110));
        if (r103 == null) goto L23;
        r103.subscribe(new com.bytedance.android.livesdk.interactivity.roomintro.view.m(r110, r101), new com.bytedance.android.livesdk.interactivity.roomintro.view.n(r110));
        return;
    L23:
        return;
    L22:
        return;
    L27:
        return;
    L12:
        int r104 = RoomIntroDialog.f140674l;
        Intrinsics.checkNotNull(r110);
        b0 r105 = new b0(r111, r112, r113);
        Intrinsics.checkNotNullParameter(r110, "activity");
        Intrinsics.checkNotNullParameter(r105, "params");
        RoomIntroApi r106 = (RoomIntroApi) com.bytedance.android.live.network.c.b().e(RoomIntroApi.class);
        if (r111 == null) goto L15;
        Long r107 = Long.valueOf(r111.f162599id);
    L16:
        Observable<R> r108 = r106.getRoomIntro(r107, r105.c(), r105.b()).compose(RxUtil.rxSchedulerHelper());
        if (r108 == 0) goto L25;
        ObservableSubscribeProxy r109 = (ObservableSubscribeProxy) r108.as(AutoDispose.bind(r110));
        if (r109 == null) goto L26;
        r109.subscribe(new com.bytedance.android.livesdk.interactivity.roomintro.view.a(r110, r105), new com.bytedance.android.livesdk.interactivity.roomintro.view.b(r110));
        return;
    L26:
        return;
    L25:
        return;
    L15:
        r107 = null;
        goto L16
    }
}
