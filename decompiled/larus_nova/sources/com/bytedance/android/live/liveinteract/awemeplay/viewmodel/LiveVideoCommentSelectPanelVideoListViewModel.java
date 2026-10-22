package com.bytedance.android.live.liveinteract.awemeplay.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.liveinteract.awemeplay.api.LiveVideoCommentApi;
import com.bytedance.android.live.network.c;
import com.bytedance.android.live.network.response.Response;
import com.bytedance.android.livehostapi.foundation.IMiddleWareHostContext;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import vm2.k;

/* JADX INFO: loaded from: classes46.dex */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010$\u001a\u00020#¢\u0006\u0004\b&\u0010'J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u000e\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tJ\b\u0010\f\u001a\u00020\u0004H\u0014R(\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0016\u001a\u00020\u00158\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0018\u0010\u0019\u001a\u0004\u0018\u00010\u00188\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0018\u0010\u001b\u001a\u0004\u0018\u00010\u00188\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001b\u0010\u001aR\u0018\u0010\u001d\u001a\u0004\u0018\u00010\u001c8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u001c\u0010!\u001a\b\u0012\u0004\u0012\u00020 0\u001f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b!\u0010\"R\u0014\u0010$\u001a\u00020#8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b$\u0010%¨\u0006("}, d2 = {"Lcom/bytedance/android/live/liveinteract/awemeplay/viewmodel/LiveVideoCommentSelectPanelVideoListViewModel;", "Landroidx/lifecycle/ViewModel;", "Lud0/a$a;", "action", "", "fetchNextVideoList", "Lsd0/b;", "data", "fetchVideoListSuccess", "Lud0/a;", "viewAction", "doAction", "onCleared", "Landroidx/lifecycle/MutableLiveData;", "Lud0/b;", "viewEvent", "Landroidx/lifecycle/MutableLiveData;", "getViewEvent", "()Landroidx/lifecycle/MutableLiveData;", "setViewEvent", "(Landroidx/lifecycle/MutableLiveData;)V", "Lio/reactivex/disposables/CompositeDisposable;", "compositeDisposable", "Lio/reactivex/disposables/CompositeDisposable;", "", "curMaxCursor", "Ljava/lang/Long;", "curMinCursor", "", "hasMore", "Ljava/lang/Boolean;", "", "Lsd0/a;", "curVideoList", "Ljava/util/List;", "", "type", "I", "<init>", "(I)V", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class LiveVideoCommentSelectPanelVideoListViewModel extends ViewModel {
    private final CompositeDisposable compositeDisposable;
    private Long curMaxCursor;
    private Long curMinCursor;
    private List<sd0.a> curVideoList;
    private Boolean hasMore;
    private final int type;
    private MutableLiveData<ud0.b> viewEvent;

    public static final class a<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LiveVideoCommentSelectPanelVideoListViewModel f71628a;

        public a(LiveVideoCommentSelectPanelVideoListViewModel r100) {
            this.f71628a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            LiveVideoCommentSelectPanelVideoListViewModel.access$fetchVideoListSuccess(this.f71628a, (sd0.b) ((Response) r100).data);
        }
    }

    public static final class b<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LiveVideoCommentSelectPanelVideoListViewModel f71629a;

        public b(LiveVideoCommentSelectPanelVideoListViewModel r100) {
            this.f71629a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            Throwable r101 = (Throwable) r100;
            if (LiveVideoCommentSelectPanelVideoListViewModel.access$getCurVideoList$p(this.f71629a).isEmpty() == false) goto L5;
            this.f71629a.getViewEvent().setValue(ud0.b.e.f549711a);
            return;
        L5:
            this.f71629a.getViewEvent().setValue(new ud0.b.a(r101));
        }
    }

    @Override // androidx.lifecycle.ViewModel
    public void onCleared() {
        super.onCleared();
        this.compositeDisposable.dispose();
    }

    public final MutableLiveData<ud0.b> getViewEvent() {
        return this.viewEvent;
    }

    public LiveVideoCommentSelectPanelVideoListViewModel(int r100) {
        this.type = r100;
        this.viewEvent = new MutableLiveData();
        this.compositeDisposable = new CompositeDisposable();
        this.hasMore = Boolean.TRUE;
        this.curVideoList = new ArrayList();
    }

    public static final /* synthetic */ List access$getCurVideoList$p(LiveVideoCommentSelectPanelVideoListViewModel r100) {
        return r100.curVideoList;
    }

    private final void fetchNextVideoList(ud0.a.C7860a r100) {
        if (r100.f549705a == false) goto L9;
        if (r100.f549706b == false) goto L7;
        this.curMinCursor = null;
        this.curMaxCursor = null;
    L7:
        this.hasMore = Boolean.TRUE;
        this.curVideoList.clear();
        this.viewEvent.setValue(ud0.b.d.f549710a);
    L9:
        if (this.curMaxCursor != null) goto L11;
        int r101 = ((Number) k.f556329i.getValue(null, k.f556321a[7])).intValue();
    L12:
        int r102 = r101;
        IMiddleWareHostContext r103 = (IMiddleWareHostContext) jc1.k.f(IMiddleWareHostContext.class);
        if (r103 == null) goto L15;
        boolean r104 = r103.isNeedProtectUnderage();
    L16:
        Disposable r105 = ((LiveVideoCommentApi) c.b().e(LiveVideoCommentApi.class)).videoList(this.type, this.curMaxCursor, this.curMinCursor, r102, r104, "webcast_share_video").compose(RxUtil.rxSchedulerHelper()).subscribe(new a(this), new b(this));
        if (r105 == null) goto L20;
        RxUtilKt.c(r105, this.compositeDisposable);
        return;
    L20:
        return;
    L15:
        r104 = false;
        goto L16
    L11:
        r101 = ((Number) k.f556330j.getValue(null, k.f556321a[8])).intValue();
        goto L12
    }

    private final void fetchVideoListSuccess(sd0.b r100) {
        this.curMaxCursor = r100.b();
        this.curMinCursor = r100.c();
        this.hasMore = r100.a();
        List<sd0.a> r101 = r100.d();
        if (r101 == null) goto L9;
        if (r101.isEmpty() == true) goto L9;
        this.curVideoList.addAll(r101);
        this.viewEvent.setValue(new ud0.b.C7861b(r100));
        return;
    L9:
        if (this.curVideoList.isEmpty() == true) goto L11;
        this.viewEvent.setValue(new ud0.b.C7861b(r100));
        return;
    L11:
        if (Intrinsics.areEqual(this.hasMore, Boolean.FALSE) == false) goto L13;
        this.viewEvent.setValue(ud0.b.c.f549709a);
        return;
    L13:
        this.viewEvent.setValue(ud0.b.e.f549711a);
    }

    public final void doAction(ud0.a r100) {
        Intrinsics.checkNotNullParameter(r100, "viewAction");
        if ((r100 instanceof ud0.a.C7860a) == false) goto L6;
        fetchNextVideoList((ud0.a.C7860a) r100);
        return;
    }

    public final void setViewEvent(MutableLiveData<ud0.b> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.viewEvent = r100;
    }

    public static final /* synthetic */ void access$fetchVideoListSuccess(LiveVideoCommentSelectPanelVideoListViewModel r100, sd0.b r101) {
        r100.fetchVideoListSuccess(r101);
    }

    public static final /* synthetic */ void access$setCurVideoList$p(LiveVideoCommentSelectPanelVideoListViewModel r100, List r101) {
        r100.curVideoList = r101;
    }
}
