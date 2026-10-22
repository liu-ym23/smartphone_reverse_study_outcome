package com.bytedance.android.shopping.anchorv3.detail.widget.transwidget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.amap.api.col.s.ce;
import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.shopping.anchorv3.detail.widget.ECHorizontalScrollView;
import com.bytedance.android.shopping.anchorv3.detail.widget.ECRoundedLinearLayout;
import com.bytedance.android.shopping.anchorv3.detail.widget.VideoHolder;
import com.bytedance.android.shopping.anchorv3.detail.widget.VideoImageSquareViewPager;
import com.bytedance.android.shopping.anchorv3.detail.widget.j;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import fj.d;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\u0096\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b&\u0018\u00002\u00020\u00012\u00020\u0002B%\u0012\u0006\u0010[\u001a\u00020Z\u0012\n\b\u0002\u0010]\u001a\u0004\u0018\u00010\\\u0012\b\b\u0002\u0010^\u001a\u00020\u0005¢\u0006\u0004\b_\u0010`J\b\u0010\u0004\u001a\u00020\u0003H\u0014J\b\u0010\u0006\u001a\u00020\u0005H\u0016J\b\u0010\u0007\u001a\u00020\u0005H\u0016J\b\u0010\b\u001a\u00020\u0005H\u0016J\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\u0005H\u0016J\n\u0010\r\u001a\u0004\u0018\u00010\fH\u0016J\b\u0010\u000f\u001a\u00020\u000eH\u0016J\u0010\u0010\u0012\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\u0010H\u0016J+\u0010\u0017\u001a\u00020\n2!\u0010\u0016\u001a\u001d\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n0\u0013H\u0016J-\u0010\u0018\u001a\u00020\n2#\u0010\u0016\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010\u0005¢\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n0\u0013H\u0016J\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0019J\u0006\u0010\u001d\u001a\u00020\u001cR \u0010#\u001a\b\u0012\u0004\u0012\u00020\u001e0\u00198\u0004X\u0084\u0004¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"R \u0010'\u001a\b\u0012\u0004\u0012\u00020$0\u00198\u0004X\u0084\u0004¢\u0006\f\n\u0004\b%\u0010 \u001a\u0004\b&\u0010\"R$\u0010/\u001a\u0004\u0018\u00010(8\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\"\u00103\u001a\u0002008\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b1\u00102\u001a\u0004\b3\u00104\"\u0004\b5\u00106R\"\u0010>\u001a\u0002078\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b8\u00109\u001a\u0004\b:\u0010;\"\u0004\b<\u0010=R\u001b\u0010C\u001a\u00020?8DX\u0084\u0084\u0002¢\u0006\f\n\u0004\b@\u0010A\u001a\u0004\b\u000f\u0010BR\u001b\u0010G\u001a\u00020\u001c8DX\u0084\u0084\u0002¢\u0006\f\n\u0004\bD\u0010A\u001a\u0004\bE\u0010FR$\u0010N\u001a\u0004\u0018\u00010\u00108\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\bH\u0010I\u001a\u0004\bJ\u0010K\"\u0004\bL\u0010MR$\u0010V\u001a\u0004\u0018\u00010O8\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\bP\u0010Q\u001a\u0004\bR\u0010S\"\u0004\bT\u0010UR \u0010Y\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00198\u0004X\u0084\u0004¢\u0006\f\n\u0004\bW\u0010 \u001a\u0004\bX\u0010\"¨\u0006a"}, d2 = {"Lcom/bytedance/android/shopping/anchorv3/detail/widget/transwidget/BaseTransViewPager;", "Landroid/widget/FrameLayout;", "", "", "getECRoundedRadiusDip", "", "getCurrentImagePosition", "getCurrentVideoPosition", "getCurrentItemPosition", "position", "", "setCurrentSelected", "Lcom/bytedance/android/shopping/anchorv3/detail/widget/VideoHolder;", "getVideoHolder", "Lcom/bytedance/android/shopping/anchorv3/detail/widget/j;", "getViewPager", "Lc63/a;", "indicator", "setBannerIndicator", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "listener", "setItemClickListener", "setOnScrollBeginListener", "", "Lcom/bytedance/android/shopping/anchorv3/detail/widget/ECRoundedLinearLayout;", "getContainers", "Lcom/bytedance/android/shopping/anchorv3/detail/widget/ECHorizontalScrollView;", "getScrollView", "Lf63/a;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "Ljava/util/List;", "getImageItems", "()Ljava/util/List;", "imageItems", "Lfj/d;", "b", "getVideoItems", "videoItems", "Lcom/bytedance/android/ec/model/ECUrlModel;", "c", "Lcom/bytedance/android/ec/model/ECUrlModel;", "getAtmosphereImage", "()Lcom/bytedance/android/ec/model/ECUrlModel;", "setAtmosphereImage", "(Lcom/bytedance/android/ec/model/ECUrlModel;)V", "atmosphereImage", "", "d", "Z", "isViewPagerMode", "()Z", "setViewPagerMode", "(Z)V", "Landroid/view/View;", "e", "Landroid/view/View;", "getRootContainerView", "()Landroid/view/View;", "setRootContainerView", "(Landroid/view/View;)V", "rootContainerView", "Lcom/bytedance/android/shopping/anchorv3/detail/widget/VideoImageSquareViewPager;", "f", "Lkotlin/Lazy;", "()Lcom/bytedance/android/shopping/anchorv3/detail/widget/VideoImageSquareViewPager;", "viewPager", ce.f26391f, "getEcHorizontalScrollView", "()Lcom/bytedance/android/shopping/anchorv3/detail/widget/ECHorizontalScrollView;", "ecHorizontalScrollView", "h", "Lc63/a;", "getBindIndicator", "()Lc63/a;", "setBindIndicator", "(Lc63/a;)V", "bindIndicator", "Landroid/view/ViewGroup;", RXScreenCaptureService.KEY_INDEX, "Landroid/view/ViewGroup;", "getTransformVideoContainer", "()Landroid/view/ViewGroup;", "setTransformVideoContainer", "(Landroid/view/ViewGroup;)V", "transformVideoContainer", ce.f26395j, "getTransformContainerViews", "transformContainerViews", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public abstract class BaseTransViewPager extends FrameLayout implements j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<f63.a> f164992a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<d> f164993b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ECUrlModel f164994c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f164995d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public View f164996e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Lazy f164997f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Lazy f164998g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public c63.a f164999h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public ViewGroup f165000i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final List<ECRoundedLinearLayout> f165001j;

    public float getECRoundedRadiusDip() {
        return 0.0f;
    }

    public final ECHorizontalScrollView getEcHorizontalScrollView() {
        return (ECHorizontalScrollView) this.f164998g.getValue();
    }

    public final VideoImageSquareViewPager getViewPager() {
        return (VideoImageSquareViewPager) this.f164997f.getValue();
    }

    public int getCurrentImagePosition() {
        return getViewPager().getCurrentImagePosition();
    }

    public int getCurrentItemPosition() {
        return getViewPager().getCurrentItemPosition();
    }

    public int getCurrentVideoPosition() {
        return getViewPager().getCurrentVideoPosition();
    }

    public final ECHorizontalScrollView getScrollView() {
        return getEcHorizontalScrollView();
    }

    public VideoHolder getVideoHolder() {
        return getViewPager().getVideoHolder();
    }

    /* JADX INFO: renamed from: getViewPager, reason: collision with other method in class */
    public j m8283getViewPager() {
        return getViewPager();
    }

    public final ECUrlModel getAtmosphereImage() {
        return this.f164994c;
    }

    public final c63.a getBindIndicator() {
        return this.f164999h;
    }

    public final List<ECRoundedLinearLayout> getContainers() {
        return this.f165001j;
    }

    public final List<f63.a> getImageItems() {
        return this.f164992a;
    }

    public final View getRootContainerView() {
        return this.f164996e;
    }

    public final List<ECRoundedLinearLayout> getTransformContainerViews() {
        return this.f165001j;
    }

    public final ViewGroup getTransformVideoContainer() {
        return this.f165000i;
    }

    public final List<d> getVideoItems() {
        return this.f164993b;
    }

    public final void setAtmosphereImage(ECUrlModel r100) {
        this.f164994c = r100;
    }

    public void setBannerIndicator(c63.a r100) {
        Intrinsics.checkNotNullParameter(r100, "indicator");
        this.f164999h = r100;
        if (r100 == null) goto L6;
        getViewPager().i(r100);
        getViewPager().j(r100);
        return;
    }

    public final void setBindIndicator(c63.a r100) {
        this.f164999h = r100;
    }

    public void setCurrentSelected(int r100) {
        getViewPager().setCurrentSelected(r100);
    }

    public void setItemClickListener(Function1<? super Integer, Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        getViewPager().setItemClickListener(r100);
    }

    public void setOnScrollBeginListener(final Function1<? super Integer, Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        getViewPager().setOnScrollBeginListener(r100);
        getEcHorizontalScrollView().setOnScrollBeginListener(new AnonymousClass1(this, r100));
    }

    public final void setRootContainerView(View r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f164996e = r100;
    }

    public final void setTransformVideoContainer(ViewGroup r100) {
        this.f165000i = r100;
    }

    public final void setViewPagerMode(boolean r100) {
        this.f164995d = r100;
    }

    public BaseTransViewPager(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f164992a = new ArrayList();
        this.f164993b = new ArrayList();
        this.f164996e = u63.a.a(r100, R.layout.ec_commerce_anchor_v3_transform_viewpager_layout, this, true);
        this.f164997f = LazyKt.lazy(new BaseTransViewPager$viewPager$2(this));
        this.f164998g = LazyKt.lazy(new BaseTransViewPager$ecHorizontalScrollView$2(this));
        this.f165001j = new ArrayList();
    }
}
