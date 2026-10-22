package com.bytedance.android.live.effect.common;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.effect.api.LiveEffectContextFactoryDelegate$Type;
import com.bytedance.android.live.effect.api.LiveEffectScene;
import com.bytedance.android.live.effect.sticker.ui.stickerdialogv2.StickerLoadingStatus;
import com.bytedance.android.live.effect.sticker.viewmodel.StickerBaseViewModel;
import com.bytedance.android.live.uikit.recyclerview.LoadingStatusView;
import com.bytedance.android.livesdk.chatroom.ui.LiveDoubleColorBallAnimationView;
import com.bytedance.android.livesdkapi.depend.model.Sticker;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import io.reactivex.Completable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.subjects.PublishSubject;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000?\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u000e\u0018\u00002\u00020\u0001R#\u0010\b\u001a\n \u0003*\u0004\u0018\u00010\u00020\u00028BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R#\u0010\r\u001a\n \u0003*\u0004\u0018\u00010\t0\t8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u0005\u001a\u0004\b\u000b\u0010\fR\u001b\u0010\u0012\u001a\u00020\u000e8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\u0005\u001a\u0004\b\u0010\u0010\u0011R\u001b\u0010\u0017\u001a\u00020\u00138BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\u0005\u001a\u0004\b\u0015\u0010\u0016R\u0016\u0010\u001b\u001a\u0004\u0018\u00010\u00188BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001f\u001a\u0004\u0018\u00010\u001c8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001eR\u0016\u0010#\u001a\u0004\u0018\u00010 8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b!\u0010\"¨\u0006$"}, d2 = {"Lcom/bytedance/android/live/effect/common/LiveCommonStickerListView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Lcom/bytedance/android/live/uikit/recyclerview/LoadingStatusView;", "kotlin.jvm.PlatformType", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "Lkotlin/Lazy;", "getLoadingView", "()Lcom/bytedance/android/live/uikit/recyclerview/LoadingStatusView;", "loadingView", "Landroidx/recyclerview/widget/RecyclerView;", "b", "getRecyclerView", "()Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "com/bytedance/android/live/effect/common/LiveCommonStickerListView$stickerListAdapterListener$2$a", "d", "getStickerListAdapterListener", "()Lcom/bytedance/android/live/effect/common/LiveCommonStickerListView$stickerListAdapterListener$2$a;", "stickerListAdapterListener", "Lcom/bytedance/android/live/effect/common/LiveCommonStickerListAdapter;", "e", "getStickerListAdapter", "()Lcom/bytedance/android/live/effect/common/LiveCommonStickerListAdapter;", "stickerListAdapter", "Lcom/bytedance/android/live/effect/common/LiveCommonStickerDataViewModel;", "getStickerDataViewModel", "()Lcom/bytedance/android/live/effect/common/LiveCommonStickerDataViewModel;", "stickerDataViewModel", "Lcom/bytedance/android/live/effect/common/LiveCommonStickerRenderViewModel;", "getStickerRenderViewModel", "()Lcom/bytedance/android/live/effect/common/LiveCommonStickerRenderViewModel;", "stickerRenderViewModel", "Lcom/bytedance/android/live/effect/common/LiveCommonStickerUIViewModel;", "getStickerUIViewModel", "()Lcom/bytedance/android/live/effect/common/LiveCommonStickerUIViewModel;", "stickerUIViewModel", "liveeffect_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveCommonStickerListView extends ConstraintLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f67833a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f67834b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final CompositeDisposable f67835c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Lazy f67836d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Lazy f67837e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f67838f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final LiveEffectScene f67839g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final LiveEffectContextFactoryDelegate$Type f67840h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final WeakReference<LifecycleOwner> f67841i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final o f67842j;

    public LiveCommonStickerListView() {
        throw null;
    }

    private final LoadingStatusView getLoadingView() {
        return (LoadingStatusView) this.f67833a.getValue();
    }

    private final RecyclerView getRecyclerView() {
        return (RecyclerView) this.f67834b.getValue();
    }

    private final LiveCommonStickerListAdapter getStickerListAdapter() {
        return (LiveCommonStickerListAdapter) this.f67837e.getValue();
    }

    private final LiveCommonStickerListView$stickerListAdapterListener$2.a getStickerListAdapterListener() {
        return (LiveCommonStickerListView$stickerListAdapterListener$2.a) this.f67836d.getValue();
    }

    private final LiveCommonStickerDataViewModel getStickerDataViewModel() {
        StickerBaseViewModel.a r100 = StickerBaseViewModel.Companion;
        LiveEffectScene r101 = this.f67839g;
        String r102 = this.f67838f;
        r100.getClass();
        return (LiveCommonStickerDataViewModel) StickerBaseViewModel.a.b(r101, r102, LiveCommonStickerDataViewModel.class);
    }

    private final LiveCommonStickerRenderViewModel getStickerRenderViewModel() {
        StickerBaseViewModel.a r100 = StickerBaseViewModel.Companion;
        LiveEffectScene r101 = this.f67839g;
        String r102 = this.f67838f;
        r100.getClass();
        return (LiveCommonStickerRenderViewModel) StickerBaseViewModel.a.b(r101, r102, LiveCommonStickerRenderViewModel.class);
    }

    private final LiveCommonStickerUIViewModel getStickerUIViewModel() {
        StickerBaseViewModel.a r100 = StickerBaseViewModel.Companion;
        LiveEffectScene r101 = this.f67839g;
        String r102 = this.f67838f;
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
        Disposable r102 = r101.subscribe(new v(this));
        if (r102 == null) goto L9;
        RxUtilKt.c(r102, this.f67835c);
    L9:
        LifecycleOwner r103 = this.f67841i.get();
        if (r103 == null) goto L31;
        LiveCommonStickerDataViewModel r104 = getStickerDataViewModel();
        if (r104 == null) goto L16;
        com.bytedance.android.live.effect.sticker.viewmodel.c<String, List<Sticker>> r105 = r104.getStickerListMap();
        if (r105 == null) goto L16;
        r105.b(this.f67838f, r103, new r(this));
    L16:
        LiveCommonStickerDataViewModel r106 = getStickerDataViewModel();
        if (r106 == null) goto L21;
        com.bytedance.android.live.effect.sticker.viewmodel.c<String, StickerLoadingStatus> r107 = r106.getStickerListLoadingStatusMap();
        if (r107 == null) goto L21;
        r107.b(this.f67838f, r103, new s(this));
    L21:
        LiveCommonStickerRenderViewModel r108 = getStickerRenderViewModel();
        if (r108 == null) goto L26;
        LiveData<Sticker> r109 = r108.getRenderStickerData();
        if (r109 == null) goto L26;
        r109.observe(r103, new t(this));
    L26:
        LiveCommonStickerUIViewModel r110 = getStickerUIViewModel();
        if (r110 == null) goto L31;
        LiveData<Boolean> r111 = r110.getRepelStatus();
        if (r111 == null) goto L31;
        r111.observe(r103, new u(this));
    L31:
        LiveCommonStickerUIViewModel r112 = getStickerUIViewModel();
        if (r112 == null) goto L34;
        r112.startObserveRepelStatus();
    L34:
        LiveCommonStickerUIViewModel r113 = getStickerUIViewModel();
        if (r113 == null) goto L43;
        com.bytedance.live.datacontext.k<Sticker> r114 = r113.getStickerDownloadStartEvent();
        if (r114 == null) goto L43;
        PublishSubject r115 = r114.onEvent();
        if (r115 == null) goto L43;
        Disposable r116 = r115.subscribe(new w(this));
        if (r116 == null) goto L43;
        RxUtilKt.c(r116, this.f67835c);
    L43:
        LiveCommonStickerUIViewModel r117 = getStickerUIViewModel();
        if (r117 == null) goto L52;
        com.bytedance.live.datacontext.k<Sticker> r118 = r117.getStickerDownloadCompleteEvent();
        if (r118 == null) goto L52;
        PublishSubject r119 = r118.onEvent();
        if (r119 == null) goto L52;
        Disposable r120 = r119.subscribe(new x(this));
        if (r120 == null) goto L52;
        RxUtilKt.c(r120, this.f67835c);
    L52:
        LoadingStatusView r121 = getLoadingView();
        if (r121 == null) goto L58;
        LoadingStatusView.Builder r122 = LoadingStatusView.Builder.createDefaultBuilder(getContext());
        LiveDoubleColorBallAnimationView r123 = null;
        View r124 = LayoutInflater.from(getContext()).inflate(R.layout.ttlive_effect_view_panel_loading_error_view, null, false);
        r124.setOnClickListener(new q(this));
        Unit r125 = Unit.INSTANCE;
        LoadingStatusView.Builder r126 = r122.setErrorView(r124);
        Context r127 = getContext();
        if (r127 == null) goto L57;
        r123 = new LiveDoubleColorBallAnimationView(r127);
        int r128 = r123.getResources().getDimensionPixelSize(R.dimen.ttlive_effect_default_list_progressbar_size);
        FrameLayout.LayoutParams r129 = new FrameLayout.LayoutParams(r128, r128);
        r129.gravity = 17;
        r123.setLayoutParams(r129);
    L57:
        r121.setBuilder(r126.setLoadingView(r123));
    L58:
        RecyclerView r130 = getRecyclerView();
        if (r130 == null) goto L61;
        r130.setAdapter(getStickerListAdapter());
    L61:
        RecyclerView r131 = getRecyclerView();
        if (r131 == null) goto L64;
        r131.setLayoutManager(new LinearLayoutManager(getContext(), 0, false));
    L64:
        RecyclerView.ItemDecoration r132 = this.f67842j.f67869b;
        if (r132 == null) goto L69;
        RecyclerView r133 = getRecyclerView();
        if (r133 == null) goto L69;
        r133.addItemDecoration(r132);
    L69:
        LiveCommonStickerDataViewModel r134 = getStickerDataViewModel();
        if (r134 == null) goto L73;
        r134.fetchStickerList(this.f67838f);
        return;
    }

    public static final /* synthetic */ RecyclerView R5(LiveCommonStickerListView r100) {
        return r100.getRecyclerView();
    }

    public static final /* synthetic */ LiveCommonStickerDataViewModel S5(LiveCommonStickerListView r100) {
        return r100.getStickerDataViewModel();
    }

    public static final /* synthetic */ LiveCommonStickerListAdapter T5(LiveCommonStickerListView r100) {
        return r100.getStickerListAdapter();
    }

    public static final /* synthetic */ LiveCommonStickerListView$stickerListAdapterListener$2.a U5(LiveCommonStickerListView r100) {
        return r100.getStickerListAdapterListener();
    }

    public static final /* synthetic */ LiveCommonStickerRenderViewModel V5(LiveCommonStickerListView r100) {
        return r100.getStickerRenderViewModel();
    }

    public static final /* synthetic */ LiveCommonStickerUIViewModel Y5(LiveCommonStickerListView r100) {
        return r100.getStickerUIViewModel();
    }

    public static final void b6(LiveCommonStickerListView r100) {
        LiveCommonStickerListAdapter r101 = r100.getStickerListAdapter();
        Sticker r102 = r101.f67824k.d();
        if (r102 == null) goto L5;
        long r103 = r102.getId();
    L6:
        long r104 = r101.f67818e;
        r101.f67818e = r103;
        List<Long> r105 = r101.f67817d;
        ArrayList r106 = (ArrayList) r105;
        int r107 = r106.indexOf(Long.valueOf(r103));
        if (r102 == null) goto L12;
        if (r107 < 0) goto L12;
        if (r107 >= ((ArrayList) r101.f67816c).size()) goto L12;
        ListProtector.set(r101.f67816c, r107, r102);
    L12:
        List<Long> r108 = r101.f67817d;
        ArrayList r109 = (ArrayList) r108;
        if (r109.contains(Long.valueOf(r104)) == true) goto L15;
    L17:
        List<Long> r110 = r101.f67817d;
        ArrayList r111 = (ArrayList) r110;
        if (r111.contains(Long.valueOf(r101.f67818e)) == true) goto L20;
        return;
    L20:
        if (r104 == r101.f67818e) goto L24;
        r101.notifyItemChanged(r107, WsConstants.KEY_PAYLOAD);
        return;
    L24:
        return;
    L15:
        if (r104 == r101.f67818e) goto L17;
        List<Long> r112 = r101.f67817d;
        ArrayList r113 = (ArrayList) r112;
        r101.notifyItemChanged(r113.indexOf(Long.valueOf(r104)), WsConstants.KEY_PAYLOAD);
        goto L17
    L5:
        r103 = 0;
        goto L6
    }

    public LiveCommonStickerListView(Context r100, WeakReference r101) {
        o r102 = new o(new j(), 2);
        Intrinsics.checkNotNullParameter(r100, "mContext");
        Intrinsics.checkNotNullParameter("live_camera_move", "panel");
        Intrinsics.checkNotNullParameter(null, "scene");
        Intrinsics.checkNotNullParameter(null, "type");
        Intrinsics.checkNotNullParameter(r101, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(r102, "styleConfig");
        super(r100);
        this.f67838f = "live_camera_move";
        this.f67839g = null;
        this.f67840h = null;
        this.f67841i = r101;
        this.f67842j = r102;
        LayoutInflater.from(getContext()).inflate(R.layout.ttlive_effect_sticker_list_view, this, true);
        this.f67833a = LazyKt.lazy(new LiveCommonStickerListView$loadingView$2(this));
        this.f67834b = LazyKt.lazy(new LiveCommonStickerListView$recyclerView$2(this));
        this.f67835c = new CompositeDisposable();
        this.f67836d = LazyKt.lazy(new LiveCommonStickerListView$stickerListAdapterListener$2(this));
        this.f67837e = LazyKt.lazy(new LiveCommonStickerListView$stickerListAdapter$2(this));
    }

    public static final void Z5(LiveCommonStickerListView r100, StickerLoadingStatus r101) {
        r100.getClass();
        int r102 = p.f67870a[r101.ordinal()];
        if (r102 != 1) goto L5;
        LoadingStatusView r103 = r100.getLoadingView();
        if (r103 == null) goto L23;
        r103.showLoading();
        return;
    L23:
        return;
    L5:
        if (r102 != 2) goto L7;
        LoadingStatusView r104 = r100.getLoadingView();
        if (r104 == null) goto L21;
        r104.showError();
        return;
    L21:
        return;
    L7:
        if (r102 != 3) goto L24;
        LoadingStatusView r105 = r100.getLoadingView();
        if (r105 == null) goto L19;
        r105.reset();
        return;
    L19:
        return;
    }

    public static final void c6(LiveCommonStickerListView r100, List r101) {
        LiveCommonStickerListAdapter r102 = r100.getStickerListAdapter();
        r102.getClass();
        Intrinsics.checkNotNullParameter(r101, "data");
        Sticker r103 = r102.f67824k.d();
        if (r103 == null) goto L5;
        long r104 = r103.getId();
    L6:
        r102.f67818e = r104;
        ((ArrayList) r102.f67816c).clear();
        ArrayList r105 = (ArrayList) r102.f67816c;
        r105.addAll(r101);
        ((ArrayList) r102.f67817d).clear();
        List<Long> r106 = r102.f67817d;
        List<Sticker> r107 = r102.f67816c;
        ArrayList r108 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r107, 10));
        Iterator r109 = ((ArrayList) r107).iterator();
    L8:
        if (r109.hasNext() == false) goto L10;
        r108.add(Long.valueOf(((Sticker) r109.next()).getId()));
        goto L8
    L10:
        ((ArrayList) r106).addAll(r108);
        r102.notifyDataSetChanged();
        return;
    L5:
        r104 = 0;
        goto L6
    }
}
