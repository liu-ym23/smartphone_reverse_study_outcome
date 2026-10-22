package com.android.ttcjpaysdk.base.framework.container.view.base;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.android.ttcjpaysdk.base.framework.container.view.base.abs.BaseViewUiInfo;
import com.android.ttcjpaysdk.base.framework.container.view.base.abs.IApiView;
import com.android.ttcjpaysdk.base.framework.container.view.base.abs.IViewController;
import com.android.ttcjpaysdk.base.framework.container.view.base.abs.IViewUiInfo;
import com.android.ttcjpaysdk.base.ktextension.CJPayBasicExtensionKt;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\u0017\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0002¢\u0006\u0002\u0010\u0015J\b\u0010\u0016\u001a\u0004\u0018\u00010\tJ(\u0010\u0017\u001a\u00020\u00182 \u0010\n\u001a\u001c\u0012\u0006\b\u0001\u0012\u00020\f\u0012\u000e\b\u0001\u0012\n\u0012\u0006\b\u0001\u0012\u00020\f0\r\u0018\u00010\u000bR\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R(\u0010\n\u001a\u001c\u0012\u0006\b\u0001\u0012\u00020\f\u0012\u000e\b\u0001\u0012\n\u0012\u0006\b\u0001\u0012\u00020\f0\r\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u000e\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0019"}, d2 = {"Lcom/android/ttcjpaysdk/base/framework/container/view/base/CJPayAnyView;", "Landroid/widget/FrameLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "view", "Landroid/view/View;", "viewConfig", "Lcom/android/ttcjpaysdk/base/framework/container/view/base/abs/IViewController;", "Lcom/android/ttcjpaysdk/base/framework/container/view/base/abs/IViewUiInfo;", "Lcom/android/ttcjpaysdk/base/framework/container/view/base/abs/IApiView;", "viewFactory", "Lcom/android/ttcjpaysdk/base/framework/container/view/base/CJPayStdViewFactory;", "getViewFactory", "()Lcom/android/ttcjpaysdk/base/framework/container/view/base/CJPayStdViewFactory;", "getLayoutParamsValue", "", "value", "(Ljava/lang/Integer;)I", "getRealView", "setViewConfig", "", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CJPayAnyView extends FrameLayout {
    private View view;
    private IViewController<? extends IViewUiInfo, ? extends IApiView<? extends IViewUiInfo>> viewConfig;
    private final CJPayStdViewFactory viewFactory;

    public final View getRealView() {
        return this.view;
    }

    public final CJPayStdViewFactory getViewFactory() {
        return this.viewFactory;
    }

    public CJPayAnyView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
        this.viewFactory = new CJPayStdViewFactory(getContext());
    }

    private final int getLayoutParamsValue(Integer r100) {
        if (r100 != null) goto L6;
        return -2;
    L6:
        if (r100.intValue() >= 0) goto L10;
        return r100.intValue();
    L10:
        return CJPayBasicExtensionKt.dip2px(r100.intValue(), getContext());
    }

    public final void setViewConfig(IViewController<? extends IViewUiInfo, ? extends IApiView<? extends IViewUiInfo>> r100) {
        if (this.view != null) goto L5;
    L7:
        Integer r101 = null;
        if (r100 != null) goto L11;
        this.view = null;
        this.viewConfig = null;
        setVisibility(8);
        return;
    L11:
        View r102 = this.viewFactory.provideView(r100);
        if (r102 == null) goto L35;
        View r103 = this.view;
        if (r103 == null) goto L16;
        removeView(r103);
    L16:
        this.view = r102;
        IViewUiInfo r104 = r100.getViewUiInfo();
        if (r104 == null) goto L21;
        BaseViewUiInfo r105 = r104.getBaseUiInfo();
        if (r105 == null) goto L21;
        Integer r106 = Integer.valueOf(r105.getWidth());
    L22:
        int r107 = getLayoutParamsValue(r106);
        IViewUiInfo r108 = r100.getViewUiInfo();
        if (r108 == null) goto L27;
        BaseViewUiInfo r109 = r108.getBaseUiInfo();
        if (r109 == null) goto L27;
        r101 = Integer.valueOf(r109.getHeight());
    L27:
        FrameLayout.LayoutParams r110 = new FrameLayout.LayoutParams(r107, getLayoutParamsValue(r101));
        IViewUiInfo r111 = r100.getViewUiInfo();
        if (r111 == null) goto L32;
        BaseViewUiInfo r112 = r111.getBaseUiInfo();
        if (r112 == null) goto L32;
        int r113 = r112.getGravity();
    L33:
        r110.gravity = r113;
        Unit r114 = Unit.INSTANCE;
        addView(r102, r110);
        return;
    L32:
        r113 = 17;
    L21:
        r106 = null;
        goto L22
    L35:
        return;
    L5:
        if (this.viewConfig == null) goto L7;
    }

    public CJPayAnyView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
        this.viewFactory = new CJPayStdViewFactory(getContext());
    }
}
