package com.bytedance.android.shopping.anchorv3.comment.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import com.bytedance.android.ec.core.imagex.ImageExtensionsKt;
import com.bytedance.android.ec.core.imagex.h0;
import com.bytedance.android.ec.core.imagex.r;
import com.bytedance.android.ec.core.utils.g1;
import com.bytedance.android.ec.core.utils.y;
import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.ec.model.response.Action;
import com.bytedance.android.ec.model.response.MoreActions;
import com.bytedance.android.shopping.anchorv3.comment.CommentViewModel;
import com.bytedance.android.shopping.anchorv3.comment.model.CommentNodeVO;
import com.bytedance.android.shopping.anchorv3.comment.model.RankTypeEnum;
import com.bytedance.android.shopping.widget.legacy.AvatarImageView;
import com.bytedance.android.ui.ec.widget.ecdraweeview.ECDraweeView;
import com.facebook.drawee.drawable.ScalingUtils;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function7;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/shopping/anchorv3/comment/widget/CommentHeaderView;", "Landroid/widget/FrameLayout;", "Lcom/bytedance/android/shopping/anchorv3/comment/model/CommentNodeVO;", "commentNodeVO", "", "setCommentTime", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class CommentHeaderView extends FrameLayout {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final /* synthetic */ int f164603n = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AvatarImageView f164604a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TextView f164605b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final TextView f164606c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ECDraweeView f164607d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final TextView f164608e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final TextView f164609f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final TextView f164610g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final View f164611h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final View f164612i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final ImageView f164613j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final LinearLayout f164614k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f164615l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public CommentNodeVO f164616m;

    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ View f164617a;

        public a(View r100) {
            this.f164617a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            View r100 = this.f164617a;     // Catch: Throwable -> L4
            Intrinsics.checkNotNullParameter(r100, "$this$setBackgroundCompat");     // Catch: Throwable -> L4
            r100.setBackground(null);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public CommentHeaderView(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public CommentHeaderView(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    private final void setCommentTime(CommentNodeVO r100) {
        int r101 = m53.c.f512109a;
        boolean r102 = true;
        if (m53.a.c() != 1) goto L5;
        boolean r103 = true;
    L6:
        if (r103 == false) goto L41;
        int r104 = v53.a.f553245a;
        String r105 = v53.a.a(getContext(), r100.getCommentTime());
        Integer r106 = r100.getRankType();
        if (r106 != null) goto L10;
    L14:
        boolean r107 = false;
    L15:
        if (r107 == false) goto L36;
        int r108 = RankTypeEnum.GOOD.getValue();
        if (r106 != null) goto L20;
    L22:
        int r109 = RankTypeEnum.MIDDLE.getValue();
        if (r106 != null) goto L26;
    L28:
        int r110 = RankTypeEnum.BAD.getValue();
        if (r106 != null) goto L32;
    L34:
        int r111 = g1.f45599a;
        String r112 = g1.a.c(getContext(), R.string.commerce_anchor_v3_comment_good, new Object[0]);
    L35:
        String r113 = g1.a.c(getContext(), R.string.commerce_anchor_v3_comment_publish_comment, new Object[]{r112});
    L37:
        TextView r114 = this.f164608e;
        if (r114 == null) goto L52;
        r114.setText(r105 + ' ' + r113);
        return;
    L52:
        return;
    L32:
        if (r106.intValue() != r110) goto L34;
        int r115 = g1.f45599a;
        r112 = g1.a.c(getContext(), R.string.commerce_anchor_v3_comment_bad, new Object[0]);
        goto L35
    L26:
        if (r106.intValue() != r109) goto L28;
        int r116 = g1.f45599a;
        r112 = g1.a.c(getContext(), R.string.commerce_anchor_v3_comment_middle, new Object[0]);
        goto L35
    L20:
        if (r106.intValue() != r108) goto L22;
        int r117 = g1.f45599a;
        r112 = g1.a.c(getContext(), R.string.commerce_anchor_v3_comment_good, new Object[0]);
        goto L35
    L36:
        int r118 = g1.f45599a;
        r113 = g1.a.c(getContext(), R.string.commerce_anchor_v3_comment_publish_comment_default, new Object[0]);
        goto L37
    L10:
        if (r106.intValue() < RankTypeEnum.GOOD.getValue()) goto L14;
        if (r106.intValue() > RankTypeEnum.BAD.getValue()) goto L14;
        r107 = true;
        goto L15
    L41:
        if (m53.a.c() == 2) goto L44;
        r102 = false;
    L44:
        if (r102 == false) goto L48;
        int r119 = v53.a.f553245a;
        String r120 = v53.a.a(getContext(), r100.getCommentTime());
        int r121 = g1.f45599a;
        String r122 = g1.a.c(getContext(), R.string.commerce_anchor_v3_comment_publish, new Object[0]);
        TextView r123 = this.f164609f;
        if (r123 == null) goto L54;
        r123.setText(r120 + r122);
        return;
    L54:
        return;
    L48:
        int r124 = v53.a.f553245a;
        String r125 = v53.a.a(getContext(), r100.getCommentTime());
        TextView r126 = this.f164608e;
        if (r126 == null) goto L56;
        r126.setText(r125);
        return;
    L56:
        return;
    L5:
        r103 = false;
        goto L6
    }

    public final void c(boolean r100) {
        if (r100 == false) goto L7;
        View r101 = this.f164611h;
        if (r101 == null) goto L11;
        Drawable r102 = getContext().getResources().getDrawable(R.drawable.commerce_comment_bg_insert_comment_content);
        Intrinsics.checkNotNullParameter(r101, "$this$setBackgroundCompat");
        r101.setBackground(r102);
        r101.postDelayed(new a(r101), 5000);
        return;
    L11:
        return;
    L7:
        View r103 = this.f164611h;
        if (r103 == null) goto L13;
        Intrinsics.checkNotNullParameter(r103, "$this$setBackgroundCompat");
        r103.setBackground(null);
        return;
    }

    public final void b(boolean r110, String r111) {
        CommentNodeVO r100 = this.f164616m;
        if (r100 == null) goto L10;
        t53.b r101 = t53.b.f544622a;
        CommentHeaderView$mobProductCommentTag$1$show$1 r102 = new CommentHeaderView$mobProductCommentTag$1$show$1(r101);
        CommentHeaderView$mobProductCommentTag$1$click$1 r103 = new CommentHeaderView$mobProductCommentTag$1$click$1(r101);
        if (r110 == false) goto L7;
        Function7 r104 = r102;
    L8:
        Context r105 = getContext();
        Long r106 = Long.valueOf(r100.getProductId());
        Long r107 = Long.valueOf(r100.getOrderId());
        Long r108 = Long.valueOf(r100.getId());
        Long r109 = Long.valueOf(this.f164615l);
        String r112 = o53.b.f522096a;
        r104.invoke(r105, r106, r107, r108, r109, o53.b.f522098c, r111);
        return;
    L7:
        r104 = r103;
        goto L8
    }

    public CommentHeaderView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        LayoutInflater.from(r100).inflate(R.layout.ec_commerce_comment_item_header_new_layout, this);
        this.f164604a = (AvatarImageView) findViewById(R.id.comment_sv_user_avatar);
        this.f164605b = (TextView) findViewById(R.id.comment_tv_user_name);
        this.f164606c = (TextView) findViewById(R.id.comment_tv_sku_info);
        this.f164607d = (ECDraweeView) findViewById(R.id.comment_iv_rank_icon);
        TextView r103 = (TextView) findViewById(R.id.comment_tv_comment_time);
        this.f164608e = r103;
        this.f164610g = (TextView) findViewById(R.id.comment_tv_comment_shop);
        TextView r104 = (TextView) findViewById(R.id.comment_tv_comment_time_new);
        this.f164609f = r104;
        LinearLayout r105 = (LinearLayout) findViewById(R.id.user_name_container);
        ECDraweeView r106 = (ECDraweeView) findViewById(R.id.comment_item_sv_rank_type);
        this.f164611h = findViewById(R.id.comment_sku_info_container);
        ECDraweeView r107 = (ECDraweeView) findViewById(R.id.ic_comment_rank_info_view);
        ECDraweeView r108 = (ECDraweeView) findViewById(R.id.ic_comment_repeat_customer_tag);
        ECDraweeView r109 = (ECDraweeView) findViewById(R.id.ic_mall_gold_card_tag);
        ECDraweeView r110 = (ECDraweeView) findViewById(R.id.comment_ic_shopping_fans_group);
        TextView r111 = (TextView) findViewById(R.id.comment_shopping_fans_group_des);
        this.f164612i = findViewById(R.id.comment_shopping_fans_group_container);
        this.f164614k = (LinearLayout) findViewById(R.id.comment_tag_container);
        ConstraintLayout r112 = (ConstraintLayout) findViewById(R.id.header_hot_zone_container);
        this.f164613j = (ImageView) findViewById(R.id.more_actions_iv);
        int r113 = m53.c.f512109a;
        boolean r114 = true;
        if (m53.a.c() != 2) goto L5;
        boolean r115 = true;
    L7:
        if (r115 == false) goto L21;
        if (r103 != null) goto L10;
    L11:
        if (r103 == null) goto L13;
        r103.setVisibility(8);
    L13:
        if (r104 != null) goto L15;
    L16:
        if (r104 == null) goto L18;
        r104.setVisibility(0);
    L18:
        if (r112 == null) goto L39;
        if (r105 == null) goto L40;
        ConstraintSet r116 = new ConstraintSet();
        r116.clone(r112);
        r116.connect(r105.getId(), 4, 0, 4);
        r116.applyTo(r112);
        return;
    L40:
        return;
    L39:
        return;
    L15:
        if (r104.getVisibility() == 0) goto L18;
    L10:
        if (r103.getVisibility() == 8) goto L13;
    L21:
        if (r103 != null) goto L23;
    L24:
        if (r103 == null) goto L26;
        r103.setVisibility(0);
    L26:
        if (r104 != null) goto L28;
    L29:
        if (r104 == null) goto L32;
        r104.setVisibility(8);
    L32:
        if (m53.a.c() == 1) goto L35;
        r114 = false;
    L35:
        if (r114 == false) goto L42;
        if (r103 == null) goto L43;
        int r117 = g1.f45599a;
        r103.setTextColor(g1.a.a(r100, R.color.commerce_color_57161823));
        return;
    L43:
        return;
    L42:
        return;
    L28:
        if (r104.getVisibility() == 8) goto L32;
    L23:
        if (r103.getVisibility() == 0) goto L26;
    L5:
        r115 = false;
        goto L7
    }

    public final void a(CommentNodeVO r110, CommentViewModel r210, int r211) {
        Intrinsics.checkNotNullParameter(r110, "commentNodeVO");
        Intrinsics.checkNotNullParameter(r210, "viewModel");
        this.f164615l = r211;
        this.f164616m = r110;
        AvatarImageView r100 = this.f164604a;
        r r101 = new r("ec_comment", "comment_cellUserHead");
        List<String> r102 = m53.a.a();
        Intrinsics.checkNotNullParameter(r102, "$this$isHitExp");
        boolean r103 = true;
        r101.g("ec_comment_enable_preconnect", Integer.valueOf(!r102.isEmpty() ? 1 : 0));
        Unit r104 = Unit.INSTANCE;
        ImageExtensionsKt.D(r100, r101);
        y.c(this.f164604a, r110.getUserAvatar(), com.bytedance.android.shopping.extensions.b.b(32), com.bytedance.android.shopping.extensions.b.b(32), null);
        this.f164605b.setText(r110.getUserName());
        this.f164606c.setText(r110.getSku());
        TextView r105 = this.f164610g;
        if (r105 == null) goto L5;
        r105.setText(r110.getShopDescription());
    L5:
        String r106 = r110.getShopDescription();
        if (r106 != null) goto L8;
    L11:
        boolean r107 = true;
    L13:
        if (r107 == false) goto L17;
        TextView r108 = this.f164610g;
        if (r108 == null) goto L20;
        r108.setVisibility(8);
    L20:
        CommentNodeVO r109 = this.f164616m;
        if (r109 == null) goto L23;
        List<p53.i> r111 = r109.getTagsInfo();
    L24:
        List<p53.i> r112 = r111;
        if (r112 != null) goto L27;
    L30:
        boolean r113 = true;
    L31:
        if (r113 == false) goto L35;
        LinearLayout r114 = this.f164614k;
        if (r114 == null) goto L93;
        r114.setVisibility(8);
    L93:
        setCommentTime(r110);
        ECUrlModel r115 = r110.getRankTypeIcon();
        ECDraweeView r116 = this.f164607d;
        if (r115 == null) goto L97;
        if (r116 == null) goto L97;
        r116.setVisibility(0);
        wg.a.d(r116, com.bytedance.android.shopping.extensions.b.b(Integer.valueOf(r115.getHeight())));
        wg.a.i(r116, com.bytedance.android.shopping.extensions.b.b(Integer.valueOf(r115.getWidth())));
        h0 r117 = h0.f44678a;
        com.bytedance.android.shopping.store.tabkit.e.g(r116, r115);
        Unit r118 = Unit.INSTANCE;
    L98:
        if (r118 != null) goto L102;
        ECDraweeView r119 = this.f164607d;
        if (r119 == null) goto L102;
        r119.setVisibility(8);
        Unit r120 = Unit.INSTANCE;
    L102:
        MoreActions r121 = r110.getMoreActions();
        if (r121 == null) goto L118;
        List<Action> r122 = r121.getActions();
        if (r122 != null) goto L107;
    L110:
        boolean r123 = true;
    L111:
        if (r123 == true) goto L118;
        ImageView r124 = this.f164613j;
        if (r124 == null) goto L115;
        r124.setVisibility(0);
    L115:
        ImageView r125 = this.f164613j;
        if (r125 == null) goto L133;
        r125.setOnClickListener(new d(this, r121));
        return;
    L133:
        return;
    L107:
        if (r122.isEmpty() == true) goto L110;
        r123 = false;
    L118:
        ImageView r126 = this.f164613j;
        if (r126 == null) goto L121;
        r126.setVisibility(8);
    L121:
        ImageView r127 = this.f164613j;
        if (r127 == null) goto L135;
        r127.setOnClickListener(null);
        return;
    L135:
        return;
    L97:
        r118 = null;
        goto L98
    L35:
        LinearLayout r128 = this.f164614k;
        if (r128 == null) goto L38;
        r128.setVisibility(0);
    L38:
        LinearLayout r129 = this.f164614k;
        if (r129 == null) goto L41;
        r129.removeAllViews();
    L41:
        Iterator<T> r130 = r111.iterator();
    L43:
        if (r130.hasNext() == false) goto L93;
        p53.i r131 = (p53.i) r130.next();
        ECDraweeView r132 = new ECDraweeView(getContext(), null, 0, 6, null);
        ECUrlModel r133 = r131.f527783c;
        if (r133 == null) goto L47;
        int r134 = r133.getWidth();
    L48:
        int r135 = r132.getDp(Integer.valueOf(r134));
        ECUrlModel r136 = r131.f527783c;
        if (r136 == null) goto L51;
        int r137 = r136.getHeight();
    L52:
        r132.setLayoutParams(new ViewGroup.MarginLayoutParams(r135, r132.getDp(Integer.valueOf(r137))));
        ViewGroup.LayoutParams r138 = r132.getLayoutParams();
        if ((r138 instanceof ViewGroup.MarginLayoutParams) == true) goto L55;
        r138 = null;
    L55:
        ViewGroup.MarginLayoutParams r139 = (ViewGroup.MarginLayoutParams) r138;
        if (r139 == null) goto L58;
        r139.setMarginStart(r132.getDp(4));
        r139.topMargin = r132.getDp(Double.valueOf(0.5d));
        r132.setLayoutParams(r139);
    L58:
        GenericDraweeHierarchy r140 = (GenericDraweeHierarchy) r132.getHierarchy();
        if (r140 == null) goto L61;
        r140.setActualImageScaleType(ScalingUtils.ScaleType.FIT_XY);
    L61:
        String r141 = r131.f527781a;
        if (r141 != null) goto L64;
        r141 = "";
    L64:
        b(r103, r141);
        h0.d(r132, r131.f527783c, new r("ec_comment", com.bytedance.android.ec.core.event.a.KEY_COMMENT_TAG), null, null, null, null, 120);
        LinearLayout r142 = this.f164614k;
        if (r142 == null) goto L67;
        r142.addView(r132);
    L67:
        String r143 = r131.f527781a;
        if (r143 == null) goto L92;
        int r144 = r143.hashCode();
        if (r144 == 50) goto L90;
        if (r144 != 52) goto L92;
        if (r143.equals("4") == false) goto L92;
        CommentNodeVO r145 = this.f164616m;
        if (r145 == null) goto L80;
        String r146 = r145.getGoldCardSchema();
    L81:
        if (r146 != null) goto L83;
    L86:
        boolean r147 = true;
    L87:
        if (r147 == true) goto L92;
        r132.setOnClickListener(new c(r131, r146, this));
        goto L92
    L83:
        if (r146.length() == 0) goto L86;
        r147 = false;
        goto L87
    L80:
        r146 = null;
        goto L81
    L90:
        if (r143.equals("2") == false) goto L92;
        r132.setOnClickListener(new b(this));
    L92:
        r103 = true;
        goto L43
    L51:
        r137 = 13;
        goto L52
    L47:
        r134 = 45;
        goto L48
    L27:
        if (r112.isEmpty() == true) goto L30;
        r113 = false;
        goto L31
    L23:
        r111 = null;
        goto L24
    L17:
        TextView r148 = this.f164610g;
        if (r148 == null) goto L20;
        r148.setVisibility(0);
        goto L20
    L8:
        if (r106.length() == 0) goto L11;
        r107 = false;
        goto L13
    }

    public /* synthetic */ CommentHeaderView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
