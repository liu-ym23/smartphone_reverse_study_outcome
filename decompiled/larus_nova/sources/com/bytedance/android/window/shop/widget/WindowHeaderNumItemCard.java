package com.bytedance.android.window.shop.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\b\u0010\r\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\u000e\u0010\u000fR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/window/shop/widget/WindowHeaderNumItemCard;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Landroid/widget/TextView;", "c", "Landroid/widget/TextView;", "getTitleView", "()Landroid/widget/TextView;", "setTitleView", "(Landroid/widget/TextView;)V", "titleView", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class WindowHeaderNumItemCard extends ConstraintLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public TextView f189925a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public TextView f189926b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public TextView f189927c;

    public final TextView getTitleView() {
        TextView r100 = this.f189927c;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("titleView");
    L5:
        return r100;
    }

    @Override // android.view.View
    public final void onFinishInflate() {
        super.onFinishInflate();
        this.f189925a = (TextView) findViewById(R.id.ec_window_number_item_amount);
        this.f189926b = (TextView) findViewById(R.id.ec_window_number_item_unit);
        this.f189927c = (TextView) findViewById(R.id.ec_window_number_item_title);
    }

    public final void setTitleView(TextView r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f189927c = r100;
    }

    public WindowHeaderNumItemCard(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
    }
}
