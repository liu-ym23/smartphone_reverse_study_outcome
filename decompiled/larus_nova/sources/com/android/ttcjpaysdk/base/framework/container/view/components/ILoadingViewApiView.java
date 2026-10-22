package com.android.ttcjpaysdk.base.framework.container.view.components;

import com.android.ttcjpaysdk.base.framework.container.abs.Theme;
import com.android.ttcjpaysdk.base.framework.container.view.base.abs.IApiView;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0004H&J\u0016\u0010\u0005\u001a\u00020\u00042\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H&J\b\u0010\t\u001a\u00020\u0004H&J\b\u0010\n\u001a\u00020\u0004H&¨\u0006\u000b"}, d2 = {"Lcom/android/ttcjpaysdk/base/framework/container/view/components/ILoadingViewApiView;", "Lcom/android/ttcjpaysdk/base/framework/container/view/base/abs/IApiView;", "Lcom/android/ttcjpaysdk/base/framework/container/view/components/LoadingViewUiInfo;", "hideLoading", "", "setSweepImageConfigs", "sweepImageConfig", "", "Lcom/android/ttcjpaysdk/base/framework/container/view/components/SweepImageConfig;", "showSweepLoading", "showTextLoading", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface ILoadingViewApiView extends IApiView<LoadingViewUiInfo> {

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class DefaultImpls {
        public static Theme getTheme(ILoadingViewApiView r100) {
            return IApiView.DefaultImpls.getTheme(r100);
        }

        public static void setTheme(ILoadingViewApiView r100, Theme r101) {
            Intrinsics.checkNotNullParameter(r101, "theme");
            IApiView.DefaultImpls.setTheme(r100, r101);
        }
    }

    void hideLoading();

    void setSweepImageConfigs(List<SweepImageConfig> r100);

    void showSweepLoading();

    void showTextLoading();
}
