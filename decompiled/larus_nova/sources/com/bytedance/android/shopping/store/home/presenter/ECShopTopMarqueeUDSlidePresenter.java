package com.bytedance.android.shopping.store.home.presenter;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.graphics.drawable.GradientDrawable;
import android.text.format.DateFormat;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.livesdkapi.LiveCommonConstants;
import com.bytedance.android.shopping.store.marquee.ECStoreTopMultiMarqueeItemVO;
import com.bytedance.android.shopping.store.repository.vo.TabEnum;
import com.bytedance.android.shopping.store.viewmodel.ECStoreViewModel;
import com.bytedance.android.ui.ec.widget.photodraweeview.ExtensionsKt;
import com.bytedance.bdlocation.exception.BDLocationException;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import com.ss.android.ugc.aweme.kiwi.model.QModel;
import com.ttnet.org.chromium.base.BaseSwitches;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003:\u0001\bJ\b\u0010\u0005\u001a\u00020\u0004H\u0007J\b\u0010\u0006\u001a\u00020\u0004H\u0007J\b\u0010\u0007\u001a\u00020\u0004H\u0007¨\u0006\t"}, d2 = {"Lcom/bytedance/android/shopping/store/home/presenter/ECShopTopMarqueeUDSlidePresenter;", "Lcom/bytedance/android/shopping/store/home/presenter/ECShopBasePresenter;", "Landroid/view/View$OnClickListener;", "Landroidx/lifecycle/LifecycleObserver;", "", "onPause", "onResume", LiveCommonConstants.REASON_ON_DEDTROY, BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECShopTopMarqueeUDSlidePresenter extends ECShopBasePresenter implements View.OnClickListener, LifecycleObserver {
    public static final /* synthetic */ int I = 0;
    public ij3.b A;
    public ECStoreTopMultiMarqueeItemVO B;
    public Disposable C;
    public Disposable D;
    public int E;
    public boolean F;
    public final m G;
    public final g H;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public View f184064u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public View f184065v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final List<SimpleDraweeView> f184066w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public TextView f184067x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public TextView f184068y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public ImageView f184069z;

    public static final class a {
    }

    public static final class b<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ECShopTopMarqueeUDSlidePresenter f184070a;

        public b(ECShopTopMarqueeUDSlidePresenter r100) {
            this.f184070a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            nm.a r101 = (nm.a) CollectionsKt.getOrNull((List) r100, 0);
            boolean r102 = true;
            if (r101 == null) goto L9;
            Integer r103 = r101.f519589e;
            if (r103 == null) goto L9;
            if (r103.intValue() < 2) goto L9;
            r102 = false;
        L9:
            if (r102 == false) goto L23;
            final ECShopTopMarqueeUDSlidePresenter r104 = this.f184070a;
            View r105 = r104.f184064u;
            if (r105 == null) goto L13;
            ExtensionsKt.visible(r105);
        L13:
            r104.r0();
            View r106 = r104.f184064u;
            if (r106 == null) goto L16;
            wg.a.f(r106, 0, 0, 0, 0);
        L16:
            Disposable r107 = r104.D;
            if (r107 == null) goto L19;
            r107.dispose();
        L19:
            long r108 = 5000;
            r104.D = r104.t0(r108, r108, new ECShopTopMarqueeUDSlidePresenter$setShowDurationDisposable$1(r104));
            Disposable r109 = r104.C;
            if (r109 == null) goto L22;
            r109.dispose();
        L22:
            long r110 = 6600;
            r104.C = r104.t0(r110, r110, new ECShopTopMarqueeUDSlidePresenter$setTotalDisposable$1(r104));
            return;
        L23:
            ECShopTopMarqueeUDSlidePresenter r111 = this.f184070a;
            int r112 = ECShopTopMarqueeUDSlidePresenter.I;
            r111.v0();
        }
    }

    public static final class c<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c f184071a = null;

        static {
            f184071a = new c();
        }

        public c() {
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            ECExceptionMonitor.e((Throwable) r100);
        }
    }

    public static final class d<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function0 f184072a;

        public d(Function0 r100) {
            this.f184072a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            Long r101 = (Long) r100;
            Function0 r102 = this.f184072a;
            if (r102 == null) goto L6;
            Unit r103 = (Unit) r102.invoke();
            return;
        }
    }

    public static final class e<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final e f184073a = null;

        static {
            f184073a = new e();
        }

        public e() {
        }

        @Override // io.reactivex.functions.Consumer
        public final /* bridge */ /* synthetic */ void accept(Object r100) {
            Throwable r101 = (Throwable) r100;
        }
    }

    public static final class f implements Action {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final f f184074a = null;

        static {
            f184074a = new f();
        }

        public f() {
        }

        @Override // io.reactivex.functions.Action
        public final void run() {
        }
    }

    public static final class g implements Animator.AnimatorListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ECShopTopMarqueeUDSlidePresenter f184075a;

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationCancel(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationRepeat(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationStart(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        }

        public g(ECShopTopMarqueeUDSlidePresenter r100) {
            this.f184075a = r100;
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
            ECShopTopMarqueeUDSlidePresenter r101 = this.f184075a;
            int r102 = ECShopTopMarqueeUDSlidePresenter.I;
            r101.r0();
        }
    }

    public static final class h<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ECShopTopMarqueeUDSlidePresenter f184076a;

        public h(ECShopTopMarqueeUDSlidePresenter r100) {
            this.f184076a = r100;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r100) {
            com.bytedance.android.shopping.store.home.entity.l r101 = (com.bytedance.android.shopping.store.home.entity.l) r100;
            ij3.b r102 = r101.f183743d;
            boolean r103 = true;
            if (r102 == null) goto L14;
            List<ij3.b.C6274b> r104 = r102.f490056a;
            if (r104 != null) goto L7;
        L10:
            boolean r105 = true;
        L11:
            if (r105 == true) goto L14;
            boolean r106 = false;
        L15:
            ECStoreTopMultiMarqueeItemVO r107 = r101.f183744e;
            if (r107 == null) goto L27;
            List<ECStoreTopMultiMarqueeItemVO.b> r108 = r107.f185617a;
            if (r108 != null) goto L20;
        L23:
            boolean r109 = true;
        L24:
            if (r109 == true) goto L27;
            r103 = false;
            goto L27
        L20:
            if (r108.isEmpty() == true) goto L23;
            r109 = false;
        L27:
            if (r106 == false) goto L30;
            if (r103 == false) goto L30;
            return;
        L30:
            ECShopTopMarqueeUDSlidePresenter r110 = this.f184076a;
            if (r110.A != null) goto L35;
            if (r106 == true) goto L35;
            r110.A = r101.f183743d;
        L35:
            if (r110.B != null) goto L39;
            if (r103 == true) goto L40;
            r110.B = r101.f183744e;
            return;
        L40:
            return;
        L39:
            return;
        L7:
            if (r104.isEmpty() == true) goto L10;
            r105 = false;
        L14:
            r106 = true;
            goto L15
        }
    }

    public static final class i<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ECShopTopMarqueeUDSlidePresenter f184077a;

        public i(ECShopTopMarqueeUDSlidePresenter r100) {
            this.f184077a = r100;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r100) {
            Float r101 = (Float) r100;
            ECShopTopMarqueeUDSlidePresenter r102 = this.f184077a;
            if (r102.A != null) goto L7;
            if (r102.B != null) goto L7;
            return;
        L7:
            if (r101.floatValue() < 0) goto L12;
            this.f184077a.s0();
            return;
        }
    }

    public static final class j<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ECShopTopMarqueeUDSlidePresenter f184078a;

        public j(ECShopTopMarqueeUDSlidePresenter r100) {
            this.f184078a = r100;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r100) {
            Float r101 = (Float) r100;
            ECShopTopMarqueeUDSlidePresenter r102 = this.f184078a;
            if (r102.A != null) goto L7;
            if (r102.B != null) goto L7;
            return;
        L7:
            if (r101.floatValue() < 0) goto L12;
            this.f184078a.s0();
            return;
        }
    }

    public static final class k<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ECShopTopMarqueeUDSlidePresenter f184079a;

        public k(ECShopTopMarqueeUDSlidePresenter r100) {
            this.f184079a = r100;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r100) {
            Boolean r101 = (Boolean) r100;
            ECShopTopMarqueeUDSlidePresenter r102 = this.f184079a;
            if (r102.A == null) goto L5;
        L7:
            r102.s0();
            return;
        L5:
            if (r102.B != null) goto L7;
        }
    }

    public static final class l<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ECShopTopMarqueeUDSlidePresenter f184080a;

        public l(ECShopTopMarqueeUDSlidePresenter r100) {
            this.f184080a = r100;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r100) {
            Pair r101 = (Pair) r100;
            ECShopTopMarqueeUDSlidePresenter r102 = this.f184080a;
            if (r102.A == null) goto L5;
        L7:
            r102.s0();
            return;
        L5:
            if (r102.B != null) goto L7;
        }
    }

    public static final class m implements Animator.AnimatorListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ECShopTopMarqueeUDSlidePresenter f184081a;

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationCancel(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationRepeat(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationStart(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        }

        public m(ECShopTopMarqueeUDSlidePresenter r100) {
            this.f184081a = r100;
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
            ECShopTopMarqueeUDSlidePresenter r101 = this.f184081a;
            int r102 = ECShopTopMarqueeUDSlidePresenter.I;
            Disposable r103 = r101.D;
            if (r103 == null) goto L5;
            r103.dispose();
        L5:
            long r104 = 5000;
            r101.D = r101.t0(r104, r104, new ECShopTopMarqueeUDSlidePresenter$setShowDurationDisposable$1(r101));
        }
    }

    static {
    }

    public ECShopTopMarqueeUDSlidePresenter() {
        this(null);
    }

    public final void r0() {
        ij3.b r100 = this.A;
        if (r100 == null) goto L14;
        List<ij3.b.C6274b> r101 = r100.f490056a;
        if (r101 != null) goto L7;
    L10:
        boolean r102 = true;
    L11:
        if (r102 == true) goto L14;
        boolean r103 = false;
    L15:
        ECStoreTopMultiMarqueeItemVO r104 = this.B;
        if (r104 == null) goto L27;
        List<ECStoreTopMultiMarqueeItemVO.b> r105 = r104.f185617a;
        if (r105 != null) goto L20;
    L23:
        boolean r106 = true;
    L24:
        if (r106 == true) goto L27;
        boolean r107 = false;
    L28:
        if (r103 == false) goto L31;
        if (r107 == false) goto L31;
        return;
    L31:
        Iterator r108 = ((ArrayList) this.f184066w).iterator();
    L33:
        if (r108.hasNext() == false) goto L35;
        ExtensionsKt.gone((SimpleDraweeView) r108.next());
        goto L33
    L35:
        String r109 = "";
        String r110 = null;
        if (r107 == false) goto L76;
        ij3.b r111 = this.A;
        if (r111 == null) goto L42;
        List<ij3.b.C6274b> r112 = r111.f490056a;
        if (r112 == null) goto L42;
        int r113 = r112.size();
    L43:
        ij3.b r114 = this.A;
        if (r114 == null) goto L48;
        List<ij3.b.C6274b> r115 = r114.f490056a;
        if (r115 == null) goto L48;
        ij3.b.C6274b r116 = (ij3.b.C6274b) ListProtector.get(r115, this.E % r113);
    L49:
        SimpleDraweeView r117 = (SimpleDraweeView) CollectionsKt.firstOrNull(this.f184066w);
        if (r117 == null) goto L52;
        ExtensionsKt.visible(r117);
    L52:
        if (r117 == null) goto L57;
        if (r116 == null) goto L55;
        ECUrlModel r118 = r116.f490058b;
    L56:
        com.bytedance.android.ec.core.imagex.h0.d(r117, r118, T().getImageCallerContext(), null, null, null, null, 120);
        goto L57
    L55:
        r118 = null;
    L57:
        TextView r119 = this.f184067x;
        if (r119 == null) goto L63;
        if (r116 == null) goto L61;
        String r120 = r116.f490057a;
    L62:
        r119.setText(r120);
        goto L63
    L61:
        r120 = null;
    L63:
        TextView r121 = this.f184068y;
        if (r121 == null) goto L69;
        if (r116 == null) goto L67;
        String r122 = r116.f490059c;
    L68:
        r121.setText(r122);
        goto L69
    L67:
        r122 = null;
    L69:
        if (r116 == null) goto L71;
        r110 = r116.f490059c;
    L71:
        ECStoreViewModel r123 = T();
        Pair<String, String>[] r124 = new Pair[1];
        if (r110 == null) goto L75;
        r109 = r110;
    L75:
        r124[0] = TuplesKt.to("bubble_type", r109);
        r123.doEventAction("buy_info_bubble_show", r124);
        return;
    L48:
        r116 = null;
    L42:
        r113 = 1;
        goto L43
    L76:
        ECStoreTopMultiMarqueeItemVO r125 = this.B;
        if (r125 == null) goto L81;
        List<ECStoreTopMultiMarqueeItemVO.b> r126 = r125.f185617a;
        if (r126 == null) goto L81;
        int r127 = r126.size();
    L82:
        ECStoreTopMultiMarqueeItemVO r128 = this.B;
        if (r128 == null) goto L87;
        List<ECStoreTopMultiMarqueeItemVO.b> r129 = r128.f185617a;
        if (r129 == null) goto L87;
        ECStoreTopMultiMarqueeItemVO.b r130 = (ECStoreTopMultiMarqueeItemVO.b) ListProtector.get(r129, this.E % r127);
    L88:
        if (r130 == null) goto L99;
        List<ECUrlModel> r131 = r130.f185620b;
        if (r131 == null) goto L99;
        int r132 = r131.size();
        int r133 = 0;
    L92:
        if (r133 >= r132) goto L99;
        SimpleDraweeView r134 = (SimpleDraweeView) CollectionsKt.getOrNull(this.f184066w, r133);
        if (r134 == null) goto L96;
        ExtensionsKt.visible(r134);
    L96:
        if (r134 == null) goto L98;
        com.bytedance.android.ec.core.imagex.h0.d(r134, (ECUrlModel) ListProtector.get(r131, r133), T().getImageCallerContext(), null, null, null, null, 120);
    L98:
        r133 = r133 + 1;
    L99:
        TextView r135 = this.f184067x;
        if (r135 == null) goto L105;
        if (r130 == null) goto L103;
        String r136 = r130.f185619a;
    L104:
        r135.setText(r136);
        goto L105
    L103:
        r136 = null;
    L105:
        TextView r137 = this.f184068y;
        if (r137 == null) goto L111;
        if (r130 == null) goto L109;
        String r138 = r130.f185621c;
    L110:
        r137.setText(r138);
        goto L111
    L109:
        r138 = null;
    L111:
        if (r130 == null) goto L113;
        r110 = r130.f185621c;
    L113:
        ECStoreViewModel r139 = T();
        Pair<String, String>[] r140 = new Pair[1];
        if (r110 == null) goto L117;
        r109 = r110;
    L117:
        r140[0] = TuplesKt.to("bubble_type", r109);
        r139.doEventAction("buy_info_bubble_show", r140);
        return;
    L87:
        r130 = null;
    L81:
        r127 = 1;
        goto L82
    L20:
        if (r105.isEmpty() == true) goto L23;
        r106 = false;
    L27:
        r107 = true;
        goto L28
    L7:
        if (r101.isEmpty() == true) goto L10;
        r102 = false;
    L14:
        r103 = true;
        goto L15
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public final void onDestroy() {
        W().getLifecycle().removeObserver(this);
    }

    public final void s0() {
        if (T().isKolShop() == true) goto L5;
    L7:
        float r100 = com.bytedance.android.shopping.extensions.k.e(T().getUpglideFactor().getValue(), 0.0f);
    L8:
        uj3.j r101 = T().getCurrentTab();
        if (r101 != null) goto L11;
    L23:
        boolean r102 = false;
    L24:
        if (r102 == false) goto L26;
        ExtensionsKt.visible(y());
        String r103 = DateFormat.format("yyyy-MM-dd", System.currentTimeMillis()).toString();
        om.a r104 = om.a.f524204a;
        com.bytedance.android.ec.core.async.a.a(bg4.b.b(om.a.a(com.bytedance.android.ec.sdk.helper.r.f48132a.getCurrentUserId(), T().getStoreParam().getSecShopId(), r103)).subscribe(new b(this), c.f184071a), T());
        return;
    L26:
        v0();
        return;
    L11:
        if (r101.f550300d != TabEnum.PRODUCT_TAB.getType()) goto L23;
        if (r100 <= 0.95f) goto L23;
        if (this.F == true) goto L23;
        if (this.A != null) goto L21;
        if (this.B == null) goto L23;
    L21:
        if (Intrinsics.areEqual(T().getCouldShowMarquee().getValue(), Boolean.TRUE) == false) goto L23;
        r102 = true;
        goto L24
    L5:
        if (Intrinsics.areEqual(T().getHasGlobalComponent(), Boolean.FALSE) == false) goto L7;
        r100 = com.bytedance.android.shopping.extensions.k.e(T().getCollapseFactor().getValue(), 0.0f);
        goto L8
    }

    public final void v0() {
        ExtensionsKt.visible(y());
        View r100 = this.f184064u;
        if (r100 == null) goto L5;
        ExtensionsKt.gone(r100);
    L5:
        Disposable r101 = this.C;
        if (r101 == null) goto L8;
        r101.dispose();
    L8:
        Disposable r102 = this.D;
        if (r102 == null) goto L12;
        r102.dispose();
        return;
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    public final void onPause() {
        v0();
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public final void onResume() {
        s0();
    }

    public ECShopTopMarqueeUDSlidePresenter(Fragment r100) {
        super(r100);
        this.f184066w = new ArrayList();
        this.G = new m(this);
        this.H = new g(this);
    }

    @Override // com.ss.android.ugc.aweme.kiwi.presenter.QPresenter
    public final void A(QModel r100) {
        W().getLifecycle().addObserver(this);
        this.f184065v = y().findViewById(R.id.ec_shop_top_marquee_item);
        this.f184064u = y().findViewById(R.id.ec_shop_top_marquee_root_area);
        ((ArrayList) this.f184066w).add(y().findViewById(R.id.marquee_multi_user_logo1));
        ((ArrayList) this.f184066w).add(y().findViewById(R.id.marquee_multi_user_logo2));
        ((ArrayList) this.f184066w).add(y().findViewById(R.id.marquee_multi_user_logo3));
        this.f184067x = (TextView) y().findViewById(R.id.marquee_user_name);
        this.f184068y = (TextView) y().findViewById(R.id.marquee_comment_text);
        this.f184069z = (ImageView) y().findViewById(R.id.marquee_exit_icon);
        View r101 = this.f184065v;
        if (r101 == null) goto L5;
        r101.setOnClickListener(this);
    L5:
        ImageView r102 = this.f184069z;
        if (r102 == null) goto L8;
        r102.setOnClickListener(this);
    L8:
        ImageView r103 = this.f184069z;
        if (r103 == null) goto L11;
        ExtensionsKt.visible(r103);
    L11:
        View r104 = this.f184064u;
        ViewGroup.LayoutParams r105 = null;
        if (r104 == null) goto L14;
        ViewGroup.LayoutParams r106 = r104.getLayoutParams();
    L16:
        if ((r106 instanceof ViewGroup.MarginLayoutParams) == false) goto L19;
        r105 = r106;
    L19:
        ViewGroup.MarginLayoutParams r107 = (ViewGroup.MarginLayoutParams) r105;
        if (r107 == null) goto L22;
        r107.height = com.bytedance.android.shopping.extensions.b.b(32);
    L22:
        GradientDrawable r108 = new GradientDrawable();
        r108.setColor(1929379840);
        r108.setCornerRadii(qc3.a.b(68.0f, 68.0f, 68.0f, 68.0f));
        View r109 = this.f184064u;
        if (r109 == null) goto L25;
        Intrinsics.checkNotNullParameter(r109, "$this$setBackgroundCompat");
        r109.setBackground(r108);
    L25:
        T().getFloatArea().a(W(), new h(this), false);
        T().getCollapseFactor().a(W(), new i(this), false);
        T().getUpglideFactor().a(W(), new j(this), false);
        T().getCouldShowMarquee().a(W(), new k(this), false);
        T().getSelectedTabLocation().a(W(), new l(this), false);
        return;
    L14:
        r106 = null;
        goto L16
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        Intrinsics.checkNotNullParameter(r100, BaseSwitches.V);
        int r101 = r100.getId();
        if (r101 != R.id.marquee_exit_icon) goto L6;
        v0();
        this.F = true;
        String r102 = DateFormat.format("yyyy-MM-dd", System.currentTimeMillis()).toString();
        om.a r103 = om.a.f524204a;
        com.bytedance.android.ec.core.async.a.a(bg4.b.b(om.a.a(com.bytedance.android.ec.sdk.helper.r.f48132a.getCurrentUserId(), T().getStoreParam().getSecShopId(), r102)).subscribe(new p3(this, r102), q3.f184375a), T());
        u0("101");
        return;
    L6:
        if (r101 != R.id.ec_shop_top_marquee_item) goto L10;
        u0(BDLocationException.ERROR_UID_IS_EMPTY);
        return;
    }

    public final void u0(String r100) {
        ij3.b r101 = this.A;
        if (r101 == null) goto L7;
        List<ij3.b.C6274b> r102 = r101.f490056a;
        if (r102 == null) goto L7;
        int r103 = r102.size();
    L8:
        ij3.b r104 = this.A;
        String r105 = null;
        if (r104 == null) goto L13;
        List<ij3.b.C6274b> r106 = r104.f490056a;
        if (r106 == null) goto L13;
        ij3.b.C6274b r107 = (ij3.b.C6274b) ListProtector.get(r106, this.E % r103);
    L14:
        ECStoreViewModel r108 = T();
        Pair<String, String>[] r109 = new Pair[2];
        if (r107 == null) goto L17;
        r105 = r107.f490059c;
    L17:
        if (r105 != null) goto L19;
        r105 = "";
    L19:
        r109[0] = TuplesKt.to("bubble_type", r105);
        r109[1] = TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_CLICK_AREA, r100);
        r108.doEventAction("buy_info_bubble_click", r109);
        return;
    L13:
        r107 = null;
    L7:
        r103 = 1;
        goto L8
    }

    public final Disposable t0(long r100, long r101, Function0<Unit> r102) {
        return com.bytedance.android.ec.core.rxjava.a.a(r100, r101, TimeUnit.MILLISECONDS).subscribeOn(Schedulers.computation()).observeOn(AndroidSchedulers.mainThread()).subscribe(new d(r102), e.f184073a, f.f184074a);
    }

    public static final void q0(ECShopTopMarqueeUDSlidePresenter r100, int r101, int r102, Animator.AnimatorListener r103) {
        r100.getClass();
        ValueAnimator r104 = ValueAnimator.ofInt(new int[]{r101, r102});
        r104.setDuration(300);
        r104.setInterpolator(new DecelerateInterpolator());
        r104.addUpdateListener(new r3(r100, r103));
        if (r103 == null) goto L5;
        r104.addListener(r103);
    L5:
        r104.start();
    }
}
