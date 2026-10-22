package com.bytedance.android.shopping.deepfeed.weights.common;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatTextView;
import com.bytedance.android.shopping.deepfeed.utlis.j;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0002¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/shopping/deepfeed/weights/common/ProductTextView;", "Landroidx/appcompat/widget/AppCompatTextView;", "", "weight", "", "setWeight", "(Ljava/lang/Integer;)V", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ProductTextView extends AppCompatTextView {
    public ProductTextView(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public ProductTextView(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
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

    public ProductTextView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        TypedArray r103 = r100.obtainStyledAttributes(r101, new int[]{R.attr.customMarginBottom, R.attr.customMarginLeft, R.attr.customMarginRight, R.attr.customMarginTop, R.attr.customWeight}, 0, 0);
        setWeight(Integer.valueOf(r103.getInt(4, 400)));
        r103.recycle();
    }

    public /* synthetic */ ProductTextView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
