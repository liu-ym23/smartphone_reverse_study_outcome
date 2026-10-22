package com.android.ttcjpaysdk.integrated.sign.counter.activity.scene;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.android.ttcjpaysdk.base.CJPayCallBackCenter;
import com.android.ttcjpaysdk.base.CJPayHostInfo;
import com.android.ttcjpaysdk.base.eventbus.BaseEvent;
import com.android.ttcjpaysdk.base.framework.CJPayActivityManager;
import com.android.ttcjpaysdk.base.framework.event.CJPayFinishAllSingleFragmentActivityEvent;
import com.android.ttcjpaysdk.base.framework.manager.CJPayFragmentManager;
import com.android.ttcjpaysdk.base.ktextension.CJPayKotlinExtensionsKt;
import com.android.ttcjpaysdk.base.ui.widget.CJPayTextLoadingView;
import com.android.ttcjpaysdk.base.utils.CJPayAnimationUtils;
import com.android.ttcjpaysdk.base.utils.CJPayBasicUtils;
import com.android.ttcjpaysdk.bindcard.base.constants.BindCardPayConfirmConstants;
import com.android.ttcjpaysdk.integrated.sign.counter.activity.ISignCounterHost;
import com.android.ttcjpaysdk.integrated.sign.counter.activity.ISignCounterSceneHandler;
import com.android.ttcjpaysdk.integrated.sign.counter.activity.SignCounterLaunchArgs;
import com.android.ttcjpaysdk.integrated.sign.counter.activity.scene.integratedsign.IntegratedSignSceneState;
import com.android.ttcjpaysdk.integrated.sign.counter.data.SignCreateResponse;
import com.android.ttcjpaysdk.integrated.sign.counter.fragment.SignConfirmFragment;
import com.android.ttcjpaysdk.integrated.sign.counter.model.SignBaseModel;
import com.android.ttcjpaysdk.integrated.sign.counter.presenter.SignPresenter;
import com.android.ttcjpaysdk.integrated.sign.counter.provider.IntegratedSignCounterProvider;
import com.android.ttcjpaysdk.integrated.sign.counter.view.SignView;
import com.android.ttcjpaysdk.thirdparty.front.counter.unifypay.preverify.vm.UnifyPreVerifyRiskSmsVM;
import com.bytedance.android.livesdkapi.LiveCommonConstants;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.larus.nova.R;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u0015\u001a\u00020\u0016H\u0002J\n\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016J\b\u0010\u0019\u001a\u00020\u001aH\u0016J\u0018\u0010\u001b\u001a\u00020\u00162\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u001c\u001a\u00020\u001dH\u0016J\b\u0010\u001e\u001a\u00020\u0016H\u0016J\u0010\u0010\u001f\u001a\u00020\u00162\u0006\u0010 \u001a\u00020!H\u0016J\u0010\u0010\"\u001a\u00020\u00162\u0006\u0010\u001c\u001a\u00020\u001dH\u0016J\b\u0010#\u001a\u00020\u0016H\u0016J\u0012\u0010$\u001a\u00020\u00162\b\u0010%\u001a\u0004\u0018\u00010&H\u0016J\u0012\u0010'\u001a\u00020\u00162\b\u0010(\u001a\u0004\u0018\u00010)H\u0016J\b\u0010*\u001a\u00020\u0016H\u0002J\b\u0010+\u001a\u00020\u0016H\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0006\u001a\u00020\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006,"}, d2 = {"Lcom/android/ttcjpaysdk/integrated/sign/counter/activity/scene/IntegratedSignSceneHandler;", "Lcom/android/ttcjpaysdk/integrated/sign/counter/activity/ISignCounterSceneHandler;", "Lcom/android/ttcjpaysdk/integrated/sign/counter/view/SignView;", "()V", "activityRootView", "Landroid/view/View;", "confirmFragment", "Lcom/android/ttcjpaysdk/integrated/sign/counter/fragment/SignConfirmFragment;", "getConfirmFragment", "()Lcom/android/ttcjpaysdk/integrated/sign/counter/fragment/SignConfirmFragment;", "confirmFragment$delegate", "Lkotlin/Lazy;", "fragmentManager", "Lcom/android/ttcjpaysdk/base/framework/manager/CJPayFragmentManager;", "host", "Lcom/android/ttcjpaysdk/integrated/sign/counter/activity/ISignCounterHost;", "loadingView", "Lcom/android/ttcjpaysdk/base/ui/widget/CJPayTextLoadingView;", "presenter", "Lcom/android/ttcjpaysdk/integrated/sign/counter/presenter/SignPresenter;", "sceneRootView", "closeAll", "", "getContext", "Landroid/content/Context;", "onBackPressed", "", WidgetCostModule.TYPE_ON_CREATE, "args", "Lcom/android/ttcjpaysdk/integrated/sign/counter/activity/SignCounterLaunchArgs;", LiveCommonConstants.REASON_ON_DEDTROY, "onEvent", "event", "Lcom/android/ttcjpaysdk/base/eventbus/BaseEvent;", "onNewIntent", "onNext", "onSignCreateFailed", "message", "", "onSignCreateSuccess", "response", "Lcom/android/ttcjpaysdk/integrated/sign/counter/data/SignCreateResponse;", "signCreate", "toConfirm", "integrated-sign-counter_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class IntegratedSignSceneHandler implements ISignCounterSceneHandler, SignView {
    private View activityRootView;
    private final Lazy confirmFragment$delegate;
    private CJPayFragmentManager fragmentManager;
    private ISignCounterHost host;
    private CJPayTextLoadingView loadingView;
    private SignPresenter presenter;
    private View sceneRootView;

    @Override // com.android.ttcjpaysdk.integrated.sign.counter.activity.ISignCounterSceneHandler
    public void onNewIntent(SignCounterLaunchArgs r100) {
        Intrinsics.checkNotNullParameter(r100, "args");
    }

    private final void closeAll() {
        CJPayFragmentManager r100 = this.fragmentManager;
        if (r100 == null) goto L5;
        r100.finishAllFragment(true);
    L5:
        ISignCounterHost r101 = this.host;
        if (r101 == null) goto L11;
        Activity r102 = r101.getActivity();
        if (r102 == null) goto L12;
        CJPayKotlinExtensionsKt.postDelaySafely(r102, new AnonymousClass1(this), 50);
        return;
    L12:
        return;
    }

    private final SignConfirmFragment getConfirmFragment() {
        return (SignConfirmFragment) this.confirmFragment$delegate.getValue();
    }

    private final void signCreate() {
        CJPayHostInfo r100 = IntegratedSignCounterProvider.hostInfo;
        boolean r101 = false;
        if (r100 != null) goto L5;
    L7:
        if (r101 == false) goto L11;
        CJPayTextLoadingView r102 = this.loadingView;
        if (r102 == null) goto L11;
        r102.show();
    L11:
        ISignCounterHost r103 = this.host;
        if (r103 == null) goto L14;
        r103.disablePageClick(true);
    L14:
        SignPresenter r104 = this.presenter;
        if (r104 == null) goto L18;
        r104.signCreate();
        return;
    L18:
        return;
    L5:
        if (r100.needLoading != true) goto L7;
        r101 = true;
        goto L7
    }

    private final void toConfirm() {
        CJPayFragmentManager r100 = this.fragmentManager;
        if (r100 == null) goto L6;
        r100.startFragment(getConfirmFragment(), 2, 2);
        return;
    }

    @Override // com.android.ttcjpaysdk.base.mvp.mvp.MvpView
    public Context getContext() {
        ISignCounterHost r100 = this.host;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getActivity();
    }

    @Override // com.android.ttcjpaysdk.integrated.sign.counter.activity.ISignCounterSceneHandler
    public boolean onBackPressed() {
        CJPayFragmentManager r100 = this.fragmentManager;
        if (r100 == null) goto L5;
        r100.onBackPressed();
    L5:
        CJPayFragmentManager r101 = this.fragmentManager;
        if (r101 == null) goto L8;
        int r102 = r101.size();
    L9:
        if (r102 != 0) goto L13;
        closeAll();
        return true;
    L13:
        return true;
    L8:
        r102 = 0;
        goto L9
    }

    @Override // com.android.ttcjpaysdk.integrated.sign.counter.activity.ISignCounterSceneHandler
    public void onDestroy() {
        CJPayFragmentManager r100 = this.fragmentManager;
        if (r100 == null) goto L5;
        r100.finishAllFragment(false);
    L5:
        IntegratedSignSceneState.INSTANCE.setSignCreateResponse(null);
        SignPresenter r101 = this.presenter;
        if (r101 == null) goto L8;
        r101.detachView();
    L8:
        this.presenter = null;
        this.fragmentManager = null;
        this.loadingView = null;
        this.activityRootView = null;
        this.sceneRootView = null;
        this.host = null;
    }

    public IntegratedSignSceneHandler() {
        this.confirmFragment$delegate = LazyKt.lazy(new IntegratedSignSceneHandler$confirmFragment$2(this));
    }

    @Override // com.android.ttcjpaysdk.integrated.sign.counter.activity.ISignCounterSceneHandler
    public void onNext() {
        signCreate();
    }

    public static final /* synthetic */ void access$closeAll(IntegratedSignSceneHandler r100) {
        r100.closeAll();
    }

    public static final /* synthetic */ ISignCounterHost access$getHost$p(IntegratedSignSceneHandler r100) {
        return r100.host;
    }

    @Override // com.android.ttcjpaysdk.integrated.sign.counter.activity.ISignCounterSceneHandler
    public void onEvent(BaseEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        if ((r100 instanceof CJPayFinishAllSingleFragmentActivityEvent) == false) goto L6;
        closeAll();
        return;
    }

    @Override // com.android.ttcjpaysdk.integrated.sign.counter.view.SignView
    public void onSignCreateFailed(String r100) {
        ISignCounterHost r101 = this.host;
        if (r101 == null) goto L8;
        Activity r102 = r101.getActivity();
        if (r102 == null) goto L9;
        CJPayBasicUtils.displayToastInternal(r102, r102.getResources().getString(R.string.cj_pay_network_error), 0);
        CJPayCallBackCenter.getInstance().setResultCode(109);
        CJPayActivityManager.INSTANCE.finishAll(r102);
        return;
    L9:
        return;
    }

    @Override // com.android.ttcjpaysdk.integrated.sign.counter.view.SignView
    public void onSignCreateSuccess(SignCreateResponse r100) {
        ISignCounterHost r101 = this.host;
        if (r101 == null) goto L6;
        r101.disablePageClick(false);
    L6:
        if (r100 != null) goto L8;
    L27:
        CJPayCallBackCenter.getInstance().setResultCode(105);
        ISignCounterHost r102 = this.host;
        if (r102 == null) goto L34;
        Activity r103 = r102.getActivity();
        if (r103 == null) goto L35;
        CJPayActivityManager.INSTANCE.finishAll(r103);
        Unit r104 = Unit.INSTANCE;
        return;
    L35:
        return;
    L34:
        return;
    L8:
        if (r100.isResponseOk() == false) goto L13;
        CJPayCallBackCenter.getInstance().setTraceId(r100.data.fe_metrics.optString(BindCardPayConfirmConstants.Key.TRACE_ID));
        IntegratedSignSceneState.INSTANCE.setSignCreateResponse(r100);
        CJPayTextLoadingView r105 = this.loadingView;
        if (r105 == null) goto L12;
        r105.hide();
    L12:
        CJPayAnimationUtils.bgColorTransition(this.activityRootView, true);
        toConfirm();
        Unit r106 = Unit.INSTANCE;
    L26:
        if (r106 == null) goto L27;
        return;
    L13:
        String r107 = r100.code;
        if (Intrinsics.areEqual(r107, "CA3100") == false) goto L17;
        CJPayCallBackCenter.getInstance().setResultCode(108);
    L20:
        ISignCounterHost r108 = this.host;
        if (r108 == null) goto L25;
        Activity r109 = r108.getActivity();
        if (r109 == null) goto L25;
        CJPayActivityManager.INSTANCE.finishAll(r109);
        r106 = Unit.INSTANCE;
    L25:
        r106 = null;
        goto L26
    L17:
        if (Intrinsics.areEqual(r107, "CA3001") == false) goto L19;
        CJPayCallBackCenter.getInstance().setCallBackInfo(MapsKt.hashMapOf(new Pair[]{new Pair(UnifyPreVerifyRiskSmsVM.KEY_TOAST_MSG, r100.error.msg)}));
        CJPayCallBackCenter.getInstance().setResultCode(105);
        goto L20
    L19:
        CJPayCallBackCenter.getInstance().setResultCode(105);
        goto L20
    }

    @Override // com.android.ttcjpaysdk.integrated.sign.counter.activity.ISignCounterSceneHandler
    public void onCreate(ISignCounterHost r100, SignCounterLaunchArgs r101) {
        Intrinsics.checkNotNullParameter(r100, "host");
        Intrinsics.checkNotNullParameter(r101, "args");
        this.host = r100;
        r100.getSceneContainer().removeAllViews();
        View r102 = LayoutInflater.from(r100.getActivity()).inflate(R.layout.cj_pay_activity_sign_counter_layout, r100.getSceneContainer(), true);
        this.sceneRootView = r102;
        CJPayTextLoadingView r103 = null;
        if (r102 == null) goto L5;
        View r104 = r102.findViewById(R.id.cj_pay_single_fragment_activity_root_view);
    L6:
        this.activityRootView = r104;
        View r105 = this.sceneRootView;
        if (r105 == null) goto L9;
        r103 = (CJPayTextLoadingView) r105.findViewById(R.id.cj_pay_loading_view);
    L9:
        this.loadingView = r103;
        Activity r106 = r100.getActivity();
        Intrinsics.checkNotNull(r106, "null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
        this.fragmentManager = new CJPayFragmentManager((FragmentActivity) r106, R.id.cj_pay_single_fragment_container);
        SignPresenter r107 = new SignPresenter();
        r107.attachView(new SignBaseModel(), this);
        this.presenter = r107;
        return;
    L5:
        r104 = null;
        goto L6
    }
}
