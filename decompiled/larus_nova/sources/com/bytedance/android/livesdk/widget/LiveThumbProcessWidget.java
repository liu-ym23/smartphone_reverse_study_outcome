package com.bytedance.android.livesdk.widget;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.livesdk.chatroom.IRoomContextService;
import com.bytedance.android.livesdk.chatroom.progress.context.PlayerProgressServiceContext;
import com.bytedance.android.livesdk.chatroom.progress.service.IPlayerProgressService;
import com.bytedance.android.livesdk.chatroom.progressbar.IProgressCastService;
import com.larus.nova.R;
import io.reactivex.disposables.CompositeDisposable;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/widget/LiveThumbProcessWidget;", "Lcom/bytedance/android/live/core/tetris/widgets/LiveRecyclableWidget;", "<init>", "()V", "liveroom-middleware_saasRelease"}, k = 1, mv = {1, 4, 3})
public abstract class LiveThumbProcessWidget extends LiveRecyclableWidget {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public IPlayerProgressService f161113a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public PlayerProgressServiceContext f161114b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public LiveThumbProcessViewHolder f161115c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Lazy f161116d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public CompositeDisposable f161117e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public com.bytedance.android.livesdk.chatroom.o f161118f;

    @Override // com.bytedance.ies.sdk.widgets.Widget
    public final int getLayoutId() {
        return R.layout.ttlive_widget_thumb_process_layout;
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget
    public final void onInit(Object[] r100) {
    }

    public abstract IProgressCastService wq();

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget
    public void onUnload() {
        LiveThumbProcessViewHolder r100 = this.f161115c;
        if (r100 == null) goto L8;
        ViewGroup r101 = r100.f161110m;
        View r102 = r100.f161098a;
        if (r102 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("mRootView");
    L7:
        r101.removeView(r102);
        r100.f161105h.dispose();
    L8:
        this.f161115c = null;
        this.f161117e.dispose();
    }

    public LiveThumbProcessWidget() {
        this.f161116d = LazyKt.lazy(new LiveThumbProcessWidget$thumbProcessAreaHolder$2(this));
        this.f161117e = new CompositeDisposable();
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget
    public void onLoad(Object[] r110) {
        this.f161113a = ((rk1.a) jc1.k.n(rk1.a.class)).M4(this.dataCenter);
        this.f161117e = new CompositeDisposable();
        IPlayerProgressService r111 = this.f161113a;
        Boolean r100 = null;
        if (r111 == null) goto L5;
        PlayerProgressServiceContext r112 = r111.provideContext(this.dataCenter);
    L6:
        this.f161114b = r112;
        com.bytedance.android.livesdk.chatroom.o r113 = ((IRoomContextService) jc1.k.n(IRoomContextService.class)).getRoomDataContext(this.dataCenter, 0);
        this.f161118f = r113;
        PlayerProgressServiceContext r101 = this.f161114b;
        if (r101 == null) goto L35;
        if (r113 == null) goto L10;
        Boolean r114 = r113.isVSRoom();
    L11:
        Boolean r102 = Boolean.TRUE;
        if (Intrinsics.areEqual(r114, r102) == false) goto L14;
        int r115 = 2;
    L15:
        com.bytedance.android.livesdk.chatroom.o r103 = this.f161118f;
        if (r103 == null) goto L18;
        Boolean r104 = r103.isVSRoom();
    L20:
        if ((!Intrinsics.areEqual(r104, r102)) == false) goto L22;
        int r105 = 3;
    L23:
        this.f161115c = new LiveThumbProcessViewHolder(this.context, r101, (FrameLayout) this.f161116d.getValue(), wq(), r105, this.dataCenter);
        this.f161117e.add(i80.a.a(r101.getThumbProcessVisibility(), new LiveThumbProcessWidget$initViewHolder$$inlined$let$lambda$1(this)));
        com.bytedance.android.livesdk.chatroom.o r116 = this.f161118f;
        if (r116 == null) goto L27;
        r100 = r116.isVSRoom();
    L27:
        if ((!Intrinsics.areEqual(r100, r102)) == false) goto L36;
        LiveThumbProcessViewHolder r117 = this.f161115c;
        if (r117 == null) goto L37;
        TextView r106 = (TextView) r117.g(R.id.time_middle_line);
        if (r106 == null) goto L38;
        UtilityKotlinExtentionsKt.t((TextView) r117.f161102e.getValue());
        UtilityKotlinExtentionsKt.t(r106);
        return;
    L38:
        return;
    L37:
        return;
    L36:
        return;
    L22:
        r105 = r115;
        goto L23
    L18:
        r104 = null;
        goto L20
    L14:
        r115 = 1;
        goto L15
    L10:
        r114 = null;
        goto L11
    L35:
        return;
    L5:
        r112 = null;
        goto L6
    }
}
