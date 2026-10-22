package com.android.ttcjpaysdk.integrated.counter.fragment;

import com.android.ttcjpaysdk.base.mvp.base.MvpBaseFragment;
import com.android.ttcjpaysdk.base.mvp.mvp.BasePresenter;
import com.android.ttcjpaysdk.base.mvp.mvp.MvpModel;
import com.android.ttcjpaysdk.base.mvp.mvp.MvpView;
import com.android.ttcjpaysdk.integrated.counter.beans.ShareData;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\b&\u0018\u0000*\u0018\b\u0000\u0010\u0001*\u0012\u0012\u0006\b\u0001\u0012\u00020\u0003\u0012\u0006\b\u0001\u0012\u00020\u00040\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0005B\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\r\u001a\u00020\u000eH&R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\f¨\u0006\u000f"}, d2 = {"Lcom/android/ttcjpaysdk/integrated/counter/fragment/CommonFragment;", "P", "Lcom/android/ttcjpaysdk/base/mvp/mvp/BasePresenter;", "Lcom/android/ttcjpaysdk/base/mvp/mvp/MvpModel;", "Lcom/android/ttcjpaysdk/base/mvp/mvp/MvpView;", "Lcom/android/ttcjpaysdk/base/mvp/base/MvpBaseFragment;", "()V", "shareData", "Lcom/android/ttcjpaysdk/integrated/counter/beans/ShareData;", "getShareData", "()Lcom/android/ttcjpaysdk/integrated/counter/beans/ShareData;", "setShareData", "(Lcom/android/ttcjpaysdk/integrated/counter/beans/ShareData;)V", "refreshData", "", "integrated-counter_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public abstract class CommonFragment<P extends BasePresenter<? extends MvpModel, ? extends MvpView>> extends MvpBaseFragment<P> {
    private ShareData shareData;

    public abstract void refreshData();

    public CommonFragment() {
    }

    public final ShareData getShareData() {
        return this.shareData;
    }

    public final void setShareData(ShareData r100) {
        this.shareData = r100;
    }
}
