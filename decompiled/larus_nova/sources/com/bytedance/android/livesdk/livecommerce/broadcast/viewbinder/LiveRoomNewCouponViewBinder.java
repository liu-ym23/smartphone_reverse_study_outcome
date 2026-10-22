package com.bytedance.android.livesdk.livecommerce.broadcast.viewbinder;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.platform.comapi.map.MapController;
import com.bytedance.android.ec.common.api.inflow.AnchorBenefitToast;
import com.bytedance.android.livesdk.livecommerce.multitype.b;
import com.bytedance.android.livesdk.livecommerce.view.ECHostDistributeCouponStatusLayout;
import com.bytedance.android.livesdk.livecommerce.view.coupon.ECNewCouponLayout;
import com.larus.nova.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import si2.p;

/* JADX INFO: loaded from: classes10.dex */
public final class LiveRoomNewCouponViewBinder extends b<p, ItemViewHolder> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f147705a;

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/broadcast/viewbinder/LiveRoomNewCouponViewBinder$ItemViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class ItemViewHolder extends RecyclerView.ViewHolder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ECNewCouponLayout f147706a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final a f147707b;

        public static final class a implements ECNewCouponLayout.a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ ItemViewHolder f147708a;

            public a(ItemViewHolder r100) {
                this.f147708a = r100;
            }

            @Override // com.bytedance.android.livesdk.livecommerce.view.coupon.ECNewCouponLayout.a
            public final void a(ECHostDistributeCouponStatusLayout r100) {
                a r101 = this.f147708a.f147707b;
                if (r101 == null) goto L6;
                r101.showBubble(r100);
                return;
            }

            @Override // com.bytedance.android.livesdk.livecommerce.view.coupon.ECNewCouponLayout.a
            public final void distributeCoupon(p r100) {
                Intrinsics.checkNotNullParameter(r100, AnchorBenefitToast.TYPE_COUPON);
                a r101 = this.f147708a.f147707b;
                if (r101 == null) goto L6;
                r101.distributeCoupon(r100);
                return;
            }
        }

        public ItemViewHolder(ViewGroup r100, a r101) {
            Intrinsics.checkNotNullParameter(r100, "parentView");
            super(th.a.c(r100.getContext(), R.layout.ec_new_coupon_item, r100, false));
            this.f147707b = r101;
            ECNewCouponLayout r102 = (ECNewCouponLayout) this.itemView.findViewById(R.id.ec_coupon_layout);
            this.f147706a = r102;
            r102.setCouponHandler(new a(this));
        }
    }

    public interface a {
        void distributeCoupon(p r100);

        void showBubble(View r100);
    }

    public LiveRoomNewCouponViewBinder(a r100) {
        this.f147705a = r100;
    }

    @Override // com.bytedance.android.livesdk.livecommerce.multitype.b
    public final void a(RecyclerView.ViewHolder r100, Object r101) {
        ItemViewHolder r102 = (ItemViewHolder) r100;
        p r103 = (p) r101;
        Intrinsics.checkNotNullParameter(r102, "holder");
        Intrinsics.checkNotNullParameter(r103, MapController.ITEM_LAYER_TAG);
        r102.getClass();
        Intrinsics.checkNotNullParameter(r103, AnchorBenefitToast.TYPE_COUPON);
        r102.f147706a.b(r103);
    }

    @Override // com.bytedance.android.livesdk.livecommerce.multitype.b
    public final ItemViewHolder b(LayoutInflater r100, ViewGroup r101) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        Intrinsics.checkNotNullParameter(r101, "parent");
        return new ItemViewHolder(r101, this.f147705a);
    }
}
