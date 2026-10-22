package com.bytedance.android.live.componentsmarket.impl.components.close;

import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModel;
import com.bytedance.android.live.componentsmarket.impl.components.BaseComponentsTetris;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.setting.c0;
import com.bytedance.android.live.core.setting.f0;
import com.bytedance.android.live.core.tetris.widgets.y;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.chatroom.vsplayer.model.PlayerViewControl;
import com.bytedance.android.livesdk.config.fl;
import com.bytedance.android.livesdk.r3;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.config.FirstCompShowConfig;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.KVData;
import com.bytedance.live.datacontext.j;
import com.larus.nova.R;
import ev1.p;
import io.reactivex.Observable;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import java.util.List;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import t70.k;

/* JADX INFO: loaded from: classes45.dex */
@PlayerViewControl(key = PlayerViewControl.KEY.MatchRoomCount, needDynamicControl = true, type = PlayerViewControl.Type.TOP)
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u00022\u00020\u00042\u00020\u0005B\u0007¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¨\u0006\f"}, d2 = {"Lcom/bytedance/android/live/componentsmarket/impl/components/close/RoomCloseWidget;", "Lcom/bytedance/android/live/componentsmarket/impl/components/BaseComponentsTetris;", "Lcom/ss/android/ugc/aweme/compat/nullable/Observer;", "Lcom/bytedance/ies/sdk/widgets/KVData;", "Lo70/a;", "Lp70/d;", "Lo70/b;", "event", "", "onEvent", "<init>", "()V", "livecomponentsmarket-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class RoomCloseWidget extends BaseComponentsTetris implements o70.a, p70.d {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final String f64629s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public Disposable f64630t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final Lazy f64631u;

    @Override // o70.a
    public final List<Class<? extends o70.b>> Mg() {
        return CollectionsKt.listOf(new Class[]{bh1.a.class, bh1.b.class});
    }

    @Override // com.bytedance.android.live.componentsmarket.impl.components.BaseComponentsTetris
    public final ViewModel a0(FragmentActivity r100) {
        Intrinsics.checkNotNullParameter(r100, "cxt");
        return null;
    }

    @Override // com.bytedance.android.live.componentsmarket.impl.components.BaseComponentsTetris
    public final o40.a c0() {
        return null;
    }

    @Override // com.bytedance.android.live.componentsmarket.impl.components.BaseComponentsTetris
    public final void d0() {
    }

    @Override // p70.d
    public final Set<p70.c<?>> ud() {
        return SetsKt.setOf((RoomCloseWidget$fullInterceptProcessor$2.a) this.f64631u.getValue());
    }

    public RoomCloseWidget() {
        this.f64629s = "RoomCloseWidget";
        this.f64631u = LazyKt.lazy(new RoomCloseWidget$fullInterceptProcessor$2(this));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.android.live.componentsmarket.impl.components.BaseComponentsTetris, com.bytedance.android.live.core.tetris.layer.core.tetris.Tetris
    public final void O() {
        super.O();
        d90.a r100 = (d90.a) K();
        final f r101 = new f(this, r100);
        if (f0.f65293a.getValue().booleanValue() == false) goto L7;
        ViewGroup r102 = Z();
        if (r102 == null) goto L16;
        UtilityKotlinExtentionsKt.w(r102);
    L16:
        r3.c(Z(), s1.B(R.string.ttlive_label_close), true);
        DataCenter r103 = ((d90.a) K()).f467480h;
        if (r103 == null) goto L19;
        r103.observe("data_media_introduction_showing", this);
    L19:
        DataCenter r104 = ((d90.a) K()).f467480h;
        if (r104 == null) goto L23;
        r104.observe("cmd_p0_widget_loaded", this);
    L23:
        if (fl.f120213a.getValue().booleanValue() == false) goto L40;
        DataCenter r105 = ((d90.a) K()).f467480h;
        if (r105 == null) goto L30;
        Boolean r106 = (Boolean) r105.get("enable_rxjava_async", Boolean.FALSE);
        if (r106 == null) goto L30;
        boolean r107 = r106.booleanValue();
    L31:
        Observable r108 = xs2.b.a().b(y.class).filter(new g(this));
        if (r107 == false) goto L34;
        Scheduler r109 = Schedulers.io();
    L35:
        Disposable r110 = r108.subscribeOn(r109).observeOn(AndroidSchedulers.mainThread()).subscribe(new h(this));
        Disposable r111 = this.f64630t;
        if (r111 == null) goto L38;
        r111.dispose();
    L38:
        this.f64630t = r110;
        goto L40
    L34:
        r109 = AndroidSchedulers.mainThread();
    L30:
        r107 = false;
    L40:
        if (FirstCompShowConfig.INSTANCE.isDelayClose() == false) goto L45;
        ViewGroup r112 = Z();
        if (r112 == null) goto L46;
        UtilityKotlinExtentionsKt.u(r112);
        return;
    L46:
        return;
    L45:
        return;
    L7:
        RoomContext.a r113 = RoomContext.Companion;
        DataCenter r114 = r100.f467480h;
        Room r115 = d90.c.q(r100);
        if (r115 == null) goto L10;
        long r116 = r115.getRoomId();
    L11:
        r113.getClass();
        RoomContext r117 = RoomContext.a.a(r114, r116);
        if (r117 == null) goto L16;
        j<com.bytedance.android.livesdk.widget.schedule.c> r118 = r117.getWidgetLoadTaskScheduler();
        if (r118 == null) goto L16;
        r118.c(new RoomCloseWidget$initCloseLayout$1(this, r101));
        goto L16
    L10:
        r116 = 0;
        goto L11
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.android.live.componentsmarket.impl.components.BaseComponentsTetris, com.bytedance.android.live.core.tetris.layer.core.tetris.Tetris
    public final void onDestroy() {
        super.onDestroy();
        if (c0.f65268a.getValue().booleanValue() == false) goto L7;
        DataCenter r100 = ((d90.a) K()).f467480h;
        if (r100 == null) goto L7;
        r100.removeObserver("data_media_introduction_showing", this);
    L7:
        DataCenter r101 = ((d90.a) K()).f467480h;
        if (r101 == null) goto L10;
        r101.removeObserver("cmd_p0_widget_loaded", this);
    L10:
        Disposable r102 = this.f64630t;
        if (r102 == null) goto L13;
        r102.dispose();
    L13:
        this.f64630t = null;
    }

    @Override // com.bytedance.android.live.componentsmarket.impl.components.BaseComponentsTetris, com.bytedance.android.live.core.tetris.layer.core.tetris.Tetris
    public final View G(k r100) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        return super.G(r100);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.android.live.componentsmarket.impl.components.BaseComponentsTetris
    public final ConstraintLayout b0(k r100) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        if (p.e(((d90.a) K()).f467480h) == false) goto L6;
        int r101 = R.layout.ttlive_close_widget_with_more;
    L17:
        View r102 = r100.b(r101);
        if (r102 == null) goto L22;
        return (ConstraintLayout) r102;
    L22:
        throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout");
    L6:
        if (p.f(((d90.a) K()).f467480h) == false) goto L8;
        r101 = R.layout.ttlive_more_toolbar_top_right;
        goto L17
    L8:
        DataCenter r103 = ((d90.a) K()).f467480h;
        p.f474226a.getClass();
        if (p.d(r103) == true) goto L11;
    L13:
        boolean r104 = false;
    L14:
        if (r104 == false) goto L16;
        r101 = R.layout.ttlive_close_widget_circle;
        goto L17
    L16:
        r101 = R.layout.ttlive_close_widget;
        goto L17
    L11:
        if (p.a(r103) != 3) goto L13;
        r104 = true;
        goto L14
    }

    @Override // com.bytedance.android.live.componentsmarket.impl.components.BaseComponentsTetris
    public final void g0(KVData r100) {
        if (r100 == null) goto L4;
        String r101 = r100.getKey();
    L5:
        if (r101 == null) goto L46;
        int r102 = r101.hashCode();
        if (r102 == (-1575056762)) goto L27;
        if (r102 == 309908432) goto L13;
        return;
    L13:
        if (r101.equals("data_media_introduction_showing") == false) goto L38;
        Boolean r103 = Boolean.FALSE;
        Boolean r104 = (Boolean) r100.getData(r103);
        if (r104 == null) goto L19;
        r103 = r104;
    L19:
        if (r103.booleanValue() == false) goto L23;
        ViewGroup r105 = Z();
        if (r105 == null) goto L39;
        r105.setImportantForAccessibility(4);
        return;
    L39:
        return;
    L23:
        ViewGroup r106 = Z();
        if (r106 == null) goto L41;
        r106.setImportantForAccessibility(0);
        return;
    L41:
        return;
    L38:
        return;
    L27:
        if (r101.equals("cmd_p0_widget_loaded") == true) goto L29;
        return;
    L29:
        if (FirstCompShowConfig.INSTANCE.isDelayClose() == false) goto L44;
        Boolean r107 = Boolean.FALSE;
        Boolean r108 = (Boolean) r100.getData(r107);
        if (r108 == null) goto L35;
        r107 = r108;
    L35:
        if (r107.booleanValue() == false) goto L45;
        UtilityKotlinExtentionsKt.w(Z());
        return;
    L45:
        return;
    L44:
        return;
    L46:
        return;
    L4:
        r101 = null;
        goto L5
    }

    @Override // com.bytedance.android.live.componentsmarket.impl.components.BaseComponentsTetris, androidx.lifecycle.Observer
    public final /* bridge */ /* synthetic */ void onChanged(Object r100) {
        g0((KVData) r100);
    }

    @Override // o70.a
    public void onEvent(o70.b r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        if ((r100 instanceof bh1.b) == false) goto L8;
        int r101 = ((bh1.b) r100).f18997a;
        ViewGroup r102 = Z();
        if (r102 == null) goto L19;
        r102.setTranslationY(r101);
        return;
    L19:
        return;
    L8:
        if ((r100 instanceof bh1.a) == false) goto L21;
        bh1.a r103 = (bh1.a) r100;
        boolean r104 = r103.f18995a;
        boolean r105 = r103.f18996b;
        if (r104 == false) goto L12;
        int r106 = 4;
    L13:
        ALogger.i(this.f64629s, "setAllViewsVisibility " + r106);
        if (r105 == true) goto L22;
        ViewGroup r107 = Z();
        if (r107 == null) goto L23;
        r107.setVisibility(r106);
        return;
    L23:
        return;
    L22:
        return;
    L12:
        r106 = 0;
        goto L13
    }
}
