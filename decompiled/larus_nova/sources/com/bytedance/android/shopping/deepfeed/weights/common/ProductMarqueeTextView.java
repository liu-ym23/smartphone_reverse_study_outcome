package com.bytedance.android.shopping.deepfeed.weights.common;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Scroller;
import com.bytedance.android.shopping.deepfeed.utlis.j;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0016\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0002¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/shopping/deepfeed/weights/common/ProductMarqueeTextView;", "Lcom/bytedance/android/shopping/deepfeed/weights/common/DeepFeedMarqueeTextView;", "", "weight", "", "setWeight", "(Ljava/lang/Integer;)V", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public class ProductMarqueeTextView extends DeepFeedMarqueeTextView {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final com.bytedance.android.shopping.deepfeed.ui.view.a f174206u;

    public ProductMarqueeTextView(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public ProductMarqueeTextView(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    public final void z() {
        Scroller r100 = this.f174176b;
        if (r100 == null) goto L6;
        r100.startScroll(0, 0, 0, 0, 0);
    L6:
        setCurrentLoop(0);
        setScrollEnd(false);
        setHasAdjusted(false);
        setMFirst(true);
        scrollTo(0, 0);
        Scroller r101 = getMScroller();
        if (r101 == null) goto L10;
        r101.forceFinished(true);
        return;
    }

    public final void setWeight(Integer r100) {
        if (r100 == null) goto L7;
        r100.intValue();
        ConcurrentHashMap<String, j.a> r101 = j.f173985a;
        Typeface r102 = j.c("DouyinNumberABC-Medium", getContext(), r100);
        if (r102 == null) goto L8;
        setTypeface(r102);
        return;
    L8:
        return;
    }

    @Override // androidx.appcompat.widget.AppCompatTextView, android.widget.TextView, android.view.View
    public final void onMeasure(int r100, int r101) {
        com.bytedance.android.shopping.deepfeed.ui.view.a r102 = this.f174206u;
        if (r102 == null) goto L5;
        Pair<Integer, Integer> r103 = r102.b(r100, r101);
    L6:
        if (r103 == null) goto L8;
        super.onMeasure(r103.getFirst().intValue(), r103.getSecond().intValue());
        return;
    L8:
        super.onMeasure(r100, r101);
        return;
    L5:
        r103 = null;
        goto L6
    }

    @Override // com.bytedance.android.shopping.deepfeed.weights.common.DeepFeedMarqueeTextView, android.widget.TextView, android.view.View
    public final void onVisibilityChanged(View r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "changedView");
        z();
        super.onVisibilityChanged(r100, r101);
    }

    public ProductMarqueeTextView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        com.bytedance.android.shopping.deepfeed.ui.view.a r103 = com.bytedance.android.shopping.deepfeed.ui.view.a.f173924e;
        this.f174206u = com.bytedance.android.shopping.deepfeed.ui.view.a.f173924e;
        setWeight(400);
    }

    public /* synthetic */ ProductMarqueeTextView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
