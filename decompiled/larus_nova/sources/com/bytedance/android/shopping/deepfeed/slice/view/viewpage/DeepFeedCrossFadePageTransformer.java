package com.bytedance.android.shopping.deepfeed.slice.view.viewpage;

import android.view.View;
import androidx.viewpager2.widget.ViewPager2;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/shopping/deepfeed/slice/view/viewpage/DeepFeedCrossFadePageTransformer;", "Landroidx/viewpager2/widget/ViewPager2$PageTransformer;", "<init>", "()V", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class DeepFeedCrossFadePageTransformer implements ViewPager2.PageTransformer {
    public DeepFeedCrossFadePageTransformer() {
    }

    @Override // androidx.viewpager2.widget.ViewPager2.PageTransformer
    public final void transformPage(View r100, float r101) {
        Intrinsics.checkNotNullParameter(r100, "page");
        if (r101 >= (-1.0f)) goto L5;
    L7:
        float r102 = 0.0f;
    L8:
        r100.setAlpha(r102);
        return;
    L5:
        if (r101 > 1.0f) goto L7;
        r102 = 1.0f - Math.min(Math.abs(r101), 1.0f);
        goto L8
    }
}
