package com.bytedance.android.shopping.deepfeed.weights;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.exifinterface.media.ExifInterface;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.OrientationHelper;
import androidx.recyclerview.widget.RecyclerView;
import com.amap.api.col.s.ce;
import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.android.ec.hybrid.hostapi.IHybridHostService;
import com.bytedance.android.ec.hybrid.monitor.HybridRecyclerViewPerformanceMonitor;
import com.bytedance.android.shopping.api.video.ECVideoPlayerView;
import com.bytedance.android.shopping.deepfeed.action.DeepFeedCommentClickArea;
import com.bytedance.android.shopping.deepfeed.ui.DeepFeedProductBannerAdapter;
import com.bytedance.android.shopping.deepfeed.ui.DeepFeedProductBannerIndicatorAnimator;
import com.bytedance.android.shopping.deepfeed.ui.DeepFeedProductOverScrollPagerSnapHelper;
import com.bytedance.android.shopping.deepfeed.ui.vh.DeepFeedProductBannerVideoVH;
import com.bytedance.android.shopping.deepfeed.weights.common.ProductTextView;
import com.bytedance.android.shopping.deepfeed.weights.video.VideoCoverLayout;
import com.bytedance.android.shopping.feed.utils.f0;
import com.bytedance.android.shopping.infeed.data.idl.HeaderBannerItemType;
import com.bytedance.android.shopping.infeed.data.idl.ImageURL;
import com.bytedance.android.shopping.infeed.data.idl.InFeedProductPackData;
import com.bytedance.android.shopping.infeed.data.idl.InFeedProductPackDataElements;
import com.bytedance.android.shopping.infeed.data.idl.InFeedProductV2;
import com.bytedance.android.shopping.infeed.data.idl.InFeedUrlModel;
import com.bytedance.android.shopping.inflow.cardui.product.header.indicator.ProductCardProgressIndicator;
import com.bytedance.android.shopping.inflow.cardui.product.header.layoutmanager.SmoothScrollLayoutManager;
import com.bytedance.android.shopping.widget.banner.PrimeHorizontalRecyclerView;
import com.bytedance.android.ui.ec.widget.photodraweeview.ExtensionsKt;
import com.bytedance.common.utility.Logger;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import com.ss.ttvideoengine.ITTVideoEngineEventSource;
import he3.e2;
import he3.k1;
import he3.m1;
import he3.n2;
import he3.o0;
import he3.p0;
import he3.x0;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0010\u000b\n\u0002\u0010\u000e\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002:\u0002\u0012\u0019B'\b\u0007\u0012\u0006\u0010T\u001a\u00020S\u0012\n\b\u0002\u0010V\u001a\u0004\u0018\u00010U\u0012\b\b\u0002\u0010W\u001a\u00020\u0003¢\u0006\u0004\bX\u0010YJ\u0006\u0010\u0004\u001a\u00020\u0003J\u0006\u0010\u0005\u001a\u00020\u0003J0\u0010\f\u001a\u00020\n2(\u0010\u000b\u001a$\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\t\u0012\u0004\u0012\u00020\n\u0018\u00010\u0006J\u000e\u0010\u000e\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\bJ\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fR\u0017\u0010\u0016\u001a\u00020\u00118\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R(\u0010\u001d\u001a\u0004\u0018\u00010\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u00178\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR(\u0010\"\u001a\u0004\u0018\u00010\u00012\b\u0010\u0018\u001a\u0004\u0018\u00010\u00018\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!R(\u0010(\u001a\u0004\u0018\u00010#2\b\u0010\u0018\u001a\u0004\u0018\u00010#8\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'R$\u00100\u001a\u0004\u0018\u00010)8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b*\u0010+\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R\u0017\u00106\u001a\u0002018\u0006¢\u0006\f\n\u0004\b2\u00103\u001a\u0004\b4\u00105R\"\u0010=\u001a\u00020\b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b7\u00108\u001a\u0004\b9\u0010:\"\u0004\b;\u0010<R(\u0010C\u001a\u0004\u0018\u00010>2\b\u0010\u0018\u001a\u0004\u0018\u00010>8\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b?\u0010@\u001a\u0004\bA\u0010BR\u0017\u0010I\u001a\u00020D8\u0006¢\u0006\f\n\u0004\bE\u0010F\u001a\u0004\bG\u0010HR\u0017\u0010L\u001a\u00020D8\u0006¢\u0006\f\n\u0004\bJ\u0010F\u001a\u0004\bK\u0010HR\u0017\u0010R\u001a\u00020M8\u0006¢\u0006\f\n\u0004\bN\u0010O\u001a\u0004\bP\u0010Q¨\u0006Z"}, d2 = {"Lcom/bytedance/android/shopping/deepfeed/weights/DeepFeedProductHeaderView;", "Landroid/widget/FrameLayout;", "Lcom/bytedance/android/shopping/deepfeed/ui/b;", "", "getCurrentSelected", "getItemCount", "Lkotlin/Function4;", "", "", "", "", "listener", "setVideoProgressReportListener", ITTVideoEngineEventSource.KEY_MUTE, "setMute", "Landroid/view/View;", "getMaskView", "Lcom/bytedance/android/shopping/widget/banner/PrimeHorizontalRecyclerView;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "Lcom/bytedance/android/shopping/widget/banner/PrimeHorizontalRecyclerView;", "getRecyclerView", "()Lcom/bytedance/android/shopping/widget/banner/PrimeHorizontalRecyclerView;", "recyclerView", "Lcom/bytedance/android/shopping/inflow/cardui/product/header/indicator/ProductCardProgressIndicator;", "<set-?>", "b", "Lcom/bytedance/android/shopping/inflow/cardui/product/header/indicator/ProductCardProgressIndicator;", "getProgressIndicator", "()Lcom/bytedance/android/shopping/inflow/cardui/product/header/indicator/ProductCardProgressIndicator;", "progressIndicator", "c", "Landroid/widget/FrameLayout;", "getProgressIndicatorContainer", "()Landroid/widget/FrameLayout;", "progressIndicatorContainer", "Lcom/bytedance/android/shopping/deepfeed/weights/video/VideoCoverLayout;", "d", "Lcom/bytedance/android/shopping/deepfeed/weights/video/VideoCoverLayout;", "getVideoProgressContainer", "()Lcom/bytedance/android/shopping/deepfeed/weights/video/VideoCoverLayout;", "videoProgressContainer", "Lcom/bytedance/android/shopping/deepfeed/ui/DeepFeedProductBannerAdapter;", "f", "Lcom/bytedance/android/shopping/deepfeed/ui/DeepFeedProductBannerAdapter;", "getBannerAdapter", "()Lcom/bytedance/android/shopping/deepfeed/ui/DeepFeedProductBannerAdapter;", "setBannerAdapter", "(Lcom/bytedance/android/shopping/deepfeed/ui/DeepFeedProductBannerAdapter;)V", "bannerAdapter", "Lcom/bytedance/android/shopping/deepfeed/ui/DeepFeedProductOverScrollPagerSnapHelper;", ce.f26391f, "Lcom/bytedance/android/shopping/deepfeed/ui/DeepFeedProductOverScrollPagerSnapHelper;", "getOverScrollSnapHelper", "()Lcom/bytedance/android/shopping/deepfeed/ui/DeepFeedProductOverScrollPagerSnapHelper;", "overScrollSnapHelper", RXScreenCaptureService.KEY_INDEX, "Z", "getIgnoreAnimCall", "()Z", "setIgnoreAnimCall", "(Z)V", "ignoreAnimCall", "Landroidx/constraintlayout/widget/ConstraintLayout;", "w", "Landroidx/constraintlayout/widget/ConstraintLayout;", "getSearchContainer", "()Landroidx/constraintlayout/widget/ConstraintLayout;", "searchContainer", "Landroid/widget/ImageView;", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "Landroid/widget/ImageView;", "getMuteIcon", "()Landroid/widget/ImageView;", "muteIcon", "B", "getUnmuteIcon", "unmuteIcon", "Landroid/widget/TextView;", "C", "Landroid/widget/TextView;", "getAdTagView", "()Landroid/widget/TextView;", "adTagView", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class DeepFeedProductHeaderView extends FrameLayout implements com.bytedance.android.shopping.deepfeed.ui.b {
    public static final Set<String> H0 = null;
    public final ImageView A;
    public final ImageView B;
    public final TextView C;
    public List<e2> D;
    public List<InFeedUrlModel> E;
    public List<o0> F;
    public List<x0> G;
    public final View H;
    public com.bytedance.android.shopping.deepfeed.action.i I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public List<b> f174048J;
    public com.bytedance.android.ec.core.imagex.r K;
    public final boolean L;
    public boolean M;
    public boolean N;
    public final h O;
    public Function1<? super Boolean, Unit> P;
    public final Function0<Unit> Q;
    public Function4<? super Long, ? super Long, ? super Boolean, ? super String, Unit> R;
    public long S;
    public long T;
    public boolean U;
    public String V;
    public final g W;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final PrimeHorizontalRecyclerView f174049a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ProductCardProgressIndicator f174050b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public FrameLayout f174051c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public VideoCoverLayout f174052d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final DeepFeedProductBannerIndicatorAnimator f174053e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public DeepFeedProductBannerAdapter f174054f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final DeepFeedProductOverScrollPagerSnapHelper f174055g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Runnable f174056h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f174057i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final OrientationHelper f174058j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f174059k;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    public final DeepFeedProductHeaderView$onScrollStateChangedListener$1 f174060k0;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public ke3.a f174061l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public View.OnClickListener f174062m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public Function1<? super DeepFeedCommentClickArea, Unit> f174063n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public Function0<Unit> f174064o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public Function2<? super Integer, ? super String, Unit> f174065p;

    /* JADX INFO: renamed from: p0, reason: collision with root package name */
    public final List<x0> f174066p0;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public Function2<? super Integer, ? super String, Unit> f174067q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public View.OnLongClickListener f174068r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final e f174069s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final Function1<DeepFeedCommentClickArea, Unit> f174070t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final Function0<Unit> f174071u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final f f174072v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public ConstraintLayout f174073w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public ProductTextView f174074x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public DeepFeedProductHeaderTabLayout f174075y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public boolean f174076z;

    public static final class a {
        public static void a(k1 r100, List r101) {
            if (r100 == null) goto L9;
            List<InFeedUrlModel> r102 = r100.b();
            if (r102 == null) goto L11;
            Iterator<T> r103 = r102.iterator();
        L7:
            if (r103.hasNext() == false) goto L12;
            InFeedUrlModel r104 = (InFeedUrlModel) r103.next();
            x0 r105 = new x0();
            r105.a(HeaderBannerItemType.Image);
            r105.f484856b = r104;
            Unit r106 = Unit.INSTANCE;
            ((ArrayList) r101).add(r105);
            goto L7
        L12:
            return;
        L11:
            return;
        }

        public static void b(k1 r100, List r101) {
            if (r100.c() == null) goto L39;
            x0 r102 = new x0();
            r102.a(HeaderBannerItemType.CoverVideo);
            qe3.a r103 = new qe3.a();
            List<e2> r104 = r100.c();
            InFeedUrlModel r105 = null;
            if (r104 == null) goto L9;
            e2 r106 = (e2) CollectionsKt.firstOrNull(r104);
            if (r106 == null) goto L9;
            String r107 = r106.e();
        L10:
            r103.g(r107);
            List<e2> r108 = r100.c();
            if (r108 == null) goto L19;
            e2 r109 = (e2) CollectionsKt.firstOrNull(r108);
            if (r109 == null) goto L19;
            n2 r110 = r109.a();
            if (r110 == null) goto L19;
            List<String> r111 = r110.b();
            if (r111 == null) goto L19;
            String r112 = (String) CollectionsKt.firstOrNull(r111);
        L20:
            r103.f(r112);
            List<e2> r113 = r100.c();
            if (r113 == null) goto L25;
            e2 r114 = (e2) CollectionsKt.firstOrNull(r113);
            if (r114 == null) goto L25;
            Integer r115 = r114.f();
        L26:
            r103.h(r115);
            List<e2> r116 = r100.c();
            if (r116 == null) goto L31;
            e2 r117 = (e2) CollectionsKt.firstOrNull(r116);
            if (r117 == null) goto L31;
            Integer r118 = r117.d();
        L32:
            r103.e(r118);
            Unit r119 = Unit.INSTANCE;
            r102.f484857c = r103;
            List<e2> r120 = r100.c();
            if (r120 == null) goto L37;
            e2 r121 = (e2) CollectionsKt.firstOrNull(r120);
            if (r121 == null) goto L37;
            r105 = r121.b();
        L37:
            r102.f484856b = r105;
            ((ArrayList) r101).add(r102);
            return;
        L31:
            r118 = null;
        L25:
            r115 = null;
        L19:
            r112 = null;
        L9:
            r107 = null;
            goto L10
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v2 */
        /* JADX WARN: Type inference failed for: r4v0 */
        /* JADX WARN: Type inference failed for: r4v1 */
        /* JADX WARN: Type inference failed for: r4v12, types: [java.util.List] */
        /* JADX WARN: Type inference failed for: r4v13, types: [java.util.ArrayList] */
        /* JADX WARN: Type inference failed for: r4v2 */
        /* JADX WARN: Type inference failed for: r4v9 */
        /* JADX WARN: Type inference failed for: r7v7 */
        /* JADX WARN: Type inference failed for: r8v0, types: [java.util.List] */
        /* JADX WARN: Type inference failed for: r8v1, types: [java.util.List] */
        /* JADX WARN: Type inference failed for: r8v3, types: [java.util.ArrayList] */
        public static List c(InFeedProductV2 r110, boolean r111) {
            Intrinsics.checkNotNullParameter(r110, "inFeedProductInfo");
            InFeedProductPackData r100 = r110.getPackData();
            List<e2> r101 = null;
            if (r100 == null) goto L61;
            InFeedProductPackDataElements r102 = r100.getElements();
            if (r102 == null) goto L61;
            List<p0> r103 = r102.getProducts();
            if (r103 == null) goto L61;
            p0 r104 = (p0) CollectionsKt.firstOrNull(r103);
            if (r104 == null) goto L61;
            m1 r105 = r104.i();
            if (r105 == null) goto L61;
            he3.m r106 = r105.a();
            if (r106 == null) goto L61;
            he3.s r107 = r106.c();
            if (r107 == null) goto L61;
            List<o0> r108 = r107.a();
            if (r108 == null) goto L61;
            ?? r109 = new ArrayList();
            Iterator r112 = r108.iterator();
        L20:
            if (r112.hasNext() == false) goto L62;
            Object r113 = r112.next();
            o0 r114 = (o0) r113;
            String r115 = r114.d();
            if (r115 != null) goto L24;
        L27:
            boolean r116 = true;
        L28:
            if (r116 == true) goto L58;
            List<ImageURL> r117 = r114.b();
            if (r117 != null) goto L32;
        L35:
            boolean r118 = true;
        L36:
            if (r118 == false) goto L57;
            List<e2> r119 = r114.e();
            if (r119 != null) goto L40;
        L43:
            boolean r120 = true;
        L44:
            if (r120 == false) goto L57;
            he3.h r121 = r114.a();
            if (r121 == null) goto L48;
            List<he3.g> r122 = r121.c();
        L49:
            List<he3.g> r123 = r122;
            if (r123 != null) goto L52;
        L55:
            boolean r124 = true;
        L56:
            if (r124 == true) goto L58;
        L52:
            if (r123.isEmpty() == true) goto L55;
            r124 = false;
            goto L56
        L48:
            r122 = null;
            goto L49
        L40:
            if (r119.isEmpty() == true) goto L43;
            r120 = false;
        L57:
            boolean r125 = true;
        L59:
            if (r125 == false) goto L20;
            r109.add(r113);
            goto L20
        L32:
            if (r117.isEmpty() == true) goto L35;
            r118 = false;
        L58:
            r125 = false;
            goto L59
        L24:
            if (r115.length() == 0) goto L27;
            r116 = false;
        L62:
            if (r109 != 0) goto L65;
            r109 = CollectionsKt.emptyList();
        L65:
            if ((!((Collection) r109).isEmpty()) == false) goto L129;
            ArrayList r126 = new ArrayList();
            Set<String> r127 = DeepFeedProductHeaderView.H0;
            Iterator r128 = ((Iterable) r109).iterator();
            int r129 = 0;
        L68:
            if (r128.hasNext() == false) goto L128;
            Object r130 = r128.next();
            int r131 = r129 + 1;
            if (r129 >= 0) goto L72;
            CollectionsKt.throwIndexOverflow();
        L72:
            o0 r132 = (o0) r130;
            String r133 = r132.d();
            if (r133 != null) goto L75;
            r133 = "";
        L75:
            List<ImageURL> r134 = r132.b();
            if (r134 != null) goto L78;
        L81:
            boolean r135 = true;
        L82:
            if (r135 == true) goto L87;
            List<ImageURL> r136 = r132.b();
            ?? r137 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r136, 10));
            Iterator r138 = r136.iterator();
        L85:
            if (r138.hasNext() == false) goto L88;
            ImageURL r139 = (ImageURL) r138.next();
            Set<String> r140 = DeepFeedProductHeaderView.H0;
            InFeedUrlModel r141 = new InFeedUrlModel();
            r141.setUrlList(r139.getUrlList());
            r137.add(r141);
        L88:
            List<e2> r142 = r132.e();
            if (r142 == null) goto L91;
            e2 r143 = (e2) CollectionsKt.firstOrNull(r142);
        L92:
            he3.h r144 = r132.a();
            if (r143 == null) goto L104;
            if (r126.isEmpty() == false) goto L104;
            Set<String> r145 = DeepFeedProductHeaderView.H0;
            x0 r146 = new x0();
            r146.a(HeaderBannerItemType.CoverVideo);
            qe3.a r147 = new qe3.a();
            r147.g(r143.e());
            n2 r148 = r143.a();
            if (r148 == null) goto L101;
            List<String> r149 = r148.b();
            if (r149 == null) goto L101;
            String r150 = (String) CollectionsKt.firstOrNull(r149);
        L102:
            r147.f(r150);
            r147.h(r143.f());
            r147.e(r143.d());
            Unit r151 = Unit.INSTANCE;
            r146.f484857c = r147;
            r146.f484856b = r143.b();
            r146.f484858d = r129;
            r146.f484859e = r133;
            r126.add(r146);
        L101:
            r150 = null;
        L104:
            if ((!((Collection) r137).isEmpty()) == false) goto L112;
            Set<String> r152 = DeepFeedProductHeaderView.H0;
            Iterator r153 = ((Iterable) r137).iterator();
            int r154 = 0;
        L107:
            if (r153.hasNext() == false) goto L127;
            Object r155 = r153.next();
            int r156 = r154 + 1;
            if (r154 >= 0) goto L111;
            CollectionsKt.throwIndexOverflow();
        L111:
            x0 r157 = new x0();
            r157.a(HeaderBannerItemType.Image);
            r157.f484856b = (InFeedUrlModel) r155;
            r157.f484858d = r129;
            r157.f484859e = r133;
            r157.f484860f = r154;
            r157.f484861g = r137.size();
            Unit r158 = Unit.INSTANCE;
            r126.add(r157);
            r154 = r156;
        L127:
            r129 = r131;
            goto L68
        L112:
            if (r144 == null) goto L114;
            List<he3.g> r159 = r144.c();
        L115:
            List<he3.g> r160 = r159;
            if (r160 != null) goto L118;
        L121:
            boolean r161 = true;
        L122:
            if (r161 == true) goto L127;
            Set<String> r162 = DeepFeedProductHeaderView.H0;
            if (r144 == null) goto L127;
            x0 r163 = new x0();
            r163.a(HeaderBannerItemType.Comment);
            r163.f484862h = r144;
            r163.f484858d = r129;
            r163.f484859e = r133;
            Unit r164 = Unit.INSTANCE;
            r126.add(r163);
            goto L127
        L118:
            if (r160.isEmpty() == true) goto L121;
            r161 = false;
            goto L122
        L114:
            r159 = null;
            goto L115
        L91:
            r143 = null;
            goto L92
        L87:
            r137 = CollectionsKt.emptyList();
            goto L88
        L78:
            if (r134.isEmpty() == true) goto L81;
            r135 = false;
            goto L82
        L128:
            return r126;
        L129:
            InFeedProductPackData r165 = r110.getPackData();
            if (r165 == null) goto L138;
            InFeedProductPackDataElements r166 = r165.getElements();
            if (r166 == null) goto L138;
            List<p0> r167 = r166.getProducts();
            if (r167 == null) goto L138;
            p0 r168 = (p0) CollectionsKt.firstOrNull(r167);
            if (r168 == null) goto L138;
            k1 r169 = r168.g();
        L139:
            ArrayList r170 = new ArrayList();
            if (r169 == null) goto L142;
            List<e2> r171 = r169.c();
        L143:
            if (r171 == null) goto L146;
            if (r111 == false) goto L146;
            Set<String> r172 = DeepFeedProductHeaderView.H0;
            b(r169, r170);
            a(r169, r170);
        L151:
            return r170;
        L146:
            if (r169 == null) goto L148;
            r101 = r169.c();
        L148:
            if (r101 == null) goto L150;
            Set<String> r173 = DeepFeedProductHeaderView.H0;
            b(r169, r170);
            goto L151
        L150:
            Set<String> r174 = DeepFeedProductHeaderView.H0;
            a(r169, r170);
            goto L151
        L142:
            r171 = null;
        L138:
            r169 = null;
        L61:
            r109 = 0;
            goto L62
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f174077a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f174078b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof b) == false) goto L10;
            b r101 = (b) r100;
            if (Intrinsics.areEqual(this.f174077a, r101.f174077a) == true) goto L8;
            return false;
        L8:
            if (this.f174078b == r101.f174078b) goto L16;
            return false;
        L16:
            return true;
        L10:
            return false;
        }

        public final int hashCode() {
            String r100 = this.f174077a;
            if (r100 == null) goto L5;
            int r101 = r100.hashCode();
        L7:
            return (r101 * 31) + this.f174078b;
        L5:
            r101 = 0;
            goto L7
        }

        public final String toString() {
            return "HeaderTabBinding(title=" + this.f174077a + ", startPosition=" + this.f174078b + ")";
        }

        public b(String r100, int r101) {
            Intrinsics.checkNotNullParameter(r100, "title");
            this.f174077a = r100;
            this.f174078b = r101;
        }
    }

    public static final class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ DeepFeedProductHeaderView f174081a;

        public c(DeepFeedProductHeaderView r100) {
            this.f174081a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            VideoCoverLayout r100 = this.f174081a.getVideoProgressContainer();     // Catch: Throwable -> L6
            if (r100 == null) goto L9;
            r100.b(0.0f, true);     // Catch: Throwable -> L6
            return;
        L9:
            return;
        L6:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L13;
            throw th;
        }
    }

    public static final class d implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ DeepFeedProductHeaderView f174082a;

        public d(DeepFeedProductHeaderView r100) {
            this.f174082a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            DeepFeedProductHeaderView r100 = this.f174082a;     // Catch: Throwable -> L4
            Set<String> r101 = DeepFeedProductHeaderView.H0;     // Catch: Throwable -> L4
            r100.n("slide");     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class e implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ DeepFeedProductHeaderView f174083a;

        public e(DeepFeedProductHeaderView r100) {
            this.f174083a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            View.OnClickListener r101 = this.f174083a.f174062m;
            if (r101 == null) goto L6;
            r101.onClick(r100);
            return;
        }
    }

    public static final class f implements View.OnLongClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ DeepFeedProductHeaderView f174084a;

        public f(DeepFeedProductHeaderView r100) {
            this.f174084a = r100;
        }

        @Override // android.view.View.OnLongClickListener
        public final boolean onLongClick(View r100) {
            View.OnLongClickListener r101 = this.f174084a.f174068r;
            if (r101 == null) goto L7;
            r101.onLongClick(r100);
            return false;
        L7:
            return false;
        }
    }

    public static final class g implements Function1<Boolean, Unit> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ DeepFeedProductHeaderView f174085a;

        public g(DeepFeedProductHeaderView r100) {
            this.f174085a = r100;
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(Boolean r100) {
            boolean r101 = r100.booleanValue();
            if (r101 == false) goto L18;
            VideoCoverLayout r102 = this.f174085a.getVideoProgressContainer();
            if (r102 == null) goto L18;
            if (r102.a() == false) goto L9;
            r102.f174259k.setVisibility(4);
            r102.f174255g.setVisibility(0);
        L10:
            r102.f174254f.setVisibility(0);
            r102.setPlayState(true);
            if (r102.f174260l == true) goto L18;
            r102.f174260l = true;
            fd3.b r103 = r102.f174249a;
            if (r103 == null) goto L15;
            r103.e();
        L15:
            fd3.b r104 = r102.f174249a;
            if (r104 == null) goto L18;
            r104.d();
            goto L18
        L9:
            r102.f174259k.setVisibility(0);
            ExtensionsKt.gone(r102.f174255g);
        L18:
            Function1<? super Boolean, Unit> r105 = this.f174085a.P;
            if (r105 == null) goto L22;
            Unit r106 = r105.invoke(Boolean.valueOf(r101));
        L22:
            if (((ArrayList) this.f174085a.f174066p0).size() == 0) goto L97;
            if (r101 == true) goto L97;
            x0 r107 = (x0) CollectionsKt.getOrNull(this.f174085a.f174066p0, 0);
            RecyclerView.LayoutManager r108 = null;
            if (r107 == null) goto L27;
            HeaderBannerItemType r109 = r107.getType();
        L29:
            if (r109 != HeaderBannerItemType.CoverVideo) goto L97;
            DeepFeedProductHeaderView r110 = this.f174085a;
            int r111 = r110.f174059k;
            List<x0> r112 = CollectionsKt.toMutableList(CollectionsKt.drop(r110.f174066p0, 1));
            ((ArrayList) r110.f174066p0).clear();
            ((ArrayList) r110.f174066p0).addAll(r112);
            r110.G = CollectionsKt.toList(r112);
            r110.f174048J = DeepFeedProductHeaderView.b(r112);
            if (r112.isEmpty() == true) goto L35;
            if (r111 <= 0) goto L35;
            int r113 = RangesKt.coerceAtMost(r111 - 1, CollectionsKt.getLastIndex(r112));
        L36:
            r110.f174059k = r113;
            DeepFeedProductBannerAdapter r114 = r110.f174054f;
            if (r114 == null) goto L39;
            int r115 = DeepFeedProductBannerAdapter.f173689z;
            r114.D2(r112, true);
        L39:
            r110.a();
            if (r110.h() == false) goto L51;
            DeepFeedProductHeaderTabLayout r116 = r110.f174075y;
            if (r116 == null) goto L44;
            r116.setVisibility(0);
        L44:
            FrameLayout r117 = r110.f174051c;
            if (r117 == null) goto L47;
            r117.setVisibility(8);
        L47:
            VideoCoverLayout r118 = r110.f174052d;
            if (r118 == null) goto L50;
            r118.setVisibility(4);
        L50:
            r110.o(r110.f174059k);
        L82:
            r110.f174049a.stopScroll();
            if ((true ^ r112.isEmpty()) == false) goto L92;
            RecyclerView.LayoutManager r119 = r110.f174049a.getLayoutManager();
            if ((r119 instanceof LinearLayoutManager) == false) goto L88;
            r108 = r119;
        L88:
            LinearLayoutManager r120 = (LinearLayoutManager) r108;
            if (r120 == null) goto L91;
            r120.scrollToPositionWithOffset(r110.f174059k, 0);
            goto L92
        L91:
            r110.f174049a.scrollToPosition(r110.f174059k);
        L92:
            r110.f174049a.post(new com.bytedance.android.shopping.deepfeed.weights.h(r110));
            r110.f174057i = false;
            DeepFeedProductBannerAdapter r121 = r110.f174054f;
            if (r121 == null) goto L95;
            r121.f173707r = false;
        L95:
            r110.f174055g.f173725c = false;
            r110.m();
            goto L97
        L51:
            ProductCardProgressIndicator r122 = r110.f174050b;
            if (r122 == null) goto L54;
            r122.setup(((ArrayList) r110.f174066p0).size());
        L54:
            VideoCoverLayout r123 = r110.f174052d;
            if (r123 == null) goto L57;
            r123.c(HeaderBannerItemType.VideoAndImage, ((ArrayList) r110.f174066p0).size());
        L57:
            List<x0> r124 = r110.f174066p0;
            if ((r124 instanceof Collection) == true) goto L60;
        L62:
            Iterator r125 = ((ArrayList) r124).iterator();
        L64:
            if (r125.hasNext() == false) goto L71;
            if (((x0) r125.next()).getType() != HeaderBannerItemType.CoverVideo) goto L68;
            boolean r126 = true;
        L69:
            if (r126 == false) goto L64;
            boolean r127 = true;
        L72:
            if (r127 == true) goto L82;
            ProductCardProgressIndicator r128 = r110.f174050b;
            if (r128 == null) goto L76;
            r128.setVisibility(0);
        L76:
            FrameLayout r129 = r110.f174051c;
            if (r129 == null) goto L79;
            r129.setVisibility(0);
        L79:
            VideoCoverLayout r130 = r110.f174052d;
            if (r130 == null) goto L82;
            r130.setVisibility(4);
            goto L82
        L68:
            r126 = false;
        L71:
            r127 = false;
            goto L72
        L60:
            if (((ArrayList) r124).isEmpty() == false) goto L62;
        L35:
            r113 = 0;
            goto L36
        L27:
            r109 = null;
        L97:
            return Unit.INSTANCE;
        }
    }

    public static final class h implements Function3<Long, Long, Long, Unit> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ DeepFeedProductHeaderView f174086a;

        public h(DeepFeedProductHeaderView r100) {
            this.f174086a = r100;
        }

        @Override // kotlin.jvm.functions.Function3
        public final Unit invoke(Long r100, Long r101, Long r102) {
            long r103 = r100.longValue();
            long r104 = r101.longValue();
            long r105 = r102.longValue();
            if (r103 == (-1)) goto L18;
            if (r104 == (-1)) goto L18;
            long r106 = r105 - r103;
            long r107 = r104 - r103;
            float r108 = r106 / r107;
            VideoCoverLayout r109 = this.f174086a.getVideoProgressContainer();     // Catch: Exception -> L15
            if (r109 == null) goto L10;
            r109.b(r108, false);     // Catch: Exception -> L15
        L10:
            VideoCoverLayout r110 = this.f174086a.getVideoProgressContainer();     // Catch: Exception -> L15
            if (r110 == null) goto L13;
            r110.setTotalDuration(r107);     // Catch: Exception -> L15
        L13:
            this.f174086a.S = RangesKt.coerceAtLeast(r106, 0);     // Catch: Exception -> L15
            this.f174086a.T = RangesKt.coerceAtLeast(r107, 0);     // Catch: Exception -> L15
        L15:
            e = move-exception;
            Logger.w("DeepFeedHeader", "video progress update error", e);
        L18:
            return Unit.INSTANCE;
        }
    }

    public DeepFeedProductHeaderView(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public DeepFeedProductHeaderView(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    static {
        H0 = new LinkedHashSet();
    }

    public final boolean e() {
        if (((ArrayList) this.f174066p0).size() <= 0) goto L12;
        x0 r100 = (x0) CollectionsKt.getOrNull(this.f174066p0, 0);
        if (r100 == null) goto L7;
        HeaderBannerItemType r101 = r100.getType();
    L9:
        if (r101 != HeaderBannerItemType.CoverVideo) goto L13;
        return true;
    L13:
        return false;
    L7:
        r101 = null;
        goto L9
    L12:
        return false;
    }

    public final boolean f() {
        if (((ArrayList) this.f174066p0).size() <= 1) goto L12;
        x0 r100 = (x0) CollectionsKt.getOrNull(this.f174066p0, 0);
        if (r100 == null) goto L7;
        HeaderBannerItemType r101 = r100.getType();
    L9:
        if (r101 != HeaderBannerItemType.CoverVideo) goto L13;
        return true;
    L13:
        return false;
    L7:
        r101 = null;
        goto L9
    L12:
        return false;
    }

    public final int getCurrentSelected() {
        OrientationHelper r100 = this.f174058j;
        if (r100 == null) goto L26;
        RecyclerView.LayoutManager r101 = null;
        View r102 = f0.a(this.f174049a, r100, null);
        if (r102 == null) goto L26;
        RecyclerView.LayoutManager r103 = this.f174049a.getLayoutManager();
        if ((r103 instanceof LinearLayoutManager) == false) goto L10;
        r101 = r103;
    L10:
        LinearLayoutManager r104 = (LinearLayoutManager) r101;
        if (r104 == null) goto L13;
        int r105 = r104.getPosition(r102);
    L14:
        DeepFeedProductBannerAdapter r106 = this.f174054f;
        if (r106 == null) goto L17;
        int r107 = ((ArrayList) r106.f173691b).size();
    L18:
        if (r105 >= r107) goto L20;
        return r105;
    L20:
        if (e() == false) goto L23;
        this.f174049a.scrollToPosition(1);
        return 1;
    L23:
        this.f174049a.scrollToPosition(0);
        return 0;
    L17:
        r107 = 0;
        goto L18
    L13:
        r105 = 0;
    L26:
        return 0;
    }

    public final int getItemCount() {
        DeepFeedProductBannerAdapter r100 = this.f174054f;
        if (r100 != null) goto L7;
        return 0;
    L7:
        return ((ArrayList) r100.f173691b).size();
    }

    public final boolean h() {
        return !this.f174048J.isEmpty();
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final void a() {
        if (h() == true) goto L5;
    L7:
        boolean r100 = false;
    L9:
        if (r100 == true) goto L14;
        DeepFeedProductHeaderTabLayout r101 = this.f174075y;
        if (r101 == null) goto L46;
        r101.setVisibility(8);
        return;
    L46:
        return;
    L14:
        DeepFeedProductHeaderTabLayout r102 = this.f174075y;
        if (r102 == null) goto L39;
        List<b> r103 = this.f174048J;
        ArrayList r104 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r103, 10));
        Iterator<T> r105 = r103.iterator();
    L18:
        if (r105.hasNext() == false) goto L20;
        r104.add(new DeepFeedProductHeaderTabLayout.b(((b) r105.next()).f174077a));
        goto L18
    L20:
        int r106 = l(this.f174059k);
        Function1<Integer, Unit> r107 = new DeepFeedProductHeaderView$bindHeaderTabs$2(this);
        Intrinsics.checkNotNullParameter(r104, "items");
        r102.f174042b = r104;
        r102.removeAllViews();
        ((ArrayList) r102.f174041a).clear();
        if (r104.isEmpty() == false) goto L23;
        r102.setVisibility(8);
        goto L39
    L23:
        r102.setVisibility(0);
        r102.b(r102.f174045e, r104.size());
        Iterator r108 = r104.iterator();
        int r109 = 0;
    L25:
        if (r108.hasNext() == false) goto L38;
        Object r110 = r108.next();
        int r111 = r109 + 1;
        if (r109 >= 0) goto L29;
        CollectionsKt.throwIndexOverflow();
    L29:
        String r112 = ((DeepFeedProductHeaderTabLayout.b) r110).f174047a;
        View r113 = r102.f174044d.inflate(R.layout.shopping_deep_feed_product_header_tab_item, r102, false);
        if (r113 == null) goto L37;
        AppCompatTextView r114 = (AppCompatTextView) r113;
        r114.setText(r112);
        r114.setOnClickListener(new com.bytedance.android.shopping.deepfeed.weights.e(r109, r107));
        if (r102.a() == false) goto L34;
        LinearLayout.LayoutParams r115 = new LinearLayout.LayoutParams(-2, DeepFeedProductHeaderTabLayout.f174040j);
    L35:
        r102.addView(r114, r115);
        ((ArrayList) r102.f174041a).add(r114);
        r109 = r111;
        goto L25
    L34:
        r115 = new LinearLayout.LayoutParams(0, -1, 1.0f);
        goto L35
    L37:
        throw new NullPointerException("null cannot be cast to non-null type androidx.appcompat.widget.AppCompatTextView");
    L38:
        r102.c(r106, null);
    L39:
        o(this.f174059k);
        return;
    L5:
        if (this.M == false) goto L7;
        r100 = true;
        goto L9
    }

    public final boolean c() {
        boolean r100 = false;
        if (h() == true) goto L5;
        return false;
    L5:
        if (this.M == false) goto L12;
        if (this.L == false) goto L12;
        if (e() == true) goto L12;
        r100 = true;
    L12:
        return !r100;
    }

    public final void i() {
        if (h() == false) goto L8;
        if (this.M == true) goto L8;
        return;
    L8:
        if (e() == false) goto L33;
        boolean r100 = false;
        RecyclerView.ViewHolder r101 = this.f174049a.findViewHolderForAdapterPosition(0);
        if (r101 != null) goto L12;
        return;
    L12:
        if ((r101 instanceof DeepFeedProductBannerVideoVH) == false) goto L35;
        DeepFeedProductBannerVideoVH r102 = (DeepFeedProductBannerVideoVH) r101;
        View r103 = r102.itemView;
        View r104 = null;
        if ((r103 instanceof com.bytedance.android.shopping.deepfeed.weights.c) == true) goto L16;
        r103 = null;
    L16:
        com.bytedance.android.shopping.deepfeed.weights.c r105 = (com.bytedance.android.shopping.deepfeed.weights.c) r103;
        if (r105 == null) goto L21;
        ECVideoPlayerView r106 = r105.getVideoPlayerView();
        if (r106 == null) goto L21;
        r100 = r106.h();
    L21:
        if (r100 == true) goto L36;
        View r107 = r102.itemView;
        if ((r107 instanceof com.bytedance.android.shopping.deepfeed.weights.c) == false) goto L26;
        r104 = r107;
    L26:
        com.bytedance.android.shopping.deepfeed.weights.c r108 = (com.bytedance.android.shopping.deepfeed.weights.c) r104;
        if (r108 == null) goto L31;
        ECVideoPlayerView r109 = r108.getVideoPlayerView();
        if (r109 == null) goto L31;
        r109.n();
    L31:
        r102.V3();
        return;
    L36:
        return;
    L35:
        return;
    }

    public final void m() {
        if (c() == false) goto L7;
        this.f174053e.c();
        return;
    L7:
        if (this.f174059k != 0) goto L12;
        if (e() == false) goto L12;
        return;
    L12:
        if (this.f174057i == false) goto L14;
        return;
    L14:
        if (this.f174059k >= getItemCount()) goto L18;
        this.f174053e.b();
        return;
    }

    public final TextView getAdTagView() {
        return this.C;
    }

    public final DeepFeedProductBannerAdapter getBannerAdapter() {
        return this.f174054f;
    }

    public final boolean getIgnoreAnimCall() {
        return this.f174057i;
    }

    public final View getMaskView() {
        return this.H;
    }

    public final ImageView getMuteIcon() {
        return this.A;
    }

    public final DeepFeedProductOverScrollPagerSnapHelper getOverScrollSnapHelper() {
        return this.f174055g;
    }

    public final ProductCardProgressIndicator getProgressIndicator() {
        return this.f174050b;
    }

    public final FrameLayout getProgressIndicatorContainer() {
        return this.f174051c;
    }

    public final PrimeHorizontalRecyclerView getRecyclerView() {
        return this.f174049a;
    }

    public final ConstraintLayout getSearchContainer() {
        return this.f174073w;
    }

    public final ImageView getUnmuteIcon() {
        return this.B;
    }

    public final VideoCoverLayout getVideoProgressContainer() {
        return this.f174052d;
    }

    public static List b(List r110) {
        ArrayList r100 = new ArrayList();
        Iterator r101 = r110.iterator();
        int r102 = 0;
    L4:
        if (r101.hasNext() == false) goto L36;
        Object r103 = r101.next();
        int r104 = r102 + 1;
        if (r102 >= 0) goto L8;
        CollectionsKt.throwIndexOverflow();
    L8:
        x0 r105 = (x0) r103;
        String r106 = r105.f484859e;
        if (r105.f484858d >= 0) goto L11;
    L32:
        b r107 = null;
    L33:
        if (r107 == null) goto L35;
        r100.add(r107);
    L35:
        r102 = r104;
        goto L4
    L11:
        if (r106 != null) goto L13;
    L16:
        boolean r108 = true;
    L17:
        if (r108 == true) goto L32;
        Iterator r109 = r110.iterator();
        int r111 = 0;
    L21:
        if (r109.hasNext() == false) goto L29;
        if (((x0) r109.next()).f484858d != r105.f484858d) goto L25;
        boolean r112 = true;
    L26:
        if (r112 == true) goto L30;
        r111 = r111 + 1;
    L30:
        if (r102 != r111) goto L32;
        r107 = new b(r106, r102);
        goto L33
    L25:
        r112 = false;
        goto L26
    L29:
        r111 = -1;
        goto L30
    L13:
        if (r106.length() == 0) goto L16;
        r108 = false;
        goto L17
    L36:
        return r100;
    }

    public final void d(boolean r100) {
        if (r100 == false) goto L5;
        this.A.setVisibility(0);
        this.B.setVisibility(4);
        return;
    L5:
        this.A.setVisibility(4);
        this.B.setVisibility(0);
    }

    public final void k(String r110) {
        Function4<? super Long, ? super Long, ? super Boolean, ? super String, Unit> r100 = this.R;
        if (r100 != null) goto L5;
        return;
    L5:
        long r101 = this.T;
        String r102 = this.V;
        if (r101 <= 0) goto L22;
        if (r102 != null) goto L9;
        return;
    L9:
        if (H0.add(r102) == false) goto L24;
        long r103 = RangesKt.coerceIn(this.S, 0, r101);
        if (this.U == false) goto L14;
    L19:
        boolean r104 = true;
    L20:
        r100.invoke(Long.valueOf(r103), Long.valueOf(r101), Boolean.valueOf(r104), r110);
        return;
    L14:
        if (r103 >= r101) goto L19;
        if (Intrinsics.areEqual(r110, "natural") == true) goto L19;
        r104 = false;
        goto L20
    L24:
        return;
    }

    public final int l(int r100) {
        x0 r101 = (x0) CollectionsKt.getOrNull(this.f174066p0, r100);
        int r102 = -1;
        if (r101 == null) goto L5;
        int r103 = r101.f484858d;
    L7:
        if (r103 >= 0) goto L9;
        return 0;
    L9:
        Iterator<b> r104 = this.f174048J.iterator();
        int r105 = 0;
    L10:
        boolean r106 = true;
        if (r104.hasNext() == false) goto L21;
        b r107 = r104.next();
        x0 r108 = (x0) CollectionsKt.getOrNull(this.f174066p0, r107.f174078b);
        if (r108 != null) goto L15;
    L17:
        boolean r109 = false;
    L18:
        if (r109 == true) goto L19;
        r105 = r105 + 1;
        goto L10
    L19:
        r102 = r105;
        goto L21
    L15:
        if (r108.f484858d != r103) goto L17;
        r109 = true;
    L21:
        Integer r110 = Integer.valueOf(r102);
        if (r110.intValue() >= 0) goto L25;
        r106 = false;
    L25:
        if (r106 == true) goto L28;
        r110 = null;
    L28:
        if (r110 != null) goto L30;
        return 0;
    L30:
        return r110.intValue();
    L5:
        r103 = -1;
        goto L7
    }

    public final void n(String r100) {
        if (r100 == null) goto L5;
        k(r100);
    L5:
        if (e() == false) goto L19;
        RecyclerView.ViewHolder r101 = this.f174049a.findViewHolderForAdapterPosition(0);
        if (r101 != null) goto L9;
        return;
    L9:
        if ((r101 instanceof DeepFeedProductBannerVideoVH) == false) goto L21;
        View r102 = ((DeepFeedProductBannerVideoVH) r101).itemView;
        if ((r102 instanceof com.bytedance.android.shopping.deepfeed.weights.c) == true) goto L13;
        r102 = null;
    L13:
        com.bytedance.android.shopping.deepfeed.weights.c r103 = (com.bytedance.android.shopping.deepfeed.weights.c) r102;
        if (r103 == null) goto L22;
        ECVideoPlayerView r104 = r103.getVideoPlayerView();
        if (r104 == null) goto L23;
        r104.x();
        return;
    L23:
        return;
    L22:
        return;
    L21:
        return;
    }

    public final void o(int r100) {
        if (h() == true) goto L5;
    L7:
        boolean r101 = false;
    L8:
        if (r101 == true) goto L13;
        DeepFeedProductHeaderTabLayout r102 = this.f174075y;
        if (r102 == null) goto L31;
        r102.setVisibility(8);
        return;
    L31:
        return;
    L13:
        x0 r103 = (x0) CollectionsKt.getOrNull(this.f174066p0, r100);
        if (r103 != null) goto L16;
        return;
    L16:
        int r104 = l(r100);
        if (r103.f484861g > 1) goto L19;
    L21:
        String r105 = r103.f484859e;
        if (r105 != null) goto L27;
        b r106 = (b) CollectionsKt.getOrNull(this.f174048J, r104);
        if (r106 == null) goto L26;
        r105 = r106.f174077a;
        goto L27
    L26:
        r105 = null;
    L27:
        DeepFeedProductHeaderTabLayout r107 = this.f174075y;
        if (r107 == null) goto L32;
        r107.c(r104, r105);
        return;
    L32:
        return;
    L19:
        if (r103.f484860f < 0) goto L21;
        r105 = r103.f484859e + (r103.f484860f + 1) + '/' + r103.f484861g;
        goto L27
    L5:
        if (this.M == false) goto L7;
        r101 = true;
        goto L8
    }

    public final void p(int r100) {
        int r101 = 8;
        if (e() == true) goto L8;
        VideoCoverLayout r102 = this.f174052d;
        if (r102 == null) goto L26;
        r102.setVisibility(8);
        return;
    L26:
        return;
    L8:
        VideoCoverLayout r103 = this.f174052d;
        if (r103 != null) goto L11;
        return;
    L11:
        if (r103.a() == true) goto L28;
        VideoCoverLayout r104 = this.f174052d;
        if (r104 == null) goto L29;
        x0 r105 = (x0) CollectionsKt.getOrNull(this.f174066p0, r100);
        if (r105 == null) goto L17;
        HeaderBannerItemType r106 = r105.getType();
    L19:
        if (r106 != HeaderBannerItemType.CoverVideo) goto L21;
        boolean r107 = true;
    L22:
        if (r107 == false) goto L24;
        r101 = 0;
    L24:
        r104.setVisibility(r101);
        return;
    L21:
        r107 = false;
        goto L22
    L17:
        r106 = null;
        goto L19
    L29:
        return;
    }

    public final void setBannerAdapter(DeepFeedProductBannerAdapter r100) {
        this.f174054f = r100;
    }

    public final void setIgnoreAnimCall(boolean r100) {
        this.f174057i = r100;
    }

    public final void setMute(boolean r100) {
        RecyclerView.ViewHolder r101 = this.f174049a.findViewHolderForAdapterPosition(0);
        if (r101 != null) goto L5;
        return;
    L5:
        if ((r101 instanceof DeepFeedProductBannerVideoVH) == false) goto L26;
        DeepFeedProductBannerVideoVH r102 = (DeepFeedProductBannerVideoVH) r101;
        View r103 = r102.itemView;
        View r104 = null;
        if ((r103 instanceof com.bytedance.android.shopping.deepfeed.weights.c) == true) goto L9;
        r103 = null;
    L9:
        com.bytedance.android.shopping.deepfeed.weights.c r105 = (com.bytedance.android.shopping.deepfeed.weights.c) r103;
        if (r105 == null) goto L14;
        ECVideoPlayerView r106 = r105.getVideoPlayerView();
        if (r106 == null) goto L14;
        r106.k(r100);
    L14:
        if (r100 == true) goto L27;
        View r107 = r102.itemView;
        if ((r107 instanceof com.bytedance.android.shopping.deepfeed.weights.c) == false) goto L19;
        r104 = r107;
    L19:
        com.bytedance.android.shopping.deepfeed.weights.c r108 = (com.bytedance.android.shopping.deepfeed.weights.c) r104;
        if (r108 == null) goto L28;
        ECVideoPlayerView r109 = r108.getVideoPlayerView();
        if (r109 == null) goto L29;
        r109.q();
        return;
    L29:
        return;
    L28:
        return;
    L27:
        return;
    }

    public final void setVideoProgressReportListener(Function4<? super Long, ? super Long, ? super Boolean, ? super String, Unit> r100) {
        this.R = r100;
    }

    public final void g(int r100, boolean r110) {
        int r101 = this.f174059k;
        int r102 = l(r101);
        this.f174059k = r100;
        o(r100);
        if (r100 >= 0) goto L5;
    L13:
        p(r100);
        float r103 = 0.0f;
        if (this.f174059k == 0) goto L16;
    L27:
        String r104 = null;
        if (r101 != 0) goto L57;
        if (this.f174059k == 0) goto L57;
        if (e() == false) goto L57;
        this.f174049a.post(new d(this));
        if (f() == false) goto L39;
        this.f174057i = true;
        DeepFeedProductBannerAdapter r111 = this.f174054f;
        if (r111 == null) goto L38;
        r111.f173707r = false;
    L38:
        this.f174055g.f173725c = false;
        r110 = false;
    L43:
        ProductCardProgressIndicator r105 = this.f174050b;
        if (r105 == null) goto L46;
        r105.setFillCurrent(false);
    L46:
        ProductCardProgressIndicator r106 = this.f174050b;
        if (r106 != null) goto L49;
    L52:
        VideoCoverLayout r107 = this.f174052d;
        if (r107 == null) goto L55;
        r107.f174255g.b(r100, 1.0f);
    L55:
        this.f174056h = null;
        m();
    L70:
        if (r110 == false) goto L74;
        Runnable r112 = this.f174056h;
        if (r112 == null) goto L74;
        r112.run();
    L74:
        ke3.a r113 = this.f174061l;
        if (r113 == null) goto L77;
        int r108 = this.f174059k;
        getItemCount();
        r113.a(r108, this.f174057i);
    L77:
        int r114 = l(this.f174059k);
        if (h() == true) goto L80;
    L82:
        boolean r109 = false;
    L83:
        if (r109 == false) goto L98;
        if (r102 == r114) goto L98;
        DeepFeedProductBannerAdapter r115 = this.f174054f;
        if (r115 == null) goto L98;
        if (r115.f173707r != true) goto L98;
        if (this.N == true) goto L98;
        x0 r116 = (x0) CollectionsKt.getOrNull(this.f174066p0, this.f174059k);
        if (r116 == null) goto L94;
        r104 = r116.f484859e;
    L94:
        if (r104 == null) goto L98;
        Function2<? super Integer, ? super String, Unit> r117 = this.f174067q;
        if (r117 == null) goto L98;
        Unit r118 = r117.invoke(Integer.valueOf(r114 + 1), r104);
    L98:
        this.N = false;
        RecyclerView.ViewHolder r119 = this.f174049a.findViewHolderForAdapterPosition(r100);
        DeepFeedProductBannerAdapter r120 = this.f174054f;
        if (r120 == null) goto L102;
        r120.C2(r119);
        return;
    L102:
        return;
    L80:
        if (this.M == false) goto L82;
        r109 = true;
        goto L83
    L49:
        if (this.f174057i == false) goto L51;
        r103 = 1.0f;
    L51:
        r106.b(r100, r103);
        goto L52
    L39:
        this.f174057i = false;
        DeepFeedProductBannerAdapter r121 = this.f174054f;
        if (r121 == null) goto L42;
        r121.f173707r = true;
    L42:
        this.f174055g.f173725c = true;
    L57:
        if (this.f174059k != 0) goto L59;
    L64:
        ProductCardProgressIndicator r122 = this.f174050b;
        if (r122 == null) goto L70;
        if (this.f174057i == false) goto L69;
        r103 = 1.0f;
    L69:
        r122.b(r100, r103);
        goto L70
    L59:
        if (f() == false) goto L64;
        VideoCoverLayout r123 = this.f174052d;
        if (r123 == null) goto L63;
        r123.f174255g.b(r100, 1.0f);
    L63:
        r110 = false;
        goto L70
    L16:
        if (e() == false) goto L27;
        if (r101 == 1) goto L19;
    L26:
        postDelayed(new c(this), 100);
        goto L27
    L19:
        if (f() == false) goto L26;
        VideoCoverLayout r124 = this.f174052d;
        if (r124 == null) goto L23;
        r124.f174255g.setFillCurrent(false);
    L23:
        VideoCoverLayout r125 = this.f174052d;
        if (r125 == null) goto L26;
        r125.f174255g.b(1, 0.0f);
        goto L26
    L5:
        if (r100 >= ((ArrayList) this.f174066p0).size()) goto L13;
        x0 r126 = (x0) CollectionsKt.getOrNull(this.f174066p0, r100);
        if (r126 == null) goto L13;
        HeaderBannerItemType r127 = r126.getType();
        if (r127 == null) goto L13;
        VideoCoverLayout r128 = this.f174052d;
        if (r128 == null) goto L13;
        Intrinsics.checkNotNullParameter(r127, "type");
        r128.f174257i = r127;
        goto L13
    }

    @Override // com.bytedance.android.shopping.deepfeed.ui.b
    public final void j(float r100, boolean r101) {
        ProductCardProgressIndicator r102 = this.f174050b;
        if (r102 == null) goto L5;
        r102.f176245j = r100;
        r102.invalidate();
    L5:
        if (r101 == true) goto L7;
        return;
    L7:
        if (c() == false) goto L9;
        this.f174053e.c();
        return;
    L9:
        int r103 = this.f174059k + 1;
        this.f174056h = new j(this);
        this.f174049a.smoothScrollToPosition(r103);
    }

    /* JADX WARN: Type inference failed for: r7v13, types: [com.bytedance.android.shopping.deepfeed.weights.DeepFeedProductHeaderView$onScrollStateChangedListener$1] */
    public DeepFeedProductHeaderView(final Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f174053e = new DeepFeedProductBannerIndicatorAnimator(this);
        DeepFeedProductOverScrollPagerSnapHelper r103 = new DeepFeedProductOverScrollPagerSnapHelper();
        this.f174055g = r103;
        this.f174069s = new e(this);
        this.f174070t = new DeepFeedProductHeaderView$innerBannerCommentClickListener$1(this);
        this.f174071u = new DeepFeedProductHeaderView$innerBannerCommentShowListener$1(this);
        this.f174072v = new f(this);
        this.f174048J = CollectionsKt.emptyList();
        int r104 = tc3.f.f545400a;
        this.L = Intrinsics.areEqual(tc3.a.a().q(), Boolean.TRUE);
        this.O = new h(this);
        this.Q = new DeepFeedProductHeaderView$videoPlayCompleteListener$1(this);
        this.W = new g(this);
        this.f174060k0 = new DeepFeedProductHeaderView$onScrollStateChangedListener$1(this);
        this.f174066p0 = new ArrayList();
        FrameLayout.inflate(r100, R.layout.shopping_deepfeed_product_header_view, this);
        this.H = findViewById(R.id.cover_bottom_mask);
        PrimeHorizontalRecyclerView r105 = (PrimeHorizontalRecyclerView) findViewById(R.id.infeed_product_header_view_pager);
        SmoothScrollLayoutManager r106 = new SmoothScrollLayoutManager(r100);
        r106.setItemPrefetchEnabled(false);
        Resources r107 = th.a.f(r106.f176249b);
        r106.f176248a = WindowDisplayMetricsOverride.apply(r107, r107.getDisplayMetrics()).density * 0.15f;
        Unit r108 = Unit.INSTANCE;
        r105.setLayoutManager(r106);
        r103.attachToRecyclerView(r105);     // Catch: IllegalStateException -> L5
    L10:
        r105.addOnScrollListener(this.f174060k0);
        this.f174058j = OrientationHelper.createOrientationHelper(r105.getLayoutManager(), 0);
        r105.setItemViewCacheSize(0);
        r105.setTouchCallback(new DeepFeedProductHeaderView$$special$$inlined$apply$lambda$1(this, r100));
        Unit r109 = Unit.INSTANCE;
        this.f174049a = r105;
        this.A = (ImageView) findViewById(R.id.iv_mute);
        this.B = (ImageView) findViewById(R.id.iv_unmute);
        this.C = (TextView) findViewById(R.id.tv_ad_tag);
        r105.addOnScrollListener(new HybridRecyclerViewPerformanceMonitor("homepage_mall_depp_feed_horizon", new JSONObject()));
        IHybridHostService r110 = com.bytedance.android.ec.hybrid.a.h();
        if (r110 == null) goto L16;
        r110.attachDropFrameMonitorTo("ec_mall_product_deep_feed_horizon", r105);
        return;
    L16:
        return;
    L5:
        e = move-exception;
        String r111 = e.getMessage();
        if (r111 != null) goto L9;
        r111 = "";
    L9:
        ECExceptionMonitor.c(r111);
        goto L10
    }

    public /* synthetic */ DeepFeedProductHeaderView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
