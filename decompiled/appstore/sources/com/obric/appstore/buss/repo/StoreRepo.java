package com.obric.appstore.buss.repo;

import com.bytedanceos.common.model.SearchHotWords;
import com.bytedanceos.common.model.database.DataBaseManager;
import com.obric.appstore.network.entity.HotWordsReq;
import com.obric.appstore.network.entity.template.PageType;
import com.obric.appstore.network.g;
import com.obric.appstore.network.h;
import java.util.List;
import kotlin.Unit;
import kotlin.c;
import kotlin.collections.b0;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.a;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.q;

/* JADX INFO: loaded from: classes3.dex */
public final class StoreRepo extends BaseRepository {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final StoreRepo f10831a = null;

    static {
        f10831a = new StoreRepo();
    }

    public StoreRepo() {
    }

    public final Object d(Continuation r10) {
        DataBaseManager.SearchHistory.clearSearchHistory();
        return Unit.f21064a;
    }

    public final Object e(String r10, Continuation r11) {
        return b(new StoreRepo$getAppDetail$2(r10, null), r11);
    }

    public final Object f(String r10, Continuation r11) {
        return b(new StoreRepo$getAppPerms$2(r10, null), r11);
    }

    public final Object g(String r10, String r11, int r12, Continuation r13) {
        return b(new StoreRepo$getCategoryFirst$2(r10, r11, r12, null), r13);
    }

    public final Object h(String r10, String r11, int r12, Continuation r13) {
        return b(new StoreRepo$getDevelopApps$2(r10, r11, r12, null), r13);
    }

    public final Object i(List r10, Continuation r11) {
        return b(new StoreRepo$getLocalAppsOnline$2(r10, null), r11);
    }

    public final Object j(PageType r10, Continuation r11) {
        return b(new StoreRepo$getPageApps$2(r10, null), r11);
    }

    public final Object k(PageType r10, Continuation r11) {
        return b(new StoreRepo$getPageData$2(r10, null), r11);
    }

    public final Object l(final PageType r10, Continuation r11) {
        if ((r11 instanceof StoreRepo$getPageDataWithCache$1) == false) goto L7;
        StoreRepo$getPageDataWithCache$1 r12 = (StoreRepo$getPageDataWithCache$1) r11;
        int r13 = r12.label;
        if ((r13 & Integer.MIN_VALUE) == 0) goto L7;
        r12.label = r13 - Integer.MIN_VALUE;
    L8:
        Object r14 = r12.result;
        Object r15 = a.d();
        int r16 = r12.label;
        if (r16 == 0) goto L14;
        if (r16 != 1) goto L13;
        r10 = (PageType) r12.L$0;
        c.b(r14);
    L18:
        return h.a((g) r14, new StoreRepo$getPageDataWithCache$3$1(r10));
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        c.b(r14);
        Function2 r17 = new StoreRepo$getPageDataWithCache$2(r10, null);
        r12.L$0 = r10;
        r12.label = 1;
        r14 = c(r17, r12);
        if (r14 != r15) goto L18;
        return r15;
    L7:
        r12 = new StoreRepo$getPageDataWithCache$1(this, r11);
        goto L8
    }

    public final Object m(String r10, int r11, Continuation r12) {
        return b(new StoreRepo$getSearchApps$2(r10, r11, null), r12);
    }

    public final Object n(Continuation r10) {
        if ((r10 instanceof StoreRepo$getSearchHotWord$1) == false) goto L7;
        StoreRepo$getSearchHotWord$1 r11 = (StoreRepo$getSearchHotWord$1) r10;
        int r12 = r11.label;
        if ((r12 & Integer.MIN_VALUE) == 0) goto L7;
        r11.label = r12 - Integer.MIN_VALUE;
    L8:
        Object r13 = r11.result;
        Object r14 = a.d();
        int r15 = r11.label;
        if (r15 == 0) goto L14;
        if (r15 != 1) goto L13;
        c.b(r13);
    L17:
        g r16 = (g) r13;
        if ((r16 instanceof g.d) == false) goto L25;
        HotWordsReq r17 = (HotWordsReq) ((g.d) r16).a();
        if (r17 == null) goto L26;
        List<String> r18 = r17.getHotWords();
        if (r18 != null) goto L24;
        return null;
    L24:
        return (String) b0.Z(r18);
    L26:
        return null;
    L25:
        return null;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        c.b(r13);
        Function2 r19 = new StoreRepo$getSearchHotWord$result$1(null);
        r11.label = 1;
        r13 = c(r19, r11);
        if (r13 != r14) goto L17;
        return r14;
    L7:
        r11 = new StoreRepo$getSearchHotWord$1(this, r10);
        goto L8
    }

    public final Object o(String r10, Continuation r11) {
        return b(new StoreRepo$getSearchSuggestApps$2(r10, null), r11);
    }

    public final Object p(List r10, Continuation r11) {
        return b(new StoreRepo$getUpdateApps$2(r10, null), r11);
    }

    public final List q() {
        List<SearchHotWords> r10 = DataBaseManager.SearchHistory.readSearchHistory();
        q.f(r10, "readSearchHistory(...)");
        return r10;
    }

    public final List r(String r10) {
        q.g(r10, "searchKey");
        DataBaseManager.SearchHistory.saveSearchHistory(r10);
        List<SearchHotWords> r11 = DataBaseManager.SearchHistory.readSearchHistory();
        q.d(r11);
        return r11;
    }
}
