package com.android.ttcjpaysdk.base.framework.container.view.base;

import com.android.ttcjpaysdk.base.framework.container.abs.Theme;
import com.android.ttcjpaysdk.base.framework.container.view.base.abs.HybridViewController;
import com.android.ttcjpaysdk.base.ui.widget.CJAnnieXCard;
import jd4.a;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J0\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\u0006H&J\u0010\u0010\n\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\fH&¨\u0006\r"}, d2 = {"Lcom/android/ttcjpaysdk/base/framework/container/view/base/ILynxApiView;", "Lcom/android/ttcjpaysdk/base/framework/container/view/base/abs/HybridViewController$IHybridApiView;", "Lcom/android/ttcjpaysdk/base/framework/container/view/base/LynxUiInfo;", "setMarginParams", "", "left", "", "top", "right", "bottom", "setViewConfig", "webCardView", "Lcom/android/ttcjpaysdk/base/ui/widget/CJAnnieXCard$ICJAnnieXCardView;", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface ILynxApiView extends HybridViewController.IHybridApiView<LynxUiInfo> {

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class DefaultImpls {
        public static Theme getTheme(ILynxApiView r100) {
            return HybridViewController.IHybridApiView.DefaultImpls.getTheme(r100);
        }

        public static void setTheme(ILynxApiView r100, Theme r101) {
            Intrinsics.checkNotNullParameter(r101, "theme");
            HybridViewController.IHybridApiView.DefaultImpls.setTheme(r100, r101);
        }

        public static /* synthetic */ void setMarginParams$default(ILynxApiView r100, int r101, int r102, int r103, int r104, int r105, Object r106) {
            if (r106 != null) goto L18;
            if ((r105 & 1) == 0) goto L7;
            r101 = 0;
        L7:
            if ((r105 & 2) == 0) goto L10;
            r102 = 0;
        L10:
            if ((r105 & 4) == 0) goto L13;
            r103 = 0;
        L13:
            if ((r105 & 8) == 0) goto L15;
            r104 = 0;
        L15:
            r100.setMarginParams(r101, r102, r103, r104);
            return;
        L18:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setMarginParams");
        }
    }

    @Override // com.android.ttcjpaysdk.base.framework.container.view.base.abs.HybridViewController.IHybridApiView, id4.c
    /* synthetic */ <T extends a> T getCtx(Class<T> r100);

    @Override // com.android.ttcjpaysdk.base.framework.container.view.base.abs.HybridViewController.IHybridApiView, id4.c
    /* synthetic */ <T extends a> void putCtx(Class<T> r100, T r101);

    @Override // com.android.ttcjpaysdk.base.framework.container.view.base.abs.HybridViewController.IHybridApiView, id4.c
    /* synthetic */ <T extends a> void removeCtx(Class<T> r100);

    void setMarginParams(int r100, int r101, int r102, int r103);

    ILynxApiView setViewConfig(CJAnnieXCard.ICJAnnieXCardView r100);
}
