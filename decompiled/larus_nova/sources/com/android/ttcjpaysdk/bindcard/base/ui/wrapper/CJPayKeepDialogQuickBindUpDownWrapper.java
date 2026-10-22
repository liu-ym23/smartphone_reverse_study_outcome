package com.android.ttcjpaysdk.bindcard.base.ui.wrapper;

import android.view.View;
import android.widget.TextView;
import com.android.ttcjpaysdk.bindcard.base.bean.CJPayKeepDialogBean;
import com.android.ttcjpaysdk.bindcard.base.ui.fragment.CJPayBindCardKeepDialogFragment;
import com.larus.nova.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\n¨\u0006\r"}, d2 = {"Lcom/android/ttcjpaysdk/bindcard/base/ui/wrapper/CJPayKeepDialogQuickBindUpDownWrapper;", "Lcom/android/ttcjpaysdk/bindcard/base/ui/wrapper/CJPayKeepDialogQuickBindWrapperAbstract;", "contentView", "Landroid/view/View;", CJPayBindCardKeepDialogFragment.DIALOG_BEAN_KEY, "Lcom/android/ttcjpaysdk/bindcard/base/bean/CJPayKeepDialogBean;", "(Landroid/view/View;Lcom/android/ttcjpaysdk/bindcard/base/bean/CJPayKeepDialogBean;)V", "btnContinue", "Landroid/widget/TextView;", "getBtnContinue", "()Landroid/widget/TextView;", "tvExit", "getTvExit", "bdpay-bindcard-base_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CJPayKeepDialogQuickBindUpDownWrapper extends CJPayKeepDialogQuickBindWrapperAbstract {
    private final TextView btnContinue;
    private final TextView tvExit;

    @Override // com.android.ttcjpaysdk.bindcard.base.ui.wrapper.CJPayKeepDialogQuickBindWrapperAbstract
    public /* bridge */ /* synthetic */ View getTvExit() {
        return getTvExit();
    }

    @Override // com.android.ttcjpaysdk.bindcard.base.ui.wrapper.CJPayKeepDialogQuickBindWrapperAbstract
    public TextView getBtnContinue() {
        return this.btnContinue;
    }

    @Override // com.android.ttcjpaysdk.bindcard.base.ui.wrapper.CJPayKeepDialogQuickBindWrapperAbstract
    public TextView getTvExit() {
        return this.tvExit;
    }

    public CJPayKeepDialogQuickBindUpDownWrapper(View r100, CJPayKeepDialogBean r101) {
        Intrinsics.checkNotNullParameter(r100, "contentView");
        super(r100, r101);
        this.tvExit = (TextView) r100.findViewById(R.id.exit_btn);
        this.btnContinue = (TextView) r100.findViewById(R.id.keep_dialog_btn_red);
        if (r101 == null) goto L5;
        String r102 = r101.button_left_msg;
    L6:
        if (r102 != null) goto L8;
    L11:
        boolean r103 = true;
    L12:
        String r104 = "放弃绑卡";
        if (r103 == false) goto L15;
        getTvExit().setText("放弃绑卡");
    L21:
        initView();
        return;
    L15:
        TextView r105 = getTvExit();
        if (r101 == null) goto L20;
        String r106 = r101.button_left_msg;
        if (r106 == null) goto L20;
        r104 = r106;
    L20:
        r105.setText(r104);
        goto L21
    L8:
        if (StringsKt.isBlank(r102) == true) goto L11;
        r103 = false;
        goto L12
    L5:
        r102 = null;
        goto L6
    }
}
