package com.bytedance.android.livesdk.vscore_impl.paidlive.widget;

import android.view.View;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.livesdk.chatroom.progress.context.PlayerTipsContext;
import com.bytedance.android.livesdk.chatroom.vsplayer.api.IVSPlayerService;
import com.bytedance.android.livesdk.chatroom.widget.RoomRecyclableWidget;
import com.bytedance.android.livesdk.vscore_api.paidlive.ability.m;
import com.bytedance.android.livesdk.vscore_api.paidlive.scope.g;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import jc1.k;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import pu2.l;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/livesdk/vscore_impl/paidlive/widget/PaidPlayerTipServiceWidget;", "Lcom/bytedance/android/livesdk/chatroom/widget/RoomRecyclableWidget;", "Lpu2/l;", "<init>", "()V", "vsmain-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PaidPlayerTipServiceWidget extends RoomRecyclableWidget implements l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f160616a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f160617b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f160618c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public CompositeDisposable f160619d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public m f160620e;

    public static final class a<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ PlayerTipsContext f160621a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ PaidPlayerTipServiceWidget f160622b;

        public a(PlayerTipsContext r100, PaidPlayerTipServiceWidget r101) {
            this.f160621a = r100;
            this.f160622b = r101;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            com.bytedance.android.livesdk.chatroom.progress.context.a r101 = (com.bytedance.android.livesdk.chatroom.progress.context.a) r100;
            boolean r102 = true;
            if (Intrinsics.areEqual(r101.f107688a, "paid_live_temp_watch") == false) goto L6;
            this.f160622b.yq(true);
        L11:
            this.f160622b.xq("receive player tip show event:" + r101.f107688a + ", currentShowing:" + this.f160621a.getPlayerTipShowing() + ", conflictKey:" + this.f160622b.f160618c);
            return;
        L6:
            if (r101.f107688a.length() > 0) goto L9;
            r102 = false;
        L9:
            if (r102 == false) goto L11;
            this.f160622b.f160618c = r101.f107688a;
            goto L11
        }
    }

    public static final class b<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ PlayerTipsContext f160623a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ PaidPlayerTipServiceWidget f160624b;

        public b(PlayerTipsContext r100, PaidPlayerTipServiceWidget r101) {
            this.f160623a = r100;
            this.f160624b = r101;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            String r101 = (String) r100;
            if (Intrinsics.areEqual(r101, "paid_live_temp_watch") == false) goto L6;
            this.f160624b.yq(false);
        L8:
            this.f160624b.xq("receive player tip hide event:" + r101 + ", currentShowing:" + this.f160623a.getPlayerTipShowing() + ", conflictKey:" + this.f160624b.f160618c);
            return;
        L6:
            if (Intrinsics.areEqual(this.f160624b.f160618c, r101) == false) goto L8;
            this.f160624b.yq(false);
            this.f160624b.f160618c = "";
            goto L8
        }
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget
    public final void onInit(Object[] r100) {
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget
    public final void onUnload() {
        this.f160619d.dispose();
        yq(false);
        g.d(this.dataCenter).J1(l.class, null);
    }

    public final com.bytedance.android.livesdk.chatroom.vsplayer.api.b wq() {
        IVSPlayerService r100 = (IVSPlayerService) k.f(IVSPlayerService.class);
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.provideVSPlayerTipService(this.dataCenter);
    }

    public PaidPlayerTipServiceWidget() {
        this.f160616a = "PaidPlayerTipServiceWidget[" + hashCode() + ']';
        this.f160618c = "";
        this.f160619d = new CompositeDisposable();
    }

    @Override // pu2.l
    public final m Od() {
        return this.f160620e;
    }

    @Override // pu2.l
    public final void Fm(boolean r100) {
        if (r100 == true) goto L5;
        com.bytedance.android.livesdk.chatroom.vsplayer.api.b r101 = wq();
        if (r101 == null) goto L20;
        r101.hidePlayerTip("paid_live_temp_watch");
    L20:
        yq(false);
        xq("skip updatePaidLivePlayerTipState to " + r100 + ",cuz not paidCamera");
        return;
    L5:
        if (this.f160620e != null) goto L9;
        xq("skip updatePaidLivePlayerTipState to " + r100 + ",cuz null view info");
        return;
    L9:
        if (this.f160617b == true) goto L22;
        xq("[" + hashCode() + "] playerTipShowing false, start showPlayerTipWithCustomView");
        m r102 = this.f160620e;
        if (r102 == null) goto L23;
        View r103 = r102.getView();
        if (r103 == null) goto L24;
        com.bytedance.android.livesdk.chatroom.vsplayer.api.b r104 = wq();
        if (r104 == null) goto L25;
        r104.showPlayerTipWithCustomView("paid_live_temp_watch", r103);
        return;
    L25:
        return;
    L24:
        return;
    L23:
        return;
    }

    @Override // pu2.l
    public final void W6(m r100) {
        Intrinsics.checkNotNullParameter(r100, "tipView");
        this.f160620e = r100;
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget
    public final void onLoad(Object[] r100) {
        this.f160619d.dispose();
        this.f160619d = new CompositeDisposable();
        com.bytedance.android.livesdk.chatroom.vsplayer.api.b r101 = wq();
        if (r101 == null) goto L12;
        PlayerTipsContext r102 = r101.provideVSPlayTipsContext();
        if (r102 == null) goto L12;
        Disposable r103 = r102.getMShowPlayerTipEvent().onEvent().subscribe(new a(r102, this));
        if (r103 == null) goto L9;
        RxUtilKt.c(r103, this.f160619d);
    L9:
        Disposable r104 = r102.getMHidePlayerTipEvent().onEvent().subscribe(new b(r102, this));
        if (r104 == null) goto L12;
        RxUtilKt.c(r104, this.f160619d);
    L12:
        g.d(this.dataCenter).J1(l.class, this);
    }

    public final void xq(String r100) {
        ALogger.i(this.f160616a + '[' + hashCode() + ']', r100);
    }

    public final void yq(boolean r100) {
        xq("[" + hashCode() + "] playerTipShowing change from " + this.f160617b + " to " + r100);
        this.f160617b = r100;
    }
}
