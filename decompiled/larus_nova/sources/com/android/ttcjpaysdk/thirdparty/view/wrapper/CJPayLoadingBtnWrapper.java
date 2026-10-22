package com.android.ttcjpaysdk.thirdparty.view.wrapper;

import android.text.TextUtils;
import android.view.View;
import android.widget.ProgressBar;
import com.android.ttcjpaysdk.base.framework.BaseWrapper;
import com.android.ttcjpaysdk.base.ktextension.CJPayViewExtensionsKt;
import com.android.ttcjpaysdk.base.theme.widget.CJPayCustomButton;
import com.larus.nova.R;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0006\u0010\u000e\u001a\u00020\tJ\u0014\u0010\u000f\u001a\u00020\t2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\t0\bJ\u0010\u0010\u0011\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J\u0006\u0010\u0014\u001a\u00020\tJ\u000e\u0010\u0015\u001a\u00020\t2\u0006\u0010\u0016\u001a\u00020\u0005R\u0016\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/android/ttcjpaysdk/thirdparty/view/wrapper/CJPayLoadingBtnWrapper;", "Lcom/android/ttcjpaysdk/base/framework/BaseWrapper;", "view", "Landroid/view/View;", "btnText", "", "(Landroid/view/View;Ljava/lang/String;)V", "btnClick", "Lkotlin/Function0;", "", "nextBtn", "Lcom/android/ttcjpaysdk/base/theme/widget/CJPayCustomButton;", "progressLoading", "Landroid/widget/ProgressBar;", "hideLoadingView", "setClickListener", "click", "setLoadingView", "isShowLoading", "", "showLoadingView", "updateBtnText", "str", "bdpay-base_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CJPayLoadingBtnWrapper extends BaseWrapper {
    private Function0<Unit> btnClick;
    private String btnText;
    private final CJPayCustomButton nextBtn;
    private final ProgressBar progressLoading;

    public final void hideLoadingView() {
        setLoadingView(false);
    }

    public final void showLoadingView() {
        setLoadingView(true);
    }

    public static final /* synthetic */ Function0 access$getBtnClick$p(CJPayLoadingBtnWrapper r100) {
        return r100.btnClick;
    }

    public static final /* synthetic */ String access$getBtnText$p(CJPayLoadingBtnWrapper r100) {
        return r100.btnText;
    }

    public static final /* synthetic */ CJPayCustomButton access$getNextBtn$p(CJPayLoadingBtnWrapper r100) {
        return r100.nextBtn;
    }

    public static final /* synthetic */ ProgressBar access$getProgressLoading$p(CJPayLoadingBtnWrapper r100) {
        return r100.progressLoading;
    }

    private final void setLoadingView(final boolean r100) {
        getRootView().post(new RunnableC97061(r100, this));
    }

    public final void setClickListener(Function0<Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "click");
        this.btnClick = r100;
    }

    public final void updateBtnText(String r100) {
        Intrinsics.checkNotNullParameter(r100, "str");
        this.btnText = r100;
    }

    public CJPayLoadingBtnWrapper(View r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r101, "btnText");
        super(r100);
        this.btnText = r101;
        CJPayCustomButton r102 = (CJPayCustomButton) r100.findViewById(R.id.btn_next_step);
        this.nextBtn = r102;
        this.progressLoading = (ProgressBar) r100.findViewById(R.id.progressBar_loading);
        if (TextUtils.isEmpty(this.btnText) == true) goto L5;
        r102.setText(this.btnText);
    L5:
        CJPayViewExtensionsKt.setDebouncingOnClickListener(r102, new AnonymousClass1(this));
    }
}
