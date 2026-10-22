package com.bytedance.android.window.shop.home.presenter;

import android.view.View;
import com.bytedance.android.ec.core.utils.ECQuickUtilKt;
import com.bytedance.android.ec.window.base.common.floatelement.WindowCartEntryConfig;
import com.bytedance.android.window.shop.home.ECWindowDialogFragment;
import com.bytedance.android.window.shop.home.viewmodel.ECWindowViewModel;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import com.ss.android.ugc.aweme.kiwi.model.QModel;
import java.lang.ref.WeakReference;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes14.dex */
public final class ECWindowFloatCartEntryPresenter extends AbsWindowFloatPresenter {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Lazy f188353j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Function0<Integer> f188354k;

    public static final class a implements h2 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ECWindowFloatCartEntryPresenter f188355a;

        @Override // com.bytedance.android.window.shop.home.presenter.h2
        public final void onHidden() {
        }

        @Override // com.bytedance.android.window.shop.home.presenter.h2
        public final void a() {
            ECWindowFloatCartEntryPresenter.O(this.f188355a).doEventAction("show_cart_entrance", new Pair[]{TuplesKt.to("page_name", "store_page"), TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_CLICK_AREA, "icon"), TuplesKt.to("author_id", ECWindowFloatCartEntryPresenter.O(this.f188355a).getShopParam().getAuthorId())});
        }

        @Override // com.bytedance.android.window.shop.home.presenter.h2
        public final void onClick() {
            ECWindowFloatCartEntryPresenter.O(this.f188355a).doEventAction("click_cart_entrance", new Pair[]{TuplesKt.to("page_name", "store_page"), TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_CLICK_AREA, "icon"), TuplesKt.to("author_id", ECWindowFloatCartEntryPresenter.O(this.f188355a).getShopParam().getAuthorId())});
        }

        public a(ECWindowFloatCartEntryPresenter r100) {
            this.f188355a = r100;
        }
    }

    public static final class b implements i2 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ECWindowFloatCartEntryPresenter f188356a;

        @Override // com.bytedance.android.window.shop.home.presenter.i2
        public final zn.b a() {
            return ECWindowFloatCartEntryPresenter.O(this.f188356a).getScrollState();
        }

        @Override // com.bytedance.android.window.shop.home.presenter.i2
        public final zn.b b() {
            return ECWindowFloatCartEntryPresenter.O(this.f188356a).getSelectedTabLocation();
        }

        @Override // com.bytedance.android.window.shop.home.presenter.i2
        public final int d() {
            return this.f188356a.f188354k.invoke().intValue();
        }

        @Override // com.bytedance.android.window.shop.home.presenter.i2
        public final zn.a<WindowCartEntryConfig> e() {
            return ECWindowFloatCartEntryPresenter.O(this.f188356a).getCartEntryConfig();
        }

        @Override // com.bytedance.android.window.shop.home.presenter.i2
        public final zn.b f() {
            zn.b<Pair<Integer, Integer>> r100 = ECWindowFloatCartEntryPresenter.O(this.f188356a).getOffsetState();
            if (r100 == null) goto L6;
            return r100;
        L6:
            throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.ec.window.base.common.livedata.ECWindowLiveData<kotlin.Any>");
        }

        public b(ECWindowFloatCartEntryPresenter r100) {
            this.f188356a = r100;
        }

        @Override // com.bytedance.android.window.shop.home.presenter.i2
        public final void c(View r100) {
            ECWindowFloatCartEntryPresenter.O(this.f188356a).getDestView().setValue(new WeakReference(r100));
        }
    }

    public static final class c<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ECWindowFloatCartEntryPresenter f188357a;

        public c(ECWindowFloatCartEntryPresenter r100) {
            this.f188357a = r100;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r100) {
            WindowCartEntryConfig r101 = (WindowCartEntryConfig) r100;
            ECWindowFloatCartEntryPresenter r102 = this.f188357a;
            boolean r103 = false;
            if (r101 == null) goto L13;
            String r104 = r101.getJumpUrl();
            if (r104 != null) goto L7;
        L10:
            boolean r105 = true;
        L11:
            if (r105 == true) goto L13;
            r103 = true;
            goto L13
        L7:
            if (StringsKt.isBlank(r104) == true) goto L10;
            r105 = false;
        L13:
            r102.f188263h = Boolean.valueOf(r103);
            Boolean r106 = this.f188357a.f188263h;
            Intrinsics.checkNotNull(r106);
            if (r106.booleanValue() == false) goto L17;
            this.f188357a.N();
            this.f188357a.y().setOnClickListener(new u0(this, r101));
            return;
        }
    }

    @Override // com.bytedance.android.window.shop.home.presenter.AbsWindowFloatPresenter
    public final boolean D() {
        return true;
    }

    @Override // com.bytedance.android.window.shop.home.presenter.AbsWindowFloatPresenter
    public final h2 E() {
        return new a(this);
    }

    @Override // com.bytedance.android.window.shop.home.presenter.AbsWindowFloatPresenter
    public final i2 F() {
        return new b(this);
    }

    public ECWindowFloatCartEntryPresenter(Function0<Integer> r100) {
        Intrinsics.checkNotNullParameter(r100, "getViewHeight");
        this.f188354k = r100;
        this.f188353j = LazyKt.lazy(new ECWindowFloatCartEntryPresenter$viewModel$2(this));
    }

    public static final ECWindowViewModel O(ECWindowFloatCartEntryPresenter r100) {
        return (ECWindowViewModel) r100.f188353j.getValue();
    }

    @Override // com.bytedance.android.window.shop.home.presenter.AbsWindowFloatPresenter, com.ss.android.ugc.aweme.kiwi.presenter.QPresenter
    public final void A(QModel r100) {
        this.f188260e = ECQuickUtilKt.b(u(), ECWindowDialogFragment.class);
        super.A(r100);
        zn.a<WindowCartEntryConfig> r101 = G().e();
        if (r101 == null) goto L6;
        r101.a(I(), new c(this), false);
        return;
    }

    @Override // com.bytedance.android.window.shop.home.presenter.AbsWindowFloatPresenter
    public final void K(int r100) {
        if (r100 != 0) goto L4;
        G().c(y());
        return;
    L4:
        G().c(null);
    }
}
