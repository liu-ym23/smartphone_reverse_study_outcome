package com.bytedance.android.shopping.feed.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.Button;
import androidx.appcompat.widget.AppCompatButton;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.NotImplementedError;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Deprecated(message = "use ProductFlowCardBuyButton instead")
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B'\b\u0007\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\r\u0012\b\b\u0002\u0010\u000f\u001a\u00020\t¢\u0006\u0004\b\u0010\u0010\u0011J\b\u0010\u0004\u001a\u00020\u0003H\u0016J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\b\u0010\n\u001a\u00020\tH\u0016¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/shopping/feed/view/ProductFeedBuyButton;", "Landroidx/appcompat/widget/AppCompatButton;", "", "Landroid/widget/Button;", "getView", "", "float", "", "setRadius", "", "getBuyButtonActivityType", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ec-biz-inner-flow-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ProductFeedBuyButton extends AppCompatButton {
    public ProductFeedBuyButton(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public ProductFeedBuyButton(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    public int getBuyButtonActivityType() {
        throw new NotImplementedError("An operation is not implemented: Not yet implemented");
    }

    public Button getView() {
        throw new NotImplementedError("An operation is not implemented: Not yet implemented");
    }

    public void setRadius(float r100) {
        throw new NotImplementedError("An operation is not implemented: Not yet implemented");
    }

    public ProductFeedBuyButton(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
    }

    public /* synthetic */ ProductFeedBuyButton(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
