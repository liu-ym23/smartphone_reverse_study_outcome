package com.bytedance.android.shopping.deepfeed.weights;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import androidx.core.view.ViewCompat;
import com.bytedance.android.shopping.deepfeed.weights.common.ProductTextView;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/shopping/deepfeed/weights/SalesViewContainer;", "Landroid/widget/LinearLayout;", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class SalesViewContainer extends LinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ProductTextView f174141a;

    public SalesViewContainer(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public SalesViewContainer(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    public SalesViewContainer(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        ProductTextView r103 = new ProductTextView(r100, null, 6, 0);
        r103.setId(ViewCompat.generateViewId());
        r103.setIncludeFontPadding(false);
        r103.setMaxLines(1);
        com.bytedance.android.shopping.deepfeed.ui.view.a r104 = com.bytedance.android.shopping.deepfeed.ui.view.a.f173924e;
        r103.setTextSize(0, com.bytedance.android.shopping.deepfeed.ui.view.a.C2600a.a(r100, 12));
        Integer r105 = com.bytedance.android.shopping.deepfeed.utlis.j.d("#16182399");
        if (r105 == null) goto L6;
        r103.setTextColor(r105.intValue());
    L6:
        if (tc3.f.e() == false) goto L8;
        r103.setGravity(80);
    L8:
        Unit r106 = Unit.INSTANCE;
        this.f174141a = r103;
        if (tc3.f.e() == false) goto L11;
        setGravity(80);
    L12:
        LinearLayout.LayoutParams r107 = new LinearLayout.LayoutParams(-2, -2);
        if (tc3.f.e() == false) goto L15;
        r107.gravity = 80;
    L15:
        addView(r103, r107);
        Integer r108 = tc3.f.c();
        if (r108 != null) goto L19;
    L21:
        Integer r109 = tc3.f.c();
        if (r109 != null) goto L25;
        return;
    L25:
        if (r109.intValue() != 2) goto L29;
        r103.setTextSize(0, com.bytedance.android.shopping.deepfeed.ui.view.a.C2600a.a(getContext(), 14));
        return;
    L29:
        return;
    L19:
        if (r108.intValue() != 1) goto L21;
        r103.setTextSize(0, com.bytedance.android.shopping.deepfeed.ui.view.a.C2600a.a(getContext(), 13));
        return;
    L11:
        setGravity(17);
        goto L12
    }

    public /* synthetic */ SalesViewContainer(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
