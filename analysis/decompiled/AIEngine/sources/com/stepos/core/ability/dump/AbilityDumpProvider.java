package com.stepos.core.ability.dump;

import b7.b;
import com.stepos.core.ability.AbilityManager;
import com.stepos.core.common.log.BaseDumpProvider;
import com.stepos.core.common.log.LogModule;
import com.stepos.core.ota.d;
import java.io.PrintWriter;
import kotlin.jvm.internal.g;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class AbilityDumpProvider extends BaseDumpProvider {
    public AbilityDumpProvider() {
        super("Ability", LogModule.ABILITY);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence dumpContent$lambda$4$lambda$3$lambda$2(b bVar, String mid) {
        String string;
        g.f(mid, "mid");
        if (bVar == null || (string = Integer.valueOf(bVar.getRefCount(mid)).toString()) == null) {
            string = "?";
        }
        return mid + "(ref=" + string + ")";
    }

    /* JADX WARN: Removed duplicated region for block: B:113:0x03d0  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x042a  */
    @Override // com.stepos.core.common.log.BaseDumpProvider
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void dumpContent(java.io.PrintWriter r33, java.lang.String[] r34) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 1926
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.core.ability.dump.AbilityDumpProvider.dumpContent(java.io.PrintWriter, java.lang.String[]):void");
    }

    @Override // com.stepos.core.common.log.BaseDumpProvider, com.stepos.core.common.log.IDumpProvider
    public void dumpStats(PrintWriter writer) {
        g.f(writer, "writer");
        AbilityManager abilityManager = AbilityManager.INSTANCE;
        writer.println(d.e(abilityManager.getAbilities().size(), "Ability: ", abilityManager.getActiveInstanceCount(), " registered, ", " active"));
    }

    @Override // com.stepos.core.common.log.BaseDumpProvider, com.stepos.core.common.log.IDumpProvider
    public String getHelp() {
        return "Ability: registered abilities, active DeepBinder instances, permission audit";
    }
}
