package com.zyql.ability.sdk.client;

import C7.r;
import S7.k;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.zyql.ability.service.IAbilityExecuteCallback;
import h7.AbstractC1492b;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u001b\u0012\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002¢\u0006\u0004\b\u0006\u0010\u0007J-\u0010\f\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\n\u001a\u0004\u0018\u00010\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\bH\u0016¢\u0006\u0004\b\f\u0010\rJ7\u0010\u0010\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\b2\b\u0010\u000e\u001a\u0004\u0018\u00010\b2\b\u0010\u000f\u001a\u0004\u0018\u00010\bH\u0016¢\u0006\u0004\b\u0010\u0010\u0011R \u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0012¨\u0006\u0013"}, d2 = {"Lcom/zyql/ability/sdk/client/IAbilityCallbackProxy;", "Lcom/zyql/ability/service/IAbilityExecuteCallback$Stub;", "Lkotlin/Function1;", "Lg7/b;", "LC7/r;", "callback", AppAgent.CONSTRUCT, "(LS7/k;)V", "", "taskCode", "taskResult", "extra", "onSuccess", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "errCode", "errMsg", "onFailure", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "LS7/k;", "sdk_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class IAbilityCallbackProxy extends IAbilityExecuteCallback.Stub {
    private final k callback;

    public IAbilityCallbackProxy(k callback) {
        kotlin.jvm.internal.k.f(callback, "callback");
        this.callback = callback;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final r onFailure$lambda$0(IAbilityCallbackProxy iAbilityCallbackProxy, String str, String str2, String str3) {
        iAbilityCallbackProxy.callback.invoke(new g7.b(str, null, str2 == null ? "Unknown error" : str2, str3 == null ? "Unknown error" : str3, false));
        return r.f317a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final r onSuccess$lambda$0(IAbilityCallbackProxy iAbilityCallbackProxy, String str, String str2) {
        k kVar = iAbilityCallbackProxy.callback;
        if (str == null) {
            str = "";
        }
        kVar.invoke(new g7.b(str, str2, null, null, true));
        return r.f317a;
    }

    @Override // com.zyql.ability.service.IAbilityExecuteCallback
    public void onFailure(String taskCode, String extra, String errCode, String errMsg) {
        AbstractC1492b.a(new H4.b(this, extra, errCode, errMsg, 2));
    }

    @Override // com.zyql.ability.service.IAbilityExecuteCallback
    public void onSuccess(String taskCode, String taskResult, String extra) {
        AbstractC1492b.a(new androidx.compose.runtime.changelist.b(this, taskResult, extra, 3));
    }
}
