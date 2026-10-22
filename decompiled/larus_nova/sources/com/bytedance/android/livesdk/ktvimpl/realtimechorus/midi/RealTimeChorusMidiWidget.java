package com.bytedance.android.livesdk.ktvimpl.realtimechorus.midi;

import android.view.ViewGroup;
import androidx.camera.video.AudioStats;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import com.bytedance.android.live.core.utils.StateMachine;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.ktv.common.model.api.g0;
import com.bytedance.android.livesdk.chatroom.widget.MiddlewareRoomWidget;
import com.bytedance.android.livesdk.ktvapi.IKtvService;
import com.bytedance.android.livesdk.ktvimpl.base.KtvContext;
import com.bytedance.android.livesdk.ktvimpl.base.RealTimeChorusMidiViewModelFactory;
import com.bytedance.android.livesdk.ktvimpl.ktvroom.view.midi.KtvComponentMidiView;
import com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel.KtvRoomLyricsStateMachineConfig;
import com.bytedance.android.livesdk.ktvimpl.realtimechorus.l1;
import com.bytedance.android.livesdk.message.model.MusicPanel;
import com.bytedance.android.livesdk.utils.ViewModelStoreOwnerCompat;
import com.bytedance.android.livesdkapi.depend.message.MidiSkinDressInfo;
import com.bytedance.ies.sdk.widgets.NextLiveData;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/ktvimpl/realtimechorus/midi/RealTimeChorusMidiWidget;", "Lcom/bytedance/android/livesdk/chatroom/widget/MiddlewareRoomWidget;", "Lcom/bytedance/android/livesdk/utils/ViewModelStoreOwnerCompat;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "livektv-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class RealTimeChorusMidiWidget extends MiddlewareRoomWidget implements ViewModelStoreOwnerCompat {

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final /* synthetic */ int f146766p = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CompositeDisposable f146767a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public RealTimeChorusMidiViewModel f146768b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public KtvComponentMidiView f146769c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ViewModelStore f146770d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final CompositeDisposable f146771e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Function0<Unit> f146772f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public float f146773g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f146774h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f146775i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final com.bytedance.android.livesdk.ktvimpl.realtimechorus.midi.a f146776j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final m f146777k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final n f146778l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final KtvContext f146779m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final com.bytedance.android.livesdk.ktvimpl.realtimechorus.midi.b f146780n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final l1 f146781o;

    public static final class a {
    }

    public static final class b<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ RealTimeChorusMidiWidget f146782a;

        public b(RealTimeChorusMidiWidget r100) {
            this.f146782a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            RealTimeChorusMidiWidget r101 = this.f146782a;
            MidiSkinDressInfo r102 = (MidiSkinDressInfo) sh6.c.b((sh6.b) r100);
            KtvComponentMidiView r103 = r101.f146769c;
            if (r103 == null) goto L6;
            r103.y(r102);
            return;
        }
    }

    static {
    }

    @Override // com.bytedance.ies.sdk.widgets.Widget
    public final int getLayoutId() {
        return R.layout.ttlive_chorus_midi_layout;
    }

    @Override // com.bytedance.android.livesdk.utils.ViewModelStoreOwnerCompat, androidx.lifecycle.ViewModelStoreOwner
    public final /* synthetic */ ViewModelStore getViewModelStore() {
        return ViewModelStoreOwnerCompat.CC.$default$getViewModelStore(this);
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveWidget, com.bytedance.livesdk.preview.merge.AbsMergeWidget, com.bytedance.ies.sdk.widgets.Widget
    public final void onDestroy() {
        this.f146767a.clear();
        KtvComponentMidiView r100 = this.f146769c;
        if (r100 == null) goto L5;
        r100.onDetach();
    L5:
        this.f146770d.clear();
        if (this.f146771e.isDisposed() == true) goto L8;
        this.f146771e.dispose();
    L8:
        super.onDestroy();
    }

    public final double wq() {
        RealTimeChorusMidiViewModel r100 = this.f146768b;
        if (r100 == null) goto L11;
        MutableLiveData<Pair<Long, com.bytedance.android.live.ktv.common.midi.k>> r101 = r100.m8264getScoreInfo();
        if (r101 == null) goto L11;
        Pair<Long, com.bytedance.android.live.ktv.common.midi.k> r102 = r101.getValue();
        if (r102 == null) goto L11;
        com.bytedance.android.live.ktv.common.midi.k r103 = r102.getSecond();
        if (r103 == null) goto L11;
        return r103.f69863d;
    L11:
        return AudioStats.AUDIO_AMPLITUDE_NONE;
    }

    @Override // com.bytedance.android.livesdk.chatroom.widget.MiddlewareRoomWidget, com.bytedance.android.live.core.tetris.widgets.LiveWidget, com.bytedance.ies.sdk.widgets.Widget
    public final void onCreate() {
        super.onCreate();
        KtvComponentMidiView r100 = (KtvComponentMidiView) this.contentView.findViewById(R.id.chorus_midi_view);
        this.f146769c = r100;
        if (r100 == null) goto L5;
        r100.setPerformStrategy(this.f146778l);
    L5:
        KtvComponentMidiView r101 = this.f146769c;
        if (r101 == null) goto L8;
        r101.qc(this.f146777k);
    L8:
        KtvComponentMidiView r102 = this.f146769c;
        if ((r102 instanceof com.bytedance.android.live.ktv.common.util.c) == true) goto L11;
        r102 = null;
    L11:
        if (r102 == null) goto L15;
        this.f146779m.getStatisticHelper().b(r102);
        ViewGroup r103 = this.containerView;
        if (r103 == null) goto L15;
        r103.postDelayed(new l(r102), vm2.h.A());
    L15:
        RealTimeChorusMidiViewModel r104 = (RealTimeChorusMidiViewModel) new ViewModelProvider(this, new RealTimeChorusMidiViewModelFactory(this.f146779m)).get(RealTimeChorusMidiViewModel.class);
        this.f146768b = r104;
        if (r104 == null) goto L18;
        r104.onCreate(this);
    L18:
        RealTimeChorusMidiViewModel r105 = this.f146768b;
        if (r105 == null) goto L23;
        MutableLiveData<List<cb0.c>> r106 = r105.getMidiData();
        if (r106 == null) goto L23;
        r106.observe(this, new h(this));
    L23:
        RealTimeChorusMidiViewModel r107 = this.f146768b;
        if (r107 == null) goto L28;
        MutableLiveData<g0> r108 = r107.getMidiConfig();
        if (r108 == null) goto L28;
        r108.observe(this, new i(this));
    L28:
        RealTimeChorusMidiViewModel r109 = this.f146768b;
        if (r109 == null) goto L33;
        MutableLiveData<Pair<Long, com.bytedance.android.live.ktv.common.midi.k>> r110 = r109.m8264getScoreInfo();
        if (r110 == null) goto L33;
        r110.observe(this, new j(this));
    L33:
        RealTimeChorusMidiViewModel r111 = this.f146768b;
        if (r111 == null) goto L38;
        KtvComponentMidiView r112 = this.f146769c;
        if (r112 == null) goto L38;
        r112.Gk(r111, this.f146778l);
    L38:
        RealTimeChorusMidiViewModel r113 = this.f146768b;
        if (r113 == null) goto L43;
        NextLiveData<StateMachine.c.b<KtvRoomLyricsStateMachineConfig.d, KtvRoomLyricsStateMachineConfig.a, KtvRoomLyricsStateMachineConfig.b>> r114 = r113.getCurState();
        if (r114 == null) goto L43;
        r114.observe(this, new k(this));
    L43:
        RealTimeChorusMidiViewModel r115 = this.f146768b;
        if (r115 == null) goto L48;
        NextLiveData<Long> r116 = r115.getLyricProgress();
        if (r116 == null) goto L48;
        final RealTimeChorusMidiWidget$initStageViewModel$6 r117 = new RealTimeChorusMidiWidget$initStageViewModel$6(this);
        r116.observe(this, new o(r117));
    L48:
        MidiSkinDressInfo r118 = this.f146779m.getMidiSkinContext().getValue();
        KtvComponentMidiView r119 = this.f146769c;
        if (r119 == null) goto L51;
        r119.y(r118);
    L51:
        RxUtilKt.c(this.f146779m.getMidiSkinContext().a().subscribe(new b(this)), this.f146771e);
        Function0<Unit> r120 = this.f146772f;
        if (r120 == null) goto L55;
        Unit r121 = r120.invoke();
        return;
    }

    @Override // com.bytedance.android.livesdk.utils.ViewModelStoreOwnerCompat
    public final ViewModelStore tf() {
        return this.f146770d;
    }

    public final void xq(Long r100) {
        com.bytedance.live.datacontext.n<com.bytedance.android.livesdk.ktvimpl.base.viewmodel.c> r101 = this.f146779m.getKtvCoreViewModel();
        if (r101 == null) goto L9;
        com.bytedance.android.livesdk.ktvimpl.base.viewmodel.c r102 = r101.getValue();
        if (r102 == null) goto L9;
        KtvRoomLyricsStateMachineConfig.d r103 = r102.getCurState();
        if (r103 == null) goto L9;
        MusicPanel r104 = r103.b();
    L10:
        if (r104 == null) goto L19;
        KtvComponentMidiView r105 = this.f146769c;
        if (r105 != null) goto L14;
        return;
    L14:
        if (r105.getVisibility() != 0) goto L21;
        RealTimeChorusMidiViewModel r106 = this.f146768b;
        if (r106 == null) goto L22;
        r106.tryStartGetScoreInfoTimer(r100);
        return;
    L22:
        return;
    L21:
        return;
    L19:
        return;
    L9:
        r104 = null;
        goto L10
    }

    public RealTimeChorusMidiWidget(KtvContext r100, c r101, l1 r102) {
        Intrinsics.checkNotNullParameter(r100, IKtvService.KEY_OF_KTVCONTEXT_FOR_DATACENTER);
        Intrinsics.checkNotNullParameter(r102, "singInfoProvider");
        this.f146779m = r100;
        this.f146780n = r101;
        this.f146781o = r102;
        this.f146767a = new CompositeDisposable();
        this.f146770d = new ViewModelStore();
        this.f146771e = new CompositeDisposable();
        this.f146775i = -1;
        this.f146776j = new com.bytedance.android.livesdk.ktvimpl.realtimechorus.midi.a();
        this.f146777k = new m();
        this.f146778l = new n();
    }
}
