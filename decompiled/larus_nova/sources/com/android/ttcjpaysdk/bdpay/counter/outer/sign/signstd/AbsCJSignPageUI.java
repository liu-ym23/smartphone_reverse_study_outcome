package com.android.ttcjpaysdk.bdpay.counter.outer.sign.signstd;

import android.app.Activity;
import android.view.ViewGroup;
import com.android.ttcjpaysdk.base.framework.BaseWrapper;
import com.android.ttcjpaysdk.bdpay.counter.outer.sign.AbsCJSignWrapper;
import com.android.ttcjpaysdk.bdpay.counter.outer.sign.CJSignContract;
import com.android.ttcjpaysdk.bdpay.counter.outer.sign.CJSignPageState;
import com.android.ttcjpaysdk.bdpay.counter.outer.sign.logger.CJPaySignOnlyLogger;
import com.bytedance.android.livesdkapi.LiveCommonConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\b\u0010\u0019\u001a\u00020\u001aH&J\b\u0010\u001b\u001a\u00020\u001aH&J\b\u0010\u001c\u001a\u00020\u001dH&J\u0010\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001f\u001a\u00020 H&J\u0010\u0010!\u001a\u00020\u001d2\u0006\u0010\"\u001a\u00020\u001aH&R\u0014\u0010\u0004\u001a\u00020\u0005X\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u0002\u001a\u00020\u0003X\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0006\u001a\u00020\u0007X\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0014\u0010\b\u001a\u00020\tX\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018¨\u0006#"}, d2 = {"Lcom/android/ttcjpaysdk/bdpay/counter/outer/sign/signstd/AbsCJSignPageUI;", "Lcom/android/ttcjpaysdk/base/framework/BaseWrapper;", "contentView", "Landroid/view/ViewGroup;", "activity", "Landroid/app/Activity;", "logger", "Lcom/android/ttcjpaysdk/bdpay/counter/outer/sign/logger/CJPaySignOnlyLogger;", "pageAction", "Lcom/android/ttcjpaysdk/bdpay/counter/outer/sign/CJSignContract$IAction;", "pageState", "Lcom/android/ttcjpaysdk/bdpay/counter/outer/sign/CJSignPageState;", "(Landroid/view/ViewGroup;Landroid/app/Activity;Lcom/android/ttcjpaysdk/bdpay/counter/outer/sign/logger/CJPaySignOnlyLogger;Lcom/android/ttcjpaysdk/bdpay/counter/outer/sign/CJSignContract$IAction;Lcom/android/ttcjpaysdk/bdpay/counter/outer/sign/CJSignPageState;)V", "getActivity", "()Landroid/app/Activity;", "getContentView", "()Landroid/view/ViewGroup;", "getLogger", "()Lcom/android/ttcjpaysdk/bdpay/counter/outer/sign/logger/CJPaySignOnlyLogger;", "getPageAction", "()Lcom/android/ttcjpaysdk/bdpay/counter/outer/sign/CJSignContract$IAction;", "getPageState", "()Lcom/android/ttcjpaysdk/bdpay/counter/outer/sign/CJSignPageState;", "setPageState", "(Lcom/android/ttcjpaysdk/bdpay/counter/outer/sign/CJSignPageState;)V", "isAgreementChecked", "", "isAgreementDeclined", LiveCommonConstants.REASON_ON_DEDTROY, "", "refreshUI", "scene", "Lcom/android/ttcjpaysdk/bdpay/counter/outer/sign/AbsCJSignWrapper$SignPageScene;", "setAgreementChecked", "isChecked", "bdpay-counter-outer_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public abstract class AbsCJSignPageUI extends BaseWrapper {
    private final Activity activity;
    private final ViewGroup contentView;
    private final CJPaySignOnlyLogger logger;
    private final CJSignContract.IAction pageAction;
    private CJSignPageState pageState;

    public abstract boolean isAgreementChecked();

    public abstract boolean isAgreementDeclined();

    public abstract void onDestroy();

    public abstract void refreshUI(AbsCJSignWrapper.SignPageScene r100);

    public abstract void setAgreementChecked(boolean r100);

    public final Activity getActivity() {
        return this.activity;
    }

    public final ViewGroup getContentView() {
        return this.contentView;
    }

    public final CJPaySignOnlyLogger getLogger() {
        return this.logger;
    }

    public final CJSignContract.IAction getPageAction() {
        return this.pageAction;
    }

    public final CJSignPageState getPageState() {
        return this.pageState;
    }

    public final void setPageState(CJSignPageState r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.pageState = r100;
    }

    public AbsCJSignPageUI(ViewGroup r100, Activity r101, CJPaySignOnlyLogger r102, CJSignContract.IAction r103, CJSignPageState r104) {
        Intrinsics.checkNotNullParameter(r100, "contentView");
        Intrinsics.checkNotNullParameter(r101, "activity");
        Intrinsics.checkNotNullParameter(r102, "logger");
        Intrinsics.checkNotNullParameter(r103, "pageAction");
        Intrinsics.checkNotNullParameter(r104, "pageState");
        super(r100);
        this.contentView = r100;
        this.activity = r101;
        this.logger = r102;
        this.pageAction = r103;
        this.pageState = r104;
        r100.getViewTreeObserver().addOnGlobalLayoutListener(new AnonymousClass1(this));
    }
}
