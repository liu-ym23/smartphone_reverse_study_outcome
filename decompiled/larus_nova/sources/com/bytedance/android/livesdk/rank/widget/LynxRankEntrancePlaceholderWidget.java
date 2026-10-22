package com.bytedance.android.livesdk.rank.widget;

import com.bytedance.android.live.rowcontract.RowRecyclableWidget;
import com.larus.nova.R;
import io.reactivex.disposables.CompositeDisposable;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/livesdk/rank/widget/LynxRankEntrancePlaceholderWidget;", "Lcom/bytedance/android/live/rowcontract/RowRecyclableWidget;", "Lu70/b;", "<init>", "()V", "liveprofit-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LynxRankEntrancePlaceholderWidget extends RowRecyclableWidget implements u70.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CompositeDisposable f157034a;

    @Override // com.bytedance.ies.sdk.widgets.Widget
    public final int getLayoutId() {
        return R.layout.ttlive_lynx_rank_entrance_placeholder;
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget
    public final void onInit(Object[] r100) {
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget
    public final void onUnload() {
        this.f157034a.dispose();
    }

    public LynxRankEntrancePlaceholderWidget() {
        this.f157034a = new CompositeDisposable();
    }

    @Override // u70.b
    public final void J6(boolean r100) {
        av0.a r101 = yt0.c.j();
        if (r101 != null) goto L5;
        return;
    L5:
        Pair<Boolean, Boolean> r102 = r101.Uc().getFromClient().getValue();
        if (r102 != null) goto L8;
        Boolean r103 = Boolean.FALSE;
        r102 = TuplesKt.to(r103, r103);
    L8:
        r101.Uc().getFromClient().onNext(TuplesKt.to(r102.getFirst(), Boolean.valueOf(r100)));
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget
    public final void onLoad(Object[] r100) {
        Unit r101 = Unit.INSTANCE;
        av0.a r102 = yt0.c.j();
        if (r102 != null) goto L5;
        return;
    L5:
        Pair<Boolean, Boolean> r103 = r102.Uc().getFromClient().getValue();
        if (r103 != null) goto L8;
        Boolean r104 = Boolean.FALSE;
        r103 = TuplesKt.to(r104, r104);
    L8:
        r102.Uc().getFromClient().onNext(TuplesKt.to(r103.getFirst(), Boolean.FALSE));
    }
}
