package com.bytedance.android.livesdk.interactivity.enteranim.controller.v2.biz.animplayer;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.android.live.base.model.message.a5;
import com.bytedance.android.live.base.model.message.c5;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.gift.platform.business.effect.assets.IAssetsManager;
import com.bytedance.android.livesdk.interactivity.InteractivityPlatformContext;
import com.bytedance.android.livesdk.interactivity.enteranim.controller.v2.biz.RevenueUtils;
import com.bytedance.android.livesdk.message.model.va;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.ttm.player.MediaPlayer;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.subjects.PublishSubject;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes9.dex */
public final class Mp4EnhancedEnterPlayer extends AnimPlayer<k32.a> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final CompositeDisposable f136617c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Lazy f136618d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f136619e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Disposable f136620f;

    public static final class a implements Action {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Mp4EnhancedEnterPlayer f136621a;

        public a(Mp4EnhancedEnterPlayer r100) {
            this.f136621a = r100;
        }

        @Override // io.reactivex.functions.Action
        public final void run() {
            this.f136621a.f136617c.clear();
        }
    }

    public static final class b {
    }

    public static final class c<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Mp4EnhancedEnterPlayer$playAnim$2 f136622a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f136623b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ long f136624c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ com.bytedance.android.live.profit.player.d f136625d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ Mp4EnhancedEnterPlayer$playAnim$4 f136626e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ AnimPlayer.a f136627f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final /* synthetic */ com.bytedance.android.livesdk.interactivity.enteranim.controller.v2.biz.animplayer.a f136628g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final /* synthetic */ Mp4EnhancedEnterPlayer$playAnim$3 f136629h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final /* synthetic */ String f136630i;

        public c(Mp4EnhancedEnterPlayer r100, Mp4EnhancedEnterPlayer$playAnim$2 r101, String r102, long r103, com.bytedance.android.live.profit.player.d r104, Mp4EnhancedEnterPlayer$playAnim$4 r105, AnimPlayer.a r106, com.bytedance.android.livesdk.interactivity.enteranim.controller.v2.biz.animplayer.a r107, Mp4EnhancedEnterPlayer$playAnim$3 r110, String r111) {
            this.f136622a = r101;
            this.f136623b = r102;
            this.f136624c = r103;
            this.f136625d = r104;
            this.f136626e = r105;
            this.f136627f = r106;
            this.f136628g = r107;
            this.f136629h = r110;
            this.f136630i = r111;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            com.bytedance.android.live.profit.player.s r101 = (com.bytedance.android.live.profit.player.s) r100;
            List r102 = (List) r101.b();
            if (r102 != null) goto L9;
            Mp4EnhancedEnterPlayer$playAnim$2 r103 = this.f136622a;
            StringBuilder r104 = new StringBuilder("MaskSrc list create failed: ");
            Throwable r105 = r101.a();
            if (r105 == null) goto L7;
            String r106 = r105.getMessage();
        L8:
            r104.append(r106);
            r103.invoke2(r104.toString(), this.f136623b, String.valueOf(this.f136624c));
            return;
        L7:
            r106 = null;
            goto L8
        L9:
            this.f136625d.lh(this.f136624c, new com.bytedance.android.live.profit.player.n(r102, new Mp4EnhancedEnterPlayer$playAnim$8$1(this), new q(this), 1));
        }
    }

    static {
    }

    @Override // com.bytedance.android.livesdk.interactivity.enteranim.controller.v2.biz.animplayer.AnimPlayer
    public AnimPlayer.PlayerType getType() {
        return AnimPlayer.PlayerType.Mp4EnhancedEnter;
    }

    public Mp4EnhancedEnterPlayer(InteractivityPlatformContext r100, DataCenter r101) {
        Intrinsics.checkNotNullParameter(r100, "interactivityContext");
        Intrinsics.checkNotNullParameter(r101, "dataCenter");
        super(r100, r101);
        CompositeDisposable r102 = new CompositeDisposable();
        this.f136617c = r102;
        this.f136618d = LazyKt.lazy(Mp4EnhancedEnterPlayer$assetManager$2.INSTANCE);
        RxUtilKt.c(r100.getOnCleared().subscribe(new a(this)), r102);
        com.bytedance.android.live.profit.player.d r103 = yt0.c.h();
        if (r103 == null) goto L10;
        PublishSubject r104 = r103.x1();
        if (r104 == null) goto L11;
        Disposable r105 = r104.subscribe(new p(this));
        if (r105 == null) goto L12;
        RxUtilKt.c(r105, r102);
        return;
    L12:
        return;
    L11:
        return;
    }

    @Override // com.bytedance.android.livesdk.interactivity.enteranim.controller.v2.biz.animplayer.AnimPlayer
    public final void b(k32.a r210, Context r211, AnimPlayer.a r310, ViewGroup r311, com.bytedance.android.livesdk.interactivity.enteranim.controller.v2.biz.animplayer.a r312) {
        Intrinsics.checkNotNullParameter(r210, "msg");
        Intrinsics.checkNotNullParameter(r211, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r310, "animParams");
        Intrinsics.checkNotNullParameter(r311, "parentView");
        Intrinsics.checkNotNullParameter(r312, "playerListener");
        if (this.f136619e == false) goto L8;
        ALogger.w("Mp4EnhancedEnterPlayer", "skip enter effect caused by profile preview showing");
        View.OnClickListener r100 = r310.f136616c;
        if (r100 == null) goto L42;
        r100.onClick(r311);
        return;
    L42:
        return;
    L8:
        Ref.BooleanRef r101 = new Ref.BooleanRef();
        r101.element = false;
        Mp4EnhancedEnterPlayer$playAnim$1 r102 = new Mp4EnhancedEnterPlayer$playAnim$1(this, r101, r312);
        final Mp4EnhancedEnterPlayer$playAnim$2 r103 = new Mp4EnhancedEnterPlayer$playAnim$2(r102, r210);
        final Mp4EnhancedEnterPlayer$playAnim$3 r110 = new Mp4EnhancedEnterPlayer$playAnim$3(r102, r210);
        ALogger.w("Mp4EnhancedEnterPlayer", "start to play");
        va.a r104 = r210.f501694k;
        if (r104 != null) goto L12;
        Mp4EnhancedEnterPlayer$playAnim$2.invoke$default(r103, "Message.effectConfig is null", null, null, 6, null);
        return;
    L12:
        final String r105 = r104.getDressId();
        if (r105 != null) goto L16;
        Mp4EnhancedEnterPlayer$playAnim$2.invoke$default(r103, "Message.effectConfig.dressId is null", null, null, 6, null);
        return;
    L16:
        com.bytedance.android.live.profit.dress.l r106 = (com.bytedance.android.live.profit.dress.l) yt0.c.a().getDressData(r105, 2, "Mp4EnhancedEnterPlayer: playAnim");
        if (r106 != null) goto L20;
        Mp4EnhancedEnterPlayer$playAnim$2.invoke$default(r103, "dressModel is null", r105, null, 4, null);
        return;
    L20:
        final long r111 = r106.f87147j;
        com.bytedance.android.live.profit.player.d r112 = yt0.c.h();
        if (r112 != null) goto L24;
        r103.invoke2("playerService is null", r105, String.valueOf(r111));
        return;
    L24:
        final String r212 = ((IAssetsManager) this.f136618d.getValue()).H0(r111);
        if (r212 != null) goto L28;
        r103.invoke2("resource not ready", r105, String.valueOf(r111));
        return;
    L28:
        Mp4EnhancedEnterPlayer$playAnim$4 r113 = new Mp4EnhancedEnterPlayer$playAnim$4(r310, r311, r210);
        RevenueUtils.b r107 = RevenueUtils.f136592i;
        JSONObject r108 = UtilityKotlinExtentionsKt.o(new Pair[]{TuplesKt.to(ILiveRoomPlayFragmentConstant.EXTRA_HEAD_ENTER_TYPE, 9), TuplesKt.to("dress_id", r105), TuplesKt.to("resource_id", Long.valueOf(r111))});
        r107.getClass();
        RevenueUtils.b.d(r210, "user_enter_play", false, null, r108);
        if (j40.z.f497329a.getValue().booleanValue() == false) goto L32;
        r112.Nc(new com.bytedance.android.live.profit.player.a(r105, r104.l(), r210.f501686c, s1.G(r310.f136614a) + 11.0f, new Mp4EnhancedEnterPlayer$playAnim$5(r113), new Mp4EnhancedEnterPlayer$playAnim$6(r110, r105, r111, r212), new Mp4EnhancedEnterPlayer$playAnim$7(r103, r105, r111)));
        ((v72.c.a) r312).b();
        return;
    L32:
        a5 r109 = r106.f87150m;
        if (r109 != null) goto L36;
        r103.invoke2("template is null", r105, String.valueOf(r111));
        return;
    L36:
        com.bytedance.android.live.profit.player.e r114 = r112.Qh();
        Map<String, ? extends c5> r115 = r104.l();
        if (r115 == null) goto L39;
        Map r116 = MapsKt.toMap(r115);
    L40:
        RxUtilKt.c(com.bytedance.android.live.profit.player.e.a.a(r114, r211, r212, r109, r116, r106.f87153p, r210.f501686c, r106.f87152o, 0, null, MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_RENDER_FRAME_COUNT).subscribe(new c(this, r103, r105, r111, r112, r113, r310, r312, r110, r212)), this.f136617c);
        return;
    L39:
        r116 = null;
        goto L40
    }
}
