package com.zyql.ability.sdk.client;

import android.util.Log;
import com.zyql.ability.service.IAbilityQueryCallback;
import com.zyql.ability.service.model.AbilityMetadataParcelable;
import h7.C1491a;
import kotlin.Metadata;
import kotlin.jvm.internal.k;
import m9.InterfaceC1717j;

@Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\n\u0018\u00002\u00020\u0001J+\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"com/zyql/ability/sdk/client/AbilityInvoker$queryAbilityMetaData$2$executeQuery$1", "Lcom/zyql/ability/service/IAbilityQueryCallback$Stub;", "", "isSuccess", "", "errorMsg", "Lcom/zyql/ability/service/model/AbilityMetadataParcelable;", "result", "LC7/r;", "onComplete", "(ZLjava/lang/String;Lcom/zyql/ability/service/model/AbilityMetadataParcelable;)V", "sdk_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class AbilityInvoker$queryAbilityMetaData$2$executeQuery$1 extends IAbilityQueryCallback.Stub {
    final /* synthetic */ InterfaceC1717j $cont;

    public AbilityInvoker$queryAbilityMetaData$2$executeQuery$1(InterfaceC1717j interfaceC1717j) {
        this.$cont = interfaceC1717j;
    }

    @Override // com.zyql.ability.service.IAbilityQueryCallback
    public void onComplete(boolean isSuccess, String errorMsg, AbilityMetadataParcelable result) {
        if (this.$cont.isActive()) {
            if (isSuccess) {
                C1491a.a("AbilityInvoker", "Query success: " + result);
                this.$cont.resumeWith(result);
                return;
            }
            String msg = "Query failed: ".concat(errorMsg == null ? "Query ability metadata failed" : errorMsg);
            k.f(msg, "msg");
            Log.e("AbilityInvoker", msg, null);
            InterfaceC1717j interfaceC1717j = this.$cont;
            if (errorMsg == null) {
                errorMsg = "Query ability metadata failed";
            }
            interfaceC1717j.resumeWith(kotlin.b.a(new Exception(errorMsg)));
        }
    }
}
