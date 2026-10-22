package com.bytedance.android.livesdk.chatroom.tetris.row3;

import android.view.View;
import android.view.ViewGroup;
import com.bytedance.android.live.core.tetris.layer.core.tetris.LiveTetris;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.core.utils.rxutils.autodispose.AutoDispose;
import com.bytedance.android.live.core.utils.rxutils.autodispose.ObservableSubscribeProxy;
import com.bytedance.android.live.room.api.experience.service.ILiveExpOptService;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.chatroom.utils.VrUtils;
import com.bytedance.android.livesdk.chatroom.viewmodule.TopRightBannerWidget;
import com.bytedance.android.livesdk.config.setting.i;
import com.bytedance.android.livesdk.widgetdescriptor.e0;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.depend.model.live.RoomAuthStatus;
import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.rxbus.RxBusAbility;
import com.bytedance.live.datacontext.m;
import com.larus.nova.R;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.List;
import jc1.k;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import zg1.m0;
import zg1.n3;
import zg1.q3;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B\u0007¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¨\u0006\n"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/tetris/row3/LongTouchTetris;", "Lcom/bytedance/android/live/core/tetris/layer/core/tetris/LiveTetris;", "Lcom/bytedance/android/livesdk/widgetdescriptor/e0;", "Lo70/a;", "Lo70/b;", "event", "", "onEvent", "<init>", "()V", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LongTouchTetris extends LiveTetris<e0> implements o70.a {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final CompositeDisposable f111828o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public ViewGroup f111829p;

    public static final class a<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LongTouchTetris f111830a;

        public a(LongTouchTetris r100) {
            this.f111830a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            n3 r101 = (n3) r100;
            boolean r102 = false;
            if (VrUtils.t(((e0) this.f111830a.K()).f467480h, false) == false) goto L12;
            LongTouchTetris r103 = this.f111830a;
            if (r101 != null) goto L8;
        L9:
            r102 = true;
        L10:
            r103.V(r102);
            return;
        L8:
            if (r101.f571889a == true) goto L10;
        }
    }

    @Override // o70.a
    public final List<Class<? extends o70.b>> Mg() {
        return CollectionsKt.listOf(m0.class);
    }

    public LongTouchTetris() {
        this.f111828o = new CompositeDisposable();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.android.live.core.tetris.layer.core.tetris.Tetris
    public final void O() {
        Room r100 = d90.c.q((d90.a) K());
        boolean r101 = false;
        if (r100 == null) goto L7;
        RoomAuthStatus r102 = r100.getRoomAuthStatus();
        if (r102 == null) goto L7;
        boolean r103 = r102.enableLongTouch();
    L8:
        Room r104 = d90.c.q((d90.a) K());
        if (r104 != null) goto L11;
    L12:
        if (r104 != null) goto L14;
    L16:
        ViewGroup r105 = this.f111829p;
        if (r105 == null) goto L20;
        LiveTetris.Q(this, TopRightBannerWidget.class, r105, true, null, 24);
    L20:
        if (VrUtils.t(((e0) K()).f467480h, false) == false) goto L30;
        ((ObservableSubscribeProxy) RxBusAbility.INSTANCE.getRxBus(((e0) K()).f467480h).b(n3.class).observeOn(AndroidSchedulers.mainThread()).as(AutoDispose.bind(this))).subscribe(new a(this));
        RoomContext r106 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r106 == null) goto L27;
        m<Boolean> r107 = r106.getVrInImmersedMode();
        if (r107 == null) goto L27;
        if (r107.getValue().booleanValue() != true) goto L27;
    L28:
        V(r101);
    L27:
        r101 = true;
    L30:
        if (d90.c.c((d90.a) K()) == false) goto L33;
        Disposable r108 = xs2.b.a().b(q3.class).subscribe(new d(this));
        this.f111828o.add(r108);
    L33:
        if (i.f121210a.K() == true) goto L43;
        ILiveExpOptService r109 = (ILiveExpOptService) k.f(ILiveExpOptService.class);
        if (r109 == null) goto L41;
        Disposable r110 = r109.registerExpBizListener(l61.d.a.e0.f507610e, new e(this));
        if (r110 == null) goto L42;
        RxUtilKt.c(r110, this.f111828o);
        return;
    L42:
        return;
    L41:
        return;
    L43:
        return;
    L14:
        if (r104.isMergeVSRoom() != true) goto L16;
    L15:
        if (r103 == false) goto L20;
    L11:
        if (r104.isMediaRoom() == true) goto L15;
    L7:
        r103 = false;
        goto L8
    }

    @Override // com.bytedance.android.live.core.tetris.layer.core.tetris.Tetris
    public final void onDestroy() {
        super.onDestroy();
        this.f111828o.clear();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.android.live.core.tetris.layer.core.tetris.Tetris
    public final View G(t70.k r100) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        if (d90.c.i((d90.a) K()) == false) goto L5;
        View r101 = r100.b(R.layout.ttlive_layout_portrait_long_touch_container);
        this.f111829p = (ViewGroup) r101.findViewById(R.id.portrait_task_indicator_container);
        return r101;
    L5:
        View r102 = r100.b(R.layout.ttlive_layout_landscape_long_touch_container);
        this.f111829p = (ViewGroup) r102.findViewById(R.id.landscape_top_left_task_banner);
        return r102;
    }

    public final void V(boolean r100) {
        if (r100 == false) goto L4;
        int r101 = 0;
    L5:
        ViewGroup r102 = this.f111829p;
        if (r102 == null) goto L9;
        r102.setVisibility(r101);
        return;
    L9:
        return;
    L4:
        r101 = 8;
        goto L5
    }

    @Override // o70.a
    public void onEvent(o70.b r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        if ((r100 instanceof m0) == false) goto L10;
        boolean r101 = ((m0) r100).f571878a;
        View r102 = L();
        if (r101 == false) goto L7;
        float r103 = 0.0f;
    L8:
        r102.setAlpha(r103);
        return;
    L7:
        r103 = 1.0f;
        goto L8
    }
}
