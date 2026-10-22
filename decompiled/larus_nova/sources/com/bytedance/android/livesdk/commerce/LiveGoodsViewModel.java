package com.bytedance.android.livesdk.commerce;

import android.util.Pair;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.live.base.model.feed.FeedExtra;
import com.bytedance.android.live.core.widget.simple.SimpleListViewModel;
import com.bytedance.android.live.network.response.BaseListResponse;
import com.bytedance.android.livesdk.config.n61;
import com.bytedance.android.livesdk.service.l;
import com.bytedance.android.livesdkapi.depend.prefs.Property;
import com.bytedance.common.utility.Lists;
import io.reactivex.Observable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\"\u0010#J\b\u0010\u0004\u001a\u00020\u0003H\u0016J\b\u0010\u0005\u001a\u00020\u0003H\u0016JA\u0010\u000f\u001a\u001a\u0012\u0016\u0012\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\r\u0012\u0004\u0012\u00020\u000e0\f0\u000b2\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\n\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u000e\u0010\u0012\u001a\u00020\u00002\u0006\u0010\u0011\u001a\u00020\bJ\u0010\u0010\u0016\u001a\u00020\u00152\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013R\u0016\u0010\u0017\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0016\u0010\u0011\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010\u0019R\u001d\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00030\u001a8\u0006¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u001c\u0010 \u001a\b\u0012\u0004\u0012\u00020\b0\u001f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b \u0010!¨\u0006$"}, d2 = {"Lcom/bytedance/android/livesdk/commerce/LiveGoodsViewModel;", "Lcom/bytedance/android/live/core/widget/simple/SimpleListViewModel;", "", "", "getPageSize", "getPrefetchDistance", "", "initial", "", "key", "pageSize", "Lio/reactivex/Observable;", "Landroid/util/Pair;", "", "Lcom/bytedance/android/live/base/model/feed/FeedExtra;", "createObservable", "(ZLjava/lang/Long;I)Lio/reactivex/Observable;", "userId", "setUserId", "Lcom/bytedance/android/livesdk/commerce/e;", "data", "", "removeBanner", "offset", "I", "J", "Landroidx/lifecycle/MutableLiveData;", "totalNum", "Landroidx/lifecycle/MutableLiveData;", "getTotalNum", "()Landroidx/lifecycle/MutableLiveData;", "Lcom/bytedance/android/livesdkapi/depend/prefs/Property;", "LIVE_COMMERCE_BANNER_LAST_CLOSE_ID", "Lcom/bytedance/android/livesdkapi/depend/prefs/Property;", "<init>", "()V", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveGoodsViewModel extends SimpleListViewModel<Object> {
    private Property<Long> LIVE_COMMERCE_BANNER_LAST_CLOSE_ID;
    private int offset;
    private final MutableLiveData<Integer> totalNum;
    private long userId;

    public static final class a<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LiveGoodsViewModel f119535a;

        public a(LiveGoodsViewModel r100) {
            this.f119535a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            LiveGoodsViewModel r101 = this.f119535a;
            LiveGoodsViewModel.access$setOffset$p(r101, LiveGoodsViewModel.access$getOffset$p(r101) + ((BaseListResponse) r100).data.size());
        }
    }

    public static final class b<T, R> implements Function {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LiveGoodsViewModel f119536a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ boolean f119537b;

        public b(LiveGoodsViewModel r100, boolean r101) {
            this.f119536a = r100;
            this.f119537b = r101;
        }

        @Override // io.reactivex.functions.Function
        public final Object apply(Object r100) {
            BaseListResponse r101 = (BaseListResponse) r100;
            Intrinsics.checkNotNullParameter(r101, "response");
            ArrayList r102 = new ArrayList();
            if (Lists.isEmpty(r101.data) == false) goto L5;
        L12:
            FeedExtra r103 = (FeedExtra) r101.extra;
            r103.maxTime = r103.now;
            this.f119536a.getTotalNum().postValue(Integer.valueOf(((FeedExtra) r101.extra).total));
            return Pair.create(r102, r101.extra);
        L5:
            if (this.f119537b == false) goto L11;
            e r104 = n61.f120809a.getValue();
            if (r104 == null) goto L11;
            if (r104.a() <= ((Number) LiveGoodsViewModel.access$getLIVE_COMMERCE_BANNER_LAST_CLOSE_ID$p(this.f119536a).getValue()).longValue()) goto L11;
            r102.add(r104);
        L11:
            r102.addAll(r101.data);
            goto L12
        }
    }

    @Override // com.bytedance.android.live.core.widget.simple.SimpleListViewModel
    public int getPageSize() {
        return 10;
    }

    @Override // com.bytedance.android.live.core.widget.simple.SimpleListViewModel
    public int getPrefetchDistance() {
        return 5;
    }

    public LiveGoodsViewModel() {
        this.totalNum = new MutableLiveData();
        this.LIVE_COMMERCE_BANNER_LAST_CLOSE_ID = new Property("live_commerce_banner_last_close_id", -1L);
    }

    public final MutableLiveData<Integer> getTotalNum() {
        return this.totalNum;
    }

    public static final /* synthetic */ Property access$getLIVE_COMMERCE_BANNER_LAST_CLOSE_ID$p(LiveGoodsViewModel r100) {
        return r100.LIVE_COMMERCE_BANNER_LAST_CLOSE_ID;
    }

    public static final /* synthetic */ int access$getOffset$p(LiveGoodsViewModel r100) {
        return r100.offset;
    }

    public final void removeBanner(e r100) {
        if (r100 == null) goto L5;
        this.LIVE_COMMERCE_BANNER_LAST_CLOSE_ID.setValue(Long.valueOf(r100.a()));
        remove(r100);
        return;
    }

    public final LiveGoodsViewModel setUserId(long r100) {
        this.userId = r100;
        return this;
    }

    public static final /* synthetic */ void access$setLIVE_COMMERCE_BANNER_LAST_CLOSE_ID$p(LiveGoodsViewModel r100, Property r101) {
        r100.LIVE_COMMERCE_BANNER_LAST_CLOSE_ID = r101;
    }

    public static final /* synthetic */ void access$setOffset$p(LiveGoodsViewModel r100, int r101) {
        r100.offset = r101;
    }

    @Override // com.bytedance.android.live.core.paging.datasource.PagingLoadCallback
    public Observable<Pair<List<Object>, FeedExtra>> createObservable(boolean r110, Long r111, int r112) {
        if (r110 == false) goto L4;
        this.offset = 0;
    L4:
        int r113 = c.f119539a;
        long r100 = this.userId;
        long r101 = this.offset;
        long r102 = getPageSize();
        l.d().getClass();
        return ((LiveCommerceApi) com.bytedance.android.live.network.c.b().e(LiveCommerceApi.class)).fetchLiveCommerce("https://hotsoon.snssdk.com/hotsoon/commerce/live/promotions/", r100, r101, r102, "live").doOnNext(new a(this)).map(new b(this, r110));
    }
}
