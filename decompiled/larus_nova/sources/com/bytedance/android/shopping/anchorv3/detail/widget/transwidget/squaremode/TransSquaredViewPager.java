package com.bytedance.android.shopping.anchorv3.detail.widget.transwidget.squaremode;

import android.content.Context;
import android.util.AttributeSet;
import com.amap.api.col.s.ce;
import com.bytedance.android.shopping.anchorv3.detail.widget.transwidget.BaseTransViewPager;
import com.ss.android.lark.officesdk.api.init.OfficeSDKRequestTag;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\t\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016R\u001b\u0010\u000b\u001a\u00020\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\nR\u0017\u0010\u0011\u001a\u00020\f8\u0006¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0014\u001a\u00020\f8\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u000e\u001a\u0004\b\u0013\u0010\u0010¨\u0006\u0015"}, d2 = {"Lcom/bytedance/android/shopping/anchorv3/detail/widget/transwidget/squaremode/TransSquaredViewPager;", "Lcom/bytedance/android/shopping/anchorv3/detail/widget/transwidget/BaseTransViewPager;", "Lc63/a;", "indicator", "", "setBannerIndicator", "", ce.f26396k, "Lkotlin/Lazy;", "getScreenWidth", "()I", "screenWidth", "", "m", "Z", "getFirstExpanded", "()Z", "firstExpanded", OfficeSDKRequestTag.KEY_NEW_USER, "getV4Head", "v4Head", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class TransSquaredViewPager extends BaseTransViewPager {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Lazy f165012k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final a f165013l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final boolean f165014m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final boolean f165015n;

    public TransSquaredViewPager(Context r100) {
        this(r100, null, 0, 30);
    }

    public TransSquaredViewPager(Context r100, AttributeSet r101) {
        this(r100, r101, 0, 28);
    }

    public TransSquaredViewPager(Context r100, AttributeSet r101, int r102) {
        this(r100, r101, r102, 24);
    }

    private final int getScreenWidth() {
        return ((Number) this.f165012k.getValue()).intValue();
    }

    public final boolean getFirstExpanded() {
        return this.f165014m;
    }

    public final boolean getV4Head() {
        return this.f165015n;
    }

    @Override // com.bytedance.android.shopping.anchorv3.detail.widget.transwidget.BaseTransViewPager
    public void setBannerIndicator(c63.a r100) {
        Intrinsics.checkNotNullParameter(r100, "indicator");
        super.setBannerIndicator(r100);
        c63.a r101 = getBindIndicator();
        if (r101 == null) goto L6;
        r101.setOnIndicatorSelectedListener(this.f165013l);
        return;
    }

    public TransSquaredViewPager(final Context r100, AttributeSet r101, int r102, int r103) {
        if ((r103 & 2) == 0) goto L6;
        r101 = null;
    L6:
        if ((r103 & 4) == 0) goto L8;
        r102 = 0;
    L8:
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f165014m = false;
        this.f165015n = false;
        Intrinsics.checkNotNullParameter(this, "mTransformViewPager");
        this.f165012k = LazyKt.lazy(new TransSquaredViewPager$screenWidth$2(r100));
        this.f165013l = new a();
    }
}
