package com.android.ttcjpaysdk.base.framework.container.view.base;

import android.content.Context;
import android.view.View;
import com.android.ttcjpaysdk.base.framework.container.view.base.abs.IApiView;
import com.android.ttcjpaysdk.base.framework.container.view.base.abs.IViewController;
import com.android.ttcjpaysdk.base.framework.container.view.base.abs.IViewUiInfo;
import com.android.ttcjpaysdk.base.framework.container.view.components.CJPayStdErrorPage;
import com.android.ttcjpaysdk.base.framework.container.view.components.CJPayStdLoadingView;
import com.android.ttcjpaysdk.base.framework.container.view.components.CJPayStdTitleBar;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J(\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u001e\u0010\u0007\u001a\u001a\u0012\u0006\b\u0001\u0012\u00020\t\u0012\u000e\b\u0001\u0012\n\u0012\u0006\b\u0001\u0012\u00020\t0\n0\bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/android/ttcjpaysdk/base/framework/container/view/base/CJPayStdViewFactory;", "", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "(Landroid/content/Context;)V", "provideView", "Landroid/view/View;", "viewConfig", "Lcom/android/ttcjpaysdk/base/framework/container/view/base/abs/IViewController;", "Lcom/android/ttcjpaysdk/base/framework/container/view/base/abs/IViewUiInfo;", "Lcom/android/ttcjpaysdk/base/framework/container/view/base/abs/IApiView;", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CJPayStdViewFactory {
    private final Context context;

    public CJPayStdViewFactory(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.context = r100;
    }

    public final View provideView(IViewController<? extends IViewUiInfo, ? extends IApiView<? extends IViewUiInfo>> r100) {
        Intrinsics.checkNotNullParameter(r100, "viewConfig");
        if ((r100 instanceof CJPayStdTextView.TextViewController) == false) goto L6;
        View r101 = new CJPayStdTextView(this.context);
        ((CJPayStdTextView.TextViewController) r100).attachApiView(r101);
    L24:
        if (r101 == null) goto L26;
        return r101;
    L26:
        return r100.getView(this.context);
    L6:
        if ((r100 instanceof CJPayStdTitleBar.TitleBarController) == false) goto L9;
        r101 = new CJPayStdTitleBar(this.context);
        ((CJPayStdTitleBar.TitleBarController) r100).attachApiView(r101);
        goto L24
    L9:
        if ((r100 instanceof CJPayStdImgView.ImgViewController) == false) goto L12;
        r101 = new CJPayStdImgView(this.context);
        ((CJPayStdImgView.ImgViewController) r100).attachApiView(r101);
        goto L24
    L12:
        if ((r100 instanceof CJPayStdAnnieXView.LynxViewController) == false) goto L15;
        r101 = new CJPayStdAnnieXView(this.context);
        ((CJPayStdAnnieXView.LynxViewController) r100).attachApiView(r101);
        goto L24
    L15:
        if ((r100 instanceof CJPayStdAnnieXWebCard.WebViewController) == false) goto L18;
        r101 = new CJPayStdAnnieXWebCard(this.context);
        ((CJPayStdAnnieXWebCard.WebViewController) r100).attachApiView(r101);
        goto L24
    L18:
        if ((r100 instanceof CJPayStdErrorPage.ErrorPageController) == false) goto L21;
        r101 = new CJPayStdErrorPage(this.context);
        ((CJPayStdErrorPage.ErrorPageController) r100).attachApiView(r101);
        goto L24
    L21:
        if ((r100 instanceof CJPayStdLoadingView.LoadingViewController) == false) goto L23;
        r101 = new CJPayStdLoadingView(this.context);
        ((CJPayStdLoadingView.LoadingViewController) r100).attachApiView(r101);
        goto L24
    L23:
        r101 = null;
        goto L24
    }
}
