package com.bytedance.android.shopping.store.home.presenter;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleObserver;
import com.bytedance.android.ec.store.utils.taskmanager.ECTaskManager;
import com.bytedance.android.ec.store.utils.taskmanager.TaskPriority;
import com.bytedance.ies.sdk.widgets.api.WidgetService;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import com.ss.android.ugc.aweme.kiwi.model.QModel;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/shopping/store/home/presenter/ECShopAnimationPresenter;", "Lcom/bytedance/android/shopping/store/home/presenter/ECShopBasePresenter;", "Landroidx/lifecycle/LifecycleObserver;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECShopAnimationPresenter extends ECShopBasePresenter implements LifecycleObserver {

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final /* synthetic */ int f183865w = 0;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final Lazy f183866u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public boolean f183867v;

    public static final class a {
    }

    public static final class b<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ECShopAnimationPresenter f183868a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ View f183869b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Ref.ObjectRef f183870c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ i4 f183871d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ View f183872e;

        public b(ECShopAnimationPresenter r100, View r101, Ref.ObjectRef r102, i4 r103, View r104) {
            this.f183868a = r100;
            this.f183869b = r101;
            this.f183870c = r102;
            this.f183871d = r103;
            this.f183872e = r104;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r100) {
            Float r101 = (Float) r100;
            if (this.f183868a.T().needShopProfilePin2Top() == true) goto L8;
            this.f183869b.setVisibility(0);
            View r102 = (View) this.f183870c.element;
            if (r102 == null) goto L7;
            r102.setVisibility(8);
        L7:
            this.f183869b.setAlpha(1.0f);
            return;
        L8:
            ECShopAnimationPresenter r103 = this.f183868a;
            if (r103.f183867v == true) goto L12;
            this.f183870c.element = (T) r103.r0(this.f183869b);
            return;
        L12:
            if (Intrinsics.areEqual(r101, 0.0f) == false) goto L20;
            this.f183871d.a();
            this.f183869b.setVisibility(0);
            View r104 = (View) this.f183870c.element;
            if (r104 == null) goto L16;
            r104.setVisibility(8);
        L16:
            View r105 = (View) this.f183870c.element;
            if (r105 == null) goto L42;
            wg.a.i(r105, this.f183871d.f184200c);
            wg.a.d(r105, this.f183871d.f184201d);
            r105.setX(this.f183871d.f184204g);
            r105.setY(this.f183871d.f184205h);
            return;
        L42:
            return;
        L20:
            if (Intrinsics.areEqual(r101, 1.0f) == false) goto L33;
            View r106 = (View) this.f183870c.element;
            if (r106 == null) goto L24;
            wg.a.i(r106, this.f183871d.f184202e);
            wg.a.d(r106, this.f183871d.f184203f);
            r106.setX(this.f183871d.f184206i - (r106.getWidth() / 2));
            r106.setY(this.f183871d.f184207j + (r106.getHeight() / 2));
        L24:
            i4 r107 = this.f183871d;
            r107.f184199b = wg.a.c(r107.f184209l);
            r107.f184202e = r107.f184209l.getWidth();
            r107.f184203f = r107.f184209l.getHeight();
            int[] r108 = r107.f184199b;
            if (r108 != null) goto L27;
            Intrinsics.throwUninitializedPropertyAccessException("targetLocationInScreen");
        L27:
            r107.f184206i = r108[0] + (r107.f184202e / 2);
            int[] r109 = r107.f184199b;
            if (r109 != null) goto L30;
            Intrinsics.throwUninitializedPropertyAccessException("targetLocationInScreen");
        L30:
            r107.f184207j = r109[1] - (r107.f184203f / 2);
            this.f183872e.setVisibility(0);
            View r110 = (View) this.f183870c.element;
            if (r110 == null) goto L44;
            r110.post(new e(this));
            return;
        L44:
            return;
        L33:
            float r111 = RangesKt.coerceAtMost(RangesKt.coerceAtLeast(r101.floatValue() * 1.5f, 0.0f), 1.0f);
            this.f183872e.setVisibility(4);
            this.f183869b.setVisibility(4);
            View r112 = (View) this.f183870c.element;
            if (r112 == null) goto L36;
            r112.setVisibility(0);
        L36:
            View r113 = (View) this.f183870c.element;
            if (r113 == null) goto L46;
            i4 r114 = this.f183871d;
            int r115 = r114.f184202e;
            int r116 = r114.f184200c;
            int r117 = r114.f184203f;
            int r118 = r114.f184201d;
            int r119 = r114.f184206i - r114.f184204g;
            int r120 = r114.f184207j - r114.f184205h;
            int r121 = r116 + ((int) ((r115 - r116) * r111));
            int r122 = r118 + ((int) ((r117 - r118) * r111));
            wg.a.i(r113, r121);
            wg.a.d(r113, r122);
            i4 r123 = this.f183871d;
            float r124 = (r123.f184204g + (r119 * r111)) - (r121 / 2);
            float r125 = (r123.f184205h + (r120 * r111)) + (r122 / 2);
            r113.setX(r124);
            r113.setY(r125);
            return;
        }
    }

    public static final class c<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ i4 f183873a;

        public c(i4 r100) {
            this.f183873a = r100;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r100) {
            Float r101 = (Float) r100;
            if (Intrinsics.areEqual(r101, 1.0f) == false) goto L6;
            this.f183873a.a();
            dm.a.a("ECShopAnimationPresenter").a("collapseFactor: " + r101 + ',' + this.f183873a.f184205h);
            return;
        }
    }

    public static final class d<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ECShopAnimationPresenter f183874a;

        public d(ECShopAnimationPresenter r100) {
            this.f183874a = r100;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r100) {
            if (((com.bytedance.android.shopping.store.home.entity.n) r100) == null) goto L7;
            Lazy r101 = ECTaskManager.f48688b;
            ECTaskManager.a.a().a(this.f183874a.T().getStoreParam().getLifecycleMonitorId(), TaskPriority.AFTER_FIRST_SCREEN, new ECShopAnimationPresenter$onBind$1$1(this));
            return;
        }
    }

    static {
    }

    public ECShopAnimationPresenter(Fragment r100) {
        Intrinsics.checkNotNullParameter(r100, WidgetService.PARAM_FRAGMENT);
        super(r100);
        this.f183866u = LazyKt.lazy(new ECShopAnimationPresenter$animationLayout$2(this));
    }

    @Override // com.ss.android.ugc.aweme.kiwi.presenter.QPresenter
    public final void A(QModel r100) {
        T().getHeaderArea().a(W(), new d(this), false);
    }

    public final ImageView r0(View r100) {
        r100.setAlpha(1.0f);
        Intrinsics.checkNotNullParameter(r100, "$this$clone2Bitmap");
        if (r100.getWidth() > 0) goto L5;
    L8:
        Bitmap r101 = null;
    L9:
        if (r101 != null) goto L11;
        return null;
    L11:
        ImageView r102 = new ImageView(r100.getContext());
        r102.setImageBitmap(r101);
        r102.setLayoutParams(r100.getLayoutParams());
        r102.setClickable(false);
        ((ViewGroup) this.f183866u.getValue()).addView(r102);
        r102.setX(wg.a.c(r100)[0]);
        r102.setY(wg.a.c(r100)[1]);
        r102.setVisibility(8);
        this.f183867v = true;
        return r102;
    L5:
        if (r100.getHeight() <= 0) goto L8;
        r101 = Bitmap.createBitmap(r100.getWidth(), r100.getHeight(), Bitmap.Config.ARGB_8888);
        r100.draw(new Canvas(r101));
        goto L9
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [T, android.widget.ImageView] */
    public final void q0(View r110, View r111) {
        Ref.ObjectRef r100 = new Ref.ObjectRef();
        r100.element = null;
        i4 r101 = new i4(r110, r111);
        r100.element = r0(r110);
        T().getUpglideFactor().a(W(), new b(this, r110, r100, r101, r111), false);
        T().getCollapseFactor().a(W(), new c(r101), false);
    }
}
