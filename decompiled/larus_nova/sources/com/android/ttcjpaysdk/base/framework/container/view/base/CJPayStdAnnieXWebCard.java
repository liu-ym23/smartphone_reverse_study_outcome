package com.android.ttcjpaysdk.base.framework.container.view.base;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import com.android.ttcjpaysdk.base.framework.container.abs.Theme;
import com.android.ttcjpaysdk.base.framework.container.view.base.abs.HybridViewController;
import com.android.ttcjpaysdk.base.framework.container.view.base.abs.IViewUiInfo;
import com.android.ttcjpaysdk.base.ui.widget.CJAnnieXWebCard;
import com.bytedance.android.ecom.arch.slice.render.SlcElement;
import com.bytedance.ee.bear.lynx.impl.xbridge.method.view.SendEventContainerMethodParamModel;
import com.ss.android.lark.utils.statistics.PerfLog;
import ed4.f;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002:\u0001&B\u0011\b\u0016\u0012\u0006\u0010 \u001a\u00020\u001f¢\u0006\u0004\b!\u0010\"B\u001b\b\u0016\u0012\u0006\u0010 \u001a\u00020\u001f\u0012\b\u0010$\u001a\u0004\u0018\u00010#¢\u0006\u0004\b!\u0010%J\u001a\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016J\u0010\u0010\u000b\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tH\u0016J\b\u0010\f\u001a\u00020\u0007H\u0016J\b\u0010\r\u001a\u00020\u0007H\u0016J\b\u0010\u000e\u001a\u00020\u0007H\u0016J\u0010\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u000fH\u0016J\b\u0010\u0011\u001a\u00020\u000fH\u0016J\u001e\u0010\u0015\u001a\u00020\u00072\u0014\u0010\u0014\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u0012H\u0016J\u0010\u0010\u0018\u001a\u00020\u00072\u0006\u0010\u0017\u001a\u00020\u0016H\u0016J\u0012\u0010\u001b\u001a\u00020\u00072\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019H\u0016J\u0016\u0010\u001e\u001a\u00020\u00072\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00070\u001cH\u0016¨\u0006'"}, d2 = {"Lcom/android/ttcjpaysdk/base/framework/container/view/base/CJPayStdAnnieXWebCard;", "Lcom/android/ttcjpaysdk/base/ui/widget/CJAnnieXWebCard;", "Lcom/android/ttcjpaysdk/base/framework/container/view/base/IWebApiView;", "", "eventName", "Lorg/json/JSONObject;", "params", "", "sendJsEvent", "Lcom/android/ttcjpaysdk/base/ui/widget/CJAnnieXWebCard$ICJAnnieXCardView;", "webCardView", "setViewConfig", "startLoad", "onViewShow", "onViewHide", "", "useBulletCardView", "isViewPreRender", "", "", SlcElement.KEY_PROPS, "setViewWindowProps", "Led4/f;", "delegate", "addViewScrollDelegate", "Lcom/android/ttcjpaysdk/base/framework/container/view/base/WebUiInfo;", "viewUIInfo", "refresh", "Lkotlin/Function0;", SendEventContainerMethodParamModel.EventKinds.onClick, "setClickListener", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "WebViewController", "base-context_release"}, k = 1, mv = {1, 6, 0})
public final class CJPayStdAnnieXWebCard extends CJAnnieXWebCard implements IWebApiView {

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u000f\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0002¢\u0006\u0002\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/android/ttcjpaysdk/base/framework/container/view/base/CJPayStdAnnieXWebCard$WebViewController;", "Lcom/android/ttcjpaysdk/base/framework/container/view/base/abs/HybridViewController;", "Lcom/android/ttcjpaysdk/base/framework/container/view/base/WebUiInfo;", "Lcom/android/ttcjpaysdk/base/framework/container/view/base/IWebApiView;", "webUiInfo", "(Lcom/android/ttcjpaysdk/base/framework/container/view/base/WebUiInfo;)V", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class WebViewController extends HybridViewController<WebUiInfo, IWebApiView> {
        /* JADX WARN: Multi-variable type inference failed */
        public WebViewController() {
            this(null, 1, 0 == true ? 1 : 0);
        }

        public WebViewController(WebUiInfo r100) {
            Intrinsics.checkNotNullParameter(r100, "webUiInfo");
            super(r100);
        }

        public /* synthetic */ WebViewController(WebUiInfo r100, int r101, DefaultConstructorMarker r102) {
            if ((r101 & 1) == 0) goto L5;
            r100 = new WebUiInfo(null, 1, null);
        L5:
            this(r100);
        }
    }

    @Override // com.android.ttcjpaysdk.base.framework.container.view.base.abs.IApiView
    public void setClickListener(Function0<Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, SendEventContainerMethodParamModel.EventKinds.onClick);
    }

    @Override // com.android.ttcjpaysdk.base.framework.container.abs.ITheme
    public Theme getTheme() {
        return IWebApiView.DefaultImpls.getTheme(this);
    }

    @Override // com.android.ttcjpaysdk.base.framework.container.view.base.IWebApiView
    public boolean isViewPreRender() {
        return isPreRender();
    }

    @Override // com.android.ttcjpaysdk.base.framework.container.view.base.abs.HybridViewController.IHybridApiView
    public void onViewHide() {
        onHide();
    }

    @Override // com.android.ttcjpaysdk.base.framework.container.view.base.abs.HybridViewController.IHybridApiView
    public void onViewShow() {
        onShow();
    }

    @Override // com.android.ttcjpaysdk.base.framework.container.view.base.abs.HybridViewController.IHybridApiView
    public void startLoad() {
        load();
    }

    public CJPayStdAnnieXWebCard(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
    }

    @Override // com.android.ttcjpaysdk.base.framework.container.view.base.IWebApiView
    public void addViewScrollDelegate(f r100) {
        Intrinsics.checkNotNullParameter(r100, "delegate");
        addWebViewScrollDelegate(r100);
    }

    public void refresh(WebUiInfo r100) {
        if (r100 == null) goto L7;
        ViewGroup.LayoutParams r101 = getLayoutParams();
        if (r101 == null) goto L8;
        r101.width = r100.getBaseViewUiInfo().getWidth();
        r101.height = r100.getBaseViewUiInfo().getHeight();
        setLayoutParams(r101);
        return;
    L8:
        return;
    }

    @Override // com.android.ttcjpaysdk.base.framework.container.abs.ITheme
    public void setTheme(Theme r100) {
        IWebApiView.DefaultImpls.setTheme(this, r100);
    }

    @Override // com.android.ttcjpaysdk.base.framework.container.view.base.IWebApiView
    public IWebApiView setViewConfig(CJAnnieXWebCard.ICJAnnieXCardView r100) {
        Intrinsics.checkNotNullParameter(r100, "webCardView");
        setConfig(r100);
        return this;
    }

    @Override // com.android.ttcjpaysdk.base.framework.container.view.base.IWebApiView
    public void setViewWindowProps(Map<String, ? extends Object> r100) {
        setWindowProps(r100);
    }

    @Override // com.android.ttcjpaysdk.base.framework.container.view.base.IWebApiView
    public void useBulletCardView(boolean r100) {
        useBulletCard(r100);
    }

    @Override // com.android.ttcjpaysdk.base.framework.container.view.base.abs.IApiView
    public /* bridge */ /* synthetic */ void refresh(IViewUiInfo r100) {
        refresh((WebUiInfo) r100);
    }

    public CJPayStdAnnieXWebCard(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
    }

    @Override // com.android.ttcjpaysdk.base.framework.container.view.base.abs.HybridViewController.IHybridApiView
    public void sendJsEvent(String r100, JSONObject r101) {
        Intrinsics.checkNotNullParameter(r100, "eventName");
        sendEvent(r100, r101);
    }
}
