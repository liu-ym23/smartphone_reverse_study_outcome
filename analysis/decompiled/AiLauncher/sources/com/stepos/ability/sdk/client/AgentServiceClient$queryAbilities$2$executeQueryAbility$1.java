package com.stepos.ability.sdk.client;

import U3.a;
import Ua.InterfaceC1066l;
import Y3.AbilityMetaDataInfo;
import com.stepos.ability.IAbilityQueryCallback;
import com.stepos.ability.bean.AbilityMetadataParcelable;
import com.stepos.ability.common.AbilityException;
import com.stepos.ailauncher.chat.voice.support.C3081a;
import java.util.List;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.Result;

@Metadata(d1 = {"\u0000$\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\n\u0018\u00002\u00020\u0001J1\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006H\u0016¢\u0006\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"com/stepos/ability/sdk/client/AgentServiceClient$queryAbilities$2$executeQueryAbility$1", "Lcom/stepos/ability/IAbilityQueryCallback$Stub;", "", "isSuccess", "", C3081a.ERROR_MSG, "", "Lcom/stepos/ability/bean/AbilityMetadataParcelable;", "result", "LY8/t;", "onComplete", "(ZLjava/lang/String;Ljava/util/List;)V", "sdk_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class AgentServiceClient$queryAbilities$2$executeQueryAbility$1 extends IAbilityQueryCallback.Stub {
    final /* synthetic */ InterfaceC1066l<List<AbilityMetaDataInfo>> $cont;

    /* JADX WARN: Multi-variable type inference failed */
    public AgentServiceClient$queryAbilities$2$executeQueryAbility$1(InterfaceC1066l<? super List<AbilityMetaDataInfo>> interfaceC1066l) {
        this.$cont = interfaceC1066l;
    }

    @Override // com.stepos.ability.IAbilityQueryCallback
    public void onComplete(boolean isSuccess, String errorMsg, List<AbilityMetadataParcelable> result) {
        if (this.$cont.b()) {
            if (isSuccess) {
                V3.b.c(V3.b.f6474a, "Ability_AgentServiceClient", "queryAbilities Query success: " + result, null, 4, null);
                InterfaceC1066l<List<AbilityMetaDataInfo>> interfaceC1066l = this.$cont;
                Result.Companion companion = Result.INSTANCE;
                interfaceC1066l.resumeWith(Result.b(result != null ? Y3.a.a(result) : null));
                return;
            }
            a.AbstractC0107a.C0108a c0108a = a.AbstractC0107a.C0108a.f6290d;
            V3.b.e(V3.b.f6474a, "Ability_AgentServiceClient", "queryAbilities Query meta info failed. Msg: " + errorMsg, null, 4, null);
            InterfaceC1066l<List<AbilityMetaDataInfo>> interfaceC1066l2 = this.$cont;
            Result.Companion companion2 = Result.INSTANCE;
            interfaceC1066l2.resumeWith(Result.b(C4849c.a(new AbilityException(c0108a, null, null, 6, null))));
        }
    }
}
