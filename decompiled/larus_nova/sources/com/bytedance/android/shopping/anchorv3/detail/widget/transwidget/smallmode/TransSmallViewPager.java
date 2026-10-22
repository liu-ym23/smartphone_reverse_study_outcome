package com.bytedance.android.shopping.anchorv3.detail.widget.transwidget.smallmode;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.amap.api.col.s.ce;
import com.bytedance.android.shopping.anchorv3.detail.widget.transwidget.BaseTransViewPager;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.officesdk.api.init.OfficeSDKRequestTag;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u001a\u0018\u00002\u00020\u0001:\u0001'J\b\u0010\u0003\u001a\u00020\u0002H\u0014J\u0006\u0010\u0005\u001a\u00020\u0004J\u0006\u0010\u0007\u001a\u00020\u0006J\b\u0010\t\u001a\u0004\u0018\u00010\bJ+\u0010\u0010\u001a\u00020\u000e2!\u0010\u000f\u001a\u001d\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u000e0\nH\u0016R\u001b\u0010\u0015\u001a\u00020\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u001b\u0010\u0018\u001a\u00020\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0016\u0010\u0012\u001a\u0004\b\u0017\u0010\u0014R\u001b\u0010\u001b\u001a\u00020\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0019\u0010\u0012\u001a\u0004\b\u001a\u0010\u0014R\u001b\u0010\u001e\u001a\u00020\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001c\u0010\u0012\u001a\u0004\b\u001d\u0010\u0014R\u001b\u0010!\u001a\u00020\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001f\u0010\u0012\u001a\u0004\b \u0010\u0014R\u0017\u0010&\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%¨\u0006("}, d2 = {"Lcom/bytedance/android/shopping/anchorv3/detail/widget/transwidget/smallmode/TransSmallViewPager;", "Lcom/bytedance/android/shopping/anchorv3/detail/widget/transwidget/BaseTransViewPager;", "", "getECRoundedRadiusDip", "", "getIsViewPagerMode", "", "getViewPagerCurrentIndex", "Landroid/widget/FrameLayout;", "getScrollContainer", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "position", "", "listener", "setItemClickListener", ce.f26396k, "Lkotlin/Lazy;", "getScreenWidth", "()I", "screenWidth", "l", "getSmallWidth", "smallWidth", "m", "getMBigWidth", "mBigWidth", OfficeSDKRequestTag.KEY_NEW_USER, "getMBigMargin", "mBigMargin", "o", "getMSmallMargin", "mSmallMargin", "p", "Z", "getFirstExpanded", "()Z", "firstExpanded", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class TransSmallViewPager extends BaseTransViewPager {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Lazy f165006k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Lazy f165007l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Lazy f165008m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Lazy f165009n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final Lazy f165010o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final boolean f165011p;

    public static final class a {
    }

    static {
    }

    public TransSmallViewPager(Context r100) {
        this(r100, null, 0, 14);
    }

    public TransSmallViewPager(Context r100, AttributeSet r101) {
        this(r100, r101, 0, 12);
    }

    public TransSmallViewPager(Context r100, AttributeSet r101, int r102) {
        this(r100, r101, r102, 8);
    }

    private final int getMBigMargin() {
        return ((Number) this.f165009n.getValue()).intValue();
    }

    private final int getMBigWidth() {
        return ((Number) this.f165008m.getValue()).intValue();
    }

    private final int getMSmallMargin() {
        return ((Number) this.f165010o.getValue()).intValue();
    }

    private final int getScreenWidth() {
        return ((Number) this.f165006k.getValue()).intValue();
    }

    private final int getSmallWidth() {
        return ((Number) this.f165007l.getValue()).intValue();
    }

    @Override // com.bytedance.android.shopping.anchorv3.detail.widget.transwidget.BaseTransViewPager
    public float getECRoundedRadiusDip() {
        return 6.0f;
    }

    public final FrameLayout getScrollContainer() {
        return null;
    }

    public final int getViewPagerCurrentIndex() {
        return getViewPager().getCurrentItem();
    }

    public final boolean getFirstExpanded() {
        return this.f165011p;
    }

    public final boolean getIsViewPagerMode() {
        return this.f164995d;
    }

    public static final /* synthetic */ int a(TransSmallViewPager r100) {
        return r100.getScreenWidth();
    }

    public static final /* synthetic */ int b(TransSmallViewPager r100) {
        return r100.getSmallWidth();
    }

    @Override // com.bytedance.android.shopping.anchorv3.detail.widget.transwidget.BaseTransViewPager
    public void setItemClickListener(Function1<? super Integer, Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        getViewPager().setItemClickListener(r100);
    }

    public TransSmallViewPager(final Context r100, AttributeSet r101, int r102, int r103) {
        if ((r103 & 2) == 0) goto L6;
        r101 = null;
    L6:
        if ((r103 & 4) == 0) goto L8;
        r102 = 0;
    L8:
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f165011p = false;
        Intrinsics.checkNotNullParameter(this, "mTransformViewPager");
        new ArrayList();
        new ArrayList();
        LazyKt.lazy(SmallTransition$mScreenWidth$2.INSTANCE);
        this.f165006k = LazyKt.lazy(new TransSmallViewPager$screenWidth$2(r100));
        this.f165007l = LazyKt.lazy(new TransSmallViewPager$smallWidth$2(this, r100));
        this.f165008m = LazyKt.lazy(new TransSmallViewPager$mBigWidth$2(this, r100));
        this.f165009n = LazyKt.lazy(new TransSmallViewPager$mBigMargin$2(r100));
        this.f165010o = LazyKt.lazy(new TransSmallViewPager$mSmallMargin$2(r100));
    }
}
