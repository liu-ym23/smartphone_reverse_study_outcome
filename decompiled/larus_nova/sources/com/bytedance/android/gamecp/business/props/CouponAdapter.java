package com.bytedance.android.gamecp.business.props;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.gamecp.business.GamePromoteTrack;
import com.bytedance.android.gamecp.common.utils.y0;
import com.bytedance.android.livesdk.schema.AudienceGamePromoteDetailActionHandler;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.nova.R;
import com.ss.android.downloadlib.constants.EventConstants;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/gamecp/business/props/CouponAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/bytedance/android/gamecp/business/props/CouponAdapter$CouponViewHolder;", "CouponViewHolder", "gamecp-business_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class CouponAdapter extends RecyclerView.Adapter<CouponViewHolder> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f56275a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<wt.m> f56276b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final wt.g f56277c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Map<String, Object> f56278d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Function2<Integer, Boolean, Unit> f56279e;

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/gamecp/business/props/CouponAdapter$CouponViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "gamecp-business_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class CouponViewHolder extends RecyclerView.ViewHolder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final TextView f56280a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final TextView f56281b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final TextView f56282c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final TextView f56283d;

        public CouponViewHolder(View r100) {
            Intrinsics.checkNotNullParameter(r100, "itemView");
            super(r100);
            this.f56280a = (TextView) r100.findViewById(R.id.tv_coupon_list_item_price);
            this.f56281b = (TextView) r100.findViewById(R.id.tv_coupon_list_item_price_limit);
            this.f56282c = (TextView) r100.findViewById(R.id.tv_coupon_list_item_name);
            this.f56283d = (TextView) r100.findViewById(R.id.tv_coupon_list_item_time);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        return this.f56276b.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder r110, int r111) {
        CouponViewHolder r112 = (CouponViewHolder) r110;
        Intrinsics.checkNotNullParameter(r112, "holder");
        wt.m r113 = (wt.m) ListProtector.get(this.f56276b, r111);
        Long r100 = null;
        if (this.f56275a == true) goto L19;
        int r101 = GamePromoteTrack.f51759a;
        wt.g r102 = this.f56277c;
        Object r103 = this.f56278d.get("prop_enter_from");
        if ((r103 instanceof String) == true) goto L7;
        r103 = null;
    L7:
        String r104 = (String) r103;
        Object r105 = this.f56278d.get(AudienceGamePromoteDetailActionHandler.PARA_PROMOTER_SCENE);
        if ((r105 instanceof Integer) == true) goto L10;
        r105 = null;
    L10:
        Integer r106 = (Integer) r105;
        String r107 = r113.couponId;
        Pair[] r108 = new Pair[5];
        r108[0] = TuplesKt.to("user_id", GamePromoteTrack.j());
        if (r102 == null) goto L13;
        String r109 = r102.gameId;
    L14:
        r108[1] = TuplesKt.to("game_id", r109);
        if (r102 == null) goto L17;
        String r114 = r102.gameName;
    L18:
        r108[2] = TuplesKt.to(EventConstants.ExtraJson.GAME_NAME, r114);
        r108[3] = TuplesKt.to("enter_from", r104);
        r108[4] = TuplesKt.to("coupon_id", r107);
        GamePromoteTrack.t("livesdk_gcom_coupon_card_show", r104, r106, MapsKt.mutableMapOf(r108));
        goto L19
    L17:
        r114 = null;
        goto L18
    L13:
        r109 = null;
    L19:
        TextView r115 = r112.f56280a;
        int r116 = y.f56404a;
        r115.setText(y.a(r113.couponDiscountAmount));
        Long r117 = r113.couponDiscountLimit;
        if (r117 != null) goto L23;
    L25:
        r112.f56281b.setText(y0.j(R.string.ttlive_game_promote_prop_order_prop_coupon_limit, new Object[]{y.a(r113.couponDiscountLimit)}));
    L26:
        r112.f56282c.setText(r113.couponName);
        TextView r118 = r112.f56283d;
        Long r119 = r113.couponExpireTime;
        if (r119 == null) goto L29;
        r100 = Long.valueOf(r119.longValue() * ((long) 1000));
    L29:
        if (r100 != null) goto L32;
    L34:
        Calendar r120 = Calendar.getInstance();
        Calendar r121 = Calendar.getInstance();
        Intrinsics.checkNotNull(r100);
        r121.setTimeInMillis(r100.longValue());
        if (r120.get(1) == r121.get(1)) goto L37;
    L40:
        String r122 = new SimpleDateFormat("yyyy.MM.dd", Locale.getDefault()).format(r121.getTime());
    L41:
        r118.setText(r122);
        if (Intrinsics.areEqual(r113.isDefault, Boolean.TRUE) == false) goto L44;
        r112.itemView.setBackground(y0.e(R.drawable.gamecp_bg_props_coupon_list_item_selected));
        return;
    L44:
        r112.itemView.setBackground(y0.e(R.drawable.gamecp_bg_props_coupon_list_item_unselected));
        return;
    L37:
        if ((r120.get(6) - r121.get(6)) != 0) goto L40;
        r122 = y0.i(R.string.ttlive_game_promote_prop_order_prop_coupon_expire);
        goto L41
    L32:
        if (r100.longValue() != 0) goto L34;
        r122 = "";
        goto L41
    L23:
        if (r117.longValue() != 0) goto L25;
        r112.f56281b.setText(y0.i(R.string.ttlive_game_promote_prop_order_prop_coupon_no_limit));
        goto L26
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        CouponViewHolder r102 = new CouponViewHolder(LayoutInflater.from(r100.getContext()).inflate(R.layout.gamecp_item_props_coupon_list, r100, false));
        r102.itemView.setOnClickListener(new a(this, r102));
        return r102;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public CouponAdapter(List<wt.m> r100, wt.g r101, Map<String, Object> r102, Function2<? super Integer, ? super Boolean, Unit> r103) {
        Intrinsics.checkNotNullParameter(r100, "dataList");
        Intrinsics.checkNotNullParameter(r101, "info");
        Intrinsics.checkNotNullParameter(r102, "logParams");
        Intrinsics.checkNotNullParameter(r103, "clickAction");
        this.f56276b = r100;
        this.f56277c = r101;
        this.f56278d = r102;
        this.f56279e = r103;
    }
}
