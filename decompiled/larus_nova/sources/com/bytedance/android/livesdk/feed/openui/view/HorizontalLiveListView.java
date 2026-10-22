package com.bytedance.android.livesdk.feed.openui.view;

import android.content.Context;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleRegistry;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.amap.api.col.s.ce;
import com.bytedance.android.live.core.network.NetworkStat;
import com.bytedance.android.live.core.paging.Listing;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.livehostapi.TTLiveSDK;
import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import com.bytedance.android.livesdk.config.LiveConfigSettingKeys;
import com.bytedance.android.livesdk.feed.openui.adapter.HorizontalListAdapter;
import com.bytedance.android.livesdk.feed.openui.vm.RoomListViewModel;
import com.bytedance.android.livesdk.utils.LifecycleOwnerCompat;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.bytedance.android.livesdkapi.depend.live.LiveRoomIntentBuilder;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.feed.ArgumentsBuilder;
import com.bytedance.android.livesdkapi.feed.constant.FeedType;
import com.bytedance.android.livesdkapi.feed.model.HorFollowListParams;
import com.bytedance.android.livesdkapi.feed.ui.ILiveBlock;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003J\b\u0010\u0005\u001a\u00020\u0004H\u0016R\u001a\u0010\u000b\u001a\u00020\u00068\u0006X\u0086D¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\nR\u001b\u0010\u0011\u001a\u00020\f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001b\u0010\u0016\u001a\u00020\u00128BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0013\u0010\u000e\u001a\u0004\b\u0014\u0010\u0015R\u001b\u0010\u001b\u001a\u00020\u00178BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0018\u0010\u000e\u001a\u0004\b\u0019\u0010\u001a¨\u0006\u001c"}, d2 = {"Lcom/bytedance/android/livesdk/feed/openui/view/HorizontalLiveListView;", "Landroid/widget/FrameLayout;", "Lcom/bytedance/android/livesdk/utils/LifecycleOwnerCompat;", "Lcom/bytedance/android/livesdkapi/feed/ui/ILiveBlock;", "Landroidx/lifecycle/Lifecycle;", "getLifecycleCompat", "", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "I", "getDefaultBg", "()I", "defaultBg", "Landroidx/lifecycle/LifecycleRegistry;", "b", "Lkotlin/Lazy;", "getLifecycleRegistry", "()Landroidx/lifecycle/LifecycleRegistry;", "lifecycleRegistry", "Lcom/bytedance/android/livesdk/feed/openui/vm/RoomListViewModel;", ce.f26391f, "getFeedViewModel", "()Lcom/bytedance/android/livesdk/feed/openui/vm/RoomListViewModel;", "feedViewModel", "Lcom/bytedance/android/livesdk/feed/openui/adapter/HorizontalListAdapter;", RXScreenCaptureService.KEY_INDEX, "getAdapter", "()Lcom/bytedance/android/livesdk/feed/openui/adapter/HorizontalListAdapter;", "adapter", "saasfeed_release"}, k = 1, mv = {1, 4, 3})
public final class HorizontalLiveListView extends FrameLayout implements LifecycleOwnerCompat, ILiveBlock {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f124221a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f124222b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Disposable f124223c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List<Room> f124224d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f124225e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f124226f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Lazy f124227g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final MutableLiveData<Boolean> f124228h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Lazy f124229i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final MutableLiveData<Boolean> f124230j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final b f124231k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final MutableLiveData<Integer> f124232l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final HorFollowListParams f124233m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public HashMap f124234n;

    public static final class a implements View.OnTouchListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ HorizontalLiveListView f124235a;

        public a(HorizontalLiveListView r100) {
            this.f124235a = r100;
        }

        @Override // android.view.View.OnTouchListener
        public final boolean onTouch(View r100, MotionEvent r101) {
            Intrinsics.checkNotNullParameter(r101, "motionEvent");
            if (r101.getAction() != 0) goto L5;
        L10:
            ((RecyclerView) this.f124235a.a(R.id.recycler_view)).getParent().requestDisallowInterceptTouchEvent(true);
            return false;
        L5:
            if (r101.getAction() == 2) goto L10;
            if (r101.getAction() == 1) goto L10;
            ((RecyclerView) this.f124235a.a(R.id.recycler_view)).getParent().requestDisallowInterceptTouchEvent(true);
            return false;
        }
    }

    public static final class b<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ HorizontalLiveListView f124236a;

        public b(HorizontalLiveListView r100) {
            this.f124236a = r100;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r100) {
            MutableLiveData<Boolean> r101 = this.f124236a.f124230j;
            r101.postValue((Boolean) r100);
        }
    }

    public static final class c<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ HorizontalLiveListView f124237a;

        public c(HorizontalLiveListView r100) {
            this.f124237a = r100;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r100) {
            NetworkStat r101 = (NetworkStat) r100;
            NetworkStat.Status r102 = null;
            if (r101 == null) goto L5;
            NetworkStat.Status r103 = r101.mStatus;
        L6:
            int r104 = 0;
            if (r103 != NetworkStat.Status.FAILED) goto L11;
            this.f124237a.f124228h.postValue(Boolean.TRUE);
            if (this.f124237a.f124233m.getSupportStatusView() == false) goto L12;
            f2.b(R.string.ttlive_feed_empty, 0);
        L12:
            if (r101 == null) goto L15;
            r102 = r101.mStatus;
        L15:
            if (r102 != NetworkStat.Status.SUCCESS) goto L21;
            HorizontalLiveListView r105 = this.f124237a;
            MutableLiveData<Integer> r106 = r105.f124232l;
            Listing<Room> r107 = HorizontalLiveListView.c(r105).listing();
            if (r107 == null) goto L19;
            r104 = r107.size();
        L19:
            r106.postValue(Integer.valueOf(r104));
            return;
        L21:
            return;
        L11:
            this.f124237a.f124228h.postValue(Boolean.FALSE);
            goto L12
        L5:
            r103 = null;
            goto L6
        }
    }

    private final HorizontalListAdapter getAdapter() {
        return (HorizontalListAdapter) this.f124229i.getValue();
    }

    private final RoomListViewModel getFeedViewModel() {
        return (RoomListViewModel) this.f124227g.getValue();
    }

    private final LifecycleRegistry getLifecycleRegistry() {
        return (LifecycleRegistry) this.f124222b.getValue();
    }

    public final View a(int r100) {
        if (this.f124234n != null) goto L5;
        this.f124234n = new HashMap();
    L5:
        View r101 = (View) this.f124234n.get(Integer.valueOf(R.id.recycler_view));
        if (r101 != null) goto L9;
        View r102 = findViewById(R.id.recycler_view);
        this.f124234n.put(Integer.valueOf(R.id.recycler_view), r102);
        return r102;
    L9:
        return r101;
    }

    @Override // androidx.lifecycle.LifecycleOwner
    public /* bridge */ /* synthetic */ Lifecycle getLifecycle() {
        return LifecycleOwnerCompat.CC.$default$getLifecycle(this);
    }

    @Override // com.bytedance.android.livesdk.utils.LifecycleOwnerCompat
    public Lifecycle getLifecycleCompat() {
        return getLifecycleRegistry();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        getLifecycleRegistry().markState(Lifecycle.State.STARTED);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        getLifecycleRegistry().markState(Lifecycle.State.DESTROYED);
        Disposable r100 = this.f124223c;
        if (r100 != null) goto L5;
        return;
    L5:
        if (r100.isDisposed() == true) goto L11;
        Disposable r101 = this.f124223c;
        if (r101 == null) goto L12;
        r101.dispose();
        return;
    L12:
        return;
    }

    @Override // com.bytedance.android.livesdkapi.feed.ui.ILiveBlock
    public final void refresh() {
        if (Intrinsics.areEqual(getFeedViewModel().isDataEmpty().getValue(), Boolean.FALSE) == false) goto L6;
        getFeedViewModel().refresh();
        return;
    L6:
        String r100 = com.bytedance.android.live.core.feed.d.a(this.f124225e, this.f124226f);
        String r101 = this.f124225e + '-' + this.f124226f;
        LinkedHashMap r102 = new LinkedHashMap();
        r102.put("content_type", 1);
        getFeedViewModel().fetch(r100, r101, r102);
        if (this.f124233m.getFeedType() != FeedType.FOLLOW_FEED) goto L16;
        Disposable r103 = this.f124223c;
        if (r103 != null) goto L11;
    L15:
        this.f124223c = Observable.just(1).delay(300000, TimeUnit.MILLISECONDS).compose(RxUtil.rxSchedulerHelper()).subscribe(new com.bytedance.android.livesdk.feed.openui.view.c(this));
        goto L16
    L11:
        if (r103.isDisposed() == true) goto L15;
        Disposable r104 = this.f124223c;
        if (r104 == null) goto L15;
        r104.dispose();
    L16:
        getFeedViewModel().networkStat().observe(this, new c(this));
        getFeedViewModel().listing().isEmpty().removeObserver(this.f124231k);
        getFeedViewModel().listing().isEmpty().observeForever(this.f124231k);
    }

    public final int getDefaultBg() {
        return this.f124221a;
    }

    @Override // com.bytedance.android.livesdkapi.feed.ui.ILiveBlock
    public final LiveData<Boolean> isEmpty() {
        return this.f124230j;
    }

    @Override // com.bytedance.android.livesdkapi.feed.ui.ILiveBlock
    public final LiveData<Boolean> isError() {
        return this.f124228h;
    }

    public static final /* synthetic */ RoomListViewModel c(HorizontalLiveListView r100) {
        return r100.getFeedViewModel();
    }

    public static final void b(HorizontalLiveListView r100, Room r101) {
        r100.getClass();
        Bundle r102 = new Bundle();
        r102.putString("log_pb", r101.getLog_pb());
        r102.putString("request_id", r101.getRequestId());
        r102.putString("enter_from_merge", r100.f124225e);
        r102.putString("enter_method", r100.f124226f);
        r102.putString("anchor_id", r101.getOwnerUserIdString());
        String r103 = LiveConfigSettingKeys.LIVE_FEED_TOP_PORTRAINT_CLICK.getValue();
        if (r103 != null) goto L5;
        r103 = "https://webcast-open.douyin.com/webcast/openapi/feed/?channel_id=160007&hidden_banner=1&content_type=1";
    L5:
        r102.putString(ILiveRoomPlayFragmentConstant.EXTRA_LIVE_FEED_URL_NEW, r103);
        Bundle r104 = LiveRoomIntentBuilder.buildBundle(r100.getContext(), r101, UserProfileEvent.DATA_TYPE_HOME_PAGE_HOT, r102);
        if (r104 != null) goto L8;
        return;
    L8:
        if (TTLiveSDK.hostService() != null) goto L10;
        return;
    L10:
        if (TTLiveSDK.hostService().action() == null) goto L42;
        r104.putAll(ArgumentsBuilder.buildRoomArgs(r101));
        if (r104.get(ILiveRoomPlayFragmentConstant.EXTRA_USER_ID) != null) goto L15;
        r104.putString(ILiveRoomPlayFragmentConstant.EXTRA_USER_ID, r101.getOwnerUserIdString());
    L15:
        if (r100.f124233m.getFeedType() != FeedType.FOLLOW_FEED) goto L31;
        Listing<Room> r105 = r100.getFeedViewModel().listing();
        int r106 = 0;
        if (r105 == null) goto L19;
        int r107 = r105.size();
    L20:
        ((ArrayList) r100.f124224d).clear();
    L21:
        if (r106 >= r107) goto L26;
        Room r108 = r100.getFeedViewModel().get(r106);
        if (r108 == null) goto L25;
        ((ArrayList) r100.f124224d).add(r108);
    L25:
        r106 = r106 + 1;
        goto L21
    L26:
        List<Room> r109 = r100.f124224d;
        ArrayList r110 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r109, 10));
        Iterator r111 = ((ArrayList) r109).iterator();
    L28:
        if (r111.hasNext() == false) goto L30;
        r110.add(Long.valueOf(((Room) r111.next()).f162599id));
        goto L28
    L30:
        r104.putLongArray(ILiveRoomPlayFragmentConstant.EXTRA_ENTER_ROOM_IDS, CollectionsKt.toLongArray(r110));
        r104.putBoolean(ILiveRoomPlayFragmentConstant.EXTRA_FORCE_NO_RECOMMEND_DRAW, true);
        goto L31
    L19:
        r107 = 0;
    L31:
        int r112 = kw1.c.f506382a;
        kw1.c.b(r100.getContext(), r102);
        nn2.a r113 = nn2.a.f519628d;
        if (nn2.a.C6941a.a().b(r101.f162599id) == false) goto L34;
        r104.putString("source", "ad_union");
        r104.putString("ad_data_params", r101.adRawString);
    L34:
        TTLiveSDK.hostService().action().startLive(r100.getContext(), r101.f162599id, r104);
        return;
    }

    public HorizontalLiveListView(HorFollowListParams r100, Context r101, AttributeSet r102, int r103) {
        Intrinsics.checkNotNullParameter(r100, "feedParams");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r101, r102, r103);
        this.f124233m = r100;
        this.f124221a = -1;
        this.f124222b = LazyKt.lazy(new HorizontalLiveListView$lifecycleRegistry$2(this));
        this.f124224d = new ArrayList();
        this.f124225e = "homepage_follow";
        this.f124226f = "top_portrait";
        this.f124227g = LazyKt.lazy(HorizontalLiveListView$feedViewModel$2.INSTANCE);
        this.f124228h = new MutableLiveData();
        this.f124229i = LazyKt.lazy(new HorizontalLiveListView$adapter$2(this));
        getLifecycleRegistry().markState(Lifecycle.State.CREATED);
        String r104 = r100.getEnterFromMerge();
        if (r104 != null) goto L5;
    L13:
        FrameLayout.inflate(r101, R.layout.ttlive_feed_view_horizontal_list, this);
        ((RecyclerView) a(R.id.recycler_view)).setAdapter(getAdapter());
        ((RecyclerView) a(R.id.recycler_view)).setLayoutManager(new LinearLayoutManager(r101, 0, false));
        ((RecyclerView) a(R.id.recycler_view)).addItemDecoration(new FollowSkyItemDecoration());
        ((RecyclerView) a(R.id.recycler_view)).setOnTouchListener(new a(this));
        getAdapter().setViewModel(getFeedViewModel());
        Integer r105 = r100.getBackgroundColor();
        if (r105 == null) goto L16;
        setBackgroundColor(r105.intValue());
    L16:
        this.f124230j = new MutableLiveData();
        this.f124231k = new b(this);
        this.f124232l = new MutableLiveData();
        return;
    L5:
        if (r104.length() <= 0) goto L7;
        boolean r106 = true;
    L8:
        if (r106 == true) goto L11;
        r104 = null;
    L11:
        if (r104 == null) goto L13;
        this.f124225e = r104;
        goto L13
    L7:
        r106 = false;
        goto L8
    }
}
