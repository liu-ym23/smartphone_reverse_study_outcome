package com.android.ttcjpaysdk.integrated.sign.counter.presenter;

import com.android.ttcjpaysdk.base.mvp.mvp.BasePresenter;
import com.android.ttcjpaysdk.integrated.sign.counter.model.SignBaseModel;
import com.android.ttcjpaysdk.integrated.sign.counter.view.SignView;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0005¢\u0006\u0002\u0010\u0004J\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/android/ttcjpaysdk/integrated/sign/counter/presenter/SignPresenter;", "Lcom/android/ttcjpaysdk/base/mvp/mvp/BasePresenter;", "Lcom/android/ttcjpaysdk/integrated/sign/counter/model/SignBaseModel;", "Lcom/android/ttcjpaysdk/integrated/sign/counter/view/SignView;", "()V", "signCreate", "", "integrated-sign-counter_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class SignPresenter extends BasePresenter<SignBaseModel, SignView> {
    public final void signCreate() {
        SignBaseModel r100 = getModel();
        if (r100 == null) goto L6;
        r100.signCreate(new AnonymousClass1(this), null);
        return;
    }

    public SignPresenter() {
    }
}
