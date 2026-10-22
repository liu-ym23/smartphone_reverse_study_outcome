package com.android.ttcjpaysdk.base.framework.container.base;

import com.android.ttcjpaysdk.base.framework.container.base.StdModel;
import com.android.ttcjpaysdk.base.framework.container.base.StdView;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import com.ss.android.ugc.aweme.shortvideo.ShortVideoSegments;
import id4.c;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000e\b\u0016\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u0001*\b\b\u0001\u0010\u0004*\u00020\u00032\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0005B\t\b\u0016¢\u0006\u0004\b\u001a\u0010\u001bB\u0019\b\u0016\u0012\u0006\u0010\u0006\u001a\u00028\u0000\u0012\u0006\u0010\u0007\u001a\u00028\u0001¢\u0006\u0004\b\u001a\u0010\u001cJ\u001c\u0010\t\u001a\u00020\b2\b\u0010\u0006\u001a\u0004\u0018\u00010\u00012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003H\u0016J\b\u0010\n\u001a\u00020\bH\u0016J\u000f\u0010\u000b\u001a\u0004\u0018\u00018\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u0004\u0018\u00018\u0000¢\u0006\u0004\b\r\u0010\u000eJ\u000e\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u000fJ\b\u0010\u0012\u001a\u0004\u0018\u00010\u000fJ\b\u0010\u0013\u001a\u00020\bH\u0016R\u0018\u0010\u0014\u001a\u0004\u0018\u00018\u00018\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0018\u0010\u0016\u001a\u0004\u0018\u00018\u00008\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019¨\u0006\u001d"}, d2 = {"Lcom/android/ttcjpaysdk/base/framework/container/base/StdBasePresenter;", "Lcom/android/ttcjpaysdk/base/framework/container/base/StdModel;", "M", "Lcom/android/ttcjpaysdk/base/framework/container/base/StdView;", "V", "Lcom/android/ttcjpaysdk/base/framework/container/base/IStdPresenter;", DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL, "view", "", "attachView", "detachView", "getRootView", "()Lcom/android/ttcjpaysdk/base/framework/container/base/StdView;", "getModel", "()Lcom/android/ttcjpaysdk/base/framework/container/base/StdModel;", "Lid4/c;", ShortVideoSegments.KEY_PROP_PROVIDER, "bindContextProvider", "getContextProvider", "release", "mView", "Lcom/android/ttcjpaysdk/base/framework/container/base/StdView;", "mModel", "Lcom/android/ttcjpaysdk/base/framework/container/base/StdModel;", "contextProvider", "Lid4/c;", "<init>", "()V", "(Lcom/android/ttcjpaysdk/base/framework/container/base/StdModel;Lcom/android/ttcjpaysdk/base/framework/container/base/StdView;)V", "base-context_release"}, k = 1, mv = {1, 6, 0})
public class StdBasePresenter<M extends StdModel, V extends StdView> implements IStdPresenter<M, V> {
    private c contextProvider;
    private M mModel;
    private V mView;

    public StdBasePresenter() {
    }

    public void release() {
        this.contextProvider = null;
        detachView();
    }

    @Override // com.android.ttcjpaysdk.base.framework.container.base.IStdPresenter
    public void detachView() {
        M r100 = this.mModel;
        if (r100 == null) goto L5;
        r100.cancelRequest();
    L5:
        this.mModel = null;
        this.mView = null;
    }

    public final c getContextProvider() {
        return this.contextProvider;
    }

    public final M getModel() {
        return this.mModel;
    }

    public final V getRootView() {
        return this.mView;
    }

    public final void bindContextProvider(c r100) {
        Intrinsics.checkNotNullParameter(r100, ShortVideoSegments.KEY_PROP_PROVIDER);
        this.contextProvider = r100;
    }

    public StdBasePresenter(M r100, V r101) {
        Intrinsics.checkNotNullParameter(r100, DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL);
        Intrinsics.checkNotNullParameter(r101, "view");
        this.mView = r101;
        this.mModel = r100;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.android.ttcjpaysdk.base.framework.container.base.IStdPresenter
    public void attachView(StdModel r100, StdView r101) {
        if (r100 == 0) goto L4;
        this.mModel = r100;
    L4:
        if (r101 == 0) goto L7;
        this.mView = r101;
        return;
    }
}
