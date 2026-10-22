package com.bytedance.android.livesdk.linkvideo;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.network.response.Response;
import com.bytedance.android.livehostapi.foundation.IMiddleWareHostContext;
import com.bytedance.android.livesdk.l3;
import com.bytedance.android.livesdk.m3;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.List;
import jc1.k;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010&\u001a\u00020%¢\u0006\u0004\b(\u0010)J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u000e\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tJ\u0006\u0010\f\u001a\u00020\u0004J\b\u0010\r\u001a\u00020\u0004H\u0014J\u0006\u0010\u000e\u001a\u00020\u0004R(\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u00178\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0018\u0010\u001b\u001a\u0004\u0018\u00010\u001a8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0018\u0010\u001d\u001a\u0004\u0018\u00010\u001a8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001d\u0010\u001cR\u0018\u0010\u001f\u001a\u0004\u0018\u00010\u001e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u001c\u0010#\u001a\b\u0012\u0004\u0012\u00020\"0!8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b#\u0010$R\u0014\u0010&\u001a\u00020%8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b&\u0010'¨\u0006*"}, d2 = {"Lcom/bytedance/android/livesdk/linkvideo/AnchorLinkVideoListViewModel;", "Landroidx/lifecycle/ViewModel;", "Lcom/bytedance/android/livesdk/linkvideo/f$a;", "action", "", "fetchNextVideoList", "Lgf2/b;", "data", "fetchVideoListSuccess", "Lcom/bytedance/android/livesdk/linkvideo/f;", "viewAction", "doAction", "initData", "onCleared", "onDialogDismiss", "Landroidx/lifecycle/MutableLiveData;", "Lcom/bytedance/android/livesdk/linkvideo/g;", "viewEvent", "Landroidx/lifecycle/MutableLiveData;", "getViewEvent", "()Landroidx/lifecycle/MutableLiveData;", "setViewEvent", "(Landroidx/lifecycle/MutableLiveData;)V", "Lio/reactivex/disposables/CompositeDisposable;", "compositeDisposable", "Lio/reactivex/disposables/CompositeDisposable;", "", "curMaxCursor", "Ljava/lang/Long;", "curMinCursor", "", "hasMore", "Ljava/lang/Boolean;", "", "Lgf2/a;", "curVideoList", "Ljava/util/List;", "", "type", "I", "<init>", "(I)V", "room-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AnchorLinkVideoListViewModel extends ViewModel {
    private CompositeDisposable compositeDisposable;
    private Long curMaxCursor;
    private Long curMinCursor;
    private List<gf2.a> curVideoList;
    private Boolean hasMore;
    private final int type;
    private MutableLiveData<g> viewEvent;

    public static final class a<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AnchorLinkVideoListViewModel f147108a;

        public a(AnchorLinkVideoListViewModel r100) {
            this.f147108a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            AnchorLinkVideoListViewModel.access$fetchVideoListSuccess(this.f147108a, (gf2.b) ((Response) r100).data);
        }
    }

    public static final class b<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AnchorLinkVideoListViewModel f147109a;

        public b(AnchorLinkVideoListViewModel r100) {
            this.f147109a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            Throwable r101 = (Throwable) r100;
            if (AnchorLinkVideoListViewModel.access$getCurVideoList$p(this.f147109a).isEmpty() == false) goto L5;
            this.f147109a.getViewEvent().setValue(g.e.f147124a);
            return;
        L5:
            this.f147109a.getViewEvent().setValue(new g.a(r101));
        }
    }

    public final void initData() {
        this.viewEvent = new MutableLiveData();
        this.compositeDisposable = new CompositeDisposable();
        this.curMaxCursor = null;
        this.curMinCursor = null;
        this.hasMore = Boolean.FALSE;
        this.curVideoList = new ArrayList();
    }

    public final void onDialogDismiss() {
        CompositeDisposable r100 = this.compositeDisposable;
        if (r100 == null) goto L6;
        r100.clear();
        return;
    }

    @Override // androidx.lifecycle.ViewModel
    public void onCleared() {
        super.onCleared();
        CompositeDisposable r100 = this.compositeDisposable;
        if (r100 == null) goto L6;
        r100.clear();
        return;
    }

    public final MutableLiveData<g> getViewEvent() {
        return this.viewEvent;
    }

    public AnchorLinkVideoListViewModel(int r100) {
        this.type = r100;
        this.viewEvent = new MutableLiveData();
        this.compositeDisposable = new CompositeDisposable();
        this.hasMore = Boolean.TRUE;
        this.curVideoList = new ArrayList();
    }

    public static final /* synthetic */ List access$getCurVideoList$p(AnchorLinkVideoListViewModel r100) {
        return r100.curVideoList;
    }

    private final void fetchNextVideoList(f.a r100) {
        if (r100.f147118a == false) goto L9;
        if (r100.f147119b == false) goto L7;
        this.curMinCursor = null;
        this.curMaxCursor = null;
    L7:
        this.hasMore = Boolean.TRUE;
        this.curVideoList.clear();
        this.viewEvent.setValue(g.d.f147123a);
    L9:
        if (this.curMaxCursor != null) goto L11;
        Integer r101 = l3.f146987a.getValue();
    L12:
        IMiddleWareHostContext r102 = (IMiddleWareHostContext) k.f(IMiddleWareHostContext.class);
        if (r102 == null) goto L15;
        boolean r103 = r102.isNeedProtectUnderage();
    L16:
        Disposable r104 = ((LinkVideoApi) com.bytedance.android.live.network.c.b().e(LinkVideoApi.class)).videoList(3, this.curMaxCursor, this.curMinCursor, r101.intValue(), r103, "webcast_intro_video").compose(RxUtil.rxSchedulerHelper()).subscribe(new a(this), new b(this));
        if (r104 == null) goto L20;
        RxUtilKt.c(r104, this.compositeDisposable);
        return;
    L20:
        return;
    L15:
        r103 = false;
        goto L16
    L11:
        r101 = m3.f153486a.getValue();
        goto L12
    }

    private final void fetchVideoListSuccess(gf2.b r100) {
        this.curMaxCursor = r100.b();
        this.hasMore = r100.a();
        List<gf2.a> r101 = r100.c();
        if (r101 == null) goto L9;
        if (r101.isEmpty() == true) goto L9;
        this.curVideoList.addAll(r101);
        this.viewEvent.setValue(new g.b(r100));
        return;
    L9:
        if (this.curVideoList.isEmpty() == true) goto L11;
        this.viewEvent.setValue(new g.b(r100));
        return;
    L11:
        if (Intrinsics.areEqual(this.hasMore, Boolean.FALSE) == false) goto L13;
        this.viewEvent.setValue(g.c.f147122a);
        return;
    L13:
        this.viewEvent.setValue(g.e.f147124a);
    }

    public final void doAction(f r100) {
        Intrinsics.checkNotNullParameter(r100, "viewAction");
        if ((r100 instanceof f.a) == false) goto L6;
        fetchNextVideoList((f.a) r100);
        return;
    }

    public final void setViewEvent(MutableLiveData<g> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.viewEvent = r100;
    }

    public static final /* synthetic */ void access$fetchVideoListSuccess(AnchorLinkVideoListViewModel r100, gf2.b r101) {
        r100.fetchVideoListSuccess(r101);
    }

    public static final /* synthetic */ void access$setCurVideoList$p(AnchorLinkVideoListViewModel r100, List r101) {
        r100.curVideoList = r101;
    }
}
