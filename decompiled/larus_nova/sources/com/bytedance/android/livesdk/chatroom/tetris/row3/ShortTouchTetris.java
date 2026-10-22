package com.bytedance.android.livesdk.chatroom.tetris.row3;

import android.view.View;
import android.view.ViewGroup;
import com.bytedance.android.live.core.log.g;
import com.bytedance.android.live.core.setting.LiveInfraSettingKeys;
import com.bytedance.android.live.core.tetris.layer.core.tetris.LiveTetris;
import com.bytedance.android.live.core.utils.rxutils.autodispose.AutoDispose;
import com.bytedance.android.live.core.utils.rxutils.autodispose.ObservableSubscribeProxy;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.chatroom.indicator.shortterm.LandscapeShortTermIndicatorWidget;
import com.bytedance.android.livesdk.chatroom.indicator.shortterm.NewLandscapeShortTermWidget;
import com.bytedance.android.livesdk.chatroom.indicator.shortterm.PortraitShortTermIndicatorWidget;
import com.bytedance.android.livesdk.chatroom.utils.VrUtils;
import com.bytedance.android.livesdk.log.b0;
import com.bytedance.android.livesdk.widget.opt.MeasureOptFrameLayout;
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
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import t70.k;
import zg1.m0;
import zg1.n3;
import zg1.q3;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B\u0007¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¨\u0006\n"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/tetris/row3/ShortTouchTetris;", "Lcom/bytedance/android/live/core/tetris/layer/core/tetris/LiveTetris;", "Lcom/bytedance/android/livesdk/widgetdescriptor/e0;", "Lo70/a;", "Lo70/b;", "event", "", "onEvent", "<init>", "()V", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ShortTouchTetris extends LiveTetris<e0> implements o70.a {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final CompositeDisposable f111831o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public ViewGroup f111832p;

    public static final class a<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ShortTouchTetris f111833a;

        public a(ShortTouchTetris r100) {
            this.f111833a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            n3 r101 = (n3) r100;
            int r102 = 0;
            if (VrUtils.t(((e0) this.f111833a.K()).f467480h, false) == false) goto L20;
            ShortTouchTetris r103 = this.f111833a;
            boolean r104 = true;
            if (r101 != null) goto L8;
        L11:
            r103.getClass();
            if (r104 == true) goto L15;
            r102 = 8;
        L15:
            ViewGroup r105 = r103.f111832p;
            if (r105 == null) goto L19;
            r105.setVisibility(r102);
            return;
        L19:
            return;
        L8:
            if (r101.f571889a != true) goto L11;
            r104 = false;
            goto L11
        }
    }

    @Override // o70.a
    public final List<Class<? extends o70.b>> Mg() {
        return CollectionsKt.listOf(m0.class);
    }

    public ShortTouchTetris() {
        this.f111831o = new CompositeDisposable();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.android.live.core.tetris.layer.core.tetris.Tetris
    public final void O() {
        boolean r100 = false;
        if (VrUtils.t(((e0) K()).f467480h, false) == false) goto L19;
        a r101 = new a(this);
        ((ObservableSubscribeProxy) RxBusAbility.INSTANCE.getRxBus(((e0) K()).f467480h).b(n3.class).observeOn(AndroidSchedulers.mainThread()).as(AutoDispose.bind(this))).subscribe(r101);
        RoomContext r102 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r102 == null) goto L12;
        m<Boolean> r103 = r102.getVrInImmersedMode();
        if (r103 == null) goto L12;
        if (r103.getValue().booleanValue() != true) goto L12;
        boolean r104 = false;
    L13:
        if (r104 == false) goto L15;
        int r105 = 0;
    L16:
        ViewGroup r106 = this.f111832p;
        if (r106 == null) goto L19;
        r106.setVisibility(r105);
        goto L19
    L15:
        r105 = 8;
    L12:
        r104 = true;
    L19:
        Room r107 = d90.c.q((d90.a) K());
        if (r107 == null) goto L24;
        RoomAuthStatus r108 = r107.getRoomAuthStatus();
        if (r108 == null) goto L24;
        boolean r109 = r108.enableShortTouch();
    L25:
        if (r109 == true) goto L32;
        if (r107 == null) goto L30;
        RoomAuthStatus r110 = r107.getRoomAuthStatus();
        if (r110 == null) goto L30;
        boolean r111 = r110.enableEnhancedTouch();
    L31:
        if (r111 == true) goto L32;
    L33:
        if (r100 == false) goto L44;
        ViewGroup r112 = this.f111832p;
        if (r112 == null) goto L44;
        if (d90.c.i((d90.a) K()) == false) goto L40;
        LiveTetris.Q(this, PortraitShortTermIndicatorWidget.class, r112, i60.c.f488350a.getValue().booleanValue(), null, 24);
        goto L44
    L40:
        if (com.bytedance.android.livesdk.utils.landscape.d.c(((e0) K()).f467480h) == false) goto L42;
        LiveTetris.Q(this, NewLandscapeShortTermWidget.class, r112, false, null, 24);
        goto L44
    L42:
        LiveTetris.Q(this, LandscapeShortTermIndicatorWidget.class, r112, false, null, 24);
    L44:
        if (LiveInfraSettingKeys.LIVE_ON_MEASURE_OPT_CONFIG.getValue().e() == false) goto L52;
        ViewGroup r113 = this.f111832p;
        if ((r113 instanceof MeasureOptFrameLayout) == false) goto L52;
        if (r113 == null) goto L50;
        ((MeasureOptFrameLayout) r113).setHasFixSize(true);
        b0.o().getClass();
        g.i("ttlive_short_touch", "shortterm measure opt enabled");
        goto L52
    L50:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.widget.opt.MeasureOptFrameLayout");
    L52:
        if (jr1.b.a((d90.d) K()) == false) goto L55;
        Disposable r114 = xs2.b.a().b(q3.class).subscribe(new f(this));
        this.f111831o.add(r114);
        return;
    L55:
        return;
    L30:
        r111 = false;
    L32:
        r100 = true;
    L24:
        r109 = false;
        goto L25
    }

    @Override // com.bytedance.android.live.core.tetris.layer.core.tetris.Tetris
    public final void onDestroy() {
        super.onDestroy();
        this.f111831o.clear();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.android.live.core.tetris.layer.core.tetris.Tetris
    public final View G(k r100) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        if (d90.c.i((d90.a) K()) == false) goto L5;
        View r101 = r100.b(R.layout.ttlive_layout_portrait_short_touch_container);
        this.f111832p = (ViewGroup) r101.findViewById(R.id.portrait_short_term_indicator_container);
        return r101;
    L5:
        View r102 = r100.b(R.layout.ttlive_layout_landscape_short_touch_container);
        this.f111832p = (ViewGroup) r102.findViewById(R.id.short_term_indicator_container_new);
        return r102;
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
