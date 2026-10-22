package com.android.ttcjpaysdk.base.framework.container.view.base.abs;

import androidx.exifinterface.media.ExifInterface;
import com.android.ttcjpaysdk.base.framework.container.abs.ITheme;
import com.android.ttcjpaysdk.base.framework.container.abs.Theme;
import com.android.ttcjpaysdk.base.framework.container.view.base.abs.IViewUiInfo;
import com.bytedance.ee.bear.lynx.impl.xbridge.method.view.SendEventContainerMethodParamModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\bf\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003J\u0017\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00018\u0000H&¢\u0006\u0002\u0010\u0007J\u0016\u0010\b\u001a\u00020\u00052\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00050\nH&¨\u0006\u000b"}, d2 = {"Lcom/android/ttcjpaysdk/base/framework/container/view/base/abs/IApiView;", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/android/ttcjpaysdk/base/framework/container/view/base/abs/IViewUiInfo;", "Lcom/android/ttcjpaysdk/base/framework/container/abs/ITheme;", "refresh", "", "viewUIInfo", "(Lcom/android/ttcjpaysdk/base/framework/container/view/base/abs/IViewUiInfo;)V", "setClickListener", SendEventContainerMethodParamModel.EventKinds.onClick, "Lkotlin/Function0;", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface IApiView<T extends IViewUiInfo> extends ITheme {

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class DefaultImpls {
        public static <T extends IViewUiInfo> Theme getTheme(IApiView<T> r100) {
            return ITheme.DefaultImpls.getTheme(r100);
        }

        public static <T extends IViewUiInfo> void setTheme(IApiView<T> r100, Theme r101) {
            Intrinsics.checkNotNullParameter(r101, "theme");
            ITheme.DefaultImpls.setTheme(r100, r101);
        }
    }

    void refresh(T r100);

    void setClickListener(Function0<Unit> r100);
}
