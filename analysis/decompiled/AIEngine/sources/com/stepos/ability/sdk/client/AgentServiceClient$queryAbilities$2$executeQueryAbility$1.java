package com.stepos.ability.sdk.client;

import com.stepos.ability.IAbilityQueryCallback;
import com.stepos.ability.bean.AbilityMetadataParcelable;
import com.stepos.ability.common.AbilityException;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.g;
import kotlinx.coroutines.CancellableContinuation;
import mb.m;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class AgentServiceClient$queryAbilities$2$executeQueryAbility$1 extends IAbilityQueryCallback.Stub {
    final /* synthetic */ CancellableContinuation<List<w5.a>> $cont;

    /* JADX WARN: Multi-variable type inference failed */
    public AgentServiceClient$queryAbilities$2$executeQueryAbility$1(CancellableContinuation<? super List<w5.a>> cancellableContinuation) {
        this.$cont = cancellableContinuation;
    }

    @Override // com.stepos.ability.IAbilityQueryCallback
    public void onComplete(boolean z, String str, List<AbilityMetadataParcelable> list) {
        if (this.$cont.isActive()) {
            v5.a aVar = v5.b.f13381a;
            ArrayList arrayList = null;
            if (!z) {
                String msg = "queryAbilities Query meta info failed. Msg: " + str;
                g.f(msg, "msg");
                aVar.a(6, "Ability_".concat("Ability_AgentServiceClient"), msg, null);
                this.$cont.resumeWith(kotlin.c.a(new AbilityException("[META_INFO_QUERY_FAILED] 元信息查询失败", null)));
                return;
            }
            String msg2 = "queryAbilities Query success: " + list;
            g.f(msg2, "msg");
            aVar.a(3, "Ability_".concat("Ability_AgentServiceClient"), msg2, null);
            CancellableContinuation<List<w5.a>> cancellableContinuation = this.$cont;
            if (list != null) {
                arrayList = new ArrayList(m.Z(list, 10));
                for (AbilityMetadataParcelable abilityMetadataParcelable : list) {
                    arrayList.add(new w5.a(abilityMetadataParcelable.getToolName(), abilityMetadataParcelable.getDescription(), abilityMetadataParcelable.getInputSchema(), abilityMetadataParcelable.getPackageName()));
                }
            }
            cancellableContinuation.resumeWith(arrayList);
        }
    }
}
