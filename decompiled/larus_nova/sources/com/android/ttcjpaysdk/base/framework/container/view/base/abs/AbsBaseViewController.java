package com.android.ttcjpaysdk.base.framework.container.view.base.abs;

import android.content.Context;
import android.view.View;
import androidx.exifinterface.media.ExifInterface;
import com.android.ttcjpaysdk.base.framework.container.view.base.abs.IApiView;
import com.android.ttcjpaysdk.base.framework.container.view.base.abs.IViewUiInfo;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0006\b&\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u0002*\u000e\b\u0001\u0010\u0003*\b\u0012\u0004\u0012\u0002H\u00010\u00042\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00030\u0005B\u000f\u0012\b\u0010\u0006\u001a\u0004\u0018\u00018\u0000¢\u0006\u0002\u0010\u0007J\u0015\u0010\u000b\u001a\u00020\f2\b\u0010\b\u001a\u0004\u0018\u00018\u0001¢\u0006\u0002\u0010\rJ\r\u0010\u000e\u001a\u0004\u0018\u00018\u0001¢\u0006\u0002\u0010\u000fJ\r\u0010\u0010\u001a\u0004\u0018\u00018\u0000¢\u0006\u0002\u0010\u0011R\u0012\u0010\b\u001a\u0004\u0018\u00018\u0001X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\tR\u0012\u0010\u0006\u001a\u0004\u0018\u00018\u0000X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\n¨\u0006\u0012"}, d2 = {"Lcom/android/ttcjpaysdk/base/framework/container/view/base/abs/AbsBaseViewController;", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/android/ttcjpaysdk/base/framework/container/view/base/abs/IViewUiInfo;", "R", "Lcom/android/ttcjpaysdk/base/framework/container/view/base/abs/IApiView;", "Lcom/android/ttcjpaysdk/base/framework/container/view/base/abs/IViewController;", "viewUIInfo", "(Lcom/android/ttcjpaysdk/base/framework/container/view/base/abs/IViewUiInfo;)V", "apiView", "Lcom/android/ttcjpaysdk/base/framework/container/view/base/abs/IApiView;", "Lcom/android/ttcjpaysdk/base/framework/container/view/base/abs/IViewUiInfo;", "attachApiView", "", "(Lcom/android/ttcjpaysdk/base/framework/container/view/base/abs/IApiView;)V", "getApiView", "()Lcom/android/ttcjpaysdk/base/framework/container/view/base/abs/IApiView;", "getViewUiInfo", "()Lcom/android/ttcjpaysdk/base/framework/container/view/base/abs/IViewUiInfo;", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public abstract class AbsBaseViewController<T extends IViewUiInfo, R extends IApiView<T>> implements IViewController<T, R> {
    private R apiView;
    private T viewUIInfo;

    public final R getApiView() {
        return this.apiView;
    }

    @Override // com.android.ttcjpaysdk.base.framework.container.view.base.abs.IViewController
    public final T getViewUiInfo() {
        return this.viewUIInfo;
    }

    public AbsBaseViewController(T r100) {
        this.viewUIInfo = r100;
    }

    @Override // com.android.ttcjpaysdk.base.framework.container.view.base.abs.IViewController
    public final void attachApiView(R r100) {
        this.apiView = r100;
        if (r100 == null) goto L6;
        r100.refresh(this.viewUIInfo);
        return;
    }

    @Override // com.android.ttcjpaysdk.base.framework.container.view.base.abs.IViewController
    public View getView(Context r100) {
        return IViewController.DefaultImpls.getView(this, r100);
    }
}
