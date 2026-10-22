package com.bytedance.android.livesdk.chatroom.widget;

import com.bytedance.android.live.browser.IBrowserService;
import com.bytedance.android.live.core.tetris.widgets.LiveWidget;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.livesdkapi.hybridapi.BaseJsBridgeMethodFactory;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/widget/TopicGetParamsMethodWidget;", "Lcom/bytedance/android/live/core/tetris/widgets/LiveWidget;", "<init>", "()V", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class TopicGetParamsMethodWidget extends LiveWidget {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CompositeDisposable f118708a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f118709b;

    public TopicGetParamsMethodWidget() {
        this.f118708a = new CompositeDisposable();
        this.f118709b = LazyKt.lazy(new TopicGetParamsMethodWidget$methodFactory$2(this));
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveWidget, com.bytedance.ies.sdk.widgets.Widget
    public final void onCreate() {
        super.onCreate();
        BaseJsBridgeMethodFactory r100 = (BaseJsBridgeMethodFactory) this.f118709b.getValue();
        if (r100 == null) goto L12;
        IBrowserService r101 = (IBrowserService) jc1.k.f(IBrowserService.class);
        if (r101 == null) goto L13;
        Observable<Unit> r102 = r101.registerExternalMethodFactory(r100);
        if (r102 == null) goto L14;
        Disposable r103 = r102.subscribe();
        if (r103 == null) goto L15;
        RxUtilKt.c(r103, this.f118708a);
        return;
    L15:
        return;
    L14:
        return;
    L13:
        return;
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveWidget, com.bytedance.livesdk.preview.merge.AbsMergeWidget, com.bytedance.ies.sdk.widgets.Widget
    public final void onDestroy() {
        super.onDestroy();
        this.f118708a.clear();
    }
}
