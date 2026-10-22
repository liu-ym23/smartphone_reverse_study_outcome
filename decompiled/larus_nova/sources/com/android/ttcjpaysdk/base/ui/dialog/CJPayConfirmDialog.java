package com.android.ttcjpaysdk.base.ui.dialog;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.alipay.sdk.m.x.d;
import com.android.ttcjpaysdk.base.ktextension.CJPayViewExtensionsKt;
import com.android.ttcjpaysdk.base.ui.widget.LoadingButton;
import com.android.ttcjpaysdk.base.utils.CJPayBasicUtils;
import com.larus.nova.R;
import com.ss.android.dypay.api.DyPayConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u001eB\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\b\u0010\u0014\u001a\u00020\u0015H\u0002J\u000e\u0010\u0016\u001a\u00020\u00002\u0006\u0010\u0017\u001a\u00020\u0018J\u000e\u0010\u0019\u001a\u00020\u00002\u0006\u0010\u001a\u001a\u00020\u0018J\u000e\u0010\u001b\u001a\u00020\u00152\u0006\u0010\u001c\u001a\u00020\u001dR\u001c\u0010\b\u001a\u0004\u0018\u00010\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lcom/android/ttcjpaysdk/base/ui/dialog/CJPayConfirmDialog;", "Lcom/android/ttcjpaysdk/base/ui/dialog/CJPayFadeAnimationDialog;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "(Landroid/content/Context;)V", "themeResId", "", "(Landroid/content/Context;I)V", "actionListener", "Lcom/android/ttcjpaysdk/base/ui/dialog/CJPayConfirmDialog$DialogActionListener;", "getActionListener", "()Lcom/android/ttcjpaysdk/base/ui/dialog/CJPayConfirmDialog$DialogActionListener;", "setActionListener", "(Lcom/android/ttcjpaysdk/base/ui/dialog/CJPayConfirmDialog$DialogActionListener;)V", "closeImage", "Landroid/widget/ImageView;", "singleBtn", "Lcom/android/ttcjpaysdk/base/ui/widget/LoadingButton;", "titleTextView", "Landroid/widget/TextView;", "initView", "", "setButtonText", "buttonDesc", "", d.f25925o, "title", DyPayConstant.KEY_SHOW_LOADING, "show", "", "DialogActionListener", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CJPayConfirmDialog extends CJPayFadeAnimationDialog {
    private DialogActionListener actionListener;
    private ImageView closeImage;
    private LoadingButton singleBtn;
    private TextView titleTextView;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&¨\u0006\u0005"}, d2 = {"Lcom/android/ttcjpaysdk/base/ui/dialog/CJPayConfirmDialog$DialogActionListener;", "", "onClose", "", "onContinue", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface DialogActionListener {
        void onClose();

        void onContinue();
    }

    private final void initView() {
        View r100 = LayoutInflater.from(getContext()).inflate(R.layout.cj_pay_view_confirm_dialog_layout, null);
        setContentView(r100);
        setCancelable(false);
        this.closeImage = (ImageView) r100.findViewById(R.id.dialog_close_image);
        this.titleTextView = (TextView) r100.findViewById(R.id.dialog_title);
        this.singleBtn = (LoadingButton) r100.findViewById(R.id.dialog_btn);
        CJPayViewExtensionsKt.setDebouncingOnClickListener(this.closeImage, new AnonymousClass1(this));
        CJPayViewExtensionsKt.setDebouncingOnClickListener(this.singleBtn, new AnonymousClass2(this));
        ViewGroup.LayoutParams r101 = r100.getLayoutParams();
        r101.width = CJPayBasicUtils.dipToPX(getContext(), 280.0f);
        r100.getLayoutParams().height = -2;
    }

    public final DialogActionListener getActionListener() {
        return this.actionListener;
    }

    public CJPayConfirmDialog(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, R.style.CJ_Pay_Dialog_With_Layer);
    }

    public final void setActionListener(DialogActionListener r100) {
        this.actionListener = r100;
    }

    public final CJPayConfirmDialog setButtonText(String r100) {
        Intrinsics.checkNotNullParameter(r100, "buttonDesc");
        LoadingButton r101 = this.singleBtn;
        if (r101 == null) goto L6;
        r101.setButtonText(r100);
    L6:
        return this;
    }

    public final CJPayConfirmDialog setTitle(String r100) {
        Intrinsics.checkNotNullParameter(r100, "title");
        TextView r101 = this.titleTextView;
        if (r101 == null) goto L6;
        r101.setText(r100);
    L6:
        return this;
    }

    public final void showLoading(boolean r100) {
        if (r100 == false) goto L6;
        LoadingButton r101 = this.singleBtn;
        if (r101 == null) goto L10;
        r101.showLoading();
        return;
    L10:
        return;
    L6:
        LoadingButton r102 = this.singleBtn;
        if (r102 == null) goto L12;
        r102.hideLoading();
        return;
    }

    public CJPayConfirmDialog(Context r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, false, 4, null);
        initView();
    }

    public /* synthetic */ CJPayConfirmDialog(Context r100, int r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = R.style.CJ_Pay_Dialog_With_Layer;
    L5:
        this(r100, r101);
    }
}
