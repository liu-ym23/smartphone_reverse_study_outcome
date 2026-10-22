package com.android.ttcjpaysdk.base.framework.container.view.base.abs;

import android.content.Context;
import android.view.View;
import androidx.exifinterface.media.ExifInterface;
import com.android.ttcjpaysdk.base.framework.container.view.base.abs.IApiView;
import com.android.ttcjpaysdk.base.framework.container.view.base.abs.IViewUiInfo;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u0002*\u000e\b\u0001\u0010\u0003*\b\u0012\u0004\u0012\u0002H\u00010\u00042\u00020\u0005J\u0017\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00018\u0001H&¢\u0006\u0002\u0010\tJ\u0012\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J\u000f\u0010\u000e\u001a\u0004\u0018\u00018\u0000H&¢\u0006\u0002\u0010\u000f¨\u0006\u0010"}, d2 = {"Lcom/android/ttcjpaysdk/base/framework/container/view/base/abs/IViewController;", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/android/ttcjpaysdk/base/framework/container/view/base/abs/IViewUiInfo;", "R", "Lcom/android/ttcjpaysdk/base/framework/container/view/base/abs/IApiView;", "", "attachApiView", "", "apiView", "(Lcom/android/ttcjpaysdk/base/framework/container/view/base/abs/IApiView;)V", "getView", "Landroid/view/View;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "getViewUiInfo", "()Lcom/android/ttcjpaysdk/base/framework/container/view/base/abs/IViewUiInfo;", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface IViewController<T extends IViewUiInfo, R extends IApiView<T>> {

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class DefaultImpls {
        public static <T extends IViewUiInfo, R extends IApiView<T>> View getView(IViewController<T, R> r100, Context r101) {
            Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
            return null;
        }
    }

    void attachApiView(R r100);

    View getView(Context r100);

    T getViewUiInfo();
}
