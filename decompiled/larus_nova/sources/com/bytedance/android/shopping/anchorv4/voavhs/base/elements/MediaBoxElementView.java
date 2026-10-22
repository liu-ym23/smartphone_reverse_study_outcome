package com.bytedance.android.shopping.anchorv4.voavhs.base.elements;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import com.bytedance.android.ec.core.utils.ECLiveImageUtils;
import com.bytedance.android.ec.core.utils.y;
import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.shopping.anchorv3.detail.widget.VideoHolder;
import com.bytedance.android.shopping.anchorv3.detail.widget.playerblock.PlayerBlock;
import com.bytedance.android.shopping.anchorv3.detail.widget.playerblock.h;
import com.bytedance.android.shopping.anchorv4.dto.base.Action;
import com.bytedance.android.shopping.anchorv4.dto.base.Border;
import com.bytedance.android.shopping.anchorv4.dto.base.ImageModel;
import com.bytedance.android.shopping.anchorv4.dto.base.LocalImage;
import com.bytedance.android.shopping.anchorv4.dto.base.VideoModel;
import com.bytedance.android.shopping.anchorv4.dto.elements.MediaBoxElement;
import com.bytedance.android.shopping.anchorv4.monitor.ImageMonitorMeta;
import com.bytedance.android.shopping.anchorv4.voavhs.base.design.ActionHubAccessor;
import com.bytedance.android.shopping.anchorv4.voavhs.base.extensions.ExtensionsKt;
import com.bytedance.android.shopping.anchorv4.voavhs.base.extensions.ImageExtensionsKt;
import com.bytedance.android.shopping.api.video.AVScene;
import com.bytedance.android.shopping.events.ImagePosition;
import com.bytedance.android.shopping.widget.legacy.SquareImageView;
import com.bytedance.common.utility.UIUtils;
import com.facebook.drawee.drawable.ScalingUtils;
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0016R\u001b\u0010\u000e\u001a\u00020\t8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR$\u0010\u0016\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001b\u0010\u001b\u001a\u00020\u00178BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0018\u0010\u000b\u001a\u0004\b\u0019\u0010\u001aR\u001b\u0010 \u001a\u00020\u001c8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001d\u0010\u000b\u001a\u0004\b\u001e\u0010\u001f¨\u0006!"}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/voavhs/base/elements/MediaBoxElementView;", "Landroid/widget/FrameLayout;", "Lfj/e;", "Lcom/bytedance/android/shopping/anchorv4/voavhs/base/design/ActionHubAccessor;", "Lcom/bytedance/android/shopping/anchorv4/voavhs/base/design/b;", "Lcom/bytedance/android/shopping/anchorv4/voavhs/base/design/a;", "hub", "", "setActionHub", "Lcom/bytedance/android/shopping/widget/legacy/SquareImageView;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "Lkotlin/Lazy;", "getImageView", "()Lcom/bytedance/android/shopping/widget/legacy/SquareImageView;", "imageView", "Lcom/bytedance/android/shopping/anchorv3/detail/widget/VideoHolder;", "b", "Lcom/bytedance/android/shopping/anchorv3/detail/widget/VideoHolder;", "getVideoHolder", "()Lcom/bytedance/android/shopping/anchorv3/detail/widget/VideoHolder;", "setVideoHolder", "(Lcom/bytedance/android/shopping/anchorv3/detail/widget/VideoHolder;)V", "videoHolder", "Landroid/view/View;", "d", "getMaskView", "()Landroid/view/View;", "maskView", "", "e", "getEnableOptimize", "()Z", "enableOptimize", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class MediaBoxElementView extends FrameLayout implements fj.e, ActionHubAccessor, com.bytedance.android.shopping.anchorv4.voavhs.base.design.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f167848a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public VideoHolder f167849b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final com.bytedance.android.shopping.anchorv4.voavhs.base.extensions.b f167850c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Lazy f167851d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Lazy f167852e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public MediaBoxElement f167853f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public com.bytedance.android.shopping.anchorv4.voavhs.base.design.a f167854g;

    public MediaBoxElementView(Context r100) {
        this(r100, null, 0, 14);
    }

    public MediaBoxElementView(Context r100, AttributeSet r101) {
        this(r100, r101, 0, 12);
    }

    public MediaBoxElementView(Context r100, AttributeSet r101, int r102) {
        this(r100, r101, r102, 8);
    }

    private final boolean getEnableOptimize() {
        return ((Boolean) this.f167852e.getValue()).booleanValue();
    }

    private final View getMaskView() {
        return (View) this.f167851d.getValue();
    }

    @Override // fj.e
    public final void B0() {
    }

    @Override // fj.e
    public final void H() {
    }

    @Override // fj.e
    public final void Q(float r100) {
    }

    @Override // fj.e
    public final void R2() {
    }

    @Override // fj.e
    public final void Z2() {
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.base.design.ActionHubAccessor
    public final Action associatedAction() {
        return null;
    }

    @Override // fj.e
    public final void e() {
    }

    public final SquareImageView getImageView() {
        return (SquareImageView) this.f167848a.getValue();
    }

    @Override // fj.e
    public final void m3(boolean r100) {
    }

    @Override // fj.e
    public final void y(boolean r100) {
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.base.design.b
    public final void a() {
        if (getEnableOptimize() == false) goto L32;
        MediaBoxElement r100 = this.f167853f;
        LocalImage r101 = null;
        if (r100 == null) goto L9;
        ImageModel r102 = r100.getImageModel();
        if (r102 == null) goto L9;
        ECUrlModel r103 = r102.getRemote();
    L10:
        if (r103 == null) goto L18;
        MediaBoxElement r104 = this.f167853f;
        if (r104 == null) goto L33;
        ImageModel r105 = r104.getImageModel();
        if (r105 == null) goto L34;
        ECUrlModel r106 = r105.getRemote();
        if (r106 == null) goto L35;
        ImageExtensionsKt.a(getImageView(), r106.getUri(), Integer.valueOf(r106.getHeight()), Integer.valueOf(r106.getWidth()));
        return;
    L35:
        return;
    L34:
        return;
    L33:
        return;
    L18:
        MediaBoxElement r107 = this.f167853f;
        if (r107 == null) goto L23;
        ImageModel r108 = r107.getImageModel();
        if (r108 == null) goto L23;
        r101 = r108.getLocal();
    L23:
        if (r101 == null) goto L37;
        MediaBoxElement r109 = this.f167853f;
        if (r109 == null) goto L38;
        ImageModel r110 = r109.getImageModel();
        if (r110 == null) goto L39;
        LocalImage r111 = r110.getLocal();
        if (r111 == null) goto L40;
        ImageExtensionsKt.a(getImageView(), r111.getName(), Integer.valueOf(r111.getHeight()), Integer.valueOf(r111.getWidth()));
        return;
    L40:
        return;
    L39:
        return;
    L38:
        return;
    L37:
        return;
    L9:
        r103 = null;
        goto L10
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.base.design.ActionHubAccessor
    public final com.bytedance.android.shopping.anchorv4.voavhs.base.design.a actionHub() {
        return this.f167854g;
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.base.design.ActionHubAccessor
    public final Object descriptionVO() {
        return this.f167853f;
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.base.design.ActionHubAccessor
    public final void dispatchPossibleShow() {
        ActionHubAccessor.DefaultImpls.b(this);
    }

    public final VideoHolder getVideoHolder() {
        return this.f167849b;
    }

    public static final /* synthetic */ boolean b(MediaBoxElementView r100) {
        return r100.getEnableOptimize();
    }

    public final void d(boolean r100) {
        Border r101 = null;
        if (r100 == false) goto L12;
        SquareImageView r102 = getImageView();
        MediaBoxElement r103 = this.f167853f;
        if (r103 == null) goto L7;
        ImageModel r104 = r103.getImageModel();
    L8:
        MediaBoxElement r105 = this.f167853f;
        if (r105 == null) goto L11;
        r101 = r105.getSelectInBorder();
    L11:
        ImageExtensionsKt.g(r102, r104, r101);
        getMaskView().setVisibility(0);
        return;
    L7:
        r104 = null;
        goto L8
    L12:
        getMaskView().setVisibility(4);
        SquareImageView r106 = getImageView();
        MediaBoxElement r107 = this.f167853f;
        if (r107 == null) goto L15;
        ImageModel r108 = r107.getImageModel();
    L16:
        MediaBoxElement r109 = this.f167853f;
        if (r109 == null) goto L19;
        r101 = r109.getDefaultInBorder();
    L19:
        ImageExtensionsKt.g(r106, r108, r101);
        return;
    L15:
        r108 = null;
        goto L16
    }

    @Override // android.view.View
    public final void draw(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        this.f167850c.e(r100);
        super.draw(r100);
        this.f167850c.d(r100);
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.base.design.ActionHubAccessor
    public final String getOnLimitClickBindKey(Action r100) {
        Intrinsics.checkNotNullParameter(r100, "action");
        return ActionHubAccessor.DefaultImpls.c(r100);
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.base.design.ActionHubAccessor
    public void setActionHub(com.bytedance.android.shopping.anchorv4.voavhs.base.design.a r100) {
        Intrinsics.checkNotNullParameter(r100, "hub");
        this.f167854g = r100;
    }

    public final void setVideoHolder(VideoHolder r100) {
        this.f167849b = r100;
    }

    public MediaBoxElementView(final Context r100, AttributeSet r101, int r102, int r103) {
        if ((r103 & 2) == 0) goto L6;
        r101 = null;
    L6:
        if ((r103 & 4) == 0) goto L8;
        r102 = 0;
    L8:
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f167854g = null;
        this.f167848a = LazyKt.lazy(new MediaBoxElementView$imageView$2(this, r100));
        this.f167850c = new com.bytedance.android.shopping.anchorv4.voavhs.base.extensions.b(this);
        this.f167851d = LazyKt.lazy(new MediaBoxElementView$maskView$2(this, r100));
        this.f167852e = LazyKt.lazy(MediaBoxElementView$enableOptimize$2.INSTANCE);
    }

    @Override // android.view.View
    public final void onSizeChanged(int r100, int r101, int r102, int r103) {
        super.onSizeChanged(r100, r101, r102, r103);
        this.f167850c.c(r100, r101);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v2, types: [T, com.bytedance.android.ec.model.ECUrlModel] */
    public static void c(final MediaBoxElementView r310, final MediaBoxElement r311, ViewGroup.LayoutParams r312, boolean r313, int r410) {
        LocalImage r100 = null;
        View r101 = null;
        if ((r410 & 2) == 0) goto L5;
        ViewGroup.LayoutParams r102 = null;
    L7:
        if ((r410 & 4) == 0) goto L9;
        boolean r110 = false;
    L10:
        r310.f167853f = r311;
        if (r311 != null) goto L13;
        r310.setVisibility(8);
        return;
    L13:
        r310.f167850c.f(r311.getRadius());
        if (r102 == null) goto L16;
        r310.setLayoutParams(r102);
    L16:
        ExtensionsKt.j(r310, r311.getBackground());
        int r103 = r311.getType();
        if (r103 == 0) goto L65;
        if (r103 == 1) goto L21;
        r310.setVisibility(8);
    L126:
        Action r104 = r311.getAction();
        Intrinsics.checkNotNullParameter(r310, "theView");
        ActionHubAccessor.DefaultImpls.a(r310, r310, r104);
        return;
    L21:
        if (r310.getChildCount() > 0) goto L126;
        VideoModel r105 = r311.getVideo();
        if (r105 == null) goto L126;
        String r111 = r105.getMainUrl();
        String r112 = r105.getBackupUrl();
        String r113 = r105.getVid();
        long r106 = r105.getHeight();
        long r107 = r105.getWidth();
        Integer r114 = r105.getDuration();
        if (r114 == null) goto L29;
        long r115 = r114.intValue();
    L30:
        long r210 = r115;
        ImageModel r108 = r105.getPosterImage();
        if (r108 == null) goto L37;
        ECUrlModel r109 = r108.getRemote();
        if (r109 == null) goto L37;
        List<String> r116 = r109.getUrlList();
        if (r116 == null) goto L37;
        String r211 = (String) CollectionsKt.firstOrNull(r116);
    L38:
        final fj.d r117 = new fj.d(r111, r112, r113, r107, r106, r210, r211, false, false, false, false, false, null, false, 0, null, null, 130944);
        final VideoHolder r118 = new VideoHolder(r310.getContext(), r110, false, 26);
        ECUrlModel r119 = new ECUrlModel();
        String r120 = r117.f477440g;
        if (r120 != null) goto L41;
        r120 = "";
    L41:
        r119.setUrlList(CollectionsKt.listOf(r120));
        Unit r121 = Unit.INSTANCE;
        final boolean r122 = r110;
        r118.f(r117, r119, new MediaBoxElementView$renderAsVideoMode$$inlined$apply$lambda$1(r118, r310, r117, r311, r122));
        if (r110 == false) goto L44;
        final boolean r123 = r110;
        Function1<Boolean, Unit> r124 = new MediaBoxElementView$renderAsVideoMode$$inlined$apply$lambda$2(r118, r310, r117, r311, r123);
        Intrinsics.checkNotNullParameter(r124, "listener");
        r118.f164882k = r124;
    L44:
        r310.f167849b = r118;
        ViewGroup.LayoutParams r125 = new ViewGroup.MarginLayoutParams(-1, -1);
        VideoHolder r126 = r310.f167849b;
        if (r126 == null) goto L47;
        r101 = r126.b();
    L47:
        r310.addView(r101, r125);
        VideoHolder r127 = r310.f167849b;
        if (r127 == null) goto L63;
        PlayerBlock r128 = r127.f164878g;
        if (r128 != null) goto L52;
    L60:
        r127.h(false);
        ProgressBar r129 = r127.f164877f;
        if (r129 == null) goto L63;
        r129.setVisibility(8);
        goto L63
    L52:
        if (r128.P == false) goto L54;
        int r130 = com.bytedance.android.shopping.extensions.b.b(32);
    L56:
        if (r128.P == false) goto L58;
        int r131 = R.drawable.ex_shopping_anchor_v4_play_icon_32;
    L59:
        r128.f164936a.setAlpha(1.0f);
        r128.f164936a.setBackgroundResource(r131);
        ImageView r132 = r128.f164936a;
        ViewGroup.LayoutParams r133 = r132.getLayoutParams();
        r133.width = r130;
        r133.height = r130;
        r132.setLayoutParams(r133);
        r128.f164936a.setVisibility(0);
        goto L60
    L58:
        r131 = R.drawable.commerce_ic_comment_play_block_play;
        goto L59
    L54:
        r130 = (int) UIUtils.dip2Px(r128.getContext(), 23.53f);
    L63:
        new h(r310, r117, AVScene.CONTENT_PRODUCT_DETAIL_MEDIA_BOX).A(r310);
        r310.setOnClickListener(c.f167873a);
    L37:
        r211 = null;
        goto L38
    L29:
        r115 = 0;
        goto L30
    L65:
        if (r310.getChildCount() > 0) goto L126;
        ImageModel r134 = r311.getImageModel();
        if (r134 == null) goto L70;
        ECUrlModel r135 = r134.getRemote();
    L71:
        if (r135 == null) goto L102;
        final Ref.ObjectRef r136 = new Ref.ObjectRef();
        r136.element = r311.getImageModel().getRemote();
        ImageModel r137 = r311.getImageModel();
        if (r102 != null) goto L80;
        ECUrlModel r138 = (ECUrlModel) r136.element;
        Intrinsics.checkNotNullParameter(r138, "urlModel");
        if (r138.getWidth() > 0) goto L77;
    L79:
        FrameLayout.LayoutParams r139 = new FrameLayout.LayoutParams(-1, -1);
        r139.gravity = 17;
        ViewGroup.LayoutParams r140 = r139;
    L81:
        if (r137 == null) goto L86;
        ImageMonitorMeta r141 = r137.getImageMonitorMeta();
        if (r141 == null) goto L86;
        com.bytedance.android.ec.core.imagex.ImageExtensionsKt.D(r310.getImageView(), q73.b.a(r141));
    L86:
        if (r310.getEnableOptimize() == false) goto L91;
        String r142 = ((ECUrlModel) r136.element).getUri();
        if (r142 != null) goto L90;
    L99:
        Float.valueOf(r137.getRoundCorner()).floatValue();
        ImageExtensionsKt.g(r310.getImageView(), r137, r311.getDefaultInBorder());
        r310.addView(r310.getImageView(), r140);
        Border r143 = r311.getOutBorder();
        if (r143 == null) goto L126;
        int r144 = Integer.valueOf(r143.getBorderWidth()).intValue();
        View r145 = r310.getMaskView();
        FrameLayout.LayoutParams r146 = new FrameLayout.LayoutParams(r140.width + (com.bytedance.android.shopping.extensions.b.b(Integer.valueOf(r144)) * 2), r140.height + (com.bytedance.android.shopping.extensions.b.b(Integer.valueOf(r144)) * 2));
        r146.gravity = 17;
        Unit r147 = Unit.INSTANCE;
        r310.addView(r145, r146);
        goto L126
    L90:
        if (r142.equals(r310.getImageView().getTag(R.id.detail_page_sku_image_view_uri)) == true) goto L99;
    L91:
        r310.getImageView().setHierarchy(new GenericDraweeHierarchyBuilder(r310.getResources()).setActualImageScaleType(ScalingUtils.ScaleType.CENTER_CROP).build());
        if (r102 == null) goto L94;
    L98:
        SquareImageView r148 = r310.getImageView();
        ECUrlModel r149 = (ECUrlModel) r136.element;
        y.c(r148, r149, -1, -1, new z53.a(r149.getUrlList(), ImagePosition.COMMENT_PAGE.getValue(), new MediaBoxElementView$renderAsImageMode$2(r310, r136), false, 24));
        goto L99
    L94:
        if (((ECUrlModel) r136.element).getWidth() <= 0) goto L98;
        if (((ECUrlModel) r136.element).getHeight() <= 0) goto L98;
        ECLiveImageUtils.c(r310.getImageView(), (ECUrlModel) r136.element, true, null);
        goto L99
    L77:
        if (r138.getHeight() <= 0) goto L79;
        FrameLayout.LayoutParams r150 = new FrameLayout.LayoutParams(vf4.a.b(Integer.valueOf(r138.getWidth())), vf4.a.b(Integer.valueOf(r138.getHeight())));
        r150.gravity = 17;
        r140 = r150;
        goto L81
    L80:
        r140 = r102;
        goto L81
    L102:
        ImageModel r151 = r311.getImageModel();
        if (r151 == null) goto L105;
        r100 = r151.getLocal();
    L105:
        if (r100 == null) goto L126;
        LocalImage r152 = r311.getImageModel().getLocal();
        Intrinsics.checkNotNullParameter(r152, "localModel");
        if (r152.getWidth() > 0) goto L109;
    L111:
        ViewGroup.LayoutParams r153 = new ViewGroup.MarginLayoutParams(-1, -1);
    L113:
        if (r310.getEnableOptimize() == false) goto L118;
        String r154 = r311.getImageModel().getLocal().getName();
        if (r154 != null) goto L117;
    L125:
        r310.addView(r310.getImageView(), r153);
        goto L126
    L117:
        if (r154.equals(r310.getImageView().getTag()) == true) goto L125;
    L118:
        SquareImageView r155 = r310.getImageView();
        LocalImage r156 = r311.getImageModel().getLocal();
        Intrinsics.checkNotNullParameter(r155, "$this$setLocalImage");
        if (r156 == null) goto L125;
        String r157 = r156.getName();
        if (r157 == null) goto L125;
        Integer r158 = ImageExtensionsKt.c(r157);
        if (r158 == null) goto L125;
        r155.setActualImageResource(r158.intValue());
        goto L125
    L109:
        if (r152.getHeight() <= 0) goto L111;
        r153 = new ViewGroup.MarginLayoutParams(vf4.a.b(Integer.valueOf(r152.getWidth())), vf4.a.b(Integer.valueOf(r152.getHeight())));
        goto L113
    L70:
        r135 = null;
        goto L71
    L9:
        r110 = r313;
        goto L10
    L5:
        r102 = r312;
        goto L7
    }
}
