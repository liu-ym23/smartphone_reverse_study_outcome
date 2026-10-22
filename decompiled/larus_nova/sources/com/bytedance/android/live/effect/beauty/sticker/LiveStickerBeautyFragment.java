package com.bytedance.android.live.effect.beauty.sticker;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.amap.api.col.s.ce;
import com.bytedance.android.live.core.ui.BaseFragment;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.effect.api.LiveEffectContext;
import com.bytedance.android.live.effect.api.LiveEffectContextFactoryDelegate$Type;
import com.bytedance.android.live.effect.api.d0;
import com.bytedance.android.live.effect.base.setting.LiveEffectSettings;
import com.bytedance.android.live.effect.sticker.api.AnchorEffectApi;
import com.bytedance.android.live.effect.sticker.k;
import com.bytedance.android.live.effect.sticker.m;
import com.bytedance.android.live.effect.sticker.n;
import com.bytedance.android.live.effect.sticker.presenter.o;
import com.bytedance.android.live.uikit.recyclerview.LoadingStatusView;
import com.bytedance.android.livesdk.chatroom.ui.LiveDoubleColorBallAnimationView;
import com.bytedance.android.livesdkapi.depend.model.Sticker;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001:\u0002\b\tR\u0017\u0010\u0007\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\n"}, d2 = {"Lcom/bytedance/android/live/effect/beauty/sticker/LiveStickerBeautyFragment;", "Lcom/bytedance/android/live/core/ui/BaseFragment;", "Lcom/bytedance/android/live/effect/api/LiveEffectContextFactoryDelegate$Type;", ce.f26396k, "Lcom/bytedance/android/live/effect/api/LiveEffectContextFactoryDelegate$Type;", "getType", "()Lcom/bytedance/android/live/effect/api/LiveEffectContextFactoryDelegate$Type;", "type", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "b", "liveeffect_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveStickerBeautyFragment extends BaseFragment {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final /* synthetic */ int f67741o = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Map<Integer, View> f67742d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Sticker f67743e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Lazy f67744f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final CompositeDisposable f67745g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public k f67746h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final e f67747i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final com.bytedance.android.live.effect.beauty.sticker.a f67748j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final LiveEffectContextFactoryDelegate$Type f67749k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final String f67750l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final String f67751m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final long f67752n;

    public static final class a {
    }

    public static final class b {
        public b() {
        }
    }

    static {
    }

    public final LiveStickerListAdapter U90() {
        return (LiveStickerListAdapter) this.f67744f.getValue();
    }

    public final void T90() {
        List<String> r100 = LiveEffectContext.f66734h;
        o.a.a(LiveEffectContext.a.a(this.f67749k).b().d(), this.f67750l, this.f67748j, false, false, false, 48);
    }

    public final void V90() {
        List<String> r100 = LiveEffectContext.f66734h;
        this.f67743e = (Sticker) CollectionsKt.firstOrNull(LiveEffectContext.a.a(this.f67749k).a().o(d0.f66753c));
        LiveStickerListAdapter r101 = U90();
        Sticker r102 = this.f67743e;
        if (r102 == null) goto L5;
        long r103 = r102.getId();
    L6:
        Sticker r104 = this.f67743e;
        long r105 = r101.f67754a;
        r101.f67754a = r103;
        List<Long> r106 = r101.f67756c;
        ArrayList r107 = (ArrayList) r106;
        int r108 = r107.indexOf(Long.valueOf(r103));
        if (r104 == null) goto L12;
        if (r108 < 0) goto L12;
        if (r108 >= ((ArrayList) r101.f67755b).size()) goto L12;
        ListProtector.set(r101.f67755b, r108, r104);
    L12:
        List<Long> r109 = r101.f67756c;
        ArrayList r110 = (ArrayList) r109;
        if (r110.contains(Long.valueOf(r105)) == true) goto L15;
    L17:
        List<Long> r111 = r101.f67756c;
        ArrayList r112 = (ArrayList) r111;
        if (r112.contains(Long.valueOf(r101.f67754a)) == false) goto L21;
        r101.notifyItemChanged(r108, 1);
        return;
    L21:
        return;
    L15:
        if (r105 == r101.f67754a) goto L17;
        List<Long> r113 = r101.f67756c;
        ArrayList r114 = (ArrayList) r113;
        r101.notifyItemChanged(r114.indexOf(Long.valueOf(r105)), 1);
        goto L17
    L5:
        r103 = 0;
        goto L6
    }

    @Override // com.bytedance.android.live.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public final void onDestroy() {
        super.onDestroy();
        if (this.f67746h == null) goto L5;
        k.f68200k.getClass();
        k.f68199j = 0;
        k.f68198i = false;
    L5:
        this.f67745g.clear();
    }

    @Override // com.bytedance.android.live.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public final void onDestroyView() {
        super.onDestroyView();
        this.f67742d.clear();
    }

    public final LiveEffectContextFactoryDelegate$Type getType() {
        return this.f67749k;
    }

    public final View S90(int r100) {
        if (this.f67742d != null) goto L5;
        this.f67742d = new LinkedHashMap();
    L5:
        View r101 = this.f67742d.get(Integer.valueOf(r100));
        if (r101 != null) goto L14;
        View r102 = getView();
        if (r102 == null) goto L12;
        View r103 = r102.findViewById(r100);
        if (r103 == null) goto L12;
        this.f67742d.put(Integer.valueOf(r100), r103);
        return r103;
    L12:
        return null;
    L14:
        return r101;
    }

    @Override // androidx.fragment.app.Fragment
    public final void onHiddenChanged(boolean r100) {
        super.onHiddenChanged(r100);
        if (r100 == true) goto L6;
        V90();
        return;
    }

    @Override // com.bytedance.android.live.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public final void onViewCreated(View r100, Bundle r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        super.onViewCreated(r100, r101);
        V90();
        LiveStickerListAdapter r102 = U90();
        com.bytedance.android.live.effect.beauty.sticker.b r103 = new com.bytedance.android.live.effect.beauty.sticker.b(this);
        r102.getClass();
        Intrinsics.checkNotNullParameter(r103, "listener");
        r102.f67757d = r103;
        LiveStickerListAdapter r104 = U90();
        c r105 = new c(this);
        r104.getClass();
        Intrinsics.checkNotNullParameter(r105, "listener");
        r104.f67758e = r105;
        View r106 = LayoutInflater.from(getContext()).inflate(R.layout.ttlive_effect_broadcast_beauty_panel_error_layout, null);
        r106.setOnClickListener(new d(this));
        Context r107 = getContext();
        if (r107 == null) goto L5;
        LiveDoubleColorBallAnimationView r108 = new LiveDoubleColorBallAnimationView(r107);
        int r109 = r108.getResources().getDimensionPixelSize(R.dimen.ttlive_effect_default_list_progressbar_size);
        FrameLayout.LayoutParams r110 = new FrameLayout.LayoutParams(r109, r109);
        r110.gravity = 17;
        r108.setLayoutParams(r110);
    L6:
        LoadingStatusView r111 = (LoadingStatusView) S90(R.id.sticker_beauty_loading_view);
        if (r111 == null) goto L9;
        r111.setBuilder(new LoadingStatusView.Builder(getContext()).setErrorView(r106).setLoadingView(r108));
    L9:
        LoadingStatusView r112 = (LoadingStatusView) S90(R.id.sticker_beauty_loading_view);
        if (r112 == null) goto L12;
        r112.showLoading();
    L12:
        RecyclerView r113 = (RecyclerView) S90(R.id.sticker_beauty_recycle_view);
        if (r113 == null) goto L15;
        r113.setLayoutManager(new LinearLayoutManager(getContext(), 0, false));
    L15:
        RecyclerView r114 = (RecyclerView) S90(R.id.sticker_beauty_recycle_view);
        if (r114 == null) goto L18;
        r114.setAdapter(U90());
    L18:
        RecyclerView r115 = (RecyclerView) S90(R.id.sticker_beauty_recycle_view);
        if (r115 == null) goto L21;
        r115.addItemDecoration(new LiveBeautyStickerItemDecoration());
    L21:
        RecyclerView r116 = (RecyclerView) S90(R.id.sticker_beauty_recycle_view);
        if (r116 == null) goto L24;
        r116.setHasFixedSize(true);
    L24:
        T90();
        RxUtilKt.c(xs2.b.a().b(b.class).subscribe(new f(this)), this.f67745g);
        long r117 = this.f67752n;
        if (r117 <= 0) goto L33;
        k.a r118 = k.f68200k;
        e r119 = this.f67747i;
        String r120 = String.valueOf(r117);
        r118.getClass();
        Intrinsics.checkNotNullParameter(r119, "mOnMultiAnchorEffectLoadListener");
        Intrinsics.checkNotNullParameter(r120, "roomId");
        Intrinsics.checkNotNullParameter("", "anchorId");
        if (LiveEffectSettings.LIVE_ENABLE_MULTI_ANCHOR_EFFECT_SHARE.getValue().booleanValue() == false) goto L31;
        Long r121 = StringsKt.toLongOrNull(r120);
        if (r121 == null) goto L31;
        k r122 = new k(r119, r121.longValue(), "");
    L32:
        this.f67746h = r122;
    L31:
        r122 = null;
    L33:
        k r123 = this.f67746h;
        if (r123 == null) goto L44;
        k.f68200k.getClass();
        k.f68199j = 1;
        k.f68198i = true;
        if (LiveEffectSettings.LIVE_ENABLE_DEFAULT_MULTI_ANCHOR_EFFECT_SHARE.getValue().booleanValue() == false) goto L38;
        m90.b.f512566x.getValue().booleanValue();
    L39:
        List<String> r124 = LiveEffectContext.f66734h;
        Sticker r125 = (Sticker) CollectionsKt.getOrNull(LiveEffectContext.a.a(LiveEffectContextFactoryDelegate$Type.DEFAULT).a().o(d0.f66753c), 0);
        r123.f68203c.clear();
        if (k.f68198i == false) goto L45;
        r123.f68202b = null;
        r123.f68201a = ((AnchorEffectApi) com.bytedance.android.live.network.c.b().e(AnchorEffectApi.class)).getMultiAnchorEffect(r123.f68207g).observeOn(AndroidSchedulers.mainThread()).subscribe(new m(r123), new n(r123));
        return;
    L45:
        return;
    L38:
        m90.b.f512565w.getValue().booleanValue();
        goto L39
    L44:
        return;
    L5:
        r108 = null;
        goto L6
    }

    public LiveStickerBeautyFragment(LiveEffectContextFactoryDelegate$Type r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "type");
        Intrinsics.checkNotNullParameter(r101, "panelValue");
        Intrinsics.checkNotNullParameter(r102, "eventPage");
        this.f67749k = r100;
        this.f67750l = r101;
        this.f67751m = r102;
        this.f67752n = 0;
        this.f67742d = new LinkedHashMap();
        this.f67744f = LazyKt.lazy(new LiveStickerBeautyFragment$adapter$2(this));
        this.f67745g = new CompositeDisposable();
        this.f67747i = new e(this);
        this.f67748j = new com.bytedance.android.live.effect.beauty.sticker.a(this);
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r100, ViewGroup r101, Bundle r102) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        return r100.inflate(R.layout.ttlive_effect_dialog_beauty_sticker_layout, r101, false);
    }
}
