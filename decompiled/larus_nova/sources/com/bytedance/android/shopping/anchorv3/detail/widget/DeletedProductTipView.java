package com.bytedance.android.shopping.anchorv3.detail.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.android.ec.core.utils.k1;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001d\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/android/shopping/anchorv3/detail/widget/DeletedProductTipView;", "Landroid/widget/LinearLayout;", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class DeletedProductTipView extends LinearLayout {
    public DeletedProductTipView(Context r100) {
        this(r100, null);
    }

    public DeletedProductTipView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
        LinearLayout.inflate(r100, R.layout.shopping_view_invalid_product_tip_view, this);
        SimpleDraweeView r102 = (SimpleDraweeView) findViewById(R.id.icon);
        TextView r103 = (TextView) findViewById(R.id.text);
        setOrientation(1);
        ViewGroup.LayoutParams r104 = r102.getLayoutParams();
        if ((r104 instanceof LinearLayout.LayoutParams) == true) goto L5;
        r104 = null;
    L5:
        LinearLayout.LayoutParams r105 = (LinearLayout.LayoutParams) r104;
        if (r105 == null) goto L9;
        r105.topMargin = k1.p() + com.bytedance.android.shopping.extensions.b.b(54);
        r102.setLayoutParams(r105);
        return;
    }
}
