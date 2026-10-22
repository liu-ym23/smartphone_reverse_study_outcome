package com.bytedance.android.shopping.store.search.viewmodel;

import android.content.Context;
import android.os.SystemClock;
import bn.b;
import com.bytedance.android.ec.core.arch.viewmodel.BaseViewModel;
import com.bytedance.android.ec.core.imagex.r;
import com.bytedance.android.shopping.store.repository.searchhistorydb.StoreSearchHistoryDatabase;
import com.bytedance.android.shopping.store.search.router.ECShopSearchParam;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.aweme.kiwi.viewmodel.QLiveData;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.util.Date;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import rj3.d;
import rj3.e;
import sj3.h;
import uj3.g;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010%\n\u0002\u0010\u0000\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\bS\u0010TJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0016\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006J\u0016\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tJ\u0006\u0010\f\u001a\u00020\u0004J\u0006\u0010\r\u001a\u00020\u0004J\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u000f0\u000eR\"\u0010\u0011\u001a\u00020\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\"\u0010\u0017\u001a\u00020\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u0012\u001a\u0004\b\u0018\u0010\u0014\"\u0004\b\u0019\u0010\u0016R\"\u0010\u001b\u001a\u00020\u001a8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u001d\u0010\"\u001a\b\u0012\u0004\u0012\u00020\t0!8\u0006¢\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%R\u001d\u0010&\u001a\b\u0012\u0004\u0012\u00020\t0!8\u0006¢\u0006\f\n\u0004\b&\u0010#\u001a\u0004\b'\u0010%R\u001d\u0010(\u001a\b\u0012\u0004\u0012\u00020\t0!8\u0006¢\u0006\f\n\u0004\b(\u0010#\u001a\u0004\b)\u0010%R\u001d\u0010+\u001a\b\u0012\u0004\u0012\u00020\t0*8\u0006¢\u0006\f\n\u0004\b+\u0010,\u001a\u0004\b-\u0010.R#\u00100\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060/0!8\u0006¢\u0006\f\n\u0004\b0\u0010#\u001a\u0004\b1\u0010%R\"\u00103\u001a\u0002028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b3\u00104\u001a\u0004\b5\u00106\"\u0004\b7\u00108R\u0016\u0010:\u001a\u0002098\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b:\u0010;R\u001d\u0010<\u001a\b\u0012\u0004\u0012\u0002020!8\u0006¢\u0006\f\n\u0004\b<\u0010#\u001a\u0004\b=\u0010%R\u0017\u0010?\u001a\u00020>8\u0006¢\u0006\f\n\u0004\b?\u0010@\u001a\u0004\bA\u0010BR\u001d\u0010D\u001a\b\u0012\u0004\u0012\u00020C0!8\u0006¢\u0006\f\n\u0004\bD\u0010#\u001a\u0004\bE\u0010%R\"\u0010F\u001a\u0002098\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bF\u0010;\u001a\u0004\bG\u0010H\"\u0004\bI\u0010JR\"\u0010K\u001a\u0002098\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bK\u0010;\u001a\u0004\bL\u0010H\"\u0004\bM\u0010JR\u0017\u0010O\u001a\u00020N8\u0006¢\u0006\f\n\u0004\bO\u0010P\u001a\u0004\bQ\u0010R¨\u0006U"}, d2 = {"Lcom/bytedance/android/shopping/store/search/viewmodel/ShopSearchViewModel;", "Lcom/bytedance/android/ec/core/arch/viewmodel/BaseViewModel;", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "", "initSearchHistoryData", "Lsj3/h;", "history", "updateHistory", "", "keyword", "insertHistory", "traceTimeStart", "traceTimeEnd", "", "", "getAdParams", "marketId", "Ljava/lang/String;", "getMarketId", "()Ljava/lang/String;", "setMarketId", "(Ljava/lang/String;)V", "userId", "getUserId", "setUserId", "Lcom/bytedance/android/shopping/store/search/router/ECShopSearchParam;", "searchParam", "Lcom/bytedance/android/shopping/store/search/router/ECShopSearchParam;", "getSearchParam", "()Lcom/bytedance/android/shopping/store/search/router/ECShopSearchParam;", "setSearchParam", "(Lcom/bytedance/android/shopping/store/search/router/ECShopSearchParam;)V", "Lcom/ss/android/ugc/aweme/kiwi/viewmodel/QLiveData;", "searchHint", "Lcom/ss/android/ugc/aweme/kiwi/viewmodel/QLiveData;", "getSearchHint", "()Lcom/ss/android/ugc/aweme/kiwi/viewmodel/QLiveData;", "searchContent", "getSearchContent", "initSearchText", "getInitSearchText", "Ljm/a;", "postKeyword", "Ljm/a;", "getPostKeyword", "()Ljm/a;", "", "storeSearchHistories", "getStoreSearchHistories", "", "toNewPage", "Z", "getToNewPage", "()Z", "setToNewPage", "(Z)V", "", "recordTime", "J", "historyEditing", "getHistoryEditing", "Ldn/a;", "sugRequestParam", "Ldn/a;", "getSugRequestParam", "()Ldn/a;", "Luj3/g;", "sugListResponseData", "getSugListResponseData", "middlePageStartTime", "getMiddlePageStartTime", "()J", "setMiddlePageStartTime", "(J)V", "pageDuration", "getPageDuration", "setPageDuration", "Lcom/bytedance/android/ec/core/imagex/r;", "imageCallerContext", "Lcom/bytedance/android/ec/core/imagex/r;", "getImageCallerContext", "()Lcom/bytedance/android/ec/core/imagex/r;", "<init>", "()V", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ShopSearchViewModel extends BaseViewModel {
    private final QLiveData<Boolean> historyEditing;
    private final r imageCallerContext;
    private final QLiveData<String> initSearchText;
    private String marketId;
    private long middlePageStartTime;
    private long pageDuration;
    private final jm.a<String> postKeyword;
    private long recordTime;
    private final QLiveData<String> searchContent;
    private final QLiveData<String> searchHint;
    private ECShopSearchParam searchParam;
    private final QLiveData<List<h>> storeSearchHistories;
    private final QLiveData<g> sugListResponseData;
    private final dn.a sugRequestParam;
    private boolean toNewPage;
    private String userId;

    public static final class a<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ShopSearchViewModel f186137a;

        public a(ShopSearchViewModel r100) {
            this.f186137a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            QLiveData<List<h>> r101 = this.f186137a.getStoreSearchHistories();
            r101.g((List) r100);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ShopSearchViewModel() {
        Object[] r100 = 0 == true ? 1 : 0;
        super(null, r100, 3, 0 == true ? 1 : 0);
        this.marketId = "unknown";
        this.userId = "unknown";
        this.searchParam = new ECShopSearchParam(null, null, null, null, 15, null);
        this.searchHint = new QLiveData();
        this.searchContent = new QLiveData();
        this.initSearchText = new QLiveData();
        this.postKeyword = new jm.a(7);
        this.storeSearchHistories = new QLiveData();
        this.toNewPage = true;
        this.recordTime = SystemClock.elapsedRealtime();
        this.historyEditing = new QLiveData();
        this.sugRequestParam = new dn.a();
        this.sugListResponseData = new QLiveData();
        this.middlePageStartTime = SystemClock.elapsedRealtime();
        int r101 = r.f44937h;
        this.imageCallerContext = r.a.c("ec_shop_search_sug");
    }

    public final Map<String, Object> getAdParams() {
        return MapsKt.mutableMapOf(new Pair[]{TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_SHOP_ID, this.searchParam.getShopId()), TuplesKt.to("category", "umeng"), TuplesKt.to("anchor_id", this.searchParam.getAnchorId()), TuplesKt.to("room_id", this.searchParam.getRoomId())});
    }

    public final void traceTimeEnd() {
        long r100 = SystemClock.elapsedRealtime();
        b r101 = new b();
        r101.f19696a = Long.valueOf(r100 - this.recordTime);
        if (this.toNewPage == false) goto L5;
        String r102 = "other";
    L6:
        r101.f19697b = r102;
        r101.f19698c = this.searchParam.getAuthorId();
        r101.f19699d = this.searchParam.getEnterFrom();
        r101.post(null, null);
        return;
    L5:
        r102 = "initiative";
        goto L6
    }

    public final void traceTimeStart() {
        this.recordTime = SystemClock.elapsedRealtime();
    }

    public final QLiveData<Boolean> getHistoryEditing() {
        return this.historyEditing;
    }

    public final r getImageCallerContext() {
        return this.imageCallerContext;
    }

    public final QLiveData<String> getInitSearchText() {
        return this.initSearchText;
    }

    public final String getMarketId() {
        return this.marketId;
    }

    public final long getMiddlePageStartTime() {
        return this.middlePageStartTime;
    }

    public final long getPageDuration() {
        return this.pageDuration;
    }

    public final jm.a<String> getPostKeyword() {
        return this.postKeyword;
    }

    public final QLiveData<String> getSearchContent() {
        return this.searchContent;
    }

    public final QLiveData<String> getSearchHint() {
        return this.searchHint;
    }

    public final ECShopSearchParam getSearchParam() {
        return this.searchParam;
    }

    public final QLiveData<List<h>> getStoreSearchHistories() {
        return this.storeSearchHistories;
    }

    public final QLiveData<g> getSugListResponseData() {
        return this.sugListResponseData;
    }

    public final dn.a getSugRequestParam() {
        return this.sugRequestParam;
    }

    public final boolean getToNewPage() {
        return this.toNewPage;
    }

    public final String getUserId() {
        return this.userId;
    }

    public final void initSearchHistoryData(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        rj3.a.C7490a r101 = rj3.a.f537991c;
        r101.a().a(r100);
        rj3.a r102 = r101.a();
        String r103 = this.userId;
        String r104 = this.marketId;
        Intrinsics.checkNotNullParameter(r103, "userId");
        Intrinsics.checkNotNullParameter(r104, "storeId");
        StoreSearchHistoryDatabase r105 = r102.f537992a;
        if (r105 == null) goto L5;
        Observable r106 = Observable.create(new d(r105, r102, r103, r104));
    L6:
        r106.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new a(this));
        return;
    L5:
        r106 = Observable.just(CollectionsKt.emptyList());
        goto L6
    }

    public final void setMarketId(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.marketId = r100;
    }

    public final void setMiddlePageStartTime(long r100) {
        this.middlePageStartTime = r100;
    }

    public final void setPageDuration(long r100) {
        this.pageDuration = r100;
    }

    public final void setSearchParam(ECShopSearchParam r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.searchParam = r100;
    }

    public final void setToNewPage(boolean r100) {
        this.toNewPage = r100;
    }

    public final void setUserId(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.userId = r100;
    }

    public final void insertHistory(Context r100, String r110) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r110, "keyword");
        rj3.a.C7490a r101 = rj3.a.f537991c;
        r101.a().a(r100);
        rj3.a r102 = r101.a();
        h r103 = new h(0, this.userId, this.marketId, r110, new Date());
        Intrinsics.checkNotNullParameter(r103, "history");
        StoreSearchHistoryDatabase r111 = r102.f537992a;
        if (r111 == null) goto L5;
        Observable r104 = Observable.create(new rj3.b(r111, r102, r103));
    L6:
        r104.subscribeOn(Schedulers.io()).observeOn(Schedulers.io()).subscribe();
        return;
    L5:
        r104 = Observable.just(-1L);
        goto L6
    }

    public final void updateHistory(Context r110, h r111) {
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r111, "history");
        rj3.a.C7490a r100 = rj3.a.f537991c;
        r100.a().a(r110);
        h r112 = new h(r111.f542279a, r111.f542280b, r111.f542281c, r111.f542282d, new Date());
        rj3.a r113 = r100.a();
        Intrinsics.checkNotNullParameter(r112, "history");
        StoreSearchHistoryDatabase r101 = r113.f537992a;
        if (r101 == null) goto L5;
        Observable r114 = Observable.create(new e(r101, r113, r112));
    L6:
        r114.subscribeOn(Schedulers.io()).observeOn(Schedulers.io()).subscribe();
        return;
    L5:
        r114 = Observable.just(-1);
        goto L6
    }
}
