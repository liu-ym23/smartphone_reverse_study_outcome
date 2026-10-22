package com.android.ttcjpaysdk.integrated.counter.dypay.wrapper;

import android.content.res.Configuration;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.android.ttcjpaysdk.integrated.counter.data.CounterResponseBean;
import com.android.ttcjpaysdk.integrated.counter.wrapper.BaseConfirmWrapper;
import com.bytedance.caijing.sdk.infra.base.logger.CJLogger;
import com.larus.nova.R;
import com.ss.android.dypay.api.DyPayConstant;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\t\u0018\u0000 !2\u00020\u0001:\u0001!B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0012\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016J\u0012\u0010\u000b\u001a\u00020\b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J\n\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J\b\u0010\u0010\u001a\u00020\u0011H\u0016J\b\u0010\u0012\u001a\u00020\bH\u0016J\b\u0010\u0013\u001a\u00020\bH\u0016J\u0010\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\u0010\u0010\u0017\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J\u0010\u0010\u001a\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J\b\u0010\u001b\u001a\u00020\bH\u0016J\u0010\u0010\u001c\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J\u0010\u0010\u001d\u001a\u00020\b2\u0006\u0010\u001e\u001a\u00020\u0019H\u0016J\b\u0010\u001f\u001a\u00020\bH\u0002J\u0010\u0010 \u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\u0019H\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"Lcom/android/ttcjpaysdk/integrated/counter/dypay/wrapper/ConfirmEmptyWrapper;", "Lcom/android/ttcjpaysdk/integrated/counter/wrapper/BaseConfirmWrapper;", "contentView", "Landroid/view/View;", "(Landroid/view/View;)V", "hasTriggeredConfirm", "Ljava/util/concurrent/atomic/AtomicBoolean;", "bindData", "", "checkoutResponseBean", "Lcom/android/ttcjpaysdk/integrated/counter/data/CounterResponseBean;", "executeAdjustOnScreenChanged", "newConfig", "Landroid/content/res/Configuration;", "getRecyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "getResId", "", "hideLoading", "initActions", "onTimeChange", "time", "", "setBackVisible", "enable", "", "setPayConfirmViewEnabled", "setTitleData", "showConfirmLoading", DyPayConstant.KEY_SHOW_LOADING, "show", "triggerAutoConfirm", "updatePayConfirmContent", "Companion", "integrated-counter-dy-pay_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ConfirmEmptyWrapper extends BaseConfirmWrapper {
    public static final Companion Companion = null;
    private static final String TAG = "ConfirmEmptyWrapper";
    private final AtomicBoolean hasTriggeredConfirm;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/android/ttcjpaysdk/integrated/counter/dypay/wrapper/ConfirmEmptyWrapper$Companion;", "", "()V", "TAG", "", "integrated-counter-dy-pay_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }
    }

    static {
        Companion = new Companion(null);
    }

    @Override // com.android.ttcjpaysdk.integrated.counter.wrapper.BaseConfirmWrapper
    public void executeAdjustOnScreenChanged(Configuration r100) {
    }

    @Override // com.android.ttcjpaysdk.integrated.counter.wrapper.BaseConfirmWrapper
    public RecyclerView getRecyclerView() {
        return null;
    }

    @Override // com.android.ttcjpaysdk.integrated.counter.wrapper.BaseConfirmWrapper
    public int getResId() {
        return R.layout.cj_pay_view_integrated_confirm_empty;
    }

    @Override // com.android.ttcjpaysdk.integrated.counter.wrapper.BaseConfirmWrapper
    public void hideLoading() {
    }

    @Override // com.android.ttcjpaysdk.integrated.counter.wrapper.BaseConfirmWrapper
    public void initActions() {
    }

    @Override // com.android.ttcjpaysdk.integrated.counter.wrapper.BaseConfirmWrapper
    public void onTimeChange(String r100) {
        Intrinsics.checkNotNullParameter(r100, "time");
    }

    @Override // com.android.ttcjpaysdk.integrated.counter.wrapper.BaseConfirmWrapper
    public void setBackVisible(boolean r100) {
    }

    @Override // com.android.ttcjpaysdk.integrated.counter.wrapper.BaseConfirmWrapper
    public void setPayConfirmViewEnabled(boolean r100) {
    }

    @Override // com.android.ttcjpaysdk.integrated.counter.wrapper.BaseConfirmWrapper
    public void setTitleData() {
    }

    @Override // com.android.ttcjpaysdk.integrated.counter.wrapper.BaseConfirmWrapper
    public void showConfirmLoading(boolean r100) {
    }

    @Override // com.android.ttcjpaysdk.integrated.counter.wrapper.BaseConfirmWrapper
    public void showLoading(boolean r100) {
    }

    @Override // com.android.ttcjpaysdk.integrated.counter.wrapper.BaseConfirmWrapper
    public void updatePayConfirmContent(boolean r100) {
    }

    private final void triggerAutoConfirm() {
        if (this.hasTriggeredConfirm.compareAndSet(false, true) == true) goto L6;
        CJLogger.e(TAG, "triggerAutoConfirm already triggered, skip");
        return;
    L6:
        CJLogger.d(TAG, "triggerAutoConfirm, will post onPayConfirmClick");
        new Handler(Looper.getMainLooper()).post(new AnonymousClass1(this));
    }

    public ConfirmEmptyWrapper(View r100) {
        Intrinsics.checkNotNullParameter(r100, "contentView");
        super(r100);
        this.hasTriggeredConfirm = new AtomicBoolean(false);
    }

    @Override // com.android.ttcjpaysdk.integrated.counter.wrapper.BaseConfirmWrapper
    public void bindData(CounterResponseBean r100) {
        setCheckoutResponseBean(r100);
        triggerAutoConfirm();
    }
}
