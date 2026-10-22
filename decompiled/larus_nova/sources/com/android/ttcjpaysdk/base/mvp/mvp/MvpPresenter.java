package com.android.ttcjpaysdk.base.mvp.mvp;

import com.android.ttcjpaysdk.base.mvp.mvp.MvpModel;
import com.android.ttcjpaysdk.base.mvp.mvp.MvpView;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bf\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u0002*\b\b\u0001\u0010\u0003*\u00020\u00042\u00020\u0005J\u001c\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u00022\b\u0010\t\u001a\u0004\u0018\u00010\u0004H&J\b\u0010\n\u001a\u00020\u0007H&¨\u0006\u000b"}, d2 = {"Lcom/android/ttcjpaysdk/base/mvp/mvp/MvpPresenter;", "M", "Lcom/android/ttcjpaysdk/base/mvp/mvp/MvpModel;", "V", "Lcom/android/ttcjpaysdk/base/mvp/mvp/MvpView;", "", "attachView", "", DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL, "view", "detachView", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface MvpPresenter<M extends MvpModel, V extends MvpView> {
    void attachView(MvpModel r100, MvpView r101);

    void detachView();
}
