package com.bytedance.android.live.openplatform.impl.miniappanchor.choose.page.search;

import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.openplatform.impl.base.utils.LiveOpenPlatformClient;
import com.bytedance.android.live.openplatform.impl.miniappanchor.choose.api.ChooseApi;
import com.bytedance.android.live.openplatform.impl.miniappanchor.choose.page.base.MiniAppChooseBaseViewModel;
import com.bytedance.android.live.openplatform.impl.miniappanchor.choose.page.search.respository.MiniAppChooseSearchRepository;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.JsonSyntaxException;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.LinkedList;
import java.util.List;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes46.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u001d\u0010\u001eJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u000f\u0010\u0004\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\b\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\n\u0010\u0005J\u000e\u0010\u000b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006J\u0006\u0010\r\u001a\u00020\fJ\u0006\u0010\u000e\u001a\u00020\u0002J\b\u0010\u000f\u001a\u00020\u0002H\u0014R\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R#\u0010\u0015\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00140\u00138\u0006¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R#\u0010\u001b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001a0\u00190\u00138\u0006¢\u0006\f\n\u0004\b\u001b\u0010\u0016\u001a\u0004\b\u001c\u0010\u0018¨\u0006\u001f"}, d2 = {"Lcom/bytedance/android/live/openplatform/impl/miniappanchor/choose/page/search/MiniAppChooseSearchViewModel;", "Lcom/bytedance/android/live/openplatform/impl/miniappanchor/choose/page/base/MiniAppChooseBaseViewModel;", "", "onScopeInitialized", "loadHistoryList", "()Lkotlin/Unit;", "", "keyword", "deleteHistory", "(Ljava/lang/String;)Lkotlin/Unit;", "deleteAllHistory", "searchMiniApp", "", "getHistoryListSize", "saveHistoryList", "onCleared", "Lcom/bytedance/android/live/openplatform/impl/miniappanchor/choose/page/search/respository/MiniAppChooseSearchRepository;", "repository", "Lcom/bytedance/android/live/openplatform/impl/miniappanchor/choose/page/search/respository/MiniAppChooseSearchRepository;", "Landroidx/lifecycle/MutableLiveData;", "Ljava/util/LinkedList;", "historyListUiState", "Landroidx/lifecycle/MutableLiveData;", "getHistoryListUiState", "()Landroidx/lifecycle/MutableLiveData;", "Lcom/bytedance/android/live/openplatform/impl/base/utils/b;", "Lcom/bytedance/android/live/openplatform/impl/miniappanchor/choose/page/search/p;", "searchResultUiState", "getSearchResultUiState", "<init>", "()V", "liveopenplatform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class MiniAppChooseSearchViewModel extends MiniAppChooseBaseViewModel {
    private final MutableLiveData<LinkedList<String>> historyListUiState;
    private MiniAppChooseSearchRepository repository;
    private final MutableLiveData<com.bytedance.android.live.openplatform.impl.base.utils.b<p>> searchResultUiState;

    public static final class a<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MiniAppChooseSearchViewModel f84262a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f84263b;

        public a(MiniAppChooseSearchViewModel r100, String r101) {
            this.f84262a = r100;
            this.f84263b = r101;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            List r101 = (List) r100;
            MutableLiveData<com.bytedance.android.live.openplatform.impl.base.utils.b<p>> r102 = this.f84262a.getSearchResultUiState();
            List r103 = r101;
            if (r103 != null) goto L5;
        L8:
            boolean r104 = true;
        L10:
            if (r104 == false) goto L12;
            int r105 = qo0.a.f534145a;
            qo0.a.c("choose_search", "search mini app success, keyword: " + this.f84263b + ", result is empty");
            com.bytedance.android.live.openplatform.impl.base.utils.b<p> r106 = new com.bytedance.android.live.openplatform.impl.base.utils.b(p.a.f84291a);
        L13:
            r102.setValue(r106);
            return;
        L12:
            int r107 = qo0.a.f534145a;
            qo0.a.c("choose_search", "search mini app success, keyword: " + this.f84263b);
            r106 = new com.bytedance.android.live.openplatform.impl.base.utils.b(new p.d(r101));
            goto L13
        L5:
            if (r103.isEmpty() == true) goto L8;
            r104 = false;
            goto L10
        }
    }

    public static final class b<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MiniAppChooseSearchViewModel f84264a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f84265b;

        public b(MiniAppChooseSearchViewModel r100, String r101) {
            this.f84264a = r100;
            this.f84265b = r101;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            int r101 = qo0.a.f534145a;
            qo0.a.b("choose_search", "search mini app fail, keyword: " + this.f84265b, (Throwable) r100);
            this.f84264a.getSearchResultUiState().setValue(new com.bytedance.android.live.openplatform.impl.base.utils.b(p.b.f84292a));
        }
    }

    public final Unit deleteAllHistory() {
        MiniAppChooseSearchRepository r100 = this.repository;
        if (r100 == null) goto L9;
        LinkedList<String> r101 = r100.f84296b.f519996a;
        if (r101 == null) goto L11;
        qo0.a.c("choose_search", "delete all history");
        r101.clear();
        r100.f84296b.a(r101);
    L11:
        return Unit.INSTANCE;
    L9:
        return null;
    }

    public final int getHistoryListSize() {
        MiniAppChooseSearchRepository r100 = this.repository;
        if (r100 == null) goto L8;
        LinkedList<String> r101 = r100.f84296b.f519996a;
        if (r101 != null) goto L7;
        return 0;
    L7:
        return r101.size();
    L8:
        return 0;
    }

    public final Unit loadHistoryList() {
        MiniAppChooseSearchRepository r100 = this.repository;
        if (r100 == null) goto L19;
        np0.b<LinkedList<String>> r101 = r100.f84296b;
        m r102 = r100.f84295a;
        r102.getClass();
        String r103 = r102.f84285a.j(r102.f84286b, "");     // Catch: JsonSyntaxException -> L16
        if (r103 != null) goto L8;
    L11:
        boolean r104 = true;
    L12:
        if (r104 == false) goto L14;
        LinkedList<String> r105 = new LinkedList();     // Catch: JsonSyntaxException -> L16
    L18:
        int r106 = qo0.a.f534145a;
        qo0.a.c("choose_search", "load history list success: " + CollectionsKt.joinToString$default(r105, null, "[", "]", 0, null, null, 57, null));
        Unit r107 = Unit.INSTANCE;
        r101.a(r105);
        return Unit.INSTANCE;
    L14:
        r105 = (LinkedList) GsonProtectorUtils.fromJson(GsonHelper.getDefault(), r103, new l().getType());     // Catch: JsonSyntaxException -> L16
        goto L18
    L8:
        if (StringsKt.isBlank(r103) == true) goto L11;
        r104 = false;
    L16:
        e = move-exception;
        qo0.a.b("choose_search", "load local history list error", e);
        r105 = new LinkedList();
        goto L18
    L19:
        return null;
    }

    public final void saveHistoryList() {
        MiniAppChooseSearchRepository r100 = this.repository;
        if (r100 == null) goto L8;
        LinkedList<String> r101 = r100.f84296b.f519996a;
        if (r101 == null) goto L9;
        int r102 = qo0.a.f534145a;
        qo0.a.c("choose_search", "save history list: " + CollectionsKt.joinToString$default(r101, null, "[", "]", 0, null, null, 57, null));
        m r103 = r100.f84295a;
        r103.getClass();
        Intrinsics.checkNotNullParameter(r101, "newHistoryList");
        r103.f84285a.m(r103.f84286b, GsonProtectorUtils.toJson(GsonHelper.getDefault(), r101));
        return;
    L9:
        return;
    }

    public MiniAppChooseSearchViewModel() {
        this.historyListUiState = new MutableLiveData();
        this.searchResultUiState = new MutableLiveData();
    }

    @Override // com.bytedance.android.live.openplatform.impl.miniappanchor.choose.page.base.MiniAppChooseBaseViewModel, androidx.lifecycle.ViewModel
    public void onCleared() {
        super.onCleared();
        qo0.a.c("choose_search", "on choose search vm cleared");
    }

    @Override // com.bytedance.android.live.openplatform.impl.miniappanchor.choose.page.base.MiniAppChooseBaseViewModel
    public void onScopeInitialized() {
        lp0.a r100 = getScope();
        Observable<LinkedList<String>> r101 = null;
        if (r100 == null) goto L5;
        MiniAppChooseSearchRepository r102 = (MiniAppChooseSearchRepository) lp0.b.b(r100, MiniAppChooseSearchRepository.class);
    L6:
        this.repository = r102;
        MutableLiveData<LinkedList<String>> r103 = this.historyListUiState;
        if (r102 == null) goto L9;
        r101 = r102.f84296b.f519998c;
    L9:
        subscribe(r103, r101, AnonymousClass1.INSTANCE);
        return;
    L5:
        r102 = null;
        goto L6
    }

    public final MutableLiveData<LinkedList<String>> getHistoryListUiState() {
        return this.historyListUiState;
    }

    public final MutableLiveData<com.bytedance.android.live.openplatform.impl.base.utils.b<p>> getSearchResultUiState() {
        return this.searchResultUiState;
    }

    public final Unit deleteHistory(String r100) {
        Intrinsics.checkNotNullParameter(r100, "keyword");
        MiniAppChooseSearchRepository r101 = this.repository;
        if (r101 == null) goto L12;
        Intrinsics.checkNotNullParameter(r100, "keyword");
        LinkedList<String> r102 = r101.f84296b.f519996a;
        if (r102 == null) goto L14;
        int r103 = qo0.a.f534145a;
        qo0.a.c("choose_search", "delete history, keyword: " + r100);
        if (r102.contains(r100) == false) goto L10;
        r102.remove(r100);
    L10:
        r101.f84296b.a(r102);
    L14:
        return Unit.INSTANCE;
    L12:
        return null;
    }

    public final void searchMiniApp(String r110) {
        Intrinsics.checkNotNullParameter(r110, "keyword");
        this.searchResultUiState.setValue(new com.bytedance.android.live.openplatform.impl.base.utils.b(p.c.f84293a));
        MiniAppChooseSearchRepository r100 = this.repository;
        if (r100 == null) goto L20;
        long r101 = getScene();
        long r102 = getRoomId();
        Intrinsics.checkNotNullParameter(r110, "keyword");
        int r103 = qo0.a.f534145a;
        qo0.a.c("choose_search", "start search mini app, keyword: " + r110);
        LinkedList<String> r104 = r100.f84296b.f519996a;
        if (r104 == null) goto L14;
        qo0.a.c("choose_search", "add keyword to history: " + r110 + ", size: " + r104.size());
        if (r104.contains(r110) == false) goto L10;
        r104.remove(r110);
    L10:
        r104.add(r110);
        if (r104.size() <= 5) goto L13;
        r104.poll();
    L13:
        r100.f84296b.a(r104);
    L14:
        Lazy r105 = LiveOpenPlatformClient.f84032c;
        Observable r106 = ((ChooseApi) LiveOpenPlatformClient.a.a().a(ChooseApi.class)).searchMiniApp(r101, Long.valueOf(r102), r110).compose(RxUtil.rxSchedulerHelper()).map(kp0.a.f505489a);
        if (r106 == null) goto L21;
        Disposable r111 = r106.subscribe(new a(this, r110), new b(this, r110));
        if (r111 == null) goto L22;
        autoDispose(r111);
        return;
    L22:
        return;
    L21:
        return;
    }
}
