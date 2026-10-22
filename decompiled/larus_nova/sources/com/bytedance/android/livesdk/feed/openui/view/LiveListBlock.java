package com.bytedance.android.livesdk.feed.openui.view;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleRegistry;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.core.network.NetworkStat;
import com.bytedance.android.live.core.utils.LiveResUtil;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.g0;
import com.bytedance.android.livesdk.feed.adapter.FeedLiveAdapter;
import com.bytedance.android.livesdk.feed.openui.vm.FeedListViewModel;
import com.bytedance.android.livesdk.feed.ui.OpenItemDecoration;
import com.bytedance.android.livesdk.utils.LifecycleOwnerCompat;
import com.bytedance.android.livesdkapi.feed.constant.FeedStyle;
import com.bytedance.android.livesdkapi.feed.constant.FeedType;
import com.bytedance.android.livesdkapi.feed.model.OpenFeedParams;
import com.bytedance.android.livesdkapi.feed.ui.ILiveBlock;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import mv1.l;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\n\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002J\b\u0010\t\u001a\u00020\bH\u0016R\u001a\u0010\u000f\u001a\u00020\n8\u0006X\u0086D¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u001b\u0010\u0015\u001a\u00020\u00108BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u001b\u0010\u001a\u001a\u00020\u00168BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0017\u0010\u0012\u001a\u0004\b\u0018\u0010\u0019R\u001b\u0010\u001f\u001a\u00020\u001b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001c\u0010\u0012\u001a\u0004\b\u001d\u0010\u001e¨\u0006 "}, d2 = {"Lcom/bytedance/android/livesdk/feed/openui/view/LiveListBlock;", "Landroid/widget/FrameLayout;", "Lcom/bytedance/android/livesdk/utils/LifecycleOwnerCompat;", "Lcom/bytedance/android/livesdkapi/feed/ui/ILiveBlock;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "getItemDecoration", "Landroidx/recyclerview/widget/RecyclerView$LayoutManager;", "getLayoutManager", "Landroidx/lifecycle/Lifecycle;", "getLifecycleCompat", "", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "I", "getDefaultBg", "()I", "defaultBg", "Landroidx/lifecycle/LifecycleRegistry;", "b", "Lkotlin/Lazy;", "getLifecycleRegistry", "()Landroidx/lifecycle/LifecycleRegistry;", "lifecycleRegistry", "Lcom/bytedance/android/livesdk/feed/openui/vm/FeedListViewModel;", "c", "getFeedViewModel", "()Lcom/bytedance/android/livesdk/feed/openui/vm/FeedListViewModel;", "feedViewModel", "Lcom/bytedance/android/livesdk/feed/adapter/FeedLiveAdapter;", "f", "getAdapter", "()Lcom/bytedance/android/livesdk/feed/adapter/FeedLiveAdapter;", "adapter", "saasfeed_release"}, k = 1, mv = {1, 4, 3})
public final class LiveListBlock extends FrameLayout implements LifecycleOwnerCompat, ILiveBlock {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f124238a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f124239b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f124240c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final f f124241d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final MutableLiveData<Boolean> f124242e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Lazy f124243f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final OpenFeedParams f124244g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public HashMap f124245h;

    public static final class a<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LiveListBlock f124246a;

        public a(LiveListBlock r100) {
            this.f124246a = r100;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r100) {
            NetworkStat r101 = (NetworkStat) r100;
            if (r101 == null) goto L5;
            NetworkStat.Status r102 = r101.mStatus;
        L7:
            if (r102 != NetworkStat.Status.FAILED) goto L9;
            this.f124246a.f124242e.postValue(Boolean.TRUE);
            f2.b(R.string.ttlive_feed_empty, 0);
            return;
        L9:
            this.f124246a.f124242e.postValue(Boolean.FALSE);
            return;
        L5:
            r102 = null;
            goto L7
        }
    }

    private final FeedLiveAdapter getAdapter() {
        return (FeedLiveAdapter) this.f124243f.getValue();
    }

    private final FeedListViewModel getFeedViewModel() {
        return (FeedListViewModel) this.f124240c.getValue();
    }

    private final LifecycleRegistry getLifecycleRegistry() {
        return (LifecycleRegistry) this.f124239b.getValue();
    }

    public final View a(int r100) {
        if (this.f124245h != null) goto L5;
        this.f124245h = new HashMap();
    L5:
        View r101 = (View) this.f124245h.get(Integer.valueOf(r100));
        if (r101 != null) goto L9;
        View r102 = findViewById(r100);
        this.f124245h.put(Integer.valueOf(r100), r102);
        return r102;
    L9:
        return r101;
    }

    @Override // androidx.lifecycle.LifecycleOwner
    public /* bridge */ /* synthetic */ Lifecycle getLifecycle() {
        return LifecycleOwnerCompat.CC.$default$getLifecycle(this);
    }

    private final RecyclerView.ItemDecoration getItemDecoration() {
        FeedStyle r100 = this.f124244g.getFeedStyle();
        if (r100 != null) goto L5;
        r100 = FeedStyle.DOUBLE_LIST_D;
    L5:
        int r101 = this.f124244g.getFeedItemDecorationHorizontal();
        int r102 = this.f124244g.getFeedItemDecorationVertical();
        int r103 = mw1.c.f515916a;
        Intrinsics.checkNotNullParameter(r100, "feedStyle");
        int r104 = LiveResUtil.dp2Px(3.0f);
        int r105 = LiveResUtil.dp2Px(3.0f);
        if (r100 != FeedStyle.DOUBLE_LIST_D) goto L17;
        if (r101 != 0) goto L11;
        if (r102 != 0) goto L11;
        int r106 = r105;
    L15:
        int r107 = r104 / 2;
        return new OpenItemDecoration(r107, 0, r107, r106, 0);
    L11:
        if (r101 > 0) goto L14;
        r101 = r102;
    L14:
        r104 = r101;
        r106 = r104;
        goto L15
    L17:
        return new OpenItemDecoration(0, 0, 0, 0, 0);
    }

    private final RecyclerView.LayoutManager getLayoutManager() {
        GridLayoutManager r100 = new GridLayoutManager(getContext(), 2);
        r100.setSpanSizeLookup(new AnonymousClass1(this));
        return r100;
    }

    @Override // com.bytedance.android.livesdkapi.feed.ui.ILiveBlock
    public final void refresh() {
        FeedType r100 = this.f124244g.getFeedType();
        FeedType r101 = FeedType.FOLLOW_FEED;
        if (r100 != r101) goto L5;
        int r102 = g0.f66171a;
        String r103 = g0.a.a(1001);
    L6:
        LinkedHashMap r104 = new LinkedHashMap();
        if (this.f124244g.getFeedType() != r101) goto L9;
        r104.put("content_type", 3);
    L10:
        final Ref.IntRef r105 = new Ref.IntRef();
        r105.element = 0;
        final int r106 = 4;
        getFeedViewModel().setDataFilter(new C100241(r106, r105));
        getFeedViewModel().fetch(r103, "homepage_follow-live_cover", r104);
        getFeedViewModel().networkStat().observe(this, new a(this));
        return;
    L9:
        r104.put("content_type", 0);
        goto L10
    L5:
        int r107 = g0.f66171a;
        r103 = g0.a.a(1004);
        goto L6
    }

    @Override // com.bytedance.android.livesdk.utils.LifecycleOwnerCompat
    public Lifecycle getLifecycleCompat() {
        return getLifecycleRegistry();
    }

    @Override // com.bytedance.android.livesdkapi.feed.ui.ILiveBlock
    public final LiveData<Boolean> isEmpty() {
        return getFeedViewModel().listing().isEmpty();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        getLifecycleRegistry().markState(Lifecycle.State.STARTED);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        FeedLiveAdapter r100 = getAdapter();
        if (r100 == null) goto L7;
        com.bytedance.android.livesdk.feed.f r101 = r100.f123597e;
        if (r101 == null) goto L7;
        r101.b(this.f124241d);
    L7:
        super.onDetachedFromWindow();
        getLifecycleRegistry().markState(Lifecycle.State.DESTROYED);
    }

    public final int getDefaultBg() {
        return this.f124238a;
    }

    @Override // com.bytedance.android.livesdkapi.feed.ui.ILiveBlock
    public final LiveData<Boolean> isError() {
        return this.f124242e;
    }

    public static final /* synthetic */ FeedLiveAdapter b(LiveListBlock r100) {
        return r100.getAdapter();
    }

    public static final /* synthetic */ FeedListViewModel c(LiveListBlock r100) {
        return r100.getFeedViewModel();
    }

    public LiveListBlock(OpenFeedParams r100, Context r101) {
        Intrinsics.checkNotNullParameter(r100, "feedParams");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r101, null, 0);
        this.f124244g = r100;
        this.f124238a = -1;
        this.f124239b = LazyKt.lazy(new LiveListBlock$lifecycleRegistry$2(this));
        new ArrayList();
        this.f124240c = LazyKt.lazy(LiveListBlock$feedViewModel$2.INSTANCE);
        f r102 = new f(this);
        this.f124241d = r102;
        this.f124242e = new MutableLiveData();
        this.f124243f = LazyKt.lazy(new LiveListBlock$adapter$2(this));
        getLifecycleRegistry().markState(Lifecycle.State.CREATED);
        FrameLayout.inflate(r101, R.layout.ttlive_feed_block_view, this);
        ((RecyclerView) a(R.id.recycler_view)).setAdapter(getAdapter());
        ((RecyclerView) a(R.id.recycler_view)).setLayoutManager(getLayoutManager());
        ((RecyclerView) a(R.id.recycler_view)).addItemDecoration(getItemDecoration());
        ((RecyclerView) a(R.id.recycler_view)).setOnTouchListener(new d(this));
        ((LinearLayout) a(R.id.feed_title_right_btn)).setOnClickListener(new e(this, r101));
        getAdapter().setViewModel(getFeedViewModel());
        getAdapter().H2(l.f515875a);
        com.bytedance.android.livesdk.feed.f r103 = getAdapter().f123597e;
        if (r103 == null) goto L6;
        r103.i(r102);
        return;
    }
}
