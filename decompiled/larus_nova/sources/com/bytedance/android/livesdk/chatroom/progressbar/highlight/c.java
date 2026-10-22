package com.bytedance.android.livesdk.chatroom.progressbar.highlight;

import android.view.View;
import android.widget.TextView;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.ImageLoader;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.a1;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.livesdk.chatroom.progress.context.PlayerProgressServiceContext;
import com.bytedance.android.livesdk.chatroom.progress.service.IPlayerProgressService;
import com.bytedance.android.livesdk.chatroom.progressbar.ui.PlayerSeekBar;
import com.bytedance.android.livesdk.chatroom.ui.LiveRoundDraweeImageView;
import com.bytedance.android.livesdk.chatroom.vsplayer.api.IVSPlayerService;
import com.bytedance.android.livesdk.chatroom.vsplayer.model.VSPlayerViewControlContext;
import com.bytedance.android.livesdkapi.depend.model.live.episode.EpisodeHighLight;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.live.datacontext.m;
import com.bytedance.live.datacontext.n;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.jvm.internal.Intrinsics;
import py.k;

/* JADX INFO: loaded from: classes7.dex */
public final class c implements com.bytedance.android.livesdk.chatroom.progressbar.c {

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final int f107761r = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Disposable f107762a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Disposable f107763b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public EpisodeHighLight f107764c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Lazy f107765d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Lazy f107766e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Lazy f107767f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Lazy f107768g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Lazy f107769h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f107770i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Lazy f107771j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Lazy f107772k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Lazy f107773l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final View f107774m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final View f107775n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final PlayerSeekBar f107776o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final DataCenter f107777p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final String f107778q;

    public static final class a {
    }

    public final IPlayerProgressService f() {
        return (IPlayerProgressService) this.f107771j.getValue();
    }

    public final View g() {
        return (View) this.f107765d.getValue();
    }

    static {
        f107761r = (int) UtilityKotlinExtentionsKt.h(2.5f);
    }

    @Override // com.bytedance.android.livesdk.chatroom.progressbar.c
    public final void b() {
        Disposable r100 = this.f107762a;
        if (r100 == null) goto L6;
        r100.dispose();
    L6:
        if (h() == true) goto L8;
        return;
    L8:
        View r101 = g();
        if (r101 == null) goto L11;
        UtilityKotlinExtentionsKt.u(r101);
    L11:
        View r102 = this.f107775n;
        if (r102 == null) goto L15;
        r102.setVisibility(this.f107770i);
        return;
    }

    @Override // com.bytedance.android.livesdk.chatroom.progressbar.c
    public final void c() {
        View r100 = this.f107775n;
        if (r100 == null) goto L6;
        this.f107770i = r100.getVisibility();
    L6:
        if (h() == false) goto L11;
        View r101 = this.f107775n;
        if (r101 == null) goto L12;
        r101.setVisibility(8);
        return;
    L12:
        return;
    }

    public final boolean h() {
        View r100 = g();
        if (r100 != null) goto L5;
    L7:
        return false;
    L5:
        if (r100.getVisibility() != 0) goto L7;
        return true;
    }

    @Override // com.bytedance.android.livesdk.chatroom.progressbar.c
    public final boolean isShowing() {
        return h();
    }

    @Override // com.bytedance.android.livesdk.chatroom.progressbar.c
    public final EpisodeHighLight a() {
        return this.f107764c;
    }

    @Override // com.bytedance.android.livesdk.chatroom.progressbar.c
    public final void release() {
        b();
    }

    @Override // com.bytedance.android.livesdk.chatroom.progressbar.c
    public final void d(final com.bytedance.android.livesdk.chatroom.vsplayer.model.e r100) {
        Intrinsics.checkNotNullParameter(r100, "mark");
        com.bytedance.android.livesdk.chatroom.vsplayer.api.c r101 = (com.bytedance.android.livesdk.chatroom.vsplayer.api.c) this.f107773l.getValue();
        if (r101 == null) goto L6;
        r101.resetHideTask();
    L6:
        if (h() == true) goto L8;
        c();
    L8:
        View r102 = this.f107775n;
        if (r102 == null) goto L11;
        UtilityKotlinExtentionsKt.t(r102);
    L11:
        View r103 = g();
        if (r103 == null) goto L14;
        UtilityKotlinExtentionsKt.u(r103);
    L14:
        Disposable r104 = this.f107762a;
        if (r104 == null) goto L17;
        r104.dispose();
    L17:
        IPlayerProgressService r105 = f();
        if (r105 != null) goto L20;
    L24:
        boolean r106 = false;
    L25:
        Disposable r107 = null;
        if (r106 == false) goto L88;
        PlayerProgressServiceContext r108 = (PlayerProgressServiceContext) this.f107772k.getValue();
        if (r108 == null) goto L41;
        n<List<EpisodeHighLight>> r109 = r108.getHighLightList();
        if (r109 == null) goto L41;
        List<EpisodeHighLight> r110 = r109.getValue();
        if (r110 == null) goto L41;
        Iterator<T> r111 = r110.iterator();
    L35:
        if (r111.hasNext() == false) goto L39;
        Object r112 = r111.next();
        if (Intrinsics.areEqual(((EpisodeHighLight) r112).getDescription(), r100.f118421e) == false) goto L35;
    L40:
        final EpisodeHighLight r113 = (EpisodeHighLight) r112;
    L42:
        if (r113 != null) goto L46;
        ALogger.e(this.f107778q, "showHighLightBubbleView: can not find highLightItem for " + r100.f118421e);
        this.f107764c = null;
        return;
    L46:
        if ((!Intrinsics.areEqual(this.f107764c, r113)) == false) goto L76;
        TextView r114 = (TextView) this.f107767f.getValue();
        if (r114 == null) goto L50;
        r114.setText(r113.getDescription());
    L50:
        k r115 = r113.getImage();
        if (r115 != null) goto L53;
    L57:
        LiveRoundDraweeImageView r116 = (LiveRoundDraweeImageView) this.f107766e.getValue();
        if (r116 == null) goto L60;
        UtilityKotlinExtentionsKt.t(r116);
    L60:
        View r117 = (View) this.f107769h.getValue();
        if (r117 == null) goto L63;
        UtilityKotlinExtentionsKt.z(r117, r113.getHot());
    L63:
        View r118 = g();
        if (r118 == null) goto L66;
        UtilityKotlinExtentionsKt.w(r118);
    L66:
        View r119 = (View) this.f107768g.getValue();
        if (r119 == null) goto L69;
        a1.m(r119, 0);
    L69:
        View r120 = g();
        if (r120 == null) goto L72;
        r120.setAlpha(0.0f);
    L72:
        View r121 = g();
        if (r121 == null) goto L75;
        r121.post(new MatchHighLightPopHolder$showHighLightBubbleView$1(this, r100, r113));
    L75:
        this.f107764c = r113;
    L85:
        View.OnClickListener r122 = new MatchHighLightPopHolder$showHighLightBubbleView$onClickListener$1(this, r113);
        View r123 = g();
        if (r123 == null) goto L88;
        r123.setOnClickListener(r122);
        goto L88
    L53:
        if (r115.isValid() != true) goto L57;
        ImageLoader.bindImage((LiveRoundDraweeImageView) this.f107766e.getValue(), r113.getImage());
        LiveRoundDraweeImageView r124 = (LiveRoundDraweeImageView) this.f107766e.getValue();
        if (r124 == null) goto L60;
        UtilityKotlinExtentionsKt.w(r124);
        goto L60
    L76:
        View r125 = g();
        if (r125 == null) goto L79;
        UtilityKotlinExtentionsKt.w(r125);
    L79:
        View r126 = g();
        if (r126 == null) goto L82;
        r126.setAlpha(1.0f);
    L82:
        View r127 = g();
        if (r127 == null) goto L85;
        r127.post(new MatchHighLightPopHolder$showHighLightBubbleView$2(this, r113));
        goto L85
    L39:
        r112 = null;
    L41:
        r113 = null;
    L88:
        com.bytedance.android.livesdk.chatroom.vsplayer.api.c r128 = ((IVSPlayerService) jc1.k.n(IVSPlayerService.class)).provideVSPlayerViewControlService(this.f107777p);
        if (r128 == null) goto L97;
        VSPlayerViewControlContext r129 = r128.provideContext();
        if (r129 == null) goto L97;
        m<Boolean> r130 = r129.getPlayerViewVisible();
        if (r130 == null) goto L97;
        Observable<Boolean> r131 = r130.a();
        if (r131 == null) goto L97;
        r107 = r131.subscribe(new d(this));
    L97:
        this.f107762a = r107;
        this.f107763b = Observable.timer(3000, TimeUnit.MILLISECONDS).compose(RxUtil.rxSchedulerHelper()).subscribe(new e(this));
        return;
    L20:
        if (r105.getHighLightDisplayStatus() != true) goto L24;
        if (((PlayerProgressServiceContext) this.f107772k.getValue()) == null) goto L24;
        r106 = true;
        goto L25
    }

    public static final View e(c r100, int r101) {
        View r102 = r100.f107774m;
        if (r102 != null) goto L7;
        return null;
    L7:
        return r102.findViewById(r101);
    }

    public c(View r100, View r101, PlayerSeekBar r102, DataCenter r103) {
        Intrinsics.checkNotNullParameter("VSProgressBarWidget", "TAG");
        this.f107774m = r100;
        this.f107775n = r101;
        this.f107776o = r102;
        this.f107777p = r103;
        this.f107778q = "VSProgressBarWidget";
        new CompositeDisposable();
        this.f107765d = LazyKt.lazy(new MatchHighLightPopHolder$vsHighLightPopRoot$2(this));
        this.f107766e = LazyKt.lazy(new MatchHighLightPopHolder$vsHighLightPopImg$2(this));
        this.f107767f = LazyKt.lazy(new MatchHighLightPopHolder$vsHighLightPopTitle$2(this));
        this.f107768g = LazyKt.lazy(new MatchHighLightPopHolder$vsHighLightPopArrow$2(this));
        this.f107769h = LazyKt.lazy(LazyThreadSafetyMode.NONE, new MatchHighLightPopHolder$vsHighLightPopHotLabel$2(this));
        this.f107770i = 8;
        this.f107771j = com.bytedance.android.livesdk.chatroom.vs_base.base.a.a(new MatchHighLightPopHolder$progressService$2(this));
        this.f107772k = com.bytedance.android.livesdk.chatroom.vs_base.base.a.a(new MatchHighLightPopHolder$vsProgressContext$2(this));
        this.f107773l = com.bytedance.android.livesdk.chatroom.vs_base.base.a.a(new MatchHighLightPopHolder$playerViewControlService$2(this));
    }
}
