package com.android.ttcjpaysdk.bindcard.base.ui.wrapper;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.android.ttcjpaysdk.base.framework.BaseWrapper;
import com.android.ttcjpaysdk.base.ktextension.CJPayKotlinExtensionsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b&\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0003H&J\n\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&J\b\u0010\b\u001a\u00020\u0003H&J\u0016\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e¨\u0006\u000f"}, d2 = {"Lcom/android/ttcjpaysdk/bindcard/base/ui/wrapper/CJPayBindCardKeepDialogBaseWrapper;", "Lcom/android/ttcjpaysdk/base/framework/BaseWrapper;", "view", "Landroid/view/View;", "(Landroid/view/View;)V", "getContinueBtn", "getContinueBtnClickListener", "Landroid/view/View$OnClickListener;", "getExitBtn", "getSpaceLength", "", "flBankIcons", "Landroid/widget/FrameLayout;", "textView", "Landroid/widget/TextView;", "bdpay-bindcard-base_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public abstract class CJPayBindCardKeepDialogBaseWrapper extends BaseWrapper {
    public abstract View getContinueBtn();

    public abstract View.OnClickListener getContinueBtnClickListener();

    public abstract View getExitBtn();

    public CJPayBindCardKeepDialogBaseWrapper(View r100) {
        Intrinsics.checkNotNullParameter(r100, "view");
        super(r100);
    }

    public final int getSpaceLength(FrameLayout r100, TextView r101) {
        Intrinsics.checkNotNullParameter(r100, "flBankIcons");
        Intrinsics.checkNotNullParameter(r101, "textView");
        r100.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        return (int) ((r100.getMeasuredWidth() + CJPayKotlinExtensionsKt.dp2px(getContext(), 2.0f)) / r101.getPaint().measureText(" "));
    }
}
