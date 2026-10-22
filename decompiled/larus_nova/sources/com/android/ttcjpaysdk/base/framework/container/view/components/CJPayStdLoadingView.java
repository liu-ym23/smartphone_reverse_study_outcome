package com.android.ttcjpaysdk.base.framework.container.view.components;

import android.content.Context;
import android.os.CountDownTimer;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.android.ttcjpaysdk.base.framework.container.abs.ITheme;
import com.android.ttcjpaysdk.base.framework.container.abs.Theme;
import com.android.ttcjpaysdk.base.framework.container.view.base.abs.AbsBaseViewController;
import com.android.ttcjpaysdk.base.framework.container.view.base.abs.IViewUiInfo;
import com.android.ttcjpaysdk.base.framework.container.view.components.abs.AbsStdComponent;
import com.android.ttcjpaysdk.base.ui.component.pop.CJImageView;
import com.android.ttcjpaysdk.base.ui.widget.CJPayTextLoadingView;
import com.bytedance.ee.bear.lynx.impl.xbridge.method.view.SendEventContainerMethodParamModel;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003:\u0001%B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u0015\u001a\u00020\u0016H\u0016J\b\u0010\u0017\u001a\u00020\u0018H\u0016J\b\u0010\u0019\u001a\u00020\u0016H\u0016J\u0012\u0010\u001a\u001a\u00020\u00162\b\u0010\u001b\u001a\u0004\u0018\u00010\u0014H\u0016J\u0016\u0010\u001c\u001a\u00020\u00162\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00160\u001eH\u0016J\u0016\u0010\u001f\u001a\u00020\u00162\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\"0!H\u0016J\b\u0010#\u001a\u00020\u0016H\u0016J\b\u0010$\u001a\u00020\u0016H\u0016R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u000b\u001a\u00020\f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\r\u0010\u000eR\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006&"}, d2 = {"Lcom/android/ttcjpaysdk/base/framework/container/view/components/CJPayStdLoadingView;", "Lcom/android/ttcjpaysdk/base/framework/container/view/components/abs/AbsStdComponent;", "Lcom/android/ttcjpaysdk/base/framework/container/view/components/ILoadingViewApiView;", "Lcom/android/ttcjpaysdk/base/framework/container/abs/ITheme;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "(Landroid/content/Context;)V", "loadingRootView", "Landroid/widget/FrameLayout;", "sweepImageContainer", "Landroid/widget/LinearLayout;", "textLoadingView", "Lcom/android/ttcjpaysdk/base/ui/widget/CJPayTextLoadingView;", "getTextLoadingView", "()Lcom/android/ttcjpaysdk/base/ui/widget/CJPayTextLoadingView;", "textLoadingView$delegate", "Lkotlin/Lazy;", "timeoutTask", "Landroid/os/CountDownTimer;", "uiInfo", "Lcom/android/ttcjpaysdk/base/framework/container/view/components/LoadingViewUiInfo;", "bindView", "", "getLayoutId", "", "hideLoading", "refresh", "viewUIInfo", "setClickListener", SendEventContainerMethodParamModel.EventKinds.onClick, "Lkotlin/Function0;", "setSweepImageConfigs", "sweepImageConfig", "", "Lcom/android/ttcjpaysdk/base/framework/container/view/components/SweepImageConfig;", "showSweepLoading", "showTextLoading", "LoadingViewController", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CJPayStdLoadingView extends AbsStdComponent implements ILoadingViewApiView, ITheme {
    private FrameLayout loadingRootView;
    private LinearLayout sweepImageContainer;
    private final Lazy textLoadingView$delegate;
    private CountDownTimer timeoutTask;
    private LoadingViewUiInfo uiInfo;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u000f\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0002¢\u0006\u0002\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/android/ttcjpaysdk/base/framework/container/view/components/CJPayStdLoadingView$LoadingViewController;", "Lcom/android/ttcjpaysdk/base/framework/container/view/base/abs/AbsBaseViewController;", "Lcom/android/ttcjpaysdk/base/framework/container/view/components/LoadingViewUiInfo;", "Lcom/android/ttcjpaysdk/base/framework/container/view/components/ILoadingViewApiView;", "loadingViewUiInfo", "(Lcom/android/ttcjpaysdk/base/framework/container/view/components/LoadingViewUiInfo;)V", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class LoadingViewController extends AbsBaseViewController<LoadingViewUiInfo, ILoadingViewApiView> {
        /* JADX WARN: Multi-variable type inference failed */
        public LoadingViewController() {
            this(null, 1, 0 == true ? 1 : 0);
        }

        public LoadingViewController(LoadingViewUiInfo r100) {
            Intrinsics.checkNotNullParameter(r100, "loadingViewUiInfo");
            super(r100);
        }

        public /* synthetic */ LoadingViewController(LoadingViewUiInfo r100, int r101, DefaultConstructorMarker r110) {
            if ((r101 & 1) == 0) goto L5;
            r100 = new LoadingViewUiInfo(null, 0, false, 7, null);
        L5:
            this(r100);
        }
    }

    @Override // com.android.ttcjpaysdk.base.framework.container.view.components.abs.IBaseComponent
    public int getLayoutId() {
        return R.layout.cj_pay_std_loading_view_layout;
    }

    @Override // com.android.ttcjpaysdk.base.framework.container.view.base.abs.IApiView
    public void setClickListener(Function0<Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, SendEventContainerMethodParamModel.EventKinds.onClick);
    }

    private final CJPayTextLoadingView getTextLoadingView() {
        return (CJPayTextLoadingView) this.textLoadingView$delegate.getValue();
    }

    @Override // com.android.ttcjpaysdk.base.framework.container.view.components.ILoadingViewApiView
    public void hideLoading() {
        CountDownTimer r100 = this.timeoutTask;
        if (r100 == null) goto L5;
        r100.cancel();
    L5:
        getTextLoadingView().setVisibility(8);
        getTextLoadingView().hide();
        LinearLayout r101 = this.sweepImageContainer;
        if (r101 == null) goto L10;
        r101.setVisibility(8);
        return;
    }

    @Override // com.android.ttcjpaysdk.base.framework.container.view.components.ILoadingViewApiView
    public void showSweepLoading() {
        CountDownTimer r100 = this.timeoutTask;
        if (r100 == null) goto L5;
        r100.cancel();
    L5:
        CountDownTimer r101 = this.timeoutTask;
        if (r101 == null) goto L8;
        r101.start();
    L8:
        LinearLayout r102 = this.sweepImageContainer;
        if (r102 == null) goto L13;
        r102.setVisibility(0);
        return;
    }

    @Override // com.android.ttcjpaysdk.base.framework.container.view.components.ILoadingViewApiView
    public void showTextLoading() {
        CountDownTimer r100 = this.timeoutTask;
        if (r100 == null) goto L5;
        r100.cancel();
    L5:
        CountDownTimer r101 = this.timeoutTask;
        if (r101 == null) goto L8;
        r101.start();
    L8:
        getTextLoadingView().setVisibility(0);
        CJPayTextLoadingView r102 = getTextLoadingView();
        LoadingViewUiInfo r103 = this.uiInfo;
        if (r103 == null) goto L11;
        Boolean r104 = Boolean.valueOf(r103.getShowLoadingTextAndBg());
    L12:
        if (r104 == null) goto L14;
        boolean r105 = r104.booleanValue();
    L15:
        r102.show(r105);
        return;
    L14:
        r105 = true;
        goto L15
    L11:
        r104 = null;
        goto L12
    }

    @Override // com.android.ttcjpaysdk.base.framework.container.view.components.abs.AbsStdComponent
    public void bindView() {
        this.loadingRootView = (FrameLayout) findViewById(R.id.cj_pay_std_loading_root_view);
        this.sweepImageContainer = (LinearLayout) findViewById(R.id.cj_pay_sweep_image_view_container);
    }

    @Override // com.android.ttcjpaysdk.base.framework.container.abs.ITheme
    public Theme getTheme() {
        return ILoadingViewApiView.DefaultImpls.getTheme(this);
    }

    public CJPayStdLoadingView(final Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
        this.textLoadingView$delegate = LazyKt.lazy(new CJPayStdLoadingView$textLoadingView$2(r100, this));
    }

    public static final /* synthetic */ FrameLayout access$getLoadingRootView$p(CJPayStdLoadingView r100) {
        return r100.loadingRootView;
    }

    public void refresh(LoadingViewUiInfo r100) {
        if (r100 != null) goto L5;
        return;
    L5:
        if (Intrinsics.areEqual(r100, this.uiInfo) == true) goto L13;
        this.uiInfo = r100;
        if (r100.getTimeout() <= 0) goto L14;
        CountDownTimer r101 = this.timeoutTask;
        if (r101 == null) goto L11;
        r101.cancel();
    L11:
        final long r102 = r100.getTimeout();
        final long r103 = r100.getTimeout();
        this.timeoutTask = new AnonymousClass1(this, r102, r103);
        return;
    L14:
        return;
    }

    @Override // com.android.ttcjpaysdk.base.framework.container.view.components.ILoadingViewApiView
    public void setSweepImageConfigs(List<SweepImageConfig> r100) {
        Intrinsics.checkNotNullParameter(r100, "sweepImageConfig");
        LinearLayout r101 = this.sweepImageContainer;
        if (r101 == null) goto L5;
        r101.removeAllViews();
    L5:
        Iterator<T> r102 = r100.iterator();
    L7:
        if (r102.hasNext() == false) goto L13;
        CJImageView r103 = ((SweepImageConfig) r102.next()).createImageView(getContext());
        if (r103 == null) goto L7;
        LinearLayout r104 = this.sweepImageContainer;
        if (r104 == null) goto L7;
        r104.addView(r103);
        goto L7
    }

    @Override // com.android.ttcjpaysdk.base.framework.container.abs.ITheme
    public void setTheme(Theme r100) {
        ILoadingViewApiView.DefaultImpls.setTheme(this, r100);
    }

    @Override // com.android.ttcjpaysdk.base.framework.container.view.base.abs.IApiView
    public /* bridge */ /* synthetic */ void refresh(IViewUiInfo r100) {
        refresh((LoadingViewUiInfo) r100);
    }
}
