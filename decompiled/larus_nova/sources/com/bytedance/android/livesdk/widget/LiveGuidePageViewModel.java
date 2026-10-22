package com.bytedance.android.livesdk.widget;

import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.live.datacontext.DataContext;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0010\u0018\u0000 32\u00020\u0001:\u00014B\u0007¢\u0006\u0004\b1\u00102J&\u0010\b\u001a\u00020\u0007*\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00022\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0002J\u0012\u0010\u000b\u001a\u00020\u00072\b\b\u0002\u0010\n\u001a\u00020\tH\u0002J\b\u0010\f\u001a\u00020\u0007H\u0002J\b\u0010\r\u001a\u0004\u0018\u00010\u0003J\u001e\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u000e2\u000e\u0010\u0011\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0010J\u0018\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005J\u000e\u0010\u0016\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u0014J\u0006\u0010\u0017\u001a\u00020\u0007J\u0006\u0010\u0018\u001a\u00020\u0007J\u0006\u0010\u0019\u001a\u00020\u0007J\u000e\u0010\u001c\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u001aJ\u0006\u0010\u001d\u001a\u00020\u0007R\u0014\u0010\u001f\u001a\u00020\u001e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u001e\u0010!\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b!\u0010\"R\u0018\u0010#\u001a\u0004\u0018\u00010\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b#\u0010$R\u0018\u0010&\u001a\u0004\u0018\u00010%8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b&\u0010'R\u0018\u0010(\u001a\u0004\u0018\u00010\u00038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b(\u0010)R\u0018\u0010*\u001a\u0004\u0018\u00010\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b*\u0010$R#\u00100\u001a\n +*\u0004\u0018\u00010\t0\t8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b,\u0010-\u001a\u0004\b.\u0010/¨\u00065"}, d2 = {"Lcom/bytedance/android/livesdk/widget/LiveGuidePageViewModel;", "Lcom/bytedance/live/datacontext/DataContext;", "Landroidx/lifecycle/MutableLiveData;", "Lcom/bytedance/android/livesdk/widget/z;", "info", "Lcom/bytedance/android/livesdk/widget/g0;", "pageListener", "", "postGuideInfoWithCheck", "", "isShowing", "postGuideStatus", "checkWaitingGuideInfo", "getGuideInfo", "Landroidx/lifecycle/LifecycleOwner;", "owner", "Lcom/ss/android/ugc/aweme/compat/nullable/Observer;", "observer", "observeGuideInfo", "insertGuideInfo", "", "delay", "countdown", "onGuideShow", "onGuidePrepareGone", "onGuideGone", "", "errorMsg", "onGuideLoadError", "onGuideLoadErrorComplete", "Lio/reactivex/disposables/CompositeDisposable;", "cd", "Lio/reactivex/disposables/CompositeDisposable;", "guideInfo", "Landroidx/lifecycle/MutableLiveData;", "guidePageListener", "Lcom/bytedance/android/livesdk/widget/g0;", "Lio/reactivex/disposables/Disposable;", "timerDisposable", "Lio/reactivex/disposables/Disposable;", "waitingGuideInfo", "Lcom/bytedance/android/livesdk/widget/z;", "waitingGuidePageListener", "kotlin.jvm.PlatformType", "enableNotify$delegate", "Lkotlin/Lazy;", "getEnableNotify", "()Ljava/lang/Boolean;", "enableNotify", "<init>", "()V", "Companion", "b", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveGuidePageViewModel extends DataContext {
    public static final b Companion = null;
    private static final String TAG = null;

    /* JADX INFO: renamed from: cd, reason: collision with root package name */
    private final CompositeDisposable f160990cd;
    private final Lazy enableNotify$delegate;
    private MutableLiveData<z> guideInfo;
    private g0 guidePageListener;
    private Disposable timerDisposable;
    private z waitingGuideInfo;
    private g0 waitingGuidePageListener;

    public static final class a implements Action {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LiveGuidePageViewModel f160991a;

        public a(LiveGuidePageViewModel r100) {
            this.f160991a = r100;
        }

        @Override // io.reactivex.functions.Action
        public final void run() {
            ALogger.d(LiveGuidePageViewModel.access$getTAG$cp(), "viewModel onCleared");
            Disposable r100 = LiveGuidePageViewModel.access$getTimerDisposable$p(this.f160991a);
            if (r100 == null) goto L5;
            r100.dispose();
        L5:
            LiveGuidePageViewModel.access$getCd$p(this.f160991a).clear();
            LiveGuidePageViewModel.m8270access$onCleared$s179125691(this.f160991a);
        }
    }

    public static final class b {
        public b() {
        }
    }

    public static final class c<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LiveGuidePageViewModel f160992a;

        public c(LiveGuidePageViewModel r100) {
            this.f160992a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            Long r101 = (Long) r100;
            if (LiveGuidePageViewModel.access$getGuideInfo$p(this.f160992a) != null) goto L5;
            LiveGuidePageViewModel.access$setGuideInfo$p(this.f160992a, new MutableLiveData());
        L5:
            MutableLiveData r102 = LiveGuidePageViewModel.access$getGuideInfo$p(this.f160992a);
            if (r102 == null) goto L9;
            r102.postValue(null);
            return;
        }
    }

    private final Boolean getEnableNotify() {
        return (Boolean) this.enableNotify$delegate.getValue();
    }

    static {
        Companion = new b();
        TAG = "LiveGuidePage";
    }

    private final void checkWaitingGuideInfo() {
        if (this.waitingGuideInfo == null) goto L12;
        ALogger.d(TAG, "waiting guide page  is not null");
        this.guidePageListener = this.waitingGuidePageListener;
        if (this.guideInfo != null) goto L7;
        this.guideInfo = new MutableLiveData();
    L7:
        MutableLiveData<z> r100 = this.guideInfo;
        if (r100 == null) goto L10;
        r100.postValue(this.waitingGuideInfo);
    L10:
        this.waitingGuideInfo = null;
        this.waitingGuidePageListener = null;
        return;
    }

    public final z getGuideInfo() {
        MutableLiveData<z> r100 = this.guideInfo;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getValue();
    }

    public final void onGuideGone() {
        g0 r100 = this.guidePageListener;
        if (r100 == null) goto L5;
        r100.d();
    L5:
        Disposable r101 = this.timerDisposable;
        if (r101 == null) goto L8;
        r101.dispose();
    L8:
        checkWaitingGuideInfo();
        postGuideStatus$default(this, false, 1, null);
    }

    public final void onGuideLoadErrorComplete() {
        Disposable r100 = this.timerDisposable;
        if (r100 == null) goto L5;
        r100.dispose();
    L5:
        checkWaitingGuideInfo();
    }

    public final void onGuidePrepareGone() {
        if (this.guideInfo != null) goto L5;
        this.guideInfo = new MutableLiveData();
    L5:
        g0 r100 = this.guidePageListener;
        if (r100 == null) goto L8;
        r100.a();
    L8:
        MutableLiveData<z> r101 = this.guideInfo;
        if (r101 == null) goto L11;
        r101.postValue(null);
    L11:
        postGuideStatus$default(this, false, 1, null);
    }

    public final void onGuideShow() {
        g0 r100 = this.guidePageListener;
        if (r100 == null) goto L5;
        r100.c();
    L5:
        postGuideStatus(true);
    }

    public LiveGuidePageViewModel() {
        CompositeDisposable r100 = new CompositeDisposable();
        this.f160990cd = r100;
        this.enableNotify$delegate = LazyKt.lazy(LiveGuidePageViewModel$enableNotify$2.INSTANCE);
        Disposable r101 = getOnCleared().subscribe(new a(this));
        if (r101 == null) goto L6;
        r100.add(r101);
        return;
    }

    public static final /* synthetic */ String access$getTAG$cp() {
        return TAG;
    }

    public static final /* synthetic */ CompositeDisposable access$getCd$p(LiveGuidePageViewModel r100) {
        return r100.f160990cd;
    }

    public static final /* synthetic */ MutableLiveData access$getGuideInfo$p(LiveGuidePageViewModel r100) {
        return r100.guideInfo;
    }

    public static final /* synthetic */ Disposable access$getTimerDisposable$p(LiveGuidePageViewModel r100) {
        return r100.timerDisposable;
    }

    /* JADX INFO: renamed from: access$onCleared$s-179125691, reason: not valid java name */
    public static final /* synthetic */ void m8270access$onCleared$s179125691(LiveGuidePageViewModel r100) {
        super.onCleared();
    }

    private final void postGuideStatus(boolean r100) {
        if (getEnableNotify().booleanValue() == false) goto L6;
        xs2.b.a().post(new d1(r100));
        return;
    }

    public final void countdown(long r100) {
        Observable<Long> r101 = Observable.timer(r100, TimeUnit.SECONDS).observeOn(AndroidSchedulers.mainThread());
        if (r101 == null) goto L5;
        Disposable r102 = r101.subscribe(new c(this));
    L6:
        this.timerDisposable = r102;
        return;
    L5:
        r102 = null;
        goto L6
    }

    public final void onGuideLoadError(String r100) {
        Intrinsics.checkNotNullParameter(r100, "errorMsg");
        ALogger.e(TAG, "guide page load error : " + r100);
        g0 r101 = this.guidePageListener;
        if (r101 == null) goto L6;
        r101.b(r100);
    L6:
        if (this.guideInfo != null) goto L8;
        this.guideInfo = new MutableLiveData();
    L8:
        postGuideStatus$default(this, false, 1, null);
        MutableLiveData<z> r102 = this.guideInfo;
        if (r102 == null) goto L12;
        r102.postValue(null);
        return;
    }

    public static final /* synthetic */ void access$setGuideInfo$p(LiveGuidePageViewModel r100, MutableLiveData r101) {
        r100.guideInfo = r101;
    }

    public static final /* synthetic */ void access$setTimerDisposable$p(LiveGuidePageViewModel r100, Disposable r101) {
        r100.timerDisposable = r101;
    }

    public final void insertGuideInfo(z r100, g0 r101) {
        Intrinsics.checkNotNullParameter(r100, "info");
        if (this.guideInfo != null) goto L5;
        this.guideInfo = new MutableLiveData();
    L5:
        postGuideInfoWithCheck(this.guideInfo, r100, r101);
    }

    public final void observeGuideInfo(LifecycleOwner r100, Observer<z> r101) {
        Intrinsics.checkNotNullParameter(r100, "owner");
        Intrinsics.checkNotNullParameter(r101, "observer");
        if (this.guideInfo != null) goto L5;
        this.guideInfo = new MutableLiveData();
    L5:
        MutableLiveData<z> r102 = this.guideInfo;
        if (r102 == null) goto L9;
        r102.observe(r100, r101);
        return;
    }

    private final void postGuideInfoWithCheck(MutableLiveData<z> r100, z r101, g0 r102) {
        MutableLiveData<z> r103 = this.guideInfo;
        z r104 = null;
        if (r103 == null) goto L5;
        z r105 = r103.getValue();
    L6:
        if (r105 == null) goto L14;
        MutableLiveData<z> r106 = this.guideInfo;
        if (r106 == null) goto L14;
        z r107 = r106.getValue();
        if (r107 == null) goto L14;
        if (r107.equals(r101) != true) goto L14;
        return;
    L14:
        MutableLiveData<z> r108 = this.guideInfo;
        if (r108 == null) goto L17;
        r104 = r108.getValue();
    L17:
        if (r104 == null) goto L20;
        this.waitingGuideInfo = r101;
        this.waitingGuidePageListener = r102;
        return;
    L20:
        if (this.guideInfo != null) goto L22;
        this.guideInfo = new MutableLiveData();
    L22:
        this.guidePageListener = r102;
        MutableLiveData<z> r109 = this.guideInfo;
        if (r109 == null) goto L27;
        r109.postValue(r101);
        return;
    L27:
        return;
    L5:
        r105 = null;
        goto L6
    }

    public static /* synthetic */ void postGuideStatus$default(LiveGuidePageViewModel r100, boolean r101, int r102, Object r103) {
        if ((r102 & 1) == 0) goto L5;
        r101 = false;
    L5:
        r100.postGuideStatus(r101);
    }
}
