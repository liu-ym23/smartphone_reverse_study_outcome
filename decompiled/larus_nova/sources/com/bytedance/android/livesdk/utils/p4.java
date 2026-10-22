package com.bytedance.android.livesdk.utils;

import android.os.Handler;
import android.os.Looper;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdk.chatroom.viewmodule.activity.banner.ActivityTopBannerViewIntent;
import com.bytedance.android.livesdk.chatroom.viewmodule.activity.banner.presenter.TopRightBannerPresenter;
import com.bytedance.android.livesdk.utils.g2;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.live.datacontext.DataContext;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public abstract class p4<INTENT, STATE extends g2> implements b2<INTENT, STATE> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f159114a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final CompositeDisposable f159115b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public a2<? extends DataContext> f159116c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public DataCenter f159117d;

    public static final class a<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f159118a;

        public a(Function1 r100) {
            this.f159118a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(T r100) {
            this.f159118a.invoke(r100);
        }
    }

    public static final class b<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ p4 f159119a;

        public b(p4 r100) {
            this.f159119a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            String r101 = this.f159119a.f159114a;
            ALogger.e(r101, (Throwable) r100);
        }
    }

    public p4() {
        this.f159114a = "MVIWidget";
        this.f159115b = new CompositeDisposable();
    }

    @Override // com.bytedance.android.livesdk.utils.b2
    public final void a(STATE r100) {
        Intrinsics.checkNotNullParameter(r100, "state");
        LiveViewState r101 = (LiveViewState) ((TopRightBannerPresenter) this).f115189m.getValue();
        if (r101.f158762a != null) goto L5;
        r101.f158762a = new Handler(Looper.getMainLooper());
    L5:
        r101.f158762a.post(new LiveViewState.a(r101, r100));
    }

    public final void b(com.bytedance.android.live.core.arch.mvi.widgetcompat.a r100) {
        Intrinsics.checkNotNullParameter(r100, "mviContext");
        this.f159116c = r100;
        this.f159117d = r100.f64751a.dataCenter;
    }

    public final void c(ActivityTopBannerViewIntent r100) {
        Intrinsics.checkNotNullParameter(r100, "intent");
        TopRightBannerPresenter r101 = (TopRightBannerPresenter) this;
        Intrinsics.checkNotNullParameter(r100, "intent");
        if ((r100 instanceof ActivityTopBannerViewIntent.b) == false) goto L6;
        z40.a r102 = (to1.h) r101.f115186j.getValue();
    L22:
        if (r102 != null) goto L24;
        Intrinsics.checkNotNullParameter(r100, "intent");
        return;
    L24:
        Intrinsics.checkNotNullParameter(this, DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL);
        if (r102.f569887c != null) goto L27;
        r102.f569887c = this;
    L27:
        a2<? extends DataContext> r103 = this.f159116c;
        if (r102.f569885a != null) goto L34;
        r102.f569885a = r103;
        if (r103 == null) goto L32;
        DataCenter r104 = r103.getDataCenter();
    L33:
        r102.f569886b = r104;
        goto L34
    L32:
        r104 = null;
    L34:
        r102.a(r100);
        return;
    L6:
        if ((r100 instanceof ActivityTopBannerViewIntent.g) == false) goto L9;
        r102 = (to1.i) r101.f115187k.getValue();
        goto L22
    L9:
        if ((r100 instanceof ActivityTopBannerViewIntent.c) == false) goto L11;
    L21:
        r102 = (to1.a) r101.f115188l.getValue();
        goto L22
    L11:
        if ((r100 instanceof ActivityTopBannerViewIntent.a) == true) goto L21;
        if ((r100 instanceof ActivityTopBannerViewIntent.d) == true) goto L21;
        if ((r100 instanceof ActivityTopBannerViewIntent.f) == true) goto L21;
        if ((r100 instanceof ActivityTopBannerViewIntent.e) == true) goto L21;
        throw new NoWhenBranchMatchedException();
    }

    public final <T> void d(Class<T> r100, Function1<? super T, Unit> r101) {
        Intrinsics.checkNotNullParameter(r100, "classT");
        Intrinsics.checkNotNullParameter(r101, "consumer");
        Disposable r102 = xs2.b.a().b(r100).observeOn(AndroidSchedulers.mainThread()).subscribe(new a(r101), new b(this));
        this.f159115b.add(r102);
    }
}
