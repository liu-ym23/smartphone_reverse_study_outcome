package com.android.ttcjpaysdk.thirdparty.front.counter.unifypay.preverify;

import android.content.Context;
import com.android.ttcjpaysdk.thirdparty.front.counter.unifypay.preverify.api.IUnifyPreVerifyListener;
import com.android.ttcjpaysdk.thirdparty.front.counter.unifypay.preverify.model.UnifyPreVerifyCommonParams;
import com.android.ttcjpaysdk.thirdparty.verify.base.VerifyBaseFragment;
import com.android.ttcjpaysdk.thirdparty.verify.base.VerifyStackManager;
import com.bytedance.ies.sdk.widgets.api.WidgetService;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0006\u0010\t\u001a\u00020\nJ\u0006\u0010\u000b\u001a\u00020\u0003J\u0006\u0010\f\u001a\u00020\rJ\u0006\u0010\u000e\u001a\u00020\u000fJ\u0006\u0010\u0010\u001a\u00020\u0007J\u0006\u0010\u0011\u001a\u00020\u0012J0\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\n2\u0006\u0010\u001a\u001a\u00020\n2\u0006\u0010\u001b\u001a\u00020\u0018R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/android/ttcjpaysdk/thirdparty/front/counter/unifypay/preverify/UnifyPreVerifyVMContext;", "", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "stack", "Lcom/android/ttcjpaysdk/thirdparty/verify/base/VerifyStackManager;", "preVerifyManager", "Lcom/android/ttcjpaysdk/thirdparty/front/counter/unifypay/preverify/CJUnifyPreVerifyManager;", "(Landroid/content/Context;Lcom/android/ttcjpaysdk/thirdparty/verify/base/VerifyStackManager;Lcom/android/ttcjpaysdk/thirdparty/front/counter/unifypay/preverify/CJUnifyPreVerifyManager;)V", "getContainerId", "", "getContext", "getPreVerifyGetParams", "Lcom/android/ttcjpaysdk/thirdparty/front/counter/unifypay/preverify/CJUnifyPreVerifyManager$IUnifyPreVerifyGetParams;", "getPreVerifyListener", "Lcom/android/ttcjpaysdk/thirdparty/front/counter/unifypay/preverify/api/IUnifyPreVerifyListener;", "getPreVerifyManager", "getVerifyParams", "Lcom/android/ttcjpaysdk/thirdparty/front/counter/unifypay/preverify/model/UnifyPreVerifyCommonParams;", "startFragment", "", WidgetService.PARAM_FRAGMENT, "Lcom/android/ttcjpaysdk/thirdparty/verify/base/VerifyBaseFragment;", "isNeedAnimation", "", "inAnim", "outAnim", "hasMask", "bdpay-front-counter_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class UnifyPreVerifyVMContext {
    private final Context context;
    private final CJUnifyPreVerifyManager preVerifyManager;
    private VerifyStackManager stack;

    public final int getContainerId() {
        return this.stack.getContainerId();
    }

    public final CJUnifyPreVerifyManager.IUnifyPreVerifyGetParams getPreVerifyGetParams() {
        return this.preVerifyManager.getPreVerifyGetParams();
    }

    public final IUnifyPreVerifyListener getPreVerifyListener() {
        return this.preVerifyManager.getPreVerifyListener();
    }

    public final UnifyPreVerifyCommonParams getVerifyParams() {
        return this.preVerifyManager.getVerifyCommonParams();
    }

    public final Context getContext() {
        return this.context;
    }

    public final CJUnifyPreVerifyManager getPreVerifyManager() {
        return this.preVerifyManager;
    }

    public UnifyPreVerifyVMContext(Context r100, VerifyStackManager r101, CJUnifyPreVerifyManager r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "stack");
        Intrinsics.checkNotNullParameter(r102, "preVerifyManager");
        this.context = r100;
        this.stack = r101;
        this.preVerifyManager = r102;
    }

    public final void startFragment(VerifyBaseFragment r100, boolean r101, int r102, int r110, boolean r111) {
        this.stack.startFragment(r100, r101, r102, r110, r111);
    }
}
