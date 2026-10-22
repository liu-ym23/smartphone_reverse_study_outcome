package com.android.ttcjpaysdk.bdpay.counter.outer.independent;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rR\u0016\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/android/ttcjpaysdk/bdpay/counter/outer/independent/MethodCategoryHeaderViewHolder;", "Lcom/android/ttcjpaysdk/bdpay/counter/outer/independent/OHomePageMethodViewHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "kotlin.jvm.PlatformType", "headerTv", "Landroid/widget/TextView;", "bindData", "", "groupTitle", "", "bdpay-counter-outer_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class MethodCategoryHeaderViewHolder extends OHomePageMethodViewHolder {
    private final Context context;
    private final TextView headerTv;

    public MethodCategoryHeaderViewHolder(View r100) {
        Intrinsics.checkNotNullParameter(r100, "itemView");
        super(r100);
        this.context = r100.getContext();
        this.headerTv = (TextView) r100.findViewById(R.id.tv_header_text);
    }

    public final void bindData(String r100) {
        Intrinsics.checkNotNullParameter(r100, "groupTitle");
        this.headerTv.setText(r100);
    }
}
