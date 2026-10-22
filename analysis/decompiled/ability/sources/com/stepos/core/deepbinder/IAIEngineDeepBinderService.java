package com.stepos.core.deepbinder;

import androidx.autofill.HintConstants;
import com.stepos.core.ability.AbilityInfo;
import com.stepos.deepbinder.annotation.type.AutoRecover;
import com.stepos.deepbinder.annotation.type.ServiceName;
import com.stepos.deepbinder.annotation.type.ValidityCheck;
import e5.InterfaceC1423a;
import java.util.List;
import kotlin.Metadata;

@AutoRecover
@ServiceName("com.stepos.core.ability.deepbinder.AIEngineDeepBinderServiceImpl")
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0015\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H&¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H&¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u0006H&¢\u0006\u0004\b\f\u0010\rJ!\u0010\u000f\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u0006H&¢\u0006\u0004\b\u000f\u0010\u0010J\u0019\u0010\u0011\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0007\u001a\u00020\u0006H&¢\u0006\u0004\b\u0011\u0010\u0012J'\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u0006H&¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0017\u001a\u00020\u0016H&¢\u0006\u0004\b\u0019\u0010\u001a¨\u0006\u001b"}, d2 = {"Lcom/stepos/core/deepbinder/IAIEngineDeepBinderService;", "", "", "Lcom/stepos/core/ability/AbilityInfo;", "getAbilities", "()Ljava/util/List;", "", "id", "", "containsAbility", "(Ljava/lang/String;)Z", "", "getAbilityState", "(Ljava/lang/String;)I", HintConstants.AUTOFILL_HINT_NAME, "getAbilityProperty", "(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", "checkModelReady", "(Ljava/lang/String;)Ljava/lang/Boolean;", "value", "setAbilityProperty", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Z", "Le5/a;", "callback", "LC7/r;", "showCTADialog", "(Le5/a;)V", "shared-lib_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
@ValidityCheck
/* loaded from: classes3.dex */
public interface IAIEngineDeepBinderService {
    Boolean checkModelReady(String id);

    boolean containsAbility(String id);

    List<AbilityInfo> getAbilities();

    String getAbilityProperty(String id, String name);

    int getAbilityState(String id);

    boolean setAbilityProperty(String id, String name, String value);

    void showCTADialog(InterfaceC1423a callback);
}
