package com.bytedance.android.window.shop.innerflow.holder.element.presenter;

import android.graphics.Rect;
import android.view.View;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.ec.core.utils.ECQuickUtilKt;
import com.bytedance.android.ec.core.utils.l0;
import com.bytedance.android.ec.sdk.helper.p;
import com.bytedance.android.ec.window.base.utils.playable.WindowPlayAbleType;
import com.bytedance.android.window.shop.innerflow.ECWindowInnerFlowViewModel;
import com.bytedance.android.window.shop.innerflow.holder.element.commentlist.CommentListAdapter;
import com.ss.android.ugc.aweme.kiwi.presenter.QContext;
import com.ttnet.org.chromium.base.BaseSwitches;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class ECWindowInnerFlowHotCommentElementPresenter extends d<wp3.b> implements tp.c, View.OnClickListener {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Lazy f189094g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Lazy f189095h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Lazy f189096i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final CommentListAdapter f189097j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public wp3.b f189098k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Lazy f189099l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public tp.b f189100m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public Disposable f189101n;

    public static final class a<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ECWindowInnerFlowHotCommentElementPresenter f189102a;

        public a(ECWindowInnerFlowHotCommentElementPresenter r100) {
            this.f189102a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            Long r101 = (Long) r100;
            ECWindowInnerFlowHotCommentElementPresenter r102 = this.f189102a;
            r102.F().smoothScrollBy(0, r102.F().getMeasuredHeight());
        }
    }

    public static final class b<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f189103a = null;

        static {
            f189103a = new b();
        }

        public b() {
        }

        @Override // io.reactivex.functions.Consumer
        public final /* bridge */ /* synthetic */ void accept(Object r100) {
            Throwable r101 = (Throwable) r100;
        }
    }

    public static final class c implements Action {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c f189104a = null;

        static {
            f189104a = new c();
        }

        public c() {
        }

        @Override // io.reactivex.functions.Action
        public final void run() {
        }
    }

    @Override // tp.c
    public final boolean D3() {
        return true;
    }

    public final RecyclerView F() {
        return (RecyclerView) this.f189094g.getValue();
    }

    @Override // tp.c
    public final Rect r() {
        return null;
    }

    @Override // tp.c
    public final void B() {
        Disposable r100 = this.f189101n;
        if (r100 == null) goto L5;
        r100.dispose();
    L5:
        this.f189101n = null;
    }

    @Override // com.bytedance.android.window.shop.innerflow.holder.element.presenter.d
    public final void E() {
        Disposable r100 = this.f189101n;
        if (r100 == null) goto L5;
        r100.dispose();
    L5:
        this.f189098k = null;
        ((TextView) this.f189095h.getValue()).setText("");
        CommentListAdapter r101 = this.f189097j;
        r101.getClass();
        r101.f189060a = CollectionsKt.emptyList();
        r101.notifyDataSetChanged();
    }

    @Override // tp.c
    public final void R() {
        Disposable r100 = this.f189101n;
        if (r100 == null) goto L8;
        if ((!r100.isDisposed()) != true) goto L8;
        return;
    L8:
        if (this.f189097j.getItemCount() > 1) goto L10;
        return;
    L10:
        this.f189101n = com.bytedance.android.ec.core.rxjava.a.b(2, 2, TimeUnit.SECONDS, Schedulers.computation()).subscribeOn(Schedulers.computation()).observeOn(AndroidSchedulers.mainThread()).subscribe(new a(this), b.f189103a, c.f189104a);
    }

    @Override // tp.c
    public final boolean isPlaying() {
        Disposable r100 = this.f189101n;
        if (r100 != null) goto L5;
        return false;
    L5:
        if (r100.isDisposed() == true) goto L9;
        return true;
    L9:
        return false;
    }

    @Override // tp.c
    public final boolean g0() {
        tp.c.a.g(this);
        return true;
    }

    @Override // tp.c
    public final void pausePlay() {
        v();
        M();
    }

    @Override // tp.c
    public final boolean resumePlay() {
        g0();
        U0();
        return true;
    }

    @Override // tp.c
    public final void startPlay() {
        R();
        x();
    }

    @Override // tp.c
    public final void stopPlay() {
        B();
        z();
    }

    @Override // tp.c
    public final void M() {
        tp.c.a.a(this);
    }

    @Override // tp.c
    public final WindowPlayAbleType P() {
        return WindowPlayAbleType.OTHER;
    }

    @Override // tp.c
    public final void U0() {
        tp.c.a.b(this);
    }

    @Override // tp.c
    public final tp.b m() {
        return this.f189100m;
    }

    @Override // tp.c
    public final void v() {
        tp.c.a.h(this);
    }

    @Override // tp.c
    public final void x() {
        tp.c.a.c(this);
    }

    @Override // tp.c
    public final void z() {
        tp.c.a.d(this);
    }

    public ECWindowInnerFlowHotCommentElementPresenter(vp.c r100) {
        Intrinsics.checkNotNullParameter(r100, "hotElementPlayerProxy");
        super(yp3.b.f568700a);
        r100.f556543a = this;
        this.f189094g = LazyKt.lazy(new ECWindowInnerFlowHotCommentElementPresenter$recyclerView$2(this));
        this.f189095h = LazyKt.lazy(new ECWindowInnerFlowHotCommentElementPresenter$tvHotCommentCount$2(this));
        this.f189096i = LazyKt.lazy(new ECWindowInnerFlowHotCommentElementPresenter$btGoToCommentPage$2(this));
        this.f189097j = new CommentListAdapter();
        this.f189099l = LazyKt.lazy(new ECWindowInnerFlowHotCommentElementPresenter$viewModel$2(this));
    }

    @Override // com.bytedance.android.window.shop.innerflow.holder.element.presenter.d
    public final void D(wp3.b r100) {
        wp3.b r101 = r100;
        this.f189098k = r101;
        if (F().getAdapter() != null) goto L5;
        ECWindowInnerFlowViewModel r102 = (ECWindowInnerFlowViewModel) ECQuickUtilKt.c(u(), ECWindowInnerFlowViewModel.class);
        F().setRecycledViewPool(r102.getFlyWeight().f189032c);
        F().setAdapter(this.f189097j);
        RecyclerView r103 = F();
        LinearLayoutManager r104 = new LinearLayoutManager(y().getContext(), 1, false);
        r104.setItemPrefetchEnabled(true);
        r104.setInitialPrefetchItemCount(2);
        Unit r105 = Unit.INSTANCE;
        r103.setLayoutManager(r104);
        new PagerSnapHelper().attachToRecyclerView(F());
        ((TextView) this.f189096i.getValue()).setOnClickListener(this);
    L8:
        if (r101 == null) goto L18;
        ((TextView) this.f189095h.getValue()).setText(r101.f560571b);
        RecyclerView.Adapter r106 = F().getAdapter();
        if ((r106 instanceof CommentListAdapter) == true) goto L12;
        r106 = null;
    L12:
        CommentListAdapter r107 = (CommentListAdapter) r106;
        if (r107 == null) goto L19;
        Intrinsics.checkNotNullParameter(r101, "vo");
        r107.f189060a = r101.f560570a;
        r107.notifyDataSetChanged();
        return;
    L19:
        return;
    L18:
        return;
    L5:
        RecyclerView.Adapter r108 = F().getAdapter();
        if (r108 == null) goto L17;
        CommentListAdapter r109 = (CommentListAdapter) r108;
        r109.f189060a = CollectionsKt.emptyList();
        r109.notifyDataSetChanged();
        goto L8
    L17:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.window.shop.innerflow.holder.element.commentlist.CommentListAdapter");
    }

    @Override // tp.c
    public final List<tp.c> L(Rect r100) {
        Intrinsics.checkNotNullParameter(r100, "visibleArea");
        return CollectionsKt.listOf(this);
    }

    @Override // tp.c
    public final void o2(tp.b r100) {
        this.f189100m = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        Intrinsics.checkNotNullParameter(r100, BaseSwitches.V);
        int r101 = rp.a.f538829a;
        if (rp.a.a(((TextView) this.f189096i.getValue()).getId()) == false) goto L5;
        return;
    L5:
        int r102 = com.bytedance.android.window.shop.innerflow.a.f189038a;
        ECWindowInnerFlowViewModel r103 = (ECWindowInnerFlowViewModel) this.f189099l.getValue();
        Pair[] r104 = new Pair[1];
        fo.b r105 = this.f189144e;
        FragmentActivity r106 = null;
        if (r105 == null) goto L8;
        String r107 = (String) r105.a(vp3.b.f556617d);
    L9:
        if (r107 != null) goto L11;
        r107 = "";
    L11:
        r104[0] = TuplesKt.to("product_id", r107);
        com.bytedance.android.window.shop.innerflow.a.d(r103, "comment", r104);
        wp3.b r108 = this.f189098k;
        if (r108 == null) goto L21;
        p r109 = p.f48130a;
        QContext r110 = u();
        FragmentActivity r111 = l0.c(r110.c());
        if ((r111 instanceof FragmentActivity) == false) goto L17;
        r106 = r111;
    L17:
        if (r106 != null) goto L19;
        r106 = r110.a();
    L19:
        r109.openSchema(r106, r108.f560572c);
        return;
    L21:
        return;
    L8:
        r107 = null;
        goto L9
    }
}
