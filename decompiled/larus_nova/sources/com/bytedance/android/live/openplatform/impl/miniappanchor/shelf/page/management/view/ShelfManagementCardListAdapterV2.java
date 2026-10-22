package com.bytedance.android.live.openplatform.impl.miniappanchor.shelf.page.management.view;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.amap.api.col.s.ce;
import com.bytedance.android.live.core.utils.ImageLoader;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.openplatform.api.model.shelf.ProductInfo;
import com.bytedance.android.live.openplatform.api.model.shelf.ProductIntroductionInfo;
import com.bytedance.android.live.openplatform.api.model.shelf.ProductLabelInfo;
import com.bytedance.android.live.openplatform.api.model.shelf.ProductPriceInfo;
import com.bytedance.android.live.openplatform.api.model.shelf.ShelfCardInfo;
import com.bytedance.android.live.openplatform.impl.miniappcommon.shelf.view.CommonProductIntroductionLayout;
import com.bytedance.android.live.openplatform.impl.miniappcommon.shelf.view.CommonProductLabelLayout;
import com.bytedance.android.live.openplatform.impl.miniappcommon.shelf.view.CommonProductPriceView;
import com.bytedance.android.livesdk.config.ee0;
import com.bytedance.android.livesdk.utils.t6;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import java.util.Collections;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u00012\u00020\u0003:\u0006\n\u000b\f\r\u000e\u000fR\u0017\u0010\t\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/live/openplatform/impl/miniappanchor/shelf/page/management/view/ShelfManagementCardListAdapterV2;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/bytedance/android/live/openplatform/impl/miniappanchor/shelf/page/management/view/ShelfManagementCardListAdapterV2$ShelfManagementCardItemViewHolder;", "Lcom/bytedance/android/live/openplatform/impl/miniappanchor/shelf/page/management/view/a;", "Landroid/app/Activity;", ce.f26391f, "Landroid/app/Activity;", "getActivity", "()Landroid/app/Activity;", "activity", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "b", "OnItemClickListener", "c", "d", "ShelfManagementCardItemViewHolder", "liveopenplatform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ShelfManagementCardListAdapterV2 extends RecyclerView.Adapter<ShelfManagementCardItemViewHolder> implements com.bytedance.android.live.openplatform.impl.miniappanchor.shelf.page.management.view.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public b f84651a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public d f84652b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public c f84653c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public OnItemClickListener f84654d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public a f84655e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public List<aq0.a> f84656f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Activity f84657g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f84658h;

    public interface OnItemClickListener {

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/live/openplatform/impl/miniappanchor/shelf/page/management/view/ShelfManagementCardListAdapterV2$OnItemClickListener$ClickPosition;", "", "Cover", "Title", "MORE", "REVIEW_REJECTED", "liveopenplatform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
        public static final enum ClickPosition extends Enum<ClickPosition> {
            public static final ClickPosition Cover = null;
            public static final ClickPosition MORE = null;
            public static final ClickPosition REVIEW_REJECTED = null;
            public static final ClickPosition Title = null;

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ ClickPosition[] f84659a = null;

            static {
                ClickPosition r100 = new ClickPosition("Cover", 0);
                Cover = r100;
                ClickPosition r101 = new ClickPosition("Title", 1);
                Title = r101;
                ClickPosition r102 = new ClickPosition("MORE", 2);
                MORE = r102;
                ClickPosition r103 = new ClickPosition("REVIEW_REJECTED", 3);
                REVIEW_REJECTED = r103;
                f84659a = new ClickPosition[]{r100, r101, r102, r103};
            }

            public static ClickPosition valueOf(String r100) {
                return (ClickPosition) r27.a.a(ClickPosition.class, r100);
            }

            public static ClickPosition[] values() {
                return (ClickPosition[]) f84659a.clone();
            }

            public ClickPosition(String r100, int r101) {
                super(r100, r101);
            }
        }

        void a(ShelfCardInfo r100, ClickPosition r101, int r102);
    }

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/live/openplatform/impl/miniappanchor/shelf/page/management/view/ShelfManagementCardListAdapterV2$ShelfManagementCardItemViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "liveopenplatform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public final class ShelfManagementCardItemViewHolder extends RecyclerView.ViewHolder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final View f84660a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final CheckBox f84661b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final HSImageView f84662c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final TextView f84663d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final LinearLayout f84664e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final TextView f84665f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final TextView f84666g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final TextView f84667h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final TextView f84668i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final TextView f84669j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public final CommonProductIntroductionLayout f84670k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public final CommonProductLabelLayout f84671l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public final CommonProductPriceView f84672m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public final /* synthetic */ ShelfManagementCardListAdapterV2 f84673n;

        public ShelfManagementCardItemViewHolder(ShelfManagementCardListAdapterV2 r100, View r101) {
            Intrinsics.checkNotNullParameter(r101, "itemView");
            this.f84673n = r100;
            super(r101);
            this.f84660a = r101.findViewById(R.id.card_content);
            this.f84661b = (CheckBox) r101.findViewById(R.id.checkbox);
            this.f84662c = (HSImageView) r101.findViewById(R.id.card_cover_img);
            this.f84663d = (TextView) r101.findViewById(R.id.card_index_tv);
            this.f84664e = (LinearLayout) r101.findViewById(R.id.card_explaining_container);
            this.f84665f = (TextView) r101.findViewById(R.id.card_title_tv);
            this.f84666g = (TextView) r101.findViewById(R.id.more_tv);
            this.f84667h = (TextView) r101.findViewById(R.id.edit_explain_card);
            this.f84668i = (TextView) r101.findViewById(R.id.review_status_tv);
            this.f84669j = (TextView) r101.findViewById(R.id.selling_point_tv);
            this.f84670k = (CommonProductIntroductionLayout) r101.findViewById(R.id.product_introduction);
            this.f84671l = (CommonProductLabelLayout) r101.findViewById(R.id.product_label);
            this.f84672m = (CommonProductPriceView) r101.findViewById(R.id.product_price);
        }
    }

    public interface a {
        void a();
    }

    public interface b {
        void a(ShelfCardInfo r100, int r101);
    }

    public interface c {
        void a();

        void c();

        void g();
    }

    public interface d {
        void a(int r100);

        void b(int r100);
    }

    @Override // com.bytedance.android.live.openplatform.impl.miniappanchor.shelf.page.management.view.a
    public final boolean isDraggable() {
        return true;
    }

    @Override // com.bytedance.android.live.openplatform.impl.miniappanchor.shelf.page.management.view.a
    public final void c() {
        c r100 = this.f84653c;
        if (r100 == null) goto L6;
        r100.c();
        return;
    }

    @Override // com.bytedance.android.live.openplatform.impl.miniappanchor.shelf.page.management.view.a
    public final void g() {
        c r100 = this.f84653c;
        if (r100 == null) goto L6;
        r100.g();
        return;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        return this.f84656f.size();
    }

    public final Activity getActivity() {
        return this.f84657g;
    }

    public ShelfManagementCardListAdapterV2(ShelfManagementActivityV2 r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        this.f84657g = r100;
        this.f84658h = r101;
        this.f84656f = CollectionsKt.emptyList();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder r110, final int r111) {
        final ShelfManagementCardItemViewHolder r112 = (ShelfManagementCardItemViewHolder) r110;
        Intrinsics.checkNotNullParameter(r112, "viewHolder");
        aq0.a r100 = (aq0.a) ListProtector.get(this.f84656f, r111);
        r112.getClass();
        Intrinsics.checkNotNullParameter(r100, "shelfManagementCardInfo");
        r112.f84661b.setChecked(r100.f15878b);
        r112.f84661b.setOnClickListener(new i(r112, r111));
        cq0.a.a(r112.f84660a, new ShelfManagementCardListAdapterV2$ShelfManagementCardItemViewHolder$onBindViewHolder$2(r112, r111));
        r112.f84663d.setText(String.valueOf(r111 + 1));
        final ShelfCardInfo r101 = r100.f15877a;
        ImageLoader.bindImage(r112.f84662c, r101.h());
        cq0.a.a(r112.f84662c, new ShelfManagementCardListAdapterV2$ShelfManagementCardItemViewHolder$onBindViewHolder$3(r112, r101, r111));
        cq0.a.a(r112.f84665f, new ShelfManagementCardListAdapterV2$ShelfManagementCardItemViewHolder$onBindViewHolder$4(r112, r101, r111));
        if (ee0.f120119a.getValue().s() == false) goto L5;
        r112.f84666g.setVisibility(0);
        cq0.a.a(r112.f84666g, new ShelfManagementCardListAdapterV2$ShelfManagementCardItemViewHolder$onBindViewHolder$5(r112, r101, r111));
        r112.f84666g.post(new j(r112));
    L7:
        if (r112.f84673n.f84658h == true) goto L9;
    L11:
        r112.f84664e.setVisibility(8);
    L12:
        boolean r102 = true;
        boolean r103 = r101.c(true);
        if (r103 == false) goto L15;
        r112.f84669j.setVisibility(0);
        r112.f84669j.setText(r101.b());
    L17:
        if (r112.f84673n.f84658h == true) goto L19;
        r112.f84668i.setVisibility(8);
    L26:
        r112.f84665f.setText(r101.i(null));
        ProductInfo r113 = r101.getProductInfo();
        com.bytedance.android.live.openplatform.api.utils.a r104 = com.bytedance.android.live.openplatform.api.utils.a.f84001a;
        if (r104.h() == false) goto L64;
        if (r113 == null) goto L64;
        r112.f84667h.setVisibility(8);
        if (r104.i() == false) goto L41;
        List<ProductIntroductionInfo> r105 = r113.introductionList;
        if (r105 != null) goto L34;
    L37:
        boolean r106 = true;
    L38:
        if (r106 == true) goto L41;
        CommonProductIntroductionLayout r107 = r112.f84670k;
        List<ProductIntroductionInfo> r108 = r113.introductionList;
        Intrinsics.checkNotNull(r108);
        r107.r(r104.k(r108));
        r112.f84670k.setVisibility(0);
        boolean r109 = true;
    L42:
        if (r103 == false) goto L46;
        if (r109 == false) goto L46;
        r112.f84671l.setVisibility(8);
    L58:
        if (r104.e() == false) goto L63;
        ProductPriceInfo r114 = r113.price;
        if (r114 == null) goto L63;
        CommonProductPriceView r115 = r112.f84672m;
        Intrinsics.checkNotNull(r114);
        r115.b(r114);
        r112.f84672m.setVisibility(0);
        return;
    L63:
        r112.f84672m.setVisibility(8);
        return;
    L46:
        if (r104.j() == false) goto L56;
        List<ProductLabelInfo> r116 = r113.labelList;
        if (r116 != null) goto L50;
    L53:
        if (r102 == true) goto L56;
        CommonProductLabelLayout r117 = r112.f84671l;
        List<ProductLabelInfo> r118 = r113.labelList;
        Intrinsics.checkNotNull(r118);
        r117.r(r104.l(r118));
        r112.f84671l.setVisibility(0);
        goto L58
    L50:
        if (r116.isEmpty() == true) goto L53;
        r102 = false;
    L56:
        r112.f84671l.setVisibility(8);
        goto L58
    L34:
        if (r105.isEmpty() == true) goto L37;
        r106 = false;
    L41:
        r112.f84670k.setVisibility(8);
        r109 = false;
    L64:
        r112.f84670k.setVisibility(8);
        r112.f84671l.setVisibility(8);
        r112.f84672m.setVisibility(8);
        return;
    L19:
        if (r101.G0(-1) == false) goto L22;
        r112.f84668i.setVisibility(0);
        r112.f84668i.setText(s1.B(R.string.ttlive_open_platform_custom_card_review_reject));
        r112.f84668i.setTextColor(s1.h(R.color.ttlive_miniapp_card_review_not_pass));
        r112.f84668i.setBackgroundResource(R.drawable.ttlive_open_platform_review_reject_background);
        r112.f84668i.setCompoundDrawablesWithIntrinsicBounds(null, null, s1.m(R.drawable.ttlive_open_platform_review_rejected_icon), null);
        r112.f84668i.setCompoundDrawablePadding((int) t6.a(r112.itemView.getContext(), 2.0f));
        cq0.a.a(r112.f84668i, new ShelfManagementCardListAdapterV2$ShelfManagementCardItemViewHolder$onBindViewHolder$8(r112, r101, r111));
        goto L26
    L22:
        if (r101.H0(-1) == false) goto L24;
        r112.f84668i.setVisibility(0);
        r112.f84668i.setText(s1.B(R.string.ttlive_open_platform_custom_card_reviewing));
        r112.f84668i.setTextColor(s1.h(R.color.ttlive_miniapp_card_review_ing));
        r112.f84668i.setBackgroundResource(R.drawable.ttlive_open_platform_reviewing_background);
        r112.f84668i.setCompoundDrawables(null, null, s1.m(R.drawable.ttlive_open_platform_review_rejected_icon), null);
        r112.f84668i.setCompoundDrawablePadding((int) t6.a(r112.itemView.getContext(), 2.0f));
        r112.f84668i.setOnClickListener(null);
        goto L26
    L24:
        r112.f84668i.setVisibility(8);
        goto L26
    L15:
        r112.f84669j.setVisibility(8);
        goto L17
    L9:
        if (r101.getStatus() != 1) goto L11;
        r112.f84664e.setVisibility(0);
        goto L12
    L5:
        Drawable r119 = s1.m(R.drawable.ttlive_ic_explain_card_setting_arrow);
        r119.setBounds(0, 0, (int) t6.a(r112.itemView.getContext(), 8.0f), (int) t6.a(r112.itemView.getContext(), 8.0f));
        r112.f84667h.setVisibility(0);
        r112.f84667h.setCompoundDrawables(null, null, r119, null);
        cq0.a.a(r112.f84667h, new ShelfManagementCardListAdapterV2$ShelfManagementCardItemViewHolder$onBindViewHolder$7(r112, r101, r111));
        goto L7
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        return new ShelfManagementCardItemViewHolder(this, LayoutInflater.from(r100.getContext()).inflate(R.layout.ttlive_miniapp_shelf_management_item_v2, r100, false));
    }

    @Override // com.bytedance.android.live.openplatform.impl.miniappanchor.shelf.page.management.view.a
    public final void r(RecyclerView.ViewHolder r100, RecyclerView.ViewHolder r101) {
        Intrinsics.checkNotNullParameter(r100, "source");
        Intrinsics.checkNotNullParameter(r101, PickerReporterConstants.KEY.TARGET);
        int r102 = r100.getAdapterPosition();
        int r103 = r101.getAdapterPosition();
        Collections.swap(this.f84656f, r102, r103);
        notifyItemMoved(r102, r103);
        c r104 = this.f84653c;
        if (r104 == null) goto L6;
        r104.a();
        return;
    }
}
