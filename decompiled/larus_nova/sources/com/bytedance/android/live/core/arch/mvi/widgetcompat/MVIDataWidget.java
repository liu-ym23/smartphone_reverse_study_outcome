package com.bytedance.android.live.core.arch.mvi.widgetcompat;

import com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget;
import com.bytedance.android.livesdk.chatroom.viewmodule.activity.banner.ActivityTopBannerViewIntent;
import com.bytedance.android.livesdk.chatroom.viewmodule.activity.banner.ActivityTopBannerWidget;
import com.bytedance.android.livesdk.chatroom.viewmodule.activity.banner.presenter.TopRightBannerPresenter;
import com.bytedance.android.livesdk.utils.IView;
import com.bytedance.android.livesdk.utils.LiveViewState;
import com.bytedance.android.livesdk.utils.b2;
import com.bytedance.android.livesdk.utils.g2;
import com.bytedance.live.datacontext.DataContext;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u0001*\b\b\u0001\u0010\u0004*\u00020\u0003*\u0014\b\u0002\u0010\u0006*\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00000\u0005*\b\b\u0003\u0010\b*\u00020\u00072\u00020\t2\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\nB\u0007¢\u0006\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lcom/bytedance/android/live/core/arch/mvi/widgetcompat/MVIDataWidget;", "Lcom/bytedance/android/livesdk/utils/g2;", "STATE", "", "INTENT", "Lcom/bytedance/android/livesdk/utils/b2;", "M", "Lcom/bytedance/live/datacontext/DataContext;", "DATA", "Lcom/bytedance/android/live/core/tetris/widgets/LiveRecyclableWidget;", "Lcom/bytedance/android/livesdk/utils/IView;", "<init>", "()V", "livedynamic_saasRelease"}, k = 1, mv = {1, 4, 3})
public abstract class MVIDataWidget<STATE extends g2, INTENT, M extends b2<INTENT, STATE>, DATA extends DataContext> extends LiveRecyclableWidget implements IView<STATE, INTENT, M> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public TopRightBannerPresenter f64750a;

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget
    public void onInit(Object[] r100) {
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget
    public void onUnload() {
        TopRightBannerPresenter r100 = this.f64750a;
        if (r100 == null) goto L6;
        r100.h();
        return;
    }

    public MVIDataWidget() {
    }

    @Override // androidx.lifecycle.Observer
    public /* bridge */ /* synthetic */ void onChanged(Object r100) {
        wq((g2) r100);
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget
    public void onLoad(Object[] r100) {
        TopRightBannerPresenter r101 = ((ActivityTopBannerWidget) this).f115113h;
        this.f64750a = r101;
        if (r101 == null) goto L9;
        LiveViewState r102 = (LiveViewState) r101.f115189m.getValue();
        Intrinsics.checkNotNullParameter(r102, "liveViewState");
        Intrinsics.checkNotNullParameter(r102, "liveViewState");
        r102.observe(this, this);
        TopRightBannerPresenter r103 = this.f64750a;
        if (r103 == null) goto L7;
        r103.b(new a(this));
    L7:
        r101.e();
        return;
    }

    public void wq(STATE r100) {
        ((ActivityTopBannerWidget) this).Lq(r100);
    }

    public final void xq(ActivityTopBannerViewIntent r100) {
        Intrinsics.checkNotNullParameter(r100, "intent");
        TopRightBannerPresenter r101 = this.f64750a;
        if (r101 == null) goto L6;
        r101.c(r100);
        return;
    }
}
