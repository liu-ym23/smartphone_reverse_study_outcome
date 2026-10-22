package com.bytedance.android.annie.bridge.method;

import com.bytedance.android.annie.Annie;
import com.bytedance.android.annie.bridge.method.abs.ShowLoadingResultModel;
import com.bytedance.ies.sdk.widgets.api.WidgetService;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.ss.android.dypay.api.DyPayConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
@XBridgeMethod(biz = "webcast_sdk", name = DyPayConstant.KEY_SHOW_LOADING)
@Metadata(d1 = {"\u0000.\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0013\b\u0016\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\u0011\u0010\u0010B\u0011\b\u0016\u0012\u0006\u0010\u0013\u001a\u00020\u0012¢\u0006\u0004\b\u0011\u0010\u0014J\u0019\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0094\u0002J\b\u0010\t\u001a\u00020\u0007H\u0014R$\u0010\u000b\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u0015"}, d2 = {"com/bytedance/android/annie/bridge/method/LoadingMethods$ShowLoadingMethod", "Le7/b0;", "Le7/x0;", "Lcom/bytedance/android/annie/bridge/method/abs/ShowLoadingResultModel;", "params", "Lcom/bytedance/ies/web/jsbridge2/CallContext;", PerfLog.PARAM_KEY_CONTEXT_ID, "", AbsMethodDelegate.TAG_INVOKE, "onTerminate", "Lcom/bytedance/android/annie/container/fragment/q;", WidgetService.PARAM_FRAGMENT, "Lcom/bytedance/android/annie/container/fragment/q;", "getFragment", "()Lcom/bytedance/android/annie/container/fragment/q;", "setFragment", "(Lcom/bytedance/android/annie/container/fragment/q;)V", "<init>", "Lm16/b;", "providerFactory", "(Lm16/b;)V", "annie_release"}, k = 1, mv = {1, 4, 3})
public final class LoadingMethods$ShowLoadingMethod extends e7.b0<e7.x0, ShowLoadingResultModel> {
    private com.bytedance.android.annie.container.fragment.q fragment;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LoadingMethods$ShowLoadingMethod f38465a;

        public final void a() {
            ShowLoadingResultModel r100 = new ShowLoadingResultModel();
            r100.a(ShowLoadingResultModel.Code.Success);
            r100.b("SUCCESS");
            LoadingMethods$ShowLoadingMethod.access$finishWithResult(this.f38465a, r100);
        }

        public a(LoadingMethods$ShowLoadingMethod r100) {
            this.f38465a = r100;
        }
    }

    @Override // e7.b0, com.bytedance.ies.web.jsbridge2.f
    public void onTerminate() {
    }

    public final com.bytedance.android.annie.container.fragment.q getFragment() {
        return this.fragment;
    }

    public LoadingMethods$ShowLoadingMethod(m16.b r100) {
        Intrinsics.checkNotNullParameter(r100, "providerFactory");
        com.bytedance.android.annie.container.fragment.q r101 = (com.bytedance.android.annie.container.fragment.q) r100.c(com.bytedance.android.annie.container.fragment.q.class);
        if (r101 == null) goto L6;
        this.fragment = r101;
        return;
    }

    public final void setFragment(com.bytedance.android.annie.container.fragment.q r100) {
        this.fragment = r100;
    }

    public LoadingMethods$ShowLoadingMethod(com.bytedance.android.annie.container.fragment.q r100) {
        this.fragment = r100;
    }

    public static final /* synthetic */ void access$finishWithResult(LoadingMethods$ShowLoadingMethod r100, ShowLoadingResultModel r101) {
        r100.finishWithResult(r101);
    }

    public void invoke(e7.x0 r100, CallContext r101) {
        Intrinsics.checkNotNullParameter(r100, "params");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        com.bytedance.android.annie.container.fragment.q r102 = this.fragment;
        if (r102 == null) goto L5;
        v7.b r103 = r102.getLoadingFragment();
    L6:
        ((a9.h) Annie.getService$default(a9.h.class, null, 2, null)).C(r101.getContext(), r103, r100, new a(this));
        return;
    L5:
        r103 = null;
        goto L6
    }

    @Override // com.bytedance.ies.web.jsbridge2.f
    public /* bridge */ /* synthetic */ void invoke(Object r100, CallContext r101) {
        invoke((e7.x0) r100, r101);
    }
}
