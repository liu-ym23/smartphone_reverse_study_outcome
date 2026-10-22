package com.bytedance.android.livesdk.microom.enhance;

import android.view.View;
import android.widget.TextView;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.rowcontract.RowRecyclableWidget;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.larus.nova.R;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/microom/enhance/MicRoomCenterCountDownWidget;", "Lcom/bytedance/android/live/rowcontract/RowRecyclableWidget;", "<init>", "()V", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class MicRoomCenterCountDownWidget extends RowRecyclableWidget {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public TextView f153819a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public CompositeDisposable f153820b;

    public static final class a<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MicRoomCenterCountDownWidget f153821a;

        public a(MicRoomCenterCountDownWidget r100) {
            this.f153821a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            Boolean r101 = (Boolean) r100;
            View r102 = this.f153821a.contentView;
            if (r102 == null) goto L5;
            UtilityKotlinExtentionsKt.w(r102);
        L5:
            MicRoomCenterCountDownWidget r103 = this.f153821a;
            r103.getClass();
            RxUtilKt.c(Observable.interval(1, TimeUnit.SECONDS).map(new j()).take(5).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new k(r103)), r103.f153820b);
        }
    }

    @Override // com.bytedance.ies.sdk.widgets.Widget
    public final int getLayoutId() {
        return R.layout.ttlive_mic_room_center_count_down_layout;
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget
    public final void onInit(Object[] r100) {
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget
    public final void onUnload() {
        this.f153820b.clear();
    }

    public MicRoomCenterCountDownWidget() {
        this.f153820b = new CompositeDisposable();
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget
    public final void onLoad(Object[] r100) {
        View r101 = this.contentView;
        if (r101 == null) goto L5;
        TextView r102 = (TextView) r101.findViewById(R.id.count_down_text_normal);
    L6:
        this.f153819a = r102;
        View r103 = this.contentView;
        if (r103 == null) goto L9;
        TextView r104 = (TextView) r103.findViewById(R.id.count_down_tips);
    L9:
        View r105 = this.contentView;
        if (r105 == null) goto L12;
        UtilityKotlinExtentionsKt.u(r105);
    L12:
        this.f153820b = new CompositeDisposable();
        MicRoomStatusViewModel.a r106 = MicRoomStatusViewModel.Companion;
        DataCenter r107 = this.dataCenter;
        r106.getClass();
        RxUtilKt.c(MicRoomStatusViewModel.a.a(r107).getCenterCountDown().subscribe(new a(this)), this.f153820b);
        return;
    L5:
        r102 = null;
        goto L6
    }
}
