package com.bytedance.android.window.shop.home.presenter;

import android.view.View;
import com.bytedance.android.ec.core.utils.ECQuickUtilKt;
import com.bytedance.android.ec.window.base.common.floatelement.WindowCartEntryConfig;
import com.bytedance.android.window.shop.home.ECWindowDialogFragment;
import com.bytedance.android.window.shop.home.ECWindowParam;
import com.bytedance.android.window.shop.home.tab.WindowTabEventReporter;
import com.bytedance.android.window.shop.home.viewmodel.ECWindowViewModel;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import com.ss.android.ugc.aweme.kiwi.model.QModel;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class ECWindowFloatGoTopPresenter extends AbsWindowFloatPresenter {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Lazy f188358j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Function0<Integer> f188359k;

    public static final class a implements h2 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ECWindowFloatGoTopPresenter f188360a;

        @Override // com.bytedance.android.window.shop.home.presenter.h2
        public final void onHidden() {
        }

        @Override // com.bytedance.android.window.shop.home.presenter.h2
        public final void a() {
            this.f188360a.O().doEventAction("store_show_totop", new Pair[]{TuplesKt.to("page_name", "store_page"), TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_CLICK_AREA, "icon"), TuplesKt.to("author_id", this.f188360a.O().getShopParam().getAuthorId())});
        }

        @Override // com.bytedance.android.window.shop.home.presenter.h2
        public final void onClick() {
            int r100 = WindowTabEventReporter.f188681a;
            ECWindowViewModel r101 = this.f188360a.O();
            ECWindowParam r102 = this.f188360a.O().getShopParam();
            Intrinsics.checkNotNullParameter(r101, "reporter");
            Intrinsics.checkNotNullParameter(r102, "shopParam");
            r101.doEventAction("store_click_totop", WindowTabEventReporter.b(r102), new Pair[0]);
            this.f188360a.O().getGoTopEventReceiver().setValue(new Object());
            this.f188360a.O().getScrollPositionFarEnough().setValue(Boolean.FALSE);
        }

        public a(ECWindowFloatGoTopPresenter r100) {
            this.f188360a = r100;
        }
    }

    public static final class b implements i2 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ECWindowFloatGoTopPresenter f188361a;

        @Override // com.bytedance.android.window.shop.home.presenter.i2
        public final void c(View r100) {
        }

        @Override // com.bytedance.android.window.shop.home.presenter.i2
        public final zn.a<WindowCartEntryConfig> e() {
            return null;
        }

        @Override // com.bytedance.android.window.shop.home.presenter.i2
        public final zn.b a() {
            return this.f188361a.O().getScrollState();
        }

        @Override // com.bytedance.android.window.shop.home.presenter.i2
        public final zn.b b() {
            return this.f188361a.O().getSelectedTabLocation();
        }

        @Override // com.bytedance.android.window.shop.home.presenter.i2
        public final int d() {
            return this.f188361a.f188359k.invoke().intValue();
        }

        @Override // com.bytedance.android.window.shop.home.presenter.i2
        public final zn.b f() {
            zn.b<Pair<Integer, Integer>> r100 = this.f188361a.O().getOffsetState();
            if (r100 == null) goto L6;
            return r100;
        L6:
            throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.ec.window.base.common.livedata.ECWindowLiveData<kotlin.Any>");
        }

        public b(ECWindowFloatGoTopPresenter r100) {
            this.f188361a = r100;
        }
    }

    public static final class c<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ECWindowFloatGoTopPresenter f188362a;

        public c(ECWindowFloatGoTopPresenter r100) {
            this.f188362a = r100;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r100) {
            Boolean r101 = (Boolean) r100;
            this.f188362a.N();
        }
    }

    public final ECWindowViewModel O() {
        return (ECWindowViewModel) this.f188358j.getValue();
    }

    @Override // com.bytedance.android.window.shop.home.presenter.AbsWindowFloatPresenter
    public final h2 E() {
        return new a(this);
    }

    @Override // com.bytedance.android.window.shop.home.presenter.AbsWindowFloatPresenter
    public final i2 F() {
        return new b(this);
    }

    @Override // com.bytedance.android.window.shop.home.presenter.AbsWindowFloatPresenter
    public final boolean D() {
        Boolean r100 = O().getScrollPositionFarEnough().getValue();
        if (r100 != null) goto L7;
        return false;
    L7:
        return r100.booleanValue();
    }

    public ECWindowFloatGoTopPresenter(Function0<Integer> r100) {
        Intrinsics.checkNotNullParameter(r100, "getViewHeight");
        this.f188359k = r100;
        this.f188358j = LazyKt.lazy(new ECWindowFloatGoTopPresenter$shopViewModel$2(this));
    }

    @Override // com.bytedance.android.window.shop.home.presenter.AbsWindowFloatPresenter, com.ss.android.ugc.aweme.kiwi.presenter.QPresenter
    public final void A(QModel r100) {
        this.f188260e = ECQuickUtilKt.b(u(), ECWindowDialogFragment.class);
        super.A(r100);
        O().getScrollPositionFarEnough().a(I(), new c(this), false);
    }
}
