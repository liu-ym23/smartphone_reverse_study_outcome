package com.bytedance.android.shopping.anchorv4.voavhs.head.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.bytedance.android.ec.core.opt.asyncInflate.ShoppingAsyncInflater;
import com.bytedance.android.ec.core.utils.y;
import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.shopping.anchorv4.dto.base.FontStyle;
import com.bytedance.android.shopping.anchorv4.dto.base.ImageModel;
import com.bytedance.android.shopping.anchorv4.dto.elements.TextElement;
import com.bytedance.android.shopping.anchorv4.dto.elements.TextWithOneIconElement;
import com.bytedance.android.shopping.anchorv4.voavhs.base.elements.TextElementView;
import com.bytedance.android.shopping.anchorv4.voavhs.base.elements.TextWithOneIconElementView;
import com.facebook.drawee.view.GenericDraweeView;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\t\u001a\u00020\b\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n\u0012\b\b\u0002\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u000e\u0010\u000fR\u001b\u0010\u0007\u001a\u00020\u00028BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/voavhs/head/view/AnchorV4FeaturedCommentView;", "Landroid/widget/FrameLayout;", "Lcom/facebook/drawee/view/SimpleDraweeView;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "Lkotlin/Lazy;", "getBgView", "()Lcom/facebook/drawee/view/SimpleDraweeView;", "bgView", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AnchorV4FeaturedCommentView extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f168869a;

    public AnchorV4FeaturedCommentView(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public AnchorV4FeaturedCommentView(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    private final SimpleDraweeView getBgView() {
        return (SimpleDraweeView) this.f168869a.getValue();
    }

    @Override // android.widget.FrameLayout, android.view.View
    public final void onMeasure(int r100, int r101) {
        super.onMeasure(r100, r100);
    }

    public AnchorV4FeaturedCommentView(final Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f168869a = LazyKt.lazy(new AnchorV4FeaturedCommentView$bgView$2(r100));
        addView(getBgView(), -1, -1);
        ShoppingAsyncInflater.f45268e.getClass();
        ShoppingAsyncInflater.a.a(r100).aU(R.layout.ec_commerce_anchor_v4_featured_comment_layout, this, true).findViewById(R.id.featured_comment_root_view).setBackgroundColor(com.bytedance.android.shopping.extensions.j.b(R.color.shopping_color_CCFFFFFF));
    }

    public final void a(com.bytedance.android.shopping.anchorv4.voavhs.head.holder.b r110, com.bytedance.android.shopping.anchorv4.voavhs.head.base.d r210, boolean r211) {
        SimpleDraweeView r100 = getBgView();
        TextWithOneIconElement r101 = null;
        if (r110 == null) goto L5;
        ECUrlModel r102 = r110.f168678b;
    L6:
        y.a(r100, r102);
        TextWithOneIconElementView r103 = (TextWithOneIconElementView) findViewById(R.id.featured_title);
        if (r103 == null) goto L14;
        if (r110 == null) goto L12;
        FeaturedComment r104 = r110.f168677a;
        if (r104 == null) goto L12;
        TextWithOneIconElement r105 = r104.getFeaturedTitle();
    L13:
        TextWithOneIconElementView.b(r103, r105, null, false, null, 14);
    L12:
        r105 = null;
    L14:
        Iterator r106 = CollectionsKt.listOf(new HeadCommentInfoView[]{(HeadCommentInfoView) findViewById(R.id.featured_comment_info_one), (HeadCommentInfoView) findViewById(R.id.featured_comment_info_two)}).iterator();
        int r107 = 0;
    L16:
        if (r106.hasNext() == false) goto L53;
        Object r108 = r106.next();
        int r111 = r107 + 1;
        if (r107 >= 0) goto L20;
        CollectionsKt.throwIndexOverflow();
    L20:
        HeadCommentInfoView r109 = (HeadCommentInfoView) r108;
        if (r110 == null) goto L51;
        FeaturedComment r112 = r110.f168677a;
        if (r112 == null) goto L51;
        List<CommentInfoVO> r113 = r112.getFeaturedCommentList();
        if (r113 == null) goto L51;
        CommentInfoVO r114 = (CommentInfoVO) CollectionsKt.getOrNull(r113, r107);
        if (r114 == null) goto L51;
        r109.setVisibility(0);
        Intrinsics.checkNotNullParameter(r114, "infoVO");
        ImageModel r115 = r114.getUserAvatar();
        if (r115 == null) goto L33;
        ECUrlModel r116 = r115.getRemote();
        if (r116 == null) goto L33;
        y.a((GenericDraweeView) r109.findViewById(R.id.featured_item_icon), r116);
    L33:
        TextWithOneIconElement r117 = r114.getUserName();
        if (r117 == null) goto L38;
        TextWithOneIconElementView r118 = (TextWithOneIconElementView) r109.findViewById(R.id.featured_item_title);
        if (r118 == null) goto L38;
        TextWithOneIconElementView.b(r118, r117, null, false, null, 14);
    L38:
        TextElement r119 = r114.getContent();
        if (r119 == null) goto L43;
        FontStyle r120 = r119.getFontStyle();
        if (r120 == null) goto L43;
        r120.setLine(2);
    L43:
        TextElementView r121 = (TextElementView) r109.findViewById(R.id.featured_item_content);
        if (r121 == null) goto L46;
        r121.x(r119);
    L46:
        ImageModel r122 = r114.getPhoto();
        if (r122 == null) goto L52;
        ECUrlModel r123 = r122.getRemote();
        if (r123 == null) goto L52;
        y.a((GenericDraweeView) r109.findViewById(R.id.featured_item_photo), r123);
    L52:
        r107 = r111;
    L51:
        r109.setVisibility(8);
        Unit r124 = Unit.INSTANCE;
        goto L52
    L53:
        TextWithOneIconElementView r125 = (TextWithOneIconElementView) findViewById(R.id.featured_more_comment);
        if (r125 == null) goto L63;
        if (r211 == false) goto L57;
        r125.setVisibility(8);
        goto L63
    L57:
        r125.setVisibility(0);
        if (r110 == null) goto L62;
        FeaturedComment r126 = r110.f168677a;
        if (r126 == null) goto L62;
        r101 = r126.getMoreCommentTitle();
    L62:
        TextWithOneIconElementView.b(r125, r101, null, false, null, 14);
        r125.setOnClickListener(new b(r210));
    L63:
        if (r110 == null) goto L67;
        String r127 = r110.f168679c;
        if (r127 == null) goto L67;
    L68:
        setContentDescription(r127);
        if (r211 == false) goto L71;
        setBackgroundColor(-1);
        postDelayed(new d(this), 300);
    L71:
        if (r110 != null) goto L73;
    L74:
        post(new c(this));
        return;
    L73:
        if (r110.f168680d != true) goto L74;
        return;
    L67:
        r127 = "图片，商品评论";
        goto L68
    L5:
        r102 = null;
        goto L6
    }

    public /* synthetic */ AnchorV4FeaturedCommentView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
