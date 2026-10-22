package com.stepos.ability.database.repository;

import P3.c;
import S3.a;
import android.content.Context;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.stepos.ability.api.init.IInit;
import com.stepos.ability.database.AppDatabase;
import com.stepos.ability.database.dao.AbilityDao;
import com.stepos.ability.database.dao.AbilityReportDao;
import com.stepos.ability.database.dao.AbilityTaskDao;
import com.stepos.ability.database.dao.AtomicAbilityDao;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/stepos/ability/database/repository/RepositoryInit;", "Lcom/stepos/ability/api/init/IInit;", AppAgent.CONSTRUCT, "()V", "Landroid/content/Context;", "context", "LC7/r;", "init", "(Landroid/content/Context;)V", "database_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class RepositoryInit implements IInit {
    @Inject
    public RepositoryInit() {
    }

    @Override // com.stepos.ability.api.init.IInit
    public void init(Context context) {
        k.f(context, "context");
        AppDatabase appDatabaseB = AppDatabase.Companion.b(context);
        AbilityDao abilityDao = appDatabaseB.abilityDao();
        k.f(abilityDao, "<set-?>");
        a.b = abilityDao;
        AbilityTaskDao abilityTaskDao = appDatabaseB.abilityTaskDao();
        k.f(abilityTaskDao, "<set-?>");
        a.c = abilityTaskDao;
        AbilityReportDao abilityReportDao = appDatabaseB.abilityReportDao();
        k.f(abilityReportDao, "<set-?>");
        a.d = abilityReportDao;
        AtomicAbilityDao atomicAbilityDao = appDatabaseB.atomicAbilityDao();
        k.f(atomicAbilityDao, "<set-?>");
        a.e = atomicAbilityDao;
        String tag = a.f1173a.getTAG();
        k.f(tag, "tag");
        c.f1086a.invoke(3, "Ability_".concat(tag), "init: database ready", null);
    }
}
