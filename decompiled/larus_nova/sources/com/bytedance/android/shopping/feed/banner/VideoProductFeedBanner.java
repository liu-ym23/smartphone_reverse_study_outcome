package com.bytedance.android.shopping.feed.banner;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.OrientationHelper;
import androidx.recyclerview.widget.RecyclerView;
import com.amap.api.col.s.ce;
import com.bytedance.android.ec.core.opt.asyncInflate.ShoppingAsyncCacheInflater;
import com.bytedance.android.ec.core.opt.asyncInflate.ShoppingAsyncInflater;
import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.ec.model.response.anchorv3.SpecDetail;
import com.bytedance.android.shopping.feed.utils.f0;
import com.bytedance.android.shopping.feed.viewmodel.ProductFeedViewModel;
import com.bytedance.android.shopping.feed.widget.InflowSkuWidget;
import com.bytedance.android.shopping.inflow.view.InFlowNumberBannerIndicatorView;
import com.bytedance.android.shopping.inflow.view.MainCardImageBannerAdapter;
import com.bytedance.android.shopping.product.flow.banner.BannerAdapter;
import com.bytedance.android.shopping.product.flow.banner.BannerHolder;
import com.bytedance.android.shopping.product.flow.banner.OverScrollPagerSnapHelper;
import com.bytedance.android.shopping.product.flow.indicator.DefaultBannerIndicatorView;
import com.bytedance.android.shopping.product.flow.indicator.MediaBannerIndicatorView;
import com.bytedance.android.shopping.widget.banner.BannerRecyclerView;
import com.bytedance.android.ui.ec.widget.ecdraweeview.ECDraweeView;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.officesdk.api.init.OfficeSDKRequestTag;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ttnet.org.chromium.base.BaseSwitches;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import yg3.e;
import yg3.f;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000¨\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\u0019B.\b\u0007\u0012\b\u0010\u008c\u0001\u001a\u00030\u008b\u0001\u0012\f\b\u0002\u0010\u008e\u0001\u001a\u0005\u0018\u00010\u008d\u0001\u0012\t\b\u0002\u0010\u008f\u0001\u001a\u00020\u0002¢\u0006\u0006\b\u0090\u0001\u0010\u0091\u0001J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0007\u001a\u00020\u0006J\u0006\u0010\b\u001a\u00020\u0006J\b\u0010\n\u001a\u0004\u0018\u00010\tR\u0017\u0010\u0010\u001a\u00020\u000b8\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001d\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00120\u00118\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u0017\u0010\u001d\u001a\u00020\u00188\u0006¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u0017\u0010#\u001a\u00020\u001e8\u0006¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"R\u0017\u0010)\u001a\u00020$8\u0006¢\u0006\f\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(R\u0017\u0010/\u001a\u00020*8\u0006¢\u0006\f\n\u0004\b+\u0010,\u001a\u0004\b-\u0010.R\u0017\u00105\u001a\u0002008\u0006¢\u0006\f\n\u0004\b1\u00102\u001a\u0004\b3\u00104R*\u0010>\u001a\n\u0012\u0004\u0012\u000207\u0018\u0001068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b8\u00109\u001a\u0004\b:\u0010;\"\u0004\b<\u0010=R$\u0010F\u001a\u0004\u0018\u00010?8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b@\u0010A\u001a\u0004\bB\u0010C\"\u0004\bD\u0010ER\u0017\u0010L\u001a\u00020G8\u0006¢\u0006\f\n\u0004\bH\u0010I\u001a\u0004\bJ\u0010KR\"\u0010T\u001a\u00020M8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bN\u0010O\u001a\u0004\bP\u0010Q\"\u0004\bR\u0010SR\"\u0010\\\u001a\u00020U8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bV\u0010W\u001a\u0004\bX\u0010Y\"\u0004\bZ\u0010[R\"\u0010`\u001a\u00020U8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b]\u0010W\u001a\u0004\b^\u0010Y\"\u0004\b_\u0010[R\"\u0010b\u001a\u00020U8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\ba\u0010W\u001a\u0004\bb\u0010Y\"\u0004\bc\u0010[R.\u0010l\u001a\u0004\u0018\u00010d2\b\u0010e\u001a\u0004\u0018\u00010d8\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\bf\u0010g\u001a\u0004\bh\u0010i\"\u0004\bj\u0010kR\"\u0010s\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bm\u0010n\u001a\u0004\bo\u0010p\"\u0004\bq\u0010rR\"\u0010w\u001a\u00020U8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bt\u0010W\u001a\u0004\bu\u0010Y\"\u0004\bv\u0010[R\"\u0010{\u001a\u00020U8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bx\u0010W\u001a\u0004\by\u0010Y\"\u0004\bz\u0010[R\u0017\u0010~\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b|\u0010n\u001a\u0004\b}\u0010pR5\u0010\u0086\u0001\u001a\u0004\u0018\u00010\u007f2\b\u0010e\u001a\u0004\u0018\u00010\u007f8\u0006@FX\u0086\u000e¢\u0006\u0018\n\u0006\b\u0080\u0001\u0010\u0081\u0001\u001a\u0006\b\u0082\u0001\u0010\u0083\u0001\"\u0006\b\u0084\u0001\u0010\u0085\u0001R&\u0010\u008a\u0001\u001a\u00020U8\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\b\u0087\u0001\u0010W\u001a\u0005\b\u0088\u0001\u0010Y\"\u0005\b\u0089\u0001\u0010[¨\u0006\u0092\u0001"}, d2 = {"Lcom/bytedance/android/shopping/feed/banner/VideoProductFeedBanner;", "Landroid/widget/FrameLayout;", "", "angle", "", "setInterceptAngle", "", "getCurImageUrl", "getFirstImgUrl", "Landroid/view/View;", "getCenterView", "Lcom/bytedance/android/shopping/widget/banner/BannerRecyclerView;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "Lcom/bytedance/android/shopping/widget/banner/BannerRecyclerView;", "getViewPager", "()Lcom/bytedance/android/shopping/widget/banner/BannerRecyclerView;", "viewPager", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/bytedance/android/shopping/product/flow/banner/BannerHolder;", "b", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "getAdapter", "()Landroidx/recyclerview/widget/RecyclerView$Adapter;", "adapter", "Lcom/bytedance/android/shopping/product/flow/banner/OverScrollPagerSnapHelper;", "c", "Lcom/bytedance/android/shopping/product/flow/banner/OverScrollPagerSnapHelper;", "getSnapHelper", "()Lcom/bytedance/android/shopping/product/flow/banner/OverScrollPagerSnapHelper;", "snapHelper", "Lcom/bytedance/android/shopping/product/flow/indicator/MediaBannerIndicatorView;", "d", "Lcom/bytedance/android/shopping/product/flow/indicator/MediaBannerIndicatorView;", "getMediaIndicator", "()Lcom/bytedance/android/shopping/product/flow/indicator/MediaBannerIndicatorView;", "mediaIndicator", "Lcom/bytedance/android/shopping/product/flow/indicator/DefaultBannerIndicatorView;", "e", "Lcom/bytedance/android/shopping/product/flow/indicator/DefaultBannerIndicatorView;", "getImageIndicator", "()Lcom/bytedance/android/shopping/product/flow/indicator/DefaultBannerIndicatorView;", "imageIndicator", "Lcom/bytedance/android/shopping/inflow/view/InFlowNumberBannerIndicatorView;", "f", "Lcom/bytedance/android/shopping/inflow/view/InFlowNumberBannerIndicatorView;", "getNumberIndicator", "()Lcom/bytedance/android/shopping/inflow/view/InFlowNumberBannerIndicatorView;", "numberIndicator", "Lcom/bytedance/android/shopping/feed/banner/ImageSlideListProgressBar;", ce.f26391f, "Lcom/bytedance/android/shopping/feed/banner/ImageSlideListProgressBar;", "getProgressBar", "()Lcom/bytedance/android/shopping/feed/banner/ImageSlideListProgressBar;", "progressBar", "", "Lcom/bytedance/android/ec/model/ECUrlModel;", "h", "Ljava/util/List;", "getImages", "()Ljava/util/List;", "setImages", "(Ljava/util/List;)V", "images", "Lcom/bytedance/android/shopping/feed/widget/InflowSkuWidget;", ce.f26395j, "Lcom/bytedance/android/shopping/feed/widget/InflowSkuWidget;", "getSkuWidget", "()Lcom/bytedance/android/shopping/feed/widget/InflowSkuWidget;", "setSkuWidget", "(Lcom/bytedance/android/shopping/feed/widget/InflowSkuWidget;)V", "skuWidget", "Landroidx/recyclerview/widget/OrientationHelper;", ce.f26396k, "Landroidx/recyclerview/widget/OrientationHelper;", "getOrientationHelper", "()Landroidx/recyclerview/widget/OrientationHelper;", "orientationHelper", "Lcom/bytedance/android/shopping/feed/banner/d;", "l", "Lcom/bytedance/android/shopping/feed/banner/d;", "getConfig", "()Lcom/bytedance/android/shopping/feed/banner/d;", "setConfig", "(Lcom/bytedance/android/shopping/feed/banner/d;)V", "config", "", "m", "Z", "getStopByDrag", "()Z", "setStopByDrag", "(Z)V", "stopByDrag", OfficeSDKRequestTag.KEY_NEW_USER, "getCancelProgressTask", "setCancelProgressTask", "cancelProgressTask", "o", "isAutoSlide", "setAutoSlide", "Lyg3/e;", "value", "s", "Lyg3/e;", "getOnOverScrollListener", "()Lyg3/e;", "setOnOverScrollListener", "(Lyg3/e;)V", "onOverScrollListener", "t", "I", "getCurPagePos", "()I", "setCurPagePos", "(I)V", "curPagePos", "u", "getShouldJump", "setShouldJump", "shouldJump", BaseSwitches.V, "getCanPullLeft", "setCanPullLeft", "canPullLeft", "w", "getThreshold", "threshold", "Lyg3/d;", "x", "Lyg3/d;", "getOnItemClickListener", "()Lyg3/d;", "setOnItemClickListener", "(Lyg3/d;)V", "onItemClickListener", "y", "getIndicatorNewStyleAB", "setIndicatorNewStyleAB", "indicatorNewStyleAB", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ec-biz-inner-flow-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class VideoProductFeedBanner extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final BannerRecyclerView f174390a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final RecyclerView.Adapter<BannerHolder> f174391b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final OverScrollPagerSnapHelper f174392c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final MediaBannerIndicatorView f174393d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final DefaultBannerIndicatorView f174394e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final InFlowNumberBannerIndicatorView f174395f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final ImageSlideListProgressBar f174396g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public List<? extends ECUrlModel> f174397h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f174398i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public InflowSkuWidget f174399j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final OrientationHelper f174400k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public com.bytedance.android.shopping.feed.banner.d f174401l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f174402m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f174403n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f174404o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final LinkedList<f> f174405p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public rd3.a f174406q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final boolean f174407r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public e f174408s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public int f174409t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public boolean f174410u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public boolean f174411v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final int f174412w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public yg3.d f174413x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public boolean f174414y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final com.bytedance.android.shopping.feed.banner.c f174415z;

    public static final class a implements com.bytedance.android.shopping.feed.banner.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ VideoProductFeedBanner f174418a;

        @Override // com.bytedance.android.shopping.feed.banner.b
        public final void b() {
            VideoProductFeedBanner r100 = this.f174418a;
            if (r100.f174404o == false) goto L5;
            r100.f174404o = false;
        L5:
            r100.f174401l.getClass();
        }

        public a(VideoProductFeedBanner r100) {
            this.f174418a = r100;
        }
    }

    public static final class b implements f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ VideoProductFeedBanner f174419a;

        @Override // yg3.f
        public final void a(ECDraweeView r100) {
        }

        public b(VideoProductFeedBanner r100) {
            this.f174419a = r100;
        }

        @Override // yg3.f
        public final void onPageSelected(int r100, boolean r101) {
            if (r100 <= 0) goto L9;
            rd3.a r102 = this.f174419a.f174406q;
            if (r102 == null) goto L9;
            ProductFeedViewModel r103 = r102.f537236c;
            if (r103 == null) goto L9;
            r103.setSlideHeadImage(true);
        L9:
            this.f174419a.setCurPagePos(r100);
            rd3.a r104 = this.f174419a.f174406q;
            if (r104 != null) goto L12;
        L13:
            if (r104 == null) goto L17;
            ProductFeedViewModel r105 = r104.f537236c;
            if (r105 == null) goto L17;
            r105.setHeadImagePos(r100);
        L17:
            this.f174419a.getConfig().getClass();
            int r106 = 0;
            if (this.f174419a.getIndicatorNewStyleAB() == false) goto L36;
            List<ECUrlModel> r107 = this.f174419a.getImages();
            if (r107 == null) goto L22;
            r106 = r107.size() - this.f174419a.f174398i;
        L22:
            if (r100 < r106) goto L33;
            int r108 = r100 - r106;
            this.f174419a.getNumberIndicator().a(r108, this.f174419a.f174398i);
            InflowSkuWidget r109 = this.f174419a.getSkuWidget();
            if (r109 == null) goto L41;
            if (r108 < 0) goto L42;
            List<SpecDetail> r110 = r109.f175927f.f174340a;
            if (r110 == null) goto L31;
            SpecDetail r111 = (SpecDetail) CollectionsKt.getOrNull(r110, r108);
            if (r111 == null) goto L31;
            Long r112 = Long.valueOf(r111.getSpecDetailId());
        L32:
            r109.a(String.valueOf(r112));
            return;
        L31:
            r112 = null;
            goto L32
        L42:
            return;
        L41:
            return;
        L33:
            this.f174419a.getNumberIndicator().a(r100, r106);
            InflowSkuWidget r113 = this.f174419a.getSkuWidget();
            if (r113 == null) goto L44;
            r113.a("");
            return;
        L44:
            return;
        L36:
            DefaultBannerIndicatorView r114 = this.f174419a.getImageIndicator();
            List<ECUrlModel> r115 = this.f174419a.getImages();
            if (r115 == null) goto L39;
            r106 = r115.size();
        L39:
            r114.c(r100, r106);
            return;
        L12:
            if (r104.f537238e == true) goto L17;
            goto L13
        }
    }

    public static final class c {
    }

    public static final class d implements com.bytedance.android.shopping.feed.banner.c.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ VideoProductFeedBanner f174420a;

        @Override // com.bytedance.android.shopping.feed.banner.c.a
        public final void a() {
            this.f174420a.getConfig().getClass();
        }

        public d(VideoProductFeedBanner r100) {
            this.f174420a = r100;
        }

        @Override // com.bytedance.android.shopping.feed.banner.c.a
        public final void b(float r100, float r101) {
            VideoProductFeedBanner r102 = this.f174420a;
            r102.getCurPagePos();
            r102.f174401l.getClass();
            if (r100 != 100.0f) goto L21;
            VideoProductFeedBanner r103 = this.f174420a;
            if (r103.f174404o == true) goto L7;
            r103.f174404o = true;
        L7:
            List<? extends ECUrlModel> r104 = r103.f174397h;
            if (r104 == null) goto L10;
            int r105 = r104.size();
        L11:
            int r106 = r103.f174409t + 1;
            if (r106 > (r105 - 1)) goto L14;
            r103.f174390a.smoothScrollToPosition(r106);
        L15:
            List<ECUrlModel> r107 = this.f174420a.getImages();
            if (r107 != null) goto L18;
            return;
        L18:
            if (this.f174420a.getCurPagePos() == (r107.size() - 1)) goto L23;
            VideoProductFeedBanner r108 = this.f174420a;
            r108.setCurPagePos(r108.getCurPagePos() + 1);
            return;
        L23:
            return;
        L14:
            com.bytedance.android.shopping.feed.banner.c r109 = r103.f174415z;
            r109.f174427e = false;
            r109.f174428f = false;
            r109.f174429g = 0.0f;
            r109.a();
            r103.f174403n = true;
            goto L15
        L10:
            r105 = 0;
            goto L11
        }
    }

    static {
    }

    public VideoProductFeedBanner(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public VideoProductFeedBanner(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    public final View getCenterView() {
        return f0.a(this.f174390a, this.f174400k, null);
    }

    public final String getCurImageUrl() {
        String r100 = null;
        if (this.f174407r == false) goto L10;
        RecyclerView.Adapter<BannerHolder> r101 = this.f174391b;
        if ((r101 instanceof MainCardImageBannerAdapter) == true) goto L7;
        r101 = null;
    L7:
        MainCardImageBannerAdapter r102 = (MainCardImageBannerAdapter) r101;
        if (r102 == null) goto L16;
        List<? extends ECUrlModel> r103 = r102.f176343a;
    L17:
        if (r103 == null) goto L22;
        ECUrlModel r104 = (ECUrlModel) CollectionsKt.getOrNull(r103, this.f174409t);
        if (r104 == null) goto L22;
        r100 = r104.getFirstUrl();
    L22:
        return String.valueOf(r100);
    L16:
        r103 = null;
        goto L17
    L10:
        RecyclerView.Adapter<BannerHolder> r105 = this.f174391b;
        if ((r105 instanceof BannerAdapter) == true) goto L13;
        r105 = null;
    L13:
        BannerAdapter r106 = (BannerAdapter) r105;
        if (r106 == null) goto L16;
        r103 = r106.f182319a;
        goto L17
    }

    public final String getFirstImgUrl() {
        String r100 = null;
        if (this.f174407r == false) goto L10;
        RecyclerView.Adapter<BannerHolder> r101 = this.f174391b;
        if ((r101 instanceof MainCardImageBannerAdapter) == true) goto L7;
        r101 = null;
    L7:
        MainCardImageBannerAdapter r102 = (MainCardImageBannerAdapter) r101;
        if (r102 == null) goto L16;
        List<? extends ECUrlModel> r103 = r102.f176343a;
    L17:
        if (r103 == null) goto L22;
        ECUrlModel r104 = (ECUrlModel) CollectionsKt.getOrNull(r103, 0);
        if (r104 == null) goto L22;
        r100 = r104.getFirstUrl();
    L22:
        return String.valueOf(r100);
    L16:
        r103 = null;
        goto L17
    L10:
        RecyclerView.Adapter<BannerHolder> r105 = this.f174391b;
        if ((r105 instanceof BannerAdapter) == true) goto L13;
        r105 = null;
    L13:
        BannerAdapter r106 = (BannerAdapter) r105;
        if (r106 == null) goto L16;
        r103 = r106.f182319a;
        goto L17
    }

    public final RecyclerView.Adapter<BannerHolder> getAdapter() {
        return this.f174391b;
    }

    public final boolean getCanPullLeft() {
        return this.f174411v;
    }

    public final boolean getCancelProgressTask() {
        return this.f174403n;
    }

    public final com.bytedance.android.shopping.feed.banner.d getConfig() {
        return this.f174401l;
    }

    public final int getCurPagePos() {
        return this.f174409t;
    }

    public final DefaultBannerIndicatorView getImageIndicator() {
        return this.f174394e;
    }

    public final List<ECUrlModel> getImages() {
        return this.f174397h;
    }

    public final boolean getIndicatorNewStyleAB() {
        return this.f174414y;
    }

    public final MediaBannerIndicatorView getMediaIndicator() {
        return this.f174393d;
    }

    public final InFlowNumberBannerIndicatorView getNumberIndicator() {
        return this.f174395f;
    }

    public final yg3.d getOnItemClickListener() {
        return this.f174413x;
    }

    public final e getOnOverScrollListener() {
        return this.f174408s;
    }

    public final OrientationHelper getOrientationHelper() {
        return this.f174400k;
    }

    public final ImageSlideListProgressBar getProgressBar() {
        return this.f174396g;
    }

    public final boolean getShouldJump() {
        return this.f174410u;
    }

    public final InflowSkuWidget getSkuWidget() {
        return this.f174399j;
    }

    public final OverScrollPagerSnapHelper getSnapHelper() {
        return this.f174392c;
    }

    public final boolean getStopByDrag() {
        return this.f174402m;
    }

    public final int getThreshold() {
        return this.f174412w;
    }

    public final BannerRecyclerView getViewPager() {
        return this.f174390a;
    }

    public final void setAutoSlide(boolean r100) {
        this.f174404o = r100;
    }

    public final void setCanPullLeft(boolean r100) {
        this.f174411v = r100;
    }

    public final void setCancelProgressTask(boolean r100) {
        this.f174403n = r100;
    }

    public final void setConfig(com.bytedance.android.shopping.feed.banner.d r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f174401l = r100;
    }

    public final void setCurPagePos(int r100) {
        this.f174409t = r100;
    }

    public final void setImages(List<? extends ECUrlModel> r100) {
        this.f174397h = r100;
    }

    public final void setIndicatorNewStyleAB(boolean r100) {
        this.f174414y = r100;
    }

    public final void setInterceptAngle(int r100) {
        this.f174390a.setInterceptAngle(r100);
    }

    public final void setOnItemClickListener(yg3.d r100) {
        RecyclerView.Adapter<BannerHolder> r101 = null;
        if (this.f174407r == false) goto L11;
        RecyclerView.Adapter<BannerHolder> r102 = this.f174391b;
        if ((r102 instanceof MainCardImageBannerAdapter) == false) goto L8;
        r101 = r102;
    L8:
        MainCardImageBannerAdapter r103 = (MainCardImageBannerAdapter) r101;
        if (r103 == null) goto L18;
        r103.f176346d = r100;
    L18:
        this.f174413x = r100;
        return;
    L11:
        RecyclerView.Adapter<BannerHolder> r104 = this.f174391b;
        if ((r104 instanceof BannerAdapter) == false) goto L15;
        r101 = r104;
    L15:
        BannerAdapter r105 = (BannerAdapter) r101;
        if (r105 == null) goto L18;
        r105.f182321c = r100;
        goto L18
    }

    public final void setOnOverScrollListener(e r100) {
        this.f174392c.f182344a = r100;
        this.f174408s = r100;
    }

    public final void setShouldJump(boolean r100) {
        this.f174410u = r100;
    }

    public final void setSkuWidget(InflowSkuWidget r100) {
        this.f174399j = r100;
    }

    public final void setStopByDrag(boolean r100) {
        this.f174402m = r100;
    }

    public VideoProductFeedBanner(Context r110, AttributeSet r111, int r112) {
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r110, r111, r112);
        this.f174401l = new com.bytedance.android.shopping.feed.banner.d();
        LinkedList<f> r113 = new LinkedList();
        this.f174405p = r113;
        boolean r114 = ld3.d.e(ld3.d.b());
        this.f174407r = r114;
        this.f174411v = true;
        Resources r100 = Resources.getSystem();
        this.f174412w = MathKt.roundToInt(TypedValue.applyDimension(1, 26, WindowDisplayMetricsOverride.apply(r100, r100.getDisplayMetrics())));
        d r101 = new d(this);
        com.bytedance.android.shopping.feed.banner.c r102 = new com.bytedance.android.shopping.feed.banner.c();
        r102.f174426d = r101;
        Unit r103 = Unit.INSTANCE;
        this.f174415z = r102;
        if (ld3.b.a() == false) goto L5;
        Map<Activity, ShoppingAsyncCacheInflater> r104 = ShoppingAsyncCacheInflater.f45261d;
        ShoppingAsyncCacheInflater.a.a(r110).aU(R.layout.ec_commerce_inflow_feed_view_pager, this, true);
    L6:
        BannerRecyclerView r105 = (BannerRecyclerView) findViewById(R.id.view_pager);
        this.f174390a = r105;
        this.f174393d = (MediaBannerIndicatorView) findViewById(R.id.media_indicator);
        DefaultBannerIndicatorView r106 = (DefaultBannerIndicatorView) findViewById(R.id.page_indicator);
        this.f174394e = r106;
        InFlowNumberBannerIndicatorView r107 = (InFlowNumberBannerIndicatorView) findViewById(R.id.num_indicator);
        this.f174395f = r107;
        if (ld3.d.e(ld3.d.b()) == false) goto L21;
        ViewGroup.LayoutParams r108 = r106.getLayoutParams();
        ViewGroup.LayoutParams r109 = null;
        if ((r108 instanceof ViewGroup.MarginLayoutParams) == true) goto L11;
        r108 = null;
    L11:
        ViewGroup.MarginLayoutParams r115 = (ViewGroup.MarginLayoutParams) r108;
        if (r115 == null) goto L14;
        Resources r116 = Resources.getSystem();
        r115.bottomMargin = MathKt.roundToInt(TypedValue.applyDimension(1, 28, WindowDisplayMetricsOverride.apply(r116, r116.getDisplayMetrics())));
        r106.setLayoutParams(r115);
    L14:
        ViewGroup.LayoutParams r117 = r107.getLayoutParams();
        if ((r117 instanceof ViewGroup.MarginLayoutParams) == false) goto L18;
        r109 = r117;
    L18:
        ViewGroup.MarginLayoutParams r118 = (ViewGroup.MarginLayoutParams) r109;
        if (r118 == null) goto L21;
        Resources r119 = Resources.getSystem();
        r118.bottomMargin = MathKt.roundToInt(TypedValue.applyDimension(1, 28, WindowDisplayMetricsOverride.apply(r119, r119.getDisplayMetrics())));
        r107.setLayoutParams(r118);
    L21:
        this.f174396g = (ImageSlideListProgressBar) findViewById(R.id.view_pager_wrapper_image_progress_bar_group);
        if (r114 == false) goto L24;
        RecyclerView.Adapter<BannerHolder> r120 = new MainCardImageBannerAdapter();
    L25:
        this.f174391b = r120;
        r105.setAdapter(r120);
        SlowScrollLinearLayoutManager r121 = new SlowScrollLinearLayoutManager(r110);
        r121.f174387a *= 2.5f;
        r105.setLayoutManager(r121);
        OverScrollPagerSnapHelper r122 = new OverScrollPagerSnapHelper();
        this.f174392c = r122;
        r122.attachToRecyclerView(r105);
        this.f174400k = OrientationHelper.createOrientationHelper(r105.getLayoutManager(), 0);
        r105.setNestedScrollingEnabled(false);
        r105.addOnScrollListener(new VideoProductFeedBanner$$special$$inlined$apply$lambda$1(this));
        r105.setScrollByDragListener(new a(this));
        b r123 = new b(this);
        Intrinsics.checkNotNullParameter(r123, "onPageChangeListener");
        r113.add(r123);
        return;
    L24:
        r120 = new BannerAdapter();
        goto L25
    L5:
        ShoppingAsyncInflater.f45268e.getClass();
        ShoppingAsyncInflater.a.a(r110).aU(R.layout.ec_commerce_inflow_feed_view_pager, this, true);
        goto L6
    }

    public /* synthetic */ VideoProductFeedBanner(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
