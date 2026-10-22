package com.bytedance.android.live.effect.common;

import android.content.Context;
import android.view.LayoutInflater;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.effect.api.LiveEffectScene;
import com.bytedance.android.live.effect.sticker.viewmodel.StickerBaseViewModel;
import com.bytedance.android.livesdkapi.depend.model.Sticker;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import io.reactivex.Completable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import java.lang.ref.WeakReference;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001R#\u0010\b\u001a\n \u0003*\u0004\u0018\u00010\u00020\u00028BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u001b\u0010\r\u001a\u00020\t8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u0005\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\u0011\u001a\u0004\u0018\u00010\u000e8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0015\u001a\u0004\u0018\u00010\u00128BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0019\u001a\u0004\u0018\u00010\u00168BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018¨\u0006\u001a"}, d2 = {"Lcom/bytedance/android/live/effect/common/LiveCommonStickerAdjustBarView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Landroidx/recyclerview/widget/RecyclerView;", "kotlin.jvm.PlatformType", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "Lkotlin/Lazy;", "getAdjustBarRecyclerView", "()Landroidx/recyclerview/widget/RecyclerView;", "adjustBarRecyclerView", "Lcom/bytedance/android/live/effect/common/AdjustBarListAdapter;", "d", "getAdjustBarListAdapter", "()Lcom/bytedance/android/live/effect/common/AdjustBarListAdapter;", "adjustBarListAdapter", "Lcom/bytedance/android/live/effect/common/LiveCommonStickerDataViewModel;", "getStickerDataViewModel", "()Lcom/bytedance/android/live/effect/common/LiveCommonStickerDataViewModel;", "stickerDataViewModel", "Lcom/bytedance/android/live/effect/common/LiveCommonStickerRenderViewModel;", "getStickerRenderViewModel", "()Lcom/bytedance/android/live/effect/common/LiveCommonStickerRenderViewModel;", "stickerRenderViewModel", "Lcom/bytedance/android/live/effect/common/LiveCommonStickerUIViewModel;", "getStickerUIViewModel", "()Lcom/bytedance/android/live/effect/common/LiveCommonStickerUIViewModel;", "stickerUIViewModel", "liveeffect_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveCommonStickerAdjustBarView extends ConstraintLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f67805a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final CompositeDisposable f67806b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final g f67807c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Lazy f67808d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f67809e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final LiveEffectScene f67810f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final WeakReference<LifecycleOwner> f67811g;

    private final AdjustBarListAdapter getAdjustBarListAdapter() {
        return (AdjustBarListAdapter) this.f67808d.getValue();
    }

    private final RecyclerView getAdjustBarRecyclerView() {
        return (RecyclerView) this.f67805a.getValue();
    }

    private final LiveCommonStickerDataViewModel getStickerDataViewModel() {
        StickerBaseViewModel.a r100 = StickerBaseViewModel.Companion;
        LiveEffectScene r101 = this.f67810f;
        String r102 = this.f67809e;
        r100.getClass();
        return (LiveCommonStickerDataViewModel) StickerBaseViewModel.a.b(r101, r102, LiveCommonStickerDataViewModel.class);
    }

    private final LiveCommonStickerRenderViewModel getStickerRenderViewModel() {
        StickerBaseViewModel.a r100 = StickerBaseViewModel.Companion;
        LiveEffectScene r101 = this.f67810f;
        String r102 = this.f67809e;
        r100.getClass();
        return (LiveCommonStickerRenderViewModel) StickerBaseViewModel.a.b(r101, r102, LiveCommonStickerRenderViewModel.class);
    }

    private final LiveCommonStickerUIViewModel getStickerUIViewModel() {
        StickerBaseViewModel.a r100 = StickerBaseViewModel.Companion;
        LiveEffectScene r101 = this.f67810f;
        String r102 = this.f67809e;
        r100.getClass();
        return (LiveCommonStickerUIViewModel) StickerBaseViewModel.a.b(r101, r102, LiveCommonStickerUIViewModel.class);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        LiveCommonStickerDataViewModel r100 = getStickerDataViewModel();
        if (r100 == null) goto L9;
        Completable r101 = r100.getOnCleared();
        if (r101 == null) goto L9;
        Disposable r102 = r101.subscribe(new i(this));
        if (r102 == null) goto L9;
        RxUtilKt.c(r102, this.f67806b);
    L9:
        LifecycleOwner r103 = this.f67811g.get();
        if (r103 == null) goto L16;
        LiveCommonStickerRenderViewModel r104 = getStickerRenderViewModel();
        if (r104 == null) goto L16;
        LiveData<Sticker> r105 = r104.getRenderStickerData();
        if (r105 == null) goto L16;
        r105.observe(r103, new h(this));
    L16:
        RecyclerView r106 = getAdjustBarRecyclerView();
        if (r106 == null) goto L20;
        final Context r107 = r106.getContext();
        r106.setLayoutManager(new LiveCommonStickerAdjustBarView$initView$1$1(r107));
        r106.setAdapter(getAdjustBarListAdapter());
        return;
    }

    public static final /* synthetic */ LiveCommonStickerRenderViewModel R5(LiveCommonStickerAdjustBarView r100) {
        return r100.getStickerRenderViewModel();
    }

    public LiveCommonStickerAdjustBarView(Context r100, WeakReference r101) {
        Intrinsics.checkNotNullParameter(r100, "mContext");
        Intrinsics.checkNotNullParameter("live_camera_move", "panel");
        Intrinsics.checkNotNullParameter(null, "scene");
        Intrinsics.checkNotNullParameter(null, "type");
        Intrinsics.checkNotNullParameter(r101, "lifecycleOwner");
        super(r100);
        this.f67809e = "live_camera_move";
        this.f67810f = null;
        this.f67811g = r101;
        LayoutInflater.from(getContext()).inflate(R.layout.ttlive_effect_sticker_adjust_bar_view, this, true);
        this.f67805a = LazyKt.lazy(new LiveCommonStickerAdjustBarView$adjustBarRecyclerView$2(this));
        this.f67806b = new CompositeDisposable();
        this.f67807c = new g(this);
        this.f67808d = LazyKt.lazy(new LiveCommonStickerAdjustBarView$adjustBarListAdapter$2(this));
    }

    public static final void S5(LiveCommonStickerAdjustBarView r100, Sticker r101) {
        AdjustBarListAdapter r102 = r100.getAdjustBarListAdapter();
        LiveCommonStickerRenderViewModel r103 = r100.getStickerRenderViewModel();
        if (r103 == null) goto L6;
        Map<String, Integer> r104 = r103.generateValueMapBySticker(r101);
        if (r104 == null) goto L6;
    L7:
        r102.getClass();
        Intrinsics.checkNotNullParameter(r104, "initValueMap");
        r102.f67801a = r101;
        ((LinkedHashMap) r102.f67802b).clear();
        r102.f67802b.putAll(r104);
        r102.notifyDataSetChanged();
        return;
    L6:
        r104 = MapsKt.emptyMap();
        goto L7
    }
}
