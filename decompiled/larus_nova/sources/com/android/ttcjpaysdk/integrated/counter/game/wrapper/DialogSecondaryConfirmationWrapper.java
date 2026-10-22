package com.android.ttcjpaysdk.integrated.counter.game.wrapper;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.android.ttcjpaysdk.base.framework.BaseWrapper;
import com.android.ttcjpaysdk.base.ktextension.CJPayViewExtensionsKt;
import com.larus.nova.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0001\u0011B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u0016\u0010\u000b\u001a\n \r*\u0004\u0018\u00010\f0\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000e\u001a\n \r*\u0004\u0018\u00010\u000f0\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0010\u001a\n \r*\u0004\u0018\u00010\u000f0\u000fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/android/ttcjpaysdk/integrated/counter/game/wrapper/DialogSecondaryConfirmationWrapper;", "Lcom/android/ttcjpaysdk/base/framework/BaseWrapper;", "view", "Landroid/view/View;", "(Landroid/view/View;)V", "actionListener", "Lcom/android/ttcjpaysdk/integrated/counter/game/wrapper/DialogSecondaryConfirmationWrapper$ActionListener;", "getActionListener", "()Lcom/android/ttcjpaysdk/integrated/counter/game/wrapper/DialogSecondaryConfirmationWrapper$ActionListener;", "setActionListener", "(Lcom/android/ttcjpaysdk/integrated/counter/game/wrapper/DialogSecondaryConfirmationWrapper$ActionListener;)V", "ivCloseBtn", "Landroid/widget/ImageView;", "kotlin.jvm.PlatformType", "tvCancel", "Landroid/widget/TextView;", "tvContinue", "ActionListener", "integrated-counter-game_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class DialogSecondaryConfirmationWrapper extends BaseWrapper {
    private ActionListener actionListener;
    private final ImageView ivCloseBtn;
    private final TextView tvCancel;
    private final TextView tvContinue;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&J\b\u0010\u0005\u001a\u00020\u0003H&¨\u0006\u0006"}, d2 = {"Lcom/android/ttcjpaysdk/integrated/counter/game/wrapper/DialogSecondaryConfirmationWrapper$ActionListener;", "", "onCancel", "", "onClose", "onContinue", "integrated-counter-game_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface ActionListener {
        void onCancel();

        void onClose();

        void onContinue();
    }

    public final ActionListener getActionListener() {
        return this.actionListener;
    }

    public DialogSecondaryConfirmationWrapper(View r100) {
        Intrinsics.checkNotNullParameter(r100, "view");
        super(r100);
        ImageView r101 = (ImageView) r100.findViewById(R.id.iv_secondary_confirm_close);
        this.ivCloseBtn = r101;
        TextView r102 = (TextView) r100.findViewById(R.id.tv_cancel);
        this.tvCancel = r102;
        TextView r103 = (TextView) r100.findViewById(R.id.tv_continue);
        this.tvContinue = r103;
        CJPayViewExtensionsKt.setDebouncingOnClickListener(r101, new AnonymousClass1(this));
        CJPayViewExtensionsKt.setDebouncingOnClickListener(r102, new AnonymousClass2(this));
        CJPayViewExtensionsKt.setDebouncingOnClickListener(r103, new AnonymousClass3(this));
    }

    public final void setActionListener(ActionListener r100) {
        this.actionListener = r100;
    }
}
