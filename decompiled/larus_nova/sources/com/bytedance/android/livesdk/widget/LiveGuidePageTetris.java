package com.bytedance.android.livesdk.widget;

import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.lifecycle.ViewModel;
import com.airbnb.lottie.LottieAnimationView;
import com.byted.cast.linkcommon.cybergarage.upnp.RootDescription;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.tetris.layer.core.tetris.LiveTetris;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.config.sg0;
import com.bytedance.android.livesdk.config.tp0;
import com.bytedance.android.livesdk.config.vs;
import com.bytedance.android.livesdk.utils.LifecycleOwnerCompat;
import com.bytedance.android.livesdk.w8;
import com.bytedance.android.livesdk.z8;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.depend.model.live.RoomLinkInfo;
import com.bytedance.android.livesdkapi.distribution.EXTERNAL_CONFIG_TYPE;
import com.bytedance.android.livesdkapi.distribution.IExternalConfigJudger;
import com.bytedance.android.livesdkapi.distribution.config.GestureAction;
import com.bytedance.android.livesdkapi.distribution.config.GuideAction;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0001\u0006B\u0007¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/livesdk/widget/LiveGuidePageTetris;", "Lcom/bytedance/android/live/core/tetris/layer/core/tetris/LiveTetris;", "Lcom/bytedance/android/livesdk/widgetdescriptor/e0;", "", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveGuidePageTetris extends LiveTetris<com.bytedance.android.livesdk.widgetdescriptor.e0> {

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final /* synthetic */ int f160979w = 0;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public View f160980o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public LiveGuidePageViewModel f160981p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public HSImageView f160982q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public LottieAnimationView f160983r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public TextView f160984s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public View f160985t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public View f160986u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public Animation f160987v;

    public static final class a {
    }

    public static final class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LiveGuidePageTetris f160988a;

        public b(LiveGuidePageTetris r100) {
            this.f160988a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            LiveGuidePageViewModel r101 = this.f160988a.f160981p;
            if (r101 == null) goto L6;
            r101.onGuidePrepareGone();
            return;
        }
    }

    public static final class c<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LiveGuidePageTetris f160989a;

        public c(LiveGuidePageTetris r100) {
            this.f160989a = r100;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r100) {
            z r101 = (z) r100;
            if (r101 == null) goto L70;
            int r102 = LiveGuidePageTetris.f160979w;
            ALogger.d("LiveGuidePage", "guide show");
            LiveGuidePageTetris.V(this.f160989a).setAlpha(0.0f);
            LiveGuidePageTetris.V(this.f160989a).setVisibility(0);
            TextView r103 = this.f160989a.f160984s;
            if (r103 == null) goto L7;
            r103.setText(r101.f162269e);
        L7:
            LiveGuidePageTetris r104 = this.f160989a;
            r104.getClass();
            if (r101.f162267c <= 0) goto L22;
            View r105 = r104.f160986u;
            if (r105 == null) goto L13;
            ViewGroup.LayoutParams r106 = r105.getLayoutParams();
        L15:
            if ((r106 instanceof FrameLayout.LayoutParams) == true) goto L17;
            r106 = null;
        L17:
            FrameLayout.LayoutParams r107 = (FrameLayout.LayoutParams) r106;
            if (r107 == null) goto L22;
            r107.topMargin = r101.f162267c;
            r107.gravity = 1;
            View r108 = r104.f160986u;
            if (r108 == null) goto L22;
            r108.setLayoutParams(r107);
            goto L22
        L13:
            r106 = null;
        L22:
            LiveGuidePageTetris r109 = this.f160989a;
            r109.getClass();
            z8 r110 = r101.f162265a;
            if (r110 == null) goto L56;
            if (r110.f162566b == false) goto L35;
            String r111 = r110.f162565a;
            if (r111 != null) goto L29;
        L32:
            boolean r112 = true;
        L33:
            if (r112 == true) goto L35;
            boolean r113 = true;
        L36:
            if (r113 != true) goto L56;
            HSImageView r114 = r109.f160982q;
            if (r114 == null) goto L40;
            r114.setVisibility(8);
        L40:
            LottieAnimationView r115 = r109.f160983r;
            if (r115 == null) goto L43;
            r115.setVisibility(0);
        L43:
            LottieAnimationView r116 = r109.f160983r;
            if (r116 == null) goto L49;
            z8 r117 = r101.f162265a;
            Intrinsics.checkNotNull(r117);
            if (r117.f162566b == true) goto L48;
            r116.setAnimation(null);
            r116.setImageAssetsFolder(null);
            r116.loop(true);
            r116.playAnimation();
            goto L49
        L48:
            String r118 = com.bytedance.android.livesdk.chatroom.utils.i2.f114501a;
            com.bytedance.android.livesdk.chatroom.utils.i2.g(r116, "/guideview/" + r117.f162565a);
        L49:
            View r119 = r109.f160980o;
            if (r119 != null) goto L52;
            Intrinsics.throwUninitializedPropertyAccessException(RootDescription.ROOT_ELEMENT);
        L52:
            r119.setAlpha(1.0f);
            LiveGuidePageViewModel r120 = r109.f160981p;
            if (r120 == null) goto L82;
            r120.onGuideShow();
            return;
        L82:
            return;
        L29:
            if (StringsKt.isBlank(r111) == true) goto L32;
            r112 = false;
        L35:
            r113 = false;
        L56:
            if (r101.f162266b == null) goto L66;
            LottieAnimationView r121 = r109.f160983r;
            if (r121 == null) goto L60;
            r121.setVisibility(8);
        L60:
            HSImageView r122 = r109.f160982q;
            if (r122 == null) goto L63;
            r122.setVisibility(0);
        L63:
            HSImageView r123 = r109.f160982q;
            if (r123 == null) goto L84;
            r123.setController(Fresco.newDraweeControllerBuilder().setUri(r101.f162266b).setAutoPlayAnimations(true).setControllerListener(new b1(r109, r101)).build());
            return;
        L84:
            return;
        L66:
            LiveGuidePageViewModel r124 = r109.f160981p;
            if (r124 == null) goto L86;
            r124.onGuideLoadError("all img info is null");
            return;
        L86:
            return;
        L70:
            if (LiveGuidePageTetris.V(this.f160989a).getAlpha() != 1.0f) goto L78;
            ALogger.d("LiveGuidePage", "guide gone");
            this.f160989a.f160987v = new AlphaAnimation(1.0f, 0.0f);
            Animation r125 = this.f160989a.f160987v;
            if (r125 == null) goto L74;
            r125.setDuration(300);
        L74:
            Animation r126 = this.f160989a.f160987v;
            if (r126 == null) goto L77;
            r126.setAnimationListener(new c1(this));
        L77:
            LiveGuidePageTetris.V(this.f160989a).startAnimation(this.f160989a.f160987v);
            return;
        L78:
            ALogger.d("LiveGuidePage", "guide onGuideLoadErrorComplete");
            LiveGuidePageTetris.V(this.f160989a).setVisibility(8);
            LiveGuidePageViewModel r127 = this.f160989a.f160981p;
            if (r127 == null) goto L89;
            r127.onGuideLoadErrorComplete();
            return;
        }
    }

    static {
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v9, types: [h70.b] */
    @Override // com.bytedance.android.live.core.tetris.layer.core.tetris.Tetris
    public final void O() {
        RoomContext.a r100 = RoomContext.Companion;
        String r101 = null;
        RoomContext r102 = RoomContext.a.c(r100, null, 0, 3);
        if (r102 == null) goto L7;
        com.bytedance.live.datacontext.n<ViewModel> r103 = r102.getGuideInfoViewModel();
        if (r103 == null) goto L7;
        ((com.bytedance.android.livesdk.widgetdescriptor.e0) K()).getContext();
        DataCenter r104 = ((com.bytedance.android.livesdk.widgetdescriptor.e0) K()).f467480h;
        r103.setValue(new GuidePageModelFactory().create(LiveGuidePageViewModel.class));
    L7:
        RoomContext r105 = RoomContext.a.c(r100, null, 0, 3);
        if (r105 == null) goto L12;
        com.bytedance.live.datacontext.n<ViewModel> r106 = r105.getGuideInfoViewModel();
        if (r106 == null) goto L12;
        ViewModel r107 = r106.getValue();
    L13:
        this.f160981p = (LiveGuidePageViewModel) r107;
        StringBuilder r108 = new StringBuilder("guide info is  ");
        LiveGuidePageViewModel r109 = this.f160981p;
        if (r109 == null) goto L18;
        z r110 = r109.getGuideInfo();
        if (r110 == null) goto L18;
        r101 = r110.f162269e;
    L18:
        r108.append(r101);
        ALogger.d("LiveGuidePage", r108.toString());
        LiveGuidePageViewModel r111 = this.f160981p;
        if (r111 == null) goto L21;
        ?? r112 = K();
        DataCenter r113 = ((com.bytedance.android.livesdk.widgetdescriptor.e0) K()).f467480h;
        LifecycleOwnerCompat.CC.$default$getLifecycle(this).addObserver(new GuidePageController(r112, this, r111));
    L21:
        LiveGuidePageViewModel r114 = this.f160981p;
        if (r114 == null) goto L24;
        r114.observeGuideInfo(this, new c(this));
    L24:
        RoomContext r115 = ((com.bytedance.android.livesdk.widgetdescriptor.e0) K()).b();
        if (r115 == null) goto L33;
        com.bytedance.live.datacontext.n<IExternalConfigJudger> r116 = r115.getExternalConfigJudger();
        if (r116 == null) goto L33;
        IExternalConfigJudger r117 = r116.getValue();
        if (r117 == null) goto L33;
        if (r117.disable(EXTERNAL_CONFIG_TYPE.Gesture, GestureAction.zoom) != true) goto L33;
        return;
    L33:
        RoomContext r118 = ((com.bytedance.android.livesdk.widgetdescriptor.e0) K()).b();
        if (r118 == null) goto L55;
        com.bytedance.live.datacontext.n<IExternalConfigJudger> r119 = r118.getExternalConfigJudger();
        if (r119 == null) goto L55;
        IExternalConfigJudger r120 = r119.getValue();
        if (r120 == null) goto L55;
        if (r120.disable(EXTERNAL_CONFIG_TYPE.Guide, GuideAction.zoomGuide) != true) goto L55;
        return;
    L55:
        Result.Companion r121 = Result.Companion;     // Catch: Throwable -> L52
        com.bytedance.android.livesdk.e.b().getClass();     // Catch: Throwable -> L52
        if (com.bytedance.android.livesdk.e.c() == false) goto L46;
        return;
    L46:
        if (Z() == false) goto L50;
        com.bytedance.android.livesdk.sharedpref.e<Boolean> r122 = com.bytedance.android.livesdk.sharedpref.b.f158118a0;     // Catch: Throwable -> L52
        if (r122.getValue().booleanValue() == true) goto L50;
        w8 r123 = new w8(n3.f161871a, com.bytedance.android.live.core.utils.s1.B(R.string.ttlive_video_scale_guide_text));     // Catch: Throwable -> L52
        r123.f160661e = 10L;     // Catch: Throwable -> L52
        r123.f160660d = "https://lf1-webcastcdn-tos.douyinstatic.com/obj/live-android/clear_screen_scale_guide.webp";     // Catch: Throwable -> L52
        r123.f160657a = "live.pref.PREF_CLEARSCREEN_ZOOM_GUIDE";     // Catch: Throwable -> L52
        r123.f160658b = 1;     // Catch: Throwable -> L52
        xs2.b.a().post(r123);     // Catch: Throwable -> L52
        com.bytedance.android.livesdk.sharedpref.f.d(r122, Boolean.TRUE);     // Catch: Throwable -> L52
    L50:
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L52
        return;
    L52:
        th = move-exception;
        Result.Companion r124 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        return;
    L12:
        r107 = null;
        goto L13
    }

    @Override // com.bytedance.android.live.core.tetris.layer.core.tetris.Tetris
    public final void onDestroy() {
        ALogger.d("LiveGuidePage", "guide tetris onDestroy");
        super.onDestroy();
        Animation r100 = this.f160987v;
        String r101 = null;
        if (r100 == null) goto L5;
        r100.setAnimationListener(null);
    L5:
        Animation r102 = this.f160987v;
        if (r102 == null) goto L8;
        r102.cancel();
    L8:
        StringBuilder r103 = new StringBuilder("ondestroy: guide info is  ");
        LiveGuidePageViewModel r104 = this.f160981p;
        if (r104 == null) goto L13;
        z r105 = r104.getGuideInfo();
        if (r105 == null) goto L13;
        r101 = r105.f162269e;
    L13:
        r103.append(r101);
        ALogger.d("LiveGuidePage", r103.toString());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean W() {
        DataCenter r100 = ((com.bytedance.android.livesdk.widgetdescriptor.e0) K()).f467480h;
        IRoom r101 = null;
        if (r100 == null) goto L5;
        r101 = (IRoom) r100.get("data_room", null);
    L5:
        if (r101 != null) goto L7;
    L9:
        return false;
    L7:
        if (r101.isLiveTypeAudio() != true) goto L9;
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean Z() {
        DataCenter r100 = ((com.bytedance.android.livesdk.widgetdescriptor.e0) K()).f467480h;
        if (r100 == null) goto L7;
        Integer r101 = (Integer) r100.get("data_link_state", 0);
        if (r101 == null) goto L7;
        int r102 = r101.intValue();
    L8:
        int r103 = ((IInteractService) jc1.k.n(IInteractService.class)).getLinkMode();
        if (gd0.v.a(r103, 2) == false) goto L11;
    L18:
        boolean r104 = true;
    L19:
        if (r104 == true) goto L85;
        DataCenter r105 = ((com.bytedance.android.livesdk.widgetdescriptor.e0) K()).f467480h;
        Integer r106 = null;
        if (r105 == null) goto L23;
        IRoom r107 = (IRoom) r105.get("data_room", null);
    L24:
        if (r107 == null) goto L28;
        Map<String, Long> r108 = r107.getLinkMap();
        if (r108 == null) goto L28;
        Long r109 = r108.get(String.valueOf(7));
    L29:
        if (r109 == null) goto L31;
        boolean r110 = true;
    L32:
        if (r110 == true) goto L85;
        if (sg0.f121226a.getValue().booleanValue() == false) goto L41;
        boolean r111 = com.bytedance.android.live.revenue.core.util.h.f91037a;
        kc0.q r112 = ((kc0.j) com.bytedance.android.live.revenue.core.util.h.d(kc0.j.class)).getPkService();
        if (r112 == null) goto L39;
        r106 = Integer.valueOf(r112.getPkState());
    L39:
        if (r106.intValue() != 0) goto L62;
    L61:
        boolean r113 = false;
    L63:
        if (r113 == true) goto L85;
        if (vs.f121474a.getValue().booleanValue() == false) goto L105;
        com.bytedance.android.livesdk.widgetdescriptor.e0 r114 = (com.bytedance.android.livesdk.widgetdescriptor.e0) K();
        if (r114 == null) goto L106;
        DataCenter r115 = r114.f467480h;
        if (r115 != null) goto L72;
        return false;
    L72:
        if (com.bytedance.android.live.core.utils.z.m(r115, true) == true) goto L74;
        return false;
    L74:
        if (W() == true) goto L109;
        com.bytedance.android.livesdk.widgetdescriptor.e0 r116 = (com.bytedance.android.livesdk.widgetdescriptor.e0) K();
        if (r116 != null) goto L78;
    L80:
        boolean r117 = false;
    L81:
        if (r117 == true) goto L110;
        return true;
    L110:
        return false;
    L78:
        if (jr1.b.a(r116) != true) goto L80;
        r117 = true;
        goto L81
    L109:
        return false;
    L106:
        return false;
    L105:
        return false;
    L62:
        r113 = true;
        goto L63
    L41:
        RoomContext.a r118 = RoomContext.Companion;
        RoomContext r119 = RoomContext.a.c(r118, null, 0, 3);
        if (r119 == null) goto L48;
        com.bytedance.live.datacontext.m<Room> r120 = r119.getRoom();
        if (r120 == null) goto L48;
        Room r121 = r120.getValue();
        if (r121 == null) goto L48;
        RoomLinkInfo r122 = r121.getLinkMicInfo();
    L49:
        if (r122 != null) goto L62;
        RoomContext r123 = RoomContext.a.c(r118, null, 0, 3);
        if (r123 == null) goto L61;
        com.bytedance.live.datacontext.m<Room> r124 = r123.getRoom();
        if (r124 == null) goto L61;
        Room r125 = r124.getValue();
        if (r125 == null) goto L61;
        Map<String, Long> r126 = r125.getLinkMap();
        if (r126 == null) goto L61;
        if (r126.containsKey(String.valueOf(1)) != true) goto L61;
    L48:
        r122 = null;
        goto L49
    L31:
        r110 = false;
    L28:
        r109 = null;
        goto L29
    L23:
        r107 = null;
    L85:
        if (tp0.f121317a.getValue().booleanValue() == true) goto L87;
        return false;
    L87:
        if (vs.f121474a.getValue().booleanValue() == false) goto L112;
        com.bytedance.android.livesdk.widgetdescriptor.e0 r127 = (com.bytedance.android.livesdk.widgetdescriptor.e0) K();
        if (r127 == null) goto L113;
        DataCenter r128 = r127.f467480h;
        if (r128 != null) goto L93;
        return false;
    L93:
        if (com.bytedance.android.live.core.utils.z.m(r128, true) == true) goto L95;
        return false;
    L95:
        if (W() == true) goto L116;
        com.bytedance.android.livesdk.widgetdescriptor.e0 r129 = (com.bytedance.android.livesdk.widgetdescriptor.e0) K();
        if (r129 != null) goto L99;
    L101:
        boolean r130 = false;
    L102:
        if (r130 == true) goto L117;
        return true;
    L117:
        return false;
    L99:
        if (jr1.b.a(r129) != true) goto L101;
        r130 = true;
        goto L102
    L116:
        return false;
    L113:
        return false;
    L112:
        return false;
    L11:
        if (gd0.v.a(r103, 8) == true) goto L18;
        if (gd0.v.a(r103, 32) == true) goto L18;
        if (gd0.v.a(r102, 512) == true) goto L18;
        r104 = false;
    L7:
        r102 = 0;
        goto L8
    }

    public LiveGuidePageTetris() {
    }

    public static final /* synthetic */ View V(LiveGuidePageTetris r100) {
        View r101 = r100.f160980o;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException(RootDescription.ROOT_ELEMENT);
    L5:
        return r101;
    }

    @Override // com.bytedance.android.live.core.tetris.layer.core.tetris.Tetris
    public final View G(t70.k r100) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        View r101 = r100.b(R.layout.ttlive_guide_page);
        this.f160980o = r101;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException(RootDescription.ROOT_ELEMENT);
    L5:
        this.f160983r = (LottieAnimationView) r101.findViewById(R.id.guide_img_lottie);
        View r102 = this.f160980o;
        if (r102 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException(RootDescription.ROOT_ELEMENT);
    L8:
        this.f160982q = (HSImageView) r102.findViewById(R.id.guide_img_hsimage);
        View r103 = this.f160980o;
        if (r103 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException(RootDescription.ROOT_ELEMENT);
    L11:
        this.f160984s = (TextView) r103.findViewById(R.id.tv_desc);
        View r104 = this.f160980o;
        if (r104 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException(RootDescription.ROOT_ELEMENT);
    L14:
        this.f160985t = r104.findViewById(R.id.container_background);
        View r105 = this.f160980o;
        if (r105 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException(RootDescription.ROOT_ELEMENT);
    L17:
        this.f160986u = r105.findViewById(R.id.container_root);
        View r106 = this.f160980o;
        if (r106 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException(RootDescription.ROOT_ELEMENT);
    L20:
        r106.setOnClickListener(new b(this));
        View r107 = this.f160980o;
        if (r107 != null) goto L23;
        Intrinsics.throwUninitializedPropertyAccessException(RootDescription.ROOT_ELEMENT);
    L23:
        r107.setVisibility(8);
        View r108 = this.f160980o;
        if (r108 != null) goto L26;
        Intrinsics.throwUninitializedPropertyAccessException(RootDescription.ROOT_ELEMENT);
    L26:
        return r108;
    }
}
