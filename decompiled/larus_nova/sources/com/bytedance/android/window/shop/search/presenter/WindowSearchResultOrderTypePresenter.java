package com.bytedance.android.window.shop.search.presenter;

import androidx.fragment.app.Fragment;
import com.bytedance.android.ec.window.base.shop.ECWindowSortBarBasePresenter;
import com.bytedance.android.window.shop.search.viewmodel.WindowSearchFragmentProductViewModel;
import com.bytedance.ies.sdk.widgets.api.WidgetService;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class WindowSearchResultOrderTypePresenter extends ECWindowSortBarBasePresenter {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final /* synthetic */ int f189699o = 0;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Lazy f189700j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f189701k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final a f189702l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final b f189703m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final c f189704n;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ WindowSearchResultOrderTypePresenter f189705a;

        public a(WindowSearchResultOrderTypePresenter r100) {
            this.f189705a = r100;
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ WindowSearchResultOrderTypePresenter f189706a;

        public b(WindowSearchResultOrderTypePresenter r100) {
            this.f189706a = r100;
        }
    }

    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ WindowSearchResultOrderTypePresenter f189707a;

        public c(WindowSearchResultOrderTypePresenter r100) {
            this.f189707a = r100;
        }
    }

    public final WindowSearchFragmentProductViewModel e0() {
        return (WindowSearchFragmentProductViewModel) this.f189700j.getValue();
    }

    public WindowSearchResultOrderTypePresenter(Fragment r100) {
        Intrinsics.checkNotNullParameter(r100, WidgetService.PARAM_FRAGMENT);
        super(r100);
        this.f189700j = LazyKt.lazy(new WindowSearchResultOrderTypePresenter$viewModel$2(this));
        this.f189702l = new a(this);
        this.f189703m = new b(this);
        this.f189704n = new c(this);
    }
}
