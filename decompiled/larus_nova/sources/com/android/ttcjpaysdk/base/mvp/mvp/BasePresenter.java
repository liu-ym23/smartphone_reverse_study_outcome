package com.android.ttcjpaysdk.base.mvp.mvp;

import android.content.Context;
import com.android.ttcjpaysdk.base.mvp.mvp.MvpModel;
import com.android.ttcjpaysdk.base.mvp.mvp.MvpView;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0016\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u0002*\b\b\u0001\u0010\u0003*\u00020\u00042\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00030\u0005B\u0007\b\u0016¢\u0006\u0002\u0010\u0006B\u0017\b\u0016\u0012\u0006\u0010\u0007\u001a\u00028\u0000\u0012\u0006\u0010\b\u001a\u00028\u0001¢\u0006\u0002\u0010\tJ\u001c\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0007\u001a\u0004\u0018\u00010\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u0004H\u0016J\b\u0010\u0010\u001a\u00020\u000fH\u0016J\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012J\r\u0010\u0013\u001a\u0004\u0018\u00018\u0000¢\u0006\u0002\u0010\u0014J\r\u0010\u0015\u001a\u0004\u0018\u00018\u0001¢\u0006\u0002\u0010\u0016R\u0012\u0010\n\u001a\u0004\u0018\u00018\u0000X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u000bR\u0012\u0010\f\u001a\u0004\u0018\u00018\u0001X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\r¨\u0006\u0017"}, d2 = {"Lcom/android/ttcjpaysdk/base/mvp/mvp/BasePresenter;", "M", "Lcom/android/ttcjpaysdk/base/mvp/mvp/MvpModel;", "V", "Lcom/android/ttcjpaysdk/base/mvp/mvp/MvpView;", "Lcom/android/ttcjpaysdk/base/mvp/mvp/MvpPresenter;", "()V", DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL, "view", "(Lcom/android/ttcjpaysdk/base/mvp/mvp/MvpModel;Lcom/android/ttcjpaysdk/base/mvp/mvp/MvpView;)V", "mModel", "Lcom/android/ttcjpaysdk/base/mvp/mvp/MvpModel;", "mView", "Lcom/android/ttcjpaysdk/base/mvp/mvp/MvpView;", "attachView", "", "detachView", "getContext", "Landroid/content/Context;", "getModel", "()Lcom/android/ttcjpaysdk/base/mvp/mvp/MvpModel;", "getRootView", "()Lcom/android/ttcjpaysdk/base/mvp/mvp/MvpView;", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public class BasePresenter<M extends MvpModel, V extends MvpView> implements MvpPresenter<M, V> {
    private M mModel;
    private V mView;

    public BasePresenter() {
    }

    @Override // com.android.ttcjpaysdk.base.mvp.mvp.MvpPresenter
    public void detachView() {
        M r100 = this.mModel;
        if (r100 == null) goto L5;
        r100.cancelRequest();
    L5:
        this.mModel = null;
        this.mView = null;
    }

    public final Context getContext() {
        V r100 = this.mView;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getContext();
    }

    public final M getModel() {
        return this.mModel;
    }

    public final V getRootView() {
        return this.mView;
    }

    public BasePresenter(M r100, V r101) {
        Intrinsics.checkNotNullParameter(r100, DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL);
        Intrinsics.checkNotNullParameter(r101, "view");
        this.mView = r101;
        this.mModel = r100;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.android.ttcjpaysdk.base.mvp.mvp.MvpPresenter
    public void attachView(MvpModel r100, MvpView r101) {
        if (r100 == 0) goto L4;
        this.mModel = r100;
    L4:
        if (r101 == 0) goto L7;
        this.mView = r101;
        return;
    }
}
