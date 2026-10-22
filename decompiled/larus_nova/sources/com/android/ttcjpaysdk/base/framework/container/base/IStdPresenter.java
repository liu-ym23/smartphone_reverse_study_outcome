package com.android.ttcjpaysdk.base.framework.container.base;

import com.android.ttcjpaysdk.base.framework.container.base.StdModel;
import com.android.ttcjpaysdk.base.framework.container.base.StdView;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bf\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u0002*\b\b\u0001\u0010\u0003*\u00020\u00042\u00020\u0005J\u001c\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u00022\b\u0010\t\u001a\u0004\u0018\u00010\u0004H&J\b\u0010\n\u001a\u00020\u0007H&¨\u0006\u000b"}, d2 = {"Lcom/android/ttcjpaysdk/base/framework/container/base/IStdPresenter;", "M", "Lcom/android/ttcjpaysdk/base/framework/container/base/StdModel;", "V", "Lcom/android/ttcjpaysdk/base/framework/container/base/StdView;", "", "attachView", "", DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL, "view", "detachView", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface IStdPresenter<M extends StdModel, V extends StdView> {
    void attachView(StdModel r100, StdView r101);

    void detachView();
}
