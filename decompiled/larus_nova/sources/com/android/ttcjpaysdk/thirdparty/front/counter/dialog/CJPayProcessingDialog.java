package com.android.ttcjpaysdk.thirdparty.front.counter.dialog;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.alipay.sdk.m.x.d;
import com.android.ttcjpaysdk.base.ktextension.CJPayViewExtensionsKt;
import com.android.ttcjpaysdk.base.theme.widget.CJPayCustomButton;
import com.android.ttcjpaysdk.base.ui.dialog.CJPayFadeAnimationDialog;
import com.android.ttcjpaysdk.base.utils.CJPayBasicUtils;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\u0018B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u000e\u0010\u0011\u001a\u00020\u00002\u0006\u0010\b\u001a\u00020\tJ\u000e\u0010\u0012\u001a\u00020\u00002\u0006\u0010\u0013\u001a\u00020\u0014J\u000e\u0010\u0015\u001a\u00020\u00002\u0006\u0010\u0013\u001a\u00020\u0014J\u000e\u0010\u0016\u001a\u00020\u00002\u0006\u0010\u0017\u001a\u00020\u0014R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/android/ttcjpaysdk/thirdparty/front/counter/dialog/CJPayProcessingDialog;", "Lcom/android/ttcjpaysdk/base/ui/dialog/CJPayFadeAnimationDialog;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "(Landroid/content/Context;)V", "themeResId", "", "(Landroid/content/Context;I)V", "actionListener", "Lcom/android/ttcjpaysdk/thirdparty/front/counter/dialog/CJPayProcessingDialog$ProcessingDialogActionListener;", "btProcessing", "Lcom/android/ttcjpaysdk/base/theme/widget/CJPayCustomButton;", "ivClose", "Landroid/widget/ImageView;", "tvContent", "Landroid/widget/TextView;", "tvTitle", "setActionListener", "setBtnText", "content", "", "setContent", d.f25925o, "title", "ProcessingDialogActionListener", "bdpay-front-counter_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CJPayProcessingDialog extends CJPayFadeAnimationDialog {
    private ProcessingDialogActionListener actionListener;
    private final CJPayCustomButton btProcessing;
    private final ImageView ivClose;
    private final TextView tvContent;
    private final TextView tvTitle;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&¨\u0006\u0005"}, d2 = {"Lcom/android/ttcjpaysdk/thirdparty/front/counter/dialog/CJPayProcessingDialog$ProcessingDialogActionListener;", "", "onBtnClick", "", "onCloseClick", "bdpay-front-counter_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface ProcessingDialogActionListener {
        void onBtnClick();

        void onCloseClick();
    }

    public CJPayProcessingDialog(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, R.style.CJ_Pay_Dialog_With_Layer);
    }

    public static final /* synthetic */ ProcessingDialogActionListener access$getActionListener$p(CJPayProcessingDialog r100) {
        return r100.actionListener;
    }

    public final CJPayProcessingDialog setActionListener(ProcessingDialogActionListener r100) {
        Intrinsics.checkNotNullParameter(r100, "actionListener");
        this.actionListener = r100;
        return this;
    }

    public final CJPayProcessingDialog setBtnText(String r100) {
        Intrinsics.checkNotNullParameter(r100, "content");
        this.btProcessing.setText(r100);
        return this;
    }

    public final CJPayProcessingDialog setContent(String r100) {
        Intrinsics.checkNotNullParameter(r100, "content");
        this.tvContent.setText(r100);
        return this;
    }

    public final CJPayProcessingDialog setTitle(String r100) {
        Intrinsics.checkNotNullParameter(r100, "title");
        this.tvTitle.setText(r100);
        return this;
    }

    public CJPayProcessingDialog(Context r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, false, 4, null);
        View r102 = LayoutInflater.from(r100).inflate(R.layout.cj_pay_view_processing_dialog_layout, null);
        setContentView(r102);
        setCancelable(false);
        ImageView r103 = (ImageView) r102.findViewById(R.id.iv_close);
        this.ivClose = r103;
        this.tvTitle = (TextView) r102.findViewById(R.id.tv_title);
        this.tvContent = (TextView) r102.findViewById(R.id.tv_content);
        CJPayCustomButton r104 = (CJPayCustomButton) r102.findViewById(R.id.bt_processing);
        this.btProcessing = r104;
        CJPayViewExtensionsKt.setDebouncingOnClickListener(r103, new AnonymousClass1(this));
        CJPayViewExtensionsKt.setDebouncingOnClickListener(r104, new AnonymousClass2(this));
        ViewGroup.LayoutParams r105 = r102.getLayoutParams();
        r105.width = CJPayBasicUtils.dipToPX(r100, 280.0f);
        r102.getLayoutParams().height = -2;
    }

    public /* synthetic */ CJPayProcessingDialog(Context r100, int r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = R.style.CJ_Pay_Dialog_With_Layer;
    L5:
        this(r100, r101);
    }
}
