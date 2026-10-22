package com.android.ttcjpaysdk.base.framework.container.view.components;

import com.android.ttcjpaysdk.base.framework.container.abs.Theme;
import com.android.ttcjpaysdk.base.framework.container.view.base.abs.IApiView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\bf\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0004H&J\u0012\u0010\u0005\u001a\u00020\u00042\b\b\u0001\u0010\u0006\u001a\u00020\u0007H&J\b\u0010\b\u001a\u00020\u0004H&¨\u0006\t"}, d2 = {"Lcom/android/ttcjpaysdk/base/framework/container/view/components/IErrorPageApiView;", "Lcom/android/ttcjpaysdk/base/framework/container/view/base/abs/IApiView;", "Lcom/android/ttcjpaysdk/base/framework/container/view/components/ErrorPageUiInfo;", "hideButtonLoading", "", "setBgColor", "color", "", "showButtonLoading", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface IErrorPageApiView extends IApiView<ErrorPageUiInfo> {

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class DefaultImpls {
        public static Theme getTheme(IErrorPageApiView r100) {
            return IApiView.DefaultImpls.getTheme(r100);
        }

        public static void setTheme(IErrorPageApiView r100, Theme r101) {
            Intrinsics.checkNotNullParameter(r101, "theme");
            IApiView.DefaultImpls.setTheme(r100, r101);
        }
    }

    void hideButtonLoading();

    void setBgColor(int r100);

    void showButtonLoading();
}
