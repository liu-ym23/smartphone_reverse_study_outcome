package com.bytedance.android.shopping.product.flow.banner;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.OrientationHelper;
import androidx.recyclerview.widget.RecyclerView;
import com.amap.api.col.s.ce;
import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.shopping.widget.ecvideoplayer.ECVideoPlayer;
import com.bytedance.android.ui.ec.widget.ecdraweeview.ECDraweeView;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import yg3.c;
import yg3.d;
import yg3.e;
import yg3.f;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010Y\u001a\u00020X\u0012\n\b\u0002\u0010[\u001a\u0004\u0018\u00010Z\u0012\b\b\u0002\u0010\\\u001a\u000202¢\u0006\u0004\b]\u0010^J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\n\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002R\u0017\u0010\r\u001a\u00020\b8\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0013\u001a\u00020\u000e8\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0019\u001a\u00020\u00148\u0006¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R*\u0010\"\u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010\u001a8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u0017\u0010(\u001a\u00020#8\u0006¢\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'R.\u00101\u001a\u0004\u0018\u00010)2\b\u0010*\u001a\u0004\u0018\u00010)8\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b+\u0010,\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R\"\u00109\u001a\u0002028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b3\u00104\u001a\u0004\b5\u00106\"\u0004\b7\u00108R\"\u0010A\u001a\u00020:8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b;\u0010<\u001a\u0004\b=\u0010>\"\u0004\b?\u0010@R\"\u0010E\u001a\u00020:8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bB\u0010<\u001a\u0004\bC\u0010>\"\u0004\bD\u0010@R\u0017\u0010H\u001a\u0002028\u0006¢\u0006\f\n\u0004\bF\u00104\u001a\u0004\bG\u00106R.\u0010P\u001a\u0004\u0018\u00010I2\b\u0010*\u001a\u0004\u0018\u00010I8\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\bJ\u0010K\u001a\u0004\bL\u0010M\"\u0004\bN\u0010OR.\u0010R\u001a\u0004\u0018\u00010Q2\b\u0010*\u001a\u0004\u0018\u00010Q8\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\bR\u0010S\u001a\u0004\bT\u0010U\"\u0004\bV\u0010W¨\u0006_"}, d2 = {"Lcom/bytedance/android/shopping/product/flow/banner/BannerView;", "Landroid/widget/FrameLayout;", "Lyg3/c;", "IBannerIndicator", "", "setIndicator", "Lcom/bytedance/android/shopping/product/flow/banner/VideoBannerHolder;", "getVideoBannerHolder", "Landroidx/recyclerview/widget/RecyclerView;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "Landroidx/recyclerview/widget/RecyclerView;", "getViewPager", "()Landroidx/recyclerview/widget/RecyclerView;", "viewPager", "Lcom/bytedance/android/shopping/product/flow/banner/BannerAdapter;", "b", "Lcom/bytedance/android/shopping/product/flow/banner/BannerAdapter;", "getAdapter", "()Lcom/bytedance/android/shopping/product/flow/banner/BannerAdapter;", "adapter", "Lcom/bytedance/android/shopping/product/flow/banner/OverScrollPagerSnapHelper;", "c", "Lcom/bytedance/android/shopping/product/flow/banner/OverScrollPagerSnapHelper;", "getSnapHelper", "()Lcom/bytedance/android/shopping/product/flow/banner/OverScrollPagerSnapHelper;", "snapHelper", "", "Lcom/bytedance/android/ec/model/ECUrlModel;", "d", "Ljava/util/List;", "getImages", "()Ljava/util/List;", "setImages", "(Ljava/util/List;)V", "images", "Landroidx/recyclerview/widget/OrientationHelper;", "e", "Landroidx/recyclerview/widget/OrientationHelper;", "getOrientationHelper", "()Landroidx/recyclerview/widget/OrientationHelper;", "orientationHelper", "Lyg3/e;", "value", "h", "Lyg3/e;", "getOnOverScrollListener", "()Lyg3/e;", "setOnOverScrollListener", "(Lyg3/e;)V", "onOverScrollListener", "", RXScreenCaptureService.KEY_INDEX, "I", "getCurPagePos", "()I", "setCurPagePos", "(I)V", "curPagePos", "", ce.f26395j, "Z", "getShouldJump", "()Z", "setShouldJump", "(Z)V", "shouldJump", ce.f26396k, "getCanPullLeft", "setCanPullLeft", "canPullLeft", "l", "getThreshold", "threshold", "Lyg3/d;", "m", "Lyg3/d;", "getOnItemClickListener", "()Lyg3/d;", "setOnItemClickListener", "(Lyg3/d;)V", "onItemClickListener", "Lcom/bytedance/android/shopping/product/flow/banner/VideoBannerHolder$d;", "onVolumeClickListener", "Lcom/bytedance/android/shopping/product/flow/banner/VideoBannerHolder$d;", "getOnVolumeClickListener", "()Lcom/bytedance/android/shopping/product/flow/banner/VideoBannerHolder$d;", "setOnVolumeClickListener", "(Lcom/bytedance/android/shopping/product/flow/banner/VideoBannerHolder$d;)V", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class BannerView extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final RecyclerView f182325a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final BannerAdapter f182326b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final OverScrollPagerSnapHelper f182327c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public List<? extends ECUrlModel> f182328d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final OrientationHelper f182329e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final LinkedList<f> f182330f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public c f182331g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public e f182332h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f182333i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f182334j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f182335k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final int f182336l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public d f182337m;

    public static final class a implements f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ BannerView f182340a;

        @Override // yg3.f
        public final void a(ECDraweeView r100) {
        }

        public a(BannerView r100) {
            this.f182340a = r100;
        }

        @Override // yg3.f
        public final void onPageSelected(int r100, boolean r101) {
            BannerView r102 = this.f182340a;
            c r103 = r102.f182331g;
            if (r103 == null) goto L6;
            r103.a(r100, r102.getAdapter().getItemCount() - 1);
        L6:
            if (this.f182340a.getAdapter().f182322d == null) goto L8;
            boolean r104 = true;
        L9:
            if (r104 == false) goto L14;
            if (r100 != 0) goto L12;
            this.f182340a.b();
            return;
        L12:
            this.f182340a.a();
            return;
        L14:
            return;
        L8:
            r104 = false;
            goto L9
        }
    }

    public BannerView(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public BannerView(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    public final VideoBannerHolder.d getOnVolumeClickListener() {
        return null;
    }

    private final VideoBannerHolder getVideoBannerHolder() {
        if (this.f182326b.f182322d == null) goto L5;
        boolean r100 = true;
    L6:
        RecyclerView.ViewHolder r101 = null;
        if (r100 == false) goto L14;
        RecyclerView.ViewHolder r102 = this.f182325a.findViewHolderForAdapterPosition(0);
        if ((r102 instanceof VideoBannerHolder) == false) goto L13;
        r101 = r102;
    L13:
        return (VideoBannerHolder) r101;
    L14:
        return null;
    L5:
        r100 = false;
        goto L6
    }

    public final void b() {
        if (this.f182333i != 0) goto L10;
        VideoBannerHolder r100 = getVideoBannerHolder();
        if (r100 == null) goto L11;
        r100.f182347b.setVisibility(8);
        ECVideoPlayer r101 = r100.f182346a;
        if (r101 == null) goto L12;
        r101.k();
        return;
    L12:
        return;
    L11:
        return;
    }

    public final void a() {
        VideoBannerHolder r100 = getVideoBannerHolder();
        if (r100 == null) goto L8;
        ECVideoPlayer r101 = r100.f182346a;
        if (r101 == null) goto L9;
        r101.j();
        return;
    L9:
        return;
    }

    public final BannerAdapter getAdapter() {
        return this.f182326b;
    }

    public final boolean getCanPullLeft() {
        return this.f182335k;
    }

    public final int getCurPagePos() {
        return this.f182333i;
    }

    public final List<ECUrlModel> getImages() {
        return this.f182328d;
    }

    public final d getOnItemClickListener() {
        return this.f182337m;
    }

    public final e getOnOverScrollListener() {
        return this.f182332h;
    }

    public final OrientationHelper getOrientationHelper() {
        return this.f182329e;
    }

    public final boolean getShouldJump() {
        return this.f182334j;
    }

    public final OverScrollPagerSnapHelper getSnapHelper() {
        return this.f182327c;
    }

    public final int getThreshold() {
        return this.f182336l;
    }

    public final RecyclerView getViewPager() {
        return this.f182325a;
    }

    public final void setCanPullLeft(boolean r100) {
        this.f182335k = r100;
    }

    public final void setCurPagePos(int r100) {
        this.f182333i = r100;
    }

    public final void setImages(List<? extends ECUrlModel> r100) {
        this.f182328d = r100;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void setIndicator(c r100) {
        Intrinsics.checkNotNullParameter(r100, "IBannerIndicator");
        addView((View) r100);
        this.f182331g = r100;
        if (r100 == 0) goto L6;
        r100.b(this);
        return;
    }

    public final void setOnItemClickListener(d r100) {
        this.f182326b.f182321c = r100;
        this.f182337m = r100;
    }

    public final void setOnOverScrollListener(e r100) {
        this.f182327c.f182344a = r100;
        this.f182332h = r100;
    }

    public final void setOnVolumeClickListener(VideoBannerHolder.d r100) {
        getVideoBannerHolder();
        this.f182326b.getClass();
    }

    public final void setShouldJump(boolean r100) {
        this.f182334j = r100;
    }

    @Override // android.widget.FrameLayout, android.view.View
    public final void onMeasure(int r100, int r101) {
        super.onMeasure(r100, r100);
    }

    public BannerView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        RecyclerView r103 = new RecyclerView(r100);
        this.f182325a = r103;
        LinkedList<f> r104 = new LinkedList();
        this.f182330f = r104;
        this.f182335k = true;
        Resources r105 = Resources.getSystem();
        this.f182336l = MathKt.roundToInt(TypedValue.applyDimension(1, 26, WindowDisplayMetricsOverride.apply(r105, r105.getDisplayMetrics())));
        addView(r103, new FrameLayout.LayoutParams(-1, -1));
        BannerAdapter r106 = new BannerAdapter();
        this.f182326b = r106;
        r103.setAdapter(r106);
        r103.setLayoutManager(new LinearLayoutManager(r100, 0, false));
        OverScrollPagerSnapHelper r107 = new OverScrollPagerSnapHelper();
        this.f182327c = r107;
        r107.attachToRecyclerView(r103);
        this.f182329e = OrientationHelper.createOrientationHelper(r103.getLayoutManager(), 0);
        r103.setNestedScrollingEnabled(false);
        r103.addOnScrollListener(new AnonymousClass1(this));
        a r108 = new a(this);
        Intrinsics.checkNotNullParameter(r108, "onPageChangeListener");
        r104.add(r108);
    }

    public /* synthetic */ BannerView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
