package com.bytedance.android.livesdk.feed.repository;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.OnLifecycleEvent;
import com.alibaba.gaiax.model.GXAnimation;
import com.bytedance.android.live.base.model.feed.FeedItem;
import com.bytedance.android.live.core.cache.a;
import com.bytedance.android.live.core.cache.i;
import com.bytedance.android.live.core.monitor.BaseFeedMonitor;
import com.bytedance.android.live.core.paging.Listing;
import com.bytedance.android.livehostapi.TTMiddlewareLiveSDK;
import com.bytedance.android.livesdk.feed.ApiCallBack;
import com.bytedance.android.livesdk.feed.ItemRepository;
import com.bytedance.android.livesdk.feed.f;
import com.bytedance.android.livesdk.feed.feed.FeedDataKey;
import com.bytedance.android.livesdk.feed.feed.b;
import com.bytedance.android.livesdk.feed.z0;
import com.bytedance.common.utility.NetworkUtils;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.subjects.PublishSubject;

/* JADX INFO: loaded from: classes8.dex */
public abstract class BaseFeedRepository implements ItemRepository<FeedItem>, ApiCallBack {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final f f124308a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final CompositeDisposable f124309b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final a<FeedDataKey, FeedItem> f124310c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final PublishSubject<ApiDataStatus> f124311d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final PublishSubject<ApiDataStatus> f124312e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public z0 f124313f;

    public static final enum ApiDataStatus extends Enum<ApiDataStatus> {
        public static final ApiDataStatus FAIL = null;
        public static final ApiDataStatus START = null;
        public static final ApiDataStatus SUCCESS = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ ApiDataStatus[] f124314a = null;

        static {
            ApiDataStatus r100 = new ApiDataStatus(GXAnimation.STATE_START, 0);
            START = r100;
            ApiDataStatus r101 = new ApiDataStatus("SUCCESS", 1);
            SUCCESS = r101;
            ApiDataStatus r102 = new ApiDataStatus("FAIL", 2);
            FAIL = r102;
            f124314a = new ApiDataStatus[]{r100, r101, r102};
        }

        public static ApiDataStatus[] values() {
            return (ApiDataStatus[]) f124314a.clone();
        }

        public static ApiDataStatus valueOf(String r100) {
            return (ApiDataStatus) r27.a.a(ApiDataStatus.class, r100);
        }

        public ApiDataStatus(String r100, int r101) {
            super(r100, r101);
        }
    }

    public abstract FeedDataKey d();

    @Override // com.bytedance.android.livesdk.feed.ItemRepository
    public Listing<FeedItem> pc() {
        return null;
    }

    public abstract com.bytedance.android.livesdk.feed.feed.a<Listing<FeedItem>, b> query();

    @Override // com.bytedance.android.livesdk.feed.ItemRepository
    public void update(String r100) {
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public void unRegisterFeedRepository() {
        if (this.f124308a.h(d(), this) == false) goto L6;
        clear();
        this.f124309b.clear();
        return;
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    public void registerFeedRepository() {
        if (d() != null) goto L5;
        return;
    L5:
        this.f124308a.g(d(), this);
    }

    public final void b(ApiCallBack.ApiType r100) {
        z0 r101 = new z0();
        this.f124313f = r101;
        r101.l();
        if (r100 != ApiCallBack.ApiType.REFRESH) goto L6;
        this.f124311d.onNext(ApiDataStatus.START);
        return;
    L6:
        if (r100 != ApiCallBack.ApiType.LOAD_MORE) goto L12;
        this.f124312e.onNext(ApiDataStatus.START);
        z0 r102 = this.f124313f;
        if (r102 == null) goto L13;
        r102.l();
        return;
    L13:
        return;
    }

    public final void c(ApiCallBack.ApiType r100) {
        if (r100 != ApiCallBack.ApiType.REFRESH) goto L8;
        this.f124311d.onNext(ApiDataStatus.SUCCESS);
        z0 r101 = this.f124313f;
        if (r101 == null) goto L13;
        r101.n(z0.f124605d, BaseFeedMonitor.Scene.SERVICE_SCENE_DRAWER, BaseFeedMonitor.SubScene.SERVICE_SUB_SCENE_NONE);
        return;
    L13:
        return;
    L8:
        if (r100 != ApiCallBack.ApiType.LOAD_MORE) goto L15;
        this.f124312e.onNext(ApiDataStatus.SUCCESS);
        z0 r102 = this.f124313f;
        if (r102 == null) goto L16;
        r102.n(z0.f124606e, BaseFeedMonitor.Scene.SERVICE_SCENE_DRAWER, BaseFeedMonitor.SubScene.SERVICE_SUB_SCENE_NONE);
        return;
    L16:
        return;
    }

    public final void vK(LifecycleOwner r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        r100.getLifecycle().addObserver(this);
    }

    public BaseFeedRepository(f r100, i r101) {
        this.f124309b = new CompositeDisposable();
        this.f124311d = PublishSubject.create();
        this.f124312e = PublishSubject.create();
        this.f124308a = r100;
        this.f124310c = r101;
    }

    public final void a(ApiCallBack.ApiType r100, Throwable r101) {
        if (r100 != ApiCallBack.ApiType.REFRESH) goto L10;
        this.f124311d.onNext(ApiDataStatus.FAIL);
        if (this.f124313f != null) goto L7;
        return;
    L7:
        if (NetworkUtils.isNetworkAvailable(TTMiddlewareLiveSDK.getContext()) == false) goto L18;
        z0 r102 = this.f124313f;
        String r103 = z0.f124605d;
        r102.getClass();
        r102.m(r101, r103, BaseFeedMonitor.Scene.SERVICE_SCENE_DRAWER, BaseFeedMonitor.SubScene.SERVICE_SUB_SCENE_NONE);
        return;
    L18:
        return;
    L10:
        if (r100 != ApiCallBack.ApiType.LOAD_MORE) goto L20;
        this.f124312e.onNext(ApiDataStatus.FAIL);
        if (this.f124313f != null) goto L14;
        return;
    L14:
        if (NetworkUtils.isNetworkAvailable(TTMiddlewareLiveSDK.getContext()) == false) goto L22;
        z0 r104 = this.f124313f;
        String r105 = z0.f124606e;
        r104.getClass();
        r104.m(r101, r105, BaseFeedMonitor.Scene.SERVICE_SCENE_DRAWER, BaseFeedMonitor.SubScene.SERVICE_SUB_SCENE_NONE);
        return;
    L22:
        return;
    }
}
