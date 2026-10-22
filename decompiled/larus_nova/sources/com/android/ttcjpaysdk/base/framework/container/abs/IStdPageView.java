package com.android.ttcjpaysdk.base.framework.container.abs;

import android.view.View;
import com.android.ttcjpaysdk.base.framework.container.view.components.abs.IErrorPageView;
import com.android.ttcjpaysdk.base.framework.container.view.components.abs.ITitleBarView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\bf\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003J\u0012\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&J\b\u0010\b\u001a\u00020\u0005H&J\b\u0010\t\u001a\u00020\u0005H&J\b\u0010\n\u001a\u00020\u0005H&J\b\u0010\u000b\u001a\u00020\u0005H&J\b\u0010\f\u001a\u00020\u0005H&J\b\u0010\r\u001a\u00020\u0005H&¨\u0006\u000e"}, d2 = {"Lcom/android/ttcjpaysdk/base/framework/container/abs/IStdPageView;", "Lcom/android/ttcjpaysdk/base/framework/container/view/components/abs/ITitleBarView;", "Lcom/android/ttcjpaysdk/base/framework/container/view/components/abs/IErrorPageView;", "Lcom/android/ttcjpaysdk/base/framework/container/abs/ITheme;", "addContentView", "", "contentView", "Landroid/view/View;", "hideErrorView", "onErrorViewBtnClicked", "onErrorViewTextLinkClicked", "onTitleLeftViewClicked", "onTitleRightViewClicked", "showErrorView", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface IStdPageView extends ITitleBarView, IErrorPageView, ITheme {

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class DefaultImpls {
        public static Theme getTheme(IStdPageView r100) {
            return ITheme.DefaultImpls.getTheme(r100);
        }

        public static void setTheme(IStdPageView r100, Theme r101) {
            Intrinsics.checkNotNullParameter(r101, "theme");
            ITheme.DefaultImpls.setTheme(r100, r101);
        }
    }

    void addContentView(View r100);

    void hideErrorView();

    void onErrorViewBtnClicked();

    void onErrorViewTextLinkClicked();

    void onTitleLeftViewClicked();

    void onTitleRightViewClicked();

    void showErrorView();
}
