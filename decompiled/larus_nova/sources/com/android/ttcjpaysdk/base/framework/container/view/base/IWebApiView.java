package com.android.ttcjpaysdk.base.framework.container.view.base;

import com.android.ttcjpaysdk.base.framework.container.abs.Theme;
import com.android.ttcjpaysdk.base.framework.container.view.base.abs.HybridViewController;
import com.android.ttcjpaysdk.base.ui.widget.CJAnnieXWebCard;
import com.bytedance.android.ecom.arch.slice.render.SlcElement;
import ed4.f;
import java.util.Map;
import jd4.a;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u0003H&J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H&J\b\u0010\t\u001a\u00020\u0006H&J\u001e\u0010\u000e\u001a\u00020\b2\u0014\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f\u0018\u00010\nH&J\u0010\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u000fH&¨\u0006\u0012"}, d2 = {"Lcom/android/ttcjpaysdk/base/framework/container/view/base/IWebApiView;", "Lcom/android/ttcjpaysdk/base/framework/container/view/base/abs/HybridViewController$IHybridApiView;", "Lcom/android/ttcjpaysdk/base/framework/container/view/base/WebUiInfo;", "Lcom/android/ttcjpaysdk/base/ui/widget/CJAnnieXWebCard$ICJAnnieXCardView;", "webCardView", "setViewConfig", "", "useBulletCardView", "", "isViewPreRender", "", "", "", SlcElement.KEY_PROPS, "setViewWindowProps", "Led4/f;", "delegate", "addViewScrollDelegate", "base-context_release"}, k = 1, mv = {1, 6, 0})
public interface IWebApiView extends HybridViewController.IHybridApiView<WebUiInfo> {

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class DefaultImpls {
        public static Theme getTheme(IWebApiView r100) {
            return HybridViewController.IHybridApiView.DefaultImpls.getTheme(r100);
        }

        public static void setTheme(IWebApiView r100, Theme r101) {
            Intrinsics.checkNotNullParameter(r101, "theme");
            HybridViewController.IHybridApiView.DefaultImpls.setTheme(r100, r101);
        }
    }

    void addViewScrollDelegate(f r100);

    @Override // com.android.ttcjpaysdk.base.framework.container.view.base.abs.HybridViewController.IHybridApiView, id4.c
    /* synthetic */ <T extends a> T getCtx(Class<T> r100);

    boolean isViewPreRender();

    @Override // com.android.ttcjpaysdk.base.framework.container.view.base.abs.HybridViewController.IHybridApiView, id4.c
    /* synthetic */ <T extends a> void putCtx(Class<T> r100, T r101);

    @Override // com.android.ttcjpaysdk.base.framework.container.view.base.abs.HybridViewController.IHybridApiView, id4.c
    /* synthetic */ <T extends a> void removeCtx(Class<T> r100);

    IWebApiView setViewConfig(CJAnnieXWebCard.ICJAnnieXCardView r100);

    void setViewWindowProps(Map<String, ? extends Object> r100);

    void useBulletCardView(boolean r100);
}
