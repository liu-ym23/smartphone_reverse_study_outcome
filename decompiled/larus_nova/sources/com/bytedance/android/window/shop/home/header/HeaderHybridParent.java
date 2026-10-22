package com.bytedance.android.window.shop.home.header;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\bB\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\t"}, d2 = {"Lcom/bytedance/android/window/shop/home/header/HeaderHybridParent;", "Landroid/widget/FrameLayout;", "Landroid/content/Context;", "ctx", "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class HeaderHybridParent extends FrameLayout {

    public static final class a {
    }

    static {
    }

    public HeaderHybridParent(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, "ctx");
        Intrinsics.checkNotNullParameter(r101, "attrs");
        super(r100, r101);
    }

    @Override // android.widget.FrameLayout, android.view.View
    public final void onMeasure(int r100, int r101) {
        if (getChildCount() != 0) goto L6;
        super.onMeasure(r100, View.MeasureSpec.makeMeasureSpec(0, 1073741824));
        return;
    L6:
        super.onMeasure(r100, View.MeasureSpec.makeMeasureSpec(1073741823, 1073741824));
        setMeasuredDimension(getMeasuredWidth(), getChildAt(0).getMeasuredHeight());
    }
}
