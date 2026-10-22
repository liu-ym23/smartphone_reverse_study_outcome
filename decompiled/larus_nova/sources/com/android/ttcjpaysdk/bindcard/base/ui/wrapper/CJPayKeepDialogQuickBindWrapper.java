package com.android.ttcjpaysdk.bindcard.base.ui.wrapper;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.android.ttcjpaysdk.bindcard.base.bean.CJPayKeepDialogBean;
import com.android.ttcjpaysdk.bindcard.base.ui.fragment.CJPayBindCardKeepDialogFragment;
import com.larus.nova.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\fX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/android/ttcjpaysdk/bindcard/base/ui/wrapper/CJPayKeepDialogQuickBindWrapper;", "Lcom/android/ttcjpaysdk/bindcard/base/ui/wrapper/CJPayKeepDialogQuickBindWrapperAbstract;", "contentView", "Landroid/view/View;", CJPayBindCardKeepDialogFragment.DIALOG_BEAN_KEY, "Lcom/android/ttcjpaysdk/bindcard/base/bean/CJPayKeepDialogBean;", "(Landroid/view/View;Lcom/android/ttcjpaysdk/bindcard/base/bean/CJPayKeepDialogBean;)V", "btnContinue", "Landroid/widget/TextView;", "getBtnContinue", "()Landroid/widget/TextView;", "tvExit", "Landroid/widget/ImageView;", "getTvExit", "()Landroid/widget/ImageView;", "bdpay-bindcard-base_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CJPayKeepDialogQuickBindWrapper extends CJPayKeepDialogQuickBindWrapperAbstract {
    private final TextView btnContinue;
    private final ImageView tvExit;

    @Override // com.android.ttcjpaysdk.bindcard.base.ui.wrapper.CJPayKeepDialogQuickBindWrapperAbstract
    public /* bridge */ /* synthetic */ View getTvExit() {
        return getTvExit();
    }

    @Override // com.android.ttcjpaysdk.bindcard.base.ui.wrapper.CJPayKeepDialogQuickBindWrapperAbstract
    public TextView getBtnContinue() {
        return this.btnContinue;
    }

    @Override // com.android.ttcjpaysdk.bindcard.base.ui.wrapper.CJPayKeepDialogQuickBindWrapperAbstract
    public ImageView getTvExit() {
        return this.tvExit;
    }

    public CJPayKeepDialogQuickBindWrapper(View r100, CJPayKeepDialogBean r101) {
        Intrinsics.checkNotNullParameter(r100, "contentView");
        super(r100, r101);
        this.tvExit = (ImageView) r100.findViewById(R.id.iv_close);
        this.btnContinue = (TextView) r100.findViewById(R.id.keep_dialog_btn_red);
        initView();
    }
}
