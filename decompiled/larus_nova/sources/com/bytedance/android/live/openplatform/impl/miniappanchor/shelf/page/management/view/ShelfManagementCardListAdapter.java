package com.bytedance.android.live.openplatform.impl.miniappanchor.shelf.page.management.view;

import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.core.utils.ImageLoader;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.openplatform.api.model.datacontext.MiniAppDataContext;
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
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u00012\u00020\u0003:\u0005\u0004\u0005\u0006\u0007\b¨\u0006\t"}, d2 = {"Lcom/bytedance/android/live/openplatform/impl/miniappanchor/shelf/page/management/view/ShelfManagementCardListAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/bytedance/android/live/openplatform/impl/miniappanchor/shelf/page/management/view/ShelfManagementCardListAdapter$ShelfManagementCardItemViewHolder;", "Lcom/bytedance/android/live/openplatform/impl/miniappanchor/shelf/page/management/view/a;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "OnItemClickListener", "b", "c", "ShelfManagementCardItemViewHolder", "liveopenplatform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ShelfManagementCardListAdapter extends RecyclerView.Adapter<ShelfManagementCardItemViewHolder> implements com.bytedance.android.live.openplatform.impl.miniappanchor.shelf.page.management.view.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public a f84630a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public c f84631b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public b f84632c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public OnItemClickListener f84633d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f84634e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public List<ShelfCardInfo> f84635f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Boolean[] f84636g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f84637h;

    public interface OnItemClickListener {

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/live/openplatform/impl/miniappanchor/shelf/page/management/view/ShelfManagementCardListAdapter$OnItemClickListener$ClickPosition;", "", "Cover", "Title", "REVIEW_REJECTED", "liveopenplatform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
        public static final enum ClickPosition extends Enum<ClickPosition> {
            public static final ClickPosition Cover = null;
            public static final ClickPosition REVIEW_REJECTED = null;
            public static final ClickPosition Title = null;

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ ClickPosition[] f84638a = null;

            static {
                ClickPosition r100 = new ClickPosition("Cover", 0);
                Cover = r100;
                ClickPosition r101 = new ClickPosition("Title", 1);
                Title = r101;
                ClickPosition r102 = new ClickPosition("REVIEW_REJECTED", 2);
                REVIEW_REJECTED = r102;
                f84638a = new ClickPosition[]{r100, r101, r102};
            }

            public static ClickPosition valueOf(String r100) {
                return (ClickPosition) r27.a.a(ClickPosition.class, r100);
            }

            public static ClickPosition[] values() {
                return (ClickPosition[]) f84638a.clone();
            }

            public ClickPosition(String r100, int r101) {
                super(r100, r101);
            }
        }

        void a(ShelfCardInfo r100, ClickPosition r101);
    }

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/live/openplatform/impl/miniappanchor/shelf/page/management/view/ShelfManagementCardListAdapter$ShelfManagementCardItemViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "liveopenplatform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public final class ShelfManagementCardItemViewHolder extends RecyclerView.ViewHolder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final CheckBox f84639a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final HSImageView f84640b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final TextView f84641c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final TextView f84642d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final TextView f84643e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final LinearLayout f84644f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final TextView f84645g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final ImageView f84646h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final CommonProductIntroductionLayout f84647i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final CommonProductLabelLayout f84648j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public final CommonProductPriceView f84649k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public final /* synthetic */ ShelfManagementCardListAdapter f84650l;

        public ShelfManagementCardItemViewHolder(ShelfManagementCardListAdapter r100, View r101) {
            Intrinsics.checkNotNullParameter(r101, "itemView");
            this.f84650l = r100;
            super(r101);
            this.f84639a = (CheckBox) r101.findViewById(R.id.checkbox);
            this.f84640b = (HSImageView) r101.findViewById(R.id.card_cover_img);
            this.f84641c = (TextView) r101.findViewById(R.id.card_index_tv);
            this.f84642d = (TextView) r101.findViewById(R.id.card_title_tv);
            this.f84643e = (TextView) r101.findViewById(R.id.edit_explain_card);
            this.f84644f = (LinearLayout) r101.findViewById(R.id.card_explaining_container);
            this.f84645g = (TextView) r101.findViewById(R.id.review_status_tv);
            this.f84646h = (ImageView) r101.findViewById(R.id.drag_img);
            this.f84647i = (CommonProductIntroductionLayout) r101.findViewById(R.id.product_introduction);
            this.f84648j = (CommonProductLabelLayout) r101.findViewById(R.id.product_label);
            this.f84649k = (CommonProductPriceView) r101.findViewById(R.id.product_price);
        }
    }

    public interface a {
        void a(ShelfCardInfo r100);
    }

    public interface b {
        void a();

        void c();

        void g();
    }

    public interface c {
        void a(int r100);

        void b(int r100);
    }

    @Override // com.bytedance.android.live.openplatform.impl.miniappanchor.shelf.page.management.view.a
    public final void c() {
        b r100 = this.f84632c;
        if (r100 == null) goto L6;
        r100.c();
        return;
    }

    @Override // com.bytedance.android.live.openplatform.impl.miniappanchor.shelf.page.management.view.a
    public final void g() {
        b r100 = this.f84632c;
        if (r100 == null) goto L6;
        r100.g();
        return;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        return this.f84635f.size();
    }

    @Override // com.bytedance.android.live.openplatform.impl.miniappanchor.shelf.page.management.view.a
    public final boolean isDraggable() {
        return !this.f84634e;
    }

    public ShelfManagementCardListAdapter(boolean r100) {
        this.f84637h = r100;
        this.f84635f = CollectionsKt.emptyList();
        this.f84636g = new Boolean[0];
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder r110, int r111) {
        ShelfManagementCardItemViewHolder r112 = (ShelfManagementCardItemViewHolder) r110;
        Intrinsics.checkNotNullParameter(r112, "viewHolder");
        ShelfCardInfo r100 = (ShelfCardInfo) ListProtector.get(this.f84635f, r111);
        r112.getClass();
        Intrinsics.checkNotNullParameter(r100, "shelfCardInfo");
        r112.f84639a.setChecked(r112.f84650l.f84636g[r111].booleanValue());
        r112.f84639a.setOnClickListener(new d(r112, r111));
        r112.f84641c.setText(String.valueOf(r111 + 1));
        ImageLoader.bindImage(r112.f84640b, r100.h());
        r112.f84640b.setOnClickListener(new e(r112, r100));
        r112.f84642d.setOnClickListener(new f(r112, r100));
        Drawable r113 = s1.m(R.drawable.ttlive_ic_explain_card_setting_arrow);
        r113.setBounds(0, 0, (int) t6.a(r112.itemView.getContext(), 8.0f), (int) t6.a(r112.itemView.getContext(), 8.0f));
        r112.f84643e.setCompoundDrawables(null, null, r113, null);
        r112.f84643e.setOnClickListener(new g(r112, r100));
        if (r112.f84650l.f84634e == false) goto L9;
        r112.f84639a.setVisibility(0);
        r112.f84646h.setVisibility(8);
        ViewGroup.LayoutParams r114 = r112.f84640b.getLayoutParams();
        if (r114 == null) goto L8;
        int r101 = UtilityKotlinExtentionsKt.i(12);
        ((ViewGroup.MarginLayoutParams) r114).leftMargin = r101;
    L12:
        r112.f84650l.getClass();
        if (r112.f84650l.f84634e == false) goto L15;
        r112.f84643e.setVisibility(8);
        r112.f84640b.setEnabled(false);
        r112.f84642d.setEnabled(false);
    L17:
        if (r112.f84650l.f84637h == true) goto L19;
    L21:
        r112.f84644f.setVisibility(8);
    L23:
        if (r112.f84650l.f84637h == true) goto L25;
        r112.f84645g.setVisibility(8);
    L32:
        r112.f84642d.setText(r100.i(null));
        ProductInfo r115 = r100.getProductInfo();
        com.bytedance.android.live.openplatform.api.utils.a r102 = com.bytedance.android.live.openplatform.api.utils.a.f84001a;
        if (r102.h() == false) goto L68;
        if (r115 == null) goto L68;
        r112.f84643e.setVisibility(8);
        if (r102.i() == false) goto L47;
        List<ProductIntroductionInfo> r103 = r115.introductionList;
        if (r103 != null) goto L40;
    L43:
        boolean r104 = true;
    L44:
        if (r104 == true) goto L47;
        CommonProductIntroductionLayout r105 = r112.f84647i;
        List<ProductIntroductionInfo> r106 = r115.introductionList;
        Intrinsics.checkNotNull(r106);
        r105.r(r102.k(r106));
        r112.f84647i.setVisibility(0);
    L49:
        if (r102.j() == false) goto L60;
        List<ProductLabelInfo> r107 = r115.labelList;
        if (r107 != null) goto L53;
    L56:
        boolean r108 = true;
    L57:
        if (r108 == true) goto L60;
        CommonProductLabelLayout r109 = r112.f84648j;
        List<ProductLabelInfo> r116 = r115.labelList;
        Intrinsics.checkNotNull(r116);
        r109.r(r102.l(r116));
        r112.f84648j.setVisibility(0);
    L62:
        if (r102.e() == false) goto L67;
        ProductPriceInfo r117 = r115.price;
        if (r117 == null) goto L67;
        CommonProductPriceView r118 = r112.f84649k;
        Intrinsics.checkNotNull(r117);
        r118.b(r117);
        r112.f84649k.setVisibility(0);
    L69:
        int r119 = ee0.f120119a.getValue().p();
        if (r119 != 1) goto L72;
        Pair r120 = TuplesKt.to(Integer.valueOf(UtilityKotlinExtentionsKt.i(116)), Integer.valueOf(UtilityKotlinExtentionsKt.i(116)));
    L79:
        int r121 = ((Number) r120.component1()).intValue();
        int r122 = ((Number) r120.component2()).intValue();
        HSImageView r123 = r112.f84640b;
        ViewGroup.LayoutParams r124 = r123.getLayoutParams();
        r124.width = r121;
        r124.height = r122;
        Unit r125 = Unit.INSTANCE;
        r123.setLayoutParams(r124);
        return;
    L72:
        if (r119 == 2) goto L74;
        r120 = TuplesKt.to(Integer.valueOf(UtilityKotlinExtentionsKt.i(87)), Integer.valueOf(UtilityKotlinExtentionsKt.i(87)));
        goto L79
    L74:
        MiniAppDataContext.Companion.getClass();
        if (com.bytedance.android.live.openplatform.api.model.shelf.g.d(MiniAppDataContext.a.b()) == false) goto L77;
        r120 = TuplesKt.to(Integer.valueOf(UtilityKotlinExtentionsKt.i(116)), Integer.valueOf(UtilityKotlinExtentionsKt.i(116)));
        goto L79
    L77:
        r120 = TuplesKt.to(Integer.valueOf(UtilityKotlinExtentionsKt.i(87)), Integer.valueOf(UtilityKotlinExtentionsKt.i(87)));
    L67:
        r112.f84649k.setVisibility(8);
        goto L69
    L53:
        if (r107.isEmpty() == true) goto L56;
        r108 = false;
    L60:
        r112.f84648j.setVisibility(8);
        goto L62
    L40:
        if (r103.isEmpty() == true) goto L43;
        r104 = false;
    L47:
        r112.f84647i.setVisibility(8);
    L68:
        r112.f84647i.setVisibility(8);
        r112.f84648j.setVisibility(8);
        r112.f84649k.setVisibility(8);
        goto L69
    L25:
        if (r100.G0(-1) == false) goto L28;
        r112.f84645g.setVisibility(0);
        r112.f84645g.setText(s1.B(R.string.ttlive_open_platform_custom_card_review_reject));
        r112.f84645g.setTextColor(s1.h(R.color.ttlive_miniapp_card_review_not_pass));
        r112.f84645g.setBackgroundResource(R.drawable.ttlive_open_platform_review_reject_background);
        r112.f84645g.setCompoundDrawablesWithIntrinsicBounds(null, null, s1.m(R.drawable.ttlive_open_platform_review_rejected_icon), null);
        r112.f84645g.setCompoundDrawablePadding((int) t6.a(r112.itemView.getContext(), 2.0f));
        r112.f84645g.setOnClickListener(new h(r112, r100));
        goto L32
    L28:
        if (r100.H0(-1) == false) goto L30;
        r112.f84645g.setVisibility(0);
        r112.f84645g.setText(s1.B(R.string.ttlive_open_platform_custom_card_reviewing));
        r112.f84645g.setTextColor(s1.h(R.color.ttlive_miniapp_card_review_ing));
        r112.f84645g.setBackgroundResource(R.drawable.ttlive_open_platform_reviewing_background);
        r112.f84645g.setCompoundDrawables(null, null, s1.m(R.drawable.ttlive_open_platform_review_rejected_icon), null);
        r112.f84645g.setCompoundDrawablePadding((int) t6.a(r112.itemView.getContext(), 2.0f));
        r112.f84645g.setOnClickListener(null);
        goto L32
    L30:
        r112.f84645g.setVisibility(8);
        goto L32
    L19:
        if (r100.getStatus() != 1) goto L21;
        r112.f84644f.setVisibility(0);
        goto L23
    L15:
        r112.f84643e.setVisibility(0);
        r112.f84640b.setEnabled(true);
        r112.f84642d.setEnabled(true);
        goto L17
    L8:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    L9:
        r112.f84639a.setVisibility(8);
        r112.f84639a.setChecked(false);
        r112.f84646h.setVisibility(0);
        ViewGroup.LayoutParams r126 = r112.f84640b.getLayoutParams();
        if (r126 == null) goto L82;
        ((ViewGroup.MarginLayoutParams) r126).leftMargin = 0;
        goto L12
    L82:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        return new ShelfManagementCardItemViewHolder(this, LayoutInflater.from(r100.getContext()).inflate(R.layout.ttlive_miniapp_shelf_management_item, r100, false));
    }

    @Override // com.bytedance.android.live.openplatform.impl.miniappanchor.shelf.page.management.view.a
    public final void r(RecyclerView.ViewHolder r100, RecyclerView.ViewHolder r101) {
        Intrinsics.checkNotNullParameter(r100, "source");
        Intrinsics.checkNotNullParameter(r101, PickerReporterConstants.KEY.TARGET);
        int r102 = r100.getAdapterPosition();
        int r103 = r101.getAdapterPosition();
        if (r102 < this.f84635f.size()) goto L5;
        return;
    L5:
        if (r103 >= this.f84635f.size()) goto L11;
        Collections.swap(this.f84635f, r102, r103);
        notifyItemMoved(r102, r103);
        notifyItemRangeChanged(Math.min(r102, r103), Math.abs(r102 - r103) + 1);
        b r104 = this.f84632c;
        if (r104 == null) goto L12;
        r104.a();
        return;
    L12:
        return;
    }
}
