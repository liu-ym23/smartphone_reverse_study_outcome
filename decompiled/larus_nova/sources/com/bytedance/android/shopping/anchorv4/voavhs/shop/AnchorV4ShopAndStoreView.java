package com.bytedance.android.shopping.anchorv4.voavhs.shop;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.byted.cast.linkcommon.cybergarage.upnp.RootDescription;
import com.bytedance.android.ec.core.opt.asyncInflate.ShoppingAsyncInflater;
import com.bytedance.android.ec.core.utils.y;
import com.bytedance.android.ec.core.widget.RoundedFrameLayout;
import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.shopping.anchorv3.view.AnchorV3RecInShopBoxView;
import com.bytedance.android.shopping.anchorv4.dto.base.Action;
import com.bytedance.android.shopping.anchorv4.dto.base.Background;
import com.bytedance.android.shopping.anchorv4.dto.base.Border;
import com.bytedance.android.shopping.anchorv4.dto.base.ImageModel;
import com.bytedance.android.shopping.anchorv4.dto.base.Radius;
import com.bytedance.android.shopping.anchorv4.dto.elements.MediaBoxElement;
import com.bytedance.android.shopping.anchorv4.dto.elements.TextElement;
import com.bytedance.android.shopping.anchorv4.dto.elements.TextWithOneIconElement;
import com.bytedance.android.shopping.anchorv4.vm.AnchorV4VM;
import com.bytedance.android.shopping.anchorv4.voavhs.base.components.LongContentLabelComponentView;
import com.bytedance.android.shopping.anchorv4.voavhs.base.components.TagsScrollBoxComponentView;
import com.bytedance.android.shopping.anchorv4.voavhs.base.design.ActionHubAccessor;
import com.bytedance.android.shopping.anchorv4.voavhs.base.elements.IconsWithSpaceElementView;
import com.bytedance.android.shopping.anchorv4.voavhs.base.elements.LynxCardView;
import com.bytedance.android.shopping.anchorv4.voavhs.base.elements.MediaBoxElementView;
import com.bytedance.android.shopping.anchorv4.voavhs.base.elements.TextElementView;
import com.bytedance.android.shopping.anchorv4.voavhs.base.elements.TextWithOneIconElementView;
import com.bytedance.android.shopping.anchorv4.voavhs.base.extensions.ExtensionsKt;
import com.bytedance.android.shopping.anchorv4.voavhs.base.extensions.ImageExtensionsKt;
import com.bytedance.android.ui.ec.widget.ecdraweeview.ECDraweeView;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u0007J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¨\u0006\b"}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/voavhs/shop/AnchorV4ShopAndStoreView;", "Landroid/widget/LinearLayout;", "Lcom/bytedance/android/shopping/anchorv4/voavhs/base/design/ActionHubAccessor;", "Lcom/bytedance/android/shopping/anchorv4/voavhs/base/design/a;", "hub", "", "setActionHub", "StarType", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AnchorV4ShopAndStoreView extends LinearLayout implements ActionHubAccessor {
    public LongContentLabelComponentView A;
    public TagsScrollBoxComponentView B;
    public LongContentLabelComponentView C;
    public TextElementView D;
    public TextWithOneIconElementView E;
    public TextWithOneIconElementView F;
    public SimpleDraweeView G;
    public ConstraintLayout H;
    public View H0;
    public final com.bytedance.android.shopping.anchorv4.voavhs.base.extensions.b I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public AnchorV4VM f170074J;
    public LinearLayout K;
    public LinearLayout L;
    public View L0;
    public LinearLayout M;
    public LinearLayout N;
    public View O;
    public View P;
    public Boolean P0;
    public RoundedFrameLayout Q;
    public TextWithOneIconElementView R;
    public AnchorV4ShopAndStoreMeta S;
    public ECDraweeView T;
    public View U;
    public TextWithOneIconElementView V;
    public com.bytedance.android.shopping.anchorv4.voavhs.base.design.a V0;
    public TagsScrollBoxComponentView W;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public LinearLayout f170075a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ConstraintLayout f170076b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public LinearLayout f170077c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public MediaBoxElementView f170078d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public TextWithOneIconElementView f170079e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public View f170080f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public TextWithOneIconElementView f170081g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public TextWithOneIconElementView f170082h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public TextWithOneIconElementView f170083i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public IconsWithSpaceElementView f170084j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public LinearLayout f170085k;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    public TextWithOneIconElementView f170086k0;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public View f170087l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public TextElementView f170088m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public TextElementView f170089n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public View f170090o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public LynxCardView f170091p;

    /* JADX INFO: renamed from: p0, reason: collision with root package name */
    public View f170092p0;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public TextElementView f170093q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public LinearLayout f170094r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public View f170095s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public TextElementView f170096t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public LongContentLabelComponentView f170097u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public LongContentLabelComponentView f170098v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public LongContentLabelComponentView f170099w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public AnchorV3RecInShopBoxView f170100x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public TextWithOneIconElementView f170101y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public TextElementView f170102z;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/voavhs/shop/AnchorV4ShopAndStoreView$StarType;", "", "FULL", "HALF", "BLANK", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum StarType extends Enum<StarType> {
        public static final StarType BLANK = null;
        public static final StarType FULL = null;
        public static final StarType HALF = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ StarType[] f170103a = null;

        static {
            StarType r100 = new StarType("FULL", 0);
            FULL = r100;
            StarType r101 = new StarType("HALF", 1);
            HALF = r101;
            StarType r102 = new StarType("BLANK", 2);
            BLANK = r102;
            f170103a = new StarType[]{r100, r101, r102};
        }

        public static StarType valueOf(String r100) {
            return (StarType) r27.a.a(StarType.class, r100);
        }

        public static StarType[] values() {
            return (StarType[]) f170103a.clone();
        }

        public StarType(String r100, int r101) {
            super(r100, r101);
        }
    }

    public AnchorV4ShopAndStoreView(Context r100) {
        this(r100, null, 0, 14);
    }

    public AnchorV4ShopAndStoreView(Context r100, AttributeSet r101) {
        this(r100, r101, 0, 12);
    }

    public AnchorV4ShopAndStoreView(Context r100, AttributeSet r101, int r102) {
        this(r100, r101, r102, 8);
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.base.design.ActionHubAccessor
    public final Action associatedAction() {
        return null;
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.base.design.ActionHubAccessor
    public final Object descriptionVO() {
        return null;
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.base.design.ActionHubAccessor
    public final com.bytedance.android.shopping.anchorv4.voavhs.base.design.a actionHub() {
        return this.V0;
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.base.design.ActionHubAccessor
    public final void dispatchPossibleShow() {
        ActionHubAccessor.DefaultImpls.b(this);
    }

    public final void a(AnchorV4ShopAndStoreDisplay r110) {
        AnchorV4ShopDetailMainInfo r100 = r110.getShopDetailMainInfo();
        ViewGroup.LayoutParams r101 = null;
        List<TextElement> r102 = null;
        if (r100 == null) goto L45;
        LinearLayout r111 = this.f170085k;
        if (r111 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("llScore");
    L7:
        r111.setVisibility(8);
        TextWithOneIconElement r112 = r100.getShopRating();
        if (r112 == null) goto L16;
        TextWithOneIconElementView r113 = this.R;
        if (r113 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("mainInfoScore");
    L12:
        r113.setVisibility(0);
        TextWithOneIconElementView r114 = this.R;
        if (r114 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("mainInfoScore");
    L15:
        TextWithOneIconElementView.b(r114, r112, null, false, null, 14);
    L20:
        List<TextElement> r103 = r100.getTextArray();
        if (r103 != null) goto L23;
    L41:
        View r104 = this.f170087l;
        if (r104 != null) goto L44;
        Intrinsics.throwUninitializedPropertyAccessException("llFollowAndSales");
    L44:
        r104.setVisibility(8);
        return;
    L23:
        if ((!r103.isEmpty()) == false) goto L25;
        r102 = r103;
    L25:
        if (r102 == null) goto L41;
        View r105 = this.f170087l;
        if (r105 != null) goto L29;
        Intrinsics.throwUninitializedPropertyAccessException("llFollowAndSales");
    L29:
        r105.setVisibility(0);
        TextElementView r106 = this.f170088m;
        if (r106 != null) goto L32;
        Intrinsics.throwUninitializedPropertyAccessException("tivFollow");
    L32:
        r106.x((TextElement) CollectionsKt.getOrNull(r102, 0));
        TextElementView r107 = this.f170089n;
        if (r107 != null) goto L35;
        Intrinsics.throwUninitializedPropertyAccessException("tivSales");
    L35:
        r107.x((TextElement) CollectionsKt.getOrNull(r102, 1));
        if (r102.size() > 1) goto L80;
        View r108 = this.f170090o;
        if (r108 != null) goto L40;
        Intrinsics.throwUninitializedPropertyAccessException("followDivider");
    L40:
        r108.setVisibility(8);
        return;
    L80:
        return;
    L16:
        TextWithOneIconElementView r115 = this.R;
        if (r115 != null) goto L19;
        Intrinsics.throwUninitializedPropertyAccessException("mainInfoScore");
    L19:
        r115.setVisibility(8);
        Unit r116 = Unit.INSTANCE;
        goto L20
    L45:
        List<TextElement> r109 = r110.getFollowAndSellInfo();
        if (r109 != null) goto L48;
        return;
    L48:
        if (r109.isEmpty() == false) goto L53;
        View r117 = this.f170087l;
        if (r117 != null) goto L52;
        Intrinsics.throwUninitializedPropertyAccessException("llFollowAndSales");
    L52:
        r117.setVisibility(8);
        return;
    L53:
        TextElementView r118 = this.f170088m;
        if (r118 != null) goto L56;
        Intrinsics.throwUninitializedPropertyAccessException("tivFollow");
    L56:
        ViewGroup.LayoutParams r119 = r118.getLayoutParams();
        if ((r119 instanceof ViewGroup.MarginLayoutParams) == false) goto L60;
        r101 = r119;
    L60:
        ViewGroup.MarginLayoutParams r120 = (ViewGroup.MarginLayoutParams) r101;
        if (r120 == null) goto L63;
        r120.leftMargin = com.bytedance.android.shopping.extensions.b.b(0);
        r118.setLayoutParams(r120);
    L63:
        TextElementView r121 = this.f170088m;
        if (r121 != null) goto L66;
        Intrinsics.throwUninitializedPropertyAccessException("tivFollow");
    L66:
        r121.x((TextElement) CollectionsKt.getOrNull(r109, 0));
        TextElementView r122 = this.f170089n;
        if (r122 != null) goto L69;
        Intrinsics.throwUninitializedPropertyAccessException("tivSales");
    L69:
        r122.x((TextElement) CollectionsKt.getOrNull(r109, 1));
        if (r109.size() > 1) goto L75;
        View r123 = this.f170090o;
        if (r123 != null) goto L74;
        Intrinsics.throwUninitializedPropertyAccessException("followDivider");
    L74:
        r123.setVisibility(8);
    L75:
        View r124 = this.f170087l;
        if (r124 != null) goto L78;
        Intrinsics.throwUninitializedPropertyAccessException("llFollowAndSales");
    L78:
        r124.setVisibility(0);
    }

    public final void b(AnchorV4ShopAndStoreDisplay r110) {
        AnchorV4ShopAmbient r111 = r110.getShopAmbient();
        if (r111 == null) goto L68;
        LinearLayout r100 = this.f170077c;
        if (r100 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("llShopExtra");
    L7:
        ViewGroup.LayoutParams r101 = r100.getLayoutParams();
        if ((r101 instanceof ViewGroup.MarginLayoutParams) == true) goto L10;
        r101 = null;
    L10:
        ViewGroup.MarginLayoutParams r102 = (ViewGroup.MarginLayoutParams) r101;
        if (r102 == null) goto L13;
        r102.topMargin = 0;
        r100.setLayoutParams(r102);
    L13:
        LinearLayout r103 = this.f170077c;
        if (r103 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("llShopExtra");
    L16:
        r103.setBackground(com.bytedance.commerce.base.drawable.a.a(AnchorV4ShopAndStoreView$bindShopAmbient$1$2.INSTANCE));
        LinearLayout r104 = this.f170075a;
        if (r104 != null) goto L19;
        Intrinsics.throwUninitializedPropertyAccessException("llShopInfo");
    L19:
        ViewGroup.LayoutParams r105 = r104.getLayoutParams();
        if ((r105 instanceof ViewGroup.MarginLayoutParams) == true) goto L22;
        r105 = null;
    L22:
        ViewGroup.MarginLayoutParams r106 = (ViewGroup.MarginLayoutParams) r105;
        if (r106 == null) goto L25;
        r106.topMargin = com.bytedance.android.shopping.extensions.b.b(14);
        r104.setLayoutParams(r106);
    L25:
        ConstraintLayout r107 = this.H;
        if (r107 != null) goto L28;
        Intrinsics.throwUninitializedPropertyAccessException("shopContainer");
    L28:
        ExtensionsKt.j(r107, r111.getBackGround());
        TextWithOneIconElement r108 = r111.getTitle();
        if (r108 == null) goto L37;
        TextWithOneIconElementView r109 = this.E;
        if (r109 != null) goto L33;
        Intrinsics.throwUninitializedPropertyAccessException("shopAmbientTitle");
    L33:
        r109.setVisibility(0);
        TextWithOneIconElementView r112 = this.E;
        if (r112 != null) goto L36;
        Intrinsics.throwUninitializedPropertyAccessException("shopAmbientTitle");
    L36:
        TextWithOneIconElementView.b(r112, r108, null, false, null, 14);
    L41:
        TextWithOneIconElement r113 = r111.getSlogan();
        if (r113 == null) goto L50;
        TextWithOneIconElementView r114 = this.F;
        if (r114 != null) goto L46;
        Intrinsics.throwUninitializedPropertyAccessException("shopAmbientSlogan");
    L46:
        r114.setVisibility(0);
        TextWithOneIconElementView r115 = this.F;
        if (r115 != null) goto L49;
        Intrinsics.throwUninitializedPropertyAccessException("shopAmbientSlogan");
    L49:
        TextWithOneIconElementView.b(r115, r113, null, false, null, 14);
    L54:
        ImageModel r116 = r111.getShading();
        if (r116 == null) goto L63;
        SimpleDraweeView r117 = this.G;
        if (r117 != null) goto L59;
        Intrinsics.throwUninitializedPropertyAccessException("shopAmbientShading");
    L59:
        r117.setVisibility(0);
        SimpleDraweeView r118 = this.G;
        if (r118 != null) goto L62;
        Intrinsics.throwUninitializedPropertyAccessException("shopAmbientShading");
    L62:
        ImageExtensionsKt.d(r118, r116, null);
        return;
    L63:
        SimpleDraweeView r119 = this.G;
        if (r119 != null) goto L66;
        Intrinsics.throwUninitializedPropertyAccessException("shopAmbientShading");
    L66:
        r119.setVisibility(8);
        return;
    L50:
        TextWithOneIconElementView r120 = this.F;
        if (r120 != null) goto L53;
        Intrinsics.throwUninitializedPropertyAccessException("shopAmbientSlogan");
    L53:
        r120.setVisibility(8);
        Unit r121 = Unit.INSTANCE;
        goto L54
    L37:
        TextWithOneIconElementView r122 = this.E;
        if (r122 != null) goto L40;
        Intrinsics.throwUninitializedPropertyAccessException("shopAmbientTitle");
    L40:
        r122.setVisibility(8);
        Unit r123 = Unit.INSTANCE;
        goto L41
    }

    public final void c(AnchorV4ShopAndStoreDisplay r110) {
        ConstraintLayout r100 = this.f170076b;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("clShopInfo");
    L5:
        ExtensionsKt.j(r100, r110.getBasicInfoBg());
        MediaBoxElement r101 = r110.getShopAvatarBorder();
        ViewGroup.LayoutParams r102 = null;
        if (r101 == null) goto L10;
        ImageModel r103 = r101.getImageModel();
        if (r103 == null) goto L10;
        ECUrlModel r104 = r103.getRemote();
    L11:
        if (r104 == null) goto L16;
        ECDraweeView r105 = this.T;
        if (r105 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("shopAvatarLive");
    L15:
        y.a(r105, r104);
    L16:
        boolean r106 = true;
        MediaBoxElement r107 = r110.getShopAvatarBorder();     // Catch: Exception -> L30
        if (r107 == null) goto L31;
        Background r108 = r107.getBackground();     // Catch: Exception -> L30
        if (r108 == null) goto L31;
        Border r109 = r108.getBorder();     // Catch: Exception -> L30
        if (r109 == null) goto L31;
        String r111 = r109.getBorderColor();     // Catch: Exception -> L30
        if (r111 == null) goto L31;
        GradientDrawable r112 = new GradientDrawable();     // Catch: Exception -> L30
        r112.setShape(1);     // Catch: Exception -> L30
        r112.setStroke(com.bytedance.android.shopping.extensions.b.b(Double.valueOf(0.5d)), Color.parseColor(r111));     // Catch: Exception -> L30
        View r113 = this.U;     // Catch: Exception -> L30
        if (r113 != null) goto L28;
        Intrinsics.throwUninitializedPropertyAccessException("shopAvatarBorder");     // Catch: Exception -> L30
    L28:
        r113.setBackgroundDrawable(r112);     // Catch: Exception -> L30
    L31:
        TextWithOneIconElementView r114 = this.V;
        if (r114 != null) goto L34;
        Intrinsics.throwUninitializedPropertyAccessException("shopAvatarTag");
    L34:
        TextWithOneIconElementView.b(r114, r110.getShopAvatarTag(), null, false, null, 14);
        TagsScrollBoxComponentView r115 = this.W;
        if (r115 != null) goto L37;
        Intrinsics.throwUninitializedPropertyAccessException("shopScoreIcons");
    L37:
        TagsScrollBoxComponentView.b(r115, r110.getShopScoreIcons(), null, 14);
        TextWithOneIconElement r116 = r110.getShopScoreText();
        int r117 = 0;
        if (r116 == null) goto L56;
        TextElement r118 = r116.getContent();
        if (r118 == null) goto L56;
        String r119 = r118.getText();
        if (r119 == null) goto L56;
        if (StringsKt.contains$default(r119, " ", false, 2, null) == true) goto L56;
        TextWithOneIconElement r120 = r110.getShopScoreText();
        if (r120 == null) goto L56;
        TextElement r121 = r120.getContent();
        if (r121 == null) goto L56;
        TextWithOneIconElement r122 = r110.getShopScoreText();
        if (r122 == null) goto L54;
        TextElement r123 = r122.getContent();
        if (r123 == null) goto L54;
        String r124 = r123.getText();
    L55:
        r121.setText(Intrinsics.stringPlus(r124, " "));
    L54:
        r124 = null;
    L56:
        TextWithOneIconElementView r125 = this.f170086k0;
        if (r125 != null) goto L59;
        Intrinsics.throwUninitializedPropertyAccessException("shopScoreText");
    L59:
        TextWithOneIconElementView.b(r125, r110.getShopScoreText(), null, false, null, 14);
        TextWithOneIconElementView r126 = this.f170086k0;
        if (r126 != null) goto L62;
        Intrinsics.throwUninitializedPropertyAccessException("shopScoreText");
    L62:
        r126.getTextElementView().setTypeface(Typeface.SANS_SERIF, 3);
        TextWithOneIconElementView r127 = this.f170086k0;
        if (r127 != null) goto L65;
        Intrinsics.throwUninitializedPropertyAccessException("shopScoreText");
    L65:
        r127.getTextElementView().setGravity(17);
        TextWithOneIconElementView r128 = this.f170086k0;
        if (r128 != null) goto L68;
        Intrinsics.throwUninitializedPropertyAccessException("shopScoreText");
    L68:
        TextElementView r129 = r128.getTextElementView();
        ViewGroup.LayoutParams r130 = r129.getLayoutParams();
        if ((r130 instanceof ViewGroup.MarginLayoutParams) == true) goto L71;
        r130 = null;
    L71:
        ViewGroup.MarginLayoutParams r131 = (ViewGroup.MarginLayoutParams) r130;
        if (r131 == null) goto L75;
        r131.bottomMargin = com.bytedance.android.shopping.extensions.b.b(1);
        r129.setLayoutParams(r131);
    L75:
        if (r110.getShopStructOptimize() == false) goto L185;
        View r132 = this.f170092p0;
        if (r132 != null) goto L79;
        Intrinsics.throwUninitializedPropertyAccessException("shopRankListViewDivider");
    L79:
        LongContentLabelComponentView r133 = this.A;
        if (r133 != null) goto L83;
        Intrinsics.throwUninitializedPropertyAccessException("shopRankListView");
    L83:
        if (r133.getVisibility() != 0) goto L85;
        boolean r134 = true;
    L87:
        if (r134 == false) goto L97;
        LynxCardView r135 = this.f170091p;
        if (r135 != null) goto L92;
        Intrinsics.throwUninitializedPropertyAccessException("storeReputationLynxView");
    L92:
        if (r135.getVisibility() != 0) goto L94;
        boolean r136 = true;
    L95:
        if (r136 == false) goto L97;
        int r137 = 0;
    L98:
        r132.setVisibility(r137);
        View r138 = this.H0;
        if (r138 != null) goto L101;
        Intrinsics.throwUninitializedPropertyAccessException("shopCouponViewDivider");
    L101:
        LongContentLabelComponentView r139 = this.f170097u;
        if (r139 != null) goto L105;
        Intrinsics.throwUninitializedPropertyAccessException("shopCouponView");
    L105:
        if (r139.getVisibility() != 0) goto L107;
        boolean r140 = true;
    L108:
        if (r140 == false) goto L126;
        LynxCardView r141 = this.f170091p;
        if (r141 != null) goto L113;
        Intrinsics.throwUninitializedPropertyAccessException("storeReputationLynxView");
    L113:
        if (r141.getVisibility() != 0) goto L115;
        boolean r142 = true;
    L116:
        if (r142 == true) goto L125;
        LongContentLabelComponentView r143 = this.A;
        if (r143 != null) goto L121;
        Intrinsics.throwUninitializedPropertyAccessException("shopRankListView");
    L121:
        if (r143.getVisibility() != 0) goto L123;
        boolean r144 = true;
    L124:
        if (r144 == false) goto L126;
    L123:
        r144 = false;
    L125:
        int r145 = 0;
    L127:
        r138.setVisibility(r145);
        View r146 = this.L0;
        if (r146 != null) goto L130;
        Intrinsics.throwUninitializedPropertyAccessException("llShopExtraDivider");
    L130:
        LinearLayout r147 = this.f170077c;
        if (r147 != null) goto L134;
        Intrinsics.throwUninitializedPropertyAccessException("llShopExtra");
    L134:
        if (r147.getVisibility() != 0) goto L136;
        boolean r148 = true;
    L137:
        if (r148 == false) goto L163;
        LynxCardView r149 = this.f170091p;
        if (r149 != null) goto L142;
        Intrinsics.throwUninitializedPropertyAccessException("storeReputationLynxView");
    L142:
        if (r149.getVisibility() != 0) goto L144;
        boolean r150 = true;
    L145:
        if (r150 == true) goto L164;
        LongContentLabelComponentView r151 = this.A;
        if (r151 != null) goto L150;
        Intrinsics.throwUninitializedPropertyAccessException("shopRankListView");
    L150:
        if (r151.getVisibility() != 0) goto L152;
        boolean r152 = true;
    L153:
        if (r152 == true) goto L164;
        LongContentLabelComponentView r153 = this.f170097u;
        if (r153 != null) goto L158;
        Intrinsics.throwUninitializedPropertyAccessException("shopCouponView");
    L158:
        if (r153.getVisibility() == 0) goto L161;
        r106 = false;
    L161:
        if (r106 == false) goto L163;
    L152:
        r152 = false;
    L164:
        r146.setVisibility(r117);
        LinearLayout r154 = this.f170077c;
        if (r154 != null) goto L167;
        Intrinsics.throwUninitializedPropertyAccessException("llShopExtra");
    L167:
        ViewGroup.LayoutParams r155 = r154.getLayoutParams();
        if ((r155 instanceof ViewGroup.MarginLayoutParams) == false) goto L171;
        r102 = r155;
    L171:
        ViewGroup.MarginLayoutParams r156 = (ViewGroup.MarginLayoutParams) r102;
        if (r156 == null) goto L174;
        r156.topMargin = com.bytedance.android.shopping.extensions.b.b(3);
        r154.setLayoutParams(r156);
    L174:
        TextWithOneIconElementView r157 = this.f170081g;
        if (r157 != null) goto L177;
        Intrinsics.throwUninitializedPropertyAccessException("tivShopName");
    L177:
        TextWithOneIconElementView r158 = this.f170081g;
        if (r158 != null) goto L180;
        Intrinsics.throwUninitializedPropertyAccessException("tivShopName");
    L180:
        ViewGroup.LayoutParams r159 = r158.getLayoutParams();
        if (r159 == null) goto L184;
        ConstraintLayout.LayoutParams r160 = (ConstraintLayout.LayoutParams) r159;
        ((ViewGroup.MarginLayoutParams) r160).topMargin = com.bytedance.android.shopping.extensions.b.b(11);
        Unit r161 = Unit.INSTANCE;
        r157.setLayoutParams(r160);
        return;
    L184:
        throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
    L144:
        r150 = false;
    L163:
        r117 = 8;
        goto L164
    L136:
        r148 = false;
        goto L137
    L115:
        r142 = false;
    L126:
        r145 = 8;
        goto L127
    L107:
        r140 = false;
        goto L108
    L94:
        r136 = false;
    L97:
        r137 = 8;
        goto L98
    L85:
        r134 = false;
        goto L87
    L185:
        return;
    L10:
        r104 = null;
        goto L11
    }

    public final void d(int r100) {
        ShoppingAsyncInflater.a r101 = ShoppingAsyncInflater.f45268e;
        Context r102 = getContext();
        r101.getClass();
        ShoppingAsyncInflater.a.a(r102).aU(r100, this, true);
        this.f170075a = (LinearLayout) findViewById(R.id.anchor_v4_ll_shop_info);
        this.f170076b = (ConstraintLayout) findViewById(R.id.anchor_v4_shop_cl_shop_info);
        this.f170077c = (LinearLayout) findViewById(R.id.anchor_v4_ll_shop_extra);
        this.f170078d = (MediaBoxElementView) findViewById(R.id.anchor_v4_ibv_shop_avatar);
        this.f170079e = (TextWithOneIconElementView) findViewById(R.id.anchor_v4_shop_live_or_douyin_view);
        this.f170080f = findViewById(R.id.anchor_v4_shop_live_or_douyin_view_bg);
        this.f170081g = (TextWithOneIconElementView) findViewById(R.id.anchor_v4_tiv_shop_name);
        this.f170082h = (TextWithOneIconElementView) findViewById(R.id.anchor_v4_shop_icon);
        this.f170083i = (TextWithOneIconElementView) findViewById(R.id.anchor_v4_tiv_jump_to_shop);
        this.f170084j = (IconsWithSpaceElementView) findViewById(R.id.anchor_v4_iws_trust_pics);
        this.f170085k = (LinearLayout) findViewById(R.id.anchor_v4_ll_score);
        this.f170087l = findViewById(R.id.anchor_v4_follow_sales_layout);
        this.f170088m = (TextElementView) findViewById(R.id.anchor_v4_detail_main_info_follow);
        this.f170089n = (TextElementView) findViewById(R.id.anchor_v4_detail_main_info_sell);
        this.f170090o = findViewById(R.id.anchor_v4_detail_main_info_divider);
        this.f170091p = (LynxCardView) findViewById(R.id.store_reputation_lynx_card);
        this.f170093q = (TextElementView) findViewById(R.id.anchor_v4_tv_shop_score);
        this.f170094r = (LinearLayout) findViewById(R.id.anchor_v4_ll_stars);
        this.f170095s = findViewById(R.id.anchor_v4_shop_divider);
        this.f170096t = (TextElementView) findViewById(R.id.anchor_v4_tv_shop_peers_exceeded);
        this.f170097u = (LongContentLabelComponentView) findViewById(R.id.anchor_v4_shop_promotion_info);
        this.f170098v = (LongContentLabelComponentView) findViewById(R.id.anchor_v4_shop_profile);
        this.f170099w = (LongContentLabelComponentView) findViewById(R.id.anchor_v4_shop_recommend_title);
        this.f170100x = (AnchorV3RecInShopBoxView) findViewById(R.id.anchor_v4_bv_rec_in_shop);
        this.f170101y = (TextWithOneIconElementView) findViewById(R.id.anchor_v4_tiv_supermarket_slogan);
        this.f170102z = (TextElementView) findViewById(R.id.anchor_v4_supermarket_sales);
        this.B = (TagsScrollBoxComponentView) findViewById(R.id.anchor_v4_icons_and_fans);
        this.K = (LinearLayout) findViewById(R.id.anchor_v4_ll_shop_follower_count);
        this.L = (LinearLayout) findViewById(R.id.anchor_v4_ll_shop_sell_num);
        this.M = (LinearLayout) findViewById(R.id.anchor_v4_ll_shop_sub_score);
        this.N = (LinearLayout) findViewById(R.id.anchor_v4_ll_shop_reputation);
        this.O = findViewById(R.id.anchor_v4_shop_rep_divider1);
        this.P = findViewById(R.id.anchor_v4_shop_rep_divider2);
        this.Q = (RoundedFrameLayout) findViewById(R.id.anchor_v4_avatar_mask);
        this.A = (LongContentLabelComponentView) findViewById(R.id.anchor_v4_shop_rank_list);
        this.C = (LongContentLabelComponentView) findViewById(R.id.anchor_v4_supermarket_icon_list);
        this.D = (TextElementView) findViewById(R.id.anchor_v4_supermarket_distance);
        this.E = (TextWithOneIconElementView) findViewById(R.id.anchor_v4_shop_ambient_title);
        this.F = (TextWithOneIconElementView) findViewById(R.id.anchor_v4_shop_ambient_slogan);
        this.G = (SimpleDraweeView) findViewById(R.id.anchor_v4_shop_ambient_shading);
        this.H = (ConstraintLayout) findViewById(R.id.anchor_v4_shop_container);
        this.R = (TextWithOneIconElementView) findViewById(R.id.anchor_v4_detail_main_info_score);
        this.T = (ECDraweeView) findViewById(R.id.anchor_v4_ibv_shop_avatar_live);
        this.U = findViewById(R.id.anchor_v4_ibv_shop_avatar_border);
        this.V = (TextWithOneIconElementView) findViewById(R.id.anchor_v4_ibv_shop_avatar_tag);
        this.W = (TagsScrollBoxComponentView) findViewById(R.id.anchor_v4_shop_score_icons);
        this.f170086k0 = (TextWithOneIconElementView) findViewById(R.id.anchor_v4_shop_score_text);
        this.f170092p0 = findViewById(R.id.anchor_v4_shop_rank_list_divider);
        this.H0 = findViewById(R.id.anchor_v4_shop_promotion_info_divider);
        this.L0 = findViewById(R.id.anchor_v4_ll_shop_extra_divider);
    }

    @Override // android.view.View
    public final void draw(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        this.I.e(r100);
        super.draw(r100);
        this.I.d(r100);
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.base.design.ActionHubAccessor
    public final String getOnLimitClickBindKey(Action r100) {
        Intrinsics.checkNotNullParameter(r100, "action");
        return ActionHubAccessor.DefaultImpls.c(r100);
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.base.design.ActionHubAccessor
    public void setActionHub(com.bytedance.android.shopping.anchorv4.voavhs.base.design.a r100) {
        Intrinsics.checkNotNullParameter(r100, "hub");
        this.V0 = r100;
    }

    public AnchorV4ShopAndStoreView(Context r100, AttributeSet r110, int r111, int r112) {
        if ((r112 & 2) == 0) goto L6;
        r110 = null;
    L6:
        if ((r112 & 4) == 0) goto L8;
        r111 = 0;
    L8:
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r110, r111);
        this.V0 = null;
        com.bytedance.android.shopping.anchorv4.voavhs.base.extensions.b r101 = new com.bytedance.android.shopping.anchorv4.voavhs.base.extensions.b(this);
        this.I = r101;
        d(R.layout.ec_commerce_anchor_v4_view_section_shop);
        Action r113 = new Action(RootDescription.ROOT_ELEMENT, null, null, null, new JSONObject().put("check_login", true).toString(), 14, null);
        Intrinsics.checkNotNullParameter(this, "theView");
        ActionHubAccessor.DefaultImpls.a(this, this, r113);
        r101.f(new Radius(8, 8, 8, 8));
    }

    @Override // android.view.View
    public final void onSizeChanged(int r100, int r101, int r102, int r103) {
        super.onSizeChanged(r100, r101, r102, r103);
        this.I.c(r100, r101);
    }
}
