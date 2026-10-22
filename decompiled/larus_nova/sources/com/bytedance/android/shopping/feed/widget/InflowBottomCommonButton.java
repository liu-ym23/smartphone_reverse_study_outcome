package com.bytedance.android.shopping.feed.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.appcompat.widget.AppCompatButton;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductButtonStruct;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductStruct;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u00012\u00020\u0002B'\b\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t\u0012\b\b\u0002\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\r\u0010\u000eJ\n\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016J\n\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/shopping/feed/widget/InflowBottomCommonButton;", "Landroidx/appcompat/widget/AppCompatButton;", "", "", "getJumpUrl", "Lcom/bytedance/android/ec/model/response/anchorv3/PromotionProductStruct;", "getPromotion", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ec-biz-inner-flow-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public class InflowBottomCommonButton extends AppCompatButton {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public PromotionProductStruct f175909a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public PromotionProductButtonStruct f175910b;

    public InflowBottomCommonButton(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public InflowBottomCommonButton(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    public String getJumpUrl() {
        PromotionProductButtonStruct r100 = this.f175910b;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getOrderUrl();
    }

    public PromotionProductStruct getPromotion() {
        return this.f175909a;
    }

    public InflowBottomCommonButton(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        setText(ag4.a.d(R.string.commerce_buy_now));
        setGravity(17);
        setTextColor(getResources().getColor(R.color.white));
        setBackgroundResource(R.drawable.ec_inflow_bg_buy_button);
    }

    public /* synthetic */ InflowBottomCommonButton(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }

    public final void a(PromotionProductStruct r100, PromotionProductButtonStruct r101, final View.OnClickListener r102, rd3.a r103) {
        Intrinsics.checkNotNullParameter(r100, "promotion");
        this.f175909a = r100;
        this.f175910b = r101;
        if (r101 == null) goto L7;
        String r104 = r101.getText();
        if (r104 == null) goto L7;
    L8:
        setText(r104);
        if (r101 != null) goto L11;
    L13:
        com.bytedance.android.ec.core.widget.f.c(this, null, null, new InflowBottomCommonButton$bind$1(r102), 3);
        return;
    L11:
        if (r101.getGrayButton() != true) goto L13;
        setAlpha(0.5f);
        setOnClickListener(null);
        return;
    L7:
        r104 = ag4.a.d(R.string.commerce_buy_now);
        goto L8
    }
}
