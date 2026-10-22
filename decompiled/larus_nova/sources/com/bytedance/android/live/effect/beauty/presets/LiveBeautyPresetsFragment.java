package com.bytedance.android.live.effect.beauty.presets;

import android.os.Bundle;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.ui.BaseFragment;
import com.bytedance.android.live.effect.LiveSmallItemBeautyHelper;
import com.bytedance.android.live.effect.api.LiveEffectContext;
import com.bytedance.android.live.effect.api.LiveEffectContextFactoryDelegate$Type;
import com.bytedance.android.live.effect.api.d0;
import com.bytedance.android.live.effect.template.BeautifyTemplate;
import com.bytedance.android.live.effect.utils.LivePresetsLogger;
import com.bytedance.android.live.uikit.recyclerview.LoadingStatusView;
import com.bytedance.android.livesdk.config.jq;
import com.bytedance.android.livesdk.config.n21;
import com.bytedance.android.livesdk.config.qb;
import com.bytedance.android.livesdk.h4;
import com.bytedance.android.livesdk.j4;
import com.bytedance.common.utility.concurrent.TTExecutors;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.TypeIntrinsics;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/live/effect/beauty/presets/LiveBeautyPresetsFragment;", "Lcom/bytedance/android/live/core/ui/BaseFragment;", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "liveeffect_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveBeautyPresetsFragment extends BaseFragment {
    public static final /* synthetic */ int C = 0;
    public final Integer A;
    public final b B;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public LiveEffectContextFactoryDelegate$Type f67429d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f67430e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public BeautifyTemplate f67431f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f67432g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public View f67433h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public View f67434i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public View f67435j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public LoadingStatusView f67436k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public RecyclerView f67437l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public ConstraintLayout f67438m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public ImageView f67439n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f67440o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public BeautifyPreset f67441p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f67442q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f67443r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f67444s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public boolean f67445t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public boolean f67446u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public boolean f67447v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public TextView f67448w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final CompositeDisposable f67449x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final Lazy f67450y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final Lazy f67451z;

    public static final class a {
    }

    public static final class b implements q {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LiveBeautyPresetsFragment f67452a;

        public b(LiveBeautyPresetsFragment r100) {
            this.f67452a = r100;
        }

        @Override // com.bytedance.android.live.effect.beauty.presets.q
        public final void onError(String r100) {
            LiveBeautyPresetsFragment r101 = this.f67452a;
            int r102 = LiveBeautyPresetsFragment.C;
            r101.T90().getClass();
            LiveBeautyPresetsHelper.n("beautyPresetsLoadCallback onError:" + r100);
            LoadingStatusView r103 = this.f67452a.f67436k;
            if (r103 != null) goto L5;
            Intrinsics.throwUninitializedPropertyAccessException("loadingView");
        L5:
            r103.showError();
        }

        /* JADX WARN: Type inference failed for: r3v0, types: [T, java.util.concurrent.atomic.AtomicBoolean] */
        @Override // com.bytedance.android.live.effect.beauty.presets.q
        public final void onSuccess(List<BeautifyPreset> r100) {
            Intrinsics.checkNotNullParameter(r100, "presetList");
            StringBuilder r101 = new StringBuilder("beautyPresetsLoadCallback onSuccess:");
            ArrayList r102 = (ArrayList) r100;
            r101.append(r102.size());
            ALogger.e("LiveBeautyPresetsFragment", r101.toString());
            List<String> r103 = LiveEffectContext.f66734h;
            if (LiveEffectContext.a.a(this.f67452a.f67429d).a().W() == false) goto L5;
            LiveBeautyPresetsFragment.S90(this.f67452a, r102);
        L6:
            LiveBeautyPresetsHelper r104 = this.f67452a.T90();
            String r105 = "beautyPresetsLoadCallback onSuccess:" + r102.size();
            r104.getClass();
            LiveBeautyPresetsHelper.n(r105);
            return;
        L5:
            LiveBeautyPresetsFragment r106 = this.f67452a;
            r106.getClass();
            Ref.ObjectRef r107 = new Ref.ObjectRef();
            r107.element = new AtomicBoolean(false);
            LiveBeautyPresetsFragment$waitForRestoreComplete$restoreListener$1 r108 = new LiveBeautyPresetsFragment$waitForRestoreComplete$restoreListener$1(r106, r107, r102);
            LiveEffectContext.a.a(r106.f67429d).a().f(r108);
            r106.f67449x.add(Observable.timer(10, TimeUnit.SECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(new n(r106, r107, r102, r108)));
            goto L6
        }
    }

    static {
    }

    public final LiveBeautyPresetsHelper T90() {
        return (LiveBeautyPresetsHelper) this.f67451z.getValue();
    }

    public final LiveBeautyPresetsAdapter U90() {
        return (LiveBeautyPresetsAdapter) this.f67450y.getValue();
    }

    public final void V90() {
        this.f67445t = m90.b.f512543a.c(this.f67429d).booleanValue();
        this.f67446u = m90.b.f512552j.c(this.f67429d).booleanValue();
        LiveBeautyPresetsHelper r100 = T90();
        Map<String, ? extends List<PresetEffect>> r101 = r100.f67459c;
        boolean r102 = false;
        if (r101 != null) goto L5;
    L8:
        boolean r103 = true;
    L9:
        ALogger.e("LiveBeautyPresetsFragment", "handleState: isChange = " + r103);
        if (r103 == false) goto L12;
        T90().p("");
        U90().A2(T90().f67457a, PresetOperationType.SELECT_PRESET, -1);
    L12:
        if (r103 == true) goto L14;
    L16:
        X90(r102);
        W90(!Intrinsics.areEqual(T90().j(), ""));
        return;
    L14:
        if (((ArrayList) T90().f67457a).size() >= this.A.intValue()) goto L16;
        r102 = true;
        goto L16
    L5:
        if ((!Intrinsics.areEqual(LiveBeautyPresetsHelper.g(r101), LiveBeautyPresetsHelper.g(r100.f()))) == true) goto L8;
        r103 = false;
        goto L9
    }

    public LiveBeautyPresetsFragment() {
        this.f67429d = LiveEffectContextFactoryDelegate$Type.DEFAULT;
        this.f67430e = "";
        BeautifyTemplate r100 = new BeautifyTemplate(CollectionsKt.mutableListOf(new BeautifyTemplate.BeautifyContentType[]{BeautifyTemplate.BeautifyContentType.BEAUTY, BeautifyTemplate.BeautifyContentType.MAKEUPS, BeautifyTemplate.BeautifyContentType.FILTER}));
        int r101 = n21.f120803a;
        if (n21.a.a() == false) goto L14;
        Integer r102 = jq.f120544a.getValue();
        if (r102.intValue() >= 0) goto L7;
    L8:
        r102 = Integer.valueOf(r100.f68831b.size());
    L9:
        List<BeautifyTemplate.BeautifyContentType> r103 = r100.f68831b;
        if (r103 == null) goto L13;
        ListProtector.add(TypeIntrinsics.asMutableList(r103), r102.intValue(), BeautifyTemplate.BeautifyContentType.BODY_BEAUTY);
        goto L14
    L13:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.MutableList<com.bytedance.android.live.effect.template.BeautifyTemplate.BeautifyContentType>");
    L7:
        if (r102.intValue() <= r100.f68831b.size()) goto L9;
    L14:
        Integer r104 = qb.f121041a.getValue();
        if (r104 != null) goto L18;
    L19:
        List<BeautifyTemplate.BeautifyContentType> r105 = r100.f68831b;
        if (r105 == null) goto L23;
        TypeIntrinsics.asMutableList(r105).add(BeautifyTemplate.BeautifyContentType.AV_ADJUST);
    L25:
        if (h4.f132626a.getValue().booleanValue() == false) goto L31;
        List<BeautifyTemplate.BeautifyContentType> r106 = r100.f68831b;
        if (r106 == null) goto L30;
        ListProtector.add(TypeIntrinsics.asMutableList(r106), 0, BeautifyTemplate.BeautifyContentType.PRESETS);
        goto L31
    L30:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.MutableList<com.bytedance.android.live.effect.template.BeautifyTemplate.BeautifyContentType>");
    L31:
        this.f67431f = r100;
        this.f67447v = true;
        this.f67449x = new CompositeDisposable();
        this.f67450y = LazyKt.lazy(new LiveBeautyPresetsFragment$presetsAdapter$2(this));
        this.f67451z = LazyKt.lazy(new LiveBeautyPresetsFragment$helper$2(this));
        this.A = j4.f142017a.getValue();
        this.B = new b(this);
        return;
    L23:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.MutableList<com.bytedance.android.live.effect.template.BeautifyTemplate.BeautifyContentType>");
    L18:
        if (r104.intValue() == 0) goto L25;
        goto L19
    }

    @Override // com.bytedance.android.live.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public final void onDestroy() {
        super.onDestroy();
        this.f67449x.clear();
    }

    @Override // com.bytedance.android.live.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public final void onPause() {
        super.onPause();
        Long r100 = LivePresetsLogger.f68864a;
        LivePresetsLogger.c(((ArrayList) T90().f67457a).size());
        U90().B2(false);
    }

    @Override // com.bytedance.android.live.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public final void onResume() {
        super.onResume();
        Long r100 = LivePresetsLogger.f68864a;
        LivePresetsLogger.f68864a = Long.valueOf(System.currentTimeMillis());
    }

    public final void W90(boolean r100) {
        T90().getClass();
        LiveBeautyPresetsHelper.n("updateResetState:canReset:" + r100);
        if (r100 == false) goto L11;
        View r101 = this.f67434i;
        if (r101 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("resetView");
    L7:
        r101.setClickable(true);
        View r102 = this.f67434i;
        if (r102 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("resetView");
    L10:
        r102.setAlpha(1.0f);
        return;
    L11:
        View r103 = this.f67434i;
        if (r103 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("resetView");
    L14:
        r103.setClickable(false);
        View r104 = this.f67434i;
        if (r104 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("resetView");
    L17:
        r104.setAlpha(0.5f);
    }

    public final void X90(boolean r100) {
        T90().getClass();
        LiveBeautyPresetsHelper.n("updateSaveState:canSave:" + r100);
        this.f67447v = r100;
        ImageView r101 = this.f67439n;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("ivSaveView");
    L5:
        if (r100 == false) goto L7;
        int r102 = R.drawable.ttlive_effect_ic_save_preset_enable;
    L8:
        r101.setImageResource(r102);
        return;
    L7:
        r102 = R.drawable.ttlive_effect_ic_save_preset_disable;
        goto L8
    }

    @Override // androidx.fragment.app.Fragment
    public final void onHiddenChanged(boolean r100) {
        super.onHiddenChanged(r100);
        if (r100 == false) goto L5;
        Long r101 = LivePresetsLogger.f68864a;
        LivePresetsLogger.c(((ArrayList) T90().f67457a).size());
    L7:
        if (this.f67440o == true) goto L10;
        return;
    L10:
        if (r100 == true) goto L12;
        LiveBeautyPresetsHelper r102 = T90();
        String r103 = "onHiddenChanged:" + r100 + ",initialBeautySwitchState:" + this.f67445t + ",initialBodyBeautySwitchState:" + this.f67446u;
        r102.getClass();
        LiveBeautyPresetsHelper.n(r103);
        V90();
        return;
    L12:
        if (U90().f67411c == false) goto L14;
        U90().B2(false);
    L14:
        LiveBeautyPresetsHelper r104 = T90();
        String r105 = "onHiddenChanged:" + r100 + ",selectedPreset:" + this.f67441p + ",isReset:" + this.f67442q + ",beautySwitchChanged:" + this.f67443r + ",bodyBeautySwitchChanged:" + this.f67444s;
        r104.getClass();
        LiveBeautyPresetsHelper.n(r105);
        if (this.f67441p == null) goto L17;
    L18:
        xs2.b.a().post(new n90.b(d0.f66759i, this.f67443r));
        xs2.b.a().post(new n90.b("livebody", this.f67444s));
    L19:
        this.f67442q = false;
        this.f67443r = false;
        this.f67444s = false;
        return;
    L17:
        if (this.f67442q == false) goto L19;
    L5:
        Long r106 = LivePresetsLogger.f68864a;
        LivePresetsLogger.f68864a = Long.valueOf(System.currentTimeMillis());
        goto L7
    }

    public static final void S90(LiveBeautyPresetsFragment r100, List r101) {
        r100.f67440o = true;
        ConstraintLayout r102 = r100.f67438m;
        if (r102 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("savePresetView");
    L5:
        int r103 = 0;
        r102.setVisibility(0);
        View r104 = r100.f67434i;
        if (r104 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("resetView");
    L8:
        r104.setVisibility(0);
        LoadingStatusView r105 = r100.f67436k;
        if (r105 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("loadingView");
    L11:
        r105.setVisibility(8);
        r100.V90();
        r100.U90().A2(r101, PresetOperationType.INIT, -1);
        if (r101.isEmpty() == false) goto L17;
        r100.T90().getClass();
        LiveBeautyPresetsHelper.n("beautyPresetsLoadCallback onSuccess:presetList.isEmpty()");
        TextView r106 = r100.f67448w;
        if (r106 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("remindView");
    L16:
        r106.setVisibility(0);
        return;
    L17:
        Iterator r107 = r101.iterator();
    L19:
        if (r107.hasNext() == false) goto L24;
        if (Intrinsics.areEqual(((BeautifyPreset) r107.next()).getPresetId(), r100.T90().j()) == true) goto L25;
        r103 = r103 + 1;
    L25:
        if (r103 == (-1)) goto L38;
        RecyclerView r108 = r100.f67437l;
        if (r108 != null) goto L29;
        Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
    L29:
        r108.scrollToPosition(r103);
        if (r103 != 0) goto L32;
        String r109 = "1";
    L33:
        Long r110 = LivePresetsLogger.f68864a;
        LivePresetsLogger.a(((BeautifyPreset) ListProtector.get(r101, r103)).getPresetName(), GsonProtectorUtils.toJson(GsonHelper.get(), ((BeautifyPreset) ListProtector.get(r101, r103)).getEffectsByPanel()), null, r109, 4);
        return;
    L32:
        r109 = "0";
        goto L33
    L38:
        return;
    L24:
        r103 = -1;
        goto L25
    }

    @Override // com.bytedance.android.live.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public final void onViewCreated(View r100, Bundle r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        super.onViewCreated(r100, r101);
        T90().getClass();
        LiveBeautyPresetsHelper.n("onViewCreated");
        this.f67434i = r100.findViewById(R.id.reset_view);
        this.f67435j = r100.findViewById(R.id.reset_icon);
        TextView r102 = (TextView) r100.findViewById(R.id.reset_text);
        this.f67448w = (TextView) r100.findViewById(R.id.tv_preset_reminder);
        this.f67436k = (LoadingStatusView) r100.findViewById(R.id.loading_view);
        View r103 = LayoutInflater.from(getContext()).inflate(R.layout.ttlive_effect_view_beauty_presets_loading_error_view, null);
        r103.setOnClickListener(new f(this));
        LoadingStatusView r104 = this.f67436k;
        if (r104 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("loadingView");
    L5:
        r104.setBuilder(LoadingStatusView.Builder.createDefaultBuilder(getContext()).setErrorView(r103).setUseProgressBar(getResources().getDimensionPixelSize(R.dimen.ttlive_effect_default_list_progressbar_size)));
        LoadingStatusView r105 = this.f67436k;
        if (r105 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("loadingView");
    L8:
        r105.showLoading();
        RecyclerView r106 = (RecyclerView) r100.findViewById(R.id.presets_recycle_view);
        this.f67437l = r106;
        if (r106 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
    L11:
        r106.setLayoutManager(new LinearLayoutManager(getContext(), 0, false));
        RecyclerView r107 = this.f67437l;
        if (r107 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
    L14:
        r107.setAdapter(U90());
        View r108 = this.f67434i;
        if (r108 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("resetView");
    L17:
        r108.setOnClickListener(new g(this));
        this.f67438m = (ConstraintLayout) r100.findViewById(R.id.save_preset_view);
        this.f67439n = (ImageView) r100.findViewById(R.id.iv_save_preset);
        ConstraintLayout r109 = this.f67438m;
        if (r109 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("savePresetView");
    L20:
        r109.setOnClickListener(new h(this));
        final GestureDetector r110 = new GestureDetector(getContext(), new j(this));
        RecyclerView r111 = this.f67437l;
        if (r111 != null) goto L23;
        Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
    L23:
        r111.addOnItemTouchListener(new LiveBeautyPresetsFragment$initView$4(r110));
        View r112 = this.f67433h;
        if (r112 != null) goto L26;
        Intrinsics.throwUninitializedPropertyAccessException("rootView");
    L26:
        r112.setOnClickListener(new i(this));
        LiveBeautyPresetsHelper r113 = T90();
        b r114 = this.B;
        r113.getClass();
        TTExecutors.getNormalExecutor().submit(new p(r113, r114));
        List<String> r115 = LiveEffectContext.f66734h;
        if (((CopyOnWriteArrayList) LiveEffectContext.a.a(this.f67429d).b().g().f66680b).isEmpty() == false) goto L30;
        LiveSmallItemBeautyHelper r116 = LiveEffectContext.a.a(this.f67429d).b().g();
        this.f67431f.getClass();
        LiveSmallItemBeautyHelper.d(r116, null, 11);
    L30:
        if (((com.bytedance.android.live.effect.beauty.makeups.d) LiveEffectContext.a.a(this.f67429d).b().f()).f67344a.isEmpty() == false) goto L33;
        com.bytedance.android.live.effect.beauty.makeups.a r117 = LiveEffectContext.a.a(this.f67429d).b().f();
        this.f67431f.getClass();
        ((com.bytedance.android.live.effect.beauty.makeups.d) r117).b(null);
    L33:
        if (((ArrayList) LiveEffectContext.a.a(this.f67429d).b().m().f67270b).isEmpty() == false) goto L36;
        LiveEffectContext.a.a(this.f67429d).b().m().d(null, this.f67430e);
    L36:
        if (CollectionsKt.toList(LiveEffectContext.a.a(this.f67429d).b().p().f67189a).isEmpty() == false) goto L38;
        LiveEffectContext.a.a(this.f67429d).b().p().b(null);
    L38:
        Integer r118 = qb.f121041a.getValue();
        if (r118 == null) goto L44;
        if (r118.intValue() != 0) goto L44;
        return;
    L44:
        if (((CopyOnWriteArrayList) LiveEffectContext.a.a(this.f67429d).b().n().f66849b).isEmpty() == false) goto L48;
        com.bytedance.android.live.effect.avadjust.l.b(LiveEffectContext.a.a(this.f67429d).b().n(), null);
        return;
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r100, ViewGroup r101, Bundle r102) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        if (this.f67432g == false) goto L5;
        int r103 = R.layout.ttlive_effect_fragment_beauty_presets_v2;
    L6:
        View r104 = r100.inflate(r103, r101, false);
        this.f67433h = r104;
        if (r104 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("rootView");
    L9:
        return r104;
    L5:
        r103 = R.layout.ttlive_effect_fragment_beauty_presets;
        goto L6
    }
}
