package com.stepos.ability.api.agentbus;

import H7.c;
import android.content.Context;
import com.stepos.ability.beaninternal.ability.AbilityMetaDataResult;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J2\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004H¦@¢\u0006\u0004\b\b\u0010\t¨\u0006\nÀ\u0006\u0003"}, d2 = {"Lcom/stepos/ability/api/agentbus/IAbilityCatalog;", "", "Landroid/content/Context;", "context", "", "", "appNames", "Lcom/stepos/ability/beaninternal/ability/AbilityMetaDataResult;", "listAbilities", "(Landroid/content/Context;Ljava/util/List;LH7/c;)Ljava/lang/Object;", "api_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public interface IAbilityCatalog {
    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ Object listAbilities$default(IAbilityCatalog iAbilityCatalog, Context context, List list, c cVar, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: listAbilities");
        }
        if ((i & 2) != 0) {
            list = null;
        }
        return iAbilityCatalog.listAbilities(context, list, cVar);
    }

    Object listAbilities(Context context, List<String> list, c<? super List<AbilityMetaDataResult>> cVar);
}
