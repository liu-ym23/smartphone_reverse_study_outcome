package com.bytedance.android.live.effect.sticker.ui.stickerdialogv2;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.recyclerview.widget.RecyclerView;
import com.amap.api.col.s.ce;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.effect.api.LiveEffectContextFactoryDelegate$Type;
import com.bytedance.android.live.effect.api.LiveEffectScene;
import com.bytedance.android.live.effect.sticker.ui.RecommendKeywordView;
import com.bytedance.android.live.effect.sticker.ui.StickerSearchBox;
import com.bytedance.android.live.effect.sticker.viewmodel.StickerBaseViewModel;
import com.bytedance.android.live.effect.sticker.viewmodel.StickerDataViewModel;
import com.bytedance.android.live.effect.sticker.viewmodel.StickerDialogUIViewModel;
import com.bytedance.android.live.effect.sticker.viewmodel.StickerSearchViewModel;
import com.bytedance.android.live.uikit.recyclerview.LoadingStatusView;
import com.bytedance.android.livesdk.chatroom.ui.LiveDoubleColorBallAnimationView;
import com.bytedance.android.livesdk.chatroom.ui.SSGridLayoutManager;
import com.bytedance.android.livesdk.utils.t2;
import com.bytedance.android.livesdk.widget.FlowLayout;
import com.bytedance.android.livesdkapi.depend.model.Sticker;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.effectmanager.effect.model.Effect;
import com.ss.android.ugc.effectmanager.effect.model.SearchEffectModel;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
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
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0004B'\b\u0007\u0012\u0006\u0010.\u001a\u00020-\u0012\n\b\u0002\u00100\u001a\u0004\u0018\u00010/\u0012\b\b\u0002\u00102\u001a\u000201¢\u0006\u0004\b3\u00104R#\u0010\b\u001a\n \u0003*\u0004\u0018\u00010\u00020\u00028BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R#\u0010\r\u001a\n \u0003*\u0004\u0018\u00010\t0\t8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u0005\u001a\u0004\b\u000b\u0010\fR#\u0010\u0012\u001a\n \u0003*\u0004\u0018\u00010\u000e0\u000e8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\u0005\u001a\u0004\b\u0010\u0010\u0011R#\u0010\u0015\u001a\n \u0003*\u0004\u0018\u00010\u00020\u00028BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0013\u0010\u0005\u001a\u0004\b\u0014\u0010\u0007R#\u0010\u001a\u001a\n \u0003*\u0004\u0018\u00010\u00160\u00168BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0017\u0010\u0005\u001a\u0004\b\u0018\u0010\u0019R#\u0010\u001f\u001a\n \u0003*\u0004\u0018\u00010\u001b0\u001b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001c\u0010\u0005\u001a\u0004\b\u001d\u0010\u001eR#\u0010\"\u001a\n \u0003*\u0004\u0018\u00010\u001b0\u001b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b \u0010\u0005\u001a\u0004\b!\u0010\u001eR#\u0010'\u001a\n \u0003*\u0004\u0018\u00010#0#8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b$\u0010\u0005\u001a\u0004\b%\u0010&R#\u0010,\u001a\n \u0003*\u0004\u0018\u00010(0(8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b)\u0010\u0005\u001a\u0004\b*\u0010+¨\u00065"}, d2 = {"Lcom/bytedance/android/live/effect/sticker/ui/stickerdialogv2/StickerSearchPageView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Landroid/view/View;", "kotlin.jvm.PlatformType", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "Lkotlin/Lazy;", "getSearchBeyondView", "()Landroid/view/View;", "searchBeyondView", "Landroidx/recyclerview/widget/RecyclerView;", "b", "getStickerRecyclerView", "()Landroidx/recyclerview/widget/RecyclerView;", "stickerRecyclerView", "Lcom/bytedance/android/live/effect/sticker/ui/StickerSearchBox;", "c", "getSearchBox", "()Lcom/bytedance/android/live/effect/sticker/ui/StickerSearchBox;", "searchBox", "d", "getCancelButton", "cancelButton", "Lcom/bytedance/android/live/uikit/recyclerview/LoadingStatusView;", "e", "getLoading", "()Lcom/bytedance/android/live/uikit/recyclerview/LoadingStatusView;", "loading", "Landroid/widget/TextView;", "f", "getSearchEmptyTextView", "()Landroid/widget/TextView;", "searchEmptyTextView", ce.f26391f, "getSearchRecommendTextView", "searchRecommendTextView", "Lcom/bytedance/android/livesdk/widget/FlowLayout;", "h", "getRecommendKeywordContainer", "()Lcom/bytedance/android/livesdk/widget/FlowLayout;", "recommendKeywordContainer", "Landroid/widget/EditText;", RXScreenCaptureService.KEY_INDEX, "getEditText", "()Landroid/widget/EditText;", "editText", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "liveeffect_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class StickerSearchPageView extends ConstraintLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f68687a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f68688b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f68689c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Lazy f68690d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Lazy f68691e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Lazy f68692f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Lazy f68693g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Lazy f68694h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Lazy f68695i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public LiveEffectContextFactoryDelegate$Type f68696j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public LiveEffectScene f68697k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public String f68698l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public StickerDataViewModel f68699m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public StickerSearchViewModel f68700n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public StickerDialogUIViewModel f68701o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public LiveStickerDialogListAdapter f68702p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f68703q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f68704r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final CompositeDisposable f68705s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public WeakReference<LifecycleOwner> f68706t;

    public static final class a {
    }

    static {
    }

    public StickerSearchPageView(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public StickerSearchPageView(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    private final View getCancelButton() {
        return (View) this.f68690d.getValue();
    }

    private final EditText getEditText() {
        return (EditText) this.f68695i.getValue();
    }

    private final LoadingStatusView getLoading() {
        return (LoadingStatusView) this.f68691e.getValue();
    }

    private final FlowLayout getRecommendKeywordContainer() {
        return (FlowLayout) this.f68694h.getValue();
    }

    private final View getSearchBeyondView() {
        return (View) this.f68687a.getValue();
    }

    private final StickerSearchBox getSearchBox() {
        return (StickerSearchBox) this.f68689c.getValue();
    }

    private final TextView getSearchEmptyTextView() {
        return (TextView) this.f68692f.getValue();
    }

    private final TextView getSearchRecommendTextView() {
        return (TextView) this.f68693g.getValue();
    }

    private final RecyclerView getStickerRecyclerView() {
        return (RecyclerView) this.f68688b.getValue();
    }

    public final void I() {
        EditText r100 = getEditText();
        if (r100 == null) goto L5;
        r100.requestFocus();
    L5:
        t2.b(getContext(), getEditText());
        StickerSearchBox r101 = getSearchBox();
        if (r101 == null) goto L9;
        r101.U5(true);
        return;
    }

    public final void hideKeyboard() {
        EditText r100 = getEditText();
        if (r100 == null) goto L5;
        r100.clearFocus();
    L5:
        t2.a(getContext(), getEditText());
        StickerSearchBox r101 = getSearchBox();
        if (r101 == null) goto L9;
        r101.U5(false);
        return;
    }

    public static final /* synthetic */ LoadingStatusView R5(StickerSearchPageView r100) {
        return r100.getLoading();
    }

    public static final /* synthetic */ FlowLayout S5(StickerSearchPageView r100) {
        return r100.getRecommendKeywordContainer();
    }

    public static final /* synthetic */ StickerSearchBox T5(StickerSearchPageView r100) {
        return r100.getSearchBox();
    }

    public static final /* synthetic */ TextView U5(StickerSearchPageView r100) {
        return r100.getSearchEmptyTextView();
    }

    public static final /* synthetic */ TextView V5(StickerSearchPageView r100) {
        return r100.getSearchRecommendTextView();
    }

    public static final /* synthetic */ RecyclerView Y5(StickerSearchPageView r100) {
        return r100.getStickerRecyclerView();
    }

    public static final void c6(StickerSearchPageView r100) {
        LoadingStatusView r101 = r100.getLoading();
        if (r101 == null) goto L5;
        r101.showLoading();
    L5:
        StickerSearchBox r102 = r100.getSearchBox();
        if (r102 == null) goto L9;
        r102.Z5();
        return;
    }

    public static final void Z5(final StickerSearchPageView r100, com.bytedance.android.live.effect.sticker.p r101) {
        StickerSearchBox r102 = r100.getSearchBox();
        if (r102 == null) goto L5;
        r102.setSearchHint(r101.f68215c);
    L5:
        List<String> r103 = r101.f68214b;
        final LiveEffectScene r104 = r100.f68697k;
        FlowLayout r105 = r100.getRecommendKeywordContainer();
        if (r105 == null) goto L8;
        r105.removeAllViews();
    L8:
        Iterator<String> r106 = r103.iterator();
    L9:
        boolean r107 = true;
        if (r106.hasNext() == false) goto L23;
        final String r108 = r106.next();
        if (r100.getContext() == null) goto L9;
        if (r108.length() <= 0) goto L16;
        boolean r109 = true;
    L17:
        if (r109 == false) goto L9;
        if ((true ^ StringsKt.isBlank(r108)) == false) goto L9;
        Context r110 = r100.getContext();
        Intrinsics.checkNotNull(r110);
        RecommendKeywordView r111 = new RecommendKeywordView(r110, null, 6, 0);
        r111.setKeyword(r108);
        r111.setOnClick(new StickerSearchPageView$setRecommendKeyword$$inlined$apply$lambda$1(r100, r108, r104));
        FlowLayout r112 = r100.getRecommendKeywordContainer();
        if (r112 == null) goto L9;
        r112.addView(r111);
        goto L9
    L16:
        r109 = false;
        goto L17
    L23:
        TextView r113 = r100.getSearchEmptyTextView();
        if (r113 == null) goto L44;
        String r114 = r101.f68213a;
        if (r114.length() == 0) goto L29;
        r107 = false;
    L29:
        if (r107 == false) goto L31;
        r114 = s1.B(R.string.ttlive_effect_sticker_search_empty_result);
    L31:
        r113.setText(r114);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void b6(StickerSearchPageView r100, com.bytedance.android.live.effect.sticker.viewmodel.a r101) {
        r100.getClass();
        if ((r101 instanceof com.bytedance.android.live.effect.sticker.viewmodel.a.C1121a) == false) goto L8;
        LoadingStatusView r102 = r100.getLoading();
        if (r102 == null) goto L74;
        r102.showError();
        return;
    L74:
        return;
    L8:
        if ((r101 instanceof com.bytedance.android.live.effect.sticker.viewmodel.a.b) == false) goto L76;
        TextView r103 = r100.getSearchRecommendTextView();
        if (r103 != null) goto L12;
        return;
    L12:
        if (r103.getVisibility() != 4) goto L78;
        com.bytedance.android.live.effect.sticker.viewmodel.a.b r104 = (com.bytedance.android.live.effect.sticker.viewmodel.a.b) r101;
        StickerSearchViewModel.b r105 = (StickerSearchViewModel.b) r104.f68819b;
        if (r105 != null) goto L16;
        return;
    L16:
        if (r105.f68811c == r100.f68704r) goto L18;
        return;
    L18:
        if (Intrinsics.areEqual(((SearchEffectModel) r104.f68818a).getUse_hot(), Boolean.TRUE) == true) goto L20;
        LiveStickerDialogListAdapter r106 = r100.f68702p;
        if (r106 == null) goto L62;
        List<Effect> r107 = ((SearchEffectModel) r104.f68818a).getEffectList();
        if (r107 != null) goto L57;
        r107 = CollectionsKt.emptyList();
    L57:
        List<Effect> r108 = r107;
        ArrayList r109 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r108, 10));
        Iterator<T> r110 = r108.iterator();
    L59:
        if (r110.hasNext() == false) goto L61;
        r109.add(com.bytedance.android.live.effect.sticker.d.d((Effect) r110.next(), r100.f68698l));
        goto L59
    L61:
        r106.y2(r109);
    L62:
        LoadingStatusView r111 = r100.getLoading();
        if (r111 == null) goto L65;
        r111.reset();
    L65:
        RecyclerView r112 = r100.getStickerRecyclerView();
        if (r112 == null) goto L68;
        r112.scrollToPosition(0);
    L68:
        RecyclerView r113 = r100.getStickerRecyclerView();
        if (r113 == null) goto L85;
        r113.setVisibility(0);
        return;
    L85:
        return;
    L20:
        if (((StickerSearchViewModel.b) r104.f68819b).f68810b == false) goto L43;
        LiveStickerDialogListAdapter r114 = r100.f68702p;
        if (r114 == null) goto L31;
        List<Effect> r115 = ((SearchEffectModel) r104.f68818a).getEffectList();
        if (r115 != null) goto L26;
        r115 = CollectionsKt.emptyList();
    L26:
        List<Effect> r116 = r115;
        ArrayList r117 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r116, 10));
        Iterator<T> r118 = r116.iterator();
    L28:
        if (r118.hasNext() == false) goto L30;
        r117.add(com.bytedance.android.live.effect.sticker.d.d((Effect) r118.next(), r100.f68698l));
        goto L28
    L30:
        r114.y2(r117);
    L31:
        LoadingStatusView r119 = r100.getLoading();
        if (r119 == null) goto L34;
        r119.reset();
    L34:
        RecyclerView r120 = r100.getStickerRecyclerView();
        if (r120 == null) goto L37;
        r120.scrollToPosition(0);
    L37:
        RecyclerView r121 = r100.getStickerRecyclerView();
        if (r121 == null) goto L40;
        r121.setVisibility(0);
    L40:
        TextView r122 = r100.getSearchEmptyTextView();
        if (r122 == null) goto L81;
        r122.setVisibility(0);
        return;
    L81:
        return;
    L43:
        LiveStickerDialogListAdapter r123 = r100.f68702p;
        if (r123 == null) goto L46;
        r123.y2(CollectionsKt.emptyList());
    L46:
        LoadingStatusView r124 = r100.getLoading();
        if (r124 == null) goto L49;
        r124.reset();
    L49:
        RecyclerView r125 = r100.getStickerRecyclerView();
        if (r125 == null) goto L83;
        r125.setVisibility(0);
        return;
    L83:
        return;
    L78:
        return;
    }

    public StickerSearchPageView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f68687a = LazyKt.lazy(new StickerSearchPageView$searchBeyondView$2(this));
        this.f68688b = LazyKt.lazy(new StickerSearchPageView$stickerRecyclerView$2(this));
        this.f68689c = LazyKt.lazy(new StickerSearchPageView$searchBox$2(this));
        this.f68690d = LazyKt.lazy(new StickerSearchPageView$cancelButton$2(this));
        this.f68691e = LazyKt.lazy(new StickerSearchPageView$loading$2(this));
        this.f68692f = LazyKt.lazy(new StickerSearchPageView$searchEmptyTextView$2(this));
        this.f68693g = LazyKt.lazy(new StickerSearchPageView$searchRecommendTextView$2(this));
        this.f68694h = LazyKt.lazy(new StickerSearchPageView$recommendKeywordContainer$2(this));
        this.f68695i = LazyKt.lazy(new StickerSearchPageView$editText$2(this));
        this.f68696j = LiveEffectContextFactoryDelegate$Type.DEFAULT;
        this.f68697k = LiveEffectScene.Live;
        this.f68698l = com.bytedance.android.live.effect.api.d0.f66753c;
        this.f68705s = new CompositeDisposable();
        this.f68706t = new WeakReference(null);
        ViewGroup.inflate(r100, R.layout.ttlive_effect_sticker_search_page_view, this);
    }

    public /* synthetic */ StickerSearchPageView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }

    public static void i6(final StickerSearchPageView r100, LiveEffectContextFactoryDelegate$Type r101, LiveEffectScene r102, LifecycleOwner r103) {
        String r104 = com.bytedance.android.live.effect.api.d0.f66753c;
        Intrinsics.checkNotNullParameter(r101, "type");
        Intrinsics.checkNotNullParameter(r102, "scene");
        Intrinsics.checkNotNullParameter(r104, "panel");
        r100.f68696j = r101;
        r100.f68697k = r102;
        r100.f68698l = r104;
        r100.f68706t.clear();
        r100.f68706t = new WeakReference(r103);
        StickerBaseViewModel.a r105 = StickerBaseViewModel.Companion;
        LiveEffectScene r106 = r100.f68697k;
        r105.getClass();
        r100.f68699m = (StickerDataViewModel) StickerBaseViewModel.a.a(r106, StickerDataViewModel.class);
        r100.f68700n = (StickerSearchViewModel) StickerBaseViewModel.a.a(r100.f68697k, StickerSearchViewModel.class);
        r100.f68701o = (StickerDialogUIViewModel) StickerBaseViewModel.a.a(r100.f68697k, StickerDialogUIViewModel.class);
        StickerDataViewModel r107 = r100.f68699m;
        if (r107 == null) goto L9;
        Completable r108 = r107.getOnCleared();
        if (r108 == null) goto L9;
        Disposable r109 = r108.subscribe(new p0(r100));
        if (r109 == null) goto L9;
        RxUtilKt.c(r109, r100.f68705s);
    L9:
        StickerDialogUIViewModel r110 = r100.f68701o;
        if (r110 == null) goto L18;
        com.bytedance.live.datacontext.k<Sticker> r111 = r110.getStickerDownloadCompleteEvent();
        if (r111 == null) goto L18;
        PublishSubject r112 = r111.onEvent();
        if (r112 == null) goto L18;
        Disposable r113 = r112.subscribe(new q0(r100));
        if (r113 == null) goto L18;
        RxUtilKt.c(r113, r100.f68705s);
    L18:
        StickerDialogUIViewModel r114 = r100.f68701o;
        if (r114 == null) goto L27;
        com.bytedance.live.datacontext.k<Sticker> r115 = r114.getStickerDownloadStartEvent();
        if (r115 == null) goto L27;
        PublishSubject r116 = r115.onEvent();
        if (r116 == null) goto L27;
        Disposable r117 = r116.subscribe(new r0(r100));
        if (r117 == null) goto L27;
        RxUtilKt.c(r117, r100.f68705s);
    L27:
        LifecycleOwner r118 = r100.f68706t.get();
        if (r118 == null) goto L39;
        StickerDialogUIViewModel r119 = r100.f68701o;
        if (r119 == null) goto L34;
        LiveData<Sticker> r120 = r119.getCurrentSelectStickerData();
        if (r120 == null) goto L34;
        r120.observe(r118, new n0(r100));
    L34:
        StickerSearchViewModel r121 = r100.f68700n;
        if (r121 == null) goto L39;
        LiveData<com.bytedance.android.live.effect.sticker.viewmodel.a<SearchEffectModel, StickerSearchViewModel.b>> r122 = r121.getStickerSearchResultData();
        if (r122 == null) goto L39;
        r122.observe(r118, new o0(r100));
    L39:
        StickerDataViewModel r123 = r100.f68699m;
        if (r123 == null) goto L46;
        com.bytedance.live.datacontext.m<com.bytedance.android.live.effect.sticker.p> r124 = r123.getPanelExtraInfo();
        if (r124 == null) goto L46;
        Disposable r125 = com.bytedance.android.live.effect.sticker.viewmodel.d.a(r124, new StickerSearchPageView$registerLiveData$5(r100));
        if (r125 == null) goto L46;
        RxUtilKt.c(r125, r100.f68705s);
    L46:
        StickerSearchViewModel r126 = r100.f68700n;
        if (r126 == null) goto L55;
        com.bytedance.live.datacontext.k<Unit> r127 = r126.getTabViewClearContentEvent();
        if (r127 == null) goto L55;
        PublishSubject r128 = r127.onEvent();
        if (r128 == null) goto L55;
        Disposable r129 = r128.subscribe(new s0(r100));
        if (r129 == null) goto L55;
        RxUtilKt.c(r129, r100.f68705s);
    L55:
        StickerSearchViewModel r130 = r100.f68700n;
        if (r130 == null) goto L64;
        com.bytedance.live.datacontext.k<Unit> r131 = r130.getTabViewCoverClickEvent();
        if (r131 == null) goto L64;
        PublishSubject r132 = r131.onEvent();
        if (r132 == null) goto L64;
        Disposable r133 = r132.subscribe(new t0(r100));
        if (r133 == null) goto L64;
        RxUtilKt.c(r133, r100.f68705s);
    L64:
        StickerSearchViewModel r134 = r100.f68700n;
        if (r134 == null) goto L73;
        com.bytedance.live.datacontext.k<Unit> r135 = r134.getTabViewSearchFailEvent();
        if (r135 == null) goto L73;
        PublishSubject r136 = r135.onEvent();
        if (r136 == null) goto L73;
        Disposable r137 = r136.subscribe(new u0(r100));
        if (r137 == null) goto L73;
        RxUtilKt.c(r137, r100.f68705s);
    L73:
        StickerSearchViewModel r138 = r100.f68700n;
        if (r138 == null) goto L82;
        com.bytedance.live.datacontext.k<String> r139 = r138.getTabViewKeywordClickEvent();
        if (r139 == null) goto L82;
        PublishSubject r140 = r139.onEvent();
        if (r140 == null) goto L82;
        Disposable r141 = r140.subscribe(new v0(r100));
        if (r141 == null) goto L82;
        RxUtilKt.c(r141, r100.f68705s);
    L82:
        r100.f68702p = new LiveStickerDialogListAdapter(r100.f68696j, r100.f68697k, "search_0", "", new WeakReference(r100.getStickerRecyclerView()));
        View r142 = r100.getSearchBeyondView();
        if (r142 == null) goto L85;
        r142.setOnClickListener(new j0(r100));
    L85:
        RecyclerView r143 = r100.getStickerRecyclerView();
        if (r143 == null) goto L88;
        r143.setAdapter(r100.f68702p);
        r143.setLayoutManager(new SSGridLayoutManager(r143.getContext(), 5, 1));
        r143.setOnTouchListener(new h0(r143, r100));
    L88:
        View r144 = r100.getCancelButton();
        if (r144 == null) goto L91;
        r144.setOnClickListener(new k0(r100));
    L91:
        LoadingStatusView r145 = r100.getLoading();
        if (r145 == null) goto L97;
        LoadingStatusView.Builder r146 = LoadingStatusView.Builder.createDefaultBuilder(r100.getContext());
        LiveDoubleColorBallAnimationView r147 = null;
        View r148 = LayoutInflater.from(r100.getContext()).inflate(R.layout.ttlive_effect_view_panel_loading_error_view, null, false);
        r148.setOnClickListener(new i0(r100));
        Unit r149 = Unit.INSTANCE;
        LoadingStatusView.Builder r150 = r146.setErrorView(r148);
        Context r151 = r100.getContext();
        if (r151 == null) goto L96;
        r147 = new LiveDoubleColorBallAnimationView(r151);
        int r152 = r147.getResources().getDimensionPixelSize(R.dimen.ttlive_effect_default_list_progressbar_size);
        FrameLayout.LayoutParams r153 = new FrameLayout.LayoutParams(r152, r152);
        r153.gravity = 17;
        r147.setLayoutParams(r153);
    L96:
        r145.setBuilder(r150.setLoadingView(r147));
    L97:
        FlowLayout r154 = r100.getRecommendKeywordContainer();
        if (r154 == null) goto L100;
        r154.setItemSpacing(UtilityKotlinExtentionsKt.i(12));
        r154.setLineSpacing(UtilityKotlinExtentionsKt.i(12));
    L100:
        StickerSearchBox r155 = r100.getSearchBox();
        if (r155 == null) goto L103;
        r155.setEditTextOnKeyListener(new l0(r100));
    L103:
        StickerSearchBox r156 = r100.getSearchBox();
        if (r156 == null) goto L107;
        r156.setOnChangeListener(new m0(r100));
        return;
    }
}
