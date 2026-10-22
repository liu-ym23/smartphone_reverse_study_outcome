package com.bytedance.android.shopping.feed.widget;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.android.ec.model.response.anchorv3.SellingPointInfoStruct;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B'\b\u0007\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/bytedance/android/shopping/feed/widget/InnerFeedSellingPointView;", "Lcom/bytedance/android/shopping/feed/widget/HorizontalSplitTextViewGroup;", "Lcom/bytedance/android/ec/model/response/anchorv3/SellingPointInfoStruct;", "Lcom/bytedance/android/shopping/feed/view/c;", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ec-biz-inner-flow-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class InnerFeedSellingPointView extends HorizontalSplitTextViewGroup<SellingPointInfoStruct> implements com.bytedance.android.shopping.feed.view.c {
    public InnerFeedSellingPointView(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public InnerFeedSellingPointView(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    @Override // com.bytedance.android.shopping.feed.view.c
    public final void a() {
    }

    @Override // com.bytedance.android.shopping.feed.widget.HorizontalSplitTextViewGroup
    public final void b(List<? extends SellingPointInfoStruct> r100) {
        super.b(r100);
        if (r100 == null) goto L13;
        Iterator<T> r101 = r100.iterator();
    L6:
        if (r101.hasNext() == false) goto L17;
        SellingPointInfoStruct r102 = (SellingPointInfoStruct) r101.next();
        TextView r103 = getServiceView();
        r103.setIncludeFontPadding(false);
        r103.setGravity(17);
        Resources r104 = Resources.getSystem();
        r103.setLayoutParams(new LinearLayout.LayoutParams(-2, MathKt.roundToInt(TypedValue.applyDimension(1, 16, WindowDisplayMetricsOverride.apply(r104, r104.getDisplayMetrics())))));
        float r105 = 4;
        Resources r106 = Resources.getSystem();
        int r107 = MathKt.roundToInt(TypedValue.applyDimension(1, r105, WindowDisplayMetricsOverride.apply(r106, r106.getDisplayMetrics())));
        Resources r108 = Resources.getSystem();
        r103.setPadding(r107, 0, MathKt.roundToInt(TypedValue.applyDimension(1, r105, WindowDisplayMetricsOverride.apply(r108, r108.getDisplayMetrics()))), 0);
        r103.setTextColor(ag4.a.b(R.color.commerce_color_BF161823));
        r103.setTextSize(1, 11.0f);
        r103.setSingleLine();
        r103.setBackgroundResource(R.drawable.commerce_feed_selling_point_bg);
        String r109 = null;
        if ((r102 instanceof SellingPointInfoStruct) == true) goto L10;
        r102 = null;
    L10:
        if (r102 == null) goto L12;
        r109 = r102.getContent();
    L12:
        r103.setText(r109);
        addView(r103);
        goto L6
    L17:
        return;
    }

    public InnerFeedSellingPointView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        setDividerDrawable(ag4.a.c(R.drawable.commerce_divider_feed_selling_point));
        Resources r103 = Resources.getSystem();
        setDividerPadding(MathKt.roundToInt(TypedValue.applyDimension(1, 4, WindowDisplayMetricsOverride.apply(r103, r103.getDisplayMetrics()))));
    }

    public /* synthetic */ InnerFeedSellingPointView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
