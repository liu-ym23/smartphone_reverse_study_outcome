package com.bytedance.android.live.componentsmarket.impl.components.title;

import am2.x;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewPropertyAnimator;
import android.view.animation.DecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.bytedance.android.live.componentsmarket.impl.components.BaseComponentsTetris;
import com.bytedance.android.live.componentsmarket.impl.components.title.model.BaseTitleViewModel;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.a1;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.utils.z;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.room.api.IVisibilityControlBrickService;
import com.bytedance.android.live.room.api.IVisibilityControlService;
import com.bytedance.android.live.room.api.visibilitycontrol.LiveVisibilityControlContext;
import com.bytedance.android.livesdk.chatroom.MiddlewareRoomContext;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import com.bytedance.android.livesdk.chatroom.ui.d9;
import com.bytedance.android.livesdk.chatroom.utils.o3;
import com.bytedance.android.livesdk.chatroom.vsplayer.api.IVSPlayerService;
import com.bytedance.android.livesdk.chatroom.vsplayer.model.PlayerViewControl;
import com.bytedance.android.livesdk.config.lj;
import com.bytedance.android.livesdk.config.qu0;
import com.bytedance.android.livesdk.log.filter.o;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdk.projectmode.ILiveSdkProjectModeService;
import com.bytedance.android.livesdk.r3;
import com.bytedance.android.livesdk.utils.t6;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.depend.model.live.RoomPlatformComponentsData;
import com.bytedance.android.livesdkapi.depend.model.live.RoomTitle;
import com.bytedance.android.livesdkapi.depend.model.live.episode.EpisodeExtraInfo;
import com.bytedance.android.livesdkapi.depend.model.live.episode.VSCameraInfo;
import com.bytedance.android.livesdkapi.depend.model.live.episode.VSCameraType;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.KVData;
import com.bytedance.live.datacontext.m;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import com.ss.android.ugc.aweme.search.model.SearchResultParam;
import com.ss.ttm.player.MediaPlayer;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004B\u0007¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/live/componentsmarket/impl/components/title/TitleTetris;", "Lcom/bytedance/android/live/componentsmarket/impl/components/BaseComponentsTetris;", "Lcom/bytedance/android/live/componentsmarket/impl/components/titledetail/a$a;", "Lo70/a;", "Lcom/bytedance/android/livesdk/chatroom/vsplayer/model/a;", "Lo70/b;", "event", "", "onEvent", "<init>", "()V", "livecomponentsmarket-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class TitleTetris extends BaseComponentsTetris implements com.bytedance.android.live.componentsmarket.impl.components.titledetail.a.InterfaceC1061a, o70.a, com.bytedance.android.livesdk.chatroom.vsplayer.model.a {
    public com.bytedance.android.livesdk.common.j A;
    public Disposable B;
    public HSImageView C;
    public Disposable D;
    public ObjectAnimator E;
    public boolean F;
    public final TitleTetris$timerListener$1 G;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public TextView f64654s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public ConstraintLayout f64655t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public TextView f64656u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public View f64657v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public View f64658w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public TextView f64659x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public View f64660y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public View f64661z;

    public static final class a implements View.OnLongClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ILiveSdkProjectModeService f64662a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ TitleTetris f64663b;

        public a(ILiveSdkProjectModeService r100, TitleTetris r101) {
            this.f64662a = r100;
            this.f64663b = r101;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.view.View.OnLongClickListener
        public final boolean onLongClick(View r100) {
            Context r101 = ((d90.a) this.f64663b.K()).getContext();
            if (r101 == null) goto L7;
            ILiveSdkProjectModeService r102 = this.f64662a;
            r102.initAndShowPerfTools((FragmentActivity) r101);
            return true;
        L7:
            throw new NullPointerException("null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
        }
    }

    public static final class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ TitleTetris f64664a;

        public b(TitleTetris r100) {
            this.f64664a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            TitleTetris.i0(this.f64664a);
        }
    }

    public static final class c implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ TitleTetris f64665a;

        public c(TitleTetris r100) {
            this.f64665a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            TitleTetris.i0(this.f64665a);
        }
    }

    public static final class d implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ TitleTetris f64666a;

        public static final class a implements com.bytedance.android.livesdk.common.j.a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ d f64667a;

            @Override // com.bytedance.android.livesdk.common.j.a
            public final void onEnd() {
                com.bytedance.android.livesdk.common.j r100 = this.f64667a.f64666a.A;
                if (r100 == null) goto L5;
                r100.cancelAnimation();
            L5:
                TitleTetris r101 = this.f64667a.f64666a;
                com.bytedance.android.livesdk.common.j r102 = r101.A;
                if (r102 == null) goto L9;
                r102.setTextWithFadingMode(r101.j0());
                return;
            }

            @Override // com.bytedance.android.livesdk.common.j.a
            public final void onStart() {
                com.bytedance.android.livesdk.common.j r100 = this.f64667a.f64666a.A;
                if (r100 == null) goto L6;
                r100.textNeedLeftEdge(true);
                return;
            }

            public a(d r100) {
                this.f64667a = r100;
            }
        }

        public d(TitleTetris r100) {
            this.f64666a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            com.bytedance.android.livesdk.common.j r100 = this.f64666a.A;     // Catch: Throwable -> L6
            if (r100 == null) goto L9;
            r100.startMarqueeIfNeed(new a(this));     // Catch: Throwable -> L6
            return;
        L9:
            return;
        L6:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L13;
            throw th;
        }
    }

    public static final class e<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ TitleTetris f64668a;

        public e(TitleTetris r100) {
            this.f64668a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            Long r101 = (Long) r100;
            this.f64668a.n0(true);
        }
    }

    public static final class f extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ TitleTetris f64669a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ boolean f64670b;

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
            super.onAnimationEnd(r100);
            if (this.f64670b == true) goto L7;
            ConstraintLayout r101 = this.f64669a.f64655t;
            if (r101 == null) goto L7;
            r101.setVisibility(8);
        L7:
            TitleTetris r102 = this.f64669a;
            boolean r103 = this.f64670b;
            ConstraintLayout r104 = r102.f64655t;
            if (r104 == null) goto L27;
            float r105 = r104.getAlpha();
            float r106 = 1.0f;
            if (r103 == false) goto L15;
            if (r105 != 1.0f) goto L16;
        L17:
            boolean r107 = false;
        L18:
            if (r107 == true) goto L21;
            r104 = null;
        L21:
            if (r104 == null) goto L28;
            if (r103 == true) goto L25;
            r106 = 0.0f;
        L25:
            r104.setAlpha(r106);
            return;
        L28:
            return;
        L16:
            r107 = true;
            goto L18
        L15:
            if (r105 == 0.0f) goto L17;
        }

        public f(TitleTetris r100, boolean r101) {
            this.f64669a = r100;
            this.f64670b = r101;
        }
    }

    @Override // o70.a
    public final List<Class<? extends o70.b>> Mg() {
        return CollectionsKt.listOf(new Class[]{bh1.a.class, bh1.b.class});
    }

    @Override // com.bytedance.android.live.componentsmarket.impl.components.BaseComponentsTetris, android.view.View.OnClickListener
    public final void onClick(View r100) {
    }

    @Override // com.bytedance.android.live.componentsmarket.impl.components.BaseComponentsTetris
    public final void V() {
        ILiveSdkProjectModeService r100 = (ILiveSdkProjectModeService) jc1.k.f(ILiveSdkProjectModeService.class);
        if (r100 != null) goto L5;
    L9:
        View r101 = this.f64660y;
        if (r101 == null) goto L12;
        r101.setOnClickListener(new b(this));
    L12:
        View r102 = this.f64657v;
        if (r102 == null) goto L15;
        r102.setOnClickListener(new c(this));
    L15:
        com.bytedance.android.live.componentsmarket.impl.components.titledetail.a.b r103 = com.bytedance.android.live.componentsmarket.impl.components.titledetail.a.f64696a;
        ArrayList<com.bytedance.android.live.componentsmarket.impl.components.titledetail.a.InterfaceC1061a> r104 = com.bytedance.android.live.componentsmarket.impl.components.titledetail.a.f64697b;
        if (r104.contains(this) == true) goto L18;
        r104.add(this);
    L18:
        super.V();
        return;
    L5:
        if (r100.isPerfToolsDebug() == false) goto L9;
        View r105 = this.f64660y;
        if (r105 == null) goto L9;
        r105.setOnLongClickListener(new a(r100, this));
        goto L9
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.android.live.componentsmarket.impl.components.BaseComponentsTetris
    public final void W() {
        if ((this.f64505p instanceof BaseTitleViewModel) == false) goto L211;
        d90.a r100 = (d90.a) K();
        Disposable r101 = null;
        if (r100 == null) goto L9;
        DataCenter r102 = r100.f467480h;
        if (r102 == null) goto L9;
        Room r103 = z.o(r102);
    L10:
        this.f64506q = r103;
        if (r103 == null) goto L15;
        RoomPlatformComponentsData r104 = r103.roomPlatformComponentsData;
        if (r104 == null) goto L15;
        RoomTitle r105 = r104.getRoomTitle();
    L16:
        if (r105 == null) goto L19;
        this.F = r105.isGameUIStyle();
    L19:
        if (this.F == true) goto L21;
    L117:
        ConstraintLayout r106 = this.f64655t;
        if (r106 == null) goto L121;
        r106.setVisibility(0);
    L121:
        if (d90.c.i((d90.a) K()) == false) goto L132;
        if (this.F == false) goto L132;
        MiddlewareRoomContext r107 = d90.e.l((d90.d) K());
        if (r107 == null) goto L132;
        m<Boolean> r108 = r107.isShowTitleUIByClickScreen();
        if (r108 == null) goto L132;
        Observable<Boolean> r109 = r108.a();
        if (r109 == null) goto L132;
        r109.subscribe(new com.bytedance.android.live.componentsmarket.impl.components.title.a(this));
    L132:
        if (this.F == true) goto L134;
    L138:
        View r110 = this.f64658w;
        if (r110 == null) goto L142;
        UtilityKotlinExtentionsKt.t(r110);
    L142:
        if (this.F == true) goto L144;
        TextView r111 = this.f64659x;
        if (r111 == null) goto L166;
        r111.setTextSize(1, 16.0f);
    L166:
        com.bytedance.android.livesdk.common.j r112 = this.A;
        if (r112 == null) goto L169;
        r112.setTextSize(1, 16.0f);
    L169:
        Room r113 = this.f64506q;
        if (r113 == null) goto L176;
        ViewModel r114 = this.f64505p;
        if (r114 == null) goto L175;
        Intrinsics.checkNotNull(r113);
        ((BaseTitleViewModel) r114).setRoomInfo(r113);
        goto L176
    L175:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.componentsmarket.impl.components.title.model.BaseTitleViewModel");
    L176:
        ViewModel r115 = this.f64505p;
        if (r115 == null) goto L210;
        LiveData<Boolean> r116 = ((BaseTitleViewModel) r115).isTvStatusShow();
        if (r116 == null) goto L181;
        r116.observe(this, new com.bytedance.android.live.componentsmarket.impl.components.title.b(this));
    L181:
        ViewModel r117 = this.f64505p;
        if (r117 == null) goto L208;
        LiveData<String> r118 = ((BaseTitleViewModel) r117).getTitleText();
        if (r118 == null) goto L186;
        r118.observe(this, new com.bytedance.android.live.componentsmarket.impl.components.title.c(this));
    L186:
        ViewModel r119 = this.f64505p;
        if (r119 == null) goto L206;
        LiveData<String> r120 = ((BaseTitleViewModel) r119).getDesText();
        if (r120 == null) goto L191;
        r120.observe(this, new com.bytedance.android.live.componentsmarket.impl.components.title.d(this));
    L191:
        ViewModel r121 = this.f64505p;
        if (r121 == null) goto L204;
        LiveData<Boolean> r122 = ((BaseTitleViewModel) r121).isTitleIconShow();
        if (r122 == null) goto L196;
        r122.observe(this, new com.bytedance.android.live.componentsmarket.impl.components.title.e(this));
    L196:
        ViewModel r123 = this.f64505p;
        if (r123 == null) goto L202;
        LiveData<Boolean> r124 = ((BaseTitleViewModel) r123).isPrefixImgShow();
        if (r124 == null) goto L211;
        r124.observe(this, new com.bytedance.android.live.componentsmarket.impl.components.title.f(this));
        goto L211
    L202:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.componentsmarket.impl.components.title.model.BaseTitleViewModel");
    L204:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.componentsmarket.impl.components.title.model.BaseTitleViewModel");
    L206:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.componentsmarket.impl.components.title.model.BaseTitleViewModel");
    L208:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.componentsmarket.impl.components.title.model.BaseTitleViewModel");
    L210:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.componentsmarket.impl.components.title.model.BaseTitleViewModel");
    L144:
        if (isScreenPortrait() == false) goto L157;
        ConstraintLayout r125 = this.f64655t;
        if (r125 == null) goto L148;
        a1.k(r125, (int) t6.a(((d90.a) K()).getContext(), 36.0f));
    L148:
        TextView r126 = this.f64659x;
        if (r126 == null) goto L151;
        r126.setTextSize(1, 13.0f);
    L151:
        TextView r127 = this.f64659x;
        if (r127 == null) goto L154;
        r127.setPadding(0, 0, UtilityKotlinExtentionsKt.i(58), 0);
    L154:
        com.bytedance.android.livesdk.common.j r128 = this.A;
        if (r128 == null) goto L169;
        r128.setTextSize(1, 13.0f);
        goto L169
    L157:
        TextView r129 = this.f64659x;
        if (r129 == null) goto L160;
        r129.setTextSize(1, 15.0f);
    L160:
        com.bytedance.android.livesdk.common.j r130 = this.A;
        if (r130 == null) goto L169;
        r130.setTextSize(1, 15.0f);
        goto L169
    L134:
        if (isScreenPortrait() == false) goto L138;
        View r131 = this.f64658w;
        if (r131 == null) goto L142;
        UtilityKotlinExtentionsKt.w(r131);
        goto L142
    L21:
        if (d90.c.i((d90.a) K()) == false) goto L117;
        d90.a r132 = (d90.a) K();
        if (r132 == null) goto L27;
        DataCenter r133 = r132.f467480h;
        if (r133 == null) goto L27;
        Integer r134 = (Integer) r133.get("data_screen_change_status", 0);
    L28:
        if (r134 != null) goto L30;
    L32:
        boolean r135 = false;
    L33:
        int r136 = o40.b.f521942a;
        o r137 = j0.l().c(x.class);
        if (r137 != null) goto L37;
    L73:
        boolean r138 = false;
    L74:
        if (r138 == false) goto L79;
        if (r135 == true) goto L79;
        ConstraintLayout r139 = this.f64655t;
        if (r139 == null) goto L121;
        r139.setVisibility(8);
    L79:
        MiddlewareRoomContext r140 = d90.e.l((d90.d) K());
        if (r140 == null) goto L121;
        r140.isShowTitleUIByClickScreen().setValue(Boolean.TRUE);
        ConstraintLayout r141 = this.f64655t;
        if (r141 == null) goto L84;
        r141.setVisibility(0);
    L84:
        RoomContext r142 = (RoomContext) d90.e.l((d90.d) K());
        Disposable r143 = this.D;
        if (r143 != null) goto L87;
    L91:
        LiveVisibilityControlContext.Companion.getClass();
        if (LiveVisibilityControlContext.a.a() == false) goto L111;
        DataCenter r144 = o3.f().getDataCenter();
        if (r144 == null) goto L99;
        IVisibilityControlBrickService r145 = (IVisibilityControlBrickService) jc1.k.f(IVisibilityControlBrickService.class);
        if (r145 == null) goto L99;
        IVisibilityControlService r146 = r145.provideVisibilityControlService(r144);
    L100:
        if (r146 == null) goto L111;
        DataCenter r147 = o3.f().getDataCenter();
        if (r147 == null) goto L107;
        IVisibilityControlBrickService r148 = (IVisibilityControlBrickService) jc1.k.f(IVisibilityControlBrickService.class);
        if (r148 == null) goto L107;
        IVisibilityControlService r149 = r148.provideVisibilityControlService(r147);
    L108:
        if (r149 == null) goto L110;
        Observable r150 = r149.startVisibilityTimer();
    L112:
        if (r150 == null) goto L116;
        Observable r151 = r150.observeOn(AndroidSchedulers.mainThread());
        if (r151 == null) goto L116;
        r101 = r151.subscribe(new k(r142));
    L116:
        this.D = r101;
        goto L121
    L110:
        r150 = null;
    L107:
        r149 = null;
    L99:
        r146 = null;
    L111:
        r150 = Observable.timer(lj.f120685a.getValue().a(), TimeUnit.SECONDS).map(j.f64682a);
        goto L112
    L87:
        if (r143.isDisposed() == true) goto L91;
        Disposable r152 = this.D;
        if (r152 == null) goto L91;
        r152.dispose();
        goto L91
    L37:
        if (r137.getMap() == null) goto L73;
        String r153 = "";
        if (r137.getMap().containsKey("enter_from_merge") == false) goto L44;
        String r154 = r137.getMap().get("enter_from_merge");
        if (r154 != null) goto L46;
        r154 = "";
    L46:
        if (r137.getMap().containsKey("enter_method") == false) goto L50;
        String r155 = r137.getMap().get("enter_method");
        if (r155 != null) goto L52;
        r155 = "";
    L52:
        if (r137.getMap().containsKey("action_type") == false) goto L57;
        String r156 = r137.getMap().get("action_type");
        if (r156 == null) goto L59;
        r153 = r156;
    L59:
        if (UserProfileEvent.DATA_TYPE_HOME_PAGE_HOT.equals(r154) == true) goto L69;
        if ("homepage_follow".equals(r154) == true) goto L69;
        if ("homepage_tablive".equals(r154) == true) goto L69;
        if (SearchResultParam.ENTER_PAGE_GENERAL_SEARCH.equals(r154) == true) goto L69;
        if ("search_result".equals(r154) == false) goto L73;
    L69:
        if ("live_cell".equals(r155) == false) goto L73;
        if ("click".equals(r153) == false) goto L73;
        r138 = true;
        goto L74
    L57:
        r153 = null;
        goto L59
    L50:
        r155 = null;
        goto L52
    L44:
        r154 = null;
        goto L46
    L30:
        if (r134.intValue() <= 0) goto L32;
        r135 = true;
    L27:
        r134 = null;
    L15:
        r105 = null;
    L9:
        r103 = null;
    L211:
        super.W();
    }

    @Override // com.bytedance.android.live.componentsmarket.impl.components.BaseComponentsTetris
    public final o40.a c0() {
        return new s40.a();
    }

    public final String j0() {
        ViewModel r100 = this.f64505p;
        if (r100 != null) goto L5;
    L14:
        return "";
    L5:
        if ((r100 instanceof BaseTitleViewModel) == false) goto L14;
        if (r100 == null) goto L13;
        String r101 = ((BaseTitleViewModel) r100).getTitleText().getValue();
        if (r101 != null) goto L11;
        return "";
    L11:
        return r101;
    L13:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.componentsmarket.impl.components.title.model.BaseTitleViewModel");
    }

    public final boolean k0() {
        if (this.F == true) goto L5;
    L8:
        return true;
    L5:
        if (isScreenPortrait() == false) goto L8;
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.android.live.componentsmarket.impl.components.BaseComponentsTetris, com.bytedance.android.live.core.tetris.layer.core.tetris.Tetris
    public final void onDestroy() {
        com.bytedance.android.livesdk.common.j r100 = this.A;
        if (r100 == null) goto L5;
        r100.cancelAnimation();
    L5:
        Disposable r101 = this.D;
        if (r101 != null) goto L8;
    L12:
        RoomContext r102 = ((d90.a) K()).b();
        if (r102 == null) goto L19;
        com.bytedance.live.datacontext.j<d9> r103 = r102.getRoomTitleAndAnchorNameTimer();
        if (r103 == null) goto L19;
        d9 r104 = r103.getValue();
        if (r104 == null) goto L19;
        r104.c(this.G);
    L19:
        Disposable r105 = this.B;
        if (r105 == null) goto L22;
        r105.dispose();
    L22:
        super.onDestroy();
        return;
    L8:
        if (r101.isDisposed() == true) goto L12;
        Disposable r106 = this.D;
        if (r106 == null) goto L12;
        r106.dispose();
        goto L12
    }

    public TitleTetris() {
        this.G = new TitleTetris$timerListener$1(this);
    }

    @Override // com.bytedance.android.live.componentsmarket.impl.components.BaseComponentsTetris, com.bytedance.android.live.core.tetris.layer.core.tetris.Tetris
    public final void O() {
        super.O();
        Disposable r100 = null;
        RoomContext r101 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r101 == null) goto L9;
        m<Long> r102 = r101.getCurrentMatchId();
        if (r102 == null) goto L9;
        Observable<Long> r103 = r102.a();
        if (r103 == null) goto L9;
        r100 = r103.subscribe(new e(this));
    L9:
        this.B = r100;
        ConstraintLayout r104 = this.f64655t;
        if (r104 == null) goto L13;
        r104.setPadding(0, 0, 0, 0);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.android.live.componentsmarket.impl.components.BaseComponentsTetris
    public final void d0() {
        DataCenter r100 = ((d90.a) K()).f467480h;
        if (r100 == null) goto L6;
        r100.observe("data_is_hiding_landscape_buttons", this);
    L6:
        if (qu0.f121084a.getValue().booleanValue() == false) goto L14;
        DataCenter r101 = ((d90.a) K()).f467480h;
        if (r101 == null) goto L10;
        r101.observe("data_room_title", this);
    L10:
        DataCenter r102 = ((d90.a) K()).f467480h;
        if (r102 == null) goto L15;
        r102.observe("data_room_short_title", this);
        return;
    L15:
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.android.live.componentsmarket.impl.components.BaseComponentsTetris
    public final void f0() {
        this.f64658w = Z().findViewById(R.id.title_bg);
        this.f64654s = (TextView) Z().findViewById(R.id.tv_status);
        this.f64655t = (ConstraintLayout) Z().findViewById(R.id.title_root);
        this.f64659x = (TextView) Z().findViewById(R.id.tv_title);
        this.f64656u = (TextView) Z().findViewById(R.id.tv_desc);
        this.f64657v = Z().findViewById(R.id.title_icon);
        this.f64660y = Z().findViewById(R.id.title_container);
        this.f64661z = Z().findViewById(R.id.title_container_child);
        this.A = (com.bytedance.android.livesdk.common.j) Z().findViewById(R.id.marquee_title);
        this.C = (HSImageView) Z().findViewById(R.id.iv_prefix_img);
        super.f0();
        IVSPlayerService r100 = (IVSPlayerService) jc1.k.f(IVSPlayerService.class);
        if (r100 == null) goto L5;
        com.bytedance.android.livesdk.chatroom.vsplayer.api.c r101 = r100.provideVSPlayerViewControlService(((d90.a) K()).f467480h);
    L6:
        com.bytedance.android.livesdk.chatroom.vsplayer.api.c r102 = r101;
        if (r102 == null) goto L10;
        com.bytedance.android.livesdk.chatroom.vsplayer.api.c.a.a(r102, PlayerViewControl.KEY.LandscapeRoomTitle, PlayerViewControl.Type.TOP, PlayerViewControl.Style.HIDE, Z(), 0.0f, true, false, this, MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_HTTP_REQ_FINSIH_TIME);
        return;
    L10:
        return;
    L5:
        r101 = null;
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.android.live.componentsmarket.impl.components.titledetail.a.InterfaceC1061a
    public final void onHide() {
        if (isScreenPortrait() == false) goto L9;
        d90.a r100 = (d90.a) K();
        if (r100 == null) goto L9;
        DataCenter r101 = r100.f467480h;
        if (r101 == null) goto L9;
        r101.put("data_media_introduction_showing", Boolean.FALSE);
    L9:
        View r102 = this.f64657v;
        if (r102 == null) goto L18;
        ViewPropertyAnimator r103 = r102.animate();
        if (r103 == null) goto L18;
        ViewPropertyAnimator r104 = r103.rotation(0.0f);
        if (r104 == null) goto L18;
        ViewPropertyAnimator r105 = r104.setDuration(200);
        if (r105 == null) goto L18;
        ViewPropertyAnimator r106 = r105.setInterpolator(new DecelerateInterpolator());
    L19:
        if (r106 == null) goto L22;
        r106.start();
    L22:
        if (r3.l(((d90.a) K()).getContext()) == false) goto L24;
        r3.q(((d90.a) K()).getContext(), "已收起");
    L24:
        o0(null);
        return;
    L18:
        r106 = null;
        goto L19
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.android.live.componentsmarket.impl.components.titledetail.a.InterfaceC1061a
    public final void onShow() {
        if (isScreenPortrait() == false) goto L9;
        d90.a r100 = (d90.a) K();
        if (r100 == null) goto L9;
        DataCenter r101 = r100.f467480h;
        if (r101 == null) goto L9;
        r101.put("data_media_introduction_showing", Boolean.TRUE);
    L9:
        View r102 = this.f64657v;
        if (r102 == null) goto L18;
        ViewPropertyAnimator r103 = r102.animate();
        if (r103 == null) goto L18;
        ViewPropertyAnimator r104 = r103.rotation(180.0f);
        if (r104 == null) goto L18;
        ViewPropertyAnimator r105 = r104.setDuration(200);
        if (r105 == null) goto L18;
        ViewPropertyAnimator r106 = r105.setInterpolator(new DecelerateInterpolator());
    L19:
        if (r106 == null) goto L22;
        r106.start();
    L22:
        if (r3.l(((d90.a) K()).getContext()) == false) goto L24;
        r3.q(((d90.a) K()).getContext(), "已展开");
    L24:
        o0(null);
        return;
    L18:
        r106 = null;
        goto L19
    }

    @Override // com.bytedance.android.live.core.tetris.layer.core.tetris.Tetris
    public final void onStop() {
        super.onStop();
    }

    public static final void i0(TitleTetris r100) {
        Room r101 = r100.f64506q;
        if (r101 == null) goto L134;
        RoomPlatformComponentsData r102 = r101.roomPlatformComponentsData;
        if (r102 == null) goto L136;
        RoomTitle r103 = r102.getRoomTitle();
        if (r103 == null) goto L137;
        String r104 = r103.getIntroduction();
        if (r104 != null) goto L11;
        return;
    L11:
        if (r104.length() != 0) goto L13;
        boolean r105 = true;
    L14:
        if (r105 == false) goto L16;
        return;
    L16:
        if (r100.isScreenPortrait() == false) goto L144;
        com.bytedance.android.live.componentsmarket.impl.components.titledetail.a.b r106 = com.bytedance.android.live.componentsmarket.impl.components.titledetail.a.f64696a;
        ConstraintLayout r107 = r100.f64655t;
        Intrinsics.checkNotNull(r107);
        int r108 = r107.getWidth();
        com.bytedance.android.live.componentsmarket.impl.components.titledetail.a.f64698c = r107;
        com.bytedance.android.live.componentsmarket.impl.components.titledetail.a.f64699d = r108;
        com.bytedance.android.live.componentsmarket.impl.components.titledetail.a.b r109 = com.bytedance.android.live.componentsmarket.impl.components.titledetail.a.f64696a;
        if (r109 != null) goto L21;
    L23:
        com.bytedance.android.live.componentsmarket.impl.components.titledetail.a.b r110 = com.bytedance.android.live.componentsmarket.impl.components.titledetail.a.f64696a;
        if (r110 != null) goto L26;
        return;
    L26:
        if (com.bytedance.android.live.componentsmarket.impl.components.titledetail.a.f64698c != null) goto L28;
        return;
    L28:
        if (com.bytedance.android.live.componentsmarket.impl.components.titledetail.a.f64703h != null) goto L30;
        return;
    L30:
        if (com.bytedance.android.live.componentsmarket.impl.components.titledetail.a.f64707l != null) goto L33;
        return;
    L33:
        if (r110.isShowing() == true) goto L146;
        View r111 = com.bytedance.android.live.componentsmarket.impl.components.titledetail.a.f64703h;
        ViewGroup.LayoutParams r112 = null;
        if (r111 == null) goto L61;
        ViewParent r113 = r111.getParent();
        if ((r113 instanceof ViewGroup) == true) goto L40;
        r113 = null;
    L40:
        ViewGroup r114 = (ViewGroup) r113;
        com.bytedance.android.live.componentsmarket.impl.components.titledetail.a.f64705j = r114;
        if (r114 == null) goto L43;
        Integer r115 = Integer.valueOf(r114.indexOfChild(com.bytedance.android.live.componentsmarket.impl.components.titledetail.a.f64703h));
    L44:
        com.bytedance.android.live.componentsmarket.impl.components.titledetail.a.f64704i = r115;
        View r116 = com.bytedance.android.live.componentsmarket.impl.components.titledetail.a.f64703h;
        if (r116 == null) goto L47;
        ViewGroup.LayoutParams r117 = r116.getLayoutParams();
    L48:
        com.bytedance.android.live.componentsmarket.impl.components.titledetail.a.f64706k = r117;
        ViewGroup r118 = com.bytedance.android.live.componentsmarket.impl.components.titledetail.a.f64705j;
        if (r118 == null) goto L51;
        r118.removeView(com.bytedance.android.live.componentsmarket.impl.components.titledetail.a.f64703h);
    L51:
        com.bytedance.android.live.componentsmarket.impl.components.titledetail.a.b r119 = com.bytedance.android.live.componentsmarket.impl.components.titledetail.a.f64696a;
        if (r119 == null) goto L56;
        ViewGroup r120 = r119.r3();
        if (r120 == null) goto L56;
        r120.removeAllViews();
    L56:
        com.bytedance.android.live.componentsmarket.impl.components.titledetail.a.b r121 = com.bytedance.android.live.componentsmarket.impl.components.titledetail.a.f64696a;
        if (r121 == null) goto L61;
        ViewGroup r122 = r121.r3();
        if (r122 == null) goto L61;
        r122.addView(com.bytedance.android.live.componentsmarket.impl.components.titledetail.a.f64703h);
        goto L61
    L47:
        r117 = null;
        goto L48
    L43:
        r115 = null;
    L61:
        View r123 = com.bytedance.android.live.componentsmarket.impl.components.titledetail.a.f64707l;
        if (r123 == null) goto L92;
        ViewParent r124 = r123.getParent();
        if ((r124 instanceof ViewGroup) == true) goto L66;
        r124 = null;
    L66:
        ViewGroup r125 = (ViewGroup) r124;
        com.bytedance.android.live.componentsmarket.impl.components.titledetail.a.f64709n = r125;
        if (r125 == null) goto L69;
        Integer r126 = Integer.valueOf(r125.indexOfChild(com.bytedance.android.live.componentsmarket.impl.components.titledetail.a.f64707l));
    L70:
        com.bytedance.android.live.componentsmarket.impl.components.titledetail.a.f64708m = r126;
        View r127 = com.bytedance.android.live.componentsmarket.impl.components.titledetail.a.f64707l;
        if (r127 == null) goto L73;
        ViewGroup.LayoutParams r128 = r127.getLayoutParams();
    L74:
        com.bytedance.android.live.componentsmarket.impl.components.titledetail.a.f64710o = r128;
        ViewGroup r129 = com.bytedance.android.live.componentsmarket.impl.components.titledetail.a.f64709n;
        if (r129 == null) goto L77;
        r129.removeView(com.bytedance.android.live.componentsmarket.impl.components.titledetail.a.f64707l);
    L77:
        com.bytedance.android.live.componentsmarket.impl.components.titledetail.a.b r130 = com.bytedance.android.live.componentsmarket.impl.components.titledetail.a.f64696a;
        if (r130 == null) goto L82;
        ViewGroup r131 = r130.B2();
        if (r131 == null) goto L82;
        r131.removeAllViews();
    L82:
        com.bytedance.android.live.componentsmarket.impl.components.titledetail.a.b r132 = com.bytedance.android.live.componentsmarket.impl.components.titledetail.a.f64696a;
        if (r132 == null) goto L87;
        ViewGroup r133 = r132.B2();
        if (r133 == null) goto L87;
        r133.addView(com.bytedance.android.live.componentsmarket.impl.components.titledetail.a.f64707l);
    L87:
        com.bytedance.android.live.componentsmarket.impl.components.titledetail.a.b r134 = com.bytedance.android.live.componentsmarket.impl.components.titledetail.a.f64696a;
        if (r134 == null) goto L92;
        ViewGroup r135 = r134.B2();
        if (r135 == null) goto L92;
        UtilityKotlinExtentionsKt.w(r135);
        goto L92
    L73:
        r128 = null;
        goto L74
    L69:
        r126 = null;
    L92:
        View r136 = com.bytedance.android.live.componentsmarket.impl.components.titledetail.a.f64698c;
        if (r136 == null) goto L127;
        ViewParent r137 = r136.getParent();
        if ((r137 instanceof ViewGroup) == true) goto L97;
        r137 = null;
    L97:
        ViewGroup r138 = (ViewGroup) r137;
        com.bytedance.android.live.componentsmarket.impl.components.titledetail.a.f64701f = r138;
        if (r138 == null) goto L100;
        Integer r139 = Integer.valueOf(r138.indexOfChild(com.bytedance.android.live.componentsmarket.impl.components.titledetail.a.f64698c));
    L101:
        com.bytedance.android.live.componentsmarket.impl.components.titledetail.a.f64700e = r139;
        View r140 = com.bytedance.android.live.componentsmarket.impl.components.titledetail.a.f64698c;
        if (r140 == null) goto L104;
        r112 = r140.getLayoutParams();
    L104:
        com.bytedance.android.live.componentsmarket.impl.components.titledetail.a.f64702g = r112;
        ViewGroup r141 = com.bytedance.android.live.componentsmarket.impl.components.titledetail.a.f64701f;
        if (r141 == null) goto L107;
        r141.removeView(com.bytedance.android.live.componentsmarket.impl.components.titledetail.a.f64698c);
    L107:
        ConstraintLayout.LayoutParams r142 = new ConstraintLayout.LayoutParams(com.bytedance.android.live.componentsmarket.impl.components.titledetail.a.f64699d, s1.f(52.0f));
        com.bytedance.android.live.componentsmarket.impl.components.titledetail.a.b r143 = com.bytedance.android.live.componentsmarket.impl.components.titledetail.a.f64696a;
        if (r143 == null) goto L112;
        ViewGroup r144 = r143.J4();
        if (r144 == null) goto L112;
        a1.j(r144, 16);
    L112:
        com.bytedance.android.live.componentsmarket.impl.components.titledetail.a.b r145 = com.bytedance.android.live.componentsmarket.impl.components.titledetail.a.f64696a;
        if (r145 == null) goto L117;
        ViewGroup r146 = r145.J4();
        if (r146 == null) goto L117;
        r146.setLayoutParams(r142);
    L117:
        com.bytedance.android.live.componentsmarket.impl.components.titledetail.a.b r147 = com.bytedance.android.live.componentsmarket.impl.components.titledetail.a.f64696a;
        if (r147 == null) goto L122;
        ViewGroup r148 = r147.J4();
        if (r148 == null) goto L122;
        r148.removeAllViews();
    L122:
        com.bytedance.android.live.componentsmarket.impl.components.titledetail.a.b r149 = com.bytedance.android.live.componentsmarket.impl.components.titledetail.a.f64696a;
        if (r149 == null) goto L127;
        ViewGroup r150 = r149.J4();
        if (r150 == null) goto L127;
        r150.addView(com.bytedance.android.live.componentsmarket.impl.components.titledetail.a.f64698c);
        goto L127
    L100:
        r139 = null;
    L127:
        com.bytedance.android.live.componentsmarket.impl.components.titledetail.a.b r151 = com.bytedance.android.live.componentsmarket.impl.components.titledetail.a.f64696a;
        if (r151 == null) goto L130;
        r151.y2();
    L130:
        Iterator<com.bytedance.android.live.componentsmarket.impl.components.titledetail.a.InterfaceC1061a> r152 = com.bytedance.android.live.componentsmarket.impl.components.titledetail.a.f64697b.iterator();
    L132:
        if (r152.hasNext() == false) goto L147;
        r152.next().onShow();
        goto L132
    L147:
        return;
    L146:
        return;
    L21:
        if (r109.isShowing() != true) goto L23;
        com.bytedance.android.live.componentsmarket.impl.components.titledetail.a.a();
        return;
    L144:
        return;
    L13:
        r105 = false;
        goto L14
    L137:
        return;
    L136:
        return;
    }

    @Override // com.bytedance.android.live.componentsmarket.impl.components.BaseComponentsTetris, com.bytedance.android.live.core.tetris.layer.core.tetris.Tetris
    public final View G(t70.k r100) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        return super.G(r100);
    }

    @Override // com.bytedance.android.live.componentsmarket.impl.components.BaseComponentsTetris
    public final ViewModel a0(FragmentActivity r100) {
        Intrinsics.checkNotNullParameter(r100, "cxt");
        BaseTitleViewModel.a r101 = BaseTitleViewModel.Companion;
        BaseTitleViewModel.ComponentsType r102 = BaseTitleViewModel.ComponentsType.IS_VS;
        r101.getClass();
        return BaseTitleViewModel.a.a(r102, r100);
    }

    @Override // com.bytedance.android.live.componentsmarket.impl.components.BaseComponentsTetris
    public final ConstraintLayout b0(t70.k r100) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        if (isScreenPortrait() == false) goto L5;
        int r101 = R.layout.ttlive_title_widget;
    L6:
        View r102 = r100.b(r101);
        if (r102 == null) goto L11;
        return (ConstraintLayout) r102;
    L11:
        throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout");
    L5:
        r101 = R.layout.ttlive_title_landscape_widget;
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.android.livesdk.chatroom.vsplayer.model.a
    public final boolean canControlByPlayer(PlayerViewControl.KEY r100) {
        Intrinsics.checkNotNullParameter(r100, "key");
        return d90.c.f((d90.a) K());
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.android.live.componentsmarket.impl.components.BaseComponentsTetris
    public final void g0(KVData r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (TextUtils.isEmpty(r100.getKey()) == true) goto L126;
        String r101 = r100.getKey();
        int r102 = r101.hashCode();
        Object r103 = null;
        if (r102 == 956730793) goto L51;
        if (r102 == 1511434086) goto L34;
        if (r102 == 1883240861) goto L14;
        return;
    L14:
        if (r101.equals("data_is_hiding_landscape_buttons") == false) goto L109;
        Object r104 = r100.getData();
        if ((r104 instanceof Boolean) == false) goto L19;
        r103 = r104;
    L19:
        Boolean r105 = (Boolean) r103;
        if (r105 == null) goto L110;
        boolean r106 = r105.booleanValue();
        if (this.F == true) goto L24;
        return;
    L24:
        if (isScreenPortrait() == true) goto L112;
        com.bytedance.android.livesdk.common.j r107 = this.A;
        if (r107 == null) goto L28;
        r107.cancelAnimation();
    L28:
        com.bytedance.android.livesdk.common.j r108 = this.A;
        if (r108 == null) goto L31;
        r108.scrollToOrigin();
    L31:
        if (r106 == true) goto L113;
        Z().postDelayed(new d(this), 800);
        return;
    L113:
        return;
    L112:
        return;
    L110:
        return;
    L109:
        return;
    L34:
        if (r101.equals("data_room_short_title") == true) goto L36;
        return;
    L36:
        if (k0() == false) goto L44;
        com.bytedance.android.livesdk.common.j r109 = this.A;
        if ((r109 instanceof FrameLayout) == false) goto L41;
        r103 = r109;
    L41:
        FrameLayout r110 = (FrameLayout) r103;
        if (r110 == null) goto L47;
        a1.m(r110, s1.f(0.0f));
    L47:
        o40.a r111 = this.f64507r;
        if (r111 == null) goto L116;
        r111.c();
        return;
    L116:
        return;
    L44:
        TextView r112 = this.f64659x;
        if (r112 == null) goto L47;
        a1.m(r112, s1.f(8.0f));
        goto L47
    L51:
        if (r101.equals("data_room_title") == false) goto L118;
        Object r113 = r100.getData();
        if ((r113 instanceof String) == false) goto L56;
        r103 = r113;
    L56:
        String r114 = (String) r103;
        if (r114 != null) goto L59;
        return;
    L59:
        if ((!Intrinsics.areEqual(r114, "")) == true) goto L61;
        return;
    L61:
        if (qu0.f121084a.getValue().booleanValue() == false) goto L77;
        DataCenter r115 = ((d90.a) K()).f467480h;
        if (r115 == null) goto L71;
        Room r116 = z.o(r115);
        if (r116 == null) goto L71;
        RoomPlatformComponentsData r117 = r116.roomPlatformComponentsData;
        if (r117 == null) goto L71;
        RoomTitle r118 = r117.getRoomTitle();
        if (r118 == null) goto L71;
        r118.setTitle(r114);
    L71:
        ViewModel r119 = this.f64505p;
        if (r119 == null) goto L75;
        ((BaseTitleViewModel) r119).titleText(r114);
        goto L77
    L75:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.componentsmarket.impl.components.title.model.BaseTitleViewModel");
    L77:
        if (k0() == false) goto L92;
        DataCenter r120 = ((d90.a) K()).f467480h;
        if (r120 == null) goto L85;
        Room r121 = z.o(r120);
        if (r121 == null) goto L85;
        EpisodeExtraInfo r122 = r121.getEpisodeExtra2();
        if (r122 == null) goto L85;
        r122.setTitle(r114);
    L85:
        nm1.m r123 = pm1.f.l();
        if (r123 != null) goto L88;
    L90:
        n0(false);
        goto L92
    L88:
        if (r123.y(((d90.a) K()).f467480h) != true) goto L90;
        return;
    L92:
        if (k0() == true) goto L94;
        TextView r124 = this.f64659x;
        if (r124 == null) goto L104;
        r124.setEllipsize(TextUtils.TruncateAt.END);
    L104:
        TextView r125 = this.f64659x;
        if (r125 == null) goto L125;
        r125.setText(r114);
        return;
    L125:
        return;
    L94:
        if (this.F == false) goto L98;
        com.bytedance.android.livesdk.common.j r126 = this.A;
        if (r126 == null) goto L121;
        r126.setTextWithFadingMode(r114);
        return;
    L121:
        return;
    L98:
        com.bytedance.android.livesdk.common.j r127 = this.A;
        if (r127 == null) goto L123;
        r127.setTextWithEllipsis(r114);
        return;
    L123:
        return;
    L118:
        return;
    }

    public final void l0(boolean r100) {
        ObjectAnimator r101 = this.E;
        if (r101 != null) goto L5;
    L9:
        ObjectAnimator r102 = null;
        if (r100 == false) goto L14;
        ConstraintLayout r103 = this.f64655t;
        if (r103 == null) goto L17;
        r103.setVisibility(0);
        r102 = ObjectAnimator.ofFloat(this.f64655t, "alpha", new float[]{0.0f, 1.0f});
    L17:
        this.E = r102;
        if (r102 == null) goto L20;
        r102.setDuration(200);
    L20:
        ObjectAnimator r104 = this.E;
        if (r104 == null) goto L23;
        r104.removeAllListeners();
    L23:
        ObjectAnimator r105 = this.E;
        if (r105 == null) goto L26;
        r105.start();
    L26:
        ObjectAnimator r106 = this.E;
        if (r106 == null) goto L30;
        r106.addListener(new f(this, r100));
        return;
    L30:
        return;
    L14:
        ConstraintLayout r107 = this.f64655t;
        if (r107 == null) goto L17;
        r102 = ObjectAnimator.ofFloat(r107, "alpha", new float[]{1.0f, 0.0f});
        goto L17
    L5:
        if (r101.isRunning() != true) goto L9;
        ObjectAnimator r108 = this.E;
        if (r108 == null) goto L9;
        r108.cancel();
        goto L9
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void n0(boolean r100) {
        if (r100 == false) goto L41;
        String r101 = "";
        if (((d90.a) K()).f467480h == null) goto L29;
        nm1.m r102 = pm1.f.l();
        if (r102 == null) goto L18;
        VSCameraInfo r103 = r102.K(((d90.a) K()).f467480h);
        if (r103 == null) goto L18;
        if (r103.cameraType != VSCameraType.CAMERA_TYPE_MATCH.getValue()) goto L18;
        nm1.m r104 = pm1.f.l();
        if (r104 == null) goto L17;
        VSCameraInfo r105 = r104.K(((d90.a) K()).f467480h);
        if (r105 == null) goto L17;
        final String r106 = r105.title;
        if (r106 == null) goto L17;
    L42:
        com.bytedance.android.livesdk.common.j r107 = this.A;
        Object r108 = null;
        if (r107 == null) goto L45;
        String r109 = r107.getOriginText();
    L47:
        if (r106.equals(r109) != true) goto L49;
        return;
    L49:
        com.bytedance.android.livesdk.common.j r110 = this.A;
        if (r110 == null) goto L53;
        r110.cancelAnimation();
    L53:
        if (k0() == false) goto L68;
        Object r111 = this.A;
        if ((r111 instanceof FrameLayout) == true) goto L57;
        r111 = null;
    L57:
        FrameLayout r112 = (FrameLayout) r111;
        if (r112 == null) goto L60;
        r112.setAlpha(1.0f);
    L60:
        com.bytedance.android.livesdk.common.j r113 = this.A;
        if ((r113 instanceof FrameLayout) == false) goto L64;
        r108 = r113;
    L64:
        FrameLayout r114 = (FrameLayout) r108;
        if (r114 == null) goto L67;
        UtilityKotlinExtentionsKt.w(r114);
    L67:
        ObjectAnimator r115 = ObjectAnimator.ofFloat(this.A, "alpha", new float[]{1.0f, 0.0f}).setDuration(200);
        Function1<Animator, Unit> r116 = new TitleTetris$updateTitle$1(this, r106);
        Intrinsics.checkNotNullParameter(r115, "$this$doOnComplete");
        Intrinsics.checkNotNullParameter(r116, "callback");
        r115.addListener(new com.bytedance.android.live.core.utils.e(r116));
        r115.start();
    L74:
        o0(r106);
        return;
    L68:
        TextView r117 = this.f64659x;
        if (r117 == null) goto L71;
        r117.setEllipsize(TextUtils.TruncateAt.END);
    L71:
        TextView r118 = this.f64659x;
        if (r118 == null) goto L74;
        r118.setText(r106);
        goto L74
    L45:
        r109 = null;
    L17:
        r106 = j0();
        ALogger.d("VSMediaMergeTitle", "currentVsTitle is " + r106 + " current cameratype is CAMERA_TYPE_MATCH");
    L18:
        Room r119 = this.f64506q;
        if (r119 == null) goto L28;
        RoomPlatformComponentsData r120 = r119.roomPlatformComponentsData;
        if (r120 == null) goto L28;
        RoomTitle r121 = r120.getRoomTitle();
        if (r121 == null) goto L28;
        String r122 = r121.getTitle();
        if (r122 == null) goto L28;
        r101 = r122;
    L28:
        ALogger.d("VSMediaMergeTitle", "currentVsTitle is " + r101 + " current cameratype is not CAMERA_TYPE_MATCH");
    L40:
        r106 = r101;
        goto L42
    L29:
        Room r123 = this.f64506q;
        if (r123 == null) goto L39;
        RoomPlatformComponentsData r124 = r123.roomPlatformComponentsData;
        if (r124 == null) goto L39;
        RoomTitle r125 = r124.getRoomTitle();
        if (r125 == null) goto L39;
        String r126 = r125.getTitle();
        if (r126 == null) goto L39;
        r101 = r126;
    L39:
        ALogger.d("VSMediaMergeTitle", "currentVsTitle is " + r101 + " current cameratype is not CAMERA_TYPE_MATCH");
        goto L40
    L41:
        r106 = j0();
        goto L42
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void o0(String r110) {
        if (isScreenPortrait() == false) goto L50;
        d90.a r100 = (d90.a) K();
        String r101 = null;
        if (r100 == null) goto L9;
        DataCenter r102 = r100.f467480h;
        if (r102 == null) goto L9;
        Boolean r103 = (Boolean) r102.get("data_media_introduction_showing", Boolean.FALSE);
    L10:
        boolean r104 = Intrinsics.areEqual(r103, Boolean.TRUE);
        String r105 = "收起";
        if (m40.a.f511830a.getValue().booleanValue() == false) goto L27;
        View r106 = this.f64660y;
        StringBuilder r107 = new StringBuilder();
        TextView r108 = this.f64659x;
        if (r108 == null) goto L17;
        CharSequence r109 = r108.getText();
        if (r109 == null) goto L17;
        r101 = r109.toString();
    L17:
        r107.append(m0(r110, r101));
        r107.append(' ');
        if (r104 == true) goto L21;
        r105 = "展开";
    L21:
        r107.append(r105);
        r107.append(", 按钮");
        r3.a(r106, r107.toString());
        View r111 = this.f64661z;
        if (r111 == null) goto L24;
        r111.setImportantForAccessibility(4);
    L24:
        View r112 = this.f64657v;
        if (r112 == null) goto L51;
        r112.setImportantForAccessibility(2);
        return;
    L51:
        return;
    L27:
        TextView r113 = this.f64659x;
        StringBuilder r114 = new StringBuilder();
        TextView r115 = this.f64659x;
        if (r115 == null) goto L32;
        CharSequence r116 = r115.getText();
        if (r116 == null) goto L32;
        String r117 = r116.toString();
    L33:
        r114.append(m0(r110, r117));
        r114.append(' ');
        if (r104 == false) goto L36;
        String r118 = "收起";
    L37:
        r114.append(r118);
        r114.append(", 按钮");
        r3.a(r113, r114.toString());
        com.bytedance.android.livesdk.common.j r119 = this.A;
        if (r119 == null) goto L40;
        View r120 = r119.getA11yDescView();
    L41:
        StringBuilder r121 = new StringBuilder();
        com.bytedance.android.livesdk.common.j r122 = this.A;
        if (r122 == null) goto L44;
        r101 = r122.getContent();
    L44:
        r121.append(m0(r110, r101));
        r121.append(' ');
        if (r104 == true) goto L48;
        r105 = "展开";
    L48:
        r121.append(r105);
        r121.append(", 按钮");
        r3.a(r120, r121.toString());
        return;
    L40:
        r120 = null;
        goto L41
    L36:
        r118 = "展开";
    L32:
        r117 = null;
    L9:
        r103 = null;
        goto L10
    }

    @Override // com.bytedance.android.live.componentsmarket.impl.components.BaseComponentsTetris, androidx.lifecycle.Observer
    public final /* bridge */ /* synthetic */ void onChanged(Object r100) {
        g0((KVData) r100);
    }

    @Override // o70.a
    public void onEvent(o70.b r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        if ((r100 instanceof bh1.b) == false) goto L11;
        int r101 = ((bh1.b) r100).f18997a;
        View r102 = this.f64660y;
        if (r102 == null) goto L7;
        r102.setTranslationY(r101);
    L7:
        View r103 = this.f64657v;
        if (r103 == null) goto L23;
        r103.setTranslationY(r101);
        return;
    L23:
        return;
    L11:
        if ((r100 instanceof bh1.a) == false) goto L25;
        bh1.a r104 = (bh1.a) r100;
        boolean r105 = r104.f18995a;
        boolean r106 = r104.f18996b;
        if (r105 == false) goto L15;
        int r107 = 4;
    L16:
        View r108 = this.f64660y;
        if (r108 == null) goto L19;
        r108.setVisibility(r107);
    L19:
        View r109 = this.f64657v;
        if (r109 == null) goto L26;
        r109.setVisibility(r107);
        return;
    L26:
        return;
    L15:
        r107 = 0;
        goto L16
    }

    public static String m0(String r100, String r101) {
        if (ln1.a.C6715a.a(r100) == true) goto L6;
        r100 = null;
    L6:
        if (r100 != null) goto L11;
        if (r101 != null) goto L10;
        r101 = "";
    L10:
        return r101;
    L11:
        return r100;
    }
}
