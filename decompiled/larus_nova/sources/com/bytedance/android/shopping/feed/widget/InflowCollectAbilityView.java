package com.bytedance.android.shopping.feed.widget;

import android.content.Context;
import android.util.AttributeSet;
import com.bytedance.android.ec.core.utils.g1;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\n\u001a\u00020\t\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b\u0012\b\b\u0002\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u000f\u0010\u0010R*\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00028\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0004\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/shopping/feed/widget/InflowCollectAbilityView;", "Lcom/bytedance/android/shopping/feed/widget/InflowSimpleAbilityView;", "", "value", "isCollected", "Z", "()Z", "setCollected", "(Z)V", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ec-biz-inner-flow-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class InflowCollectAbilityView extends InflowSimpleAbilityView {
    public InflowCollectAbilityView(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public InflowCollectAbilityView(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    public final void setCollected(boolean r100) {
        if (r100 == false) goto L5;
        setIcon(R.drawable.shopping_product_feed_collect);
        int r101 = g1.f45599a;
        setText(g1.a.c(getContext(), R.string.shopping_product_feed_collect, new Object[0]));
        return;
    L5:
        setIcon(R.drawable.ec_inflow_ability_collect);
        int r102 = g1.f45599a;
        setText(g1.a.c(getContext(), R.string.shopping_product_feed_un_collect, new Object[0]));
    }

    public InflowCollectAbilityView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        setCollected(false);
    }

    public /* synthetic */ InflowCollectAbilityView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
