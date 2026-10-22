package com.bytedance.android.shopping.store.home.presenter;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import androidx.fragment.app.Fragment;
import com.bytedance.android.ec.store.common.headlive.StoreV3LiveRoomVO;
import com.bytedance.android.shopping.store.home.frame.container.ShopContainerType;
import com.bytedance.android.shopping.store.repository.vo.ShopHeaderVideoVO;
import com.bytedance.android.shopping.store.viewmodel.ECStoreViewModel;
import com.larus.nova.R;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import com.ss.android.ugc.aweme.kiwi.model.QModel;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class q0 extends ECShopBasePresenter implements View.OnClickListener {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public View f184364u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public View f184365v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final float f184366w;

    public static final class a {
    }

    public static final class b<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ q0 f184367a;

        public b(q0 r100) {
            this.f184367a = r100;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r100) {
            StoreV3LiveRoomVO r101 = (StoreV3LiveRoomVO) r100;
            View r102 = this.f184367a.f184365v;
            if (r102 != null) goto L6;
            Intrinsics.throwUninitializedPropertyAccessException("liveTipsContainer");
        L6:
            if (this.f184367a.D() == false) goto L8;
            int r103 = 0;
        L9:
            r102.setVisibility(r103);
            return;
        L8:
            r103 = 8;
            goto L9
        }
    }

    public static final class c<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ q0 f184368a;

        public c(q0 r100) {
            this.f184368a = r100;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r100) {
            ShopHeaderVideoVO r101 = (ShopHeaderVideoVO) r100;
            View r102 = this.f184368a.f184365v;
            if (r102 != null) goto L6;
            Intrinsics.throwUninitializedPropertyAccessException("liveTipsContainer");
        L6:
            if (this.f184368a.D() == false) goto L8;
            int r103 = 0;
        L9:
            r102.setVisibility(r103);
            return;
        L8:
            r103 = 8;
            goto L9
        }
    }

    public static final class d<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ q0 f184369a;

        public d(q0 r100) {
            this.f184369a = r100;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r100) {
            Float r101 = (Float) r100;
            q0 r102 = this.f184369a;
            View r103 = r102.f184364u;
            if (r103 != null) goto L5;
            Intrinsics.throwUninitializedPropertyAccessException("infoGroupArea");
        L5:
            Drawable r104 = r103.getBackground();
            if ((r104 instanceof GradientDrawable) == true) goto L8;
            r104 = null;
        L8:
            GradientDrawable r105 = (GradientDrawable) r104;
            if (r105 == null) goto L12;
            float r106 = (1.0f - r102.a0(0.5f)) * r102.f184366w;
            r105.setCornerRadii(qc3.a.b(r106, r106, 0.0f, 0.0f));
            return;
        }
    }

    public static final class e implements View.OnLayoutChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ q0 f184370a;

        public e(q0 r100) {
            this.f184370a = r100;
        }

        @Override // android.view.View.OnLayoutChangeListener
        public final void onLayoutChange(View r100, int r101, int r102, int r103, int r104, int r105, int r106, int r107, int r108) {
            ECStoreViewModel r109 = this.f184370a.T();
            ShopContainerType r110 = ShopContainerType.SHOP_INFO_CONTAINER;
            vi3.c r111 = new vi3.c(r100.getLayoutParams().width, r100.getLayoutParams().height);
            r111.f555305a = r100.getHeight();
            r111.f555306b = r100.getWidth();
            Unit r112 = Unit.INSTANCE;
            r109.updateContainer(r110, r111);
        }
    }

    static {
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
    }

    public q0(Fragment r100) {
        super(r100);
        this.f184366w = 12.0f;
    }

    @Override // com.ss.android.ugc.aweme.kiwi.presenter.QPresenter
    public final void A(QModel r100) {
        this.f184364u = y();
        this.f184365v = w().b(R.id.ec_store_info_group_live_tips_container).f();
        T().getLiveInfo().a(W(), new b(this), false);
        T().getVideoInfo().a(W(), new c(this), false);
        T().getCollapseFactor().a(W(), new d(this), false);
        y().addOnLayoutChangeListener(new e(this));
    }
}
