package com.bytedance.android.livesdk.chatroom.widget;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.platform.comapi.map.MapController;
import com.bytedance.android.live.core.anim.LiveDegradeFpsAnimator;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.livesdk.chatroom.progress.service.IPlayerProgressService;
import com.bytedance.android.livesdk.chatroom.vsplayer.api.IVSPlayerService;
import com.bytedance.android.livesdk.chatroom.vsplayer.model.PlayerViewControl;
import com.bytedance.android.livesdk.chatroom.vsplayer.model.VSPlayerViewControlContext;
import com.bytedance.android.livesdk.r3;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.episode.EpisodeHighLight;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.KVData;
import com.bytedance.ies.sdk.widgets.NextLiveData;
import com.bytedance.ies.sdk.widgets.Widget;
import com.bytedance.ies.sdk.widgets.WidgetManager;
import com.bytedance.ies.sdk.widgets.info.WidgetInfo;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u0001\u0006B\u0007¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/widget/PlayerVisibilityControllerWidget;", "Lcom/bytedance/android/live/core/tetris/widgets/LiveRecyclableWidget;", "Lcom/ss/android/ugc/aweme/compat/nullable/Observer;", "Lcom/bytedance/ies/sdk/widgets/KVData;", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "vs-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PlayerVisibilityControllerWidget extends LiveRecyclableWidget implements Observer<KVData> {
    public static final /* synthetic */ int A = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f118626a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public WidgetManager f118627b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f118628c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f118629d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final List<com.bytedance.android.livesdk.chatroom.vsplayer.model.c> f118630e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final List<com.bytedance.android.livesdk.chatroom.vsplayer.model.c> f118631f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final List<com.bytedance.android.livesdk.chatroom.vsplayer.model.c> f118632g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final List<com.bytedance.android.livesdk.chatroom.vsplayer.model.c> f118633h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final List<com.bytedance.android.livesdk.chatroom.vsplayer.model.c> f118634i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final List<com.bytedance.android.livesdk.chatroom.vsplayer.model.c> f118635j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Map<PlayerViewControl.KEY, com.bytedance.android.livesdk.chatroom.vsplayer.model.c> f118636k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public Observable<Long> f118637l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public Disposable f118638m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public IVSPlayerService f118639n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public VSPlayerViewControlContext f118640o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public CompositeDisposable f118641p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f118642q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f118643r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public int f118644s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public int f118645t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final List<Animator> f118646u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public boolean f118647v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int f118648w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public long f118649x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public long f118650y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final e f118651z;

    public static final class a {
    }

    public static final class b<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ VSPlayerViewControlContext f118652a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ PlayerVisibilityControllerWidget f118653b;

        public b(VSPlayerViewControlContext r100, PlayerVisibilityControllerWidget r101) {
            this.f118652a = r100;
            this.f118653b = r101;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r110) {
            Boolean r100 = (Boolean) r110;
            PlayerVisibilityControllerWidget r101 = this.f118653b;
            if (r101.f118628c == true) goto L5;
            r101.f118629d = true;
            return;
        L5:
            Boolean r102 = Boolean.FALSE;
            if (Intrinsics.areEqual(r100, r102) == false) goto L11;
            if (this.f118652a.isLocked().getValue().booleanValue() == true) goto L11;
            w1.a(this.f118653b.f118632g);
            w1.a(this.f118653b.f118633h);
            w1.a(this.f118653b.f118634i);
            w1.a(this.f118653b.f118635j);
            this.f118653b.Lq();
        L11:
            if (this.f118652a.getCustomAnimDuration().getValue().longValue() == (-1)) goto L13;
            long r103 = this.f118652a.getCustomAnimDuration().getValue().longValue();
            this.f118652a.getCustomAnimDuration().setValue(-1L);
        L14:
            PlayerVisibilityControllerWidget r104 = this.f118653b;
            boolean r111 = r100.booleanValue();
            if (r104.isViewValid() == false) goto L39;
            if (com.bytedance.android.livesdk.chatroom.vs_base.util.h.d(r104.dataCenter, true) == true) goto L25;
            if (r111 == false) goto L21;
            r104.f118649x = System.currentTimeMillis();
            r104.f118648w++;
        L21:
            if (r111 == true) goto L25;
            if (r104.f118649x == 0) goto L25;
            r104.f118650y += System.currentTimeMillis() - r104.f118649x;
            r104.f118649x = 0;
        L25:
            String r105 = r104.f118626a;
            StringBuilder r106 = new StringBuilder(" start changeInteractionVisibility to ");
            r106.append(r111);
            r106.append(",lock state=");
            VSPlayerViewControlContext r107 = r104.f118640o;
            if (r107 == null) goto L30;
            com.bytedance.live.datacontext.m<Boolean> r108 = r107.isLocked();
            if (r108 == null) goto L30;
            Boolean r109 = r108.getValue();
        L31:
            r106.append(r109);
            ALogger.d(r105, r106.toString());
            ((ArrayList) r104.f118646u).clear();
            long r112 = r103;
            r104.Gq(r104.f118630e, r111, false, r112);
            r104.Eq(r104.f118631f, r111, false, r112);
            r104.Kq(r104.f118632g, r111, false, r112);
            r104.Fq(r104.f118633h, r111, false, r112);
            r104.Iq(r104.f118634i, r111, false, r112);
            r104.Jq(r104.f118635j, r111, false, r112);
            AnimatorSet r113 = new AnimatorSet();
            r113.playTogether(r104.f118646u);
            r113.addListener(new t1(r104, r111, r113));
            r113.start();
            if (r3.l(r104.context) == false) goto L39;
            Context r114 = r104.context;
            if (r111 == false) goto L36;
            String r115 = "已显示播放控制栏";
        L37:
            r3.q(r114, r115);
            goto L39
        L36:
            r115 = "已隐藏播放控制栏";
        L30:
            r109 = null;
        L39:
            if (Intrinsics.areEqual(r100, Boolean.TRUE) == false) goto L42;
            this.f118653b.Nq();
        L42:
            if (Intrinsics.areEqual(r100, r102) == false) goto L46;
            this.f118652a.getPlayerViewVisibleTriggeredByUser().setValue(r102);
            return;
        L46:
            return;
        L13:
            r103 = 300;
            goto L14
        }
    }

    public static final class c<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ PlayerVisibilityControllerWidget f118654a;

        public c(PlayerVisibilityControllerWidget r100) {
            this.f118654a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            Unit r101 = (Unit) r100;
            ALogger.d(this.f118654a.f118626a, "receive resetHideTaskEvent");
            this.f118654a.Nq();
        }
    }

    public static final class d<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ PlayerVisibilityControllerWidget f118655a;

        public d(PlayerVisibilityControllerWidget r100) {
            this.f118655a = r100;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r100) {
            if (((Boolean) r100).booleanValue() == false) goto L19;
            PlayerVisibilityControllerWidget r101 = this.f118655a;
            if (r101.f118647v == true) goto L8;
            return;
        L8:
            if (com.bytedance.android.livesdk.chatroom.vs_base.util.h.d(r101.dataCenter, true) == true) goto L16;
            PlayerVisibilityControllerWidget r102 = this.f118655a;
            IVSPlayerService r103 = r102.f118639n;
            if (r103 == null) goto L17;
            com.bytedance.android.livesdk.chatroom.vsplayer.api.c r104 = r103.provideVSPlayerViewControlService(r102.dataCenter);
            if (r104 == null) goto L18;
            r104.setVisibilityStatus(false);
            return;
        L18:
            return;
        L17:
            return;
        L16:
            return;
        }
    }

    public static final class e implements com.bytedance.android.livesdk.chatroom.vsplayer.api.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ PlayerVisibilityControllerWidget f118656a;

        @Override // com.bytedance.android.livesdk.chatroom.vsplayer.api.d
        public final void C5() {
        }

        @Override // com.bytedance.android.livesdk.chatroom.vsplayer.api.d
        public final void D5() {
        }

        @Override // com.bytedance.android.livesdk.chatroom.vsplayer.api.d
        public final void H5() {
        }

        @Override // com.bytedance.android.livesdk.chatroom.vsplayer.api.d
        public final void P1() {
        }

        @Override // com.bytedance.android.livesdk.chatroom.vsplayer.api.d
        public final void g5() {
        }

        @Override // com.bytedance.android.livesdk.chatroom.vsplayer.api.d
        public final void k2() {
        }

        @Override // com.bytedance.android.livesdk.chatroom.vsplayer.api.d
        public final void l3() {
        }

        @Override // com.bytedance.android.livesdk.chatroom.vsplayer.api.d
        public final void onRenderStart() {
        }

        @Override // com.bytedance.android.livesdk.chatroom.vsplayer.api.d
        public final void z() {
        }

        @Override // com.bytedance.android.livesdk.chatroom.vsplayer.api.d
        public final void E5() {
            PlayerVisibilityControllerWidget r100 = this.f118656a;
            int r101 = PlayerVisibilityControllerWidget.A;
            r100.Nq();
        }

        public e(PlayerVisibilityControllerWidget r100) {
            this.f118656a = r100;
        }

        @Override // com.bytedance.android.livesdk.chatroom.vsplayer.api.d
        public final void G5(boolean r100) {
            if (r100 == false) goto L5;
            PlayerVisibilityControllerWidget r101 = this.f118656a;
            int r102 = PlayerVisibilityControllerWidget.A;
            r101.Nq();
            return;
        }

        @Override // com.bytedance.android.livesdk.chatroom.vsplayer.api.d
        public final void v2(EpisodeHighLight r100) {
            Intrinsics.checkNotNullParameter(r100, "episodeHighLight");
            Intrinsics.checkNotNullParameter(r100, "episodeHighLight");
        }

        @Override // com.bytedance.android.livesdk.chatroom.vsplayer.api.d
        public final void F5(EpisodeHighLight r100, Pair<Integer, Boolean> r101) {
            Intrinsics.checkNotNullParameter(r100, "episodeHighLight");
            Intrinsics.checkNotNullParameter(r101, "pair");
            com.bytedance.android.livesdk.chatroom.vsplayer.api.d.a.a(r100, r101);
        }

        @Override // com.bytedance.android.livesdk.chatroom.vsplayer.api.d
        public final void I5(EpisodeHighLight r100, Pair<Integer, Boolean> r101) {
            Intrinsics.checkNotNullParameter(r100, "episodeHighLight");
            Intrinsics.checkNotNullParameter(r101, "pair");
            com.bytedance.android.livesdk.chatroom.vsplayer.api.d.a.b(r100, r101);
        }
    }

    static {
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget
    public final void onInit(Object[] r100) {
    }

    public final void Nq() {
        ALogger.d(this.f118626a, "--resetHideViewTask");
        Disposable r100 = null;
        this.f118637l = null;
        this.f118637l = Observable.timer(5000, TimeUnit.MILLISECONDS).compose(RxUtil.rxSchedulerHelper());
        Disposable r101 = this.f118638m;
        if (r101 == null) goto L5;
        r101.dispose();
    L5:
        Observable<Long> r102 = this.f118637l;
        if (r102 == null) goto L8;
        r100 = RxUtilKt.n(r102, new PlayerVisibilityControllerWidget$resetHideViewTask$1(this));
    L8:
        this.f118638m = r100;
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget
    public final void onUnload() {
        String r100 = this.f118626a;
        StringBuilder r101 = new StringBuilder("start onUnload: dataCenter:");
        r101.append(this.dataCenter.hashCode());
        r101.append(", viewControlService:");
        IVSPlayerService r102 = this.f118639n;
        if (r102 == null) goto L5;
        com.bytedance.android.livesdk.chatroom.vsplayer.api.c r103 = r102.provideVSPlayerViewControlService(this.dataCenter);
    L7:
        if (r103 == null) goto L9;
        int r104 = r103.hashCode();
    L10:
        r101.append(r104);
        ALogger.d(r100, r101.toString());
        VSPlayerViewControlContext r105 = this.f118640o;
        if (r105 == null) goto L20;
        com.bytedance.live.datacontext.m<Boolean> r106 = r105.getPlayerViewVisible();
        if (r106 != null) goto L15;
    L17:
        boolean r107 = false;
    L18:
        r105.setInitVisible(r107);
        goto L20
    L15:
        if (r106.getValue().booleanValue() != true) goto L17;
        r107 = true;
    L20:
        if (com.bytedance.android.livesdk.chatroom.vs_base.util.h.d(this.dataCenter, true) == false) goto L23;
    L26:
        this.dataCenter.removeObserver(this);
        this.f118647v = false;
        this.f118627b = null;
        ((LinkedHashMap) this.f118636k).clear();
        ((ArrayList) this.f118630e).clear();
        ((ArrayList) this.f118631f).clear();
        ((ArrayList) this.f118632g).clear();
        ((ArrayList) this.f118633h).clear();
        ((ArrayList) this.f118634i).clear();
        ((ArrayList) this.f118635j).clear();
        this.f118640o = null;
        IVSPlayerService r108 = this.f118639n;
        if (r108 == null) goto L31;
        IPlayerProgressService r109 = r108.provideVSProgressService(this.dataCenter);
        if (r109 == null) goto L31;
        r109.removeProgressChangeListener(this.f118651z);
    L31:
        IVSPlayerService r110 = this.f118639n;
        if (r110 == null) goto L36;
        com.bytedance.android.livesdk.chatroom.vsplayer.api.c r111 = r110.provideVSPlayerViewControlService(this.dataCenter);
        if (r111 == null) goto L36;
        r111.clearControlWidget();
    L36:
        this.f118639n = null;
        ((ArrayList) this.f118646u).clear();
        Disposable r112 = this.f118638m;
        if (r112 != null) goto L39;
    L44:
        this.f118638m = null;
        this.f118641p.dispose();
        return;
    L39:
        if (r112.isDisposed() == false) goto L42;
        r112 = null;
    L42:
        if (r112 == null) goto L44;
        r112.dispose();
        goto L44
    L23:
        if (this.f118649x == 0) goto L25;
        this.f118650y += System.currentTimeMillis() - this.f118649x;
        this.f118649x = 0;
    L25:
        com.bytedance.android.livesdk.chatroom.vs_base.base.util.r.l().w(this.dataCenter, this.f118648w, this.f118650y);
        this.f118650y = 0;
        goto L26
    L9:
        r104 = 0;
        goto L10
    L5:
        r103 = null;
        goto L7
    }

    public PlayerVisibilityControllerWidget() {
        this.f118626a = "PlayerVisibilityControllerWidget[" + hashCode() + ']';
        this.f118630e = new ArrayList();
        this.f118631f = new ArrayList();
        this.f118632g = new ArrayList();
        this.f118633h = new ArrayList();
        this.f118634i = new ArrayList();
        this.f118635j = new ArrayList();
        this.f118636k = new LinkedHashMap();
        this.f118641p = new CompositeDisposable();
        this.f118646u = new ArrayList();
        this.f118651z = new e(this);
    }

    public final void Lq() {
        Class<? extends Widget> r100 = com.bytedance.android.livesdk.chatroom.vs_base.base.util.r.B().getWidgetClass(102);
        if (r100 == null) goto L8;
        WidgetInfo r101 = getWidgetInfo(r100);
        if (r101 == null) goto L9;
        int[] r102 = r101.getLocationOnScreen();
        int r103 = r102[0];
        this.f118644s = r103;
        this.f118642q = r102[1];
        this.f118645t = r103 + r101.getContentViewWidth();
        this.f118643r = this.f118642q + r101.getContentViewHeight();
        return;
    L9:
        return;
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveWidget, com.bytedance.ies.sdk.widgets.Widget
    public final void onPause() {
        super.onPause();
        this.f118647v = false;
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveWidget, com.bytedance.ies.sdk.widgets.Widget
    public final void onResume() {
        super.onResume();
        Nq();
        VSPlayerViewControlContext r100 = this.f118640o;
        if (r100 == null) goto L5;
        r100.getPlayerViewVisibleTriggeredByUser().setValue(Boolean.FALSE);
    L5:
        this.f118647v = true;
    }

    public final void Bq(com.bytedance.android.livesdk.chatroom.vsplayer.model.c r110) {
        Intrinsics.checkNotNullParameter(r110, MapController.ITEM_LAYER_TAG);
        ALogger.d(this.f118626a, "start addControl Item for " + r110.f118405g.getDescribe());
        Mq(r110.f118405g);
        switch(s1.f119175b[r110.getType().ordinal()]) {
            case 1: goto L10;
            case 2: goto L9;
            case 3: goto L8;
            case 4: goto L7;
            case 5: goto L6;
            case 6: goto L5;
            default: goto L11;
        };
    L5:
        ((ArrayList) this.f118631f).add(r110);
        goto L11
    L6:
        ((ArrayList) this.f118630e).add(r110);
        goto L11
    L7:
        ((ArrayList) this.f118635j).add(r110);
        goto L11
    L8:
        ((ArrayList) this.f118634i).add(r110);
        goto L11
    L9:
        ((ArrayList) this.f118633h).add(r110);
        goto L11
    L10:
        ((ArrayList) this.f118632g).add(r110);
    L11:
        View r100 = r110.f118407i;
        r100.setTag(r110.f118405g.getDescribe());
        r100.setAlpha(1.0f);
        r100.setTranslationY(0.0f);
        r100.setTranslationX(0.0f);
        this.f118636k.put(r110.f118405g, r110);
        VSPlayerViewControlContext r101 = this.f118640o;
        int r102 = 0;
        if (r101 == null) goto L18;
        com.bytedance.live.datacontext.m<Boolean> r103 = r101.getPlayerViewVisible();
        if (r103 == null) goto L18;
        if (r103.getValue().booleanValue() != true) goto L18;
        boolean r104 = true;
    L19:
        if (r104 == true) goto L21;
    L23:
        int r105 = r102 ^ 1;
        Integer r106 = r110.f118404f.getValue();
        if (r106 != null) goto L27;
    L29:
        ((ArrayList) this.f118646u).clear();
        switch(s1.f119174a[r110.getType().ordinal()]) {
            case 1: goto L37;
            case 2: goto L36;
            case 3: goto L35;
            case 4: goto L34;
            case 5: goto L33;
            case 6: goto L32;
            default: goto L38;
        };
    L32:
        Eq(CollectionsKt.listOf(r110), r104, false, 0);
        goto L38
    L33:
        Gq(CollectionsKt.listOf(r110), r104, false, 0);
        goto L38
    L34:
        Jq(CollectionsKt.listOf(r110), r104, false, 0);
        goto L38
    L35:
        Iq(CollectionsKt.listOf(r110), r104, false, 0);
        goto L38
    L36:
        Fq(CollectionsKt.listOf(r110), r104, false, 0);
        goto L38
    L37:
        Kq(CollectionsKt.listOf(r110), r104, false, 0);
    L38:
        AnimatorSet r107 = new AnimatorSet();
        r107.playTogether(this.f118646u);
        r107.start();
        ALogger.d(this.f118626a, "add control item and init it's status Item:[" + r110.f118405g.getDescribe() + "] Visibility to [" + r104 + ']');
        return;
    L27:
        if (r106.intValue() != r105) goto L29;
        return;
    L21:
        if (r110.f118413o == true) goto L23;
        r102 = 1;
    L18:
        r104 = false;
        goto L19
    }

    public final void Mq(PlayerViewControl.KEY r100) {
        Intrinsics.checkNotNullParameter(r100, "key");
        com.bytedance.android.livesdk.chatroom.vsplayer.model.c r101 = (com.bytedance.android.livesdk.chatroom.vsplayer.model.c) ((LinkedHashMap) this.f118636k).get(r100);
        if (r101 == null) goto L15;
        PlayerViewControl.Type r102 = r101.getType();
        switch(s1.f119176c[r102.ordinal()]) {
            case 1: goto L13;
            case 2: goto L12;
            case 3: goto L11;
            case 4: goto L10;
            case 5: goto L9;
            case 6: goto L8;
            default: goto L7;
        };
    L8:
        ((ArrayList) this.f118631f).remove(r101);
        return;
    L9:
        ((ArrayList) this.f118630e).remove(r101);
        return;
    L10:
        ((ArrayList) this.f118635j).remove(r101);
        return;
    L11:
        ((ArrayList) this.f118634i).remove(r101);
        return;
    L12:
        ((ArrayList) this.f118633h).remove(r101);
        return;
    L13:
        ((ArrayList) this.f118632g).remove(r101);
        return;
    L7:
        throw new NoWhenBranchMatchedException();
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r110) {
        KVData r100 = (KVData) r110;
        if (r100 == null) goto L72;
        String r101 = r100.getKey();
        switch(r101.hashCode()) {
            case -1836833765: goto L17;
            case -1575056762: goto L14;
            case -67504953: goto L11;
            case 1440046856: goto L8;
            default: goto L79;
        };
    L79:
        return;
    L8:
        if (r101.equals("cmd_p2_widget_loaded") == false) goto L73;
    L18:
        Lq();
        WidgetManager r102 = this.f118627b;
        if (r102 == null) goto L77;
        Iterator<Map.Entry<Widget, ViewGroup>> r103 = r102.widgetViewGroupHashMap.entrySet().iterator();
    L21:
        Widget r104 = null;
        if (r103.hasNext() == false) goto L37;
        Map.Entry<Widget, ViewGroup> r105 = r103.next();
        Widget r106 = r105.getKey();
        PlayerViewControl r107 = (PlayerViewControl) r106.getClass().getAnnotation(PlayerViewControl.class);
        if (r107 == null) goto L21;
        if ((true ^ this.f118636k.containsKey(r107.key())) == true) goto L29;
        r107 = null;
    L29:
        if (r107 == null) goto L21;
        ViewGroup r111 = r105.getValue();
        if (r111 == null) goto L21;
        PlayerViewControl.KEY r108 = r107.key();
        if ((r106 instanceof com.bytedance.android.livesdk.chatroom.vsplayer.model.a) == false) goto L36;
        r104 = r106;
    L36:
        Bq(new com.bytedance.android.livesdk.chatroom.vsplayer.model.c(r108, (com.bytedance.android.livesdk.chatroom.vsplayer.model.a) r104, r111, r107.type(), r107.style(), r107.attachMarginDp(), r107.needDynamicControl(), r107.ignoreLock(), r107.reverse()));
        goto L21
    L37:
        VSPlayerViewControlContext r109 = this.f118640o;
        if (r109 == null) goto L44;
        ALogger.d(this.f118626a, "initViewList: tmp list size:" + r109.getTmpControlItemList().size());
        Iterator<T> r112 = r109.getTmpControlItemList().iterator();
    L41:
        if (r112.hasNext() == false) goto L43;
        Bq((com.bytedance.android.livesdk.chatroom.vsplayer.model.c) r112.next());
        goto L41
    L43:
        r109.getTmpControlItemList().clear();
    L44:
        this.f118628c = true;
        DataCenter r113 = this.dataCenter;
        if (r113 == null) goto L55;
        IRoom r114 = com.bytedance.android.livesdk.chatroom.vs_base.util.h.e(r113);
        if (r114 == null) goto L55;
        if (r114.isMergeVSRoom() != true) goto L55;
        vr1.u r115 = com.bytedance.android.livesdk.chatroom.vs_base.base.util.r.u(this.dataCenter, null, 2);
        if (r115 == null) goto L55;
        com.bytedance.live.datacontext.k<Boolean> r116 = r115.Y0();
        if (r116 == null) goto L55;
        r116.post(Boolean.TRUE);
    L55:
        ALogger.d(this.f118626a, "init complete. size: \ndirect[" + ((ArrayList) this.f118630e).size() + "]\nalpha[" + ((ArrayList) this.f118631f).size() + "]\ntop[" + ((ArrayList) this.f118632g).size() + "]\nbottom[" + ((ArrayList) this.f118633h).size() + "]\nleft[" + ((ArrayList) this.f118634i).size() + "]\nright[" + ((ArrayList) this.f118635j).size() + "]\n");
        if (this.f118629d == false) goto L78;
        VSPlayerViewControlContext r117 = this.f118640o;
        if (r117 == null) goto L60;
        r117.getPlayerViewVisible().setValue(r117.getPlayerViewVisible().getValue());
        ALogger.w(this.f118626a, "beforeInitStatusChangeFlag == true, refresh status");
    L60:
        this.f118629d = false;
        return;
    L78:
        return;
    L77:
        return;
    L73:
        return;
    L11:
        if (r101.equals("cmd_p1_widget_loaded") == true) goto L18;
        return;
    L14:
        if (r101.equals("cmd_p0_widget_loaded") == true) goto L18;
        return;
    L17:
        if (r101.equals("cmd_widget_loaded") == true) goto L18;
        return;
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget
    public final void onLoad(Object[] r100) {
        IVSPlayerService r101 = (IVSPlayerService) jc1.k.f(IVSPlayerService.class);
        this.f118639n = r101;
        if (r101 == null) goto L7;
        com.bytedance.android.livesdk.chatroom.vsplayer.api.c r102 = r101.provideVSPlayerViewControlService(this.dataCenter);
        if (r102 == null) goto L7;
        r102.f(this);
    L7:
        String r103 = this.f118626a;
        StringBuilder r104 = new StringBuilder("start onLoad: dataCenter:");
        r104.append(this.dataCenter.hashCode());
        r104.append(", viewControlService:");
        IVSPlayerService r105 = this.f118639n;
        VSPlayerViewControlContext r106 = null;
        if (r105 == null) goto L10;
        com.bytedance.android.livesdk.chatroom.vsplayer.api.c r107 = r105.provideVSPlayerViewControlService(this.dataCenter);
    L12:
        if (r107 == null) goto L14;
        int r108 = r107.hashCode();
    L15:
        r104.append(r108);
        ALogger.d(r103, r104.toString());
        this.f118628c = false;
        this.f118629d = false;
        IVSPlayerService r109 = this.f118639n;
        if (r109 == null) goto L20;
        com.bytedance.android.livesdk.chatroom.vsplayer.api.c r110 = r109.provideVSPlayerViewControlService(this.dataCenter);
        if (r110 == null) goto L20;
        WidgetManager r111 = r110.getWidgetManager();
    L21:
        this.f118627b = r111;
        this.f118647v = false;
        this.f118641p = new CompositeDisposable();
        ((ArrayList) this.f118646u).clear();
        IVSPlayerService r112 = this.f118639n;
        if (r112 == null) goto L26;
        com.bytedance.android.livesdk.chatroom.vsplayer.api.c r113 = r112.provideVSPlayerViewControlService(this.dataCenter);
        if (r113 == null) goto L26;
        r106 = r113.provideContext();
    L26:
        this.f118640o = r106;
        this.f118649x = System.currentTimeMillis();
        this.f118648w++;
        VSPlayerViewControlContext r114 = this.f118640o;
        if (r114 == null) goto L34;
        r114.isLocked().setValue(Boolean.FALSE);
        r114.getPlayerViewVisible().setValue(Boolean.valueOf(r114.getInitVisible()));
        Disposable r115 = r114.getPlayerViewVisible().a().subscribe(new b(r114, this));
        if (r115 == null) goto L31;
        RxUtilKt.c(r115, this.f118641p);
    L31:
        Disposable r116 = r114.getResetHideTaskEvent().onEvent().subscribe(new c(this));
        if (r116 == null) goto L34;
        RxUtilKt.c(r116, this.f118641p);
    L34:
        this.dataCenter.observe("cmd_widget_loaded", this).observe("cmd_p0_widget_loaded", this).observe("cmd_p1_widget_loaded", this).observe("cmd_p2_widget_loaded", this);
        IVSPlayerService r117 = this.f118639n;
        if (r117 == null) goto L39;
        IPlayerProgressService r118 = r117.provideVSProgressService(this.dataCenter);
        if (r118 == null) goto L39;
        r118.addProgressChangeListener(this.f118651z);
    L39:
        com.bytedance.android.livesdk.f.d().f123392a.observe(this, new d(this));
        return;
    L20:
        r111 = null;
        goto L21
    L14:
        r108 = 0;
        goto L15
    L10:
        r107 = null;
        goto L12
    }

    public static final Animator wq(PlayerVisibilityControllerWidget r100, View r101, float r102, long r103) {
        r100.getClass();
        ObjectAnimator r104 = ObjectAnimator.ofFloat(r101, "alpha", new float[]{r101.getAlpha(), r102});
        r104.setInterpolator(new com.bytedance.android.live.core.widget.g());
        r104.setDuration(r103);
        return r104;
    }

    public final void Cq(List<com.bytedance.android.livesdk.chatroom.vsplayer.model.c> r100, Function1<? super com.bytedance.android.livesdk.chatroom.vsplayer.model.c, Unit> r101, boolean r110, boolean r111) {
        ArrayList r102 = new ArrayList();
        r102.addAll(r100);
        VSPlayerViewControlContext r103 = this.f118640o;
        List r104 = r102;
        if (r103 == null) goto L16;
        com.bytedance.live.datacontext.m<Boolean> r105 = r103.isLocked();
        r104 = r102;
        if (r105 == null) goto L16;
        r104 = r102;
        r104 = r102;
        if (r105.getValue().booleanValue() != true) goto L16;
        if (r110 == false) goto L16;
        ArrayList r106 = new ArrayList();
        Iterator r107 = r102.iterator();
    L11:
        if (r107.hasNext() == false) goto L15;
        Object r108 = r107.next();
        if (((com.bytedance.android.livesdk.chatroom.vsplayer.model.c) r108).f118412n == false) goto L11;
        r106.add(r108);
        goto L11
    L15:
        r104 = CollectionsKt.toMutableList(r106);
    L16:
        Iterator r109 = r104.iterator();
    L18:
        if (r109.hasNext() == false) goto L36;
        com.bytedance.android.livesdk.chatroom.vsplayer.model.c r112 = (com.bytedance.android.livesdk.chatroom.vsplayer.model.c) r109.next();
        if (r112.f118411m == false) goto L21;
        if (r111 == true) goto L23;
        com.bytedance.android.livesdk.chatroom.vsplayer.model.a r113 = r112.f118406h;     // Catch: Exception -> L30
        if ((r113 instanceof com.bytedance.android.livesdk.chatroom.vsplayer.model.a) == false) goto L32;
        if (r113 == null) goto L29;
        boolean r114 = r113.canControlByPlayer(r112.f118405g);     // Catch: Exception -> L30
    L33:
        if (r114 == true) goto L34;
        ALogger.i(this.f118626a, "dynamic check failed, skip action [" + r110 + "] for " + r112.f118405g.getDescribe());
        goto L18
    L34:
        ALogger.i(this.f118626a, "dynamic check success, start do action [" + r110 + "] for " + r112.f118405g.getDescribe());
        r101.invoke(r112);
        goto L18
    L29:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.chatroom.vsplayer.model.IPlayerViewControlFlag");     // Catch: Exception -> L30
    L32:
        r114 = true;
    L30:
        e = move-exception;
        ALogger.e(this.f118626a, "canHandleByAnnotation: " + e);
        goto L32
    L23:
        r101.invoke(r112);
        ALogger.w(this.f118626a, "skip dynamic check for " + r112.f118405g.getDescribe() + " when visible [" + r110 + ']');
        goto L18
    L21:
        ALogger.i(this.f118626a, "start do action [" + r110 + "] for " + r112.f118405g.getDescribe());
        r101.invoke(r112);
        goto L18
    }

    public final void Eq(List<com.bytedance.android.livesdk.chatroom.vsplayer.model.c> r100, boolean r101, boolean r102, long r103) {
        if (((ArrayList) this.f118631f).isEmpty() == false) goto L5;
        return;
    L5:
        Cq(r100, new PlayerVisibilityControllerWidget$handleAlphaViews$2(new PlayerVisibilityControllerWidget$handleAlphaViews$1(this, r101, r103)), r101, r102);
    }

    public final void Fq(List<com.bytedance.android.livesdk.chatroom.vsplayer.model.c> r100, boolean r101, boolean r102, long r103) {
        if (((ArrayList) this.f118633h).isEmpty() == false) goto L5;
        return;
    L5:
        Cq(r100, new PlayerVisibilityControllerWidget$handleBottomViews$2(new PlayerVisibilityControllerWidget$handleBottomViews$1(this, r101, r103)), r101, r102);
    }

    public final void Gq(List<com.bytedance.android.livesdk.chatroom.vsplayer.model.c> r100, boolean r101, boolean r102, long r103) {
        if (((ArrayList) this.f118630e).isEmpty() == false) goto L5;
        return;
    L5:
        Cq(r100, new PlayerVisibilityControllerWidget$handleDirectHideViews$2(new PlayerVisibilityControllerWidget$handleDirectHideViews$1(this, r101, r103)), r101, r102);
    }

    public final void Iq(List<com.bytedance.android.livesdk.chatroom.vsplayer.model.c> r100, boolean r101, boolean r102, long r103) {
        if (((ArrayList) this.f118634i).isEmpty() == false) goto L5;
        return;
    L5:
        Cq(r100, new PlayerVisibilityControllerWidget$handleLeftViews$2(new PlayerVisibilityControllerWidget$handleLeftViews$1(this, r101, r103)), r101, r102);
    }

    public final void Jq(List<com.bytedance.android.livesdk.chatroom.vsplayer.model.c> r100, boolean r101, boolean r102, long r103) {
        if (((ArrayList) this.f118635j).isEmpty() == false) goto L5;
        return;
    L5:
        Cq(r100, new PlayerVisibilityControllerWidget$handleRightViews$2(new PlayerVisibilityControllerWidget$handleRightViews$1(this, r101, r103)), r101, r102);
    }

    public final void Kq(List<com.bytedance.android.livesdk.chatroom.vsplayer.model.c> r100, boolean r101, boolean r102, long r103) {
        if (((ArrayList) this.f118632g).isEmpty() == false) goto L5;
        return;
    L5:
        Cq(r100, new PlayerVisibilityControllerWidget$handleTopViews$2(new PlayerVisibilityControllerWidget$handleTopViews$1(this, r101, r103)), r101, r102);
    }

    public final void Pq(PlayerViewControl.KEY r110, boolean r111, long r112, boolean r113) {
        Intrinsics.checkNotNullParameter(r110, "key");
        com.bytedance.android.livesdk.chatroom.vsplayer.model.c r100 = (com.bytedance.android.livesdk.chatroom.vsplayer.model.c) ((LinkedHashMap) this.f118636k).get(r110);
        if (r100 != null) goto L6;
        return;
    L6:
        if (r113 == false) goto L52;
        Iterator r101 = ((ArrayList) this.f118646u).iterator();
    L9:
        if (r101.hasNext() == false) goto L42;
        Animator r102 = (Animator) r101.next();
        String r103 = this.f118626a;
        StringBuilder r104 = new StringBuilder("cancelObjectAnimator item[");
        r104.append(r100.f118405g.getDescribe());
        r104.append("] view tag[");
        boolean r105 = r102 instanceof ObjectAnimator;
        Object r114 = null;
        if (r105 == true) goto L13;
        Animator r115 = null;
    L14:
        ObjectAnimator r116 = (ObjectAnimator) r115;
        if (r116 == null) goto L17;
        Object r117 = r116.getTarget();
    L19:
        if ((r117 instanceof View) == true) goto L21;
        r117 = null;
    L21:
        View r118 = (View) r117;
        if (r118 == null) goto L24;
        Object r119 = r118.getTag();
    L25:
        r104.append(r119);
        r104.append(']');
        ALogger.w(r103, r104.toString());
        if (r105 == true) goto L28;
        Animator r106 = null;
    L29:
        ObjectAnimator r107 = (ObjectAnimator) r106;
        if (r107 == null) goto L32;
        Object r108 = r107.getTarget();
    L34:
        if ((r108 instanceof View) == true) goto L36;
        r108 = null;
    L36:
        View r109 = (View) r108;
        if (r109 == null) goto L40;
        r114 = r109.getTag();
    L40:
        if (Intrinsics.areEqual(r114, r100.f118405g.getDescribe()) == false) goto L9;
        r102.cancel();
        ((ArrayList) this.f118646u).remove(r102);
        goto L42
    L32:
        r108 = null;
        goto L34
    L28:
        r106 = r102;
        goto L29
    L24:
        r119 = null;
        goto L25
    L17:
        r117 = null;
        goto L19
    L13:
        r115 = r102;
    L42:
        NextLiveData<Integer> r120 = r100.f118404f;
        if (r100.f118413o == false) goto L47;
        if (r111 == true) goto L46;
        boolean r121 = true;
    L48:
        if (r121 == false) goto L50;
        int r122 = 1;
    L51:
        r120.setValue(r122);
        goto L52
    L50:
        r122 = 0;
        goto L51
    L46:
        r121 = false;
        goto L48
    L47:
        r121 = r111;
    L52:
        ((ArrayList) this.f118646u).clear();
        switch(s1.f119177d[r100.getType().ordinal()]) {
            case 1: goto L60;
            case 2: goto L59;
            case 3: goto L58;
            case 4: goto L57;
            case 5: goto L56;
            case 6: goto L55;
            default: goto L61;
        };
    L55:
        Eq(CollectionsKt.listOf(r100), r111, true, r112);
        goto L61
    L56:
        Gq(CollectionsKt.listOf(r100), r111, true, r112);
        goto L61
    L57:
        Jq(CollectionsKt.listOf(r100), r111, true, r112);
        goto L61
    L58:
        Iq(CollectionsKt.listOf(r100), r111, true, r112);
        goto L61
    L59:
        Fq(CollectionsKt.listOf(r100), r111, true, r112);
        goto L61
    L60:
        Kq(CollectionsKt.listOf(r100), r111, true, r112);
    L61:
        AnimatorSet r123 = new AnimatorSet();
        r123.playTogether(this.f118646u);
        r123.start();
        ALogger.d(this.f118626a, "start change Item:[" + r110.getDescribe() + "] Visibility to [" + r111 + ']');
    }

    public static final Animator Aq(PlayerVisibilityControllerWidget r100, View r101, float r102, float r103, long r104) {
        r100.getClass();
        ObjectAnimator r105 = ObjectAnimator.ofFloat(r101, LiveDegradeFpsAnimator.TRANSLATION_Y, new float[]{r102, r103});
        r105.setInterpolator(new com.bytedance.android.live.core.widget.g());
        r105.setDuration(r104);
        return r105;
    }

    public static final Animator zq(PlayerVisibilityControllerWidget r100, View r101, float r102, float r103, long r104) {
        r100.getClass();
        ObjectAnimator r105 = ObjectAnimator.ofFloat(r101, LiveDegradeFpsAnimator.TRANSLATION_X, new float[]{r102, r103});
        r105.setInterpolator(new com.bytedance.android.live.core.widget.g());
        r105.setDuration(r104);
        return r105;
    }

    public static final Animator xq(PlayerVisibilityControllerWidget r100, View r101, float r102, float r103, float r104, long r105) {
        r100.getClass();
        ValueAnimator r106 = ValueAnimator.ofFloat(new float[]{r102, r103});
        r106.addUpdateListener(new u1(r104, r101));
        r106.setInterpolator(new com.bytedance.android.live.core.widget.g());
        r106.setDuration(r105);
        return r106;
    }

    public static final Animator yq(PlayerVisibilityControllerWidget r100, View r101, float r102, float r103, float r104, long r105) {
        r100.getClass();
        ValueAnimator r106 = ValueAnimator.ofFloat(new float[]{r102, r103});
        r106.addUpdateListener(new v1(r104, r101));
        r106.setInterpolator(new com.bytedance.android.live.core.widget.g());
        r106.setDuration(r105);
        return r106;
    }
}
