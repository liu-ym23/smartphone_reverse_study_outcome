package com.bytedance.android.livesdk.ktvimpl.ktvroom.widget;

import android.app.Activity;
import android.content.DialogInterface;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.bytedance.android.live.base.model.user.UserAttr;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.StateMachine;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.ktv.common.ordersong.feedback.KtvMusicFeedbackDialog;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livesdk.chatroom.LiveRoomPermission;
import com.bytedance.android.livesdk.chatroom.widget.MiddlewareRoomWidget;
import com.bytedance.android.livesdk.ktvapi.IKtvService;
import com.bytedance.android.livesdk.ktvapi.util.KtvCommonSettingHelper;
import com.bytedance.android.livesdk.ktvimpl.base.KtvContext;
import com.bytedance.android.livesdk.ktvimpl.base.karaokestation.ktvmode.KtvModeOrderSongDataContext;
import com.bytedance.android.livesdk.ktvimpl.base.tuningpanel.util.KSongTuningPanelHelperKt;
import com.bytedance.android.livesdk.ktvimpl.base.util.KtvUtilsKt;
import com.bytedance.android.livesdk.ktvimpl.ktvroom.challenge.ui.KtvRoomChallengeViewWrapper;
import com.bytedance.android.livesdk.ktvimpl.ktvroom.view.KtvMvSingerInfoView;
import com.bytedance.android.livesdk.ktvimpl.ktvroom.view.dialog.KtvRoomFeedbackGuideDialog;
import com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel.KtvRoomLyricsStateMachineConfig;
import com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel.KtvRoomViewModel;
import com.bytedance.android.livesdk.message.model.InteractiveSongUserInfo;
import com.bytedance.android.livesdk.message.model.KtvMusic;
import com.bytedance.android.livesdk.message.model.MusicPanel;
import com.bytedance.android.livesdk.message.model.OrderInfo;
import com.bytedance.ies.sdk.widgets.NextLiveData;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.List;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.LongRange;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/ktvimpl/ktvroom/widget/KtvMvControlAreaWidget;", "Lcom/bytedance/android/livesdk/chatroom/widget/MiddlewareRoomWidget;", "Landroid/view/View$OnClickListener;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "livektv-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class KtvMvControlAreaWidget extends MiddlewareRoomWidget implements View.OnClickListener {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final /* synthetic */ int f145608s = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public View f145609a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public TextView f145610b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public KtvMvSingerInfoView f145611c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public TextView f145612d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public TextView f145613e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public View f145614f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public View f145615g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public ImageView f145616h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public ImageView f145617i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public ImageView f145618j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public ImageView f145619k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public View f145620l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public ImageView f145621m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final CompositeDisposable f145622n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final sb0.b f145623o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final KtvRoomViewModel f145624p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final KtvContext f145625q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final com.bytedance.android.livesdk.ktvimpl.ktvroom.challenge.ui.a f145626r;

    public static final class a {
    }

    public static final class b implements DialogInterface.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f145627a = null;

        static {
            f145627a = new b();
        }

        public b() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public final void onClick(DialogInterface r100, int r101) {
            r100.dismiss();
        }
    }

    public static final class c implements DialogInterface.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ KtvMvControlAreaWidget f145628a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ boolean f145629b;

        public c(KtvMvControlAreaWidget r100, boolean r101) {
            this.f145628a = r100;
            this.f145629b = r101;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public final void onClick(DialogInterface r100, int r101) {
            r100.dismiss();
            if (this.f145629b == false) goto L45;
            KtvContext r102 = this.f145628a.f145625q;
            if (r102 == null) goto L11;
            com.bytedance.live.datacontext.n<com.bytedance.android.livesdk.ktvimpl.base.viewmodel.d> r103 = r102.getKtvSingerViewModel();
            if (r103 == null) goto L11;
            com.bytedance.android.livesdk.ktvimpl.base.viewmodel.d r104 = r103.getValue();
            if (r104 == null) goto L11;
            r104.cutMusic();
        L11:
            KtvMvControlAreaWidget r105 = this.f145628a;
            KtvContext r106 = r105.f145625q;
            if (r106 == null) goto L18;
            com.bytedance.live.datacontext.n<com.bytedance.android.livesdk.ktvimpl.base.i> r107 = r106.getKtvCoreController();
            if (r107 == null) goto L18;
            com.bytedance.android.livesdk.ktvimpl.base.i r108 = r107.getValue();
            if (r108 == null) goto L18;
            Long r109 = Long.valueOf(r108.b());
        L19:
            LongRange r110 = new LongRange(0, 30000);
            if (r109 != null) goto L22;
        L24:
            boolean r111 = false;
        L25:
            if (r111 == false) goto L56;
            com.bytedance.android.livesdk.ktvimpl.base.viewmodel.c r112 = r105.f145625q.getKtvCoreViewModel().getValue();
            if (r112 == null) goto L31;
            KtvRoomLyricsStateMachineConfig.d r113 = r112.getCurState();
            if (r113 == null) goto L31;
            MusicPanel r114 = r113.b();
        L32:
            if (r114 == null) goto L57;
            int r115 = KtvRoomFeedbackGuideDialog.f145031k;
            String r116 = r114.f153577a.getMTitle();
            String r117 = "";
            if (r116 != null) goto L36;
            r116 = "";
        L36:
            String r118 = r114.f153577a.getMAuthor();
            if (r118 == null) goto L40;
            r117 = r118;
        L40:
            KtvRoomFeedbackGuideDialog r119 = KtvRoomFeedbackGuideDialog.a.a(new com.bytedance.android.live.ktv.common.ordersong.feedback.a(r116, r117), KtvMusicFeedbackDialog.FeedbackType.KSONG_SONG_INFO);
            Activity r120 = com.bytedance.android.livesdk.utils.d.f158925a.get();
            if (r120 != null) goto L44;
            r120 = r105.context;
        L44:
            r119.W90(r120, null, true);
            return;
        L57:
            return;
        L31:
            r114 = null;
            goto L32
        L56:
            return;
        L22:
            if (r110.contains(r109.longValue()) == false) goto L24;
            r111 = true;
        L18:
            r109 = null;
            goto L19
        L45:
            com.bytedance.android.livesdk.ktvimpl.base.viewmodel.c r121 = this.f145628a.f145625q.getKtvCoreViewModel().getValue();
            if (r121 == null) goto L50;
            KtvRoomLyricsStateMachineConfig.d r122 = r121.getCurState();
            if (r122 == null) goto L50;
            MusicPanel r123 = r122.b();
        L51:
            if (r123 == null) goto L59;
            KtvModeOrderSongDataContext.Companion.getClass();
            com.bytedance.android.livesdk.ktvimpl.base.karaokestation.d r124 = KtvModeOrderSongDataContext.Companion.a();
            if (r124 == null) goto L60;
            com.bytedance.android.livesdk.ktvimpl.base.karaokestation.d.a.b(r124, r123, null, 6);
            return;
        L60:
            return;
        L59:
            return;
        L50:
            r123 = null;
            goto L51
        }
    }

    public static final class d<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ KtvMvControlAreaWidget f145630a;

        public d(KtvMvControlAreaWidget r100) {
            this.f145630a = r100;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r100) {
            KtvMvControlAreaWidget r101 = this.f145630a;
            int r102 = KtvMvControlAreaWidget.f145608s;
            r101.yq((StateMachine.c.b) r100);
        }
    }

    public static final class e<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ KtvMvControlAreaWidget f145631a;

        public e(KtvMvControlAreaWidget r100) {
            this.f145631a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            UserAttr r101 = (UserAttr) r100;
            KtvMvControlAreaWidget r102 = this.f145631a;
            KtvRoomViewModel r103 = r102.f145624p;
            if (r103 == null) goto L7;
            NextLiveData<StateMachine.c.b<KtvRoomLyricsStateMachineConfig.d, KtvRoomLyricsStateMachineConfig.a, KtvRoomLyricsStateMachineConfig.b>> r104 = r103.getStateChangeEvent();
            if (r104 == null) goto L7;
            StateMachine.c.b<KtvRoomLyricsStateMachineConfig.d, KtvRoomLyricsStateMachineConfig.a, KtvRoomLyricsStateMachineConfig.b> r105 = r104.getValue();
        L8:
            r102.yq(r105);
            com.bytedance.android.livesdk.ktvimpl.ktvroom.challenge.ui.a r106 = r102.f145626r;
            if (r106 == null) goto L12;
            r106.h(r101);
            return;
        L12:
            return;
        L7:
            r105 = null;
            goto L8
        }
    }

    public static final class f<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ KtvMvControlAreaWidget f145632a;

        public f(KtvMvControlAreaWidget r100) {
            this.f145632a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            sh6.b r101 = (sh6.b) r100;
            KtvMvControlAreaWidget r102 = this.f145632a;
            int r103 = KtvMvControlAreaWidget.f145608s;
            r102.xq();
        }
    }

    static {
    }

    @Override // com.bytedance.ies.sdk.widgets.Widget
    public final int getLayoutId() {
        return R.layout.ttlive_ktv_mv_control_area_layout;
    }

    public final boolean isAnchor() {
        sb0.b r100 = this.f145623o;
        if (r100 != null) goto L5;
    L7:
        return false;
    L5:
        if (r100.isAnchor() != true) goto L7;
        return true;
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveWidget, com.bytedance.livesdk.preview.merge.AbsMergeWidget, com.bytedance.ies.sdk.widgets.Widget
    public final void onDestroy() {
        if (this.f145622n.isDisposed() == true) goto L5;
        this.f145622n.dispose();
    L5:
        com.bytedance.android.livesdk.ktvimpl.ktvroom.challenge.ui.a r100 = this.f145626r;
        if (r100 == null) goto L8;
        r100.onDestroy();
    L8:
        super.onDestroy();
    }

    public final boolean zq() {
        KtvModeOrderSongDataContext.Companion.getClass();
        com.bytedance.android.livesdk.ktvimpl.base.skin.viewmodel.a r100 = KtvModeOrderSongDataContext.Companion.e();
        if (r100 != null) goto L5;
    L7:
        return false;
    L5:
        if (r100.hasNewKtvDress() != true) goto L7;
        return true;
    }

    @Override // com.bytedance.android.livesdk.chatroom.widget.MiddlewareRoomWidget, com.bytedance.android.live.core.tetris.widgets.LiveWidget, com.bytedance.ies.sdk.widgets.Widget
    public final void onCreate() {
        super.onCreate();
        this.f145609a = this.containerView.findViewById(R.id.ktv_mv_separator);
        TextView r100 = (TextView) this.containerView.findViewById(R.id.ktv_mv_order_song_btn);
        this.f145610b = r100;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mOrderSongBtn");
    L5:
        r100.setOnClickListener(com.bytedance.android.livesdk.utils.x0.a(new AnonymousClass1(this)));
        KtvMvSingerInfoView r101 = (KtvMvSingerInfoView) this.containerView.findViewById(R.id.ktv_mv_singer_info_view);
        this.f145611c = r101;
        if (r101 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("mSingerInfoView");
    L8:
        r101.setKtvContext(this.f145625q);
        KtvMvSingerInfoView r102 = this.f145611c;
        if (r102 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("mSingerInfoView");
    L11:
        r102.S5(this, this.f145624p, this.f145622n);
        this.f145612d = (TextView) this.containerView.findViewById(R.id.ktv_mv_welcome_tv);
        this.f145613e = (TextView) this.containerView.findViewById(R.id.ktv_mv_song_num);
        this.f145614f = this.containerView.findViewById(R.id.ktv_dress_yellow_dot);
        Lazy r103 = KtvCommonSettingHelper.f142336a;
        this.f145620l = this.containerView.findViewById(R.id.ktv_anchor_control_container);
        ImageView r104 = (ImageView) this.containerView.findViewById(R.id.ktv_mv_anchor_stop_btn);
        this.f145621m = r104;
        if (r104 == null) goto L14;
        r104.setOnClickListener(this);
    L14:
        ImageView r105 = (ImageView) this.containerView.findViewById(R.id.ktv_mv_anchor_next_btn);
        if (r105 == null) goto L17;
        r105.setOnClickListener(this);
    L17:
        this.f145615g = this.containerView.findViewById(R.id.ktv_singer_control_container);
        ImageView r106 = (ImageView) this.containerView.findViewById(R.id.ktv_mv_singer_origin_btn);
        this.f145616h = r106;
        if (r106 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("mSingerOriginBtn");
    L20:
        r106.setOnClickListener(this);
        ImageView r107 = (ImageView) this.containerView.findViewById(R.id.ktv_mv_singer_stop_btn);
        this.f145617i = r107;
        if (r107 != null) goto L23;
        Intrinsics.throwUninitializedPropertyAccessException("mSingerStopBtn");
    L23:
        r107.setOnClickListener(this);
        ImageView r108 = (ImageView) this.containerView.findViewById(R.id.ktv_mv_singer_next_btn);
        this.f145618j = r108;
        if (r108 != null) goto L26;
        Intrinsics.throwUninitializedPropertyAccessException("mSingerNextBtn");
    L26:
        r108.setOnClickListener(this);
        ImageView r109 = (ImageView) this.containerView.findViewById(R.id.ktv_mv_singer_tone_btn);
        this.f145619k = r109;
        if (r109 != null) goto L29;
        Intrinsics.throwUninitializedPropertyAccessException("mSingerToneBtn");
    L29:
        r109.setOnClickListener(this);
        RxUtilKt.c(this.f145625q.getHasBgm().a().subscribe(new z(this)), this.f145622n);
        if (isAnchor() == false) goto L32;
    L33:
        ImageView r110 = this.f145616h;
        if (r110 != null) goto L36;
        Intrinsics.throwUninitializedPropertyAccessException("mSingerOriginBtn");
    L36:
        r110.setVisibility(8);
    L37:
        KtvRoomViewModel r111 = this.f145624p;
        if (r111 == null) goto L42;
        NextLiveData<StateMachine.c.b<KtvRoomLyricsStateMachineConfig.d, KtvRoomLyricsStateMachineConfig.a, KtvRoomLyricsStateMachineConfig.b>> r112 = r111.getStateChangeEvent();
        if (r112 == null) goto L42;
        r112.observe(this, new d(this));
    L42:
        KtvRoomViewModel r113 = this.f145624p;
        if (r113 == null) goto L47;
        NextLiveData<StateMachine.c.b<KtvRoomLyricsStateMachineConfig.d, KtvRoomLyricsStateMachineConfig.a, KtvRoomLyricsStateMachineConfig.b>> r114 = r113.getStateChangeEvent();
        if (r114 == null) goto L47;
        StateMachine.c.b<KtvRoomLyricsStateMachineConfig.d, KtvRoomLyricsStateMachineConfig.a, KtvRoomLyricsStateMachineConfig.b> r115 = r114.getValue();
    L48:
        yq(r115);
        if (isAnchor() == true) goto L59;
        IMiddlewareUserService r116 = (IMiddlewareUserService) jc1.k.f(IMiddlewareUserService.class);
        if (r116 == null) goto L59;
        com.bytedance.android.livesdk.user.e r117 = r116.user();
        if (r117 == null) goto L59;
        Observable<? extends UserAttr> r118 = r117.u();
        if (r118 == null) goto L59;
        Disposable r119 = r118.subscribe(new e(this));
        if (r119 == null) goto L59;
        RxUtilKt.c(r119, this.f145622n);
    L59:
        Observable<sh6.b<Long>> r120 = this.f145625q.getKtvAddDressVersion().a();
        if (r120 == null) goto L64;
        Disposable r121 = r120.subscribe(new f(this));
        if (r121 == null) goto L64;
        RxUtilKt.c(r121, this.f145622n);
    L64:
        xq();
        if (vm2.h.p() == true) goto L67;
        return;
    L67:
        if ((this.f145625q.getBizLcMager().f70685a instanceof tb0.c.b) == true) goto L71;
        Aq(false);
        return;
    L71:
        return;
    L47:
        r115 = null;
        goto L48
    L32:
        if (KtvUtilsKt.d() == false) goto L37;
        goto L33
    }

    public final void xq() {
        if (zq() == false) goto L9;
        View r100 = this.f145614f;
        if (r100 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("mKtvDressYellowDot");
    L7:
        if (r100 == null) goto L14;
        r100.setVisibility(0);
    L14:
        Eq(com.bytedance.android.livesdk.ktvimpl.base.orderedsong.d.e(this.f145625q));
        return;
    L9:
        View r101 = this.f145614f;
        if (r101 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("mKtvDressYellowDot");
    L12:
        if (r101 == null) goto L14;
        r101.setVisibility(8);
        goto L14
    }

    public final void Aq(boolean r100) {
        TextView r101 = this.f145610b;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mOrderSongBtn");
    L5:
        if (r101 == null) goto L11;
        if (r100 == false) goto L8;
        int r102 = 0;
    L9:
        r101.setVisibility(r102);
        goto L11
    L8:
        r102 = 8;
    L11:
        if (r100 == false) goto L23;
        View r103 = this.f145614f;
        if (r103 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("mKtvDressYellowDot");
    L16:
        if (r103 == null) goto L18;
        r103.setAlpha(1.0f);
    L18:
        TextView r104 = this.f145613e;
        if (r104 != null) goto L21;
        Intrinsics.throwUninitializedPropertyAccessException("mSongCountTextView");
    L21:
        if (r104 == null) goto L35;
        r104.setAlpha(1.0f);
        return;
    L35:
        return;
    L23:
        View r105 = this.f145614f;
        if (r105 != null) goto L27;
        Intrinsics.throwUninitializedPropertyAccessException("mKtvDressYellowDot");
    L27:
        if (r105 == null) goto L29;
        r105.setAlpha(0.0f);
    L29:
        TextView r106 = this.f145613e;
        if (r106 != null) goto L32;
        Intrinsics.throwUninitializedPropertyAccessException("mSongCountTextView");
    L32:
        if (r106 == null) goto L37;
        r106.setAlpha(0.0f);
        return;
    }

    public final void Bq(boolean r100) {
        KtvContext.Companion.getClass();
        boolean r101 = KtvContext.a.g().isCurrentUserIsSinger();
        if (r100 == false) goto L8;
        KtvMvSingerInfoView r102 = this.f145611c;
        if (r102 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("mSingerInfoView");
    L7:
        r102.setSingingInfoVisibility(false);
    L13:
        if (r101 == false) goto L54;
        if (r100 == false) goto L30;
        ImageView r103 = this.f145617i;
        if (r103 != null) goto L19;
        Intrinsics.throwUninitializedPropertyAccessException("mSingerStopBtn");
    L19:
        if (r103 == null) goto L21;
        r103.setVisibility(8);
    L21:
        ImageView r104 = this.f145618j;
        if (r104 != null) goto L24;
        Intrinsics.throwUninitializedPropertyAccessException("mSingerNextBtn");
    L24:
        if (r104 == null) goto L26;
        r104.setVisibility(8);
    L26:
        ImageView r105 = this.f145616h;
        if (r105 != null) goto L29;
        Intrinsics.throwUninitializedPropertyAccessException("mSingerOriginBtn");
    L29:
        r105.setVisibility(8);
        return;
    L30:
        ImageView r106 = this.f145617i;
        if (r106 != null) goto L33;
        Intrinsics.throwUninitializedPropertyAccessException("mSingerStopBtn");
    L33:
        if (r106 == null) goto L35;
        r106.setVisibility(0);
    L35:
        ImageView r107 = this.f145618j;
        if (r107 != null) goto L38;
        Intrinsics.throwUninitializedPropertyAccessException("mSingerNextBtn");
    L38:
        if (r107 == null) goto L41;
        r107.setVisibility(0);
    L41:
        if (isAnchor() == false) goto L43;
    L49:
        ImageView r108 = this.f145616h;
        if (r108 != null) goto L52;
        Intrinsics.throwUninitializedPropertyAccessException("mSingerOriginBtn");
    L52:
        r108.setVisibility(8);
        return;
    L43:
        if (KtvUtilsKt.d() == true) goto L49;
        ImageView r109 = this.f145616h;
        if (r109 != null) goto L48;
        Intrinsics.throwUninitializedPropertyAccessException("mSingerOriginBtn");
    L48:
        r109.setVisibility(0);
        return;
    L54:
        if (isAnchor() == false) goto L56;
    L57:
        if (r100 == false) goto L61;
        ImageView r110 = this.f145621m;
        if (r110 == null) goto L64;
        r110.setVisibility(8);
    L64:
        ImageView r111 = this.f145616h;
        if (r111 != null) goto L67;
        Intrinsics.throwUninitializedPropertyAccessException("mSingerOriginBtn");
    L67:
        r111.setVisibility(8);
        return;
    L61:
        ImageView r112 = this.f145621m;
        if (r112 == null) goto L64;
        r112.setVisibility(0);
        goto L64
    L56:
        if (KtvUtilsKt.d() == true) goto L57;
        return;
    L8:
        KtvMvSingerInfoView r113 = this.f145611c;
        if (r113 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("mSingerInfoView");
    L11:
        r113.setSingingInfoVisibility(true);
        goto L13
    }

    public final void Cq(boolean r100) {
        if (r100 == false) goto L4;
        int r101 = R.drawable.ttlive_ktv_mv_origin_opened;
    L5:
        ImageView r102 = this.f145616h;
        if (r102 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("mSingerOriginBtn");
    L8:
        r102.setImageResource(r101);
        KtvRoomViewModel r103 = this.f145624p;
        if (r103 == null) goto L13;
        KtvRoomLyricsStateMachineConfig.d r104 = r103.getCurState();
        if (r104 == null) goto L13;
        MusicPanel r105 = r104.b();
    L14:
        if (r100 == true) goto L22;
        if (r105 == null) goto L22;
        if (com.bytedance.android.live.ktv.common.util.KtvUtilsKt.D(r105) == true) goto L22;
        ImageView r106 = this.f145616h;
        if (r106 != null) goto L21;
        Intrinsics.throwUninitializedPropertyAccessException("mSingerOriginBtn");
    L21:
        r106.setAlpha(0.5f);
        return;
    L22:
        ImageView r107 = this.f145616h;
        if (r107 != null) goto L25;
        Intrinsics.throwUninitializedPropertyAccessException("mSingerOriginBtn");
    L25:
        r107.setAlpha(1.0f);
        return;
    L13:
        r105 = null;
        goto L14
    L4:
        r101 = R.drawable.ttlive_ktv_mv_origin_closed;
        goto L5
    }

    public final void Eq(int r100) {
        if (zq() == false) goto L9;
        TextView r101 = this.f145613e;
        if (r101 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("mSongCountTextView");
    L7:
        r101.setVisibility(8);
        return;
    L9:
        if (r100 <= 0) goto L20;
        String r102 = String.valueOf(r100);
        if (r100 <= 99) goto L13;
        r102 = "99+";
    L13:
        TextView r103 = this.f145613e;
        if (r103 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("mSongCountTextView");
    L16:
        r103.setVisibility(0);
        TextView r104 = this.f145613e;
        if (r104 != null) goto L19;
        Intrinsics.throwUninitializedPropertyAccessException("mSongCountTextView");
    L19:
        r104.setText(r102);
        return;
    L20:
        TextView r105 = this.f145613e;
        if (r105 != null) goto L23;
        Intrinsics.throwUninitializedPropertyAccessException("mSongCountTextView");
    L23:
        r105.setText("0");
        TextView r106 = this.f145613e;
        if (r106 != null) goto L26;
        Intrinsics.throwUninitializedPropertyAccessException("mSongCountTextView");
    L26:
        r106.setVisibility(8);
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        KtvRoomLyricsStateMachineConfig.d r101 = null;
        MusicPanel r102 = null;
        r102 = null;
        KtvRoomLyricsStateMachineConfig.d r103 = null;
        r103 = null;
        r103 = null;
        r101 = null;
        r101 = null;
        if (r100 == null) goto L5;
        Integer r104 = Integer.valueOf(r100.getId());
    L6:
        boolean r105 = false;
        if (r104 != null) goto L10;
    L50:
        if (r104 != null) goto L53;
    L68:
        if (r104 != null) goto L71;
    L73:
        if (r104 != null) goto L76;
    L78:
        if (r104 != null) goto L81;
    L96:
        if (r104 != null) goto L99;
        return;
    L99:
        if (r104.intValue() != R.id.ktv_mv_anchor_next_btn) goto L115;
        wq(false);
        return;
    L115:
        return;
    L81:
        if (r104.intValue() != R.id.ktv_mv_anchor_stop_btn) goto L96;
        KtvContext r106 = this.f145625q;
        if (r106 == null) goto L89;
        com.bytedance.live.datacontext.n<com.bytedance.android.livesdk.ktvimpl.base.viewmodel.c> r107 = r106.getKtvCoreViewModel();
        if (r107 == null) goto L89;
        com.bytedance.android.livesdk.ktvimpl.base.viewmodel.c r108 = r107.getValue();
        if (r108 == null) goto L89;
        r101 = r108.getCurState();
    L89:
        boolean r109 = r101 instanceof KtvRoomLyricsStateMachineConfig.d.C2274d;
        KtvContext r110 = this.f145625q;
        if (r110 == null) goto L111;
        com.bytedance.live.datacontext.n<com.bytedance.android.livesdk.ktvimpl.base.viewmodel.d> r111 = r110.getKtvSingerViewModel();
        if (r111 == null) goto L112;
        com.bytedance.android.livesdk.ktvimpl.base.viewmodel.d r112 = r111.getValue();
        if (r112 == null) goto L113;
        r112.togglePause(!r109);
        return;
    L113:
        return;
    L112:
        return;
    L111:
        return;
    L76:
        if (r104.intValue() != R.id.ktv_mv_singer_tone_btn) goto L78;
        this.f145625q.getOpenKtvRoomDialogEvent().post(new od2.b("control", true, null));
        pd2.d.f528658n.getClass();
        pd2.d.u("half_mv");
        return;
    L71:
        if (r104.intValue() != R.id.ktv_mv_singer_next_btn) goto L73;
        wq(true);
        return;
    L53:
        if (r104.intValue() != R.id.ktv_mv_singer_stop_btn) goto L68;
        KtvContext r113 = this.f145625q;
        if (r113 == null) goto L61;
        com.bytedance.live.datacontext.n<com.bytedance.android.livesdk.ktvimpl.base.viewmodel.c> r114 = r113.getKtvCoreViewModel();
        if (r114 == null) goto L61;
        com.bytedance.android.livesdk.ktvimpl.base.viewmodel.c r115 = r114.getValue();
        if (r115 == null) goto L61;
        r103 = r115.getCurState();
    L61:
        boolean r116 = r103 instanceof KtvRoomLyricsStateMachineConfig.d.C2274d;
        KtvContext r117 = this.f145625q;
        if (r117 == null) goto L105;
        com.bytedance.live.datacontext.n<com.bytedance.android.livesdk.ktvimpl.base.viewmodel.d> r118 = r117.getKtvSingerViewModel();
        if (r118 == null) goto L106;
        com.bytedance.android.livesdk.ktvimpl.base.viewmodel.d r119 = r118.getValue();
        if (r119 == null) goto L107;
        r119.togglePause(!r116);
        return;
    L107:
        return;
    L106:
        return;
    L105:
        return;
    L10:
        if (r104.intValue() != R.id.ktv_mv_singer_origin_btn) goto L50;
        KtvRoomViewModel r120 = this.f145624p;
        if (r120 == null) goto L16;
        KtvRoomLyricsStateMachineConfig.d r121 = r120.getCurState();
        if (r121 == null) goto L16;
        r102 = r121.b();
    L16:
        com.bytedance.android.live.ktv.common.tuningpanel.ability.a r122 = KSongTuningPanelHelperKt.d();
        if (r122 != null) goto L19;
    L21:
        boolean r123 = false;
    L23:
        if (KtvUtilsKt.h(r102) == false) goto L25;
        f2.c(com.bytedance.android.live.core.utils.s1.B(R.string.ktv_resource_loading_tips), 0);
        return;
    L25:
        if (r102 != null) goto L27;
    L32:
        KtvContext r124 = this.f145625q;
        if (r124 == null) goto L39;
        com.bytedance.live.datacontext.n<com.bytedance.android.livesdk.ktvimpl.base.viewmodel.d> r125 = r124.getKtvSingerViewModel();
        if (r125 == null) goto L39;
        com.bytedance.android.livesdk.ktvimpl.base.viewmodel.d r126 = r125.getValue();
        if (r126 == null) goto L39;
        r126.toggleOrigin(!r123);
    L39:
        oe2.b r127 = this.f145625q.getKtvRoomProvider().getValue();
        if (r127 == null) goto L46;
        com.bytedance.android.live.ktv.common.tuningpanel.ability.a r128 = KSongTuningPanelHelperKt.d();
        if (r128 == null) goto L44;
        boolean r129 = r128.R();
    L45:
        r127.f(r129);
        goto L46
    L44:
        r129 = false;
    L46:
        com.bytedance.android.live.ktv.common.tuningpanel.ability.a r130 = KSongTuningPanelHelperKt.d();
        if (r130 == null) goto L49;
        r105 = r130.R();
    L49:
        Cq(r105);
        return;
    L27:
        if (com.bytedance.android.live.ktv.common.util.KtvUtilsKt.D(r102) == true) goto L32;
        if (r123 == false) goto L30;
        int r131 = R.string.ttlive_ktv_no_accompany;
    L31:
        f2.b(r131, 0);
        return;
    L30:
        r131 = R.string.ttlive_ktv_no_origin;
        goto L31
    L19:
        if (r122.R() != true) goto L21;
        r123 = true;
        goto L23
    L5:
        r104 = null;
        goto L6
    }

    public final void wq(boolean r100) {
        Activity r101 = com.bytedance.android.livesdk.utils.d.f158925a.get();
        if (r101 != null) goto L6;
        r101 = this.context;
    L6:
        com.bytedance.android.livesdk.widget.x0.b r102 = new com.bytedance.android.livesdk.widget.x0.b(r101, 0);
        r102.f162238a.f162242a = 7;
        r102.m(R.string.ttlive_ktv_mv_cut_music_dialog_title);
        r102.i(1, R.string.ttlive_ktv_play_all_dialog_cancle, b.f145627a);
        r102.i(0, R.string.ttlive_ktv_play_all_dialog_confirm, new c(this, r100));
        com.bytedance.android.livesdk.widget.x0.d r103 = r102.f162238a;
        r103.f162252k = false;
        r103.f162253l = false;
        r102.n();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void yq(StateMachine.c.b<? extends KtvRoomLyricsStateMachineConfig.d, ? extends KtvRoomLyricsStateMachineConfig.a, ? extends KtvRoomLyricsStateMachineConfig.b> r110) {
        if (r110 != null) goto L4;
        return;
    L4:
        KtvRoomLyricsStateMachineConfig.d r100 = (KtvRoomLyricsStateMachineConfig.d) r110.f66101c;
        boolean r101 = false;
        if ((r100 instanceof KtvRoomLyricsStateMachineConfig.d.a) == false) goto L7;
    L162:
        View r102 = this.f145615g;
        if (r102 != null) goto L165;
        Intrinsics.throwUninitializedPropertyAccessException("mSingerControlContainer");
    L165:
        r102.setVisibility(8);
        View r103 = this.f145620l;
        if (r103 == null) goto L168;
        r103.setVisibility(8);
    L168:
        KtvMvSingerInfoView r104 = this.f145611c;
        if (r104 != null) goto L171;
        Intrinsics.throwUninitializedPropertyAccessException("mSingerInfoView");
    L171:
        r104.setVisibility(8);
        if ((r100 instanceof KtvRoomLyricsStateMachineConfig.d.b) == false) goto L177;
        TextView r105 = this.f145612d;
        if (r105 != null) goto L176;
        Intrinsics.throwUninitializedPropertyAccessException("mWelcomeTextView");
    L176:
        r105.setVisibility(0);
    L177:
        com.bytedance.android.livesdk.ktvimpl.ktvroom.challenge.ui.a r106 = this.f145626r;
        if (r106 == null) goto L181;
        r106.c(r110);
        return;
    L181:
        return;
    L7:
        if ((r100 instanceof KtvRoomLyricsStateMachineConfig.d.b) == true) goto L162;
        TextView r107 = this.f145612d;
        if (r107 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("mWelcomeTextView");
    L12:
        r107.setVisibility(8);
        KtvMvSingerInfoView r108 = this.f145611c;
        if (r108 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("mSingerInfoView");
    L15:
        r108.setVisibility(0);
        KtvMvSingerInfoView r109 = this.f145611c;
        if (r109 != null) goto L18;
        Intrinsics.throwUninitializedPropertyAccessException("mSingerInfoView");
    L18:
        r109.getClass();
        KtvRoomLyricsStateMachineConfig.d r111 = (KtvRoomLyricsStateMachineConfig.d) r110.f66101c;
        KtvRoomLyricsStateMachineConfig.d r112 = (KtvRoomLyricsStateMachineConfig.d) r110.f66099a;
        KtvMusic r113 = null;
        if ((r111 instanceof KtvRoomLyricsStateMachineConfig.d.e) == false) goto L50;
        r109.V5(0);
        KtvMusic.a r114 = KtvMusic.Companion;
        MusicPanel r115 = ((KtvRoomLyricsStateMachineConfig.d) r110.f66101c).b();
        if (r115 == null) goto L23;
        KtvMusic r116 = r115.f153577a;
    L24:
        r114.getClass();
        r109.U5(KtvMusic.a.a(r116) * ((long) 1000));
        MusicPanel r117 = ((KtvRoomLyricsStateMachineConfig.d) r110.f66101c).b();
        if (r117 == null) goto L29;
        KtvMusic r118 = r117.f153577a;
        if (r118 == null) goto L29;
        String r119 = r118.getMTitle();
    L30:
        r109.Z5(r119);
        if ((r112 instanceof KtvRoomLyricsStateMachineConfig.d.e) == false) goto L46;
        OrderInfo r120 = ((KtvRoomLyricsStateMachineConfig.d.e) r112).f145409b.f153577a.getOrderInfo();
        if (r120 == null) goto L37;
        InteractiveSongUserInfo r121 = r120.getTopUser();
        if (r121 == null) goto L37;
        String r122 = r121.getIdString();
    L38:
        OrderInfo r123 = ((KtvRoomLyricsStateMachineConfig.d.e) r111).f145409b.f153577a.getOrderInfo();
        if (r123 == null) goto L43;
        InteractiveSongUserInfo r124 = r123.getTopUser();
        if (r124 == null) goto L43;
        String r125 = r124.getIdString();
    L45:
        if ((!Intrinsics.areEqual(r122, r125)) == true) goto L46;
    L75:
        boolean r126 = this.f145625q.isCurrentUserIsSinger();
        int r127 = R.drawable.ttlive_ktv_mv_stop_sing_btn;
        if (r126 == false) goto L110;
        View r128 = this.f145615g;
        if (r128 != null) goto L80;
        Intrinsics.throwUninitializedPropertyAccessException("mSingerControlContainer");
    L80:
        r128.setVisibility(0);
        View r129 = this.f145620l;
        if (r129 == null) goto L83;
        r129.setVisibility(8);
    L83:
        oe2.l.a r130 = oe2.l.f522975f;
        MusicPanel r131 = r100.b();
        r130.getClass();
        int r132 = oe2.l.a.a();
        if (r131 == null) goto L86;
        MusicPanel.Track r133 = r131.h();
    L87:
        if (r133 == null) goto L97;
        int r134 = oe2.k.f522974a[r133.ordinal()];
        if (r134 != 1) goto L92;
        if (r132 == 0) goto L97;
        if (r132 != 1) goto L97;
    L96:
        boolean r135 = true;
    L98:
        Cq(r135);
        if ((r100 instanceof KtvRoomLyricsStateMachineConfig.d.C2274d) == false) goto L101;
        r127 = R.drawable.ttlive_ktv_mv_play_sing_btn;
    L101:
        ImageView r136 = this.f145617i;
        if (r136 != null) goto L104;
        Intrinsics.throwUninitializedPropertyAccessException("mSingerStopBtn");
    L104:
        r136.setImageResource(r127);
        ImageView r137 = this.f145617i;
        if (r137 != null) goto L107;
        Intrinsics.throwUninitializedPropertyAccessException("mSingerStopBtn");
    L107:
        if (r137 == null) goto L151;
        r137.setAlpha(1.0f);
    L151:
        com.bytedance.android.livesdk.ktvimpl.ktvroom.challenge.ui.a r138 = this.f145626r;
        if (r138 != null) goto L154;
    L161:
        Bq(r101);
        goto L177
    L154:
        if (r138.d() != true) goto L161;
        MusicPanel r139 = r100.b();
        if (r139 == null) goto L159;
        r113 = r139.f153577a;
    L159:
        if (ne2.a.f(r113) == false) goto L161;
        r101 = true;
        goto L161
    L92:
        if (r134 == 2) goto L96;
    L97:
        r135 = false;
        goto L98
    L86:
        r133 = null;
        goto L87
    L110:
        if (isAnchor() == false) goto L112;
    L136:
        View r140 = this.f145615g;
        if (r140 != null) goto L139;
        Intrinsics.throwUninitializedPropertyAccessException("mSingerControlContainer");
    L139:
        r140.setVisibility(8);
        View r141 = this.f145620l;
        if (r141 == null) goto L143;
        r141.setVisibility(0);
    L143:
        if ((r100 instanceof KtvRoomLyricsStateMachineConfig.d.C2274d) == false) goto L145;
        r127 = R.drawable.ttlive_ktv_mv_play_sing_btn;
    L145:
        ImageView r142 = this.f145621m;
        if (r142 == null) goto L148;
        r142.setImageResource(r127);
    L148:
        ImageView r143 = this.f145621m;
        if (r143 == null) goto L151;
        r143.setAlpha(1.0f);
        goto L151
    L112:
        if (((IMiddlewareUserService) jc1.k.n(IMiddlewareUserService.class)).user().c() == true) goto L136;
        if (((IMiddlewareUserService) jc1.k.n(IMiddlewareUserService.class)).user().isAdmin() == true) goto L116;
    L126:
        boolean r144 = false;
    L127:
        ALogger.i("KtvMvControlAreaWidget", "supportAdminOperate, hasPermission: " + r144);
        if (r144 == true) goto L136;
        View r145 = this.f145615g;
        if (r145 != null) goto L133;
        Intrinsics.throwUninitializedPropertyAccessException("mSingerControlContainer");
    L133:
        r145.setVisibility(8);
        View r146 = this.f145620l;
        if (r146 == null) goto L151;
        r146.setVisibility(8);
        goto L151
    L116:
        if (com.bytedance.android.livesdk.sharedpref.c.f158313v1.getValue().booleanValue() == false) goto L126;
        com.bytedance.android.livesdk.user.e r147 = ((IMiddlewareUserService) jc1.k.n(IMiddlewareUserService.class)).user();
        if (r147 == null) goto L126;
        UserAttr r148 = r147.q();
        if (r148 == null) goto L126;
        List<Integer> r149 = r148.getAdminPrivileges();
        if (r149 == null) goto L126;
        LiveRoomPermission.D.getClass();
        if (r149.contains(Integer.valueOf(LiveRoomPermission.f105062l.f105077a)) != true) goto L126;
        r144 = true;
    L43:
        r125 = null;
    L37:
        r122 = null;
    L46:
        String r150 = ((KtvRoomLyricsStateMachineConfig.d.e) r111).f145409b.g();
        if (r150 == null) goto L75;
        r109.Y5(r150);
    L29:
        r119 = null;
        goto L30
    L23:
        r116 = null;
        goto L24
    L50:
        if ((r111 instanceof KtvRoomLyricsStateMachineConfig.d.f) == false) goto L71;
        if ((r112 instanceof KtvRoomLyricsStateMachineConfig.d.f) == false) goto L67;
        OrderInfo r151 = ((KtvRoomLyricsStateMachineConfig.d.f) r112).f145409b.f153577a.getOrderInfo();
        if (r151 == null) goto L58;
        InteractiveSongUserInfo r152 = r151.getTopUser();
        if (r152 == null) goto L58;
        String r153 = r152.getIdString();
    L59:
        OrderInfo r154 = ((KtvRoomLyricsStateMachineConfig.d.f) r111).f145409b.f153577a.getOrderInfo();
        if (r154 == null) goto L64;
        InteractiveSongUserInfo r155 = r154.getTopUser();
        if (r155 == null) goto L64;
        String r156 = r155.getIdString();
    L66:
        if ((!Intrinsics.areEqual(r153, r156)) == false) goto L75;
    L64:
        r156 = null;
    L58:
        r153 = null;
    L67:
        String r157 = ((KtvRoomLyricsStateMachineConfig.d.f) r111).f145409b.g();
        if (r157 == null) goto L75;
        r109.Y5(r157);
        goto L75
    L71:
        if ((r111 instanceof KtvRoomLyricsStateMachineConfig.d.a) == false) goto L73;
    L74:
        r109.V5(0);
        goto L75
    L73:
        if ((r111 instanceof KtvRoomLyricsStateMachineConfig.d.b) == false) goto L75;
        goto L74
    }

    public KtvMvControlAreaWidget(KtvRoomViewModel r100, KtvContext r101, KtvRoomChallengeViewWrapper r102) {
        Intrinsics.checkNotNullParameter(r101, IKtvService.KEY_OF_KTVCONTEXT_FOR_DATACENTER);
        this.f145624p = r100;
        this.f145625q = r101;
        this.f145626r = r102;
        this.f145622n = new CompositeDisposable();
        this.f145623o = r101.getDataEntity().getValue();
    }
}
