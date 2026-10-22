package com.bytedance.android.livesdk.chatroom.viewmodule.welfare.right;

import com.bytedance.android.live.browser.IBrowserService;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.rxutils.autodispose.ObservableSubscribeProxy;
import com.bytedance.android.live.core.utils.rxutils.j;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.chatroom.viewmodule.welfare.IWelfareApi;
import com.bytedance.android.livesdk.chatroom.widget.RoomRecyclableWidget;
import com.bytedance.android.livesdk.config.qy0;
import com.bytedance.ies.sdk.widgets.DataCenter;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.concurrent.TimeUnit;
import jc1.k;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/viewmodule/welfare/right/WelfareAudienceWelfareServiceWidget;", "Lcom/bytedance/android/livesdk/chatroom/widget/RoomRecyclableWidget;", "<init>", "()V", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class WelfareAudienceWelfareServiceWidget extends RoomRecyclableWidget {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f117637a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final CompositeDisposable f117638b;

    public static final class a<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ WelfareAudienceWelfareServiceWidget f117639a;

        public a(WelfareAudienceWelfareServiceWidget r100) {
            this.f117639a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r110) {
            Long r111 = (Long) r110;
            WelfareAudienceWelfareServiceWidget r112 = this.f117639a;
            DataCenter r100 = r112.dataCenter;
            if (r100 == null) goto L14;
            Long r101 = (Long) r100.get("data_live_welfare_donation_click_count", 0L);
            if (r101 != null) goto L7;
            return;
        L7:
            if (r101.longValue() <= 0) goto L16;
            RoomContext r102 = r112.getDataContext();
            if (r102 == null) goto L17;
            ((IWelfareApi) r112.f117637a.getValue()).reportWelfareClick(r102.getRoom().getValue().f162599id, 0, System.currentTimeMillis() / ((long) 1000), 1).compose(RxUtil.rxSchedulerHelper()).subscribe(new c(r112), d.f117652a);
            return;
        L17:
            return;
        L16:
            return;
        }
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget
    public final void onInit(Object[] r100) {
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget
    public final void onUnload() {
        this.f117638b.dispose();
    }

    public WelfareAudienceWelfareServiceWidget() {
        this.f117637a = LazyKt.lazy(WelfareAudienceWelfareServiceWidget$welfareApi$2.INSTANCE);
        this.f117638b = new CompositeDisposable();
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget
    public final void onLoad(Object[] r100) {
        IBrowserService r101 = (IBrowserService) k.f(IBrowserService.class);
        if (r101 == null) goto L9;
        Observable<Unit> r102 = r101.registerExternalMethodFactory(new b(this));
        if (r102 == null) goto L9;
        ObservableSubscribeProxy r103 = (ObservableSubscribeProxy) r102.as(autoDispose());
        if (r103 == null) goto L9;
        r103.subscribe();
    L9:
        qy0 r104 = qy0.f121092a;
        if (r104.getValue().e() <= 0) goto L13;
        j.a r105 = j.f66356a;
        Disposable r106 = j.a(r104.getValue().e(), r104.getValue().e(), TimeUnit.SECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(new a(this));
        this.f117638b.add(r106);
        return;
    }
}
