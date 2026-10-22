package com.bytedance.android.shopping.feed.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.bytedance.android.ec.core.utils.y;
import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.ui.ec.widget.ecdraweeview.ECDraweeView;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0016\u0018\u00002\u00020\u00012\u00020\u0002B'\b\u0007\u0012\u0006\u0010\u001a\u001a\u00020\u0019\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001b\u0012\b\b\u0002\u0010\u001d\u001a\u00020\u0003¢\u0006\u0004\b\u001e\u0010\u001fJ\u000e\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003J\u0010\u0010\t\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0007J\u000e\u0010\f\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\nR\u001a\u0010\u0012\u001a\u00020\r8\u0004X\u0084\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0018\u001a\u00020\u00138\u0004X\u0084\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017¨\u0006 "}, d2 = {"Lcom/bytedance/android/shopping/feed/widget/InflowSimpleAbilityView;", "Landroid/widget/FrameLayout;", "", "", "resId", "", "setIcon", "Lcom/bytedance/android/ec/model/ECUrlModel;", "url", "setIconUrl", "", "text", "setText", "Lcom/bytedance/android/ui/ec/widget/ecdraweeview/ECDraweeView;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "Lcom/bytedance/android/ui/ec/widget/ecdraweeview/ECDraweeView;", "getIcon", "()Lcom/bytedance/android/ui/ec/widget/ecdraweeview/ECDraweeView;", "icon", "Landroid/widget/TextView;", "b", "Landroid/widget/TextView;", "getTextTV", "()Landroid/widget/TextView;", "textTV", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ec-biz-inner-flow-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public class InflowSimpleAbilityView extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ECDraweeView f175920a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TextView f175921b;

    public InflowSimpleAbilityView(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public InflowSimpleAbilityView(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    public final ECDraweeView getIcon() {
        return this.f175920a;
    }

    public final TextView getTextTV() {
        return this.f175921b;
    }

    public final void setIcon(int r100) {
        this.f175920a.setImageResource(r100);
    }

    public final void setIconUrl(ECUrlModel r100) {
        this.f175920a.setAdjustMode(2000);
        y.a(this.f175920a, r100);
    }

    public final void setText(String r100) {
        Intrinsics.checkNotNullParameter(r100, "text");
        this.f175921b.setText(r100);
    }

    public InflowSimpleAbilityView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        LayoutInflater.from(r100).inflate(R.layout.ec_inflow_card_ability_view, this);
        ECDraweeView r103 = (ECDraweeView) findViewById(R.id.product_flow_card_ability_view_icon);
        this.f175920a = r103;
        TextView r104 = (TextView) findViewById(R.id.product_flow_card_ability_view_tv);
        this.f175921b = r104;
        se3.a.c(r104, 2, 11.0f);
        se3.a.b(r103);
    }

    public /* synthetic */ InflowSimpleAbilityView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
