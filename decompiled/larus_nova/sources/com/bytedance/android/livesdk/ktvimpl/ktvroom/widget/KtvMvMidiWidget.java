package com.bytedance.android.livesdk.ktvimpl.ktvroom.widget;

import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.StateMachine;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.core.utils.rxutils.autodispose.ObservableSubscribeProxy;
import com.bytedance.android.live.ktv.common.midi.AbsKtvMidiView;
import com.bytedance.android.live.ktv.common.midi.MidiContext;
import com.bytedance.android.livesdk.chatroom.widget.MiddlewareRoomWidget;
import com.bytedance.android.livesdk.ktvapi.IKtvService;
import com.bytedance.android.livesdk.ktvimpl.base.KtvContext;
import com.bytedance.android.livesdk.ktvimpl.base.KtvStageViewModelFactory;
import com.bytedance.android.livesdk.ktvimpl.base.datacontext.KtvRoomContext;
import com.bytedance.android.livesdk.ktvimpl.base.lyrics.widget.MvLyricWidget;
import com.bytedance.android.livesdk.ktvimpl.ktvroom.previewsongs.KtvPreviewSongsViewModel;
import com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel.KtvRoomLyricsStateMachineConfig;
import com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel.KtvRoomViewModel;
import com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel.stage.KtvMidiStageViewModel;
import com.bytedance.android.livesdk.message.model.KtvMusic;
import com.bytedance.android.livesdk.message.model.MusicPanel;
import com.bytedance.android.livesdk.utils.ViewModelStoreOwnerCompat;
import com.bytedance.android.livesdkapi.depend.message.MidiSkinDressInfo;
import com.bytedance.ies.sdk.widgets.NextLiveData;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.larus.nova.R;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/ktvimpl/ktvroom/widget/KtvMvMidiWidget;", "Lcom/bytedance/android/livesdk/chatroom/widget/MiddlewareRoomWidget;", "Lcom/bytedance/android/livesdk/utils/ViewModelStoreOwnerCompat;", "Ltb0/a;", "livektv-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class KtvMvMidiWidget extends MiddlewareRoomWidget implements ViewModelStoreOwnerCompat, tb0.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CompositeDisposable f145633a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public KtvMidiStageViewModel f145634b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public AbsKtvMidiView f145635c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public com.bytedance.android.livesdk.ktvimpl.ktvroom.view.singer.a f145636d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ViewModelStore f145637e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final CompositeDisposable f145638f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final KtvContext f145639g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final KtvRoomViewModel f145640h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final com.bytedance.android.livesdk.ktvimpl.base.lyrics.b f145641i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final View f145642j;

    public static final class a<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ KtvMvMidiWidget f145643a;

        public a(KtvMvMidiWidget r100) {
            this.f145643a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            KtvMvMidiWidget r101 = this.f145643a;
            MidiSkinDressInfo r102 = (MidiSkinDressInfo) sh6.c.b((sh6.b) r100);
            AbsKtvMidiView r103 = r101.f145635c;
            if (r103 == null) goto L6;
            r103.y(r102);
            return;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.ktvimpl.ktvroom.widget.KtvMvMidiWidget$onBizEnterRoom$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "p1", "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 5, 1})
    public static final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<Boolean, Unit> {
        public AnonymousClass1(KtvMvMidiWidget r100) {
            super(1, r100, KtvMvMidiWidget.class, "onPreviewCardShown", "onPreviewCardShown(Z)V", 0);
        }

        public final void invoke(boolean r100) {
            KtvMvMidiWidget r101 = (KtvMvMidiWidget) this.receiver;
            if (r100 == false) goto L7;
            AbsKtvMidiView r102 = r101.f145635c;
            if (r102 == null) goto L9;
            r102.setVisibility(8);
            return;
        L9:
            return;
        L7:
            r101.getClass();
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Boolean r100) {
            invoke(r100.booleanValue());
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.ktvimpl.ktvroom.widget.KtvMvMidiWidget$onCreate$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", "p1", "", AbsMethodDelegate.TAG_INVOKE, "(Ljava/lang/Long;)V"}, k = 3, mv = {1, 5, 1})
    public static final /* synthetic */ class C101131 extends FunctionReferenceImpl implements Function1<Long, Unit> {
        public C101131(KtvMvMidiWidget r100) {
            super(1, r100, KtvMvMidiWidget.class, "onListenerLyricPlayTimeCallback", "onListenerLyricPlayTimeCallback(Ljava/lang/Long;)V", 0);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Long r100) {
            KtvMvMidiWidget r101 = (KtvMvMidiWidget) this.receiver;
            r101.getClass();
            if (r100 == null) goto L36;
            long r102 = r100.longValue();
            KtvRoomViewModel r103 = r101.f145640h;
            KtvMidiStageViewModel r104 = null;
            if (r103 == null) goto L9;
            KtvRoomLyricsStateMachineConfig.d r105 = r103.getCurState();
            if (r105 == null) goto L9;
            MusicPanel r106 = r105.b();
        L10:
            KtvMidiStageViewModel r107 = r101.f145634b;
            if ((r107 instanceof KtvMidiStageViewModel) == false) goto L14;
            r104 = r107;
        L14:
            if (r104 == null) goto L24;
            MutableLiveData<Pair<Long, com.bytedance.android.live.ktv.common.midi.k>> r108 = r104.m8260getScoreInfo();
            if (r108 == null) goto L24;
            Pair<Long, com.bytedance.android.live.ktv.common.midi.k> r109 = r108.getValue();
            if (r109 == null) goto L24;
            com.bytedance.android.live.ktv.common.midi.k r110 = r109.getSecond();
            if (r110 == null) goto L24;
            AbsKtvMidiView r111 = r101.f145635c;
            if (r111 == null) goto L24;
            r111.S5(r110, r100);
        L24:
            AbsKtvMidiView r112 = r101.f145635c;
            if (r112 == null) goto L27;
            r112.R2(r102);
        L27:
            if (r106 == null) goto L37;
            KtvMusic r113 = r106.f153577a;
            if (r113 == null) goto L38;
            KtvMusic.Companion.getClass();
            long r114 = KtvMusic.a.a(r113);
            if (r114 <= 0) goto L39;
            AbsKtvMidiView r115 = r101.f145635c;
            if (r115 == null) goto L40;
            r115.U5(r114 * 1000, KtvMusic.a.b(r113, r102));
            return;
        L40:
            return;
        L39:
            return;
        L38:
            return;
        L37:
            return;
        L9:
            r106 = null;
            goto L10
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Long r100) {
            invoke2(r100);
            return Unit.INSTANCE;
        }
    }

    @Override // com.bytedance.ies.sdk.widgets.Widget
    public final int getLayoutId() {
        return R.layout.ttlive_ktv_mv_midi_layout;
    }

    @Override // com.bytedance.android.livesdk.utils.ViewModelStoreOwnerCompat, androidx.lifecycle.ViewModelStoreOwner
    public final /* synthetic */ ViewModelStore getViewModelStore() {
        return ViewModelStoreOwnerCompat.CC.$default$getViewModelStore(this);
    }

    @Override // tb0.a
    public final void onBizDestory() {
    }

    @Override // tb0.a
    public final void onBizHide() {
    }

    @Override // tb0.a
    public final void onBizLeaveRoom() {
    }

    @Override // tb0.a
    public final void onBizShow() {
    }

    @Override // tb0.a
    public final void onBizEnterRoom() {
        KtvRoomContext.Companion.getClass();
        KtvRoomContext r100 = KtvRoomContext.a.a();
        if (r100 == null) goto L15;
        com.bytedance.live.datacontext.n<KtvPreviewSongsViewModel> r101 = r100.getPreviewViewModel();
        if (r101 == null) goto L15;
        KtvPreviewSongsViewModel r102 = r101.getValue();
        if (r102 == null) goto L15;
        com.bytedance.live.datacontext.m<Boolean> r103 = r102.getShowPreviewCard();
        if (r103 == null) goto L15;
        Observable<Boolean> r104 = r103.a();
        if (r104 == null) goto L15;
        ObservableSubscribeProxy r105 = (ObservableSubscribeProxy) r104.as(autoDispose());
        if (r105 == null) goto L15;
        final AnonymousClass1 r106 = new AnonymousClass1(this);
        r105.subscribe(new b(r106));
    L15:
        KtvMidiStageViewModel r107 = this.f145634b;
        if (r107 == null) goto L21;
        AbsKtvMidiView r108 = this.f145635c;
        if (r108 == null) goto L22;
        r108.T5(r107);
        return;
    L22:
        return;
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveWidget, com.bytedance.livesdk.preview.merge.AbsMergeWidget, com.bytedance.ies.sdk.widgets.Widget
    public final void onDestroy() {
        this.f145633a.clear();
        AbsKtvMidiView r100 = this.f145635c;
        if (r100 == null) goto L5;
        r100.setVisibility(8);
    L5:
        AbsKtvMidiView r101 = this.f145635c;
        if (r101 == null) goto L8;
        r101.onDetach();
    L8:
        this.f145637e.clear();
        if (this.f145638f.isDisposed() == true) goto L11;
        this.f145638f.dispose();
    L11:
        super.onDestroy();
    }

    public final void wq() {
        KtvMidiStageViewModel r100 = this.f145634b;
        Object r101 = null;
        if (r100 == null) goto L9;
        NextLiveData<StateMachine.c.b<KtvRoomLyricsStateMachineConfig.d, KtvRoomLyricsStateMachineConfig.a, KtvRoomLyricsStateMachineConfig.b>> r102 = r100.getCurState();
        if (r102 == null) goto L9;
        StateMachine.c.b<KtvRoomLyricsStateMachineConfig.d, KtvRoomLyricsStateMachineConfig.a, KtvRoomLyricsStateMachineConfig.b> r103 = r102.getValue();
        if (r103 == null) goto L9;
        KtvRoomLyricsStateMachineConfig.d r104 = r103.f66101c;
    L11:
        if ((r104 instanceof KtvRoomLyricsStateMachineConfig.d.b) == true) goto L15;
        AbsKtvMidiView r105 = this.f145635c;
        if (r105 == null) goto L15;
        r105.setVisibility(0);
    L15:
        ALogger.i("midi-check", "onSongFeedbackHide");
        KtvRoomContext.Companion.getClass();
        KtvRoomContext r106 = KtvRoomContext.a.a();
        if (r106 == null) goto L24;
        com.bytedance.live.datacontext.n<KtvPreviewSongsViewModel> r107 = r106.getPreviewViewModel();
        if (r107 == null) goto L24;
        KtvPreviewSongsViewModel r108 = r107.getValue();
        if (r108 == null) goto L24;
        com.bytedance.live.datacontext.m<Boolean> r109 = r108.getNeedDelayToShow();
        if (r109 == null) goto L24;
        r109.setValue(Boolean.FALSE);
    L24:
        com.bytedance.android.livesdk.ktvimpl.ktvroom.view.singer.a r110 = this.f145636d;
        if ((r110 instanceof View) == false) goto L28;
        r101 = r110;
    L28:
        View r111 = (View) r101;
        if (r111 == null) goto L31;
        r111.setVisibility(8);
    L31:
        View r112 = this.f145642j;
        if (r112 == null) goto L34;
        r112.setBackgroundColor(0);
    L34:
        View r113 = this.f145642j;
        if (r113 == null) goto L38;
        r113.setVisibility(8);
        return;
    L38:
        return;
    L9:
        r104 = null;
        goto L11
    }

    @Override // com.bytedance.android.livesdk.chatroom.widget.MiddlewareRoomWidget, com.bytedance.android.live.core.tetris.widgets.LiveWidget, com.bytedance.ies.sdk.widgets.Widget
    public final void onCreate() {
        super.onCreate();
        MidiContext.a r100 = MidiContext.Companion;
        sb0.b r101 = this.f145639g.getDataEntity().getValue();
        MusicPanel r102 = null;
        if (r101 == null) goto L7;
        sb0.e r103 = r101.b();
        if (r103 == null) goto L7;
        Map<String, String> r104 = r103.getAnchorAbMap();
    L8:
        r100.getClass();
        if (MidiContext.a.e(r104) == false) goto L11;
        AbsKtvMidiView r105 = (AbsKtvMidiView) this.contentView.findViewById(R.id.ktv_mv_midi_view_v2);
    L12:
        this.f145635c = r105;
        if ((r105 instanceof com.bytedance.android.live.ktv.common.util.c) == true) goto L15;
        r105 = null;
    L15:
        if (r105 == null) goto L19;
        this.f145639g.getStatisticHelper().b(r105);
        ViewGroup r106 = this.containerView;
        if (r106 == null) goto L19;
        r106.postDelayed(new l0(r105), vm2.h.A());
    L19:
        View r107 = this.contentView;
        if (r107 == null) goto L24;
        ViewStub r108 = (ViewStub) r107.findViewById(R.id.ktv_song_end_feed_back_view_v2);
        if (r108 == null) goto L24;
        KeyEvent.Callback r109 = r108.inflate();
    L26:
        if ((r109 instanceof com.bytedance.android.livesdk.ktvimpl.ktvroom.view.singer.a) == true) goto L28;
        r109 = null;
    L28:
        com.bytedance.android.livesdk.ktvimpl.ktvroom.view.singer.a r110 = (com.bytedance.android.livesdk.ktvimpl.ktvroom.view.singer.a) r109;
        this.f145636d = r110;
        if (r110 == null) goto L31;
        r110.setKtvRoomViewModel(this.f145640h);
    L31:
        Pair r111 = com.bytedance.live.datacontext.d.a(KtvMvMidiWidget$initStageViewModel$pair$1.INSTANCE);
        MidiContext r112 = (MidiContext) r111.getFirst();
        this.f145638f.add((Disposable) r111.getSecond());
        com.bytedance.live.datacontext.b.a(r112, MidiContext.class);
        KtvMidiStageViewModel r113 = (KtvMidiStageViewModel) new ViewModelProvider(this, new KtvStageViewModelFactory(this.f145639g, this.f145640h)).get(KtvMidiStageViewModel.class);
        this.f145634b = r113;
        if (r113 == null) goto L34;
        r113.onCreate(this);
    L34:
        KtvMidiStageViewModel r114 = this.f145634b;
        if (r114 == null) goto L39;
        MutableLiveData<List<cb0.c>> r115 = r114.getMidiData();
        if (r115 == null) goto L39;
        r115.observe(this, new g0(this));
    L39:
        KtvMidiStageViewModel r116 = this.f145634b;
        if (r116 == null) goto L44;
        MutableLiveData<com.bytedance.android.live.ktv.common.model.api.g0> r117 = r116.getMidiConfig();
        if (r117 == null) goto L44;
        r117.observe(this, new h0(this));
    L44:
        KtvMidiStageViewModel r118 = this.f145634b;
        if (r118 == null) goto L49;
        MutableLiveData<Pair<Long, com.bytedance.android.live.ktv.common.midi.k>> r119 = r118.m8260getScoreInfo();
        if (r119 == null) goto L49;
        r119.observe(this, new i0(this));
    L49:
        KtvMidiStageViewModel r120 = this.f145634b;
        if (r120 == null) goto L54;
        MutableLiveData<Boolean> r121 = r120.getHideFeedback();
        if (r121 == null) goto L54;
        r121.observe(this, new j0(this));
    L54:
        KtvMidiStageViewModel r122 = this.f145634b;
        if (r122 == null) goto L59;
        AbsKtvMidiView r123 = this.f145635c;
        if (r123 == null) goto L59;
        r123.T5(r122);
    L59:
        KtvMidiStageViewModel r124 = this.f145634b;
        if (r124 == null) goto L64;
        NextLiveData<StateMachine.c.b<KtvRoomLyricsStateMachineConfig.d, KtvRoomLyricsStateMachineConfig.a, KtvRoomLyricsStateMachineConfig.b>> r125 = r124.getCurState();
        if (r125 == null) goto L64;
        r125.observe(this, new k0(this));
    L64:
        KtvMidiStageViewModel r126 = this.f145634b;
        if (r126 == null) goto L69;
        NextLiveData<Long> r127 = r126.getLyricProgress();
        if (r127 == null) goto L69;
        final KtvMvMidiWidget$initStageViewModel$7 r128 = new KtvMvMidiWidget$initStageViewModel$7(this);
        r127.observe(this, new m0(r128));
    L69:
        RxUtilKt.c(this.f145639g.observeSingEndedFeedbackSei(new d0(this)), this.f145633a);
        KtvRoomViewModel r129 = this.f145640h;
        if (r129 == null) goto L74;
        MutableLiveData<oe2.f> r130 = r129.getStageUiState();
        if (r130 == null) goto L74;
        com.bytedance.android.livesdk.ktvapi.util.d.a(r130, this, KtvMvMidiWidget$initStageViewModel$9.INSTANCE, new e0(this));
    L74:
        this.f145640h.getSingerFollowState().observe(this, new f0(this));
        com.bytedance.live.datacontext.n<com.bytedance.android.livesdk.ktvimpl.base.viewmodel.c> r131 = this.f145639g.getKtvCoreViewModel();
        if (r131 == null) goto L81;
        com.bytedance.android.livesdk.ktvimpl.base.viewmodel.c r132 = r131.getValue();
        if (r132 == null) goto L81;
        KtvRoomLyricsStateMachineConfig.d r133 = r132.getCurState();
        if (r133 == null) goto L81;
        r102 = r133.b();
    L81:
        NextLiveData<com.bytedance.android.livesdk.ktvimpl.base.sei.k> r134 = this.f145640h.getFeedSeiModel();
        if (r102 == null) goto L84;
    L89:
        ALogger.i(bb0.b.b(), "handleEnterStage in singing, invoke class :KtvMvMidiWidget");
        AbsKtvMidiView r135 = this.f145635c;
        if (r135 == null) goto L92;
        r135.setVisibility(0);
    L92:
        AbsKtvMidiView r136 = this.f145635c;
        if (r136 == null) goto L95;
        r136.setVisibility(0);
    L95:
        AbsKtvMidiView r137 = this.f145635c;
        if (r137 == null) goto L99;
        r137.R5();
    L99:
        if (r134.getValue() == null) goto L106;
        com.bytedance.android.livesdk.ktvimpl.base.sei.k r138 = r134.getValue();
        if (r138 == null) goto L106;
        KtvMidiStageViewModel r139 = this.f145634b;
        if (r139 == null) goto L106;
        r139.initAudienceMidi(r138);
    L106:
        com.bytedance.android.livesdk.ktvimpl.base.lyrics.b r140 = this.f145641i;
        if (r140 == null) goto L109;
        r140.a(new C101131(this));
    L109:
        com.bytedance.live.datacontext.n<MidiSkinDressInfo> r141 = this.f145639g.getMidiSkinContext();
        if (r141 == null) goto L117;
        Observable<sh6.b<MidiSkinDressInfo>> r142 = r141.a();
        if (r142 == null) goto L118;
        Disposable r143 = r142.subscribe(new a(this));
        if (r143 == null) goto L119;
        RxUtilKt.c(r143, this.f145638f);
        return;
    L119:
        return;
    L118:
        return;
    L117:
        return;
    L84:
        if (r134.getValue() != null) goto L89;
        AbsKtvMidiView r144 = this.f145635c;
        if (r144 == null) goto L106;
        r144.setVisibility(8);
    L24:
        r109 = null;
        goto L26
    L11:
        r105 = (AbsKtvMidiView) this.contentView.findViewById(R.id.ktv_mv_midi_view);
    L7:
        r104 = null;
        goto L8
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveWidget, com.bytedance.ies.sdk.widgets.Widget
    public final void onResume() {
        super.onResume();
        AbsKtvMidiView r100 = this.f145635c;
        if (r100 == null) goto L6;
        r100.onResume();
        return;
    }

    @Override // com.bytedance.android.livesdk.utils.ViewModelStoreOwnerCompat
    public final ViewModelStore tf() {
        return this.f145637e;
    }

    public KtvMvMidiWidget(KtvContext r100, KtvRoomViewModel r101, MvLyricWidget r102, View r103) {
        Intrinsics.checkNotNullParameter(r100, IKtvService.KEY_OF_KTVCONTEXT_FOR_DATACENTER);
        Intrinsics.checkNotNullParameter(r101, "mRoomViewModel");
        this.f145639g = r100;
        this.f145640h = r101;
        this.f145641i = r102;
        this.f145642j = r103;
        this.f145633a = new CompositeDisposable();
        this.f145637e = new ViewModelStore();
        this.f145638f = new CompositeDisposable();
    }
}
