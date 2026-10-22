package com.bytedance.android.livesdk.vscore_impl.paidlive.ablity.playertip.replay;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.core.utils.rxutils.autodispose.AutoDispose;
import com.bytedance.android.live.core.utils.rxutils.autodispose.ObservableSubscribeProxy;
import com.bytedance.android.live.core.utils.v;
import com.bytedance.android.livesdk.chatroom.vs_base.base.ReplayDataContext;
import com.bytedance.android.livesdk.projectmode.ILiveSdkProjectModeService;
import com.bytedance.android.livesdk.utils.q6;
import com.bytedance.android.livesdk.vscore_api.paidlive.ability.TempWatchPlayerTipUiInfo;
import com.bytedance.android.livesdk.vscore_api.paidlive.ability.i;
import com.bytedance.android.livesdk.vscore_api.paidlive.ability.m;
import com.bytedance.android.livesdk.vscore_api.paidlive.scope.g;
import com.bytedance.android.livesdk.vscore_impl.paidlive.f;
import com.bytedance.android.livesdkapi.depend.model.live.episode.Episode;
import com.bytedance.android.livesdkapi.depend.model.live.episode.main.IMainEpisode;
import com.larus.nova.R;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.concurrent.TimeUnit;
import jc1.k;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import nm1.e;
import pu2.l;

/* JADX INFO: loaded from: classes11.dex */
public final class PaidReplayCameraTempWatchPlayerTipView implements m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f160288a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f160289b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public View f160290c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public TextView f160291d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public View f160292e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public TextView f160293f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public TempWatchPlayerTipUiInfo f160294g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public CompositeDisposable f160295h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final com.bytedance.android.livesdk.vscore_api.paidlive.scope.a f160296i;

    public static final class a<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ PaidReplayCameraTempWatchPlayerTipView f160297a;

        public a(PaidReplayCameraTempWatchPlayerTipView r100) {
            this.f160297a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            TempWatchPlayerTipUiInfo r101 = this.f160297a.f160294g;
            if (r101 == null) goto L8;
            Function0<Unit> r102 = r101.f159406c;
            if (r102 == null) goto L9;
            Unit r103 = r102.invoke();
            return;
        L9:
            return;
        }
    }

    public static final class b implements View.OnLongClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ PaidReplayCameraTempWatchPlayerTipView f160298a;

        public b(PaidReplayCameraTempWatchPlayerTipView r100) {
            this.f160298a = r100;
        }

        @Override // android.view.View.OnLongClickListener
        public final boolean onLongClick(View r100) {
            ILiveSdkProjectModeService r101 = (ILiveSdkProjectModeService) k.f(ILiveSdkProjectModeService.class);
            if (r101 == null) goto L7;
            r101.openPaidLiveDebugWindow(this.f160298a.f160296i);
            return true;
        L7:
            return true;
        }
    }

    @Override // com.bytedance.android.scope.o
    public final void onStart() {
    }

    public final IMainEpisode a() {
        Episode r100 = this.f160296i.D().getEpisode().invoke();
        if (r100 != null) goto L7;
        return null;
    L7:
        return (IMainEpisode) r100.castToOrNull(IMainEpisode.class);
    }

    public final l c() {
        return (l) g.b(this.f160296i).w1(l.class);
    }

    public final void d() {
        CompositeDisposable r100 = this.f160295h;
        if (r100 == null) goto L5;
        r100.clear();
    L5:
        this.f160295h = new CompositeDisposable();
        View r101 = (View) this.f160289b.getValue();
        TextView r102 = null;
        if (r101 == null) goto L8;
        View r103 = r101.findViewById(R.id.paid_live_tip_temp_root);
    L9:
        this.f160290c = r103;
        if (r103 == null) goto L12;
        r103.setLayoutParams(new ViewGroup.LayoutParams(-2, UtilityKotlinExtentionsKt.i(29)));
    L12:
        View r104 = (View) this.f160289b.getValue();
        if (r104 == null) goto L15;
        TextView r105 = (TextView) r104.findViewById(R.id.paid_live_tip_temp_timing);
    L16:
        this.f160291d = r105;
        if (r105 == null) goto L20;
        UtilityKotlinExtentionsKt.t(r105);
    L20:
        if (v.a() == false) goto L24;
        TextView r106 = this.f160291d;
        if (r106 == null) goto L24;
        r106.setOnLongClickListener(new b(this));
    L24:
        View r107 = (View) this.f160289b.getValue();
        if (r107 == null) goto L27;
        View r108 = r107.findViewById(R.id.paid_live_tip_temp_open_panel);
    L28:
        this.f160292e = r108;
        if (r108 == null) goto L35;
        Object r109 = n80.a.f518238a;
        Observable<Object> r110 = new n80.b(r108).throttleFirst(500, TimeUnit.MILLISECONDS);
        if (r110 == null) goto L35;
        Disposable r111 = r110.subscribe(new a(this));
        if (r111 == null) goto L35;
        RxUtilKt.c(r111, this.f160295h);
    L35:
        View r112 = (View) this.f160289b.getValue();
        if (r112 == null) goto L38;
        r102 = (TextView) r112.findViewById(R.id.paid_live_tip_temp_open_panel_text);
    L38:
        this.f160293f = r102;
        View r113 = this.f160292e;
        if (r113 == null) goto L42;
        UtilityKotlinExtentionsKt.t(r113);
        return;
    L42:
        return;
    L27:
        r108 = null;
        goto L28
    L15:
        r105 = null;
        goto L16
    L8:
        r103 = null;
        goto L9
    }

    @Override // com.bytedance.android.livesdk.vscore_api.paidlive.ability.m
    public final View getView() {
        if (this.f160291d != null) goto L5;
    L6:
        d();
    L8:
        return (View) this.f160289b.getValue();
    L5:
        if (this.f160292e != null) goto L8;
        goto L6
    }

    @Override // com.bytedance.android.scope.o
    public final void onStop() {
        CompositeDisposable r100 = this.f160295h;
        if (r100 == null) goto L5;
        r100.clear();
    L5:
        this.f160295h = null;
    }

    @Override // com.bytedance.android.livesdk.vscore_api.paidlive.ability.m
    public final void Tn() {
        l r100 = c();
        if (r100 == null) goto L5;
        r100.Fm(false);
    L5:
        View r101 = this.f160290c;
        if (r101 == null) goto L8;
        UtilityKotlinExtentionsKt.t(r101);
    L8:
        TextView r102 = this.f160291d;
        if (r102 == null) goto L11;
        r102.setText("");
    L11:
        TextView r103 = this.f160291d;
        if (r103 == null) goto L14;
        UtilityKotlinExtentionsKt.t(r103);
    L14:
        View r104 = this.f160292e;
        if (r104 == null) goto L17;
        UtilityKotlinExtentionsKt.t(r104);
    L17:
        i r105 = f.h(this.f160296i);
        if (r105 == null) goto L21;
        r105.L2();
        return;
    }

    public PaidReplayCameraTempWatchPlayerTipView(com.bytedance.android.livesdk.vscore_api.paidlive.scope.a r100) {
        Intrinsics.checkNotNullParameter(r100, "attachScene");
        this.f160296i = r100;
        this.f160288a = "PaidReplayCameraTempWatchPlayerTipView[" + hashCode() + "][" + r100.i0() + "][" + r100.w0() + ']';
        this.f160289b = LazyKt.lazy(new PaidReplayCameraTempWatchPlayerTipView$playerTipTimingView$2(this));
        e r101 = pm1.f.c();
        if (r101 == null) goto L14;
        ReplayDataContext r102 = r101.h(r100.D().getDataCenter());
        if (r102 == null) goto L15;
        com.bytedance.live.datacontext.m<Boolean> r103 = r102.isPortrait();
        if (r103 == null) goto L16;
        Observable<Boolean> r104 = r103.a();
        if (r104 == null) goto L17;
        ObservableSubscribeProxy r105 = (ObservableSubscribeProxy) r104.as(AutoDispose.bind(r100.D().g()));
        if (r105 == null) goto L18;
        r105.subscribe(new com.bytedance.android.livesdk.vscore_impl.paidlive.ablity.playertip.replay.a(this));
        return;
    L18:
        return;
    L17:
        return;
    L16:
        return;
    L15:
        return;
    }

    @Override // com.bytedance.android.livesdk.vscore_api.paidlive.ability.m
    public final void C0(long r100) {
        IMainEpisode r101 = a();
        if (r101 != null) goto L5;
    L6:
        IMainEpisode r102 = a();
        if (r102 != null) goto L9;
    L11:
        boolean r103 = false;
    L12:
        if (r103 == true) goto L14;
        return;
    L14:
        TempWatchPlayerTipUiInfo r104 = this.f160294g;
        if (r104 != null) goto L17;
    L42:
        l r105 = c();
        if (r105 == null) goto L45;
        m r106 = r105.Od();
    L47:
        if ((!Intrinsics.areEqual(r106, this)) == false) goto L51;
        l r107 = c();
        if (r107 == null) goto L51;
        r107.W6(this);
    L51:
        l r108 = c();
        if (r108 == null) goto L55;
        r108.Fm(true);
        return;
    L55:
        return;
    L45:
        r106 = null;
        goto L47
    L17:
        if (r100 <= 0) goto L30;
        String r109 = q6.c(r100 * ((long) 1000));
        TextView r110 = this.f160291d;
        if (r110 == null) goto L21;
        r110.setText(String.valueOf(StringsKt.replace$default(r104.f159404a, "%time%", r109, false, 4, null)));
    L21:
        TextView r111 = this.f160291d;
        if (r111 == null) goto L24;
        UtilityKotlinExtentionsKt.w(r111);
    L24:
        View r112 = this.f160292e;
        if (r112 == null) goto L27;
        UtilityKotlinExtentionsKt.w(r112);
    L27:
        View r113 = this.f160290c;
        if (r113 == null) goto L42;
        UtilityKotlinExtentionsKt.w(r113);
        goto L42
    L30:
        TextView r114 = this.f160291d;
        if (r114 == null) goto L33;
        r114.setText("");
    L33:
        TextView r115 = this.f160291d;
        if (r115 == null) goto L36;
        UtilityKotlinExtentionsKt.t(r115);
    L36:
        View r116 = this.f160292e;
        if (r116 == null) goto L39;
        UtilityKotlinExtentionsKt.t(r116);
    L39:
        View r117 = this.f160290c;
        if (r117 == null) goto L42;
        UtilityKotlinExtentionsKt.t(r117);
        goto L42
    L9:
        if (r102.isPrivilegeCameraReplay() != true) goto L11;
    L10:
        r103 = true;
        goto L12
    L5:
        if (r101.isPaidCameraReplay() == true) goto L10;
        goto L6
    }

    @Override // com.bytedance.android.livesdk.vscore_api.paidlive.ability.m
    public final void Sn(TempWatchPlayerTipUiInfo r100) {
        this.f160294g = r100;
    }

    @Override // com.bytedance.android.livesdk.vscore_api.paidlive.ability.m
    public final void k8(boolean r100) {
        ALogger.i(this.f160288a, " onPlayerTipShow");
        IMainEpisode r101 = a();
        if (r101 != null) goto L5;
    L6:
        IMainEpisode r102 = a();
        if (r102 != null) goto L9;
    L11:
        boolean r103 = false;
    L12:
        if (r103 == true) goto L24;
        View r104 = this.f160290c;
        if (r104 == null) goto L16;
        UtilityKotlinExtentionsKt.t(r104);
    L16:
        TextView r105 = this.f160291d;
        if (r105 == null) goto L19;
        UtilityKotlinExtentionsKt.t(r105);
    L19:
        View r106 = this.f160292e;
        if (r106 == null) goto L47;
        UtilityKotlinExtentionsKt.t(r106);
        return;
    L47:
        return;
    L24:
        if (this.f160291d != null) goto L26;
    L27:
        d();
    L28:
        TextView r107 = this.f160293f;
        if (r107 == null) goto L35;
        TempWatchPlayerTipUiInfo r108 = this.f160294g;
        if (r108 == null) goto L33;
        String r109 = r108.f159405b;
    L34:
        r107.setText(r109);
        goto L35
    L33:
        r109 = null;
    L35:
        l r110 = c();
        if (r110 == null) goto L38;
        r110.W6(this);
    L38:
        l r111 = c();
        if (r111 == null) goto L41;
        r111.Fm(true);
    L41:
        String r112 = c() + " updatePaidLivePlayerTipState true";
        ALogger.i(this.f160288a, " " + r112);
        if (r100 == false) goto L48;
        i r113 = f.h(this.f160296i);
        if (r113 == null) goto L49;
        r113.ca();
        return;
    L49:
        return;
    L48:
        return;
    L26:
        if (this.f160292e != null) goto L28;
    L9:
        if (r102.isPrivilegeCameraReplay() != true) goto L11;
    L10:
        r103 = true;
        goto L12
    L5:
        if (r101.isPaidCameraReplay() == true) goto L10;
        goto L6
    }
}
